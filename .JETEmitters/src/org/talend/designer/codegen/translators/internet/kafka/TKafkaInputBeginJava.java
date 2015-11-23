package org.talend.designer.codegen.translators.internet.kafka;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TKafkaInputBeginJava
{
  protected static String nl;
  public static synchronized TKafkaInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKafkaInputBeginJava result = new TKafkaInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + NL + "class ";
  protected final String TEXT_5 = "_ValueDecoder implements kafka.serializer.Decoder<";
  protected final String TEXT_6 = "> {" + NL + "" + NL + "    private final kafka.serializer.StringDecoder stringDecoder;" + NL + "" + NL + "    public ";
  protected final String TEXT_7 = "_ValueDecoder(kafka.utils.VerifiableProperties props){" + NL + "        this.stringDecoder = new kafka.serializer.StringDecoder(props);" + NL + "    }" + NL + "" + NL + "    public ";
  protected final String TEXT_8 = " fromBytes(byte[] bytes) {";
  protected final String TEXT_9 = NL + "        ";
  protected final String TEXT_10 = " result = new ";
  protected final String TEXT_11 = "();";
  protected final String TEXT_12 = NL + "\t\t\tString line = this.stringDecoder.fromBytes(bytes);" + NL + "\t\t\tresult.";
  protected final String TEXT_13 = " = line;";
  protected final String TEXT_14 = NL + "\t\t\tresult.";
  protected final String TEXT_15 = " = bytes;";
  protected final String TEXT_16 = NL + "        return result;" + NL + "    }" + NL + "}" + NL + "" + NL + "class ";
  protected final String TEXT_17 = "_KeyDecoder implements kafka.serializer.Decoder<byte[]> {" + NL + "" + NL + "    public ";
  protected final String TEXT_18 = "_KeyDecoder(kafka.utils.VerifiableProperties props){" + NL + "        // nothing but Decoder implementations must define a constructor with VerifiableProperties" + NL + "    }" + NL + "" + NL + "    public byte[] fromBytes(byte[] bytes) {" + NL + "        return bytes;" + NL + "    }" + NL + "}" + NL + "" + NL + "// Consumer configuration" + NL + "java.util.Properties ";
  protected final String TEXT_19 = "_kafkaProperties = new java.util.Properties();";
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = "_kafkaProperties.put(\"zookeeper.connect\", ";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = "_kafkaProperties.put(\"group.id\", ";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = "_kafkaProperties.put(\"serializer.encoding\", ";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = "_kafkaProperties.put(\"auto.offset.reset\", \"";
  protected final String TEXT_31 = "\");";
  protected final String TEXT_32 = NL;
  protected final String TEXT_33 = "_kafkaProperties.put(\"consumer.timeout.ms\", ";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL;
  protected final String TEXT_36 = "_kafkaProperties.put(\"auto.commit.interval.ms\", ";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL;
  protected final String TEXT_39 = "_kafkaProperties.put(\"offsets.storage\", \"";
  protected final String TEXT_40 = "\");";
  protected final String TEXT_41 = NL;
  protected final String TEXT_42 = "_kafkaProperties.put(\"dual.commit.enabled\", \"";
  protected final String TEXT_43 = "\");";
  protected final String TEXT_44 = NL;
  protected final String TEXT_45 = "_kafkaProperties.put(";
  protected final String TEXT_46 = ", ";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + "kafka.utils.VerifiableProperties ";
  protected final String TEXT_49 = "_verifiableProperties = new kafka.utils.VerifiableProperties(";
  protected final String TEXT_50 = "_kafkaProperties);" + NL;
  protected final String TEXT_51 = NL + "// Reset consumer offsets" + NL + "kafka.utils.ZkUtils.maybeDeletePath(";
  protected final String TEXT_52 = ", \"/consumers/\"+";
  protected final String TEXT_53 = "_kafkaProperties.get(\"group.id\"));";
  protected final String TEXT_54 = NL + NL + "// Single-threaded consumer" + NL + "kafka.javaapi.consumer.ConsumerConnector ";
  protected final String TEXT_55 = "_consumerConnector = kafka.consumer.Consumer.createJavaConsumerConnector(new kafka.consumer.ConsumerConfig(";
  protected final String TEXT_56 = "_kafkaProperties));" + NL + "java.util.Map<String, Integer> ";
  protected final String TEXT_57 = "_topicCountMap = new java.util.HashMap<String, Integer>();";
  protected final String TEXT_58 = NL;
  protected final String TEXT_59 = "_topicCountMap.put(";
  protected final String TEXT_60 = ", 1);" + NL + "java.util.Map<String, List<kafka.consumer.KafkaStream<byte[], ";
  protected final String TEXT_61 = ">>> ";
  protected final String TEXT_62 = "_consumerMap = ";
  protected final String TEXT_63 = "_consumerConnector.createMessageStreams(";
  protected final String TEXT_64 = "_topicCountMap, new ";
  protected final String TEXT_65 = "_KeyDecoder(";
  protected final String TEXT_66 = "_verifiableProperties), new ";
  protected final String TEXT_67 = "_ValueDecoder(";
  protected final String TEXT_68 = "_verifiableProperties));" + NL + "java.util.List<kafka.consumer.KafkaStream<byte[], ";
  protected final String TEXT_69 = ">> ";
  protected final String TEXT_70 = "_streams = ";
  protected final String TEXT_71 = "_consumerMap.get(";
  protected final String TEXT_72 = ");" + NL + "" + NL + "// Start consumption" + NL + "kafka.consumer.ConsumerIterator<byte[], ";
  protected final String TEXT_73 = "> ";
  protected final String TEXT_74 = "_consumerIterator = ";
  protected final String TEXT_75 = "_streams.get(0).iterator();" + NL + "" + NL + "try {" + NL + "\twhile (";
  protected final String TEXT_76 = "_consumerIterator.hasNext()) {" + NL;
  protected final String TEXT_77 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
class TKafkaInputUtil {
	
	private INode node;
	
	private IConnection outgoingConnection;
	
	private Map<String, String> kafkaConsumerProperties;
	
	public TKafkaInputUtil(INode node) {
		this.node = node;
		this.outgoingConnection = findOutgoingConnection();
		this.kafkaConsumerProperties = findKafkaConsumerProperties();
	}
	
	public String getOffsetStorage() {
		return ElementParameterParser.getValue(node, "__KAFKA_OFFSET_STORAGE__").toLowerCase();
	}
	
	public boolean isDualCommit() {
		return "kafka".equals(getOffsetStorage()) && "true".equals(ElementParameterParser.getValue(node, "__KAFKA_DUAL_COMMIT_CHECK__"));
	}
	
	public String getTopic() {
		return ElementParameterParser.getValue(node, "__KAFKA_TOPIC__");
	}
	
	public String getEncoding() {
		String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
		if (encoding == null || "".equals(encoding)) {
		    encoding = "\"UTF-8\"";
		}
		return encoding;
   }
	
	public Map<String, String> getKafkaConsumerProperties() {
		return this.kafkaConsumerProperties;
	}
	
	public String getZookeeperConnect() {
		return ElementParameterParser.getValue(node, "__ZOOKEEPER_CONNECT__");
	}
	
	public String getGroupId() {
		return ElementParameterParser.getValue(node, "__GROUP_ID__");
	}
	
	public String getCommitInterval() {
		return ElementParameterParser.getValue(node, "__KAFKA_COMMIT_INTERVAL__");
	}
	
	public String getConsumerTimeout() {
		return ElementParameterParser.getValue(node, "__KAFKA_CONSUMER_TIMEOUT__");
	}
	
	public String getAutoOffsetReset() {
		return ElementParameterParser.getValue(node, "__AUTO_OFFSET_RESET__").toLowerCase();
   }
	
	public String getOutStructName() {
		return this.outgoingConnection.getName() + "Struct";
	}
	
	public String getOutgoingConnectionName() {
		return this.outgoingConnection.getName();
	}
	
	public String getOutgoingColumnName() {
		return this.outgoingConnection.getMetadataTable().getListColumns().get(0).getLabel();
	}
	
	public String getOutputType() {
   	return ElementParameterParser.getValue(node, "__OUTPUT_TYPE__");
   }
	
	private Map<String, String> findKafkaConsumerProperties() {
		Map<String, String> result = new HashMap<String, String>();
		List<Map<String, String>> consumerPropertiesFromStudio = (List<Map<String, String>>) ElementParameterParser
		        .getObjectValue(node, "__KAFKA_CONSUMER_PROPERTIES__");
		if(consumerPropertiesFromStudio != null) {
			for (Map<String, String> consumerPropertyFromStudio : consumerPropertiesFromStudio) {
			    result.put(consumerPropertyFromStudio.get("PROPERTY"), consumerPropertyFromStudio.get("VALUE"));
			}
		}
		return result;
   }
	
	private IConnection findOutgoingConnection() {
		IConnection result = null;
		List<? extends IConnection> connections = node.getOutgoingConnections();
		for(IConnection connection : connections) {
			if(connection.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				result = connection;
				break;
			}
		}
		return result;
	}
}

    stringBuffer.append(TEXT_3);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

TKafkaInputUtil tKafkaInputUtil = new TKafkaInputUtil(node);
String outStructName = tKafkaInputUtil.getOutStructName();


    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_11);
    
	if("STRING".equals(tKafkaInputUtil.getOutputType())) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(tKafkaInputUtil.getOutgoingColumnName());
    stringBuffer.append(TEXT_13);
    
	} else if("BYTES".equals(tKafkaInputUtil.getOutputType())) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(tKafkaInputUtil.getOutgoingColumnName());
    stringBuffer.append(TEXT_15);
    
	}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(tKafkaInputUtil.getZookeeperConnect());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(tKafkaInputUtil.getGroupId());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(tKafkaInputUtil.getEncoding());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(tKafkaInputUtil.getAutoOffsetReset());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(tKafkaInputUtil.getConsumerTimeout());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(tKafkaInputUtil.getCommitInterval());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(tKafkaInputUtil.getOffsetStorage());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(tKafkaInputUtil.isDualCommit());
    stringBuffer.append(TEXT_43);
    
	for(java.util.Map.Entry<String, String> kafkaProperty : tKafkaInputUtil.getKafkaConsumerProperties().entrySet()) {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(kafkaProperty.getKey());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(kafkaProperty.getValue());
    stringBuffer.append(TEXT_47);
    
	}

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
	if("smallest".equals(tKafkaInputUtil.getAutoOffsetReset())) {

    stringBuffer.append(TEXT_51);
    stringBuffer.append(tKafkaInputUtil.getZookeeperConnect());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
	}

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(tKafkaInputUtil.getTopic());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(tKafkaInputUtil.getTopic());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(TEXT_77);
    return stringBuffer.toString();
  }
}
