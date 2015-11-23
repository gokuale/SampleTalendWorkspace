package org.talend.designer.codegen.translators.mapreduce.input;

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

public class TMRInputMrconfigJava
{
  protected static String nl;
  public static synchronized TMRInputMrconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMRInputMrconfigJava result = new TMRInputMrconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t\tMultipleInputs.addInputPath(job, ";
  protected final String TEXT_2 = "StructInputFormat.class, ChainMapper.class, \"";
  protected final String TEXT_3 = "\");" + NL + "\t\t\t\t\tchainMapper.setCid(\"";
  protected final String TEXT_4 = "\");" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_5 = NL + "\t\t\t\t\tjob.set(\"mapreduce.input.fileinputformat.inputdir\", ";
  protected final String TEXT_6 = ");" + NL + "            \t\tjob.set(\"mapred.input.dir\", ";
  protected final String TEXT_7 = ");" + NL + "\t\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;

INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
		            //Cloudera Navigator parameters
		            
    stringBuffer.append(TEXT_5);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_7);
    
				}
			}
		}
	}
}

    return stringBuffer.toString();
  }
}
