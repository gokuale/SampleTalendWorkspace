package org.talend.designer.codegen.translators.mapreduce.input;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TInputFormatAvroSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TInputFormatAvroSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TInputFormatAvroSparkstreamingconfigJava result = new TInputFormatAvroSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            org.apache.spark.api.java.JavaPairRDD<NullWritable, ";
  protected final String TEXT_2 = "> rdd_";
  protected final String TEXT_3 = " =" + NL + "                    ctx.sparkContext().hadoopRDD(" + NL + "                            job,";
  protected final String TEXT_4 = NL + "                            ";
  protected final String TEXT_5 = "StructInputFormat.class," + NL + "                            NullWritable.class,";
  protected final String TEXT_6 = NL + "                            ";
  protected final String TEXT_7 = ".class);";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

    
List<IMetadataTable> metadatas = node.getMetadataList();

if (metadatas != null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    if(metadata != null){
        List< ? extends IConnection> connections = node.getOutgoingConnections();
        if ((connections != null) && (connections.size() > 0)) {
            IConnection connection = connections.get(0);
            String connName = connection.getName();
            String recordStructName = codeGenArgument.getRecordStructName(connection);
            
    stringBuffer.append(TEXT_1);
    stringBuffer.append(recordStructName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(recordStructName);
    stringBuffer.append(TEXT_7);
    
        }
    }
}

    return stringBuffer.toString();
  }
}
