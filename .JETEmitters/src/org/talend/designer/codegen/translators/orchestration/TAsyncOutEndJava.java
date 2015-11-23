package org.talend.designer.codegen.translators.orchestration;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TAsyncOutEndJava
{
  protected static String nl;
  public static synchronized TAsyncOutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAsyncOutEndJava result = new TAsyncOutEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\tif (buffers_";
  protected final String TEXT_4 = ".size() > 0) {" + NL + "\t\tglobalMap.put(\"PARALLEL_FLOW_BUFFER_";
  protected final String TEXT_5 = "\", buffers_";
  protected final String TEXT_6 = ");" + NL + "\t    ";
  protected final String TEXT_7 = "Process(globalMap);" + NL + "\t}" + NL + "\tpool_";
  protected final String TEXT_8 = ".waitForEnd();" + NL + "\tpool_";
  protected final String TEXT_9 = ".setGlobalVariables(globalMap);";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    
	boolean isParallelize = false;
	INode parallelizeNode = null;
	String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
	for(INode tmpNode:node.getProcess().getGeneratingNodes()){
		if(tmpNode!=null && tmpNode.isActivate() && tmpNode.getUniqueName().equals(destination)){
			isParallelize = true;
			parallelizeNode = tmpNode;
		}
	}
	if(isParallelize){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid.replaceAll("tAsyncOut", "tAsyncIn"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
	}

    return stringBuffer.toString();
  }
}
