package org.talend.designer.codegen.translators.mapreduce.input;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TAvroInputMrconfigJava
{
  protected static String nl;
  public static synchronized TAvroInputMrconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAvroInputMrconfigJava result = new TAvroInputMrconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "MultipleInputs.addInputPath(job, ";
  protected final String TEXT_2 = "InputFormat.class," + NL + "        ChainMapper.class," + NL + "        \"";
  protected final String TEXT_3 = "\");" + NL + "chainMapper.setCid(\"";
  protected final String TEXT_4 = "\");";
  protected final String TEXT_5 = NL + "    chainMapper.addMapper(job, ";
  protected final String TEXT_6 = "_InputMapper.class," + NL + "        NullWritable.class, ";
  protected final String TEXT_7 = "TemporaryStruct.class," + NL + "        NullWritable.class, ";
  protected final String TEXT_8 = "Struct.class," + NL + "        true, new JobConf(false));" + NL + "" + NL + "    MultipleOutputs.setWorkDir(job," + NL + "            genTempFolderForComponent(\"";
  protected final String TEXT_9 = "\"));" + NL + "    MultipleOutputs.setKeyValue(job, \"";
  protected final String TEXT_10 = "\"," + NL + "            NullWritable.class, ";
  protected final String TEXT_11 = "Struct.class);" + NL;
  protected final String TEXT_12 = NL + "job.set(\"mapreduce.input.fileinputformat.inputdir\", ";
  protected final String TEXT_13 = ");" + NL + "job.set(\"mapred.input.dir\", ";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

// Fail fast when no output connections exist.
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
if (conns == null || conns.size() == 0)
    return "";

// Parameters
String folder = ElementParameterParser.getValue(node,"__FILENAME__");
boolean dieOnError = "true".equals(ElementParameterParser.getValue(node,
        "__DIE_ON_ERROR__"));

// Get the output connections.
List< ? extends IConnection> rejConns = node.getOutgoingConnections("REJECT");
List< ? extends IConnection> mainConns = node.getOutgoingConnections("FLOW");
IConnection mainConn = mainConns == null || mainConns.size() == 0
        ? null : mainConns.get(0);
IConnection rejConn = rejConns == null || rejConns.size() == 0
        ? null : rejConns.get(0);

// Fail fast on bad main connection style.
if (mainConn != null && !mainConn.getLineStyle().hasConnectionCategory(
        IConnectionCategory.DATA)) {
    return "";
}

// Fail fast on no connections.
if (mainConn == null && rejConn == null) {
    return "";
}


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    

// If there is a main and a reject connection, the input format will wrap the
// rows into a generic object, and the mapper will separate them into multiple
// outputs.
if (mainConn != null && rejConn != null) {
    
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(mainConn.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(mainConn.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(rejConn.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(rejConn.getName());
    stringBuffer.append(TEXT_11);
    
}
//Cloudera Navigator parameters

    stringBuffer.append(TEXT_12);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
