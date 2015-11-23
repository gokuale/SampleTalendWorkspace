package org.talend.designer.codegen.translators.data_quality.address.experianqas;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.EConnectionType;
import java.util.List;

public class TQASBatchAddressRowMainJava
{
  protected static String nl;
  public static synchronized TQASBatchAddressRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TQASBatchAddressRowMainJava result = new TQASBatchAddressRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "       " + NL + "        String[] retAddr_";
  protected final String TEXT_2 = " = null;" + NL + "        int iLenRetAddr_";
  protected final String TEXT_3 = " = 0;" + NL + "        " + NL + "        if (bStarted_";
  protected final String TEXT_4 = "){" + NL + "          retAddr_";
  protected final String TEXT_5 = " = qasSearch_";
  protected final String TEXT_6 = ".getAddress(";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = ");" + NL + "          iLenRetAddr_";
  protected final String TEXT_9 = " = retAddr_";
  protected final String TEXT_10 = ".length;" + NL + "                ";
  protected final String TEXT_11 = NL + "              ";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ";";
  protected final String TEXT_16 = NL + "              ";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = " = (";
  protected final String TEXT_19 = " < iLenRetAddr_";
  protected final String TEXT_20 = ") ? retAddr_";
  protected final String TEXT_21 = "[";
  protected final String TEXT_22 = "] : null;";
  protected final String TEXT_23 = NL + "        }";
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
  CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
  INode node = (INode)codeGenArgument.getArgument();
  String cid = node.getUniqueName();
  List<IMetadataTable> metadatas = node.getMetadataList();
 
  if ((metadatas != null) && (metadatas.size() > 0)) {
    IMetadataTable metadata = metadatas.get(0);
    
    if (metadata != null) {
      List<IMetadataColumn> colums = metadata.getListColumns();
      List<? extends IConnection> connsIn = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
      List<? extends IConnection> connsOut = node.getOutgoingSortedConnections();
      
      if (connsIn != null && connsIn.size() > 0 && connsOut != null && connsOut.size() > 0){
        String inFlowName = connsIn.get(0).getName();
        String outFlowName = connsOut.get(0).getName();
        String sColumnToAnalyse = ElementParameterParser.getValue(node, "__ANALYZED_COLUMN__");
        
        
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(inFlowName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(sColumnToAnalyse);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
          int i = 0;
        
          for (IMetadataColumn column : colums){
            String sColumnName = column.getLabel();
            boolean bReadOnly = column.isReadOnly();
          
            if (!bReadOnly){
            
    stringBuffer.append(TEXT_11);
    stringBuffer.append(outFlowName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(inFlowName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_15);
    
            // ...addtional colums
            } else{
            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(outFlowName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i++);
    stringBuffer.append(TEXT_22);
    
            }
          }
          
    stringBuffer.append(TEXT_23);
    
      }
    }
  }

    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
