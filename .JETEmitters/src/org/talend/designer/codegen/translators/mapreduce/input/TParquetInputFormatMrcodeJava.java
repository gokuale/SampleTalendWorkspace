package org.talend.designer.codegen.translators.mapreduce.input;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TParquetInputFormatMrcodeJava
{
  protected static String nl;
  public static synchronized TParquetInputFormatMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TParquetInputFormatMrcodeJava result = new TParquetInputFormatMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t\tpublic static class TalendParquetInputFormat_";
  protected final String TEXT_2 = " extends parquet.hadoop.mapred.DeprecatedParquetInputFormat<parquet.example.data.Group> {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tprivate ContextProperties context;" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tpublic InputSplit[] getSplits(JobConf job, int numSplits) throws IOException {" + NL + "\t\t\t\t\t\t\t\tcontext = new ContextProperties(job);" + NL + "\t\t\t\t\t\t\t\tjob.set(\"mapred.input.dir\", ";
  protected final String TEXT_3 = ");" + NL + "\t\t\t\t\t\t\t\treturn super.getSplits(job, numSplits);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;

INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
String shortCid = cid.replaceAll("_Out", "").replaceAll("_In", "");

List<IMetadataTable> metadatas = node.getMetadataList();

if ((metadatas!=null) && (metadatas.size() > 0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata != null) {
    	String folder = ElementParameterParser.getValue(node,"__FILENAME__");
		
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		if (conns != null){
		
			if (conns.size()>0){
		
				IConnection conn =conns.get(0);
				String connName = conn.getName();
		
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					List<IMetadataColumn> columns = metadata.getListColumns();
					int nbColumns = columns.size();
					
					
    stringBuffer.append(TEXT_1);
    stringBuffer.append(shortCid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_3);
    
				}
			}
		}
	}		
}

    return stringBuffer.toString();
  }
}
