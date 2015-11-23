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
import java.util.ArrayList;

public class TUniservRTMailSearchBeginJava
{
  protected static String nl;
  public static synchronized TUniservRTMailSearchBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniservRTMailSearchBeginJava result = new TUniservRTMailSearchBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "String hostname_";
  protected final String TEXT_2 = "=";
  protected final String TEXT_3 = ";" + NL + "String service_";
  protected final String TEXT_4 = "=";
  protected final String TEXT_5 = ";" + NL + "int port_";
  protected final String TEXT_6 = "=Integer.parseInt(";
  protected final String TEXT_7 = ");" + NL + "StringBuffer msg_";
  protected final String TEXT_8 = " =new StringBuffer();" + NL + "" + NL + "boolean use_component_status_";
  protected final String TEXT_9 = "_begin = false;" + NL + NL;
  protected final String TEXT_10 = NL + "WSStatus ws_status_";
  protected final String TEXT_11 = "_begin = (WSStatus)globalMap.get(\"WS_STATUS\");" + NL + "ComponentStatus status_";
  protected final String TEXT_12 = "_begin = null;" + NL + "" + NL + "if(ws_status_";
  protected final String TEXT_13 = "_begin != null)" + NL + "{" + NL + "   status_";
  protected final String TEXT_14 = "_begin = ws_status_";
  protected final String TEXT_15 = "_begin.getComponentStatus(\"";
  protected final String TEXT_16 = "\");" + NL + "" + NL + "   if(status_";
  protected final String TEXT_17 = "_begin != null)" + NL + "   {" + NL + "      use_component_status_";
  protected final String TEXT_18 = "_begin = true;" + NL + "   }" + NL + "}";
  protected final String TEXT_19 = NL + NL + "java.util.Hashtable<String, String> h_";
  protected final String TEXT_20 = " = new java.util.Hashtable<String, String>();" + NL + "java.util.Hashtable<String, String> [] htable_";
  protected final String TEXT_21 = " = new java.util.Hashtable[";
  protected final String TEXT_22 = "];" + NL + "java.util.Vector<String> v_";
  protected final String TEXT_23 = " = new java.util.Vector<String>();" + NL + "uniserv.cliserv.GenClient mailClient_";
  protected final String TEXT_24 = " = null;" + NL + "" + NL + "uniserv.cliserv.Uniresult myResult_";
  protected final String TEXT_25 = " = null;" + NL + "" + NL + "" + NL + "" + NL + "if(!use_component_status_";
  protected final String TEXT_26 = "_begin)" + NL + "{" + NL + "    try {" + NL + "    \tmailClient_";
  protected final String TEXT_27 = " = new uniserv.cliserv.GenClient(uniserv.cliserv.GenClient.IGNORE_UNKNOWN_ARGUMENTS);" + NL + "\t   myResult_";
  protected final String TEXT_28 = " = mailClient_";
  protected final String TEXT_29 = ".open(hostname_";
  protected final String TEXT_30 = ", port_";
  protected final String TEXT_31 = ", service_";
  protected final String TEXT_32 = ");" + NL + "\t} catch (Exception ex) {" + NL + "\t   globalMap.put(\"WS_ERROR_CODE\", new Integer(-1));" + NL + "\t   globalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_33 = "\");" + NL + "\t   String serverData = \"Mail server on host \" + hostname_";
  protected final String TEXT_34 = " " + NL + "\t\t+ \" port \" + port_";
  protected final String TEXT_35 = " + \" service \" + service_";
  protected final String TEXT_36 = " + \" \";" + NL + "\t" + NL + "\t   String msg = ex.getMessage();" + NL + "\t   if(msg == null) {" + NL + "\t\tmsg = ex.toString();" + NL + "\t   }" + NL + "\t   globalMap.put(\"WS_ERROR_MESSAGE\", serverData + msg);" + NL + "\t" + NL + "\t   throw new RuntimeException(msg);" + NL + "\t}" + NL + "" + NL + "    class ShutdownHook";
  protected final String TEXT_37 = " extends Thread" + NL + "    {" + NL + "        uniserv.cliserv.GenClient m_guarded_client = null;" + NL + "" + NL + "        public ShutdownHook";
  protected final String TEXT_38 = "(uniserv.cliserv.GenClient client)" + NL + "        {" + NL + "            m_guarded_client = client;" + NL + "        }" + NL + "" + NL + "        public void run()" + NL + "        {" + NL + "           try" + NL + "           {" + NL + "              if(m_guarded_client != null)" + NL + "              {" + NL + "                  m_guarded_client.close();" + NL + "              }" + NL + "           }" + NL + "           catch (Exception ex)" + NL + "           {" + NL + "                  // do nothing" + NL + "           }" + NL + "       }" + NL + "   }" + NL + "" + NL + "   Runtime.getRuntime().addShutdownHook(new ShutdownHook";
  protected final String TEXT_39 = "(mailClient_";
  protected final String TEXT_40 = "));" + NL + "" + NL + "" + NL + "   mailClient_";
  protected final String TEXT_41 = ".setArg(\"par_list_max\", ";
  protected final String TEXT_42 = ");" + NL + "   mailClient_";
  protected final String TEXT_43 = ".setArg(\"par_evalue_tab\", ";
  protected final String TEXT_44 = ");" + NL + "   mailClient_";
  protected final String TEXT_45 = ".setArg(\"par_min_mval\", ";
  protected final String TEXT_46 = ");" + NL + "   mailClient_";
  protected final String TEXT_47 = ".setArg(\"par_date_format\", ";
  protected final String TEXT_48 = ");" + NL + "   mailClient_";
  protected final String TEXT_49 = ".setArg(\"par_symmetric\", \"";
  protected final String TEXT_50 = "\");" + NL + "   mailClient_";
  protected final String TEXT_51 = ".setArg(\"par_time_out\", ";
  protected final String TEXT_52 = ");" + NL + "   mailClient_";
  protected final String TEXT_53 = ".setArg(\"par_data_format\", ";
  protected final String TEXT_54 = ");" + NL + "   mailClient_";
  protected final String TEXT_55 = ".setArg(\"par_accumulate\", \"";
  protected final String TEXT_56 = "\"); " + NL + "   mailClient_";
  protected final String TEXT_57 = ".setArg(\"par_max_simils\", ";
  protected final String TEXT_58 = ");" + NL + "   //mailClient_";
  protected final String TEXT_59 = ".setArg(\"par_strict_search\", \"";
  protected final String TEXT_60 = "\");" + NL + "   mailClient_";
  protected final String TEXT_61 = ".setArg(\"par_rate_gender\", \"";
  protected final String TEXT_62 = "\");" + NL + "   " + NL + "   if(myResult_";
  protected final String TEXT_63 = ".getRetType()!=uniserv.cliserv.GenClient.UNI_OK){" + NL + "\t\tmailClient_";
  protected final String TEXT_64 = ".getErrorMsg(myResult_";
  protected final String TEXT_65 = ".getRetType()," + NL + "\t\t\t\tmyResult_";
  protected final String TEXT_66 = ".getRetInfo(),\"E\",msg_";
  protected final String TEXT_67 = ");" + NL + "\t\t" + NL + "\t\tglobalMap.put(\"WS_ERROR_CODE\", new Integer(myResult_";
  protected final String TEXT_68 = ".getRetInfo()));" + NL + "\t\tglobalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_69 = "\");" + NL + "\t\tString serverData = \"Mail server on host \" + hostname_";
  protected final String TEXT_70 = " " + NL + "\t\t\t+ \" port \" + port_";
  protected final String TEXT_71 = " + \" service \" + service_";
  protected final String TEXT_72 = " + \" \";" + NL + "\t\tglobalMap.put(\"WS_ERROR_MESSAGE\", serverData + msg_";
  protected final String TEXT_73 = ".toString());" + NL + "\t\t" + NL + "\t\tthrow new RuntimeException(msg_";
  protected final String TEXT_74 = ".toString());" + NL + "\t}else{" + NL + "\t\tSystem.out.println(\"Connection to Mail Server established on host \"+ hostname_";
  protected final String TEXT_75 = "+\" with id \"+port_";
  protected final String TEXT_76 = ");" + NL + "\t}" + NL + "" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

    

String hostname = ElementParameterParser.getValue(node, "__HOSTNAME__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String service = ElementParameterParser.getValue(node, "__SERVICE__");
int duplicate = Integer.parseInt(ElementParameterParser.getValue(node, "__DUPLICATE__"));


String par_list_max = ElementParameterParser.getValue(node, "__PAR_LIST_MAX__");
String par_evalue_tab = ElementParameterParser.getValue(node, "__PAR_EVALUE_TAB__");
String par_min_mval = ElementParameterParser.getValue(node, "__PAR_MIN_MVAL__");
String par_date_format = ElementParameterParser.getValue(node, "__PAR_DATE_FORMAT__");
String par_symmetric = ElementParameterParser.getValue(node, "__PAR_SYMMETRIC__");
String par_time_out = ElementParameterParser.getValue(node, "__PAR_TIME_OUT__");
String par_data_format = ElementParameterParser.getValue(node, "__PAR_DATA_FORMAT__");
String par_accumulate = ElementParameterParser.getValue(node, "__PAR_ACCUMULATE__");
String par_max_simils = ElementParameterParser.getValue(node, "__PAR_MAX_SIMILS__");
String par_strict_search = ElementParameterParser.getValue(node, "__PAR_STRICT_SEARCH__");
String par_rate_gender = ElementParameterParser.getValue(node, "__PAR_RATE_GENDER__");


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(service);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
IProcess process = node.getProcess();
java.util.List<INode> tRTOutputList = (java.util.List<INode>)process.getNodesOfType("tRTOutput");

if(tRTOutputList != null && tRTOutputList.size() > 0)
{  

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
    
}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(duplicate==0?1000:duplicate);
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
    stringBuffer.append(par_list_max);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(par_evalue_tab);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(par_min_mval);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(par_date_format);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(par_symmetric);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(par_time_out);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(par_data_format);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(par_accumulate);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(par_max_simils);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(par_strict_search);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(par_rate_gender);
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
    return stringBuffer.toString();
  }
}
