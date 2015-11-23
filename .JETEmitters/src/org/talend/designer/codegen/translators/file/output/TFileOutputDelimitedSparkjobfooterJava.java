package org.talend.designer.codegen.translators.file.output;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TFileOutputDelimitedSparkjobfooterJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedSparkjobfooterJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedSparkjobfooterJava result = new TFileOutputDelimitedSparkjobfooterJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t\t\t\t" + NL + "    \t\t\tPath sourceDirPath_";
  protected final String TEXT_3 = " = new Path(";
  protected final String TEXT_4 = ");";
  protected final String TEXT_5 = NL + "                    java.net.URI currentURI_";
  protected final String TEXT_6 = "_footer = FileSystem.getDefaultUri(ctx.hadoopConfiguration());" + NL + "                    FileSystem.setDefaultUri(ctx.hadoopConfiguration(), new java.net.URI(";
  protected final String TEXT_7 = "));" + NL + "                    fs = FileSystem.get(ctx.hadoopConfiguration());";
  protected final String TEXT_8 = NL + "    \t\t\tif(fs.exists(sourceDirPath_";
  protected final String TEXT_9 = ")) {" + NL + "    \t\t\t\tPath targetFilePath_";
  protected final String TEXT_10 = " = new Path(";
  protected final String TEXT_11 = ");" + NL + "    \t\t\t\t" + NL + "    \t\t\t\t";
  protected final String TEXT_12 = NL + "    \t\t\t\tif(fs.exists(targetFilePath_";
  protected final String TEXT_13 = ") && !fs.getFileStatus(targetFilePath_";
  protected final String TEXT_14 = ").isDir()) {" + NL + "    \t\t\t\t\tfs.delete(targetFilePath_";
  protected final String TEXT_15 = ",false);" + NL + "    \t\t\t\t}" + NL + "    \t\t\t\t";
  protected final String TEXT_16 = NL + "    \t\t\t\t\tint headerByteCount_";
  protected final String TEXT_17 = " = \"";
  protected final String TEXT_18 = "\".getBytes(";
  protected final String TEXT_19 = ").length + ";
  protected final String TEXT_20 = ".getBytes(";
  protected final String TEXT_21 = ").length;" + NL + "    \t\t\t\t\torg.talend.hadoop.fs.FileUtil.copyMerge(fs,sourceDirPath_";
  protected final String TEXT_22 = ",fs,targetFilePath_";
  protected final String TEXT_23 = ",";
  protected final String TEXT_24 = ", job, null, headerByteCount_";
  protected final String TEXT_25 = ");" + NL + "    \t\t\t\t";
  protected final String TEXT_26 = NL + "    \t\t\t\t\torg.apache.hadoop.fs.FileUtil.copyMerge(fs,sourceDirPath_";
  protected final String TEXT_27 = ",fs,targetFilePath_";
  protected final String TEXT_28 = ",";
  protected final String TEXT_29 = ", job, null);" + NL + "    \t\t\t\t";
  protected final String TEXT_30 = NL + "    \t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_31 = NL + "                    FileSystem.setDefaultUri(ctx.hadoopConfiguration(), currentURI_";
  protected final String TEXT_32 = "_footer);" + NL + "                    fs = FileSystem.get(ctx.hadoopConfiguration());";

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
        	boolean compress = "true".equals(ElementParameterParser.getValue(node, "__COMPRESS__"));	
			boolean merge = "true".equals(ElementParameterParser.getValue(node, "__MERGE_RESULT__"));
			String mergeTargetFilePath = ElementParameterParser.getValue(node, "__MERGE_PATH__");
			boolean removeMergeSourceDir = "true".equals(ElementParameterParser.getValue(node, "__REMOVE_FILE__"));
			boolean overwriteMergeTargetFile = "true".equals(ElementParameterParser.getValue(node, "__REPLACE_FILE__"));
	        String folder = ElementParameterParser.getValue(node, "__FOLDER__");

            String uriPrefix = "\"\"";
            // Used for Spark only for now.
            boolean useConfigurationComponent = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_STORAGE_CONFIGURATION__"));
            if(useConfigurationComponent) {
                uriPrefix = org.talend.designer.spark.generator.storage.SparkStorageUtils.getURIPrefix(node);
                folder = uriPrefix + " + " + folder;
            }
			
			String typeFile = "TEXT";
			
		    List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
		    if(inConns != null && inConns.size() > 0){
		        
		    }else{
		        return "";
		    }
		    
			if(!compress && merge && "TEXT".equals(typeFile)) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_4);
    
                if(!"\"\"".equals(uriPrefix)) {
            
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(uriPrefix);
    stringBuffer.append(TEXT_7);
            
                }
            
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(mergeTargetFilePath);
    stringBuffer.append(TEXT_11);
    if(overwriteMergeTargetFile){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    }
    				
    				boolean includeHeader = "true".equals(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
    				if(includeHeader){
    					String fieldSeparator = ElementParameterParser.getValue(node,"__FIELDSEPARATOR__");
    					String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");
    					boolean customEncoding = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_ENCODING__"));
        				String encoding = ElementParameterParser.getValue(node,"__ENCODING__");  
    					List<IMetadataColumn> columns = metadata.getListColumns();
    					String header = "";
    					int i = 1;
    					for(IMetadataColumn column : columns){
    						header += column.getLabel() + (i!=columns.size() ? fieldSeparator.substring(1,fieldSeparator.length()-1) : "");
    						i++;
    					}
    				
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(header);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(removeMergeSourceDir);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    } else {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(removeMergeSourceDir);
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    

                if(!"\"\"".equals(uriPrefix)) {
            
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
            
                }
			}
    	}
	}
	
    return stringBuffer.toString();
  }
}
