package org.talend.designer.codegen.translators.processing.fields;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TWritePositionalFieldsSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TWritePositionalFieldsSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWritePositionalFieldsSparkstreamingcodeJava result = new TWritePositionalFieldsSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "public static class ";
  protected final String TEXT_4 = " implements java.io.Serializable {" + NL + "" + NL + "\tprivate ContextProperties context;" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_5 = "(ContextProperties context) {" + NL + "\t\tthis.context = context;" + NL + "\t}" + NL + "\t" + NL + "\tpublic byte[] convert(";
  protected final String TEXT_6 = " value) {" + NL + "\t\tStringBuilder sb_";
  protected final String TEXT_7 = " = new StringBuilder();" + NL + "\t\tString tempStringM";
  protected final String TEXT_8 = ";" + NL + "\t\tint tempLengthM";
  protected final String TEXT_9 = " = 0;";
  protected final String TEXT_10 = NL + "\t\tsb_";
  protected final String TEXT_11 = ".append(\"";
  protected final String TEXT_12 = "\");" + NL + "\t\tsb_";
  protected final String TEXT_13 = ".append(";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\t\ttempStringM";
  protected final String TEXT_16 = " = String.valueOf(value.";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t\tif (value.";
  protected final String TEXT_19 = " != null) {";
  protected final String TEXT_20 = NL + "\t\t\ttempStringM";
  protected final String TEXT_21 = " = FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "\t\t\ttempStringM";
  protected final String TEXT_25 = " = java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(value.";
  protected final String TEXT_26 = ")).toString();";
  protected final String TEXT_27 = NL + "\t\t\ttempStringM";
  protected final String TEXT_28 = " = value.";
  protected final String TEXT_29 = ";";
  protected final String TEXT_30 = NL + "\t\t\ttempStringM";
  protected final String TEXT_31 = " = FormatterUtils.format_Number(";
  protected final String TEXT_32 = ".toPlainString(), ";
  protected final String TEXT_33 = ", ";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "\t\t\ttempStringM";
  protected final String TEXT_36 = " = FormatterUtils.format_Number(String.valueOf(value.";
  protected final String TEXT_37 = "), ";
  protected final String TEXT_38 = ", ";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\t\t\ttempStringM";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = ".toPlainString();";
  protected final String TEXT_43 = NL + "\t\t\ttempStringM";
  protected final String TEXT_44 = " = String.valueOf(value.";
  protected final String TEXT_45 = ");";
  protected final String TEXT_46 = NL + "\t\t} else {" + NL + "    \t\ttempStringM";
  protected final String TEXT_47 = " = \"\";" + NL + "\t\t}";
  protected final String TEXT_48 = NL + "\t\ttempLengthM";
  protected final String TEXT_49 = "=tempStringM";
  protected final String TEXT_50 = ".getBytes(";
  protected final String TEXT_51 = ").length;";
  protected final String TEXT_52 = NL + "\t\ttempLengthM";
  protected final String TEXT_53 = "=tempStringM";
  protected final String TEXT_54 = ".length();";
  protected final String TEXT_55 = NL + NL + "      if (tempLengthM";
  protected final String TEXT_56 = " >= ";
  protected final String TEXT_57 = ") {";
  protected final String TEXT_58 = NL + "\t\t\tsb_";
  protected final String TEXT_59 = ".append(tempStringM";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\t\t\tbyteArray_";
  protected final String TEXT_62 = "=arrays_";
  protected final String TEXT_63 = ".copyOfRange(tempStringM";
  protected final String TEXT_64 = ".getBytes(";
  protected final String TEXT_65 = "),tempLengthM";
  protected final String TEXT_66 = " - ";
  protected final String TEXT_67 = ",tempLengthM";
  protected final String TEXT_68 = ");" + NL + "\t\t\tsb_";
  protected final String TEXT_69 = ".append(new String(byteArray_";
  protected final String TEXT_70 = ",";
  protected final String TEXT_71 = "));";
  protected final String TEXT_72 = NL + "\t\t\tsb_";
  protected final String TEXT_73 = ".append(tempStringM";
  protected final String TEXT_74 = ".substring(tempLengthM";
  protected final String TEXT_75 = "-";
  protected final String TEXT_76 = "));";
  protected final String TEXT_77 = NL + "\t\t\tint begin";
  protected final String TEXT_78 = "=(tempLengthM";
  protected final String TEXT_79 = "-";
  protected final String TEXT_80 = ")/2;";
  protected final String TEXT_81 = NL + "\t\t\tbyteArray_";
  protected final String TEXT_82 = "=arrays_";
  protected final String TEXT_83 = ".copyOfRange(tempStringM";
  protected final String TEXT_84 = ".getBytes(";
  protected final String TEXT_85 = "),begin";
  protected final String TEXT_86 = ",begin";
  protected final String TEXT_87 = "+";
  protected final String TEXT_88 = ");" + NL + "\t\t\tsb_";
  protected final String TEXT_89 = ".append(new String(byteArray_";
  protected final String TEXT_90 = ",";
  protected final String TEXT_91 = "));";
  protected final String TEXT_92 = NL + "\t\t\tsb_";
  protected final String TEXT_93 = ".append(tempStringM";
  protected final String TEXT_94 = ".substring(begin";
  protected final String TEXT_95 = ", begin";
  protected final String TEXT_96 = "+";
  protected final String TEXT_97 = "));";
  protected final String TEXT_98 = NL + "\t\t\tbyteArray_";
  protected final String TEXT_99 = "=arrays_";
  protected final String TEXT_100 = ".copyOfRange(tempStringM";
  protected final String TEXT_101 = ".getBytes(";
  protected final String TEXT_102 = "),0,";
  protected final String TEXT_103 = ");" + NL + "\t\t\tsb_";
  protected final String TEXT_104 = ".append(new String(byteArray_";
  protected final String TEXT_105 = ",";
  protected final String TEXT_106 = "));";
  protected final String TEXT_107 = NL + "\t\t\tsb_";
  protected final String TEXT_108 = ".append(tempStringM";
  protected final String TEXT_109 = ".substring(0, ";
  protected final String TEXT_110 = "));";
  protected final String TEXT_111 = NL + "\t\t} else if (tempLengthM";
  protected final String TEXT_112 = "<";
  protected final String TEXT_113 = ") {";
  protected final String TEXT_114 = NL + "\t\t\tsb_";
  protected final String TEXT_115 = ".append(tempStringM";
  protected final String TEXT_116 = ");" + NL + "\t\t\tfor(int i_";
  protected final String TEXT_117 = "=0; i_";
  protected final String TEXT_118 = "< ";
  protected final String TEXT_119 = "-tempLengthM";
  protected final String TEXT_120 = "; i_";
  protected final String TEXT_121 = "++){" + NL + "\t\t\t\tsb_";
  protected final String TEXT_122 = ".append(";
  protected final String TEXT_123 = ");" + NL + "\t\t\t}";
  protected final String TEXT_124 = NL + "\t\t\tfor(int i_";
  protected final String TEXT_125 = "=0; i_";
  protected final String TEXT_126 = "< ";
  protected final String TEXT_127 = "-tempLengthM";
  protected final String TEXT_128 = "; i_";
  protected final String TEXT_129 = "++){" + NL + "\t\t\t\tsb_";
  protected final String TEXT_130 = ".append(";
  protected final String TEXT_131 = ");" + NL + "\t\t\t}" + NL + "\t\t\tsb_";
  protected final String TEXT_132 = ".append(tempStringM";
  protected final String TEXT_133 = ");";
  protected final String TEXT_134 = NL + "\t\t\tint temp";
  protected final String TEXT_135 = "= (";
  protected final String TEXT_136 = "-tempLengthM";
  protected final String TEXT_137 = ")/2;" + NL + "\t\t\tfor(int i_";
  protected final String TEXT_138 = "=0;i_";
  protected final String TEXT_139 = "<temp";
  protected final String TEXT_140 = ";i_";
  protected final String TEXT_141 = "++){" + NL + "\t\t\t\tsb_";
  protected final String TEXT_142 = ".append(";
  protected final String TEXT_143 = ");" + NL + "\t\t\t}" + NL + "\t\t\tsb_";
  protected final String TEXT_144 = ".append(tempStringM";
  protected final String TEXT_145 = ");" + NL + "\t\t\tfor(int i=temp";
  protected final String TEXT_146 = "+tempLengthM";
  protected final String TEXT_147 = ";i<";
  protected final String TEXT_148 = ";i++){" + NL + "\t\t\t\tsb_";
  protected final String TEXT_149 = ".append(";
  protected final String TEXT_150 = ");" + NL + "\t\t\t}";
  protected final String TEXT_151 = NL + "\t\t}" + NL + "//get  and format output String end" + NL;
  protected final String TEXT_152 = NL + "\t\ttry {" + NL + "\t\t\treturn sb_";
  protected final String TEXT_153 = ".toString().getBytes(";
  protected final String TEXT_154 = ");" + NL + "\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t} // end convert()\t" + NL + "" + NL + "} // end ";
  protected final String TEXT_155 = "_";
  protected final String TEXT_156 = "ToPositionalStringConverter class ";
  protected final String TEXT_157 = NL;
  protected final String TEXT_158 = NL;
  protected final String TEXT_159 = NL + NL + "public static class ";
  protected final String TEXT_160 = "_convertFunction<KEY> implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<KEY, ";
  protected final String TEXT_161 = ">, KEY,";
  protected final String TEXT_162 = "> {" + NL + "\t\t" + NL + "\tprivate ";
  protected final String TEXT_163 = " converter;" + NL + "\t" + NL + "\tpublic ";
  protected final String TEXT_164 = "_convertFunction(JobConf job){" + NL + "\t\tthis.converter = new ";
  protected final String TEXT_165 = "(new ContextProperties(job));" + NL + "\t}" + NL + "\t" + NL + "\tpublic scala.Tuple2<KEY, ";
  protected final String TEXT_166 = "> call(scala.Tuple2<KEY, ";
  protected final String TEXT_167 = "> tuple) {" + NL + "\t\t";
  protected final String TEXT_168 = " record = new ";
  protected final String TEXT_169 = "();";
  protected final String TEXT_170 = NL + "\t\ttry {";
  protected final String TEXT_171 = NL + "\t\t\trecord.";
  protected final String TEXT_172 = " = new String(converter.convert(tuple._2()));";
  protected final String TEXT_173 = NL + "\t\t\trecord.";
  protected final String TEXT_174 = " = new String(converter.convert(tuple._2()), ";
  protected final String TEXT_175 = ");";
  protected final String TEXT_176 = NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\trecord.";
  protected final String TEXT_177 = " = null;" + NL + "\t\t}";
  protected final String TEXT_178 = NL + "\t\trecord.";
  protected final String TEXT_179 = " = java.nio.ByteBuffer.wrap(converter.convert(tuple._2()));";
  protected final String TEXT_180 = NL + "\t\treturn new scala.Tuple2(tuple._1(), record);" + NL + "\t}" + NL + "}";
  protected final String TEXT_181 = NL + "\torg.apache.spark.streaming.api.java.JavaPairDStream<NullWritable, ";
  protected final String TEXT_182 = "> rdd_";
  protected final String TEXT_183 = " = rdd_";
  protected final String TEXT_184 = ".mapToPair(new ";
  protected final String TEXT_185 = "_convertFunction(job));";
  protected final String TEXT_186 = NL + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();


    stringBuffer.append(TEXT_2);
    
class RowStructToPositionalStringConverterHelper {

	private INode node;
	
	private String cid;
	
	private String incomingConnectionTypeName;
	
	private IConnection incomingConnection;

	public RowStructToPositionalStringConverterHelper(INode node) {
		this.node = node;
		cid = node.getUniqueName();
		
		List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
		this.incomingConnection = inConns.get(0); 
		incomingConnectionTypeName = codeGenArgument.getRecordStructName(incomingConnection);
	}
	
	public String getConverterTypeName() {
		return cid+"_"+incomingConnectionTypeName+"ToPositionalStringConverter";
	}
	
	public void generateConverterCode() {
		IMetadataTable metadata = incomingConnection.getMetadataTable();
		List<Map<String, String>> formats =
		        (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FORMATS__");
		String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");
		String fieldSeparator = ElementParameterParser.getValue(node,"__FIELDSEPARATOR__");
		boolean includeHeader = "true".equals(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
		boolean customEncoding = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_ENCODING__"));
		String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		
		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
		
		boolean useByte = ("true").equals(ElementParameterParser.getValue(node, "__USE_BYTE__"));
		
		List<IMetadataColumn> columns = metadata.getListColumns();
		int columnSize = columns.size();

    stringBuffer.append(TEXT_3);
    stringBuffer.append(getConverterTypeName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(getConverterTypeName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
		if (includeHeader) {
			String header = "";
			int iterator = 1;
			for(IMetadataColumn columnForHeader : columns){
				header += columnForHeader.getLabel() + (iterator!=columns.size() ? fieldSeparator.substring(1, fieldSeparator.length() - 1) : "");
				iterator++;
			}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(header);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_14);
    
		} // end if (includeHeader)

		for (int i = 0; i < columnSize; i++) {
			IMetadataColumn column = columns.get(i);
			Map<String,String> format=formats.get(i);
			String columnName = column.getLabel();
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
			
			//get  and format output String begin
			
			if(isPrimitive) {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_17);
    
			} else {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_19);
    
				if(javaType == JavaTypesManager.DATE && pattern!=null){

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_23);
    
				}else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_26);
    
				}else if(javaType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_29);
    
				} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
    				if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(column.getPrecision() == null? "value" + "." + column.getLabel() : "value" + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_34);
    
					} else {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_39);
    
    				}
				} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getPrecision() == null ? "value" + "." + column.getLabel() : "value" + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_42);
    
				} else {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_45);
    
				}

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
      } // end else : javaType is not Primitive

      if (useByte) {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_51);
    
		}else{

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    
		}

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_57);
    
		if (("\'A\'").equals(format.get("KEEP"))) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    
		} else if (("\'R\'").equals(format.get("KEEP"))) {
     		if(useByte){

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_71);
    
			}else{

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_76);
    
     		}
		} else if (("\'M\'").equals(format.get("KEEP"))) {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_80);
    
			if(useByte){

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_91);
    
			}else{

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_97);
    
    		}
		} else {
    		if(useByte){

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_106);
    
			}else{

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_110);
    
    		}
		}

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_113);
    
		if (("\'L\'").equals(format.get("ALIGN"))) {

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_123);
    
		} else if (("\'R\'").equals(format.get("ALIGN"))) {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    
		} else {

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_150);
    
		}

    stringBuffer.append(TEXT_151);
    
} // end for

    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_156);
    
	} // end generateConverterCode()
} // end class

    stringBuffer.append(TEXT_157);
    stringBuffer.append(TEXT_158);
    
