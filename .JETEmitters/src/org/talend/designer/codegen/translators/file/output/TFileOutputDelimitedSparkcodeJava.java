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

public class TFileOutputDelimitedSparkcodeJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedSparkcodeJava result = new TFileOutputDelimitedSparkcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "        private void writeObject(";
  protected final String TEXT_5 = " value) throws IOException {" + NL + "            StringBuilder sb = new StringBuilder();";
  protected final String TEXT_6 = NL + "                    if(value.";
  protected final String TEXT_7 = " != null){";
  protected final String TEXT_8 = NL + "                    sb.append(FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = "));";
  protected final String TEXT_11 = NL + "                        sb.append(FormatterUtils.format_Number(";
  protected final String TEXT_12 = ".toPlainString(), ";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = "));";
  protected final String TEXT_15 = NL + "                        sb.append(FormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(value.";
  protected final String TEXT_16 = ")).toPlainString(), ";
  protected final String TEXT_17 = ", ";
  protected final String TEXT_18 = "));                       ";
  protected final String TEXT_19 = NL + "                    sb.append(";
  protected final String TEXT_20 = ".toPlainString());";
  protected final String TEXT_21 = NL + "                    sb.append(java.nio.charset.Charset.forName(";
  protected final String TEXT_22 = ").decode(";
  protected final String TEXT_23 = "value.";
  protected final String TEXT_24 = ").toString());";
  protected final String TEXT_25 = NL + "                    sb.append(value.";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "                    }";
  protected final String TEXT_28 = NL + "                    sb.append(";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "            this.out.write(sb.toString().getBytes(";
  protected final String TEXT_31 = "));" + NL + "        }";
  protected final String TEXT_32 = NL + NL + "        private void writeObject(";
  protected final String TEXT_33 = " value) throws IOException {" + NL + "            StringBuilder sb = new StringBuilder();" + NL + "            String currentValue = null;";
  protected final String TEXT_34 = NL + "                    if(value.";
  protected final String TEXT_35 = " != null){";
  protected final String TEXT_36 = NL + "                    currentValue = FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_37 = ", ";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "                        currentValue = FormatterUtils.format_Number(";
  protected final String TEXT_40 = ".toPlainString(), ";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "                        currentValue = FormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(value.";
  protected final String TEXT_44 = ")).toPlainString(), ";
  protected final String TEXT_45 = ", ";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "                    currentValue = ";
  protected final String TEXT_48 = ".toPlainString();";
  protected final String TEXT_49 = NL + "                    currentValue = java.nio.charset.Charset.forName(";
  protected final String TEXT_50 = ").decode(java.nio.ByteBuffer.wrap(value.";
  protected final String TEXT_51 = ")).toString();";
  protected final String TEXT_52 = NL + "                    currentValue =  String.valueOf(value.";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "                    }";
  protected final String TEXT_55 = NL + "                sb.append('";
  protected final String TEXT_56 = "' + currentValue.replace(\"\" + '";
  protected final String TEXT_57 = "', \"\" + '";
  protected final String TEXT_58 = "' + '";
  protected final String TEXT_59 = "') + '";
  protected final String TEXT_60 = "');";
  protected final String TEXT_61 = NL + "                    sb.append(";
  protected final String TEXT_62 = ");";
  protected final String TEXT_63 = NL + "            this.out.write(sb.toString().getBytes(";
  protected final String TEXT_64 = "));" + NL + "        }";
  protected final String TEXT_65 = NL;
  protected final String TEXT_66 = NL + "\t\tpublic static class ";
  protected final String TEXT_67 = "StructOutputFormat extends FileOutputFormat<NullWritable, ";
  protected final String TEXT_68 = "> {" + NL + "" + NL + "\t\t\tprivate ContextProperties context;" + NL + "\t\t\t" + NL + "\t\t\tprotected static class HDFSRecordWriter implements RecordWriter<NullWritable, ";
  protected final String TEXT_69 = "> {" + NL + "\t\t\t\tprotected DataOutputStream out;" + NL + "\t\t\t\tprivate ContextProperties context;" + NL + "" + NL + "\t\t\t\tpublic HDFSRecordWriter(DataOutputStream out, JobConf job) {" + NL + "\t\t\t\t\tthis.out = out;" + NL + "\t\t\t\t\tthis.context = new ContextProperties(job);" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_70 = NL + NL + "\t\t\t\tpublic synchronized void write(NullWritable key, ";
  protected final String TEXT_71 = " value)" + NL + "\t\t\t\t\t\tthrows IOException {" + NL + "\t\t\t\t\tif (value == null) {" + NL + "\t\t\t\t\t\treturn;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\twriteObject(value);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tout.write(";
  protected final String TEXT_72 = ".getBytes(";
  protected final String TEXT_73 = "));" + NL + "\t\t\t\t}" + NL + "\t" + NL + "\t\t\t\tpublic synchronized void close(Reporter reporter) throws IOException {" + NL + "\t\t\t\t\tout.close();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\tpublic RecordWriter<NullWritable, ";
  protected final String TEXT_74 = "> getRecordWriter(" + NL + "\t\t\t\t\tFileSystem ignored, JobConf job, String name, Progressable progress) throws IOException{" + NL + "\t\t\t\t\tthis.context = new ContextProperties(job);" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\t\t\tPath file = FileOutputFormat.getTaskOutputPath(job, name);" + NL + "\t\t\t\t\tFileSystem fs = file.getFileSystem(job);" + NL + "\t\t\t\t\tDataOutputStream fileOut = fs.create(file, progress);" + NL + "\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\tCompressionCodec codec = ReflectionUtils.newInstance(org.apache.hadoop.io.compress.GzipCodec.class," + NL + "\t\t\t\t\t\t\tjob);" + NL + "\t\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\tCompressionCodec codec = ReflectionUtils.newInstance(org.apache.hadoop.io.compress.BZip2Codec.class," + NL + "\t\t\t\t\t\t\tjob);" + NL + "\t\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\t// build the filename including the extension" + NL + "\t\t\t\t\tPath file = FileOutputFormat.getTaskOutputPath(job," + NL + "\t\t\t\t\t\t\tname + codec.getDefaultExtension());" + NL + "\t\t\t\t\tFileSystem fs = file.getFileSystem(job);" + NL + "\t\t\t\t\tDataOutputStream fileOut = new DataOutputStream(" + NL + "\t\t\t\t\t\t\tcodec.createOutputStream(fs.create(file, progress)));" + NL + "\t\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\t\tfileOut.write(\"";
  protected final String TEXT_82 = "\".getBytes(";
  protected final String TEXT_83 = "));" + NL + "\t\t\t\t\tfileOut.write(";
  protected final String TEXT_84 = ".getBytes(";
  protected final String TEXT_85 = "));" + NL + "\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\treturn new HDFSRecordWriter(fileOut, job);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_87 = NL;
  protected final String TEXT_88 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    
class TFileOutputDelimitedUtil {
    public void writeRawFile(INode node, String connName, String connTypeName, List<IMetadataColumn> columns) {
        int columnSize = columns.size();
        String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
        boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
        String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
        String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
        String fieldSeparator = ElementParameterParser.getValue(node,"__FIELDSEPARATOR__");
        boolean customEncoding = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_ENCODING__"));
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
        boolean isSpark = ("SPARKSTREAMING".equals(node.getComponent().getType()) || "SPARK".equals(node.getComponent().getType()));
        
        
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_5);
    
            for (int i = 0; i < columnSize; i++) {
                IMetadataColumn column = columns.get(i);
                String columnName = column.getLabel();
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
                if(!isPrimitive){
                
    stringBuffer.append(TEXT_6);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_7);
    
                }
                if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0){
                    
    stringBuffer.append(TEXT_8);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_10);
    
                }else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())){ 
                    if(javaType == JavaTypesManager.BIGDECIMAL){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(column.getPrecision() == null? "value." + columnName : "value." + columnName + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_14);
    }else{
    stringBuffer.append(TEXT_15);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_18);
    }
                } else if(javaType == JavaTypesManager.BIGDECIMAL){
                
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getPrecision() == null ? "value." + columnName : "value." + columnName + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_20);
    
                } else if(javaType == JavaTypesManager.BYTE_ARRAY){
                
    stringBuffer.append(TEXT_21);
    stringBuffer.append(customEncoding?encoding:"utf8Charset" );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(isSpark?"":"java.nio.ByteBuffer.wrap(");
    stringBuffer.append(TEXT_23);
    stringBuffer.append(columnName);
    stringBuffer.append(isSpark?"":")");
    stringBuffer.append(TEXT_24);
    
                } else {
                
    stringBuffer.append(TEXT_25);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_26);
    
                }
                if(!isPrimitive){
                
    stringBuffer.append(TEXT_27);
    
                }
                if(i < columnSize-1){
    stringBuffer.append(TEXT_28);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_29);
    }
    
            }
            
    stringBuffer.append(TEXT_30);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_31);
    
    }

    public void writeCSVFile(INode node, String connName, String connTypeName, List<IMetadataColumn> columns) {
        int columnSize = columns.size();
        String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
        boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
        String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
        String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
        String fieldSeparator = ElementParameterParser.getValue(node,"__FIELDSEPARATOR__");
        boolean customEncoding = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_ENCODING__"));
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
        String escapeChar = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
        if(("").equals(escapeChar)){
            escapeChar = "\"\"";
        }
//        if(("\"\"\"").equals(escapeChar)){
//            escapeChar = "\"\\\"\"";
//        }

        escapeChar = escapeChar.substring(1, escapeChar.length() - 1);
        if(("'").equals(escapeChar)){
            escapeChar = "\\'";
        }

        String textEnclosure = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
        if(("").equals(textEnclosure)){
            textEnclosure = "\"\"";
        }
//        if(("\"\"\"").equals(textEnclosure)){
//            textEnclosure = "\"\\\"\"";
//        }

        textEnclosure = textEnclosure.substring(1, textEnclosure.length() - 1);
        if ("".equals(textEnclosure)) {
            textEnclosure = "\0";
        } else if (("'").equals(textEnclosure)) {
            textEnclosure = "\\'";
        }
        
    stringBuffer.append(TEXT_32);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_33);
    
            for (int i = 0; i < columnSize; i++) {
                IMetadataColumn column = columns.get(i);
                String columnName = column.getLabel();
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
                if(!isPrimitive){
                
    stringBuffer.append(TEXT_34);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_35);
    
                }
                if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0){
                    
    stringBuffer.append(TEXT_36);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_38);
    
                }else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())){ 
                    if(javaType == JavaTypesManager.BIGDECIMAL){
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getPrecision() == null? "value." + columnName : "value." + columnName + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_41);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_42);
    }else{
    stringBuffer.append(TEXT_43);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_45);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_46);
    }
                } else if(javaType == JavaTypesManager.BIGDECIMAL){
                
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getPrecision() == null ? "value." + columnName : "value." + columnName + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_48);
    
                } else if(javaType == JavaTypesManager.BYTE_ARRAY){
                
    stringBuffer.append(TEXT_49);
    stringBuffer.append(customEncoding?encoding:"utf8Charset" );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_51);
    
                } else {
                
    stringBuffer.append(TEXT_52);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_53);
    
                }
                if(!isPrimitive){
                
    stringBuffer.append(TEXT_54);
    
                }
                
    stringBuffer.append(TEXT_55);
    stringBuffer.append(textEnclosure);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(textEnclosure);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(escapeChar);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(textEnclosure);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(textEnclosure);
    stringBuffer.append(TEXT_60);
    
                if(i < columnSize-1){
    stringBuffer.append(TEXT_61);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_62);
    }
    
            }
            
    stringBuffer.append(TEXT_63);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_64);
    
    }
}

    stringBuffer.append(TEXT_65);
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();  
String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
if(metadatas != null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    if(metadata != null){
    
		String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");
		String fieldSeparator = ElementParameterParser.getValue(node,"__FIELDSEPARATOR__");
		boolean includeHeader = "true".equals(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
		boolean customEncoding = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_ENCODING__"));
		String encoding = ElementParameterParser.getValue(node,"__ENCODING__");

        boolean csvMode = "true".equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"));
        if (csvMode) {
            rowSeparator = ElementParameterParser.getValue(node, "__CSVROWSEPARATOR__");
        }
		
		boolean compress = "true".equals(ElementParameterParser.getValue(node, "__COMPRESS__"));
		String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");
		boolean merge = "true".equals(ElementParameterParser.getValue(node, "__MERGE_RESULT__"));
		
  		String connName = "";
  		String connTypeName = "";
        
	    List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
	    if(inConns != null && inConns.size() > 0){
	    	IConnection inConn = inConns.get(0); 
	        connName = inConn.getName();
	        connTypeName = codeGenArgument.getRecordStructName(inConn);
	    }else{
	        return "";
	    }

	    List<IMetadataColumn> columns = metadata.getListColumns();
	    int columnSize = columns.size();

	    TFileOutputDelimitedUtil tFileOutputDelimitedUtil = new TFileOutputDelimitedUtil();

	    
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_69);
    
				if (csvMode) {
	                tFileOutputDelimitedUtil.writeCSVFile(node, connName, connTypeName, columns);
				} else {
                    tFileOutputDelimitedUtil.writeRawFile(node, connName, connTypeName, columns);
				}
				
    stringBuffer.append(TEXT_70);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_74);
    if(!compress || merge){
    stringBuffer.append(TEXT_75);
    }else{
    stringBuffer.append(TEXT_76);
    
					if("GZIP".equals(compression)){
					
    stringBuffer.append(TEXT_77);
    
					}else if("BZIP2".equals(compression)){
					
    stringBuffer.append(TEXT_78);
    
					}
					
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    
				if(includeHeader){
					String header = "";
					int i = 1;
					for(IMetadataColumn column : columns){
						header += column.getLabel() + (i!=columns.size() ? fieldSeparator.substring(1,fieldSeparator.length()-1) : "");
						i++;
					}
					
    stringBuffer.append(TEXT_81);
    stringBuffer.append(header);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_85);
    }
    stringBuffer.append(TEXT_86);
    
	}
}   

    stringBuffer.append(TEXT_87);
    stringBuffer.append(TEXT_88);
    return stringBuffer.toString();
  }
}
