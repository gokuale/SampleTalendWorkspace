package org.talend.designer.codegen.translators.messaging.kinesis;

import java.util.Map.Entry;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TKinesisInputSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TKinesisInputSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKinesisInputSparkstreamingcodeJava result = new TKinesisInputSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "public static class ";
  protected final String TEXT_2 = "_MapToOutputStruct implements org.apache.spark.api.java.function.Function<byte[], ";
  protected final String TEXT_3 = "> {" + NL + "    @Override" + NL + "    public ";
  protected final String TEXT_4 = " call(byte[] input) throws Exception {";
  protected final String TEXT_5 = NL + "        ";
  protected final String TEXT_6 = " output = new ";
  protected final String TEXT_7 = "();" + NL + "        output.payload = new String(input);" + NL + "        return output;" + NL + "    }" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
IConnection conn = node.getOutgoingConnections().get(0);
String connectionTypeName = codeGenArgument.getRecordStructName(conn);
String connName = conn.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
