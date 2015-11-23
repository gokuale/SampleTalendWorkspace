package org.talend.designer.codegen.translators.data_quality.address;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class TAddressRowCloudBeginJava
{
  protected static String nl;
  public static synchronized TAddressRowCloudBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAddressRowCloudBeginJava result = new TAddressRowCloudBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " " + NL;
  protected final String TEXT_2 = NL + "      if(";
  protected final String TEXT_3 = " == null || \"\".equals(";
  protected final String TEXT_4 = ".trim())) {" + NL + "          System.err.println(\"[ERROR]: Please make sure that the tAddressRowCloud component has been configured with a valid license/API key.\");" + NL + "          return;" + NL + "      }";
  protected final String TEXT_5 = NL + NL + NL + "    System.out.println(\"[INFO] using \" + (";
  protected final String TEXT_6 = " ? \"https\":\"http\") + \" protocol to connect to the \" + \"";
  protected final String TEXT_7 = "\" +\" webservice.\");" + NL + "" + NL + "    // fix when use jdk1.7, when select security mode connect for loqate" + NL + "    // get error:javax.net.ssl.SSLProtocolException: handshake alert: unrecognized_name    " + NL + "    if (";
  protected final String TEXT_8 = ") {" + NL + "       System.setProperty(\"jsse.enableSNIExtension\", \"false\");" + NL + "    }" + NL + "    " + NL + "    org.talend.dataquality.address.api.AddressEngine engine_";
  protected final String TEXT_9 = " = new org.talend.dataquality.address.api.AddressEngine(\"";
  protected final String TEXT_10 = "\");" + NL + "    if (!\"QAS\".equals(\"";
  protected final String TEXT_11 = "\")) {" + NL + "        engine_";
  protected final String TEXT_12 = ".getEngineConfig().setLicenseKey(";
  protected final String TEXT_13 = ");" + NL + "        engine_";
  protected final String TEXT_14 = ".getEngineConfig().setSecureMode(";
  protected final String TEXT_15 = ");" + NL + "    " + NL + "        engine_";
  protected final String TEXT_16 = ".getEngineConfig().setLineSeparator(\"";
  protected final String TEXT_17 = "\");" + NL + "        engine_";
  protected final String TEXT_18 = ".getEngineConfig().setDefaultCountry(\"";
  protected final String TEXT_19 = "\");" + NL + "        engine_";
  protected final String TEXT_20 = ".getEngineConfig().setForcedCountry(\"";
  protected final String TEXT_21 = "\");" + NL + "        engine_";
  protected final String TEXT_22 = ".getEngineConfig().setOutputScript(\"";
  protected final String TEXT_23 = "\");" + NL + "        engine_";
  protected final String TEXT_24 = ".getEngineConfig().setMinimumMatchScore(\"";
  protected final String TEXT_25 = "\");" + NL + "        engine_";
  protected final String TEXT_26 = ".getEngineConfig().setMinimumVerificationLevel(";
  protected final String TEXT_27 = ");" + NL + "        engine_";
  protected final String TEXT_28 = ".getEngineConfig().setOutputHandlerTerminationDelay(";
  protected final String TEXT_29 = ");" + NL + "        engine_";
  protected final String TEXT_30 = ".getEngineConfig().setProcessingMode(\"";
  protected final String TEXT_31 = "\");" + NL + "    } else {" + NL + "        // for qas" + NL + "        String url = \"https://ws.ondemand.qas.com/ProOnDemand/V2/ProOnDemandService.asmx\";" + NL + "        org.talend.qas.QASClientOnDemand qasClient_";
  protected final String TEXT_32 = " = new org.talend.qas.QASClientOnDemand(url, \"";
  protected final String TEXT_33 = "\", ";
  protected final String TEXT_34 = ", ";
  protected final String TEXT_35 = ");" + NL + "        engine_";
  protected final String TEXT_36 = ".getEngineConfig().setQasClientOnDemand(qasClient_";
  protected final String TEXT_37 = ");" + NL + "    }" + NL + "    engine_";
  protected final String TEXT_38 = ".getEngineConfig().setQueryInterval(";
  protected final String TEXT_39 = ");" + NL + "    engine_";
  protected final String TEXT_40 = ".getEngineConfig().setTrialLimit(";
  protected final String TEXT_41 = ");" + NL + "    engine_";
  protected final String TEXT_42 = ".getEngineConfig().setTrialInterval(";
  protected final String TEXT_43 = ");" + NL + "    engine_";
  protected final String TEXT_44 = ".getEngineConfig().setTerminationWaitingSeconds(";
  protected final String TEXT_45 = ");" + NL + "    ";
  protected final String TEXT_46 = NL + "      java.util.Set<String> additionalColumnSet_";
  protected final String TEXT_47 = " = new java.util.HashSet<String>();";
  protected final String TEXT_48 = NL + "          additionalColumnSet_";
  protected final String TEXT_49 = ".add(\"";
  protected final String TEXT_50 = "\");";
  protected final String TEXT_51 = NL + "      engine_";
  protected final String TEXT_52 = ".getEngineConfig().setAdditionalOutputColumnSet(additionalColumnSet_";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "        ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String api_type = ElementParameterParser.getValue(node, "__API_TYPE__"); 
	String licenseKey = ElementParameterParser.getValue(node, "__LICENSE_KEY__"); 
	boolean isSecuredMode = ("true").equals(ElementParameterParser.getValue(node, "__SECURE_MODE__")); 
	
	String address_line_separator = ElementParameterParser.getValue(node,"__ADDRESS_LINE_SEPARATOR__");
	String default_country = ElementParameterParser.getValue(node, "__DEFAULT_COUNTRY__"); 
	String forced_country = ElementParameterParser.getValue(node, "__FORCED_COUNTRY__"); 
	String output_script = ElementParameterParser.getValue(node, "__OUTPUT_SCRIPT__"); 
	String minimum_match_score = ElementParameterParser.getValue(node, "__MINIMUM_MATCH_SCORE__"); 
	String minimum_verification_level = ElementParameterParser.getValue(node, "__MINIMUM_VERIFICATION_LEVEL__");
	
	String query_interval = ElementParameterParser.getValue(node, "__QUERY_INTERVAL__"); 
	String trial_limit = ElementParameterParser.getValue(node, "__TRIAL_LIMIT__"); 
	String trial_interval = ElementParameterParser.getValue(node, "__TRIAL_INTERVAL__"); 
	String termination_waiting_seconds = ElementParameterParser.getValue(node, "__TERMINATION_WAITING_SECONDS__"); 
    String output_handler_termination_delay = ElementParameterParser.getValue(node, "__OUTPUT_HANDLER_TERMINATION_DELAY__");
    String processing_mode = ElementParameterParser.getValue(node, "__PROCESSING_MODE__");
    
    boolean useAdditionalOutput = ("true").equals(ElementParameterParser.getValue(node, "__USE_ADDITIONAL_OUTPUT__")); 
    List<Map<String, String>> additional_output_mapping = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__OUTPUT_MAPPING__");
    
    // only used for qas
    String country = ElementParameterParser.getValue(node, "__COUNTRY__"); 
    String username = ElementParameterParser.getValue(node, "__USER_NAME__"); 
    String password = ElementParameterParser.getValue(node, "__PASSWORD__"); 

    stringBuffer.append(TEXT_1);
    
    if (!"QAS".equals(api_type)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append( licenseKey );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( licenseKey );
    stringBuffer.append(TEXT_4);
    
    }

    stringBuffer.append(TEXT_5);
    stringBuffer.append( isSecuredMode );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( api_type );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( isSecuredMode );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append( api_type );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( api_type );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( licenseKey );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append( isSecuredMode );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append( address_line_separator );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append( default_country );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append( forced_country );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append( output_script );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append( minimum_match_score );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append( minimum_verification_level );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append( output_handler_termination_delay );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append( processing_mode );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(country);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append( query_interval );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append( trial_limit );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append( trial_interval );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append( termination_waiting_seconds );
    stringBuffer.append(TEXT_45);
    
  if(useAdditionalOutput){ 
  
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
      for (Map<String, String> output : additional_output_mapping) {
          String output_address_field = output.get("ADDRESS_FIELD");
      
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(output_address_field);
    stringBuffer.append(TEXT_50);
    
      }
      
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    return stringBuffer.toString();
  }
}
