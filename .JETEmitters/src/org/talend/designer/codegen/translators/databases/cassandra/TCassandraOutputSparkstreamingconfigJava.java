package org.talend.designer.codegen.translators.databases.cassandra;

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

public class TCassandraOutputSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TCassandraOutputSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCassandraOutputSparkstreamingconfigJava result = new TCassandraOutputSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\tcom.datastax.driver.core.Cluster cluster_";
  protected final String TEXT_3 = " = (com.datastax.driver.core.Cluster)globalMap.get(\"cluster_";
  protected final String TEXT_4 = "\");" + NL + "        \tcom.datastax.driver.core.Session connection_";
  protected final String TEXT_5 = " = (com.datastax.driver.core.Session)globalMap.get(\"connection_";
  protected final String TEXT_6 = "\");";
  protected final String TEXT_7 = NL + "\t        ";
  protected final String TEXT_8 = NL + "\t";
  protected final String TEXT_9 = NL + "    com.datastax.driver.core.Cluster cluster_";
  protected final String TEXT_10 = " = com.datastax.driver.core.Cluster.builder()" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.addContactPoints(";
  protected final String TEXT_11 = ".split(\",\"))" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.withPort(Integer.valueOf(";
  protected final String TEXT_12 = "))" + NL + "                                                            \t";
  protected final String TEXT_13 = NL + "                                                                \t.withCredentials(";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = ")" + NL + "                                                            \t";
  protected final String TEXT_16 = NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.build();" + NL + "\t" + NL + "\tcom.datastax.driver.core.Session connection_";
  protected final String TEXT_17 = " = null;" + NL + "\tconnection_";
  protected final String TEXT_18 = " = cluster_";
  protected final String TEXT_19 = ".connect();" + NL + "\t        resourceMap.put(\"cluster_";
  protected final String TEXT_20 = "\", cluster_";
  protected final String TEXT_21 = ");" + NL + "\t        resourceMap.put(\"connection_";
  protected final String TEXT_22 = "\", connection_";
  protected final String TEXT_23 = ");" + NL + "\t    ";
  protected final String TEXT_24 = NL + "\t";
  protected final String TEXT_25 = NL + "\t    \t\tconnection_";
  protected final String TEXT_26 = ".execute(";
  protected final String TEXT_27 = ");" + NL + "\t    \t\tconnection_";
  protected final String TEXT_28 = ".execute(";
  protected final String TEXT_29 = ");" + NL + "\t    \t";
  protected final String TEXT_30 = NL + "\t    \t\tconnection_";
  protected final String TEXT_31 = ".execute(";
  protected final String TEXT_32 = ");" + NL + "\t    \t";
  protected final String TEXT_33 = NL + "\t    \t\tconnection_";
  protected final String TEXT_34 = ".execute(";
  protected final String TEXT_35 = ");" + NL + "\t    \t";
  protected final String TEXT_36 = NL + "\t    \t\tconnection_";
  protected final String TEXT_37 = ".execute(";
  protected final String TEXT_38 = ");" + NL + "\t    \t\tconnection_";
  protected final String TEXT_39 = ".execute(";
  protected final String TEXT_40 = ");" + NL + "\t    \t";
  protected final String TEXT_41 = NL + "\t\t\t\tconnection_";
  protected final String TEXT_42 = ".execute(";
  protected final String TEXT_43 = ");" + NL + "\t            connection_";
  protected final String TEXT_44 = ".execute(";
  protected final String TEXT_45 = ");" + NL + "\t            ";
  protected final String TEXT_46 = NL + "\t                System.err.println(\"Don't support create table with set/list/map\");" + NL + "\t            ";
  protected final String TEXT_47 = NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\tconnection_";
  protected final String TEXT_49 = ".execute(";
  protected final String TEXT_50 = ");" + NL + "\t            ";
  protected final String TEXT_51 = NL + "\t                System.err.println(\"Don't support create table with set/list/map\");" + NL + "\t            ";
  protected final String TEXT_52 = NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t            connection_";
  protected final String TEXT_54 = ".execute(";
  protected final String TEXT_55 = ");" + NL + "\t            connection_";
  protected final String TEXT_56 = ".execute(";
  protected final String TEXT_57 = ");" + NL + "\t            ";
  protected final String TEXT_58 = NL + "\t                System.err.println(\"Don't support create table with set/list/map\");" + NL + "\t            ";
  protected final String TEXT_59 = NL + "\t        ";
  protected final String TEXT_60 = NL + "\t            connection_";
  protected final String TEXT_61 = ".execute(";
  protected final String TEXT_62 = ");" + NL + "\t            ";
  protected final String TEXT_63 = NL + "\t                System.err.println(\"Don't support create table with set/list/map\");" + NL + "\t            ";
  protected final String TEXT_64 = NL + "\t        ";
  protected final String TEXT_65 = NL + "\t            connection_";
  protected final String TEXT_66 = ".execute(";
  protected final String TEXT_67 = ");" + NL + "\t        ";
  protected final String TEXT_68 = NL + "\t            connection_";
  protected final String TEXT_69 = ".execute(";
  protected final String TEXT_70 = ");" + NL + "\t        ";
  protected final String TEXT_71 = NL + "\t\t\tclass CassandraBatchUtil_";
  protected final String TEXT_72 = " {" + NL + "\t\t\t\tjava.util.List<Integer> keyPositions = new java.util.ArrayList<Integer>();" + NL + "\t\t\t\tpublic CassandraBatchUtil_";
  protected final String TEXT_73 = "(com.datastax.driver.core.Cluster cluster, String keyspace, String table, List<String> columns){" + NL + "\t\t\t    \tjava.util.List<com.datastax.driver.core.ColumnMetadata> partitionKeys = cluster.getMetadata().getKeyspace(keyspace).getTable(table).getPartitionKey();" + NL + "\t\t\t\t\tjava.util.List<String> partitionColumnKeys = new java.util.ArrayList<String>();" + NL + "\t\t\t\t\tfor(com.datastax.driver.core.ColumnMetadata partitionKey : partitionKeys){" + NL + "\t\t\t\t\t    partitionColumnKeys.add(partitionKey.getName());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tint position = 0;" + NL + "\t\t\t\t\tfor(String col : columns){" + NL + "\t\t\t\t\t\tif(partitionColumnKeys.contains(col)){" + NL + "\t\t\t\t\t\t\tkeyPositions.add(position);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tposition++;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic java.nio.ByteBuffer getKey(com.datastax.driver.core.BoundStatement stmt){" + NL + "\t\t\t\t\tjava.util.List<java.nio.ByteBuffer> keys = new java.util.ArrayList<java.nio.ByteBuffer>();" + NL + "\t\t\t\t\tfor(int position : keyPositions){" + NL + "\t\t\t\t\t\tkeys.add(stmt.getBytesUnsafe(position));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(keys.size() == 1){" + NL + "\t\t\t\t\t\treturn keys.get(0);" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\treturn composeKeys(keys);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tprivate java.nio.ByteBuffer composeKeys(java.util.List<java.nio.ByteBuffer> buffers){" + NL + "\t\t\t\t\tint totalLength = 0;" + NL + "\t\t\t\t\tfor(java.nio.ByteBuffer buffer : buffers){" + NL + "\t\t\t\t\t\ttotalLength += buffer.remaining() + 3;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tjava.nio.ByteBuffer out = java.nio.ByteBuffer.allocate(totalLength);" + NL + "\t\t\t\t\tfor(java.nio.ByteBuffer buffer : buffers){" + NL + "\t\t\t\t\t\tjava.nio.ByteBuffer bb = buffer.duplicate();" + NL + "\t\t\t\t\t\tout.put((byte)((bb.remaining() >> 8) & 0xFF));" + NL + "\t\t\t\t\t    out.put((byte)(bb.remaining() & 0xFF));" + NL + "\t\t\t\t\t    out.put(bb);" + NL + "\t\t\t\t\t    out.put((byte)0);" + NL + "\t\t\t\t    }" + NL + "\t\t\t\t    out.flip();" + NL + "\t\t\t\t    return out;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_74 = NL + "\t\tint nb_line_";
  protected final String TEXT_75 = " = 0;" + NL + "\t    com.datastax.driver.core.PreparedStatement prepareStmt_";
  protected final String TEXT_76 = " = null;" + NL + "\t    prepareStmt_";
  protected final String TEXT_77 = " = connection_";
  protected final String TEXT_78 = ".prepare(";
  protected final String TEXT_79 = ");" + NL + "\t    com.datastax.driver.core.BoundStatement boundStmt_";
  protected final String TEXT_80 = " = null;" + NL + "\t    ";
  protected final String TEXT_81 = NL + "\t    \tjava.util.List<String> columns_";
  protected final String TEXT_82 = " = new java.util.ArrayList<String>();\t" + NL + "\t    \t";
  protected final String TEXT_83 = NL + "\t    \t\tcolumns_";
  protected final String TEXT_84 = ".add(\"";
  protected final String TEXT_85 = "\");" + NL + "\t    \t";
  protected final String TEXT_86 = NL + "\t    \tCassandraBatchUtil_";
  protected final String TEXT_87 = " cassandraBatchUtil_";
  protected final String TEXT_88 = " = new CassandraBatchUtil_";
  protected final String TEXT_89 = "(cluster_";
  protected final String TEXT_90 = ", StringHandling.DQUOTE(";
  protected final String TEXT_91 = "), StringHandling.DQUOTE(";
  protected final String TEXT_92 = "), columns_";
  protected final String TEXT_93 = ");" + NL + "\t\t\tjava.nio.ByteBuffer currentKey_";
  protected final String TEXT_94 = " = null;     " + NL + "\t\t\tjava.nio.ByteBuffer lastKey_";
  protected final String TEXT_95 = " = null;" + NL + "\t\t\tboolean newOne_";
  protected final String TEXT_96 = " = false;    " + NL + "\t    \t" + NL + "\t        com.datastax.driver.core.BatchStatement batchStmt_";
  protected final String TEXT_97 = " = new com.datastax.driver.core.BatchStatement(com.datastax.driver.core.BatchStatement.Type.UNLOGGED);" + NL + "\t    ";
  protected final String TEXT_98 = NL + "\t        boundStmt_";
  protected final String TEXT_99 = " = new com.datastax.driver.core.BoundStatement(prepareStmt_";
  protected final String TEXT_100 = ");" + NL + "\t    ";
  protected final String TEXT_101 = NL + "\t    \torg.apache.spark.SparkConf sparkConf_";
  protected final String TEXT_102 = " = new org.apache.spark.SparkConf(); " + NL + "\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t\tsparkConf_";
  protected final String TEXT_104 = ".set(";
  protected final String TEXT_105 = ", ";
  protected final String TEXT_106 = ");\t" + NL + "\t\t\t";
  protected final String TEXT_107 = NL + "\t\t\tcom.datastax.spark.connector.cql.CassandraConnector cassandraConnector_";
  protected final String TEXT_108 = " = new com.datastax.spark.connector.cql.CassandraConnector(com.datastax.spark.connector.cql.CassandraConnectorConf.apply(sparkConf_";
  protected final String TEXT_109 = "));" + NL + "\t    \tcom.datastax.driver.core.Session connection_";
  protected final String TEXT_110 = " = cassandraConnector_";
  protected final String TEXT_111 = ".openSession();" + NL + "\t\t";
  protected final String TEXT_112 = NL;
  protected final String TEXT_113 = NL + "\t\trdd_";
  protected final String TEXT_114 = ".rdd().conf().set(";
  protected final String TEXT_115 = ", ";
  protected final String TEXT_116 = ");\t" + NL + "\t";
  protected final String TEXT_117 = NL + "    java.util.Map<String, String> columnMapping_";
  protected final String TEXT_118 = " = new java.util.HashMap<String, String>();" + NL + "\t";
  protected final String TEXT_119 = NL + "\t\t\tcolumnMapping_";
  protected final String TEXT_120 = ".put(\"";
  protected final String TEXT_121 = "\", \"";
  protected final String TEXT_122 = "\");" + NL + "    \t";
  protected final String TEXT_123 = NL + "\tcom.datastax.spark.connector.japi.CassandraStreamingJavaUtil.javaFunctions(rdd_";
  protected final String TEXT_124 = ").writerBuilder(" + NL + "    \t\t";
  protected final String TEXT_125 = ", ";
  protected final String TEXT_126 = ", " + NL + "    \t\tcom.datastax.spark.connector.japi.CassandraJavaUtil.mapToRow(";
  protected final String TEXT_127 = ".class, columnMapping_";
  protected final String TEXT_128 = ")" + NL + "\t\t)" + NL + "\t\t.withColumnSelector(com.datastax.spark.connector.japi.CassandraJavaUtil.someColumns(";
  protected final String TEXT_129 = "))" + NL + "\t\t.saveToCassandra();";
  protected final String TEXT_130 = NL + "\trdd_";
  protected final String TEXT_131 = ".foreachRDD(new org.apache.spark.api.java.function.Function<org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_132 = ">, Void>(){" + NL + "        public Void call(org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_133 = "> rdd) throws Exception{" + NL + "        \trdd.foreachPartition(new ";
  protected final String TEXT_134 = "_OutputFunction(job));" + NL + "            return null;" + NL + "        }" + NL + "\t});";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    
	class Column{

        IMetadataColumn column;
        private String mark = "?";
        private String assignmentOperation = "=";
        private Column assignmentKey;
        private boolean asColumnKey = false;
        public Column(IMetadataColumn column){
            this.column = column;
        }
        public String getName(){
            return column.getLabel();
        }
        public String getDBName(){
        	return column.getOriginalDbColumnName();
        }
        public String getTalendType(){
        	return column.getTalendType();
        }
        public String getDBType(){
        	return column.getType();
        }
        public JavaType getJavaType(){
        	return JavaTypesManager.getJavaTypeFromId(getTalendType());
        }
        public boolean isObject(){
        	return !JavaTypesManager.isJavaPrimitiveType(getJavaType(), column.isNullable());
        }
        public boolean isKey(){
        	return column.isKey();
        }
        public String getMark(){
        	return mark;
        }
        public void setMark(String mark){
        	this.mark = mark;
        }
        public void setAssignmentOperation(String op){
            this.assignmentOperation = op;
        }
        public String getAssignmentOperation(){
            return assignmentOperation;
        }
        public void setAssignmentKey(Column keyColumn){
            this.assignmentKey = keyColumn;
        }
        public Column getAssignmentKey(){
            return assignmentKey;
        }
        public void setAsColumnKey(boolean asColumnKey){
            this.asColumnKey = asColumnKey;
        }
        public boolean getAsColumnKey(){
            return asColumnKey;
        }
    }
    
	class CQLManager{
		private String CASSANDRA = "cassandra_datastax_id";
        
        private String[] KeyWords = {"ADD","ALL","ALLOW","ALTER","AND","ANY","APPLY","AS","ASC","ASCII","AUTHORIZE","BATCH","BEGIN","BIGINT","BLOB","BOOLEAN","BY","CLUSTERING","COLUMNFAMILY","COMPACT","CONSISTENCY","COUNT","COUNTER","CREATE","CUSTOM","DECIMAL","DELETE","DESC","DISTINCT","DOUBLE","DROP","EACH_QUORUM","EXISTS","FILTERING","FLOAT","FROM","frozen","GRANT","IF","IN","INDEX","INET","INFINITY","INSERT","INT","INTO","KEY","KEYSPACE","KEYSPACES","LEVEL","LIMIT","LIST","LOCAL_ONE","LOCAL_QUORUM","MAP","MODIFY","NAN","NORECURSIVE","NOSUPERUSER","NOT","OF","ON","ONE","ORDER","PASSWORD","PERMISSION","PERMISSIONS","PRIMARY","QUORUM","RENAME","REVOKE","SCHEMA","SELECT","SET","STATIC","STORAGE","SUPERUSER","TABLE","TEXT","TIMESTAMP","TIMEUUID","THREE","TO","TOKEN","TRUNCATE","TTL","TWO","TYPE","UNLOGGED","UPDATE","USE","USER","USERS","USING","UUID","VALUES","VARCHAR","VARINT","WHERE","WITH","WRITETIME"};
        
        private INode node;
        private String action;
        private String keyspace;
        private String tableName;
        private Boolean useSpark = false;
        private List<Column> valueColumns;

        public CQLManager(INode node, List<IMetadataColumn> columnList){
        	this.node = node;
            this.action = ElementParameterParser.getValue(node, "__DATA_ACTION__");
            this.keyspace = "StringHandling.DQUOTE(" + ElementParameterParser.getValue(node, "__KEY_SPACE__") + ")";
            this.tableName = this.keyspace + " + \".\" + " + "StringHandling.DQUOTE(" + ElementParameterParser.getValue(node, "__COLUMN_FAMILY__") + ")";
            createColumnList(columnList);
            this.valueColumns = collectValueColumns();
        }
        
        public CQLManager(INode node, List<IMetadataColumn> columnList, boolean useSpark){
            this(node, columnList);
            this.useSpark = useSpark;
        }

        private List<Column> all;
    	private List<Column> keys;
    	private List<Column> normals;
    	private List<Column> conditions;
    	private Column ttl;
    	private Column timestamp;

        private void createColumnList(List<IMetadataColumn> columnList){
            all = new ArrayList<Column>();            
            for(IMetadataColumn column : columnList){
                all.add(new Column(column));
            }
            keys = new ArrayList<Column>();
    		normals = new ArrayList<Column>();
    		conditions = new ArrayList<Column>();
			boolean usingTimestamp = "true".equals(ElementParameterParser.getValue(node, "__USING_TIMESTAMP__"));
			String timestampColName = ElementParameterParser.getValue(node, "__TIMESTAMP__");
			for(Column column : all){
    			if("INSERT".equals(action) || "UPDATE".equals(action)){
					boolean usingTTL = "true".equals(ElementParameterParser.getValue(node, "__USING_TTL__"));
					String ttlColName = ElementParameterParser.getValue(node, "__TTL__");
    				if(usingTTL && ttlColName.equals(column.getName())){
    					ttl = column;
    					ttl.setMark("TTL ?");
    					continue;
    				}
    			}
				if(usingTimestamp && timestampColName.equals(column.getName())){
					timestamp = column;
					timestamp.setMark("TIMESTAMP ?");
					continue;
				}
				if(column.isKey()){
    				keys.add(column);
    				continue;
    			}
    			if("UPDATE".equals(action) || ("DELETE".equals(action) && !"true".equals(ElementParameterParser.getValue(node, "__DELETE_IF_EXISTS__")))){
    				List<Map<String,String>> ifCoditions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__IF_CONDITION__");
    				boolean matched = false;
    				for(Map<String, String> ifCodition : ifCoditions){
    					if(ifCodition.get("COLUMN_NAME").equals(column.getName())){
    						conditions.add(column);
    						matched = true;
    						continue;
    					}
    				}
    				if(matched){
    					continue;
    				}
    			}
    			normals.add(column);
			}
            if("UPDATE".equals(action)){
                List<Map<String,String>> assignOperations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ASSIGNMENT_OPERATION__");
                List<Column> keyColumns = new ArrayList<Column>();
                for(Column column : normals){
                    for(Map<String, String> operation : assignOperations){
                        String updateColumnKeyName = operation.get("KEY_COLUMN");
                        String updateColumnOperation = operation.get("OPERATION");
                        if("p/k".equals(updateColumnOperation) && column.getName().equals(updateColumnKeyName)){
                            keyColumns.add(column);
                        }
                    }
                }
                normals.removeAll(keyColumns);
                for(Column column : normals){
                    for(Map<String, String> operation : assignOperations){
                        String updateColumnName = operation.get("COLUMN_NAME");
                        String updateColumnKeyName = operation.get("KEY_COLUMN");
                        String updateColumnOperation = operation.get("OPERATION");
                        if(updateColumnName.equals(column.getName())){
                            column.setAssignmentOperation(updateColumnOperation);
                            if("p/k".equals(updateColumnOperation)){
                                for(Column keyColumn : keyColumns){
                                    if(keyColumn.getName().equals(updateColumnKeyName)){
                                        column.setAssignmentKey(keyColumn);
                                    }
                                }
                            }
                            continue;
                        }
                    }
                }
            }
            if("DELETE".equals(action)){
                List<Map<String,String>> columnsKey = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__DELETE_COLUMN_BY_POSITION_KEY__");
                for(Column column : normals){
                    for(Map<String, String> columnKey : columnsKey){
                        if(column.getName().equals(columnKey.get("COLUMN_NAME"))){
                            column.setAsColumnKey(true);
                        }
                    }
                }
            }
        }
        private List<Column> collectValueColumns(){
        	List<Column> columns = new ArrayList<Column>();
        	if("INSERT".equals(action)){
	        	columns.addAll(keys);
	        	columns.addAll(normals);
	        	if(ttl != null)
	        		columns.add(ttl);
	        	if(timestamp != null)
	        		columns.add(timestamp);
        	}else if("UPDATE".equals(action)){
	        	if(ttl != null)
	        		columns.add(ttl);
	        	if(timestamp != null)
	        		columns.add(timestamp);
	            for(Column normal : normals){
	                if(normal.getAssignmentKey() != null){
	                    columns.add(normal.getAssignmentKey());
	                }
	                columns.add(normal);
	            }
	        	columns.addAll(keys);
	        	columns.addAll(conditions);
        	}else if("DELETE".equals(action)){
	            for(Column column : normals){
	                if(column.getAsColumnKey()){
	                    columns.add(column);
	                }
	            }
	        	if(timestamp != null)
	        		columns.add(timestamp);
	        	columns.addAll(keys);
	        	boolean ifExist = "true".equals(ElementParameterParser.getValue(node, "__DELETE_IF_EXISTS__"));
	            if(!ifExist){
		        	columns.addAll(conditions);
		        }
		    }
        	return columns;
        }
        protected String getDBMSId(){
            return CASSANDRA;
        }
        private String getLProtectedChar(String keyword){
            return "\\\""; 
        }
        private String getRProtectedChar(String keyword){
            return "\\\"";
        }  
        private String wrapProtectedChar(String keyword){
        	if(keyword.matches("^[a-z]+$")){
        		return keyword;
        	}else{
        		return getLProtectedChar(keyword) + keyword + getRProtectedChar(keyword);
        	}
        }
        public List<String> getValueColumns(){
        	java.util.List<String> valueColumnsName = new java.util.ArrayList<String>();
        	for(Column col : valueColumns){
        		valueColumnsName.add(col.getName());
        	}
        	return valueColumnsName;
        }
        public String getDropKSSQL(boolean ifExists){
        	StringBuilder dropKSSQL = new StringBuilder();
        	dropKSSQL.append("\"DROP KEYSPACE ");
        	if(ifExists){
        		dropKSSQL.append("IF EXISTS ");
        	}
        	dropKSSQL.append("\" + ");
        	dropKSSQL.append(this.keyspace);
        	return dropKSSQL.toString();
        }
        public String getCreateKSSQL(boolean ifNotExists){
        	StringBuilder createKSSQL = new StringBuilder();
        	createKSSQL.append("\"CREATE KEYSPACE ");
        	if(ifNotExists){
        		createKSSQL.append("IF NOT EXISTS ");
        	}
        	createKSSQL.append("\" + ");
        	createKSSQL.append(this.keyspace);
        	createKSSQL.append(" + \"");
        	createKSSQL.append("WITH REPLICATION = {\'class\' : \'" + ElementParameterParser.getValue(this.node, "__REPLICA_STRATEGY__") + "\',");
        	if("SimpleStrategy".equals(ElementParameterParser.getValue(this.node, "__REPLICA_STRATEGY__"))){
        		createKSSQL.append("'replication_factor' : \" + " + ElementParameterParser.getValue(this.node, "__SIMEPLE_REPLICA_NUMBER__") + " + \"}\"");
        	}else{
        		List<Map<String, String>> replicas = ElementParameterParser.getTableValue(this.node, "__NETWORK_REPLICA_TABLE__");
        		int count = 1;
        		for(Map<String, String> replica : replicas){
        			createKSSQL.append("\'\" + " + replica.get("DATACENTER_NAME") + " + \"\' : \" + " + replica.get("REPLICA_NUMBER") + " + \"");
        			if(count < replicas.size()){
        				createKSSQL.append(",");
        			}
        			count++;
        		}
        		createKSSQL.append("}\"");
        	}
        	
        	return createKSSQL.toString();
        }
 	    public String getDropTableSQL(boolean ifExists){
 	    	StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("\"DROP TABLE ");
        	if(ifExists){
	            dropTableSQL.append("IF EXISTS ");
        	}
            dropTableSQL.append("\" + " + tableName);
            return dropTableSQL.toString();
 	    }   
        public String getCreateTableSQL(boolean ifNotExists){
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("\"CREATE TABLE ");
            if(ifNotExists){
            	createSQL.append("IF NOT EXISTS ");
            }
            createSQL.append("\" + " + tableName + " + \"(");
            List<Column> columns = new ArrayList<Column>();
            if(!"DELETE".equals(action)){
            	columns.addAll(keys);
            	columns.addAll(normals);
            	if("UPDATE".equals(action)){
            		columns.addAll(conditions);
            	}
            }
            int count = 1;
            for(Column column : columns){
                createSQL.append(wrapProtectedChar(column.getDBName()));
                createSQL.append(" ");
                createSQL.append(validateDBType(column));
				if(count < columns.size()){
                	createSQL.append(",");
                }
                count++;
            }
            if(keys.size() > 0){
                createSQL.append(",PRIMARY KEY(");
                int i = 1;
                for(Column column : keys){
                    createSQL.append(wrapProtectedChar(column.getDBName()));
                    if(i < keys.size()){
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            createSQL.append(")\"");
            return createSQL.toString();
        }
        public boolean containsUnsupportTypes(){
        	boolean unsupport = false;
        	List<String> unsupportTypes = java.util.Arrays.asList(new String[]{"set", "list", "map"});
        	List<Column> columns = new ArrayList<Column>();
            if("INSERT".equals(action)){
            	columns.addAll(keys);
            	columns.addAll(normals);
            }
            for(Column column : columns){
                if(unsupportTypes.contains(validateDBType(column))){
                	return true;
                }
            }
            return false;
        }
        public String getDeleteTableSQL(){
            StringBuilder deleteTableSQL = new StringBuilder();
            deleteTableSQL.append("\"DELETE FROM \" + " + tableName);
            return deleteTableSQL.toString();
        }
        public String getTruncateTableSQL(){
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("\"TRUNCATE \" + " + tableName);
            return truncateTableSQL.toString();
        }
        public String generatePreActionSQL(){
        	if("INSERT".equals(action)){
        		return generatePreInsertSQL();
        	}else if("UPDATE".equals(action)){
        		return generatePreUpdateSQL();
        	}else if("DELETE".equals(action)){
        		return generatePreDeleteSQL();
        	}else{
        		return "";
        	}
        }
        public String generateStmt(String assignStmt, String inConnName){
        	if("INSERT".equals(action) || "UPDATE".equals(action) || "DELETE".equals(action)){
	        	StringBuilder stmt = new StringBuilder();
	        	int index = 0;
	        	for(Column column : valueColumns){
	        		stmt.append(generateSetStmt(assignStmt, column, inConnName, index));
	        		index++;
	        	}
	        	return stmt.toString();
        	}else{
        		return "";
        	}
        }
        /*INSERT INTO table_name
		 *( identifier, column_name...)
		 *VALUES ( value, value ... )
		 *USING option AND option
		 */
        private String generatePreInsertSQL(){
        	List<Column> columns = new ArrayList<Column>();
        	columns.addAll(keys);
        	columns.addAll(normals);
        	
        	int count = 1;
        	StringBuilder preInsertSQL = new StringBuilder();
        	preInsertSQL.append("\"INSERT INTO \" + " + tableName + " + \" (");
        	for(Column column : columns){
                preInsertSQL.append(wrapProtectedChar(column.getDBName()));
				if(count < columns.size()){
                	preInsertSQL.append(",");
                }
                count++;
            }
            preInsertSQL.append(") VALUES (");
            count = 1;
        	for(Column column : columns){
                preInsertSQL.append(column.getMark());
				if(count < columns.size()){
                	preInsertSQL.append(",");
                }
                count++;
            }
            preInsertSQL.append(")");
            boolean ifNotExist = "true".equals(ElementParameterParser.getValue(node, "__INSERT_IF_NOT_EXISTS__"));
            if(ifNotExist){
            	preInsertSQL.append(" IF NOT EXISTS");
            }
            if(ttl != null || timestamp != null){
            	preInsertSQL.append(" USING ");
            	if(ttl != null){
            		preInsertSQL.append(ttl.getMark());
            		if(timestamp != null){
            			preInsertSQL.append(" AND ");
            		}
            	}
            	if(timestamp != null){
            		preInsertSQL.append(timestamp.getMark());
            	}
            }
            preInsertSQL.append("\"");
            return preInsertSQL.toString();
        }
        private String generatePreUpdateSQL(){
        	StringBuilder preUpdateSQL = new StringBuilder();
        	preUpdateSQL.append("\"UPDATE \" + " + tableName + "+ \"");
        	if(ttl != null || timestamp != null){
            	preUpdateSQL.append(" USING ");
            	if(ttl != null){
            		preUpdateSQL.append(ttl.getMark());
            		if(timestamp != null){
            			preUpdateSQL.append(" AND ");
            		}
            	}
            	if(timestamp != null){
            		preUpdateSQL.append(timestamp.getMark());
            	}
            }
            preUpdateSQL.append(" SET ");
        	int count = 1;
        	for(Column column : normals){
                
                String assignment = wrapProtectedChar(column.getDBName()) + "=" + column.getMark();
                
                if("+v".equals(column.getAssignmentOperation())){
                    assignment = wrapProtectedChar(column.getDBName()) + "=" + wrapProtectedChar(column.getDBName()) + "+" + column.getMark();     
                }else if("v+".equals(column.getAssignmentOperation())){
                    assignment = wrapProtectedChar(column.getDBName()) + "=" + column.getMark() + "+" + wrapProtectedChar(column.getDBName());     
                }else if("-".equals(column.getAssignmentOperation())){
                    assignment = wrapProtectedChar(column.getDBName()) + "=" + wrapProtectedChar(column.getDBName()) + "-" + column.getMark();     
                }else if("p/k".equals(column.getAssignmentOperation())){
                    assignment = wrapProtectedChar(column.getDBName()) + "[?]=" + column.getMark(); 
                }

                preUpdateSQL.append(assignment);

				if(count < normals.size()){
                	preUpdateSQL.append(",");
                }
                count++;
            }
            preUpdateSQL.append(" WHERE ");
            count = 1;
        	for(Column column : keys){
                preUpdateSQL.append(wrapProtectedChar(column.getDBName()));
                preUpdateSQL.append(rowKeyInList(column) ? " IN " : "=");
                preUpdateSQL.append(column.getMark());
				if(count < keys.size()){
                	preUpdateSQL.append(" AND ");
                }
                count++;
            }
            if(conditions.size() > 0){
         	   	preUpdateSQL.append(" IF ");
	            count = 1;
	            for(Column column : conditions){
	            	preUpdateSQL.append(wrapProtectedChar(column.getDBName()));
	            	preUpdateSQL.append("=");
                	preUpdateSQL.append(column.getMark());
	            	if(count < conditions.size()){
	                	preUpdateSQL.append(" AND ");
	                }
	                count++;	
	            }
            }
	        // can't work actually, even it supported on office document
            // boolean ifExist = "true".equals(ElementParameterParser.getValue(node, "__UPDATE_IF_EXISTS__"));
            // if(ifExist){
            // 	preUpdateSQL.append(" IF EXISTS");
            // }
            
            preUpdateSQL.append("\"");
            return preUpdateSQL.toString();

        }
        private boolean rowKeyInList(Column column){
            List<Map<String,String>> rowKeyInList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROW_KEY_IN_LIST__");
            for(Map<String, String> rowKey : rowKeyInList){
                if(column.getName().equals(rowKey.get("COLUMN_NAME"))){
                    return true;
                }
            }
            return false;
        }
        private String generatePreDeleteSQL(){
        	StringBuilder preDeleteSQL = new StringBuilder();
        	preDeleteSQL.append("\"DELETE ");
        	int count = 1;
        	for(Column column : normals){
                preDeleteSQL.append(wrapProtectedChar(column.getDBName()));
                if(column.getAsColumnKey()){
                    preDeleteSQL.append("[?]");
                }
				if(count < normals.size()){
                	preDeleteSQL.append(",");
                }
                count++;
            }
            preDeleteSQL.append(" FROM \" + " + tableName + " + \"");
        	if(timestamp != null){
            	preDeleteSQL.append(" USING ");
        		preDeleteSQL.append(timestamp.getMark());
            }
            if(keys.size() > 0){
                preDeleteSQL.append(" WHERE ");
                count = 1;
            	for(Column column : keys){
            		preDeleteSQL.append(wrapProtectedChar(column.getDBName()));
            		preDeleteSQL.append(rowKeyInList(column) ? " IN " : "=");
                    preDeleteSQL.append(column.getMark());
    				if(count < keys.size()){
                    	preDeleteSQL.append(" AND ");
                    }
                    count++;
                }
            }
            boolean ifExist = "true".equals(ElementParameterParser.getValue(node, "__DELETE_IF_EXISTS__"));
            if(ifExist){
            	preDeleteSQL.append(" IF EXISTS");
            }else{
	            if(conditions.size() > 0){
	         	   	preDeleteSQL.append(" IF ");
		            count = 1;
		            for(Column column : conditions){
		            	preDeleteSQL.append(wrapProtectedChar(column.getDBName()));
		            	preDeleteSQL.append("=");
	                	preDeleteSQL.append(column.getMark());
		            	if(count < conditions.size()){
		                	preDeleteSQL.append(" AND ");
		                }
		                count++;	
		            }
		        }
		    }
            preDeleteSQL.append("\"");
            return preDeleteSQL.toString();
        }
        private String validateDBType(Column column){
        	String dbType = column.getDBType();
        	if(dbType == null || "".equals(dbType.trim())){//TODO: throw error or use default value?
        		MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
                dbType = mappingType.getDefaultSelectedDbType(column.getTalendType());
            } 
            return dbType;
        }
        private String generateSetStmt(String assignStmt, Column column, String inConnName, int index){
            String dbType = validateDBType(column);
            String columnValue = inConnName + "." + column.getName();
            StringBuilder setStmt = new StringBuilder();
            if(column.isObject()){
                setStmt.append("if(" + columnValue + " == null){\r\n");
                setStmt.append(assignStmt + ".setToNull(" + index + ");\r\n");
                setStmt.append("} else {");
            }

            if("ascii".equals(dbType) || "text".equals(dbType) || "varchar".equals(dbType)){
            	if(JavaTypesManager.STRING == column.getJavaType()){
                    setStmt.append(assignStmt +".setString(" + index + ", " + columnValue + ");\r\n");
            	}else if(JavaTypesManager.CHARACTER == column.getJavaType()){
            		setStmt.append(assignStmt +".setString(" + index + ", String.valueOf(" + columnValue + "));\r\n");
            	}
            }else if("timeuuid".equals(dbType) || "uuid".equals(dbType)){
                setStmt.append(assignStmt +".setUUID(" + index + ", java.util.UUID.fromString(" + columnValue + "));\r\n");
            }else if("varint".equals(dbType)){
                setStmt.append(assignStmt +".setVarint(" + index + ", (java.math.BigInteger)" + columnValue + ");\r\n");
            }else if("inet".equals(dbType)){
                setStmt.append(assignStmt +".setInet(" + index + ", (java.net.InetAddress)" + columnValue + ");\r\n");
            }else if("map".equals(dbType)){
                setStmt.append(assignStmt +".setMap(" + index + ", (java.util.Map)" + columnValue + ");\r\n");
            }else if("set".equals(dbType)){
                setStmt.append(assignStmt +".setSet(" + index + ", (java.util.Set)" + columnValue + ");\r\n");
            }else if("list".equals(dbType)){
                setStmt.append(assignStmt +".setList(" + index + ", " + columnValue + ");\r\n");
            }else if("boolean".equals(dbType)){
                setStmt.append(assignStmt +".setBool(" + index + ", " + columnValue + ");\r\n");
            }else if("blob".equals(dbType)){
                if (useSpark) {
                    setStmt.append(assignStmt +".setBytes(" + index + ", " + columnValue + ");\r\n");
                } else {
                    setStmt.append(assignStmt +".setBytes(" + index + ", java.nio.ByteBuffer.wrap(" + columnValue + "));\r\n");
                }
            }else if("timestamp".equals(dbType)){
                setStmt.append(assignStmt +".setDate(" + index + ", " + columnValue + ");\r\n");
            }else if("decimal".equals(dbType)){
                setStmt.append(assignStmt +".setDecimal(" + index + ", " + columnValue + ");\r\n");
            }else if("double".equals(dbType)){
                setStmt.append(assignStmt +".setDouble(" + index + ", " + columnValue + ");\r\n");
            }else if("float".equals(dbType)){
                setStmt.append(assignStmt +".setFloat(" + index + ", " + columnValue + ");\r\n");
            }else if("int".equals(dbType)){
            	setStmt.append(assignStmt +".setInt(" + index + ", " + columnValue + ");\r\n");
            }else if("bigint".equals(dbType) || "count".equals(dbType)){
                setStmt.append(assignStmt +".setLong(" + index + ", " + columnValue + ");\r\n");
            }

            if(column.isObject()){
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    
class CassandraOutputGenHelper{
	String cid;
	INode node;
    IMetadataTable metadata = null;
    IConnection conn = null;
    List<IMetadataColumn> columns = null;
    
	CQLManager cqlManager;
	public CassandraOutputGenHelper(INode node){
		init(node);
	}
	
	private void init(INode node){
		this.node = node;
		cid = node.getUniqueName();
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
		this.cqlManager = new CQLManager(node, columns);
	}
	public String getCid(){
		return cid;
	}
	public IMetadataTable getMetadata(){
		return metadata;
	}
	public IConnection getConn(){
		return conn;
	}
	public List<IMetadataColumn> getColumns(){
		return columns;
	}
	public boolean validGen(){
		return columns == null || columns.isEmpty() || conn == null;
	}
	public CQLManager getCQLManager(){
		return cqlManager;
	}
	public void genConn(){
		boolean useExistConn = ElementParameterParser.getBooleanValue(node, "__USE_EXISTING_CONNECTION__");
    	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
    	if(useExistConn){
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_6);
    
	    }else{  
	    
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    
    String host = ElementParameterParser.getValue(node,"__HOST__");
    String port = ElementParameterParser.getValue(node,"__PORT__");
    String userName = ElementParameterParser.getValue(node, "__USERNAME__");
    String passWord = ElementParameterParser.getPasswordValue(node, "__PASSWORD__");
	boolean authentication= ElementParameterParser.getBooleanValue(node, "__REQUIRED_AUTHENTICATION__");
    
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_12);
    
                                                            	if(authentication){
                                                            	
    stringBuffer.append(TEXT_13);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(passWord);
    stringBuffer.append(TEXT_15);
    
                                                            	}
                                                            	
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
	    }
	    
    stringBuffer.append(TEXT_24);
    
	}
	
	public void genKSAction(){
		String keyspaceAction = ElementParameterParser.getValue(node, "__ACTION_ON_KEYSPACE__");
		String dataAction = ElementParameterParser.getValue(node, "__DATA_ACTION__");
		if(!"NONE".equals(keyspaceAction) && !"DELETE".equals(dataAction)){
	    	if("DROP_CREATE".equals(keyspaceAction)){
	    	
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cqlManager.getDropKSSQL(false));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cqlManager.getCreateKSSQL(false));
    stringBuffer.append(TEXT_29);
    
	    	}else if("CREATE".equals(keyspaceAction)){
	    	
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cqlManager.getCreateKSSQL(false));
    stringBuffer.append(TEXT_32);
    
	    	}else if("CREATE_IF_NOT_EXISTS".equals(keyspaceAction)){
	    	
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cqlManager.getCreateKSSQL(true));
    stringBuffer.append(TEXT_35);
    
	    	}else if("DROP_IF_EXISTS_AND_CREATE".equals(keyspaceAction)){
	    	
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cqlManager.getDropKSSQL(true));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cqlManager.getCreateKSSQL(false));
    stringBuffer.append(TEXT_40);
    
	    	}
	    }
	}
	
	public void genCFAction(){
		String tableAction = ElementParameterParser.getValue(node, "__ACTION_ON_COLUMN_FAMILY__");
	    String dataAction = ElementParameterParser.getValue(node, "__DATA_ACTION__");
		if(!"NONE".equals(tableAction) && !"DELETE".equals(dataAction)){
			if("DROP_CREATE".equals(tableAction)){
			
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cqlManager.getDropTableSQL(false));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cqlManager.getCreateTableSQL(false));
    stringBuffer.append(TEXT_45);
    
	            if(cqlManager.containsUnsupportTypes()){
	            
    stringBuffer.append(TEXT_46);
    
	            }
	            
    stringBuffer.append(TEXT_47);
    
			}else if("CREATE".equals(tableAction)){
			
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cqlManager.getCreateTableSQL(false));
    stringBuffer.append(TEXT_50);
    
	            if(cqlManager.containsUnsupportTypes()){
	            
    stringBuffer.append(TEXT_51);
    
	            }
	            
    stringBuffer.append(TEXT_52);
    
	        }else if("DROP_IF_EXISTS_AND_CREATE".equals(tableAction)){
	        
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cqlManager.getDropTableSQL(true));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cqlManager.getCreateTableSQL(false));
    stringBuffer.append(TEXT_57);
    
	            if(cqlManager.containsUnsupportTypes()){
	            
    stringBuffer.append(TEXT_58);
    
	            }
	            
    stringBuffer.append(TEXT_59);
        
	        }else if("CREATE_IF_NOT_EXISTS".equals(tableAction)){
	        
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cqlManager.getCreateTableSQL(true));
    stringBuffer.append(TEXT_62);
    
	            if(cqlManager.containsUnsupportTypes()){
	            
    stringBuffer.append(TEXT_63);
    
	            }
	            
    stringBuffer.append(TEXT_64);
    
	        }else if("CLEAR".equals(tableAction)){
	        
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cqlManager.getDeleteTableSQL());
    stringBuffer.append(TEXT_67);
    
	        }else if("TRUNCATE".equals(tableAction)){
	        
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cqlManager.getTruncateTableSQL());
    stringBuffer.append(TEXT_70);
     
	        }
	    }
	}
	
	public void genBatchUtilClass(){
		boolean useBatch = ElementParameterParser.getBooleanValue(node, "__USE_UNLOGGED_BATCH__");
		if(useBatch){
		
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    	
		}
	}
	
	public void genInit(){
	
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cqlManager.generatePreActionSQL());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
		boolean useBatch = ElementParameterParser.getBooleanValue(node, "__USE_UNLOGGED_BATCH__");
	    if(useBatch){
	    
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
	    	for(String col : cqlManager.getValueColumns()){
	    	
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(col);
    stringBuffer.append(TEXT_85);
    	
	    	}
	    	
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(ElementParameterParser.getValue(node, "__KEY_SPACE__"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(ElementParameterParser.getValue(node, "__COLUMN_FAMILY__"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
	    }else{
	    
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
	    }
	}
}

    
class CassandraConfiguration_Helper{
	public Map<String, String> getProperties(INode node){
		java.util.Map<String, String> properties = new java.util.HashMap<String, String>();
		
        java.util.List<java.util.Map<String, String>> configurations = (java.util.List<java.util.Map<String, String>>)ElementParameterParser.getObjectValue(node, "__CASSANDRA_CONFIGURATION__");
        //remove some key from the configuration table, but can remove it from migration task, so ignore them on code generate stage
        java.util.List<String> ignoreConfList = new java.util.ArrayList<String>();
        ignoreConfList.add("connection_rpc_port");//"spark.cassandra.connection.rpc.port"
		ignoreConfList.add("connection_native_port");//"spark.cassandra.connection.native.port"
        java.util.Map<String, String> confMapping = new java.util.HashMap<String, String>();
        confMapping.put("connection_conf_factory","spark.cassandra.connection.conf.factory");
        confMapping.put("connection_keep_alive_ms","spark.cassandra.connection.keep_alive_ms");
        confMapping.put("connection_timeout_ms","spark.cassandra.connection.timeout_ms");
        confMapping.put("reconnection_delay_ms_min","spark.cassandra.connection.reconnection_delay_ms.min");
        confMapping.put("connection_reconnection_delay_ms_max","spark.cassandra.connection.reconnection_delay_ms.max");
        confMapping.put("connection_local_dc","spark.cassandra.connection.local_dc");
        confMapping.put("auth_conf_factory","spark.cassandra.auth.conf.factory");
        confMapping.put("query_retry_count","spark.cassandra.query.retry.count");
        confMapping.put("read_timeout_ms","spark.cassandra.read.timeout_ms");   
        confMapping.put("input_split_size","spark.cassandra.input.split.size");
        confMapping.put("input_page_row_size","spark.cassandra.input.page.row.size");
        confMapping.put("input_consistency_level","spark.cassandra.input.consistency.level");
        for(java.util.Map<String, String> conf : configurations){
            String confKey = conf.get("KEY");
            if(ignoreConfList.contains(confKey)){
            	continue;
            }
            String propertyKey = confMapping.containsKey(confKey) ? "\"" + confMapping.get(confKey) + "\"" : confKey;
            properties.put(propertyKey, conf.get("VALUE"));
        }
        String host = ElementParameterParser.getValue(node,"__HOST__");
        if(!"".equals(host)){
        	properties.put("\"spark.cassandra.connection.host\"", host);
        }
        String port = ElementParameterParser.getValue(node,"__PORT__");
        if(!"".equals(port)){
        	properties.put("\"spark.cassandra.connection.port\"", port);
        }
        boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
        String userName = ElementParameterParser.getValue(node, "__USERNAME__");
        String passWord = ElementParameterParser.getPasswordValue(node, "__PASSWORD__");
        if(authentication){
            properties.put("\"spark.cassandra.auth.username\"", userName);
            properties.put("\"spark.cassandra.auth.password\"", passWord);
        }  
        
        return properties; 
	}
	
	public Map<String, String> getPropertiesForOutput(INode node){
		java.util.Map<String, String> properties = new java.util.HashMap<String, String>();
		
        java.util.List<java.util.Map<String, String>> configurations = (java.util.List<java.util.Map<String, String>>)ElementParameterParser.getObjectValue(node, "__CASSANDRA_CONFIGURATION__");
        java.util.Map<String, String> confMapping = new java.util.HashMap<String, String>();
        confMapping.put("output_batch_size_rows","spark.cassandra.output.batch.size.rows");
        confMapping.put("output_batch_size_bytes","spark.cassandra.output.batch.size.bytes");
        confMapping.put("output_batch_grouping_key","spark.cassandra.output.batch.grouping.key");
        confMapping.put("output_batch_buffer_size","spark.cassandra.output.batch.buffer.size");
        confMapping.put("output_concurrent_writes","spark.cassandra.output.concurrent.writes");
        confMapping.put("output_consistency_level","spark.cassandra.output.consistency.level");
        confMapping.put("output_throughput_mb_per_sec","spark.cassandra.output.throughput_mb_per_sec");
        for(java.util.Map<String, String> conf : configurations){
            String confKey = conf.get("KEY");
            String propertyKey = confMapping.containsKey(confKey) ? "\"" + confMapping.get(confKey) + "\"" : confKey;
            properties.put(propertyKey, conf.get("VALUE"));
        }
        
        return properties; 
	}
}	

    
class SparkCassandraOutputGenHelper extends CassandraOutputGenHelper{
    
    INode configurationNode = null;
    
	public SparkCassandraOutputGenHelper(INode node){
		super(node);
		List<? extends INode> configurationNodes = node.getProcess().getNodesOfType("tCassandraConfiguration");
		if (configurationNodes != null && configurationNodes.size() > 0) {
		    configurationNode = configurationNodes.get(0);
		}
	}
	
	@Override
	public boolean validGen(){
		return super.validGen() || configurationNode == null;
	}
	
	@Override
	public void genConn(){
		String connName = conn.getName();
		String keyspaceAction = ElementParameterParser.getValue(node, "__ACTION_ON_KEYSPACE__");
		String tableAction = ElementParameterParser.getValue(node, "__TABLE_ACTION__");
		String dataAction = ElementParameterParser.getValue(node, "__DATA_ACTION__");
		if((!"NONE".equals(tableAction) || !"NONE".equals(keyspaceAction)) && !"DELETE".equals(dataAction)){
			
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
			Map<String, String> cassandraProperties = (new CassandraConfiguration_Helper()).getProperties(configurationNode);
			for(String cPropKey : cassandraProperties.keySet()){
			
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cPropKey);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cassandraProperties.get(cPropKey));
    stringBuffer.append(TEXT_106);
    	
			}
			
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
		}
	}
	
	public INode getConfigurationNode(){
		return configurationNode;
	}
}

    
class SparkStrCassandraOutputGenHelper extends SparkCassandraOutputGenHelper{
	
