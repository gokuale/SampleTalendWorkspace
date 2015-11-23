package org.talend.designer.codegen.translators.routing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class CAggregateMainJava
{
  protected static String nl;
  public static synchronized CAggregateMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CAggregateMainJava result = new CAggregateMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t.aggregate().";
  protected final String TEXT_2 = "(";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = "NSMap)";
  protected final String TEXT_5 = NL + "\t\t\t\t.aggregate().";
  protected final String TEXT_6 = "(";
  protected final String TEXT_7 = ")";
  protected final String TEXT_8 = NL + "\t\t\t\t.aggregate().";
  protected final String TEXT_9 = NL + "\t\t\t.aggregate(new ";
  protected final String TEXT_10 = "()).";
  protected final String TEXT_11 = "(";
  protected final String TEXT_12 = ", ";
  protected final String TEXT_13 = "NSMap)";
  protected final String TEXT_14 = NL + "\t\t\t\t.aggregate(new ";
  protected final String TEXT_15 = "()).";
  protected final String TEXT_16 = "(";
  protected final String TEXT_17 = ")";
  protected final String TEXT_18 = NL + "\t\t\t\t.aggregate(new ";
  protected final String TEXT_19 = "()).";
  protected final String TEXT_20 = NL + "\t\t\t.aggregationRepository(repo_";
  protected final String TEXT_21 = ")";
  protected final String TEXT_22 = NL + "\t\t\t\t.completionSize(";
  protected final String TEXT_23 = ")";
  protected final String TEXT_24 = NL + "\t\t\t\t.completionTimeout(";
  protected final String TEXT_25 = ")";
  protected final String TEXT_26 = NL + "\t\t\t\t.completionInterval(";
  protected final String TEXT_27 = ")";
  protected final String TEXT_28 = NL + "\t\t\t\t.completionPredicate(";
  protected final String TEXT_29 = ")";
  protected final String TEXT_30 = NL + "\t\t\t.completionFromBatchConsumer()";
  protected final String TEXT_31 = NL + "\t\t\t.eagerCheckCompletion()";
  protected final String TEXT_32 = NL + "\t\t\t\t.closeCorrelationKeyOnCompletion(";
  protected final String TEXT_33 = ")";
  protected final String TEXT_34 = NL + "\t\t\t.ignoreInvalidCorrelationKeys()";
  protected final String TEXT_35 = NL + "\t\t\t.groupExchanges()";
  protected final String TEXT_36 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
	String expression = ElementParameterParser.getValue(node, "__EXPRESSION__");
	
	if("correlation".equals(language)){
		language = "simple";
		expression = "\"${in.header.CamelCxfMessage[CorrelationID]}\", String.class";
	}
	
	String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
	
	boolean useAggregationStrategy = true;
//	boolean useAggregationStrategy = "true".equals(ElementParameterParser.getValue(node, "__USE_AGGREGATION_STRATEGY__"));
	String aggregationStrategy = ElementParameterParser.getValue(node, "__AGGREGATION_STRATEGY__");
	
	boolean useCompletionSize = "true".equals(ElementParameterParser.getValue(node, "__USE_COMPLETION_SIZE__"));
	String size = ElementParameterParser.getValue(node, "__SIZE__");
	
	boolean useCompletionTimeout = "true".equals(ElementParameterParser.getValue(node, "__USE_COMPLETION_TIMEOUT__"));
	String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");
	
	boolean useCompletionInterval = "true".equals(ElementParameterParser.getValue(node, "__USE_COMPLETION_INTERVAL__"));
	String interval = ElementParameterParser.getValue(node, "__INTERVAL__");
	
	boolean useCompletionPredicate = "true".equals(ElementParameterParser.getValue(node, "__USE_COMPLETION_PREDICATE__"));
	String predicate = ElementParameterParser.getValue(node, "__PREDICATE__");
	
	boolean useCompletionBatch = "true".equals(ElementParameterParser.getValue(node, "__USE_COMPLETION_BATCH__"));
	
	boolean eagerCheckCompletion = "true".equals(ElementParameterParser.getValue(node, "__EAGER_CHECK_COMPLETION__"));
	boolean closeCorrelation = "true".equals(ElementParameterParser.getValue(node, "__CLOSE_CORRELATION__"));
	String maxBound = ElementParameterParser.getValue(node, "__MAXIMUM_BOUND__");
	boolean ignoreInvalidKey = "true".equals(ElementParameterParser.getValue(node, "__IGNORE_INVALID_KEY__"));
	boolean groupExchange = "true".equals(ElementParameterParser.getValue(node, "__GROUP_EXCHANGES__"));
	
	if(groupExchange){
		useAggregationStrategy = false;
	}
	
	boolean usePersistence = "true".equals(ElementParameterParser.getValue(node, "__USE_PERSISTENCE__"));
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns.size()>0) {
		if(!useAggregationStrategy) {
			if("xpath".equals(language) && "true".equals(useNamespaces)){

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
		} else {			
			if("xpath".equals(language) && "true".equals(useNamespaces)){

    stringBuffer.append(TEXT_9);
    stringBuffer.append(aggregationStrategy);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
		}else if(!("none".equals(language))) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(aggregationStrategy);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_17);
    
			} else {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(aggregationStrategy);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(expression);
    
			}
		}
		
		if(usePersistence) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
		}
		
		if(useCompletionSize) {
			if(!("".equals(size)) && size!=null) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		if(useCompletionTimeout) {
			if(!("".equals(timeout)) && timeout!=null) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		if(useCompletionInterval) {
			if(!("".equals(interval)) && interval!=null) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_27);
    
			}
		}
		
		if(useCompletionPredicate) {
			if(!("".equals(predicate)) && size!=predicate) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(predicate);
    stringBuffer.append(TEXT_29);
    
			}
		}
		
		if(useCompletionBatch) {

    stringBuffer.append(TEXT_30);
    
		}
		
		if(eagerCheckCompletion) {

    stringBuffer.append(TEXT_31);
    
		}
		
		if(closeCorrelation) {
			if(!("".equals(maxBound)) && maxBound!=null) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(maxBound);
    stringBuffer.append(TEXT_33);
    
			}
		}
		
		if(ignoreInvalidKey) {

    stringBuffer.append(TEXT_34);
    
		}
		
		if(groupExchange) {

    stringBuffer.append(TEXT_35);
    
		}
	}

    stringBuffer.append(TEXT_36);
    return stringBuffer.toString();
  }
}
