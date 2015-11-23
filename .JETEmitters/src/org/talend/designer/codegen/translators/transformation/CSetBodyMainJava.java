package org.talend.designer.codegen.translators.transformation;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class CSetBodyMainJava
{
  protected static String nl;
  public static synchronized CSetBodyMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CSetBodyMainJava result = new CSetBodyMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t.setBody().";
  protected final String TEXT_2 = "(";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = "NSMap)";
  protected final String TEXT_5 = NL + "\t\t\t.setBody().";
  protected final String TEXT_6 = "(";
  protected final String TEXT_7 = ")";
  protected final String TEXT_8 = NL + "\t\t\t.setBody().";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
	String expression = ElementParameterParser.getValue(node, "__EXPRESSION__");
	String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns.size()>0) {
		if("xpath".equals(language)&&"true".equals(useNamespaces)){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
		}else if(!("none".equals(language))) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_7);
    
		} else {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(expression);
    
		}
	}

    return stringBuffer.toString();
  }
}
