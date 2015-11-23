package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.TalendTextUtils;
import java.util.List;
import java.util.Map;

public class TSAPBapiOutBeginJava
{
  protected static String nl;
  public static synchronized TSAPBapiOutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPBapiOutBeginJava result = new TSAPBapiOutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\torg.talend.sap.DocumentHelper documentHelper_";
  protected final String TEXT_3 = " = new org.talend.sap.DocumentHelper(); " + NL + "\tdocumentHelper_";
  protected final String TEXT_4 = ".setFunctionName(";
  protected final String TEXT_5 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_8 = ", ";
  protected final String TEXT_9 = ")";
  protected final String TEXT_10 = NL + "\t\t\t\t";
  protected final String TEXT_11 = ".toPlainString()";
  protected final String TEXT_12 = NL + "\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_13 = ")).toString()";
  protected final String TEXT_14 = NL + "\t\t\t\tString.valueOf(";
  protected final String TEXT_15 = ")";
  protected final String TEXT_16 = NL + "\t\t\tdocumentHelper_";
  protected final String TEXT_17 = ".addSingleParameter(\"";
  protected final String TEXT_18 = "\",";
  protected final String TEXT_19 = ",";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\t\tdocumentHelper_";
  protected final String TEXT_22 = ".addStructParameter(\"";
  protected final String TEXT_23 = "\",";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t\t\tdocumentHelper_";
  protected final String TEXT_26 = ".addStructChildParameter(\"";
  protected final String TEXT_27 = "\",";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\tint rowCount_";
  protected final String TEXT_30 = "_";
  protected final String TEXT_31 = " = 0;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String graphicalUniqueName = cid.replace("_TSAPBapi_OUT","");
	List<? extends INode> grpapicalNodes = node.getProcess().getGraphicalNodes();
	INode graphicalNode = null;
	for(INode gnode : grpapicalNodes) {
		if(graphicalUniqueName.equals(gnode.getUniqueName())) {
			graphicalNode = gnode;
			break;
		}
	}
	
	List<? extends IConnection> incomingConns = node.getIncomingConnections();

    List<Map<String, String>> originalInputParameters = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING_INPUT__");
	
	List<String> usefulConnections = new java.util.ArrayList<String>();
	
	String sapFunction = ElementParameterParser.getValue(node,"__SAP_FUNCTION__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(sapFunction);
    stringBuffer.append(TEXT_5);
    
	class ColumnValueFormatter {
		
		public void format(String valueExpression, IMetadataColumn column) {
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			//boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
			
			if(javaType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(valueExpression );
    
			} else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(valueExpression);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_9);
    
			} else if(javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(column.getPrecision() == null? valueExpression : valueExpression + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_11);
    
			} else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(valueExpression);
    stringBuffer.append(TEXT_13);
    
			} else {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(valueExpression);
    stringBuffer.append(TEXT_15);
    
			}
		}
		
	}
	
	ColumnValueFormatter columnValueFormatter = new ColumnValueFormatter();

    
	for(Map<String, String> originalInputParameter : originalInputParameters){
		Map<String, String> inputParameter = new java.util.HashMap<String, String>();
		inputParameter.put("NAME", TalendTextUtils.removeQuotes(originalInputParameter.get("NAME")));
		inputParameter.put("TYPE", TalendTextUtils.removeQuotes(originalInputParameter.get("TYPE")));
		inputParameter.put("SCHEMA", TalendTextUtils.removeQuotes(originalInputParameter.get("SCHEMA")));
		inputParameter.put("PARENT_ROW", TalendTextUtils.removeQuotes(originalInputParameter.get("PARENT_ROW")));
		
		String name = inputParameter.get("NAME");
		String type = inputParameter.get("TYPE");
		
		String componentSchemaName = inputParameter.get("SCHEMA");
		
		if(componentSchemaName == null || "".equals(componentSchemaName)) {
			continue;
		}
		
	
		IMetadataTable metadata = node.getMetadataTable(componentSchemaName);
		
		List<IMetadataColumn> columns = metadata.getListColumns();
		
		if(columns == null || columns.isEmpty()) {
			continue;
		}
		
		boolean isChanging = "true".equals(originalInputParameter.get("CHANGING"));
		
		if("SINGLE".equals(type)) {
			IMetadataColumn column = columns.get(0);

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_18);
    columnValueFormatter.format(column.getDefault(),column);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(isChanging);
    stringBuffer.append(TEXT_20);
    
		} else if("STRUCTURE".equals(type)) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(isChanging);
    stringBuffer.append(TEXT_24);
    
			for(IMetadataColumn column : columns) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_27);
    columnValueFormatter.format(column.getDefault(),column);
    stringBuffer.append(TEXT_28);
    
			}
		} else if("TABLE".equals(type)) {
			
			String sourceRow = inputParameter.get("PARENT_ROW");
			if(sourceRow==null || "".equals(sourceRow)) {
				continue;
			}
			
			for(int i=0;i<incomingConns.size();i++){
    			IConnection sourceConn = incomingConns.get(i);
	    		if (sourceConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA) && sourceRow.equals(sourceConn.getName())) {
	    			usefulConnections.add(sourceRow);
	    		}
    		}
    		
		}
		
	}
	
	for(String connName : usefulConnections) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_31);
    
	}

    return stringBuffer.toString();
  }
}
