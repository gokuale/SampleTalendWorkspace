package org.talend.designer.codegen.translators.messaging.kafka;

import java.util.Map.Entry;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.common.tkafkaoutput.TKafkaOutputUtil;

public class TKafkaOutputSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TKafkaOutputSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKafkaOutputSparkstreamingconfigJava result = new TKafkaOutputSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.util.Properties ";
  protected final String TEXT_3 = "_kafkaProperties = new java.util.Properties();";
  protected final String TEXT_4 = NL + "\tif(true){" + NL + "\t\tthrow new Exception(\"A broker list must be provided.\");" + NL + "\t}";
  protected final String TEXT_5 = NL + "\t";
  protected final String TEXT_6 = "_kafkaProperties.setProperty(\"bootstrap.servers\", ";
  protected final String TEXT_7 = ");" + NL + "\t";
  protected final String TEXT_8 = "_kafkaProperties.setProperty(\"compression.type\", \"";
  protected final String TEXT_9 = "\");";
  protected final String TEXT_10 = NL + "\t";
  protected final String TEXT_11 = "_kafkaProperties.setProperty(";
  protected final String TEXT_12 = ", ";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\tjava.util.Set<String> ";
  protected final String TEXT_15 = "_kafkaTopics = new java.util.HashSet<String>();";
  protected final String TEXT_16 = NL + NL + "\tif(true){" + NL + "\t\tthrow new Exception(\"At least one Kafka topic must be provided.\");" + NL + "\t}";
  protected final String TEXT_17 = NL + "\t\t";
  protected final String TEXT_18 = "_kafkaTopics.add(";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = NL + NL + "rdd_";
  protected final String TEXT_22 = ".foreachRDD(new ";
  protected final String TEXT_23 = "_ForeachRDD_KafkaMessageSender(job, ";
  protected final String TEXT_24 = "_kafkaProperties, ";
  protected final String TEXT_25 = "_kafkaTopics));";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
final class TKafkaOutputHelper {

	private TKafkaOutputUtil tKafkaOutputUtil;
	
	public TKafkaOutputHelper(TKafkaOutputUtil util){
		tKafkaOutputUtil = util;
	}

	public void generateKafkaProperties(String cid) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
		if(tKafkaOutputUtil.getBrokerList() == null || "".equals(tKafkaOutputUtil.getBrokerList())){

    stringBuffer.append(TEXT_4);
     
		} else {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(tKafkaOutputUtil.getBrokerList());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(tKafkaOutputUtil.getCompression());
    stringBuffer.append(TEXT_9);
    
			for(Entry<String, String> kafkaProperty : tKafkaOutputUtil.getKafkaProducerProperties().entrySet()) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(kafkaProperty.getKey());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(kafkaProperty.getValue());
    stringBuffer.append(TEXT_13);
    
			} // end for
		} // end else
	} // end generateKafkaProperties
	
	public void generateKafkaTopics(String cid) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
		if(tKafkaOutputUtil.getKafkaTopics().isEmpty()){

    stringBuffer.append(TEXT_16);
    
		}else {
			for(String kafkaTopic : tKafkaOutputUtil.getKafkaTopics()) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(kafkaTopic);
    stringBuffer.append(TEXT_19);
    
			} // end for
		} // end else
	} // end generateKafkaTopics
	
} // end class TKafkaOutputHelper

    stringBuffer.append(TEXT_20);
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();
final String cid = node.getUniqueName();

TKafkaOutputUtil tKafkaOutputUtil = new TKafkaOutputUtil(node);
TKafkaOutputHelper tKafkaOutputHelper = new TKafkaOutputHelper(tKafkaOutputUtil);

tKafkaOutputHelper.generateKafkaProperties(cid);
tKafkaOutputHelper.generateKafkaTopics(cid);

    stringBuffer.append(TEXT_21);
    stringBuffer.append(tKafkaOutputUtil.getIncomingConnection().getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}
