package org.talend.designer.codegen.translators.mapreduce.output;

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

public class TFileOutputParquetMrconfigJava
{
  protected static String nl;
  public static synchronized TFileOutputParquetMrconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputParquetMrconfigJava result = new TFileOutputParquetMrconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "                String outputPath_";
  protected final String TEXT_2 = " = ";
  protected final String TEXT_3 = ";";
  protected final String TEXT_4 = NL + "                    job.set(parquet.hadoop.ParquetOutputFormat.WRITE_SUPPORT_CLASS, parquet.hadoop.example.GroupWriteSupport.class.getCanonicalName());" + NL + "                    java.util.List<parquet.schema.Type> types_";
  protected final String TEXT_5 = " = new java.util.ArrayList<parquet.schema.Type>();";
  protected final String TEXT_6 = NL + "                            types_";
  protected final String TEXT_7 = ".add(new parquet.schema.PrimitiveType(parquet.schema.Type.Repetition.REQUIRED,    parquet.schema.PrimitiveType.PrimitiveTypeName.INT32, \"";
  protected final String TEXT_8 = "\"));";
  protected final String TEXT_9 = NL + "                            types_";
  protected final String TEXT_10 = ".add(new parquet.schema.PrimitiveType(parquet.schema.Type.Repetition.REQUIRED,    parquet.schema.PrimitiveType.PrimitiveTypeName.INT64, \"";
  protected final String TEXT_11 = "\"));";
  protected final String TEXT_12 = NL + "                            types_";
  protected final String TEXT_13 = ".add(new parquet.schema.PrimitiveType(parquet.schema.Type.Repetition.REQUIRED,    parquet.schema.PrimitiveType.PrimitiveTypeName.DOUBLE, \"";
  protected final String TEXT_14 = "\"));";
  protected final String TEXT_15 = NL + "                            types_";
  protected final String TEXT_16 = ".add(new parquet.schema.PrimitiveType(parquet.schema.Type.Repetition.REQUIRED,    parquet.schema.PrimitiveType.PrimitiveTypeName.FLOAT, \"";
  protected final String TEXT_17 = "\"));";
  protected final String TEXT_18 = NL + "                            types_";
  protected final String TEXT_19 = ".add(new parquet.schema.PrimitiveType(parquet.schema.Type.Repetition.REQUIRED,    parquet.schema.PrimitiveType.PrimitiveTypeName.BOOLEAN, \"";
  protected final String TEXT_20 = "\"));";
  protected final String TEXT_21 = NL + "                            types_";
  protected final String TEXT_22 = ".add(new parquet.schema.PrimitiveType(parquet.schema.Type.Repetition.REQUIRED,    parquet.schema.PrimitiveType.PrimitiveTypeName.BINARY, \"";
  protected final String TEXT_23 = "\"));";
  protected final String TEXT_24 = NL + "                    parquet.schema.MessageType schema_";
  protected final String TEXT_25 = " = new parquet.schema.MessageType(\"";
  protected final String TEXT_26 = "\", types_";
  protected final String TEXT_27 = ");" + NL + "                    parquet.hadoop.example.GroupWriteSupport.setSchema(schema_";
  protected final String TEXT_28 = ", job);" + NL + "" + NL + "                    job.setOutputFormat(TalendParquetOutputFormat_";
  protected final String TEXT_29 = ".class);" + NL + "                    TalendParquetOutputFormat_";
  protected final String TEXT_30 = ".setOutputPath(job, new Path(outputPath_";
  protected final String TEXT_31 = "));" + NL + "                    TalendParquetOutputFormat_";
  protected final String TEXT_32 = ".setCompression(job, parquet.hadoop.metadata.CompressionCodecName.";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "                        fs.delete(new Path(";
  protected final String TEXT_35 = "),true);";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

// Note: because tFileOutputParquet is always preceded by a Parquet mapper,
// it is never directly based on a direct REJECT flow from a component with
// multiple connections (i.e., its data is never coming from a MultipleOutputs
// object)

BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;

INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();

if(metadatas!=null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    if(metadata != null){

        String folder = ElementParameterParser.getValue(node,"__FILENAME__");
        String fileAction = ElementParameterParser.getValue(node, "__FILE_ACTION__");
        String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");

        List< ? extends IConnection> conns = node.getIncomingConnections();
        if(conns != null){

            if(conns.size()>0){

                IConnection conn =conns.get(0);
                String connName = conn.getName();


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_3);
    
                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
                    List<IMetadataColumn> columns = metadata.getListColumns();
                    int nbColumns = columns.size();
                
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
                    for(int i=0; i<nbColumns; i++) {
                        IMetadataColumn column = columns.get(i);
                        String columnName = column.getLabel();
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                        JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

                        if(javaType == JavaTypesManager.INTEGER || javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.BYTE) {
                
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_8);
    
                        } else if(javaType == JavaTypesManager.LONG) {
                
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_11);
    
                        } else if(javaType == JavaTypesManager.DOUBLE) {
                
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_14);
    
                        } else if(javaType == JavaTypesManager.FLOAT) {
                
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_17);
    
                        } else if(javaType == JavaTypesManager.BOOLEAN) {
                
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_20);
    
                        } else {
                
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_23);
    
                        }
                    }
                
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(compression);
    stringBuffer.append(TEXT_33);
    
                    if("OVERWRITE".equals(fileAction)){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_35);
    
                    }
                }
            }
        }
    }
}

    return stringBuffer.toString();
  }
}
