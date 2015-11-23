package org.talend.designer.codegen.translators.file.input;

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

public class TFileStreamInputParquetSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TFileStreamInputParquetSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileStreamInputParquetSparkstreamingcodeJava result = new TFileStreamInputParquetSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "                public static class TalendParquetInputFormat_";
  protected final String TEXT_2 = NL + "                    extends parquet.hadoop.ParquetInputFormat<Object> {" + NL + "                }" + NL + "" + NL + "                public static class toNullWritable_";
  protected final String TEXT_3 = NL + "                    implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<Void, Object>," + NL + "                        NullWritable, ";
  protected final String TEXT_4 = "> {" + NL + "" + NL + "                    public scala.Tuple2<NullWritable, ";
  protected final String TEXT_5 = "> call(" + NL + "                                scala.Tuple2<Void, Object> arg0) throws Exception {" + NL + "                        parquet.example.data.Group input = (parquet.example.data.Group)arg0._2;";
  protected final String TEXT_6 = NL + "                        ";
  protected final String TEXT_7 = " output = new ";
  protected final String TEXT_8 = "();" + NL;
  protected final String TEXT_9 = NL + "                                output.";
  protected final String TEXT_10 = " = input.getInteger(\"";
  protected final String TEXT_11 = "\", 0);";
  protected final String TEXT_12 = NL + "                                output.";
  protected final String TEXT_13 = " = BigDataParserUtils.parseTo_Byte(input.getInteger(\"";
  protected final String TEXT_14 = "\", 0));";
  protected final String TEXT_15 = NL + "                                output.";
  protected final String TEXT_16 = " = input.getDouble(\"";
  protected final String TEXT_17 = "\", 0);";
  protected final String TEXT_18 = NL + "                                output.";
  protected final String TEXT_19 = " = input.getLong(\"";
  protected final String TEXT_20 = "\", 0);";
  protected final String TEXT_21 = NL + "                                output.";
  protected final String TEXT_22 = " = input.getFloat(\"";
  protected final String TEXT_23 = "\", 0);";
  protected final String TEXT_24 = NL + "                                output.";
  protected final String TEXT_25 = " = new Integer(input.getInteger(\"";
  protected final String TEXT_26 = "\", 0)).shortValue();";
  protected final String TEXT_27 = NL + "                                output.";
  protected final String TEXT_28 = " = input.getBoolean(\"";
  protected final String TEXT_29 = "\", 0);";
  protected final String TEXT_30 = NL + "                                output.";
  protected final String TEXT_31 = " = java.nio.ByteBuffer.wrap(input.getBinary(\"";
  protected final String TEXT_32 = "\", 0).getBytes());";
  protected final String TEXT_33 = NL + "                                output.";
  protected final String TEXT_34 = " = BigDataParserUtils.parseTo_Date(input.getString(\"";
  protected final String TEXT_35 = "\", 0),";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "                                output.";
  protected final String TEXT_38 = " = BigDataParserUtils.parseTo_";
  protected final String TEXT_39 = "(input.getString(\"";
  protected final String TEXT_40 = "\", 0));";
  protected final String TEXT_41 = NL + NL + "                        return new scala.Tuple2<NullWritable, ";
  protected final String TEXT_42 = ">(" + NL + "                                NullWritable.get(), output);" + NL + "                    }" + NL + "                }";
  protected final String TEXT_43 = NL;

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
        List< ? extends IConnection> conns = node.getOutgoingConnections();

        if ((conns != null) && (conns.size() > 0)) {
            IConnection conn = conns.get(0);
            String connName = conn.getName();
            String connTypeName = codeGenArgument.getRecordStructName(conn);

            if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_8);
    
                        List<IMetadataColumn> columns = metadata.getListColumns();
                        for(IMetadataColumn column: columns) {
                            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                            String columnName = column.getLabel();
                            if(javaType == JavaTypesManager.INTEGER) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_11);
    
                            } else if(javaType == JavaTypesManager.BYTE) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_14);
    
                            } else if(javaType == JavaTypesManager.DOUBLE) {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_17);
    
                            } else if(javaType == JavaTypesManager.LONG) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_20);
    
                            } else if(javaType == JavaTypesManager.FLOAT) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_23);
    
                            } else if(javaType == JavaTypesManager.SHORT) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_26);
    
                            } else if(javaType == JavaTypesManager.BOOLEAN) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_29);
    
                            } else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_32);
    
                            } else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_36);
    
                            } else {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_40);
    
                            }
                        }

    stringBuffer.append(TEXT_41);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_42);
    
            }
        }
    }
}

    stringBuffer.append(TEXT_43);
    return stringBuffer.toString();
  }
}
