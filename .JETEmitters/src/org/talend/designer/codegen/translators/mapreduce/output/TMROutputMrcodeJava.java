package org.talend.designer.codegen.translators.mapreduce.output;

import java.util.HashMap;
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

public class TMROutputMrcodeJava
{
  protected static String nl;
  public static synchronized TMROutputMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMROutputMrcodeJava result = new TMROutputMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "        public static class ";
  protected final String TEXT_3 = "StructOutputFormat extends FileOutputFormat<NullWritable, ";
  protected final String TEXT_4 = ">{" + NL + "            protected static class AvroRecordWriter implements RecordWriter<NullWritable, ";
  protected final String TEXT_5 = ">{" + NL + "                org.apache.avro.file.DataFileWriter<org.apache.avro.generic.GenericRecord> writer = null;" + NL + "                private ContextProperties context;" + NL + "" + NL + "                private org.apache.avro.Schema schema = null;" + NL + "" + NL + "                public AvroRecordWriter(org.apache.avro.file.DataFileWriter<org.apache.avro.generic.GenericRecord> writer, JobConf job, org.apache.avro.Schema schema){" + NL + "                    this.context = new ContextProperties(job);" + NL + "                    this.writer = writer;" + NL + "                    this.schema = schema;" + NL + "                }" + NL + "" + NL + "                public void write(NullWritable key, ";
  protected final String TEXT_6 = " value) throws IOException{" + NL + "                    org.apache.avro.generic.GenericRecord record = new org.apache.avro.generic.GenericData.Record(schema);";
  protected final String TEXT_7 = NL + "                            if(value.";
  protected final String TEXT_8 = " != null){";
  protected final String TEXT_9 = NL + "                            record.put(\"";
  protected final String TEXT_10 = "\", ((Byte)(value.";
  protected final String TEXT_11 = ")).intValue());";
  protected final String TEXT_12 = NL + "                            record.put(\"";
  protected final String TEXT_13 = "\", ((Short)(value.";
  protected final String TEXT_14 = ")).intValue());";
  protected final String TEXT_15 = NL + "                            record.put(\"";
  protected final String TEXT_16 = "\", (int)(char)(Character)(value.";
  protected final String TEXT_17 = "));";
  protected final String TEXT_18 = NL + "                                record.put(\"";
  protected final String TEXT_19 = "\", value.";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "                                record.put(\"";
  protected final String TEXT_22 = "\", java.nio.ByteBuffer.wrap(value.";
  protected final String TEXT_23 = "));";
  protected final String TEXT_24 = NL + "                            record.put(\"";
  protected final String TEXT_25 = "\", value.";
  protected final String TEXT_26 = ".toString());";
  protected final String TEXT_27 = NL + "                            record.put(\"";
  protected final String TEXT_28 = "\", value.";
  protected final String TEXT_29 = ".toString());";
  protected final String TEXT_30 = NL + "                            record.put(\"";
  protected final String TEXT_31 = "\", value.";
  protected final String TEXT_32 = ".getTime());";
  protected final String TEXT_33 = NL + "                            record.put(\"";
  protected final String TEXT_34 = "\", value.";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "                            }";
  protected final String TEXT_37 = NL + "                     writer.append(record);" + NL + "                }" + NL + "" + NL + "                public void close(Reporter reporter) throws IOException{" + NL + "                    writer.close();" + NL + "                }" + NL + "            }" + NL + "" + NL + "              void configureDataFileWriter(org.apache.avro.file.DataFileWriter<org.apache.avro.generic.GenericRecord> writer, JobConf job) throws java.io.UnsupportedEncodingException{";
  protected final String TEXT_38 = NL + "                    int level = job.getInt(org.apache.avro.mapred.AvroOutputFormat.DEFLATE_LEVEL_KEY, org.apache.avro.mapred.AvroOutputFormat.DEFAULT_DEFLATE_LEVEL);" + NL + "                    org.apache.avro.file.CodecFactory factory = org.apache.avro.file.CodecFactory.deflateCodec(level);" + NL + "                    writer.setCodec(factory);";
  protected final String TEXT_39 = NL + NL + "                writer.setSyncInterval(job.getInt(org.apache.avro.mapred.AvroOutputFormat.SYNC_INTERVAL_KEY, org.apache.avro.file.DataFileConstants.DEFAULT_SYNC_INTERVAL));" + NL + "              }" + NL + "" + NL + "            public final static String EXT = \".avro\";" + NL + "" + NL + "            public RecordWriter<NullWritable, ";
  protected final String TEXT_40 = "> getRecordWriter(" + NL + "                    FileSystem ignored, JobConf job, String name, Progressable progress) throws IOException{" + NL + "                //set schema" + NL + "                List<org.apache.avro.Schema.Field> fields = new java.util.ArrayList<org.apache.avro.Schema.Field>();" + NL + "                List<org.apache.avro.Schema> unionSchema = null;" + NL + "                List<org.apache.avro.Schema> arraySchema = null;";
  protected final String TEXT_41 = NL + "                        fields.add(new org.apache.avro.Schema.Field(\"";
  protected final String TEXT_42 = "\",org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_43 = "),null,null));";
  protected final String TEXT_44 = NL + "                        unionSchema = new java.util.ArrayList<org.apache.avro.Schema>();";
  protected final String TEXT_45 = NL + "                            unionSchema.add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_46 = "));";
  protected final String TEXT_47 = NL + "                            arraySchema = new java.util.ArrayList<org.apache.avro.Schema>();";
  protected final String TEXT_48 = NL + "                                arraySchema.add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_49 = "));";
  protected final String TEXT_50 = NL + "                            arraySchema.add(org.apache.avro.Schema" + NL + "                                    .createArray(org.apache.avro.Schema" + NL + "                                            .createUnion(arraySchema)));" + NL + "                            unionSchema.add(org.apache.avro.Schema.createArray(" + NL + "                                    org.apache.avro.Schema.createUnion(arraySchema)));";
  protected final String TEXT_51 = NL + "                                unionSchema.add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_52 = "));";
  protected final String TEXT_53 = NL + NL + "                        unionSchema.add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.NULL));" + NL + "                        fields.add(new org.apache.avro.Schema.Field(\"";
  protected final String TEXT_54 = "\",org.apache.avro.Schema.createUnion(unionSchema),null,null));";
  protected final String TEXT_55 = NL + "                org.apache.avro.Schema schema = org.apache.avro.Schema.createRecord(\"record\", null, null, false);" + NL + "                schema.setFields(fields);" + NL + "" + NL + "                //create file writer" + NL + "                org.apache.avro.io.DatumWriter<org.apache.avro.generic.GenericRecord> datumWriter = new org.apache.avro.generic.GenericDatumWriter<org.apache.avro.generic.GenericRecord>(schema);" + NL + "                org.apache.avro.file.DataFileWriter<org.apache.avro.generic.GenericRecord> writer = new org.apache.avro.file.DataFileWriter<org.apache.avro.generic.GenericRecord>(datumWriter);" + NL + "" + NL + "                //init writer" + NL + "                Path path = FileOutputFormat.getTaskOutputPath(job, name+EXT);" + NL + "                configureDataFileWriter(writer,job);" + NL + "                   writer.create(schema, path.getFileSystem(job).create(path));" + NL + "" + NL + "                   return new AvroRecordWriter(writer, job, schema);" + NL + "            }" + NL + "        }";
  protected final String TEXT_56 = NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
