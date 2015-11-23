package org.talend.designer.codegen.translators.processing.fields;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import java.util.Map;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TWriteJSONFieldSparkcodeJava
{
  protected static String nl;
  public static synchronized TWriteJSONFieldSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteJSONFieldSparkcodeJava result = new TWriteJSONFieldSparkcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "public static class ";
  protected final String TEXT_4 = " implements java.io.Serializable {" + NL + "\tprivate ContextProperties context;" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_5 = "(ContextProperties context) {" + NL + "\t\tthis.context = context;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void mapRootTableToTree(";
  protected final String TEXT_6 = " value, java.util.HashMap<String, org.json.simple.JSONObject> outputTree) {" + NL + "\t    org.json.simple.JSONObject jsonRow_";
  protected final String TEXT_7 = " = new org.json.simple.JSONObject();" + NL + "\t    ";
  protected final String TEXT_8 = NL + "                // get the parent" + NL + "                if (outputTree.containsKey(\"";
  protected final String TEXT_9 = "\")) {" + NL + "                    jsonRow_";
  protected final String TEXT_10 = "  = outputTree.get(\"";
  protected final String TEXT_11 = "\");" + NL + "                } else {" + NL + "                    throw new RuntimeException(\"No parent found for node ";
  protected final String TEXT_12 = ".\");" + NL + "                }" + NL + "                jsonRow_";
  protected final String TEXT_13 = ".put(\"";
  protected final String TEXT_14 = "\", ";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "                // Create element" + NL + "                jsonRow_";
  protected final String TEXT_17 = " = new org.json.simple.JSONObject();" + NL + "                // add it to the tree" + NL + "                outputTree.put(\"";
  protected final String TEXT_18 = "\", jsonRow_";
  protected final String TEXT_19 = ");" + NL + "                // link it to its parent" + NL + "                if (outputTree.containsKey(\"";
  protected final String TEXT_20 = "\")) {" + NL + "                    outputTree.get(\"";
  protected final String TEXT_21 = "\").put(\"";
  protected final String TEXT_22 = "\", jsonRow_";
  protected final String TEXT_23 = ");" + NL + "                }";
  protected final String TEXT_24 = NL + "                // get the parent" + NL + "                if (outputTree.containsKey(\"";
  protected final String TEXT_25 = "\")) {" + NL + "                    jsonRow_";
  protected final String TEXT_26 = "  = outputTree.get(\"";
  protected final String TEXT_27 = "\");" + NL + "                } else {" + NL + "                    throw new RuntimeException(\"No parent found for node ";
  protected final String TEXT_28 = ".\");" + NL + "                }" + NL + "                // add the element to the parent";
  protected final String TEXT_29 = NL + "                        if(value.";
  protected final String TEXT_30 = " != null){";
  protected final String TEXT_31 = NL + "                            jsonRow_";
  protected final String TEXT_32 = ".put(\"";
  protected final String TEXT_33 = "\", FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_34 = ", ";
  protected final String TEXT_35 = "));";
  protected final String TEXT_36 = NL + "                            jsonRow_";
  protected final String TEXT_37 = ".put(\"";
  protected final String TEXT_38 = "\", String.valueOf(value.";
  protected final String TEXT_39 = "));";
  protected final String TEXT_40 = NL + "                            jsonRow_";
  protected final String TEXT_41 = ".put(\"";
  protected final String TEXT_42 = "\", value.";
  protected final String TEXT_43 = ");";
  protected final String TEXT_44 = NL + "                        }else{" + NL + "                            jsonRow_";
  protected final String TEXT_45 = ".put(\"";
  protected final String TEXT_46 = "\", null);" + NL + "                        }";
  protected final String TEXT_47 = NL + "                if (true) {" + NL + "                    throw new RuntimeException(\"This component does not support namespace, please remove them from the tree.\");" + NL + "                }";
  protected final String TEXT_48 = NL + "                if (true) {" + NL + "                    throw new RuntimeException(\"This component does not support attribute, please remove them from the tree.\");" + NL + "                }";
  protected final String TEXT_49 = NL + "                if (true) {" + NL + "                    throw new RuntimeException(\"Unhandled element type ";
  protected final String TEXT_50 = ".\");" + NL + "                }";
  protected final String TEXT_51 = NL + "\t} // end of class mapRootTableToTree" + NL + "" + NL + "\t// TODO: the mapRootTableToTree and the mapLoopTableToTree are more or less the same function," + NL + "\t// except they use two different javajet as input. We may want to factorise that." + NL + "\tpublic void mapLoopTableToTree(";
  protected final String TEXT_52 = " value, java.util.HashMap<String, org.json.simple.JSONObject> outputTree) {" + NL + "        org.json.simple.JSONObject jsonRow_";
  protected final String TEXT_53 = " = new org.json.simple.JSONObject();";
  protected final String TEXT_54 = NL + "                // get the parent" + NL + "                if (outputTree.containsKey(\"";
  protected final String TEXT_55 = "\")) {" + NL + "                    jsonRow_";
  protected final String TEXT_56 = "  = outputTree.get(\"";
  protected final String TEXT_57 = "\");" + NL + "                } else {" + NL + "                    throw new RuntimeException(\"No parent found for node ";
  protected final String TEXT_58 = ".\");" + NL + "                }" + NL + "                jsonRow_";
  protected final String TEXT_59 = ".put(\"";
  protected final String TEXT_60 = "\", ";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = NL + "                // Create element" + NL + "                jsonRow_";
  protected final String TEXT_63 = " = new org.json.simple.JSONObject();" + NL + "                // add it to the tree" + NL + "                outputTree.put(\"";
  protected final String TEXT_64 = "\", jsonRow_";
  protected final String TEXT_65 = ");" + NL + "                // link it to its parent" + NL + "                if (outputTree.containsKey(\"";
  protected final String TEXT_66 = "\")) {" + NL + "                    outputTree.get(\"";
  protected final String TEXT_67 = "\").put(\"";
  protected final String TEXT_68 = "\", jsonRow_";
  protected final String TEXT_69 = ");" + NL + "                }";
  protected final String TEXT_70 = NL + "                // get the parent" + NL + "                if (outputTree.containsKey(\"";
  protected final String TEXT_71 = "\")) {" + NL + "                    jsonRow_";
  protected final String TEXT_72 = "  = outputTree.get(\"";
  protected final String TEXT_73 = "\");" + NL + "                } else {" + NL + "                    throw new RuntimeException(\"No parent found for node ";
  protected final String TEXT_74 = ".\");" + NL + "                }" + NL + "                // add the element to the parent";
  protected final String TEXT_75 = NL + "                        if(value.";
  protected final String TEXT_76 = " != null){";
  protected final String TEXT_77 = NL + "                        jsonRow_";
  protected final String TEXT_78 = ".put(\"";
  protected final String TEXT_79 = "\", FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_80 = ", ";
  protected final String TEXT_81 = "));";
  protected final String TEXT_82 = NL + "                        jsonRow_";
  protected final String TEXT_83 = ".put(\"";
  protected final String TEXT_84 = "\", String.valueOf(value.";
  protected final String TEXT_85 = "));";
  protected final String TEXT_86 = NL + "                        jsonRow_";
  protected final String TEXT_87 = ".put(\"";
  protected final String TEXT_88 = "\", value.";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "                        }else{" + NL + "                            jsonRow_";
  protected final String TEXT_91 = ".put(\"";
  protected final String TEXT_92 = "\", null);" + NL + "                        }";
  protected final String TEXT_93 = NL + "                if (true) {" + NL + "                    throw new RuntimeException(\"This component does not support namespace, please remove them from the tree.\");" + NL + "                }";
  protected final String TEXT_94 = NL + "                if (true) {" + NL + "                    throw new RuntimeException(\"This component does not support attributes, please remove them from the tree.\");" + NL + "                }";
  protected final String TEXT_95 = NL + "                if (true) {" + NL + "                    throw new RuntimeException(\"Unhandled element type ";
  protected final String TEXT_96 = ".\");" + NL + "                }";
  protected final String TEXT_97 = NL + "    } // end of class mapLoopTableToTree" + NL + "" + NL + "   public void mapLoopTableToArray(";
  protected final String TEXT_98 = " value, org.json.simple.JSONArray loopElementRoot) {";
  protected final String TEXT_99 = NL + "                    if(value.";
  protected final String TEXT_100 = " != null){";
  protected final String TEXT_101 = NL + "                    loopElementRoot.add(FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_102 = ", ";
  protected final String TEXT_103 = "));";
  protected final String TEXT_104 = NL + "                    loopElementRoot.add(String.valueOf(value.";
  protected final String TEXT_105 = "));";
  protected final String TEXT_106 = NL + "                    loopElementRoot.add(value.";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = NL + "                    }else{" + NL + "                        loopElementRoot.add(null);" + NL + "                    }";
  protected final String TEXT_109 = NL + "    } // end of class mapLoopTableToArray" + NL + "" + NL + "\tpublic byte[] convert(Iterable<";
  protected final String TEXT_110 = "> values) {" + NL + "\t    java.util.HashMap<String, org.json.simple.JSONObject> jsonTree_";
  protected final String TEXT_111 = "  = new java.util.HashMap<String, org.json.simple.JSONObject>();" + NL + "" + NL + "\t    ";
  protected final String TEXT_112 = NL + "            if (true) {" + NL + "                throw new RuntimeException(\"This component does not support the option \\\"group element\\\", please remove them from the tree.\");" + NL + "            }";
  protected final String TEXT_113 = NL + NL + "\t    java.util.Iterator<";
  protected final String TEXT_114 = "> valuesIterator = values.iterator();" + NL + "\t\tif (valuesIterator.hasNext()) {" + NL + "\t\t    ";
  protected final String TEXT_115 = " value = valuesIterator.next();" + NL + "\t\t    // create the common tree" + NL + "\t\t    mapRootTableToTree(value, jsonTree_";
  protected final String TEXT_116 = ");" + NL + "\t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_117 = NL + "\t\t    org.json.simple.JSONArray loopElementRoot = new org.json.simple.JSONArray();" + NL + "            // prepare aggregation" + NL + "\t\t    ";
  protected final String TEXT_118 = NL + "            if (jsonTree_";
  protected final String TEXT_119 = ".containsKey(\"";
  protected final String TEXT_120 = "\")) {" + NL + "                jsonTree_";
  protected final String TEXT_121 = ".get(\"";
  protected final String TEXT_122 = "\").put(\"";
  protected final String TEXT_123 = "\", loopElementRoot);" + NL + "            }" + NL;
  protected final String TEXT_124 = NL + "                for (";
  protected final String TEXT_125 = " value: values) {" + NL + "                    loopElementRoot.add(";
  protected final String TEXT_126 = ");" + NL + "                }";
  protected final String TEXT_127 = NL + "                // aggregate Json field" + NL + "                for (";
  protected final String TEXT_128 = " value: values) {" + NL + "                    mapLoopTableToArray(value, loopElementRoot);" + NL + "                }";
  protected final String TEXT_129 = NL + "                // aggregate JSON object" + NL + "                for (";
  protected final String TEXT_130 = " value: values) {" + NL + "                    java.util.HashMap<String, org.json.simple.JSONObject> jsonSubTree = new java.util.HashMap<String, org.json.simple.JSONObject>();" + NL + "                    mapLoopTableToTree(value, jsonSubTree);" + NL + "                    loopElementRoot.add(jsonSubTree.get(\"";
  protected final String TEXT_131 = "/";
  protected final String TEXT_132 = "\"));" + NL + "                }";
  protected final String TEXT_133 = NL + "            return jsonTree_";
  protected final String TEXT_134 = ".get(\"/";
  protected final String TEXT_135 = "\").toString().getBytes();";
  protected final String TEXT_136 = NL + "            // Create specifici node for rootTag" + NL + "            org.json.simple.JSONObject jsonRow_";
  protected final String TEXT_137 = " = new org.json.simple.JSONObject();" + NL + "            jsonRow_";
  protected final String TEXT_138 = ".put(\"";
  protected final String TEXT_139 = "\", jsonTree_";
  protected final String TEXT_140 = ".get(\"/";
  protected final String TEXT_141 = "\"));" + NL + "            return jsonRow_";
  protected final String TEXT_142 = ".toString().getBytes();";
  protected final String TEXT_143 = NL + NL + "\t} // end convert()\t" + NL + "" + NL + "} // end ";
  protected final String TEXT_144 = "_";
  protected final String TEXT_145 = "ToJSONConverter class ";
  protected final String TEXT_146 = NL;
  protected final String TEXT_147 = NL;
  protected final String TEXT_148 = NL + NL + "public static class ";
  protected final String TEXT_149 = " implements java.io.Serializable {" + NL + "    private ContextProperties context;" + NL + "" + NL + "    public ";
  protected final String TEXT_150 = "(ContextProperties context) {" + NL + "        this.context = context;" + NL + "    }" + NL + "    " + NL + "    public void mapRootTableToTree(";
  protected final String TEXT_151 = " value, java.util.HashMap<String, org.json.simple.JSONObject> outputTree) {" + NL + "        org.json.simple.JSONObject jsonRow_";
  protected final String TEXT_152 = " = new org.json.simple.JSONObject();";
  protected final String TEXT_153 = NL + "                // get the parent" + NL + "                if (outputTree.containsKey(\"";
  protected final String TEXT_154 = "\")) {" + NL + "                    jsonRow_";
  protected final String TEXT_155 = "  = outputTree.get(\"";
  protected final String TEXT_156 = "\");" + NL + "                } else {" + NL + "                    throw new RuntimeException(\"No parent found for node ";
  protected final String TEXT_157 = ".\");" + NL + "                }" + NL + "                jsonRow_";
  protected final String TEXT_158 = ".put(\"";
  protected final String TEXT_159 = "\", ";
  protected final String TEXT_160 = ");";
  protected final String TEXT_161 = NL + "                // Create element" + NL + "                jsonRow_";
  protected final String TEXT_162 = " = new org.json.simple.JSONObject();" + NL + "                // add it to the tree" + NL + "                outputTree.put(\"";
  protected final String TEXT_163 = "\", jsonRow_";
  protected final String TEXT_164 = ");" + NL + "                // link it to its parent" + NL + "                if (outputTree.containsKey(\"";
  protected final String TEXT_165 = "\")) {" + NL + "                    outputTree.get(\"";
  protected final String TEXT_166 = "\").put(\"";
  protected final String TEXT_167 = "\", jsonRow_";
  protected final String TEXT_168 = ");" + NL + "                }";
  protected final String TEXT_169 = NL + "                // get the parent" + NL + "                if (outputTree.containsKey(\"";
  protected final String TEXT_170 = "\")) {" + NL + "                    jsonRow_";
  protected final String TEXT_171 = "  = outputTree.get(\"";
  protected final String TEXT_172 = "\");" + NL + "                } else {" + NL + "                    throw new RuntimeException(\"No parent found for node ";
  protected final String TEXT_173 = ".\");" + NL + "                }" + NL + "                // add the element to the parent";
  protected final String TEXT_174 = NL + "                        if(value.";
  protected final String TEXT_175 = " != null){";
  protected final String TEXT_176 = NL + "                            jsonRow_";
  protected final String TEXT_177 = ".put(\"";
  protected final String TEXT_178 = "\", FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_179 = ", ";
  protected final String TEXT_180 = "));";
  protected final String TEXT_181 = NL + "                            jsonRow_";
  protected final String TEXT_182 = ".put(\"";
  protected final String TEXT_183 = "\", String.valueOf(value.";
  protected final String TEXT_184 = "));";
  protected final String TEXT_185 = NL + "                            jsonRow_";
  protected final String TEXT_186 = ".put(\"";
  protected final String TEXT_187 = "\", value.";
  protected final String TEXT_188 = ");";
  protected final String TEXT_189 = NL + "                        }else{" + NL + "                            jsonRow_";
  protected final String TEXT_190 = ".put(\"";
  protected final String TEXT_191 = "\", null);" + NL + "                        }";
  protected final String TEXT_192 = NL + "                if (true) {" + NL + "                    throw new RuntimeException(\"This component does not support namespace, please remove them from the tree.\");" + NL + "                }";
  protected final String TEXT_193 = NL + "                if (true) {" + NL + "                    throw new RuntimeException(\"This component does not support attribute, please remove them from the tree.\");" + NL + "                }";
  protected final String TEXT_194 = NL + "                if (true) {" + NL + "                    throw new RuntimeException(\"Unhandled element type ";
  protected final String TEXT_195 = ".\");" + NL + "                }";
  protected final String TEXT_196 = NL + "    } // end of class mapRootTableToTree" + NL + "" + NL + "    // TODO: the mapRootTableToTree and the mapLoopTableToTree are more or less the same function," + NL + "    // except they use two different javajet as input. We may want to factorise that." + NL + "    public void mapLoopTableToTree(";
  protected final String TEXT_197 = " value, java.util.HashMap<String, org.json.simple.JSONObject> outputTree) {" + NL + "        org.json.simple.JSONObject jsonRow_";
  protected final String TEXT_198 = " = new org.json.simple.JSONObject();";
  protected final String TEXT_199 = NL + "                // get the parent" + NL + "                if (outputTree.containsKey(\"";
  protected final String TEXT_200 = "\")) {" + NL + "                    jsonRow_";
  protected final String TEXT_201 = "  = outputTree.get(\"";
  protected final String TEXT_202 = "\");" + NL + "                } else {" + NL + "                    throw new RuntimeException(\"No parent found for node ";
  protected final String TEXT_203 = ".\");" + NL + "                }" + NL + "                jsonRow_";
  protected final String TEXT_204 = ".put(\"";
  protected final String TEXT_205 = "\", ";
  protected final String TEXT_206 = ");";
  protected final String TEXT_207 = NL + "                // Create element" + NL + "                jsonRow_";
  protected final String TEXT_208 = " = new org.json.simple.JSONObject();" + NL + "                // add it to the tree" + NL + "                outputTree.put(\"";
  protected final String TEXT_209 = "\", jsonRow_";
  protected final String TEXT_210 = ");" + NL + "                // link it to its parent" + NL + "                if (outputTree.containsKey(\"";
  protected final String TEXT_211 = "\")) {" + NL + "                    outputTree.get(\"";
  protected final String TEXT_212 = "\").put(\"";
  protected final String TEXT_213 = "\", jsonRow_";
  protected final String TEXT_214 = ");" + NL + "                }";
  protected final String TEXT_215 = NL + "                // get the parent" + NL + "                if (outputTree.containsKey(\"";
  protected final String TEXT_216 = "\")) {" + NL + "                    jsonRow_";
  protected final String TEXT_217 = "  = outputTree.get(\"";
  protected final String TEXT_218 = "\");" + NL + "                } else {" + NL + "                    throw new RuntimeException(\"No parent found for node ";
  protected final String TEXT_219 = ".\");" + NL + "                }" + NL + "                // add the element to the parent";
  protected final String TEXT_220 = NL + "                        if(value.";
  protected final String TEXT_221 = " != null){";
  protected final String TEXT_222 = NL + "                        jsonRow_";
  protected final String TEXT_223 = ".put(\"";
  protected final String TEXT_224 = "\", FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_225 = ", ";
  protected final String TEXT_226 = "));";
  protected final String TEXT_227 = NL + "                        jsonRow_";
  protected final String TEXT_228 = ".put(\"";
  protected final String TEXT_229 = "\", String.valueOf(value.";
  protected final String TEXT_230 = "));";
  protected final String TEXT_231 = NL + "                        jsonRow_";
  protected final String TEXT_232 = ".put(\"";
  protected final String TEXT_233 = "\", value.";
  protected final String TEXT_234 = ");";
  protected final String TEXT_235 = NL + "                        }else{" + NL + "                            jsonRow_";
  protected final String TEXT_236 = ".put(\"";
  protected final String TEXT_237 = "\", null);" + NL + "                        }";
  protected final String TEXT_238 = NL + "                if (true) {" + NL + "                    throw new RuntimeException(\"This component does not support namespace, please remove them from the tree.\");" + NL + "                }";
  protected final String TEXT_239 = NL + "                if (true) {" + NL + "                    throw new RuntimeException(\"This component does not support attributes, please remove them from the tree.\");" + NL + "                }";
  protected final String TEXT_240 = NL + "                if (true) {" + NL + "                    throw new RuntimeException(\"Unhandled element type ";
  protected final String TEXT_241 = ".\");" + NL + "                }";
  protected final String TEXT_242 = NL + "    } // end of class mapLoopTableToTree" + NL + "" + NL + "   public void mapLoopTableToArray(";
  protected final String TEXT_243 = " value, org.json.simple.JSONArray loopElementRoot) {";
  protected final String TEXT_244 = NL + "                    if(value.";
  protected final String TEXT_245 = " != null){";
  protected final String TEXT_246 = NL + "                    loopElementRoot.add(FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_247 = ", ";
  protected final String TEXT_248 = "));";
  protected final String TEXT_249 = NL + "                    loopElementRoot.add( String.valueOf(value.";
  protected final String TEXT_250 = "));";
  protected final String TEXT_251 = NL + "                    loopElementRoot.add(value.";
  protected final String TEXT_252 = ");";
  protected final String TEXT_253 = NL + "                    }else{" + NL + "                        loopElementRoot.add(null);" + NL + "                    }";
  protected final String TEXT_254 = NL + "    } // end of class mapLoopTableToArray" + NL + "" + NL + "   public byte[] convert(";
  protected final String TEXT_255 = " value) {" + NL + "        java.util.HashMap<String, org.json.simple.JSONObject> jsonTree_";
  protected final String TEXT_256 = "  = new java.util.HashMap<String, org.json.simple.JSONObject>();" + NL;
  protected final String TEXT_257 = NL + "            if (true) {" + NL + "                throw new RuntimeException(\"This component does not support the option \\\"group element\\\", please remove them from the tree.\");" + NL + "            }";
  protected final String TEXT_258 = NL + NL + "        // create the common tree" + NL + "        mapRootTableToTree(value, jsonTree_";
  protected final String TEXT_259 = ");" + NL;
  protected final String TEXT_260 = NL + "            org.json.simple.JSONArray loopElementRoot = new org.json.simple.JSONArray();" + NL + "            // prepare aggregation";
  protected final String TEXT_261 = NL + "            if (jsonTree_";
  protected final String TEXT_262 = ".containsKey(\"";
  protected final String TEXT_263 = "\")) {" + NL + "                jsonTree_";
  protected final String TEXT_264 = ".get(\"";
  protected final String TEXT_265 = "\").put(\"";
  protected final String TEXT_266 = "\", loopElementRoot);" + NL + "            }" + NL;
  protected final String TEXT_267 = NL + "                loopElementRoot.add(";
  protected final String TEXT_268 = ");";
  protected final String TEXT_269 = NL + "                // aggregate Json field" + NL + "                mapLoopTableToArray(value, loopElementRoot);";
  protected final String TEXT_270 = NL + "                // aggregate JSON object" + NL + "                java.util.HashMap<String, org.json.simple.JSONObject> jsonSubTree = new java.util.HashMap<String, org.json.simple.JSONObject>();" + NL + "                mapLoopTableToTree(value, jsonSubTree);" + NL + "                loopElementRoot.add(jsonSubTree.get(\"";
  protected final String TEXT_271 = "/";
  protected final String TEXT_272 = "\"));";
  protected final String TEXT_273 = NL + "            return jsonTree_";
  protected final String TEXT_274 = ".get(\"/";
  protected final String TEXT_275 = "\").toString().getBytes();";
  protected final String TEXT_276 = NL + "            // Create specifici node for rootTag" + NL + "            org.json.simple.JSONObject jsonRow_";
  protected final String TEXT_277 = " = new org.json.simple.JSONObject();" + NL + "            jsonRow_";
  protected final String TEXT_278 = ".put(\"";
  protected final String TEXT_279 = "\", jsonTree_";
  protected final String TEXT_280 = ".get(\"/";
  protected final String TEXT_281 = "\"));" + NL + "            return jsonRow_";
  protected final String TEXT_282 = ".toString().getBytes();";
  protected final String TEXT_283 = NL + NL + "    } // end convert()  " + NL + "" + NL + "} // end ";
  protected final String TEXT_284 = "_";
  protected final String TEXT_285 = "ToJSONConverter class ";
  protected final String TEXT_286 = NL;
  protected final String TEXT_287 = NL;
  protected final String TEXT_288 = NL + NL + "public static class ";
  protected final String TEXT_289 = "_convertFunction<KEY> implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<KEY, ";
  protected final String TEXT_290 = ">, KEY,";
  protected final String TEXT_291 = "> {" + NL + "\t\t" + NL + "\tprivate ";
  protected final String TEXT_292 = " converter;" + NL + "\t" + NL + "\tpublic ";
  protected final String TEXT_293 = "_convertFunction(JobConf job){" + NL + "\t\tthis.converter = new ";
  protected final String TEXT_294 = "(new ContextProperties(job));" + NL + "\t}" + NL + "\t" + NL + "\tpublic scala.Tuple2<KEY, ";
  protected final String TEXT_295 = "> call(scala.Tuple2<KEY, ";
  protected final String TEXT_296 = "> tuple) {" + NL + "\t\t";
  protected final String TEXT_297 = " record = new ";
  protected final String TEXT_298 = "();" + NL + "\t\ttry {";
  protected final String TEXT_299 = NL + "\t\t\trecord.";
  protected final String TEXT_300 = " = new String(converter.convert(tuple._2()));";
  protected final String TEXT_301 = NL + "\t\t\trecord.";
  protected final String TEXT_302 = " = new String(converter.convert(tuple._2()), ";
  protected final String TEXT_303 = ");";
  protected final String TEXT_304 = NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\trecord.";
  protected final String TEXT_305 = " = null;" + NL + "\t\t}" + NL + "" + NL + "\t\treturn new scala.Tuple2(tuple._1(), record);" + NL + "\t}" + NL + "}";
  protected final String TEXT_306 = NL + "\torg.apache.spark.api.java.JavaPairRDD<NullWritable, ";
  protected final String TEXT_307 = "> rdd_";
  protected final String TEXT_308 = " = rdd_";
  protected final String TEXT_309 = ".mapToPair(new ";
  protected final String TEXT_310 = "_convertFunction(job));";
  protected final String TEXT_311 = NL;
  protected final String TEXT_312 = NL;
  protected final String TEXT_313 = NL + NL + "public static class ";
  protected final String TEXT_314 = "_convertFunction<KEY> implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<KEY, Iterable<";
  protected final String TEXT_315 = ">>, KEY,";
  protected final String TEXT_316 = "> {" + NL + "\t\t" + NL + "\tprivate ";
  protected final String TEXT_317 = " converter;" + NL + "\t" + NL + "\tpublic ";
  protected final String TEXT_318 = "_convertFunction(JobConf job){" + NL + "\t\tthis.converter = new ";
  protected final String TEXT_319 = "(new ContextProperties(job));" + NL + "\t}" + NL + "\t" + NL + "\tpublic scala.Tuple2<KEY, ";
  protected final String TEXT_320 = "> call(scala.Tuple2<KEY, Iterable<";
  protected final String TEXT_321 = ">> tuple) {" + NL + "\t\t";
  protected final String TEXT_322 = " record = new ";
  protected final String TEXT_323 = "();" + NL + "\t\ttry {";
  protected final String TEXT_324 = NL + "\t\t\trecord.";
  protected final String TEXT_325 = " = new String(converter.convert(tuple._2()));";
  protected final String TEXT_326 = NL + "\t\t\trecord.";
  protected final String TEXT_327 = " = new String(converter.convert(tuple._2()), ";
  protected final String TEXT_328 = ");";
  protected final String TEXT_329 = NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\trecord.";
  protected final String TEXT_330 = " = null;" + NL + "\t\t}" + NL + "" + NL + "\t\treturn new scala.Tuple2(tuple._1(), record);" + NL + "\t}" + NL + "}";
  protected final String TEXT_331 = NL + "\torg.apache.spark.api.java.JavaPairRDD<NullWritable, ";
  protected final String TEXT_332 = "> rdd_";
  protected final String TEXT_333 = " = rdd_";
  protected final String TEXT_334 = ".groupByKey().mapToPair(new ";
  protected final String TEXT_335 = "_convertFunction(job));";
  protected final String TEXT_336 = NL + NL;
  protected final String TEXT_337 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();


    stringBuffer.append(TEXT_2);
    
class RowStructToJSONConverterAggregatorHelper {

	private INode node;
	
	private String cid;
	
	private String incomingConnectionTypeName;
	
	private List<IMetadataColumn> inColumns;
	
	public RowStructToJSONConverterAggregatorHelper(INode node) {
		this.node = node;
		cid = node.getUniqueName();
		List<IMetadataColumn> columns = node.getMetadataList().get(0).getListColumns();
		
		for (IConnection in : node.getIncomingConnections()) {
		    if (in.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		        incomingConnectionTypeName = codeGenArgument.getRecordStructName(in);
		        inColumns = in.getMetadataTable().getListColumns();
		        break;
		    }
		}
	}
	
	public String getConverterTypeName() {
		return cid+"_"+incomingConnectionTypeName+"ToJSONConverter";
	}
	
	public void generateConverterCode() {
		String datablockname = ElementParameterParser.getValue(node, "__DATABLOCKNAME__");
		String type = ElementParameterParser.getValue(node, "__TYPE__");

        Boolean removeHeader = ElementParameterParser.getBooleanValue(node, "__REMOVE_HEADER__");
        String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
        boolean isAllowEmpty = ("true").equals(ElementParameterParser.getValue(node, "__CREATE_EMPTY_ELEMENT__"));
        boolean expandEmptyElm = ("true").equals(ElementParameterParser.getValue(node, "__EXPAND_EMPTY_ELM__"));
        String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
        List<Map<String, String>> rootTable = 
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
        List<Map<String, String>> groupTable = 
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
        List<Map<String, String>> loopTable = 
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");

    stringBuffer.append(TEXT_3);
    stringBuffer.append(getConverterTypeName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(getConverterTypeName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
        for (Map<String, String> rootElement: rootTable) {
            String parent = rootElement.get("PATH").substring(0, rootElement.get("PATH").lastIndexOf("/"));
            String nodeName = rootElement.get("PATH").substring(rootElement.get("PATH").lastIndexOf("/") + 1);

            if (!"".equals(rootElement.get("VALUE"))) {
                // fixed value, directly put it as a leaf
                
    stringBuffer.append(TEXT_8);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(rootElement.get("VALUE"));
    stringBuffer.append(TEXT_15);
    
            } else if (("main".equals(rootElement.get("ATTRIBUTE")))
                    || (("branch".equals(rootElement.get("ATTRIBUTE"))) && ("".equals(rootElement.get("COLUMN"))))) { // tree branch
                
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(rootElement.get("PATH"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
            } else if (("branch".equals(rootElement.get("ATTRIBUTE"))) && (!"".equals(rootElement.get("COLUMN")))) { // tree leaf (yeah, I know...)
                
    stringBuffer.append(TEXT_24);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_28);
    
                for(IMetadataColumn column : inColumns){
                    String columnName = column.getLabel();
                    if (!columnName.equals(rootElement.get("COLUMN"))) {
                        continue;
                    }

                    // Retieve input column and put it as output
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                    boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
                    if(!isPrimitive){
                        
    stringBuffer.append(TEXT_29);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_30);
    
                    }
                    if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0){
                            
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_35);
    
                    }else if(javaType == JavaTypesManager.CHARACTER){
                            
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_39);
    
                    }else{
                            
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_43);
    
                    }
                    if(!isPrimitive){
                        
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_46);
    
                    } 
                } // end for(IMetadataColumn column : inColumns)
            } else if ("ns".equals(rootElement.get("ATTRIBUTE"))) { // Not supported
                
    stringBuffer.append(TEXT_47);
    
            } else if ("attri".equals(rootElement.get("ATTRIBUTE"))) { // Not supported
                
    stringBuffer.append(TEXT_48);
    
            } else {
                
    stringBuffer.append(TEXT_49);
    stringBuffer.append(rootElement.get("ATTRIBUTE"));
    stringBuffer.append(TEXT_50);
    
            }
        }// end for (Map<String, String> rootElement: rootTable)
        
    stringBuffer.append(TEXT_51);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
        for (Map<String, String> loopElement: loopTable) {
            String parent = loopElement.get("PATH").substring(0, loopElement.get("PATH").lastIndexOf("/"));
            String nodeName = loopElement.get("PATH").substring(loopElement.get("PATH").lastIndexOf("/") + 1);
            if (!"".equals(loopElement.get("VALUE"))) {
                // fixed value, directly put it as a leaf
                
    stringBuffer.append(TEXT_54);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(loopElement.get("VALUE"));
    stringBuffer.append(TEXT_61);
    
            } else if (("main".equals(loopElement.get("ATTRIBUTE"))) || 
                    (("branch".equals(loopElement.get("ATTRIBUTE"))) && ("".equals(loopElement.get("COLUMN"))))) { // tree branch
                
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(loopElement.get("PATH"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
            } else if (("branch".equals(loopElement.get("ATTRIBUTE"))) && (!"".equals(loopElement.get("COLUMN")))) { // tree leaf (yeah, I know...)
                
    stringBuffer.append(TEXT_70);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_74);
    
                for(IMetadataColumn column : inColumns){
                    String columnName = column.getLabel();
                    if (!columnName.equals(loopElement.get("COLUMN"))) {
                        continue;
                    }

                    // Retieve input column and put it as output
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                    boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
                    if(!isPrimitive){
                        
    stringBuffer.append(TEXT_75);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_76);
    
                    }
                    if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0){
                        
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_81);
    
                    }else if(javaType == JavaTypesManager.CHARACTER){
                        
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_85);
    
                    }else{
                        
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_89);
    
                    }
                    if(!isPrimitive){
                        
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_92);
    
                    } 
                } // end for(IMetadataColumn column : inColumns)
            }  else if ("ns".equals(loopElement.get("ATTRIBUTE"))) { // Not supported
                
    stringBuffer.append(TEXT_93);
    
            } else if ("attri".equals(loopElement.get("ATTRIBUTE"))) { // Not supported
                
    stringBuffer.append(TEXT_94);
    
            } else {
                
    stringBuffer.append(TEXT_95);
    stringBuffer.append(loopElement.get("ATTRIBUTE"));
    stringBuffer.append(TEXT_96);
    
            }
        }// end for (Map<String, String> loopElement: loopTable)
        
    stringBuffer.append(TEXT_97);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_98);
    
        for (Map<String, String> loopElement: loopTable) {
            String parent = loopElement.get("PATH").substring(0, loopElement.get("PATH").lastIndexOf("/"));
            String nodeName = loopElement.get("PATH").substring(loopElement.get("PATH").lastIndexOf("/") + 1);

            // just add the element to the JSONArray
            for(IMetadataColumn column : inColumns){
                String columnName = column.getLabel();
                if (!columnName.equals(loopElement.get("COLUMN"))) {
                    continue;
                }

                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
                if(!isPrimitive){
                    
    stringBuffer.append(TEXT_99);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_100);
    
                }
                if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0){
                    
    stringBuffer.append(TEXT_101);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_103);
    
                }else if(javaType == JavaTypesManager.CHARACTER){
                    
    stringBuffer.append(TEXT_104);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_105);
    
                }else{
                    
    stringBuffer.append(TEXT_106);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_107);
    
                }
                if(!isPrimitive){
                    
    stringBuffer.append(TEXT_108);
    
                } 
            } // end for(IMetadataColumn column : inColumns)
        }// end for (Map<String, String> loopElement: loopTable)
        
    stringBuffer.append(TEXT_109);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
        // get the name of the root
	    String rootName = "rootTag";
        if (rootTable.size() > 0) {
            rootName = rootTable.get(0).get("PATH").substring(rootTable.get(0).get("PATH").lastIndexOf("/") + 1);
        }
        
        if (groupTable.size() > 0) {
            
    stringBuffer.append(TEXT_112);
    
        }
        
    stringBuffer.append(TEXT_113);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    
		if (loopTable.size() > 0) {
		    
    stringBuffer.append(TEXT_117);
    
            String parent = loopTable.get(0).get("PATH").substring(0, loopTable.get(0).get("PATH").lastIndexOf("/"));
            String nodeName = loopTable.get(0).get("PATH").substring(loopTable.get(0).get("PATH").lastIndexOf("/") + 1);
            
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_123);
    
            if ((loopTable.size() == 1) && (!"".equals(loopTable.get(0).get("VALUE")))) {
                // the loop element is the leaf of the three we want to construct an array of field
                // But this is a fixed value, so we directly put it  to the array
                
    stringBuffer.append(TEXT_124);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(loopTable.get(0).get("VALUE"));
    stringBuffer.append(TEXT_126);
    
            } else if ((loopTable.size() == 1) && ("main".equals(loopTable.get(0).get("ATTRIBUTE"))) && (!"".equals(loopTable.get(0).get("COLUMN")))) {
                // the loop element is the leaf of the three we want to construct an array of field
                
    stringBuffer.append(TEXT_127);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_128);
    
            } else {
                // the loop element is a branch of the three we want to construct an array of object
                
    stringBuffer.append(TEXT_129);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_132);
    
            }
	    } // end of if (loopTable.size() > 0) 

        if (removeHeader) {
            
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(rootName);
    stringBuffer.append(TEXT_135);
    
        } else {
            
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(rootName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(rootName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
        }
        
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_145);
    
	} // end generateConverterCode()
} // end class

    stringBuffer.append(TEXT_146);
    stringBuffer.append(TEXT_147);
    
