package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMOutputEndJava
{
  protected static String nl;
  public static synchronized TMDMOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMOutputEndJava result = new TMDMOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " " + NL + "\tif(miList_";
  protected final String TEXT_3 = ".size() > 0){" + NL + "\t\twspks_";
  protected final String TEXT_4 = " = tmdmWS_";
  protected final String TEXT_5 = ".putItemWithReportArray(miList_";
  protected final String TEXT_6 = ".toArray(new org.talend.mdm.webservice.WSPutItemWithReport[miList_";
  protected final String TEXT_7 = ".size()]));" + NL + "\t\tmiList_";
  protected final String TEXT_8 = ".clear();" + NL + "\t\tmiList_";
  protected final String TEXT_9 = " = null;" + NL + "\t\t";
  protected final String TEXT_10 = NL + "\t\t" + NL + "\t\t\tint i2_";
  protected final String TEXT_11 = " = 0;" + NL + "\t\t    for(org.talend.mdm.webservice.WSItemPK wspk2_";
  protected final String TEXT_12 = " : wspks_";
  protected final String TEXT_13 = "){" + NL + "\t\t    \twspk2_";
  protected final String TEXT_14 = ".setWsDataClusterPK(dataCluster_";
  protected final String TEXT_15 = ");" + NL + "\t\t    \ttmdmWS_";
  protected final String TEXT_16 = ".updateItemMetadata(util_";
  protected final String TEXT_17 = ".makeUpdateMeteItm(taskIDs_";
  protected final String TEXT_18 = ".get(i2_";
  protected final String TEXT_19 = "), wspk2_";
  protected final String TEXT_20 = "));" + NL + "\t\t    \ti2_";
  protected final String TEXT_21 = "++;" + NL + "\t\t    }" + NL + "\t\t    " + NL + "        \ttaskIDs_";
  protected final String TEXT_22 = ".clear();";
  protected final String TEXT_23 = NL + "\t}";
  protected final String TEXT_24 = NL + "\tif(miList_";
  protected final String TEXT_25 = ".size() > 0){" + NL + "\t\twspks_";
  protected final String TEXT_26 = " = tmdmWS_";
  protected final String TEXT_27 = ".putItemArray(miList_";
  protected final String TEXT_28 = ".toArray(new org.talend.mdm.webservice.WSPutItem[miList_";
  protected final String TEXT_29 = ".size()]));" + NL + "\t\tmiList_";
  protected final String TEXT_30 = ".clear();" + NL + "\t\tmiList_";
  protected final String TEXT_31 = " = null;" + NL + "\t\t";
  protected final String TEXT_32 = NL + "\t\t" + NL + "        \tint i2_";
  protected final String TEXT_33 = " = 0;" + NL + "\t\t    for(org.talend.mdm.webservice.WSItemPK wspk2_";
  protected final String TEXT_34 = " : wspks_";
  protected final String TEXT_35 = "){" + NL + "\t\t    \twspk2_";
  protected final String TEXT_36 = ".setWsDataClusterPK(dataCluster_";
  protected final String TEXT_37 = ");" + NL + "\t\t    \ttmdmWS_";
  protected final String TEXT_38 = ".updateItemMetadata(util_";
  protected final String TEXT_39 = ".makeUpdateMeteItm(taskIDs_";
  protected final String TEXT_40 = ".get(i2_";
  protected final String TEXT_41 = "), wspk2_";
  protected final String TEXT_42 = "));" + NL + "\t\t    \ti2_";
  protected final String TEXT_43 = "++;" + NL + "\t\t    }" + NL + "\t\t    " + NL + "        \ttaskIDs_";
  protected final String TEXT_44 = ".clear();";
  protected final String TEXT_45 = NL + "\t}";
  protected final String TEXT_46 = NL + " \t";
  protected final String TEXT_47 = NL + " \t\tstub_";
  protected final String TEXT_48 = ".logout(new org.talend.mdm.webservice.WSLogout());" + NL + " \t";
  protected final String TEXT_49 = NL + " \t" + NL + " \tglobalMap.put(\"";
  protected final String TEXT_50 = "_NB_LINE\",nb_line_";
  protected final String TEXT_51 = ");             " + NL + " \tglobalMap.put(\"";
  protected final String TEXT_52 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "            ";

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
	
	boolean isMassInsert =("true").equals(ElementParameterParser.getValue(node,"__EXTENDINSERT__"));
	boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
	
	boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));
	
	boolean addTaskID = ("true").equals(ElementParameterParser.getValue(node,"__ADD_TASKID__"));
	String taskID = ElementParameterParser.getValue(node,"__TASKID__");
	boolean usePartialUpdate = ("true").equals(ElementParameterParser.getValue(node,"__USE_PARTIAL_UPDATE__"));

    stringBuffer.append(TEXT_1);
    
if(!usePartialUpdate){
	if(isMassInsert){
		if(!isStaging && withReport){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    if(addTaskID){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    
		}else{
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    if(addTaskID){
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    
		}
	}
}
    stringBuffer.append(TEXT_46);
    if(!useExistingConn){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(TEXT_54);
    return stringBuffer.toString();
  }
}
