package org.talend.designer.codegen.translators.data_quality.survivorship;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TRuleSurvivorshipBeginJava
{
  protected static String nl;
  public static synchronized TRuleSurvivorshipBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRuleSurvivorshipBeginJava result = new TRuleSurvivorshipBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\torg.talend.survivorship.SurvivorshipManager manager_";
  protected final String TEXT_3 = " = new org.talend.survivorship.SurvivorshipManager(\"";
  protected final String TEXT_4 = "\", ";
  protected final String TEXT_5 = ");" + NL + "\t\t\t\t\tmanager_";
  protected final String TEXT_6 = ".setJobName(jobName);" + NL + "                    manager_";
  protected final String TEXT_7 = ".setJobVersion(jobVersion);" + NL + "                    //manager_";
  protected final String TEXT_8 = ".setRulePath( \"";
  protected final String TEXT_9 = "/metadata/survivorship/\" + ";
  protected final String TEXT_10 = ");" + NL + "\t\t\t\t\t//manager_";
  protected final String TEXT_11 = ".setPackageName(";
  protected final String TEXT_12 = ");" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\t\tmanager_";
  protected final String TEXT_14 = ".addColumn(\"";
  protected final String TEXT_15 = "\",\"";
  protected final String TEXT_16 = "\");" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\tmanager_";
  protected final String TEXT_18 = ".addRuleDefinition(" + NL + "\t\t\t\t\t\t\tnew org.talend.survivorship.model.RuleDefinition(" + NL + "\t\t\t\t\t\t\t\torg.talend.survivorship.model.RuleDefinition.Order.";
  protected final String TEXT_19 = NL + "\t\t\t\t\t\t\t\t,";
  protected final String TEXT_20 = NL + "\t\t\t\t\t\t\t\t,\"";
  protected final String TEXT_21 = "\"                                " + NL + "\t\t\t\t\t\t\t\t,";
  protected final String TEXT_22 = "null";
  protected final String TEXT_23 = "org.talend.survivorship.model.RuleDefinition.Function.";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\t\t\t,";
  protected final String TEXT_25 = NL + "\t\t\t\t\t\t\t\t,\"";
  protected final String TEXT_26 = "\"" + NL + "                                ,";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\t\t)" + NL + "\t\t\t\t\t\t);" + NL + "\t\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\tmanager_";
  protected final String TEXT_29 = ".initKnowledgeBase();" + NL + "\t\t\t\t\tint groupSize_";
  protected final String TEXT_30 = " = 0;" + NL + "\t\t\t\t\tObject groupID_";
  protected final String TEXT_31 = " = null;" + NL + "\t\t\t    \tint groupCount_";
  protected final String TEXT_32 = " = 0;" + NL + "\t\t\t    \tObject[][] groupValues_";
  protected final String TEXT_33 = " = new Object[1][1];" + NL + "\t\t\t\t\tObject tmpValue_";
  protected final String TEXT_34 = " = null;" + NL + "\t\t\t\t\tjava.util.Map<String, Object> survivors_";
  protected final String TEXT_35 = " = null;" + NL + "\t\t\t\t\tjava.util.List<java.util.HashSet<String>> conflicts_";
  protected final String TEXT_36 = " = null;" + NL + "\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_37 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	
	if ((metadatas!=null) && (metadatas.size() > 0)) {//1
	    IMetadataTable metadata = metadatas.get(0);
	    if (metadata != null) {//2
	    	List< ? extends IConnection> conns = node.getIncomingConnections();
	    	for (IConnection conn : conns) {//3
	    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
			
					IMetadataTable inputMetadataTable = null;
					java.util.List<IMetadataColumn> inputColumns = null;
					List<? extends IConnection> incomingConnections = node.getIncomingConnections();
					if (incomingConnections != null && !incomingConnections.isEmpty()) {
						for (IConnection inConn : incomingConnections) {
							inputMetadataTable = inConn.getMetadataTable();
							inputColumns = inputMetadataTable.getListColumns();
							break;
						}
					}
					String packageName = ElementParameterParser.getValue(node, "__PACKAGE_NAME__");
					//String rulePath = ElementParameterParser.getValue(node, "__RULE_PATH__");
					String projectDir = ElementParameterParser.getValue(node.getProcess(), "__COMP_DEFAULT_PROJECT_DIR__");
					String jobName = node.getProcess().getName();
                    String jobVersion = node.getProcess().getVersion();
					
					List<Map<String, String>> operations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
					
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(projectDir);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(packageName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(projectDir);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(packageName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(packageName);
    stringBuffer.append(TEXT_12);
    
					for(IMetadataColumn column : inputColumns){
						String typeName = "";
						//if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){
						//	typeName = JavaTypesManager.getJavaTypeFromId(column.getTalendType()).getPrimitiveClass().toString();
						//}else{
						typeName = column.getTalendType().substring(column.getTalendType().indexOf("_")+1);
						if(typeName.equals("Date")){
							typeName = "java.util.Date";
						}
						//}
					
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_16);
    
					}
					for(int i=0; i<operations.size(); i++){
						Map<String, String> operation = operations.get(i);
						String relation = operation.get("RELATION");
						String name = operation.get("RULE_NAME");
                        String reference = operation.get("INPUT_COLUMN");
						String function = operation.get("FUNCTION");
						String operationValue = operation.get("OPERATION");
                        String target = operation.get("OUTPUT_COLUMN");//?
						String ignoreNull = operation.get("IGNORE_NULL");
						
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(relation);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(reference);
    stringBuffer.append(TEXT_21);
    if("None".equals(function)){
    stringBuffer.append(TEXT_22);
    }else{
    stringBuffer.append(TEXT_23);
    stringBuffer.append(function);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append("\"\"".equals(operationValue)?null:operationValue);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(target);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(ignoreNull);
    stringBuffer.append(TEXT_27);
    
					}
					
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
				}//4
			}//3
		}//2
	}//1

    stringBuffer.append(TEXT_37);
    return stringBuffer.toString();
  }
}
