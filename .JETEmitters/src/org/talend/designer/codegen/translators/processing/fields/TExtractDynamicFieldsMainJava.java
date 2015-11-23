package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.Set;
import java.util.HashSet;

public class TExtractDynamicFieldsMainJava
{
  protected static String nl;
  public static synchronized TExtractDynamicFieldsMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractDynamicFieldsMainJava result = new TExtractDynamicFieldsMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "  \troutines.system.Dynamic dynamicTarget_";
  protected final String TEXT_2 = " = new routines.system.Dynamic();" + NL + "  \tList<String> mappingCols_";
  protected final String TEXT_3 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_4 = NL + "\t\t\t\t\t\t\t// mapping all basic type columns execpt Dynamic" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = ";";
  protected final String TEXT_9 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t// mapping all target column from Dynamic" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ".getColumnValue(\"";
  protected final String TEXT_14 = "\");" + NL + "\t\t\t\t\t\t\tmappingCols_";
  protected final String TEXT_15 = ".add(\"";
  protected final String TEXT_16 = "\");";
  protected final String TEXT_17 = "\t\t\t\t" + NL + "                   // mapping dynamic column" + NL + "                   for (int i=0 ; i < ";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ".getColumnCount() ; i++  )\t {" + NL + "\t                   if ( !(mappingCols_";
  protected final String TEXT_20 = ".contains(";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = ".getColumnMetadata(i).getName())) ) { \t                   " + NL + "    \t               dynamicTarget_";
  protected final String TEXT_23 = ".metadatas.add(";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = ".metadatas.get(i));" + NL + "    \t               dynamicTarget_";
  protected final String TEXT_26 = ".addColumnValue(";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = ".getColumnValue(i));" + NL + "    \t               }" + NL + "                   }";
  protected final String TEXT_29 = NL + "                   ";
  protected final String TEXT_30 = "=";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = ".copy();" + NL + "\t\t\t\t   for(int i=0; i<mappingCols_";
  protected final String TEXT_33 = ".size(); i++) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_34 = ".removeDynamicElement(mappingCols_";
  protected final String TEXT_35 = ".get(i));" + NL + "\t\t\t\t   }";
  protected final String TEXT_36 = NL;
  protected final String TEXT_37 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	

    
	String inputConnName = null;
	String inputDynamicName=null;
	String outputDynamicName=null;
	String castDynaColumn=null;
	Set<String> inputCols = new HashSet<String>();
 	
	if (node.getIncomingConnections()!=null) {
		for (IConnection incomingConn : node.getIncomingConnections()) {
			if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				inputConnName = incomingConn.getName();
				IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
				for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
					if ("id_Dynamic".equals(inputCol.getTalendType())) {
					    inputDynamicName=inputCol.getLabel();
					} else {
					    inputCols.add(inputCol.getLabel());
					}
				}
				break;
			}
		}
	}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    	
	for (IConnection conn : node.getOutgoingConnections()) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			IMetadataTable outputMetadataTable = conn.getMetadataTable();
			if (outputMetadataTable!=null) {
				if(inputConnName!=null) {
					for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(outputCol.getTalendType());
						if (javaType == null){
							castDynaColumn = "";
						}
						else if(javaType == JavaTypesManager.STRING ){
							castDynaColumn="(String)";
						}
						else if(javaType == JavaTypesManager.INTEGER ){
							castDynaColumn="(Integer)";
						}
						else if(javaType == JavaTypesManager.LONG ){
							castDynaColumn="(Long)";
						}
						else if(javaType == JavaTypesManager.DOUBLE ){
							castDynaColumn="(Double)";
						}
						else if(javaType == JavaTypesManager.DATE ){
							castDynaColumn="(java.util.Date)";
						}
						else if(javaType == JavaTypesManager.BOOLEAN ){
							castDynaColumn="(Boolean)";
						}
						else if(javaType == JavaTypesManager.BIGDECIMAL ){
							castDynaColumn="(java.math.BigDecimal)";
						}
						else if(javaType == JavaTypesManager.FLOAT ){
							castDynaColumn="(Float)";
						}
						else if(javaType == JavaTypesManager.SHORT ){
							castDynaColumn="(Short)";
						}
						else if(javaType == JavaTypesManager.CHARACTER ){
							castDynaColumn="(Character)";
						}
						else if(javaType == JavaTypesManager.BYTE ){
							castDynaColumn="(Byte)";
						}
						else if ("id_Dynamic".equals(outputCol.getTalendType())) {
						   outputDynamicName=conn.getName()+"."+outputCol.getLabel(); 
						} else {
							castDynaColumn="";
						}
						
						if (inputCols.contains(outputCol.getLabel()) ) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_8);
    
						} else if (!inputCols.contains(outputCol.getLabel())&& !"id_Dynamic".equals(outputCol.getTalendType()) ) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(castDynaColumn);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(inputDynamicName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_16);
    	
						}
					}
				}
				if ( outputDynamicName!=null) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(inputDynamicName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(inputDynamicName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(inputDynamicName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(inputDynamicName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(outputDynamicName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(inputDynamicName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(outputDynamicName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
               }
			}
		}	
	}		

    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    return stringBuffer.toString();
  }
}
