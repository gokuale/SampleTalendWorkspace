package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.NodeUtil;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.common.CommonRowTransformUtil;
import org.talend.designer.common.TransformerBase;
import org.talend.designer.common.TransformerBaseUtil;

public class TExtractXMLFieldSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TExtractXMLFieldSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractXMLFieldSparkstreamingcodeJava result = new TExtractXMLFieldSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "            public static class ";
  protected final String TEXT_3 = " implements ";
  protected final String TEXT_4 = " {";
  protected final String TEXT_5 = NL + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_6 = "(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "\t            public ";
  protected final String TEXT_7 = " ";
  protected final String TEXT_8 = "(";
  protected final String TEXT_9 = ") ";
  protected final String TEXT_10 = " {" + NL + "\t            \t";
  protected final String TEXT_11 = NL + "\t            \t";
  protected final String TEXT_12 = NL + "\t                ";
  protected final String TEXT_13 = NL + "\t                return ";
  protected final String TEXT_14 = ";" + NL + "\t            }" + NL + "\t        }" + NL + "\t\t";
  protected final String TEXT_15 = NL + "            public static class ";
  protected final String TEXT_16 = " implements ";
  protected final String TEXT_17 = " {";
  protected final String TEXT_18 = NL + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_19 = "(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_20 = " ";
  protected final String TEXT_21 = "(";
  protected final String TEXT_22 = ") ";
  protected final String TEXT_23 = " {" + NL + "                \t";
  protected final String TEXT_24 = NL + "\t                 \treturn ";
  protected final String TEXT_25 = ";";
  protected final String TEXT_26 = NL + "                }" + NL + "            }";
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL + "            // No sparkcode generated for unnecessary ";
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL + "            public static class ";
  protected final String TEXT_31 = "TrueFilter implements org.apache.spark.api.java.function.Function<scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase>, Boolean> {" + NL + "" + NL + "                public Boolean call(scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> arg0)" + NL + "                        throws Exception {" + NL + "                    return arg0._1;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public static class ";
  protected final String TEXT_32 = "FalseFilter implements org.apache.spark.api.java.function.Function<scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase>, Boolean> {" + NL + "" + NL + "                public Boolean call(scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> arg0)" + NL + "                        throws Exception {" + NL + "                    return !arg0._1;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public static class ";
  protected final String TEXT_33 = "ToNullWritableMain implements ";
  protected final String TEXT_34 = " {" + NL + "" + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_35 = "ToNullWritableMain(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_36 = " call(" + NL + "                        scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> data){";
  protected final String TEXT_37 = NL + "                    ";
  protected final String TEXT_38 = " ";
  protected final String TEXT_39 = " = (";
  protected final String TEXT_40 = ")data._2; " + NL + "                    return ";
  protected final String TEXT_41 = ";" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public static class ";
  protected final String TEXT_42 = "ToNullWritableReject implements ";
  protected final String TEXT_43 = " {" + NL + "" + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_44 = "ToNullWritableReject(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_45 = " call(" + NL + "                        scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> data){";
  protected final String TEXT_46 = NL + "                        ";
  protected final String TEXT_47 = " ";
  protected final String TEXT_48 = " = (";
  protected final String TEXT_49 = ")data._2; " + NL + "                    return ";
  protected final String TEXT_50 = ";" + NL + "                }" + NL + "            }";
  protected final String TEXT_51 = NL + "            // No sparkconfig generated for unnecessary ";
  protected final String TEXT_52 = NL;
  protected final String TEXT_53 = NL + "            // Extract data." + NL + "            ";
  protected final String TEXT_54 = NL + "            ";
  protected final String TEXT_55 = "<Boolean, org.apache.avro.specific.SpecificRecordBase> temporary_rdd_";
  protected final String TEXT_56 = " = rdd_";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = "(new ";
  protected final String TEXT_59 = "(job));" + NL + "" + NL + "            // Main flow" + NL;
  protected final String TEXT_60 = NL + "            ";
  protected final String TEXT_61 = " rdd_";
  protected final String TEXT_62 = " = temporary_rdd_";
  protected final String TEXT_63 = NL + "                  .filter(new ";
  protected final String TEXT_64 = "TrueFilter())" + NL + "                    .";
  protected final String TEXT_65 = "(new ";
  protected final String TEXT_66 = "ToNullWritableMain(job));" + NL + "" + NL + "            // Reject flow";
  protected final String TEXT_67 = NL + "            ";
  protected final String TEXT_68 = " rdd_";
  protected final String TEXT_69 = " = temporary_rdd_";
  protected final String TEXT_70 = NL + "                    .filter(new ";
  protected final String TEXT_71 = "FalseFilter())" + NL + "                    .";
  protected final String TEXT_72 = "(new ";
  protected final String TEXT_73 = "ToNullWritableReject(job));";
  protected final String TEXT_74 = NL + "            ";
  protected final String TEXT_75 = " rdd_";
  protected final String TEXT_76 = " = rdd_";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = "(new ";
  protected final String TEXT_79 = "(job));";
  protected final String TEXT_80 = NL + "        ";
  protected final String TEXT_81 = " class NameSpaceTool_";
  protected final String TEXT_82 = " implements Serializable{" + NL + "" + NL + "            public java.util.HashMap<String, String> xmlNameSpaceMap = new java.util.HashMap<String, String>();" + NL + "            private java.util.List<String> defaultNSPath = new java.util.ArrayList<String>();" + NL + "" + NL + "            public void countNSMap(org.dom4j.Element el) {" + NL + "                for (org.dom4j.Namespace ns : (java.util.List<org.dom4j.Namespace>) el.declaredNamespaces()) {" + NL + "                    if (ns.getPrefix().trim().length() == 0) {" + NL + "                        xmlNameSpaceMap.put(\"pre\"+defaultNSPath.size(), ns.getURI());" + NL + "                        String path = \"\";" + NL + "                        org.dom4j.Element elTmp = el;" + NL + "                        while (elTmp != null) {" + NL + "                            if (elTmp.getNamespacePrefix() != null && elTmp.getNamespacePrefix().length() > 0) {" + NL + "                                path = \"/\" + elTmp.getNamespacePrefix() + \":\" + elTmp.getName() + path;" + NL + "                            } else {" + NL + "                                path = \"/\" + elTmp.getName() + path;" + NL + "                            }" + NL + "                            elTmp = elTmp.getParent();" + NL + "                        }" + NL + "                        defaultNSPath.add(path);" + NL + "                    } else {" + NL + "                        xmlNameSpaceMap.put(ns.getPrefix(), ns.getURI());" + NL + "                    }" + NL + "" + NL + "                }" + NL + "                for (org.dom4j.Element e : (java.util.List<org.dom4j.Element>) el.elements()) {" + NL + "                    countNSMap(e);" + NL + "                }" + NL + "            }" + NL + "" + NL + "            /**" + NL + "             *  the regex for the xpath like that :" + NL + "             *  case 1 : functionA(locationXPathExpression)" + NL + "             *  case 2 : fn:functionA(locationXPathExpression)" + NL + "             *  case 3 : functionA(functionB(locationXPathExpression))" + NL + "             *  case 4 : fn:functionA(fn:functionB(locationXPathExpression))" + NL + "             *  and like that." + NL + "            */" + NL + "            private java.util.regex.Pattern simpleFunctionPattern;" + NL + "            private StringBuffer stringBuffer;" + NL + "            private java.util.Map<String,String> resultCache;" + NL + "" + NL + "            public String addDefaultNSPrefix(final String xpathExpression, String loopPath) {" + NL + "                if (defaultNSPath.size() < 1) {" + NL + "                    return xpathExpression;" + NL + "                }" + NL + "" + NL + "                if(resultCache == null) {" + NL + "                    resultCache = new java.util.HashMap<String,String>();" + NL + "                }" + NL + "" + NL + "                String resultXpathExpression = resultCache.get(xpathExpression);" + NL + "                if(resultXpathExpression!=null) {" + NL + "                    return resultXpathExpression;" + NL + "                }" + NL + "" + NL + "                String locationPathExpression = xpathExpression;" + NL + "" + NL + "                if(simpleFunctionPattern == null) {" + NL + "                    simpleFunctionPattern = java.util.regex.Pattern.compile(\"([a-zA-z0-9]+:)?[a-zA-Z]+-?[A-Za-z]+\\\\(.*\\\\)\");" + NL + "                }" + NL + "" + NL + "                boolean isSimpleFunctionXPath = simpleFunctionPattern.matcher(xpathExpression).matches();" + NL + "                String tail = null;" + NL + "                if(isSimpleFunctionXPath) {" + NL + "                    int start = xpathExpression.lastIndexOf('(');" + NL + "                    int end = xpathExpression.indexOf(')');" + NL + "                    if(start < end) {" + NL + "                        if(stringBuffer == null) {" + NL + "                            stringBuffer = new StringBuffer();" + NL + "                        }" + NL + "                        locationPathExpression = xpathExpression.substring(start+1,end);" + NL + "                        stringBuffer.append(xpathExpression.substring(0,start+1));" + NL + "                        tail = xpathExpression.substring(end);" + NL + "                    } else {" + NL + "                        isSimpleFunctionXPath = false;" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                locationPathExpression = addDefaultNSPrefixForLocationXPathExpression(locationPathExpression,loopPath);" + NL + "" + NL + "                resultXpathExpression = locationPathExpression;" + NL + "" + NL + "                if(isSimpleFunctionXPath) {" + NL + "                    stringBuffer.append(locationPathExpression);" + NL + "                    stringBuffer.append(tail);" + NL + "                    resultXpathExpression = stringBuffer.toString();" + NL + "                    stringBuffer.setLength(0);" + NL + "                }" + NL + "" + NL + "                resultCache.put(xpathExpression,resultXpathExpression);" + NL + "                return resultXpathExpression;" + NL + "            }" + NL + "" + NL + "            private String addDefaultNSPrefixForLocationXPathExpression(String path, String loopPath) {" + NL + "                String fullPath = loopPath;" + NL + "                if(!path.equals(fullPath)){" + NL + "                    for (String tmp : path.split(\"/\")) {" + NL + "                        if ((\"..\").equals(tmp)) {" + NL + "                            fullPath = fullPath.substring(0, fullPath.lastIndexOf(\"/\"));" + NL + "                        } else {" + NL + "                            fullPath += \"/\" + tmp;" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "                int[] indexs = new int[fullPath.split(\"/\").length - 1];" + NL + "                java.util.Arrays.fill(indexs, -1);" + NL + "                int length = 0;" + NL + "                for (int i = 0; i < defaultNSPath.size(); i++) {" + NL + "                    if (defaultNSPath.get(i).length() > length && fullPath.startsWith(defaultNSPath.get(i))) {" + NL + "                        java.util.Arrays.fill(indexs, defaultNSPath.get(i).split(\"/\").length - 2, indexs.length, i);" + NL + "                        length = defaultNSPath.get(i).length();" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                StringBuilder newPath = new StringBuilder();" + NL + "                String[] pathStrs = path.split(\"/\");" + NL + "                for (int i = 0; i < pathStrs.length; i++) {" + NL + "                    String tmp = pathStrs[i];" + NL + "                    if (newPath.length() > 0) {" + NL + "                        newPath.append(\"/\");" + NL + "                    }" + NL + "                    if (tmp.length() > 0 && tmp.indexOf(\":\") == -1 && tmp.indexOf(\".\") == -1 /*&& tmp.indexOf(\"@\") == -1*/) {" + NL + "                        int index = indexs[i + indexs.length - pathStrs.length];" + NL + "                        if (index >= 0) {" + NL + "                            if(tmp.indexOf(\"[\")>0 && tmp.indexOf(\"]\")>tmp.indexOf(\"[\")){//include filter" + NL + "                                String tmpStr=replaceElementWithNS(tmp,\"pre\"+index+\":\");" + NL + "                                newPath.append(tmpStr);" + NL + "                            }else{" + NL + "                                if(tmp.indexOf(\"@\") != -1 || tmp.indexOf(\"(\")<tmp.indexOf(\")\")){  // include attribute" + NL + "                                    newPath.append(tmp);" + NL + "                                }else{" + NL + "                                    newPath.append(\"pre\").append(index).append(\":\").append(tmp);" + NL + "                                }" + NL + "                            }" + NL + "                        } else {" + NL + "                            newPath.append(tmp);" + NL + "                        }" + NL + "                    } else {" + NL + "                        newPath.append(tmp);" + NL + "                    }" + NL + "                }" + NL + "                return newPath.toString();" + NL + "            }" + NL + "" + NL + "            private String matches = \"@*\\\\b[a-z|A-Z|_]+[[-]*\\\\w]*\\\\b[^'|^\\\\(]\";" + NL + "            private java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(matches);" + NL + "" + NL + "            private String replaceElementWithNS(String global, String pre){" + NL + "" + NL + "                java.util.regex.Matcher match = pattern.matcher(global);" + NL + "                StringBuffer sb = new StringBuffer();" + NL + "                match.reset();" + NL + "                while (match.find()) {" + NL + "                    String group = match.group();" + NL + "                    String tmp = \"\";" + NL + "                    if (group.toLowerCase().matches(\"\\\\b(div|mod|and|or)\\\\b.*\") || group.matches(\"@.*\")) {" + NL + "                        tmp = group;" + NL + "                    } else {" + NL + "                        tmp = tmp + pre + group;" + NL + "                    }" + NL + "                    match.appendReplacement(sb, tmp);" + NL + "                }" + NL + "                match.appendTail(sb);" + NL + "" + NL + "                return sb.toString();" + NL + "            }" + NL + "" + NL + "        }";
  protected final String TEXT_83 = NL + "        ";
  protected final String TEXT_84 = " class XML_API_";
  protected final String TEXT_85 = " implements Serializable {" + NL + "            public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "                if (node != null && node instanceof org.dom4j.Element) {" + NL + "                    org.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "                    if(attri != null && (\"true\").equals(attri.getText())){" + NL + "                        return true;" + NL + "                    }" + NL + "                }" + NL + "                return false;" + NL + "            }" + NL + "" + NL + "            public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "                return node == null;" + NL + "            }" + NL + "" + NL + "            public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "                return node != null && node.getText().length() == 0;" + NL + "            }" + NL;
  protected final String TEXT_86 = NL + "        }";
  protected final String TEXT_87 = NL + "                    }";
  protected final String TEXT_88 = NL + "                    public void putUnExtractValue_";
  protected final String TEXT_89 = "(";
  protected final String TEXT_90 = NL + "                        ";
  protected final String TEXT_91 = "Struct ";
  protected final String TEXT_92 = ",";
  protected final String TEXT_93 = NL + "                        ";
  protected final String TEXT_94 = "Struct ";
  protected final String TEXT_95 = ") {";
  protected final String TEXT_96 = NL + "            ";
  protected final String TEXT_97 = NL + "            }";
  protected final String TEXT_98 = NL + "                        }";
  protected final String TEXT_99 = NL + "                    public void putExtractValue_";
  protected final String TEXT_100 = "(";
  protected final String TEXT_101 = "Struct ";
  protected final String TEXT_102 = ",";
  protected final String TEXT_103 = NL + "                            ";
  protected final String TEXT_104 = NL + "                            String xmlStr_";
  protected final String TEXT_105 = "," + NL + "                            org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_106 = "," + NL + "                            NameSpaceTool_";
  protected final String TEXT_107 = " nsTool_";
  protected final String TEXT_108 = ",String loopQuery_";
  protected final String TEXT_109 = "," + NL + "                            java.util.HashMap xmlNameSpaceMap_";
  protected final String TEXT_110 = "," + NL + "                            org.dom4j.Node node_";
  protected final String TEXT_111 = "," + NL + "                            String str_";
  protected final String TEXT_112 = ",XML_API_";
  protected final String TEXT_113 = " xml_api_";
  protected final String TEXT_114 = NL + "                            ";
  protected final String TEXT_115 = NL + "                            ) throws java.lang.Exception {" + NL + "                        boolean resultIsNode_";
  protected final String TEXT_116 = " = true;";
  protected final String TEXT_117 = NL + "            }";
  protected final String TEXT_118 = NL + "                                }";
  protected final String TEXT_119 = NL + "                                public void putRejectValueBeforeExtract_";
  protected final String TEXT_120 = "(";
  protected final String TEXT_121 = NL + "                                        ";
  protected final String TEXT_122 = "Struct ";
  protected final String TEXT_123 = ",";
  protected final String TEXT_124 = NL + "                                        ";
  protected final String TEXT_125 = "Struct ";
  protected final String TEXT_126 = ") {";
  protected final String TEXT_127 = NL + "                        ";
  protected final String TEXT_128 = NL + "            }";
  protected final String TEXT_129 = NL + "                    }";
  protected final String TEXT_130 = NL + "                public void putRejectValueAfterExtract_";
  protected final String TEXT_131 = "(";
  protected final String TEXT_132 = NL + "                        ";
  protected final String TEXT_133 = "Struct ";
  protected final String TEXT_134 = ",";
  protected final String TEXT_135 = NL + "                        ";
  protected final String TEXT_136 = "Struct ";
  protected final String TEXT_137 = "){";
  protected final String TEXT_138 = NL + "            ";
  protected final String TEXT_139 = NL + "            }";
  protected final String TEXT_140 = NL + "        ";
  protected final String TEXT_141 = " class XML_NS_RMV_";
  protected final String TEXT_142 = " {" + NL + "            public void removeNamespace(org.dom4j.Document reader," + NL + "                    org.dom4j.Document writer) {" + NL + "                org.dom4j.Element elemReader = reader.getRootElement();" + NL + "                org.dom4j.Element elemTo = writer.addElement(elemReader" + NL + "                        .getName());" + NL + "                if(elemReader!=null && elemReader.getText()!=null && !\"\".equals(elemReader.getText())){" + NL + "                    elemTo.setText(elemReader.getText());" + NL + "                }" + NL + "                for (org.dom4j.Attribute attri : (java.util.List<org.dom4j.Attribute>) elemReader" + NL + "                        .attributes()) {" + NL + "                    elemTo.addAttribute(attri.getName(),attri.getText());" + NL + "                }" + NL + "                removeSubNamespace(elemReader, elemTo);" + NL + "            }" + NL + "" + NL + "            public void removeSubNamespace(org.dom4j.Element elemFrom," + NL + "                    org.dom4j.Element elemTo) {" + NL + "                for (org.dom4j.Element subFrom : (java.util.List<org.dom4j.Element>) elemFrom" + NL + "                        .elements()) {" + NL + "                    org.dom4j.Element tmpElemTo = elemTo.addElement(subFrom" + NL + "                            .getName());" + NL + "                    if(subFrom!=null && subFrom.getText()!=null && !\"\".equals(subFrom.getText())){" + NL + "                        tmpElemTo.setText(subFrom.getText());" + NL + "                    }" + NL + "                    for (org.dom4j.Attribute attri : (java.util.List<org.dom4j.Attribute>) subFrom" + NL + "                            .attributes()) {" + NL + "                        tmpElemTo.addAttribute(attri.getName(),attri.getText());" + NL + "                    }" + NL + "                    removeSubNamespace(subFrom, tmpElemTo);" + NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_143 = NL + "        XML_API_";
  protected final String TEXT_144 = " xml_api_";
  protected final String TEXT_145 = " = new XML_API_";
  protected final String TEXT_146 = "();";
  protected final String TEXT_147 = NL + "            XML_NS_RMV_";
  protected final String TEXT_148 = " XML_ns_rmv_";
  protected final String TEXT_149 = " = null;" + NL + "            org.jaxen.NamespaceContext namespaceContext_";
  protected final String TEXT_150 = " = null;";
  protected final String TEXT_151 = NL + "        String xmlStr_";
  protected final String TEXT_152 = " = null;" + NL + "        String loopQuery_";
  protected final String TEXT_153 = " = null;" + NL + "" + NL + "        NameSpaceTool_";
  protected final String TEXT_154 = " nsTool_";
  protected final String TEXT_155 = " = new NameSpaceTool_";
  protected final String TEXT_156 = "();" + NL + "" + NL + "        javax.xml.stream.XMLOutputFactory xmlOutputFactory_";
  protected final String TEXT_157 = " = null;" + NL + "        org.dom4j.io.SAXReader reader_";
  protected final String TEXT_158 = " = null;" + NL + "        org.dom4j.Document doc_";
  protected final String TEXT_159 = " = null;" + NL + "        java.util.HashMap<String, String> xmlNameSpaceMap_";
  protected final String TEXT_160 = " = new java.util.HashMap<String, String>();" + NL + "        org.dom4j.XPath x_";
  protected final String TEXT_161 = " = null;" + NL + "        java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_162 = " = null;";
  protected final String TEXT_163 = NL;
  protected final String TEXT_164 = NL + "            XML_ns_rmv_";
  protected final String TEXT_165 = " = new XML_NS_RMV_";
  protected final String TEXT_166 = "();" + NL + "            namespaceContext_";
  protected final String TEXT_167 = " = new org.jaxen.NamespaceContext() {" + NL + "                public String translateNamespacePrefixToUri(String prefix) {" + NL + "                    return \"\";//ignore prefix in xpath when evaluate" + NL + "                }" + NL + "            };";
  protected final String TEXT_168 = NL + NL + "        xmlOutputFactory_";
  protected final String TEXT_169 = " = javax.xml.stream.XMLOutputFactory.newInstance();" + NL + "        reader_";
  protected final String TEXT_170 = " = new org.dom4j.io.SAXReader();" + NL + NL;
  protected final String TEXT_171 = NL + "            loopQuery_";
  protected final String TEXT_172 = " = ";
  protected final String TEXT_173 = " + ";
  protected final String TEXT_174 = ";";
  protected final String TEXT_175 = NL + "            loopQuery_";
  protected final String TEXT_176 = " = ";
  protected final String TEXT_177 = ";";
  protected final String TEXT_178 = NL + "        if (";
  protected final String TEXT_179 = " != null) {" + NL + "            xmlStr_";
  protected final String TEXT_180 = " = ";
  protected final String TEXT_181 = ";" + NL + "        } else {" + NL + "            return";
  protected final String TEXT_182 = ";" + NL + "        }" + NL + "" + NL + "        boolean isStructError_";
  protected final String TEXT_183 = " = true;" + NL;
  protected final String TEXT_184 = NL + "            org.dom4j.Document doc_tmp_";
  protected final String TEXT_185 = " = org.dom4j.DocumentHelper.createDocument();" + NL + "            XML_ns_rmv_";
  protected final String TEXT_186 = ".removeNamespace(xmlDocument_";
  protected final String TEXT_187 = ".getDocument()," + NL + "                doc_tmp_";
  protected final String TEXT_188 = ");";
  protected final String TEXT_189 = NL + "            org.dom4j.Document doc_tmp_";
  protected final String TEXT_190 = " = org.dom4j.DocumentHelper.createDocument();" + NL + "            try {" + NL + "                XML_ns_rmv_";
  protected final String TEXT_191 = ".removeNamespace(" + NL + "                    reader_";
  protected final String TEXT_192 = ".read(new java.io.StringReader(xmlStr_";
  protected final String TEXT_193 = "))," + NL + "                    doc_tmp_";
  protected final String TEXT_194 = ");" + NL + "            } catch (org.dom4j.DocumentException e) {";
  protected final String TEXT_195 = NL + "            }";
  protected final String TEXT_196 = NL + NL + "        boolean resultIsNode_";
  protected final String TEXT_197 = " = true;" + NL + "        java.io.ByteArrayInputStream bais_";
  protected final String TEXT_198 = " = null;" + NL + "        java.io.ByteArrayOutputStream  baos_";
  protected final String TEXT_199 = " = new java.io.ByteArrayOutputStream();" + NL;
  protected final String TEXT_200 = NL + NL + "         org.dom4j.Node node_";
  protected final String TEXT_201 = " = null;" + NL + "         String str_";
  protected final String TEXT_202 = " = \"\";" + NL + "         org.dom4j.XPath xTmp_";
  protected final String TEXT_203 = " = null;" + NL + "         Object obj_";
  protected final String TEXT_204 = " = null;" + NL + "         String xmlStrTemp_";
  protected final String TEXT_205 = " = \"\";" + NL + "        java.util.List<String> xmlListTemp_";
  protected final String TEXT_206 = " = null;" + NL + "" + NL + "" + NL + "        if (!isStructError_";
  protected final String TEXT_207 = " && nodeList_";
  protected final String TEXT_208 = " != null) {" + NL + "            for (org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_209 = " : nodeList_";
  protected final String TEXT_210 = ") {";
  protected final String TEXT_211 = NL + "                    ";
  protected final String TEXT_212 = " = new ";
  protected final String TEXT_213 = "();";
  protected final String TEXT_214 = NL + "                    ";
  protected final String TEXT_215 = " = new ";
  protected final String TEXT_216 = "();";
  protected final String TEXT_217 = NL + "                try {";
  protected final String TEXT_218 = NL + "                        ";
  protected final String TEXT_219 = NL + "                        ";
  protected final String TEXT_220 = NL + "                    ";
  protected final String TEXT_221 = NL + "                } catch (java.lang.Exception ex) {";
  protected final String TEXT_222 = NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_223 = NL + "        try{";
  protected final String TEXT_224 = NL + "                    doc_";
  protected final String TEXT_225 = "= xmlDocument_";
  protected final String TEXT_226 = ".getDocument();";
  protected final String TEXT_227 = NL + "                    doc_";
  protected final String TEXT_228 = "= reader_";
  protected final String TEXT_229 = ".read(new java.io.StringReader(xmlStr_";
  protected final String TEXT_230 = "));";
  protected final String TEXT_231 = NL + "                doc_";
  protected final String TEXT_232 = "= doc_tmp_";
  protected final String TEXT_233 = ";";
  protected final String TEXT_234 = NL + NL + "            nsTool_";
  protected final String TEXT_235 = ".countNSMap(doc_";
  protected final String TEXT_236 = ".getRootElement());" + NL + "            xmlNameSpaceMap_";
  protected final String TEXT_237 = " = nsTool_";
  protected final String TEXT_238 = ".xmlNameSpaceMap;" + NL + "            x_";
  protected final String TEXT_239 = " = doc_";
  protected final String TEXT_240 = ".createXPath(nsTool_";
  protected final String TEXT_241 = ".addDefaultNSPrefix(loopQuery_";
  protected final String TEXT_242 = ",loopQuery_";
  protected final String TEXT_243 = "));" + NL + "            x_";
  protected final String TEXT_244 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_245 = ");";
  protected final String TEXT_246 = NL + "                x_";
  protected final String TEXT_247 = ".setNamespaceContext(namespaceContext_";
  protected final String TEXT_248 = ");";
  protected final String TEXT_249 = NL + "            nodeList_";
  protected final String TEXT_250 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_251 = ".selectNodes(doc_";
  protected final String TEXT_252 = ");" + NL + "            isStructError_";
  protected final String TEXT_253 = " = false;" + NL + "" + NL + "        } catch (java.lang.Exception ex) {";
  protected final String TEXT_254 = NL + "        } finally {" + NL + "            try {" + NL + "                baos_";
  protected final String TEXT_255 = ".close();" + NL + "                if (bais_";
  protected final String TEXT_256 = " != null) {" + NL + "                    bais_";
  protected final String TEXT_257 = ".close();" + NL + "                }" + NL + "            } catch (IOException e) {";
  protected final String TEXT_258 = NL + "                    throw new java.io.IOException(e.getMessage());";
  protected final String TEXT_259 = NL + "                    System.err.println(e.getMessage());";
  protected final String TEXT_260 = NL + "            }" + NL + "        }";
  protected final String TEXT_261 = NL + NL + "        org.dom4j.XPath xTmp";
  protected final String TEXT_262 = "_";
  protected final String TEXT_263 = " = temp_";
  protected final String TEXT_264 = ".createXPath(nsTool_";
  protected final String TEXT_265 = ".addDefaultNSPrefix(";
  protected final String TEXT_266 = ",loopQuery_";
  protected final String TEXT_267 = "));" + NL + "        xTmp";
  protected final String TEXT_268 = "_";
  protected final String TEXT_269 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_270 = ");" + NL;
  protected final String TEXT_271 = NL + "            xTmp";
  protected final String TEXT_272 = "_";
  protected final String TEXT_273 = ".setNamespaceContext(namespaceContext_";
  protected final String TEXT_274 = ");";
  protected final String TEXT_275 = NL + NL + "        Object obj";
  protected final String TEXT_276 = "_";
  protected final String TEXT_277 = " = xTmp";
  protected final String TEXT_278 = "_";
  protected final String TEXT_279 = ".evaluate(temp_";
  protected final String TEXT_280 = ");" + NL + "        if (obj";
  protected final String TEXT_281 = "_";
  protected final String TEXT_282 = " instanceof String || obj";
  protected final String TEXT_283 = "_";
  protected final String TEXT_284 = " instanceof Number) {" + NL + "            resultIsNode_";
  protected final String TEXT_285 = " = false;" + NL + "            str_";
  protected final String TEXT_286 = " = String.valueOf(obj";
  protected final String TEXT_287 = "_";
  protected final String TEXT_288 = ");" + NL + "        } else {" + NL + "            resultIsNode_";
  protected final String TEXT_289 = " = true;" + NL + "            node_";
  protected final String TEXT_290 = " = xTmp";
  protected final String TEXT_291 = "_";
  protected final String TEXT_292 = ".selectSingleNode(temp_";
  protected final String TEXT_293 = ");" + NL;
  protected final String TEXT_294 = NL + "                str_";
  protected final String TEXT_295 = " = node_";
  protected final String TEXT_296 = " == null ? null : node_";
  protected final String TEXT_297 = ".asXML();";
  protected final String TEXT_298 = NL + "                str_";
  protected final String TEXT_299 = " = xTmp";
  protected final String TEXT_300 = "_";
  protected final String TEXT_301 = ".valueOf(temp_";
  protected final String TEXT_302 = ");";
  protected final String TEXT_303 = NL + "        }" + NL;
  protected final String TEXT_304 = NL + "                            ";
  protected final String TEXT_305 = NL + "                            ";
  protected final String TEXT_306 = NL + "                        ";
  protected final String TEXT_307 = NL + "                        ";
  protected final String TEXT_308 = NL + "                        ";
  protected final String TEXT_309 = NL + "                        if (resultIsNode_";
  protected final String TEXT_310 = " && xml_api_";
  protected final String TEXT_311 = ".isDefNull(node_";
  protected final String TEXT_312 = ")) {";
  protected final String TEXT_313 = NL + "                            ";
  protected final String TEXT_314 = NL + "                        } else if (resultIsNode_";
  protected final String TEXT_315 = " && xml_api_";
  protected final String TEXT_316 = ".isEmpty(node_";
  protected final String TEXT_317 = ")) {";
  protected final String TEXT_318 = NL + "                            ";
  protected final String TEXT_319 = NL + "                        } else if (resultIsNode_";
  protected final String TEXT_320 = " && xml_api_";
  protected final String TEXT_321 = ".isMissing(node_";
  protected final String TEXT_322 = " )){";
  protected final String TEXT_323 = NL + "                            ";
  protected final String TEXT_324 = NL + "                        } else{";
  protected final String TEXT_325 = NL + "                        if (resultIsNode_";
  protected final String TEXT_326 = " && xml_api_";
  protected final String TEXT_327 = ".isEmpty(node_";
  protected final String TEXT_328 = ")) {";
  protected final String TEXT_329 = NL + "                            ";
  protected final String TEXT_330 = NL + "                        } else if (resultIsNode_";
  protected final String TEXT_331 = " && xml_api_";
  protected final String TEXT_332 = ".isMissing(node_";
  protected final String TEXT_333 = ")) {";
  protected final String TEXT_334 = NL + "                            ";
  protected final String TEXT_335 = NL + "                        } else {";
  protected final String TEXT_336 = NL + "                        if (resultIsNode_";
  protected final String TEXT_337 = " && xml_api_";
  protected final String TEXT_338 = ".isDefNull(node_";
  protected final String TEXT_339 = ")) {";
  protected final String TEXT_340 = NL + "                            ";
  protected final String TEXT_341 = NL + "                        } else if (resultIsNode_";
  protected final String TEXT_342 = " && (xml_api_";
  protected final String TEXT_343 = ".isEmpty(node_";
  protected final String TEXT_344 = ") || xml_api_";
  protected final String TEXT_345 = ".isMissing(node_";
  protected final String TEXT_346 = "))) {";
  protected final String TEXT_347 = NL + "                            ";
  protected final String TEXT_348 = NL + "                        } else {";
  protected final String TEXT_349 = NL + "                        if (resultIsNode_";
  protected final String TEXT_350 = " && (xml_api_";
  protected final String TEXT_351 = ".isMissing(node_";
  protected final String TEXT_352 = ") || xml_api_";
  protected final String TEXT_353 = ".isEmpty(node_";
  protected final String TEXT_354 = "))) {";
  protected final String TEXT_355 = NL + "                             ";
  protected final String TEXT_356 = NL + "                        } else {";
  protected final String TEXT_357 = NL + "                    ";
  protected final String TEXT_358 = NL + "                        ";
  protected final String TEXT_359 = NL + "                            ";
  protected final String TEXT_360 = NL + "                            ";
  protected final String TEXT_361 = NL + "                        ";
  protected final String TEXT_362 = NL + "                }";
  protected final String TEXT_363 = NL + "            ";
  protected final String TEXT_364 = NL + "            // Die immediately on errors." + NL + "            throw new IOException(";
  protected final String TEXT_365 = ");";
  protected final String TEXT_366 = NL + "                // Ignore errors processing this row and move to the next.";
  protected final String TEXT_367 = NL + "                // Send error rows to the reject output.";
  protected final String TEXT_368 = NL + "                ";
  protected final String TEXT_369 = NL + "                    ";
  protected final String TEXT_370 = NL + "                ";
  protected final String TEXT_371 = NL + "                ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final IBigDataNode bigDataNode = (IBigDataNode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    
	/**
	 * Code generated for component with single output
 	 */
    class SOFunctionGenerator extends org.talend.designer.spark.generator.FunctionGenerator{

    	SOFunctionGenerator(org.talend.designer.common.TransformerBase transformer) {
            super(transformer);
        }

    	SOFunctionGenerator(org.talend.designer.common.TransformerBase transformer, org.talend.designer.spark.generator.SparkFunction sparkFunction) {
    		super(transformer, sparkFunction);
    	}

    	@Override
        public void generate(){
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(this.sparkFunction.getCodeFunctionImplementation(getOutValueClass(), getInValueClass()));
    stringBuffer.append(TEXT_4);
    
                this.transformer.generateHelperClasses(true);
                this.transformer.generateTransformContextDeclaration();
                
    stringBuffer.append(TEXT_5);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturnedType(this.outValueClass.toString()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(this.sparkFunction.getCodeImplementedMethod());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(this.sparkFunction.getCodeFunctionArgument(getInValueClass()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(this.sparkFunction.getCodeThrowException());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(this.sparkFunction.getMethodHeader(this.outValueClass, this.outValue, this.inValueClass, this.inValue));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(this.sparkFunction.getCodeKeyMapping(getInValue()));
    stringBuffer.append(TEXT_12);
    
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
    class MOFunctionGenerator extends org.talend.designer.spark.generator.FunctionGenerator{

        /** The single connection to pass along the output chain of Mappers
         *  instead of sending to a dedicated collector via MultipleOutputs. */
        String connectionToChain = null;
        
        MOFunctionGenerator(org.talend.designer.common.TransformerBase transformer) {
            super(transformer);
            defaultOutKeyClass = "Boolean";
        }

    	MOFunctionGenerator(org.talend.designer.common.TransformerBase transformer, org.talend.designer.spark.generator.SparkFunction sparkFunction) {
    		super(transformer, sparkFunction);
            defaultOutKeyClass = "Boolean";
    	}

    	@Override
        public void generate(){
        
    stringBuffer.append(TEXT_15);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(this.sparkFunction.getCodeFunctionImplementationOutputFixedType(getInValueClass(), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
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
    stringBuffer.append(this.sparkFunction.getCodeFunctionArgument(getInValueClass()));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(this.sparkFunction.getCodeThrowException());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(this.sparkFunction.getMethodHeader(this.outValueClass, this.outValue, this.inValueClass, this.inValue));
    
                    this.transformer.generateTransformContextInitialization();
                    this.transformer.generateTransform(true);
	                if(this.sparkFunction.getCodeFunctionReturn()!=null) {
                
    stringBuffer.append(TEXT_24);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturn());
    stringBuffer.append(TEXT_25);
    
	            	}
                
    stringBuffer.append(TEXT_26);
    
        }
    }

    stringBuffer.append(TEXT_27);
    

/**
 * A common, reusable utility that generates code in the context of a spark
 * component, for reading and writing to a spark RDD.
 */
class SparkRowTransformUtil extends org.talend.designer.common.CommonRowTransformUtil {

    private boolean isMultiOutput = false;

    private org.talend.designer.spark.generator.SparkFunction sparkFunction = null;
    

    private org.talend.designer.spark.generator.FunctionGenerator functionGenerator = null;

    public SparkRowTransformUtil() {

    }

    public SparkRowTransformUtil(org.talend.designer.spark.generator.SparkFunction sparkFunction) {
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
        if(!isReject && this.sparkFunction!=null && !isMultiOutput) {
            return this.sparkFunction.getCodeToInitOut(functionGenerator.getOutValue("main"), functionGenerator.getOutValueClass("main"));
        } else {
            return "";
        }
    }

    // Method to avoid using getCodeToInitOut that calls sparkFunction.getCodeToInitOut which creates unnecessary objects
    // Check getCodeToAddToOutput in SparkFunction and its implementation in FlatMapToPairFunction
    public String getCodeToAddToOutput(boolean isReject, Iterable<IMetadataColumn> columns) {
        if(this.sparkFunction!=null && !isMultiOutput) {
            return this.sparkFunction.getCodeToAddToOutput(false, false, functionGenerator.getOutValue(isReject ? "reject" : "main"), functionGenerator.getOutValueClass(isReject ? "reject" : "main"));
        }else if(this.sparkFunction!=null && isMultiOutput){
            if(isReject){
                return this.sparkFunction.getCodeToAddToOutput(true, false, functionGenerator.getOutValue("reject"), functionGenerator.getOutValueClass("reject"));
            }else{
                return this.sparkFunction.getCodeToAddToOutput(true, true, functionGenerator.getOutValue("main"), functionGenerator.getOutValueClass("main"));
            }
        }else {
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
        if (this.sparkFunction != null && isMultiOutput) {
            if (isReject) {
                return this.sparkFunction.getCodeToEmit(false, functionGenerator.getOutValue("reject"), functionGenerator.getOutValueClass("reject"));
            } else {
                return this.sparkFunction.getCodeToEmit(true, functionGenerator.getOutValue("main"), functionGenerator.getOutValueClass("main"));
            }
        } else {
            if (isReject) {
                return this.sparkFunction.getCodeToInitOut(functionGenerator.getOutValue("reject"), functionGenerator.getOutValueClass("reject"));
            } else {
                return "";
            }
        }
    }

    public void generateSparkCode(final org.talend.designer.common.TransformerBase transformer, final org.talend.designer.spark.generator.SparkFunction sparkFunction) {
        if (transformer.isMultiOutput()) {
            setMultiOutput(true);
        }
        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
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
            functionGenerator = new MOFunctionGenerator(transformer, localSparkFunction);
            functionGenerator.init(node, cid, null, transformer.getInConnName(), null, names);

            
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(extractSparkFunction.getCodeFunctionImplementationInputFixedType(transformer.getOutConnMainTypeName(), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturnedType(transformer.getOutConnMainTypeName()));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(transformer.getOutConnMainTypeName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(transformer.getOutConnMainTypeName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturn(transformer.getOutConnMainName(), transformer.getOutConnMainTypeName()));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(extractSparkFunction.getCodeFunctionImplementationInputFixedType(transformer.getOutConnRejectTypeName(), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturnedType(transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(transformer.getOutConnRejectTypeName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(transformer.getOutConnRejectName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(transformer.getOutConnRejectTypeName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturn(transformer.getOutConnRejectName(), transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_50);
    
        } else {
            // Refactoring FunctionGenerator to java so we have to instaniate a MO or SO here
            functionGenerator = new SOFunctionGenerator(transformer, sparkFunction);

            functionGenerator.init(node, cid, null, transformer.getInConnName(), null, 
                    transformer.getOutConnMainName() != null
                        ? transformer.getOutConnMainName()
                                : transformer.getOutConnRejectName());
        }
        functionGenerator.generate();
    }

    public void generateSparkConfig(final org.talend.designer.common.TransformerBase transformer, final org.talend.designer.spark.generator.SparkFunction sparkFunction) {
        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
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
            
    stringBuffer.append(TEXT_53);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(sparkFunction.isStreaming() ?"org.apache.spark.streaming.api.java.JavaPairDStream":"org.apache.spark.api.java.JavaPairRDD");
    stringBuffer.append(TEXT_55);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(transformer.getInConnName());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(localFunctionType);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(sparkFunction.getConfigReturnedType(transformer.getOutConnMainTypeName()));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(extractFunctionType);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(sparkFunction.getConfigReturnedType(transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(transformer.getOutConnRejectName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(extractFunctionType);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
        } else {
            functionGenerator = new SOFunctionGenerator(transformer, sparkFunction);

            functionGenerator.init(node, cid, null, transformer.getInConnName(), null, 
                    transformer.getOutConnMainName() != null
                        ? transformer.getOutConnMainName()
                                : transformer.getOutConnRejectName());
            
    stringBuffer.append(TEXT_74);
    stringBuffer.append(sparkFunction.getConfigReturnedType(transformer.getOutConnMainName() != null ? transformer.getOutConnMainTypeName() : transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(transformer.getOutConnMainName() != null ? transformer.getOutConnMainName() : transformer.getOutConnRejectName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(transformer.getInConnName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(sparkFunction.getConfigTransformation());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_79);
    
        }
    }
}


    

/**
 * Contains common processing for tExtractXMLField code generation.  This is
 * used in MapReduce and Storm components.
 *
 * The following imports must occur before importing this file:
 * @ include file="@{org.talend.designer.components.mrprovider}/resources/utils/common_codegen_util.javajet"
 */
class TExtractXMLFieldUtil extends org.talend.designer.common.TransformerBase {

    // TODO: what happens when these are input column names?
    final private static String REJECT_MSG = "errorMessage";
    final private static String REJECT_CODE = "errorCode";
    final private static String REJECT_FIELD = "errorXMLField";

    final private String strXMLText = ElementParameterParser.getValue(node, "__XML_TEXT__");

    final private boolean useXMLField = "true".equals(ElementParameterParser.getValue(node, "__USE_XML_FIELD__"));

    final private String strXMLPrefix;

    final private String limit;

    final private static boolean isDocumentType = false;

    /**
     * schemaOptNum is used to split extremely large methods into smaller
     * chunks, in the case where the mapping table and the corresponding output
     */
    final private int schemaOptNum;

    final private boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
    // TODO: rename variable
    final private boolean ignore_NS_Str = "true".equals(ElementParameterParser.getValue(node, "__IGNORE_NS__"));

    final private String field = ElementParameterParser.getValue(node, "__XMLFIELD__");
    final private String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__");

    final private java.util.List<java.util.Map<String, String>> mappings = (java.util.List<java.util.Map<String,String>>)
            ElementParameterParser.getObjectValue(node, "__MAPPING__");

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
     *  checked. */
    // TODO document
    final private boolean hasNodeCheck;

    public TExtractXMLFieldUtil(INode node,
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
                    getOutColumnsReject(),
                    getColumns(getOutColumnsReject(),
                            REJECT_FIELD, REJECT_CODE, REJECT_MSG));
            newOutColumns = getColumnsDiff(mainCols, getInColumns());
        } else {
            copiedInColumns = null;
            newOutColumns = null;
        }

        // Some element parameters for this node require additional parsing.

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
        // TODO: is this necessary>
        hasNodeCheck = hasNodeCheckTemp;

        String strXMLPrefixTmp = ElementParameterParser.getValue(node, "__XML_PREFIX__");
        if (("TRIGGER_ITEM").equals(strXMLPrefixTmp)) {
            strXMLPrefix = "\"/exchange/item\"";
        } else if(("PROCESS_ITEM").equals(strXMLPrefixTmp)) {
            strXMLPrefix = "\"/item\"";
        } else if(("NONE_ITEM").equals(strXMLPrefixTmp)) {
            strXMLPrefix = "\"\"";
        } else {
            strXMLPrefix = strXMLPrefixTmp;
        }

        String limitTmp = ElementParameterParser.getValue(node, "__LIMIT__");
        limit = "".equals(limitTmp) ? "-1" : limitTmp;

        // TODO: This should be read from the component for handling extra-large
        // XML schemas.
        schemaOptNum = 100;
        //String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
        //if (schemaOptNumStr !=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)) {
        //    schemaOptNum  = Integer.parseInt(schemaOptNumStr);
        //} else {
        //    schemaOptNum = 100;
        //}
    }

    /**
     * Generates all of the helper classes necessary to implement this node.
     */
    public void generateHelperClasses(boolean isStatic) {
        // TODO: these could be shared between all json nodes.
        generateClassNameSpaceTool(isStatic);
        generateClassXmlApi(isStatic);
        if (ignore_NS_Str)
            generateClassXmlApiRmv(isStatic);
    }

    /**
     * TODO: doc
     * NameSpaceTool_cid is used for...
     * The class generated by this method is identical for all tExtractXMLField
     * nodes.
     */
    private void generateClassNameSpaceTool(boolean isStatic) {
        // Start generating code for NameSpaceTool_cid class.
        
    stringBuffer.append(TEXT_80);
    stringBuffer.append(isStatic ? "static" : "");
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
        // End generated code for NameSpaceTool_cid
    }

    /**
     * TODO: doc
     * XML_API_cid is used for...
     *
     * This class can contain helper methods for parsing columns.
     */
    private void generateClassXmlApi(boolean isStatic) {
        // Start generating code for XML_API_cid class.
        
    stringBuffer.append(TEXT_83);
    stringBuffer.append(isStatic ? "static" : "");
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
            if (schemaOptNum < mappings.size()) {
                generateClassXmlApiMethodsPutUnExtractValue();
                generateClassXmlApiMethodsPutExtractValue();
                if (!dieOnError && getOutConnReject() != null) {
                    generateClassXmlApiMethodsPutRejectValueBeforeExtract();
                    if (getOutConnMainName() != null)
                        generateClassXmlApiMethodsPutRejectValueAfterExtract();
                }
            }
            
    stringBuffer.append(TEXT_86);
    
        // End generated code for XML_API_cid class
    }

    /**
     * Generates putUnExtractValue_ methods in the scope of the XML_API_cid
     * class for this node that copies all columns without a specified query to
     * the output.
     */
    private void generateClassXmlApiMethodsPutUnExtractValue() {
        boolean methodStarted = false;
        for (int i = 0; i < copiedInColumns.size(); i ++) {
            String columnName = copiedInColumns.get(i).getLabel();
            if (i % schemaOptNum == 0) {
                // Close any open methods.
                if (methodStarted) {
                    
    stringBuffer.append(TEXT_87);
    
                }
                // Every n'th column to process, open a new method.
                
    stringBuffer.append(TEXT_88);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(getOutConnMain()));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(getOutConnMainName());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(getInConn()));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(getInConnName());
    stringBuffer.append(TEXT_95);
    
                methodStarted = true;
            }
            
    stringBuffer.append(TEXT_96);
    stringBuffer.append(getRowTransform().getCodeToCopyField(false, columnName));
    
        }
        // Close any open methods.
        if (methodStarted) {
            
    stringBuffer.append(TEXT_97);
    
        }
    }

    /**
     * Generates putExtractValue_ methods in the scope of the XML_API_cid
     * class for this node that copies all columns with a specified query to
     * the output.
     */
    private void generateClassXmlApiMethodsPutExtractValue() {
        boolean methodStarted = false;
        int columnNo=0;
        for (int i=0; i < mappings.size() ;i++) {

            String query = mappings.get(i).get("QUERY");
            String nodeCheck = mappings.get(i).get("NODECHECK");

            if (query!=null && query.trim().length()>0) {

                if (columnNo % schemaOptNum == 0) {
                    // Close any open methods.
                    if (methodStarted) {
                        
    stringBuffer.append(TEXT_98);
    
                    }
                    // Every n'th column to process, open a new method.
                    
    stringBuffer.append(TEXT_99);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(getOutConnMain()));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(getOutConnMainName());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(TEXT_103);
    stringBuffer.append( getInConn() != null ? NodeUtil.getPrivateConnClassName(getInConn()) + "Struct "
                                    + getInConnName() + ",": "" );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append( ignore_NS_Str ? ", org.jaxen.NamespaceContext namespaceContext_" + cid : "" );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    
                    methodStarted = true;
                }
                
    
                columnNo++;
            }
        }
        // Close any open methods.
        if (methodStarted) {
            
    stringBuffer.append(TEXT_117);
    
        }
    }

    /**
     * Generates putRejectValueBeforeExtract_ methods in the scope of the
     * XML_API_cid that copies all columns (except the field column) from
     * the input to the reject struct.
     */
    private void generateClassXmlApiMethodsPutRejectValueBeforeExtract() {
        boolean methodStarted = false;
        int columnNo=0;
        for (IMetadataColumn column : getOutColumnsMain()) {
            if (!field.equals(column.getLabel())){
                for (IMetadataColumn inColumn : getInColumns()) {
                    if (inColumn.getLabel().equals(column.getLabel())) {
                        if (columnNo % schemaOptNum == 0) {
                            // Close any open methods.
                            if (methodStarted) {
                                
    stringBuffer.append(TEXT_118);
    
                            }
                            // Every n'th column to process, open a new method.
                            
    stringBuffer.append(TEXT_119);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(getOutConnRejectName());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(getOutConnRejectName());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(getInConn()));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(getInConnName());
    stringBuffer.append(TEXT_126);
    
                            methodStarted = true;
                        }
                        
    stringBuffer.append(TEXT_127);
    stringBuffer.append(getRowTransform().getCodeToCopyField(true, column.getLabel()));
    
                        columnNo++;
                    }
                }
            }
        }
        // Close any open methods.
        if (methodStarted) {
            
    stringBuffer.append(TEXT_128);
    
        }
    }

    /**
     * Generates putRejectValueAfterExtract_ methods in the scope of the
     * XML_API_cid that copies all columns that have been extracted to
     * the row to the reject struct.
     */
    private void generateClassXmlApiMethodsPutRejectValueAfterExtract() {
        boolean methodStarted = false;
        int columnNo=0;
        for (IMetadataColumn column : getOutColumnsMain()) {
            if (columnNo % schemaOptNum == 0) {
                // Close any open methods.
                if (methodStarted) {
                    
    stringBuffer.append(TEXT_129);
    
                }
                // Every n'th column to process, open a new method.
                
    stringBuffer.append(TEXT_130);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(getOutConnRejectName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(getOutConnRejectName());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(getOutConnMainName() );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(getOutConnMainName() );
    stringBuffer.append(TEXT_137);
    
                methodStarted = true;
            }
            
    stringBuffer.append(TEXT_138);
    stringBuffer.append(getRowTransform().getCodeToCopyField(true, column.getLabel()));
    
        }
        // Close any open methods.
        if (methodStarted) {
            
    stringBuffer.append(TEXT_139);
    
        }
    }

    private void generateClassXmlApiRmv(boolean isStatic) {
        // Start generating code for XML_API_RMV_cid class.
        
    stringBuffer.append(TEXT_140);
    stringBuffer.append(isStatic ? "static" : "");
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
        // End generated code for XML_API_RMV_cid
    }

    public void generateTransformContextDeclaration() {
        
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
     if (ignore_NS_Str) { 
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    
    }

    public void generateTransformContextInitialization() {
        
    stringBuffer.append(TEXT_163);
     if (ignore_NS_Str) { 
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
     } 
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
     if (useXMLField) { 
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(strXMLPrefix);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_174);
     } else { 
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_177);
    
        }
    }


    public void generateTransform() {
        generateTransform(false);
    }

    /**
     * Generates code that performs the tranformation from one XML input string
     * to many output strings, or to a reject flow.
     */
    public void generateTransform(boolean hasAReturnedType) {
        // variables used throughout the transform scope of the generated code.
        
    stringBuffer.append(TEXT_178);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(hasAReturnedType?" null":"");
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    
        if (ignore_NS_Str && isDocumentType) {
            
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    
        } else if (ignore_NS_Str && !isDocumentType) {
            
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
     generateTransformReject(dieOnError, "e", null, "xmlStr_" + cid); 
    stringBuffer.append(TEXT_195);
    
        }
        
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    
        generateTransformParseInputField();
        // After this call, the isStructError_cid member is false if the XML
        // input was correctly parsed into the common structures.
        int i = 0;
        
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    
                if (getOutConnMain() != null) {
                    
    stringBuffer.append(TEXT_211);
    stringBuffer.append(getOutConnMain().getName());
    stringBuffer.append(TEXT_212);
    stringBuffer.append(codeGenArgument.getRecordStructName(getOutConnMain()));
    stringBuffer.append(TEXT_213);
    
                } else {
                    
    stringBuffer.append(TEXT_214);
    stringBuffer.append(getOutConnReject().getName());
    stringBuffer.append(TEXT_215);
    stringBuffer.append(codeGenArgument.getRecordStructName(getOutConnReject()));
    stringBuffer.append(TEXT_216);
    
                }
                
    stringBuffer.append(TEXT_217);
    
                    MAPPING: for (java.util.Map<String, String> mapping : mappings) {
                        String columnName = mapping.get("SCHEMA_COLUMN");
                        for (IMetadataColumn col : copiedInColumns)
                            if (col.getLabel().equals(columnName))
                                continue MAPPING;
                        generateTransformForMapping(i++, "true".equals(mapping.get("NODECHECK")),
                            mapping.get("QUERY"),
                            columnName);
                    }
                    if (getOutConnMain() != null) {
                        
    stringBuffer.append(TEXT_218);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(false, copiedInColumns));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(getRowTransform().getCodeToEmit(false));
    
                    }
                    
    stringBuffer.append(TEXT_220);
    stringBuffer.append(getRowTransform().getCodeToInitOut(null == getOutConnMain(), newOutColumns));
    stringBuffer.append(TEXT_221);
    
                    generateTransformReject(dieOnError, "ex", null, "temp_"+cid+".asXML()");
                    
    stringBuffer.append(TEXT_222);
    
    }

    /**
     * Part of the code generation for parsing the input field into several of
     * the variables that are used to generate output.
     */
    private void generateTransformParseInputField() {
        // Parse the structure.
        
    stringBuffer.append(TEXT_223);
    
            if (!ignore_NS_Str) {
                if (isDocumentType) {
                    
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    
                } else {
                    
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    
                }
            } else {
                
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    
            }
            
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    if(ignore_NS_Str){
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    }
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    
            generateTransformReject(dieOnError, "ex", null, "xmlStr_"+cid);
            
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
     if (dieOnError) { 
    stringBuffer.append(TEXT_258);
     } else { 
    stringBuffer.append(TEXT_259);
     } 
    stringBuffer.append(TEXT_260);
    
    }

    /**
     * Generates code that performs the tranformation from one JSON input string
     * to many output strings, or to a reject flow.
     */
    private void generateTransformForMapping(final int i, final boolean nodeCheck,
        final String query, final String columnName) {
        
    stringBuffer.append(TEXT_261);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
     if(ignore_NS_Str) { 
    stringBuffer.append(TEXT_271);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
     } 
    stringBuffer.append(TEXT_275);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
     if(nodeCheck) { 
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
     } else { 
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
     } 
    stringBuffer.append(TEXT_303);
    
        Iterable<IMetadataColumn> outColumns = getOutColumnsMain();
        if (outColumns == null)
            outColumns = getOutColumnsReject();
        for(IMetadataColumn column : outColumns) {
            if (mappings.get(i).get("SCHEMA_COLUMN") == null)
                continue;

            if (column.getLabel().equals(mappings.get(i).get("SCHEMA_COLUMN"))) {

                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

                String defaultValue = column.getDefault();
                boolean isNotSetDefault = defaultValue == null || defaultValue.length() == 0;

                if (nodeCheck) {
                    if(javaType == JavaTypesManager.BYTE_ARRAY){
     if (("SPARKSTREAMING".equals(node.getComponent().getType())
                                || "SPARK".equals(node.getComponent().getType()))) { 
    stringBuffer.append(TEXT_304);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "java.nio.ByteBuffer.wrap(str_" + cid + ".getBytes())"));
     } else { 
    stringBuffer.append(TEXT_305);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "str_" + cid + ".getBytes()"));
     } 
     } else if (javaType == JavaTypesManager.DATE) { 
    stringBuffer.append(TEXT_306);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(str_" + cid + ", " + column.getPattern() + ")"));
     } else if(!("id_Document".equals(column.getTalendType()))) { 
    stringBuffer.append(TEXT_307);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_"+ typeToGenerate +"(str_" + cid + ")"));
     } else { 
    stringBuffer.append(TEXT_308);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Document(str_" + cid + ")"));
     }
                    continue;
                }

                if (javaType == JavaTypesManager.STRING) {
                    if(column.isNullable()) {
                        
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null"));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "\"\""));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?null:column.getDefault()));
    stringBuffer.append(TEXT_324);
    
                    } else { // column.isNullable()
                        
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "\"\""));
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault()));
    stringBuffer.append(TEXT_335);
    
                    }
                } else { // other non-STRING types
                    if (column.isNullable()) {
                        
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null") );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
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
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?null:column.getDefault()));
    stringBuffer.append(TEXT_348);
    
                    } else { // column.isNullable()
                        
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault()));
    stringBuffer.append(TEXT_356);
    
                    }
                }
                // There's a dangling else { statement at this point.

                if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
                    
    stringBuffer.append(TEXT_357);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "str_" + cid));
    
                } else {
                    if (javaType == JavaTypesManager.DATE) {
                        
    stringBuffer.append(TEXT_358);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(str_"+cid+", "+patternValue+")"));
    
                    } else if (javaType == JavaTypesManager.BYTE_ARRAY) {
                        if ("SPARKSTREAMING".equals(node.getComponent().getType()) || "SPARK".equals(node.getComponent().getType())) {
                            
    stringBuffer.append(TEXT_359);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "java.nio.ByteBuffer.wrap(str_" + cid + ".getBytes())"));
    
                        } else {
                            
    stringBuffer.append(TEXT_360);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "str_" + cid + ".getBytes()"));
    
                        }
                    } else {
                        
    stringBuffer.append(TEXT_361);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_"+typeToGenerate+"(str_"+cid+")"));
    
                    }
                }

                // Close the dangling else
                
    stringBuffer.append(TEXT_362);
    
                break;
            }
        }
    }

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
            
    stringBuffer.append(TEXT_363);
    stringBuffer.append(getRowTransform().getCodeToCopyOutMainToReject(newOutColumns));
    
        }

        if (die) {
            
    stringBuffer.append(TEXT_364);
    stringBuffer.append(codeException);
    stringBuffer.append(TEXT_365);
    
        } else {
            if (null == getOutConnReject()) {
                
    stringBuffer.append(TEXT_366);
    
                generateLogMessage(codeRejectMsg);
            } else {
                
    stringBuffer.append(TEXT_367);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_MSG,
                        codeRejectMsg) );
    
                if (containsRejectField) {
                    
    stringBuffer.append(TEXT_369);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_FIELD,
                        codeRejectField) );
    
                }
                
    stringBuffer.append(TEXT_370);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(true, copiedInColumns));
    stringBuffer.append(TEXT_371);
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
    sparkFunction = new org.talend.designer.spark.generator.FlatMapToPairFunction(inputIsPair);
} else if("VALUE".equals(type)) {
    sparkFunction = new org.talend.designer.spark.generator.FlatMapFunction(inputIsPair);
}

final SparkRowTransformUtil sparkTransformUtil = new SparkRowTransformUtil(sparkFunction);
final TExtractXMLFieldUtil tExtractXMLFieldUtil = new TExtractXMLFieldUtil(
        node, codeGenArgument, sparkTransformUtil);


sparkTransformUtil.generateSparkCode(tExtractXMLFieldUtil, sparkFunction);

    return stringBuffer.toString();
  }
}
