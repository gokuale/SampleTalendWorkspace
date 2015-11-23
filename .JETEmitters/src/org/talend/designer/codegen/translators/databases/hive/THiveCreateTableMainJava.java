package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class THiveCreateTableMainJava
{
  protected static String nl;
  public static synchronized THiveCreateTableMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveCreateTableMainJava result = new THiveCreateTableMainJava();
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
  protected final String TEXT_70 = NL;
  protected final String TEXT_71 = NL + "\tjava.io.File localPigLatin_";
  protected final String TEXT_72 = " = new java.io.File(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tjava.io.FileWriter fw_";
  protected final String TEXT_73 = " = new java.io.FileWriter(localPigLatin_";
  protected final String TEXT_74 = ".getAbsoluteFile());" + NL + "\tjava.io.BufferedWriter bw_";
  protected final String TEXT_75 = " = new java.io.BufferedWriter(fw_";
  protected final String TEXT_76 = ");" + NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_77 = " = new StringBuilder();";
  protected final String TEXT_78 = " " + NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_79 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_82 = " = ";
  protected final String TEXT_83 = "; ";
  protected final String TEXT_84 = " " + NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_85 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_88 = " = ";
  protected final String TEXT_89 = "; ";
  protected final String TEXT_90 = NL + "\t\torg.talend.webhcat.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_91 = " = new org.talend.webhcat.launcher.fs.AzureFileSystem(\"DefaultEndpointsProtocol=https;\"" + NL + "\t\t\t+ \"AccountName=\"" + NL + "\t\t\t+ ";
  protected final String TEXT_92 = NL + "\t\t\t+ \";\"" + NL + "\t\t\t+ \"AccountKey=\" + wasbPassword_";
  protected final String TEXT_93 = ", ";
  protected final String TEXT_94 = ");" + NL + "\t\t\t\t" + NL + "\t\torg.talend.webhcat.launcher.common.Job instance_";
  protected final String TEXT_95 = " = new org.talend.webhcat.launcher.common.impl.PigJob(azureFs_";
  protected final String TEXT_96 = ", org.talend.webhcat.launcher.utils.JobType.HIVE);" + NL + "\t\t\t\t\t\t" + NL + "\t\tinstance_";
  protected final String TEXT_97 = ".setAzureAccountName(";
  protected final String TEXT_98 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_99 = ".setAzureAccountPassword(wasbPassword_";
  protected final String TEXT_100 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_101 = ".setAzureStorageAddress(";
  protected final String TEXT_102 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_103 = ".setAzureContainer(";
  protected final String TEXT_104 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_105 = ".setHdInsightUsername(";
  protected final String TEXT_106 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_107 = ".setHdInsightPassword(hdInsightPassword_";
  protected final String TEXT_108 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_109 = ".setUsername(";
  protected final String TEXT_110 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_111 = ".setWebhcatEndpoint(\"https\", ";
  protected final String TEXT_112 = " + \":\" + ";
  protected final String TEXT_113 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_114 = ".setStatusFolder(org.talend.webhcat.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_115 = "));" + NL + "\t\tinstance_";
  protected final String TEXT_116 = ".setRemoteFolder(org.talend.webhcat.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_117 = "));";
  protected final String TEXT_118 = NL + "\t\torg.talend.webhcat.launcher.common.Job instance_";
  protected final String TEXT_119 = " = (org.talend.webhcat.launcher.common.Job)globalMap.get(\"conn_";
  protected final String TEXT_120 = "\");" + NL + "\t\t" + NL + "\t\torg.talend.webhcat.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_121 = " = instance_";
  protected final String TEXT_122 = ".getFileSystem();\t\t" + NL + "\t\t" + NL + "\t\tjava.util.List<String> connectionCommandList_";
  protected final String TEXT_123 = " = (java.util.List<String>)globalMap.get(\"commandList_";
  protected final String TEXT_124 = "\");" + NL + "\t\tfor(String command : connectionCommandList_";
  protected final String TEXT_125 = ") {" + NL + "\t\t\tbw_";
  protected final String TEXT_126 = ".write(command);" + NL + "\t\t}";
  protected final String TEXT_127 = NL + "\tinstance_";
  protected final String TEXT_128 = ".setFileToExecute(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tString wasbPath_";
  protected final String TEXT_129 = " = azureFs_";
  protected final String TEXT_130 = ".getFileSystemPrefix() + \"/\"\t+ instance_";
  protected final String TEXT_131 = ".getRemoteFolder()\t+ \"/libjars/\";";
  protected final String TEXT_132 = NL + "                bw_";
  protected final String TEXT_133 = ".write(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_134 = " + \";\");" + NL + "                bw_";
  protected final String TEXT_135 = ".write(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_136 = " + \";\");" + NL + "                bw_";
  protected final String TEXT_137 = ".write(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_138 = " + \";\");";
  protected final String TEXT_139 = NL + "                    bw_";
  protected final String TEXT_140 = ".write(\"SET \"+";
  protected final String TEXT_141 = "+\"=\"+";
  protected final String TEXT_142 = " + \";\");";
  protected final String TEXT_143 = NL + "            String dbname_";
  protected final String TEXT_144 = " = ";
  protected final String TEXT_145 = ";" + NL + "            if(dbname_";
  protected final String TEXT_146 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_147 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_148 = ".trim())) {" + NL + "                bw_";
  protected final String TEXT_149 = ".write(\"use \" + dbname_";
  protected final String TEXT_150 = " + \";\");" + NL + "            }";
  protected final String TEXT_151 = NL + NL + "java.sql.Connection conn_";
  protected final String TEXT_152 = " = null;";
  protected final String TEXT_153 = " " + NL + "\t\tSystem.setProperty(\"java.io.tmpdir\", ";
  protected final String TEXT_154 = "); ";
  protected final String TEXT_155 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_156 = ");";
  protected final String TEXT_157 = NL + "\t\tconn_";
  protected final String TEXT_158 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_159 = "\");" + NL + "\t\t" + NL + "\t\tString dbname_";
  protected final String TEXT_160 = " = (String)globalMap.get(\"";
  protected final String TEXT_161 = "\");" + NL + "    \tif(dbname_";
  protected final String TEXT_162 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_163 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_164 = ".trim())) {" + NL + "        \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_165 = " = conn_";
  protected final String TEXT_166 = ".createStatement();" + NL + "        \tgoToDatabase_";
  protected final String TEXT_167 = ".execute(\"use \" + dbname_";
  protected final String TEXT_168 = ");" + NL + "        \tgoToDatabase_";
  protected final String TEXT_169 = ".close();" + NL + "    \t}" + NL + "    \t" + NL + "    \tString dbUser_";
  protected final String TEXT_170 = " = (String)globalMap.get(\"";
  protected final String TEXT_171 = "\");" + NL + "    \t" + NL + "    \tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_172 = "\", System.getProperty(\"HADOOP_USER_NAME\"));" + NL + "\t\tif(dbUser_";
  protected final String TEXT_173 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_174 = ".trim())) {" + NL + "\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_175 = ");" + NL + "\t\t\t//make relative file path work for hive" + NL + "\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_176 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_177 = NL + "\t\t\tif(true) {" + NL + "\t\t\t\tthrow new java.lang.Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t}";
  protected final String TEXT_178 = NL + "\t\t\t\tSystem.setProperty(";
  protected final String TEXT_179 = " ,";
  protected final String TEXT_180 = ");";
  protected final String TEXT_181 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_182 = ");" + NL + "\t\t\t";
  protected final String TEXT_183 = NL + "\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"false\");" + NL + "\t\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"true\");" + NL + "\t\t\t\t";
  protected final String TEXT_185 = NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_186 = ");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_187 = ");" + NL + "\t        " + NL + "    \t\t";
  protected final String TEXT_188 = NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_189 = " " + NL + "        \tString decryptedMetastorePassword_";
  protected final String TEXT_190 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_191 = ");" + NL + "   \t\t \t";
  protected final String TEXT_192 = NL + "        \tString decryptedMetastorePassword_";
  protected final String TEXT_193 = " = ";
  protected final String TEXT_194 = "; " + NL + "\t\t\t";
  protected final String TEXT_195 = NL + "\t\t   \t" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", decryptedMetastorePassword_";
  protected final String TEXT_196 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_197 = ");" + NL + "\t\t\t";
  protected final String TEXT_198 = NL + "\t\t\t\tSystem.setProperty(\"hive.server2.authentication.kerberos.principal\", ";
  protected final String TEXT_199 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.server2.authentication.kerberos.keytab\", ";
  protected final String TEXT_200 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_201 = NL + "\t\t\t";
  protected final String TEXT_202 = NL + "\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_203 = ", ";
  protected final String TEXT_204 = ");";
  protected final String TEXT_205 = NL + "\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_206 = ");";
  protected final String TEXT_207 = NL + "\t\t\tSystem.setProperty(\"";
  protected final String TEXT_208 = "\", ";
  protected final String TEXT_209 = ");";
  protected final String TEXT_210 = NL + "\t\tString dbUser_";
  protected final String TEXT_211 = " = ";
  protected final String TEXT_212 = ";" + NL + "" + NL + "\t\t";
  protected final String TEXT_213 = NL + NL + "\t\t";
  protected final String TEXT_214 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_215 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_216 = ");";
  protected final String TEXT_217 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_218 = " = ";
  protected final String TEXT_219 = "; ";
  protected final String TEXT_220 = NL + NL + "\t\tString dbPwd_";
  protected final String TEXT_221 = " = decryptedPassword_";
  protected final String TEXT_222 = ";" + NL;
  protected final String TEXT_223 = NL + "            String username_";
  protected final String TEXT_224 = " = ";
  protected final String TEXT_225 = ";" + NL + "            if(username_";
  protected final String TEXT_226 = "!=null && !\"\".equals(username_";
  protected final String TEXT_227 = ".trim())) {" + NL + "                System.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_228 = ");" + NL + "            }";
  protected final String TEXT_229 = NL + "        globalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_230 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_231 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_232 = " + \":\" + ";
  protected final String TEXT_233 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\tString url_";
  protected final String TEXT_234 = " = \"jdbc:";
  protected final String TEXT_235 = "://\";";
  protected final String TEXT_236 = NL + "\t\t\t\tif(dbUser_";
  protected final String TEXT_237 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_238 = ".trim())) {" + NL + "\t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_239 = ");" + NL + "\t\t\t\t\t//make relative file path work for hive" + NL + "\t\t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_240 = ");" + NL + "\t\t\t\t}";
  protected final String TEXT_241 = NL + "\t\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_242 = ", ";
  protected final String TEXT_243 = ");";
  protected final String TEXT_244 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_245 = " = \"jdbc:";
  protected final String TEXT_246 = "://\" + ";
  protected final String TEXT_247 = " + \":\" + ";
  protected final String TEXT_248 = " + \"/\" + ";
  protected final String TEXT_249 = " + \";principal=\" + ";
  protected final String TEXT_250 = "+\";sasl.qop=auth-conf\";";
  protected final String TEXT_251 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_252 = " = \"jdbc:";
  protected final String TEXT_253 = "://\" + ";
  protected final String TEXT_254 = " + \":\" + ";
  protected final String TEXT_255 = " + \"/\" + ";
  protected final String TEXT_256 = " + \";principal=\" + ";
  protected final String TEXT_257 = ";";
  protected final String TEXT_258 = NL + "\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_259 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_260 = ");";
  protected final String TEXT_261 = NL + "\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_262 = " = ";
  protected final String TEXT_263 = "; ";
  protected final String TEXT_264 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_265 = " = \"jdbc:";
  protected final String TEXT_266 = "://\" + ";
  protected final String TEXT_267 = " + \":\" + ";
  protected final String TEXT_268 = " + \"/\" + ";
  protected final String TEXT_269 = "+ \";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_270 = " + \";trustStorePassword=\" + decryptedSslStorePassword_";
  protected final String TEXT_271 = ";";
  protected final String TEXT_272 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_273 = " = \"jdbc:";
  protected final String TEXT_274 = "://\" + ";
  protected final String TEXT_275 = " + \":\" + ";
  protected final String TEXT_276 = " + \"/\" + ";
  protected final String TEXT_277 = ";";
  protected final String TEXT_278 = NL + "\t\t\t\tString additionalJdbcSettings_";
  protected final String TEXT_279 = " = ";
  protected final String TEXT_280 = ";" + NL + "\t\t\t\tif(!\"\".equals(additionalJdbcSettings_";
  protected final String TEXT_281 = ".trim())) {" + NL + "\t\t\t\t\tif(!additionalJdbcSettings_";
  protected final String TEXT_282 = ".startsWith(\";\")) {" + NL + "\t\t\t\t\t\tadditionalJdbcSettings_";
  protected final String TEXT_283 = " = \";\" + additionalJdbcSettings_";
  protected final String TEXT_284 = ";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_285 = " += additionalJdbcSettings_";
  protected final String TEXT_286 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_287 = NL + "\t\tString driverClass_";
  protected final String TEXT_288 = " = \"";
  protected final String TEXT_289 = "\";" + NL + "\t\tjava.lang.Class.forName(driverClass_";
  protected final String TEXT_290 = ");" + NL + "\t\t";
  protected final String TEXT_291 = "\t" + NL + "\t\t";
  protected final String TEXT_292 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_293 = " - Connection attempt to '\" + url_";
  protected final String TEXT_294 = " + \"' with the username '\" + dbUser_";
  protected final String TEXT_295 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_296 = NL + "\t\t\tconn_";
  protected final String TEXT_297 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_298 = ");";
  protected final String TEXT_299 = NL + "\t\t\tconn_";
  protected final String TEXT_300 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_301 = ", dbUser_";
  protected final String TEXT_302 = ", dbPwd_";
  protected final String TEXT_303 = ");";
  protected final String TEXT_304 = NL + "\t\t";
  protected final String TEXT_305 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_306 = " - Connection to '\" + url_";
  protected final String TEXT_307 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_308 = NL + "\t\t" + NL + "\t\tjava.sql.Statement init_";
  protected final String TEXT_309 = " = conn_";
  protected final String TEXT_310 = ".createStatement();";
  protected final String TEXT_311 = NL + "        \tinit_";
  protected final String TEXT_312 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_313 = ");" + NL + "\t    \tinit_";
  protected final String TEXT_314 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_315 = ");";
  protected final String TEXT_316 = NL + "\t\tinit_";
  protected final String TEXT_317 = ".execute(\"SET dfs.namenode.kerberos.principal=\" + ";
  protected final String TEXT_318 = ");";
  protected final String TEXT_319 = NL + "\t\t\tinit_";
  protected final String TEXT_320 = ".execute(\"SET mapreduce.jobtracker.kerberos.principal=\" + ";
  protected final String TEXT_321 = ");";
  protected final String TEXT_322 = NL + "\t\t\tinit_";
  protected final String TEXT_323 = ".execute(\"SET yarn.resourcemanager.principal=\" + ";
  protected final String TEXT_324 = ");";
  protected final String TEXT_325 = NL + "        \t\tinit_";
  protected final String TEXT_326 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "        \t\tinit_";
  protected final String TEXT_327 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_328 = ");";
  protected final String TEXT_329 = NL + "\t\t\t\tinit_";
  protected final String TEXT_330 = ".execute(\"SET mapreduce.jobhistory.address=\" + ";
  protected final String TEXT_331 = ");" + NL + "    \t\t\t";
  protected final String TEXT_332 = NL + "\t\t\t\tinit_";
  protected final String TEXT_333 = ".execute(\"SET yarn.resourcemanager.scheduler.address=\" + ";
  protected final String TEXT_334 = ");";
  protected final String TEXT_335 = NL + "                init_";
  protected final String TEXT_336 = ".execute(\"SET dfs.client.use.datanode.hostname=true\");";
  protected final String TEXT_337 = NL + "\t\t\t\tinit_";
  protected final String TEXT_338 = ".execute(\"SET fs.default.name=\" + ";
  protected final String TEXT_339 = ");";
  protected final String TEXT_340 = NL + "\t\t\t\tinit_";
  protected final String TEXT_341 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_342 = NL + "\t\t\t\tinit_";
  protected final String TEXT_343 = ".execute(\"SET mapreduce.job.map.output.collector.class=org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "\t\t\t\tinit_";
  protected final String TEXT_344 = ".execute(\"SET mapreduce.job.reduce.shuffle.consumer.plugin.class=org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_345 = NL + "\t\t\t\t" + NL + "\t\t\t\tinit_";
  protected final String TEXT_346 = ".execute(\"SET yarn.application.classpath=/etc/hadoop/conf,/usr/lib/hadoop/*,/usr/lib/hadoop/lib/*,/usr/lib/hadoop-hdfs/*,/usr/lib/hadoop-hdfs/lib/*,/usr/lib/hadoop-yarn/*,/usr/lib/hadoop-yarn/lib/*,/usr/lib/hadoop-mapreduce/*,/usr/lib/hadoop-mapreduce/lib/*\");";
  protected final String TEXT_347 = NL + "\t\t\t\tinit_";
  protected final String TEXT_348 = ".execute(\"SET mapreduce.application.classpath=$PWD/mr-framework/hadoop/share/hadoop/mapreduce/*:$PWD/mr-framework/hadoop/share/hadoop/mapreduce/lib/*:$PWD/mr-framework/hadoop/share/hadoop/common/*:$PWD/mr-framework/hadoop/share/hadoop/common/lib/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/lib/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/lib/*:/etc/hadoop/conf/secure\");" + NL + "\t\t\t\tinit_";
  protected final String TEXT_349 = ".execute(\"SET yarn.application.classpath=$HADOOP_CONF_DIR,/usr/hdp/current/hadoop-client/*,/usr/hdp/current/hadoop-client/lib/*,/usr/hdp/current/hadoop-hdfs-client/*,/usr/hdp/current/hadoop-hdfs-client/lib/*,/usr/hdp/current/hadoop-mapreduce-client/*,/usr/hdp/current/hadoop-mapreduce-client/lib/*,/usr/hdp/current/hadoop-yarn-client/*,/usr/hdp/current/hadoop-yarn-client/lib/*\");";
  protected final String TEXT_350 = NL + "        \t\t//set default yarn classpath with environment variable" + NL + "        \t\tinit_";
  protected final String TEXT_351 = ".execute(\"SET yarn.application.classpath=$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*\");";
  protected final String TEXT_352 = NL + "    \t\t\tinit_";
  protected final String TEXT_353 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_354 = NL + "    \t\t\tinit_";
  protected final String TEXT_355 = ".execute(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_356 = ");" + NL + "    \t\t\tinit_";
  protected final String TEXT_357 = ".execute(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_358 = ");" + NL + "    \t\t\tinit_";
  protected final String TEXT_359 = ".execute(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_360 = ");";
  protected final String TEXT_361 = NL + "\t\t\t\tinit_";
  protected final String TEXT_362 = ".execute(\"SET \"+";
  protected final String TEXT_363 = "+\"=\"+";
  protected final String TEXT_364 = ");";
  protected final String TEXT_365 = NL + NL + "\t\t";
  protected final String TEXT_366 = NL + "        \t";
  protected final String TEXT_367 = NL;
  protected final String TEXT_368 = NL + "    \t\tinit_";
  protected final String TEXT_369 = ".execute(\"SET hive.execution.engine=tez\");";
  protected final String TEXT_370 = NL + "                        System.err.println(\"Please set the path of Tez lib in 'Tez lib path'!\");";
  protected final String TEXT_371 = NL;
  protected final String TEXT_372 = NL + "        String username_";
  protected final String TEXT_373 = " = (";
  protected final String TEXT_374 = " != null && !\"\".equals(";
  protected final String TEXT_375 = ")) ? ";
  protected final String TEXT_376 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_377 = " = null;";
  protected final String TEXT_378 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_379 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_380 = ".set(\"";
  protected final String TEXT_381 = "\", ";
  protected final String TEXT_382 = ");" + NL + "        ";
  protected final String TEXT_383 = NL + "            conf_";
  protected final String TEXT_384 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_385 = NL + "        \t\tconf_";
  protected final String TEXT_386 = ".set(";
  protected final String TEXT_387 = " ,";
  protected final String TEXT_388 = ");" + NL + "        \t";
  protected final String TEXT_389 = NL + "    \t\tconf_";
  protected final String TEXT_390 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_391 = ");" + NL + "    \t\t";
  protected final String TEXT_392 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_393 = ", ";
  protected final String TEXT_394 = ");" + NL + "    \t\t";
  protected final String TEXT_395 = NL + "\t\t\tconf_";
  protected final String TEXT_396 = ".set(\"hadoop.job.ugi\",username_";
  protected final String TEXT_397 = "+\",\"+";
  protected final String TEXT_398 = ");" + NL + "        \tfs_";
  protected final String TEXT_399 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_400 = ");";
  protected final String TEXT_401 = NL + "        \t" + NL + "        \tif(username_";
  protected final String TEXT_402 = " == null || \"\".equals(username_";
  protected final String TEXT_403 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_404 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_405 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_406 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_407 = ".get(\"";
  protected final String TEXT_408 = "\")),conf_";
  protected final String TEXT_409 = ",username_";
  protected final String TEXT_410 = ");" + NL + "        \t}\t";
  protected final String TEXT_411 = NL + "                    String hdfsUserName_";
  protected final String TEXT_412 = " = (";
  protected final String TEXT_413 = " != null && !\"\".equals(";
  protected final String TEXT_414 = ")) ? ";
  protected final String TEXT_415 = " : System.getProperty(\"user.name\");" + NL + "                    String tezLibPath_";
  protected final String TEXT_416 = " = \"/tmp/\" + hdfsUserName_";
  protected final String TEXT_417 = " + \"/talend_tez_libs/";
  protected final String TEXT_418 = "\";";
  protected final String TEXT_419 = NL + "                    String tezLibPath_";
  protected final String TEXT_420 = " = ";
  protected final String TEXT_421 = ";";
  protected final String TEXT_422 = NL + "                fs_";
  protected final String TEXT_423 = ".mkdirs(new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_424 = "));";
  protected final String TEXT_425 = NL + "                String[] classPaths_";
  protected final String TEXT_426 = " = System.getProperty(\"java.class.path\").split(";
  protected final String TEXT_427 = "String.valueOf(globalMap.get(\"current_client_path_separator\"))";
  protected final String TEXT_428 = "System.getProperty(\"path.separator\")";
  protected final String TEXT_429 = ");" + NL + "                String tezLibLocalPath_";
  protected final String TEXT_430 = " = null;" + NL + "                for(String classPath_";
  protected final String TEXT_431 = " : classPaths_";
  protected final String TEXT_432 = "){";
  protected final String TEXT_433 = NL + "                        if(classPath_";
  protected final String TEXT_434 = ".endsWith(\"";
  protected final String TEXT_435 = "\")){" + NL + "                            org.apache.hadoop.fs.Path tezJarPath_";
  protected final String TEXT_436 = " = new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_437 = " + \"/";
  protected final String TEXT_438 = "\");" + NL + "                            if(!fs_";
  protected final String TEXT_439 = ".exists(tezJarPath_";
  protected final String TEXT_440 = ")){" + NL + "                                fs_";
  protected final String TEXT_441 = ".copyFromLocalFile(false, false, new org.apache.hadoop.fs.Path(classPath_";
  protected final String TEXT_442 = "), tezJarPath_";
  protected final String TEXT_443 = ");" + NL + "                            }" + NL + "                        }";
  protected final String TEXT_444 = NL + "                }";
  protected final String TEXT_445 = NL + "                String tezLibPath_";
  protected final String TEXT_446 = " = ";
  protected final String TEXT_447 = ";";
  protected final String TEXT_448 = NL + "\t\t\tStringBuilder script_";
  protected final String TEXT_449 = " = new StringBuilder();" + NL + "\t\t\tString[] tezLibPaths_";
  protected final String TEXT_450 = " = tezLibPath_";
  protected final String TEXT_451 = ".split(\",\");" + NL + "\t\t\tscript_";
  protected final String TEXT_452 = ".append(\"SET tez.lib.uris=\");" + NL + "\t\t\tint tezLibPathCount_";
  protected final String TEXT_453 = " = 1;" + NL + "\t\t\tfor(String tezLibPathKey_";
  protected final String TEXT_454 = " : tezLibPaths_";
  protected final String TEXT_455 = "){" + NL + "\t\t\t\t script_";
  protected final String TEXT_456 = ".append(";
  protected final String TEXT_457 = " + \"/\" + tezLibPathKey_";
  protected final String TEXT_458 = ");" + NL + "\t\t\t\t if(tezLibPathCount_";
  protected final String TEXT_459 = " < tezLibPaths_";
  protected final String TEXT_460 = ".length){" + NL + "\t\t\t\t \tscript_";
  protected final String TEXT_461 = ".append(\",\");" + NL + "\t\t\t\t }" + NL + "\t\t\t\t tezLibPathCount_";
  protected final String TEXT_462 = "++;" + NL + "\t\t\t}" + NL + "\t\t\tinit_";
  protected final String TEXT_463 = ".execute(script_";
  protected final String TEXT_464 = ".toString());" + NL + "\t\t";
  protected final String TEXT_465 = NL + "            \t";
  protected final String TEXT_466 = NL + "\t\tinit_";
  protected final String TEXT_467 = ".close();" + NL + "\t\t" + NL + "    \tString dbname_";
  protected final String TEXT_468 = " = ";
  protected final String TEXT_469 = ";" + NL + "    \tif(dbname_";
  protected final String TEXT_470 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_471 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_472 = ".trim())) {" + NL + "        \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_473 = " = conn_";
  protected final String TEXT_474 = ".createStatement();" + NL + "        \tgoToDatabase_";
  protected final String TEXT_475 = ".execute(\"use \" + dbname_";
  protected final String TEXT_476 = ");" + NL + "        \tgoToDatabase_";
  protected final String TEXT_477 = ".close();" + NL + "    \t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_478 = NL + "    \t\tjava.sql.Statement statement_";
  protected final String TEXT_479 = " = conn_";
  protected final String TEXT_480 = ".createStatement();" + NL + "    \t\t";
  protected final String TEXT_481 = NL + "    \t\t\tstatement_";
  protected final String TEXT_482 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_483 = ");" + NL + "    \t\t";
  protected final String TEXT_484 = NL + "    \t" + NL + "        \t";
  protected final String TEXT_485 = NL + "        \t\tstatement_";
  protected final String TEXT_486 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_487 = ");" + NL + "        \t";
  protected final String TEXT_488 = NL + "        \t" + NL + "\t\t\t";
  protected final String TEXT_489 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_490 = ".execute(\"SET zookeeper.znode.parent=\"+";
  protected final String TEXT_491 = ");" + NL + "\t\t\t";
  protected final String TEXT_492 = NL + NL + "\t\t\t";
  protected final String TEXT_493 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_494 = ".execute(\"SET hbase.security.authentication=kerberos\");" + NL + "\t\t\t\tstatement_";
  protected final String TEXT_495 = ".execute(\"SET hbase.rpc.engine=org.apache.hadoop.hbase.ipc.SecureRpcEngine\");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_496 = NL + "\t\t\t\t\tstatement_";
  protected final String TEXT_497 = ".execute(\"SET hbase.master.kerberos.principal=\"+";
  protected final String TEXT_498 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_499 = NL + "\t\t\t\t";
  protected final String TEXT_500 = NL + "\t\t\t\t\tstatement_";
  protected final String TEXT_501 = ".execute(\"SET hbase.regionserver.kerberos.principal=\"+";
  protected final String TEXT_502 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_503 = NL + "\t\t\t";
  protected final String TEXT_504 = NL + "    \t" + NL + "        \t";
  protected final String TEXT_505 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_506 = ".execute(\"add jar \"+";
  protected final String TEXT_507 = ");" + NL + "    \t\t";
  protected final String TEXT_508 = NL + "    \t\tstatement_";
  protected final String TEXT_509 = ".close();";
  protected final String TEXT_510 = NL + "        if(true) {" + NL + "            throw new java.lang.UnsupportedOperationException(\"Parquet is only supported if the distribution uses embedded Hive version 0.10 or later.\");" + NL + "        }";
  protected final String TEXT_511 = NL + "\t\tclass GetJarsToRegister_";
  protected final String TEXT_512 = " {" + NL + "\t\t\tprivate String oozieClasspathLine;" + NL + "\t\t\tprivate boolean isOozieRuntime;" + NL + "\t\t\t" + NL + "\t\t\tpublic GetJarsToRegister_";
  protected final String TEXT_513 = "() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tthis.isOozieRuntime = setJarsToRegister();" + NL + "\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t";
  protected final String TEXT_514 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_515 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_516 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean setJarsToRegister() throws IOException, org.dom4j.DocumentException {" + NL + "\t\t\t\tString jobXmlPath = new java.io.File(\"../../job.xml\").getCanonicalPath();" + NL + "\t\t\t\tboolean isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\tif(!isOozieExecution) {" + NL + "\t\t\t\t    jobXmlPath = new java.io.File(\"./job.xml\").getCanonicalPath();" + NL + "\t\t\t\t    isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(isOozieExecution) {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.dom4j.io.SAXReader reader_oozie = new org.dom4j.io.SAXReader();" + NL + "\t\t\t\t\torg.dom4j.Document document_oozie = reader_oozie.read(jobXmlPath);" + NL + "\t\t\t\t\tList list_oozie = document_oozie.selectNodes(\"/configuration/property\");" + NL + "\t\t\t\t\tfor (java.util.Iterator iter_oozie = list_oozie.iterator(); iter_oozie.hasNext();) {" + NL + "\t\t\t\t\t\torg.dom4j.Element element_oozie = (org.dom4j.Element) iter_oozie.next();" + NL + "\t\t\t\t\t\tString name_oozie = element_oozie.elementText(\"name\");" + NL + "\t\t\t\t\t\tif(name_oozie.equals(\"mapred.cache.localFiles\") || name_oozie.equals(\"mapreduce.job.cache.local.files\")) {" + NL + "\t\t\t\t\t\t\tthis.oozieClasspathLine = element_oozie.elementText(\"value\");" + NL + "\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\t\treturn replaceJarPaths(originalClassPathLine, \"\");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine, String scheme) throws Exception {" + NL + "\t\t\t\tString classPathLine = \"\";" + NL + "\t\t\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\t\t\t" + NL + "\t\t\t\tif (isNeedAddLibsPath(crcMapPath)) {" + NL + "\t\t\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\t\t\tois.close();" + NL + "\t\t\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t\t\t} else if(this.isOozieRuntime) {" + NL + "\t\t\t\t\tif(this.oozieClasspathLine!=null) {" + NL + "\t\t\t\t\t\tList<String> oozieJars = java.util.Arrays.asList(this.oozieClasspathLine.split(\",\"));" + NL + "\t\t\t\t\t\tfor(int j=0; j<oozieJars.size(); j++) {" + NL + "\t\t\t\t\t\t\tif(oozieJars.get(j).contains(originalClassPathLine.substring(originalClassPathLine.lastIndexOf(\"/\")))) {" + NL + "\t\t\t\t\t\t\t\tclassPathLine = oozieJars.get(j);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tif(originalClassPathLine!=null && originalClassPathLine.startsWith(\".\")) {" + NL + "\t\t\t\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tclassPathLine = scheme + originalClassPathLine;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn classPathLine;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\t\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\t\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\t\t\tString jarName = entry.getValue();" + NL + "\t\t\t\tString crc = entry.getKey();" + NL + "\t\t\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\t\t\tString libStringFinder2 = \"./\" + jarName; // for the job jar itself." + NL + "\t\t\t\t" + NL + "\t\t\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.toLowerCase().contains(libStringFinder2)) {" + NL + "\t\t\t\t\tline = line.toLowerCase().replace(libStringFinder2, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t}" + NL + "            GetJarsToRegister_";
  protected final String TEXT_517 = " getJarsToRegister_";
  protected final String TEXT_518 = " = new GetJarsToRegister_";
  protected final String TEXT_519 = "();";
  protected final String TEXT_520 = NL + "\t";
  protected final String TEXT_521 = NL + "\t\tclass GetJarsToRegister_";
  protected final String TEXT_522 = " {" + NL + "\t\t\tprivate String oozieClasspathLine;" + NL + "\t\t\tprivate boolean isOozieRuntime;" + NL + "\t\t\t" + NL + "\t\t\tpublic GetJarsToRegister_";
  protected final String TEXT_523 = "() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tthis.isOozieRuntime = setJarsToRegister();" + NL + "\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t";
  protected final String TEXT_524 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_525 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_526 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean setJarsToRegister() throws IOException, org.dom4j.DocumentException {" + NL + "\t\t\t\tString jobXmlPath = new java.io.File(\"../../job.xml\").getCanonicalPath();" + NL + "\t\t\t\tboolean isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\tif(!isOozieExecution) {" + NL + "\t\t\t\t    jobXmlPath = new java.io.File(\"./job.xml\").getCanonicalPath();" + NL + "\t\t\t\t    isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(isOozieExecution) {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.dom4j.io.SAXReader reader_oozie = new org.dom4j.io.SAXReader();" + NL + "\t\t\t\t\torg.dom4j.Document document_oozie = reader_oozie.read(jobXmlPath);" + NL + "\t\t\t\t\tList list_oozie = document_oozie.selectNodes(\"/configuration/property\");" + NL + "\t\t\t\t\tfor (java.util.Iterator iter_oozie = list_oozie.iterator(); iter_oozie.hasNext();) {" + NL + "\t\t\t\t\t\torg.dom4j.Element element_oozie = (org.dom4j.Element) iter_oozie.next();" + NL + "\t\t\t\t\t\tString name_oozie = element_oozie.elementText(\"name\");" + NL + "\t\t\t\t\t\tif(name_oozie.equals(\"mapred.cache.localFiles\") || name_oozie.equals(\"mapreduce.job.cache.local.files\")) {" + NL + "\t\t\t\t\t\t\tthis.oozieClasspathLine = element_oozie.elementText(\"value\");" + NL + "\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\t\treturn replaceJarPaths(originalClassPathLine, \"\");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine, String scheme) throws Exception {" + NL + "\t\t\t\tString classPathLine = \"\";" + NL + "\t\t\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\t\t\t" + NL + "\t\t\t\tif (isNeedAddLibsPath(crcMapPath)) {" + NL + "\t\t\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\t\t\tois.close();" + NL + "\t\t\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t\t\t} else if(this.isOozieRuntime) {" + NL + "\t\t\t\t\tif(this.oozieClasspathLine!=null) {" + NL + "\t\t\t\t\t\tList<String> oozieJars = java.util.Arrays.asList(this.oozieClasspathLine.split(\",\"));" + NL + "\t\t\t\t\t\tfor(int j=0; j<oozieJars.size(); j++) {" + NL + "\t\t\t\t\t\t\tif(oozieJars.get(j).contains(originalClassPathLine.substring(originalClassPathLine.lastIndexOf(\"/\")))) {" + NL + "\t\t\t\t\t\t\t\tclassPathLine = oozieJars.get(j);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tif(originalClassPathLine!=null && originalClassPathLine.startsWith(\".\")) {" + NL + "\t\t\t\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tclassPathLine = scheme + originalClassPathLine;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn classPathLine;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\t\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\t\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\t\t\tString jarName = entry.getValue();" + NL + "\t\t\t\tString crc = entry.getKey();" + NL + "\t\t\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\t\t\tString libStringFinder2 = \"./\" + jarName; // for the job jar itself." + NL + "\t\t\t\t" + NL + "\t\t\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.toLowerCase().contains(libStringFinder2)) {" + NL + "\t\t\t\t\tline = line.toLowerCase().replace(libStringFinder2, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t}" + NL + "\t\t\t\t" + NL + "\tclass GetHiveJarsToRegister_";
  protected final String TEXT_527 = " extends GetJarsToRegister_";
  protected final String TEXT_528 = " {" + NL + "\t\t" + NL + "\t\tprivate String uploadJarToHDFS(String jar) throws Exception {" + NL + "\t\t\torg.apache.hadoop.fs.FileSystem fs = null;" + NL + "\t\t\torg.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();" + NL + "\t\t\tconf.set(\"fs.default.name\", ";
  protected final String TEXT_529 = ");" + NL + "\t\t\tString username = ";
  protected final String TEXT_530 = ";" + NL + "\t\t\tif (username == null\t|| \"\".equals(username)) {" + NL + "\t\t\t\tfs = org.apache.hadoop.fs.FileSystem.get(conf);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tfs = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf.get(\"fs.default.name\")), conf, username);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tfs.mkdirs(new org.apache.hadoop.fs.Path(\"/user/\" + username + \"/tmp\"), new org.apache.hadoop.fs.permission.FsPermission(org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL));" + NL + "\t\t\tfs.copyFromLocalFile(false, true, new org.apache.hadoop.fs.Path(jar), new org.apache.hadoop.fs.Path(\"/user/\" + username + \"/tmp\"));" + NL + "\t\t\t" + NL + "\t\t\treturn ";
  protected final String TEXT_531 = " + \"/user/\" + username + \"/tmp/\" + new java.io.File(jar).getName();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\tString classPathLine = super.replaceJarPaths(originalClassPathLine);" + NL + "\t\t\tString hdfsPath = uploadJarToHDFS(classPathLine);" + NL + "\t\t\treturn hdfsPath;" + NL + "\t\t}" + NL + "\t}" + NL + "                GetHiveJarsToRegister_";
  protected final String TEXT_532 = " getJarsToRegister_";
  protected final String TEXT_533 = " = new GetHiveJarsToRegister_";
  protected final String TEXT_534 = "();";
  protected final String TEXT_535 = NL + "            java.sql.Statement addJar_";
  protected final String TEXT_536 = " = null;";
  protected final String TEXT_537 = NL + "                        addJar_";
  protected final String TEXT_538 = " = conn_";
  protected final String TEXT_539 = ".createStatement();" + NL + "                        try {" + NL + "                            addJar_";
  protected final String TEXT_540 = ".execute(\"add jar \" + getJarsToRegister_";
  protected final String TEXT_541 = ".replaceJarPaths(\"";
  protected final String TEXT_542 = "\"));" + NL + "                        } catch (Exception e) {" + NL + "                            e.printStackTrace();" + NL + "                        } finally {" + NL + "                            addJar_";
  protected final String TEXT_543 = ".close();" + NL + "                        }";
  protected final String TEXT_544 = NL + "                            bw_";
  protected final String TEXT_545 = ".write(\"ADD JAR \" + wasbPath_";
  protected final String TEXT_546 = " + new java.io.File(getJarsToRegister_";
  protected final String TEXT_547 = ".replaceJarPaths(\"";
  protected final String TEXT_548 = "\")).getName() + \";\");" + NL + "                            libjars_";
  protected final String TEXT_549 = ".append(getJarsToRegister_";
  protected final String TEXT_550 = ".replaceJarPaths(\"";
  protected final String TEXT_551 = "\") + \",\");";
  protected final String TEXT_552 = NL + "    java.sql.Statement stmt_";
  protected final String TEXT_553 = " = conn_";
  protected final String TEXT_554 = ".createStatement();";
  protected final String TEXT_555 = NL + "    String query_";
  protected final String TEXT_556 = " = \"\";" + NL + "    String tableName_";
  protected final String TEXT_557 = " = ";
  protected final String TEXT_558 = ";";
  protected final String TEXT_559 = NL + "    String likeTableName_";
  protected final String TEXT_560 = " = ";
  protected final String TEXT_561 = ";";
  protected final String TEXT_562 = NL + "        String location_";
  protected final String TEXT_563 = " = ";
  protected final String TEXT_564 = ";";
  protected final String TEXT_565 = NL + "    String querySQL_";
  protected final String TEXT_566 = " = \"";
  protected final String TEXT_567 = "\";";
  protected final String TEXT_568 = NL + "    try {" + NL + "        stmt_";
  protected final String TEXT_569 = ".execute(querySQL_";
  protected final String TEXT_570 = ");" + NL + "    } catch(java.sql.SQLException e_";
  protected final String TEXT_571 = ") {";
  protected final String TEXT_572 = NL + "            throw(e_";
  protected final String TEXT_573 = ");";
  protected final String TEXT_574 = NL + "            System.err.println(e_";
  protected final String TEXT_575 = ".getMessage());";
  protected final String TEXT_576 = NL + "    }" + NL + "    stmt_";
  protected final String TEXT_577 = ".close();" + NL + "    globalMap.put(\"";
  protected final String TEXT_578 = "_QUERY\", querySQL_";
  protected final String TEXT_579 = ");" + NL + "" + NL + "    String currentClientPathSeparator_";
  protected final String TEXT_580 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "    if(currentClientPathSeparator_";
  protected final String TEXT_581 = "!=null) {" + NL + "        System.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_582 = ");" + NL + "        globalMap.put(\"current_client_path_separator\", null);" + NL + "    }";
  protected final String TEXT_583 = NL + "        conn_";
  protected final String TEXT_584 = ".close();";
  protected final String TEXT_585 = NL + "            bw_";
  protected final String TEXT_586 = ".write(querySQL_";
  protected final String TEXT_587 = " + \";\");" + NL + "            globalMap.put(\"";
  protected final String TEXT_588 = "_QUERY\", querySQL_";
  protected final String TEXT_589 = ");" + NL + "" + NL + "            bw_";
  protected final String TEXT_590 = ".close();" + NL + "" + NL + "            if(libjars_";
  protected final String TEXT_591 = ".length() > 0) {" + NL + "                instance_";
  protected final String TEXT_592 = ".setLibJars(libjars_";
  protected final String TEXT_593 = ".toString().substring(0, libjars_";
  protected final String TEXT_594 = ".length()-1));" + NL + "            }" + NL + "            instance_";
  protected final String TEXT_595 = ".sendFiles();" + NL + "            instance_";
  protected final String TEXT_596 = ".callWS(null, true);" + NL + "            int exitCode_";
  protected final String TEXT_597 = " = instance_";
  protected final String TEXT_598 = ".execute();" + NL + "            if(exitCode_";
  protected final String TEXT_599 = " > 0) {" + NL;
  protected final String TEXT_600 = NL + "                    throw new Exception(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_601 = NL + "                    System.err.println(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_602 = NL + "                        log.error(\"";
  protected final String TEXT_603 = " - The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_604 = NL + "            }";
  protected final String TEXT_605 = NL + "\t\t\t\t\tString comment_";
  protected final String TEXT_606 = "_";
  protected final String TEXT_607 = "_";
  protected final String TEXT_608 = " = ";
  protected final String TEXT_609 = ";";
  protected final String TEXT_610 = NL + "\t\t\t\t\tString comment_";
  protected final String TEXT_611 = "_";
  protected final String TEXT_612 = "_";
  protected final String TEXT_613 = " = ";
  protected final String TEXT_614 = ";";
  protected final String TEXT_615 = NL + "\t\t\t\t\tString key_";
  protected final String TEXT_616 = "_";
  protected final String TEXT_617 = "_";
  protected final String TEXT_618 = " = ";
  protected final String TEXT_619 = ";" + NL + "\t\t\t\t\tString value_";
  protected final String TEXT_620 = "_";
  protected final String TEXT_621 = "_";
  protected final String TEXT_622 = " = ";
  protected final String TEXT_623 = ";";
  protected final String TEXT_624 = NL + "    String tableComment_";
  protected final String TEXT_625 = " = ";
  protected final String TEXT_626 = ";";
  protected final String TEXT_627 = NL + "    String clustededOrSkewed_";
  protected final String TEXT_628 = " = ";
  protected final String TEXT_629 = ";";
  protected final String TEXT_630 = NL + "            String fieldChar_";
  protected final String TEXT_631 = " = ";
  protected final String TEXT_632 = ";";
  protected final String TEXT_633 = NL + "                String escapeChar_";
  protected final String TEXT_634 = " = ";
  protected final String TEXT_635 = ";";
  protected final String TEXT_636 = NL + "            String collectionChar_";
  protected final String TEXT_637 = " = ";
  protected final String TEXT_638 = ";";
  protected final String TEXT_639 = NL + "            String mapChar_";
  protected final String TEXT_640 = " = ";
  protected final String TEXT_641 = ";";
  protected final String TEXT_642 = NL + "            String lineChar_";
  protected final String TEXT_643 = " = ";
  protected final String TEXT_644 = ";";
  protected final String TEXT_645 = NL + "        String serdeName_";
  protected final String TEXT_646 = " = ";
  protected final String TEXT_647 = ";";
  protected final String TEXT_648 = NL + "        String inputClass_";
  protected final String TEXT_649 = " = ";
  protected final String TEXT_650 = ";" + NL + "        String outputClass_";
  protected final String TEXT_651 = " = ";
  protected final String TEXT_652 = ";";
  protected final String TEXT_653 = NL + "    String storageClass_";
  protected final String TEXT_654 = " = ";
  protected final String TEXT_655 = ";";
  protected final String TEXT_656 = NL + "            String decryptedS3Password_";
  protected final String TEXT_657 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_658 = ");";
  protected final String TEXT_659 = NL + "            String decryptedS3Password_";
  protected final String TEXT_660 = " = ";
  protected final String TEXT_661 = ";";
  protected final String TEXT_662 = NL + "        String location_";
  protected final String TEXT_663 = " = \"s3n://\" + ";
  protected final String TEXT_664 = " +\":\" + decryptedS3Password_";
  protected final String TEXT_665 = " + \"@\" + ";
  protected final String TEXT_666 = ";";
  protected final String TEXT_667 = NL + "    String location_";
  protected final String TEXT_668 = " = ";
  protected final String TEXT_669 = ";";
  protected final String TEXT_670 = NL + "    String select_";
  protected final String TEXT_671 = " = ";
  protected final String TEXT_672 = ";";
  protected final String TEXT_673 = NL + "String querySQL_";
  protected final String TEXT_674 = " = \"";
  protected final String TEXT_675 = "\";";
  protected final String TEXT_676 = NL + "try {" + NL + "    stmt_";
  protected final String TEXT_677 = ".execute(querySQL_";
  protected final String TEXT_678 = ");" + NL + "} catch(java.sql.SQLException e_";
  protected final String TEXT_679 = ") {";
  protected final String TEXT_680 = NL + "        throw(e_";
  protected final String TEXT_681 = ");";
  protected final String TEXT_682 = NL + "        System.err.println(e_";
  protected final String TEXT_683 = ".getMessage());";
  protected final String TEXT_684 = NL + "        }" + NL + "stmt_";
  protected final String TEXT_685 = ".close();";
  protected final String TEXT_686 = NL + "    conn_";
  protected final String TEXT_687 = ".close();";
  protected final String TEXT_688 = NL + "globalMap.put(\"";
  protected final String TEXT_689 = "_QUERY\", querySQL_";
  protected final String TEXT_690 = ");" + NL + "" + NL + "String currentClientPathSeparator_";
  protected final String TEXT_691 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "if(currentClientPathSeparator_";
  protected final String TEXT_692 = "!=null) {" + NL + "    System.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_693 = ");" + NL + "    globalMap.put(\"current_client_path_separator\", null);" + NL + "}" + NL + "" + NL + "String currentClientUsername_";
  protected final String TEXT_694 = " = (String)globalMap.get(\"current_client_user_name\");" + NL + "if(currentClientUsername_";
  protected final String TEXT_695 = "!=null) {" + NL + "    System.setProperty(\"user.name\", currentClientUsername_";
  protected final String TEXT_696 = ");" + NL + "    globalMap.put(\"current_client_user_name\", null);" + NL + "}" + NL + "" + NL + "String originalHadoopUsername_";
  protected final String TEXT_697 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_698 = "\");" + NL + "if(originalHadoopUsername_";
  protected final String TEXT_699 = "!=null) {" + NL + "    System.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_700 = ");" + NL + "    globalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_701 = "\", null);" + NL + "} else {" + NL + "    System.clearProperty(\"HADOOP_USER_NAME\");" + NL + "}";
  protected final String TEXT_702 = NL + "        bw_";
  protected final String TEXT_703 = ".write(querySQL_";
  protected final String TEXT_704 = " + \";\");" + NL + "        globalMap.put(\"";
  protected final String TEXT_705 = "_QUERY\", querySQL_";
  protected final String TEXT_706 = ");" + NL + "" + NL + "        bw_";
  protected final String TEXT_707 = ".close();" + NL + "" + NL + "        if(libjars_";
  protected final String TEXT_708 = ".length() > 0) {" + NL + "            instance_";
  protected final String TEXT_709 = ".setLibJars(libjars_";
  protected final String TEXT_710 = ".toString().substring(0, libjars_";
  protected final String TEXT_711 = ".length()-1));" + NL + "        }" + NL + "        instance_";
  protected final String TEXT_712 = ".sendFiles();" + NL + "        instance_";
  protected final String TEXT_713 = ".callWS(null, true);" + NL + "        int exitCode_";
  protected final String TEXT_714 = " = instance_";
  protected final String TEXT_715 = ".execute();" + NL + "        if(exitCode_";
  protected final String TEXT_716 = " > 0) {" + NL;
  protected final String TEXT_717 = NL + "                throw new Exception(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_718 = NL + "                System.err.println(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_719 = NL + "                    log.error(\"";
  protected final String TEXT_720 = " - The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_721 = NL + "        }";

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

    stringBuffer.append(TEXT_70);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    final String cid = node.getUniqueName();
    String processId = node.getProcess().getId();

    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser= ElementParameterParser.getValue(node, "__USER__");


    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    boolean isExecutedThroughWebHCat = "MICROSOFT_HD_INSIGHT".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
    if("true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"))) {
        isExecutedThroughWebHCat = false;
        String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
            if(connection!=null && connection.equals(pNode.getUniqueName())) {
                isExecutedThroughWebHCat = "MICROSOFT_HD_INSIGHT".equals(ElementParameterParser.getValue(pNode, "__DISTRIBUTION__"));
            }
        }
    }

    if(isExecutedThroughWebHCat) {

    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

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
    
	if("false".equals(useExistingConn)) {
		String passwordFieldName = "__HDINSIGHT_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_80);
    
		} else {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_83);
    
		}
			
		passwordFieldName = "__WASB_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_86);
    
		} else {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_89);
    
		}

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_HOST__"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HDINSIGHT_USERNAME__"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_USERNAME__"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_HOST__"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_PORT__"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(ElementParameterParser.getValue(node, "__STATUSDIR__"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(ElementParameterParser.getValue(node, "__REMOTE_FOLDER__"));
    stringBuffer.append(TEXT_117);
    
	} else {
		String azureConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
	}

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    
        if("false".equals(useExistingConn)) { // This variable is declared and initialized in the GetAzureConnection.javajet
            boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
            if(setMemory) {
                String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
                String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
                String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_138);
    
            }

            List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
            if(advProps!=null) {
                for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_142);
    
                }
            }

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(dbname);
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
    
        }
    } else {

    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    
	boolean setTempPath = "true".equals(ElementParameterParser.getValue(node, "__SET_TEMP_PATH__")); 
	if(setTempPath) { 
		String tempPath = ElementParameterParser.getValue(node, "__TEMP_PATH__"); 

    stringBuffer.append(TEXT_153);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_154);
     
	}
	
	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_155);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_156);
    
	
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String conn = "conn_" + connection;
		String db = "db_" + connection;
		String dbUser = "dbUser_" + connection;
		
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(db);
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
    stringBuffer.append(dbUser);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    
	} else {
		String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
		String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
		String fsDefalutName = "fs.default.name";
		String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
		
		boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
		boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
		List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
		
    	String storeByHBase = ElementParameterParser.getValue(node, "__STORE_BY_HBASE__");
    	String zookeeperQuorumForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
    	String zookeeperClientPortForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
    	
    	boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
		String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");

		String hbaseMasterPrincipal = ElementParameterParser.getValue(node, "__HBASE_MASTER_PRINCIPAL__");
		String hbaseRegionServerPrincipal = ElementParameterParser.getValue(node, "__HBASE_REGIONSERVER_PRINCIPAL__");

    	String defineRegisterJar = ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__");
    	List<Map<String, String>> registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");
		
		boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
		boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
		
		boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
		boolean cdhCanBeSecured = ("Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_4".equals(hiveVersion) || "Cloudera_CDH5_1_MR1".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
		boolean pivotalCanBeSecured = ("PIVOTAL_HD_2_0".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
		boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "HDP_2_2".equals(hiveVersion) || cdhCanBeSecured || pivotalCanBeSecured));
		boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
		boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
		boolean securedEmbeddedHive2 = securedEmbedded && "HIVE2".equalsIgnoreCase(hiveServer);
		String hivePrincipal = ElementParameterParser.getValue(node, "__HIVE_PRINCIPAL__");
		boolean useSsl = "true".equals(ElementParameterParser.getValue(node, "__USE_SSL__"));
		String sslTrustStore = ElementParameterParser.getValue(node, "__SSL_TRUST_STORE__");

		// force hive2
		if ((!isCustom)
		        && (("Cloudera_CDH5_4".equals(hiveVersion))
		                || ("APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion)))) {
		    hiveServer = "HIVE2";
		}
		
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

    stringBuffer.append(TEXT_177);
    
		}
		
		if(hadoopProps.size() > 0){
			for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_178);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_180);
    
			} 
		}
		
		if(securedEmbedded) {
			String metastoreUrl = ElementParameterParser.getValue(node, "__METASTORE_JDBC_URL__");
			String driverClass = ElementParameterParser.getValue(node, "__METASTORE_CLASSNAME__");
			String metastoreUsername = ElementParameterParser.getValue(node, "__METASTORE_USERNAME__");
			boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
			String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
			String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_181);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_182);
    if(securedEmbeddedHive2){
				// Disable authorization when using local HiveServer2 in secure mode
				
    stringBuffer.append(TEXT_183);
    
			}else{
				
    stringBuffer.append(TEXT_184);
    
			}
			
    stringBuffer.append(TEXT_185);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_187);
    
    		String passwordFieldName = "__METASTORE_PASSWORD__";
    		
    stringBuffer.append(TEXT_188);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_191);
    } else {
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_194);
    }
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_197);
    
			if(securedEmbeddedHive2){
				
    stringBuffer.append(TEXT_198);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_PRINCIPAL__"));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_KEYTAB__"));
    stringBuffer.append(TEXT_200);
    
			}
			
    stringBuffer.append(TEXT_201);
    
			if(useKeytab) {

    stringBuffer.append(TEXT_202);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_204);
    
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
		            && !"EMR_4_0_0".equals(hiveVersion)
		            && !"APACHE_2_4_0_EMR".equals(hiveVersion)
		            && !"APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion))) && setMapredJT) {
			String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_205);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_206);
    
		}
		
		if(setNamenode) {
			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_207);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_209);
    
		}		

    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_212);
    
		String passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_213);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_216);
    } else {
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_219);
    }
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    
        boolean setHadoopUser = "true".equals(ElementParameterParser.getValue(node, "__SET_HADOOP_USER__"));
        if (setHadoopUser) {
            String hadoopUser = ElementParameterParser.getValue(node, "__HADOOP_USER__");
            
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(hadoopUser);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    
        }
        
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    
		if("EMBEDDED".equals(connectionMode)) {

    stringBuffer.append(TEXT_231);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_235);
    
			if(isCustom || (!isCustom && (("HDP_1_2,HDP_1_3,HDP_2_0,HDP_2_1,HDP_2_2,Cloudera_CDH4,Cloudera_CDH4_YARN,Cloudera_CDH5,Cloudera_CDH5_1,Cloudera_CDH5_4,Cloudera_CDH5_1_MR1,PIVOTAL_HD_1_0_1,PIVOTAL_HD_2_0,EMR_4_0_0".contains(hiveVersion))
			        || ("APACHE_2_4_0_EMR".equals(hiveVersion))
			        || ("APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion))))) {

    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    
			}
		} else {
				if(securedStandaloneHive2) {
					// using keytab with HiveServer2 in standalone mode
					boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
					String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
					String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
					if(useKeytab) {

    stringBuffer.append(TEXT_241);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_243);
    
					}
					// Using SSL in Secure Mode
					if(useSsl){

    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_250);
    
					}else{

    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_257);
    
					}
				} else {
					// Using SSL in non Secure Mode
					if(useSsl){
						String sslStorepasswordFieldName = "__SSL_TRUST_STORE_PASSWORD__";
						if (ElementParameterParser.canEncrypt(node, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_260);
    
						}else{

    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append( ElementParameterParser.getValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_263);
    
						}

    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    
					}else{

    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_277);
    
					}
				}
				String additionalJdbcSettings = ElementParameterParser.getValue(node, "__HIVE_ADDITIONAL_JDBC__");

    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(additionalJdbcSettings);
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
    
			}

    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    
	   		log4jCodeGenerateUtil.debugConnectionParams(node);	
		
    stringBuffer.append(TEXT_291);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    }
    
		if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    
		} else {

    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    
		}

    stringBuffer.append(TEXT_304);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    }
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    
    	if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
        	String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
       		String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_315);
    
	}
	
	boolean isKerberosAvailableHadoop2 = !isCustom && ("HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "HDP_2_2".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_4".equals(hiveVersion) || "PIVOTAL_HD_2_0".equals(hiveVersion));
	boolean isHadoop2 = "PIVOTAL_HD_1_0_1".equals(hiveVersion) || "APACHE_2_4_0_EMR".equals(hiveVersion) || "APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion) || "EMR_4_0_0".equals(hiveVersion) || "MAPR401".equals(hiveVersion) || "MAPR410".equals(hiveVersion) || isKerberosAvailableHadoop2;
	
	boolean isKerberosAvailableHadoop1 = !isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH5_1_MR1".equals(hiveVersion));
		
	if(securedEmbedded) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");

    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_318);
    
		if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
			String jobtrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(jobtrackerPrincipal);
    stringBuffer.append(TEXT_321);
    
		}
		if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
			String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");

    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_324);
    
		}

	}
		
    	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(node, "__SET_RESOURCE_MANAGER__"));
		
    	if((isCustom && useYarn) || (!isCustom && isHadoop2)) {
    		if(setResourceManager) {
    			String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_328);
    
			}

			boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_JOBHISTORY_ADDRESS__"));
			if(setJobHistoryAddress) {
				String jobHistoryAddress = ElementParameterParser.getValue(node,"__JOBHISTORY_ADDRESS__");
    			
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_331);
    
			}
			
    		boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
    		if(setSchedulerAddress) {
    			String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_334);
    
			}
    		
            if ("true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"))) {
                
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    
            }
			
    		if("true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"))) {
    			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_339);
    
			}
		
			if("EMBEDDED".equals(connectionMode)) {
				if(!isCustom && ("HDP_2_1".equals(hiveVersion) || "HDP_2_2".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_4".equals(hiveVersion) || "MAPR401".equals(hiveVersion)|| "MAPR410".equals(hiveVersion) || "APACHE_2_4_0_EMR".equals(hiveVersion) || "APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion))) {

    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    
				}

				if("MAPR410".equals(hiveVersion)){

    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    
			}

				if(!isCustom && "HDP_2_1".equals(hiveVersion)) {

    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    
				/**/
				} else if(!isCustom && "HDP_2_2".equals(hiveVersion)) {

    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    
				} else {

    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    
				/**/
				}
				
    			boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
    			if(isCustom && useYarn && crossPlatformSubmission) {

    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    
				}
			}
		
    		boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
    		if(setMemory) {
    			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
    			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
    			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_360);
    
			}
		}
		
		List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
		if(advProps!=null) {
			for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_363);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_364);
    
			}
		}

    stringBuffer.append(TEXT_365);
    
		if(("false").equals(useExistingConn)){
		
    stringBuffer.append(TEXT_366);
    stringBuffer.append(TEXT_367);
    
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
    	
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    
            if(advProps != null){
                for(Map<String, String> item : advProps){
                    if("\"tez.lib.uris\"".equals(item.get("PROPERTY"))){
                    
    stringBuffer.append(TEXT_370);
      
                    }
                }
            }
            boolean installTez = "INSTALL".equals(ElementParameterParser.getValue(node, "__TEZ_LIB__"));
            if(installTez){
                //prepare the folder
                
    stringBuffer.append(TEXT_371);
    
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
        
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    
        hadoopVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));
        
        String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        isCustom = "CUSTOM".equals(distribution);
        
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_382);
    
        if(mrUseDatanodeHostname){
        
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_387);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_388);
     
    		}
    	}
        	
    	if(((hadoopVersion!=null && supportKrbVersionList.contains(hadoopVersion)) && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_391);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_392);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_394);
    
    		}
    	}
    	
    	if("MAPR".equals(distribution)){
    		String group = ElementParameterParser.getValue(node, "__GROUP__");
    		
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(group);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    
        }else{
        
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    
        }
    }
}

      
                (new GetFileSystem()).invoke(node, cid);
                String tezLibFolder = ElementParameterParser.getValue(node, "__TEZ_LIB_FOLDER__");
                boolean useDefaultTezLibFolder = "\"/tmp/{USERNAME}/talend_tez_libs/{custom|HIVE_VERSION}\"".equals(tezLibFolder);
                if(useDefaultTezLibFolder){
                
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(isCustom?"custom":hiveVersion);
    stringBuffer.append(TEXT_418);
    
                }else{
                
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(tezLibFolder);
    stringBuffer.append(TEXT_421);
    
                }
                
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    
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
                
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    if(changePathSeparator){
    stringBuffer.append(TEXT_427);
    }else{
    stringBuffer.append(TEXT_428);
    }
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    
                    for(String jarName : tezLibJarsName){
                    
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    
                    }
                    
    stringBuffer.append(TEXT_444);
    
            }else{
            
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TEZ_LIB_PATH__"));
    stringBuffer.append(TEXT_447);
    
            }
            //define the location of tez lib    
            
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__"));
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    
    	}
    }
}

    stringBuffer.append(TEXT_465);
    
            	(new PrepareTez()).invoke(node, cid);
        }
    	
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    if("true".equalsIgnoreCase(storeByHBase) && !("EMBEDDED".equals(connectionMode) && "MAPR2".equals(hiveVersion))) {
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_483);
    }
    stringBuffer.append(TEXT_484);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_487);
    }
    stringBuffer.append(TEXT_488);
    if(setZNodeParent && zNodeParent!=null && !"".equals(zNodeParent) && !"\"\"".equals(zNodeParent)) {
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_491);
    }
    stringBuffer.append(TEXT_492);
    if(useKrb){
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    if(hbaseMasterPrincipal!=null && !"".equals(hbaseMasterPrincipal) && !"\"\"".equals(hbaseMasterPrincipal)){
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(hbaseMasterPrincipal);
    stringBuffer.append(TEXT_498);
    }
    stringBuffer.append(TEXT_499);
    if(hbaseRegionServerPrincipal!=null && !"".equals(hbaseRegionServerPrincipal) && !"\"\"".equals(hbaseRegionServerPrincipal)){
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(hbaseRegionServerPrincipal);
    stringBuffer.append(TEXT_502);
    }
    stringBuffer.append(TEXT_503);
    }
    stringBuffer.append(TEXT_504);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
        		for(Map<String, String> jar : registerJarForHBase){
        			String path = jar.get("JAR_PATH");
        			if(path == null || "".equals(path) || "\"\"".equals(path)) {
        				continue;
        			}
        	
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_507);
    
    			}
    		}

    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    
	  	}
	}

    
    }

    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
    String tableName = ElementParameterParser.getValue(node, "__TABLE__");
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
    boolean external = "true".equals(ElementParameterParser.getValue(node, "__CREATE_EXTERNAL__"));
    String tableAction = ElementParameterParser.getValue(node,"__TABLEACTION__");
    boolean createIfNotExist = "CREATE_IF_NOT_EXIST".equals(tableAction);
    boolean setPartitioned = "true".equals(ElementParameterParser.getValue(node, "__SET_PARTITIONS__"));
    boolean setClustered = false;
    boolean setSkewed = false;

    boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

    String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
    String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
    String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
    boolean setFsDefaultName = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
    String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    if(useExistingConnection && !isExecutedThroughWebHCat) {
        distribution = "";
        hiveVersion = "";
        connectionMode = "";
        setFsDefaultName = false;
        fsDefaultName = "";
        dbuser = "";
        String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
            if(connection!=null && connection.equals(pNode.getUniqueName())) {
                distribution = ElementParameterParser.getValue(pNode, "__DISTRIBUTION__");
                hiveVersion = ElementParameterParser.getValue(pNode, "__HIVE_VERSION__");
                connectionMode = ElementParameterParser.getValue(pNode, "__CONNECTION_MODE__");
                setFsDefaultName = "true".equals(ElementParameterParser.getValue(pNode, "__SET_FS_DEFAULT_NAME__"));
                fsDefaultName = ElementParameterParser.getValue(pNode, "__FS_DEFAULT_NAME__");
                dbuser = ElementParameterParser.getValue(pNode, "__USER__");
                break;
            }
        }
    }

    boolean isCustom = "CUSTOM".equals(distribution);

    boolean setLocation = "true".equals(ElementParameterParser.getValue(node, "__SET_FILE_LOCATION__"));
    String location = ElementParameterParser.getValue(node, "__FILE_LOCATION__");
    boolean isS3Location = "true".equals(ElementParameterParser.getValue(node, "__S3_LOCATION__"));

    String storedFormat = ElementParameterParser.getValue(node, "__STORAGE_FORMAT__");

    List<Map<String, String>> serdeProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SERDE_PROPERTIES__");

    List<Map<String, String>> tableProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TABLE_PROPERTIES__");

    boolean setDelimitedRowFormat = "true".equals(ElementParameterParser.getValue(node, "__SET_ROW_FORMAT__"));
    boolean setSerdeRowFormat = "true".equals(ElementParameterParser.getValue(node, "__SET_SERDE_ROW_FORMAT__"));

    boolean setRowFormat = (setDelimitedRowFormat || setSerdeRowFormat) && !"STORAGE".equals(storedFormat);

    boolean storeAsAvro = "AVRO".equals(storedFormat);
    boolean storeAsParquet = "PARQUET".equals(storedFormat);

    java.util.List<String> hiveVersionList = new java.util.ArrayList<String>();
    hiveVersionList.add("Cloudera_CDH4");
    hiveVersionList.add("APACHE_1_0_0");
    hiveVersionList.add("MAPR2");
    hiveVersionList.add("PIVOTAL_HD_1_0_1");

    boolean isParquetSupported = "CUSTOM".equals(distribution) || !hiveVersionList.contains(hiveVersion);
    if(storeAsParquet && !isParquetSupported) {

    stringBuffer.append(TEXT_510);
    
    }

    // Register jars to handle the parquet format.

    boolean generateAddJarCodeForAll = storeAsParquet;
    java.util.List<String> jarsToRegister = null;
    java.util.List<String> jars = null;

    if(generateAddJarCodeForAll) {
        String[] commandLine = new String[] {"<command>"};
        try {
            commandLine = ProcessorUtilities.getCommandLine("win32",true, processId, "",org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, new String[]{});
        } catch (ProcessorException e) {
            e.printStackTrace();
        }

        jarsToRegister = new java.util.ArrayList();

        jarsToRegister.add("parquet-hive-bundle");
        jarsToRegister.add("snappy-java");

        for (int j = 0; j < commandLine.length; j++) {
            if(commandLine[j].contains("jar")) {
                jars = java.util.Arrays.asList(commandLine[j].split(";"));
                break;
            }
        }
    }

    if(jarsToRegister!=null && jars!=null) {
        if("EMBEDDED".equalsIgnoreCase(connectionMode) || isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    }
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    
        } else {
            generateAddJarCodeForAll = false;
            if(setFsDefaultName) {
                generateAddJarCodeForAll = true;

    stringBuffer.append(TEXT_520);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
    }
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    
            }
        }

        if(generateAddJarCodeForAll) {
            if(!isExecutedThroughWebHCat) { // Then we create a SQL statement to add the jars.

    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    
            }
            for(int i=0; i<jarsToRegister.size(); i++) {
                String jarToRegister = jarsToRegister.get(i);
                for(int j=0; j<jars.size(); j++) {
                    if(jars.get(j).contains(jarToRegister)) {
                        if(!isExecutedThroughWebHCat) { // Then we use the created SQL statement to add the jars.

    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_541);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    
                        } else {

    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_547);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_550);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_551);
    
                        }
                    }
                }
            }
        }
    }

    // End of parquet format handling.
    if(!isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_554);
    
    }

    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_558);
    
