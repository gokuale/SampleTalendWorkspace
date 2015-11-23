package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class THiveConnectionBeginJava
{
  protected static String nl;
  public static synchronized THiveConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveConnectionBeginJava result = new THiveConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t";
  protected final String TEXT_2 = " " + NL + "\t\tfinal String hdInsightPassword_";
  protected final String TEXT_3 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_4 = ");";
  protected final String TEXT_5 = NL + "\t\tfinal String hdInsightPassword_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = "; ";
  protected final String TEXT_8 = " " + NL + "\t\tfinal String wasbPassword_";
  protected final String TEXT_9 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\t\tfinal String wasbPassword_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = "; ";
  protected final String TEXT_14 = NL + "\t" + NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_15 = " = new StringBuilder();" + NL + "\t" + NL + "\torg.talend.webhcat.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_16 = " = new org.talend.webhcat.launcher.fs.AzureFileSystem(\"DefaultEndpointsProtocol=https;\"" + NL + "\t\t+ \"AccountName=\"" + NL + "\t\t+ ";
  protected final String TEXT_17 = NL + "\t\t+ \";\"" + NL + "\t\t+ \"AccountKey=\" + wasbPassword_";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = ");" + NL + "\t\t\t" + NL + "\torg.talend.webhcat.launcher.common.Job instance_";
  protected final String TEXT_20 = " = new org.talend.webhcat.launcher.common.impl.PigJob(azureFs_";
  protected final String TEXT_21 = ", org.talend.webhcat.launcher.utils.JobType.HIVE);" + NL + "\t\t\t\t\t" + NL + "\tinstance_";
  protected final String TEXT_22 = ".setAzureAccountName(";
  protected final String TEXT_23 = ");" + NL + "\tinstance_";
  protected final String TEXT_24 = ".setAzureAccountPassword(wasbPassword_";
  protected final String TEXT_25 = ");" + NL + "\tinstance_";
  protected final String TEXT_26 = ".setAzureStorageAddress(";
  protected final String TEXT_27 = ");" + NL + "\tinstance_";
  protected final String TEXT_28 = ".setAzureContainer(";
  protected final String TEXT_29 = ");" + NL + "\tinstance_";
  protected final String TEXT_30 = ".setHdInsightUsername(";
  protected final String TEXT_31 = ");" + NL + "\tinstance_";
  protected final String TEXT_32 = ".setHdInsightPassword(hdInsightPassword_";
  protected final String TEXT_33 = ");" + NL + "\tinstance_";
  protected final String TEXT_34 = ".setUsername(";
  protected final String TEXT_35 = ");" + NL + "\tinstance_";
  protected final String TEXT_36 = ".setWebhcatEndpoint(\"https\", ";
  protected final String TEXT_37 = " + \":\" + ";
  protected final String TEXT_38 = ");" + NL + "\tinstance_";
  protected final String TEXT_39 = ".setStatusFolder(org.talend.webhcat.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_40 = "));" + NL + "\tinstance_";
  protected final String TEXT_41 = ".setRemoteFolder(org.talend.webhcat.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_42 = "));" + NL + "\t" + NL + "\tjava.util.List<String> connectionCommandList_";
  protected final String TEXT_43 = " = new java.util.ArrayList<String>();" + NL + "\t";
  protected final String TEXT_44 = NL + "\t\tconnectionCommandList_";
  protected final String TEXT_45 = ".add(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_46 = " + \";\");" + NL + "\t\tconnectionCommandList_";
  protected final String TEXT_47 = ".add(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_48 = " + \";\");" + NL + "\t\tconnectionCommandList_";
  protected final String TEXT_49 = ".add(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_50 = " + \";\");";
  protected final String TEXT_51 = NL + "\t\t\tconnectionCommandList_";
  protected final String TEXT_52 = ".add(\"SET \"+";
  protected final String TEXT_53 = "+\"=\"+";
  protected final String TEXT_54 = " + \";\");";
  protected final String TEXT_55 = NL + NL + "\tString dbname_";
  protected final String TEXT_56 = " = ";
  protected final String TEXT_57 = ";" + NL + "\tif(dbname_";
  protected final String TEXT_58 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_59 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_60 = ".trim())) {" + NL + "\t\tconnectionCommandList_";
  protected final String TEXT_61 = ".add(\"use \" + dbname_";
  protected final String TEXT_62 = " + \";\");" + NL + "\t}" + NL + "" + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_63 = "\", instance_";
  protected final String TEXT_64 = ");" + NL + "\tglobalMap.put(\"commandList_";
  protected final String TEXT_65 = "\", connectionCommandList_";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "\t\t";
  protected final String TEXT_68 = NL + "\t";
  protected final String TEXT_69 = NL + "\t\t\tString driverClass_";
  protected final String TEXT_70 = " = \"";
  protected final String TEXT_71 = "\";" + NL + "\t\t\tjava.lang.Class.forName(driverClass_";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = NL + "\t\t\tSharedDBConnectionLog4j.initLogger(log,\"";
  protected final String TEXT_74 = "\");";
  protected final String TEXT_75 = NL + "\t\t\tString sharedConnectionName_";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = ";" + NL + "\t\t\tconn_";
  protected final String TEXT_78 = " = ";
  protected final String TEXT_79 = ".getDBConnection(\"";
  protected final String TEXT_80 = "\",url_";
  protected final String TEXT_81 = ",dbUser_";
  protected final String TEXT_82 = " , dbPwd_";
  protected final String TEXT_83 = " , sharedConnectionName_";
  protected final String TEXT_84 = ");";
  protected final String TEXT_85 = NL + "\t\tconn_";
  protected final String TEXT_86 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_87 = ",dbUser_";
  protected final String TEXT_88 = ",dbPwd_";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_91 = " - Connection is set auto commit to '";
  protected final String TEXT_92 = "'.\");";
  protected final String TEXT_93 = NL + "\t\t\tconn_";
  protected final String TEXT_94 = ".setAutoCommit(";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "\t\t\t\tconn_";
  protected final String TEXT_97 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_98 = ");";
  protected final String TEXT_99 = NL + "\t\t\t\tif(true) {" + NL + "\t\t\t\t\tthrow new java.lang.Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t\t}";
  protected final String TEXT_100 = NL + "\t\t\t\t\tSystem.setProperty(";
  protected final String TEXT_101 = " ,";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_104 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_105 = NL + "\t\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"false\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"true\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_107 = NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_108 = ");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_109 = ");" + NL + "\t        " + NL + "        \t\t";
  protected final String TEXT_110 = NL + "        \t\t" + NL + "        \t\t";
  protected final String TEXT_111 = " " + NL + "            \tString decryptedMetastorePassword_";
  protected final String TEXT_112 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_113 = ");" + NL + "       \t\t \t";
  protected final String TEXT_114 = NL + "            \tString decryptedMetastorePassword_";
  protected final String TEXT_115 = " = ";
  protected final String TEXT_116 = "; " + NL + "    \t\t\t";
  protected final String TEXT_117 = NL + "        \t   \t" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", decryptedMetastorePassword_";
  protected final String TEXT_118 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_119 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\t\tSystem.setProperty(\"hive.server2.authentication.kerberos.principal\", ";
  protected final String TEXT_121 = ");" + NL + "\t\t\t\t\tSystem.setProperty(\"hive.server2.authentication.kerberos.keytab\", ";
  protected final String TEXT_122 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_123 = NL + "\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_124 = ", ";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + "\t\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_127 = ");";
  protected final String TEXT_128 = NL + "\t\t\t\tSystem.setProperty(\"";
  protected final String TEXT_129 = "\", ";
  protected final String TEXT_130 = ");";
  protected final String TEXT_131 = NL + "                String username_";
  protected final String TEXT_132 = " = ";
  protected final String TEXT_133 = ";" + NL + "                if(username_";
  protected final String TEXT_134 = "!=null && !\"\".equals(username_";
  protected final String TEXT_135 = ".trim())) {" + NL + "                    System.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_136 = ");" + NL + "                }";
  protected final String TEXT_137 = NL + "\t\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_138 = "\", System.getProperty(\"HADOOP_USER_NAME\"));" + NL + "\t\t\t";
  protected final String TEXT_139 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_140 = " + \":\" + ";
  protected final String TEXT_141 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\t\tString url_";
  protected final String TEXT_142 = " = \"jdbc:";
  protected final String TEXT_143 = "://\";";
  protected final String TEXT_144 = NL + "\t\t\t\t\tString dbUserName_";
  protected final String TEXT_145 = " = ";
  protected final String TEXT_146 = ";" + NL + "\t\t\t\t\tif(dbUserName_";
  protected final String TEXT_147 = "!=null && !\"\".equals(dbUserName_";
  protected final String TEXT_148 = ".trim())) {" + NL + "\t\t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUserName_";
  protected final String TEXT_149 = ");" + NL + "\t\t\t\t\t\t//make relative file path work for hive" + NL + "\t\t\t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\t\t\t\tSystem.setProperty(\"user.name\",dbUserName_";
  protected final String TEXT_150 = ");" + NL + "\t\t\t\t\t\tglobalMap.put(\"dbUser_";
  protected final String TEXT_151 = "\",dbUserName_";
  protected final String TEXT_152 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_153 = NL + "\t\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_154 = ", ";
  protected final String TEXT_155 = ");";
  protected final String TEXT_156 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_157 = " = \"jdbc:";
  protected final String TEXT_158 = "://\" + ";
  protected final String TEXT_159 = " + \":\" + ";
  protected final String TEXT_160 = " + \"/\" + ";
  protected final String TEXT_161 = " + \";principal=\" + ";
  protected final String TEXT_162 = "+\";sasl.qop=auth-conf\";";
  protected final String TEXT_163 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_164 = " = \"jdbc:";
  protected final String TEXT_165 = "://\" + ";
  protected final String TEXT_166 = " + \":\" + ";
  protected final String TEXT_167 = " + \"/\" + ";
  protected final String TEXT_168 = " + \";principal=\" + ";
  protected final String TEXT_169 = ";";
  protected final String TEXT_170 = NL + "\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_171 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_172 = ");";
  protected final String TEXT_173 = NL + "\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_174 = " = ";
  protected final String TEXT_175 = "; ";
  protected final String TEXT_176 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_177 = " = \"jdbc:";
  protected final String TEXT_178 = "://\" + ";
  protected final String TEXT_179 = " + \":\" + ";
  protected final String TEXT_180 = " + \"/\" + ";
  protected final String TEXT_181 = "+ \";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_182 = " + \";trustStorePassword=\" + decryptedSslStorePassword_";
  protected final String TEXT_183 = ";";
  protected final String TEXT_184 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_185 = " = \"jdbc:";
  protected final String TEXT_186 = "://\" + ";
  protected final String TEXT_187 = " + \":\" + ";
  protected final String TEXT_188 = " + \"/\" + ";
  protected final String TEXT_189 = ";";
  protected final String TEXT_190 = NL + "\t\t\t\tString additionalJdbcSettings_";
  protected final String TEXT_191 = " = ";
  protected final String TEXT_192 = ";" + NL + "\t\t\t\tif(!\"\".equals(additionalJdbcSettings_";
  protected final String TEXT_193 = ".trim())) {" + NL + "\t\t\t\t\tif(!additionalJdbcSettings_";
  protected final String TEXT_194 = ".startsWith(\";\")) {" + NL + "\t\t\t\t\t\tadditionalJdbcSettings_";
  protected final String TEXT_195 = " = \";\" + additionalJdbcSettings_";
  protected final String TEXT_196 = ";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_197 = " += additionalJdbcSettings_";
  protected final String TEXT_198 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_199 = NL + "\t\t\tconn_";
  protected final String TEXT_200 = ".setAutoCommit(";
  protected final String TEXT_201 = ");";
  protected final String TEXT_202 = NL + NL + "\t";
  protected final String TEXT_203 = NL + NL + "\tString dbUser_";
  protected final String TEXT_204 = " = ";
  protected final String TEXT_205 = ";";
  protected final String TEXT_206 = NL + "\t" + NL + "\t";
  protected final String TEXT_207 = NL + "\t\tString dbPwd_";
  protected final String TEXT_208 = " = null;" + NL + "\t";
  protected final String TEXT_209 = NL + "\t\t";
  protected final String TEXT_210 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_211 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_212 = ");";
  protected final String TEXT_213 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_214 = " = ";
  protected final String TEXT_215 = "; ";
  protected final String TEXT_216 = NL + "\t\tString dbPwd_";
  protected final String TEXT_217 = " = decryptedPassword_";
  protected final String TEXT_218 = ";" + NL + "\t";
  protected final String TEXT_219 = NL + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_220 = " = null;" + NL + "\t";
  protected final String TEXT_221 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_222 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_223 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_224 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_225 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_226 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_227 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_228 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_229 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_230 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_231 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_232 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_233 = " - Written records count: \" + nb_line_";
  protected final String TEXT_234 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_235 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_236 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_237 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_238 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_239 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_240 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_241 = " - Writing the record \" + nb_line_";
  protected final String TEXT_242 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_243 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_244 = " - Processing the record \" + nb_line_";
  protected final String TEXT_245 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_246 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_247 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_248 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_249 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_250 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_251 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_252 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_253 = " - Uses an existing connection ";
  protected final String TEXT_254 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_255 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_256 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_257 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_258 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_259 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_260 = NL + "\t\t\tconn_";
  protected final String TEXT_261 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_262 = ", dbUser_";
  protected final String TEXT_263 = ", dbPwd_";
  protected final String TEXT_264 = ");" + NL + "\t\t\t";
  protected final String TEXT_265 = NL + "\t\t\tconn_";
  protected final String TEXT_266 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_267 = NL + "\t\t\tconn_";
  protected final String TEXT_268 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_269 = NL + "\t\t\tconn_";
  protected final String TEXT_270 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_271 = NL + "\t\t\t\tconn_";
  protected final String TEXT_272 = ".setAutoCommit(";
  protected final String TEXT_273 = ");" + NL + "\t\t\t";
  protected final String TEXT_274 = NL + "\t\t\t\tlog.";
  protected final String TEXT_275 = "(\"";
  protected final String TEXT_276 = " - \" + ";
  protected final String TEXT_277 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_278 = NL + "\t    \t\tlog.";
  protected final String TEXT_279 = "(\"";
  protected final String TEXT_280 = "\");" + NL + "\t\t\t";
  protected final String TEXT_281 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_282 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_283 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_284 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_285 = ": pstmt_";
  protected final String TEXT_286 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_287 = " += (countEach_";
  protected final String TEXT_288 = " < 0 ? 0 : ";
  protected final String TEXT_289 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_290 = NL + "\t";
  protected final String TEXT_291 = NL + NL + "\tif ((null == globalMap.get(KEY_DB_DATASOURCES)) || \"\".equals(";
  protected final String TEXT_292 = ")) {";
  protected final String TEXT_293 = NL + "\t\t";
  protected final String TEXT_294 = NL + "\t\t";
  protected final String TEXT_295 = NL + NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_296 = "\", conn_";
  protected final String TEXT_297 = ");";
  protected final String TEXT_298 = NL + "\t}";
  protected final String TEXT_299 = NL + "\tif (null != conn_";
  protected final String TEXT_300 = ") {" + NL + "\t\t";
  protected final String TEXT_301 = NL + "\t}";
  protected final String TEXT_302 = NL;
  protected final String TEXT_303 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_304 = ");" + NL + "\t" + NL + "\tjava.sql.Statement init_";
  protected final String TEXT_305 = " = conn_";
  protected final String TEXT_306 = ".createStatement();";
  protected final String TEXT_307 = NL + "        init_";
  protected final String TEXT_308 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_309 = ");" + NL + "\t    init_";
  protected final String TEXT_310 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_311 = ");";
  protected final String TEXT_312 = NL + "\t\tinit_";
  protected final String TEXT_313 = ".execute(\"SET dfs.namenode.kerberos.principal=\" + ";
  protected final String TEXT_314 = ");";
  protected final String TEXT_315 = NL + "\t\t\tinit_";
  protected final String TEXT_316 = ".execute(\"SET mapreduce.jobtracker.kerberos.principal=\" + ";
  protected final String TEXT_317 = ");";
  protected final String TEXT_318 = NL + "\t\t\tinit_";
  protected final String TEXT_319 = ".execute(\"SET yarn.resourcemanager.principal=\" + ";
  protected final String TEXT_320 = ");";
  protected final String TEXT_321 = NL + "    \t\tinit_";
  protected final String TEXT_322 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "    \t\tinit_";
  protected final String TEXT_323 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_324 = ");";
  protected final String TEXT_325 = NL + "\t\t\tinit_";
  protected final String TEXT_326 = ".execute(\"SET mapreduce.jobhistory.address=\" + ";
  protected final String TEXT_327 = ");" + NL + "\t\t\t";
  protected final String TEXT_328 = NL + "\t\t\tinit_";
  protected final String TEXT_329 = ".execute(\"SET dfs.client.use.datanode.hostname=true\");";
  protected final String TEXT_330 = NL + "\t\t\tinit_";
  protected final String TEXT_331 = ".execute(\"SET yarn.resourcemanager.scheduler.address=\" + ";
  protected final String TEXT_332 = ");";
  protected final String TEXT_333 = NL + "\t\t\tinit_";
  protected final String TEXT_334 = ".execute(\"SET fs.default.name=\" + ";
  protected final String TEXT_335 = ");";
  protected final String TEXT_336 = NL + "\t\t\tinit_";
  protected final String TEXT_337 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_338 = NL + "\t\t\t\tinit_";
  protected final String TEXT_339 = ".execute(\"SET mapreduce.job.map.output.collector.class=org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "\t\t\t\tinit_";
  protected final String TEXT_340 = ".execute(\"SET mapreduce.job.reduce.shuffle.consumer.plugin.class=org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_341 = NL + "\t\t\tinit_";
  protected final String TEXT_342 = ".execute(\"SET yarn.application.classpath=/etc/hadoop/conf,/usr/lib/hadoop/*,/usr/lib/hadoop/lib/*,/usr/lib/hadoop-hdfs/*,/usr/lib/hadoop-hdfs/lib/*,/usr/lib/hadoop-yarn/*,/usr/lib/hadoop-yarn/lib/*,/usr/lib/hadoop-mapreduce/*,/usr/lib/hadoop-mapreduce/lib/*\");";
  protected final String TEXT_343 = NL + "\t\t\tinit_";
  protected final String TEXT_344 = ".execute(\"SET mapreduce.application.classpath=$PWD/mr-framework/hadoop/share/hadoop/mapreduce/*:$PWD/mr-framework/hadoop/share/hadoop/mapreduce/lib/*:$PWD/mr-framework/hadoop/share/hadoop/common/*:$PWD/mr-framework/hadoop/share/hadoop/common/lib/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/lib/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/lib/*:/etc/hadoop/conf/secure\");" + NL + "\t\t\tinit_";
  protected final String TEXT_345 = ".execute(\"SET yarn.application.classpath=$HADOOP_CONF_DIR,/usr/hdp/current/hadoop-client/*,/usr/hdp/current/hadoop-client/lib/*,/usr/hdp/current/hadoop-hdfs-client/*,/usr/hdp/current/hadoop-hdfs-client/lib/*,/usr/hdp/current/hadoop-mapreduce-client/*,/usr/hdp/current/hadoop-mapreduce-client/lib/*,/usr/hdp/current/hadoop-yarn-client/*,/usr/hdp/current/hadoop-yarn-client/lib/*\");";
  protected final String TEXT_346 = NL + "    \t\t\t//set default yarn classpath with environment variable" + NL + "    \t\t\tinit_";
  protected final String TEXT_347 = ".execute(\"SET yarn.application.classpath=$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*\");";
  protected final String TEXT_348 = NL + "    \t\tinit_";
  protected final String TEXT_349 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_350 = NL + "\t\t\tinit_";
  protected final String TEXT_351 = ".execute(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_352 = ");" + NL + "\t\t\tinit_";
  protected final String TEXT_353 = ".execute(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_354 = ");" + NL + "\t\t\tinit_";
  protected final String TEXT_355 = ".execute(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_356 = ");";
  protected final String TEXT_357 = NL + "\t\t\tinit_";
  protected final String TEXT_358 = ".execute(\"SET \"+";
  protected final String TEXT_359 = "+\"=\"+";
  protected final String TEXT_360 = ");";
  protected final String TEXT_361 = NL + NL + "\t";
  protected final String TEXT_362 = NL;
  protected final String TEXT_363 = NL + "    \t\tinit_";
  protected final String TEXT_364 = ".execute(\"SET hive.execution.engine=tez\");";
  protected final String TEXT_365 = NL + "                        System.err.println(\"Please set the path of Tez lib in 'Tez lib path'!\");";
  protected final String TEXT_366 = NL;
  protected final String TEXT_367 = NL + "        String username_";
  protected final String TEXT_368 = " = (";
  protected final String TEXT_369 = " != null && !\"\".equals(";
  protected final String TEXT_370 = ")) ? ";
  protected final String TEXT_371 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_372 = " = null;";
  protected final String TEXT_373 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_374 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_375 = ".set(\"";
  protected final String TEXT_376 = "\", ";
  protected final String TEXT_377 = ");" + NL + "        ";
  protected final String TEXT_378 = NL + "            conf_";
  protected final String TEXT_379 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_380 = NL + "        \t\tconf_";
  protected final String TEXT_381 = ".set(";
  protected final String TEXT_382 = " ,";
  protected final String TEXT_383 = ");" + NL + "        \t";
  protected final String TEXT_384 = NL + "    \t\tconf_";
  protected final String TEXT_385 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_386 = ");" + NL + "    \t\t";
  protected final String TEXT_387 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_388 = ", ";
  protected final String TEXT_389 = ");" + NL + "    \t\t";
  protected final String TEXT_390 = NL + "\t\t\tconf_";
  protected final String TEXT_391 = ".set(\"hadoop.job.ugi\",username_";
  protected final String TEXT_392 = "+\",\"+";
  protected final String TEXT_393 = ");" + NL + "        \tfs_";
  protected final String TEXT_394 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_395 = ");";
  protected final String TEXT_396 = NL + "        \t" + NL + "        \tif(username_";
  protected final String TEXT_397 = " == null || \"\".equals(username_";
  protected final String TEXT_398 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_399 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_400 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_401 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_402 = ".get(\"";
  protected final String TEXT_403 = "\")),conf_";
  protected final String TEXT_404 = ",username_";
  protected final String TEXT_405 = ");" + NL + "        \t}\t";
  protected final String TEXT_406 = NL + "                    String hdfsUserName_";
  protected final String TEXT_407 = " = (";
  protected final String TEXT_408 = " != null && !\"\".equals(";
  protected final String TEXT_409 = ")) ? ";
  protected final String TEXT_410 = " : System.getProperty(\"user.name\");" + NL + "                    String tezLibPath_";
  protected final String TEXT_411 = " = \"/tmp/\" + hdfsUserName_";
  protected final String TEXT_412 = " + \"/talend_tez_libs/";
  protected final String TEXT_413 = "\";";
  protected final String TEXT_414 = NL + "                    String tezLibPath_";
  protected final String TEXT_415 = " = ";
  protected final String TEXT_416 = ";";
  protected final String TEXT_417 = NL + "                fs_";
  protected final String TEXT_418 = ".mkdirs(new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_419 = "));";
  protected final String TEXT_420 = NL + "                String[] classPaths_";
  protected final String TEXT_421 = " = System.getProperty(\"java.class.path\").split(";
  protected final String TEXT_422 = "String.valueOf(globalMap.get(\"current_client_path_separator\"))";
  protected final String TEXT_423 = "System.getProperty(\"path.separator\")";
  protected final String TEXT_424 = ");" + NL + "                String tezLibLocalPath_";
  protected final String TEXT_425 = " = null;" + NL + "                for(String classPath_";
  protected final String TEXT_426 = " : classPaths_";
  protected final String TEXT_427 = "){";
  protected final String TEXT_428 = NL + "                        if(classPath_";
  protected final String TEXT_429 = ".endsWith(\"";
  protected final String TEXT_430 = "\")){" + NL + "                            org.apache.hadoop.fs.Path tezJarPath_";
  protected final String TEXT_431 = " = new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_432 = " + \"/";
  protected final String TEXT_433 = "\");" + NL + "                            if(!fs_";
  protected final String TEXT_434 = ".exists(tezJarPath_";
  protected final String TEXT_435 = ")){" + NL + "                                fs_";
  protected final String TEXT_436 = ".copyFromLocalFile(false, false, new org.apache.hadoop.fs.Path(classPath_";
  protected final String TEXT_437 = "), tezJarPath_";
  protected final String TEXT_438 = ");" + NL + "                            }" + NL + "                        }";
  protected final String TEXT_439 = NL + "                }";
  protected final String TEXT_440 = NL + "                String tezLibPath_";
  protected final String TEXT_441 = " = ";
  protected final String TEXT_442 = ";";
  protected final String TEXT_443 = NL + "\t\t\tStringBuilder script_";
  protected final String TEXT_444 = " = new StringBuilder();" + NL + "\t\t\tString[] tezLibPaths_";
  protected final String TEXT_445 = " = tezLibPath_";
  protected final String TEXT_446 = ".split(\",\");" + NL + "\t\t\tscript_";
  protected final String TEXT_447 = ".append(\"SET tez.lib.uris=\");" + NL + "\t\t\tint tezLibPathCount_";
  protected final String TEXT_448 = " = 1;" + NL + "\t\t\tfor(String tezLibPathKey_";
  protected final String TEXT_449 = " : tezLibPaths_";
  protected final String TEXT_450 = "){" + NL + "\t\t\t\t script_";
  protected final String TEXT_451 = ".append(";
  protected final String TEXT_452 = " + \"/\" + tezLibPathKey_";
  protected final String TEXT_453 = ");" + NL + "\t\t\t\t if(tezLibPathCount_";
  protected final String TEXT_454 = " < tezLibPaths_";
  protected final String TEXT_455 = ".length){" + NL + "\t\t\t\t \tscript_";
  protected final String TEXT_456 = ".append(\",\");" + NL + "\t\t\t\t }" + NL + "\t\t\t\t tezLibPathCount_";
  protected final String TEXT_457 = "++;" + NL + "\t\t\t}" + NL + "\t\t\tinit_";
  protected final String TEXT_458 = ".execute(script_";
  protected final String TEXT_459 = ".toString());" + NL + "\t\t";
  protected final String TEXT_460 = NL + "\t";
  protected final String TEXT_461 = NL + "\t" + NL + "\tinit_";
  protected final String TEXT_462 = ".close();" + NL + "\t" + NL + "\t";
  protected final String TEXT_463 = NL + "\t\tjava.sql.Statement statement_";
  protected final String TEXT_464 = " = conn_";
  protected final String TEXT_465 = ".createStatement();" + NL + "\t\t";
  protected final String TEXT_466 = NL + "\t\t\tstatement_";
  protected final String TEXT_467 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_468 = ");" + NL + "\t\t";
  protected final String TEXT_469 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_470 = NL + "\t\t\tstatement_";
  protected final String TEXT_471 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_472 = ");" + NL + "\t\t";
  protected final String TEXT_473 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_474 = NL + "\t\t\tstatement_";
  protected final String TEXT_475 = ".execute(\"SET zookeeper.znode.parent=\"+";
  protected final String TEXT_476 = ");" + NL + "\t\t";
  protected final String TEXT_477 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_478 = NL + "\t\t\tstatement_";
  protected final String TEXT_479 = ".execute(\"SET hbase.security.authentication=kerberos\");" + NL + "\t\t\tstatement_";
  protected final String TEXT_480 = ".execute(\"SET hbase.rpc.engine=org.apache.hadoop.hbase.ipc.SecureRpcEngine\");" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_481 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_482 = ".execute(\"SET hbase.master.kerberos.principal=\"+";
  protected final String TEXT_483 = ");" + NL + "\t\t\t";
  protected final String TEXT_484 = NL + "\t\t\t";
  protected final String TEXT_485 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_486 = ".execute(\"SET hbase.regionserver.kerberos.principal=\"+";
  protected final String TEXT_487 = ");" + NL + "\t\t\t";
  protected final String TEXT_488 = NL + "\t\t";
  protected final String TEXT_489 = NL + NL + "\t\t";
  protected final String TEXT_490 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_491 = ".execute(\"add jar \"+";
  protected final String TEXT_492 = ");" + NL + "\t\t";
  protected final String TEXT_493 = NL + "\t\tstatement_";
  protected final String TEXT_494 = ".close();" + NL + "\t";
  protected final String TEXT_495 = NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_496 = "\",conn_";
  protected final String TEXT_497 = ");" + NL + "" + NL + "\tglobalMap.put(\"db_";
  protected final String TEXT_498 = "\",";
  protected final String TEXT_499 = ");" + NL + "\t" + NL + "\tString currentClientPathSeparator_";
  protected final String TEXT_500 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "\tif(currentClientPathSeparator_";
  protected final String TEXT_501 = "!=null) {" + NL + "\t\tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_502 = ");" + NL + "\t\tglobalMap.put(\"current_client_path_separator\", null);" + NL + "\t}" + NL + "\t" + NL + "\tString currentClientUsername_";
  protected final String TEXT_503 = " = (String)globalMap.get(\"current_client_user_name\");" + NL + "\tif(currentClientUsername_";
  protected final String TEXT_504 = "!=null) {" + NL + "\t\tSystem.setProperty(\"user.name\", currentClientUsername_";
  protected final String TEXT_505 = ");" + NL + "\t\tglobalMap.put(\"current_client_user_name\", null);" + NL + "\t}" + NL + "\t" + NL + "\tString originalHadoopUsername_";
  protected final String TEXT_506 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_507 = "\");" + NL + "\tif(originalHadoopUsername_";
  protected final String TEXT_508 = "!=null) {" + NL + "\t\tSystem.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_509 = ");" + NL + "\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_510 = "\", null);" + NL + "\t} else {" + NL + "\t\tSystem.clearProperty(\"HADOOP_USER_NAME\");" + NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument theCodeGenArgument = (CodeGeneratorArgument) argument;
	INode theNode = (INode)theCodeGenArgument.getArgument();
	
	if("MICROSOFT_HD_INSIGHT".equals(ElementParameterParser.getValue(theNode, "__DISTRIBUTION__"))) { // Execution through WebHCat

    stringBuffer.append(TEXT_1);
    

	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String cid = node.getUniqueName();

	String passwordFieldName = "__HDINSIGHT_PASSWORD__";
	if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_4);
    
	} else {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_7);
    
	}
			
	passwordFieldName = "__WASB_PASSWORD__";
	if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_10);
    
	} else {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    
	}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_HOST__"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HDINSIGHT_USERNAME__"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_USERNAME__"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_HOST__"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_PORT__"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(ElementParameterParser.getValue(node, "__STATUSDIR__"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(ElementParameterParser.getValue(node, "__REMOTE_FOLDER__"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
	boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
	if(setMemory) {
		String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
		String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
		String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_50);
    
	}
	
	List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
	if(advProps!=null) {
		for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_54);
    
		}
	}

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(dbname);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
	} else { // JDBC execution

    stringBuffer.append(TEXT_67);
    stringBuffer.append(TEXT_68);
    
	class DefaultConnectionUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    protected boolean isLog4jEnabled;
	    
	    public void beforeComponentProcess(INode node){
	    }
	    
		public void createURL(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
		
		public void classForName(INode node){

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
		}
		
		public void useShareConnection(INode node) {
			String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");
			String shareDBClass = "SharedDBConnection";
			if(isLog4jEnabled){
				shareDBClass = "SharedDBConnectionLog4j";

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
			}

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(shareDBClass);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
		}
		
		public void createConnection(INode node) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
		}
		
		public void setAutoCommit(INode node) {
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_92);
    
			}

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_95);
    
		}
		
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultUtil class
	
	DefaultConnectionUtil connUtil = new DefaultConnectionUtil();

    

	class ConnectionUtil extends DefaultConnectionUtil{
		private String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		
		public void createConnection(INode node) {
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
			boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
			
			boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
			boolean cdhCanBeSecured = ("Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_4".equals(hiveVersion) || "Cloudera_CDH5_1_MR1".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
			boolean pivotalCanBeSecured = ("PIVOTAL_HD_2_0".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
			boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "HDP_2_2".equals(hiveVersion) || cdhCanBeSecured || pivotalCanBeSecured));
			boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
			if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
			} else {
				super.createConnection(node);
			}
		}
	
		public void createURL(INode node) {
			super.createURL(node);
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			String fsDefalutName = "fs.default.name";
			String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
			
			boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
			boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
			List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
			
			boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
			boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
			
			boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
			boolean cdhCanBeSecured = ("Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_4".equals(hiveVersion) || "Cloudera_CDH5_1_MR1".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
			boolean pivotalCanBeSecured = ("PIVOTAL_HD_2_0".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
			
			boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "HDP_2_2".equals(hiveVersion) || cdhCanBeSecured ||pivotalCanBeSecured));
			boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
			boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
			boolean securedEmbeddedHive2 = securedEmbedded && "HIVE2".equalsIgnoreCase(hiveServer);
			String hivePrincipal = ElementParameterParser.getValue(node, "__HIVE_PRINCIPAL__");
			boolean useSsl = "true".equals(ElementParameterParser.getValue(node, "__USE_SSL__"));
			String sslTrustStore = ElementParameterParser.getValue(node, "__SSL_TRUST_STORE__");

			if(hiveServer!=null && !"".equals(hiveServer.trim())
			    && (isCustom
			            || ("HDP_1_2".equals(hiveVersion)
			                    || "HDP_1_3".equals(hiveVersion) 
			                    || "Cloudera_CDH4".equals(hiveVersion) 
			                    || "Cloudera_CDH4_YARN".equals(hiveVersion) 
			                    || "Cloudera_CDH5".equals(hiveVersion) 
			                    || "Cloudera_CDH5_1".equals(hiveVersion) 
			                    || "Cloudera_CDH5_4".equals(hiveVersion) 
			                    || "Cloudera_CDH5_1_MR1".equals(hiveVersion) 
			                    || "MAPR213".equals(hiveVersion) 
			                    || "MAPR301".equals(hiveVersion) 
			                    || "MAPR310".equals(hiveVersion) 
			                    || "MAPR401".equals(hiveVersion) 
			                    || "MAPR410".equals(hiveVersion) 
			                    || "HDP_2_0".equals(hiveVersion) 
			                    || "HDP_2_1".equals(hiveVersion) 
			                    || "HDP_2_2".equals(hiveVersion) 
                                || "PIVOTAL_HD_2_0".equals(hiveVersion)
                                || "EMR_4_0_0".equals(hiveVersion)
                                || "APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion)))) {
				hiveServer = hiveServer.toLowerCase();
				if ("hive2".equals(hiveServer)) {
					javaDbDriver = "org.apache.hive.jdbc.HiveDriver";
				}
			} else {
				hiveServer = "hive";
			}
			if (!isCustom && (("HDP_1_2".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
			        || ("HDP_1_3".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
			        || ("HDP_2_0".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
			        || ("HDP_2_1".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
			        || ("HDP_2_2".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
			        || ("EMR_4_0_0".equals(hiveVersion) && ("EMBEDDED".equals(connectionMode) || "HIVE".equalsIgnoreCase(hiveServer)))
			        || ("APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)))) {

    stringBuffer.append(TEXT_99);
    
			}
			
			if(hadoopProps.size() > 0){
				for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_100);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_102);
    
				} 
			}
			
			if(securedEmbedded) {
				String metastoreUrl = ElementParameterParser.getValue(node, "__METASTORE_JDBC_URL__");
				String driverClass = ElementParameterParser.getValue(node, "__METASTORE_CLASSNAME__");
				String metastoreUsername = ElementParameterParser.getValue(node, "__METASTORE_USERNAME__");
				boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
				String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
				String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_103);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_104);
    if(securedEmbeddedHive2){
					// Disable authorization when using local HiveServer2 in secure mode
					
    stringBuffer.append(TEXT_105);
    
				}else{
					
    stringBuffer.append(TEXT_106);
    
				}
			
    stringBuffer.append(TEXT_107);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_109);
    
        		String passwordFieldName = "__METASTORE_PASSWORD__";
        		
    stringBuffer.append(TEXT_110);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_113);
    } else {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_119);
    
				if(securedEmbeddedHive2){
				
    stringBuffer.append(TEXT_120);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_PRINCIPAL__"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_KEYTAB__"));
    stringBuffer.append(TEXT_122);
    
				}
			
    
				if(useKeytab) {

    stringBuffer.append(TEXT_123);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_125);
    
				}
			}
			
			if(((isCustom && !useYarn)
			        || (!isCustom
			                && !"PIVOTAL_HD_1_0_1".equals(hiveVersion)
			                && !"PIVOTAL_HD_2_0".equals(hiveVersion)
			                && !"HDP_2_0".equals(hiveVersion)
			                && !"HDP_2_1".equals(hiveVersion)
			                && !"HDP_2_2".equals(hiveVersion)
			                && !"Cloudera_CDH4_YARN".equals(hiveVersion)
			                && !"Cloudera_CDH5".equals(hiveVersion)
			                && !"Cloudera_CDH5_1".equals(hiveVersion)
			                && !"Cloudera_CDH5_4".equals(hiveVersion)
			                && !"MAPR401".equals(hiveVersion)
			                && !"MAPR410".equals(hiveVersion)
			                && !"APACHE_2_4_0_EMR".equals(hiveVersion)
			                && !"EMR_4_0_0".equals(hiveVersion)
			                && !"APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion))) && setMapredJT) {
				String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_126);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_127);
    
			}
			
			if(setNamenode) {
				String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_128);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_130);
    
			}

			boolean setHadoopUser = "true".equals(ElementParameterParser.getValue(node, "__SET_HADOOP_USER__"));
		    if (setHadoopUser) {
	            String hadoopUser = ElementParameterParser.getValue(node, "__HADOOP_USER__");
                
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(hadoopUser);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    
            }
		    
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    


			if("EMBEDDED".equals(connectionMode)) {

    stringBuffer.append(TEXT_139);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_143);
    
				if(isCustom || (!isCustom && ("HDP_1_2,HDP_1_3,HDP_2_0,HDP_2_1,HDP_2_2,Cloudera_CDH4,Cloudera_CDH4_YARN,Cloudera_CDH5,Cloudera_CDH5_1,Cloudera_CDH5_4,Cloudera_CDH5_1_MR1,PIVOTAL_HD_1_0_1,PIVOTAL_HD_2_0,EMR_4_0_0".contains(hiveVersion)))) {
					String dbuser = ElementParameterParser.getValue(node, "__USER__");

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    
				}
			} else {
				if(securedStandaloneHive2) {
					// using keytab with HiveServer2 in standalone mode
					boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
					String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
					String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
					if(useKeytab) {

    stringBuffer.append(TEXT_153);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_155);
    
					}
					// Using SSL in Secure Mode
					if(useSsl){

    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_162);
    
					}else{

    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_169);
    
					}
				} else {
					// Using SSL in non Secure Mode
					if(useSsl){
						String sslStorepasswordFieldName = "__SSL_TRUST_STORE_PASSWORD__";
						if (ElementParameterParser.canEncrypt(node, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_172);
    
						}else{

    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append( ElementParameterParser.getValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_175);
    
						}

    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    
					}else{

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_189);
    
					}
				}

				String additionalJdbcSettings = ElementParameterParser.getValue(node, "__HIVE_ADDITIONAL_JDBC__");

    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(additionalJdbcSettings);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    
			}
		}
		
		public void setAutoCommit(INode node) {
			boolean useTransaction = false;//("true").equals(ElementParameterParser.getValue(node,"__IS_USE_AUTO_COMMIT__"));
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));
			if (useTransaction) {

    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_201);
    
			}
		}
		
		public String getDirverClassName(INode node){
			return javaDbDriver;
		}
	}//end class
	
	connUtil = new ConnectionUtil();

    //----------------------------component codes-----------------------------------------
    stringBuffer.append(TEXT_202);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
    if(dbschema == null||dbschema.trim().length()==0) {
    	 dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
    }
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser = ElementParameterParser.getValue(node, "__USER__");
    String dbpass = ElementParameterParser.getValue(node, "__PASS__");
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    
	boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_SHARED_CONNECTION__"));

    
	connUtil.beforeComponentProcess(node);
	connUtil.createURL(node);

    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append((dbuser != null && dbuser.trim().length() == 0)? "null":dbuser);
    stringBuffer.append(TEXT_205);
    //the tSQLiteConnection component not contain user and pass return null
    stringBuffer.append(TEXT_206);
    if(dbpass != null && dbpass.trim().length() == 0) {
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    } else {
		String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_209);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_212);
    } else {
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_215);
    }
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    }
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    
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
			
    stringBuffer.append(TEXT_221);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_222);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_223);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_226);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_229);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_232);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_237);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_239);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_240);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_243);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_246);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    
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
			
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    if (cid.startsWith("tImpala") || cid.startsWith("tHive")) {
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_254);
    } else {
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    }
    stringBuffer.append(TEXT_259);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    
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
			
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    
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
			
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    
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
			
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_273);
    
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
	    	
    stringBuffer.append(TEXT_274);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_277);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_278);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_280);
    
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
			
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_289);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
	if(isUseSharedConnection){

    stringBuffer.append(TEXT_290);
    connUtil.useShareConnection(node);
    
	} else {
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){
			String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_291);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_292);
    
		}

    stringBuffer.append(TEXT_293);
    connUtil.classForName(node);
    stringBuffer.append(TEXT_294);
    
		log4jCodeGenerateUtil.debugConnectionParams(node);
		log4jCodeGenerateUtil.connect_begin();
		connUtil.createConnection(node);
		log4jCodeGenerateUtil.connect_end();
		
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    
		if(specify_alias){

    stringBuffer.append(TEXT_298);
    
		}
	}

    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    connUtil.setAutoCommit(node);
    stringBuffer.append(TEXT_301);
    
	connUtil.afterComponentProcess(node);

    stringBuffer.append(TEXT_302);
    
	String storeByHBase = ElementParameterParser.getValue(node, "__STORE_BY_HBASE__");
	String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
	String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
	String zookeeperQuorumForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
	String zookeeperClientPortForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
	boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
	String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");	
	String hbaseMasterPrincipal = ElementParameterParser.getValue(node, "__HBASE_MASTER_PRINCIPAL__");
	String hbaseRegionServerPrincipal = ElementParameterParser.getValue(node, "__HBASE_REGIONSERVER_PRINCIPAL__");
	
	String defineRegisterJar = ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__");
	List<Map<String, String>> registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");
	String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
	
	boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(node, "__SET_RESOURCE_MANAGER__"));
	
	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");
	
	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	boolean cdhCanBeSecured = ("Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_4".equals(hiveVersion) || "Cloudera_CDH5_1_MR1".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
	boolean pivotalCanBeSecured = ("PIVOTAL_HD_2_0".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));	
			
	boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "HDP_2_2".equals(hiveVersion) || cdhCanBeSecured || pivotalCanBeSecured));
	boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
	boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
	
	boolean isKerberosAvailableHadoop2 = !isCustom && ("HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "HDP_2_2".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_4".equals(hiveVersion) || "PIVOTAL_HD_2_0".equals(hiveVersion));
	boolean isHadoop2 = "PIVOTAL_HD_1_0_1".equals(hiveVersion) || "APACHE_2_4_0_EMR".equals(hiveVersion) || "APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion) || "EMR_4_0_0".equals(hiveVersion) || "MAPR401".equals(hiveVersion) || "MAPR410".equals(hiveVersion) || isKerberosAvailableHadoop2;
	
	boolean isKerberosAvailableHadoop1 = !isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH5_1_MR1".equals(hiveVersion));
	

    stringBuffer.append(TEXT_303);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    
    if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
        String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
        String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_311);
    
	}
	
	if(securedEmbedded) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");

    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_314);
    
		if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
			String jobtrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(jobtrackerPrincipal);
    stringBuffer.append(TEXT_317);
    
		}
		if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
			String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");

    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_320);
    
		}

	}
	
	if((isCustom && useYarn) || (!isCustom && isHadoop2)) {
		if(setResourceManager) {
			String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_324);
    
		}
		
		boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_JOBHISTORY_ADDRESS__"));
		if(setJobHistoryAddress) {
			String jobHistoryAddress = ElementParameterParser.getValue(node,"__JOBHISTORY_ADDRESS__");
			
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_327);
    
		}
		
		if ("true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"))) {

    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    
		}
		
		boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
		if(setSchedulerAddress) {
			String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_332);
    
		}
		
		if("true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"))) {
			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_335);
    
		}
		
		if("EMBEDDED".equals(connectionMode)) {
			if(!isCustom && ("HDP_2_1".equals(hiveVersion) || "HDP_2_2".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_4".equals(hiveVersion) || "MAPR401".equals(hiveVersion) || "MAPR410".equals(hiveVersion) || "APACHE_2_4_0_EMR".equals(hiveVersion) || "APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion))) {

    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    
			}

			if("MAPR410".equals(hiveVersion)){

    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    
			}

			if(!isCustom && "HDP_2_1".equals(hiveVersion)) {

    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    
			} else if(!isCustom && "HDP_2_2".equals(hiveVersion)) {

    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    
			} else if(!isCustom && ("APACHE_2_4_0_EMR".equals(hiveVersion) && "APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion))) {
			} else {

    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    
			}
			
			boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
			if(isCustom && useYarn && crossPlatformSubmission) {

    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    
			}
		}
		
		boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
		if(setMemory) {
			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_356);
    
		}
	}
	
	List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
	if(advProps!=null) {
		for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_359);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_360);
    
		}
	}

    stringBuffer.append(TEXT_361);
    stringBuffer.append(TEXT_362);
    
