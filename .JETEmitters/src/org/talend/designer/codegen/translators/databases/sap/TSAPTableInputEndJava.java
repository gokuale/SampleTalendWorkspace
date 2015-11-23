package org.talend.designer.codegen.translators.databases.sap;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSAPTableInputEndJava
{
  protected static String nl;
  public static synchronized TSAPTableInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPTableInputEndJava result = new TSAPTableInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t} while(data_";
  protected final String TEXT_3 = ".nextRow());" + NL + "} finally {" + NL + "\t";
  protected final String TEXT_4 = NL + "\tif(connection_";
  protected final String TEXT_5 = "!=null && connection_";
  protected final String TEXT_6 = ".isAlive()) {" + NL + "\t\tconnection_";
  protected final String TEXT_7 = ".close();" + NL + "\t}" + NL + "\t";
  protected final String TEXT_8 = NL + "}";
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	List<? extends IConnection> outputConnections = node.getOutgoingSortedConnections();
	if((outputConnections == null) || (outputConnections.size() == 0)) {
		return "";
	}
	IConnection outputConnection = outputConnections.get(0);
	
	if(!outputConnection.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		return "";
	}
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas == null) && (metadatas.size() == 0) || (metadatas.get(0) == null)) {
		return "";
	}
	IMetadataTable metadata = metadatas.get(0);
	
	List<IMetadataColumn> columnList = metadata.getListColumns();
	if((columnList == null) || (columnList.size() == 0)) {
		return "";
	}
	
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    if(!useExistingConn) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
