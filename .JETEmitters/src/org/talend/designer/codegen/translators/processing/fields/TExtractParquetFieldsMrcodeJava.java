package org.talend.designer.codegen.translators.processing.fields;

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

public class TExtractParquetFieldsMrcodeJava
{
  protected static String nl;
  public static synchronized TExtractParquetFieldsMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractParquetFieldsMrcodeJava result = new TExtractParquetFieldsMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t\tpublic static class TalendParquetInputMapper_";
  protected final String TEXT_2 = " extends MapReduceBase implements Mapper<LongWritable, Object, NullWritable, ";
  protected final String TEXT_3 = "Struct> {" + NL + "" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_4 = "Struct ";
  protected final String TEXT_5 = " = null;" + NL + "" + NL + "\t\t\t\t\t\tpublic void map(LongWritable key, Object objectContainer," + NL + "\t\t\t\t\t\t\t\torg.apache.hadoop.mapred.OutputCollector<NullWritable, ";
  protected final String TEXT_6 = "Struct> output, org.apache.hadoop.mapred.Reporter reporter)" + NL + "\t\t\t\t\t\t\t\tthrows IOException {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tparquet.hadoop.mapred.Container<parquet.example.data.Group> container = (parquet.hadoop.mapred.Container<parquet.example.data.Group>) objectContainer;" + NL + "\t\t\t\t\t\t\tparquet.example.data.Group value = container.get();" + NL + "\t\t\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = " = value.getInteger(\"";
  protected final String TEXT_10 = "\", 0);" + NL + "\t\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " = BigDataParserUtils.parseTo_Byte(value.getInteger(\"";
  protected final String TEXT_14 = "\", 0));" + NL + "\t\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = " = value.getDouble(\"";
  protected final String TEXT_18 = "\", 0);" + NL + "\t\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = " = value.getLong(\"";
  protected final String TEXT_22 = "\", 0);" + NL + "\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = " = value.getFloat(\"";
  protected final String TEXT_26 = "\", 0);" + NL + "\t\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = " = new Integer(value.getInteger(\"";
  protected final String TEXT_30 = "\", 0)).shortValue();" + NL + "\t\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = " = value.getBoolean(\"";
  protected final String TEXT_34 = "\", 0);" + NL + "\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = " = value.getBinary(\"";
  protected final String TEXT_38 = "\", 0).getBytes();" + NL + "\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = " = BigDataParserUtils.parseTo_Date(value.getString(\"";
  protected final String TEXT_42 = "\", 0),";
  protected final String TEXT_43 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = " = BigDataParserUtils.parseTo_";
  protected final String TEXT_47 = "(value.getString(\"";
  protected final String TEXT_48 = "\", 0));" + NL + "\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\t\toutput.collect(NullWritable.get(), ";
  protected final String TEXT_50 = ");" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\tpublic void configure(JobConf conf) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_51 = " = new ";
  protected final String TEXT_52 = "Struct();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t\tpublic void close() throws IOException {\t\t\t\t\t" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";

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
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_6);
    
							for(int i=0; i<nbColumns; i++) {
								IMetadataColumn column = columns.get(i); 
								String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
								String columnName = column.getLabel();
								if(javaType == JavaTypesManager.INTEGER) {
					
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_10);
    
								} else if(javaType == JavaTypesManager.BYTE) {
					
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_14);
    
								} else if(javaType == JavaTypesManager.DOUBLE) {
					
    stringBuffer.append(TEXT_15);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_18);
    
								} else if(javaType == JavaTypesManager.LONG) {
					
    stringBuffer.append(TEXT_19);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_22);
    
								} else if(javaType == JavaTypesManager.FLOAT) {
					
    stringBuffer.append(TEXT_23);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_26);
    
								} else if(javaType == JavaTypesManager.SHORT) {
					
    stringBuffer.append(TEXT_27);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_30);
    
								} else if(javaType == JavaTypesManager.BOOLEAN) {
					
    stringBuffer.append(TEXT_31);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_34);
    
								} else if(javaType == JavaTypesManager.BYTE_ARRAY) {
					
    stringBuffer.append(TEXT_35);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_38);
    
								} else if(javaType == JavaTypesManager.DATE) {
					
    stringBuffer.append(TEXT_39);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_43);
    
								} else {
					
    stringBuffer.append(TEXT_44);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_48);
    
								}
							}
					
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_52);
    
				}
			}
		}
	}		
}

    return stringBuffer.toString();
  }
}
