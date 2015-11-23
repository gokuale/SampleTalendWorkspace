package org.talend.designer.codegen.translators.processing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.talend.designer.spark.generator.utils.SparkFunctionUtil;

public class TUniqRowSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TUniqRowSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniqRowSparkstreamingconfigJava result = new TUniqRowSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        ";
  protected final String TEXT_3 = "<";
  protected final String TEXT_4 = ", ";
  protected final String TEXT_5 = "> rdd_lowercase_";
  protected final String TEXT_6 = " =" + NL + "        rdd_";
  protected final String TEXT_7 = ".mapToPair(new ";
  protected final String TEXT_8 = "LowerCaseMap_Function(job));" + NL;
  protected final String TEXT_9 = NL + "        ";
  protected final String TEXT_10 = "<";
  protected final String TEXT_11 = ", Iterable<";
  protected final String TEXT_12 = ">> rdd_grouped_";
  protected final String TEXT_13 = " =" + NL + "        rdd_lowercase_";
  protected final String TEXT_14 = ".groupByKey();";
  protected final String TEXT_15 = NL + "        ";
  protected final String TEXT_16 = "<";
  protected final String TEXT_17 = ", Iterable<";
  protected final String TEXT_18 = ">> rdd_grouped_";
  protected final String TEXT_19 = " =" + NL + "        rdd_";
  protected final String TEXT_20 = ".groupByKey();";
  protected final String TEXT_21 = NL + "        ";
  protected final String TEXT_22 = "<";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = "> rdd_";
  protected final String TEXT_25 = " = " + NL + "        rdd_grouped_";
  protected final String TEXT_26 = ".mapToPair(new ";
  protected final String TEXT_27 = "UniqueMap_Function(job));" + NL;
  protected final String TEXT_28 = NL + "        ";
  protected final String TEXT_29 = "<";
  protected final String TEXT_30 = ", ";
  protected final String TEXT_31 = "> rdd_";
  protected final String TEXT_32 = " = rdd_grouped_";
  protected final String TEXT_33 = ".flatMapToPair(new ";
  protected final String TEXT_34 = "DuplicateFlatMap_Function(job));";
  protected final String TEXT_35 = NL + "        ";
  protected final String TEXT_36 = "<";
  protected final String TEXT_37 = ", ";
  protected final String TEXT_38 = "> rdd_";
  protected final String TEXT_39 = " = rdd_";
  protected final String TEXT_40 = ";";
  protected final String TEXT_41 = NL + "        ";
  protected final String TEXT_42 = "<";
  protected final String TEXT_43 = ", ";
  protected final String TEXT_44 = "> rdd_";
  protected final String TEXT_45 = " = rdd_";
  protected final String TEXT_46 = ";";
  protected final String TEXT_47 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;

