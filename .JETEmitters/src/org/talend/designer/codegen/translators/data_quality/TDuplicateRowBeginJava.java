package org.talend.designer.codegen.translators.data_quality;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.talend.core.model.utils.NodeUtil;

public class TDuplicateRowBeginJava
{
  protected static String nl;
  public static synchronized TDuplicateRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDuplicateRowBeginJava result = new TDuplicateRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    final String distributionName_";
  protected final String TEXT_3 = " = String.valueOf(\"";
  protected final String TEXT_4 = "\");" + NL + "  " + NL + "    final double duplicatePercentage_";
  protected final String TEXT_5 = " = Double.valueOf(\"";
  protected final String TEXT_6 = "\");" + NL + "    " + NL + "    if(duplicatePercentage_";
  protected final String TEXT_7 = " < 0 || duplicatePercentage_";
  protected final String TEXT_8 = " > 100){" + NL + "        throw new Exception(\"The percentage of duplicated records must be between 0 and 100.\");" + NL + "    }" + NL + "    " + NL + "    final double expectation_";
  protected final String TEXT_9 = " = Double.valueOf(\"";
  protected final String TEXT_10 = "\");    " + NL + "    " + NL + "    int times_";
  protected final String TEXT_11 = ";" + NL + "        " + NL + "    final org.talend.dataquality.duplicating.FieldModifier modifier_";
  protected final String TEXT_12 = " = " + NL + "                new org.talend.dataquality.duplicating.FieldModifier();" + NL + "    " + NL + "    final org.talend.dataquality.standardization.action.SynonymReplaceAction synonymReplaceAction_";
  protected final String TEXT_13 = "= new org.talend.dataquality.standardization.action.SynonymReplaceAction();";
  protected final String TEXT_14 = "        " + NL + "    modifier_";
  protected final String TEXT_15 = ".setSeed(Long.valueOf(";
  protected final String TEXT_16 = "));";
  protected final String TEXT_17 = "   " + NL + "    " + NL + "    Object tmpValue_";
  protected final String TEXT_18 = " = null;" + NL + "    " + NL + "    org.talend.dataquality.duplicating.AbstractDuplicator<";
  protected final String TEXT_19 = "Struct, ";
  protected final String TEXT_20 = "Struct> duplicator_";
  protected final String TEXT_21 = " " + NL + "        = new org.talend.dataquality.duplicating.AbstractDuplicator<";
  protected final String TEXT_22 = "Struct, ";
  protected final String TEXT_23 = "Struct>" + NL + "         (expectation_";
  protected final String TEXT_24 = ", duplicatePercentage_";
  protected final String TEXT_25 = "/100, distributionName_";
  protected final String TEXT_26 = "        " + NL + "        , Long.valueOf(";
  protected final String TEXT_27 = ")";
  protected final String TEXT_28 = "         " + NL + "         ) {" + NL + "    " + NL + "        @Override" + NL + "        protected ";
  protected final String TEXT_29 = "Struct generateOutput(";
  protected final String TEXT_30 = "Struct originalStruct, boolean isOriginal) {";
  protected final String TEXT_31 = NL + "            ";
  protected final String TEXT_32 = "Struct tmpStruct = new ";
  protected final String TEXT_33 = "Struct();" + NL;
  protected final String TEXT_34 = "      " + NL + "                tmpStruct.";
  protected final String TEXT_35 = " = originalStruct.";
  protected final String TEXT_36 = ";";
  protected final String TEXT_37 = NL + NL + "            if (isOriginal) {" + NL + "                tmpStruct.ORIGINAL_MARK = true;" + NL + "            } else {" + NL + "                modifyOutput(tmpStruct);            " + NL + "                tmpStruct.ORIGINAL_MARK = false;" + NL + "            }" + NL + "            return tmpStruct;" + NL + "        }" + NL + "        " + NL + "        private void modifyOutput(";
  protected final String TEXT_38 = "Struct ";
  protected final String TEXT_39 = "){" + NL + "        " + NL + "            Object tmpValue_";
  protected final String TEXT_40 = " = null;";
  protected final String TEXT_41 = "      " + NL + "            if(Double.valueOf(\"";
  protected final String TEXT_42 = "\") > getRandom().nextDouble()){";
  protected final String TEXT_43 = NL + "             tmpValue_";
  protected final String TEXT_44 = " =synonymReplaceAction_";
  protected final String TEXT_45 = ".run(";
  protected final String TEXT_46 = NL + "                     ";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = "," + NL + "                     getRandom().nextInt(Integer.valueOf(\"";
  protected final String TEXT_49 = "\"))+1," + NL + "                     String.valueOf(";
  protected final String TEXT_50 = "),modifier_";
  protected final String TEXT_51 = ".getRandom());" + NL + "                        ";
  protected final String TEXT_52 = NL + "            tmpValue_";
  protected final String TEXT_53 = " = modifier_";
  protected final String TEXT_54 = ".generateDuplicate(";
  protected final String TEXT_55 = NL + "                    ";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = "," + NL + "                    org.talend.dataquality.duplicating.FieldModifier.Function.";
  protected final String TEXT_58 = "," + NL + "                    getRandom().nextInt(Integer.valueOf(\"";
  protected final String TEXT_59 = "\"))+1," + NL + "                    String.valueOf(";
  protected final String TEXT_60 = ") ); " + NL + "            ";
  protected final String TEXT_61 = NL + "                        if(tmpValue_";
  protected final String TEXT_62 = " == null){";
  protected final String TEXT_63 = NL + "                            ";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = " = null;" + NL + "                        }else{                                              ";
  protected final String TEXT_66 = "              ";
  protected final String TEXT_67 = NL + "                                ";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = " = tmpValue_";
  protected final String TEXT_70 = ".toString();";
  protected final String TEXT_71 = NL + "                                if(tmpValue_";
  protected final String TEXT_72 = " instanceof java.util.Date){";
  protected final String TEXT_73 = NL + "                                    ";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = " = (java.util.Date)tmpValue_";
  protected final String TEXT_76 = ";" + NL + "                                }else{";
  protected final String TEXT_77 = NL + "                                    ";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = " = ParserUtils.parseTo_Date(tmpValue_";
  protected final String TEXT_80 = ".toString(), ";
  protected final String TEXT_81 = ");" + NL + "                                }";
  protected final String TEXT_82 = NL + "                                ";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = " = tmpValue_";
  protected final String TEXT_85 = ".toString().getBytes();";
  protected final String TEXT_86 = "                                  ";
  protected final String TEXT_87 = NL + "                                ";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = " = ParserUtils.parseTo_";
  protected final String TEXT_90 = "(tmpValue_";
  protected final String TEXT_91 = ".toString()); ";
  protected final String TEXT_92 = "  " + NL + "                        }" + NL + "                    }                   ";
  protected final String TEXT_93 = NL + "        " + NL + "        " + NL + "        " + NL + "        }        " + NL + "" + NL + "    };" + NL + "    " + NL + NL;
  protected final String TEXT_94 = NL + "    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String percentageDuplicatesString = ElementParameterParser.getValue(node, "__PERCENTAGE_DUPLICATES__");
    
