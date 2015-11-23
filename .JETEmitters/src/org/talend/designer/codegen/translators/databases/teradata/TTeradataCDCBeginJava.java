package org.talend.designer.codegen.translators.databases.teradata;

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

public class TTeradataCDCBeginJava
{
  protected static String nl;
  public static synchronized TTeradataCDCBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataCDCBeginJava result = new TTeradataCDCBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_31 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_32 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_34 = " - Uses an existing connection ";
  protected final String TEXT_35 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_37 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_38 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_39 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\tconn_";
  protected final String TEXT_42 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_43 = ", dbUser_";
  protected final String TEXT_44 = ", dbPwd_";
  protected final String TEXT_45 = ");" + NL + "\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\tconn_";
  protected final String TEXT_47 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\tconn_";
  protected final String TEXT_49 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\tconn_";
  protected final String TEXT_51 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\tconn_";
  protected final String TEXT_53 = ".setAutoCommit(";
  protected final String TEXT_54 = ");" + NL + "\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t\tlog.";
  protected final String TEXT_56 = "(\"";
  protected final String TEXT_57 = " - \" + ";
  protected final String TEXT_58 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "\t    \t\tlog.";
  protected final String TEXT_60 = "(\"";
  protected final String TEXT_61 = "\");" + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_63 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_65 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_66 = ": pstmt_";
  protected final String TEXT_67 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_68 = " += (countEach_";
  protected final String TEXT_69 = " < 0 ? 0 : ";
  protected final String TEXT_70 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_71 = NL;
  protected final String TEXT_72 = NL + NL + "\t\t    int nb_line_";
  protected final String TEXT_73 = " = 0;" + NL + "\t\t    java.sql.Connection conn_";
  protected final String TEXT_74 = " = null;" + NL;
  protected final String TEXT_75 = NL + NL + "\t\t        conn_";
  protected final String TEXT_76 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_77 = "\");" + NL + "\t\t        ";
  protected final String TEXT_78 = NL + NL + "    \t\t\tString driverClass_";
  protected final String TEXT_79 = " = \"com.teradata.jdbc.TeraDriver\"; " + NL + "    \t\t    java.lang.Class.forName(driverClass_";
  protected final String TEXT_80 = ");" + NL + "    \t\t    ";
  protected final String TEXT_81 = NL + NL + "                    String url_";
  protected final String TEXT_82 = " = \"jdbc:teradata://\" + ";
  protected final String TEXT_83 = " + \"/DATABASE=\" + ";
  protected final String TEXT_84 = ";" + NL + "                    ";
  protected final String TEXT_85 = NL + NL + "                    String url_";
  protected final String TEXT_86 = " = \"jdbc:teradata://\" + ";
  protected final String TEXT_87 = " + \"/DATABASE=\" + ";
  protected final String TEXT_88 = " + \",\" + ";
  protected final String TEXT_89 = ";" + NL;
  protected final String TEXT_90 = NL + NL + "\t\t        String dbUser_";
  protected final String TEXT_91 = " = ";
  protected final String TEXT_92 = ";" + NL + "\t\t        ";
  protected final String TEXT_93 = NL + "                " + NL + "\t\t\t\t";
  protected final String TEXT_94 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_95 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_96 = ");";
  protected final String TEXT_97 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_98 = " = ";
  protected final String TEXT_99 = "; ";
  protected final String TEXT_100 = NL + "  \t\t        " + NL + "\t\t        " + NL + "\t\t        String dbPwd_";
  protected final String TEXT_101 = " = decryptedPassword_";
  protected final String TEXT_102 = ";" + NL + "\t\t        ";
  protected final String TEXT_103 = NL;
  protected final String TEXT_104 = NL + NL + "\t\t        String dbschema_";
  protected final String TEXT_105 = " = (String)globalMap.get(\"";
  protected final String TEXT_106 = "\");" + NL;
  protected final String TEXT_107 = NL + NL + "\t\t\t\tString dbschema_";
  protected final String TEXT_108 = " = ";
  protected final String TEXT_109 = ";" + NL;
  protected final String TEXT_110 = NL + NL + "            String dataTableName_";
  protected final String TEXT_111 = " = \"\";" + NL + "            String changeTableName_";
  protected final String TEXT_112 = " = \"\";" + NL + "            ";
  protected final String TEXT_113 = NL + "            " + NL + "\t\t\tif(dbschema_";
  protected final String TEXT_114 = " == null || dbschema_";
  protected final String TEXT_115 = ".trim().length() == 0) {" + NL + "    \t\t\tdataTableName_";
  protected final String TEXT_116 = " =";
  protected final String TEXT_117 = "+\"TCDC_\" + ";
  protected final String TEXT_118 = "+";
  protected final String TEXT_119 = ";" + NL + "    \t\t\tchangeTableName_";
  protected final String TEXT_120 = " =";
  protected final String TEXT_121 = "+\"TCDC_VIEW_\" + ";
  protected final String TEXT_122 = "+";
  protected final String TEXT_123 = ";" + NL + "\t\t\t} else {" + NL + "    \t\t\tdataTableName_";
  protected final String TEXT_124 = " = ";
  protected final String TEXT_125 = "+dbschema_";
  protected final String TEXT_126 = " +";
  protected final String TEXT_127 = "+ \".\"+";
  protected final String TEXT_128 = "+\"TCDC_\" + ";
  protected final String TEXT_129 = "+";
  protected final String TEXT_130 = ";" + NL + "    \t\t\tchangeTableName_";
  protected final String TEXT_131 = " = ";
  protected final String TEXT_132 = "+dbschema_";
  protected final String TEXT_133 = " + ";
  protected final String TEXT_134 = "+\".\"+";
  protected final String TEXT_135 = "+\"TCDC_VIEW_\" + ";
  protected final String TEXT_136 = "+";
  protected final String TEXT_137 = ";" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tString queryUpdatePrefix_";
  protected final String TEXT_138 = "=\"UPDATE \"+dataTableName_";
  protected final String TEXT_139 = "+\" SET TALEND_CDC_STATE='1' WHERE TALEND_CDC_STATE<>'x' AND TALEND_CDC_SUBSCRIBERS_NAME='\"+";
  protected final String TEXT_140 = "+\"'\";" + NL + "            String getRowsToConsume_";
  protected final String TEXT_141 = " = \"SELECT \"" + NL + "            ";
  protected final String TEXT_142 = NL + NL + "            \t+ \" ";
  protected final String TEXT_143 = " \"" + NL;
  protected final String TEXT_144 = NL + NL + "                    + \",\" " + NL;
  protected final String TEXT_145 = NL + "                + \" FROM \"+changeTableName_";
  protected final String TEXT_146 = " +\" WHERE TALEND_CDC_SUBSCRIBERS_NAME='\"+";
  protected final String TEXT_147 = "+\"'\";" + NL;
  protected final String TEXT_148 = NL + "            queryUpdatePrefix_";
  protected final String TEXT_149 = " += \"";
  protected final String TEXT_150 = "\";" + NL + "            " + NL + "            getRowsToConsume_";
  protected final String TEXT_151 = " += \"";
  protected final String TEXT_152 = "\";" + NL + "            getRowsToConsume_";
  protected final String TEXT_153 = " += \" ORDER BY TALEND_CDC_CREATION_DATE ASC\";" + NL + "            " + NL + "" + NL + "\t\t    java.sql.Statement stmt_";
  protected final String TEXT_154 = " = conn_";
  protected final String TEXT_155 = ".createStatement();" + NL + "" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_156 = NL + "\t\t\t" + NL + "            stmt_";
  protected final String TEXT_157 = ".executeUpdate(queryUpdatePrefix_";
  protected final String TEXT_158 = ");" + NL + "            ";
  protected final String TEXT_159 = NL + "\t\t\t";
  protected final String TEXT_160 = " " + NL + "\t\t\t" + NL + "\t    \tjava.sql.ResultSet rs_";
  protected final String TEXT_161 = " = stmt_";
  protected final String TEXT_162 = ".executeQuery(getRowsToConsume_";
  protected final String TEXT_163 = ");" + NL + "\t    \t" + NL + "\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t" + NL + "\t\t    java.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_165 = " = rs_";
  protected final String TEXT_166 = ".getMetaData();" + NL + "\t\t    int colQtyInRs_";
  protected final String TEXT_167 = " = rsmd_";
  protected final String TEXT_168 = ".getColumnCount();" + NL + "" + NL + "\t\t    globalMap.put(\"";
  protected final String TEXT_169 = "_QUERY\",getRowsToConsume_";
  protected final String TEXT_170 = ");" + NL;
  protected final String TEXT_171 = NL + NL + "\t\t    String tmpContent_";
  protected final String TEXT_172 = " = null;" + NL + "\t\t    " + NL + "\t        ";
  protected final String TEXT_173 = NL + "\t        " + NL + "\t\t    while (rs_";
  protected final String TEXT_174 = ".next()) {" + NL + "\t\t        nb_line_";
  protected final String TEXT_175 = "++;" + NL;
  protected final String TEXT_176 = " \t" + NL + "" + NL + "\t\t                    if(colQtyInRs_";
  protected final String TEXT_177 = " < ";
  protected final String TEXT_178 = ") {" + NL + "\t\t                        ";
  protected final String TEXT_179 = ".";
  protected final String TEXT_180 = " = ";
  protected final String TEXT_181 = "; \t\t\t" + NL + "\t\t                    } else {" + NL + "\t\t                    ";
  protected final String TEXT_182 = NL + NL + "\t\t                            tmpContent_";
  protected final String TEXT_183 = " = rs_";
  protected final String TEXT_184 = ".getString(";
  protected final String TEXT_185 = ");" + NL;
  protected final String TEXT_186 = NL + NL + "    \t\t                            if(tmpContent_";
  protected final String TEXT_187 = " != null) {" + NL + "    \t\t                                tmpContent_";
  protected final String TEXT_188 = " = tmpContent_";
  protected final String TEXT_189 = ";" + NL + "    \t\t                            }" + NL;
  protected final String TEXT_190 = NL + NL + "\t\t                            if(tmpContent_";
  protected final String TEXT_191 = " != null && tmpContent_";
  protected final String TEXT_192 = ".length() > 0) {\t\t\t  \t" + NL + "\t\t                                ";
  protected final String TEXT_193 = ".";
  protected final String TEXT_194 = " = tmpContent_";
  protected final String TEXT_195 = ".charAt(0);\t\t\t  \t\t" + NL + "\t\t                            } else {" + NL;
  protected final String TEXT_196 = "\t" + NL + "\t\t  \t    " + NL + "\t\t                                    if(tmpContent_";
  protected final String TEXT_197 = " == null) {\t\t\t  \t   \t" + NL + "\t\t                                        ";
  protected final String TEXT_198 = ".";
  protected final String TEXT_199 = " = null;\t\t\t  \t\t\t" + NL + "\t\t                                    } else {\t\t\t  \t\t" + NL + "\t\t                                        ";
  protected final String TEXT_200 = ".";
  protected final String TEXT_201 = " = '\\0';\t\t\t  \t\t\t" + NL + "\t\t                                    }" + NL + "\t\t                                    ";
  protected final String TEXT_202 = NL + "\t\t  \t\t" + NL + "\t\t                                    if(tmpContent_";
  protected final String TEXT_203 = ".equals(\"\")) {\t\t\t  \t\t" + NL + "\t\t                                        ";
  protected final String TEXT_204 = ".";
  protected final String TEXT_205 = " = '\\0';\t\t\t  \t\t\t" + NL + "\t\t                                    } else {\t\t\t  \t\t" + NL + "                        \t\t\t  \t\t\tthrow new RuntimeException(" + NL + "                        \t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_206 = "' in '";
  protected final String TEXT_207 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t" + NL + "\t\t                                    }" + NL + "\t\t                                    \t\t  \t\t";
  protected final String TEXT_208 = NL + NL + "\t\t                            }\t\t\t" + NL;
  protected final String TEXT_209 = NL + NL + "\t\t                            ";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = " = (List)rs_";
  protected final String TEXT_212 = ".getObject(";
  protected final String TEXT_213 = ");" + NL + "\t\t                            ";
  protected final String TEXT_214 = NL + NL + "\t\t                            tmpContent_";
  protected final String TEXT_215 = " = rs_";
  protected final String TEXT_216 = ".getString(";
  protected final String TEXT_217 = ");" + NL + "\t\t                            if(tmpContent_";
  protected final String TEXT_218 = " != null) {" + NL;
  protected final String TEXT_219 = NL + NL + "    \t\t                            \ttmpContent_";
  protected final String TEXT_220 = " = tmpContent_";
  protected final String TEXT_221 = ";" + NL;
  protected final String TEXT_222 = NL + NL + "\t\t                                ";
  protected final String TEXT_223 = ".";
  protected final String TEXT_224 = " = tmpContent_";
  protected final String TEXT_225 = ";" + NL + "\t\t                            } else {" + NL + "\t\t                                ";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = " = null;" + NL + "\t\t                            }" + NL + "\t\t                            ";
  protected final String TEXT_228 = NL + NL + "\t\t                            if(rs_";
  protected final String TEXT_229 = ".getObject(";
  protected final String TEXT_230 = ") != null) {" + NL + "\t\t                                ";
  protected final String TEXT_231 = ".";
  protected final String TEXT_232 = " = rs_";
  protected final String TEXT_233 = ".get";
  protected final String TEXT_234 = "(";
  protected final String TEXT_235 = ");" + NL + "\t\t                            } else {" + NL + "\t\t                            ";
  protected final String TEXT_236 = NL + NL + "\t\t                                    ";
  protected final String TEXT_237 = ".";
  protected final String TEXT_238 = " = null;";
  protected final String TEXT_239 = "    " + NL + "" + NL + "\t\t                                    throw new RuntimeException(\"Null value in non-Nullable column\");" + NL;
  protected final String TEXT_240 = NL + NL + "\t\t                            }";
  protected final String TEXT_241 = NL + NL + "\t\t                    }" + NL;
  protected final String TEXT_242 = NL + NL + "\t\t                            ";
  protected final String TEXT_243 = ".";
  protected final String TEXT_244 = " = ";
  protected final String TEXT_245 = ".";
  protected final String TEXT_246 = ";" + NL;
  protected final String TEXT_247 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
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
			
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    if (cid.startsWith("tImpala") || cid.startsWith("tHive")) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_35);
    } else {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
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
			
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
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
			
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
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
			
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_54);
    
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
	    	
    stringBuffer.append(TEXT_55);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_58);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_59);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_61);
    
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
			
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_70);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    stringBuffer.append(TEXT_71);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
    
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser = ElementParameterParser.getValue(node, "__USER__");
	String suscriber = ElementParameterParser.getValue(node, "__SUSCRIBER__");
	String dataTable = ElementParameterParser.getValue(node, "__DATATABLE__");
    boolean whetherTrimAllCol = ElementParameterParser.getValue(node, "__TRIM_ALL_COLUMN__").equals("true");
	boolean eventsTypeInsert = "true".compareTo(ElementParameterParser.getValue(node,"__EVENTS_TYPE_INSERT__"))==0;
	boolean eventsTypeUpdate = "true".compareTo(ElementParameterParser.getValue(node,"__EVENTS_TYPE_UPDATE__"))==0;
	boolean eventsTypeDelete = "true".compareTo(ElementParameterParser.getValue(node,"__EVENTS_TYPE_DELETE__"))==0;
    List<Map<String, String>> trimColumnList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIM_COLUMN__");
	    
	List<IMetadataTable> metadatas = node.getMetadataList(); // get schema
	if ((metadatas != null) && (metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata != null) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
		    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(useExistingConn.equals("true")) {
		        String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		        String conn = "conn_" + connection;

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_77);
    
            	log4jCodeGenerateUtil.useExistConnection(node);
		    } else {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
		        if(dbproperties == null || dbproperties.equals("\"\"") || dbproperties.equals("")) {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_84);
    
		        } else {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_89);
    
		        }

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_92);
    
                String passwordFieldName = "__PASS__";

    stringBuffer.append(TEXT_93);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_96);
    } else {
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_99);
    }
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
            	log4jCodeGenerateUtil.debugConnectionParams(node);
            	log4jCodeGenerateUtil.connect(node);
		    }

    stringBuffer.append(TEXT_103);
    
		    if(useExistingConn.equals("true")) {
		    	String connection_cid = ElementParameterParser.getValue(node,"__CONNECTION__");
		        String conn_dbname_key = "dbname_" + connection_cid;

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(conn_dbname_key);
    stringBuffer.append(TEXT_106);
    
			} else {

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_109);
    
			}

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
            String quote=TalendTextUtils.getQuoteByDBType(EDatabaseTypeName.TERADATA.getXmlName(),false);
            String oneQuote=TalendTextUtils.addQuotes(quote);

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(dataTable);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(dataTable);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(dataTable);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(dataTable);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(oneQuote);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(suscriber);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
            for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_142);
    stringBuffer.append(TalendTextUtils.addSQLFieldQuotes(column.getOriginalDbColumnName(),quote));
    stringBuffer.append(TEXT_143);
    
            	if (metadata.getListColumns().indexOf(column) != (metadata.getListColumns().size() -1)) {

    stringBuffer.append(TEXT_144);
    
            	}
            }

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(suscriber);
    stringBuffer.append(TEXT_147);
    
            String filterOnEvent = "";
            if (eventsTypeInsert && eventsTypeUpdate&&eventsTypeDelete) {
            	// do nothing
            } else if (!eventsTypeInsert && !eventsTypeUpdate && !eventsTypeDelete) {
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

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(filterOnEvent );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(filterOnEvent );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executing SQL:\"+queryUpdatePrefix_"+cid + "+\"");
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executed successfully.");
    stringBuffer.append(TEXT_159);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executing SQL:\"+getRowsToConsume_"+cid+"+\"");
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Executed successfully.");
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    
		    List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		    List<IMetadataColumn> columnList = metadata.getListColumns();

    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    log4jCodeGenerateUtil.logInfo(node,"info",cid+" - Retrieving records from the database.");
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    
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

    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_181);
    
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

    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_185);
    
		                            if(whetherTrimAllCol || whetherTrimCol) {

    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_189);
    
		                            }

    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    
		                                if(typeToGenerate.equals("Character")) {

    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_199);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_201);
    
		                                } else {

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_205);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_206);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_207);
    
		                                }

    stringBuffer.append(TEXT_208);
    
		                        } else if (typeToGenerate.equals("List")) {

    stringBuffer.append(TEXT_209);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_213);
    
		                        } else if(typeToGenerate.equals("String")) {

    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
		                            	if(whetherTrimAllCol || whetherTrimCol) {

    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_221);
    
		                            	}

    stringBuffer.append(TEXT_222);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_227);
    
		                        } else {

    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_235);
    
		                                if(column.isNullable()) {

    stringBuffer.append(TEXT_236);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_238);
    
		                                } else {

    stringBuffer.append(TEXT_239);
        
		                                }

    stringBuffer.append(TEXT_240);
    
		                        }

    stringBuffer.append(TEXT_241);
      
		                    currentColNo++;
		                }
		            }
                 	log4jCodeGenerateUtil.logInfo(node,"debug",cid+" - Retrieving the record \"+nb_line_"+cid+"+\"."); 
		            if(conns.size() > 1) {
		                for(int connNO = 1 ; connNO < conns.size() ; connNO++) {
		                    IConnection conn2 = conns.get(connNO);
		                    if((conn2.getName().compareTo(firstConnName) != 0) && (conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
		                        for(IMetadataColumn column:columnList){

    stringBuffer.append(TEXT_242);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_243);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_244);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_246);
     
		                        }
		                    }
		                }
		            }
		        }
			}
		}

    stringBuffer.append(TEXT_247);
    return stringBuffer.toString();
  }
}
