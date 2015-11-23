package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;

public class TMDMWriteConfEndJava
{
  protected static String nl;
  public static synchronized TMDMWriteConfEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMWriteConfEndJava result = new TMDMWriteConfEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t}" + NL + "}";
  protected final String TEXT_2 = NL + "\ttxf_";
  protected final String TEXT_3 = ".join();" + NL + "\tif(txf_";
  protected final String TEXT_4 = ".getLastException()!=null) {" + NL + "\t\tcurrentComponent = txf_";
  protected final String TEXT_5 = ".getCurrentComponent();" + NL + "\t\tthrow txf_";
  protected final String TEXT_6 = ".getLastException();" + NL + "\t}" + NL + "\tglobalMap.remove(\"queue_";
  protected final String TEXT_7 = "\");";
  protected final String TEXT_8 = NL + "\tString readFinishWithExceptionMarkWithPipeId_";
  protected final String TEXT_9 = " = \"";
  protected final String TEXT_10 = "_FINISH_WITH_EXCEPTION\"+(queue_";
  protected final String TEXT_11 = "==null?\"\":queue_";
  protected final String TEXT_12 = ".hashCode());" + NL + "\tif(globalMap.containsKey(readFinishWithExceptionMarkWithPipeId_";
  protected final String TEXT_13 = ")){" + NL + "\t\tglobalMap.put(readFinishWithExceptionMarkWithPipeId_";
  protected final String TEXT_14 = ", null);// syn" + NL + "\t\tglobalMap.remove(readFinishWithExceptionMarkWithPipeId_";
  protected final String TEXT_15 = ");" + NL + "\t\treturn;" + NL + "\t} " + NL + "\tglobalMap.remove(\"queue_";
  protected final String TEXT_16 = "\");";
  protected final String TEXT_17 = NL + "globalMap.put(readFinishMarkWithPipeId_";
  protected final String TEXT_18 = ",null);//syn" + NL + "globalMap.remove(readFinishMarkWithPipeId_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = " " + NL + "\tif(miList_";
  protected final String TEXT_21 = ".size() > 0){" + NL + "\t\twspks_";
  protected final String TEXT_22 = " = tmdmWS_";
  protected final String TEXT_23 = ".putItemWithReportArray(miList_";
  protected final String TEXT_24 = ".toArray(new org.talend.mdm.webservice.WSPutItemWithReport[miList_";
  protected final String TEXT_25 = ".size()]));" + NL + "\t\tmiList_";
  protected final String TEXT_26 = ".clear();" + NL + "\t\tmiList_";
  protected final String TEXT_27 = " = null;" + NL + "\t\t";
  protected final String TEXT_28 = NL + "        \t" + NL + "        \tint i2_";
  protected final String TEXT_29 = " = 0;" + NL + "\t\t\tfor(org.talend.mdm.webservice.WSItemPK wspk2_";
  protected final String TEXT_30 = " : wspks_";
  protected final String TEXT_31 = "){" + NL + "\t\t\t\twspk2_";
  protected final String TEXT_32 = ".setWsDataClusterPK(dataCluster_";
  protected final String TEXT_33 = ");" + NL + "\t\t\t\ttmdmWS_";
  protected final String TEXT_34 = ".updateItemMetadata(util_";
  protected final String TEXT_35 = ".makeUpdateMeteItm(taskIDs_";
  protected final String TEXT_36 = ".get(i2_";
  protected final String TEXT_37 = "), wspk2_";
  protected final String TEXT_38 = "));" + NL + "\t\t\t\ti2_";
  protected final String TEXT_39 = "++;" + NL + "\t\t\t}" + NL + "        \t" + NL + "        \ttaskIDs_";
  protected final String TEXT_40 = ".clear();";
  protected final String TEXT_41 = NL + "\t}";
  protected final String TEXT_42 = NL + "\tif(miList_";
  protected final String TEXT_43 = ".size() > 0){" + NL + "\t\twspks_";
  protected final String TEXT_44 = " = tmdmWS_";
  protected final String TEXT_45 = ".putItemArray(miList_";
  protected final String TEXT_46 = ".toArray(new org.talend.mdm.webservice.WSPutItem[miList_";
  protected final String TEXT_47 = ".size()]));" + NL + "\t\tmiList_";
  protected final String TEXT_48 = ".clear();" + NL + "\t\tmiList_";
  protected final String TEXT_49 = " = null;" + NL + "\t\t";
  protected final String TEXT_50 = NL + "        \t" + NL + "        \tint i2_";
  protected final String TEXT_51 = " = 0;" + NL + "\t\t\tfor(org.talend.mdm.webservice.WSItemPK wspk2_";
  protected final String TEXT_52 = " : wspks_";
  protected final String TEXT_53 = "){" + NL + "\t\t\t\twspk2_";
  protected final String TEXT_54 = ".setWsDataClusterPK(dataCluster_";
  protected final String TEXT_55 = ");" + NL + "\t\t\t\ttmdmWS_";
  protected final String TEXT_56 = ".updateItemMetadata(util_";
  protected final String TEXT_57 = ".makeUpdateMeteItm(taskIDs_";
  protected final String TEXT_58 = ".get(i2_";
  protected final String TEXT_59 = "), wspk2_";
  protected final String TEXT_60 = "));" + NL + "\t\t\t\ti2_";
  protected final String TEXT_61 = "++;" + NL + "\t\t\t}" + NL + "        \t" + NL + "        \ttaskIDs_";
  protected final String TEXT_62 = ".clear();";
  protected final String TEXT_63 = NL + "\t}";
  protected final String TEXT_64 = NL + " \t";
  protected final String TEXT_65 = NL + " \t\tstub_";
  protected final String TEXT_66 = ".logout(new org.talend.mdm.webservice.WSLogout());" + NL + " \t";
  protected final String TEXT_67 = NL + " \t" + NL + " \tglobalMap.put(\"";
  protected final String TEXT_68 = "_NB_LINE\",nb_line_";
  protected final String TEXT_69 = ");  " + NL + " \tglobalMap.put(\"";
  protected final String TEXT_70 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_71 = ");           ";
  protected final String TEXT_72 = NL + "            ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String virtualcid = cid;
	String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
	if(destination!=null && !"".equals(destination)){
		cid = destination;
	}
	
	boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));
	
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	
	boolean isMassInsert =("true").equals(ElementParameterParser.getValue(node,"__EXTENDINSERT__"));
	boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
	
	boolean addTaskID = ("true").equals(ElementParameterParser.getValue(node,"__ADD_TASKID__"));
	String taskID = ElementParameterParser.getValue(node,"__TASKID__");
	boolean usePartialUpdate = ("true").equals(ElementParameterParser.getValue(node,"__USE_PARTIAL_UPDATE__"));

    stringBuffer.append(TEXT_1);
    
INode sourceNode = node.getIncomingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getSource();
String virtualSourceCid = sourceNode.getUniqueName();
INode startNode = NodeUtil.getSpecificStartNode(sourceNode);
String startNodeCid = null; 
if(startNode != null){
	startNodeCid = startNode.getUniqueName();
} 
IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
if(nextMergeConn != null && nextMergeConn.getInputId()>1 && startNodeCid != null){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_7);
    
}else{

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_16);
    
}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
if(!usePartialUpdate){
	if(isMassInsert){
		if(!isStaging && withReport){

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    if(addTaskID){
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    
		}else{
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    if(addTaskID){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    
		}
	}
}
    stringBuffer.append(TEXT_64);
    if(!useExistingConn){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(TEXT_72);
    return stringBuffer.toString();
  }
}
