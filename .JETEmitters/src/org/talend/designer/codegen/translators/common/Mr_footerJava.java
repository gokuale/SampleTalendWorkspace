package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.CorePlugin;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.Vector;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.JavaResourcesHelper;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;

public class Mr_footerJava
{
  protected static String nl;
  public static synchronized Mr_footerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Mr_footerJava result = new Mr_footerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "    public String resuming_logs_dir_path = null;" + NL + "    public String resuming_checkpoint_path = null;" + NL + "    public String parent_part_launcher = null;" + NL + "    private String resumeEntryMethodName = null;" + NL + "    ResumeUtil resumeUtil = null;" + NL + "    private boolean globalResumeTicket = false;" + NL + "" + NL + "    public String pid = \"0\";" + NL + "    public String rootPid = null;" + NL + "    public String fatherPid = null;" + NL + "" + NL + "    public boolean isChildJob = false;" + NL + "" + NL + "    private MRRunStat runStat = new MRRunStat();" + NL + "    // portStats is null, it means don't execute the statistics" + NL + "    public Integer portStats = null;" + NL + "    public String clientHost;" + NL + "    public String defaultClientHost = \"localhost\";" + NL + "    private boolean execStat = true;" + NL + "    public String log4jLevel = \"\";" + NL + "" + NL + "    public String contextStr = \"";
  protected final String TEXT_2 = "\";" + NL + "    public boolean isDefaultContext = true;" + NL + "" + NL + "    private java.util.Properties context_param = new java.util.Properties();" + NL + "    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();" + NL + "" + NL + "    public String status= \"\";" + NL + "" + NL + "    private String mr_temp_dir = \"\";" + NL + "" + NL + "" + NL + "    public static void main(String[] args){" + NL + "        final ";
  protected final String TEXT_3 = " ";
  protected final String TEXT_4 = "Class = new ";
  protected final String TEXT_5 = "();" + NL + "        int exitCode = ";
  protected final String TEXT_6 = "Class.runJobInTOS(args);" + NL + "        System.exit(exitCode);" + NL + "    }" + NL + "" + NL + "    public String[][] runJob(String[] args){" + NL + "        int exitCode = runJobInTOS(args);" + NL + "        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };" + NL + "        return bufferValue;" + NL + "    }" + NL + "" + NL + "    public int runJobInTOS (String[] args) {" + NL + "    \targs = normalizeArgs(args);" + NL + "\t\t";
  protected final String TEXT_7 = NL + "\t\t\ttry{" + NL + "\t\t\t\tint exitCode = 0;";
  protected final String TEXT_8 = NL + "\t\t\t\t\tif(!isTempletonCall(args)) {" + NL + "\t\t\t\t\t\texitCode = runTempletonJob();" + NL + "\t\t\t\t\t} else {";
  protected final String TEXT_9 = NL + "\t\t\t\t\t\texitCode = ToolRunner.run(new Configuration(), this, args);";
  protected final String TEXT_10 = NL + "\t\t\t\t\t}";
  protected final String TEXT_11 = NL + "\t\t\t\treturn exitCode;" + NL + "\t\t\t}catch(Exception ex){" + NL + "\t\t\t\tex.printStackTrace();" + NL + "\t\t\t\treturn 1;" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_12 = NL + "    }";
  protected final String TEXT_13 = NL + "\t\tpublic int runTempletonJob() throws Exception {" + NL + "\t\t\tinitContext();";
  protected final String TEXT_14 = NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\tclass GetJarsToRegister_";
  protected final String TEXT_16 = " {" + NL + "\t\t\tprivate String oozieClasspathLine;" + NL + "\t\t\tprivate boolean isOozieRuntime;" + NL + "\t\t\t" + NL + "\t\t\tpublic GetJarsToRegister_";
  protected final String TEXT_17 = "() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tthis.isOozieRuntime = setJarsToRegister();" + NL + "\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_19 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean setJarsToRegister() throws IOException, org.dom4j.DocumentException {" + NL + "\t\t\t\tString jobXmlPath = new java.io.File(\"../../job.xml\").getCanonicalPath();" + NL + "\t\t\t\tboolean isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\tif(!isOozieExecution) {" + NL + "\t\t\t\t    jobXmlPath = new java.io.File(\"./job.xml\").getCanonicalPath();" + NL + "\t\t\t\t    isOozieExecution = isNeedAddLibsPath(jobXmlPath);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(isOozieExecution) {" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.dom4j.io.SAXReader reader_oozie = new org.dom4j.io.SAXReader();" + NL + "\t\t\t\t\torg.dom4j.Document document_oozie = reader_oozie.read(jobXmlPath);" + NL + "\t\t\t\t\tList list_oozie = document_oozie.selectNodes(\"/configuration/property\");" + NL + "\t\t\t\t\tfor (java.util.Iterator iter_oozie = list_oozie.iterator(); iter_oozie.hasNext();) {" + NL + "\t\t\t\t\t\torg.dom4j.Element element_oozie = (org.dom4j.Element) iter_oozie.next();" + NL + "\t\t\t\t\t\tString name_oozie = element_oozie.elementText(\"name\");" + NL + "\t\t\t\t\t\tif(name_oozie.equals(\"mapred.cache.localFiles\") || name_oozie.equals(\"mapreduce.job.cache.local.files\")) {" + NL + "\t\t\t\t\t\t\tthis.oozieClasspathLine = element_oozie.elementText(\"value\");" + NL + "\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\t\treturn replaceJarPaths(originalClassPathLine, \"\");" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tpublic String replaceJarPaths(String originalClassPathLine, String scheme) throws Exception {" + NL + "\t\t\t\tString classPathLine = \"\";" + NL + "\t\t\t\tString crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "\t\t\t\t" + NL + "\t\t\t\tif (isNeedAddLibsPath(crcMapPath)) {" + NL + "\t\t\t\t\tjava.util.Map<String, String> crcMap = null;" + NL + "\t\t\t\t\tjava.io.ObjectInputStream ois = new ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "\t\t\t\t\tcrcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "\t\t\t\t\tois.close();" + NL + "\t\t\t\t\tclassPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "\t\t\t\t} else if(this.isOozieRuntime) {" + NL + "\t\t\t\t\tif(this.oozieClasspathLine!=null) {" + NL + "\t\t\t\t\t\tList<String> oozieJars = java.util.Arrays.asList(this.oozieClasspathLine.split(\",\"));" + NL + "\t\t\t\t\t\tfor(int j=0; j<oozieJars.size(); j++) {" + NL + "\t\t\t\t\t\t\tif(oozieJars.get(j).contains(originalClassPathLine.substring(originalClassPathLine.lastIndexOf(\"/\")))) {" + NL + "\t\t\t\t\t\t\t\tclassPathLine = oozieJars.get(j);" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tif(originalClassPathLine!=null && originalClassPathLine.startsWith(\".\")) {" + NL + "\t\t\t\t\t\tclassPathLine = originalClassPathLine;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tclassPathLine = scheme + originalClassPathLine;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn classPathLine;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "\t\t\t\tif (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\t\tprivate String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "\t\t\t\tfor (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "\t\t\t\t\tline = adaptLibPaths(line, entry);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\tprivate String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "\t\t\t\tString jarName = entry.getValue();" + NL + "\t\t\t\tString crc = entry.getKey();" + NL + "\t\t\t\tString libStringFinder = \"../lib/\" + jarName;" + NL + "\t\t\t\tString libStringFinder2 = \"./\" + jarName; // for the job jar itself." + NL + "\t\t\t\t" + NL + "\t\t\t\tif (line.contains(libStringFinder)) {" + NL + "\t\t\t\t\tline = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.toLowerCase().contains(libStringFinder2)) {" + NL + "\t\t\t\t\tline = line.toLowerCase().replace(libStringFinder2, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "\t\t\t\t} else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "\t\t\t\t\tline = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "\t\t\t\t} else if (line.contains(\";\" + jarName + \";\")) {" + NL + "\t\t\t\t\tline = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn line;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t}";
  protected final String TEXT_21 = NL + "\t\t\tGetJarsToRegister_";
  protected final String TEXT_22 = " getJarsToRegister = new GetJarsToRegister_";
  protected final String TEXT_23 = "();" + NL + "\t\t\tStringBuilder libjars = new StringBuilder();";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\t\tlibjars.append(getJarsToRegister.replaceJarPaths(\"";
  protected final String TEXT_25 = "\"));";
  protected final String TEXT_26 = NL + "\t\t\t\t\t\t\tlibjars.append(\",\" + getJarsToRegister.replaceJarPaths(\"";
  protected final String TEXT_27 = "\"));";
  protected final String TEXT_28 = NL + "\t\t\t\tfinal String hdInsightPassword = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "\t\t\t\tfinal String hdInsightPassword = ";
  protected final String TEXT_31 = ";";
  protected final String TEXT_32 = NL + "\t\t\t\tfinal String wasbPassword = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "\t\t\t\tfinal String wasbPassword = ";
  protected final String TEXT_35 = ";";
  protected final String TEXT_36 = NL + NL + "\t\t\torg.talend.webhcat.launcher.fs.FileSystem azureFs = new org.talend.webhcat.launcher.fs.AzureFileSystem(\"DefaultEndpointsProtocol=https;\"" + NL + "\t\t\t\t+ \"AccountName=\"" + NL + "\t\t\t\t+ ";
  protected final String TEXT_37 = NL + "\t\t\t\t+ \";\"" + NL + "\t\t\t\t+ \"AccountKey=\" + wasbPassword, ";
  protected final String TEXT_38 = ");" + NL + "" + NL + "\t\t\torg.talend.webhcat.launcher.common.Job instance = new org.talend.webhcat.launcher.common.impl.MapReduceJob(azureFs);" + NL + "" + NL + "\t\t\tinstance.setAzureAccountName(";
  protected final String TEXT_39 = ");" + NL + "\t\t\tinstance.setAzureAccountPassword(wasbPassword);" + NL + "\t\t\tinstance.setAzureStorageAddress(";
  protected final String TEXT_40 = ");" + NL + "\t\t\tinstance.setAzureContainer(";
  protected final String TEXT_41 = ");" + NL + "\t\t\tinstance.setHdInsightUsername(";
  protected final String TEXT_42 = ");" + NL + "\t\t\tinstance.setHdInsightPassword(hdInsightPassword);" + NL + "\t\t\tinstance.setUsername(";
  protected final String TEXT_43 = ");" + NL + "\t\t\tinstance.setWebhcatEndpoint(\"https\", ";
  protected final String TEXT_44 = " + \":\" + ";
  protected final String TEXT_45 = ");" + NL + "\t\t\tinstance.setStatusFolder(org.talend.webhcat.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_46 = "));" + NL + "\t\t\tinstance.setRemoteFolder(org.talend.webhcat.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_47 = "));" + NL + "" + NL + "\t\t\tinstance.setJarToExecute(\"";
  protected final String TEXT_48 = "\" + \".jar\");" + NL + "\t\t\tinstance.setClassToExecute(\"";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = "\");" + NL + "\t\t\tinstance.setLibJars(libjars.toString());" + NL + "\t\t\tinstance.callWS(instance.sendFiles(), true);" + NL + "\t\t\tint returnCode = instance.execute();" + NL + "" + NL + "\t\t\tjava.io.InputStream is = instance.getStdOut();" + NL + "\t\t\tif(is!=null) {" + NL + "\t\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(is));" + NL + "\t\t\t\tString s;" + NL + "\t\t\t\twhile ((s = reader.readLine()) != null) {" + NL + "\t\t\t\t\tSystem.out.println(s);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\treturn returnCode;" + NL + "\t\t}";
  protected final String TEXT_52 = NL + NL + "    public int run(String[] args) throws Exception {" + NL + "" + NL + "        String lastStr = \"\";" + NL + "        for (String arg : args) {" + NL + "            if (arg.equalsIgnoreCase(\"--context_param\")) {" + NL + "                lastStr = arg;" + NL + "            } else if (lastStr.equals(\"\")) {" + NL + "                evalParam(arg);" + NL + "            } else {" + NL + "                evalParam(lastStr + \" \" + arg);" + NL + "                lastStr = \"\";" + NL + "            }" + NL + "        }" + NL;
  protected final String TEXT_53 = NL + "            if(!\"\".equals(log4jLevel)){" + NL + "                if(\"trace\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.TRACE);" + NL + "                }else if(\"debug\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.DEBUG);" + NL + "                }else if(\"info\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.INFO);" + NL + "                }else if(\"warn\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.WARN);" + NL + "                }else if(\"error\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.ERROR);" + NL + "                }else if(\"fatal\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.FATAL);" + NL + "                }else if (\"off\".equalsIgnoreCase(log4jLevel)){" + NL + "                    log.setLevel(org.apache.log4j.Level.OFF);" + NL + "                }" + NL + "                org.apache.log4j.Logger.getRootLogger().setLevel(log.getLevel());" + NL + "            }" + NL + "            log.info(\"TalendJob: '";
  protected final String TEXT_54 = "' - Start.\");";
  protected final String TEXT_55 = NL + NL + "        startStat();" + NL + "" + NL + "        initContext();" + NL + "" + NL + "        initMapReduceJob(getConf());" + NL + "" + NL + "        initResume();" + NL + "        " + NL + "\t\tList<String> parametersToEncrypt = new java.util.ArrayList<String>();" + NL + "\t\t";
  protected final String TEXT_56 = NL + "\t\t\tparametersToEncrypt.add(\"";
  protected final String TEXT_57 = "\");" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "        resumeUtil.addLog(\"JOB_STARTED\", \"JOB:\" + jobName, parent_part_launcher," + NL + "            Thread.currentThread().getId() + \"\", \"\", \"\", \"\", \"\"," + NL + "            ResumeUtil.convertToJsonText(context,parametersToEncrypt));" + NL + "" + NL + "" + NL + "        mr_temp_dir = (new java.io.File(";
  protected final String TEXT_59 = ", jobName)).toString();" + NL + "        validTempFolder(mr_temp_dir);" + NL + "        globalMap = new GlobalVar(getConf());";
  protected final String TEXT_60 = NL + "            try{";
  protected final String TEXT_61 = NL + "                ";
  protected final String TEXT_62 = "Process(globalMap);" + NL + "\t\t\t\t}catch(Exception e){" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\te.printStackTrace(errorMessagePS);" + NL + "\t\t\t\t\tstatus = \"failure\";" + NL + "\t\t\t\t}";
  protected final String TEXT_63 = NL + "\t\t\t\tclearTempFolder();";
  protected final String TEXT_64 = NL + NL + "\t\t\tendStat();" + NL + "" + NL + "\t\t\tint returnCode = 0;" + NL + "\t\t\tif(errorCode == null){" + NL + "\t\t\t\treturnCode = status != null && status.equals(\"failure\") ? 1 : 0;" + NL + "\t\t\t}else{" + NL + "\t\t\t\treturnCode = errorCode.intValue();" + NL + "\t\t\t}" + NL + "\t\t\tresumeUtil.addLog(\"JOB_ENDED\", \"JOB:\" + jobName, parent_part_launcher, Thread.currentThread().getId() + \"\", \"\",\"\" + returnCode, \"\", \"\",\"\");" + NL + "\t\t\treturn returnCode;" + NL + "\t\t}" + NL + "" + NL + "\t\tprivate void runMRJob(JobConf job, int groupID, int mrjobIDInGroup) throws IOException{" + NL + "\t\t\tString currentClientPathSeparator = System.getProperty(\"path.separator\");" + NL + "\t\t\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_65 = ");" + NL + "\t\t\tif(job.get(\"mapred.reducer.class\") == null){" + NL + "\t\t\t\tjob.setNumReduceTasks(0);" + NL + "\t\t\t}" + NL + "\t\t\tmrJobClient.setGroupID(groupID);" + NL + "\t\t\tmrJobClient.setMRJobIDInGroup(mrjobIDInGroup);" + NL + "\t\t\tmrJobClient.runJob(job);" + NL + "\t\t\tSystem.setProperty(\"path.separator\", currentClientPathSeparator);" + NL + "\t\t}" + NL + "" + NL + "\t\tprivate void initMapReduceJob(Configuration conf) throws IOException{";
  protected final String TEXT_66 = NL + "\t\t\t//set basic info" + NL + "\t\t\tFileSystem.setDefaultUri(conf, ";
  protected final String TEXT_67 = ");";
  protected final String TEXT_68 = NL + "\t        conf.set(\"mapred.compress.map.output\", \"true\");" + NL + "\t        conf.set(\"mapred.map.output.compression.codec\", \"org.apache.hadoop.io.compress.DefaultCodec\");";
  protected final String TEXT_69 = NL + "\t\t\tconf.set(\"mapreduce.job.map.output.collector.class\", \"org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "\t        conf.set(\"mapreduce.job.reduce.shuffle.consumer.plugin.class\", \"org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_70 = NL + "\t\t\t\tconf.set(\"mapreduce.framework.name\", \"yarn\");" + NL + "\t\t\t\tconf.set(\"yarn.resourcemanager.address\", ";
  protected final String TEXT_71 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\t\tconf.set(\"mapreduce.jobhistory.address\", ";
  protected final String TEXT_73 = ");" + NL + "\t    \t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\t\tconf.set(\"yarn.resourcemanager.scheduler.address\", ";
  protected final String TEXT_75 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\tconf.set(\"mapreduce.app-submission.cross-platform\",\"true\");" + NL + "\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\tconf.set(\"yarn.application.classpath\",\"/etc/hadoop/conf,/usr/lib/hadoop/*,/usr/lib/hadoop/lib/*,/usr/lib/hadoop-hdfs/*,/usr/lib/hadoop-hdfs/lib/*,/usr/lib/hadoop-yarn/*,/usr/lib/hadoop-yarn/lib/*,/usr/lib/hadoop-mapreduce/*,/usr/lib/hadoop-mapreduce/lib/*\");" + NL + "\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\tconf.set(\"mapreduce.application.classpath\",\"$PWD/mr-framework/hadoop/share/hadoop/mapreduce/*:$PWD/mr-framework/hadoop/share/hadoop/mapreduce/lib/*:$PWD/mr-framework/hadoop/share/hadoop/common/*:$PWD/mr-framework/hadoop/share/hadoop/common/lib/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/lib/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/lib/*:/etc/hadoop/conf/secure\");" + NL + "\t\t\t\t\tconf.set(\"yarn.application.classpath\",\"$HADOOP_CONF_DIR,/usr/hdp/current/hadoop-client/*,/usr/hdp/current/hadoop-client/lib/*,/usr/hdp/current/hadoop-hdfs-client/*,/usr/hdp/current/hadoop-hdfs-client/lib/*,/usr/hdp/current/hadoop-mapreduce-client/*,/usr/hdp/current/hadoop-mapreduce-client/lib/*,/usr/hdp/current/hadoop-yarn-client/*,/usr/hdp/current/hadoop-yarn-client/lib/*\");" + NL + "\t\t\t\t";
  protected final String TEXT_79 = NL + "                \tconf.set(\"yarn.application.classpath\",\"$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*,/usr/share/aws/emr/emr-fs/lib/*,/usr/share/aws/emr/lib/*\");" + NL + "            \t";
  protected final String TEXT_80 = NL + "\t\t\t\t\tconf.set(\"yarn.application.classpath\",\"$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,/usr/lib/hadoop-lzo/lib/*,/usr/share/aws/emr/emrfs/conf, /usr/share/aws/emr/emrfs/lib/*,/usr/share/aws/emr/emrfs/auxlib/*,/usr/share/aws/emr/lib/*,/usr/share/aws/emr/ddb/lib/emr-ddb-hadoop.jar, /usr/share/aws/emr/goodies/lib/emr-hadoop-goodies.jar,/usr/share/aws/emr/kinesis/lib/emr-kinesis-hadoop.jar,/usr/lib/spark/yarn/lib/datanucleus-api-jdo.jar,/usr/lib/spark/yarn/lib/datanucleus-core.jar,/usr/lib/spark/yarn/lib/datanucleus-rdbms.jar,/usr/share/aws/emr/cloudwatch-sink/lib/*\");" + NL + "\t\t\t\t";
  protected final String TEXT_81 = NL + "\t    \t\t\t//set default yarn classpath with environment variable" + NL + "\t    \t\t\tconf.set(\"yarn.application.classpath\",\"$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*\");" + NL + "\t\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t\t\tconf.set(\"mapreduce.app-submission.cross-platform\",\"true\");" + NL + "\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\t\tconf.set(\"yarn.app.mapreduce.am.staging-dir\", ";
  protected final String TEXT_84 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\tconf.set(\"mapreduce.map.memory.mb\", ";
  protected final String TEXT_86 = ");" + NL + "\t\t\t\tconf.set(\"mapreduce.reduce.memory.mb\", ";
  protected final String TEXT_87 = ");" + NL + "\t\t\t\tconf.set(\"yarn.app.mapreduce.am.resource.mb\", ";
  protected final String TEXT_88 = ");" + NL + "\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\tconf.set(\"mapred.job.tracker\", ";
  protected final String TEXT_90 = ");" + NL + "\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_92 = ", ";
  protected final String TEXT_93 = ");" + NL + "\t\t";
  protected final String TEXT_94 = NL + "\t\t\tconf.set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_95 = ");" + NL + "\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\tconf.set(\"mapreduce.jobtracker.kerberos.principal\", ";
  protected final String TEXT_97 = ");" + NL + "\t\t";
  protected final String TEXT_98 = NL + "\t\t\t\tconf.set(\"yarn.resourcemanager.principal\", ";
  protected final String TEXT_99 = ");" + NL + "\t\t\t\tconf.set(\"mapreduce.jobhistory.principal\", ";
  protected final String TEXT_100 = ");" + NL + "\t\t";
  protected final String TEXT_101 = NL + "\t\t\tconf.set(\"dfs.client.use.datanode.hostname\", \"true\");" + NL + "\t\t\t";
  protected final String TEXT_102 = NL + NL + "\t\t";
  protected final String TEXT_103 = NL + "        \tconf.set(\"mapred.job.map.memory.mb\", ";
  protected final String TEXT_104 = ");" + NL + "        \tconf.set(\"mapred.job.reduce.memory.mb\", ";
  protected final String TEXT_105 = ");" + NL + "\t\t";
  protected final String TEXT_106 = NL + NL + "\t\t//tunning m/r jobs" + NL + "\t\tsetDefaultMapReduceConfig(conf);" + NL + "" + NL + "\t\t//set custom hadoop properties" + NL + "\t\tsetCustomHadoopProperties(conf);" + NL + "" + NL + "\t\t//set context" + NL + "\t\tsetContext(conf);" + NL + "" + NL + "\t\t//init MRJobClient" + NL + "\t\tmrJobClient = new MRJobClient();" + NL + "\t\tif(execStat){" + NL + "\t\t\tmrJobClient.setRunStat(runStat);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\tprivate void setCustomHadoopProperties(Configuration conf){" + NL + "\t\t";
  protected final String TEXT_107 = NL + "\t\t\t\tconf.set(String.valueOf(";
  protected final String TEXT_108 = "), String.valueOf(";
  protected final String TEXT_109 = "));" + NL + "\t\t\t";
  protected final String TEXT_110 = NL + "\t}" + NL + "" + NL + "\tprivate void setDefaultMapReduceConfig(Configuration conf) throws IOException{" + NL + "\t\t//set default reduce number" + NL + "\t\tJobConf jobConf = new JobConf(conf);" + NL + "\t\tsetCustomHadoopProperties(jobConf);" + NL + "\t\tJobClient client = new JobClient(jobConf);" + NL + "\t\tint maxReduceNum = client.getClusterStatus()" + NL + "\t\t\t\t.getMaxReduceTasks();" + NL + "" + NL + "\t\tint reduceNum = (int) (maxReduceNum * 0.99);" + NL + "\t\treduceNum = reduceNum > 0 ? reduceNum : 1;" + NL + "" + NL + "\t\tconf.setInt(\"mapred.reduce.tasks\", reduceNum);" + NL + "\t\t//set distributedcache" + NL + "\t\torg.apache.hadoop.filecache.DistributedCache.createSymlink(conf);" + NL + "\t}" + NL + "" + NL + "\tprivate void validTempFolder(String mr_temp_dir) throws Exception{" + NL + "\t\tjava.io.File[] rootFoldersArray = java.io.File.listRoots();" + NL + "\t\tjava.util.List<java.io.File> listRootFoldersReadOnly = java.util.Arrays.asList(rootFoldersArray);" + NL + "\t\tjava.util.List<java.io.File> listRootFolders = new java.util.ArrayList<java.io.File>(listRootFoldersReadOnly);" + NL + "\t\tlistRootFolders.add(new java.io.File(System.getProperty(\"user.home\")));" + NL + "\t\t";
  protected final String TEXT_111 = NL + "\t\tlistRootFolders.add(new java.io.File(\"/user/\" + ";
  protected final String TEXT_112 = "));" + NL + "\t\t";
  protected final String TEXT_113 = NL + "\t\tlistRootFolders.add(new java.io.File(\"/user/\" + System.getProperty(\"user.name\")));" + NL + "\t\tif(listRootFolders.contains(new java.io.File(mr_temp_dir))) {" + NL + "\t\t\tthrow new Exception(\"Using a root folder or a home folder as the temporary directory is not recommended, please choose another one.\");" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\tprivate void startStat(){" + NL + "\t\tif(clientHost == null){" + NL + "\t\t\tclientHost = defaultClientHost;" + NL + "\t\t}" + NL + "\t\tif(portStats != null){" + NL + "\t\t\t// portStats = -1; //for testing" + NL + "\t\t\tif(portStats < 0 || portStats > 65535){" + NL + "\t\t\t\t// issue:10869, the portStats is invalid, so this client socket" + NL + "\t\t\t\t// can't open" + NL + "\t\t\t\tSystem.err.println(\"The statistics socket port \" + portStats" + NL + "\t\t\t\t\t\t+ \" is invalid.\");" + NL + "\t\t\t\texecStat = false;" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\texecStat = false;" + NL + "\t\t}" + NL + "\t\tif(execStat){" + NL + "\t\t\ttry{" + NL + "\t\t\t\trunStat.startThreadStat(clientHost, portStats);" + NL + "\t\t\t}catch(java.io.IOException ioException){" + NL + "\t\t\t\tioException.printStackTrace();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\tprivate void endStat(){" + NL + "\t\tif(execStat){" + NL + "\t\t\trunStat.stopThreadStat();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\tprivate void initContext(){" + NL + "\t\t//get context" + NL + "\t\ttry{" + NL + "\t        //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead." + NL + "\t        java.io.InputStream inContext = ";
  protected final String TEXT_114 = ".class.getClassLoader().getResourceAsStream(\"";
  protected final String TEXT_115 = "/";
  protected final String TEXT_116 = "/contexts/\"+contextStr+\".properties\");" + NL + "\t        if(isDefaultContext && inContext == null){" + NL + "" + NL + "\t        }else{" + NL + "\t            if(inContext!=null){" + NL + "\t            \t//defaultProps is in order to keep the original context value" + NL + "                    defaultProps.load(inContext);" + NL + "                    inContext.close();" + NL + "                    context = new ContextProperties(defaultProps);" + NL + "                }else{" + NL + "                    //print info and job continue to run, for case: context_param is not empty." + NL + "                    System.err.println(\"Could not find the context \" + contextStr);" + NL + "                }" + NL + "            }" + NL + "" + NL + "            if(!context_param.isEmpty()){" + NL + "                context.putAll(context_param);" + NL + "            }" + NL + "            context.loadValue(context_param,null);" + NL + "            if(parentContextMap != null && !parentContextMap.isEmpty()){";
  protected final String TEXT_117 = NL + "                    if(parentContextMap.containsKey(\"";
  protected final String TEXT_118 = "\")){" + NL + "                        context.";
  protected final String TEXT_119 = " = (";
  protected final String TEXT_120 = ") parentContextMap.get(\"";
  protected final String TEXT_121 = "\");" + NL + "                    }";
  protected final String TEXT_122 = NL + "            }" + NL + "        }catch (java.io.IOException ie){" + NL + "            System.err.println(\"Could not load context \"+contextStr);" + NL + "            ie.printStackTrace();" + NL + "        }" + NL + "    }" + NL + "" + NL + "    private void setContext(Configuration conf){" + NL + "        //get context" + NL + "        try{" + NL + "            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead." + NL + "            java.net.URL inContextUrl = ";
  protected final String TEXT_123 = ".class.getClassLoader().getResource(\"";
  protected final String TEXT_124 = "/";
  protected final String TEXT_125 = "/contexts/\"+contextStr+\".properties\");" + NL + "            if(isDefaultContext && inContextUrl == null){" + NL + "" + NL + "            }else{" + NL + "                if(inContextUrl!=null){" + NL + "                    conf.set(ContextProperties.CONTEXT_FILE_NAME, contextStr+\".properties\");" + NL + "                    org.talend.hadoop.mapred.lib.DistributedCache.addCacheFile(new java.net.URI(inContextUrl.getProtocol(),inContextUrl.getHost(),inContextUrl.getPath(), contextStr+\".properties\"), conf);" + NL + "                }" + NL + "            }" + NL + "" + NL + "            if(!context_param.isEmpty()){" + NL + "                for(Object contextKey : context_param.keySet()){" + NL + "                    conf.set(ContextProperties.CONTEXT_PARAMS_PREFIX + contextKey, context.getProperty(contextKey.toString()));" + NL + "                    conf.set(ContextProperties.CONTEXT_KEYS, conf.get(ContextProperties.CONTEXT_KEYS, \"\") + \" \" + contextKey);" + NL + "                }" + NL + "            }" + NL + "" + NL + "            if(parentContextMap != null && !parentContextMap.isEmpty()){";
  protected final String TEXT_126 = NL + "                    if(parentContextMap.containsKey(\"";
  protected final String TEXT_127 = "\")){" + NL + "                        conf.set(ContextProperties.CONTEXT_PARENT_PARAMS_PREFIX + \"";
  protected final String TEXT_128 = "\", parentContextMap.get(\"";
  protected final String TEXT_129 = "\").toString());" + NL + "                        conf.set(ContextProperties.CONTEXT_PARENT_KEYS, conf.get(ContextProperties.CONTEXT_KEYS, \"\") + \" \" + \"";
  protected final String TEXT_130 = "\");" + NL + "                    }";
  protected final String TEXT_131 = NL + "            }" + NL + "        }catch (java.net.URISyntaxException e){" + NL + "            System.err.println(\"Could not load context \"+contextStr);" + NL + "            e.printStackTrace();" + NL + "        }" + NL + "    }" + NL + "" + NL + "    private void initResume() {" + NL + "" + NL + "        if (pid == null || \"0\".equals(pid)) {" + NL + "            pid = TalendString.getAsciiRandomString(6);" + NL + "        }" + NL + "" + NL + "        if (rootPid == null) {" + NL + "            rootPid = pid;" + NL + "        }" + NL + "" + NL + "        if (fatherPid == null) {" + NL + "            fatherPid = pid;" + NL + "        } else {" + NL + "            isChildJob = true;" + NL + "        }" + NL + "" + NL + "        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);" + NL + "        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);" + NL + "        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);" + NL + "    }" + NL + "" + NL + "    private void clearTempFolder(){" + NL + "        try{";
  protected final String TEXT_132 = NL + "                final String mr_temp_dir = this.mr_temp_dir;" + NL + "                UserGroupInformation ugi = UserGroupInformation.createRemoteUser(";
  protected final String TEXT_133 = ");" + NL + "                ugi.doAs(new PrivilegedExceptionAction<Void>() {" + NL + "                    public Void run() throws Exception {";
  protected final String TEXT_134 = NL + "            FileSystem fs = FileSystem.get(getConf());" + NL + "            fs.delete(new Path(mr_temp_dir),true);";
  protected final String TEXT_135 = NL + "                        return null;" + NL + "                    }" + NL + "                });";
  protected final String TEXT_136 = NL + "        } catch (Exception e) {" + NL + "            e.printStackTrace();" + NL + "        }" + NL + "    }" + NL + "" + NL + "    private String genTempFolderForComponent(String name){" + NL + "        java.io.File tempDir = new java.io.File(";
  protected final String TEXT_137 = " + \"/\" + pid, name);" + NL + "        String tempDirPath = tempDir.getPath();" + NL + "        if(java.io.File.separatorChar != '/')" + NL + "            tempDirPath = tempDirPath.replace(java.io.File.separatorChar, '/');" + NL + "        return tempDirPath;" + NL + "    }" + NL + "" + NL + "    private static boolean runInRuntime;" + NL + "" + NL + "    private String[] normalizeArgs(String[] args){" + NL + "        if(args.length > 0) {" + NL + "            List<String> argsList = java.util.Arrays.asList(args);" + NL + "            int indexlibjars = argsList.indexOf(\"-libjars\");" + NL + "            if(indexlibjars > -1 && indexlibjars + 1 < args.length) {" + NL + "                indexlibjars += 1;" + NL + "                String newlibjars = argsList.get(indexlibjars);" + NL + "                newlibjars = newlibjars.replaceAll(\" \", \"%20\");" + NL + "                args[indexlibjars] = newlibjars;" + NL + "                return args;" + NL + "            }" + NL + "        }";
  protected final String TEXT_138 = NL + "\t\t\t\t\trunInRuntime = true;" + NL + "\t\t\t\t\tjava.util.Collection<String> jars = new java.util.HashSet<String>();";
  protected final String TEXT_139 = NL + "\t\t\t\t\t\tjars.add(\"";
  protected final String TEXT_140 = "\");";
  protected final String TEXT_141 = NL + "                    try {" + NL + "                        String libjars = (String) Class.forName(\"org.talend.cloud.MRHelper\")" + NL + "                            .getDeclaredMethod(\"getLibJars\", Class.class, java.util.Collection.class)" + NL + "                            .invoke(null, getClass(), jars);" + NL + "                        int len = args.length;" + NL + "                        args = java.util.Arrays.copyOf(args, len + 2);" + NL + "                        args[len] = \"-libjars\";" + NL + "                        args[len + 1] = libjars;" + NL + "                    } catch (Exception e) {" + NL + "                    }";
  protected final String TEXT_142 = NL + "        return args;" + NL + "    }" + NL;
  protected final String TEXT_143 = NL + "\t\tprivate boolean isTempletonCall(String[] args) {" + NL + "\t\t\tList<String> argsList = java.util.Arrays.asList(args);" + NL + "\t\t\tint indexlibjars = argsList.indexOf(\"-calledByTempleton\");" + NL + "\t\t\treturn (indexlibjars!=-1);" + NL + "\t\t}";
  protected final String TEXT_144 = NL + NL + "    private void evalParam(String arg) {" + NL + "        if (arg.startsWith(\"--resuming_logs_dir_path\")) {" + NL + "            resuming_logs_dir_path = arg.substring(25);" + NL + "        } else if (arg.startsWith(\"--resuming_checkpoint_path\")) {" + NL + "            resuming_checkpoint_path = arg.substring(27);" + NL + "        } else if (arg.startsWith(\"--parent_part_launcher\")) {" + NL + "            parent_part_launcher = arg.substring(23);" + NL + "        } else if (arg.startsWith(\"--father_pid=\")) {" + NL + "            fatherPid = arg.substring(13);" + NL + "        } else if (arg.startsWith(\"--root_pid=\")) {" + NL + "            rootPid = arg.substring(11);" + NL + "        } else if (arg.startsWith(\"--pid=\")) {" + NL + "            pid = arg.substring(6);" + NL + "        } else if (arg.startsWith(\"--context=\")) {" + NL + "            contextStr = arg.substring(\"--context=\".length());" + NL + "            isDefaultContext = false;" + NL + "        } else if (arg.startsWith(\"--context_param\")) {" + NL + "            String keyValue = arg.substring(\"--context_param\".length() + 1);" + NL + "            int index = -1;" + NL + "            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {" + NL + "                context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));" + NL + "            }" + NL + "        } else if (arg.startsWith(\"--stat_port=\")) {" + NL + "            String portStatsStr = arg.substring(12);" + NL + "            if (portStatsStr != null && !portStatsStr.equals(\"null\")) {" + NL + "                portStats = Integer.parseInt(portStatsStr);" + NL + "            }" + NL + "        } else if (arg.startsWith(\"--client_host=\")) {" + NL + "            clientHost = arg.substring(14);" + NL + "        } else if (arg.startsWith(\"--log4jLevel=\")) {" + NL + "            log4jLevel = arg.substring(13);" + NL + "        }" + NL + "    }" + NL + "" + NL + "    private final String[][] escapeChars = {" + NL + "        {\"\\\\\\\\\",\"\\\\\"},{\"\\\\n\",\"\\n\"},{\"\\\\'\",\"\\'\"},{\"\\\\r\",\"\\r\"}," + NL + "        {\"\\\\f\",\"\\f\"},{\"\\\\b\",\"\\b\"},{\"\\\\t\",\"\\t\"}" + NL + "        };" + NL + "    private String replaceEscapeChars (String keyValue) {" + NL + "" + NL + "        if (keyValue == null || (\"\").equals(keyValue.trim())) {" + NL + "            return keyValue;" + NL + "        }" + NL + "" + NL + "        StringBuilder result = new StringBuilder();" + NL + "        int currIndex = 0;" + NL + "        while (currIndex < keyValue.length()) {" + NL + "            int index = -1;" + NL + "            // judege if the left string includes escape chars" + NL + "            for (String[] strArray : escapeChars) {" + NL + "                index = keyValue.indexOf(strArray[0],currIndex);" + NL + "                if (index>=0) {" + NL + "" + NL + "                    result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));" + NL + "                    currIndex = index + strArray[0].length();" + NL + "                    break;" + NL + "                }" + NL + "            }" + NL + "            // if the left string doesn't include escape chars, append the left into the result" + NL + "            if (index < 0) {" + NL + "                result.append(keyValue.substring(currIndex));" + NL + "                currIndex = currIndex + keyValue.length();" + NL + "            }" + NL + "        }" + NL + "" + NL + "        return result.toString();" + NL + "    }" + NL + "" + NL + "    public Integer getErrorCode() {" + NL + "        return errorCode;" + NL + "    }" + NL + "" + NL + "    public String getStatus() {" + NL + "        return status;" + NL + "    }" + NL + "}";
  protected final String TEXT_145 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    Vector v = (Vector) codeGenArgument.getArgument();
    IProcess process = (IProcess)v.get(0);

    boolean isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));

    List<INode> rootNodes = (List<INode>)v.get(1);
    INode mrconn = (INode)v.get(2);
    String jobFolderName = JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
    List<IContextParameter> params = new ArrayList<IContextParameter>();
    params=process.getContextManager().getDefaultContext().getContextParameterList();

    String mrNameNode = ElementParameterParser.getValue(mrconn,"__NAMENODE__");
    String mrJobTracker = ElementParameterParser.getValue(mrconn,"__JOBTRACKER__");

    boolean useYarn = "true".equals(ElementParameterParser.getValue(mrconn, "__USE_YARN__"));
    String resourceManager = ElementParameterParser.getValue(mrconn,"__RESOURCE_MANAGER__");
	String mrDistribution = ElementParameterParser.getValue(mrconn,"__DISTRIBUTION__");
	String mrVersion = ElementParameterParser.getValue(mrconn,"__MR_VERSION__");
	boolean isExecutedThroughWebHCat = "MICROSOFT_HD_INSIGHT_3_1".equals(mrVersion);
    boolean mrUseKrb = false;
    List<String> mrKrbSupportListHadoop1 = java.util.Arrays.asList("APACHE_1_0_0","HDP_1_2","HDP_1_3","Cloudera_CDH4","APACHE_1_0_3_EMR","Cloudera_CDH5_1_MR1");
    List<String> mrKrbSupportListHadoop2 = java.util.Arrays.asList("PIVOTAL_HD_2_0","HDP_2_0","HDP_2_1","HDP_2_2","Cloudera_CDH4_YARN","Cloudera_CDH5","Cloudera_CDH5_1","Cloudera_CDH5_4");
    if("CUSTOM".equals(mrDistribution) || mrKrbSupportListHadoop1.contains(mrVersion) || mrKrbSupportListHadoop2.contains(mrVersion)){
        mrUseKrb = "true".equals(ElementParameterParser.getValue(mrconn,"__USE_KRB__"));
    }
    String mrNNPrincipal = ElementParameterParser.getValue(mrconn,"__NAMENODE_PRINCIPAL__");
    String mrJTPrincipal = ElementParameterParser.getValue(mrconn,"__JOBTRACKER_PRINCIPAL__");
    String mrRMPrincipal = ElementParameterParser.getValue(mrconn,"__RESOURCEMANAGER_PRINCIPAL__");
    String mrJHPrincipal = ElementParameterParser.getValue(mrconn, "__JOBHISTORY_PRINCIPAL__");
    boolean useKeytab = "true".equals(ElementParameterParser.getValue(mrconn, "__USE_KEYTAB__"));
    String userPrincipal = ElementParameterParser.getValue(mrconn, "__PRINCIPAL__");
    String keytabPath = ElementParameterParser.getValue(mrconn, "__KEYTAB_PATH__");
    List<Map<String, String>> mrCustomProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(mrconn,"__HADOOP_ADVANCED_PROPERTIES__");
    String mrUserName = ElementParameterParser.getValue(mrconn,"__USERNAME__");
    boolean mrNeedUserName = !(mrUserName == null || "".equals(mrUserName) || "\"\"".equals(mrUserName) || mrUseKrb);
    String mrServerPathSeparator = ElementParameterParser.getValue(mrconn,"__SERVER_PATH_SEPARATOR__");
    boolean mrClearTempFolder = "true".equals(ElementParameterParser.getValue(mrconn,"__RM_TEMP_FOLDER__"));
    String mrTempFolder = ElementParameterParser.getValue(mrconn,"__TEMP_FOLDER__");
    boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(mrconn, "__USE_DATANODE_HOSTNAME__"));
    boolean mrCompressMapIO = "true".equals(ElementParameterParser.getValue(mrconn,"__MAPRED_JOB_COMPRESS_MAP_IO__"));
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(codeGenArgument.getContextName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_6);
    
		if(mrconn == null){
			System.err.println("use tMRConnection component to config the hadoop environment");
		}else{
			
    stringBuffer.append(TEXT_7);
    
				if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_8);
    
				}

    stringBuffer.append(TEXT_9);
    
				if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_10);
    
				}

    stringBuffer.append(TEXT_11);
    
		}
		
    stringBuffer.append(TEXT_12);
    
	if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_13);
    
			String cid = "MR";

    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    

			java.util.List<String> jarsToRegister = null;
			java.util.List<String> jars = null;
			String[] commandLine = new String[] {"<command>"};
			try {
				commandLine = ProcessorUtilities.getCommandLine("win32",true, process.getId(), "",org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, new String[]{});
			} catch (ProcessorException e) {
				e.printStackTrace();
			}

			jarsToRegister = new java.util.ArrayList();

			jarsToRegister.add("talend-webhcat-launcher-1.0.0.jar");
			jarsToRegister.add("userRoutines.jar");
			jarsToRegister.add("talend-mapred-lib.jar");
			jarsToRegister.add("systemRoutines.jar");
			jarsToRegister.add("routines.jar");
			jarsToRegister.add("snappy-java-1.0.5.jar");
			jarsToRegister.add("jackson-mapper-asl-1.8.8.jar");
			jarsToRegister.add("jackson-core-asl-1.8.8.jar");
			jarsToRegister.add("avro-mapred-1.5.4.jar");
			jarsToRegister.add("avro-1.5.4.jar");

			for (int j = 0; j < commandLine.length; j++) {
				if(commandLine[j].contains("jar")) {
					jars = java.util.Arrays.asList(commandLine[j].split(";"));
					break;
				}
			}


    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    

			for(int i=0; i<jarsToRegister.size(); i++) {
				String jarToRegister = jarsToRegister.get(i);
				for(int j=0; j<jars.size(); j++) {
					if(jars.get(j).contains(jarToRegister)) {
						if(i==0) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_25);
    
						} else {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_27);
    
						}
					}
				}
			}

			String passwordFieldName = "__HDINSIGHT_PASSWORD__";
			if (ElementParameterParser.canEncrypt(mrconn, passwordFieldName)) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(mrconn, passwordFieldName));
    stringBuffer.append(TEXT_29);
    
			} else {

    stringBuffer.append(TEXT_30);
    stringBuffer.append( ElementParameterParser.getValue(mrconn, passwordFieldName));
    stringBuffer.append(TEXT_31);
    
			}

			passwordFieldName = "__WASB_PASSWORD__";
			if (ElementParameterParser.canEncrypt(mrconn, passwordFieldName)) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(mrconn, passwordFieldName));
    stringBuffer.append(TEXT_33);
    
			} else {

    stringBuffer.append(TEXT_34);
    stringBuffer.append( ElementParameterParser.getValue(mrconn, passwordFieldName));
    stringBuffer.append(TEXT_35);
    
			}

