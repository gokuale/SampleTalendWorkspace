package org.talend.designer.codegen.translators.processing;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TUniteSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TUniteSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniteSparkstreamingconfigJava result = new TUniteSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\tif (true) {" + NL + "\t\tthrow new java.lang.Exception(\"The component ";
  protected final String TEXT_4 = " should have at least 2 input connections.\");" + NL + "\t}";
  protected final String TEXT_5 = NL + "\tif (true) {" + NL + "\t\tthrow new java.lang.Exception(\"The component ";
  protected final String TEXT_6 = " should have only 1 output connection.\");" + NL + "\t}";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = " rdd_";
  protected final String TEXT_10 = " = null;" + NL;
  protected final String TEXT_11 = "\t\t" + NL + "\t\t\trdd_";
  protected final String TEXT_12 = " = rdd_";
  protected final String TEXT_13 = ";";
  protected final String TEXT_14 = NL + "\t\t\trdd_";
  protected final String TEXT_15 = " = rdd_";
  protected final String TEXT_16 = ".union(rdd_";
  protected final String TEXT_17 = ");\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final IBigDataNode node = (IBigDataNode)codeGenArgument.getArgument();
final String cid = node.getUniqueName();

List<? extends IConnection> incomingConnections = node.getIncomingConnections();
if (incomingConnections == null || incomingConnections.size() < 2) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
}

List<? extends IConnection> outgoingConnections = node.getOutgoingConnections();
if (outgoingConnections == null || outgoingConnections.size() != 1) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
}
String outConnectionName = outgoingConnections.get(0).getName();
String outStruct = codeGenArgument.getRecordStructName(outgoingConnections.get(0));

org.talend.designer.spark.generator.SparkFunction sparkFunction = null;
String requiredInputType = node.getRequiredInputType();
String requiredOutputType = node.getRequiredOutputType();
String incomingType = node.getIncomingType();
String outgoingType = node.getOutgoingType();
boolean inputIsPair = requiredInputType != null ? "KEYVALUE".equals(requiredInputType) : "KEYVALUE".equals(incomingType);
String type = requiredOutputType == null ? outgoingType : requiredOutputType;

if("KEYVALUE".equals(type)) {
    sparkFunction = new org.talend.designer.spark.generator.MapToPairFunction(inputIsPair);
} else if("VALUE".equals(type)) {
    sparkFunction = new org.talend.designer.spark.generator.MapFunction(inputIsPair);
}

boolean isNodeInBatchMode = org.talend.designer.common.tmap.LookupUtil.isNodeInBatchMode(node);
if("SPARKSTREAMING".equals(node.getComponent().getType()) && !isNodeInBatchMode) {
    sparkFunction.setStreaming(true);
}

    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(sparkFunction.getConfigReturnedType(outStruct));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(outConnectionName);
    stringBuffer.append(TEXT_10);
    
if (incomingConnections != null) {
	boolean isFirstIncomingConnection = true;
	for (IConnection incomingConnection : incomingConnections) {
	   String incomingConnectionName = incomingConnection.getName();

		if(isFirstIncomingConnection){
			isFirstIncomingConnection = false;

    stringBuffer.append(TEXT_11);
    stringBuffer.append(outConnectionName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(incomingConnectionName);
    stringBuffer.append(TEXT_13);
     
		} else{

    stringBuffer.append(TEXT_14);
    stringBuffer.append(outConnectionName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(outConnectionName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(incomingConnectionName);
    stringBuffer.append(TEXT_17);
    
    	}
    }
}

    return stringBuffer.toString();
  }
}
