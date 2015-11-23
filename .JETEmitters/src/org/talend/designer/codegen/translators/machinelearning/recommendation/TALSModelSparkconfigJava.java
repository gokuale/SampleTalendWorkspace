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
import org.talend.core.model.process.IBigDataNode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TALSModelSparkconfigJava
{
  protected static String nl;
  public static synchronized TALSModelSparkconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TALSModelSparkconfigJava result = new TALSModelSparkconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "org.talend.datascience.mllib.recommendation.ALSParams params_";
  protected final String TEXT_2 = " =" + NL + "\tnew org.talend.datascience.mllib.recommendation.ALSParams(";
  protected final String TEXT_3 = ",";
  protected final String TEXT_4 = ",";
  protected final String TEXT_5 = ",";
  protected final String TEXT_6 = ",";
  protected final String TEXT_7 = ", -1, -1);" + NL + "" + NL + "org.apache.spark.mllib.recommendation.MatrixFactorizationModel model_";
  protected final String TEXT_8 = " = " + NL + "\torg.talend.datascience.mllib.recommendation.CollaborativeFiltering.modelBuilder(" + NL + "\t\trdd_";
  protected final String TEXT_9 = ".map(new ";
  protected final String TEXT_10 = "RowStructToRating_Function(job)).rdd()," + NL + "\t\t";
  protected final String TEXT_11 = "," + NL + "\t\tparams_";
  protected final String TEXT_12 = NL + "\t);" + NL + "" + NL + "model_";
  protected final String TEXT_13 = ".save(ctx.sc(), ";
  protected final String TEXT_14 = "+\"/\"+";
  protected final String TEXT_15 = ");" + NL;
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final IBigDataNode bigDataNode = (IBigDataNode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

String inConnName = node.getIncomingConnections().get(0).getUniqueName();

Double trainingPercentage = Double.parseDouble(ElementParameterParser.getValue(node, "__TRAIN_PERCENTAGE__"));
Integer nbFactors = Integer.parseInt(ElementParameterParser.getValue(node, "__NB_FACTORS__"));
Integer nbIteration = Integer.parseInt(ElementParameterParser.getValue(node, "__NB_ITERATION__"));
Double lambda = Double.parseDouble(ElementParameterParser.getValue(node, "__LAMBDA__"));
Boolean implicitFlag = Boolean.valueOf(ElementParameterParser.getValue(node, "__IMPLICIT_PREFS__"));
Double alpha = implicitFlag?Double.parseDouble(ElementParameterParser.getValue(node, "__ALPHA__")):1;
String parquetModelPath = ElementParameterParser.getValue(node, "__MODEL_PATH__");
String parquetModelName = ElementParameterParser.getValue(node, "__MODEL_NAME__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(nbFactors);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(nbIteration);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(lambda);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(implicitFlag);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(alpha);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(trainingPercentage);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(parquetModelPath);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(parquetModelName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
