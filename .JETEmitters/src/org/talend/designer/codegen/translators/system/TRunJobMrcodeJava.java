package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;

public class TRunJobMrcodeJava
{
  protected static String nl;
  public static synchronized TRunJobMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRunJobMrcodeJava result = new TRunJobMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "private static class DealChildJobLibrary {" + NL + "" + NL + "\tpublic static String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {" + NL + "\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\tif (isNeedAddLibsPath( crcMapPath)) {" + NL + "\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\tois.close();" + NL + "\t\t\treturn addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t} else {" + NL + "\t\t\tif (runInRuntime) {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\treturn (String) Class.forName(\"org.talend.cloud.MRHelper\")" + NL + "\t\t\t\t\t\t.getDeclaredMethod(\"replaceLibJars\", Class.class, String.class)" + NL + "\t\t\t\t\t\t.invoke(null, DealChildJobLibrary.class, originalClassPathLine);" + NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn originalClassPathLine;" + NL + "\t}" + NL + "\t" + NL + "\tprivate static boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;" + NL + "\t}" + NL + "\t" + NL + "\tprivate static String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t}" + NL + "\t\treturn line;" + NL + "\t}" + NL + "\t" + NL + "\tprivate static String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\tString jarName = entry.getValue();" + NL + "\t\tString crc = entry.getKey();" + NL + "\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t}" + NL + "\t\treturn line;" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_2 = NL;

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

// single class declaration
if (node.equals(node.getProcess().getNodesOfType("tRunJob").iterator().next())) {

    stringBuffer.append(TEXT_1);
    
}

    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
