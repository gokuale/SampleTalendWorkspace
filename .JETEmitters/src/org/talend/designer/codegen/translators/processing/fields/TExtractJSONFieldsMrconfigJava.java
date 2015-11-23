package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.common.TransformerBase;

public class TExtractJSONFieldsMrconfigJava
{
  protected static String nl;
  public static synchronized TExtractJSONFieldsMrconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractJSONFieldsMrconfigJava result = new TExtractJSONFieldsMrconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\t";
  protected final String TEXT_3 = NL + "\t\t\toutput_";
  protected final String TEXT_4 = ".collect(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ");" + NL + "\t\t";
  protected final String TEXT_7 = NL + "\t\t\tpublic static class ";
  protected final String TEXT_8 = " extends MapReduceBase" + NL + "\t\t\t\timplements Mapper<";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ", ";
  protected final String TEXT_11 = ", ";
  protected final String TEXT_12 = ">{" + NL + "" + NL + "\t\t\t\tContextProperties context;" + NL + "\t\t\t\tGlobalVar globalMap;" + NL + "\t\t\t\t";
  protected final String TEXT_13 = " ";
  protected final String TEXT_14 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t";
  protected final String TEXT_16 = " ";
  protected final String TEXT_17 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t";
  protected final String TEXT_19 = NL + NL + "\t\t\t\tpublic void configure(JobConf job_";
  protected final String TEXT_20 = "){" + NL + "\t\t\t\t\tcontext = new ContextProperties(job_";
  protected final String TEXT_21 = ");" + NL + "\t\t\t\t\tglobalMap = new GlobalVar(job_";
  protected final String TEXT_22 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_24 = " = NullWritable.get();" + NL + "\t\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_26 = " = new ";
  protected final String TEXT_27 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_30 = " = new ";
  protected final String TEXT_31 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t";
  protected final String TEXT_33 = NL + "  \t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic void map(";
  protected final String TEXT_34 = " key_";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = " value_";
  protected final String TEXT_37 = "," + NL + "\t\t\t\t\tOutputCollector<";
  protected final String TEXT_38 = ", ";
  protected final String TEXT_39 = "> output_";
  protected final String TEXT_40 = ", Reporter reporter_";
  protected final String TEXT_41 = ") throws IOException{" + NL + "\t\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic void close() throws IOException{" + NL + "\t\t\t\t\t";
  protected final String TEXT_43 = NL + "  \t\t\t\t}" + NL + "    \t\t}" + NL + "    \t";
  protected final String TEXT_44 = NL + "\t\t\t\tChainReducer.addMapper(job, ";
  protected final String TEXT_45 = ".class, ";
  protected final String TEXT_46 = ".class," + NL + "\t        \t\t";
  protected final String TEXT_47 = ".class, ";
  protected final String TEXT_48 = ".class, ";
  protected final String TEXT_49 = ".class, true, new JobConf(false));" + NL + "\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\tchainMapper.addMapper(job, ";
  protected final String TEXT_51 = ".class, ";
  protected final String TEXT_52 = ".class," + NL + "\t        \t\t";
  protected final String TEXT_53 = ".class, ";
  protected final String TEXT_54 = ".class, ";
  protected final String TEXT_55 = ".class, true, new JobConf(false));" + NL + "\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\tchainMapper.setCid(\"";
  protected final String TEXT_57 = "\");" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\tmos_";
  protected final String TEXT_59 = ".getCollector(\"";
  protected final String TEXT_60 = "\", reporter_";
  protected final String TEXT_61 = ").collect(";
  protected final String TEXT_62 = ", ";
  protected final String TEXT_63 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\tpublic static class ";
  protected final String TEXT_65 = " extends MapReduceBase" + NL + "\t\t\t\timplements Mapper<";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = ", ";
  protected final String TEXT_68 = ", WritableComparable>{" + NL + "\t\t\t\tContextProperties context;" + NL + "\t\t\t\tGlobalVar globalMap;" + NL + "\t\t\t\tpublic MultipleOutputs mos_";
  protected final String TEXT_69 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_70 = " ";
  protected final String TEXT_71 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_73 = " ";
  protected final String TEXT_74 = " = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\t\t";
  protected final String TEXT_76 = NL + NL + "\t\t\t\tpublic void configure(JobConf job_";
  protected final String TEXT_77 = "){" + NL + "\t\t\t\t\tcontext = new ContextProperties(job_";
  protected final String TEXT_78 = ");" + NL + "\t\t\t\t\tglobalMap = new GlobalVar(job_";
  protected final String TEXT_79 = ");" + NL + "\t\t\t\t\tmos_";
  protected final String TEXT_80 = " = new MultipleOutputs(job_";
  protected final String TEXT_81 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_83 = " = NullWritable.get();" + NL + "\t\t\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_85 = " = new ";
  protected final String TEXT_86 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_89 = " = new ";
  protected final String TEXT_90 = "();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\t\t";
  protected final String TEXT_92 = NL + "  \t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic void map(";
  protected final String TEXT_93 = " key_";
  protected final String TEXT_94 = ", ";
  protected final String TEXT_95 = " value_";
  protected final String TEXT_96 = "," + NL + "\t\t\t\t\tOutputCollector<";
  protected final String TEXT_97 = ", WritableComparable> output_";
  protected final String TEXT_98 = ", Reporter reporter_";
  protected final String TEXT_99 = ") throws IOException{" + NL + "\t\t\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic void close() throws IOException{" + NL + "\t\t\t\t\tmos_";
  protected final String TEXT_101 = ".close();" + NL + "\t\t\t\t\t";
  protected final String TEXT_102 = NL + "  \t\t\t\t}" + NL + "    \t\t}" + NL + "    \t";
  protected final String TEXT_103 = NL + "\t\t\t\tChainReducer.addMapper(job, ";
  protected final String TEXT_104 = ".class, ";
  protected final String TEXT_105 = ".class," + NL + "\t        \t\t";
  protected final String TEXT_106 = ".class, ";
  protected final String TEXT_107 = ".class, WritableComparable.class, true, new JobConf(false));" + NL + "\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t\tchainMapper.addMapper(job, ";
  protected final String TEXT_109 = ".class, ";
  protected final String TEXT_110 = ".class," + NL + "\t        \t\t";
  protected final String TEXT_111 = ".class, ";
  protected final String TEXT_112 = ".class, WritableComparable.class, true, new JobConf(false));" + NL + "\t\t\t";
  protected final String TEXT_113 = NL + "        \tMultipleOutputs.setWorkDir(job, genTempFolderForComponent(\"MultipleOutputs_";
  protected final String TEXT_114 = "\"));" + NL + "        \t";
  protected final String TEXT_115 = NL + "\t\t\t\tMultipleOutputs.setKeyValue(job, \"";
  protected final String TEXT_116 = "\", ";
  protected final String TEXT_117 = ".class, ";
  protected final String TEXT_118 = ".class);" + NL + "        \t";
  protected final String TEXT_119 = NL + "            // No mrcode generated for unnecessary ";
  protected final String TEXT_120 = NL + "                ";
  protected final String TEXT_121 = " ";
  protected final String TEXT_122 = " = value_";
  protected final String TEXT_123 = ";";
  protected final String TEXT_124 = NL + "            // No mrconfig generated for unnecessary ";
  protected final String TEXT_125 = NL + "        chainMapper.addMapper(job, ";
  protected final String TEXT_126 = "," + NL + "                NullWritable.class, ";
  protected final String TEXT_127 = "Struct.class," + NL + "                NullWritable.class, ";
  protected final String TEXT_128 = "Struct.class," + NL + "                            true, new JobConf(false));" + NL;
  protected final String TEXT_129 = NL + "            MultipleOutputs.setWorkDir(job," + NL + "                    genTempFolderForComponent(\"";
  protected final String TEXT_130 = "\"));" + NL + "            MultipleOutputs.setKeyValue(job, \"";
  protected final String TEXT_131 = "\"," + NL + "                    NullWritable.class, ";
  protected final String TEXT_132 = "Struct.class);";
  protected final String TEXT_133 = NL + "        ";
  protected final String TEXT_134 = " class ConvertJSONString_";
  protected final String TEXT_135 = " {" + NL + "            final static int Brace = 0 ; // {" + NL + "            final static int Bracket = 1; // [" + NL + "            private int barceType = -1 ;" + NL + "            private String originalJsonString = \"\" ;" + NL + "            private String originalLoopString = \"\" ;" + NL + "            private String jsonString4XML = null;" + NL + "            private String loopString4XML = null;" + NL + "            private String additionRoot = null;" + NL + "" + NL + "            public void barceType() {" + NL + "                for (int c = 0; c < originalJsonString.length(); ++c) {" + NL + "                    if (originalJsonString.charAt(c) == '{') {" + NL + "                        barceType = Brace;" + NL + "                        break;" + NL + "                    } else if (originalJsonString.charAt(c) == '[') {" + NL + "                        barceType = Bracket;" + NL + "                        break;" + NL + "                    }" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public void setJsonString (String originalJsonString) {" + NL + "                this.originalJsonString = originalJsonString;" + NL + "            }" + NL + "" + NL + "            public void setLoopString (String originalLoopString) {" + NL + "                this.originalLoopString = originalLoopString;" + NL + "            }" + NL + "" + NL + "            public String getJsonString4XML() {" + NL + "                return jsonString4XML;" + NL + "            }" + NL + "" + NL + "            public String getLoopString4XML() {" + NL + "                if(loopString4XML.length()>1 && loopString4XML.endsWith(\"/\")) {" + NL + "                    loopString4XML = loopString4XML.substring(0, loopString4XML.length()-1);" + NL + "                }" + NL + "                return loopString4XML;" + NL + "            }" + NL + "" + NL + "            public void setAdditionRoot(String additionRoot) {" + NL + "                this.additionRoot = additionRoot;" + NL + "            }" + NL + "" + NL + "            public String getAdditionRoot() {" + NL + "                return additionRoot;" + NL + "            }" + NL + "" + NL + "            public void generate() {" + NL + "                barceType();" + NL + "                jsonString4XML = originalJsonString;" + NL + "                loopString4XML = originalLoopString;" + NL + "                if (Brace == barceType) {" + NL + "                    if (isNeedAddRoot(originalJsonString)) {" + NL + "                        jsonString4XML = \"{ \\\"root\\\": \" + originalJsonString + \" }\";" + NL + "                        loopString4XML = \"root\" + originalLoopString;" + NL + "                        setAdditionRoot(\"root\");" + NL + "                    }" + NL + "                } else if (Bracket == barceType) {" + NL + "                    jsonString4XML = \"{ \\\"root\\\" : { \\\"object\\\": \"" + NL + "                            + originalJsonString + \" } }\";" + NL + "                    loopString4XML = \"root/object\" + originalLoopString;" + NL + "                        setAdditionRoot(\"object\");" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public boolean isNeedAddRoot(String originalJsonString) {" + NL + "                boolean isNeedAddRoot = false;" + NL + "                net.sf.json.JSONObject jso = net.sf.json.JSONObject" + NL + "                        .fromObject(originalJsonString);" + NL + "                String jsonKey = \"\";" + NL + "                Object firstObject = null;" + NL + "                if (jso.names().size() == 1) {" + NL + "                     jsonKey = jso.names().get(0).toString();" + NL + "                     firstObject = jso.get(jsonKey);" + NL + "                 }" + NL + "                 if (jso.size() > 1" + NL + "                         || (firstObject != null" + NL + "                                 && firstObject instanceof net.sf.json.JSONArray && ((net.sf.json.JSONArray) firstObject)" + NL + "                                 .size() > 1)) {" + NL + "                     isNeedAddRoot = true;" + NL + "                 }" + NL + "                 return isNeedAddRoot;" + NL + "            }" + NL + "        }";
  protected final String TEXT_136 = NL + "        ";
  protected final String TEXT_137 = " class OriginalJSONString_";
  protected final String TEXT_138 = " {" + NL + "            String originalJSONString = null;" + NL + "            java.io.ByteArrayInputStream bais = null;" + NL + "            java.io.ByteArrayOutputStream baos = null;" + NL + "            de.odysseus.staxon.json.JsonXMLConfig config = null;" + NL + "            de.odysseus.staxon.json.JsonXMLOutputFactory jxof = null;" + NL + "" + NL + "            public String getOriginalJSONString(String xmlString,String additionRoot,String encoding,boolean isGetWholeJson, boolean isArray) throws Exception {" + NL + "                try {" + NL + "                    if (isArray) {" + NL + "                        xmlString = \"<list>\" + xmlString + \"</list>\";" + NL + "                    }" + NL + "                    bais = new java.io.ByteArrayInputStream(xmlString.getBytes(encoding));" + NL + "                    baos = new java.io.ByteArrayOutputStream();" + NL + "                    config = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).autoArray(true).build();" + NL + "                    jxof = new de.odysseus.staxon.json.JsonXMLOutputFactory(config);" + NL + "                    javax.xml.stream.XMLEventReader xmlEventReader = javax.xml.stream.XMLInputFactory.newInstance().createXMLEventReader(bais);" + NL + "                    javax.xml.stream.XMLEventWriter xmLEventWriter = jxof.createXMLEventWriter(baos);" + NL + "                    xmLEventWriter.add(xmlEventReader);" + NL + "                    xmlEventReader.close();" + NL + "                    xmLEventWriter.close();" + NL + "                    net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(baos.toString());" + NL + "                    if(isArray) {" + NL + "                        json = json.getJSONObject(\"list\");" + NL + "                    }" + NL + "                    net.sf.json.JSONObject originalJsonObject = null;" + NL + "                    if (!json.isNullObject()) {" + NL + "                        if (additionRoot == null) {" + NL + "                            originalJSONString = json.toString();" + NL + "                        } else {" + NL + "                            if (isGetWholeJson) {" + NL + "                                originalJsonObject = json.getJSONObject(additionRoot);" + NL + "                                if (!originalJsonObject.isNullObject()) {" + NL + "                                    originalJSONString = originalJsonObject.toString();" + NL + "                                }" + NL + "                            } else {" + NL + "                                originalJSONString = json.toString();" + NL + "                            }" + NL + "                        }" + NL + "                    }" + NL + "                } finally {" + NL + "                    baos.close();" + NL + "                    if (bais != null) {" + NL + "                        bais.close();" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                return originalJSONString;" + NL + "            }" + NL + "" + NL + "            public String getOriginalJSONString(String xmlString,String additionRoot,String encoding,boolean isGetWholeJson) throws Exception {" + NL + "               return getOriginalJSONString(xmlString, additionRoot, encoding, isGetWholeJson, false);" + NL + "            }" + NL + "" + NL + "        }";
  protected final String TEXT_139 = NL + "        ";
  protected final String TEXT_140 = " class XML_API_";
  protected final String TEXT_141 = " {" + NL + "            public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "                if (node != null && node instanceof org.dom4j.Element) {" + NL + "                    org.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "                    if(attri != null && (\"true\").equals(attri.getText())){" + NL + "                        return true;" + NL + "                    }" + NL + "                }" + NL + "                return false;" + NL + "            }" + NL + "" + NL + "            public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "                return node == null ? true : false;" + NL + "            }" + NL + "" + NL + "            public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "                if (node != null) {" + NL + "                    return node.getText().length() == 0;" + NL + "                }" + NL + "                return false;" + NL + "            }" + NL + "        }";
  protected final String TEXT_142 = NL + "        ConvertJSONString_";
  protected final String TEXT_143 = " cjs_";
  protected final String TEXT_144 = " = null;" + NL + "        de.odysseus.staxon.json.JsonXMLConfig config_";
  protected final String TEXT_145 = " = null;" + NL + "        de.odysseus.staxon.json.JsonXMLInputFactory jsonXMLInputFactory_";
  protected final String TEXT_146 = " = null;" + NL + "        javax.xml.stream.XMLOutputFactory xmlOutputFactory_";
  protected final String TEXT_147 = " = null;";
  protected final String TEXT_148 = NL + "            OriginalJSONString_";
  protected final String TEXT_149 = " originalJSONString_";
  protected final String TEXT_150 = " = null;";
  protected final String TEXT_151 = NL + "        XML_API_";
  protected final String TEXT_152 = " xml_api_";
  protected final String TEXT_153 = " = null;" + NL + "        org.dom4j.io.SAXReader reader_";
  protected final String TEXT_154 = " = null;" + NL + "        org.dom4j.Document doc_";
  protected final String TEXT_155 = " = null;" + NL + "        java.util.HashMap<String, String> xmlNameSpaceMap_";
  protected final String TEXT_156 = " = new java.util.HashMap<String, String>();" + NL + "        org.dom4j.XPath x_";
  protected final String TEXT_157 = " = null;" + NL + "        java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_158 = " = null;" + NL + "        String jsonStr_";
  protected final String TEXT_159 = " = null;" + NL + "        String xmlStr_";
  protected final String TEXT_160 = " = null;";
  protected final String TEXT_161 = NL + "        cjs_";
  protected final String TEXT_162 = " = new ConvertJSONString_";
  protected final String TEXT_163 = "();" + NL + "        config_";
  protected final String TEXT_164 = " = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).build();" + NL + "        jsonXMLInputFactory_";
  protected final String TEXT_165 = " = new de.odysseus.staxon.json.JsonXMLInputFactory(config_";
  protected final String TEXT_166 = ");" + NL + "        xmlOutputFactory_";
  protected final String TEXT_167 = " = javax.xml.stream.XMLOutputFactory.newInstance();";
  protected final String TEXT_168 = NL + "            originalJSONString_";
  protected final String TEXT_169 = " = new OriginalJSONString_";
  protected final String TEXT_170 = "();";
  protected final String TEXT_171 = NL + "        xml_api_";
  protected final String TEXT_172 = " = new XML_API_";
  protected final String TEXT_173 = "();" + NL + "        reader_";
  protected final String TEXT_174 = " = new org.dom4j.io.SAXReader();";
  protected final String TEXT_175 = NL + "        boolean isStructError_";
  protected final String TEXT_176 = " = true;" + NL + "        String loopQuery_";
  protected final String TEXT_177 = " = ";
  protected final String TEXT_178 = ";" + NL + "        String originalJsonStr_";
  protected final String TEXT_179 = " = (String) ";
  protected final String TEXT_180 = ";" + NL + "        cjs_";
  protected final String TEXT_181 = ".setJsonString(originalJsonStr_";
  protected final String TEXT_182 = ");" + NL + "        cjs_";
  protected final String TEXT_183 = ".setLoopString(loopQuery_";
  protected final String TEXT_184 = ");" + NL + "        java.io.ByteArrayInputStream bais_";
  protected final String TEXT_185 = " = null;" + NL + "        java.io.ByteArrayOutputStream  baos_";
  protected final String TEXT_186 = " = new java.io.ByteArrayOutputStream();" + NL;
  protected final String TEXT_187 = NL + NL + "         org.dom4j.Node node_";
  protected final String TEXT_188 = " = null;" + NL + "         String str_";
  protected final String TEXT_189 = " = \"\";" + NL + "         org.dom4j.XPath xTmp_";
  protected final String TEXT_190 = " = null;" + NL + "         Object obj_";
  protected final String TEXT_191 = " = null;" + NL + "         String xmlStrTemp_";
  protected final String TEXT_192 = " = \"\";" + NL + "         java.util.List<String> xmlListTemp_";
  protected final String TEXT_193 = " = null;" + NL + "" + NL + "        if (!isStructError_";
  protected final String TEXT_194 = " && nodeList_";
  protected final String TEXT_195 = " != null) {" + NL + "            for (org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_196 = " : nodeList_";
  protected final String TEXT_197 = ") {";
  protected final String TEXT_198 = NL + "                    ";
  protected final String TEXT_199 = " = new ";
  protected final String TEXT_200 = "();";
  protected final String TEXT_201 = NL + "                    ";
  protected final String TEXT_202 = " = new ";
  protected final String TEXT_203 = "();";
  protected final String TEXT_204 = NL + "                try {";
  protected final String TEXT_205 = NL + "                        ";
  protected final String TEXT_206 = NL + "                        ";
  protected final String TEXT_207 = NL + "                } catch (java.lang.Exception ex) {";
  protected final String TEXT_208 = NL + "                }";
  protected final String TEXT_209 = NL + "                ";
  protected final String TEXT_210 = NL + "            }" + NL + "        }";
  protected final String TEXT_211 = NL + "        try {" + NL + "            cjs_";
  protected final String TEXT_212 = ".generate();" + NL + "            jsonStr_";
  protected final String TEXT_213 = " = cjs_";
  protected final String TEXT_214 = ".getJsonString4XML();" + NL + "            loopQuery_";
  protected final String TEXT_215 = " = cjs_";
  protected final String TEXT_216 = ".getLoopString4XML();" + NL + "            bais_";
  protected final String TEXT_217 = " = new java.io.ByteArrayInputStream(jsonStr_";
  protected final String TEXT_218 = ".getBytes(";
  protected final String TEXT_219 = "));" + NL + "" + NL + "            javax.xml.stream.XMLEventReader xmlEventReader_";
  protected final String TEXT_220 = " = jsonXMLInputFactory_";
  protected final String TEXT_221 = ".createXMLEventReader(bais_";
  protected final String TEXT_222 = ");" + NL + "            javax.xml.stream.XMLEventWriter xmLEventWriter_";
  protected final String TEXT_223 = " = xmlOutputFactory_";
  protected final String TEXT_224 = ".createXMLEventWriter(baos_";
  protected final String TEXT_225 = ");" + NL + "            xmLEventWriter_";
  protected final String TEXT_226 = ".add(xmlEventReader_";
  protected final String TEXT_227 = ");" + NL + "            // Convert JSON string to XML." + NL + "            xmLEventWriter_";
  protected final String TEXT_228 = ".close();" + NL + "            xmlEventReader_";
  protected final String TEXT_229 = ".close();" + NL + "            xmlStr_";
  protected final String TEXT_230 = " = baos_";
  protected final String TEXT_231 = ".toString();" + NL + "            doc_";
  protected final String TEXT_232 = "= reader_";
  protected final String TEXT_233 = ".read(new java.io.StringReader(xmlStr_";
  protected final String TEXT_234 = "));" + NL + "            x_";
  protected final String TEXT_235 = " = doc_";
  protected final String TEXT_236 = ".createXPath(loopQuery_";
  protected final String TEXT_237 = ");" + NL + "            x_";
  protected final String TEXT_238 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_239 = ");" + NL + "            nodeList_";
  protected final String TEXT_240 = " = (java.util.List<org.dom4j.tree.AbstractNode>) x_";
  protected final String TEXT_241 = ".selectNodes(doc_";
  protected final String TEXT_242 = ");" + NL + "            isStructError_";
  protected final String TEXT_243 = " = false;" + NL + "        } catch (java.lang.Exception ex) {";
  protected final String TEXT_244 = NL + "        } finally {" + NL + "            try {" + NL + "                baos_";
  protected final String TEXT_245 = ".close();" + NL + "                if (bais_";
  protected final String TEXT_246 = " != null) {" + NL + "                    bais_";
  protected final String TEXT_247 = ".close();" + NL + "                }" + NL + "            } catch (IOException e) {";
  protected final String TEXT_248 = NL + "                    throw new  java.io.IOException(e.getMessage());";
  protected final String TEXT_249 = NL + "                    System.err.println(e.getMessage());";
  protected final String TEXT_250 = NL + "            }" + NL + "        }";
  protected final String TEXT_251 = NL + "        xTmp_";
  protected final String TEXT_252 = " = temp_";
  protected final String TEXT_253 = ".createXPath(";
  protected final String TEXT_254 = ");" + NL + "        xTmp_";
  protected final String TEXT_255 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_256 = ");" + NL;
  protected final String TEXT_257 = NL + "            obj_";
  protected final String TEXT_258 = " = xTmp_";
  protected final String TEXT_259 = ".evaluate(temp_";
  protected final String TEXT_260 = ");" + NL + "            if (obj_";
  protected final String TEXT_261 = " instanceof String || obj_";
  protected final String TEXT_262 = " instanceof Number) {" + NL + "                node_";
  protected final String TEXT_263 = " = temp_";
  protected final String TEXT_264 = ";" + NL + "                str_";
  protected final String TEXT_265 = " = String.valueOf(obj_";
  protected final String TEXT_266 = ");" + NL + "            } else {" + NL + "                node_";
  protected final String TEXT_267 = " = xTmp_";
  protected final String TEXT_268 = ".selectSingleNode(temp_";
  protected final String TEXT_269 = ");";
  protected final String TEXT_270 = NL + "                    if (node_";
  protected final String TEXT_271 = " == null) {" + NL + "                        str_";
  protected final String TEXT_272 = " = null;" + NL + "                    } else {" + NL + "                        str_";
  protected final String TEXT_273 = " = originalJSONString_";
  protected final String TEXT_274 = ".getOriginalJSONString(node_";
  protected final String TEXT_275 = ".asXML(), cjs_";
  protected final String TEXT_276 = ".getAdditionRoot(), ";
  protected final String TEXT_277 = ", ";
  protected final String TEXT_278 = ");" + NL + "                    }";
  protected final String TEXT_279 = NL + "                    str_";
  protected final String TEXT_280 = " = xTmp_";
  protected final String TEXT_281 = ".valueOf(temp_";
  protected final String TEXT_282 = ");";
  protected final String TEXT_283 = NL + "            }";
  protected final String TEXT_284 = NL + "                xmlStrTemp_";
  protected final String TEXT_285 = " = \"\";" + NL + "                for (Object tempNode_";
  protected final String TEXT_286 = " : xTmp_";
  protected final String TEXT_287 = ".selectNodes(temp_";
  protected final String TEXT_288 = ")) {" + NL + "                    node_";
  protected final String TEXT_289 = " = (org.dom4j.Node)tempNode_";
  protected final String TEXT_290 = ";" + NL + "                    xmlStrTemp_";
  protected final String TEXT_291 = " += node_";
  protected final String TEXT_292 = ".asXML();" + NL + "                }" + NL + "                if(\"\".equals(xmlStrTemp_";
  protected final String TEXT_293 = ")) {" + NL + "                    str_";
  protected final String TEXT_294 = " = null;" + NL + "                } else {" + NL + "                    str_";
  protected final String TEXT_295 = " = originalJSONString_";
  protected final String TEXT_296 = ".getOriginalJSONString(xmlStrTemp_";
  protected final String TEXT_297 = ",cjs_";
  protected final String TEXT_298 = ".getAdditionRoot(),";
  protected final String TEXT_299 = ",";
  protected final String TEXT_300 = ", true);" + NL + "                }";
  protected final String TEXT_301 = NL + "                xmlListTemp_";
  protected final String TEXT_302 = " = new java.util.ArrayList<String>();" + NL + "                for(Object tempNode_";
  protected final String TEXT_303 = " : xTmp_";
  protected final String TEXT_304 = ".selectNodes(temp_";
  protected final String TEXT_305 = ")) {" + NL + "                    xmlListTemp_";
  protected final String TEXT_306 = ".add(((org.dom4j.Node)tempNode_";
  protected final String TEXT_307 = ").getStringValue());" + NL + "                }";
  protected final String TEXT_308 = NL + "                    ";
  protected final String TEXT_309 = NL + "                            if (xml_api_";
  protected final String TEXT_310 = ".isDefNull(node_";
  protected final String TEXT_311 = ")) {";
  protected final String TEXT_312 = NL + "                                ";
  protected final String TEXT_313 = NL + "                            } else if (xml_api_";
  protected final String TEXT_314 = ".isEmpty(node_";
  protected final String TEXT_315 = ")) {";
  protected final String TEXT_316 = NL + "                                ";
  protected final String TEXT_317 = NL + "                            } else if (xml_api_";
  protected final String TEXT_318 = ".isMissing(node_";
  protected final String TEXT_319 = ")) {";
  protected final String TEXT_320 = NL + "                                ";
  protected final String TEXT_321 = NL + "                            } else {";
  protected final String TEXT_322 = NL + "                            if (xml_api_";
  protected final String TEXT_323 = ".isEmpty(node_";
  protected final String TEXT_324 = ")) {";
  protected final String TEXT_325 = NL + "                                ";
  protected final String TEXT_326 = NL + "                            } else if(xml_api_";
  protected final String TEXT_327 = ".isMissing(node_";
  protected final String TEXT_328 = ")) {";
  protected final String TEXT_329 = NL + "                                ";
  protected final String TEXT_330 = NL + "                            } else {";
  protected final String TEXT_331 = NL + "                            if(xml_api_";
  protected final String TEXT_332 = ".isDefNull(node_";
  protected final String TEXT_333 = ")) {";
  protected final String TEXT_334 = NL + "                                ";
  protected final String TEXT_335 = NL + "                            } else if (xml_api_";
  protected final String TEXT_336 = ".isEmpty(node_";
  protected final String TEXT_337 = ") || xml_api_";
  protected final String TEXT_338 = ".isMissing(node_";
  protected final String TEXT_339 = ")) {";
  protected final String TEXT_340 = NL + "                                ";
  protected final String TEXT_341 = NL + "                            } else {";
  protected final String TEXT_342 = NL + "                            if (xml_api_";
  protected final String TEXT_343 = ".isMissing(node_";
  protected final String TEXT_344 = ") || xml_api_";
  protected final String TEXT_345 = ".isEmpty(node_";
  protected final String TEXT_346 = ")) {";
  protected final String TEXT_347 = NL + "                                 ";
  protected final String TEXT_348 = NL + "                            } else {";
  protected final String TEXT_349 = NL + "                        ";
  protected final String TEXT_350 = NL + "                            ";
  protected final String TEXT_351 = NL + "                            ";
  protected final String TEXT_352 = NL + "                            ";
  protected final String TEXT_353 = " } ";
  protected final String TEXT_354 = NL + "                    if (xmlListTemp_";
  protected final String TEXT_355 = ".isEmpty()) {";
  protected final String TEXT_356 = NL + "                        ";
  protected final String TEXT_357 = NL + "                    } else {";
  protected final String TEXT_358 = NL + "                            ";
  protected final String TEXT_359 = NL + "                            ";
  protected final String TEXT_360 = NL + "                    }";
  protected final String TEXT_361 = NL + "            ";
  protected final String TEXT_362 = NL + "            // Die immediately on errors." + NL + "            throw new IOException(";
  protected final String TEXT_363 = ");";
  protected final String TEXT_364 = NL + "                // Ignore errors processing this row and move to the next.";
  protected final String TEXT_365 = NL + "                // Send error rows to the reject output.";
  protected final String TEXT_366 = NL + "                ";
  protected final String TEXT_367 = NL + "                    ";
  protected final String TEXT_368 = NL + "                ";
  protected final String TEXT_369 = NL + "                ";
  protected final String TEXT_370 = NL + "       class JsonPathCache_";
  protected final String TEXT_371 = " {" + NL + "           final java.util.Map<String, com.jayway.jsonpath.JsonPath> jsonPathString2compiledJsonPath = new java.util.HashMap<String, com.jayway.jsonpath.JsonPath>();" + NL + "" + NL + "           public com.jayway.jsonpath.JsonPath getCompiledJsonPath(" + NL + "                   String jsonPath) {" + NL + "               if (jsonPathString2compiledJsonPath" + NL + "                       .containsKey(jsonPath)) {" + NL + "                   return jsonPathString2compiledJsonPath" + NL + "                           .get(jsonPath);" + NL + "               } else {" + NL + "                   com.jayway.jsonpath.JsonPath compiledLoopPath = com.jayway.jsonpath.JsonPath" + NL + "                           .compile(jsonPath);" + NL + "                   jsonPathString2compiledJsonPath.put(jsonPath," + NL + "                           compiledLoopPath);" + NL + "                   return compiledLoopPath;" + NL + "               }" + NL + "           }" + NL + "       }";
  protected final String TEXT_372 = NL + "        JsonPathCache_";
  protected final String TEXT_373 = " jsonPathCache_";
  protected final String TEXT_374 = " = new JsonPathCache_";
  protected final String TEXT_375 = "();" + NL + "" + NL + "        String loopPath_";
  protected final String TEXT_376 = " = ";
  protected final String TEXT_377 = ";" + NL + "        java.util.List<Object> resultset_";
  protected final String TEXT_378 = " = new java.util.ArrayList<Object>();" + NL + "        String jsonStr_";
  protected final String TEXT_379 = " = (String) ";
  protected final String TEXT_380 = ";" + NL + "" + NL + "        boolean isStructError_";
  protected final String TEXT_381 = " = true;" + NL + "        try {" + NL + "            com.jayway.jsonpath.ReadContext document_";
  protected final String TEXT_382 = " = com.jayway.jsonpath.JsonPath.parse(jsonStr_";
  protected final String TEXT_383 = ");" + NL + "            com.jayway.jsonpath.JsonPath compiledLoopPath_";
  protected final String TEXT_384 = " = jsonPathCache_";
  protected final String TEXT_385 = ".getCompiledJsonPath(loopPath_";
  protected final String TEXT_386 = ");" + NL + "            Object result_";
  protected final String TEXT_387 = " = document_";
  protected final String TEXT_388 = ".read(compiledLoopPath_";
  protected final String TEXT_389 = ");" + NL + "            if (result_";
  protected final String TEXT_390 = " instanceof net.minidev.json.JSONArray) {" + NL + "                resultset_";
  protected final String TEXT_391 = " = (net.minidev.json.JSONArray) result_";
  protected final String TEXT_392 = ";" + NL + "            } else {" + NL + "                resultset_";
  protected final String TEXT_393 = ".add(result_";
  protected final String TEXT_394 = ");" + NL + "            }" + NL + "" + NL + "            isStructError_";
  protected final String TEXT_395 = " = false;" + NL + "        } catch (java.lang.Exception ex_";
  protected final String TEXT_396 = ") {";
  protected final String TEXT_397 = NL + "        }" + NL + "" + NL + "        String jsonPath_";
  protected final String TEXT_398 = " = null;" + NL + "        com.jayway.jsonpath.JsonPath compiledJsonPath_";
  protected final String TEXT_399 = " = null;" + NL + "" + NL + "        Object currentValue_";
  protected final String TEXT_400 = " = null;" + NL + "" + NL + "        for(int i_";
  protected final String TEXT_401 = "=0; isStructError_";
  protected final String TEXT_402 = " || (i_";
  protected final String TEXT_403 = " < resultset_";
  protected final String TEXT_404 = ".size());i_";
  protected final String TEXT_405 = "++){" + NL + "            if(!isStructError_";
  protected final String TEXT_406 = "){" + NL + "                Object row_";
  protected final String TEXT_407 = " = resultset_";
  protected final String TEXT_408 = ".get(i_";
  protected final String TEXT_409 = ");";
  protected final String TEXT_410 = NL + "                    ";
  protected final String TEXT_411 = " = new ";
  protected final String TEXT_412 = "();";
  protected final String TEXT_413 = NL + "                    ";
  protected final String TEXT_414 = " = new ";
  protected final String TEXT_415 = "();";
  protected final String TEXT_416 = NL + "                try {";
  protected final String TEXT_417 = NL + "                            jsonPath_";
  protected final String TEXT_418 = " = ";
  protected final String TEXT_419 = ";" + NL + "                            compiledJsonPath_";
  protected final String TEXT_420 = " = jsonPathCache_";
  protected final String TEXT_421 = ".getCompiledJsonPath(jsonPath_";
  protected final String TEXT_422 = ");" + NL + "" + NL + "                            try {" + NL + "                                currentValue_";
  protected final String TEXT_423 = " = compiledJsonPath_";
  protected final String TEXT_424 = ".read(row_";
  protected final String TEXT_425 = ");";
  protected final String TEXT_426 = NL + "                                    if (currentValue_";
  protected final String TEXT_427 = " == null) {";
  protected final String TEXT_428 = NL + "                                            ";
  protected final String TEXT_429 = NL + "                                            ";
  protected final String TEXT_430 = NL + "                                            ";
  protected final String TEXT_431 = NL + "                                    } else {";
  protected final String TEXT_432 = NL + "                                        ";
  protected final String TEXT_433 = NL + "                                    }";
  protected final String TEXT_434 = NL + "                                    if(currentValue_";
  protected final String TEXT_435 = " != null && !currentValue_";
  protected final String TEXT_436 = ".toString().isEmpty()) {";
  protected final String TEXT_437 = NL + "                                            ";
  protected final String TEXT_438 = NL + "                                            ";
  protected final String TEXT_439 = NL + "                                            ";
  protected final String TEXT_440 = NL + "                                            ";
  protected final String TEXT_441 = NL + "                                    } else {";
  protected final String TEXT_442 = NL + "                                            ";
  protected final String TEXT_443 = NL + "                                            ";
  protected final String TEXT_444 = NL + "                                            ";
  protected final String TEXT_445 = NL + "                                    }";
  protected final String TEXT_446 = NL + "                            } catch (com.jayway.jsonpath.PathNotFoundException e_";
  protected final String TEXT_447 = ") {";
  protected final String TEXT_448 = NL + "                                    ";
  protected final String TEXT_449 = NL + "                                    ";
  protected final String TEXT_450 = NL + "                                    ";
  protected final String TEXT_451 = NL + "                            }";
  protected final String TEXT_452 = NL + "                        ";
  protected final String TEXT_453 = NL + "                        ";
  protected final String TEXT_454 = NL + "                    ";
  protected final String TEXT_455 = NL + "                } catch (java.lang.Exception ex_";
  protected final String TEXT_456 = ") {";
  protected final String TEXT_457 = NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_458 = NL + "            ";
  protected final String TEXT_459 = NL + "            // Die immediately on errors." + NL + "            throw new IOException(";
  protected final String TEXT_460 = ");";
  protected final String TEXT_461 = NL + "                // Ignore errors processing this row and move to the next.";
  protected final String TEXT_462 = NL + "                // Send error rows to the reject output.";
  protected final String TEXT_463 = NL + "                ";
  protected final String TEXT_464 = NL + "                    ";
  protected final String TEXT_465 = NL + "                ";
  protected final String TEXT_466 = NL + "                ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
	//need to define MapperHelper before MapperGenerator, so use this trick
	class MapperHelperBase{
		public void map(){
		}

		public void prepare(){
		}

		public void configure(){
		}

		public void close(){
		}
	}

	class MapperGenerator{
		MapperHelperBase mapper;

		org.talend.core.model.process.AbstractNode node = null;
		String cid = null;
		String mapperClass = null;

		Object inKey = null;
		Object inKeyClass = null;

		Object inValue = null;
		Object inValueClass = null;

		Object outKey = null;
		Object outKeyClass = null;

		Object outValue = null;
		Object outValueClass = null;

		public MapperGenerator(MapperHelperBase mapper){
			this.mapper = mapper;
		}

		public void init(INode node, String cid, Object inKey, Object inValue, Object outKey, Object outValue){
			this.node = (org.talend.core.model.process.AbstractNode)node;
			this.cid = cid;
			this.inKey = (inKey == null ? "key_"+cid : inKey);
			this.inValue = (inValue == null ? "value_"+cid : inValue);
			this.outKey = (outKey == null ? "outputKey_"+cid : outKey);
			this.outValue = (outValue == null ? "outputValue_"+cid : outValue);
			this.mapperClass = buildClassName(cid, "m");
			this.inKeyClass = buildClassName(inKey, "row");
			this.inValueClass = buildClassName(inValue, "row");
			this.outKeyClass = buildClassName(outKey, "row");
			this.outValueClass = buildClassName(outValue, "row");
		}

		private String buildClassName(String name, String type){
			if(type.equals("m")){
				return name + "Mapper";
			}else if(type.equals("r")){
				return name + "Reducer";
			}else if(type.equals("row")){
				return name + "Struct";
			}else{
				return null;
			}
		}

		private Object buildClassName(Object name, String type){
			if(type.equals("row")){
				if(name instanceof java.util.Map){
					java.util.Map<String, String> classes = new java.util.HashMap<String, String>();
					java.util.Map<String, String> names = (java.util.Map<String, String>)name;
					for(String key : names.keySet()){
						classes.put(key, buildClassName(names.get(key), "row"));
					}
					return classes;
				}else if(name instanceof String){
					return buildClassName(name.toString(), "row");
				}else if(name == null){
					return "NullWritable";
				}
			}
			return null;
		}

		public String getInKeyClass(String name){
			if(inKeyClass instanceof java.util.Map){
				return ((java.util.Map<String, String>)inKeyClass).get(name);
			}
			return getInKeyClass();
		}

		public String getInKeyClass(){
			if(inKeyClass instanceof String){
				return inKeyClass.toString();
			}else{
				System.err.println("not single, wrong call");
				return null;
			}
		}

		public String getInKey(String name){
			if(inKey instanceof java.util.Map){
				return ((java.util.Map<String, String>)inKey).get(name);
			}
			return getInKey();
		}

		public String getInKey(){
			if(inKey instanceof String){
				return inKey.toString();
			}else{
				System.err.println("not single, wrong call");
				return null;
			}
		}

		public String getOutKeyClass(String name){
			if(outKeyClass instanceof java.util.Map){
				return ((java.util.Map<String, String>)outKeyClass).get(name);
			}
			return getOutKeyClass();
		}

		public String getOutKeyClass(){
			if(outKeyClass instanceof String){
				return outKeyClass.toString();
			}else{
				System.err.println("not single, wrong call");
				return null;
			}
		}

		public String getOutKey(String name){
			if(outKey instanceof java.util.Map){
				return ((java.util.Map<String, String>)outKey).get(name);
			}
			return getOutKey();
		}

		public String getOutKey(){
			if(outKey instanceof String){
				return outKey.toString();
			}else{
				System.err.println("not single, wrong call");
				return null;
			}
		}

		public String getInValueClass(String name){
			if(inValueClass instanceof java.util.Map){
				return ((java.util.Map<String, String>)inValueClass).get(name);
			}
			return getInValueClass();
		}

		public String getInValueClass(){
			if(inValueClass instanceof String){
				return inValueClass.toString();
			}else{
				System.err.println("not single, wrong call");
				return null;
			}
		}

		public String getInValue(String name){
			if(inValue instanceof java.util.Map){
				return ((java.util.Map<String, String>)inValue).get(name);
			}
			return getInValue();
		}

		public String getInValue(){
			if(inValue instanceof String){
				return inValue.toString();
			}else{
				System.err.println("not single, wrong call");
				return null;
			}
		}

		public String getOutValueClass(String name){
			if(outValueClass instanceof java.util.Map){
				return ((java.util.Map<String, String>)outValueClass).get(name);
			}
			return getOutValueClass();
		}

		public String getOutValueClass(){
			if(outValueClass instanceof String){
				return outValueClass.toString();
			}else{
				System.err.println("not single, wrong call");
				return null;
			}
		}

		public String getOutValue(String name){
			if(outValue instanceof java.util.Map){
				return ((java.util.Map<String, String>)outValue).get(name);
			}
			return getOutValue();
		}

		public String getOutValue(){
			if(outValue instanceof String){
				return outValue.toString();
			}else{
				System.err.println("not single, wrong call");
				return null;
			}
		}

		public void output(String outKey, String outValue){
			outKey = (outKey == null ? "outputKey_"+cid : outKey);
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(outValue);
    stringBuffer.append(TEXT_6);
    
		}

		public String getCodeEmit(String outKey, String outValue) {
			return "output_" + cid + ".collect("
					+ (outKey == null ? "outputKey_"+cid : outKey) + ","
					+ outValue + ");";
		}

		public void generate(){
		
    stringBuffer.append(TEXT_7);
    stringBuffer.append(mapperClass);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_14);
    if(!outKey.equals(outValue)){//for tFindQuantiles, if outKey same as outValue, assume the write want to reuse same object
    stringBuffer.append(TEXT_15);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(outValue);
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    mapper.prepare();
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    if("NullWritable".equals(outKeyClass)){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_24);
    }else{
    stringBuffer.append(TEXT_25);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    if(!outKey.equals(outValue)){
    stringBuffer.append(TEXT_29);
    stringBuffer.append(outValue);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    mapper.configure();
    stringBuffer.append(TEXT_33);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    mapper.map();
    stringBuffer.append(TEXT_42);
    mapper.close();
    stringBuffer.append(TEXT_43);
    
		}
		public void generateConf(){
			if(node.isMapOnlyAfterReduce()){
			
    stringBuffer.append(TEXT_44);
    stringBuffer.append(mapperClass);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_49);
    
			}else{
			
    stringBuffer.append(TEXT_50);
    stringBuffer.append(mapperClass);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_55);
    
			}
		}

		public void generateConf(org.talend.core.model.process.IConnection inConn){
			String startNodeCid = inConn.getSource().getSubProcessStartNode(false).getUniqueName();
			
    stringBuffer.append(TEXT_56);
    stringBuffer.append(startNodeCid);
    stringBuffer.append(TEXT_57);
    
			generateConf();
		}
	}

	class MOMapperGenerator extends MapperGenerator{

		/** The single connection to pass along the output chain of Mappers
		 *  instead of sending to a dedicated collector via MultipleOutputs. */
		String connectionToChain = null;

		public MOMapperGenerator(MapperHelperBase mapper){
			super(mapper);
		}

		public void sendOutConnectionToChain(String name) {
			connectionToChain = getOutValue(name);
		}

		public void output(String outKey, String outValue){
			outKey = (outKey == null ? "outputKey_"+cid : outKey);
			if (outValue != null && outValue.equals(connectionToChain))
				super.output(outKey, outValue);
			else {
				
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(outValue);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(outValue);
    stringBuffer.append(TEXT_63);
    
			}
		}

		public String getCodeEmit(String outKey, String outValue) {
			if (outValue != null && outValue.equals(connectionToChain))
				return super.getCodeEmit(outKey, outValue);
			else
				return "mos_" + cid + ".getCollector(\"" + outValue
						+ "\", reporter_"+ cid + ")"+ ".collect("
						+ (outKey == null ? "outputKey_"+cid : outKey) + ","
						+ outValue + ");";
		}

		public void generate(){
		
    stringBuffer.append(TEXT_64);
    stringBuffer.append(mapperClass);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_71);
    
				if(outValueClass instanceof java.util.Map){
					for(String key : ((java.util.Map<String, String>)outValueClass).keySet()){
					
    stringBuffer.append(TEXT_72);
    stringBuffer.append(((java.util.Map)outValueClass).get(key));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(((java.util.Map)outValue).get(key));
    stringBuffer.append(TEXT_74);
    
					}
				}
				
    stringBuffer.append(TEXT_75);
    mapper.prepare();
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
    if("NullWritable".equals(outKeyClass)){
    stringBuffer.append(TEXT_82);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_83);
    }else{
    stringBuffer.append(TEXT_84);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_86);
    }
    stringBuffer.append(TEXT_87);
    
					if(outValueClass instanceof java.util.Map){
						for(String key : ((java.util.Map<String, String>)outValueClass).keySet()){
						
    stringBuffer.append(TEXT_88);
    stringBuffer.append(((java.util.Map)outValue).get(key));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(((java.util.Map)outValueClass).get(key));
    stringBuffer.append(TEXT_90);
    
						}
					}
					
    stringBuffer.append(TEXT_91);
    mapper.configure();
    stringBuffer.append(TEXT_92);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    mapper.map();
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    mapper.close();
    stringBuffer.append(TEXT_102);
    
		}
		public void generateConf(){
			if(node.isMapOnlyAfterReduce()){
			
    stringBuffer.append(TEXT_103);
    stringBuffer.append(mapperClass);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_107);
    
			}else{
			
    stringBuffer.append(TEXT_108);
    stringBuffer.append(mapperClass);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_112);
    
			}
			
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
        	java.util.Map<String, String> values = (java.util.Map<String, String>)outValue;
        	for(String key : values.keySet()){
        	
    stringBuffer.append(TEXT_115);
    stringBuffer.append(values.get(key));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(getOutValueClass(key));
    stringBuffer.append(TEXT_118);
    
        	}
		}
	}

	final String M_TYPE_BASE = "base";
	final String M_TYPE_MO = "mo";

	class MapperHelper extends MapperHelperBase{

		MapperGenerator mapperGen;

		String cid = null;

		public void setType(String type){
			if(type.equals(M_TYPE_BASE)){
				mapperGen = new MapperGenerator(this);
			}else if(type.equals(M_TYPE_MO)){
				mapperGen = new MOMapperGenerator(this);
			}
		}

		public void init(INode node, String cid, String inKey, String inValue, String outKey, Object outValue){
			if(mapperGen == null){
				mapperGen = new MapperGenerator(this);
			}
			mapperGen.init(node, cid, inKey, inValue, outKey, outValue);
			this.cid = mapperGen.cid;
		}

		public String getInKeyClass(String name){
			return mapperGen.getInKeyClass(name);
		}

		public String getInKeyClass(){
			return mapperGen.getInKeyClass();
		}

		public String getInKey(String name){
			return mapperGen.getInKey(name);
		}

		public String getInKey(){
			return mapperGen.getInKey();
		}

		public String getOutKeyClass(String name){
			return mapperGen.getOutKeyClass(name);
		}

		public String getOutKeyClass(){
			return mapperGen.getOutKeyClass();
		}

		public String getOutKey(String name){
			return mapperGen.getOutKey(name);
		}

		public String getOutKey(){
			return mapperGen.getOutKey();
		}

		public String getInValueClass(String name){
			return mapperGen.getInValueClass(name);
		}

		public String getInValueClass(){
			return mapperGen.getInValueClass();
		}

		public String getInValue(String name){
			return mapperGen.getInValue(name);
		}

		public String getInValue(){
			return mapperGen.getInValue();
		}

		public String getOutValueClass(String name){
			return mapperGen.getOutValueClass(name);
		}

		public String getOutValueClass(){
			return mapperGen.getOutValueClass();
		}

		public String getOutValue(String name){
			return mapperGen.getOutValue(name);
		}

		public String getOutValue(){
			return mapperGen.getOutValue();
		}

		/**
		 * In the case where the underlying implementation supports multiple
		 * outputs, this causes the named output to be passed along the chain
		 * of mapper tasks instead of using the MultipleOutputs object.
		 */
		public void sendOutConnectionToChain(String name) {
			if (mapperGen instanceof MOMapperGenerator)
				((MOMapperGenerator)mapperGen).sendOutConnectionToChain(name);
		}

		public void output(String outKey, String outValue){
			mapperGen.output(outKey, outValue);
		}

		public String getCodeEmit(String outKey, String outValue){
			return mapperGen.getCodeEmit(outKey, outValue);
		}

		public void generate(){
			mapperGen.generate();
		}

		public void generateConf(){
			mapperGen.generateConf();
		}

		public void generateConf(org.talend.core.model.process.IConnection inConn){
			mapperGen.generateConf(inConn);
		}

		public void map(){
		}

		public void prepare(){
		}

		public void configure(){
		}

		public void close(){
		}
	}
	
    

