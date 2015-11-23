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
import org.talend.designer.common.tsetkeystore.TSetKeystoreUtil;

public class TElasticSearchOutputSparkcodeJava
{
  protected static String nl;
  public static synchronized TElasticSearchOutputSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TElasticSearchOutputSparkcodeJava result = new TElasticSearchOutputSparkcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tpublic static class ";
  protected final String TEXT_2 = "_toMetadataFunction implements org.apache.spark.api.java.function.PairFunction<";
  protected final String TEXT_3 = ", Object, Object>{" + NL + "\t\tprivate ContextProperties context = null;" + NL + "\t    " + NL + "\t    public ";
  protected final String TEXT_4 = "_toMetadataFunction(JobConf job){" + NL + "\t \t\tthis.context = new ContextProperties(job);" + NL + "\t    }" + NL + "\t    " + NL + "\t\tpublic scala.Tuple2<Object, Object> call(";
  protected final String TEXT_5 = " row) throws Exception{" + NL + "\t    \tjava.util.Map<org.elasticsearch.spark.rdd.Metadata, Object> meta = new java.util.HashMap<org.elasticsearch.spark.rdd.Metadata, Object>();" + NL + "\t    \t";
  protected final String TEXT_6 = NL + "\t\t    \tmeta.put(org.elasticsearch.spark.rdd.Metadata.";
  protected final String TEXT_7 = ", row.";
  protected final String TEXT_8 = ");" + NL + "\t\t    ";
  protected final String TEXT_9 = NL + "\t    \t";
  protected final String TEXT_10 = NL + "\t    \t\treturn new scala.Tuple2<Object, Object>(meta, row.json_document);" + NL + "\t    \t";
  protected final String TEXT_11 = NL + "\t\t    \t";
  protected final String TEXT_12 = " docRow = new ";
  protected final String TEXT_13 = "();" + NL + "\t\t    \t";
  protected final String TEXT_14 = NL + "\t\t\t    \tdocRow.";
  protected final String TEXT_15 = " = row.";
  protected final String TEXT_16 = ";" + NL + "\t\t    \t";
  protected final String TEXT_17 = NL + "\t\t    \treturn new scala.Tuple2<Object, Object>(meta, docRow);" + NL + "\t    \t";
  protected final String TEXT_18 = NL + "\t    }\t" + NL + "\t}";
  protected final String TEXT_19 = NL + "\t\tpublic static class ";
  protected final String TEXT_20 = "_toJsonFunction implements org.apache.spark.api.java.function.Function<";
  protected final String TEXT_21 = ", String>{" + NL + "\t\t\tprivate ContextProperties context = null;" + NL + "\t\t    " + NL + "\t\t    public ";
  protected final String TEXT_22 = "_toJsonFunction(JobConf job){" + NL + "\t\t \t\tthis.context = new ContextProperties(job);" + NL + "\t\t    }" + NL + "\t\t    " + NL + "\t\t\tpublic String call(";
  protected final String TEXT_23 = " row) throws Exception{" + NL + "\t\t    \treturn row.json_document;" + NL + "\t\t    }\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t";
  protected final String TEXT_24 = NL + "public static class ";
  protected final String TEXT_25 = "_saveFunction implements org.apache.spark.api.java.function.Function<";
  protected final String TEXT_26 = ", Void>{" + NL + "\tprivate ContextProperties context = null;" + NL + "" + NL + "    public ";
  protected final String TEXT_27 = "_saveFunction(JobConf job){" + NL + " \t\tthis.context = new ContextProperties(job);" + NL + "    }" + NL + "\tpublic Void call(";
  protected final String TEXT_28 = " rdd) throws Exception{" + NL + "\t    " + NL + "    \tjava.util.Map<String, String> config = new java.util.HashMap<String, String>();" + NL + "    \t";
  protected final String TEXT_29 = NL + "\t\t\tconfig.put(";
  protected final String TEXT_30 = ", ";
  protected final String TEXT_31 = ");" + NL + "\t\t";
  protected final String TEXT_32 = NL + "\t\t\tconfig.put(org.elasticsearch.hadoop.cfg.ConfigurationOptions.ES_NET_USE_SSL, \"true\");" + NL + "\t\t\tconfig.put(org.elasticsearch.hadoop.cfg.ConfigurationOptions.ES_NET_SSL_CERT_ALLOW_SELF_SIGNED, \"true\");" + NL + "\t\t\tconfig.put(org.elasticsearch.hadoop.cfg.ConfigurationOptions.ES_NET_SSL_TRUST_STORE_LOCATION, ";
  protected final String TEXT_33 = ");" + NL + "\t\t\tconfig.put(org.elasticsearch.hadoop.cfg.ConfigurationOptions.ES_NET_SSL_TRUST_STORE_PASS, ";
  protected final String TEXT_34 = ");" + NL + "\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\tconfig.put(org.elasticsearch.hadoop.cfg.ConfigurationOptions.ES_NET_SSL_KEYSTORE_LOCATION, ";
  protected final String TEXT_36 = ");" + NL + "\t\t\t\tconfig.put(org.elasticsearch.hadoop.cfg.ConfigurationOptions.ES_NET_SSL_KEYSTORE_PASS, ";
  protected final String TEXT_37 = ");" + NL + "\t\t\t\tconfig.put(org.elasticsearch.hadoop.cfg.ConfigurationOptions.ES_NET_SSL_KEYSTORE_TYPE, ";
  protected final String TEXT_38 = ");" + NL + "\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(" + NL + "\t\t\t    \tnew javax.net.ssl.HostnameVerifier(){" + NL + "\t\t\t      \t\tpublic boolean verify(String hostName,javax.net.ssl.SSLSession session)" + NL + "\t\t\t       \t\t\t{" + NL + "\t\t\t       \t\t\t\treturn true;" + NL + "\t\t\t       \t\t\t}" + NL + "\t\t\t     \t}" + NL + "\t\t\t    );" + NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t";
  protected final String TEXT_42 = NL + "    \tconfig.put(org.elasticsearch.hadoop.cfg.ConfigurationOptions.ES_NODES, ";
  protected final String TEXT_43 = ");" + NL + "    \t";
  protected final String TEXT_44 = NL + "\t\t\tconfig.put(org.elasticsearch.hadoop.cfg.ConfigurationOptions.ES_INPUT_JSON, \"true\");" + NL + "\t\t";
  protected final String TEXT_45 = NL + "\t\t" + NL + "\t\torg.elasticsearch.spark.rdd.api.java.JavaEsSpark.";
  protected final String TEXT_46 = "saveToEsWithMeta";
  protected final String TEXT_47 = "saveToEs";
  protected final String TEXT_48 = "(rdd, ";
  protected final String TEXT_49 = " + \"/\" + ";
  protected final String TEXT_50 = ", config);" + NL + "    \t" + NL + "        return null;" + NL + "    }" + NL + "}";
  protected final String TEXT_51 = NL;

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
String docRowStruct = "doc_" + connName + "Struct";

if(definedDocMetadata){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_5);
    
