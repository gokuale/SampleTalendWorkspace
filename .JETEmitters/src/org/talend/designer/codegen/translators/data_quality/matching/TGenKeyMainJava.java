package org.talend.designer.codegen.translators.data_quality.matching;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TGenKeyMainJava
{
  protected static String nl;
  public static synchronized TGenKeyMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGenKeyMainJava result = new TGenKeyMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    String winKey_";
  protected final String TEXT_2 = " = \"\";" + NL + "    String strInput_";
  protected final String TEXT_3 = " = null;";
  protected final String TEXT_4 = NL + "      strInput_";
  protected final String TEXT_5 = " = \"\";";
  protected final String TEXT_6 = NL + "        strInput_";
  protected final String TEXT_7 = " = TypeConvert.";
  protected final String TEXT_8 = "2String(";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ", ";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "        strInput_";
  protected final String TEXT_13 = " = TypeConvert.";
  protected final String TEXT_14 = "2String(";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "        strInput_";
  protected final String TEXT_18 = " = org.talend.windowkey.AlgoBox.";
  protected final String TEXT_19 = "(strInput_";
  protected final String TEXT_20 = NL + "              , ";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "      strInput_";
  protected final String TEXT_23 = " = org.talend.windowkey.AlgoBox.";
  protected final String TEXT_24 = "(strInput_";
  protected final String TEXT_25 = NL + "              , ";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "        strInput_";
  protected final String TEXT_28 = " = org.talend.windowkey.AlgoBox.";
  protected final String TEXT_29 = "(strInput_";
  protected final String TEXT_30 = NL + "              , ";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "      winKey_";
  protected final String TEXT_33 = " += (strInput_";
  protected final String TEXT_34 = " == null) ? \"\" : strInput_";
  protected final String TEXT_35 = ";";
  protected final String TEXT_36 = NL + "        ";
  protected final String TEXT_37 = ".T_GEN_KEY = winKey_";
  protected final String TEXT_38 = ";";
  protected final String TEXT_39 = NL + "        ";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = ";";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
List<? extends IConnection> outConns = node.getOutgoingSortedConnections();

if (inConns.size() > 0 && outConns.size() > 0){
 if(outConns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
  String inConnName = inConns.get(0).getName();
  String outConnName = outConns.get(0).getName();
  List<IMetadataTable> metaTables = node.getMetadataList();
  
  if (metaTables != null && metaTables.size() > 0){
    IMetadataTable metaTable = metaTables.get(0);
    List<IMetadataColumn> columns = metaTable.getListColumns();
    
    /* to store the funcations that do not have the second parameter */
    List<String> listNoParamAlgo = new java.util.ArrayList<String>();
    listNoParamAlgo.addAll(java.util.Arrays.asList("first_Char_EW", "soundex", "metaphone", "doublemetaphone", "exact", "fingerPrintKey", "nGramKey", "colognePhonetic"));
    listNoParamAlgo.addAll(java.util.Arrays.asList("lowerCase", "upperCase", "removeDiacriticalMarks", "removeDMAndLowerCase", "removeDMAndUpperCase"));
    
    List<Map<String, String>> listKeyAlgo = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__ALGO__");
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
    for (Map<String, String> algo : listKeyAlgo){ // T01
      
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
      String colName = algo.get("PRECOLUMN");
      String preAlgoName = algo.get("PRE_ALGO");
      String preAlgoPara = algo.get("PRE_VALUE");
      String keyAlgoName = algo.get("KEY_ALGO");
      String keyAlgoPara = algo.get("KEY_VALUE");
      String postAlgoName = algo.get("POST_ALGO");
      String postAlgoPara = algo.get("POST_VALUE");
      
      IMetadataColumn metaColumn = metaTable.getColumn(colName);
      String inTypeWhole = JavaTypesManager.getTypeToGenerate(metaColumn.getTalendType(), metaColumn.isNullable());
      String inType = inTypeWhole.contains(".") ? inTypeWhole.substring(inTypeWhole.lastIndexOf(".") + 1) : inTypeWhole;
      inType = ("byte[]".equals(inType)) ? "byteArray" : inType;
      
      if ("Date".equals(inType)){
      
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(inType);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(metaColumn.getPattern());
    stringBuffer.append(TEXT_11);
    } else {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(inType);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_16);
    
      }
      // pre algo
      if (!"NON_ALGO".equals(preAlgoName)){
        
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(preAlgoName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    if (!listNoParamAlgo.contains(preAlgoName)){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(preAlgoPara);
    }
    stringBuffer.append(TEXT_21);
    
      }
      
      // key algo
      
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(keyAlgoName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    if (!listNoParamAlgo.contains(keyAlgoName)){
    stringBuffer.append(TEXT_25);
    stringBuffer.append(keyAlgoPara);
    }
    stringBuffer.append(TEXT_26);
    
      
      // post algo
      if (!"NON_ALGO".equals(postAlgoName)){
        
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(postAlgoName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    if (!listNoParamAlgo.contains(postAlgoName)){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(postAlgoPara);
    }
    stringBuffer.append(TEXT_31);
    
      }
      
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
    } // T01
    
    // output
    for (IMetadataColumn column : columns){
      String colName = column.getLabel();
      
      if ("T_GEN_KEY".equals(colName)){
      
    stringBuffer.append(TEXT_36);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
      } else {
      
    stringBuffer.append(TEXT_39);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_43);
    
      }
    }
  }
 }
}

    return stringBuffer.toString();
  }
}
