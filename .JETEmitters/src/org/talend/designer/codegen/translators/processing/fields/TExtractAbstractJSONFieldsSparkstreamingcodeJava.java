package org.talend.designer.codegen.translators.processing.fields;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.common.TransformerBase;
import org.talend.designer.spark.generator.SparkFunction;

public class TExtractAbstractJSONFieldsSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TExtractAbstractJSONFieldsSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractAbstractJSONFieldsSparkstreamingcodeJava result = new TExtractAbstractJSONFieldsSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        public static class ";
  protected final String TEXT_2 = " implements ";
  protected final String TEXT_3 = " {";
  protected final String TEXT_4 = NL + NL + "            private ContextProperties context = null;" + NL + "" + NL + "            public ";
  protected final String TEXT_5 = "(JobConf job) {" + NL + "                this.context = new ContextProperties(job);" + NL + "            }" + NL + "" + NL + "            public ";
  protected final String TEXT_6 = " ";
  protected final String TEXT_7 = "(";
  protected final String TEXT_8 = ")";
  protected final String TEXT_9 = NL + "                    ";
  protected final String TEXT_10 = " {";
  protected final String TEXT_11 = NL + "                ";
  protected final String TEXT_12 = NL + "                ";
  protected final String TEXT_13 = NL + "                return ";
  protected final String TEXT_14 = ";" + NL + "            }" + NL + "        }";
  protected final String TEXT_15 = NL + "        public static class ";
  protected final String TEXT_16 = " implements ";
  protected final String TEXT_17 = " {";
  protected final String TEXT_18 = NL + NL + "            private ContextProperties context = null;" + NL + "" + NL + "            public ";
  protected final String TEXT_19 = "(JobConf job) {" + NL + "                this.context = new ContextProperties(job);" + NL + "            }" + NL + "" + NL + "            public ";
  protected final String TEXT_20 = " ";
  protected final String TEXT_21 = "(";
  protected final String TEXT_22 = ") ";
  protected final String TEXT_23 = " {";
  protected final String TEXT_24 = NL + "                ";
  protected final String TEXT_25 = NL + "                     return ";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = NL + "            }" + NL + "        }";
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = NL + "            // No sparkcode generated for unnecessary ";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL + "            public static class ";
  protected final String TEXT_32 = "TrueFilter implements org.apache.spark.api.java.function.Function<scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase>, Boolean> {" + NL + "" + NL + "                public Boolean call(scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> arg0)" + NL + "                        throws Exception {" + NL + "                    return arg0._1;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public static class ";
  protected final String TEXT_33 = "FalseFilter implements org.apache.spark.api.java.function.Function<scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase>, Boolean> {" + NL + "" + NL + "                public Boolean call(scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> arg0)" + NL + "                        throws Exception {" + NL + "                    return !arg0._1;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public static class ";
  protected final String TEXT_34 = "ToNullWritableMain implements ";
  protected final String TEXT_35 = " {" + NL + "" + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_36 = "ToNullWritableMain(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_37 = " call(" + NL + "                        scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> data){";
  protected final String TEXT_38 = NL + "                    ";
  protected final String TEXT_39 = " ";
  protected final String TEXT_40 = " = (";
  protected final String TEXT_41 = ")data._2;" + NL + "                    return ";
  protected final String TEXT_42 = ";" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public static class ";
  protected final String TEXT_43 = "ToNullWritableReject implements ";
  protected final String TEXT_44 = " {" + NL + "" + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_45 = "ToNullWritableReject(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_46 = " call(" + NL + "                        scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> data){";
  protected final String TEXT_47 = NL + "                        ";
  protected final String TEXT_48 = " ";
  protected final String TEXT_49 = " = (";
  protected final String TEXT_50 = ")data._2;" + NL + "                    return ";
  protected final String TEXT_51 = ";" + NL + "                }" + NL + "            }";
  protected final String TEXT_52 = NL + "            // No sparkconfig generated for unnecessary ";
  protected final String TEXT_53 = NL;
  protected final String TEXT_54 = NL + "            // Extract data." + NL + "            org.apache.spark.api.java.JavaPairRDD<Boolean, org.apache.avro.specific.SpecificRecordBase> temporary_rdd_";
  protected final String TEXT_55 = " = rdd_";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = "(new ";
  protected final String TEXT_58 = "(job));" + NL + "" + NL + "            // Main flow" + NL;
  protected final String TEXT_59 = NL + "            ";
  protected final String TEXT_60 = " rdd_";
  protected final String TEXT_61 = " = temporary_rdd_";
  protected final String TEXT_62 = NL + "                  .filter(new ";
  protected final String TEXT_63 = "TrueFilter())" + NL + "                    .";
  protected final String TEXT_64 = "(new ";
  protected final String TEXT_65 = "ToNullWritableMain(job));" + NL + "" + NL + "            // Reject flow";
  protected final String TEXT_66 = NL + "            ";
  protected final String TEXT_67 = " rdd_";
  protected final String TEXT_68 = " = temporary_rdd_";
  protected final String TEXT_69 = NL + "                    .filter(new ";
  protected final String TEXT_70 = "FalseFilter())" + NL + "                    .";
  protected final String TEXT_71 = "(new ";
  protected final String TEXT_72 = "ToNullWritableReject(job));";
  protected final String TEXT_73 = NL + "            ";
  protected final String TEXT_74 = " rdd_";
  protected final String TEXT_75 = " = rdd_";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = "(new ";
  protected final String TEXT_78 = "(job));";
  protected final String TEXT_79 = NL + "        ";
  protected final String TEXT_80 = " class OriginalJSONString_";
  protected final String TEXT_81 = " {" + NL + "            String originalJSONString = null;" + NL + "            java.io.ByteArrayInputStream bais = null;" + NL + "            java.io.ByteArrayOutputStream baos = null;" + NL + "            de.odysseus.staxon.json.JsonXMLConfig config = null;" + NL + "            de.odysseus.staxon.json.JsonXMLOutputFactory jxof = null;" + NL + "" + NL + "            public String getOriginalJSONString(String xmlString,String additionRoot,String encoding,boolean isGetWholeJson, boolean isArray) throws Exception {" + NL + "                try {" + NL + "                    if (isArray) {" + NL + "                        xmlString = \"<list>\" + xmlString + \"</list>\";" + NL + "                    }" + NL + "                    bais = new java.io.ByteArrayInputStream(xmlString.getBytes(encoding));" + NL + "                    baos = new java.io.ByteArrayOutputStream();" + NL + "                    config = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).autoArray(true).build();" + NL + "                    jxof = new de.odysseus.staxon.json.JsonXMLOutputFactory(config);" + NL + "                    javax.xml.stream.XMLEventReader xmlEventReader = javax.xml.stream.XMLInputFactory.newInstance().createXMLEventReader(bais);" + NL + "                    javax.xml.stream.XMLEventWriter xmLEventWriter = jxof.createXMLEventWriter(baos);" + NL + "                    xmLEventWriter.add(xmlEventReader);" + NL + "                    xmlEventReader.close();" + NL + "                    xmLEventWriter.close();" + NL + "                    net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(baos.toString());" + NL + "                    if(isArray) {" + NL + "                        json = json.getJSONObject(\"list\");" + NL + "                    }" + NL + "                    net.sf.json.JSONObject originalJsonObject = null;" + NL + "                    if (!json.isNullObject()) {" + NL + "                        if (additionRoot == null) {" + NL + "                            originalJSONString = json.toString();" + NL + "                        } else {" + NL + "                            if (isGetWholeJson) {" + NL + "                                originalJsonObject = json.getJSONObject(additionRoot);" + NL + "                                if (!originalJsonObject.isNullObject()) {" + NL + "                                    originalJSONString = originalJsonObject.toString();" + NL + "                                }" + NL + "                            } else {" + NL + "                                originalJSONString = json.toString();" + NL + "                            }" + NL + "                        }" + NL + "                    }" + NL + "                } finally {" + NL + "                    baos.close();" + NL + "                    if (bais != null) {" + NL + "                        bais.close();" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                return originalJSONString;" + NL + "            }" + NL + "" + NL + "            public String getOriginalJSONString(String xmlString,String additionRoot,String encoding,boolean isGetWholeJson) throws Exception {" + NL + "               return getOriginalJSONString(xmlString, additionRoot, encoding, isGetWholeJson, false);" + NL + "            }" + NL + "" + NL + "        }";
  protected final String TEXT_82 = NL + "        ";
  protected final String TEXT_83 = " class XML_API_";
  protected final String TEXT_84 = " {" + NL + "            public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "                if (node != null && node instanceof org.dom4j.Element) {" + NL + "                    org.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "                    if(attri != null && (\"true\").equals(attri.getText())){" + NL + "                        return true;" + NL + "                    }" + NL + "                }" + NL + "                return false;" + NL + "            }" + NL + "" + NL + "            public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "                return node == null ? true : false;" + NL + "            }" + NL + "" + NL + "            public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "                if (node != null) {" + NL + "                    return node.getText().length() == 0;" + NL + "                }" + NL + "                return false;" + NL + "            }" + NL + "        }";
  protected final String TEXT_85 = NL + "        de.odysseus.staxon.json.JsonXMLConfig config_";
  protected final String TEXT_86 = " = null;" + NL + "        de.odysseus.staxon.json.JsonXMLInputFactory jsonXMLInputFactory_";
  protected final String TEXT_87 = " = null;" + NL + "        javax.xml.stream.XMLOutputFactory xmlOutputFactory_";
  protected final String TEXT_88 = " = null;";
  protected final String TEXT_89 = NL + "            OriginalJSONString_";
  protected final String TEXT_90 = " originalJSONString_";
  protected final String TEXT_91 = " = null;";
  protected final String TEXT_92 = NL + "        XML_API_";
  protected final String TEXT_93 = " xml_api_";
  protected final String TEXT_94 = " = null;" + NL + "        org.dom4j.io.SAXReader reader_";
  protected final String TEXT_95 = " = null;" + NL + "        org.dom4j.Document doc_";
  protected final String TEXT_96 = " = null;" + NL + "        java.util.HashMap<String, String> xmlNameSpaceMap_";
  protected final String TEXT_97 = " = new java.util.HashMap<String, String>();" + NL + "        org.dom4j.XPath x_";
  protected final String TEXT_98 = " = null;" + NL + "        java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_99 = " = null;" + NL + "        String xmlStr_";
  protected final String TEXT_100 = " = null;";
  protected final String TEXT_101 = NL + "        config_";
  protected final String TEXT_102 = " = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).build();" + NL + "        jsonXMLInputFactory_";
  protected final String TEXT_103 = " = new de.odysseus.staxon.json.JsonXMLInputFactory(config_";
  protected final String TEXT_104 = ");" + NL + "        xmlOutputFactory_";
  protected final String TEXT_105 = " = javax.xml.stream.XMLOutputFactory.newInstance();";
  protected final String TEXT_106 = NL + "            originalJSONString_";
  protected final String TEXT_107 = " = new OriginalJSONString_";
  protected final String TEXT_108 = "();";
  protected final String TEXT_109 = NL + "        xml_api_";
  protected final String TEXT_110 = " = new XML_API_";
  protected final String TEXT_111 = "();" + NL + "        reader_";
  protected final String TEXT_112 = " = new org.dom4j.io.SAXReader();";
  protected final String TEXT_113 = NL + "        boolean isStructError_";
  protected final String TEXT_114 = " = true;" + NL + "        org.dom4j.tree.AbstractNode currentNode_";
  protected final String TEXT_115 = " = (org.dom4j.tree.AbstractNode) ";
  protected final String TEXT_116 = NL + "                .get();" + NL + "        java.io.ByteArrayInputStream bais_";
  protected final String TEXT_117 = " = null;" + NL + "        java.io.ByteArrayOutputStream baos_";
  protected final String TEXT_118 = " = new java.io.ByteArrayOutputStream();" + NL;
  protected final String TEXT_119 = NL + NL + "        org.dom4j.Node node_";
  protected final String TEXT_120 = " = null;" + NL + "        String str_";
  protected final String TEXT_121 = " = \"\";" + NL + "        org.dom4j.XPath xTmp_";
  protected final String TEXT_122 = " = null;" + NL + "        Object obj_";
  protected final String TEXT_123 = " = null;" + NL + "" + NL + "        try {";
  protected final String TEXT_124 = NL + "                ";
  protected final String TEXT_125 = NL + "                ";
  protected final String TEXT_126 = NL + "        } catch (java.lang.Exception ex) {";
  protected final String TEXT_127 = NL + "        }";
  protected final String TEXT_128 = NL + "        ";
  protected final String TEXT_129 = NL;
  protected final String TEXT_130 = NL + "        xTmp_";
  protected final String TEXT_131 = " = currentNode_";
  protected final String TEXT_132 = ".createXPath(";
  protected final String TEXT_133 = ");" + NL + "        xTmp_";
  protected final String TEXT_134 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_135 = ");" + NL;
  protected final String TEXT_136 = NL + "            obj_";
  protected final String TEXT_137 = " = xTmp_";
  protected final String TEXT_138 = ".evaluate(currentNode_";
  protected final String TEXT_139 = ");" + NL + "            if (obj_";
  protected final String TEXT_140 = " instanceof String || obj_";
  protected final String TEXT_141 = " instanceof Number) {" + NL + "                node_";
  protected final String TEXT_142 = " = currentNode_";
  protected final String TEXT_143 = ";" + NL + "                str_";
  protected final String TEXT_144 = " = String.valueOf(obj_";
  protected final String TEXT_145 = ");" + NL + "            } else {" + NL + "                node_";
  protected final String TEXT_146 = " = xTmp_";
  protected final String TEXT_147 = ".selectSingleNode(currentNode_";
  protected final String TEXT_148 = ");";
  protected final String TEXT_149 = NL + "                    if (node_";
  protected final String TEXT_150 = " == null) {" + NL + "                        str_";
  protected final String TEXT_151 = " = null;" + NL + "                    } else {" + NL + "                        str_";
  protected final String TEXT_152 = " = originalJSONString_";
  protected final String TEXT_153 = ".getOriginalJSONString(node_";
  protected final String TEXT_154 = ".asXML(), null, ";
  protected final String TEXT_155 = ", ";
  protected final String TEXT_156 = ");" + NL + "                    }";
  protected final String TEXT_157 = NL + "                    str_";
  protected final String TEXT_158 = " = xTmp_";
  protected final String TEXT_159 = ".valueOf(currentNode_";
  protected final String TEXT_160 = ");";
  protected final String TEXT_161 = NL + "            }";
  protected final String TEXT_162 = NL + "                xmlStrTemp_";
  protected final String TEXT_163 = " = \"\";" + NL + "                for (Object tempNode_";
  protected final String TEXT_164 = " : xTmp_";
  protected final String TEXT_165 = ".selectNodes(currentNode_";
  protected final String TEXT_166 = ")) {" + NL + "                    node_";
  protected final String TEXT_167 = " = (org.dom4j.Node)tempNode_";
  protected final String TEXT_168 = ";" + NL + "                    xmlStrTemp_";
  protected final String TEXT_169 = " += node_";
  protected final String TEXT_170 = ".asXML();" + NL + "                }" + NL + "                if(\"\".equals(xmlStrTemp_";
  protected final String TEXT_171 = ")) {" + NL + "                    str_";
  protected final String TEXT_172 = " = null;" + NL + "                } else {" + NL + "                    str_";
  protected final String TEXT_173 = " = originalJSONString_";
  protected final String TEXT_174 = ".getOriginalJSONString(xmlStrTemp_";
  protected final String TEXT_175 = ", null,";
  protected final String TEXT_176 = ",";
  protected final String TEXT_177 = ", true);" + NL + "                }";
  protected final String TEXT_178 = NL + "                xmlListTemp_";
  protected final String TEXT_179 = " = new java.util.ArrayList<String>();" + NL + "                for(Object tempNode_";
  protected final String TEXT_180 = " : xTmp_";
  protected final String TEXT_181 = ".selectNodes(currentNode_";
  protected final String TEXT_182 = ")) {" + NL + "                    xmlListTemp_";
  protected final String TEXT_183 = ".add(((org.dom4j.Node)tempNode_";
  protected final String TEXT_184 = ").getStringValue());" + NL + "                }";
  protected final String TEXT_185 = NL + "                            ";
  protected final String TEXT_186 = NL + "                            ";
  protected final String TEXT_187 = NL + "                        ";
  protected final String TEXT_188 = NL + "                        ";
  protected final String TEXT_189 = NL + "                        ";
  protected final String TEXT_190 = NL + "                            if (xml_api_";
  protected final String TEXT_191 = ".isDefNull(node_";
  protected final String TEXT_192 = ")) {";
  protected final String TEXT_193 = NL + "                                ";
  protected final String TEXT_194 = NL + "                            } else if (xml_api_";
  protected final String TEXT_195 = ".isEmpty(node_";
  protected final String TEXT_196 = ")) {";
  protected final String TEXT_197 = NL + "                                ";
  protected final String TEXT_198 = NL + "                            } else if (xml_api_";
  protected final String TEXT_199 = ".isMissing(node_";
  protected final String TEXT_200 = ")) {";
  protected final String TEXT_201 = NL + "                                ";
  protected final String TEXT_202 = NL + "                            } else {";
  protected final String TEXT_203 = NL + "                            if (xml_api_";
  protected final String TEXT_204 = ".isEmpty(node_";
  protected final String TEXT_205 = ")) {";
  protected final String TEXT_206 = NL + "                                ";
  protected final String TEXT_207 = NL + "                            } else if(xml_api_";
  protected final String TEXT_208 = ".isMissing(node_";
  protected final String TEXT_209 = ")) {";
  protected final String TEXT_210 = NL + "                                ";
  protected final String TEXT_211 = NL + "                            } else {";
  protected final String TEXT_212 = NL + "                            if(xml_api_";
  protected final String TEXT_213 = ".isDefNull(node_";
  protected final String TEXT_214 = ")) {";
  protected final String TEXT_215 = NL + "                                ";
  protected final String TEXT_216 = NL + "                            } else if (xml_api_";
  protected final String TEXT_217 = ".isEmpty(node_";
  protected final String TEXT_218 = ") || xml_api_";
  protected final String TEXT_219 = ".isMissing(node_";
  protected final String TEXT_220 = ")) {";
  protected final String TEXT_221 = NL + "                                ";
  protected final String TEXT_222 = NL + "                            } else {";
  protected final String TEXT_223 = NL + "                            if (xml_api_";
  protected final String TEXT_224 = ".isMissing(node_";
  protected final String TEXT_225 = ") || xml_api_";
  protected final String TEXT_226 = ".isEmpty(node_";
  protected final String TEXT_227 = ")) {";
  protected final String TEXT_228 = NL + "                                 ";
  protected final String TEXT_229 = NL + "                            } else {";
  protected final String TEXT_230 = NL + "                        ";
  protected final String TEXT_231 = NL + "                                ";
  protected final String TEXT_232 = NL + "                                ";
  protected final String TEXT_233 = NL + "                            ";
  protected final String TEXT_234 = NL + "                            ";
  protected final String TEXT_235 = NL + "                            ";
  protected final String TEXT_236 = " } ";
  protected final String TEXT_237 = NL + "                    if (xmlListTemp_";
  protected final String TEXT_238 = ".isEmpty()) {";
  protected final String TEXT_239 = NL + "                        ";
  protected final String TEXT_240 = NL + "                    } else {";
  protected final String TEXT_241 = NL + "                            ";
  protected final String TEXT_242 = NL + "                            ";
  protected final String TEXT_243 = NL + "                    }";
  protected final String TEXT_244 = NL + "            ";
  protected final String TEXT_245 = NL + "            // Die immediately on errors." + NL + "            throw new IOException(";
  protected final String TEXT_246 = ");";
  protected final String TEXT_247 = NL + "                // Ignore errors processing this row and move to the next.";
  protected final String TEXT_248 = NL + "                // Send error rows to the reject output.";
  protected final String TEXT_249 = NL + "                ";
  protected final String TEXT_250 = NL + "                    ";
  protected final String TEXT_251 = NL + "                ";
  protected final String TEXT_252 = NL + "                ";
  protected final String TEXT_253 = NL + "       class JsonPathCache_";
  protected final String TEXT_254 = " {" + NL + "           final java.util.Map<String, com.jayway.jsonpath.JsonPath> jsonPathString2compiledJsonPath = new java.util.HashMap<String, com.jayway.jsonpath.JsonPath>();" + NL + "" + NL + "           public com.jayway.jsonpath.JsonPath getCompiledJsonPath(" + NL + "                   String jsonPath) {" + NL + "               if (jsonPathString2compiledJsonPath" + NL + "                       .containsKey(jsonPath)) {" + NL + "                   return jsonPathString2compiledJsonPath" + NL + "                           .get(jsonPath);" + NL + "               } else {" + NL + "                   com.jayway.jsonpath.JsonPath compiledLoopPath = com.jayway.jsonpath.JsonPath" + NL + "                           .compile(jsonPath);" + NL + "                   jsonPathString2compiledJsonPath.put(jsonPath," + NL + "                           compiledLoopPath);" + NL + "                   return compiledLoopPath;" + NL + "               }" + NL + "           }" + NL + "       }";
  protected final String TEXT_255 = NL + "        JsonPathCache_";
  protected final String TEXT_256 = " jsonPathCache_";
  protected final String TEXT_257 = " = new JsonPathCache_";
  protected final String TEXT_258 = "();" + NL + "        String jsonPath_";
  protected final String TEXT_259 = " = null;" + NL + "        com.jayway.jsonpath.JsonPath compiledJsonPath_";
  protected final String TEXT_260 = " = null;" + NL + "        Object currentValue_";
  protected final String TEXT_261 = " = null;" + NL + "" + NL + "        Object row_";
  protected final String TEXT_262 = " = ";
  protected final String TEXT_263 = ".get();" + NL + "" + NL + "        try {";
  protected final String TEXT_264 = NL + "                    jsonPath_";
  protected final String TEXT_265 = " = ";
  protected final String TEXT_266 = ";" + NL + "                    compiledJsonPath_";
  protected final String TEXT_267 = " = jsonPathCache_";
  protected final String TEXT_268 = ".getCompiledJsonPath(jsonPath_";
  protected final String TEXT_269 = ");" + NL + "" + NL + "                    try {" + NL + "                        currentValue_";
  protected final String TEXT_270 = " = compiledJsonPath_";
  protected final String TEXT_271 = ".read(row_";
  protected final String TEXT_272 = ");";
  protected final String TEXT_273 = NL + "                            if (currentValue_";
  protected final String TEXT_274 = " == null) {";
  protected final String TEXT_275 = NL + "                                            ";
  protected final String TEXT_276 = NL + "                                    ";
  protected final String TEXT_277 = NL + "                                            ";
  protected final String TEXT_278 = NL + "                            } else {";
  protected final String TEXT_279 = NL + "                                ";
  protected final String TEXT_280 = NL + "                            }";
  protected final String TEXT_281 = NL + "                            if(currentValue_";
  protected final String TEXT_282 = " != null && !currentValue_";
  protected final String TEXT_283 = ".toString().isEmpty()) {";
  protected final String TEXT_284 = NL + "                                    ";
  protected final String TEXT_285 = NL + "                                    ";
  protected final String TEXT_286 = NL + "                                    ";
  protected final String TEXT_287 = NL + "                                    ";
  protected final String TEXT_288 = NL + "                                    ";
  protected final String TEXT_289 = NL + "                            } else {";
  protected final String TEXT_290 = NL + "                                            ";
  protected final String TEXT_291 = NL + "                                    ";
  protected final String TEXT_292 = NL + "                                            ";
  protected final String TEXT_293 = NL + "                            }";
  protected final String TEXT_294 = NL + "                    } catch (com.jayway.jsonpath.PathNotFoundException e_";
  protected final String TEXT_295 = ") {";
  protected final String TEXT_296 = NL + "                                    ";
  protected final String TEXT_297 = NL + "                                    ";
  protected final String TEXT_298 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t                        ";
  protected final String TEXT_299 = NL + "                    }";
  protected final String TEXT_300 = NL + "                ";
  protected final String TEXT_301 = NL + "                ";
  protected final String TEXT_302 = NL + "            ";
  protected final String TEXT_303 = NL + "        } catch (java.lang.Exception ex_";
  protected final String TEXT_304 = ") {";
  protected final String TEXT_305 = NL + "        }" + NL;
  protected final String TEXT_306 = NL + "            ";
  protected final String TEXT_307 = NL + "            // Die immediately on errors." + NL + "            throw new IOException(";
  protected final String TEXT_308 = ");";
  protected final String TEXT_309 = NL + "                // Ignore errors processing this row and move to the next.";
  protected final String TEXT_310 = NL + "                // Send error rows to the reject output.";
  protected final String TEXT_311 = NL + "                ";
  protected final String TEXT_312 = NL + "                    ";
  protected final String TEXT_313 = NL + "                ";
  protected final String TEXT_314 = NL + "                ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final IBigDataNode bigDataNode = (IBigDataNode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    