List<IMetadataColumn> listColumn = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if(metadatas != null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    listColumn = metadata.getListColumns();
}

StringBuilder createTableSQL = new StringBuilder();

createTableSQL.append("CREATE ");
createTableSQL.append(external || isS3Location ?"EXTERNAL":"");
createTableSQL.append(" TABLE ");
createTableSQL.append(createIfNotExist?"IF NOT EXISTS":"");
createTableSQL.append(" \" + ");
createTableSQL.append("tableName_");
createTableSQL.append(cid);
createTableSQL.append(" + \"");

boolean likeTable = "true".equals(ElementParameterParser.getValue(node, "__LIKE_TABLE__"));
if(likeTable) {
    String likeTableName = ElementParameterParser.getValue(node, "__LIKE_TABLE_NAME__");

    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(likeTableName);
    stringBuffer.append(TEXT_561);
    
    createTableSQL.append(" LIKE ");
    createTableSQL.append("\" + ");
    createTableSQL.append("likeTableName_");
    createTableSQL.append(cid);
    createTableSQL.append(" + \"");

    if(setLocation) {

    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(location);
    stringBuffer.append(TEXT_564);
    
        createTableSQL.append(" LOCATION '");
        createTableSQL.append("\" + ");
        createTableSQL.append("location_");
        createTableSQL.append(cid);
        createTableSQL.append(" + \"'");
    }

    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_566);
    stringBuffer.append(createTableSQL.toString());
    stringBuffer.append(TEXT_567);
    
        if(!isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    if(("true").equals(dieOnError)) {
        
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    
        }else {
        
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    
        }
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    
    if(!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_584);
    
    }
        } else {

    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    
                if(("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_600);
    
                } else {

    stringBuffer.append(TEXT_601);
    
                    if(isLog4jEnabled) {

    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    
                    }
                }

    stringBuffer.append(TEXT_604);
    
        }
    return stringBuffer.toString();
}

