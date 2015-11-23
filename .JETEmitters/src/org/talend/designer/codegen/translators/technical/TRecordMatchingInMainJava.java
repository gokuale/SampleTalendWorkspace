package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TRecordMatchingInMainJava
{
  protected static String nl;
  public static synchronized TRecordMatchingInMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRecordMatchingInMainJava result = new TRecordMatchingInMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        ";
  protected final String TEXT_2 = " = new ";
  protected final String TEXT_3 = "Struct();";
  protected final String TEXT_4 = NL + "                ";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ";";
  protected final String TEXT_8 = NL + "                ";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ";";
  protected final String TEXT_12 = NL + "                        ";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = ";";
  protected final String TEXT_17 = NL + "                        ";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = ";";
  protected final String TEXT_22 = NL + "                        ";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = NL + "                        ";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = " = null;    ";
  protected final String TEXT_30 = NL + "                    ";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = " = ";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = ";";
  protected final String TEXT_35 = NL + "                    ";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = ";";
  protected final String TEXT_40 = NL + "                    ";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = " = null;    ";
  protected final String TEXT_43 = NL + "    String[] arrMainData_";
  protected final String TEXT_44 = " = new String[";
  protected final String TEXT_45 = "];" + NL + "    String[] arrLookupData_";
  protected final String TEXT_46 = " = new String[";
  protected final String TEXT_47 = "];            " + NL + "    final double UNACCEPTABLE_THRESHOLD_";
  protected final String TEXT_48 = " = Double.valueOf(";
  protected final String TEXT_49 = ");" + NL + "    final double ACCEPTABLE_THRESHOLD_";
  protected final String TEXT_50 = " = Double.valueOf(";
  protected final String TEXT_51 = ");" + NL + "        " + NL + "    if (";
  protected final String TEXT_52 = " == null) {";
  protected final String TEXT_53 = NL + "        ";
  protected final String TEXT_54 = " = new ";
  protected final String TEXT_55 = "Struct();" + NL + "    }" + NL + "    SortableRow_";
  protected final String TEXT_56 = " rsc_";
  protected final String TEXT_57 = ";" + NL + "    tHash_Lookup_";
  protected final String TEXT_58 = ".initGet();" + NL + "    fsi_";
  protected final String TEXT_59 = ".initGet();" + NL + "    " + NL + "    while (fsi_";
  protected final String TEXT_60 = ".hasNext()) {        ";
  protected final String TEXT_61 = NL + "        ";
  protected final String TEXT_62 = "Struct currentLookupRow_";
  protected final String TEXT_63 = " = null;";
  protected final String TEXT_64 = NL + "        ";
  protected final String TEXT_65 = "Struct savedMatchRow_";
  protected final String TEXT_66 = " = null;";
  protected final String TEXT_67 = NL + "        ";
  protected final String TEXT_68 = "Struct savedPMatchRow_";
  protected final String TEXT_69 = " = null;" + NL + "        String sMatchingDists_";
  protected final String TEXT_70 = " = null, savedRowDists_";
  protected final String TEXT_71 = " = null, savedPRowDists_";
  protected final String TEXT_72 = " = null;    " + NL + "        double matchingProba_";
  protected final String TEXT_73 = " = 0, savedRowProba_";
  protected final String TEXT_74 = " = 0, savedPRowProba_";
  protected final String TEXT_75 = " = 0;" + NL + "        boolean bMatch_";
  protected final String TEXT_76 = " = false, bPMatch_";
  protected final String TEXT_77 = " = false, bHasMatchRec_";
  protected final String TEXT_78 = " = false,bPHasMatchRec_";
  protected final String TEXT_79 = " = false;" + NL + "" + NL + "        rsc_";
  protected final String TEXT_80 = " = (SortableRow_";
  protected final String TEXT_81 = ") fsi_";
  protected final String TEXT_82 = ".next();" + NL + "        rsc_";
  protected final String TEXT_83 = ".copyDataTo(";
  protected final String TEXT_84 = ");";
  protected final String TEXT_85 = " " + NL + "                        arrMainData_";
  protected final String TEXT_86 = "[";
  protected final String TEXT_87 = "] = FormatterUtils.format_Date(";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = ", ";
  protected final String TEXT_90 = "); ";
  protected final String TEXT_91 = NL + "                        //primitive type case" + NL + "                        arrMainData_";
  protected final String TEXT_92 = "[";
  protected final String TEXT_93 = "] = String.valueOf(";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "                        //not primitive type case                                 " + NL + "                        arrMainData_";
  protected final String TEXT_97 = "[";
  protected final String TEXT_98 = "] = ";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = "==null?null:String.valueOf(";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = " " + NL + "            ";
  protected final String TEXT_104 = NL + "            ";
  protected final String TEXT_105 = "HashKey.";
  protected final String TEXT_106 = " = rsc_";
  protected final String TEXT_107 = ".exprKey_";
  protected final String TEXT_108 = "__";
  protected final String TEXT_109 = ";";
  protected final String TEXT_110 = NL + "        tHash_Lookup_";
  protected final String TEXT_111 = ".lookup(";
  protected final String TEXT_112 = "HashKey);" + NL + "        boolean forceLoop";
  protected final String TEXT_113 = " = true;" + NL + "            " + NL + "        while (tHash_Lookup_";
  protected final String TEXT_114 = ".hasNext() || forceLoop";
  protected final String TEXT_115 = "){";
  protected final String TEXT_116 = NL + "                    ";
  protected final String TEXT_117 = " = null;";
  protected final String TEXT_118 = NL + "            if (tHash_Lookup_";
  protected final String TEXT_119 = ".hasNext()) {" + NL + "                forceLoop";
  protected final String TEXT_120 = " = false;" + NL + "                currentLookupRow_";
  protected final String TEXT_121 = " = tHash_Lookup_";
  protected final String TEXT_122 = ".next();" + NL + "                " + NL + "                //";
  protected final String TEXT_123 = NL + "                 // if (bHasOutputMatchRec_";
  protected final String TEXT_124 = "){" + NL + "                    //    continue;" + NL + "                 // }" + NL + "                " + NL + "                ";
  protected final String TEXT_125 = " " + NL + "                                arrLookupData_";
  protected final String TEXT_126 = "[";
  protected final String TEXT_127 = "] = FormatterUtils.format_Date(currentLookupRow_";
  protected final String TEXT_128 = ".";
  protected final String TEXT_129 = ", ";
  protected final String TEXT_130 = "); ";
  protected final String TEXT_131 = NL + "                                    //primitive type case" + NL + "                                    arrLookupData_";
  protected final String TEXT_132 = "[";
  protected final String TEXT_133 = "] = String.valueOf(currentLookupRow_";
  protected final String TEXT_134 = ".";
  protected final String TEXT_135 = ");";
  protected final String TEXT_136 = NL + "                                    //not primitive type case                                 " + NL + "                                    arrLookupData_";
  protected final String TEXT_137 = "[";
  protected final String TEXT_138 = "] = currentLookupRow_";
  protected final String TEXT_139 = ".";
  protected final String TEXT_140 = "==null?null:String.valueOf(currentLookupRow_";
  protected final String TEXT_141 = ".";
  protected final String TEXT_142 = ");";
  protected final String TEXT_143 = " " + NL + "           ";
  protected final String TEXT_144 = NL + "                matchingProba_";
  protected final String TEXT_145 = " = recordMatcher_";
  protected final String TEXT_146 = ".getMatchingWeight(arrMainData_";
  protected final String TEXT_147 = ", arrLookupData_";
  protected final String TEXT_148 = ");" + NL + "                bMatch_";
  protected final String TEXT_149 = " = bPMatch_";
  protected final String TEXT_150 = " = true;" + NL + "                " + NL + "                if (ACCEPTABLE_THRESHOLD_";
  protected final String TEXT_151 = " <= matchingProba_";
  protected final String TEXT_152 = "){" + NL + "                    bPMatch_";
  protected final String TEXT_153 = " = false;" + NL + "                }else if (UNACCEPTABLE_THRESHOLD_";
  protected final String TEXT_154 = " < matchingProba_";
  protected final String TEXT_155 = " && matchingProba_";
  protected final String TEXT_156 = " < ACCEPTABLE_THRESHOLD_";
  protected final String TEXT_157 = "){                     " + NL + "                    bMatch_";
  protected final String TEXT_158 = " = false;    " + NL + "                }else if (matchingProba_";
  protected final String TEXT_159 = " <= UNACCEPTABLE_THRESHOLD_";
  protected final String TEXT_160 = "){" + NL + "                    bMatch_";
  protected final String TEXT_161 = " = bPMatch_";
  protected final String TEXT_162 = " = false;" + NL + "                }" + NL + "                " + NL + "                if (bMatch_";
  protected final String TEXT_163 = " || bPMatch_";
  protected final String TEXT_164 = " ){" + NL + "                    StringBuffer sb_";
  protected final String TEXT_165 = " = new StringBuffer(10);" + NL + "                    for(double v_";
  protected final String TEXT_166 = " : recordMatcher_";
  protected final String TEXT_167 = ".getCurrentAttributeMatchingWeights())" + NL + "                    sb_";
  protected final String TEXT_168 = ".append(Double.toString(v_";
  protected final String TEXT_169 = ")).append(\"|\");" + NL + "                    sb_";
  protected final String TEXT_170 = ".deleteCharAt(sb_";
  protected final String TEXT_171 = ".length() - 1);" + NL + "                    sMatchingDists_";
  protected final String TEXT_172 = " = new String(sb_";
  protected final String TEXT_173 = ");" + NL + "                }" + NL + "                " + NL + "                // save current match or possible match row for output" + NL + "                if (bMatch_";
  protected final String TEXT_174 = "){ " + NL + "                    // note: no additional condition needed for last match strategy           ";
  protected final String TEXT_175 = NL + "                        if (!bHasMatchRec_";
  protected final String TEXT_176 = "){";
  protected final String TEXT_177 = NL + "                        if (savedMatchRow_";
  protected final String TEXT_178 = "==null" + NL + "                                ||matchingProba_";
  protected final String TEXT_179 = ">savedRowProba_";
  protected final String TEXT_180 = "){";
  protected final String TEXT_181 = "    " + NL + "                            /*save the match row of lookup flow*/" + NL + "                            savedMatchRow_";
  protected final String TEXT_182 = " = new ";
  protected final String TEXT_183 = "Struct();";
  protected final String TEXT_184 = NL + "                                savedMatchRow_";
  protected final String TEXT_185 = ".";
  protected final String TEXT_186 = " = currentLookupRow_";
  protected final String TEXT_187 = ".";
  protected final String TEXT_188 = ";";
  protected final String TEXT_189 = NL + "                            /*save the MATCHING_DISTANCES*/" + NL + "                            savedRowDists_";
  protected final String TEXT_190 = " = sMatchingDists_";
  protected final String TEXT_191 = ";" + NL + "                            /*save the MATCHING_WEIGHT*/" + NL + "                            savedRowProba_";
  protected final String TEXT_192 = " = matchingProba_";
  protected final String TEXT_193 = "; " + NL + "                            bHasMatchRec_";
  protected final String TEXT_194 = " = true;                       ";
  protected final String TEXT_195 = NL + "                        }";
  protected final String TEXT_196 = "                      " + NL + "                }" + NL + "" + NL + "                if (bPMatch_";
  protected final String TEXT_197 = " && !bMatch_";
  protected final String TEXT_198 = "){                        ";
  protected final String TEXT_199 = NL + "                        if (!bPHasMatchRec_";
  protected final String TEXT_200 = "){";
  protected final String TEXT_201 = NL + "                        if (savedPMatchRow_";
  protected final String TEXT_202 = "==null" + NL + "                                ||matchingProba_";
  protected final String TEXT_203 = ">savedPRowProba_";
  protected final String TEXT_204 = "){";
  protected final String TEXT_205 = NL + "                            /*save the possible match row of lookup flow*/" + NL + "                            savedPMatchRow_";
  protected final String TEXT_206 = " = new ";
  protected final String TEXT_207 = "Struct();";
  protected final String TEXT_208 = NL + "                                savedPMatchRow_";
  protected final String TEXT_209 = ".";
  protected final String TEXT_210 = " = currentLookupRow_";
  protected final String TEXT_211 = ".";
  protected final String TEXT_212 = ";";
  protected final String TEXT_213 = NL + "                            /*save the MATCHING_DISTANCES*/" + NL + "                            savedPRowDists_";
  protected final String TEXT_214 = " = sMatchingDists_";
  protected final String TEXT_215 = ";" + NL + "                            /*save the MATCHING_WEIGHT*/" + NL + "                            savedPRowProba_";
  protected final String TEXT_216 = " = matchingProba_";
  protected final String TEXT_217 = ";" + NL + "                            bPHasMatchRec_";
  protected final String TEXT_218 = " = true;       ";
  protected final String TEXT_219 = NL + "                        }";
  protected final String TEXT_220 = "                           " + NL + "                }" + NL + "            }" + NL + "            //} to be suitable for IS_MULTIPLYING_OUTPUTS" + NL + "" + NL + "            // output matched rows";
  protected final String TEXT_221 = NL + "                    if(bMatch_";
  protected final String TEXT_222 = "){";
  protected final String TEXT_223 = NL + "                        nb_matches_";
  protected final String TEXT_224 = "++;" + NL + "                    }";
  protected final String TEXT_225 = NL + "                    // at the end of lookup, output last/best matches if needed" + NL + "                    if (!tHash_Lookup_";
  protected final String TEXT_226 = ".hasNext() && savedMatchRow_";
  protected final String TEXT_227 = " != null){";
  protected final String TEXT_228 = NL + "                        nb_matches_";
  protected final String TEXT_229 = "++;" + NL + "                    }                        ";
  protected final String TEXT_230 = NL + "        " + NL + "            // output possibly matched rows";
  protected final String TEXT_231 = "  ";
  protected final String TEXT_232 = NL + "                    if(bPMatch_";
  protected final String TEXT_233 = "){";
  protected final String TEXT_234 = NL + "                        nb_pMatches_";
  protected final String TEXT_235 = "++;" + NL + "                    }";
  protected final String TEXT_236 = NL + "                    // at the end of lookup, output first/last/best matches if needed" + NL + "                    if (!tHash_Lookup_";
  protected final String TEXT_237 = ".hasNext() && !bHasMatchRec_";
  protected final String TEXT_238 = " && savedPMatchRow_";
  protected final String TEXT_239 = " != null){";
  protected final String TEXT_240 = NL + "                        nb_pMatches_";
  protected final String TEXT_241 = "++;" + NL + "                    }";
  protected final String TEXT_242 = "  ";
  protected final String TEXT_243 = NL + "        " + NL + "            /*none matches output, no lookup record or at the end of the loop and no matches record outputted and no possible matches record outputted*/" + NL + "            if ((forceLoop";
  protected final String TEXT_244 = ") || ( !tHash_Lookup_";
  protected final String TEXT_245 = ".hasNext() && !bHasMatchRec_";
  protected final String TEXT_246 = " && !bPHasMatchRec_";
  protected final String TEXT_247 = ") ){" + NL + "                forceLoop";
  protected final String TEXT_248 = " = false;" + NL + "                nb_nMatches_";
  protected final String TEXT_249 = "++;";
  protected final String TEXT_250 = NL + "            }" + NL;
  protected final String TEXT_251 = NL + "        {";
  protected final String TEXT_252 = NL + "        }";
  protected final String TEXT_253 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
cid = cid.replace("_RecordMatchingIn", "");

/* incoming connections of source */
List<? extends IConnection> inConns = node.getIncomingConnections();
IConnection inMainCon = null, inLookupCon = null;
String connNameMain = null, connNameLookUp = null;

for (IConnection connIn : inConns){    
    List<? extends IConnection> srcConnIncs    = connIn.getSource().getIncomingConnections();
            
    for (IConnection srcConnInc : srcConnIncs){ 
        if (srcConnInc.getLineStyle().equals(EConnectionType.FLOW_REF)){         
            inLookupCon = srcConnInc;
            connNameLookUp = srcConnInc.getName();
        } else if (srcConnInc.getLineStyle().equals(EConnectionType.FLOW_MAIN)){ 
            inMainCon = srcConnInc;    
            connNameMain = srcConnInc.getName();
        }
    }
    break;
}

if (connNameMain == null || connNameLookUp == null){
    return "";
}

/* metatable's columns */
List<String> listMainColsName = new java.util.ArrayList<String>();
List<String> listLUColsName = new java.util.ArrayList<String>();
List<String> listOutColsName = new java.util.ArrayList<String>();

for(IMetadataColumn mainColumn : inMainCon.getMetadataTable().getListColumns()){
    listMainColsName.add(mainColumn.getLabel());
}

for(IMetadataColumn luColumn : inLookupCon.getMetadataTable().getListColumns()){
    listLUColsName.add(luColumn.getLabel());
}

for(IMetadataColumn outColumn : node.getMetadataList().get(0).getListColumns()){ 
    listOutColsName.add(outColumn.getLabel()); 
}

/* outting connections */
List< ? extends IConnection> connsOut = node.getOutgoingConnections();
String connNameMatchesOut = null, connNamePosMatchOut = null, connNameNonMatchOut = null;
        
for (IConnection connOut: connsOut){

    if (connOut.isActivate()){
        String connOutCntorName = connOut.getConnectorName();
        String connOutFlowName = connOut.getName();
        
        if ("MATCHES".equals(connOutCntorName)){
            connNameMatchesOut = connOutFlowName;
        } else if ("POSSIBLE_MATCHES".equals(connOutCntorName)){
            connNamePosMatchOut = connOutFlowName;
        } else if ("NON_MATCHES".equals(connOutCntorName)){
            connNameNonMatchOut = connOutFlowName;
        }
    }
}

// read columns mapping, the defined columns data from main flow will be replaced by lookup flow if row matches(or possible matches)
boolean bReplacedByLookupRow    = "true".equals(ElementParameterParser.getValue(node, "__REPLACED_BY_LOOKUPCOL__"));
List<Map<String, String>> listReplacedColsMapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REPLACED_COLS__");
String _UNACCEPTABLE_THRESHOLD = ElementParameterParser.getValue(node, "__MINIMUM__");
String _ACCEPTABLE_THRESHOLD = ElementParameterParser.getValue(node, "__MAXIMUM__");
List<Map<String, String>> listMapJoinCols = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JOIN_KEY__");
//boolean bAllMatches    = "true".equals(ElementParameterParser.getValue(node, "__ALL_MATCHES__"));
 String sOutputStat    = ElementParameterParser.getValue(node, "__OUTPUT_STAT__");
     //System.out.println(sOutputStat+"1");
    
     
class CodeGenerator{
    public void generateOutput(String _outConnName, String _connNameLookUp, String _connNameMain
        , List<String> _listMainColsName, List<String> _listLUColsName, List<String> _listOutColsName, List<Map<String, String>> _listReplacedColsMapping
        , boolean _bReplacedByLookupRow, String _MATCHING_DISTANCES, String _MATCHING_WEIGHT, String _cid){
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(_outConnName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(_outConnName);
    stringBuffer.append(TEXT_3);
    
        for (String currentOutputCol : _listOutColsName){
            if("MATCHING_DISTANCES".equals(currentOutputCol)){
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(_outConnName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(currentOutputCol);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(_MATCHING_DISTANCES);
    stringBuffer.append(TEXT_7);
    // fetch next column
            continue;
            }
 
            if("MATCHING_WEIGHT".equals(currentOutputCol)){
            
    stringBuffer.append(TEXT_8);
    stringBuffer.append(_outConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(currentOutputCol);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(_MATCHING_WEIGHT);
    stringBuffer.append(TEXT_11);
    // fetch next column
                continue;
            }
        
            if (_bReplacedByLookupRow && (_listReplacedColsMapping.size() > 0)) {
                boolean bReadyReplaced = false;
            
                for (Map<String, String> colMapping : _listReplacedColsMapping){
                    String toReplaceCol = colMapping.get("OUTPUT_COLUMN");
                    String lookupCol = colMapping.get("LOOKUP_COLUMN");
                
                    if (_listLUColsName != null && toReplaceCol.equals(currentOutputCol)){
                    
    stringBuffer.append(TEXT_12);
    stringBuffer.append(_outConnName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(currentOutputCol);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(_connNameLookUp);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(lookupCol);
    stringBuffer.append(TEXT_16);
    
                        bReadyReplaced = true;
                        break;
                    }
                }
            
                // current column not be filled in replaced table
                if (!bReadyReplaced){
                    // main flow schema has current column, output its
                    if (_listMainColsName.contains(currentOutputCol)){
                    
    stringBuffer.append(TEXT_17);
    stringBuffer.append(_outConnName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(currentOutputCol);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(_connNameMain);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(currentOutputCol);
    stringBuffer.append(TEXT_21);
    } else if (_listLUColsName != null && _listLUColsName.contains(currentOutputCol)){ //    otherwise output its using lookup flow column
    stringBuffer.append(TEXT_22);
    stringBuffer.append(_outConnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(currentOutputCol);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(_connNameLookUp);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(currentOutputCol);
    stringBuffer.append(TEXT_26);
    } else{ // current column not in main schema and lookup schema, output NULL
    stringBuffer.append(TEXT_27);
    stringBuffer.append(_outConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(currentOutputCol);
    stringBuffer.append(TEXT_29);
    
                    }
                }
            } else {// no column defined in replaced table
                if (_listMainColsName.contains(currentOutputCol)){
                // main flow schema has current column, output its
                
    stringBuffer.append(TEXT_30);
    stringBuffer.append(_outConnName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(currentOutputCol);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(_connNameMain);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(currentOutputCol);
    stringBuffer.append(TEXT_34);
    } else if (_listLUColsName != null && _listLUColsName.contains(currentOutputCol)){ //    otherwise output its using lookup flow
    stringBuffer.append(TEXT_35);
    stringBuffer.append(_outConnName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(currentOutputCol);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(_connNameLookUp);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(currentOutputCol);
    stringBuffer.append(TEXT_39);
    } else{ // current column not in main schema and lookup schema, output NULL
    stringBuffer.append(TEXT_40);
    stringBuffer.append(_outConnName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(currentOutputCol);
    stringBuffer.append(TEXT_42);
    
                }
            }
        }
    }
} 
CodeGenerator codeGenerator = new CodeGenerator();
int iJoinSize = 0;
        
if (listMapJoinCols != null && listMapJoinCols.size() > 0){
    iJoinSize = listMapJoinCols.size(); 
    String[] arrLookupColsName = new String[iJoinSize];
    
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(iJoinSize);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(iJoinSize);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(_UNACCEPTABLE_THRESHOLD);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(_ACCEPTABLE_THRESHOLD);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_84);
    
        for (int j = 0; j < iJoinSize; j++){
            Map<String, String> mapJoinCol = listMapJoinCols.get(j);
            
            List<IMetadataColumn> mainColumns = inMainCon.getMetadataTable().getListColumns();
            String inputColumn = mapJoinCol.get("INPUT_COLUMN");         
            for (int i = 0; i < mainColumns.size(); i++) { 
                IMetadataColumn column = mainColumns.get(i);             
                if(column.getLabel().equals(inputColumn)){           
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType()); 
                    String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern(); 
                    if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0 ){
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(inputColumn);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_90);
    }else{ 
                    if(JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable())){//need to judge whether javaType is a primitive type.if it is primitive type we need to use "" instead of null
                        
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(inputColumn);
    stringBuffer.append(TEXT_95);
    }else{
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(inputColumn);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(inputColumn);
    stringBuffer.append(TEXT_102);
    }
                    } 
                } 
            }
    stringBuffer.append(TEXT_103);
    
            arrLookupColsName[j] = mapJoinCol.get("LOOKUP_COLUMN");
        }
        List<Map<String, String>> listBlocking = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BLOCKING_DEFINITION__");
    
        for (Map<String, String> mapJoinCol : listBlocking){
        
    stringBuffer.append(TEXT_104);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(mapJoinCol.get("LOOKUP_COLUMN"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(mapJoinCol.get("LOOKUP_COLUMN"));
    stringBuffer.append(TEXT_109);
    
        }
        
    stringBuffer.append(TEXT_110);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_115);
    
            // avoid to duplicate outputing
            for (IConnection connOut: connsOut){ 
                if (connOut.isActivate()){
                
    stringBuffer.append(TEXT_116);
    stringBuffer.append(connOut.getName());
    stringBuffer.append(TEXT_117);
    
                }
            } 
            
    stringBuffer.append(TEXT_118);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(connNameLookUp );
    stringBuffer.append(TEXT_122);
    
                // must fetch all rows with current key if data stored on disk. but no need to go on
                //if (!bAllMatches){
                //
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    for (int i = 0; i < iJoinSize; i++){                    

                    List<IMetadataColumn> lookupColumns = inLookupCon.getMetadataTable().getListColumns();
                    String inputColumn = arrLookupColsName[i];
                    for (int j = 0; j < lookupColumns.size(); j++) { 
                        IMetadataColumn column = lookupColumns.get(j);             
                        if(column.getLabel().equals(inputColumn)){           
                            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType()); 
                            String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                            if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0 ){
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(inputColumn);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_130);
    }else{ 
                                if(JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable())){//need to judge whether javaType is a primitive type.if it is primitive type we need to use "" instead of null
                                     
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(inputColumn);
    stringBuffer.append(TEXT_135);
    }else{
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(inputColumn);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(inputColumn);
    stringBuffer.append(TEXT_142);
    }                                     
                             } 
                         } 
                     }
    stringBuffer.append(TEXT_143);
    }
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    if("FIRST_MATCH".equals(sOutputStat)){
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    }
    if("BEST_MATCH".equals(sOutputStat)){
    stringBuffer.append(TEXT_177);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    }
    stringBuffer.append(TEXT_181);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_183);
    for (String lookupCol : listLUColsName) {
    stringBuffer.append(TEXT_184);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(lookupCol);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(lookupCol);
    stringBuffer.append(TEXT_188);
    }
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    if("FIRST_MATCH".equals(sOutputStat)||"BEST_MATCH".equals(sOutputStat)){
    stringBuffer.append(TEXT_195);
    }
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    if("FIRST_MATCH".equals(sOutputStat)){
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    }
    if("BEST_MATCH".equals(sOutputStat)){
    stringBuffer.append(TEXT_201);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    }
    stringBuffer.append(TEXT_205);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_207);
    for (String lookupCol : listLUColsName) {
    stringBuffer.append(TEXT_208);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(lookupCol);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(lookupCol);
    stringBuffer.append(TEXT_212);
    }
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    if("FIRST_MATCH".equals(sOutputStat)||"BEST_MATCH".equals(sOutputStat)){
    stringBuffer.append(TEXT_219);
    }
    stringBuffer.append(TEXT_220);
    if (connNameMatchesOut != null){
    if("ALL_MATCHES".equals(sOutputStat)){
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    codeGenerator.generateOutput(connNameMatchesOut, "currentLookupRow_".concat(connNameLookUp), connNameMain, listMainColsName, listLUColsName, listOutColsName, listReplacedColsMapping, bReplacedByLookupRow, "sMatchingDists_".concat(cid), "matchingProba_".concat(cid), cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    }else{
    stringBuffer.append(TEXT_225);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_227);
    codeGenerator.generateOutput(connNameMatchesOut, "savedMatchRow_".concat(connNameLookUp), connNameMain, listMainColsName, listLUColsName, listOutColsName, listReplacedColsMapping, bReplacedByLookupRow, "savedRowDists_".concat(cid), "savedRowProba_".concat(cid), cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    }
    }
    stringBuffer.append(TEXT_230);
    if (connNamePosMatchOut != null){
    stringBuffer.append(TEXT_231);
    if("ALL_MATCHES".equals(sOutputStat)){
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    codeGenerator.generateOutput(connNamePosMatchOut, "currentLookupRow_".concat(connNameLookUp), connNameMain, listMainColsName, listLUColsName, listOutColsName, listReplacedColsMapping, bReplacedByLookupRow, "sMatchingDists_".concat(cid), "matchingProba_".concat(cid), cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    }else{
    stringBuffer.append(TEXT_236);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_239);
    codeGenerator.generateOutput(connNamePosMatchOut, "savedPMatchRow_".concat(connNameLookUp), connNameMain, listMainColsName, listLUColsName, listOutColsName, listReplacedColsMapping, bReplacedByLookupRow, "savedPRowDists_".concat(cid), "savedPRowProba_".concat(cid), cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    }
    stringBuffer.append(TEXT_242);
    }
    stringBuffer.append(TEXT_243);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    if (connNameNonMatchOut != null){
    codeGenerator.generateOutput(connNameNonMatchOut, connNameLookUp, connNameMain, listMainColsName, null, listOutColsName, listReplacedColsMapping, bReplacedByLookupRow, null, null, cid);
    }
    stringBuffer.append(TEXT_250);
    
        } else{ /* to be suitable for IS_MULTIPLYING_OUTPUTS */
        
    stringBuffer.append(TEXT_251);
    
    }
    /* to be suitable for IS_MULTIPLYING_OUTPUTS */
    if (node.getOutgoingConnections() == null || node.getOutgoingConnections().size() == 0){
    
    stringBuffer.append(TEXT_252);
    
    }

    stringBuffer.append(TEXT_253);
    return stringBuffer.toString();
  }
}
