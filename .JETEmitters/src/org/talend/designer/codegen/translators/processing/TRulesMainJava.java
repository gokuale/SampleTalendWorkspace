package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TRulesMainJava
{
  protected static String nl;
  public static synchronized TRulesMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRulesMainJava result = new TRulesMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = " = null;";
  protected final String TEXT_4 = NL + "org.kie.internal.runtime.StatefulKnowledgeSession ksession_";
  protected final String TEXT_5 = " = kbase_";
  protected final String TEXT_6 = ".newStatefulKnowledgeSession();" + NL + "java.util.List<Object> List_";
  protected final String TEXT_7 = " = new java.util.ArrayList<Object>();" + NL + "ksession_";
  protected final String TEXT_8 = ".setGlobal(\"list\", List_";
  protected final String TEXT_9 = ");" + NL + "ksession_";
  protected final String TEXT_10 = ".setGlobal(\"globalMap\", globalMap);" + NL + "ksession_";
  protected final String TEXT_11 = ".insert(";
  protected final String TEXT_12 = ");" + NL + "ksession_";
  protected final String TEXT_13 = ".fireAllRules();" + NL + "" + NL + "if (List_";
  protected final String TEXT_14 = ".size() >0) {" + NL + "\tObject fromList_";
  protected final String TEXT_15 = " =null;" + NL + "\tfor(int i=0;i<List_";
  protected final String TEXT_16 = ".size();i++){" + NL + " \t\tfromList_";
  protected final String TEXT_17 = " = List_";
  protected final String TEXT_18 = ".get(i);" + NL + " \t\t";
  protected final String TEXT_19 = NL + "\t\tif (fromList_";
  protected final String TEXT_20 = " instanceof ";
  protected final String TEXT_21 = "Struct) {" + NL + "\t\t\t";
  protected final String TEXT_22 = " = (";
  protected final String TEXT_23 = "Struct) fromList_";
  protected final String TEXT_24 = ";" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_25 = NL + "\t}" + NL + "}" + NL + "ksession_";
  protected final String TEXT_26 = ".dispose();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();

List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

String bufferSize = ElementParameterParser.getValue(node, "__RULES_BUFFER__");

if(conns!=null && conns.size() >0 ){

//get the name of the incoming connection
IConnection inConn = null;
if (node.getIncomingConnections()!=null) {
	for (IConnection incomingConn : node.getIncomingConnections()) {
		if (incomingConn.getLineStyle().equals(EConnectionType.FLOW_MAIN)) {
			inConn = incomingConn;
			break;
		}
	}
}
if(inConn==null)return "";

    
	for(IConnection conn: conns){
		if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_3);
    
		}
	}

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
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
    
			for(int i=0;i < conns.size(); i++){
				IConnection conn = conns.get(i);
				if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)){
		
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
		}
	}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
}

    return stringBuffer.toString();
  }
}
