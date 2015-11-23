package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.TalendTextUtils;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class TSAPBapiInBeginJava
{
  protected static String nl;
  public static synchronized TSAPBapiInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPBapiInBeginJava result = new TSAPBapiInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\torg.dom4j.Document outputDocument_";
  protected final String TEXT_2 = " = (org.dom4j.Document)globalMap.get(\"outputDocument_";
  protected final String TEXT_3 = "\");" + NL + "\torg.talend.sap.DocumentExtractor documentExtractor_";
  protected final String TEXT_4 = " = new org.talend.sap.DocumentExtractor(outputDocument_";
  protected final String TEXT_5 = ",";
  protected final String TEXT_6 = ");" + NL + "\tString stringValue_";
  protected final String TEXT_7 = " = null;";
  protected final String TEXT_8 = NL + "\t\tboolean go_";
  protected final String TEXT_9 = "_";
  protected final String TEXT_10 = " = true;";
  protected final String TEXT_11 = NL + "\t\tList<String> columnNames_";
  protected final String TEXT_12 = "_";
  protected final String TEXT_13 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_14 = NL + "\t\t\tcolumnNames_";
  protected final String TEXT_15 = "_";
  protected final String TEXT_16 = ".add(\"";
  protected final String TEXT_17 = "\");";
  protected final String TEXT_18 = NL + "\t\t\tList<List<String>> table_";
  protected final String TEXT_19 = "_";
  protected final String TEXT_20 = " = documentExtractor_";
  protected final String TEXT_21 = ".getTableResult(\"";
  protected final String TEXT_22 = "\",columnNames_";
  protected final String TEXT_23 = "_";
  protected final String TEXT_24 = ");" + NL + "\t\t\tgo_";
  protected final String TEXT_25 = "_";
  protected final String TEXT_26 = " = (table_";
  protected final String TEXT_27 = "_";
  protected final String TEXT_28 = "!=null && table_";
  protected final String TEXT_29 = "_";
  protected final String TEXT_30 = ".size()>0);" + NL + "\t\t\tjava.util.Iterator<List<String>> tableIter_";
  protected final String TEXT_31 = "_";
  protected final String TEXT_32 = " = null;" + NL + "\t\t\tif(go_";
  protected final String TEXT_33 = "_";
  protected final String TEXT_34 = ") {" + NL + "\t\t\t\ttableIter_";
  protected final String TEXT_35 = "_";
  protected final String TEXT_36 = " = table_";
  protected final String TEXT_37 = "_";
  protected final String TEXT_38 = ".iterator();" + NL + "\t\t\t}";
  protected final String TEXT_39 = NL + NL + "\t";
  protected final String TEXT_40 = NL + "\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\tParserUtils.parseTo_Date(";
  protected final String TEXT_42 = ", ";
  protected final String TEXT_43 = ")";
  protected final String TEXT_44 = NL + "\t\t\t\t";
  protected final String TEXT_45 = ".getBytes()";
  protected final String TEXT_46 = NL + "\t\t\t\tParserUtils.parseTo_";
  protected final String TEXT_47 = "(";
  protected final String TEXT_48 = ")";
  protected final String TEXT_49 = NL + NL + "\twhile(";
  protected final String TEXT_50 = NL + "\t\tgo_";
  protected final String TEXT_51 = "_";
  protected final String TEXT_52 = NL + "\t\t||";
  protected final String TEXT_53 = NL + "\t) {";
  protected final String TEXT_54 = NL + "\t\t";
  protected final String TEXT_55 = " = null; ";
  protected final String TEXT_56 = NL + "\t\t\tif(go_";
  protected final String TEXT_57 = "_";
  protected final String TEXT_58 = ") {" + NL + "\t\t\t\tgo_";
  protected final String TEXT_59 = "_";
  protected final String TEXT_60 = " = false;" + NL + "\t\t\t\t";
  protected final String TEXT_61 = " = new ";
  protected final String TEXT_62 = "Struct();";
  protected final String TEXT_63 = NL + "\t\t\t\t\tstringValue_";
  protected final String TEXT_64 = " = documentExtractor_";
  protected final String TEXT_65 = ".getSingleResult(\"";
  protected final String TEXT_66 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = " = ";
  protected final String TEXT_69 = ";";
  protected final String TEXT_70 = NL + "\t\t\t}";
  protected final String TEXT_71 = NL + "\t\t\tif(go_";
  protected final String TEXT_72 = "_";
  protected final String TEXT_73 = ") {" + NL + "\t\t\t\tgo_";
  protected final String TEXT_74 = "_";
  protected final String TEXT_75 = " = false;" + NL + "\t\t\t\t";
  protected final String TEXT_76 = " = new ";
  protected final String TEXT_77 = "Struct();" + NL + "\t\t\t\tList<String> structure_";
  protected final String TEXT_78 = " = documentExtractor_";
  protected final String TEXT_79 = ".getStructureResult(\"";
  protected final String TEXT_80 = "\",columnNames_";
  protected final String TEXT_81 = "_";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL + "\t\t\t\t\tstringValue_";
  protected final String TEXT_84 = " = structure_";
  protected final String TEXT_85 = ".get(";
  protected final String TEXT_86 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = " = ";
  protected final String TEXT_89 = ";";
  protected final String TEXT_90 = NL + "\t\t\t}";
  protected final String TEXT_91 = NL + "\t\t\tif(go_";
  protected final String TEXT_92 = "_";
  protected final String TEXT_93 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_94 = " = new ";
  protected final String TEXT_95 = "Struct();" + NL + "\t\t\t\tList<String> tableRow_";
  protected final String TEXT_96 = " = tableIter_";
  protected final String TEXT_97 = "_";
  protected final String TEXT_98 = ".next();";
  protected final String TEXT_99 = NL + "\t\t\t\t\tstringValue_";
  protected final String TEXT_100 = " = tableRow_";
  protected final String TEXT_101 = ".get(";
  protected final String TEXT_102 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = " = ";
  protected final String TEXT_105 = ";";
  protected final String TEXT_106 = NL + "\t\t\t\tgo_";
  protected final String TEXT_107 = "_";
  protected final String TEXT_108 = " = tableIter_";
  protected final String TEXT_109 = "_";
  protected final String TEXT_110 = ".hasNext();" + NL + "\t\t\t}";
  protected final String TEXT_111 = NL + "\t//}";
  protected final String TEXT_112 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String graphicalUniqueName = cid.replace("_TSAPBapi_IN","");
	
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	List<IConnection> connections = new java.util.ArrayList<IConnection>();
	List<String> connNames = new java.util.ArrayList<String>(); 
	
	if(conns!=null){
		for(int i=0;i<conns.size();i++){
			IConnection conn = conns.get(i);
		    if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		   		connections.add(conn);
		   		connNames.add(conn.getName());
		    }
		}
	}
	
	if(connections.isEmpty()) {
		return "";
	}

	List<Map<String, String>> originalOutputParameters = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SCHEMAS__");
	List<Map<String, Object>> outputParameters = new ArrayList<Map<String, Object>>();
	
	for(int i=0;i<connections.size();i++){
		IConnection conn = connections.get(i);
		IMetadataTable metadata = conn.getMetadataTable();
		
		for(Map<String, String> originalOutputParameter : originalOutputParameters){
			String schemaName = TalendTextUtils.removeQuotes(originalOutputParameter.get("SCHEMA"));
			if(metadata.getTableName().equals(schemaName)) {
				Map<String, Object> outputParameter = new java.util.HashMap<String, Object>();
				outputParameter.put("NAME", TalendTextUtils.removeQuotes(originalOutputParameter.get("NAME")));
				outputParameter.put("TYPE", TalendTextUtils.removeQuotes(originalOutputParameter.get("TYPE")));
				outputParameter.put("SCHEMA", schemaName);
				List<IMetadataColumn> columns = metadata.getListColumns();
				outputParameter.put("COLUMNS",columns);
				outputParameter.put("CONNECTION",conn.getName());
				outputParameters.add(outputParameter);
				break;
			}
		}
	}
	
	String sapFunction = ElementParameterParser.getValue(node,"__SAP_FUNCTION__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(graphicalUniqueName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sapFunction);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
	for(Map<String, Object> outputParameter : outputParameters){
		String name = (String)outputParameter.get("NAME");
		String type = (String)outputParameter.get("TYPE");
		String schemaName = (String)outputParameter.get("SCHEMA");
		String connectionName = (String)outputParameter.get("CONNECTION"); 
		List<IMetadataColumn> columns = (List<IMetadataColumn>)outputParameter.get("COLUMNS");
		if(columns == null || columns.isEmpty()) {
			continue;
		}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
		if("SINGLE".equals(type)) {
			continue;
		}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
		for(IMetadataColumn column : columns) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_17);
    
		}
		
		if("STRUCTURE".equals(type)) {
			continue;
		}
		
		if("TABLE".equals(type)) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    		
		}
	}

    stringBuffer.append(TEXT_39);
    
	class ColumnValueParser {
		
		public void parse(String valueExpression,IMetadataColumn column) {
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
			if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_40);
    stringBuffer.append(valueExpression);
    
			} else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(valueExpression);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_43);
    
			} else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(valueExpression);
    stringBuffer.append(TEXT_45);
    
			} else {

    stringBuffer.append(TEXT_46);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(valueExpression);
    stringBuffer.append(TEXT_48);
    
			}
		}
		
	}
	
	ColumnValueParser columnValueParser = new ColumnValueParser();

    stringBuffer.append(TEXT_49);
    
	Iterator<Map<String, Object>> iterator = outputParameters.iterator();
	while(iterator.hasNext()){
		Map<String, Object> outputParameter = iterator.next();
		String schemaName = (String)outputParameter.get("SCHEMA");

    stringBuffer.append(TEXT_50);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    
		if(iterator.hasNext()) {

    stringBuffer.append(TEXT_52);
    
		}
	}

    stringBuffer.append(TEXT_53);
    
	for(Map<String, Object> outputParameter : outputParameters){
		String name = (String)outputParameter.get("NAME");
		String type = (String)outputParameter.get("TYPE");
		String schemaName = (String)outputParameter.get("SCHEMA");
		String connectionName = (String)outputParameter.get("CONNECTION"); 
		List<IMetadataColumn> columns = (List<IMetadataColumn>)outputParameter.get("COLUMNS");

    stringBuffer.append(TEXT_54);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_55);
    
		if("SINGLE".equals(type)) {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_62);
    
				for(int i=0;i<columns.size();i++) {
					IMetadataColumn column = columns.get(i);

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_68);
    columnValueParser.parse("stringValue_" + cid,column);
    stringBuffer.append(TEXT_69);
    
				}

    stringBuffer.append(TEXT_70);
    
			continue;
		}
		
		if("STRUCTURE".equals(type)) {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    
				for(int i=0;i<columns.size();i++) {
					IMetadataColumn column = columns.get(i);

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_88);
    columnValueParser.parse("stringValue_" + cid,column);
    stringBuffer.append(TEXT_89);
    
				}

    stringBuffer.append(TEXT_90);
    
			continue;
		}
		
		if("TABLE".equals(type)) {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    
				for(int i=0;i<columns.size();i++) {
					IMetadataColumn column = columns.get(i);

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_104);
    columnValueParser.parse("stringValue_" + cid,column);
    stringBuffer.append(TEXT_105);
    
				}

    stringBuffer.append(TEXT_106);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    
		}
	}

    stringBuffer.append(TEXT_111);
    stringBuffer.append(TEXT_112);
    return stringBuffer.toString();
  }
}
