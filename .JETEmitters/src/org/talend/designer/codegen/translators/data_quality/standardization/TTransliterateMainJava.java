package org.talend.designer.codegen.translators.data_quality.standardization;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TTransliterateMainJava
{
  protected static String nl;
  public static synchronized TTransliterateMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTransliterateMainJava result = new TTransliterateMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "//to transliterate the input column: ";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = " = " + NL + "\tgcardone.junidecode.Junidecode.unidecode(";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "//not to transliterat the input column: ";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = ";";
  protected final String TEXT_15 = NL + "nb_line_";
  protected final String TEXT_16 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	//boolean transliterate  = "true".equals(ElementParameterParser.getValue(node, "__COLUMNS_TRANS__"));
	List<Map<String, String>> transliterate = 
			(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TABLE_CONFIG__");

	Map<String, Boolean> mapColTrans = new HashMap<String, Boolean>();
	for (Map<String, String> mapCol : transliterate){
		String columnName = mapCol.get("SCHEMA_COLUMN");
		boolean isTransliterate = "true".equals(mapCol.get("COLUMNS_TRANS"));
		mapColTrans.put(columnName,isTransliterate);
	}
	
	String inputConnName = null;
	Set<String> inputCols = new HashSet<String>();
	
	if (node.getIncomingConnections()!=null) {
		for (IConnection incomingConn : node.getIncomingConnections()) {
			if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				inputConnName = incomingConn.getName();
				IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
				for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
					inputCols.add(inputCol.getLabel());
				}
				break;
			}
		}
	}

    stringBuffer.append(TEXT_2);
    	

for (IConnection conn : node.getOutgoingConnections()) {
	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		IMetadataTable outputMetadataTable = conn.getMetadataTable();
		if (outputMetadataTable!=null) {
			for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) { 
				if (inputCols.contains(outputCol.getLabel())) {
					
					if(mapColTrans.get(outputCol.getLabel())){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_8);
    
					}else{

    stringBuffer.append(TEXT_9);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_14);
    				
					}
				}
			}
		}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    			
		break;
	}
}

    return stringBuffer.toString();
  }
}
