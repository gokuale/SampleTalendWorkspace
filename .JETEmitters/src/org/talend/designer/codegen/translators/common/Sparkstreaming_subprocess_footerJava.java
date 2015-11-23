package org.talend.designer.codegen.translators.common;

import java.util.Vector;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class Sparkstreaming_subprocess_footerJava
{
  protected static String nl;
  public static synchronized Sparkstreaming_subprocess_footerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Sparkstreaming_subprocess_footerJava result = new Sparkstreaming_subprocess_footerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tctx.start();" + NL + "\t\tctx.awaitTermination(";
  protected final String TEXT_2 = ");" + NL + "" + NL + "\t    } catch(java.lang.Exception e) {" + NL + "\t    \tthrow e;" + NL + "\t    }" + NL + "    }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	Vector v = (Vector) codeGenArgument.getArgument();
	INode sparkConfig = (INode)v.get(0);

	boolean defineDuration = false;
	String duration = null;

	if(sparkConfig != null) {
		defineDuration = "true".equals(ElementParameterParser.getValue(sparkConfig, "__DEFINE_DURATION__"));
		duration = ElementParameterParser.getValue(sparkConfig, "__STREAMING_DURATION__");
	}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(defineDuration?duration:"");
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
