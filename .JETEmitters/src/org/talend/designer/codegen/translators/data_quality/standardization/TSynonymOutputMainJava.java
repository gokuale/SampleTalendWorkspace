package org.talend.designer.codegen.translators.data_quality.standardization;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TSynonymOutputMainJava
{
  protected static String nl;
  public static synchronized TSynonymOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSynonymOutputMainJava result = new TSynonymOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tstatus_";
  protected final String TEXT_2 = " = null;" + NL + "\t";
  protected final String TEXT_3 = NL + "\t\tif (";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = " == null || \"\".equals(";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ".trim())) {" + NL + "\t\t\terror_";
  protected final String TEXT_8 = ".set(false, \"entry is null\");" + NL + "\t\t} else {" + NL + "\t\t\tbuilder_";
  protected final String TEXT_9 = ".insertDocument(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = ", ";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_14 = NL + "\t\tif (";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = " == null || \"\".equals(";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ".trim())) {" + NL + "\t\t\terror_";
  protected final String TEXT_19 = ".set(false, \"entry is null\");" + NL + "\t\t} else {" + NL + "\t\t\tbuilder_";
  protected final String TEXT_20 = ".insertDocumentIfNotExists(";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = ");" + NL + "\t\t} " + NL + "\t";
  protected final String TEXT_25 = NL + "\t\tif (";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = " == null || \"\".equals(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ".trim())) {" + NL + "\t\t\terror_";
  protected final String TEXT_30 = ".set(false, \"entry is null\");" + NL + "\t\t} else {" + NL + "\t\t\tstatus_";
  protected final String TEXT_31 = " = \"updated\";" + NL + "\t\t\tif (0 == builder_";
  protected final String TEXT_32 = ".updateDocument(";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = ", ";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = ")) {" + NL + "\t\t\t\tbuilder_";
  protected final String TEXT_37 = ".insertDocumentIfNotExists(";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = ", ";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = ");" + NL + "\t\t\t\terror_";
  protected final String TEXT_42 = ".reset();" + NL + "\t\t\t\tstatus_";
  protected final String TEXT_43 = " = \"to update but not existing and inserted\";" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_44 = NL + "\t\tif (";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = " == null || \"\".equals(";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = ".trim())) {" + NL + "\t\t\terror_";
  protected final String TEXT_49 = ".set(false, \"entry is null\");" + NL + "\t\t} else {" + NL + "\t\t\tbuilder_";
  protected final String TEXT_50 = ".deleteDocumentByWord(";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = ");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_53 = NL + "\t\tif (error_";
  protected final String TEXT_54 = ".getStatus()) {" + NL + "\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t\tif (";
  protected final String TEXT_56 = " == null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_57 = " = new ";
  protected final String TEXT_58 = "Struct();" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = " = status_";
  protected final String TEXT_62 = " == null ? \"";
  protected final String TEXT_63 = "\" : status_";
  protected final String TEXT_64 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_66 = ".";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t";
  protected final String TEXT_71 = " = null;" + NL + "\t\t\t";
  protected final String TEXT_72 = NL + "\t\t} else {" + NL + "\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\tif (";
  protected final String TEXT_74 = " == null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_75 = " = new ";
  protected final String TEXT_76 = "Struct();" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = " = error_";
  protected final String TEXT_80 = ".getMessage();" + NL + "\t\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = " = ";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\t";
  protected final String TEXT_87 = " = null;" + NL + "\t\t\t";
  protected final String TEXT_88 = NL + "\t\t}" + NL + "\t\terror_";
  protected final String TEXT_89 = ".reset();" + NL + "\t";
  protected final String TEXT_90 = NL + "\t\t\t";
  protected final String TEXT_91 = " = null;" + NL + "\t\t";
  protected final String TEXT_92 = NL + "\t\t\t";
  protected final String TEXT_93 = " = null;" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();	
List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
IConnection inConn = null;

// get incomming connection
if (inConns == null || inConns.isEmpty()) {
	return "";
} else {
	inConn = inConns.get(0);
}
String sInConnName = null;

// get incoming connection name
if (inConn == null || !inConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	return "";
} else {
	sInConnName = inConn.getName();
}

// get outgoing connections
List<? extends IConnection> outConns = node.getOutgoingConnections();
String sOutMainConnName = null, sOutRejectConnName = null;
IConnection outMainConn = null, outRejectConn = null;

List<IMetadataColumn> reject_out_columns = null, main_out_coulmns = null;


for (IConnection outConn : outConns) {
  if (outConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
	if (outConn.isActivate()){
		String connOutCntorName = outConn.getConnectorName();
		String connOutFlowName = outConn.getName();

		if ("REJECT".equalsIgnoreCase(connOutCntorName)){
			sOutRejectConnName = connOutFlowName;
			reject_out_columns = outConn.getMetadataTable().getListColumns();
		} else {
			sOutMainConnName = connOutFlowName;
			main_out_coulmns = outConn.getMetadataTable().getListColumns();
		}
	}
  }
}
List<IMetadataTable> metadatas = node.getMetadataList();

if ((metadatas != null) && (metadatas.size() > 0)) {
	String entry = ElementParameterParser.getValue(node, "__ENTRY__");
	String synonyms = ElementParameterParser.getValue(node, "__SYNONYMS__");
	String operation = ElementParameterParser.getValue(node, "__OPERATION__");
	String status_info = "";
	
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
	
	// create a new index, deleting the old one if necessary
	if ("INIT".equals(operation)) {
		status_info = "inserted";
		
    stringBuffer.append(TEXT_3);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(entry);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(entry);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(entry);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(synonyms);
    stringBuffer.append(TEXT_13);
    
	// add incoming rows as new documents out the index
	} else if ("INSERT_NEW_DOC".equals(operation)) {
		status_info = "inserted";
		
    stringBuffer.append(TEXT_14);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(entry);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(entry);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(entry);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(synonyms);
    stringBuffer.append(TEXT_24);
    
	// update documents when they exist in the index or insert them if they are new
	} else if ("UPDATE_EXISTING_DOC".equals(operation)) {
	
    stringBuffer.append(TEXT_25);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(entry);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(entry);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(entry);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(synonyms);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(entry);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(synonyms);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
	// delete documents from the index if they exist
	} else if ("DELETE_EXISTING_DOC".equals(operation)) {
		status_info = "deleted";
		
    stringBuffer.append(TEXT_44);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(entry);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(entry);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(entry);
    stringBuffer.append(TEXT_52);
    
	}
	
	// not output when deleting index option chosen, or no input flow, or no output flow. 
	if (!"DELETE_INDEX".equals(operation) && (sOutRejectConnName != null || sOutMainConnName != null)) {
	
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    if (sOutMainConnName != null) {
    stringBuffer.append(TEXT_55);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_58);
    
				for (IMetadataColumn column : main_out_coulmns) {
					String label = column.getLabel();
					
					if ("status".equals(label)) {
					
    stringBuffer.append(TEXT_59);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(status_info);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    } else {
    stringBuffer.append(TEXT_65);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_69);
    
					}
				}
			}
			
			if (sOutRejectConnName != null) {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(sOutRejectConnName);
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    if (sOutRejectConnName != null) {
    stringBuffer.append(TEXT_73);
    stringBuffer.append(sOutRejectConnName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(sOutRejectConnName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(sOutRejectConnName);
    stringBuffer.append(TEXT_76);
    
				for (IMetadataColumn column : reject_out_columns) {
					String label = column.getLabel();
					
					if ("error_message".equals(label)) {
					
    stringBuffer.append(TEXT_77);
    stringBuffer.append(sOutRejectConnName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    } else {
    stringBuffer.append(TEXT_81);
    stringBuffer.append(sOutRejectConnName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(sInConnName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_85);
    
					}
				}
			}
			
			if (sOutMainConnName != null) {
			
    stringBuffer.append(TEXT_86);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
	} else {
		if (sOutMainConnName != null) {
		
    stringBuffer.append(TEXT_90);
    stringBuffer.append(sOutMainConnName);
    stringBuffer.append(TEXT_91);
    
		}
		if (sOutRejectConnName != null) {
		
    stringBuffer.append(TEXT_92);
    stringBuffer.append(sOutRejectConnName);
    stringBuffer.append(TEXT_93);
    
		}
	}
}

    return stringBuffer.toString();
  }
}
