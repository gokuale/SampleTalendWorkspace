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

public class TUniservRTMailBulkBeginJava
{
  protected static String nl;
  public static synchronized TUniservRTMailBulkBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniservRTMailBulkBeginJava result = new TUniservRTMailBulkBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "class MailError implements uniserv.cliserv.mail.MailErrorHandler{" + NL + "\tpublic int handleError(int arg0, int arg1, String arg2) {" + NL + "\t\tSystem.out.println(arg0+\" - \"+arg1+\" - \"+arg2);" + NL + "\t\treturn 0;" + NL + "\t}" + NL + "}" + NL + "" + NL + "String hostname_";
  protected final String TEXT_2 = "=";
  protected final String TEXT_3 = ";" + NL + "String service_";
  protected final String TEXT_4 = "=";
  protected final String TEXT_5 = ";" + NL + "int port_";
  protected final String TEXT_6 = "=Integer.parseInt(";
  protected final String TEXT_7 = ");" + NL + "" + NL + "java.util.Hashtable<String, String> h_";
  protected final String TEXT_8 = "=new java.util.Hashtable<String, String>();" + NL + "uniserv.cliserv.mail.MailClient mailClient_";
  protected final String TEXT_9 = "=new uniserv.cliserv.mail.MailClient(hostname_";
  protected final String TEXT_10 = ", port_";
  protected final String TEXT_11 = ", service_";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\tmailClient_";
  protected final String TEXT_14 = ".setArg(\"par_date_format\", ";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "mailClient_";
  protected final String TEXT_17 = ".setArg(\"par_create_pool\", \"";
  protected final String TEXT_18 = "\");" + NL + "MailError mailError_";
  protected final String TEXT_19 = "=new MailError();" + NL + "" + NL + "class ShutdownHook";
  protected final String TEXT_20 = " extends Thread" + NL + "{" + NL + "     uniserv.cliserv.GenClient m_guarded_client = null;" + NL + "" + NL + "     public ShutdownHook";
  protected final String TEXT_21 = "(uniserv.cliserv.GenClient client)" + NL + "     {" + NL + "         m_guarded_client = client;" + NL + "     }" + NL + "" + NL + "     public void run()" + NL + "     {" + NL + "         try" + NL + "         {" + NL + "            if(m_guarded_client != null)" + NL + "            {" + NL + "                m_guarded_client.close();" + NL + "            }" + NL + "         }" + NL + "         catch (Exception ex)" + NL + "         {" + NL + "                  // do nothing" + NL + "         }" + NL + "     }" + NL + "}" + NL + "" + NL + "Runtime.getRuntime().addShutdownHook(new ShutdownHook";
  protected final String TEXT_22 = "(mailClient_";
  protected final String TEXT_23 = "));" + NL + "" + NL + "mailClient_";
  protected final String TEXT_24 = ".mailLoadBegin();";
  protected final String TEXT_25 = NL;

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
if(!("".equals(par_date_format)) && par_date_format.length()>0 && par_date_format!=null) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(par_date_format);
    stringBuffer.append(TEXT_15);
    
}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(par_create_pool);
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
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}
