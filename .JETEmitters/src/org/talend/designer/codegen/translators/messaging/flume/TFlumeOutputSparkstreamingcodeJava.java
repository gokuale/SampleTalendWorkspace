package org.talend.designer.codegen.translators.messaging.flume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.NodeUtil;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TFlumeOutputSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TFlumeOutputSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFlumeOutputSparkstreamingcodeJava result = new TFlumeOutputSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "public static class ";
  protected final String TEXT_2 = "_OutputFunction" + NL + "    implements org.apache.spark.api.java.function.VoidFunction<java.util.Iterator<";
  protected final String TEXT_3 = ">>{" + NL + "    " + NL + "    public ";
  protected final String TEXT_4 = "_OutputFunction(){" + NL + "    }" + NL + "" + NL + "    public void call(java.util.Iterator<";
  protected final String TEXT_5 = "> dataIterator) throws java.lang.Exception{" + NL + "    \t";
  protected final String TEXT_6 = NL + "        " + NL + "        org.apache.flume.api.RpcClient client = org.apache.flume.api.RpcClientFactory.getDefaultInstance(";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = ");" + NL + "\t\twhile(dataIterator.hasNext()){";
  protected final String TEXT_9 = NL + "            ";
  protected final String TEXT_10 = " ";
  protected final String TEXT_11 = " = dataIterator.next();";
  protected final String TEXT_12 = NL + "            \tjava.util.Map<String, String> headers = new java.util.HashMap<String, String>();" + NL + "            \t";
  protected final String TEXT_13 = NL + "            \t\theaders.put(\"";
  protected final String TEXT_14 = "\", String.valueOf(";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = "));\t" + NL + "            \t";
  protected final String TEXT_17 = NL + "            try{" + NL + "            \tclient.append(org.apache.flume.event.EventBuilder.withBody(";
  protected final String TEXT_18 = ".line, java.nio.charset.Charset.forName(";
  protected final String TEXT_19 = ")";
  protected final String TEXT_20 = ", headers";
  protected final String TEXT_21 = "));" + NL + "            }catch(org.apache.flume.EventDeliveryException e){" + NL + "            \tclient.close();" + NL + "            \tclient = org.apache.flume.api.RpcClientFactory.getDefaultInstance(";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = ");" + NL + "            }" + NL + "    \t}" + NL + "    \tclient.close();" + NL + "    }" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    
IMetadataTable metadata = null;
IConnection conn = null;
List<IMetadataColumn> columns = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if((metadatas!=null) && (metadatas.size() > 0)){
    metadata = metadatas.get(0);
    if(metadata != null){
		columns = metadata.getListColumns();		
	}
}
List<? extends IConnection> conns = node.getIncomingConnections();
if(conns != null && conns.size() > 0 && conns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
    conn = conns.get(0);
}

if(columns == null || columns.isEmpty() || conn == null){
	return "";
}

String inRowStruct = codeGenArgument.getRecordStructName(conn);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_5);
    
        String host = ElementParameterParser.getValue(node, "__HOST__");
        String port = ElementParameterParser.getValue(node, "__PORT__");
        String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
        
    stringBuffer.append(TEXT_6);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_11);
    
        	List<IMetadataColumn> headerKeys = new ArrayList<IMetadataColumn>();
            for(IMetadataColumn column : columns){
            	String columnName = column.getLabel();
            	if("line".equals(columnName)){
            		continue;
            	}
            	headerKeys.add(column);
            }
            if(headerKeys.size() > 0){
            
    stringBuffer.append(TEXT_12);
    
            	for(IMetadataColumn column : headerKeys){
            		String columnName = column.getLabel();
            		
    stringBuffer.append(TEXT_13);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_16);
    
            	}	
            	
    	
            }
            
    stringBuffer.append(TEXT_17);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_19);
    if(headerKeys.size() > 0){
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_23);
    return stringBuffer.toString();
  }
}
