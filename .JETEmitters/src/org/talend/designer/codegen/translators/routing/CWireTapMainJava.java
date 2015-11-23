package org.talend.designer.codegen.translators.routing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class CWireTapMainJava
{
  protected static String nl;
  public static synchronized CWireTapMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CWireTapMainJava result = new CWireTapMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t.wireTap(";
  protected final String TEXT_2 = ")";
  protected final String TEXT_3 = NL + "\t\t.copy(true)";
  protected final String TEXT_4 = NL + "\t\t.copy(false)";
  protected final String TEXT_5 = NL + "\t\t\t.newExchangeBody(";
  protected final String TEXT_6 = "(";
  protected final String TEXT_7 = "))";
  protected final String TEXT_8 = NL + "\t\t\t.newExchange(new org.apache.camel.Processor() {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tpublic void process(org.apache.camel.Exchange exchange) throws Exception {" + NL + "\t\t\t\t\t\t// TODO Auto-generated method stub" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t})" + NL + "\t\t\t\t";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String URI = ElementParameterParser.getValue(node, "__URI__");
	boolean new_exchange  = "true".equals(ElementParameterParser.getValue(node, "__NEW_EXCHANGE__"));
	boolean copy_original_message  = "true".equals(ElementParameterParser.getValue(node, "__COPY_ORIGINAL_MESSAGE__"));
	String expression  = ElementParameterParser.getValue(node, "__EXPRESSION__");
	String processor  = ElementParameterParser.getValue(node, "__PROCESSOR__");
	String code = ElementParameterParser.getValue(node, "__CODE__");
	String language  = ElementParameterParser.getValue(node, "__LANGUAGES__");
	String expressiontxt  = ElementParameterParser.getValue(node, "__EXPRESSIONTXT__");
	

    stringBuffer.append(TEXT_1);
    stringBuffer.append(URI);
    stringBuffer.append(TEXT_2);
    

	if(copy_original_message){

    stringBuffer.append(TEXT_3);
    
	}else{

    stringBuffer.append(TEXT_4);
    	
	}

	if(new_exchange){
		if("true".equals(expression)){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(expressiontxt);
    stringBuffer.append(TEXT_7);
    
		}else if("true".equals(processor)){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(code);
    stringBuffer.append(TEXT_9);
    		
		}
}

    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
