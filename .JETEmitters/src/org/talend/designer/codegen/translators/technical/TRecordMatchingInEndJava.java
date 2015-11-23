package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.EConnectionType;
import java.util.List;
import java.util.Map;

public class TRecordMatchingInEndJava
{
  protected static String nl;
  public static synchronized TRecordMatchingInEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRecordMatchingInEndJava result = new TRecordMatchingInEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  }" + NL + "  globalMap.put(\"";
  protected final String TEXT_2 = "_NB_MATCH_LINE\", nb_matches_";
  protected final String TEXT_3 = ");" + NL + "  globalMap.put(\"";
  protected final String TEXT_4 = "_NB_POSSIBLE_MATCH_LINE\", nb_pMatches_";
  protected final String TEXT_5 = ");" + NL + "  globalMap.put(\"";
  protected final String TEXT_6 = "_NB_NONE_MATCH_LINE\", nb_nMatches_";
  protected final String TEXT_7 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
cid = cid.replace("_RecordMatchingIn", "");

/* incoming connections of source */
List<? extends IConnection> inConns = node.getIncomingConnections();
IConnection inMainCon = null, inLookupCon = null;
String connNameMain = null, connNameLookUp = null;

for (IConnection connIn : inConns){  
  List<? extends IConnection> srcConnIncs  = connIn.getSource().getIncomingConnections();

  for (IConnection srcConnInc : srcConnIncs){ 
    if (srcConnInc.getLineStyle().equals(EConnectionType.FLOW_REF)){     
      inLookupCon = srcConnInc;
      connNameLookUp = srcConnInc.getName();
    } else if (srcConnInc.getLineStyle().equals(EConnectionType.FLOW_MAIN)){ 
      inMainCon = srcConnInc;  
      connNameMain = srcConnInc.getName();
    }
  }
  break;
}

if (connNameLookUp == null || connNameMain == null){
  return "";
}
List<Map<String, String>> listMapJoinCols = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JOIN_KEY__");

if (listMapJoinCols != null && listMapJoinCols.size() > 0){

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

    return stringBuffer.toString();
  }
}
