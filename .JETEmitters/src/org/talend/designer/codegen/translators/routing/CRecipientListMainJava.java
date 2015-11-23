package org.talend.designer.codegen.translators.routing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class CRecipientListMainJava
{
 
  protected static String nl;
  public static synchronized CRecipientListMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CRecipientListMainJava result = new CRecipientListMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL;
  protected final String TEXT_2 = NL + "\t\t\t.recipientList(";
  protected final String TEXT_3 = ").";
  protected final String TEXT_4 = "(";
  protected final String TEXT_5 = ",";
  protected final String TEXT_6 = ",";
  protected final String TEXT_7 = "NSMap";
  protected final String TEXT_8 = ")";
  protected final String TEXT_9 = ".aggregationStrategyRef(";
  protected final String TEXT_10 = ")\t\t\t\t";
  protected final String TEXT_11 = ".parallelProcessing()\t\t\t\t\t\t\t";
  protected final String TEXT_12 = ".executorService(";
  protected final String TEXT_13 = ")\t\t\t";
  protected final String TEXT_14 = ".stopOnException()\t\t\t\t\t\t\t\t";
  protected final String TEXT_15 = ".ignoreInvalidEndpoints()\t\t\t\t\t\t\t";
  protected final String TEXT_16 = ".streaming()\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_17 = ".timeout( ";
  protected final String TEXT_18 = " )\t\t\t\t\t\t\t\t";
  protected final String TEXT_19 = ".onPrepareRef(";
  protected final String TEXT_20 = ")\t\t";
  protected final String TEXT_21 = ".shareUnitOfWork()\t\t\t\t\t\t\t\t";
  protected final String TEXT_22 = NL;

 	private   INode node;
 
	public String getSetting(String settingName){
		return ElementParameterParser.getValue(node, settingName);
	}
	
	public boolean getBoolSetting(String settingName){
		return "true".equals(getSetting(settingName));
	}
	
	public void setNode(INode node){
		this.node=node;
	}

	public String generate(CodeGeneratorArgument argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	setNode(node);
	String cid = node.getUniqueName();
	
	String language = getSetting("__LANGUAGES__");
	String expression = getSetting("__EXPRESSION__");
	boolean useResultClassType = getBoolSetting("__USE_RESULT_CLASS_TYPE__");
	String resultClassType = getSetting("__RESULT_CLASS_TYPE__");
	boolean useNamespaces = getBoolSetting( "__USE_NAMESPACES__");

	boolean useSpecifyDelimiter = getBoolSetting( "__USE_DELIMITER__");
	String delimiter = getSetting( "__DELIMITER__");
	
	boolean useStrategy = getBoolSetting( "__USE_STRATEGY__");
	String strategyRef = getSetting( "__STRATEGY_REF__");
	
	
	boolean parallelProcessing = getBoolSetting( "__PARELLEL_PROCESS__");
	boolean useExecutorService = parallelProcessing && getBoolSetting( "__USE_EXECUTOR_SERVICE__");
	String executorService = getSetting( "__EXECUTOR_SERVICE__");
	
	
	boolean stopOnException = getBoolSetting( "__STOP_ON_EXCEPTION__");
	boolean  ignoreInvalid = getBoolSetting( "__IGNORE_INVALID__");
	boolean streaming = getBoolSetting( "__STREAMING__");
	String timeout = getSetting( "__TIMEOUT__");
	boolean useTimeout = ((timeout!=null)&&(timeout.equals("\\s*\\d+\\s*")));
	
	boolean useOnPrepareProcessor = getBoolSetting("__USE_ON_PREPARE_PROCESSOR__");
	String onPrepareProcessor = getSetting("__ON_PREPARE_PROCESSOR__");
	
	boolean shareUnitOfWork = getBoolSetting( "__SHARE_UNIT_OF_WORK__");
	
	
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns.size()>0) {

    stringBuffer.append(TEXT_2);
    	if(useSpecifyDelimiter){
    stringBuffer.append(delimiter);
    }		
    stringBuffer.append(TEXT_3);
    	
			//will return ExpressionClause instance, then wait for fill  expression
			if(!"none".equals(language)){
				
    stringBuffer.append(language);
    stringBuffer.append(TEXT_4);
    
			}
			//then wait for fill expression
				
    stringBuffer.append(expression);
    
			if("xpath".equals(language)){
				if(useResultClassType){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(resultClassType);
    	}
				if(useNamespaces){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    					}
			}
			if(!"none".equals(language)){
				
    stringBuffer.append(TEXT_8);
    //close expression bracket
			}
			//then append suffix settings.
			if(useStrategy){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(strategyRef);
    stringBuffer.append(TEXT_10);
    }
			if(parallelProcessing){
    stringBuffer.append(TEXT_11);
    }
			if(useExecutorService){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(executorService);
    stringBuffer.append(TEXT_13);
    }
			if(stopOnException){
    stringBuffer.append(TEXT_14);
    }
			if(ignoreInvalid){
    stringBuffer.append(TEXT_15);
    }
			if(streaming){
    stringBuffer.append(TEXT_16);
    }
			if(useTimeout){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_18);
    }
			if(useOnPrepareProcessor){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(onPrepareProcessor);
    stringBuffer.append(TEXT_20);
    }
			if(shareUnitOfWork){
    stringBuffer.append(TEXT_21);
    }
			
		
	}//finish all suffix settings.

    stringBuffer.append(TEXT_22);
    return stringBuffer.toString();
  }
}