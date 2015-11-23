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

public class TReservoirSamplingOutMainJava
{
  protected static String nl;
  public static synchronized TReservoirSamplingOutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TReservoirSamplingOutMainJava result = new TReservoirSamplingOutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "  " + NL + "\tresult_";
  protected final String TEXT_3 = " = sampler_";
  protected final String TEXT_4 = ".sample();" + NL + "\t" + NL + "        " + NL + "    for (int count = 0; count < result_";
  protected final String TEXT_5 = ".size(); count++){";
  protected final String TEXT_6 = NL + "        ";
  protected final String TEXT_7 = "Struct tempRecord = result_";
  protected final String TEXT_8 = ".get(count);";
  protected final String TEXT_9 = "      ";
  protected final String TEXT_10 = NL + "            ";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = " = tempRecord.";
  protected final String TEXT_13 = ";" + NL + "           ";
  protected final String TEXT_14 = NL + "        " + NL + "        ";
  protected final String TEXT_15 = NL + "    }";
  protected final String TEXT_16 = NL + NL;
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = ElementParameterParser.getValue(node, "__ORIGIN__");
        
    String incomingConnName = null, outgoingConnName = null;    
	IMetadataTable outputMetadataTable = null;
	java.util.List<IMetadataColumn> outputColumns = null;

	String searchedComponentName = cid + "_SAMPLIN";
	List<? extends INode> generatedNodes = node.getProcess().getGeneratingNodes();
	for(INode loopNode : generatedNodes) {
		if(loopNode.getUniqueName().equals(searchedComponentName)) {
			List<IConnection> incomingConnections = (List<IConnection>) loopNode.getIncomingConnections();
			if (incomingConnections != null && !incomingConnections.isEmpty()) {
				for (IConnection conn : incomingConnections) {
					incomingConnName = conn.getName();
					break;
				}
			}
			break;
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
     
        for(int i = 0; i < outputColumns.size(); i++) {            
            IMetadataColumn column = outputColumns.get(i);
        
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_13);
    
        }
        
    stringBuffer.append(TEXT_14);
    
/* to adapt IS_MULTIPLYING_OUTPUTS option */
if (node.getOutgoingConnections() == null || node.getOutgoingConnections().size() == 0){

    stringBuffer.append(TEXT_15);
    
}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
