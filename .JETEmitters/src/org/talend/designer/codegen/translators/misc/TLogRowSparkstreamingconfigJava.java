package org.talend.designer.codegen.translators.misc;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TLogRowSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TLogRowSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLogRowSparkstreamingconfigJava result = new TLogRowSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\tString outputPath_";
  protected final String TEXT_3 = " = genTempFolderForComponent(\"";
  protected final String TEXT_4 = "\");" + NL;
  protected final String TEXT_5 = NL + "    \toutputPath_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = " + ";
  protected final String TEXT_8 = " + \"/\" + pid + \"/";
  protected final String TEXT_9 = "\";";
  protected final String TEXT_10 = NL + "java.net.URI currentURI_";
  protected final String TEXT_11 = "_config = FileSystem.getDefaultUri(ctx.hadoopConfiguration());" + NL + "FileSystem.setDefaultUri(ctx.hadoopConfiguration(), new java.net.URI(";
  protected final String TEXT_12 = "));" + NL + "fs = FileSystem.get(ctx.hadoopConfiguration());";
  protected final String TEXT_13 = NL + "\tlog.info(\"using \" + outputPath_";
  protected final String TEXT_14 = " + \" as temp folder\");" + NL + "\tif (fs.exists(new Path(outputPath_";
  protected final String TEXT_15 = "))){" + NL + "\t\tfs.delete(new Path(outputPath_";
  protected final String TEXT_16 = "), true);" + NL + "\t}" + NL + "" + NL + "\trdd_";
  protected final String TEXT_17 = ".saveAsHadoopFile(outputPath_";
  protected final String TEXT_18 = ", NullWritable.class, ";
  protected final String TEXT_19 = ".class, ";
  protected final String TEXT_20 = "StructOutputFormat.class);" + NL;
  protected final String TEXT_21 = NL + "\tFileSystem.setDefaultUri(ctx.hadoopConfiguration(), currentURI_";
  protected final String TEXT_22 = "_config);" + NL + "\tfs = FileSystem.get(ctx.hadoopConfiguration());";
  protected final String TEXT_23 = NL + "\trdd_";
  protected final String TEXT_24 = ".foreach(new ";
  protected final String TEXT_25 = "_ForeachRDD(job));";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
if(org.talend.designer.common.tmap.LookupUtil.isNodeInBatchMode((INode) ((BigDataCodeGeneratorArgument) argument).getArgument())) {

    stringBuffer.append(TEXT_1);
    
	BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

   	List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
	if(inConns != null && inConns.size() > 0) {
	} else {
		return "";
	}

	IConnection inConn = inConns.get(0);
	String inConnName = inConn.getName();
    String inConnTypeName = codeGenArgument.getRecordStructName(inConn);

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
	String uriPrefix = "\"\"";
	String tempFolder = "\"\"";
	// Used for Spark only for now.
	boolean useConfigurationComponent = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_STORAGE_CONFIGURATION__"));
	if(useConfigurationComponent) {
	    uriPrefix = org.talend.designer.spark.generator.storage.SparkStorageUtils.getURIPrefix(node);
	    tempFolder = org.talend.designer.spark.generator.storage.SparkStorageUtils.getTempFolder(node);

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(uriPrefix);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(tempFolder);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
	}

	if(!"\"\"".equals(uriPrefix)) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(uriPrefix);
    stringBuffer.append(TEXT_12);
    
	}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
	if(!"\"\"".equals(uriPrefix)) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
	}

    
} else {
	// We do a forEachRDD on the DStream and collect values then print them

	BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

   	List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
	if(inConns != null && inConns.size() > 0) {
	} else {
		return "";
	}

	IConnection inConn = inConns.get(0);
	String inConnName = inConn.getName();
    String inConnTypeName = codeGenArgument.getRecordStructName(inConn);


    stringBuffer.append(TEXT_23);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
} // end else

    return stringBuffer.toString();
  }
}
