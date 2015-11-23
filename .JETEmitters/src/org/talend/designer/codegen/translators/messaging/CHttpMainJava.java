package org.talend.designer.codegen.translators.messaging;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IElementParameter;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CHttpMainJava
{
  protected static String nl;
  public static synchronized CHttpMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CHttpMainJava result = new CHttpMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t.to(";
  protected final String TEXT_2 = ")";
  protected final String TEXT_3 = NL + "\t\t\tfrom(";
  protected final String TEXT_4 = ")";
  protected final String TEXT_5 = NL + "\t\t";
  protected final String TEXT_6 = ".to(";
  protected final String TEXT_7 = ")";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    
    String isServer = ElementParameterParser.getValue(node, "__SERVER__");
    
    String cid = node.getUniqueName();
    //  http://jira.talendforge.org/browse/TESB-5241
    /*
     * change to use label + unique to make it unique but readable
     */
//    IElementParameter param = node.getElementParameter("LABEL");
//    if(param != null && !"__UNIQUE_NAME__".equals(param.getValue())){
//    	cid = (String)param.getValue()+"_"+cid;	
//    }
    
	
    String uriRef = "uriMap.get(\"" + cid + "\")";
    
    if("true".equals(isServer)){
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	if(conns.size()>0){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(uriRef);
    stringBuffer.append(TEXT_2);
    
    	}else{

    stringBuffer.append(TEXT_3);
    stringBuffer.append(uriRef);
    stringBuffer.append(TEXT_4);
    
    	}
    	
    }else{
		StringBuilder sb = new StringBuilder();
		
		String method = ElementParameterParser.getValue(node, "__METHOD__");
		String contentType = ElementParameterParser.getValue(node, "__CONTENT_TYPE__");
		
		sb.append(".setHeader(\"");
		sb.append("CamelHttpMethod");
		sb.append("\",");
		sb.append("constant(\"");
		sb.append(method);
		sb.append("\"))");
		
		String formStyle = ElementParameterParser.getValue(node, "__FORM_CONTENT__");
		String plainTextStyle = ElementParameterParser.getValue(node, "__PLAIN_TEXT__");
		String noContentStyle = ElementParameterParser.getValue(node, "__NO_CONTENT__");
		String manualContentType = ElementParameterParser.getValue(node, "__MANUAL_CONTENT_TYPE__");
		
		if (contentType.equals("other")) {
			contentType=manualContentType;
		}else{
			contentType = "\""+contentType+"\"";
		}
		if(("POST".equals(method)||"PUT".equals(method))){
			if("true".equals(plainTextStyle)||"true".equals(noContentStyle)){
				sb.append(".setHeader(\"Content-Type\", constant("+ contentType + "))");
				if("true".equals(plainTextStyle)){
					String plainTextContent = ElementParameterParser.getValue(node, "__PLAIN_TEXT_CONTENT__");
					sb.append(".setBody(");
					sb.append("constant(");
					sb.append(plainTextContent);
					sb.append("))");
				}
			}else if("true".equals(formStyle)){
				// content-type of form is "application/x-www-form-urlencoded"
				sb.append(".setHeader(\"Content-Type\", constant(\"application/x-www-form-urlencoded\"))");
				List<Map<String, String>> parameters = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__PARAMETERS__");
				String encodeCharset = ElementParameterParser.getValue(node, "__ENCODER_CHARSET__");
				boolean hasParam = false;
				sb.append(".setBody(");
				sb.append("constant(");
				for (Map<String, String> map : parameters) {
					String argName = map.get("KEY").trim();
					String argValue = map.get("VALUE").trim();
					try{
						if(argName.startsWith("\"")&&argName.endsWith("\"")&&argName.length()>=2){
							argName = URLEncoder.encode(argName.substring(1, argName.length()-1),encodeCharset);
							argName = "\""+argName+"\"";
						}else{
							argName = URLEncoder.encode(argName,encodeCharset);
						}
						if(argValue.startsWith("\"")&&argValue.endsWith("\"")&&argValue.length()>=2){
							argValue = URLEncoder.encode(argValue.substring(1, argValue.length()-1),encodeCharset);
							argValue = "\""+argValue+"\"";
						}else{
							argValue = URLEncoder.encode(argValue,encodeCharset);
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					if (hasParam) {
						sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
					} else {
						sb.append(argName + "+\"=\"+" + argValue);
						hasParam = true;
					}
				}
				sb.append("))");
			}
		}
		
		
		List<Map<String, String>> arguments = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__HEADERS__");
		for (Map<String, String> map : arguments) {
			String argName = map.get("KEY").trim();
			String argValue = map.get("VALUE").trim();
			sb.append(".setHeader(");
			sb.append(argName);
			sb.append(",");
			sb.append("constant(");
			sb.append(argValue);
			sb.append("))");
		}



    stringBuffer.append(TEXT_5);
    stringBuffer.append(sb.toString());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(uriRef);
    stringBuffer.append(TEXT_7);
    
    }

    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
