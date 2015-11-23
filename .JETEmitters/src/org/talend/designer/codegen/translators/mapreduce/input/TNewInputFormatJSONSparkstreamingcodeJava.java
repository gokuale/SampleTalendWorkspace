package org.talend.designer.codegen.translators.mapreduce.input;

import java.util.ArrayList;
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

public class TNewInputFormatJSONSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TNewInputFormatJSONSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNewInputFormatJSONSparkstreamingcodeJava result = new TNewInputFormatJSONSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "// Use this object to override the ouput struct default ";
  protected final String TEXT_3 = NL + "public static class ";
  protected final String TEXT_4 = " extends org.apache.hadoop.io.ObjectWritable {" + NL + "}" + NL;
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + NL + NL + "public static class ";
  protected final String TEXT_7 = "StructInputFormat" + NL + "        extends org.apache.hadoop.mapreduce.lib.input.FileInputFormat<NullWritable, ";
  protected final String TEXT_8 = "> implements org.apache.hadoop.conf.Configurable {" + NL + "" + NL + "    private ContextProperties context;" + NL + "    private GlobalVar globalMap;" + NL + "" + NL + "    public Configuration getConf() {" + NL + "        // Not used." + NL + "        return null;" + NL + "    }" + NL + "" + NL + "    // init" + NL + "    public void setConf(Configuration conf) {" + NL + "        context = new ContextProperties(conf);" + NL + "    }" + NL + "" + NL + "    @Override" + NL + "    public org.apache.hadoop.mapreduce.RecordReader<NullWritable, ";
  protected final String TEXT_9 = "> createRecordReader(" + NL + "            org.apache.hadoop.mapreduce.InputSplit split," + NL + "            org.apache.hadoop.mapreduce.TaskAttemptContext taskContext)" + NL + "            throws IOException, InterruptedException {" + NL + "        return new JSONRecordReader(context);" + NL + "    }" + NL + "" + NL + "    private static class JSONRecordReader extends" + NL + "            org.apache.hadoop.mapreduce.RecordReader<NullWritable, ";
  protected final String TEXT_10 = "> {" + NL;
  protected final String TEXT_11 = NL + "    class ConvertJSONString_";
  protected final String TEXT_12 = "{" + NL + "        final static int Brace = 0 ; // {" + NL + "        final static int Bracket = 1; // [" + NL + "        private int barceType = -1 ;" + NL + "        private String originalJsonString = \"\" ;" + NL + "        private String originalLoopString = \"\" ;" + NL + "        private String jsonString4XML = null;" + NL + "        private String loopString4XML = null;" + NL + "        private String additionRoot = null;" + NL + "" + NL + "        public void barceType(){" + NL + "            for (int c = 0; c < originalJsonString.length(); ++c) {" + NL + "                if (originalJsonString.charAt(c) == '{') {" + NL + "                    barceType = Brace;" + NL + "                    break;" + NL + "                } else if (originalJsonString.charAt(c) == '[') {" + NL + "                    barceType = Bracket;" + NL + "                    break;" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "" + NL + "        public void setJsonString (String originalJsonString) {" + NL + "            this.originalJsonString = originalJsonString;" + NL + "        }" + NL + "" + NL + "        public void setLoopString (String originalLoopString) {" + NL + "            this.originalLoopString = originalLoopString;" + NL + "        }" + NL + "" + NL + "        public String getJsonString4XML(){" + NL + "            return jsonString4XML;" + NL + "        }" + NL + "" + NL + "        public String getLoopString4XML(){" + NL + "            if(loopString4XML.length()>1 && loopString4XML.endsWith(\"/\")){" + NL + "                loopString4XML = loopString4XML.substring(0, loopString4XML.length()-1);" + NL + "            }" + NL + "            return loopString4XML;" + NL + "        }" + NL + "" + NL + "        public void setAdditionRoot(String additionRoot) {" + NL + "            this.additionRoot = additionRoot;" + NL + "        }" + NL + "" + NL + "        public String getAdditionRoot(){" + NL + "            return additionRoot;" + NL + "        }" + NL + "" + NL + "        public void generate() {" + NL + "            barceType();" + NL + "            jsonString4XML = originalJsonString;" + NL + "            loopString4XML = originalLoopString;" + NL + "            if (Brace == barceType) {" + NL + "                if (isNeedAddRoot(originalJsonString)) {" + NL + "                    jsonString4XML = \"{ \\\"root\\\": \" + originalJsonString + \" }\";" + NL + "                    loopString4XML = \"root\" + originalLoopString;" + NL + "                    setAdditionRoot(\"root\");" + NL + "                }" + NL + "            } else if (Bracket == barceType) {" + NL + "                jsonString4XML = \"{ \\\"root\\\" : { \\\"object\\\": \"" + NL + "                        + originalJsonString + \" } }\";" + NL + "                loopString4XML = \"root/object\" + originalLoopString;" + NL + "                    setAdditionRoot(\"object\");" + NL + "            }" + NL + "        }" + NL + "        " + NL + "        " + NL + "" + NL + "        public boolean isNeedAddRoot(String originalJsonString) {" + NL + "            boolean isNeedAddRoot = false;" + NL + "            net.sf.json.JSONObject jso = net.sf.json.JSONObject" + NL + "                    .fromObject(originalJsonString);" + NL + "            String jsonKey = \"\";" + NL + "            Object firstObject = null;" + NL + "            if (jso.names().size() == 1) {" + NL + "                jsonKey = jso.names().get(0).toString();" + NL + "                firstObject = jso.get(jsonKey);" + NL + "            }" + NL + "            if (jso.size() > 1" + NL + "                    || (firstObject != null" + NL + "                            && firstObject instanceof net.sf.json.JSONArray && ((net.sf.json.JSONArray) firstObject)" + NL + "                            .size() > 1)) {" + NL + "                isNeedAddRoot = true;" + NL + "            }" + NL + "            return isNeedAddRoot;" + NL + "        }" + NL + "    }";
  protected final String TEXT_13 = NL + "    class OriginalJSONString_";
  protected final String TEXT_14 = " {" + NL + "        String originalJSONString = null;" + NL + "        java.io.ByteArrayInputStream bais = null;" + NL + "        java.io.ByteArrayOutputStream baos = null;" + NL + "        de.odysseus.staxon.json.JsonXMLConfig config = null;" + NL + "        de.odysseus.staxon.json.JsonXMLOutputFactory jxof = null;" + NL + "" + NL + "        public String getOriginalJSONString(String xmlString,String additionRoot,String encoding,boolean isGetWholeJson) throws Exception {" + NL + "            try {" + NL + "                bais = new java.io.ByteArrayInputStream(xmlString.getBytes(encoding));" + NL + "                baos = new java.io.ByteArrayOutputStream();" + NL + "                config = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).autoArray(true).build();" + NL + "                jxof = new de.odysseus.staxon.json.JsonXMLOutputFactory(config);" + NL + "                javax.xml.stream.XMLEventReader xmlEventReader = javax.xml.stream.XMLInputFactory.newInstance().createXMLEventReader(bais);" + NL + "                javax.xml.stream.XMLEventWriter xmLEventWriter = jxof.createXMLEventWriter(baos);" + NL + "                xmLEventWriter.add(xmlEventReader);" + NL + "                xmlEventReader.close();" + NL + "                xmLEventWriter.close();" + NL + "                net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(baos.toString());" + NL + "                net.sf.json.JSONObject originalJsonObject = null;" + NL + "                if (!json.isNullObject()) {" + NL + "                    if (additionRoot == null) {" + NL + "                        originalJSONString = json.toString();" + NL + "                    } else {" + NL + "                        if (isGetWholeJson) {" + NL + "                            originalJsonObject = json.getJSONObject(additionRoot);" + NL + "                            if (!originalJsonObject.isNullObject()) {" + NL + "                                originalJSONString = originalJsonObject.toString();" + NL + "                            }" + NL + "                        } else {" + NL + "                            originalJSONString = json.toString();" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "            } finally {" + NL + "                baos.close();" + NL + "                if(bais!=null){" + NL + "                    bais.close();" + NL + "                }" + NL + "            }" + NL + "" + NL + "            return originalJSONString;" + NL + "        }" + NL + "    }";
  protected final String TEXT_15 = "    " + NL + "" + NL + "        private ContextProperties context;" + NL + "        private ";
  protected final String TEXT_16 = " value;" + NL + "        private java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_17 = " = null;" + NL + "        private CompressionCodecFactory compressionCodecs = null;" + NL + "        private long start;" + NL + "        private long pos;" + NL + "        private long end;" + NL + "        private org.talend.hadoop.mapred.lib.json.TJSONFileLineReader in;" + NL + "        int maxLineLength;" + NL + "        int max = 0;" + NL + "        int position = 0;" + NL + "" + NL + "" + NL + "        ConvertJSONString_";
  protected final String TEXT_18 = " cjs_";
  protected final String TEXT_19 = " = null;" + NL + "        de.odysseus.staxon.json.JsonXMLConfig config_";
  protected final String TEXT_20 = " = null;" + NL + "        de.odysseus.staxon.json.JsonXMLInputFactory jsonXMLInputFactory_";
  protected final String TEXT_21 = " = null;" + NL + "        javax.xml.stream.XMLOutputFactory xmlOutputFactory_";
  protected final String TEXT_22 = " = null;";
  protected final String TEXT_23 = NL + "            OriginalJSONString_";
  protected final String TEXT_24 = " originalJSONString_";
  protected final String TEXT_25 = " = null;";
  protected final String TEXT_26 = NL + "        org.dom4j.io.SAXReader reader_";
  protected final String TEXT_27 = " = null;" + NL + "        org.dom4j.Document doc_";
  protected final String TEXT_28 = " = null;" + NL + "        org.dom4j.XPath x_";
  protected final String TEXT_29 = " = null;" + NL + "        String jsonStr_";
  protected final String TEXT_30 = " = null;" + NL + "        String xmlStr_";
  protected final String TEXT_31 = " = null;" + NL + "" + NL + "        public JSONRecordReader(ContextProperties context) {" + NL + "            this.context = context;" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public NullWritable getCurrentKey() throws IOException," + NL + "                InterruptedException {" + NL + "            return NullWritable.get();" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public ";
  protected final String TEXT_32 = " getCurrentValue() throws IOException, InterruptedException {" + NL + "            return value;" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public boolean nextKeyValue() throws IOException," + NL + "                InterruptedException {" + NL + "            if(position == max){" + NL + "                nodeList_";
  protected final String TEXT_33 = " = next();" + NL + "                if(nodeList_";
  protected final String TEXT_34 = " == null){" + NL + "                    return false;" + NL + "                }" + NL + "                max = nodeList_";
  protected final String TEXT_35 = ".size();" + NL + "                position = 0;" + NL + "            }" + NL + "            value = new ";
  protected final String TEXT_36 = "();" + NL + "            value.set(nodeList_";
  protected final String TEXT_37 = ".get(position));" + NL + "            position++;" + NL + "            return true;" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public void initialize(" + NL + "                org.apache.hadoop.mapreduce.InputSplit split," + NL + "                org.apache.hadoop.mapreduce.TaskAttemptContext taskContext) throws IOException," + NL + "                InterruptedException {" + NL + "            Configuration jobConf = taskContext.getConfiguration();" + NL + "            " + NL + "            this.maxLineLength = Integer.MAX_VALUE;" + NL + "            start = ((org.apache.hadoop.mapreduce.lib.input.FileSplit) split).getStart();" + NL + "            end = start + ((org.apache.hadoop.mapreduce.lib.input.FileSplit) split).getLength();" + NL + "            final Path file = ((org.apache.hadoop.mapreduce.lib.input.FileSplit) split).getPath();" + NL + "            compressionCodecs = new CompressionCodecFactory(jobConf);" + NL + "            final CompressionCodec codec = compressionCodecs.getCodec(file);" + NL + "" + NL + "            FileSystem fs = file.getFileSystem(jobConf);" + NL + "            FSDataInputStream fileIn = fs.open(file);" + NL + "" + NL + "            boolean skipFirstLine = false;" + NL + "            if (codec != null) {" + NL + "                in = new org.talend.hadoop.mapred.lib.json.TJSONFileLineReader(codec.createInputStream(fileIn));" + NL + "                if (start != 0) {" + NL + "                    skipFirstLine = true;" + NL + "                    start -= \"}\\r\\n\".getBytes().length;" + NL + "                }" + NL + "                end = Long.MAX_VALUE;" + NL + "            } else {" + NL + "                if (start != 0) {" + NL + "                    skipFirstLine = true;" + NL + "                    start -= \"}\\r\\n\".getBytes().length;" + NL + "                    fileIn.seek(start);" + NL + "                }" + NL + "                in = new org.talend.hadoop.mapred.lib.json.TJSONFileLineReader(fileIn);" + NL + "            }" + NL + "            if (skipFirstLine) {" + NL + "                start += in.readLine(new Text(), start," + NL + "                        (int) Math.min((long) Integer.MAX_VALUE, end - start));" + NL + "            }" + NL + "            this.pos = start;" + NL + "" + NL + "" + NL + "" + NL + "            cjs_";
  protected final String TEXT_38 = " = new ConvertJSONString_";
  protected final String TEXT_39 = "();" + NL + "            config_";
  protected final String TEXT_40 = " = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).build();" + NL + "            jsonXMLInputFactory_";
  protected final String TEXT_41 = " = new de.odysseus.staxon.json.JsonXMLInputFactory(config_";
  protected final String TEXT_42 = ");" + NL + "            xmlOutputFactory_";
  protected final String TEXT_43 = " = javax.xml.stream.XMLOutputFactory.newInstance();";
  protected final String TEXT_44 = NL + "                originalJSONString_";
  protected final String TEXT_45 = " = new OriginalJSONString_";
  protected final String TEXT_46 = "();";
  protected final String TEXT_47 = NL + "            reader_";
  protected final String TEXT_48 = " = new org.dom4j.io.SAXReader();" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public void close() throws IOException {" + NL + "            if (in != null) {" + NL + "                in.close();" + NL + "            }" + NL + "        }" + NL + "" + NL + "        public float getProgress() throws IOException {" + NL + "            if (start == end) {" + NL + "                return 0.0f;" + NL + "            } else {" + NL + "                return Math.min(1.0f, (pos - start) / (float) (end - start));" + NL + "            }" + NL + "        }" + NL + "" + NL + "" + NL + "        protected Text dummyValue = new Text();" + NL + "" + NL + "        public java.util.List<org.dom4j.tree.AbstractNode> next() throws IOException {" + NL + "            java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_49 = " = null;" + NL + "            if (next(dummyValue)) {" + NL + "" + NL + "                boolean isStructError_";
  protected final String TEXT_50 = " = true;" + NL + "" + NL + "                String loopQuery_";
  protected final String TEXT_51 = " = ";
  protected final String TEXT_52 = ";" + NL + "                String oraginalJsonStr_";
  protected final String TEXT_53 = " = dummyValue.toString();" + NL + "                cjs_";
  protected final String TEXT_54 = ".setJsonString(oraginalJsonStr_";
  protected final String TEXT_55 = ");" + NL + "                cjs_";
  protected final String TEXT_56 = ".setLoopString(loopQuery_";
  protected final String TEXT_57 = ");" + NL + "                java.io.ByteArrayInputStream bais_";
  protected final String TEXT_58 = " = null;" + NL + "                java.io.ByteArrayOutputStream  baos_";
  protected final String TEXT_59 = " = new java.io.ByteArrayOutputStream();" + NL + "                try {" + NL + "                    cjs_";
  protected final String TEXT_60 = ".generate();" + NL + "                    jsonStr_";
  protected final String TEXT_61 = " = cjs_";
  protected final String TEXT_62 = ".getJsonString4XML();" + NL + "                    loopQuery_";
  protected final String TEXT_63 = " = cjs_";
  protected final String TEXT_64 = ".getLoopString4XML();" + NL + "                    bais_";
  protected final String TEXT_65 = " = new java.io.ByteArrayInputStream(jsonStr_";
  protected final String TEXT_66 = ".getBytes(";
  protected final String TEXT_67 = "));" + NL + "                    javax.xml.stream.XMLEventReader xmlEventReader_";
  protected final String TEXT_68 = " = jsonXMLInputFactory_";
  protected final String TEXT_69 = ".createXMLEventReader(bais_";
  protected final String TEXT_70 = ");" + NL + "                    javax.xml.stream.XMLEventWriter xmLEventWriter_";
  protected final String TEXT_71 = " = xmlOutputFactory_";
  protected final String TEXT_72 = ".createXMLEventWriter(baos_";
  protected final String TEXT_73 = ");" + NL + "                    xmLEventWriter_";
  protected final String TEXT_74 = ".add(xmlEventReader_";
  protected final String TEXT_75 = ");" + NL + "                    //convert json string to xml" + NL + "                    xmLEventWriter_";
  protected final String TEXT_76 = ".close();" + NL + "                    xmlEventReader_";
  protected final String TEXT_77 = ".close();" + NL + "                    xmlStr_";
  protected final String TEXT_78 = " = baos_";
  protected final String TEXT_79 = ".toString();" + NL + "" + NL + "                    doc_";
  protected final String TEXT_80 = "= reader_";
  protected final String TEXT_81 = ".read(new java.io.StringReader(xmlStr_";
  protected final String TEXT_82 = "));" + NL + "                    x_";
  protected final String TEXT_83 = " = doc_";
  protected final String TEXT_84 = ".createXPath(loopQuery_";
  protected final String TEXT_85 = ");" + NL + "                    nodeList_";
  protected final String TEXT_86 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_87 = ".selectNodes(doc_";
  protected final String TEXT_88 = ");" + NL + "                    isStructError_";
  protected final String TEXT_89 = " = false;" + NL + "                } catch(java.lang.Exception ex_";
  protected final String TEXT_90 = ") {" + NL + "                    System.err.println(ex_";
  protected final String TEXT_91 = ".getMessage());" + NL + "                } finally {" + NL + "                    baos_";
  protected final String TEXT_92 = ".close();" + NL + "                    if(bais_";
  protected final String TEXT_93 = "!=null){" + NL + "                        bais_";
  protected final String TEXT_94 = ".close();" + NL + "                    }" + NL + "                }" + NL + "                if (!isStructError_";
  protected final String TEXT_95 = ") {" + NL + "                    if (nodeList_";
  protected final String TEXT_96 = " != null) {" + NL + "                        return nodeList_";
  protected final String TEXT_97 = ";" + NL + "                    }" + NL + "                }" + NL + "            }" + NL + "            return null;" + NL + "        }" + NL + "" + NL + "        public boolean next(Text value) throws IOException {" + NL + "           while (pos < end) {" + NL + "                int newSize = in.readLine(value, pos," + NL + "                        Math.max((int) Math.min(Integer.MAX_VALUE, end - pos)," + NL + "                                maxLineLength));" + NL + "                if (newSize == 0) {" + NL + "                    return false;" + NL + "                }" + NL + "                pos += newSize;" + NL + "                if (newSize < maxLineLength) {" + NL + "                    return true;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            return false;" + NL + "        }" + NL + "    }" + NL + "}";
  protected final String TEXT_98 = NL + NL + "public static class JsonPathCache_";
  protected final String TEXT_99 = " {" + NL + "    final java.util.Map<String, com.jayway.jsonpath.JsonPath> jsonPathString2compiledJsonPath = new java.util.HashMap<String, com.jayway.jsonpath.JsonPath>();" + NL + "" + NL + "    public com.jayway.jsonpath.JsonPath getCompiledJsonPath(" + NL + "            String jsonPath) {" + NL + "        if (jsonPathString2compiledJsonPath" + NL + "                .containsKey(jsonPath)) {" + NL + "            return jsonPathString2compiledJsonPath" + NL + "                    .get(jsonPath);" + NL + "        } else {" + NL + "            com.jayway.jsonpath.JsonPath compiledLoopPath = com.jayway.jsonpath.JsonPath" + NL + "                    .compile(jsonPath);" + NL + "            jsonPathString2compiledJsonPath.put(jsonPath," + NL + "                    compiledLoopPath);" + NL + "            return compiledLoopPath;" + NL + "        }" + NL + "    }" + NL + "}" + NL + "" + NL + "public static class ";
  protected final String TEXT_100 = "StructInputFormat extends org.apache.hadoop.mapreduce.lib.input.FileInputFormat<NullWritable, ";
  protected final String TEXT_101 = "> implements org.apache.hadoop.conf.Configurable {" + NL + "    private ContextProperties context;" + NL + "" + NL + "    public Configuration getConf() {" + NL + "        // Not used." + NL + "        return null;" + NL + "    }" + NL + "" + NL + "    //init" + NL + "    public void setConf(Configuration conf) {" + NL + "        context = new ContextProperties(conf);" + NL + "    }" + NL + "" + NL + "    @Override" + NL + "    public org.apache.hadoop.mapreduce.RecordReader<NullWritable, ";
  protected final String TEXT_102 = "> createRecordReader(" + NL + "            org.apache.hadoop.mapreduce.InputSplit split," + NL + "            org.apache.hadoop.mapreduce.TaskAttemptContext taskContext)" + NL + "            throws IOException, InterruptedException {" + NL + "        return new JSONRecordReader(context);" + NL + "    }" + NL + "" + NL + "    protected static class JSONRecordReader extends org.apache.hadoop.mapreduce.RecordReader<NullWritable, ";
  protected final String TEXT_103 = "> {" + NL + "" + NL + "        private ContextProperties context;" + NL + "        private String loopPath_";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = ";" + NL + "        private JsonPathCache_";
  protected final String TEXT_106 = " jsonPathCache_";
  protected final String TEXT_107 = " = new JsonPathCache_";
  protected final String TEXT_108 = "();" + NL + "        private ";
  protected final String TEXT_109 = " value;" + NL + "        java.util.List<Object> resultset_";
  protected final String TEXT_110 = ";" + NL + "        private CompressionCodecFactory compressionCodecs = null;" + NL + "        private long start;" + NL + "        private long pos;" + NL + "        private long end;" + NL + "        private org.talend.hadoop.mapred.lib.json.TJSONFileLineReader in;" + NL + "        int maxLineLength;" + NL + "        int max = 0;" + NL + "        int position = 0;" + NL + "" + NL + "" + NL + "        public JSONRecordReader(ContextProperties context) {" + NL + "            this.context = context;" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public NullWritable getCurrentKey() throws IOException," + NL + "                InterruptedException {" + NL + "            return NullWritable.get();" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public ";
  protected final String TEXT_111 = " getCurrentValue() throws IOException, InterruptedException {" + NL + "            return value;" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public boolean nextKeyValue() throws IOException," + NL + "                InterruptedException {" + NL + "            if(position == max) {" + NL + "                resultset_";
  protected final String TEXT_112 = " = next();" + NL + "                if(resultset_";
  protected final String TEXT_113 = " == null){" + NL + "                    return false;" + NL + "                }" + NL + "                max = resultset_";
  protected final String TEXT_114 = ".size();" + NL + "                position = 0;" + NL + "            }" + NL + "            value = new ";
  protected final String TEXT_115 = "();" + NL + "            value.set(resultset_";
  protected final String TEXT_116 = ".get(position));" + NL + "            position++;" + NL + "            return true;" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public void initialize(" + NL + "                org.apache.hadoop.mapreduce.InputSplit split," + NL + "                org.apache.hadoop.mapreduce.TaskAttemptContext taskContext) throws IOException," + NL + "                InterruptedException {" + NL + "            Configuration jobConf = taskContext.getConfiguration();" + NL + "" + NL + "            this.maxLineLength = Integer.MAX_VALUE;" + NL + "            start = ((org.apache.hadoop.mapreduce.lib.input.FileSplit) split).getStart();" + NL + "            end = start + ((org.apache.hadoop.mapreduce.lib.input.FileSplit) split).getLength();" + NL + "            final Path file = ((org.apache.hadoop.mapreduce.lib.input.FileSplit) split).getPath();" + NL + "            compressionCodecs = new CompressionCodecFactory(jobConf);" + NL + "            final CompressionCodec codec = compressionCodecs.getCodec(file);" + NL + "" + NL + "            FileSystem fs = file.getFileSystem(jobConf);" + NL + "            FSDataInputStream fileIn = fs.open(file);" + NL + "" + NL + "            boolean skipFirstLine = false;" + NL + "            if (codec != null) {" + NL + "                in = new org.talend.hadoop.mapred.lib.json.TJSONFileLineReader(codec.createInputStream(fileIn));" + NL + "                if (start != 0) {" + NL + "                    skipFirstLine = true;" + NL + "                    start -= \"}\\r\\n\".getBytes().length;" + NL + "                }" + NL + "                end = Long.MAX_VALUE;" + NL + "            } else {" + NL + "                if (start != 0) {" + NL + "                    skipFirstLine = true;" + NL + "                    start -= \"}\\r\\n\".getBytes().length;" + NL + "                    fileIn.seek(start);" + NL + "                }" + NL + "                in = new org.talend.hadoop.mapred.lib.json.TJSONFileLineReader(fileIn);" + NL + "            }" + NL + "            if (skipFirstLine) {" + NL + "                start += in.readLine(new Text(), start," + NL + "                        (int) Math.min((long) Integer.MAX_VALUE, end - start));" + NL + "            }" + NL + "            this.pos = start;" + NL + "        }" + NL + "" + NL + "        protected Text dummyValue = new Text();" + NL + "" + NL + "        public java.util.List<Object> next() throws IOException {" + NL + "" + NL + "            java.util.List<Object> resultset_";
  protected final String TEXT_117 = " = new java.util.ArrayList<Object>();" + NL + "" + NL + "            if (next(dummyValue)) {" + NL + "" + NL + "                String loopQuery_";
  protected final String TEXT_118 = " = ";
  protected final String TEXT_119 = ";" + NL + "                String originalJsonStr_";
  protected final String TEXT_120 = " = dummyValue.toString();" + NL + "" + NL + "                try {" + NL + "                    com.jayway.jsonpath.ReadContext document_";
  protected final String TEXT_121 = " = com.jayway.jsonpath.JsonPath.parse(originalJsonStr_";
  protected final String TEXT_122 = ");" + NL + "                    com.jayway.jsonpath.JsonPath compiledLoopPath_";
  protected final String TEXT_123 = " = jsonPathCache_";
  protected final String TEXT_124 = ".getCompiledJsonPath(loopPath_";
  protected final String TEXT_125 = ");" + NL + "                    Object result_";
  protected final String TEXT_126 = " = document_";
  protected final String TEXT_127 = ".read(compiledLoopPath_";
  protected final String TEXT_128 = ",net.minidev.json.JSONObject.class);" + NL + "                    if (result_";
  protected final String TEXT_129 = " instanceof net.minidev.json.JSONArray) {" + NL + "                        resultset_";
  protected final String TEXT_130 = " = (net.minidev.json.JSONArray) result_";
  protected final String TEXT_131 = ";" + NL + "                    } else {" + NL + "                        resultset_";
  protected final String TEXT_132 = ".add(result_";
  protected final String TEXT_133 = ");" + NL + "                    }" + NL + "" + NL + "                    if (resultset_";
  protected final String TEXT_134 = " != null) {" + NL + "                        return resultset_";
  protected final String TEXT_135 = ";" + NL + "                    }" + NL + "                } catch (java.lang.Exception ex_";
  protected final String TEXT_136 = ") {" + NL + "                    System.err.println(ex_";
  protected final String TEXT_137 = ".getMessage());" + NL + "                }" + NL + "            }" + NL + "            return null;" + NL + "        }" + NL + "" + NL + "        public boolean next(Text value) throws IOException {" + NL + "            while (pos < end) {" + NL + "                int newSize = in.readLine(value, pos," + NL + "                        Math.max((int) Math.min(Integer.MAX_VALUE, end - pos)," + NL + "                                maxLineLength));" + NL + "                if (newSize == 0) {" + NL + "                    return false;" + NL + "                }" + NL + "                pos += newSize;" + NL + "                if (newSize < maxLineLength) {" + NL + "                    return true;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            return false;" + NL + "        }" + NL + "" + NL + "        public long getPos() throws IOException {" + NL + "            return pos;" + NL + "        }" + NL + "" + NL + "        public void close() throws IOException {" + NL + "            if (in != null) {" + NL + "                in.close();" + NL + "            }" + NL + "        }" + NL + "" + NL + "        public float getProgress() throws IOException {" + NL + "            if (start == end) {" + NL + "                return 0.0f;" + NL + "            } else {" + NL + "                return Math.min(1.0f, (pos - start) / (float) (end - start));" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "}";

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

List<IMetadataTable> metadatas = node.getMetadataList();
List< ? extends IConnection> connections = node.getOutgoingConnections();
if (connections == null || connections.size() == 0 || metadatas == null || metadatas.size() == 0)
    return "";


String connectionName = connections.get(0).getName();
String inConnTypeName = connectionName + "Struct";
// Since the schema is fixed, this should be a constant defined in the _java.xml
String columnName = metadatas.get(0).getListColumns().get(0).getLabel();


    stringBuffer.append(TEXT_2);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_4);
    
final String readBy = ElementParameterParser.getValue(node, "__READ_BY__");
if ("XPATH".equals(readBy)) {
    
    stringBuffer.append(TEXT_5);
    
String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__");
List<Map<String, String>> mappings = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPINGXPATH__");
boolean hasNodeCheck = false;
for (Map<String, String> mapping : mappings) {
    hasNodeCheck = hasNodeCheck || "true".equals(mapping.get("NODECHECK"));
}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
     if(hasNodeCheck) { 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
     } 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    if(hasNodeCheck){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    if(hasNodeCheck){
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
} else {
    
    
String loopQuery = ElementParameterParser.getValue(node, "__JSON_LOOP_QUERY__");

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
}

    return stringBuffer.toString();
  }
}