/**
 * Code generated for component with single output
 */
class SOUserSpecifiedFunctionGenerator extends org.talend.designer.spark.generator.FunctionGenerator{

    SOUserSpecifiedFunctionGenerator(org.talend.designer.common.TransformerBase transformer) {
        super(transformer);
    }

    SOUserSpecifiedFunctionGenerator(org.talend.designer.common.TransformerBase transformer, org.talend.designer.spark.generator.SparkFunction sparkFunction) {
        super(transformer, sparkFunction);
    }

    @Override
    public void generate() {
        
    stringBuffer.append(TEXT_1);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_2);
    stringBuffer.append(this.sparkFunction.getCodeFunctionImplementation(getOutValueClass(),
                codeGenArgument.getRecordStructName(getInValue())));
    stringBuffer.append(TEXT_3);
    
            this.transformer.generateHelperClasses(true);
            this.transformer.generateTransformContextDeclaration();
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturnedType(this.outValueClass.toString()));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(this.sparkFunction.getCodeImplementedMethod());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(this.sparkFunction.getCodeFunctionArgument(codeGenArgument.getRecordStructName(getInValue().toString())));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(this.sparkFunction.getCodeThrowException());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(this.sparkFunction.getMethodHeader(this.outValueClass, this.outValue,
                            codeGenArgument.getRecordStructName(getInValue()), this.inValue));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(this.sparkFunction.getCodeKeyMapping(getInValue()));
    
                this.transformer.generateTransformContextInitialization();
                this.transformer.generateTransform(true);
                
    stringBuffer.append(TEXT_13);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturn(this.getOutValue(), this.getOutValueClass()));
    stringBuffer.append(TEXT_14);
    
    }
}