boolean asSelect = "true".equals(ElementParameterParser.getValue(node, "__AS_SELECT__"));

if(!storeAsAvro && !asSelect) {
    createTableSQL.append("(");
}

final MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever("hive_id");

    
	class Util {
		int index = 0;
		java.util.Map<String,String> hiveTypeToAvroType = null;
		String appendKeyValue = null;
	
		void generateColumnsSQL(List<IMetadataColumn> listColumn,StringBuilder createTableSQL) {
			index++;
			int count = 0;
			String ending = ",";
			for(IMetadataColumn metadataColumn : listColumn) {
				createTableSQL.append(metadataColumn.getOriginalDbColumnName());
				createTableSQL.append(" ");
            
				String hiveType = null;
				if(metadataColumn.getType() == null || metadataColumn.getType().trim().length() == 0) {
					hiveType = mappingType.getDefaultSelectedDbType(metadataColumn.getTalendType());
				} else {
					hiveType = metadataColumn.getType();
				}
        		createTableSQL.append(hiveType);
        	
	        	String comment = metadataColumn.getComment();
	        	if(comment!=null && !"".equals(comment) && !"\"\"".equals(comment)) {

    stringBuffer.append(TEXT_605);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(comment);
    stringBuffer.append(TEXT_609);
    
	        		createTableSQL.append(" COMMENT '");
		    		createTableSQL.append("\" + ");
	    			createTableSQL.append("comment_");
	    			createTableSQL.append(index);
	    			createTableSQL.append("_");
	    			createTableSQL.append(count);
	    			createTableSQL.append("_");
	    			createTableSQL.append(cid);
	        		createTableSQL.append(" + \"'");
        		}
            
            if(count == listColumn.size() - 1) {
                ending = "";
            }
            createTableSQL.append(ending);
            count++;
			}
		}
	
		void generateAvroSchema(List<IMetadataColumn> listColumn,StringBuilder schemaBuilder, String quote) {
			if(hiveTypeToAvroType == null) {
				hiveTypeToAvroType = new java.util.HashMap<String,String>();
				hiveTypeToAvroType.put("SMALLINT","int");
				hiveTypeToAvroType.put("FLOAT","float");
				hiveTypeToAvroType.put("DOUBLE","double");
				hiveTypeToAvroType.put("BIGINT","long");
				hiveTypeToAvroType.put("INT","int");
				hiveTypeToAvroType.put("TINYINT","int");
				hiveTypeToAvroType.put("STRING","string");
				hiveTypeToAvroType.put("BOOLEAN","boolean");
				hiveTypeToAvroType.put("STRUCT","record");
				hiveTypeToAvroType.put("MAP","map");
				hiveTypeToAvroType.put("ARRAY","list");
				hiveTypeToAvroType.put("TIMESTAMP","long");
			}
		
			index++;
		
			int count = 0;
			String ending = ",";
			for(IMetadataColumn metadataColumn : listColumn) {
        		schemaBuilder.append("{");
        	
        		schemaBuilder.append(quote).append("name").append(quote);
            schemaBuilder.append(" : ");
            schemaBuilder.append(quote).append(metadataColumn.getOriginalDbColumnName()).append(quote);
            
            schemaBuilder.append(", ");
            
            String hiveType = null;
            if(metadataColumn.getType() == null || metadataColumn.getType().trim().length() == 0) {
                hiveType = mappingType.getDefaultSelectedDbType(metadataColumn.getTalendType());
            } else {
                hiveType = metadataColumn.getType();
            }
            
            String avroType = hiveTypeToAvroType.get(hiveType);
            
            schemaBuilder.append(quote).append("type").append(quote);
            schemaBuilder.append(" : ");
        		schemaBuilder.append(quote).append(avroType).append(quote);
        	
        		String comment = metadataColumn.getComment();
        		if(comment!=null && !"".equals(comment) && !"\"\"".equals(comment)) {
        			schemaBuilder.append(", ");

    stringBuffer.append(TEXT_610);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(comment);
    stringBuffer.append(TEXT_614);
    
	        		schemaBuilder.append(quote).append("doc").append(quote);
	        		schemaBuilder.append(" : ");
	        		schemaBuilder.append(quote);
	        		
		    		schemaBuilder.append("\" + ");
	    			schemaBuilder.append("comment_");
	    			schemaBuilder.append(index);
	    			schemaBuilder.append("_");
	    			schemaBuilder.append(count);
	    			schemaBuilder.append("_");
	    			schemaBuilder.append(cid);
	        		schemaBuilder.append(" + \"");
	        		
	        		schemaBuilder.append(quote);
        		}
            
            schemaBuilder.append("}");
            
            if(count == listColumn.size() - 1) {
                ending = "";
            }
            schemaBuilder.append(ending);
            count++;
			}
		}
	
		void generatePros(String prefix, List<Map<String, String>> pros, StringBuilder createTableSQL) {
			index++;
			
			int count = 0;
			String ending = ",";
			if(pros.size() > 0){
				createTableSQL.append(prefix);
				createTableSQL.append("(");
				for(Map<String, String> item : pros){

    stringBuffer.append(TEXT_615);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_619);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_623);
    
		    		createTableSQL.append("'\" + ");
	    			createTableSQL.append("key_");
	    			createTableSQL.append(index);
	    			createTableSQL.append("_");
	    			createTableSQL.append(count);
	    			createTableSQL.append("_");
	    			createTableSQL.append(cid);
	        		createTableSQL.append(" + \"'");
	        		
	        		createTableSQL.append(" = ");
	        		
	        		createTableSQL.append("'\" + ");
	    			createTableSQL.append("value_");
	    			createTableSQL.append(index);
	    			createTableSQL.append("_");
	    			createTableSQL.append(count);
	    			createTableSQL.append("_");
	    			createTableSQL.append(cid);
	        		createTableSQL.append(" + \"'");
        		
        			if(count == pros.size() - 1) {
            		ending = "";
        			}
            	
	            createTableSQL.append(ending);
            	count++;
				}
			
				if(appendKeyValue!=null) {
					createTableSQL.append(",");
					createTableSQL.append(appendKeyValue);
					appendKeyValue = null;
				}
			
				createTableSQL.append(")");
			} else if(appendKeyValue!=null) {
				createTableSQL.append(prefix);
				createTableSQL.append("(");
				createTableSQL.append(appendKeyValue);
				createTableSQL.append(")");
				appendKeyValue = null;
			}
		}
	
		void appendKeyValue(String appendKeyValue) {
			this.appendKeyValue = appendKeyValue;
		}
	}

    

