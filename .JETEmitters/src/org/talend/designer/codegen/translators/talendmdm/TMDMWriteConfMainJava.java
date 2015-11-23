package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TMDMWriteConfMainJava
{
  protected static String nl;
  public static synchronized TMDMWriteConfMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMWriteConfMainJava result = new TMDMWriteConfMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        ";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + "      ";
  protected final String TEXT_4 = " = new ";
  protected final String TEXT_5 = "Struct();" + NL + "  \t";
  protected final String TEXT_6 = NL + "\t\t\t";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " = ParserUtils.parseTo_Document(queue_";
  protected final String TEXT_9 = ".peek());" + NL + "\t\t";
  protected final String TEXT_10 = NL + "\t\t\t";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = " = queue_";
  protected final String TEXT_13 = ".peek();" + NL + "\t\t";
  protected final String TEXT_14 = NL + "      \t\tjava.util.Map<String,String> xmlFlow_";
  protected final String TEXT_15 = " = xmlFlowList_";
  protected final String TEXT_16 = ".get(flowNum_";
  protected final String TEXT_17 = ");" + NL + "      \t\tString valueStr_";
  protected final String TEXT_18 = ";" + NL + "\t\t\t";
  protected final String TEXT_19 = NL + "\t \t\t\tvalueStr_";
  protected final String TEXT_20 = " = xmlFlow_";
  protected final String TEXT_21 = ".get(\"";
  protected final String TEXT_22 = "\");" + NL + "\t  \t\t\tif (valueStr_";
  protected final String TEXT_23 = " != null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = " = valueStr_";
  protected final String TEXT_27 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = " = ParserUtils.parseTo_Date(valueStr_";
  protected final String TEXT_31 = ", ";
  protected final String TEXT_32 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " = valueStr_";
  protected final String TEXT_36 = ".getBytes();" + NL + "\t\t\t\t\t";
  protected final String TEXT_37 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = " = ParserUtils.parseTo_";
  protected final String TEXT_40 = "(valueStr_";
  protected final String TEXT_41 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_42 = "\t\t\t" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = " = ";
  protected final String TEXT_45 = ";" + NL + "\t\t\t\t}" + NL + "\t      \t\t";
  protected final String TEXT_46 = NL + "    input_";
  protected final String TEXT_47 = " = queue_";
  protected final String TEXT_48 = ".peek();" + NL + "" + NL + "    try {" + NL + "\t\t";
  protected final String TEXT_49 = NL + "\t\t\torg.talend.mdm.webservice.WSPartialPutItem wsPartialPutItem_";
  protected final String TEXT_50 = " = new org.talend.mdm.webservice.WSPartialPutItem(";
  protected final String TEXT_51 = ",";
  protected final String TEXT_52 = ",";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = ", ";
  protected final String TEXT_55 = ",";
  protected final String TEXT_56 = ", ";
  protected final String TEXT_57 = ",";
  protected final String TEXT_58 = ", input_";
  protected final String TEXT_59 = ");" + NL + "\t\t\twspk_";
  protected final String TEXT_60 = " = tmdmWS_";
  protected final String TEXT_61 = ".partialPutItem(wsPartialPutItem_";
  protected final String TEXT_62 = ");" + NL + "\t\t\t";
  protected final String TEXT_63 = NL + "\t              \t";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = "= wspk_";
  protected final String TEXT_66 = ".getIds(";
  protected final String TEXT_67 = ");" + NL + "\t            ";
  protected final String TEXT_68 = "     " + NL + "            " + NL + "\t\t";
  protected final String TEXT_69 = "   " + NL + "\t\t\t" + NL + "\t\t\torg.talend.mdm.webservice.WSPutItem item_";
  protected final String TEXT_70 = " = new org.talend.mdm.webservice.WSPutItem(";
  protected final String TEXT_71 = ", dataCluster_";
  protected final String TEXT_72 = ",dataModel_";
  protected final String TEXT_73 = ",input_";
  protected final String TEXT_74 = ");" + NL + "\t      \t";
  protected final String TEXT_75 = NL + "\t        \torg.talend.mdm.webservice.WSPutItemWithReport itemReport_";
  protected final String TEXT_76 = " = new org.talend.mdm.webservice.WSPutItemWithReport(";
  protected final String TEXT_77 = ", ";
  protected final String TEXT_78 = ", item_";
  protected final String TEXT_79 = ");" + NL + "\t\t" + NL + "\t\t        ";
  protected final String TEXT_80 = NL + "\t\t        \t";
  protected final String TEXT_81 = NL + "\t\t        \t\ttaskIDs_";
  protected final String TEXT_82 = ".add(";
  protected final String TEXT_83 = ");" + NL + "\t\t        \t";
  protected final String TEXT_84 = NL + "\t\t          miList_";
  protected final String TEXT_85 = ".add(itemReport_";
  protected final String TEXT_86 = ");" + NL + "\t\t" + NL + "\t\t          if (miList_";
  protected final String TEXT_87 = ".size() >= ";
  protected final String TEXT_88 = ") {" + NL + "\t\t            wspks_";
  protected final String TEXT_89 = " = tmdmWS_";
  protected final String TEXT_90 = ".putItemWithReportArray(miList_";
  protected final String TEXT_91 = ".toArray(new org.talend.mdm.webservice.WSPutItemWithReport[";
  protected final String TEXT_92 = "]));" + NL + "\t\t            miList_";
  protected final String TEXT_93 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_94 = NL + "\t\t            \t" + NL + "\t\t            \tint i2_";
  protected final String TEXT_95 = " = 0;" + NL + "\t\t\t\t\t\tfor(org.talend.mdm.webservice.WSItemPK wspk2_";
  protected final String TEXT_96 = " : wspks_";
  protected final String TEXT_97 = "){" + NL + "\t\t\t\t\t\t\twspk2_";
  protected final String TEXT_98 = ".setWsDataClusterPK(dataCluster_";
  protected final String TEXT_99 = ");" + NL + "\t\t\t\t\t\t\ttmdmWS_";
  protected final String TEXT_100 = ".updateItemMetadata(util_";
  protected final String TEXT_101 = ".makeUpdateMeteItm(taskIDs_";
  protected final String TEXT_102 = ".get(i2_";
  protected final String TEXT_103 = "), wspk2_";
  protected final String TEXT_104 = "));" + NL + "\t\t\t\t\t\t\ti2_";
  protected final String TEXT_105 = "++;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t            \t" + NL + "\t\t            \ttaskIDs_";
  protected final String TEXT_106 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_107 = NL + "\t\t          }" + NL + "\t\t        ";
  protected final String TEXT_108 = NL + "\t\t          wspk_";
  protected final String TEXT_109 = " = tmdmWS_";
  protected final String TEXT_110 = ".putItemWithReport(itemReport_";
  protected final String TEXT_111 = ");" + NL + "\t\t          \t";
  protected final String TEXT_112 = NL + "\t\t            \ttmdmWS_";
  protected final String TEXT_113 = ".updateItemMetadata(util_";
  protected final String TEXT_114 = ". makeUpdateMeteItm(";
  protected final String TEXT_115 = ",wspk_";
  protected final String TEXT_116 = "));" + NL + "\t\t            ";
  protected final String TEXT_117 = NL + "\t\t        ";
  protected final String TEXT_118 = NL + "\t\t            ";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = "= wspk_";
  protected final String TEXT_121 = ".getIds(";
  protected final String TEXT_122 = ");" + NL + "\t\t          ";
  protected final String TEXT_123 = NL + "\t\t        \t";
  protected final String TEXT_124 = NL + "\t\t        \t\ttaskIDs_";
  protected final String TEXT_125 = ".add(";
  protected final String TEXT_126 = ");" + NL + "\t\t        \t";
  protected final String TEXT_127 = NL + "\t\t          miList_";
  protected final String TEXT_128 = ".add(item_";
  protected final String TEXT_129 = ");" + NL + "\t\t" + NL + "\t\t          if (miList_";
  protected final String TEXT_130 = ".size() >= ";
  protected final String TEXT_131 = ") {" + NL + "\t\t            wspks_";
  protected final String TEXT_132 = " = tmdmWS_";
  protected final String TEXT_133 = ".putItemArray(miList_";
  protected final String TEXT_134 = ".toArray(new org.talend.mdm.webservice.WSPutItem[";
  protected final String TEXT_135 = "]));" + NL + "\t\t            miList_";
  protected final String TEXT_136 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_137 = NL + "\t\t            \t" + NL + "\t\t            \tint i2_";
  protected final String TEXT_138 = " = 0;" + NL + "\t\t\t\t\t\tfor(org.talend.mdm.webservice.WSItemPK wspk2_";
  protected final String TEXT_139 = " : wspks_";
  protected final String TEXT_140 = "){" + NL + "\t\t\t\t\t\t\twspk2_";
  protected final String TEXT_141 = ".setWsDataClusterPK(dataCluster_";
  protected final String TEXT_142 = ");" + NL + "\t\t\t\t\t\t\ttmdmWS_";
  protected final String TEXT_143 = ".updateItemMetadata(util_";
  protected final String TEXT_144 = ".makeUpdateMeteItm(taskIDs_";
  protected final String TEXT_145 = ".get(i2_";
  protected final String TEXT_146 = "), wspk2_";
  protected final String TEXT_147 = "));" + NL + "\t\t\t\t\t\t\ti2_";
  protected final String TEXT_148 = "++;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t            \t" + NL + "\t\t            \ttaskIDs_";
  protected final String TEXT_149 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_150 = NL + "\t\t          }" + NL + "\t\t        ";
  protected final String TEXT_151 = NL + "\t\t          wspk_";
  protected final String TEXT_152 = " = tmdmWS_";
  protected final String TEXT_153 = ".putItem(item_";
  protected final String TEXT_154 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_155 = NL + "\t\t            \ttmdmWS_";
  protected final String TEXT_156 = ".updateItemMetadata(util_";
  protected final String TEXT_157 = ". makeUpdateMeteItm(";
  protected final String TEXT_158 = ",wspk_";
  protected final String TEXT_159 = "));" + NL + "\t\t            ";
  protected final String TEXT_160 = NL + "\t\t          ";
  protected final String TEXT_161 = NL + "\t\t              ";
  protected final String TEXT_162 = ".";
  protected final String TEXT_163 = "= wspk_";
  protected final String TEXT_164 = ".getIds(";
  protected final String TEXT_165 = ");" + NL + "\t\t            ";
  protected final String TEXT_166 = NL + "\t    ";
  protected final String TEXT_167 = "  " + NL + "    } catch (java.lang.Exception e) {";
  protected final String TEXT_168 = NL + "        throw(e);";
  protected final String TEXT_169 = NL + "            ";
  protected final String TEXT_170 = " = null;";
  protected final String TEXT_171 = NL + "          ";
  protected final String TEXT_172 = " = new ";
  protected final String TEXT_173 = "Struct();" + NL + "          ";
  protected final String TEXT_174 = NL + "      \t\tjava.util.Map<String,String> rejectXmlFlow_";
  protected final String TEXT_175 = " = xmlFlowList_";
  protected final String TEXT_176 = ".get(flowNum_";
  protected final String TEXT_177 = ");" + NL + "      \t\tString rejectValueStr_";
  protected final String TEXT_178 = ";" + NL + "\t\t\t";
  protected final String TEXT_179 = NL + "\t \t\t\trejectValueStr_";
  protected final String TEXT_180 = " = rejectXmlFlow_";
  protected final String TEXT_181 = ".get(\"";
  protected final String TEXT_182 = "\");" + NL + "\t  \t\t\tif (rejectValueStr_";
  protected final String TEXT_183 = " != null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_185 = ".";
  protected final String TEXT_186 = " = rejectValueStr_";
  protected final String TEXT_187 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_188 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_189 = ".";
  protected final String TEXT_190 = " = ParserUtils.parseTo_Date(rejectValueStr_";
  protected final String TEXT_191 = ", ";
  protected final String TEXT_192 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_193 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_194 = ".";
  protected final String TEXT_195 = " = rejectValueStr_";
  protected final String TEXT_196 = ".getBytes();" + NL + "\t\t\t\t\t";
  protected final String TEXT_197 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_198 = ".";
  protected final String TEXT_199 = " = ParserUtils.parseTo_";
  protected final String TEXT_200 = "(rejectValueStr_";
  protected final String TEXT_201 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_202 = "\t\t\t" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_203 = ".";
  protected final String TEXT_204 = " = ";
  protected final String TEXT_205 = ";" + NL + "\t\t\t\t}" + NL + "\t      \t\t";
  protected final String TEXT_206 = NL + "\t\t\t";
  protected final String TEXT_207 = ".";
  protected final String TEXT_208 = " = ParserUtils.parseTo_Document(queue_";
  protected final String TEXT_209 = ".peek());" + NL + "\t\t  ";
  protected final String TEXT_210 = NL + "\t\t\t";
  protected final String TEXT_211 = ".";
  protected final String TEXT_212 = " = queue_";
  protected final String TEXT_213 = ".peek();" + NL + "\t\t  ";
  protected final String TEXT_214 = NL + "\t\t  nb_line_rejected_";
  protected final String TEXT_215 = "++; ";
  protected final String TEXT_216 = NL + "          ";
  protected final String TEXT_217 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_218 = ";";
  protected final String TEXT_219 = NL + "          System.err.println(e.getMessage());";
  protected final String TEXT_220 = NL + "    }";
  protected final String TEXT_221 = NL + "    flowNum_";
  protected final String TEXT_222 = "++;";
  protected final String TEXT_223 = NL + "    nb_line_";
  protected final String TEXT_224 = "++;";
  protected final String TEXT_225 = NL + "queue_";
  protected final String TEXT_226 = ".remove();";
  protected final String TEXT_227 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String destination = ElementParameterParser.getValue(node, "__DESTINATION__");

boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));

boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
String xmlField = ElementParameterParser.getValue(node,"__XMLFIELD__");
String needCheck = ElementParameterParser.getValue(node,"__ISINVOKE__");
boolean isMassInsert =("true").equals(ElementParameterParser.getValue(node,"__EXTENDINSERT__"));
String numMassInsert = ElementParameterParser.getValue(node,"__COMMIT_LEVEL__");
String sourceName = ElementParameterParser.getValue(node,"__SOURCE__");
boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
String isUpdate = ElementParameterParser.getValue(node,"__ISUPDATE__");
List<Map<String,String>> keysReturn = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__RETURN_IDS__");

boolean addTaskID = ("true").equals(ElementParameterParser.getValue(node,"__ADD_TASKID__"));
boolean isCustom = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM__"));
String taskID = ElementParameterParser.getValue(node,"__TASKID__");
String prevColumn = ElementParameterParser.getValue(node, "__PREV_COLUMN_TASK_ID__");

boolean usePartialUpdate = ("true").equals(ElementParameterParser.getValue(node,"__USE_PARTIAL_UPDATE__"));
String pivot = ElementParameterParser.getValue(node,"__PIVOT__");
boolean overwrite = ("true").equals(ElementParameterParser.getValue(node,"__OVERWRITE__"));
String key = ElementParameterParser.getValue(node,"__KEY__");
String position = ElementParameterParser.getValue(node,"__POSITION__");
String dataModule = ElementParameterParser.getValue(node, "__DATAMODEL__");
String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");

