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
import org.talend.designer.spark.generator.storage.MysqlSparkStorage;

public class TMysqlOutputSparkcodeJava
{
  protected static String nl;
  public static synchronized TMysqlOutputSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlOutputSparkcodeJava result = new TMysqlOutputSparkcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "            public static class ";
  protected final String TEXT_3 = "_OutputFunction" + NL + "                implements org.apache.spark.api.java.function.VoidFunction<java.util.Iterator<";
  protected final String TEXT_4 = ">> {" + NL;
  protected final String TEXT_5 = NL + "                    int batchSize = ";
  protected final String TEXT_6 = ";" + NL + "                    int batchSizeCounter = 0;";
  protected final String TEXT_7 = NL + "                ContextProperties context;" + NL + "" + NL + "                public ";
  protected final String TEXT_8 = "_OutputFunction(JobConf conf) throws ClassNotFoundException, java.sql.SQLException {" + NL + "                    Class.forName(\"org.gjt.mm.mysql.Driver\");" + NL + "                    context = new ContextProperties(conf);" + NL + "                }" + NL + "" + NL + "                public void call(java.util.Iterator<";
  protected final String TEXT_9 = "> dataIterator) throws java.lang.Exception {" + NL + "                    java.sql.Connection connection = java.sql.DriverManager.getConnection(";
  protected final String TEXT_10 = ");" + NL + "                    java.sql.PreparedStatement statement = connection.prepareStatement(\"INSERT INTO \" + ";
  protected final String TEXT_11 = " + \" (";
  protected final String TEXT_12 = ") VALUES(";
  protected final String TEXT_13 = ")\");" + NL + "                    while (dataIterator.hasNext()) {";
  protected final String TEXT_14 = NL + "                        ";
  protected final String TEXT_15 = " value = dataIterator.next();";
  protected final String TEXT_16 = NL + "\t\t\t                    \tif(String.valueOf(value.";
  protected final String TEXT_17 = ").toLowerCase().equals(\"null\")){" + NL + "\t\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_18 = ", java.sql.Types.CHAR);\t" + NL + "\t\t\t                    \t}else if(value.";
  protected final String TEXT_19 = " == '\\0'){" + NL + "\t\t\t                    \t\tstatement.setString(";
  protected final String TEXT_20 = ", \"\");" + NL + "\t\t\t                    \t}else{" + NL + "\t\t\t                    \t\tstatement.setString(";
  protected final String TEXT_21 = ", String.valueOf(value.";
  protected final String TEXT_22 = "));" + NL + "\t\t\t                    \t}" + NL + "\t\t\t                    ";
  protected final String TEXT_23 = NL + "\t\t\t                        statement.set";
  protected final String TEXT_24 = "(";
  protected final String TEXT_25 = ", value.";
  protected final String TEXT_26 = ");" + NL + "\t\t                    \t";
  protected final String TEXT_27 = NL + "\t\t                    \tif(value.";
  protected final String TEXT_28 = " != null){" + NL + "\t\t                        \tstatement.setBoolean(";
  protected final String TEXT_29 = ", value.";
  protected final String TEXT_30 = ");" + NL + "\t\t                       \t}else{" + NL + "\t\t                       \t\tstatement.setNull(";
  protected final String TEXT_31 = ", java.sql.Types.BOOLEAN);" + NL + "\t\t                       \t}" + NL + "\t\t                    ";
  protected final String TEXT_32 = NL + "\t\t                    \tif(value.";
  protected final String TEXT_33 = " != null){" + NL + "\t\t                    \t\tstatement.setByte(";
  protected final String TEXT_34 = ", value.";
  protected final String TEXT_35 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_36 = ", java.sql.Types.INTEGER);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_37 = NL + "\t\t                    \tif(value.";
  protected final String TEXT_38 = " != null){" + NL + "\t\t                    \t\tstatement.setBytes(";
  protected final String TEXT_39 = ", value.";
  protected final String TEXT_40 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_41 = ", java.sql.Types.ARRAY);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_42 = NL + "\t\t                    \tif(value.";
  protected final String TEXT_43 = " != null){" + NL + "\t\t                    \t\tstatement.setString(";
  protected final String TEXT_44 = ", String.valueOf(value.";
  protected final String TEXT_45 = "));" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_46 = ", java.sql.Types.CHAR);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_47 = NL + "\t\t                    \tif(value.";
  protected final String TEXT_48 = " != null){" + NL + "\t\t                    \t\tstatement.setTimestamp(";
  protected final String TEXT_49 = ", new java.sql.Timestamp(value.";
  protected final String TEXT_50 = ".getTime()));" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_51 = ", java.sql.Types.DATE);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_52 = NL + "\t\t                        if(value.";
  protected final String TEXT_53 = " != null){" + NL + "\t\t                    \t\tstatement.setDouble(";
  protected final String TEXT_54 = ", value.";
  protected final String TEXT_55 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_56 = ", java.sql.Types.DOUBLE);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_57 = NL + "\t\t                        if(value.";
  protected final String TEXT_58 = " != null){" + NL + "\t\t                    \t\tstatement.setFloat(";
  protected final String TEXT_59 = ", value.";
  protected final String TEXT_60 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_61 = ", java.sql.Types.FLOAT);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_62 = NL + "\t\t\t\t                statement.setBigDecimal(";
  protected final String TEXT_63 = ", value.";
  protected final String TEXT_64 = ");" + NL + "\t\t\t                ";
  protected final String TEXT_65 = NL + "\t\t                        if(value.";
  protected final String TEXT_66 = " != null){" + NL + "\t\t                    \t\tstatement.setInt(";
  protected final String TEXT_67 = ", value.";
  protected final String TEXT_68 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_69 = ", java.sql.Types.INTEGER);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_70 = NL + "\t\t                        if(value.";
  protected final String TEXT_71 = " != null){" + NL + "\t\t                    \t\tstatement.setLong(";
  protected final String TEXT_72 = ", value.";
  protected final String TEXT_73 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_74 = ", java.sql.Types.INTEGER);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_75 = NL + "\t\t                        if(value.";
  protected final String TEXT_76 = " != null){" + NL + "\t\t                    \t\tstatement.setObject(";
  protected final String TEXT_77 = ", value.";
  protected final String TEXT_78 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_79 = ", java.sql.Types.OTHER);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_80 = NL + "\t\t                        if(value.";
  protected final String TEXT_81 = " != null){" + NL + "\t\t                    \t\tstatement.setShort(";
  protected final String TEXT_82 = ", value.";
  protected final String TEXT_83 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_84 = ", java.sql.Types.INTEGER);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_85 = NL + "\t\t                        if(value.";
  protected final String TEXT_86 = " != null){" + NL + "\t\t                    \t\tstatement.setString(";
  protected final String TEXT_87 = ", value.";
  protected final String TEXT_88 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_89 = ", java.sql.Types.VARCHAR);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_90 = NL + "\t\t                        statement.setObject(";
  protected final String TEXT_91 = ", value.";
  protected final String TEXT_92 = ");" + NL + "\t\t                    ";
  protected final String TEXT_93 = NL + "                            statement.addBatch();" + NL + "                            batchSizeCounter++;" + NL + "                            if (batchSizeCounter >= batchSize) {" + NL + "                            \ttry{" + NL + "                            \t\tstatement.executeBatch();" + NL + "                            \t}catch(Exception e){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_94 = "                            " + NL + "\t\t\t\t\t\t\t\t\t\tthrow(e);" + NL + "\t                                ";
  protected final String TEXT_95 = NL + "\t                                \tSystem.err.print(e.getMessage());" + NL + "\t                                ";
  protected final String TEXT_96 = NL + "                            \t}" + NL + "                                statement.clearBatch();" + NL + "                                batchSizeCounter = 0;" + NL + "                            }";
  protected final String TEXT_97 = NL + "                        \ttry{" + NL + "                            \tstatement.executeUpdate();" + NL + "                            }catch(Exception e){" + NL + "                            \t";
  protected final String TEXT_98 = "                            " + NL + "\t\t\t\t\t\t\t\t\tthrow(e);";
  protected final String TEXT_99 = NL + "                                \tSystem.err.print(e.getMessage());";
  protected final String TEXT_100 = NL + "                            }";
  protected final String TEXT_101 = NL + "                    }";
  protected final String TEXT_102 = NL + "                        if (batchSizeCounter != 0) {" + NL + "                            try{" + NL + "\t                            statement.executeBatch();" + NL + "                            }catch(Exception e){" + NL + "                            \t";
  protected final String TEXT_103 = "                            " + NL + "\t\t\t\t\t\t\t\t\tthrow(e);";
  protected final String TEXT_104 = NL + "                                \tSystem.err.print(e.getMessage());";
  protected final String TEXT_105 = NL + "                            }" + NL + "                            statement.clearBatch();" + NL + "                        }";
  protected final String TEXT_106 = NL + "                    statement.close();" + NL + "                    connection.close();" + NL + "                }" + NL + "" + NL + "            }";

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

            MysqlSparkStorage storage = new MysqlSparkStorage(node);

            String table = ElementParameterParser.getValue(node, "__TABLE__");
            boolean useBatchSize = ("true").equals(ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__"));
            String batchSize = ElementParameterParser.getValue(node, "__BATCH_SIZE__");
            boolean dieOnError = ElementParameterParser.getBooleanValue(node, "__DIE_ON_ERROR__");
            
            String connName = "";
            String connStructName = "";
            String statement = "";
            String columnsDescription = "";
            IConnection inConn = null;
            List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
            if(inConns != null && inConns.size() > 0){
                inConn = inConns.get(0); 
                connName = inConn.getName();
                connStructName = codeGenArgument.getRecordStructName(inConn);
                for (IMetadataColumn column: inConn.getMetadataTable().getListColumns()) {
                    statement += ",?";
                    columnsDescription += "," + column.getOriginalDbColumnName();
                }
                if (!statement.equals("")) {
                    statement = statement.substring(1);
                    columnsDescription = columnsDescription.substring(1);
                }
            }else{
                return "";
            }
            class TypeGenerator {
                String generateType(String typeToGenerate) {
                    if(("byte[]").equals(typeToGenerate)){
                        typeToGenerate = "Bytes";
                    }else if(("java.util.Date").equals(typeToGenerate)){
                        typeToGenerate = "Date";
                    }else if(("Integer").equals(typeToGenerate)){
                        typeToGenerate = "Int";
                    }else if(("List").equals(typeToGenerate)){
                        typeToGenerate = "Object";
                    }else{
                        typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
                    }
                    return typeToGenerate;
                }
            }
            TypeGenerator typeGenerator = new TypeGenerator();
            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connStructName);
    stringBuffer.append(TEXT_4);
    
                if (useBatchSize) {
                    
    stringBuffer.append(TEXT_5);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_6);
    
                }
                
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connStructName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(storage.getURI());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(columnsDescription);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connStructName);
    stringBuffer.append(TEXT_15);
    
		                int i = 1;
			            for (IMetadataColumn column: inConn.getMetadataTable().getListColumns()) {
			                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			                
			                if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
			                    typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
			                    if (typeToGenerate.equals("Char")) {
			                    
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_22);
    
			                    } else {
			                    
    stringBuffer.append(TEXT_23);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_26);
    	
		                    	}
			                } else if (typeToGenerate.equals("Boolean")) {
		                    
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_31);
    
			                } else if (typeToGenerate.equals("Byte")) {
		                    
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_36);
    
			                } else if (typeToGenerate.equals("byte[]")) {
		                    
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_41);
    
			                } else if (typeToGenerate.equals("Character")) {
		                    
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_46);
    
			                } else if (typeToGenerate.equals("java.util.Date")) {
		                    
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_51);
    
			                } else if (typeToGenerate.equals("Double")) {
		                    
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_56);
    
			                } else if (typeToGenerate.equals("Float")) {
		                    
    stringBuffer.append(TEXT_57);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_61);
    
			                } else if(typeToGenerate.equals("BigDecimal")) {
			                
    stringBuffer.append(TEXT_62);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_64);
    
			                } else if (typeToGenerate.equals("Integer")) {
		                    
    stringBuffer.append(TEXT_65);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_69);
    
			                } else if (typeToGenerate.equals("Long")) {
		                    
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_74);
    
			                } else if (typeToGenerate.equals("Object")) {
		                    
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_79);
    
			                } else if (typeToGenerate.equals("Short")) {
		                    
    stringBuffer.append(TEXT_80);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_84);
    
			                } else if (typeToGenerate.equals("String")) {
		                    
    stringBuffer.append(TEXT_85);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_89);
    
			                } else if (typeToGenerate.equals("List")) {
		                    
    stringBuffer.append(TEXT_90);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_92);
    
			                } 
			                i++;
			            }
                        if (useBatchSize) {
                        
    stringBuffer.append(TEXT_93);
    
									if(dieOnError){
									
    stringBuffer.append(TEXT_94);
    
	                                }else{
	                                
    stringBuffer.append(TEXT_95);
    
	                                }
	                                
    stringBuffer.append(TEXT_96);
    
                        } else {
                        
    stringBuffer.append(TEXT_97);
    
								if(dieOnError){
								
    stringBuffer.append(TEXT_98);
    
                                }else{
                                
    stringBuffer.append(TEXT_99);
    
                                }
                                
    stringBuffer.append(TEXT_100);
    
                        }
                        
    stringBuffer.append(TEXT_101);
    
                    if (useBatchSize) {
                        
    stringBuffer.append(TEXT_102);
    
								if(dieOnError){
								
    stringBuffer.append(TEXT_103);
    
                                }else{
                                
    stringBuffer.append(TEXT_104);
    
                                }
                                
    stringBuffer.append(TEXT_105);
    
                    }
                    
    stringBuffer.append(TEXT_106);
    
        }
    }

    return stringBuffer.toString();
  }
}