Util util = new Util();

if(!storeAsAvro && !asSelect) {
    util.generateColumnsSQL(listColumn,createTableSQL);
    createTableSQL.append(")");
}

String tableComment = ElementParameterParser.getValue(node, "__TABLE_COMMENT__");
if(tableComment!=null && !"".equals(tableComment) && !"\"\"".equals(tableComment)) {

    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(tableComment);
    stringBuffer.append(TEXT_626);
    
    createTableSQL.append(" COMMENT '");
    createTableSQL.append("\" + ");
    createTableSQL.append("tableComment_");
    createTableSQL.append(cid);
    createTableSQL.append(" + \"'");
}

if(setPartitioned) {
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(1);
        if (metadata!=null) {
            List<IMetadataColumn> columnList = metadata.getListColumns();
            if(columnList != null && columnList.size() > 0) {
                createTableSQL.append(" PARTITIONED BY (");
                util.generateColumnsSQL(columnList,createTableSQL);
                createTableSQL.append(")");
            }
        }
    }
}

boolean clustededOrSkewed = "true".equals(ElementParameterParser.getValue(node, "__SET_CLUSTERED_BY_AND_SKEWED_BY__"));
if(clustededOrSkewed) {
    String ddl = ElementParameterParser.getValue(node, "__CLUSTERED_BY_AND_SKEWED_BY__");
    ddl = ddl.replaceAll("\n"," ");
    ddl = ddl.replaceAll("\r"," ");

    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(ddl);
    stringBuffer.append(TEXT_629);
    
    createTableSQL.append(" \" + ");
    createTableSQL.append("clustededOrSkewed_");
    createTableSQL.append(cid);
    createTableSQL.append(" + \"");
}

