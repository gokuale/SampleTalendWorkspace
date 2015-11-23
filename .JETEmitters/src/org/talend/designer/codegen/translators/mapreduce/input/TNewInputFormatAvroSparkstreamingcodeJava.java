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

public class TNewInputFormatAvroSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TNewInputFormatAvroSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNewInputFormatAvroSparkstreamingcodeJava result = new TNewInputFormatAvroSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "public static class ";
  protected final String TEXT_3 = "StructInputFormat" + NL + "        extends org.apache.hadoop.mapreduce.lib.input.FileInputFormat<NullWritable, ";
  protected final String TEXT_4 = "> implements org.apache.hadoop.conf.Configurable {" + NL + "" + NL + "    private ContextProperties context;" + NL + "    private GlobalVar globalMap;" + NL + "" + NL + "    public final static String EXT = \".avro\";" + NL + "" + NL + "    public Configuration getConf() {" + NL + "        // Not used." + NL + "        return null;" + NL + "    }" + NL + "" + NL + "    // init" + NL + "    public void setConf(Configuration conf) {" + NL + "        context = new ContextProperties(conf);" + NL + "    }" + NL + "" + NL + "    @Override" + NL + "    public org.apache.hadoop.mapreduce.RecordReader<NullWritable, ";
  protected final String TEXT_5 = "> createRecordReader(" + NL + "            org.apache.hadoop.mapreduce.InputSplit split," + NL + "            org.apache.hadoop.mapreduce.TaskAttemptContext taskContext)" + NL + "            throws IOException, InterruptedException {" + NL + "        return new AvroRecordReader(context);" + NL + "    }" + NL + "" + NL + "    private static class AvroRecordReader extends" + NL + "            org.apache.hadoop.mapreduce.RecordReader<NullWritable, ";
  protected final String TEXT_6 = "> {" + NL + "" + NL + "        private ContextProperties context;" + NL + "" + NL + "        private org.apache.avro.file.FileReader<org.apache.avro.generic.GenericRecord> reader;" + NL + "        private long start;" + NL + "        private long end;" + NL + "        private org.apache.avro.generic.GenericRecord record = null;" + NL + "        private ";
  protected final String TEXT_7 = " value = null;" + NL + "" + NL + "        public AvroRecordReader(ContextProperties context) {" + NL + "            this.context = context;" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public NullWritable getCurrentKey() throws IOException," + NL + "                InterruptedException {" + NL + "            return NullWritable.get();" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public ";
  protected final String TEXT_8 = " getCurrentValue() throws IOException, InterruptedException {" + NL + "            return value;" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public boolean nextKeyValue() throws IOException," + NL + "                InterruptedException {" + NL + "           value = new ";
  protected final String TEXT_9 = "();" + NL + "            if (!reader.hasNext() || reader.pastSync(end)) {" + NL + "                return false;" + NL + "            }" + NL + "            value.set(reader.next(record));" + NL + "            return true;" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public void initialize(" + NL + "                org.apache.hadoop.mapreduce.InputSplit split," + NL + "                org.apache.hadoop.mapreduce.TaskAttemptContext taskContext) throws IOException," + NL + "                InterruptedException {" + NL + "            " + NL + "            Configuration jobConf = taskContext.getConfiguration();" + NL + "" + NL + "            //create file reader" + NL + "            org.apache.avro.io.DatumReader<org.apache.avro.generic.GenericRecord> datumReader = new org.apache.avro.generic.GenericDatumReader<org.apache.avro.generic.GenericRecord>();" + NL + "            reader = org.apache.avro.file.DataFileReader.openReader(new org.apache.avro.mapred.FsInput(((org.apache.hadoop.mapreduce.lib.input.FileSplit) split).getPath(),jobConf),datumReader);" + NL + "" + NL + "            // get the schema" + NL + "            org.apache.avro.Schema schema = reader.getSchema();" + NL + "" + NL + "            //sync to start" + NL + "            reader.sync(((org.apache.hadoop.mapreduce.lib.input.FileSplit) split).getStart());" + NL + "            this.start = reader.tell();" + NL + "            this.end = ((org.apache.hadoop.mapreduce.lib.input.FileSplit) split).getStart() + ((org.apache.hadoop.mapreduce.lib.input.FileSplit) split).getLength();" + NL + "" + NL + "            record = new org.apache.avro.generic.GenericData.Record(schema);" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public void close() throws IOException {" + NL + "            if (reader != null) {" + NL + "                reader.close();" + NL + "            }" + NL + "        }" + NL + "" + NL + "        private long getPos() throws IOException {" + NL + "            return reader.tell();" + NL + "        }" + NL + "" + NL + "        public float getProgress() throws IOException {" + NL + "            if (start == end) {" + NL + "                return 0.0f;" + NL + "            } else {" + NL + "                return Math.min(1.0f, (getPos() - start) / (float) (end - start));" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "}";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    
String folder = ElementParameterParser.getValue(node,"__FILENAME__");

String uriPrefix = "";
// Used for Spark only for now.
boolean useConfigurationComponent = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_STORAGE_CONFIGURATION__"));
if (useConfigurationComponent) {
    uriPrefix = org.talend.designer.spark.generator.storage.SparkStorageUtils.getURIPrefix(node);
    folder = uriPrefix + " + " + folder;
}

List<IMetadataTable> metadatas = node.getMetadataList();
List<? extends IConnection> connections = node.getOutgoingConnections();
if (connections == null || connections.size() == 0 || metadatas == null || metadatas.size() == 0)
    return "";

String connectionName = connections.get(0).getName();
List<IMetadataColumn> columns = metadatas.get(0).getListColumns();
int nbColumns = columns.size();

// Don't use the auto-generated Avro record struct with the outgoing connection.
// It will be embedded in the job code.
//String avroRecordStruct = connectionName + "_ObjectWritableStruct";
String avroRecordStruct = "org.apache.hadoop.io.ObjectWritable";
codeGenArgument.getRecordStructGenerator().reserveRecordStructName(connections.get(0), avroRecordStruct);

    stringBuffer.append(TEXT_2);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(avroRecordStruct);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(avroRecordStruct);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(avroRecordStruct);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(avroRecordStruct);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(avroRecordStruct);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(avroRecordStruct);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