class AvroOutput{
    private String cid;
    private String rowStructName;
    private List<IMetadataColumn> columns;
    private boolean compress = false;
    private String compression;
    private Boolean useAvroMetadataTable = false;

    public AvroOutput(String cid, String rowStructName, List<IMetadataColumn> columns){
        this.cid = cid;
        this.rowStructName = rowStructName;
        this.columns = columns;
    }

    public AvroOutput(String cid, String rowStructName, List<IMetadataColumn> columns, Boolean useAvroMetadataTable) {
        this.cid = cid;
        this.rowStructName = rowStructName;
        this.columns = columns;
        this.useAvroMetadataTable = useAvroMetadataTable;
    }

    public void gen(){
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_6);
    
                    for(IMetadataColumn column : columns){
                        String columnName = column.getLabel();
                        JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                        String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                        boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
                        if(!isPrimitive){
                        
    stringBuffer.append(TEXT_7);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_8);
    
                        }
                        if(javaType == JavaTypesManager.BYTE) {
                        
    stringBuffer.append(TEXT_9);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_11);
    
                        } else if(javaType == JavaTypesManager.SHORT) {
                        
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_14);
    
                        } else if(javaType == JavaTypesManager.CHARACTER) {
                        
    stringBuffer.append(TEXT_15);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_17);
    
                        } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
                            if (useAvroMetadataTable) {
                            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_20);
    
                            } else {
                            
    stringBuffer.append(TEXT_21);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_23);
    
                            }
                        } else if(javaType == JavaTypesManager.OBJECT) {
                        
    stringBuffer.append(TEXT_24);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_26);
    
                        } else if(javaType == JavaTypesManager.BIGDECIMAL) {
                        
    stringBuffer.append(TEXT_27);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_29);
    
                        } else if(javaType == JavaTypesManager.DATE) {
                            
    stringBuffer.append(TEXT_30);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_32);
    
                        } else {
                        
    stringBuffer.append(TEXT_33);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_35);
    
                        }

                        if(!isPrimitive){
                        
    stringBuffer.append(TEXT_36);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_37);
    if(compress && "DEFLATE".equals(compression)){
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_40);
    
                java.util.Map<JavaType,String> talendTypeToAvroType = new java.util.HashMap<JavaType,String>();
                talendTypeToAvroType.put(JavaTypesManager.OBJECT,"STRING");
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
                    String columnName = column.getLabel();
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());

                    if(isPrimitive){
                    
    stringBuffer.append(TEXT_41);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(talendTypeToAvroType.get(javaType));
    stringBuffer.append(TEXT_43);
    
                    }else{
                    
    stringBuffer.append(TEXT_44);
    
                        if (talendTypeToAvroType.containsKey(javaType)) {
                            
    stringBuffer.append(TEXT_45);
    stringBuffer.append(talendTypeToAvroType.get(javaType));
    stringBuffer.append(TEXT_46);
    
                        } else if (javaType.getLabel().equals("List")){
                            
    stringBuffer.append(TEXT_47);
    
                            for (String type: new java.util.HashSet<String>(talendTypeToAvroType.values())) {
                                
    stringBuffer.append(TEXT_48);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_49);
    
                            }
                            
    stringBuffer.append(TEXT_50);
    
                        } else {
                            for (String type: new java.util.HashSet<String>(talendTypeToAvroType.values())) {
                                
    stringBuffer.append(TEXT_51);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_52);
    
                            }
                        }
                        
    stringBuffer.append(TEXT_53);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_54);
    
                    }
                }
                
    stringBuffer.append(TEXT_55);
    
    }
}

    stringBuffer.append(TEXT_56);
    
    BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();  
    String cid = node.getUniqueName();
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    IMetadataTable metadata = null;
    if(metadatas != null && metadatas.size() > 0){
        metadata = metadatas.get(0);
    }
	String connName = null;
	List<IMetadataColumn> columns = null;
    if(metadata != null){
		boolean compress = "true".equals(ElementParameterParser.getValue(node, "__COMPRESS__"));
		String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");
			
	    List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
		if(inConns != null && inConns.size() > 0){
		   	IConnection inConn = inConns.get(0); 
		    connName = inConn.getName();
		}
	    columns = metadata.getListColumns();
	} 
	String rowStructName = connName != null ? connName + "Struct" : null;
	if(rowStructName == null || columns == null){
		return "";
	}
	
	AvroOutput avroOutput = new AvroOutput(cid, rowStructName, columns);
	avroOutput.gen();  
	
    return stringBuffer.toString();
  }
}
