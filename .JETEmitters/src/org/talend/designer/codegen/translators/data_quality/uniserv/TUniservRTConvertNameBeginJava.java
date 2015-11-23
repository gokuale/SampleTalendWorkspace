package org.talend.designer.codegen.translators.data_quality.uniserv;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;

public class TUniservRTConvertNameBeginJava
{
  protected static String nl;
  public static synchronized TUniservRTConvertNameBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniservRTConvertNameBeginJava result = new TUniservRTConvertNameBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "uniserv.cliserv.GenClient cnameClient_";
  protected final String TEXT_2 = " = null;" + NL + "uniserv.cliserv.Uniresult unires_";
  protected final String TEXT_3 = " = null;" + NL + "StringBuffer errmsg_";
  protected final String TEXT_4 = " = new StringBuffer();" + NL + "String langCode_";
  protected final String TEXT_5 = " = \"E\";" + NL + "" + NL + "java.util.Hashtable<String, String> h_";
  protected final String TEXT_6 = " = new java.util.Hashtable<String, String>();" + NL + "java.util.Vector<String> v_";
  protected final String TEXT_7 = " = new java.util.Vector<String>();" + NL + "" + NL + "String host_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ";" + NL + "int portNumber_";
  protected final String TEXT_10 = " = Integer.parseInt(";
  protected final String TEXT_11 = ");" + NL + "String service_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ";" + NL + "String resClassArg_";
  protected final String TEXT_14 = " = \"out_res_\" + ";
  protected final String TEXT_15 = " + \"_cl\";" + NL;
  protected final String TEXT_16 = NL + "\tint rejectClass_";
  protected final String TEXT_17 = " = Integer.parseInt(\"";
  protected final String TEXT_18 = "\");";
  protected final String TEXT_19 = NL + NL + "cnameClient_";
  protected final String TEXT_20 = " = new uniserv.cliserv.GenClient(uniserv.cliserv.GenClient.IGNORE_UNKNOWN_ARGUMENTS);" + NL + "try {" + NL + "\tunires_";
  protected final String TEXT_21 = " = cnameClient_";
  protected final String TEXT_22 = ".open(host_";
  protected final String TEXT_23 = ", portNumber_";
  protected final String TEXT_24 = ", service_";
  protected final String TEXT_25 = ");" + NL + "} catch (Exception ex) {" + NL + "\t   globalMap.put(\"WS_ERROR_CODE\", new Integer(-1));" + NL + "\t   globalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_26 = "\");" + NL + "\t   String serverData = \"Convert-name server on host \" + host_";
  protected final String TEXT_27 = " " + NL + "\t\t+ \" port \" + portNumber_";
  protected final String TEXT_28 = " + \" service \" + service_";
  protected final String TEXT_29 = " + \" \";" + NL + "\t" + NL + "\t   String msg = ex.getMessage();" + NL + "\t   if(msg == null) {" + NL + "\t\tmsg = ex.toString();" + NL + "\t   }" + NL + "\t   globalMap.put(\"WS_ERROR_MESSAGE\", serverData + msg);" + NL + "\t" + NL + "\t   throw new RuntimeException(msg);" + NL + "}" + NL + "if (unires_";
  protected final String TEXT_30 = ".getRetType() != uniserv.cliserv.GenClient.UNI_OK) {" + NL + "\tcnameClient_";
  protected final String TEXT_31 = ".getErrorMsg(unires_";
  protected final String TEXT_32 = ".getRetType(), unires_";
  protected final String TEXT_33 = ".getRetInfo(), " + NL + "\t\t\tlangCode_";
  protected final String TEXT_34 = ", errmsg_";
  protected final String TEXT_35 = ");" + NL + "" + NL + "\tglobalMap.put(\"WS_ERROR_CODE\", new Integer(unires_";
  protected final String TEXT_36 = ".getRetInfo()));" + NL + "\tglobalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_37 = "\");" + NL + "\t String serverData = \"Convert-name server on host \" + host_";
  protected final String TEXT_38 = " " + NL + "\t\t+ \" port \" + portNumber_";
  protected final String TEXT_39 = " + \" service \" + service_";
  protected final String TEXT_40 = " + \" \";" + NL + "\tglobalMap.put(\"WS_ERROR_MESSAGE\", serverData + errmsg_";
  protected final String TEXT_41 = ".toString());" + NL + "\t" + NL + "\tthrow new RuntimeException(\"Error code \" + unires_";
  protected final String TEXT_42 = ".getRetInfo() + \": \" + errmsg_";
  protected final String TEXT_43 = ".toString());" + NL + "} else {" + NL + "\tSystem.out.println(\"Successfully connected to service \" + service_";
  protected final String TEXT_44 = " + \" on host \" + host_";
  protected final String TEXT_45 = " + \" (port number \" + portNumber_";
  protected final String TEXT_46 = " + \")\");" + NL + "}" + NL + "" + NL + "//StringBuffer versionNumber_";
  protected final String TEXT_47 = " = new StringBuffer();" + NL + "//StringBuffer version_";
  protected final String TEXT_48 = " = new StringBuffer();" + NL + "" + NL + "//unires_";
  protected final String TEXT_49 = " = cnameClient_";
  protected final String TEXT_50 = ".getVersion(versionNumber_";
  protected final String TEXT_51 = ", version_";
  protected final String TEXT_52 = ");" + NL + "//if (unires_";
  protected final String TEXT_53 = ".getRetType() != uniserv.cliserv.GenClient.UNI_OK) {" + NL + "//    cnameClient_";
  protected final String TEXT_54 = ".getErrorMsg(unires_";
  protected final String TEXT_55 = ".getRetType(), unires_";
  protected final String TEXT_56 = ".getRetInfo(), " + NL + "//        langCode_";
  protected final String TEXT_57 = ", errmsg_";
  protected final String TEXT_58 = ");" + NL + "//\tSystem.err.println(\"Error code \" + unires_";
  protected final String TEXT_59 = ".getRetInfo() + \": \" + errmsg_";
  protected final String TEXT_60 = ".toString());" + NL + "//} else {" + NL + "//\tSystem.out.println(\"Version:\\n\" + version_";
  protected final String TEXT_61 = ".toString() + \"\\n\");" + NL + "//}" + NL;
  protected final String TEXT_62 = NL + "cnameClient_";
  protected final String TEXT_63 = ".setArg(uniserv.cliserv.Name.PAR_NAME_LASTFIRST, ";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL;
  protected final String TEXT_66 = NL + "cnameClient_";
  protected final String TEXT_67 = ".setArg(uniserv.cliserv.Name.PAR_NAME_FIRSTLAST, ";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + NL + "cnameClient_";
  protected final String TEXT_70 = ".setArg(uniserv.cliserv.Name.PAR_SPACED_REDUCES, \"";
  protected final String TEXT_71 = "\");" + NL + "cnameClient_";
  protected final String TEXT_72 = ".setArg(uniserv.cliserv.Name.PAR_LINEBREAKS, \"";
  protected final String TEXT_73 = "\");" + NL + "cnameClient_";
  protected final String TEXT_74 = ".setArg(uniserv.cliserv.Name.PAR_REF_PERSONS, \"";
  protected final String TEXT_75 = "\");" + NL + "cnameClient_";
  protected final String TEXT_76 = ".setArg(uniserv.cliserv.Name.PAR_REF_COMPANY, \"";
  protected final String TEXT_77 = "\");" + NL + "cnameClient_";
  protected final String TEXT_78 = ".setArg(uniserv.cliserv.Name.PAR_SALUTATION, \"";
  protected final String TEXT_79 = "\");" + NL + "cnameClient_";
  protected final String TEXT_80 = ".setArg(uniserv.cliserv.Name.PAR_STREET, \"";
  protected final String TEXT_81 = "\");" + NL + "cnameClient_";
  protected final String TEXT_82 = ".setArg(uniserv.cliserv.Name.PAR_CITY, \"";
  protected final String TEXT_83 = "\");" + NL + "" + NL + "cnameClient_";
  protected final String TEXT_84 = ".setArg(uniserv.cliserv.Name.PAR_NORM_OUTPUT, \"";
  protected final String TEXT_85 = "\");" + NL + "cnameClient_";
  protected final String TEXT_86 = ".setArg(uniserv.cliserv.Name.PAR_TRANS_UPPER_LOWER, \"";
  protected final String TEXT_87 = "\");" + NL + "cnameClient_";
  protected final String TEXT_88 = ".setArg(uniserv.cliserv.Name.PAR_NORM_SPEC_CHARS, \"";
  protected final String TEXT_89 = "\");" + NL;
  protected final String TEXT_90 = NL + "\tcnameClient_";
  protected final String TEXT_91 = ".setArg(uniserv.cliserv.Name.PAR_OUT_BAD_LINE_1, ";
  protected final String TEXT_92 = ");";
  protected final String TEXT_93 = NL + "\tcnameClient_";
  protected final String TEXT_94 = ".setArg(uniserv.cliserv.Name.PAR_OUT_BAD_LINE_2, ";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "\tcnameClient_";
  protected final String TEXT_97 = ".setArg(uniserv.cliserv.Name.PAR_OUT_BAD_LINE_3, ";
  protected final String TEXT_98 = ");";
  protected final String TEXT_99 = NL + "\tcnameClient_";
  protected final String TEXT_100 = ".setArg(uniserv.cliserv.Name.PAR_OUT_BAD_LINE_4, ";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "\tcnameClient_";
  protected final String TEXT_103 = ".setArg(uniserv.cliserv.Name.PAR_OUT_BAD_LINE_5, ";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = NL + "\tcnameClient_";
  protected final String TEXT_106 = ".setArg(uniserv.cliserv.Name.PAR_OUT_BAD_LINE_6, ";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = NL;
  protected final String TEXT_109 = NL + "\tcnameClient_";
  protected final String TEXT_110 = ".setArg(uniserv.cliserv.Name.PAR_FREE_FIELD_01, ";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "\tcnameClient_";
  protected final String TEXT_113 = ".setArg(uniserv.cliserv.Name.PAR_FREE_FIELD_02, ";
  protected final String TEXT_114 = ");";
  protected final String TEXT_115 = NL + "\tcnameClient_";
  protected final String TEXT_116 = ".setArg(uniserv.cliserv.Name.PAR_FREE_FIELD_03, ";
  protected final String TEXT_117 = ");";
  protected final String TEXT_118 = NL + "\tcnameClient_";
  protected final String TEXT_119 = ".setArg(uniserv.cliserv.Name.PAR_FREE_FIELD_04, ";
  protected final String TEXT_120 = ");";
  protected final String TEXT_121 = NL + "\tcnameClient_";
  protected final String TEXT_122 = ".setArg(uniserv.cliserv.Name.PAR_FREE_FIELD_05, ";
  protected final String TEXT_123 = ");";
  protected final String TEXT_124 = NL + "\tcnameClient_";
  protected final String TEXT_125 = ".setArg(uniserv.cliserv.Name.PAR_FREE_FIELD_06, ";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = NL + "\tcnameClient_";
  protected final String TEXT_128 = ".setArg(uniserv.cliserv.Name.PAR_FREE_FIELD_07, ";
  protected final String TEXT_129 = ");";
  protected final String TEXT_130 = NL + "\tcnameClient_";
  protected final String TEXT_131 = ".setArg(uniserv.cliserv.Name.PAR_FREE_FIELD_08, ";
  protected final String TEXT_132 = ");";
  protected final String TEXT_133 = NL + "\tcnameClient_";
  protected final String TEXT_134 = ".setArg(uniserv.cliserv.Name.PAR_FREE_FIELD_09, ";
  protected final String TEXT_135 = ");";
  protected final String TEXT_136 = NL + "\tcnameClient_";
  protected final String TEXT_137 = ".setArg(uniserv.cliserv.Name.PAR_FREE_FIELD_10, ";
  protected final String TEXT_138 = ");";
  protected final String TEXT_139 = NL + NL + "\tcnameClient_";
  protected final String TEXT_140 = ".setArg(uniserv.cliserv.Name.PAR_CACHE_SIZE, ";
  protected final String TEXT_141 = ");";
  protected final String TEXT_142 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String hostname = ElementParameterParser.getValue(node, "__HOSTNAME__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String service = ElementParameterParser.getValue(node, "__SERVICE__");

String useRejects = ElementParameterParser.getValue(node, "__USE_REJECTS__");
String rejectClass = ElementParameterParser.getValue(node, "__REJECTS_CLASS__");

String par_name_lastfirst = ElementParameterParser.getValue(node, "__PAR_NAME_LASTFIRST__");
String par_name_firstlast = ElementParameterParser.getValue(node, "__PAR_NAME_FIRSTLAST__");
String par_spaced_reduces= ElementParameterParser.getValue(node, "__PAR_SPACED_REDUCES__");
String par_linebreaks = ElementParameterParser.getValue(node, "__PAR_LINEBREAKS__");
String par_ref_persons = ElementParameterParser.getValue(node, "__PAR_REF_PERSONS__");
String par_ref_company = ElementParameterParser.getValue(node, "__PAR_REF_COMPANY__");
String par_salutation = ElementParameterParser.getValue(node, "__PAR_SALUTATION__");
String par_street = ElementParameterParser.getValue(node, "__PAR_STREET__");
String par_city = ElementParameterParser.getValue(node, "__PAR_CITY__");

String par_norm_output = ElementParameterParser.getValue(node, "__PAR_NORM_OUTPUT__");
String par_trans_upper_lower = ElementParameterParser.getValue(node, "__PAR_TRANS_UPPER_LOWER__");
String par_norm_spec_chars = ElementParameterParser.getValue(node, "__PAR_NORM_SPEC_CHARS__");

String par_out_bad_line_1 = ElementParameterParser.getValue(node, "__PAR_OUT_BAD_LINE_1__");
String par_out_bad_line_2 = ElementParameterParser.getValue(node, "__PAR_OUT_BAD_LINE_2__");
String par_out_bad_line_3 = ElementParameterParser.getValue(node, "__PAR_OUT_BAD_LINE_3__");
String par_out_bad_line_4 = ElementParameterParser.getValue(node, "__PAR_OUT_BAD_LINE_4__");
String par_out_bad_line_5 = ElementParameterParser.getValue(node, "__PAR_OUT_BAD_LINE_5__");
String par_out_bad_line_6 = ElementParameterParser.getValue(node, "__PAR_OUT_BAD_LINE_6__");

String par_free_field_01 = ElementParameterParser.getValue(node, "__PAR_FREE_FIELD_01__");
String par_free_field_02 = ElementParameterParser.getValue(node, "__PAR_FREE_FIELD_02__");
String par_free_field_03 = ElementParameterParser.getValue(node, "__PAR_FREE_FIELD_03__");
String par_free_field_04 = ElementParameterParser.getValue(node, "__PAR_FREE_FIELD_04__");
String par_free_field_05 = ElementParameterParser.getValue(node, "__PAR_FREE_FIELD_05__");
String par_free_field_06 = ElementParameterParser.getValue(node, "__PAR_FREE_FIELD_06__");
String par_free_field_07 = ElementParameterParser.getValue(node, "__PAR_FREE_FIELD_07__");
String par_free_field_08 = ElementParameterParser.getValue(node, "__PAR_FREE_FIELD_08__");
String par_free_field_09 = ElementParameterParser.getValue(node, "__PAR_FREE_FIELD_09__");
String par_free_field_10 = ElementParameterParser.getValue(node, "__PAR_FREE_FIELD_10__");

String par_cache_size = ElementParameterParser.getValue(node, "__PAR_CACHE_SIZE__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(service);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(service);
    stringBuffer.append(TEXT_15);
    
if ("true".equals(useRejects)) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(rejectClass);
    stringBuffer.append(TEXT_18);
    
}

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
if (par_name_lastfirst != null && par_name_lastfirst.length() >0) {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(par_name_lastfirst);
    stringBuffer.append(TEXT_64);
    
}

    stringBuffer.append(TEXT_65);
    
if (par_name_firstlast != null && par_name_firstlast.length() > 0) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(par_name_firstlast);
    stringBuffer.append(TEXT_68);
    
}

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(par_spaced_reduces);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(par_linebreaks);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(par_ref_persons);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(par_ref_company);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(par_salutation);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(par_street);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(par_city);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(par_norm_output);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(par_trans_upper_lower);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(par_norm_spec_chars);
    stringBuffer.append(TEXT_89);
    
if (par_out_bad_line_1 != null  && par_out_bad_line_1.length() > 0) {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(par_out_bad_line_1);
    stringBuffer.append(TEXT_92);
    
}

    
if (par_out_bad_line_2 != null && par_out_bad_line_2.length() > 0) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(par_out_bad_line_2);
    stringBuffer.append(TEXT_95);
    
}

    
if (par_out_bad_line_3 != null && par_out_bad_line_3.length() > 0) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(par_out_bad_line_3);
    stringBuffer.append(TEXT_98);
    
}

    
if (par_out_bad_line_4 != null && par_out_bad_line_4.length() > 0) {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(par_out_bad_line_4);
    stringBuffer.append(TEXT_101);
    
}

    
if (par_out_bad_line_5 != null && par_out_bad_line_5.length() > 0) {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(par_out_bad_line_5);
    stringBuffer.append(TEXT_104);
    
}

    
if (par_out_bad_line_6 != null && par_out_bad_line_6.length() > 0) {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(par_out_bad_line_6);
    stringBuffer.append(TEXT_107);
    
}

    stringBuffer.append(TEXT_108);
    
