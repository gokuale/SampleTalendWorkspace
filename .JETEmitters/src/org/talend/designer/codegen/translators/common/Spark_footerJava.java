package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.JavaResourcesHelper;
import org.talend.core.CorePlugin;
import java.lang.Iterable;
import java.util.Vector;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Spark_footerJava
{
  protected static String nl;
  public static synchronized Spark_footerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Spark_footerJava result = new Spark_footerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        throw new java.lang.RuntimeException(\"A Spark job can't have more than 1 tS3Configuration defined in the designer.\");";
  protected final String TEXT_3 = NL + "        throw new java.lang.RuntimeException(\"A Spark job can't have more than 1 tTachyonConfiguration defined in the designer.\");";
  protected final String TEXT_4 = NL + "        throw new java.lang.RuntimeException(\"A Spark job can't have more than 1 tHDFSConfiguration defined in the designer.\");";
  protected final String TEXT_5 = NL + "        throw new java.lang.RuntimeException(\"A Spark job can't have more than 1 tCassandraConfiguration defined in the designer.\");";
  protected final String TEXT_6 = NL + "    ";
  protected final String TEXT_7 = NL + "\tpublic static class TalendKryoRegistrator implements org.apache.spark.serializer.KryoRegistrator {" + NL + "\t\t\t" + NL + "\t\t@Override" + NL + "\t\tpublic void registerClasses(com.esotericsoftware.kryo.Kryo kryo) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tkryo.register(Class.forName(\"org.talend.bigdata.dataflow.keys.JoinKeyRecord\"));" + NL + "\t\t\t} catch (java.lang.ClassNotFoundException e) {" + NL + "\t\t\t\t// Ignore" + NL + "\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\tkryo.register(java.net.InetAddress.class, new InetAddressSerializer());" + NL + "\t\t\tkryo.addDefaultSerializer(java.net.InetAddress.class, new InetAddressSerializer());" + NL + "\t\t";
  protected final String TEXT_8 = "\t\t\t" + NL + "\t\t\tkryo.register(";
  protected final String TEXT_9 = ".class);" + NL + "\t\t";
  protected final String TEXT_10 = NL + "\t\t}" + NL + "\t}" + NL + "\t\t" + NL + "\tpublic static class InetAddressSerializer extends com.esotericsoftware.kryo.Serializer<java.net.InetAddress> {" + NL + "\t" + NL + "\t\t@Override" + NL + "\t\tpublic void write(com.esotericsoftware.kryo.Kryo kryo, com.esotericsoftware.kryo.io.Output output, java.net.InetAddress value) {" + NL + "\t\t\toutput.writeInt(value.getAddress().length);" + NL + "\t\t\toutput.writeBytes(value.getAddress());" + NL + "\t\t}" + NL + "\t" + NL + "\t\t@Override" + NL + "\t\tpublic java.net.InetAddress read(com.esotericsoftware.kryo.Kryo kryo, com.esotericsoftware.kryo.io.Input input, Class<java.net.InetAddress> paramClass) {" + NL + "\t\t\tjava.net.InetAddress inetAddress = null;" + NL + "\t\t\ttry {" + NL + "\t\t\t\tint length = input.readInt();" + NL + "\t\t\t\tbyte[] address = input.readBytes(length);" + NL + "\t\t\t\tinetAddress = java.net.InetAddress.getByAddress(address);" + NL + "\t\t\t} catch (java.net.UnknownHostException e) {" + NL + "\t\t\t\t// Cannot recreate InetAddress instance : return null" + NL + "\t\t\t} catch (com.esotericsoftware.kryo.KryoException e) {" + NL + "\t\t\t\t// Should not happen since write() and read() methods are consistent." + NL + "\t\t\t}" + NL + "\t\t\treturn inetAddress;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "    public String resuming_logs_dir_path = null;" + NL + "    public String resuming_checkpoint_path = null;" + NL + "    public String parent_part_launcher = null;" + NL + "    public String pid = \"0\";" + NL + "    public String rootPid = null;" + NL + "    public String fatherPid = null;" + NL + "    public Integer portStats = null;" + NL + "    public String clientHost;" + NL + "    public String defaultClientHost = \"localhost\";" + NL + "    public String libjars = null;" + NL + "    private boolean execStat = true;" + NL + "    public boolean isChildJob = false;" + NL + "    public String fatherNode = null;" + NL + "    public String log4jLevel = \"\";" + NL + "    private boolean doInspect = false;" + NL + "" + NL + "    public String contextStr = \"";
  protected final String TEXT_11 = "\";" + NL + "    public boolean isDefaultContext = true;" + NL + "" + NL + "    private java.util.Properties context_param = new java.util.Properties();" + NL + "    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();" + NL + "" + NL + "    public String status= \"\";" + NL + "" + NL + "    public static void main(String[] args){" + NL + "        int exitCode = new ";
  protected final String TEXT_12 = "().runJobInTOS(args);";
  protected final String TEXT_13 = NL + "            if(exitCode == 0) {" + NL + "                log.info(\"TalendJob: '";
  protected final String TEXT_14 = "' - Done.\");" + NL + "            } else {" + NL + "                log.error(\"TalendJob: '";
  protected final String TEXT_15 = "' - Failed with exit code: \" + exitCode + \".\");" + NL + "            }";
  protected final String TEXT_16 = NL + "        System.exit(exitCode);" + NL + "    }" + NL + "" + NL + "    public String[][] runJob(String[] args){" + NL + "        int exitCode = runJobInTOS(args);" + NL + "        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };" + NL + "        return bufferValue;" + NL + "    }" + NL + "" + NL + "    public int runJobInTOS (String[] args) {" + NL + "        normalizeArgs(args);" + NL + "" + NL + "        String lastStr = \"\";" + NL + "        for (String arg : args) {" + NL + "            if (arg.equalsIgnoreCase(\"--context_param\")) {" + NL + "                lastStr = arg;" + NL + "            } else if (lastStr.equals(\"\")) {" + NL + "                evalParam(arg);" + NL + "            } else {" + NL + "                evalParam(lastStr + \" \" + arg);" + NL + "                lastStr = \"\";" + NL + "            }" + NL + "        }" + NL;
  protected final String TEXT_17 = NL + "            if(!\"\".equals(log4jLevel)){" + NL + "                if(\"trace\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.TRACE);" + NL + "                }else if(\"debug\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.DEBUG);" + NL + "                }else if(\"info\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.INFO);" + NL + "                }else if(\"warn\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.WARN);" + NL + "                }else if(\"error\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.ERROR);" + NL + "                }else if(\"fatal\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.FATAL);" + NL + "                }else if (\"off\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.OFF);" + NL + "                }" + NL + "                org.apache.log4j.Logger.getRootLogger().setLevel(log.getLevel());" + NL + "            }" + NL + "            log.info(\"TalendJob: '";
  protected final String TEXT_18 = "' - Start.\");";
  protected final String TEXT_19 = NL + NL + "        initContext();" + NL + "" + NL + "        if (clientHost == null) {" + NL + "            clientHost = defaultClientHost;" + NL + "        }" + NL + "" + NL + "        if (pid == null || \"0\".equals(pid)) {" + NL + "            pid = TalendString.getAsciiRandomString(6);" + NL + "        }" + NL + "" + NL + "        if (rootPid == null) {" + NL + "            rootPid = pid;" + NL + "        }" + NL + "        if (fatherPid == null) {" + NL + "            fatherPid = pid;" + NL + "        } else {" + NL + "            isChildJob = true;" + NL + "        }";
  protected final String TEXT_20 = NL + NL + "            if (portStats != null) {" + NL + "                // portStats = -1; //for testing" + NL + "                if (portStats < 0 || portStats > 65535) {" + NL + "                    // issue:10869, the portStats is invalid, so this client socket" + NL + "                    // can't open" + NL + "                    System.err.println(\"The statistics socket port \" + portStats" + NL + "                            + \" is invalid.\");" + NL + "                    execStat = false;" + NL + "                }" + NL + "            } else {" + NL + "                execStat = false;" + NL + "            }" + NL + "" + NL + "            if (execStat) {" + NL + "                try {" + NL + "                    runStat.startThreadStat(clientHost, portStats);" + NL + "                    runStat.setAllPID(rootPid, fatherPid, pid);" + NL + "                } catch (java.io.IOException ioException) {" + NL + "                    ioException.printStackTrace();" + NL + "                }" + NL + "            }";
  protected final String TEXT_21 = NL + "            if(!\"\".equals(";
  protected final String TEXT_22 = ")) {" + NL + "                System.setProperty(\"HADOOP_USER_NAME\", ";
  protected final String TEXT_23 = ");" + NL + "            }";
  protected final String TEXT_24 = NL + "        String osName = System.getProperty(\"os.name\");" + NL + "        String snappyLibName = \"libsnappyjava.so\";" + NL + "        if(osName.startsWith(\"Windows\")) {" + NL + "            snappyLibName = \"snappyjava.dll\";" + NL + "        } else if(osName.startsWith(\"Mac\")) {" + NL + "            snappyLibName = \"libsnappyjava.jnilib\";" + NL + "        }" + NL + "        System.setProperty(\"org.xerial.snappy.lib.name\", snappyLibName);";
  protected final String TEXT_25 = NL + "            try {" + NL + "                org.apache.spark.SparkConf sparkConfiguration = new  org.apache.spark.SparkConf();" + NL + "                sparkConfiguration.setAppName(projectName + \"_\" + jobName + \"_\" + jobVersion);" + NL + "                sparkConfiguration.set(\"spark.serializer\", \"org.apache.spark.serializer.KryoSerializer\"); " + NL + "                sparkConfiguration.set(\"spark.kryo.registrator\", TalendKryoRegistrator.class.getName());";
  protected final String TEXT_26 = NL + "                sparkConfiguration.setMaster(";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "                               sparkConfiguration.set(\"spark.driver.host\", ";
  protected final String TEXT_29 = ");" + NL + "                               org.apache.spark.util.Utils.setCustomHostname(";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "                        sparkConfiguration.setSparkHome(";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "                            sparkConfiguration.set(\"spark.hadoop.yarn.application.classpath\", \"$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*\");";
  protected final String TEXT_34 = NL + "                            sparkConfiguration.set(\"spark.hadoop.yarn.application.classpath\", \"$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,/usr/lib/hadoop-lzo/lib/*,/usr/share/aws/emr/emrfs/conf, /usr/share/aws/emr/emrfs/lib/*,/usr/share/aws/emr/emrfs/auxlib/*,/usr/share/aws/emr/lib/*,/usr/share/aws/emr/ddb/lib/emr-ddb-hadoop.jar, /usr/share/aws/emr/goodies/lib/emr-hadoop-goodies.jar,/usr/share/aws/emr/kinesis/lib/emr-kinesis-hadoop.jar,/usr/lib/spark/yarn/lib/datanucleus-api-jdo.jar,/usr/lib/spark/yarn/lib/datanucleus-core.jar,/usr/lib/spark/yarn/lib/datanucleus-rdbms.jar,/usr/share/aws/emr/cloudwatch-sink/lib/*\");";
  protected final String TEXT_35 = NL + "                            sparkConfiguration.set(\"spark.hadoop.yarn.application.classpath\", \"$HADOOP_CLIENT_CONF_DIR,$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*\");";
  protected final String TEXT_36 = NL + "                            sparkConfiguration.set(\"spark.hadoop.yarn.application.classpath\", \"/etc/hadoop/conf, /usr/lib/hadoop/*, /usr/lib/hadoop/lib/*,/usr/lib/hadoop-hdfs/*, /usr/lib/hadoop-hdfs/lib/*, /usr/lib/hadoop-mapreduce/*, /usr/lib/hadoop-mapreduce/lib/*,/usr/lib/hadoop-yarn/*, /usr/lib/hadoop-yarn/lib/*\");";
  protected final String TEXT_37 = NL + NL + "                        sparkConfiguration.set(\"spark.hadoop.yarn.resourcemanager.address\", ";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = "sparkConfiguration.set(\"spark.hadoop.yarn.resourcemanager.scheduler.address\", ";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = "sparkConfiguration.set(\"spark.hadoop.mapreduce.jobhistory.address\", ";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = "sparkConfiguration.set(\"spark.hadoop.yarn.app.mapreduce.am.staging-dir\", ";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL + "                            sparkConfiguration.set(\"spark.hadoop.mapreduce.map.memory.mb\", ";
  protected final String TEXT_46 = ");" + NL + "                            sparkConfiguration.set(\"spark.hadoop.mapreduce.reduce.memory.mb\", ";
  protected final String TEXT_47 = ");" + NL + "                            sparkConfiguration.set(\"spark.hadoop.yarn.app.mapreduce.am.resource.mb\", ";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "                            sparkConfiguration.set(\"spark.hadoop.yarn.resourcemanager.principal\", ";
  protected final String TEXT_50 = ");" + NL + "                            sparkConfiguration.set(\"spark.hadoop.mapreduce.jobhistory.principal\", ";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "                                org.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "                                    if(!";
  protected final String TEXT_56 = ".equals(";
  protected final String TEXT_57 = ")) {" + NL + "                                        throw new RuntimeException(\"The HDFS and the Spark configurations must have the same user name.\");" + NL + "                                    }";
  protected final String TEXT_58 = NL + "                                    if(!\"\".equals(";
  protected final String TEXT_59 = ")) {" + NL + "                                        System.setProperty(\"HADOOP_USER_NAME\", ";
  protected final String TEXT_60 = ");" + NL + "                                    }";
  protected final String TEXT_61 = NL + "                    System.setProperty(\"hadoop.home.dir\", ";
  protected final String TEXT_62 = ");";
  protected final String TEXT_63 = NL + "                        sparkConfiguration.set(\"spark.ui.port\", ";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "                    sparkConfiguration.set(\"spark.driver.memory\", ";
  protected final String TEXT_66 = ");" + NL + "                    sparkConfiguration.set(\"spark.executor.memory\", ";
  protected final String TEXT_67 = ");";
  protected final String TEXT_68 = NL + "                        sparkConfiguration.set(\"spark.driver.cores\", ";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL + "                        sparkConfiguration.set(\"spark.yarn.am.cores\", ";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL + "                        sparkConfiguration.set(\"spark.executor.cores\", ";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "                            sparkConfiguration.set(\"spark.executor.instances\", ";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = NL + "                            sparkConfiguration.set(\"spark.dynamicAllocation.enabled\", \"true\");" + NL + "                            sparkConfiguration.set(\"spark.shuffle.service.enabled\", \"true\");" + NL + "                            String dynInitialValue = ";
  protected final String TEXT_77 = ";" + NL + "                            sparkConfiguration.set(\"spark.dynamicAllocation.initialExecutors\", dynInitialValue);" + NL + "                            String dynMinValue = ";
  protected final String TEXT_78 = ";" + NL + "                            sparkConfiguration.set(\"spark.dynamicAllocation.minExecutors\", dynMinValue);";
  protected final String TEXT_79 = NL + "                                Integer iDynMaxValue = Integer.MAX_VALUE;" + NL + "                                sparkConfiguration.set(\"spark.dynamicAllocation.maxExecutors\", new Integer(Integer.MAX_VALUE).toString());";
  protected final String TEXT_80 = NL + "                                Integer iDynMaxValue = Integer.parseInt(";
  protected final String TEXT_81 = ");" + NL + "                                sparkConfiguration.set(\"spark.dynamicAllocation.maxExecutors\", ";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL + "                            Integer iDynInitialValue = Integer.parseInt(dynInitialValue);" + NL + "                            Integer iDynMinValue = Integer.parseInt(dynMinValue);" + NL + "                            if(iDynInitialValue < iDynMinValue|| iDynInitialValue > iDynMaxValue || iDynMinValue > iDynMaxValue) {" + NL + "                                throw new RuntimeException(\"Please check your dynamicAllocation bounds, you should have min <= initial <= max\");" + NL + "                            }";
  protected final String TEXT_84 = NL + "                        sparkConfiguration.set(\"spark.broadcast.factory\", \"org.apache.spark.broadcast.TorrentBroadcastFactory\");";
  protected final String TEXT_85 = NL + "                        sparkConfiguration.set(\"spark.broadcast.factory\", \"org.apache.spark.broadcast.HttpBroadcastFactory\");";
  protected final String TEXT_86 = NL + "                        sparkConfiguration.set(\"spark.serializer\", ";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "                    sparkConfiguration.set(";
  protected final String TEXT_89 = ", ";
  protected final String TEXT_90 = ");";
  protected final String TEXT_91 = NL + "\t\tclass GetJarsToRegister_";
  protected final String TEXT_92 = " {" + NL + "\t\t\tprivate String oozieClasspathLine;" + NL + "\t\t\tprivate boolean isOozieRuntime;" + NL + "\t\t\t" + NL + "\t\t\tpublic GetJarsToRegister_";
  protected final String TEXT_93 = "() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tthis.isOozieRuntime = setJarsToRegister();" + NL + "\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_95 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean setJarsToRegister() throws IOException, org.dom4j.DocumentException {" + NL + "\t\t\t\tString jobXmlPath = new java.io.File(\"../../job.xml\").getCanonicalPath();" + NL + "\t\t\t\tboolean isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\tif(!isOozieExecution) {" + NL + "\t\t\t\t    jobXmlPath = new java.io.File(\"./job.xml\").getCanonicalPath();" + NL + "\t\t\t\t    isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(isOozieExecution) {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.dom4j.io.SAXReader reader_oozie = new org.dom4j.io.SAXReader();" + NL + "\t\t\t\t\torg.dom4j.Document document_oozie = reader_oozie.read(jobXmlPath);" + NL + "\t\t\t\t\tList list_oozie = document_oozie.selectNodes(\"/configuration/property\");" + NL + "\t\t\t\t\tfor (java.util.Iterator iter_oozie = list_oozie.iterator(); iter_oozie.hasNext();) {" + NL + "\t\t\t\t\t\torg.dom4j.Element element_oozie = (org.dom4j.Element) iter_oozie.next();" + NL + "\t\t\t\t\t\tString name_oozie = element_oozie.elementText(\"name\");" + NL + "\t\t\t\t\t\tif(name_oozie.equals(\"mapred.cache.localFiles\") || name_oozie.equals(\"mapreduce.job.cache.local.files\")) {" + NL + "\t\t\t\t\t\t\tthis.oozieClasspathLine = element_oozie.elementText(\"value\");" + NL + "\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\t\treturn replaceJarPaths(originalClassPathLine, \"\");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine, String scheme) throws Exception {" + NL + "\t\t\t\tString classPathLine = \"\";" + NL + "\t\t\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\t\t\t" + NL + "\t\t\t\tif (isNeedAddLibsPath(crcMapPath)) {" + NL + "\t\t\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\t\t\tois.close();" + NL + "\t\t\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t\t\t} else if(this.isOozieRuntime) {" + NL + "\t\t\t\t\tif(this.oozieClasspathLine!=null) {" + NL + "\t\t\t\t\t\tList<String> oozieJars = java.util.Arrays.asList(this.oozieClasspathLine.split(\",\"));" + NL + "\t\t\t\t\t\tfor(int j=0; j<oozieJars.size(); j++) {" + NL + "\t\t\t\t\t\t\tif(oozieJars.get(j).contains(originalClassPathLine.substring(originalClassPathLine.lastIndexOf(\"/\")))) {" + NL + "\t\t\t\t\t\t\t\tclassPathLine = oozieJars.get(j);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tif(originalClassPathLine!=null && originalClassPathLine.startsWith(\".\")) {" + NL + "\t\t\t\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tclassPathLine = scheme + originalClassPathLine;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn classPathLine;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\t\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\t\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\t\t\tString jarName = entry.getValue();" + NL + "\t\t\t\tString crc = entry.getKey();" + NL + "\t\t\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\t\t\tString libStringFinder2 = \"./\" + jarName; // for the job jar itself." + NL + "\t\t\t\t" + NL + "\t\t\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.toLowerCase().contains(libStringFinder2)) {" + NL + "\t\t\t\t\tline = line.toLowerCase().replace(libStringFinder2, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t}" + NL + "" + NL + "                GetJarsToRegister_";
  protected final String TEXT_97 = " getJarsToRegister = new GetJarsToRegister_";
  protected final String TEXT_98 = "();" + NL + "                java.util.List<String> listJar = new java.util.ArrayList<String>();" + NL + "                if(libjars != null) {" + NL + "                    for(String jar:libjars.split(\",\")) {" + NL + "                        listJar.add(jar);" + NL + "                    }" + NL + "                }" + NL + "                listJar.add(getJarsToRegister.replaceJarPaths(\"./\" + \"";
  protected final String TEXT_99 = "\" + \".jar\", \"file://\"));" + NL + "                routines.system.BigDataUtil.installWinutils(";
  protected final String TEXT_100 = ", getJarsToRegister.replaceJarPaths(\"../lib/winutils-hadoop-2.6.0.exe\", \"file://\"));" + NL + "                sparkConfiguration.setJars(listJar.toArray(new String[listJar.size()]));" + NL + "                sparkConfiguration.set(\"spark.local.dir\", ";
  protected final String TEXT_101 = ");" + NL + "" + NL + "                org.apache.spark.api.java.JavaSparkContext ctx = new org.apache.spark.api.java.JavaSparkContext(sparkConfiguration);" + NL;
  protected final String TEXT_102 = NL + "                        org.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_103 = ", ";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = NL + "                    ctx.sc().addSparkListener(new TalendRuntimeSparkListener(sparkConfiguration));";
  protected final String TEXT_106 = NL + "                    ctx.sc().addSparkListener(new TalendEndOfRunSparkListener(jobName));";
  protected final String TEXT_107 = NL + "                ctx.setJobGroup(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId(), \"\");" + NL + "" + NL + "                setContext(ctx.hadoopConfiguration(), ctx);" + NL + "" + NL + "                if (doInspect) {" + NL + "                    System.out.println(\"== inspect start ==\");" + NL + "                    System.out.println(\"{\");" + NL + "                    System.out.println(\"  \\\"SPARK_MASTER\\\": \\\"\" + sparkConfiguration.get(\"spark.master\") + \"\\\",\");" + NL + "                    System.out.println(\"  \\\"SPARK_UI_PORT\\\": \\\"\" + sparkConfiguration.get(\"spark.ui.port\", \"4040\") + \"\\\",\");" + NL + "                    System.out.println(\"  \\\"JOB_NAME\\\": \\\"\" + sparkConfiguration.get(\"spark.app.name\", jobName) + \"\\\"\");" + NL + "                    System.out.println(\"}\"); //$NON-NLS-1$" + NL + "                    System.out.println(\"== inspect end ==\");" + NL + "                }";
  protected final String TEXT_108 = NL;
  protected final String TEXT_109 = NL + "                if(log.is";
  protected final String TEXT_110 = "Enabled())";
  protected final String TEXT_111 = NL + "            log.";
  protected final String TEXT_112 = "(\"";
  protected final String TEXT_113 = " - \" ";
  protected final String TEXT_114 = " + ";
  protected final String TEXT_115 = " ";
  protected final String TEXT_116 = ");";
  protected final String TEXT_117 = NL + "            StringBuilder ";
  protected final String TEXT_118 = " = new StringBuilder();";
  protected final String TEXT_119 = NL + "            ";
  protected final String TEXT_120 = ".append(\"Parameters:\");";
  protected final String TEXT_121 = NL + "                    ";
  protected final String TEXT_122 = ".append(\"";
  protected final String TEXT_123 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_124 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_125 = NL + "                    ";
  protected final String TEXT_126 = ".append(\"";
  protected final String TEXT_127 = "\" + \" = \" + ";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "                ";
  protected final String TEXT_130 = ".append(\" | \");";
  protected final String TEXT_131 = NL + "            StringBuilder ";
  protected final String TEXT_132 = " = new StringBuilder();    ";
  protected final String TEXT_133 = NL + "                    ";
  protected final String TEXT_134 = ".append(";
  protected final String TEXT_135 = ".";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL + "                    if(";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = " == null){";
  protected final String TEXT_140 = NL + "                        ";
  protected final String TEXT_141 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_142 = NL + "                        ";
  protected final String TEXT_143 = ".append(";
  protected final String TEXT_144 = ".";
  protected final String TEXT_145 = ");" + NL + "                    }   ";
  protected final String TEXT_146 = NL + "                ";
  protected final String TEXT_147 = ".append(\"|\");";
  protected final String TEXT_148 = NL + "                            log.info(\"A <";
  protected final String TEXT_149 = "> configuration component has been found.\");";
  protected final String TEXT_150 = NL + "                        try {" + NL + "                            globalMap = new GlobalVar(ctx.hadoopConfiguration());";
  protected final String TEXT_151 = NL + "                            ";
  protected final String TEXT_152 = "Process(ctx, globalMap);" + NL + "                        } catch(Exception e) {" + NL + "                            e.printStackTrace();" + NL + "                            e.printStackTrace(errorMessagePS);" + NL + "                            status = \"failure\";" + NL + "                            return 1;" + NL + "                        } finally {" + NL + "                            ctx.cancelJobGroup(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId());" + NL + "                            ctx.stop();";
  protected final String TEXT_153 = NL + "                                if (execStat) {" + NL + "                                    runStat.stopThreadStat();" + NL + "                                }";
  protected final String TEXT_154 = NL + "                        }";
  protected final String TEXT_155 = NL + NL + "                return 0;" + NL + "            } catch(Exception ex) {" + NL + "                ex.printStackTrace();" + NL + "                return 1;" + NL + "            }";
  protected final String TEXT_156 = NL + "    }" + NL + "" + NL + "    private String genTempFolderForComponent(String name) {" + NL + "        java.io.File tempDir = new java.io.File(\"/tmp/\" + pid, name);" + NL + "        String tempDirPath = tempDir.getPath();" + NL + "        if (java.io.File.separatorChar != '/')" + NL + "            tempDirPath = tempDirPath.replace(java.io.File.separatorChar, '/');" + NL + "        return tempDirPath;" + NL + "    }" + NL + "" + NL + "    private void initContext(){" + NL + "        //get context" + NL + "        try{" + NL + "            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead." + NL + "            java.io.InputStream inContext = ";
  protected final String TEXT_157 = ".class.getClassLoader().getResourceAsStream(\"";
  protected final String TEXT_158 = "/";
  protected final String TEXT_159 = "/contexts/\"+contextStr+\".properties\");" + NL + "            if(isDefaultContext && inContext == null){" + NL + "" + NL + "            }else{" + NL + "                if(inContext!=null){" + NL + "                    //defaultProps is in order to keep the original context value" + NL + "                    defaultProps.load(inContext);" + NL + "                    inContext.close();" + NL + "                    context = new ContextProperties(defaultProps);" + NL + "                }else{" + NL + "                    //print info and job continue to run, for case: context_param is not empty." + NL + "                    System.err.println(\"Could not find the context \" + contextStr);" + NL + "                }" + NL + "            }" + NL + "" + NL + "            if(!context_param.isEmpty()){" + NL + "                context.putAll(context_param);" + NL + "            }" + NL + "            context.loadValue(context_param,null);" + NL + "            if(parentContextMap != null && !parentContextMap.isEmpty()){";
  protected final String TEXT_160 = NL + "                    if(parentContextMap.containsKey(\"";
  protected final String TEXT_161 = "\")){" + NL + "                        context.";
  protected final String TEXT_162 = " = (";
  protected final String TEXT_163 = ") parentContextMap.get(\"";
  protected final String TEXT_164 = "\");" + NL + "                    }";
  protected final String TEXT_165 = NL + "            }" + NL + "        }catch (java.io.IOException ie){" + NL + "            System.err.println(\"Could not load context \"+contextStr);" + NL + "            ie.printStackTrace();" + NL + "        }" + NL + "    }" + NL + "" + NL + "    private void setContext(Configuration conf, org.apache.spark.api.java.JavaSparkContext ctx){" + NL + "        //get context" + NL + "        //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead." + NL + "        java.net.URL inContextUrl = ";
  protected final String TEXT_166 = ".class.getClassLoader().getResource(\"";
  protected final String TEXT_167 = "/";
  protected final String TEXT_168 = "/contexts/\"+contextStr+\".properties\");" + NL + "        if(isDefaultContext && inContextUrl == null){" + NL + "" + NL + "        }else{" + NL + "            if(inContextUrl!=null){" + NL + "                conf.set(ContextProperties.CONTEXT_FILE_NAME, contextStr+\".properties\");";
  protected final String TEXT_169 = NL + "                    ctx.addFile(inContextUrl.getPath());";
  protected final String TEXT_170 = NL + NL + "            }" + NL + "        }" + NL + "" + NL + "        if(!context_param.isEmpty()){" + NL + "            for(Object contextKey : context_param.keySet()){" + NL + "                conf.set(ContextProperties.CONTEXT_PARAMS_PREFIX + contextKey, context.getProperty(contextKey.toString()));" + NL + "                conf.set(ContextProperties.CONTEXT_KEYS, conf.get(ContextProperties.CONTEXT_KEYS, \"\") + \" \" + contextKey);" + NL + "            }" + NL + "        }" + NL + "" + NL + "        if(parentContextMap != null && !parentContextMap.isEmpty()){";
  protected final String TEXT_171 = NL + "                if(parentContextMap.containsKey(\"";
  protected final String TEXT_172 = "\")){" + NL + "                    conf.set(ContextProperties.CONTEXT_PARENT_PARAMS_PREFIX + \"";
  protected final String TEXT_173 = "\", parentContextMap.get(\"";
  protected final String TEXT_174 = "\").toString());" + NL + "                    conf.set(ContextProperties.CONTEXT_PARENT_KEYS, conf.get(ContextProperties.CONTEXT_KEYS, \"\") + \" \" + \"";
  protected final String TEXT_175 = "\");" + NL + "                }";
  protected final String TEXT_176 = NL + "        }" + NL + "    }" + NL + "" + NL + "    private void evalParam(String arg) {" + NL + "        if (arg.startsWith(\"--resuming_logs_dir_path\")) {" + NL + "            resuming_logs_dir_path = arg.substring(25);" + NL + "        } else if (arg.startsWith(\"--resuming_checkpoint_path\")) {" + NL + "            resuming_checkpoint_path = arg.substring(27);" + NL + "        } else if (arg.startsWith(\"--parent_part_launcher\")) {" + NL + "            parent_part_launcher = arg.substring(23);" + NL + "        } else if (arg.startsWith(\"--father_pid=\")) {" + NL + "            fatherPid = arg.substring(13);" + NL + "        } else if (arg.startsWith(\"--root_pid=\")) {" + NL + "            rootPid = arg.substring(11);" + NL + "        } else if (arg.startsWith(\"--pid=\")) {" + NL + "            pid = arg.substring(6);" + NL + "        } else if (arg.startsWith(\"--context=\")) {" + NL + "            contextStr = arg.substring(\"--context=\".length());" + NL + "            isDefaultContext = false;" + NL + "        } else if (arg.startsWith(\"--context_param\")) {" + NL + "            String keyValue = arg.substring(\"--context_param\".length() + 1);" + NL + "            int index = -1;" + NL + "            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {" + NL + "                context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));" + NL + "            }" + NL + "        } else if (arg.startsWith(\"--stat_port=\")) {" + NL + "            String portStatsStr = arg.substring(12);" + NL + "            if (portStatsStr != null && !portStatsStr.equals(\"null\")) {" + NL + "                portStats = Integer.parseInt(portStatsStr);" + NL + "            }" + NL + "        } else if (arg.startsWith(\"--client_host=\")) {" + NL + "            clientHost = arg.substring(14);" + NL + "        } else if (arg.startsWith(\"--log4jLevel=\")) {" + NL + "            log4jLevel = arg.substring(13);" + NL + "        } else if (arg.startsWith(\"--inspect\")) {" + NL + "            doInspect = Boolean.valueOf(arg.substring(\"--inspect=\".length()));" + NL + "        }" + NL + "    }" + NL + "" + NL + "    private void normalizeArgs(String[] args){" + NL + "        java.util.List<String> argsList = java.util.Arrays.asList(args);" + NL + "        int indexlibjars = argsList.indexOf(\"-libjars\") + 1;" + NL + "        libjars = indexlibjars == 0 ? null : argsList.get(indexlibjars);" + NL + "    }" + NL + "" + NL + "    private final String[][] escapeChars = {" + NL + "        {\"\\\\\\\\\",\"\\\\\"},{\"\\\\n\",\"\\n\"},{\"\\\\'\",\"\\'\"},{\"\\\\r\",\"\\r\"}," + NL + "        {\"\\\\f\",\"\\f\"},{\"\\\\b\",\"\\b\"},{\"\\\\t\",\"\\t\"}" + NL + "        };" + NL + "    private String replaceEscapeChars (String keyValue) {" + NL + "" + NL + "        if (keyValue == null || (\"\").equals(keyValue.trim())) {" + NL + "            return keyValue;" + NL + "        }" + NL + "" + NL + "        StringBuilder result = new StringBuilder();" + NL + "        int currIndex = 0;" + NL + "        while (currIndex < keyValue.length()) {" + NL + "            int index = -1;" + NL + "            // judege if the left string includes escape chars" + NL + "            for (String[] strArray : escapeChars) {" + NL + "                index = keyValue.indexOf(strArray[0],currIndex);" + NL + "                if (index>=0) {" + NL + "" + NL + "                    result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));" + NL + "                    currIndex = index + strArray[0].length();" + NL + "                    break;" + NL + "                }" + NL + "            }" + NL + "            // if the left string doesn't include escape chars, append the left into the result" + NL + "            if (index < 0) {" + NL + "                result.append(keyValue.substring(currIndex));" + NL + "                currIndex = currIndex + keyValue.length();" + NL + "            }" + NL + "        }" + NL + "" + NL + "        return result.toString();" + NL + "    }" + NL + "" + NL + "    public String getStatus() {" + NL + "        return status;" + NL + "    }" + NL + "}";
  protected final String TEXT_177 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    Vector v = (Vector) codeGenArgument.getArgument();
    IProcess process = (IProcess)v.get(0);
    List<INode> rootNodes = (List<INode>)v.get(1);
    List<INode> confNodes = new ArrayList<INode>(rootNodes);

    INode sparkConfig = (INode)v.get(2);
    confNodes.add(sparkConfig);

    String processId = process.getId();

    String cid = "Spark";
    String jobFolderName = JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
    List<IContextParameter> params = new ArrayList<IContextParameter>();
    params=process.getContextManager().getDefaultContext().getContextParameterList();
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));
    boolean tuningProperties = "true".equals(ElementParameterParser.getValue(sparkConfig, "__ADVANCED_SETTINGS_CHECK__"));
    boolean setWebuiPort = "true".equals(ElementParameterParser.getValue(sparkConfig, "__WEB_UI_PORT_CHECK__"));

    String sparkMode = ElementParameterParser.getValue(sparkConfig, "__SPARK_MODE__");
    String distribution = ElementParameterParser.getValue(sparkConfig, "__DISTRIBUTION__");
    String sparkVersion = ElementParameterParser.getValue(sparkConfig, "__SPARK_VERSION__");
    List<Map<String, String>> sparkAdvancedProperties = (List<Map<String,String>>)ElementParameterParser.getObjectValue(sparkConfig, "__SPARK_ADVANCED_PROPERTIES__");

    boolean useLocalMode = "LOCAL".equals(sparkMode);
    boolean useStandaloneMode = "CLUSTER".equals(sparkMode);
    boolean useYarnClientMode = "YARN_CLIENT".equals(sparkMode);
    boolean useYarnClusterMode = "YARN_CLUSTER".equals(sparkMode);
    boolean useYarnMode = useYarnClusterMode || useYarnClientMode;

    java.util.List<String> jarsToRegister = null;

    boolean stats = codeGenArgument.isStatistics();

    // Kerberos variables
    boolean useKrb = false;
    boolean useKeytab = false;
    String keytabPrincipal = null;
    String keytabPath = null;

    String username = null;

    // Spark configurations for caching
    // In case we have multiple components that set different configurations, the last component in the list imposes its configurations
    List<INode> cacheConfNodes = new ArrayList<INode>();
    // tCacheOut nodes
    for (INode pNode : process.getNodesOfType("tCacheOut")) {
        cacheConfNodes.add(pNode);
    }
    // tReplicate nodes
    for (INode pNode : process.getNodesOfType("tReplicate")) {
        cacheConfNodes.add(pNode);
    }
    // Parse nodes and setup configuration map
    for (INode pNode : cacheConfNodes) {
        boolean compressRdd = ("true").equals(ElementParameterParser.getValue(pNode, "__COMPRESSRDD__"));
        String compressCodec = ElementParameterParser.getValue(pNode, "__COMPRESSCODEC__");
        String storageLevel = ElementParameterParser.getValue(pNode, "__STORAGELEVEL__");
        String tachyonStoreUrl = ElementParameterParser.getValue(pNode, "__TACHYON_STORE_URL__");
        String tachyonStoreBaseDir = ElementParameterParser.getValue(pNode, "__TACHYON_STORE_BASEDIR__");

        if(storageLevel.equals("OFF_HEAP")){
            Map<String, String> tachyonStoreUrlMap = new HashMap<String, String>();
            tachyonStoreUrlMap.put("PROPERTY","\"spark.tachyonStore.url\"");
            tachyonStoreUrlMap.put("VALUE",tachyonStoreUrl);
            sparkAdvancedProperties.add(tachyonStoreUrlMap);
            Map<String, String> tachyonStoreBaseDirMap = new HashMap<String, String>();
            tachyonStoreBaseDirMap.put("PROPERTY","\"spark.tachyonStore.baseDir\"");
            tachyonStoreBaseDirMap.put("VALUE",tachyonStoreBaseDir);
            sparkAdvancedProperties.add(tachyonStoreBaseDirMap);
        }

        if(compressRdd && (storageLevel.equals("MEMORY_ONLY_SER") || storageLevel.equals("MEMORY_AND_DISK_SER") || storageLevel.equals("MEMORY_AND_DISK_SER") || storageLevel.equals("MEMORY_ONLY_SER_2") || storageLevel.equals("MEMORY_AND_DISK_SER_2"))){
            Map<String, String> rddCompression = new HashMap<String, String>();
            rddCompression.put("PROPERTY", "\"spark.rdd.compress\"");
            rddCompression.put("VALUE", "\"true\"");
            sparkAdvancedProperties.add(rddCompression);
            Map<String, String> rddCompressionCodec = new HashMap<String, String>();
            rddCompressionCodec.put("PROPERTY", "\"spark.io.compression.codec\"");
            rddCompressionCodec.put("VALUE", '"'+compressCodec+'"');
            sparkAdvancedProperties.add(rddCompressionCodec);
        }
    }

    // tS3Configuration component generation.
    List<INode> s3Nodes = new ArrayList<INode>();
    for (INode pNode : process.getNodesOfType("tS3Configuration")) {
        s3Nodes.add(pNode);
    }

    if(s3Nodes.size() > 1) {

    stringBuffer.append(TEXT_2);
    
    }
    if(s3Nodes.size() == 1) {
        INode pNode = s3Nodes.get(0);
        // the configuration components must not be considered as a root node.
        rootNodes.remove(pNode);
        Map<String, String> s3Properties = new HashMap<String, String>();
        s3Properties.put("PROPERTY", "\"spark.hadoop.fs.s3.impl\"");
        s3Properties.put("VALUE", "\"org.apache.hadoop.fs.s3native.NativeS3FileSystem\"");
        sparkAdvancedProperties.add(s3Properties);
        s3Properties = new HashMap<String, String>();
        s3Properties.put("PROPERTY", "\"spark.hadoop.fs.s3.awsAccessKeyId\"");
        s3Properties.put("VALUE", ElementParameterParser.getValue(pNode, "__ACCESS_KEY__"));
        sparkAdvancedProperties.add(s3Properties);
        s3Properties = new HashMap<String, String>();
        s3Properties.put("PROPERTY", "\"spark.hadoop.fs.s3.awsSecretAccessKey\"");
        String passwordFieldName = "__SECRET_KEY__";
        String password = "";
        if (ElementParameterParser.canEncrypt(pNode, passwordFieldName)) {
            password = ElementParameterParser.getEncryptedValue(pNode, passwordFieldName);
            password = "routines.system.PasswordEncryptUtil.decryptPassword(" + password + ")";
        } else {
            password = ElementParameterParser.getValue(pNode, passwordFieldName);
        }
        s3Properties.put("VALUE", password);
        sparkAdvancedProperties.add(s3Properties);
    }
    //End of tS3Configuration component generation.

// tTachyonConfiguration component generation.
    List<INode> tTachyonNodes = new ArrayList<INode>();
    for (INode pNode : process.getNodesOfType("tTachyonConfiguration")) {
        tTachyonNodes.add(pNode);
    }

    if(tTachyonNodes.size() > 1) {

    stringBuffer.append(TEXT_3);
    
    }
    if(tTachyonNodes.size() == 1) {
        INode pNode = tTachyonNodes.get(0);
        // the configuration components must not be considered as a root node.
        rootNodes.remove(pNode);

        Map<String, String> tachyonProperties = new HashMap<String, String>();
        tachyonProperties.put("PROPERTY", "\"spark.hadoop.fs.tachyon.impl\"");
        tachyonProperties.put("VALUE", "\"tachyon.hadoop.TFS\"");
        sparkAdvancedProperties.add(tachyonProperties);

        //Set underFS username
        //May conflict with the username set HDFSConfiguration
        //The username is used when the Spark worker is not on the same node as the tachyon worker, in this case the the write goes directly
        // to the UnderFS which requires a authentication (in the case of HDFS).
        username = ElementParameterParser.getValue(pNode, "__UNDERFS_USERNAME__");

    }
    //End of tTachyonConfiguration component generation.

    // tHDFSConfiguration component generation.
    List<INode> hdfsNodes = new ArrayList<INode>();
    for (INode pNode : process.getNodesOfType("tHDFSConfiguration")) {
        hdfsNodes.add(pNode);
    }

    if(hdfsNodes.size() > 1) {

    stringBuffer.append(TEXT_4);
    
    }
    if(hdfsNodes.size() == 1) {
        INode pNode = hdfsNodes.get(0);
        // the configuration components must not be considered as a root node.
        rootNodes.remove(pNode);

        Map<String, String> hdfsProperties = new HashMap<String, String>();
        hdfsProperties.put("PROPERTY", "\"spark.hadoop.fs.defaultFS\"");
        hdfsProperties.put("VALUE", ElementParameterParser.getValue(pNode, "__FS_DEFAULT_NAME__"));
        sparkAdvancedProperties.add(hdfsProperties);

        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(pNode, "__USE_DATANODE_HOSTNAME__"));
        if(mrUseDatanodeHostname) {
            hdfsProperties = new HashMap<String, String>();
            hdfsProperties.put("PROPERTY", "\"spark.hadoop.dfs.client.use.datanode.hostname\"");
            hdfsProperties.put("VALUE", "\"true\"");
            sparkAdvancedProperties.add(hdfsProperties);
        }

        String hadoopVersion = ElementParameterParser.getValue(pNode, "__DB_VERSION__");
        List<String> supportKrbVersionList = java.util.Arrays.<String>asList(
            "Cloudera_CDH4","Cloudera_CDH4_YARN","Cloudera_CDH5","Cloudera_CDH5_1","Cloudera_CDH5_4","Cloudera_CDH5_1_MR1",
            "HDP_1_2","HDP_1_3","HDP_2_0","HDP_2_1","HDP_2_2",
            "APACHE_1_0_0","APACHE_1_0_3_EMR",
            "PIVOTAL_HD_2_0");

        useKrb = "true".equals(ElementParameterParser.getValue(pNode, "__USE_KRB__")) && (hadoopVersion!=null && supportKrbVersionList.contains(hadoopVersion));
        if(useKrb) {
            hdfsProperties = new HashMap<String, String>();
            hdfsProperties.put("PROPERTY", "\"spark.hadoop.dfs.namenode.kerberos.principal\"");
            hdfsProperties.put("VALUE", ElementParameterParser.getValue(pNode, "__NAMENODE_PRINCIPAL__"));
            sparkAdvancedProperties.add(hdfsProperties);
            hdfsProperties = new HashMap<String, String>();
            hdfsProperties.put("PROPERTY", "\"spark.hadoop.hadoop.security.authorization\"");
            hdfsProperties.put("VALUE", "\"true\"");
            sparkAdvancedProperties.add(hdfsProperties);
            hdfsProperties = new HashMap<String, String>();
            hdfsProperties.put("PROPERTY", "\"spark.hadoop.hadoop.security.authentication\"");
            hdfsProperties.put("VALUE", "\"kerberos\"");
            sparkAdvancedProperties.add(hdfsProperties);
            useKeytab = "true".equals(ElementParameterParser.getValue(pNode, "__USE_KEYTAB__"));
            if(useKeytab) {
                keytabPrincipal = ElementParameterParser.getValue(pNode, "__PRINCIPAL__");
                keytabPath = ElementParameterParser.getValue(pNode, "__KEYTAB_PATH__");
            }
        } else {
            username = ElementParameterParser.getValue(pNode, "__USERNAME__");
        }

        List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(pNode, "__HADOOP_ADVANCED_PROPERTIES__");
        for(Map<String, String> item : hadoopProps){
            hdfsProperties = new HashMap<String, String>();
            hdfsProperties.put("PROPERTY", "\"spark.hadoop.\" + " + item.get("PROPERTY"));
            hdfsProperties.put("VALUE", item.get("VALUE"));
            sparkAdvancedProperties.add(hdfsProperties);
        }
    }
    //End of tHDFSConfiguration component generation.

    // tCassandraConfiguration component generation.
    List<INode> cassandraNodes = new ArrayList<INode>();
    for (INode pNode : process.getNodesOfType("tCassandraConfiguration")) {
        cassandraNodes.add(pNode);
    }

    if(cassandraNodes.size() > 1) {
    
    stringBuffer.append(TEXT_5);
    
    }
    if(cassandraNodes.size() == 1) {
        INode pNode = cassandraNodes.get(0);
        // the configuration components must not be considered as a root node.
        rootNodes.remove(pNode);
        
    
class CassandraConfiguration_Helper{
	public Map<String, String> getProperties(INode node){
		java.util.Map<String, String> properties = new java.util.HashMap<String, String>();
		
        java.util.List<java.util.Map<String, String>> configurations = (java.util.List<java.util.Map<String, String>>)ElementParameterParser.getObjectValue(node, "__CASSANDRA_CONFIGURATION__");
        //remove some key from the configuration table, but can remove it from migration task, so ignore them on code generate stage
        java.util.List<String> ignoreConfList = new java.util.ArrayList<String>();
        ignoreConfList.add("connection_rpc_port");//"spark.cassandra.connection.rpc.port"
		ignoreConfList.add("connection_native_port");//"spark.cassandra.connection.native.port"
        java.util.Map<String, String> confMapping = new java.util.HashMap<String, String>();
        confMapping.put("connection_conf_factory","spark.cassandra.connection.conf.factory");
        confMapping.put("connection_keep_alive_ms","spark.cassandra.connection.keep_alive_ms");
        confMapping.put("connection_timeout_ms","spark.cassandra.connection.timeout_ms");
        confMapping.put("reconnection_delay_ms_min","spark.cassandra.connection.reconnection_delay_ms.min");
        confMapping.put("connection_reconnection_delay_ms_max","spark.cassandra.connection.reconnection_delay_ms.max");
        confMapping.put("connection_local_dc","spark.cassandra.connection.local_dc");
        confMapping.put("auth_conf_factory","spark.cassandra.auth.conf.factory");
        confMapping.put("query_retry_count","spark.cassandra.query.retry.count");
        confMapping.put("read_timeout_ms","spark.cassandra.read.timeout_ms");   
        confMapping.put("input_split_size","spark.cassandra.input.split.size");
        confMapping.put("input_page_row_size","spark.cassandra.input.page.row.size");
        confMapping.put("input_consistency_level","spark.cassandra.input.consistency.level");
        for(java.util.Map<String, String> conf : configurations){
            String confKey = conf.get("KEY");
            if(ignoreConfList.contains(confKey)){
            	continue;
            }
            String propertyKey = confMapping.containsKey(confKey) ? "\"" + confMapping.get(confKey) + "\"" : confKey;
            properties.put(propertyKey, conf.get("VALUE"));
        }
        String host = ElementParameterParser.getValue(node,"__HOST__");
        if(!"".equals(host)){
        	properties.put("\"spark.cassandra.connection.host\"", host);
        }
        String port = ElementParameterParser.getValue(node,"__PORT__");
        if(!"".equals(port)){
        	properties.put("\"spark.cassandra.connection.port\"", port);
        }
        boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
        String userName = ElementParameterParser.getValue(node, "__USERNAME__");
        String passWord = ElementParameterParser.getPasswordValue(node, "__PASSWORD__");
        if(authentication){
            properties.put("\"spark.cassandra.auth.username\"", userName);
            properties.put("\"spark.cassandra.auth.password\"", passWord);
        }  
        
        return properties; 
	}
	
	public Map<String, String> getPropertiesForOutput(INode node){
		java.util.Map<String, String> properties = new java.util.HashMap<String, String>();
		
        java.util.List<java.util.Map<String, String>> configurations = (java.util.List<java.util.Map<String, String>>)ElementParameterParser.getObjectValue(node, "__CASSANDRA_CONFIGURATION__");
        java.util.Map<String, String> confMapping = new java.util.HashMap<String, String>();
        confMapping.put("output_batch_size_rows","spark.cassandra.output.batch.size.rows");
        confMapping.put("output_batch_size_bytes","spark.cassandra.output.batch.size.bytes");
        confMapping.put("output_batch_grouping_key","spark.cassandra.output.batch.grouping.key");
        confMapping.put("output_batch_buffer_size","spark.cassandra.output.batch.buffer.size");
        confMapping.put("output_concurrent_writes","spark.cassandra.output.concurrent.writes");
        confMapping.put("output_consistency_level","spark.cassandra.output.consistency.level");
        confMapping.put("output_throughput_mb_per_sec","spark.cassandra.output.throughput_mb_per_sec");
        for(java.util.Map<String, String> conf : configurations){
            String confKey = conf.get("KEY");
            String propertyKey = confMapping.containsKey(confKey) ? "\"" + confMapping.get(confKey) + "\"" : confKey;
            properties.put(propertyKey, conf.get("VALUE"));
        }
        
        return properties; 
	}
}	

    
        Map<String, String> cassandraProperties = (new CassandraConfiguration_Helper()).getProperties(pNode);
        for(String cPropKey : cassandraProperties.keySet()){
            Map<String, String> cProperty = new HashMap<String, String>();
            cProperty.put("PROPERTY", cPropKey);
            cProperty.put("VALUE", cassandraProperties.get(cPropKey));
            sparkAdvancedProperties.add(cProperty);
        }
    }
    //End of tCassandraConfiguration component generation.
    
    stringBuffer.append(TEXT_6);
    
	// This is the TalendKryoRegistrator class generation part.

    stringBuffer.append(TEXT_7);
    
			Iterable<String> structNameList = (Iterable<String>) v.get(3);		
			for(String structName : structNameList) {
		
    stringBuffer.append(TEXT_8);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_9);
    
			} 
		
    stringBuffer.append(TEXT_10);
    stringBuffer.append(codeGenArgument.getContextName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(codeGenArgument.getJobName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(codeGenArgument.getJobName());
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(codeGenArgument.getJobName());
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    
        if(stats) {

    stringBuffer.append(TEXT_20);
    
        }

        if(username != null && !"".equals(username)) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_23);
    
        }

        // this snippet to solve an issue in Spark Driver on MacOSX with snappy
        // you have to run with -Dorg.xerial.snappy.lib.name=libsnappyjava.jnilib

    stringBuffer.append(TEXT_24);
    
        if(sparkConfig!=null) {

    stringBuffer.append(TEXT_25);
    
                String master = "\"local[*]\"";
                if(useStandaloneMode) {
                    master = ElementParameterParser.getValue(sparkConfig, "__SPARK_HOST__");
                }

                if(useYarnClientMode) {
                    master = "\"yarn-client\"";
                }

                if(useYarnClusterMode) {
                    master = "\"yarn-cluster\"";
                }

    stringBuffer.append(TEXT_26);
    stringBuffer.append(master);
    stringBuffer.append(TEXT_27);
    
                if(!useLocalMode) { // If the spark mode is not local.
                    boolean defineDriverHost = "true".equals(ElementParameterParser.getValue(sparkConfig, "__DEFINE_SPARK_DRIVER_HOST__"));
                    if(defineDriverHost) {
                        String driverHost = ElementParameterParser.getValue(sparkConfig, "__SPARK_DRIVER_HOST__");
                        if(driverHost != null && !"".equals(driverHost)) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(driverHost);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(driverHost);
    stringBuffer.append(TEXT_30);
    
                        }
                    }                
                    if(useStandaloneMode) {
                        String sparkHome = ElementParameterParser.getValue(sparkConfig, "__SPARK_HOME__");

    stringBuffer.append(TEXT_31);
    stringBuffer.append(sparkHome);
    stringBuffer.append(TEXT_32);
    
                    } else if(useYarnMode) {
                        // Set the YARN parameters in the SparkConf
                        String resourceManager = ElementParameterParser.getValue(sparkConfig, "__RESOURCE_MANAGER__");
                        boolean setResourceManagerSchedulerAddress = "true".equals(ElementParameterParser.getValue(sparkConfig, "__SET_SCHEDULER_ADDRESS__"));
                        boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(sparkConfig, "__SET_JOBHISTORY_ADDRESS__"));
                        boolean setStagingDirectory = "true".equals(ElementParameterParser.getValue(sparkConfig, "__SET_STAGING_DIRECTORY__"));
                        boolean setMemory = "true".equals(ElementParameterParser.getValue(sparkConfig, "__SET_MEMORY__"));

                        if ("MAPR_410".equals(sparkVersion)) {
                            
    stringBuffer.append(TEXT_33);
    
                        } else if ("EMR_4_0_0".equals(sparkVersion)) {
                            
    stringBuffer.append(TEXT_34);
    
                        } else if("Cloudera_CDH5_4".equals(sparkVersion)) {
                            
    stringBuffer.append(TEXT_35);
    
                        } else {
                            
    stringBuffer.append(TEXT_36);
    
                        }

    stringBuffer.append(TEXT_37);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_38);
    if(setResourceManagerSchedulerAddress) { 
    stringBuffer.append(TEXT_39);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__RESOURCEMANAGER_SCHEDULER_ADDRESS__"));
    stringBuffer.append(TEXT_40);
     } 
    if(setJobHistoryAddress) { 
    stringBuffer.append(TEXT_41);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__JOBHISTORY_ADDRESS__"));
    stringBuffer.append(TEXT_42);
     } 
    if(setStagingDirectory) { 
    stringBuffer.append(TEXT_43);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__STAGING_DIRECTORY__"));
    stringBuffer.append(TEXT_44);
     } 
    if(setMemory) { 
    stringBuffer.append(TEXT_45);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__MAPREDUCE_MAP_MEMORY_MB__"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__MAPREDUCE_REDUCE_MEMORY_MB__"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__"));
    stringBuffer.append(TEXT_48);
     } 
    
                        boolean sparkUseKrb = "true".equals(ElementParameterParser.getValue(sparkConfig, "__USE_KRB__"));
                        if(sparkUseKrb) {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__RESOURCEMANAGER_PRINCIPAL__"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__JOBHISTORY_PRINCIPAL__"));
    stringBuffer.append(TEXT_51);
    
                            boolean sparkUseKeytab = "true".equals(ElementParameterParser.getValue(sparkConfig, "__USE_KEYTAB__"));
                            if(sparkUseKeytab) {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__PRINCIPAL__"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__KEYTAB_PATH__"));
    stringBuffer.append(TEXT_54);
    
                            }
                        } else {
                            String sparkUsername = ElementParameterParser.getValue(sparkConfig, "__USERNAME__");
                            if(sparkUsername != null) {
                                if(username != null) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(sparkUsername);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_57);
    
                                }
                                if(!"".equals(sparkUsername)) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(sparkUsername);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(sparkUsername);
    stringBuffer.append(TEXT_60);
    
                                }
                            }
                        }
                    }
                } // End of: If the spark mode is not local.

                boolean defineHadoopHomeDir = "true".equals(ElementParameterParser.getValue(sparkConfig, "__DEFINE_HADOOP_HOME_DIR__"));
                if(defineHadoopHomeDir) {
                
    stringBuffer.append(TEXT_61);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__HADOOP_HOME_DIR__"));
    stringBuffer.append(TEXT_62);
    
                }

                if(tuningProperties) {
                    // Set Web UI port
                    if(setWebuiPort) {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__WEB_UI_PORT__"));
    stringBuffer.append(TEXT_64);
    
                    }

    stringBuffer.append(TEXT_65);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_DRIVER_MEM__"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_EXECUTOR_MEM__"));
    stringBuffer.append(TEXT_67);
    
                    if(useStandaloneMode || useYarnClusterMode) {

    stringBuffer.append(TEXT_68);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_DRIVER_CORES__"));
    stringBuffer.append(TEXT_69);
    
                    } else if(useYarnClientMode) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_DRIVER_CORES__"));
    stringBuffer.append(TEXT_71);
    
                    }
                    boolean setExecutorCores = "true".equals(ElementParameterParser.getValue(sparkConfig, "__SPARK_EXECUTOR_CORES_CHECK__"));
                    if(setExecutorCores && !useLocalMode) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_EXECUTOR_CORES__"));
    stringBuffer.append(TEXT_73);
    
                    }

                    if(useYarnMode) {
                        String allocationMode = ElementParameterParser.getValue(sparkConfig, "__SPARK_YARN_ALLOC_TYPE__");
                        // we do nothing in AUTO mode
                        if("FIXED".equalsIgnoreCase(allocationMode)) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_EXECUTOR_INSTANCES__"));
    stringBuffer.append(TEXT_75);
    
                        } else if("DYNAMIC".equalsIgnoreCase(allocationMode) && ("CUSTOM".equals(distribution) || "CLOUDERA".equals(distribution) || ("AMAZON_EMR".equals(distribution) && "EMR_4_0_0".equals(sparkVersion)))) {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_YARN_DYN_INIT__"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_YARN_DYN_MIN__"));
    stringBuffer.append(TEXT_78);
    
                            String dynMaxValue = ElementParameterParser.getValue(sparkConfig, "__SPARK_YARN_DYN_MAX__");
                            if(dynMaxValue.contains("MAX")) {

    stringBuffer.append(TEXT_79);
    
                            }
                            else {

    stringBuffer.append(TEXT_80);
    stringBuffer.append(dynMaxValue);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(dynMaxValue);
    stringBuffer.append(TEXT_82);
    
                            }

    stringBuffer.append(TEXT_83);
    
                        }
                    }
                    String broadcastFactory = ElementParameterParser.getValue(sparkConfig, "__SPARK_BROADCAST_FACTORY__");
                    // we do nothing in auto mode
                    if("TORRENT".equalsIgnoreCase(broadcastFactory)) {

    stringBuffer.append(TEXT_84);
    
                    } else if ("HTTP".equalsIgnoreCase(broadcastFactory)) {

    stringBuffer.append(TEXT_85);
    
                    }

                    boolean customizeSparkSerializer = "true".equals(ElementParameterParser.getValue(sparkConfig, "__CUSTOMIZE_SPARK_SERIALIZER__"));
                    if(customizeSparkSerializer) {

    stringBuffer.append(TEXT_86);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_SERIALIZER__"));
    stringBuffer.append(TEXT_87);
                            
                    }

                } // end set of tuning properties

                for(Map<String, String> property : sparkAdvancedProperties){

    stringBuffer.append(TEXT_88);
    stringBuffer.append(property.get("PROPERTY"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(property.get("VALUE"));
    stringBuffer.append(TEXT_90);
    
                }

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    }
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(jobFolderName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_SCRATCH_DIR__"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_SCRATCH_DIR__"));
    stringBuffer.append(TEXT_101);
    
                if(useKrb) {
                    if(useKeytab) {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(keytabPrincipal);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_104);
    
                    }
                }

                if(stats) {

    stringBuffer.append(TEXT_105);
    
                }
                if(isLog4jEnabled) {

    stringBuffer.append(TEXT_106);
    
                }

    stringBuffer.append(TEXT_107);
    
                if(isLog4jEnabled) {

    stringBuffer.append(TEXT_108);
    
class BasicLogUtil{
    protected String cid  = "";
    protected org.talend.core.model.process.INode node = null;
    protected boolean log4jEnabled = false;
    private String logID = "";
    
    private BasicLogUtil(){}
    
    public BasicLogUtil(org.talend.core.model.process.INode node){
        this.node = node;
        String cidx = this.node.getUniqueName();
        if(cidx.matches("^.*?tAmazonAuroraOutput_\\d+_out$")){
             cidx = cidx.substring(0,cidx.length()-4);// 4 ==> "_out".length();
        }
        this.cid = cidx;
        this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
        this.log4jEnabled = this.log4jEnabled &&
                            this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
        this.logID = this.cid;
    }
    
    public String var(String varName){
        return varName + "_" + this.cid;
    }
    public String str(String content){
        return "\"" + content + "\"";
    }
    
    public void info(String... message){
        log4j("info", message);
    }
    
    public void debug(String... message){
        log4j("debug", message);
    }
    
    public void warn(String... message){
        log4j("warn", message);
    }
    
    public void error(String... message){
        log4j("error", message);
    }
    
    public void fatal(String... message){
        log4j("fatal", message);
    }
    
    public void trace(String... message){
        log4j("trace", message);
    }
    java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"});     
    public void log4j(String level, String... messages){
        if(this.log4jEnabled){
            if(checkableList.contains(level)){
            
    stringBuffer.append(TEXT_109);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_110);
    
            }
            
    stringBuffer.append(TEXT_111);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_113);
    for(String message : messages){
    stringBuffer.append(TEXT_114);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_115);
    }
    stringBuffer.append(TEXT_116);
    
        }
    }
    
    public boolean isActive(){
        return this.log4jEnabled;
    }
}

