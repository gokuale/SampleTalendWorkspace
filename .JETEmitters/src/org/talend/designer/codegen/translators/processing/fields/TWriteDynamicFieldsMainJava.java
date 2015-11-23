package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Set;
import java.util.HashSet;

public class TWriteDynamicFieldsMainJava
{
  protected static String nl;
  public static synchronized TWriteDynamicFieldsMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteDynamicFieldsMainJava result = new TWriteDynamicFieldsMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t// Copy Dynamic " + NL + "\t";
  protected final String TEXT_4 = "=";
  protected final String TEXT_5 = ".copy();";
  protected final String TEXT_6 = NL + "\t";
  protected final String TEXT_7 = "=new routines.system.Dynamic();";
  protected final String TEXT_8 = NL + NL + "\t// Mapping Standard Column";
  protected final String TEXT_9 = NL + "\t";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = "=";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ";";
  protected final String TEXT_14 = NL + "  " + NL + "  \t//Add Dynamic Metedata" + NL + "\tint recordCount_";
  protected final String TEXT_15 = "=";
  protected final String TEXT_16 = ".getColumnCount();" + NL + "" + NL + "\troutines.system.DynamicMetadata DynamicElement_";
  protected final String TEXT_17 = "=null;" + NL;
  protected final String TEXT_18 = NL + "\tDynamicElement_";
  protected final String TEXT_19 = " = new routines.system.DynamicMetadata();" + NL + "" + NL + "    DynamicElement_";
  protected final String TEXT_20 = ".setName(\"";
  protected final String TEXT_21 = "\");" + NL + "    DynamicElement_";
  protected final String TEXT_22 = ".setDbName(\"";
  protected final String TEXT_23 = "\");" + NL + "    DynamicElement_";
  protected final String TEXT_24 = ".setType(\"";
  protected final String TEXT_25 = "\");" + NL + "    DynamicElement_";
  protected final String TEXT_26 = ".setDbType(\"";
  protected final String TEXT_27 = "\");" + NL + "    DynamicElement_";
  protected final String TEXT_28 = ".setLength(";
  protected final String TEXT_29 = ");" + NL + "    DynamicElement_";
  protected final String TEXT_30 = ".setPrecision(";
  protected final String TEXT_31 = ");" + NL + "    DynamicElement_";
  protected final String TEXT_32 = ".setFormat(";
  protected final String TEXT_33 = ");" + NL + "    DynamicElement_";
  protected final String TEXT_34 = ".setDescription(\"";
  protected final String TEXT_35 = "\");" + NL + "    DynamicElement_";
  protected final String TEXT_36 = ".setKey(";
  protected final String TEXT_37 = ");" + NL + "    DynamicElement_";
  protected final String TEXT_38 = ".setNullable(";
  protected final String TEXT_39 = ");" + NL + "    DynamicElement_";
  protected final String TEXT_40 = ".setSourceType(routines.system.DynamicMetadata.sourceTypes.unknown);" + NL + "    DynamicElement_";
  protected final String TEXT_41 = ".setColumnPosition(recordCount_";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "    ";
  protected final String TEXT_44 = ".metadatas.add(DynamicElement_";
  protected final String TEXT_45 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_46 = NL + "  " + NL + "\t// Add Column to Dynamic";
  protected final String TEXT_47 = NL + "\t//Copy : no clear,unCopy clear" + NL + "\t";
  protected final String TEXT_48 = ".clearColumnValues();";
  protected final String TEXT_49 = NL;
  protected final String TEXT_50 = NL;
  protected final String TEXT_51 = NL + "    ";
  protected final String TEXT_52 = ".addColumnValue(";
  protected final String TEXT_53 = ".";
  protected final String TEXT_54 = ");" + NL + "    " + NL + "   ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	

    
	String outputConnName = null;
	String inputDynamicFullName=null;
	String outputDynamicFullName=null;
	Set<String> outputCols= new HashSet<String>();
	Set<String> outputCols2= new HashSet<String>();

    // Analyse output schema
	for (IConnection conn : node.getOutgoingConnections()) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			IMetadataTable outputMetadataTable = conn.getMetadataTable();
			outputConnName=conn.getName();
			if (outputMetadataTable!=null) {
				for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
					if ( outputCol.getTalendType().equals("id_Dynamic") ) {
					    outputDynamicFullName=outputConnName+"."+outputCol.getLabel();
					} else {
					    outputCols.add(outputCol.getLabel());
					}
				}
			}
		}
   }

    stringBuffer.append(TEXT_1);
     
	if (node.getIncomingConnections()!=null) {
		for (IConnection incomingConn : node.getIncomingConnections()) {
			if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
				for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
					if ( inputCol.getTalendType().equals("id_Dynamic") ) {
					    inputDynamicFullName=incomingConn.getName()+"."+inputCol.getLabel();
					}
				}
				break;
			}
		}
	}

    stringBuffer.append(TEXT_2);
    
	if ( inputDynamicFullName !=null ) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(outputDynamicFullName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(inputDynamicFullName);
    stringBuffer.append(TEXT_5);
    
	} else {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(outputDynamicFullName);
    stringBuffer.append(TEXT_7);
    
	}

    stringBuffer.append(TEXT_8);
     
	if (node.getIncomingConnections()!=null) {
		for (IConnection incomingConn : node.getIncomingConnections()) {
			if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
				for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
					if ( !inputCol.getTalendType().equals("id_Dynamic")&& outputCols.contains(inputCol.getLabel()) ) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inputCol.getLabel());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(incomingConn.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(inputCol.getLabel());
    stringBuffer.append(TEXT_13);
    
					} else {
						outputCols2.add(inputCol.getLabel());
					}
				}
				break;
			}
		}
	}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(outputDynamicFullName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
     
	if (node.getIncomingConnections()!=null) {
		for (IConnection incomingConn : node.getIncomingConnections()) {
			if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
				for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
					if ( !inputCol.getTalendType().equals("id_Dynamic")&& outputCols2.contains(inputCol.getLabel()) ) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(inputCol.getLabel());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(inputCol.getOriginalDbColumnName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(inputCol.getTalendType());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(inputCol.getType());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(inputCol.getLength()==null?-1:inputCol.getLength());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(inputCol.getPrecision()==null?-1:inputCol.getPrecision());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(inputCol.getPattern()==null||"".equals(inputCol.getPattern())?"\"\"":inputCol.getPattern());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(inputCol.getComment());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(inputCol.isKey());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(inputCol.isNullable());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(outputDynamicFullName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
					}
				}
				break;
			}
		}
	}

    stringBuffer.append(TEXT_46);
    
	if ( inputDynamicFullName ==null ) {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(outputDynamicFullName);
    stringBuffer.append(TEXT_48);
     
   	}

    stringBuffer.append(TEXT_49);
     
	if (node.getIncomingConnections()!=null) {
		for (IConnection incomingConn : node.getIncomingConnections()) {
			if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
				for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
					if ( !inputCol.getTalendType().equals("id_Dynamic")&& outputCols2.contains(inputCol.getLabel()) ) {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(outputDynamicFullName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(incomingConn.getName());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(inputCol.getLabel());
    stringBuffer.append(TEXT_54);
    
					}
				}
				break;
			}
		}
	}

    return stringBuffer.toString();
  }
}
