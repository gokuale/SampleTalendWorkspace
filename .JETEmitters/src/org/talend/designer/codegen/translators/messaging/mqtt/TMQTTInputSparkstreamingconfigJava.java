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

public class TMQTTInputSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TMQTTInputSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMQTTInputSparkstreamingconfigJava result = new TMQTTInputSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "MQTTInputSetting_";
  protected final String TEXT_2 = " setting_";
  protected final String TEXT_3 = " = new MQTTInputSetting_";
  protected final String TEXT_4 = "();";
  protected final String TEXT_5 = NL + "setting_";
  protected final String TEXT_6 = ".setTopic(";
  protected final String TEXT_7 = ");" + NL + "setting_";
  protected final String TEXT_8 = ".setBrokerUrl(";
  protected final String TEXT_9 = ");" + NL + "setting_";
  protected final String TEXT_10 = ".setEncoding(";
  protected final String TEXT_11 = ");" + NL + "setting_";
  protected final String TEXT_12 = ".setQos(";
  protected final String TEXT_13 = ");" + NL + "org.apache.spark.streaming.api.java.JavaDStream<";
  protected final String TEXT_14 = "> rdd_";
  protected final String TEXT_15 = " = ctx.receiverStream(new Receiver_";
  protected final String TEXT_16 = "(setting_";
  protected final String TEXT_17 = ", org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK_SER_2()));";
  protected final String TEXT_18 = NL;

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
String brokerUrl = ElementParameterParser.getValue(node, "__BROKER_URL__");
String topic = ElementParameterParser.getValue(node, "__TOPIC__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String qos = ElementParameterParser.getValue(node, "__QOS__");

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(topic);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(brokerUrl);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(qos);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outRowStruct);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}
