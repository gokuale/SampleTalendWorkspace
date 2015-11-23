package org.talend.designer.codegen.translators.messaging.kafka;

import java.util.Map.Entry;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.common.tkafkainput.TKafkaInputUtil;

public class TKafkaAbstractInputAvroSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TKafkaAbstractInputAvroSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKafkaAbstractInputAvroSparkstreamingconfigJava result = new TKafkaAbstractInputAvroSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\tjava.util.Map<String, String> ";
  protected final String TEXT_4 = "_kafkaProperties = new java.util.HashMap<String, String>();";
  protected final String TEXT_5 = NL + "\t\tif(true){" + NL + "\t\t\tthrow new Exception(\"A broker list must be provided.\");" + NL + "\t\t}";
  protected final String TEXT_6 = NL + "\t";
  protected final String TEXT_7 = "_kafkaProperties.put(\"bootstrap.servers\", ";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\t";
  protected final String TEXT_10 = "_kafkaProperties.put(";
  protected final String TEXT_11 = ", ";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\t";
  protected final String TEXT_14 = "_kafkaProperties.put(\"serializer.encoding\", ";
  protected final String TEXT_15 = ");" + NL + "\t";
  protected final String TEXT_16 = "_kafkaProperties.put(\"auto.offset.reset\", \"";
  protected final String TEXT_17 = "\");";
  protected final String TEXT_18 = NL + "\tjava.util.Set<String> ";
  protected final String TEXT_19 = "_kafkaTopics = new java.util.HashSet<String>();";
  protected final String TEXT_20 = NL + NL + "\tif(true){" + NL + "\t\tthrow new Exception(\"A Kafka topic must be provided.\");" + NL + "\t}";
  protected final String TEXT_21 = NL + "\t\t";
  protected final String TEXT_22 = "_kafkaTopics.add(";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL + NL + "    String avroSchema_";
  protected final String TEXT_26 = " = org.apache.commons.io.FileUtils.readFileToString(new java.io.File(";
  protected final String TEXT_27 = "));";
  protected final String TEXT_28 = NL + "    ";
  protected final String TEXT_29 = "_kafkaProperties.put(\"talend.avro.schema\", avroSchema_";
  protected final String TEXT_30 = ");" + NL;
  protected final String TEXT_31 = NL + NL + "org.apache.spark.streaming.api.java.JavaPairDStream<NullWritable, org.apache.hadoop.io.ObjectWritable> rdd_";
  protected final String TEXT_32 = " = org.apache.spark.streaming.kafka.KafkaUtils.createDirectStream(ctx, NullWritable.class, org.apache.hadoop.io.ObjectWritable.class, ";
  protected final String TEXT_33 = "_DecoderFromByteArrayToNullWritable.class, ";
  protected final String TEXT_34 = "_DecoderFromByteArrayToObjectWritable.class, ";
  protected final String TEXT_35 = "_kafkaProperties, ";
  protected final String TEXT_36 = "_kafkaTopics);" + NL;
  protected final String TEXT_37 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
/**
* This is a Javajet helper class meant to mutualize code generation for tKafkaXXXInput components.
* These components share several parameters :
* - the Kafka consumer properties
* - the list of Kafka topics to read from
*
* Each tKafkaXXXInput_sparkstreamingconfig.javajet should at least import this file to avoid
* code duplication.
*/

final class TKafkaInputHelper {

	private TKafkaInputUtil tKafkaInputUtil;
	
	public TKafkaInputHelper(TKafkaInputUtil util){
		tKafkaInputUtil = util;
	}

	public void generateKafkaProperties(String cid) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
		if(tKafkaInputUtil.getBrokerList() == null || "".equals(tKafkaInputUtil.getBrokerList())){

    stringBuffer.append(TEXT_5);
    
		} else {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(tKafkaInputUtil.getBrokerList());
    stringBuffer.append(TEXT_8);
    
			for(Entry<String, String> kafkaProperty : tKafkaInputUtil.getKafkaConsumerProperties().entrySet()) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(kafkaProperty.getKey());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(kafkaProperty.getValue());
    stringBuffer.append(TEXT_12);
    
			} // end for
		} // end else

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(tKafkaInputUtil.getEncoding());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(tKafkaInputUtil.getAutoOffsetReset());
    stringBuffer.append(TEXT_17);
    
	} // end generateKafkaProperties
	
	public void generateKafkaTopics(String cid) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
		if(tKafkaInputUtil.getKafkaTopics().isEmpty()){

    stringBuffer.append(TEXT_20);
    
		}else {
			for(String kafkaTopic : tKafkaInputUtil.getKafkaTopics()) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(kafkaTopic);
    stringBuffer.append(TEXT_23);
    
			} // end for
		} // end else
	} // end generateKafkaTopics
	
} // end class TKafkaInputHelper

    stringBuffer.append(TEXT_24);
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

TKafkaInputUtil tKafkaInputUtil = new TKafkaInputUtil(node);
TKafkaInputHelper tKafkaInputHelper = new TKafkaInputHelper(tKafkaInputUtil);

tKafkaInputHelper.generateKafkaProperties(cid);
tKafkaInputHelper.generateKafkaTopics(cid);

boolean useHierarchical = "true".equals(ElementParameterParser.getValue(node, "__USE_HIERARCHICAL__"));

if (useHierarchical) {
    String schemaFileName = ElementParameterParser.getValue(node, "__SCHEMA_FILENAME__");
    
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(schemaFileName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
}

    stringBuffer.append(TEXT_31);
    stringBuffer.append(tKafkaInputUtil.getOutgoingConnection().getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    return stringBuffer.toString();
  }
}
