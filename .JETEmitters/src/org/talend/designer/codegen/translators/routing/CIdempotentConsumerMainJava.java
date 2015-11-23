package org.talend.designer.codegen.translators.routing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class CIdempotentConsumerMainJava
{
  protected static String nl;
  public static synchronized CIdempotentConsumerMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CIdempotentConsumerMainJava result = new CIdempotentConsumerMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t.idempotentConsumer(";
  protected final String TEXT_2 = ",";
  protected final String TEXT_3 = NL + "\t\t\t\t.idempotentConsumer(";
  protected final String TEXT_4 = "(";
  protected final String TEXT_5 = "),";
  protected final String TEXT_6 = NL + "\t\t\t\t.idempotentConsumer(";
  protected final String TEXT_7 = ",";
  protected final String TEXT_8 = NL + "\t\t\torg.apache.camel.processor.idempotent.MemoryIdempotentRepository.memoryIdempotentRepository(";
  protected final String TEXT_9 = ")";
  protected final String TEXT_10 = NL + "\t\t\torg.apache.camel.processor.idempotent.FileIdempotentRepository.fileIdempotentRepository(new java.io.File(";
  protected final String TEXT_11 = "), ";
  protected final String TEXT_12 = ")";
  protected final String TEXT_13 = NL + "\t\t).eager(";
  protected final String TEXT_14 = ").skipDuplicate(";
  protected final String TEXT_15 = ")";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	String expression = ElementParameterParser.getValue(node, "__EXPRESSION__");
	String useLanguage = ElementParameterParser.getValue(node, "__USE_LANGUAGE__");
	String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
	String predicate = ElementParameterParser.getValue(node, "__PREDICATE__");
	String repository = ElementParameterParser.getValue(node, "__REPOSITORY_TYPE__");
	String cacheSize = ElementParameterParser.getValue(node, "__CACHE_SIZE__");
	String fileStore = ElementParameterParser.getValue(node, "__FILE_STORE__");
	String eager = ElementParameterParser.getValue(node, "__EAGER__");
	String skipDuplicate = ElementParameterParser.getValue(node, "__SKIP_DUPLICATE__");
	
	boolean isEager = false;
	boolean isSkip = false;
	
	if("true".equals(eager)){
		isEager = true;
	}
	
	if("true".equals(skipDuplicate)){
		isSkip = true;
	}
	
	
	if(conns.size()>0) { //BEGIN 1
		if("false".equals(useLanguage)) { //BEGIN 2

    stringBuffer.append(TEXT_1);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_2);
    
		} else {
			if(!("none".equals(language))) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(predicate);
    stringBuffer.append(TEXT_5);
    
			} else {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(predicate);
    stringBuffer.append(TEXT_7);
    
			}
		} //END 2
		
		if("MEMORY".equals(repository)) { //BEGIN 2

    stringBuffer.append(TEXT_8);
    stringBuffer.append((cacheSize.length()>0 && !("".equals(cacheSize)))?Integer.parseInt(cacheSize):200);
    stringBuffer.append(TEXT_9);
    
		} else if("FILE".equals(repository)) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(fileStore);
    stringBuffer.append(TEXT_11);
    stringBuffer.append((cacheSize.length()>0 && !("".equals(cacheSize)))?Integer.parseInt(cacheSize):200);
    stringBuffer.append(TEXT_12);
    
		} //END 2

    stringBuffer.append(TEXT_13);
    stringBuffer.append(isEager);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(isSkip);
    stringBuffer.append(TEXT_15);
    
	} //END 1

    return stringBuffer.toString();
  }
}
