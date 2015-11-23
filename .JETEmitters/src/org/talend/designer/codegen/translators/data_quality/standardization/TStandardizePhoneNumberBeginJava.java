package org.talend.designer.codegen.translators.data_quality.standardization;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TStandardizePhoneNumberBeginJava
{
  protected static String nl;
  public static synchronized TStandardizePhoneNumberBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TStandardizePhoneNumberBeginJava result = new TStandardizePhoneNumberBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "com.google.i18n.phonenumbers.PhoneNumberUtil phoneUtil_";
  protected final String TEXT_2 = " = com.google.i18n.phonenumbers.PhoneNumberUtil.getInstance();" + NL + "String errorMsg_";
  protected final String TEXT_3 = ";" + NL + "com.google.i18n.phonenumbers.Phonenumber.PhoneNumber numberProto_";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL;

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
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
