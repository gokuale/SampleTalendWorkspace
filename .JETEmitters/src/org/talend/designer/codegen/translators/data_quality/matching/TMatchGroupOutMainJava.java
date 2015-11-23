package org.talend.designer.codegen.translators.data_quality.matching;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TMatchGroupOutMainJava
{
  protected static String nl;
  public static synchronized TMatchGroupOutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMatchGroupOutMainJava result = new TMatchGroupOutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  ";
  protected final String TEXT_2 = "Struct ";
  protected final String TEXT_3 = "_HashRow = new ";
  protected final String TEXT_4 = "Struct();";
  protected final String TEXT_5 = " ";
  protected final String TEXT_6 = NL + "      ";
  protected final String TEXT_7 = "_HashRow.";
  protected final String TEXT_8 = " =  ";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ";";
  protected final String TEXT_11 = NL + "    ";
  protected final String TEXT_12 = "_2Struct ";
  protected final String TEXT_13 = "_2_HashRow = new ";
  protected final String TEXT_14 = "_2Struct();";
  protected final String TEXT_15 = NL + "        ";
  protected final String TEXT_16 = "_2_HashRow.";
  protected final String TEXT_17 = " =  ";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ";";
  protected final String TEXT_20 = "        " + NL + "        blockRows_";
  protected final String TEXT_21 = ".add(";
  protected final String TEXT_22 = "_2_HashRow.getArrays());";
  protected final String TEXT_23 = NL + NL + "        blockRows_";
  protected final String TEXT_24 = ".put(";
  protected final String TEXT_25 = "_2_HashRow,null);";
  protected final String TEXT_26 = NL + "tHash_Lookup_";
  protected final String TEXT_27 = ".put(";
  protected final String TEXT_28 = "_HashRow);";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
cid = cid.replace("_GroupOut", "");

// incoming connection
List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
IConnection inConn = null;
String connNameMain = null;
 
if (inConns == null || inConns.size() == 0){
  return "";
} else{
  inConn = inConns.get(0);
  connNameMain = inConn.getName();
}
IMetadataTable table = inConn.getMetadataTable();
boolean bSortOnDisk = "true".equals(ElementParameterParser.getValue(node, "__STORE_ON_DISK__")); 
List<Map<String, String>> listBlocking = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BLOCKING_DEFINITION__");
//tMatchGroupOut->tMatchGroupIn so first node must have only one outputConnection
List<? extends IConnection> outConns = node.getOutgoingSortedConnections().get(0).getTarget().getOutgoingSortedConnections();
if(outConns==null || outConns.size()==0){
    return "";
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
//}

    for (IMetadataColumn column : table.getListColumns()){
        String sColumnName = column.getLabel();
        
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_10);
    
    }

if (listBlocking != null && listBlocking.size() > 0){
    //MOD 20130325 TDQ-1359 yyin
    
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
     
    for (Map<String, String> blocking : listBlocking){
        String sColumnName = blocking.get("INPUT_COLUMN");
        
    stringBuffer.append(TEXT_15);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_19);
    
    }//~20130325

    
    if (bSortOnDisk){

    stringBuffer.append(TEXT_20);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_22);
      }else{
    stringBuffer.append(TEXT_23);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_25);
    
    }
}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}
