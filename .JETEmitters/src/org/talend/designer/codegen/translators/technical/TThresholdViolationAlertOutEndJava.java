package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TThresholdViolationAlertOutEndJava
{
  protected static String nl;
  public static synchronized TThresholdViolationAlertOutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TThresholdViolationAlertOutEndJava result = new TThresholdViolationAlertOutEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "globalMap.put(\"mailField\",bd_";
  protected final String TEXT_3 = ".toString() + bdExtra_";
  protected final String TEXT_4 = ".toString() );" + NL + "globalMap.put(\"MAILFIELD_";
  protected final String TEXT_5 = "\", bd_";
  protected final String TEXT_6 = ".toString() + bdExtra_";
  protected final String TEXT_7 = ".toString());";

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
    stringBuffer.append(cid_original );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
