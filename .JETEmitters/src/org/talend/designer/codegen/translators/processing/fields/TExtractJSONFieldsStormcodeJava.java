package org.talend.designer.codegen.translators.processing.fields;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.NodeUtil;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TExtractJSONFieldsStormcodeJava
{
  protected static String nl;
  public static synchronized TExtractJSONFieldsStormcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractJSONFieldsStormcodeJava result = new TExtractJSONFieldsStormcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            ";
  protected final String TEXT_2 = " stream_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL + "        public static class ";
  protected final String TEXT_6 = " implements Serializable {";
  protected final String TEXT_7 = NL + "        }";
  protected final String TEXT_8 = NL + "        public final static Fields fields = new Fields(";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "            public static final int tupleIndex";
  protected final String TEXT_11 = "_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ";";
  protected final String TEXT_14 = NL + "        /** Default serial version UID. */" + NL + "        private static final long serialVersionUID = 1L;";
  protected final String TEXT_15 = NL + "           private TridentTuple tuple;";
  protected final String TEXT_16 = NL + "            ";
  protected final String TEXT_17 = "(TridentTuple tuple) {";
  protected final String TEXT_18 = NL + "            }";
  protected final String TEXT_19 = NL + "            this.tuple = tuple;";
  protected final String TEXT_20 = NL + "            public TridentTuple getTuple() {" + NL + "                return tuple;" + NL + "            }" + NL + "" + NL + "            public void setTuple(TridentTuple tuple) {" + NL + "                this.tuple = tuple;" + NL + "            }";
  protected final String TEXT_21 = NL + "            public final static String getField";
  protected final String TEXT_22 = "_";
  protected final String TEXT_23 = "() {";
  protected final String TEXT_24 = NL + "                    return \"";
  protected final String TEXT_25 = "__";
  protected final String TEXT_26 = "\";";
  protected final String TEXT_27 = NL + "                    return ";
  protected final String TEXT_28 = ";";
  protected final String TEXT_29 = NL + "            }";
  protected final String TEXT_30 = NL + "            public final ";
  protected final String TEXT_31 = " get";
  protected final String TEXT_32 = "_";
  protected final String TEXT_33 = "() {" + NL + "                return ";
  protected final String TEXT_34 = "(tupleIndex";
  protected final String TEXT_35 = "_";
  protected final String TEXT_36 = ");" + NL + "            }";
  protected final String TEXT_37 = NL + "        public final static Values createValues(";
  protected final String TEXT_38 = " ";
  protected final String TEXT_39 = ") {" + NL + "            return new Values(";
  protected final String TEXT_40 = NL + "            );" + NL + "        }";
  protected final String TEXT_41 = NL + "        public static class ";
  protected final String TEXT_42 = " extends ";
  protected final String TEXT_43 = " {" + NL + "            /** Default serial version UID. */" + NL + "            private static final long serialVersionUID = 1L;" + NL + "            public ";
  protected final String TEXT_44 = "(TridentTuple tuple) {" + NL + "                super(tuple);" + NL + "            }" + NL + "        }";
  protected final String TEXT_45 = NL + "            // No stormcode generated for unnecessary ";
  protected final String TEXT_46 = NL + NL + "        public static class StormFunction_";
  protected final String TEXT_47 = " extends storm.trident.operation.BaseFunction {" + NL + "" + NL + "            private final ";
  protected final String TEXT_48 = " input" + NL + "                    = new ";
  protected final String TEXT_49 = "(null);" + NL + "            private final ";
  protected final String TEXT_50 = " output = new ";
  protected final String TEXT_51 = "(null);" + NL;
  protected final String TEXT_52 = NL + NL + "            @Override" + NL + "            public void prepare(Map conf, TridentOperationContext context) {";
  protected final String TEXT_53 = NL + "            }" + NL + "" + NL + "            public void execute(TridentTuple tuple, TridentCollector collector) {" + NL + "                input.setTuple(tuple);" + NL + "                Object[] values = new Object[";
  protected final String TEXT_54 = "];";
  protected final String TEXT_55 = NL + "            }" + NL + "        }";
  protected final String TEXT_56 = NL + "        /** A wrapper containing the union of main and reject column values" + NL + "         * for ";
  protected final String TEXT_57 = " and ";
  protected final String TEXT_58 = "*/";
  protected final String TEXT_59 = NL + "        /** A filter that selects only the main rows from ";
  protected final String TEXT_60 = " tuples.*/" + NL + "        public static class StormFilter_Demux";
  protected final String TEXT_61 = " extends storm.trident.operation.BaseFilter {" + NL + "            /** Default serial version UID. */" + NL + "            private static final long serialVersionUID = 1L;" + NL + "            private final ";
  protected final String TEXT_62 = " input = new ";
  protected final String TEXT_63 = "(null);" + NL + "            public boolean isKeep(storm.trident.tuple.TridentTuple tuple) {" + NL + "                input.setTuple(tuple);" + NL + "                return input.getInternal_mux();" + NL + "            }" + NL + "        }" + NL;
  protected final String TEXT_64 = NL + "            // No stormconfig generated for unnecessary ";
  protected final String TEXT_65 = NL + "        {";
  protected final String TEXT_66 = NL + "        }";
  protected final String TEXT_67 = NL + "        // The main and reject rows in a single multiplexed stream." + NL + "        Stream streamMux = ";
  protected final String TEXT_68 = NL + "            .each(";
  protected final String TEXT_69 = "," + NL + "                    new StormFunction_";
  protected final String TEXT_70 = "(),";
  protected final String TEXT_71 = NL + "                    ";
  protected final String TEXT_72 = ".fields)" + NL + "            .project(";
  protected final String TEXT_73 = ".fields);" + NL + "" + NL + "        // The main rows." + NL + "        stream_";
  protected final String TEXT_74 = " = streamMux" + NL + "            .each(";
  protected final String TEXT_75 = ".fields," + NL + "                    new StormFilter_Demux";
  protected final String TEXT_76 = "())" + NL + "            .project(";
  protected final String TEXT_77 = ");" + NL + "" + NL + "        // The reject rows." + NL + "        stream_";
  protected final String TEXT_78 = " = streamMux" + NL + "            .each(";
  protected final String TEXT_79 = ".fields," + NL + "                    new storm.trident.operation.builtin.Negate(" + NL + "                            new StormFilter_Demux";
  protected final String TEXT_80 = "()))" + NL + "            .project(";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL + "        stream_";
  protected final String TEXT_83 = " = ";
  protected final String TEXT_84 = NL + "            .each(";
  protected final String TEXT_85 = "," + NL + "                    new StormFunction_";
  protected final String TEXT_86 = "(),";
  protected final String TEXT_87 = NL + "                    ";
  protected final String TEXT_88 = ")" + NL + "            .project(";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "        ";
  protected final String TEXT_91 = " class ConvertJSONString_";
  protected final String TEXT_92 = " {" + NL + "            final static int Brace = 0 ; // {" + NL + "            final static int Bracket = 1; // [" + NL + "            private int barceType = -1 ;" + NL + "            private String originalJsonString = \"\" ;" + NL + "            private String originalLoopString = \"\" ;" + NL + "            private String jsonString4XML = null;" + NL + "            private String loopString4XML = null;" + NL + "            private String additionRoot = null;" + NL + "" + NL + "            public void barceType() {" + NL + "                for (int c = 0; c < originalJsonString.length(); ++c) {" + NL + "                    if (originalJsonString.charAt(c) == '{') {" + NL + "                        barceType = Brace;" + NL + "                        break;" + NL + "                    } else if (originalJsonString.charAt(c) == '[') {" + NL + "                        barceType = Bracket;" + NL + "                        break;" + NL + "                    }" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public void setJsonString (String originalJsonString) {" + NL + "                this.originalJsonString = originalJsonString;" + NL + "            }" + NL + "" + NL + "            public void setLoopString (String originalLoopString) {" + NL + "                this.originalLoopString = originalLoopString;" + NL + "            }" + NL + "" + NL + "            public String getJsonString4XML() {" + NL + "                return jsonString4XML;" + NL + "            }" + NL + "" + NL + "            public String getLoopString4XML() {" + NL + "                if(loopString4XML.length()>1 && loopString4XML.endsWith(\"/\")) {" + NL + "                    loopString4XML = loopString4XML.substring(0, loopString4XML.length()-1);" + NL + "                }" + NL + "                return loopString4XML;" + NL + "            }" + NL + "" + NL + "            public void setAdditionRoot(String additionRoot) {" + NL + "                this.additionRoot = additionRoot;" + NL + "            }" + NL + "" + NL + "            public String getAdditionRoot() {" + NL + "                return additionRoot;" + NL + "            }" + NL + "" + NL + "            public void generate() {" + NL + "                barceType();" + NL + "                jsonString4XML = originalJsonString;" + NL + "                loopString4XML = originalLoopString;" + NL + "                if (Brace == barceType) {" + NL + "                    if (isNeedAddRoot(originalJsonString)) {" + NL + "                        jsonString4XML = \"{ \\\"root\\\": \" + originalJsonString + \" }\";" + NL + "                        loopString4XML = \"root\" + originalLoopString;" + NL + "                        setAdditionRoot(\"root\");" + NL + "                    }" + NL + "                } else if (Bracket == barceType) {" + NL + "                    jsonString4XML = \"{ \\\"root\\\" : { \\\"object\\\": \"" + NL + "                            + originalJsonString + \" } }\";" + NL + "                    loopString4XML = \"root/object\" + originalLoopString;" + NL + "                        setAdditionRoot(\"object\");" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public boolean isNeedAddRoot(String originalJsonString) {" + NL + "                boolean isNeedAddRoot = false;" + NL + "                net.sf.json.JSONObject jso = net.sf.json.JSONObject" + NL + "                        .fromObject(originalJsonString);" + NL + "                String jsonKey = \"\";" + NL + "                Object firstObject = null;" + NL + "                if (jso.names().size() == 1) {" + NL + "                     jsonKey = jso.names().get(0).toString();" + NL + "                     firstObject = jso.get(jsonKey);" + NL + "                 }" + NL + "                 if (jso.size() > 1" + NL + "                         || (firstObject != null" + NL + "                                 && firstObject instanceof net.sf.json.JSONArray && ((net.sf.json.JSONArray) firstObject)" + NL + "                                 .size() > 1)) {" + NL + "                     isNeedAddRoot = true;" + NL + "                 }" + NL + "                 return isNeedAddRoot;" + NL + "            }" + NL + "        }";
  protected final String TEXT_93 = NL + "        ";
  protected final String TEXT_94 = " class OriginalJSONString_";
  protected final String TEXT_95 = " {" + NL + "            String originalJSONString = null;" + NL + "            java.io.ByteArrayInputStream bais = null;" + NL + "            java.io.ByteArrayOutputStream baos = null;" + NL + "            de.odysseus.staxon.json.JsonXMLConfig config = null;" + NL + "            de.odysseus.staxon.json.JsonXMLOutputFactory jxof = null;" + NL + "" + NL + "            public String getOriginalJSONString(String xmlString,String additionRoot,String encoding,boolean isGetWholeJson, boolean isArray) throws Exception {" + NL + "                try {" + NL + "                    if (isArray) {" + NL + "                        xmlString = \"<list>\" + xmlString + \"</list>\";" + NL + "                    }" + NL + "                    bais = new java.io.ByteArrayInputStream(xmlString.getBytes(encoding));" + NL + "                    baos = new java.io.ByteArrayOutputStream();" + NL + "                    config = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).autoArray(true).build();" + NL + "                    jxof = new de.odysseus.staxon.json.JsonXMLOutputFactory(config);" + NL + "                    javax.xml.stream.XMLEventReader xmlEventReader = javax.xml.stream.XMLInputFactory.newInstance().createXMLEventReader(bais);" + NL + "                    javax.xml.stream.XMLEventWriter xmLEventWriter = jxof.createXMLEventWriter(baos);" + NL + "                    xmLEventWriter.add(xmlEventReader);" + NL + "                    xmlEventReader.close();" + NL + "                    xmLEventWriter.close();" + NL + "                    net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(baos.toString());" + NL + "                    if(isArray) {" + NL + "                        json = json.getJSONObject(\"list\");" + NL + "                    }" + NL + "                    net.sf.json.JSONObject originalJsonObject = null;" + NL + "                    if (!json.isNullObject()) {" + NL + "                        if (additionRoot == null) {" + NL + "                            originalJSONString = json.toString();" + NL + "                        } else {" + NL + "                            if (isGetWholeJson) {" + NL + "                                originalJsonObject = json.getJSONObject(additionRoot);" + NL + "                                if (!originalJsonObject.isNullObject()) {" + NL + "                                    originalJSONString = originalJsonObject.toString();" + NL + "                                }" + NL + "                            } else {" + NL + "                                originalJSONString = json.toString();" + NL + "                            }" + NL + "                        }" + NL + "                    }" + NL + "                } finally {" + NL + "                    baos.close();" + NL + "                    if (bais != null) {" + NL + "                        bais.close();" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                return originalJSONString;" + NL + "            }" + NL + "" + NL + "            public String getOriginalJSONString(String xmlString,String additionRoot,String encoding,boolean isGetWholeJson) throws Exception {" + NL + "               return getOriginalJSONString(xmlString, additionRoot, encoding, isGetWholeJson, false);" + NL + "            }" + NL + "" + NL + "        }";
  protected final String TEXT_96 = NL + "        ";
  protected final String TEXT_97 = " class XML_API_";
  protected final String TEXT_98 = " {" + NL + "            public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "                if (node != null && node instanceof org.dom4j.Element) {" + NL + "                    org.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "                    if(attri != null && (\"true\").equals(attri.getText())){" + NL + "                        return true;" + NL + "                    }" + NL + "                }" + NL + "                return false;" + NL + "            }" + NL + "" + NL + "            public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "                return node == null ? true : false;" + NL + "            }" + NL + "" + NL + "            public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "                if (node != null) {" + NL + "                    return node.getText().length() == 0;" + NL + "                }" + NL + "                return false;" + NL + "            }" + NL + "        }";
  protected final String TEXT_99 = NL + "        ConvertJSONString_";
  protected final String TEXT_100 = " cjs_";
  protected final String TEXT_101 = " = null;" + NL + "        de.odysseus.staxon.json.JsonXMLConfig config_";
  protected final String TEXT_102 = " = null;" + NL + "        de.odysseus.staxon.json.JsonXMLInputFactory jsonXMLInputFactory_";
  protected final String TEXT_103 = " = null;" + NL + "        javax.xml.stream.XMLOutputFactory xmlOutputFactory_";
  protected final String TEXT_104 = " = null;";
  protected final String TEXT_105 = NL + "            OriginalJSONString_";
  protected final String TEXT_106 = " originalJSONString_";
  protected final String TEXT_107 = " = null;";
  protected final String TEXT_108 = NL + "        XML_API_";
  protected final String TEXT_109 = " xml_api_";
  protected final String TEXT_110 = " = null;" + NL + "        org.dom4j.io.SAXReader reader_";
  protected final String TEXT_111 = " = null;" + NL + "        org.dom4j.Document doc_";
  protected final String TEXT_112 = " = null;" + NL + "        java.util.HashMap<String, String> xmlNameSpaceMap_";
  protected final String TEXT_113 = " = new java.util.HashMap<String, String>();" + NL + "        org.dom4j.XPath x_";
  protected final String TEXT_114 = " = null;" + NL + "        java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_115 = " = null;" + NL + "        String jsonStr_";
  protected final String TEXT_116 = " = null;" + NL + "        String xmlStr_";
  protected final String TEXT_117 = " = null;";
  protected final String TEXT_118 = NL + "        cjs_";
  protected final String TEXT_119 = " = new ConvertJSONString_";
  protected final String TEXT_120 = "();" + NL + "        config_";
  protected final String TEXT_121 = " = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).build();" + NL + "        jsonXMLInputFactory_";
  protected final String TEXT_122 = " = new de.odysseus.staxon.json.JsonXMLInputFactory(config_";
  protected final String TEXT_123 = ");" + NL + "        xmlOutputFactory_";
  protected final String TEXT_124 = " = javax.xml.stream.XMLOutputFactory.newInstance();";
  protected final String TEXT_125 = NL + "            originalJSONString_";
  protected final String TEXT_126 = " = new OriginalJSONString_";
  protected final String TEXT_127 = "();";
  protected final String TEXT_128 = NL + "        xml_api_";
  protected final String TEXT_129 = " = new XML_API_";
  protected final String TEXT_130 = "();" + NL + "        reader_";
  protected final String TEXT_131 = " = new org.dom4j.io.SAXReader();";
  protected final String TEXT_132 = NL + "        boolean isStructError_";
  protected final String TEXT_133 = " = true;" + NL + "        String loopQuery_";
  protected final String TEXT_134 = " = ";
  protected final String TEXT_135 = ";" + NL + "        String originalJsonStr_";
  protected final String TEXT_136 = " = (String) ";
  protected final String TEXT_137 = ";" + NL + "        cjs_";
  protected final String TEXT_138 = ".setJsonString(originalJsonStr_";
  protected final String TEXT_139 = ");" + NL + "        cjs_";
  protected final String TEXT_140 = ".setLoopString(loopQuery_";
  protected final String TEXT_141 = ");" + NL + "        java.io.ByteArrayInputStream bais_";
  protected final String TEXT_142 = " = null;" + NL + "        java.io.ByteArrayOutputStream  baos_";
  protected final String TEXT_143 = " = new java.io.ByteArrayOutputStream();" + NL;
  protected final String TEXT_144 = NL + NL + "         org.dom4j.Node node_";
  protected final String TEXT_145 = " = null;" + NL + "         String str_";
  protected final String TEXT_146 = " = \"\";" + NL + "         org.dom4j.XPath xTmp_";
  protected final String TEXT_147 = " = null;" + NL + "         Object obj_";
  protected final String TEXT_148 = " = null;" + NL + "         String xmlStrTemp_";
  protected final String TEXT_149 = " = \"\";" + NL + "         java.util.List<String> xmlListTemp_";
  protected final String TEXT_150 = " = null;" + NL + "" + NL + "        if (!isStructError_";
  protected final String TEXT_151 = " && nodeList_";
  protected final String TEXT_152 = " != null) {" + NL + "            for (org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_153 = " : nodeList_";
  protected final String TEXT_154 = ") {" + NL + "                try {";
  protected final String TEXT_155 = NL + "                        ";
  protected final String TEXT_156 = NL + "                        ";
  protected final String TEXT_157 = NL + "                } catch (java.lang.Exception ex) {";
  protected final String TEXT_158 = NL + "                }";
  protected final String TEXT_159 = NL + "                ";
  protected final String TEXT_160 = NL + "            }" + NL + "        }";
  protected final String TEXT_161 = NL + "        try {" + NL + "            cjs_";
  protected final String TEXT_162 = ".generate();" + NL + "            jsonStr_";
  protected final String TEXT_163 = " = cjs_";
  protected final String TEXT_164 = ".getJsonString4XML();" + NL + "            loopQuery_";
  protected final String TEXT_165 = " = cjs_";
  protected final String TEXT_166 = ".getLoopString4XML();" + NL + "            bais_";
  protected final String TEXT_167 = " = new java.io.ByteArrayInputStream(jsonStr_";
  protected final String TEXT_168 = ".getBytes(";
  protected final String TEXT_169 = "));" + NL + "" + NL + "            javax.xml.stream.XMLEventReader xmlEventReader_";
  protected final String TEXT_170 = " = jsonXMLInputFactory_";
  protected final String TEXT_171 = ".createXMLEventReader(bais_";
  protected final String TEXT_172 = ");" + NL + "            javax.xml.stream.XMLEventWriter xmLEventWriter_";
  protected final String TEXT_173 = " = xmlOutputFactory_";
  protected final String TEXT_174 = ".createXMLEventWriter(baos_";
  protected final String TEXT_175 = ");" + NL + "            xmLEventWriter_";
  protected final String TEXT_176 = ".add(xmlEventReader_";
  protected final String TEXT_177 = ");" + NL + "            // Convert JSON string to XML." + NL + "            xmLEventWriter_";
  protected final String TEXT_178 = ".close();" + NL + "            xmlEventReader_";
  protected final String TEXT_179 = ".close();" + NL + "            xmlStr_";
  protected final String TEXT_180 = " = baos_";
  protected final String TEXT_181 = ".toString();" + NL + "            doc_";
  protected final String TEXT_182 = "= reader_";
  protected final String TEXT_183 = ".read(new java.io.StringReader(xmlStr_";
  protected final String TEXT_184 = "));" + NL + "            x_";
  protected final String TEXT_185 = " = doc_";
  protected final String TEXT_186 = ".createXPath(loopQuery_";
  protected final String TEXT_187 = ");" + NL + "            x_";
  protected final String TEXT_188 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_189 = ");" + NL + "            nodeList_";
  protected final String TEXT_190 = " = (java.util.List<org.dom4j.tree.AbstractNode>) x_";
  protected final String TEXT_191 = ".selectNodes(doc_";
  protected final String TEXT_192 = ");" + NL + "            isStructError_";
  protected final String TEXT_193 = " = false;" + NL + "        } catch (java.lang.Exception ex) {";
  protected final String TEXT_194 = NL + "        } finally {" + NL + "            try {" + NL + "                baos_";
  protected final String TEXT_195 = ".close();" + NL + "                if (bais_";
  protected final String TEXT_196 = " != null) {" + NL + "                    bais_";
  protected final String TEXT_197 = ".close();" + NL + "                }" + NL + "            } catch (IOException e) {";
  protected final String TEXT_198 = NL + "                    throw new  java.io.IOException(e.getMessage());";
  protected final String TEXT_199 = NL + "                    System.err.println(e.getMessage());";
  protected final String TEXT_200 = NL + "            }" + NL + "        }";
  protected final String TEXT_201 = NL + "        xTmp_";
  protected final String TEXT_202 = " = temp_";
  protected final String TEXT_203 = ".createXPath(";
  protected final String TEXT_204 = ");" + NL + "        xTmp_";
  protected final String TEXT_205 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_206 = ");" + NL;
  protected final String TEXT_207 = NL + "            obj_";
  protected final String TEXT_208 = " = xTmp_";
  protected final String TEXT_209 = ".evaluate(temp_";
  protected final String TEXT_210 = ");" + NL + "            if (obj_";
  protected final String TEXT_211 = " instanceof String || obj_";
  protected final String TEXT_212 = " instanceof Number) {" + NL + "                node_";
  protected final String TEXT_213 = " = temp_";
  protected final String TEXT_214 = ";" + NL + "                str_";
  protected final String TEXT_215 = " = String.valueOf(obj_";
  protected final String TEXT_216 = ");" + NL + "            } else {" + NL + "                node_";
  protected final String TEXT_217 = " = xTmp_";
  protected final String TEXT_218 = ".selectSingleNode(temp_";
  protected final String TEXT_219 = ");";
  protected final String TEXT_220 = NL + "                    if (node_";
  protected final String TEXT_221 = " == null) {" + NL + "                        str_";
  protected final String TEXT_222 = " = null;" + NL + "                    } else {" + NL + "                        str_";
  protected final String TEXT_223 = " = originalJSONString_";
  protected final String TEXT_224 = ".getOriginalJSONString(node_";
  protected final String TEXT_225 = ".asXML(), cjs_";
  protected final String TEXT_226 = ".getAdditionRoot(), ";
  protected final String TEXT_227 = ", ";
  protected final String TEXT_228 = ");" + NL + "                    }";
  protected final String TEXT_229 = NL + "                    str_";
  protected final String TEXT_230 = " = xTmp_";
  protected final String TEXT_231 = ".valueOf(temp_";
  protected final String TEXT_232 = ");";
  protected final String TEXT_233 = NL + "            }";
  protected final String TEXT_234 = NL + "                xmlStrTemp_";
  protected final String TEXT_235 = " = \"\";" + NL + "                for (Object tempNode_";
  protected final String TEXT_236 = " : xTmp_";
  protected final String TEXT_237 = ".selectNodes(temp_";
  protected final String TEXT_238 = ")) {" + NL + "                    node_";
  protected final String TEXT_239 = " = (org.dom4j.Node)tempNode_";
  protected final String TEXT_240 = ";" + NL + "                    xmlStrTemp_";
  protected final String TEXT_241 = " += node_";
  protected final String TEXT_242 = ".asXML();" + NL + "                }" + NL + "                if(\"\".equals(xmlStrTemp_";
  protected final String TEXT_243 = ")) {" + NL + "                    str_";
  protected final String TEXT_244 = " = null;" + NL + "                } else {" + NL + "                    str_";
  protected final String TEXT_245 = " = originalJSONString_";
  protected final String TEXT_246 = ".getOriginalJSONString(xmlStrTemp_";
  protected final String TEXT_247 = ",cjs_";
  protected final String TEXT_248 = ".getAdditionRoot(),";
  protected final String TEXT_249 = ",";
  protected final String TEXT_250 = ", true);" + NL + "                }";
  protected final String TEXT_251 = NL + "                xmlListTemp_";
  protected final String TEXT_252 = " = new java.util.ArrayList<String>();" + NL + "                for(Object tempNode_";
  protected final String TEXT_253 = " : xTmp_";
  protected final String TEXT_254 = ".selectNodes(temp_";
  protected final String TEXT_255 = ")) {" + NL + "                    xmlListTemp_";
  protected final String TEXT_256 = ".add(((org.dom4j.Node)tempNode_";
  protected final String TEXT_257 = ").getStringValue());" + NL + "                }";
  protected final String TEXT_258 = NL + "                    ";
  protected final String TEXT_259 = NL + "                            if (xml_api_";
  protected final String TEXT_260 = ".isDefNull(node_";
  protected final String TEXT_261 = ")) {";
  protected final String TEXT_262 = NL + "                                ";
  protected final String TEXT_263 = NL + "                            } else if (xml_api_";
  protected final String TEXT_264 = ".isEmpty(node_";
  protected final String TEXT_265 = ")) {";
  protected final String TEXT_266 = NL + "                                ";
  protected final String TEXT_267 = NL + "                            } else if (xml_api_";
  protected final String TEXT_268 = ".isMissing(node_";
  protected final String TEXT_269 = ")) {";
  protected final String TEXT_270 = NL + "                                ";
  protected final String TEXT_271 = NL + "                            } else {";
  protected final String TEXT_272 = NL + "                            if (xml_api_";
  protected final String TEXT_273 = ".isEmpty(node_";
  protected final String TEXT_274 = ")) {";
  protected final String TEXT_275 = NL + "                                ";
  protected final String TEXT_276 = NL + "                            } else if(xml_api_";
  protected final String TEXT_277 = ".isMissing(node_";
  protected final String TEXT_278 = ")) {";
  protected final String TEXT_279 = NL + "                                ";
  protected final String TEXT_280 = NL + "                            } else {";
  protected final String TEXT_281 = NL + "                            if(xml_api_";
  protected final String TEXT_282 = ".isDefNull(node_";
  protected final String TEXT_283 = ")) {";
  protected final String TEXT_284 = NL + "                                ";
  protected final String TEXT_285 = NL + "                            } else if (xml_api_";
  protected final String TEXT_286 = ".isEmpty(node_";
  protected final String TEXT_287 = ") || xml_api_";
  protected final String TEXT_288 = ".isMissing(node_";
  protected final String TEXT_289 = ")) {";
  protected final String TEXT_290 = NL + "                                ";
  protected final String TEXT_291 = NL + "                            } else {";
  protected final String TEXT_292 = NL + "                            if (xml_api_";
  protected final String TEXT_293 = ".isMissing(node_";
  protected final String TEXT_294 = ") || xml_api_";
  protected final String TEXT_295 = ".isEmpty(node_";
  protected final String TEXT_296 = ")) {";
  protected final String TEXT_297 = NL + "                                 ";
  protected final String TEXT_298 = NL + "                            } else {";
  protected final String TEXT_299 = NL + "                        ";
  protected final String TEXT_300 = NL + "                            ";
  protected final String TEXT_301 = NL + "                            ";
  protected final String TEXT_302 = NL + "                            ";
  protected final String TEXT_303 = " } ";
  protected final String TEXT_304 = NL + "                    if (xmlListTemp_";
  protected final String TEXT_305 = ".isEmpty()) {";
  protected final String TEXT_306 = NL + "                        ";
  protected final String TEXT_307 = NL + "                    } else {";
  protected final String TEXT_308 = NL + "                            ";
  protected final String TEXT_309 = NL + "                            ";
  protected final String TEXT_310 = NL + "                    }";
  protected final String TEXT_311 = NL + "            ";
  protected final String TEXT_312 = NL + "            // Die immediately on errors." + NL + "            throw new IOException(";
  protected final String TEXT_313 = ");";
  protected final String TEXT_314 = NL + "                // Ignore errors processing this row and move to the next.";
  protected final String TEXT_315 = NL + "                // Send error rows to the reject output.";
  protected final String TEXT_316 = NL + "                ";
  protected final String TEXT_317 = NL + "                    ";
  protected final String TEXT_318 = NL + "                ";
  protected final String TEXT_319 = NL + "                ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    

/**
 * This utility class is responsible for some common Storm and Trident code
 * generation, including:
 *
 * - analyzing the input and function fields for BaseFunctions
 */
class StormStreamUtil {

    private final INode node;
    private IConnection inConn;
    private IMetadataTable inMetadata;
    private java.util.List<IMetadataColumn> inColumns;
    private IConnection outConn;
    private IMetadataTable outMetadata;
    private java.util.List<IMetadataColumn> outColumns;

    public StormStreamUtil(INode node) {
        this.node = node;
    }

    /**
     * @return the input connection or null if none was set.
     */
    public IConnection getInConnection() {
        return inConn;
    }

    /**
     * @return the input metadata table or null if none was set.
     */
    public IMetadataTable getInMetadata() {
        return inMetadata;
    }

    /**
     * @return the input schema columns or null if none was set.
     */
    public java.util.List<IMetadataColumn> getInColumns() {
        return inColumns;
    }

    /**
     * @return the input schema columns or null if none was set.
     */
    public boolean getInColumnsContains(String label) {
        for (IMetadataColumn column : inColumns)
            if (column.getLabel().equals(label))
                return true;
        return false;
    }

    /**
     * Sets and configures this utility to consider the given input connection
     * as the input to the Storm stream.
     */
    public void setInConnection(IConnection inConn) {
        this.inConn = inConn;
        this.inMetadata = inConn == null ? null : inConn.getMetadataTable();
        this.inColumns = inMetadata == null ? null : inMetadata.getListColumns();
    }

    /**
     * @return the output connection or null if none was set.
     */
    public IConnection getOutConnection() {
        return outConn;
    }

    /**
     * @return the output metadata table or null if none was set.
     */
    public IMetadataTable getOutMetadata() {
        return outMetadata;
    }

    /**
     * @return the output schema columns or null if none was set.
     */
    public java.util.List<IMetadataColumn> getOutColumns() {
        return outColumns;
    }

    /**
     * Sets and configures this utility to consider the given output connection
     * as the output to the Storm stream.
     */
    public void setOutConnection(IConnection outConn) {
        this.outConn = outConn;
        this.outMetadata = outConn == null ? null : outConn.getMetadataTable();
        this.outColumns = outMetadata == null ? null : outMetadata.getListColumns();
    }

    /**
     * @return the first data connection coming into this node.
     */
    public IConnection getFirstDataInConnection() {
        // Use the first incoming DATA connection
        if (node.getIncomingConnections() != null) {
            for (IConnection inConn : node.getIncomingConnections()) {
                if (inConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                    return inConn;
                }
            }
        }
        return null;
    }

    /**
     * @return the first main connection coming into this node.
     */
    public IConnection getFirstMainInConnection() {
        java.util.List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
        return inConns == null || inConns.size() == 0 ? null : inConns.get(0);
    }

    /**
     * @return the first connection with the given name coming out of this node.
     */
    public IConnection getFirstOutConnection() {
        // Use the first outgoing connection of any type
        if (node.getOutgoingConnections() != null
                && node.getOutgoingConnections().size() > 0) {
            return node.getOutgoingConnections().get(0);
        }
        return null;
    }

    /**
     * @return the first connection with the given name coming out of this node.
     */
    public IConnection getFirstNamedOutConnection(String connectorName) {
        // Use the first incoming DATA connection
        if (node.getOutgoingConnections() != null) {
            for (IConnection outConn : node.getOutgoingConnections()) {
                if (outConn.getConnectorName().equals(connectorName)) {
                    return outConn;
                }
            }
        }
        return null;
    }

    /**
     * @return the number of fields in the output columns, or 0 if there is no
     *    output connection.
     */
    public int getOutFieldsSize() {
        return outColumns == null ? 0 : outColumns.size();
    }

    public void generateAllOutStreamsDeclarations() {
        generateSetAllOutStreams(true, null);
    }

    /**
     * For every output stream from this node (not just the specific
     * getOutputConnection()), generate a line of code that declares and/or sets
     * the corresponding trident <code>stream_</code> variable.
     *
     * @param declare whether the type declaration should be included.
     * @param the value to set the output streams (must be a
     *      <code>storm.trident.Stream</code>).
     */
    public void generateSetAllOutStreams(boolean declare, String codeValue) {
        for (IConnection conn : node.getOutgoingConnections()) { 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(declare ? "Stream" : "" );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( conn.getName() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(codeValue);
    stringBuffer.append(TEXT_4);
     }
    }

    public String getCodeInStreamVariable() {
        return "stream_" + inConn.getName();
    }

    public String getCodeOutStreamVariable() {
        return "stream_" + outConn.getName();
    }
}

    
/**
 * Helper tool to generate wrappers for Tuples, including specifications about
 * which fields are found in the tuple, and a simple, reusable wrapper for
 * getting column values from a tuple.
 *
 * TODO(rskraba): check whether a Values-based getter/setter methods are
 *    useful for tFilterRow and tJavaStorm.
 */
class TupleWrapperHelper {

    /** The full class name for the wrapper. */
    private final String className;

    /** A unique field prefix for generating field names.  If based on a
     *  connection, the connection name can be freely used. */
    protected final String fieldPrefix;

    /** List of columns that have values belonging to tuples of this type. */
    private final java.util.LinkedHashMap<String, IMetadataColumn> columnInfo
            = new java.util.LinkedHashMap<String, IMetadataColumn>();

    /** A column prefix to use to prevent collisions between
     *  intermediate/generated columns and columns coming from actual row
     *  schemas. */
    private final java.util.HashMap<String, String> codeGenPrefix
            = new java.util.HashMap<String, String>();

    /** A list of tuple field names that should not be generated automatically,
     *  but overridden to use a specific code value (usually a reference to a
     *  field name from another wrapper). */
    private final java.util.HashMap<String, String> overrideCodeFieldName
            = new java.util.HashMap<String, String>();

    /** True if generate should add a method for getting the field names per
     *  column. */
    protected boolean needsFieldNameAccessors = true;

    /** True if generate should create the methods for wrapping a TridentTuple. */
    protected boolean needsTupleMethods = true;

    /** True if generate should add a method for outputting a Values. */
    protected boolean needsValuesMethods = true;

    // TODO -- delete when static methods can be used within code generators.
    TupleWrapperHelper() {
        className = null;
        fieldPrefix = null;
    }

    TupleWrapperHelper(IConnection conn) {
        this(new TupleWrapperHelper().getClassName(conn), conn.getName(),
                conn.getMetadataTable().getListColumns());
    }

    TupleWrapperHelper(String className, IConnection conn) {
        this(className, conn.getName(),
                conn.getMetadataTable().getListColumns());
    }

    TupleWrapperHelper(String className, IConnection conn,
            Iterable<IMetadataColumn> columns) {
        this(className, conn.getName(), columns);
    }

    TupleWrapperHelper(String className, String fieldPrefix,
            Iterable<IMetadataColumn> columns) {
        this.className = className;
        this.fieldPrefix = fieldPrefix;
        for (IMetadataColumn column : columns)
            columnInfo.put(column.getLabel(), column);
    }

    TupleWrapperHelper(TupleWrapperHelper parent, IConnection conn) {
        this(conn);
        // override all of the field values to refer to the parent.
        for (IMetadataColumn column : columnInfo.values()) {
            setCodeFieldName(column,
                    parent.getCodeFieldsAccessors(parent.className + ".",
                            java.util.Arrays.asList(column)));
        }
    }

    /** The number of fields that this class manages. */
    public int getSize() {
        return columnInfo.size();
    }


    /**
     * @return the class name that contains field information for the given
     *   connection, if a TupleWrapper was generated for that connection.
     */
    // TODO(rskraba): static
    public String getClassName(IConnection conn) {
        if(conn != null)
            return "TupleWrapper_" + conn.getName();
        else 
            return "TupleWrapper_null";
    }

    /**
     * @return the fields that are used for the given connection, if a
     *   TupleWrapper was generated for that connection.
     */
    // TODO(rskraba): static
    public String getFields(IConnection conn) {
        return getClassName(conn) + ".fields";
    }

    /**
     * @return the default TupleWrapper getField for a field of a specify connection
     */
    // TODO(rskraba): static
    public String getField(IConnection conn, String field) {
        return getClassName(conn) + ".getField_" + field + "()";
    }

    /**
     * Specifies that a field name for the given column should be initialized
     * to the given code value (usually a quoted string constant or a static
     * reference to another class).
     */
    public void setCodeFieldName(IMetadataColumn column, String codeOther) {
        overrideCodeFieldName.put(column.getLabel(), codeOther);
    }

    /**
     * Used to add a prefix to a column for generated code referring to that
     * column.  As long as the prefix doesn't start with _, it is guaranteed
     * not to cause a collision with existing row schema columns.
     *
     * This should be used for intermediary columns that don't specifically
     * belong to row schemas.
     */
    public void setPrefix(IMetadataColumn column, String prefix) {
        codeGenPrefix.put(column.getLabel(), prefix);
    }

    /**
     * Adds all of the given columns to this class, ignoring any that have the
     * same label as existing columns.
     */
    public void union(Iterable<IMetadataColumn> columns) {
        for (IMetadataColumn toAdd : columns)
            if (!columnInfo.containsKey(toAdd.getLabel()))
                columnInfo.put(toAdd.getLabel(), toAdd);
    }

    /**
     * Adds the given column as an internal, intermediary column, which is used
     * during processing but doesn't belong to any specific row schema.
     */
    public void addInternalColumn(String label, String prefix,
            org.talend.core.model.metadata.types.JavaType jt) {
        IMetadataColumn internal
                = new org.talend.core.model.metadata.MetadataColumn();
        internal.setLabel(label);
        internal.setType(jt.getId());
        internal.setTalendType(jt.getId());
        columnInfo.put(label, internal);
        setCodeFieldName(internal, '"' + label + '"');
        setPrefix(internal, prefix);
    }

    // TODO(rskraba): static
    public String getCodeJavaType(IMetadataColumn column) {
        org.talend.core.model.metadata.types.JavaType jt
                = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
        return org.talend.core.model.metadata.types.JavaTypesManager.getTypeToGenerate(jt, column.isNullable());
    }

    // TODO(rskraba): static
    public String getCodeJavaMember(String codeModifiers, IMetadataColumn column,
            String codeVarName, String codeVarValue) {
        StringBuilder member = new StringBuilder();
        if (codeModifiers != null)
            member.append(codeModifiers).append(' ');
        member.append(getCodeJavaType(column)).append(' ').append(codeVarName);
        if (codeVarValue != null)
            member.append('=').append(codeVarValue);
        member.append(';');
        return member.toString();
    }

        // TODO(rskraba): static
    public String getCodeJavaMemberInit(IMetadataColumn column, String codeVarName,
            String codeVarValue) {
        StringBuilder member = new StringBuilder();
        member.append(codeVarName);
        if (codeVarValue != null)
            member.append('=').append(codeVarValue);
        member.append(';');
        return member.toString();
    }

    // TODO(rskraba): static
    public String getCodeJavaDefault(IMetadataColumn column) {
        return org.talend.core.model.metadata.types.JavaTypesManager.getDefaultValueFromJavaIdType(
                column.getTalendType(), column.isNullable());
    }

    /**
     * Creates a code snippet that can be used to access a value from a
     * TridentTuple instance.  This is in the format like: <code>codeTuple.getString</code>
     * or <code>(Date) codeTuple.getObject</code>.
     *
     * Note the open parenthesis isn't added, and that the snippet should return
     * a value compatible with {@link getCodeJavaType}.
     */
    // TODO(rskraba): static
    public String getCodeTupleAccessorForType(String codeTuple, IMetadataColumn column) {
        org.talend.core.model.metadata.types.JavaType jt
                = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
        if (jt.isPrimitive() && (jt != org.talend.core.model.metadata.types.JavaTypesManager.CHARACTER)) {
            // getByte, getShort, getLong, etc...
            // But character type is not a default type of storm, so we need to cast it.
            return codeTuple + ".get" + jt.getNullableClass().getSimpleName();
        } else if (jt == org.talend.core.model.metadata.types.JavaTypesManager.STRING) {
            return codeTuple + ".getString";
        } else if (jt == org.talend.core.model.metadata.types.JavaTypesManager.BYTE_ARRAY) {
            return codeTuple + ".getBytes";
        }
        return "(" + getCodeJavaType(column) + ") " + codeTuple + ".getValue";
    }

    /** Generates standard TupleWrappers for all of the outgoing connections
     *  of the given node. */
    // TODO(rskraba): static
    public void generateAllOutgoing(INode node) {
        for (IConnection conn : node.getOutgoingConnections())
            new TupleWrapperHelper(conn).generate();
    }

    /** Generates the entire class. */
    public void generate() {
        
    stringBuffer.append(TEXT_5);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_6);
    
            generateFieldsConstants();
            generateMembers();
            generateConstructors();
            if (needsFieldNameAccessors)
                generateFieldNameAccessors();
            generateMethods();
            if (needsTupleMethods)
                generateWrappedTupleAccessors();
            if (needsValuesMethods)
                generateValuesCreate();
            
    stringBuffer.append(TEXT_7);
    
    }

    /**
     * Generates a class member containing all of the expected field names that
     * are expected to be emitted along the stream that this struct represents.
     *
     * <code>
     * public final static Fields fields = new Fields(getField_store(),
     *     getField_sales(), getField_avePrice(), getField_maxPrice(),
     *     getField_date(), getField_unknown());
     * public static final int tupleIndex_store = 0;
     * public static final int tupleIndex_sales = 1;
     * public static final int tupleIndex_avePrice = 2;
     * public static final int tupleIndex_maxPrice = 3;
     * public static final int tupleIndex_date = 4;
     * public static final int tupleIndex_unknown = 5;
     * </code>
     */
    protected void generateFieldsConstants() {
        
    stringBuffer.append(TEXT_8);
    stringBuffer.append(getCodeFieldsAccessors(null, columnInfo.values()));
    stringBuffer.append(TEXT_9);
    
        int i = 0;
        for (IMetadataColumn column : columnInfo.values()) {
            String prefix = codeGenPrefix.get(column.getLabel());
            if (prefix == null)
                prefix = "";
            
    stringBuffer.append(TEXT_10);
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(i++);
    stringBuffer.append(TEXT_13);
    
        }
    }

    /**
     * Any class members that need to be created for this struct.
     *
     * By default, just the underlying private tuple that any instances of this
     * struct can wrap.
     */
    protected void generateMembers() {
        
    stringBuffer.append(TEXT_14);
     if (needsTupleMethods) { 
    stringBuffer.append(TEXT_15);
     }
    }

    /**
     * Constructors that need to be created for this struct.
     *
     * By default, the constructor that wraps an underlying tuple.
     */
    protected void generateConstructors() {
        if (needsTupleMethods) {
            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_17);
     generateInitializeMembers(); 
    stringBuffer.append(TEXT_18);
    
        }
    }

    /**
     * Class or instance that need to be initialized in the constructor.
     *
     * By default, the constructor that wraps an underlying tuple.
     */
    protected void generateInitializeMembers() {
        if (needsTupleMethods) {
            
    stringBuffer.append(TEXT_19);
    
        }
    }

    /**
     * Any methods that need to be created for this struct.
     *
     * By default, just accessors for the underlying private tuple that any
     * instances of this struct can wrap.
     */
    protected void generateMethods() {
        if (needsTupleMethods) {
            
    stringBuffer.append(TEXT_20);
    
        }
    }

    /**
     * Generates static class methods used access the field names for given
     * columns.
     *
     * <code>
     * // for each column
     * public static String getField_store() {
     *     return "row3__store";
     * }
     *
     * // or:
     * public static String getField_store() {
     *     return row2Struct.getField_store();
     * }
     * </code>
     */
    protected void generateFieldNameAccessors() {
        for (IMetadataColumn column : columnInfo.values()) {
            String prefix = codeGenPrefix.get(column.getLabel());
            if (prefix == null)
                prefix = "";
            
    stringBuffer.append(TEXT_21);
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_23);
    
                String codeOverride = overrideCodeFieldName.get(column.getLabel());
                if (codeOverride == null) {
                    
    stringBuffer.append(TEXT_24);
    stringBuffer.append(fieldPrefix);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_26);
    
                } else {
                    
    stringBuffer.append(TEXT_27);
    stringBuffer.append(codeOverride);
    stringBuffer.append(TEXT_28);
    
                }
                
    stringBuffer.append(TEXT_29);
    
        }
    }

    /**
     * Generates accessors to get column values of the correct type given the
     * column name.
     *
     * <code>
     * public String get_store() {
     *   return tuple.getString(tupleIndex_store);
     * }
     *
     * public double get_sales() {
     *  return tuple.getDouble(tupleIndex_sales);
     * }
     * </code>
     */
    protected void generateWrappedTupleAccessors() {
        for (IMetadataColumn column : columnInfo.values()) {
            String prefix = codeGenPrefix.get(column.getLabel());
            if (prefix == null)
                prefix = "";
            
    stringBuffer.append(TEXT_30);
    stringBuffer.append(getCodeJavaType(column));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(getCodeTupleAccessorForType("tuple", column));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_36);
    
        }
    }

    /**
     * Generates a static helper method to create a Trident Values object in the
     * expected format and order for emission.
     *
     * <code>
     * public static Values createValues(String store, double sales,
     *         double avePrice, double maxPrice, long date, String unknown) {
     *      return new Values(store, sales, avePrice, maxPrice, date, unknown);
     * }
     * </code>
     */
    protected void generateValuesCreate() {
        
    stringBuffer.append(TEXT_37);
    
            boolean first = true;
            // Construct the method signature
            for (IMetadataColumn column : columnInfo.values()) {
                
    stringBuffer.append( first ? "" : ", " );
    stringBuffer.append(getCodeJavaType(column));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(column.getLabel());
    
                first = false;
            }
            // Close the signature and start the body.
            
    stringBuffer.append(TEXT_39);
    
                first = true;
                for (IMetadataColumn column : columnInfo.values()) {
                    
    stringBuffer.append( first ? "" : ", " );
    stringBuffer.append(column.getLabel());
    
                    first = false;
                }
                
    stringBuffer.append(TEXT_40);
    
        // Close the body.
    }

    /**
     * A very simple helper that creates a subclass that adds nothing to the
     * parent subclass generated by a previous TupleWrapper.  This is useful
     * for extending the static namespace from the previous class.
     */
    // TODO(rskraba): static
    public void generateExtends(String className, String parentClassName) {
        // This currently doesn't support extra constructors, and may eventually
        //  be better off as a subclass strateggy of TupleWrapperHelper.
        // For the moment, it's only used by tReplicate.
        
    stringBuffer.append(TEXT_41);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(parentClassName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_44);
    
    }

    /**
     * @return the actual name of this class.
     */
    public String toString() {
        return className;
    }

    /**
     * @return a comma-separated list of getField_COLUMN_LABEL() accessors
     */
    public String getCodeFieldsAccessors(String tupleWrapperRedirect,
            Iterable<IMetadataColumn> columns) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (IMetadataColumn column : columns) {
            String prefix = codeGenPrefix.get(column.getLabel());
            if (prefix == null)
                prefix = "";
            sb.append(first ? "" : ",");
            if (tupleWrapperRedirect != null)
                sb.append(tupleWrapperRedirect);
            sb.append("getField").append(prefix).append("_").append(
                    column.getLabel()).append("()");
            first = false;
        }
        return sb.toString();
    }
}

    

