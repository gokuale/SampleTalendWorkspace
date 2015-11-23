package org.talend.designer.codegen.translators.file.output;

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

public class TFileOutputParquetSparkconfigJava
{
  protected static String nl;
  public static synchronized TFileOutputParquetSparkconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputParquetSparkconfigJava result = new TFileOutputParquetSparkconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        String outputPath_";
  protected final String TEXT_2 = " = ";
  protected final String TEXT_3 = ";";
  protected final String TEXT_4 = NL + "            java.net.URI currentURI_";
  protected final String TEXT_5 = "_config = FileSystem.getDefaultUri(ctx.hadoopConfiguration());" + NL + "            FileSystem.setDefaultUri(ctx.hadoopConfiguration(), new java.net.URI(";
  protected final String TEXT_6 = "));" + NL + "            fs = FileSystem.get(ctx.hadoopConfiguration());";
  protected final String TEXT_7 = NL + "                fs.delete(new Path(";
  protected final String TEXT_8 = "),true);";
  protected final String TEXT_9 = NL + NL + "            job.setWorkingDirectory(fs.getWorkingDirectory());" + NL + "            job.set(parquet.hadoop.ParquetOutputFormat.WRITE_SUPPORT_CLASS, parquet.hadoop.example.GroupWriteSupport.class.getCanonicalName());" + NL + "            java.util.List<parquet.schema.Type> types_";
  protected final String TEXT_10 = " = new java.util.ArrayList<parquet.schema.Type>();";
  protected final String TEXT_11 = NL + "                    types_";
  protected final String TEXT_12 = ".add(new parquet.schema.PrimitiveType(parquet.schema.Type.Repetition.REQUIRED,    parquet.schema.PrimitiveType.PrimitiveTypeName.INT32, \"";
  protected final String TEXT_13 = "\"));";
  protected final String TEXT_14 = NL + "                    types_";
  protected final String TEXT_15 = ".add(new parquet.schema.PrimitiveType(parquet.schema.Type.Repetition.REQUIRED,    parquet.schema.PrimitiveType.PrimitiveTypeName.INT64, \"";
  protected final String TEXT_16 = "\"));";
  protected final String TEXT_17 = NL + "                    types_";
  protected final String TEXT_18 = ".add(new parquet.schema.PrimitiveType(parquet.schema.Type.Repetition.REQUIRED,    parquet.schema.PrimitiveType.PrimitiveTypeName.DOUBLE, \"";
  protected final String TEXT_19 = "\"));";
  protected final String TEXT_20 = NL + "                    types_";
  protected final String TEXT_21 = ".add(new parquet.schema.PrimitiveType(parquet.schema.Type.Repetition.REQUIRED,    parquet.schema.PrimitiveType.PrimitiveTypeName.FLOAT, \"";
  protected final String TEXT_22 = "\"));";
  protected final String TEXT_23 = NL + "                    types_";
  protected final String TEXT_24 = ".add(new parquet.schema.PrimitiveType(parquet.schema.Type.Repetition.REQUIRED,    parquet.schema.PrimitiveType.PrimitiveTypeName.BOOLEAN, \"";
  protected final String TEXT_25 = "\"));";
  protected final String TEXT_26 = NL + "                    types_";
  protected final String TEXT_27 = ".add(new parquet.schema.PrimitiveType(parquet.schema.Type.Repetition.REQUIRED,    parquet.schema.PrimitiveType.PrimitiveTypeName.BINARY, \"";
  protected final String TEXT_28 = "\"));";
  protected final String TEXT_29 = NL + "            parquet.schema.MessageType schema_";
  protected final String TEXT_30 = " = new parquet.schema.MessageType(\"";
  protected final String TEXT_31 = "\", types_";
  protected final String TEXT_32 = ");" + NL + "            parquet.hadoop.example.GroupWriteSupport.setSchema(schema_";
  protected final String TEXT_33 = ", job);" + NL + "" + NL + "            TalendParquetOutputFormat_";
  protected final String TEXT_34 = ".setWorkOutputPath(job, new Path(outputPath_";
  protected final String TEXT_35 = " + \"/workoutput\"));" + NL + "            TalendParquetOutputFormat_";
  protected final String TEXT_36 = ".setOutputPath(job, new Path(outputPath_";
  protected final String TEXT_37 = "));" + NL + "            TalendParquetOutputFormat_";
  protected final String TEXT_38 = ".setCompression(job, parquet.hadoop.metadata.CompressionCodecName.";
  protected final String TEXT_39 = ");" + NL + "" + NL + "            rdd_";
  protected final String TEXT_40 = ".mapToPair(new toVoid_";
  protected final String TEXT_41 = "()).saveAsHadoopFile(";
  protected final String TEXT_42 = ", NullWritable.class, Object.class, TalendParquetOutputFormat_";
  protected final String TEXT_43 = ".class, job);";
  protected final String TEXT_44 = NL + "            FileSystem.setDefaultUri(ctx.hadoopConfiguration(), currentURI_";
  protected final String TEXT_45 = "_config);" + NL + "            fs = FileSystem.get(ctx.hadoopConfiguration());";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();
final String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();

if(metadatas != null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    if(metadata != null){
        String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");
        String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");
        String folder = ElementParameterParser.getValue(node, "__FILENAME__");
        String fileAction = ElementParameterParser.getValue(node, "__FILE_ACTION__");

        String uriPrefix = "\"\"";
        // Used for Spark only for now.
        boolean useConfigurationComponent = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_STORAGE_CONFIGURATION__"));
        if(useConfigurationComponent) {
            uriPrefix = org.talend.designer.spark.generator.storage.SparkStorageUtils.getURIPrefix(node);
            folder = uriPrefix + " + " + folder;
        }

        String inConnName = "";
        IConnection connection = null;
        String connTypeName = "";
        if ((node.getIncomingConnections() != null) && (node.getIncomingConnections().size() > 0)) {
            connection = node.getIncomingConnections().get(0);
            inConnName = connection.getName();
            connTypeName = codeGenArgument.getRecordStructName(connection);
        }
        
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_3);
    

        if(!"\"\"".equals(uriPrefix)) {
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(uriPrefix);
    stringBuffer.append(TEXT_6);
    
        }

        if(connection.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
            if("OVERWRITE".equals(fileAction)){
                
    stringBuffer.append(TEXT_7);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_8);
    
            }
            
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
            List<IMetadataColumn> columns = metadata.getListColumns();
            int nbColumns = columns.size();
            for(int i=0; i<nbColumns; i++) {
                IMetadataColumn column = columns.get(i);
                String columnName = column.getLabel();
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

                if(javaType == JavaTypesManager.INTEGER || javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.BYTE) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_13);
    
                } else if(javaType == JavaTypesManager.LONG) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_16);
    
                } else if(javaType == JavaTypesManager.DOUBLE) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_19);
    
                } else if(javaType == JavaTypesManager.FLOAT) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_22);
    
                } else if(javaType == JavaTypesManager.BOOLEAN) {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_25);
    
                } else {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_28);
    
                }
            }

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(compression);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
        }

        if(!"\"\"".equals(uriPrefix)) {
        
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
        }
    }
}

    return stringBuffer.toString();
  }
}
