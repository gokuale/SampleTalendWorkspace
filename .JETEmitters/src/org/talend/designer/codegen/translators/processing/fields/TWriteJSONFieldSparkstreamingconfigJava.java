package org.talend.designer.codegen.translators.processing.fields;

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
import org.talend.core.model.process.IBigDataNode;
import java.util.Map;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TWriteJSONFieldSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TWriteJSONFieldSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteJSONFieldSparkstreamingconfigJava result = new TWriteJSONFieldSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    org.apache.spark.streaming.api.java.JavaPairDStream<";
  protected final String TEXT_3 = ",";
  protected final String TEXT_4 = NL + "        ";
  protected final String TEXT_5 = "> rdd_";
  protected final String TEXT_6 = NL + "        = rdd_";
  protected final String TEXT_7 = ".groupByKey().mapToPair(new ";
  protected final String TEXT_8 = "_convertFunction(job));";
  protected final String TEXT_9 = NL + "    org.apache.spark.streaming.api.java.JavaPairDStream<";
  protected final String TEXT_10 = ",";
  protected final String TEXT_11 = NL + "        ";
  protected final String TEXT_12 = "> rdd_";
  protected final String TEXT_13 = NL + "        = rdd_";
  protected final String TEXT_14 = ".mapToPair(new ";
  protected final String TEXT_15 = "_convertFunction(job));";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

// Do not use tWriteXXXHelper due to key handling.
// Do the key handling by hand because tWriteJSON is a INode and not a BigDataNode => No KeyList.


IConnection incomingConnection = null;
if (node.getIncomingConnections() != null) {
    for (IConnection in : node.getIncomingConnections()) {
        if (in.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            incomingConnection = in;
            break;
        }
    }
}

IConnection outgoingConnection = null;
if (node.getOutgoingConnections() != null) {
    for (IConnection out : node.getOutgoingConnections()) {
        if (out.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            outgoingConnection = out;
            break;
        }
    }
}

// get the KeyList from the previous component
String outputKey = "Object";
INode previousNode = incomingConnection.getSource();
if (previousNode instanceof IBigDataNode) {
    final IBigDataNode previousBDNode = (IBigDataNode) previousNode;
    List<IMetadataColumn> keyList = previousBDNode.getKeyList().get("OUTPUT");
    if (keyList.size() > 0) {
        outputKey = "scala.Tuple" + keyList.size() + "<";
        for (IMetadataColumn keyListElement: keyList) {
            outputKey += JavaTypesManager.getTypeToGenerate(keyListElement.getTalendType(), keyListElement.isNullable()) + ",";
        }
        outputKey = outputKey.substring(0, outputKey.length() - 1) +  ">";
    }
}

List<Map<String, String>> loopTable = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
List<Map<String, String>> groupBys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "GROUPBYS");
if ((loopTable.size() > 0) && (groupBys.size() > 0)) {
    // loop element exist =>  we group by
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(outputKey);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(codeGenArgument.getRecordStructName(outgoingConnection));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(outgoingConnection.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(incomingConnection.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
} else {
    // Flat structure
    
    stringBuffer.append(TEXT_9);
    stringBuffer.append(outputKey);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(codeGenArgument.getRecordStructName(outgoingConnection));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(outgoingConnection.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(incomingConnection.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
