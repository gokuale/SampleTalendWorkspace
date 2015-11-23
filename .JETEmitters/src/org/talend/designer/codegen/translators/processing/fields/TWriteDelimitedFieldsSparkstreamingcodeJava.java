package org.talend.designer.codegen.translators.processing.fields;

import java.util.List;
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

public class TWriteDelimitedFieldsSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TWriteDelimitedFieldsSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteDelimitedFieldsSparkstreamingcodeJava result = new TWriteDelimitedFieldsSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "public static class ";
  protected final String TEXT_4 = " implements java.io.Serializable {" + NL + "" + NL + "\tprivate ContextProperties context;" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_5 = "(ContextProperties context) {" + NL + "\t\tthis.context = context;" + NL + "\t}" + NL + "\t" + NL + "\tpublic byte[] convert(";
  protected final String TEXT_6 = " value) {" + NL + "\t\tStringBuilder sb = new StringBuilder();";
  protected final String TEXT_7 = NL + "\t\tsb.append(\"";
  protected final String TEXT_8 = "\");" + NL + "\t\tsb.append(";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\tif(value.";
  protected final String TEXT_11 = " != null){";
  protected final String TEXT_12 = NL + "\tcurrentValue = FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\tcurrentValue = FormatterUtils.format_Number(";
  protected final String TEXT_16 = ".toPlainString(), ";
  protected final String TEXT_17 = ", ";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\tcurrentValue = FormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(value.";
  protected final String TEXT_20 = ")).toPlainString(), ";
  protected final String TEXT_21 = ", ";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\tcurrentValue = ";
  protected final String TEXT_24 = ".toPlainString();";
  protected final String TEXT_25 = NL + "\tcurrentValue = java.nio.charset.Charset.forName(";
  protected final String TEXT_26 = ").decode(java.nio.ByteBuffer.wrap(value.";
  protected final String TEXT_27 = ")).toString();";
  protected final String TEXT_28 = NL + "\tcurrentValue =  String.valueOf(value.";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "\t} // end if(value.";
  protected final String TEXT_31 = " != null)";
  protected final String TEXT_32 = NL + "\tsb.append('";
  protected final String TEXT_33 = "' + currentValue.replace(\"\" + '";
  protected final String TEXT_34 = "', \"\" + '";
  protected final String TEXT_35 = "' + '";
  protected final String TEXT_36 = "') + '";
  protected final String TEXT_37 = "');";
  protected final String TEXT_38 = NL + "\tsb.append(";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\ttry {" + NL + "\t\treturn sb.toString().getBytes(";
  protected final String TEXT_41 = ");" + NL + "\t} catch (java.lang.Exception e) {" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_42 = NL + "\tif(value.";
  protected final String TEXT_43 = " != null){";
  protected final String TEXT_44 = NL + "\t\tsb.append(FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_45 = ", ";
  protected final String TEXT_46 = "));";
  protected final String TEXT_47 = NL + "\t\tsb.append(FormatterUtils.format_Number(";
  protected final String TEXT_48 = ".toPlainString(), ";
  protected final String TEXT_49 = ", ";
  protected final String TEXT_50 = "));                   ";
  protected final String TEXT_51 = NL + "\t\tsb.append(FormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(value.";
  protected final String TEXT_52 = ")).toPlainString(), ";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = "));                       ";
  protected final String TEXT_55 = NL + "\t\tsb.append(";
  protected final String TEXT_56 = ".toPlainString());";
  protected final String TEXT_57 = NL + "\t\tsb.append(java.nio.charset.Charset.forName(";
  protected final String TEXT_58 = ").decode(java.nio.ByteBuffer.wrap(value.";
  protected final String TEXT_59 = ")).toString());";
  protected final String TEXT_60 = NL + "\t\tsb.append(value.";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = NL + "\t} // end if(value.";
  protected final String TEXT_63 = " != null)";
  protected final String TEXT_64 = NL + "\tsb.append(";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = NL + "\ttry {" + NL + "\t\treturn sb.toString().getBytes(";
  protected final String TEXT_67 = ");" + NL + "\t} catch (java.lang.Exception e) {" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_68 = NL + "\t} // end convert()\t" + NL + "" + NL + "} // end ";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = "ToDelimitedStringConverter class ";
  protected final String TEXT_71 = NL;
  protected final String TEXT_72 = NL;
  protected final String TEXT_73 = NL + NL + "public static class ";
  protected final String TEXT_74 = "_convertFunction<KEY> implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<KEY, ";
  protected final String TEXT_75 = ">, KEY,";
  protected final String TEXT_76 = "> {" + NL + "\t\t" + NL + "\tprivate ";
  protected final String TEXT_77 = " converter;" + NL + "\t" + NL + "\tpublic ";
  protected final String TEXT_78 = "_convertFunction(JobConf job){" + NL + "\t\tthis.converter = new ";
  protected final String TEXT_79 = "(new ContextProperties(job));" + NL + "\t}" + NL + "\t" + NL + "\tpublic scala.Tuple2<KEY, ";
  protected final String TEXT_80 = "> call(scala.Tuple2<KEY, ";
  protected final String TEXT_81 = "> tuple) {" + NL + "\t\t";
  protected final String TEXT_82 = " record = new ";
  protected final String TEXT_83 = "();";
  protected final String TEXT_84 = NL + "\t\ttry {";
  protected final String TEXT_85 = NL + "\t\t\trecord.";
  protected final String TEXT_86 = " = new String(converter.convert(tuple._2()));";
  protected final String TEXT_87 = NL + "\t\t\trecord.";
  protected final String TEXT_88 = " = new String(converter.convert(tuple._2()), ";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\trecord.";
  protected final String TEXT_91 = " = null;" + NL + "\t\t}";
  protected final String TEXT_92 = NL + "\t\trecord.";
  protected final String TEXT_93 = " = java.nio.ByteBuffer.wrap(converter.convert(tuple._2()));";
  protected final String TEXT_94 = NL + "\t\treturn new scala.Tuple2(tuple._1(), record);" + NL + "\t}" + NL + "}";
  protected final String TEXT_95 = NL + "\torg.apache.spark.streaming.api.java.JavaPairDStream<NullWritable, ";
  protected final String TEXT_96 = "> rdd_";
  protected final String TEXT_97 = " = rdd_";
  protected final String TEXT_98 = ".mapToPair(new ";
  protected final String TEXT_99 = "_convertFunction(job));";
  protected final String TEXT_100 = NL + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();


    stringBuffer.append(TEXT_2);
    
class RowStructToDelimitedStringConverterHelper {

	private INode node;
	
	private String cid;
	
	private IConnection incomingConnection;
	
	private String incomingConnectionTypeName;

	public RowStructToDelimitedStringConverterHelper(INode node) {
		this.node = node;
		cid = node.getUniqueName();
		
		for (IConnection in : node.getIncomingConnections()) {
		    if (in.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		        incomingConnectionTypeName = codeGenArgument.getRecordStructName(in);
		        incomingConnection = in;
		        break;
		    }
		}
	}
	
	public String getConverterTypeName() {
		return cid+"_"+incomingConnectionTypeName+"ToDelimitedStringConverter";
	}
	
	public void generateConverterCode() {
		List<IMetadataColumn> columns = incomingConnection.getMetadataTable().getListColumns();
		
		String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");
		String fieldSeparator = ElementParameterParser.getValue(node,"__FIELDSEPARATOR__");
		boolean includeHeader = "true".equals(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
		
		boolean customEncoding = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_ENCODING__"));
		String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		
		boolean csvMode = "true".equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"));
		if (csvMode) {
			rowSeparator = ElementParameterParser.getValue(node, "__CSVROWSEPARATOR__");
      }

    stringBuffer.append(TEXT_3);
    stringBuffer.append(getConverterTypeName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(getConverterTypeName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_6);
    
		if(includeHeader){
			String header = "";
			int i = 1;
			for(IMetadataColumn column : columns){
				header += column.getLabel() + (i!=columns.size() ? fieldSeparator.substring(1,fieldSeparator.length()-1) : "");
				i++;
			}

    stringBuffer.append(TEXT_7);
    stringBuffer.append(header);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_9);
    
		}
		
		int columnSize = columns.size();
		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
		
		if (csvMode) {
			String escapeChar = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
			if(("").equals(escapeChar)){
			    escapeChar = "\"\"";
			}
			escapeChar = escapeChar.substring(1, escapeChar.length() - 1);
			if(("'").equals(escapeChar)){
			    escapeChar = "\\'";
			}
			String textEnclosure = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
			if(("").equals(textEnclosure)){
			    textEnclosure = "\"\"";
			}
			textEnclosure = textEnclosure.substring(1, textEnclosure.length() - 1);
			if ("".equals(textEnclosure)) {
			    textEnclosure = "\0";
			} else if (("'").equals(textEnclosure)) {
			    textEnclosure = "\\'";
			}
			for (int i = 0; i < columnSize; i++) {
				IMetadataColumn column = columns.get(i);
				String columnName = column.getLabel();
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
				
				if(!isPrimitive){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_11);
    
				}
				
				if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0){

    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_14);
    
				} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())){ 
		    		if(javaType == JavaTypesManager.BIGDECIMAL){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getPrecision() == null? "value." + columnName : "value." + columnName + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_18);
    
					}
					else{

    stringBuffer.append(TEXT_19);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_22);
    
					}
				} else if(javaType == JavaTypesManager.BIGDECIMAL){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getPrecision() == null ? "value." + columnName : "value." + columnName + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_24);
    
				} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_25);
    stringBuffer.append(customEncoding?encoding:"utf8Charset" );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_27);
    
				} else {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_29);
    
				}
			
				if(!isPrimitive){

    stringBuffer.append(TEXT_30);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_31);
    
				}

    stringBuffer.append(TEXT_32);
    stringBuffer.append(textEnclosure);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(textEnclosure);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(escapeChar);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(textEnclosure);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(textEnclosure);
    stringBuffer.append(TEXT_37);
    
				if(i < columnSize-1){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_39);
    
				}
			} // end for (int i = 0; i < columnSize; i++)

    stringBuffer.append(TEXT_40);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_41);
    
		} // end if (csvMode)
		else {
			for (int i = 0; i < columnSize; i++) {
				IMetadataColumn column = columns.get(i);
				String columnName = column.getLabel();
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
				if(!isPrimitive){

    stringBuffer.append(TEXT_42);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_43);
    
				} // end if(!isPrimitive)
				
				if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0){

    stringBuffer.append(TEXT_44);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_46);
    
				}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())){ 
					if(javaType == JavaTypesManager.BIGDECIMAL){

    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getPrecision() == null? "value." + columnName : "value." + columnName + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_48);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_50);
    
					}else{

    stringBuffer.append(TEXT_51);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_53);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_54);
    
					}
				} // end if(javaType == ...) 
				else if(javaType == JavaTypesManager.BIGDECIMAL){

    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getPrecision() == null ? "value." + columnName : "value." + columnName + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_56);
    
				} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_57);
    stringBuffer.append(customEncoding?encoding:"utf8Charset" );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_59);
    
				} else {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_61);
                  
				}
			
				if(!isPrimitive){

    stringBuffer.append(TEXT_62);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_63);
    
				}
			
				if(i < columnSize-1){

    stringBuffer.append(TEXT_64);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_65);
    
				}

    
			} // end for (int i = 0; i < columnSize; i++)

    stringBuffer.append(TEXT_66);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_67);
    
		} // end else (!csvMode)

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_70);
    
	} // end generateConverterCode()
} // end class

    stringBuffer.append(TEXT_71);
    stringBuffer.append(TEXT_72);
    
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

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(getIncomingConnectionTypeName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(converterTypeName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(converterTypeName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(getIncomingConnectionTypeName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_83);
    
		if("STRING".equals(getOutputType())) {

    stringBuffer.append(TEXT_84);
    			
			if(getEncoding() == null || getEncoding().equals("")) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_86);
    
			} else {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(getEncoding());
    stringBuffer.append(TEXT_89);
    
			}

    stringBuffer.append(TEXT_90);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_91);
    
		} else {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_93);
    
		}

    stringBuffer.append(TEXT_94);
    
	} // end generateCode()
	
	public void generateConfig() {
		String cid = node.getUniqueName();

    stringBuffer.append(TEXT_95);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(outgoingConnection.getName());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(incomingConnection.getName());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    	
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

    stringBuffer.append(TEXT_100);
    
RowStructToDelimitedStringConverterHelper converterHelper = new RowStructToDelimitedStringConverterHelper(node);
converterHelper.generateConverterCode();

TWriteXXXHelper tWriteXXXHelper = new TWriteXXXHelper(node);
tWriteXXXHelper.generateCode(converterHelper.getConverterTypeName());

    return stringBuffer.toString();
  }
}
