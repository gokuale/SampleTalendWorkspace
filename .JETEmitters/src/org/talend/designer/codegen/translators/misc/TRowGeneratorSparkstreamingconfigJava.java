package org.talend.designer.codegen.translators.misc;

import java.util.List;
import java.util.Map;
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

public class TRowGeneratorSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TRowGeneratorSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRowGeneratorSparkstreamingconfigJava result = new TRowGeneratorSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\torg.apache.spark.streaming.api.java.JavaDStream<";
  protected final String TEXT_3 = "> ";
  protected final String TEXT_4 = "_sourceDStream = ctx.receiverStream(new CustomReceiver_";
  protected final String TEXT_5 = "(Long.valueOf(";
  protected final String TEXT_6 = ").longValue(), ";
  protected final String TEXT_7 = ", job));" + NL + "" + NL + "\torg.apache.spark.streaming.api.java.JavaPairDStream<NullWritable, ";
  protected final String TEXT_8 = "> rdd_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = "_sourceDStream.mapToPair(new ";
  protected final String TEXT_11 = "_mapToPair(job));" + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument)argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	final String repetitionInterval = ElementParameterParser.getValue(node, "__INPUT_REPETITION__");

	List<IMetadataTable> metadatas = node.getMetadataList();
	IMetadataTable metadata = null;
	if(metadatas != null && metadatas.size() > 0){
		metadata = metadatas.get(0);
	}
	List<IMetadataColumn> columns = metadata.getListColumns(); 
	String connName = null;
	List<? extends IConnection> conns = node.getOutgoingConnections();
	IConnection outConn = null;
	String connTypeName = null;
	for(IConnection conn : conns){
		if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
			outConn = conn;
			connName = conn.getName();
			connTypeName = codeGenArgument.getRecordStructName(conn);
		}
	}
	if(metadata == null || connName == null || columns.size() == 0){
		return "";
	}
	
    
// We have to transform the output of the queuestream into JavaPairDStream so that the final output of the component is KEYVALUE

    stringBuffer.append(TEXT_2);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(repetitionInterval);
    stringBuffer.append(TEXT_6);
    stringBuffer.append((("").equals(ElementParameterParser.getValue(node, "__NB_ROWS__")) ? 10 : ElementParameterParser.getValue(node, "__NB_ROWS__")));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    

    return stringBuffer.toString();
  }
}
