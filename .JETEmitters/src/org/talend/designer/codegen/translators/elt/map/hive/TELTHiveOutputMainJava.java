package org.talend.designer.codegen.translators.elt.map.hive;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;
import java.util.List;
import java.util.Map;

public class TELTHiveOutputMainJava
{
  protected static String nl;
  public static synchronized TELTHiveOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TELTHiveOutputMainJava result = new TELTHiveOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    String select_query_";
  protected final String TEXT_3 = " = null;" + NL + "    String tableName_";
  protected final String TEXT_4 = " = null;";
  protected final String TEXT_5 = NL + "        select_query_";
  protected final String TEXT_6 = " = (String) globalMap.get(\"";
  protected final String TEXT_7 = "\"+\"QUERY\"+\"";
  protected final String TEXT_8 = "\");" + NL;
  protected final String TEXT_9 = NL + "        String dbschema_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ";" + NL + "        if(dbschema_";
  protected final String TEXT_12 = " != null && dbschema_";
  protected final String TEXT_13 = ".trim().length() > 0) {" + NL + "             tableName_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = " + \".\" + ";
  protected final String TEXT_16 = ";" + NL + "        } else {" + NL + "            tableName_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ";" + NL + "        }";
  protected final String TEXT_19 = NL + "\tjava.io.File localPigLatin_";
  protected final String TEXT_20 = " = new java.io.File(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tjava.io.FileWriter fw_";
  protected final String TEXT_21 = " = new java.io.FileWriter(localPigLatin_";
  protected final String TEXT_22 = ".getAbsoluteFile());" + NL + "\tjava.io.BufferedWriter bw_";
  protected final String TEXT_23 = " = new java.io.BufferedWriter(fw_";
  protected final String TEXT_24 = ");" + NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_25 = " = new StringBuilder();";
  protected final String TEXT_26 = " " + NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_27 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_30 = " = ";
  protected final String TEXT_31 = "; ";
  protected final String TEXT_32 = " " + NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_33 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_36 = " = ";
  protected final String TEXT_37 = "; ";
  protected final String TEXT_38 = NL + "\t\torg.talend.webhcat.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_39 = " = new org.talend.webhcat.launcher.fs.AzureFileSystem(\"DefaultEndpointsProtocol=https;\"" + NL + "\t\t\t+ \"AccountName=\"" + NL + "\t\t\t+ ";
  protected final String TEXT_40 = NL + "\t\t\t+ \";\"" + NL + "\t\t\t+ \"AccountKey=\" + wasbPassword_";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ");" + NL + "\t\t\t\t" + NL + "\t\torg.talend.webhcat.launcher.common.Job instance_";
  protected final String TEXT_43 = " = new org.talend.webhcat.launcher.common.impl.PigJob(azureFs_";
  protected final String TEXT_44 = ", org.talend.webhcat.launcher.utils.JobType.HIVE);" + NL + "\t\t\t\t\t\t" + NL + "\t\tinstance_";
  protected final String TEXT_45 = ".setAzureAccountName(";
  protected final String TEXT_46 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_47 = ".setAzureAccountPassword(wasbPassword_";
  protected final String TEXT_48 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_49 = ".setAzureStorageAddress(";
  protected final String TEXT_50 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_51 = ".setAzureContainer(";
  protected final String TEXT_52 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_53 = ".setHdInsightUsername(";
  protected final String TEXT_54 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_55 = ".setHdInsightPassword(hdInsightPassword_";
  protected final String TEXT_56 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_57 = ".setUsername(";
  protected final String TEXT_58 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_59 = ".setWebhcatEndpoint(\"https\", ";
  protected final String TEXT_60 = " + \":\" + ";
  protected final String TEXT_61 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_62 = ".setStatusFolder(org.talend.webhcat.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_63 = "));" + NL + "\t\tinstance_";
  protected final String TEXT_64 = ".setRemoteFolder(org.talend.webhcat.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_65 = "));";
  protected final String TEXT_66 = NL + "\t\torg.talend.webhcat.launcher.common.Job instance_";
  protected final String TEXT_67 = " = (org.talend.webhcat.launcher.common.Job)globalMap.get(\"conn_";
  protected final String TEXT_68 = "\");" + NL + "\t\t" + NL + "\t\torg.talend.webhcat.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_69 = " = instance_";
  protected final String TEXT_70 = ".getFileSystem();\t\t" + NL + "\t\t" + NL + "\t\tjava.util.List<String> connectionCommandList_";
  protected final String TEXT_71 = " = (java.util.List<String>)globalMap.get(\"commandList_";
  protected final String TEXT_72 = "\");" + NL + "\t\tfor(String command : connectionCommandList_";
  protected final String TEXT_73 = ") {" + NL + "\t\t\tbw_";
  protected final String TEXT_74 = ".write(command);" + NL + "\t\t}";
  protected final String TEXT_75 = NL + "\tinstance_";
  protected final String TEXT_76 = ".setFileToExecute(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tString wasbPath_";
  protected final String TEXT_77 = " = azureFs_";
  protected final String TEXT_78 = ".getFileSystemPrefix() + \"/\"\t+ instance_";
  protected final String TEXT_79 = ".getRemoteFolder()\t+ \"/libjars/\";";
  protected final String TEXT_80 = NL + "                bw_";
  protected final String TEXT_81 = ".write(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_82 = " + \";\");" + NL + "                bw_";
  protected final String TEXT_83 = ".write(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_84 = " + \";\");" + NL + "                bw_";
  protected final String TEXT_85 = ".write(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_86 = " + \";\");";
  protected final String TEXT_87 = NL + "                    bw_";
  protected final String TEXT_88 = ".write(\"SET \"+";
  protected final String TEXT_89 = "+\"=\"+";
  protected final String TEXT_90 = " + \";\");";
  protected final String TEXT_91 = NL + "            String dbname_";
  protected final String TEXT_92 = " = ";
  protected final String TEXT_93 = ";" + NL + "            if(dbname_";
  protected final String TEXT_94 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_95 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_96 = ".trim())) {" + NL + "                bw_";
  protected final String TEXT_97 = ".write(\"use \" + dbname_";
  protected final String TEXT_98 = " + \";\");" + NL + "            }";
  protected final String TEXT_99 = NL + "java.sql.Connection conn_";
  protected final String TEXT_100 = " = null;" + NL;
  protected final String TEXT_101 = NL + "globalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "System.setProperty(\"path.separator\", ";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "    conn_";
  protected final String TEXT_104 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_105 = "\");" + NL + "" + NL + "    String dbname_";
  protected final String TEXT_106 = " = (String)globalMap.get(\"";
  protected final String TEXT_107 = "\");" + NL + "    if(dbname_";
  protected final String TEXT_108 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_109 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_110 = ".trim())) {" + NL + "        java.sql.Statement goToDatabase_";
  protected final String TEXT_111 = " = conn_";
  protected final String TEXT_112 = ".createStatement();" + NL + "        goToDatabase_";
  protected final String TEXT_113 = ".execute(\"use \" + dbname_";
  protected final String TEXT_114 = ");" + NL + "        goToDatabase_";
  protected final String TEXT_115 = ".close();" + NL + "    }" + NL + "" + NL + "    String dbUser_";
  protected final String TEXT_116 = " = (String)globalMap.get(\"";
  protected final String TEXT_117 = "\");" + NL + "" + NL + "" + NL + "    globalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_118 = "\", System.getProperty(\"HADOOP_USER_NAME\"));" + NL + "    if(dbUser_";
  protected final String TEXT_119 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_120 = ".trim())) {" + NL + "        System.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_121 = ");" + NL + "        //make relative file path work for hive" + NL + "        globalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "        System.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_122 = ");" + NL + "    }";
  protected final String TEXT_123 = NL + "            if(true) {" + NL + "                throw new Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "            }";
  protected final String TEXT_124 = NL + "        String dbUser_";
  protected final String TEXT_125 = " = ";
  protected final String TEXT_126 = ";" + NL;
  protected final String TEXT_127 = NL;
  protected final String TEXT_128 = NL + "        ";
  protected final String TEXT_129 = "String decryptedPassword_";
  protected final String TEXT_130 = " = null;";
  protected final String TEXT_131 = " " + NL + "\tdecryptedPassword_";
  protected final String TEXT_132 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_133 = ");";
  protected final String TEXT_134 = NL + "\tdecryptedPassword_";
  protected final String TEXT_135 = " = ";
  protected final String TEXT_136 = "; ";
  protected final String TEXT_137 = NL + NL + "        String dbPwd_";
  protected final String TEXT_138 = " = decryptedPassword_";
  protected final String TEXT_139 = ";" + NL;
  protected final String TEXT_140 = NL + "            String username_";
  protected final String TEXT_141 = " = ";
  protected final String TEXT_142 = ";" + NL + "            if(username_";
  protected final String TEXT_143 = "!=null && !\"\".equals(username_";
  protected final String TEXT_144 = ".trim())) {" + NL + "                System.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_145 = ");" + NL + "            }";
  protected final String TEXT_146 = NL + NL + "        globalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_147 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_148 = NL + "            System.setProperty(\"hive.metastore.local\", \"false\");" + NL + "            System.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_149 = " + \":\" + ";
  protected final String TEXT_150 = ");" + NL + "            System.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "            String url_";
  protected final String TEXT_151 = " = \"jdbc:";
  protected final String TEXT_152 = "://\";";
  protected final String TEXT_153 = NL + "                if(dbUser_";
  protected final String TEXT_154 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_155 = ".trim())) {" + NL + "                    System.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_156 = ");" + NL + "                    //make relative file path work for hive" + NL + "                    globalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "                    System.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_157 = ");" + NL + "                }";
  protected final String TEXT_158 = NL + "                    String url_";
  protected final String TEXT_159 = " = \"jdbc:";
  protected final String TEXT_160 = "://\" + ";
  protected final String TEXT_161 = " + \":\" + ";
  protected final String TEXT_162 = " + \"/\" + ";
  protected final String TEXT_163 = " + \";principal=\" + ";
  protected final String TEXT_164 = "+\";sasl.qop=auth-conf\";";
  protected final String TEXT_165 = NL + "                    String url_";
  protected final String TEXT_166 = " = \"jdbc:";
  protected final String TEXT_167 = "://\" + ";
  protected final String TEXT_168 = " + \":\" + ";
  protected final String TEXT_169 = " + \"/\" + ";
  protected final String TEXT_170 = " + \";principal=\" + ";
  protected final String TEXT_171 = ";";
  protected final String TEXT_172 = NL + "                            String decryptedSslStorePassword_";
  protected final String TEXT_173 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_174 = ");";
  protected final String TEXT_175 = NL + "                            String decryptedSslStorePassword_";
  protected final String TEXT_176 = " = ";
  protected final String TEXT_177 = "; ";
  protected final String TEXT_178 = NL + "                        String decryptedSslStorePassword_";
  protected final String TEXT_179 = " = \"\";";
  protected final String TEXT_180 = NL + "                    String url_";
  protected final String TEXT_181 = " = \"jdbc:";
  protected final String TEXT_182 = "://\" + ";
  protected final String TEXT_183 = " + \":\" + ";
  protected final String TEXT_184 = " + \"/\" + ";
  protected final String TEXT_185 = "+ \";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_186 = " + \";trustStorePassword=\" + decryptedSslStorePassword_";
  protected final String TEXT_187 = ";";
  protected final String TEXT_188 = NL + "                String url_";
  protected final String TEXT_189 = " = \"jdbc:";
  protected final String TEXT_190 = "://\" + ";
  protected final String TEXT_191 = " + \":\" + ";
  protected final String TEXT_192 = " + \"/\" + ";
  protected final String TEXT_193 = ";";
  protected final String TEXT_194 = NL + "            String additionalJdbcSettings_";
  protected final String TEXT_195 = " = ";
  protected final String TEXT_196 = ";" + NL + "            if(!\"\".equals(additionalJdbcSettings_";
  protected final String TEXT_197 = ".trim())) {" + NL + "                if(!additionalJdbcSettings_";
  protected final String TEXT_198 = ".startsWith(\";\")) {" + NL + "                    additionalJdbcSettings_";
  protected final String TEXT_199 = " = \";\" + additionalJdbcSettings_";
  protected final String TEXT_200 = ";" + NL + "                }" + NL + "                url_";
  protected final String TEXT_201 = " += additionalJdbcSettings_";
  protected final String TEXT_202 = ";" + NL + "            }";
  protected final String TEXT_203 = NL + "        java.lang.Class.forName(\"";
  protected final String TEXT_204 = "\");";
  protected final String TEXT_205 = NL + "            conn_";
  protected final String TEXT_206 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_207 = ");";
  protected final String TEXT_208 = NL + "            conn_";
  protected final String TEXT_209 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_210 = ", dbUser_";
  protected final String TEXT_211 = ", dbPwd_";
  protected final String TEXT_212 = ");";
  protected final String TEXT_213 = NL + "        java.sql.Statement init_";
  protected final String TEXT_214 = " = conn_";
  protected final String TEXT_215 = ".createStatement();";
  protected final String TEXT_216 = NL + "            init_";
  protected final String TEXT_217 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_218 = ");" + NL + "            init_";
  protected final String TEXT_219 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_220 = ");";
  protected final String TEXT_221 = NL + "            init_";
  protected final String TEXT_222 = ".execute(\"SET dfs.namenode.kerberos.principal=\" + ";
  protected final String TEXT_223 = ");";
  protected final String TEXT_224 = NL + "                init_";
  protected final String TEXT_225 = ".execute(\"SET mapreduce.jobtracker.kerberos.principal=\" + ";
  protected final String TEXT_226 = ");";
  protected final String TEXT_227 = NL + "                init_";
  protected final String TEXT_228 = ".execute(\"SET yarn.resourcemanager.principal=\" + ";
  protected final String TEXT_229 = ");";
  protected final String TEXT_230 = NL + "                init_";
  protected final String TEXT_231 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "                init_";
  protected final String TEXT_232 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_233 = ");";
  protected final String TEXT_234 = NL + "                init_";
  protected final String TEXT_235 = ".execute(\"SET mapreduce.jobhistory.address=\" + ";
  protected final String TEXT_236 = ");";
  protected final String TEXT_237 = NL + "                init_";
  protected final String TEXT_238 = ".execute(\"SET yarn.resourcemanager.scheduler.address=\" + ";
  protected final String TEXT_239 = ");";
  protected final String TEXT_240 = NL + "                init_";
  protected final String TEXT_241 = ".execute(\"SET fs.default.name=\" + ";
  protected final String TEXT_242 = ");";
  protected final String TEXT_243 = NL + "                    init_";
  protected final String TEXT_244 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_245 = NL + "                    init_";
  protected final String TEXT_246 = ".execute(\"SET mapreduce.job.map.output.collector.class=org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "                    init_";
  protected final String TEXT_247 = ".execute(\"SET mapreduce.job.reduce.shuffle.consumer.plugin.class=org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_248 = NL + "                init_";
  protected final String TEXT_249 = ".execute(\"SET yarn.application.classpath=/etc/hadoop/conf,/usr/lib/hadoop/*,/usr/lib/hadoop/lib/*,/usr/lib/hadoop-hdfs/*,/usr/lib/hadoop-hdfs/lib/*,/usr/lib/hadoop-yarn/*,/usr/lib/hadoop-yarn/lib/*,/usr/lib/hadoop-mapreduce/*,/usr/lib/hadoop-mapreduce/lib/*\");";
  protected final String TEXT_250 = NL + "\t\t\t\tinit_";
  protected final String TEXT_251 = ".execute(\"SET mapreduce.application.classpath=$PWD/mr-framework/hadoop/share/hadoop/mapreduce/*:$PWD/mr-framework/hadoop/share/hadoop/mapreduce/lib/*:$PWD/mr-framework/hadoop/share/hadoop/common/*:$PWD/mr-framework/hadoop/share/hadoop/common/lib/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/lib/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/lib/*:/etc/hadoop/conf/secure\");" + NL + "\t\t\t\tinit_";
  protected final String TEXT_252 = ".execute(\"SET yarn.application.classpath=$HADOOP_CONF_DIR,/usr/hdp/current/hadoop-client/*,/usr/hdp/current/hadoop-client/lib/*,/usr/hdp/current/hadoop-hdfs-client/*,/usr/hdp/current/hadoop-hdfs-client/lib/*,/usr/hdp/current/hadoop-mapreduce-client/*,/usr/hdp/current/hadoop-mapreduce-client/lib/*,/usr/hdp/current/hadoop-yarn-client/*,/usr/hdp/current/hadoop-yarn-client/lib/*\");";
  protected final String TEXT_253 = NL + "                    init_";
  protected final String TEXT_254 = ".execute(\"SET yarn.application.classpath=$HADOOP_CONF_DIR,$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*,/usr/share/aws/emr/emr-fs/lib/*,/usr/share/aws/emr/lib/*,/home/hadoop/hive/conf/*\");";
  protected final String TEXT_255 = NL + "                //set default yarn classpath with environment variable" + NL + "                init_";
  protected final String TEXT_256 = ".execute(\"SET yarn.application.classpath=$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*\");";
  protected final String TEXT_257 = NL + "                    init_";
  protected final String TEXT_258 = ".execute(\"SET dfs.client.use.datanode.hostname=true\");";
  protected final String TEXT_259 = NL + "                init_";
  protected final String TEXT_260 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_261 = NL + "                init_";
  protected final String TEXT_262 = ".execute(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_263 = ");" + NL + "                init_";
  protected final String TEXT_264 = ".execute(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_265 = ");" + NL + "                init_";
  protected final String TEXT_266 = ".execute(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_267 = ");";
  protected final String TEXT_268 = NL + "                init_";
  protected final String TEXT_269 = ".execute(\"SET \"+";
  protected final String TEXT_270 = "+\"=\"+";
  protected final String TEXT_271 = ");";
  protected final String TEXT_272 = NL + NL + "\t\t";
  protected final String TEXT_273 = NL + "        \t";
  protected final String TEXT_274 = NL;
  protected final String TEXT_275 = NL + "    \t\tinit_";
  protected final String TEXT_276 = ".execute(\"SET hive.execution.engine=tez\");";
  protected final String TEXT_277 = NL + "                        System.err.println(\"Please set the path of Tez lib in 'Tez lib path'!\");";
  protected final String TEXT_278 = NL;
  protected final String TEXT_279 = NL + "        String username_";
  protected final String TEXT_280 = " = (";
  protected final String TEXT_281 = " != null && !\"\".equals(";
  protected final String TEXT_282 = ")) ? ";
  protected final String TEXT_283 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_284 = " = null;";
  protected final String TEXT_285 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_286 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_287 = ".set(\"";
  protected final String TEXT_288 = "\", ";
  protected final String TEXT_289 = ");" + NL + "        ";
  protected final String TEXT_290 = NL + "            conf_";
  protected final String TEXT_291 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_292 = NL + "        \t\tconf_";
  protected final String TEXT_293 = ".set(";
  protected final String TEXT_294 = " ,";
  protected final String TEXT_295 = ");" + NL + "        \t";
  protected final String TEXT_296 = NL + "    \t\tconf_";
  protected final String TEXT_297 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_298 = ");" + NL + "    \t\t";
  protected final String TEXT_299 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_300 = ", ";
  protected final String TEXT_301 = ");" + NL + "    \t\t";
  protected final String TEXT_302 = NL + "\t\t\tconf_";
  protected final String TEXT_303 = ".set(\"hadoop.job.ugi\",username_";
  protected final String TEXT_304 = "+\",\"+";
  protected final String TEXT_305 = ");" + NL + "        \tfs_";
  protected final String TEXT_306 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_307 = ");";
  protected final String TEXT_308 = NL + "        \t" + NL + "        \tif(username_";
  protected final String TEXT_309 = " == null || \"\".equals(username_";
  protected final String TEXT_310 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_311 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_312 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_313 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_314 = ".get(\"";
  protected final String TEXT_315 = "\")),conf_";
  protected final String TEXT_316 = ",username_";
  protected final String TEXT_317 = ");" + NL + "        \t}\t";
  protected final String TEXT_318 = NL + "                    String hdfsUserName_";
  protected final String TEXT_319 = " = (";
  protected final String TEXT_320 = " != null && !\"\".equals(";
  protected final String TEXT_321 = ")) ? ";
  protected final String TEXT_322 = " : System.getProperty(\"user.name\");" + NL + "                    String tezLibPath_";
  protected final String TEXT_323 = " = \"/tmp/\" + hdfsUserName_";
  protected final String TEXT_324 = " + \"/talend_tez_libs/";
  protected final String TEXT_325 = "\";";
  protected final String TEXT_326 = NL + "                    String tezLibPath_";
  protected final String TEXT_327 = " = ";
  protected final String TEXT_328 = ";";
  protected final String TEXT_329 = NL + "                fs_";
  protected final String TEXT_330 = ".mkdirs(new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_331 = "));";
  protected final String TEXT_332 = NL + "                String[] classPaths_";
  protected final String TEXT_333 = " = System.getProperty(\"java.class.path\").split(";
  protected final String TEXT_334 = "String.valueOf(globalMap.get(\"current_client_path_separator\"))";
  protected final String TEXT_335 = "System.getProperty(\"path.separator\")";
  protected final String TEXT_336 = ");" + NL + "                String tezLibLocalPath_";
  protected final String TEXT_337 = " = null;" + NL + "                for(String classPath_";
  protected final String TEXT_338 = " : classPaths_";
  protected final String TEXT_339 = "){";
  protected final String TEXT_340 = NL + "                        if(classPath_";
  protected final String TEXT_341 = ".endsWith(\"";
  protected final String TEXT_342 = "\")){" + NL + "                            org.apache.hadoop.fs.Path tezJarPath_";
  protected final String TEXT_343 = " = new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_344 = " + \"/";
  protected final String TEXT_345 = "\");" + NL + "                            if(!fs_";
  protected final String TEXT_346 = ".exists(tezJarPath_";
  protected final String TEXT_347 = ")){" + NL + "                                fs_";
  protected final String TEXT_348 = ".copyFromLocalFile(false, false, new org.apache.hadoop.fs.Path(classPath_";
  protected final String TEXT_349 = "), tezJarPath_";
  protected final String TEXT_350 = ");" + NL + "                            }" + NL + "                        }";
  protected final String TEXT_351 = NL + "                }";
  protected final String TEXT_352 = NL + "                String tezLibPath_";
  protected final String TEXT_353 = " = ";
  protected final String TEXT_354 = ";";
  protected final String TEXT_355 = NL + "\t\t\tStringBuilder script_";
  protected final String TEXT_356 = " = new StringBuilder();" + NL + "\t\t\tString[] tezLibPaths_";
  protected final String TEXT_357 = " = tezLibPath_";
  protected final String TEXT_358 = ".split(\",\");" + NL + "\t\t\tscript_";
  protected final String TEXT_359 = ".append(\"SET tez.lib.uris=\");" + NL + "\t\t\tint tezLibPathCount_";
  protected final String TEXT_360 = " = 1;" + NL + "\t\t\tfor(String tezLibPathKey_";
  protected final String TEXT_361 = " : tezLibPaths_";
  protected final String TEXT_362 = "){" + NL + "\t\t\t\t script_";
  protected final String TEXT_363 = ".append(";
  protected final String TEXT_364 = " + \"/\" + tezLibPathKey_";
  protected final String TEXT_365 = ");" + NL + "\t\t\t\t if(tezLibPathCount_";
  protected final String TEXT_366 = " < tezLibPaths_";
  protected final String TEXT_367 = ".length){" + NL + "\t\t\t\t \tscript_";
  protected final String TEXT_368 = ".append(\",\");" + NL + "\t\t\t\t }" + NL + "\t\t\t\t tezLibPathCount_";
  protected final String TEXT_369 = "++;" + NL + "\t\t\t}" + NL + "\t\t\tinit_";
  protected final String TEXT_370 = ".execute(script_";
  protected final String TEXT_371 = ".toString());" + NL + "\t\t";
  protected final String TEXT_372 = NL + "        \t";
  protected final String TEXT_373 = NL + "        init_";
  protected final String TEXT_374 = ".close();" + NL + "" + NL + "        String dbname_";
  protected final String TEXT_375 = " = ";
  protected final String TEXT_376 = ";" + NL + "        if(dbname_";
  protected final String TEXT_377 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_378 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_379 = ".trim())) {" + NL + "            java.sql.Statement goToDatabase_";
  protected final String TEXT_380 = " = conn_";
  protected final String TEXT_381 = ".createStatement();" + NL + "            goToDatabase_";
  protected final String TEXT_382 = ".execute(\"use \" + dbname_";
  protected final String TEXT_383 = ");" + NL + "            goToDatabase_";
  protected final String TEXT_384 = ".close();" + NL + "        }";
  protected final String TEXT_385 = NL + "            java.sql.Statement statement_";
  protected final String TEXT_386 = " = conn_";
  protected final String TEXT_387 = ".createStatement();";
  protected final String TEXT_388 = NL + "                statement_";
  protected final String TEXT_389 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_390 = ");";
  protected final String TEXT_391 = NL;
  protected final String TEXT_392 = NL + "                statement_";
  protected final String TEXT_393 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_394 = ");";
  protected final String TEXT_395 = NL;
  protected final String TEXT_396 = NL + "                statement_";
  protected final String TEXT_397 = ".execute(\"SET zookeeper.znode.parent=\"+";
  protected final String TEXT_398 = ");";
  protected final String TEXT_399 = NL;
  protected final String TEXT_400 = NL + "                    statement_";
  protected final String TEXT_401 = ".execute(\"add jar \"+";
  protected final String TEXT_402 = ");";
  protected final String TEXT_403 = NL + "            statement_";
  protected final String TEXT_404 = ".close();";
  protected final String TEXT_405 = NL + "        if(true) {" + NL + "            throw new java.lang.UnsupportedOperationException(\"Parquet is only supported if the distribution uses embedded Hive version 0.10 or later.\");" + NL + "        }";
  protected final String TEXT_406 = NL + "\t\tclass GetJarsToRegister_";
  protected final String TEXT_407 = " {" + NL + "\t\t\tprivate String oozieClasspathLine;" + NL + "\t\t\tprivate boolean isOozieRuntime;" + NL + "\t\t\t" + NL + "\t\t\tpublic GetJarsToRegister_";
  protected final String TEXT_408 = "() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tthis.isOozieRuntime = setJarsToRegister();" + NL + "\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t";
  protected final String TEXT_409 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_410 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_411 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean setJarsToRegister() throws IOException, org.dom4j.DocumentException {" + NL + "\t\t\t\tString jobXmlPath = new java.io.File(\"../../job.xml\").getCanonicalPath();" + NL + "\t\t\t\tboolean isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\tif(!isOozieExecution) {" + NL + "\t\t\t\t    jobXmlPath = new java.io.File(\"./job.xml\").getCanonicalPath();" + NL + "\t\t\t\t    isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(isOozieExecution) {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.dom4j.io.SAXReader reader_oozie = new org.dom4j.io.SAXReader();" + NL + "\t\t\t\t\torg.dom4j.Document document_oozie = reader_oozie.read(jobXmlPath);" + NL + "\t\t\t\t\tList list_oozie = document_oozie.selectNodes(\"/configuration/property\");" + NL + "\t\t\t\t\tfor (java.util.Iterator iter_oozie = list_oozie.iterator(); iter_oozie.hasNext();) {" + NL + "\t\t\t\t\t\torg.dom4j.Element element_oozie = (org.dom4j.Element) iter_oozie.next();" + NL + "\t\t\t\t\t\tString name_oozie = element_oozie.elementText(\"name\");" + NL + "\t\t\t\t\t\tif(name_oozie.equals(\"mapred.cache.localFiles\") || name_oozie.equals(\"mapreduce.job.cache.local.files\")) {" + NL + "\t\t\t\t\t\t\tthis.oozieClasspathLine = element_oozie.elementText(\"value\");" + NL + "\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\t\treturn replaceJarPaths(originalClassPathLine, \"\");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine, String scheme) throws Exception {" + NL + "\t\t\t\tString classPathLine = \"\";" + NL + "\t\t\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\t\t\t" + NL + "\t\t\t\tif (isNeedAddLibsPath(crcMapPath)) {" + NL + "\t\t\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\t\t\tois.close();" + NL + "\t\t\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t\t\t} else if(this.isOozieRuntime) {" + NL + "\t\t\t\t\tif(this.oozieClasspathLine!=null) {" + NL + "\t\t\t\t\t\tList<String> oozieJars = java.util.Arrays.asList(this.oozieClasspathLine.split(\",\"));" + NL + "\t\t\t\t\t\tfor(int j=0; j<oozieJars.size(); j++) {" + NL + "\t\t\t\t\t\t\tif(oozieJars.get(j).contains(originalClassPathLine.substring(originalClassPathLine.lastIndexOf(\"/\")))) {" + NL + "\t\t\t\t\t\t\t\tclassPathLine = oozieJars.get(j);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tif(originalClassPathLine!=null && originalClassPathLine.startsWith(\".\")) {" + NL + "\t\t\t\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tclassPathLine = scheme + originalClassPathLine;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn classPathLine;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\t\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\t\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\t\t\tString jarName = entry.getValue();" + NL + "\t\t\t\tString crc = entry.getKey();" + NL + "\t\t\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\t\t\tString libStringFinder2 = \"./\" + jarName; // for the job jar itself." + NL + "\t\t\t\t" + NL + "\t\t\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.toLowerCase().contains(libStringFinder2)) {" + NL + "\t\t\t\t\tline = line.toLowerCase().replace(libStringFinder2, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t}" + NL + "                GetJarsToRegister_";
  protected final String TEXT_412 = " getJarsToRegister_";
  protected final String TEXT_413 = " = new GetJarsToRegister_";
  protected final String TEXT_414 = "();";
  protected final String TEXT_415 = NL + "\t";
  protected final String TEXT_416 = NL + "\t\tclass GetJarsToRegister_";
  protected final String TEXT_417 = " {" + NL + "\t\t\tprivate String oozieClasspathLine;" + NL + "\t\t\tprivate boolean isOozieRuntime;" + NL + "\t\t\t" + NL + "\t\t\tpublic GetJarsToRegister_";
  protected final String TEXT_418 = "() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tthis.isOozieRuntime = setJarsToRegister();" + NL + "\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t";
  protected final String TEXT_419 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_420 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_421 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean setJarsToRegister() throws IOException, org.dom4j.DocumentException {" + NL + "\t\t\t\tString jobXmlPath = new java.io.File(\"../../job.xml\").getCanonicalPath();" + NL + "\t\t\t\tboolean isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\tif(!isOozieExecution) {" + NL + "\t\t\t\t    jobXmlPath = new java.io.File(\"./job.xml\").getCanonicalPath();" + NL + "\t\t\t\t    isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(isOozieExecution) {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.dom4j.io.SAXReader reader_oozie = new org.dom4j.io.SAXReader();" + NL + "\t\t\t\t\torg.dom4j.Document document_oozie = reader_oozie.read(jobXmlPath);" + NL + "\t\t\t\t\tList list_oozie = document_oozie.selectNodes(\"/configuration/property\");" + NL + "\t\t\t\t\tfor (java.util.Iterator iter_oozie = list_oozie.iterator(); iter_oozie.hasNext();) {" + NL + "\t\t\t\t\t\torg.dom4j.Element element_oozie = (org.dom4j.Element) iter_oozie.next();" + NL + "\t\t\t\t\t\tString name_oozie = element_oozie.elementText(\"name\");" + NL + "\t\t\t\t\t\tif(name_oozie.equals(\"mapred.cache.localFiles\") || name_oozie.equals(\"mapreduce.job.cache.local.files\")) {" + NL + "\t\t\t\t\t\t\tthis.oozieClasspathLine = element_oozie.elementText(\"value\");" + NL + "\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\t\treturn replaceJarPaths(originalClassPathLine, \"\");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine, String scheme) throws Exception {" + NL + "\t\t\t\tString classPathLine = \"\";" + NL + "\t\t\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\t\t\t" + NL + "\t\t\t\tif (isNeedAddLibsPath(crcMapPath)) {" + NL + "\t\t\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\t\t\tois.close();" + NL + "\t\t\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t\t\t} else if(this.isOozieRuntime) {" + NL + "\t\t\t\t\tif(this.oozieClasspathLine!=null) {" + NL + "\t\t\t\t\t\tList<String> oozieJars = java.util.Arrays.asList(this.oozieClasspathLine.split(\",\"));" + NL + "\t\t\t\t\t\tfor(int j=0; j<oozieJars.size(); j++) {" + NL + "\t\t\t\t\t\t\tif(oozieJars.get(j).contains(originalClassPathLine.substring(originalClassPathLine.lastIndexOf(\"/\")))) {" + NL + "\t\t\t\t\t\t\t\tclassPathLine = oozieJars.get(j);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tif(originalClassPathLine!=null && originalClassPathLine.startsWith(\".\")) {" + NL + "\t\t\t\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tclassPathLine = scheme + originalClassPathLine;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn classPathLine;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\t\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\t\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\t\t\tString jarName = entry.getValue();" + NL + "\t\t\t\tString crc = entry.getKey();" + NL + "\t\t\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\t\t\tString libStringFinder2 = \"./\" + jarName; // for the job jar itself." + NL + "\t\t\t\t" + NL + "\t\t\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.toLowerCase().contains(libStringFinder2)) {" + NL + "\t\t\t\t\tline = line.toLowerCase().replace(libStringFinder2, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t}" + NL + "\t\t\t\t" + NL + "\tclass GetHiveJarsToRegister_";
  protected final String TEXT_422 = " extends GetJarsToRegister_";
  protected final String TEXT_423 = " {" + NL + "\t\t" + NL + "\t\tprivate String uploadJarToHDFS(String jar) throws Exception {" + NL + "\t\t\torg.apache.hadoop.fs.FileSystem fs = null;" + NL + "\t\t\torg.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();" + NL + "\t\t\tconf.set(\"fs.default.name\", ";
  protected final String TEXT_424 = ");" + NL + "\t\t\tString username = ";
  protected final String TEXT_425 = ";" + NL + "\t\t\tif (username == null\t|| \"\".equals(username)) {" + NL + "\t\t\t\tfs = org.apache.hadoop.fs.FileSystem.get(conf);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tfs = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf.get(\"fs.default.name\")), conf, username);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tfs.mkdirs(new org.apache.hadoop.fs.Path(\"/user/\" + username + \"/tmp\"), new org.apache.hadoop.fs.permission.FsPermission(org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL));" + NL + "\t\t\tfs.copyFromLocalFile(false, true, new org.apache.hadoop.fs.Path(jar), new org.apache.hadoop.fs.Path(\"/user/\" + username + \"/tmp\"));" + NL + "\t\t\t" + NL + "\t\t\treturn ";
  protected final String TEXT_426 = " + \"/user/\" + username + \"/tmp/\" + new java.io.File(jar).getName();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\tString classPathLine = super.replaceJarPaths(originalClassPathLine);" + NL + "\t\t\tString hdfsPath = uploadJarToHDFS(classPathLine);" + NL + "\t\t\treturn hdfsPath;" + NL + "\t\t}" + NL + "\t}" + NL + "                    GetHiveJarsToRegister_";
  protected final String TEXT_427 = " getJarsToRegister_";
  protected final String TEXT_428 = " = new GetHiveJarsToRegister_";
  protected final String TEXT_429 = "();";
  protected final String TEXT_430 = NL + "                java.sql.Statement addJar_";
  protected final String TEXT_431 = " = null;";
  protected final String TEXT_432 = NL + "                            addJar_";
  protected final String TEXT_433 = " = conn_";
  protected final String TEXT_434 = ".createStatement();" + NL + "                            try {" + NL + "                                addJar_";
  protected final String TEXT_435 = ".execute(\"add jar \" + getJarsToRegister_";
  protected final String TEXT_436 = ".replaceJarPaths(\"";
  protected final String TEXT_437 = "\"));" + NL + "                            } catch (Exception e) {" + NL + "                                e.printStackTrace();" + NL + "                            } finally {" + NL + "                                addJar_";
  protected final String TEXT_438 = ".close();" + NL + "                            }";
  protected final String TEXT_439 = NL + "                                bw_";
  protected final String TEXT_440 = ".write(\"ADD JAR \" + wasbPath_";
  protected final String TEXT_441 = " + new java.io.File(getJarsToRegister_";
  protected final String TEXT_442 = ".replaceJarPaths(\"";
  protected final String TEXT_443 = "\")).getName() + \";\");" + NL + "                                libjars_";
  protected final String TEXT_444 = ".append(getJarsToRegister_";
  protected final String TEXT_445 = ".replaceJarPaths(\"";
  protected final String TEXT_446 = "\") + \",\");";
  protected final String TEXT_447 = NL + "            java.sql.Statement setCompression_";
  protected final String TEXT_448 = " = conn_";
  protected final String TEXT_449 = ".createStatement();" + NL + "            try {" + NL + "                setCompression_";
  protected final String TEXT_450 = ".execute(\"SET parquet.compression=";
  protected final String TEXT_451 = "\");" + NL + "            } finally {" + NL + "                setCompression_";
  protected final String TEXT_452 = ".close();" + NL + "            }";
  protected final String TEXT_453 = NL + "            bw_";
  protected final String TEXT_454 = ".write(\"SET parquet.compression=";
  protected final String TEXT_455 = ";\");";
  protected final String TEXT_456 = NL + "        java.sql.Statement stmt_";
  protected final String TEXT_457 = " = conn_";
  protected final String TEXT_458 = ".createStatement();";
  protected final String TEXT_459 = NL + "    StringBuffer partitionSql = new StringBuffer();" + NL + "    String startPartition = \"\";" + NL + "    String endPartition = \"\";" + NL + "    String bodyPartition = \"\";";
  protected final String TEXT_460 = NL + "    startPartition = \" PARTITION(\";" + NL + "    endPartition = \")\";";
  protected final String TEXT_461 = NL + "                bodyPartition = bodyPartition + ";
  protected final String TEXT_462 = ";";
  protected final String TEXT_463 = NL + "                       bodyPartition = bodyPartition + \"=\";" + NL + "                       bodyPartition = bodyPartition + ";
  protected final String TEXT_464 = ";";
  protected final String TEXT_465 = NL + "                    bodyPartition = bodyPartition + \",\";";
  protected final String TEXT_466 = NL + "    partitionSql.append(startPartition).append(bodyPartition).append(endPartition);" + NL;
  protected final String TEXT_467 = NL + "    String insertQuery_";
  protected final String TEXT_468 = " = \"INSERT INTO TABLE \"+tableName_";
  protected final String TEXT_469 = " + partitionSql.toString() + \" \"+select_query_";
  protected final String TEXT_470 = ";";
  protected final String TEXT_471 = NL + "    stmt_";
  protected final String TEXT_472 = ".execute(insertQuery_";
  protected final String TEXT_473 = ");";
  protected final String TEXT_474 = NL + "                bw_";
  protected final String TEXT_475 = ".write(insertQuery_";
  protected final String TEXT_476 = " + \";\");";
  protected final String TEXT_477 = NL + "    String overwriteQuery_";
  protected final String TEXT_478 = " = \"INSERT OVERWRITE TABLE \"+tableName_";
  protected final String TEXT_479 = "+ partitionSql.toString() + \" \"+select_query_";
  protected final String TEXT_480 = ";";
  protected final String TEXT_481 = NL + "    stmt_";
  protected final String TEXT_482 = ".execute(overwriteQuery_";
  protected final String TEXT_483 = ");" + NL;
  protected final String TEXT_484 = NL + "                bw_";
  protected final String TEXT_485 = ".write(overwriteQuery_";
  protected final String TEXT_486 = " + \";\");";
  protected final String TEXT_487 = NL + "stmt_";
  protected final String TEXT_488 = ".close();" + NL;
  protected final String TEXT_489 = NL + "    if(conn_";
  protected final String TEXT_490 = " != null && !conn_";
  protected final String TEXT_491 = ".isClosed()) {" + NL + "        conn_";
  protected final String TEXT_492 = " .close();" + NL + "    }";
  protected final String TEXT_493 = NL + NL + "String currentClientPathSeparator_";
  protected final String TEXT_494 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "if(currentClientPathSeparator_";
  protected final String TEXT_495 = "!=null) {" + NL + "    System.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_496 = ");" + NL + "    globalMap.put(\"current_client_path_separator\", null);" + NL + "}" + NL + "" + NL + "String currentClientUsername_";
  protected final String TEXT_497 = " = (String)globalMap.get(\"current_client_user_name\");" + NL + "if(currentClientUsername_";
  protected final String TEXT_498 = "!=null) {" + NL + "    System.setProperty(\"user.name\", currentClientUsername_";
  protected final String TEXT_499 = ");" + NL + "    globalMap.put(\"current_client_user_name\", null);" + NL + "}" + NL + "" + NL + "String originalHadoopUsername_";
  protected final String TEXT_500 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_501 = "\");" + NL + "if(originalHadoopUsername_";
  protected final String TEXT_502 = "!=null) {" + NL + "    System.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_503 = ");" + NL + "    globalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_504 = "\", null);" + NL + "} else {" + NL + "    System.clearProperty(\"HADOOP_USER_NAME\");" + NL + "}";
  protected final String TEXT_505 = NL + "        bw_";
  protected final String TEXT_506 = ".close();" + NL + "" + NL + "        if(libjars_";
  protected final String TEXT_507 = ".length() > 0) {" + NL + "            instance_";
  protected final String TEXT_508 = ".setLibJars(libjars_";
  protected final String TEXT_509 = ".toString().substring(0, libjars_";
  protected final String TEXT_510 = ".length()-1));" + NL + "        }" + NL + "" + NL + "        instance_";
  protected final String TEXT_511 = ".sendFiles();" + NL + "        instance_";
  protected final String TEXT_512 = ".callWS(null, true);" + NL + "        int exitCode_";
  protected final String TEXT_513 = " = instance_";
  protected final String TEXT_514 = ".execute();" + NL + "        if(exitCode_";
  protected final String TEXT_515 = " > 0) {" + NL + "            throw new Exception(\"The Hive job failed. Please read the logs for more details\");" + NL + "        }";
  protected final String TEXT_516 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();
    String processId = node.getProcess().getId();

    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    String dbtable = null;
    String uniqueNameConnection = null;
    INode previousNode = null;
    boolean isExecutedThroughWebHCat = false;
    boolean setFsDefaultName=false;
    String connectionMode = "";
    String fsDefaultName = "";

    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
    List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();
    if(connections != null && connections.size() > 0 && connections.get(0) != null) {
        IConnection connection = connections.get(0);
        previousNode = connection.getSource();
        String previousComponentName = previousNode.getUniqueName();
        dbtable = connection.getName();
        uniqueNameConnection = connection.getUniqueName();

        
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(previousComponentName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(uniqueNameConnection);
    stringBuffer.append(TEXT_8);
    
    }

    String differenttable = ElementParameterParser.getValue(node, "__DIFFERENT_TABLE_NAME__");
    boolean useDifferentTable = "true".equals(ElementParameterParser.getValue(node, "__USE_DIFFERENT_TABLE__"));

       String dbschema = ElementParameterParser.getValue(node,"__ELT_SCHEMA_NAME__");
    
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(useDifferentTable? differenttable:"\""+dbtable +"\"");
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(useDifferentTable? differenttable:"\""+dbtable +"\"");
    stringBuffer.append(TEXT_18);
    

    String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");

    List<Map<String, String>> fieldPartitions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FIELD_PARTITION__");

    String dbhost = null;
    String dbport = null;
    String dbname = null;
    String dbuser = null;
    String hiveVersion = null;
    String distribution = null;

    //hbase settings
       String storeByHBase = null;
    String zookeeperQuorumForHBase = null;
    String zookeeperClientPortForHBase = null;

    boolean setZNodeParent = false;
    String zNodeParent = null;

    String sslTrustStore = null;

    boolean useSsl = false;
    String additionalJdbcSettings = "";

    String defineRegisterJar = null;
    List<Map<String, String>> registerJarForHBase = null;

    if(previousNode != null) {
        dbhost = ElementParameterParser.getValue(previousNode, "__HOST__");
        dbport = ElementParameterParser.getValue(previousNode, "__PORT__");
        dbname = ElementParameterParser.getValue(previousNode, "__DBNAME__");
        dbuser = ElementParameterParser.getValue(previousNode, "__USER__");
        hiveVersion = ElementParameterParser.getValue(previousNode, "__HIVE_VERSION__");
        distribution = ElementParameterParser.getValue(previousNode, "__DISTRIBUTION__");

        additionalJdbcSettings = ElementParameterParser.getValue(previousNode, "__HIVE_ADDITIONAL_JDBC__");
        useSsl = "true".equals(ElementParameterParser.getValue(previousNode, "__USE_SSL__"));
        sslTrustStore = ElementParameterParser.getValue(previousNode, "__SSL_TRUST_STORE__");


        storeByHBase = ElementParameterParser.getValue(previousNode, "__STORE_BY_HBASE__");
        zookeeperQuorumForHBase = ElementParameterParser.getValue(previousNode, "__ZOOKEEPER_QUORUM__");
        zookeeperClientPortForHBase = ElementParameterParser.getValue(previousNode, "__ZOOKEEPER_CLIENT_PORT__");

        setZNodeParent = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_ZNODE_PARENT__"));
        zNodeParent = ElementParameterParser.getValue(previousNode, "__ZNODE_PARENT__");

        defineRegisterJar = ElementParameterParser.getValue(previousNode, "__DEFINE_REGISTER_JAR__");
        registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(previousNode, "__REGISTER_JAR__");
        isExecutedThroughWebHCat = "MICROSOFT_HD_INSIGHT".equals(ElementParameterParser.getValue(previousNode, "__DISTRIBUTION__"));
        if("true".equals(ElementParameterParser.getValue(previousNode,"__USE_EXISTING_CONNECTION__"))) {
            isExecutedThroughWebHCat = false;
            String connection = ElementParameterParser.getValue(previousNode, "__CONNECTION__");
            for (INode pNode : previousNode.getProcess().getNodesOfType("tHiveConnection")) {
                if(connection!=null && connection.equals(pNode.getUniqueName())) {
                    isExecutedThroughWebHCat = "MICROSOFT_HD_INSIGHT".equals(ElementParameterParser.getValue(pNode, "__DISTRIBUTION__"));
    }
            }
        }
    }

    if(isExecutedThroughWebHCat) {
        INode nodeBackup = node;
        node = previousNode;

    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
	if("false".equals(useExistingConn)) {
		String passwordFieldName = "__HDINSIGHT_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_28);
    
		} else {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_31);
    
		}
			
		passwordFieldName = "__WASB_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_34);
    
		} else {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_37);
    
		}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_HOST__"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HDINSIGHT_USERNAME__"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_USERNAME__"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_HOST__"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_PORT__"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(ElementParameterParser.getValue(node, "__STATUSDIR__"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(ElementParameterParser.getValue(node, "__REMOTE_FOLDER__"));
    stringBuffer.append(TEXT_65);
    
	} else {
		String azureConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
	}

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
        node = nodeBackup;
        if("false".equals(useExistingConn)) { // This variable is declared and initialized in the GetAzureConnection.javajet
            boolean setMemory = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_MEMORY__"));
            if(setMemory) {
                String mapMemory = ElementParameterParser.getValue(previousNode,"__MAPREDUCE_MAP_MEMORY_MB__");
                String reduceMemory = ElementParameterParser.getValue(previousNode,"__MAPREDUCE_REDUCE_MEMORY_MB__");
                String amMemory = ElementParameterParser.getValue(previousNode,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_86);
    
            }

            List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(previousNode, "__ADVANCED_PROPERTIES__");
            if(advProps!=null) {
                for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_90);
    
                }
            }

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
        }
    } else {
        boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(previousNode, "__USE_EXISTING_CONNECTION__"));

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
        connectionMode = ElementParameterParser.getValue(previousNode, "__CONNECTION_MODE__");
        setFsDefaultName = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_FS_DEFAULT_NAME__"));
        fsDefaultName = ElementParameterParser.getValue(previousNode, "__FS_DEFAULT_NAME__");

