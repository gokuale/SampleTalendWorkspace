package org.talend.designer.codegen.translators.databases.as400;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.core.database.EDatabaseTypeName;
import java.util.List;
import java.util.Map;

public class TAS400CDCBeginJava
{
  protected static String nl;
  public static synchronized TAS400CDCBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAS400CDCBeginJava result = new TAS400CDCBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_30 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_31 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_33 = " - Uses an existing connection ";
  protected final String TEXT_34 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_36 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_37 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_38 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\tconn_";
  protected final String TEXT_41 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_42 = ", dbUser_";
  protected final String TEXT_43 = ", dbPwd_";
  protected final String TEXT_44 = ");" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\tconn_";
  protected final String TEXT_46 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\tconn_";
  protected final String TEXT_48 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\tconn_";
  protected final String TEXT_50 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\tconn_";
  protected final String TEXT_52 = ".setAutoCommit(";
  protected final String TEXT_53 = ");" + NL + "\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\tlog.";
  protected final String TEXT_55 = "(\"";
  protected final String TEXT_56 = " - \" + ";
  protected final String TEXT_57 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t    \t\tlog.";
  protected final String TEXT_59 = "(\"";
  protected final String TEXT_60 = "\");" + NL + "\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_62 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_64 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_65 = ": pstmt_";
  protected final String TEXT_66 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_67 = " += (countEach_";
  protected final String TEXT_68 = " < 0 ? 0 : ";
  protected final String TEXT_69 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_70 = NL + "\t\t    int nb_line_";
  protected final String TEXT_71 = " = 0;" + NL + "\t\t    ";
  protected final String TEXT_72 = NL + "            ";
  protected final String TEXT_73 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_74 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = "; ";
  protected final String TEXT_79 = NL + "  \t\t    " + NL + "\t\t    " + NL + "\t\t    ";
  protected final String TEXT_80 = NL + "\t\t    com.ibm.as400.access.AS400 as400_";
  protected final String TEXT_81 = " = new com.ibm.as400.access.AS400(";
  protected final String TEXT_82 = ",";
  protected final String TEXT_83 = ",decryptedPassword_";
  protected final String TEXT_84 = ");" + NL + "\t\t    ";
  protected final String TEXT_85 = NL + "\t\t    " + NL + "\t\t    ";
  protected final String TEXT_86 = NL + "\t\t\tString[] commands_";
  protected final String TEXT_87 = " =new String[]{" + NL + "\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t";
  protected final String TEXT_89 = "+\"/RUNCDC FILE(\"+";
  protected final String TEXT_90 = "+\"/\"+";
  protected final String TEXT_91 = "+\") LIBOUT(\"+";
  protected final String TEXT_92 = "+\") MODE(*DETACHED) MBROPT(*ADD)\"" + NL + "\t\t\t\t";
  protected final String TEXT_93 = NL + "    \t\t\t\t\t";
  protected final String TEXT_94 = NL + "    \t\t\t";
  protected final String TEXT_95 = NL + "    \t\t\t\t\t," + NL + "    \t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_97 = NL + "\t\t\t};" + NL + "\t\t\t" + NL + "\t\t\tfor(String cmd_";
  protected final String TEXT_98 = " : commands_";
  protected final String TEXT_99 = ") {" + NL + "\t\t\t\tcom.ibm.as400.access.CommandCall command_";
  protected final String TEXT_100 = " = new com.ibm.as400.access.CommandCall(as400_";
  protected final String TEXT_101 = ", cmd_";
  protected final String TEXT_102 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t\tif (!command_";
  protected final String TEXT_104 = ".run()) {" + NL + "\t\t\t\t\tSystem.err.println(\"fail when execute command : \" + cmd_";
  protected final String TEXT_105 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\t";
  protected final String TEXT_107 = NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tfor (com.ibm.as400.access.AS400Message msg_";
  protected final String TEXT_108 = " : command_";
  protected final String TEXT_109 = ".getMessageList()) {" + NL + "\t\t\t\t\tif(!\"CDC9990\".equals(msg_";
  protected final String TEXT_110 = ".getID())) {//no need to show the data retrieving success information" + NL + "\t\t\t\t\t\tSystem.out.println(\" msg: \" + msg_";
  protected final String TEXT_111 = ".getID() + \": \" + msg_";
  protected final String TEXT_112 = ".getText());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_114 = NL + "\t\t\t" + NL + "\t\t    ";
  protected final String TEXT_115 = NL + "\t\t        java.sql.Connection conn_";
  protected final String TEXT_116 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_117 = "\");" + NL + "\t\t        ";
  protected final String TEXT_118 = NL + "\t\t\tString driverClass_";
  protected final String TEXT_119 = " = \"com.ibm.as400.access.AS400JDBCDriver\"; " + NL + "\t\t        java.lang.Class.forName(driverClass_";
  protected final String TEXT_120 = ");" + NL + "\t\t        ";
  protected final String TEXT_121 = "    " + NL + "\t\t            String url_";
  protected final String TEXT_122 = " = \"jdbc:as400://\" + ";
  protected final String TEXT_123 = " + \"/\" + ";
  protected final String TEXT_124 = "; " + NL + "\t\t            ";
  protected final String TEXT_125 = "  " + NL + "\t\t            String url_";
  protected final String TEXT_126 = " = \"jdbc:as400://\" + ";
  protected final String TEXT_127 = " + \"/\" + ";
  protected final String TEXT_128 = " + \";\" + ";
  protected final String TEXT_129 = ";" + NL + "\t\t            ";
  protected final String TEXT_130 = NL + "\t\t        String dbUser_";
  protected final String TEXT_131 = " = ";
  protected final String TEXT_132 = ";" + NL + "\t\t        String dbPwd_";
  protected final String TEXT_133 = " = decryptedPassword_";
  protected final String TEXT_134 = ";" + NL + "\t\t        java.sql.Connection conn_";
  protected final String TEXT_135 = " = null;" + NL + "\t\t        ";
  protected final String TEXT_136 = NL + "            String dataTableName_";
  protected final String TEXT_137 = " = \"\";" + NL + "            String changeTableName_";
  protected final String TEXT_138 = " = \"\";";
  protected final String TEXT_139 = NL + NL + "    \t\tdataTableName_";
  protected final String TEXT_140 = " =";
  protected final String TEXT_141 = "+";
  protected final String TEXT_142 = "+";
  protected final String TEXT_143 = ";" + NL + "    \t\tchangeTableName_";
  protected final String TEXT_144 = " =";
  protected final String TEXT_145 = "+";
  protected final String TEXT_146 = "+";
  protected final String TEXT_147 = ";" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_148 = NL + "            String queryUpdatePrefix_";
  protected final String TEXT_149 = "= \"UPDATE \"+dataTableName_";
  protected final String TEXT_150 = "+\" SET TALEND_CDC_STATE='1' WHERE TALEND_CDC_STATE<>'x' AND TALEND_CDC_SUBSCRIBERS_NAME='\"+";
  protected final String TEXT_151 = "+\"'\";";
  protected final String TEXT_152 = NL + "            String queryLockUpdate_";
  protected final String TEXT_153 = " =\"\";" + NL + "            String getRowsToConsume_";
  protected final String TEXT_154 = " = \"SELECT ";
  protected final String TEXT_155 = ", ";
  protected final String TEXT_156 = " FROM \"+changeTableName_";
  protected final String TEXT_157 = NL + "\t\t\t";
  protected final String TEXT_158 = NL + "\t\t\t+\" WHERE TALEND_CDC_STATE='1' AND TALEND_CDC_SUBSCRIBERS_NAME='\"+";
  protected final String TEXT_159 = "+\"'\"" + NL + "\t\t\t";
  protected final String TEXT_160 = NL + "\t\t\t;" + NL + "            " + NL + "           \tString filterOnEvent_";
  protected final String TEXT_161 = " = \"\";" + NL + "           \tif (";
  protected final String TEXT_162 = "&&";
  protected final String TEXT_163 = "&&";
  protected final String TEXT_164 = ") {" + NL + "           \t\t// do nothing" + NL + "           \t} else if (!";
  protected final String TEXT_165 = "&&!";
  protected final String TEXT_166 = "&&!";
  protected final String TEXT_167 = ") {" + NL + "           \t\t// do nothing" + NL + "           \t} else {" + NL + "           \t\tfilterOnEvent_";
  protected final String TEXT_168 = " += \" AND (TALEND_CDC_TYPE IN (\";" + NL + "           \t\tboolean prec = false; " + NL + "           \t\tif (";
  protected final String TEXT_169 = ") {" + NL + "           \t\t\tfilterOnEvent_";
  protected final String TEXT_170 = " += \"'I'\";" + NL + "           \t\t\tprec=true;" + NL + "           \t\t}" + NL + "           \t\tif (";
  protected final String TEXT_171 = ") {" + NL + "           \t\t\tif (prec) {" + NL + "           \t\t\t\tfilterOnEvent_";
  protected final String TEXT_172 = " += \",\";" + NL + "           \t\t\t}" + NL + "           \t\t\tfilterOnEvent_";
  protected final String TEXT_173 = " += \"'U'\";" + NL + "           \t\t\tprec=true;" + NL + "           \t\t}" + NL + "           \t\tif (";
  protected final String TEXT_174 = ") {" + NL + "           \t\t\tif (prec) {" + NL + "           \t\t\t\tfilterOnEvent_";
  protected final String TEXT_175 = " += \",\";" + NL + "           \t\t\t}" + NL + "           \t\t\tfilterOnEvent_";
  protected final String TEXT_176 = " += \"'D'\";" + NL + "           \t\t}" + NL + "           \t\tfilterOnEvent_";
  protected final String TEXT_177 = " += \"))\";" + NL + "           \t}" + NL + "           \t" + NL + "           \t";
  protected final String TEXT_178 = NL + "           \tif (!";
  protected final String TEXT_179 = ".equals(\"\")) {" + NL + "           \t\tfilterOnEvent_";
  protected final String TEXT_180 = " += \" AND TALEND_CDC_MEMBER = '\"+";
  protected final String TEXT_181 = "+\"'\";" + NL + "           \t}" + NL + "\t\t\t";
  protected final String TEXT_182 = NL + "            " + NL + "            getRowsToConsume_";
  protected final String TEXT_183 = " += filterOnEvent_";
  protected final String TEXT_184 = ";" + NL + "            queryLockUpdate_";
  protected final String TEXT_185 = " += filterOnEvent_";
  protected final String TEXT_186 = ";" + NL + "            " + NL + "            getRowsToConsume_";
  protected final String TEXT_187 = " += \" ORDER BY TALEND_CDC_CREATION_DATE ASC\";" + NL + "\t\t    java.sql.Statement stmt_";
  protected final String TEXT_188 = " = conn_";
  protected final String TEXT_189 = ".createStatement();" + NL + "\t\t    " + NL + "\t\t    ";
  protected final String TEXT_190 = NL + "\t\t\t\t";
  protected final String TEXT_191 = NL + "\t\t\t    stmt_";
  protected final String TEXT_192 = ".executeUpdate(queryUpdatePrefix_";
  protected final String TEXT_193 = "+queryLockUpdate_";
  protected final String TEXT_194 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_195 = NL + "\t\t\t";
  protected final String TEXT_196 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_197 = " " + NL + "\t\t    java.sql.ResultSet rs_";
  protected final String TEXT_198 = " = stmt_";
  protected final String TEXT_199 = ".executeQuery(getRowsToConsume_";
  protected final String TEXT_200 = ");" + NL + "\t\t\t";
  protected final String TEXT_201 = NL + "\t\t\t" + NL + "\t\t    java.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_202 = " = rs_";
  protected final String TEXT_203 = ".getMetaData();" + NL + "\t\t    int colQtyInRs_";
  protected final String TEXT_204 = " = rsmd_";
  protected final String TEXT_205 = ".getColumnCount();" + NL + "\t\t    globalMap.put(\"";
  protected final String TEXT_206 = "_QUERY\",getRowsToConsume_";
  protected final String TEXT_207 = " + \"\\n\"+ queryLockUpdate_";
  protected final String TEXT_208 = ");" + NL + "\t\t    ";
  protected final String TEXT_209 = NL + "\t\t    String tmpContent_";
  protected final String TEXT_210 = " = null;" + NL + "\t        ";
  protected final String TEXT_211 = NL + "\t\t    while (rs_";
  protected final String TEXT_212 = ".next()) {" + NL + "\t\t        nb_line_";
  protected final String TEXT_213 = "++;" + NL + "\t\t        ";
  protected final String TEXT_214 = " \t" + NL + "\t\t                    if(colQtyInRs_";
  protected final String TEXT_215 = " < ";
  protected final String TEXT_216 = ") { \t\t" + NL + "\t\t                        ";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = "=";
  protected final String TEXT_219 = "; \t\t\t" + NL + "\t\t                    } else {" + NL + "\t\t                        ";
  protected final String TEXT_220 = NL + "\t\t                            tmpContent_";
  protected final String TEXT_221 = " = rs_";
  protected final String TEXT_222 = ".getString(";
  protected final String TEXT_223 = ");" + NL + "\t\t                            ";
  protected final String TEXT_224 = NL + "                                        if(tmpContent_";
  protected final String TEXT_225 = " != null) {" + NL + "                                            tmpContent_";
  protected final String TEXT_226 = " = tmpContent_";
  protected final String TEXT_227 = ";" + NL + "                                        }";
  protected final String TEXT_228 = NL + "\t\t                            if(tmpContent_";
  protected final String TEXT_229 = " != null && tmpContent_";
  protected final String TEXT_230 = ".length() > 0) {\t\t\t  \t" + NL + "\t\t                                ";
  protected final String TEXT_231 = ".";
  protected final String TEXT_232 = " = tmpContent_";
  protected final String TEXT_233 = ".charAt(0);\t\t\t  \t\t" + NL + "\t\t                            } else {\t\t\t  \t" + NL + "\t\t                                ";
  protected final String TEXT_234 = "\t\t\t  \t    " + NL + "\t\t                                    if(tmpContent_";
  protected final String TEXT_235 = " == null) {\t\t\t  \t   \t" + NL + "\t\t                                        ";
  protected final String TEXT_236 = ".";
  protected final String TEXT_237 = " = null;\t\t\t  \t\t\t" + NL + "\t\t                                    } else {\t\t\t  \t\t" + NL + "\t\t                                        ";
  protected final String TEXT_238 = ".";
  protected final String TEXT_239 = " = '\\0';\t\t\t  \t\t\t" + NL + "\t\t                                    }" + NL + "\t\t                                    ";
  protected final String TEXT_240 = "\t\t\t  \t\t" + NL + "\t\t                                    if((\"\").equals(tmpContent_";
  protected final String TEXT_241 = ")) {\t\t\t  \t\t" + NL + "\t\t                                        ";
  protected final String TEXT_242 = ".";
  protected final String TEXT_243 = " = '\\0';\t\t\t  \t\t\t" + NL + "\t\t                                    } else {\t\t\t  \t\t" + NL + "                        \t\t\t  \t\t\tthrow new RuntimeException(" + NL + "                        \t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_244 = "' in '";
  protected final String TEXT_245 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t" + NL + "\t\t                                    }\t\t\t  \t\t" + NL + "\t\t                                    ";
  protected final String TEXT_246 = NL + "\t\t                            }\t\t\t" + NL + "\t\t                            ";
  protected final String TEXT_247 = NL + "\t\t                            if(rs_";
  protected final String TEXT_248 = ".getTimestamp(";
  protected final String TEXT_249 = ") != null) {" + NL + "\t\t                                ";
  protected final String TEXT_250 = ".";
  protected final String TEXT_251 = " = new java.util.Date(rs_";
  protected final String TEXT_252 = ".getTimestamp(";
  protected final String TEXT_253 = ").getTime());" + NL + "\t\t                            } else {" + NL + "\t\t                                ";
  protected final String TEXT_254 = ".";
  protected final String TEXT_255 = " =  null;" + NL + "\t\t                            }" + NL + "\t\t                            ";
  protected final String TEXT_256 = NL + "\t\t                            ";
  protected final String TEXT_257 = ".";
  protected final String TEXT_258 = " = (List)rs_";
  protected final String TEXT_259 = ".getObject(";
  protected final String TEXT_260 = ");" + NL + "\t\t                            ";
  protected final String TEXT_261 = NL + "                                    tmpContent_";
  protected final String TEXT_262 = " = rs_";
  protected final String TEXT_263 = ".getString(";
  protected final String TEXT_264 = ");" + NL + "                                    if(tmpContent_";
  protected final String TEXT_265 = " != null) {";
  protected final String TEXT_266 = NL + "                                        ";
  protected final String TEXT_267 = ".";
  protected final String TEXT_268 = " = tmpContent_";
  protected final String TEXT_269 = ";" + NL + "                                    } else {";
  protected final String TEXT_270 = NL + "                                        ";
  protected final String TEXT_271 = ".";
  protected final String TEXT_272 = " = null;" + NL + "                                    }\t\t                            " + NL + "\t\t                            ";
  protected final String TEXT_273 = NL + "\t                                if(rs_";
  protected final String TEXT_274 = ".getObject(";
  protected final String TEXT_275 = ") != null) {" + NL + "\t                                    ";
  protected final String TEXT_276 = ".";
  protected final String TEXT_277 = " = rs_";
  protected final String TEXT_278 = ".get";
  protected final String TEXT_279 = "(";
  protected final String TEXT_280 = ");" + NL + "\t                                } else {" + NL + "\t                                    ";
  protected final String TEXT_281 = NL + "\t                                        ";
  protected final String TEXT_282 = ".";
  protected final String TEXT_283 = " = null;" + NL + "\t                                        ";
  protected final String TEXT_284 = NL + "\t                                        throw new RuntimeException(\"Null value in non-Nullable column\");" + NL + "\t                                        ";
  protected final String TEXT_285 = NL + "\t                                }" + NL + "\t                                ";
  protected final String TEXT_286 = NL + "\t\t                    } \t\t" + NL + "\t\t                    ";
  protected final String TEXT_287 = NL + "\t\t                            ";
  protected final String TEXT_288 = ".";
  protected final String TEXT_289 = "=";
  protected final String TEXT_290 = ".";
  protected final String TEXT_291 = ";" + NL + "\t\t                            ";
  protected final String TEXT_292 = NL;
  protected final String TEXT_293 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    if (cid.startsWith("tImpala") || cid.startsWith("tHive")) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_34);
    } else {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
			connect_end();
		}

		public void connect_begin(){
			logInfo(node,"info",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"info",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"info",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"info",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"info",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_53);
    
		}

		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = dbquery.replaceAll("\n"," ");
			dbquery = dbquery.replaceAll("\r"," ");
			logInfo(node,"info",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"info",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_54);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_57);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_58);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_60);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_69);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();	
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	String cdctable= ElementParameterParser.getValue(node, "__DATATABLE__");
	String suscriber = ElementParameterParser.getValue(node, "__SUSCRIBER__");
	
	String sourceLibrary = ElementParameterParser.getValue(node,"__SOURCE_LIB__");
	String member = ElementParameterParser.getValue(node,"__MEMBER__");
	
	boolean eventsTypeInsert = "true".compareTo(ElementParameterParser.getValue(node,"__EVENTS_TYPE_INSERT__"))==0;
	boolean eventsTypeUpdate = "true".compareTo(ElementParameterParser.getValue(node,"__EVENTS_TYPE_UPDATE__"))==0;
	boolean eventsTypeDelete = "true".compareTo(ElementParameterParser.getValue(node,"__EVENTS_TYPE_DELETE__"))==0;
	
   	boolean processAllData = "true".equals(ElementParameterParser.getValue(node, "__PROCESS_ALL_DATA__"));
    processAllData = processAllData && eventsTypeInsert && eventsTypeUpdate && eventsTypeDelete;
	
    boolean whetherTrimAllCol = ("true").equals(ElementParameterParser.getValue(node, "__TRIM_ALL_COLUMN__"));
    List<Map<String, String>> trimColumnList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIM_COLUMN__");
    
    boolean disableFtpCommand = "true".equals(ElementParameterParser.getValue(node, "__DISABLE_FTP_CALL__"));
    boolean customiseFtpCommand = "true".equals(ElementParameterParser.getValue(node, "__CUSTOMISE_FTP_COMMAND__"));
    List<Map<String, String>> ftpCommands = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FTP_COMMANDS__");
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas != null) && (metadatas.size() > 0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata != null) {
		    
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
            String passwordFieldName = "__PASS__";
            
    stringBuffer.append(TEXT_72);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_75);
    } else {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    if(!disableFtpCommand || processAllData) {
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    if(!disableFtpCommand) {
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    if(!customiseFtpCommand) {
    stringBuffer.append(TEXT_88);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(sourceLibrary);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cdctable);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_92);
    } else if(ftpCommands!=null){
					for (int i = 0; i < ftpCommands.size(); i++) {
    					Map<String, String> ftpCommand = ftpCommands.get(i);
    			
    stringBuffer.append(TEXT_93);
    stringBuffer.append(ftpCommand.get("FTP_COMMAND"));
    stringBuffer.append(TEXT_94);
    
    					if(i < (ftpCommands.size() - 1)) {
    			
    stringBuffer.append(TEXT_95);
    
    					}
    				}
				
    stringBuffer.append(TEXT_96);
    }
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executing Command:\"+cmd_"+cid+"+\"");
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    log4jCodeGenerateUtil.logInfo(node,"error",cid+" - Executed unsuccessfully.");
    stringBuffer.append(TEXT_106);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executed successfully.");
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - msg: \"+msg_"+cid+".getID()+\":\"+msg_"+cid+".getText()+\"");
    stringBuffer.append(TEXT_113);
    }
    stringBuffer.append(TEXT_114);
    
		    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(("true").equals(useExistingConn)) {
		        String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		        String conn = "conn_" + connection;
		        
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_117);
    
            	log4jCodeGenerateUtil.useExistConnection(node);
		    } else {
		        
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
		        if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {        
		            
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_124);
     
		        } else {
		            
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_129);
    
		        }
		        
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
            	log4jCodeGenerateUtil.debugConnectionParams(node);
            	log4jCodeGenerateUtil.connect(node);
		    }
		    
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    String quote=TalendTextUtils.getQuoteByDBType(EDatabaseTypeName.AS400.getXmlName(),false);
              String oneQuote=TalendTextUtils.addQuotes(quote);
            
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cdctable);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cdctable);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_147);
    if(!processAllData) {
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(suscriber);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
            for (IMetadataColumn column: metadata.getListColumns()) {
            	
    stringBuffer.append(TalendTextUtils.addSQLFieldQuotes(column.getOriginalDbColumnName(),quote));
    
            	if (metadata.getListColumns().indexOf(column) != (metadata.getListColumns().size() -1)) {
            		
    stringBuffer.append(TEXT_155);
    
            	}
            }
            
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    if(!processAllData) {
    stringBuffer.append(TEXT_158);
    stringBuffer.append(suscriber);
    stringBuffer.append(TEXT_159);
    }
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(eventsTypeInsert);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(eventsTypeUpdate);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(eventsTypeDelete);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(eventsTypeInsert);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(eventsTypeUpdate);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(eventsTypeDelete);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(eventsTypeInsert);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(eventsTypeUpdate);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(eventsTypeDelete);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    if(!processAllData) {
    stringBuffer.append(TEXT_178);
    stringBuffer.append(member);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(member);
    stringBuffer.append(TEXT_181);
    }
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    if(!processAllData) {
    stringBuffer.append(TEXT_190);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executing SQL:\"+queryUpdatePrefix_"+cid+"+queryLockUpdate_"+cid+"+\"");
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executed successfully.");
    stringBuffer.append(TEXT_195);
    }
    stringBuffer.append(TEXT_196);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executing SQL:\"+getRowsToConsume_"+cid+"+\"");
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executed successfully.");
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    
		    List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		    List<IMetadataColumn> columnList = metadata.getListColumns();
		    
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Retrieving records from the database.");
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
		        if(conns != null && conns.size() > 0) {
		            IConnection conn = conns.get(0);
		            String firstConnName = conn.getName();
		            int currentColNo = 1;
		            for(IMetadataColumn column : columnList) { 	
                        boolean whetherTrimCol = false;
                        if((trimColumnList != null && trimColumnList.size() > 0) && !whetherTrimAllCol) {
                            for(Map<String, String> trimColumn : trimColumnList) {
                                if(column.getLabel().equals(trimColumn.get("SCHEMA_COLUMN"))) {
                                    if(("true").equals(trimColumn.get("TRIM"))) {
                                        whetherTrimCol = true;
                                        break;
                                    }
                                }
                            }
                        }
                        String trimMethod = "";
                        if(whetherTrimAllCol || whetherTrimCol) {
                            trimMethod = ".trim()";
                        }                        
		                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		                String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate); 	
		                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		                    
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_218);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_219);
    
		                        if(("byte[]").equals(typeToGenerate)) {
		                            typeToGenerate = "Bytes";
		                        } else if(("java.util.Date").equals(typeToGenerate)) {
		                            typeToGenerate = "Timestamp";
		                        } else if(("Integer").equals(typeToGenerate)) {
		                            typeToGenerate = "Int";
		                        } else {
		                            typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
		                        }		  
		                        if(("Char").equals(typeToGenerate) || ("Character").equals(typeToGenerate)) {
		                            
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_223);
    
                                    if(whetherTrimAllCol || whetherTrimCol) {
                                        
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_227);
    
                                    }		                            
		                            
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    
		                                if(("Character").equals(typeToGenerate)) {
		                                    
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_237);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_239);
    
		                                } else {
		                                    
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_243);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_244);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_245);
    
		                                }
		                                
    stringBuffer.append(TEXT_246);
    
		                        } else if(("Timestamp").equals(typeToGenerate)) {
		                            
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_255);
    
		                        } else if (("List").equals(typeToGenerate)) {
		                            
    stringBuffer.append(TEXT_256);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_260);
    
		                        } else if(("String").equals(typeToGenerate)) {
		                            
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_272);
    
		                        } else {	  
		                            
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_280);
    
	                                    if(column.isNullable()) {
	                                        
    stringBuffer.append(TEXT_281);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_283);
    
	                                    } else {
	                                        
    stringBuffer.append(TEXT_284);
        
	                                    }
	                                    
    stringBuffer.append(TEXT_285);
    
		                        }
		                        
    stringBuffer.append(TEXT_286);
      
		                    currentColNo++;
		                }
		        	}
		            log4jCodeGenerateUtil.logInfo(node,"debug",cid+" - Retrieving the record \"+nb_line_"+cid+"+\"."); 
		            if(conns.size() > 1) {
		                for(int connNO = 1 ; connNO < conns.size() ; connNO++) {
		                    IConnection conn2 = conns.get(connNO);
		                    if((conn2.getName().compareTo(firstConnName) != 0) && (conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
		                        for(IMetadataColumn column : columnList) {
		                            
    stringBuffer.append(TEXT_287);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_288);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_289);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_291);
     
		                        }
		                    }
		                }
		            }
		        }
		}
	}

    stringBuffer.append(TEXT_292);
    stringBuffer.append(TEXT_293);
    return stringBuffer.toString();
  }
}
