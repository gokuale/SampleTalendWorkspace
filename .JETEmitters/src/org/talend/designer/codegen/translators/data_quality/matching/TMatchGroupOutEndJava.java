package org.talend.designer.codegen.translators.data_quality.matching;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TMatchGroupOutEndJava
{
  protected static String nl;
  public static synchronized TMatchGroupOutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMatchGroupOutEndJava result = new TMatchGroupOutEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "tHash_Lookup_";
  protected final String TEXT_2 = ".endPut();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
cid = cid.replace("_GroupOut", "");
List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
String connNameMain = null;

if (inConns == null || inConns.size() == 0){
  return "";
} else{
  connNameMain = inConns.get(0).getName();
}
List<? extends IConnection> outConns = node.getOutgoingSortedConnections().get(0).getTarget().getOutgoingSortedConnections();

if (outConns == null || outConns.size() == 0){
  return "";
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
