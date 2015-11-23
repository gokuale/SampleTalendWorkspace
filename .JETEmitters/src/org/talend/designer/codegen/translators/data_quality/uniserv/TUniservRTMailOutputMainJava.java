package org.talend.designer.codegen.translators.data_quality.uniserv;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class TUniservRTMailOutputMainJava
{
  protected static String nl;
  public static synchronized TUniservRTMailOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniservRTMailOutputMainJava result = new TUniservRTMailOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "int myRetCount_";
  protected final String TEXT_2 = " = 1;" + NL + "boolean use_component_status_";
  protected final String TEXT_3 = " = false;" + NL + "" + NL + "//mumb";
  protected final String TEXT_4 = NL + "WSStatus ws_status_";
  protected final String TEXT_5 = " = (WSStatus)globalMap.get(\"WS_STATUS\");" + NL + "ComponentStatus status_";
  protected final String TEXT_6 = " = null;" + NL + "" + NL + "boolean is_last_component_";
  protected final String TEXT_7 = " = false;" + NL + "" + NL + "if(ws_status_";
  protected final String TEXT_8 = " != null)" + NL + "{" + NL + "   status_";
  protected final String TEXT_9 = " = ws_status_";
  protected final String TEXT_10 = ".getComponentStatus(\"";
  protected final String TEXT_11 = "\");" + NL + "" + NL + "   if(status_";
  protected final String TEXT_12 = " == null)" + NL + "   {" + NL + "      status_";
  protected final String TEXT_13 = " = new ComponentStatus();" + NL + "      status_";
  protected final String TEXT_14 = ".setComponentName(\"";
  protected final String TEXT_15 = "\");" + NL + "      ws_status_";
  protected final String TEXT_16 = ".getComponentStatusList().add(status_";
  protected final String TEXT_17 = ");" + NL + "      ws_status_";
  protected final String TEXT_18 = ".setLastComponent(\"";
  protected final String TEXT_19 = "\");" + NL + "   }" + NL + "   else" + NL + "   {" + NL + "      use_component_status_";
  protected final String TEXT_20 = " = true;" + NL + "      if(ws_status_";
  protected final String TEXT_21 = ".getLastComponent().compareTo(\"";
  protected final String TEXT_22 = "\") == 0)" + NL + "      {" + NL + "         is_last_component_";
  protected final String TEXT_23 = " = true;         " + NL + "      }" + NL + "   }" + NL + "}" + NL + "else" + NL + "{" + NL + "     status_";
  protected final String TEXT_24 = " = new ComponentStatus();" + NL + "     status_";
  protected final String TEXT_25 = ".setComponentName(\"";
  protected final String TEXT_26 = "\");" + NL + "}";
  protected final String TEXT_27 = NL + NL + NL + NL + NL + NL;
  protected final String TEXT_28 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_29 = " = new ";
  protected final String TEXT_30 = "Struct();" + NL + "\t\t\t\t\t";
  protected final String TEXT_31 = NL + NL + NL + NL;
  protected final String TEXT_32 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = "!=null) {" + NL + "\t\t\t\t\t\th_";
  protected final String TEXT_35 = ".put(\"";
  protected final String TEXT_36 = "\", ";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_39 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t  ";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_44 = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t}";
  protected final String TEXT_45 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t  ";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = " = ";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_50 = NL;
  protected final String TEXT_51 = NL + "\tif(use_component_status_";
  protected final String TEXT_52 = ")" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_53 = "\t" + NL + "\t\t  byte[] conn_data_";
  protected final String TEXT_54 = " = status_";
  protected final String TEXT_55 = ".getOutputConnectionData(0, \"";
  protected final String TEXT_56 = "\");" + NL + "\t\t  ByteArrayInputStream biss_";
  protected final String TEXT_57 = " = new ByteArrayInputStream(conn_data_";
  protected final String TEXT_58 = ");" + NL + "\t\t  ObjectInputStream dis_";
  protected final String TEXT_59 = " = new ObjectInputStream(biss_";
  protected final String TEXT_60 = ");" + NL + "\t\t  ";
  protected final String TEXT_61 = ".readData(dis_";
  protected final String TEXT_62 = ");" + NL + "\t\t  dis_";
  protected final String TEXT_63 = ".close();" + NL + "\t\t  biss_";
  protected final String TEXT_64 = ".close(); " + NL + "\t\t";
  protected final String TEXT_65 = NL + "\t} else {\t" + NL + "\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\tmailClient_";
  protected final String TEXT_67 = ".setArg(h_";
  protected final String TEXT_68 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tint retCode = mailClient_";
  protected final String TEXT_70 = ".mailInsert(mailError_";
  protected final String TEXT_71 = ");" + NL + "\t\t\t\t\t\tif(retCode == 0) {" + NL + "\t\t\t\t\t\t  mailClient_";
  protected final String TEXT_72 = ".commit();" + NL + "\t\t\t\t\t\t  ";
  protected final String TEXT_73 = NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_74 = ".STATUS_CODE=0;" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_75 = ".STATUS_CODE_INFO=0;" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_76 = ".STATUS_MESSAGE=\"\";\t\t" + NL + "\t\t\t\t\t\t  ";
  protected final String TEXT_77 = NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t   ";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_79 = ".STATUS_CODE =((Integer)globalMap.get(\"RT_MAIL_STATUS_CODE\")).intValue();" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_80 = ".STATUS_CODE_INFO=((Integer)globalMap.get(\"RT_MAIL_STATUS_CODE_INFO\")).intValue();" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_81 = ".STATUS_MESSAGE=(String)globalMap.get(\"RT_MAIL_STATUS_MESSAGE\");" + NL + "\t\t\t\t\t\t  ";
  protected final String TEXT_82 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} catch(uniserv.cliserv.mail.MailException e) {" + NL + "\t\t\t\t\t\tglobalMap.put(\"WS_ERROR_CODE\", -1);" + NL + "                        globalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_83 = "\");" + NL + "                        globalMap.put(\"WS_ERROR_MESSAGE\", e.toString());" + NL + "\t\t\t\t\t\tmailClient_";
  protected final String TEXT_84 = ".rollback();" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Unable to insert the record into the index pool: \" + e.getMessage());" + NL + "\t\t\t\t\t}";
  protected final String TEXT_85 = NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tint retCode = mailClient_";
  protected final String TEXT_86 = ".mailUpdate(mailError_";
  protected final String TEXT_87 = ");" + NL + "\t\t\t\t\t\tif(retCode == 0) {" + NL + "\t\t\t\t\t\t   mailClient_";
  protected final String TEXT_88 = ".commit();" + NL + "\t\t\t\t\t\t   ";
  protected final String TEXT_89 = NL + "\t\t\t\t\t\t     ";
  protected final String TEXT_90 = ".STATUS_CODE=0;" + NL + "\t\t\t\t\t\t     ";
  protected final String TEXT_91 = ".STATUS_CODE_INFO=0;" + NL + "\t\t\t\t\t\t     ";
  protected final String TEXT_92 = ".STATUS_MESSAGE=\"\";" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_93 = NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t ";
  protected final String TEXT_94 = NL + "\t\t\t\t\t\t\t    ";
  protected final String TEXT_95 = ".STATUS_CODE =((Integer)globalMap.get(\"RT_MAIL_STATUS_CODE\")).intValue();" + NL + "\t\t\t\t\t\t\t    ";
  protected final String TEXT_96 = ".STATUS_CODE_INFO=((Integer)globalMap.get(\"RT_MAIL_STATUS_CODE_INFO\")).intValue();" + NL + "\t\t\t\t\t\t\t    ";
  protected final String TEXT_97 = ".STATUS_MESSAGE=(String)globalMap.get(\"RT_MAIL_STATUS_MESSAGE\");" + NL + "\t\t\t\t\t\t\t  ";
  protected final String TEXT_98 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} catch(uniserv.cliserv.mail.MailException e) {" + NL + "\t\t\t\t\t\tglobalMap.put(\"WS_ERROR_CODE\", -1);" + NL + "                        globalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_99 = "\");" + NL + "                        globalMap.put(\"WS_ERROR_MESSAGE\", e.toString());" + NL + "\t\t\t\t\t\tmailClient_";
  protected final String TEXT_100 = ".rollback();" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Unable to update the record in the index pool: \" + e.getMessage());" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t}";
  protected final String TEXT_101 = NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tint retCode = mailClient_";
  protected final String TEXT_102 = ".mailDelete(mailError_";
  protected final String TEXT_103 = ");" + NL + "\t\t\t\t\t\tif(retCode == 0) {" + NL + "\t\t\t\t\t\t    mailClient_";
  protected final String TEXT_104 = ".commit();" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_105 = NL + "\t\t\t\t\t\t      ";
  protected final String TEXT_106 = ".STATUS_CODE=0;" + NL + "\t\t\t\t\t\t      ";
  protected final String TEXT_107 = ".STATUS_CODE_INFO=0;" + NL + "\t\t\t\t\t\t      ";
  protected final String TEXT_108 = ".STATUS_MESSAGE=\"\";" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_109 = NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t  ";
  protected final String TEXT_110 = NL + "\t\t\t\t\t\t\t    ";
  protected final String TEXT_111 = ".STATUS_CODE =((Integer)globalMap.get(\"RT_MAIL_STATUS_CODE\")).intValue();" + NL + "\t\t\t\t\t\t\t    ";
  protected final String TEXT_112 = ".STATUS_CODE_INFO=((Integer)globalMap.get(\"RT_MAIL_STATUS_CODE_INFO\")).intValue();" + NL + "\t\t\t\t\t\t\t    ";
  protected final String TEXT_113 = ".STATUS_MESSAGE=(String)globalMap.get(\"RT_MAIL_STATUS_MESSAGE\");" + NL + "\t\t\t\t\t\t\t  ";
  protected final String TEXT_114 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} catch(uniserv.cliserv.mail.MailException e) {" + NL + "\t\t\t\t\t\tglobalMap.put(\"WS_ERROR_CODE\", -1);" + NL + "                        globalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_115 = "\");" + NL + "                        globalMap.put(\"WS_ERROR_MESSAGE\", e.toString());" + NL + "\t\t\t\t\t\tmailClient_";
  protected final String TEXT_116 = ".rollback();" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"Unable to delete the record from the index pool: \" + e.getMessage());" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t}";
  protected final String TEXT_117 = NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tint retCode = mailClient_";
  protected final String TEXT_118 = ".mailInsert(silentMailError_";
  protected final String TEXT_119 = ");" + NL + "\t\t\t\t\t\tif(retCode == 0) {" + NL + "\t\t\t\t\t\t    mailClient_";
  protected final String TEXT_120 = ".commit();" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_121 = NL + "\t\t\t\t\t\t      ";
  protected final String TEXT_122 = ".STATUS_CODE=0;" + NL + "\t\t\t\t\t\t      ";
  protected final String TEXT_123 = ".STATUS_CODE_INFO=0;" + NL + "\t\t\t\t\t\t      ";
  protected final String TEXT_124 = ".STATUS_MESSAGE=\"\";" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_125 = NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tmailClient_";
  protected final String TEXT_126 = ".setArg(h_";
  protected final String TEXT_127 = ");" + NL + "\t\t\t\t\t\t\tretCode = mailClient_";
  protected final String TEXT_128 = ".mailUpdate(mailError_";
  protected final String TEXT_129 = ");" + NL + "\t\t\t\t\t\t\tif(retCode == 0) {" + NL + "\t\t\t\t\t\t\t    mailClient_";
  protected final String TEXT_130 = ".commit();" + NL + "\t\t\t\t\t\t\t    ";
  protected final String TEXT_131 = NL + "\t\t\t\t\t\t\t      ";
  protected final String TEXT_132 = ".STATUS_CODE=0;" + NL + "\t\t\t\t\t\t\t      ";
  protected final String TEXT_133 = ".STATUS_CODE_INFO=0;" + NL + "\t\t\t\t\t\t\t      ";
  protected final String TEXT_134 = ".STATUS_MESSAGE=\"\";" + NL + "\t\t\t\t\t\t\t    ";
  protected final String TEXT_135 = NL + "\t\t\t\t\t\t\t    " + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t   ";
  protected final String TEXT_136 = NL + "\t\t\t\t\t\t\t\t  ";
  protected final String TEXT_137 = ".STATUS_CODE =((Integer)globalMap.get(\"RT_MAIL_STATUS_CODE\")).intValue();" + NL + "\t\t\t\t\t\t\t\t  ";
  protected final String TEXT_138 = ".STATUS_CODE_INFO=((Integer)globalMap.get(\"RT_MAIL_STATUS_CODE_INFO\")).intValue();" + NL + "\t\t\t\t\t\t\t\t  ";
  protected final String TEXT_139 = ".STATUS_MESSAGE=(String)globalMap.get(\"RT_MAIL_STATUS_MESSAGE\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} catch(uniserv.cliserv.mail.MailException e) {" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tmailClient_";
  protected final String TEXT_141 = ".setArg(h_";
  protected final String TEXT_142 = ");" + NL + "\t\t\t\t\t\t\tmailClient_";
  protected final String TEXT_143 = ".mailUpdate(mailError_";
  protected final String TEXT_144 = ");" + NL + "\t\t\t\t\t\t\tmailClient_";
  protected final String TEXT_145 = ".commit();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\t\t\t\t\t  ";
  protected final String TEXT_147 = ".STATUS_CODE=0;" + NL + "\t\t\t\t\t\t\t  ";
  protected final String TEXT_148 = ".STATUS_CODE_INFO=0;" + NL + "\t\t\t\t\t\t\t  ";
  protected final String TEXT_149 = ".STATUS_MESSAGE=\"\";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_150 = NL + "\t\t\t\t\t\t} catch(uniserv.cliserv.mail.MailException ee) {" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"WS_ERROR_CODE\", -1);" + NL + "\t                        globalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_151 = "\");" + NL + "\t                        globalMap.put(\"WS_ERROR_MESSAGE\", ee.toString());" + NL + "\t\t\t\t\t\t\tmailClient_";
  protected final String TEXT_152 = ".rollback();" + NL + "\t\t\t\t\t\t\tthrow new RuntimeException(\"Unable to insert or update in the index pool: \" + ee.getMessage());" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}";
  protected final String TEXT_153 = NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tint retCode = mailClient_";
  protected final String TEXT_154 = ".mailUpdate(silentMailError_";
  protected final String TEXT_155 = ");" + NL + "\t\t\t\t\t\tif(retCode == 0) {" + NL + "\t\t\t\t\t\t    mailClient_";
  protected final String TEXT_156 = ".commit();" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_157 = NL + "\t\t\t\t\t\t      ";
  protected final String TEXT_158 = ".STATUS_CODE=0;" + NL + "\t\t\t\t\t\t      ";
  protected final String TEXT_159 = ".STATUS_CODE_INFO=0;" + NL + "\t\t\t\t\t\t      ";
  protected final String TEXT_160 = ".STATUS_MESSAGE=\"\";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tmailClient_";
  protected final String TEXT_162 = ".setArg(h_";
  protected final String TEXT_163 = ");" + NL + "\t\t\t\t\t\t\tretCode = mailClient_";
  protected final String TEXT_164 = ".mailInsert(mailError_";
  protected final String TEXT_165 = ");" + NL + "\t\t\t\t\t\t\tif(retCode == 0) {" + NL + "\t\t\t\t\t\t\t    mailClient_";
  protected final String TEXT_166 = ".commit();" + NL + "\t\t\t\t\t\t\t    ";
  protected final String TEXT_167 = NL + "\t\t\t\t\t\t\t      ";
  protected final String TEXT_168 = ".STATUS_CODE=0;" + NL + "\t\t\t\t\t\t\t      ";
  protected final String TEXT_169 = ".STATUS_CODE_INFO=0;" + NL + "\t\t\t\t\t\t\t      ";
  protected final String TEXT_170 = ".STATUS_MESSAGE=\"\";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_171 = NL + "\t\t\t\t\t\t\t    " + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_172 = NL + "\t\t\t\t\t\t\t     ";
  protected final String TEXT_173 = ".STATUS_CODE =((Integer)globalMap.get(\"RT_MAIL_STATUS_CODE\")).intValue();" + NL + "\t\t\t\t\t\t\t     ";
  protected final String TEXT_174 = ".STATUS_CODE_INFO=((Integer)globalMap.get(\"RT_MAIL_STATUS_CODE_INFO\")).intValue();" + NL + "\t\t\t\t\t\t\t     ";
  protected final String TEXT_175 = ".STATUS_MESSAGE=(String)globalMap.get(\"RT_MAIL_STATUS_MESSAGE\");" + NL + "\t\t\t\t\t\t\t    ";
  protected final String TEXT_176 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} catch(uniserv.cliserv.mail.MailException e) {" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tmailClient_";
  protected final String TEXT_177 = ".setArg(h_";
  protected final String TEXT_178 = ");" + NL + "\t\t\t\t\t\t\tmailClient_";
  protected final String TEXT_179 = ".mailInsert(mailError_";
  protected final String TEXT_180 = ");" + NL + "\t\t\t\t\t\t\tmailClient_";
  protected final String TEXT_181 = ".commit();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\t\t\t\t  ";
  protected final String TEXT_183 = ".STATUS_CODE=0;" + NL + "\t\t\t\t\t\t\t  ";
  protected final String TEXT_184 = ".STATUS_CODE_INFO=0;" + NL + "\t\t\t\t\t\t\t  ";
  protected final String TEXT_185 = ".STATUS_MESSAGE=\"\";" + NL + "\t\t\t\t\t\t\t ";
  protected final String TEXT_186 = NL + "\t\t\t\t\t\t} catch(uniserv.cliserv.mail.MailException ee) {" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"WS_ERROR_CODE\", -1);" + NL + "\t                        globalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_187 = "\");" + NL + "\t                        globalMap.put(\"WS_ERROR_MESSAGE\", ee.toString());" + NL + "\t\t\t\t\t\t\tmailClient_";
  protected final String TEXT_188 = ".rollback();" + NL + "\t\t\t\t\t\t\tthrow new RuntimeException(\"Unable to update or insert in the index pool: \" + ee.getMessage());" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}";
  protected final String TEXT_189 = NL + NL + NL;
  protected final String TEXT_190 = NL;
  protected final String TEXT_191 = NL + NL + "   ByteArrayOutputStream boss_";
  protected final String TEXT_192 = " = new ByteArrayOutputStream();" + NL + "   ObjectOutputStream dos_";
  protected final String TEXT_193 = " = new ObjectOutputStream(boss_";
  protected final String TEXT_194 = ");";
  protected final String TEXT_195 = NL + "   ";
  protected final String TEXT_196 = ".writeData(dos_";
  protected final String TEXT_197 = ");" + NL + "   dos_";
  protected final String TEXT_198 = ".close();" + NL + "   boss_";
  protected final String TEXT_199 = ".close();" + NL + "   status_";
  protected final String TEXT_200 = ".addOutputConnectionData(0, \"";
  protected final String TEXT_201 = "\", boss_";
  protected final String TEXT_202 = ".toByteArray());";
  protected final String TEXT_203 = "\t\t" + NL;
  protected final String TEXT_204 = NL + "} //if use_component_status_";
  protected final String TEXT_205 = NL;
  protected final String TEXT_206 = NL + NL + NL + NL;
  protected final String TEXT_207 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    

boolean has_out_res_component_state = false;
boolean has_out_list_count = false;


org.talend.core.model.process.IProcess process = node.getProcess();
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
    
}


    stringBuffer.append(TEXT_27);
    

List<String> UniservOutput=new ArrayList<String>();
UniservOutput.add("IN_NAME");
UniservOutput.add("IN_FIRST_NAME");
UniservOutput.add("IN_NAME_LINE");
UniservOutput.add("IN_COMPANY_NAME");
UniservOutput.add("IN_PERSON");
UniservOutput.add("IN_DEPARTMENT");
UniservOutput.add("IN_WEB_ADDR");
UniservOutput.add("IN_STR");
UniservOutput.add("IN_HNO");
UniservOutput.add("IN_STR_LINE");
UniservOutput.add("IN_ZIP");
UniservOutput.add("IN_CITY");
UniservOutput.add("IN_CITY_LINE");
UniservOutput.add("IN_COUNTRY_CODE");
UniservOutput.add("IN_POBOX");
UniservOutput.add("IN_FREE");
UniservOutput.add("IN_FREE2");
UniservOutput.add("IN_FREE3");
UniservOutput.add("IN_FREE4");
UniservOutput.add("IN_FREE5");
UniservOutput.add("IN_FREE6");
UniservOutput.add("IN_FREE7");
UniservOutput.add("IN_DATE");
UniservOutput.add("IN_PHONE");
UniservOutput.add("IN_GENDER");
UniservOutput.add("IN_ROLE");
UniservOutput.add("IN_EMAIL");
UniservOutput.add("IN_CODEPOOL");
UniservOutput.add("IN_DBREF");
UniservOutput.add("IN_DATA");

String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		List< ? extends IConnection> conns = node.getIncomingConnections();
		List<? extends IConnection> outConns = node.getOutgoingConnections("OUTPUT");
		IConnection outConn = null;
		for (IConnection conn : conns) {

			List<IMetadataColumn> columns = metadata.getListColumns();
			
			if (outConns != null) { // 4
				for (IConnection outConnTmp : outConns) { // 5

    stringBuffer.append(TEXT_28);
    stringBuffer.append(outConnTmp.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(outConnTmp.getName());
    stringBuffer.append(TEXT_30);
    
                    outConn = outConnTmp;
				} // end 5
			} // end 4
			

    stringBuffer.append(TEXT_31);
    
        	int sizeColumns = columns.size();
			for(int i=0; i<sizeColumns; i++) {//6
				if(UniservOutput.contains(columns.get(i).getLabel())) {//7

    stringBuffer.append(TEXT_32);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append((columns.get(i).getLabel()).toLowerCase());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_38);
    
						if(outConn != null){
						
    stringBuffer.append(TEXT_39);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_43);
    
						}
						
    stringBuffer.append(TEXT_44);
    
				} else { //7
					
					if(outConn != null){
					
    stringBuffer.append(TEXT_45);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_49);
    
					}
						
				} //7
			}//6

    stringBuffer.append(TEXT_50);
    
