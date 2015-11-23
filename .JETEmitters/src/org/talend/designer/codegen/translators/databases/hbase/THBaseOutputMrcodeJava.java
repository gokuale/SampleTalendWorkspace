package org.talend.designer.codegen.translators.databases.hbase;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class THBaseOutputMrcodeJava
{
  protected static String nl;
  public static synchronized THBaseOutputMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseOutputMrcodeJava result = new THBaseOutputMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t\t\tpublic static class ";
  protected final String TEXT_3 = "StructOutputFormat implements OutputFormat<NullWritable, ";
  protected final String TEXT_4 = "Struct> {" + NL + "\t\t\t\tprotected static class HBaseTableRecordWriter implements" + NL + "\t\t\t\t\t\tRecordWriter<NullWritable, ";
  protected final String TEXT_5 = "Struct> {" + NL + "\t\t\t\t\tprivate org.apache.hadoop.hbase.client.HTable m_table;" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tContextProperties context;" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tpublic HBaseTableRecordWriter(org.apache.hadoop.hbase.client.HTable table, Configuration job) {" + NL + "\t\t\t\t\t\tthis.m_table = table;" + NL + "\t\t\t\t\t\tcontext = new ContextProperties(job);" + NL + "\t\t\t\t\t}" + NL + "\t\t" + NL + "\t\t\t\t\tprivate void writeObject(";
  protected final String TEXT_6 = "Struct value) throws IOException {" + NL + "\t\t\t\t\t\tbyte[] rowKey = org.apache.hadoop.hbase.util.Bytes.toBytes(value.";
  protected final String TEXT_7 = ");" + NL + "\t\t\t\t\t\torg.apache.hadoop.hbase.client.Put put = new org.apache.hadoop.hbase.client.Put(rowKey);" + NL + "\t\t\t\t\t\tbyte[] temp = null;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t\t\t\t\ttemp = null;" + NL + "\t\t\t\t\t\t\t\tif(value.";
  protected final String TEXT_9 = "!=null){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\t\t\t\ttemp = org.apache.hadoop.hbase.util.Bytes.toBytes(FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_11 = ", ";
  protected final String TEXT_12 = "));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\t\t\t\ttemp = value.";
  protected final String TEXT_14 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\t\t\ttemp = org.apache.hadoop.hbase.util.Bytes.toBytes(value.";
  protected final String TEXT_16 = "+\"\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t\t\ttemp = org.apache.hadoop.hbase.util.Bytes.toBytes(value.";
  protected final String TEXT_18 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\t\t\t\ttemp = org.apache.hadoop.hbase.util.Bytes.toBytes(value.";
  protected final String TEXT_20 = ".toString());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\t\t\tput.add(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_23 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(\"";
  protected final String TEXT_24 = "\"), temp);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t\t\tthis.m_table.put(put);" + NL + "\t\t\t\t\t}" + NL + "\t\t" + NL + "\t\t\t\t\tpublic void write(NullWritable key, ";
  protected final String TEXT_26 = "Struct value)" + NL + "\t\t\t\t\t\t\tthrows IOException {" + NL + "\t\t" + NL + "\t\t\t\t\t\tboolean nullValue = value == null;" + NL + "\t\t\t\t\t\tif (nullValue) {" + NL + "\t\t\t\t\t\t\treturn;" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\twriteObject(value);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t" + NL + "\t\t\t\t\tpublic synchronized void close(Reporter reporter) throws IOException {" + NL + "\t\t\t\t\t\tthis.m_table.close();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tContextProperties context;" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic RecordWriter<NullWritable, ";
  protected final String TEXT_27 = "Struct> getRecordWriter(" + NL + "\t\t\t\t\t\tFileSystem ignored, JobConf job, String name, Progressable progress) throws IOException{" + NL + "\t\t\t\t\tcontext = new ContextProperties(job);" + NL + "\t\t\t\t\tJobConf hbaseJob = new JobConf(job);" + NL + "\t\t\t\t\thbaseJob.set(\"hbase.zookeeper.quorum\", ";
  protected final String TEXT_28 = ");" + NL + "\t\t\t\t\thbaseJob.set(\"hbase.zookeeper.property.clientPort\", ";
  protected final String TEXT_29 = ");" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\t\thbaseJob.set(\"zookeeper.znode.parent\",";
  protected final String TEXT_31 = "); " + NL + "\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\thbaseJob.set(";
  protected final String TEXT_33 = ",";
  protected final String TEXT_34 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\torg.apache.hadoop.hbase.client.HTable hTable = new org.apache.hadoop.hbase.client.HTable(hbaseJob, ";
  protected final String TEXT_36 = ");" + NL + "\t\t\t\t\thTable.setAutoFlush(false);" + NL + "\t\t\t\t\treturn new HBaseTableRecordWriter(hTable, job);" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic void checkOutputSpecs(FileSystem ignored, JobConf job)" + NL + "\t\t\t\t  throws FileAlreadyExistsException, InvalidJobConfException, IOException {" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();  
    String cid = node.getUniqueName();
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if(metadatas != null && metadatas.size() > 0) {
        IMetadataTable metadata = metadatas.get(0);
        if(metadata != null){
        
			String zookeeper_quorum = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
			String zookeeper_client_port = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
			
			boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
			String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");
						
			String table_name = ElementParameterParser.getValue(node, "__TABLE__");
			String rowKey = ElementParameterParser.getValue(node, "__ROWKEY_COLUMN__");
			List<Map<String,String>> families = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__FAMILIES__");
			boolean contains_rowKey = "true".equals(ElementParameterParser.getValue(node, "__CONTAIN_ROWKEY__"));
	  		
	  		String connName = "";
	        
		    List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
		    if(inConns != null && inConns.size() > 0){
		    	IConnection inConn = inConns.get(0); 
		        connName = inConn.getName();
		    }else{
		        return "";
		    }
    
		    List<IMetadataColumn> columns = metadata.getListColumns();
		    int columnSize = columns.size();
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(rowKey);
    stringBuffer.append(TEXT_7);
    
						for(int familyNum = 0; familyNum < families.size(); familyNum++){
							IMetadataColumn column = columns.get(familyNum);
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							Map<String,String> mapLine = families.get(familyNum);
							String schema_column = mapLine.get("SCHEMA_COLUMN");
							String family_column = mapLine.get("FAMILY_COLUMN");
							if(family_column==null || family_column.trim().length()==0){
								continue;
							}
							if(!contains_rowKey){
								if(schema_column.equals(rowKey)){
									continue;
								}
							}
							boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
							if(!isPrimitive){
							
    stringBuffer.append(TEXT_8);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_9);
    
							}
							if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
							
    stringBuffer.append(TEXT_10);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_11);
    stringBuffer.append( pattern);
    stringBuffer.append(TEXT_12);
    
							}else if (javaType == JavaTypesManager.BYTE_ARRAY) {
							
    stringBuffer.append(TEXT_13);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_14);
    
							}else if (javaType == JavaTypesManager.BYTE) {
							
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_16);
    
							}else if(JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable())) {
							
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_18);
    
							}else{
							
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_20);
    
							}
							if(!isPrimitive){
							
    stringBuffer.append(TEXT_21);
    
							}
							
    stringBuffer.append(TEXT_22);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_24);
    
						}
						
    stringBuffer.append(TEXT_25);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(zookeeper_quorum);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(zookeeper_client_port);
    stringBuffer.append(TEXT_29);
    
					if(setZNodeParent) {
					
    stringBuffer.append(TEXT_30);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_31);
    
					}
					
					List<Map<String, String>> properties =
				        (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__HBASE_PARAMETERS__");
				   	for(int i=0;i<properties.size();i++){
				   		Map<String, String> map = properties.get(i);
				   		String property = map.get("PROPERTY");
				   		String value= map.get("VALUE");
						
    stringBuffer.append(TEXT_32);
    stringBuffer.append(property);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_34);
    
				   	}
					
    stringBuffer.append(TEXT_35);
    stringBuffer.append(table_name);
    stringBuffer.append(TEXT_36);
    
    	}
	}   
	
    return stringBuffer.toString();
  }
}
