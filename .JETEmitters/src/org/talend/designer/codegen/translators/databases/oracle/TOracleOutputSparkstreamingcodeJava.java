package org.talend.designer.codegen.translators.databases.oracle;

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
import org.talend.designer.spark.generator.storage.OracleSparkStorage;

public class TOracleOutputSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TOracleOutputSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleOutputSparkstreamingcodeJava result = new TOracleOutputSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "            public static class ";
  protected final String TEXT_4 = "_OutputFunction" + NL + "                implements org.apache.spark.api.java.function.VoidFunction<java.util.Iterator<";
  protected final String TEXT_5 = ">> {" + NL;
  protected final String TEXT_6 = NL + "                    int batchSize = ";
  protected final String TEXT_7 = ";" + NL + "                    int batchSizeCounter = 0;";
  protected final String TEXT_8 = NL + "                ContextProperties context;" + NL + "" + NL + "                public ";
  protected final String TEXT_9 = "_OutputFunction(JobConf conf) throws ClassNotFoundException, java.sql.SQLException {" + NL + "                    Class.forName(";
  protected final String TEXT_10 = ");" + NL + "                    context = new ContextProperties(conf);" + NL + "                }" + NL + "" + NL + "                public void call(java.util.Iterator<";
  protected final String TEXT_11 = "> dataIterator) throws java.lang.Exception {" + NL + "                    java.sql.Connection connection = java.sql.DriverManager.getConnection(";
  protected final String TEXT_12 = ");" + NL + "" + NL + "" + NL + "                    java.sql.PreparedStatement statement = connection.prepareStatement(\"INSERT INTO \" + ";
  protected final String TEXT_13 = " + \" (";
  protected final String TEXT_14 = ") VALUES(";
  protected final String TEXT_15 = ")\");" + NL + "                    while (dataIterator.hasNext()) {";
  protected final String TEXT_16 = NL + "                        ";
  protected final String TEXT_17 = " value = dataIterator.next();";
  protected final String TEXT_18 = NL + "\t\t\t                    \tif(String.valueOf(value.";
  protected final String TEXT_19 = ").toLowerCase().equals(\"null\")){" + NL + "\t\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_20 = ", java.sql.Types.CHAR);\t" + NL + "\t\t\t                    \t}else if(value.";
  protected final String TEXT_21 = " == '\\0'){" + NL + "\t\t\t                    \t\tstatement.setString(";
  protected final String TEXT_22 = ", \"\");" + NL + "\t\t\t                    \t}else{" + NL + "\t\t\t                    \t\tstatement.setString(";
  protected final String TEXT_23 = ", String.valueOf(value.";
  protected final String TEXT_24 = "));" + NL + "\t\t\t                    \t}" + NL + "\t\t\t                    ";
  protected final String TEXT_25 = NL + "\t\t\t                        statement.set";
  protected final String TEXT_26 = "(";
  protected final String TEXT_27 = ", value.";
  protected final String TEXT_28 = ");" + NL + "\t\t                    \t";
  protected final String TEXT_29 = NL + "\t\t                    \tif(value.";
  protected final String TEXT_30 = " != null){" + NL + "\t\t                        \tstatement.setBoolean(";
  protected final String TEXT_31 = ", value.";
  protected final String TEXT_32 = ");" + NL + "\t\t                       \t}else{" + NL + "\t\t                       \t\tstatement.setNull(";
  protected final String TEXT_33 = ", java.sql.Types.BOOLEAN);" + NL + "\t\t                       \t}" + NL + "\t\t                    ";
  protected final String TEXT_34 = NL + "\t\t                    \tif(value.";
  protected final String TEXT_35 = " != null){" + NL + "\t\t                    \t\tstatement.setByte(";
  protected final String TEXT_36 = ", value.";
  protected final String TEXT_37 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_38 = ", java.sql.Types.INTEGER);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_39 = NL + "\t\t                    \tif(value.";
  protected final String TEXT_40 = " != null){" + NL + "\t\t                    \t\tstatement.setBytes(";
  protected final String TEXT_41 = ", value.";
  protected final String TEXT_42 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_43 = ", java.sql.Types.ARRAY);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_44 = NL + "\t\t                    \tif(value.";
  protected final String TEXT_45 = " != null){" + NL + "\t\t                    \t\tstatement.setString(";
  protected final String TEXT_46 = ", String.valueOf(value.";
  protected final String TEXT_47 = "));" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_48 = ", java.sql.Types.CHAR);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_49 = NL + "\t\t                    \tif(value.";
  protected final String TEXT_50 = " != null){" + NL + "\t\t                    \t\tstatement.setTimestamp(";
  protected final String TEXT_51 = ", new java.sql.Timestamp(value.";
  protected final String TEXT_52 = ".getTime()));" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_53 = ", java.sql.Types.DATE);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_54 = NL + "\t\t                        if(value.";
  protected final String TEXT_55 = " != null){" + NL + "\t\t                    \t\tstatement.setDouble(";
  protected final String TEXT_56 = ", value.";
  protected final String TEXT_57 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_58 = ", java.sql.Types.DOUBLE);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_59 = NL + "\t\t                        if(value.";
  protected final String TEXT_60 = " != null){" + NL + "\t\t                    \t\tstatement.setFloat(";
  protected final String TEXT_61 = ", value.";
  protected final String TEXT_62 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_63 = ", java.sql.Types.FLOAT);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_64 = NL + "\t\t\t\t                statement.setBigDecimal(";
  protected final String TEXT_65 = ", value.";
  protected final String TEXT_66 = ");" + NL + "\t\t\t                ";
  protected final String TEXT_67 = NL + "\t\t                        if(value.";
  protected final String TEXT_68 = " != null){" + NL + "\t\t                    \t\tstatement.setInt(";
  protected final String TEXT_69 = ", value.";
  protected final String TEXT_70 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_71 = ", java.sql.Types.INTEGER);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_72 = NL + "\t\t                        if(value.";
  protected final String TEXT_73 = " != null){" + NL + "\t\t                    \t\tstatement.setLong(";
  protected final String TEXT_74 = ", value.";
  protected final String TEXT_75 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_76 = ", java.sql.Types.INTEGER);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_77 = NL + "\t\t                        if(value.";
  protected final String TEXT_78 = " != null){" + NL + "\t\t                    \t\tstatement.setObject(";
  protected final String TEXT_79 = ", value.";
  protected final String TEXT_80 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_81 = ", java.sql.Types.OTHER);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_82 = NL + "\t\t                        if(value.";
  protected final String TEXT_83 = " != null){" + NL + "\t\t                    \t\tstatement.setShort(";
  protected final String TEXT_84 = ", value.";
  protected final String TEXT_85 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_86 = ", java.sql.Types.INTEGER);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_87 = NL + "\t\t                        if(value.";
  protected final String TEXT_88 = " != null){" + NL + "\t\t                    \t\tstatement.setString(";
  protected final String TEXT_89 = ", value.";
  protected final String TEXT_90 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_91 = ", java.sql.Types.VARCHAR);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_92 = NL + "\t\t                        statement.setObject(";
  protected final String TEXT_93 = ", value.";
  protected final String TEXT_94 = ");" + NL + "\t\t                    ";
  protected final String TEXT_95 = NL + "                            statement.addBatch();" + NL + "                            batchSizeCounter++;" + NL + "                            if (batchSizeCounter >= batchSize) {" + NL + "                                try{" + NL + "                            \t\tstatement.executeBatch();" + NL + "                            \t}catch(Exception e){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_96 = "                            " + NL + "\t\t\t\t\t\t\t\t\t\tthrow(e);" + NL + "\t                                ";
  protected final String TEXT_97 = NL + "\t                                \tSystem.err.print(e.getMessage());" + NL + "\t                                ";
  protected final String TEXT_98 = NL + "                            \t}" + NL + "                                statement.clearBatch();" + NL + "                                batchSizeCounter = 0;" + NL + "                            }";
  protected final String TEXT_99 = NL + "\t\t\t\t\t\t\ttry{" + NL + "                            \tstatement.executeUpdate();" + NL + "                            }catch(Exception e){" + NL + "                            \t";
  protected final String TEXT_100 = "                            " + NL + "\t\t\t\t\t\t\t\t\tthrow(e);";
  protected final String TEXT_101 = NL + "                                \tSystem.err.print(e.getMessage());";
  protected final String TEXT_102 = NL + "                            }                            ";
  protected final String TEXT_103 = NL + "                    }";
  protected final String TEXT_104 = NL + "                        if (batchSizeCounter != 0) {" + NL + "                            try{" + NL + "                        \t\tstatement.executeBatch();" + NL + "                        \t}catch(Exception e){" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_105 = "                            " + NL + "\t\t\t\t\t\t\t\t\tthrow(e);";
  protected final String TEXT_106 = NL + "                                \tSystem.err.print(e.getMessage());";
  protected final String TEXT_107 = NL + "                        \t}" + NL + "                            statement.clearBatch();" + NL + "                        }";
  protected final String TEXT_108 = NL + "                    statement.close();" + NL + "                    connection.close();" + NL + "                }" + NL + "" + NL + "            }";
  protected final String TEXT_109 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
    BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();  
    String cid = node.getUniqueName();

    List<IMetadataTable> metadatas = node.getMetadataList();
    if((metadatas != null) && (metadatas.size() > 0)){
        IMetadataTable metadata = metadatas.get(0);
        if(metadata != null){

            OracleSparkStorage storage = new OracleSparkStorage(node);

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
            
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connStructName);
    stringBuffer.append(TEXT_5);
    
                if (useBatchSize) {
                    
    stringBuffer.append(TEXT_6);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_7);
    
                }
                
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(storage.getDriver());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connStructName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(storage.getURI());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(columnsDescription);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(connStructName);
    stringBuffer.append(TEXT_17);
    
		                int i = 1;
			            for (IMetadataColumn column: inConn.getMetadataTable().getListColumns()) {
			                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			                
			                if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
			                    typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
			                    if (typeToGenerate.equals("Char")) {
			                    
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_24);
    
			                    } else {
			                    
    stringBuffer.append(TEXT_25);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_28);
    	
		                    	}
			                } else if (typeToGenerate.equals("Boolean")) {
		                    
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_33);
    
			                } else if (typeToGenerate.equals("Byte")) {
		                    
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_38);
    
			                } else if (typeToGenerate.equals("byte[]")) {
		                    
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_43);
    
			                } else if (typeToGenerate.equals("Character")) {
		                    
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    
			                } else if (typeToGenerate.equals("java.util.Date")) {
		                    
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_53);
    
			                } else if (typeToGenerate.equals("Double")) {
		                    
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_58);
    
			                } else if (typeToGenerate.equals("Float")) {
		                    
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_63);
    
			                } else if(typeToGenerate.equals("BigDecimal")) {
			                
    stringBuffer.append(TEXT_64);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_66);
    
			                } else if (typeToGenerate.equals("Integer")) {
		                    
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_71);
    
			                } else if (typeToGenerate.equals("Long")) {
		                    
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_76);
    
			                } else if (typeToGenerate.equals("Object")) {
		                    
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_81);
    
			                } else if (typeToGenerate.equals("Short")) {
		                    
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_86);
    
			                } else if (typeToGenerate.equals("String")) {
		                    
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_91);
    
			                } else if (typeToGenerate.equals("List")) {
		                    
    stringBuffer.append(TEXT_92);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_94);
    
			                } 
			                i++;
			            }
                        if (useBatchSize) {
                            
    stringBuffer.append(TEXT_95);
    
									if(dieOnError){
									
    stringBuffer.append(TEXT_96);
    
	                                }else{
	                                
    stringBuffer.append(TEXT_97);
    
	                                }
	                                
    stringBuffer.append(TEXT_98);
    
                        } else {
                        
    stringBuffer.append(TEXT_99);
    
								if(dieOnError){
								
    stringBuffer.append(TEXT_100);
    
                                }else{
                                
    stringBuffer.append(TEXT_101);
    
                                }
                                
    stringBuffer.append(TEXT_102);
    
                        }
                        
    stringBuffer.append(TEXT_103);
    
                    if (useBatchSize) {
                        
    stringBuffer.append(TEXT_104);
    
								if(dieOnError){
								
    stringBuffer.append(TEXT_105);
    
                                }else{
                                
    stringBuffer.append(TEXT_106);
    
                                }
                                
    stringBuffer.append(TEXT_107);
    
                    }
                    
    stringBuffer.append(TEXT_108);
    
        }
    }

    stringBuffer.append(TEXT_109);
    return stringBuffer.toString();
  }
}
