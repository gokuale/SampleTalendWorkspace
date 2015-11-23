package org.talend.designer.codegen.translators.common;

import java.util.Vector;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class Sparkstreaming_checkpoint_subprocess_footerJava
{
  protected static String nl;
  public static synchronized Sparkstreaming_checkpoint_subprocess_footerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Sparkstreaming_checkpoint_subprocess_footerJava result = new Sparkstreaming_checkpoint_subprocess_footerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\treturn ctx;" + NL + "" + NL + "\t    } catch(java.lang.Exception e) {" + NL + "\t    \tthrow e;" + NL + "\t    }" + NL + "    }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
