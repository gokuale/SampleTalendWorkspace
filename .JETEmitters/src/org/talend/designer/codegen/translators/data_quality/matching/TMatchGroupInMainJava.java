package org.talend.designer.codegen.translators.data_quality.matching;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.BlockCode;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.eclipse.emf.common.util.EMap;
import org.talend.designer.tdqmatching.MatchingData;
import org.talend.designer.tdqmatching.RuleMatcher;
import org.talend.designer.tdqmatching.JoinkeyRecord;

public class TMatchGroupInMainJava
{
  protected static String nl;
  public static synchronized TMatchGroupInMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMatchGroupInMainJava result = new TMatchGroupInMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "java.util.List<List<java.util.Map<String, String>>> matchingRulesAll_";
  protected final String TEXT_2 = " = new java.util.ArrayList<java.util.List<java.util.Map<String, String>>>();" + NL + "java.util.List<java.util.Map<String, String>> matcherList_";
  protected final String TEXT_3 = " = null;" + NL + "java.util.Map<String,String> tmpMap_";
  protected final String TEXT_4 = " =null;" + NL + "java.util.Map<String,String> paramMapTmp_";
  protected final String TEXT_5 = " =null;";
  protected final String TEXT_6 = NL + "        matcherList_";
  protected final String TEXT_7 = " = new java.util.ArrayList<java.util.Map<String, String>>();";
  protected final String TEXT_8 = NL + "            tmpMap_";
  protected final String TEXT_9 = "=new java.util.HashMap<String,String>();";
  protected final String TEXT_10 = NL + "                    tmpMap_";
  protected final String TEXT_11 = ".put(\"ATTRIBUTE_NAME\",\"";
  protected final String TEXT_12 = "\");";
  protected final String TEXT_13 = NL + "                    tmpMap_";
  protected final String TEXT_14 = ".put(\"";
  protected final String TEXT_15 = "\",";
  protected final String TEXT_16 = "+\"\");";
  protected final String TEXT_17 = NL + "                tmpMap_";
  protected final String TEXT_18 = ".put(\"";
  protected final String TEXT_19 = "\",\"";
  protected final String TEXT_20 = "\");";
  protected final String TEXT_21 = NL + "                    tmpMap_";
  protected final String TEXT_22 = ".put(\"";
  protected final String TEXT_23 = "\", \"";
  protected final String TEXT_24 = "\");";
  protected final String TEXT_25 = NL + "                                tmpMap_";
  protected final String TEXT_26 = ".put(\"";
  protected final String TEXT_27 = "\", String.valueOf(";
  protected final String TEXT_28 = "));";
  protected final String TEXT_29 = NL + "            matcherList_";
  protected final String TEXT_30 = ".add( tmpMap_";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "        matchingRulesAll_";
  protected final String TEXT_33 = ".add(matcherList_";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "if(matchingRulesAll_";
  protected final String TEXT_36 = ".size()==0){" + NL + "   //If no matching rules in external data, try to get to rule from JOIN_KEY table (which will be compatible to old version less than 5.3)   ";
  protected final String TEXT_37 = NL + "      matcherList_";
  protected final String TEXT_38 = " = new java.util.ArrayList<java.util.Map<String, String>>();" + NL + "      ";
  protected final String TEXT_39 = NL + "          tmpMap_";
  protected final String TEXT_40 = "=new java.util.HashMap<String,String>();";
  protected final String TEXT_41 = NL + "                  tmpMap_";
  protected final String TEXT_42 = ".put(\"ATTRIBUTE_NAME\",\"";
  protected final String TEXT_43 = "\");";
  protected final String TEXT_44 = NL + "                  tmpMap_";
  protected final String TEXT_45 = ".put(\"";
  protected final String TEXT_46 = "\",";
  protected final String TEXT_47 = "+\"\");";
  protected final String TEXT_48 = NL + "              tmpMap_";
  protected final String TEXT_49 = ".put(\"";
  protected final String TEXT_50 = "\",\"";
  protected final String TEXT_51 = "\");";
  protected final String TEXT_52 = NL + "          matcherList_";
  protected final String TEXT_53 = ".add( tmpMap_";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "//      paramMapTmp_";
  protected final String TEXT_56 = " = new java.util.HashMap<String,String>();" + NL + "//      paramMapTmp_";
  protected final String TEXT_57 = ".put(\"INTERVAL_RULE\", \"";
  protected final String TEXT_58 = "\");" + NL + "//      paramMapTmp_";
  protected final String TEXT_59 = ".put(\"MATCHING_ALGORITHM\", \"Simple VSR Matcher\");" + NL + "//      matcherList_";
  protected final String TEXT_60 = ".add( paramMapTmp_";
  protected final String TEXT_61 = ");" + NL + "      matchingRulesAll_";
  protected final String TEXT_62 = ".add(matcherList_";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = " " + NL + "}" + NL;
  protected final String TEXT_65 = NL + "  tHash_Lookup_";
  protected final String TEXT_66 = ".initGet();";
  protected final String TEXT_67 = NL;
  protected final String TEXT_68 = NL + "    ";
  protected final String TEXT_69 = "Struct ";
  protected final String TEXT_70 = " = null; // main output is used even in \"separate output\" mode";
  protected final String TEXT_71 = NL;
  protected final String TEXT_72 = "Struct masterRow_";
  protected final String TEXT_73 = " = null; // a master-row in a group";
  protected final String TEXT_74 = NL;
  protected final String TEXT_75 = "Struct subRow_";
  protected final String TEXT_76 = " = null; // a sub-row in a group." + NL + "// key row";
  protected final String TEXT_77 = NL;
  protected final String TEXT_78 = "Struct hashKey_";
  protected final String TEXT_79 = " = new ";
  protected final String TEXT_80 = "Struct();  " + NL + "// rows respond to key row ";
  protected final String TEXT_81 = NL;
  protected final String TEXT_82 = "Struct hashValue_";
  protected final String TEXT_83 = " = new ";
  protected final String TEXT_84 = "Struct();" + NL + "java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap_";
  protected final String TEXT_85 = " = (java.util.concurrent.ConcurrentHashMap) globalMap.get(\"concurrentHashMap\");" + NL + "concurrentHashMap_";
  protected final String TEXT_86 = ".putIfAbsent(\"gid_";
  protected final String TEXT_87 = "\", new java.util.concurrent.atomic.AtomicLong(0L));" + NL + "java.util.concurrent.atomic.AtomicLong gid_";
  protected final String TEXT_88 = " = (java.util.concurrent.atomic.AtomicLong) concurrentHashMap_";
  protected final String TEXT_89 = ".get(\"gid_";
  protected final String TEXT_90 = "\");" + NL + "// master rows in a group" + NL + "final java.util.List<";
  protected final String TEXT_91 = "Struct> masterRows_";
  protected final String TEXT_92 = " = new java.util.ArrayList<";
  protected final String TEXT_93 = "Struct>();" + NL + "// all rows in a group " + NL + "final java.util.List<";
  protected final String TEXT_94 = "Struct> groupRows_";
  protected final String TEXT_95 = " = new java.util.ArrayList<";
  protected final String TEXT_96 = "Struct>();" + NL + "// this Map key is MASTER GID,value is this MASTER index of all MASTERS.it will be used to get DUPLICATE GRP_QUALITY from MASTER and only in case of separate output." + NL + "final java.util.Map<String,Integer> indexMap_";
  protected final String TEXT_97 = " = new java.util.HashMap<String,Integer>();" + NL + "final double CONFIDENCE_THRESHOLD_";
  protected final String TEXT_98 = " = Double.valueOf(";
  protected final String TEXT_99 = ");" + NL + "" + NL + "" + NL + "" + NL + "//Long gid_";
  protected final String TEXT_100 = " = 0L;" + NL + "boolean forceLoop_";
  protected final String TEXT_101 = " = (blockRows_";
  protected final String TEXT_102 = ".isEmpty());";
  protected final String TEXT_103 = "    " + NL + "        java.util.Iterator<Object[]> iter_";
  protected final String TEXT_104 = " = blockRows_";
  protected final String TEXT_105 = ".iterator();";
  protected final String TEXT_106 = NL + "        java.util.Iterator<";
  protected final String TEXT_107 = "_2Struct> iter_";
  protected final String TEXT_108 = " = blockRows_";
  protected final String TEXT_109 = ".keySet().iterator();";
  protected final String TEXT_110 = NL + NL + "//TDQ-9172 reuse JAVA API at here." + NL + "org.talend.dataquality.record.linkage.grouping.AbstractRecordGrouping<Object> recordGroupImp_";
  protected final String TEXT_111 = "= new org.talend.dataquality.record.linkage.grouping.AbstractRecordGrouping<Object>(){" + NL + "    @Override" + NL + "    protected void outputRow(Object[] row) {";
  protected final String TEXT_112 = NL + "        ";
  protected final String TEXT_113 = "Struct outStuct_";
  protected final String TEXT_114 = " = new ";
  protected final String TEXT_115 = "Struct ();" + NL + "        boolean isMaster=false; ";
  protected final String TEXT_116 = NL + "           " + NL + "              if(";
  protected final String TEXT_117 = " <row.length){" + NL + "                  outStuct_";
  protected final String TEXT_118 = ".";
  protected final String TEXT_119 = "=(";
  protected final String TEXT_120 = ")row[";
  protected final String TEXT_121 = "];" + NL + "              }" + NL + "              ";
  protected final String TEXT_122 = NL + "          if(outStuct_";
  protected final String TEXT_123 = ".MASTER==true){" + NL + "             masterRows_";
  protected final String TEXT_124 = ".add(outStuct_";
  protected final String TEXT_125 = ");" + NL + "             indexMap_";
  protected final String TEXT_126 = ".put(String.valueOf(outStuct_";
  protected final String TEXT_127 = ".GID), masterRows_";
  protected final String TEXT_128 = ".size()-1);" + NL + "         }else{" + NL + "             groupRows_";
  protected final String TEXT_129 = ".add(outStuct_";
  protected final String TEXT_130 = ");" + NL + "         }" + NL + "    }" + NL + "    @Override" + NL + "    protected boolean isMaster(Object col) {" + NL + "        return String.valueOf(col).equals(\"true\");" + NL + "    }" + NL + "    @Override" + NL + "    protected Object incrementGroupSize(Object oldGroupSize) {" + NL + "        return Integer.parseInt(String.valueOf(oldGroupSize)) + 1;" + NL + "    }" + NL + "    @Override" + NL + "    protected Object[] createTYPEArray(int size) {" + NL + "        return  new Object[size];" + NL + "    }" + NL + "    @Override" + NL + "    protected Object castAsType(Object objectValue) {" + NL + "        return objectValue;" + NL + "    }" + NL + "   @Override" + NL + "   protected void outputRow(org.talend.dataquality.record.linkage.grouping.swoosh.RichRecord row) {" + NL + "       // No implementation temporarily." + NL + "" + NL + "   }      " + NL + "};" + NL + "recordGroupImp_";
  protected final String TEXT_131 = ".setColumnDelimiter(\";\");" + NL + "recordGroupImp_";
  protected final String TEXT_132 = ".setIsOutputDistDetails(";
  protected final String TEXT_133 = ");" + NL + "recordGroupImp_";
  protected final String TEXT_134 = ".setIsComputeGrpQuality(";
  protected final String TEXT_135 = ");" + NL + "recordGroupImp_";
  protected final String TEXT_136 = ".setAcceptableThreshold(Float.valueOf(\"";
  protected final String TEXT_137 = "\"));" + NL + "recordGroupImp_";
  protected final String TEXT_138 = ".setIsLinkToPrevious(";
  protected final String TEXT_139 = ");" + NL + "recordGroupImp_";
  protected final String TEXT_140 = ".setOrginalInputColumnSize(";
  protected final String TEXT_141 = ");" + NL + "recordGroupImp_";
  protected final String TEXT_142 = ".setIsDisplayAttLabels(";
  protected final String TEXT_143 = ");" + NL + "recordGroupImp_";
  protected final String TEXT_144 = ".setIsGIDStringType(\"true\".equals(\"";
  protected final String TEXT_145 = "\")?true :false);" + NL + "" + NL + "while (iter_";
  protected final String TEXT_146 = ".hasNext() || forceLoop_";
  protected final String TEXT_147 = "){ // C_01" + NL + "" + NL + "  if (forceLoop_";
  protected final String TEXT_148 = "){" + NL + "    forceLoop_";
  protected final String TEXT_149 = " = false;" + NL + "  } else {" + NL + "    // block existing" + NL;
  protected final String TEXT_150 = NL + "      ";
  protected final String TEXT_151 = "_2Struct row_";
  protected final String TEXT_152 = " =null;";
  protected final String TEXT_153 = NL + "          row_";
  protected final String TEXT_154 = " = new ";
  protected final String TEXT_155 = "_2Struct();" + NL + "          row_";
  protected final String TEXT_156 = ".restoreObjectByArrays(iter_";
  protected final String TEXT_157 = ".next());";
  protected final String TEXT_158 = NL + "          row_";
  protected final String TEXT_159 = " = iter_";
  protected final String TEXT_160 = ".next();";
  protected final String TEXT_161 = NL + "          hashKey_";
  protected final String TEXT_162 = ".";
  protected final String TEXT_163 = " = row_";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = ";" + NL + "          hashKey_";
  protected final String TEXT_166 = ".hashCodeDirty = true;";
  protected final String TEXT_167 = NL + "  }" + NL + "  tHash_Lookup_";
  protected final String TEXT_168 = ".lookup(hashKey_";
  protected final String TEXT_169 = ");" + NL + "  masterRows_";
  protected final String TEXT_170 = ".clear();";
  protected final String TEXT_171 = NL + "  groupRows_";
  protected final String TEXT_172 = ".clear();";
  protected final String TEXT_173 = NL + "  indexMap_";
  protected final String TEXT_174 = ".clear();" + NL + "  " + NL + "  //add mutch rules" + NL + "  for(java.util.List<java.util.Map<String, String>> matcherList:matchingRulesAll_";
  protected final String TEXT_175 = "){" + NL + "     recordGroupImp_";
  protected final String TEXT_176 = ".addMatchRule(matcherList);" + NL + "  }" + NL + "  recordGroupImp_";
  protected final String TEXT_177 = ".initialize();" + NL + " " + NL + "  while (tHash_Lookup_";
  protected final String TEXT_178 = ".hasNext()){  // loop on each data in one block" + NL + "    hashValue_";
  protected final String TEXT_179 = " = tHash_Lookup_";
  protected final String TEXT_180 = ".next();" + NL + "    // set the a loop data into inputTexts one column by one column. " + NL + "    java.util.List<Object> inputTexts=new java.util.ArrayList<Object>();";
  protected final String TEXT_181 = NL + "          inputTexts.add(hashValue_";
  protected final String TEXT_182 = ".";
  protected final String TEXT_183 = ");" + NL + "          ";
  protected final String TEXT_184 = NL + "    recordGroupImp_";
  protected final String TEXT_185 = ".doGroup((Object[]) inputTexts.toArray(new Object[inputTexts.size()]));" + NL + "    " + NL + "  } // while" + NL + "" + NL + "  recordGroupImp_";
  protected final String TEXT_186 = ".end();" + NL + "  groupRows_";
  protected final String TEXT_187 = ".addAll(masterRows_";
  protected final String TEXT_188 = ");" + NL + "    ";
  protected final String TEXT_189 = NL + "    java.util.Collections.sort(groupRows_";
  protected final String TEXT_190 = ", " + NL + "      new Comparator<";
  protected final String TEXT_191 = "Struct>(){" + NL + "        public int compare(";
  protected final String TEXT_192 = "Struct row1, ";
  protected final String TEXT_193 = "Struct row2){" + NL + "          if (!(row1.GID).equals(row2.GID)){" + NL + "            return (row1.GID).compareTo(row2.GID);" + NL + "          } else {" + NL + "            // false < true" + NL + "            return (row2.MASTER).compareTo(row1.MASTER); " + NL + "          }" + NL + "        }" + NL + "      }" + NL + "    );";
  protected final String TEXT_194 = NL;
  protected final String TEXT_195 = NL + "} // C_01 //TDQ-9655  if the second tMatchGroup select sort and mulyipass, make the C_01 while end here, and sort all rows " + NL + "    java.util.Collections.sort(groupRows_";
  protected final String TEXT_196 = ", " + NL + "      new Comparator<";
  protected final String TEXT_197 = "Struct>(){" + NL + "        public int compare(";
  protected final String TEXT_198 = "Struct row1, ";
  protected final String TEXT_199 = "Struct row2){" + NL + "          if (!(row1.GID).equals(row2.GID)){" + NL + "            return (row1.GID).compareTo(row2.GID);" + NL + "          } else {" + NL + "            // false < true" + NL + "            return (row2.MASTER).compareTo(row1.MASTER); " + NL + "          }" + NL + "        }" + NL + "      }" + NL + "    );" + NL;
  protected final String TEXT_200 = NL + "  // output data" + NL + "  for (";
  protected final String TEXT_201 = "Struct out_";
  protected final String TEXT_202 = " : groupRows_";
  protected final String TEXT_203 = "){ // C_02" + NL + "  " + NL + "    if (out_";
  protected final String TEXT_204 = " != null){ // C_03";
  protected final String TEXT_205 = NL + "          if(out_";
  protected final String TEXT_206 = ".GRP_SIZE == 1){ // unique rows";
  protected final String TEXT_207 = NL + "              ";
  protected final String TEXT_208 = " = new ";
  protected final String TEXT_209 = "Struct();";
  protected final String TEXT_210 = NL + "                  ";
  protected final String TEXT_211 = ".";
  protected final String TEXT_212 = " = out_";
  protected final String TEXT_213 = ".";
  protected final String TEXT_214 = ";";
  protected final String TEXT_215 = NL + "                  ";
  protected final String TEXT_216 = " = null;";
  protected final String TEXT_217 = NL + "                  ";
  protected final String TEXT_218 = " = null;";
  protected final String TEXT_219 = NL + "          }else{" + NL + "              double groupQuality;" + NL + "              if(out_";
  protected final String TEXT_220 = ".MASTER == true){ // sub rows" + NL + "                  groupQuality = out_";
  protected final String TEXT_221 = ".GRP_QUALITY;" + NL + "              }else{ // master rows" + NL + "                  groupQuality = masterRows_";
  protected final String TEXT_222 = ".get(indexMap_";
  protected final String TEXT_223 = ".get(String.valueOf(out_";
  protected final String TEXT_224 = ".GID))).GRP_QUALITY;//.intValue()-1).GRP_QUALITY;" + NL + "              }" + NL + "              if(groupQuality >= CONFIDENCE_THRESHOLD_";
  protected final String TEXT_225 = "){";
  protected final String TEXT_226 = NL + "                      ";
  protected final String TEXT_227 = " = null;";
  protected final String TEXT_228 = NL + "                      ";
  protected final String TEXT_229 = " = new ";
  protected final String TEXT_230 = "Struct();";
  protected final String TEXT_231 = NL + "                          ";
  protected final String TEXT_232 = ".";
  protected final String TEXT_233 = " = out_";
  protected final String TEXT_234 = ".";
  protected final String TEXT_235 = ";";
  protected final String TEXT_236 = NL + "                      ";
  protected final String TEXT_237 = " = null;";
  protected final String TEXT_238 = NL + "              }else{";
  protected final String TEXT_239 = NL + "                      ";
  protected final String TEXT_240 = " = null;";
  protected final String TEXT_241 = NL + "                      ";
  protected final String TEXT_242 = " = null;";
  protected final String TEXT_243 = NL + "                  ";
  protected final String TEXT_244 = " = new ";
  protected final String TEXT_245 = "Struct();";
  protected final String TEXT_246 = NL + "                      ";
  protected final String TEXT_247 = ".";
  protected final String TEXT_248 = " = out_";
  protected final String TEXT_249 = ".";
  protected final String TEXT_250 = "; ";
  protected final String TEXT_251 = NL + "              }" + NL + "          }";
  protected final String TEXT_252 = NL;
  protected final String TEXT_253 = NL + "              ";
  protected final String TEXT_254 = " = null;";
  protected final String TEXT_255 = NL + "              ";
  protected final String TEXT_256 = " = null;";
  protected final String TEXT_257 = NL + "              ";
  protected final String TEXT_258 = " = null;";
  protected final String TEXT_259 = NL + NL + "      // all output";
  protected final String TEXT_260 = NL + "      ";
  protected final String TEXT_261 = " = new ";
  protected final String TEXT_262 = "Struct();";
  protected final String TEXT_263 = " ";
  protected final String TEXT_264 = NL + "          ";
  protected final String TEXT_265 = ".";
  protected final String TEXT_266 = " = out_";
  protected final String TEXT_267 = ".";
  protected final String TEXT_268 = ";";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
org.talend.core.model.process.IProcess process = node.getProcess();
String cid = node.getUniqueName();
cid = cid.replace("_GroupIn", "");
boolean bSeparateOutput = "true".equals(ElementParameterParser.getValue(node, "__SEPARATE_OUTPUT__"));
boolean bOutputDetails = "true".equals(ElementParameterParser.getValue(node, "__OUTPUTDD__"));
boolean bCompGRPQuality = "true".equals(ElementParameterParser.getValue(node, "__COMPUTE_GRP_QUALITY__"));
final List<org.talend.core.model.process.IContextParameter> params = process.getContextManager().getDefaultContext().getContextParameterList();
boolean bSortOnDisk = "true".equals(ElementParameterParser.getValue(node, "__STORE_ON_DISK__")); 
// incoming connection
List<? extends IConnection> inConns = node.getIncomingConnections().get(0).getSource().getIncomingConnections();
IConnection inConn = null; 
String connNameMain = null;

if (inConns == null || inConns.size() == 0){
  return "";
} else{
  inConn = inConns.get(0);
  connNameMain = inConn.getName();
}

// schema of tGroup
IMetadataTable table = node.getMetadataList().get(0);
List<IMetadataColumn> columns = null;

// 'originalInputColumnSize' except the exernal columns as follow.
int extSize=bCompGRPQuality ? 5 : 4;
extSize=bOutputDetails ? extSize+1 : extSize;
int originalInputColumnSize=0;
if (table!=null) {
    columns = table.getListColumns();
    originalInputColumnSize=columns.size()-extSize;
}
String [] externalColumnsName=new String []{"GID","GRP_SIZE","MASTER","SCORE","GRP_QUALITY","MATCHING_DISTANCES"};
java.util.List externalColumnList=java.util.Arrays.asList(externalColumnsName);

// input schema
IMetadataTable tableIn = inConn.getMetadataTable();
List<IMetadataColumn> inColumns = null;
if (tableIn!=null) {
    inColumns = tableIn.getListColumns();
}

// get previous node name
INode preNode= inConn.getSource();
String preNodeName=preNode.getComponent().getName();

// outing connection
String connNameOut = null, connNameMainOut = null;
String connNameUniqueRowsOut = null, connNameConfidentGroupsOut = null, connNameUncertainGroupsOut = null;
List<? extends IConnection> outConns = node.getOutgoingSortedConnections();

if (outConns != null && outConns.size() > 0){

    connNameOut = outConns.get(0).getName(); 

    if(connNameMainOut == null){
        connNameMainOut = "mainOutput_" + cid; 
    }    
        for (IConnection connection: outConns){    
            if (connection.isActivate()){
                String connOutCntorName = connection.getConnectorName();
                String connOutFlowName = connection.getName();        
                if ("UNIQUE_ROWS".equals(connOutCntorName)){
                    connNameUniqueRowsOut = connOutFlowName;
                } else if ("CONFIDENT_GROUPS".equals(connOutCntorName)){
                    connNameConfidentGroupsOut = connOutFlowName;
                } else if ("UNCERTAIN_GROUPS".equals(connOutCntorName)){
                    connNameUncertainGroupsOut = connOutFlowName;
                } else if ("FLOW".equals(connOutCntorName)){
                    connNameMainOut = connOutFlowName;
                }
            }
        }
} else {
    return "";
}

// blocks
List<Map<String, String>> listBlocking = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BLOCKING_DEFINITION__");
List<String> blockColumns = new java.util.ArrayList<String>(); // to store unduplicated blocking columns
boolean hasAtLeastOneBlock = false;
String sSorted = "";

for (Map<String, String> blocking : listBlocking){
  String sColumnName = blocking.get("INPUT_COLUMN");
  
  if (!hasAtLeastOneBlock){
    hasAtLeastOneBlock = true;
    sSorted = "Sorted";
  }

  if (!blockColumns.contains(sColumnName)){
    blockColumns.add(sColumnName);
  }
}

String _ACCEPTABLE_THRESHOLD = ElementParameterParser.getValue(node, "__INTERVAL__");

//Get the join key parameter
//mzhao TDQ-5981 add multi rule set feature. Get the multi rules from matching component external data.

MatchingData matchData = (MatchingData)node.getExternalNode().getExternalEmfData();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
if (matchData != null && matchData.getRuleMatchers().size() > 0) {
    List<RuleMatcher> ruleMatchers = matchData.getRuleMatchers();
    for (RuleMatcher ruleMatcher : ruleMatchers) {
        
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
        List<JoinkeyRecord> jionkeys = ruleMatcher.getJoinkeys();
        EMap<String, Object> paramMap = ruleMatcher.getMatchParamMap();
        for (JoinkeyRecord joinKey : jionkeys) {
            EMap<String, Object> columnMap = joinKey.getColumnMap();
            
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
            for(String key: columnMap.keySet()){
                String value=columnMap.get(key)==null?"":columnMap.get(key).toString();
                String newKey=key;
                String newValue=value;
                //replace "INPUT_COLUMN" with "ATTRIBUTE_NAME" and "COLUMN_IDX" to JAVA API.
                if("INPUT_COLUMN".equals(key)){
                    
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_12);
    
                    newKey="COLUMN_IDX";
                    for(int index = 0; index < columns.size(); index++) {
                        IMetadataColumn column = columns.get(index);
                        if(value.equals(column.getLabel())) {
                            newValue=String.valueOf(index);
                            break;
                        }
                      }
                }else if("CUSTOM_MATCHER".equals(key)){
                    //only add CUSTOMER_MATCH_CLASS for custom Mating Type.
                    if("custom".equals(columnMap.get("MATCHING_TYPE"))){
                        newKey="CUSTOMER_MATCH_CLASS";
                    }else{
                        continue;
                    }
                }
                // they allow expression, like as "globalMap.get("col1")"
                if ("CONFIDENCE_WEIGHT".equals(key)||"CUSTOM_MATCHER".equals(key)){
                    
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(newKey);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(newValue);
    stringBuffer.append(TEXT_16);
    
                    continue;
                }
                //avoid to appear this style """"
                newValue=newValue.replace("\"", "");
                
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(newKey);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(newValue);
    stringBuffer.append(TEXT_20);
    
            }
            
            if(!"dummy".equals(columnMap.get("MATCHING_TYPE"))){
                for(String key: paramMap.keySet()){
                    String value=paramMap.get(key)==null ? "" :paramMap.get(key).toString();
                    String newKey=key;
                    //replace key "INTERVAL_RULE" with "RECORD_MATCH_THRESHOLD" .
                    if(key.equals("INTERVAL_RULE")){
                        newKey="RECORD_MATCH_THRESHOLD";
                    }
                    value=value.replace("\"", "");
                    
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(newKey);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_24);
    
                    if(params.size()>0&&value.contains("context.")){
                        String contextName=value.split("context.")[1];
                        for (org.talend.core.model.process.IContextParameter ctxParam :params){
                            if(ctxParam.getName().equals(contextName)){
                                
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(newKey);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_28);
    
                                break;
                            }
                        }
                    }
                }
            }
            
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
        }
        
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
    }
}


    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
  List<List<Map<String, String>>> allRules = (List<List<Map<String, String>>>)ElementParameterParser.getMultiObjectValue(node, "__JOIN_KEY__");
  if(allRules!=null&&allRules.size()>0){
      List<Map<String, String>> firstMatcherList = allRules.get(0);
      
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
      for(Map<String,String> columnMap:firstMatcherList){
      
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
          for(String key: columnMap.keySet()){
              String value=columnMap.get(key)==null?"":columnMap.get(key).toString();
              String newKey=key;
              String newValue=value;
              //replace "INPUT_COLUMN" with "ATTRIBUTE_NAME" and "COLUMN_IDX" to JAVA API.
              if("INPUT_COLUMN".equals(key)){
                  
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_43);
    
                  newKey="COLUMN_IDX";
                  for(int index = 0; index < columns.size(); index++) {
                      IMetadataColumn column = columns.get(index);
                      if(value.equals(column.getLabel())) {
                          newValue=String.valueOf(index);
                          break;
                      }
                    }
              }else if("CUSTOM_MATCHER".equals(key)){
                //only add CUSTOMER_MATCH_CLASS for custom Mating Type.
                  if("custom".equals(columnMap.get("MATCHING_TYPE"))){
                      newKey="CUSTOMER_MATCH_CLASS";
                  }else{
                      continue;
                  }
              }
              // it allows expression like as "globalMap.get("col1")"
              if ("CONFIDENCE_WEIGHT".equals(key)||"CUSTOM_MATCHER".equals(key)){
                  
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(newKey);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(newValue);
    stringBuffer.append(TEXT_47);
    
                  continue;
              }
              //avoid to appear this style """"
              newValue=newValue.replace("\"", "");
              
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(newKey);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(newValue);
    stringBuffer.append(TEXT_51);
    
          }
          
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
      }
      //Add the parameter map of algorithm interval of each matching rule, and  algorithm name.
      
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(_ACCEPTABLE_THRESHOLD);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
      
  }  
 
    stringBuffer.append(TEXT_64);
    