boolean storeFlow = ("true").equals(ElementParameterParser.getValue(node, "__STORE_FLOW__"));

List<IMetadataTable> metadatas = node.getMetadataList();

if (destination != null && !"".equals(destination)) {
  cid = destination;
}

if (metadatas != null && metadatas.size()>0) { 
  IMetadataTable metadata = metadatas.get(0);
  if (metadata != null) { 
  
    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    List<IMetadataColumn> rejectColumnList = null;
    boolean xmlFieldDocType=false;
    if (rejectConns != null && rejectConns.size() > 0) {
      IConnection rejectConn = rejectConns.get(0);
      if(rejectConn!=null){
      	rejectConnName = rejectConn.getName();
      	IMetadataTable metadataTable = rejectConn.getMetadataTable();
      	if(metadataTable!=null){
      		rejectColumnList = metadataTable.getListColumns();
      	}
      }
    }
   


    String outConnName = null;
    List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    List<IMetadataColumn> outputColumnList = null;

    for(IConnection tmpconn : outgoingConns) {
      if (tmpconn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        if(rejectConnName==null || !rejectConnName.equals(tmpconn.getName())){
          outConnName=tmpconn.getName();
	  IMetadataTable outputMetadata = tmpconn.getMetadataTable();
	  if(outputMetadata!=null){
	      outputColumnList = outputMetadata.getListColumns();
	  }
	}
      
    stringBuffer.append(TEXT_1);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_2);
    
      }
    }

    if (outConnName != null) {
    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_5);
    
  		if(outputColumnList!=null){
  			for(IMetadataColumn column:outputColumnList) {
  				if(column.getLabel().equals(xmlField) && "id_Document".equals(column.getTalendType())) {
  					xmlFieldDocType=true;
  					break;
  				}
  			}
  		}
      	if(xmlFieldDocType) {
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(xmlField );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
		}else{
		
    stringBuffer.append(TEXT_10);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(xmlField );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
		}
		 if(storeFlow){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
			if(outputColumnList!=null){
				for( int i = 0; i < outputColumnList.size(); i++) {
					IMetadataColumn column = outputColumnList.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					if(xmlField.equals(column.getLabel())){
						continue;
					}
				
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
					if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { // String or Object
					
    stringBuffer.append(TEXT_24);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
					} else if(javaType == JavaTypesManager.DATE) { // Date
					
    stringBuffer.append(TEXT_28);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_32);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { // byte[]
					
    stringBuffer.append(TEXT_33);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
					} else  { // other
					
    stringBuffer.append(TEXT_37);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_39);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
					}
					
    stringBuffer.append(TEXT_42);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_45);
    }
	      	}
      }
    }
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    if(usePartialUpdate){ // partial
    
			String stagingString = "";
    		if(isStaging){
    			stagingString = dataCluster + " + \"#STAGING\"";
    		} else {
    			stagingString = dataCluster;
    		}

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(stagingString );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(dataModule );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(key.equals("")?null:key);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(overwrite);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(pivot);
    stringBuffer.append(TEXT_55);
    stringBuffer.append( true==isStaging?false:withReport);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(sourceName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(position.equals("")?null:position);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
	        if (outConnName !=null && !isMassInsert && keysReturn.size() > 0) {
	        	for (int i = 0; i < keysReturn.size(); i++){
	            	Map<String,String> map = keysReturn.get(i);
	              	
    stringBuffer.append(TEXT_63);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(map.get("OUTPUT_COLUMN"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_67);
    
	            }
	       	}
		   	
    stringBuffer.append(TEXT_68);
    }else{// not partial 
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(isUpdate );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    
		    if (!isStaging && withReport) {
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(needCheck );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(sourceName );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    if (isMassInsert) {
    stringBuffer.append(TEXT_80);
    if(addTaskID){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(isCustom?taskID:"xmlFlowList_" + cid + ".get(flowNum_" + cid + ").get(\"" + prevColumn + "\")");
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(numMassInsert );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(numMassInsert );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    if(addTaskID){
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    } else {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    if(addTaskID){
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(isCustom?taskID:"xmlFlowList_" + cid + ".get(flowNum_" + cid + ").get(\"" + prevColumn + "\")");
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    
		        }
		
		        if (outConnName !=null && !isMassInsert && keysReturn.size() > 0) {
		        
		          for (int i = 0; i < keysReturn.size(); i++){
		            Map<String,String> map = keysReturn.get(i);
		            
    stringBuffer.append(TEXT_118);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(map.get("OUTPUT_COLUMN"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_122);
    
		          }
		        }
		      } else {
		      
		        if (isMassInsert) {
		        
    stringBuffer.append(TEXT_123);
    if(addTaskID){
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(isCustom?taskID:"xmlFlowList_" + cid + ".get(flowNum_" + cid + ").get(\"" + prevColumn + "\")");
    stringBuffer.append(TEXT_126);
    }
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(numMassInsert );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(numMassInsert );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    if(addTaskID){
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    }
    stringBuffer.append(TEXT_150);
    
		        } else {
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    if(addTaskID){
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(isCustom?taskID:"xmlFlowList_" + cid + ".get(flowNum_" + cid + ").get(\"" + prevColumn + "\")");
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    }
    stringBuffer.append(TEXT_160);
    
		          if (outConnName !=null && !isMassInsert && keysReturn.size() > 0) {
		            for (int i = 0; i < keysReturn.size(); i++){
		              Map<String,String> map = keysReturn.get(i);
		              
    stringBuffer.append(TEXT_161);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(map.get("OUTPUT_COLUMN"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_165);
    
		            }
		          }
		        }
		      }
		      
    stringBuffer.append(TEXT_166);
    }//end partial
    stringBuffer.append(TEXT_167);
    if (dieOnError) {
    stringBuffer.append(TEXT_168);
    } else {

        if (rejectConnName != null) {
          if (outConnName != null) {
    stringBuffer.append(TEXT_169);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_170);
    }
    stringBuffer.append(TEXT_171);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_173);
    if(storeFlow){
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    
			if(rejectColumnList!=null){
				for( int i = 0; i < rejectColumnList.size(); i++) {
					IMetadataColumn column = rejectColumnList.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					if(xmlField.equals(column.getLabel())){
						continue;
					}
				
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    
					if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { // String or Object
					
    stringBuffer.append(TEXT_184);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    
					} else if(javaType == JavaTypesManager.DATE) { // Date
					
    stringBuffer.append(TEXT_188);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_192);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { // byte[]
					
    stringBuffer.append(TEXT_193);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
					} else  { // other
					
    stringBuffer.append(TEXT_197);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_199);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    
					}
					
    stringBuffer.append(TEXT_202);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_204);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_205);
    }
	      	}
      	  }
      	  if(xmlFieldDocType) {
		  
    stringBuffer.append(TEXT_206);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(xmlField );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    
		  }else{
		  
    stringBuffer.append(TEXT_210);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(xmlField );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    
		  }
		  
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_218);
    } else {
    stringBuffer.append(TEXT_219);
    }
      }
    stringBuffer.append(TEXT_220);
    if(storeFlow){
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    }
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    
  }
}
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(TEXT_227);
    return stringBuffer.toString();
  }
}
