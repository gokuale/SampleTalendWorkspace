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

public class TS3InputMrcodeJava
{
  protected static String nl;
  public static synchronized TS3InputMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TS3InputMrcodeJava result = new TS3InputMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t\t\t\t\tpublic static class ";
  protected final String TEXT_2 = "StructInputFormat extends SequenceFileInputFormat<NullWritable, ";
  protected final String TEXT_3 = "Struct> {" + NL + "                        private ContextProperties context;" + NL + "" + NL + "" + NL + "" + NL + "\t\t\t\t\t\tpublic InputSplit[] getSplits(JobConf job, int numSplits) throws IOException {" + NL + "\t\t\t\t\t\t\tcontext = new ContextProperties(job);" + NL + "" + NL + "\t\t\t\t\t\t\t// Get the password under the variable decryptedPassword" + NL + "\t                        ";
  protected final String TEXT_4 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_5 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = "; ";
  protected final String TEXT_10 = NL + NL + "\t\t\t\t\t\t\tjob.set(\"mapred.input.dir\", \"s3n://\" + ";
  protected final String TEXT_11 = " +\":\" + decryptedPassword_";
  protected final String TEXT_12 = " + \"@\" + ";
  protected final String TEXT_13 = ");" + NL + "\t\t\t\t\t\t\treturn super.getSplits(job, numSplits);" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\tpublic RecordReader<NullWritable, ";
  protected final String TEXT_14 = "Struct> getRecordReader(" + NL + "\t\t\t\t\t\t\t\tInputSplit split, JobConf job, Reporter reporter)" + NL + "\t\t\t\t\t\t\t\tthrows IOException {" + NL + "\t\t\t\t\t\t\treporter.setStatus(split.toString());" + NL + "\t\t\t\t\t\t\treturn new S3SequenceFileRecordReader(job, (FileSplit) split);" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\tprotected static class S3SequenceFileRecordReader implements" + NL + "\t\t\t\t\t\t\tRecordReader<NullWritable, ";
  protected final String TEXT_15 = "Struct> {" + NL + "" + NL + "\t\t\t\t\t\t \tprivate SequenceFile.Reader in;" + NL + "                         \tprivate long start;" + NL + "                         \tprivate long end;" + NL + "                         \tprivate boolean more = true;" + NL + "                         \tprotected Configuration conf;" + NL + "" + NL + "                         \tprivate ContextProperties context;" + NL + "" + NL + "\t\t\t\t\t\t\tprotected S3SequenceFileRecordReader(JobConf conf, FileSplit split)" + NL + "\t\t\t\t\t\t\t\t\tthrows IOException {" + NL + "" + NL + "\t\t\t\t\t\t\t\tthis.context = new ContextProperties(conf);" + NL + "" + NL + "                            \tPath path = split.getPath();" + NL + "                                FileSystem fs = path.getFileSystem(conf);" + NL + "                                this.in = new SequenceFile.Reader(fs, path, conf);" + NL + "                                this.end = split.getStart() + split.getLength();" + NL + "                                this.conf = conf;" + NL + "" + NL + "                                if (split.getStart() > in.getPosition())" + NL + "                              \t\tin.sync(split.getStart());//sync to start" + NL + "" + NL + "                                this.start = in.getPosition();" + NL + "                                more = start < end;" + NL + "\t\t\t\t\t\t \t}" + NL + "" + NL + "\t\t\t\t\t\t\tpublic synchronized boolean next(NullWritable key, ";
  protected final String TEXT_16 = "Struct value) throws IOException {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_17 = NL + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_18 = " seqKey_";
  protected final String TEXT_19 = " = (";
  protected final String TEXT_20 = ")ReflectionUtils.newInstance(in.getKeyClass(), conf);" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_21 = " seqValue_";
  protected final String TEXT_22 = " = (";
  protected final String TEXT_23 = ")ReflectionUtils.newInstance(in.getValueClass(), conf);" + NL + "" + NL + "                            \tif (!more) return false;" + NL + "                                long pos = in.getPosition();" + NL + "                                boolean remaining = in.next(seqKey_";
  protected final String TEXT_24 = ");" + NL + "                                if (remaining) {" + NL + "                                  in.getCurrentValue(seqValue_";
  protected final String TEXT_25 = ");" + NL + "                                }" + NL + "                                if (pos >= end && in.syncSeen()) {" + NL + "                                  more = false;" + NL + "                                } else {" + NL + "                                  more = remaining;" + NL + "                                }" + NL + "" + NL + "                                value.";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = "seqKey_";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ";" + NL + "                                value.";
  protected final String TEXT_30 = " = ";
  protected final String TEXT_31 = "seqValue_";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ";" + NL + "" + NL + "                                return more;" + NL + "  \t\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\t\tpublic NullWritable createKey() {" + NL + "\t\t\t\t\t\t\t\treturn NullWritable.get();" + NL + "\t\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\t\tpublic ";
  protected final String TEXT_34 = "Struct createValue() {" + NL + "\t\t\t\t\t\t\t\treturn new ";
  protected final String TEXT_35 = "Struct();" + NL + "\t\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\t\tpublic long getPos() throws IOException {" + NL + "\t\t\t\t\t\t\t\tif(in != null) {" + NL + "\t\t\t\t\t\t \t\t\treturn in.getPosition();" + NL + "\t\t\t\t\t\t \t\t}" + NL + "\t\t\t\t\t\t \t\treturn -1;" + NL + "  \t\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\t\tpublic void close() throws IOException {" + NL + "\t\t\t\t\t\t\t\tif (in != null) {" + NL + "\t\t\t\t\t\t\t\t\tin.close();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\t\tpublic float getProgress() throws IOException {" + NL + "\t\t\t\t\t\t\t\tif (start == end) {" + NL + "\t\t\t\t\t\t\t\t\treturn 0.0f;" + NL + "\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\treturn Math" + NL + "\t\t\t\t\t\t\t\t\t\t\t.min(1.0f, (getPos() - start) / (float) (end - start));" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_36 = NL + NL + "\t\t\t\t\tpublic static class ";
  protected final String TEXT_37 = "StructInputFormat extends org.talend.hadoop.mapred.lib.file.TDelimitedFileInputFormat<NullWritable, ";
  protected final String TEXT_38 = "Struct> {" + NL + "\t\t\t\t\t\tprivate ContextProperties context;" + NL + "" + NL + "                \t\t//init" + NL + "                \t\tpublic void setConf(Configuration conf){" + NL + "\t\t\t\t\t\t\tcontext = new ContextProperties(conf);" + NL + "" + NL + "\t\t\t\t\t\t\t// Get the password under the variable decryptedPassword" + NL + "\t                        ";
  protected final String TEXT_39 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_40 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_43 = " = ";
  protected final String TEXT_44 = "; ";
  protected final String TEXT_45 = NL + NL + "\t                        setInputPath(\"s3n://\" + ";
  protected final String TEXT_46 = " +\":\" + decryptedPassword_";
  protected final String TEXT_47 = " + \"@\" + ";
  protected final String TEXT_48 = ");" + NL + "\t\t\t\t\t\t\tsetSkipLines(";
  protected final String TEXT_49 = ");" + NL + "                \t\t}" + NL + "" + NL + "\t\t\t\t\t\tpublic RecordReader<NullWritable, ";
  protected final String TEXT_50 = "Struct> getRecordReader(" + NL + "\t\t\t\t\t\t\t\tInputSplit split, JobConf job, Reporter reporter)" + NL + "\t\t\t\t\t\t\t\tthrows IOException {" + NL + "\t\t\t\t\t\t\tif (reporter != null) {" + NL + "\t\t\t\t\t\t\t\treporter.setStatus(split.toString());" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\treturn new S3RecordReader(job, (FileSplit) split, ";
  protected final String TEXT_51 = ".getBytes(";
  protected final String TEXT_52 = "));" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\tprotected static class S3RecordReader extends" + NL + "\t\t\t\t\t\t\torg.talend.hadoop.mapred.lib.file.TDelimitedFileRecordReader<NullWritable, ";
  protected final String TEXT_53 = "Struct> {" + NL + "" + NL + "\t\t\t\t\t\t\tprivate ContextProperties context;" + NL + "" + NL + "\t\t\t\t\t\t\tprotected S3RecordReader(JobConf job, FileSplit split, byte[] rowSeparator)" + NL + "\t\t\t\t\t\t\t\t\tthrows IOException {" + NL + "\t\t\t\t\t\t\t\tsuper(job, split, rowSeparator);" + NL + "\t\t\t\t\t\t\t\tthis.context = new ContextProperties(job);" + NL + "\t\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\t\tprotected Text dummyValue = new Text();" + NL + "" + NL + "\t\t\t\t\t\t\tpublic boolean next(NullWritable key, ";
  protected final String TEXT_54 = "Struct value) throws IOException {" + NL + "\t\t\t\t\t\t\t\tif (next(dummyValue)) {" + NL + "\t\t\t\t\t\t\t\t\tString[] columns = routines.system.StringUtils.splitNotRegex(dummyValue.toString(), ";
  protected final String TEXT_55 = ");" + NL + "\t\t\t\t\t\t\t\t\tString columnValue = \"\";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_57 = " < columns.length){" + NL + "\t\t\t\t\t\t\t\t\t\t\tcolumnValue = columns[";
  protected final String TEXT_58 = "]";
  protected final String TEXT_59 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\tif(columnValue.length() > 0){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_61 = " = columnValue;" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_63 = " = columnValue.getBytes(";
  protected final String TEXT_64 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_66 = " = BigDataParserUtils.parseTo_Date(columnValue, ";
  protected final String TEXT_67 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_69 = " = BigDataParserUtils.parseTo_";
  protected final String TEXT_70 = "(BigDataParserUtils.parseTo_Number(columnValue, ";
  protected final String TEXT_71 = ", ";
  protected final String TEXT_72 = "));" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_74 = " = BigDataParserUtils.parseTo_";
  protected final String TEXT_75 = "(columnValue);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_78 = " = ";
  protected final String TEXT_79 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_81 = "' in '";
  protected final String TEXT_82 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_85 = " = ";
  protected final String TEXT_86 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_88 = "' in '";
  protected final String TEXT_89 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\t\tpublic NullWritable createKey() {" + NL + "\t\t\t\t\t\t\t\treturn NullWritable.get();" + NL + "\t\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\t\tpublic ";
  protected final String TEXT_92 = "Struct createValue() {" + NL + "\t\t\t\t\t\t\t\treturn new ";
  protected final String TEXT_93 = "Struct();" + NL + "\t\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;

INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();

if ((metadatas!=null) && (metadatas.size() > 0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata != null) {
		String fieldSeparator = ElementParameterParser.getValue(node,"__FIELDSEPARATOR__");
		String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");
		boolean customEncoding = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_ENCODING__"));
		String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		String skipLines = ElementParameterParser.getValue(node,"__HEADER__");
        String s3bucket = ElementParameterParser.getValue(node,"__S3_BUCKET__");
        String s3username = ElementParameterParser.getValue(node, "__S3_USERNAME__");
        String passwordFieldName = "__S3_PASSWORD__";

		String typeFile = ElementParameterParser.getValue(node,"__TYPEFILE__");

		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		if (conns != null){

			if (conns.size()>0){

				IConnection conn =conns.get(0);
				String connName = conn.getName();

				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					List<IMetadataColumn> columns = metadata.getListColumns();
					int nbColumns = columns.size();

					if ("SEQUENCE".equals(typeFile)) {
					
    stringBuffer.append(TEXT_1);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_3);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_6);
    } else {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_16);
    
    							String keyColumn = ElementParameterParser.getValue(node,"__KEYCOLUMN__");
    							String valueColumn = ElementParameterParser.getValue(node,"__VALUECOLUMN__");

    							String talendKeyClass = "";
								String talendValueClass = "";

    							for ( int i = 0; i < nbColumns; i++ ){
        							IMetadataColumn column = columns.get(i);
                    				if (column.getLabel().equals(keyColumn)) {
                    					talendKeyClass = column.getTalendType();
                    				}
                    				if (column.getLabel().equals(valueColumn)) {
                    					talendValueClass = column.getTalendType();
                    				}
    							}

    							String keyClass="org.apache.hadoop.io.Text";
                    			if (talendKeyClass.equals("id_Boolean")) keyClass="org.apache.hadoop.io.BooleanWritable";
                    			if (talendKeyClass.equals("id_Byte")) keyClass="org.apache.hadoop.io.ByteWritable";
                    			if (talendKeyClass.equals("id_byte[]")) keyClass="org.apache.hadoop.io.BytesWritable";
                    			if (talendKeyClass.equals("id_Double")) keyClass="org.apache.hadoop.io.DoubleWritable";
                    			if (talendKeyClass.equals("id_Float")) keyClass="org.apache.hadoop.io.FloatWritable";
                    			if (talendKeyClass.equals("id_Integer")) keyClass="org.apache.hadoop.io.IntWritable";
                    			if (talendKeyClass.equals("id_Long")) keyClass="org.apache.hadoop.io.LongWritable";
                    			if (talendKeyClass.equals("id_Short")) keyClass="org.apache.hadoop.io.IntWritable";
                    			if (talendKeyClass.equals("id_String")) keyClass="org.apache.hadoop.io.Text";

                    			String valueClass="org.apache.hadoop.io.Text";
                    			if (talendValueClass.equals("id_Boolean")) valueClass="org.apache.hadoop.io.BooleanWritable";
                    			if (talendValueClass.equals("id_Byte")) valueClass="org.apache.hadoop.io.ByteWritable";
                    			if (talendValueClass.equals("id_byte[]")) valueClass="org.apache.hadoop.io.BytesWritable";
                    			if (talendValueClass.equals("id_Double")) valueClass="org.apache.hadoop.io.DoubleWritable";
                    			if (talendValueClass.equals("id_Float")) valueClass="org.apache.hadoop.io.FloatWritable";
                    			if (talendValueClass.equals("id_Integer")) valueClass="org.apache.hadoop.io.IntWritable";
                    			if (talendValueClass.equals("id_Long")) valueClass="org.apache.hadoop.io.LongWritable";
                    			if (talendValueClass.equals("id_Short")) valueClass="org.apache.hadoop.io.IntWritable";
                    			if (talendValueClass.equals("id_String")) valueClass="org.apache.hadoop.io.Text";
								
    stringBuffer.append(TEXT_17);
    stringBuffer.append(keyClass);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(keyClass);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(valueClass);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(valueClass);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(keyColumn );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(talendKeyClass.equals("id_Short")?"(short)":"");
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(((keyClass.equals("org.apache.hadoop.io.Text"))?"toString()":"get()") );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(valueColumn );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(talendValueClass.equals("id_Short")?"(short)":"");
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(((valueClass.equals("org.apache.hadoop.io.Text"))?"toString()":"get()") );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_35);
    
						return stringBuffer.toString();
					}
					
    stringBuffer.append(TEXT_36);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_38);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_41);
    } else {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(skipLines);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_55);
    
									List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
									String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
									boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;

									String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
									boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
									String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
									String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

									for ( int i = 0; i < nbColumns; i++ ){
										IMetadataColumn column = columns.get(i);
										String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
										JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
										String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
										String columnName = column.getLabel();	
										String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
										
    stringBuffer.append(TEXT_56);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_58);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_59);
    
												if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
												
    stringBuffer.append(TEXT_60);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_61);
    
												}else{
													if(javaType == JavaTypesManager.BYTE_ARRAY){ 
													
    stringBuffer.append(TEXT_62);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_64);
    
													}else if(javaType == JavaTypesManager.DATE) { 
													
    stringBuffer.append(TEXT_65);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_67);
    
													}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
													
    stringBuffer.append(TEXT_68);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_70);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_71);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_72);
    
													} else { 
													
    stringBuffer.append(TEXT_73);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_75);
    
													}
												}
												
    stringBuffer.append(TEXT_76);
    if(defaultValue!=null && defaultValue.length()>0){
    stringBuffer.append(TEXT_77);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_79);
    }else{
    stringBuffer.append(TEXT_80);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    if(defaultValue!=null && defaultValue.length()>0){
    stringBuffer.append(TEXT_84);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_86);
    }else{
    stringBuffer.append(TEXT_87);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    
									}
									
    stringBuffer.append(TEXT_91);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_93);
    
				}
			}
		}
	}
}

    return stringBuffer.toString();
  }
}