/**
 * The following imports must occur before importing this file:
 * @ include file="@{org.talend.designer.components.mrprovider}/resources/utils/common_codegen_util.javajet"
 */
class MrMapperRowTransformUtil extends org.talend.designer.common.CommonRowTransformUtil {
    /** Must be set to provide a Mapper context to this tool. */
    public MapperHelper helper;

    public String getCodeToGetInField(String columnName) {
        return helper.getInValue() + "." + columnName;
    }
    public String getInValue() {
        return helper.getInValue();
    }
    
    /** Not used in MR, but had to implement it so it returns null*/
    public String getOutValue(){
        return null;
    }

    public String getInValueClass() {
        return helper.getInValueClass();
    }
    
    /** Not used in MR, but had to implement it so it returns null*/
    public String getOutValueClass() {
        return null;
    }

    public String getCodeToGetOutField(boolean isReject, String columnName) {
        return helper.getOutValue(isReject ? "reject" : "main") + "." + columnName;
    }

    public String getCodeToSetOutField(boolean isReject, String columnName, String codeValue) {
        return helper.getOutValue(isReject ? "reject" : "main") + "." + columnName + " = " + codeValue + ";";
    }


    public String getCodeToSetOutField(boolean isReject, String columnName, String codeValue, String operator) {
        return helper.getOutValue(isReject ? "reject" : "main") + "." + columnName + " = " + codeValue + ";";
    }


