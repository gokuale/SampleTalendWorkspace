package org.talend.designer.codegen.translators.messaging.kinesis;

import java.util.Map.Entry;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TKinesisInputSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TKinesisInputSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKinesisInputSparkstreamingconfigJava result = new TKinesisInputSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "System.setProperty(\"aws.accessKeyId\", ";
  protected final String TEXT_2 = ");" + NL + "//Get the password under the variable decryptedPassword";
  protected final String TEXT_3 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_4 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = "; ";
  protected final String TEXT_9 = NL + "System.setProperty(\"aws.secretKey\", decryptedPassword_";
  protected final String TEXT_10 = ");" + NL + "" + NL + "\torg.apache.spark.streaming.api.java.JavaDStream<";
  protected final String TEXT_11 = "> rdd_";
  protected final String TEXT_12 = " = " + NL + "\t        org.apache.spark.streaming.kinesis.KinesisUtils.createStream(ctx, ";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = "," + NL + "\t                new org.apache.spark.streaming.Duration(";
  protected final String TEXT_15 = ")," + NL + "                    com.amazonaws.services.kinesis.clientlibrary.lib.worker.InitialPositionInStream.";
  protected final String TEXT_16 = "," + NL + "                    org.apache.spark.storage.StorageLevel.";
  protected final String TEXT_17 = "())" + NL + "            .map(new ";
  protected final String TEXT_18 = "_MapToOutputStruct());" + NL + NL + NL;
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
IConnection conn = node.getOutgoingConnections().get(0);
String connectionTypeName = codeGenArgument.getRecordStructName(conn);
String connName = conn.getUniqueName();

String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
String passwordFieldName = "__SECRET_KEY__";

String streamName = ElementParameterParser.getValue(node, "__STREAM_NAME__");
String endpointUrl = ElementParameterParser.getValue(node, "__ENDPOINT_URL__");

String checkpointInterval = ElementParameterParser.getValue(node, "__CHECKPOINT_INTERVAL__");
String initialPositionStream = ElementParameterParser.getValue(node, "__INITIAL_POSITION_STREAM__");
String storageLevel = ElementParameterParser.getValue(node, "__STORAGELEVEL__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_2);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_5);
    } else {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(streamName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(endpointUrl);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(checkpointInterval);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(initialPositionStream);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(storageLevel);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
