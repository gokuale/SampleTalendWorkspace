package org.talend.designer.codegen.translators.data_quality;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class TVerifyEmailBeginJava
{
  protected static String nl;
  public static synchronized TVerifyEmailBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TVerifyEmailBeginJava result = new TVerifyEmailBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tList<String> tldLs_";
  protected final String TEXT_2 = "=new java.util.ArrayList();" + NL + "\tList domainLs_";
  protected final String TEXT_3 = "=new java.util.ArrayList();" + NL + "\t";
  protected final String TEXT_4 = NL + "              tldLs_";
  protected final String TEXT_5 = ".add(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "               domainLs_";
  protected final String TEXT_8 = ".add(";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "    String localPart_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ";" + NL + "    org.talend.dataquality.email.api.EmailVerify emailVerify_";
  protected final String TEXT_13 = " = new org.talend.dataquality.email.api.EmailVerify();" + NL + "    if(";
  protected final String TEXT_14 = "){" + NL + "      emailVerify_";
  protected final String TEXT_15 = " = emailVerify_";
  protected final String TEXT_16 = ".addRegularRegexChecker(";
  protected final String TEXT_17 = ",";
  protected final String TEXT_18 = ")" + NL + "                .addLocalPartColumnContentChecker(true,";
  protected final String TEXT_19 = ",\"";
  protected final String TEXT_20 = "\", ";
  protected final String TEXT_21 = ", ";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ")" + NL + "                .addListDomainsChecker(";
  protected final String TEXT_26 = ", domainLs_";
  protected final String TEXT_27 = ")" + NL + "                .addTLDsChecker(";
  protected final String TEXT_28 = ", tldLs_";
  protected final String TEXT_29 = ", ";
  protected final String TEXT_30 = ")" + NL + "                .addCallbackMailServerChecker(";
  protected final String TEXT_31 = ");" + NL + "    }else{" + NL + "    emailVerify_";
  protected final String TEXT_32 = " = emailVerify_";
  protected final String TEXT_33 = ".addRegularRegexChecker(";
  protected final String TEXT_34 = ",";
  protected final String TEXT_35 = ")" + NL + "                .addLocalPartRegexChecker(localPart_";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = ", ";
  protected final String TEXT_38 = ")" + NL + "                .addListDomainsChecker(";
  protected final String TEXT_39 = ", domainLs_";
  protected final String TEXT_40 = ")" + NL + "                .addTLDsChecker(";
  protected final String TEXT_41 = ", tldLs_";
  protected final String TEXT_42 = ", ";
  protected final String TEXT_43 = ")" + NL + "                .addCallbackMailServerChecker(";
  protected final String TEXT_44 = ");" + NL + "    }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	boolean isUseRegularRegex = ("true").equals(ElementParameterParser.getValue(node, "__USE_REGULAR_EXPRESSION__"));
	String userDefinedRegex =  ElementParameterParser.getValue(node, "__COMPLETE_REGEX__");
	boolean isCaseSensitive = ("true").equals(ElementParameterParser.getValue(node, "__CASE_SENSITIVE__"));
	
	boolean isLocalPartShort = ("true").equals(ElementParameterParser.getValue(node, "__USE_SHORT__"));
	String localPartShortExpress= ElementParameterParser.getValue(node, "__LOCAL_SHORT_PART__");
	
	boolean isLocalPartUseRegex = ("true").equals(ElementParameterParser.getValue(node, "__USE_REGEX__"));
    String localPartRegexExpress= ElementParameterParser.getValue(node, "__LOCAL_REGEX_PART__");
    
    boolean isLocalPartUseColumn = ("true").equals(ElementParameterParser.getValue(node, "__USE_COLUMN__"));
    String nFirstOfFirst = ElementParameterParser.getValue(node, "__COLUMN_NFIRSTCHAR_FIRSTNAME__");
    String nLastOfFirst = ElementParameterParser.getValue(node, "__COLUMN_NLASTCHAR_FIRSTNAME__");
    String nFirstOfLast = ElementParameterParser.getValue(node, "__COLUMN_NFIRSTCHAR_LASTNAME__");
    String nLastOfLast = ElementParameterParser.getValue(node, "__COLUMN_NLASTCHAR_LASTNAME__");
    String separator = ElementParameterParser.getValue(node, "__COLUMN_SEPARATOR__");
    
    String useCharCase=ElementParameterParser.getValue(node, "__COLUMN_CASE_TYPE__");
	
	boolean isValidTLDs = ("true").equals(ElementParameterParser.getValue(node, "__CHECK_TLDS__"));
	boolean isBlackListDomains = ("true").equals(ElementParameterParser.getValue(node, "__CHECK_BLACK_DOMAINS__"));
	boolean isCallbackMailServer = ("true").equals(ElementParameterParser.getValue(node, "__CALL_BACK__"));
	
	//Additional TLDS,white or black domain List 
	List<Map<String, String>> tldTable = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__ADDITIONAL_TLDS__");
	List<Map<String, String>> domianTable = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__DOMAINS_LIST__");
	
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	if(tldTable!=null){
	   for (Map<String, String> tldMap : tldTable) {
           String tld = tldMap.get("TLD_NAME");
           if(tld!=null){
     
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(tld.toUpperCase());
    stringBuffer.append(TEXT_6);
              
           }
       }
	}
	
	if(domianTable!=null){
       for (Map<String, String> domainMap : domianTable) {
           String domain = domainMap.get("DOMAIN_NAME");
           if(domain!=null){
     
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(domain);
    stringBuffer.append(TEXT_9);
    
           }
       }
    }

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(isLocalPartShort ? localPartShortExpress : localPartRegexExpress);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(isLocalPartUseColumn);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(isUseRegularRegex);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(userDefinedRegex);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(isCaseSensitive);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(useCharCase);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(nFirstOfFirst);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(nLastOfFirst);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(nFirstOfLast);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(nLastOfLast);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(isBlackListDomains);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(isValidTLDs);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(isBlackListDomains);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(isCallbackMailServer);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(isUseRegularRegex);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(userDefinedRegex);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(isCaseSensitive);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(isLocalPartShort);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(isBlackListDomains);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(isValidTLDs);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(isBlackListDomains);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(isCallbackMailServer);
    stringBuffer.append(TEXT_44);
    return stringBuffer.toString();
  }
}
