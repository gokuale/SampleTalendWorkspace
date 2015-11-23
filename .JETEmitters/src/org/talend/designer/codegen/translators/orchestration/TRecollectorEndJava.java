package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TRecollectorEndJava
{
  protected static String nl;
  public static synchronized TRecollectorEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRecollectorEndJava result = new TRecollectorEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "} else {" + NL + "\t\tfinished_";
  protected final String TEXT_2 = " = true;" + NL + "}" + NL + "" + NL + "}//loop!" + NL + "} catch (Exception ex) {" + NL + "\tex.printStackTrace();" + NL + "\tfor (int i = 0; i < queues_";
  protected final String TEXT_3 = ".size(); i++) {" + NL + "    \tqueues_";
  protected final String TEXT_4 = ".get(i).getMap().put(\"HAS_ERROR\",ex);" + NL + "    }" + NL + "    throw ex;" + NL + "}" + NL + "}" + NL;
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    String departComponent = ElementParameterParser.getValue(node,"__DEPART_COMPONENT__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
