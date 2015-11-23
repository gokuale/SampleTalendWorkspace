package org.talend.designer.codegen.translators.processing;

public class TReplicateSparkcodeJava
{
  protected static String nl;
  public static synchronized TReplicateSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TReplicateSparkcodeJava result = new TReplicateSparkcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    return stringBuffer.toString();
  }
}