    public String getCodeToEmit(boolean isReject) {
        return helper.getCodeEmit(null, helper.getOutValue(isReject ? "reject" : "main"));
    }

    /**
     * Generates a Mapper that is typically correct for the given
     * TransformerBase.  This is a shortcut for many use cases, but not
     * mandatory.
     */
    public void generateMrCode(final org.talend.designer.common.TransformerBase transformer) {

        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    
            return;
        }

        // Use a MapperHelper base that has been tied into the transformer.
        class Mapper extends MapperHelper {

            public void prepare() {
                transformer.generateHelperClasses(false);
                transformer.generateTransformContextDeclaration();
            }

            public void configure() {
                transformer.generateTransformContextInitialization();
            }

            public void map() {
                
    stringBuffer.append(TEXT_120);
    stringBuffer.append(getInValueClass());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
                transformer.generateTransform();
            }
        }

        Mapper mapper = new Mapper();
        this.helper = mapper;

        if (transformer.isMultiOutput()) {
            // The multi-output condition is slightly different, and the
            // MapperHelper is configured with internal names for the
            // connections.
            mapper.setType(M_TYPE_MO);
            java.util.HashMap<String, String> names = new java.util.HashMap<String, String>();
            names.put("main", transformer.getOutConnMainName());
            names.put("reject", transformer.getOutConnRejectName());
            mapper.init(node, cid, null, transformer.getInConnName(), null,
                    names);
            // When there is more than one output, the main output continues
            // along the chain, and the reject output is sent to a secondary
            // file.
            mapper.sendOutConnectionToChain("main");
        } else {
            mapper.init(node, cid, null, transformer.getInConnName(), null,
                    transformer.getOutConnMainName() != null
                            ? transformer.getOutConnMainName()
                            : transformer.getOutConnRejectName());
        }