if(storeAsAvro || storeAsParquet) {
    createTableSQL.append(" ROW FORMAT SERDE '" + (storeAsAvro?"org.apache.hadoop.hive.serde2.avro.AvroSerDe":"parquet.hive.serde.ParquetHiveSerDe") + "'");
    util.generatePros(" WITH SERDEPROPERTIES ", serdeProps, createTableSQL);
} else if(setRowFormat) {
    createTableSQL.append(" ROW FORMAT ");
    if(setDelimitedRowFormat) {
        createTableSQL.append("DELIMITED ");
        boolean setField = "true".equals(ElementParameterParser.getValue(node, "__SET_FIELD_TERMINATED_BY__"));
        if(setField) {
            String fieldChar = ElementParameterParser.getValue(node, "__FIELD_TERMINATED_BY__");

    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(fieldChar);
    stringBuffer.append(TEXT_632);
    
            createTableSQL.append(" FIELDS TERMINATED BY '");
            createTableSQL.append("\" + ");
            createTableSQL.append("fieldChar_");
            createTableSQL.append(cid);
            createTableSQL.append(" + \"'");

            boolean setEscape = "true".equals(ElementParameterParser.getValue(node, "__SET_FIELD_ESCAPE_BY__"));
            if(setEscape) {
                String escapeChar = ElementParameterParser.getValue(node, "__FIELD_ESCAPE_BY__");

    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(escapeChar);
    stringBuffer.append(TEXT_635);
    
                createTableSQL.append(" ESCAPED BY '");
                createTableSQL.append("\" + ");
                createTableSQL.append("escapeChar_");
                createTableSQL.append(cid);
                createTableSQL.append(" + \"'");
            }
        }

        boolean setCollection = "true".equals(ElementParameterParser.getValue(node, "__SET_COLLECTION_ITEM_TERMINATED_BY__"));
        if(setCollection) {
            String collectionChar = ElementParameterParser.getValue(node, "__COLLECTION_ITEM_TERMINATED_BY__");

    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(collectionChar);
    stringBuffer.append(TEXT_638);
    
            createTableSQL.append(" COLLECTION ITEMS TERMINATED BY '");
            createTableSQL.append("\" + ");
            createTableSQL.append("collectionChar_");
            createTableSQL.append(cid);
            createTableSQL.append(" + \"'");
        }

        boolean setMap = "true".equals(ElementParameterParser.getValue(node, "__SET_MAP_KEY_TERMINATED_BY__"));
        if(setMap) {
            String mapChar = ElementParameterParser.getValue(node, "__MAP_KEY_TERMINATED_BY__");

    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(mapChar);
    stringBuffer.append(TEXT_641);
    
            createTableSQL.append(" MAP KEYS TERMINATED BY '");
            createTableSQL.append("\" + ");
            createTableSQL.append("mapChar_");
            createTableSQL.append(cid);
            createTableSQL.append(" + \"'");
        }

        boolean setLine = "true".equals(ElementParameterParser.getValue(node, "__SET_LINES_TERMINATED_BY__"));
        if(setLine) {
            String lineChar = ElementParameterParser.getValue(node, "__LINES_TERMINATED_BY__");

    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(lineChar);
    stringBuffer.append(TEXT_644);
    
            createTableSQL.append(" LINES TERMINATED BY '");
            createTableSQL.append("\" + ");
            createTableSQL.append("lineChar_");
            createTableSQL.append(cid);
            createTableSQL.append(" + \"'");
        }
    } else {
        createTableSQL.append("SERDE \\\"");
        createTableSQL.append("\" + ");
        String serdeName = ElementParameterParser.getValue(node, "__SERDE_NAME__");

    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(serdeName);
    stringBuffer.append(TEXT_647);
    
        createTableSQL.append("serdeName_");
        createTableSQL.append(cid);
        createTableSQL.append(" + \"\\\"");

        util.generatePros(" WITH SERDEPROPERTIES ", serdeProps, createTableSQL);
    }
}

