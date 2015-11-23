package org.talend.designer.codegen.translators.data_quality.address.melissadata;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMelissaDataAddressBeginJava
{
  protected static String nl;
  public static synchronized TMelissaDataAddressBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMelissaDataAddressBeginJava result = new TMelissaDataAddressBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t// start part of your Java code" + NL + "\tString ResultsString_";
  protected final String TEXT_2 = ";" + NL + "\tcom.melissadata.mdAddr ao_";
  protected final String TEXT_3 = " = new com.melissadata.mdAddr();" + NL + "" + NL + "\t//test licensce" + NL + "\tboolean test_";
  protected final String TEXT_4 = " = ao_";
  protected final String TEXT_5 = ".SetLicenseString(";
  protected final String TEXT_6 = ");" + NL + "\tString build_";
  protected final String TEXT_7 = " = ao_";
  protected final String TEXT_8 = ".GetBuildNumber();" + NL + "" + NL + "\t//set path to files" + NL + "\tao_";
  protected final String TEXT_9 = ".SetPathToUSFiles(";
  protected final String TEXT_10 = ");" + NL + "\tao_";
  protected final String TEXT_11 = ".SetPathToCanadaFiles(";
  protected final String TEXT_12 = ");" + NL + "\t//Initialize Data Files" + NL + "\tao_";
  protected final String TEXT_13 = ".InitializeDataFiles();" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String path = ElementParameterParser.getValue(node, "__PATH__");
	String license = ElementParameterParser.getValue(node, "__LICENSE__");
	String dataFileDir = ElementParameterParser.getValue(node, "__DATAFILE_DIR__");
	

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( license );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append( dataFileDir );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append( dataFileDir );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
