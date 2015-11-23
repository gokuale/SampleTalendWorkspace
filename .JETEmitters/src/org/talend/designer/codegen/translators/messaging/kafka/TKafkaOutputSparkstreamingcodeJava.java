package org.talend.designer.codegen.translators.messaging.kafka;

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
import org.talend.designer.common.tkafkaoutput.TKafkaOutputUtil;

public class TKafkaOutputSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TKafkaOutputSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKafkaOutputSparkstreamingcodeJava result = new TKafkaOutputSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "public static class ";
  protected final String TEXT_3 = "_ForeachRDD_KafkaMessageSender<KEY> implements org.apache.spark.api.java.function.Function<org.apache.spark.api.java.JavaPairRDD<KEY,";
  protected final String TEXT_4 = "> , Void> {" + NL + "" + NL + "\tprivate java.util.Properties kafkaProperties;" + NL + "" + NL + "\tprivate java.util.Set<String> topics;" + NL + "" + NL + "\tprivate ContextProperties context;" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_5 = "_ForeachRDD_KafkaMessageSender(JobConf job, java.util.Properties kafkaProperties, java.util.Set<String> topics){" + NL + "\t\tthis.kafkaProperties = kafkaProperties;" + NL + "\t\tthis.topics = topics;" + NL + "\t\tthis.context = new ContextProperties(job);" + NL + "\t}" + NL + "" + NL + "\tpublic Void call(org.apache.spark.api.java.JavaPairRDD<KEY,";
  protected final String TEXT_6 = "> rdd) {" + NL + "\t\trdd.foreachPartition(new ";
  protected final String TEXT_7 = "_ForeachPartition_KafkaMessageSender<KEY>(context, kafkaProperties, topics));" + NL + "\t\treturn null;" + NL + "\t}" + NL + "}" + NL + "" + NL + "public static class ";
  protected final String TEXT_8 = "_ForeachPartition_KafkaMessageSender<KEY> implements org.apache.spark.api.java.function.VoidFunction<java.util.Iterator<scala.Tuple2<KEY,";
  protected final String TEXT_9 = ">>> {" + NL + "" + NL + "\tprivate java.util.Properties kafkaProperties;" + NL + "" + NL + "\tprivate java.util.Set<String> topics;" + NL + "" + NL + "\tprivate ContextProperties context;" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_10 = "_ForeachPartition_KafkaMessageSender(ContextProperties context, java.util.Properties kafkaProperties, java.util.Set<String> topics){" + NL + "\t\tthis.kafkaProperties = kafkaProperties;" + NL + "\t\tthis.topics = topics;" + NL + "\t\tthis.context = context;" + NL + "\t}" + NL + "" + NL + "\tpublic void call(java.util.Iterator<scala.Tuple2<KEY,";
  protected final String TEXT_11 = ">> iterator) {" + NL + "\t\torg.apache.kafka.clients.producer.KafkaProducer<byte[], byte[]> kafkaProducer = new org.apache.kafka.clients.producer.KafkaProducer<byte[], byte[]>(kafkaProperties, new org.apache.kafka.common.serialization.ByteArraySerializer(), new org.apache.kafka.common.serialization.ByteArraySerializer());" + NL + "\t\tscala.Tuple2<KEY,";
  protected final String TEXT_12 = "> tuple;" + NL + "\t\twhile(iterator.hasNext()) {" + NL + "\t\t\ttuple = iterator.next();" + NL + "\t\t\tif(tuple._2() != null){" + NL + "\t\t\t\tfor(String topic : topics){" + NL + "\t\t\t\t\tjava.nio.ByteBuffer byteBuffer = tuple._2().";
  protected final String TEXT_13 = ";" + NL + "\t\t\t\t\tif(byteBuffer != null){" + NL + "\t\t\t\t\t\tbyte[] value = new byte[byteBuffer.remaining()];" + NL + "\t\t\t\t\t\tbyteBuffer.get(value);" + NL + "\t\t\t\t\t\tkafkaProducer.send(new org.apache.kafka.clients.producer.ProducerRecord<byte[], byte[]>(topic, value));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tkafkaProducer.close();" + NL + "\t}" + NL + "}" + NL + NL;
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();
final TKafkaOutputUtil tKafkaOutputUtil = new TKafkaOutputUtil(node);

final String cid = node.getUniqueName();
String inStructName = codeGenArgument.getRecordStructName(tKafkaOutputUtil.getIncomingConnection());


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
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(tKafkaOutputUtil.getIncomingColumnName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
