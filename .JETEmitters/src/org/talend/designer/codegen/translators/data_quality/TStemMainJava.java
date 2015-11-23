package org.talend.designer.codegen.translators.data_quality;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TStemMainJava
{
  protected static String nl;
  public static synchronized TStemMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TStemMainJava result = new TStemMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        ";
  protected final String TEXT_2 = "  = null;";
  protected final String TEXT_3 = NL + "      ";
  protected final String TEXT_4 = "  = new ";
  protected final String TEXT_5 = "Struct();";
  protected final String TEXT_6 = NL + "          ";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " = sh_";
  protected final String TEXT_9 = ".stemming(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = ", \"";
  protected final String TEXT_12 = "\");";
  protected final String TEXT_13 = NL + "          ";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = ";";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();  
List<IMetadataTable> metadatas = node.getMetadataList();

if ((metadatas != null) && (metadatas.size() > 0)) { 
  IMetadataTable metadata = metadatas.get(0);
  List<IMetadataColumn> listColumns = metadata.getListColumns();
  
  if (metadata != null) {    
    String sConnInName = null, sConnOutName = null;    
    //initalize in connections
    List< ? extends IConnection> connsIn  = node.getIncomingConnections();
    
    for (IConnection connIn : connsIn){
      sConnInName = connIn.getName();
      break;
    }
    if (sConnInName == null) return "";    
    //initalize out connections
    List< ? extends IConnection> connsOut = node.getOutgoingSortedConnections();
    
    for (IConnection connOut : connsOut){ 
    	if(connOut!=null && connOut.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){ 
      		sConnOutName = connOut.getName();
      
    stringBuffer.append(TEXT_1);
    stringBuffer.append(sConnOutName);
    stringBuffer.append(TEXT_2);
    
      	}
      	break;
    }

    if (sConnOutName != null){
    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(sConnOutName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(sConnOutName);
    stringBuffer.append(TEXT_5);
    
      List<Map<String, String>> tableAlgorithm = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ALGORITHM_SETTING__");
  
      for (IMetadataColumn column : listColumns) {
        String sColumnName = column.getLabel();
        String sType = JavaTypesManager.getTypeToGenerate(column.getTalendType(), true);

        if ("String".equals(sType)){
          int index = listColumns.indexOf(column);
          String algorithm = tableAlgorithm.get(index).get("ALGORITHMS");
          
    stringBuffer.append(TEXT_6);
    stringBuffer.append(sConnOutName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(sConnInName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(algorithm);
    stringBuffer.append(TEXT_12);
    
        } else{
        
    stringBuffer.append(TEXT_13);
    stringBuffer.append(sConnOutName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(sConnInName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_17);
    
        }
      }
    }
  }
}

    return stringBuffer.toString();
  }
}
