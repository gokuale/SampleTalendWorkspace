package org.talend.designer.codegen.translators.mapreduce.input;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class THDFSStreamInputFormatSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized THDFSStreamInputFormatSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSStreamInputFormatSparkstreamingcodeJava result = new THDFSStreamInputFormatSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        " + NL + "        public static class ";
  protected final String TEXT_2 = "Filter extends scala.runtime.AbstractFunction1<org.apache.hadoop.fs.Path,Object> {" + NL + "        \t\tpublic Object call(org.apache.hadoop.fs.Path path) {" + NL + "        \t\t\treturn true;" + NL + "        \t\t}" + NL + "        \t\t" + NL + "        \t\tpublic Object apply(Path path) {" + NL + "\t\t\t\t\treturn call(path);" + NL + "\t\t\t\t}" + NL + "        }" + NL + "" + NL + "        // read the input format line by line" + NL + "        public static class ";
  protected final String TEXT_3 = "StructInputFormat extends org.apache.hadoop.mapreduce.lib.input.FileInputFormat<NullWritable, ";
  protected final String TEXT_4 = "> implements org.apache.hadoop.conf.Configurable {" + NL + "            private ContextProperties context;" + NL + "            private int skipLines = 0;" + NL + "" + NL + "            public Configuration getConf() {" + NL + "            \t// Not used." + NL + "            \treturn null;" + NL + "            }" + NL + "" + NL + "             //init" + NL + "            public void setConf(Configuration conf){" + NL + "                context = new ContextProperties(conf);" + NL + "            }" + NL + "" + NL + "            @Override" + NL + "\t\t\tpublic org.apache.hadoop.mapreduce.RecordReader<NullWritable, ";
  protected final String TEXT_5 = "> createRecordReader(" + NL + "\t\t\t\t\torg.apache.hadoop.mapreduce.InputSplit split," + NL + "\t\t\t\t\torg.apache.hadoop.mapreduce.TaskAttemptContext taskContext) throws IOException," + NL + "\t\t\t\t\tInterruptedException {" + NL + "\t\t\t\treturn new HDFSRecordReader(context);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic List<org.apache.hadoop.mapreduce.InputSplit> getSplits(" + NL + "\t\t\t\t\torg.apache.hadoop.mapreduce.JobContext job) throws IOException {" + NL + "\t\t\t\tlong minSize = Math.max(getFormatMinSplitSize()," + NL + "\t\t\t\t\t\tgetMinSplitSize(job));" + NL + "\t\t\t\tlong maxSize = getMaxSplitSize(job);" + NL + "\t\t\t\t";
  protected final String TEXT_6 = NL + "                    this.skipLines = ";
  protected final String TEXT_7 = ";";
  protected final String TEXT_8 = NL + NL + "\t\t\t\t// generate splits" + NL + "\t\t\t\tList<org.apache.hadoop.mapreduce.InputSplit> splits = new ArrayList<org.apache.hadoop.mapreduce.InputSplit>();" + NL + "\t\t\t\tList<org.apache.hadoop.fs.FileStatus> files = listStatus(job);" + NL + "\t\t\t\tfor (org.apache.hadoop.fs.FileStatus file : files) {" + NL + "\t\t\t\t\tPath path = file.getPath();" + NL + "\t\t\t\t\tFileSystem fs = path.getFileSystem(job.getConfiguration());" + NL + "\t\t\t\t\tlong length = file.getLen();" + NL + "\t\t\t\t\tlong skipLength = 0;" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tskipLength = this.skipLines > 0 ? caculateSkipLength(file, job)" + NL + "\t\t\t\t\t\t\t\t: 0;" + NL + "\t\t\t\t\t} catch (InterruptedException e) {" + NL + "\t\t\t\t\t\t// TODO Auto-generated catch block" + NL + "\t\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\torg.apache.hadoop.fs.BlockLocation[] blkLocations = fs" + NL + "\t\t\t\t\t\t\t.getFileBlockLocations(file, 0, length);" + NL + "\t\t\t\t\tif ((length != 0) && isSplitable(job, path)) {" + NL + "\t\t\t\t\t\tlong blockSize = file.getBlockSize();" + NL + "\t\t\t\t\t\tlong splitSize = computeSplitSize(blockSize, minSize," + NL + "\t\t\t\t\t\t\t\tmaxSize);" + NL + "" + NL + "\t\t\t\t\t\tlong bytesRemaining = length - skipLength;" + NL + "\t\t\t\t\t\twhile (((double) bytesRemaining) / splitSize > 1.1) {" + NL + "\t\t\t\t\t\t\tint blkIndex = getBlockIndex(blkLocations, length" + NL + "\t\t\t\t\t\t\t\t\t- bytesRemaining);" + NL + "\t\t\t\t\t\t\tsplits.add(new org.apache.hadoop.mapreduce.lib.input.FileSplit(path, length - bytesRemaining," + NL + "\t\t\t\t\t\t\t\t\tsplitSize, blkLocations[blkIndex].getHosts()));" + NL + "\t\t\t\t\t\t\tbytesRemaining -= splitSize;" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\tif (bytesRemaining != 0) {" + NL + "\t\t\t\t\t\t\tsplits.add(new org.apache.hadoop.mapreduce.lib.input.FileSplit(path, length - bytesRemaining," + NL + "\t\t\t\t\t\t\t\t\tbytesRemaining," + NL + "\t\t\t\t\t\t\t\t\tblkLocations[blkLocations.length - 1]" + NL + "\t\t\t\t\t\t\t\t\t\t\t.getHosts()));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} else if (length != 0) {" + NL + "\t\t\t\t\t\tsplits.add(new org.apache.hadoop.mapreduce.lib.input.FileSplit(path, skipLength, length - skipLength, blkLocations[0]" + NL + "\t\t\t\t\t\t\t\t.getHosts()));" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t// Create empty hosts array for zero length files" + NL + "\t\t\t\t\t\tsplits.add(new org.apache.hadoop.mapreduce.lib.input.FileSplit(path, 0, length, new String[0]));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\t// Save the number of input files in the job-conf" + NL + "\t\t\t\tjob.getConfiguration().setLong(NUM_INPUT_FILES, files.size());" + NL + "" + NL + "\t\t\t\treturn splits;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprivate long caculateSkipLength(org.apache.hadoop.fs.FileStatus file, org.apache.hadoop.mapreduce.JobContext job) throws IOException, InterruptedException {" + NL + "\t\t\t\torg.apache.hadoop.mapreduce.lib.input.FileSplit split = new org.apache.hadoop.mapreduce.lib.input.FileSplit(file.getPath(), 0, file.getLen(),new String[0]);" + NL + "\t\t\t\tHDFSRecordReader reader = new HDFSRecordReader(split, job.getConfiguration());" + NL + "\t\t\t\tText text = new Text();" + NL + "\t\t\t\tfor (int i = 0; i < this.skipLines; i++) {" + NL + "\t\t\t\t\treader.next(text);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn reader.getPos();" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprotected static class HDFSRecordReader" + NL + "\t\t\t\textends" + NL + "\t\t\t\torg.apache.hadoop.mapreduce.RecordReader<NullWritable, ";
  protected final String TEXT_9 = "> {" + NL + "" + NL + "\t\t\t\tprivate ContextProperties context;" + NL + "\t\t\t\tprivate CompressionCodecFactory compressionCodecs = null;" + NL + "\t\t\t\tprivate long start;" + NL + "\t\t\t\tprivate long pos;" + NL + "\t\t\t\tprivate long end;" + NL + "\t\t\t\tprivate org.talend.hadoop.mapred.lib.file.TDelimitedFileLineReader in;" + NL + "\t\t\t\tprivate int maxLineLength;" + NL + "\t\t\t\tprivate NullWritable key = null;" + NL + "\t\t\t\tprivate ";
  protected final String TEXT_10 = " value = null;" + NL + "" + NL + "\t\t\t\tpublic HDFSRecordReader(ContextProperties context) {" + NL + "\t\t\t\t\tsuper();" + NL + "\t\t\t\t\tthis.context = context;" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic HDFSRecordReader(org.apache.hadoop.mapreduce.InputSplit genericSplit, Configuration job) throws IOException {" + NL + "\t\t\t\t\tsuper();" + NL + "\t\t\t\t\tthis.context = new ContextProperties(job);" + NL + "\t\t\t\t\tinit(genericSplit, job);" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\t@Override" + NL + "\t\t\t\tpublic void close() throws IOException {" + NL + "\t\t\t\t\tif (in != null) {" + NL + "\t\t\t\t\t\tin.close();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\t@Override" + NL + "\t\t\t\tpublic NullWritable getCurrentKey() throws IOException," + NL + "\t\t\t\t\t\tInterruptedException {" + NL + "\t\t\t\t\treturn key;" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\t@Override" + NL + "\t\t\t\tpublic ";
  protected final String TEXT_11 = " getCurrentValue()" + NL + "\t\t\t\t\t\tthrows IOException, InterruptedException {" + NL + "\t\t\t\t\treturn value;" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\t@Override" + NL + "\t\t\t\tpublic float getProgress() throws IOException, InterruptedException {" + NL + "\t\t\t\t\tif (start == end) {" + NL + "\t\t\t\t\t\treturn 0.0f;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\treturn Math" + NL + "\t\t\t\t\t\t\t\t.min(1.0f, (pos - start) / (float) (end - start));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tprivate void init(org.apache.hadoop.mapreduce.InputSplit genericSplit, Configuration job) throws IOException {" + NL + "\t\t\t\t\torg.apache.hadoop.mapreduce.lib.input.FileSplit split = (org.apache.hadoop.mapreduce.lib.input.FileSplit) genericSplit;" + NL + "\t\t\t\t\tthis.maxLineLength = job.getInt(" + NL + "\t\t\t\t\t\t\t\"mapred.linerecordreader.maxlength\", Integer.MAX_VALUE);" + NL + "\t\t\t\t\tstart = split.getStart();" + NL + "\t\t\t\t\tend = start + split.getLength();" + NL + "\t\t\t\t\tfinal Path file = split.getPath();" + NL + "\t\t\t\t\tcompressionCodecs = new CompressionCodecFactory(job);" + NL + "\t\t\t\t\tfinal CompressionCodec codec = compressionCodecs.getCodec(file);" + NL + "" + NL + "\t\t\t\t\t// open the file and seek to the start of the split" + NL + "\t\t\t\t\tFileSystem fs = file.getFileSystem(job);" + NL + "\t\t\t\t\tFSDataInputStream fileIn = fs.open(split.getPath());" + NL + "\t\t\t\t\tboolean skipFirstLine = false;" + NL + "\t\t\t\t\tif (codec != null) {" + NL + "\t\t\t\t\t\tin = new org.talend.hadoop.mapred.lib.file.TDelimitedFileLineReader(" + NL + "\t\t\t\t\t\t\t\tcodec.createInputStream(fileIn)," + NL + "\t\t\t\t\t\t\t\torg.talend.hadoop.mapred.lib.file.TDelimitedFileLineReader.DEFAULT_BUFFER_SIZE," + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_12 = ".getBytes(";
  protected final String TEXT_13 = "));" + NL + "\t\t\t\t\t\tend = Long.MAX_VALUE;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tif (start != 0) {" + NL + "\t\t\t\t\t\t\tskipFirstLine = true;" + NL + "\t\t\t\t\t\t\t--start;" + NL + "\t\t\t\t\t\t\tfileIn.seek(start);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tin = new org.talend.hadoop.mapred.lib.file.TDelimitedFileLineReader(" + NL + "\t\t\t\t\t\t\t\tfileIn," + NL + "\t\t\t\t\t\t\t\torg.talend.hadoop.mapred.lib.file.TDelimitedFileLineReader.DEFAULT_BUFFER_SIZE," + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_14 = ".getBytes(";
  protected final String TEXT_15 = "));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (skipFirstLine) { // skip first line and re-establish" + NL + "\t\t\t\t\t\t\t\t\t\t\t// \"start\"." + NL + "\t\t\t\t\t\tstart += in.readLine(" + NL + "\t\t\t\t\t\t\t\tnew Text()," + NL + "\t\t\t\t\t\t\t\t0," + NL + "\t\t\t\t\t\t\t\t(int) Math.min((long) Integer.MAX_VALUE, end" + NL + "\t\t\t\t\t\t\t\t\t\t- start));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tthis.pos = start;" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\t@Override" + NL + "\t\t\t\tpublic void initialize(" + NL + "\t\t\t\t\t\torg.apache.hadoop.mapreduce.InputSplit genericSplit," + NL + "\t\t\t\t\t\torg.apache.hadoop.mapreduce.TaskAttemptContext taskContext) throws IOException," + NL + "\t\t\t\t\t\tInterruptedException {" + NL + "\t\t\t\t\tConfiguration job = taskContext.getConfiguration();" + NL + "\t\t\t\t\tinit(genericSplit, job);" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\t@Override" + NL + "\t\t\t\tpublic boolean nextKeyValue() throws IOException," + NL + "\t\t\t\t\t\tInterruptedException {" + NL + "" + NL + "\t\t\t\t\tkey = NullWritable.get();" + NL + "\t\t\t\t\tvalue = new ";
  protected final String TEXT_16 = "();" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_17 = NL + "                        Text textValue = new Text();" + NL + "                        boolean hasNext = next(textValue);" + NL + "                        while (hasNext && textValue.getLength() == 0) {" + NL + "                            hasNext =  next(textValue);" + NL + "                        }" + NL + "                        value.";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = ";" + NL + "                        return hasNext;";
  protected final String TEXT_20 = NL + "                        Text textValue = new Text();" + NL + "                        boolean hasNext = next(textValue);" + NL + "\t\t\t\t\t\tvalue.";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = ";" + NL + "                        return hasNext;";
  protected final String TEXT_23 = NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic long getPos() throws IOException {" + NL + "\t\t\t\t\treturn pos;" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic boolean next(Text value) throws IOException {" + NL + "\t\t\t\t\twhile (pos < end) {" + NL + "\t\t\t\t\t\tint newSize = in.readLine(value, maxLineLength," + NL + "\t\t\t\t\t\t\t\tMath.max((int) Math.min(Integer.MAX_VALUE, end - pos)," + NL + "\t\t\t\t\t\t\t\t\t\tmaxLineLength));" + NL + "\t\t\t\t\t\tif (newSize == 0) {" + NL + "\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tpos += newSize;" + NL + "\t\t\t\t\t\tif (newSize < maxLineLength) {" + NL + "\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "        }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String folder = ElementParameterParser.getValue(node,"__FILENAME__");
String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");
boolean customEncoding = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_ENCODING__"));
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
String skipLines = ElementParameterParser.getValue(node,"__HEADER__");
boolean skipEmptyLines = "true".equals(ElementParameterParser.getValue(node,"__REMOVE_EMPTY_ROW__"));
boolean csvMode = "true".equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"));
if (csvMode) {
    rowSeparator = ElementParameterParser.getValue(node, "__CSVROWSEPARATOR__");
}

List<IMetadataTable> metadatas = node.getMetadataList();
List< ? extends IConnection> connections = node.getOutgoingConnections();
if ((connections != null) && (connections.size() > 0) && (metadatas!=null) && (metadatas.size() > 0)){
    IConnection connection = connections.get(0);
    String connectionName = connection.getName();
    String connectionTypeName = codeGenArgument.getRecordStructName(connection);

    List<IMetadataColumn> columns = metadatas.get(0).getListColumns();
    if ((connection.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) && (columns != null) && (columns.size() > 0)) {
        IMetadataColumn column = columns.get(0);
        String columnName = column.getLabel();
        
    stringBuffer.append(TEXT_1);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_5);
    
				if (skipLines != null && !skipLines.isEmpty()) {
                    
    stringBuffer.append(TEXT_6);
    stringBuffer.append(skipLines);
    stringBuffer.append(TEXT_7);
    
                }
				
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_16);
    
					if (skipEmptyLines) {
                        
    stringBuffer.append(TEXT_17);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(customEncoding?"new String(textValue.getBytes(), " + encoding + ")":"textValue.toString()" );
    stringBuffer.append(TEXT_19);
    
                    } else {
                        
    stringBuffer.append(TEXT_20);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(customEncoding?"new String(textValue.getBytes(), " + encoding + ")":"textValue.toString()" );
    stringBuffer.append(TEXT_22);
    
                    }
                    
    stringBuffer.append(TEXT_23);
    
    }
}

    return stringBuffer.toString();
  }
}
