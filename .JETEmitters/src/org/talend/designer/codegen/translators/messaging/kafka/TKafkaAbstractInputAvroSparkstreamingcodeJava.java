package org.talend.designer.codegen.translators.messaging.kafka;

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
import org.talend.designer.common.tkafkainput.TKafkaInputUtil;

public class TKafkaAbstractInputAvroSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TKafkaAbstractInputAvroSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKafkaAbstractInputAvroSparkstreamingcodeJava result = new TKafkaAbstractInputAvroSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "//Use this object to override the ouput struct default ";
  protected final String TEXT_2 = NL + "//public static class ";
  protected final String TEXT_3 = " extends org.apache.hadoop.io.ObjectWritable {" + NL + "//}" + NL + "" + NL + "public static class ";
  protected final String TEXT_4 = "_DecoderFromByteArrayToObjectWritable implements kafka.serializer.Decoder<";
  protected final String TEXT_5 = "> {" + NL + "\t" + NL + "\tprivate final org.apache.avro.io.DatumReader<org.apache.avro.generic.GenericRecord> datumReader;" + NL + "\t" + NL + "\tprivate org.apache.avro.generic.GenericRecord record;" + NL + "\t" + NL + "\tprivate org.apache.avro.io.BinaryDecoder decoder;" + NL + "" + NL + "\t";
  protected final String TEXT_6 = NL + "\t    private String avroSchema;" + NL + "\t    ";
  protected final String TEXT_7 = NL + "\t\t" + NL + "\tpublic ";
  protected final String TEXT_8 = "_DecoderFromByteArrayToObjectWritable(kafka.utils.VerifiableProperties props){" + NL + "\t    ";
  protected final String TEXT_9 = NL + "            avroSchema = props.getString(\"talend.avro.schema\");" + NL + "            org.apache.avro.Schema schema = new org.apache.avro.Schema.Parser().parse(avroSchema);";
  protected final String TEXT_10 = NL + "            org.apache.avro.Schema schema = createSchema();";
  protected final String TEXT_11 = NL + "\t\tdatumReader = new org.apache.avro.generic.GenericDatumReader<org.apache.avro.generic.GenericRecord>(schema);" + NL + "\t \trecord = new org.apache.avro.generic.GenericData.Record(schema);" + NL + "\t}" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_12 = " fromBytes(byte[] bytes) {" + NL + "\t\t";
  protected final String TEXT_13 = " result = new ";
  protected final String TEXT_14 = "();" + NL + "\t\tdecoder = org.apache.avro.io.DecoderFactory.get().binaryDecoder(bytes, decoder);" + NL + "\t\ttry {" + NL + "\t\t\tresult.set(datumReader.read(record, decoder));" + NL + "\t\t} catch(java.io.IOException e) {" + NL + "\t\t\t// TODO : how to handle this ?" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t ";
  protected final String TEXT_15 = NL + "         private org.apache.avro.Schema createSchema() {" + NL + "             //set schema" + NL + "             List<org.apache.avro.Schema.Field> fields = new java.util.ArrayList<org.apache.avro.Schema.Field>();" + NL + "             List<org.apache.avro.Schema> unionSchema = null;" + NL;
  protected final String TEXT_16 = NL + "             fields.add(new org.apache.avro.Schema.Field(\"";
  protected final String TEXT_17 = "\",org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_18 = "),null,null));";
  protected final String TEXT_19 = NL + "             unionSchema = new java.util.ArrayList<org.apache.avro.Schema>();" + NL + "             unionSchema.add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_20 = "));" + NL + "             unionSchema.add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.NULL));" + NL + "             fields.add(new org.apache.avro.Schema.Field(\"";
  protected final String TEXT_21 = "\",org.apache.avro.Schema.createUnion(unionSchema),null,null));" + NL + "             ";
  protected final String TEXT_22 = NL + "             return org.apache.avro.Schema.createRecord(fields);" + NL + "         }";
  protected final String TEXT_23 = NL + NL + "}" + NL + "" + NL + "public static class ";
  protected final String TEXT_24 = "_DecoderFromByteArrayToNullWritable implements kafka.serializer.Decoder<org.apache.hadoop.io.NullWritable> {" + NL + "\t" + NL + "\tpublic ";
  protected final String TEXT_25 = "_DecoderFromByteArrayToNullWritable(kafka.utils.VerifiableProperties props) {" + NL + "\t\t// nothing but Decoder implementations must define a constructor with VerifiableProperties " + NL + "\t}" + NL + "\t" + NL + "\tpublic org.apache.hadoop.io.NullWritable fromBytes(byte[] bytes) {" + NL + "\t\treturn org.apache.hadoop.io.NullWritable.get();" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

TKafkaInputUtil tKafkaInputUtil = new TKafkaInputUtil(node);
String connectionNameStruct = tKafkaInputUtil.getOutgoingConnection().getName()+"Struct";
boolean useHierarchical = "true".equals(ElementParameterParser.getValue(node, "__USE_HIERARCHICAL__"));

String avroRecordStruct = "org.apache.hadoop.io.ObjectWritable";
codeGenArgument.getRecordStructGenerator().reserveRecordStructName(tKafkaInputUtil.getOutgoingConnection(), avroRecordStruct);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(connectionNameStruct);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connectionNameStruct);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(avroRecordStruct);
    stringBuffer.append(TEXT_5);
    
	if (useHierarchical) {
	    
    stringBuffer.append(TEXT_6);
    
	}
	
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
	    if (useHierarchical) {
	        
    stringBuffer.append(TEXT_9);
    
	    } else {
            
    stringBuffer.append(TEXT_10);
    
        }
	    
    stringBuffer.append(TEXT_11);
    stringBuffer.append(avroRecordStruct);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(avroRecordStruct);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(avroRecordStruct);
    stringBuffer.append(TEXT_14);
    
     if (!useHierarchical) {
         
    stringBuffer.append(TEXT_15);
    
         java.util.Map<JavaType,String> talendTypeToAvroType = tKafkaInputUtil.getTalendTypesToAvroTypes();
         
         List<IMetadataColumn> columns = node.getMetadataList().get(0).getListColumns();
         int nbColumns = columns.size();
         
         for (int i = 0; i < nbColumns; i++ ){
             IMetadataColumn column = columns.get(i);
             JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
             String columnName = column.getLabel();  
             boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
             
             if(isPrimitive) {
     
    stringBuffer.append(TEXT_16);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(talendTypeToAvroType.get(javaType));
    stringBuffer.append(TEXT_18);
    
             } else {
     
    stringBuffer.append(TEXT_19);
    stringBuffer.append(talendTypeToAvroType.get(javaType));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_21);
    
          }
         }
     
    stringBuffer.append(TEXT_22);
    
     }   
	 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}