class RowStructToJSONConverterHelper {

    private INode node;
    
    private String cid;
    
    private String incomingConnectionTypeName;
    
    private List<IMetadataColumn> inColumns;
    
    public RowStructToJSONConverterHelper(INode node) {
        this.node = node;
        cid = node.getUniqueName();
        List<IMetadataColumn> columns = node.getMetadataList().get(0).getListColumns();
        
        for (IConnection in : node.getIncomingConnections()) {
            if (in.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                incomingConnectionTypeName = codeGenArgument.getRecordStructName(in);
                inColumns = in.getMetadataTable().getListColumns();
                break;
            }
        }
    }
    
    public String getConverterTypeName() {
        return cid+"_"+incomingConnectionTypeName+"ToJSONConverter";
    }
    
    public void generateConverterCode() {
        String datablockname = ElementParameterParser.getValue(node, "__DATABLOCKNAME__");
        String type = ElementParameterParser.getValue(node, "__TYPE__");

        Boolean removeHeader = ElementParameterParser.getBooleanValue(node, "__REMOVE_HEADER__");
        String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
        boolean isAllowEmpty = ("true").equals(ElementParameterParser.getValue(node, "__CREATE_EMPTY_ELEMENT__"));
        boolean expandEmptyElm = ("true").equals(ElementParameterParser.getValue(node, "__EXPAND_EMPTY_ELM__"));
        String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
        List<Map<String, String>> rootTable = 
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
        List<Map<String, String>> groupTable = 
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
        List<Map<String, String>> loopTable = 
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");

    stringBuffer.append(TEXT_148);
    stringBuffer.append(getConverterTypeName());
    stringBuffer.append(TEXT_149);
    stringBuffer.append(getConverterTypeName());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    
        for (Map<String, String> rootElement: rootTable) {
            String parent = rootElement.get("PATH").substring(0, rootElement.get("PATH").lastIndexOf("/"));
            String nodeName = rootElement.get("PATH").substring(rootElement.get("PATH").lastIndexOf("/") + 1);
            if (!"".equals(rootElement.get("VALUE"))) {
                // fixed value, directly put it as a leaf
                
    stringBuffer.append(TEXT_153);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(rootElement.get("VALUE"));
    stringBuffer.append(TEXT_160);
    
            } else if (("main".equals(rootElement.get("ATTRIBUTE")))
                    || (("branch".equals(rootElement.get("ATTRIBUTE"))) && ("".equals(rootElement.get("COLUMN"))))) { // tree branch
                
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(rootElement.get("PATH"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    
            } else if (("branch".equals(rootElement.get("ATTRIBUTE"))) && (!"".equals(rootElement.get("COLUMN")))) { // tree leaf (yeah, I know...)
                
    stringBuffer.append(TEXT_169);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_173);
    
                for(IMetadataColumn column : inColumns){
                    String columnName = column.getLabel();
                    if (!columnName.equals(rootElement.get("COLUMN"))) {
                        continue;
                    }
                    // Retieve input column and put it as output
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                    boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
                    if(!isPrimitive){
                        
    stringBuffer.append(TEXT_174);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_175);
    
                    }
                    if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0){
                            
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_180);
    
                    }else if(javaType == JavaTypesManager.CHARACTER){
                            
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_184);
    
                    }else{
                            
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_188);
    
                    }
                    if(!isPrimitive){
                        
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_191);
    
                    } 
                } // end for(IMetadataColumn column : inColumns)
            } else if ("ns".equals(rootElement.get("ATTRIBUTE"))) { // Not supported
                
    stringBuffer.append(TEXT_192);
    
            } else if ("attri".equals(rootElement.get("ATTRIBUTE"))) { // Not supported
                
    stringBuffer.append(TEXT_193);
    
            } else {
                
    stringBuffer.append(TEXT_194);
    stringBuffer.append(rootElement.get("ATTRIBUTE"));
    stringBuffer.append(TEXT_195);
    
            }
        }// end for (Map<String, String> rootElement: rootTable)
        
    stringBuffer.append(TEXT_196);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    
        for (Map<String, String> loopElement: loopTable) {
            String parent = loopElement.get("PATH").substring(0, loopElement.get("PATH").lastIndexOf("/"));
            String nodeName = loopElement.get("PATH").substring(loopElement.get("PATH").lastIndexOf("/") + 1);
            if (!"".equals(loopElement.get("VALUE"))) {
                // fixed value, directly put it as a leaf
                
    stringBuffer.append(TEXT_199);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(loopElement.get("VALUE"));
    stringBuffer.append(TEXT_206);
    
            } else if (("main".equals(loopElement.get("ATTRIBUTE"))) || 
                    (("branch".equals(loopElement.get("ATTRIBUTE"))) && ("".equals(loopElement.get("COLUMN"))))) { // tree branch
                
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(loopElement.get("PATH"));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    
            } else if (("branch".equals(loopElement.get("ATTRIBUTE"))) && (!"".equals(loopElement.get("COLUMN")))) { // tree leaf (yeah, I know...)
                
    stringBuffer.append(TEXT_215);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_219);
    
                for(IMetadataColumn column : inColumns){
                    String columnName = column.getLabel();
                    if (!columnName.equals(loopElement.get("COLUMN"))) {
                        continue;
                    }
                    // Retieve input column and put it as output
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                    boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
                    if(!isPrimitive){
                        
    stringBuffer.append(TEXT_220);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_221);
    
                    }
                    if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0){
                            
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_226);
    
                    }else if(javaType == JavaTypesManager.CHARACTER){
                            
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_230);
    
                    }else{
                            
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_234);
    
                    }
                    if(!isPrimitive){
                        
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_237);
    
                    } 
                } // end for(IMetadataColumn column : inColumns)
            }  else if ("ns".equals(loopElement.get("ATTRIBUTE"))) { // Not supported
                
    stringBuffer.append(TEXT_238);
    
            } else if ("attri".equals(loopElement.get("ATTRIBUTE"))) { // Not supported
                
    stringBuffer.append(TEXT_239);
    
            } else {
                
    stringBuffer.append(TEXT_240);
    stringBuffer.append(loopElement.get("ATTRIBUTE"));
    stringBuffer.append(TEXT_241);
    
            }
        }// end for (Map<String, String> loopElement: loopTable)
        
    stringBuffer.append(TEXT_242);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_243);
    
        for (Map<String, String> loopElement: loopTable) {
            String parent = loopElement.get("PATH").substring(0, loopElement.get("PATH").lastIndexOf("/"));
            String nodeName = loopElement.get("PATH").substring(loopElement.get("PATH").lastIndexOf("/") + 1);

            // just add the element to the JSONArray
            for(IMetadataColumn column : inColumns){
                String columnName = column.getLabel();
                if (!columnName.equals(loopElement.get("COLUMN"))) {
                    continue;
                }
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
                if(!isPrimitive){
                    
    stringBuffer.append(TEXT_244);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_245);
    
                }
                if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0){
                    
    stringBuffer.append(TEXT_246);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_248);
    
                }else if(javaType == JavaTypesManager.CHARACTER){
                    
    stringBuffer.append(TEXT_249);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_250);
    
                }else{
                    
    stringBuffer.append(TEXT_251);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_252);
    
                }
                if(!isPrimitive){
                    
    stringBuffer.append(TEXT_253);
    
                } 
            } // end for(IMetadataColumn column : inColumns)
        }// end for (Map<String, String> loopElement: loopTable)
        
    stringBuffer.append(TEXT_254);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    
        // get the name of the root
        String rootName = "rootTag";
        if (rootTable.size() > 0) {
            rootName = rootTable.get(0).get("PATH").substring(rootTable.get(0).get("PATH").lastIndexOf("/") + 1);
        }
        
        if (groupTable.size() > 0) {
            
    stringBuffer.append(TEXT_257);
    
        }
        
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    
        if (loopTable.size() > 0) {
            
    stringBuffer.append(TEXT_260);
    
            String parent = loopTable.get(0).get("PATH").substring(0, loopTable.get(0).get("PATH").lastIndexOf("/"));
            String nodeName = loopTable.get(0).get("PATH").substring(loopTable.get(0).get("PATH").lastIndexOf("/") + 1);
            
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_266);
    

            if ((loopTable.size() == 1) && (!"".equals(loopTable.get(0).get("VALUE")))) {
                // the loop element is the leaf of the three we want to construct an array of field
                // But this is a fixed value, so we directly put it  to the array
                
    stringBuffer.append(TEXT_267);
    stringBuffer.append(loopTable.get(0).get("VALUE"));
    stringBuffer.append(TEXT_268);
    
            } else if ((loopTable.size() == 1) && ("main".equals(loopTable.get(0).get("ATTRIBUTE"))) && (!"".equals(loopTable.get(0).get("COLUMN")))) {
                // the loop element is the leaf of the three we want to construct an array of field
                
    stringBuffer.append(TEXT_269);
    
            } else {
                // the loop element is a branch of the three we want to construct an array of object
                
    stringBuffer.append(TEXT_270);
    stringBuffer.append(parent);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(nodeName);
    stringBuffer.append(TEXT_272);
    
            }
        } // end of if (loopTable.size() > 0) 

        if (removeHeader) {
            
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(rootName);
    stringBuffer.append(TEXT_275);
    
        } else {
            
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(rootName);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(rootName);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    
        }
        
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_285);
    
    } // end generateConverterCode()
} // end class

    stringBuffer.append(TEXT_286);
    stringBuffer.append(TEXT_287);
    
