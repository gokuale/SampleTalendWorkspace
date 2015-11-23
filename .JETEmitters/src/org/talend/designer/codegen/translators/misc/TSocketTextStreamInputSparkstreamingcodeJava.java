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

public class TSocketTextStreamInputSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TSocketTextStreamInputSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSocketTextStreamInputSparkstreamingcodeJava result = new TSocketTextStreamInputSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tpublic static class ";
  protected final String TEXT_2 = "_Function implements org.apache.spark.api.java.function.Function<String, ";
  protected final String TEXT_3 = "> {" + NL + "" + NL + "        private ContextProperties context = null;" + NL + "" + NL + "        public ";
  protected final String TEXT_4 = "_Function(JobConf job) {" + NL + "            this.context = new ContextProperties(job);" + NL + "        }" + NL + "" + NL + "\t    public ";
  protected final String TEXT_5 = " call(String data) throws java.lang.Exception {" + NL + "\t        ";
  protected final String TEXT_6 = " row1 = new ";
  protected final String TEXT_7 = "();" + NL + "\t        row1.line = data;" + NL + "\t        return row1;" + NL + "\t    }" + NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final IBigDataNode bigDataNode = (IBigDataNode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

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
    stringBuffer.append(outgoingConnectionTypeName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outgoingConnectionTypeName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(outgoingConnectionTypeName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(outgoingConnectionTypeName);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
