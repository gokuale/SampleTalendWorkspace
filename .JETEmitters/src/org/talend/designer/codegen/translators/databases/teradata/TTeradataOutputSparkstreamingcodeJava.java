package org.talend.designer.codegen.translators.databases.teradata;

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
import org.talend.designer.spark.generator.storage.TeradataSparkStorage;

public class TTeradataOutputSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TTeradataOutputSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataOutputSparkstreamingcodeJava result = new TTeradataOutputSparkstreamingcodeJava();
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
  protected final String TEXT_9 = "_OutputFunction(JobConf conf) throws ClassNotFoundException, java.sql.SQLException {" + NL + "                    Class.forName(\"com.teradata.jdbc.TeraDriver\");" + NL + "                    context = new ContextProperties(conf);" + NL + "                }" + NL + "" + NL + "                public void call(java.util.Iterator<";
  protected final String TEXT_10 = "> dataIterator) throws java.lang.Exception {" + NL + "                    java.sql.Connection connection = java.sql.DriverManager.getConnection(";
  protected final String TEXT_11 = ");" + NL + "" + NL + "" + NL + "                    java.sql.PreparedStatement statement = connection.prepareStatement(\"INSERT INTO \\\"\" + ";
  protected final String TEXT_12 = " + \"\\\" (";
  protected final String TEXT_13 = ") VALUES(";
  protected final String TEXT_14 = ")\");" + NL + "                    while (dataIterator.hasNext()) {";
  protected final String TEXT_15 = NL + "                        ";
  protected final String TEXT_16 = " value = dataIterator.next();";
  protected final String TEXT_17 = NL + "\t\t\t                    \tif(String.valueOf(value.";
  protected final String TEXT_18 = ").toLowerCase().equals(\"null\")){" + NL + "\t\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_19 = ", java.sql.Types.CHAR);\t" + NL + "\t\t\t                    \t}else if(value.";
  protected final String TEXT_20 = " == '\\0'){" + NL + "\t\t\t                    \t\tstatement.setString(";
  protected final String TEXT_21 = ", \"\");" + NL + "\t\t\t                    \t}else{" + NL + "\t\t\t                    \t\tstatement.setString(";
  protected final String TEXT_22 = ", String.valueOf(value.";
  protected final String TEXT_23 = "));" + NL + "\t\t\t                    \t}" + NL + "\t\t\t                    ";
  protected final String TEXT_24 = NL + "\t\t\t                        statement.set";
  protected final String TEXT_25 = "(";
  protected final String TEXT_26 = ", value.";
  protected final String TEXT_27 = ");" + NL + "\t\t                    \t";
  protected final String TEXT_28 = NL + "\t\t                    \tif(value.";
  protected final String TEXT_29 = " != null){" + NL + "\t\t                        \tstatement.setBoolean(";
  protected final String TEXT_30 = ", value.";
  protected final String TEXT_31 = ");" + NL + "\t\t                       \t}else{" + NL + "\t\t                       \t\tstatement.setNull(";
  protected final String TEXT_32 = ", java.sql.Types.BOOLEAN);" + NL + "\t\t                       \t}" + NL + "\t\t                    ";
  protected final String TEXT_33 = NL + "\t\t                    \tif(value.";
  protected final String TEXT_34 = " != null){" + NL + "\t\t                    \t\tstatement.setByte(";
  protected final String TEXT_35 = ", value.";
  protected final String TEXT_36 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_37 = ", java.sql.Types.INTEGER);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_38 = NL + "\t\t                    \tif(value.";
  protected final String TEXT_39 = " != null){" + NL + "\t\t                    \t\tstatement.setBytes(";
  protected final String TEXT_40 = ", value.";
  protected final String TEXT_41 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_42 = ", java.sql.Types.ARRAY);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_43 = NL + "\t\t                    \tif(value.";
  protected final String TEXT_44 = " != null){" + NL + "\t\t                    \t\tstatement.setString(";
  protected final String TEXT_45 = ", String.valueOf(value.";
  protected final String TEXT_46 = "));" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_47 = ", java.sql.Types.CHAR);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_48 = NL + "\t\t                    \tif(value.";
  protected final String TEXT_49 = " != null){" + NL + "\t\t                    \t\tstatement.setTimestamp(";
  protected final String TEXT_50 = ", new java.sql.Timestamp(value.";
  protected final String TEXT_51 = ".getTime()));" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_52 = ", java.sql.Types.DATE);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_53 = NL + "\t\t                        if(value.";
  protected final String TEXT_54 = " != null){" + NL + "\t\t                    \t\tstatement.setDouble(";
  protected final String TEXT_55 = ", value.";
  protected final String TEXT_56 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_57 = ", java.sql.Types.DOUBLE);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_58 = NL + "\t\t                        if(value.";
  protected final String TEXT_59 = " != null){" + NL + "\t\t                    \t\tstatement.setFloat(";
  protected final String TEXT_60 = ", value.";
  protected final String TEXT_61 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_62 = ", java.sql.Types.FLOAT);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_63 = NL + "\t\t\t\t                statement.setBigDecimal(";
  protected final String TEXT_64 = ", value.";
  protected final String TEXT_65 = ");" + NL + "\t\t\t                ";
  protected final String TEXT_66 = NL + "\t\t                        if(value.";
  protected final String TEXT_67 = " != null){" + NL + "\t\t                    \t\tstatement.setInt(";
  protected final String TEXT_68 = ", value.";
  protected final String TEXT_69 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_70 = ", java.sql.Types.INTEGER);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_71 = NL + "\t\t                        if(value.";
  protected final String TEXT_72 = " != null){" + NL + "\t\t                    \t\tstatement.setLong(";
  protected final String TEXT_73 = ", value.";
  protected final String TEXT_74 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_75 = ", java.sql.Types.INTEGER);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_76 = NL + "\t\t                        if(value.";
  protected final String TEXT_77 = " != null){" + NL + "\t\t                    \t\tstatement.setObject(";
  protected final String TEXT_78 = ", value.";
  protected final String TEXT_79 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_80 = ", java.sql.Types.OTHER);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_81 = NL + "\t\t                        if(value.";
  protected final String TEXT_82 = " != null){" + NL + "\t\t                    \t\tstatement.setShort(";
  protected final String TEXT_83 = ", value.";
  protected final String TEXT_84 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_85 = ", java.sql.Types.INTEGER);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_86 = NL + "\t\t                        if(value.";
  protected final String TEXT_87 = " != null){" + NL + "\t\t                    \t\tstatement.setString(";
  protected final String TEXT_88 = ", value.";
  protected final String TEXT_89 = ");" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tstatement.setNull(";
  protected final String TEXT_90 = ", java.sql.Types.VARCHAR);\t" + NL + "\t\t                    \t}" + NL + "\t\t                    ";
  protected final String TEXT_91 = NL + "\t\t                        statement.setObject(";
  protected final String TEXT_92 = ", value.";
  protected final String TEXT_93 = ");" + NL + "\t\t                    ";
  protected final String TEXT_94 = NL + "                            statement.addBatch();" + NL + "                            batchSizeCounter++;" + NL + "                            if (batchSizeCounter >= batchSize) {" + NL + "                                try{" + NL + "                            \t\tstatement.executeBatch();" + NL + "                            \t}catch(Exception e){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_95 = "                            " + NL + "\t\t\t\t\t\t\t\t\t\tthrow(e);" + NL + "\t                                ";
  protected final String TEXT_96 = NL + "\t                                \tSystem.err.print(e.getMessage());" + NL + "\t                                ";
  protected final String TEXT_97 = NL + "                            \t}" + NL + "                                statement.clearBatch();" + NL + "                                batchSizeCounter = 0;" + NL + "                            }";
  protected final String TEXT_98 = NL + "                        \ttry{" + NL + "                            \tstatement.executeUpdate();" + NL + "                            }catch(Exception e){" + NL + "                            \t";
  protected final String TEXT_99 = "                            " + NL + "\t\t\t\t\t\t\t\t\tthrow(e);";
  protected final String TEXT_100 = NL + "                                \tSystem.err.print(e.getMessage());";
  protected final String TEXT_101 = NL + "                            }";
  protected final String TEXT_102 = NL + "                    }";
  protected final String TEXT_103 = NL + "                        if (batchSizeCounter != 0) {" + NL + "                            try{" + NL + "\t                            statement.executeBatch();" + NL + "                            }catch(Exception e){" + NL + "                            \t";
  protected final String TEXT_104 = "                            " + NL + "\t\t\t\t\t\t\t\t\tthrow(e);";
  protected final String TEXT_105 = NL + "                                \tSystem.err.print(e.getMessage());";
  protected final String TEXT_106 = NL + "                            }" + NL + "                            statement.clearBatch();" + NL + "                        }";
  protected final String TEXT_107 = NL + "                    statement.close();" + NL + "                    connection.close();" + NL + "                }" + NL + "" + NL + "            }";

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

            TeradataSparkStorage storage = new TeradataSparkStorage(node);

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
                    columnsDescription += ",\\\"" + column.getOriginalDbColumnName() + "\\\"";
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
    stringBuffer.append(connStructName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(storage.getURI());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnsDescription);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(connStructName);
    stringBuffer.append(TEXT_16);
    
		                int i = 1;
			            for (IMetadataColumn column: inConn.getMetadataTable().getListColumns()) {
			                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			                
			                if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
			                    typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
			                    if (typeToGenerate.equals("Char")) {
			                    
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_23);
    
			                    } else {
			                    
    stringBuffer.append(TEXT_24);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_27);
    	
		                    	}
			                } else if (typeToGenerate.equals("Boolean")) {
		                    
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_32);
    
			                } else if (typeToGenerate.equals("Byte")) {
		                    
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_37);
    
			                } else if (typeToGenerate.equals("byte[]")) {
		                    
    stringBuffer.append(TEXT_38);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_42);
    
			                } else if (typeToGenerate.equals("Character")) {
		                    
    stringBuffer.append(TEXT_43);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_47);
    
			                } else if (typeToGenerate.equals("java.util.Date")) {
		                    
    stringBuffer.append(TEXT_48);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_52);
    
			                } else if (typeToGenerate.equals("Double")) {
		                    
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    
			                } else if (typeToGenerate.equals("Float")) {
		                    
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_62);
    
			                } else if(typeToGenerate.equals("BigDecimal")) {
			                
    stringBuffer.append(TEXT_63);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_65);
    
			                } else if (typeToGenerate.equals("Integer")) {
		                    
    stringBuffer.append(TEXT_66);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_70);
    
			                } else if (typeToGenerate.equals("Long")) {
		                    
    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_75);
    
			                } else if (typeToGenerate.equals("Object")) {
		                    
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_80);
    
			                } else if (typeToGenerate.equals("Short")) {
		                    
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_85);
    
			                } else if (typeToGenerate.equals("String")) {
		                    
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_90);
    
			                } else if (typeToGenerate.equals("List")) {
		                    
    stringBuffer.append(TEXT_91);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_93);
    
			                } 
			                i++;
			            }
                        if (useBatchSize) {
                            
    stringBuffer.append(TEXT_94);
    
									if(dieOnError){
									
    stringBuffer.append(TEXT_95);
    
	                                }else{
	                                
    stringBuffer.append(TEXT_96);
    
	                                }
	                                
    stringBuffer.append(TEXT_97);
    
                        } else {
						
    stringBuffer.append(TEXT_98);
    
								if(dieOnError){
								
    stringBuffer.append(TEXT_99);
    
                                }else{
                                
    stringBuffer.append(TEXT_100);
    
                                }
                                
    stringBuffer.append(TEXT_101);
    
                        }
                        
    stringBuffer.append(TEXT_102);
    
                    if (useBatchSize) {
                        
    stringBuffer.append(TEXT_103);
    
								if(dieOnError){
								
    stringBuffer.append(TEXT_104);
    
                                }else{
                                
    stringBuffer.append(TEXT_105);
    
                                }
                                
    stringBuffer.append(TEXT_106);
    
                    }
                    
    stringBuffer.append(TEXT_107);
    
        }
    }

    return stringBuffer.toString();
  }
}
