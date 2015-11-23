package org.talend.designer.codegen.translators.messaging.flume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.NodeUtil;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TFlumeInputSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TFlumeInputSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFlumeInputSparkstreamingcodeJava result = new TFlumeInputSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "public static class ";
  protected final String TEXT_2 = "_convertFunction implements org.apache.spark.api.java.function.Function<org.apache.spark.streaming.flume.SparkFlumeEvent, ";
  protected final String TEXT_3 = ">{" + NL + "    public ";
  protected final String TEXT_4 = " call(org.apache.spark.streaming.flume.SparkFlumeEvent event){";
  protected final String TEXT_5 = NL + "        ";
  protected final String TEXT_6 = NL + "        ";
  protected final String TEXT_7 = " result = new ";
  protected final String TEXT_8 = "();" + NL + "        result.line = new String(event.event().getBody().array(), java.nio.charset.Charset.forName(";
  protected final String TEXT_9 = "));";
  protected final String TEXT_10 = NL + "        \tjava.util.Map<CharSequence,CharSequence> headers = event.event().getHeaders();" + NL + "        \t";
  protected final String TEXT_11 = NL + "        \t\tresult.";
  protected final String TEXT_12 = " = headers.get(\"";
  protected final String TEXT_13 = "\").toString();\t" + NL + "        \t";
  protected final String TEXT_14 = NL + "        return result;" + NL + "    }" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    
IMetadataTable metadata = null;
IConnection conn = null;
List<IMetadataColumn> columns = null;
List<IMetadataTable> metadatas = node.getMetadataList();    
if((metadatas != null) && (metadatas.size() > 0)){
    metadata = metadatas.get(0);
    if(metadata != null){
        columns = metadata.getListColumns();        
    }
}

List<? extends IConnection> conns = node.getOutgoingSortedConnections();
if(conns != null && conns.size() > 0 && conns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
    conn = conns.get(0);
}   

if(columns == null || columns.isEmpty() || conn == null){
	return "";
}
String outRowStruct = codeGenArgument.getRecordStructName(conn);
String connName = conn.getName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(outRowStruct);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(outRowStruct);
    stringBuffer.append(TEXT_4);
    
        String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
        
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(outRowStruct);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(outRowStruct);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_9);
    
        List<IMetadataColumn> headerKeys = new ArrayList<IMetadataColumn>();
        for(IMetadataColumn column : columns){
        	String columnName = column.getLabel();
        	if("line".equals(columnName)){
        		continue;
        	}
        	headerKeys.add(column);
        }
        if(headerKeys.size() > 0){
        
    stringBuffer.append(TEXT_10);
    
        	for(IMetadataColumn column : headerKeys){	
        		String columnName = column.getLabel();
        		//TODO: consider other type?
        		
    stringBuffer.append(TEXT_11);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_13);
    
        	}
        }
        
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