String _CONFIDENCE_THRESHOLD = ElementParameterParser.getValue(node, "__CONFIDENCE_THRESHOLD__");
boolean bStoreOnDisk = "true".equals(ElementParameterParser.getValue(node, "__STORE_ON_DISK__")); 
boolean bSortData = "true".equals(ElementParameterParser.getValue(node, "__SORT_DATA__")); 
boolean bGIDUseString = "true".equals(ElementParameterParser.getValue(node, "__GID_USE_STRING__"));
boolean bMultiPass="true".equals(ElementParameterParser.getValue(node, "__LINK_WITH_PREVIOUS__"))&&(preNodeName.startsWith("tMatchGroup")||preNodeName.equals("tJavaRow"));
boolean displayAttLabels = "true".equals(ElementParameterParser.getValue(node, "__DISPLAY_ATTR_LABELS__"));

if (bStoreOnDisk){

    stringBuffer.append(TEXT_65);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_66);
    
}

    stringBuffer.append(TEXT_67);
    if(connNameMainOut.startsWith("mainOutput_")){
    stringBuffer.append(TEXT_68);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(connNameMainOut);
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(_CONFIDENCE_THRESHOLD);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_102);
    
    if (bSortOnDisk && hasAtLeastOneBlock){

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_105);
    }else{
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_115);
     
         
         for(int i=0;i< columns.size();i++){
              IMetadataColumn column=columns.get(i);
              String type=column.getTalendType();
              type=type.replace("id_", "");
        
    stringBuffer.append(TEXT_116);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_121);
    }
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(bOutputDetails);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(bCompGRPQuality);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(_ACCEPTABLE_THRESHOLD);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(bMultiPass);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(originalInputColumnSize);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(displayAttLabels);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(bGIDUseString);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
  if (hasAtLeastOneBlock){
  
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_152);
        
      if(bSortOnDisk){
      
    stringBuffer.append(TEXT_153);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
      }else{
      
    stringBuffer.append(TEXT_158);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
      }
      for (String block : blockColumns){
      
    stringBuffer.append(TEXT_161);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(block);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(block);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_166);
    
      }
  }
  
    stringBuffer.append(TEXT_167);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    if( !(bSortData && bMultiPass)){ //TDQ-9655 if the second tMatchGroup select sort and mulyipass, not clear 
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    }
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_180);
    
    for(int i=0;i<inColumns.size();i++){  
        IMetadataColumn column=inColumns.get(i);
          String label= column.getLabel();
          //filter the external columns if it is not multiple pass.
          if(!bMultiPass && externalColumnList.contains(label)&&i>originalInputColumnSize-1){
                  continue;
          }
    
    stringBuffer.append(TEXT_181);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_183);
    }
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    
  if (bSortData && !bMultiPass){ // order by gid, master
  
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_193);
    }
    stringBuffer.append(TEXT_194);
    if( bSortData && bMultiPass){  
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_199);
    } 
    stringBuffer.append(TEXT_200);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    if (bSeparateOutput){
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    if (connNameUniqueRowsOut != null){
    stringBuffer.append(TEXT_207);
    stringBuffer.append(connNameUniqueRowsOut);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(connNameUniqueRowsOut);
    stringBuffer.append(TEXT_209);
    for (IMetadataColumn column : table.getListColumns()){
    stringBuffer.append(TEXT_210);
    stringBuffer.append(connNameUniqueRowsOut);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_214);
    }
              }
              if (connNameConfidentGroupsOut != null){
    stringBuffer.append(TEXT_215);
    stringBuffer.append(connNameConfidentGroupsOut);
    stringBuffer.append(TEXT_216);
    }
              if (connNameUncertainGroupsOut != null){
    stringBuffer.append(TEXT_217);
    stringBuffer.append(connNameUncertainGroupsOut);
    stringBuffer.append(TEXT_218);
    }
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    if (connNameUniqueRowsOut != null){
    stringBuffer.append(TEXT_226);
    stringBuffer.append(connNameUniqueRowsOut);
    stringBuffer.append(TEXT_227);
    }
                  if (connNameConfidentGroupsOut != null){
    stringBuffer.append(TEXT_228);
    stringBuffer.append(connNameConfidentGroupsOut);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(connNameConfidentGroupsOut);
    stringBuffer.append(TEXT_230);
    for (IMetadataColumn column : table.getListColumns()){
    stringBuffer.append(TEXT_231);
    stringBuffer.append(connNameConfidentGroupsOut);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_235);
    }
                  }
                  if (connNameUncertainGroupsOut != null){
    stringBuffer.append(TEXT_236);
    stringBuffer.append(connNameUncertainGroupsOut);
    stringBuffer.append(TEXT_237);
    }
    stringBuffer.append(TEXT_238);
    if (connNameUniqueRowsOut != null){
    stringBuffer.append(TEXT_239);
    stringBuffer.append(connNameUniqueRowsOut);
    stringBuffer.append(TEXT_240);
    }
                  if (connNameConfidentGroupsOut != null){
    stringBuffer.append(TEXT_241);
    stringBuffer.append(connNameConfidentGroupsOut);
    stringBuffer.append(TEXT_242);
    }
                  if (connNameUncertainGroupsOut != null){
    stringBuffer.append(TEXT_243);
    stringBuffer.append(connNameUncertainGroupsOut);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(connNameUncertainGroupsOut);
    stringBuffer.append(TEXT_245);
    for (IMetadataColumn column : table.getListColumns()){
    stringBuffer.append(TEXT_246);
    stringBuffer.append(connNameUncertainGroupsOut);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_250);
    }
                  }
    stringBuffer.append(TEXT_251);
    }else{
    stringBuffer.append(TEXT_252);
    if (connNameUniqueRowsOut != null){
    stringBuffer.append(TEXT_253);
    stringBuffer.append(connNameUniqueRowsOut);
    stringBuffer.append(TEXT_254);
    }
          if (connNameConfidentGroupsOut != null){
    stringBuffer.append(TEXT_255);
    stringBuffer.append(connNameConfidentGroupsOut);
    stringBuffer.append(TEXT_256);
    }
          if (connNameUncertainGroupsOut != null){
    stringBuffer.append(TEXT_257);
    stringBuffer.append(connNameUncertainGroupsOut);
    stringBuffer.append(TEXT_258);
    }
      }
    stringBuffer.append(TEXT_259);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(connNameMainOut);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_262);
    for(IMetadataColumn column : table.getListColumns()){
    stringBuffer.append(TEXT_263);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(connNameMainOut);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_268);
    }
        
      List<BlockCode> blockCodes = new java.util.ArrayList<BlockCode>();
    blockCodes.add(new BlockCode("C_03"));
  blockCodes.add(new BlockCode("C_02"));
  if( !(bSortData && bMultiPass)){  // TDQ-9655 if the second tMatchGroup select sort and mulyipass, do not need C_01 here
    blockCodes.add(new BlockCode("C_01"));
  }
((org.talend.core.model.process.AbstractNode) node).setBlocksCodeToClose(blockCodes);

    return stringBuffer.toString();
  }
}
