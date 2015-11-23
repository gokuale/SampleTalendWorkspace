package org.talend.designer.codegen.translators.custom_code;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSetDynamicSchemaBeginJava
{
  protected static String nl;
  public static synchronized TSetDynamicSchemaBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSetDynamicSchemaBeginJava result = new TSetDynamicSchemaBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "routines.system.Dynamic dynamic_";
  protected final String TEXT_2 = " = new routines.system.Dynamic();";

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
