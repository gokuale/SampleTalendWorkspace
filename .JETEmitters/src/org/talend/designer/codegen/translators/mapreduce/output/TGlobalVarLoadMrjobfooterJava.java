package org.talend.designer.codegen.translators.mapreduce.output;

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

public class TGlobalVarLoadMrjobfooterJava
{
  protected static String nl;
  public static synchronized TGlobalVarLoadMrjobfooterJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGlobalVarLoadMrjobfooterJava result = new TGlobalVarLoadMrjobfooterJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t\t\t" + NL + "\t\t\tList<org.apache.avro.Schema.Field> fields_";
  protected final String TEXT_3 = " = new java.util.ArrayList<org.apache.avro.Schema.Field>();" + NL + "\t\t\tList<org.apache.avro.Schema> unionSchema_";
  protected final String TEXT_4 = " = null;" + NL + "        \t";
  protected final String TEXT_5 = NL + "\t\t\t\t\tfields_";
  protected final String TEXT_6 = ".add(new org.apache.avro.Schema.Field(\"";
  protected final String TEXT_7 = "\",org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_8 = "),null,null));" + NL + "\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\tunionSchema_";
  protected final String TEXT_10 = " = new java.util.ArrayList<org.apache.avro.Schema>();" + NL + "            \t\tunionSchema_";
  protected final String TEXT_11 = ".add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_12 = "));" + NL + "            \t\tunionSchema_";
  protected final String TEXT_13 = ".add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.NULL));" + NL + "\t\t\t\t\tfields_";
  protected final String TEXT_14 = ".add(new org.apache.avro.Schema.Field(\"";
  protected final String TEXT_15 = "\",org.apache.avro.Schema.createUnion(unionSchema_";
  protected final String TEXT_16 = "),null,null));" + NL + "\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\torg.apache.avro.Schema schema_";
  protected final String TEXT_18 = " = org.apache.avro.Schema.createRecord(fields_";
  protected final String TEXT_19 = ");" + NL + "\t\t\t" + NL + "\t\t\t//create file reader" + NL + "\t\t\torg.apache.avro.io.DatumReader<org.apache.avro.generic.GenericRecord> datumReader_";
  protected final String TEXT_20 = " = new org.apache.avro.generic.GenericDatumReader<org.apache.avro.generic.GenericRecord>(schema_";
  protected final String TEXT_21 = ");" + NL + "\t\t\torg.apache.avro.generic.GenericRecord record_";
  protected final String TEXT_22 = " = new org.apache.avro.generic.GenericData.Record(schema_";
  protected final String TEXT_23 = ");" + NL + "\t\t\t" + NL + "\t\t\tStringBuilder strBuffer_";
  protected final String TEXT_24 = " = null;" + NL + "\t\t\tint nb_line_";
  protected final String TEXT_25 = " = 0;" + NL + "\t\t\tfinal java.util.List<org.apache.hadoop.fs.FileStatus> listStatus_";
  protected final String TEXT_26 = " = new java.util.ArrayList<org.apache.hadoop.fs.FileStatus>();" + NL + "\t\t\torg.apache.hadoop.fs.PathFilter hiddenFileFilter_";
  protected final String TEXT_27 = " = new org.apache.hadoop.fs.PathFilter(){" + NL + "\t\t    \tpublic boolean accept(Path p){" + NL + "" + NL + "\t\t\t\t\torg.apache.hadoop.fs.FileStatus statu;" + NL + "\t\t\t\t\tString name = p.getName();" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tstatu = fs.getFileStatus(p);" + NL + "\t\t\t\t\t\tif (statu.isDir()) {" + NL + "\t\t\t\t\t\t} else if (name.startsWith(\".\") || name.startsWith(\"_\")) {" + NL + "\t\t\t\t\t\t} else if (name.endsWith(\".avro\")) {" + NL + "\t\t\t\t\t\t\tlistStatus_";
  protected final String TEXT_28 = ".add(statu);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t} catch (IOException e) {" + NL + "\t\t\t\t\t\t// TODO Auto-generated catch block" + NL + "\t\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t" + NL + "\t\t      \t}" + NL + "\t\t    }; " + NL + "\t\t\tfs.listStatus(new Path(outputPath_";
  protected final String TEXT_29 = "), hiddenFileFilter_";
  protected final String TEXT_30 = ");" + NL + "\t\t\t";
  protected final String TEXT_31 = "Struct ";
  protected final String TEXT_32 = " = new ";
  protected final String TEXT_33 = "Struct();" + NL + "\t\t\tfor(org.apache.hadoop.fs.FileStatus fileStatus_";
  protected final String TEXT_34 = " : listStatus_";
  protected final String TEXT_35 = "){" + NL + "\t\t\t\torg.apache.avro.file.FileReader<org.apache.avro.generic.GenericRecord> reader_";
  protected final String TEXT_36 = " = org.apache.avro.file.DataFileReader.openReader(new org.apache.avro.mapred.FsInput(fileStatus_";
  protected final String TEXT_37 = ".getPath(), job), datumReader_";
  protected final String TEXT_38 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t\twhile(reader_";
  protected final String TEXT_39 = ".hasNext()){" + NL + "\t\t\t\t\trecord_";
  protected final String TEXT_40 = " = reader_";
  protected final String TEXT_41 = ".next(record_";
  protected final String TEXT_42 = ");" + NL + "\t\t\t\t\tObject columnObject_";
  protected final String TEXT_43 = " = null;" + NL + "\t\t\t\t\tif(reader_";
  protected final String TEXT_44 = ".hasNext()) continue;" + NL + "\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\tcolumnObject_";
  protected final String TEXT_46 = " = record_";
  protected final String TEXT_47 = ".get(\"";
  protected final String TEXT_48 = "\");" + NL + "\t\t\t\t\t\tif(columnObject_";
  protected final String TEXT_49 = " != null) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = " = columnObject_";
  protected final String TEXT_53 = ".toString();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = " = ((Integer)columnObject_";
  protected final String TEXT_57 = ").byteValue();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = " = ((Integer)columnObject_";
  protected final String TEXT_61 = ").shortValue();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = " = (Character)(char)(int)(Integer)columnObject_";
  protected final String TEXT_65 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = " = ((java.nio.ByteBuffer)columnObject_";
  protected final String TEXT_69 = ").array();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = " = new java.math.BigDecimal(columnObject_";
  protected final String TEXT_73 = ".toString());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = " = new java.util.Date((Long)columnObject_";
  protected final String TEXT_77 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = " = (";
  protected final String TEXT_81 = ")columnObject_";
  protected final String TEXT_82 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = " = ";
  protected final String TEXT_87 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_91 = "\", ";
  protected final String TEXT_92 = ".";
  protected final String TEXT_93 = ");" + NL + "\t\t\t";
  protected final String TEXT_94 = NL + "\t\t";

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
        
			List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
		    if(inConns != null && inConns.size() > 0){
		        
		    }else{
		        return "";
		    }
			IConnection inConn = inConns.get(0);
			String connName = inConn.getName();
			
			List<IMetadataColumn> columns = metadata.getListColumns();
			int sizeColumns = columns.size();
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
			java.util.Map<JavaType,String> talendTypeToAvroType = new java.util.HashMap<JavaType,String>();
			talendTypeToAvroType.put(JavaTypesManager.STRING,"STRING");
			talendTypeToAvroType.put(JavaTypesManager.CHARACTER,"INT");
			talendTypeToAvroType.put(JavaTypesManager.BYTE_ARRAY,"BYTES");
			talendTypeToAvroType.put(JavaTypesManager.INTEGER,"INT");
			talendTypeToAvroType.put(JavaTypesManager.BYTE,"INT");
			talendTypeToAvroType.put(JavaTypesManager.SHORT,"INT");
			talendTypeToAvroType.put(JavaTypesManager.LONG,"LONG");
			talendTypeToAvroType.put(JavaTypesManager.FLOAT,"FLOAT");
			talendTypeToAvroType.put(JavaTypesManager.DOUBLE,"DOUBLE");
			talendTypeToAvroType.put(JavaTypesManager.BOOLEAN,"BOOLEAN");
			talendTypeToAvroType.put(JavaTypesManager.BIGDECIMAL,"STRING");
			talendTypeToAvroType.put(JavaTypesManager.DATE,"LONG");
            
            for(IMetadataColumn column : columns){
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				String columnName = column.getLabel();	
				boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
				
			    if(isPrimitive) {
				
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(talendTypeToAvroType.get(javaType));
    stringBuffer.append(TEXT_8);
    
			    } else {
				
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(talendTypeToAvroType.get(javaType));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
   				}
			}
            
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(connName);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
					for(IMetadataColumn column : columns){
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						String objectTypeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), true);
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String columnName = column.getLabel();	
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    if(javaType == JavaTypesManager.STRING) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    } else if(javaType == JavaTypesManager.BYTE) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    } else if(javaType == JavaTypesManager.SHORT) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    } else if(javaType == JavaTypesManager.CHARACTER) {
    stringBuffer.append(TEXT_62);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    } else if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    } else if(javaType == JavaTypesManager.DATE) {
    stringBuffer.append(TEXT_74);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    } else {
    stringBuffer.append(TEXT_78);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(objectTypeToGenerate);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    if(defaultValue!=null && defaultValue.length()>0){
    stringBuffer.append(TEXT_84);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    
					}
					
    stringBuffer.append(TEXT_89);
    
			for(IMetadataColumn column : columns){
			
    stringBuffer.append(TEXT_90);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_93);
    	
			}
			
    stringBuffer.append(TEXT_94);
    
    	}
	}    
	
    return stringBuffer.toString();
  }
}
