package org.talend.designer.codegen.translators.business.marketo;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;

public class TMarketoOutputWriteEndJava
{
  protected static String nl;
  public static synchronized TMarketoOutputWriteEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoOutputWriteEndJava result = new TMarketoOutputWriteEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " ";
  protected final String TEXT_2 = NL + "\t\t\t\tif(leadRecordList_";
  protected final String TEXT_3 = ".size()>0){" + NL + "\t\t\t\t\tcom.marketo.www.mktows.LeadRecord[] leadRecords_";
  protected final String TEXT_4 = " = leadRecordList_";
  protected final String TEXT_5 = ".toArray(new com.marketo.www.mktows.LeadRecord[leadRecordList_";
  protected final String TEXT_6 = ".size()]);" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tcom.marketo.www.mktows.ResultSyncMultipleLeads syncLeads_";
  protected final String TEXT_7 = " = client_";
  protected final String TEXT_8 = ".syncMultipleLeads(";
  protected final String TEXT_9 = ",leadRecords_";
  protected final String TEXT_10 = ");" + NL + "\t\t\t\t\t\tstatusList_";
  protected final String TEXT_11 = ".add(syncLeads_";
  protected final String TEXT_12 = ".getSyncStatusList());" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_13 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_14 = "); \t" + NL + "\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_15 = "){" + NL + "\t\t\t\t\t\tif(ex_";
  protected final String TEXT_16 = " instanceof org.apache.axis.AxisFault){" + NL + "\t\t\t    \t\t\tif(!client_";
  protected final String TEXT_17 = ".isSystemError((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_18 = ")){" + NL + "\t\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_19 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_20 = ");\t\t" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t    \t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t            throw(ex_";
  protected final String TEXT_22 = ");" + NL + "\t\t\t\t        ";
  protected final String TEXT_23 = NL + "\t\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_24 = ".getMessage());" + NL + "\t\t\t\t        ";
  protected final String TEXT_25 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tleadRecordList_";
  protected final String TEXT_26 = ".clear();" + NL + "\t\t\t\t}";
  protected final String TEXT_27 = NL + "globalMap.put(\"";
  protected final String TEXT_28 = "_NB_CALL\",nb_call_";
  protected final String TEXT_29 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_30 = "_STATUS_LIST\",statusList_";
  protected final String TEXT_31 = ");" + NL;
  protected final String TEXT_32 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName().replace("_Out","");
	String operation = ElementParameterParser.getValue(node, "__OPERATION__");
	boolean deDupenabled = ("true").equals(ElementParameterParser.getValue(node,"__DE_DUPENABLED__"));
	boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));

    stringBuffer.append(TEXT_1);
    
			if("syncMultipleLeads".equals(operation)){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
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
    stringBuffer.append(deDupenabled);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
				        if (dieOnError) {
				        
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
				        } else {
				        
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
				        }
				        
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    				
			}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(TEXT_32);
    return stringBuffer.toString();
  }
}
