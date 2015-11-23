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

public class TReservoirSamplingInMainJava
{
  protected static String nl;
  public static synchronized TReservoirSamplingInMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TReservoirSamplingInMainJava result = new TReservoirSamplingInMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "  " + NL + "\t" + NL + "\t\t";
  protected final String TEXT_3 = "Struct tempRow_";
  protected final String TEXT_4 = " = new ";
  protected final String TEXT_5 = "Struct();  " + NL + "        ";
  protected final String TEXT_6 = "      " + NL + "            tempRow_";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ";" + NL + "           ";
  protected final String TEXT_11 = "        " + NL + "  " + NL + "\t\tsampler_";
  protected final String TEXT_12 = ".onNext(tempRow_";
  protected final String TEXT_13 = ");        " + NL + NL;
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = ElementParameterParser.getValue(node, "__DESTINATION__");

    String incomingConnName = null;    
	IMetadataTable inputMetadataTable = null;
	java.util.List<IMetadataColumn> inputColumns = null;

    List<? extends IConnection> incomingConnections = node.getIncomingConnections();
	if (incomingConnections != null && !incomingConnections.isEmpty()) {	
		for (IConnection conn : incomingConnections) {
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				incomingConnName = conn.getName();				
				inputMetadataTable = conn.getMetadataTable();
				inputColumns = inputMetadataTable.getListColumns();
				break;
			}
		}
	}  
  
    stringBuffer.append(TEXT_2);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_5);
     
        for(int i = 0; i < inputColumns.size(); i++) {            
            IMetadataColumn column = inputColumns.get(i);
        
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_10);
    
        }
        
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
