package org.talend.designer.codegen.translators.data_quality.uniserv;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class TUniservRTPostMainJava
{
  protected static String nl;
  public static synchronized TUniservRTPostMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniservRTPostMainJava result = new TUniservRTPostMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "int myRetCount_";
  protected final String TEXT_2 = " = 0;" + NL + "int myRetType_";
  protected final String TEXT_3 = " = 0;" + NL + "int myRetInfo_";
  protected final String TEXT_4 = " = 0;" + NL + "boolean errorForRejected_";
  protected final String TEXT_5 = " = false;" + NL;
  protected final String TEXT_6 = NL + "WSStatus ws_status_";
  protected final String TEXT_7 = " = (WSStatus)globalMap.get(\"WS_STATUS\");" + NL + "ComponentStatus status_";
  protected final String TEXT_8 = " = null;" + NL + "boolean use_component_status_";
  protected final String TEXT_9 = " = false;" + NL + "boolean is_last_component_";
  protected final String TEXT_10 = " = false;" + NL + "" + NL + "" + NL + "if(ws_status_";
  protected final String TEXT_11 = " != null)" + NL + "{" + NL + "   status_";
  protected final String TEXT_12 = " = ws_status_";
  protected final String TEXT_13 = ".getComponentStatus(\"";
  protected final String TEXT_14 = "\");" + NL + "" + NL + "   if(status_";
  protected final String TEXT_15 = " == null)" + NL + "   {" + NL + "      status_";
  protected final String TEXT_16 = " = new ComponentStatus();" + NL + "      status_";
  protected final String TEXT_17 = ".setComponentName(\"";
  protected final String TEXT_18 = "\");" + NL + "      ws_status_";
  protected final String TEXT_19 = ".getComponentStatusList().add(status_";
  protected final String TEXT_20 = ");" + NL + "      ws_status_";
  protected final String TEXT_21 = ".setLastComponent(\"";
  protected final String TEXT_22 = "\");" + NL + "   }" + NL + "   else" + NL + "   {" + NL + "      use_component_status_";
  protected final String TEXT_23 = " = true;" + NL + "      myRetCount_";
  protected final String TEXT_24 = " = status_";
  protected final String TEXT_25 = ".getOutputConnectionDataCount();" + NL + "      if(ws_status_";
  protected final String TEXT_26 = ".getLastComponent().compareTo(\"";
  protected final String TEXT_27 = "\") == 0)" + NL + "      {" + NL + "         is_last_component_";
  protected final String TEXT_28 = " = true;" + NL + "" + NL + "         /*" + NL + "          * Check if the client has selected an element from the ambiguity list" + NL + "          * then set result count to 1" + NL + "          */" + NL + "         if(globalMap.get(\"WS_SELECTED\") != null)" + NL + "         {" + NL + "            myRetCount_";
  protected final String TEXT_29 = " = 1;" + NL + "         }" + NL + "      }" + NL + "   }" + NL + "}" + NL + "else" + NL + "{" + NL + "     status_";
  protected final String TEXT_30 = " = new ComponentStatus();" + NL + "     status_";
  protected final String TEXT_31 = ".setComponentName(\"";
  protected final String TEXT_32 = "\");" + NL + "}";
  protected final String TEXT_33 = NL + "\tint rejectClass_";
  protected final String TEXT_34 = "=Integer.parseInt(";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "\t\t\t\t\t";
  protected final String TEXT_37 = "=null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_38 = "=new ";
  protected final String TEXT_39 = "Struct();";
  protected final String TEXT_40 = NL + "\t\t\t\t\t";
  protected final String TEXT_41 = "=null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_42 = "=new ";
  protected final String TEXT_43 = "Struct();";
  protected final String TEXT_44 = NL + "\t\t\t\t\t";
  protected final String TEXT_45 = "=null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_46 = "=new ";
  protected final String TEXT_47 = "Struct();";
  protected final String TEXT_48 = NL + "                            if(!use_component_status_";
  protected final String TEXT_49 = ")" + NL + "                            {";
  protected final String TEXT_50 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = "!=null) {postClient_";
  protected final String TEXT_53 = ".setArg(uniserv.cliserv.Post.";
  protected final String TEXT_54 = ",";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = ");}";
  protected final String TEXT_57 = NL + "\t\t\ttry {       " + NL + "\t\t\t\tmyResult_";
  protected final String TEXT_58 = "=postClient_";
  protected final String TEXT_59 = ".execRequest(uniserv.cliserv.Post.CHECK_ADDRESS);" + NL + "            } catch (Exception ex) {" + NL + "                globalMap.put(\"WS_ERROR_CODE\", new Integer(-1));" + NL + "                globalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_60 = "\");" + NL + "                " + NL + "                String msg = ex.getMessage();" + NL + "                if(msg == null) {" + NL + "                   msg = ex.toString();" + NL + "                }" + NL + "                globalMap.put(\"WS_ERROR_MESSAGE\", msg);" + NL + "                        \t" + NL + "                throw new RuntimeException(msg);" + NL + "            }" + NL + "\t\t    myRetType_";
  protected final String TEXT_61 = "=myResult_";
  protected final String TEXT_62 = ".getRetType();" + NL + "\t\t\tmyRetInfo_";
  protected final String TEXT_63 = "=myResult_";
  protected final String TEXT_64 = ".getRetInfo();" + NL + "\t\t\tmyRetCount_";
  protected final String TEXT_65 = "=myResult_";
  protected final String TEXT_66 = ".getRetCount();" + NL + "" + NL + "\t\t\t" + NL + "            if(myRetType_";
  protected final String TEXT_67 = " == uniserv.cliserv.GenClient.UNI_ERR){" + NL + "               switch (myRetInfo_";
  protected final String TEXT_68 = ") {" + NL + "               \tcase 1000: " + NL + "               \tcase 1001:" + NL + "               \tcase 1002:" + NL + "               \tcase 1007:" + NL + "               \tcase 4006:" + NL + "               \tcase 4007:" + NL + "               \tcase 4009:" + NL + "               \tcase 5012:" + NL + "               \tcase 11066:" + NL + "               \tcase 11069:" + NL + "               \tcase 18100:" + NL + "               \tcase 18101:" + NL + "               \tcase 18102:" + NL + "               \tcase 18107:" + NL + "               \tcase 18200:" + NL + "               \tcase 18201:" + NL + "               \tcase 18202:               \t\t\t" + NL + "               \tcase 18207: errorForRejected_";
  protected final String TEXT_69 = " = true;" + NL + "      \t         \t\t   break;" + NL + "               \tdefault: errorForRejected_";
  protected final String TEXT_70 = " = false;" + NL + "               \t         break;" + NL + "               }" + NL + "               " + NL + "                       " + NL + "               StringBuffer error_msg_";
  protected final String TEXT_71 = " = new StringBuffer();" + NL + "               uniserv.cliserv.Uniresult rslt_";
  protected final String TEXT_72 = " = postClient_";
  protected final String TEXT_73 = ".getErrorMsg(myRetType_";
  protected final String TEXT_74 = ", myRetInfo_";
  protected final String TEXT_75 = ", \"E\", error_msg_";
  protected final String TEXT_76 = ");" + NL + "               if(!errorForRejected_";
  protected final String TEXT_77 = "){" + NL + "                 globalMap.put(\"WS_ERROR_CODE\", myRetInfo_";
  protected final String TEXT_78 = ");" + NL + "                 globalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_79 = "\");" + NL + "                 globalMap.put(\"WS_ERROR_MESSAGE\", error_msg_";
  protected final String TEXT_80 = ".toString());" + NL + "                 postClient_";
  protected final String TEXT_81 = ".close();" + NL + "                 throw new RuntimeException(\"Error while executing postal validation, info = \" + myRetInfo_";
  protected final String TEXT_82 = " + \", msg = \" + error_msg_";
  protected final String TEXT_83 = ");" + NL + "               } else {" + NL + "            \t   System.out.println(error_msg_";
  protected final String TEXT_84 = ".toString());" + NL + "               }" + NL + "            }" + NL;
  protected final String TEXT_85 = NL + "                            }";
  protected final String TEXT_86 = NL + "\t\t\t" + NL + "\t\t\tif(errorForRejected_";
  protected final String TEXT_87 = ") {" + NL + "\t\t\t\tmyRetCount_";
  protected final String TEXT_88 = " = 1;" + NL + "\t\t\t}" + NL + "\t\t\tfor(int count_";
  protected final String TEXT_89 = " = 0; count_";
  protected final String TEXT_90 = " < myRetCount_";
  protected final String TEXT_91 = "; count_";
  protected final String TEXT_92 = "++)" + NL + "            {" + NL;
  protected final String TEXT_93 = NL + "                            if(!use_component_status_";
  protected final String TEXT_94 = ")" + NL + "                            {";
  protected final String TEXT_95 = NL + "\t\t\t//if(myRetType_";
  protected final String TEXT_96 = "!=uniserv.cliserv.GenClient.UNI_ERR && myRetType_";
  protected final String TEXT_97 = "!=uniserv.cliserv.GenClient.UNI_BREAK){" + NL + "\t\t\tif( errorForRejected_";
  protected final String TEXT_98 = " ||" + NL + "\t\t\t\t( myRetType_";
  protected final String TEXT_99 = "!=uniserv.cliserv.GenClient.UNI_ERR && myRetType_";
  protected final String TEXT_100 = "!=uniserv.cliserv.GenClient.UNI_BREAK)){\t" + NL + "\t\t\t" + NL + "\t\t\t\tv_";
  protected final String TEXT_101 = ".removeAllElements();";
  protected final String TEXT_102 = NL + "\t\t\t\t\tv_";
  protected final String TEXT_103 = ".addElement(uniserv.cliserv.Post.";
  protected final String TEXT_104 = ");\t" + NL + "\t\t\t\t\tif(errorForRejected_";
  protected final String TEXT_105 = ") {" + NL + "\t\t\t\t\t\th_";
  protected final String TEXT_106 = ".put(uniserv.cliserv.Post.";
  protected final String TEXT_107 = ", \"\");" + NL + "\t\t\t\t\t}" + NL + NL;
  protected final String TEXT_108 = NL + "\t\t\t" + NL + "\t\t\tif(errorForRejected_";
  protected final String TEXT_109 = ") {" + NL + "\t\t\t\th_";
  protected final String TEXT_110 = ".put(uniserv.cliserv.Post.OUT_RES_POST_CL, \"5\");" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\tif(";
  protected final String TEXT_112 = ".";
  protected final String TEXT_113 = " != null) {" + NL + "\t\t\t\t\th_";
  protected final String TEXT_114 = ".put(uniserv.cliserv.Post.";
  protected final String TEXT_115 = ", ";
  protected final String TEXT_116 = ".";
  protected final String TEXT_117 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_118 = NL + "\t\t" + NL + "\t\t\t\t" + NL + "\t\t\t\tswitch (myRetInfo_";
  protected final String TEXT_119 = ") {" + NL + "               \tcase 1000: h_";
  protected final String TEXT_120 = ".put(uniserv.cliserv.Post.OUT_RES_CITY, \"NF\");" + NL + "               \t           break;" + NL + "               \tcase 1001: h_";
  protected final String TEXT_121 = ".put(uniserv.cliserv.Post.OUT_RES_ZIP, \"NF\");" + NL + "    \t           \t\t   break;" + NL + "               \tcase 1002: h_";
  protected final String TEXT_122 = ".put(uniserv.cliserv.Post.OUT_RES_CITY, \"NF\");" + NL + "               \t           h_";
  protected final String TEXT_123 = ".put(uniserv.cliserv.Post.OUT_RES_ZIP, \"NF\");" + NL + "    \t           \t       break;" + NL + "               \tcase 1007: h_";
  protected final String TEXT_124 = ".put(uniserv.cliserv.Post.OUT_RES_CITY, \"NI\");" + NL + "    \t           \t\t   h_";
  protected final String TEXT_125 = ".put(uniserv.cliserv.Post.OUT_RES_ZIP, \"NI\");" + NL + "    \t           \t\t   break;" + NL + "               " + NL + "               \tcase 4009: h_";
  protected final String TEXT_126 = ".put(uniserv.cliserv.Post.OUT_RES_CITY, \"NI\");" + NL + "        \t\t   \t\t   h_";
  protected final String TEXT_127 = ".put(uniserv.cliserv.Post.OUT_RES_ZIP, \"NI\");" + NL + "        \t\t   \t\t   break;" + NL + "               " + NL + "               \tdefault: " + NL + "               \t         break;" + NL + "               }" + NL + "\t\t\t} else {" + NL + "\t\t\t\tpostClient_";
  protected final String TEXT_128 = ".getArg(v_";
  protected final String TEXT_129 = ",h_";
  protected final String TEXT_130 = ");" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t\t" + NL + "\t\t\t" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_131 = "\t\t" + NL + "\t\tif(((String) h_";
  protected final String TEXT_132 = ".get(uniserv.cliserv.Post.OUT_RES_POST_CL)) !=null) {\t" + NL + "\t\t\tif(Integer.parseInt((String)h_";
  protected final String TEXT_133 = ".get(uniserv.cliserv.Post.OUT_RES_POST_CL))>=rejectClass_";
  protected final String TEXT_134 = ") {";
  protected final String TEXT_135 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_136 = ".";
  protected final String TEXT_137 = "=";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = ";";
  protected final String TEXT_140 = NL + "                                                        ByteArrayOutputStream boss_";
  protected final String TEXT_141 = " = new ByteArrayOutputStream();" + NL + "                                                        ObjectOutputStream dos_";
  protected final String TEXT_142 = " = new ObjectOutputStream(boss_";
  protected final String TEXT_143 = ");";
  protected final String TEXT_144 = NL + "                                                        ";
  protected final String TEXT_145 = ".writeData(dos_";
  protected final String TEXT_146 = ");" + NL + "                                                        dos_";
  protected final String TEXT_147 = ".close();" + NL + "                                                        boss_";
  protected final String TEXT_148 = ".close();" + NL + "                                                        status_";
  protected final String TEXT_149 = ".addOutputConnectionData(count_";
  protected final String TEXT_150 = ", \"";
  protected final String TEXT_151 = "\", boss_";
  protected final String TEXT_152 = ".toByteArray());" + NL;
  protected final String TEXT_153 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_154 = "=null;";
  protected final String TEXT_155 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_156 = "=null;";
  protected final String TEXT_157 = NL + "\t\t\t}" + NL + "\t\t\telse {\t";
  protected final String TEXT_158 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_159 = ".";
  protected final String TEXT_160 = "=(String)h_";
  protected final String TEXT_161 = ".get(uniserv.cliserv.Post.";
  protected final String TEXT_162 = ");";
  protected final String TEXT_163 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = "=";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = ";";
  protected final String TEXT_168 = NL + "                                                            ";
  protected final String TEXT_169 = ".OUT_RES_COMPONENT_STATE = \"SERVICE_RESPONSE\";";
  protected final String TEXT_170 = NL + NL + "                                                        ByteArrayOutputStream boss_";
  protected final String TEXT_171 = " = new ByteArrayOutputStream();" + NL + "                                                        ObjectOutputStream dos_";
  protected final String TEXT_172 = " = new ObjectOutputStream(boss_";
  protected final String TEXT_173 = ");";
  protected final String TEXT_174 = NL + "                                                        ";
  protected final String TEXT_175 = ".writeData(dos_";
  protected final String TEXT_176 = ");" + NL + "                                                        dos_";
  protected final String TEXT_177 = ".close();" + NL + "                                                        boss_";
  protected final String TEXT_178 = ".close();" + NL + "                                                        status_";
  protected final String TEXT_179 = ".addOutputConnectionData(count_";
  protected final String TEXT_180 = ", \"";
  protected final String TEXT_181 = "\", boss_";
  protected final String TEXT_182 = ".toByteArray());";
  protected final String TEXT_183 = NL + "\t\t\t\t\t";
  protected final String TEXT_184 = "=null;";
  protected final String TEXT_185 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_186 = NL + "        if(myRetInfo_";
  protected final String TEXT_187 = " != 18022)" + NL + "        {";
  protected final String TEXT_188 = NL + "                ";
  protected final String TEXT_189 = "=null;";
  protected final String TEXT_190 = NL + "         }" + NL + "\t}" + NL + "\t" + NL + "\tif(myRetType_";
  protected final String TEXT_191 = " == uniserv.cliserv.GenClient.UNI_BREAK) {";
  protected final String TEXT_192 = NL + "\t\t\t\t";
  protected final String TEXT_193 = "=null;";
  protected final String TEXT_194 = NL + "\t\t\tif(rejectClass_";
  protected final String TEXT_195 = "<=4) {";
  protected final String TEXT_196 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_197 = ".";
  protected final String TEXT_198 = "=";
  protected final String TEXT_199 = ".";
  protected final String TEXT_200 = ";";
  protected final String TEXT_201 = NL + "                                                        ByteArrayOutputStream boss_";
  protected final String TEXT_202 = " = new ByteArrayOutputStream();" + NL + "                                                        ObjectOutputStream dos_";
  protected final String TEXT_203 = " = new ObjectOutputStream(boss_";
  protected final String TEXT_204 = ");";
  protected final String TEXT_205 = NL + "                                                        ";
  protected final String TEXT_206 = ".writeData(dos_";
  protected final String TEXT_207 = ");" + NL + "                                                        dos_";
  protected final String TEXT_208 = ".close();" + NL + "                                                        boss_";
  protected final String TEXT_209 = ".close();" + NL + "                                                        status_";
  protected final String TEXT_210 = ".addOutputConnectionData(count_";
  protected final String TEXT_211 = ", \"";
  protected final String TEXT_212 = "\", boss_";
  protected final String TEXT_213 = ".toByteArray());" + NL;
  protected final String TEXT_214 = NL + "\t\t\t} else {";
  protected final String TEXT_215 = NL + "\t\t\t\t\t";
  protected final String TEXT_216 = "=null;";
  protected final String TEXT_217 = NL + "\t\tprintWriter_";
  protected final String TEXT_218 = ".print(tos_count_";
  protected final String TEXT_219 = "+1);";
  protected final String TEXT_220 = NL;
  protected final String TEXT_221 = NL + "\t\t\t\t\tprintWriter_";
  protected final String TEXT_222 = ".print(\";\"+";
  protected final String TEXT_223 = ".";
  protected final String TEXT_224 = ");";
  protected final String TEXT_225 = NL + "\t\t\t\tprintWriter_";
  protected final String TEXT_226 = ".println();";
  protected final String TEXT_227 = NL + "\t\tv_";
  protected final String TEXT_228 = ".removeAllElements();" + NL + "" + NL + "\t\tif(myResult_";
  protected final String TEXT_229 = ".getRetInfo()==18022) {";
  protected final String TEXT_230 = NL + "\t\t\t\t\tv_";
  protected final String TEXT_231 = ".addElement(uniserv.cliserv.Post.";
  protected final String TEXT_232 = ");";
  protected final String TEXT_233 = "\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tuniserv.cliserv.Uniresult uniresult_";
  protected final String TEXT_234 = ";" + NL + "" + NL + "\t    uniresult_";
  protected final String TEXT_235 = "=postClient_";
  protected final String TEXT_236 = ".getArg(v_";
  protected final String TEXT_237 = ", h_";
  protected final String TEXT_238 = ", count_";
  protected final String TEXT_239 = ");" + NL + "\t   ";
  protected final String TEXT_240 = NL + "\t\tprintWriter_";
  protected final String TEXT_241 = ".print(tos_count_";
  protected final String TEXT_242 = "+1);";
  protected final String TEXT_243 = NL + NL + "\t\tif(myResult_";
  protected final String TEXT_244 = ".getRetInfo()==18022) {";
  protected final String TEXT_245 = NL + "\t\t\t\tprintWriter_";
  protected final String TEXT_246 = ".print(\";\"+h_";
  protected final String TEXT_247 = ".get(uniserv.cliserv.Post.";
  protected final String TEXT_248 = "));" + NL + "\t\t\t\t";
  protected final String TEXT_249 = "\t" + NL + "\t\t\tprintWriter_";
  protected final String TEXT_250 = ".println();";
  protected final String TEXT_251 = NL + "            if(rejectClass_";
  protected final String TEXT_252 = " >= 4)" + NL + "            {";
  protected final String TEXT_253 = NL + "                          if(";
  protected final String TEXT_254 = " != null)" + NL + "                          {";
  protected final String TEXT_255 = NL + "\t\t\t\t             ";
  protected final String TEXT_256 = ".";
  protected final String TEXT_257 = "=h_";
  protected final String TEXT_258 = ".get(uniserv.cliserv.Post.";
  protected final String TEXT_259 = ");";
  protected final String TEXT_260 = NL + "                                              ByteArrayOutputStream boss_";
  protected final String TEXT_261 = " = new ByteArrayOutputStream();" + NL + "                                              ObjectOutputStream dos_";
  protected final String TEXT_262 = " = new ObjectOutputStream(boss_";
  protected final String TEXT_263 = ");";
  protected final String TEXT_264 = NL + "                                              ";
  protected final String TEXT_265 = ".writeData(dos_";
  protected final String TEXT_266 = ");" + NL + "                                              dos_";
  protected final String TEXT_267 = ".close();" + NL + "                                              boss_";
  protected final String TEXT_268 = ".close();" + NL + "                                              status_";
  protected final String TEXT_269 = ".addOutputConnectionData(count_";
  protected final String TEXT_270 = ", \"";
  protected final String TEXT_271 = "\", boss_";
  protected final String TEXT_272 = ".toByteArray());";
  protected final String TEXT_273 = NL + "                          }";
  protected final String TEXT_274 = NL + "\t\t\t  }" + NL + "\t\t\t  else" + NL + "\t\t\t  {";
  protected final String TEXT_275 = NL + "\t\t\t       ";
  protected final String TEXT_276 = " = null;";
  protected final String TEXT_277 = NL + "\t\t\t  }";
  protected final String TEXT_278 = NL + "        }" + NL + " ";
  protected final String TEXT_279 = NL + "\t\t\t}";
  protected final String TEXT_280 = NL + "\t}" + NL + "\t" + NL + "\tif(myRetType_";
  protected final String TEXT_281 = "==uniserv.cliserv.GenClient.UNI_ERR && !errorForRejected_";
  protected final String TEXT_282 = "){";
  protected final String TEXT_283 = NL + "\t\t\t\t";
  protected final String TEXT_284 = "=null;";
  protected final String TEXT_285 = NL + "\t\t\t\t";
  protected final String TEXT_286 = "=null;";
  protected final String TEXT_287 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_288 = ".";
  protected final String TEXT_289 = "=";
  protected final String TEXT_290 = ".";
  protected final String TEXT_291 = ";";
  protected final String TEXT_292 = NL + "            }";
  protected final String TEXT_293 = NL + "                }" + NL + "                else" + NL + "                {" + NL + "                   Integer selected_index_";
  protected final String TEXT_294 = " = (Integer)globalMap.get(\"WS_SELECTED\");";
  protected final String TEXT_295 = NL + "                      if(ws_status_";
  protected final String TEXT_296 = " != null)" + NL + "                      {" + NL + "                         byte[] conn_data_";
  protected final String TEXT_297 = " = status_";
  protected final String TEXT_298 = ".getOutputConnectionData(count_";
  protected final String TEXT_299 = ", \"";
  protected final String TEXT_300 = "\");" + NL + "        " + NL + "                         if(conn_data_";
  protected final String TEXT_301 = " != null && (!is_last_component_";
  protected final String TEXT_302 = " || selected_index_";
  protected final String TEXT_303 = " == null || selected_index_";
  protected final String TEXT_304 = ".intValue() == 0))" + NL + "                         {" + NL + "                            ByteArrayInputStream biss_";
  protected final String TEXT_305 = " = new ByteArrayInputStream(conn_data_";
  protected final String TEXT_306 = ");" + NL + "                            ObjectInputStream dis_";
  protected final String TEXT_307 = " = new ObjectInputStream(biss_";
  protected final String TEXT_308 = ");";
  protected final String TEXT_309 = NL + "                            ";
  protected final String TEXT_310 = ".readData(dis_";
  protected final String TEXT_311 = ");" + NL + "                            dis_";
  protected final String TEXT_312 = ".close();" + NL + "                            biss_";
  protected final String TEXT_313 = ".close();" + NL;
  protected final String TEXT_314 = NL + "                               ";
  protected final String TEXT_315 = ".OUT_RES_COMPONENT_STATE = \"USER_DECISION_ACCEPTED\";";
  protected final String TEXT_316 = NL + "                         }\t" + NL + "                         else if(is_last_component_";
  protected final String TEXT_317 = " && selected_index_";
  protected final String TEXT_318 = " != null)" + NL + "                         {";
  protected final String TEXT_319 = NL + "                                               ";
  protected final String TEXT_320 = ".";
  protected final String TEXT_321 = " = ";
  protected final String TEXT_322 = ".";
  protected final String TEXT_323 = ";";
  protected final String TEXT_324 = NL + "                                           ";
  protected final String TEXT_325 = ".";
  protected final String TEXT_326 = " = ";
  protected final String TEXT_327 = ".";
  protected final String TEXT_328 = ";";
  protected final String TEXT_329 = NL + "                                 ";
  protected final String TEXT_330 = ".OUT_RES_COMPONENT_STATE = \"USER_DECISION_REJECTED\";";
  protected final String TEXT_331 = NL + "                                  byte[] sel_data_";
  protected final String TEXT_332 = " = status_";
  protected final String TEXT_333 = ".getOutputConnectionData(selected_index_";
  protected final String TEXT_334 = ".intValue(), \"";
  protected final String TEXT_335 = "\");" + NL + "" + NL + "                                  if(sel_data_";
  protected final String TEXT_336 = " != null)" + NL + "                                  {" + NL + "                                       ByteArrayInputStream biss_";
  protected final String TEXT_337 = " = new ByteArrayInputStream(sel_data_";
  protected final String TEXT_338 = ");" + NL + "                                       ObjectInputStream dis_";
  protected final String TEXT_339 = " = new ObjectInputStream(biss_";
  protected final String TEXT_340 = ");";
  protected final String TEXT_341 = NL + "                                       ";
  protected final String TEXT_342 = "Struct ambig_row_";
  protected final String TEXT_343 = " = new ";
  protected final String TEXT_344 = "Struct();" + NL + "                                       ambig_row_";
  protected final String TEXT_345 = ".readData(dis_";
  protected final String TEXT_346 = ");" + NL + "                                       dis_";
  protected final String TEXT_347 = ".close();" + NL + "                                       biss_";
  protected final String TEXT_348 = ".close();" + NL;
  protected final String TEXT_349 = NL + "                                          ";
  protected final String TEXT_350 = ".OUT_RES_COMPONENT_STATE = \"USER_DECISION_ACCEPTED\";";
  protected final String TEXT_351 = NL + "                                                ";
  protected final String TEXT_352 = ".";
  protected final String TEXT_353 = " = ambig_row_";
  protected final String TEXT_354 = ".";
  protected final String TEXT_355 = ";";
  protected final String TEXT_356 = NL + "                                    }";
  protected final String TEXT_357 = NL + NL + "                              ws_status_";
  protected final String TEXT_358 = ".getComponentStatusList().remove(status_";
  protected final String TEXT_359 = ");" + NL + "                              status_";
  protected final String TEXT_360 = " = new ComponentStatus();" + NL + "                              status_";
  protected final String TEXT_361 = ".setComponentName(\"";
  protected final String TEXT_362 = "\");" + NL + "                              ws_status_";
  protected final String TEXT_363 = ".getComponentStatusList().add(status_";
  protected final String TEXT_364 = ");" + NL + "" + NL + "                              ByteArrayOutputStream boss_";
  protected final String TEXT_365 = " = new ByteArrayOutputStream();" + NL + "                              ObjectOutputStream dos_";
  protected final String TEXT_366 = " = new ObjectOutputStream(boss_";
  protected final String TEXT_367 = ");";
  protected final String TEXT_368 = NL + "                              ";
  protected final String TEXT_369 = ".writeData(dos_";
  protected final String TEXT_370 = ");" + NL + "                              dos_";
  protected final String TEXT_371 = ".close();" + NL + "                              boss_";
  protected final String TEXT_372 = ".close();" + NL + "                              status_";
  protected final String TEXT_373 = ".addOutputConnectionData(count_";
  protected final String TEXT_374 = ", \"";
  protected final String TEXT_375 = "\", boss_";
  protected final String TEXT_376 = ".toByteArray());" + NL + "                         }" + NL + "                         else" + NL + "                         {";
  protected final String TEXT_377 = NL + "                             ";
  protected final String TEXT_378 = " = null;" + NL + "                         }" + NL + "                      }";
  protected final String TEXT_379 = NL + NL + "                " + NL + "                if(!is_last_component_";
  protected final String TEXT_380 = " || globalMap.get(\"WS_SELECTED\") == null)" + NL + "                {" + NL;
  protected final String TEXT_381 = NL + "                         if(ws_status_";
  protected final String TEXT_382 = " != null)" + NL + "                         {" + NL + "                             byte[] conn_data_ambig_";
  protected final String TEXT_383 = " = status_";
  protected final String TEXT_384 = ".getOutputConnectionData(count_";
  protected final String TEXT_385 = ", \"";
  protected final String TEXT_386 = "\");" + NL + "        " + NL + "                             if(conn_data_ambig_";
  protected final String TEXT_387 = " != null)" + NL + "                             {" + NL + "                                ByteArrayInputStream biss_";
  protected final String TEXT_388 = " = new ByteArrayInputStream(conn_data_ambig_";
  protected final String TEXT_389 = ");" + NL + "                                ObjectInputStream dis_";
  protected final String TEXT_390 = " = new ObjectInputStream(biss_";
  protected final String TEXT_391 = ");";
  protected final String TEXT_392 = NL + "                                ";
  protected final String TEXT_393 = ".readData(dis_";
  protected final String TEXT_394 = ");" + NL + "                                dis_";
  protected final String TEXT_395 = ".close();" + NL + "                                biss_";
  protected final String TEXT_396 = ".close();" + NL + "                                " + NL + "                             }\t" + NL + "                             else" + NL + "                             {";
  protected final String TEXT_397 = NL + "                                ";
  protected final String TEXT_398 = " = null;" + NL + "                             }" + NL + "                         }";
  protected final String TEXT_399 = NL + "                }" + NL + "                else" + NL + "                {";
  protected final String TEXT_400 = "  ";
  protected final String TEXT_401 = NL + "                           ";
  protected final String TEXT_402 = " = null;";
  protected final String TEXT_403 = NL + "                }";
  protected final String TEXT_404 = NL + "                      if(ws_status_";
  protected final String TEXT_405 = " != null)" + NL + "                      {" + NL + "                         byte[] conn_data_";
  protected final String TEXT_406 = " = status_";
  protected final String TEXT_407 = ".getOutputConnectionData(count_";
  protected final String TEXT_408 = ", \"";
  protected final String TEXT_409 = "\");" + NL + "        " + NL + "                         if(conn_data_";
  protected final String TEXT_410 = " != null)" + NL + "                         {" + NL + "                            ByteArrayInputStream biss_";
  protected final String TEXT_411 = " = new ByteArrayInputStream(conn_data_";
  protected final String TEXT_412 = ");" + NL + "                            ObjectInputStream dis_";
  protected final String TEXT_413 = " = new ObjectInputStream(biss_";
  protected final String TEXT_414 = ");";
  protected final String TEXT_415 = NL + "                            ";
  protected final String TEXT_416 = ".readData(dis_";
  protected final String TEXT_417 = ");" + NL + "                            dis_";
  protected final String TEXT_418 = ".close();" + NL + "                            biss_";
  protected final String TEXT_419 = ".close();" + NL + "                         }\t" + NL + "                         else" + NL + "                         {";
  protected final String TEXT_420 = NL + "                            ";
  protected final String TEXT_421 = " = null;" + NL + "                         }" + NL + "                      }";
  protected final String TEXT_422 = "\t\t\t\t" + NL + "\t       }\t";
  protected final String TEXT_423 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String hasRejects = ElementParameterParser.getValue(node, "__USE_REJECTS__");
String rejectClass = ElementParameterParser.getValue(node, "__REJECTS_CLASS__");
String use_file_ambig = ElementParameterParser.getValue(node, "__USE_FILE_AMBIGUOUS__");


List<Map<String, String>> listTableCols_18022 = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__TABLE_18022__");

List<String> UniservOutput=new ArrayList<String>();
UniservOutput.add("OUT_COUNTRY");
UniservOutput.add("OUT_ZIP");
UniservOutput.add("OUT_CITY");
UniservOutput.add("OUT_COUNTRY_FULL");
UniservOutput.add("OUT_COUNTRY_ISO_2");
UniservOutput.add("OUT_COUNTRY_ISO_AL");
UniservOutput.add("OUT_COUNTRY_ISO_NO");
UniservOutput.add("OUT_CAR_REG");
UniservOutput.add("OUT_ZIP_ADD_ON");
UniservOutput.add("OUT_MAX_ZIP");
UniservOutput.add("OUT_MIN_ZIP");
UniservOutput.add("OUT_ZIP_TYPE");
UniservOutput.add("OUT_ZIP_SCHEME");
UniservOutput.add("OUT_ZIP_RANGE");
UniservOutput.add("OUT_REGION");
UniservOutput.add("OUT_STATE");
UniservOutput.add("OUT_STATE_FULL");
UniservOutput.add("OUT_DEP_DISTRICT");
UniservOutput.add("OUT_DISTRICT");
UniservOutput.add("OUT_DISTRICT_CODE");
UniservOutput.add("OUT_DISTR_PRINT");
UniservOutput.add("OUT_COUNTY");
UniservOutput.add("OUT_NIELSEN");
UniservOutput.add("OUT_AREA_CENSAL");
UniservOutput.add("OUT_FREGUESI");
UniservOutput.add("OUT_FREGUESI_CODE");
UniservOutput.add("OUT_CITY");
UniservOutput.add("OUT_STR_HNO");
UniservOutput.add("OUT_RES_POST_CL");
UniservOutput.add("OUT_ALTERNATIVE_CITY");
UniservOutput.add("OUT_FORMER_CITY");
UniservOutput.add("OUT_CITY_ABBREV");
UniservOutput.add("OUT_CITY_SUFFIX");
UniservOutput.add("OUT_CITY_NORM");
UniservOutput.add("OUT_CITY_CODE");
UniservOutput.add("OUT_CITY_DETAIL");
UniservOutput.add("OUT_CITY_VIABLE");
UniservOutput.add("OUT_COMMUNITY");
UniservOutput.add("OUT_COMMUNITY_CODE");
UniservOutput.add("OUT_CITY_ADMIN_CODE");
UniservOutput.add("OUT_CITY_DEL_IND");
UniservOutput.add("OUT_CITY_DISTRICT");
UniservOutput.add("OUT_CITY_DISTRICT_CODE");
UniservOutput.add("OUT_CITY_REGION");
UniservOutput.add("OUT_IC_ARRD");
UniservOutput.add("OUT_IC_ADR");
UniservOutput.add("OUT_MVAL_CITY");
UniservOutput.add("OUT_STR_HNO");
UniservOutput.add("OUT_STR");
UniservOutput.add("OUT_ALTERNATIVE_STR");
UniservOutput.add("OUT_FORMER_STR");
UniservOutput.add("OUT_STR_ABBREV");
UniservOutput.add("OUT_MAJOR_STR");
UniservOutput.add("OUT_STR_TYPE");
UniservOutput.add("OUT_STR_AMBIG");
UniservOutput.add("OUT_STR_NAME_CHANGE");
UniservOutput.add("OUT_STR_SUBDIV");
UniservOutput.add("OUT_PREDIR_STR");
UniservOutput.add("OUT_STR_KERNEL");
UniservOutput.add("OUT_STR_POSTDIR");
UniservOutput.add("OUT_STR_ZIP");
UniservOutput.add("OUT_STR_LANG_CODE");
UniservOutput.add("OUT_STR_COUNT");
UniservOutput.add("OUT_MVAL_STR");
UniservOutput.add("OUT_HNO");
UniservOutput.add("OUT_HNO_MATCH");
UniservOutput.add("OUT_HNO_TO");
UniservOutput.add("OUT_HNO_TO_AL");
UniservOutput.add("OUT_HNO_FROM");
UniservOutput.add("OUT_HNO_FROM_AL");
UniservOutput.add("OUT_HNO_RANGE");
UniservOutput.add("OUT_HNO_EVEN");
UniservOutput.add("OUT_HNO_RISTANTI");
UniservOutput.add("OUT_HNO_POS");
UniservOutput.add("OUT_HNO_NUM");
UniservOutput.add("OUT_HNO_NORM");
UniservOutput.add("OUT_SEC");
UniservOutput.add("OUT_SEC_TYP_FULL");
UniservOutput.add("OUT_SEC_TO");
UniservOutput.add("OUT_SEC_FROM");
UniservOutput.add("OUT_SEC_EVEN");
UniservOutput.add("OUT_HNO_ADDITION");
UniservOutput.add("OUT_BUILDING_NAME");
UniservOutput.add("OUT_BUILDING_TYPE");
UniservOutput.add("OUT_SUB_BUILD_NAME");
UniservOutput.add("OUT_ORGANISATION");
UniservOutput.add("OUT_MVAL_ORGANISATION");
UniservOutput.add("OUT_FLOOR_NO");
UniservOutput.add("OUT_HNO_ZIP");
UniservOutput.add("OUT_FLOOR_ZIP");
UniservOutput.add("OUT_BUILDING_ZIP");
UniservOutput.add("OUT_HNO_CITY_DISTRICT");
UniservOutput.add("OUT_HNO_CITY_CODE");
UniservOutput.add("OUT_DPV_VALID");
UniservOutput.add("OUT_DPV_ETC");
UniservOutput.add("OUT_RDI");
UniservOutput.add("OUT_POBOX_ZIP");
UniservOutput.add("OUT_POBOX_CITY");
UniservOutput.add("OUT_POBOX_NO");
UniservOutput.add("OUT_SPEC_ZIP");
UniservOutput.add("OUT_SPEC_CITY");
UniservOutput.add("OUT_SPEC_IC_CITY");
UniservOutput.add("OUT_LINE_1");
UniservOutput.add("OUT_LINE_2");
UniservOutput.add("OUT_LINE_3");
UniservOutput.add("OUT_LINE_4");
UniservOutput.add("OUT_LINE_5");
UniservOutput.add("OUT_LINE_6");
UniservOutput.add("OUT_RES_POST_CL");
UniservOutput.add("OUT_RES_GCS_CL");
UniservOutput.add("OUT_RES_POST_FIELD");
UniservOutput.add("OUT_RES_CHANGE");
UniservOutput.add("OUT_RES_ABBREV");
UniservOutput.add("OUT_RES_ZIP");
UniservOutput.add("OUT_RES_ZIP_ADD_ON");
UniservOutput.add("OUT_RES_REGION");
UniservOutput.add("OUT_RES_CITY_DISTRICT");
UniservOutput.add("OUT_RES_DEP_DISTRICT");
UniservOutput.add("OUT_RES_CITY");
UniservOutput.add("OUT_RES_STR");
UniservOutput.add("OUT_RES_REF");
UniservOutput.add("OUT_RES_HNO");
UniservOutput.add("OUT_RES_ORGANISATION");
UniservOutput.add("OUT_RES_SEC");
UniservOutput.add("OUT_RES_BUILD_NAME");
UniservOutput.add("OUT_RES_SUB_BUILD_NAME");
UniservOutput.add("OUT_RES_POBOX_CL");
UniservOutput.add("OUT_RES_POBOX");
UniservOutput.add("OUT_RES_POBOX_ZIP");
UniservOutput.add("OUT_RES_POBOX_CITY");
UniservOutput.add("OUT_RES_SPEC_CL");
UniservOutput.add("OUT_RES_SPEC_CITY");
UniservOutput.add("OUT_RES_SPEC_ZIP");
UniservOutput.add("OUT_CARRIER_ROUTE");
UniservOutput.add("OUT_CARRIER_SORT_IND");
UniservOutput.add("OUT_FINANCE_NO");
UniservOutput.add("OUT_GEN_DELIVERY");
UniservOutput.add("OUT_GENERATION");
UniservOutput.add("OUT_EXPIRE_DAYS");
UniservOutput.add("OUT_LANG_CODE");
UniservOutput.add("OUT_SERVICE");


List<String> UniservInput=new ArrayList<String>();
UniservInput.add("IN_COUNTRY");
UniservInput.add("IN_ZIP");
UniservInput.add("IN_ZIP_ADD_ON");
UniservInput.add("IN_STATE");
UniservInput.add("IN_CITY");
UniservInput.add("IN_DISTRICT");
UniservInput.add("IN_CITY_DISTRICT");
UniservInput.add("IN_STR_HNO");
UniservInput.add("IN_STR");
UniservInput.add("IN_MAJOR_STR");
UniservInput.add("IN_HNO");
UniservInput.add("IN_SEC");
UniservInput.add("IN_BUILD_NAME");
UniservInput.add("IN_SUB_BUILD_NAME");
UniservInput.add("IN_ORGANISATION");
UniservInput.add("IN_POBOX_COUNTRY");
UniservInput.add("IN_POBOX_ZIP");
UniservInput.add("IN_POBOX_CITY");
UniservInput.add("IN_POBOX_NO");
UniservInput.add("IN_SPEC_COUNTRY");
UniservInput.add("IN_SPEC_CITY");
UniservInput.add("IN_SPEC_ZIP");
UniservInput.add("IN_LINE_1");
UniservInput.add("IN_LINE_2");
UniservInput.add("IN_LINE_3");
UniservInput.add("IN_LINE_4");
UniservInput.add("IN_LINE_5");
UniservInput.add("IN_LINE_6");
UniservInput.add("IN_LINE_7");
UniservInput.add("IN_SELECT_CONTROL");
UniservInput.add("IN_STATUS");


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    

boolean has_out_res_component_state = false;
IProcess process = node.getProcess();
List<INode> tRTOutputList = (List<INode>)process.getNodesOfType("tRTOutput");



if(tRTOutputList != null && tRTOutputList.size() > 0)
{  

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
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
    
}


if("true".equals(hasRejects)) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(rejectClass);
    stringBuffer.append(TEXT_35);
    
}

String incomingConn="";
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(1);
	IMetadataTable inputMetadata = metadatas.get(0);
	if (metadata!=null) {
		List< ? extends IConnection> conns = node.getIncomingConnections();
		List< ? extends IConnection> conns_out = node.getOutgoingConnections();
		List<? extends IConnection> connsOut = node.getOutgoingConnections("OUTPUT");
		List<? extends IConnection> connsReject = node.getOutgoingConnections("REJECT");
		List<? extends IConnection> conns18022 = node.getOutgoingConnections("SCHEMA_18022");

		for (IConnection conn : conns) {
			incomingConn=conn.getName();
			List<IMetadataColumn> columns = metadata.getListColumns();
        	int sizeColumns = columns.size(); 
			if(connsOut!=null) {
				for(IConnection conn_o:connsOut) {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(conn_o.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(conn_o.getName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(conn_o.getName());
    stringBuffer.append(TEXT_39);
    
				}
			}
			
			if(connsReject!=null) {
				for(IConnection conn_rej:connsReject) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(conn_rej.getName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(conn_rej.getName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(conn_rej.getName());
    stringBuffer.append(TEXT_43);
    
				}
			}
			
			if(conns18022!=null) {
				for(IConnection conn_amb:conns18022) {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(conn_amb.getName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(conn_amb.getName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn_amb.getName());
    stringBuffer.append(TEXT_47);
    
				}
			}
			

                        if(tRTOutputList != null && tRTOutputList.size() > 0)
                        {  

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
                        }

			metadata = metadatas.get(0);
			columns = metadata.getListColumns();
			sizeColumns = columns.size();
			for (int j = 0; j < sizeColumns; j++) {
				if(UniservInput.contains(columns.get(j).getLabel())) {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(columns.get(j).getLabel());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(columns.get(j).getLabel());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(columns.get(j).getLabel());
    stringBuffer.append(TEXT_56);
    
				}
			}

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
    
                        if(tRTOutputList != null && tRTOutputList.size() > 0)
                        {  

    stringBuffer.append(TEXT_85);
    
                        }

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
    
                        if(tRTOutputList != null && tRTOutputList.size() > 0)
                        {  

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
                        }

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
			metadata = metadatas.get(1);
			columns = metadata.getListColumns();
			sizeColumns = columns.size();
			for (int i = 0; i < sizeColumns; i++) {
                                if(columns.get(i).getLabel().compareTo("OUT_RES_COMPONENT_STATE") == 0)
                                {
                                    has_out_res_component_state = true;
                                }

				if(UniservOutput.contains(columns.get(i).getLabel())) {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_107);
    
				}
			}

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
				List<IMetadataColumn> inputColumns = inputMetadata.getListColumns();
				for(IMetadataColumn inputColumn : inputColumns) {
					String inputColumnName = inputColumn.getLabel();
					String outputColumnName = "";
					if("IN_SPEC_COUNTRY".equals(inputColumnName) 
							|| "IN_POBOX_COUNTRY".equals(inputColumnName)
							|| "IN_GEOCODING".equals(inputColumnName)
							|| "IN_SELECT_CONTROL".equals(inputColumnName)
							|| "IN_STATUS".equals(inputColumnName)
							) {
						continue;
					}
					if("IN_BUILDING_NAME".equals(inputColumnName)) {
						outputColumnName = "OUT_BUILD_NAME";
					} else {
						outputColumnName = inputColumnName.replace("IN_", "OUT_");
					}
				
					
					if(UniservOutput.contains(outputColumnName)) {
				
    stringBuffer.append(TEXT_111);
    stringBuffer.append(incomingConn);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(inputColumnName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(outputColumnName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(incomingConn);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(inputColumnName);
    stringBuffer.append(TEXT_117);
    
					} 
			    }
				
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
    
		}
		if("true".equals(hasRejects)) {

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
				metadata = metadatas.get(2);
				List<IMetadataColumn> columns_rej = metadata.getListColumns();
				int sizeColumns = columns_rej.size();
				if(connsReject!=null) {
					for(IConnection conn_rej:connsReject) {
						for (int j = 0; j < sizeColumns; j++) {

    stringBuffer.append(TEXT_135);
    stringBuffer.append(conn_rej.getName());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(columns_rej.get(j).getLabel());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(incomingConn);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(columns_rej.get(j).getLabel());
    stringBuffer.append(TEXT_139);
    
						}

                                                if(tRTOutputList != null && tRTOutputList.size() > 0)
                                                {  

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(conn_rej.getName());
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
    stringBuffer.append(conn_rej.getName());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    
                                                }
					}
				}
				if(connsOut!=null) {
					for(IConnection conn_out:connsOut) {

    stringBuffer.append(TEXT_153);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_154);
    
					}
				}
				if(conns18022!=null) {
					for(IConnection conn_amb:conns18022) {

    stringBuffer.append(TEXT_155);
    stringBuffer.append(conn_amb.getName());
    stringBuffer.append(TEXT_156);
    
					}
				}

    stringBuffer.append(TEXT_157);
    
		}
				metadata = metadatas.get(1);
				List<IMetadataColumn> columns_out = metadata.getListColumns();
				int sizeColumns = columns_out.size();
				if(connsOut!=null) {
					for(IConnection conn_out:connsOut) {
						for (int j = 0; j < sizeColumns; j++) {
                                                       /*
                                                        * special case, OUT_RES_COMPONENT_STATE is part of the output schema
                                                        * but it is not an output arg
                                                        */
                                                       if(columns_out.get(j).getLabel().compareTo("OUT_RES_COMPONENT_STATE") != 0) {
							    if(UniservOutput.contains(columns_out.get(j).getLabel())) {

    stringBuffer.append(TEXT_158);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_159);
    stringBuffer.append(columns_out.get(j).getLabel());
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(columns_out.get(j).getLabel());
    stringBuffer.append(TEXT_162);
    
							    } else {

    stringBuffer.append(TEXT_163);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_164);
    stringBuffer.append(columns_out.get(j).getLabel());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(incomingConn);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(columns_out.get(j).getLabel());
    stringBuffer.append(TEXT_167);
    
							    }
                                                       }
						}

                                                if(tRTOutputList != null && tRTOutputList.size() > 0)
                                                {  
                                                        if(has_out_res_component_state)
                                                        {

    stringBuffer.append(TEXT_168);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_169);
    

                                                        }

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(conn_out.getName());
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
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
                                                }
					}
				}
		if("true".equals(hasRejects)) {
			if(connsReject!=null) {
				for(IConnection conn_rej:connsReject) {

    stringBuffer.append(TEXT_183);
    stringBuffer.append(conn_rej.getName());
    stringBuffer.append(TEXT_184);
    
				}
			}

    stringBuffer.append(TEXT_185);
    		
		}	

    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    
            if(conns18022!=null) {
			     for(IConnection conn_o:conns18022) {

    stringBuffer.append(TEXT_188);
    stringBuffer.append(conn_o.getName());
    stringBuffer.append(TEXT_189);
    
			    }
		    }

    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    
		if(connsOut!=null) {
			for(IConnection conn_o:connsOut) {

    stringBuffer.append(TEXT_192);
    stringBuffer.append(conn_o.getName());
    stringBuffer.append(TEXT_193);
    
			}
		}
		if("true".equals(hasRejects)) {

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    			
				metadata = metadatas.get(2);
				List<IMetadataColumn> columns_rej = metadata.getListColumns();
				sizeColumns = columns_rej.size();
				if(connsReject!=null) {
					for(IConnection conn_rej:connsReject) {
						for (int j = 0; j < sizeColumns; j++) {

    stringBuffer.append(TEXT_196);
    stringBuffer.append(conn_rej.getName());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(columns_rej.get(j).getLabel());
    stringBuffer.append(TEXT_198);
    stringBuffer.append(incomingConn);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(columns_rej.get(j).getLabel());
    stringBuffer.append(TEXT_200);
    

						}

                                                if(tRTOutputList != null && tRTOutputList.size() > 0)
                                                {  

    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(conn_rej.getName());
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
    stringBuffer.append(conn_rej.getName());
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
                                                }
					}
				}

    stringBuffer.append(TEXT_214);
    		
		}
		if(connsReject!=null) {
				for(IConnection conn_rej:connsReject) {

    stringBuffer.append(TEXT_215);
    stringBuffer.append(conn_rej.getName());
    stringBuffer.append(TEXT_216);
    
				}
			}

    
	    if(conns!=null && ("true".equals(use_file_ambig)))
        {

    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
        }

    stringBuffer.append(TEXT_220);
    
		if(conns!=null && ("true".equals(use_file_ambig)))
        {
			for (IConnection conn : conns) {
				metadata = metadatas.get(0);
				List<IMetadataColumn> columns = metadata.getListColumns();
				sizeColumns = columns.size();
				for (int j = 0; j < sizeColumns; j++) {

    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_223);
    stringBuffer.append(columns.get(j).getLabel());
    stringBuffer.append(TEXT_224);
    
				}

    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    
			}
		}

    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    
			metadata = metadatas.get(3);
			List<IMetadataColumn> columns_amb_18022 = metadata.getListColumns();
			sizeColumns = columns_amb_18022.size();
			for (int j = 0; j < 40; j++) {
				Map<String, String> checkedColumn = listTableCols_18022.get(j);
				

    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(columns_amb_18022.get(j).getLabel());
    stringBuffer.append(TEXT_232);
    
				
			}

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
    
	    if(conns!=null && ("true".equals(use_file_ambig)))
        {

    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    }
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    
        if("true".equals(use_file_ambig))
        {
			metadata = metadatas.get(3);
			columns_amb_18022 = metadata.getListColumns();
			sizeColumns = columns_amb_18022.size();
			for (int j = 0; j < 40; j++) {
				Map<String, String> checkedColumn = listTableCols_18022.get(j);
				if("true".equals(checkedColumn.get("USE_IT"))) { 

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(columns_amb_18022.get(j).getLabel());
    stringBuffer.append(TEXT_248);
    
				}	
			}

    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    
        }    
        if("true".equals(hasRejects)) {

    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    
            }
		        metadata = metadatas.get(3);
				columns_amb_18022 = metadata.getListColumns();
				sizeColumns = columns_amb_18022.size();
				if(conns18022!=null) {
				    for(IConnection conn:conns18022) {

    stringBuffer.append(TEXT_253);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_254);
    
					  for (int j = 0; j < sizeColumns; j++) {

    stringBuffer.append(TEXT_255);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_256);
    stringBuffer.append(columns_amb_18022.get(j).getLabel());
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(columns_amb_18022.get(j).getLabel());
    stringBuffer.append(TEXT_259);
    
	     				  }

                                          if(tRTOutputList != null && tRTOutputList.size() > 0)
                                          {  

    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    
                                          }

    stringBuffer.append(TEXT_273);
    
	     	         }
			  }
		      if("true".equals(hasRejects)) {

    stringBuffer.append(TEXT_274);
    
              if(conns18022!=null) {
				  for(IConnection conn:conns18022) {

    stringBuffer.append(TEXT_275);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_276);
    
                    }
              }

    stringBuffer.append(TEXT_277);
    
              }

    stringBuffer.append(TEXT_278);
    
		if("true".equals(hasRejects)) {

    stringBuffer.append(TEXT_279);
    
		}

    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    
		if(connsOut!=null) {
			for(IConnection conn_o:connsOut) {

    stringBuffer.append(TEXT_283);
    stringBuffer.append(conn_o.getName());
    stringBuffer.append(TEXT_284);
    
			}
		}
		
		if(conns18022!=null) {
			for(IConnection conn_o:conns18022) {

    stringBuffer.append(TEXT_285);
    stringBuffer.append(conn_o.getName());
    stringBuffer.append(TEXT_286);
    
			}
		}
		
		if("true".equals(hasRejects)) {
			metadata = metadatas.get(2);
			List<IMetadataColumn> columns_rej = metadata.getListColumns();
			sizeColumns = columns_rej.size();
			if(connsReject!=null) {
				for(IConnection conn_rej:connsReject) {
					for (int j = 0; j < sizeColumns; j++) {

    stringBuffer.append(TEXT_287);
    stringBuffer.append(conn_rej.getName());
    stringBuffer.append(TEXT_288);
    stringBuffer.append(columns_rej.get(j).getLabel());
    stringBuffer.append(TEXT_289);
    stringBuffer.append(incomingConn);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(columns_rej.get(j).getLabel());
    stringBuffer.append(TEXT_291);
    
					}
				}
			}
		} 		

    stringBuffer.append(TEXT_292);
    

            if(tRTOutputList != null && tRTOutputList.size() > 0)
            { 

    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    
                if(connsOut != null)
                {
                   for(IConnection conn_out : connsOut) 
                   {

    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    
                            if(has_out_res_component_state)
                            {

    stringBuffer.append(TEXT_314);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_315);
    
                            }

    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
     
                              metadata = metadatas.get(3);
			      java.util.List<IMetadataColumn> columns_ambig = metadata.getListColumns();
			      int sizeColumns_ambig = columns_ambig.size();
		              				
                              metadata = metadatas.get(1);
			      columns_out = metadata.getListColumns();
			      sizeColumns = columns_out.size();

                              metadata = metadatas.get(0);
			      List<IMetadataColumn> columns_inp = metadata.getListColumns();
			      int sizeColumns_inp = columns_inp.size();

                              IConnection first_inp_conn = conns.get(0);
                              if(first_inp_conn != null)
                              {
                                  for (int j = 0; j < sizeColumns; j++) 
                                  { 
                                       for (int k = 0; k < sizeColumns_inp; k++) 
                                       {
                                           if(columns_out.get(j).getLabel().compareTo(columns_inp.get(k).getLabel()) == 0)
                                           {                                        

    stringBuffer.append(TEXT_319);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_320);
    stringBuffer.append(columns_out.get(j).getLabel());
    stringBuffer.append(TEXT_321);
    stringBuffer.append(first_inp_conn.getName());
    stringBuffer.append(TEXT_322);
    stringBuffer.append(columns_out.get(j).getLabel());
    stringBuffer.append(TEXT_323);
    
                                            }
                                        }
                                   }
                              }


                              for (int j = 0; j < sizeColumns; j++) 
                              { 
                                  for (int k = 0; k < sizeColumns_inp; k++) 
                                  {
                                       if(columns_out.get(j).getLabel().substring(3).compareTo(columns_inp.get(k).getLabel().substring(2)) == 0)
                                       {                                        

    stringBuffer.append(TEXT_324);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_325);
    stringBuffer.append(columns_out.get(j).getLabel());
    stringBuffer.append(TEXT_326);
    stringBuffer.append(first_inp_conn.getName());
    stringBuffer.append(TEXT_327);
    stringBuffer.append(columns_inp.get(k).getLabel());
    stringBuffer.append(TEXT_328);
    
                                       }
                                  }
                              }

                              if(has_out_res_component_state)
                              {

    stringBuffer.append(TEXT_329);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_330);
    
                              }

                              IConnection first_ambig_conn = null;
                              if (conns18022 != null && conns18022.size() >0) {
                                  first_ambig_conn = conns18022.get(0);
                              }
                              
                              if(first_ambig_conn != null)
                              {

    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(first_ambig_conn.getName());
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(first_ambig_conn.getName());
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(first_ambig_conn.getName());
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    
                                       if(has_out_res_component_state)
                                       {

    stringBuffer.append(TEXT_349);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_350);
    
                                       }

                                       for (int j = 0; j < sizeColumns; j++) 
                                       { 
                                          for (int k = 0; k < sizeColumns_ambig; k++) 
                                          {
                                              if(columns_out.get(j).getLabel().compareTo(columns_ambig.get(k).getLabel()) == 0)
                                              {
                                           

    stringBuffer.append(TEXT_351);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_352);
    stringBuffer.append(columns_out.get(j).getLabel());
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(columns_out.get(j).getLabel());
    stringBuffer.append(TEXT_355);
    
                                              }
                                          }
    
                                       }

    stringBuffer.append(TEXT_356);
    
                              }

    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_378);
    
                   }
                }


    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    
                if(conns18022 != null)
                { 
                      for(IConnection conn_ambig : conns18022) 
                      {

    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(conn_ambig.getName());
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
    stringBuffer.append(TEXT_392);
    stringBuffer.append(conn_ambig.getName());
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(conn_ambig.getName());
    stringBuffer.append(TEXT_398);
                  
                     }
                }

    stringBuffer.append(TEXT_399);
    
                   if(conns18022 != null)
                   { 
                       for(IConnection conn_ambig : conns18022) 
                       {

    stringBuffer.append(TEXT_400);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(conn_ambig.getName());
    stringBuffer.append(TEXT_402);
    
                       }
                   }

    stringBuffer.append(TEXT_403);
    


                if(connsReject != null)
                {
                   for(IConnection connReject : connsReject) 
                   {

    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(connReject.getName());
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(connReject.getName());
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(connReject.getName());
    stringBuffer.append(TEXT_421);
         
                   }
               }

    stringBuffer.append(TEXT_422);
    
            }
      }
}

    stringBuffer.append(TEXT_423);
    return stringBuffer.toString();
  }
}