class PrepareTez{
	public void invoke(INode node, String cid){
        boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
        boolean changePathSeparator = !"MICROSOFT_HD_INSIGHT".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
        String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
        boolean useTez = "tez".equals(ElementParameterParser.getValue(node, "__EXECUTION_ENGINE__"));
    	boolean supportTez = (isCustom || "HDP_2_2".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "MAPR401".equals(hiveVersion) || "MAPR410".equals(hiveVersion)) && "EMBEDDED".equals(connectionMode);
    	if(supportTez && useTez){
    	
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    
            if(advProps != null){
                for(Map<String, String> item : advProps){
                    if("\"tez.lib.uris\"".equals(item.get("PROPERTY"))){
                    
    stringBuffer.append(TEXT_365);
      
                    }
                }
            }
            boolean installTez = "INSTALL".equals(ElementParameterParser.getValue(node, "__TEZ_LIB__"));
            if(installTez){
                //prepare the folder
                
    stringBuffer.append(TEXT_366);
    
class GetFileSystem{
	public void invoke(INode node, String cid){
        String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
        List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
        String user = null;
        
        String fsDefaultNameKey = "fs.default.name";
        
        String hadoopVersion = null;
        boolean isCustom = false;
        
        java.util.List<String> supportKrbVersionList = java.util.Arrays.<String>asList(
        	"Cloudera_CDH4","Cloudera_CDH4_YARN","Cloudera_CDH5","Cloudera_CDH5_1","Cloudera_CDH5_4","Cloudera_CDH5_1_MR1",
        	"HDP_1_2","HDP_1_3","HDP_2_0","HDP_2_1","HDP_2_2",
        	"APACHE_1_0_0","APACHE_1_0_3_EMR",
        	"PIVOTAL_HD_2_0"
        );
        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    
        hadoopVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));
        
        String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        isCustom = "CUSTOM".equals(distribution);
        
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_377);
    
        if(mrUseDatanodeHostname){
        
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_383);
     
    		}
    	}
        	
