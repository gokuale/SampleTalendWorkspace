package org.talend.designer.codegen.translators.data_quality.uniserv;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;

public class TUniservRTPostBeginJava
{
  protected static String nl;
  public static synchronized TUniservRTPostBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniservRTPostBeginJava result = new TUniservRTPostBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "uniserv.cliserv.GenClient postClient_";
  protected final String TEXT_2 = " = null;" + NL + "java.util.Hashtable<String,String> h_";
  protected final String TEXT_3 = "=new java.util.Hashtable<String,String>();" + NL + "java.util.Vector<String> v_";
  protected final String TEXT_4 = "=new java.util.Vector<String>();" + NL + "String postServer_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "int portNumber_";
  protected final String TEXT_7 = " = Integer.parseInt(";
  protected final String TEXT_8 = ");" + NL + "String service_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = ";" + NL + "StringBuffer msg_";
  protected final String TEXT_11 = " =new StringBuffer();" + NL + "String filename_";
  protected final String TEXT_12 = "=";
  protected final String TEXT_13 = ";" + NL;
  protected final String TEXT_14 = NL + "   java.io.PrintWriter printWriter_";
  protected final String TEXT_15 = "=new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(filename_";
  protected final String TEXT_16 = ")));";
  protected final String TEXT_17 = NL + NL + NL + "boolean use_component_status_";
  protected final String TEXT_18 = "_begin = false;" + NL + NL;
  protected final String TEXT_19 = NL + "WSStatus ws_status_";
  protected final String TEXT_20 = "_begin = (WSStatus)globalMap.get(\"WS_STATUS\");" + NL + "ComponentStatus status_";
  protected final String TEXT_21 = "_begin = null;" + NL + "" + NL + "if(ws_status_";
  protected final String TEXT_22 = "_begin != null)" + NL + "{" + NL + "   status_";
  protected final String TEXT_23 = "_begin = ws_status_";
  protected final String TEXT_24 = "_begin.getComponentStatus(\"";
  protected final String TEXT_25 = "\");" + NL + "" + NL + "   if(status_";
  protected final String TEXT_26 = "_begin != null)" + NL + "   {" + NL + "      use_component_status_";
  protected final String TEXT_27 = "_begin = true;" + NL + "   }" + NL + "}";
  protected final String TEXT_28 = NL + NL + NL + "uniserv.cliserv.Uniresult myResult_";
  protected final String TEXT_29 = " = null;" + NL + "" + NL + "" + NL + "if(!use_component_status_";
  protected final String TEXT_30 = "_begin)" + NL + "{" + NL + "\tpostClient_";
  protected final String TEXT_31 = " = new uniserv.cliserv.GenClient(uniserv.cliserv.GenClient.IGNORE_UNKNOWN_ARGUMENTS);" + NL + "        class ShutdownHook";
  protected final String TEXT_32 = " extends Thread" + NL + "        {" + NL + "           uniserv.cliserv.GenClient m_guarded_client = null;" + NL + "" + NL + "           public ShutdownHook";
  protected final String TEXT_33 = "(uniserv.cliserv.GenClient client)" + NL + "           {" + NL + "              m_guarded_client = client;" + NL + "           }" + NL + "" + NL + "           public void run()" + NL + "           {" + NL + "              try" + NL + "              {" + NL + "                 if(m_guarded_client != null)" + NL + "                 {" + NL + "                    m_guarded_client.close();" + NL + "                 }" + NL + "              }" + NL + "              catch (Exception ex)" + NL + "              {" + NL + "                  // do nothing" + NL + "              }" + NL + "           }" + NL + "        }" + NL + "" + NL + "        Runtime.getRuntime().addShutdownHook(new ShutdownHook";
  protected final String TEXT_34 = "(postClient_";
  protected final String TEXT_35 = "));" + NL + "    " + NL + "        try {" + NL + "        myResult_";
  protected final String TEXT_36 = "=postClient_";
  protected final String TEXT_37 = ".open( postServer_";
  protected final String TEXT_38 = ", portNumber_";
  protected final String TEXT_39 = ", service_";
  protected final String TEXT_40 = ");" + NL + "        } catch (Exception ex) {" + NL + "        \tglobalMap.put(\"WS_ERROR_CODE\", new Integer(-1));" + NL + "        \tglobalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_41 = "\");" + NL + "        \tString serverData = \"Post server on host \" + postServer_";
  protected final String TEXT_42 = " " + NL + "        \t\t+ \" port \" + portNumber_";
  protected final String TEXT_43 = " + \" service \" + service_";
  protected final String TEXT_44 = " + \" \";" + NL + "        \t" + NL + "        \tString msg = ex.getMessage();" + NL + "        \tif(msg == null) {" + NL + "        \t\tmsg = ex.toString();" + NL + "        \t}" + NL + "        \tglobalMap.put(\"WS_ERROR_MESSAGE\", serverData + msg);" + NL + "        \t" + NL + "        \tthrow new RuntimeException(msg);" + NL + "        }" + NL + "\tpostClient_";
  protected final String TEXT_45 = ".setArg(\"par_list_resolve\", \"";
  protected final String TEXT_46 = "\");";
  protected final String TEXT_47 = NL + "\tpostClient_";
  protected final String TEXT_48 = ".setArg(\"par_case\", \"";
  protected final String TEXT_49 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_50 = ".setArg(\"par_country\", ";
  protected final String TEXT_51 = ");" + NL + "\tpostClient_";
  protected final String TEXT_52 = ".setArg(\"par_special_chars\", \"";
  protected final String TEXT_53 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_54 = ".setArg(\"par_conv_alnum\", \"";
  protected final String TEXT_55 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_56 = ".setArg(\"par_norm_output\", \"";
  protected final String TEXT_57 = "\");";
  protected final String TEXT_58 = NL + "\tpostClient_";
  protected final String TEXT_59 = ".setArg(\"par_language\", \"";
  protected final String TEXT_60 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_61 = ".setArg(\"par_client_codepage\", ";
  protected final String TEXT_62 = ");" + NL + "\tpostClient_";
  protected final String TEXT_63 = ".setArg(\"par_len_out_line\", ";
  protected final String TEXT_64 = ");" + NL + "\tpostClient_";
  protected final String TEXT_65 = ".setArg(\"par_city_len\", ";
  protected final String TEXT_66 = ");" + NL + "\tpostClient_";
  protected final String TEXT_67 = ".setArg(\"par_str_len\", ";
  protected final String TEXT_68 = ");" + NL + "\tpostClient_";
  protected final String TEXT_69 = ".setArg(\"par_city_abbrev\", \"";
  protected final String TEXT_70 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_71 = ".setArg(\"par_str_abbrev\", \"";
  protected final String TEXT_72 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_73 = ".setArg(\"par_alternative_city\", \"";
  protected final String TEXT_74 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_75 = ".setArg(\"par_alternative_str\", \"";
  protected final String TEXT_76 = "\");";
  protected final String TEXT_77 = NL + "\tpostClient_";
  protected final String TEXT_78 = ".setArg(\"par_zip_hno\", \"";
  protected final String TEXT_79 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_80 = ".setArg(\"par_hno_confirmed\", \"";
  protected final String TEXT_81 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_82 = ".setArg(\"par_check_pobox\", \"";
  protected final String TEXT_83 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_84 = ".setArg(\"par_business_check\", \"";
  protected final String TEXT_85 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_86 = ".setArg(\"par_business_fetch\", \"";
  protected final String TEXT_87 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_88 = ".setArg(\"par_str_mval\", ";
  protected final String TEXT_89 = ");" + NL + "\tpostClient_";
  protected final String TEXT_90 = ".setArg(\"par_check_str\", \"";
  protected final String TEXT_91 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_92 = ".setArg(\"par_str_type\", \"";
  protected final String TEXT_93 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_94 = ".setArg(\"par_str_main_type\", \"";
  protected final String TEXT_95 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_96 = ".setArg(\"par_ref\", \"";
  protected final String TEXT_97 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_98 = ".setArg(\"par_key_word\", \"";
  protected final String TEXT_99 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_100 = ".setArg(\"par_city_mval\", ";
  protected final String TEXT_101 = ");" + NL + "\tpostClient_";
  protected final String TEXT_102 = ".setArg(\"par_out_city\", \"";
  protected final String TEXT_103 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_104 = ".setArg(\"par_suppress_district_equal\", \"";
  protected final String TEXT_105 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_106 = ".setArg(\"par_use_city\", \"";
  protected final String TEXT_107 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_108 = ".setArg(\"par_zip_full\", \"";
  protected final String TEXT_109 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_110 = ".setArg(\"par_zip_separator\", \"";
  protected final String TEXT_111 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_112 = ".setArg(\"par_bulk_purchaser\", \"";
  protected final String TEXT_113 = "\");";
  protected final String TEXT_114 = NL + "\tpostClient_";
  protected final String TEXT_115 = ".setArg(\"par_check_address\", \"";
  protected final String TEXT_116 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_117 = ".setArg(\"par_pos_zip\", \"";
  protected final String TEXT_118 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_119 = ".setArg(\"par_pos_city\", \"";
  protected final String TEXT_120 = "\");";
  protected final String TEXT_121 = NL + "\tpostClient_";
  protected final String TEXT_122 = ".setArg(\"par_insuff_result\", \"";
  protected final String TEXT_123 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_124 = ".setArg(\"par_untie_range\", ";
  protected final String TEXT_125 = ");" + NL + "\tpostClient_";
  protected final String TEXT_126 = ".setArg(\"par_dpv\", \"";
  protected final String TEXT_127 = "\");" + NL + "\tpostClient_";
  protected final String TEXT_128 = ".setArg(\"par_rdi\", \"";
  protected final String TEXT_129 = "\");";
  protected final String TEXT_130 = NL + "\tpostClient_";
  protected final String TEXT_131 = ".setArg(\"par_sel_list_max\", ";
  protected final String TEXT_132 = ");";
  protected final String TEXT_133 = NL + NL + "if(myResult_";
  protected final String TEXT_134 = ".getRetType()!=uniserv.cliserv.GenClient.UNI_OK){" + NL + "\tpostClient_";
  protected final String TEXT_135 = ".getErrorMsg(myResult_";
  protected final String TEXT_136 = ".getRetType()," + NL + "\t\t\tmyResult_";
  protected final String TEXT_137 = ".getRetInfo(),\"E\",msg_";
  protected final String TEXT_138 = ");" + NL + "\t" + NL + "\tglobalMap.put(\"WS_ERROR_CODE\", new Integer(myResult_";
  protected final String TEXT_139 = ".getRetInfo()));" + NL + "\tglobalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_140 = "\");" + NL + "\tString serverData = \"Post server on host \" + postServer_";
  protected final String TEXT_141 = " " + NL + "\t\t+ \" port \" + portNumber_";
  protected final String TEXT_142 = " + \" service \" + service_";
  protected final String TEXT_143 = " + \" \";" + NL + "\tglobalMap.put(\"WS_ERROR_MESSAGE\", serverData + msg_";
  protected final String TEXT_144 = ".toString());" + NL + "\t" + NL + "\tthrow new RuntimeException(msg_";
  protected final String TEXT_145 = ".toString());" + NL + "}else{" + NL + "\tSystem.out.println(\"Connection to Postal Validation established on host \"+postServer_";
  protected final String TEXT_146 = "+\" with id \"+portNumber_";
  protected final String TEXT_147 = ");" + NL + "}" + NL + "" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String hostname = ElementParameterParser.getValue(node, "__HOSTNAME__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String service = ElementParameterParser.getValue(node, "__SERVICE__");
String file_ambiguous = ElementParameterParser.getValue(node, "__FILE_AMBIGUOUS__");


String charset_case = ElementParameterParser.getValue(node, "__CHARSET_CASE__");
String length_abbrev_lang = ElementParameterParser.getValue(node, "__LENGTH_ABBREV_LANG__");
String ctrl_element = ElementParameterParser.getValue(node, "__CTRL_ELEMENT__");
String analyze_process = ElementParameterParser.getValue(node, "__ANALYZE_PROCESS__");
String misc = ElementParameterParser.getValue(node, "__MISC__");
String ambiguous = ElementParameterParser.getValue(node, "__AMBIGUOUS__");

String par_case = ElementParameterParser.getValue(node, "__PAR_CASE__");
String par_country = ElementParameterParser.getValue(node, "__PAR_COUNTRY__");
String par_special_chars = ElementParameterParser.getValue(node, "__PAR_SPECIAL_CHARS__");
String par_conv_alnum = ElementParameterParser.getValue(node, "__PAR_CONV_ALNUM__");
String par_norm_output = ElementParameterParser.getValue(node, "__PAR_NORM_OUTPUT__");

String par_language = ElementParameterParser.getValue(node, "__PAR_LANGUAGE__");
String par_client_codepage = ElementParameterParser.getValue(node, "__PAR_CLIENT_CODEPAGE__");
String par_len_out_line = ElementParameterParser.getValue(node, "__PAR_LEN_OUT_LINE__");
String par_city_len = ElementParameterParser.getValue(node, "__PAR_CITY_LEN__");
String par_str_len = ElementParameterParser.getValue(node, "__PAR_STR_LEN__");
String par_city_abbrev = ElementParameterParser.getValue(node, "__PAR_CITY_ABBREV__");
String par_str_abbrev = ElementParameterParser.getValue(node, "__PAR_STR_ABBREV__");
String par_alternative_city = ElementParameterParser.getValue(node, "__PAR_ALTERNATIVE_CITY__");
String par_alternative_str = ElementParameterParser.getValue(node, "__PAR_ALTERNATIVE_STR__");

String par_list_resolve = ElementParameterParser.getValue(node, "__PAR_LIST_RESOLVE__");
String par_zip_hno = ElementParameterParser.getValue(node, "__PAR_ZIP_HNO__");
String par_hno_confirmed = ElementParameterParser.getValue(node, "__PAR_HNO_CONFIRMED__");
String par_check_pobox = ElementParameterParser.getValue(node, "__PAR_CHECK_POBOX__");
String par_business_check = ElementParameterParser.getValue(node, "__PAR_BUSINESS_CHECK__");
String par_business_fetch = ElementParameterParser.getValue(node, "__PAR_BUSINESS_FETCH__");
String par_str_mval = ElementParameterParser.getValue(node, "__PAR_STR_MVAL__");
String par_check_str = ElementParameterParser.getValue(node, "__PAR_CHECK_STR__");
String par_str_type = ElementParameterParser.getValue(node, "__PAR_STR_TYPE__");
String par_str_main_type = ElementParameterParser.getValue(node, "__PAR_STR_MAIN_TYPE__");
String par_ref = ElementParameterParser.getValue(node, "__PAR_REF__");
String par_key_word = ElementParameterParser.getValue(node, "__PAR_KEY_WORD__");
String par_city_mval = ElementParameterParser.getValue(node, "__PAR_CITY_MVAL__");
String par_out_city = ElementParameterParser.getValue(node, "__PAR_OUT_CITY__");
String par_suppress_district_equal = ElementParameterParser.getValue(node, "__PAR_SUPPRESS_DISTRICT_EQUAL__");
String par_use_city = ElementParameterParser.getValue(node, "__PAR_USE_CITY__");
String par_zip_full = ElementParameterParser.getValue(node, "__PAR_ZIP_FULL__");
String par_zip_separator = ElementParameterParser.getValue(node, "__PAR_ZIP_SEPARATOR__");
String par_bulk_purchaser = ElementParameterParser.getValue(node, "__PAR_BULK_PURCHASER__");

String par_check_address = ElementParameterParser.getValue(node, "__PAR_CHECK_ADDRESS__");
String par_pos_zip = ElementParameterParser.getValue(node, "__PAR_POS_ZIP__");
String par_pos_city = ElementParameterParser.getValue(node, "__PAR_POS_CITY__");

String par_insuff_result = ElementParameterParser.getValue(node, "__PAR_INSUFF_RESULT__");
String par_untie_range = ElementParameterParser.getValue(node, "__PAR_UNTIE_RANGE__");
String par_dpv = ElementParameterParser.getValue(node, "__PAR_DPV__");
String par_rdi = ElementParameterParser.getValue(node, "__PAR_RDI__");

String par_sel_list_max = ElementParameterParser.getValue(node, "__PAR_SEL_LIST_MAX__");


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(service);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(file_ambiguous);
    stringBuffer.append(TEXT_13);
    
if(ElementParameterParser.getValue(node, "__USE_FILE_AMBIGUOUS__").equals("true"))
{

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
IProcess process = node.getProcess();
java.util.List<INode> tRTOutputList = (java.util.List<INode>)process.getNodesOfType("tRTOutput");

if(tRTOutputList != null && tRTOutputList.size() > 0)
{  

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
    
}

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
    stringBuffer.append(par_list_resolve);
    stringBuffer.append(TEXT_46);
    
	if("true".equals(charset_case)) {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(par_case);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(par_country);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(par_special_chars);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(par_conv_alnum);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(par_norm_output);
    stringBuffer.append(TEXT_57);
    
}
if("true".equals(length_abbrev_lang)) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(par_language);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(par_client_codepage);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(par_len_out_line);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(par_city_len);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(par_str_len);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(par_city_abbrev);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(par_str_abbrev);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(par_alternative_city);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(par_alternative_str);
    stringBuffer.append(TEXT_76);
    
}
if("true".equals(ctrl_element)) {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(par_zip_hno);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(par_hno_confirmed);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(par_check_pobox);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(par_business_check);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(par_business_fetch);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(par_str_mval);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(par_check_str);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(par_str_type);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(par_str_main_type);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(par_ref);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(par_key_word);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(par_city_mval);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(par_out_city);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(par_suppress_district_equal);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(par_use_city);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(par_zip_full);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(par_zip_separator);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(par_bulk_purchaser);
    stringBuffer.append(TEXT_113);
    
}

if("true".equals(analyze_process)) {

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(par_check_address);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(par_pos_zip);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(par_pos_city);
    stringBuffer.append(TEXT_120);
    
}
if("true".equals(misc)) {

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(par_insuff_result);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(par_untie_range);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(par_dpv);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(par_rdi);
    stringBuffer.append(TEXT_129);
    
}
if("true".equals(ambiguous)) {

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(par_sel_list_max);
    stringBuffer.append(TEXT_132);
    
}

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
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
    return stringBuffer.toString();
  }
}
