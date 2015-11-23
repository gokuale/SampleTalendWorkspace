package org.talend.designer.codegen.translators.machinelearning;

import java.util.ArrayList;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;
import java.util.Set;
import java.util.HashSet;

public class TMahoutClusteringMrcodeJava
{
  protected static String nl;
  public static synchronized TMahoutClusteringMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMahoutClusteringMrcodeJava result = new TMahoutClusteringMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t\t\t\t\tpublic static class ";
  protected final String TEXT_3 = "StructInputFormat extends org.talend.hadoop.mapred.lib.file.TDelimitedFileInputFormat<NullWritable, ";
  protected final String TEXT_4 = "Struct> {" + NL + "" + NL + "\t\t\t\t\t\tprivate ContextProperties context;" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t//init" + NL + "\t\t\t\t\t\tpublic void setConf(Configuration conf){" + NL + "\t\t\t\t\t\t\tcontext = new ContextProperties(conf);" + NL + "\t\t\t\t\t\t\tsetInputPath(\"";
  protected final String TEXT_5 = "\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t        \t\t" + NL + "\t\t\t\t\t\tpublic RecordReader<NullWritable, ";
  protected final String TEXT_6 = "Struct> getRecordReader(InputSplit split, JobConf job, Reporter reporter)throws IOException {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tif (reporter != null) {" + NL + "\t\t\t\t\t\t\t\treporter.setStatus(split.toString());" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\treturn new HDFSRecordReader(job, (FileSplit) split, \"\\n\".getBytes());" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tprotected static class HDFSRecordReader extends org.talend.hadoop.mapred.lib.file.TDelimitedFileRecordReader<NullWritable, ";
  protected final String TEXT_7 = "Struct> {" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tprivate ContextProperties context;" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tprotected HDFSRecordReader(JobConf job, FileSplit split, byte[] rowSeparator) throws IOException {" + NL + "" + NL + "\t\t\t\t\t\t\t\tsuper(job, split, rowSeparator);" + NL + "\t\t\t\t\t\t\t\tthis.context = new ContextProperties(job);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tprotected Text dummyValue = new Text();" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tpublic boolean next(NullWritable key, ";
  protected final String TEXT_8 = "Struct value) throws IOException {" + NL + "" + NL + "\t\t\t\t\t\t\t\tif (next(dummyValue)) {" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tString[] columns = routines.system.StringUtils.splitNotRegex(dummyValue.toString(), ";
  protected final String TEXT_9 = ");" + NL + "\t\t\t\t\t\t\t\t\tString columnValue = \"\";" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_11 = " < columns.length){" + NL + "" + NL + "\t\t\t\t\t\t\t\t\t\tcolumnValue = columns[";
  protected final String TEXT_12 = "];" + NL + "" + NL + "\t\t\t\t\t\t\t\t\t\tif(columnValue.length() > 0){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_14 = " = columnValue;" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_16 = " = columnValue.getBytes();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_18 = " = ParserUtils.parseTo_Date(columnValue, ";
  protected final String TEXT_19 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_21 = " = (ParserUtils.parseTo_Double(columnValue))" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t.";
  protected final String TEXT_22 = "Value();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_23 = NL + NL + "\t\t\t\t\t\t\t\t\t\t}else{//columnValue.length() <= 0" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_25 = " = ";
  protected final String TEXT_26 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_28 = "' in '";
  protected final String TEXT_29 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\t\t\t\t\t\t\t}//fin if(columnValue.length() > 0)" + NL + "" + NL + "\t\t\t\t\t\t\t\t\t}else{// ";
  protected final String TEXT_31 = " >= columns.length" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_36 = "' in '";
  protected final String TEXT_37 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_38 = "// fin if(defaultValue!=null && defaultValue.length()>0)" + NL + "\t\t\t\t\t\t\t\t\t}// fin if(";
  protected final String TEXT_39 = " < columns.length)" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t\t\t}// fin if (next(dummyValue))" + NL + "\t\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t\t}// fin public boolean next(NullWritable key, ";
  protected final String TEXT_41 = "Struct value) " + NL + "\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tpublic NullWritable createKey() {" + NL + "\t\t\t\t\t\t\t\treturn NullWritable.get();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tpublic ";
  protected final String TEXT_42 = "Struct createValue() {" + NL + "\t\t\t\t\t\t\t\treturn new ";
  protected final String TEXT_43 = "Struct();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\t}// fin protected static class HDFSRecordReader\t" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t}//fin public static class ";
  protected final String TEXT_44 = "StructInputFormat" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_45 = NL + NL + NL + "\t\t" + NL + NL;
  protected final String TEXT_46 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    

	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

