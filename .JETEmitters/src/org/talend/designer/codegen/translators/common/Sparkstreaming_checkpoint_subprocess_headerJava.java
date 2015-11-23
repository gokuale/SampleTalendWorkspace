package org.talend.designer.codegen.translators.common;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.IHashConfiguration;
import org.talend.core.model.process.IHashableColumn;
import org.talend.core.model.process.IHashableInputConnections;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.utils.TalendQuoteUtils;
import org.talend.designer.codegen.config.NodesSubTree;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class Sparkstreaming_checkpoint_subprocess_headerJava
{
  protected static String nl;
  public static synchronized Sparkstreaming_checkpoint_subprocess_headerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Sparkstreaming_checkpoint_subprocess_headerJava result = new Sparkstreaming_checkpoint_subprocess_headerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    public org.apache.spark.streaming.api.java.JavaStreamingContext ";
  protected final String TEXT_2 = "Process(final org.apache.spark.SparkConf sparkConfiguration) throws java.lang.Exception {" + NL + "" + NL + "        org.apache.spark.streaming.api.java.JavaStreamingContext ctx = new org.apache.spark.streaming.api.java.JavaStreamingContext(sparkConfiguration, new org.apache.spark.streaming.Duration(";
  protected final String TEXT_3 = "));" + NL + "        globalMap = new GlobalVar(ctx.sparkContext().hadoopConfiguration());" + NL + "        ctx.checkpoint(";
  protected final String TEXT_4 = ");" + NL + "        setContext(ctx.sparkContext().hadoopConfiguration(), ctx.sparkContext());" + NL + "" + NL + "        FileSystem fs = FileSystem.get(ctx.sparkContext().hadoopConfiguration());" + NL + "        final JobConf job = new JobConf(ctx.sparkContext().hadoopConfiguration());" + NL + "" + NL + "        try {";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    Vector v = (Vector) codeGenArgument.getArgument();
    NodesSubTree subTree = (NodesSubTree)v.get(1);
    INode sparkConfig = (INode)v.get(0);

    String checkpointDir = ElementParameterParser.getValue(sparkConfig, "__CHECKPOINT_DIR__");
    String batchSize = ElementParameterParser.getValue(sparkConfig, "__STREAMING_BATCH_SIZE__");

    boolean stats = codeGenArgument.isStatistics();


    stringBuffer.append(TEXT_1);
    stringBuffer.append(subTree.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(checkpointDir);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
