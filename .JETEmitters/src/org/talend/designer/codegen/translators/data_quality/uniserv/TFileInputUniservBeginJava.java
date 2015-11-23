package org.talend.designer.codegen.translators.data_quality.uniserv;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.EConnectionType;
import java.util.List;
import java.util.Map;

public class TFileInputUniservBeginJava
{
  protected static String nl;
  public static synchronized TFileInputUniservBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputUniservBeginJava result = new TFileInputUniservBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\t" + NL + "" + NL + "" + NL + "java.io.Writer writer_";
  protected final String TEXT_3 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(";
  protected final String TEXT_4 = "+\"/tempInputUniserv";
  protected final String TEXT_5 = "_";
  protected final String TEXT_6 = "_";
  protected final String TEXT_7 = "_";
  protected final String TEXT_8 = "\"),\"UTF-8\"));" + NL + "new java.io.File(";
  protected final String TEXT_9 = "+\"/tempInputUniserv";
  protected final String TEXT_10 = "_";
  protected final String TEXT_11 = "_";
  protected final String TEXT_12 = "_";
  protected final String TEXT_13 = "\").deleteOnExit();" + NL + "boolean headerDone_";
  protected final String TEXT_14 = "=false;" + NL;
  protected final String TEXT_15 = NL + NL + NL + NL + NL + NL;
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String projectName = codeGenArgument.getCurrentProjectName();
String jobName = codeGenArgument.getJobName();
String jobVersion = codeGenArgument.getJobVersion();
String vcid = "";

String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
String tempDir = ElementParameterParser.getValue(node, "__TEMP_DIR__");
if(destination!=null && !"".equals(destination)){
	vcid = destination;
}
  
boolean metricJob = ("true").equals(ElementParameterParser.getValue(node,"__METRIC_JOB__"));

    stringBuffer.append(TEXT_1);
    
if(!metricJob){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(tempDir);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(vcid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(jobName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(jobVersion);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(tempDir);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(vcid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(jobName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(jobVersion);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
