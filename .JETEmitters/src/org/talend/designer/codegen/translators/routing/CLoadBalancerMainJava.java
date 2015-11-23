package org.talend.designer.codegen.translators.routing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class CLoadBalancerMainJava
{
  protected static String nl;
  public static synchronized CLoadBalancerMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CLoadBalancerMainJava result = new CLoadBalancerMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t.loadBalance().";
  protected final String TEXT_2 = "(";
  protected final String TEXT_3 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_4 = "(";
  protected final String TEXT_5 = ")";
  protected final String TEXT_6 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\t\t\t\t\t\t,";
  protected final String TEXT_8 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_9 = ".class";
  protected final String TEXT_10 = NL + "\t\t\t\t\t\t\t-1";
  protected final String TEXT_11 = NL + "\t\t\t\t\t\t\t0";
  protected final String TEXT_12 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\t\t, ";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = "\t\t\t" + NL + "\t\t\t)";
  protected final String TEXT_16 = NL + "\t\t\t.loadBalance(new ";
  protected final String TEXT_17 = "())";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	
	String strategy = ElementParameterParser.getValue(node, "__STRATEGY__");
	String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
	String expression = ElementParameterParser.getValue(node, "__EXPRESSION__");
	
	String exceptionMode = ElementParameterParser.getValue(node, "__EXCEPTION_MODE__");
	String roundRobinMode = ElementParameterParser.getValue(node, "__ROUND_ROBIN_MODE__");
	
	String maxFailAttempt = ElementParameterParser.getValue(node, "__MAXFAILATTEMPT__");
	
	String inherit = ElementParameterParser.getValue(node, "__INHERIT_ERROR_HANDLER__");
	String useRoundRobin = ElementParameterParser.getValue(node, "__USE_ROUND_ROBIN__");
	
	String attemptNumber = ElementParameterParser.getValue(node, "__ATTEMPT_NUMBER__");
	
	String customBalancer = ElementParameterParser.getValue(node, "__CUSTOM_LOAD_BALANCER__");
	
	List<Map<String, String>> exceptions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__EXCEPTIONS__");
	
		
	if(conns.size()>0) { //BEGIN 1
		if(!("custom".equals(strategy))) { //BEGIN 2

    stringBuffer.append(TEXT_1);
    stringBuffer.append(strategy);
    stringBuffer.append(TEXT_2);
    
				if("sticky".equals(strategy)) { //BEGIN STICKY
					if(!("none".equals(language))) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_5);
    
					} else {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(expression);
    
					}
				} // END STICKY
				if("failover".equals(strategy)) { //BEGIN FAILOVER
					if("true".equals(exceptionMode)) {
						boolean isFirstException = true;
						if(exceptions.size()>0) {
							for(Map<String, String> anException : exceptions) {
								if(!isFirstException) {

    stringBuffer.append(TEXT_7);
    
								}
								isFirstException=false;

    stringBuffer.append(TEXT_8);
    stringBuffer.append(anException.get("EXCEPTION"));
    stringBuffer.append(TEXT_9);
    
							}
						}
					}
					if("true".equals(roundRobinMode)) {
						if("ALWAYS".equals(maxFailAttempt)) {

    stringBuffer.append(TEXT_10);
    
						}
						if("NEVER".equals(maxFailAttempt)) {

    stringBuffer.append(TEXT_11);
    
						}
						if("SOMETIMES".equals(maxFailAttempt)) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(Integer.parseInt(attemptNumber));
    
						}

    stringBuffer.append(TEXT_13);
    stringBuffer.append("true".equals(inherit)?true:false);
    stringBuffer.append(TEXT_14);
    stringBuffer.append("true".equals(useRoundRobin)?true:false);
    
						
					}
				} //END FAILOVER
					
			

    stringBuffer.append(TEXT_15);
    
		} else {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(customBalancer);
    stringBuffer.append(TEXT_17);
    
		} //END 2
	} //END 1

    return stringBuffer.toString();
  }
}
