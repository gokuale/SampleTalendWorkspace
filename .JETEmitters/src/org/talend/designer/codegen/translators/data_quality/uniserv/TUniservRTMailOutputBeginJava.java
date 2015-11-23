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

public class TUniservRTMailOutputBeginJava
{
  protected static String nl;
  public static synchronized TUniservRTMailOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniservRTMailOutputBeginJava result = new TUniservRTMailOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + NL + "boolean use_component_status_";
  protected final String TEXT_2 = "_begin = false;" + NL + NL;
  protected final String TEXT_3 = NL + "WSStatus ws_status_";
  protected final String TEXT_4 = "_begin = (WSStatus)globalMap.get(\"WS_STATUS\");" + NL + "ComponentStatus status_";
  protected final String TEXT_5 = "_begin = null;" + NL + "" + NL + "if(ws_status_";
  protected final String TEXT_6 = "_begin != null)" + NL + "{" + NL + "   status_";
  protected final String TEXT_7 = "_begin = ws_status_";
  protected final String TEXT_8 = "_begin.getComponentStatus(\"";
  protected final String TEXT_9 = "\");" + NL + "" + NL + "   if(status_";
  protected final String TEXT_10 = "_begin != null)" + NL + "   {" + NL + "      use_component_status_";
  protected final String TEXT_11 = "_begin = true;" + NL + "   }" + NL + "}";
  protected final String TEXT_12 = NL + NL + "java.util.Hashtable<String, String> h_";
  protected final String TEXT_13 = "=new java.util.Hashtable<String, String>();" + NL + "uniserv.cliserv.mail.MailClient mailClient_";
  protected final String TEXT_14 = " = null;" + NL + "" + NL + "" + NL + "class MailError_";
  protected final String TEXT_15 = " implements uniserv.cliserv.mail.MailErrorHandler{" + NL + "\t\t" + NL + "\tpublic int handleError(int arg0, int arg1, String arg2) {\t\t " + NL + "         " + NL + "\t\tSystem.err.println(\"Error \" + arg1 + \": \" + arg2 );\t\t" + NL + "\t\tglobalMap.put(\"RT_MAIL_STATUS_CODE\", arg0);" + NL + "\t\tglobalMap.put(\"RT_MAIL_STATUS_CODE_INFO\", arg1);\t\t" + NL + "\t\tglobalMap.put(\"RT_MAIL_STATUS_MESSAGE\", arg2);" + NL + "\t\t" + NL + "\t\treturn 0;" + NL + "\t}" + NL + "}" + NL + "" + NL + "class SilentMailError_";
  protected final String TEXT_16 = " implements uniserv.cliserv.mail.MailErrorHandler{" + NL + "\t" + NL + "\tpublic int handleError(int arg0, int arg1, String arg2) {\t\t " + NL + "       " + NL + "\t\treturn 0;" + NL + "\t}" + NL + "}" + NL + "" + NL + "MailError_";
  protected final String TEXT_17 = " mailError_";
  protected final String TEXT_18 = " = new MailError_";
  protected final String TEXT_19 = "();" + NL + "SilentMailError_";
  protected final String TEXT_20 = " silentMailError_";
  protected final String TEXT_21 = " = new SilentMailError_";
  protected final String TEXT_22 = "();" + NL + "" + NL + "" + NL + "if(!use_component_status_";
  protected final String TEXT_23 = "_begin)" + NL + "{" + NL + "String hostname_";
  protected final String TEXT_24 = "=";
  protected final String TEXT_25 = ";" + NL + "String service_";
  protected final String TEXT_26 = "=";
  protected final String TEXT_27 = ";" + NL + "int port_";
  protected final String TEXT_28 = "=Integer.parseInt(";
  protected final String TEXT_29 = ");" + NL + "" + NL + " mailClient_";
  protected final String TEXT_30 = " = new uniserv.cliserv.mail.MailClient(hostname_";
  protected final String TEXT_31 = ", port_";
  protected final String TEXT_32 = ", service_";
  protected final String TEXT_33 = ");" + NL + "" + NL + "mailClient_";
  protected final String TEXT_34 = ".setLanguage(\"E\");" + NL + "" + NL + "class ShutdownHook";
  protected final String TEXT_35 = " extends Thread" + NL + "{" + NL + "     uniserv.cliserv.GenClient m_guarded_client = null;" + NL + "" + NL + "     public ShutdownHook";
  protected final String TEXT_36 = "(uniserv.cliserv.GenClient client)" + NL + "     {" + NL + "         m_guarded_client = client;" + NL + "     }" + NL + "" + NL + "     public void run()" + NL + "     {" + NL + "         try" + NL + "         {" + NL + "            if(m_guarded_client != null)" + NL + "            {" + NL + "                m_guarded_client.close();" + NL + "            }" + NL + "         }" + NL + "         catch (Exception ex)" + NL + "         {" + NL + "                  // do nothing" + NL + "         }" + NL + "     }" + NL + "}" + NL + "" + NL + "Runtime.getRuntime().addShutdownHook(new ShutdownHook";
  protected final String TEXT_37 = "(mailClient_";
  protected final String TEXT_38 = "));" + NL + NL;
  protected final String TEXT_39 = NL + "\tmailClient_";
  protected final String TEXT_40 = ".setArg(\"par_date_format\", ";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "mailClient_";
  protected final String TEXT_43 = ".setArg(\"par_create_pool\", \"";
  protected final String TEXT_44 = "\");" + NL + "" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String hostname = ElementParameterParser.getValue(node, "__HOSTNAME__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String service = ElementParameterParser.getValue(node, "__SERVICE__");

String par_date_format = ElementParameterParser.getValue(node, "__PAR_DATE_FORMAT__");
String par_create_pool = ElementParameterParser.getValue(node, "__PAR_CREATE_POOL__");


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
org.talend.core.model.process.IProcess process = node.getProcess();
java.util.List<INode> tRTOutputList = (java.util.List<INode>)process.getNodesOfType("tRTOutput");

if(tRTOutputList != null && tRTOutputList.size() > 0)
{  

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
}

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
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(service);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(port);
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
    
if(!("".equals(par_date_format)) && par_date_format.length()>0 && par_date_format!=null) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(par_date_format);
    stringBuffer.append(TEXT_41);
    
}

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(par_create_pool);
    stringBuffer.append(TEXT_44);
    return stringBuffer.toString();
  }
}
