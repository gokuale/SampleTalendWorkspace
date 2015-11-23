package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.NodeUtil;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TExtractXMLFieldMrconfigJava
{
  protected static String nl;
  public static synchronized TExtractXMLFieldMrconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractXMLFieldMrconfigJava result = new TExtractXMLFieldMrconfigJava();
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
  protected final String TEXT_134 = " class NameSpaceTool_";
  protected final String TEXT_135 = " implements Serializable{" + NL + "" + NL + "            public java.util.HashMap<String, String> xmlNameSpaceMap = new java.util.HashMap<String, String>();" + NL + "            private java.util.List<String> defaultNSPath = new java.util.ArrayList<String>();" + NL + "" + NL + "            public void countNSMap(org.dom4j.Element el) {" + NL + "                for (org.dom4j.Namespace ns : (java.util.List<org.dom4j.Namespace>) el.declaredNamespaces()) {" + NL + "                    if (ns.getPrefix().trim().length() == 0) {" + NL + "                        xmlNameSpaceMap.put(\"pre\"+defaultNSPath.size(), ns.getURI());" + NL + "                        String path = \"\";" + NL + "                        org.dom4j.Element elTmp = el;" + NL + "                        while (elTmp != null) {" + NL + "                            if (elTmp.getNamespacePrefix() != null && elTmp.getNamespacePrefix().length() > 0) {" + NL + "                                path = \"/\" + elTmp.getNamespacePrefix() + \":\" + elTmp.getName() + path;" + NL + "                            } else {" + NL + "                                path = \"/\" + elTmp.getName() + path;" + NL + "                            }" + NL + "                            elTmp = elTmp.getParent();" + NL + "                        }" + NL + "                        defaultNSPath.add(path);" + NL + "                    } else {" + NL + "                        xmlNameSpaceMap.put(ns.getPrefix(), ns.getURI());" + NL + "                    }" + NL + "" + NL + "                }" + NL + "                for (org.dom4j.Element e : (java.util.List<org.dom4j.Element>) el.elements()) {" + NL + "                    countNSMap(e);" + NL + "                }" + NL + "            }" + NL + "" + NL + "            /**" + NL + "             *  the regex for the xpath like that :" + NL + "             *  case 1 : functionA(locationXPathExpression)" + NL + "             *  case 2 : fn:functionA(locationXPathExpression)" + NL + "             *  case 3 : functionA(functionB(locationXPathExpression))" + NL + "             *  case 4 : fn:functionA(fn:functionB(locationXPathExpression))" + NL + "             *  and like that." + NL + "            */" + NL + "            private java.util.regex.Pattern simpleFunctionPattern;" + NL + "            private StringBuffer stringBuffer;" + NL + "            private java.util.Map<String,String> resultCache;" + NL + "" + NL + "            public String addDefaultNSPrefix(final String xpathExpression, String loopPath) {" + NL + "                if (defaultNSPath.size() < 1) {" + NL + "                    return xpathExpression;" + NL + "                }" + NL + "" + NL + "                if(resultCache == null) {" + NL + "                    resultCache = new java.util.HashMap<String,String>();" + NL + "                }" + NL + "" + NL + "                String resultXpathExpression = resultCache.get(xpathExpression);" + NL + "                if(resultXpathExpression!=null) {" + NL + "                    return resultXpathExpression;" + NL + "                }" + NL + "" + NL + "                String locationPathExpression = xpathExpression;" + NL + "" + NL + "                if(simpleFunctionPattern == null) {" + NL + "                    simpleFunctionPattern = java.util.regex.Pattern.compile(\"([a-zA-z0-9]+:)?[a-zA-Z]+-?[A-Za-z]+\\\\(.*\\\\)\");" + NL + "                }" + NL + "" + NL + "                boolean isSimpleFunctionXPath = simpleFunctionPattern.matcher(xpathExpression).matches();" + NL + "                String tail = null;" + NL + "                if(isSimpleFunctionXPath) {" + NL + "                    int start = xpathExpression.lastIndexOf('(');" + NL + "                    int end = xpathExpression.indexOf(')');" + NL + "                    if(start < end) {" + NL + "                        if(stringBuffer == null) {" + NL + "                            stringBuffer = new StringBuffer();" + NL + "                        }" + NL + "                        locationPathExpression = xpathExpression.substring(start+1,end);" + NL + "                        stringBuffer.append(xpathExpression.substring(0,start+1));" + NL + "                        tail = xpathExpression.substring(end);" + NL + "                    } else {" + NL + "                        isSimpleFunctionXPath = false;" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                locationPathExpression = addDefaultNSPrefixForLocationXPathExpression(locationPathExpression,loopPath);" + NL + "" + NL + "                resultXpathExpression = locationPathExpression;" + NL + "" + NL + "                if(isSimpleFunctionXPath) {" + NL + "                    stringBuffer.append(locationPathExpression);" + NL + "                    stringBuffer.append(tail);" + NL + "                    resultXpathExpression = stringBuffer.toString();" + NL + "                    stringBuffer.setLength(0);" + NL + "                }" + NL + "" + NL + "                resultCache.put(xpathExpression,resultXpathExpression);" + NL + "                return resultXpathExpression;" + NL + "            }" + NL + "" + NL + "            private String addDefaultNSPrefixForLocationXPathExpression(String path, String loopPath) {" + NL + "                String fullPath = loopPath;" + NL + "                if(!path.equals(fullPath)){" + NL + "                    for (String tmp : path.split(\"/\")) {" + NL + "                        if ((\"..\").equals(tmp)) {" + NL + "                            fullPath = fullPath.substring(0, fullPath.lastIndexOf(\"/\"));" + NL + "                        } else {" + NL + "                            fullPath += \"/\" + tmp;" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "                int[] indexs = new int[fullPath.split(\"/\").length - 1];" + NL + "                java.util.Arrays.fill(indexs, -1);" + NL + "                int length = 0;" + NL + "                for (int i = 0; i < defaultNSPath.size(); i++) {" + NL + "                    if (defaultNSPath.get(i).length() > length && fullPath.startsWith(defaultNSPath.get(i))) {" + NL + "                        java.util.Arrays.fill(indexs, defaultNSPath.get(i).split(\"/\").length - 2, indexs.length, i);" + NL + "                        length = defaultNSPath.get(i).length();" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                StringBuilder newPath = new StringBuilder();" + NL + "                String[] pathStrs = path.split(\"/\");" + NL + "                for (int i = 0; i < pathStrs.length; i++) {" + NL + "                    String tmp = pathStrs[i];" + NL + "                    if (newPath.length() > 0) {" + NL + "                        newPath.append(\"/\");" + NL + "                    }" + NL + "                    if (tmp.length() > 0 && tmp.indexOf(\":\") == -1 && tmp.indexOf(\".\") == -1 /*&& tmp.indexOf(\"@\") == -1*/) {" + NL + "                        int index = indexs[i + indexs.length - pathStrs.length];" + NL + "                        if (index >= 0) {" + NL + "                            if(tmp.indexOf(\"[\")>0 && tmp.indexOf(\"]\")>tmp.indexOf(\"[\")){//include filter" + NL + "                                String tmpStr=replaceElementWithNS(tmp,\"pre\"+index+\":\");" + NL + "                                newPath.append(tmpStr);" + NL + "                            }else{" + NL + "                                if(tmp.indexOf(\"@\") != -1 || tmp.indexOf(\"(\")<tmp.indexOf(\")\")){  // include attribute" + NL + "                                    newPath.append(tmp);" + NL + "                                }else{" + NL + "                                    newPath.append(\"pre\").append(index).append(\":\").append(tmp);" + NL + "                                }" + NL + "                            }" + NL + "                        } else {" + NL + "                            newPath.append(tmp);" + NL + "                        }" + NL + "                    } else {" + NL + "                        newPath.append(tmp);" + NL + "                    }" + NL + "                }" + NL + "                return newPath.toString();" + NL + "            }" + NL + "" + NL + "            private String matches = \"@*\\\\b[a-z|A-Z|_]+[[-]*\\\\w]*\\\\b[^'|^\\\\(]\";" + NL + "            private java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(matches);" + NL + "" + NL + "            private String replaceElementWithNS(String global, String pre){" + NL + "" + NL + "                java.util.regex.Matcher match = pattern.matcher(global);" + NL + "                StringBuffer sb = new StringBuffer();" + NL + "                match.reset();" + NL + "                while (match.find()) {" + NL + "                    String group = match.group();" + NL + "                    String tmp = \"\";" + NL + "                    if (group.toLowerCase().matches(\"\\\\b(div|mod|and|or)\\\\b.*\") || group.matches(\"@.*\")) {" + NL + "                        tmp = group;" + NL + "                    } else {" + NL + "                        tmp = tmp + pre + group;" + NL + "                    }" + NL + "                    match.appendReplacement(sb, tmp);" + NL + "                }" + NL + "                match.appendTail(sb);" + NL + "" + NL + "                return sb.toString();" + NL + "            }" + NL + "" + NL + "        }";
  protected final String TEXT_136 = NL + "        ";
  protected final String TEXT_137 = " class XML_API_";
  protected final String TEXT_138 = " implements Serializable {" + NL + "            public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "                if (node != null && node instanceof org.dom4j.Element) {" + NL + "                    org.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "                    if(attri != null && (\"true\").equals(attri.getText())){" + NL + "                        return true;" + NL + "                    }" + NL + "                }" + NL + "                return false;" + NL + "            }" + NL + "" + NL + "            public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "                return node == null;" + NL + "            }" + NL + "" + NL + "            public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "                return node != null && node.getText().length() == 0;" + NL + "            }" + NL;
  protected final String TEXT_139 = NL + "        }";
  protected final String TEXT_140 = NL + "                    }";
  protected final String TEXT_141 = NL + "                    public void putUnExtractValue_";
  protected final String TEXT_142 = "(";
  protected final String TEXT_143 = NL + "                        ";
  protected final String TEXT_144 = "Struct ";
  protected final String TEXT_145 = ",";
  protected final String TEXT_146 = NL + "                        ";
  protected final String TEXT_147 = "Struct ";
  protected final String TEXT_148 = ") {";
  protected final String TEXT_149 = NL + "            ";
  protected final String TEXT_150 = NL + "            }";
  protected final String TEXT_151 = NL + "                        }";
  protected final String TEXT_152 = NL + "                    public void putExtractValue_";
  protected final String TEXT_153 = "(";
  protected final String TEXT_154 = "Struct ";
  protected final String TEXT_155 = ",";
  protected final String TEXT_156 = NL + "                            ";
  protected final String TEXT_157 = NL + "                            String xmlStr_";
  protected final String TEXT_158 = "," + NL + "                            org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_159 = "," + NL + "                            NameSpaceTool_";
  protected final String TEXT_160 = " nsTool_";
  protected final String TEXT_161 = ",String loopQuery_";
  protected final String TEXT_162 = "," + NL + "                            java.util.HashMap xmlNameSpaceMap_";
  protected final String TEXT_163 = "," + NL + "                            org.dom4j.Node node_";
  protected final String TEXT_164 = "," + NL + "                            String str_";
  protected final String TEXT_165 = ",XML_API_";
  protected final String TEXT_166 = " xml_api_";
  protected final String TEXT_167 = NL + "                            ";
  protected final String TEXT_168 = NL + "                            ) throws java.lang.Exception {" + NL + "                        boolean resultIsNode_";
  protected final String TEXT_169 = " = true;";
  protected final String TEXT_170 = NL + "            }";
  protected final String TEXT_171 = NL + "                                }";
  protected final String TEXT_172 = NL + "                                public void putRejectValueBeforeExtract_";
  protected final String TEXT_173 = "(";
  protected final String TEXT_174 = NL + "                                        ";
  protected final String TEXT_175 = "Struct ";
  protected final String TEXT_176 = ",";
  protected final String TEXT_177 = NL + "                                        ";
  protected final String TEXT_178 = "Struct ";
  protected final String TEXT_179 = ") {";
  protected final String TEXT_180 = NL + "                        ";
  protected final String TEXT_181 = NL + "            }";
  protected final String TEXT_182 = NL + "                    }";
  protected final String TEXT_183 = NL + "                public void putRejectValueAfterExtract_";
  protected final String TEXT_184 = "(";
  protected final String TEXT_185 = NL + "                        ";
  protected final String TEXT_186 = "Struct ";
  protected final String TEXT_187 = ",";
  protected final String TEXT_188 = NL + "                        ";
  protected final String TEXT_189 = "Struct ";
  protected final String TEXT_190 = "){";
  protected final String TEXT_191 = NL + "            ";
  protected final String TEXT_192 = NL + "            }";
  protected final String TEXT_193 = NL + "        ";
  protected final String TEXT_194 = " class XML_NS_RMV_";
  protected final String TEXT_195 = " {" + NL + "            public void removeNamespace(org.dom4j.Document reader," + NL + "                    org.dom4j.Document writer) {" + NL + "                org.dom4j.Element elemReader = reader.getRootElement();" + NL + "                org.dom4j.Element elemTo = writer.addElement(elemReader" + NL + "                        .getName());" + NL + "                if(elemReader!=null && elemReader.getText()!=null && !\"\".equals(elemReader.getText())){" + NL + "                    elemTo.setText(elemReader.getText());" + NL + "                }" + NL + "                for (org.dom4j.Attribute attri : (java.util.List<org.dom4j.Attribute>) elemReader" + NL + "                        .attributes()) {" + NL + "                    elemTo.addAttribute(attri.getName(),attri.getText());" + NL + "                }" + NL + "                removeSubNamespace(elemReader, elemTo);" + NL + "            }" + NL + "" + NL + "            public void removeSubNamespace(org.dom4j.Element elemFrom," + NL + "                    org.dom4j.Element elemTo) {" + NL + "                for (org.dom4j.Element subFrom : (java.util.List<org.dom4j.Element>) elemFrom" + NL + "                        .elements()) {" + NL + "                    org.dom4j.Element tmpElemTo = elemTo.addElement(subFrom" + NL + "                            .getName());" + NL + "                    if(subFrom!=null && subFrom.getText()!=null && !\"\".equals(subFrom.getText())){" + NL + "                        tmpElemTo.setText(subFrom.getText());" + NL + "                    }" + NL + "                    for (org.dom4j.Attribute attri : (java.util.List<org.dom4j.Attribute>) subFrom" + NL + "                            .attributes()) {" + NL + "                        tmpElemTo.addAttribute(attri.getName(),attri.getText());" + NL + "                    }" + NL + "                    removeSubNamespace(subFrom, tmpElemTo);" + NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_196 = NL + "        XML_API_";
  protected final String TEXT_197 = " xml_api_";
  protected final String TEXT_198 = " = new XML_API_";
  protected final String TEXT_199 = "();";
  protected final String TEXT_200 = NL + "            XML_NS_RMV_";
  protected final String TEXT_201 = " XML_ns_rmv_";
  protected final String TEXT_202 = " = null;" + NL + "            org.jaxen.NamespaceContext namespaceContext_";
  protected final String TEXT_203 = " = null;";
  protected final String TEXT_204 = NL + "        String xmlStr_";
  protected final String TEXT_205 = " = null;" + NL + "        String loopQuery_";
  protected final String TEXT_206 = " = null;" + NL + "" + NL + "        NameSpaceTool_";
  protected final String TEXT_207 = " nsTool_";
  protected final String TEXT_208 = " = new NameSpaceTool_";
  protected final String TEXT_209 = "();" + NL + "" + NL + "        javax.xml.stream.XMLOutputFactory xmlOutputFactory_";
  protected final String TEXT_210 = " = null;" + NL + "        org.dom4j.io.SAXReader reader_";
  protected final String TEXT_211 = " = null;" + NL + "        org.dom4j.Document doc_";
  protected final String TEXT_212 = " = null;" + NL + "        java.util.HashMap<String, String> xmlNameSpaceMap_";
  protected final String TEXT_213 = " = new java.util.HashMap<String, String>();" + NL + "        org.dom4j.XPath x_";
  protected final String TEXT_214 = " = null;" + NL + "        java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_215 = " = null;";
  protected final String TEXT_216 = NL;
  protected final String TEXT_217 = NL + "            XML_ns_rmv_";
  protected final String TEXT_218 = " = new XML_NS_RMV_";
  protected final String TEXT_219 = "();" + NL + "            namespaceContext_";
  protected final String TEXT_220 = " = new org.jaxen.NamespaceContext() {" + NL + "                public String translateNamespacePrefixToUri(String prefix) {" + NL + "                    return \"\";//ignore prefix in xpath when evaluate" + NL + "                }" + NL + "            };";
  protected final String TEXT_221 = NL + NL + "        xmlOutputFactory_";
  protected final String TEXT_222 = " = javax.xml.stream.XMLOutputFactory.newInstance();" + NL + "        reader_";
  protected final String TEXT_223 = " = new org.dom4j.io.SAXReader();" + NL + NL;
  protected final String TEXT_224 = NL + "            loopQuery_";
  protected final String TEXT_225 = " = ";
  protected final String TEXT_226 = " + ";
  protected final String TEXT_227 = ";";
  protected final String TEXT_228 = NL + "            loopQuery_";
  protected final String TEXT_229 = " = ";
  protected final String TEXT_230 = ";";
  protected final String TEXT_231 = NL + "        if (";
  protected final String TEXT_232 = " != null) {" + NL + "            xmlStr_";
  protected final String TEXT_233 = " = ";
  protected final String TEXT_234 = ";" + NL + "        } else {" + NL + "            return";
  protected final String TEXT_235 = ";" + NL + "        }" + NL + "" + NL + "        boolean isStructError_";
  protected final String TEXT_236 = " = true;" + NL;
  protected final String TEXT_237 = NL + "            org.dom4j.Document doc_tmp_";
  protected final String TEXT_238 = " = org.dom4j.DocumentHelper.createDocument();" + NL + "            XML_ns_rmv_";
  protected final String TEXT_239 = ".removeNamespace(xmlDocument_";
  protected final String TEXT_240 = ".getDocument()," + NL + "                doc_tmp_";
  protected final String TEXT_241 = ");";
  protected final String TEXT_242 = NL + "            org.dom4j.Document doc_tmp_";
  protected final String TEXT_243 = " = org.dom4j.DocumentHelper.createDocument();" + NL + "            try {" + NL + "                XML_ns_rmv_";
  protected final String TEXT_244 = ".removeNamespace(" + NL + "                    reader_";
  protected final String TEXT_245 = ".read(new java.io.StringReader(xmlStr_";
  protected final String TEXT_246 = "))," + NL + "                    doc_tmp_";
  protected final String TEXT_247 = ");" + NL + "            } catch (org.dom4j.DocumentException e) {";
  protected final String TEXT_248 = NL + "            }";
  protected final String TEXT_249 = NL + NL + "        boolean resultIsNode_";
  protected final String TEXT_250 = " = true;" + NL + "        java.io.ByteArrayInputStream bais_";
  protected final String TEXT_251 = " = null;" + NL + "        java.io.ByteArrayOutputStream  baos_";
  protected final String TEXT_252 = " = new java.io.ByteArrayOutputStream();" + NL;
  protected final String TEXT_253 = NL + NL + "         org.dom4j.Node node_";
  protected final String TEXT_254 = " = null;" + NL + "         String str_";
  protected final String TEXT_255 = " = \"\";" + NL + "         org.dom4j.XPath xTmp_";
  protected final String TEXT_256 = " = null;" + NL + "         Object obj_";
  protected final String TEXT_257 = " = null;" + NL + "         String xmlStrTemp_";
  protected final String TEXT_258 = " = \"\";" + NL + "        java.util.List<String> xmlListTemp_";
  protected final String TEXT_259 = " = null;" + NL + "" + NL + "" + NL + "        if (!isStructError_";
  protected final String TEXT_260 = " && nodeList_";
  protected final String TEXT_261 = " != null) {" + NL + "            for (org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_262 = " : nodeList_";
  protected final String TEXT_263 = ") {";
  protected final String TEXT_264 = NL + "                    ";
  protected final String TEXT_265 = " = new ";
  protected final String TEXT_266 = "();";
  protected final String TEXT_267 = NL + "                    ";
  protected final String TEXT_268 = " = new ";
  protected final String TEXT_269 = "();";
  protected final String TEXT_270 = NL + "                try {";
  protected final String TEXT_271 = NL + "                        ";
  protected final String TEXT_272 = NL + "                        ";
  protected final String TEXT_273 = NL + "                    ";
  protected final String TEXT_274 = NL + "                } catch (java.lang.Exception ex) {";
  protected final String TEXT_275 = NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_276 = NL + "        try{";
  protected final String TEXT_277 = NL + "                    doc_";
  protected final String TEXT_278 = "= xmlDocument_";
  protected final String TEXT_279 = ".getDocument();";
  protected final String TEXT_280 = NL + "                    doc_";
  protected final String TEXT_281 = "= reader_";
  protected final String TEXT_282 = ".read(new java.io.StringReader(xmlStr_";
  protected final String TEXT_283 = "));";
  protected final String TEXT_284 = NL + "                doc_";
  protected final String TEXT_285 = "= doc_tmp_";
  protected final String TEXT_286 = ";";
  protected final String TEXT_287 = NL + NL + "            nsTool_";
  protected final String TEXT_288 = ".countNSMap(doc_";
  protected final String TEXT_289 = ".getRootElement());" + NL + "            xmlNameSpaceMap_";
  protected final String TEXT_290 = " = nsTool_";
  protected final String TEXT_291 = ".xmlNameSpaceMap;" + NL + "            x_";
  protected final String TEXT_292 = " = doc_";
  protected final String TEXT_293 = ".createXPath(nsTool_";
  protected final String TEXT_294 = ".addDefaultNSPrefix(loopQuery_";
  protected final String TEXT_295 = ",loopQuery_";
  protected final String TEXT_296 = "));" + NL + "            x_";
  protected final String TEXT_297 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_298 = ");";
  protected final String TEXT_299 = NL + "                x_";
  protected final String TEXT_300 = ".setNamespaceContext(namespaceContext_";
  protected final String TEXT_301 = ");";
  protected final String TEXT_302 = NL + "            nodeList_";
  protected final String TEXT_303 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_304 = ".selectNodes(doc_";
  protected final String TEXT_305 = ");" + NL + "            isStructError_";
  protected final String TEXT_306 = " = false;" + NL + "" + NL + "        } catch (java.lang.Exception ex) {";
  protected final String TEXT_307 = NL + "        } finally {" + NL + "            try {" + NL + "                baos_";
  protected final String TEXT_308 = ".close();" + NL + "                if (bais_";
  protected final String TEXT_309 = " != null) {" + NL + "                    bais_";
  protected final String TEXT_310 = ".close();" + NL + "                }" + NL + "            } catch (IOException e) {";
  protected final String TEXT_311 = NL + "                    throw new java.io.IOException(e.getMessage());";
  protected final String TEXT_312 = NL + "                    System.err.println(e.getMessage());";
  protected final String TEXT_313 = NL + "            }" + NL + "        }";
  protected final String TEXT_314 = NL + NL + "        org.dom4j.XPath xTmp";
  protected final String TEXT_315 = "_";
  protected final String TEXT_316 = " = temp_";
  protected final String TEXT_317 = ".createXPath(nsTool_";
  protected final String TEXT_318 = ".addDefaultNSPrefix(";
  protected final String TEXT_319 = ",loopQuery_";
  protected final String TEXT_320 = "));" + NL + "        xTmp";
  protected final String TEXT_321 = "_";
  protected final String TEXT_322 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_323 = ");" + NL;
  protected final String TEXT_324 = NL + "            xTmp";
  protected final String TEXT_325 = "_";
  protected final String TEXT_326 = ".setNamespaceContext(namespaceContext_";
  protected final String TEXT_327 = ");";
  protected final String TEXT_328 = NL + NL + "        Object obj";
  protected final String TEXT_329 = "_";
  protected final String TEXT_330 = " = xTmp";
  protected final String TEXT_331 = "_";
  protected final String TEXT_332 = ".evaluate(temp_";
  protected final String TEXT_333 = ");" + NL + "        if (obj";
  protected final String TEXT_334 = "_";
  protected final String TEXT_335 = " instanceof String || obj";
  protected final String TEXT_336 = "_";
  protected final String TEXT_337 = " instanceof Number) {" + NL + "            resultIsNode_";
  protected final String TEXT_338 = " = false;" + NL + "            str_";
  protected final String TEXT_339 = " = String.valueOf(obj";
  protected final String TEXT_340 = "_";
  protected final String TEXT_341 = ");" + NL + "        } else {" + NL + "            resultIsNode_";
  protected final String TEXT_342 = " = true;" + NL + "            node_";
  protected final String TEXT_343 = " = xTmp";
  protected final String TEXT_344 = "_";
  protected final String TEXT_345 = ".selectSingleNode(temp_";
  protected final String TEXT_346 = ");" + NL;
  protected final String TEXT_347 = NL + "                str_";
  protected final String TEXT_348 = " = node_";
  protected final String TEXT_349 = " == null ? null : node_";
  protected final String TEXT_350 = ".asXML();";
  protected final String TEXT_351 = NL + "                str_";
  protected final String TEXT_352 = " = xTmp";
  protected final String TEXT_353 = "_";
  protected final String TEXT_354 = ".valueOf(temp_";
  protected final String TEXT_355 = ");";
  protected final String TEXT_356 = NL + "        }" + NL;
  protected final String TEXT_357 = NL + "                            ";
  protected final String TEXT_358 = NL + "                            ";
  protected final String TEXT_359 = NL + "                        ";
  protected final String TEXT_360 = NL + "                        ";
  protected final String TEXT_361 = NL + "                        ";
  protected final String TEXT_362 = NL + "                        if (resultIsNode_";
  protected final String TEXT_363 = " && xml_api_";
  protected final String TEXT_364 = ".isDefNull(node_";
  protected final String TEXT_365 = ")) {";
  protected final String TEXT_366 = NL + "                            ";
  protected final String TEXT_367 = NL + "                        } else if (resultIsNode_";
  protected final String TEXT_368 = " && xml_api_";
  protected final String TEXT_369 = ".isEmpty(node_";
  protected final String TEXT_370 = ")) {";
  protected final String TEXT_371 = NL + "                            ";
  protected final String TEXT_372 = NL + "                        } else if (resultIsNode_";
  protected final String TEXT_373 = " && xml_api_";
  protected final String TEXT_374 = ".isMissing(node_";
  protected final String TEXT_375 = " )){";
  protected final String TEXT_376 = NL + "                            ";
  protected final String TEXT_377 = NL + "                        } else{";
  protected final String TEXT_378 = NL + "                        if (resultIsNode_";
  protected final String TEXT_379 = " && xml_api_";
  protected final String TEXT_380 = ".isEmpty(node_";
  protected final String TEXT_381 = ")) {";
  protected final String TEXT_382 = NL + "                            ";
  protected final String TEXT_383 = NL + "                        } else if (resultIsNode_";
  protected final String TEXT_384 = " && xml_api_";
  protected final String TEXT_385 = ".isMissing(node_";
  protected final String TEXT_386 = ")) {";
  protected final String TEXT_387 = NL + "                            ";
  protected final String TEXT_388 = NL + "                        } else {";
  protected final String TEXT_389 = NL + "                        if (resultIsNode_";
  protected final String TEXT_390 = " && xml_api_";
  protected final String TEXT_391 = ".isDefNull(node_";
  protected final String TEXT_392 = ")) {";
  protected final String TEXT_393 = NL + "                            ";
  protected final String TEXT_394 = NL + "                        } else if (resultIsNode_";
  protected final String TEXT_395 = " && (xml_api_";
  protected final String TEXT_396 = ".isEmpty(node_";
  protected final String TEXT_397 = ") || xml_api_";
  protected final String TEXT_398 = ".isMissing(node_";
  protected final String TEXT_399 = "))) {";
  protected final String TEXT_400 = NL + "                            ";
  protected final String TEXT_401 = NL + "                        } else {";
  protected final String TEXT_402 = NL + "                        if (resultIsNode_";
  protected final String TEXT_403 = " && (xml_api_";
  protected final String TEXT_404 = ".isMissing(node_";
  protected final String TEXT_405 = ") || xml_api_";
  protected final String TEXT_406 = ".isEmpty(node_";
  protected final String TEXT_407 = "))) {";
  protected final String TEXT_408 = NL + "                             ";
  protected final String TEXT_409 = NL + "                        } else {";
  protected final String TEXT_410 = NL + "                    ";
  protected final String TEXT_411 = NL + "                        ";
  protected final String TEXT_412 = NL + "                            ";
  protected final String TEXT_413 = NL + "                            ";
  protected final String TEXT_414 = NL + "                        ";
  protected final String TEXT_415 = NL + "                }";
  protected final String TEXT_416 = NL + "            ";
  protected final String TEXT_417 = NL + "            // Die immediately on errors." + NL + "            throw new IOException(";
  protected final String TEXT_418 = ");";
  protected final String TEXT_419 = NL + "                // Ignore errors processing this row and move to the next.";
  protected final String TEXT_420 = NL + "                // Send error rows to the reject output.";
  protected final String TEXT_421 = NL + "                ";
  protected final String TEXT_422 = NL + "                    ";
  protected final String TEXT_423 = NL + "                ";
  protected final String TEXT_424 = NL + "                ";

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
        
    stringBuffer.append(TEXT_133);
    stringBuffer.append(isStatic ? "static" : "");
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
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
        
    stringBuffer.append(TEXT_136);
    stringBuffer.append(isStatic ? "static" : "");
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
            if (schemaOptNum < mappings.size()) {
                generateClassXmlApiMethodsPutUnExtractValue();
                generateClassXmlApiMethodsPutExtractValue();
                if (!dieOnError && getOutConnReject() != null) {
                    generateClassXmlApiMethodsPutRejectValueBeforeExtract();
                    if (getOutConnMainName() != null)
                        generateClassXmlApiMethodsPutRejectValueAfterExtract();
                }
            }
            
    stringBuffer.append(TEXT_139);
    
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
                    
    stringBuffer.append(TEXT_140);
    
                }
                // Every n'th column to process, open a new method.
                
    stringBuffer.append(TEXT_141);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(getOutConnMain()));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(getOutConnMainName());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(getInConn()));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(getInConnName());
    stringBuffer.append(TEXT_148);
    
                methodStarted = true;
            }
            
    stringBuffer.append(TEXT_149);
    stringBuffer.append(getRowTransform().getCodeToCopyField(false, columnName));
    
        }
        // Close any open methods.
        if (methodStarted) {
            
    stringBuffer.append(TEXT_150);
    
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
                        
    stringBuffer.append(TEXT_151);
    
                    }
                    // Every n'th column to process, open a new method.
                    
    stringBuffer.append(TEXT_152);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(getOutConnMain()));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(getOutConnMainName());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(TEXT_156);
    stringBuffer.append( getInConn() != null ? NodeUtil.getPrivateConnClassName(getInConn()) + "Struct "
                                    + getInConnName() + ",": "" );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append( ignore_NS_Str ? ", org.jaxen.NamespaceContext namespaceContext_" + cid : "" );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    
                    methodStarted = true;
                }
                
    
                columnNo++;
            }
        }
        // Close any open methods.
        if (methodStarted) {
            
    stringBuffer.append(TEXT_170);
    
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
                                
    stringBuffer.append(TEXT_171);
    
                            }
                            // Every n'th column to process, open a new method.
                            
    stringBuffer.append(TEXT_172);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(getOutConnRejectName());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(getOutConnRejectName());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(getInConn()));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(getInConnName());
    stringBuffer.append(TEXT_179);
    
                            methodStarted = true;
                        }
                        
    stringBuffer.append(TEXT_180);
    stringBuffer.append(getRowTransform().getCodeToCopyField(true, column.getLabel()));
    
                        columnNo++;
                    }
                }
            }
        }
        // Close any open methods.
        if (methodStarted) {
            
    stringBuffer.append(TEXT_181);
    
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
                    
    stringBuffer.append(TEXT_182);
    
                }
                // Every n'th column to process, open a new method.
                
    stringBuffer.append(TEXT_183);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(getOutConnRejectName());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(getOutConnRejectName());
    stringBuffer.append(TEXT_187);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(getOutConnMainName() );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(getOutConnMainName() );
    stringBuffer.append(TEXT_190);
    
                methodStarted = true;
            }
            
    stringBuffer.append(TEXT_191);
    stringBuffer.append(getRowTransform().getCodeToCopyField(true, column.getLabel()));
    
        }
        // Close any open methods.
        if (methodStarted) {
            
    stringBuffer.append(TEXT_192);
    
        }
    }

    private void generateClassXmlApiRmv(boolean isStatic) {
        // Start generating code for XML_API_RMV_cid class.
        
    stringBuffer.append(TEXT_193);
    stringBuffer.append(isStatic ? "static" : "");
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    
        // End generated code for XML_API_RMV_cid
    }

    public void generateTransformContextDeclaration() {
        
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
     if (ignore_NS_Str) { 
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
     } 
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
    
    }

    public void generateTransformContextInitialization() {
        
    stringBuffer.append(TEXT_216);
     if (ignore_NS_Str) { 
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
     } 
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
     if (useXMLField) { 
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(strXMLPrefix);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_227);
     } else { 
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_230);
    
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
        
    stringBuffer.append(TEXT_231);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_234);
    stringBuffer.append(hasAReturnedType?" null":"");
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    
        if (ignore_NS_Str && isDocumentType) {
            
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    
        } else if (ignore_NS_Str && !isDocumentType) {
            
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
     generateTransformReject(dieOnError, "e", null, "xmlStr_" + cid); 
    stringBuffer.append(TEXT_248);
    
        }
        
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    
        generateTransformParseInputField();
        // After this call, the isStructError_cid member is false if the XML
        // input was correctly parsed into the common structures.
        int i = 0;
        
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    
                if (getOutConnMain() != null) {
                    
    stringBuffer.append(TEXT_264);
    stringBuffer.append(getOutConnMain().getName());
    stringBuffer.append(TEXT_265);
    stringBuffer.append(codeGenArgument.getRecordStructName(getOutConnMain()));
    stringBuffer.append(TEXT_266);
    
                } else {
                    
    stringBuffer.append(TEXT_267);
    stringBuffer.append(getOutConnReject().getName());
    stringBuffer.append(TEXT_268);
    stringBuffer.append(codeGenArgument.getRecordStructName(getOutConnReject()));
    stringBuffer.append(TEXT_269);
    
                }
                
    stringBuffer.append(TEXT_270);
    
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
                        
    stringBuffer.append(TEXT_271);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(false, copiedInColumns));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(getRowTransform().getCodeToEmit(false));
    
                    }
                    
    stringBuffer.append(TEXT_273);
    stringBuffer.append(getRowTransform().getCodeToInitOut(null == getOutConnMain(), newOutColumns));
    stringBuffer.append(TEXT_274);
    
                    generateTransformReject(dieOnError, "ex", null, "temp_"+cid+".asXML()");
                    
    stringBuffer.append(TEXT_275);
    
    }

    /**
     * Part of the code generation for parsing the input field into several of
     * the variables that are used to generate output.
     */
    private void generateTransformParseInputField() {
        // Parse the structure.
        
    stringBuffer.append(TEXT_276);
    
            if (!ignore_NS_Str) {
                if (isDocumentType) {
                    
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    
                } else {
                    
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    
                }
            } else {
                
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    
            }
            
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    if(ignore_NS_Str){
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    }
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    
            generateTransformReject(dieOnError, "ex", null, "xmlStr_"+cid);
            
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
     if (dieOnError) { 
    stringBuffer.append(TEXT_311);
     } else { 
    stringBuffer.append(TEXT_312);
     } 
    stringBuffer.append(TEXT_313);
    
    }

    /**
     * Generates code that performs the tranformation from one JSON input string
     * to many output strings, or to a reject flow.
     */
    private void generateTransformForMapping(final int i, final boolean nodeCheck,
        final String query, final String columnName) {
        
    stringBuffer.append(TEXT_314);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
     if(ignore_NS_Str) { 
    stringBuffer.append(TEXT_324);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
     } 
    stringBuffer.append(TEXT_328);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
     if(nodeCheck) { 
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
     } else { 
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_355);
     } 
    stringBuffer.append(TEXT_356);
    
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
    stringBuffer.append(TEXT_357);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "java.nio.ByteBuffer.wrap(str_" + cid + ".getBytes())"));
     } else { 
    stringBuffer.append(TEXT_358);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "str_" + cid + ".getBytes()"));
     } 
     } else if (javaType == JavaTypesManager.DATE) { 
    stringBuffer.append(TEXT_359);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(str_" + cid + ", " + column.getPattern() + ")"));
     } else if(!("id_Document".equals(column.getTalendType()))) { 
    stringBuffer.append(TEXT_360);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_"+ typeToGenerate +"(str_" + cid + ")"));
     } else { 
    stringBuffer.append(TEXT_361);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Document(str_" + cid + ")"));
     }
                    continue;
                }

                if (javaType == JavaTypesManager.STRING) {
                    if(column.isNullable()) {
                        
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null"));
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "\"\""));
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?null:column.getDefault()));
    stringBuffer.append(TEXT_377);
    
                    } else { // column.isNullable()
                        
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "\"\""));
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault()));
    stringBuffer.append(TEXT_388);
    
                    }
                } else { // other non-STRING types
                    if (column.isNullable()) {
                        
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "null") );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?null:column.getDefault()));
    stringBuffer.append(TEXT_401);
    
                    } else { // column.isNullable()
                        
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault()));
    stringBuffer.append(TEXT_409);
    
                    }
                }
                // There's a dangling else { statement at this point.

                if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
                    
    stringBuffer.append(TEXT_410);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "str_" + cid));
    
                } else {
                    if (javaType == JavaTypesManager.DATE) {
                        
    stringBuffer.append(TEXT_411);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(str_"+cid+", "+patternValue+")"));
    
                    } else if (javaType == JavaTypesManager.BYTE_ARRAY) {
                        if ("SPARKSTREAMING".equals(node.getComponent().getType()) || "SPARK".equals(node.getComponent().getType())) {
                            
    stringBuffer.append(TEXT_412);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "java.nio.ByteBuffer.wrap(str_" + cid + ".getBytes())"));
    
                        } else {
                            
    stringBuffer.append(TEXT_413);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "str_" + cid + ".getBytes()"));
    
                        }
                    } else {
                        
    stringBuffer.append(TEXT_414);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_"+typeToGenerate+"(str_"+cid+")"));
    
                    }
                }

                // Close the dangling else
                
    stringBuffer.append(TEXT_415);
    
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
            
    stringBuffer.append(TEXT_416);
    stringBuffer.append(getRowTransform().getCodeToCopyOutMainToReject(newOutColumns));
    
        }

        if (die) {
            
    stringBuffer.append(TEXT_417);
    stringBuffer.append(codeException);
    stringBuffer.append(TEXT_418);
    
        } else {
            if (null == getOutConnReject()) {
                
    stringBuffer.append(TEXT_419);
    
                generateLogMessage(codeRejectMsg);
            } else {
                
    stringBuffer.append(TEXT_420);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_MSG,
                        codeRejectMsg) );
    
                if (containsRejectField) {
                    
    stringBuffer.append(TEXT_422);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_FIELD,
                        codeRejectField) );
    
                }
                
    stringBuffer.append(TEXT_423);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(true, copiedInColumns));
    stringBuffer.append(TEXT_424);
    stringBuffer.append(getRowTransform().getCodeToEmit(true));
    
            }
        }
    }
}

    
final MrMapperRowTransformUtil mrTransformUtil = new MrMapperRowTransformUtil();
final TExtractXMLFieldUtil tExtractXMLFieldUtil = new TExtractXMLFieldUtil(
        node, codeGenArgument, mrTransformUtil);
mrTransformUtil.generateMrConfig(tExtractXMLFieldUtil, cid + "Mapper.class");

    return stringBuffer.toString();
  }
}
