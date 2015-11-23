package org.talend.designer.codegen.translators.data_quality.address;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.talend.core.model.process.EConnectionType;

public class TBatchAddressRowCloudOutBeginJava
{
  protected static String nl;
  public static synchronized TBatchAddressRowCloudOutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBatchAddressRowCloudOutBeginJava result = new TBatchAddressRowCloudOutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    if(";
  protected final String TEXT_2 = " == null || \"\".equals(";
  protected final String TEXT_3 = ".trim())) {" + NL + "        System.err.println(\"[ERROR]: Please make sure all the tBatchAddressRowCloud components have input the API key when select \" + \"";
  protected final String TEXT_4 = "\" + \" as address provider.\");" + NL + "        return;" + NL + "    }" + NL + "    if (\"LOQATE\".equals(\"";
  protected final String TEXT_5 = "\")) {" + NL + "        if(";
  protected final String TEXT_6 = " == null || \"\".equals(";
  protected final String TEXT_7 = ".trim())) {" + NL + "            System.err.println(\"[ERROR]: Please make sure all the tBatchAddressRowCloud components have input the Loqate website login username when select \" + \"";
  protected final String TEXT_8 = "\" + \" as address provider.\");" + NL + "            return;" + NL + "        }" + NL + "        if(";
  protected final String TEXT_9 = " == null || \"\".equals(";
  protected final String TEXT_10 = ".trim())) {" + NL + "            System.err.println(\"[ERROR]: Please make sure all the tBatchAddressRowCloud components have input the Loqate website login password when select \" + \"";
  protected final String TEXT_11 = "\" + \" as address provider.\");" + NL + "            return;" + NL + "        }" + NL + "        if(";
  protected final String TEXT_12 = " == null || \"\".equals(";
  protected final String TEXT_13 = ".trim())) {" + NL + "            System.err.println(\"[ERROR]: Please make sure all the tBatchAddressRowCloud components have input the Batch job name when select \" + \"";
  protected final String TEXT_14 = "\" + \" as address provider.\");" + NL + "            return;" + NL + "        }" + NL + "    }" + NL + "    if(\"";
  protected final String TEXT_15 = "\" == null || \"\".equals(\"";
  protected final String TEXT_16 = "\".trim())) {" + NL + "        System.err.println(\"[ERROR]: Please make sure all the tBatchAddressRowCloud components have select the default country when select \" + \"";
  protected final String TEXT_17 = "\" + \" as address provider.\");" + NL + "        return;" + NL + "    }" + NL + "" + NL + "" + NL + "    org.talend.dataquality.address.api.EngineConfig config_";
  protected final String TEXT_18 = " = new org.talend.dataquality.address.api.EngineConfig();" + NL + "    config_";
  protected final String TEXT_19 = ".setLicenseKey(";
  protected final String TEXT_20 = ");" + NL + "    config_";
  protected final String TEXT_21 = ".setProcessingMode(\"";
  protected final String TEXT_22 = "\");" + NL + "    if (\"LOQATE\".equals(\"";
  protected final String TEXT_23 = "\")) {" + NL + "        config_";
  protected final String TEXT_24 = ".getLoqateBatchParameters().setJobName(";
  protected final String TEXT_25 = ");" + NL + "        config_";
  protected final String TEXT_26 = ".getLoqateBatchParameters().setUsername(";
  protected final String TEXT_27 = ");" + NL + "        config_";
  protected final String TEXT_28 = ".getLoqateBatchParameters().setPassword(";
  protected final String TEXT_29 = ");" + NL + "    }" + NL + "    config_";
  protected final String TEXT_30 = ".setLineSeparator(\"";
  protected final String TEXT_31 = "\");" + NL + "    config_";
  protected final String TEXT_32 = ".setDefaultCountry(\"";
  protected final String TEXT_33 = "\");" + NL + "    config_";
  protected final String TEXT_34 = ".setForcedCountry(\"";
  protected final String TEXT_35 = "\");" + NL + "    config_";
  protected final String TEXT_36 = ".setOutputScript(\"";
  protected final String TEXT_37 = "\");" + NL + "    config_";
  protected final String TEXT_38 = ".setMinimumMatchScore(\"";
  protected final String TEXT_39 = "\");" + NL + "    " + NL + "    config_";
  protected final String TEXT_40 = ".setQueryInterval(";
  protected final String TEXT_41 = ");" + NL + "    config_";
  protected final String TEXT_42 = ".setTrialLimit(";
  protected final String TEXT_43 = ");" + NL + "    config_";
  protected final String TEXT_44 = ".setTrialInterval(";
  protected final String TEXT_45 = ");" + NL + "    config_";
  protected final String TEXT_46 = ".setTerminationWaitingSeconds(";
  protected final String TEXT_47 = ");" + NL + "    config_";
  protected final String TEXT_48 = ".setOutputHandlerTerminationDelay(";
  protected final String TEXT_49 = ");" + NL + "    config_";
  protected final String TEXT_50 = ".setProcessingMode(\"";
  protected final String TEXT_51 = "\");" + NL + "    config_";
  protected final String TEXT_52 = ".setBatchSize(";
  protected final String TEXT_53 = ");" + NL + "    config_";
  protected final String TEXT_54 = ".setMockupMode(";
  protected final String TEXT_55 = ");" + NL + "    config_";
  protected final String TEXT_56 = ".setBatchId(";
  protected final String TEXT_57 = ");" + NL + "    " + NL + "    // this is used to store the input columns' values that store to the temp input file." + NL + "    List<org.talend.dataquality.address.api.AddressObject> inputFileColumnList_";
  protected final String TEXT_58 = " = new java.util.ArrayList<org.talend.dataquality.address.api.AddressObject>();" + NL + "    " + NL + "    // fix when use jdk1.7, when select security mode connect for loqate" + NL + "    // get error:javax.net.ssl.SSLProtocolException: handshake alert: unrecognized_name    " + NL + "    System.setProperty(\"jsse.enableSNIExtension\", \"false\");" + NL + "    ";
  protected final String TEXT_59 = NL + "      java.util.Set<String> additionalColumnSet_";
  protected final String TEXT_60 = " = new java.util.HashSet<String>();";
  protected final String TEXT_61 = NL + "          additionalColumnSet_";
  protected final String TEXT_62 = ".add(\"";
  protected final String TEXT_63 = "\");";
  protected final String TEXT_64 = NL + "      config_";
  protected final String TEXT_65 = ".setAdditionalOutputColumnSet(additionalColumnSet_";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + NL + "  int recordCount = 0;" + NL + "" + NL + "  int nb_line_";
  protected final String TEXT_68 = " = 0;" + NL + "" + NL + "  java.util.Queue<";
  protected final String TEXT_69 = "Struct> listGroupby_";
  protected final String TEXT_70 = " = new java.util.concurrent.ConcurrentLinkedQueue<";
  protected final String TEXT_71 = "Struct>();" + NL + "" + NL + "  class ThreadBatchOutput_";
  protected final String TEXT_72 = " extends Thread {" + NL + "      java.util.Queue<org.talend.dataquality.address.api.AddressObject> queue;" + NL + "      java.lang.Exception lastException;" + NL + "      String currentComponent;" + NL + "      " + NL + "      ThreadBatchOutput_";
  protected final String TEXT_73 = "(java.util.Queue q) {" + NL + "          this.queue = q;" + NL + "          globalMap.put(\"queue_";
  protected final String TEXT_74 = "\", queue);" + NL + "          lastException = null;" + NL + "      }" + NL + "            " + NL + "      public java.lang.Exception getLastException() {" + NL + "          return this.lastException;" + NL + "      }" + NL + "      public String getCurrentComponent() {" + NL + "          return this.currentComponent;" + NL + "      }" + NL + "" + NL + "      @Override" + NL + "      public void run() {" + NL + "          try {";
  protected final String TEXT_75 = NL + "              ";
  protected final String TEXT_76 = "Process(globalMap);" + NL + "          } catch (TalendException te) {" + NL + "              this.lastException = te.getException();" + NL + "              this.currentComponent = te.getCurrentComponent();" + NL + "          }" + NL + "      }" + NL + "  }" + NL + "  " + NL + "  ThreadBatchOutput_";
  protected final String TEXT_77 = " tbo_";
  protected final String TEXT_78 = " = new ThreadBatchOutput_";
  protected final String TEXT_79 = "(listGroupby_";
  protected final String TEXT_80 = ");" + NL + "  tbo_";
  protected final String TEXT_81 = ".start();" + NL + "  " + NL + "  org.talend.dataquality.address.api.batch.BatchAddressEngine engine_";
  protected final String TEXT_82 = " = new org.talend.dataquality.address.api.batch.BatchAddressEngine(\"";
  protected final String TEXT_83 = "\", config_";
  protected final String TEXT_84 = ");" + NL + "" + NL + "  class ComponentBatchAsyncAddressObjectHandler_";
  protected final String TEXT_85 = " extends org.talend.dataquality.address.api.batch.BatchAsyncAddressObjectHandler {" + NL + "" + NL + "      java.util.Queue<";
  protected final String TEXT_86 = "Struct> input_cache;" + NL + "      " + NL + "      java.util.Queue<";
  protected final String TEXT_87 = "Struct> queue;" + NL + "      " + NL + "      ComponentBatchAsyncAddressObjectHandler_";
  protected final String TEXT_88 = "(java.util.Queue q) {" + NL + "          this.queue = q;" + NL + "          input_cache = new java.util.concurrent.ConcurrentLinkedQueue<";
  protected final String TEXT_89 = "Struct>();" + NL + "      }" + NL + "" + NL + "      @Override" + NL + "      protected void handleAddressObject(List<org.talend.dataquality.address.api.AddressObject> addressObjects) {" + NL + "           for(org.talend.dataquality.address.api.AddressObject addressObject: addressObjects){";
  protected final String TEXT_90 = NL + "              ";
  protected final String TEXT_91 = "Struct outStruct = input_cache.peek();" + NL + "               " + NL + "              if(outStruct!=null){" + NL + "                  outStruct = input_cache.poll();" + NL + "" + NL + "                  outStruct.Status = addressObject.getStatus();" + NL + "                  outStruct.AddressVerificationCode = addressObject.getAddressVerificationCode();" + NL + "                  outStruct.VerificationLevel = addressObject.getVerificationLevel();" + NL + "                  outStruct.FormattedAddress = addressObject.getFormattedAddress();" + NL + "                  outStruct.StreetNumber = addressObject.getStreetNumber();" + NL + "                  outStruct.Route = addressObject.getRoute();" + NL + "                  outStruct.Locality = addressObject.getLocality();" + NL + "                  outStruct.AdministrationAreaLevel1 = addressObject.getAdministrationAreaLevel1();" + NL + "                  outStruct.AdministrationAreaLevel2 = addressObject.getAdministrationAreaLevel2();" + NL + "                  outStruct.Country = addressObject.getCountry();" + NL + "                  outStruct.PostalCodeLong = addressObject.getPostalCodeLong();" + NL + "                  outStruct.PostalCodeShort = addressObject.getPostalCodeShort();" + NL + "                  outStruct.Longitude = addressObject.getLongitude();" + NL + "                  outStruct.Latitude = addressObject.getLatitude();" + NL + "                  ";
  protected final String TEXT_92 = NL + "                          outStruct.";
  protected final String TEXT_93 = " = addressObject.getResultColumn(\"";
  protected final String TEXT_94 = "\");";
  protected final String TEXT_95 = "    " + NL + "" + NL + "                  queue.add(outStruct);                   " + NL + "              }" + NL + "          }" + NL + "      }" + NL + "      " + NL + "      public void addOutputRecord(";
  protected final String TEXT_96 = "Struct inStruct){";
  protected final String TEXT_97 = NL + "          ";
  protected final String TEXT_98 = "Struct outStruct = new ";
  protected final String TEXT_99 = "Struct();" + NL + "      ";
  protected final String TEXT_100 = "          " + NL + "                              outStruct.";
  protected final String TEXT_101 = " = inStruct.";
  protected final String TEXT_102 = ";";
  protected final String TEXT_103 = NL + "      " + NL + "          input_cache.add(outStruct);" + NL + "      }" + NL + "  }" + NL + "" + NL + "  ComponentBatchAsyncAddressObjectHandler_";
  protected final String TEXT_104 = " handler_";
  protected final String TEXT_105 = " = new ComponentBatchAsyncAddressObjectHandler_";
  protected final String TEXT_106 = "(listGroupby_";
  protected final String TEXT_107 = ");" + NL + "  engine_";
  protected final String TEXT_108 = ".setAddressObjectHandler(handler_";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	INode virtualTargetNode = node.getOutgoingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getTarget();
    String virtualTargetCid = virtualTargetNode.getUniqueName();

    String connInName = null, connOutName = null;    
    IMetadataTable inputMetadataTable = null, outputMetadataTable = null;
    java.util.List<IMetadataColumn> inputColumns = null, outputColumns = null;
    
    List<? extends IConnection> incomingConnections = node.getIncomingConnections();
    if (incomingConnections != null && !incomingConnections.isEmpty()) {    
        for (IConnection conn : incomingConnections) {
            if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                connInName = conn.getName();              
                inputMetadataTable = conn.getMetadataTable();
                inputColumns = inputMetadataTable.getListColumns();
                break;
            }
        }
    }  
    
