package org.talend.designer.codegen.translators.machinelearning.classification;

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

public class TPredictSparkconfigJava
{
  protected static String nl;
  public static synchronized TPredictSparkconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPredictSparkconfigJava result = new TPredictSparkconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "// 1. Model Loading" + NL + "// Common processing for both batch & streaming version of tPredict" + NL + "final org.apache.spark.mllib.classification.talend.NaiveBayesRegularRecordsModel model_";
  protected final String TEXT_2 = " =";
  protected final String TEXT_3 = "   " + NL + "        (org.apache.spark.mllib.classification.talend.NaiveBayesRegularRecordsModel) org.talend.datascience.mllib.pmml.imports.ModelImporter" + NL + "            .fromPMML(";
  protected final String TEXT_4 = ", ";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "        (org.apache.spark.mllib.classification.talend.NaiveBayesRegularRecordsModel) org.talend.datascience.mllib.pmml.imports.ModelImporter" + NL + "                .fromPMML(";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + NL + "\t//Streaming version of tPredict" + NL + "\torg.apache.spark.streaming.api.java.JavaDStream<";
  protected final String TEXT_10 = ">" + NL + "\t\trdd_";
  protected final String TEXT_11 = " = rdd_";
  protected final String TEXT_12 = ".transform(" + NL + "" + NL + "\t\t    new org.apache.spark.api.java.function.Function<org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_13 = ">, org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_14 = ">>() {" + NL + "\t\t\t\t@Override" + NL + "\t\t\t\tpublic org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_15 = "> call(org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_16 = "> rdd) {" + NL + "" + NL + "\t\t\t\t\t// 2. Create dataFrame" + NL + "\t\t\t\t\torg.apache.spark.sql.SQLContext sqlContext_";
  protected final String TEXT_17 = " = org.talend.datascience.util.SQLUtil.getSQLContextSingleton(rdd.context());" + NL + "\t\t\t\t    org.apache.spark.sql.DataFrame df_";
  protected final String TEXT_18 = " =" + NL + "\t\t\t\t    \tsqlContext_";
  protected final String TEXT_19 = ".createDataFrame(rdd, ";
  protected final String TEXT_20 = ".class);" + NL + "" + NL + "\t\t\t\t    // 3. Call predictor" + NL + "\t\t\t\t    return (org.talend.datascience.mllib.classification.NaiveBayes.predictor(" + NL + "\t\t\t\t    \t\t\tdf_";
  protected final String TEXT_21 = ".rdd(), // rdd<Row>" + NL + "\t\t\t\t    \t\t\tdf_";
  protected final String TEXT_22 = ".schema(), // schema" + NL + "\t\t\t\t    \t\t\tmodel_";
  protected final String TEXT_23 = " // model" + NL + "\t\t\t\t    \t\t).toJavaRDD()).map(new ";
  protected final String TEXT_24 = "_FromRowTo";
  protected final String TEXT_25 = "());" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t);" + NL;
  protected final String TEXT_26 = NL + "\t// Batch version of tPredict" + NL + "\t// 2. Create dataFrame from incoming rdd & rowStruct" + NL + "\torg.apache.spark.sql.SQLContext sqlContext_";
  protected final String TEXT_27 = " = new org.apache.spark.sql.SQLContext(";
  protected final String TEXT_28 = ");" + NL + "\torg.apache.spark.sql.DataFrame df_";
  protected final String TEXT_29 = "_";
  protected final String TEXT_30 = " =" + NL + "\t\tsqlContext_";
  protected final String TEXT_31 = ".createDataFrame(rdd_";
  protected final String TEXT_32 = ", ";
  protected final String TEXT_33 = ".class);" + NL + "" + NL + "\t// 3. Call predictor" + NL + "\torg.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_34 = "> rdd_";
  protected final String TEXT_35 = " =" + NL + "\t\t(org.talend.datascience.mllib.classification.NaiveBayes.predictor(" + NL + "\t\t\tdf_";
  protected final String TEXT_36 = "_";
  protected final String TEXT_37 = ".rdd(), // rdd<Row>" + NL + "\t\t\tdf_";
  protected final String TEXT_38 = "_";
  protected final String TEXT_39 = ".schema(), // schema" + NL + "\t\t\tmodel_";
  protected final String TEXT_40 = " // model" + NL + "\t\t).toJavaRDD()).map(new ";
  protected final String TEXT_41 = "_FromRowTo";
  protected final String TEXT_42 = "());";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

TSqlRowUtil tSqlRowUtil = new TSqlRowUtil(node);
IConnection inConn = tSqlRowUtil.getIncomingConnections().get(0);
String pmmlModelPath = ElementParameterParser.getValue(node, "__PMML_MODEL_PATH__");

String inStructName = codeGenArgument.getRecordStructName(inConn);
String outStructName = codeGenArgument.getRecordStructName(tSqlRowUtil.getOutgoingConnection());
boolean useConfigurationComponent = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_STORAGE_CONFIGURATION__"));
String ctx = ("SPARKSTREAMING".equals(node.getComponent().getType())) ? "ctx.sparkContext().sc()" : "ctx.sc()" ;


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
    if(useConfigurationComponent){//import from dfs


    stringBuffer.append(TEXT_3);
    stringBuffer.append(ctx);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(pmmlModelPath);
    stringBuffer.append(TEXT_5);
    
    }else{//import from local

    stringBuffer.append(TEXT_6);
    stringBuffer.append(pmmlModelPath);
    stringBuffer.append(TEXT_7);
    
    }

    stringBuffer.append(TEXT_8);
    
if("SPARKSTREAMING".equals(node.getComponent().getType())
	&& !org.talend.designer.common.tmap.LookupUtil.isNodeInBatchMode(node)) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(tSqlRowUtil.getOutgoingConnection().getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_25);
    
}else{

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(ctx);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(tSqlRowUtil.getOutgoingConnection().getName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_42);
    
}

    return stringBuffer.toString();
  }
}
