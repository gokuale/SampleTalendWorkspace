package org.talend.designer.codegen.translators.data_quality;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import org.talend.core.model.utils.NodeUtil;

public class TDuplicateRowMainJava
{
  protected static String nl;
  public static synchronized TDuplicateRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDuplicateRowMainJava result = new TDuplicateRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "  " + NL + "    List<";
  protected final String TEXT_3 = "Struct> ";
  protected final String TEXT_4 = "ResultList = duplicator_";
  protected final String TEXT_5 = ".process(";
  protected final String TEXT_6 = ");" + NL + "    " + NL + "    for (";
  protected final String TEXT_7 = "Struct tmpStruct : ";
  protected final String TEXT_8 = "ResultList){" + NL + "    \t";
  protected final String TEXT_9 = " = tmpStruct;" + NL + "        ";
  protected final String TEXT_10 = NL + "    }";
  protected final String TEXT_11 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    List<Map<String, String>> modifTableList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MODIF_TABLE__");

    Map<String, Map<String, String>> modifTableMap = new HashMap<String, Map<String, String>>();
	for(int i=0; i<modifTableList.size(); i++){
		Map<String, String> modif = modifTableList.get(i);
		String inputColumn = modif.get("INPUT_COLUMN");	
		modifTableMap.put(inputColumn, modif);	
	}
	
	String incomingConnName = null, outgoingConnName = null;    
	IMetadataTable inputMetadataTable = null, outputMetadataTable = null;
	java.util.List<IMetadataColumn> inputColumns = null, outputColumns = null;

    List<? extends IConnection> incomingConnections = node.getIncomingConnections();
	if (incomingConnections != null && !incomingConnections.isEmpty()) {	
		for (IConnection conn : incomingConnections) {
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                INode preNode = conn.getSource();
                while(NodeUtil.isDataAutoPropagated(preNode)&&!preNode.isSubProcessStart()) {     
                   List<? extends IConnection> preincomingConnections = preNode.getIncomingConnections();
                   if (preincomingConnections != null && !preincomingConnections.isEmpty()) {    
                      for (IConnection preNodeConn : preincomingConnections) {
                         conn=preNodeConn;
                         preNode=preNodeConn.getSource();
                         break;
                      }
                   } else {
                      break;
                   }
                }
				incomingConnName = conn.getName();				
				inputMetadataTable = conn.getMetadataTable();
				inputColumns = inputMetadataTable.getListColumns();
				break;
			}
		}
	}  
	
    List<? extends IConnection> outgoingConnections = node.getOutgoingConnections();
	if (outgoingConnections != null && !outgoingConnections.isEmpty()) {	
		for (IConnection conn : outgoingConnections) {
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				outgoingConnName = conn.getName();				
				outputMetadataTable = conn.getMetadataTable();
				outputColumns = outputMetadataTable.getListColumns();
				break;
			}
		}
	}  
                    
  
    stringBuffer.append(TEXT_2);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_9);
    
  

/* to adapt IS_MULTIPLYING_OUTPUTS option */
if (node.getOutgoingConnections() == null || node.getOutgoingConnections().size() == 0){

    stringBuffer.append(TEXT_10);
    
}

    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
