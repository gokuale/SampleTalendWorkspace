package org.talend.designer.codegen.translators.business.marketo;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TMarketoListOperationBeginJava
{
  protected static String nl;
  public static synchronized TMarketoListOperationBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoListOperationBeginJava result = new TMarketoListOperationBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "int nb_call_";
  protected final String TEXT_2 = " = 0;" + NL + "globalMap.put(\"";
  protected final String TEXT_3 = "_NB_CALL\",0);  ";
  protected final String TEXT_4 = NL + "\t\t\t\t\tboolean firstList_";
  protected final String TEXT_5 = " = true;" + NL + "\t\t\t\t\tString listTypeFlag_";
  protected final String TEXT_6 = "=\"\";" + NL + "\t\t\t\t\tString listValueFlag_";
  protected final String TEXT_7 = "=\"\";";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + "                ";
  protected final String TEXT_10 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_11 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = "; ";
  protected final String TEXT_16 = NL + "                " + NL + "\t\t\t\torg.talend.marketo.Client client_";
  protected final String TEXT_17 = " = new org.talend.marketo.Client(";
  protected final String TEXT_18 = ",decryptedPassword_";
  protected final String TEXT_19 = ",";
  protected final String TEXT_20 = ");" + NL + "\t\t\t\tclient_";
  protected final String TEXT_21 = ".setTimeout(";
  protected final String TEXT_22 = ");" + NL + "\t\t\t\tjava.util.List<com.marketo.www.mktows.LeadKey> leadKeyList_";
  protected final String TEXT_23 = " = new java.util.ArrayList<com.marketo.www.mktows.LeadKey>();" + NL + "\t\t\t\tcom.marketo.www.mktows.ResultListOperation resultListOperation_";
  protected final String TEXT_24 = " = null;" + NL + "\t\t\t\t" + NL + "\t\t\t\tboolean whetherReject_";
  protected final String TEXT_25 = " = false;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    
   	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");

    String clientAccessID = ElementParameterParser.getValue(node, "__CLIENT_ACCESSID__");
    String operation = ElementParameterParser.getValue(node, "__OPERATION__");
    boolean mutipleOperation = ("true").equals(ElementParameterParser.getValue(node,"__MUTIPLE_OPERATION__"));
	boolean isMutiple = false;
	if(mutipleOperation&&!operation.equals("ISMEMBEROFLIST")){
		isMutiple = true;
	}
	String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");
    List<IMetadataTable> metadatas = node.getMetadataList();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    
    if (metadata!=null) {//2
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	
    	for (IConnection conn : conns) {//3
    	
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
    			if(isMutiple){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
     
				}

    stringBuffer.append(TEXT_8);
    
                String passwordFieldName = "__SECRET_KEY__";
                
    stringBuffer.append(TEXT_9);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_12);
    } else {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(clientAccessID);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
     
			}	
		}
	}	
}

    return stringBuffer.toString();
  }
}
