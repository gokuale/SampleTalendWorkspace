package org.talend.designer.codegen.translators.misc;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TRowGeneratorSparkcodeJava
{
  protected static String nl;
  public static synchronized TRowGeneratorSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRowGeneratorSparkcodeJava result = new TRowGeneratorSparkcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        public static class ";
  protected final String TEXT_2 = "InputFormat extends FileInputFormat<NullWritable, ";
  protected final String TEXT_3 = "> {" + NL + "            private ContextProperties context;" + NL + "" + NL + "            public final static String EXT = \".avro\";" + NL;
  protected final String TEXT_4 = NL + "            private boolean ignoreInputPath = false;" + NL + "" + NL + "            protected boolean isIgnoreInputPath() {" + NL + "                return ignoreInputPath;" + NL + "            }" + NL + "" + NL + "            protected void setIgnoreInputPath(boolean ignoreInputPath) {" + NL + "                this.ignoreInputPath = ignoreInputPath;" + NL + "            }" + NL + NL;
  protected final String TEXT_5 = NL + NL + "            protected org.apache.hadoop.fs.FileStatus[] listStatus(JobConf conf) throws IOException {" + NL + "                List<org.apache.hadoop.fs.FileStatus> result = new java.util.ArrayList<org.apache.hadoop.fs.FileStatus>();" + NL + "                for (org.apache.hadoop.fs.FileStatus file : super.listStatus(conf)) {" + NL + "                      if (file.getPath().getName().endsWith(EXT)) {" + NL + "                        result.add(file);" + NL + "                    }" + NL + "                }" + NL + "                return result.toArray(new org.apache.hadoop.fs.FileStatus[0]);" + NL + "              }" + NL + "" + NL + "            public InputSplit[] getSplits(JobConf job, int numSplits)" + NL + "                    throws IOException {";
  protected final String TEXT_6 = NL + "                    if(!isIgnoreInputPath()){" + NL + "                        context = new ContextProperties(job);" + NL + "                        job.set(\"mapred.input.dir\", ";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "                            FileSystem fs = FileSystem.get(job);" + NL + "                            Path inputDir = new Path(";
  protected final String TEXT_9 = ");" + NL + "                            if (!fs.exists(inputDir)) {" + NL + "                                return new InputSplit[0];" + NL + "                            }";
  protected final String TEXT_10 = NL + "                    }";
  protected final String TEXT_11 = NL + "                return super.getSplits(job, numSplits);" + NL + "            }" + NL + "" + NL + "            public RecordReader<NullWritable, ";
  protected final String TEXT_12 = "> getRecordReader(" + NL + "                    InputSplit split, JobConf job, Reporter reporter)" + NL + "                    throws IOException {" + NL + "                return new AvroRecordReader(job, (FileSplit) split);" + NL + "            }" + NL + "" + NL + "            protected static class AvroRecordReader implements" + NL + "                RecordReader<NullWritable, ";
  protected final String TEXT_13 = "> {" + NL + "" + NL + "                private ContextProperties context;" + NL + "" + NL + "                private org.apache.avro.file.FileReader<org.apache.avro.generic.GenericRecord> reader;" + NL + "                  private long start;" + NL + "                  private long end;" + NL + "" + NL + "                  org.apache.avro.generic.GenericRecord record = null;" + NL + "" + NL + "                protected AvroRecordReader(JobConf job, FileSplit split)" + NL + "                        throws IOException {" + NL + "                    this.context = new ContextProperties(job);" + NL + "" + NL + "                    //set schema" + NL + "                    List<org.apache.avro.Schema.Field> fields = new java.util.ArrayList<org.apache.avro.Schema.Field>();" + NL + "                    List<org.apache.avro.Schema> unionSchema = null;";
  protected final String TEXT_14 = NL + "                            fields.add(new org.apache.avro.Schema.Field(\"";
  protected final String TEXT_15 = "\",org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_16 = "),null,null));";
  protected final String TEXT_17 = NL + "                            unionSchema = new java.util.ArrayList<org.apache.avro.Schema>();" + NL + "                            unionSchema.add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_18 = "));" + NL + "                            unionSchema.add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.NULL));" + NL + "                            fields.add(new org.apache.avro.Schema.Field(\"";
  protected final String TEXT_19 = "\",org.apache.avro.Schema.createUnion(unionSchema),null,null));";
  protected final String TEXT_20 = NL + "                    org.apache.avro.Schema schema = org.apache.avro.Schema.createRecord(fields);" + NL + "" + NL + "                    //create file reader" + NL + "                    org.apache.avro.io.DatumReader<org.apache.avro.generic.GenericRecord> datumReader = new org.apache.avro.generic.GenericDatumReader<org.apache.avro.generic.GenericRecord>(schema);" + NL + "                    reader = org.apache.avro.file.DataFileReader.openReader(new org.apache.avro.mapred.FsInput(split.getPath(),job),datumReader);" + NL + "" + NL + "                    //sync to start" + NL + "                    reader.sync(split.getStart());" + NL + "                    this.start = reader.tell();" + NL + "                    this.end = split.getStart() + split.getLength();" + NL + "" + NL + "                    record = new org.apache.avro.generic.GenericData.Record(schema);" + NL + "                }" + NL + "" + NL + "                public boolean next(NullWritable key, ";
  protected final String TEXT_21 = " value) throws IOException {" + NL + "                    if (!reader.hasNext() || reader.pastSync(end)) {" + NL + "                        return false;" + NL + "                    }" + NL + "                    record = reader.next(record);" + NL + "" + NL + "                    Object columnObject = null;" + NL;
  protected final String TEXT_22 = NL + "                        columnObject = record.get(\"";
  protected final String TEXT_23 = "\");" + NL + "                        if(columnObject != null) {";
  protected final String TEXT_24 = NL + "                                value.";
  protected final String TEXT_25 = " = columnObject.toString();";
  protected final String TEXT_26 = NL + "                                value.";
  protected final String TEXT_27 = " = ((Integer)columnObject).byteValue();";
  protected final String TEXT_28 = NL + "                                value.";
  protected final String TEXT_29 = " = ((Integer)columnObject).shortValue();";
  protected final String TEXT_30 = NL + "                                value.";
  protected final String TEXT_31 = " = (Character)(char)(int)(Integer)columnObject;";
  protected final String TEXT_32 = NL + "                                    value.";
  protected final String TEXT_33 = " = ((java.nio.ByteBuffer)columnObject);";
  protected final String TEXT_34 = NL + "                                    value.";
  protected final String TEXT_35 = " = ((java.nio.ByteBuffer)columnObject).array();";
  protected final String TEXT_36 = NL + "                                value.";
  protected final String TEXT_37 = " = new java.math.BigDecimal(columnObject.toString());";
  protected final String TEXT_38 = NL + "                                value.";
  protected final String TEXT_39 = " = new java.util.Date((Long)columnObject);";
  protected final String TEXT_40 = NL + "                                value.";
  protected final String TEXT_41 = " = (";
  protected final String TEXT_42 = ")columnObject;";
  protected final String TEXT_43 = NL + "                                } else {" + NL + "                                    value.";
  protected final String TEXT_44 = " = ";
  protected final String TEXT_45 = ";";
  protected final String TEXT_46 = NL + "                        }";
  protected final String TEXT_47 = NL + "                    return true;" + NL + "                  }" + NL + "" + NL + "                public NullWritable createKey(){" + NL + "                    return NullWritable.get();" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_48 = " createValue(){" + NL + "                    return new ";
  protected final String TEXT_49 = "();" + NL + "                }" + NL + "" + NL + "                public long getPos() throws IOException{" + NL + "                    return reader.tell();" + NL + "                  }" + NL + "" + NL + "                public void close() throws IOException{" + NL + "                    if(reader != null){" + NL + "                        reader.close();" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                public float getProgress() throws IOException {" + NL + "                    if (start == end) {" + NL + "                        return 0.0f;" + NL + "                    } else {" + NL + "                        return Math.min(1.0f, (getPos() - start) / (float) (end - start));" + NL + "                    }" + NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_50 = NL + "\t\tpublic static void addInputPath(JobConf job, String path){" + NL + "\t\t\tjob.set(\"talend.component.tRowGenerator.";
  protected final String TEXT_51 = "\", path);" + NL + "\t\t}" + NL + "\t\tpublic String getInputPath(JobConf job){" + NL + "\t\t\treturn job.get(\"talend.component.tRowGenerator.";
  protected final String TEXT_52 = "\");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_53 = NL + NL + "public static class IdentityMap_";
  protected final String TEXT_54 = " implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<NullWritable, ";
  protected final String TEXT_55 = ">, NullWritable, ";
  protected final String TEXT_56 = "> {" + NL + "" + NL + "        private ContextProperties context = null;" + NL + "        private java.util.List<org.apache.avro.Schema.Field> fieldsList;" + NL + "" + NL + "        public IdentityMap_";
  protected final String TEXT_57 = "(JobConf job) {" + NL + "            this.context = new ContextProperties(job);" + NL + "        }" + NL + "" + NL + "        public scala.Tuple2<NullWritable, ";
  protected final String TEXT_58 = "> call(scala.Tuple2<NullWritable, ";
  protected final String TEXT_59 = "> data) throws java.lang.Exception {" + NL + "" + NL + "            if(fieldsList == null){" + NL + "                this.fieldsList = (new ";
  protected final String TEXT_60 = "()).getSchema().getFields();" + NL + "            }" + NL;
  protected final String TEXT_61 = NL + "            ";
  protected final String TEXT_62 = " value = new ";
  protected final String TEXT_63 = "();" + NL + "" + NL + "            for(org.apache.avro.Schema.Field field : fieldsList){" + NL + "                value.put(field.pos(), data._2().get(field.pos()));" + NL + "            }" + NL + "" + NL + "\t\t\treturn new scala.Tuple2<NullWritable, ";
  protected final String TEXT_64 = ">(NullWritable.get(), value);" + NL + "        }" + NL + "" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
class AvroInput{
    private String inputFormatName;
    private String rowStructName;
    private List<IMetadataColumn> columns;
    private String folder;
    private boolean isSpark = false;

    /** Forces the creation of the input dir if it doesn't exist. */
    private boolean createInputDirIfNotExists = false;
    public AvroInput(String rowStructName, List<IMetadataColumn> columns, String folder){
        this.rowStructName = rowStructName;
        this.inputFormatName = rowStructName;
        this.columns = columns;
        this.folder = folder;
    }

    public AvroInput(String inputFormatName, String rowStructName, List<IMetadataColumn> columns, String folder){
        this.rowStructName = rowStructName;
        this.inputFormatName = inputFormatName;
        this.columns = columns;
        this.folder = folder;
    }


    public AvroInput(String inputFormatName, String rowStructName, List<IMetadataColumn> columns, String folder, boolean isSpark){
        this.rowStructName = rowStructName;
        this.inputFormatName = inputFormatName;
        this.columns = columns;
        this.folder = folder;
        this.isSpark = isSpark;
    }

    
    /**
     * In some cases, we do not want to fail the job if the input directory does
     * not exist, but to treat it as a valid (but empty) input.
     */
    public void setCreateInputDirIfNotExists(boolean createInputDirIfNotExists) {
        this.createInputDirIfNotExists = createInputDirIfNotExists;
    }

    public void extendMethods(){
    }

    public void gen(){
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(inputFormatName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_3);
    
            // If a specific folder has been specified, it should normally be
            // set as the only input dir for this input format during
            // getSplits().  The setOverrideInputDir() can be used in a
            // generated job to change this behaviour (such as when the inputs
            // have been copied to the DistributedCache).
            
    stringBuffer.append(TEXT_4);
    extendMethods();
    stringBuffer.append(TEXT_5);
     if (folder != null) { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_7);
     if (createInputDirIfNotExists) { 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_9);
     } 
    stringBuffer.append(TEXT_10);
     } 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_13);
    
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
                        
    stringBuffer.append(TEXT_14);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(talendTypeToAvroType.get(javaType));
    stringBuffer.append(TEXT_16);
    
                        } else {
                        
    stringBuffer.append(TEXT_17);
    stringBuffer.append(talendTypeToAvroType.get(javaType));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_19);
    
                            }
                    }
                    
    stringBuffer.append(TEXT_20);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_21);
    
                    for(IMetadataColumn column : columns){
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                        String objectTypeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), true);
                        JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                        String columnName = column.getLabel();
                        String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
                        
    stringBuffer.append(TEXT_22);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_23);
    if(javaType == JavaTypesManager.STRING) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_25);
    } else if(javaType == JavaTypesManager.BYTE) {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_27);
    } else if(javaType == JavaTypesManager.SHORT) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_29);
    } else if(javaType == JavaTypesManager.CHARACTER) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_31);
    } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
    if (isSpark) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_33);
    } else {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_35);
    }
    } else if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_37);
    } else if(javaType == JavaTypesManager.DATE) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_39);
    } else {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(objectTypeToGenerate);
    stringBuffer.append(TEXT_42);
    }
    if(defaultValue!=null && defaultValue.length()>0){
    stringBuffer.append(TEXT_43);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    
                    }
                    
    stringBuffer.append(TEXT_47);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_49);
    
    }
}

    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
