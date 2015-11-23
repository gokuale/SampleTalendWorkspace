package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TDepartitionerMainJava
{
  protected static String nl;
  public static synchronized TDepartitionerMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDepartitionerMainJava result = new TDepartitionerMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "Struct tmp_";
  protected final String TEXT_3 = " = new ";
  protected final String TEXT_4 = "Struct();";
  protected final String TEXT_5 = NL + "   tmp_";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = NL + "\tlog.debug(\"";
  protected final String TEXT_11 = "[\" + Thread.currentThread().getName() + \"] - Departition the record : \"";
  protected final String TEXT_12 = " + ";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = " + \"|\" + ";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "Integer currentCounter_";
  protected final String TEXT_18 = " = (Integer)globalMap.get(\"counter_";
  protected final String TEXT_19 = "\");" + NL + "org.talend.concurrent.LinkedBlockingQueue<";
  protected final String TEXT_20 = "Struct> currentOutputQueue_";
  protected final String TEXT_21 = " = (org.talend.concurrent.LinkedBlockingQueue<";
  protected final String TEXT_22 = "Struct>)globalMap.get(\"outputQueue_";
  protected final String TEXT_23 = "\");" + NL + "" + NL + "if ((currentCounter_";
  protected final String TEXT_24 = " % 100) == 0) {" + NL + "\tif (globalMap.get(\"HAS_ERROR\") != null) {" + NL + "\t\tthrow new RuntimeException(\"Error in recollector for ";
  protected final String TEXT_25 = "\",(Throwable)globalMap.get(\"HAS_ERROR\"));" + NL + "\t\t\t" + NL + "\t}" + NL + "}" + NL + "int offerCounter_";
  protected final String TEXT_26 = " = 0;" + NL + "while (!currentOutputQueue_";
  protected final String TEXT_27 = ".offer(tmp_";
  protected final String TEXT_28 = ")) {" + NL + "\tofferCounter_";
  protected final String TEXT_29 = "++;" + NL + "\tif ((offerCounter_";
  protected final String TEXT_30 = " % 500) == 0) {" + NL + "\t    if (globalMap.get(\"HAS_ERROR\") != null) {" + NL + "\t\t\tthrow new RuntimeException(\"Error in recollector for ";
  protected final String TEXT_31 = "\",(Throwable)globalMap.get(\"HAS_ERROR\"));" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL + "globalMap.put(\"counter_";
  protected final String TEXT_32 = "\",++currentCounter_";
  protected final String TEXT_33 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    INode startNode = org.talend.core.model.utils.NodeUtil.getSubProcessStartNode(node);
    
    String startCid = startNode.getUniqueName();//assume it's a tCollector... I hope it is...
    String connName = null;
    if (node.getIncomingConnections().size() == 1) {    
        IConnection conn = node.getIncomingConnections().get(0);
        connName = conn.getName();
    }
    List<IMetadataTable> metadatas = node.getMetadataList();
	IMetadataTable metadata = metadatas.get(0);
	List<IMetadataColumn> columnsout = metadata.getListColumns();
	String queueSize = ElementParameterParser.getValue(node,"__QUEUE_SIZE__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_4);
    
   	for (IMetadataColumn imc : columnsout) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(imc.getLabel());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(imc.getLabel());
    stringBuffer.append(TEXT_9);
    
	}

    
	if(isLog4jEnabled){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		for (int i=0; i < columnsout.size(); i++) {
			if (i==0) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(columnsout.get(i).getLabel());
    
			} else {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(columnsout.get(i).getLabel());
    
			}
		}

    stringBuffer.append(TEXT_16);
    
	}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    return stringBuffer.toString();
  }
}
