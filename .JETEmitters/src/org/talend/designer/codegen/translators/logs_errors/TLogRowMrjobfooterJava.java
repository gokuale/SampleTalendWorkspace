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

public class TLogRowMrjobfooterJava
{
  protected static String nl;
  public static synchronized TLogRowMrjobfooterJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLogRowMrjobfooterJava result = new TLogRowMrjobfooterJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    Util_";
  protected final String TEXT_2 = " util_";
  protected final String TEXT_3 = " = new Util_";
  protected final String TEXT_4 = "();" + NL + "    util_";
  protected final String TEXT_5 = ".setTableName(\"";
  protected final String TEXT_6 = "\");" + NL + "    util_";
  protected final String TEXT_7 = ".addRow(new String[]{";
  protected final String TEXT_8 = "\"";
  protected final String TEXT_9 = "\",";
  protected final String TEXT_10 = "});";
  protected final String TEXT_11 = NL + "    Util_";
  protected final String TEXT_12 = " util_";
  protected final String TEXT_13 = " = new Util_";
  protected final String TEXT_14 = "();" + NL + "    java.io.PrintStream consoleOut_";
  protected final String TEXT_15 = " = null;" + NL + "    if (globalMap.getLocal(\"tLogRow_CONSOLE\")!=null){" + NL + "        consoleOut_";
  protected final String TEXT_16 = " = (java.io.PrintStream) globalMap.getLocal(\"tLogRow_CONSOLE\");" + NL + "    }else{" + NL + "        consoleOut_";
  protected final String TEXT_17 = " = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));" + NL + "        globalMap.putLocal(\"tLogRow_CONSOLE\",consoleOut_";
  protected final String TEXT_18 = ");" + NL + "    }";
  protected final String TEXT_19 = NL + "    final String OUTPUT_FIELD_SEPARATOR_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ";" + NL + "    java.io.PrintStream consoleOut_";
  protected final String TEXT_22 = " = null;";
  protected final String TEXT_23 = NL + "        StringBuilder sbHeader_";
  protected final String TEXT_24 = " = new StringBuilder();";
  protected final String TEXT_25 = NL + "            sbHeader_";
  protected final String TEXT_26 = ".append(\"";
  protected final String TEXT_27 = "\");" + NL;
  protected final String TEXT_28 = NL + "            sbHeader_";
  protected final String TEXT_29 = ".append(\"\\t\");";
  protected final String TEXT_30 = NL + "        if (globalMap.getLocal(\"tLogRow_CONSOLE\")!=null)" + NL + "        {" + NL + "            consoleOut_";
  protected final String TEXT_31 = " = (java.io.PrintStream) globalMap.getLocal(\"tLogRow_CONSOLE\");" + NL + "        }" + NL + "        else" + NL + "        {" + NL + "            consoleOut_";
  protected final String TEXT_32 = " = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));" + NL + "            globalMap.putLocal(\"tLogRow_CONSOLE\",consoleOut_";
  protected final String TEXT_33 = ");" + NL + "        }" + NL + "" + NL + "        consoleOut_";
  protected final String TEXT_34 = ".println(sbHeader_";
  protected final String TEXT_35 = ".toString());" + NL + "        consoleOut_";
  protected final String TEXT_36 = ".flush();";
  protected final String TEXT_37 = NL + NL + NL + NL + "List<org.apache.avro.Schema.Field> fields_";
  protected final String TEXT_38 = " = new java.util.ArrayList<org.apache.avro.Schema.Field>();" + NL + "List<org.apache.avro.Schema> unionSchema_";
  protected final String TEXT_39 = " = null;" + NL + "List<org.apache.avro.Schema> arraySchema_";
  protected final String TEXT_40 = " = null;";
  protected final String TEXT_41 = NL + "        fields_";
  protected final String TEXT_42 = ".add(new org.apache.avro.Schema.Field(\"";
  protected final String TEXT_43 = "\",org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_44 = "),null,null));";
  protected final String TEXT_45 = NL + "        unionSchema_";
  protected final String TEXT_46 = " = new java.util.ArrayList<org.apache.avro.Schema>();";
  protected final String TEXT_47 = NL + "            arraySchema_";
  protected final String TEXT_48 = " = new java.util.ArrayList<org.apache.avro.Schema>();";
  protected final String TEXT_49 = NL + "                arraySchema_";
  protected final String TEXT_50 = ".add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_51 = "));";
  protected final String TEXT_52 = NL + "            arraySchema_";
  protected final String TEXT_53 = ".add(org.apache.avro.Schema" + NL + "                    .createArray(org.apache.avro.Schema" + NL + "                            .createUnion(arraySchema_";
  protected final String TEXT_54 = ")));" + NL + "            unionSchema_";
  protected final String TEXT_55 = ".add(org.apache.avro.Schema.createArray(" + NL + "                    org.apache.avro.Schema.createUnion(arraySchema_";
  protected final String TEXT_56 = ")));";
  protected final String TEXT_57 = NL + "            unionSchema_";
  protected final String TEXT_58 = ".add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_59 = "));";
  protected final String TEXT_60 = NL + "                unionSchema_";
  protected final String TEXT_61 = ".add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_62 = "));";
  protected final String TEXT_63 = NL + "        unionSchema_";
  protected final String TEXT_64 = ".add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.NULL));" + NL + "        fields_";
  protected final String TEXT_65 = ".add(new org.apache.avro.Schema.Field(\"";
  protected final String TEXT_66 = "\", org.apache.avro.Schema.createUnion(unionSchema_";
  protected final String TEXT_67 = "),null,null));";
  protected final String TEXT_68 = NL + "org.apache.avro.Schema schema_";
  protected final String TEXT_69 = " = org.apache.avro.Schema.createRecord(fields_";
  protected final String TEXT_70 = ");" + NL + "" + NL + "//create file reader" + NL + "org.apache.avro.io.DatumReader<org.apache.avro.generic.GenericRecord> datumReader_";
  protected final String TEXT_71 = " = new org.apache.avro.generic.GenericDatumReader<org.apache.avro.generic.GenericRecord>(schema_";
  protected final String TEXT_72 = ");" + NL + "org.apache.avro.generic.GenericRecord record_";
  protected final String TEXT_73 = " = new org.apache.avro.generic.GenericData.Record(schema_";
  protected final String TEXT_74 = ");" + NL + "" + NL + "StringBuilder strBuffer_";
  protected final String TEXT_75 = " = null;" + NL + "int nb_line_";
  protected final String TEXT_76 = " = 0;";
  protected final String TEXT_77 = NL + "    java.net.URI currentURI_";
  protected final String TEXT_78 = "_footer = FileSystem.getDefaultUri(ctx.hadoopConfiguration());" + NL + "    FileSystem.setDefaultUri(ctx.hadoopConfiguration(), new java.net.URI(";
  protected final String TEXT_79 = "));" + NL + "    fs = FileSystem.get(ctx.hadoopConfiguration());";
  protected final String TEXT_80 = NL + NL + "org.apache.hadoop.fs.PathFilter hiddenFileFilter_";
  protected final String TEXT_81 = " = new org.apache.hadoop.fs.PathFilter(){" + NL + "    public boolean accept(Path p){" + NL + "" + NL + "        org.apache.hadoop.fs.FileStatus statu;" + NL + "        String name = p.getName();" + NL + "        try {";
  protected final String TEXT_82 = NL + "                statu = FileSystem.get(ctx.hadoopConfiguration()).getFileStatus(p);";
  protected final String TEXT_83 = NL + "                statu = fs.getFileStatus(p);";
  protected final String TEXT_84 = NL + "            if (statu.isDir()) {" + NL + "            } else if (name.startsWith(\".\") || name.startsWith(\"_\")) {" + NL + "            } else if (name.endsWith(\".avro\")) {" + NL + "                return true;" + NL + "            }" + NL + "        } catch (IOException e) {" + NL + "            // TODO Auto-generated catch block" + NL + "            e.printStackTrace();" + NL + "        }" + NL + "" + NL + "        return false;" + NL + "" + NL + "      }" + NL + "};" + NL + "" + NL + "if (fs.exists(new Path(outputPath_";
  protected final String TEXT_85 = "))) {" + NL + "    final java.util.List<org.apache.hadoop.fs.FileStatus> listStatus_";
  protected final String TEXT_86 = " = java.util.Arrays.asList(fs.listStatus(new Path(outputPath_";
  protected final String TEXT_87 = "), hiddenFileFilter_";
  protected final String TEXT_88 = "));" + NL + "    // Read result files in the right order to keep potential previous row ordering" + NL + "    java.util.Collections.sort(listStatus_";
  protected final String TEXT_89 = ", new java.util.Comparator<org.apache.hadoop.fs.FileStatus>() {" + NL + "                public int compare(org.apache.hadoop.fs.FileStatus o1, org.apache.hadoop.fs.FileStatus o2) {" + NL + "                return o1.getPath().getName().compareTo(o2.getPath().getName());" + NL + "             }" + NL + "         });" + NL + "" + NL + "    for(org.apache.hadoop.fs.FileStatus fileStatus_";
  protected final String TEXT_90 = " : listStatus_";
  protected final String TEXT_91 = "){" + NL + "        org.apache.avro.file.FileReader<org.apache.avro.generic.GenericRecord> reader_";
  protected final String TEXT_92 = " = org.apache.avro.file.DataFileReader.openReader(new org.apache.avro.mapred.FsInput(fileStatus_";
  protected final String TEXT_93 = ".getPath(), job), datumReader_";
  protected final String TEXT_94 = ");" + NL + "" + NL + "        while(reader_";
  protected final String TEXT_95 = ".hasNext()){" + NL + "            record_";
  protected final String TEXT_96 = " = reader_";
  protected final String TEXT_97 = ".next(record_";
  protected final String TEXT_98 = ");";
  protected final String TEXT_99 = NL + "            ";
  protected final String TEXT_100 = " ";
  protected final String TEXT_101 = " = new ";
  protected final String TEXT_102 = "();" + NL + "            Object columnObject_";
  protected final String TEXT_103 = " = null;";
  protected final String TEXT_104 = NL + "                columnObject_";
  protected final String TEXT_105 = " = record_";
  protected final String TEXT_106 = ".get(\"";
  protected final String TEXT_107 = "\");" + NL + "                if(columnObject_";
  protected final String TEXT_108 = " != null) {";
  protected final String TEXT_109 = NL + "                        ";
  protected final String TEXT_110 = ".";
  protected final String TEXT_111 = " = columnObject_";
  protected final String TEXT_112 = ".toString();";
  protected final String TEXT_113 = NL + "                        ";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = " = ((Integer)columnObject_";
  protected final String TEXT_116 = ").byteValue();";
  protected final String TEXT_117 = NL + "                        ";
  protected final String TEXT_118 = ".";
  protected final String TEXT_119 = " = ((Integer)columnObject_";
  protected final String TEXT_120 = ").shortValue();";
  protected final String TEXT_121 = NL + "                        ";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = " = (Character)(char)(int)(Integer)columnObject_";
  protected final String TEXT_124 = ";";
  protected final String TEXT_125 = NL + "                            ";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = " = (java.nio.ByteBuffer)columnObject_";
  protected final String TEXT_128 = ";";
  protected final String TEXT_129 = NL + "                            ";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = " = ((java.nio.ByteBuffer)columnObject_";
  protected final String TEXT_132 = ").array();";
  protected final String TEXT_133 = NL + "                        ";
  protected final String TEXT_134 = ".";
  protected final String TEXT_135 = " = new java.math.BigDecimal(columnObject_";
  protected final String TEXT_136 = ".toString());";
  protected final String TEXT_137 = NL + "                        ";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = " = new java.util.Date((Long)columnObject_";
  protected final String TEXT_140 = ");";
  protected final String TEXT_141 = NL + "                        ";
  protected final String TEXT_142 = ".";
  protected final String TEXT_143 = " = (";
  protected final String TEXT_144 = ")columnObject_";
  protected final String TEXT_145 = ";";
  protected final String TEXT_146 = NL + "                        } else {";
  protected final String TEXT_147 = NL + "                                ";
  protected final String TEXT_148 = ".";
  protected final String TEXT_149 = " = ";
  protected final String TEXT_150 = "d;";
  protected final String TEXT_151 = NL + "                                ";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = " = ";
  protected final String TEXT_154 = "f;";
  protected final String TEXT_155 = NL + "                                ";
  protected final String TEXT_156 = ".";
  protected final String TEXT_157 = " = ";
  protected final String TEXT_158 = "l;";
  protected final String TEXT_159 = NL + "                            ";
  protected final String TEXT_160 = ".";
  protected final String TEXT_161 = " = ";
  protected final String TEXT_162 = ";";
  protected final String TEXT_163 = NL + "                }";
  protected final String TEXT_164 = NL + "                strBuffer_";
  protected final String TEXT_165 = " = new StringBuilder();";
  protected final String TEXT_166 = NL + "                    strBuffer_";
  protected final String TEXT_167 = ".append(\"[";
  protected final String TEXT_168 = "] \");";
  protected final String TEXT_169 = NL + "                        java.util.Formatter formatter_";
  protected final String TEXT_170 = "_";
  protected final String TEXT_171 = " = new java.util.Formatter(new StringBuilder());";
  protected final String TEXT_172 = NL + "                        strBuffer_";
  protected final String TEXT_173 = ".append(\"";
  protected final String TEXT_174 = ": \");";
  protected final String TEXT_175 = NL + "                        if(";
  protected final String TEXT_176 = ".";
  protected final String TEXT_177 = " != null) { //";
  protected final String TEXT_178 = NL + "                    strBuffer_";
  protected final String TEXT_179 = ".append(";
  protected final String TEXT_180 = NL + "                            formatter_";
  protected final String TEXT_181 = "_";
  protected final String TEXT_182 = ".format(\"%1$";
  protected final String TEXT_183 = "s\",";
  protected final String TEXT_184 = NL + "                                FormatterUtils.format_DateInUTC(";
  protected final String TEXT_185 = ".";
  protected final String TEXT_186 = ", ";
  protected final String TEXT_187 = ")";
  protected final String TEXT_188 = NL + "                                    java.nio.charset.Charset.defaultCharset().decode(";
  protected final String TEXT_189 = ".";
  protected final String TEXT_190 = ").toString()";
  protected final String TEXT_191 = NL + "                                    java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_192 = ".";
  protected final String TEXT_193 = ")).toString()";
  protected final String TEXT_194 = NL + "                                ";
  protected final String TEXT_195 = ".toPlainString()";
  protected final String TEXT_196 = NL + "                                FormatterUtils.formatUnwithE(";
  protected final String TEXT_197 = ".";
  protected final String TEXT_198 = ")";
  protected final String TEXT_199 = NL + "                                String.valueOf(";
  protected final String TEXT_200 = ".";
  protected final String TEXT_201 = ")";
  protected final String TEXT_202 = NL + "                            ).toString()";
  protected final String TEXT_203 = NL + "                    );";
  protected final String TEXT_204 = NL + "                        } //";
  protected final String TEXT_205 = NL + "                    strBuffer_";
  protected final String TEXT_206 = ".append(";
  protected final String TEXT_207 = ");";
  protected final String TEXT_208 = NL + "                if (globalMap.getLocal(\"tLogRow_CONSOLE\")!=null)" + NL + "                {" + NL + "                    consoleOut_";
  protected final String TEXT_209 = " = (java.io.PrintStream) globalMap.getLocal(\"tLogRow_CONSOLE\");" + NL + "                }" + NL + "                else" + NL + "                {" + NL + "                    consoleOut_";
  protected final String TEXT_210 = " = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));" + NL + "                    globalMap.putLocal(\"tLogRow_CONSOLE\",consoleOut_";
  protected final String TEXT_211 = ");" + NL + "                }" + NL + "" + NL + "                consoleOut_";
  protected final String TEXT_212 = ".println(strBuffer_";
  protected final String TEXT_213 = ".toString());" + NL + "                consoleOut_";
  protected final String TEXT_214 = ".flush();";
  protected final String TEXT_215 = NL + "                String[] row_";
  protected final String TEXT_216 = " = new String[";
  protected final String TEXT_217 = "];";
  protected final String TEXT_218 = NL + "                        if(";
  protected final String TEXT_219 = ".";
  protected final String TEXT_220 = " != null) { //";
  protected final String TEXT_221 = NL + "                    row_";
  protected final String TEXT_222 = "[";
  protected final String TEXT_223 = "]=";
  protected final String TEXT_224 = NL + "                            FormatterUtils.format_DateInUTC(";
  protected final String TEXT_225 = ".";
  protected final String TEXT_226 = ", ";
  protected final String TEXT_227 = ")";
  protected final String TEXT_228 = NL + "                                java.nio.charset.Charset.defaultCharset().decode(";
  protected final String TEXT_229 = ".";
  protected final String TEXT_230 = ").toString()";
  protected final String TEXT_231 = NL + "                                java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_232 = ".";
  protected final String TEXT_233 = ")).toString()";
  protected final String TEXT_234 = NL + "                            ";
  protected final String TEXT_235 = ".toPlainString()";
  protected final String TEXT_236 = NL + "                            FormatterUtils.formatUnwithE(";
  protected final String TEXT_237 = ".";
  protected final String TEXT_238 = ")";
  protected final String TEXT_239 = NL + "                            String.valueOf(";
  protected final String TEXT_240 = ".";
  protected final String TEXT_241 = ")";
  protected final String TEXT_242 = NL + "                    ;";
  protected final String TEXT_243 = NL + "                        } //";
  protected final String TEXT_244 = NL + "                       util_";
  protected final String TEXT_245 = ".addRow(row_";
  protected final String TEXT_246 = ");";
  protected final String TEXT_247 = NL + "                       nb_line_";
  protected final String TEXT_248 = "++;" + NL + "                       consoleOut_";
  protected final String TEXT_249 = ".println(util_";
  protected final String TEXT_250 = ".print(row_";
  protected final String TEXT_251 = ",nb_line_";
  protected final String TEXT_252 = "));" + NL + "                    consoleOut_";
  protected final String TEXT_253 = ".flush();";
  protected final String TEXT_254 = NL + "        }" + NL + "        reader_";
  protected final String TEXT_255 = ".close();" + NL + "    }" + NL + "}" + NL;
  protected final String TEXT_256 = NL + "    java.io.PrintStream consoleOut_";
  protected final String TEXT_257 = " = null;" + NL + "    if (globalMap.getLocal(\"tLogRow_CONSOLE\")!=null)" + NL + "    {" + NL + "        consoleOut_";
  protected final String TEXT_258 = " = (java.io.PrintStream) globalMap.getLocal(\"tLogRow_CONSOLE\");" + NL + "    }" + NL + "    else" + NL + "    {" + NL + "        consoleOut_";
  protected final String TEXT_259 = " = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));" + NL + "        globalMap.putLocal(\"tLogRow_CONSOLE\",consoleOut_";
  protected final String TEXT_260 = ");" + NL + "    }" + NL + "" + NL + "    consoleOut_";
  protected final String TEXT_261 = ".println(util_";
  protected final String TEXT_262 = ".format().toString());" + NL + "    consoleOut_";
  protected final String TEXT_263 = ".flush();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
