package org.talend.designer.codegen.translators.data_quality.standardization;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSynonymOutputBeginJava
{
  protected static String nl;
  public static synchronized TSynonymOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSynonymOutputBeginJava result = new TSynonymOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "org.talend.dataquality.standardization.index.SynonymIndexBuilder builder_";
  protected final String TEXT_2 = " = new org.talend.dataquality.standardization.index.SynonymIndexBuilder();" + NL + "org.talend.dataquality.standardization.index.Error error_";
  protected final String TEXT_3 = " = builder_";
  protected final String TEXT_4 = ".getError();" + NL;
  protected final String TEXT_5 = NL + "\tbuilder_";
  protected final String TEXT_6 = ".deleteIndexFromFS(";
  protected final String TEXT_7 = ");" + NL + "    if (!error_";
  protected final String TEXT_8 = ".getStatus()){" + NL + "        throw new Exception(error_";
  protected final String TEXT_9 = ".getMessage());" + NL + "    }    ";
  protected final String TEXT_10 = NL + "\tbuilder_";
  protected final String TEXT_11 = ".initIndexInFS(";
  protected final String TEXT_12 = ");" + NL + "\tbuilder_";
  protected final String TEXT_13 = ".setSynonymSeparator(";
  protected final String TEXT_14 = ");" + NL + "\tString status_";
  protected final String TEXT_15 = ";";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();	
String path = ElementParameterParser.getValue(node, "__FILE_PATH__"); 
String separator = ElementParameterParser.getValue(node, "__SEPARATOR__"); 
String operation = ElementParameterParser.getValue(node, "__OPERATION__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    if ("INIT".equals(operation)) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
} 

if (!"DELETE_INDEX".equals(operation)) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
