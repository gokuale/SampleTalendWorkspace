package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMCloseMainJava
{
  protected static String nl;
  public static synchronized TMDMCloseMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMCloseMainJava result = new TMDMCloseMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t";
  protected final String TEXT_3 = NL + "\torg.talend.mdm.webservice.TMDMService_PortType tmdmWS_";
  protected final String TEXT_4 = " = (org.talend.mdm.webservice.TMDMService_PortType)globalMap.get(\"";
  protected final String TEXT_5 = "\");" + NL + "\tif(tmdmWS_";
  protected final String TEXT_6 = " != null)" + NL + "\t{" + NL + "\t\ttmdmWS_";
  protected final String TEXT_7 = ".logout(new org.talend.mdm.webservice.WSLogout());" + NL + "\t}";
  protected final String TEXT_8 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();

    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_2);
    String conn = "TMDMService_" + connection;
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
