package org.talend.designer.codegen.translators.mapreduce.output;

import java.util.List;
import java.util.Map;
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

public class TFileOutputJSONMrcodeJava
{
  protected static String nl;
  public static synchronized TFileOutputJSONMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputJSONMrcodeJava result = new TFileOutputJSONMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\tpublic static class ";
  protected final String TEXT_3 = "StructOutputFormat extends FileOutputFormat<NullWritable, ";
  protected final String TEXT_4 = "> {" + NL + "" + NL + "\t\tprivate ContextProperties context;" + NL + "" + NL + "\t\tprotected static class HDFSRecordWriter implements RecordWriter<NullWritable, ";
  protected final String TEXT_5 = "> {" + NL + "\t\t\tprotected DataOutputStream out;" + NL + "\t\t\tprivate ContextProperties context;" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tprivate org.json.simple.JSONArray jsonSet_";
  protected final String TEXT_7 = ";" + NL + "\t\t\t\tprivate org.json.simple.JSONObject jsonOut_";
  protected final String TEXT_8 = ";" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\tprivate org.json.simple.JSONObject jsonRow_";
  protected final String TEXT_10 = ";" + NL + "" + NL + "\t\t\tpublic HDFSRecordWriter(DataOutputStream out, JobConf job) {" + NL + "\t\t\t\tthis.out = out;" + NL + "\t\t\t\tthis.context = new ContextProperties(job);" + NL + "\t\t\t\t";
  protected final String TEXT_11 = "\t" + NL + "\t\t\t\t\tthis.jsonSet_";
  protected final String TEXT_12 = " = new org.json.simple.JSONArray();" + NL + "\t\t\t\t\tjsonOut_";
  protected final String TEXT_13 = " = new org.json.simple.JSONObject();" + NL + "\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\t\tjsonRow_";
  protected final String TEXT_15 = " = new org.json.simple.JSONObject();" + NL + "\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprivate void writeObject(";
  protected final String TEXT_17 = " value) throws IOException {" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\tjsonRow_";
  protected final String TEXT_19 = " = new org.json.simple.JSONObject();" + NL + "\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t    \tif(value.";
  protected final String TEXT_22 = " != null){" + NL + "\t\t\t\t    ";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\tjsonRow_";
  protected final String TEXT_24 = ".put(\"";
  protected final String TEXT_25 = "\", FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_26 = ", ";
  protected final String TEXT_27 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\tjsonRow_";
  protected final String TEXT_29 = ".put(\"";
  protected final String TEXT_30 = "\", String.valueOf(value.";
  protected final String TEXT_31 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\tjsonRow_";
  protected final String TEXT_33 = ".put(\"";
  protected final String TEXT_34 = "\", value.";
  protected final String TEXT_35 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tjsonRow_";
  protected final String TEXT_37 = ".put(\"";
  protected final String TEXT_38 = "\", null);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\tjsonSet_";
  protected final String TEXT_41 = ".add(jsonRow_";
  protected final String TEXT_42 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\tout.write(jsonRow_";
  protected final String TEXT_44 = ".toString().getBytes(";
  protected final String TEXT_45 = "));" + NL + "\t\t\t\t\t\tout.write(\"\\n\".getBytes(";
  protected final String TEXT_46 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\t\tout.write(jsonRow_";
  protected final String TEXT_48 = ".toString().getBytes());" + NL + "\t\t\t\t\t\tout.write(\"\\n\".getBytes());" + NL + "\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic synchronized void write(NullWritable key, ";
  protected final String TEXT_51 = " value)" + NL + "\t\t\t\t\tthrows IOException {" + NL + "\t\t\t\tboolean nullValue = value == null;" + NL + "\t\t\t\tif (nullValue) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\twriteObject(value);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic synchronized void close(Reporter reporter) throws IOException {" + NL + "\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\tjsonOut_";
  protected final String TEXT_53 = ".put(";
  protected final String TEXT_54 = ",jsonSet_";
  protected final String TEXT_55 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\tout.write(jsonOut_";
  protected final String TEXT_57 = ".toString().getBytes(";
  protected final String TEXT_58 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_59 = "\t" + NL + "\t\t\t\t\t\tout.write(jsonOut_";
  protected final String TEXT_60 = ".toString().getBytes());" + NL + "\t\t\t\t\t";
  protected final String TEXT_61 = NL + " \t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\tout.close();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic RecordWriter<NullWritable, ";
  protected final String TEXT_63 = "> getRecordWriter(" + NL + "\t\t\t\tFileSystem ignored, JobConf job, String name, Progressable progress) throws IOException{" + NL + "\t\t\t\tthis.context = new ContextProperties(job);" + NL + "\t\t\t\tPath file = FileOutputFormat.getTaskOutputPath(job, name);" + NL + "\t\t\t\tFileSystem fs = file.getFileSystem(job);" + NL + "\t\t\t\tDataOutputStream fileOut = fs.create(file, progress);" + NL + "\t\t\t\treturn new HDFSRecordWriter(fileOut, job);" + NL + "\t\t\t}" + NL + "\t\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();  
    String cid = node.getUniqueName();
    
    String inConnName = null;
    String connTypeName = null;
	List<IMetadataColumn> inColumnsTemp = null;
	List<? extends IConnection> inConns = node.getIncomingConnections();
	if(inConns != null){
	    for(IConnection inConn : inConns){
	        if(inConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
	            inConnName = inConn.getName();
	            inColumnsTemp = inConn.getMetadataTable().getListColumns();

	            connTypeName = codeGenArgument.getRecordStructName(inConn);
	            break;
	        }
	    }
	}
	List<IMetadataColumn> inColumns = inColumnsTemp;
	
	if(inConnName == null || inColumns == null || inColumns.size() == 0){ 
		return "";
	}
	
	String datablockname = ElementParameterParser.getValue(node, "__DATABLOCKNAME__");
	String type = ElementParameterParser.getValue(node, "__TYPE__");
	boolean customEncoding = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_ENCODING__"));
    String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	boolean allInOne = "ALL_IN_ONE".equals(type);
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_5);
    if(allInOne){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    if(allInOne){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    }else{
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_17);
    if(allInOne){
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    
				for(IMetadataColumn column : inColumns){
				    String columnName = column.getLabel();
				    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				    String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				    boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
				    if(!isPrimitive){
				    
    stringBuffer.append(TEXT_21);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_22);
    
				    }
				    if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0){
					
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_27);
    
					}else if(javaType == JavaTypesManager.CHARACTER){
					
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_31);
    
					}else{
					
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_35);
    
					}
					if(!isPrimitive){
					
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_38);
    
					}
				}
				
    stringBuffer.append(TEXT_39);
    if(allInOne){
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    }else{
					if (customEncoding) { 
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_46);
     } else { 
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
     } 
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_51);
    if(allInOne){ 
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(datablockname);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
     if (customEncoding) { 
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_58);
     } else { 
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
     } 
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_63);
    return stringBuffer.toString();
  }
}