/**
* This is a Javajet helper class meant to generate all Spark functions responsible for serializing rowXStruct objects into byte arrays
* within a Spark Streaming job.
*
* tWriteXXX Spark functions rely on converters to serialize rowStruct into byte arrays accepted by messaging output components.
* These converters are framework undependant : they can be reused with any framework which needs to send messages as byte arrays.
* The type name of the converter to use must be provided via the generateCode() method.
*  
* WARNING : this does not generate the converter code but only the Spark functions one actually. These functions are common between 
* all tWriteXXX components and converters code have to be generated elsewhere beforehand.
*/

class TWriteXXXHelper {

	private INode node;
	
	private IConnection incomingConnection;
	
	private IConnection outgoingConnection;

	public TWriteXXXHelper(INode node) {
		this.node = node;
		this.incomingConnection = findIncomingConnection();
		this.outgoingConnection = findOutgoingConnection();
	}
	
	public void generateCode(String converterTypeName) {
		String cid = node.getUniqueName();

    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(getIncomingConnectionTypeName());
    stringBuffer.append(TEXT_290);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_291);
    stringBuffer.append(converterTypeName);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(converterTypeName);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_295);
    stringBuffer.append(getIncomingConnectionTypeName());
    stringBuffer.append(TEXT_296);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_297);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_298);
    
			if(getEncoding() == null || getEncoding().equals("")) {

    stringBuffer.append(TEXT_299);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_300);
    
			} else {

    stringBuffer.append(TEXT_301);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_302);
    stringBuffer.append(getEncoding());
    stringBuffer.append(TEXT_303);
    
			}

    stringBuffer.append(TEXT_304);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_305);
    
	} // end generateCode()
	
	public void generateConfig() {
		String cid = node.getUniqueName();

    stringBuffer.append(TEXT_306);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_307);
    stringBuffer.append(outgoingConnection.getName());
    stringBuffer.append(TEXT_308);
    stringBuffer.append(incomingConnection.getName());
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    	
	} // end generateConfig()
	
	private IConnection findIncomingConnection() {
		IConnection result = null;
		if (node.getIncomingConnections() != null) {
		    for (IConnection in : node.getIncomingConnections()) {
		        if (in.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		            result = in;
		            break;
		        }
		    }
		}
		return result;
	}

   private IConnection findOutgoingConnection() {
		IConnection result = null;
		if (node.getOutgoingConnections() != null) {
		    for (IConnection in : node.getOutgoingConnections()) {
		        if (in.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		            result = in;
		            break;
		        }
		    }
		}
		return result;
	}
    
   private String getIncomingConnectionTypeName() {
		return codeGenArgument.getRecordStructName(this.incomingConnection);
   }
   
   private String getOutgoingConnectionTypeName() {
		return codeGenArgument.getRecordStructName(this.outgoingConnection);
   }
   
   private String getOutgoingColumnName() {
       return ElementParameterParser.getValue(node, "__JSONFIELD__");
   }
   
   private String getEncoding() {
   	return ElementParameterParser.getValue(node, "__ENCODING__");
   }
    
} // end TWriteXXXHelper class

    stringBuffer.append(TEXT_311);
    stringBuffer.append(TEXT_312);
    
