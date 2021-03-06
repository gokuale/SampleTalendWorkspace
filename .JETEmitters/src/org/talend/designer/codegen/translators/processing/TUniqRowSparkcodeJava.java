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

public class TUniqRowSparkcodeJava
{
  protected static String nl;
  public static synchronized TUniqRowSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniqRowSparkcodeJava result = new TUniqRowSparkcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        public static class ";
  protected final String TEXT_2 = "LowerCaseMap_Function implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = ">, ";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ">{" + NL + "" + NL + "            private ContextProperties context = null;" + NL + "" + NL + "            public ";
  protected final String TEXT_7 = "LowerCaseMap_Function(JobConf job) {" + NL + "                this.context = new ContextProperties(job);" + NL + "            }" + NL + "" + NL + "                public scala.Tuple2<";
  protected final String TEXT_8 = ", ";
  protected final String TEXT_9 = "> call(" + NL + "                    scala.Tuple2<";
  protected final String TEXT_10 = ", ";
  protected final String TEXT_11 = "> data)" + NL + "                    throws java.lang.Exception {" + NL;
  protected final String TEXT_12 = NL + "                        ";
  protected final String TEXT_13 = " outConnFrom_";
  protected final String TEXT_14 = " = new ";
  protected final String TEXT_15 = "();" + NL + "                        outConnFrom_";
  protected final String TEXT_16 = " = data._2;" + NL;
  protected final String TEXT_17 = NL + "                        ";
  protected final String TEXT_18 = " key = new ";
  protected final String TEXT_19 = "(";
  protected final String TEXT_20 = " " + NL + "                                data._1._1().toLowerCase()";
  protected final String TEXT_21 = " " + NL + "                                data._1._1()";
  protected final String TEXT_22 = " " + NL + "                                    data._1._";
  protected final String TEXT_23 = "().toLowerCase(),";
  protected final String TEXT_24 = " " + NL + "                                    data._1._";
  protected final String TEXT_25 = "(),";
  protected final String TEXT_26 = " " + NL + "                                data._1._";
  protected final String TEXT_27 = "().toLowerCase()";
  protected final String TEXT_28 = " " + NL + "                                 data._1._";
  protected final String TEXT_29 = "()";
  protected final String TEXT_30 = NL + "                    );" + NL + "" + NL + "                return new scala.Tuple2<";
  protected final String TEXT_31 = ", ";
  protected final String TEXT_32 = ">(key, outConnFrom_";
  protected final String TEXT_33 = ");" + NL + "            }" + NL + "        }";
  protected final String TEXT_34 = NL + "        public static class ";
  protected final String TEXT_35 = "UniqueMap_Function implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<";
  protected final String TEXT_36 = ", Iterable<";
  protected final String TEXT_37 = ">>, ";
  protected final String TEXT_38 = ", ";
  protected final String TEXT_39 = ">{" + NL + "" + NL + "            private ContextProperties context = null;" + NL + "" + NL + "            public ";
  protected final String TEXT_40 = "UniqueMap_Function(JobConf job) {" + NL + "                this.context = new ContextProperties(job);" + NL + "            }" + NL + "" + NL + "                public scala.Tuple2<";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = "> call(" + NL + "                    scala.Tuple2<";
  protected final String TEXT_43 = ", Iterable<";
  protected final String TEXT_44 = ">> data)" + NL + "                    throws java.lang.Exception {" + NL + "                    ";
  protected final String TEXT_45 = NL + "                    ";
  protected final String TEXT_46 = " outConnFrom_";
  protected final String TEXT_47 = " = new ";
  protected final String TEXT_48 = "();" + NL + "                    java.util.Iterator<";
  protected final String TEXT_49 = "> iterator = data._2().iterator();" + NL + "                    if(iterator.hasNext()){" + NL + "                            outConnFrom_";
  protected final String TEXT_50 = " = iterator.next();" + NL + "                    }" + NL;
  protected final String TEXT_51 = NL + "                    ";
  protected final String TEXT_52 = " key = data._1();" + NL + "" + NL + "                return new scala.Tuple2<";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = ">(key, outConnFrom_";
  protected final String TEXT_55 = ");" + NL + "                }" + NL + "        }" + NL;
  protected final String TEXT_56 = NL + "        public static class ";
  protected final String TEXT_57 = "DuplicateFlatMap_Function implements org.apache.spark.api.java.function.PairFlatMapFunction<scala.Tuple2<";
  protected final String TEXT_58 = ", Iterable<";
  protected final String TEXT_59 = ">>, ";
  protected final String TEXT_60 = ", ";
  protected final String TEXT_61 = ">{" + NL + "" + NL + "            private ContextProperties context = null;" + NL + "" + NL + "            public ";
  protected final String TEXT_62 = "DuplicateFlatMap_Function(JobConf job) {" + NL + "                this.context = new ContextProperties(job);" + NL + "            }" + NL + "" + NL + "            public Iterable<scala.Tuple2<";
  protected final String TEXT_63 = ", ";
  protected final String TEXT_64 = ">> call(scala.Tuple2<";
  protected final String TEXT_65 = ", Iterable<";
  protected final String TEXT_66 = ">> data){" + NL + "" + NL + "                    java.util.Iterator<";
  protected final String TEXT_67 = "> iterator = data._2().iterator();";
  protected final String TEXT_68 = NL + "                    ";
  protected final String TEXT_69 = " key = data._1();";
  protected final String TEXT_70 = NL + "                    ";
  protected final String TEXT_71 = " value;" + NL + "                    java.util.List<scala.Tuple2<";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = ">> outputList = " + NL + "                    new ArrayList<scala.Tuple2<";
  protected final String TEXT_74 = ", ";
  protected final String TEXT_75 = ">>();" + NL + "" + NL + "                    iterator.next();" + NL + "" + NL + "                    if(!iterator.hasNext()){" + NL + "                        return outputList;" + NL + "                    } else{" + NL + "                        while(iterator.hasNext()){" + NL + "                            value = iterator.next();" + NL + "                            outputList.add(new scala.Tuple2<";
  protected final String TEXT_76 = ", ";
  protected final String TEXT_77 = ">(key,value));";
  protected final String TEXT_78 = NL + "                                break;";
  protected final String TEXT_79 = NL + "                        }" + NL + "                    }" + NL + "" + NL + "                return outputList;" + NL + "" + NL + "            }" + NL + "        }";
  protected final String TEXT_80 = NL;
  protected final String TEXT_81 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;

final INode node = (INode) codeGenArgument.getArgument();
final IBigDataNode bigDataNode = (IBigDataNode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();
final String onlyOnceEachDuplicatedKey = ElementParameterParser.getValue(node, "__ONLY_ONCE_EACH_DUPLICATED_KEY__");

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

    // MAP 1 : If we have String and non case sensitive columns in unique columns we need
    // an additional map to convert columns to lowercase for later grouping.
    if(hasStringNotCaseSensitiveCol){
        // find the real unique columns and how they are represented in the incoming tuple
        java.util.List<Boolean> uniqueCols = uniqueColsKeyAttributes;
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_19);
    
                        // special case where we have a single column
                        if(tdummySize == 1){
                            if(uniqueCols.get(0).booleanValue()){
    
    stringBuffer.append(TEXT_20);
    
                            }else{
    
    stringBuffer.append(TEXT_21);
    
                            }
                        }else if(tdummySize > 1){
                            for(int i=0; i<=tdummySize-2; i++){
                                if(uniqueCols.get(i).booleanValue()){
    
    stringBuffer.append(TEXT_22);
    stringBuffer.append(i+1);
    stringBuffer.append(TEXT_23);
    
                                }else{
    
    stringBuffer.append(TEXT_24);
    stringBuffer.append(i+1);
    stringBuffer.append(TEXT_25);
    
                                }

                            }
                            if(uniqueCols.get(tdummySize-1).booleanValue()){
    
    stringBuffer.append(TEXT_26);
    stringBuffer.append(tdummySize);
    stringBuffer.append(TEXT_27);
    
                            }else{
    
    stringBuffer.append(TEXT_28);
    stringBuffer.append(tdummySize);
    stringBuffer.append(TEXT_29);
    
                            }
                        }
    
    stringBuffer.append(TEXT_30);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
    }

    // MAP 2 : if we have a unique output flow Create output rdd for unique flow.
    // gets the key and the first value in the iterable list
    if(hasUniqueOutput){
    
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
    }

    if(hasDuplicateOutput) {

    // MAP 3 : If we have duplicate output flow Create output rdd for duplicate flow from the filtered rdd
    // gets the key and one or more of the duplicate values
    
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(SparkFunctionUtil.getKeyType(keyList, "BOTH"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_77);
    
                            // Practically doing a MAP and not a Flat MAP if true
                            if(("true").equals(onlyOnceEachDuplicatedKey)){
    
    stringBuffer.append(TEXT_78);
    
                            }
    
    stringBuffer.append(TEXT_79);
    
    }
}
// TODO : Do nothing or map input to output
// If we don't have any key attributes in unique key table
// we can ignore the whole generation (no unique filtering)
else{
    
}

    stringBuffer.append(TEXT_80);
    stringBuffer.append(TEXT_81);
    return stringBuffer.toString();
  }
}
