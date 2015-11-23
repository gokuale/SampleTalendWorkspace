package org.talend.designer.codegen.translators.business.marketo;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TMarketoOutputMainJava
{
  protected static String nl;
  public static synchronized TMarketoOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoOutputMainJava result = new TMarketoOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "\t\t";
  protected final String TEXT_2 = " = null;\t\t\t" + NL + "\t";
  protected final String TEXT_3 = NL + "//////////////////////////////" + NL + "" + NL + "\t\tjava.util.Map<String, String> leadAllAttrList_";
  protected final String TEXT_4 = " = new java.util.HashMap<String,String>();";
  protected final String TEXT_5 = NL + "\t\t\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " != null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\t\tleadAllAttrList_";
  protected final String TEXT_10 = ".put(";
  protected final String TEXT_11 = ",FormatterUtils.format_Date(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = "));";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\tleadAllAttrList_";
  protected final String TEXT_16 = ".put(";
  protected final String TEXT_17 = ",String.valueOf(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = "));";
  protected final String TEXT_20 = NL + "\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = NL + "\t\t\t\t\tboolean hasFault_";
  protected final String TEXT_24 = " = false;" + NL + "\t\t\t\t\tString errorMsg_";
  protected final String TEXT_25 = " = null;" + NL + "\t\t\t\t\tInteger marketoId_";
  protected final String TEXT_26 = " = null;" + NL + "\t\t\t\t\tString marketoStatus_";
  protected final String TEXT_27 = "=null;" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tcom.marketo.www.mktows.ResultSyncLead syncLead_";
  protected final String TEXT_28 = " = client_";
  protected final String TEXT_29 = ".syncLead(false,null,client_";
  protected final String TEXT_30 = ".buildLead(leadAllAttrList_";
  protected final String TEXT_31 = "));" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_32 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_33 = ");" + NL + "\t\t\t\t\t\tcom.marketo.www.mktows.SyncStatus syncStatus_";
  protected final String TEXT_34 = " = syncLead_";
  protected final String TEXT_35 = ".getSyncStatus();" + NL + "\t\t\t\t\t\tstatusList_";
  protected final String TEXT_36 = ".add(new com.marketo.www.mktows.SyncStatus[]{syncStatus_";
  protected final String TEXT_37 = "});" + NL + "\t\t\t\t\t\tif (!com.marketo.www.mktows.LeadSyncStatus.FAILED.equals(syncStatus_";
  protected final String TEXT_38 = ".getStatus())) {" + NL + "\t\t\t\t\t\t\thasFault_";
  protected final String TEXT_39 = " = false;" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\thasFault_";
  protected final String TEXT_40 = " = true;" + NL + "\t\t\t\t\t\t\terrorMsg_";
  protected final String TEXT_41 = " = syncStatus_";
  protected final String TEXT_42 = ".getError();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tmarketoId_";
  protected final String TEXT_43 = " = syncStatus_";
  protected final String TEXT_44 = ".getLeadId();" + NL + "\t\t\t\t\t\tmarketoStatus_";
  protected final String TEXT_45 = " = syncStatus_";
  protected final String TEXT_46 = ".getStatus().getValue();" + NL + "\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_47 = "){" + NL + "\t\t\t\t\t\tif(ex_";
  protected final String TEXT_48 = " instanceof org.apache.axis.AxisFault){" + NL + "\t\t\t    \t\t\tif(!client_";
  protected final String TEXT_49 = ".isSystemError((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_50 = ")){" + NL + "\t\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_51 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_52 = ");\t\t" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t    \t\t}" + NL + "\t\t\t\t\t\thasFault_";
  protected final String TEXT_53 = " = true;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_54 = NL + "\t\t                    throw(ex_";
  protected final String TEXT_55 = ");" + NL + "\t\t                    ";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\t\t\terrorMsg_";
  protected final String TEXT_57 = " = ex_";
  protected final String TEXT_58 = ".getMessage();" + NL + "\t\t\t\t\t\t\t\tmarketoId_";
  protected final String TEXT_59 = " = ";
  protected final String TEXT_60 = ".Id;" + NL + "\t\t\t\t\t\t\t\tmarketoStatus_";
  protected final String TEXT_61 = " = \"FAILED\";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\t\t\t\t\tSystem.err.println(ex_";
  protected final String TEXT_63 = ".getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t\t}";
  protected final String TEXT_65 = NL + "\t\t\t\t\tleadRecordList_";
  protected final String TEXT_66 = ".add(client_";
  protected final String TEXT_67 = ".buildLead(leadAllAttrList_";
  protected final String TEXT_68 = "));" + NL + "\t\t\t\t\tif(leadRecordList_";
  protected final String TEXT_69 = ".size()>=";
  protected final String TEXT_70 = "){" + NL + "\t\t\t\t\t\tcom.marketo.www.mktows.LeadRecord[] leadRecords_";
  protected final String TEXT_71 = " = leadRecordList_";
  protected final String TEXT_72 = ".toArray(new com.marketo.www.mktows.LeadRecord[leadRecordList_";
  protected final String TEXT_73 = ".size()]);" + NL + "\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\tcom.marketo.www.mktows.ResultSyncMultipleLeads syncLeads_";
  protected final String TEXT_74 = " = client_";
  protected final String TEXT_75 = ".syncMultipleLeads(";
  protected final String TEXT_76 = ",leadRecords_";
  protected final String TEXT_77 = ");" + NL + "\t\t\t\t\t\t\tstatusList_";
  protected final String TEXT_78 = ".add(syncLeads_";
  protected final String TEXT_79 = ".getSyncStatusList());" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_80 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_81 = ");" + NL + "\t\t\t\t\t\t }catch(java.lang.Exception ex_";
  protected final String TEXT_82 = "){" + NL + "\t\t\t\t\t\t \tif(ex_";
  protected final String TEXT_83 = " instanceof org.apache.axis.AxisFault){" + NL + "\t\t\t\t    \t\t\tif(!client_";
  protected final String TEXT_84 = ".isSystemError((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_85 = ")){" + NL + "\t\t\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_86 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_87 = ");\t\t" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t    \t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\t            throw(ex_";
  protected final String TEXT_89 = ");" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_90 = NL + "\t\t\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_91 = ".getMessage());" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_92 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tleadRecordList_";
  protected final String TEXT_93 = ".clear();" + NL + "\t\t\t\t\t}";
  protected final String TEXT_94 = NL + "\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\t\t\t\t\tif (!hasFault_";
  protected final String TEXT_96 = ") {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_97 = " = new ";
  protected final String TEXT_98 = "Struct();" + NL + "\t\t\t\t\t\t\t\t\t//";
  protected final String TEXT_99 = ".SYNC_STATUS = syncStatus_";
  protected final String TEXT_100 = ".getStatus().toString();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_102 = ".Id = marketoId_";
  protected final String TEXT_103 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_104 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_105 = ".Status = marketoStatus_";
  protected final String TEXT_106 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_107 = "\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_108 = ".";
  protected final String TEXT_109 = " = ";
  protected final String TEXT_110 = ".";
  protected final String TEXT_111 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_112 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\t\t\tif(hasFault_";
  protected final String TEXT_114 = "){\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_115 = " = new ";
  protected final String TEXT_116 = "Struct();" + NL + "\t\t\t\t\t\t\t" + NL + "\t            \t\t\t";
  protected final String TEXT_117 = ".ERROR_MSG = errorMsg_";
  protected final String TEXT_118 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_119 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_120 = ".Id = marketoId_";
  protected final String TEXT_121 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_123 = ".Status = marketoStatus_";
  protected final String TEXT_124 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_125 = "\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = " = ";
  protected final String TEXT_128 = ".";
  protected final String TEXT_129 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_130 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_131 = NL + "\t\t\t\t";
  protected final String TEXT_132 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_133 = " = new ";
  protected final String TEXT_134 = "Struct();";
  protected final String TEXT_135 = "\t\t\t" + NL + "\t\t\t   \t\t\t";
  protected final String TEXT_136 = ".";
  protected final String TEXT_137 = " = ";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = ";\t\t\t";
  protected final String TEXT_140 = "\t\t \t";
  protected final String TEXT_141 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName().replace("_Out","");
	
	String operation = ElementParameterParser.getValue(node, "__OPERATION__");
	boolean deDupenabled = ("true").equals(ElementParameterParser.getValue(node,"__DE_DUPENABLED__"));
	String batchSize = ElementParameterParser.getValue(node, "__BATCH_SIZE__");
	boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
	String rejectConnName = null;
	List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
	if(rejectConns != null && rejectConns.size() > 0) {
	    IConnection rejectConn = rejectConns.get(0);
	    rejectConnName = rejectConn.getName();
	}
	List<IMetadataColumn> rejectColumnList = null;
	IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
	if(metadataTable != null) {
	    rejectColumnList = metadataTable.getListColumns();
	}
	
	List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
	if(outgoingConns!=null){
		for (int i=0;i<outgoingConns.size();i++) {
	    IConnection outgoingConn = outgoingConns.get(i);
	    	if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	
    stringBuffer.append(TEXT_1);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_2);
    
	    	}
	    }
	}   	
	
