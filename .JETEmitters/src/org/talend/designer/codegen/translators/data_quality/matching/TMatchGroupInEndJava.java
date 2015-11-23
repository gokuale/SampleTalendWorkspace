package org.talend.designer.codegen.translators.data_quality.matching;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TMatchGroupInEndJava
{
  protected static String nl;
  public static synchronized TMatchGroupInEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMatchGroupInEndJava result = new TMatchGroupInEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "blockRows_";
  protected final String TEXT_2 = ".clear();" + NL + "blockRows_";
  protected final String TEXT_3 = " = null;" + NL + "masterRows_";
  protected final String TEXT_4 = ".clear();" + NL + "groupRows_";
  protected final String TEXT_5 = ".clear();" + NL + "" + NL + "if (tHash_Lookup_";
  protected final String TEXT_6 = " != null) {" + NL + "  tHash_Lookup_";
  protected final String TEXT_7 = ".endGet();" + NL + "}" + NL + "globalMap.remove(\"tHash_Lookup_";
  protected final String TEXT_8 = "\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
cid = cid.replace("_GroupIn", "");


List<? extends IConnection> inConns = node.getIncomingConnections().get(0).getSource().getIncomingConnections();
String connNameMain = null;

if (inConns == null || inConns.size() == 0){
  return "";
} else{
  connNameMain = inConns.get(0).getName();
}

List<? extends IConnection> outConns = node.getOutgoingSortedConnections();

if (outConns == null || outConns.size() == 0){
  return "";
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
