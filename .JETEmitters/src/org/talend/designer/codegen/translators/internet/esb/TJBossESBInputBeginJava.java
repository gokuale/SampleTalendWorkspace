package org.talend.designer.codegen.translators.internet.esb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TJBossESBInputBeginJava
{
  protected static String nl;
  public static synchronized TJBossESBInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJBossESBInputBeginJava result = new TJBossESBInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "Object obj_";
  protected final String TEXT_2 = " = null;" + NL + "if(this.valueObject == null){" + NL + "\tthrow new RuntimeException(\"The jboss esb message is null\");" + NL + "}else if(((org.jboss.soa.esb.message.Message)this.valueObject).getBody() == null){" + NL + "\tthrow new RuntimeException(\"The body of jboss esb message is null\");" + NL + "}else ";
  protected final String TEXT_3 = NL + "\t{" + NL + "        if(((org.jboss.soa.esb.message.Message)this.valueObject).getBody().get() == null){" + NL + "        \tthrow new RuntimeException(\"The default info is null in body of jboss esb message.\"); " + NL + "        }else {" + NL + "\t\t\tobj_";
  protected final String TEXT_4 = " = ((org.jboss.soa.esb.message.Message)this.valueObject).getBody().get();" + NL + "        }    \t" + NL + "    \t" + NL + "    }";
  protected final String TEXT_5 = NL + "    if(((org.jboss.soa.esb.message.Message)this.valueObject).getBody().get(";
  protected final String TEXT_6 = ") == null){" + NL + "    \tthrow new RuntimeException(\"The key \" + ";
  protected final String TEXT_7 = " + \" is not in the body of jboss esb message\"); " + NL + "    }else {" + NL + "\t\t\tobj_";
  protected final String TEXT_8 = " = ((org.jboss.soa.esb.message.Message)this.valueObject).getBody().get(";
  protected final String TEXT_9 = ");" + NL + "    }";
  protected final String TEXT_10 = NL + NL + "globalMap.put(\"";
  protected final String TEXT_11 = "_JBossESB_MESSAGE\", obj_";
  protected final String TEXT_12 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
	String messageKey = ElementParameterParser.getValue(node, "__MESSAGEKEY__");

    
/*
Mmandatory key and key not define:

Firstly, keys should not be mandatory.
If key is empty, it means that the content must be directly in the body of the message.

Next : null keys.

Solution is different in input and output component:

If the key is specified in input component, then the key must be found,  If the key is not specified in input component, then try to read the body

If the key is not specified in output component, then write directly to the body If the key is specified in output component, then : 
	If the key exists in the message, append to it
	If the key doesn't exists in the message, then create it and then append to it.
*/

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    if(messageKey==null || messageKey.length()==0){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    }else{
    stringBuffer.append(TEXT_5);
    stringBuffer.append(messageKey );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(messageKey );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(messageKey );
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
