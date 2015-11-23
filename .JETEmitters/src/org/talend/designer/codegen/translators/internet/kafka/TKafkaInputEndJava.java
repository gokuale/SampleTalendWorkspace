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

public class TKafkaInputEndJava
{
  protected static String nl;
  public static synchronized TKafkaInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKafkaInputEndJava result = new TKafkaInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "\t} // end while (";
  protected final String TEXT_5 = "_consumerIterator.hasNext())" + NL + "} catch (kafka.consumer.ConsumerTimeoutException e) {" + NL + "\t// Silently stop consuming" + NL + "}";
  protected final String TEXT_6 = NL;

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

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