        // Use the configured mapper helper to create the Mapper MR_CODE
        mapper.generate();
    }


    public void generateMrConfig(final org.talend.designer.common.TransformerBase transformer,
            String inputMapperClass) {

        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    
            return;
        }

        // The connection that contains rows to be passed along the chain.  At
        // least one of these is guaranteed to be present.
        IConnection chained = transformer.getOutConnMain() != null
                ? transformer.getOutConnMain() : transformer.getOutConnReject();

        
    stringBuffer.append(TEXT_125);
    stringBuffer.append(inputMapperClass);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(transformer.getInConnName());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(chained.getName());
    stringBuffer.append(TEXT_128);
    
        // If multiple outputs, the rejected output is guaranteed to be on a
        // multiple outputs.
        if (transformer.isMultiOutput()) {
            String shortCid = cid.replaceAll("_Out", "").replaceAll("_In", "");
            
    stringBuffer.append(TEXT_129);
    stringBuffer.append(shortCid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(transformer.getOutConnRejectName());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(transformer.getOutConnRejectName());
    stringBuffer.append(TEXT_132);
    
        }
    }
}

    

/**
 * Contains common processing for tExtractJSONFields code generation.  This is
 * used in MapReduce and Storm components.
 *
 * The following imports must occur before importing this file:
 * @ include file="@{org.talend.designer.components.mrprovider}/resources/utils/common_codegen_util.javajet"
 */
