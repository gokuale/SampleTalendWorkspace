package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMBulkLoadBeginJava
{
  protected static String nl;
  public static synchronized TMDMBulkLoadBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMBulkLoadBeginJava result = new TMDMBulkLoadBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_4 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = "; ";
  protected final String TEXT_9 = NL + NL + "org.talend.mdm.bulkload.client.BulkloadClient bulkloadClient_";
  protected final String TEXT_10 = " = new org.talend.mdm.bulkload.client.BulkloadClient(";
  protected final String TEXT_11 = ", ";
  protected final String TEXT_12 = ", decryptedPassword_";
  protected final String TEXT_13 = ", null, ";
  protected final String TEXT_14 = " + \"";
  protected final String TEXT_15 = "\", ";
  protected final String TEXT_16 = ", ";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "com.talend.mdm.transaction.client.MDMTransaction mdmTransaction_";
  protected final String TEXT_19 = " = (com.talend.mdm.transaction.client.MDMTransaction)globalMap.get(\"";
  protected final String TEXT_20 = "\");" + NL + "if(mdmTransaction_";
  protected final String TEXT_21 = "!=null) {" + NL + "\tbulkloadClient_";
  protected final String TEXT_22 = ".setTransactionId(mdmTransaction_";
  protected final String TEXT_23 = ".getId());" + NL + "}";
  protected final String TEXT_24 = NL + "bulkloadClient_";
  protected final String TEXT_25 = ".startThreadCount();" + NL + "bulkloadClient_";
  protected final String TEXT_26 = ".setOptions(new org.talend.mdm.bulkload.client.BulkloadOptions(";
  protected final String TEXT_27 = ", ";
  protected final String TEXT_28 = ", ";
  protected final String TEXT_29 = "));" + NL + "int count_";
  protected final String TEXT_30 = " = 0;" + NL + "org.talend.mdm.bulkload.client.InputStreamMerger inputStreamMerger_";
  protected final String TEXT_31 = " = null;";
  protected final String TEXT_32 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
	String username = ElementParameterParser.getValue(node, "__USERNAME__");

	String dataModule = ElementParameterParser.getValue(node, "__DATAMODEL__");
	String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");
	boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));
	String dataEntity = ElementParameterParser.getValue(node, "__DATACONCEPT__");
	String arraySize = ElementParameterParser.getValue(node,"__MASS_LEVEL__");
	
	boolean validate = ("true").equals(ElementParameterParser.getValue(node,"__VALIDATE__"));
	boolean isGenerateId = ("true").equals(ElementParameterParser.getValue(node,"__GENERATE_ID__"));
	
	boolean useTransaction = ("true").equals(ElementParameterParser.getValue(node,"__USE_TRANSACTION__"));
	String transactionProvider = ElementParameterParser.getValue(node,"__TRANSACTION_PROVIDER__");
	String mdmTransaction = "mdmTransaction_" + transactionProvider;
	

    stringBuffer.append(TEXT_1);
    
String passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_2);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_5);
    } else {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(mdmUrl);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dataCluster );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(isStaging?"#STAGING":"");
    stringBuffer.append(TEXT_15);
    stringBuffer.append(dataEntity );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(dataModule);
    stringBuffer.append(TEXT_17);
    if(useTransaction) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(mdmTransaction);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(isGenerateId );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(validate );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(arraySize);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(TEXT_32);
    return stringBuffer.toString();
  }
}
