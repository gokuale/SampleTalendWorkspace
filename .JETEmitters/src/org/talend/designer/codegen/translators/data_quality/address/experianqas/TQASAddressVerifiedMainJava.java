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

public class TQASAddressVerifiedMainJava
{
  protected static String nl;
  public static synchronized TQASAddressVerifiedMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TQASAddressVerifiedMainJava result = new TQASAddressVerifiedMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = " = null;\t\t\t\t";
  protected final String TEXT_4 = NL + "\t";
  protected final String TEXT_5 = " = null;\t\t";
  protected final String TEXT_6 = NL + "\t";
  protected final String TEXT_7 = " = null;";
  protected final String TEXT_8 = NL + "\tString[] results_";
  protected final String TEXT_9 = " = null;" + NL + "    results_";
  protected final String TEXT_10 = " = qasClient_";
  protected final String TEXT_11 = ".getRightAddress(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ");" + NL + "if(results_";
  protected final String TEXT_14 = "[0].equals(\"Verified\")){";
  protected final String TEXT_15 = NL + "\tif(";
  protected final String TEXT_16 = " == null){" + NL + "\t\t";
  protected final String TEXT_17 = " = new ";
  protected final String TEXT_18 = "Struct();" + NL + "\t}";
  protected final String TEXT_19 = NL + "                                int iLenRetAddr_";
  protected final String TEXT_20 = " = results_";
  protected final String TEXT_21 = ".length;" + NL + "                                ";
  protected final String TEXT_22 = NL + "                                        ";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = "                                 ";
  protected final String TEXT_28 = NL + "                                            ";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = " = (";
  protected final String TEXT_31 = " < iLenRetAddr_";
  protected final String TEXT_32 = ") ? results_";
  protected final String TEXT_33 = "[";
  protected final String TEXT_34 = "] : \"\";";
  protected final String TEXT_35 = NL + "} else if(results_";
  protected final String TEXT_36 = "[0].equals(\"InteractionRequired\")){";
  protected final String TEXT_37 = NL + "\tif(";
  protected final String TEXT_38 = " == null){" + NL + "\t\t";
  protected final String TEXT_39 = " = new ";
  protected final String TEXT_40 = "Struct();" + NL + "\t}";
  protected final String TEXT_41 = NL + "                                int iLenRetAddr_";
  protected final String TEXT_42 = " = results_";
  protected final String TEXT_43 = ".length;" + NL + "                                ";
  protected final String TEXT_44 = NL + "                                        ";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = ";";
  protected final String TEXT_49 = "                                 ";
  protected final String TEXT_50 = NL + "                                            ";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = " = (";
  protected final String TEXT_53 = " < iLenRetAddr_";
  protected final String TEXT_54 = ") ? results_";
  protected final String TEXT_55 = "[";
  protected final String TEXT_56 = "] : \"\";";
  protected final String TEXT_57 = NL + "} else {";
  protected final String TEXT_58 = NL + "\tif(";
  protected final String TEXT_59 = " == null){" + NL + "\t\t";
  protected final String TEXT_60 = " = new ";
  protected final String TEXT_61 = "Struct();" + NL + "\t}";
  protected final String TEXT_62 = NL + "                                int iLenRetAddr_";
  protected final String TEXT_63 = " = results_";
  protected final String TEXT_64 = ".length;" + NL + "                                ";
  protected final String TEXT_65 = NL + "                                        ";
  protected final String TEXT_66 = ".";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = ";";
  protected final String TEXT_70 = "                                 ";
  protected final String TEXT_71 = NL + "                                            ";
  protected final String TEXT_72 = ".";
  protected final String TEXT_73 = " = (";
  protected final String TEXT_74 = " < iLenRetAddr_";
  protected final String TEXT_75 = ") ? results_";
  protected final String TEXT_76 = "[";
  protected final String TEXT_77 = "] : \"\";";
  protected final String TEXT_78 = NL + "}" + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_79 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String wsdlAddress = ElementParameterParser.getValue(node, "__WSDL_ADDRESS__");
	String country = ElementParameterParser.getValue(node, "__COUNTRY__");
	String addressToVerify = ElementParameterParser.getValue(node, "__ANALYZED_COLUMN__");
	List<IMetadataTable> metadatas = node.getMetadataList();
	
	boolean verifiedExist = false;
	boolean interactionExist = false;
	boolean rejectExist = false;
	
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			String cid = node.getUniqueName();
			List< ? extends IConnection> conns = node.getIncomingConnections();
			if(conns!=null){
				if (conns.size()>0){
					IConnection conn =conns.get(0);

String verifiedConnName = null;
List<? extends IConnection> connsVerified = node.getOutgoingConnections("VERIFIED");
if(connsVerified != null && connsVerified.size() > 0) {
    for(IConnection vConn : connsVerified) {
        verifiedConnName = vConn.getName();
        verifiedExist = true;

    stringBuffer.append(TEXT_2);
    stringBuffer.append( verifiedConnName );
    stringBuffer.append(TEXT_3);
           
    }
}
String interactionConnName = null;
List<? extends IConnection> connsInteraction = node.getOutgoingConnections("INTERACTION_REQUIRED");
if(connsInteraction != null && connsInteraction.size() > 0) {
    for(IConnection iConn : connsInteraction) {
        interactionConnName = iConn.getName();
        interactionExist = true;

    stringBuffer.append(TEXT_4);
    stringBuffer.append( interactionConnName );
    stringBuffer.append(TEXT_5);
           
    }
}
String rejectConnName = null;
List<? extends IConnection> connsReject = node.getOutgoingConnections("REJECT");
if(connsReject != null && connsReject.size() > 0) {
    for(IConnection rConn : connsReject) {
        rejectConnName = rConn.getName();
        rejectExist = true;

    stringBuffer.append(TEXT_6);
    stringBuffer.append( rejectConnName );
    stringBuffer.append(TEXT_7);
           
    }
}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( addressToVerify );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
	if( verifiedExist ){

    stringBuffer.append(TEXT_15);
    stringBuffer.append( verifiedConnName );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( verifiedConnName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( verifiedConnName );
    stringBuffer.append(TEXT_18);
     }
	                if (connsVerified!=null) {
    	            	List<IMetadataColumn> columnsout = metadata.getListColumns();
            	        for (int i=0;i < connsVerified.size();i++) {
            	        	IConnection connout = connsVerified.get(i);
                    	    if(connout.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                    	        
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
                                int k = 1;
                                
                                for (IMetadataColumn column : columnsout){
                                    String sColumnName = column.getLabel();
                                    boolean bReadOnly = column.isReadOnly();
                                    
                                    if (!bReadOnly){
                                    
    stringBuffer.append(TEXT_22);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_26);
    
                                      // ...addtional colums
                                    } else{
                                        
    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(k);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(k++);
    stringBuffer.append(TEXT_34);
    
                                    }
                                }
    
							}
						}
					}

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    
	if( interactionExist ){

    stringBuffer.append(TEXT_37);
    stringBuffer.append( interactionConnName  );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( interactionConnName  );
    stringBuffer.append(TEXT_39);
    stringBuffer.append( interactionConnName  );
    stringBuffer.append(TEXT_40);
    
	}
	                if (connsInteraction!=null) {
    	            	List<IMetadataColumn> columnsout = metadata.getListColumns();
            	        for (int i=0;i<connsInteraction.size();i++) {
            	        	IConnection connout = connsInteraction.get(i);
                    	    if(connout.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                                
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
                                int k = 1;
                                
                                for (IMetadataColumn column : columnsout){
                                    String sColumnName = column.getLabel();
                                    boolean bReadOnly = column.isReadOnly();
                                    
                                    if (!bReadOnly){
                                    
    stringBuffer.append(TEXT_44);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_48);
    
                                      // ...addtional colums
                                    } else{
                                        
    stringBuffer.append(TEXT_49);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(k);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(k++);
    stringBuffer.append(TEXT_56);
    
                                    }
                                }
	
							}
						}
					}

    stringBuffer.append(TEXT_57);
    
	if( rejectExist ){

    stringBuffer.append(TEXT_58);
    stringBuffer.append( rejectConnName );
    stringBuffer.append(TEXT_59);
    stringBuffer.append( rejectConnName );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( rejectConnName );
    stringBuffer.append(TEXT_61);
    		
	}
			if (connsReject!=null) {
    	            	List<IMetadataColumn> columnsout = metadata.getListColumns();
            	        for (int i=0;i<connsReject.size();i++) {
            	        	IConnection connout = connsReject.get(i);
                    	    if(connout.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                    	        
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
                                int k = 1;
                                
                                for (IMetadataColumn column : columnsout){
                                    String sColumnName = column.getLabel();
                                    boolean bReadOnly = column.isReadOnly();
                                    
                                    if (!bReadOnly){
                                    
    stringBuffer.append(TEXT_65);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_69);
    
                                      // ...addtional colums
                                    } else{
                                        
    stringBuffer.append(TEXT_70);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(k);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(k++);
    stringBuffer.append(TEXT_77);
    
                                    }
                                }
    
							}
						}
					}

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    				}
			}
		}
	}

    return stringBuffer.toString();
  }
}