/**
 * A common, reusable utility that generates code in the context of a storm
 * component, for reading and writing to a storm stream.
 *
 * The code generation context includes includes:
 * - tuple : the current storm tuple being processed.
 * - input : a TupleWrapperHelper generated class with get_columnName() accessors.
 * - output : a TupleWrapperHelper generated class with get_columnName() accessors.
 * - values : an array of output values to be sent.
 */
class StormRowTransformUtil extends org.talend.designer.common.CommonRowTransformUtil {

    private boolean isMultiOutput = false;

    public void setMultiOutput(boolean multiOutput) {
        isMultiOutput = multiOutput;
    }

    public String getCodeToGetInField(String columnName) {
        return "input.get_" + columnName + "()";
    }

    public String getInValue() {
        return "input"; //$NON-NLS-1$
    }

    // Note :added abstract method to CommonRowTransformUtil
    // and added its impl. here. Check what really needs to be returned
    public String getOutValue() {
        return "output"; //$NON-NLS-1$
    }

    public String getInValueClass() {
        return ""; //$NON-NLS-1$
    }

    // Note :added abstract method to CommonRowTransformUtil
    // and added its impl. here. Check what really needs to be returned
    public String getOutValueClass() {
        return ""; //$NON-NLS-1$
    }

    public String getCodeToGetOutField(boolean isReject, String columnName) {
        return "values[output.tupleIndex_" + columnName + "]";
    }

