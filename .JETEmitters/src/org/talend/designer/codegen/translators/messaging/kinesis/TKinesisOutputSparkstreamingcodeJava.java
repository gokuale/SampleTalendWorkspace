package org.talend.designer.codegen.translators.messaging.kinesis;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.common.output.TKinesisOutputUtil;

public class TKinesisOutputSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TKinesisOutputSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKinesisOutputSparkstreamingcodeJava result = new TKinesisOutputSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "public static class ";
  protected final String TEXT_3 = "_ForeachRDD_KinesisMessageSender<KEY> implements org.apache.spark.api.java.function.Function<org.apache.spark.api.java.JavaPairRDD<KEY,";
  protected final String TEXT_4 = "> , Void> {" + NL + "" + NL + "    private ContextProperties context;" + NL + "" + NL + "    public ";
  protected final String TEXT_5 = "_ForeachRDD_KinesisMessageSender(JobConf job){" + NL + "        this.context = new ContextProperties(job);" + NL + "    }" + NL + "" + NL + "    public Void call(org.apache.spark.api.java.JavaPairRDD<KEY,";
  protected final String TEXT_6 = "> rdd) {" + NL + "        rdd.foreachPartition(new ";
  protected final String TEXT_7 = "_ForeachPartition_KinesisMessageSender<KEY>(context));" + NL + "        return null;" + NL + "    }" + NL + "}" + NL + "" + NL + "public static class ";
  protected final String TEXT_8 = "_ForeachPartition_KinesisMessageSender<KEY> implements org.apache.spark.api.java.function.VoidFunction<java.util.Iterator<scala.Tuple2<KEY,";
  protected final String TEXT_9 = ">>> {" + NL + "" + NL + "    private ContextProperties context;" + NL + "" + NL + "    public ";
  protected final String TEXT_10 = "_ForeachPartition_KinesisMessageSender(ContextProperties context){" + NL + "        this.context = context;" + NL + "    }" + NL + "" + NL + "    public void call(java.util.Iterator<scala.Tuple2<KEY,";
  protected final String TEXT_11 = ">> iterator) {" + NL + "        com.amazonaws.services.kinesis.AmazonKinesisClient client = new com.amazonaws.services.kinesis.AmazonKinesisClient();" + NL + "        Integer shard = 0;" + NL + "        client.setEndpoint(";
  protected final String TEXT_12 = ");" + NL + "" + NL + "        scala.Tuple2<KEY, ";
  protected final String TEXT_13 = "> tuple;" + NL + "        while (iterator.hasNext()) {" + NL + "            if (";
  protected final String TEXT_14 = " > 1) {" + NL + "                shard = shard + 1 % ";
  protected final String TEXT_15 = ";" + NL + "            }" + NL + "            tuple = iterator.next();" + NL + "            if (tuple._2() != null) {" + NL + "                /* Create a PutRecordRequest with an Array[Byte] version of the data */" + NL + "                com.amazonaws.services.kinesis.model.PutRecordRequest putRecordRequest =" + NL + "                        new com.amazonaws.services.kinesis.model.PutRecordRequest()" + NL + "                            .withStreamName(";
  protected final String TEXT_16 = ")" + NL + "                            .withPartitionKey(\"partitionKey-\" + shard)" + NL + "                            .withData(tuple._2().";
  protected final String TEXT_17 = ");" + NL + "" + NL + "                /* Put the record onto the stream and capture the PutRecordResult */" + NL + "                client.putRecord(putRecordRequest);" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "}" + NL + NL;
  protected final String TEXT_18 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();
final String cid = node.getUniqueName();
final TKinesisOutputUtil tKinesisOutputUtil = new TKinesisOutputUtil(node);

String inStructName = codeGenArgument.getRecordStructName(tKinesisOutputUtil.getIncomingConnection());

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(tKinesisOutputUtil.getEndpointUrl());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(tKinesisOutputUtil.getPartitionNumber());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(tKinesisOutputUtil.getPartitionNumber());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(tKinesisOutputUtil.getStreamName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(tKinesisOutputUtil.getIncomingColumnName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}
