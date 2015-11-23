package org.talend.designer.codegen.translators.data_quality.matching;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.EConnectionType;
import java.util.List;

public class TRecordMatchingEndJava
{
  protected static String nl;
  public static synchronized TRecordMatchingEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRecordMatchingEndJava result = new TRecordMatchingEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        globalMap.put(\"";
  protected final String TEXT_2 = "_NB_MATCH_LINE\", nb_matches_";
  protected final String TEXT_3 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_4 = "_NB_POSSIBLE_MATCH_LINE\", nb_pMatches_";
  protected final String TEXT_5 = ");" + NL + "        globalMap.put(\"";
  protected final String TEXT_6 = "_NB_NONE_MATCH_LINE\", nb_nMatches_";
  protected final String TEXT_7 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();

if ((metadatas != null) && (metadatas.size() > 0)) {
  IMetadataTable metadata = metadatas.get(0);
  
  if (metadata != null){
    List< ? extends IConnection> connsIn = node.getIncomingConnections();
    
    for (IConnection connIn: connsIn){
    
      if (connIn.getLineStyle().equals(EConnectionType.FLOW_REF)){
        String connInName = connIn.getName();
        
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
      }
    }
  }
}

    return stringBuffer.toString();
  }
}