/**
 * Code generated for component with multiple outputs
  */
class MOUserSpecifiedFunctionGenerator extends org.talend.designer.spark.generator.FunctionGenerator{

    /** The single connection to pass along the output chain of Mappers
     *  instead of sending to a dedicated collector via MultipleOutputs. */
    String connectionToChain = null;

    MOUserSpecifiedFunctionGenerator(org.talend.designer.common.TransformerBase transformer) {
        super(transformer);
        defaultOutKeyClass = "Boolean";
    }

    MOUserSpecifiedFunctionGenerator(org.talend.designer.common.TransformerBase transformer, org.talend.designer.spark.generator.SparkFunction sparkFunction) {
        super(transformer, sparkFunction);
        defaultOutKeyClass = "Boolean";
    }

    @Override
    public void generate() {
        
    stringBuffer.append(TEXT_15);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(this.sparkFunction.getCodeFunctionImplementationOutputFixedType(codeGenArgument.getRecordStructName(getInValue().toString()), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_17);
    
            this.transformer.generateHelperClasses(true);
            this.transformer.generateTransformContextDeclaration();
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturnedTypeFixedType((String)this.outKeyClass, "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(this.sparkFunction.getCodeImplementedMethod());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(this.sparkFunction.getCodeFunctionArgument(codeGenArgument.getRecordStructName(getInValue().toString())));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(this.sparkFunction.getCodeThrowException());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(this.sparkFunction.getMethodHeader(this.outValueClass, this.outValue,
                        codeGenArgument.getRecordStructName(getInValue()), this.inValue));
    
                this.transformer.generateTransformContextInitialization();
                this.transformer.generateTransform(true);
                if(this.sparkFunction.getCodeFunctionReturn()!=null) {
                    
    stringBuffer.append(TEXT_25);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturn());
    stringBuffer.append(TEXT_26);
    
                }
                
