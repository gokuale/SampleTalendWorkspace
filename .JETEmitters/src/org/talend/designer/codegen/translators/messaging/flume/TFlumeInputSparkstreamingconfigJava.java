package org.talend.designer.codegen.translators.messaging.flume;

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

public class TFlumeInputSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TFlumeInputSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFlumeInputSparkstreamingconfigJava result = new TFlumeInputSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "org.apache.spark.streaming.api.java.JavaReceiverInputDStream<org.apache.spark.streaming.flume.SparkFlumeEvent> flumeEvent_";
  protected final String TEXT_2 = " = org.apache.spark.streaming.flume.FlumeUtils.";
  protected final String TEXT_3 = "createStream";
  protected final String TEXT_4 = "createPollingStream";
  protected final String TEXT_5 = "(ctx, ";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ");" + NL + "org.apache.spark.streaming.api.java.JavaDStream<";
  protected final String TEXT_8 = "> rdd_";
  protected final String TEXT_9 = " = flumeEvent_";
  protected final String TEXT_10 = ".map(new ";
  protected final String TEXT_11 = "_convertFunction());";

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

String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
boolean isPush = "PUSH".equals(ElementParameterParser.getValue(node, "__TYPE__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    if(isPush){
    stringBuffer.append(TEXT_3);
    }else{
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(outRowStruct);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
