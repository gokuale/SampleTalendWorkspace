package org.talend.designer.codegen.translators.data_quality.standardization;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TSynonymOutputEndJava
{
  protected static String nl;
  public static synchronized TSynonymOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSynonymOutputEndJava result = new TSynonymOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tbuilder_";
  protected final String TEXT_2 = ".commit();" + NL + "\tbuilder_";
  protected final String TEXT_3 = ".closeIndex();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();	
String path = ElementParameterParser.getValue(node, "__FILE_PATH__"); 
String operation = ElementParameterParser.getValue(node, "__OPERATION__");

if ("DELETE_INDEX".equals(operation)) {

} else {
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    }
    return stringBuffer.toString();
  }
}
