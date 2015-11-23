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
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TExtractParquetFieldsMrconfigJava
{
  protected static String nl;
  public static synchronized TExtractParquetFieldsMrconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractParquetFieldsMrconfigJava result = new TExtractParquetFieldsMrconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t\tchainMapper.addMapper(job, (Class<? extends Mapper<LongWritable, Object, NullWritable, ";
  protected final String TEXT_2 = "Struct>>) TalendParquetInputMapper_";
  protected final String TEXT_3 = ".class, LongWritable.class, Text.class, NullWritable.class, ";
  protected final String TEXT_4 = "Struct.class, true, mapperConf_";
  protected final String TEXT_5 = ");" + NL + "\t\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;

INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
String shortCid = cid.replaceAll("_Out", "").replaceAll("_In", "");

List<IMetadataTable> metadatas = node.getMetadataList();

if(metadatas!=null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    if(metadata != null){
    
    	String folder = ElementParameterParser.getValue(node,"__FILENAME__");
    	
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		if(conns != null){
		
			if(conns.size()>0){
		
				IConnection conn =conns.get(0);
				String connName = conn.getName();
		
				if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
				
    stringBuffer.append(TEXT_1);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(shortCid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(shortCid);
    stringBuffer.append(TEXT_5);
    
				}
			}					
		}
	}		
}

    return stringBuffer.toString();
  }
}
