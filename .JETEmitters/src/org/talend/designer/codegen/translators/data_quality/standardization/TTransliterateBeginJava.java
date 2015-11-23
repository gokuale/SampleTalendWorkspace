package org.talend.designer.codegen.translators.data_quality.standardization;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TTransliterateBeginJava
{
  protected static String nl;
  public static synchronized TTransliterateBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTransliterateBeginJava result = new TTransliterateBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "int nb_line_";
  protected final String TEXT_2 = " = 0;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