final INode node = (INode) codeGenArgument.getArgument();
final IBigDataNode bigDataNode = (IBigDataNode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();
final String onlyOnceEachDuplicatedKey = ElementParameterParser.getValue(node, "__ONLY_ONCE_EACH_DUPLICATED_KEY__");
String returnedType = "org.apache.spark.api.java.JavaPairRDD";

boolean isNodeInBatchMode = org.talend.designer.common.tmap.LookupUtil.isNodeInBatchMode(node);
if("SPARKSTREAMING".equals(node.getComponent().getType()) && !isNodeInBatchMode) {
    returnedType = "org.apache.spark.streaming.api.java.JavaPairDStream";
}

// Used to generate the Pre/Post tDummymaps. Used here to get key types instead of regenerating them manually.
java.util.Map<String, java.util.List<org.talend.core.model.metadata.IMetadataColumn>> keyList = bigDataNode.getKeyList();
// Size of incoming column list from tdummy MAP
int tdummySize = 0;
if (keyList != null) {
    java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList = keyList.get("BOTH");
    if (columnList != null) {
        tdummySize = columnList.size();
    }
}

// Input Connections
IConnection inMainCon = null;
List<? extends IConnection> connsIn = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
if (connsIn == null || connsIn.size() == 0 ){
    return "";
} else{
    inMainCon = connsIn.get(0);
}
final String incomingConnectionName = inMainCon.getName();
final String inConnTypeName = codeGenArgument.getRecordStructName(inMainCon);
final IMetadataTable inMetadata = inMainCon.getMetadataTable(); 
final List<IMetadataColumn> inColumns = inMetadata.getListColumns();

// Output Connections
IConnection uniqueOutput = null;
IConnection duplicateOutput = null;
boolean hasUniqueOutput = false;
boolean hasDuplicateOutput = false;
List<? extends IConnection> outputCons = node.getOutgoingConnections();
if (outputCons == null || outputCons.size() == 0 ){
    return "";
} else{
    for(IConnection iconnection: outputCons){
        if(("UNIQUE").equals(iconnection.getConnectorName())){
            uniqueOutput = iconnection;
            hasUniqueOutput = true;
        }
        if(("DUPLICATE").equals(iconnection.getConnectorName())){
            duplicateOutput = iconnection;
            hasDuplicateOutput = true;
        }
    }
}
final String uniqueOutputConnectionName = hasUniqueOutput ? uniqueOutput.getName() : null;
final String duplicateOutputConnectionName = hasDuplicateOutput ? duplicateOutput.getName() : null;

// String columns in incoming schema
java.util.List<String> stringCols = new java.util.ArrayList<String>();
for(IMetadataColumn inColumn : inColumns){
    if(("id_String").equals(inColumn.getTalendType())){
        stringCols.add(inColumn.getLabel());
    }
}

// List of columns in Unique key table which are Key Attributes
// Boolean : true if the column is a String column and case sensitive, false otherwise
// preserving the order of columns in schema. Element 1 in list corresponds to col1 in schema
java.util.List<Boolean> uniqueColsKeyAttributes = new java.util.ArrayList<Boolean>();
// If at least one of the columns is a key attribute
boolean hasKeyAttributeOn = false;
// If at least one column is String and not case sentitive
boolean hasStringNotCaseSensitiveCol = false;
// Map of columns in Unique key table
java.util.List<java.util.Map<String, String>> uniqKeyCols = (java.util.List<java.util.Map<String,String>>)ElementParameterParser.getObjectValue(node, "__UNIQUE_KEY__");
for(int i = 0; i < uniqKeyCols.size(); i++){
    java.util.Map<String, String> line = uniqKeyCols.get(i);
    if(("true").equals(line.get("KEY_ATTRIBUTE"))){
        hasKeyAttributeOn = true;
        if((("false").equals(line.get("CASE_SENSITIVE")))&&(stringCols.contains(line.get("SCHEMA_COLUMN")))){
            hasStringNotCaseSensitiveCol = true;
            uniqueColsKeyAttributes.add(new Boolean(true));
        }else{
            uniqueColsKeyAttributes.add(new Boolean(false));
        }
    }
}

if(hasKeyAttributeOn){

    // If we have String and non case sensitive columns in unique columns we need
    // an additional map to convert columns to lowercase for later grouping.
    if(hasStringNotCaseSensitiveCol){
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(returnedType);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(incomingConnectionName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(returnedType);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
    }else {
    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(returnedType);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(incomingConnectionName);
    stringBuffer.append(TEXT_20);
    
    }

    // Unique output
    if(hasUniqueOutput){
    
    stringBuffer.append(TEXT_21);
    stringBuffer.append(returnedType);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(uniqueOutputConnectionName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
    }

    // Duplicate output
    if (hasDuplicateOutput) {
    
    stringBuffer.append(TEXT_28);
    stringBuffer.append(returnedType);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(duplicateOutputConnectionName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
    }
}
// TODO : Do nothing or map input to output
// If we don't have any key attributes in unique key table
// we can ignore the whole generation (no unique filtering)
else{
    if(hasUniqueOutput){

    stringBuffer.append(TEXT_35);
    stringBuffer.append(returnedType);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(uniqueOutputConnectionName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(incomingConnectionName);
    stringBuffer.append(TEXT_40);
    
    }
    if(hasDuplicateOutput){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(returnedType);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(duplicateOutputConnectionName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(incomingConnectionName);
    stringBuffer.append(TEXT_46);
    
    }
}

    stringBuffer.append(TEXT_47);
    return stringBuffer.toString();
  }
}