/**
* This is a Javajet helper class meant to generate all Spark functions responsible for serializing rowXStruct objects into byte arrays
* within a Spark Streaming job.
*
* tWriteXXX Spark functions rely on converters to serialize rowStruct into byte arrays accepted by messaging output components.
* These converters are framework undependant : they can be reused with any framework which needs to send messages as byte arrays.
* The type name of the converter to use must be provided via the generateCode() method.
*  
* WARNING : this does not generate the converter code but only the Spark functions one actually. These functions are common between 
* all tWriteXXX components and converters code have to be generated elsewhere beforehand.
*/

class TWriteXXXHelper {

	private INode node;
	
	private IConnection incomingConnection;
	
	private IConnection outgoingConnection;

	public TWriteXXXHelper(INode node) {
		this.node = node;
		this.incomingConnection = findIncomingConnection();
		this.outgoingConnection = findOutgoingConnection();
	}
	
	public void generateCode(String converterTypeName) {
		String cid = node.getUniqueName();

    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(getIncomingConnectionTypeName());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(converterTypeName);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(converterTypeName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(getIncomingConnectionTypeName());
    stringBuffer.append(TEXT_167);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_168);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_169);
    
		if("STRING".equals(getOutputType())) {

    stringBuffer.append(TEXT_170);
    			
			if(getEncoding() == null || getEncoding().equals("")) {

    stringBuffer.append(TEXT_171);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_172);
    
			} else {

    stringBuffer.append(TEXT_173);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_174);
    stringBuffer.append(getEncoding());
    stringBuffer.append(TEXT_175);
    
			}

    stringBuffer.append(TEXT_176);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_177);
    
		} else {

    stringBuffer.append(TEXT_178);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_179);
    
		}

    stringBuffer.append(TEXT_180);
    
	} // end generateCode()
	
	public void generateConfig() {
		String cid = node.getUniqueName();

    stringBuffer.append(TEXT_181);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_182);
    stringBuffer.append(outgoingConnection.getName());
    stringBuffer.append(TEXT_183);
    stringBuffer.append(incomingConnection.getName());
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    	
	} // end generateConfig()
	
	private IConnection findIncomingConnection() {
		IConnection result = null;
		if (node.getIncomingConnections() != null) {
		    for (IConnection in : node.getIncomingConnections()) {
		        if (in.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		            result = in;
		            break;
		        }
		    }
		}
		return result;
	}

   private IConnection findOutgoingConnection() {
		IConnection result = null;
		if (node.getOutgoingConnections() != null) {
		    for (IConnection in : node.getOutgoingConnections()) {
		        if (in.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		            result = in;
		            break;
		        }
		    }
		}
		return result;
	}
    
   private String getIncomingConnectionTypeName() {
		return codeGenArgument.getRecordStructName(this.incomingConnection);
   }
   
   private String getOutgoingConnectionTypeName() {
		return codeGenArgument.getRecordStructName(this.outgoingConnection);
   }
   
   private String getOutgoingColumnName() {
      return this.outgoingConnection.getMetadataTable().getListColumns().get(0).getLabel();
   }
   
   private String getOutputType() {
   	return ElementParameterParser.getValue(node, "__OUTPUT_TYPE__");
   }
   
   private String getEncoding() {
   	return ElementParameterParser.getValue(node, "__ENCODING__");
   }
    
} // end TWriteXXXHelper class

    stringBuffer.append(TEXT_186);
    
RowStructToPositionalStringConverterHelper converterHelper = new RowStructToPositionalStringConverterHelper(node);
converterHelper.generateConverterCode();

TWriteXXXHelper tWriteXXXHelper = new TWriteXXXHelper(node);
tWriteXXXHelper.generateCode(converterHelper.getConverterTypeName());

    return stringBuffer.toString();
  }
}
