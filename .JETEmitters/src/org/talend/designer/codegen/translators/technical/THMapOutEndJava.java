package org.talend.designer.codegen.translators.technical;

public class THMapOutEndJava
{
  protected static String nl;
  public static synchronized THMapOutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THMapOutEndJava result = new THMapOutEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
