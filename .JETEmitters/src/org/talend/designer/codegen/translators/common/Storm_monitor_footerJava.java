package org.talend.designer.codegen.translators.common;

import java.util.List;
import java.util.Vector;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.temp.ECodePart;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class Storm_monitor_footerJava
{
  protected static String nl;
  public static synchronized Storm_monitor_footerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Storm_monitor_footerJava result = new Storm_monitor_footerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "    }" + NL + "};";
  protected final String TEXT_2 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
/*
    This template closes the scope opened by the storm_monitor_header template
    (i.e. finishing the while loop for monitoring and closing the method.)

    After this method, the scope is the top-level job class.
 */

CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
Vector v = (Vector) codeGenArgument.getArgument();
IProcess process = (IProcess)v.get(0);
List<INode> rootNodes = (List<INode>)v.get(1);
INode stormConfig = (INode)v.get(2);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