final String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();

IMetadataTable metadata = null;
if((metadatas!=null) && (metadatas.size() > 0)){
    metadata = metadatas.get(0);
}
String connName = null;
String connTypeName = null;
List<IMetadataColumn> columns = null;
if(metadata != null){
	List<? extends IConnection> conns = node.getOutgoingSortedConnections();
	if(conns != null){
		if(conns.size()>0){
			IConnection conn = conns.get(0);
			connName = conn.getName();
			connTypeName = codeGenArgument.getRecordStructName(conn);
			if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
				columns = metadata.getListColumns();
			}					
		}
	}		
}
if(metadata == null || connName == null || columns == null){
	return "";
}

class RowGeneratorInput extends AvroInput{
	public RowGeneratorInput(String inputFormatName, String rowStructName, List<IMetadataColumn> columns, String folder, boolean isSpark){
		super(inputFormatName, rowStructName, columns, folder, isSpark);
	}
	public void extendMethods(){
	
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    	
	}
}

boolean isSpark = ("SPARKSTREAMING".equals(node.getComponent().getType()) || "SPARK".equals(node.getComponent().getType()));
RowGeneratorInput avroInput = new RowGeneratorInput(connName + "Struct", connTypeName, columns, "getInputPath(job)", isSpark);
avroInput.gen();

    
    //Note: Because Hadoop's RecordReader class re-uses the same Writable object for each record, directly caching the returned RDD or directly passing it to an aggregation or shuffle operation will create many references to the same object. If you plan to directly cache, sort, or aggregate Hadoop writable objects, you should first copy them using a map function.

	// Uses Avro builder to copy the incoming record into a new record.
    // TODO: a Better way to copy the records. Ditch Avro builder.

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_64);
    return stringBuffer.toString();
  }
}