if(tRTOutputList != null && tRTOutputList.size() > 0)
{  

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
		if(outConn != null){
		
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
		}
		
    stringBuffer.append(TEXT_65);
    
}

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
				if("INSERT".equals(dataAction)) {

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
							if(outConn != null){
						  
    stringBuffer.append(TEXT_73);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_76);
    
							}
						  
    stringBuffer.append(TEXT_77);
    
								if(outConn != null){
						   
    stringBuffer.append(TEXT_78);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_81);
    
						  }
						  
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
				}

    
				else if("UPDATE".equals(dataAction)) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
							if(outConn != null){
					       
    stringBuffer.append(TEXT_89);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_92);
    
							  }
						    
    stringBuffer.append(TEXT_93);
    
								if(outConn != null){
						     
    stringBuffer.append(TEXT_94);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_97);
    
							   }
							  
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
				}

    
				else if("DELETE".equals(dataAction)) {

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
							if(outConn != null){
					        
    stringBuffer.append(TEXT_105);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_108);
    
							  }
						    
    stringBuffer.append(TEXT_109);
    
								if(outConn != null){
						      
    stringBuffer.append(TEXT_110);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_113);
    
						      }
					          
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    
				}

    
				else if("INSERT_OR_UPDATE".equals(dataAction)) {

    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
							 if(outConn != null){
					        
    stringBuffer.append(TEXT_121);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_124);
    
						     }
					        
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
    
								if(outConn != null){
						        
    stringBuffer.append(TEXT_131);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_134);
    
						        }
					            
    stringBuffer.append(TEXT_135);
    
								 if(outConn != null){
							   
    stringBuffer.append(TEXT_136);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_138);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_139);
    
								 }
							    
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
    
							  if(outConn != null){
						    
    stringBuffer.append(TEXT_146);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_149);
    
					        }
				            
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    
				}

    
				else if("UPDATE_OR_INSERT".equals(dataAction)) {

    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    
							 if(outConn != null){
					        
    stringBuffer.append(TEXT_157);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_159);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_160);
    
						      }
					        
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
    
								  if(outConn != null){
						        
    stringBuffer.append(TEXT_167);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_168);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_169);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_170);
    
						         }
					            
    stringBuffer.append(TEXT_171);
    
								  if(outConn != null){
							    
    stringBuffer.append(TEXT_172);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_173);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_174);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_175);
    
								  }
							    
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
    
							  if(outConn != null){
						    
    stringBuffer.append(TEXT_182);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_183);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_184);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_185);
    
							  }
						    
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    
				}

    stringBuffer.append(TEXT_189);
    
if(tRTOutputList != null && tRTOutputList.size() > 0)
{

    stringBuffer.append(TEXT_190);
    
    if(outConn != null){
   
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
    }
  
    
}                          

    stringBuffer.append(TEXT_203);
    
if(tRTOutputList != null && tRTOutputList.size() > 0)
{  

    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    
}

    stringBuffer.append(TEXT_206);
    
		}
	}
}

    stringBuffer.append(TEXT_207);
    return stringBuffer.toString();
  }
}
