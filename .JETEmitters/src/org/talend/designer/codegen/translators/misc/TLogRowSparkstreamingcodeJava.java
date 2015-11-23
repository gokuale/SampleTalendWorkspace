package org.talend.designer.codegen.translators.misc;

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

public class TLogRowSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TLogRowSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLogRowSparkstreamingcodeJava result = new TLogRowSparkstreamingcodeJava();
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
  protected final String TEXT_56 = NL;
  protected final String TEXT_57 = "    ";
  protected final String TEXT_58 = NL + "    ";
  protected final String TEXT_59 = NL + "        class Util_";
  protected final String TEXT_60 = " {" + NL + "" + NL + "        String[] des_top = { \".\", \".\", \"-\", \"+\" };" + NL + "" + NL + "        String[] des_head = { \"|=\", \"=|\", \"-\", \"+\" };" + NL + "" + NL + "        String[] des_bottom = { \"'\", \"'\", \"-\", \"+\" };" + NL + "" + NL + "        String name=\"\";" + NL + "" + NL + "        java.util.List<String[]> list = new java.util.ArrayList<String[]>();" + NL + "" + NL + "        int[] colLengths = new int[";
  protected final String TEXT_61 = "];" + NL + "" + NL + "        public void addRow(String[] row) {" + NL + "" + NL + "            for (int i = 0; i < ";
  protected final String TEXT_62 = "; i++) {" + NL + "                if (row[i]!=null) {" + NL + "                  colLengths[i] = Math.max(colLengths[i], row[i].length());" + NL + "                }" + NL + "            }" + NL + "            list.add(row);" + NL + "        }" + NL + "" + NL + "        public void setTableName(String name) {" + NL + "" + NL + "            this.name = name;" + NL + "        }" + NL + "" + NL + "            public StringBuilder format() {" + NL + "            " + NL + "                StringBuilder sb = new StringBuilder();" + NL + " ";
  protected final String TEXT_63 = " " + NL + "            " + NL + "                    sb.append(print(des_top));" + NL + "    " + NL + "                    int totals = 0;" + NL + "                    for (int i = 0; i < colLengths.length; i++) {" + NL + "                        totals = totals + colLengths[i];" + NL + "                    }" + NL + "    " + NL + "                    // name" + NL + "                    sb.append(\"|\");" + NL + "                    int k = 0;" + NL + "                    for (k = 0; k < (totals + ";
  protected final String TEXT_64 = " - name.length()) / 2; k++) {" + NL + "                        sb.append(' ');" + NL + "                    }" + NL + "                    sb.append(name);" + NL + "                    for (int i = 0; i < totals + ";
  protected final String TEXT_65 = " - name.length() - k; i++) {" + NL + "                        sb.append(' ');" + NL + "                    }" + NL + "                    sb.append(\"|\\n\");" + NL + "" + NL + "                    // head and rows" + NL + "                    sb.append(print(des_head));" + NL + "                    for (int i = 0; i < list.size(); i++) {" + NL + "    " + NL + "                        String[] row = list.get(i);" + NL + "    " + NL + "                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());" + NL + "                        " + NL + "                        StringBuilder sbformat = new StringBuilder();                                       ";
  protected final String TEXT_66 = "      " + NL + "                            sbformat.append(\"|%";
  protected final String TEXT_67 = "$-\");" + NL + "                            sbformat.append(colLengths[";
  protected final String TEXT_68 = "]);" + NL + "                            sbformat.append(\"s\");";
  protected final String TEXT_69 = "              " + NL + "                        sbformat.append(\"|\\n\");                    " + NL + "       " + NL + "                        formatter.format(sbformat.toString(), (Object[])row);   " + NL + "                                " + NL + "                        sb.append(formatter.toString());" + NL + "                        if (i == 0)" + NL + "                            sb.append(print(des_head)); // print the head" + NL + "                    }" + NL + "    " + NL + "                    // end" + NL + "                    sb.append(print(des_bottom));" + NL + "                    return sb;" + NL + "                }" + NL + "            " + NL + "" + NL + "            private StringBuilder print(String[] fillChars) {" + NL + "                StringBuilder sb = new StringBuilder();" + NL + "                //first column" + NL + "                sb.append(fillChars[0]);";
  protected final String TEXT_70 = "                " + NL + "                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }" + NL + "                    sb.append(fillChars[3]);";
  protected final String TEXT_71 = "                  " + NL;
  protected final String TEXT_72 = NL + "                    for (int i = 0; i < colLengths[";
  protected final String TEXT_73 = "] - fillChars[3].length() + 1; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }" + NL + "                    sb.append(fillChars[3]);";
  protected final String TEXT_74 = NL + "                ";
  protected final String TEXT_75 = "  " + NL + "                    //last column" + NL + "                    for (int i = 0; i < colLengths[";
  protected final String TEXT_76 = "] - fillChars[0].length() - fillChars[1].length()+2; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }";
  protected final String TEXT_77 = NL + "                    //last column" + NL + "                    for (int i = 0; i < colLengths[";
  protected final String TEXT_78 = "] - fillChars[1].length() + 1; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }";
  protected final String TEXT_79 = "         " + NL + "                sb.append(fillChars[1]);" + NL + "                sb.append(\"\\n\");";
  protected final String TEXT_80 = "               " + NL + "                return sb;" + NL + "            }" + NL + "        }";
  protected final String TEXT_81 = " " + NL + "        class Util_";
  protected final String TEXT_82 = " {" + NL + "        " + NL + "            String[] des_top = { \".\", \"-\" };" + NL + "    " + NL + "            String[] des_data = { \"-\", \"+\" };" + NL + "    " + NL + "            String[] des_frame = { \"|\" }; " + NL + "            " + NL + "            public void printLine(StringBuilder sb, int titleWidth, int dataWidth){" + NL + "            " + NL + "                sb.append(\"+\");" + NL + "                for(int i=0; i<titleWidth+2; i++)" + NL + "                    sb.append(\"-\");" + NL + "                sb.append(\"+\");" + NL + "                for(int i=0; i<dataWidth+2; i++)" + NL + "                    sb.append(\"-\");" + NL + "                sb.append(\"+\" + \"\\n\");" + NL + "            }      " + NL + "    " + NL + "            public String print(String[] row, int nbLine){" + NL + "                " + NL + "                StringBuilder sb = new StringBuilder();";
  protected final String TEXT_83 = NL + "                    String title = \"#\" + nbLine + \". \" + \"";
  protected final String TEXT_84 = "\";";
  protected final String TEXT_85 = NL + "                    String title = \"#\" + nbLine + \". \" + \"";
  protected final String TEXT_86 = "\";";
  protected final String TEXT_87 = NL + "                    String title = \"#\" + nbLine + \". \" + \"";
  protected final String TEXT_88 = "--";
  protected final String TEXT_89 = "\";";
  protected final String TEXT_90 = NL + "            " + NL + "                //step 1: get the max length of all the row[] member;" + NL + "                int dataWidth = 5;      //the length of the string \"value\"  " + NL + "                for(int i=0;i<row.length;i++) {" + NL + "                    if(row[i] == null && 4 > dataWidth) {" + NL + "                        dataWidth = 4;" + NL + "                    }" + NL + "                    else if(row[i] != null && row[i].length()>dataWidth) " + NL + "                        dataWidth = row[i].length();" + NL + "                }           ";
  protected final String TEXT_91 = "          " + NL + "                int titleWidth = ";
  protected final String TEXT_92 = ";" + NL + "                " + NL + "                int totalWidth = dataWidth + titleWidth + 5;" + NL + "                " + NL + "                //step 2: print the header with line number" + NL + "                sb.append(\".\");" + NL + "                for(int i=0 ; i<totalWidth ; i++)" + NL + "                    sb.append(\"-\");         " + NL + "                sb.append(\".\" + \"\\n\" + \"|\");" + NL + "                " + NL + "                int emptyCenterWidth = (totalWidth-title.length())/2;" + NL + "                for(int i=0 ; i<emptyCenterWidth; i++)" + NL + "                    sb.append(\" \"); " + NL + "                sb.append(title);" + NL + "                for(int i=0 ; i<totalWidth - emptyCenterWidth - title.length() ; i++)" + NL + "                    sb.append(\" \"); " + NL + "                sb.append(\"|\" + \"\\n\");" + NL + "                " + NL + "                //step 3: print \"key\" and \"value\"           " + NL + "                printLine(sb,titleWidth,dataWidth);" + NL + "                " + NL + "                sb.append(\"|\" + \" key\");" + NL + "                for(int i=0; i<titleWidth-2; i++)" + NL + "                    sb.append(\" \");" + NL + "                sb.append(\"|\" + \" value\");" + NL + "                for(int i=0; i<dataWidth-4; i++)" + NL + "                    sb.append(\" \");" + NL + "                sb.append(\"|\" + \"\\n\");" + NL + "                " + NL + "                printLine(sb,titleWidth,dataWidth);" + NL + "                " + NL + "                //step 4: print dataset";
  protected final String TEXT_93 = NL + "                //for(int i=0; i<row.length; i++){" + NL + "                    sb.append(\"| \" + \"";
  protected final String TEXT_94 = "\");" + NL + "                    for(int i=0; i<titleWidth -\"";
  protected final String TEXT_95 = "\".length()+ 1 ;i++)" + NL + "                        sb.append(\" \");" + NL + "                    sb.append(\"| \" + row[";
  protected final String TEXT_96 = "]);" + NL + "                    for(int i=0; row[";
  protected final String TEXT_97 = "] == null && i<dataWidth - 3 || row[";
  protected final String TEXT_98 = "] != null && i<dataWidth -row[";
  protected final String TEXT_99 = "].length()+ 1 ;i++)" + NL + "                        sb.append(\" \");" + NL + "                    sb.append(\"|\" + \"\\n\");" + NL + "                " + NL + "                //}" + NL + "    ";
  protected final String TEXT_100 = NL + "                //step 5: print a line gap" + NL + "                printLine(sb,titleWidth,dataWidth);" + NL + "                return sb.toString();" + NL + "            }" + NL + "        }";
  protected final String TEXT_101 = NL;
  protected final String TEXT_102 = NL + "   ";
  protected final String TEXT_103 = "    ";
  protected final String TEXT_104 = NL + "    ";
  protected final String TEXT_105 = NL + "        public static class Util_";
  protected final String TEXT_106 = " {" + NL + "" + NL + "        String[] des_top = { \".\", \".\", \"-\", \"+\" };" + NL + "" + NL + "        String[] des_head = { \"|=\", \"=|\", \"-\", \"+\" };" + NL + "" + NL + "        String[] des_bottom = { \"'\", \"'\", \"-\", \"+\" };" + NL + "" + NL + "        String name=\"\";" + NL + "" + NL + "        java.util.List<String[]> list = new java.util.ArrayList<String[]>();" + NL + "" + NL + "        int[] colLengths = new int[";
  protected final String TEXT_107 = "];" + NL + "" + NL + "        public void addRow(String[] row) {" + NL + "" + NL + "            for (int i = 0; i < ";
  protected final String TEXT_108 = "; i++) {" + NL + "                if (row[i]!=null) {" + NL + "                  colLengths[i] = Math.max(colLengths[i], row[i].length());" + NL + "                }" + NL + "            }" + NL + "            list.add(row);" + NL + "        }" + NL + "" + NL + "        public void resetList(){" + NL + "            list.clear();" + NL + "        }" + NL + "" + NL + "        public void setTableName(String name) {" + NL + "" + NL + "            this.name = name;" + NL + "        }" + NL + "" + NL + "            public StringBuilder format() {" + NL + "            " + NL + "                StringBuilder sb = new StringBuilder();" + NL + " ";
  protected final String TEXT_109 = " " + NL + "            " + NL + "                    sb.append(print(des_top));" + NL + "    " + NL + "                    int totals = 0;" + NL + "                    for (int i = 0; i < colLengths.length; i++) {" + NL + "                        totals = totals + colLengths[i];" + NL + "                    }" + NL + "    " + NL + "                    // name" + NL + "                    sb.append(\"|\");" + NL + "                    int k = 0;" + NL + "                    for (k = 0; k < (totals + ";
  protected final String TEXT_110 = " - name.length()) / 2; k++) {" + NL + "                        sb.append(' ');" + NL + "                    }" + NL + "                    sb.append(name);" + NL + "                    for (int i = 0; i < totals + ";
  protected final String TEXT_111 = " - name.length() - k; i++) {" + NL + "                        sb.append(' ');" + NL + "                    }" + NL + "                    sb.append(\"|\\n\");" + NL + "" + NL + "                    // head and rows" + NL + "                    sb.append(print(des_head));" + NL + "                    for (int i = 0; i < list.size(); i++) {" + NL + "    " + NL + "                        String[] row = list.get(i);" + NL + "    " + NL + "                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());" + NL + "                        " + NL + "                        StringBuilder sbformat = new StringBuilder();                                       ";
  protected final String TEXT_112 = "      " + NL + "                            sbformat.append(\"|%";
  protected final String TEXT_113 = "$-\");" + NL + "                            sbformat.append(colLengths[";
  protected final String TEXT_114 = "]);" + NL + "                            sbformat.append(\"s\");";
  protected final String TEXT_115 = "              " + NL + "                        sbformat.append(\"|\\n\");                    " + NL + "       " + NL + "                        formatter.format(sbformat.toString(), (Object[])row);   " + NL + "                                " + NL + "                        sb.append(formatter.toString());" + NL + "                        if (i == 0)" + NL + "                            sb.append(print(des_head)); // print the head" + NL + "                    }" + NL + "    " + NL + "                    // end" + NL + "                    sb.append(print(des_bottom));" + NL + "                    return sb;" + NL + "                }" + NL + "            " + NL + "" + NL + "            private StringBuilder print(String[] fillChars) {" + NL + "                StringBuilder sb = new StringBuilder();" + NL + "                //first column" + NL + "                sb.append(fillChars[0]);";
  protected final String TEXT_116 = "                " + NL + "                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }" + NL + "                    sb.append(fillChars[3]);";
  protected final String TEXT_117 = "                  " + NL;
  protected final String TEXT_118 = NL + "                    for (int i = 0; i < colLengths[";
  protected final String TEXT_119 = "] - fillChars[3].length() + 1; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }" + NL + "                    sb.append(fillChars[3]);";
  protected final String TEXT_120 = NL + "                ";
  protected final String TEXT_121 = "  " + NL + "                    //last column" + NL + "                    for (int i = 0; i < colLengths[";
  protected final String TEXT_122 = "] - fillChars[0].length() - fillChars[1].length()+2; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }";
  protected final String TEXT_123 = NL + "                    //last column" + NL + "                    for (int i = 0; i < colLengths[";
  protected final String TEXT_124 = "] - fillChars[1].length() + 1; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }";
  protected final String TEXT_125 = "         " + NL + "                sb.append(fillChars[1]);" + NL + "                sb.append(\"\\n\");";
  protected final String TEXT_126 = "               " + NL + "                return sb;" + NL + "            }" + NL + "        }";
  protected final String TEXT_127 = " " + NL + "        public static class Util_";
  protected final String TEXT_128 = " {" + NL + "        " + NL + "            String[] des_top = { \".\", \"-\" };" + NL + "    " + NL + "            String[] des_data = { \"-\", \"+\" };" + NL + "    " + NL + "            String[] des_frame = { \"|\" }; " + NL + "            " + NL + "            public void printLine(StringBuilder sb, int titleWidth, int dataWidth){" + NL + "            " + NL + "                sb.append(\"+\");" + NL + "                for(int i=0; i<titleWidth+2; i++)" + NL + "                    sb.append(\"-\");" + NL + "                sb.append(\"+\");" + NL + "                for(int i=0; i<dataWidth+2; i++)" + NL + "                    sb.append(\"-\");" + NL + "                sb.append(\"+\" + \"\\n\");" + NL + "            }      " + NL + "    " + NL + "            public String print(String[] row, int nbLine){" + NL + "                " + NL + "                StringBuilder sb = new StringBuilder();";
  protected final String TEXT_129 = NL + "                    String title = \"#\" + nbLine + \". \" + \"";
  protected final String TEXT_130 = "\";";
  protected final String TEXT_131 = NL + "                    String title = \"#\" + nbLine + \". \" + \"";
  protected final String TEXT_132 = "\";";
  protected final String TEXT_133 = NL + "                    String title = \"#\" + nbLine + \". \" + \"";
  protected final String TEXT_134 = "--";
  protected final String TEXT_135 = "\";";
  protected final String TEXT_136 = NL + "            " + NL + "                //step 1: get the max length of all the row[] member;" + NL + "                int dataWidth = 5;      //the length of the string \"value\"  " + NL + "                for(int i=0;i<row.length;i++) {" + NL + "                    if(row[i] == null && 4 > dataWidth) {" + NL + "                        dataWidth = 4;" + NL + "                    }" + NL + "                    else if(row[i] != null && row[i].length()>dataWidth) " + NL + "                        dataWidth = row[i].length();" + NL + "                }           ";
  protected final String TEXT_137 = "          " + NL + "                int titleWidth = ";
  protected final String TEXT_138 = ";" + NL + "                " + NL + "                int totalWidth = dataWidth + titleWidth + 5;" + NL + "                " + NL + "                //step 2: print the header with line number" + NL + "                sb.append(\".\");" + NL + "                for(int i=0 ; i<totalWidth ; i++)" + NL + "                    sb.append(\"-\");         " + NL + "                sb.append(\".\" + \"\\n\" + \"|\");" + NL + "                " + NL + "                int emptyCenterWidth = (totalWidth-title.length())/2;" + NL + "                for(int i=0 ; i<emptyCenterWidth; i++)" + NL + "                    sb.append(\" \"); " + NL + "                sb.append(title);" + NL + "                for(int i=0 ; i<totalWidth - emptyCenterWidth - title.length() ; i++)" + NL + "                    sb.append(\" \"); " + NL + "                sb.append(\"|\" + \"\\n\");" + NL + "                " + NL + "                //step 3: print \"key\" and \"value\"           " + NL + "                printLine(sb,titleWidth,dataWidth);" + NL + "                " + NL + "                sb.append(\"|\" + \" key\");" + NL + "                for(int i=0; i<titleWidth-2; i++)" + NL + "                    sb.append(\" \");" + NL + "                sb.append(\"|\" + \" value\");" + NL + "                for(int i=0; i<dataWidth-4; i++)" + NL + "                    sb.append(\" \");" + NL + "                sb.append(\"|\" + \"\\n\");" + NL + "                " + NL + "                printLine(sb,titleWidth,dataWidth);" + NL + "                " + NL + "                //step 4: print dataset";
  protected final String TEXT_139 = NL + "                //for(int i=0; i<row.length; i++){" + NL + "                    sb.append(\"| \" + \"";
  protected final String TEXT_140 = "\");" + NL + "                    for(int i=0; i<titleWidth -\"";
  protected final String TEXT_141 = "\".length()+ 1 ;i++)" + NL + "                        sb.append(\" \");" + NL + "                    sb.append(\"| \" + row[";
  protected final String TEXT_142 = "]);" + NL + "                    for(int i=0; row[";
  protected final String TEXT_143 = "] == null && i<dataWidth - 3 || row[";
  protected final String TEXT_144 = "] != null && i<dataWidth -row[";
  protected final String TEXT_145 = "].length()+ 1 ;i++)" + NL + "                        sb.append(\" \");" + NL + "                    sb.append(\"|\" + \"\\n\");" + NL + "                " + NL + "                //}" + NL + "    ";
  protected final String TEXT_146 = NL + "                //step 5: print a line gap" + NL + "                printLine(sb,titleWidth,dataWidth);" + NL + "                return sb.toString();" + NL + "            }" + NL + "        }";
  protected final String TEXT_147 = NL + NL + NL + "   public static class ";
  protected final String TEXT_148 = "_ForeachRDD implements org.apache.spark.api.java.function.Function<org.apache.spark.api.java.JavaPairRDD<NullWritable, ";
  protected final String TEXT_149 = ">, Void>{" + NL + "" + NL + "       private final ContextProperties context;" + NL + "       private final String OUTPUT_FIELD_SEPARATOR_";
  protected final String TEXT_150 = ";" + NL + "       private transient java.io.PrintStream consoleOut_";
  protected final String TEXT_151 = " = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));" + NL + "" + NL + "      public ";
  protected final String TEXT_152 = "_ForeachRDD(JobConf job){" + NL + "        this.context = new ContextProperties(job);" + NL + "        this.OUTPUT_FIELD_SEPARATOR_";
  protected final String TEXT_153 = " = ";
  protected final String TEXT_154 = ";" + NL + "        consoleOut_";
  protected final String TEXT_155 = " = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));";
  protected final String TEXT_156 = NL + "        ";
  protected final String TEXT_157 = "_createDisplayMode();" + NL + "      }" + NL + "" + NL + "      public void ";
  protected final String TEXT_158 = "_createDisplayMode(){";
  protected final String TEXT_159 = " " + NL + "             StringBuilder sbHeader_";
  protected final String TEXT_160 = " = new StringBuilder();";
  protected final String TEXT_161 = NL + "               sbHeader_";
  protected final String TEXT_162 = ".append(\"";
  protected final String TEXT_163 = "\");" + NL + "           ";
  protected final String TEXT_164 = NL + "                 sbHeader_";
  protected final String TEXT_165 = ".append(\"\\t\");";
  protected final String TEXT_166 = NL + "                       consoleOut_";
  protected final String TEXT_167 = ".println(sbHeader_";
  protected final String TEXT_168 = ".toString());" + NL + "                       consoleOut_";
  protected final String TEXT_169 = ".flush();";
  protected final String TEXT_170 = NL + NL + "      }" + NL + "" + NL + "      public Void call(org.apache.spark.api.java.JavaPairRDD<NullWritable, ";
  protected final String TEXT_171 = "> rdd) throws Exception {" + NL + "" + NL + "          if(consoleOut_";
  protected final String TEXT_172 = " == null){" + NL + "            consoleOut_";
  protected final String TEXT_173 = " = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));" + NL + "          }" + NL + "" + NL + "         // Get the values since the keys are not serializable" + NL + "         java.util.List<";
  protected final String TEXT_174 = "> recordsList = rdd.values().collect();" + NL + "         java.util.Iterator<";
  protected final String TEXT_175 = "> recordsIterator = recordsList.iterator();" + NL + "" + NL + "          StringBuilder strBuffer_";
  protected final String TEXT_176 = " = null;";
  protected final String TEXT_177 = NL + "               Util_";
  protected final String TEXT_178 = " util_";
  protected final String TEXT_179 = " = new Util_";
  protected final String TEXT_180 = "();" + NL + "               util_";
  protected final String TEXT_181 = ".setTableName(\"";
  protected final String TEXT_182 = "\");" + NL + "               util_";
  protected final String TEXT_183 = ".addRow(new String[]{";
  protected final String TEXT_184 = "\"";
  protected final String TEXT_185 = "\",";
  protected final String TEXT_186 = "});";
  protected final String TEXT_187 = NL + "               Util_";
  protected final String TEXT_188 = " util_";
  protected final String TEXT_189 = " = new Util_";
  protected final String TEXT_190 = "();" + NL + "               int nb_line_";
  protected final String TEXT_191 = " = 0;";
  protected final String TEXT_192 = NL + "              while(recordsIterator.hasNext()){";
  protected final String TEXT_193 = NL + "                 ";
  protected final String TEXT_194 = " ";
  protected final String TEXT_195 = " = recordsIterator.next();";
  protected final String TEXT_196 = NL + "                   strBuffer_";
  protected final String TEXT_197 = " = new StringBuilder();";
  protected final String TEXT_198 = NL + "                     strBuffer_";
  protected final String TEXT_199 = ".append(\"[";
  protected final String TEXT_200 = "] \");";
  protected final String TEXT_201 = NL + "                       java.util.Formatter formatter_";
  protected final String TEXT_202 = "_";
  protected final String TEXT_203 = " = new java.util.Formatter(new StringBuilder());";
  protected final String TEXT_204 = NL + "                       strBuffer_";
  protected final String TEXT_205 = ".append(\"";
  protected final String TEXT_206 = ": \");";
  protected final String TEXT_207 = NL + "                       if(";
  protected final String TEXT_208 = ".";
  protected final String TEXT_209 = " != null) { //";
  protected final String TEXT_210 = NL + "                     strBuffer_";
  protected final String TEXT_211 = ".append(";
  protected final String TEXT_212 = NL + "                         formatter_";
  protected final String TEXT_213 = "_";
  protected final String TEXT_214 = ".format(\"%1$";
  protected final String TEXT_215 = "s\",";
  protected final String TEXT_216 = NL + "                           FormatterUtils.format_DateInUTC(";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = ", ";
  protected final String TEXT_219 = ")";
  protected final String TEXT_220 = NL + "                                                   java.nio.charset.Charset.defaultCharset().decode(";
  protected final String TEXT_221 = ".";
  protected final String TEXT_222 = ").toString()";
  protected final String TEXT_223 = NL + "                                                   java.nio.charset.Charset.defaultCharset().decode(";
  protected final String TEXT_224 = ".";
  protected final String TEXT_225 = ").toString()";
  protected final String TEXT_226 = NL + "                           ";
  protected final String TEXT_227 = ".toPlainString()";
  protected final String TEXT_228 = NL + "                           FormatterUtils.formatUnwithE(";
  protected final String TEXT_229 = ".";
  protected final String TEXT_230 = ")";
  protected final String TEXT_231 = NL + "                               String.valueOf(";
  protected final String TEXT_232 = ".";
  protected final String TEXT_233 = ")      ";
  protected final String TEXT_234 = NL + "                         ).toString()";
  protected final String TEXT_235 = NL + "                     );";
  protected final String TEXT_236 = NL + "                       } //  ";
  protected final String TEXT_237 = NL + "                     strBuffer_";
  protected final String TEXT_238 = ".append(";
  protected final String TEXT_239 = ");";
  protected final String TEXT_240 = NL + "                             consoleOut_";
  protected final String TEXT_241 = ".println(strBuffer_";
  protected final String TEXT_242 = ".toString());" + NL + "                             consoleOut_";
  protected final String TEXT_243 = ".flush();";
  protected final String TEXT_244 = NL + "                           String[] row_";
  protected final String TEXT_245 = " = new String[";
  protected final String TEXT_246 = "];";
  protected final String TEXT_247 = NL + "                               if(";
  protected final String TEXT_248 = ".";
  protected final String TEXT_249 = " != null) { //";
  protected final String TEXT_250 = NL + "                             row_";
  protected final String TEXT_251 = "[";
  protected final String TEXT_252 = "]= ";
  protected final String TEXT_253 = NL + "                         FormatterUtils.format_DateInUTC(";
  protected final String TEXT_254 = ".";
  protected final String TEXT_255 = ", ";
  protected final String TEXT_256 = ")";
  protected final String TEXT_257 = NL + "                         java.nio.charset.Charset.defaultCharset().decode(";
  protected final String TEXT_258 = ".";
  protected final String TEXT_259 = ").toString()";
  protected final String TEXT_260 = NL + "                         ";
  protected final String TEXT_261 = ".toPlainString()";
  protected final String TEXT_262 = NL + "                         FormatterUtils.formatUnwithE(";
  protected final String TEXT_263 = ".";
  protected final String TEXT_264 = ")";
  protected final String TEXT_265 = NL + "                             String.valueOf(";
  protected final String TEXT_266 = ".";
  protected final String TEXT_267 = ")      ";
  protected final String TEXT_268 = NL + "                     ;";
  protected final String TEXT_269 = NL + "                               } //";
  protected final String TEXT_270 = NL + "                             util_";
  protected final String TEXT_271 = ".addRow(row_";
  protected final String TEXT_272 = ");";
  protected final String TEXT_273 = NL + "                             nb_line_";
  protected final String TEXT_274 = "++;" + NL + "                             consoleOut_";
  protected final String TEXT_275 = ".println(util_";
  protected final String TEXT_276 = ".print(row_";
  protected final String TEXT_277 = ",nb_line_";
  protected final String TEXT_278 = "));" + NL + "                             consoleOut_";
  protected final String TEXT_279 = ".flush();";
  protected final String TEXT_280 = NL + "               }";
  protected final String TEXT_281 = NL + "                  consoleOut_";
  protected final String TEXT_282 = ".println(util_";
  protected final String TEXT_283 = ".format().toString());" + NL + "                  consoleOut_";
  protected final String TEXT_284 = ".flush();";
  protected final String TEXT_285 = NL + "   return null;" + NL + "      }" + NL + "   }";
  protected final String TEXT_286 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