    String distributionNameString = ElementParameterParser.getValue(node, "__DISTRIBUTION_NAME__");
    String distributionExpectationString = ElementParameterParser.getValue(node, "__AVERAGE_GROUP_SIZE__");
    String randomSeedString = ElementParameterParser.getValue(node, "__RANDOM_SEED__");
    
    List<Map<String, String>> modifTableList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MODIF_TABLE__");
    
    String incomingConnName = null, outgoingConnName = null;    
    IMetadataTable inputMetadataTable = null, outputMetadataTable = null;
    java.util.List<IMetadataColumn> inputColumns = null, outputColumns = null;

    List<? extends IConnection> incomingConnections = node.getIncomingConnections();
    if (incomingConnections != null && !incomingConnections.isEmpty()) {    
        for (IConnection conn : incomingConnections) {
            if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                INode preNode = conn.getSource();
                while(NodeUtil.isDataAutoPropagated(preNode)&&!preNode.isSubProcessStart()) {     
                   List<? extends IConnection> preincomingConnections = preNode.getIncomingConnections();
                   if (preincomingConnections != null && !preincomingConnections.isEmpty()) {    
                      for (IConnection preNodeConn : preincomingConnections) {
                          conn=preNodeConn;
                          preNode=preNodeConn.getSource();
                          break;
                      }
                   } else {
                      break;
                   }
                }
                incomingConnName = conn.getName();              
                inputMetadataTable = conn.getMetadataTable();
                inputColumns = inputMetadataTable.getListColumns();
                break;
            }
        }
    }  
    
    List<? extends IConnection> outgoingConnections = node.getOutgoingConnections();
    if (outgoingConnections != null && !outgoingConnections.isEmpty()) {    
        for (IConnection conn : outgoingConnections) {
            if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                outgoingConnName = conn.getName();              
                outputMetadataTable = conn.getMetadataTable();
                outputColumns = outputMetadataTable.getListColumns();
                break;
            }
        }
    }  
                    
  
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(distributionNameString);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(percentageDuplicatesString);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(distributionExpectationString);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
if(randomSeedString.length() > 0 && !"\"\"".equals(randomSeedString)){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(randomSeedString);
    stringBuffer.append(TEXT_16);
    
}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    
if(randomSeedString.length() > 0 && !"\"\"".equals(randomSeedString)){

    stringBuffer.append(TEXT_26);
    stringBuffer.append(randomSeedString);
    stringBuffer.append(TEXT_27);
    
}

    stringBuffer.append(TEXT_28);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_33);
     
            for(int i = 0; i < inputColumns.size(); i++) {          
                IMetadataColumn column = inputColumns.get(i);
            
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_36);
    
            }
            
    stringBuffer.append(TEXT_37);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
     
        for(int i = 0; i < inputColumns.size(); i++) {          
            IMetadataColumn column = inputColumns.get(i);
            
            for(Map<String, String> columnModifMap : modifTableList){
                if(column.getLabel().equalsIgnoreCase(columnModifMap.get("INPUT_COLUMN"))){ 
                    String modifRate = columnModifMap.get("MODIF_RATE");
                    String function = columnModifMap.get("FUNCTION");
                    String maxModifCount = columnModifMap.get("MAX_MODIF_COUNT");
                    String extraParam = columnModifMap.get("SYNONYM_INDEX_PATH");
                    
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                            
            
    stringBuffer.append(TEXT_41);
    stringBuffer.append(modifRate);
    stringBuffer.append(TEXT_42);
    
             if(function.equals("SYNONYM_REPLACE")){
             
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(maxModifCount);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(extraParam);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
            }else{
            
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(function);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(maxModifCount);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(extraParam);
    stringBuffer.append(TEXT_60);
    
            }
            
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_65);
                              
                            if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
                            
    stringBuffer.append(TEXT_66);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
                            } else if(javaType == JavaTypesManager.DATE) { // Date
                                String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                            
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_81);
    
                            } else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]
                            
    stringBuffer.append(TEXT_82);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
                            } else {
                            
    stringBuffer.append(TEXT_86);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_89);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
                            } 
                            
    stringBuffer.append(TEXT_92);
    
                } 
            }
        }
        
    stringBuffer.append(TEXT_93);
    stringBuffer.append(TEXT_94);
    return stringBuffer.toString();
  }
}
