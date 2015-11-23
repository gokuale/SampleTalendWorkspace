package org.talend.designer.codegen.translators.elasticsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.NodeUtil;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TElasticSearchOutputSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TElasticSearchOutputSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TElasticSearchOutputSparkstreamingconfigJava result = new TElasticSearchOutputSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "rdd_";
  protected final String TEXT_2 = NL + "\t.mapToPair(new ";
  protected final String TEXT_3 = "_toMetadataFunction(job))";
  protected final String TEXT_4 = NL + "\t.map(new ";
  protected final String TEXT_5 = "_toJsonFunction(job))" + NL + "\t";
  protected final String TEXT_6 = NL + ".foreachRDD(new ";
  protected final String TEXT_7 = "_saveFunction(job));";
  protected final String TEXT_8 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    
IMetadataTable metadata = null;
IConnection conn = null;
List<IMetadataColumn> columns = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if((metadatas!=null) && (metadatas.size() > 0)){
    metadata = metadatas.get(0);
    if(metadata != null){
		columns = metadata.getListColumns();		
	}
}
List<? extends IConnection> conns = node.getIncomingConnections();
if(conns != null && conns.size() > 0 && conns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
    conn = conns.get(0);
}

if(columns == null || columns.isEmpty() || conn == null){
	return "";
}

String inRowStruct = codeGenArgument.getRecordStructName(conn);
String connName = conn.getName();

    
String nodes = ElementParameterParser.getValue(node, "__NODES__");	
String index = ElementParameterParser.getValue(node, "__INDEX__");
String type = ElementParameterParser.getValue(node, "__TYPE__");
boolean jsonDoc = "JSON".equals(ElementParameterParser.getValue(node, "__DOC_TYPE__"));
List<Map<String, String>> configuration = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CONFIGURATION__");
List<Map<String, String>> docMetadatas = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__DOC_METADATA__");

Map<String, String> docMetadataMapping = new HashMap<String, String>();

org.talend.core.model.metadata.MetadataTable docColumnTable = new org.talend.core.model.metadata.MetadataTable(); //for non-metadata column

List<IMetadataColumn> docColumnList = new ArrayList<IMetadataColumn>();
docColumnTable.setListColumns(docColumnList);

for(Map<String, String> docMetadata : docMetadatas){
	if("true".equals(docMetadata.get("AS_META"))){
		docMetadataMapping.put(docMetadata.get("SCHEMA_COLUMN"), docMetadata.get("TYPE"));
	}else{
	    for(IMetadataColumn col : columns){
	        if(col.getLabel().equals(docMetadata.get("SCHEMA_COLUMN"))){
	            docColumnList.add(col);
	        }
	    }
	}
}
final boolean definedDocMetadata = docMetadataMapping.size() > 0; 
if(definedDocMetadata && !jsonDoc){
	codeGenArgument.getRecordStructGenerator().generateRecordStruct("doc_" + connName, docColumnTable);
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(connName);
    
if(definedDocMetadata){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    	
}else{
	if(jsonDoc){
	
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	}	
}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
