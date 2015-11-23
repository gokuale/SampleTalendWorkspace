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

public class TQASAddressRowMainJava
{
  protected static String nl;
  public static synchronized TQASAddressRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TQASAddressRowMainJava result = new TQASAddressRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\t\t\t\tString[] results_";
  protected final String TEXT_3 = " = null;" + NL + "\t\t\t\t\t\t        " + NL + "\t\t\t\t\t\t\t\tresults_";
  protected final String TEXT_4 = " = qasClient_";
  protected final String TEXT_5 = ".getRightAddress(";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ");" + NL + "\t\t\t\t\t\t\t\tboolean isInvalidResult = results_";
  protected final String TEXT_8 = "[0].equals(\"None\") || results_";
  protected final String TEXT_9 = "[0].equals(\"Multiple\");" + NL + "\t\t\t\t\t\t\t\t" + NL + "                                int iLenRetAddr_";
  protected final String TEXT_10 = " = results_";
  protected final String TEXT_11 = ".length;" + NL + "                                ";
  protected final String TEXT_12 = NL + "                                        ";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = ";";
  protected final String TEXT_17 = "            " + NL + "                                        if(isInvalidResult){";
  protected final String TEXT_18 = NL + "                                            ";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = " = \"\";" + NL + "                                        }else{                               ";
  protected final String TEXT_21 = NL + "                                            ";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = " = (";
  protected final String TEXT_24 = " < iLenRetAddr_";
  protected final String TEXT_25 = ") ? results_";
  protected final String TEXT_26 = "[";
  protected final String TEXT_27 = "] : \"\";" + NL + "                                        }";
  protected final String TEXT_28 = NL + "                                ";
  protected final String TEXT_29 = NL + "                                ";
  protected final String TEXT_30 = ".STATUS = results_";
  protected final String TEXT_31 = "[0];";
  protected final String TEXT_32 = NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_33 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String addressToVerify = ElementParameterParser.getValue(node, "__ANALYZED_COLUMN__");
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			String cid = node.getUniqueName();
			List< ? extends IConnection> conns = node.getIncomingConnections();
			if(conns!=null){
				if (conns.size()>0){
					IConnection conn =conns.get(0);

    
					List< ? extends IConnection> connsout = node.getOutgoingConnections(); 
	                if (connsout!=null) {
    	            	List<IMetadataColumn> columnsout = metadata.getListColumns();
            	        for (int i=0;i<connsout.size();i++) {
            	        	IConnection connout = connsout.get(i);
                    	    if(connout.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( addressToVerify );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
                                int k = 0;
                              
                                for (IMetadataColumn column : columnsout){
                                    String sColumnName = column.getLabel();
                                    boolean bReadOnly = column.isReadOnly();
                                    
                                    if (!bReadOnly){
                                    
    stringBuffer.append(TEXT_12);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_16);
    
                                      // ...addtional colums
                                    } else{
                                        
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(k);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(k++);
    stringBuffer.append(TEXT_27);
    
                                    }
                                }
                                
    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    							}
						}
					}

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    
				}
			}
		}
	}

    return stringBuffer.toString();
  }
}
