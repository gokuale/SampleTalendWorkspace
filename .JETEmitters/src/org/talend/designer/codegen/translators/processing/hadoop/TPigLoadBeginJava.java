package org.talend.designer.codegen.translators.processing.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.Java2STLangTypesHelper;
import org.talend.designer.runprocess.ProcessorUtilities;
import org.talend.designer.runprocess.ProcessorException;
import java.util.List;
import java.util.Map;

public class TPigLoadBeginJava
{
  protected static String nl;
  public static synchronized TPigLoadBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigLoadBeginJava result = new TPigLoadBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_8 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_11 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_16 = " - Written records count: \" + nb_line_";
  protected final String TEXT_17 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_19 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_22 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Writing the record \" + nb_line_";
  protected final String TEXT_25 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - Processing the record \" + nb_line_";
  protected final String TEXT_28 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_30 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_31 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_32 = "\t";
  protected final String TEXT_33 = NL + "\t\t";
  protected final String TEXT_34 = NL + "\t\tclass GetJarsToRegister_";
  protected final String TEXT_35 = " {" + NL + "\t\t\tprivate String oozieClasspathLine;" + NL + "\t\t\tprivate boolean isOozieRuntime;" + NL + "\t\t\t" + NL + "\t\t\tpublic GetJarsToRegister_";
  protected final String TEXT_36 = "() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tthis.isOozieRuntime = setJarsToRegister();" + NL + "\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_38 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean setJarsToRegister() throws IOException, org.dom4j.DocumentException {" + NL + "\t\t\t\tString jobXmlPath = new java.io.File(\"../../job.xml\").getCanonicalPath();" + NL + "\t\t\t\tboolean isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\tif(!isOozieExecution) {" + NL + "\t\t\t\t    jobXmlPath = new java.io.File(\"./job.xml\").getCanonicalPath();" + NL + "\t\t\t\t    isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(isOozieExecution) {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.dom4j.io.SAXReader reader_oozie = new org.dom4j.io.SAXReader();" + NL + "\t\t\t\t\torg.dom4j.Document document_oozie = reader_oozie.read(jobXmlPath);" + NL + "\t\t\t\t\tList list_oozie = document_oozie.selectNodes(\"/configuration/property\");" + NL + "\t\t\t\t\tfor (java.util.Iterator iter_oozie = list_oozie.iterator(); iter_oozie.hasNext();) {" + NL + "\t\t\t\t\t\torg.dom4j.Element element_oozie = (org.dom4j.Element) iter_oozie.next();" + NL + "\t\t\t\t\t\tString name_oozie = element_oozie.elementText(\"name\");" + NL + "\t\t\t\t\t\tif(name_oozie.equals(\"mapred.cache.localFiles\") || name_oozie.equals(\"mapreduce.job.cache.local.files\")) {" + NL + "\t\t\t\t\t\t\tthis.oozieClasspathLine = element_oozie.elementText(\"value\");" + NL + "\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\t\treturn replaceJarPaths(originalClassPathLine, \"\");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine, String scheme) throws Exception {" + NL + "\t\t\t\tString classPathLine = \"\";" + NL + "\t\t\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\t\t\t" + NL + "\t\t\t\tif (isNeedAddLibsPath(crcMapPath)) {" + NL + "\t\t\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\t\t\tois.close();" + NL + "\t\t\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t\t\t} else if(this.isOozieRuntime) {" + NL + "\t\t\t\t\tif(this.oozieClasspathLine!=null) {" + NL + "\t\t\t\t\t\tList<String> oozieJars = java.util.Arrays.asList(this.oozieClasspathLine.split(\",\"));" + NL + "\t\t\t\t\t\tfor(int j=0; j<oozieJars.size(); j++) {" + NL + "\t\t\t\t\t\t\tif(oozieJars.get(j).contains(originalClassPathLine.substring(originalClassPathLine.lastIndexOf(\"/\")))) {" + NL + "\t\t\t\t\t\t\t\tclassPathLine = oozieJars.get(j);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tif(originalClassPathLine!=null && originalClassPathLine.startsWith(\".\")) {" + NL + "\t\t\t\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tclassPathLine = scheme + originalClassPathLine;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn classPathLine;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\t\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\t\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\t\t\tString jarName = entry.getValue();" + NL + "\t\t\t\tString crc = entry.getKey();" + NL + "\t\t\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\t\t\tString libStringFinder2 = \"./\" + jarName; // for the job jar itself." + NL + "\t\t\t\t" + NL + "\t\t\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.toLowerCase().contains(libStringFinder2)) {" + NL + "\t\t\t\t\tline = line.toLowerCase().replace(libStringFinder2, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t}" + NL + "\t\tGetJarsToRegister_";
  protected final String TEXT_40 = " getJarsToRegister_";
  protected final String TEXT_41 = " = new GetJarsToRegister_";
  protected final String TEXT_42 = "();";
  protected final String TEXT_43 = NL + "\t\tjava.util.Properties props_";
  protected final String TEXT_44 = " = new java.util.Properties();";
  protected final String TEXT_45 = NL + "\t\tprops_";
  protected final String TEXT_46 = ".put(org.apache.pig.impl.PigContext.JOB_NAME, projectName + \"_\" + jobName + \"_\" + jobVersion + \"_\" + \"";
  protected final String TEXT_47 = "\");";
  protected final String TEXT_48 = NL + "\ttry {";
  protected final String TEXT_49 = " " + NL + "\t\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_50 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "\t\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_53 = " = ";
  protected final String TEXT_54 = "; ";
  protected final String TEXT_55 = " " + NL + "\t\t\t\tfinal String wasbPassword_";
  protected final String TEXT_56 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "\t\t\t\tfinal String wasbPassword_";
  protected final String TEXT_59 = " = ";
  protected final String TEXT_60 = "; ";
  protected final String TEXT_61 = NL + "\t\t\t" + NL + "\t\t\tjava.io.File localPigLatin_";
  protected final String TEXT_62 = " = new java.io.File(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".pig\");" + NL + "\t\t\tjava.io.FileWriter fw_";
  protected final String TEXT_63 = " = new java.io.FileWriter(localPigLatin_";
  protected final String TEXT_64 = ".getAbsoluteFile());" + NL + "\t\t\tjava.io.BufferedWriter bw_";
  protected final String TEXT_65 = " = new java.io.BufferedWriter(fw_";
  protected final String TEXT_66 = ");" + NL + "\t\t\t" + NL + "\t\t\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_67 = " = new StringBuilder();" + NL + "\t\t\t" + NL + "\t\t\torg.talend.webhcat.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_68 = " = new org.talend.webhcat.launcher.fs.AzureFileSystem(\"DefaultEndpointsProtocol=https;\"" + NL + "\t\t\t\t+ \"AccountName=\"" + NL + "\t\t\t\t+ ";
  protected final String TEXT_69 = NL + "\t\t\t\t+ \";\"" + NL + "\t\t\t\t+ \"AccountKey=\" + wasbPassword_";
  protected final String TEXT_70 = ", ";
  protected final String TEXT_71 = ");" + NL + "\t\t\t" + NL + "\t\t\torg.talend.webhcat.launcher.common.Job instance_";
  protected final String TEXT_72 = " = new org.talend.webhcat.launcher.common.impl.PigJob(azureFs_";
  protected final String TEXT_73 = ", org.talend.webhcat.launcher.utils.JobType.PIG);" + NL + "\t\t\tinstance_";
  protected final String TEXT_74 = ".setAzureAccountName(";
  protected final String TEXT_75 = ");" + NL + "\t\t\tinstance_";
  protected final String TEXT_76 = ".setAzureAccountPassword(wasbPassword_";
  protected final String TEXT_77 = ");" + NL + "\t\t\tinstance_";
  protected final String TEXT_78 = ".setAzureStorageAddress(";
  protected final String TEXT_79 = ");" + NL + "\t\t\tinstance_";
  protected final String TEXT_80 = ".setAzureContainer(";
  protected final String TEXT_81 = ");" + NL + "\t\t\tinstance_";
  protected final String TEXT_82 = ".setHdInsightUsername(";
  protected final String TEXT_83 = ");" + NL + "\t\t\tinstance_";
  protected final String TEXT_84 = ".setHdInsightPassword(hdInsightPassword_";
  protected final String TEXT_85 = ");" + NL + "\t\t\tinstance_";
  protected final String TEXT_86 = ".setUsername(";
  protected final String TEXT_87 = ");" + NL + "\t\t\tinstance_";
  protected final String TEXT_88 = ".setWebhcatEndpoint(\"https\", ";
  protected final String TEXT_89 = " + \":\" + ";
  protected final String TEXT_90 = ");" + NL + "\t\t\tinstance_";
  protected final String TEXT_91 = ".setStatusFolder(org.talend.webhcat.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_92 = "));" + NL + "\t\t\tinstance_";
  protected final String TEXT_93 = ".setRemoteFolder(org.talend.webhcat.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_94 = "));" + NL + "\t\t\tinstance_";
  protected final String TEXT_95 = ".setFileToExecute(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".pig\");" + NL + "\t\t\t" + NL + "\t\t\tString wasbPath_";
  protected final String TEXT_96 = " = azureFs_";
  protected final String TEXT_97 = ".getFileSystemPrefix() + \"/\"\t+ instance_";
  protected final String TEXT_98 = ".getRemoteFolder()\t+ \"/libjars/\";";
  protected final String TEXT_99 = NL + "\t\t\torg.apache.pig.impl.PigContext context_";
  protected final String TEXT_100 = " = new org.apache.pig.impl.PigContext(org.apache.pig.ExecType.LOCAL, props_";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "\t\t\t\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\t\t\t\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_103 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_104 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_105 = NL + "\t\t\t\t\tString username_";
  protected final String TEXT_106 = " = ";
  protected final String TEXT_107 = ";" + NL + "\t\t\t\t\tif(username_";
  protected final String TEXT_108 = "!=null && !\"\".equals(username_";
  protected final String TEXT_109 = ".trim())) {" + NL + "\t\t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_110 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_111 = NL + "\t\t\t        props_";
  protected final String TEXT_112 = ".put(\"mapreduce.job.map.output.collector.class\", \"org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "\t\t\t        props_";
  protected final String TEXT_113 = ".put(\"mapreduce.job.reduce.shuffle.consumer.plugin.class\", \"org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_114 = NL + "                props_";
  protected final String TEXT_115 = ".put(\"fs.defaultFS\", ";
  protected final String TEXT_116 = ");" + NL + "                org.apache.hadoop.security.UserGroupInformation.setLoginUser(org.apache.hadoop.security.UserGroupInformation.createRemoteUser(username_";
  protected final String TEXT_117 = "));";
  protected final String TEXT_118 = NL + "                props_";
  protected final String TEXT_119 = ".put(\"fs.default.name\", ";
  protected final String TEXT_120 = ");";
  protected final String TEXT_121 = NL + "\t\t\t\tprops_";
  protected final String TEXT_122 = ".put(\"mapreduce.framework.name\", \"yarn\");" + NL + "\t\t\t\tprops_";
  protected final String TEXT_123 = ".put(\"yarn.resourcemanager.address\", ";
  protected final String TEXT_124 = ");";
  protected final String TEXT_125 = NL + "\t\t\t\t\tprops_";
  protected final String TEXT_126 = ".put(\"yarn.resourcemanager.scheduler.address\", ";
  protected final String TEXT_127 = ");";
  protected final String TEXT_128 = NL + "\t\t\t\t\tprops_";
  protected final String TEXT_129 = ".put(\"yarn.app.mapreduce.am.staging-dir\", ";
  protected final String TEXT_130 = ");";
  protected final String TEXT_131 = NL + "\t\t\t\t\tprops_";
  protected final String TEXT_132 = ".put(\"mapreduce.app-submission.cross-platform\",\"true\");";
  protected final String TEXT_133 = NL + "\t\t\t\t\tprops_";
  protected final String TEXT_134 = ".put(\"yarn.application.classpath\",\"/etc/hadoop/conf,/usr/lib/hadoop/*,/usr/lib/hadoop/lib/*,/usr/lib/hadoop-hdfs/*,/usr/lib/hadoop-hdfs/lib/*,/usr/lib/hadoop-yarn/*,/usr/lib/hadoop-yarn/lib/*,/usr/lib/hadoop-mapreduce/*,/usr/lib/hadoop-mapreduce/lib/*\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\t\t\tprops_";
  protected final String TEXT_136 = ".put(\"mapreduce.application.classpath\",\"$PWD/mr-framework/hadoop/share/hadoop/mapreduce/*:$PWD/mr-framework/hadoop/share/hadoop/mapreduce/lib/*:$PWD/mr-framework/hadoop/share/hadoop/common/*:$PWD/mr-framework/hadoop/share/hadoop/common/lib/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/lib/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/lib/*:/etc/hadoop/conf/secure\");" + NL + "\t\t\t\t\tprops_";
  protected final String TEXT_137 = ".put(\"yarn.application.classpath\",\"$HADOOP_CONF_DIR,/usr/hdp/current/hadoop-client/*,/usr/hdp/current/hadoop-client/lib/*,/usr/hdp/current/hadoop-hdfs-client/*,/usr/hdp/current/hadoop-hdfs-client/lib/*,/usr/hdp/current/hadoop-mapreduce-client/*,/usr/hdp/current/hadoop-mapreduce-client/lib/*,/usr/hdp/current/hadoop-yarn-client/*,/usr/hdp/current/hadoop-yarn-client/lib/*\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_138 = NL + "\t\t            props_";
  protected final String TEXT_139 = ".put(\"yarn.application.classpath\",\"$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*,/usr/share/aws/emr/emr-fs/lib/*,/usr/share/aws/emr/lib/*\");" + NL + "\t                ";
  protected final String TEXT_140 = NL + "\t\t            props_";
  protected final String TEXT_141 = ".put(\"yarn.application.classpath\",\"$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,/usr/lib/hadoop-lzo/lib/*,/usr/share/aws/emr/emrfs/conf, /usr/share/aws/emr/emrfs/lib/*,/usr/share/aws/emr/emrfs/auxlib/*,/usr/share/aws/emr/lib/*,/usr/share/aws/emr/ddb/lib/emr-ddb-hadoop.jar, /usr/share/aws/emr/goodies/lib/emr-hadoop-goodies.jar,/usr/share/aws/emr/kinesis/lib/emr-kinesis-hadoop.jar,/usr/lib/spark/yarn/lib/datanucleus-api-jdo.jar,/usr/lib/spark/yarn/lib/datanucleus-core.jar,/usr/lib/spark/yarn/lib/datanucleus-rdbms.jar,/usr/share/aws/emr/cloudwatch-sink/lib/*\");" + NL + "\t                ";
  protected final String TEXT_142 = NL + "    \t\t\t\t//set default yarn classpath with environment variable" + NL + "                    props_";
  protected final String TEXT_143 = ".put(\"yarn.application.classpath\",\"$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*\");" + NL + "    \t\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\t\tprops_";
  protected final String TEXT_145 = ".put(\"mapreduce.app-submission.cross-platform\",\"true\");";
  protected final String TEXT_146 = NL + "    \t\t\t\tprops_";
  protected final String TEXT_147 = ".put(\"mapreduce.map.memory.mb\", ";
  protected final String TEXT_148 = ");" + NL + "    \t\t\t\tprops_";
  protected final String TEXT_149 = ".put(\"mapreduce.reduce.memory.mb\", ";
  protected final String TEXT_150 = ");" + NL + "    \t\t\t\tprops_";
  protected final String TEXT_151 = ".put(\"yarn.app.mapreduce.am.resource.mb\", ";
  protected final String TEXT_152 = ");";
  protected final String TEXT_153 = NL + "\t\t\t\t\tprops_";
  protected final String TEXT_154 = ".put(\"mapreduce.jobhistory.address\", ";
  protected final String TEXT_155 = ");";
  protected final String TEXT_156 = NL + "\t\t\t\tprops_";
  protected final String TEXT_157 = ".put(\"mapred.job.tracker\", ";
  protected final String TEXT_158 = ");";
  protected final String TEXT_159 = NL + "\t\t\t\tprops_";
  protected final String TEXT_160 = ".put(\"hcat.metastore.uri\", ";
  protected final String TEXT_161 = ");";
  protected final String TEXT_162 = NL + "\t\t\t\tprops_";
  protected final String TEXT_163 = ".put(\"hbase.zookeeper.quorum\", ";
  protected final String TEXT_164 = ");" + NL + "\t\t\t\tprops_";
  protected final String TEXT_165 = ".put(\"hbase.zookeeper.property.clientPort\", ";
  protected final String TEXT_166 = ");";
  protected final String TEXT_167 = NL + "\t\t\t\tprops_";
  protected final String TEXT_168 = ".put(\"zookeeper.znode.parent\",";
  protected final String TEXT_169 = "); ";
  protected final String TEXT_170 = NL + "\t\t\t\tprops_";
  protected final String TEXT_171 = ".put(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_172 = ");" + NL + "\t\t\t\tprops_";
  protected final String TEXT_173 = ".put(\"hbase.security.authentication\",\"kerberos\"); " + NL + "\t\t\t\tprops_";
  protected final String TEXT_174 = ".put(\"hbase.regionserver.kerberos.principal\",";
  protected final String TEXT_175 = ");" + NL + "\t\t\t\tprops_";
  protected final String TEXT_176 = ".put(\"hbase.master.kerberos.principal\",";
  protected final String TEXT_177 = ");";
  protected final String TEXT_178 = NL + "\t\t\t\t\tprops_";
  protected final String TEXT_179 = ".put(\"mapreduce.jobtracker.kerberos.principal\", ";
  protected final String TEXT_180 = ");";
  protected final String TEXT_181 = NL + "\t\t\t\t\tprops_";
  protected final String TEXT_182 = ".put(\"yarn.resourcemanager.principal\", ";
  protected final String TEXT_183 = ");" + NL + "\t\t\t\t\tprops_";
  protected final String TEXT_184 = ".put(\"mapreduce.jobhistory.principal\", ";
  protected final String TEXT_185 = ");";
  protected final String TEXT_186 = NL + "\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_187 = ", ";
  protected final String TEXT_188 = ");";
  protected final String TEXT_189 = NL + "\t\t        props_";
  protected final String TEXT_190 = ".put(\"mapred.job.map.memory.mb\", ";
  protected final String TEXT_191 = ");" + NL + "\t\t        props_";
  protected final String TEXT_192 = ".put(\"mapred.job.reduce.memory.mb\", ";
  protected final String TEXT_193 = ");";
  protected final String TEXT_194 = NL + "\t\t\t\t\tprops_";
  protected final String TEXT_195 = ".put(";
  protected final String TEXT_196 = " ,";
  protected final String TEXT_197 = ");";
  protected final String TEXT_198 = NL + "                props_";
  protected final String TEXT_199 = ".put(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_200 = NL + "\t\t\t\torg.apache.pig.impl.PigContext context_";
  protected final String TEXT_201 = " = new org.apache.pig.impl.PigContext(new org.apache.pig.backend.hadoop.executionengine.tez.TezExecType(), props_";
  protected final String TEXT_202 = ");" + NL + "\t\t\t";
  protected final String TEXT_203 = "            " + NL + "\t\t\t\torg.apache.pig.impl.PigContext context_";
  protected final String TEXT_204 = " = new org.apache.pig.impl.PigContext(org.apache.pig.ExecType.MAPREDUCE, props_";
  protected final String TEXT_205 = ");" + NL + "\t\t\t";
  protected final String TEXT_206 = " " + NL + "                String decryptedS3Password_";
  protected final String TEXT_207 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_208 = ");";
  protected final String TEXT_209 = NL + "                String decryptedS3Password_";
  protected final String TEXT_210 = " = ";
  protected final String TEXT_211 = "; ";
  protected final String TEXT_212 = NL + "\t\t\t\torg.apache.pig.PigServer pigServer_";
  protected final String TEXT_213 = " = new org.apache.pig.PigServer(context_";
  protected final String TEXT_214 = ");" + NL + "\t\t\t\tpigServer_";
  protected final String TEXT_215 = ".setBatchOn();";
  protected final String TEXT_216 = NL + "\t\t\t//store the pig script in the lookup process" + NL + "\t\t\tjava.util.List<String[]> pigScript_";
  protected final String TEXT_217 = " = new java.util.ArrayList<String[]>();";
  protected final String TEXT_218 = NL + "\t\troutines.system.PigHelper helper_";
  protected final String TEXT_219 = " = new routines.system.PigHelper();" + NL + "\t\t";
  protected final String TEXT_220 = NL + "\t\tStringBuilder script_";
  protected final String TEXT_221 = "=new StringBuilder();";
  protected final String TEXT_222 = NL + "\t\tscript_";
  protected final String TEXT_223 = ".append(\"SET \"+";
  protected final String TEXT_224 = "+\" \"+";
  protected final String TEXT_225 = "+\";\");";
  protected final String TEXT_226 = NL + "\t\tscript_";
  protected final String TEXT_227 = ".append(\"SET output.compression.enabled true;\");";
  protected final String TEXT_228 = NL + "\t\tscript_";
  protected final String TEXT_229 = ".append(\"SET output.compression.codec org.apache.hadoop.io.compress.GzipCodec;\");";
  protected final String TEXT_230 = NL + "\t\tscript_";
  protected final String TEXT_231 = ".append(\"SET output.compression.codec org.apache.hadoop.io.compress.BZip2Codec;\");";
  protected final String TEXT_232 = NL + "\t\tscript_";
  protected final String TEXT_233 = ".append(\"SET hbase.zookeeper.quorum \").append(";
  protected final String TEXT_234 = ").append(\";\");" + NL + "\t\tscript_";
  protected final String TEXT_235 = ".append(\"SET hbase.zookeeper.property.clientPort \").append(";
  protected final String TEXT_236 = ").append(\";\");";
  protected final String TEXT_237 = NL + "\t\t\tscript_";
  protected final String TEXT_238 = ".append(\"SET zookeeper.znode.parent \").append(";
  protected final String TEXT_239 = ").append(\";\");";
  protected final String TEXT_240 = NL + "    \t\t\t\t\tSystem.err.println(\"Please set the path of Tez lib in 'Tez lib path'!\");" + NL + "    \t\t\t\t";
  protected final String TEXT_241 = NL + "\t\t\t\t";
  protected final String TEXT_242 = NL;
  protected final String TEXT_243 = NL + "        String hdfs_username_";
  protected final String TEXT_244 = " = (";
  protected final String TEXT_245 = " != null && !\"\".equals(";
  protected final String TEXT_246 = ")) ? ";
  protected final String TEXT_247 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_248 = " = null;";
  protected final String TEXT_249 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_250 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_251 = ".set(\"fs.default.name\", ";
  protected final String TEXT_252 = ");" + NL + "        ";
  protected final String TEXT_253 = NL + "            conf_";
  protected final String TEXT_254 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_255 = NL + "        \t\tconf_";
  protected final String TEXT_256 = ".set(";
  protected final String TEXT_257 = " ,";
  protected final String TEXT_258 = ");" + NL + "        \t";
  protected final String TEXT_259 = NL + "    \t\tconf_";
  protected final String TEXT_260 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_261 = ");" + NL + "    \t\t";
  protected final String TEXT_262 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_263 = ", ";
  protected final String TEXT_264 = ");" + NL + "    \t\t";
  protected final String TEXT_265 = NL + "\t\t\tconf_";
  protected final String TEXT_266 = ".set(\"hadoop.job.ugi\",hdfs_username_";
  protected final String TEXT_267 = "+\",\"+";
  protected final String TEXT_268 = ");" + NL + "        \tfs_";
  protected final String TEXT_269 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_270 = ");";
  protected final String TEXT_271 = NL + "        \t" + NL + "        \tif(hdfs_username_";
  protected final String TEXT_272 = " == null || \"\".equals(hdfs_username_";
  protected final String TEXT_273 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_274 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_275 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_276 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_277 = ".get(\"fs.default.name\")),conf_";
  protected final String TEXT_278 = ",hdfs_username_";
  protected final String TEXT_279 = ");" + NL + "        \t}\t";
  protected final String TEXT_280 = NL + "\t\t\t\t";
  protected final String TEXT_281 = NL + "\t\t\t\t\tString hdfsUserName_";
  protected final String TEXT_282 = " = (";
  protected final String TEXT_283 = " != null && !\"\".equals(";
  protected final String TEXT_284 = ")) ? ";
  protected final String TEXT_285 = " : System.getProperty(\"user.name\");" + NL + "\t    \t\t\tString tezLibPath_";
  protected final String TEXT_286 = " = \"/tmp/\" + hdfsUserName_";
  protected final String TEXT_287 = " + \"/talend_tez_libs/";
  protected final String TEXT_288 = "\";" + NL + "\t\t\t\t";
  protected final String TEXT_289 = NL + "\t\t\t\t\tString tezLibPath_";
  protected final String TEXT_290 = " = ";
  protected final String TEXT_291 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_292 = NL + "\t\t\t\tfs_";
  protected final String TEXT_293 = ".mkdirs(new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_294 = "));" + NL + "\t\t\t\t";
  protected final String TEXT_295 = NL + "\t\t\t\tString[] classPaths_";
  protected final String TEXT_296 = " = System.getProperty(\"java.class.path\").split(";
  protected final String TEXT_297 = "String.valueOf(globalMap.get(\"current_client_path_separator\"))";
  protected final String TEXT_298 = "System.getProperty(\"path.separator\")";
  protected final String TEXT_299 = ");" + NL + "\t\t\t\tfor(String classPath_";
  protected final String TEXT_300 = " : classPaths_";
  protected final String TEXT_301 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_302 = NL + "\t\t\t\t\t\tif(classPath_";
  protected final String TEXT_303 = ".endsWith(\"";
  protected final String TEXT_304 = "\")){" + NL + "\t\t\t\t\t\t\torg.apache.hadoop.fs.Path tezJarPath_";
  protected final String TEXT_305 = " = new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_306 = " + \"/";
  protected final String TEXT_307 = "\");" + NL + "\t\t\t\t\t\t\tif(!fs_";
  protected final String TEXT_308 = ".exists(tezJarPath_";
  protected final String TEXT_309 = ")){" + NL + "\t\t\t\t\t\t\t\tfs_";
  protected final String TEXT_310 = ".copyFromLocalFile(false, false, new org.apache.hadoop.fs.Path(classPath_";
  protected final String TEXT_311 = "), tezJarPath_";
  protected final String TEXT_312 = ");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_313 = NL + "\t    \t\t}" + NL + "\t\t\t";
  protected final String TEXT_314 = NL + "\t\t\t\tString tezLibPath_";
  protected final String TEXT_315 = " = ";
  protected final String TEXT_316 = ";" + NL + "\t\t\t";
  protected final String TEXT_317 = NL + "\t\t\tString[] tezLibPaths_";
  protected final String TEXT_318 = " = tezLibPath_";
  protected final String TEXT_319 = ".split(\",\");" + NL + "\t\t\tscript_";
  protected final String TEXT_320 = ".append(\"SET tez.lib.uris \");" + NL + "\t\t\tint tezLibPathCount_";
  protected final String TEXT_321 = " = 1;" + NL + "\t\t\tfor(String tezLibPathKey_";
  protected final String TEXT_322 = " : tezLibPaths_";
  protected final String TEXT_323 = "){" + NL + "\t\t\t\t script_";
  protected final String TEXT_324 = ".append(";
  protected final String TEXT_325 = " + \"/\" + tezLibPathKey_";
  protected final String TEXT_326 = ");" + NL + "\t\t\t\t if(tezLibPathCount_";
  protected final String TEXT_327 = " < tezLibPaths_";
  protected final String TEXT_328 = ".length){" + NL + "\t\t\t\t \tscript_";
  protected final String TEXT_329 = ".append(\",\");" + NL + "\t\t\t\t }" + NL + "\t\t\t\t tezLibPathCount_";
  protected final String TEXT_330 = "++;" + NL + "\t\t\t}" + NL + "\t\t\tscript_";
  protected final String TEXT_331 = ".append(\";\");" + NL + "\t\t";
  protected final String TEXT_332 = NL + "\t\thelper_";
  protected final String TEXT_333 = ".add(\"script\",script_";
  protected final String TEXT_334 = ".toString());";
  protected final String TEXT_335 = NL + NL + "\t\tStringBuilder sb_";
  protected final String TEXT_336 = " = new StringBuilder();" + NL;
  protected final String TEXT_337 = NL + "\t\t\t\t\t\thelper_";
  protected final String TEXT_338 = ".add(\"jar\",getJarsToRegister_";
  protected final String TEXT_339 = ".replaceJarPaths(\"";
  protected final String TEXT_340 = "\"));";
  protected final String TEXT_341 = NL + "\t\t\t\thelper_";
  protected final String TEXT_342 = ".add(\"function\", ";
  protected final String TEXT_343 = " ,";
  protected final String TEXT_344 = ");";
  protected final String TEXT_345 = NL + "\t\t\t\t\t\thelper_";
  protected final String TEXT_346 = ".add(\"jar\",";
  protected final String TEXT_347 = ");";
  protected final String TEXT_348 = NL + "\t\t\t" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.uris\", ";
  protected final String TEXT_349 = ");" + NL + "\t\t\tsb_";
  protected final String TEXT_350 = ".append(\"";
  protected final String TEXT_351 = "_";
  protected final String TEXT_352 = "_RESULT";
  protected final String TEXT_353 = " = LOAD '\"+";
  protected final String TEXT_354 = "+\".\"+";
  protected final String TEXT_355 = "+\"' using ";
  protected final String TEXT_356 = ".";
  protected final String TEXT_357 = "()\");";
  protected final String TEXT_358 = NL + "\t            sb_";
  protected final String TEXT_359 = ".append(\"";
  protected final String TEXT_360 = "_";
  protected final String TEXT_361 = "_RESULT = LOAD '\" + \"s3n://\" + ";
  protected final String TEXT_362 = " +\":\" + decryptedS3Password_";
  protected final String TEXT_363 = " + \"@\" + ";
  protected final String TEXT_364 = NL + "\t                + \"' using com.twitter.elephantbird.pig.load.SequenceFileLoader('-c ";
  protected final String TEXT_365 = "','-c ";
  protected final String TEXT_366 = "')\");" + NL + "\t            ";
  protected final String TEXT_367 = NL + "\t            sb_";
  protected final String TEXT_368 = ".append(\"";
  protected final String TEXT_369 = "_";
  protected final String TEXT_370 = "_RESULT = LOAD '\" + ";
  protected final String TEXT_371 = " +" + NL + "\t                \"' using com.twitter.elephantbird.pig.load.SequenceFileLoader('-c ";
  protected final String TEXT_372 = "','-c ";
  protected final String TEXT_373 = "')\");" + NL + "\t            ";
  protected final String TEXT_374 = NL + "\t\t\t\tsb_";
  protected final String TEXT_375 = ".append(\" AS (\");" + NL + "\t\t\t\tsb_";
  protected final String TEXT_376 = ".append(\"";
  protected final String TEXT_377 = ":";
  protected final String TEXT_378 = ", ";
  protected final String TEXT_379 = ":";
  protected final String TEXT_380 = "\");" + NL + "\t\t\t\tsb_";
  protected final String TEXT_381 = ".append(\")\");";
  protected final String TEXT_382 = NL + "\t                sb_";
  protected final String TEXT_383 = ".append(\"";
  protected final String TEXT_384 = "_";
  protected final String TEXT_385 = "_RESULT = LOAD '\" + \"s3n://\" + ";
  protected final String TEXT_386 = " +\":\" + decryptedS3Password_";
  protected final String TEXT_387 = " + \"@\" + ";
  protected final String TEXT_388 = NL + "\t                    + \"' using \" + ";
  protected final String TEXT_389 = ");" + NL + "\t                ";
  protected final String TEXT_390 = NL + "\t                sb_";
  protected final String TEXT_391 = ".append(\"";
  protected final String TEXT_392 = "_";
  protected final String TEXT_393 = "_RESULT = LOAD '\"+";
  protected final String TEXT_394 = "+\"' using \" + ";
  protected final String TEXT_395 = ");" + NL + "\t                ";
  protected final String TEXT_396 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_397 = ".append(\"";
  protected final String TEXT_398 = "_";
  protected final String TEXT_399 = "_RESULT = LOAD 'hbase://\").append(";
  protected final String TEXT_400 = ").append(\"' using org.apache.pig.backend.hadoop.hbase.HBaseStorage('\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_401 = NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_402 = ".append(";
  protected final String TEXT_403 = ");";
  protected final String TEXT_404 = NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_405 = ".append(\" \");";
  protected final String TEXT_406 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_407 = ".append(\"'\");";
  protected final String TEXT_408 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_409 = ".append(\",'-loadKey true\");";
  protected final String TEXT_410 = NL + "\t\t\t\t\t\t\t\tsb_";
  protected final String TEXT_411 = ".append(\",'\");";
  protected final String TEXT_412 = NL + "\t\t\t\t\t\t\t\tsb_";
  protected final String TEXT_413 = ".append(\" \");";
  protected final String TEXT_414 = NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_415 = ".append(\"-";
  protected final String TEXT_416 = " \").append(";
  protected final String TEXT_417 = ");";
  protected final String TEXT_418 = NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_419 = ".append(\" \");";
  protected final String TEXT_420 = NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_421 = ".append(\"'\");";
  protected final String TEXT_422 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_423 = ".append(\"'\");";
  protected final String TEXT_424 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_425 = ".append(\")\");";
  protected final String TEXT_426 = NL + "\t                    sb_";
  protected final String TEXT_427 = ".append(\"";
  protected final String TEXT_428 = "_";
  protected final String TEXT_429 = "_RESULT = LOAD '\" + \"s3n://\" + ";
  protected final String TEXT_430 = " +\":\" + decryptedS3Password_";
  protected final String TEXT_431 = " + \"@\" + ";
  protected final String TEXT_432 = NL + "\t                        + \"' using parquet.pig.ParquetLoader\");" + NL + "\t                    ";
  protected final String TEXT_433 = NL + "\t                    sb_";
  protected final String TEXT_434 = ".append(\"";
  protected final String TEXT_435 = "_";
  protected final String TEXT_436 = "_RESULT = LOAD '\"+";
  protected final String TEXT_437 = "+\"' using parquet.pig.ParquetLoader\");" + NL + "\t                    ";
  protected final String TEXT_438 = NL + "                        sb_";
  protected final String TEXT_439 = ".append(\"";
  protected final String TEXT_440 = "_";
  protected final String TEXT_441 = "_RESULT = LOAD '\" + \"s3n://\" + ";
  protected final String TEXT_442 = " +\":\" + decryptedS3Password_";
  protected final String TEXT_443 = " + \"@\" + ";
  protected final String TEXT_444 = NL + "                            + \"' using ";
  protected final String TEXT_445 = "(";
  protected final String TEXT_446 = ")\");";
  protected final String TEXT_447 = NL + "                        sb_";
  protected final String TEXT_448 = ".append(\"";
  protected final String TEXT_449 = "_";
  protected final String TEXT_450 = "_RESULT = LOAD '\"+";
  protected final String TEXT_451 = "+\"' using ";
  protected final String TEXT_452 = "(";
  protected final String TEXT_453 = ")\");";
  protected final String TEXT_454 = NL + "\t\t\t\t\t\tsb_";
  protected final String TEXT_455 = ".append(\" AS (\");";
  protected final String TEXT_456 = NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_457 = ".append(\"";
  protected final String TEXT_458 = ":";
  protected final String TEXT_459 = "\");";
  protected final String TEXT_460 = NL + "\t\t\t\t\t\tsb_";
  protected final String TEXT_461 = ".append(\")\");";
  protected final String TEXT_462 = NL + "\t\tsb_";
  protected final String TEXT_463 = ".append(\";\");" + NL + "\t\t" + NL + "\t\thelper_";
  protected final String TEXT_464 = ".add(\"query\",sb_";
  protected final String TEXT_465 = ".toString());";
  protected final String TEXT_466 = NL + "\t\t\t\tsb_";
  protected final String TEXT_467 = " = new StringBuilder();" + NL + "\t\t\t\tsb_";
  protected final String TEXT_468 = ".append(\"";
  protected final String TEXT_469 = "_";
  protected final String TEXT_470 = "_RESULT = FILTER ";
  protected final String TEXT_471 = "_";
  protected final String TEXT_472 = "_RESULT_TEMP BY \");";
  protected final String TEXT_473 = NL + "\t\t\t\t\t\tsb_";
  protected final String TEXT_474 = ".append(\" AND \");";
  protected final String TEXT_475 = NL + "\t\t\t\t\tsb_";
  protected final String TEXT_476 = ".append(\"(\" + ";
  protected final String TEXT_477 = ");" + NL + "\t\t\t\t\tsb_";
  protected final String TEXT_478 = ".append(\" == \");" + NL + "\t\t\t\t\tsb_";
  protected final String TEXT_479 = ".append(";
  protected final String TEXT_480 = " + \")\");";
  protected final String TEXT_481 = NL + "\t\t\t\tsb_";
  protected final String TEXT_482 = ".append(\";\");" + NL + "\t\t\t\t\t" + NL + "\t\t\t\thelper_";
  protected final String TEXT_483 = ".add(\"query\",sb_";
  protected final String TEXT_484 = ".toString());";
  protected final String TEXT_485 = NL + NL + "\t\t";
  protected final String TEXT_486 = NL + "\tjava.util.List<String[]> pigLatins_";
  protected final String TEXT_487 = " = helper_";
  protected final String TEXT_488 = ".getPigLatins();";
  protected final String TEXT_489 = NL + "\t\tfor(String[] pigLatin_";
  protected final String TEXT_490 = " : pigLatins_";
  protected final String TEXT_491 = ") {" + NL + "\t\t\tString type_";
  protected final String TEXT_492 = " = pigLatin_";
  protected final String TEXT_493 = "[0];" + NL + "\t\t\t";
  protected final String TEXT_494 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_495 = " - register \" + type_";
  protected final String TEXT_496 = " + \" : \" + pigLatin_";
  protected final String TEXT_497 = "[1]);" + NL + "\t\t\t";
  protected final String TEXT_498 = NL + "\t\t\tif(\"query\".equals(type_";
  protected final String TEXT_499 = ")) {";
  protected final String TEXT_500 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_501 = ".write(pigLatin_";
  protected final String TEXT_502 = "[1]);";
  protected final String TEXT_503 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_504 = ".registerQuery(pigLatin_";
  protected final String TEXT_505 = "[1]);";
  protected final String TEXT_506 = NL + "\t\t\t} else if(\"jar\".equals(type_";
  protected final String TEXT_507 = ")) {";
  protected final String TEXT_508 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_509 = ".write(\"REGISTER \" + wasbPath_";
  protected final String TEXT_510 = " + new java.io.File(pigLatin_";
  protected final String TEXT_511 = "[1]).getName() + \";\");" + NL + "\t\t\t\t\tlibjars_";
  protected final String TEXT_512 = ".append(pigLatin_";
  protected final String TEXT_513 = "[1] + \",\");";
  protected final String TEXT_514 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_515 = ".registerJar(pigLatin_";
  protected final String TEXT_516 = "[1]);";
  protected final String TEXT_517 = NL + "\t\t\t} else if(\"script\".equals(type_";
  protected final String TEXT_518 = ")) {";
  protected final String TEXT_519 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_520 = ".write(pigLatin_";
  protected final String TEXT_521 = "[1]);";
  protected final String TEXT_522 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_523 = ".registerScript(new java.io.ByteArrayInputStream(pigLatin_";
  protected final String TEXT_524 = "[1].getBytes()));";
  protected final String TEXT_525 = NL + "\t\t\t} else if(\"function\".equals(type_";
  protected final String TEXT_526 = ")) {";
  protected final String TEXT_527 = NL + "\t\t\t\t\tbw_";
  protected final String TEXT_528 = ".write(\"DEFINE \" + pigLatin_";
  protected final String TEXT_529 = "[1] + \" \" + pigLatin_";
  protected final String TEXT_530 = "[2] + \";\");";
  protected final String TEXT_531 = NL + "\t\t\t\t\tpigServer_";
  protected final String TEXT_532 = ".registerFunction(pigLatin_";
  protected final String TEXT_533 = "[1], new org.apache.pig.FuncSpec(pigLatin_";
  protected final String TEXT_534 = "[2]));";
  protected final String TEXT_535 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_536 = NL + "    \tpigScript_";
  protected final String TEXT_537 = ".addAll(pigLatins_";
  protected final String TEXT_538 = ");";
  protected final String TEXT_539 = NL + "\tpigLatins_";
  protected final String TEXT_540 = ".clear();";
  protected final String TEXT_541 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String processId = node.getProcess().getId();
	
	String pigVersion = ElementParameterParser.getValue(node, "__PIG_VERSION__");
	boolean isLocal = "true".equals(ElementParameterParser.getValue(node, "__LOCAL__"));
	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	String inputFilename = ElementParameterParser.getValue(node, "__INPUT_FILENAME__");
	boolean isS3Location = "true".equals(ElementParameterParser.getValue(node, "__S3_LOCATION_LOAD__"));
    String s3bucket = ElementParameterParser.getValue(node, "__S3_BUCKET_LOAD__");
    String s3username = ElementParameterParser.getValue(node, "__S3_USERNAME_LOAD__");
	String databaseName = ElementParameterParser.getValue(node, "__DATABASE_NAME__");
	String tableName = ElementParameterParser.getValue(node, "__TABLE_NAME__");
	String fieldSeparator = ElementParameterParser.getValue(node, "__FIELD_SEPARATOR_CHAR__");
	String function = ElementParameterParser.getValue(node, "__LOAD__");
	
	String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
	String mapredJobTracker = ElementParameterParser.getValue(node, "__MAPRED_JOB_TRACKER__");
	String thriftServer = ElementParameterParser.getValue(node, "__THRIFT_SERVER__");
	
	List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
	List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
	
	List<Map<String, String>> partitionFilter = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__PARTITION_FILTER__");
	
	boolean compress = "true".equals(ElementParameterParser.getValue(node, "__COMPRESS__"));
	String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");
	
	String zookeeper_quorum = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
	String zookeeper_client_port = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");	
	
	boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
	String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");	
	
	boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
	String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");
	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
	boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_JOBHISTORY_ADDRESS__"));
    boolean useDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));
	
	boolean isParquet = !isLocal && "ParquetLoader".equals(function);
	
	boolean defineJarsToRegister = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__"));
	List<Map<String, String>> registerJarForHCatalog = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");
	
	List<Map<String, String>> registerJar = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__DRIVER_JAR__");
	List<Map<String, String>> defineFunctions = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__DEFINE_FUNCTION__");
	
	boolean isExecutedThroughWebHCat = !isLocal && "MICROSOFT_HD_INSIGHT".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
	
	java.util.List<String> supportHcatVersionList = java.util.Arrays.<String>asList("HDP_1_2","HDP_1_3","HDP_2_0","HDP_2_1","HDP_2_2","Cloudera_CDH5","Cloudera_CDH5_1","Cloudera_CDH5_4","Cloudera_CDH5_1_MR1","MAPR310","MAPR401","MAPR410","MICROSOFT_HD_INSIGHT_3_1");
	java.util.List<String> priorPig012HcatVersionList = java.util.Arrays.<String>asList("HDP_1_2","HDP_1_3","MAPR310");
	String hcatPackage = (priorPig012HcatVersionList.contains(pigVersion) && !isCustom) ? "org.apache.hcatalog.pig" : "org.apache.hive.hcatalog.pig";
	
	boolean generateRegisterJarCodeForHCatalog = (!isLocal && (isCustom || (pigVersion!=null && supportHcatVersionList.contains(pigVersion))) && "HCatLoader".equals(function) && !defineJarsToRegister);
	boolean generateRegisterJarCode = registerJar.size() > 0;
	
	java.util.List<String> jarsToRegister = null;
	java.util.List<String> jars = null;
	
	boolean generateRegisterJarCodeForHBase = !isLocal && "HBaseStorage".equals(function);
	
	boolean generateRegisterJarCodeForSequenceFile = !isLocal && "SequenceFileStorage".equals(function);
	
	boolean generateRegisterJarCodeForRCFile = !isLocal && "RCFilePigStorage".equals(function);
	
	boolean generateRegisterJarCodeForAvroFile = !isLocal && "AvroStorage".equals(function);
	
	boolean generateRegisterJarCodeForParquetFile = isParquet;
	
	boolean generateRegisterJarCodeForAll = true;
	
	if(generateRegisterJarCodeForAll) {
		String[] commandLine = new String[] {"<command>"};
		try {
			commandLine = ProcessorUtilities.getCommandLine("win32",true, processId, "",org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, new String[]{});
		} catch (ProcessorException e) {
			e.printStackTrace();
		}

		jarsToRegister = new java.util.ArrayList();
		
		jarsToRegister.add("datafu");
		
		if(generateRegisterJarCode) {
			for(Map<String, String> jar : registerJar){
				jarsToRegister.add(jar.get("JAR_NAME"));
			}
		}
		
		if(generateRegisterJarCodeForHCatalog) {
			jarsToRegister.add("hcatalog");
			
			jarsToRegister.add("hcatalog-core");
			
			jarsToRegister.add("hive-hcatalog-core");
			
			jarsToRegister.add("hive-exec");
			jarsToRegister.add("hive-metastore");
			jarsToRegister.add("jdo2-api");
			jarsToRegister.add("libfb303");
			jarsToRegister.add("libthrift");
		}
		
		if(generateRegisterJarCodeForHBase) {
			jarsToRegister.add("protobuf-java");
			jarsToRegister.add("hbase");
			jarsToRegister.add("hbase-client");
			jarsToRegister.add("hbase-common");
			jarsToRegister.add("hbase-protocol");
			jarsToRegister.add("hbase-server");
			jarsToRegister.add("zookeeper");
			jarsToRegister.add("guava");
			jarsToRegister.add("htrace-core");
		}
		
		if(generateRegisterJarCodeForSequenceFile) {
			jarsToRegister.add("elephant-bird-core");
			jarsToRegister.add("elephant-bird-hadoop-compat");
			jarsToRegister.add("elephant-bird-pig");
			jarsToRegister.add("pigutil");
		}
		
		if(generateRegisterJarCodeForRCFile) {
			jarsToRegister.add("elephant-bird-core");
			jarsToRegister.add("elephant-bird-hadoop-compat");
			jarsToRegister.add("elephant-bird-rcfile");
			jarsToRegister.add("hive-serde");
			jarsToRegister.add("hive-common");
			jarsToRegister.add("hive-exec");
		}
		
		if(generateRegisterJarCodeForAvroFile) {
			jarsToRegister.add("piggybank");
			jarsToRegister.add("avro");
			jarsToRegister.add("json_simple");
		}
		
		if(generateRegisterJarCodeForParquetFile) {
			jarsToRegister.add("parquet-pig-bundle");
			jarsToRegister.add("snappy-java");
		}

		for (int j = 0; j < commandLine.length; j++) {
			if(commandLine[j].contains("jar")) {
				jars = java.util.Arrays.asList(commandLine[j].split(";"));
				break;
			}
		}
	}

	String start_node=cid;

	boolean inMain = true;

	if(node.getIncomingConnections()!=null && node.getIncomingConnections().size()>0) {
		INode loadNode = node.getDesignSubjobStartNode();
		inMain = loadNode.isSubtreeStart();
		start_node = loadNode.getUniqueName();
	}
	
	String outputConnectionName = "";
	List<IConnection> outputConnections = (List<IConnection>)node.getOutgoingConnections();
	if(outputConnections!=null && outputConnections.size()>0) {
		outputConnectionName = outputConnections.get(0).getName();
	}
	
	boolean useTez = "true".equals(ElementParameterParser.getValue(node, "__TEZ__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    
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
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	log4jFileUtil.componentStartInfo(node);
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_32);
    
	if(generateRegisterJarCodeForAll) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
	}
	
	if(!isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
     
	}
	 
	if(inMain && !isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
      
	}

    stringBuffer.append(TEXT_48);
    
		if(inMain && isExecutedThroughWebHCat) {
			String passwordFieldName = "__HDINSIGHT_PASSWORD__";
			if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_51);
    
			} else {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_54);
    
			}
			
			passwordFieldName = "__WASB_PASSWORD__";
			if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_57);
    
			} else {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_60);
    
			}

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_HOST__"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HDINSIGHT_USERNAME__"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_USERNAME__"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_HOST__"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_PORT__"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(ElementParameterParser.getValue(node, "__STATUSDIR__"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(ElementParameterParser.getValue(node, "__REMOTE_FOLDER__"));
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
		
		if(isLocal) { // LOCAL mode

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
		} else if(!isLocal && !isExecutedThroughWebHCat) { // MAPREDUCE mode
			if(inMain) {
				String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_102);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
				if(isCustom || (!isCustom && (pigVersion!=null && "HDP_1_2,HDP_1_3,HDP_2_0,HDP_2_1,HDP_2_2,Cloudera_CDH4,Cloudera_CDH4_YARN,Cloudera_CDH5,Cloudera_CDH5_1,Cloudera_CDH5_4,Cloudera_CDH5_1_MR1,PIVOTAL_HD_1_0_1,PIVOTAL_HD_2_0,APACHE_2_4_0_EMR,EMR_4_0_0".contains(pigVersion)))) {
					String username = ElementParameterParser.getValue(node, "__USERNAME__");

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    
				}
				
				if(!isCustom && ("MAPR401".equals(pigVersion) || "MAPR410".equals(pigVersion))) {//set the default properties

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
				}
			}

			if(!isCustom && "APACHE_2_4_0_EMR".equals(pigVersion)) {
                
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    
            } else {
                
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_120);
    
            }
			boolean isKerberosAvailableHadoop2 = !isCustom && ("PIVOTAL_HD_2_0".equals(pigVersion) || "HDP_2_0".equals(pigVersion) || "HDP_2_1".equals(pigVersion) || "HDP_2_2".equals(pigVersion) || "Cloudera_CDH4_YARN".equals(pigVersion) || "Cloudera_CDH5".equals(pigVersion) || "Cloudera_CDH5_1".equals(pigVersion) || "Cloudera_CDH5_4".equals(pigVersion));
			boolean isHadoop2 = "PIVOTAL_HD_1_0_1".equals(pigVersion) || "APACHE_2_4_0_EMR".equals(pigVersion) || "EMR_4_0_0".equals(pigVersion) || "MAPR401".equals(pigVersion) || "MAPR410".equals(pigVersion) || isKerberosAvailableHadoop2;
			
			boolean isKerberosAvailableHadoop1 = !isCustom && ("HDP_1_2".equals(pigVersion) || "HDP_1_3".equals(pigVersion) || "APACHE_1_0_0".equals(pigVersion) || "APACHE_1_0_3_EMR".equals(pigVersion) || "Cloudera_CDH4".equals(pigVersion) || "Cloudera_CDH5_1_MR1".equals(pigVersion));
			
			if((isCustom && useYarn) || (!isCustom && isHadoop2)) {

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_124);
    
				boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
				if(setSchedulerAddress) {
					String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_127);
    
				}
				boolean setStagingDirectory = "true".equals(ElementParameterParser.getValue(node, "__SET_STAGING_DIRECTORY__"));
				if(setStagingDirectory) {
					String stagingDirectory = ElementParameterParser.getValue(node, "__STAGING_DIRECTORY__");

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(stagingDirectory);
    stringBuffer.append(TEXT_130);
    
				}
				
				if(!isCustom && ("HDP_2_1".equals(pigVersion) || "HDP_2_2".equals(pigVersion) || "Cloudera_CDH5".equals(pigVersion) || "Cloudera_CDH5_1".equals(pigVersion) || "Cloudera_CDH5_4".equals(pigVersion) || "MAPR401".equals(pigVersion) || "MAPR410".equals(pigVersion) || "EMR_4_0_0".equals(pigVersion) || "APACHE_2_4_0_EMR".equals(pigVersion) || "APACHE_2_4_0_EMR_0_13_1".equals(pigVersion))) {

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
				}
				
				if(!isCustom && "HDP_2_1".equals(pigVersion)) {
				    
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
				} else if(!isCustom && "HDP_2_2".equals(pigVersion)) {
					
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
				} else if(!isCustom && "APACHE_2_4_0_EMR".equals(pigVersion)) {
		            
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    
		        } else if(!isCustom && "EMR_4_0_0".equals(pigVersion)) {
		        	
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    
		        } else {
		            
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    
				}
				
        		boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
        		if(isCustom && useYarn && crossPlatformSubmission) {

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    
				}
				
				boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
				if(setMemory) {
					String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
					String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
					String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_152);
    
				}
				
				if(setJobHistoryAddress) {
					String jobHistoryAddress = ElementParameterParser.getValue(node, "__JOBHISTORY_ADDRESS__");

    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_155);
    
				}
			} else {

    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(mapredJobTracker);
    stringBuffer.append(TEXT_158);
    
			}
			
			if("HCatLoader".equals(function)) { // If the HCatalog loader is used, we need to add the HCat metastore in the pig context

    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(thriftServer);
    stringBuffer.append(TEXT_161);
    
			}
			
			if("HBaseStorage".equals(function)) {

    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(zookeeper_quorum);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(zookeeper_client_port);
    stringBuffer.append(TEXT_166);
    
				if(setZNodeParent) {

    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_169);
    
				}
			}
			
			if(useKrb) {
				String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
				boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
				String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
				String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
				String hbaseMasterPrincipal = ElementParameterParser.getValue(node, "__HBASEMASTER_PRINCIPAL__");
				String hbaseReigonServerPrincipal = ElementParameterParser.getValue(node, "__HBASEREIGONSERVER_PRINCIPAL__");

    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(hbaseReigonServerPrincipal);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(hbaseMasterPrincipal);
    stringBuffer.append(TEXT_177);
    				
				if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
					String jobTrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(jobTrackerPrincipal);
    stringBuffer.append(TEXT_180);
    
				}
				if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
					String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");
					String jobHistoryPrincipal = ElementParameterParser.getValue(node, "__JOBHISTORY_PRINCIPAL__");

    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(jobHistoryPrincipal);
    stringBuffer.append(TEXT_185);
    
				}

				if(useKeytab) {

    stringBuffer.append(TEXT_186);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_188);
    
				}
			}

		    if(!isCustom && ("HDP_1_2".equals(pigVersion) || "HDP_1_3".equals(pigVersion))) {
		        String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
		        String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_193);
    
    		}
			if(hadoopProps.size() > 0){
				for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_197);
     
				} 
			}
            if (useDatanodeHostname) {
                
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    
            }
			
			if(useTez){
			
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
			}else{
            
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    
			}
		}

        if (isS3Location) {
            String passwordFieldName = "__S3_PASSWORD_LOAD__";
            // Get the decrypted password under the variable decryptedS3Password

            if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
                
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_208);
    
            } else {
                
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_211);
    
            }
        }
		
		if(inMain) {//only main process create the server object,lookup process use the one in main process
			if(!isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_212);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_215);
    
			}
		} else {

    stringBuffer.append(TEXT_216);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_217);
    
		}

    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
	if((advProps.size() > 0) || compress || (isLocal && "HBaseStorage".equals(function)) || useTez){

    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    
		for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_225);
     
		} 
		
		if(compress) {

    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    
			if("GZIP".equals(compression)) {

    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    
			} else if("BZIP2".equals(compression)) {

    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    		
			}
		}
		
		if(isLocal && "HBaseStorage".equals(function)) {

    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(zookeeper_quorum);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(zookeeper_client_port);
    stringBuffer.append(TEXT_236);
    
			if(setZNodeParent) {

    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_239);
    
			}
		}

		if(useTez){
			if(advProps != null){
    			for(Map<String, String> item : advProps){
    				if("\"tez.lib.uris\"".equals(item.get("PROPERTY"))){
    				
    stringBuffer.append(TEXT_240);
    	
    				}
    			}
    		}
			boolean installTez = "INSTALL".equals(ElementParameterParser.getValue(node, "__TEZ_LIB__"));
			if(installTez){
				//prepare the folder
				
    stringBuffer.append(TEXT_241);
    stringBuffer.append(TEXT_242);
    
class GetFileSystem{
	public void invoke(INode node){
        String cid = node.getUniqueName();
        
        String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
        List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
        String user = null;
        
        String hadoopVersion = null;
        boolean isCustom = false;
        
        java.util.List<String> supportKrbVersionList = java.util.Arrays.<String>asList(
        	"Cloudera_CDH4","Cloudera_CDH4_YARN","Cloudera_CDH5","Cloudera_CDH5_1","Cloudera_CDH5_4","Cloudera_CDH5_1_MR1",
        	"HDP_1_2","HDP_1_3","HDP_2_0","HDP_2_1",
        	"APACHE_1_0_0","APACHE_1_0_3_EMR",
        	"PIVOTAL_HD_2_0"
        );
        String username = ElementParameterParser.getValue(node, "__USERNAME__");
        
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    
        hadoopVersion = ElementParameterParser.getValue(node, "__PIG_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));
        
        String distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        isCustom = "CUSTOM".equals(distribution);
        
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_252);
    
        if(mrUseDatanodeHostname){
        
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_258);
     
    		}
    	}
        	
    	if(((hadoopVersion!=null && supportKrbVersionList.contains(hadoopVersion)) && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_261);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_262);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_264);
    
    		}
    	}
    	
    	if("MAPR".equals(distribution)){
    		String group = ElementParameterParser.getValue(node, "__GROUP__");
    		
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(group);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    
        }else{
        
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    
        }
    }
}

    stringBuffer.append(TEXT_280);
    	
				(new GetFileSystem()).invoke(node);
				String tezLibFolder = ElementParameterParser.getValue(node, "__TEZ_LIB_FOLDER__");
				boolean useDefaultTezLibFolder = "\"/tmp/{USERNAME}/talend_tez_libs/{custom|PIG_VERSION}\"".equals(tezLibFolder);
				if(useDefaultTezLibFolder){
					String username = ElementParameterParser.getValue(node, "__USERNAME__");
					
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(isCustom?"custom":pigVersion);
    stringBuffer.append(TEXT_288);
    
				}else{
				
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(tezLibFolder);
    stringBuffer.append(TEXT_291);
    
				}
				
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    
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
				
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    if(!isLocal && !isExecutedThroughWebHCat && inMain){
    stringBuffer.append(TEXT_297);
    }else{
    stringBuffer.append(TEXT_298);
    }
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    
					for(String jarName : tezLibJarsName){
					
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(jarName);
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
    
					}
					
    stringBuffer.append(TEXT_313);
    
			}else{
			
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TEZ_LIB_PATH__"));
    stringBuffer.append(TEXT_316);
    
			}
    		//define the location of tez lib	
			
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    
		}
		
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    
	}

    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    		
		if(generateRegisterJarCodeForAll) {
			for(int i=0; i<jarsToRegister.size(); i++) {
				String jarToRegister = jarsToRegister.get(i);
				for(int j=0; j<jars.size(); j++) {
					if(jars.get(j).contains(jarToRegister)) {

    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_340);
    
					}
				}
			}
		}
		
		if(defineFunctions.size() > 0){
			for(Map<String, String> item : defineFunctions){

    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(item.get("FUNCTION_ALIAS") );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(item.get("UDF_FUNCTION") );
    stringBuffer.append(TEXT_344);
     
			} 
		} 

		if(!isLocal && "HCatLoader".equals(function)) { // If the HCatalog loader is used, we don't need a filename anymore, but a database name and a table name.
			if(!generateRegisterJarCodeForHCatalog) {
				if(defineJarsToRegister && registerJarForHCatalog.size() > 0){
					for(Map<String, String> item : registerJarForHCatalog){

    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(item.get("JAR_PATH") );
    stringBuffer.append(TEXT_347);
     
					} 
				}
			}

    stringBuffer.append(TEXT_348);
    stringBuffer.append(thriftServer);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(partitionFilter.size()>0?"_TEMP":"");
    stringBuffer.append(TEXT_353);
    stringBuffer.append(databaseName);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(hcatPackage);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(function);
    stringBuffer.append(TEXT_357);
    
		} else if(!isLocal && "SequenceFileStorage".equals(function)) {
			List<IMetadataTable> metadatas = node.getMetadataList();
			IMetadataTable metadata = null;
			if(metadatas != null && metadatas.size() > 0) {
				metadata = metadatas.get(0);
			}
			
			String keyColumn = ElementParameterParser.getValue(node,"__KEYCOLUMN__");
			String valueColumn = ElementParameterParser.getValue(node,"__VALUECOLUMN__");
			
			String talendKeyClass = "";
			String talendValueClass = "";
			
			if(metadata!=null) {
    			List<IMetadataColumn> listColumns = metadata.getListColumns();
    			
    			for (IMetadataColumn column : listColumns) {
    				if (column.getLabel().equals(keyColumn)) {
    					talendKeyClass = column.getTalendType();
    				}
    				if (column.getLabel().equals(valueColumn)) {
    					talendValueClass = column.getTalendType();
    				}
    			}
			}
			
			String keyConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
			if (talendKeyClass.equals("id_Boolean")) keyConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
			if (talendKeyClass.equals("id_Byte")) keyConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
			if (talendKeyClass.equals("id_byte[]")) keyConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
			if (talendKeyClass.equals("id_Double")) keyConverterClass="com.talend.pig.util.DoubleWritableConverter";
			if (talendKeyClass.equals("id_Float")) keyConverterClass="com.talend.pig.util.FloatWritableConverter";
			if (talendKeyClass.equals("id_Integer")) keyConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
			if (talendKeyClass.equals("id_Long")) keyConverterClass="com.twitter.elephantbird.pig.util.LongWritableConverter";
			if (talendKeyClass.equals("id_Short")) keyConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
			if (talendKeyClass.equals("id_String")) keyConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
			
			String valueConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
			if (talendValueClass.equals("id_Boolean")) valueConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
			if (talendValueClass.equals("id_Byte")) valueConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
			if (talendValueClass.equals("id_byte[]")) valueConverterClass="com.twitter.elephantbird.pig.util.TextConverter";
			if (talendValueClass.equals("id_Double")) valueConverterClass="com.talend.pig.util.DoubleWritableConverter";
			if (talendValueClass.equals("id_Float")) valueConverterClass="com.talend.pig.util.FloatWritableConverter";
			if (talendValueClass.equals("id_Integer")) valueConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
			if (talendValueClass.equals("id_Long")) valueConverterClass="com.twitter.elephantbird.pig.util.LongWritableConverter";
			if (talendValueClass.equals("id_Short")) valueConverterClass="com.twitter.elephantbird.pig.util.IntWritableConverter";
			if (talendValueClass.equals("id_String")) valueConverterClass="com.twitter.elephantbird.pig.util.TextConverter";

			if (isS3Location) {
			    
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(keyConverterClass);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(valueConverterClass);
    stringBuffer.append(TEXT_366);
    
	        } else {
	            
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(inputFilename);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(keyConverterClass);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(valueConverterClass);
    stringBuffer.append(TEXT_373);
    
	        }

			if(metadata!=null) {

    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(keyColumn);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(Java2STLangTypesHelper.getPigType(metadata, keyColumn));
    stringBuffer.append(TEXT_378);
    stringBuffer.append(valueColumn);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(Java2STLangTypesHelper.getPigType(metadata, valueColumn));
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    
			}
		} else {
			if("CustomLoader".equals(function)) {
				String customLoader = ElementParameterParser.getValue(node, "__CUSTOM_LOADER__");
	            if (isS3Location) {
	                
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(customLoader);
    stringBuffer.append(TEXT_389);
    
	            } else {
	                
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(inputFilename);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(customLoader);
    stringBuffer.append(TEXT_395);
    
	            }
			} else {
				List<IMetadataTable> metadatas = node.getMetadataList();
				IMetadataTable metadata = null;
				if(metadatas != null && metadatas.size() > 0) {
					metadata = metadatas.get(0);
				}

				if("HBaseStorage".equals(function)){
					String hbasetable = ElementParameterParser.getValue(node, "__HBASE_TABLE__");
					boolean loadkey = "true".equals(ElementParameterParser.getValue(node, "__LOAD_KEY__"));//if load key,the first column is hbase row key
					List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MAPPING__");
					
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(hbasetable);
    stringBuffer.append(TEXT_400);
    

					if(metadata!=null && mapping!=null) {
						for(int i=0;i<mapping.size();i++){
							if(loadkey && (i == 0)) {
								continue;
							}
                			Map<String, String> map = mapping.get(i);
                			String family_column= map.get("FAMILY_COLUMN");

    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_403);
    
							if(i < mapping.size()-1) {

    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    
							}
            			}
					}

    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    
					List<Map<String, String>> hbasestorageParams = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__HBASESTORAGE_PARAMETER__");
					
					if(loadkey) {

    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    
					}
					
					if(hbasestorageParams!=null) {
						for(int i=0;i<hbasestorageParams.size();i++) {
							if(i == 0) {
								if(!loadkey) {

    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    							
								} else {

    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    
								}
							}
							Map<String, String> param = hbasestorageParams.get(i);
							String name = param.get("PARAM_NAME");
							String value = param.get("PARAM_VALUE");

    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_417);
    							
							if(i < hbasestorageParams.size()-1) {

    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    							
							} else if(!loadkey){

    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    							
							}
						}
					}
					
					if(loadkey) {

    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    
					}

    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    
				} else if(isParquet) {
	                if (isS3Location) {
	                    
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_432);
    
	                } else {
	                    
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(inputFilename);
    stringBuffer.append(TEXT_437);
    
	                }
				} else {
					if("RCFilePigStorage".equals(function)) {
						function = "com.twitter.elephantbird.pig.store.RCFilePigStorage";
					}
					
					if("AvroStorage".equals(function)) {
						function = "org.apache.pig.piggybank.storage.avro.AvroStorage";
					}
					if (isS3Location) {
                        
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(function);
    stringBuffer.append(TEXT_445);
    stringBuffer.append("PigStorage".equals(function)?"'\"+"+fieldSeparator+"+\"'":"");
    stringBuffer.append(TEXT_446);
    
                    } else {
                        
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(inputFilename);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(function);
    stringBuffer.append(TEXT_452);
    stringBuffer.append("PigStorage".equals(function)?"'\"+"+fieldSeparator+"+\"'":"");
    stringBuffer.append(TEXT_453);
    
                    }
				}
			
				if(metadata!=null) {
					if(metadata.getListColumns() != null && metadata.getListColumns().size() > 0) {

    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    
						for(int i=0; i<metadata.getListColumns().size(); i++) {

    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(i!=0?", ":"");
    stringBuffer.append(metadata.getListColumns().get(i).getLabel());
    stringBuffer.append(TEXT_458);
    stringBuffer.append(Java2STLangTypesHelper.getPigType(metadata, metadata.getListColumns().get(i).getLabel()));
    stringBuffer.append(TEXT_459);
    

						}

    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    
					}
				}
			}
		}

    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    
		if(!isLocal && "HCatLoader".equals(function)) { // If the HCatalog loader is used, we will have to consider the partition filter
			if(partitionFilter.size() > 0){
				int i = 0;

    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_472);
    
				for(Map<String, String> item : partitionFilter){
					if(i++ != 0) {

    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    
					}

    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(item.get("PART_NAME") );
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(item.get("PART_VALUE") );
    stringBuffer.append(TEXT_480);
     
				}

    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    				
			}
		}

    stringBuffer.append(TEXT_485);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    
	if(inMain) {

    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    }
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    
				if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_500);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    					
				} else {

    stringBuffer.append(TEXT_503);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    
				}

    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    
				if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_508);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    					
				} else {

    stringBuffer.append(TEXT_514);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    
				}

    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    
				if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_519);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    					
				} else {

    stringBuffer.append(TEXT_522);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    
				}

    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    
				if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_527);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    					
				} else {

    stringBuffer.append(TEXT_531);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    
				}

    stringBuffer.append(TEXT_535);
    
	} else {

    stringBuffer.append(TEXT_536);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    
	}

    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(TEXT_541);
    return stringBuffer.toString();
  }
}
