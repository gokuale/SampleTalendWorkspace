package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.EConnectionType;
import java.util.List;
import java.util.Map;

public class TRecordMatchingInBeginJava
{
  protected static String nl;
  public static synchronized TRecordMatchingInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRecordMatchingInBeginJava result = new TRecordMatchingInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        // ###############################" + NL + "        // # Lookup's keys initialization" + NL + "        org.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_2 = "LookupManager<";
  protected final String TEXT_3 = "Struct> " + NL + "          tHash_Lookup_";
  protected final String TEXT_4 = " = (org.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_5 = "LookupManager<";
  protected final String TEXT_6 = "Struct>) ((org.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_7 = "LookupManager<";
  protected final String TEXT_8 = "Struct>) " + NL + "            globalMap.get(\"tHash_Lookup_";
  protected final String TEXT_9 = "\"));" + NL;
  protected final String TEXT_10 = NL + "        ";
  protected final String TEXT_11 = "Struct ";
  protected final String TEXT_12 = "HashKey = new ";
  protected final String TEXT_13 = "Struct();" + NL + "        // ############################### " + NL + "        int nb_matches_";
  protected final String TEXT_14 = " = 0;" + NL + "        int nb_pMatches_";
  protected final String TEXT_15 = " = 0;" + NL + "        int nb_nMatches_";
  protected final String TEXT_16 = " = 0;  ";
  protected final String TEXT_17 = " " + NL + "          double[] arrAttrWeights_";
  protected final String TEXT_18 = " = new double[";
  protected final String TEXT_19 = "];" + NL + "          String[][] arrMatcherAlgoName_";
  protected final String TEXT_20 = " = new String[";
  protected final String TEXT_21 = "][2];" + NL + "           org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption[] arrMatchHandleNull_";
  protected final String TEXT_22 = " = new org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption[";
  protected final String TEXT_23 = "];" + NL + "          ";
  protected final String TEXT_24 = NL + "            arrAttrWeights_";
  protected final String TEXT_25 = "[";
  protected final String TEXT_26 = "] = ";
  protected final String TEXT_27 = ";" + NL + "            ";
  protected final String TEXT_28 = NL + "              arrMatcherAlgoName_";
  protected final String TEXT_29 = "[";
  protected final String TEXT_30 = "][0] = \"";
  protected final String TEXT_31 = "\";";
  protected final String TEXT_32 = NL + "              arrMatcherAlgoName_";
  protected final String TEXT_33 = "[";
  protected final String TEXT_34 = "] = new String[]{\"";
  protected final String TEXT_35 = "\", ";
  protected final String TEXT_36 = "};";
  protected final String TEXT_37 = NL + "        arrMatchHandleNull_";
  protected final String TEXT_38 = "[";
  protected final String TEXT_39 = "] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.";
  protected final String TEXT_40 = ";";
  protected final String TEXT_41 = NL + "          org.talend.dataquality.record.linkage.attribute.IAttributeMatcher[]" + NL + "            attributeMatchers_";
  protected final String TEXT_42 = " = new org.talend.dataquality.record.linkage.attribute.IAttributeMatcher[";
  protected final String TEXT_43 = "];" + NL + "            " + NL + "          for (int i_";
  protected final String TEXT_44 = " = 0; i_";
  protected final String TEXT_45 = " < ";
  protected final String TEXT_46 = "; i_";
  protected final String TEXT_47 = "++){" + NL + "            org.talend.dataquality.record.linkage.constant.AttributeMatcherType type_";
  protected final String TEXT_48 = " = org.talend.dataquality.record.linkage.constant.AttributeMatcherType.get(arrMatcherAlgoName_";
  protected final String TEXT_49 = "[i_";
  protected final String TEXT_50 = "][0]);" + NL + "            attributeMatchers_";
  protected final String TEXT_51 = "[i_";
  protected final String TEXT_52 = "] = org.talend.dataquality.record.linkage.attribute.AttributeMatcherFactory.createMatcher(type_";
  protected final String TEXT_53 = ", arrMatcherAlgoName_";
  protected final String TEXT_54 = "[i_";
  protected final String TEXT_55 = "][1]);" + NL + "            attributeMatchers_";
  protected final String TEXT_56 = "[i_";
  protected final String TEXT_57 = "].setNullOption(arrMatchHandleNull_";
  protected final String TEXT_58 = "[i_";
  protected final String TEXT_59 = "]);" + NL + "            " + NL + "          }" + NL + "          org.talend.dataquality.record.linkage.record.IRecordMatcher " + NL + "            recordMatcher_";
  protected final String TEXT_60 = " = org.talend.dataquality.record.linkage.record.RecordMatcherFactory.createMatcher(org.talend.dataquality.record.linkage.constant.RecordMatcherType.simpleVSRMatcher);      " + NL + "          recordMatcher_";
  protected final String TEXT_61 = ".setRecordSize(";
  protected final String TEXT_62 = ");" + NL + "          recordMatcher_";
  protected final String TEXT_63 = ".setAttributeWeights(arrAttrWeights_";
  protected final String TEXT_64 = ");" + NL + "          recordMatcher_";
  protected final String TEXT_65 = ".setAttributeMatchers(attributeMatchers_";
  protected final String TEXT_66 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
cid = cid.replace("_RecordMatchingIn", "");
List<IMetadataTable> metadatas = node.getMetadataList();

if ((metadatas != null) && (metadatas.size() > 0)) {
  IMetadataTable metadata = metadatas.get(0);
  
  if (metadata != null){
    List< ? extends IConnection> connsIn = node.getIncomingConnections().get(0).getSource().getIncomingConnections();
    
    for (IConnection connIn: connsIn){
        
      if (connIn.getLineStyle().equals(EConnectionType.FLOW_REF)){
        String Sorted = "";
        List<Map<String, String>> listBlocking = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BLOCKING_DEFINITION__");
        
        if (listBlocking != null && listBlocking.size() > 0){        
          Sorted = "Sorted";
        }
        String connInName = connIn.getName();
        
    stringBuffer.append(TEXT_1);
    stringBuffer.append(Sorted);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(Sorted);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(Sorted);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
        List<Map<String, String>> listMapJoinCols = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JOIN_KEY__");
        
        if (listMapJoinCols != null && listMapJoinCols.size() > 0){
          int iJoinSize = listMapJoinCols.size();
          
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(iJoinSize);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(iJoinSize);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(iJoinSize);
    stringBuffer.append(TEXT_23);
    
          for (int i = 0; i < iJoinSize; i++){
            Map<String, String> mapJoinCol =  listMapJoinCols.get(i);
            String sMatcherAlgorithm = mapJoinCol.get("MATCHING_TYPE");
            
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(Double .valueOf(mapJoinCol.get("CONFIDENCE_WEIGHT")));
    stringBuffer.append(TEXT_27);
    if (!"custom".equalsIgnoreCase(sMatcherAlgorithm)) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(sMatcherAlgorithm);
    stringBuffer.append(TEXT_31);
    } else { 
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(sMatcherAlgorithm);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(mapJoinCol.get("CUSTOM_MATCHER"));
    stringBuffer.append(TEXT_36);
    }
             
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(mapJoinCol.get("HANDLE_NULL"));
    stringBuffer.append(TEXT_40);
    
          }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(iJoinSize);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(iJoinSize);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(iJoinSize);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
        }
      }
    }
  }
}

    return stringBuffer.toString();
  }
}
