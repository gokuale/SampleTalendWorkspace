package org.talend.designer.codegen.translators.logs_errors;

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

public class TLogRowMrcodeJava
{
  protected static String nl;
  public static synchronized TLogRowMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLogRowMrcodeJava result = new TLogRowMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "        public static class ";
  protected final String TEXT_4 = "StructOutputFormat extends FileOutputFormat<NullWritable, ";
  protected final String TEXT_5 = ">{" + NL + "            protected static class AvroRecordWriter implements RecordWriter<NullWritable, ";
  protected final String TEXT_6 = ">{" + NL + "                org.apache.avro.file.DataFileWriter<org.apache.avro.generic.GenericRecord> writer = null;" + NL + "                private ContextProperties context;" + NL + "" + NL + "                private org.apache.avro.Schema schema = null;" + NL + "" + NL + "                public AvroRecordWriter(org.apache.avro.file.DataFileWriter<org.apache.avro.generic.GenericRecord> writer, JobConf job, org.apache.avro.Schema schema){" + NL + "                    this.context = new ContextProperties(job);" + NL + "                    this.writer = writer;" + NL + "                    this.schema = schema;" + NL + "                }" + NL + "" + NL + "                public void write(NullWritable key, ";
  protected final String TEXT_7 = " value) throws IOException{" + NL + "                    org.apache.avro.generic.GenericRecord record = new org.apache.avro.generic.GenericData.Record(schema);";
  protected final String TEXT_8 = NL + "                            if(value.";
  protected final String TEXT_9 = " != null){";
  protected final String TEXT_10 = NL + "                            record.put(\"";
  protected final String TEXT_11 = "\", ((Byte)(value.";
  protected final String TEXT_12 = ")).intValue());";
  protected final String TEXT_13 = NL + "                            record.put(\"";
  protected final String TEXT_14 = "\", ((Short)(value.";
  protected final String TEXT_15 = ")).intValue());";
  protected final String TEXT_16 = NL + "                            record.put(\"";
  protected final String TEXT_17 = "\", (int)(char)(Character)(value.";
  protected final String TEXT_18 = "));";
  protected final String TEXT_19 = NL + "                                record.put(\"";
  protected final String TEXT_20 = "\", value.";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "                                record.put(\"";
  protected final String TEXT_23 = "\", java.nio.ByteBuffer.wrap(value.";
  protected final String TEXT_24 = "));";
  protected final String TEXT_25 = NL + "                            record.put(\"";
  protected final String TEXT_26 = "\", value.";
  protected final String TEXT_27 = ".toString());";
  protected final String TEXT_28 = NL + "                            record.put(\"";
  protected final String TEXT_29 = "\", value.";
  protected final String TEXT_30 = ".toString());";
  protected final String TEXT_31 = NL + "                            record.put(\"";
  protected final String TEXT_32 = "\", value.";
  protected final String TEXT_33 = ".getTime());";
  protected final String TEXT_34 = NL + "                            record.put(\"";
  protected final String TEXT_35 = "\", value.";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "                            }";
  protected final String TEXT_38 = NL + "                     writer.append(record);" + NL + "                }" + NL + "" + NL + "                public void close(Reporter reporter) throws IOException{" + NL + "                    writer.close();" + NL + "                }" + NL + "            }" + NL + "" + NL + "              void configureDataFileWriter(org.apache.avro.file.DataFileWriter<org.apache.avro.generic.GenericRecord> writer, JobConf job) throws java.io.UnsupportedEncodingException{";
  protected final String TEXT_39 = NL + "                    int level = job.getInt(org.apache.avro.mapred.AvroOutputFormat.DEFLATE_LEVEL_KEY, org.apache.avro.mapred.AvroOutputFormat.DEFAULT_DEFLATE_LEVEL);" + NL + "                    org.apache.avro.file.CodecFactory factory = org.apache.avro.file.CodecFactory.deflateCodec(level);" + NL + "                    writer.setCodec(factory);";
  protected final String TEXT_40 = NL + NL + "                writer.setSyncInterval(job.getInt(org.apache.avro.mapred.AvroOutputFormat.SYNC_INTERVAL_KEY, org.apache.avro.file.DataFileConstants.DEFAULT_SYNC_INTERVAL));" + NL + "              }" + NL + "" + NL + "            public final static String EXT = \".avro\";" + NL + "" + NL + "            public RecordWriter<NullWritable, ";
  protected final String TEXT_41 = "> getRecordWriter(" + NL + "                    FileSystem ignored, JobConf job, String name, Progressable progress) throws IOException{" + NL + "                //set schema" + NL + "                List<org.apache.avro.Schema.Field> fields = new java.util.ArrayList<org.apache.avro.Schema.Field>();" + NL + "                List<org.apache.avro.Schema> unionSchema = null;" + NL + "                List<org.apache.avro.Schema> arraySchema = null;";
  protected final String TEXT_42 = NL + "                        fields.add(new org.apache.avro.Schema.Field(\"";
  protected final String TEXT_43 = "\",org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_44 = "),null,null));";
  protected final String TEXT_45 = NL + "                        unionSchema = new java.util.ArrayList<org.apache.avro.Schema>();";
  protected final String TEXT_46 = NL + "                            unionSchema.add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_47 = "));";
  protected final String TEXT_48 = NL + "                            arraySchema = new java.util.ArrayList<org.apache.avro.Schema>();";
  protected final String TEXT_49 = NL + "                                arraySchema.add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_50 = "));";
  protected final String TEXT_51 = NL + "                            arraySchema.add(org.apache.avro.Schema" + NL + "                                    .createArray(org.apache.avro.Schema" + NL + "                                            .createUnion(arraySchema)));" + NL + "                            unionSchema.add(org.apache.avro.Schema.createArray(" + NL + "                                    org.apache.avro.Schema.createUnion(arraySchema)));";
  protected final String TEXT_52 = NL + "                                unionSchema.add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_53 = "));";
  protected final String TEXT_54 = NL + NL + "                        unionSchema.add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.NULL));" + NL + "                        fields.add(new org.apache.avro.Schema.Field(\"";
  protected final String TEXT_55 = "\",org.apache.avro.Schema.createUnion(unionSchema),null,null));";
  protected final String TEXT_56 = NL + "                org.apache.avro.Schema schema = org.apache.avro.Schema.createRecord(\"record\", null, null, false);" + NL + "                schema.setFields(fields);" + NL + "" + NL + "                //create file writer" + NL + "                org.apache.avro.io.DatumWriter<org.apache.avro.generic.GenericRecord> datumWriter = new org.apache.avro.generic.GenericDatumWriter<org.apache.avro.generic.GenericRecord>(schema);" + NL + "                org.apache.avro.file.DataFileWriter<org.apache.avro.generic.GenericRecord> writer = new org.apache.avro.file.DataFileWriter<org.apache.avro.generic.GenericRecord>(datumWriter);" + NL + "" + NL + "                //init writer" + NL + "                Path path = FileOutputFormat.getTaskOutputPath(job, name+EXT);" + NL + "                configureDataFileWriter(writer,job);" + NL + "                   writer.create(schema, path.getFileSystem(job).create(path));" + NL + "" + NL + "                   return new AvroRecordWriter(writer, job, schema);" + NL + "            }" + NL + "        }";
  protected final String TEXT_57 = NL + "\t";
  protected final String TEXT_58 = NL + "\t";
  protected final String TEXT_59 = "    ";
  protected final String TEXT_60 = NL + "    ";
  protected final String TEXT_61 = NL + "        class Util_";
  protected final String TEXT_62 = " {" + NL + "" + NL + "        String[] des_top = { \".\", \".\", \"-\", \"+\" };" + NL + "" + NL + "        String[] des_head = { \"|=\", \"=|\", \"-\", \"+\" };" + NL + "" + NL + "        String[] des_bottom = { \"'\", \"'\", \"-\", \"+\" };" + NL + "" + NL + "        String name=\"\";" + NL + "" + NL + "        java.util.List<String[]> list = new java.util.ArrayList<String[]>();" + NL + "" + NL + "        int[] colLengths = new int[";
  protected final String TEXT_63 = "];" + NL + "" + NL + "        public void addRow(String[] row) {" + NL + "" + NL + "            for (int i = 0; i < ";
  protected final String TEXT_64 = "; i++) {" + NL + "                if (row[i]!=null) {" + NL + "                  colLengths[i] = Math.max(colLengths[i], row[i].length());" + NL + "                }" + NL + "            }" + NL + "            list.add(row);" + NL + "        }" + NL + "" + NL + "        public void setTableName(String name) {" + NL + "" + NL + "            this.name = name;" + NL + "        }" + NL + "" + NL + "            public StringBuilder format() {" + NL + "            " + NL + "                StringBuilder sb = new StringBuilder();" + NL + " ";
  protected final String TEXT_65 = " " + NL + "            " + NL + "                    sb.append(print(des_top));" + NL + "    " + NL + "                    int totals = 0;" + NL + "                    for (int i = 0; i < colLengths.length; i++) {" + NL + "                        totals = totals + colLengths[i];" + NL + "                    }" + NL + "    " + NL + "                    // name" + NL + "                    sb.append(\"|\");" + NL + "                    int k = 0;" + NL + "                    for (k = 0; k < (totals + ";
  protected final String TEXT_66 = " - name.length()) / 2; k++) {" + NL + "                        sb.append(' ');" + NL + "                    }" + NL + "                    sb.append(name);" + NL + "                    for (int i = 0; i < totals + ";
  protected final String TEXT_67 = " - name.length() - k; i++) {" + NL + "                        sb.append(' ');" + NL + "                    }" + NL + "                    sb.append(\"|\\n\");" + NL + "" + NL + "                    // head and rows" + NL + "                    sb.append(print(des_head));" + NL + "                    for (int i = 0; i < list.size(); i++) {" + NL + "    " + NL + "                        String[] row = list.get(i);" + NL + "    " + NL + "                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());" + NL + "                        " + NL + "                        StringBuilder sbformat = new StringBuilder();                                       ";
  protected final String TEXT_68 = "      " + NL + "                            sbformat.append(\"|%";
  protected final String TEXT_69 = "$-\");" + NL + "                            sbformat.append(colLengths[";
  protected final String TEXT_70 = "]);" + NL + "                            sbformat.append(\"s\");";
  protected final String TEXT_71 = "              " + NL + "                        sbformat.append(\"|\\n\");                    " + NL + "       " + NL + "                        formatter.format(sbformat.toString(), (Object[])row);   " + NL + "                                " + NL + "                        sb.append(formatter.toString());" + NL + "                        if (i == 0)" + NL + "                            sb.append(print(des_head)); // print the head" + NL + "                    }" + NL + "    " + NL + "                    // end" + NL + "                    sb.append(print(des_bottom));" + NL + "                    return sb;" + NL + "                }" + NL + "            " + NL + "" + NL + "            private StringBuilder print(String[] fillChars) {" + NL + "                StringBuilder sb = new StringBuilder();" + NL + "                //first column" + NL + "                sb.append(fillChars[0]);";
  protected final String TEXT_72 = "                " + NL + "                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }" + NL + "                    sb.append(fillChars[3]);";
  protected final String TEXT_73 = "                  " + NL;
  protected final String TEXT_74 = NL + "                    for (int i = 0; i < colLengths[";
  protected final String TEXT_75 = "] - fillChars[3].length() + 1; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }" + NL + "                    sb.append(fillChars[3]);";
  protected final String TEXT_76 = NL + "                ";
  protected final String TEXT_77 = "  " + NL + "                    //last column" + NL + "                    for (int i = 0; i < colLengths[";
  protected final String TEXT_78 = "] - fillChars[0].length() - fillChars[1].length()+2; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }";
  protected final String TEXT_79 = NL + "                    //last column" + NL + "                    for (int i = 0; i < colLengths[";
  protected final String TEXT_80 = "] - fillChars[1].length() + 1; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }";
  protected final String TEXT_81 = "         " + NL + "                sb.append(fillChars[1]);" + NL + "                sb.append(\"\\n\");";
  protected final String TEXT_82 = "               " + NL + "                return sb;" + NL + "            }" + NL + "        }";
  protected final String TEXT_83 = " " + NL + "        class Util_";
  protected final String TEXT_84 = " {" + NL + "        " + NL + "            String[] des_top = { \".\", \"-\" };" + NL + "    " + NL + "            String[] des_data = { \"-\", \"+\" };" + NL + "    " + NL + "            String[] des_frame = { \"|\" }; " + NL + "            " + NL + "            public void printLine(StringBuilder sb, int titleWidth, int dataWidth){" + NL + "            " + NL + "                sb.append(\"+\");" + NL + "                for(int i=0; i<titleWidth+2; i++)" + NL + "                    sb.append(\"-\");" + NL + "                sb.append(\"+\");" + NL + "                for(int i=0; i<dataWidth+2; i++)" + NL + "                    sb.append(\"-\");" + NL + "                sb.append(\"+\" + \"\\n\");" + NL + "            }      " + NL + "    " + NL + "            public String print(String[] row, int nbLine){" + NL + "                " + NL + "                StringBuilder sb = new StringBuilder();";
  protected final String TEXT_85 = NL + "                    String title = \"#\" + nbLine + \". \" + \"";
  protected final String TEXT_86 = "\";";
  protected final String TEXT_87 = NL + "                    String title = \"#\" + nbLine + \". \" + \"";
  protected final String TEXT_88 = "\";";
  protected final String TEXT_89 = NL + "                    String title = \"#\" + nbLine + \". \" + \"";
  protected final String TEXT_90 = "--";
  protected final String TEXT_91 = "\";";
  protected final String TEXT_92 = NL + "            " + NL + "                //step 1: get the max length of all the row[] member;" + NL + "                int dataWidth = 5;      //the length of the string \"value\"  " + NL + "                for(int i=0;i<row.length;i++) {" + NL + "                    if(row[i] == null && 4 > dataWidth) {" + NL + "                        dataWidth = 4;" + NL + "                    }" + NL + "                    else if(row[i] != null && row[i].length()>dataWidth) " + NL + "                        dataWidth = row[i].length();" + NL + "                }           ";
  protected final String TEXT_93 = "          " + NL + "                int titleWidth = ";
  protected final String TEXT_94 = ";" + NL + "                " + NL + "                int totalWidth = dataWidth + titleWidth + 5;" + NL + "                " + NL + "                //step 2: print the header with line number" + NL + "                sb.append(\".\");" + NL + "                for(int i=0 ; i<totalWidth ; i++)" + NL + "                    sb.append(\"-\");         " + NL + "                sb.append(\".\" + \"\\n\" + \"|\");" + NL + "                " + NL + "                int emptyCenterWidth = (totalWidth-title.length())/2;" + NL + "                for(int i=0 ; i<emptyCenterWidth; i++)" + NL + "                    sb.append(\" \"); " + NL + "                sb.append(title);" + NL + "                for(int i=0 ; i<totalWidth - emptyCenterWidth - title.length() ; i++)" + NL + "                    sb.append(\" \"); " + NL + "                sb.append(\"|\" + \"\\n\");" + NL + "                " + NL + "                //step 3: print \"key\" and \"value\"           " + NL + "                printLine(sb,titleWidth,dataWidth);" + NL + "                " + NL + "                sb.append(\"|\" + \" key\");" + NL + "                for(int i=0; i<titleWidth-2; i++)" + NL + "                    sb.append(\" \");" + NL + "                sb.append(\"|\" + \" value\");" + NL + "                for(int i=0; i<dataWidth-4; i++)" + NL + "                    sb.append(\" \");" + NL + "                sb.append(\"|\" + \"\\n\");" + NL + "                " + NL + "                printLine(sb,titleWidth,dataWidth);" + NL + "                " + NL + "                //step 4: print dataset";
  protected final String TEXT_95 = NL + "                //for(int i=0; i<row.length; i++){" + NL + "                    sb.append(\"| \" + \"";
  protected final String TEXT_96 = "\");" + NL + "                    for(int i=0; i<titleWidth -\"";
  protected final String TEXT_97 = "\".length()+ 1 ;i++)" + NL + "                        sb.append(\" \");" + NL + "                    sb.append(\"| \" + row[";
  protected final String TEXT_98 = "]);" + NL + "                    for(int i=0; row[";
  protected final String TEXT_99 = "] == null && i<dataWidth - 3 || row[";
  protected final String TEXT_100 = "] != null && i<dataWidth -row[";
  protected final String TEXT_101 = "].length()+ 1 ;i++)" + NL + "                        sb.append(\" \");" + NL + "                    sb.append(\"|\" + \"\\n\");" + NL + "                " + NL + "                //}" + NL + "    ";
  protected final String TEXT_102 = NL + "                //step 5: print a line gap" + NL + "                printLine(sb,titleWidth,dataWidth);" + NL + "                return sb.toString();" + NL + "            }" + NL + "        }";
  protected final String TEXT_103 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
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
    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_7);
    
                    for(IMetadataColumn column : columns){
                        String columnName = column.getLabel();
                        JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                        String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                        boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
                        if(!isPrimitive){
                        
    stringBuffer.append(TEXT_8);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_9);
    
                        }
                        if(javaType == JavaTypesManager.BYTE) {
                        
    stringBuffer.append(TEXT_10);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_12);
    
                        } else if(javaType == JavaTypesManager.SHORT) {
                        
    stringBuffer.append(TEXT_13);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_15);
    
                        } else if(javaType == JavaTypesManager.CHARACTER) {
                        
    stringBuffer.append(TEXT_16);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_18);
    
                        } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
                            if (useAvroMetadataTable) {
                            
    stringBuffer.append(TEXT_19);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_21);
    
                            } else {
                            
    stringBuffer.append(TEXT_22);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_24);
    
                            }
                        } else if(javaType == JavaTypesManager.OBJECT) {
                        
    stringBuffer.append(TEXT_25);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_27);
    
                        } else if(javaType == JavaTypesManager.BIGDECIMAL) {
                        
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_30);
    
                        } else if(javaType == JavaTypesManager.DATE) {
                            
    stringBuffer.append(TEXT_31);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_33);
    
                        } else {
                        
    stringBuffer.append(TEXT_34);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_36);
    
                        }

                        if(!isPrimitive){
                        
    stringBuffer.append(TEXT_37);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_38);
    if(compress && "DEFLATE".equals(compression)){
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_41);
    
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
                    
    stringBuffer.append(TEXT_42);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(talendTypeToAvroType.get(javaType));
    stringBuffer.append(TEXT_44);
    
                    }else{
                    
    stringBuffer.append(TEXT_45);
    
                        if (talendTypeToAvroType.containsKey(javaType)) {
                            
    stringBuffer.append(TEXT_46);
    stringBuffer.append(talendTypeToAvroType.get(javaType));
    stringBuffer.append(TEXT_47);
    
                        } else if (javaType.getLabel().equals("List")){
                            
    stringBuffer.append(TEXT_48);
    
                            for (String type: new java.util.HashSet<String>(talendTypeToAvroType.values())) {
                                
    stringBuffer.append(TEXT_49);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_50);
    
                            }
                            
    stringBuffer.append(TEXT_51);
    
                        } else {
                            for (String type: new java.util.HashSet<String>(talendTypeToAvroType.values())) {
                                
    stringBuffer.append(TEXT_52);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_53);
    
                            }
                        }
                        
    stringBuffer.append(TEXT_54);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_55);
    
                    }
                }
                
    stringBuffer.append(TEXT_56);
    
    }
}

    stringBuffer.append(TEXT_57);
    
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
	
    stringBuffer.append(TEXT_58);
    stringBuffer.append(TEXT_59);
    
    String label = ElementParameterParser.getValue(node, "__LABEL__");
    if(("__UNIQUE_NAME__").equals(label))
        label=cid;
    boolean tablePrint = ("true").equals(ElementParameterParser.getValue(node,"__TABLE_PRINT__"));
    String printHeader = ElementParameterParser.getValue(node,"__PRINT_HEADER__");
    boolean vertical = ("true").equals(ElementParameterParser.getValue(node,"__VERTICAL__"));
    boolean uniquePrint = ("true").equals(ElementParameterParser.getValue(node,"__PRINT_UNIQUE__"));
    boolean titlePrint = ("true").equals(ElementParameterParser.getValue(node,"__PRINT_LABEL__"));
    boolean uniqueTitlePrint = ("true").equals(ElementParameterParser.getValue(node,"__PRINT_UNIQUE_LABEL__"));
    boolean basic = !(tablePrint||vertical);
    
    int sizeColumns = columns.size();
    
    stringBuffer.append(TEXT_60);
    
    if(tablePrint) { // table display mode
        
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_64);
     
                if (sizeColumns > 0) { //more than one column
                
    stringBuffer.append(TEXT_65);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_67);
    
                        for ( int i = 0; i < sizeColumns; i++) {
                            
    stringBuffer.append(TEXT_68);
    stringBuffer.append(i+1 );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_70);
    
                        }
                        
    stringBuffer.append(TEXT_71);
     
                if (sizeColumns > 1) { 
                    
    stringBuffer.append(TEXT_72);
    
                }
                
    stringBuffer.append(TEXT_73);
    
                for(int i = 0; i< sizeColumns-2;i++) {
                    
    stringBuffer.append(TEXT_74);
    stringBuffer.append(i+1 );
    stringBuffer.append(TEXT_75);
    
                }
                
    stringBuffer.append(TEXT_76);
     
                if (sizeColumns == 1) { 
                    
    stringBuffer.append(TEXT_77);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_78);
     
                } else if (sizeColumns > 1){
                    
    stringBuffer.append(TEXT_79);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_80);
    
                }
                
    stringBuffer.append(TEXT_81);
     
            } 
            
    stringBuffer.append(TEXT_82);
    
    }
    if(vertical) { 
    
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    
                if(uniquePrint) {
                    
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
                } else if(titlePrint) {
                    
    stringBuffer.append(TEXT_87);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_88);
    
                } else if(uniqueTitlePrint) {
                    
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_91);
    
                }
                
    stringBuffer.append(TEXT_92);
    
                int titleWidth = 3;    //the length of the string 'key'
                for(IMetadataColumn column:columns)
                    if(column.getLabel().length()>titleWidth) titleWidth = column.getLabel().length();
                
    stringBuffer.append(TEXT_93);
    stringBuffer.append(titleWidth);
    stringBuffer.append(TEXT_94);
    
                int count = 0;
                for(IMetadataColumn column:columns){
                
    stringBuffer.append(TEXT_95);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_101);
    
                    count++;
                }
    stringBuffer.append(TEXT_102);
    
    }
    
    stringBuffer.append(TEXT_103);
    return stringBuffer.toString();
  }
}
