package org.talend.designer.codegen.translators.processing.fields;

import java.util.HashMap;
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

public class TWriteAvroFieldsSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TWriteAvroFieldsSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteAvroFieldsSparkstreamingcodeJava result = new TWriteAvroFieldsSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "public static class ";
  protected final String TEXT_4 = " implements java.io.Serializable {" + NL + "" + NL + "\tprivate ContextProperties context;" + NL + "\t" + NL + "\tprivate transient org.apache.avro.io.DatumWriter<org.apache.avro.generic.GenericRecord> datumWriter;" + NL + "\t" + NL + "\tprivate transient org.apache.avro.io.BinaryEncoder encoder;" + NL + "\t" + NL + "\tprivate transient java.io.ByteArrayOutputStream outputStream;" + NL + "\t" + NL + "\tprivate transient org.apache.avro.Schema schema;" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_5 = "(ContextProperties context) {" + NL + "\t\tthis.context = context;" + NL + "\t}" + NL + "\t" + NL + "\tpublic byte[] convert(";
  protected final String TEXT_6 = " value){" + NL + "\t\tif(this.schema == null) {" + NL + "\t\t\tthis.schema = createSchema();" + NL + "\t\t}" + NL + "\t\tif(this.datumWriter == null) {" + NL + "\t\t\tthis.datumWriter = new org.apache.avro.generic.GenericDatumWriter<org.apache.avro.generic.GenericRecord>(schema);" + NL + "\t\t}" + NL + "\t\tif(this.outputStream == null) {" + NL + "\t\t\tthis.outputStream = new java.io.ByteArrayOutputStream();" + NL + "\t\t} else {" + NL + "         this.outputStream.reset();" + NL + "      }" + NL + "\t\t" + NL + "\t\tencoder = org.apache.avro.io.EncoderFactory.get().binaryEncoder(outputStream, encoder);" + NL + "\t\t" + NL + "\t\ttry {" + NL + "\t\t\tdatumWriter.write(getGenericRecord(value), encoder);" + NL + "\t\t\tencoder.flush();" + NL + "\t\t\treturn outputStream.toByteArray();" + NL + "\t\t} catch(java.io.IOException e) {" + NL + "\t\t\t// TODO : how to handle this ?" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t} // end convert()" + NL + "" + NL + "\tprivate org.apache.avro.generic.GenericRecord getGenericRecord(";
  protected final String TEXT_7 = " value) {" + NL + "\t\torg.apache.avro.generic.GenericRecord record = new org.apache.avro.generic.GenericData.Record(schema);";
  protected final String TEXT_8 = NL + "\t\tif(value.";
  protected final String TEXT_9 = " != null){";
  protected final String TEXT_10 = NL + "\t\trecord.put(\"";
  protected final String TEXT_11 = "\", ((Byte)(value.";
  protected final String TEXT_12 = ")).intValue());";
  protected final String TEXT_13 = NL + "\t\trecord.put(\"";
  protected final String TEXT_14 = "\", ((Short)(value.";
  protected final String TEXT_15 = ")).intValue());";
  protected final String TEXT_16 = NL + "\t\trecord.put(\"";
  protected final String TEXT_17 = "\", (int)(char)(Character)(value.";
  protected final String TEXT_18 = "));";
  protected final String TEXT_19 = NL + "\t\trecord.put(\"";
  protected final String TEXT_20 = "\", java.nio.ByteBuffer.wrap(value.";
  protected final String TEXT_21 = "));";
  protected final String TEXT_22 = NL + "\t\trecord.put(\"";
  protected final String TEXT_23 = "\", value.";
  protected final String TEXT_24 = ".toString());";
  protected final String TEXT_25 = NL + "\t\trecord.put(\"";
  protected final String TEXT_26 = "\", value.";
  protected final String TEXT_27 = ".getTime());";
  protected final String TEXT_28 = NL + "\t\trecord.put(\"";
  protected final String TEXT_29 = "\", value.";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "\t\t}";
  protected final String TEXT_32 = NL + "\t\treturn record;" + NL + "\t} // end getGenericRecord()" + NL + "" + NL + "\tprivate org.apache.avro.Schema createSchema() {" + NL + "\t\tList<org.apache.avro.Schema.Field> fields = new java.util.ArrayList<org.apache.avro.Schema.Field>();" + NL + "\t\tList<org.apache.avro.Schema> unionSchema = null;";
  protected final String TEXT_33 = NL + "\t\tfields.add(new org.apache.avro.Schema.Field(\"";
  protected final String TEXT_34 = "\",org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_35 = "),null,null));";
  protected final String TEXT_36 = NL + "\t\tunionSchema = new java.util.ArrayList<org.apache.avro.Schema>();" + NL + "\t\tunionSchema.add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_37 = "));" + NL + "\t\tunionSchema.add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.NULL));" + NL + "\t\tfields.add(new org.apache.avro.Schema.Field(\"";
  protected final String TEXT_38 = "\",org.apache.avro.Schema.createUnion(unionSchema),null,null));";
  protected final String TEXT_39 = NL + "\t\torg.apache.avro.Schema schema = org.apache.avro.Schema.createRecord(\"record\", null, null, false);" + NL + "\t\tschema.setFields(fields);" + NL + "\t\treturn schema;" + NL + "\t} // end createSchema()" + NL + "" + NL + "} // end ";
  protected final String TEXT_40 = " class ";
  protected final String TEXT_41 = NL;
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = NL + NL + "public static class ";
  protected final String TEXT_44 = "_convertFunction<KEY> implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<KEY, ";
  protected final String TEXT_45 = ">, KEY,";
  protected final String TEXT_46 = "> {" + NL + "\t\t" + NL + "\tprivate ";
  protected final String TEXT_47 = " converter;" + NL + "\t" + NL + "\tpublic ";
  protected final String TEXT_48 = "_convertFunction(JobConf job){" + NL + "\t\tthis.converter = new ";
  protected final String TEXT_49 = "(new ContextProperties(job));" + NL + "\t}" + NL + "\t" + NL + "\tpublic scala.Tuple2<KEY, ";
  protected final String TEXT_50 = "> call(scala.Tuple2<KEY, ";
  protected final String TEXT_51 = "> tuple) {" + NL + "\t\t";
  protected final String TEXT_52 = " record = new ";
  protected final String TEXT_53 = "();";
  protected final String TEXT_54 = NL + "\t\ttry {";
  protected final String TEXT_55 = NL + "\t\t\trecord.";
  protected final String TEXT_56 = " = new String(converter.convert(tuple._2()));";
  protected final String TEXT_57 = NL + "\t\t\trecord.";
  protected final String TEXT_58 = " = new String(converter.convert(tuple._2()), ";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\trecord.";
  protected final String TEXT_61 = " = null;" + NL + "\t\t}";
  protected final String TEXT_62 = NL + "\t\trecord.";
  protected final String TEXT_63 = " = java.nio.ByteBuffer.wrap(converter.convert(tuple._2()));";
  protected final String TEXT_64 = NL + "\t\treturn new scala.Tuple2(tuple._1(), record);" + NL + "\t}" + NL + "}";
  protected final String TEXT_65 = NL + "\torg.apache.spark.streaming.api.java.JavaPairDStream<NullWritable, ";
  protected final String TEXT_66 = "> rdd_";
  protected final String TEXT_67 = " = rdd_";
  protected final String TEXT_68 = ".mapToPair(new ";
  protected final String TEXT_69 = "_convertFunction(job));";
  protected final String TEXT_70 = NL + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();


    stringBuffer.append(TEXT_2);
    
class RowStructToAvroGenericRecordConverterHelper {

	private INode node;
	
	private String cid;
	
	private String incomingConnectionTypeName;
	
	private IConnection incomingConnection;

	public RowStructToAvroGenericRecordConverterHelper(INode node) {
		this.node = node;
		cid = node.getUniqueName();
		
		for (IConnection in : node.getIncomingConnections()) {
		    if (in.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		   	  incomingConnection = in;
		        incomingConnectionTypeName = codeGenArgument.getRecordStructName(in);
		        break;
		    }
		}
	}
	
	public String getConverterTypeName() {
		return cid+"_"+incomingConnectionTypeName+"ToAvroGenericRecordConverter";
	}
	
	public void generateConverterCode() {
		List<IMetadataColumn> columns = incomingConnection.getMetadataTable().getListColumns();

    stringBuffer.append(TEXT_3);
    stringBuffer.append(getConverterTypeName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(getConverterTypeName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_7);
    
	for (int i = 0; i < columns.size(); i++) {
		IMetadataColumn column = columns.get(i);
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

    stringBuffer.append(TEXT_19);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_21);
    
		} else if(javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_24);
    
		} else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_27);
    
		} else {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_30);
    
		}
				
		if(!isPrimitive){

    stringBuffer.append(TEXT_31);
    
		}
	} // end for

    stringBuffer.append(TEXT_32);
    
	java.util.Map<JavaType, String> talendTypeToAvroType = new HashMap<JavaType, String>();
	talendTypeToAvroType.put(JavaTypesManager.STRING, "STRING");
	talendTypeToAvroType.put(JavaTypesManager.CHARACTER, "INT");
	talendTypeToAvroType.put(JavaTypesManager.BYTE_ARRAY, "BYTES");
	talendTypeToAvroType.put(JavaTypesManager.INTEGER, "INT");
	talendTypeToAvroType.put(JavaTypesManager.BYTE, "INT");
	talendTypeToAvroType.put(JavaTypesManager.SHORT, "INT");
	talendTypeToAvroType.put(JavaTypesManager.LONG, "LONG");
	talendTypeToAvroType.put(JavaTypesManager.FLOAT, "FLOAT");
	talendTypeToAvroType.put(JavaTypesManager.DOUBLE, "DOUBLE");
	talendTypeToAvroType.put(JavaTypesManager.BOOLEAN, "BOOLEAN");
	talendTypeToAvroType.put(JavaTypesManager.BIGDECIMAL, "STRING");
	talendTypeToAvroType.put(JavaTypesManager.DATE, "LONG");
	
	for (int i = 0; i < columns.size(); i++) {
	    IMetadataColumn column = columns.get(i);
	    String columnName = column.getLabel();
	    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
	    boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
	    
	    if(isPrimitive) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(talendTypeToAvroType.get(javaType));
    stringBuffer.append(TEXT_35);
    
    	} else {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(talendTypeToAvroType.get(javaType));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_38);
    
    	}
	}

    stringBuffer.append(TEXT_39);
    stringBuffer.append(getConverterTypeName());
    stringBuffer.append(TEXT_40);
    
	} // end generateConverterCode()
} // end class

    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    
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

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(getIncomingConnectionTypeName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(converterTypeName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(converterTypeName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(getIncomingConnectionTypeName());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_53);
    
		if("STRING".equals(getOutputType())) {

    stringBuffer.append(TEXT_54);
    			
			if(getEncoding() == null || getEncoding().equals("")) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_56);
    
			} else {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(getEncoding());
    stringBuffer.append(TEXT_59);
    
			}

    stringBuffer.append(TEXT_60);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_61);
    
		} else {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_63);
    
		}

    stringBuffer.append(TEXT_64);
    
	} // end generateCode()
	
	public void generateConfig() {
		String cid = node.getUniqueName();

    stringBuffer.append(TEXT_65);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(outgoingConnection.getName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(incomingConnection.getName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    	
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

    stringBuffer.append(TEXT_70);
    
RowStructToAvroGenericRecordConverterHelper converterHelper = new RowStructToAvroGenericRecordConverterHelper(node);
converterHelper.generateConverterCode();

TWriteXXXHelper tWriteXXXHelper = new TWriteXXXHelper(node);
tWriteXXXHelper.generateCode(converterHelper.getConverterTypeName());

    return stringBuffer.toString();
  }
}
