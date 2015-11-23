package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TSocketTextStreamInputSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TSocketTextStreamInputSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSocketTextStreamInputSparkstreamingconfigJava result = new TSocketTextStreamInputSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "org.apache.spark.streaming.api.java.JavaDStream<String> lines_";
  protected final String TEXT_2 = " = ctx.socketTextStream(";
  protected final String TEXT_3 = ", Integer.valueOf(";
  protected final String TEXT_4 = ").intValue());" + NL + "org.apache.spark.streaming.api.java.JavaDStream<";
  protected final String TEXT_5 = "> rdd_";
  protected final String TEXT_6 = " = lines_";
  protected final String TEXT_7 = ".map(new ";
  protected final String TEXT_8 = "_Function(job));";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final IBigDataNode bigDataNode = (IBigDataNode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

final String host = ElementParameterParser.getValue(node, "__HOST__");
final String port = ElementParameterParser.getValue(node, "__PORT__");

//outgoing connection
IConnection outgoingConnection = null;
    if (node.getOutgoingConnections() != null) {
        for (IConnection connection : node.getOutgoingConnections()) {
            if (connection.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
                outgoingConnection = connection;
                break;
            }
        }
    }



String outgoingConnectionName = outgoingConnection.getName();
String outgoingConnectionTypeName = codeGenArgument.getRecordStructName(outgoingConnection);


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outgoingConnectionTypeName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(outgoingConnection.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