    stringBuffer.append(TEXT_27);
    
    }
}

    stringBuffer.append(TEXT_28);
    

/**
 * A common, reusable utility that generates code in the context of a spark
 * component, for reading and writing to a spark RDD.
 * This implementation do not use the avro schema, and will use '"InConnName" + Struct' as a structure
 */
class SparkUserSpecifiedRowTransformUtil extends org.talend.designer.common.CommonRowTransformUtil {

    private boolean isMultiOutput = false;

    private org.talend.designer.spark.generator.SparkFunction sparkFunction = null;


    private org.talend.designer.spark.generator.FunctionGenerator functionGenerator = null;

    public SparkUserSpecifiedRowTransformUtil() {

    }

    public SparkUserSpecifiedRowTransformUtil(org.talend.designer.spark.generator.SparkFunction sparkFunction) {
        this.sparkFunction = sparkFunction;
    }

    public void setMultiOutput(boolean multiOutput) {
        isMultiOutput = multiOutput;
    }

    public String getCodeToGetInField(String columnName) {
        return functionGenerator.getInValue() + "." + columnName;
    }

    public String getInValue() {
        return functionGenerator.getInValue();
    }

    public String getOutValue() {
        return functionGenerator.getOutValue();
    }

    public String getInValueClass() {
        return functionGenerator.getInValueClass();
    }