	    	for(String columnName : docMetadataMapping.keySet()){
		    
    stringBuffer.append(TEXT_6);
    stringBuffer.append(docMetadataMapping.get(columnName));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_8);
    
	    	}
	    	
    stringBuffer.append(TEXT_9);
    if(jsonDoc){
    stringBuffer.append(TEXT_10);
    }else{
    stringBuffer.append(TEXT_11);
    stringBuffer.append(docRowStruct);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(docRowStruct);
    stringBuffer.append(TEXT_13);
    
		    	for(IMetadataColumn docColumn : docColumnList){
		    		String docColumName = docColumn.getLabel();
		    		
    stringBuffer.append(TEXT_14);
    stringBuffer.append(docColumName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(docColumName);
    stringBuffer.append(TEXT_16);
    
		    	}
		    	
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    
}else{
	if(jsonDoc){
	
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_23);
    
	}
}

String rowType = jsonDoc ? "String" : inRowStruct;
String rddType = definedDocMetadata ? "org.apache.spark.api.java.JavaPairRDD<Object, Object>" : "org.apache.spark.api.java.JavaRDD<" + rowType + ">" ;

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(rddType);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(rddType);
    stringBuffer.append(TEXT_28);
    
    	for(Map<String, String> config : configuration){
		
    stringBuffer.append(TEXT_29);
    stringBuffer.append(config.get("KEY"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(config.get("VALUE"));
    stringBuffer.append(TEXT_31);
    
    	}
    	
    
		TSetKeystoreUtil tSetKeystoreUtil = new TSetKeystoreUtil(node);
		if(tSetKeystoreUtil.useHTTPS()){
		
    stringBuffer.append(TEXT_32);
    stringBuffer.append(tSetKeystoreUtil.getTrustStorePath());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(tSetKeystoreUtil.getTrustStorePassword());
    stringBuffer.append(TEXT_34);
    if(tSetKeystoreUtil.needClientAuth()){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(tSetKeystoreUtil.getTrustStorePath());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(tSetKeystoreUtil.getTrustStorePassword());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(tSetKeystoreUtil.getTrustStoreType());
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    if(!tSetKeystoreUtil.needVerifyName()){
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    
		}
		
    stringBuffer.append(TEXT_42);
    stringBuffer.append(nodes);
    stringBuffer.append(TEXT_43);
    if(jsonDoc){
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    if(definedDocMetadata){
    stringBuffer.append(TEXT_46);
    }else{
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(TEXT_51);
    return stringBuffer.toString();
  }
}
