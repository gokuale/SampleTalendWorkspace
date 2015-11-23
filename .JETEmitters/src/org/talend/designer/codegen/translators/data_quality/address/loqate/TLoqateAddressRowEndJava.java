package org.talend.designer.codegen.translators.data_quality.address.loqate;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TLoqateAddressRowEndJava
{
  protected static String nl;
  public static synchronized TLoqateAddressRowEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLoqateAddressRowEndJava result = new TLoqateAddressRowEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "  com.loqate.lqtProcessList.destroy(lqtProcessList_";
  protected final String TEXT_2 = ");" + NL + "  com.loqate.lqtProcessOptions.destroy(lqtProcessOptions_";
  protected final String TEXT_3 = ");" + NL + "" + NL + "  lqtServer_";
  protected final String TEXT_4 = ".close(session_";
  protected final String TEXT_5 = ");" + NL + "  lqtServer_";
  protected final String TEXT_6 = ".shutdown();" + NL + "  com.loqate.lqtInputRecord.destroy(lqtInputRecord_";
  protected final String TEXT_7 = ");" + NL + "  com.loqate.lqtProcessResult.destroy(lqtProcessResult_";
  protected final String TEXT_8 = ");" + NL + "  com.loqate.lqtServer.destroy(lqtServer_";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
