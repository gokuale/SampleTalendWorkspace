package org.talend.designer.codegen.translators.machinelearning.recommendation;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.tsqlrow.TSqlRowUtil;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TRecommendSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TRecommendSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRecommendSparkstreamingconfigJava result = new TRecommendSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "// 1. Load and cache the Model" + NL + "//Common processing for both batch & streaming version of tRecommend" + NL + "org.apache.spark.mllib.recommendation.MatrixFactorizationModel ";
  protected final String TEXT_2 = "_model =" + NL + "\torg.apache.spark.mllib.recommendation.MatrixFactorizationModel.load(";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = ");" + NL + "" + NL + "final org.apache.spark.mllib.recommendation.MatrixFactorizationModel ";
  protected final String TEXT_5 = "_cachedModel =" + NL + "\tnew org.apache.spark.mllib.recommendation.MatrixFactorizationModel(" + NL + "\t\t\t";
  protected final String TEXT_6 = "_model.rank()," + NL + "\t\t\t";
  protected final String TEXT_7 = "_model.userFeatures().cache(),//cached rddUserFeatures" + NL + "\t\t\t";
  protected final String TEXT_8 = "_model.productFeatures().cache()//cached rddProductFeatures" + NL + "\t);" + NL + "//TODO partitioner features rdd" + NL;
  protected final String TEXT_9 = NL + NL + "\t//Streaming version of tPredict" + NL + "\torg.apache.spark.streaming.api.java.JavaDStream<";
  protected final String TEXT_10 = "> rdd_";
  protected final String TEXT_11 = NL + "\t\t= rdd_";
  protected final String TEXT_12 = ".transform(" + NL + "" + NL + "\t\t    new org.apache.spark.api.java.function.Function<org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_13 = ">, org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_14 = ">>() {" + NL + "" + NL + "\t\t\t\t@Override" + NL + "\t\t\t\tpublic org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_15 = "> call(org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_16 = "> rdd) {" + NL + "" + NL + "\t\t\t\t\t// 2. Create dataFrame" + NL + "\t\t\t\t\torg.apache.spark.sql.SQLContext sqlContext_";
  protected final String TEXT_17 = " =" + NL + "\t\t\t\t\t\torg.talend.datascience.util.SQLUtil.getSQLContextSingleton(rdd.context());" + NL + "\t\t\t\t    org.apache.spark.sql.DataFrame df_";
  protected final String TEXT_18 = " =" + NL + "\t\t\t\t    \tsqlContext_";
  protected final String TEXT_19 = ".createDataFrame(rdd, ";
  protected final String TEXT_20 = ".class);" + NL + "" + NL + "\t\t\t\t    // 3. Call predictor" + NL + "\t\t\t\t    return (org.talend.datascience.mllib.recommendation.CollaborativeFiltering.recommender(" + NL + "\t\t\t\t    \t\t\tdf_";
  protected final String TEXT_21 = ".rdd(),//rdd[Row]" + NL + "\t\t\t\t    \t\t\tdf_";
  protected final String TEXT_22 = ".schema(),//sparkSqlSchema" + NL + "\t\t\t\t\t    \t\t";
  protected final String TEXT_23 = "_cachedModel,//MatrixFactorizationModel" + NL + "\t\t\t\t\t    \t\t";
  protected final String TEXT_24 = ",//topN number" + NL + "\t\t\t\t\t    \t\t\"";
  protected final String TEXT_25 = "\"//user column name" + NL + "\t\t\t\t\t    \t).toJavaRDD()).map(new ";
  protected final String TEXT_26 = "_FromRowTo";
  protected final String TEXT_27 = "());" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t);" + NL;
  protected final String TEXT_28 = NL + "// 2. Create dataFrame from incoming rdd & rowStruct" + NL + "org.apache.spark.sql.SQLContext sqlContext_";
  protected final String TEXT_29 = " = new org.apache.spark.sql.SQLContext(";
  protected final String TEXT_30 = ");" + NL + "org.apache.spark.sql.DataFrame df_";
  protected final String TEXT_31 = "_";
  protected final String TEXT_32 = " =" + NL + "\tsqlContext_";
  protected final String TEXT_33 = ".createDataFrame(rdd_";
  protected final String TEXT_34 = ", ";
  protected final String TEXT_35 = ".class);" + NL + "" + NL + "// 3. Call recommender" + NL + "org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_36 = "> rdd_";
  protected final String TEXT_37 = " =" + NL + "\t(org.talend.datascience.mllib.recommendation.CollaborativeFiltering.recommender(" + NL + "\t\tdf_";
  protected final String TEXT_38 = "_";
  protected final String TEXT_39 = ".rdd(),//rdd[Row]" + NL + "\t\tdf_";
  protected final String TEXT_40 = "_";
  protected final String TEXT_41 = ".schema(),//sparkSqlSchema" + NL + "\t\t";
  protected final String TEXT_42 = "_cachedModel,//MatrixFactorizationModel" + NL + "\t\t";
  protected final String TEXT_43 = ",//topN number" + NL + "\t\t\"";
  protected final String TEXT_44 = "\"//user column name" + NL + "\t).toJavaRDD()).map(new ";
  protected final String TEXT_45 = "_FromRowTo";
  protected final String TEXT_46 = "());";
  protected final String TEXT_47 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

TSqlRowUtil tSqlRowUtil = new TSqlRowUtil(node);
IConnection inConn = tSqlRowUtil.getIncomingConnections().get(0);
String inConnTypeName = codeGenArgument.getRecordStructName(inConn);
String outConnTypeName = codeGenArgument.getRecordStructName(tSqlRowUtil.getOutgoingConnection());

Integer topN = Integer.parseInt(ElementParameterParser.getValue(node, "__TOP_NB__"));
String nameIDCol = ElementParameterParser.getValue(node, "__ID_COLUMN__");
String modelPath = ElementParameterParser.getValue(node, "__MODEL_PATH__");

String ctx = ("SPARKSTREAMING".equals(node.getComponent().getType())) ? "ctx.sparkContext().sc()" : "ctx.sc()" ;


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(ctx);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(modelPath);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
if("SPARKSTREAMING".equals(node.getComponent().getType())
	&& !org.talend.designer.common.tmap.LookupUtil.isNodeInBatchMode(node)){

    stringBuffer.append(TEXT_9);
    stringBuffer.append(outConnTypeName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(tSqlRowUtil.getOutgoingConnection().getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outConnTypeName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(outConnTypeName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(topN);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(nameIDCol);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(outConnTypeName);
    stringBuffer.append(TEXT_27);
    
}else{

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(ctx);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(outConnTypeName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(tSqlRowUtil.getOutgoingConnection().getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(topN);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(nameIDCol);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(outConnTypeName);
    stringBuffer.append(TEXT_46);
    
}

    stringBuffer.append(TEXT_47);
    return stringBuffer.toString();
  }
}
