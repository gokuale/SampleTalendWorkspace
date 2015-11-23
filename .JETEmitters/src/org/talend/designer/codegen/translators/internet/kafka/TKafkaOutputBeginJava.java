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
import java.util.Map.Entry;
import java.util.HashMap;

public class TKafkaOutputBeginJava
{
  protected static String nl;
  public static synchronized TKafkaOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKafkaOutputBeginJava result = new TKafkaOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + NL + "// Producer configuration" + NL + "java.util.Properties ";
  protected final String TEXT_5 = "_kafkaProperties = new java.util.Properties();";
  protected final String TEXT_6 = NL + "\tif(true){" + NL + "\t\tthrow new Exception(\"A broker list must be provided.\");" + NL + "\t}";
  protected final String TEXT_7 = NL + "\t";
  protected final String TEXT_8 = "_kafkaProperties.setProperty(\"bootstrap.servers\", ";
  protected final String TEXT_9 = ");" + NL + "\t";
  protected final String TEXT_10 = "_kafkaProperties.setProperty(\"compression.type\", \"";
  protected final String TEXT_11 = "\");";
  protected final String TEXT_12 = NL + "\t";
  protected final String TEXT_13 = "_kafkaProperties.setProperty(";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + NL + "org.apache.kafka.clients.producer.KafkaProducer<byte[], byte[]> ";
  protected final String TEXT_17 = "_kafkaProducer = (org.apache.kafka.clients.producer.KafkaProducer<byte[], byte[]>)globalMap.get(\"";
  protected final String TEXT_18 = "_kafkaProducer\");" + NL + "if(null == ";
  protected final String TEXT_19 = "_kafkaProducer) {";
  protected final String TEXT_20 = NL + "    ";
  protected final String TEXT_21 = "_kafkaProducer = new org.apache.kafka.clients.producer.KafkaProducer<byte[], byte[]>(";
  protected final String TEXT_22 = "_kafkaProperties, new org.apache.kafka.common.serialization.ByteArraySerializer(), new org.apache.kafka.common.serialization.ByteArraySerializer());" + NL + "    globalMap.put(\"";
  protected final String TEXT_23 = "_kafkaProducer\", ";
  protected final String TEXT_24 = "_kafkaProducer);" + NL + "}";
  protected final String TEXT_25 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
class TKafkaOutputUtil {
	
	 private INode node;

    private IConnection incomingConnection;

    private Map<String, String> kafkaProducerProperties;

    public TKafkaOutputUtil(INode node) {
        this.node = node;
        this.incomingConnection = findIncomingConnection();
        this.kafkaProducerProperties = findKafkaProducerProperties();
    }
    
    public String getInStructName() {
		return this.incomingConnection.getName() + "Struct";
	 }

    public String getEncoding() {
        return ElementParameterParser.getValue(node, "__ENCODING__");
    }

    public String getBrokerList() {
        return ElementParameterParser.getValue(node, "__BROKER_LIST__");
    }

    public String getCompression() {
        String compression = "none";
        if ("true".equals(ElementParameterParser.getValue(node, "__COMPRESS__"))) {
            compression = ElementParameterParser.getValue(node, "__COMPRESSION__").toLowerCase();
        }
        return compression;
    }

    public IConnection getIncomingConnection() {
        return this.incomingConnection;
    }

    public Map<String, String> getKafkaProducerProperties() {
        return this.kafkaProducerProperties;
    }

    public String getKafkaTopic() {
        return ElementParameterParser.getValue(node, "__KAFKA_TOPIC__");
    }

    public String getIncomingColumnName() {
        return this.incomingConnection.getMetadataTable().getListColumns().get(0).getLabel();
    }

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

    private Map<String, String> findKafkaProducerProperties() {
        Map<String, String> result = new HashMap<String, String>();
        List<Map<String, String>> producerPropertiesFromStudio = (List<Map<String, String>>) ElementParameterParser
                .getObjectValue(node, "__KAFKA_PRODUCER_PROPERTIES__");
        if(producerPropertiesFromStudio != null) {
	        for (Map<String, String> producerPropertyFromStudio : producerPropertiesFromStudio) {
	            result.put(producerPropertyFromStudio.get("PROPERTY"), producerPropertyFromStudio.get("VALUE"));
	        }
        }
        return result;
    }
}

    stringBuffer.append(TEXT_3);
    
// Parse the inputs to this javajet generator.
final CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();
final String cid = node.getUniqueName();

TKafkaOutputUtil tKafkaOutputUtil = new TKafkaOutputUtil(node);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	if(tKafkaOutputUtil.getBrokerList() == null || "".equals(tKafkaOutputUtil.getBrokerList())){

    stringBuffer.append(TEXT_6);
     
	} else {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(tKafkaOutputUtil.getBrokerList());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(tKafkaOutputUtil.getCompression());
    stringBuffer.append(TEXT_11);
    
		for(Entry<String, String> kafkaProperty : tKafkaOutputUtil.getKafkaProducerProperties().entrySet()) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(kafkaProperty.getKey());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(kafkaProperty.getValue());
    stringBuffer.append(TEXT_15);
    
		} // end for
	} // end else

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}