if(storeAsAvro || storeAsParquet) {
    createTableSQL.append(" STORED AS INPUTFORMAT '" + (storeAsAvro?"org.apache.hadoop.hive.ql.io.avro.AvroContainerInputFormat":"parquet.hive.DeprecatedParquetInputFormat") + "'");
    createTableSQL.append(" OUTPUTFORMAT '" + (storeAsAvro?"org.apache.hadoop.hive.ql.io.avro.AvroContainerOutputFormat":"parquet.hive.DeprecatedParquetOutputFormat") + "'");
} else if(!"STORAGE".equals(storedFormat)) {
    createTableSQL.append(" STORED AS ");
    if("INPUTFORMAT_AND_OUTPUTFORMAT".equals(storedFormat)) {
        String inputClass = ElementParameterParser.getValue(node, "__INPUTFORMAT_CLASS__");
        String outputClass = ElementParameterParser.getValue(node, "__OUTPUTFORMAT_CLASS__");

    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(inputClass);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(outputClass);
    stringBuffer.append(TEXT_652);
    
        createTableSQL.append("INPUTFORMAT '");
        createTableSQL.append("\" + ");
        createTableSQL.append("inputClass_");
        createTableSQL.append(cid);
        createTableSQL.append(" + \"'");

        createTableSQL.append(" OUTPUTFORMAT '");
        createTableSQL.append("\" + ");
        createTableSQL.append("outputClass_");
        createTableSQL.append(cid);
        createTableSQL.append(" + \"'");
    } else {
        createTableSQL.append(storedFormat);
    }
} else {
    String storageClass = ElementParameterParser.getValue(node, "__STORAGE_CLASS__");

    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_654);
    stringBuffer.append(storageClass);
    stringBuffer.append(TEXT_655);
    
    createTableSQL.append(" STORED BY '");
    createTableSQL.append("\" + ");
    createTableSQL.append("storageClass_");
    createTableSQL.append(cid);
    createTableSQL.append(" + \"'");

    util.generatePros(" WITH SERDEPROPERTIES ", serdeProps, createTableSQL);
}