class LogUtil extends BasicLogUtil{
    
    private LogUtil(){
    }
    
    public LogUtil(org.talend.core.model.process.INode node){
        super(node);
    }
    
    public void startWork(){
        info(str("Start to work."));
    }
    
    public void endWork(){
        info(str("Done."));
    }
    
    public void logIgnoredException(String exception){
        warn(exception);
    }
    
    public void logPrintedException(String exception){
        error(exception);
    }
    
    public void logException(String exception){
        fatal(exception);
    }
    
    public void logCompSetting(){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_117);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_120);
    
            java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
            ignoredParamsTypes.addAll(
                java.util.Arrays.asList(
                    org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                    org.talend.core.model.process.EParameterFieldType.LABEL,
                    org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                    org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                    org.talend.core.model.process.EParameterFieldType.IMAGE,
                    org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                    org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                    org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                    org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                    org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                    org.talend.core.model.process.EParameterFieldType.VERSION,
                    org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                    org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                    org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                    org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                    org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                    org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                    org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
                    )
            );
            for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                    continue;
                }
                String name = ep.getName();
                if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
                    String epName = "__" + name + "__";
                    String password = "";
                    if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
                        password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
                    }else{
                        String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
                        if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                            passwordValue = "\"\"";
                        } 
                        password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
                    } 
                    
    stringBuffer.append(TEXT_121);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_124);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    
    stringBuffer.append(TEXT_125);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_128);
    
                }   
                
    stringBuffer.append(TEXT_129);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_130);
    
            }
        }
        debug(var("log4jParamters"));
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_131);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_132);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_133);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_136);
    
                }else{
                
    stringBuffer.append(TEXT_137);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_145);
    
                }
                
    stringBuffer.append(TEXT_146);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_147);
    
            }
        }
        trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
        
    
    }
}

