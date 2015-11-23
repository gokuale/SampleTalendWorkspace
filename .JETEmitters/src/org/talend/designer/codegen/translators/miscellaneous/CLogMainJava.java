package org.talend.designer.codegen.translators.miscellaneous;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IElementParameter;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CLogMainJava
{
  protected static String nl;
  public static synchronized CLogMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CLogMainJava result = new CLogMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t.log(org.apache.camel.LoggingLevel.";
  protected final String TEXT_2 = ",";
  protected final String TEXT_3 = ",";
  protected final String TEXT_4 = ")";
  protected final String TEXT_5 = NL + "\t\t.to(";
  protected final String TEXT_6 = ")";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
   	String cid = node.getUniqueName();
//  http://jira.talendforge.org/browse/TESB-5241
	/*
   	 * change to use label + unique to make it unique but readable
   	 */
//	IElementParameter param = node.getElementParameter("LABEL");
//	if(param != null && !"__UNIQUE_NAME__".equals(param.getValue())){
//		cid = (String)param.getValue()+"_"+cid;	
//	}

	String useLogEIP = ElementParameterParser.getValue(node, "__USE_LOGEIP__");
	if("true".equals(useLogEIP)){
		String logName = ElementParameterParser.getValue(node, "__LOGGING_CATEGORY__");
		String level = ElementParameterParser.getValue(node, "__LEVEL_TYPE__");
		String message = ElementParameterParser.getValue(node, "__MESSAGE__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(logName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_4);
    
	}else{
    	String uriRef = "uriMap.get(\"" + cid + "\")";

    stringBuffer.append(TEXT_5);
    stringBuffer.append(uriRef);
    stringBuffer.append(TEXT_6);
    
	}

    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