if(setLocation) {
    if (isS3Location) {
        String s3bucket = ElementParameterParser.getValue(node, "__S3_BUCKET__");
        String s3username = ElementParameterParser.getValue(node, "__S3_USERNAME__");

        String passwordFieldName = "__S3_PASSWORD__";
        // Get the decrypted password under the variable decryptedS3Password

        if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
            
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_658);
    
        } else {
            
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_660);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_661);
    
        }
        
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_666);
    

    } else {

    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(location);
    stringBuffer.append(TEXT_669);
    
    }
    createTableSQL.append(" LOCATION '");
    createTableSQL.append("\" + ");
    createTableSQL.append("location_");
    createTableSQL.append(cid);
    createTableSQL.append(" + \"'");
}

if(storeAsAvro) {
    StringBuilder avroSchemaBuilder = new StringBuilder();
    String quote = "\\\"";
    avroSchemaBuilder.append("'avro.schema.literal'='{").append(quote).append("name").append(quote).append(" : ").append(quote).append("row").append(quote)
    .append(", ").append(quote).append("type").append(quote).append(" : ").append(quote).append("record").append(quote)
    .append(", ").append(quote).append("fields").append(quote).append(" : [");
    util.generateAvroSchema(listColumn, avroSchemaBuilder, quote);
    avroSchemaBuilder.append("] }'");

    util.appendKeyValue(avroSchemaBuilder.toString());
}

util.generatePros(" TBLPROPERTIES ", tableProps, createTableSQL);

if(asSelect) {
    String sql = ElementParameterParser.getValue(node, "__SELECT__");
    sql = sql.replaceAll("\n"," ");
    sql = sql.replaceAll("\r"," ");

    stringBuffer.append(TEXT_670);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_671);
    stringBuffer.append(sql);
    stringBuffer.append(TEXT_672);
    
    createTableSQL.append(" AS ");
    createTableSQL.append("\" + ");
    createTableSQL.append("select_");
    createTableSQL.append(cid);
    createTableSQL.append(" + \"");
}

    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_674);
    stringBuffer.append(createTableSQL.toString());
    stringBuffer.append(TEXT_675);
    
    if(!isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    
            if(("true").equals(dieOnError)) {
    
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_681);
    
    }else {
    
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_683);
    
            }

    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_685);
    if(!("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_687);
    }
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_695);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    
    } else {

    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_712);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_716);
    
            if(("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_717);
    
            } else {

    stringBuffer.append(TEXT_718);
    
                if(isLog4jEnabled) {

    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_720);
    
                }
            }

    stringBuffer.append(TEXT_721);
    
    }

    return stringBuffer.toString();
  }
}
