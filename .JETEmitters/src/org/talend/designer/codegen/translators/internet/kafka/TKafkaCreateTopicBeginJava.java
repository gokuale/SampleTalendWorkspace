package org.talend.designer.codegen.translators.internet.kafka;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

public class TKafkaCreateTopicBeginJava
{
  protected static String nl;
  public static synchronized TKafkaCreateTopicBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKafkaCreateTopicBeginJava result = new TKafkaCreateTopicBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + NL + "// Topic configuration" + NL + "java.util.Properties ";
  protected final String TEXT_5 = "_topicProperties = new java.util.Properties();";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = "_topicProperties.put(\"retention.ms\", \"";
  protected final String TEXT_8 = "\");";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = "_topicProperties.put(";
  protected final String TEXT_11 = ", ";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\t" + NL + "org.I0Itec.zkclient.ZkClient ";
  protected final String TEXT_14 = "_zkClient = new org.I0Itec.zkclient.ZkClient(";
  protected final String TEXT_15 = ", 10000, 10000, kafka.utils.ZKStringSerializer$.MODULE$);" + NL;
  protected final String TEXT_16 = NL + "try{" + NL + "\tkafka.admin.AdminUtils.createTopic(";
  protected final String TEXT_17 = "_zkClient, ";
  protected final String TEXT_18 = ", Integer.valueOf(";
  protected final String TEXT_19 = "), Integer.valueOf(";
  protected final String TEXT_20 = "), ";
  protected final String TEXT_21 = "_topicProperties);" + NL + "} catch (kafka.common.TopicExistsException e) {";
  protected final String TEXT_22 = NL + "\t// nothing to do even through the topic already exists, continue the job";
  protected final String TEXT_23 = NL + "\t// topic already exists, stop the job" + NL + "\tthrow e;";
  protected final String TEXT_24 = NL + "}";
  protected final String TEXT_25 = NL + "// Existing topic configuration" + NL + "java.util.Properties ";
  protected final String TEXT_26 = "_initialTopicProperties = kafka.admin.AdminUtils.fetchTopicConfig(";
  protected final String TEXT_27 = "_zkClient, ";
  protected final String TEXT_28 = ");" + NL + "// Merge existing configuration with the new one" + NL + "java.util.Properties ";
  protected final String TEXT_29 = "_newTopicProperties = new java.util.Properties();";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = "_newTopicProperties.putAll(";
  protected final String TEXT_32 = "_initialTopicProperties);";
  protected final String TEXT_33 = NL;
  protected final String TEXT_34 = "_newTopicProperties.putAll(";
  protected final String TEXT_35 = "_topicProperties);" + NL + "// Push the configuration changes into ZK" + NL + "kafka.admin.AdminUtils.changeTopicConfig(";
  protected final String TEXT_36 = "_zkClient, ";
  protected final String TEXT_37 = ", ";
  protected final String TEXT_38 = "_newTopicProperties);";
  protected final String TEXT_39 = NL;
  protected final String TEXT_40 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
class TKafkaCreateTopicUtil {
	
	private INode node;
	
	private Map<String, String> kafkaTopicProperties;
	
	public TKafkaCreateTopicUtil(INode node) {
		this.node = node;
		this.kafkaTopicProperties = findKafkaTopicProperties();
	}
	
	public boolean isCreate() {
		return "CREATE_TOPIC".equals(ElementParameterParser.getValue(node, "__TOPICACTION__")) || isCreateIfNotExists();
	}
	
	public boolean isCreateIfNotExists() {
		return "CREATE_IF_NOT_EXISTS".equals(ElementParameterParser.getValue(node, "__TOPICACTION__"));
	}
	
	public boolean isAlter() {
		return "ALTER_TOPIC".equals(ElementParameterParser.getValue(node, "__TOPICACTION__"));
	}
	
	public String getZookeeperConnect() {
		return ElementParameterParser.getValue(node, "__ZOOKEEPER_CONNECT__");
	}
	
	public boolean isRetentionSet() {
		return "true".equals(ElementParameterParser.getValue(node, "__KAFKA_RETENTION_CHECK__"));
	}
	
	public String getRetention() {
		return ElementParameterParser.getValue(node, "__KAFKA_RETENTION__");
	}
	
	public String getTopic() {
		return ElementParameterParser.getValue(node, "__KAFKA_TOPIC__");
	}
	
	public String getReplicationFactor() {
		return ElementParameterParser.getValue(node, "__KAFKA_REPLICATION__");
	}
	
	public String getNbPartitions() {
		return ElementParameterParser.getValue(node, "__KAFKA_PARTITION__");
	}
	
	public Map<String, String> getKafkaTopicProperties(){
		return this.kafkaTopicProperties;
	}
	
	private Map<String, String> findKafkaTopicProperties() {
		Map<String, String> result = new HashMap<String, String>();
		List<Map<String, String>> topicPropertiesFromStudio = (List<Map<String, String>>) ElementParameterParser
		        .getObjectValue(node, "__KAFKA_TOPIC_PROPERTIES__");
		for (Map<String, String> topicPropertyFromStudio : topicPropertiesFromStudio) {
		    result.put(topicPropertyFromStudio.get("PROPERTY"), topicPropertyFromStudio.get("VALUE"));
		}
		return result;
   }
}

    stringBuffer.append(TEXT_3);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

TKafkaCreateTopicUtil tKafkaCreateTopicUtil = new TKafkaCreateTopicUtil(node);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	if(tKafkaCreateTopicUtil.isRetentionSet()) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(tKafkaCreateTopicUtil.getRetention());
    stringBuffer.append(TEXT_8);
    
	}

    
	for(Entry<String, String> topicProperty : tKafkaCreateTopicUtil.getKafkaTopicProperties().entrySet()) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(topicProperty.getKey());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(topicProperty.getValue());
    stringBuffer.append(TEXT_12);
    
	}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(tKafkaCreateTopicUtil.getZookeeperConnect());
    stringBuffer.append(TEXT_15);
     
	if(tKafkaCreateTopicUtil.isCreate()) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(tKafkaCreateTopicUtil.getTopic());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(tKafkaCreateTopicUtil.getNbPartitions());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(tKafkaCreateTopicUtil.getReplicationFactor());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
     
		if (tKafkaCreateTopicUtil.isCreateIfNotExists()) {

    stringBuffer.append(TEXT_22);
     
		} else {

    stringBuffer.append(TEXT_23);
    
		}

    stringBuffer.append(TEXT_24);
    
	} else if(tKafkaCreateTopicUtil.isAlter()) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(tKafkaCreateTopicUtil.getTopic());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(tKafkaCreateTopicUtil.getTopic());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
	}

    stringBuffer.append(TEXT_39);
    stringBuffer.append(TEXT_40);
    return stringBuffer.toString();
  }
}
