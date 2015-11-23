package org.talend.designer.codegen.translators.mapreduce.output;

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

public class TGlobalVarLoadMrconfigJava
{
  protected static String nl;
  public static synchronized TGlobalVarLoadMrconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGlobalVarLoadMrconfigJava result = new TGlobalVarLoadMrconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t\t\tString outputPath_";
  protected final String TEXT_3 = " = genTempFolderForComponent(\"";
  protected final String TEXT_4 = "\");" + NL + "\t\t\t";
  protected final String TEXT_5 = NL + "\t\t\t\t\tMultipleOutputs.setOutputFormat(job, \"";
  protected final String TEXT_6 = "\", ";
  protected final String TEXT_7 = "StructOutputFormat.class, outputPath_";
  protected final String TEXT_8 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\tjob.setOutputFormat(";
  protected final String TEXT_10 = "StructOutputFormat.class);" + NL + "\t\t\t\t\t";
  protected final String TEXT_11 = "StructOutputFormat" + NL + "\t\t\t\t\t\t\t.setOutputPath(" + NL + "\t\t\t\t\t\t\t\t\tjob," + NL + "\t\t\t\t\t\t\t\t\tnew Path(" + NL + "\t\t\t\t\t\t\t\t\t\t\toutputPath_";
  protected final String TEXT_12 = "));" + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\tfs.delete(new Path(outputPath_";
  protected final String TEXT_14 = "),true);" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();  
    String cid = node.getUniqueName();
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if((metadatas != null) && (metadatas.size() > 0)){
        IMetadataTable metadata = metadatas.get(0);
        if(metadata != null){
        
			
		    List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
		    if(inConns != null && inConns.size() > 0){
		        
		    }else{
		        return "";
		    }
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
			IConnection inConn = inConns.get(0);
			String connName = inConn.getName();
			List<? extends IConnection> sourceNodeOutConns = inConn.getSource().getOutgoingConnections(EConnectionType.FLOW_MAIN);
            if (sourceNodeOutConns != null && sourceNodeOutConns.size() > 0) {
            	boolean hasMultipleOutputs = sourceNodeOutConns.size() > 1;
				if(hasMultipleOutputs){
				
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
				}else{
				
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
				}
			}
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
    	}
	}    
	
    return stringBuffer.toString();
  }
}
