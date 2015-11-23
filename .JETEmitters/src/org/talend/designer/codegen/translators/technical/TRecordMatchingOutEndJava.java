package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.EConnectionType;
import java.util.List;
import java.util.Map;

public class TRecordMatchingOutEndJava
{
  protected static String nl;
  public static synchronized TRecordMatchingOutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRecordMatchingOutEndJava result = new TRecordMatchingOutEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  fsi_";
  protected final String TEXT_2 = ".endPut(); ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
String connNameMain = null;
List<Map<String, String>> listMapJoinCols = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JOIN_KEY__");
  
if (listMapJoinCols == null || listMapJoinCols.size() == 0){
  return "";
}
if (inConns.size() > 0){
  connNameMain = inConns.get(0).getName();
  
    stringBuffer.append(TEXT_1);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_2);
    
}

    return stringBuffer.toString();
  }
}
