package org.talend.designer.codegen.translators.databases.sybase;

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

public class TSybaseCDCBeginJava
{
  protected static String nl;
  public static synchronized TSybaseCDCBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSybaseCDCBeginJava result = new TSybaseCDCBeginJava();
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
  protected final String TEXT_72 = NL + "        \t\tjava.sql.Connection conn_";
  protected final String TEXT_73 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_74 = "\");" + NL + "        \t\t";
  protected final String TEXT_75 = NL + "\t\t\tString driverClass_";
  protected final String TEXT_76 = " = \"com.sybase.jdbc3.jdbc.SybDriver\"; " + NL + "                java.lang.Class.forName(driverClass_";
  protected final String TEXT_77 = ");" + NL + "                String url_";
  protected final String TEXT_78 = " = \"jdbc:sybase:Tds:\" + ";
  protected final String TEXT_79 = " + \":\" + ";
  protected final String TEXT_80 = " + \"/\" + ";
  protected final String TEXT_81 = ";" + NL + "                String dbUser_";
  protected final String TEXT_82 = " = ";
  protected final String TEXT_83 = ";" + NL + "                ";
  protected final String TEXT_84 = NL + "                ";
  protected final String TEXT_85 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_86 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_89 = " = ";
  protected final String TEXT_90 = "; ";
  protected final String TEXT_91 = NL + "                  " + NL + "                " + NL + "                String dbPwd_";
  protected final String TEXT_92 = " = decryptedPassword_";
  protected final String TEXT_93 = ";" + NL + "                java.sql.Connection conn_";
  protected final String TEXT_94 = " = null;";
  protected final String TEXT_95 = NL + "        \t// String dbschema_";
  protected final String TEXT_96 = " = ";
  protected final String TEXT_97 = ";";
  protected final String TEXT_98 = "  " + NL + "                String dbschema_";
  protected final String TEXT_99 = " = ";
  protected final String TEXT_100 = ";  ";
  protected final String TEXT_101 = "  " + NL + "                 String dbschema_";
  protected final String TEXT_102 = " = ";
  protected final String TEXT_103 = ";  ";
  protected final String TEXT_104 = " " + NL + "            String dataTableName_";
  protected final String TEXT_105 = " = \"\";" + NL + "            String changeTableName_";
  protected final String TEXT_106 = " = \"\";";
  protected final String TEXT_107 = NL + "            " + NL + "\t\t\tif(dbschema_";
  protected final String TEXT_108 = " == null || dbschema_";
  protected final String TEXT_109 = ".trim().length() == 0) {" + NL + "    \t\t\tdataTableName_";
  protected final String TEXT_110 = " =";
  protected final String TEXT_111 = "+\"TCDC_\" + ";
  protected final String TEXT_112 = "+";
  protected final String TEXT_113 = ";" + NL + "    \t\t\tchangeTableName_";
  protected final String TEXT_114 = " =";
  protected final String TEXT_115 = "+\"TCDC_VIEW_\" + ";
  protected final String TEXT_116 = "+";
  protected final String TEXT_117 = ";" + NL + "\t\t\t} else {" + NL + "    \t\t\tdataTableName_";
  protected final String TEXT_118 = " = ";
  protected final String TEXT_119 = "+dbschema_";
  protected final String TEXT_120 = " +";
  protected final String TEXT_121 = "+ \".\"+";
  protected final String TEXT_122 = "+\"TCDC_\" + ";
  protected final String TEXT_123 = "+";
  protected final String TEXT_124 = ";" + NL + "    \t\t\tchangeTableName_";
  protected final String TEXT_125 = " = ";
  protected final String TEXT_126 = "+dbschema_";
  protected final String TEXT_127 = " + ";
  protected final String TEXT_128 = "+\".\"+";
  protected final String TEXT_129 = "+\"TCDC_VIEW_\" + ";
  protected final String TEXT_130 = "+";
  protected final String TEXT_131 = ";" + NL + "\t\t\t}" + NL + "            String queryUpdatePrefix_";
  protected final String TEXT_132 = "=\" UPDATE \"+dataTableName_";
  protected final String TEXT_133 = "+\" SET TALEND_CDC_STATE='1' WHERE TALEND_CDC_STATE<>'x' AND TALEND_CDC_SUBSCRIBERS_NAME='\"+";
  protected final String TEXT_134 = "+\"'\";" + NL + "            String queryLockUpdate_";
  protected final String TEXT_135 = " =\"\";" + NL + "            String getRowsToConsume_";
  protected final String TEXT_136 = " = \"SELECT ";
  protected final String TEXT_137 = ", ";
  protected final String TEXT_138 = " FROM \"+changeTableName_";
  protected final String TEXT_139 = " +\" WHERE TALEND_CDC_SUBSCRIBERS_NAME='\"+";
  protected final String TEXT_140 = "+\"'\";" + NL + "            ";
  protected final String TEXT_141 = NL + "            getRowsToConsume_";
  protected final String TEXT_142 = " += \"";
  protected final String TEXT_143 = "\";" + NL + "            queryLockUpdate_";
  protected final String TEXT_144 = " += \"";
  protected final String TEXT_145 = "\";" + NL + "            " + NL + "            getRowsToConsume_";
  protected final String TEXT_146 = " += \" ORDER BY TALEND_CDC_CREATION_DATE ASC\";" + NL + "            ";
  protected final String TEXT_147 = NL + "            String limitRequest = \"\";" + NL + "            if (\"\".compareTo(";
  protected final String TEXT_148 = ")!=0) {" + NL + "            \tlimitRequest = \" SET ROWCOUNT \"+";
  protected final String TEXT_149 = " ;" + NL + "            }" + NL + "           // queryLockUpdate_";
  protected final String TEXT_150 = " = limitRequest + queryLockUpdate_";
  protected final String TEXT_151 = ";" + NL + "            limitRequest = limitRequest + queryUpdatePrefix_";
  protected final String TEXT_152 = ";";
  protected final String TEXT_153 = NL + "            " + NL + "\t\t    ";
  protected final String TEXT_154 = NL + "\t\t        java.sql.Statement stmt_";
  protected final String TEXT_155 = " = conn_";
  protected final String TEXT_156 = ".createStatement();" + NL + "\t\t        ((com.mysql.jdbc.Statement)stmt_";
  protected final String TEXT_157 = ").enableStreamingResults();" + NL + "\t\t        ";
  protected final String TEXT_158 = NL + "\t\t        java.sql.Statement stmt_";
  protected final String TEXT_159 = " = conn_";
  protected final String TEXT_160 = ".createStatement();" + NL + "\t\t        ";
  protected final String TEXT_161 = NL + "\t\t    if(limitRequest != null && !\"\".equals(limitRequest) ){ " + NL + "\t\t\t\t";
  protected final String TEXT_162 = NL + "\t\t    \tstmt_";
  protected final String TEXT_163 = ".executeUpdate(limitRequest+queryLockUpdate_";
  protected final String TEXT_164 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_165 = NL + "\t\t    }else{" + NL + "\t\t    \t";
  protected final String TEXT_166 = NL + "\t\t    \tstmt_";
  protected final String TEXT_167 = ".executeUpdate(queryUpdatePrefix_";
  protected final String TEXT_168 = "+queryLockUpdate_";
  protected final String TEXT_169 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_170 = NL + "\t\t    }" + NL + "\t\t    ";
  protected final String TEXT_171 = "  " + NL + "            java.sql.ResultSet rs_";
  protected final String TEXT_172 = " = stmt_";
  protected final String TEXT_173 = ".executeQuery(getRowsToConsume_";
  protected final String TEXT_174 = ");" + NL + "\t\t\t";
  protected final String TEXT_175 = NL + NL + "\t\t    java.util.Calendar calendar_";
  protected final String TEXT_176 = " = java.util.Calendar.getInstance();" + NL + "\t\t    calendar_";
  protected final String TEXT_177 = ".set(0, 0, 0, 0, 0, 0);" + NL + "\t\t    java.util.Date year0_";
  protected final String TEXT_178 = " = calendar_";
  protected final String TEXT_179 = ".getTime();" + NL + "\t\t    globalMap.put(\"";
  protected final String TEXT_180 = "_QUERY\",getRowsToConsume_";
  protected final String TEXT_181 = ");" + NL + "\t\t    ";
  protected final String TEXT_182 = NL + "        \tString tmpContent_";
  protected final String TEXT_183 = " = null;" + NL + "\t        ";
  protected final String TEXT_184 = NL + "            java.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_185 = " = rs_";
  protected final String TEXT_186 = ".getMetaData();" + NL + "            int colQtyInRs_";
  protected final String TEXT_187 = " = rsmd_";
  protected final String TEXT_188 = ".getColumnCount();" + NL + "           " + NL + "            while (rs_";
  protected final String TEXT_189 = ".next()) {" + NL + "                nb_line_";
  protected final String TEXT_190 = "++;";
  protected final String TEXT_191 = " \t" + NL + "                            if(colQtyInRs_";
  protected final String TEXT_192 = " < ";
  protected final String TEXT_193 = ") { \t\t";
  protected final String TEXT_194 = NL + "                                ";
  protected final String TEXT_195 = ".";
  protected final String TEXT_196 = " = ";
  protected final String TEXT_197 = "; \t\t\t" + NL + "                            } else {";
  protected final String TEXT_198 = NL + "                                    tmpContent_";
  protected final String TEXT_199 = " = rs_";
  protected final String TEXT_200 = ".getString(";
  protected final String TEXT_201 = ");";
  protected final String TEXT_202 = NL + "                                        if(tmpContent_";
  protected final String TEXT_203 = " != null) {" + NL + "                                            tmpContent_";
  protected final String TEXT_204 = " = tmpContent_";
  protected final String TEXT_205 = ";" + NL + "                                        }";
  protected final String TEXT_206 = "                                    " + NL + "                                    if(tmpContent_";
  protected final String TEXT_207 = " != null && tmpContent_";
  protected final String TEXT_208 = ".length() > 0) {\t\t\t  \t";
  protected final String TEXT_209 = NL + "                                        ";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = " = tmpContent_";
  protected final String TEXT_212 = ".charAt(0);\t\t\t  \t\t" + NL + "                                    } else {\t\t\t  \t";
  protected final String TEXT_213 = "\t\t\t  \t    " + NL + "                                            if(tmpContent_";
  protected final String TEXT_214 = " == null) {\t\t\t  \t   \t";
  protected final String TEXT_215 = NL + "                                                ";
  protected final String TEXT_216 = ".";
  protected final String TEXT_217 = " = null;\t\t\t  \t\t\t" + NL + "                                            } else {\t\t\t  \t\t";
  protected final String TEXT_218 = NL + "                                                ";
  protected final String TEXT_219 = ".";
  protected final String TEXT_220 = " = '\\0';\t\t\t  \t\t\t" + NL + "                                            }";
  protected final String TEXT_221 = "\t\t\t  \t\t" + NL + "                                            if(tmpContent_";
  protected final String TEXT_222 = ".equals(\"\")) {\t\t\t  \t\t";
  protected final String TEXT_223 = NL + "                                                ";
  protected final String TEXT_224 = ".";
  protected final String TEXT_225 = " = '\\0';\t\t\t  \t\t\t" + NL + "                                            } else {\t\t\t  \t\t" + NL + "                        \t\t\t  \t\t\tthrow new RuntimeException(" + NL + "                        \t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_226 = "' in '";
  protected final String TEXT_227 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t" + NL + "                                            }\t\t\t  \t\t";
  protected final String TEXT_228 = NL + "                                    }\t\t\t";
  protected final String TEXT_229 = NL + "                                    if(rs_";
  protected final String TEXT_230 = ".getTimestamp(";
  protected final String TEXT_231 = ") != null) {";
  protected final String TEXT_232 = NL + "                                        ";
  protected final String TEXT_233 = ".";
  protected final String TEXT_234 = " = new java.util.Date(rs_";
  protected final String TEXT_235 = ".getTimestamp(";
  protected final String TEXT_236 = ").getTime());" + NL + "                                    } else {";
  protected final String TEXT_237 = NL + "                                        ";
  protected final String TEXT_238 = ".";
  protected final String TEXT_239 = " = null;" + NL + "                                    }";
  protected final String TEXT_240 = NL + "                                    ";
  protected final String TEXT_241 = ".";
  protected final String TEXT_242 = " = (List)rs_";
  protected final String TEXT_243 = ".getObject(";
  protected final String TEXT_244 = ");";
  protected final String TEXT_245 = NL + "                                    tmpContent_";
  protected final String TEXT_246 = " = rs_";
  protected final String TEXT_247 = ".getString(";
  protected final String TEXT_248 = ");" + NL + "                                    if(tmpContent_";
  protected final String TEXT_249 = " != null) {";
  protected final String TEXT_250 = NL + "                                        ";
  protected final String TEXT_251 = ".";
  protected final String TEXT_252 = " = tmpContent_";
  protected final String TEXT_253 = ";" + NL + "                                    } else {";
  protected final String TEXT_254 = NL + "                                        ";
  protected final String TEXT_255 = ".";
  protected final String TEXT_256 = " = null;" + NL + "                                    }                                    ";
  protected final String TEXT_257 = NL + "                                    if(rs_";
  protected final String TEXT_258 = ".getObject(";
  protected final String TEXT_259 = ") != null) {";
  protected final String TEXT_260 = NL + "                                        ";
  protected final String TEXT_261 = ".";
  protected final String TEXT_262 = " = rs_";
  protected final String TEXT_263 = ".get";
  protected final String TEXT_264 = "(";
  protected final String TEXT_265 = ");" + NL + "                                    } else {";
  protected final String TEXT_266 = NL + "                                            ";
  protected final String TEXT_267 = ".";
  protected final String TEXT_268 = " = null;";
  protected final String TEXT_269 = "    " + NL + "                                            throw new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_270 = NL + "                                    }";
  protected final String TEXT_271 = NL + "                            } \t\t";
  protected final String TEXT_272 = NL + "                                    ";
  protected final String TEXT_273 = ".";
  protected final String TEXT_274 = " = ";
  protected final String TEXT_275 = ".";
  protected final String TEXT_276 = ";";
  protected final String TEXT_277 = NL;
  protected final String TEXT_278 = NL;

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
	String dbServer = ElementParameterParser.getValue(node, "__SERVER__");
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	String enableStream = ElementParameterParser.getValue(node, "__ENABLE_STREAM__");
	String suscriber = ElementParameterParser.getValue(node, "__SUSCRIBER__");
	String dataTable = ElementParameterParser.getValue(node, "__DATATABLE__");
	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
	String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
    boolean whetherTrimAllCol = ElementParameterParser.getValue(node, "__TRIM_ALL_COLUMN__").equals("true");
    boolean eventsTypeInsert = "true".compareTo(ElementParameterParser.getValue(node,"__EVENTS_TYPE_INSERT__"))==0;
	boolean eventsTypeUpdate = "true".compareTo(ElementParameterParser.getValue(node,"__EVENTS_TYPE_UPDATE__"))==0;
	boolean eventsTypeDelete = "true".compareTo(ElementParameterParser.getValue(node,"__EVENTS_TYPE_DELETE__"))==0;
    List<Map<String, String>> trimColumnList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIM_COLUMN__");
    	   
	List<IMetadataTable> metadatas = node.getMetadataList();	
	boolean useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__").equals("true");	
	if ((metadatas != null) && (metadatas.size() > 0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
		    
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    	
        	if(useExistingConn){
        		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
        		String conn = "conn_" + connection;
        		
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_74);
    
            	log4jCodeGenerateUtil.useExistConnection(node);
        	} else {       
        	    
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(dbServer);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_83);
    
                String passwordFieldName = "__PASS__";
                
    stringBuffer.append(TEXT_84);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_87);
    } else {
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
            	log4jCodeGenerateUtil.debugConnectionParams(node);
            	log4jCodeGenerateUtil.connect(node);
        	}
            
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_97);
    if(dbschema != null && !"".equals(dbschema)){
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_100);
    } else {
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    String quote=TalendTextUtils.getQuoteByDBType(EDatabaseTypeName.SYBASEASE.getXmlName(),false);
              String oneQuote=TalendTextUtils.addQuotes(quote);
            
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(dataTable);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(dataTable);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(dataTable);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(dataTable);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(suscriber);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
            for (IMetadataColumn column: metadata.getListColumns()) {
            	
    stringBuffer.append(TalendTextUtils.addSQLFieldQuotes(column.getOriginalDbColumnName(),quote));
    
            	if (metadata.getListColumns().indexOf(column) != (metadata.getListColumns().size() -1)) {
            		
    stringBuffer.append(TEXT_137);
    
            	}
            }
            
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(suscriber);
    stringBuffer.append(TEXT_140);
    
            	String filterOnEvent = "";
            	if (eventsTypeInsert&&eventsTypeUpdate&&eventsTypeDelete) {
            		// do nothing
            	} else if (!eventsTypeInsert&&!eventsTypeUpdate&&!eventsTypeDelete) {
            		// do nothing
            	} else {
            		filterOnEvent += " AND (TALEND_CDC_TYPE IN (";
            		boolean prec = false; 
            		if (eventsTypeInsert) {
            			filterOnEvent += "'I'";
            			prec=true;
            		}
            		if (eventsTypeUpdate) {
            			if (prec) {
            				filterOnEvent += ",";
            			}
            			filterOnEvent += "'U'";
            			prec=true;
            		}
            		if (eventsTypeDelete) {
            			if (prec) {
            				filterOnEvent += ",";
            			}
            			filterOnEvent += "'D'";
            		}
            		filterOnEvent += "))";
            	}
            
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(filterOnEvent );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(filterOnEvent );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
     if ((limit!=null)&&(limit.compareTo("")!=0)) { 
    stringBuffer.append(TEXT_147);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
     } 
    stringBuffer.append(TEXT_153);
    
		    if(enableStream.equals("true")) {
		        
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    
		    } else {
		        
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
		    }
		    
    stringBuffer.append(TEXT_161);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executing SQL:\"+limitRequest+queryLockUpdate_"+cid+"+\"");
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executed successfully.");
    stringBuffer.append(TEXT_165);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executing SQL:\"+queryUpdatePrefix_"+cid+"+queryLockUpdate_"+cid+"+\"");
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executed successfully.");
    stringBuffer.append(TEXT_170);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executing SQL:\"+getRowsToConsume_"+cid+"+\"");
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executed successfully.");
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    
        	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
        	List<IMetadataColumn> columnList = metadata.getListColumns();
        	
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Retrieving records from the database.");
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    
                if(conns != null && conns.size() > 0) {
                    IConnection conn = conns.get(0);
                    String firstConnName = conn.getName();
                    int currentColNo = 1;
                    for(IMetadataColumn column : columnList) { 	
                        boolean whetherTrimCol = false;
                        if((trimColumnList != null && trimColumnList.size() > 0) && !whetherTrimAllCol) {
                            for(Map<String, String> trimColumn : trimColumnList) {
                                if(column.getLabel().equals(trimColumn.get("SCHEMA_COLUMN"))) {
                                    if(trimColumn.get("TRIM").equals("true")) {
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
                            
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_196);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_197);
    
                                if(typeToGenerate.equals("byte[]")) {
                                    typeToGenerate = "Bytes";
                                } else if(typeToGenerate.equals("java.util.Date")) {
                                    typeToGenerate = "Timestamp";
                                } else if(typeToGenerate.equals("Integer")) {
                                    typeToGenerate = "Int";
                                } else {
                                    typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
                                }		  
                                if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                                    
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_201);
    
                                    if(whetherTrimAllCol || whetherTrimCol) {
                                        
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_205);
    
                                    }
                                    
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    
                                        if(typeToGenerate.equals("Character")) {
                                            
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_217);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_220);
    
                                        } else {
                                            
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_225);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_226);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_227);
    
                                        }
                                        
    stringBuffer.append(TEXT_228);
    
                                } else if(typeToGenerate.equals("Timestamp")) {
                                    
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_239);
    
                                } else if (typeToGenerate.equals("List")) {
                                    
    stringBuffer.append(TEXT_240);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_244);
     	
                                } else if(typeToGenerate.equals("String")) {
                                    
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_256);
    
                                } else {		  
                                    
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_265);
    
                                        if(column.isNullable()) {
                                            
    stringBuffer.append(TEXT_266);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_268);
    
                                        } else {
                                            
    stringBuffer.append(TEXT_269);
        
                                        }
                                        
    stringBuffer.append(TEXT_270);
    
                                }
                                
    stringBuffer.append(TEXT_271);
      
                            currentColNo++;
                        }
		       		}
                 	log4jCodeGenerateUtil.logInfo(node,"debug",cid+" - Retrieving the record \"+nb_line_"+cid+"+\"."); 
                    if(conns.size() > 1) {
                        for(int connNO = 1 ; connNO < conns.size() ; connNO++) {
                            IConnection conn2 = conns.get(connNO);
                            if((conn2.getName().compareTo(firstConnName) != 0) && (conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
                                for(IMetadataColumn column : columnList) {
                                    
    stringBuffer.append(TEXT_272);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_273);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_274);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_276);
     
                                }
                            }
                        }
                    }
                }
		}
	}

    stringBuffer.append(TEXT_277);
    stringBuffer.append(TEXT_278);
    return stringBuffer.toString();
  }
}
