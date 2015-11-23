package org.talend.designer.codegen.translators.talendcloud.action;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TActionOutputEndJava
{
  protected static String nl;
  public static synchronized TActionOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TActionOutputEndJava result = new TActionOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "if (null == iPaasObject) {" + NL + "\tjava.io.PrintStream ";
  protected final String TEXT_2 = "_Log_Output = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));" + NL + "\t";
  protected final String TEXT_3 = "_Log_Output.println(util_";
  protected final String TEXT_4 = ".format().toString());" + NL + "\t";
  protected final String TEXT_5 = "_Log_Output.flush();" + NL + "}";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
