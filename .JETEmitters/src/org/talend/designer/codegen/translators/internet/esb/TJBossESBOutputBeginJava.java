package org.talend.designer.codegen.translators.internet.esb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TJBossESBOutputBeginJava
{
  protected static String nl;
  public static synchronized TJBossESBOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJBossESBOutputBeginJava result = new TJBossESBOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "    if (this.valueObject == null) {" + NL + "        throw new RuntimeException(\"The jboss esb message is null\");" + NL + "    } else if (((org.jboss.soa.esb.message.Message)this.valueObject).getBody() == null) {" + NL + "        throw new RuntimeException(\"The body of jboss esb message is null\");" + NL + "    }";
  protected final String TEXT_2 = NL + "    if(((org.jboss.soa.esb.message.Message)this.valueObject).getBody().get() == null){" + NL + "    \t((org.jboss.soa.esb.message.Message)this.valueObject).getBody().add(";
  protected final String TEXT_3 = "); " + NL + "    }";
  protected final String TEXT_4 = NL + "    if(((org.jboss.soa.esb.message.Message)this.valueObject).getBody().get(";
  protected final String TEXT_5 = ") == null){" + NL + "    \t((org.jboss.soa.esb.message.Message)this.valueObject).getBody().add(";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ");" + NL + "    }";
  protected final String TEXT_8 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
	String messageKey = ElementParameterParser.getValue(node, "__MESSAGEKEY__");
	String messageValue = ElementParameterParser.getValue(node, "__MESSAGEVALUE__");

    stringBuffer.append(TEXT_1);
    if(messageKey==null || messageKey.length()==0){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(messageValue );
    stringBuffer.append(TEXT_3);
    }else{
    stringBuffer.append(TEXT_4);
    stringBuffer.append(messageKey );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(messageKey );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(messageValue );
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
