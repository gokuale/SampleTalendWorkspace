package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;

public class TRunJobSparkcodeJava
{
  protected static String nl;
  public static synchronized TRunJobSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRunJobSparkcodeJava result = new TRunJobSparkcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "class DealChildJobLibrary_";
  protected final String TEXT_2 = " {" + NL + "" + NL + "\tpublic String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {" + NL + "\t\tString classPathLine = \"\";" + NL + "\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\tif (isNeedAddLibsPath( crcMapPath)) {" + NL + "\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\tois.close();" + NL + "\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t} else {" + NL + "\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t}" + NL + "\t\treturn classPathLine;" + NL + "\t}" + NL + "\t" + NL + "\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;" + NL + "\t}" + NL + "\t" + NL + "\t" + NL + "\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t}" + NL + "\t\treturn line;" + NL + "\t}" + NL + "\t" + NL + "\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\tString jarName = entry.getValue();" + NL + "\t\tString crc = entry.getKey();" + NL + "\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t}" + NL + "\t\treturn line;" + NL + "\t}" + NL + "\t" + NL + "}" + NL + "" + NL + "DealChildJobLibrary_";
  protected final String TEXT_3 = " dealChildJobLibrary_";
  protected final String TEXT_4 = " = new DealChildJobLibrary_";
  protected final String TEXT_5 = "();";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean useDynamicJob = ("true").equals(ElementParameterParser.getValue(node, "__USE_DYNAMIC_JOB__"));

String process = ElementParameterParser.getValue(node,"__PROCESS_TYPE_PROCESS__");
String context = "";

if (useDynamicJob) {
	context = ElementParameterParser.getValue(node,"__CONTEXT_NAME__");
} else {
	context = ElementParameterParser.getValue(node,"__PROCESS_TYPE_CONTEXT__");
}

String[] commandLine = new String[] {"<command>"};


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
