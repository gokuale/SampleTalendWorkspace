package org.talend.designer.codegen.translators.messaging.mqtt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.NodeUtil;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TMQTTInputSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TMQTTInputSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMQTTInputSparkstreamingcodeJava result = new TMQTTInputSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "public static class MQTTInputSetting_";
  protected final String TEXT_2 = " implements java.io.Serializable{" + NL + "\tprivate String topic;" + NL + "\tpublic String getTopic(){" + NL + "\t\treturn topic;" + NL + "\t}" + NL + "\tpublic void setTopic(String topic){" + NL + "\t\tthis.topic = topic;" + NL + "\t}" + NL + "\tprivate String brokerUrl;" + NL + "\tpublic String getBrokerUrl(){" + NL + "\t\treturn brokerUrl;" + NL + "\t}" + NL + "\tpublic void setBrokerUrl(String brokerUrl){" + NL + "\t\tthis.brokerUrl = brokerUrl;" + NL + "\t}" + NL + "\tprivate String encoding;" + NL + "\tpublic String getEncoding(){" + NL + "\t\treturn encoding;" + NL + "\t}" + NL + "\tpublic void setEncoding(String encoding){" + NL + "\t\tthis.encoding = encoding;" + NL + "\t}" + NL + "\tprivate int qos;" + NL + "\tpublic int getQos(){" + NL + "\t\treturn qos;" + NL + "\t}" + NL + "\tpublic void setQos(int qos){" + NL + "\t\tthis.qos = qos;" + NL + "\t}" + NL + "}" + NL + "public static class Receiver_";
  protected final String TEXT_3 = " extends org.apache.spark.streaming.receiver.Receiver<";
  protected final String TEXT_4 = ">{" + NL + "\tMQTTInputSetting_";
  protected final String TEXT_5 = " setting;" + NL + "\tpublic Receiver_";
  protected final String TEXT_6 = "(MQTTInputSetting_";
  protected final String TEXT_7 = " setting, org.apache.spark.storage.StorageLevel storageLevel) {" + NL + "        super(storageLevel);" + NL + "        this.setting = setting;" + NL + "    }" + NL + "    " + NL + "    public void onStart() {" + NL + "        org.eclipse.paho.client.mqttv3.MqttCallback callback = new org.eclipse.paho.client.mqttv3.MqttCallback(){" + NL + "        \tpublic void connectionLost(Throwable cause){" + NL + "        \t\trestart(\"Connection lost \", cause);" + NL + "        \t}" + NL + "        \tpublic void messageArrived(String topic, org.eclipse.paho.client.mqttv3.MqttMessage message) throws Exception{" + NL + "        \t\t";
  protected final String TEXT_8 = " row = new ";
  protected final String TEXT_9 = "();" + NL + "        \t\t";
  protected final String TEXT_10 = NL + "        \t\t\trow.topic = topic;" + NL + "        \t\t";
  protected final String TEXT_11 = NL + "        \t\trow.payload = new String(message.getPayload(), setting.getEncoding());" + NL + "        \t\tstore(row);" + NL + "        \t}" + NL + "        \tpublic void deliveryComplete(org.eclipse.paho.client.mqttv3.IMqttDeliveryToken token){}" + NL + "        };" + NL + "        org.eclipse.paho.client.mqttv3.persist.MemoryPersistence persistence = new org.eclipse.paho.client.mqttv3.persist.MemoryPersistence();" + NL + "        org.eclipse.paho.client.mqttv3.MqttClient client = null;" + NL + "        try{" + NL + "\t        client = new org.eclipse.paho.client.mqttv3.MqttClient(setting.getBrokerUrl(), org.eclipse.paho.client.mqttv3.MqttClient.generateClientId(), persistence);" + NL + "\t        client.setCallback(callback);" + NL + "\t\t    client.connect();" + NL + "\t\t    client.subscribe(setting.getTopic(), setting.getQos());" + NL + "\t    }catch(Exception ex){" + NL + "\t    }" + NL + "    }" + NL + "    public void onStop() {" + NL + "" + NL + "    }" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    
IMetadataTable metadata = null;
IConnection conn = null;
List<IMetadataColumn> columns = null;
List<IMetadataTable> metadatas = node.getMetadataList();    
if((metadatas != null) && (metadatas.size() > 0)){
    metadata = metadatas.get(0);
    if(metadata != null){
        columns = metadata.getListColumns();        
    }
}

List<? extends IConnection> conns = node.getOutgoingSortedConnections();
if(conns != null && conns.size() > 0 && conns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
    conn = conns.get(0);
}   

if(columns == null || columns.isEmpty() || conn == null){
	return "";
}
String outRowStruct = codeGenArgument.getRecordStructName(conn);
String connName = conn.getName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(outRowStruct);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(outRowStruct);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(outRowStruct);
    stringBuffer.append(TEXT_9);
    
        		boolean includeTopic = "true".equals(ElementParameterParser.getValue(node, "__INCLUDE_TOPIC__"));
        		if(includeTopic){
        		
    stringBuffer.append(TEXT_10);
    
        		}
        		
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
