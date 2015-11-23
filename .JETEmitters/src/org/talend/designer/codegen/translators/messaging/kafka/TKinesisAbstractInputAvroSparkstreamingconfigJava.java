package org.talend.designer.codegen.translators.messaging.kafka;

import java.util.Map.Entry;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TKinesisAbstractInputAvroSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TKinesisAbstractInputAvroSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKinesisAbstractInputAvroSparkstreamingconfigJava result = new TKinesisAbstractInputAvroSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    String avroSchema_";
  protected final String TEXT_3 = " = org.apache.commons.io.FileUtils.readFileToString(new java.io.File(";
  protected final String TEXT_4 = "));";
  protected final String TEXT_5 = NL + "System.setProperty(\"aws.accessKeyId\", ";
  protected final String TEXT_6 = ");" + NL + "//Get the password under the variable decryptedPassword";
  protected final String TEXT_7 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_8 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = "; ";
  protected final String TEXT_13 = NL + "System.setProperty(\"aws.secretKey\", decryptedPassword_";
  protected final String TEXT_14 = ");" + NL + "" + NL + "org.apache.spark.streaming.api.java.JavaPairDStream<org.apache.hadoop.io.NullWritable, org.apache.hadoop.io.ObjectWritable> rdd_";
  protected final String TEXT_15 = " = " + NL + "          org.apache.spark.streaming.kinesis.KinesisUtils.createStream(ctx, ";
  protected final String TEXT_16 = ", ";
  protected final String TEXT_17 = "," + NL + "                  new org.apache.spark.streaming.Duration(";
  protected final String TEXT_18 = ")," + NL + "                  com.amazonaws.services.kinesis.clientlibrary.lib.worker.InitialPositionInStream.";
  protected final String TEXT_19 = "," + NL + "                  org.apache.spark.storage.StorageLevel.";
  protected final String TEXT_20 = "())" + NL + "          .mapToPair(new ";
  protected final String TEXT_21 = "_MapToOutputStruct(";
  protected final String TEXT_22 = "));" + NL + NL + NL + NL;
  protected final String TEXT_23 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
IConnection conn = node.getOutgoingConnections().get(0);
String connectionTypeName = codeGenArgument.getRecordStructName(conn);
String connName = conn.getName();

String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
String passwordFieldName = "__SECRET_KEY__";

String streamName = ElementParameterParser.getValue(node, "__STREAM_NAME__");
String endpointUrl = ElementParameterParser.getValue(node, "__ENDPOINT_URL__");

String checkpointInterval = ElementParameterParser.getValue(node, "__CHECKPOINT_INTERVAL__");
String initialPositionStream = ElementParameterParser.getValue(node, "__INITIAL_POSITION_STREAM__");
String storageLevel = ElementParameterParser.getValue(node, "__STORAGELEVEL__");

boolean useHierarchical = "true".equals(ElementParameterParser.getValue(node, "__USE_HIERARCHICAL__"));

String mapToOutputStructArgument = "";
if (useHierarchical) {
    String schemaFileName = ElementParameterParser.getValue(node, "__SCHEMA_FILENAME__");
    mapToOutputStructArgument = "avroSchema_" + cid;
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(schemaFileName);
    stringBuffer.append(TEXT_4);
    
}

    stringBuffer.append(TEXT_5);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_6);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_9);
    } else {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(streamName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(endpointUrl);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(checkpointInterval);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(initialPositionStream);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(storageLevel);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(mapToOutputStructArgument);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_23);
    return stringBuffer.toString();
  }
}
