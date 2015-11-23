package org.talend.designer.codegen.translators.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.talend.core.CorePlugin;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.utils.JavaResourcesHelper;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class Sparkstreaming_footerJava
{
  protected static String nl;
  public static synchronized Sparkstreaming_footerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Sparkstreaming_footerJava result = new Sparkstreaming_footerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        throw new java.lang.RuntimeException(\"A Spark job can't have more than 1 tS3Configuration defined in the designer.\");";
  protected final String TEXT_2 = NL + "        throw new java.lang.RuntimeException(\"A Spark job can't have more than 1 tTachyonConfiguration defined in the designer.\");";
  protected final String TEXT_3 = NL + "        throw new java.lang.RuntimeException(\"A Spark job can't have more than 1 tHDFSConfiguration defined in the designer.\");";
  protected final String TEXT_4 = NL + "        throw new java.lang.RuntimeException(\"A Spark job can't have more than 1 tCassandraConfiguration defined in the designer.\");";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + "\tpublic static class TalendKryoRegistrator implements org.apache.spark.serializer.KryoRegistrator {" + NL + "\t\t\t" + NL + "\t\t@Override" + NL + "\t\tpublic void registerClasses(com.esotericsoftware.kryo.Kryo kryo) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tkryo.register(Class.forName(\"org.talend.bigdata.dataflow.keys.JoinKeyRecord\"));" + NL + "\t\t\t} catch (java.lang.ClassNotFoundException e) {" + NL + "\t\t\t\t// Ignore" + NL + "\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\tkryo.register(java.net.InetAddress.class, new InetAddressSerializer());" + NL + "\t\t\tkryo.addDefaultSerializer(java.net.InetAddress.class, new InetAddressSerializer());" + NL + "\t\t";
  protected final String TEXT_7 = "\t\t\t" + NL + "\t\t\tkryo.register(";
  protected final String TEXT_8 = ".class);" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t\t}" + NL + "\t}" + NL + "\t\t" + NL + "\tpublic static class InetAddressSerializer extends com.esotericsoftware.kryo.Serializer<java.net.InetAddress> {" + NL + "\t" + NL + "\t\t@Override" + NL + "\t\tpublic void write(com.esotericsoftware.kryo.Kryo kryo, com.esotericsoftware.kryo.io.Output output, java.net.InetAddress value) {" + NL + "\t\t\toutput.writeInt(value.getAddress().length);" + NL + "\t\t\toutput.writeBytes(value.getAddress());" + NL + "\t\t}" + NL + "\t" + NL + "\t\t@Override" + NL + "\t\tpublic java.net.InetAddress read(com.esotericsoftware.kryo.Kryo kryo, com.esotericsoftware.kryo.io.Input input, Class<java.net.InetAddress> paramClass) {" + NL + "\t\t\tjava.net.InetAddress inetAddress = null;" + NL + "\t\t\ttry {" + NL + "\t\t\t\tint length = input.readInt();" + NL + "\t\t\t\tbyte[] address = input.readBytes(length);" + NL + "\t\t\t\tinetAddress = java.net.InetAddress.getByAddress(address);" + NL + "\t\t\t} catch (java.net.UnknownHostException e) {" + NL + "\t\t\t\t// Cannot recreate InetAddress instance : return null" + NL + "\t\t\t} catch (com.esotericsoftware.kryo.KryoException e) {" + NL + "\t\t\t\t// Should not happen since write() and read() methods are consistent." + NL + "\t\t\t}" + NL + "\t\t\treturn inetAddress;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "    public String resuming_logs_dir_path = null;" + NL + "    public String resuming_checkpoint_path = null;" + NL + "    public String parent_part_launcher = null;" + NL + "    public String pid = \"0\";" + NL + "    public String rootPid = null;" + NL + "    public String fatherPid = null;" + NL + "    public Integer portStats = null;" + NL + "    public String clientHost;" + NL + "    public String defaultClientHost = \"localhost\";" + NL + "    public String libjars = null;" + NL + "    private boolean execStat = true;" + NL + "    public boolean isChildJob = false;" + NL + "    public String fatherNode = null;" + NL + "    public String log4jLevel = \"\";" + NL + "    public boolean doInspect = false;" + NL + "" + NL + "    public String contextStr = \"";
  protected final String TEXT_10 = "\";" + NL + "    public boolean isDefaultContext = true;" + NL + "" + NL + "    private java.util.Properties context_param = new java.util.Properties();" + NL + "    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();" + NL + "" + NL + "    public String status= \"\";" + NL + "" + NL + "    public static void main(String[] args){";
  protected final String TEXT_11 = NL + "                new java.lang.Exception(\"In Talend, Spark Streaming jobs only support one job. Please deactivate the extra jobs.\").printStackTrace();" + NL + "                int exitCode = 1;";
  protected final String TEXT_12 = NL + "            int exitCode = new ";
  protected final String TEXT_13 = "().runJobInTOS(args);";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL + "            if(exitCode == 0) {" + NL + "                log.info(\"TalendJob: '";
  protected final String TEXT_16 = "' - Done.\");" + NL + "            } else {" + NL + "                log.error(\"TalendJob: '";
  protected final String TEXT_17 = "' - Failed with exit code: \" + exitCode + \".\");" + NL + "            }";
  protected final String TEXT_18 = NL + "        System.exit(exitCode);" + NL + "    }" + NL + "" + NL + "    public String[][] runJob(String[] args){";
  protected final String TEXT_19 = NL + "                new java.lang.Exception(\"In Talend, Spark Streaming jobs only support one job. Please deactivate the extra jobs.\").printStackTrace();" + NL + "                 String[][] bufferValue = new String[][] { { Integer.toString(1) } };";
  protected final String TEXT_20 = NL + "            int exitCode = runJobInTOS(args);" + NL + "            String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };";
  protected final String TEXT_21 = NL + "        return bufferValue;" + NL + "    }" + NL + "" + NL + "    public int runJobInTOS (String[] args) {" + NL + "        normalizeArgs(args);" + NL + "" + NL + "        String lastStr = \"\";" + NL + "        for (String arg : args) {" + NL + "            if (arg.equalsIgnoreCase(\"--context_param\")) {" + NL + "                lastStr = arg;" + NL + "            } else if (lastStr.equals(\"\")) {" + NL + "                evalParam(arg);" + NL + "            } else {" + NL + "                evalParam(lastStr + \" \" + arg);" + NL + "                lastStr = \"\";" + NL + "            }" + NL + "        }" + NL;
  protected final String TEXT_22 = NL + "            if(!\"\".equals(log4jLevel)){" + NL + "                if(\"trace\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.TRACE);" + NL + "                }else if(\"debug\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.DEBUG);" + NL + "                }else if(\"info\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.INFO);" + NL + "                }else if(\"warn\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.WARN);" + NL + "                }else if(\"error\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.ERROR);" + NL + "                }else if(\"fatal\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.FATAL);" + NL + "                }else if (\"off\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.OFF);" + NL + "                }" + NL + "                org.apache.log4j.Logger.getRootLogger().setLevel(log.getLevel());" + NL + "            }" + NL + "            log.info(\"TalendJob: '";
  protected final String TEXT_23 = "' - Start.\");";
  protected final String TEXT_24 = NL + NL + "        initContext();" + NL + "" + NL + "        if (clientHost == null) {" + NL + "            clientHost = defaultClientHost;" + NL + "        }" + NL + "" + NL + "        if (pid == null || \"0\".equals(pid)) {" + NL + "            pid = TalendString.getAsciiRandomString(6);" + NL + "        }" + NL + "" + NL + "        if (rootPid == null) {" + NL + "            rootPid = pid;" + NL + "        }" + NL + "        if (fatherPid == null) {" + NL + "            fatherPid = pid;" + NL + "        } else {" + NL + "            isChildJob = true;" + NL + "        }";
  protected final String TEXT_25 = NL + NL + "            if (portStats != null) {" + NL + "                // portStats = -1; //for testing" + NL + "                if (portStats < 0 || portStats > 65535) {" + NL + "                    // issue:10869, the portStats is invalid, so this client socket" + NL + "                    // can't open" + NL + "                    System.err.println(\"The statistics socket port \" + portStats" + NL + "                            + \" is invalid.\");" + NL + "                    execStat = false;" + NL + "                }" + NL + "            } else {" + NL + "                execStat = false;" + NL + "            }" + NL + "" + NL + "            if (execStat) {" + NL + "                try {" + NL + "                    runStat.startThreadStat(clientHost, portStats);" + NL + "                    runStat.setAllPID(rootPid, fatherPid, pid);" + NL + "                } catch (java.io.IOException ioException) {" + NL + "                    ioException.printStackTrace();" + NL + "                }" + NL + "            }";
  protected final String TEXT_26 = NL + "            if(!\"\".equals(";
  protected final String TEXT_27 = ")) {" + NL + "                System.setProperty(\"HADOOP_USER_NAME\", ";
  protected final String TEXT_28 = ");" + NL + "            }";
  protected final String TEXT_29 = NL + "        String osName = System.getProperty(\"os.name\");" + NL + "        String snappyLibName = \"libsnappyjava.so\";" + NL + "        if(osName.startsWith(\"Windows\")) {" + NL + "            snappyLibName = \"snappyjava.dll\";" + NL + "        } else if(osName.startsWith(\"Mac\")) {" + NL + "            snappyLibName = \"libsnappyjava.jnilib\";" + NL + "        }" + NL + "        System.setProperty(\"org.xerial.snappy.lib.name\", snappyLibName);";
  protected final String TEXT_30 = NL + "            try {" + NL + "                org.apache.spark.SparkConf sparkConfiguration = new  org.apache.spark.SparkConf();" + NL + "                sparkConfiguration.set(\"spark.serializer\", \"org.apache.spark.serializer.KryoSerializer\");" + NL + "                sparkConfiguration.set(\"spark.kryo.registrator\", TalendKryoRegistrator.class.getName());" + NL + "" + NL + "                java.text.DateFormat outdfm = new java.text.SimpleDateFormat(\"yyyy_MM_dd_HH_mm_ss\");" + NL + "                String appName = projectName + \"_\" + jobName + \"_\" + jobVersion + \"_\" + outdfm.format(new java.util.Date());" + NL + "                sparkConfiguration.setAppName(appName);" + NL + "                log.info(\"Created App:\" + appName);";
  protected final String TEXT_31 = NL + "                sparkConfiguration.setMaster(";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "                               sparkConfiguration.set(\"spark.driver.host\", ";
  protected final String TEXT_34 = ");" + NL + "                               org.apache.spark.util.Utils.setCustomHostname(";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "                        sparkConfiguration.setSparkHome(";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "                            sparkConfiguration.set(\"spark.hadoop.yarn.application.classpath\", \"$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,/usr/lib/hadoop-lzo/lib/*,/usr/share/aws/emr/emrfs/conf, /usr/share/aws/emr/emrfs/lib/*,/usr/share/aws/emr/emrfs/auxlib/*,/usr/share/aws/emr/lib/*,/usr/share/aws/emr/ddb/lib/emr-ddb-hadoop.jar, /usr/share/aws/emr/goodies/lib/emr-hadoop-goodies.jar,/usr/share/aws/emr/kinesis/lib/emr-kinesis-hadoop.jar,/usr/lib/spark/yarn/lib/datanucleus-api-jdo.jar,/usr/lib/spark/yarn/lib/datanucleus-core.jar,/usr/lib/spark/yarn/lib/datanucleus-rdbms.jar,/usr/share/aws/emr/cloudwatch-sink/lib/*\");";
  protected final String TEXT_39 = NL + "                            sparkConfiguration.set(\"spark.hadoop.yarn.application.classpath\", \"$HADOOP_CLIENT_CONF_DIR,$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*\");";
  protected final String TEXT_40 = NL + "                            sparkConfiguration.set(\"spark.hadoop.yarn.application.classpath\", \"/etc/hadoop/conf, /usr/lib/hadoop/*, /usr/lib/hadoop/lib/*,/usr/lib/hadoop-hdfs/*, /usr/lib/hadoop-hdfs/lib/*, /usr/lib/hadoop-mapreduce/*, /usr/lib/hadoop-mapreduce/lib/*,/usr/lib/hadoop-yarn/*, /usr/lib/hadoop-yarn/lib/*\");";
  protected final String TEXT_41 = NL + NL + "                        sparkConfiguration.set(\"spark.hadoop.yarn.resourcemanager.address\", ";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = "sparkConfiguration.set(\"spark.hadoop.yarn.resourcemanager.scheduler.address\", ";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = "sparkConfiguration.set(\"spark.hadoop.mapreduce.jobhistory.address\", ";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = "sparkConfiguration.set(\"spark.hadoop.yarn.app.mapreduce.am.staging-dir\", ";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "                            sparkConfiguration.set(\"spark.hadoop.mapreduce.map.memory.mb\", ";
  protected final String TEXT_50 = ");" + NL + "                            sparkConfiguration.set(\"spark.hadoop.mapreduce.reduce.memory.mb\", ";
  protected final String TEXT_51 = ");" + NL + "                            sparkConfiguration.set(\"spark.hadoop.yarn.app.mapreduce.am.resource.mb\", ";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "                            sparkConfiguration.set(\"spark.hadoop.yarn.resourcemanager.principal\", ";
  protected final String TEXT_54 = ");" + NL + "                            sparkConfiguration.set(\"spark.hadoop.mapreduce.jobhistory.principal\", ";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "                                org.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_57 = ", ";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "                                    if(!";
  protected final String TEXT_60 = ".equals(";
  protected final String TEXT_61 = ")) {" + NL + "                                        throw new RuntimeException(\"The HDFS and the Spark configurations must have the same user name.\");" + NL + "                                    }";
  protected final String TEXT_62 = NL + "                                    if(!\"\".equals(";
  protected final String TEXT_63 = ")) {" + NL + "                                        System.setProperty(\"HADOOP_USER_NAME\", ";
  protected final String TEXT_64 = ");" + NL + "                                    }";
  protected final String TEXT_65 = NL + "                    System.setProperty(\"hadoop.home.dir\", ";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "\t\t\t\t\t\t\t\t\tif(true) {" + NL + "    \t\t\t\t\t\t\t\t\tthrow new java.lang.RuntimeException(\"The number of records per second to read from each Kafka partition must be the same between all Kafka input components.\");" + NL + "    \t\t\t\t\t\t\t\t}";
  protected final String TEXT_68 = NL + "                        sparkConfiguration.set(\"spark.ui.port\", ";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL + "                    sparkConfiguration.set(\"spark.driver.memory\", ";
  protected final String TEXT_71 = ");" + NL + "                    sparkConfiguration.set(\"spark.executor.memory\", ";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = NL + "                        sparkConfiguration.set(\"spark.driver.cores\", ";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "                        sparkConfiguration.set(\"spark.yarn.am.cores\", ";
  protected final String TEXT_76 = ");";
  protected final String TEXT_77 = NL + "                        sparkConfiguration.set(\"spark.executor.cores\", ";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "                            sparkConfiguration.set(\"spark.executor.instances\", ";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "                            sparkConfiguration.set(\"spark.dynamicAllocation.enabled\", \"true\");" + NL + "                            sparkConfiguration.set(\"spark.shuffle.service.enabled\", \"true\");" + NL + "                            String dynInitialValue = ";
  protected final String TEXT_82 = ";" + NL + "                            sparkConfiguration.set(\"spark.dynamicAllocation.initialExecutors\", dynInitialValue);" + NL + "                            String dynMinValue = ";
  protected final String TEXT_83 = ";" + NL + "                            sparkConfiguration.set(\"spark.dynamicAllocation.minExecutors\", dynMinValue);";
  protected final String TEXT_84 = NL + "                                Integer iDynMaxValue = Integer.MAX_VALUE;" + NL + "                                sparkConfiguration.set(\"spark.dynamicAllocation.maxExecutors\", new Integer(Integer.MAX_VALUE).toString());";
  protected final String TEXT_85 = NL + "                                Integer iDynMaxValue = Integer.parseInt(";
  protected final String TEXT_86 = ");" + NL + "                                sparkConfiguration.set(\"spark.dynamicAllocation.maxExecutors\", ";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "                            Integer iDynInitialValue = Integer.parseInt(dynInitialValue);" + NL + "                            Integer iDynMinValue = Integer.parseInt(dynMinValue);" + NL + "                            if(iDynInitialValue < iDynMinValue|| iDynInitialValue > iDynMaxValue || iDynMinValue > iDynMaxValue) {" + NL + "                                throw new RuntimeException(\"Please check your dynamicAllocation bounds, you should have min <= initial <= max\");" + NL + "                            }";
  protected final String TEXT_89 = NL + "                        sparkConfiguration.set(\"spark.broadcast.factory\", \"org.apache.spark.broadcast.TorrentBroadcastFactory\");";
  protected final String TEXT_90 = NL + "                        sparkConfiguration.set(\"spark.broadcast.factory\", \"org.apache.spark.broadcast.HttpBroadcastFactory\");";
  protected final String TEXT_91 = NL + "                        sparkConfiguration.set(\"spark.serializer\", ";
  protected final String TEXT_92 = ");";
  protected final String TEXT_93 = NL + "                    sparkConfiguration.set(";
  protected final String TEXT_94 = ", ";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "\t\tclass GetJarsToRegister_";
  protected final String TEXT_97 = " {" + NL + "\t\t\tprivate String oozieClasspathLine;" + NL + "\t\t\tprivate boolean isOozieRuntime;" + NL + "\t\t\t" + NL + "\t\t\tpublic GetJarsToRegister_";
  protected final String TEXT_98 = "() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tthis.isOozieRuntime = setJarsToRegister();" + NL + "\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_100 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean setJarsToRegister() throws IOException, org.dom4j.DocumentException {" + NL + "\t\t\t\tString jobXmlPath = new java.io.File(\"../../job.xml\").getCanonicalPath();" + NL + "\t\t\t\tboolean isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\tif(!isOozieExecution) {" + NL + "\t\t\t\t    jobXmlPath = new java.io.File(\"./job.xml\").getCanonicalPath();" + NL + "\t\t\t\t    isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(isOozieExecution) {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.dom4j.io.SAXReader reader_oozie = new org.dom4j.io.SAXReader();" + NL + "\t\t\t\t\torg.dom4j.Document document_oozie = reader_oozie.read(jobXmlPath);" + NL + "\t\t\t\t\tList list_oozie = document_oozie.selectNodes(\"/configuration/property\");" + NL + "\t\t\t\t\tfor (java.util.Iterator iter_oozie = list_oozie.iterator(); iter_oozie.hasNext();) {" + NL + "\t\t\t\t\t\torg.dom4j.Element element_oozie = (org.dom4j.Element) iter_oozie.next();" + NL + "\t\t\t\t\t\tString name_oozie = element_oozie.elementText(\"name\");" + NL + "\t\t\t\t\t\tif(name_oozie.equals(\"mapred.cache.localFiles\") || name_oozie.equals(\"mapreduce.job.cache.local.files\")) {" + NL + "\t\t\t\t\t\t\tthis.oozieClasspathLine = element_oozie.elementText(\"value\");" + NL + "\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\t\treturn replaceJarPaths(originalClassPathLine, \"\");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine, String scheme) throws Exception {" + NL + "\t\t\t\tString classPathLine = \"\";" + NL + "\t\t\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\t\t\t" + NL + "\t\t\t\tif (isNeedAddLibsPath(crcMapPath)) {" + NL + "\t\t\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\t\t\tois.close();" + NL + "\t\t\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t\t\t} else if(this.isOozieRuntime) {" + NL + "\t\t\t\t\tif(this.oozieClasspathLine!=null) {" + NL + "\t\t\t\t\t\tList<String> oozieJars = java.util.Arrays.asList(this.oozieClasspathLine.split(\",\"));" + NL + "\t\t\t\t\t\tfor(int j=0; j<oozieJars.size(); j++) {" + NL + "\t\t\t\t\t\t\tif(oozieJars.get(j).contains(originalClassPathLine.substring(originalClassPathLine.lastIndexOf(\"/\")))) {" + NL + "\t\t\t\t\t\t\t\tclassPathLine = oozieJars.get(j);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tif(originalClassPathLine!=null && originalClassPathLine.startsWith(\".\")) {" + NL + "\t\t\t\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tclassPathLine = scheme + originalClassPathLine;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn classPathLine;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\t\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\t\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\t\t\tString jarName = entry.getValue();" + NL + "\t\t\t\tString crc = entry.getKey();" + NL + "\t\t\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\t\t\tString libStringFinder2 = \"./\" + jarName; // for the job jar itself." + NL + "\t\t\t\t" + NL + "\t\t\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.toLowerCase().contains(libStringFinder2)) {" + NL + "\t\t\t\t\tline = line.toLowerCase().replace(libStringFinder2, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t}" + NL + "" + NL + "                GetJarsToRegister_";
  protected final String TEXT_102 = " getJarsToRegister = new GetJarsToRegister_";
  protected final String TEXT_103 = "();" + NL + "                java.util.List<String> listJar = new java.util.ArrayList<String>();" + NL + "                if(libjars != null) {" + NL + "                    for(String jar:libjars.split(\",\")) {" + NL + "                        listJar.add(jar);" + NL + "                    }" + NL + "                }" + NL + "                listJar.add(getJarsToRegister.replaceJarPaths(\"./\" + \"";
  protected final String TEXT_104 = "\" + \".jar\", \"file://\"));" + NL + "                routines.system.BigDataUtil.installWinutils(";
  protected final String TEXT_105 = ", getJarsToRegister.replaceJarPaths(\"../lib/winutils-hadoop-2.6.0.exe\", \"file://\"));" + NL + "                sparkConfiguration.setJars(listJar.toArray(new String[listJar.size()]));" + NL + "                sparkConfiguration.set(\"spark.local.dir\", ";
  protected final String TEXT_106 = ");" + NL;
  protected final String TEXT_107 = NL + "                        org.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_108 = ", ";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + NL + "                if (doInspect) {" + NL + "                    System.out.println(\"== inspect start ==\");" + NL + "                    System.out.println(\"{\");" + NL + "                    System.out.println(\"  \\\"SPARK_MASTER\\\": \\\"\" + sparkConfiguration.get(\"spark.master\") + \"\\\",\");" + NL + "                    System.out.println(\"  \\\"SPARK_UI_PORT\\\": \\\"\" + sparkConfiguration.get(\"spark.ui.port\", \"4040\") + \"\\\",\");" + NL + "                    System.out.println(\"  \\\"JOB_NAME\\\": \\\"\" + sparkConfiguration.get(\"spark.app.name\", jobName) + \"\\\"\");" + NL + "                    System.out.println(\"}\"); //$NON-NLS-1$" + NL + "                    System.out.println(\"== inspect end ==\");" + NL + "                }" + NL + "\t\t\t\t";
  protected final String TEXT_111 = NL;
  protected final String TEXT_112 = NL + "                    org.apache.spark.streaming.api.java.JavaStreamingContext ctx = new org.apache.spark.streaming.api.java.JavaStreamingContext(sparkConfiguration, new org.apache.spark.streaming.Duration(";
  protected final String TEXT_113 = "));";
  protected final String TEXT_114 = NL + "                        ctx.addStreamingListener(new TalendSparkStreamingListener(ctx.ssc()));";
  protected final String TEXT_115 = NL + "                    setContext(ctx.sparkContext().hadoopConfiguration(), ctx.sparkContext());";
  protected final String TEXT_116 = NL + "                           try {" + NL + "                                globalMap = new GlobalVar(ctx.sparkContext().hadoopConfiguration());";
  protected final String TEXT_117 = NL + "                                ";
  protected final String TEXT_118 = "Process(ctx, globalMap);" + NL + "                            } catch(Exception e) {" + NL + "                                e.printStackTrace();" + NL + "                                e.printStackTrace(errorMessagePS);" + NL + "                                status = \"failure\";" + NL + "                                return 1;" + NL + "                            }";
  protected final String TEXT_119 = NL + "                    return 0;";
  protected final String TEXT_120 = NL + "                    final org.apache.spark.SparkConf finalSparkConfiguration = sparkConfiguration;" + NL + "                    class TalendJavaStreamingContextFactory" + NL + "                            implements" + NL + "                            org.apache.spark.streaming.api.java.JavaStreamingContextFactory {" + NL + "" + NL + "                        private java.lang.Exception e = null;" + NL + "                        private String status = null;" + NL + "                        private int returnCode = 0;" + NL + "" + NL + "                        @Override" + NL + "                        public org.apache.spark.streaming.api.java.JavaStreamingContext create() {";
  protected final String TEXT_121 = NL + "                                   try {" + NL + "                                        return ";
  protected final String TEXT_122 = "Process(finalSparkConfiguration);" + NL + "                                    } catch(Exception e) {" + NL + "                                        this.e = e;" + NL + "                                        this.status = \"failure\";" + NL + "                                        this.returnCode = 1;" + NL + "                                        return null;" + NL + "                                    }";
  protected final String TEXT_123 = NL + "                        }" + NL + "" + NL + "                        public java.lang.Exception getException() { return this.e; }" + NL + "                        public String getStatus() { return this.status; }" + NL + "                        public int getReturnCode() { return this.returnCode; }" + NL + "                    }" + NL + "" + NL + "                    TalendJavaStreamingContextFactory factory = new TalendJavaStreamingContextFactory();" + NL + "                    org.apache.spark.streaming.api.java.JavaStreamingContext ctx = org.apache.spark.streaming.api.java.JavaStreamingContext.getOrCreate(";
  protected final String TEXT_124 = ", factory);" + NL + "" + NL + "                    if(factory.getException() != null) {" + NL + "                        factory.getException().printStackTrace();" + NL + "                        factory.getException().printStackTrace(errorMessagePS);" + NL + "                        status = factory.getStatus();" + NL + "                    }else{";
  protected final String TEXT_125 = NL + "                                    ctx.addStreamingListener(new TalendSparkStreamingListener(ctx.ssc()));";
  protected final String TEXT_126 = NL + "                        ctx.start();" + NL + "                        ctx.awaitTermination(";
  protected final String TEXT_127 = ");" + NL + "                    }" + NL + "" + NL + "                    return factory.getReturnCode();";
  protected final String TEXT_128 = NL + "            } catch(Exception ex) {" + NL + "                ex.printStackTrace();" + NL + "                return 1;" + NL + "            }";
  protected final String TEXT_129 = NL + "    }" + NL + "" + NL + "    private String genTempFolderForComponent(String name) {" + NL + "        java.io.File tempDir = new java.io.File(\"/tmp/\" + pid, name);" + NL + "        String tempDirPath = tempDir.getPath();" + NL + "        if (java.io.File.separatorChar != '/')" + NL + "            tempDirPath = tempDirPath.replace(java.io.File.separatorChar, '/');" + NL + "        return tempDirPath;" + NL + "    }" + NL + "" + NL + "    private void initContext(){" + NL + "        //get context" + NL + "        try{" + NL + "            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead." + NL + "            java.io.InputStream inContext = ";
  protected final String TEXT_130 = ".class.getClassLoader().getResourceAsStream(\"";
  protected final String TEXT_131 = "/";
  protected final String TEXT_132 = "/contexts/\"+contextStr+\".properties\");" + NL + "            if(isDefaultContext && inContext == null){" + NL + "" + NL + "            }else{" + NL + "                if(inContext!=null){" + NL + "                    //defaultProps is in order to keep the original context value" + NL + "                    defaultProps.load(inContext);" + NL + "                    inContext.close();" + NL + "                    context = new ContextProperties(defaultProps);" + NL + "                }else{" + NL + "                    //print info and job continue to run, for case: context_param is not empty." + NL + "                    System.err.println(\"Could not find the context \" + contextStr);" + NL + "                }" + NL + "            }" + NL + "" + NL + "            if(!context_param.isEmpty()){" + NL + "                context.putAll(context_param);" + NL + "            }" + NL + "            context.loadValue(context_param,null);" + NL + "            if(parentContextMap != null && !parentContextMap.isEmpty()){";
  protected final String TEXT_133 = NL + "                    if(parentContextMap.containsKey(\"";
  protected final String TEXT_134 = "\")){" + NL + "                        context.";
  protected final String TEXT_135 = " = (";
  protected final String TEXT_136 = ") parentContextMap.get(\"";
  protected final String TEXT_137 = "\");" + NL + "                    }";
  protected final String TEXT_138 = NL + "            }" + NL + "        }catch (java.io.IOException ie){" + NL + "            System.err.println(\"Could not load context \"+contextStr);" + NL + "            ie.printStackTrace();" + NL + "        }" + NL + "    }" + NL + "" + NL + "    private void setContext(Configuration conf, org.apache.spark.api.java.JavaSparkContext ctx){" + NL + "        //get context" + NL + "        //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead." + NL + "        java.net.URL inContextUrl = ";
  protected final String TEXT_139 = ".class.getClassLoader().getResource(\"";
  protected final String TEXT_140 = "/";
  protected final String TEXT_141 = "/contexts/\"+contextStr+\".properties\");" + NL + "        if(isDefaultContext && inContextUrl == null){" + NL + "" + NL + "        }else{" + NL + "            if(inContextUrl!=null){" + NL + "                conf.set(ContextProperties.CONTEXT_FILE_NAME, contextStr+\".properties\");";
  protected final String TEXT_142 = "                " + NL + "                    ctx.addFile(inContextUrl.getPath());";
  protected final String TEXT_143 = NL + NL + "            }" + NL + "        }" + NL + "" + NL + "        if(!context_param.isEmpty()){" + NL + "            for(Object contextKey : context_param.keySet()){" + NL + "                conf.set(ContextProperties.CONTEXT_PARAMS_PREFIX + contextKey, context.getProperty(contextKey.toString()));" + NL + "                conf.set(ContextProperties.CONTEXT_KEYS, conf.get(ContextProperties.CONTEXT_KEYS, \"\") + \" \" + contextKey);" + NL + "            }" + NL + "        }" + NL + "" + NL + "        if(parentContextMap != null && !parentContextMap.isEmpty()){";
  protected final String TEXT_144 = NL + "                if(parentContextMap.containsKey(\"";
  protected final String TEXT_145 = "\")){" + NL + "                    conf.set(ContextProperties.CONTEXT_PARENT_PARAMS_PREFIX + \"";
  protected final String TEXT_146 = "\", parentContextMap.get(\"";
  protected final String TEXT_147 = "\").toString());" + NL + "                    conf.set(ContextProperties.CONTEXT_PARENT_KEYS, conf.get(ContextProperties.CONTEXT_KEYS, \"\") + \" \" + \"";
  protected final String TEXT_148 = "\");" + NL + "                }";
  protected final String TEXT_149 = NL + "        }" + NL + "    }" + NL + "" + NL + "    private void evalParam(String arg) {" + NL + "        if (arg.startsWith(\"--resuming_logs_dir_path\")) {" + NL + "            resuming_logs_dir_path = arg.substring(25);" + NL + "        } else if (arg.startsWith(\"--resuming_checkpoint_path\")) {" + NL + "            resuming_checkpoint_path = arg.substring(27);" + NL + "        } else if (arg.startsWith(\"--parent_part_launcher\")) {" + NL + "            parent_part_launcher = arg.substring(23);" + NL + "        } else if (arg.startsWith(\"--father_pid=\")) {" + NL + "            fatherPid = arg.substring(13);" + NL + "        } else if (arg.startsWith(\"--root_pid=\")) {" + NL + "            rootPid = arg.substring(11);" + NL + "        } else if (arg.startsWith(\"--pid=\")) {" + NL + "            pid = arg.substring(6);" + NL + "        } else if (arg.startsWith(\"--context=\")) {" + NL + "            contextStr = arg.substring(\"--context=\".length());" + NL + "            isDefaultContext = false;" + NL + "        } else if (arg.startsWith(\"--context_param\")) {" + NL + "            String keyValue = arg.substring(\"--context_param\".length() + 1);" + NL + "            int index = -1;" + NL + "            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {" + NL + "                context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));" + NL + "            }" + NL + "        } else if (arg.startsWith(\"--stat_port=\")) {" + NL + "            String portStatsStr = arg.substring(12);" + NL + "            if (portStatsStr != null && !portStatsStr.equals(\"null\")) {" + NL + "                portStats = Integer.parseInt(portStatsStr);" + NL + "            }" + NL + "        } else if (arg.startsWith(\"--client_host=\")) {" + NL + "            clientHost = arg.substring(14);" + NL + "        } else if (arg.startsWith(\"--log4jLevel=\")) {" + NL + "            log4jLevel = arg.substring(13);" + NL + "        } else if (arg.startsWith(\"--inspect\")) {" + NL + "            doInspect = Boolean.valueOf(arg.substring(\"--inspect=\".length()));" + NL + "        }" + NL + "    }" + NL + "" + NL + "    private void normalizeArgs(String[] args){" + NL + "        java.util.List<String> argsList = java.util.Arrays.asList(args);" + NL + "        int indexlibjars = argsList.indexOf(\"-libjars\") + 1;" + NL + "        libjars = indexlibjars == 0 ? null : argsList.get(indexlibjars);" + NL + "    }" + NL + "" + NL + "    private final String[][] escapeChars = {" + NL + "        {\"\\\\\\\\\",\"\\\\\"},{\"\\\\n\",\"\\n\"},{\"\\\\'\",\"\\'\"},{\"\\\\r\",\"\\r\"}," + NL + "        {\"\\\\f\",\"\\f\"},{\"\\\\b\",\"\\b\"},{\"\\\\t\",\"\\t\"}" + NL + "        };" + NL + "    private String replaceEscapeChars (String keyValue) {" + NL + "" + NL + "        if (keyValue == null || (\"\").equals(keyValue.trim())) {" + NL + "            return keyValue;" + NL + "        }" + NL + "" + NL + "        StringBuilder result = new StringBuilder();" + NL + "        int currIndex = 0;" + NL + "        while (currIndex < keyValue.length()) {" + NL + "            int index = -1;" + NL + "            // judege if the left string includes escape chars" + NL + "            for (String[] strArray : escapeChars) {" + NL + "                index = keyValue.indexOf(strArray[0],currIndex);" + NL + "                if (index>=0) {" + NL + "" + NL + "                    result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));" + NL + "                    currIndex = index + strArray[0].length();" + NL + "                    break;" + NL + "                }" + NL + "            }" + NL + "            // if the left string doesn't include escape chars, append the left into the result" + NL + "            if (index < 0) {" + NL + "                result.append(keyValue.substring(currIndex));" + NL + "                currIndex = currIndex + keyValue.length();" + NL + "            }" + NL + "        }" + NL + "" + NL + "        return result.toString();" + NL + "    }" + NL + "" + NL + "    public String getStatus() {" + NL + "        return status;" + NL + "    }" + NL + "}";
  protected final String TEXT_150 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    Vector v = (Vector) codeGenArgument.getArgument();
    IProcess process = (IProcess)v.get(0);
    List<INode> rootNodes = (List<INode>)v.get(1);
    INode sparkConfig = (INode)v.get(2);
    String processId = process.getId();
    String cid = "Spark";
    String jobFolderName = JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
    List<IContextParameter> params = new ArrayList<IContextParameter>();
    params=process.getContextManager().getDefaultContext().getContextParameterList();
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));
    boolean tuningProperties = "true".equals(ElementParameterParser.getValue(sparkConfig, "__ADVANCED_SETTINGS_CHECK__"));
    boolean setWebuiPort = "true".equals(ElementParameterParser.getValue(sparkConfig, "__WEB_UI_PORT_CHECK__"));
    boolean useCheckpoint = "true".equals(ElementParameterParser.getValue(sparkConfig, "__USE_CHECKPOINT__"));
    String checkpointDir = ElementParameterParser.getValue(sparkConfig, "__CHECKPOINT_DIR__");

    String sparkMode = ElementParameterParser.getValue(sparkConfig, "__SPARK_MODE__");
    String distribution = ElementParameterParser.getValue(sparkConfig, "__DISTRIBUTION__");
    String sparkVersion = ElementParameterParser.getValue(sparkConfig, "__SPARK_VERSION__");
    String batchSize = ElementParameterParser.getValue(sparkConfig, "__STREAMING_BATCH_SIZE__");
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


    // Count how many subjobs there are in the job. Currently, the Spark Streaming only supports one.
    int subjobCount = 0;
    for (INode rootNode : rootNodes) {
        if(rootNode.getOutgoingConnections().size() > 0) {
            subjobCount++;
        }
    }


    // Spark configurations for caching
    // In case we have multiple components that set different configurations, the last component in the list imposes its configurations
    List<INode> cacheConfNodes = new ArrayList<INode>();
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
            tachyonStoreUrlMap.put("VALUE",'"'+tachyonStoreUrl+'"');
            sparkAdvancedProperties.add(tachyonStoreUrlMap);
            Map<String, String> tachyonStoreBaseDirMap = new HashMap<String, String>();
            tachyonStoreBaseDirMap.put("PROPERTY","\"spark.tachyonStore.baseDir\"");
            tachyonStoreBaseDirMap.put("VALUE",'"'+tachyonStoreBaseDir+'"');
            sparkAdvancedProperties.add(tachyonStoreBaseDirMap);
        }

        if(compressRdd){
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
    
    stringBuffer.append(TEXT_1);
    
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

    stringBuffer.append(TEXT_2);
    
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
    
    stringBuffer.append(TEXT_3);
    
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
    
    stringBuffer.append(TEXT_4);
    
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

    stringBuffer.append(TEXT_5);
    
	// This is the TalendKryoRegistrator class generation part.

    stringBuffer.append(TEXT_6);
    
			Iterable<String> structNameList = (Iterable<String>) v.get(3);		
			for(String structName : structNameList) {
		
    stringBuffer.append(TEXT_7);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_8);
    
			} 
		
    stringBuffer.append(TEXT_9);
    stringBuffer.append(codeGenArgument.getContextName());
    stringBuffer.append(TEXT_10);
     if(subjobCount > 1) { 
    stringBuffer.append(TEXT_11);
     } else { 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_13);
     } 
    stringBuffer.append(TEXT_14);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(codeGenArgument.getJobName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(codeGenArgument.getJobName());
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
     if(subjobCount > 1) { 
    stringBuffer.append(TEXT_19);
     } else { 
    stringBuffer.append(TEXT_20);
     } 
    stringBuffer.append(TEXT_21);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(codeGenArgument.getJobName());
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    
        if(stats) {

    stringBuffer.append(TEXT_25);
    
        }

        if(username != null && !"".equals(username)) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_28);
    
        }
        // this snippet to solve an issue in Spark Driver on MacOSX with snappy
        // you have to run with -Dorg.xerial.snappy.lib.name=libsnappyjava.jnilib

    stringBuffer.append(TEXT_29);
    
        if(sparkConfig!=null) {

    stringBuffer.append(TEXT_30);
    

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

    stringBuffer.append(TEXT_31);
    stringBuffer.append(master);
    stringBuffer.append(TEXT_32);
    
                if(!useLocalMode) { // If the spark mode is not local.
                    boolean defineDriverHost = "true".equals(ElementParameterParser.getValue(sparkConfig, "__DEFINE_SPARK_DRIVER_HOST__"));
                    if(defineDriverHost) {
                        String driverHost = ElementParameterParser.getValue(sparkConfig, "__SPARK_DRIVER_HOST__");
                        if(driverHost != null && !"".equals(driverHost)) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(driverHost);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(driverHost);
    stringBuffer.append(TEXT_35);
    
                        }
                    }                
                    if(useStandaloneMode) {
                        String sparkHome = ElementParameterParser.getValue(sparkConfig, "__SPARK_HOME__");

    stringBuffer.append(TEXT_36);
    stringBuffer.append(sparkHome);
    stringBuffer.append(TEXT_37);
    
                    } else if(useYarnMode) {
                        // Set the YARN parameters in the SparkConf
                        String resourceManager = ElementParameterParser.getValue(sparkConfig, "__RESOURCE_MANAGER__");
                        boolean setResourceManagerSchedulerAddress = "true".equals(ElementParameterParser.getValue(sparkConfig, "__SET_SCHEDULER_ADDRESS__"));
                        boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(sparkConfig, "__SET_JOBHISTORY_ADDRESS__"));
                        boolean setStagingDirectory = "true".equals(ElementParameterParser.getValue(sparkConfig, "__SET_STAGING_DIRECTORY__"));
                        boolean setMemory = "true".equals(ElementParameterParser.getValue(sparkConfig, "__SET_MEMORY__"));

                        if ("EMR_4_0_0".equals(sparkVersion)) {
                            
    stringBuffer.append(TEXT_38);
    
                        } else if("Cloudera_CDH5_4".equals(sparkVersion)) {
                            
    stringBuffer.append(TEXT_39);
    
                        } else {
                            
    stringBuffer.append(TEXT_40);
    
                        }
                        
    stringBuffer.append(TEXT_41);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_42);
    if(setResourceManagerSchedulerAddress) { 
    stringBuffer.append(TEXT_43);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__RESOURCEMANAGER_SCHEDULER_ADDRESS__"));
    stringBuffer.append(TEXT_44);
     } 
    if(setJobHistoryAddress) { 
    stringBuffer.append(TEXT_45);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__JOBHISTORY_ADDRESS__"));
    stringBuffer.append(TEXT_46);
     } 
    if(setStagingDirectory) { 
    stringBuffer.append(TEXT_47);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__STAGING_DIRECTORY__"));
    stringBuffer.append(TEXT_48);
     } 
    if(setMemory) { 
    stringBuffer.append(TEXT_49);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__MAPREDUCE_MAP_MEMORY_MB__"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__MAPREDUCE_REDUCE_MEMORY_MB__"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__"));
    stringBuffer.append(TEXT_52);
     } 
    
                        boolean sparkUseKrb = "true".equals(ElementParameterParser.getValue(sparkConfig, "__USE_KRB__"));
                        if(sparkUseKrb) {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__RESOURCEMANAGER_PRINCIPAL__"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__JOBHISTORY_PRINCIPAL__"));
    stringBuffer.append(TEXT_55);
    
                            boolean sparkUseKeytab = "true".equals(ElementParameterParser.getValue(sparkConfig, "__USE_KEYTAB__"));
                            if(sparkUseKeytab) {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__PRINCIPAL__"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__KEYTAB_PATH__"));
    stringBuffer.append(TEXT_58);
    
                            }
                        } else {
                            String sparkUsername = ElementParameterParser.getValue(sparkConfig, "__USERNAME__");
                            if(sparkUsername != null) {
                                if(username != null) {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(sparkUsername);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_61);
    
                                }
                                if(!"".equals(sparkUsername)) {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(sparkUsername);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(sparkUsername);
    stringBuffer.append(TEXT_64);
    
                                }
                            }
                        }
                    }
                } // End of: If the spark mode is not local.

                boolean defineHadoopHomeDir = "true".equals(ElementParameterParser.getValue(sparkConfig, "__DEFINE_HADOOP_HOME_DIR__"));
                if(defineHadoopHomeDir) {
                
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__HADOOP_HOME_DIR__"));
    stringBuffer.append(TEXT_66);
    
                }

				// tKafkaInput and tKafkaInputAvro component generation.
				List<INode> kafkaNodes = new ArrayList<INode>();
				for (INode pNode : process.getNodesOfType("tKafkaInput")) {
    				kafkaNodes.add(pNode);
				}
				for (INode pNode : process.getNodesOfType("tKafkaInputAvro")) {
    				kafkaNodes.add(pNode);
				}   
				if(!kafkaNodes.isEmpty()) {
					String maxRatePerPartition = null;
						for(INode kafkaNode : kafkaNodes) {
							if("true".equals(ElementParameterParser.getValue(kafkaNode, "__KAFKA_MAX_RATE_PER_PARTITION_CHECK__"))) {
								String currentMaxRatePerPartition = ElementParameterParser.getValue(kafkaNode, "__KAFKA_MAX_RATE_PER_PARTITION__");
								if(maxRatePerPartition == null || "".equals(maxRatePerPartition)){
									maxRatePerPartition = currentMaxRatePerPartition;
								}
								if(maxRatePerPartition != null && !maxRatePerPartition.equals(currentMaxRatePerPartition)) {

    stringBuffer.append(TEXT_67);
    
								}
							}
						}
					if(maxRatePerPartition != null && !"".equals(maxRatePerPartition)) {
    					Map<String, String> property = new HashMap<String, String>();
    					property.put("PROPERTY", "\"spark.streaming.kafka.maxRatePerPartition\"");
    					property.put("VALUE", maxRatePerPartition);
    					sparkAdvancedProperties.add(property);
					}
				}
				//End of tKafkaInput and tKafkaInputAvro component generation.

                if(tuningProperties) {
                    // Set Web UI port
                    if(setWebuiPort) {

    stringBuffer.append(TEXT_68);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__WEB_UI_PORT__"));
    stringBuffer.append(TEXT_69);
    
                    }

    stringBuffer.append(TEXT_70);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_DRIVER_MEM__"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_EXECUTOR_MEM__"));
    stringBuffer.append(TEXT_72);
    
                    if(useStandaloneMode || useYarnClusterMode) {

    stringBuffer.append(TEXT_73);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_DRIVER_CORES__"));
    stringBuffer.append(TEXT_74);
    
                    } else if(useYarnClientMode) {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_DRIVER_CORES__"));
    stringBuffer.append(TEXT_76);
    
                    }
                    boolean setExecutorCores = "true".equals(ElementParameterParser.getValue(sparkConfig, "__SPARK_EXECUTOR_CORES_CHECK__"));
                    if(setExecutorCores && !useLocalMode) {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_EXECUTOR_CORES__"));
    stringBuffer.append(TEXT_78);
                            
                    }

                    if(useYarnMode) {
                        String allocationMode = ElementParameterParser.getValue(sparkConfig, "__SPARK_YARN_ALLOC_TYPE__");
                        // we do nothing in AUTO mode
                        if("FIXED".equalsIgnoreCase(allocationMode)) {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_EXECUTOR_INSTANCES__"));
    stringBuffer.append(TEXT_80);
    
                        } else if("DYNAMIC".equalsIgnoreCase(allocationMode) && ("CUSTOM".equals(distribution) || "CLOUDERA".equals(distribution) || ("AMAZON_EMR".equals(distribution) && "EMR_4_0_0".equals(sparkVersion)))) {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_YARN_DYN_INIT__"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_YARN_DYN_MIN__"));
    stringBuffer.append(TEXT_83);
    
                            String dynMaxValue = ElementParameterParser.getValue(sparkConfig, "__SPARK_YARN_DYN_MAX__");
                            if(dynMaxValue.contains("MAX")) {

    stringBuffer.append(TEXT_84);
                                    
                            }
                            else {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(dynMaxValue);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(dynMaxValue);
    stringBuffer.append(TEXT_87);
                                    
                            }

    stringBuffer.append(TEXT_88);
    
                        }
                    }
                    String broadcastFactory = ElementParameterParser.getValue(sparkConfig, "__SPARK_BROADCAST_FACTORY__");
                    // we do nothing in auto mode
                    if("TORRENT".equalsIgnoreCase(broadcastFactory)) {

    stringBuffer.append(TEXT_89);
    
                    } else if ("HTTP".equalsIgnoreCase(broadcastFactory)) {

    stringBuffer.append(TEXT_90);
                            
                    }

                    boolean customizeSparkSerializer = "true".equals(ElementParameterParser.getValue(sparkConfig, "__CUSTOMIZE_SPARK_SERIALIZER__"));
                    if(customizeSparkSerializer) {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_SERIALIZER__"));
    stringBuffer.append(TEXT_92);
                            
                    }
                } // end set of tuning properties

                for(Map<String, String> property : sparkAdvancedProperties){

    stringBuffer.append(TEXT_93);
    stringBuffer.append(property.get("PROPERTY"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(property.get("VALUE"));
    stringBuffer.append(TEXT_95);
    
                }

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    }
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(jobFolderName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_SCRATCH_DIR__"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(ElementParameterParser.getValue(sparkConfig, "__SPARK_SCRATCH_DIR__"));
    stringBuffer.append(TEXT_106);
    
                if(useKrb) {
                    if(useKeytab) {

    stringBuffer.append(TEXT_107);
    stringBuffer.append(keytabPrincipal);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_109);
    
                    }
                }

    stringBuffer.append(TEXT_110);
    
				
    stringBuffer.append(TEXT_111);
    
                if(!useCheckpoint) {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_113);
    
                    if(stats) {

    stringBuffer.append(TEXT_114);
    
                    }

    stringBuffer.append(TEXT_115);
    
                    for (INode rootNode : rootNodes) {
                        String componentName = rootNode.getComponent().getName();
                        String uniqueName = rootNode.getUniqueName();
                        if ((rootNode.getOutgoingConnections().size() > 0) || ("tJava".equals(componentName))) {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(rootNode.getUniqueName());
    stringBuffer.append(TEXT_118);
    
                        } // end if
                    } // end for

    stringBuffer.append(TEXT_119);
    
                } else {

    stringBuffer.append(TEXT_120);
    
                            for (INode rootNode : rootNodes) {
                                String componentName = rootNode.getComponent().getName();
                                String uniqueName = rootNode.getUniqueName();
                                if ((rootNode.getOutgoingConnections().size() > 0) || ("tJava".equals(componentName))) {

    stringBuffer.append(TEXT_121);
    stringBuffer.append(rootNode.getUniqueName());
    stringBuffer.append(TEXT_122);
    
                                } // end if
                            } // end for

    stringBuffer.append(TEXT_123);
    stringBuffer.append(checkpointDir);
    stringBuffer.append(TEXT_124);
    
                                if(stats) {
                        
    stringBuffer.append(TEXT_125);
    
                                }
                        
    
                        boolean defineDuration = "true".equals(ElementParameterParser.getValue(sparkConfig, "__DEFINE_DURATION__"));
                        String duration = ElementParameterParser.getValue(sparkConfig, "__STREAMING_DURATION__");
                        
    stringBuffer.append(TEXT_126);
    stringBuffer.append(defineDuration?duration:"");
    stringBuffer.append(TEXT_127);
    
                }

    stringBuffer.append(TEXT_128);
    
        }

    stringBuffer.append(TEXT_129);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(codeGenArgument.getCurrentProjectName().toLowerCase());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(jobFolderName);
    stringBuffer.append(TEXT_132);
    
                for(IContextParameter ctxParam :params){
                    String typeToGenerate = "String";
                    if(ctxParam.getType().equals("id_List Of Value") || ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory")){
                        typeToGenerate = "String";
                    }else{
                        typeToGenerate = JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true);
                    }
                    
    stringBuffer.append(TEXT_133);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_137);
    
                }
                
    stringBuffer.append(TEXT_138);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(codeGenArgument.getCurrentProjectName().toLowerCase());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(jobFolderName);
    stringBuffer.append(TEXT_141);
    
                if(!useLocalMode) {

    stringBuffer.append(TEXT_142);
      
                }

    stringBuffer.append(TEXT_143);
    
            for(IContextParameter ctxParam : params){
            
    stringBuffer.append(TEXT_144);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_148);
    
            }
            
    stringBuffer.append(TEXT_149);
    stringBuffer.append(TEXT_150);
    return stringBuffer.toString();
  }
}
