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

public class TInputFormatJSONSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TInputFormatJSONSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TInputFormatJSONSparkstreamingcodeJava result = new TInputFormatJSONSparkstreamingcodeJava();
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
  protected final String TEXT_7 = "StructInputFormat extends org.talend.hadoop.mapred.lib.file.TDelimitedFileInputFormat<NullWritable, ";
  protected final String TEXT_8 = "> {" + NL + "    private ContextProperties context;" + NL + "" + NL + "    //init" + NL + "    public void setConf(Configuration conf){" + NL + "        context = new ContextProperties(conf);" + NL + "        setInputPath(";
  protected final String TEXT_9 = ");" + NL + "    }" + NL + "" + NL + "    public RecordReader<NullWritable, ";
  protected final String TEXT_10 = "> getRecordReader(" + NL + "            InputSplit split, JobConf job, Reporter reporter)" + NL + "            throws IOException {" + NL + "        return new JSONRecordReader(job, (FileSplit)split);" + NL + "    }" + NL + "" + NL + "    protected static class JSONRecordReader extends" + NL + "        org.talend.hadoop.mapred.lib.json.TJSONFileRecordReader<NullWritable, ";
  protected final String TEXT_11 = "> {" + NL + "" + NL + "        class ConvertJSONString_";
  protected final String TEXT_12 = "{" + NL + "            final static int Brace = 0 ; // {" + NL + "            final static int Bracket = 1; // [" + NL + "            private int barceType = -1 ;" + NL + "            private String originalJsonString = \"\" ;" + NL + "            private String originalLoopString = \"\" ;" + NL + "            private String jsonString4XML = null;" + NL + "            private String loopString4XML = null;" + NL + "            private String additionRoot = null;" + NL + "" + NL + "            public void barceType(){" + NL + "                for (int c = 0; c < originalJsonString.length(); ++c) {" + NL + "                    if (originalJsonString.charAt(c) == '{') {" + NL + "                        barceType = Brace;" + NL + "                        break;" + NL + "                    } else if (originalJsonString.charAt(c) == '[') {" + NL + "                        barceType = Bracket;" + NL + "                        break;" + NL + "                    }" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public void setJsonString (String originalJsonString) {" + NL + "                this.originalJsonString = originalJsonString;" + NL + "            }" + NL + "" + NL + "            public void setLoopString (String originalLoopString) {" + NL + "                this.originalLoopString = originalLoopString;" + NL + "            }" + NL + "" + NL + "            public String getJsonString4XML(){" + NL + "                return jsonString4XML;" + NL + "            }" + NL + "" + NL + "            public String getLoopString4XML(){" + NL + "                if(loopString4XML.length()>1 && loopString4XML.endsWith(\"/\")){" + NL + "                    loopString4XML = loopString4XML.substring(0, loopString4XML.length()-1);" + NL + "                }" + NL + "                return loopString4XML;" + NL + "            }" + NL + "" + NL + "            public void setAdditionRoot(String additionRoot) {" + NL + "                this.additionRoot = additionRoot;" + NL + "            }" + NL + "" + NL + "            public String getAdditionRoot(){" + NL + "                return additionRoot;" + NL + "            }" + NL + "" + NL + "            public void generate() {" + NL + "                barceType();" + NL + "                jsonString4XML = originalJsonString;" + NL + "                loopString4XML = originalLoopString;" + NL + "                if (Brace == barceType) {" + NL + "                    if (isNeedAddRoot(originalJsonString)) {" + NL + "                        jsonString4XML = \"{ \\\"root\\\": \" + originalJsonString + \" }\";" + NL + "                        loopString4XML = \"root\" + originalLoopString;" + NL + "                        setAdditionRoot(\"root\");" + NL + "                    }" + NL + "                } else if (Bracket == barceType) {" + NL + "                    jsonString4XML = \"{ \\\"root\\\" : { \\\"object\\\": \"" + NL + "                            + originalJsonString + \" } }\";" + NL + "                    loopString4XML = \"root/object\" + originalLoopString;" + NL + "                        setAdditionRoot(\"object\");" + NL + "                }" + NL + "            }" + NL + "            " + NL + "            " + NL + "" + NL + "            public boolean isNeedAddRoot(String originalJsonString) {" + NL + "                boolean isNeedAddRoot = false;" + NL + "                net.sf.json.JSONObject jso = net.sf.json.JSONObject" + NL + "                        .fromObject(originalJsonString);" + NL + "                String jsonKey = \"\";" + NL + "                Object firstObject = null;" + NL + "                if (jso.names().size() == 1) {" + NL + "                    jsonKey = jso.names().get(0).toString();" + NL + "                    firstObject = jso.get(jsonKey);" + NL + "                }" + NL + "                if (jso.size() > 1" + NL + "                        || (firstObject != null" + NL + "                                && firstObject instanceof net.sf.json.JSONArray && ((net.sf.json.JSONArray) firstObject)" + NL + "                                .size() > 1)) {" + NL + "                    isNeedAddRoot = true;" + NL + "                }" + NL + "                return isNeedAddRoot;" + NL + "            }" + NL + "        }" + NL;
  protected final String TEXT_13 = NL + "            class OriginalJSONString_";
  protected final String TEXT_14 = " {" + NL + "                String originalJSONString = null;" + NL + "                java.io.ByteArrayInputStream bais = null;" + NL + "                java.io.ByteArrayOutputStream baos = null;" + NL + "                de.odysseus.staxon.json.JsonXMLConfig config = null;" + NL + "                de.odysseus.staxon.json.JsonXMLOutputFactory jxof = null;" + NL + "" + NL + "                public String getOriginalJSONString(String xmlString,String additionRoot,String encoding,boolean isGetWholeJson) throws Exception {" + NL + "                    try {" + NL + "                        bais = new java.io.ByteArrayInputStream(xmlString.getBytes(encoding));" + NL + "                        baos = new java.io.ByteArrayOutputStream();" + NL + "                        config = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).autoArray(true).build();" + NL + "                        jxof = new de.odysseus.staxon.json.JsonXMLOutputFactory(config);" + NL + "                        javax.xml.stream.XMLEventReader xmlEventReader = javax.xml.stream.XMLInputFactory.newInstance().createXMLEventReader(bais);" + NL + "                        javax.xml.stream.XMLEventWriter xmLEventWriter = jxof.createXMLEventWriter(baos);" + NL + "                        xmLEventWriter.add(xmlEventReader);" + NL + "                        xmlEventReader.close();" + NL + "                        xmLEventWriter.close();" + NL + "                        net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(baos.toString());" + NL + "                        net.sf.json.JSONObject originalJsonObject = null;" + NL + "                        if (!json.isNullObject()) {" + NL + "                            if (additionRoot == null) {" + NL + "                                originalJSONString = json.toString();" + NL + "                            } else {" + NL + "                                if (isGetWholeJson) {" + NL + "                                    originalJsonObject = json.getJSONObject(additionRoot);" + NL + "                                    if (!originalJsonObject.isNullObject()) {" + NL + "                                        originalJSONString = originalJsonObject.toString();" + NL + "                                    }" + NL + "                                } else {" + NL + "                                    originalJSONString = json.toString();" + NL + "                                }" + NL + "                            }" + NL + "                        }" + NL + "                    } finally {" + NL + "                        baos.close();" + NL + "                        if(bais!=null){" + NL + "                            bais.close();" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                    return originalJSONString;" + NL + "                }" + NL + "            }";
  protected final String TEXT_15 = NL + NL + NL + "        ConvertJSONString_";
  protected final String TEXT_16 = " cjs_";
  protected final String TEXT_17 = " = null;" + NL + "        de.odysseus.staxon.json.JsonXMLConfig config_";
  protected final String TEXT_18 = " = null;" + NL + "        de.odysseus.staxon.json.JsonXMLInputFactory jsonXMLInputFactory_";
  protected final String TEXT_19 = " = null;" + NL + "        javax.xml.stream.XMLOutputFactory xmlOutputFactory_";
  protected final String TEXT_20 = " = null;";
  protected final String TEXT_21 = NL + "        OriginalJSONString_";
  protected final String TEXT_22 = " originalJSONString_";
  protected final String TEXT_23 = " = null;";
  protected final String TEXT_24 = NL + "        org.dom4j.io.SAXReader reader_";
  protected final String TEXT_25 = " = null;" + NL + "        org.dom4j.Document doc_";
  protected final String TEXT_26 = " = null;" + NL + "        org.dom4j.XPath x_";
  protected final String TEXT_27 = " = null;" + NL + "        String jsonStr_";
  protected final String TEXT_28 = " = null;" + NL + "        String xmlStr_";
  protected final String TEXT_29 = " = null;" + NL + "" + NL + "        private ContextProperties context;" + NL + "" + NL + "        protected JSONRecordReader(JobConf job, FileSplit split)" + NL + "                throws IOException {" + NL + "            super(job, split);" + NL + "            this.context = new ContextProperties(job);" + NL + "            cjs_";
  protected final String TEXT_30 = " = new ConvertJSONString_";
  protected final String TEXT_31 = "();" + NL + "            config_";
  protected final String TEXT_32 = " = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).build();" + NL + "            jsonXMLInputFactory_";
  protected final String TEXT_33 = " = new de.odysseus.staxon.json.JsonXMLInputFactory(config_";
  protected final String TEXT_34 = ");" + NL + "            xmlOutputFactory_";
  protected final String TEXT_35 = " = javax.xml.stream.XMLOutputFactory.newInstance();";
  protected final String TEXT_36 = NL + "            originalJSONString_";
  protected final String TEXT_37 = " = new OriginalJSONString_";
  protected final String TEXT_38 = "();";
  protected final String TEXT_39 = NL + "            reader_";
  protected final String TEXT_40 = " = new org.dom4j.io.SAXReader();" + NL + "        }" + NL + "" + NL + "        protected Text dummyValue = new Text();" + NL + "" + NL + "        public java.util.List<org.dom4j.tree.AbstractNode> next() throws IOException {" + NL + "            java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_41 = " = null;" + NL + "            if (next(dummyValue)) {" + NL + "" + NL + "                boolean isStructError_";
  protected final String TEXT_42 = " = true;" + NL + "" + NL + "                String loopQuery_";
  protected final String TEXT_43 = " = ";
  protected final String TEXT_44 = ";" + NL + "                String oraginalJsonStr_";
  protected final String TEXT_45 = " = dummyValue.toString();" + NL + "                cjs_";
  protected final String TEXT_46 = ".setJsonString(oraginalJsonStr_";
  protected final String TEXT_47 = ");" + NL + "                cjs_";
  protected final String TEXT_48 = ".setLoopString(loopQuery_";
  protected final String TEXT_49 = ");" + NL + "                java.io.ByteArrayInputStream bais_";
  protected final String TEXT_50 = " = null;" + NL + "                java.io.ByteArrayOutputStream  baos_";
  protected final String TEXT_51 = " = new java.io.ByteArrayOutputStream();" + NL + "                try {" + NL + "                    cjs_";
  protected final String TEXT_52 = ".generate();" + NL + "                    jsonStr_";
  protected final String TEXT_53 = " = cjs_";
  protected final String TEXT_54 = ".getJsonString4XML();" + NL + "                    loopQuery_";
  protected final String TEXT_55 = " = cjs_";
  protected final String TEXT_56 = ".getLoopString4XML();" + NL + "                    bais_";
  protected final String TEXT_57 = " = new java.io.ByteArrayInputStream(jsonStr_";
  protected final String TEXT_58 = ".getBytes(";
  protected final String TEXT_59 = "));" + NL + "                    javax.xml.stream.XMLEventReader xmlEventReader_";
  protected final String TEXT_60 = " = jsonXMLInputFactory_";
  protected final String TEXT_61 = ".createXMLEventReader(bais_";
  protected final String TEXT_62 = ");" + NL + "                    javax.xml.stream.XMLEventWriter xmLEventWriter_";
  protected final String TEXT_63 = " = xmlOutputFactory_";
  protected final String TEXT_64 = ".createXMLEventWriter(baos_";
  protected final String TEXT_65 = ");" + NL + "                    xmLEventWriter_";
  protected final String TEXT_66 = ".add(xmlEventReader_";
  protected final String TEXT_67 = ");" + NL + "                    //convert json string to xml" + NL + "                    xmLEventWriter_";
  protected final String TEXT_68 = ".close();" + NL + "                    xmlEventReader_";
  protected final String TEXT_69 = ".close();" + NL + "                    xmlStr_";
  protected final String TEXT_70 = " = baos_";
  protected final String TEXT_71 = ".toString();" + NL + "" + NL + "                    doc_";
  protected final String TEXT_72 = "= reader_";
  protected final String TEXT_73 = ".read(new java.io.StringReader(xmlStr_";
  protected final String TEXT_74 = "));" + NL + "                    x_";
  protected final String TEXT_75 = " = doc_";
  protected final String TEXT_76 = ".createXPath(loopQuery_";
  protected final String TEXT_77 = ");" + NL + "                    nodeList_";
  protected final String TEXT_78 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_79 = ".selectNodes(doc_";
  protected final String TEXT_80 = ");" + NL + "                    isStructError_";
  protected final String TEXT_81 = " = false;" + NL + "                } catch(java.lang.Exception ex_";
  protected final String TEXT_82 = ") {" + NL + "                    System.err.println(ex_";
  protected final String TEXT_83 = ".getMessage());" + NL + "                } finally {" + NL + "                    baos_";
  protected final String TEXT_84 = ".close();" + NL + "                    if(bais_";
  protected final String TEXT_85 = "!=null){" + NL + "                        bais_";
  protected final String TEXT_86 = ".close();" + NL + "                    }" + NL + "                }" + NL + "                if (!isStructError_";
  protected final String TEXT_87 = ") {" + NL + "                    if (nodeList_";
  protected final String TEXT_88 = " != null) {" + NL + "                        return nodeList_";
  protected final String TEXT_89 = ";" + NL + "                    }" + NL + "                }" + NL + "            }" + NL + "            return null;" + NL + "        }" + NL + "        int pos = 0;" + NL + "        int max = 0;" + NL + "        java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_90 = ";" + NL + "" + NL + "        public boolean next(NullWritable key, ";
  protected final String TEXT_91 = " value) throws IOException {" + NL + "            if(pos == max){" + NL + "                nodeList_";
  protected final String TEXT_92 = " = next();" + NL + "                if(nodeList_";
  protected final String TEXT_93 = " == null){" + NL + "                    return false;" + NL + "                }" + NL + "                max = nodeList_";
  protected final String TEXT_94 = ".size();" + NL + "                pos = 0;" + NL + "            }" + NL + "            //org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_95 = " = nodeList_";
  protected final String TEXT_96 = ".get(pos);" + NL + "            value.set(nodeList_";
  protected final String TEXT_97 = ".get(pos));" + NL + "            pos++;" + NL + "            return true;" + NL + "        }" + NL + "" + NL + "        public NullWritable createKey() {" + NL + "            return NullWritable.get();" + NL + "        }" + NL + "" + NL + "        public ";
  protected final String TEXT_98 = " createValue() {  " + NL + "            return new ";
  protected final String TEXT_99 = "();" + NL + "        }" + NL + "" + NL + "    }" + NL + "}";
  protected final String TEXT_100 = NL + NL + "public static class JsonPathCache_";
  protected final String TEXT_101 = " {" + NL + "    final java.util.Map<String, com.jayway.jsonpath.JsonPath> jsonPathString2compiledJsonPath = new java.util.HashMap<String, com.jayway.jsonpath.JsonPath>();" + NL + "" + NL + "    public com.jayway.jsonpath.JsonPath getCompiledJsonPath(" + NL + "            String jsonPath) {" + NL + "        if (jsonPathString2compiledJsonPath" + NL + "                .containsKey(jsonPath)) {" + NL + "            return jsonPathString2compiledJsonPath" + NL + "                    .get(jsonPath);" + NL + "        } else {" + NL + "            com.jayway.jsonpath.JsonPath compiledLoopPath = com.jayway.jsonpath.JsonPath" + NL + "                    .compile(jsonPath);" + NL + "            jsonPathString2compiledJsonPath.put(jsonPath," + NL + "                    compiledLoopPath);" + NL + "            return compiledLoopPath;" + NL + "        }" + NL + "    }" + NL + "}" + NL + "" + NL + "public static class ";
  protected final String TEXT_102 = "StructInputFormat extends org.talend.hadoop.mapred.lib.file.TDelimitedFileInputFormat<NullWritable, ";
  protected final String TEXT_103 = "> {" + NL + "    private ContextProperties context;" + NL + "" + NL + "    //init" + NL + "    public void setConf(Configuration conf){" + NL + "        context = new ContextProperties(conf);" + NL + "        setInputPath(";
  protected final String TEXT_104 = ");" + NL + "    }" + NL + "" + NL + "    public RecordReader<NullWritable, ";
  protected final String TEXT_105 = "> getRecordReader(" + NL + "            InputSplit split, JobConf job, Reporter reporter)" + NL + "            throws IOException {" + NL + "        return new JSONRecordReader(job, (FileSplit)split);" + NL + "    }" + NL + "" + NL + "    protected static class JSONRecordReader extends org.talend.hadoop.mapred.lib.json.TJSONFileRecordReader<NullWritable, ";
  protected final String TEXT_106 = "> {" + NL + "" + NL + "        private ContextProperties context;" + NL + "        private String loopPath_";
  protected final String TEXT_107 = " = ";
  protected final String TEXT_108 = ";" + NL + "        private JsonPathCache_";
  protected final String TEXT_109 = " jsonPathCache_";
  protected final String TEXT_110 = " = new JsonPathCache_";
  protected final String TEXT_111 = "();" + NL + "" + NL + "" + NL + "        protected JSONRecordReader(JobConf job, FileSplit split)" + NL + "                throws IOException {" + NL + "            super(job, split);" + NL + "            this.context = new ContextProperties(job);" + NL + "        }" + NL + "" + NL + "        protected Text dummyValue = new Text();" + NL + "" + NL + "        public java.util.List<Object> next() throws IOException {" + NL + "" + NL + "            java.util.List<Object> resultset_";
  protected final String TEXT_112 = " = new java.util.ArrayList<Object>();" + NL + "" + NL + "            if (next(dummyValue)) {" + NL + "" + NL + "                String loopQuery_";
  protected final String TEXT_113 = " = ";
  protected final String TEXT_114 = ";" + NL + "                String originalJsonStr_";
  protected final String TEXT_115 = " = dummyValue.toString();" + NL + "" + NL + "                try {" + NL + "                    com.jayway.jsonpath.ReadContext document_";
  protected final String TEXT_116 = " = com.jayway.jsonpath.JsonPath.parse(originalJsonStr_";
  protected final String TEXT_117 = ");" + NL + "                    com.jayway.jsonpath.JsonPath compiledLoopPath_";
  protected final String TEXT_118 = " = jsonPathCache_";
  protected final String TEXT_119 = ".getCompiledJsonPath(loopPath_";
  protected final String TEXT_120 = ");" + NL + "                    Object result_";
  protected final String TEXT_121 = " = document_";
  protected final String TEXT_122 = ".read(compiledLoopPath_";
  protected final String TEXT_123 = ",net.minidev.json.JSONObject.class);" + NL + "                    if (result_";
  protected final String TEXT_124 = " instanceof net.minidev.json.JSONArray) {" + NL + "                        resultset_";
  protected final String TEXT_125 = " = (net.minidev.json.JSONArray) result_";
  protected final String TEXT_126 = ";" + NL + "                    } else {" + NL + "                        resultset_";
  protected final String TEXT_127 = ".add(result_";
  protected final String TEXT_128 = ");" + NL + "                    }" + NL + "" + NL + "                    if (resultset_";
  protected final String TEXT_129 = " != null) {" + NL + "                        return resultset_";
  protected final String TEXT_130 = ";" + NL + "                    }" + NL + "                } catch (java.lang.Exception ex_";
  protected final String TEXT_131 = ") {" + NL + "                    System.err.println(ex_";
  protected final String TEXT_132 = ".getMessage());" + NL + "                }" + NL + "            }" + NL + "            return null;" + NL + "        }" + NL + "" + NL + "        " + NL + "        int pos = 0;" + NL + "        int max = 0;" + NL + "        java.util.List<Object> resultset_";
  protected final String TEXT_133 = ";" + NL + "" + NL + "        public boolean next(NullWritable key, ";
  protected final String TEXT_134 = " value) throws IOException {" + NL + "            if(pos == max){" + NL + "                resultset_";
  protected final String TEXT_135 = " = next();" + NL + "                if(resultset_";
  protected final String TEXT_136 = " == null){" + NL + "                    return false;" + NL + "                }" + NL + "                max = resultset_";
  protected final String TEXT_137 = ".size();" + NL + "                pos = 0;" + NL + "            }" + NL + "            //org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_138 = " = nodeList_";
  protected final String TEXT_139 = ".get(pos);" + NL + "            value.set(resultset_";
  protected final String TEXT_140 = ".get(pos));" + NL + "            pos++;" + NL + "            return true;" + NL + "        }" + NL + "" + NL + "        public NullWritable createKey() {" + NL + "            return NullWritable.get();" + NL + "        }" + NL + "" + NL + "        public ";
  protected final String TEXT_141 = " createValue() {  " + NL + "            return new ";
  protected final String TEXT_142 = "();" + NL + "        }" + NL + "" + NL + "    }" + NL + "}";

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
String inConnTypeName = codeGenArgument.getRecordStructName(connections.get(0));

// Since the schema is fixed, this should be a constant defined in the _java.xml
String columnName = metadatas.get(0).getListColumns().get(0).getLabel();


    stringBuffer.append(TEXT_2);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connectionName + "Struct");
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
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    if(hasNodeCheck){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
        }
        
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    if(hasNodeCheck){
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    if(hasNodeCheck){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
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
    stringBuffer.append(encoding);
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
    stringBuffer.append(cid);
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
    stringBuffer.append(inConnTypeName);
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
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_99);
    
} else {
    
    
String loopQuery = ElementParameterParser.getValue(node, "__JSON_LOOP_QUERY__");

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
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
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_142);
    
}

    return stringBuffer.toString();
  }
}