/**
* This is a Javajet helper class meant to generate all Spark functions responsible for serializing rowXStruct objects into byte arrays
* within a Spark Streaming job.
*
* tWriteXXX Spark functions rely on converters to serialize rowStruct into byte arrays accepted by messaging output components.
* These converters are framework undependant : they can be reused with any framework which needs to send messages as byte arrays.
* The type name of the converter to use must be provided via the generateCode() method.
*  
* WARNING : this does not generate the converter code but only the Spark functions one actually. These functions are common between 
* all tWriteXXX components and converters code have to be generated elsewhere beforehand.
*/

class TWriteXXXAggregatorHelper {

	private INode node;
	
	private IConnection incomingConnection;
	
	private IConnection outgoingConnection;

	public TWriteXXXAggregatorHelper(INode node) {
		this.node = node;
		this.incomingConnection = findIncomingConnection();
		this.outgoingConnection = findOutgoingConnection();
	}
	
	public void generateCode(String converterTypeName) {
		String cid = node.getUniqueName();

    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(getIncomingConnectionTypeName());
    stringBuffer.append(TEXT_315);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_316);
    stringBuffer.append(converterTypeName);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(converterTypeName);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_320);
    stringBuffer.append(getIncomingConnectionTypeName());
    stringBuffer.append(TEXT_321);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_322);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_323);
    			
			if(getEncoding() == null || getEncoding().equals("")) {

    stringBuffer.append(TEXT_324);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_325);
    
			} else {

    stringBuffer.append(TEXT_326);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_327);
    stringBuffer.append(getEncoding());
    stringBuffer.append(TEXT_328);
    
			}

    stringBuffer.append(TEXT_329);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_330);
    
	} // end generateCode()
	
	public void generateConfig() {
		String cid = node.getUniqueName();

    stringBuffer.append(TEXT_331);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_332);
    stringBuffer.append(outgoingConnection.getName());
    stringBuffer.append(TEXT_333);
    stringBuffer.append(incomingConnection.getName());
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    	
	} // end generateConfig()
	
	private IConnection findIncomingConnection() {
		IConnection result = null;
		if (node.getIncomingConnections() != null) {
		    for (IConnection in : node.getIncomingConnections()) {
		        if (in.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		            result = in;
		            break;
		        }
		    }
		}
		return result;
	}

   private IConnection findOutgoingConnection() {
		IConnection result = null;
		if (node.getOutgoingConnections() != null) {
		    for (IConnection in : node.getOutgoingConnections()) {
		        if (in.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		            result = in;
		            break;
		        }
		    }
		}
		return result;
	}
    
   private String getIncomingConnectionTypeName() {
		return codeGenArgument.getRecordStructName(this.incomingConnection);
   }
   
   private String getOutgoingConnectionTypeName() {
		return codeGenArgument.getRecordStructName(this.outgoingConnection);
   }
   
   private String getOutgoingColumnName() {
      return ElementParameterParser.getValue(node, "__JSONFIELD__");
   }
   
   private String getEncoding() {
   	return ElementParameterParser.getValue(node, "__ENCODING__");
   }
    
} // end TWriteXXXHelper class

    stringBuffer.append(TEXT_336);
    


List<Map<String, String>> loopTable = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
List<Map<String, String>> groupBys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "GROUPBYS");
if ((loopTable.size() > 0) && (groupBys.size() > 0)) {
    // loop element exist =>  we group by
    RowStructToJSONConverterAggregatorHelper converterAggregatorHelper = new RowStructToJSONConverterAggregatorHelper(node);
    converterAggregatorHelper.generateConverterCode();
    TWriteXXXAggregatorHelper tWriteXXXAggregatorHelper = new TWriteXXXAggregatorHelper(node);
    tWriteXXXAggregatorHelper.generateCode(converterAggregatorHelper.getConverterTypeName());
} else {
    // Flat structure
    RowStructToJSONConverterHelper converterHelper = new RowStructToJSONConverterHelper(node);
    converterHelper.generateConverterCode();
    TWriteXXXHelper tWriteXXXHelper = new TWriteXXXHelper(node);
    tWriteXXXHelper.generateCode(converterHelper.getConverterTypeName());
}


    stringBuffer.append(TEXT_337);
    return stringBuffer.toString();
  }
}
