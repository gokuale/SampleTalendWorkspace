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

public class TMQTTOutputSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TMQTTOutputSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMQTTOutputSparkstreamingconfigJava result = new TMQTTOutputSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "final MQTTOutputSetting_";
  protected final String TEXT_2 = " setting_";
  protected final String TEXT_3 = " = new MQTTOutputSetting_";
  protected final String TEXT_4 = "();";
  protected final String TEXT_5 = NL + "setting_";
  protected final String TEXT_6 = ".setTopic(";
  protected final String TEXT_7 = ");" + NL + "setting_";
  protected final String TEXT_8 = ".setBrokerUrl(";
  protected final String TEXT_9 = ");" + NL + "setting_";
  protected final String TEXT_10 = ".setEncoding(";
  protected final String TEXT_11 = ");" + NL + "setting_";
  protected final String TEXT_12 = ".setQos(";
  protected final String TEXT_13 = ");" + NL + "rdd_";
  protected final String TEXT_14 = ".foreachRDD(new org.apache.spark.api.java.function.Function<org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_15 = ">, Void>(){" + NL + "    public Void call(org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_16 = "> rdd) throws Exception{" + NL + "    \trdd.foreachPartition(new ";
  protected final String TEXT_17 = "_OutputFunction(setting_";
  protected final String TEXT_18 = "));" + NL + "        return null;" + NL + "    }" + NL + "});";
  protected final String TEXT_19 = NL;

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
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
