package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TAsyncInEndJava
{
  protected static String nl;
  public static synchronized TAsyncInEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAsyncInEndJava result = new TAsyncInEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t}" + NL + "\t\t\t buffers_";
  protected final String TEXT_3 = ".clear();" + NL + "\t\t}" + NL + "\t\tthis.setFree(true);" + NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
