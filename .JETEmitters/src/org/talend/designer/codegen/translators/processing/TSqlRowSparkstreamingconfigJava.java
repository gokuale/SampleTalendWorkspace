package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.common.tsqlrow.TSqlRowUtil;

public class TSqlRowSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TSqlRowSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSqlRowSparkstreamingconfigJava result = new TSqlRowSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "org.apache.spark.sql.SQLContext sqlContext_";
  protected final String TEXT_3 = " = new org.apache.spark.sql.SQLContext(ctx.sparkContext());" + NL + "" + NL + "// Create dataframes from incoming schemas and register related tables";
  protected final String TEXT_4 = NL + "    org.apache.spark.sql.DataFrame df_";
  protected final String TEXT_5 = "_";
  protected final String TEXT_6 = " = sqlContext_";
  protected final String TEXT_7 = ".createDataFrame(" + NL + "            rdd_";
  protected final String TEXT_8 = ", ";
  protected final String TEXT_9 = ".class);" + NL + "    df_";
  protected final String TEXT_10 = "_";
  protected final String TEXT_11 = ".registerTempTable(\"";
  protected final String TEXT_12 = "\");";
  protected final String TEXT_13 = NL + NL + "// Execute the sql query" + NL + "org.apache.spark.sql.DataFrame df_";
  protected final String TEXT_14 = " = sqlContext_";
  protected final String TEXT_15 = ".sql(";
  protected final String TEXT_16 = ");" + NL + "" + NL + "// Retrieve the associated RDD" + NL + "org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_17 = "> rdd_";
  protected final String TEXT_18 = " = df_";
  protected final String TEXT_19 = ".toJavaRDD().map(" + NL + "        new ";
  protected final String TEXT_20 = "_FromRowTo";
  protected final String TEXT_21 = "());";
  protected final String TEXT_22 = NL + "org.apache.spark.streaming.api.java.JavaDStream<";
  protected final String TEXT_23 = "> rdd_";
  protected final String TEXT_24 = " = rdd_";
  protected final String TEXT_25 = ".transform(" + NL + "    new org.apache.spark.api.java.function.Function<org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_26 = ">, org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_27 = ">>() {" + NL + "      @Override" + NL + "      public org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_28 = "> call(org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_29 = "> temporaryRdd) throws Exception {" + NL + "          org.apache.spark.sql.SQLContext sqlContext = ";
  protected final String TEXT_30 = "_JavaSQLContextSingleton.getInstance(temporaryRdd.context());" + NL + "          // Create dataframes from incoming schemas and register related tables" + NL + "          org.apache.spark.sql.DataFrame dataframeInput = sqlContext.createDataFrame(temporaryRdd, ";
  protected final String TEXT_31 = ".class);" + NL + "          dataframeInput.registerTempTable(\"";
  protected final String TEXT_32 = "\");" + NL + "" + NL + "          // Execute the sql query" + NL + "          org.apache.spark.sql.DataFrame dataframeOutput = sqlContext.sql(";
  protected final String TEXT_33 = ");" + NL + "" + NL + "          // Retrieve the associated RDD" + NL + "          return dataframeOutput.toJavaRDD().map(new ";
  protected final String TEXT_34 = "_FromRowTo";
  protected final String TEXT_35 = "());" + NL + "      }" + NL + "    });";
  protected final String TEXT_36 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
if(org.talend.designer.common.tmap.LookupUtil.isNodeInBatchMode((INode) ((BigDataCodeGeneratorArgument) argument).getArgument())) {

    stringBuffer.append(TEXT_1);
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

TSqlRowUtil tSqlRowUtil = new TSqlRowUtil(node);
String outStructName = codeGenArgument.getRecordStructName(tSqlRowUtil.getOutgoingConnection());


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
for(IConnection incomingConnection : tSqlRowUtil.getIncomingConnections()) {
    String inStructName = codeGenArgument.getRecordStructName(incomingConnection);
    
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(incomingConnection.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(incomingConnection.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(incomingConnection.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(tSqlRowUtil.getTableName(incomingConnection));
    stringBuffer.append(TEXT_12);
    
} // end for

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(tSqlRowUtil.getSqlQuery());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(tSqlRowUtil.getOutgoingConnection().getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_21);
    
} else {
	BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	TSqlRowUtil tSqlRowUtil = new TSqlRowUtil(node);
	String outStructName = codeGenArgument.getRecordStructName(tSqlRowUtil.getOutgoingConnection());
	IConnection incomingConnection = tSqlRowUtil.getIncomingConnections().get(0);
	String inStructName = codeGenArgument.getRecordStructName(incomingConnection);

    stringBuffer.append(TEXT_22);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(tSqlRowUtil.getOutgoingConnection().getName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(incomingConnection.getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(tSqlRowUtil.getTableName(incomingConnection));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(tSqlRowUtil.getSqlQuery());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_35);
    
} // end else

    stringBuffer.append(TEXT_36);
    return stringBuffer.toString();
  }
}
