package org.talend.designer.codegen.translators.transformation;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class CSetHeaderMainJava
{
  protected static String nl;
  public static synchronized CSetHeaderMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CSetHeaderMainJava result = new CSetHeaderMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t\t\t.setHeader(";
  protected final String TEXT_2 = ").simple(\"${in.header.CamelCxfMessage[CorrelationID]}\", String.class)" + NL;
  protected final String TEXT_3 = NL + "\t\t\t\t\t\t.setHeader(";
  protected final String TEXT_4 = ").method(";
  protected final String TEXT_5 = ")";
  protected final String TEXT_6 = NL + "\t\t\t\t\t\t.setHeader(";
  protected final String TEXT_7 = ").";
  protected final String TEXT_8 = "(";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = "NSMap)";
  protected final String TEXT_11 = NL + "\t\t\t\t\t\t.setHeader(";
  protected final String TEXT_12 = ").";
  protected final String TEXT_13 = "(";
  protected final String TEXT_14 = ")";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\t.setHeader(";
  protected final String TEXT_16 = ").";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	List<Map<String, String>> tableValues =
    (List<Map<String,String>>)ElementParameterParser.getObjectValue(
        node,
        "__VALUES__"
    );
	String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns.size()>0) {
		 	for(Map<String, String> headersMap: tableValues){
		 			String headerName = headersMap.get("NAME");
		 			String headerLanguage = headersMap.get("LANGUAGE");
		 			String headerExpression = headersMap.get("EXPRESSION");
		 			if("correlation".equals(headerLanguage)){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(headerName);
    stringBuffer.append(TEXT_2);
    		 			}else if("bean".equals(headerLanguage)){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(headerName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(headerExpression);
    stringBuffer.append(TEXT_5);
    
		 			}else if("xpath".equals(headerLanguage) && "true".equals(useNamespaces)){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(headerName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(headerLanguage);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(headerExpression);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
		 			}else if(!"none".equals(headerLanguage)) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(headerName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(headerLanguage);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(headerExpression);
    stringBuffer.append(TEXT_14);
    
					}else{

    stringBuffer.append(TEXT_15);
    stringBuffer.append(headerName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(headerExpression);
    
					}
		 	}
	}

    return stringBuffer.toString();
  }
}