    public String getCodeToSetOutField(boolean isReject, String columnName, String codeValue) {
        // TODO(rskraba): accessors for Values output, like
        // "output.set_columnName(value);"
        return "values[output.tupleIndex_" + columnName + "] = " +  codeValue + ";";
    }

    public String getCodeToSetOutField(boolean isReject, String columnName, String codeValue, String operator) {
        // TODO(rskraba): accessors for Values output, like
        // "output.set_columnName(value);"
        return "values[output.tupleIndex_" + columnName + "] " + operator + " " +  codeValue + ";";
    }

    public String getCodeToEmit(boolean isReject) {
        StringBuilder out = new StringBuilder();
        if (isMultiOutput)
            out.append("values[output.tupleIndexInternal_mux] = ").append(!isReject)
                .append(";");
        out.append("collector.emit(new Values(values));");
        return out.toString();
    }

    public void generateStormCode(org.talend.designer.common.TransformerBase transformer) {
        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    
            return;
        }

        // Both filter and reject outputs can use the same Storm BaseFunction,
        // since the reject output is a superset of the filter output.
        StormStreamUtil streamUtil = new StormStreamUtil(node);
        streamUtil.setInConnection(streamUtil.getFirstDataInConnection());
        IConnection outConn = streamUtil.getFirstNamedOutConnection("REJECT");
        if (outConn == null)
            outConn = streamUtil.getFirstOutConnection();
        streamUtil.setOutConnection(outConn);