	INode node = (INode)codeGenArgument.getArgument();

	String cid = node.getUniqueName();

	List<IMetadataTable> metadatas = node.getMetadataList();

	String outConnName = null;

	if ((metadatas!=null) && (metadatas.size() > 0)) {
	    IMetadataTable metadata = metadatas.get(0);
	    if (metadata != null) {
	    	
		///String folder = ElementParameterParser.getValue(node,"__OUTPUT_HDFS_FILENAME__");
		
		//tmp_output_path : a temp file for resaving the res of tMahoutClustering, create in mrconfig, then be read in mrcode, delete in mrjobfooter in the end.
		String tmp_output_path = cid + "_tmp_out.clusters";//"temp_out_mahoutClustering.clusters";
		
					
		//String fieldSeparator = ",";
		String fieldSeparator = ElementParameterParser.getValue(node,"__FIELDSEPARATOR__");
		String rowSeparator = "\n";
		
		final List< ? extends IConnection> conns = node.getOutgoingSortedConnections();		

		if (conns != null){
			
			if (conns.size()>0){

				IConnection conn =conns.get(0);
				outConnName = conn.getName();
				//final IMetadataTable outMetadataTable = conn.getMetadataTable();

				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			
					List<IMetadataColumn> columns = metadata.getListColumns();
					int nbColumns = columns.size();
					

    stringBuffer.append(TEXT_2);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(tmp_output_path);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_9);
    
									
									for ( int i = 0; i < nbColumns; i++ ){
										
										IMetadataColumn column = columns.get(i);

										String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
										JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
										String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
										String columnName = column.getLabel();	
										System.out.println(">>> " + columnName);
										String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
								
    stringBuffer.append(TEXT_10);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_12);
    
											if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
										
    stringBuffer.append(TEXT_13);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_14);
    
											}else{
												if(javaType == JavaTypesManager.BYTE_ARRAY){ 
												
    stringBuffer.append(TEXT_15);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_16);
    
												}else if(javaType == JavaTypesManager.DATE) { 
												
    stringBuffer.append(TEXT_17);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_19);
    
												} else { // all the other numeric types
												
    stringBuffer.append(TEXT_20);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append( (typeToGenerate).equals("Integer")?"int":typeToGenerate.toLowerCase() );
    stringBuffer.append(TEXT_22);
    
												}
											}//fin if(javaType == JavaTypesManager.STRING...
											
    stringBuffer.append(TEXT_23);
    if(defaultValue!=null && defaultValue.length()>0){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_26);
    }else{
    stringBuffer.append(TEXT_27);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_31);
    if(defaultValue!=null && defaultValue.length()>0){
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_34);
    }else{
    stringBuffer.append(TEXT_35);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_39);
    
								}//fin for ( int i = 0; i < nbColumns; i++ )
								
    stringBuffer.append(TEXT_40);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_44);
    

					

				}//fin if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))
			}//fin if (conns.size()>0)					
		}//fin if (conns != null)

	}//fin if (metadata != null)	
}//fin if ((metadatas!=null) && (metadatas.size() > 0))


    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    return stringBuffer.toString();
  }
}
