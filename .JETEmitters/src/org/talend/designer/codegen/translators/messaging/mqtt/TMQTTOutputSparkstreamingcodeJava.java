package org.talend.designer.codegen.translators.messaging.mqtt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.NodeUtil;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TMQTTOutputSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TMQTTOutputSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMQTTOutputSparkstreamingcodeJava result = new TMQTTOutputSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "public static class MQTTOutputSetting_";
  protected final String TEXT_2 = " implements java.io.Serializable{" + NL + "\tprivate String topic;" + NL + "\tpublic String getTopic(){" + NL + "\t\treturn topic;" + NL + "\t}" + NL + "\tpublic void setTopic(String topic){" + NL + "\t\tthis.topic = topic;" + NL + "\t}" + NL + "\tprivate String brokerUrl;" + NL + "\tpublic String getBrokerUrl(){" + NL + "\t\treturn brokerUrl;" + NL + "\t}" + NL + "\tpublic void setBrokerUrl(String brokerUrl){" + NL + "\t\tthis.brokerUrl = brokerUrl;" + NL + "\t}" + NL + "\tprivate String encoding;" + NL + "\tpublic String getEncoding(){" + NL + "\t\treturn encoding;" + NL + "\t}" + NL + "\tpublic void setEncoding(String encoding){" + NL + "\t\tthis.encoding = encoding;" + NL + "\t}" + NL + "\tprivate int qos;" + NL + "\tpublic int getQos(){" + NL + "\t\treturn qos;" + NL + "\t}" + NL + "\tpublic void setQos(int qos){" + NL + "\t\tthis.qos = qos;" + NL + "\t}" + NL + "}" + NL + "public static class ";
  protected final String TEXT_3 = "_OutputFunction" + NL + "    implements org.apache.spark.api.java.function.VoidFunction<java.util.Iterator<";
  protected final String TEXT_4 = ">>{" + NL + "    MQTTOutputSetting_";
  protected final String TEXT_5 = " setting;" + NL + "    public ";
  protected final String TEXT_6 = "_OutputFunction(MQTTOutputSetting_";
  protected final String TEXT_7 = " setting){" + NL + " \t\tthis.setting = setting;" + NL + "    }" + NL + "" + NL + "    public void call(java.util.Iterator<";
  protected final String TEXT_8 = "> dataIterator) throws java.lang.Exception{" + NL + "        org.eclipse.paho.client.mqttv3.MqttClient client = " + NL + "        \tnew org.eclipse.paho.client.mqttv3.MqttClient(" + NL + "        \t\tsetting.getBrokerUrl(), " + NL + "        \t\torg.eclipse.paho.client.mqttv3.MqttClient.generateClientId()," + NL + "        \t\tnew org.eclipse.paho.client.mqttv3.persist.MemoryPersistence());" + NL + "        client.connect();" + NL + "\t\twhile(dataIterator.hasNext()){";
  protected final String TEXT_9 = NL + "            ";
  protected final String TEXT_10 = " ";
  protected final String TEXT_11 = " = dataIterator.next();" + NL + "            org.eclipse.paho.client.mqttv3.MqttMessage message = null;" + NL + "            if(";
  protected final String TEXT_12 = ".payload != null){ " + NL + "            \tmessage = new org.eclipse.paho.client.mqttv3.MqttMessage(";
  protected final String TEXT_13 = ".payload.getBytes(java.nio.charset.Charset.forName(setting.getEncoding())));" + NL + "            }else{" + NL + "            \tmessage = new org.eclipse.paho.client.mqttv3.MqttMessage();" + NL + "            }" + NL + "            message.setQos(setting.getQos());" + NL + "            client.publish(setting.getTopic(), message);" + NL + "    \t}" + NL + "    \tclient.disconnect();" + NL + "    }" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    
IMetadataTable metadata = null;
IConnection conn = null;
List<IMetadataColumn> columns = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if((metadatas!=null) && (metadatas.size() > 0)){
    metadata = metadatas.get(0);
    if(metadata != null){
		columns = metadata.getListColumns();		
	}
}
List<? extends IConnection> conns = node.getIncomingConnections();
if(conns != null && conns.size() > 0 && conns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
    conn = conns.get(0);
}

if(columns == null || columns.isEmpty() || conn == null){
	return "";
}

String inRowStruct = codeGenArgument.getRecordStructName(conn);
String connName = conn.getName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