class TExtractJSONWithXMLFieldsUtil extends org.talend.designer.common.TransformerBase {

    // TODO: what happens when these are input column names?
    final private static String REJECT_MSG = "errorMessage";
    final private static String REJECT_CODE = "errorCode";
    final private static String REJECT_FIELD = "errorJSONField";

    final private String field = ElementParameterParser.getValue(node, "__JSONFIELD__");
    final private String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__");
    final private String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    final private java.util.List<java.util.Map<String, String>> mappings = (java.util.List<java.util.Map<String,String>>)
            ElementParameterParser.getObjectValue(node, "__MAPPING__");
    final private boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    /** The outgoing connection contains the column {@link #REJECT_FIELD}.
     *  If we import a job from a DI job, this column will be missing */
    final private Boolean containsRejectField;

    /** The list of columns that should be copied directly from the input to
     *  the output schema (where they have the same column names). */
    final private java.util.List<IMetadataColumn> copiedInColumns;

    /** Columns in the output schema that are not copied directly from the
     *  input schema (excluding reject fields). */
    final private java.util.List<IMetadataColumn> newOutColumns;

    /** True if any of the extract mappings has the "NODECHECK" parameter

    /** True if any of the extract mappings has the "NODECHECK" parameter
     *  checked. */
    // TODO document
    final private boolean hasNodeCheck;