class LogHelper{
    
    java.util.Map<String, String> pastDict = null;
    
    public LogHelper(){
        pastDict = new java.util.HashMap<String, String>();
        pastDict.put("insert", "inserted");
        pastDict.put("update", "updated");
        pastDict.put("delete", "deleted");
        pastDict.put("upsert", "upserted");
    }   
    
    public String upperFirstChar(String data){ 
        return data.substring(0, 1).toUpperCase() + data.substring(1);
    }
    
    public String toPastTense(String data){
        return pastDict.get(data);
    }
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    
                    for (INode confNode : confNodes) {
                        String componentName = confNode.getComponent().getName();
                        if(componentName.endsWith("Configuration")) {

    stringBuffer.append(TEXT_148);
    stringBuffer.append(confNode.getUniqueName());
    stringBuffer.append(TEXT_149);
    
                            log = new LogUtil(confNode);
                            log.logCompSetting();
                        }
                    }
                }
                for (INode rootNode : rootNodes) {
                    String componentName = rootNode.getComponent().getName();
                    String uniqueName = rootNode.getUniqueName();
                    if(rootNode.getOutgoingConnections().size() > 0 || "tJava".equals(componentName)
                            || "tRunJob".equals(componentName)) {
                    
    stringBuffer.append(TEXT_150);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(rootNode.getUniqueName());
    stringBuffer.append(TEXT_152);
    
                            if(stats) {

    stringBuffer.append(TEXT_153);
    
                            }

    stringBuffer.append(TEXT_154);
    
                    }
                }

    stringBuffer.append(TEXT_155);
    
        }

    stringBuffer.append(TEXT_156);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_157);
    stringBuffer.append(codeGenArgument.getCurrentProjectName().toLowerCase());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(jobFolderName);
    stringBuffer.append(TEXT_159);
    
                for(IContextParameter ctxParam :params){
                    String typeToGenerate = "String";
                    if(ctxParam.getType().equals("id_List Of Value") || ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory")){
                        typeToGenerate = "String";
                    }else{
                        typeToGenerate = JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true);
                    }
                    
    stringBuffer.append(TEXT_160);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_164);
    
                }
                
    stringBuffer.append(TEXT_165);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(codeGenArgument.getCurrentProjectName().toLowerCase());
    stringBuffer.append(TEXT_167);
    stringBuffer.append(jobFolderName);
    stringBuffer.append(TEXT_168);
    
                if(!useLocalMode) {

    stringBuffer.append(TEXT_169);
    
                }

    stringBuffer.append(TEXT_170);
    
            for(IContextParameter ctxParam : params){
            
    stringBuffer.append(TEXT_171);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_173);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_174);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_175);
    
            }
            
    stringBuffer.append(TEXT_176);
    stringBuffer.append(TEXT_177);
    return stringBuffer.toString();
  }
}