    List<? extends IConnection> outgoingConnections = virtualTargetNode.getOutgoingConnections();
    if (outgoingConnections != null && !outgoingConnections.isEmpty()) {    
        for (IConnection conn : outgoingConnections) {
            if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                connOutName = conn.getName();              
                outputMetadataTable = conn.getMetadataTable();
                outputColumns = outputMetadataTable.getListColumns();
                break;
            }
        }
    }  
	
	String api_type = ElementParameterParser.getValue(node, "__API_TYPE__"); 
	String licenseKey = ElementParameterParser.getValue(node, "__LICENSE_KEY__"); 
	String username = ElementParameterParser.getValue(node, "__USER_NAME__"); 
	String password = ElementParameterParser.getValue(node, "__PASSWORD__"); 
	String jobName = ElementParameterParser.getValue(node, "__JOB_NAME__"); 
    String processing_mode = ElementParameterParser.getValue(node, "__PROCESSING_MODE__");    
    String batchSize = ElementParameterParser.getValue(node, "__BATCH_SIZE__");

    boolean useAdditionalOutput = ("true").equals(ElementParameterParser.getValue(node, "__USE_ADDITIONAL_OUTPUT__"));
    List<Map<String, String>> additional_output_mapping = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__OUTPUT_MAPPING__");
    
	String address_line_separator = ElementParameterParser.getValue(node,"__ADDRESS_LINE_SEPARATOR__");
	String default_country = ElementParameterParser.getValue(node, "__DEFAULT_COUNTRY__"); 
	String forced_country = ElementParameterParser.getValue(node, "__FORCED_COUNTRY__"); 
	String output_script = ElementParameterParser.getValue(node, "__OUTPUT_SCRIPT__"); 
	String minimum_match_score = ElementParameterParser.getValue(node, "__MINIMUM_MATCH_SCORE__"); 
	
	String query_interval = ElementParameterParser.getValue(node, "__QUERY_INTERVAL__"); 
	String trial_limit = ElementParameterParser.getValue(node, "__TRIAL_LIMIT__"); 
	String trial_interval = ElementParameterParser.getValue(node, "__TRIAL_INTERVAL__"); 
	String termination_waiting_seconds = ElementParameterParser.getValue(node, "__TERMINATION_WAITING_SECONDS__"); 
    String output_handler_termination_delay = ElementParameterParser.getValue(node, "__OUTPUT_HANDLER_TERMINATION_DELAY__");
    boolean useMockupMode = ("true").equals(ElementParameterParser.getValue(node, "__USE_MOCKUP_MODE__"));
    String batchId = ElementParameterParser.getValue(node, "__BATCH_ID__");
    

    
    stringBuffer.append(TEXT_1);
    stringBuffer.append( licenseKey );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( licenseKey );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( api_type );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( api_type );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( username );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( username );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( api_type );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( password );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( password );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( api_type );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( jobName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( jobName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( api_type );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( default_country );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( default_country );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( api_type );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append( licenseKey );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append( processing_mode );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( api_type );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append( jobName );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append( username );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append( password );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append( address_line_separator );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append( default_country );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append( forced_country );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append( output_script );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append( minimum_match_score );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append( query_interval );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append( trial_limit );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append( trial_interval );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append( termination_waiting_seconds );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append( output_handler_termination_delay );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append( processing_mode );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append( batchSize );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append( useMockupMode );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append( batchId );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
  if(useAdditionalOutput){ 
  
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
      for (Map<String, String> output : additional_output_mapping) {
          String output_address_field = output.get("ADDRESS_FIELD");
      
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(output_address_field);
    stringBuffer.append(TEXT_63);
    
      }
      
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(connOutName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(connOutName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(virtualTargetCid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(virtualTargetCid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append( api_type );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(connOutName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(connOutName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(connOutName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(connOutName);
    stringBuffer.append(TEXT_91);
    
                  if(useAdditionalOutput){
                      for (Map<String, String> output : additional_output_mapping) {
                          String output_address_field = output.get("ADDRESS_FIELD");
                          String output_column = output.get("OUTPUT_COLUMN");
                  
    stringBuffer.append(TEXT_92);
    stringBuffer.append( output_column );
    stringBuffer.append(TEXT_93);
    stringBuffer.append( output_address_field );
    stringBuffer.append(TEXT_94);
    
                      }
                  }
                  
    stringBuffer.append(TEXT_95);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(connOutName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(connOutName);
    stringBuffer.append(TEXT_99);
    
          if(outputColumns != null){
              for(IMetadataColumn outColumn : outputColumns){
                  if(!outColumn.isReadOnly()){
                      for(IMetadataColumn inColumn : inputColumns){
                          if(outColumn.getLabel().equals(inColumn.getLabel())){
          
    stringBuffer.append(TEXT_100);
    stringBuffer.append(outColumn.getLabel());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_102);
    
                          }
                      }
                  }
              }
          }
          
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(TEXT_110);
    return stringBuffer.toString();
  }
}