List< ? extends IConnection> conns = node.getIncomingConnections();
for (IConnection conn : conns) {//1
	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//2
		List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null)&&(metadatas.size()>0)) {//3
		    IMetadataTable metadata = conn.getMetadataTable();
		    if (metadata!=null) {//4

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    			
				List<Map<String, String>> mappingList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING_INPUT__");
    			Map<String,String> fldMapping = new HashMap<String,String>();
    			for(Map<String,String> inputMapping:mappingList){
    				String mapStr = inputMapping.get("PARAMETER_NAME");
    				if("\"\"".equals(mapStr)){
    					fldMapping.put(inputMapping.get("SCHEMA_COLUMN"),"\""+inputMapping.get("SCHEMA_COLUMN")+"\"");
    				}else{	
    					fldMapping.put(inputMapping.get("SCHEMA_COLUMN"),inputMapping.get("PARAMETER_NAME"));
    				}
    			}
				List<IMetadataColumn> columns = metadata.getListColumns();
				int sizeColumns = columns.size();
				for (int i = 0; i < sizeColumns; i++) {
					IMetadataColumn column = columns.get(i);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					

    stringBuffer.append(TEXT_5);
    if(!isPrimitive) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_8);
    }
    
					if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_14);
    
					} else {//others	

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_19);
    
					}

    stringBuffer.append(TEXT_20);
    if(!isPrimitive) {
    stringBuffer.append(TEXT_21);
    }
    					
				}

    stringBuffer.append(TEXT_22);
    
				if("syncLead".equals(operation)){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
						if (dieOnError) {
		                    
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
		                } else {
							if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    }else{
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    }
						}
    stringBuffer.append(TEXT_64);
    				
				}else if("syncMultipleLeads".equals(operation)){

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(deDupenabled);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
					        if (dieOnError) {
					        
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
					        } else {
					        
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
					        }
					        
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    				
				}

    
			if("syncLead".equals(operation)){
				

    stringBuffer.append(TEXT_94);
    			
					 for(IConnection outgoingConn : outgoingConns) {
	                	if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
	                    	if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
									IMetadataTable outputMetadata = metadatas.get(0);
									if(outputMetadata!=null){
										for (IMetadataColumn column: outputMetadata.getListColumns()) {
											if("Id".equals(column.getLabel())){
											
    stringBuffer.append(TEXT_101);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
											}else if("Status".equals(column.getLabel())){
											
    stringBuffer.append(TEXT_104);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
											}else{
											
    stringBuffer.append(TEXT_107);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_111);
    
											}				 
										}
									}
									
    stringBuffer.append(TEXT_112);
    
							}
						}
					}

    
					if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
							IMetadataTable outputMetadata = metadatas.get(0);
							if(outputMetadata!=null){
								for (IMetadataColumn column: outputMetadata.getListColumns()) {
									if("Id".equals(column.getLabel())){
									
    stringBuffer.append(TEXT_119);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
									}else if("Status".equals(column.getLabel())){
									
    stringBuffer.append(TEXT_122);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
									}else{
									
    stringBuffer.append(TEXT_125);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_129);
    
									}				 
								}
							}
							
    stringBuffer.append(TEXT_130);
    
					}

    stringBuffer.append(TEXT_131);
    			}else{//syncLead end 

    
			 for(IConnection outgoingConn : outgoingConns) {
            	if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                	if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_132);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_134);
    
					for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_135);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_139);
    					 
					}
					}
				}
			}

    stringBuffer.append(TEXT_140);
    			
				}//syncMultipleLeads end

    				
				}//4
			}//3
		}//2
	}//1

    stringBuffer.append(TEXT_141);
    return stringBuffer.toString();
  }
}
