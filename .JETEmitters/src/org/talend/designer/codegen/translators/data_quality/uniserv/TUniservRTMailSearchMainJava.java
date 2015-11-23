package org.talend.designer.codegen.translators.data_quality.uniserv;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class TUniservRTMailSearchMainJava
{
  protected static String nl;
  public static synchronized TUniservRTMailSearchMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniservRTMailSearchMainJava result = new TUniservRTMailSearchMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int myRetCount_";
  protected final String TEXT_3 = " = 0;";
  protected final String TEXT_4 = NL + "WSStatus ws_status_";
  protected final String TEXT_5 = " = (WSStatus)globalMap.get(\"WS_STATUS\");" + NL + "ComponentStatus status_";
  protected final String TEXT_6 = " = null;" + NL + "boolean use_component_status_";
  protected final String TEXT_7 = " = false;" + NL + "boolean is_last_component_";
  protected final String TEXT_8 = " = false;" + NL + "" + NL + "if(ws_status_";
  protected final String TEXT_9 = " != null)" + NL + "{" + NL + "   status_";
  protected final String TEXT_10 = " = ws_status_";
  protected final String TEXT_11 = ".getComponentStatus(\"";
  protected final String TEXT_12 = "\");" + NL + "" + NL + "   if(status_";
  protected final String TEXT_13 = " == null)" + NL + "   {" + NL + "      status_";
  protected final String TEXT_14 = " = new ComponentStatus();" + NL + "      status_";
  protected final String TEXT_15 = ".setComponentName(\"";
  protected final String TEXT_16 = "\");" + NL + "      ws_status_";
  protected final String TEXT_17 = ".getComponentStatusList().add(status_";
  protected final String TEXT_18 = ");" + NL + "      ws_status_";
  protected final String TEXT_19 = ".setLastComponent(\"";
  protected final String TEXT_20 = "\");" + NL + "   }" + NL + "   else" + NL + "   {" + NL + "      use_component_status_";
  protected final String TEXT_21 = " = true;" + NL + "      myRetCount_";
  protected final String TEXT_22 = " = status_";
  protected final String TEXT_23 = ".getOutputConnectionDataCount();" + NL + "      if(ws_status_";
  protected final String TEXT_24 = ".getLastComponent().compareTo(\"";
  protected final String TEXT_25 = "\") == 0)" + NL + "      {" + NL + "         is_last_component_";
  protected final String TEXT_26 = " = true;" + NL + "" + NL + "         /*" + NL + "          * Check if the client has selected an element from the ambiguity list" + NL + "          * then set result count to 1" + NL + "          */" + NL + "         if(globalMap.get(\"WS_SELECTED\") != null)" + NL + "         {" + NL + "            myRetCount_";
  protected final String TEXT_27 = " = 1;" + NL + "         }" + NL + "      }" + NL + "   }" + NL + "}" + NL + "else" + NL + "{" + NL + "     status_";
  protected final String TEXT_28 = " = new ComponentStatus();" + NL + "     status_";
  protected final String TEXT_29 = ".setComponentName(\"";
  protected final String TEXT_30 = "\");" + NL + "}";
  protected final String TEXT_31 = NL + "\t\t\t\t";
  protected final String TEXT_32 = "=null;" + NL + "\t\t\t\t";
  protected final String TEXT_33 = "=new ";
  protected final String TEXT_34 = "Struct();";
  protected final String TEXT_35 = NL + "\t\t\t\t";
  protected final String TEXT_36 = "=null;" + NL + "\t\t\t\t";
  protected final String TEXT_37 = "=new ";
  protected final String TEXT_38 = "Struct();";
  protected final String TEXT_39 = NL + "                            if(!use_component_status_";
  protected final String TEXT_40 = ")" + NL + "                            {";
  protected final String TEXT_41 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = "!=null) {" + NL + "\t\t\t\t\t\t" + NL + "                                              h_";
  protected final String TEXT_44 = ".put(\"";
  protected final String TEXT_45 = "\", ";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = ");" + NL + "\t\t\t\t\t" + NL + "                                        }" + NL;
  protected final String TEXT_48 = NL + NL + "\t\t\t       mailClient_";
  protected final String TEXT_49 = ".setArg(h_";
  protected final String TEXT_50 = ");" + NL + "\t\t\t       myResult_";
  protected final String TEXT_51 = " = mailClient_";
  protected final String TEXT_52 = ".execRequest(uniserv.cliserv.Mail.MAIL_SEARCH);" + NL + "" + NL + "                   if(myResult_";
  protected final String TEXT_53 = ".getRetType() == uniserv.cliserv.GenClient.UNI_ERR)" + NL + "                   {" + NL + "                       StringBuffer error_msg_";
  protected final String TEXT_54 = " = new StringBuffer();" + NL + "                       uniserv.cliserv.Uniresult rslt_";
  protected final String TEXT_55 = " = mailClient_";
  protected final String TEXT_56 = ".getErrorMsg(myResult_";
  protected final String TEXT_57 = ".getRetType(), myResult_";
  protected final String TEXT_58 = ".getRetInfo(), \"E\", error_msg_";
  protected final String TEXT_59 = ");" + NL + "" + NL + "                        globalMap.put(\"WS_ERROR_CODE\", myResult_";
  protected final String TEXT_60 = ".getRetInfo());" + NL + "                        globalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_61 = "\");" + NL + "                        globalMap.put(\"WS_ERROR_MESSAGE\", error_msg_";
  protected final String TEXT_62 = ".toString());" + NL + "                        mailClient_";
  protected final String TEXT_63 = ".close();" + NL + "                        throw new RuntimeException(\"Error while executing duplicate search, info = \" + myResult_";
  protected final String TEXT_64 = ".getRetInfo() + \", msg = \" + error_msg_";
  protected final String TEXT_65 = ");" + NL + "" + NL + "                   }" + NL + "\t\t\t " + NL + "\t\t\t       if(myResult_";
  protected final String TEXT_66 = ".getRetType() != uniserv.cliserv.GenClient.UNI_ERR) {" + NL + "\t\t\t\t      v_";
  protected final String TEXT_67 = ".removeAllElements();" + NL + "\t\t\t\t      v_";
  protected final String TEXT_68 = ".addElement(uniserv.cliserv.Mail.OUT_LIST_COUNT);" + NL + "\t\t\t\t      v_";
  protected final String TEXT_69 = ".addElement(uniserv.cliserv.Mail.OUT_DBREF);" + NL + "\t\t\t\t      v_";
  protected final String TEXT_70 = ".addElement(uniserv.cliserv.Mail.OUT_MVAL);" + NL + "\t\t\t\t      v_";
  protected final String TEXT_71 = ".addElement(uniserv.cliserv.Mail.OUT_MVALS);" + NL + "\t\t\t\t      v_";
  protected final String TEXT_72 = ".addElement(uniserv.cliserv.Mail.OUT_DATA);" + NL + "\t\t\t\t      v_";
  protected final String TEXT_73 = ".addElement(uniserv.cliserv.Mail.OUT_EVALUE_TAB);" + NL + "\t\t\t\t      v_";
  protected final String TEXT_74 = ".addElement(uniserv.cliserv.Mail.OUT_FREE);" + NL + "\t\t\t\t      v_";
  protected final String TEXT_75 = ".addElement(uniserv.cliserv.Mail.OUT_FREE2);" + NL + "\t\t\t\t      v_";
  protected final String TEXT_76 = ".addElement(uniserv.cliserv.Mail.OUT_FREE3);" + NL + "\t\t\t\t      v_";
  protected final String TEXT_77 = ".addElement(uniserv.cliserv.Mail.OUT_FREE4);" + NL + "\t\t\t\t      v_";
  protected final String TEXT_78 = ".addElement(uniserv.cliserv.Mail.OUT_FREE5);" + NL + "\t\t\t\t      v_";
  protected final String TEXT_79 = ".addElement(uniserv.cliserv.Mail.OUT_FREE6);" + NL + "\t\t\t\t      v_";
  protected final String TEXT_80 = ".addElement(uniserv.cliserv.Mail.OUT_FREE7);" + NL + "\t\t\t\t      v_";
  protected final String TEXT_81 = ".addElement(uniserv.cliserv.Mail.OUT_INDEX);" + NL + "\t\t\t\t      mailClient_";
  protected final String TEXT_82 = ".getAllArgList(v_";
  protected final String TEXT_83 = ", htable_";
  protected final String TEXT_84 = ", ";
  protected final String TEXT_85 = ");" + NL + "\t\t\t      }";
  protected final String TEXT_86 = NL + "                            }";
  protected final String TEXT_87 = NL + "\t\t\t" + NL + "                        /*" + NL + "                         * Loop over all results, runs till there is a null pointer or the max result count has" + NL + "                         * been reached." + NL + "                         */" + NL + "\t\t\tfor(int i_";
  protected final String TEXT_88 = "=0; i_";
  protected final String TEXT_89 = "<";
  protected final String TEXT_90 = "; i_";
  protected final String TEXT_91 = "++) {";
  protected final String TEXT_92 = NL + "                                    if(!use_component_status_";
  protected final String TEXT_93 = ")" + NL + "                                    {";
  protected final String TEXT_94 = NL + "\t\t\t\t       if(htable_";
  protected final String TEXT_95 = "[i_";
  protected final String TEXT_96 = "].get(uniserv.cliserv.Mail.OUT_DBREF)==null) {" + NL + "\t\t\t\t\t   //htable_";
  protected final String TEXT_97 = "[i]=null;";
  protected final String TEXT_98 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_99 = "=null;" + NL + "\t\t\t\t\t\tbreak;";
  protected final String TEXT_100 = NL + "\t\t\t\t}";
  protected final String TEXT_101 = "\t\t\t\t" + NL + "\t\t\t\tif(";
  protected final String TEXT_102 = NL + "\t\t\t\t\t\t\t|| ";
  protected final String TEXT_103 = "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tLong.parseLong(htable_";
  protected final String TEXT_104 = "[i_";
  protected final String TEXT_105 = "].get(uniserv.cliserv.Mail.OUT_LIST_COUNT))<";
  protected final String TEXT_106 = "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tLong.parseLong(htable_";
  protected final String TEXT_107 = "[i_";
  protected final String TEXT_108 = "].get(uniserv.cliserv.Mail.OUT_LIST_COUNT))<=";
  protected final String TEXT_109 = "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tLong.parseLong(htable_";
  protected final String TEXT_110 = "[i_";
  protected final String TEXT_111 = "].get(uniserv.cliserv.Mail.OUT_LIST_COUNT))==";
  protected final String TEXT_112 = "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tLong.parseLong(htable_";
  protected final String TEXT_113 = "[i_";
  protected final String TEXT_114 = "].get(uniserv.cliserv.Mail.OUT_LIST_COUNT))>=";
  protected final String TEXT_115 = "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tLong.parseLong(htable_";
  protected final String TEXT_116 = "[i_";
  protected final String TEXT_117 = "].get(uniserv.cliserv.Mail.OUT_LIST_COUNT))>";
  protected final String TEXT_118 = NL + "\t\t\t\t) " + NL + "\t\t\t\t";
  protected final String TEXT_119 = "\t\t\t\t" + NL + "\t\t\t\tif(false)";
  protected final String TEXT_120 = NL + "\t\t\t\t{";
  protected final String TEXT_121 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = "=";
  protected final String TEXT_124 = ".";
  protected final String TEXT_125 = ";";
  protected final String TEXT_126 = NL + "                                                        ByteArrayOutputStream boss_";
  protected final String TEXT_127 = " = new ByteArrayOutputStream();" + NL + "                                                        ObjectOutputStream dos_";
  protected final String TEXT_128 = " = new ObjectOutputStream(boss_";
  protected final String TEXT_129 = ");";
  protected final String TEXT_130 = NL + "                                                        ";
  protected final String TEXT_131 = ".writeData(dos_";
  protected final String TEXT_132 = ");" + NL + "                                                        dos_";
  protected final String TEXT_133 = ".close();" + NL + "                                                        boss_";
  protected final String TEXT_134 = ".close();" + NL + "                                                        status_";
  protected final String TEXT_135 = ".addOutputConnectionData(i_";
  protected final String TEXT_136 = ", \"";
  protected final String TEXT_137 = "\", boss_";
  protected final String TEXT_138 = ".toByteArray());";
  protected final String TEXT_139 = NL + "\t\t\t\t\t";
  protected final String TEXT_140 = "=null;";
  protected final String TEXT_141 = NL + "\t\t\t\t\ti_";
  protected final String TEXT_142 = " = ";
  protected final String TEXT_143 = ";" + NL + "\t\t\t\t" + NL + "\t\t\t\t} else {";
  protected final String TEXT_144 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_145 = "=null;";
  protected final String TEXT_146 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = "=";
  protected final String TEXT_149 = ".";
  protected final String TEXT_150 = ";";
  protected final String TEXT_151 = NL + "\t\t\t\t\t\t\tif(htable_";
  protected final String TEXT_152 = "[i_";
  protected final String TEXT_153 = "]!=null) {";
  protected final String TEXT_154 = NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_155 = ".";
  protected final String TEXT_156 = "=Long.parseLong(htable_";
  protected final String TEXT_157 = "[i_";
  protected final String TEXT_158 = "].get(uniserv.cliserv.Mail.";
  protected final String TEXT_159 = "));";
  protected final String TEXT_160 = NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = "=htable_";
  protected final String TEXT_163 = "[i_";
  protected final String TEXT_164 = "].get(uniserv.cliserv.Mail.";
  protected final String TEXT_165 = ");";
  protected final String TEXT_166 = NL + "                                                                       ";
  protected final String TEXT_167 = ".OUT_RES_COMPONENT_STATE = \"SERVICE_RESPONSE\";" + NL;
  protected final String TEXT_168 = NL + "                                                                    ByteArrayOutputStream boss_";
  protected final String TEXT_169 = " = new ByteArrayOutputStream();" + NL + "                                                                    ObjectOutputStream dos_";
  protected final String TEXT_170 = " = new ObjectOutputStream(boss_";
  protected final String TEXT_171 = ");";
  protected final String TEXT_172 = NL + "                                                                    ";
  protected final String TEXT_173 = ".writeData(dos_";
  protected final String TEXT_174 = ");" + NL + "                                                                    dos_";
  protected final String TEXT_175 = ".close();" + NL + "                                                                    boss_";
  protected final String TEXT_176 = ".close();" + NL + "                                                                    status_";
  protected final String TEXT_177 = ".addOutputConnectionData(i_";
  protected final String TEXT_178 = ",\"";
  protected final String TEXT_179 = "\", boss_";
  protected final String TEXT_180 = ".toByteArray());";
  protected final String TEXT_181 = NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_182 = "=null;" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_183 = NL + "\t\t\t\t}";
  protected final String TEXT_184 = NL + "                }" + NL + "                else" + NL + "                {" + NL + "" + NL + "                   if(i_";
  protected final String TEXT_185 = " >= myRetCount_";
  protected final String TEXT_186 = ")" + NL + "                   {" + NL + "                       break;" + NL + "                   } ";
  protected final String TEXT_187 = NL + "                   if(ws_status_";
  protected final String TEXT_188 = " != null)" + NL + "                   {" + NL + "                      Integer selected_index_";
  protected final String TEXT_189 = " = (Integer)globalMap.get(\"WS_SELECTED\");" + NL + "" + NL + "                      byte[] conn_data_";
  protected final String TEXT_190 = " = status_";
  protected final String TEXT_191 = ".getOutputConnectionData(i_";
  protected final String TEXT_192 = ", \"";
  protected final String TEXT_193 = "\");" + NL + "      " + NL + "" + NL + "                      if(!is_last_component_";
  protected final String TEXT_194 = " || selected_index_";
  protected final String TEXT_195 = " == null || (is_last_component_";
  protected final String TEXT_196 = " && selected_index_";
  protected final String TEXT_197 = ".intValue() == 0 && conn_data_";
  protected final String TEXT_198 = " != null))" + NL + "                      {" + NL + "                          if(conn_data_";
  protected final String TEXT_199 = " != null)" + NL + "                          {" + NL + "                             ByteArrayInputStream biss_";
  protected final String TEXT_200 = " = new ByteArrayInputStream(conn_data_";
  protected final String TEXT_201 = ");" + NL + "                             ObjectInputStream dis_";
  protected final String TEXT_202 = " = new ObjectInputStream(biss_";
  protected final String TEXT_203 = ");";
  protected final String TEXT_204 = NL + "                             ";
  protected final String TEXT_205 = ".readData(dis_";
  protected final String TEXT_206 = ");" + NL + "                             dis_";
  protected final String TEXT_207 = ".close();" + NL + "                             biss_";
  protected final String TEXT_208 = ".close();" + NL;
  protected final String TEXT_209 = NL + "                                 ";
  protected final String TEXT_210 = ".OUT_RES_COMPONENT_STATE = \"USER_DECISION_ACCEPTED\";";
  protected final String TEXT_211 = NL + "                          }\t" + NL + "                          else" + NL + "                          {";
  protected final String TEXT_212 = NL + "                             ";
  protected final String TEXT_213 = " = null;" + NL + "                          }" + NL + "                      }" + NL + "                      else if(is_last_component_";
  protected final String TEXT_214 = " && selected_index_";
  protected final String TEXT_215 = " != null)" + NL + "                      {";
  protected final String TEXT_216 = NL + "                                          ";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = " = ";
  protected final String TEXT_219 = ".";
  protected final String TEXT_220 = ";";
  protected final String TEXT_221 = NL + "                                      ";
  protected final String TEXT_222 = ".";
  protected final String TEXT_223 = " = ";
  protected final String TEXT_224 = ".";
  protected final String TEXT_225 = ";";
  protected final String TEXT_226 = NL + "                             ";
  protected final String TEXT_227 = ".OUT_RES_COMPONENT_STATE = \"USER_DECISION_REJECTED\";";
  protected final String TEXT_228 = NL + "                             ";
  protected final String TEXT_229 = ".OUT_LIST_COUNT = 1L;";
  protected final String TEXT_230 = NL + NL + "                          conn_data_";
  protected final String TEXT_231 = " = status_";
  protected final String TEXT_232 = ".getOutputConnectionData(selected_index_";
  protected final String TEXT_233 = ".intValue(), \"";
  protected final String TEXT_234 = "\");" + NL + "" + NL + "                          if(conn_data_";
  protected final String TEXT_235 = " != null)" + NL + "                          {" + NL + "                             ByteArrayInputStream biss_";
  protected final String TEXT_236 = " = new ByteArrayInputStream(conn_data_";
  protected final String TEXT_237 = ");" + NL + "                             ObjectInputStream dis_";
  protected final String TEXT_238 = " = new ObjectInputStream(biss_";
  protected final String TEXT_239 = ");";
  protected final String TEXT_240 = NL + "                             ";
  protected final String TEXT_241 = ".readData(dis_";
  protected final String TEXT_242 = ");" + NL + "                             dis_";
  protected final String TEXT_243 = ".close();" + NL + "                             biss_";
  protected final String TEXT_244 = ".close();    " + NL;
  protected final String TEXT_245 = NL + "                                  ";
  protected final String TEXT_246 = ".OUT_RES_COMPONENT_STATE = \"USER_DECISION_ACCEPTED\";";
  protected final String TEXT_247 = NL + "                                 ";
  protected final String TEXT_248 = ".OUT_LIST_COUNT = 1L;";
  protected final String TEXT_249 = NL + "                         }" + NL + "" + NL + "                         ws_status_";
  protected final String TEXT_250 = ".getComponentStatusList().remove(status_";
  protected final String TEXT_251 = ");" + NL + "                         status_";
  protected final String TEXT_252 = " = new ComponentStatus();" + NL + "                         status_";
  protected final String TEXT_253 = ".setComponentName(\"";
  protected final String TEXT_254 = "\");" + NL + "                         ws_status_";
  protected final String TEXT_255 = ".getComponentStatusList().add(status_";
  protected final String TEXT_256 = ");" + NL + "" + NL + "                         ByteArrayOutputStream boss_";
  protected final String TEXT_257 = " = new ByteArrayOutputStream();" + NL + "                         ObjectOutputStream dos_";
  protected final String TEXT_258 = " = new ObjectOutputStream(boss_";
  protected final String TEXT_259 = ");";
  protected final String TEXT_260 = NL + "                         ";
  protected final String TEXT_261 = ".writeData(dos_";
  protected final String TEXT_262 = ");" + NL + "                         dos_";
  protected final String TEXT_263 = ".close();" + NL + "                         boss_";
  protected final String TEXT_264 = ".close();" + NL + "                         status_";
  protected final String TEXT_265 = ".addOutputConnectionData(i_";
  protected final String TEXT_266 = ", \"";
  protected final String TEXT_267 = "\", boss_";
  protected final String TEXT_268 = ".toByteArray());" + NL + "                      }" + NL + "                      else" + NL + "                      {";
  protected final String TEXT_269 = NL + "                         ";
  protected final String TEXT_270 = " = null;" + NL + "                      }" + NL + "                   }";
  protected final String TEXT_271 = NL + "                   if(ws_status_";
  protected final String TEXT_272 = " != null)" + NL + "                   {" + NL + "                      byte[] conn_data_";
  protected final String TEXT_273 = " = status_";
  protected final String TEXT_274 = ".getOutputConnectionData(i_";
  protected final String TEXT_275 = ", \"";
  protected final String TEXT_276 = "\");" + NL + "        " + NL + "                      if(conn_data_";
  protected final String TEXT_277 = " != null)" + NL + "                      {" + NL + "                         ByteArrayInputStream biss_";
  protected final String TEXT_278 = " = new ByteArrayInputStream(conn_data_";
  protected final String TEXT_279 = ");" + NL + "                         ObjectInputStream dis_";
  protected final String TEXT_280 = " = new ObjectInputStream(biss_";
  protected final String TEXT_281 = ");";
  protected final String TEXT_282 = NL + "                         ";
  protected final String TEXT_283 = ".readData(dis_";
  protected final String TEXT_284 = ");" + NL + "                         dis_";
  protected final String TEXT_285 = ".close();" + NL + "                         biss_";
  protected final String TEXT_286 = ".close();" + NL + "                      }\t" + NL + "                      else" + NL + "                      {";
  protected final String TEXT_287 = NL + "                         ";
  protected final String TEXT_288 = " = null;" + NL + "                      }" + NL + "                   }";
  protected final String TEXT_289 = NL + "                }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<String> UniservSearch=new ArrayList<String>();
List<String> UniservOut=new ArrayList<String>();
UniservSearch.add("IN_NAME");
UniservSearch.add("IN_FIRST_NAME");
UniservSearch.add("IN_NAME_LINE");
UniservSearch.add("IN_COMPANY_NAME");
UniservSearch.add("IN_PERSON");
UniservSearch.add("IN_DEPARTMENT");
UniservSearch.add("IN_WEB_ADDR");
UniservSearch.add("IN_STR");
UniservSearch.add("IN_HNO");
UniservSearch.add("IN_STR_LINE");
UniservSearch.add("IN_ZIP");
UniservSearch.add("IN_CITY");
UniservSearch.add("IN_CITY_LINE");
UniservSearch.add("IN_COUNTRY_CODE");
UniservSearch.add("IN_POBOX");
UniservSearch.add("IN_FREE");
UniservSearch.add("IN_FREE2");
UniservSearch.add("IN_FREE3");
UniservSearch.add("IN_FREE4");
UniservSearch.add("IN_FREE5");
UniservSearch.add("IN_FREE6");
UniservSearch.add("IN_FREE7");
UniservSearch.add("IN_DATE");
UniservSearch.add("IN_PHONE");
UniservSearch.add("IN_GENDER");
UniservSearch.add("IN_ROLE");
UniservSearch.add("IN_EMAIL");
UniservSearch.add("IN_CODEPOOL");

UniservOut.add("OUT_LIST_COUNT");
UniservOut.add("OUT_DBREF");
UniservOut.add("OUT_MVAL");
UniservOut.add("OUT_MVALS");
UniservOut.add("OUT_DATA");
UniservOut.add("OUT_EVALUE_TAB");
UniservOut.add("OUT_FREE");
UniservOut.add("OUT_FREE2");
UniservOut.add("OUT_FREE3");
UniservOut.add("OUT_FREE4");
UniservOut.add("OUT_FREE5");
UniservOut.add("OUT_FREE6");
UniservOut.add("OUT_FREE7");
UniservOut.add("OUT_INDEX");


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    

boolean has_out_res_component_state = false;
boolean has_out_list_count = false;
IProcess process = node.getProcess();
List<INode> tRTOutputList = (List<INode>)process.getNodesOfType("tRTOutput");


if(tRTOutputList != null && tRTOutputList.size() > 0)
{  

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
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
    
}

int duplicate = Integer.parseInt(ElementParameterParser.getValue(node, "__DUPLICATE__"));
List<Map<String, String>> defRejects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REJECTS_DEFINITION__");
String defineRejects = ElementParameterParser.getValue(node, "__DEFINE_REJECTS__");
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		List< ? extends IConnection> conns = node.getIncomingConnections();
		List<? extends IConnection> connsOut = node.getOutgoingConnections("OUTPUT");
		List<? extends IConnection> connsReject = node.getOutgoingConnections("REJECT");


		for (IConnection conn : conns) {
			for(IConnection conn_out : connsOut) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_34);
    
			}
			
			for(IConnection conn_rej : connsReject) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(conn_rej.getName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(conn_rej.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(conn_rej.getName());
    stringBuffer.append(TEXT_38);
    
			}

                        if(tRTOutputList != null && tRTOutputList.size() > 0)
                        {  

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
                        }

			List<IMetadataColumn> columns = metadata.getListColumns();
        	        int sizeColumns = columns.size();
			
                        for(int i=0; i<sizeColumns; i++) {
				
                               if(UniservSearch.contains(columns.get(i).getLabel())) {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append((columns.get(i).getLabel()).toLowerCase());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_47);
    
			       }

			}


                        metadata = metadatas.get(1); 
                        List<IMetadataColumn> columns_out_1 = metadata.getListColumns();
        	        int sizeColumns_out_1 = columns_out_1.size();
                        for(int j=0; j<sizeColumns_out_1; j++)
                        {

			    if(columns_out_1.get(j).getLabel().compareTo("OUT_RES_COMPONENT_STATE") == 0)
                            {
                                    has_out_res_component_state = true;
                            }
                            else if(columns_out_1.get(j).getLabel().compareTo("OUT_LIST_COUNT") == 0)
                            {
                                    has_out_list_count = true;
                            }
                        }

		
                        

                      


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
    stringBuffer.append(duplicate==0?1000:duplicate);
    stringBuffer.append(TEXT_85);
    
                        if(tRTOutputList != null && tRTOutputList.size() > 0)
                        {  

    stringBuffer.append(TEXT_86);
    
                        }

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(duplicate==0?1000:duplicate);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
                                if(tRTOutputList != null && tRTOutputList.size() > 0)
                                {  

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
                                }

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
					   metadata = metadatas.get(1);
					   for(IConnection conn_out : connsOut) {

    stringBuffer.append(TEXT_98);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_99);
    
					}

    stringBuffer.append(TEXT_100);
    
				if(defRejects.size()>0 && "true".equals(defineRejects) && connsReject.size()>0) {

    stringBuffer.append(TEXT_101);
    
					int count=0;
					for(Map<String, String> defRejectsRow : defRejects){
						String element=defRejectsRow.get("ELEMENT");
						String operator=defRejectsRow.get("OPERATOR");
						String value=defRejectsRow.get("ELEMENT_VALUE");
						
						if(count++>0) {

    stringBuffer.append(TEXT_102);
    							
						}
						
						if("duplicate_count".equals(element)) {
							if("lt".equals(operator)) {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(value);
    
							} else if("lte".equals(operator)) {

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(value);
    
							} else if("eq".equals(operator)) {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(value);
    
							} else if("gte".equals(operator)) {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(value);
    
							} else if("gt".equals(operator)) {

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(value);
    
							}
						}
					}

    stringBuffer.append(TEXT_118);
    
				} else {

    stringBuffer.append(TEXT_119);
    
				}

    stringBuffer.append(TEXT_120);
    				
				metadata = metadatas.get(2);
				for (IConnection conn_in : conns) {
					for(IConnection connReject : connsReject) {
						List<IMetadataColumn> columnsRej = metadata.getListColumns();
						int sizeColumnsReject = columnsRej.size();
						for(int i=0; i<sizeColumnsReject; i++) {

    stringBuffer.append(TEXT_121);
    stringBuffer.append(connReject.getName());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(columnsRej.get(i).getLabel());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(conn_in.getName());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(columnsRej.get(i).getLabel());
    stringBuffer.append(TEXT_125);
    
						}

                                                if(tRTOutputList != null && tRTOutputList.size() > 0)
                                                {  

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(connReject.getName());
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
    stringBuffer.append(connReject.getName());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
                                                }
                                        }
                                }


				for(IConnection conn_out : connsOut) {

    stringBuffer.append(TEXT_139);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_140);
    
				}

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(duplicate==0?1000:duplicate);
    stringBuffer.append(TEXT_143);
    
					for(IConnection connReject : connsReject) {

    stringBuffer.append(TEXT_144);
    stringBuffer.append(connReject.getName());
    stringBuffer.append(TEXT_145);
    
					}
					metadata = metadatas.get(1);
					if (connsOut!=null) {
						if (connsOut.size()>0) {
							for (int j=0;j<connsOut.size();j++) {
								IConnection connTemp = connsOut.get(j);
								if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
									if(metadata!=null) {
										List<IMetadataColumn> columns_out = metadata.getListColumns();
										int sizeColumns_out = columns_out.size();
										for(int i=0; i<sizeColumns_out; i++) {
											if(!(UniservOut.contains(columns_out.get(i).getLabel())) && columns_out.get(i).getLabel().compareTo("OUT_RES_COMPONENT_STATE") != 0) {

    stringBuffer.append(TEXT_146);
    stringBuffer.append(connTemp.getName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(columns_out.get(i).getLabel());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_149);
    stringBuffer.append(columns_out.get(i).getLabel());
    stringBuffer.append(TEXT_150);
    
											}
										}
									}
								}
							}
						}
					}
					
					metadata = metadatas.get(1);
					for(IConnection conn_out : connsOut) {
						if(metadata!=null) {
							List<IMetadataColumn> columns_out = metadata.getListColumns();
							int sizeColumns_out = columns_out.size();

    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
								for(int i=0; i<sizeColumns_out; i++) {
									if(UniservOut.contains(columns_out.get(i).getLabel())) {
										if("id_Long".equals(columns_out.get(i).getTalendType())) {

    stringBuffer.append(TEXT_154);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(columns_out.get(i).getLabel());
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(columns_out.get(i).getLabel());
    stringBuffer.append(TEXT_159);
    
										} else {

    stringBuffer.append(TEXT_160);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(columns_out.get(i).getLabel());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(columns_out.get(i).getLabel());
    stringBuffer.append(TEXT_165);
    			
										}
									}
								}

                                                                if(tRTOutputList != null && tRTOutputList.size() > 0)
                                                                {  
                                                                    if(has_out_res_component_state)
                                                                    {

    stringBuffer.append(TEXT_166);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_167);
    
                                                                    } 

    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(conn_out.getName());
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
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    
                                                                }

    stringBuffer.append(TEXT_181);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_182);
    
						}
					}

    stringBuffer.append(TEXT_183);
    
		}


                if(tRTOutputList != null && tRTOutputList.size() > 0)
                { 

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
            if(connsOut != null)
            {
                for(IConnection conn_out : connsOut) 
                {

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
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    
                             if(has_out_res_component_state)
                             {

    stringBuffer.append(TEXT_209);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_210);
    
                             }

    stringBuffer.append(TEXT_211);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    
                          metadata = metadatas.get(1);
                          List<IMetadataColumn> columns_out = metadata.getListColumns();
        	          int sizeColumns = columns_out.size();


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

    stringBuffer.append(TEXT_216);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_217);
    stringBuffer.append(columns_out.get(j).getLabel());
    stringBuffer.append(TEXT_218);
    stringBuffer.append(first_inp_conn.getName());
    stringBuffer.append(TEXT_219);
    stringBuffer.append(columns_out.get(j).getLabel());
    stringBuffer.append(TEXT_220);
    
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

    stringBuffer.append(TEXT_221);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_222);
    stringBuffer.append(columns_out.get(j).getLabel());
    stringBuffer.append(TEXT_223);
    stringBuffer.append(first_inp_conn.getName());
    stringBuffer.append(TEXT_224);
    stringBuffer.append(columns_inp.get(k).getLabel());
    stringBuffer.append(TEXT_225);
    
                                  }
                              }
                          }

                          if(has_out_res_component_state)
                          {

    stringBuffer.append(TEXT_226);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_227);
    
                          }

                          if(has_out_list_count)
                          {

    stringBuffer.append(TEXT_228);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_229);
    
                          }

    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(conn_out.getName());
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
    stringBuffer.append(TEXT_240);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    
                             if(has_out_res_component_state)
                             {

    stringBuffer.append(TEXT_245);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_246);
    
                             } 


                             if(has_out_list_count)
                             {

    stringBuffer.append(TEXT_247);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_248);
    
                             } 

    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(conn_out.getName());
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
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(conn_out.getName());
    stringBuffer.append(TEXT_270);
    
                }
            }


            if(connsReject != null)
            {
                for(IConnection connReject : connsReject) 
                {

    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(connReject.getName());
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(connReject.getName());
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(connReject.getName());
    stringBuffer.append(TEXT_288);
         
               }
            }

    stringBuffer.append(TEXT_289);
    
        }
    } 
}

    return stringBuffer.toString();
  }
}
