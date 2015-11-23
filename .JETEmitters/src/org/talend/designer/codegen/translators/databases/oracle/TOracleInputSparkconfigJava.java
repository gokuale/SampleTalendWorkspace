package org.talend.designer.codegen.translators.databases.oracle;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.spark.generator.storage.OracleSparkStorage;

public class TOracleInputSparkconfigJava
{
  protected static String nl;
  public static synchronized TOracleInputSparkconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleInputSparkconfigJava result = new TOracleInputSparkconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            org.apache.spark.sql.SQLContext sqlCtx_";
  protected final String TEXT_2 = " = new org.apache.spark.sql.SQLContext(ctx);" + NL + "" + NL + "            Map<String, String> map_";
  protected final String TEXT_3 = " = new java.util.HashMap<String, String>();" + NL + "" + NL + "            map_";
  protected final String TEXT_4 = ".put(\"url\" , ";
  protected final String TEXT_5 = ");" + NL + "            map_";
  protected final String TEXT_6 = ".put(\"dbtable\", ";
  protected final String TEXT_7 = ");" + NL + "            map_";
  protected final String TEXT_8 = ".put(\"driver\", ";
  protected final String TEXT_9 = ");" + NL + "" + NL + "            org.apache.spark.sql.DataFrame df_";
  protected final String TEXT_10 = " = sqlCtx_";
  protected final String TEXT_11 = ".load(\"jdbc\", map_";
  protected final String TEXT_12 = ");" + NL + "            df_";
  protected final String TEXT_13 = ".registerTempTable(";
  protected final String TEXT_14 = ");" + NL + "            df_";
  protected final String TEXT_15 = " =  sqlCtx_";
  protected final String TEXT_16 = ".sql(";
  protected final String TEXT_17 = ")";
  protected final String TEXT_18 = ";" + NL + "" + NL + "            // Retrieve the associated RDD" + NL + "            org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_19 = "> rdd_";
  protected final String TEXT_20 = " = df_";
  protected final String TEXT_21 = ".toJavaRDD().map(new ";
  protected final String TEXT_22 = "_FromRowTo";
  protected final String TEXT_23 = "());";
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();

if (metadatas != null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    if(metadata != null){
        List< ? extends IConnection> connections = node.getOutgoingConnections();
        if ((connections != null) && (connections.size() > 0)) {
            IConnection connection = connections.get(0);
            String connName = connection.getName();
            String connectionTypeName = codeGenArgument.getRecordStructName(connection);

            OracleSparkStorage storage = new OracleSparkStorage(node);

            String table = ElementParameterParser.getValue(node,  "__TABLE__");
            String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
            dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);


            String renamedColumn = "";
            for (IMetadataColumn column: connection.getMetadataTable().getListColumns()) {
                if (!column.getOriginalDbColumnName().equals(column.getLabel())) {
                    // the DB column is not the same as the label, with have to bind the name.
                    renamedColumn += ".withColumnRenamed(\"" + column.getOriginalDbColumnName() + "\", \"" + column.getLabel() + "\")";
                }
            }

            
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(storage.getURI());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(storage.getDriver());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(renamedColumn);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_23);
    
        }
    }
}

    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
