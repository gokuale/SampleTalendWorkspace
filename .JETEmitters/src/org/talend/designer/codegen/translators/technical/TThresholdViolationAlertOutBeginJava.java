package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TThresholdViolationAlertOutBeginJava
{
  protected static String nl;
  public static synchronized TThresholdViolationAlertOutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TThresholdViolationAlertOutBeginJava result = new TThresholdViolationAlertOutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "StringBuilder bd_";
  protected final String TEXT_3 = " = new StringBuilder();" + NL + "" + NL + "StringBuilder bdExtra_";
  protected final String TEXT_4 = " = new StringBuilder();" + NL + "" + NL + "bdExtra_";
  protected final String TEXT_5 = ".append(\"<p style=\\\"font:normal bold 11pt/14pt Times, serif\\\"> List of violated threholds:</p>\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid_original = ElementParameterParser.getValue(node, "__DESTINATION__");
	String cid = cid_original.replace("tThresholdViolationAlert","tThresholdVA");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
