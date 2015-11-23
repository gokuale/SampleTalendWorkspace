package org.talend.designer.codegen.translators.data_quality.matching;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.EConnectionType;
import java.util.List;
import java.util.Map;

public class TRecordMatchingBeginJava
{
  protected static String nl;
  public static synchronized TRecordMatchingBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRecordMatchingBeginJava result = new TRecordMatchingBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        // # Lookup's keys initialization" + NL + "        org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_2 = "Struct> tHash_";
  protected final String TEXT_3 = "  =" + NL + "         (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_4 = "Struct>) globalMap.get(\"tHash_Lookup_";
  protected final String TEXT_5 = "\");" + NL + "        tHash_";
  protected final String TEXT_6 = ".initGet(); ";
  protected final String TEXT_7 = NL + "        ";
  protected final String TEXT_8 = "Struct ";
  protected final String TEXT_9 = "HashKey = new ";
  protected final String TEXT_10 = "Struct();" + NL + "        // ###############################" + NL + "        int nb_matches_";
  protected final String TEXT_11 = " = 0;" + NL + "        int nb_pMatches_";
  protected final String TEXT_12 = " = 0;" + NL + "        int nb_nMatches_";
  protected final String TEXT_13 = " = 0;";
  protected final String TEXT_14 = " " + NL + "          double[] arrAttrWeights_";
  protected final String TEXT_15 = " = new double[";
  protected final String TEXT_16 = "];" + NL + "          String[][] arrMatcherAlgoName_";
  protected final String TEXT_17 = " = new String[";
  protected final String TEXT_18 = "][2];" + NL + "          Object cfWeight_";
  protected final String TEXT_19 = " = null;" + NL + "                     org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption[] arrMatchHandleNull_";
  protected final String TEXT_20 = " = new org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption[";
  protected final String TEXT_21 = "];" + NL + "          " + NL + "          ";
  protected final String TEXT_22 = NL + "            cfWeight_";
  protected final String TEXT_23 = " = ";
  protected final String TEXT_24 = ";" + NL + "            if(cfWeight_";
  protected final String TEXT_25 = "!=null){" + NL + "            \tarrAttrWeights_";
  protected final String TEXT_26 = "[";
  protected final String TEXT_27 = "] = Double.valueOf(";
  protected final String TEXT_28 = ");" + NL + "            }else{" + NL + "            \tthrow new Exception(\"Confidence Weight should not be null.\");" + NL + "            }" + NL + "            ";
  protected final String TEXT_29 = NL + "              arrMatcherAlgoName_";
  protected final String TEXT_30 = "[";
  protected final String TEXT_31 = "][0] = \"";
  protected final String TEXT_32 = "\";";
  protected final String TEXT_33 = NL + "              arrMatcherAlgoName_";
  protected final String TEXT_34 = "[";
  protected final String TEXT_35 = "] = new String[]{\"";
  protected final String TEXT_36 = "\", ";
  protected final String TEXT_37 = "};";
  protected final String TEXT_38 = NL + "        arrMatchHandleNull_";
  protected final String TEXT_39 = "[";
  protected final String TEXT_40 = "] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.";
  protected final String TEXT_41 = ";";
  protected final String TEXT_42 = NL + "          org.talend.dataquality.record.linkage.attribute.IAttributeMatcher[]" + NL + "            attributeMatchers_";
  protected final String TEXT_43 = " = new org.talend.dataquality.record.linkage.attribute.IAttributeMatcher[";
  protected final String TEXT_44 = "];" + NL + "            " + NL + "          for (int i_";
  protected final String TEXT_45 = " = 0; i_";
  protected final String TEXT_46 = " < ";
  protected final String TEXT_47 = "; i_";
  protected final String TEXT_48 = "++){" + NL + "            org.talend.dataquality.record.linkage.constant.AttributeMatcherType type_";
  protected final String TEXT_49 = " = org.talend.dataquality.record.linkage.constant.AttributeMatcherType.get(arrMatcherAlgoName_";
  protected final String TEXT_50 = "[i_";
  protected final String TEXT_51 = "][0]);" + NL + "            attributeMatchers_";
  protected final String TEXT_52 = "[i_";
  protected final String TEXT_53 = "] = org.talend.dataquality.record.linkage.attribute.AttributeMatcherFactory.createMatcher(type_";
  protected final String TEXT_54 = ", arrMatcherAlgoName_";
  protected final String TEXT_55 = "[i_";
  protected final String TEXT_56 = "][1]);" + NL + "            attributeMatchers_";
  protected final String TEXT_57 = "[i_";
  protected final String TEXT_58 = "].setNullOption(arrMatchHandleNull_";
  protected final String TEXT_59 = "[i_";
  protected final String TEXT_60 = "]);" + NL + "          }" + NL + "          org.talend.dataquality.record.linkage.record.IRecordMatcher recordMatcher_";
  protected final String TEXT_61 = " " + NL + "            = org.talend.dataquality.record.linkage.record.RecordMatcherFactory.createMatcher(org.talend.dataquality.record.linkage.constant.RecordMatcherType.simpleVSRMatcher);      " + NL + "          recordMatcher_";
  protected final String TEXT_62 = ".setRecordSize(";
  protected final String TEXT_63 = ");" + NL + "          recordMatcher_";
  protected final String TEXT_64 = ".setAttributeWeights(arrAttrWeights_";
  protected final String TEXT_65 = ");" + NL + "          recordMatcher_";
  protected final String TEXT_66 = ".setAttributeMatchers(attributeMatchers_";
  protected final String TEXT_67 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
  IMetadataTable metadata = metadatas.get(0);
  if (metadata != null){
    List< ? extends IConnection> connsIn = node.getIncomingConnections();
    
    for (IConnection connIn: connsIn){
        
      if (connIn.getLineStyle().equals(EConnectionType.FLOW_REF)){
        String connInName = connIn.getName();
        
    stringBuffer.append(TEXT_1);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(connInName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
        List<Map<String, String>> listMapJoinCols = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JOIN_KEY__");
        
        if (listMapJoinCols != null && listMapJoinCols.size() > 0){
          int iJoinSize = listMapJoinCols.size();
          
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(iJoinSize);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(iJoinSize);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(iJoinSize);
    stringBuffer.append(TEXT_21);
    
          for (int i = 0; i < iJoinSize; i++){
            Map<String, String> mapJoinCol =  listMapJoinCols.get(i);
            String sMatcherAlgorithm = mapJoinCol.get("MATCHING_TYPE");
            
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(mapJoinCol.get("CONFIDENCE_WEIGHT"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(mapJoinCol.get("CONFIDENCE_WEIGHT"));
    stringBuffer.append(TEXT_28);
    if (!"custom".equalsIgnoreCase(sMatcherAlgorithm)) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(sMatcherAlgorithm);
    stringBuffer.append(TEXT_32);
    } else { 
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(sMatcherAlgorithm);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(mapJoinCol.get("CUSTOM_MATCHER"));
    stringBuffer.append(TEXT_37);
    }
             
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(mapJoinCol.get("HANDLE_NULL"));
    stringBuffer.append(TEXT_41);
    
          }
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(iJoinSize);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(iJoinSize);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(iJoinSize);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
        }
      }
    }
  }
}

    return stringBuffer.toString();
  }
}