if (par_free_field_01 != null && par_free_field_01.length() > 0) {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(par_free_field_01);
    stringBuffer.append(TEXT_111);
    
}

    
if (par_free_field_02 != null && par_free_field_02.length() > 0) {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(par_free_field_02);
    stringBuffer.append(TEXT_114);
    
}

    
if (par_free_field_03 != null && par_free_field_03.length() > 0) {

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(par_free_field_03);
    stringBuffer.append(TEXT_117);
    
}

    
if (par_free_field_04 != null && par_free_field_04.length() > 0) {

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(par_free_field_04);
    stringBuffer.append(TEXT_120);
    
}

    
if (par_free_field_05 != null && par_free_field_05.length() > 0) {

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(par_free_field_05);
    stringBuffer.append(TEXT_123);
    
}

    
if (par_free_field_06 != null && par_free_field_06.length() > 0) {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(par_free_field_06);
    stringBuffer.append(TEXT_126);
    
}

    
if (par_free_field_07 != null && par_free_field_07.length() > 0) {

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(par_free_field_07);
    stringBuffer.append(TEXT_129);
    
}

    
if (par_free_field_08 != null && par_free_field_08.length() > 0) {

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(par_free_field_08);
    stringBuffer.append(TEXT_132);
    
}

    
if (par_free_field_09 != null && par_free_field_09.length() > 0) {

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(par_free_field_09);
    stringBuffer.append(TEXT_135);
    
}

    
if (par_free_field_10 != null && par_free_field_10.length() > 0) {

    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(par_free_field_10);
    stringBuffer.append(TEXT_138);
    
}

    
if (par_cache_size != null && par_cache_size.length() > 0) {

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(par_cache_size);
    stringBuffer.append(TEXT_141);
    
}

    stringBuffer.append(TEXT_142);
    return stringBuffer.toString();
  }
}
