package org.talend.designer.codegen.translators.databases.mongodb;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;

public class TMongoDBWriteConfMainJava
{
  protected static String nl;
  public static synchronized TMongoDBWriteConfMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBWriteConfMainJava result = new TMongoDBWriteConfMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tcom.mongodb.WriteResult resultMessage_";
  protected final String TEXT_2 = "=null;" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Trying to parse a json string.\");" + NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_5 = " - The JSON string:\"+json_";
  protected final String TEXT_6 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\tObject data_";
  protected final String TEXT_8 = "=com.mongodb.util.JSON.parse(json_";
  protected final String TEXT_9 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Parsed Successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\tObject queryObj_";
  protected final String TEXT_13 = "=null;" + NL + "\t\t\tif(data_";
  protected final String TEXT_14 = "!=null){" + NL + "\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\tif(bulkWriteOperationCounter_";
  protected final String TEXT_16 = " < bulkWriteOperationSize_";
  protected final String TEXT_17 = "){" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_18 = ".insert((com.mongodb.DBObject)data_";
  protected final String TEXT_19 = ");" + NL + "\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_20 = "++;" + NL + "\t\t\t\t\t\t} else {" + NL + "                            bulkWriteOperation_";
  protected final String TEXT_21 = ".insert((com.mongodb.DBObject)data_";
  protected final String TEXT_22 = ");" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_23 = ".execute();" + NL + "\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_24 = "=1;" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_25 = " = coll_";
  protected final String TEXT_26 = ".initialize";
  protected final String TEXT_27 = "BulkOperation();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\tresultMessage_";
  protected final String TEXT_29 = "=coll_";
  protected final String TEXT_30 = ".insert((com.mongodb.DBObject)data_";
  protected final String TEXT_31 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\tif(bulkWriteOperationCounter_";
  protected final String TEXT_33 = " < bulkWriteOperationSize_";
  protected final String TEXT_34 = "){" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_35 = ".find((com.mongodb.DBObject)data_";
  protected final String TEXT_36 = ").remove();" + NL + "\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_37 = "++;" + NL + "\t\t\t\t\t\t}else{" + NL + "                            bulkWriteOperation_";
  protected final String TEXT_38 = ".find((com.mongodb.DBObject)data_";
  protected final String TEXT_39 = ").remove();" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_40 = ".execute();" + NL + "\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_41 = "=1;" + NL + "\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_42 = " = coll_";
  protected final String TEXT_43 = ".initialize";
  protected final String TEXT_44 = "BulkOperation();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\tresultMessage_";
  protected final String TEXT_46 = "=coll_";
  protected final String TEXT_47 = ".remove((com.mongodb.DBObject)data_";
  protected final String TEXT_48 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\tqueryObj_";
  protected final String TEXT_50 = " =((com.mongodb.DBObject)data_";
  protected final String TEXT_51 = ").get(";
  protected final String TEXT_52 = ");" + NL + "\t\t\t\t\tdata_";
  protected final String TEXT_53 = "=((com.mongodb.DBObject)data_";
  protected final String TEXT_54 = ").get(";
  protected final String TEXT_55 = ");" + NL + "\t\t\t\t\tif(data_";
  protected final String TEXT_56 = "!=null && queryObj_";
  protected final String TEXT_57 = "!=null){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_58 = NL + "                                if(bulkWriteOperationCounter_";
  protected final String TEXT_59 = " < bulkWriteOperationSize_";
  protected final String TEXT_60 = "){" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_61 = ".find((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_62 = ").replaceOne((com.mongodb.DBObject)data_";
  protected final String TEXT_63 = ");" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_64 = "++;" + NL + "                                }else{" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_65 = ".find((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_66 = ").replaceOne((com.mongodb.DBObject)data_";
  protected final String TEXT_67 = ");" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_68 = ".execute();" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_69 = "=1;" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_70 = " = coll_";
  protected final String TEXT_71 = ".initialize";
  protected final String TEXT_72 = "BulkOperation();" + NL + "                                }";
  protected final String TEXT_73 = NL + "                                resultMessage_";
  protected final String TEXT_74 = "=coll_";
  protected final String TEXT_75 = ".update((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_76 = ",(com.mongodb.DBObject)data_";
  protected final String TEXT_77 = ");";
  protected final String TEXT_78 = NL + "                                if(bulkWriteOperationCounter_";
  protected final String TEXT_79 = " < bulkWriteOperationSize_";
  protected final String TEXT_80 = "){" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_81 = ".find((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_82 = ").update(new com.mongodb.BasicDBObject(\"$set\", (com.mongodb.DBObject)data_";
  protected final String TEXT_83 = "));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_84 = "++;" + NL + "                                }else{" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_85 = ".find((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_86 = ").update(new com.mongodb.BasicDBObject(\"$set\", (com.mongodb.DBObject)data_";
  protected final String TEXT_87 = "));" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_88 = ".execute();" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_89 = "=1;" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_90 = " = coll_";
  protected final String TEXT_91 = ".initialize";
  protected final String TEXT_92 = "BulkOperation();" + NL + "                                }";
  protected final String TEXT_93 = NL + "                                resultMessage_";
  protected final String TEXT_94 = "=coll_";
  protected final String TEXT_95 = ".update((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_96 = ",new com.mongodb.BasicDBObject(\"$set\", (com.mongodb.DBObject)data_";
  protected final String TEXT_97 = "));";
  protected final String TEXT_98 = NL + "\t\t\t\t\t\t\t\tif(bulkWriteOperationCounter_";
  protected final String TEXT_99 = " < bulkWriteOperationSize_";
  protected final String TEXT_100 = "){" + NL + "\t\t\t\t\t\t\t\t\tcom.mongodb.BulkWriteRequestBuilder bulkWriteRequestBuilder_";
  protected final String TEXT_101 = " = bulkWriteOperation_";
  protected final String TEXT_102 = ".find((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_103 = ");" + NL + "\t\t\t\t\t\t\t\t\tcom.mongodb.BulkUpdateRequestBuilder bulkUpdateRequestBuilder_";
  protected final String TEXT_104 = " = bulkWriteRequestBuilder_";
  protected final String TEXT_105 = ".upsert();" + NL + "\t\t\t\t\t\t\t\t\tbulkUpdateRequestBuilder_";
  protected final String TEXT_106 = ".replaceOne((com.mongodb.DBObject)data_";
  protected final String TEXT_107 = ");" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_108 = "++;" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "                                    com.mongodb.BulkWriteRequestBuilder bulkWriteRequestBuilder_";
  protected final String TEXT_109 = " = bulkWriteOperation_";
  protected final String TEXT_110 = ".find((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_111 = ");" + NL + "                                    com.mongodb.BulkUpdateRequestBuilder bulkUpdateRequestBuilder_";
  protected final String TEXT_112 = " = bulkWriteRequestBuilder_";
  protected final String TEXT_113 = ".upsert();" + NL + "                                    bulkUpdateRequestBuilder_";
  protected final String TEXT_114 = ".replaceOne((com.mongodb.DBObject)data_";
  protected final String TEXT_115 = ");" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_116 = ".execute();" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperationCounter_";
  protected final String TEXT_117 = "=1;" + NL + "\t\t\t\t\t\t\t\t\tbulkWriteOperation_";
  protected final String TEXT_118 = " = coll_";
  protected final String TEXT_119 = ".initialize";
  protected final String TEXT_120 = "BulkOperation();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_121 = NL + "\t\t\t\t\t\t\t\tresultMessage_";
  protected final String TEXT_122 = "=coll_";
  protected final String TEXT_123 = ".update((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_124 = ",(com.mongodb.DBObject)data_";
  protected final String TEXT_125 = ",true,false);" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_126 = NL + "                                if(bulkWriteOperationCounter_";
  protected final String TEXT_127 = " < bulkWriteOperationSize_";
  protected final String TEXT_128 = "){" + NL + "                                    com.mongodb.BulkWriteRequestBuilder bulkWriteRequestBuilder_";
  protected final String TEXT_129 = " = bulkWriteOperation_";
  protected final String TEXT_130 = ".find((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_131 = ");" + NL + "                                    com.mongodb.BulkUpdateRequestBuilder bulkUpdateRequestBuilder_";
  protected final String TEXT_132 = " = bulkWriteRequestBuilder_";
  protected final String TEXT_133 = ".upsert();" + NL + "                                    bulkUpdateRequestBuilder_";
  protected final String TEXT_134 = ".update(new com.mongodb.BasicDBObject(\"$set\", (com.mongodb.DBObject)data_";
  protected final String TEXT_135 = "));" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_136 = "++;" + NL + "                                }else{" + NL + "                                    com.mongodb.BulkWriteRequestBuilder bulkWriteRequestBuilder_";
  protected final String TEXT_137 = " = bulkWriteOperation_";
  protected final String TEXT_138 = ".find((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_139 = ");" + NL + "                                    com.mongodb.BulkUpdateRequestBuilder bulkUpdateRequestBuilder_";
  protected final String TEXT_140 = " = bulkWriteRequestBuilder_";
  protected final String TEXT_141 = ".upsert();" + NL + "                                    bulkUpdateRequestBuilder_";
  protected final String TEXT_142 = ".update(new com.mongodb.BasicDBObject(\"$set\", (com.mongodb.DBObject)data_";
  protected final String TEXT_143 = "));" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_144 = ".execute();" + NL + "                                    bulkWriteOperationCounter_";
  protected final String TEXT_145 = "=1;" + NL + "                                    bulkWriteOperation_";
  protected final String TEXT_146 = " = coll_";
  protected final String TEXT_147 = ".initialize";
  protected final String TEXT_148 = "BulkOperation();" + NL + "                                }";
  protected final String TEXT_149 = NL + "                                resultMessage_";
  protected final String TEXT_150 = "=coll_";
  protected final String TEXT_151 = ".update((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_152 = ",new com.mongodb.BasicDBObject(\"$set\", (com.mongodb.DBObject)data_";
  protected final String TEXT_153 = "),true,false);";
  protected final String TEXT_154 = "\t" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_155 = NL + "\t\t\t\t\t\t\tthrow new Exception(\"Data node or Query node configuration error! \");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_156 = NL + "\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_157 = " - Data node or Query node configuration error!\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_158 = NL + "\t\t\t\t\t\t\tSystem.err.println(\"Data node or Query node configuration error!\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_159 = "\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_160 = NL + "    \t\t\t\tif(resultMessage_";
  protected final String TEXT_161 = "!=null && resultMessage_";
  protected final String TEXT_162 = ".getError()!=null){" + NL + "    \t\t\t\t\t";
  protected final String TEXT_163 = NL + "    \t\t\t\t\t\tthrow new Exception(resultMessage_";
  protected final String TEXT_164 = ".getError());" + NL + "    \t\t\t\t\t";
  protected final String TEXT_165 = NL + "    \t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_166 = " - \" + resultMessage_";
  protected final String TEXT_167 = ".getError());" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_168 = NL + "    \t\t\t\t\t\tSystem.err.println(resultMessage_";
  protected final String TEXT_169 = ".getError());" + NL + "    \t\t\t\t\t";
  protected final String TEXT_170 = NL + "    \t\t\t\t}" + NL + "    \t\t\t\t";
  protected final String TEXT_171 = NL + "\t\t\t}else{" + NL + "\t\t\t\t";
  protected final String TEXT_172 = NL + "\t\t\t\t\tthrow new Exception(\"There no data in json,Please check the json configuration\");" + NL + "\t\t\t\t";
  protected final String TEXT_173 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_174 = " - There no data in json,Please check the json configuration\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_175 = NL + "\t\t\t\t\tSystem.err.println(\"There no data in json,Please check the json configuration\");" + NL + "\t\t\t\t";
  protected final String TEXT_176 = "\t" + NL + "\t\t\t}\t\t" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	String dataNode = ElementParameterParser.getValue(node,"__DATA_NODE__");
	String queryNode = ElementParameterParser.getValue(node,"__QUERY_NODE__");
	boolean dieOnError = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    String dbversion = ElementParameterParser.getValue(node, "__DB_VERSION__");

    boolean setBulkWrite = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_BULK_WRITE__"));
    String bulkWriteOperationSize = ElementParameterParser.getValue(node, "__BULK_WRITE_SIZE__");
    String bulkWriteType = ElementParameterParser.getValue(node, "__BULK_WRITE_TYPE__");
    // BulkWrite is only supportted on Mongo 2.6+ drivers
    final boolean bulkWrite = setBulkWrite & (!"MONGODB_2_5_X".equalsIgnoreCase(dbversion));
    
    List<IMetadataTable> metadatas = node.getMetadataList();
  	if(metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	if(metadata != null){
		
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
				if("Insert".equalsIgnoreCase(dataAction)){
					// Bulk Writes
					if(bulkWrite){
						// Add inserts untill bulksize is reached then execute and re-initialze the bulk operation
						
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_27);
    
					// Single Writes
					}else{
					
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
					}
				// Other operations (UPDATE, UPSERT, DELETE)
				}else if("DELETE".equalsIgnoreCase(dataAction)){
				// Bulk Delete
					if(bulkWrite){
						
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_44);
    
					}else{
						
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
					}
				}else{
				
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(queryNode);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(dataNode);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
						if("UPDATE".equalsIgnoreCase(dataAction)){
	                        // Bulk Updates
                            if(bulkWrite){
                                
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_72);
    
                            }else{
                                
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
                            }
                        } else if("SET".equalsIgnoreCase(dataAction)){
                            // Bulk Updates
                            if(bulkWrite){
                                
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_92);
    
                            }else{
                                
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
                            }
                        } else if("UPSERT".equalsIgnoreCase(dataAction)){
                            // Bulk Upsert
							if(bulkWrite){
								
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_120);
    
							}else{
								
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
							}
                        } else if("UPSERT_WITH_SET".equalsIgnoreCase(dataAction)){
                            // Bulk Upsert
                            if(bulkWrite){
                                
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(bulkWriteType);
    stringBuffer.append(TEXT_148);
    
                            }else{
                                
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
                            }
                        }
						
    stringBuffer.append(TEXT_154);
    
						if(dieOnError){
						
    stringBuffer.append(TEXT_155);
    
						}else{
							if(isLog4jEnabled){
							
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
							}
							
    stringBuffer.append(TEXT_158);
    
						}
						
    stringBuffer.append(TEXT_159);
    
				}
				
                if (dbversion.equals("MONGODB_2_5_X")) {
                
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    
    					if(dieOnError){
    					
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    
    					}else{
    						if(isLog4jEnabled){
    						
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    
    						}
    						
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    
    					}
    					
    stringBuffer.append(TEXT_170);
    
                }
    			
    stringBuffer.append(TEXT_171);
    
				if(dieOnError){
				
    stringBuffer.append(TEXT_172);
    
				}else{
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
					}
					
    stringBuffer.append(TEXT_175);
    
				}
				
    stringBuffer.append(TEXT_176);
    
		}
	}
	
    return stringBuffer.toString();
  }
}
