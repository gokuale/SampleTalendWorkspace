package org.talend.designer.codegen.translators.processing;

public class TCacheInSparkcodeJava
{
  protected static String nl;
  public static synchronized TCacheInSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCacheInSparkcodeJava result = new TCacheInSparkcodeJava();
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
