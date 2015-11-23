package org.talend.designer.codegen.translators.business.marketo;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TMarketoOutputExtractBeginJava
{
  protected static String nl;
  public static synchronized TMarketoOutputExtractBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoOutputExtractBeginJava result = new TMarketoOutputExtractBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tList<com.marketo.www.mktows.SyncStatus[]> extractStatusList_";
  protected final String TEXT_2 = " = (List<com.marketo.www.mktows.SyncStatus[]>)globalMap.get(\"";
  protected final String TEXT_3 = "_STATUS_LIST\");" + NL + "\t\t" + NL + "\t\tif(extractStatusList_";
  protected final String TEXT_4 = "!=null && extractStatusList_";
  protected final String TEXT_5 = ".size() >0){" + NL + "\t\t\tfor(com.marketo.www.mktows.SyncStatus[] statusArray_";
  protected final String TEXT_6 = " : extractStatusList_";
  protected final String TEXT_7 = "){" + NL + "\t\t\t\tfor(com.marketo.www.mktows.SyncStatus status_";
  protected final String TEXT_8 = " : statusArray_";
  protected final String TEXT_9 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_10 = "\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_11 = ".Id = status_";
  protected final String TEXT_12 = ".getLeadId();\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_13 = ".Status = status_";
  protected final String TEXT_14 = ".getStatus().getValue();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_15 = ".ERROR_MSG = status_";
  protected final String TEXT_16 = ".getError();\t\t\t" + NL + "\t\t\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName().replace("_In","");
	
	List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {//1
	    IMetadataTable metadata = metadatas.get(0);
	    if (metadata!=null) {//2
	    	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	    	for (IConnection conn : conns) {//3
	    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
				
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
					for(IConnection outgoingConn : outgoingConns) {
					
    stringBuffer.append(TEXT_10);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
					}		 
				}//4
			}//3
		}//2
	}//1
	
    return stringBuffer.toString();
  }
}