    stringBuffer.append(TEXT_36);
    stringBuffer.append(ElementParameterParser.getValue(mrconn, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(ElementParameterParser.getValue(mrconn, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(ElementParameterParser.getValue(mrconn, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(ElementParameterParser.getValue(mrconn, "__WASB_HOST__"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(ElementParameterParser.getValue(mrconn, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(ElementParameterParser.getValue(mrconn, "__HDINSIGHT_USERNAME__"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(ElementParameterParser.getValue(mrconn, "__WEBHCAT_USERNAME__"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(ElementParameterParser.getValue(mrconn, "__WEBHCAT_HOST__"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(ElementParameterParser.getValue(mrconn, "__WEBHCAT_PORT__"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(ElementParameterParser.getValue(mrconn, "__STATUSDIR__"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(ElementParameterParser.getValue(mrconn, "__REMOTE_FOLDER__"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion()));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(codeGenArgument.getCurrentProjectName().toLowerCase());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion()));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_51);
    
	}

    stringBuffer.append(TEXT_52);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_53);
    stringBuffer.append(codeGenArgument.getJobName());
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    
		for(IContextParameter ctxParam :params) {
        	if ("id_Password".equals(ctxParam.getType())) {
			
    stringBuffer.append(TEXT_56);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_57);
    
        	}
        }
		
    stringBuffer.append(TEXT_58);
    stringBuffer.append(mrTempFolder);
    stringBuffer.append(TEXT_59);
    
        for(INode rootNode : rootNodes){
            String componentName = rootNode.getComponent().getName();
            String uniqueName = rootNode.getUniqueName();
            
    stringBuffer.append(TEXT_60);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(rootNode.getUniqueName());
    stringBuffer.append(TEXT_62);
    
	    	}

			if(mrClearTempFolder){

    stringBuffer.append(TEXT_63);
    
			}

    stringBuffer.append(TEXT_64);
    stringBuffer.append(mrServerPathSeparator);
    stringBuffer.append(TEXT_65);
    
		if(!isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(mrNameNode);
    stringBuffer.append(TEXT_67);
    
		}

		if (mrCompressMapIO) {
		    // Other possible values to be set when compressing intermediate map ouput.
		    // "mapred.compress.map.output"
	        // "mapred.map.output.compression.codec", "org.apache.hadoop.io.compress.SnappyCodec"
	        // "mapreduce.map.output.compress"
	        // "mapreduce.map.output.compress.codec"

    stringBuffer.append(TEXT_68);
    
		}

		if(!"CUSTOM".equals(mrDistribution) && ("MAPR401".equals(mrVersion) || "MAPR410".equals(mrVersion))) {//set the default properties

    stringBuffer.append(TEXT_69);
    
		}

		boolean isKerberosAvailableHadoop2 = !("CUSTOM".equals(mrDistribution)) && ("PIVOTAL_HD_2_0".equals(mrVersion) || "HDP_2_0".equals(mrVersion) || "HDP_2_1".equals(mrVersion) || "HDP_2_2".equals(mrVersion) || "Cloudera_CDH4_YARN".equals(mrVersion) || "Cloudera_CDH5".equals(mrVersion) || "Cloudera_CDH5_1".equals(mrVersion) || "Cloudera_CDH5_4".equals(mrVersion));
		boolean isHadoop2 = "PIVOTAL_HD_1_0_1".equals(mrVersion) || "APACHE_2_4_0_EMR".equals(mrVersion) || "EMR_4_0_0".equals(mrVersion) || "MAPR401".equals(mrVersion) || "MAPR410".equals(mrVersion) || isKerberosAvailableHadoop2 || "MICROSOFT_HD_INSIGHT_3_1".equals(mrVersion);
		boolean isKerberosAvailableHadoop1 = !("CUSTOM".equals(mrDistribution)) && (mrVersion!=null && mrKrbSupportListHadoop1.contains(mrVersion));

		if((("CUSTOM".equals(mrDistribution) && useYarn) || (!"CUSTOM".equals(mrDistribution) && isHadoop2))) {
    
			if(!isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_71);
    
				boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(mrconn, "__SET_JOBHISTORY_ADDRESS__"));
				if(setJobHistoryAddress) {
					String jobHistoryAddress = ElementParameterParser.getValue(mrconn,"__JOBHISTORY_ADDRESS__");
	    			
    stringBuffer.append(TEXT_72);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_73);
    
				}
				boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(mrconn, "__SET_SCHEDULER_ADDRESS__"));
				if(setSchedulerAddress) {
					String schedulerAddress = ElementParameterParser.getValue(mrconn,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");
				
    stringBuffer.append(TEXT_74);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_75);
    
				}
				if(!"CUSTOM".equals(mrDistribution) && ("HDP_2_1".equals(mrVersion) || "HDP_2_2".equals(mrVersion) || "Cloudera_CDH5".equals(mrVersion) || "Cloudera_CDH5_1".equals(mrVersion) || "Cloudera_CDH5_4".equals(mrVersion) || "MAPR401".equals(mrVersion) || "MAPR410".equals(mrVersion)|| "EMR_4_0_0".equals(mrVersion) || "APACHE_2_4_0_EMR".equals(mrVersion) || "APACHE_2_4_0_EMR_0_13_1".equals(mrVersion))) {
				
    stringBuffer.append(TEXT_76);
    
				}
				if(!"CUSTOM".equals(mrDistribution) && "HDP_2_1".equals(mrVersion)) {
				
    stringBuffer.append(TEXT_77);
    
				} else if(!"CUSTOM".equals(mrDistribution) && "HDP_2_2".equals(mrVersion)) {
				
    stringBuffer.append(TEXT_78);
    
				} else if (!"CUSTOM".equals(mrDistribution) && "APACHE_2_4_0_EMR".equals(mrVersion)) {
            	
    stringBuffer.append(TEXT_79);
    
				} else if (!"CUSTOM".equals(mrDistribution) && "EMR_4_0_0".equals(mrVersion)) {
				
    stringBuffer.append(TEXT_80);
    
				}else {
				
    stringBuffer.append(TEXT_81);
    
				}

				boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(mrconn, "__CROSS_PLATFORM_SUBMISSION__"));
				if("CUSTOM".equals(mrDistribution) && useYarn && crossPlatformSubmission) {
				
    stringBuffer.append(TEXT_82);
    
				}
				boolean setStagingDirectory = "true".equals(ElementParameterParser.getValue(mrconn, "__SET_STAGING_DIRECTORY__"));
				if(setStagingDirectory) {
					String stagingDirectory = ElementParameterParser.getValue(mrconn, "__STAGING_DIRECTORY__");
				
    stringBuffer.append(TEXT_83);
    stringBuffer.append(stagingDirectory);
    stringBuffer.append(TEXT_84);
    
				}				
			}

			boolean setMemory = "true".equals(ElementParameterParser.getValue(mrconn, "__SET_MEMORY__"));
			if(setMemory) {
				String mapMemory = ElementParameterParser.getValue(mrconn,"__MAPREDUCE_MAP_MEMORY_MB__");
				String reduceMemory = ElementParameterParser.getValue(mrconn,"__MAPREDUCE_REDUCE_MEMORY_MB__");
				String amMemory = ElementParameterParser.getValue(mrconn,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");
				
    stringBuffer.append(TEXT_85);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_88);
    
			}
		}else{
		
    stringBuffer.append(TEXT_89);
    stringBuffer.append(mrJobTracker);
    stringBuffer.append(TEXT_90);
    
		}
		if(mrUseKrb){
			if(useKeytab) {
		
    stringBuffer.append(TEXT_91);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_93);
    
			}
		
    stringBuffer.append(TEXT_94);
    stringBuffer.append(mrNNPrincipal);
    stringBuffer.append(TEXT_95);
    
			if(isKerberosAvailableHadoop1 || ("CUSTOM".equals(mrDistribution) && !useYarn)) {
		
    stringBuffer.append(TEXT_96);
    stringBuffer.append(mrJTPrincipal);
    stringBuffer.append(TEXT_97);
    
			}

			if(isKerberosAvailableHadoop2 || ("CUSTOM".equals(mrDistribution) && useYarn)) {
		
    stringBuffer.append(TEXT_98);
    stringBuffer.append(mrRMPrincipal);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(mrJHPrincipal);
    stringBuffer.append(TEXT_100);
    
			}
		}
		if (mrUseDatanodeHostname) {
		    
    stringBuffer.append(TEXT_101);
    
		}
		
    stringBuffer.append(TEXT_102);
    //For TDI-27581 add map and reduce memory
    	if(!"CUSTOM".equals(mrDistribution) && ("HDP_1_2".equals(mrVersion) || "HDP_1_3".equals(mrVersion))) {
        	String mapMemory = ElementParameterParser.getValue(mrconn,"__MAPRED_JOB_MAP_MEMORY_MB__");
        	String reduceMemory = ElementParameterParser.getValue(mrconn,"__MAPRED_JOB_REDUCE_MEMORY_MB__");
			
    stringBuffer.append(TEXT_103);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_105);
    
    	}
		
    stringBuffer.append(TEXT_106);
    
		if(mrCustomProps!=null && mrCustomProps.size()>0){
			for(int i = 0; i < mrCustomProps.size(); i++){
				Map<String, String> mrCustomProp = mrCustomProps.get(i);
				
    stringBuffer.append(TEXT_107);
    stringBuffer.append(mrCustomProp.get("PROPERTY"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(mrCustomProp.get("VALUE"));
    stringBuffer.append(TEXT_109);
    
			}
		}
		
    stringBuffer.append(TEXT_110);
    if(mrNeedUserName){
    stringBuffer.append(TEXT_111);
    stringBuffer.append(mrUserName);
    stringBuffer.append(TEXT_112);
    }
    stringBuffer.append(TEXT_113);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(codeGenArgument.getCurrentProjectName().toLowerCase());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(jobFolderName);
    stringBuffer.append(TEXT_116);
    
                for(IContextParameter ctxParam :params){
                    String typeToGenerate = "String";
                    if(ctxParam.getType().equals("id_List Of Value") || ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory")){
                        typeToGenerate = "String";
                    }else{
                        typeToGenerate = JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true);
                    }
                    
    stringBuffer.append(TEXT_117);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_121);
    
                }
                
    stringBuffer.append(TEXT_122);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(codeGenArgument.getCurrentProjectName().toLowerCase());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(jobFolderName);
    stringBuffer.append(TEXT_125);
    
                for(IContextParameter ctxParam : params){
                
    stringBuffer.append(TEXT_126);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_128);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_130);
    
                }
                
    stringBuffer.append(TEXT_131);
    
            if(mrNeedUserName){
            
    stringBuffer.append(TEXT_132);
    stringBuffer.append(mrUserName);
    stringBuffer.append(TEXT_133);
    
            }
            
    stringBuffer.append(TEXT_134);
    
            if(mrNeedUserName){
            
    stringBuffer.append(TEXT_135);
    
            }
            
    stringBuffer.append(TEXT_136);
    stringBuffer.append(mrTempFolder);
    stringBuffer.append(TEXT_137);
    
				String[] commandLine = new String[] {};
				try {
					commandLine = ProcessorUtilities.getCommandLine("win32",true, process.getId(), "",org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, new String[]{});
				} catch (ProcessorException e) {
					e.printStackTrace();
				}
				int indexlibjars = java.util.Arrays.asList(commandLine).indexOf("-libjars");
				if (indexlibjars != -1 && indexlibjars + 1 < commandLine.length) {

    stringBuffer.append(TEXT_138);
    
					for (String lib : commandLine[indexlibjars + 1].split(",")) {

    stringBuffer.append(TEXT_139);
    stringBuffer.append(lib.substring(lib.lastIndexOf('/') + 1));
    stringBuffer.append(TEXT_140);
    
					}

    stringBuffer.append(TEXT_141);
    
				}

    stringBuffer.append(TEXT_142);
    
	if(isExecutedThroughWebHCat) {

    stringBuffer.append(TEXT_143);
    
	}

    stringBuffer.append(TEXT_144);
    stringBuffer.append(TEXT_145);
    return stringBuffer.toString();
  }
}