    public TExtractJSONWithXMLFieldsUtil(INode node,
            org.talend.designer.common.BigDataCodeGeneratorArgument argument,
            org.talend.designer.common.CommonRowTransformUtil rowTransformUtil) {
        super(node, argument, rowTransformUtil, "FLOW", "REJECT");

        containsRejectField = hasOutputColumn(true, REJECT_FIELD);

        if (null != getInConn() && null != getOutConnMain()) {
            copiedInColumns = getColumnsUnion(getInColumns(), getOutColumnsMain());
            newOutColumns = getColumnsDiff(getOutColumnsMain(), getInColumns());
        } else if (null != getInConn() && null != getOutConnReject()) {
            copiedInColumns = getColumnsUnion(getInColumns(), getOutColumnsReject());
            // If only the reject output is used, the new columns are those that
            // are not part of the main schema (ignore the REJECT_XXX columns).
            java.util.List<IMetadataColumn> mainCols = getColumnsDiff(
                    getOutColumnsReject(), getColumns(getOutColumnsReject(),
                            REJECT_FIELD, REJECT_CODE, REJECT_MSG));
            newOutColumns = getColumnsDiff(mainCols, getInColumns());
        } else {
            copiedInColumns = null;
            newOutColumns = null;
        }

        // Examine the configured mapping to see if node checks are necessary
        // and unused input columns.
        boolean hasNodeCheckTemp = false;
        for (java.util.Map<String, String> mapping : mappings) {
            boolean nodeCheck = "true".equals(mapping.get("NODECHECK"));
            String query = mapping.get("QUERY");
            String columnName = mapping.get("SCHEMA_COLUMN");
            if (nodeCheck) {
                hasNodeCheckTemp = true;
            }
            // Any output columns that have a query attached must be in the
            // newOutColumns list.
            if (query != null && query.trim().length() != 0) {
                for (IMetadataColumn column : new java.util.ArrayList<IMetadataColumn>(copiedInColumns)) {
                    if (column.getLabel().compareTo(columnName) == 0) {
                        copiedInColumns.remove(column);
                        newOutColumns.add(column);
                    }
                }
             }
        }
        // TODO: is this necessary?
        hasNodeCheck = hasNodeCheckTemp;
    }

    /**
     * Generates all of the helper classes necessary to implement this node.
     */
    public void generateHelperClasses(boolean isStatic) {
        // TODO: these could be shared between all json nodes.
        generateClassConvertJSONString(isStatic);
        if (hasNodeCheck)
            generateClassOriginalJSONString(isStatic);
        generateClassXmlApi(isStatic);
    }

    private void generateClassConvertJSONString(boolean isStatic) {
    // Start generating code for ConvertJSONString_cid class.
    
    stringBuffer.append(TEXT_133);
    stringBuffer.append(isStatic ? "static" : "");
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
        // End generated code for ConvertJSONString_cid
    }

    private void generateClassOriginalJSONString(boolean isStatic) {
    // Start generating code for OriginalJSONString_cid class.
    
    stringBuffer.append(TEXT_136);
    stringBuffer.append(isStatic ? "static" : "");
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
        // End generated code for OriginalJSONString_cid class
    }

