package org.talend.designer.codegen.translators.databases.mysql;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TMysqlOutputMrcodeJava
{
  protected static String nl;
  public static synchronized TMysqlOutputMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlOutputMrcodeJava result = new TMysqlOutputMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t    public static class ";
  protected final String TEXT_3 = "StructOutputFormat implements OutputFormat<NullWritable, ";
  protected final String TEXT_4 = "Struct> {" + NL + "\t\t    \t" + NL + "\t\t    \tprivate ContextProperties context;" + NL + "\t\t    \t" + NL + "\t\t    \tprivate java.sql.Connection connection;" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic RecordWriter<NullWritable, ";
  protected final String TEXT_5 = "Struct> getRecordWriter(FileSystem filesystem, JobConf job, String name, Progressable progress)" + NL + "\t\t\t            throws IOException {" + NL + "\t\t\t\t\tcontext = new ContextProperties(job);" + NL + "\t\t\t        try {" + NL + "\t\t\t            Class.forName(";
  protected final String TEXT_6 = ");" + NL + "\t\t\t            ";
  protected final String TEXT_7 = NL + "                        ";
  protected final String TEXT_8 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = "; ";
  protected final String TEXT_14 = NL + "   \t\t\t            " + NL + "                        " + NL + "\t\t\t\t        this.connection = java.sql.DriverManager.getConnection(";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ", decryptedPassword_";
  protected final String TEXT_17 = ");" + NL + "\t\t\t\t        String dbName = connection.getMetaData().getDatabaseProductName().toUpperCase();" + NL + "\t\t\t\t        this.connection.setAutoCommit(false);" + NL + "\t\t\t\t        " + NL + "\t\t\t            java.sql.PreparedStatement statement = null;" + NL + "\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\tString[] fieldNames = {";
  protected final String TEXT_19 = "};" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t            statement = connection.prepareStatement((new org.talend.hadoop.mapred.lib.db.JDBCHelper(connection)).constructQuery(";
  protected final String TEXT_20 = ", fieldNames));" + NL + "\t\t\t            return new DBRecordWriter(connection, statement);" + NL + "\t\t\t        } catch (Exception ex) {" + NL + "\t\t\t            throw new IOException(ex.getMessage());" + NL + "\t\t\t        }" + NL + "\t\t\t    }" + NL + "\t\t\t    " + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic void checkOutputSpecs(FileSystem filesystem, JobConf job) throws IOException {" + NL + "    \t\t\t}\t\t" + NL + "    \t\t\t" + NL + "    \t\t\tprotected static class DBRecordWriter implements RecordWriter<NullWritable, ";
  protected final String TEXT_21 = "Struct> {" + NL + "\t\t    \t\t" + NL + "\t\t    \t\tprivate java.sql.Connection connection;" + NL + "" + NL + "\t\t\t        private java.sql.PreparedStatement statement;" + NL + "\t\t\t        private int batchSize = ";
  protected final String TEXT_22 = ";" + NL + "\t\t\t        " + NL + "\t\t\t        private int batchSizeCounter = 0;" + NL + "\t\t\t" + NL + "\t\t\t        protected DBRecordWriter(java.sql.Connection connection, java.sql.PreparedStatement statement) throws SQLException {" + NL + "\t\t\t            this.connection = connection;" + NL + "\t\t\t            this.statement = statement;" + NL + "\t\t\t        }" + NL + "\t\t\t" + NL + "\t\t\t        public void close(Reporter reporter) throws IOException {" + NL + "\t\t\t            try {" + NL + "\t\t\t            \t";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\t\t\tif(batchSize>0 && statement!=null && batchSizeCounter>0){" + NL + "\t\t\t\t\t\t\t\t\tstatement.executeBatch();" + NL + "\t\t\t\t\t\t\t\t\tstatement.clearBatch();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t                if(connection!=null && !connection.isClosed()){" + NL + "\t\t\t                \tconnection.commit();" + NL + "\t\t\t                }" + NL + "\t\t\t\t\t\t} catch (SQLException e) {" + NL + "\t\t\t                try {" + NL + "\t\t\t                \tif(connection!=null && !connection.isClosed()){" + NL + "\t\t\t                    \tconnection.rollback();" + NL + "\t\t\t                    }" + NL + "\t\t\t                } catch (SQLException ex) {" + NL + "\t\t\t                    throw new IOException(ex.getMessage());" + NL + "\t\t\t                }" + NL + "\t\t\t                throw new IOException(e.getMessage());" + NL + "\t\t\t            } finally {" + NL + "\t\t\t                closeDB();" + NL + "\t\t\t            }" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic void closeDB() throws IOException{" + NL + "\t\t\t\t\t\ttry {" + NL + "\t                \t\tif(statement!=null){" + NL + "\t\t                    \tstatement.close();" + NL + "\t\t                    \tstatement = null;" + NL + "\t\t                    }" + NL + "\t\t                } catch (SQLException ex) {" + NL + "\t\t                    throw new IOException(ex.getMessage());" + NL + "\t    \t            }finally{" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t\t\t                    if(connection!=null && !connection.isClosed()){" + NL + "\t\t                    \t\tconnection.close();" + NL + "\t\t\t                    }" + NL + "\t\t    \t            } catch (SQLException ex) {" + NL + "\t\t        \t            throw new IOException(ex.getMessage());" + NL + "\t\t            \t    }" + NL + "\t    \t            }" + NL + "\t\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t        public void write(NullWritable key, ";
  protected final String TEXT_25 = "Struct value) throws IOException {" + NL + "\t\t\t            try {" + NL + "\t\t\t                ";
  protected final String TEXT_26 = NL + "\t\t\t\t                    \tif(String.valueOf(value.";
  protected final String TEXT_27 = ").toLowerCase().equals(\"null\")){" + NL + "\t\t\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_28 = ", java.sql.Types.CHAR);\t" + NL + "\t\t\t\t                    \t}else if(value.";
  protected final String TEXT_29 = " == '\\0'){" + NL + "\t\t\t\t                    \t\tstatement.setString(";
  protected final String TEXT_30 = ", \"\");" + NL + "\t\t\t\t                    \t}else{" + NL + "\t\t\t\t                    \t\tstatement.setString(";
  protected final String TEXT_31 = ", String.valueOf(value.";
  protected final String TEXT_32 = "));" + NL + "\t\t\t\t                    \t}" + NL + "\t\t\t\t                    ";
  protected final String TEXT_33 = NL + "\t\t\t\t                        statement.set";
  protected final String TEXT_34 = "(";
  protected final String TEXT_35 = ", value.";
  protected final String TEXT_36 = ");" + NL + "\t\t\t                    \t";
  protected final String TEXT_37 = NL + "\t\t\t                    \tif(value.";
  protected final String TEXT_38 = " != null){" + NL + "\t\t\t                        \tstatement.setBoolean(";
  protected final String TEXT_39 = ", value.";
  protected final String TEXT_40 = ");" + NL + "\t\t\t                       \t}else{" + NL + "\t\t\t                       \t\tstatement.setNull(";
  protected final String TEXT_41 = ", java.sql.Types.BOOLEAN);" + NL + "\t\t\t                       \t}" + NL + "\t\t\t                    ";
  protected final String TEXT_42 = NL + "\t\t\t                    \tif(value.";
  protected final String TEXT_43 = " != null){" + NL + "\t\t\t                    \t\tstatement.setByte(";
  protected final String TEXT_44 = ", value.";
  protected final String TEXT_45 = ");" + NL + "\t\t\t                    \t}else{" + NL + "\t\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_46 = ", java.sql.Types.INTEGER);\t" + NL + "\t\t\t                    \t}" + NL + "\t\t\t                    ";
  protected final String TEXT_47 = NL + "\t\t\t                    \tif(value.";
  protected final String TEXT_48 = " != null){" + NL + "\t\t\t                    \t\tstatement.setBytes(";
  protected final String TEXT_49 = ", value.";
  protected final String TEXT_50 = ");" + NL + "\t\t\t                    \t}else{" + NL + "\t\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_51 = ", java.sql.Types.ARRAY);\t" + NL + "\t\t\t                    \t}" + NL + "\t\t\t                    ";
  protected final String TEXT_52 = NL + "\t\t\t                    \tif(value.";
  protected final String TEXT_53 = " != null){" + NL + "\t\t\t                    \t\tstatement.setString(";
  protected final String TEXT_54 = ", String.valueOf(value.";
  protected final String TEXT_55 = "));" + NL + "\t\t\t                    \t}else{" + NL + "\t\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_56 = ", java.sql.Types.CHAR);\t" + NL + "\t\t\t                    \t}" + NL + "\t\t\t                    ";
  protected final String TEXT_57 = NL + "\t\t\t                    \tif(value.";
  protected final String TEXT_58 = " != null){" + NL + "\t\t\t                    \t\tstatement.setTimestamp(";
  protected final String TEXT_59 = ", new java.sql.Timestamp(value.";
  protected final String TEXT_60 = ".getTime()));" + NL + "\t\t\t                    \t}else{" + NL + "\t\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_61 = ", java.sql.Types.DATE);\t" + NL + "\t\t\t                    \t}" + NL + "\t\t\t                    ";
  protected final String TEXT_62 = NL + "\t\t\t                        if(value.";
  protected final String TEXT_63 = " != null){" + NL + "\t\t\t                    \t\tstatement.setDouble(";
  protected final String TEXT_64 = ", value.";
  protected final String TEXT_65 = ");" + NL + "\t\t\t                    \t}else{" + NL + "\t\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_66 = ", java.sql.Types.DOUBLE);\t" + NL + "\t\t\t                    \t}" + NL + "\t\t\t                    ";
  protected final String TEXT_67 = NL + "\t\t\t                        if(value.";
  protected final String TEXT_68 = " != null){" + NL + "\t\t\t                    \t\tstatement.setFloat(";
  protected final String TEXT_69 = ", value.";
  protected final String TEXT_70 = ");" + NL + "\t\t\t                    \t}else{" + NL + "\t\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_71 = ", java.sql.Types.FLOAT);\t" + NL + "\t\t\t                    \t}" + NL + "\t\t\t                    ";
  protected final String TEXT_72 = NL + "\t\t\t\t\t                statement.setBigDecimal(";
  protected final String TEXT_73 = ", value.";
  protected final String TEXT_74 = ");" + NL + "\t\t\t\t                ";
  protected final String TEXT_75 = NL + "\t\t\t                        if(value.";
  protected final String TEXT_76 = " != null){" + NL + "\t\t\t                    \t\tstatement.setInt(";
  protected final String TEXT_77 = ", value.";
  protected final String TEXT_78 = ");" + NL + "\t\t\t                    \t}else{" + NL + "\t\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_79 = ", java.sql.Types.INTEGER);\t" + NL + "\t\t\t                    \t}" + NL + "\t\t\t                    ";
  protected final String TEXT_80 = NL + "\t\t\t                        if(value.";
  protected final String TEXT_81 = " != null){" + NL + "\t\t\t                    \t\tstatement.setLong(";
  protected final String TEXT_82 = ", value.";
  protected final String TEXT_83 = ");" + NL + "\t\t\t                    \t}else{" + NL + "\t\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_84 = ", java.sql.Types.INTEGER);\t" + NL + "\t\t\t                    \t}" + NL + "\t\t\t                    ";
  protected final String TEXT_85 = NL + "\t\t\t                        if(value.";
  protected final String TEXT_86 = " != null){" + NL + "\t\t\t                    \t\tstatement.setObject(";
  protected final String TEXT_87 = ", value.";
  protected final String TEXT_88 = ");" + NL + "\t\t\t                    \t}else{" + NL + "\t\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_89 = ", java.sql.Types.OTHER);\t" + NL + "\t\t\t                    \t}" + NL + "\t\t\t                    ";
  protected final String TEXT_90 = NL + "\t\t\t                        if(value.";
  protected final String TEXT_91 = " != null){" + NL + "\t\t\t                    \t\tstatement.setShort(";
  protected final String TEXT_92 = ", value.";
  protected final String TEXT_93 = ");" + NL + "\t\t\t                    \t}else{" + NL + "\t\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_94 = ", java.sql.Types.INTEGER);\t" + NL + "\t\t\t                    \t}" + NL + "\t\t\t                    ";
  protected final String TEXT_95 = NL + "\t\t\t                        if(value.";
  protected final String TEXT_96 = " != null){" + NL + "\t\t\t                    \t\tstatement.setString(";
  protected final String TEXT_97 = ", value.";
  protected final String TEXT_98 = ");" + NL + "\t\t\t                    \t}else{" + NL + "\t\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_99 = ", java.sql.Types.VARCHAR);\t" + NL + "\t\t\t                    \t}" + NL + "\t\t\t                    ";
  protected final String TEXT_100 = NL + "\t\t\t                        statement.setObject(";
  protected final String TEXT_101 = ", value.";
  protected final String TEXT_102 = ");" + NL + "\t\t\t                    ";
  protected final String TEXT_103 = NL + "\t\t\t\t\t\t\t\tstatement.addBatch();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_104 = NL + "\t\t\t\t\t                batchSizeCounter++;" + NL + "\t\t\t\t\t                if(batchSizeCounter>=batchSize){" + NL + "\t\t\t\t\t                \tbatchSizeCounter=0;" + NL + "\t\t\t\t\t                \tstatement.executeBatch();" + NL + "\t\t\t\t\t                \tstatement.clearBatch();" + NL + "\t\t\t\t\t                }" + NL + "\t\t\t                ";
  protected final String TEXT_105 = NL + "\t\t\t\t            \tstatement.executeUpdate();" + NL + "\t\t\t\t            ";
  protected final String TEXT_106 = NL + "\t\t\t            } catch (SQLException e) {" + NL + "\t\t\t                try {" + NL + "\t\t\t                \tif(connection!=null){" + NL + "\t\t\t                    \tconnection.rollback();" + NL + "\t\t\t                    }" + NL + "\t\t\t                } catch (SQLException ex) {" + NL + "\t\t\t                    throw new IOException(ex.getMessage());" + NL + "\t\t\t                }finally {" + NL + "\t\t\t\t            \tcloseDB();" + NL + "\t\t\t\t                throw new IOException(e.getMessage());" + NL + "\t\t\t\t            }" + NL + "\t\t\t            }" + NL + "\t\t\t        }" + NL + "\t\t\t\t}    " + NL + "\t\t    }" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();  
    String cid = node.getUniqueName();
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if((metadatas != null) && (metadatas.size() > 0)){
        IMetadataTable metadata = metadatas.get(0);
        if(metadata != null){
        
				String dbhost = ElementParameterParser.getValue(node, "__HOST__");
				String dbport = ElementParameterParser.getValue(node, "__PORT__");
				String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
				String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
		
				String jdbcURL = "\"jdbc:mysql\"";
				String driverClass = "\"org.gjt.mm.mysql.Driver\"";
				
				if("MARIADB".equals(dbVersion)){
					jdbcURL = "\"jdbc:mariadb\"";
					driverClass = "\"org.mariadb.jdbc.Driver\"";
				}
				
				String url = jdbcURL + " + \"://\" + " + dbhost + " + \":\" + " + dbport + " + \"/\" + " + dbname;
		
	    	String dbuser = ElementParameterParser.getValue(node, "__USER__");
	 		String dbtable = ElementParameterParser.getValue(node, "__TABLE__");	
	 				
	        String connName = "";
	        
		    List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
		    if(inConns != null && inConns.size() > 0){
		    	IConnection inConn = inConns.get(0); 
		        connName = inConn.getName();
		    }else{
		        return "";
		    }
		    
			List<IMetadataColumn> columns = metadata.getListColumns();
			boolean useBatchSize = "true".equals(ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__"));
			String batchSize = ElementParameterParser.getValue(node, "__BATCH_SIZE__");
		    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_6);
    
                        String passwordFieldName = "__PASS__";
                        
    stringBuffer.append(TEXT_7);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_10);
    } else {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
						StringBuilder dbColumnsName = new StringBuilder();
						for(IMetadataColumn column : columns){
							dbColumnsName.append("\"").append(column.getOriginalDbColumnName()).append("\"").append(",");
						}
						
    stringBuffer.append(TEXT_18);
    stringBuffer.append(dbColumnsName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(batchSize==null||"".equals(batchSize)?10000:batchSize);
    stringBuffer.append(TEXT_22);
    
			            	if (useBatchSize) {
								
    stringBuffer.append(TEXT_23);
    
			                }
			                
    stringBuffer.append(TEXT_24);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_25);
    
			                int i = 1;
				            for (IMetadataColumn column: columns) {
				                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				                
				                if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
				                    typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
				                    if (typeToGenerate.equals("Char")) {
				                    
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_32);
    
				                    } else {
				                    
    stringBuffer.append(TEXT_33);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_36);
    	
			                    	}
				                } else if (typeToGenerate.equals("Boolean")) {
			                    
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_41);
    
				                } else if (typeToGenerate.equals("Byte")) {
			                    
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_46);
    
				                } else if (typeToGenerate.equals("byte[]")) {
			                    
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_51);
    
				                } else if (typeToGenerate.equals("Character")) {
			                    
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_56);
    
				                } else if (typeToGenerate.equals("java.util.Date")) {
			                    
    stringBuffer.append(TEXT_57);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_61);
    
				                } else if (typeToGenerate.equals("Double")) {
			                    
    stringBuffer.append(TEXT_62);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_66);
    
				                } else if (typeToGenerate.equals("Float")) {
			                    
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_71);
    
				                } else if(typeToGenerate.equals("BigDecimal")) {
				                
    stringBuffer.append(TEXT_72);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_74);
    
				                } else if (typeToGenerate.equals("Integer")) {
			                    
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_79);
    
				                } else if (typeToGenerate.equals("Long")) {
			                    
    stringBuffer.append(TEXT_80);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_84);
    
				                } else if (typeToGenerate.equals("Object")) {
			                    
    stringBuffer.append(TEXT_85);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_89);
    
				                } else if (typeToGenerate.equals("Short")) {
			                    
    stringBuffer.append(TEXT_90);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_94);
    
				                } else if (typeToGenerate.equals("String")) {
			                    
    stringBuffer.append(TEXT_95);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_99);
    
				                } else if (typeToGenerate.equals("List")) {
			                    
    stringBuffer.append(TEXT_100);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_102);
    
				                } 
				                i++;
				            }
							if (useBatchSize) {
			                
    stringBuffer.append(TEXT_103);
    
    							if(!("").equals(batchSize) && !("0").equals(batchSize)) {
			                
    stringBuffer.append(TEXT_104);
    
			                	}
				            }else{
				            
    stringBuffer.append(TEXT_105);
    
			                }
			                
    stringBuffer.append(TEXT_106);
    
    	}
	}   
	
    return stringBuffer.toString();
  }
}
