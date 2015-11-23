package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Map;

public class TStewardshipTaskOutputEndJava
{
  protected static String nl;
  public static synchronized TStewardshipTaskOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TStewardshipTaskOutputEndJava result = new TStewardshipTaskOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\t\tif(targetRecordExisted_";
  protected final String TEXT_3 = "){" + NL + "\t\t\t\t\t\trecord_";
  protected final String TEXT_4 = " = task_";
  protected final String TEXT_5 = ".addTargetRecord();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_6 = NL + "\t    \t\t\t\t\t\trecord_";
  protected final String TEXT_7 = ".addSrcColumn(recordColumn_";
  protected final String TEXT_8 = "_";
  protected final String TEXT_9 = ",recordColumn_";
  protected final String TEXT_10 = "_Value_";
  protected final String TEXT_11 = ",recordColumn_";
  protected final String TEXT_12 = "_Type_";
  protected final String TEXT_13 = ",recordColumn_";
  protected final String TEXT_14 = "_Key_";
  protected final String TEXT_15 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(tasks_";
  protected final String TEXT_17 = ".getTaskCount()>=1){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\t\tint tasksNo_";
  protected final String TEXT_19 = " = tasks_";
  protected final String TEXT_20 = ".getTaskCount();" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_21 = " - Uploading \"+tasksNo_";
  protected final String TEXT_22 = "+\" tasks...\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\tString content = tasks_";
  protected final String TEXT_24 = ".getTasksAndClear();" + NL + "\t\t\t\t\t\t//System.out.println(content);" + NL + "\t\t\t\t\t\tboolean loadResult_";
  protected final String TEXT_25 = " = taskLoadClient_";
  protected final String TEXT_26 = ".doLoad(content);" + NL + "\t\t\t\t\t\tif(!loadResult_";
  protected final String TEXT_27 = "){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_29 = " - An error occured while uploading tasks.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\t\t\t\tSystem.err.println(\"An error occured while uploading tasks.\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\telse{" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_32 = " - Uploaded \"+tasksNo_";
  protected final String TEXT_33 = "+\" tasks successfully.\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\tlog.info(\"";
  protected final String TEXT_36 = " - Has been uploaded \" + nb_line_";
  protected final String TEXT_37 = " + \" tasks.\");" + NL + "\t";
  protected final String TEXT_38 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_39 = "_NB_LINE\",nb_line_";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    String recordType = ElementParameterParser.getValue(node, "__RECORD_TYPE__");
	List<Map<String, String>> recordColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__RECORD_COLUMN__");
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {//1
	    IMetadataTable metadata = metadatas.get(0);
	    if (metadata!=null) {//2
	
	    	List< ? extends IConnection> conns = node.getIncomingConnections();
	    	for (IConnection conn : conns) {//3
	    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
				
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
						if(recordColumns.size()>0){
							for(Map<String, String> recordColumn:recordColumns){
							
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
							}
						}
						
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
						}
						
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
							if(isLog4jEnabled){
							
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
							}
							
    stringBuffer.append(TEXT_30);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
						}
						
    stringBuffer.append(TEXT_34);
    
				}	
			}
		}	
	}
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
	}
	
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(TEXT_41);
    return stringBuffer.toString();
  }
}