	public SparkStrCassandraOutputGenHelper(INode node){
		super(node);
	}

}

    
SparkStrCassandraOutputGenHelper outputGenHelper =  new SparkStrCassandraOutputGenHelper(node);

if(outputGenHelper.validGen()){
	return "";
}
outputGenHelper.genConn();
outputGenHelper.genKSAction();
outputGenHelper.genCFAction();

    stringBuffer.append(TEXT_112);
    
String connName = outputGenHelper.getConn().getName();
String dataAction = ElementParameterParser.getValue(node, "__DATA_ACTION__");
String inRowStruct = codeGenArgument.getRecordStructName(outputGenHelper.getConn());
if("UPSERT".equals(dataAction)){
	Map<String, String> cassandraProperties = (new CassandraConfiguration_Helper()).getPropertiesForOutput(node);
	for(String cPropKey : cassandraProperties.keySet()){
	
    stringBuffer.append(TEXT_113);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cPropKey);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cassandraProperties.get(cPropKey));
    stringBuffer.append(TEXT_116);
    	
	}
	String keyspace = ElementParameterParser.getValue(node,"__KEY_SPACE__");
	String table = ElementParameterParser.getValue(node,"__COLUMN_FAMILY__");	
	//even there is a columnMapping, the column name must be lower case, the db column name can contains upper case
	
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
    StringBuilder formatColumns = new StringBuilder();
    boolean addComma = false;
    for(IMetadataColumn column : outputGenHelper.getColumns()){
    	if(addComma){
    		formatColumns.append(",");
    	}
    	formatColumns.append("\"" + column.getOriginalDbColumnName() + "\"");
    	
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_122);
    
    	addComma = true;
    }
	
    stringBuffer.append(TEXT_123);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(keyspace);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(formatColumns.toString());
    stringBuffer.append(TEXT_129);
    
}else{

    stringBuffer.append(TEXT_130);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    	
}

    return stringBuffer.toString();
  }
}
