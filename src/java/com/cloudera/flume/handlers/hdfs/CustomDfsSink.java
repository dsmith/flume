/**
 * Licensed to Cloudera, Inc. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Cloudera, Inc. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cloudera.flume.handlers.hdfs;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import org.apache.hadoop.io.compress.Compressor;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.log4j.Logger;

import com.cloudera.flume.conf.Context;
import com.cloudera.flume.conf.FlumeConfiguration;
import com.cloudera.flume.conf.FlumeSpecException;
import com.cloudera.flume.conf.SinkFactory.SinkBuilder;
import com.cloudera.flume.core.Event;
import com.cloudera.flume.core.EventSink;
import com.cloudera.flume.handlers.text.FormatFactory;
import com.cloudera.flume.handlers.text.output.OutputFormat;
import com.cloudera.flume.reporter.ReportEvent;
import com.google.common.base.Preconditions;

/**
 * This creates a raw hadoop dfs file that outputs data formatted by the
 * provided OutputFormat. It is assumed that the output is a file of some sort.
 */
public class CustomDfsSink extends EventSink.Base {
  final static Logger LOG = Logger.getLogger(CustomDfsSink.class.getName());

  private static final String A_OUTPUTFORMAT = "recordformat";
  private static final String GZIP_EXTENSION = ".gz";

  boolean compressOutput;
  OutputFormat format;
  FSDataOutputStream writer;
  AtomicLong count = new AtomicLong();
  String path;
  Path dstPath;  
  CompressionOutputStream gzOStm;


  public CustomDfsSink(String path, OutputFormat format) {
    Preconditions.checkArgument(path != null);
    Preconditions.checkArgument(format != null);
    this.path = path;
    this.format = format;
    this.writer = null;
  }

  @Override
  public void append(Event e) throws IOException {
    if (writer == null) {
      throw new IOException("Append failed, did you open the writer?");
    }
    if (compressOutput) {
      format.format(gzOStm, e);

    } else {    
      format.format(writer, e);
    }
    count.getAndIncrement();
    super.append(e);
  }

  @Override
  public void close() throws IOException {
    LOG.info("Closing HDFS file: " + dstPath);
    if (compressOutput) {
      gzOStm.flush();
      gzOStm.close();
      LOG.info("done writing compressed file to hdfs");   
      gzOStm = null;      
    } else {
      LOG.info("done writing raw file to hdfs");
    }
    writer.close();
    writer = null;
    
    
  }

  @Override
  public void open() throws IOException {
    FlumeConfiguration conf = FlumeConfiguration.get();
    FileSystem hdfs;
    
    if (!conf.getCollectorDfsCompressGzipStatus()) { //compression disabled
      dstPath = new Path(path);
      hdfs = dstPath.getFileSystem(conf);
      writer = hdfs.create(dstPath);
      compressOutput = false;
    } else { //compression enabled
      compressOutput = true;
      CompressionCodec gzipC = new GzipCodec();
      Compressor gzCmp = gzipC.createCompressor();      
      dstPath = new Path(path + GZIP_EXTENSION);
      hdfs = dstPath.getFileSystem(conf);
      writer = hdfs.create(dstPath);
      gzOStm = gzipC.createOutputStream(writer, gzCmp);


    }
    LOG.info("Opening HDFS file: " + dstPath.toString());
  }

  public static SinkBuilder builder() {
    return new SinkBuilder() {
      @Override
      public EventSink build(Context context, String... args) {
        if (args.length != 2 && args.length != 1) {
          // TODO (jon) make this message easier.
          throw new IllegalArgumentException(
              "usage: customdfs(\"[(hdfs|file|s3n|...)://namenode[:port]]/path\", \"format\")");
        }

        String format = (args.length == 1) ? null : args[1];
        OutputFormat fmt;
        try {
          fmt = FormatFactory.get().getOutputFormat(format);
        } catch (FlumeSpecException e) {
          LOG.error("failed to load format " + format, e);
          throw new IllegalArgumentException("failed to load format " + format);
        }
        return new CustomDfsSink(args[0], fmt);
      }
    };
  }

  @Override
  public String getName() {
    return "CustomDfs";
  }

  @Override
  public ReportEvent getReport() {
    ReportEvent rpt = super.getReport();
    rpt.setStringMetric(A_OUTPUTFORMAT, format.getFormatName());
    rpt.setLongMetric(ReportEvent.A_COUNT, count.get());
    return rpt;
  }
}
