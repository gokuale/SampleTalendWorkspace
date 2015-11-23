package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMOutputBeginJava
{
  protected static String nl;
  public static synchronized TMDMOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMOutputBeginJava result = new TMDMOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "       " + NL + "int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "int nb_line_rejected_";
  protected final String TEXT_3 = " = 0;";
  protected final String TEXT_4 = NL + "\t";
  protected final String TEXT_5 = NL + "\t\tclass Util_";
  protected final String TEXT_6 = "{" + NL + "\t\t\tpublic org.talend.mdm.webservice.WSUpdateMetadataItem makeUpdateMeteItm(String taskID,org.talend.mdm.webservice.WSItemPK wspk){" + NL + "\t\t\t\torg.talend.mdm.webservice.WSUpdateMetadataItem wsUpdateMetadataItem = new org.talend.mdm.webservice.WSUpdateMetadataItem();" + NL + "\t\t        wsUpdateMetadataItem.setTaskId(taskID);" + NL + "\t\t        wsUpdateMetadataItem.setWsItemPK(wspk);" + NL + "\t\t        return wsUpdateMetadataItem;" + NL + "\t\t\t}" + NL + "\t\t\tpublic org.talend.mdm.webservice.WSUpdateMetadataItem[] makeUpdateMeteItms(java.util.List<String> taskIDs,org.talend.mdm.webservice.WSItemPK[] wspks){" + NL + "\t\t\t\tjava.util.List<org.talend.mdm.webservice.WSUpdateMetadataItem> wsUpdateMetadataItems = new java.util.ArrayList<org.talend.mdm.webservice.WSUpdateMetadataItem>();" + NL + "\t\t\t\tint i = 0;" + NL + "\t\t        for(org.talend.mdm.webservice.WSItemPK wspk : wspks){" + NL + "\t\t        \twsUpdateMetadataItems.add(makeUpdateMeteItm(taskIDs.get(i),wspk));" + NL + "\t\t        \ti++;" + NL + "\t\t        }" + NL + "\t\t        return wsUpdateMetadataItems.toArray(new org.talend.mdm.webservice.WSUpdateMetadataItem[wsUpdateMetadataItems.size()]);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tUtil_";
  protected final String TEXT_7 = " util_";
  protected final String TEXT_8 = " = new Util_";
  protected final String TEXT_9 = "();" + NL + "\t";
  protected final String TEXT_10 = NL + "\t";
  protected final String TEXT_11 = NL + "\t\t\tjava.util.List <org.talend.mdm.webservice.WSPutItemWithReport> miList_";
  protected final String TEXT_12 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSPutItemWithReport>();" + NL + "\t";
  protected final String TEXT_13 = NL + "\t\t\tjava.util.List <org.talend.mdm.webservice.WSPutItem> miList_";
  protected final String TEXT_14 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSPutItem>();" + NL + "\t";
  protected final String TEXT_15 = NL + "\t\t\tjava.util.List<String> taskIDs_";
  protected final String TEXT_16 = " = new java.util.ArrayList<String>();" + NL + "\t";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL + "\torg.talend.mdm.webservice.TMDMService_ServiceLocator tmdmService_";
  protected final String TEXT_19 = " = new org.talend.mdm.webservice.TMDMService_ServiceLocator();" + NL + "\ttmdmService_";
  protected final String TEXT_20 = ".setTMDMPortEndpointAddress(";
  protected final String TEXT_21 = ");" + NL + "\torg.talend.mdm.webservice.TMDMService_PortType tmdmWS_";
  protected final String TEXT_22 = " = tmdmService_";
  protected final String TEXT_23 = ".getTMDMPort();    " + NL + "\torg.talend.mdm.webservice.TMDMServiceSoapBindingStub stub_";
  protected final String TEXT_24 = " = (org.talend.mdm.webservice.TMDMServiceSoapBindingStub)tmdmWS_";
  protected final String TEXT_25 = ";" + NL + "\t" + NL + "\t// Authentification" + NL + "\tstub_";
  protected final String TEXT_26 = ".setUsername(";
  protected final String TEXT_27 = ");" + NL + "\t";
  protected final String TEXT_28 = NL + "    ";
  protected final String TEXT_29 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_30 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = "; ";
  protected final String TEXT_35 = NL + NL + "\tstub_";
  protected final String TEXT_36 = ".setPassword(decryptedPassword_";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\torg.talend.mdm.webservice.TMDMService_PortType tmdmWS_";
  protected final String TEXT_39 = " = (org.talend.mdm.webservice.TMDMService_PortType)globalMap.get(\"";
  protected final String TEXT_40 = "\");";
  protected final String TEXT_41 = NL + NL + "org.talend.mdm.webservice.WSDataClusterPK dataCluster_";
  protected final String TEXT_42 = " = new org.talend.mdm.webservice.WSDataClusterPK(";
  protected final String TEXT_43 = " + \"";
  protected final String TEXT_44 = "\");" + NL + "org.talend.mdm.webservice.WSDataModelPK dataModel_";
  protected final String TEXT_45 = " = new org.talend.mdm.webservice.WSDataModelPK(";
  protected final String TEXT_46 = ");" + NL + "" + NL + "String input_";
  protected final String TEXT_47 = ";" + NL + "" + NL + "org.talend.mdm.webservice.WSItemPK[] wspks_";
  protected final String TEXT_48 = ";" + NL + "org.talend.mdm.webservice.WSItemPK wspk_";
  protected final String TEXT_49 = ";";
  protected final String TEXT_50 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
	if(destination!=null && !"".equals(destination)){
		cid = destination;
	}

	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "TMDMService_" + connection;
	String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
	String username = ElementParameterParser.getValue(node, "__USERNAME__");

	String dataModule = ElementParameterParser.getValue(node, "__DATAMODEL__");
	String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");
	boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));
	
	boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
	boolean isMassInsert =("true").equals(ElementParameterParser.getValue(node,"__EXTENDINSERT__"));
	
	boolean addTaskID = ("true").equals(ElementParameterParser.getValue(node,"__ADD_TASKID__"));
	boolean usePartialUpdate = ("true").equals(ElementParameterParser.getValue(node,"__USE_PARTIAL_UPDATE__"));
	

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    if(!usePartialUpdate){
    stringBuffer.append(TEXT_4);
    if(addTaskID){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    if(isMassInsert){
		if(!isStaging && withReport){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    	}else{
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
		}
		if(addTaskID){
	
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    	
		}
	}
}
    stringBuffer.append(TEXT_17);
    if(!useExistingConn){
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_27);
    
    String passwordFieldName = "__PASSWORD__";
    
    stringBuffer.append(TEXT_28);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_31);
    } else {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    }else{
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(dataCluster );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(isStaging?"#STAGING":"");
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(dataModule );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(TEXT_50);
    return stringBuffer.toString();
  }
}
