package org.talend.designer.codegen.translators.data_quality.address;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TAddressRowCloudEndJava
{
  protected static String nl;
  public static synchronized TAddressRowCloudEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAddressRowCloudEndJava result = new TAddressRowCloudEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "try {" + NL + "    // stop accepting new queries into the thread pool and wait until" + NL + "    // all the tasks are terminated." + NL + "    engine_";
  protected final String TEXT_2 = ".shutdown();" + NL + "} catch (org.talend.dataquality.address.api.AddressApiException e) {" + NL + "    System.err.println(e.getMessage());" + NL + "    e.printStackTrace();" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
