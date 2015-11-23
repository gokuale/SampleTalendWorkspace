package org.talend.designer.codegen.translators.file.sqoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSqoopMergeBeginJava
{
  protected static String nl;
  public static synchronized TSqoopMergeBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSqoopMergeBeginJava result = new TSqoopMergeBeginJava();
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
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = NL + "\tRuntime runtime_generateJar_";
  protected final String TEXT_33 = " = Runtime.getRuntime();" + NL;
  protected final String TEXT_34 = NL + NL + "\t";
  protected final String TEXT_35 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_36 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_39 = " = ";
  protected final String TEXT_40 = "; ";
  protected final String TEXT_41 = NL + "\t\t" + NL + "" + NL + "\tString[] generateJar_cmd_";
  protected final String TEXT_42 = " = new String[] {\"sqoop\", \"codegen\", \"--connect\", ";
  protected final String TEXT_43 = ", \"--table\", ";
  protected final String TEXT_44 = ", \"--username\", ";
  protected final String TEXT_45 = ", \"--password\", decryptedPassword_";
  protected final String TEXT_46 = NL + "\t";
  protected final String TEXT_47 = ", \"--verbose\"";
  protected final String TEXT_48 = " " + NL + "            ,\"";
  protected final String TEXT_49 = "\", ";
  protected final String TEXT_50 = " ";
  protected final String TEXT_51 = " " + NL + "            ,\"";
  protected final String TEXT_52 = "\" ";
  protected final String TEXT_53 = NL + "\t};" + NL + NL;
  protected final String TEXT_54 = NL + "\t\tjava.lang.StringBuilder sb_generateJar_";
  protected final String TEXT_55 = " = new java.lang.StringBuilder();" + NL + "\t\tfor(String parameter_";
  protected final String TEXT_56 = " : generateJar_cmd_";
  protected final String TEXT_57 = ") {" + NL + "\t\t\tsb_generateJar_";
  protected final String TEXT_58 = ".append(parameter_";
  protected final String TEXT_59 = ");" + NL + "\t\t\tsb_generateJar_";
  protected final String TEXT_60 = ".append(\" \");" + NL + "\t\t}" + NL + "\t\tlog.info(\"";
  protected final String TEXT_61 = " - execute sqoop command: \" + sb_generateJar_";
  protected final String TEXT_62 = ".toString());";
  protected final String TEXT_63 = NL + NL + "\tProcess generateJar_ps_";
  protected final String TEXT_64 = "  = null;" + NL + "\tjava.lang.StringBuilder generateJar_sb_";
  protected final String TEXT_65 = " = null;" + NL + "\t" + NL + "\ttry {" + NL + "\t\tgenerateJar_ps_";
  protected final String TEXT_66 = " = runtime_generateJar_";
  protected final String TEXT_67 = ".exec(generateJar_cmd_";
  protected final String TEXT_68 = ");" + NL + "\t\tbyte[] generateJar_byteArray_";
  protected final String TEXT_69 = " = new byte[1024];" + NL + "\t\tint generateJar_len_";
  protected final String TEXT_70 = " = 0;" + NL + "\t\t" + NL + "\t\tjava.io.InputStream generateJar_errorStream_";
  protected final String TEXT_71 = " = new java.io.BufferedInputStream(generateJar_ps_";
  protected final String TEXT_72 = ".getErrorStream());" + NL + "\t\tgenerateJar_sb_";
  protected final String TEXT_73 = " = new java.lang.StringBuilder();" + NL + "\t\twhile ((generateJar_len_";
  protected final String TEXT_74 = " = generateJar_errorStream_";
  protected final String TEXT_75 = ".read(generateJar_byteArray_";
  protected final String TEXT_76 = ")) != -1) {" + NL + "\t\t    String generateJar_line_";
  protected final String TEXT_77 = " = new String(generateJar_byteArray_";
  protected final String TEXT_78 = ", 0, generateJar_len_";
  protected final String TEXT_79 = ", \"ISO-8859-1\");" + NL + "\t    \t";
  protected final String TEXT_80 = NL + "        \t\tSystem.err.println(generateJar_line_";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL + NL + "\t    \tgenerateJar_sb_";
  protected final String TEXT_83 = ".append(generateJar_line_";
  protected final String TEXT_84 = ");" + NL + "\t\t}" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_85 = "_ERROR_MESSAGE\", generateJar_sb_";
  protected final String TEXT_86 = ".toString());" + NL + "\t\t";
  protected final String TEXT_87 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_88 = " - \" + generateJar_sb_";
  protected final String TEXT_89 = ".toString());" + NL + "\t\t";
  protected final String TEXT_90 = NL + "\t\tgenerateJar_byteArray_";
  protected final String TEXT_91 = " = new byte[1024];" + NL + "\t\tgenerateJar_len_";
  protected final String TEXT_92 = " = 0;" + NL + "\t\tjava.io.InputStream generateJar_inputStream_";
  protected final String TEXT_93 = " = new java.io.BufferedInputStream(generateJar_ps_";
  protected final String TEXT_94 = ".getInputStream());" + NL + "\t\tgenerateJar_sb_";
  protected final String TEXT_95 = " = new java.lang.StringBuilder();" + NL + "\t\twhile ((generateJar_len_";
  protected final String TEXT_96 = " = generateJar_inputStream_";
  protected final String TEXT_97 = ".read(generateJar_byteArray_";
  protected final String TEXT_98 = ")) != -1) {" + NL + "\t\t    String generateJar_line_";
  protected final String TEXT_99 = " = new String(generateJar_byteArray_";
  protected final String TEXT_100 = ", 0, generateJar_len_";
  protected final String TEXT_101 = ", \"ISO-8859-1\");";
  protected final String TEXT_102 = NL + "\t       \t System.out.println(generateJar_line_";
  protected final String TEXT_103 = ");";
  protected final String TEXT_104 = NL + "\t    \tgenerateJar_sb_";
  protected final String TEXT_105 = ".append(generateJar_line_";
  protected final String TEXT_106 = ");" + NL + "\t\t}" + NL + "\t} catch (Exception e) {";
  protected final String TEXT_107 = NL + "\t\t\tthrow e;";
  protected final String TEXT_108 = NL + "\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_109 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_110 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_111 = "\t" + NL + "\t}" + NL;
  protected final String TEXT_112 = NL + "\t\tgenerateJar_ps_";
  protected final String TEXT_113 = ".waitFor();" + NL + "\t\tif(generateJar_ps_";
  protected final String TEXT_114 = ".exitValue()>0) {" + NL + "\t\t\tthrow new Exception(\"The Sqoop merge has failed. Please check the logs.\");" + NL + "\t\t}";
  protected final String TEXT_115 = NL + NL + "\tif(generateJar_sb_";
  protected final String TEXT_116 = "!=null) {" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_117 = "_OUTPUT_MESSAGE\", generateJar_sb_";
  protected final String TEXT_118 = ".toString());" + NL + "\t\t";
  protected final String TEXT_119 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_120 = " - \" + generateJar_sb_";
  protected final String TEXT_121 = ".toString());" + NL + "\t\t";
  protected final String TEXT_122 = "\t" + NL + "\t}";
  protected final String TEXT_123 = NL + NL + "//call the cmd part" + NL + "Runtime runtime_";
  protected final String TEXT_124 = " = Runtime.getRuntime();" + NL + "String jar_file_";
  protected final String TEXT_125 = " = ";
  protected final String TEXT_126 = ";";
  protected final String TEXT_127 = NL + "\tjar_file_";
  protected final String TEXT_128 = " = ";
  protected final String TEXT_129 = "+ \"/\" + ";
  protected final String TEXT_130 = "  + \".jar\";";
  protected final String TEXT_131 = NL + "String[] cmd_";
  protected final String TEXT_132 = " = new String[] {\"sqoop\", \"merge\", \"--new-data\", ";
  protected final String TEXT_133 = ", \"--onto\", ";
  protected final String TEXT_134 = ", \"--target-dir\", ";
  protected final String TEXT_135 = ", \"--jar-file\", jar_file_";
  protected final String TEXT_136 = ", \"--class-name\", ";
  protected final String TEXT_137 = ", \"--merge-key\", ";
  protected final String TEXT_138 = "};" + NL;
  protected final String TEXT_139 = NL + "java.lang.StringBuilder stringBuilder_";
  protected final String TEXT_140 = " = new java.lang.StringBuilder();" + NL + "for(String parameter_";
  protected final String TEXT_141 = " : cmd_";
  protected final String TEXT_142 = ") {" + NL + "\tstringBuilder_";
  protected final String TEXT_143 = ".append(parameter_";
  protected final String TEXT_144 = ");" + NL + "\tstringBuilder_";
  protected final String TEXT_145 = ".append(\" \");" + NL + "}" + NL + "log.info(\"";
  protected final String TEXT_146 = " - execute sqoop command: \" + stringBuilder_";
  protected final String TEXT_147 = ".toString());";
  protected final String TEXT_148 = NL + NL + "Process ps_";
  protected final String TEXT_149 = " = null;" + NL + "java.lang.StringBuilder sb_";
  protected final String TEXT_150 = " = null;" + NL + "" + NL + "try {" + NL + "\tps_";
  protected final String TEXT_151 = " = runtime_";
  protected final String TEXT_152 = ".exec(cmd_";
  protected final String TEXT_153 = ");" + NL + "\tbyte[] byteArray_";
  protected final String TEXT_154 = " = new byte[1024];" + NL + "\tint len_";
  protected final String TEXT_155 = " = 0;" + NL + "\t" + NL + "\tjava.io.InputStream errorStream_";
  protected final String TEXT_156 = " = new java.io.BufferedInputStream(ps_";
  protected final String TEXT_157 = ".getErrorStream());" + NL + "\tsb_";
  protected final String TEXT_158 = " = new java.lang.StringBuilder();" + NL + "\twhile ((len_";
  protected final String TEXT_159 = " = errorStream_";
  protected final String TEXT_160 = ".read(byteArray_";
  protected final String TEXT_161 = ")) != -1) {" + NL + "\t    String line_";
  protected final String TEXT_162 = " = new String(byteArray_";
  protected final String TEXT_163 = ", 0, len_";
  protected final String TEXT_164 = ", \"ISO-8859-1\");" + NL + "\t    ";
  protected final String TEXT_165 = NL + "\t        System.err.println(line_";
  protected final String TEXT_166 = ");";
  protected final String TEXT_167 = NL + "\t    sb_";
  protected final String TEXT_168 = ".append(line_";
  protected final String TEXT_169 = ");" + NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_170 = "_ERROR_MESSAGE\", sb_";
  protected final String TEXT_171 = ".toString());" + NL + "\t";
  protected final String TEXT_172 = NL + "\t\tlog.error(\"";
  protected final String TEXT_173 = " - \" + sb_";
  protected final String TEXT_174 = ".toString());" + NL + "\t";
  protected final String TEXT_175 = NL + "\tbyteArray_";
  protected final String TEXT_176 = " = new byte[1024];" + NL + "\tlen_";
  protected final String TEXT_177 = " = 0;" + NL + "\tjava.io.InputStream inputStream_";
  protected final String TEXT_178 = " = new java.io.BufferedInputStream(ps_";
  protected final String TEXT_179 = ".getInputStream());" + NL + "\tsb_";
  protected final String TEXT_180 = " = new java.lang.StringBuilder();" + NL + "\twhile ((len_";
  protected final String TEXT_181 = " = inputStream_";
  protected final String TEXT_182 = ".read(byteArray_";
  protected final String TEXT_183 = ")) != -1) {" + NL + "\t    String line_";
  protected final String TEXT_184 = " = new String(byteArray_";
  protected final String TEXT_185 = ", 0, len_";
  protected final String TEXT_186 = ", \"ISO-8859-1\");" + NL + "\t    sb_";
  protected final String TEXT_187 = ".append(line_";
  protected final String TEXT_188 = ");" + NL + "\t}";
  protected final String TEXT_189 = NL + "\t\tif (sb_";
  protected final String TEXT_190 = ".length() > 0 ) {" + NL + "\t\t\tSystem.out.println(sb_";
  protected final String TEXT_191 = ");" + NL + "\t\t}";
  protected final String TEXT_192 = NL + "} catch (Exception e) {";
  protected final String TEXT_193 = NL + "\t\tthrow e;";
  protected final String TEXT_194 = NL + "\t\tSystem.err.println(e.getMessage());" + NL + "\t\t";
  protected final String TEXT_195 = NL + "\t\tlog.error(\"";
  protected final String TEXT_196 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_197 = "\t" + NL + "}" + NL + "" + NL + "\tint result_";
  protected final String TEXT_198 = " = ps_";
  protected final String TEXT_199 = ".waitFor();" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_200 = "_EXIT_CODE\", result_";
  protected final String TEXT_201 = ");" + NL;
  protected final String TEXT_202 = NL + "\t\tif(ps_";
  protected final String TEXT_203 = ".exitValue()>0) {" + NL + "\t\t\tthrow new Exception(\"The Sqoop import has failed. Please check the logs.\");" + NL + "\t\t}";
  protected final String TEXT_204 = NL + NL + "if(sb_";
  protected final String TEXT_205 = "!=null) {" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_206 = "_OUTPUT_MESSAGE\", sb_";
  protected final String TEXT_207 = ".toString());" + NL + "\t";
  protected final String TEXT_208 = NL + "\t\tlog.info(\"";
  protected final String TEXT_209 = " - \" + sb_";
  protected final String TEXT_210 = ".toString());" + NL + "\t";
  protected final String TEXT_211 = NL + "}";
  protected final String TEXT_212 = NL + "\t";
  protected final String TEXT_213 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_214 = ");" + NL + "\t" + NL + "\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_215 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_216 = NL + "\t\tString username_";
  protected final String TEXT_217 = " = ";
  protected final String TEXT_218 = ";" + NL + "\t\tif(username_";
  protected final String TEXT_219 = "!=null && !\"\".equals(username_";
  protected final String TEXT_220 = ".trim())) {" + NL + "\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_221 = ");" + NL + "\t\t}";
  protected final String TEXT_222 = NL + "\t" + NL + "\torg.apache.hadoop.conf.Configuration configuration_";
  protected final String TEXT_223 = " = new org.apache.hadoop.conf.Configuration();" + NL + "\tconfiguration_";
  protected final String TEXT_224 = ".set(\"";
  protected final String TEXT_225 = "\", ";
  protected final String TEXT_226 = ");";
  protected final String TEXT_227 = NL + "\t\tconfiguration_";
  protected final String TEXT_228 = ".set(\"mapreduce.job.map.output.collector.class\", \"org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "\t    configuration_";
  protected final String TEXT_229 = ".set(\"mapreduce.job.reduce.shuffle.consumer.plugin.class\", \"org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_230 = NL + "    \tconfiguration_";
  protected final String TEXT_231 = ".set(\"mapreduce.framework.name\", \"yarn\");" + NL + "    \tconfiguration_";
  protected final String TEXT_232 = ".set(\"yarn.resourcemanager.address\", ";
  protected final String TEXT_233 = ");";
  protected final String TEXT_234 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_235 = ".set(\"mapreduce.jobhistory.address\", ";
  protected final String TEXT_236 = ");" + NL + "\t\t\t";
  protected final String TEXT_237 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_238 = ".set(\"yarn.resourcemanager.scheduler.address\", ";
  protected final String TEXT_239 = ");";
  protected final String TEXT_240 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_241 = ".set(\"yarn.app.mapreduce.am.staging-dir\", ";
  protected final String TEXT_242 = ");";
  protected final String TEXT_243 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_244 = ".set(\"mapreduce.app-submission.cross-platform\",\"true\");";
  protected final String TEXT_245 = NL + "    \t\tconfiguration_";
  protected final String TEXT_246 = ".set(\"yarn.application.classpath\",\"/etc/hadoop/conf,/usr/lib/hadoop/*,/usr/lib/hadoop/lib/*,/usr/lib/hadoop-hdfs/*,/usr/lib/hadoop-hdfs/lib/*,/usr/lib/hadoop-yarn/*,/usr/lib/hadoop-yarn/lib/*,/usr/lib/hadoop-mapreduce/*,/usr/lib/hadoop-mapreduce/lib/*\");";
  protected final String TEXT_247 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_248 = ".set(\"mapreduce.application.classpath\",\"$PWD/mr-framework/hadoop/share/hadoop/mapreduce/*:$PWD/mr-framework/hadoop/share/hadoop/mapreduce/lib/*:$PWD/mr-framework/hadoop/share/hadoop/common/*:$PWD/mr-framework/hadoop/share/hadoop/common/lib/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/lib/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/lib/*:/etc/hadoop/conf/secure\");" + NL + "\t\t\tconfiguration_";
  protected final String TEXT_249 = ".set(\"yarn.application.classpath\",\"$HADOOP_CONF_DIR,/usr/hdp/current/hadoop-client/*,/usr/hdp/current/hadoop-client/lib/*,/usr/hdp/current/hadoop-hdfs-client/*,/usr/hdp/current/hadoop-hdfs-client/lib/*,/usr/hdp/current/hadoop-mapreduce-client/*,/usr/hdp/current/hadoop-mapreduce-client/lib/*,/usr/hdp/current/hadoop-yarn-client/*,/usr/hdp/current/hadoop-yarn-client/lib/*\");";
  protected final String TEXT_250 = NL + "    \t\t//set default yarn classpath with environment variable" + NL + "    \t\tconfiguration_";
  protected final String TEXT_251 = ".set(\"yarn.application.classpath\",\"$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*\");";
  protected final String TEXT_252 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_253 = ".set(\"mapreduce.app-submission.cross-platform\",\"true\");";
  protected final String TEXT_254 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_255 = ".set(\"mapreduce.map.memory.mb\", ";
  protected final String TEXT_256 = ");" + NL + "\t\t\tconfiguration_";
  protected final String TEXT_257 = ".set(\"mapreduce.reduce.memory.mb\", ";
  protected final String TEXT_258 = ");" + NL + "\t\t\tconfiguration_";
  protected final String TEXT_259 = ".set(\"yarn.app.mapreduce.am.resource.mb\", ";
  protected final String TEXT_260 = ");";
  protected final String TEXT_261 = NL + "\t\tconfiguration_";
  protected final String TEXT_262 = ".set(\"mapred.job.tracker\", ";
  protected final String TEXT_263 = ");";
  protected final String TEXT_264 = NL + "        configuration_";
  protected final String TEXT_265 = ".set(\"mapred.job.map.memory.mb\", ";
  protected final String TEXT_266 = ");" + NL + "        configuration_";
  protected final String TEXT_267 = ".set(\"mapred.job.reduce.memory.mb\", ";
  protected final String TEXT_268 = ");";
  protected final String TEXT_269 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_270 = ".set(";
  protected final String TEXT_271 = " ,";
  protected final String TEXT_272 = ");";
  protected final String TEXT_273 = NL + "\t\tconfiguration_";
  protected final String TEXT_274 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_275 = ");";
  protected final String TEXT_276 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_277 = ".set(\"mapreduce.jobtracker.kerberos.principal\", ";
  protected final String TEXT_278 = ");";
  protected final String TEXT_279 = NL + "\t\t\tconfiguration_";
  protected final String TEXT_280 = ".set(\"yarn.resourcemanager.principal\", ";
  protected final String TEXT_281 = ");" + NL + "\t\t\tconfiguration_";
  protected final String TEXT_282 = ".set(\"mapreduce.jobhistory.principal\", ";
  protected final String TEXT_283 = ");";
  protected final String TEXT_284 = NL + "\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_285 = ", ";
  protected final String TEXT_286 = ");";
  protected final String TEXT_287 = NL + "        configuration_";
  protected final String TEXT_288 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_289 = NL + "\t//check whether we can connect to the fs?" + NL + "\torg.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_290 = " = org.apache.hadoop.fs.FileSystem.get(configuration_";
  protected final String TEXT_291 = ");" + NL + "\tString jarFileName_";
  protected final String TEXT_292 = " = ";
  protected final String TEXT_293 = ";";
  protected final String TEXT_294 = NL + "        com.cloudera.sqoop.SqoopOptions needGenereateJarSqoopOptions_";
  protected final String TEXT_295 = " = new com.cloudera.sqoop.SqoopOptions(configuration_";
  protected final String TEXT_296 = ");" + NL + "        needGenereateJarSqoopOptions_";
  protected final String TEXT_297 = ".setConnectString(";
  protected final String TEXT_298 = "); // __CONNECTION__" + NL + "        needGenereateJarSqoopOptions_";
  protected final String TEXT_299 = ".setUsername(";
  protected final String TEXT_300 = ");" + NL + "        ";
  protected final String TEXT_301 = NL + "        ";
  protected final String TEXT_302 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_303 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_304 = ");";
  protected final String TEXT_305 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_306 = " = ";
  protected final String TEXT_307 = "; ";
  protected final String TEXT_308 = NL + "\t\t        " + NL + "        " + NL + "        needGenereateJarSqoopOptions_";
  protected final String TEXT_309 = ".setPassword(decryptedPassword_";
  protected final String TEXT_310 = ");" + NL + "        needGenereateJarSqoopOptions_";
  protected final String TEXT_311 = ".setTableName(";
  protected final String TEXT_312 = ");";
  protected final String TEXT_313 = NL + "            needGenereateJarSqoopOptions_";
  protected final String TEXT_314 = ".setClassName(";
  protected final String TEXT_315 = ");";
  protected final String TEXT_316 = NL + "            needGenereateJarSqoopOptions_";
  protected final String TEXT_317 = ".setClassName(\"SqoopMerge_";
  protected final String TEXT_318 = "\");";
  protected final String TEXT_319 = NL + NL + "        java.util.Properties generateJarAdditionalProperties_";
  protected final String TEXT_320 = " = new java.util.Properties();";
  protected final String TEXT_321 = " " + NL + "                    generateJarAdditionalProperties_";
  protected final String TEXT_322 = ".put(";
  protected final String TEXT_323 = ", \"\"+";
  protected final String TEXT_324 = ".codePointAt(0)); ";
  protected final String TEXT_325 = " " + NL + "                    generateJarAdditionalProperties_";
  protected final String TEXT_326 = ".put(";
  protected final String TEXT_327 = ", ";
  protected final String TEXT_328 = "); ";
  protected final String TEXT_329 = NL + "        needGenereateJarSqoopOptions_";
  protected final String TEXT_330 = ".loadProperties(generateJarAdditionalProperties_";
  protected final String TEXT_331 = ");" + NL + "        " + NL + "        com.cloudera.sqoop.tool.CodeGenTool codeGen_";
  protected final String TEXT_332 = " = new com.cloudera.sqoop.tool.CodeGenTool();" + NL + "        com.cloudera.sqoop.Sqoop codeGenerator_";
  protected final String TEXT_333 = " = new com.cloudera.sqoop.Sqoop(codeGen_";
  protected final String TEXT_334 = ",configuration_";
  protected final String TEXT_335 = ", needGenereateJarSqoopOptions_";
  protected final String TEXT_336 = ");" + NL + "        " + NL + "\t\ttry {" + NL + "\t\t\tint ret_";
  protected final String TEXT_337 = " = com.cloudera.sqoop.Sqoop.runSqoop(codeGenerator_";
  protected final String TEXT_338 = ", new String[0]);" + NL + "       \tif (0 != ret_";
  protected final String TEXT_339 = ") {";
  protected final String TEXT_340 = NL + "\t\t\t\t\tthrow new Exception(\"The Sqoop jar generation has failed with the following code:\" + ret_";
  protected final String TEXT_341 = ");";
  protected final String TEXT_342 = NL + "\t\t\t\t\tSystem.err.println(\"The Sqoop jar generation has failed with the following code:\" + ret_";
  protected final String TEXT_343 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_344 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_345 = " - The Sqoop jar generation has failed with the following code:\" + ret_";
  protected final String TEXT_346 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_347 = NL + "        \t}" + NL + "        " + NL + "        List<String> jars_";
  protected final String TEXT_348 = " = codeGen_";
  protected final String TEXT_349 = ".getGeneratedJarFiles();" + NL + "        jarFileName_";
  protected final String TEXT_350 = " = jars_";
  protected final String TEXT_351 = ".get(0);" + NL + "\t\t} catch (Exception e) {";
  protected final String TEXT_352 = NL + "\t\t\t\tthrow e;";
  protected final String TEXT_353 = NL + "\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_354 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_355 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_356 = NL + "\t\t}";
  protected final String TEXT_357 = NL + NL + "    java.net.URLClassLoader sysloader_";
  protected final String TEXT_358 = " = (java.net.URLClassLoader) ClassLoader.getSystemClassLoader();" + NL + "    java.lang.reflect.Method method_";
  protected final String TEXT_359 = " = java.net.URLClassLoader.class.getDeclaredMethod(\"addURL\", new Class[] { java.net.URL.class});" + NL + "    method_";
  protected final String TEXT_360 = ".setAccessible(true);" + NL + "    try {" + NL + "\t\tmethod_";
  protected final String TEXT_361 = ".invoke(sysloader_";
  protected final String TEXT_362 = ", new Object[] { new java.io.File(jarFileName_";
  protected final String TEXT_363 = ").toURL()});" + NL + "    } catch (Exception e) {";
  protected final String TEXT_364 = NL + "\t\t\tthrow e;";
  protected final String TEXT_365 = NL + "\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_366 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_367 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_368 = NL + "    }" + NL + "    " + NL + "    com.cloudera.sqoop.tool.SqoopTool sqoopTool_";
  protected final String TEXT_369 = " = com.cloudera.sqoop.tool.SqoopTool.getTool(\"merge\");" + NL + "" + NL + "    com.cloudera.sqoop.SqoopOptions sqoopOptions_";
  protected final String TEXT_370 = " = new com.cloudera.sqoop.SqoopOptions(configuration_";
  protected final String TEXT_371 = ");" + NL + "" + NL + "\tsqoopOptions_";
  protected final String TEXT_372 = ".setMergeOldPath(";
  protected final String TEXT_373 = ");" + NL + "\tsqoopOptions_";
  protected final String TEXT_374 = ".setMergeNewPath(";
  protected final String TEXT_375 = ");" + NL + "\tsqoopOptions_";
  protected final String TEXT_376 = ".setMergeKeyCol(";
  protected final String TEXT_377 = ");" + NL + "\tsqoopOptions_";
  protected final String TEXT_378 = ".setTargetDir(";
  protected final String TEXT_379 = "); ";
  protected final String TEXT_380 = NL + "\t\tsqoopOptions_";
  protected final String TEXT_381 = ".setClassName(";
  protected final String TEXT_382 = ");";
  protected final String TEXT_383 = NL + "\t\tsqoopOptions_";
  protected final String TEXT_384 = ".setClassName(\"SqoopMerge_";
  protected final String TEXT_385 = "\");";
  protected final String TEXT_386 = NL + "\t\t" + NL + "\torg.apache.sqoop.Sqoop sqoop_";
  protected final String TEXT_387 = " = new org.apache.sqoop.Sqoop(sqoopTool_";
  protected final String TEXT_388 = ", configuration_";
  protected final String TEXT_389 = ", sqoopOptions_";
  protected final String TEXT_390 = ");" + NL + "\ttry {" + NL + "\t\tint result_";
  protected final String TEXT_391 = " = sqoop_";
  protected final String TEXT_392 = ".run(null);" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_393 = "_EXIT_CODE\", result_";
  protected final String TEXT_394 = ");" + NL + "\t\tif(result_";
  protected final String TEXT_395 = " != 0) {";
  protected final String TEXT_396 = NL + "\t\t\t\tthrow new Exception(\"The Sqoop merge job has failed. Please check the logs.\");";
  protected final String TEXT_397 = NL + "\t\t\t\tSystem.err.println(\"The Sqoop merge job has failed. Please check the logs.\");" + NL + "\t\t\t\t";
  protected final String TEXT_398 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_399 = " - The Sqoop merge job has failed. Please check the logs.\");" + NL + "\t\t\t\t";
  protected final String TEXT_400 = NL + "\t\t}" + NL + "\t} catch (Exception e) {";
  protected final String TEXT_401 = NL + "\t\t\tthrow e;";
  protected final String TEXT_402 = NL + "\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_403 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_404 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_405 = NL + "\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_406 = NL + "String currentClientPathSeparator_";
  protected final String TEXT_407 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "if(currentClientPathSeparator_";
  protected final String TEXT_408 = "!=null) {" + NL + "\tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_409 = ");" + NL + "\tglobalMap.put(\"current_client_path_separator\", null);" + NL + "}" + NL + "" + NL + "String originalHadoopUsername_";
  protected final String TEXT_410 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_411 = "\");" + NL + "if(originalHadoopUsername_";
  protected final String TEXT_412 = "!=null) {" + NL + "\tSystem.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_413 = ");" + NL + "\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_414 = "\", null);" + NL + "} else {" + NL + "\tSystem.clearProperty(\"HADOOP_USER_NAME\");" + NL + "}";

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
	
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	log4jFileUtil.componentStartInfo(node);
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    
    boolean useCommandLine = "true".equals(ElementParameterParser.getValue(node,"__USE_COMMANDLINE__"));
    
    if(useCommandLine) {

    stringBuffer.append(TEXT_30);
    
    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
    String table = ElementParameterParser.getValue(node,"__TABLE__");
    String username = ElementParameterParser.getValue(node,"__USERNAME__");
    boolean useMappers = "true".equals(ElementParameterParser.getValue(node,"__USE_MAPPERS__"));
    String mappers = ElementParameterParser.getValue(node,"__MAPPERS__");
    List<Map<String,String>> additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__ADDITIONAL__");
    boolean printLog = "true".equals(ElementParameterParser.getValue(node,"__PRINT_LOG__"));
    boolean verbose = "true".equals(ElementParameterParser.getValue(node,"__VERBOSE__"));
    String newDataDir = ElementParameterParser.getValue(node,"__NEWDATA__");
    String oldDataDir = ElementParameterParser.getValue(node,"__ONTO__");
    String targetDir = ElementParameterParser.getValue(node,"__TARGETDIR__");
    String jarFile = ElementParameterParser.getValue(node,"__JARFILE__");
    String className = ElementParameterParser.getValue(node,"__CLASSNAME__");
    String key = ElementParameterParser.getValue(node,"__MERGEKEY__");
    boolean needGenerateJar = "true".equals(ElementParameterParser.getValue(node,"__GENERATE__"));
	 boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
    

    stringBuffer.append(TEXT_31);
    if(needGenerateJar){
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    
	String passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_34);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_37);
    } else {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    if(printLog && verbose){
    stringBuffer.append(TEXT_47);
    }
    
	boolean isNull=false; 
	if(additionalList != null){ 
    for(Map<String,String> additionalMap : additionalList){ 
        isNull=false; 
        if(additionalMap.get("ADDITIONAL_VALUE")==null || "".equals(additionalMap.get("ADDITIONAL_VALUE"))) { 
            isNull=true; 
        } 
        if(!isNull) { 

    stringBuffer.append(TEXT_48);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(additionalMap.get("ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_50);
     
        } else { 

    stringBuffer.append(TEXT_51);
    stringBuffer.append(additionalMap.get("ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_52);
     
        } 
    } 
	} 

    stringBuffer.append(TEXT_53);
    
	if(isLog4jEnabled) {

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
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
    
	}

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
	    	if(printLog){

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
	    	}

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
	    	if(printLog){

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
	    	}

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
		if(dieOnError) {

    stringBuffer.append(TEXT_107);
    		
		} else {

    stringBuffer.append(TEXT_108);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    }
		}

    stringBuffer.append(TEXT_111);
    
	if(dieOnError) {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    		
	}

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    }

    stringBuffer.append(TEXT_122);
    
}

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(jarFile);
    stringBuffer.append(TEXT_126);
    if(needGenerateJar){
String bin_Dir = null;
String class_Name = null;
	for(Map<String,String> additionalMap : additionalList){
		if("--bindir".equals(additionalMap.get("ADDITIONAL_ARGUMENT"))){
 			bin_Dir = additionalMap.get("ADDITIONAL_VALUE");
 			break;
 		}
 	}
 	for(Map<String,String> additionalMap : additionalList){
 		if("--class-name".equals(additionalMap.get("ADDITIONAL_ARGUMENT"))){
 			class_Name = additionalMap.get("ADDITIONAL_VALUE");
 			break;
 		}
	}
	if(class_Name==null){
		class_Name = table;
	}

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(bin_Dir );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(class_Name);
    stringBuffer.append(TEXT_130);
    
}

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(newDataDir);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(oldDataDir);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(targetDir);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_138);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
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
    }
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
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
    
	    if(printLog){

    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
	    }

    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    }
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
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
    
    if(printLog){

    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    
	}

    stringBuffer.append(TEXT_192);
    
	if(dieOnError) {

    stringBuffer.append(TEXT_193);
    		
	} else {

    stringBuffer.append(TEXT_194);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    }
	}

    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    
	if(dieOnError) {

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    		
	}

    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    }
    stringBuffer.append(TEXT_211);
    
    } else {

    
	String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
	boolean isCustom = "CUSTOM".equals(distribution);
	String version = ElementParameterParser.getValue(node, "__DB_VERSION__");
	
	List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
	
	String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
	String jobtracker = ElementParameterParser.getValue(node, "__MAPRED_JOB_TRACKER__");
	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	List<Map<String,String>> additionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__ADDITIONAL_JAVA__");
	List<Map<String,String>> generateJarAdditionalList = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node,"__GENERATE_JAR_ADDITIONAL_JAVA__");
	boolean printLog = "true".equals(ElementParameterParser.getValue(node,"__PRINT_LOG__"));
	boolean verbose = "true".equals(ElementParameterParser.getValue(node,"__VERBOSE__"));
	String newDataDir = ElementParameterParser.getValue(node,"__NEWDATA__");
	String oldDataDir = ElementParameterParser.getValue(node,"__ONTO__");
	String targetDir = ElementParameterParser.getValue(node,"__TARGETDIR__");
	String jarFile = ElementParameterParser.getValue(node,"__JARFILE__");
	boolean customClassName = "true".equals(ElementParameterParser.getValue(node,"__CUSTOMCLASSNAME__"));
	String className = ElementParameterParser.getValue(node,"__CLASSNAME__");
	String key = ElementParameterParser.getValue(node,"__MERGEKEY__");
	boolean needGenerateJar = "true".equals(ElementParameterParser.getValue(node,"__GENERATE__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String table = ElementParameterParser.getValue(node,"__TABLE__");
	String username = ElementParameterParser.getValue(node,"__USERNAME__");
    boolean useDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));
    
	String fsDefalutName = "fs.default.name";
	
	boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    stringBuffer.append(TEXT_212);
    
	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
	String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");
	
	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_213);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    
	if(isCustom || (!isCustom && (version!=null && "HDP_1_2,HDP_1_3,HDP_2_0,HDP_2_1,HDP_2_2,Cloudera_CDH4,Cloudera_CDH4_YARN,Cloudera_CDH5,Cloudera_CDH5_1,Cloudera_CDH5_4,Cloudera_CDH5_1_MR1,PIVOTAL_HD_1_0_1,PIVOTAL_HD_2_0,APACHE_2_4_0_EMR".contains(version)))) {
		String hadoopUser = ElementParameterParser.getValue(node, "__HADOOP_USER__");

    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(hadoopUser);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    
	}

    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_226);
    

	if(!isCustom && ("MAPR401".equals(version) || "MAPR410".equals(version))) {//set the default properties

    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    
	}
	
	boolean isKerberosAvailableHadoop2 = !isCustom && ("PIVOTAL_HD_2_0".equals(version) || "HDP_2_0".equals(version) || "HDP_2_1".equals(version) || "HDP_2_2".equals(version) || "Cloudera_CDH4_YARN".equals(version) || "Cloudera_CDH5".equals(version) || "Cloudera_CDH5_1".equals(version) || "Cloudera_CDH5_4".equals(version));
	boolean isHadoop2 = "PIVOTAL_HD_1_0_1".equals(version) || "APACHE_2_4_0_EMR".equals(version) || "MAPR401".equals(version) || "MAPR410".equals(version) || isKerberosAvailableHadoop2;
	
	boolean isKerberosAvailableHadoop1 = !isCustom && ("HDP_1_2".equals(version) || "HDP_1_3".equals(version) || "Cloudera_CDH4".equals(version) || "Cloudera_CDH5_1_MR1".equals(version));
	
	if((isCustom && useYarn) || (!isCustom && isHadoop2)) {

    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_233);
    
		boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_JOBHISTORY_ADDRESS__"));
		if(setJobHistoryAddress) {
			String jobHistoryAddress = ElementParameterParser.getValue(node,"__JOBHISTORY_ADDRESS__");
			
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_236);
    
		}
		
		boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
		if(setSchedulerAddress) {
			String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_239);
    
		}
		boolean setStagingDirectory = "true".equals(ElementParameterParser.getValue(node, "__SET_STAGING_DIRECTORY__"));
		if(setStagingDirectory) {
			String stagingDirectory = ElementParameterParser.getValue(node, "__STAGING_DIRECTORY__");

    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(stagingDirectory);
    stringBuffer.append(TEXT_242);
    
		}
		
		if(!isCustom && ("HDP_2_1".equals(version) || "HDP_2_2".equals(version) || "Cloudera_CDH5".equals(version) || "Cloudera_CDH5_1".equals(version) || "Cloudera_CDH5_4".equals(version) || "MAPR401".equals(version) || "MAPR410".equals(version) || "APACHE_2_4_0_EMR".equals(version) || "APACHE_2_4_0_EMR_0_13_1".equals(version))) {

    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    
		}
		
		if(!isCustom && "HDP_2_1".equals(version)) {

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    
		} else if(!isCustom && "HDP_2_2".equals(version)) {

    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    
		} else {

    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    
		}
		
		boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
		if(isCustom && useYarn && crossPlatformSubmission) {

    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    
		}
		
		boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
		if(setMemory) {
			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_260);
    
		}
	} else {

    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(jobtracker);
    stringBuffer.append(TEXT_263);
    
	}
	
    if(!isCustom && ("HDP_1_2".equals(version) || "HDP_1_3".equals(version))) {
        String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
        String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_268);
    
    }
	if(hadoopProps!=null && hadoopProps.size() > 0){
		for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_272);
     
		}
	}
	if(useKrb) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
		boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
		String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
		String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_275);
    
		if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
			String jobTrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(jobTrackerPrincipal);
    stringBuffer.append(TEXT_278);
    
		}
		
		if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
			String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");
			String jobHistoryPrincipal = ElementParameterParser.getValue(node, "__JOBHISTORY_PRINCIPAL__");

    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(jobHistoryPrincipal);
    stringBuffer.append(TEXT_283);
    
		}

		if(useKeytab) {

    stringBuffer.append(TEXT_284);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_286);
    
		}
	}

    if (useDatanodeHostname) {
        
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    
    }

    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(jarFile);
    stringBuffer.append(TEXT_293);
    
    if(needGenerateJar){

    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_300);
    
        String passwordFieldName = "__PASSWORD__";
        
    stringBuffer.append(TEXT_301);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_304);
    } else {
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_307);
    }
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_312);
    if(customClassName){
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_315);
    }else{
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    }
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    
        if(generateJarAdditionalList != null){ 
            for(Map<String,String> generateJarAdditionalMap : generateJarAdditionalList){
                if(generateJarAdditionalMap.get("GENERATE_JAR_ADDITIONAL_VALUE")==null || "".equals(generateJarAdditionalMap.get("GENERATE_JAR_ADDITIONAL_VALUE"))) { 
                    break; 
                }
                if(generateJarAdditionalMap.get("GENERATE_JAR_ADDITIONAL_ARGUMENT").contains("delimiters")) {
                

    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(generateJarAdditionalMap.get("GENERATE_JAR_ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(generateJarAdditionalMap.get("GENERATE_JAR_ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_324);
    
                } else {

    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(generateJarAdditionalMap.get("GENERATE_JAR_ADDITIONAL_ARGUMENT"));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(generateJarAdditionalMap.get("GENERATE_JAR_ADDITIONAL_VALUE"));
    stringBuffer.append(TEXT_328);
    
                }
            } 
        } 

    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    
				if(dieOnError) {

    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    
				} else {

    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    }
				}

    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    
			if(dieOnError) {

    stringBuffer.append(TEXT_352);
    
			} else {

    stringBuffer.append(TEXT_353);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    }
			}

    stringBuffer.append(TEXT_356);
    
    }

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
    
		if(dieOnError) {

    stringBuffer.append(TEXT_364);
    
		} else {

    stringBuffer.append(TEXT_365);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    }
		}

    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(oldDataDir);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(newDataDir);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(targetDir);
    stringBuffer.append(TEXT_379);
    if(customClassName){
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_382);
    }else{
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    }
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    
			if(dieOnError) {

    stringBuffer.append(TEXT_396);
    
			} else {

    stringBuffer.append(TEXT_397);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    }
			}

    stringBuffer.append(TEXT_400);
    
		if(dieOnError) {

    stringBuffer.append(TEXT_401);
    
		} else {

    stringBuffer.append(TEXT_402);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    }
		}

    stringBuffer.append(TEXT_405);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    
    }
    

    return stringBuffer.toString();
  }
}
