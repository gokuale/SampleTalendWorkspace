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
import org.talend.core.model.process.IBigDataNode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TNaiveBayesModelSparkconfigJava
{
  protected static String nl;
  public static synchronized TNaiveBayesModelSparkconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNaiveBayesModelSparkconfigJava result = new TNaiveBayesModelSparkconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "org.apache.spark.sql.SQLContext sqlContext_";
  protected final String TEXT_2 = " = new org.apache.spark.sql.SQLContext(ctx);" + NL + "" + NL + "// Create dataFrame from incoming rdd & rowStruct" + NL + "org.apache.spark.sql.DataFrame df_";
  protected final String TEXT_3 = "_";
  protected final String TEXT_4 = " = " + NL + "\tsqlContext_";
  protected final String TEXT_5 = ".createDataFrame(rdd_";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ".class);" + NL + "" + NL + "// Create dictionary" + NL + "List<scala.Tuple3<String, org.talend.datascience.types.DataMiningType, String[]>> dictionary_";
  protected final String TEXT_8 = NL + "\t= new ArrayList<scala.Tuple3<String, org.talend.datascience.types.DataMiningType, String[]>>();";
  protected final String TEXT_9 = NL + "\t\t// add the feature column: ";
  protected final String TEXT_10 = " in dictionary" + NL + "\t\tdictionary_";
  protected final String TEXT_11 = ".add(" + NL + "\t\t\tnew scala.Tuple3<String, org.talend.datascience.types.DataMiningType, String[]>(" + NL + "\t\t\t\t\"";
  protected final String TEXT_12 = "\"," + NL + "\t\t\t\tnew org.talend.datascience.types.";
  protected final String TEXT_13 = "()," + NL + "\t\t\t\t";
  protected final String TEXT_14 = ".split(\";\")" + NL + "\t\t\t)" + NL + "\t\t);";
  protected final String TEXT_15 = NL + "\t// add the label in the end of dictionary" + NL + "\tdictionary_";
  protected final String TEXT_16 = ".add(" + NL + "\t\tnew scala.Tuple3<String, org.talend.datascience.types.DataMiningType, String[]>(" + NL + "\t\t\t\t\"";
  protected final String TEXT_17 = "\"," + NL + "\t\t\t\tnew org.talend.datascience.types.Categorical()," + NL + "\t\t\t\t";
  protected final String TEXT_18 = ".split(\";\")" + NL + "\t\t)" + NL + "\t);" + NL + "" + NL + "\t// Call Naive Bayes modelBuilder for training & evaluate the model" + NL + "\t@SuppressWarnings(\"unchecked\")" + NL + "\torg.apache.spark.mllib.classification.talend.NaiveBayesRegularRecordsModel model_";
  protected final String TEXT_19 = " = " + NL + "\t\torg.talend.datascience.mllib.classification.NaiveBayes.modelBuilder(" + NL + "\t\t\tdf_";
  protected final String TEXT_20 = "_";
  protected final String TEXT_21 = ".rdd(), // rdd<Row>" + NL + "\t\t\tdf_";
  protected final String TEXT_22 = "_";
  protected final String TEXT_23 = ".schema(), // schema" + NL + "\t\t\t";
  protected final String TEXT_24 = ", // training percentage " + NL + "\t\t\tdictionary_";
  protected final String TEXT_25 = "// dictionary" + NL + "\t\t\t\t.toArray((scala.Tuple3<String, org.talend.datascience.types.DataMiningType, String[]>[]) new scala.Tuple3[dictionary_";
  protected final String TEXT_26 = ".size()])" + NL + "\t\t);" + NL + "" + NL + "\t// Export model in PMML format" + NL + "\t";
  protected final String TEXT_27 = NL + "\t        org.talend.datascience.mllib.pmml.exports.ModelExporter.toPMML(ctx.sc(), model_";
  protected final String TEXT_28 = ", ";
  protected final String TEXT_29 = " +\"/\"+ ";
  protected final String TEXT_30 = ");" + NL + "\t";
  protected final String TEXT_31 = NL + "            org.talend.datascience.mllib.pmml.exports.ModelExporter.toPMML(model_";
  protected final String TEXT_32 = ", ";
  protected final String TEXT_33 = " +\"/\"+ ";
  protected final String TEXT_34 = ");" + NL + "\t";
  protected final String TEXT_35 = NL + "\t";
  protected final String TEXT_36 = NL + "\tthrow new java.lang.Exception(\"Error: illegal number of Label! Should have one and only one input column mark as Label! Please check the Columns type table in ";
  protected final String TEXT_37 = ".\");";
  protected final String TEXT_38 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();
IConnection inConn = node.getIncomingConnections().get(0);
String inConnTypeName = codeGenArgument.getRecordStructName(inConn);

Double trainingPercentage = Double.parseDouble(ElementParameterParser.getValue(node, "__TRAIN_PERCENTAGE__"));
String pmmlModelPath = ElementParameterParser.getValue(node, "__PMML_MODEL_PATH__");
String pmmlModelName = ElementParameterParser.getValue(node, "__PMML_MODEL_NAME__");
List<Map<String, String>> listMapColType = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__COLUMNS_TYPE__");
boolean useConfigurationComponent = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_STORAGE_CONFIGURATION__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
Boolean flagLabel = false;
String strLabelVect = "";
String labelName = "";

for (Map<String, String> mapCol : listMapColType){
	String miningType = "";
	String strValuesVect = "";
	String columnName = mapCol.get("SCHEMA_COLUMN");
	String colUsage = mapCol.get("COLUMNS_USAGE");
	//match miningType & strValuesVect for the column
	if ("FEATURE_CONTINUOUS".equals(colUsage)){
		miningType = "Continuous";
		strValuesVect = mapCol.get("BINS_VECTOR");
	}// end if ("FEATURE_CONTINUOUS".equals(colUsage))
	if ("FEATURE_CATEGORICAL".equals(colUsage)){
		miningType = "Categorical";
		strValuesVect = mapCol.get("CATEGORIES_VECTOR");
	}// end if ("FEATURE_CATEGORICAL".equals(colUsage))		
	if ("LABEL".equals(colUsage)){
		if(flagLabel){// Illegal case: already have one column mark as Label
			flagLabel = !flagLabel;
			break;
		} else{
			flagLabel = !flagLabel;
			labelName = columnName;
			strLabelVect = mapCol.get("LABEL_VECTOR");
		}
	}// end if ("LABEL".equals(colUsage))
	if(miningType != "" && strValuesVect != ""){// if it's not a unused column or label column	

    stringBuffer.append(TEXT_9);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(miningType);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(strValuesVect);
    stringBuffer.append(TEXT_14);
    
	}// end if(miningType != null && strValuesVect != null && !flagLabel)
}// end for (Map<String, String> mapCol : listMapColType)
if(flagLabel){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(labelName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(strLabelVect);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(trainingPercentage);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
	    if(useConfigurationComponent){// export to dfs
	
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(pmmlModelPath);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(pmmlModelName);
    stringBuffer.append(TEXT_30);
    
	    }else{// export to Local FS
	
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(pmmlModelPath);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(pmmlModelName);
    stringBuffer.append(TEXT_34);
    
	    }
	
    stringBuffer.append(TEXT_35);
    
}else{

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
}// end if(flagLabel) else..

    stringBuffer.append(TEXT_38);
    return stringBuffer.toString();
  }
}