    	if(((hadoopVersion!=null && supportKrbVersionList.contains(hadoopVersion)) && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_386);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_387);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_389);
    
    		}
    	}
    	
    	if("MAPR".equals(distribution)){
    		String group = ElementParameterParser.getValue(node, "__GROUP__");
    		
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(group);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    
        }else{
        
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    
        }
    }
}

      
                (new GetFileSystem()).invoke(node, cid);
                String tezLibFolder = ElementParameterParser.getValue(node, "__TEZ_LIB_FOLDER__");
                boolean useDefaultTezLibFolder = "\"/tmp/{USERNAME}/talend_tez_libs/{custom|HIVE_VERSION}\"".equals(tezLibFolder);
                if(useDefaultTezLibFolder){
                
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(isCustom?"custom":hiveVersion);
    stringBuffer.append(TEXT_413);
    
                }else{
                
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(tezLibFolder);
    stringBuffer.append(TEXT_416);
    
                }
                
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    
                List<String> tezLibJarsName = new java.util.ArrayList<String>();
                if(isCustom){
                    List<Map<String,String>> tezLibJarsNameValue = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__TEZ_LIB_NAME__");
                    for(Map<String, String> tezLibJarsNameV : tezLibJarsNameValue){
                        tezLibJarsName.add(tezLibJarsNameV.get("JAR_NAME"));
                    }
                }else{
                    String tezLibJarsNameValue = ElementParameterParser.getValue(node, "__TEZ_JARS_NAME__");
                    if(tezLibJarsNameValue != null && !"".equals(tezLibJarsNameValue)){
                        tezLibJarsName = java.util.Arrays.asList(tezLibJarsNameValue.split(","));
                    }
                }
                
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    if(changePathSeparator){
    stringBuffer.append(TEXT_422);
    }else{
    stringBuffer.append(TEXT_423);
    }
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    
                    for(String jarName : tezLibJarsName){
                    
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    
                    }
                    
    stringBuffer.append(TEXT_439);
    
            }else{
            
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TEZ_LIB_PATH__"));
    stringBuffer.append(TEXT_442);
    
            }
            //define the location of tez lib    
            
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__"));
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    
    	}
    }
}

    stringBuffer.append(TEXT_460);
    
	(new PrepareTez()).invoke(node, cid);
	
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    if("true".equalsIgnoreCase(storeByHBase) && !("EMBEDDED".equals(connectionMode) && "MAPR2".equals(hiveVersion))) {
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_468);
    }
    stringBuffer.append(TEXT_469);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_472);
    }
    stringBuffer.append(TEXT_473);
    if(setZNodeParent && zNodeParent!=null && !"".equals(zNodeParent) && !"\"\"".equals(zNodeParent)) {
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_476);
    }
    stringBuffer.append(TEXT_477);
    if(useKrb){
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    if(hbaseMasterPrincipal!=null && !"".equals(hbaseMasterPrincipal) && !"\"\"".equals(hbaseMasterPrincipal)){
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(hbaseMasterPrincipal);
    stringBuffer.append(TEXT_483);
    }
    stringBuffer.append(TEXT_484);
    if(hbaseRegionServerPrincipal!=null && !"".equals(hbaseRegionServerPrincipal) && !"\"\"".equals(hbaseRegionServerPrincipal)){
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(hbaseRegionServerPrincipal);
    stringBuffer.append(TEXT_487);
    }
    stringBuffer.append(TEXT_488);
    }
    stringBuffer.append(TEXT_489);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
			for(Map<String, String> jar : registerJarForHBase){
				String path = jar.get("JAR_PATH");
				if(path == null || "".equals(path) || "\"\"".equals(path)) {
					continue;
				}
		
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_492);
    
			}
		}
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    }
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    
	}

    return stringBuffer.toString();
  }
}
