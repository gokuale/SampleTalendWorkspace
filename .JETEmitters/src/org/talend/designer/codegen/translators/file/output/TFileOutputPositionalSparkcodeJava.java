package org.talend.designer.codegen.translators.file.output;

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

public class TFileOutputPositionalSparkcodeJava
{
  protected static String nl;
  public static synchronized TFileOutputPositionalSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputPositionalSparkcodeJava result = new TFileOutputPositionalSparkcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "        public static class ";
  protected final String TEXT_3 = "StructOutputFormat extends FileOutputFormat<NullWritable, ";
  protected final String TEXT_4 = "> {" + NL + "" + NL + "            private ContextProperties context;" + NL + "" + NL + "            protected static class HDFSRecordWriter implements RecordWriter<NullWritable, ";
  protected final String TEXT_5 = "> {" + NL + "        \t\tprotected DataOutputStream out;" + NL + "        \t\tprivate ContextProperties context;" + NL + "" + NL + "        \t\tpublic HDFSRecordWriter(DataOutputStream out, JobConf job) {" + NL + "        \t\t\tthis.out = out;" + NL + "        \t\t\tthis.context = new ContextProperties(job);" + NL + "        \t\t}" + NL + "" + NL + "        \t\tprivate void writeObject(";
  protected final String TEXT_6 = " value) throws IOException {" + NL + "        \t\t\tStringBuilder sb_";
  protected final String TEXT_7 = " = new StringBuilder();" + NL + "        \t\t\tString tempStringM";
  protected final String TEXT_8 = ";" + NL + "        \t\t\tint tempLengthM";
  protected final String TEXT_9 = " = 0;" + NL + "        \t\t\t";
  protected final String TEXT_10 = NL + "                            tempStringM";
  protected final String TEXT_11 = " = String.valueOf(value.";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "                            if (value.";
  protected final String TEXT_14 = " != null) {";
  protected final String TEXT_15 = NL + "                                    tempStringM";
  protected final String TEXT_16 = " = FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_17 = ", ";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "                                    tempStringM";
  protected final String TEXT_20 = " = java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(value.";
  protected final String TEXT_21 = ")).toString();";
  protected final String TEXT_22 = NL + "                                    tempStringM";
  protected final String TEXT_23 = " = value.";
  protected final String TEXT_24 = ";";
  protected final String TEXT_25 = NL + "                                        tempStringM";
  protected final String TEXT_26 = " = FormatterUtils.format_Number(";
  protected final String TEXT_27 = ".toPlainString(), ";
  protected final String TEXT_28 = ", ";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "                                        tempStringM";
  protected final String TEXT_31 = " = FormatterUtils.format_Number(String.valueOf(value.";
  protected final String TEXT_32 = "), ";
  protected final String TEXT_33 = ", ";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "                                    tempStringM";
  protected final String TEXT_36 = " = ";
  protected final String TEXT_37 = ".toPlainString();";
  protected final String TEXT_38 = NL + "                                    tempStringM";
  protected final String TEXT_39 = " = String.valueOf(value.";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "                            } else {" + NL + "                                tempStringM";
  protected final String TEXT_42 = " = \"\";" + NL + "                            }";
  protected final String TEXT_43 = NL + "                            tempLengthM";
  protected final String TEXT_44 = "=tempStringM";
  protected final String TEXT_45 = ".getBytes(";
  protected final String TEXT_46 = ").length;";
  protected final String TEXT_47 = NL + "                            tempLengthM";
  protected final String TEXT_48 = "=tempStringM";
  protected final String TEXT_49 = ".length();";
  protected final String TEXT_50 = NL + NL + "                        if (tempLengthM";
  protected final String TEXT_51 = " >= ";
  protected final String TEXT_52 = ") {";
  protected final String TEXT_53 = NL + "                                sb_";
  protected final String TEXT_54 = ".append(tempStringM";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "                                     byteArray_";
  protected final String TEXT_57 = "=arrays_";
  protected final String TEXT_58 = ".copyOfRange(tempStringM";
  protected final String TEXT_59 = ".getBytes(";
  protected final String TEXT_60 = "),tempLengthM";
  protected final String TEXT_61 = " - ";
  protected final String TEXT_62 = ",tempLengthM";
  protected final String TEXT_63 = ");" + NL + "                                     sb_";
  protected final String TEXT_64 = ".append(new String(byteArray_";
  protected final String TEXT_65 = ",";
  protected final String TEXT_66 = "));";
  protected final String TEXT_67 = NL + "                                     sb_";
  protected final String TEXT_68 = ".append(tempStringM";
  protected final String TEXT_69 = ".substring(tempLengthM";
  protected final String TEXT_70 = "-";
  protected final String TEXT_71 = "));";
  protected final String TEXT_72 = NL + "                                int begin";
  protected final String TEXT_73 = "=(tempLengthM";
  protected final String TEXT_74 = "-";
  protected final String TEXT_75 = ")/2;";
  protected final String TEXT_76 = NL + "                                    byteArray_";
  protected final String TEXT_77 = "=arrays_";
  protected final String TEXT_78 = ".copyOfRange(tempStringM";
  protected final String TEXT_79 = ".getBytes(";
  protected final String TEXT_80 = "),begin";
  protected final String TEXT_81 = ",begin";
  protected final String TEXT_82 = "+";
  protected final String TEXT_83 = ");" + NL + "                                    sb_";
  protected final String TEXT_84 = ".append(new String(byteArray_";
  protected final String TEXT_85 = ",";
  protected final String TEXT_86 = "));";
  protected final String TEXT_87 = NL + "                                    sb_";
  protected final String TEXT_88 = ".append(tempStringM";
  protected final String TEXT_89 = ".substring(begin";
  protected final String TEXT_90 = ", begin";
  protected final String TEXT_91 = "+";
  protected final String TEXT_92 = "));";
  protected final String TEXT_93 = NL + "                                    byteArray_";
  protected final String TEXT_94 = "=arrays_";
  protected final String TEXT_95 = ".copyOfRange(tempStringM";
  protected final String TEXT_96 = ".getBytes(";
  protected final String TEXT_97 = "),0,";
  protected final String TEXT_98 = ");" + NL + "                                    sb_";
  protected final String TEXT_99 = ".append(new String(byteArray_";
  protected final String TEXT_100 = ",";
  protected final String TEXT_101 = "));";
  protected final String TEXT_102 = NL + "                                    sb_";
  protected final String TEXT_103 = ".append(tempStringM";
  protected final String TEXT_104 = ".substring(0, ";
  protected final String TEXT_105 = "));";
  protected final String TEXT_106 = NL + "                        } else if (tempLengthM";
  protected final String TEXT_107 = "<";
  protected final String TEXT_108 = ") {";
  protected final String TEXT_109 = NL + "                                sb_";
  protected final String TEXT_110 = ".append(tempStringM";
  protected final String TEXT_111 = ");" + NL + "                                for(int i_";
  protected final String TEXT_112 = "=0; i_";
  protected final String TEXT_113 = "< ";
  protected final String TEXT_114 = "-tempLengthM";
  protected final String TEXT_115 = "; i_";
  protected final String TEXT_116 = "++){" + NL + "                                    sb_";
  protected final String TEXT_117 = ".append(";
  protected final String TEXT_118 = ");" + NL + "                                }";
  protected final String TEXT_119 = NL + "                                for(int i_";
  protected final String TEXT_120 = "=0; i_";
  protected final String TEXT_121 = "< ";
  protected final String TEXT_122 = "-tempLengthM";
  protected final String TEXT_123 = "; i_";
  protected final String TEXT_124 = "++){" + NL + "                                    sb_";
  protected final String TEXT_125 = ".append(";
  protected final String TEXT_126 = ");" + NL + "                                }" + NL + "                                sb_";
  protected final String TEXT_127 = ".append(tempStringM";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "                                int temp";
  protected final String TEXT_130 = "= (";
  protected final String TEXT_131 = "-tempLengthM";
  protected final String TEXT_132 = ")/2;" + NL + "                                for(int i_";
  protected final String TEXT_133 = "=0;i_";
  protected final String TEXT_134 = "<temp";
  protected final String TEXT_135 = ";i_";
  protected final String TEXT_136 = "++){" + NL + "                                    sb_";
  protected final String TEXT_137 = ".append(";
  protected final String TEXT_138 = ");" + NL + "                                }" + NL + "                                sb_";
  protected final String TEXT_139 = ".append(tempStringM";
  protected final String TEXT_140 = ");" + NL + "                                for(int i=temp";
  protected final String TEXT_141 = "+tempLengthM";
  protected final String TEXT_142 = ";i<";
  protected final String TEXT_143 = ";i++){" + NL + "                                    sb_";
  protected final String TEXT_144 = ".append(";
  protected final String TEXT_145 = ");" + NL + "                                }";
  protected final String TEXT_146 = NL + "                        }" + NL + "                        //get  and format output String end" + NL;
  protected final String TEXT_147 = NL + "        \t\t\tthis.out.write(sb_";
  protected final String TEXT_148 = ".toString().getBytes(";
  protected final String TEXT_149 = "));" + NL + "        \t\t} // writeObject" + NL + "" + NL + "        \t\tpublic synchronized void write(NullWritable key, ";
  protected final String TEXT_150 = " value)" + NL + "        \t\t\t\tthrows IOException {" + NL + "" + NL + "        \t\t\tboolean nullValue = value == null;" + NL + "        \t\t\tif (nullValue) {" + NL + "        \t\t\t\treturn;" + NL + "        \t\t\t} else {" + NL + "        \t\t\t\twriteObject(value);" + NL + "        \t\t\t}" + NL + "        \t\t\tout.write(";
  protected final String TEXT_151 = ".getBytes(";
  protected final String TEXT_152 = "));" + NL + "        \t\t}" + NL + "" + NL + "        \t\tpublic synchronized void close(Reporter reporter) throws IOException {" + NL + "        \t\t\tout.close();" + NL + "        \t\t}" + NL + "        \t} // HDFS RecordReader" + NL + "" + NL + "        \tpublic RecordWriter<NullWritable, ";
  protected final String TEXT_153 = "> getRecordWriter(" + NL + "        \t\t\tFileSystem ignored, JobConf job, String name, Progressable progress) throws IOException{" + NL + "                this.context = new ContextProperties(job);" + NL + "" + NL + "" + NL + "        \t\t";
  protected final String TEXT_154 = NL + "        \t\t\tPath file = FileOutputFormat.getTaskOutputPath(job, name);" + NL + "        \t\t\tFileSystem fs = file.getFileSystem(job);" + NL + "        \t\t\tDataOutputStream fileOut = fs.create(file, progress);" + NL + "        \t\t\t";
  protected final String TEXT_155 = NL + "        \t\t\t\tCompressionCodec codec = ReflectionUtils.newInstance(org.apache.hadoop.io.compress.GzipCodec.class," + NL + "        \t\t\t\t\t\tjob);" + NL + "        \t\t\t\t";
  protected final String TEXT_156 = NL + "        \t\t\t\tCompressionCodec codec = ReflectionUtils.newInstance(org.apache.hadoop.io.compress.BZip2Codec.class," + NL + "        \t\t\t\t\t\tjob);" + NL + "        \t\t\t\t";
  protected final String TEXT_157 = NL + "        \t\t\t// build the filename including the extension" + NL + "        \t\t\tPath file = FileOutputFormat.getTaskOutputPath(job," + NL + "        \t\t\t\t\tname + codec.getDefaultExtension());" + NL + "        \t\t\tFileSystem fs = file.getFileSystem(job);" + NL + "        \t\t\tDataOutputStream fileOut = new DataOutputStream(" + NL + "        \t\t\t\t\tcodec.createOutputStream(fs.create(file, progress)));" + NL + "        \t\t\t";
  protected final String TEXT_158 = NL + "        \t\t\t" + NL + "        \t\t\tfileOut.write(\"";
  protected final String TEXT_159 = "\".getBytes(";
  protected final String TEXT_160 = "));" + NL + "        \t\t\tfileOut.write(";
  protected final String TEXT_161 = ".getBytes(";
  protected final String TEXT_162 = "));" + NL + "\t\t\t\t    ";
  protected final String TEXT_163 = NL + "        \t\t\tStringBuilder headerBuilder_";
  protected final String TEXT_164 = " = new StringBuilder();" + NL + "        \t\t";
  protected final String TEXT_165 = NL + "        \t\t\t\t\t\theaderBuilder_";
  protected final String TEXT_166 = ".append(\"";
  protected final String TEXT_167 = "\");" + NL + "        \t\t\t\t\t";
  protected final String TEXT_168 = NL + "        \t\t\t\t\t\theaderBuilder_";
  protected final String TEXT_169 = ".append(\"";
  protected final String TEXT_170 = "\");" + NL + "        \t\t\t\t\t";
  protected final String TEXT_171 = NL + "        \t\t\t\t\t\theaderBuilder_";
  protected final String TEXT_172 = ".append(\"";
  protected final String TEXT_173 = "\");" + NL + "        \t\t\t\t\t";
  protected final String TEXT_174 = NL + "        \t\t\t\t\t\theaderBuilder_";
  protected final String TEXT_175 = ".append(\"";
  protected final String TEXT_176 = "\");" + NL + "        \t\t\t\t\t";
  protected final String TEXT_177 = NL + "\t\t\t\t\t\t\t\theaderBuilder_";
  protected final String TEXT_178 = ".append(\"";
  protected final String TEXT_179 = "\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_180 = NL + "\t\t\t\t\t\t\t\t\theaderBuilder_";
  protected final String TEXT_181 = ".append(";
  protected final String TEXT_182 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_183 = NL + "\t\t\t\t\t\t\t\t\theaderBuilder_";
  protected final String TEXT_184 = ".append(";
  protected final String TEXT_185 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_186 = NL + "\t\t\t\t\t\t\t\theaderBuilder_";
  protected final String TEXT_187 = ".append(\"";
  protected final String TEXT_188 = "\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_189 = NL + "\t\t\t\t\t\t\t\t\theaderBuilder_";
  protected final String TEXT_190 = ".append(";
  protected final String TEXT_191 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_192 = NL + "\t\t\t\t\t\t\t\theaderBuilder_";
  protected final String TEXT_193 = ".append(\"";
  protected final String TEXT_194 = "\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_195 = NL + "\t\t\t\t\t\t\t\t\theaderBuilder_";
  protected final String TEXT_196 = ".append(";
  protected final String TEXT_197 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_198 = NL + "        \t\t\t\tfileOut.write(headerBuilder_";
  protected final String TEXT_199 = ".toString().getBytes(";
  protected final String TEXT_200 = "));" + NL + "        \t\t\t\tfileOut.write(";
  protected final String TEXT_201 = ".getBytes(";
  protected final String TEXT_202 = "));" + NL + "        \t\t\t";
  protected final String TEXT_203 = NL + "\t\t\t\treturn new HDFSRecordWriter(fileOut, job);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();  
String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
if(metadatas != null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    if(metadata != null){
        List<Map<String, String>> formats =
                (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FORMATS__");
        String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");
        String fieldSeparator = ElementParameterParser.getValue(node,"__FIELDSEPARATOR__");
        boolean includeHeader = "true".equals(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
        boolean includeSeparator = "true".equals(ElementParameterParser.getValue(node, "__INCLUDESEPARATOR__")) && includeHeader;
        boolean customEncoding = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_ENCODING__"));
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");

        String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
        boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
        String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
        String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

        boolean compress = "true".equals(ElementParameterParser.getValue(node, "__COMPRESS__"));
        String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");
        boolean merge = "true".equals(ElementParameterParser.getValue(node, "__MERGE_RESULT__"));

        boolean useByte = ("true").equals(ElementParameterParser.getValue(node, "__USE_BYTE__"));


        List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
        if(inConns == null || inConns.size() == 0) {
            return "";
        }
        IConnection inConn = inConns.get(0); 
        String connName = inConn.getName();
        String connTypeName = codeGenArgument.getRecordStructName(inConn);

        List<IMetadataColumn> columns = metadata.getListColumns();
        int columnSize = columns.size();
        
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
        			for (int i = 0; i < columnSize; i++) {
        			    IMetadataColumn column = columns.get(i);
                        Map<String,String> format=formats.get(i);
        			    String columnName = column.getLabel();
        			    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
        			    String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
        			    boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());

        			    //get  and format output String begin

                        if(isPrimitive) {
                            
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_12);
    
                        } else {
                            
    stringBuffer.append(TEXT_13);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_14);
    
                                if(javaType == JavaTypesManager.DATE && pattern!=null){
                                    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_18);
    
                                }else if(javaType == JavaTypesManager.BYTE_ARRAY){
                                    
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_21);
    
                                }else if(javaType == JavaTypesManager.STRING){
                                    
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_24);
    
                                } else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
                                    if (javaType == JavaTypesManager.BIGDECIMAL) {
                                        
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getPrecision() == null? "value" + "." + column.getLabel() : "value" + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_29);
    
                                    } else {
                                        
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_34);
    
                                    }
                                } else if (javaType == JavaTypesManager.BIGDECIMAL) {
                                    
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(column.getPrecision() == null ? "value" + "." + column.getLabel() : "value" + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_37);
    
                                } else {
                                    
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_40);
    
                                }
                                
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
                        }

                        if (useByte) {
                            
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_46);
    
                        }else{
                            
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    
                        }
                        
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_52);
    
                            if (("\'A\'").equals(format.get("KEEP"))) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    
                            } else if (("\'R\'").equals(format.get("KEEP"))) {
                                 if(useByte){
                                     
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_66);
    
                                 }else{
                                     
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_71);
    
                                 }
                            } else if (("\'M\'").equals(format.get("KEEP"))) {
                                
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_75);
    
                                if(useByte){
                                    
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_86);
    
                                }else{
                                    
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_92);
    
                                }
                            } else {
                                if(useByte){
                                    
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_101);
    
                                }else{
                                    
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_105);
    
                                }
                            }
                            
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_108);
    
                            if (("\'L\'").equals(format.get("ALIGN"))) {
                                
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_118);
    
                            } else if (("\'R\'").equals(format.get("ALIGN"))) {
                                
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    
                            } else {
                                
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_145);
    
                            }
                            
    stringBuffer.append(TEXT_146);
    
        			} // For

        			
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_153);
    
        		if (!compress || merge) {
        		    
    stringBuffer.append(TEXT_154);
    
        		} else {

        			if("GZIP".equals(compression)){
        				
    stringBuffer.append(TEXT_155);
    
        			}else if("BZIP2".equals(compression)){
        				
    stringBuffer.append(TEXT_156);
    
        			}
        			
    stringBuffer.append(TEXT_157);
    
        		}
        		
        		if(includeSeparator) {
        			String header = "";
        			int iterator = 1;
        			for(IMetadataColumn columnForHeader : columns){
        				header += columnForHeader.getLabel() + (iterator!=columns.size() ? fieldSeparator.substring(1, fieldSeparator.length() - 1) : "");
        				iterator++;
        			}
        			
    stringBuffer.append(TEXT_158);
    stringBuffer.append(header);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_162);
    
        		} else if (includeHeader) {
        		
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    
        			for(int i=0; i<columns.size(); i++) {
        				String initialColumnName = columns.get(i).getLabel();
        				Map<String,String> format = formats.get(i);
        				int size = Integer.parseInt(format.get("SIZE"));
        				if(initialColumnName.length() >= size) {
        					if (("\'A\'").equals(format.get("KEEP"))) {
        					
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(initialColumnName);
    stringBuffer.append(TEXT_167);
    
        					} else if (("\'R\'").equals(format.get("KEEP"))) {
        					
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(initialColumnName.substring(initialColumnName.length()-size));
    stringBuffer.append(TEXT_170);
    
        					} else if (("\'M\'").equals(format.get("KEEP"))) {
        						int begin = (initialColumnName.length()-size)/2;
        					
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(initialColumnName.substring(begin, begin+size));
    stringBuffer.append(TEXT_173);
    
        					} else {
        					
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(initialColumnName.substring(0, size));
    stringBuffer.append(TEXT_176);
    
        					}
        				} else if(initialColumnName.length() < size) {
        					if (("\'L\'").equals(format.get("ALIGN"))) {
        					
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(initialColumnName);
    stringBuffer.append(TEXT_179);
    
								for(int j=0; j<size-initialColumnName.length(); j++){
								
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_182);
    
								}
        					} else if (("\'R\'").equals(format.get("ALIGN"))) {
								for(int j=0; j<size-initialColumnName.length(); j++){
								
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_185);
    
								}
								
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(initialColumnName);
    stringBuffer.append(TEXT_188);
    
        					} else {
								int center = (size-initialColumnName.length())/2;
								for(int j=0; j<center; j++){
								
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_191);
    
								}
								
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(initialColumnName);
    stringBuffer.append(TEXT_194);
    
								for(int j=center+initialColumnName.length(); j<size ;j++){
								
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_197);
    
								}	
        					}
        				}
        			} // end for
        			
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_202);
    
				}
			    
    stringBuffer.append(TEXT_203);
    
	}
}

    return stringBuffer.toString();
  }
}