    private void generateClassXmlApi(boolean isStatic) {
    // Start generating code for XML_API_cid class.
    
    stringBuffer.append(TEXT_139);
    stringBuffer.append(isStatic ? "static" : "");
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
        // End generated code for XML_API_cid class
    }

    public void generateTransformContextDeclaration() {
    
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
     if (hasNodeCheck) { 
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
     } 
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
    }

    public void generateTransformContextInitialization() {
        
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
     if (hasNodeCheck) { 
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
     } 
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
    }


    public void generateTransform() {
        generateTransform(false);
    }

    /**
     * Generates code that performs the tranformation from one JSON input string
     * to many output strings, or to a reject flow.
     */
    public void generateTransform(boolean hasAReturnedType) {
        // variables used throughout the transform scope of the generated code.
        
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
        generateTransformParseJsonInputField();
        // After this call, the isStructError_cid member is false if the json
        // input was correctly parsed into the common structures.
        
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
                if (getOutConnMain() != null) {
                    
    stringBuffer.append(TEXT_198);
    stringBuffer.append(getOutConnMain().getName());
    stringBuffer.append(TEXT_199);
    stringBuffer.append(codeGenArgument.getRecordStructName(getOutConnMain()));
    stringBuffer.append(TEXT_200);
    
                } else {
                    
    stringBuffer.append(TEXT_201);
    stringBuffer.append(getOutConnReject().getName());
    stringBuffer.append(TEXT_202);
    stringBuffer.append(codeGenArgument.getRecordStructName(getOutConnReject()));
    stringBuffer.append(TEXT_203);
    
                }
                
    stringBuffer.append(TEXT_204);
    
                    MAPPING: for (java.util.Map<String, String> mapping : mappings) {
                        String columnName = mapping.get("SCHEMA_COLUMN");
                        for (IMetadataColumn col : copiedInColumns)
                            if (col.getLabel().equals(columnName))
                                continue MAPPING;
                        generateTransformForMapping("true".equals(mapping.get("NODECHECK")),
                            "true".equals(mapping.get("ISARRAY")),
                            mapping.get("QUERY"),
                            columnName);
                    }
                    if (null != getOutConnMain()) {
                        
    stringBuffer.append(TEXT_205);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(false, copiedInColumns));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(getRowTransform().getCodeToEmit(false));
    
                    }
                    
    stringBuffer.append(TEXT_207);
    
                    generateTransformReject(dieOnError, "ex", null, "originalJsonStr_"+cid);
                    
    stringBuffer.append(TEXT_208);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(getRowTransform().getCodeToInitOut(null == getOutConnMain(), newOutColumns));
    stringBuffer.append(TEXT_210);
    
    }


    /**
     * Part of the code generation for parsing the input field into several of
     * the variables that are used to generate output.
     */
    private void generateTransformParseJsonInputField() {
        // Parse the structure.
        
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    
            generateTransformReject(dieOnError, "ex", null, "originalJsonStr_"+cid);
            
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
     if (dieOnError) { 
    stringBuffer.append(TEXT_248);
     } else { 
    stringBuffer.append(TEXT_249);
     } 
    stringBuffer.append(TEXT_250);
    
    }

    /**
     * Generates code that performs the tranformation from one JSON input string
     * to many output strings, or to a reject flow.
     */
    private void generateTransformForMapping(final boolean nodeCheck,
            final boolean isArrayCheck, final String query, final String columnName) {
        
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    
        if (!isArrayCheck) {
            
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    
                if (nodeCheck) { // isArrayCheck is false nodeCheck is true
                    // TODO : what exactly does this match?
                    boolean isGetWholeJson = ".".equals(query.substring(1,query.length()-1)) && "/".equals(loopQuery.substring(1,loopQuery.length()-1));
                    
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(isGetWholeJson);
    stringBuffer.append(TEXT_278);
    
                } else { // isArrayCheck is false nodeCheck is false
                
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    
                }
                
    stringBuffer.append(TEXT_283);
    
        } else { // isArrayCheck is true
            if (nodeCheck) { // isArrayCheck is true and nodeCheck true
                boolean isGetWholeJson = ".".equals(query.substring(1,query.length()-1)) && "/".equals(loopQuery.substring(1,loopQuery.length()-1));
                
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(isGetWholeJson);
    stringBuffer.append(TEXT_300);
    
             } else { // isArrayCheck true nodeCheck false
                
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    
            }
        }

        Iterable<IMetadataColumn> outColumns = getOutColumnsMain();
        if (outColumns == null)
            outColumns = getOutColumnsReject();
        for (IMetadataColumn column : outColumns) {
            if (columnName.equals(column.getLabel())) {
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

                String defaultValue=column.getDefault();
                boolean isNotSetDefault = defaultValue == null || defaultValue.length() == 0;

                if (nodeCheck) {
                    
    stringBuffer.append(TEXT_308);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "str_" + cid));
    
                    continue;
                }

                if(!isArrayCheck){
                    if (javaType == JavaTypesManager.STRING) {
                        if (column.isNullable()) {
                            
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null"));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "\"\""));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?null:column.getDefault()));
    stringBuffer.append(TEXT_321);
    
                        } else {
                            
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "\"\""));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault()));
    stringBuffer.append(TEXT_330);
    
                        }
                    } else { // javaType is not STRING
                        if (column.isNullable()) {
                            
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null") );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?null:column.getDefault()));
    stringBuffer.append(TEXT_341);
    
                        } else {  // column.isNullable()
                            
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault()));
    stringBuffer.append(TEXT_348);
    
                        }
                    }
                    // At this point, there is a dangling } else { in the generated code

                    if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
                        
    stringBuffer.append(TEXT_349);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "str_" + cid));
    
                    } else { // javaType is not STRING or OBJECT
                        if (javaType == JavaTypesManager.DATE) {
                            
    stringBuffer.append(TEXT_350);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(str_"+cid+", "+patternValue+")"));
    
                        } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
                            
    stringBuffer.append(TEXT_351);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "java.nio.ByteBuffer.wrap(str_" + cid + ".getBytes())"));
    
                        } else {
                            
    stringBuffer.append(TEXT_352);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_"+typeToGenerate+"(str_"+cid+")"));
    
                        }
                    }

                    // Close the dangling else.
                    
    stringBuffer.append(TEXT_353);
    

                } else { // !isArrayCheck
                    
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null") );
    stringBuffer.append(TEXT_357);
    
                        if (javaType == JavaTypesManager.STRING) {
                        
    stringBuffer.append(TEXT_358);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "xmlListTemp_"+cid+".toString()") );
    
                        } else if(javaType == JavaTypesManager.LIST || javaType == JavaTypesManager.OBJECT) {
                        
    stringBuffer.append(TEXT_359);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "xmlListTemp_"+cid));
    
                        }
                        
    stringBuffer.append(TEXT_360);
    
                }

                // Once the matching column has been found, break out of the
                // loop looking for it.
                break;

            } // if
        } // for
    }

    /**
     * Generates code in the transform context to create reject output.
     *
     * @param die if this reject output should kill the job.  Normally, this is
     *    tied to a dieOnError parameter for the component, but can be
     *    explicitly set to false for non-fatal reject output.
     * @param codeException a variable in the transform scope that contains the
     *    variable with an exception.  If null, this will be constructed from
     *    the codeRejectMsg.
     * @param codeRejectMsg the error message to output with the reject output.
     */
    private void generateTransformReject(boolean die, String codeException, String codeRejectMsg, String codeRejectField) {
        if (codeRejectMsg == null) {
            codeRejectMsg = "\"" + cid + " - \" + " + codeException
                    + ".getMessage()";
            // Note: in DI, the error message can have the line number  appended
            // to it: " - Line: " + tos_count_nodeUniqueName()
        }

        if (codeException == null) {
            codeException = codeRejectMsg;
        }

        if (codeRejectField == null) {
            codeRejectField = getRowTransform().getCodeToGetInField(field);
        }

        // If there are multiple outputs, then copy all of the new columns from
        // the original output to the error output.
        if (isMultiOutput()) {
            
    stringBuffer.append(TEXT_361);
    stringBuffer.append(getRowTransform().getCodeToCopyOutMainToReject(newOutColumns));
    
        }

        if (die) {
            
    stringBuffer.append(TEXT_362);
    stringBuffer.append(codeException);
    stringBuffer.append(TEXT_363);
    
        } else {
            if (null == getOutConnReject()) {
                
    stringBuffer.append(TEXT_364);
    
                generateLogMessage(codeRejectMsg);
            } else {
                
    stringBuffer.append(TEXT_365);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_MSG,
                        codeRejectMsg) );
    
                if (containsRejectField) {
                    
    stringBuffer.append(TEXT_367);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_FIELD,
                        codeRejectField) );
    
                }
                
    stringBuffer.append(TEXT_368);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(true, copiedInColumns));
    stringBuffer.append(TEXT_369);
    stringBuffer.append(getRowTransform().getCodeToEmit(true));
    
            }
        }
    }
}

    

/**
 * Contains common processing for tExtractJSONFields code generation.  This is
 * used in MapReduce and Storm components.
 *
 * The following imports must occur before importing this file:
 * @ include file="@{org.talend.designer.components.mrprovider}/resources/utils/common_codegen_util.javajet"
 */
class TExtractJSONFieldsUtil extends org.talend.designer.common.TransformerBase {

    // TODO: what happens when these are input column names?
    final private static String REJECT_MSG = "errorMessage";
    final private static String REJECT_CODE = "errorCode";
    final private static String REJECT_FIELD = "errorJSONField";

    final private String field = ElementParameterParser.getValue(node, "__JSONFIELD__");
    final private String loopQuery = ElementParameterParser.getValue(node, "__JSON_LOOP_QUERY__");
    final private String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    final private java.util.List<java.util.Map<String, String>> mappings = (java.util.List<java.util.Map<String,String>>)
            ElementParameterParser.getObjectValue(node, "__MAPPING_4_JSONPATH__");
    final private boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    /** The outgoing connection contains the column {@link #REJECT_FIELD}.
     *  If we import a job from a DI job, this column will be missing */
    final private Boolean containsRejectField;

