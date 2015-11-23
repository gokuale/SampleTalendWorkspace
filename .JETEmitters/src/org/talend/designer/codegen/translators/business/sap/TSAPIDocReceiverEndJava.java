package org.talend.designer.codegen.translators.business.sap;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class TSAPIDocReceiverEndJava
{
  protected static String nl;
  public static synchronized TSAPIDocReceiverEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPIDocReceiverEndJava result = new TSAPIDocReceiverEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tmessage_";
  protected final String TEXT_3 = ".acknowledge();" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\t//try {" + NL + "\t\t\tif(session_";
  protected final String TEXT_5 = " != null && connection_";
  protected final String TEXT_6 = " != null) {" + NL + "\t\t\t\tsession_";
  protected final String TEXT_7 = ".commit();" + NL + "\t\t\t}" + NL + "\t\t}catch(java.lang.Exception e_";
  protected final String TEXT_8 = "){" + NL + "\t\t\tif (session_";
  protected final String TEXT_9 = " != null  && connection_";
  protected final String TEXT_10 = " != null) {" + NL + "\t\t\t\tsession_";
  protected final String TEXT_11 = ".rollback();" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_12 = NL + "\t//{" + NL + "\t}" + NL + "\t" + NL + "\tif (session_";
  protected final String TEXT_13 = " != null  && connection_";
  protected final String TEXT_14 = " != null) {" + NL + " \t\tsession_";
  protected final String TEXT_15 = ".close();" + NL + " \t}" + NL + " \t" + NL + "    if (connection_";
  protected final String TEXT_16 = " != null) {" + NL + "    \tconnection_";
  protected final String TEXT_17 = ".close();" + NL + "    }" + NL + "} finally {" + NL + "\tif (connection_";
  protected final String TEXT_18 = " != null) {" + NL + " \t\tconnection_";
  protected final String TEXT_19 = ".close();" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	List<? extends IConnection> outputConnections = node.getOutgoingConnections(EConnectionType.FLOW_MAIN);
	
	if(outputConnections==null || outputConnections.isEmpty()){
		return "";
	}
	
	IConnection outputConnection = outputConnections.get(0);
	
	boolean linktHMap =  "true".equals(ElementParameterParser.getValue(node, "__LINK_THMAP__"));
	String hid = ElementParameterParser.getValue(node, "__MAPPING__");
	if(linktHMap && (hid == null || "".equals(hid))) {
		return "";
	}
	
	boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
	String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
	
	if ("CLIENT_ACKNOWLEDGE".equals(acknowledgmentMode)) {
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	}
	
	if(transacted) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
	}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