String yarnClasspathSeparator = ElementParameterParser.getValue(previousNode, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_101);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_102);
    

if(useExistingConn) {
     connectionMode = "";
     setFsDefaultName = false;
     fsDefaultName = "";
     dbuser = "";
     hiveVersion = "";
     distribution = "";
    String connection = ElementParameterParser.getValue(previousNode, "__CONNECTION__");
    for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
            if(connection!=null && connection.equals(pNode.getUniqueName())) {
                connectionMode = ElementParameterParser.getValue(pNode, "__CONNECTION_MODE__");
                setFsDefaultName = "true".equals(ElementParameterParser.getValue(pNode, "__SET_FS_DEFAULT_NAME__"));
                fsDefaultName = ElementParameterParser.getValue(pNode, "__FS_DEFAULT_NAME__");
                dbuser = ElementParameterParser.getValue(pNode, "__USER__");
                hiveVersion = ElementParameterParser.getValue(pNode, "__HIVE_VERSION__");
                distribution = ElementParameterParser.getValue(pNode, "__DISTRIBUTION__");
                break;
            }
     }

    String conn = "conn_" + connection;
    String db = "db_" + connection;
    String dbUser = "dbUser_" + connection;
    
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(db);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(dbUser);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    
} else {
        String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
        String hiveServer = ElementParameterParser.getValue(previousNode, "__HIVE_SERVER__");

        boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(previousNode, "__DISTRIBUTION__"));

        boolean useKrb = "true".equals(ElementParameterParser.getValue(previousNode, "__USE_KRB__"));
        boolean cdhCanBeSecured = ("Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_4".equals(hiveVersion) || "Cloudera_CDH5_1_MR1".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
        boolean pivotalCanBeSecured = ("PIVOTAL_HD_2_0".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
        boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "HDP_2_2".equals(hiveVersion) || cdhCanBeSecured || pivotalCanBeSecured));

        boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
        boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
        String hivePrincipal = ElementParameterParser.getValue(previousNode, "__HIVE_PRINCIPAL__");


        // force hive2
        if ((!isCustom)
                && (("Cloudera_CDH5_4".equals(hiveVersion))
                        || ("APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion)) || ("MAPR410".equals(hiveVersion)))) {
            hiveServer = "HIVE2";
        }

        if(hiveServer!=null && !"".equals(hiveServer.trim())
                && (isCustom
                        || "HDP_1_2".equals(hiveVersion)
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
                        || "APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion))) {
            hiveServer = hiveServer.toLowerCase();
            if ("hive2".equals(hiveServer)) {
                javaDbDriver = "org.apache.hive.jdbc.HiveDriver";
            }
        } else {
            hiveServer = "hive";
        }

        if(!isCustom && (("HDP_1_2".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
         || ("HDP_1_3".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer)) || ("HDP_2_0".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
          || ("HDP_2_1".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer)) || ("HDP_2_2".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer)) || ("EMR_4_0_0".equals(hiveVersion) && ("EMBEDDED".equals(connectionMode) || "HIVE".equalsIgnoreCase(hiveServer)))
           || ("APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion) && "EMBEDDED".equals(connectionMode)))) {

    stringBuffer.append(TEXT_123);
    
        }

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_126);
    
        String passwordFieldName = "__PASS__";
        
    stringBuffer.append(TEXT_127);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    if (ElementParameterParser.canEncrypt(previousNode, passwordFieldName)) {
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(previousNode, passwordFieldName));
    stringBuffer.append(TEXT_133);
    } else {
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append( ElementParameterParser.getValue(previousNode, passwordFieldName));
    stringBuffer.append(TEXT_136);
    }
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    
        boolean setHadoopUser = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_HADOOP_USER__"));
        if (setHadoopUser) {
            String hadoopUser = ElementParameterParser.getValue(previousNode, "__HADOOP_USER__");
            
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(hadoopUser);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    
        }
        
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    
        if("EMBEDDED".equals(connectionMode)) {

    stringBuffer.append(TEXT_148);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_152);
    
            if(isCustom || (!isCustom && ("HDP_1_2,HDP_1_3,HDP_2_0,HDP_2_1,HDP_2_2,Cloudera_CDH4,Cloudera_CDH4_YARN,Cloudera_CDH5,Cloudera_CDH5_1,Cloudera_CDH5_4,Cloudera_CDH5_1_MR1,PIVOTAL_HD_1_0_1,PIVOTAL_HD_2_0,EMR_4_0_0".contains(hiveVersion)))) {

    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    
            }
        } else {
            if(securedStandaloneHive2) {
                if(useSsl) {

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_164);
    
                } else {

    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_171);
    
                }
            } else {
                // Using SSL in non Secure Mode
                if(useSsl) {
                    String sslStorepasswordFieldName = "__SSL_TRUST_STORE_PASSWORD__";
                    if(previousNode != null) {
                        if (ElementParameterParser.canEncrypt(previousNode, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(previousNode, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_174);
    
                        } else {
    
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append( ElementParameterParser.getValue(previousNode, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_177);
    
                        }                       
                    }
                    else {

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
                            
                    }

    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    
                } else {                            

    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_193);
    
            }
        }

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(additionalJdbcSettings);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
        }

    stringBuffer.append(TEXT_203);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_204);
    
        if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    
        } else {

    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    
        }


    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    
        if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
            String mapMemory = ElementParameterParser.getValue(previousNode,"__MAPRED_JOB_MAP_MEMORY_MB__");
            String reduceMemory = ElementParameterParser.getValue(previousNode,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_220);
    
        }

        boolean isKerberosAvailableHadoop2 = !isCustom && ("HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "HDP_2_2".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_4".equals(hiveVersion) || "PIVOTAL_HD_2_0".equals(hiveVersion));
        boolean isHadoop2 = "PIVOTAL_HD_1_0_1".equals(hiveVersion) || "APACHE_2_4_0_EMR".equals(hiveVersion) || "APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion) || "EMR_4_0_0".equals(hiveVersion) || "MAPR401".equals(hiveVersion) || "MAPR410".equals(hiveVersion) ||  isKerberosAvailableHadoop2;

        boolean isKerberosAvailableHadoop1 = !isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH5_1_MR1".equals(hiveVersion));

        boolean useYarn = "true".equals(ElementParameterParser.getValue(previousNode, "__USE_YARN__"));

        if(securedEmbedded) {
            String namenodePrincipal = ElementParameterParser.getValue(previousNode, "__NAMENODE_PRINCIPAL__");

    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_223);
    
            if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
                String jobtrackerPrincipal = ElementParameterParser.getValue(previousNode, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(jobtrackerPrincipal);
    stringBuffer.append(TEXT_226);
    
            }
            if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
                String resourceManagerPrincipal = ElementParameterParser.getValue(previousNode, "__RESOURCEMANAGER_PRINCIPAL__");

    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_229);
    
            }

        }

        boolean setResourceManager = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_RESOURCE_MANAGER__"));

        if((isCustom && useYarn) || (!isCustom && isHadoop2)) {
            if(setResourceManager) {
                String resourceManager = ElementParameterParser.getValue(previousNode, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_233);
    
            }

            boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_JOBHISTORY_ADDRESS__"));
            if(setJobHistoryAddress) {
                String jobHistoryAddress = ElementParameterParser.getValue(previousNode,"__JOBHISTORY_ADDRESS__");
                
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_236);
    
            }

            boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_SCHEDULER_ADDRESS__"));
            if(setSchedulerAddress) {
                String schedulerAddress = ElementParameterParser.getValue(previousNode,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_239);
    
            }

            if(setFsDefaultName) {

    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_242);
    
            }

            if("EMBEDDED".equals(connectionMode)) {
                if(!isCustom && ("HDP_2_1".equals(hiveVersion) || "HDP_2_2".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_4".equals(hiveVersion) || "MAPR401".equals(hiveVersion) || "MAPR410".equals(hiveVersion) || "APACHE_2_4_0_EMR".equals(hiveVersion) || "APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion))) {

    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    
                }

                if("MAPR410".equals(hiveVersion)){

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    
                }

                if(!isCustom && "HDP_2_1".equals(hiveVersion)) {

    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    
                /**/
                } else if(!isCustom && "HDP_2_2".equals(hiveVersion)) {

    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    
				} else if(!isCustom && ("APACHE_2_4_0_EMR".equals(hiveVersion) || "APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion))) {
                    
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    
                } else {

    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    
                /**/
                }

                if ("true".equals(ElementParameterParser.getValue(previousNode, "__USE_DATANODE_HOSTNAME__"))) {
                    
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    
                }

                boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(previousNode, "__CROSS_PLATFORM_SUBMISSION__"));
                if(isCustom && useYarn && crossPlatformSubmission) {

    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    
                }
            }

            boolean setMemory = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_MEMORY__"));
            if(setMemory) {
                String mapMemory = ElementParameterParser.getValue(previousNode,"__MAPREDUCE_MAP_MEMORY_MB__");
                String reduceMemory = ElementParameterParser.getValue(previousNode,"__MAPREDUCE_REDUCE_MEMORY_MB__");
                String amMemory = ElementParameterParser.getValue(previousNode,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_267);
    
            }
        }

        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(previousNode, "__ADVANCED_PROPERTIES__");
        if(advProps!=null) {
            for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_270);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_271);
    
            }
        }

    stringBuffer.append(TEXT_272);
    
		boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
		if(!useExistingConnection){	
		
    stringBuffer.append(TEXT_273);
    stringBuffer.append(TEXT_274);
    
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
    	
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    
            if(advProps != null){
                for(Map<String, String> item : advProps){
                    if("\"tez.lib.uris\"".equals(item.get("PROPERTY"))){
                    
    stringBuffer.append(TEXT_277);
      
                    }
                }
            }
            boolean installTez = "INSTALL".equals(ElementParameterParser.getValue(node, "__TEZ_LIB__"));
            if(installTez){
                //prepare the folder
                
    stringBuffer.append(TEXT_278);
    
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
        
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
        hadoopVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));
        
        String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        isCustom = "CUSTOM".equals(distribution);
        
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_289);
    
        if(mrUseDatanodeHostname){
        
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_295);
     
    		}
    	}
        	
    	if(((hadoopVersion!=null && supportKrbVersionList.contains(hadoopVersion)) && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_298);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_299);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_301);
    
    		}
    	}
    	
    	if("MAPR".equals(distribution)){
    		String group = ElementParameterParser.getValue(node, "__GROUP__");
    		
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(group);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    
        }else{
        
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
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    
        }
    }
}

      
                (new GetFileSystem()).invoke(node, cid);
                String tezLibFolder = ElementParameterParser.getValue(node, "__TEZ_LIB_FOLDER__");
                boolean useDefaultTezLibFolder = "\"/tmp/{USERNAME}/talend_tez_libs/{custom|HIVE_VERSION}\"".equals(tezLibFolder);
                if(useDefaultTezLibFolder){
                
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(isCustom?"custom":hiveVersion);
    stringBuffer.append(TEXT_325);
    
                }else{
                
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(tezLibFolder);
    stringBuffer.append(TEXT_328);
    
                }
                
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    
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
                
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    if(changePathSeparator){
    stringBuffer.append(TEXT_334);
    }else{
    stringBuffer.append(TEXT_335);
    }
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    
                    for(String jarName : tezLibJarsName){
                    
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    
                    }
                    
    stringBuffer.append(TEXT_351);
    
            }else{
            
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TEZ_LIB_PATH__"));
    stringBuffer.append(TEXT_354);
    
            }
            //define the location of tez lib    
            
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__"));
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    
    	}
    }
}

    stringBuffer.append(TEXT_372);
    
        	(new PrepareTez()).invoke(previousNode, cid);
        }	
        
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    
        if("true".equalsIgnoreCase(storeByHBase) && !("EMBEDDED".equals(connectionMode) && "MAPR2".equals(hiveVersion))) {
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_390);
    }
    stringBuffer.append(TEXT_391);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_394);
    }
    stringBuffer.append(TEXT_395);
    if(setZNodeParent && zNodeParent!=null && !"".equals(zNodeParent) && !"\"\"".equals(zNodeParent)) {
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_398);
    }
    stringBuffer.append(TEXT_399);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
                for(Map<String, String> jar : registerJarForHBase){
                    String path = jar.get("JAR_PATH");
                    if(path == null || "".equals(path) || "\"\"".equals(path)) {
                        continue;
                    }
            
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_402);
    
                }
                }

    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    
            }
  }
 }

 List<IMetadataColumn> columnList = null;

 List<IMetadataTable> metadatas = node.getMetadataList();
 if(metadatas !=null && metadatas.size()>0){
     IMetadataTable metadata = metadatas.get(0);
     if(metadata != null){
         columnList = metadata.getListColumns();
     }
}

    // Register jars to handle the parquet format.
    boolean targetTableUsesParquetFormat = "true".equals(ElementParameterParser.getValue(node, "__TARGET_TABLE_IS_A_PARQUET_TABLE__"));

    java.util.List<String> hiveVersionList = new java.util.ArrayList<String>();

    hiveVersionList.add("Cloudera_CDH4");
    hiveVersionList.add("APACHE_1_0_0");
    hiveVersionList.add("MAPR2");
    hiveVersionList.add("PIVOTAL_HD_1_0_1");

    boolean isParquetSupported = "CUSTOM".equals(distribution) || !hiveVersionList.contains(hiveVersion);
    if(targetTableUsesParquetFormat && !isParquetSupported) {

    stringBuffer.append(TEXT_405);
    
    }

    boolean generateAddJarCodeForAll = targetTableUsesParquetFormat;

    if(targetTableUsesParquetFormat) {
        String compression = ElementParameterParser.getValue(node, "__PARQUET_COMPRESSION__");
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

            jarsToRegister.add("snappy-java");
            jarsToRegister.add("parquet-hive-bundle");

            for (int j = 0; j < commandLine.length; j++) {
                if(commandLine[j].contains("jar")) {
                    jars = java.util.Arrays.asList(commandLine[j].split(";"));
                    break;
                }
            }
        }
        if(jarsToRegister!=null && jars!=null) {
            if("EMBEDDED".equalsIgnoreCase(connectionMode) || isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    }
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    
            } else {
                generateAddJarCodeForAll = false;
                if(setFsDefaultName) {
                    generateAddJarCodeForAll = true;

    stringBuffer.append(TEXT_415);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    }
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    
                }
            }

            if(generateAddJarCodeForAll) {
                if(!isExecutedThroughWebHCat) { // Then we create a SQL statement to add the jars.

    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    
                }
                for(int i=0; i<jarsToRegister.size(); i++) {
                    String jarToRegister = jarsToRegister.get(i);
                    for(int j=0; j<jars.size(); j++) {
                        if(jars.get(j).contains(jarToRegister)) {
                            if(!isExecutedThroughWebHCat) { // Then we use the created SQL statement to add the jars.

    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_436);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    
                            } else {

    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_442);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_446);
    
                            }
                        }
                    }
                }
            }
        }

        if(!isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(compression);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    
        } else {

    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(compression);
    stringBuffer.append(TEXT_455);
    
        }
    }
        // End of parquet format handling.

    
    if(!isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_458);
    
    }

    stringBuffer.append(TEXT_459);
    
    //For Bug TDI-24105,support context variables
    if(fieldPartitions != null && !fieldPartitions.isEmpty()) {
        String columnName = null;
        String columnValue = null;
        int count = 0 ;

    stringBuffer.append(TEXT_460);
    
        for(Map<String, String> line : fieldPartitions ) {// search in the configuration table
             columnName = line.get("COLUMN_NAME");
             columnValue = line.get("COLUMN_VALUE");
            if (columnName!=null && !"".equals(columnName)) {
                count++;

    stringBuffer.append(TEXT_461);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_462);
    
                   if (columnValue!=null && !"".equals(columnValue)) {

    stringBuffer.append(TEXT_463);
    stringBuffer.append(columnValue);
    stringBuffer.append(TEXT_464);
    
                }
                if(count < fieldPartitions.size()){

    stringBuffer.append(TEXT_465);
    
                }
            }
        }
    }

    stringBuffer.append(TEXT_466);
    

if(columnList != null && columnList.size()>0){
    if(("INSERT").equals(dataAction)){

    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_470);
    
            if(!isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_473);
    
            } else {

    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_476);
    
            }

    
    }else if (("OVERWRITE").equals(dataAction)){

    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_480);
    
            if(!isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_483);
    
            } else {

    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_486);
    
            }
    }
}

// END

    boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(previousNode, "__USE_EXISTING_CONNECTION__"));

    if(!isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_488);
    
if(!useExistingConn) {
    
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    
}

    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
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
    
    } else {

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    
    }

    stringBuffer.append(TEXT_516);
    return stringBuffer.toString();
  }
}