    public String getOutValueClass() {
        return functionGenerator.getOutValueClass();
    }

    public String getCodeToGetOutField(boolean isReject, String columnName) {
        return functionGenerator.getOutValue(isReject ? "reject" : "main") + "." + columnName;
    }

    public String getCodeToInitOut(boolean isReject, Iterable<IMetadataColumn> columns) {
        if(this.sparkFunction!=null && !isMultiOutput) {
            return this.sparkFunction.getCodeToInitOut(functionGenerator.getOutValue(isReject ? "reject" : "main"), functionGenerator.getOutValueClass(isReject ? "reject" : "main"));
        } else {
            return "";
        }
    }

    public String getCodeToSetOutField(boolean isReject, String columnName, String codeValue) {
        return functionGenerator.getOutValue(isReject ? "reject" : "main") + "." + columnName + " = " + codeValue + ";";
    }

    public String getCodeToSetOutField(boolean isReject, String columnName, String codeValue, String operator) {
        return functionGenerator.getOutValue(isReject ? "reject" : "main") + "." + columnName + " " + operator + " " + codeValue + ";";
    }

    public String getCodeToEmit(boolean isReject) {
        if (this.sparkFunction!=null && isMultiOutput) {
            if (isReject) {
                return this.sparkFunction.getCodeToEmit(false, functionGenerator.getOutValue("reject"),
                        codeGenArgument.getRecordStructName(functionGenerator.getOutValue("reject")));
            } else {
                return this.sparkFunction.getCodeToEmit(true, functionGenerator.getOutValue("main"),
                        codeGenArgument.getRecordStructName(functionGenerator.getOutValue("main")));
            }
        } else {
            return "";
        }
    }

