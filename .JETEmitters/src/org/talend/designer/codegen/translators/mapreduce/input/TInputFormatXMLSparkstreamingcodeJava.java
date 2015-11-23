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

public class TInputFormatXMLSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TInputFormatXMLSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TInputFormatXMLSparkstreamingcodeJava result = new TInputFormatXMLSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "public static class ";
  protected final String TEXT_3 = "StructInputFormat" + NL + "        extends org.apache.hadoop.mapred.FileInputFormat<NullWritable, ";
  protected final String TEXT_4 = "> {" + NL + "" + NL + "    private ContextProperties context;" + NL + "    private GlobalVar globalMap;" + NL + "" + NL + "    private boolean overrideInput = true;" + NL + "" + NL + "    protected org.apache.hadoop.fs.FileStatus[] listStatus(JobConf job) throws IOException {" + NL + "" + NL + "        if (context == null) {" + NL + "            context = new ContextProperties(job);" + NL + "            globalMap = new GlobalVar(job);" + NL + "        }" + NL + "" + NL + "        if (overrideInput) {" + NL + "            // TODO: use the first in newer versions of Hadoop." + NL + "            // job.set(org.apache.hadoop.mapreduce.lib.input." + NL + "            //    FileInputFormat.INPUT_DIR, ";
  protected final String TEXT_5 = ");" + NL + "            job.set(\"mapreduce.input.fileinputformat.inputdir\", ";
  protected final String TEXT_6 = ");" + NL + "            job.set(\"mapred.input.dir\", ";
  protected final String TEXT_7 = ");" + NL + "        }" + NL + "        return super.listStatus(job);" + NL + "    }" + NL + "" + NL + "    @Override" + NL + "    public RecordReader<NullWritable, ";
  protected final String TEXT_8 = "> getRecordReader(" + NL + "            InputSplit inputSplit, JobConf jobConf, Reporter reporter)" + NL + "            throws IOException {" + NL + "        return new XmlDelimitedRecordReader((FileSplit) inputSplit, jobConf);" + NL + "    }" + NL + "" + NL + "    /**" + NL + "     * Reader that returns a single line containing text between two markers" + NL + "     * (including the markers). In this case, the markers are XML elements in the" + NL + "     * format &lt;TAG&gt; &lt;/TAG&gt;. Anything outside of these markers will be" + NL + "     * ignored, and anything inside of the markers has NOT been validated for XML" + NL + "     * correctness." + NL + "     */" + NL + "    private static class XmlDelimitedRecordReader implements" + NL + "            RecordReader<NullWritable, ";
  protected final String TEXT_9 = "> {" + NL + "" + NL + "        private final long startSplit;" + NL + "        private final long endSplit;" + NL + "        private final FSDataInputStream in;" + NL + "        private final org.apache.hadoop.io.DataOutputBuffer buffer = new org.apache.hadoop.io.DataOutputBuffer();";
  protected final String TEXT_10 = NL + "            private final static byte[] startMarker = ('<' + ";
  protected final String TEXT_11 = " + '>').getBytes();" + NL + "            private final static byte[] endMarker = (\"</\" + ";
  protected final String TEXT_12 = " + '>').getBytes();";
  protected final String TEXT_13 = NL + "            private final static byte[] startMarker;" + NL + "            private final static byte[] endMarker;" + NL + "            static {" + NL + "                try {" + NL + "                    startMarker = ('<' + ";
  protected final String TEXT_14 = " + '>').getBytes(";
  protected final String TEXT_15 = ");" + NL + "                    endMarker = (\"</\" + ";
  protected final String TEXT_16 = " + '>').getBytes(";
  protected final String TEXT_17 = ");" + NL + "                } catch (java.io.UnsupportedEncodingException ex) {" + NL + "                    throw new RuntimeException(ex);" + NL + "                }" + NL + "             }";
  protected final String TEXT_18 = NL + NL + "        public XmlDelimitedRecordReader(FileSplit split, JobConf jobConf)" + NL + "                throws IOException {" + NL + "            // The region of the file to scan." + NL + "            startSplit = split.getStart();" + NL + "            endSplit = startSplit + split.getLength();" + NL + "            // N.B. We can go beyond the endSplit position if a record has been" + NL + "            // started." + NL + "" + NL + "            Path file = split.getPath();" + NL + "            FileSystem fs = file.getFileSystem(jobConf);" + NL + "            in = fs.open(file);" + NL + "            in.seek(startSplit);" + NL + "        }" + NL + "" + NL + "        public boolean next(NullWritable key, ";
  protected final String TEXT_19 = " value) throws IOException {" + NL + "            if (in.getPos() < endSplit) {" + NL + "                try {" + NL + "                    // At this point, the buffer should always be empty." + NL + "                    if (skipUntil(startMarker, in, buffer, endSplit)" + NL + "                            && scrapeUntil(endMarker, in, buffer, endSplit)) {" + NL + "                        value.";
  protected final String TEXT_20 = " = new String(buffer.getData(), 0, buffer.getLength());" + NL + "                        return true;" + NL + "                    }" + NL + "                } finally {" + NL + "                    buffer.reset();" + NL + "                }" + NL + "            }" + NL + "            return false;" + NL + "        }" + NL + "" + NL + "        public NullWritable createKey() {" + NL + "              return NullWritable.get();" + NL + "        }" + NL + "" + NL + "        public ";
  protected final String TEXT_21 = " createValue() {" + NL + "            return new ";
  protected final String TEXT_22 = "();" + NL + "        }" + NL + "" + NL + "        public long getPos() throws IOException {" + NL + "            return in.getPos();" + NL + "        }" + NL + "" + NL + "        public void close() throws IOException {" + NL + "            in.close();" + NL + "        }" + NL + "" + NL + "        public float getProgress() throws IOException {" + NL + "            return (in.getPos() - startSplit) / (float) (endSplit - startSplit);" + NL + "        }" + NL + "" + NL + "        /**" + NL + "         * Consumes from the input stream until startMarker has been exactly and" + NL + "         * entirely read. The input stream is positioned just after the startMarker." + NL + "         *" + NL + "         * @throws IOException" + NL + "         */" + NL + "        private static boolean skipUntil(byte[] marker, FSDataInputStream in," + NL + "                java.io.OutputStream out, long end) throws IOException {" + NL + "            // Counts how many characters from the start of the marker have been" + NL + "            // matched." + NL + "            int matched = 0;" + NL + "" + NL + "            int b;" + NL + "            while (-1 != (b = in.read())) {" + NL + "                // Increment matches if it's the next character in the marker." + NL + "                if (b == marker[matched]) {" + NL + "                    matched++;" + NL + "                    if (matched == marker.length) {" + NL + "                        out.write(marker);" + NL + "                        return true;" + NL + "                    }" + NL + "                } else if (in.getPos() >= end) {" + NL + "                    // If not currently matching a marker and past the end of input split," + NL + "                    // then nothing is left for this reader." + NL + "                    return false;" + NL + "                    // Note, if currently attempting to match a marker (even one" + NL + "                    // character), then processing continues to see if there's a" + NL + "                    // possibility of an match crossing XML boundaries." + NL + "                } else {" + NL + "                    matched = 0;" + NL + "                }" + NL + "            }" + NL + "            // No more characters in the input stream, and the marker wasn't" + NL + "            // completely matched." + NL + "            return false;" + NL + "        }" + NL + "" + NL + "        private static boolean scrapeUntil(byte[] marker, FSDataInputStream in," + NL + "                java.io.OutputStream out, long end) throws IOException {" + NL + "            // Counts how many characters from the start of the marker have been" + NL + "            // matched." + NL + "            int matched = 0;" + NL + "" + NL + "            int b;" + NL + "            while (-1 != (b = in.read())) {" + NL + "                // Always copy to the buffer." + NL + "                out.write(b);" + NL + "                // Increment matches if it's the next character in the marker." + NL + "                if (b == marker[matched]) {" + NL + "                    matched++;" + NL + "                    if (matched == marker.length)" + NL + "                        return true;" + NL + "                } else {" + NL + "                    matched = 0;" + NL + "                }" + NL + "            }" + NL + "            // No more characters in the input stream, and the marker wasn't" + NL + "            // completely matched." + NL + "            return false;" + NL + "        }" + NL + "    }" + NL + "}";

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
if(useConfigurationComponent) {
    uriPrefix = org.talend.designer.spark.generator.storage.SparkStorageUtils.getURIPrefix(node);
    folder = uriPrefix + " + " + folder;
}

boolean customEncoding = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_ENCODING__"));
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");

String marker = ElementParameterParser.getValue(node,"__MARKER__");

List<IMetadataTable> metadatas = node.getMetadataList();
List< ? extends IConnection> connections = node.getOutgoingConnections();
if (connections == null || connections.size() == 0 || metadatas == null || metadatas.size() == 0)
    return "";

String connectionName = connections.get(0).getName();
String connTypeName = codeGenArgument.getRecordStructName(connections.get(0));
// Since the schema is fixed, this should be a constant defined in the _java.xml
String columnName = metadatas.get(0).getListColumns().get(0).getLabel();


    stringBuffer.append(TEXT_2);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_9);
    
        if (!customEncoding) {
            
    stringBuffer.append(TEXT_10);
    stringBuffer.append(marker);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(marker);
    stringBuffer.append(TEXT_12);
    
        } else {
            
    stringBuffer.append(TEXT_13);
    stringBuffer.append(marker);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(marker);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_17);
    
        }
        
    stringBuffer.append(TEXT_18);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_22);
    return stringBuffer.toString();
  }
}
