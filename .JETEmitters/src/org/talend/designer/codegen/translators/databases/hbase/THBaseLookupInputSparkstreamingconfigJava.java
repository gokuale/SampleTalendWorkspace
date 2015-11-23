package org.talend.designer.codegen.translators.databases.hbase;

public class THBaseLookupInputSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized THBaseLookupInputSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseLookupInputSparkstreamingconfigJava result = new THBaseLookupInputSparkstreamingconfigJava();
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
