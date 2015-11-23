package org.talend.designer.codegen.translators.messaging.kafka;

import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.common.tkafkainput.TKafkaInputUtil;

public class TKafkaInputSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TKafkaInputSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKafkaInputSparkstreamingcodeJava result = new TKafkaInputSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "public static class ";
  protected final String TEXT_2 = "_DecoderFromByteArrayTo";
  protected final String TEXT_3 = " implements kafka.serializer.Decoder<";
  protected final String TEXT_4 = "> {" + NL + "" + NL + "    private final kafka.serializer.StringDecoder stringDecoder;" + NL + "" + NL + "    public ";
  protected final String TEXT_5 = "_DecoderFromByteArrayTo";
  protected final String TEXT_6 = "(kafka.utils.VerifiableProperties props){" + NL + "        this.stringDecoder = new kafka.serializer.StringDecoder(props);" + NL + "    }" + NL + "" + NL + "    public ";
  protected final String TEXT_7 = " fromBytes(byte[] bytes) {";
  protected final String TEXT_8 = NL + "        ";
  protected final String TEXT_9 = " result = new ";
  protected final String TEXT_10 = "();" + NL + "        String line = this.stringDecoder.fromBytes(bytes);" + NL + "        result.";
  protected final String TEXT_11 = " = line;" + NL + "        return result;" + NL + "    }" + NL + "}" + NL + "" + NL + "public static class ";
  protected final String TEXT_12 = "_DecoderFromByteArrayToNullWritable implements kafka.serializer.Decoder<org.apache.hadoop.io.NullWritable> {" + NL + "" + NL + "    public ";
  protected final String TEXT_13 = "_DecoderFromByteArrayToNullWritable(kafka.utils.VerifiableProperties props){" + NL + "        // nothing but Decoder implementations must define a constructor with VerifiableProperties" + NL + "    }" + NL + "" + NL + "    public org.apache.hadoop.io.NullWritable fromBytes(byte[] bytes) {" + NL + "        return org.apache.hadoop.io.NullWritable.get();" + NL + "    }" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

TKafkaInputUtil tKafkaInputUtil = new TKafkaInputUtil(node);
String outStructName = codeGenArgument.getRecordStructName(tKafkaInputUtil.getOutgoingConnection());


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(tKafkaInputUtil.getOutgoingColumnName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