    public void generateSparkCode(final org.talend.designer.common.TransformerBase transformer, final org.talend.designer.spark.generator.SparkFunction sparkFunction) {
        if (transformer.isMultiOutput()) {
            setMultiOutput(true);
        }
        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
            return;
        }

        if (transformer.isMultiOutput()) {
            org.talend.designer.spark.generator.SparkFunction localSparkFunction = null;
            if ((sparkFunction instanceof org.talend.designer.spark.generator.FlatMapFunction)
                    || (sparkFunction instanceof org.talend.designer.spark.generator.FlatMapToPairFunction)) {
                localSparkFunction = new org.talend.designer.spark.generator.FlatMapToPairFunction(sparkFunction.isInputPair(), sparkFunction.getKeyList());
            } else {
                localSparkFunction = new org.talend.designer.spark.generator.MapToPairFunction(sparkFunction.isInputPair(), sparkFunction.getKeyList());
            }

            org.talend.designer.spark.generator.SparkFunction extractSparkFunction = null;
            if ((sparkFunction instanceof org.talend.designer.spark.generator.FlatMapFunction)
                    || (sparkFunction instanceof org.talend.designer.spark.generator.MapFunction)) {
                extractSparkFunction = new org.talend.designer.spark.generator.MapFunction(sparkFunction.isInputPair(), sparkFunction.getKeyList());
            } else {
                extractSparkFunction = new org.talend.designer.spark.generator.MapToPairFunction(sparkFunction.isInputPair(), sparkFunction.getKeyList());
            }
            this.sparkFunction = localSparkFunction;

            // The multi-output condition is slightly different, and the
            // MapperHelper is configured with internal names for the
            // connections.
            java.util.HashMap<String, String> names = new java.util.HashMap<String, String>();
            names.put("main", transformer.getOutConnMainName());
            names.put("reject", transformer.getOutConnRejectName());

            // Refactoring FunctionGenerator to java so we have to instaniate a MO or SO here
            functionGenerator = new MOUserSpecifiedFunctionGenerator(transformer, localSparkFunction);
            functionGenerator.init(node, cid, null, transformer.getInConnName(), null, names);

            
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(extractSparkFunction.getCodeFunctionImplementationInputFixedType(transformer.getOutConnMainTypeName(), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturnedType(transformer.getOutConnMainTypeName()));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(transformer.getOutConnMainTypeName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(transformer.getOutConnMainTypeName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturn(transformer.getOutConnMainName(), transformer.getOutConnMainTypeName()));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(extractSparkFunction.getCodeFunctionImplementationInputFixedType(transformer.getOutConnRejectTypeName(), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturnedType(transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(transformer.getOutConnRejectTypeName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(transformer.getOutConnRejectName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(transformer.getOutConnRejectTypeName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturn(transformer.getOutConnRejectName(), transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_51);
    
        } else {
            // Refactoring FunctionGenerator to java so we have to instaniate a MO or SO here
            functionGenerator = new SOUserSpecifiedFunctionGenerator(transformer, sparkFunction);

            functionGenerator.init(node, cid, null, transformer.getInConnName(), null,
                    transformer.getOutConnMainName() != null
                        ? transformer.getOutConnMainName()
                                : transformer.getOutConnRejectName());
        }
        functionGenerator.generate();
    }

    public void generateSparkConfig(final org.talend.designer.common.TransformerBase transformer, final org.talend.designer.spark.generator.SparkFunction sparkFunction) {
        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
            return;
        }

        if (transformer.isMultiOutput()) {
            String localFunctionType = "mapToPair";
            if ((sparkFunction instanceof org.talend.designer.spark.generator.FlatMapFunction)
                    || (sparkFunction instanceof org.talend.designer.spark.generator.FlatMapToPairFunction)) {
                localFunctionType = "flatMapToPair";
            }

            String extractFunctionType = "mapToPair";
            if ((sparkFunction instanceof org.talend.designer.spark.generator.FlatMapFunction)
                    || (sparkFunction instanceof org.talend.designer.spark.generator.MapFunction)) {
                extractFunctionType = "map";
            }
												
    stringBuffer.append(TEXT_54);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(transformer.getInConnName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(localFunctionType);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(sparkFunction.getConfigReturnedType(transformer.getOutConnMainTypeName()));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(extractFunctionType);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(sparkFunction.getConfigReturnedType(transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(transformer.getOutConnRejectName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(extractFunctionType);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
        } else {
            functionGenerator = new SOUserSpecifiedFunctionGenerator(transformer, sparkFunction);

            functionGenerator.init(node, cid, null, transformer.getInConnName(), null,
                    transformer.getOutConnMainName() != null
                        ? transformer.getOutConnMainName()
                                : transformer.getOutConnRejectName());
            
    stringBuffer.append(TEXT_73);
    stringBuffer.append(sparkFunction.getConfigReturnedType(transformer.getOutConnMainTypeName()));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(transformer.getInConnName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(sparkFunction.getConfigTransformation());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_78);
    
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

    final String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__");
    final private String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    final private java.util.List<java.util.Map<String, String>> mappings = (java.util.List<java.util.Map<String,String>>)
            ElementParameterParser.getObjectValue(node, "__MAPPING__");
    final private boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
    boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;

    String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

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
            copiedInColumns = org.talend.designer.common.TransformerBaseUtil.getColumnsUnion(getInColumns(), getOutColumnsMain());
            newOutColumns = org.talend.designer.common.TransformerBaseUtil.getColumnsDiff(getOutColumnsMain(), getInColumns());
        } else if (null != getInConn() && null != getOutConnReject()) {
            copiedInColumns = org.talend.designer.common.TransformerBaseUtil.getColumnsUnion(getInColumns(), getOutColumnsReject());
            // If only the reject output is used, the new columns are those that
            // are not part of the main schema (ignore the REJECT_XXX columns).
            java.util.List<IMetadataColumn> mainCols = org.talend.designer.common.TransformerBaseUtil.getColumnsDiff(
                    getOutColumnsReject(), org.talend.designer.common.TransformerBaseUtil.getColumns(getOutColumnsReject(),
                            REJECT_FIELD, REJECT_CODE, REJECT_MSG));
            newOutColumns = org.talend.designer.common.TransformerBaseUtil.getColumnsDiff(mainCols, getInColumns());
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
        if (hasNodeCheck)
            generateClassOriginalJSONString(isStatic);
        generateClassXmlApi(isStatic);
    }

    private void generateClassOriginalJSONString(boolean isStatic) {
    // Start generating code for OriginalJSONString_cid class.
    
    stringBuffer.append(TEXT_79);
    stringBuffer.append(isStatic ? "static" : "");
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
        // End generated code for OriginalJSONString_cid class
    }

    private void generateClassXmlApi(boolean isStatic) {
    // Start generating code for XML_API_cid class.
    
    stringBuffer.append(TEXT_82);
    stringBuffer.append(isStatic ? "static" : "");
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
        // End generated code for XML_API_cid class
    }

    public void generateTransformContextDeclaration() {
    
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
     if (hasNodeCheck) { 
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
     } 
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
    }

    public void generateTransformContextInitialization() {
        
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
     if (hasNodeCheck) { 
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
     } 
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
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
        
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(getInConnName());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
        // After this call, the isStructError_cid member is false if the json
        // input was correctly parsed into the common structures.
        
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
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
                
    stringBuffer.append(TEXT_124);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(false, copiedInColumns));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(getRowTransform().getCodeToEmit(false));
    
            }
            
    stringBuffer.append(TEXT_126);
    
            generateTransformReject(dieOnError, "ex", null, "originalJsonStr_"+cid);
            
    stringBuffer.append(TEXT_127);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(getRowTransform().getCodeToInitOut(null == getOutConnMain(), newOutColumns));
    stringBuffer.append(TEXT_129);
    
    }



    /**
     * Generates code that performs the tranformation from one JSON input string
     * to many output strings, or to a reject flow.
     */
    private void generateTransformForMapping(final boolean nodeCheck,
            final boolean isArrayCheck, final String query, final String columnName) {
        
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
        if (!isArrayCheck) {
            
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
                if (nodeCheck) { // isArrayCheck is false nodeCheck is true
                    // TODO : what exactly does this match?
                    boolean isGetWholeJson = false;
                    if ((".").equals(query.substring(1,query.length()-1)) && ("/").equals(loopQuery.substring(1,loopQuery.length()-1))) {
                        isGetWholeJson = true;
                    }
                    
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(isGetWholeJson);
    stringBuffer.append(TEXT_156);
    
                } else { // isArrayCheck is false nodeCheck is false
                
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
                }
                
    stringBuffer.append(TEXT_161);
    
        } else { // isArrayCheck is true
            if (nodeCheck) { // isArrayCheck is true and nodeCheck true
                boolean isGetWholeJson = ".".equals(query.substring(1,query.length()-1)) && "/".equals(loopQuery.substring(1,loopQuery.length()-1));
                
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(isGetWholeJson);
    stringBuffer.append(TEXT_177);
    
             } else { // isArrayCheck true nodeCheck false
                
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    
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
                    if(javaType == JavaTypesManager.BYTE_ARRAY){
     if (("SPARKSTREAMING".equals(node.getComponent().getType())
                                || "SPARK".equals(node.getComponent().getType()))) { 
    stringBuffer.append(TEXT_185);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "java.nio.ByteBuffer.wrap(str_" + cid + ".getBytes())"));
     } else { 
    stringBuffer.append(TEXT_186);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "str_" + cid + ".getBytes()"));
     } 
     } else if (javaType == JavaTypesManager.DATE) { 
    stringBuffer.append(TEXT_187);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(str_" + cid + ", " + column.getPattern() + ")"));
     } else if(!("id_Document".equals(column.getTalendType()))) { 
    stringBuffer.append(TEXT_188);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_"+ typeToGenerate +"(str_" + cid + ")"));
     } else { 
    stringBuffer.append(TEXT_189);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Document(str_" + cid + ")"));
     }
                    continue;
                }

                if(!isArrayCheck){
                    if (javaType == JavaTypesManager.STRING) {
                        if (column.isNullable()) {
                            
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null"));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "\"\""));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?null:column.getDefault()));
    stringBuffer.append(TEXT_202);
    
                        } else {
                            
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "\"\""));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault()));
    stringBuffer.append(TEXT_211);
    
                        }
                    } else { // javaType is not STRING
                        if (column.isNullable()) {
                            
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null") );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?null:column.getDefault()));
    stringBuffer.append(TEXT_222);
    
                        } else {  // column.isNullable()
                            
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault()));
    stringBuffer.append(TEXT_229);
    
                        }
                    }
                    // At this point, there is a dangling } else { in the generated code

                    if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
                        
    stringBuffer.append(TEXT_230);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "str_" + cid));
    
                    } else { // javaType is not STRING or OBJECT
                        if (javaType == JavaTypesManager.DATE) {
                            if(checkDate) {
                                
    stringBuffer.append(TEXT_231);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(str_"+cid+", "+patternValue+", false)"));
    
                            } else {
                                
    stringBuffer.append(TEXT_232);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(str_"+cid+", "+patternValue+")"));
    
                            }
                        } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
                            
    stringBuffer.append(TEXT_233);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "java.nio.ByteBuffer.wrap(str_" + cid + ".getBytes())"));
    
                        } else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) {
                            
    stringBuffer.append(TEXT_234);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_" + typeToGenerate + "(BigDataParserUtils.parseTo_Number("
                                    + "str_" + cid + ".toString(), " + thousandsSeparator + ", " + decimalSeparator + "))"));
    
                        } else {
                            
    stringBuffer.append(TEXT_235);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_"+typeToGenerate+"(str_"+cid+")"));
    
                        }
                    }

                    // Close the dangling else.
                    
    stringBuffer.append(TEXT_236);
    

                } else { // !isArrayCheck
                    
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null") );
    stringBuffer.append(TEXT_240);
    
                        if (javaType == JavaTypesManager.STRING) {
                        
    stringBuffer.append(TEXT_241);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "xmlListTemp_"+cid+".toString()") );
    
                        } else if(javaType == JavaTypesManager.LIST || javaType == JavaTypesManager.OBJECT) {
                        
    stringBuffer.append(TEXT_242);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "xmlListTemp_"+cid));
    
                        }
                        
    stringBuffer.append(TEXT_243);
    
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

        // If there are multiple outputs, then copy all of the new columns from
        // the original output to the error output.
        if (isMultiOutput()) {
            
    stringBuffer.append(TEXT_244);
    stringBuffer.append(getRowTransform().getCodeToCopyOutMainToReject(newOutColumns));
    
        }

        if (die) {
            
    stringBuffer.append(TEXT_245);
    stringBuffer.append(codeException);
    stringBuffer.append(TEXT_246);
    
        } else {
            if (null == getOutConnReject()) {
                
    stringBuffer.append(TEXT_247);
    
                generateLogMessage(codeRejectMsg);
            } else {
                
    stringBuffer.append(TEXT_248);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_MSG,
                        codeRejectMsg) );
    
                if (containsRejectField) {
                    
    stringBuffer.append(TEXT_250);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_FIELD,
                            getInConnName() + ".get().toString()") );
    
                }
                
    stringBuffer.append(TEXT_251);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(true, copiedInColumns));
    stringBuffer.append(TEXT_252);
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

    String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

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
       
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    
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
        
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
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
    stringBuffer.append(getInConnName());
    stringBuffer.append(TEXT_263);
    
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
            
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(jsonPath);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    
                        if(javaType == JavaTypesManager.STRING){
            
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    
                                if(isNotSetDefault) {
                                    
    stringBuffer.append(TEXT_275);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate)));
    
                                } else if (column.isNullable()) {
                                    
    stringBuffer.append(TEXT_276);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null"));
    
                                } else {
                                    
    stringBuffer.append(TEXT_277);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, defaultValue));
    
                                }
                                
    stringBuffer.append(TEXT_278);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "currentValue_" + cid+ ".toString()"));
    stringBuffer.append(TEXT_280);
    
                        } else {
            
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    
                                if(javaType == JavaTypesManager.BYTE_ARRAY) {
            
    stringBuffer.append(TEXT_284);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "java.nio.ByteBuffer.wrap(currentValue_" + cid + ".toString().getBytes())"));
    
                                } else if(javaType == JavaTypesManager.OBJECT) {
            
    stringBuffer.append(TEXT_285);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "currentValue_" + cid + ".toString()"));
    
                                } else if(javaType == JavaTypesManager.DATE) {
            
    stringBuffer.append(TEXT_286);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(currentValue_" + cid + ".toString(), " + pattern + ")"));
    
                                }  else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) {
            
    stringBuffer.append(TEXT_287);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_" + typeToGenerate + "(BigDataParserUtils.parseTo_Number("
                                            + "currentValue_" + cid + ".toString(), " + thousandsSeparator + ", " + decimalSeparator + "))"));
    
                                } else {
            
    stringBuffer.append(TEXT_288);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_" + typeToGenerate + "(currentValue_" + cid + ".toString())"));
    
                                }
            
    stringBuffer.append(TEXT_289);
    
                                if(isNotSetDefault) {
                                    
    stringBuffer.append(TEXT_290);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate)));
    
                                } else if (column.isNullable()) {
                                    
    stringBuffer.append(TEXT_291);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null"));
    
                                } else {
                                    
    stringBuffer.append(TEXT_292);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, defaultValue));
    
                                }
                                
    stringBuffer.append(TEXT_293);
    
                        }
            
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    
                                if(isNotSetDefault) {
                                    
    stringBuffer.append(TEXT_296);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate)));
    
                                } else if (column.isNullable()) {
                                    
    stringBuffer.append(TEXT_297);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null"));
    
                                } else {
                                    
    stringBuffer.append(TEXT_298);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, defaultValue));
    
                                }
                                
    stringBuffer.append(TEXT_299);
    
                }
            }
            if (null != getOutConnMain()) {
                
    stringBuffer.append(TEXT_300);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(false, copiedInColumns));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(getRowTransform().getCodeToEmit(false));
    
            }
            
    stringBuffer.append(TEXT_302);
    stringBuffer.append(getRowTransform().getCodeToInitOut(null == getOutConnMain(), newOutColumns));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    
            generateTransformReject(dieOnError, "ex_" + cid, null, "jsonPath_" + cid);
            
    stringBuffer.append(TEXT_305);
    
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
            
    stringBuffer.append(TEXT_306);
    stringBuffer.append(getRowTransform().getCodeToCopyOutMainToReject(newOutColumns));
    
        }

        if (die) {
            
    stringBuffer.append(TEXT_307);
    stringBuffer.append(codeException);
    stringBuffer.append(TEXT_308);
    
        } else {
            if (null == getOutConnReject()) {
                
    stringBuffer.append(TEXT_309);
    
                generateLogMessage(codeRejectMsg);
            } else {
                
    stringBuffer.append(TEXT_310);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_MSG,
                        codeRejectMsg) );
    
                if (containsRejectField) {
                    
    stringBuffer.append(TEXT_312);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_FIELD,
                        codeRejectField) );
    
                }
                
    stringBuffer.append(TEXT_313);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(true, copiedInColumns));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(getRowTransform().getCodeToEmit(true));
    
            }
        }
    }
}

    
org.talend.designer.spark.generator.SparkFunction sparkFunction = null;
String requiredInputType = bigDataNode.getRequiredInputType();
String requiredOutputType = bigDataNode.getRequiredOutputType();
String incomingType = bigDataNode.getIncomingType();
String outgoingType = bigDataNode.getOutgoingType();
boolean inputIsPair = requiredInputType != null ? "KEYVALUE".equals(requiredInputType) : "KEYVALUE".equals(incomingType);

String type = requiredOutputType == null ? outgoingType : requiredOutputType;
if("KEYVALUE".equals(type)) {
    sparkFunction = new org.talend.designer.spark.generator.MapToPairFunction(inputIsPair);
} else if("VALUE".equals(type)) {
    sparkFunction = new org.talend.designer.spark.generator.MapFunction(inputIsPair);
}

final SparkUserSpecifiedRowTransformUtil sparkTransformUtil = new SparkUserSpecifiedRowTransformUtil(sparkFunction);

final String readBy = ElementParameterParser.getValue(node, "__READ_BY__");
TransformerBase tExtractJSONFieldsUtil = null;
if ("XPATH".equals(readBy)) {
    tExtractJSONFieldsUtil = new TExtractJSONWithXMLFieldsUtil(node, codeGenArgument, sparkTransformUtil);
} else {
    tExtractJSONFieldsUtil = new TExtractJSONFieldsUtil(node, codeGenArgument, sparkTransformUtil);
}

sparkTransformUtil.generateSparkCode(tExtractJSONFieldsUtil, sparkFunction);

    return stringBuffer.toString();
  }
}
