package org.talend.designer.codegen.translators.messaging.kinesis;

import java.util.Map.Entry;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.common.output.TKinesisOutputUtil;

public class TKinesisOutputSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TKinesisOutputSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TKinesisOutputSparkstreamingconfigJava result = new TKinesisOutputSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL;
  protected final String TEXT_2 = NL + NL + "System.setProperty(\"aws.accessKeyId\", ";
  protected final String TEXT_3 = ");" + NL + "//Get the password under the variable decryptedPassword";
  protected final String TEXT_4 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_5 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = "; ";
  protected final String TEXT_10 = NL + "System.setProperty(\"aws.secretKey\", decryptedPassword_";
  protected final String TEXT_11 = ");" + NL + "" + NL + "rdd_";
  protected final String TEXT_12 = ".foreachRDD(new ";
  protected final String TEXT_13 = "_ForeachRDD_KinesisMessageSender(job));";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();
final String cid = node.getUniqueName();
IConnection conn = node.getIncomingConnections().get(0);
String connName = conn.getUniqueName();

String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
String passwordFieldName = "__SECRET_KEY__";

    stringBuffer.append(TEXT_2);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_3);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_6);
    } else {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
