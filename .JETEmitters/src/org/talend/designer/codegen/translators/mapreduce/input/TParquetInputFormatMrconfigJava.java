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

public class TParquetInputFormatMrconfigJava
{
  protected static String nl;
  public static synchronized TParquetInputFormatMrconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TParquetInputFormatMrconfigJava result = new TParquetInputFormatMrconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t\tjob.set(parquet.hadoop.ParquetInputFormat.READ_SUPPORT_CLASS, parquet.hadoop.example.GroupReadSupport.class.getCanonicalName());" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tPath parquetFilePath_";
  protected final String TEXT_2 = " = null;" + NL + "\t\t\t\t\tparquet.hadoop.metadata.ParquetMetadata readFooter_";
  protected final String TEXT_3 = " = null;" + NL + "\t\t" + NL + "\t\t\t\t\torg.apache.hadoop.fs.FileStatus[] status_";
  protected final String TEXT_4 = " = org.apache.hadoop.fs.FileSystem.get(job).listStatus(new Path(";
  protected final String TEXT_5 = "));" + NL + "\t\t\t\t\tfor (int i_";
  protected final String TEXT_6 = " = 0; i_";
  protected final String TEXT_7 = " < status_";
  protected final String TEXT_8 = ".length; i_";
  protected final String TEXT_9 = "++) {" + NL + "\t\t\t\t\t\torg.apache.hadoop.fs.FileStatus fileStatus_";
  protected final String TEXT_10 = " = status_";
  protected final String TEXT_11 = "[i_";
  protected final String TEXT_12 = "];" + NL + "\t\t\t\t\t\tif (!fileStatus_";
  protected final String TEXT_13 = ".isDir()) {" + NL + "\t\t\t\t\t\t\tparquetFilePath_";
  protected final String TEXT_14 = " = fileStatus_";
  protected final String TEXT_15 = ".getPath();" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\treadFooter_";
  protected final String TEXT_16 = " = parquet.hadoop.ParquetFileReader.readFooter(job, parquetFilePath_";
  protected final String TEXT_17 = ");" + NL + "\t\t\t\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tif(readFooter_";
  protected final String TEXT_18 = "==null) {" + NL + "\t\t\t\t\t\tthrow new Exception(\"The input path doesn't contain any valid Parquet file.\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tparquet.schema.MessageType schema_";
  protected final String TEXT_19 = " = readFooter_";
  protected final String TEXT_20 = ".getFileMetaData().getSchema();" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tJobConf mapperConf_";
  protected final String TEXT_21 = " = new JobConf(); " + NL + "\t\t\t\t\tmapperConf_";
  protected final String TEXT_22 = ".set(parquet.hadoop.example.GroupReadSupport.PARQUET_READ_SCHEMA, schema_";
  protected final String TEXT_23 = ".toString());" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\tMultipleInputs.addInputPath(job, TalendParquetInputFormat_";
  protected final String TEXT_24 = ".class, ChainMapper.class, \"";
  protected final String TEXT_25 = "\");" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tchainMapper.setCid(\"";
  protected final String TEXT_26 = "\");" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t            job.set(\"mapreduce.input.fileinputformat.inputdir\", ";
  protected final String TEXT_28 = ");" + NL + "\t\t            job.set(\"mapred.input.dir\", ";
  protected final String TEXT_29 = ");" + NL + "\t\t\t\t";

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(shortCid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(shortCid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(shortCid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
		            //Cloudera Navigator parameters
		            
    stringBuffer.append(TEXT_27);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_29);
    
				}
			}					
		}
	}		
}

    return stringBuffer.toString();
  }
}
