package org.talend.designer.codegen.translators.routing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class CSplitterMainJava
{
  protected static String nl;
  public static synchronized CSplitterMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CSplitterMainJava result = new CSplitterMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t.split(";
  protected final String TEXT_2 = ")";
  protected final String TEXT_3 = ").";
  protected final String TEXT_4 = "(";
  protected final String TEXT_5 = ",";
  protected final String TEXT_6 = ",";
  protected final String TEXT_7 = "NSMap";
  protected final String TEXT_8 = ")";
  protected final String TEXT_9 = ".aggregationStrategyRef(";
  protected final String TEXT_10 = ")";
  protected final String TEXT_11 = ".parallelProcessing()";
  protected final String TEXT_12 = ".stopOnException()";
  protected final String TEXT_13 = ".streaming()";
  protected final String TEXT_14 = ".shareUnitOfWork()";
  protected final String TEXT_15 = ".timeout(";
  protected final String TEXT_16 = ")";
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
	String expression = ElementParameterParser.getValue(node, "__EXPRESSION__");
	boolean useResultClassType ="true".equals(ElementParameterParser.getValue(node,"__USE_RESULT_CLASS_TYPE__"));
	String resultClassType = ElementParameterParser.getValue(node,"__RESULT_CLASS_TYPE__");
	String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
	
	
	boolean useStrategy = "true".equals(ElementParameterParser.getValue(node,"__USE_STRATEGY__"));
	String aggregationStrategy = ElementParameterParser.getValue(node,"__AGGREGATION_STRATEGY__");
	
	boolean arallelProcessing="true".equals(ElementParameterParser.getValue(node, "__PARALLET_PROCESSING__"));
	boolean stopOnException="true".equals(ElementParameterParser.getValue(node, "__STOP_ON_EXCEPTION__"));
	boolean streaming="true".equals(ElementParameterParser.getValue(node, "__STREAMING__"));
	boolean shareUnitOfWork="true".equals(ElementParameterParser.getValue(node, "__SHARE_UNIT_OF_WORK__"));
	
	String timeout=ElementParameterParser.getValue(node, "__TIMEOUT__");
	boolean hasTimeout=(timeout!=null&&timeout.matches("\\s*\\d+\\s*"));
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns.size()>0) {

    stringBuffer.append(TEXT_1);
    
			if("none".equals(language)){
				//inorder expression for former migrate
				
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_2);
    
			}else{
				//fill postorder expression
				
    stringBuffer.append(TEXT_3);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(expression);
    
				if("xpath".equals(language)){
					if(useResultClassType){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(resultClassType);
    	}
					if("true".equals(useNamespaces)){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    		}
				}
				//close expression
				
    stringBuffer.append(TEXT_8);
    
			}
			//then wait other postorder options.
		if(useStrategy){			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggregationStrategy);
    stringBuffer.append(TEXT_10);
    	}
		if(arallelProcessing){		
    stringBuffer.append(TEXT_11);
    								}
		if(stopOnException){		
    stringBuffer.append(TEXT_12);
    									}
		if(streaming){				
    stringBuffer.append(TEXT_13);
    										}
		if(shareUnitOfWork){		
    stringBuffer.append(TEXT_14);
    									}
		if(hasTimeout){				
    stringBuffer.append(TEXT_15);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_16);
    								}
	}

    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