    /** The list of columns that should be copied directly from the input to
     *  the output schema (where they have the same column names). */
    final private java.util.List<IMetadataColumn> copiedInColumns;

    /** Columns in the output schema that are not copied directly from the
     *  input schema (excluding reject fields). */
    final private java.util.List<IMetadataColumn> newOutColumns;

    /** True if any of the extract mappings has the "NODECHECK" parameter

    /** True if any of the extract mappings has the "NODECHECK" parameter
     *  checked. */
    // TODO document
    final private boolean hasNodeCheck;

    public TExtractJSONFieldsUtil(INode node,
            org.talend.designer.common.BigDataCodeGeneratorArgument argument,
            org.talend.designer.common.CommonRowTransformUtil rowTransformUtil) {
        super(node, argument, rowTransformUtil, "FLOW", "REJECT");

        containsRejectField = hasOutputColumn(true, REJECT_FIELD);

        if (null != getInConn() && null != getOutConnMain()) {
            copiedInColumns = getColumnsUnion(getInColumns(), getOutColumnsMain());
            newOutColumns = getColumnsDiff(getOutColumnsMain(), getInColumns());
        } else if (null != getInConn() && null != getOutConnReject()) {
            copiedInColumns = getColumnsUnion(getInColumns(), getOutColumnsReject());
            // If only the reject output is used, the new columns are those that
            // are not part of the main schema (ignore the REJECT_XXX columns).
            java.util.List<IMetadataColumn> mainCols = getColumnsDiff(
                    getOutColumnsReject(), getColumns(getOutColumnsReject(),
                            REJECT_FIELD, REJECT_CODE, REJECT_MSG));
            newOutColumns = getColumnsDiff(mainCols, getInColumns());
        } else {
            copiedInColumns = null;
            newOutColumns = null;
        }

        // Examine the configured mapping to see if node checks are necessary
        // and unused input columns.
        boolean hasNodeCheckTemp = false;
        for (java.util.Map<String, String> mapping : mappings) {
            boolean nodeCheck = "true".equals(mapping.get("NODECHECK"));
            String query = mapping.get("QUERY");
            String columnName = mapping.get("SCHEMA_COLUMN");
            if (nodeCheck) {
                hasNodeCheckTemp = true;
            }
            // Any output columns that have a query attached must be in the
            // newOutColumns list.
            if (query != null && query.trim().length() != 0) {
                for (IMetadataColumn column : new java.util.ArrayList<IMetadataColumn>(copiedInColumns)) {
                    if (column.getLabel().compareTo(columnName) == 0) {
                        copiedInColumns.remove(column);
                        newOutColumns.add(column);
                    }
                }
             }
        }
        // TODO: is this necessary?
        hasNodeCheck = hasNodeCheckTemp;
    }

    /**
     * Generates all of the helper classes necessary to implement this node.
     */
    public void generateHelperClasses(boolean isStatic) {
       
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    
    }




    public void generateTransform() {
        generateTransform(false);
    }

    /**
     * Generates code that performs the tranformation from one JSON input string
     * to many output strings, or to a reject flow.
     */
    public void generateTransform(boolean hasAReturnedType) {
        // variables used throughout the transform scope of the generated code.
        
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    
            generateTransformReject(dieOnError, "ex_" + cid, null, "jsonStr_"+cid);
            
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_409);
    
                if (getOutConnMain() != null) {
                    
    stringBuffer.append(TEXT_410);
    stringBuffer.append(getOutConnMain().getName());
    stringBuffer.append(TEXT_411);
    stringBuffer.append(codeGenArgument.getRecordStructName(getOutConnMain()));
    stringBuffer.append(TEXT_412);
    
                } else {
                    
    stringBuffer.append(TEXT_413);
    stringBuffer.append(getOutConnReject().getName());
    stringBuffer.append(TEXT_414);
    stringBuffer.append(codeGenArgument.getRecordStructName(getOutConnReject()));
    stringBuffer.append(TEXT_415);
    
                }
                
    stringBuffer.append(TEXT_416);
    
                    for (int i=0; i < mappings.size(); i++) {
                        for(IMetadataColumn column : newOutColumns) {
                            String schemaColumn = mappings.get(i).get("SCHEMA_COLUMN");
                            // If someone read that, i'm so, so, so sorry.
                            String columnName = schemaColumn;
                            if(schemaColumn == null || !column.getLabel().equals(schemaColumn)) {
                                continue;
                            }

                            String jsonPath = mappings.get(i).get("QUERY");


                            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                            String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

                            String defaultValue = column.getDefault();
                            boolean isNotSetDefault = (defaultValue == null || defaultValue.trim().length()==0);
                    
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(jsonPath);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    
                                if(javaType == JavaTypesManager.STRING){
                    
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    
                                        if(isNotSetDefault) {
                                            
    stringBuffer.append(TEXT_428);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate)));
    
                                        } else if (column.isNullable()) {
                                            
    stringBuffer.append(TEXT_429);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null"));
    
                                        } else {
                                            
    stringBuffer.append(TEXT_430);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, defaultValue));
    
                                        }
                                        
    stringBuffer.append(TEXT_431);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "currentValue_" + cid+ ".toString()"));
    stringBuffer.append(TEXT_433);
    
                                } else {
                    
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    
                                        if(javaType == JavaTypesManager.BYTE_ARRAY) {
                    
    stringBuffer.append(TEXT_437);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "java.nio.ByteBuffer.wrap(currentValue_" + cid + ".toString().getBytes())"));
    
                                        } else if(javaType == JavaTypesManager.OBJECT) {
                    
    stringBuffer.append(TEXT_438);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "currentValue_" + cid + ".toString()"));
    
                                        } else if(javaType == JavaTypesManager.DATE) {
                    
    stringBuffer.append(TEXT_439);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(currentValue_" + cid + ".toString(), " + pattern + ")"));
    
                                        } else {
                    
    stringBuffer.append(TEXT_440);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_" + typeToGenerate + "(currentValue_" + cid + ".toString())"));
    
                                        }
                    
    stringBuffer.append(TEXT_441);
    
                                        if(isNotSetDefault) {
                                            
    stringBuffer.append(TEXT_442);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate)));
    
                                        } else if (column.isNullable()) {
                                            
    stringBuffer.append(TEXT_443);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null"));
    
                                        } else {
                                            
    stringBuffer.append(TEXT_444);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, defaultValue));
    
                                        }
                                        
    stringBuffer.append(TEXT_445);
    
                                }
                    
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    
                                if(isNotSetDefault) {
                                    
    stringBuffer.append(TEXT_448);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate)));
    
                                } else if (column.isNullable()) {
                                    
    stringBuffer.append(TEXT_449);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null"));
    
                                } else {
                                    
    stringBuffer.append(TEXT_450);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, defaultValue));
    
                                }
                                
    stringBuffer.append(TEXT_451);
    
                        }
                    }
                    if (null != getOutConnMain()) {
                        
    stringBuffer.append(TEXT_452);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(false, copiedInColumns));
    stringBuffer.append(TEXT_453);
    stringBuffer.append(getRowTransform().getCodeToEmit(false));
    
                    }
                    
    stringBuffer.append(TEXT_454);
    stringBuffer.append(getRowTransform().getCodeToInitOut(null == getOutConnMain(), newOutColumns));
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    
                    generateTransformReject(dieOnError, "ex_" + cid, null, "jsonStr_"+cid);
                    
    stringBuffer.append(TEXT_457);
    
    }



    /**
     * Generates code in the transform context to create reject output.
     *
     * @param die if this reject output should kill the job.  Normally, this is
     *    tied to a dieOnError parameter for the component, but can be
     *    explicitly set to false for non-fatal reject output.
     * @param codeException a variable in the transform scope that contains the
     *    variable with an exception.  If null, this will be constructed from
     *    the codeRejectMsg.
     * @param codeRejectMsg the error message to output with the reject output.
     */
    private void generateTransformReject(boolean die, String codeException, String codeRejectMsg, String codeRejectField) {
        if (codeRejectMsg == null) {
            codeRejectMsg = "\"" + cid + " - \" + " + codeException
                    + ".getMessage()";
            // Note: in DI, the error message can have the line number  appended
            // to it: " - Line: " + tos_count_nodeUniqueName()
        }

        if (codeException == null) {
            codeException = codeRejectMsg;
        }

        if (codeRejectField == null) {
            codeRejectField = getRowTransform().getCodeToGetInField(field);
        }

        // If there are multiple outputs, then copy all of the new columns from
        // the original output to the error output.
        if (isMultiOutput()) {
            
    stringBuffer.append(TEXT_458);
    stringBuffer.append(getRowTransform().getCodeToCopyOutMainToReject(newOutColumns));
    
        }

        if (die) {
            
    stringBuffer.append(TEXT_459);
    stringBuffer.append(codeException);
    stringBuffer.append(TEXT_460);
    
        } else {
            if (null == getOutConnReject()) {
                
    stringBuffer.append(TEXT_461);
    
                generateLogMessage(codeRejectMsg);
            } else {
                
    stringBuffer.append(TEXT_462);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_MSG,
                        codeRejectMsg) );
    
                if (containsRejectField) {
                    
    stringBuffer.append(TEXT_464);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_FIELD,
                        codeRejectField) );
    
                }
                
    stringBuffer.append(TEXT_465);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(true, copiedInColumns));
    stringBuffer.append(TEXT_466);
    stringBuffer.append(getRowTransform().getCodeToEmit(true));
    
            }
        }
    }
}

    
final MrMapperRowTransformUtil mrTransformUtil = new MrMapperRowTransformUtil();
final String readBy = ElementParameterParser.getValue(node, "__READ_BY__");
TransformerBase tExtractJSONFieldsUtil = null;
if ("XPATH".equals(readBy)) {
    tExtractJSONFieldsUtil = new TExtractJSONWithXMLFieldsUtil(node, codeGenArgument, mrTransformUtil);
} else {
    tExtractJSONFieldsUtil = new TExtractJSONFieldsUtil(node, codeGenArgument, mrTransformUtil);
}

mrTransformUtil.generateMrConfig(tExtractJSONFieldsUtil, cid + "Mapper.class");

    return stringBuffer.toString();
  }
}
