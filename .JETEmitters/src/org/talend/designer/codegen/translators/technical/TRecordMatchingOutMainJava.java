package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.EConnectionType;
import java.util.List;
import java.util.Map;

public class TRecordMatchingOutMainJava
{
  protected static String nl;
  public static synchronized TRecordMatchingOutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRecordMatchingOutMainJava result = new TRecordMatchingOutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    ";
  protected final String TEXT_2 = " exprKey_";
  protected final String TEXT_3 = "__";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = ";";
  protected final String TEXT_7 = NL + "  SortableRow_";
  protected final String TEXT_8 = " rsc_";
  protected final String TEXT_9 = " = fsi_";
  protected final String TEXT_10 = ".getNextFreeRow();" + NL + "  rsc_";
  protected final String TEXT_11 = ".fillFrom(";
  protected final String TEXT_12 = ");" + NL + "  fsi_";
  protected final String TEXT_13 = ".put(rsc_";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + NL;
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<? extends IConnection> inConns = node.getIncomingConnections();
IConnection inMainCon = null, inLookupCon = null;
String connNameMain = null, connNameLookUp = null;

for (IConnection connIn : inConns){  
  if (connIn.getLineStyle().equals(EConnectionType.FLOW_REF)){     
    inLookupCon = connIn;
    connNameLookUp = connIn.getName();
  } else if (connIn.getLineStyle().equals(EConnectionType.FLOW_MAIN)){ 
    inMainCon = connIn;  
    connNameMain = connIn.getName();
  }
}

if (connNameLookUp == null || connNameMain == null){
  return "";
}
List<IMetadataTable> metadatas = node.getMetadataList();
 
if ((metadatas != null)&&(metadatas.size() > 0)) {
  IMetadataTable metadata = metadatas.get(0);
  List<IMetadataColumn> metaColumns = null;
    
  if (metadata != null) {
    metaColumns = metadata.getListColumns();
  }
  List<Map<String, String>> listMapJoinCols = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JOIN_KEY__");
  
  if (listMapJoinCols == null || listMapJoinCols.size() == 0){
    return "";
  }
  
  List<Map<String, String>> listBlocking = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BLOCKING_DEFINITION__");
  StringBuffer sb = new StringBuffer();
    
  for (Map<String, String> mapBlocking : listBlocking){
    String sMainColName = mapBlocking.get("INPUT_COLUMN");
    String sLookupColName = mapBlocking.get("LOOKUP_COLUMN");
    IMetadataColumn columnInSchema = inMainCon.getMetadataTable().getColumn(sMainColName);
    String sColumnType = JavaTypesManager.getTypeToGenerate(columnInSchema.getTalendType(), columnInSchema.isNullable());
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(sColumnType);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(sLookupColName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sMainColName);
    stringBuffer.append(TEXT_6);
    
    sb.append(",").append("exprKey_").append(connNameLookUp).append("__").append(sLookupColName);
  }
  
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connNameMain);
    stringBuffer.append(sb.toString());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_14);
    
}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
