package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import java.util.List;

public class TFireRulesVirtualMainJava
{
  protected static String nl;
  public static synchronized TFireRulesVirtualMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFireRulesVirtualMainJava result = new TFireRulesVirtualMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "java.io.InputStream in_";
  protected final String TEXT_3 = " = new ByteArrayInputStream(queue_";
  protected final String TEXT_4 = ".poll().getBytes());";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = " myObj_";
  protected final String TEXT_7 = " = (";
  protected final String TEXT_8 = ")uctx_";
  protected final String TEXT_9 = ".unmarshalDocument(in_";
  protected final String TEXT_10 = ", null);" + NL + "" + NL + "org.kie.api.runtime.rule.FactHandle factHandle = ksession_";
  protected final String TEXT_11 = ".insert(myObj_";
  protected final String TEXT_12 = ");" + NL;
  protected final String TEXT_13 = NL + "\tksession_";
  protected final String TEXT_14 = ".startProcess(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "ksession_";
  protected final String TEXT_17 = ".fireAllRules();" + NL + "ksession_";
  protected final String TEXT_18 = ".delete(factHandle);" + NL + "" + NL + "java.io.OutputStream out_";
  protected final String TEXT_19 = " = new ByteArrayOutputStream();" + NL + "mctx_";
  protected final String TEXT_20 = ".setOutput(out_";
  protected final String TEXT_21 = ", null);" + NL + "mctx_";
  protected final String TEXT_22 = ".marshalDocument(myObj_";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = " = out_";
  protected final String TEXT_27 = ".toString();" + NL + "//";
  protected final String TEXT_28 = ".xml = out_";
  protected final String TEXT_29 = ".toString();" + NL + "nb_line_";
  protected final String TEXT_30 = "++; ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
String bindingDirectory = ElementParameterParser.getValue(node, "__BINDING_DIRECTORY__");
String className = ElementParameterParser.getValue(node, "__CLASS_NAME__");
String guvnorRuleFlowID = ElementParameterParser.getValue(node, "__RULE_FLOW_ID__");
String xmlField = ElementParameterParser.getValue(node, "__XMLFIELD__");

if(className.startsWith("\"") && className.endsWith("\"")){
    className = className.substring(1,className.length()-1);
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        List< ? extends IConnection> inConns = node.getIncomingConnections();
        List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
        String inputRowName = "";
        String outputRowName = "";
        if (inConns != null && !inConns.isEmpty() && outConns != null && !outConns.isEmpty()) {
            IConnection inConn = inConns.get(0);
            inputRowName = inConn.getName();
            IConnection outConn = outConns.get(0);
            outputRowName = outConn.getName();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
if( ! "\"\"".equals(guvnorRuleFlowID) ) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(guvnorRuleFlowID);
    stringBuffer.append(TEXT_15);
    
	}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(outputRowName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(xmlField);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(outputRowName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    
		}
	}
}

    return stringBuffer.toString();
  }
}
