package org.talend.designer.codegen.translators.business.marketo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMarketoInputBeginJava
{
  protected static String nl;
  public static synchronized TMarketoInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoInputBeginJava result = new TMarketoInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "int nb_call_";
  protected final String TEXT_2 = " = 0;" + NL + "globalMap.put(\"";
  protected final String TEXT_3 = "_NB_CALL\",0);  ";
  protected final String TEXT_4 = NL + "\t\t\tString[] includeTypes_";
  protected final String TEXT_5 = " = " + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tnull;" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tnew String[]{\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_8 = "\t" + NL + "\t\t\t\t\t\"";
  protected final String TEXT_9 = "\",\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t};" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "        \tString[] excludeTypes_";
  protected final String TEXT_12 = " = " + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tnull;" + NL + "\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\tnew String[]{\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_15 = "\t" + NL + "\t\t\t\t\t\"";
  protected final String TEXT_16 = "\",\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t};" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\tint reConnMaxNum_";
  protected final String TEXT_19 = "=";
  protected final String TEXT_20 = ";" + NL + "\t\t\treConnMaxNum_";
  protected final String TEXT_21 = " = reConnMaxNum_";
  protected final String TEXT_22 = " >0 ?reConnMaxNum_";
  protected final String TEXT_23 = ":1;" + NL;
  protected final String TEXT_24 = NL + "            ";
  protected final String TEXT_25 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_26 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = "; ";
  protected final String TEXT_31 = NL + NL + "\t\t\torg.talend.marketo.Client client_";
  protected final String TEXT_32 = " = new org.talend.marketo.Client(";
  protected final String TEXT_33 = ",decryptedPassword_";
  protected final String TEXT_34 = ",";
  protected final String TEXT_35 = ");" + NL + "\t\t\tclient_";
  protected final String TEXT_36 = ".setTimeout(";
  protected final String TEXT_37 = ");" + NL + "\t\t";
  protected final String TEXT_38 = NL + "\t\t\tcom.marketo.www.mktows.ResultGetLead leads_";
  protected final String TEXT_39 = " = null;" + NL + "\t\t\tcom.marketo.www.mktows.LeadRecord[] records_";
  protected final String TEXT_40 = " = null;" + NL + "\t\t\ttry{" + NL + "\t\t\t\tfor(int i_";
  protected final String TEXT_41 = "=0;i_";
  protected final String TEXT_42 = " <= reConnMaxNum_";
  protected final String TEXT_43 = ";i_";
  protected final String TEXT_44 = "++){" + NL + "            \t\ttry{" + NL + "                \t\tleads_";
  protected final String TEXT_45 = " = client_";
  protected final String TEXT_46 = ".getLead(\"";
  protected final String TEXT_47 = "\",";
  protected final String TEXT_48 = ");" + NL + "                \t\tbreak;\t" + NL + "\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_49 = "){" + NL + "\t\t\t\t\t\tif(ex_";
  protected final String TEXT_50 = " instanceof org.apache.axis.AxisFault){" + NL + "\t\t\t\t\t\t\tString faultStr_";
  protected final String TEXT_51 = " = ((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_52 = ").getFaultString();" + NL + "\t\t\t\t\t\t\tif(faultStr_";
  protected final String TEXT_53 = "!=null && faultStr_";
  protected final String TEXT_54 = ".startsWith(\"201\")){" + NL + "\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_55 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(i_";
  protected final String TEXT_56 = " != reConnMaxNum_";
  protected final String TEXT_57 = "){" + NL + "\t\t\t\t\t\t\tSystem.err.println(\"Connection error:\");" + NL + "\t\t\t\t\t\t\tSystem.err.println(ex_";
  protected final String TEXT_58 = ".getMessage());" + NL + "\t\t\t\t\t\t\tSystem.err.println(\"Waiting to retry...\");" + NL + "\t\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_59 = ");" + NL + "\t\t\t\t\t\t\tSystem.err.println(\"Attempting to reconnect...\");" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_60 = ";" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "                }" + NL + "\t\t\t\t" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_61 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_62 = ");  " + NL + "\t\t\t\t" + NL + "\t\t\t\trecords_";
  protected final String TEXT_63 = " = leads_";
  protected final String TEXT_64 = ".getLeadRecordList();" + NL + "\t\t\t}catch(org.apache.axis.AxisFault axisFault_";
  protected final String TEXT_65 = "){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tif(!client_";
  protected final String TEXT_66 = ".isSystemError(axisFault_";
  protected final String TEXT_67 = ")){" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_68 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_69 = ");  " + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tclient_";
  protected final String TEXT_70 = ".inputExceptionFilter(axisFault_";
  protected final String TEXT_71 = ");" + NL + "\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_72 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t            throw(ex_";
  protected final String TEXT_74 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_75 = NL + "\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_76 = ".getMessage());" + NL + "\t\t\t        ";
  protected final String TEXT_77 = NL + "\t\t\t\t}" + NL + "\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_78 = "){" + NL + "\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t            throw(ex_";
  protected final String TEXT_80 = ");" + NL + "\t\t        ";
  protected final String TEXT_81 = NL + "\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_82 = ".getMessage());" + NL + "\t\t        ";
  protected final String TEXT_83 = NL + "\t\t\t}" + NL + "\t\t\tif(leads_";
  protected final String TEXT_84 = " != null && records_";
  protected final String TEXT_85 = "!=null){" + NL + "\t\t\t\tfor (int i_";
  protected final String TEXT_86 = " = 0; i_";
  protected final String TEXT_87 = " < leads_";
  protected final String TEXT_88 = ".getCount(); i_";
  protected final String TEXT_89 = "++) {" + NL + "\t            \tjava.util.Map<String, String> result_";
  protected final String TEXT_90 = " = client_";
  protected final String TEXT_91 = ".readLead(records_";
  protected final String TEXT_92 = "[i_";
  protected final String TEXT_93 = "]);";
  protected final String TEXT_94 = NL + "            String streamPosition_";
  protected final String TEXT_95 = " = null;" + NL + "            String[] includeAttributes_";
  protected final String TEXT_96 = " = new String[]{" + NL + "\t\t\t";
  protected final String TEXT_97 = "\t" + NL + "    \t\t\t";
  protected final String TEXT_98 = ",\t\t" + NL + "\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t};" + NL + "\t\t\tcom.marketo.www.mktows.LeadSelector selector_";
  protected final String TEXT_100 = " = new com.marketo.www.mktows.";
  protected final String TEXT_101 = "();" + NL + "\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\t\tfor(String[] valuesArray_";
  protected final String TEXT_103 = ":leadKeyValues_";
  protected final String TEXT_104 = "){" + NL + "\t\t\t\t\tselector_";
  protected final String TEXT_105 = " = org.talend.marketo.SelectorUtil.getLeadKeySelector(\"";
  protected final String TEXT_106 = "\",valuesArray_";
  protected final String TEXT_107 = ");" + NL + "\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t\t\tselector_";
  protected final String TEXT_109 = " = org.talend.marketo.SelectorUtil.getStaticListSelectorByName(";
  protected final String TEXT_110 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\t\tselector_";
  protected final String TEXT_112 = " = org.talend.marketo.SelectorUtil.getStaticListSelectorByID(";
  protected final String TEXT_113 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_114 = NL + "\t\t\t\tselector_";
  protected final String TEXT_115 = " =  org.talend.marketo.SelectorUtil.getLastUpdateAtSelector(";
  protected final String TEXT_116 = ",";
  protected final String TEXT_117 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_118 = NL + "            while(true){" + NL + "            \tcom.marketo.www.mktows.ResultGetMultipleLeads leads_";
  protected final String TEXT_119 = " = null;" + NL + "            \ttry{ " + NL + "\t\t\t\t\tfor(int i_";
  protected final String TEXT_120 = "=0;i_";
  protected final String TEXT_121 = " <= reConnMaxNum_";
  protected final String TEXT_122 = ";i_";
  protected final String TEXT_123 = "++){" + NL + "\t            \t\ttry{" + NL + "\t                \t\tleads_";
  protected final String TEXT_124 = " = client_";
  protected final String TEXT_125 = ".getMultipleLeads(includeAttributes_";
  protected final String TEXT_126 = ", ";
  protected final String TEXT_127 = ", streamPosition_";
  protected final String TEXT_128 = ",selector_";
  protected final String TEXT_129 = ");" + NL + "\t                \t\tbreak;\t" + NL + "\t\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_130 = "){" + NL + "\t\t\t\t\t\t\tif(ex_";
  protected final String TEXT_131 = " instanceof org.apache.axis.AxisFault){" + NL + "\t\t\t\t\t\t\t\tString faultStr_";
  protected final String TEXT_132 = " = ((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_133 = ").getFaultString();" + NL + "\t\t\t\t\t\t\t\tif(faultStr_";
  protected final String TEXT_134 = "!=null && faultStr_";
  protected final String TEXT_135 = ".startsWith(\"201\")){" + NL + "\t\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_136 = ";" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif(i_";
  protected final String TEXT_137 = " != reConnMaxNum_";
  protected final String TEXT_138 = "){" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Connection error:\");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(ex_";
  protected final String TEXT_139 = ".getMessage());" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Waiting to retry...\");" + NL + "\t\t\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_140 = ");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Attempting to reconnect...\");" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_141 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t                }" + NL + "            \t\tglobalMap.put(\"";
  protected final String TEXT_142 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_143 = ");" + NL + "            \t}catch(java.lang.Exception ex_";
  protected final String TEXT_144 = "){" + NL + "            \t\tif(ex_";
  protected final String TEXT_145 = " instanceof org.apache.axis.AxisFault){" + NL + "            \t\t\tif(!client_";
  protected final String TEXT_146 = ".isSystemError((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_147 = ")){" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_148 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_149 = ");\t\t" + NL + "\t\t\t\t\t\t}" + NL + "            \t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_150 = NL + "\t\t\t            throw(ex_";
  protected final String TEXT_151 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_152 = NL + "\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_153 = ".getMessage());" + NL + "\t\t\t\t        break;" + NL + "\t\t\t        ";
  protected final String TEXT_154 = NL + "\t\t\t\t}" + NL + "            \tif(leads_";
  protected final String TEXT_155 = " != null){" + NL + "\t            \tcom.marketo.www.mktows.LeadRecord[] records_";
  protected final String TEXT_156 = " = leads_";
  protected final String TEXT_157 = ".getLeadRecordList();" + NL + "\t            \tfor (int i_";
  protected final String TEXT_158 = " = 0; i_";
  protected final String TEXT_159 = " < leads_";
  protected final String TEXT_160 = ".getReturnCount(); i_";
  protected final String TEXT_161 = "++) {" + NL + "\t            \t\tjava.util.Map<String, String> result_";
  protected final String TEXT_162 = " = client_";
  protected final String TEXT_163 = ".readLead(records_";
  protected final String TEXT_164 = "[i_";
  protected final String TEXT_165 = "]);";
  protected final String TEXT_166 = NL + "\t\t\tcom.marketo.www.mktows.StreamPosition streamPosition_";
  protected final String TEXT_167 = " = null;" + NL + "\t\t\twhile(true){" + NL + "\t\t\t\tcom.marketo.www.mktows.LeadActivityList activities_";
  protected final String TEXT_168 = " = null;" + NL + "\t\t\t\tcom.marketo.www.mktows.ActivityRecord[] activityRecords_";
  protected final String TEXT_169 = " = null;" + NL + "                try{" + NL + "                \tfor(int i_";
  protected final String TEXT_170 = "=0;i_";
  protected final String TEXT_171 = " <= reConnMaxNum_";
  protected final String TEXT_172 = ";i_";
  protected final String TEXT_173 = "++){" + NL + "                \t\ttry{" + NL + "\t                \t\tactivities_";
  protected final String TEXT_174 = " = client_";
  protected final String TEXT_175 = ".getLeadActivity(\"";
  protected final String TEXT_176 = "\",";
  protected final String TEXT_177 = ", ";
  protected final String TEXT_178 = ", includeTypes_";
  protected final String TEXT_179 = ", excludeTypes_";
  protected final String TEXT_180 = ",streamPosition_";
  protected final String TEXT_181 = ");" + NL + "\t                \t\tbreak;" + NL + "\t\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_182 = "){" + NL + "\t\t\t\t\t\t\tif(ex_";
  protected final String TEXT_183 = " instanceof org.apache.axis.AxisFault){" + NL + "\t\t\t\t\t\t\t\tString faultStr_";
  protected final String TEXT_184 = " = ((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_185 = ").getFaultString();" + NL + "\t\t\t\t\t\t\t\tif(faultStr_";
  protected final String TEXT_186 = "!=null && faultStr_";
  protected final String TEXT_187 = ".startsWith(\"201\")){" + NL + "\t\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_188 = ";" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif(i_";
  protected final String TEXT_189 = " != reConnMaxNum_";
  protected final String TEXT_190 = "){" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Connection error:\");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(ex_";
  protected final String TEXT_191 = ".getMessage());" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Waiting to retry...\");" + NL + "\t\t\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_192 = ");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Attempting to reconnect...\");" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_193 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t                }" + NL + "\t                globalMap.put(\"";
  protected final String TEXT_194 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_195 = ");\t" + NL + "\t                activityRecords_";
  protected final String TEXT_196 = " = activities_";
  protected final String TEXT_197 = ".getActivityRecordList();" + NL + "\t            }catch(org.apache.axis.AxisFault axisFault_";
  protected final String TEXT_198 = "){" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tif(!client_";
  protected final String TEXT_199 = ".isSystemError(axisFault_";
  protected final String TEXT_200 = ")){" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_201 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_202 = ");\t\t" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tclient_";
  protected final String TEXT_203 = ".inputExceptionFilter(axisFault_";
  protected final String TEXT_204 = ");" + NL + "\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_205 = "){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_206 = NL + "\t\t\t\t            throw(ex_";
  protected final String TEXT_207 = ");" + NL + "\t\t\t\t        ";
  protected final String TEXT_208 = NL + "\t\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_209 = ".getMessage());" + NL + "\t\t\t\t\t        break;" + NL + "\t\t\t\t        ";
  protected final String TEXT_210 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_211 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_212 = NL + "\t\t\t            throw(ex_";
  protected final String TEXT_213 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_214 = NL + "\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_215 = ".getMessage());" + NL + "\t\t\t\t        break;" + NL + "\t\t\t        ";
  protected final String TEXT_216 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif(activities_";
  protected final String TEXT_217 = " != null && activityRecords_";
  protected final String TEXT_218 = " != null){" + NL + "\t                for (int i_";
  protected final String TEXT_219 = " = 0; i_";
  protected final String TEXT_220 = " < activities_";
  protected final String TEXT_221 = ".getReturnCount(); i_";
  protected final String TEXT_222 = "++) {" + NL + "\t                    java.util.Map<String, String> result_";
  protected final String TEXT_223 = " = client_";
  protected final String TEXT_224 = ".readActivity(activityRecords_";
  protected final String TEXT_225 = "[i_";
  protected final String TEXT_226 = "]);";
  protected final String TEXT_227 = NL + "\t\t\tcom.marketo.www.mktows.StreamPosition streamPosition_";
  protected final String TEXT_228 = " = new com.marketo.www.mktows.StreamPosition();" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_229 = NL + "\t\t\t\tjava.text.SimpleDateFormat oldestcreatedat_";
  protected final String TEXT_230 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss Z\");" + NL + "\t\t\t\tif(";
  protected final String TEXT_231 = " != null){" + NL + "\t\t        \toldestcreatedat_";
  protected final String TEXT_232 = ".parse(";
  protected final String TEXT_233 = ");" + NL + "\t\t            java.util.Calendar calendar_oldestcreatedat_";
  protected final String TEXT_234 = " = oldestcreatedat_";
  protected final String TEXT_235 = ".getCalendar();" + NL + "\t\t            streamPosition_";
  protected final String TEXT_236 = ".setOldestCreatedAt(calendar_oldestcreatedat_";
  protected final String TEXT_237 = ");" + NL + "\t            }";
  protected final String TEXT_238 = NL + "\t            java.text.SimpleDateFormat latestcreatedat_";
  protected final String TEXT_239 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss Z\");" + NL + "\t            if(";
  protected final String TEXT_240 = " != null){" + NL + "\t\t        \tlatestcreatedat_";
  protected final String TEXT_241 = ".parse(";
  protected final String TEXT_242 = ");" + NL + "\t\t            java.util.Calendar calendar_latestcreatedat_";
  protected final String TEXT_243 = " = latestcreatedat_";
  protected final String TEXT_244 = ".getCalendar();" + NL + "\t\t            streamPosition_";
  protected final String TEXT_245 = ".setLatestCreatedAt(calendar_latestcreatedat_";
  protected final String TEXT_246 = ");" + NL + "\t\t        }";
  protected final String TEXT_247 = NL + "            " + NL + "            com.marketo.www.mktows.LastUpdateAtSelector leadSelector_";
  protected final String TEXT_248 = " = new com.marketo.www.mktows.LastUpdateAtSelector();" + NL + "            ";
  protected final String TEXT_249 = NL + "\t\t\t\tjava.text.SimpleDateFormat oldestupdatedat_";
  protected final String TEXT_250 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss Z\");" + NL + "\t\t\t\tif(";
  protected final String TEXT_251 = " != null){" + NL + "\t\t        \toldestupdatedat_";
  protected final String TEXT_252 = ".parse(";
  protected final String TEXT_253 = ");" + NL + "\t\t            java.util.Calendar calendar_oldestupdatedat_";
  protected final String TEXT_254 = " = oldestupdatedat_";
  protected final String TEXT_255 = ".getCalendar();" + NL + "\t\t            leadSelector_";
  protected final String TEXT_256 = ".setOldestUpdatedAt(calendar_oldestupdatedat_";
  protected final String TEXT_257 = ");" + NL + "\t            }";
  protected final String TEXT_258 = NL + "\t            java.text.SimpleDateFormat latestupdatedat_";
  protected final String TEXT_259 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss Z\");" + NL + "\t            if(";
  protected final String TEXT_260 = " != null){" + NL + "\t\t        \tlatestupdatedat_";
  protected final String TEXT_261 = ".parse(";
  protected final String TEXT_262 = ");" + NL + "\t\t            java.util.Calendar calendar_latestupdatedat_";
  protected final String TEXT_263 = " = latestupdatedat_";
  protected final String TEXT_264 = ".getCalendar();" + NL + "\t\t            leadSelector_";
  protected final String TEXT_265 = ".setLatestUpdatedAt(calendar_latestupdatedat_";
  protected final String TEXT_266 = ");" + NL + "\t\t        }";
  protected final String TEXT_267 = NL + "            " + NL + "            " + NL + "            while(true){" + NL + "                com.marketo.www.mktows.ResultGetLeadChanges changes_";
  protected final String TEXT_268 = " = null;" + NL + "                try{" + NL + "\t\t\t\t\tfor(int i_";
  protected final String TEXT_269 = "=0;i_";
  protected final String TEXT_270 = " <= reConnMaxNum_";
  protected final String TEXT_271 = ";i_";
  protected final String TEXT_272 = "++){" + NL + "\t            \t\ttry{" + NL + "\t                \t\tchanges_";
  protected final String TEXT_273 = " = client_";
  protected final String TEXT_274 = ".getLeadChanges(";
  protected final String TEXT_275 = ", includeTypes_";
  protected final String TEXT_276 = ", excludeTypes_";
  protected final String TEXT_277 = ", streamPosition_";
  protected final String TEXT_278 = ", leadSelector_";
  protected final String TEXT_279 = ");" + NL + "\t                \t\tbreak;\t" + NL + "\t\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_280 = "){" + NL + "\t\t\t\t\t\t\tif(ex_";
  protected final String TEXT_281 = " instanceof org.apache.axis.AxisFault){" + NL + "\t\t\t\t\t\t\t\tString faultStr_";
  protected final String TEXT_282 = " = ((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_283 = ").getFaultString();" + NL + "\t\t\t\t\t\t\t\tif(faultStr_";
  protected final String TEXT_284 = "!=null && faultStr_";
  protected final String TEXT_285 = ".startsWith(\"201\")){" + NL + "\t\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_286 = ";" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif(i_";
  protected final String TEXT_287 = " != reConnMaxNum_";
  protected final String TEXT_288 = "){" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Connection error:\");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(ex_";
  protected final String TEXT_289 = ".getMessage());" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Waiting to retry...\");" + NL + "\t\t\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_290 = ");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Attempting to reconnect...\");" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_291 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t                }" + NL + "                \tglobalMap.put(\"";
  protected final String TEXT_292 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_293 = ");" + NL + "                }catch(java.lang.Exception ex_";
  protected final String TEXT_294 = "){" + NL + "                \tif(ex_";
  protected final String TEXT_295 = " instanceof org.apache.axis.AxisFault){" + NL + "            \t\t\tif(!client_";
  protected final String TEXT_296 = ".isSystemError((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_297 = ")){" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_298 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_299 = ");\t\t" + NL + "\t\t\t\t\t\t}" + NL + "            \t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_300 = NL + "\t\t\t            throw(ex_";
  protected final String TEXT_301 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_302 = NL + "\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_303 = ".getMessage());" + NL + "\t\t\t\t        break;" + NL + "\t\t\t        ";
  protected final String TEXT_304 = NL + "\t\t\t\t}" + NL + "                if(changes_";
  protected final String TEXT_305 = " != null){" + NL + "\t                com.marketo.www.mktows.LeadChangeRecord[] changeRecords_";
  protected final String TEXT_306 = " = changes_";
  protected final String TEXT_307 = ".getLeadChangeRecordList();" + NL + "\t                for (int i_";
  protected final String TEXT_308 = " = 0; i_";
  protected final String TEXT_309 = " < changes_";
  protected final String TEXT_310 = ".getReturnCount(); i_";
  protected final String TEXT_311 = "++) {" + NL + "\t                    java.util.Map<String, String> result_";
  protected final String TEXT_312 = " = client_";
  protected final String TEXT_313 = ".readChange(changeRecords_";
  protected final String TEXT_314 = "[i_";
  protected final String TEXT_315 = "]);";
  protected final String TEXT_316 = NL + "\t\t\t\tif(result_";
  protected final String TEXT_317 = ".get(";
  protected final String TEXT_318 = ")!=null){" + NL + "    \t\t\t";
  protected final String TEXT_319 = "\t\t\t\t" + NL + "    \t\t\t\t\t";
  protected final String TEXT_320 = ".";
  protected final String TEXT_321 = " = result_";
  protected final String TEXT_322 = ".get(";
  protected final String TEXT_323 = ");" + NL + "    \t\t\t";
  protected final String TEXT_324 = NL + "    \t\t\t\t\t";
  protected final String TEXT_325 = ".";
  protected final String TEXT_326 = " = ParserUtils.parseTo_Date(result_";
  protected final String TEXT_327 = ".get(";
  protected final String TEXT_328 = "), ";
  protected final String TEXT_329 = ");" + NL + "    \t\t\t";
  protected final String TEXT_330 = "\t\t\t\t\t\t\t" + NL + "    \t\t\t\t\t";
  protected final String TEXT_331 = ".";
  protected final String TEXT_332 = " = ParserUtils.parseTo_";
  protected final String TEXT_333 = "(result_";
  protected final String TEXT_334 = ".get(";
  protected final String TEXT_335 = "));\t" + NL + "    \t\t\t";
  protected final String TEXT_336 = NL + "    \t\t\t}else{" + NL + "    \t\t\t\t";
  protected final String TEXT_337 = ".";
  protected final String TEXT_338 = " = ";
  protected final String TEXT_339 = ";" + NL + "    \t\t\t}";
  protected final String TEXT_340 = NL + NL + NL + NL + "        ";
  protected final String TEXT_341 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName().replace("_In","");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) { //1
	IMetadataTable metadata = metadatas.get(0);
	if (metadata != null) { //2
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();			
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
		if (nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){ //3
			IConnection outgoingConn = outgoingConns.get(0);
			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { //4

            String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");

            String clientAccessID = ElementParameterParser.getValue(node, "__CLIENT_ACCESSID__");
            String operation = ElementParameterParser.getValue(node, "__OPERATION__");
            String leadKeyType = ElementParameterParser.getValue(node, "__LEAD_KEYTYPE__");
            String leadKeyValue = ElementParameterParser.getValue(node, "__LEAD_KEYVALUE__");
            String leadKeyValues = ElementParameterParser.getValue(node, "__LEAD_KEYVALUES__");
            String leadSelector = ElementParameterParser.getValue(node, "__LEAD_SELECTOR__");
            String oldestUpdatedAt = ElementParameterParser.getValue(node, "__MUTIPLE_LEADS_OLDESTUPDATEDAT__");
            String lastestUpdatedAt = ElementParameterParser.getValue(node, "__MUTIPLE_LEADS_LASTUPDATEDAT__");
            
            String listParam = ElementParameterParser.getValue(node, "__LIST_PARAM__");
            String listParamValue = ElementParameterParser.getValue(node, "__LIST_PARAM_VALUE__");
            
            String batchSize = ElementParameterParser.getValue(node, "__BATCH_SIZE__");
            String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");
            String attemptConnTimes = ElementParameterParser.getValue(node, "__MAX_RECONN_ATTEMPS__");
            String attemptsInterval = ElementParameterParser.getValue(node, "__ATTEMPS_INTERVAL_TIME__");
            
            boolean setIncludeTypes = ("true").equals(ElementParameterParser.getValue(node,"__SET_INCLUDE_TYPES__"));
            boolean setExcludeTypes = ("true").equals(ElementParameterParser.getValue(node,"__SET_EXCLUDE_TYPES__"));
			List<Map<String, String>> includeTypesList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__INCLUDE_TYPES__");
			List<Map<String, String>> excludeTypesList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__EXCLUDE_TYPES__");
            boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
			List<String> includeTypes = null;
			if(setIncludeTypes){
				includeTypes = new ArrayList<String>();
    			for(Map<String,String> includeTypesMap:includeTypesList){
    				includeTypes.add(includeTypesMap.get("TYPES").toString());
    			} 
			}
			List<String> excludeTypes = null;
			if(setExcludeTypes){
				excludeTypes = new ArrayList<String>();
    			for(Map<String,String> excludeTypesMap:excludeTypesList){
    				excludeTypes.add(excludeTypesMap.get("TYPES").toString());
    			} 
			}
			if("getLeadChanges".equals(operation)||"getLeadActivity".equals(operation)){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    if(includeTypes==null){
    stringBuffer.append(TEXT_6);
    }else{
    stringBuffer.append(TEXT_7);
    for(String includeType:includeTypes){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(includeType);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    if(excludeTypes==null){
    stringBuffer.append(TEXT_13);
    }else{
    stringBuffer.append(TEXT_14);
    for(String excludeType:excludeTypes){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(excludeType);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    }
    
			}
			List<Map<String, String>> mappingList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING_INPUT__");
			Map<String,String> fldMapping = new HashMap<String,String>();
			for(Map<String,String> inputMapping:mappingList){
				String mapStr = inputMapping.get("PARAMETER_NAME");
				if("\"\"".equals(mapStr)){
					fldMapping.put(inputMapping.get("SCHEMA_COLUMN"),"\""+inputMapping.get("SCHEMA_COLUMN")+"\"");
				}else{	
					fldMapping.put(inputMapping.get("SCHEMA_COLUMN"),inputMapping.get("PARAMETER_NAME"));
				}
			}

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(attemptConnTimes);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
            String passwordFieldName = "__SECRET_KEY__";
            
    stringBuffer.append(TEXT_24);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_27);
    } else {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(clientAccessID);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_37);
    
			if("getLead".equals(operation)){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(leadKeyType);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(leadKeyValue);
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
    stringBuffer.append(attemptsInterval);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
			        if (dieOnError) {
			        
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
			        } else {
			        
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
			        }
			        
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
		        if (dieOnError) {
		        
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
		        } else {
		        
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
		        }
		        
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    			
			}else if("getMutipleLeads".equals(operation)){

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    for(String key:fldMapping.keySet()){
    stringBuffer.append(TEXT_97);
    stringBuffer.append(fldMapping.get(key));
    stringBuffer.append(TEXT_98);
    }
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(leadSelector);
    stringBuffer.append(TEXT_101);
    
			if("LeadKeySelector".equals(leadSelector)){
				batchSize = ElementParameterParser.getValue(node, "__MAX_RETURN__");
				
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(leadKeyType);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
			}else if("StaticListSelector".equals(leadSelector)){
				if("STATIC_LIST_NAME".equals(listParam)){
            	
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(listParamValue);
    stringBuffer.append(TEXT_110);
    
            	}else{
            	
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(listParamValue);
    stringBuffer.append(TEXT_113);
    
            	}
			}else{
				
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(oldestUpdatedAt);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(lastestUpdatedAt);
    stringBuffer.append(TEXT_117);
    
			}
			
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(batchSize);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(attemptsInterval);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
			        if (dieOnError) {
			        
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    
			        } else {
			        
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
			        }
			        
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
    
			}else if("getLeadActivity".equals(operation)){

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(leadKeyType);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(leadKeyValue);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(attemptsInterval);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    
				        if (dieOnError) {
				        
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    
				        } else {
				        
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    
				        }
				        
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    
			        if (dieOnError) {
			        
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
			        } else {
			        
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    
			        }
			        
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    
			}else if("getLeadChanges".equals(operation)){
				String oldestcreatedat = ElementParameterParser.getValue(node, "__LEADS_OLDESTCREATEDAT__");
				String latestcreatedat = ElementParameterParser.getValue(node, "__LEADS_LATESTCREATEDAT__");
				String oldestupdatedat = ElementParameterParser.getValue(node, "__LEADS_OLDESTUPDATEDAT__");
				String latestupdatedat = ElementParameterParser.getValue(node, "__LEADS_LATESTUPDATEDAT__");

    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    if(!"".equals(oldestcreatedat) && !"\"\"".equals(oldestcreatedat) && !"\"yyyy-MM-dd HH:mm:ss Z\"".equals(oldestcreatedat)){
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(oldestcreatedat);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(oldestcreatedat);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    }
    if(!"".equals(latestcreatedat) && !"\"\"".equals(latestcreatedat) && !"\"yyyy-MM-dd HH:mm:ss Z\"".equals(latestcreatedat)){
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(latestcreatedat);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(latestcreatedat);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    }
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    if(!"".equals(oldestupdatedat) && !"\"\"".equals(oldestupdatedat) && !"\"yyyy-MM-dd HH:mm:ss Z\"".equals(oldestupdatedat)){
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(oldestupdatedat);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(oldestupdatedat);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    }
    if(!"".equals(latestupdatedat) && !"\"\"".equals(latestupdatedat) && !"\"yyyy-MM-dd HH:mm:ss Z\"".equals(latestupdatedat)){
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(latestupdatedat);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(latestupdatedat);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    }
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(attemptsInterval);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    
			        if (dieOnError) {
			        
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    
			        } else {
			        
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    
			        }
			        
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    
			}
			

			for( int i = 0; i < columnList.size(); i++) {
			
				IMetadataColumn column = columnList.get(i);
				
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				
				String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_318);
    	
    				if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
    			
    stringBuffer.append(TEXT_319);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_320);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_323);
    
    				} else if(javaType == JavaTypesManager.DATE) { // Date
    			
    stringBuffer.append(TEXT_324);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_325);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_328);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_329);
    
    				}  else  { // other
    			
    stringBuffer.append(TEXT_330);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_331);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_332);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_335);
    
    				}
    			
    stringBuffer.append(TEXT_336);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_337);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_338);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_339);
    
			}
			}//4
		}//3
	}//2
}//1

    stringBuffer.append(TEXT_340);
    stringBuffer.append(TEXT_341);
    return stringBuffer.toString();
  }
}
