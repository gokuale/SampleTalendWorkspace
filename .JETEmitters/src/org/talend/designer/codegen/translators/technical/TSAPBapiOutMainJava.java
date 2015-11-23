package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import org.talend.core.model.utils.TalendTextUtils;
import java.util.Map;

public class TSAPBapiOutMainJava
{
  protected static String nl;
  public static synchronized TSAPBapiOutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPBapiOutMainJava result = new TSAPBapiOutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\trowCount_";
  protected final String TEXT_2 = "_";
  protected final String TEXT_3 = "++;" + NL + "\tif(rowCount_";
  protected final String TEXT_4 = "_";
  protected final String TEXT_5 = " == 1) {" + NL + "\t\tdocumentHelper_";
  protected final String TEXT_6 = ".addTableParameter(\"";
  protected final String TEXT_7 = "\",";
  protected final String TEXT_8 = ");" + NL + "\t}" + NL + "\t" + NL + "\tdocumentHelper_";
  protected final String TEXT_9 = ".addTableRow();" + NL + "\t";
  protected final String TEXT_10 = NL + "\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_12 = ", ";
  protected final String TEXT_13 = ")";
  protected final String TEXT_14 = NL + "\t\t\t\t";
  protected final String TEXT_15 = ".toPlainString()";
  protected final String TEXT_16 = NL + "\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_17 = ")).toString()";
  protected final String TEXT_18 = NL + "\t\t\t\tString.valueOf(";
  protected final String TEXT_19 = ")";
  protected final String TEXT_20 = NL + "\tdocumentHelper_";
  protected final String TEXT_21 = ".addTableRowChildParameter(\"";
  protected final String TEXT_22 = "\",";
  protected final String TEXT_23 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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
	
	String incomingName = (String)codeGenArgument.getIncomingName();
	
    List<Map<String, String>> originalInputParameters = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING_INPUT__");
	
	String currentTableName = null;
	List<IMetadataColumn> currentColumns = null;
	
	boolean isChanging = false;
	
	for(Map<String, String> originalInputParameter : originalInputParameters){
		Map<String, String> inputParameter = new java.util.HashMap<String, String>();
		inputParameter.put("NAME", TalendTextUtils.removeQuotes(originalInputParameter.get("NAME")));
		inputParameter.put("TYPE", TalendTextUtils.removeQuotes(originalInputParameter.get("TYPE")));
		inputParameter.put("SCHEMA", TalendTextUtils.removeQuotes(originalInputParameter.get("SCHEMA")));
		inputParameter.put("PARENT_ROW", TalendTextUtils.removeQuotes(originalInputParameter.get("PARENT_ROW")));
		
		String type = inputParameter.get("TYPE");
		
		if(!"TABLE".equals(type)) {
			continue;
		}
		
		String sourceRow = inputParameter.get("PARENT_ROW");
		if(sourceRow==null || "".equals(sourceRow) || !sourceRow.equals(incomingName)) {
			continue;
		}
		
		String componentSchemaName = inputParameter.get("SCHEMA");
		
		if(componentSchemaName == null || "".equals(componentSchemaName)) {
			continue;
		}
		
		IMetadataTable metadata = node.getMetadataTable(componentSchemaName);
		
		
		List<IMetadataColumn> columns = metadata.getListColumns();
		
		if(columns == null || columns.isEmpty()) {
			continue;
		}
		
		currentTableName = inputParameter.get("NAME");
		currentColumns = columns;
		
		isChanging = "true".equals(originalInputParameter.get("CHANGING"));
		
		break;
	}
	
	if(currentTableName == null || currentColumns == null) {
		return "";
	}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(incomingName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(incomingName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(currentTableName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(isChanging);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
	class ColumnValueFormatter {
		
		public void format(String valueExpression, IMetadataColumn column) {
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			//boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
			
			if(javaType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(valueExpression );
    
			} else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(valueExpression);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_13);
    
			} else if(javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getPrecision() == null? valueExpression : valueExpression + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_15);
    
			} else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(valueExpression);
    stringBuffer.append(TEXT_17);
    
			} else {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(valueExpression);
    stringBuffer.append(TEXT_19);
    
			}
		}
		
	}
	
	ColumnValueFormatter columnValueFormatter = new ColumnValueFormatter();

    
	for(IMetadataColumn column : currentColumns) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_22);
    columnValueFormatter.format(incomingName + "." + column.getLabel(),column);
    stringBuffer.append(TEXT_23);
    
	}

    return stringBuffer.toString();
  }
}