if (metadatas == null || metadatas.size() == 0)
    return "";

IMetadataTable metadata = metadatas.get(0);
if (metadata == null)
    return "";

List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
if(inConns == null || inConns.size() == 0)

    return "";
IConnection inConn = inConns.get(0);

String connName = inConn.getName();
String connTypeName = codeGenArgument.getRecordStructName(inConn);

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

String printUniqueName = ElementParameterParser.getValue(node,"__PRINT_UNIQUE_NAME__");
String printColumnNames = ElementParameterParser.getValue(node,"__PRINT_COLNAMES__");
String useFixedLength = ElementParameterParser.getValue(node,"__USE_FIXED_LENGTH__");
List<Map<String, String>> lengths = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__LENGTHS__");

List<IMetadataColumn> columns = metadata.getListColumns();
int sizeColumns = columns.size();

// Prepare to print the output depending on the type of table.

if(tablePrint) { // table display mode
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    for(int i=0;i< columns.size();i++){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(columns.get(i).getLabel() );
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    
}
if(vertical) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
}
if(basic) {// basic display mode

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIELDSEPARATOR__") );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
    if (("true").equals(printHeader)) {
    
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
        for (int i = 0; i < sizeColumns; i++) {
        IMetadataColumn column = columns.get(i);
        
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_27);
    
            if(i == sizeColumns-1) break;
            
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
        }
        
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
    }
}

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
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
    
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(talendTypeToAvroType.get(javaType));
    stringBuffer.append(TEXT_44);
    
    } else {
    
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
        if (javaType.getLabel().equals("List")){
            
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
            for (String type: new java.util.HashSet<String>(talendTypeToAvroType.values())) {
                
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_51);
    
            }
            
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
        } else if (talendTypeToAvroType.containsKey(javaType)) {
            
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(talendTypeToAvroType.get(javaType));
    stringBuffer.append(TEXT_59);
    
        } else {
            for (String type: new java.util.HashSet<String>(talendTypeToAvroType.values())) {
                
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_62);
    
            }
        }
        
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
        }
}

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
boolean useConfigurationComponent = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_STORAGE_CONFIGURATION__"));
String uriPrefix = "\"\"";
if(useConfigurationComponent) {
    uriPrefix = org.talend.designer.spark.generator.storage.SparkStorageUtils.getURIPrefix(node);
}
if(!"\"\"".equals(uriPrefix)) {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(uriPrefix);
    stringBuffer.append(TEXT_79);
    
}

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
            // Spark compatibility
            if (!"MR".equals(node.getComponent().getType())) {
                
    stringBuffer.append(TEXT_82);
    
            } else {
                
    stringBuffer.append(TEXT_83);
    
            }
            
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
            for(IMetadataColumn column : columns){
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                String objectTypeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), true);
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
                
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    if(javaType == JavaTypesManager.STRING) {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    } else if(javaType == JavaTypesManager.BYTE) {
    stringBuffer.append(TEXT_113);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    } else if(javaType == JavaTypesManager.SHORT) {
    stringBuffer.append(TEXT_117);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    } else if(javaType == JavaTypesManager.CHARACTER) {
    stringBuffer.append(TEXT_121);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
                        // Avro metadata table compatibility
                        if (codeGenArgument.getRecordStructGenerator().isByteArrayWrappedInBuffer()) {
    stringBuffer.append(TEXT_125);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    } else {
    stringBuffer.append(TEXT_129);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    }
    } else if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_133);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    } else if(javaType == JavaTypesManager.DATE) {
    stringBuffer.append(TEXT_137);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    } else {
    stringBuffer.append(TEXT_141);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(objectTypeToGenerate);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    }
    if(defaultValue!=null && defaultValue.length()>0){
    stringBuffer.append(TEXT_146);
    if(null != defaultValue && !"null".equals(defaultValue) && !defaultValue.trim().toLowerCase().endsWith("d") && javaType == JavaTypesManager.DOUBLE) {
    stringBuffer.append(TEXT_147);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_150);
    } else if(null != defaultValue && !"null".equals(defaultValue) && !defaultValue.trim().toLowerCase().endsWith("f") && javaType == JavaTypesManager.FLOAT) {
    stringBuffer.append(TEXT_151);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_154);
    } else if(null != defaultValue && !"null".equals(defaultValue) && !defaultValue.trim().toLowerCase().endsWith("l") && javaType == JavaTypesManager.LONG) {
    stringBuffer.append(TEXT_155);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_158);
    } else {
    stringBuffer.append(TEXT_159);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_162);
    }
    }
    stringBuffer.append(TEXT_163);
    
            }
            if (basic||vertical) {  // don't print the table form//***
            
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
                if (("true").equals(printUniqueName)) {//print the component name.
                
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    
                }
                for (int i = 0; i < sizeColumns; i++) {//5
                    IMetadataColumn column = columns.get(i);
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    if (("true").equals(useFixedLength)) {//fix the column length
                    
    stringBuffer.append(TEXT_169);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    
                    }
                    if (("true").equals(printColumnNames)) {//print the schema name
                    
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_174);
    
                    }
                    boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
                    if(!isPrimitive) { //begin
                    
    stringBuffer.append(TEXT_175);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_177);
    
                    }
                    
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    
                        if (("true").equals(useFixedLength)) {//fixed the column length
                        
    stringBuffer.append(TEXT_180);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(lengths.get(i).get("LENGTH") );
    stringBuffer.append(TEXT_183);
    
                        }
                        
    
                            String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                            if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date
                                
    stringBuffer.append(TEXT_184);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_186);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_187);
    
                            } else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]
                               // Avro metadata table compatibility
                                if (codeGenArgument.getRecordStructGenerator().isByteArrayWrappedInBuffer()) {
    stringBuffer.append(TEXT_188);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_190);
    } else {
    stringBuffer.append(TEXT_191);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_193);
    }
    
                            } else if (javaType == JavaTypesManager.BIGDECIMAL) {
                            
    stringBuffer.append(TEXT_194);
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_195);
    
                            } else if (javaType == JavaTypesManager.DOUBLE || javaType == JavaTypesManager.FLOAT ) {
                            
    stringBuffer.append(TEXT_196);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_198);
    
                            } else {//others
                            
    stringBuffer.append(TEXT_199);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_201);
    
                            }
                            
    
                        if (("true").equals(useFixedLength)) {//fixed the column length
                        
    stringBuffer.append(TEXT_202);
    
                        }
                        
    stringBuffer.append(TEXT_203);
    
                    if(!isPrimitive) {//end
                    
    stringBuffer.append(TEXT_204);
    
                    }
                    if(i == sizeColumns-1) break;
                    
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIELDSEPARATOR__") );
    stringBuffer.append(TEXT_207);
    
                }
            }
            if (basic) {
            
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    
            }
            if(tablePrint || vertical) { //print the table and vertical model//***
            
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_217);
    
                for (int i = 0; i < sizeColumns; i++) {//5

                    IMetadataColumn column = columns.get(i);
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
                    if(!isPrimitive) { //begin
                    
    stringBuffer.append(TEXT_218);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_220);
    
                    }
                    
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_223);
    
                        String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                        if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date
                        
    stringBuffer.append(TEXT_224);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_226);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_227);
    
                        } else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]
                            // Avro metadata table compatibility
                            if (codeGenArgument.getRecordStructGenerator().isByteArrayWrappedInBuffer()) {
                                
    stringBuffer.append(TEXT_228);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_230);
    
                            } else {
                                
    stringBuffer.append(TEXT_231);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_233);
    
                            }
                        } else if (javaType == JavaTypesManager.BIGDECIMAL) {
                        
    stringBuffer.append(TEXT_234);
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_235);
    
                        } else if (javaType == JavaTypesManager.DOUBLE || javaType == JavaTypesManager.FLOAT ) {
                        
    stringBuffer.append(TEXT_236);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_238);
    
                        } else {//others
                        
    stringBuffer.append(TEXT_239);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_241);
    
                        }
                        
    stringBuffer.append(TEXT_242);
    
                    if(!isPrimitive) { //end
                    
    stringBuffer.append(TEXT_243);
    
                    }
                }//5
                if(tablePrint){
                   
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    
                   }else{
                   
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    
                   }
            }
            
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    
if (tablePrint) {
    
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    
}

    return stringBuffer.toString();
  }
}