        // The utility knows how to generate all the helper classes.
        transformer.generateHelperClasses(true);

        // The implementation can change depending on whether there are more
        // than a single output.
        isMultiOutput = transformer.isMultiOutput();

        // The outTw is the TupleWrapperHelper that defines the output for this
        // Storm function.
        TupleWrapperHelper outTw = null;
        if (isMultiOutput)
            outTw = generateStormCodeMultiOutputHelperClasses(streamUtil, transformer);
        else
            outTw = generateStormCodeSingleOutputHelperClasses(streamUtil, transformer);

        // Write the StormFunction that implements this component.
        
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(new TupleWrapperHelper().getClassName(streamUtil.getInConnection()));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(new TupleWrapperHelper().getClassName(streamUtil.getInConnection()));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(outTw);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(outTw);
    stringBuffer.append(TEXT_51);
     transformer.generateTransformContextDeclaration(); 
    stringBuffer.append(TEXT_52);
     transformer.generateTransformContextInitialization(); 
    stringBuffer.append(TEXT_53);
    stringBuffer.append( outTw.getSize() );
    stringBuffer.append(TEXT_54);
     transformer.generateTransform(); 
    stringBuffer.append(TEXT_55);
    
    }

    private TupleWrapperHelper generateStormCodeMultiOutputHelperClasses(
            StormStreamUtil streamUtil, org.talend.designer.common.TransformerBase transformer) {
        // Create a TupleWrapper with both main and reject fields, but base
        // it on the main row.
        TupleWrapperHelper combined = new TupleWrapperHelper(
                "TupleWrapperMO_" + transformer.getOutConnMainName(),
                transformer.getOutConnMain(),
                transformer.getOutColumnsMain());
        combined.union(transformer.getOutColumnsReject());
        // Add an extra column used to multiplex the data.  This is boolean
        // for now, but it could be sent to String if more than two outputs
        // are added.
        IMetadataColumn mux =
                new org.talend.core.model.metadata.MetadataColumn();
        combined.addInternalColumn("mux", "Internal",
                org.talend.core.model.metadata.types.JavaTypesManager.BOOLEAN);
        
    stringBuffer.append(TEXT_56);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(transformer.getOutConnRejectName());
    stringBuffer.append(TEXT_58);
    
        combined.generate();

        new TupleWrapperHelper(combined, transformer.getOutConnMain()).generate();
        new TupleWrapperHelper(combined, transformer.getOutConnReject()).generate();

        
    stringBuffer.append(TEXT_59);
    stringBuffer.append(combined);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(combined);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(combined);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(combined);
    stringBuffer.append(TEXT_63);
    
        return combined;
    }

    private TupleWrapperHelper generateStormCodeSingleOutputHelperClasses(
            StormStreamUtil streamUtil, org.talend.designer.common.TransformerBase transformer) {
        TupleWrapperHelper outTw = null != transformer.getOutConnMain()
                ? new TupleWrapperHelper(transformer.getOutConnMain())
                : new TupleWrapperHelper(transformer.getOutConnReject());
        outTw.generate();
        return outTw;
    }

    public void generateStormConfig(org.talend.designer.common.TransformerBase transformer) {
        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    
            return;
        }

        StormStreamUtil streamUtil = new StormStreamUtil(node);
        streamUtil.setInConnection(transformer.getInConn());
        IConnection outConn = transformer.getOutConnMain() != null
                ? transformer.getOutConnMain() : transformer.getOutConnReject();
        streamUtil.setOutConnection(outConn);
        streamUtil.generateAllOutStreamsDeclarations();

        // The implementation can change depending on whether there are more
        // than a single output.
        
    stringBuffer.append(TEXT_65);
    
            isMultiOutput = transformer.isMultiOutput();
            if (isMultiOutput)
                generateStormConfigMultiOutput(streamUtil, transformer);
            else
                generateStormConfigSingleOutput(streamUtil, transformer);
            
    stringBuffer.append(TEXT_66);
    

    }

    private void generateStormConfigMultiOutput(StormStreamUtil streamUtil,
            org.talend.designer.common.TransformerBase transformer) {
        // Needs to be consistent with multi-output stormCode.
        String codeTupleWrapperMO = "TupleWrapperMO_" + transformer.getOutConnMainName();
        
    stringBuffer.append(TEXT_67);
    stringBuffer.append( streamUtil.getCodeInStreamVariable() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(new TupleWrapperHelper().getFields(transformer.getInConn()));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(codeTupleWrapperMO);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(codeTupleWrapperMO);
    stringBuffer.append(TEXT_73);
    stringBuffer.append( transformer.getOutConnMainName() );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(codeTupleWrapperMO);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(codeTupleWrapperMO);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(new TupleWrapperHelper().getFields(transformer.getOutConnMain()));
    stringBuffer.append(TEXT_77);
    stringBuffer.append( transformer.getOutConnRejectName() );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(codeTupleWrapperMO);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(codeTupleWrapperMO);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(new TupleWrapperHelper().getFields(transformer.getOutConnReject()));
    stringBuffer.append(TEXT_81);
    
    }

    private void generateStormConfigSingleOutput(StormStreamUtil streamUtil,
            org.talend.designer.common.TransformerBase transformer) {
        
    stringBuffer.append(TEXT_82);
    stringBuffer.append( streamUtil.getOutConnection().getName() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append( streamUtil.getCodeInStreamVariable() );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(new TupleWrapperHelper().getFields(transformer.getInConn()));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(new TupleWrapperHelper().getFields(streamUtil.getOutConnection()));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(new TupleWrapperHelper().getFields(streamUtil.getOutConnection()));
    stringBuffer.append(TEXT_89);
    
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
        // TODO: these could be shared between all json nodes.
        generateClassConvertJSONString(isStatic);
        if (hasNodeCheck)
            generateClassOriginalJSONString(isStatic);
        generateClassXmlApi(isStatic);
    }

    private void generateClassConvertJSONString(boolean isStatic) {
    // Start generating code for ConvertJSONString_cid class.
    
    stringBuffer.append(TEXT_90);
    stringBuffer.append(isStatic ? "static" : "");
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
        // End generated code for ConvertJSONString_cid
    }

    private void generateClassOriginalJSONString(boolean isStatic) {
    // Start generating code for OriginalJSONString_cid class.
    
    stringBuffer.append(TEXT_93);
    stringBuffer.append(isStatic ? "static" : "");
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
        // End generated code for OriginalJSONString_cid class
    }

    private void generateClassXmlApi(boolean isStatic) {
    // Start generating code for XML_API_cid class.
    
    stringBuffer.append(TEXT_96);
    stringBuffer.append(isStatic ? "static" : "");
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
        // End generated code for XML_API_cid class
    }

    public void generateTransformContextDeclaration() {
    
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
     if (hasNodeCheck) { 
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
     } 
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
    }

    public void generateTransformContextInitialization() {
        
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
     if (hasNodeCheck) { 
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
     } 
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    
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
        
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
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
    
        generateTransformParseJsonInputField();
        // After this call, the isStructError_cid member is false if the json
        // input was correctly parsed into the common structures.
        
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
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
                        
    stringBuffer.append(TEXT_155);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(false, copiedInColumns));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(getRowTransform().getCodeToEmit(false));
    
                    }
                    
    stringBuffer.append(TEXT_157);
    
                    generateTransformReject(dieOnError, "ex", null, "originalJsonStr_"+cid);
                    
    stringBuffer.append(TEXT_158);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(getRowTransform().getCodeToInitOut(null == getOutConnMain(), newOutColumns));
    stringBuffer.append(TEXT_160);
    
    }


    /**
     * Part of the code generation for parsing the input field into several of
     * the variables that are used to generate output.
     */
    private void generateTransformParseJsonInputField() {
        // Parse the structure.
        
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(encoding);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
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
    
            generateTransformReject(dieOnError, "ex", null, "originalJsonStr_"+cid);
            
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
     if (dieOnError) { 
    stringBuffer.append(TEXT_198);
     } else { 
    stringBuffer.append(TEXT_199);
     } 
    stringBuffer.append(TEXT_200);
    
    }

    /**
     * Generates code that performs the tranformation from one JSON input string
     * to many output strings, or to a reject flow.
     */
    private void generateTransformForMapping(final boolean nodeCheck,
            final boolean isArrayCheck, final String query, final String columnName) {
        
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    
        if (!isArrayCheck) {
            
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
                if (nodeCheck) { // isArrayCheck is false nodeCheck is true
                    // TODO : what exactly does this match?
                    boolean isGetWholeJson = ".".equals(query.substring(1,query.length()-1)) && "/".equals(loopQuery.substring(1,loopQuery.length()-1));
                    
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
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(isGetWholeJson);
    stringBuffer.append(TEXT_228);
    
                } else { // isArrayCheck is false nodeCheck is false
                
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    
                }
                
    stringBuffer.append(TEXT_233);
    
        } else { // isArrayCheck is true
            if (nodeCheck) { // isArrayCheck is true and nodeCheck true
                boolean isGetWholeJson = ".".equals(query.substring(1,query.length()-1)) && "/".equals(loopQuery.substring(1,loopQuery.length()-1));
                
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(isGetWholeJson);
    stringBuffer.append(TEXT_250);
    
             } else { // isArrayCheck true nodeCheck false
                
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    
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
                    
    stringBuffer.append(TEXT_258);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "str_" + cid));
    
                    continue;
                }

                if(!isArrayCheck){
                    if (javaType == JavaTypesManager.STRING) {
                        if (column.isNullable()) {
                            
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null"));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "\"\""));
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?null:column.getDefault()));
    stringBuffer.append(TEXT_271);
    
                        } else {
                            
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "\"\""));
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault()));
    stringBuffer.append(TEXT_280);
    
                        }
                    } else { // javaType is not STRING
                        if (column.isNullable()) {
                            
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null") );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?null:column.getDefault()));
    stringBuffer.append(TEXT_291);
    
                        } else {  // column.isNullable()
                            
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault()));
    stringBuffer.append(TEXT_298);
    
                        }
                    }
                    // At this point, there is a dangling } else { in the generated code

                    if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
                        
    stringBuffer.append(TEXT_299);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "str_" + cid));
    
                    } else { // javaType is not STRING or OBJECT
                        if (javaType == JavaTypesManager.DATE) {
                            
    stringBuffer.append(TEXT_300);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(str_"+cid+", "+patternValue+")"));
    
                        } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
                            
    stringBuffer.append(TEXT_301);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "java.nio.ByteBuffer.wrap(str_" + cid + ".getBytes())"));
    
                        } else {
                            
    stringBuffer.append(TEXT_302);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_"+typeToGenerate+"(str_"+cid+")"));
    
                        }
                    }

                    // Close the dangling else.
                    
    stringBuffer.append(TEXT_303);
    

                } else { // !isArrayCheck
                    
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null") );
    stringBuffer.append(TEXT_307);
    
                        if (javaType == JavaTypesManager.STRING) {
                        
    stringBuffer.append(TEXT_308);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "xmlListTemp_"+cid+".toString()") );
    
                        } else if(javaType == JavaTypesManager.LIST || javaType == JavaTypesManager.OBJECT) {
                        
    stringBuffer.append(TEXT_309);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "xmlListTemp_"+cid));
    
                        }
                        
    stringBuffer.append(TEXT_310);
    
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
            
    stringBuffer.append(TEXT_311);
    stringBuffer.append(getRowTransform().getCodeToCopyOutMainToReject(newOutColumns));
    
        }

        if (die) {
            
    stringBuffer.append(TEXT_312);
    stringBuffer.append(codeException);
    stringBuffer.append(TEXT_313);
    
        } else {
            if (null == getOutConnReject()) {
                
    stringBuffer.append(TEXT_314);
    
                generateLogMessage(codeRejectMsg);
            } else {
                
    stringBuffer.append(TEXT_315);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_MSG,
                        codeRejectMsg) );
    
                if (containsRejectField) {
                    
    stringBuffer.append(TEXT_317);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_FIELD,
                        codeRejectField) );
    
                }
                
    stringBuffer.append(TEXT_318);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(true, copiedInColumns));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(getRowTransform().getCodeToEmit(true));
    
            }
        }
    }
}

    
final StormRowTransformUtil rowTransformUtil = new StormRowTransformUtil();
final TExtractJSONFieldsUtil tExtractJSONFieldsUtil = new TExtractJSONFieldsUtil(
        node, codeGenArgument, rowTransformUtil);
rowTransformUtil.generateStormCode(tExtractJSONFieldsUtil);

    return stringBuffer.toString();
  }
}
