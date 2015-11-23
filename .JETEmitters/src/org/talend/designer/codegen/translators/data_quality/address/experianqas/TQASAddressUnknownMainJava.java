package org.talend.designer.codegen.translators.data_quality.address.experianqas;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.talend.commons.utils.StringUtils;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnectionCategory;

public class TQASAddressUnknownMainJava
{
  protected static String nl;
  public static synchronized TQASAddressUnknownMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TQASAddressUnknownMainJava result = new TQASAddressUnknownMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = " = null;\t\t\t\t";
  protected final String TEXT_4 = NL + "\tString[] results_";
  protected final String TEXT_5 = " = null;" + NL + "    results_";
  protected final String TEXT_6 = " = qasClient_";
  protected final String TEXT_7 = ".getRightAddress(";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = ");" + NL + "if(results_";
  protected final String TEXT_10 = "[0].equals(\"None\") || results_";
  protected final String TEXT_11 = "[0].equals(\"Multiple\")){";
  protected final String TEXT_12 = NL + "\tif(";
  protected final String TEXT_13 = " == null){" + NL + "\t\t";
  protected final String TEXT_14 = " = new ";
  protected final String TEXT_15 = "Struct();" + NL + "\t}";
  protected final String TEXT_16 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = "=";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ";";
  protected final String TEXT_21 = NL + "}" + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_22 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String addressToVerify = ElementParameterParser.getValue(node, "__ANALYZED_COLUMN__");
	List<IMetadataTable> metadatas = node.getMetadataList();
	
	boolean unknownExist = false;
	
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			String cid = node.getUniqueName();
			List< ? extends IConnection> conns = node.getIncomingConnections();
			if(conns!=null){
				if (conns.size()>0){
					IConnection conn =conns.get(0);

String unknownConnName = null;
List<? extends IConnection> connsUnknown = node.getOutgoingConnections("UNKNOWN");
if(connsUnknown != null && connsUnknown.size() > 0) {
    for(IConnection vConn : connsUnknown) {
        unknownConnName = vConn.getName();
        unknownExist = true;

    stringBuffer.append(TEXT_2);
    stringBuffer.append( unknownConnName );
    stringBuffer.append(TEXT_3);
           
    }
}

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( addressToVerify );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    
	if( unknownExist ){

    stringBuffer.append(TEXT_12);
    stringBuffer.append( unknownConnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( unknownConnName );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( unknownConnName );
    stringBuffer.append(TEXT_15);
     }

	                if (connsUnknown!=null) {
    	            	List<IMetadataColumn> columnsout = metadata.getListColumns();
            	        for (int i=0;i < connsUnknown.size();i++) {
            	        	IConnection connout = connsUnknown.get(i);
                    	    if(connout.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    	                        for (int j = 0; j < columnsout.size(); j++) {
									IMetadataColumn columnout=columnsout.get(j);

    stringBuffer.append(TEXT_16);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(columnout.getLabel() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(columnout.getLabel() );
    stringBuffer.append(TEXT_20);
    
								}
							}
						}
					}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    				}
			}
		}
	}

    return stringBuffer.toString();
  }
}
