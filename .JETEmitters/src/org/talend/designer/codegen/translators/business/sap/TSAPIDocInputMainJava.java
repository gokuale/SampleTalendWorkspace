package org.talend.designer.codegen.translators.business.sap;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSAPIDocInputMainJava
{
  protected static String nl;
  public static synchronized TSAPIDocInputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPIDocInputMainJava result = new TSAPIDocInputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String file_idoc_xml= ElementParameterParser.getValue(node, "__FILE_IDOC_XML__");
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

    return stringBuffer.toString();
  }
}