if(org.talend.designer.common.tmap.LookupUtil.isNodeInBatchMode((INode) ((BigDataCodeGeneratorArgument) argument).getArgument())) {

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

    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
IMetadataTable metadata = null;
if(metadatas != null && metadatas.size() > 0){
    metadata = metadatas.get(0);
}
String inConnTypeName = null;
List<IMetadataColumn> columns = null;

if(metadata != null){
    boolean compress = "true".equals(ElementParameterParser.getValue(node, "__COMPRESS__"));
    String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");

    List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
    if(inConns != null && inConns.size() > 0){
           IConnection inConn = inConns.get(0);
        inConnTypeName = codeGenArgument.getRecordStructName(inConn);
    }
    columns = metadata.getListColumns();
}
if (inConnTypeName == null || columns == null){
    return "";
}

AvroOutput avroOutput = new AvroOutput(cid, inConnTypeName, columns, true);
avroOutput.gen();

    stringBuffer.append(TEXT_56);
    stringBuffer.append(TEXT_57);
    
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
    
    stringBuffer.append(TEXT_58);
    
    if(tablePrint) { // table display mode
        
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_62);
     
                if (sizeColumns > 0) { //more than one column
                
    stringBuffer.append(TEXT_63);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_65);
    
                        for ( int i = 0; i < sizeColumns; i++) {
                            
    stringBuffer.append(TEXT_66);
    stringBuffer.append(i+1 );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_68);
    
                        }
                        
    stringBuffer.append(TEXT_69);
     
                if (sizeColumns > 1) { 
                    
    stringBuffer.append(TEXT_70);
    
                }
                
    stringBuffer.append(TEXT_71);
    
                for(int i = 0; i< sizeColumns-2;i++) {
                    
    stringBuffer.append(TEXT_72);
    stringBuffer.append(i+1 );
    stringBuffer.append(TEXT_73);
    
                }
                
    stringBuffer.append(TEXT_74);
     
                if (sizeColumns == 1) { 
                    
    stringBuffer.append(TEXT_75);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_76);
     
                } else if (sizeColumns > 1){
                    
    stringBuffer.append(TEXT_77);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_78);
    
                }
                
    stringBuffer.append(TEXT_79);
     
            } 
            
    stringBuffer.append(TEXT_80);
    
    }
    if(vertical) { 
    
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    
                if(uniquePrint) {
                    
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
                } else if(titlePrint) {
                    
    stringBuffer.append(TEXT_85);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_86);
    
                } else if(uniqueTitlePrint) {
                    
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_89);
    
                }
                
    stringBuffer.append(TEXT_90);
    
                int titleWidth = 3;    //the length of the string 'key'
                for(IMetadataColumn column:columns)
                    if(column.getLabel().length()>titleWidth) titleWidth = column.getLabel().length();
                
    stringBuffer.append(TEXT_91);
    stringBuffer.append(titleWidth);
    stringBuffer.append(TEXT_92);
    
                int count = 0;
                for(IMetadataColumn column:columns){
                
    stringBuffer.append(TEXT_93);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_99);
    
                    count++;
                }
    stringBuffer.append(TEXT_100);
    
    }
    
    stringBuffer.append(TEXT_101);
    
} else {
      BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
      INode node = (INode)codeGenArgument.getArgument();  
      String cid = node.getUniqueName();

      List<IMetadataTable> metadatas = node.getMetadataList();
      IMetadataTable metadata = null;
      if(metadatas != null && metadatas.size() > 0){
          metadata = metadatas.get(0);
      }

      String inConnTypeName = null;
      String connName = null;
      List<IMetadataColumn> columns = null;

      if(metadata != null){
        boolean compress = "true".equals(ElementParameterParser.getValue(node, "__COMPRESS__"));
        String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");
        List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
        if(inConns != null && inConns.size() > 0){
          IConnection inConn = inConns.get(0); 
          connName = inConn.getName();
          inConnTypeName = codeGenArgument.getRecordStructName(inConn);
        }
        columns = metadata.getListColumns();
      }

      if (inConnTypeName == null || columns == null){
        return "";
      }

      String printUniqueName = ElementParameterParser.getValue(node,"__PRINT_UNIQUE_NAME__");
      String printColumnNames = ElementParameterParser.getValue(node,"__PRINT_COLNAMES__");
      String useFixedLength = ElementParameterParser.getValue(node,"__USE_FIXED_LENGTH__");
      List<Map<String, String>> lengths = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__LENGTHS__");


    stringBuffer.append(TEXT_102);
    stringBuffer.append(TEXT_103);
    
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

// Doesn't import the tLogRow_util from mrcode as in Spark Batch
// We need to instantiate Util_tLogRow object inside the ForEach object
// So the class was set to public static here.

    
    stringBuffer.append(TEXT_104);
    
    if(tablePrint) { // table display mode
        
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_108);
     
                if (sizeColumns > 0) { //more than one column
                
    stringBuffer.append(TEXT_109);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_111);
    
                        for ( int i = 0; i < sizeColumns; i++) {
                            
    stringBuffer.append(TEXT_112);
    stringBuffer.append(i+1 );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_114);
    
                        }
                        
    stringBuffer.append(TEXT_115);
     
                if (sizeColumns > 1) { 
                    
    stringBuffer.append(TEXT_116);
    
                }
                
    stringBuffer.append(TEXT_117);
    
                for(int i = 0; i< sizeColumns-2;i++) {
                    
    stringBuffer.append(TEXT_118);
    stringBuffer.append(i+1 );
    stringBuffer.append(TEXT_119);
    
                }
                
    stringBuffer.append(TEXT_120);
     
                if (sizeColumns == 1) { 
                    
    stringBuffer.append(TEXT_121);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_122);
     
                } else if (sizeColumns > 1){
                    
    stringBuffer.append(TEXT_123);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_124);
    
                }
                
    stringBuffer.append(TEXT_125);
     
            } 
            
    stringBuffer.append(TEXT_126);
    
    }
    if(vertical) { 
    
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    
                if(uniquePrint) {
                    
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
                } else if(titlePrint) {
                    
    stringBuffer.append(TEXT_131);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_132);
    
                } else if(uniqueTitlePrint) {
                    
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_135);
    
                }
                
    stringBuffer.append(TEXT_136);
    
                int titleWidth = 3;    //the length of the string 'key'
                for(IMetadataColumn column:columns)
                    if(column.getLabel().length()>titleWidth) titleWidth = column.getLabel().length();
                
    stringBuffer.append(TEXT_137);
    stringBuffer.append(titleWidth);
    stringBuffer.append(TEXT_138);
    
                int count = 0;
                for(IMetadataColumn column:columns){
                
    stringBuffer.append(TEXT_139);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_141);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_145);
    
                    count++;
                }
    stringBuffer.append(TEXT_146);
    
    }
    
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIELDSEPARATOR__") );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
         if(basic) {// basic display mode
           if (("true").equals(printHeader)) {
           
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
              
               for (int i = 0; i < sizeColumns; i++) {
               IMetadataColumn column = columns.get(i);
             
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_163);
    
               if(i == sizeColumns-1) break;               
               
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
                     }   
             
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    
           } 
         }
         
    stringBuffer.append(TEXT_170);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
            // Table and Vertical object initialisation
           if(tablePrint) { // table display mode
           
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    for(int i=0;i< columns.size();i++){
    stringBuffer.append(TEXT_184);
    stringBuffer.append(columns.get(i).getLabel() );
    stringBuffer.append(TEXT_185);
    }
    stringBuffer.append(TEXT_186);
    
            }
            if(vertical) {
         
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
     
             }

    stringBuffer.append(TEXT_192);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_195);
    
                   if (basic||vertical) {  // don't print the table form//***
                 
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
     
                     if (("true").equals(printUniqueName)) {//print the component name.
                   
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    
                     }
                     for (int i = 0; i < sizeColumns; i++) {//5
                       IMetadataColumn column = columns.get(i);
                     JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                     if (("true").equals(useFixedLength)) {//fix the column length
                     
    stringBuffer.append(TEXT_201);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    
                     }
                     if (("true").equals(printColumnNames)) {//print the schema name
                     
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_206);
    
                     }
                     boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
                     if(!isPrimitive) { //begin
                     
    stringBuffer.append(TEXT_207);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_209);
    
                     }
                     
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    
                       if (("true").equals(useFixedLength)) {//fixed the column length
                       
    stringBuffer.append(TEXT_212);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(lengths.get(i).get("LENGTH") );
    stringBuffer.append(TEXT_215);
    
                       }
                       
    
                           String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                           if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date
                         
    stringBuffer.append(TEXT_216);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_218);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_219);
            
                         } else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]
                                            // Avro metadata table compatibility
                             if (codeGenArgument.getRecordStructGenerator().isByteArrayWrappedInBuffer()) {
    stringBuffer.append(TEXT_220);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_222);
    } else {
    stringBuffer.append(TEXT_223);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_225);
    }
    
                         } else if (javaType == JavaTypesManager.BIGDECIMAL) {
                         
    stringBuffer.append(TEXT_226);
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_227);
    
                         } else if (javaType == JavaTypesManager.DOUBLE || javaType == JavaTypesManager.FLOAT ) {
                         
    stringBuffer.append(TEXT_228);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_230);
    
                         } else {//others
                         
    stringBuffer.append(TEXT_231);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_233);
            
                         }
                         
    
                       if (("true").equals(useFixedLength)) {//fixed the column length
                       
    stringBuffer.append(TEXT_234);
    
                       }
                       
    stringBuffer.append(TEXT_235);
    
                     if(!isPrimitive) {//end
                     
    stringBuffer.append(TEXT_236);
    
                     }
                     if(i == sizeColumns-1) break;
                     
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIELDSEPARATOR__") );
    stringBuffer.append(TEXT_239);
    
                   }
                 }
                 if (basic) { 
                 
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    
                         }
                         if(tablePrint || vertical) { //print the table and vertical model//***
                         
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_246);
    
                           for (int i = 0; i < sizeColumns; i++) {//5
               
                       IMetadataColumn column = columns.get(i);
                       JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                       boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
                     if(!isPrimitive) { //begin
                             
    stringBuffer.append(TEXT_247);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_249);
    
                             }
                             
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_252);
    
                         String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                         if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date
                       
    stringBuffer.append(TEXT_253);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_255);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_256);
            
                       } else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]
                       
    stringBuffer.append(TEXT_257);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_259);
    
                       } else if (javaType == JavaTypesManager.BIGDECIMAL) {
                       
    stringBuffer.append(TEXT_260);
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_261);
    
                       } else if (javaType == JavaTypesManager.DOUBLE || javaType == JavaTypesManager.FLOAT ) {
                       
    stringBuffer.append(TEXT_262);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_264);
    
                       } else {//others
                       
    stringBuffer.append(TEXT_265);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_267);
            
                       }
                       
    stringBuffer.append(TEXT_268);
    
                     if(!isPrimitive) { //end
                             
    stringBuffer.append(TEXT_269);
    
                             }
                           }//5
                           if(tablePrint){
                           
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    
                           }else{
                           
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    
                           }
                       }
                       
    stringBuffer.append(TEXT_280);
    
         if(tablePrint){
         
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
         }
     
    stringBuffer.append(TEXT_285);
    
} // end else

    stringBuffer.append(TEXT_286);
    return stringBuffer.toString();
  }
}
