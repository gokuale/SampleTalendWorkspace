package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMConnectionBeginJava
{
  protected static String nl;
  public static synchronized TMDMConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMConnectionBeginJava result = new TMDMConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + NL + "    org.talend.mdm.webservice.TMDMService_ServiceLocator tmdmService_";
  protected final String TEXT_3 = " = new org.talend.mdm.webservice.TMDMService_ServiceLocator();" + NL + "    tmdmService_";
  protected final String TEXT_4 = ".setTMDMPortEndpointAddress(";
  protected final String TEXT_5 = ");" + NL + "    org.talend.mdm.webservice.TMDMService_PortType tmdmWS_";
  protected final String TEXT_6 = " = tmdmService_";
  protected final String TEXT_7 = ".getTMDMPort();    " + NL + "    org.talend.mdm.webservice.TMDMServiceSoapBindingStub stub_";
  protected final String TEXT_8 = " = (org.talend.mdm.webservice.TMDMServiceSoapBindingStub)tmdmWS_";
  protected final String TEXT_9 = ";" + NL + "    " + NL + "    // Authentification" + NL + "    stub_";
  protected final String TEXT_10 = ".setUsername(";
  protected final String TEXT_11 = ");" + NL;
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = "; ";
  protected final String TEXT_19 = NL + NL + "stub_";
  protected final String TEXT_20 = ".setPassword(decryptedPassword_";
  protected final String TEXT_21 = ");" + NL;
  protected final String TEXT_22 = NL + "\tString turl_";
  protected final String TEXT_23 = " = com.talend.mdm.transaction.client.MDMTransactionClient.getMDMTransactionURL(";
  protected final String TEXT_24 = ", true);" + NL + "com.talend.mdm.transaction.client.MDMTransaction mdmTransaction_";
  protected final String TEXT_25 = " = null;";
  protected final String TEXT_26 = NL + "\tmdmTransaction_";
  protected final String TEXT_27 = " = new com.talend.mdm.transaction.client.MDMTransaction();" + NL + "\tmdmTransaction_";
  protected final String TEXT_28 = ".setUrl(turl_";
  protected final String TEXT_29 = ");" + NL + "\tString clientTranId_";
  protected final String TEXT_30 = " = \"";
  protected final String TEXT_31 = "\"+java.util.UUID.randomUUID()+Thread.currentThread().getId();" + NL + "\tmdmTransaction_";
  protected final String TEXT_32 = ".setId(clientTranId_";
  protected final String TEXT_33 = ");" + NL + "\tmdmTransaction_";
  protected final String TEXT_34 = ".setUsername(stub_";
  protected final String TEXT_35 = ".getUsername());" + NL + "\tmdmTransaction_";
  protected final String TEXT_36 = ".setPassword(stub_";
  protected final String TEXT_37 = ".getPassword());";
  protected final String TEXT_38 = NL + "\tmdmTransaction_";
  protected final String TEXT_39 = " = com.talend.mdm.transaction.client.MDMTransactionClient.newTransaction(turl_";
  protected final String TEXT_40 = ",stub_";
  protected final String TEXT_41 = ".getUsername(),stub_";
  protected final String TEXT_42 = ".getPassword());";
  protected final String TEXT_43 = NL + "stub_";
  protected final String TEXT_44 = ".setHeader(new org.apache.axis.message.SOAPHeaderElement(\"http://www.talend.com/mdm\", \"transaction-id\", mdmTransaction_";
  protected final String TEXT_45 = ".getId()));" + NL + "globalMap.put(\"mdmTransaction_";
  protected final String TEXT_46 = "\", mdmTransaction_";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + NL + "    stub_";
  protected final String TEXT_49 = ".ping(new org.talend.mdm.webservice.WSPing());";
  protected final String TEXT_50 = NL + "    " + NL + "    globalMap.put(\"TMDMService_";
  protected final String TEXT_51 = "\", tmdmWS_";
  protected final String TEXT_52 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
String username = ElementParameterParser.getValue(node, "__USERNAME__");
String version = ElementParameterParser.getValue(node, "__SERVERVERSION__");

boolean useTransaction = "false".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));
boolean useClientTranId = "true".equals(ElementParameterParser.getValue(node, "__GEN_TRANSACTION_ID__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_11);
    
String passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_12);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    } else {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    if(useTransaction) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
if(useClientTranId){

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    
}else{

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    
}

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    //For TDI-26109
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    return stringBuffer.toString();
  }
}
