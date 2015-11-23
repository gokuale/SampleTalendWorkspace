package org.talend.designer.codegen.translators.internet.esb;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPetalsOutputBeginJava
{
  protected static String nl;
  public static synchronized TPetalsOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPetalsOutputBeginJava result = new TPetalsOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "" + NL + "// Create (or overwrite) the output document" + NL + "petalsOutMessage = null;" + NL + "javax.xml.parsers.DocumentBuilderFactory factory_";
  protected final String TEXT_3 = " = javax.xml.parsers.DocumentBuilderFactory.newInstance();" + NL + "factory_";
  protected final String TEXT_4 = ".setNamespaceAware( true );" + NL + "javax.xml.parsers.DocumentBuilder builder_";
  protected final String TEXT_5 = " = factory_";
  protected final String TEXT_6 = ".newDocumentBuilder();" + NL + "petalsOutMessage = builder_";
  protected final String TEXT_7 = ".newDocument();" + NL + "" + NL + "// Create the header" + NL + "petalsOutMessage.setXmlVersion( \"1.0\" );" + NL + "petalsOutMessage.setXmlStandalone( true );" + NL + "" + NL + "org.w3c.dom.Element rootElt_";
  protected final String TEXT_8 = " = petalsOutMessage.createElement( jobName + \"OutputBean\" );" + NL + "petalsOutMessage.appendChild( rootElt_";
  protected final String TEXT_9 = " );" + NL + "" + NL + "final String petalsNs = \"http://petals.ow2.org/talend/\";" + NL + "rootElt_";
  protected final String TEXT_10 = ".setAttribute( \"xmlns\", petalsNs );" + NL + "rootElt_";
  protected final String TEXT_11 = ".setAttribute( \"xmlns:xs\", \"http://www.w3.org/2001/XMLSchema\" );" + NL + "rootElt_";
  protected final String TEXT_12 = ".setAttribute( \"xmlns:xsi\", \"http://www.w3.org/2001/XMLSchema-instance\" );" + NL + "" + NL + "org.w3c.dom.Element rowElt_";
  protected final String TEXT_13 = " = null;" + NL + "org.w3c.dom.Element element_";
  protected final String TEXT_14 = " = null;";
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();	

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
