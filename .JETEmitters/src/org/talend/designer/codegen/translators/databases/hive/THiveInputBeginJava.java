package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;
import java.util.List;
import java.util.Map;

public class THiveInputBeginJava
{
  protected static String nl;
  public static synchronized THiveInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveInputBeginJava result = new THiveInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
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
  protected final String TEXT_71 = NL + "            java.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_72 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "            if (null != dataSources_";
  protected final String TEXT_73 = ") {";
  protected final String TEXT_74 = NL + "                conn_";
  protected final String TEXT_75 = " = dataSources_";
  protected final String TEXT_76 = ".get(";
  protected final String TEXT_77 = ").getConnection();" + NL + "            } else {";
  protected final String TEXT_78 = NL + "\t\t\t\tString driverClass_";
  protected final String TEXT_79 = " = \"";
  protected final String TEXT_80 = "\";" + NL + "\t\t\t    java.lang.Class.forName(driverClass_";
  protected final String TEXT_81 = ");" + NL + "\t\t\t   \tString dbUser_";
  protected final String TEXT_82 = " = ";
  protected final String TEXT_83 = ";" + NL + "\t\t\t   \t" + NL + "        \t\t";
  protected final String TEXT_84 = NL + "        \t\t" + NL + "        \t\t";
  protected final String TEXT_85 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_86 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_89 = " = ";
  protected final String TEXT_90 = "; ";
  protected final String TEXT_91 = NL + "\t\t\t   \t" + NL + "\t\t        String dbPwd_";
  protected final String TEXT_92 = " = decryptedPassword_";
  protected final String TEXT_93 = ";" + NL + "\t\t        " + NL + "\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\tconn_";
  protected final String TEXT_96 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_97 = ",dbUser_";
  protected final String TEXT_98 = ",dbPwd_";
  protected final String TEXT_99 = ");";
  protected final String TEXT_100 = NL + "\t\t\t\tconn_";
  protected final String TEXT_101 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "\t\t        ";
  protected final String TEXT_104 = NL + "\t\t    }";
  protected final String TEXT_105 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_106 = " = conn_";
  protected final String TEXT_107 = ".createStatement();";
  protected final String TEXT_108 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_109 = " = conn_";
  protected final String TEXT_110 = ".createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tjava.sql.ResultSet.CONCUR_READ_ONLY);" + NL + "\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\t\ttmpContent_";
  protected final String TEXT_112 = " = rs_";
  protected final String TEXT_113 = ".getString(";
  protected final String TEXT_114 = "column_index_";
  protected final String TEXT_115 = ");";
  protected final String TEXT_116 = NL + "                        if(tmpContent_";
  protected final String TEXT_117 = " != null) {" + NL + "                            tmpContent_";
  protected final String TEXT_118 = " = tmpContent_";
  protected final String TEXT_119 = ";" + NL + "                        }";
  protected final String TEXT_120 = NL + "                    if(tmpContent_";
  protected final String TEXT_121 = " != null && tmpContent_";
  protected final String TEXT_122 = ".length() > 0) {\t\t\t  \t";
  protected final String TEXT_123 = NL + "                        ";
  protected final String TEXT_124 = ".";
  protected final String TEXT_125 = " = tmpContent_";
  protected final String TEXT_126 = ".charAt(0);\t\t\t  \t\t" + NL + "                    } else {\t\t\t  \t";
  protected final String TEXT_127 = "\t\t\t  \t    " + NL + "                            if(tmpContent_";
  protected final String TEXT_128 = " == null) {\t\t\t  \t   \t";
  protected final String TEXT_129 = NL + "                                ";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = " = null;\t\t\t  \t\t\t" + NL + "                            } else {\t\t\t  \t\t";
  protected final String TEXT_132 = NL + "                                ";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            }";
  protected final String TEXT_135 = "\t\t\t  \t\t" + NL + "                            if((\"\").equals(tmpContent_";
  protected final String TEXT_136 = ")) {\t\t\t  \t\t";
  protected final String TEXT_137 = NL + "                                ";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            } else {" + NL + "        \t\t\t  \t\t\tthrow new RuntimeException(" + NL + "        \t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_140 = "' in '";
  protected final String TEXT_141 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t" + NL + "                            }\t\t\t  \t\t";
  protected final String TEXT_142 = NL + "                    }";
  protected final String TEXT_143 = NL + "\t\t\tif(rs_";
  protected final String TEXT_144 = ".getTimestamp(";
  protected final String TEXT_145 = "column_index_";
  protected final String TEXT_146 = ") != null) {" + NL + "\t\t\t    ";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = " = new java.util.Date(rs_";
  protected final String TEXT_149 = ".getTimestamp(";
  protected final String TEXT_150 = "column_index_";
  protected final String TEXT_151 = ").getTime());" + NL + "\t\t\t} else {" + NL + "\t\t\t    ";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = " =  null;" + NL + "\t\t\t}\t\t\t ";
  protected final String TEXT_154 = NL + "            tmpContent_";
  protected final String TEXT_155 = " = rs_";
  protected final String TEXT_156 = ".getString(";
  protected final String TEXT_157 = "column_index_";
  protected final String TEXT_158 = ");" + NL + "            if(tmpContent_";
  protected final String TEXT_159 = " != null) {";
  protected final String TEXT_160 = NL + "                ";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = " = tmpContent_";
  protected final String TEXT_163 = ";" + NL + "            } else {";
  protected final String TEXT_164 = NL + "                ";
  protected final String TEXT_165 = ".";
  protected final String TEXT_166 = " = null;" + NL + "            }";
  protected final String TEXT_167 = NL + "            if(rs_";
  protected final String TEXT_168 = ".getObject(";
  protected final String TEXT_169 = "column_index_";
  protected final String TEXT_170 = ") != null) {";
  protected final String TEXT_171 = NL + "                ";
  protected final String TEXT_172 = ".";
  protected final String TEXT_173 = " = rs_";
  protected final String TEXT_174 = ".get";
  protected final String TEXT_175 = "(";
  protected final String TEXT_176 = "column_index_";
  protected final String TEXT_177 = ");" + NL + "            } else {";
  protected final String TEXT_178 = NL + "                    ";
  protected final String TEXT_179 = ".";
  protected final String TEXT_180 = " = null;";
  protected final String TEXT_181 = NL + "                    throw new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_182 = NL + "            }";
  protected final String TEXT_183 = NL + NL + "\t";
  protected final String TEXT_184 = NL + "\t\t\tString dbname_";
  protected final String TEXT_185 = " = (String)globalMap.get(\"";
  protected final String TEXT_186 = "\");" + NL + "        \tif(dbname_";
  protected final String TEXT_187 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_188 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_189 = ".trim())) {" + NL + "            \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_190 = " = conn_";
  protected final String TEXT_191 = ".createStatement();" + NL + "            \tgoToDatabase_";
  protected final String TEXT_192 = ".execute(\"use \" + dbname_";
  protected final String TEXT_193 = ");" + NL + "            \tgoToDatabase_";
  protected final String TEXT_194 = ".close();" + NL + "        \t}" + NL + "" + NL + "        \tString dbUser_";
  protected final String TEXT_195 = " = (String)globalMap.get(\"";
  protected final String TEXT_196 = "\");" + NL + "        \tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_197 = "\", System.getProperty(\"HADOOP_USER_NAME\"));" + NL + "    \t\tif(dbUser_";
  protected final String TEXT_198 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_199 = ".trim())) {" + NL + "    \t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_200 = ");" + NL + "    \t\t\t//make relative file path work for hive" + NL + "    \t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "    \t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_201 = ");" + NL + "    \t\t}";
  protected final String TEXT_202 = NL + "\t\t\tjava.sql.Statement init_";
  protected final String TEXT_203 = " = conn_";
  protected final String TEXT_204 = ".createStatement();";
  protected final String TEXT_205 = NL + "\t        \tinit_";
  protected final String TEXT_206 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_207 = ");" + NL + "\t\t    \tinit_";
  protected final String TEXT_208 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_209 = ");";
  protected final String TEXT_210 = NL + "\t\t\tinit_";
  protected final String TEXT_211 = ".execute(\"SET dfs.namenode.kerberos.principal=\" + ";
  protected final String TEXT_212 = ");";
  protected final String TEXT_213 = NL + "\t\t\t\tinit_";
  protected final String TEXT_214 = ".execute(\"SET mapreduce.jobtracker.kerberos.principal=\" + ";
  protected final String TEXT_215 = ");";
  protected final String TEXT_216 = NL + "\t\t\t\tinit_";
  protected final String TEXT_217 = ".execute(\"SET yarn.resourcemanager.principal=\" + ";
  protected final String TEXT_218 = ");";
  protected final String TEXT_219 = NL + "            \t\tinit_";
  protected final String TEXT_220 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "            \t\tinit_";
  protected final String TEXT_221 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_222 = ");";
  protected final String TEXT_223 = NL + "        \t\t\tinit_";
  protected final String TEXT_224 = ".execute(\"SET mapreduce.jobhistory.address=\" + ";
  protected final String TEXT_225 = ");" + NL + "        \t\t\t";
  protected final String TEXT_226 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_227 = ".execute(\"SET yarn.resourcemanager.scheduler.address=\" + ";
  protected final String TEXT_228 = ");";
  protected final String TEXT_229 = NL + "\t                init_";
  protected final String TEXT_230 = ".execute(\"SET dfs.client.use.datanode.hostname=true\");" + NL + "\t                init_";
  protected final String TEXT_231 = ".execute(\"SET dfs.datanode.use.datanode.hostname=true\");" + NL + "\t                ";
  protected final String TEXT_232 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_233 = ".execute(\"SET fs.default.name=\" + ";
  protected final String TEXT_234 = ");";
  protected final String TEXT_235 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_236 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_237 = NL + "\t\t\t\t\t\tinit_";
  protected final String TEXT_238 = ".execute(\"SET mapreduce.job.map.output.collector.class=org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "\t\t\t\t\t\tinit_";
  protected final String TEXT_239 = ".execute(\"SET mapreduce.job.reduce.shuffle.consumer.plugin.class=org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_240 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_241 = ".execute(\"SET yarn.application.classpath=/etc/hadoop/conf,/usr/lib/hadoop/*,/usr/lib/hadoop/lib/*,/usr/lib/hadoop-hdfs/*,/usr/lib/hadoop-hdfs/lib/*,/usr/lib/hadoop-yarn/*,/usr/lib/hadoop-yarn/lib/*,/usr/lib/hadoop-mapreduce/*,/usr/lib/hadoop-mapreduce/lib/*\");";
  protected final String TEXT_242 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_243 = ".execute(\"SET mapreduce.application.classpath=$PWD/mr-framework/hadoop/share/hadoop/mapreduce/*:$PWD/mr-framework/hadoop/share/hadoop/mapreduce/lib/*:$PWD/mr-framework/hadoop/share/hadoop/common/*:$PWD/mr-framework/hadoop/share/hadoop/common/lib/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/lib/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/lib/*:/etc/hadoop/conf/secure\");" + NL + "\t\t\t\t\tinit_";
  protected final String TEXT_244 = ".execute(\"SET yarn.application.classpath=$HADOOP_CONF_DIR,/usr/hdp/current/hadoop-client/*,/usr/hdp/current/hadoop-client/lib/*,/usr/hdp/current/hadoop-hdfs-client/*,/usr/hdp/current/hadoop-hdfs-client/lib/*,/usr/hdp/current/hadoop-mapreduce-client/*,/usr/hdp/current/hadoop-mapreduce-client/lib/*,/usr/hdp/current/hadoop-yarn-client/*,/usr/hdp/current/hadoop-yarn-client/lib/*\");";
  protected final String TEXT_245 = NL + "            \t\t//set default yarn classpath with environment variable" + NL + "                    init_";
  protected final String TEXT_246 = ".execute(\"SET yarn.application.classpath=$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*\");";
  protected final String TEXT_247 = NL + "    \t\t\t\tinit_";
  protected final String TEXT_248 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_249 = NL + "        \t\t\tinit_";
  protected final String TEXT_250 = ".execute(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_251 = ");" + NL + "        \t\t\tinit_";
  protected final String TEXT_252 = ".execute(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_253 = ");" + NL + "        \t\t\tinit_";
  protected final String TEXT_254 = ".execute(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_255 = ");";
  protected final String TEXT_256 = NL + "\t\t\t\t\tinit_";
  protected final String TEXT_257 = ".execute(\"SET \"+";
  protected final String TEXT_258 = "+\"=\"+";
  protected final String TEXT_259 = ");";
  protected final String TEXT_260 = NL + "\t\t\t";
  protected final String TEXT_261 = NL + "            \t";
  protected final String TEXT_262 = NL;
  protected final String TEXT_263 = NL + "    \t\tinit_";
  protected final String TEXT_264 = ".execute(\"SET hive.execution.engine=tez\");";
  protected final String TEXT_265 = NL + "                        System.err.println(\"Please set the path of Tez lib in 'Tez lib path'!\");";
  protected final String TEXT_266 = NL;
  protected final String TEXT_267 = NL + "        String username_";
  protected final String TEXT_268 = " = (";
  protected final String TEXT_269 = " != null && !\"\".equals(";
  protected final String TEXT_270 = ")) ? ";
  protected final String TEXT_271 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_272 = " = null;";
  protected final String TEXT_273 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_274 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_275 = ".set(\"";
  protected final String TEXT_276 = "\", ";
  protected final String TEXT_277 = ");" + NL + "        ";
  protected final String TEXT_278 = NL + "            conf_";
  protected final String TEXT_279 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_280 = NL + "        \t\tconf_";
  protected final String TEXT_281 = ".set(";
  protected final String TEXT_282 = " ,";
  protected final String TEXT_283 = ");" + NL + "        \t";
  protected final String TEXT_284 = NL + "    \t\tconf_";
  protected final String TEXT_285 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_286 = ");" + NL + "    \t\t";
  protected final String TEXT_287 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_288 = ", ";
  protected final String TEXT_289 = ");" + NL + "    \t\t";
  protected final String TEXT_290 = NL + "\t\t\tconf_";
  protected final String TEXT_291 = ".set(\"hadoop.job.ugi\",username_";
  protected final String TEXT_292 = "+\",\"+";
  protected final String TEXT_293 = ");" + NL + "        \tfs_";
  protected final String TEXT_294 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_295 = ");";
  protected final String TEXT_296 = NL + "        \t" + NL + "        \tif(username_";
  protected final String TEXT_297 = " == null || \"\".equals(username_";
  protected final String TEXT_298 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_299 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_300 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_301 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_302 = ".get(\"";
  protected final String TEXT_303 = "\")),conf_";
  protected final String TEXT_304 = ",username_";
  protected final String TEXT_305 = ");" + NL + "        \t}\t";
  protected final String TEXT_306 = NL + "                    String hdfsUserName_";
  protected final String TEXT_307 = " = (";
  protected final String TEXT_308 = " != null && !\"\".equals(";
  protected final String TEXT_309 = ")) ? ";
  protected final String TEXT_310 = " : System.getProperty(\"user.name\");" + NL + "                    String tezLibPath_";
  protected final String TEXT_311 = " = \"/tmp/\" + hdfsUserName_";
  protected final String TEXT_312 = " + \"/talend_tez_libs/";
  protected final String TEXT_313 = "\";";
  protected final String TEXT_314 = NL + "                    String tezLibPath_";
  protected final String TEXT_315 = " = ";
  protected final String TEXT_316 = ";";
  protected final String TEXT_317 = NL + "                fs_";
  protected final String TEXT_318 = ".mkdirs(new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_319 = "));";
  protected final String TEXT_320 = NL + "                String[] classPaths_";
  protected final String TEXT_321 = " = System.getProperty(\"java.class.path\").split(";
  protected final String TEXT_322 = "String.valueOf(globalMap.get(\"current_client_path_separator\"))";
  protected final String TEXT_323 = "System.getProperty(\"path.separator\")";
  protected final String TEXT_324 = ");" + NL + "                String tezLibLocalPath_";
  protected final String TEXT_325 = " = null;" + NL + "                for(String classPath_";
  protected final String TEXT_326 = " : classPaths_";
  protected final String TEXT_327 = "){";
  protected final String TEXT_328 = NL + "                        if(classPath_";
  protected final String TEXT_329 = ".endsWith(\"";
  protected final String TEXT_330 = "\")){" + NL + "                            org.apache.hadoop.fs.Path tezJarPath_";
  protected final String TEXT_331 = " = new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_332 = " + \"/";
  protected final String TEXT_333 = "\");" + NL + "                            if(!fs_";
  protected final String TEXT_334 = ".exists(tezJarPath_";
  protected final String TEXT_335 = ")){" + NL + "                                fs_";
  protected final String TEXT_336 = ".copyFromLocalFile(false, false, new org.apache.hadoop.fs.Path(classPath_";
  protected final String TEXT_337 = "), tezJarPath_";
  protected final String TEXT_338 = ");" + NL + "                            }" + NL + "                        }";
  protected final String TEXT_339 = NL + "                }";
  protected final String TEXT_340 = NL + "                String tezLibPath_";
  protected final String TEXT_341 = " = ";
  protected final String TEXT_342 = ";";
  protected final String TEXT_343 = NL + "\t\t\tStringBuilder script_";
  protected final String TEXT_344 = " = new StringBuilder();" + NL + "\t\t\tString[] tezLibPaths_";
  protected final String TEXT_345 = " = tezLibPath_";
  protected final String TEXT_346 = ".split(\",\");" + NL + "\t\t\tscript_";
  protected final String TEXT_347 = ".append(\"SET tez.lib.uris=\");" + NL + "\t\t\tint tezLibPathCount_";
  protected final String TEXT_348 = " = 1;" + NL + "\t\t\tfor(String tezLibPathKey_";
  protected final String TEXT_349 = " : tezLibPaths_";
  protected final String TEXT_350 = "){" + NL + "\t\t\t\t script_";
  protected final String TEXT_351 = ".append(";
  protected final String TEXT_352 = " + \"/\" + tezLibPathKey_";
  protected final String TEXT_353 = ");" + NL + "\t\t\t\t if(tezLibPathCount_";
  protected final String TEXT_354 = " < tezLibPaths_";
  protected final String TEXT_355 = ".length){" + NL + "\t\t\t\t \tscript_";
  protected final String TEXT_356 = ".append(\",\");" + NL + "\t\t\t\t }" + NL + "\t\t\t\t tezLibPathCount_";
  protected final String TEXT_357 = "++;" + NL + "\t\t\t}" + NL + "\t\t\tinit_";
  protected final String TEXT_358 = ".execute(script_";
  protected final String TEXT_359 = ".toString());" + NL + "\t\t";
  protected final String TEXT_360 = NL + "            \t";
  protected final String TEXT_361 = NL + "            " + NL + "\t\t\tinit_";
  protected final String TEXT_362 = ".close();" + NL + "" + NL + "        \tString dbname_";
  protected final String TEXT_363 = " = ";
  protected final String TEXT_364 = ";" + NL + "        \tif(dbname_";
  protected final String TEXT_365 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_366 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_367 = ".trim())) {" + NL + "            \tjava.sql.Statement goToDatabase_";
  protected final String TEXT_368 = " = conn_";
  protected final String TEXT_369 = ".createStatement();" + NL + "            \tgoToDatabase_";
  protected final String TEXT_370 = ".execute(\"use \" + dbname_";
  protected final String TEXT_371 = ");" + NL + "            \tgoToDatabase_";
  protected final String TEXT_372 = ".close();" + NL + "        \t}";
  protected final String TEXT_373 = NL + "    \t\t\tjava.sql.Statement statement_";
  protected final String TEXT_374 = " = conn_";
  protected final String TEXT_375 = ".createStatement();" + NL + "        \t\t";
  protected final String TEXT_376 = NL + "        \t\t\tstatement_";
  protected final String TEXT_377 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_378 = ");" + NL + "        \t\t";
  protected final String TEXT_379 = NL + NL + "        \t\t";
  protected final String TEXT_380 = NL + "        \t\t\tstatement_";
  protected final String TEXT_381 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_382 = ");" + NL + "        \t\t";
  protected final String TEXT_383 = NL + NL + "\t\t\t\t";
  protected final String TEXT_384 = NL + "\t\t\t\t\tstatement_";
  protected final String TEXT_385 = ".execute(\"SET zookeeper.znode.parent=\"+";
  protected final String TEXT_386 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_387 = NL + NL + "\t\t\t\t";
  protected final String TEXT_388 = NL + "\t\t\t\t\tstatement_";
  protected final String TEXT_389 = ".execute(\"SET hbase.security.authentication=kerberos\");" + NL + "\t\t\t\t\tstatement_";
  protected final String TEXT_390 = ".execute(\"SET hbase.rpc.engine=org.apache.hadoop.hbase.ipc.SecureRpcEngine\");" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_391 = NL + "\t\t\t\t\t\tstatement_";
  protected final String TEXT_392 = ".execute(\"SET hbase.master.kerberos.principal=\"+";
  protected final String TEXT_393 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_394 = NL + "\t\t\t\t\t";
  protected final String TEXT_395 = NL + "\t\t\t\t\t\tstatement_";
  protected final String TEXT_396 = ".execute(\"SET hbase.regionserver.kerberos.principal=\"+";
  protected final String TEXT_397 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_398 = NL + "\t\t\t\t";
  protected final String TEXT_399 = NL + NL + "        \t\t";
  protected final String TEXT_400 = NL + "    \t\t\t\tstatement_";
  protected final String TEXT_401 = ".execute(\"add jar \"+";
  protected final String TEXT_402 = ");" + NL + "        \t\t";
  protected final String TEXT_403 = NL + "    \t\t\tstatement_";
  protected final String TEXT_404 = ".close();";
  protected final String TEXT_405 = NL + "\t\t\t\tif(true) {" + NL + "\t\t\t\t\tthrow new Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "\t\t\t\t}";
  protected final String TEXT_406 = NL + "\t\t\t\tSystem.setProperty(";
  protected final String TEXT_407 = " ,";
  protected final String TEXT_408 = ");";
  protected final String TEXT_409 = NL + "\t\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_410 = ");";
  protected final String TEXT_411 = NL + "\t\t\t\tSystem.setProperty(\"";
  protected final String TEXT_412 = "\", ";
  protected final String TEXT_413 = ");";
  protected final String TEXT_414 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_415 = ");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_416 = NL + "                    System.setProperty(\"hive.security.authorization.enabled\", \"false\");";
  protected final String TEXT_417 = NL + "                    System.setProperty(\"hive.security.authorization.enabled\", \"true\");";
  protected final String TEXT_418 = NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_419 = ");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_420 = ");" + NL + "" + NL + "        \t\t";
  protected final String TEXT_421 = NL + NL + "        \t\t";
  protected final String TEXT_422 = NL + "            \tString decryptedMetastorePassword_";
  protected final String TEXT_423 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_424 = ");" + NL + "       \t\t \t";
  protected final String TEXT_425 = NL + "            \tString decryptedMetastorePassword_";
  protected final String TEXT_426 = " = ";
  protected final String TEXT_427 = ";" + NL + "    \t\t\t";
  protected final String TEXT_428 = NL + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", decryptedMetastorePassword_";
  protected final String TEXT_429 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_430 = ");";
  protected final String TEXT_431 = NL + "                \tSystem.setProperty(\"hive.server2.authentication.kerberos.principal\", ";
  protected final String TEXT_432 = ");" + NL + "               \t\tSystem.setProperty(\"hive.server2.authentication.kerberos.keytab\", ";
  protected final String TEXT_433 = ");";
  protected final String TEXT_434 = NL + "\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_435 = ", ";
  protected final String TEXT_436 = ");";
  protected final String TEXT_437 = NL + "\t            String username_";
  protected final String TEXT_438 = " = ";
  protected final String TEXT_439 = ";" + NL + "\t            if(username_";
  protected final String TEXT_440 = "!=null && !\"\".equals(username_";
  protected final String TEXT_441 = ".trim())) {" + NL + "\t                System.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_442 = ");" + NL + "\t            }" + NL + "\t            ";
  protected final String TEXT_443 = NL + "\t\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_444 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_445 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_446 = " + \":\" + ";
  protected final String TEXT_447 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\t\tString url_";
  protected final String TEXT_448 = " = \"jdbc:";
  protected final String TEXT_449 = "://\";";
  protected final String TEXT_450 = NL + "    \t\t\t\tif(dbUser_";
  protected final String TEXT_451 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_452 = ".trim())) {" + NL + "    \t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_453 = ");" + NL + "    \t\t\t\t\t//make relative file path work for hive" + NL + "    \t\t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "    \t\t\t\t\tSystem.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_454 = ");" + NL + "    \t\t\t\t}";
  protected final String TEXT_455 = NL + "\t\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_456 = ", ";
  protected final String TEXT_457 = ");";
  protected final String TEXT_458 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_459 = " = \"jdbc:";
  protected final String TEXT_460 = "://\" + ";
  protected final String TEXT_461 = " + \":\" + ";
  protected final String TEXT_462 = " + \"/\" + ";
  protected final String TEXT_463 = " + \";principal=\" + ";
  protected final String TEXT_464 = "+\";sasl.qop=auth-conf\";";
  protected final String TEXT_465 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_466 = " = \"jdbc:";
  protected final String TEXT_467 = "://\" + ";
  protected final String TEXT_468 = " + \":\" + ";
  protected final String TEXT_469 = " + \"/\" + ";
  protected final String TEXT_470 = " + \";principal=\" + ";
  protected final String TEXT_471 = ";";
  protected final String TEXT_472 = NL + "\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_473 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_474 = ");";
  protected final String TEXT_475 = NL + "\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_476 = " = ";
  protected final String TEXT_477 = "; ";
  protected final String TEXT_478 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_479 = " = \"jdbc:";
  protected final String TEXT_480 = "://\" + ";
  protected final String TEXT_481 = " + \":\" + ";
  protected final String TEXT_482 = " + \"/\" + ";
  protected final String TEXT_483 = "+ \";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_484 = " + \";trustStorePassword=\" + decryptedSslStorePassword_";
  protected final String TEXT_485 = ";";
  protected final String TEXT_486 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_487 = " = \"jdbc:";
  protected final String TEXT_488 = "://\" + ";
  protected final String TEXT_489 = " + \":\" + ";
  protected final String TEXT_490 = " + \"/\" + ";
  protected final String TEXT_491 = ";";
  protected final String TEXT_492 = NL + "\t\t\t\tString additionalJdbcSettings_";
  protected final String TEXT_493 = " = ";
  protected final String TEXT_494 = ";" + NL + "\t\t\t\tif(!\"\".equals(additionalJdbcSettings_";
  protected final String TEXT_495 = ".trim())) {" + NL + "\t\t\t\t\tif(!additionalJdbcSettings_";
  protected final String TEXT_496 = ".startsWith(\";\")) {" + NL + "\t\t\t\t\t\tadditionalJdbcSettings_";
  protected final String TEXT_497 = " = \";\" + additionalJdbcSettings_";
  protected final String TEXT_498 = ";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_499 = " += additionalJdbcSettings_";
  protected final String TEXT_500 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_501 = NL + "\t\t\t\tif(true) {" + NL + "\t\t\t\t\tthrow new java.lang.UnsupportedOperationException(\"Parquet is only supported if the distribution uses embedded Hive version 0.10 or later.\");" + NL + "\t\t\t\t}";
  protected final String TEXT_502 = NL + "\t\t\t\t\t";
  protected final String TEXT_503 = NL + "\t\tclass GetJarsToRegister_";
  protected final String TEXT_504 = " {" + NL + "\t\t\tprivate String oozieClasspathLine;" + NL + "\t\t\tprivate boolean isOozieRuntime;" + NL + "\t\t\t" + NL + "\t\t\tpublic GetJarsToRegister_";
  protected final String TEXT_505 = "() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tthis.isOozieRuntime = setJarsToRegister();" + NL + "\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t";
  protected final String TEXT_506 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_507 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_508 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean setJarsToRegister() throws IOException, org.dom4j.DocumentException {" + NL + "\t\t\t\tString jobXmlPath = new java.io.File(\"../../job.xml\").getCanonicalPath();" + NL + "\t\t\t\tboolean isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\tif(!isOozieExecution) {" + NL + "\t\t\t\t    jobXmlPath = new java.io.File(\"./job.xml\").getCanonicalPath();" + NL + "\t\t\t\t    isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(isOozieExecution) {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.dom4j.io.SAXReader reader_oozie = new org.dom4j.io.SAXReader();" + NL + "\t\t\t\t\torg.dom4j.Document document_oozie = reader_oozie.read(jobXmlPath);" + NL + "\t\t\t\t\tList list_oozie = document_oozie.selectNodes(\"/configuration/property\");" + NL + "\t\t\t\t\tfor (java.util.Iterator iter_oozie = list_oozie.iterator(); iter_oozie.hasNext();) {" + NL + "\t\t\t\t\t\torg.dom4j.Element element_oozie = (org.dom4j.Element) iter_oozie.next();" + NL + "\t\t\t\t\t\tString name_oozie = element_oozie.elementText(\"name\");" + NL + "\t\t\t\t\t\tif(name_oozie.equals(\"mapred.cache.localFiles\") || name_oozie.equals(\"mapreduce.job.cache.local.files\")) {" + NL + "\t\t\t\t\t\t\tthis.oozieClasspathLine = element_oozie.elementText(\"value\");" + NL + "\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\t\treturn replaceJarPaths(originalClassPathLine, \"\");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine, String scheme) throws Exception {" + NL + "\t\t\t\tString classPathLine = \"\";" + NL + "\t\t\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\t\t\t" + NL + "\t\t\t\tif (isNeedAddLibsPath(crcMapPath)) {" + NL + "\t\t\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\t\t\tois.close();" + NL + "\t\t\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t\t\t} else if(this.isOozieRuntime) {" + NL + "\t\t\t\t\tif(this.oozieClasspathLine!=null) {" + NL + "\t\t\t\t\t\tList<String> oozieJars = java.util.Arrays.asList(this.oozieClasspathLine.split(\",\"));" + NL + "\t\t\t\t\t\tfor(int j=0; j<oozieJars.size(); j++) {" + NL + "\t\t\t\t\t\t\tif(oozieJars.get(j).contains(originalClassPathLine.substring(originalClassPathLine.lastIndexOf(\"/\")))) {" + NL + "\t\t\t\t\t\t\t\tclassPathLine = oozieJars.get(j);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tif(originalClassPathLine!=null && originalClassPathLine.startsWith(\".\")) {" + NL + "\t\t\t\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tclassPathLine = scheme + originalClassPathLine;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn classPathLine;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\t\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\t\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\t\t\tString jarName = entry.getValue();" + NL + "\t\t\t\tString crc = entry.getKey();" + NL + "\t\t\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\t\t\tString libStringFinder2 = \"./\" + jarName; // for the job jar itself." + NL + "\t\t\t\t" + NL + "\t\t\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.toLowerCase().contains(libStringFinder2)) {" + NL + "\t\t\t\t\tline = line.toLowerCase().replace(libStringFinder2, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t}" + NL + "\t\t\t\t\tGetJarsToRegister_";
  protected final String TEXT_509 = " getJarsToRegister_";
  protected final String TEXT_510 = " = new GetJarsToRegister_";
  protected final String TEXT_511 = "();";
  protected final String TEXT_512 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_513 = NL + "\t";
  protected final String TEXT_514 = NL + "\t\tclass GetJarsToRegister_";
  protected final String TEXT_515 = " {" + NL + "\t\t\tprivate String oozieClasspathLine;" + NL + "\t\t\tprivate boolean isOozieRuntime;" + NL + "\t\t\t" + NL + "\t\t\tpublic GetJarsToRegister_";
  protected final String TEXT_516 = "() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tthis.isOozieRuntime = setJarsToRegister();" + NL + "\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t";
  protected final String TEXT_517 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_518 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_519 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean setJarsToRegister() throws IOException, org.dom4j.DocumentException {" + NL + "\t\t\t\tString jobXmlPath = new java.io.File(\"../../job.xml\").getCanonicalPath();" + NL + "\t\t\t\tboolean isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\tif(!isOozieExecution) {" + NL + "\t\t\t\t    jobXmlPath = new java.io.File(\"./job.xml\").getCanonicalPath();" + NL + "\t\t\t\t    isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(isOozieExecution) {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.dom4j.io.SAXReader reader_oozie = new org.dom4j.io.SAXReader();" + NL + "\t\t\t\t\torg.dom4j.Document document_oozie = reader_oozie.read(jobXmlPath);" + NL + "\t\t\t\t\tList list_oozie = document_oozie.selectNodes(\"/configuration/property\");" + NL + "\t\t\t\t\tfor (java.util.Iterator iter_oozie = list_oozie.iterator(); iter_oozie.hasNext();) {" + NL + "\t\t\t\t\t\torg.dom4j.Element element_oozie = (org.dom4j.Element) iter_oozie.next();" + NL + "\t\t\t\t\t\tString name_oozie = element_oozie.elementText(\"name\");" + NL + "\t\t\t\t\t\tif(name_oozie.equals(\"mapred.cache.localFiles\") || name_oozie.equals(\"mapreduce.job.cache.local.files\")) {" + NL + "\t\t\t\t\t\t\tthis.oozieClasspathLine = element_oozie.elementText(\"value\");" + NL + "\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\t\treturn replaceJarPaths(originalClassPathLine, \"\");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine, String scheme) throws Exception {" + NL + "\t\t\t\tString classPathLine = \"\";" + NL + "\t\t\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\t\t\t" + NL + "\t\t\t\tif (isNeedAddLibsPath(crcMapPath)) {" + NL + "\t\t\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\t\t\tois.close();" + NL + "\t\t\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t\t\t} else if(this.isOozieRuntime) {" + NL + "\t\t\t\t\tif(this.oozieClasspathLine!=null) {" + NL + "\t\t\t\t\t\tList<String> oozieJars = java.util.Arrays.asList(this.oozieClasspathLine.split(\",\"));" + NL + "\t\t\t\t\t\tfor(int j=0; j<oozieJars.size(); j++) {" + NL + "\t\t\t\t\t\t\tif(oozieJars.get(j).contains(originalClassPathLine.substring(originalClassPathLine.lastIndexOf(\"/\")))) {" + NL + "\t\t\t\t\t\t\t\tclassPathLine = oozieJars.get(j);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tif(originalClassPathLine!=null && originalClassPathLine.startsWith(\".\")) {" + NL + "\t\t\t\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tclassPathLine = scheme + originalClassPathLine;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn classPathLine;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\t\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\t\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\t\t\tString jarName = entry.getValue();" + NL + "\t\t\t\tString crc = entry.getKey();" + NL + "\t\t\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\t\t\tString libStringFinder2 = \"./\" + jarName; // for the job jar itself." + NL + "\t\t\t\t" + NL + "\t\t\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.toLowerCase().contains(libStringFinder2)) {" + NL + "\t\t\t\t\tline = line.toLowerCase().replace(libStringFinder2, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t}" + NL + "\t\t\t\t" + NL + "\tclass GetHiveJarsToRegister_";
  protected final String TEXT_520 = " extends GetJarsToRegister_";
  protected final String TEXT_521 = " {" + NL + "\t\t" + NL + "\t\tprivate String uploadJarToHDFS(String jar) throws Exception {" + NL + "\t\t\torg.apache.hadoop.fs.FileSystem fs = null;" + NL + "\t\t\torg.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();" + NL + "\t\t\tconf.set(\"fs.default.name\", ";
  protected final String TEXT_522 = ");" + NL + "\t\t\tString username = ";
  protected final String TEXT_523 = ";" + NL + "\t\t\tif (username == null\t|| \"\".equals(username)) {" + NL + "\t\t\t\tfs = org.apache.hadoop.fs.FileSystem.get(conf);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tfs = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf.get(\"fs.default.name\")), conf, username);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tfs.mkdirs(new org.apache.hadoop.fs.Path(\"/user/\" + username + \"/tmp\"), new org.apache.hadoop.fs.permission.FsPermission(org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL));" + NL + "\t\t\tfs.copyFromLocalFile(false, true, new org.apache.hadoop.fs.Path(jar), new org.apache.hadoop.fs.Path(\"/user/\" + username + \"/tmp\"));" + NL + "\t\t\t" + NL + "\t\t\treturn ";
  protected final String TEXT_524 = " + \"/user/\" + username + \"/tmp/\" + new java.io.File(jar).getName();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\tString classPathLine = super.replaceJarPaths(originalClassPathLine);" + NL + "\t\t\tString hdfsPath = uploadJarToHDFS(classPathLine);" + NL + "\t\t\treturn hdfsPath;" + NL + "\t\t}" + NL + "\t}" + NL + "\t\t\t\t\t\tGetHiveJarsToRegister_";
  protected final String TEXT_525 = " getJarsToRegister_";
  protected final String TEXT_526 = " = new GetHiveJarsToRegister_";
  protected final String TEXT_527 = "();";
  protected final String TEXT_528 = NL + "\t\t\t\t\tjava.sql.Statement addJar_";
  protected final String TEXT_529 = " = null;";
  protected final String TEXT_530 = NL + "\t\t\t\t\t\t\t\taddJar_";
  protected final String TEXT_531 = " = conn_";
  protected final String TEXT_532 = ".createStatement();" + NL + "\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\taddJar_";
  protected final String TEXT_533 = ".execute(\"add jar \" + getJarsToRegister_";
  protected final String TEXT_534 = ".replaceJarPaths(\"";
  protected final String TEXT_535 = "\"));" + NL + "\t\t\t\t\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\t\t\t\taddJar_";
  protected final String TEXT_536 = ".close();" + NL + "\t\t\t\t\t\t\t\t}";
  protected final String TEXT_537 = NL + "\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");";
  protected final String TEXT_538 = NL + "\t\tSystem.setProperty(\"java.io.tmpdir\", ";
  protected final String TEXT_539 = ");";
  protected final String TEXT_540 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_541 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_542 = NL + "\t\t    int nb_line_";
  protected final String TEXT_543 = " = 0;" + NL + "\t\t    java.sql.Connection conn_";
  protected final String TEXT_544 = " = null;";
  protected final String TEXT_545 = NL + "\t\t        conn_";
  protected final String TEXT_546 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_547 = "\");";
  protected final String TEXT_548 = NL + "\t\t        \tif (null == conn_";
  protected final String TEXT_549 = ") {" + NL + "\t\t\t\t\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_550 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\t\t\t\t\tconn_";
  protected final String TEXT_551 = " = dataSources_";
  protected final String TEXT_552 = ".get(";
  protected final String TEXT_553 = ").getConnection();" + NL + "\t\t\t\t\t\t//globalMap.put(\"";
  protected final String TEXT_554 = "\", conn_";
  protected final String TEXT_555 = ");" + NL + "\t\t        \t}" + NL + "\t\t        ";
  protected final String TEXT_556 = NL + "\t\t\t\t";
  protected final String TEXT_557 = NL + "\t\t\t\t";
  protected final String TEXT_558 = NL + "             boolean currentAutoCommitMode";
  protected final String TEXT_559 = " =  conn_";
  protected final String TEXT_560 = ".getAutoCommit();" + NL + "             conn_";
  protected final String TEXT_561 = ".setAutoCommit(true);" + NL + "             try{";
  protected final String TEXT_562 = NL + "                           try{" + NL + "                               conn_";
  protected final String TEXT_563 = ".createStatement().execute(\"BEGIN QUERY LOGGING WITH SQL,OBJECTS ON \" + ";
  protected final String TEXT_564 = ");" + NL + "                           }catch(Exception e){" + NL + "                                 System.err.println(e.getMessage());" + NL + "                           }";
  protected final String TEXT_565 = NL + "                 conn_";
  protected final String TEXT_566 = ".createStatement().execute(" + NL + "              \"SET QUERY_BAND='\" +";
  protected final String TEXT_567 = NL + "               ";
  protected final String TEXT_568 = " + \"=\" + ";
  protected final String TEXT_569 = " + \";\" +";
  protected final String TEXT_570 = " \"' FOR SESSION\"" + NL + "           );" + NL + "              }catch(Exception e){" + NL + "               System.err.println(e.getMessage());" + NL + "      }" + NL + "      conn_";
  protected final String TEXT_571 = ".setAutoCommit(currentAutoCommitMode";
  protected final String TEXT_572 = ");";
  protected final String TEXT_573 = NL + "\t\t    ";
  protected final String TEXT_574 = NL + NL + "\t\t    String dbquery_";
  protected final String TEXT_575 = " = ";
  protected final String TEXT_576 = ";" + NL + "\t\t\t";
  protected final String TEXT_577 = NL + "                log.info(\"";
  protected final String TEXT_578 = " - Executing the query: '\"+dbquery_";
  protected final String TEXT_579 = "+\"'.\");" + NL + "\t\t\t";
  protected final String TEXT_580 = NL;
  protected final String TEXT_581 = NL + "                       globalMap.put(\"";
  protected final String TEXT_582 = "_QUERY\",dbquery_";
  protected final String TEXT_583 = ");";
  protected final String TEXT_584 = NL + "                       globalMap.put(\"";
  protected final String TEXT_585 = "_QUERY\",dbquery_";
  protected final String TEXT_586 = ");";
  protected final String TEXT_587 = NL + NL + "\t\t    java.sql.ResultSet rs_";
  protected final String TEXT_588 = " = null;" + NL + "\t\ttry{" + NL + "\t\t    rs_";
  protected final String TEXT_589 = " = stmt_";
  protected final String TEXT_590 = ".executeQuery(dbquery_";
  protected final String TEXT_591 = ");" + NL + "\t\t    java.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_592 = " = rs_";
  protected final String TEXT_593 = ".getMetaData();" + NL + "\t\t    int colQtyInRs_";
  protected final String TEXT_594 = " = rsmd_";
  protected final String TEXT_595 = ".getColumnCount();" + NL;
  protected final String TEXT_596 = NL + "\t\t    routines.system.Dynamic dcg_";
  protected final String TEXT_597 = " =  new routines.system.Dynamic();" + NL + "\t\t    dcg_";
  protected final String TEXT_598 = ".setDbmsId(\"";
  protected final String TEXT_599 = "\");" + NL + "\t\t    List<String> listSchema_";
  protected final String TEXT_600 = "=new java.util.ArrayList<String>();" + NL + "\t\t    ";
  protected final String TEXT_601 = NL + "\t\t    \t    listSchema_";
  protected final String TEXT_602 = ".add(\"";
  protected final String TEXT_603 = "\");" + NL + "\t    \t    ";
  protected final String TEXT_604 = NL + NL + "\t\t\tint fixedColumnCount_";
  protected final String TEXT_605 = " = ";
  protected final String TEXT_606 = ";" + NL + "" + NL + "            for (int i = ";
  protected final String TEXT_607 = "; i <= rsmd_";
  protected final String TEXT_608 = ".getColumnCount()-";
  protected final String TEXT_609 = "; i++) {" + NL + "                if (!(listSchema_";
  protected final String TEXT_610 = ".contains(rsmd_";
  protected final String TEXT_611 = ".getColumnLabel(i).toUpperCase()) )) {" + NL + "                \troutines.system.DynamicMetadata dcm_";
  protected final String TEXT_612 = "=new routines.system.DynamicMetadata();" + NL + "                \tdcm_";
  protected final String TEXT_613 = ".setName(rsmd_";
  protected final String TEXT_614 = ".getColumnLabel(i));" + NL + "                \tdcm_";
  protected final String TEXT_615 = ".setDbName(rsmd_";
  protected final String TEXT_616 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_617 = ".setType(routines.system.Dynamic.getTalendTypeFromDBType(\"";
  protected final String TEXT_618 = "\", rsmd_";
  protected final String TEXT_619 = ".getColumnTypeName(i).toUpperCase(), rsmd_";
  protected final String TEXT_620 = ".getPrecision(i), rsmd_";
  protected final String TEXT_621 = ".getScale(i)));" + NL + "                \tdcm_";
  protected final String TEXT_622 = ".setDbType(rsmd_";
  protected final String TEXT_623 = ".getColumnTypeName(i));" + NL + "                \tdcm_";
  protected final String TEXT_624 = ".setDbTypeId(rsmd_";
  protected final String TEXT_625 = ".getColumnType(i));";
  protected final String TEXT_626 = NL + "                \tdcm_";
  protected final String TEXT_627 = ".setFormat(";
  protected final String TEXT_628 = ");";
  protected final String TEXT_629 = NL + "\t\t\tif(\"LONG\".equals(rsmd_";
  protected final String TEXT_630 = ".getColumnTypeName(i).toUpperCase())) {" + NL + "\t\t\t\tString length = MetadataTalendType.getDefaultDBTypes(\"oracle_id\", \"LONG\", MetadataTalendType.DEFAULT_LENGTH);" + NL + "\t\t\t\tif(length!=null && !(\"\".equals(length))) {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_631 = ".setLength(Integer.parseInt(length));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_632 = ".setLength(rsmd_";
  protected final String TEXT_633 = ".getPrecision(i));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdcm_";
  protected final String TEXT_634 = ".setLength(rsmd_";
  protected final String TEXT_635 = ".getPrecision(i));" + NL + "\t\t\t}";
  protected final String TEXT_636 = NL + "\t\t\tdcm_";
  protected final String TEXT_637 = ".setLength(rsmd_";
  protected final String TEXT_638 = ".getPrecision(i));";
  protected final String TEXT_639 = NL + "                \tdcm_";
  protected final String TEXT_640 = ".setPrecision(rsmd_";
  protected final String TEXT_641 = ".getScale(i));" + NL + "                \tdcm_";
  protected final String TEXT_642 = ".setNullable(rsmd_";
  protected final String TEXT_643 = ".isNullable(i) == 0 ? false : true);" + NL + "                \tdcm_";
  protected final String TEXT_644 = ".setKey(false);" + NL + "                \tdcm_";
  protected final String TEXT_645 = ".setSourceType(DynamicMetadata.sourceTypes.database);" + NL + "                \tdcm_";
  protected final String TEXT_646 = ".setColumnPosition(i);" + NL + "                \tdcg_";
  protected final String TEXT_647 = ".metadatas.add(dcm_";
  protected final String TEXT_648 = ");" + NL + "                }" + NL + "            }";
  protected final String TEXT_649 = NL + "\t\t    String tmpContent_";
  protected final String TEXT_650 = " = null;" + NL + "\t\t    ";
  protected final String TEXT_651 = NL + "\t\t    \tint column_index_";
  protected final String TEXT_652 = " =1;" + NL + "\t\t    ";
  protected final String TEXT_653 = NL + "\t\t    ";
  protected final String TEXT_654 = NL + "\t\t    \tlog.info(\"";
  protected final String TEXT_655 = " - Retrieving records from the database.\");" + NL + "\t\t    ";
  protected final String TEXT_656 = NL + "\t\t    while (rs_";
  protected final String TEXT_657 = ".next()) {" + NL + "\t\t        nb_line_";
  protected final String TEXT_658 = "++;" + NL + "\t\t        ";
  protected final String TEXT_659 = NL + "\t\t\t\t\t\t\t\t\tcolumn_index_";
  protected final String TEXT_660 = " = ";
  protected final String TEXT_661 = " + dcg_";
  protected final String TEXT_662 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_663 = NL + "\t\t\t\t\t\t\t\t\tcolumn_index_";
  protected final String TEXT_664 = " = ";
  protected final String TEXT_665 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_666 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_667 = NL + "\t\t\t\t\t\t\tif(colQtyInRs_";
  protected final String TEXT_668 = " < ";
  protected final String TEXT_669 = "column_index_";
  protected final String TEXT_670 = ") {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_671 = ".";
  protected final String TEXT_672 = " = ";
  protected final String TEXT_673 = ";" + NL + "\t\t\t\t\t\t\t} else {";
  protected final String TEXT_674 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_675 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_676 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_677 = NL + "\t\t                            ";
  protected final String TEXT_678 = ".";
  protected final String TEXT_679 = " = (List)rs_";
  protected final String TEXT_680 = ".getObject(";
  protected final String TEXT_681 = "column_index_";
  protected final String TEXT_682 = ");";
  protected final String TEXT_683 = NL + "\t\t                         ";
  protected final String TEXT_684 = NL + "                                    oracle.sql.STRUCT jGeomStruct = (oracle.sql.STRUCT) rs_";
  protected final String TEXT_685 = ".getObject(";
  protected final String TEXT_686 = "column_index_";
  protected final String TEXT_687 = ");" + NL + "                                    if (jGeomStruct != null) {" + NL + "                                    oracle.spatial.geometry.JGeometry jGeom = oracle.spatial.geometry.JGeometry.load(jGeomStruct);" + NL + "                                    oracle.spatial.util.WKT wkt = new oracle.spatial.util.WKT();" + NL + "                                    String wktValue = new String(wkt.fromJGeometry(jGeom));" + NL;
  protected final String TEXT_688 = NL + "                                    ";
  protected final String TEXT_689 = ".";
  protected final String TEXT_690 = " = new Geometry(wktValue);" + NL + "                                    } else {";
  protected final String TEXT_691 = NL + "                                      ";
  protected final String TEXT_692 = ".";
  protected final String TEXT_693 = " = null;" + NL + "                                    }";
  protected final String TEXT_694 = NL + "                                        if (";
  protected final String TEXT_695 = ".";
  protected final String TEXT_696 = " != null) {";
  protected final String TEXT_697 = NL + "                                        ";
  protected final String TEXT_698 = ".";
  protected final String TEXT_699 = ".setEPSG(";
  protected final String TEXT_700 = ");" + NL + "                                        }";
  protected final String TEXT_701 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_702 = NL + "                                  ";
  protected final String TEXT_703 = ".";
  protected final String TEXT_704 = "=dcg_";
  protected final String TEXT_705 = ";";
  protected final String TEXT_706 = NL + "\t\t\t\t\t\t\t\t\t\tList<String> list_";
  protected final String TEXT_707 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\t\t    \t\t\t\tfor(int i_";
  protected final String TEXT_708 = " = ";
  protected final String TEXT_709 = "; i_";
  protected final String TEXT_710 = "  <= rsmd_";
  protected final String TEXT_711 = ".getColumnCount(); i_";
  protected final String TEXT_712 = " ++){" + NL + "\t\t\t\t\t\t \t\t\t\t\tif (\"NTEXT\".equals(rsmd_";
  protected final String TEXT_713 = ".getColumnTypeName(i_";
  protected final String TEXT_714 = " ).toUpperCase())) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.ClobImpl clob_";
  protected final String TEXT_715 = " = (net.sourceforge.jtds.jdbc.ClobImpl) rs_";
  protected final String TEXT_716 = ".getClob(i_";
  protected final String TEXT_717 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(clob_";
  protected final String TEXT_718 = "!=null){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.TalendNTextImpl tNTextImpl_";
  protected final String TEXT_719 = " = new net.sourceforge.jtds.jdbc.TalendNTextImpl(clob_";
  protected final String TEXT_720 = ");" + NL + "\t\t\t\t\t\t\t  \t\t\t\t\t\tlist_";
  protected final String TEXT_721 = ".add(tNTextImpl_";
  protected final String TEXT_722 = ".getValue());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_723 = ".add(null);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t}" + NL + "   \t \t\t\t\t    \t\t\t\t}" + NL + "                                 \t\t routines.system.DynamicUtils.readColumnsFromDatabase_Mssql(";
  protected final String TEXT_724 = ".";
  protected final String TEXT_725 = ", rs_";
  protected final String TEXT_726 = ", fixedColumnCount_";
  protected final String TEXT_727 = ",list_";
  protected final String TEXT_728 = ",";
  protected final String TEXT_729 = ");";
  protected final String TEXT_730 = NL + "\t\t\t\t\t\t\t\t\t\troutines.system.DynamicUtils.readColumnsFromDatabase_Access(";
  protected final String TEXT_731 = ".";
  protected final String TEXT_732 = ", rs_";
  protected final String TEXT_733 = ", fixedColumnCount_";
  protected final String TEXT_734 = ",";
  protected final String TEXT_735 = ");";
  protected final String TEXT_736 = NL + "                                \t\t routines.system.DynamicUtils.readColumnsFromDatabase(";
  protected final String TEXT_737 = ".";
  protected final String TEXT_738 = ", rs_";
  protected final String TEXT_739 = ", fixedColumnCount_";
  protected final String TEXT_740 = ",";
  protected final String TEXT_741 = ");";
  protected final String TEXT_742 = NL + "                                  Object geom = rs_";
  protected final String TEXT_743 = ".getObject(";
  protected final String TEXT_744 = "column_index_";
  protected final String TEXT_745 = ");" + NL + "                                  if (geom != null) {" + NL + "                                  \torg.postgis.Geometry o =" + NL + "                                      org.postgis.PGgeometry.geomFromString(geom.toString());" + NL + "                                \tStringBuffer sb = new StringBuffer();" + NL + "                                \to.outerWKT(sb, false);" + NL + "                                \t";
  protected final String TEXT_746 = ".";
  protected final String TEXT_747 = " = new Geometry(sb.toString());" + NL + "                                  } else {" + NL + "                                  \t";
  protected final String TEXT_748 = ".";
  protected final String TEXT_749 = " = null;" + NL + "                                  }";
  protected final String TEXT_750 = NL + "\t\t                          ";
  protected final String TEXT_751 = NL + "\t\t                    }";
  protected final String TEXT_752 = NL + "\t\t\t\t\t";
  protected final String TEXT_753 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_754 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_755 = " + \".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_756 = NL + "\t\t                            ";
  protected final String TEXT_757 = ".";
  protected final String TEXT_758 = " = ";
  protected final String TEXT_759 = ".";
  protected final String TEXT_760 = ";" + NL + "\t\t                            ";
  protected final String TEXT_761 = NL;

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

    
	//this util class use by connection component
	class DefaultDBInputUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
		protected String dbport;
		protected String dbname;
		protected String dbuser;
		protected String dbpwd ;
		protected boolean isLog4jEnabled;
		protected boolean isDynamic;
		protected DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil;

		public void beforeComponentProcess(INode node){
			cid = node.getUniqueName();
			List<IMetadataTable> metadatas = node.getMetadataList();
			if ((metadatas != null) && (metadatas.size()>0)) {
				IMetadataTable metadata = metadatas.get(0);
				if (metadata != null) {
					isDynamic = metadata.isDynamicSchema();
				}
			}
			log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();
		}

		public void afterUseExistConnection(INode node) {
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
	    
	    public void afterUseNewConnection(INode node) {
	    }
	    
	    public void setURL(INode node) {
	    }
	    
		public void createConnection(INode node) {
			this.createConnection(node, true);
		}

		public void createConnection(INode node, boolean needUserAndPassword) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");

	 		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
 		if(specify_alias){

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
                String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_77);
    
		}

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
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
    this.setURL(node);
    stringBuffer.append(TEXT_94);
    
				log4jCodeGenerateUtil.debugConnectionParams(node);
				log4jCodeGenerateUtil.connect_begin();
				
    
			if(needUserAndPassword) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
			} else {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    
			}
			log4jCodeGenerateUtil.connect_end();

    stringBuffer.append(TEXT_103);
    this.afterUseNewConnection(node);
    
			if(specify_alias){

    stringBuffer.append(TEXT_104);
    
			}
		}
		
		public String getQueryString(INode node) {
			String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			
			return dbquery;
		}
		
		public void createStatement(INode node) {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
		}
		public void createMinValueStatement(INode node){

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    }
		public String mappingType(String typeToGenerate) {
		
            if(("byte[]").equals(typeToGenerate)) {
                return "Bytes";
            } else if(("java.util.Date").equals(typeToGenerate)) {
                return "Timestamp";
            } else if(("Integer").equals(typeToGenerate)) {
               return "Int";
            } else {
                return typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
		}
		//-----------according schema type to generate ResultSet
		public void generateStringCharAndCharacterSet(String firstConnName, IMetadataColumn column, int currentColNo,
					String trimMethod, String typeToGenerate, boolean whetherTrimAllCol, boolean whetherTrimCol) {

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    if(isDynamic){
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_115);
    
                    if(whetherTrimAllCol || whetherTrimCol) {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_119);
    
                    }

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
                        if(("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_134);
    
                        } else {

    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_141);
    
                        }

    stringBuffer.append(TEXT_142);
    
		}
		
	    public void generateTimestampResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    if(isDynamic){
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_146);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    if(isDynamic){
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_151);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_153);
    
	    }
	    
	    public void generateStringResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String trimMethod) {

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    if(isDynamic){
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_166);
    
	    }
	    
	    public void generateBytesResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    }
	    
	    public void generateOthersResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String typeToGenerate) {

    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    if(isDynamic){
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_170);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_175);
    if(isDynamic){
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_177);
    
                if(column.isNullable()) {
                    
    stringBuffer.append(TEXT_178);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_180);
    
                } else {
                    
    stringBuffer.append(TEXT_181);
        
                }
                
    stringBuffer.append(TEXT_182);
    
	    }
	    //---------end according schema type to generate ResultSet
	    
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultDBInputUtil class
	
	DefaultDBInputUtil dbInputBeginUtil = new DefaultDBInputUtil();
	
	

    stringBuffer.append(TEXT_183);
    
	class DBInputBeginUtil extends DefaultDBInputUtil{
		private String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		private String hiveServer = "hive";


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
				super.createConnection(node, false);
			} else {
				super.createConnection(node);
			}
		}

		public void afterUseExistConnection(INode node) {
			String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	        String db = "db_" + connection;
	        String dbUser = "dbUser_" + connection;

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(db);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(dbUser);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    
	    }

	    public void beforeComponentProcess(INode node){
	    	super.beforeComponentProcess(node);
	    	String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
	    	hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
			boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));

		     // force hive2
	        if ((!isCustom)
	                && (("Cloudera_CDH5_4".equals(hiveVersion))
	                        || ("APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion)))) {
	            hiveServer = "HIVE2";
	        }

			if(hiveServer!=null && !"".equals(hiveServer.trim()) && (isCustom || ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_4".equals(hiveVersion) || "Cloudera_CDH5_1_MR1".equals(hiveVersion) || "MAPR213".equals(hiveVersion) || "MAPR301".equals(hiveVersion) || "MAPR310".equals(hiveVersion) || "MAPR401".equals(hiveVersion) || "MAPR410".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "HDP_2_2".equals(hiveVersion) || "PIVOTAL_HD_2_0".equals(hiveVersion) || "APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion) || "EMR_4_0_0".equals(hiveVersion)))) {
				hiveServer = hiveServer.toLowerCase();
				if ("hive2".equals(hiveServer)) {
					javaDbDriver = "org.apache.hive.jdbc.HiveDriver";
				}
			} else {
				hiveServer = "hive";
			}
	    }

		public void afterUseNewConnection(INode node) {

        	String storeByHBase = ElementParameterParser.getValue(node, "__STORE_BY_HBASE__");
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");

        	String zookeeperQuorumForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
        	String zookeeperClientPortForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
        	boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
			String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");
			String hbaseMasterPrincipal = ElementParameterParser.getValue(node, "__HBASE_MASTER_PRINCIPAL__");
			String hbaseReigonServerPrincipal = ElementParameterParser.getValue(node, "__HBASE_REIGONSERVER_PRINCIPAL__");
        	String defineRegisterJar = ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__");
        	List<Map<String, String>> registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");

        	boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
        	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
        	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(node, "__SET_RESOURCE_MANAGER__"));

			boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
			boolean cdhCanBeSecured = ("Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_4".equals(hiveVersion) || "Cloudera_CDH5_1_MR1".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
			boolean pivotalCanBeSecured = ("PIVOTAL_HD_2_0".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
			boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "HDP_2_2".equals(hiveVersion) || cdhCanBeSecured || pivotalCanBeSecured));
			boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
			boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    

		    if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
		        String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
		        String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_209);
    
    		}

		boolean isKerberosAvailableHadoop2 = !isCustom && ("HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "HDP_2_2".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_4".equals(hiveVersion) || "PIVOTAL_HD_2_0".equals(hiveVersion));
		boolean isHadoop2 = "PIVOTAL_HD_1_0_1".equals(hiveVersion) || "APACHE_2_4_0_EMR".equals(hiveVersion) || "APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion) || "EMR_4_0_0".equals(hiveVersion) || "MAPR401".equals(hiveVersion) || "MAPR410".equals(hiveVersion) || isKerberosAvailableHadoop2;

		boolean isKerberosAvailableHadoop1 = !isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH5_1_MR1".equals(hiveVersion));

		if(securedEmbedded) {
			String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");

    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_212);
    
			if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
				String jobtrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(jobtrackerPrincipal);
    stringBuffer.append(TEXT_215);
    
			}
			if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
				String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");

    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_218);
    
			}

		}

        	if((isCustom && useYarn) || (!isCustom && isHadoop2)) {
        		if(setResourceManager) {
        			String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_222);
    
				}

        		boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_JOBHISTORY_ADDRESS__"));
        		if(setJobHistoryAddress) {
        			String jobHistoryAddress = ElementParameterParser.getValue(node,"__JOBHISTORY_ADDRESS__");
        			
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_225);
    
        		}

				boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
				if(setSchedulerAddress) {
					String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_228);
    
				}

				if ("true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"))) {
				    
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    
				}

				if("true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"))) {
        			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_234);
    
				}

				if("EMBEDDED".equals(connectionMode)) {
					if(!isCustom && ("HDP_2_1".equals(hiveVersion) || "HDP_2_2".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_4".equals(hiveVersion) || "MAPR401".equals(hiveVersion) || "MAPR410".equals(hiveVersion) || "APACHE_2_4_0_EMR".equals(hiveVersion) || "APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion))) {

    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    
					}

					if("MAPR410".equals(hiveVersion)){

    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    
					}

					if(!isCustom && "HDP_2_1".equals(hiveVersion)) {

    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    
					/**/
					} else if(!isCustom && "HDP_2_2".equals(hiveVersion)) {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    
					} else {

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    
					/**/
    				}

        			boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
        			if(isCustom && useYarn && crossPlatformSubmission) {

    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    
    				}
    			}

    			boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
    			if(setMemory) {
        			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
        			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
        			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_255);
    
				}
			}

            List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        	if(advProps!=null) {
				for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_258);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_259);
    
				}
			}

    stringBuffer.append(TEXT_260);
    
			boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
			if(!useExistingConnection){	
			
    stringBuffer.append(TEXT_261);
    stringBuffer.append(TEXT_262);
    
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
    	
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    
            if(advProps != null){
                for(Map<String, String> item : advProps){
                    if("\"tez.lib.uris\"".equals(item.get("PROPERTY"))){
                    
    stringBuffer.append(TEXT_265);
      
                    }
                }
            }
            boolean installTez = "INSTALL".equals(ElementParameterParser.getValue(node, "__TEZ_LIB__"));
            if(installTez){
                //prepare the folder
                
    stringBuffer.append(TEXT_266);
    
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
        
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    
        hadoopVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));
        
        String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        isCustom = "CUSTOM".equals(distribution);
        
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_277);
    
        if(mrUseDatanodeHostname){
        
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_283);
     
    		}
    	}
        	
    	if(((hadoopVersion!=null && supportKrbVersionList.contains(hadoopVersion)) && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_286);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_287);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_289);
    
    		}
    	}
    	
    	if("MAPR".equals(distribution)){
    		String group = ElementParameterParser.getValue(node, "__GROUP__");
    		
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(group);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    
        }else{
        
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    
        }
    }
}

      
                (new GetFileSystem()).invoke(node, cid);
                String tezLibFolder = ElementParameterParser.getValue(node, "__TEZ_LIB_FOLDER__");
                boolean useDefaultTezLibFolder = "\"/tmp/{USERNAME}/talend_tez_libs/{custom|HIVE_VERSION}\"".equals(tezLibFolder);
                if(useDefaultTezLibFolder){
                
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(isCustom?"custom":hiveVersion);
    stringBuffer.append(TEXT_313);
    
                }else{
                
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(tezLibFolder);
    stringBuffer.append(TEXT_316);
    
                }
                
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    
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
                
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    if(changePathSeparator){
    stringBuffer.append(TEXT_322);
    }else{
    stringBuffer.append(TEXT_323);
    }
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    
                    for(String jarName : tezLibJarsName){
                    
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    
                    }
                    
    stringBuffer.append(TEXT_339);
    
            }else{
            
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TEZ_LIB_PATH__"));
    stringBuffer.append(TEXT_342);
    
            }
            //define the location of tez lib    
            
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__"));
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    
    	}
    }
}

    stringBuffer.append(TEXT_360);
    
            	(new PrepareTez()).invoke(node, cid);
            }	
            
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(dbname);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    
    		if("true".equalsIgnoreCase(storeByHBase) && !("EMBEDDED".equals(connectionMode) && "MAPR2".equals(hiveVersion))) {
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_378);
    }
    stringBuffer.append(TEXT_379);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_382);
    }
    stringBuffer.append(TEXT_383);
    if(setZNodeParent && zNodeParent!=null && !"".equals(zNodeParent) && !"\"\"".equals(zNodeParent)) {
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_386);
    }
    stringBuffer.append(TEXT_387);
    if(useKrb){
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    if(hbaseMasterPrincipal!=null && !"".equals(hbaseMasterPrincipal) && !"\"\"".equals(hbaseMasterPrincipal)){
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(hbaseMasterPrincipal);
    stringBuffer.append(TEXT_393);
    }
    stringBuffer.append(TEXT_394);
    if(hbaseReigonServerPrincipal!=null && !"".equals(hbaseReigonServerPrincipal) && !"\"\"".equals(hbaseReigonServerPrincipal)){
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(hbaseReigonServerPrincipal);
    stringBuffer.append(TEXT_397);
    }
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

		public void setURL(INode node) {
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			String fsDefalutName = "fs.default.name";

			boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
			boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
			List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");

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

			if(!isCustom && (("HDP_1_2".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
			        || ("HDP_1_3".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
			        || ("HDP_2_0".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
			        || ("HDP_2_1".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
			        || ("HDP_2_2".equals(hiveVersion) && "STANDALONE".equals(connectionMode) && "HIVE".equalsIgnoreCase(hiveServer))
			        || ("EMR_4_0_0".equals(hiveVersion) && ("EMBEDDED".equals(connectionMode) || "HIVE".equalsIgnoreCase(hiveServer))))) {

    stringBuffer.append(TEXT_405);
    
			}

			if(hadoopProps.size() > 0){
				for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_406);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_407);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_408);
    
				}
			}

			if(((isCustom && !useYarn) || (!isCustom && !"PIVOTAL_HD_1_0_1".equals(hiveVersion) && !"PIVOTAL_HD_2_0".equals(hiveVersion) && !"HDP_2_0".equals(hiveVersion) && !"HDP_2_1".equals(hiveVersion) && !"HDP_2_2".equals(hiveVersion) && !"Cloudera_CDH4_YARN".equals(hiveVersion) && !"Cloudera_CDH5".equals(hiveVersion) && !"Cloudera_CDH5_1".equals(hiveVersion) && !"Cloudera_CDH5_4".equals(hiveVersion) && !"MAPR401".equals(hiveVersion) && !"EMR_4_0_0".equals(hiveVersion) && !"MAPR410".equals(hiveVersion))) && setMapredJT) {
				String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_409);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_410);
    
			}

			if(setNamenode) {
				String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_411);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_413);
    
			}

			if(securedEmbedded) {
				String metastoreUrl = ElementParameterParser.getValue(node, "__METASTORE_JDBC_URL__");
				String driverClass = ElementParameterParser.getValue(node, "__METASTORE_CLASSNAME__");
				String metastoreUsername = ElementParameterParser.getValue(node, "__METASTORE_USERNAME__");
				boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
				String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
				String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_414);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_415);
    if(securedEmbeddedHive2){
					// Disable authorization when using local HiveServer2 in secure mode
					
    stringBuffer.append(TEXT_416);
    
                }else{
                    
    stringBuffer.append(TEXT_417);
    
                 }
                
    stringBuffer.append(TEXT_418);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_420);
    
        		String passwordFieldName = "__METASTORE_PASSWORD__";
        		
    stringBuffer.append(TEXT_421);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_424);
    } else {
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_427);
    }
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_430);
    
               	if(securedEmbeddedHive2){
                
    stringBuffer.append(TEXT_431);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_PRINCIPAL__"));
    stringBuffer.append(TEXT_432);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_KEYTAB__"));
    stringBuffer.append(TEXT_433);
    
                }
                
    
				if(useKeytab) {

    stringBuffer.append(TEXT_434);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_436);
    
				}
			}

	        boolean setHadoopUser = "true".equals(ElementParameterParser.getValue(node, "__SET_HADOOP_USER__"));
	        if (setHadoopUser) {
	            String hadoopUser = ElementParameterParser.getValue(node, "__HADOOP_USER__");
	            
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_438);
    stringBuffer.append(hadoopUser);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_442);
    
	        }

    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    
			if("EMBEDDED".equals(connectionMode)) {

    stringBuffer.append(TEXT_445);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_449);
    
				if(isCustom || (!isCustom && ("HDP_1_2,HDP_1_3,HDP_2_0,HDP_2_1,HDP_2_2,Cloudera_CDH4,Cloudera_CDH4_YARN,Cloudera_CDH5,Cloudera_CDH5_1,Cloudera_CDH5_4,Cloudera_CDH5_1_MR1,PIVOTAL_HD_1_0_1,PIVOTAL_HD_2_0,EMR_4_0_0".contains(hiveVersion)))) {

    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_454);
    
				}
			} else {
				if(securedStandaloneHive2) {
					// using keytab with HiveServer2 in standalone mode
					boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
					String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
					String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
					if(useKeytab) {

    stringBuffer.append(TEXT_455);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_457);
    
					}
					// Using SSL in Secure Mode
					if(useSsl){

    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_464);
    
					}else{

    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_471);
    
					}
				} else {
					// Using SSL in non Secure Mode
					if(useSsl){
						String sslStorepasswordFieldName = "__SSL_TRUST_STORE_PASSWORD__";
						if (ElementParameterParser.canEncrypt(node, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_474);
    
						}else{

    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append( ElementParameterParser.getValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_477);
    
						}

    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    
					}else{

    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_491);
    
					}
				}
				String additionalJdbcSettings = ElementParameterParser.getValue(node, "__HIVE_ADDITIONAL_JDBC__");

    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(additionalJdbcSettings);
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
    
			}
		}

		public String getDirverClassName(INode node){
			return javaDbDriver;
		}

		public void createStatement(INode node) {
			boolean useParquet = "true".equals(ElementParameterParser.getValue(node,"__USE_PARQUET__"));
			String processId = node.getProcess().getId();

			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			boolean setFsDefaultName = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
			String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
			String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");

			boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

			if(useExistingConnection) {
				connectionMode = "";
				setFsDefaultName = false;
				fsDefaultName = "";
				dbuser = "";
				distribution = "";
				hiveVersion = "";
				String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
				for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
					if(connection!=null && connection.equals(pNode.getUniqueName())) {
						connectionMode = ElementParameterParser.getValue(pNode, "__CONNECTION_MODE__");
						setFsDefaultName = "true".equals(ElementParameterParser.getValue(pNode, "__SET_FS_DEFAULT_NAME__"));
						fsDefaultName = ElementParameterParser.getValue(pNode, "__FS_DEFAULT_NAME__");
						dbuser = ElementParameterParser.getValue(pNode, "__USER__");
						distribution = ElementParameterParser.getValue(pNode, "__DISTRIBUTION__");
						hiveVersion = ElementParameterParser.getValue(pNode, "__HIVE_VERSION__");
						break;
					}
				}
			}

			java.util.List<String> hiveVersionList = new java.util.ArrayList<String>();
			hiveVersionList.add("Cloudera_CDH4");
			hiveVersionList.add("APACHE_1_0_0");
			hiveVersionList.add("MAPR2");
			hiveVersionList.add("PIVOTAL_HD_1_0_1");

			boolean isParquetSupported = "CUSTOM".equals(distribution) || !hiveVersionList.contains(hiveVersion);
			if(useParquet && !isParquetSupported) {

    stringBuffer.append(TEXT_501);
    
			}

			boolean generateAddJarCodeForAll = useParquet;

			// Register jars to handle the parquet format.

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
				if("EMBEDDED".equalsIgnoreCase(connectionMode)) {

    stringBuffer.append(TEXT_502);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    }
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    
				} else {
					generateAddJarCodeForAll = false;
					if(setFsDefaultName) {
						generateAddJarCodeForAll = true;

    stringBuffer.append(TEXT_512);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    }
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    
					}
				}

				if(generateAddJarCodeForAll) {

    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    
					for(int i=0; i<jarsToRegister.size(); i++) {
						String jarToRegister = jarsToRegister.get(i);
						for(int j=0; j<jars.size(); j++) {
							if(jars.get(j).contains(jarToRegister)) {

    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_534);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    
							}
						}
					}
				}
			}

			// End of parquet format handling.

			super.createStatement(node);
		}

	}//end class

	dbInputBeginUtil = new DBInputBeginUtil();
	
    stringBuffer.append(TEXT_537);
    
	CodeGeneratorArgument codeGenArg = (CodeGeneratorArgument) argument;
	INode hiveNode = (INode)codeGenArg.getArgument();
	boolean setTempPath = "true".equals(ElementParameterParser.getValue(hiveNode, "__SET_TEMP_PATH__"));
	if(setTempPath) {
		String tempPath = ElementParameterParser.getValue(hiveNode, "__TEMP_PATH__");

    stringBuffer.append(TEXT_538);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_539);
    
	}

	String yarnClasspathSeparator = ElementParameterParser.getValue(hiveNode, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_540);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_541);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String type = ElementParameterParser.getValue(node, "__TYPE__");
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser = ElementParameterParser.getValue(node, "__USER__");

	String dbencoding = ElementParameterParser.getValue(node, "__ENCODING__");
	String enableStream = ElementParameterParser.getValue(node, "__ENABLE_STREAM__");
	String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
	if("tJDBCInput".equals(node.getComponent().getName())) {
		boolean isEnableMapping = ("true").equals(ElementParameterParser.getValue(node, "__ENABLE_MAPPING__"));
		if (!isEnableMapping) {
			dbms = "";
		}
	}
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    boolean whetherTrimAllCol = ("true").equals(ElementParameterParser.getValue(node, "__TRIM_ALL_COLUMN__"));
    List<Map<String, String>> trimColumnList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIM_COLUMN__");

    dbInputBeginUtil.beforeComponentProcess(node);
    int dynamic_index=-1;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas != null) && (metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata != null) {

    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    
		    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(("true").equals(useExistingConn)) {
		        String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		        String conn = "conn_" + connection;
                if(connection.matches("^.*?tAmazonAuroraConnection_\\d+$")){
                      conn += "_in";
                }

    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_547);
    
                INode connectionNode = null;
                for (INode processNode : node.getProcess().getGeneratingNodes()) {
                	String nodeUniqueName = processNode.getUniqueName();
                	if(connection.equals(nodeUniqueName) || (connection+"_in").equals(nodeUniqueName)) {
                		connectionNode = processNode;
                		break;
                	}
                }
		        boolean specify_alias = "true".equals(ElementParameterParser.getValue(connectionNode, "__SPECIFY_DATASOURCE_ALIAS__"));
		        if(specify_alias){
	                String alias = ElementParameterParser.getValue(connectionNode, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_553);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    
		        }
		        
    stringBuffer.append(TEXT_556);
    log4jCodeGenerateUtil.useExistConnection(node);
    
				dbInputBeginUtil.afterUseExistConnection(node);

		    } else {
				dbInputBeginUtil.createConnection(node);
				if ("teradata_id".equalsIgnoreCase(dbms)) {

    stringBuffer.append(TEXT_557);
    
      boolean queryBand = "true".equals(ElementParameterParser.getValue(node, "__QUERY_BAND__"));
      boolean activateQueryLogging = "true".equals(ElementParameterParser.getValue(node, "__ACTIVATE_QUERY_LOGGING__"));
      String usrName = ElementParameterParser.getValue(node, "__USER__");
      List<Map<String, String>> queryBandList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__QUERY_BAND_PARAMETERS__");
      if(queryBand){
    stringBuffer.append(TEXT_558);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    
                    if(activateQueryLogging){
                        
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append( usrName );
    stringBuffer.append(TEXT_564);
    
                    }
                  
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    
            for(Map<String, String> map : queryBandList) {

    stringBuffer.append(TEXT_567);
    stringBuffer.append( map.get("KEY") );
    stringBuffer.append(TEXT_568);
    stringBuffer.append( map.get("VALUE") );
    stringBuffer.append(TEXT_569);
    
            }

    stringBuffer.append(TEXT_570);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_571);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_572);
    }
    
				}
		    }

    stringBuffer.append(TEXT_573);
    dbInputBeginUtil.createStatement(node);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(dbInputBeginUtil.getQueryString(node));
    stringBuffer.append(TEXT_576);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    }
    stringBuffer.append(TEXT_580);
     
                if(cid.matches("^.*?tAmazonAuroraInput_\\d+_in$")){
                    // why 3: ==> "_in".length()
                    
    stringBuffer.append(TEXT_581);
    stringBuffer.append( cid.substring(0,cid.length() - 3) );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    
                }else{
                    
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    
            }
             
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_595);
    
		    List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		    List<IMetadataColumn> columnList = metadata.getListColumns();
		    boolean isDynamic = metadata.isDynamicSchema();
		    if(isDynamic){
		    	String DynamicDatePattern = "\"dd-MM-yyyy\"";
		    	for(IMetadataColumn column : columnList) {
		    		if("id_Dynamic".equals(column.getTalendType())) {
		    			DynamicDatePattern = column.getPattern();
		    			break;
		    		}
		    	}
		    
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    

		    for(int i=0; i< columnList.size(); i++) {
		        if(columnList.get(i).getTalendType().equals("id_Dynamic")){
		            dynamic_index = i+1;
		        }else{
		            IMetadataColumn column = columnList.get(i);
		            String columName = column.getOriginalDbColumnName();
		            if(columName==null || "".equals(columName)){
		                columName = column.getLabel();
		            }
	            
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(columName.toUpperCase());
    stringBuffer.append(TEXT_603);
    
		    	}
			}
		    
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(columnList.size()-dynamic_index);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
     if((DynamicDatePattern!=null) && (!"".equals(DynamicDatePattern)) && (!"\"\"".equals(DynamicDatePattern))) {
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(DynamicDatePattern);
    stringBuffer.append(TEXT_628);
     } 
    
		if (("oracle_id".equalsIgnoreCase(dbms))) {

    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    
		} else {

    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    
		}

    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    
		    }
		    
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    if(isDynamic){
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_652);
    }
    stringBuffer.append(TEXT_653);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_655);
    }
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_657);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_658);
    
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
		                String columnType = column.getType();

		                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		                String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate);
		                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							if(isDynamic){
								if(!("Dynamic").equals(typeToGenerate) && dynamic_index < currentColNo) {
								
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_660);
    stringBuffer.append(currentColNo-1);
    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_662);
    }else{
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_665);
    }
    stringBuffer.append(TEXT_666);
    
							}
							
    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_668);
    if(isDynamic){
    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_670);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_671);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_672);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_673);
    
								typeToGenerate = dbInputBeginUtil.mappingType(typeToGenerate);

								if(("Char").equals(typeToGenerate) || ("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_674);
    dbInputBeginUtil.generateStringCharAndCharacterSet(firstConnName, column,currentColNo, trimMethod, typeToGenerate, whetherTrimAllCol, whetherTrimCol);
    
								} else if(("Timestamp").equals(typeToGenerate)) {
									if("vertica_id".equalsIgnoreCase(dbms) && "DATE".equalsIgnoreCase(column.getType())){

    stringBuffer.append(TEXT_675);
    dbInputBeginUtil.generateOthersResultSet(firstConnName, column,  currentColNo,  "Date");
    
									}else{

    stringBuffer.append(TEXT_676);
    dbInputBeginUtil.generateTimestampResultSet(firstConnName, column, currentColNo);
    
									}
		                         } else if (("List").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_677);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_680);
    if(isDynamic){
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_682);
    
		                        } else if(("String").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_683);
    dbInputBeginUtil.generateStringResultSet(firstConnName, column, currentColNo,trimMethod);
    
								} else if("Geometry".equals(typeToGenerate) && type.indexOf("ORACLE") >= 0) {

    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_685);
    if(isDynamic){
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_687);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_690);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_693);
    
                                    String sourceCRS = ElementParameterParser.getValue(node,"__CRS__");
                                    String forceCRS = ElementParameterParser.getValue(node,"__FORCE_CRS__");
                                    if (forceCRS.equals("true")) {

    stringBuffer.append(TEXT_694);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_695);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_696);
    stringBuffer.append(TEXT_697);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_698);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_699);
    stringBuffer.append(sourceCRS);
    stringBuffer.append(TEXT_700);
    
                                    }
								} else if(("Bytes").equals(typeToGenerate) && (columnType != null && (("LONG RAW").equals(columnType) || ("RAW").equals(columnType)))) {//oracle

    stringBuffer.append(TEXT_701);
    dbInputBeginUtil.generateBytesResultSet(firstConnName, column, currentColNo);
    
								} else if(("Dynamic").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_702);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_703);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_705);
     //for bug TDI-20886
									boolean trim = whetherTrimAllCol || whetherTrimCol;
									if ("id_MSSQL".equalsIgnoreCase(dbms)) {

    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_708);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_712);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_717);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_718);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_721);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_723);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_724);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_725);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_727);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_728);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_729);
    
									}else if("access_id".equalsIgnoreCase(dbms)){

    stringBuffer.append(TEXT_730);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_731);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_733);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_734);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_735);
    
									}else{

    stringBuffer.append(TEXT_736);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_737);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_738);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_739);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_740);
    stringBuffer.append(trim);
    stringBuffer.append(TEXT_741);
    
									}
								} else if(typeToGenerate.equals("Geometry")) {

    stringBuffer.append(TEXT_742);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_743);
    if(isDynamic){
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid);
    }else{
    stringBuffer.append(currentColNo);
    }
    stringBuffer.append(TEXT_745);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_746);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_747);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_748);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_749);
    
                 	            } else {

    stringBuffer.append(TEXT_750);
    dbInputBeginUtil.generateOthersResultSet( firstConnName, column,  currentColNo,  typeToGenerate);
    
		                        }

    stringBuffer.append(TEXT_751);
    
		                    currentColNo++;
		                }
		            }

    stringBuffer.append(TEXT_752);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_753);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_754);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_755);
    }
    
		            if(conns.size() > 1) {
		                for(int connNO = 1 ; connNO < conns.size() ; connNO++) {
		                    IConnection conn2 = conns.get(connNO);
		                    if((conn2.getName().compareTo(firstConnName) != 0) && (conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
		                        for(IMetadataColumn column:columnList){
		                            
    stringBuffer.append(TEXT_756);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_757);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_758);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_759);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_760);
    
		                        }
		                    }
		                }
		            }
		        }
		}
	}

    stringBuffer.append(TEXT_761);
    return stringBuffer.toString();
  }
}
