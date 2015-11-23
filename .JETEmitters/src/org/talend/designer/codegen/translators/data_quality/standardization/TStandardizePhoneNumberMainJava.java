package org.talend.designer.codegen.translators.data_quality.standardization;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TStandardizePhoneNumberMainJava
{
  protected static String nl;
  public static synchronized TStandardizePhoneNumberMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TStandardizePhoneNumberMainJava result = new TStandardizePhoneNumberMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "errorMsg_";
  protected final String TEXT_2 = " = null;" + NL + "numberProto_";
  protected final String TEXT_3 = "  = null;";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = " = new ";
  protected final String TEXT_6 = "Struct();" + NL + "" + NL + "try {";
  protected final String TEXT_7 = NL + "\t   numberProto_";
  protected final String TEXT_8 = " = phoneUtil_";
  protected final String TEXT_9 = ".parse(String.valueOf(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = "), ";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t   numberProto_";
  protected final String TEXT_15 = " = phoneUtil_";
  protected final String TEXT_16 = ".parse(String.valueOf(";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = "), ";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "} catch (com.google.i18n.phonenumbers.NumberParseException e) {" + NL + "\terrorMsg_";
  protected final String TEXT_21 = " = e.toString();" + NL + "}" + NL;
  protected final String TEXT_22 = NL + "\t";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = NL + NL + "if (numberProto_";
  protected final String TEXT_28 = " != null) {" + NL + "\t";
  protected final String TEXT_29 = ".StandardizedPhoneNumber = phoneUtil_";
  protected final String TEXT_30 = ".format(numberProto_";
  protected final String TEXT_31 = ", com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.";
  protected final String TEXT_32 = ");" + NL + "\t";
  protected final String TEXT_33 = NL + "\t   ";
  protected final String TEXT_34 = ".IsValidPhoneNumber = phoneUtil_";
  protected final String TEXT_35 = ".isValidNumberForRegion(numberProto_";
  protected final String TEXT_36 = ",";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "\t   ";
  protected final String TEXT_40 = ".IsValidPhoneNumber = phoneUtil_";
  protected final String TEXT_41 = ".isValidNumberForRegion(numberProto_";
  protected final String TEXT_42 = ",";
  protected final String TEXT_43 = ");";
  protected final String TEXT_44 = NL + "\t";
  protected final String TEXT_45 = ".IsPossiblePhoneNumber = phoneUtil_";
  protected final String TEXT_46 = ".isPossibleNumber(numberProto_";
  protected final String TEXT_47 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_48 = NL + "\t\t";
  protected final String TEXT_49 = ".IsAlreadyStandard = (";
  protected final String TEXT_50 = ".StandardizedPhoneNumber).equals(";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = ");" + NL + "\t";
  protected final String TEXT_53 = NL + "\t";
  protected final String TEXT_54 = ".PhoneNumberType = phoneUtil_";
  protected final String TEXT_55 = ".getNumberType(numberProto_";
  protected final String TEXT_56 = ").name();" + NL + "} else {" + NL + "\t";
  protected final String TEXT_57 = ".IsValidPhoneNumber = false;" + NL + "\t";
  protected final String TEXT_58 = ".IsPossiblePhoneNumber = false;" + NL + "\t" + NL + "\t";
  protected final String TEXT_59 = NL + "\t\t";
  protected final String TEXT_60 = ".IsAlreadyStandard = false;" + NL + "\t";
  protected final String TEXT_61 = NL + "\t";
  protected final String TEXT_62 = ".ErrorMessage = errorMsg_";
  protected final String TEXT_63 = ";" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();	
List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
IConnection inConn = null;

// get incomming connection
if (inConns == null || inConns.isEmpty()) {
	return "";
} else {
	inConn = inConns.get(0);
}
String sInConnName = null;

// get incoming connection name
if (inConn == null || !inConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	return "";
} else {
	sInConnName = inConn.getName();
}

// get outgoing connections
List<? extends IConnection> outConns = node.getOutgoingSortedConnections();
String sOutMainConnName = null;
String phoneNumber = ElementParameterParser.getValue(node, "__PHONE_NUMBER__"); 
String numberFormat = ElementParameterParser.getValue(node, "__PHONE_NUMBER_FORMAT__");
String countryCode =null;
boolean countryCustomed="true".equals(ElementParameterParser.getValue(node, "__COUNTRY_CUSTOME__"));
boolean bAvoidComparision = "true".equals(ElementParameterParser.getValue(node, "__AVOID_COMPARISON__")); 
if(countryCustomed){
    countryCode=ElementParameterParser.getValue(node, "__COUNTRY_CODE_CUSTOME__"); 
}else{
    countryCode=ElementParameterParser.getValue(node, "__COUNTRY_CODE__"); 
}
if (outConns == null || outConns.isEmpty() || !outConns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	return "";
} else {
	sOutMainConnName = outConns.get(0).getName();
}
List<IMetadataColumn> inColumns = inConn.getMetadataTable().getListColumns();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_6);
    if(!countryCustomed){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(phoneNumber);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(countryCode);
    stringBuffer.append(TEXT_13);
    	}else{  
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(phoneNumber);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(countryCode);
    stringBuffer.append(TEXT_19);
    	}   
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    for (IMetadataColumn inColumn : inColumns) {
	String label = inColumn.getLabel();
	
    stringBuffer.append(TEXT_22);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(numberFormat);
    stringBuffer.append(TEXT_32);
    if(!countryCustomed){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(countryCode);
    stringBuffer.append(TEXT_38);
    }else{
    stringBuffer.append(TEXT_39);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(countryCode);
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    if (!bAvoidComparision) {
    stringBuffer.append(TEXT_48);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(phoneNumber);
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_58);
    if (!bAvoidComparision) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_60);
    }
    stringBuffer.append(TEXT_61);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    return stringBuffer.toString();
  }
}
