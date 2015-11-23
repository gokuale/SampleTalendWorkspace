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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TALSModelSparkcodeJava
{
  protected static String nl;
  public static synchronized TALSModelSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TALSModelSparkcodeJava result = new TALSModelSparkcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "public static class ";
  protected final String TEXT_2 = "RowStructToRating_Function implements " + NL + "\torg.apache.spark.api.java.function.Function<";
  protected final String TEXT_3 = ", org.apache.spark.mllib.recommendation.Rating> {" + NL + "" + NL + "\tprivate ContextProperties context = null;" + NL + "\t" + NL + "\tpublic ";
  protected final String TEXT_4 = "RowStructToRating_Function(JobConf job) {" + NL + "\t\tthis.context = new ContextProperties(job);" + NL + "\t}" + NL + "\t" + NL + "\tpublic org.apache.spark.mllib.recommendation.Rating call(";
  protected final String TEXT_5 = " ";
  protected final String TEXT_6 = ") throws java.lang.Exception {" + NL + "\t\t" + NL + "\t\t\tInteger userId = ";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = ";" + NL + "\t\t\tInteger productId = ";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ";" + NL + "\t\t\tDouble rating = ";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = ";" + NL + "\t\t\t" + NL + "\t\t\treturn new org.apache.spark.mllib.recommendation.Rating(userId,productId,rating); " + NL + "\t\t" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final IBigDataNode bigDataNode = (IBigDataNode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();
final INode previous_node = node.getIncomingConnections().get(0).getSource();

IConnection inConn = node.getIncomingConnections().get(0);
String inConnName = inConn.getUniqueName();
String inConnTypeName = codeGenArgument.getRecordStructName(inConn);

List<IMetadataTable> prevMetadatas = previous_node.getMetadataList();

Map<String, String> mapFeatureCol = new HashMap<String, String> ();
if ((prevMetadatas!=null)&&(prevMetadatas.size()>0)) {
	IMetadataTable prevMetadata = prevMetadatas.get(0);
	if (prevMetadata!=null) {
		List<Map<String, String>> inputCols = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FEATURE_COLUMNS__");
		for (IMetadataColumn col : prevMetadata.getListColumns()) {
			for (Map<String, String> fCol : inputCols) {
				mapFeatureCol.put(fCol.get("FEATURE_TYPE"),fCol.get("INPUT_COLUMN"));
			}
		} // end of for (IMetadataColumn col : metadata.getListColumns())
	}//end of if (prevMetadata!=null)
}// end of if ((prevMetadata!=null)&&(prevMetadata.size()>0))


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(mapFeatureCol.get("U"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(mapFeatureCol.get("P"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(mapFeatureCol.get("R"));
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
