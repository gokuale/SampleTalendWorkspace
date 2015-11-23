package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.CodeGeneratorRoutine;
import org.talend.designer.codegen.i18n.Messages;
import org.talend.core.ui.branding.IBrandingService;
import org.talend.core.ui.branding.AbstractBrandingService;
import org.talend.core.GlobalServiceRegister;
import org.talend.designer.codegen.ITalendSynchronizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.utils.JavaResourcesHelper;

public class Spark_headerJava
{
  protected static String nl;
  public static synchronized Spark_headerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Spark_headerJava result = new Spark_headerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "package ";
  protected final String TEXT_3 = ";" + NL + "" + NL + "import routines.system.*;" + NL + "import routines.system.SparkRunStat.*;" + NL + "import routines.system.api.*;";
  protected final String TEXT_4 = NL + "import routines.";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL + NL + NL + "import java.io.IOException;" + NL + "import java.io.Serializable;" + NL + "import java.util.ArrayList;" + NL + "import java.util.List;" + NL + "import java.util.Map;" + NL + "import java.math.BigDecimal;" + NL + "import java.io.ObjectInputStream;" + NL + "" + NL + "import org.apache.hadoop.conf.Configuration;" + NL + "import org.apache.hadoop.conf.Configured;" + NL + "import org.apache.hadoop.fs.FileSystem;" + NL + "import org.apache.hadoop.fs.FSDataInputStream;" + NL + "import org.apache.hadoop.fs.FSDataOutputStream;" + NL + "import org.apache.hadoop.fs.Path;" + NL + "import org.apache.hadoop.io.compress.CompressionCodec;" + NL + "import org.apache.hadoop.io.compress.CompressionCodecFactory;" + NL + "import org.apache.hadoop.io.compress.GzipCodec;" + NL + "import org.apache.hadoop.io.LongWritable;" + NL + "import org.apache.hadoop.io.NullWritable;" + NL + "import org.apache.hadoop.io.Text;" + NL + "import org.apache.hadoop.io.Writable;" + NL + "import org.apache.hadoop.io.WritableComparable;" + NL + "import org.apache.hadoop.io.WritableComparator;" + NL + "import org.apache.hadoop.io.WritableUtils;" + NL + "import org.apache.hadoop.io.SequenceFile;" + NL + "import org.apache.hadoop.mapred.FileAlreadyExistsException;" + NL + "import org.apache.hadoop.mapred.FileInputFormat;" + NL + "import org.apache.hadoop.mapred.SequenceFileInputFormat;" + NL + "import org.apache.hadoop.mapred.FileOutputFormat;" + NL + "import org.apache.hadoop.mapred.FileSplit;" + NL + "import org.apache.hadoop.mapred.InputSplit;" + NL + "import org.apache.hadoop.mapred.InvalidJobConfException;" + NL + "import org.apache.hadoop.mapred.JobClient;" + NL + "import org.apache.hadoop.mapred.JobConf;" + NL + "import org.apache.hadoop.mapred.JobConfigurable;" + NL + "import org.apache.hadoop.mapred.Mapper;" + NL + "import org.apache.hadoop.mapred.MapReduceBase;" + NL + "import org.apache.hadoop.mapred.OutputCollector;" + NL + "import org.apache.hadoop.mapred.RecordReader;" + NL + "import org.apache.hadoop.mapred.RecordWriter;" + NL + "import org.apache.hadoop.mapred.Reducer;" + NL + "import org.apache.hadoop.mapred.Reporter;" + NL + "import org.apache.hadoop.mapred.InputFormat;" + NL + "import org.apache.hadoop.mapred.OutputFormat;" + NL + "import org.apache.hadoop.security.UserGroupInformation;" + NL + "import org.apache.hadoop.util.Tool;" + NL + "import org.apache.hadoop.util.ToolRunner;" + NL + "import org.apache.hadoop.util.Progressable;" + NL + "import org.apache.hadoop.util.ReflectionUtils;" + NL + "import org.apache.commons.lang.SerializationUtils;" + NL + "import org.apache.commons.codec.binary.Base64;" + NL + "import org.apache.commons.codec.binary.StringUtils;" + NL + "import java.io.DataInput;" + NL + "import java.io.DataOutput;" + NL + "import java.io.DataOutputStream;" + NL + "import java.util.Date;" + NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + NL;
  protected final String TEXT_10 = NL + "    //the import part of ";
  protected final String TEXT_11 = NL + "    ";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL + NL + "@SuppressWarnings(\"unused\")" + NL + "" + NL + "/**" + NL + " * Job: ";
  protected final String TEXT_14 = " Purpose: ";
  protected final String TEXT_15 = "<br>" + NL + " * Description: ";
  protected final String TEXT_16 = " <br>" + NL + " * @author ";
  protected final String TEXT_17 = NL + " * @version ";
  protected final String TEXT_18 = NL + " * @status ";
  protected final String TEXT_19 = NL + " */" + NL + "public class ";
  protected final String TEXT_20 = " implements TalendJob {" + NL + "    static {" + NL + "        System.setProperty(\"TalendJob.log\", \"";
  protected final String TEXT_21 = ".log\");" + NL + "    }" + NL + "    private final static String utf8Charset = \"UTF-8\";" + NL + "    private GlobalVar globalMap = null;" + NL + "    private static org.apache.log4j.Logger LOG = org.apache.log4j.Logger" + NL + "            .getLogger(";
  protected final String TEXT_22 = ".class);" + NL + "" + NL + "    // DI compatibility" + NL + "    private static org.apache.log4j.Logger log = LOG;" + NL + "" + NL + "    private static class GlobalVar {" + NL + "        public static final String GLOBALVAR_PARAMS_PREFIX = \"talend.globalvar.params.\";" + NL + "        private Configuration job;" + NL + "        private java.util.Map<String, Object> map;" + NL + "" + NL + "        public GlobalVar(Configuration job) {" + NL + "            this.job = job;" + NL + "            this.map = new java.util.HashMap<String, Object>();" + NL + "        }" + NL + "" + NL + "        public Object get(String key) {" + NL + "            String tempValue = job.get(GLOBALVAR_PARAMS_PREFIX + key);" + NL + "            if (tempValue != null) {" + NL + "                return SerializationUtils.deserialize(Base64" + NL + "                        .decodeBase64(StringUtils.getBytesUtf8(tempValue)));" + NL + "            } else {" + NL + "                return null;" + NL + "            }" + NL + "        }" + NL + "" + NL + "        public void put(String key, Object value) {" + NL + "            if (value == null)" + NL + "                return;" + NL + "            job.set(GLOBALVAR_PARAMS_PREFIX + key, StringUtils" + NL + "                    .newStringUtf8(Base64.encodeBase64(SerializationUtils" + NL + "                            .serialize((Serializable) value))));" + NL + "        }" + NL + "" + NL + "        public void putLocal(String key, Object value) {" + NL + "            map.put(key, value);" + NL + "        }" + NL + "" + NL + "        public Object getLocal(String key) {" + NL + "            return map.get(key);" + NL + "        }" + NL + "    }" + NL + "" + NL + "    // create and load default properties" + NL + "    private java.util.Properties defaultProps = new java.util.Properties();" + NL + "    " + NL + "    public static class ContextProperties extends java.util.Properties {" + NL + "" + NL + "        private static final long serialVersionUID = 1L;" + NL + "" + NL + "        public static final String CONTEXT_FILE_NAME = \"talend.context.fileName\";" + NL + "        public static final String CONTEXT_KEYS = \"talend.context.keys\";" + NL + "        public static final String CONTEXT_PARAMS_PREFIX = \"talend.context.params.\";" + NL + "        public static final String CONTEXT_PARENT_KEYS = \"talend.context.parent.keys\";" + NL + "        public static final String CONTEXT_PARENT_PARAMS_PREFIX = \"talend.context.parent.params.\";" + NL + "" + NL + "        public ContextProperties(java.util.Properties properties){" + NL + "            super(properties);" + NL + "        }" + NL + "" + NL + "        public ContextProperties(){" + NL + "            super();" + NL + "        }" + NL + "" + NL + "        public ContextProperties(Configuration job){" + NL + "            super();" + NL + "            String contextFileName = (String) job.get(CONTEXT_FILE_NAME);" + NL + "            try {" + NL + "                if(contextFileName != null && !\"\".equals(contextFileName)){" + NL + "                    java.io.File contextFile = new java.io.File(contextFileName);" + NL + "                    if (contextFile.exists()) {" + NL + "                        java.io.InputStream contextIn = contextFile.toURI().toURL().openStream();" + NL + "                        this.load(contextIn);" + NL + "                        contextIn.close();" + NL + "                    } else {" + NL + "                        java.io.InputStream contextIn = ";
  protected final String TEXT_23 = ".class.getClassLoader().getResourceAsStream(\"";
  protected final String TEXT_24 = "/";
  protected final String TEXT_25 = "/contexts/\"+contextFileName);" + NL + "                        if(contextIn != null){" + NL + "                            this.load(contextIn);" + NL + "                            contextIn.close();" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "                Object contextKeys = job.get(CONTEXT_KEYS);" + NL + "                if (contextKeys != null) {" + NL + "                    java.util.StringTokenizer st = new java.util.StringTokenizer(contextKeys.toString(), \" \");" + NL + "                    while (st.hasMoreTokens()) {" + NL + "                        String contextKey = st.nextToken();" + NL + "                        if((String) job.get(CONTEXT_PARAMS_PREFIX + contextKey) != null){" + NL + "                            this.put(contextKey, job.get(CONTEXT_PARAMS_PREFIX + contextKey));" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "                Object contextParentKeys = job.get(CONTEXT_PARENT_KEYS);" + NL + "                if (contextParentKeys != null) {" + NL + "                    java.util.StringTokenizer st = new java.util.StringTokenizer(contextParentKeys.toString(), \" \");" + NL + "                    while (st.hasMoreTokens()) {" + NL + "                        String contextKey = st.nextToken();" + NL + "                        if((String)job.get(CONTEXT_PARENT_PARAMS_PREFIX + contextKey) != null){" + NL + "                            this.put(contextKey, job.get(CONTEXT_PARENT_PARAMS_PREFIX + contextKey));" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                this.loadValue(null,job);" + NL + "            } catch (java.io.IOException ie) {" + NL + "                System.err.println(\"Could not load context \" + contextFileName);" + NL + "                ie.printStackTrace();" + NL + "            }" + NL + "        }" + NL + "" + NL + "        public void synchronizeContext(){";
  protected final String TEXT_26 = NL + "                if(";
  protected final String TEXT_27 = " != null){";
  protected final String TEXT_28 = NL + "                        String pattern_";
  protected final String TEXT_29 = " = \"yyyy-MM-dd HH:mm:ss\";" + NL + "                        String value_";
  protected final String TEXT_30 = " = \"";
  protected final String TEXT_31 = "\";" + NL + "                        String[] parts_";
  protected final String TEXT_32 = " = value_";
  protected final String TEXT_33 = ".split(\";\");" + NL + "                        if(parts_";
  protected final String TEXT_34 = ".length > 1){" + NL + "                            pattern_";
  protected final String TEXT_35 = " = parts_";
  protected final String TEXT_36 = "[0];" + NL + "                            this.setProperty(\"";
  protected final String TEXT_37 = "\", pattern_";
  protected final String TEXT_38 = " + \";\" + FormatterUtils.format_DateInUTC(";
  protected final String TEXT_39 = ", pattern_";
  protected final String TEXT_40 = "));" + NL + "                        }else{" + NL + "                            this.setProperty(\"";
  protected final String TEXT_41 = "\", FormatterUtils.format_DateInUTC(";
  protected final String TEXT_42 = ", pattern_";
  protected final String TEXT_43 = "));" + NL + "                        }";
  protected final String TEXT_44 = NL + "                        this.setProperty(\"";
  protected final String TEXT_45 = "\", ";
  protected final String TEXT_46 = ".toString());";
  protected final String TEXT_47 = NL + "                }";
  protected final String TEXT_48 = NL + "        }" + NL;
  protected final String TEXT_49 = NL + "                public String ";
  protected final String TEXT_50 = ";" + NL + "                public String get";
  protected final String TEXT_51 = "(){" + NL + "                    return this.";
  protected final String TEXT_52 = ";" + NL + "                }";
  protected final String TEXT_53 = NL + "                public ";
  protected final String TEXT_54 = " ";
  protected final String TEXT_55 = ";" + NL + "                public ";
  protected final String TEXT_56 = " get";
  protected final String TEXT_57 = "(){" + NL + "                    return this.";
  protected final String TEXT_58 = ";" + NL + "                }";
  protected final String TEXT_59 = NL + "        public void loadValue(java.util.Properties context_param, Configuration job){";
  protected final String TEXT_60 = NL + "                    String pwd_";
  protected final String TEXT_61 = "_value = this.getProperty(\"";
  protected final String TEXT_62 = "\");" + NL + "                    this.";
  protected final String TEXT_63 = " = null;" + NL + "                    if(pwd_";
  protected final String TEXT_64 = "_value!=null) {" + NL + "                        //no need to decrypt if it come from program argument or parent job runtime" + NL + "                        if((context_param!=null && context_param.containsKey(\"";
  protected final String TEXT_65 = "\"))" + NL + "                         || (job!=null && job.get(CONTEXT_PARAMS_PREFIX + \"";
  protected final String TEXT_66 = "\") != null)" + NL + "                         || (job!=null && job.get(CONTEXT_PARENT_PARAMS_PREFIX + \"";
  protected final String TEXT_67 = "\") != null)){" + NL + "                            this.";
  protected final String TEXT_68 = " = pwd_";
  protected final String TEXT_69 = "_value;" + NL + "                        } else if (!pwd_";
  protected final String TEXT_70 = "_value.isEmpty()) {" + NL + "                            try {" + NL + "                                this.";
  protected final String TEXT_71 = " = routines.system.PasswordEncryptUtil.decryptPassword(pwd_";
  protected final String TEXT_72 = "_value);" + NL + "                            } catch (java.lang.RuntimeException e) {" + NL + "                                //do nothing" + NL + "                            }" + NL + "                        }" + NL + "                    }";
  protected final String TEXT_73 = NL + "                    try{" + NL + "                        String context_";
  protected final String TEXT_74 = "_value = this.getProperty(\"";
  protected final String TEXT_75 = "\");" + NL + "                        if (context_";
  protected final String TEXT_76 = "_value == null){" + NL + "                            context_";
  protected final String TEXT_77 = "_value = \"\";" + NL + "                        }" + NL + "                        int context_";
  protected final String TEXT_78 = "_pos = context_";
  protected final String TEXT_79 = "_value.indexOf(\";\");" + NL + "                        String context_";
  protected final String TEXT_80 = "_pattern =  \"yyyy-MM-dd HH:mm:ss\";" + NL + "                        if(context_";
  protected final String TEXT_81 = "_pos > -1){" + NL + "                            context_";
  protected final String TEXT_82 = "_pattern = context_";
  protected final String TEXT_83 = "_value.substring(0, context_";
  protected final String TEXT_84 = "_pos);" + NL + "                            context_";
  protected final String TEXT_85 = "_value = context_";
  protected final String TEXT_86 = "_value.substring(context_";
  protected final String TEXT_87 = "_pos + 1);" + NL + "                        }" + NL + "" + NL + "                        this.";
  protected final String TEXT_88 = "=(java.util.Date)(new java.text.SimpleDateFormat(context_";
  protected final String TEXT_89 = "_pattern).parse(context_";
  protected final String TEXT_90 = "_value));" + NL + "" + NL + "                    }catch(java.text.ParseException e){" + NL + "                        this.";
  protected final String TEXT_91 = "=null;" + NL + "                    }";
  protected final String TEXT_92 = NL + "                    this.";
  protected final String TEXT_93 = "=(";
  protected final String TEXT_94 = ") this.getProperty(\"";
  protected final String TEXT_95 = "\");";
  protected final String TEXT_96 = NL + "                     this.";
  protected final String TEXT_97 = "= new java.text.StringCharacterIterator(this.getProperty(\"";
  protected final String TEXT_98 = "\")).first();";
  protected final String TEXT_99 = NL + "                     try{" + NL + "                         this.";
  protected final String TEXT_100 = "=routines.system.BigDataParserUtils.parseTo_";
  protected final String TEXT_101 = "(this.getProperty(\"";
  protected final String TEXT_102 = "\"));" + NL + "                     }catch(NumberFormatException e){" + NL + "                         this.";
  protected final String TEXT_103 = "=null;" + NL + "                      }";
  protected final String TEXT_104 = NL + "        }" + NL + "    }" + NL + "    private ContextProperties context = new ContextProperties();" + NL + "    public ContextProperties getContext() {" + NL + "        return this.context;" + NL + "    }" + NL;
  protected final String TEXT_105 = NL + "    ";
  protected final String TEXT_106 = "    public static class TalendRuntimeSparkListener extends" + NL + "            org.apache.spark.ui.jobs.JobProgressListener {" + NL + "" + NL + "        private boolean hasStarted = false;" + NL + "        org.apache.spark.ui.jobs.UIData.JobUIData data;" + NL + "        private java.util.HashMap<String, String> components;" + NL + "        private java.util.List<String> alreadyComputedComponents;" + NL + "        private java.util.ArrayList<String> cacheNodes;" + NL + "        private int currentJobId = 0;" + NL + "        private String currentComponentConnectionId = \"\";" + NL + "        private String currentComponentName = \"\";" + NL + "        private long startTimestamp = 0L;" + NL + "        private long clientStartTimestamp = 0L;" + NL + "" + NL + "        public TalendRuntimeSparkListener(org.apache.spark.SparkConf conf) {" + NL + "            super(conf);" + NL + "            this.components = new java.util.HashMap<>();";
  protected final String TEXT_107 = NL + "                this.components.put(\"";
  protected final String TEXT_108 = "\", \"";
  protected final String TEXT_109 = "\");";
  protected final String TEXT_110 = NL + "            this.cacheNodes = new java.util.ArrayList<>();";
  protected final String TEXT_111 = NL + "                this.cacheNodes.add(\"";
  protected final String TEXT_112 = "\");";
  protected final String TEXT_113 = "                " + NL + "            this.alreadyComputedComponents = new java.util.ArrayList<>();" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public void onJobStart(" + NL + "                org.apache.spark.scheduler.SparkListenerJobStart jobStart) {" + NL + "            super.onJobStart(jobStart);" + NL + "" + NL + "            this.currentComponentConnectionId = removeAlreadyUsedConnections(this.components.get(currentComponent));" + NL + "            this.currentComponentName = currentComponent;" + NL + "            this.currentJobId = jobStart.jobId();" + NL + "            this.startTimestamp = jobStart.time();" + NL + "            this.clientStartTimestamp = System.currentTimeMillis();" + NL;
  protected final String TEXT_114 = NL + "                log.info(\"The Spark job with the id <\" + this.currentJobId + \"> has been launched.\");" + NL + "                log.debug(\"The Spark job with the id <\" + this.currentJobId + \"> will execute the transformations generated by this component: <\" + this.currentComponentName + \">.\");";
  protected final String TEXT_115 = NL;
  protected final String TEXT_116 = "                " + NL + "                StatBean sb = runStat.createSparkStatBean();" + NL + "                sb.setConnectionId(this.currentComponentConnectionId);" + NL + "                sb.setMode(0);" + NL + "                sb.setProgress(0.0f);" + NL + "                sb.setJobId(this.currentJobId);" + NL + "                runStat.updateSparkProgress(sb);";
  protected final String TEXT_117 = "                    " + NL + "" + NL + "            hasStarted = true;" + NL + "            java.util.Map<Object, org.apache.spark.ui.jobs.UIData.JobUIData> data = scala.collection.JavaConversions.asJavaMap(jobIdToData());" + NL + "            this.data = data.get(this.currentJobId);" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public void onJobEnd(" + NL + "                org.apache.spark.scheduler.SparkListenerJobEnd jobEnd) {" + NL + "            super.onJobEnd(jobEnd);" + NL;
  protected final String TEXT_118 = NL + "                log.info(String.format(\"The Spark job with the id <\" + this.currentJobId + \"> has been finished - Duration: %s.\", " + NL + "                    org.apache.commons.lang3.time.DurationFormatUtils.formatDurationHMS" + NL + "                        (jobEnd.time() - this.startTimestamp)" + NL + "                    ));" + NL + "                log.debug(\"The Spark job with the id <\" + this.currentJobId + \"> has executed the transformations generated by this component: <\" + this.currentComponentName + \">.\");";
  protected final String TEXT_119 = "                ";
  protected final String TEXT_120 = "                " + NL + "                StatBean sb = runStat.createSparkStatBean();" + NL + "                sb.setConnectionId(this.currentComponentConnectionId);" + NL + "                sb.setMode(2);" + NL + "                sb.setProgress(100.0f);" + NL + "                sb.setJobId(this.currentJobId);" + NL + "                runStat.updateSparkProgress(sb);";
  protected final String TEXT_121 = NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public void onExecutorMetricsUpdate(" + NL + "                org.apache.spark.scheduler.SparkListenerExecutorMetricsUpdate executorMetricsUpdate) {" + NL + "            super.onExecutorMetricsUpdate(executorMetricsUpdate);" + NL + "            if (hasStarted) {" + NL;
  protected final String TEXT_122 = NL + "                    log.info(String.format(\"The Spark job with the id <\" + this.currentJobId + \"> is still in progress... Elapsed time: %s.\", " + NL + "                        org.apache.commons.lang3.time.DurationFormatUtils.formatDurationHMS" + NL + "                        (System.currentTimeMillis() - this.clientStartTimestamp)" + NL + "                    ));" + NL + "                    log.trace(\"Spark job: <\" + this.currentJobId + \"> - Number of tasks: <\" + data" + NL + "                            .numTasks() + \"> - Number of completed tasks: <\" + data.numCompletedTasks() + \"> - Number of skipped tasks: <\" + data.numSkippedTasks() + \">.\");";
  protected final String TEXT_123 = "                  ";
  protected final String TEXT_124 = NL + "                    StatBean sb = runStat.createSparkStatBean();" + NL + "                    sb.setConnectionId(this.currentComponentConnectionId);" + NL + "                    sb.setMode(1);" + NL + "                    sb.setProgress(((float)data.numCompletedTasks()/((float) data" + NL + "                            .numTasks() - data.numSkippedTasks())) * 100);" + NL + "                    sb.setJobId(this.currentJobId);" + NL + "                    runStat.updateSparkProgress(sb);";
  protected final String TEXT_125 = NL + "            }" + NL + "        }" + NL + "" + NL + "        private String removeAlreadyUsedConnections(String connectionId) {" + NL + "            String localConnectionId = connectionId;" + NL + "            for(String component : alreadyComputedComponents) {" + NL + "                String alreadyComputedComponentConnectionId = this.components.get(component);" + NL + "                if(localConnectionId.contains(alreadyComputedComponentConnectionId)) {" + NL + "                    localConnectionId = localConnectionId.replace(alreadyComputedComponentConnectionId, \"\");" + NL + "                }" + NL + "            }" + NL + "" + NL + "            java.util.ArrayList<String> cacheNodesClone = (ArrayList<String>) this.cacheNodes.clone();" + NL + "            for(String cacheNode : cacheNodesClone) {" + NL + "                String cacheNodeConnectionId = this.components.get(cacheNode);" + NL + "                if(connectionId.contains(cacheNodeConnectionId)) {" + NL + "                    alreadyComputedComponents.add(0, cacheNode);" + NL + "                    this.cacheNodes.remove(cacheNode);" + NL + "                }" + NL + "            }" + NL + "            alreadyComputedComponents.add(0, currentComponent);" + NL + "            return localConnectionId;" + NL + "        }" + NL + "" + NL + "    }" + NL + "" + NL + "    private static SparkRunStat runStat = new SparkRunStat();" + NL + "" + NL + "    public static class TalendEndOfRunSparkListener extends org.apache.spark.JavaSparkListener {" + NL + "" + NL + "        public TalendEndOfRunSparkListener(String appName) {" + NL + "            //onApplicationStart is called only with spark-submit" + NL + "            this.appName = appName;" + NL + "            appStartTime = System.currentTimeMillis();" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public void onApplicationEnd(org.apache.spark.scheduler.SparkListenerApplicationEnd applicationEnd) {" + NL + "            long appDuration = applicationEnd.time() - appStartTime;" + NL + "            log.info(String.format(\"Application %s ended in %s\"," + NL + "                appName," + NL + "                org.apache.commons.lang3.time.DurationFormatUtils.formatDurationHMS" + NL + "                    (appDuration)" + NL + "                ));" + NL + "            log.info(\"Spark counters per job (\" + metricsPerJob.size() + \" jobs):\");" + NL + "            java.text.DecimalFormat df = new java.text.DecimalFormat(\"#.####\");" + NL + "" + NL + "            long totalJobDuration = 0;" + NL + "" + NL + "            for(EndOfRunMetrics metrics : metricsPerJob.values()) {" + NL + "                long jobDuration = metrics.duration();" + NL + "                totalJobDuration += jobDuration;" + NL + "                log.info(String.format(\"%s.job%d.duration=%s\"," + NL + "                    appName, metrics.jobId," + NL + "                    org.apache.commons.lang3.time.DurationFormatUtils.formatDurationHMS" + NL + "                        (jobDuration)" + NL + "                    ));" + NL + "                log.info(String.format(\"%s.job%d.recordsRead=%d\"," + NL + "                    appName, metrics.jobId, metrics.recordsRead" + NL + "                    ));" + NL + "                log.info(String.format(\"%s.job%d.shuffleRecordsRead=%d\"," + NL + "                    appName, metrics.jobId, metrics.shuffleRecordsRead" + NL + "                    ));" + NL + "                log.info(String.format(\"%s.job%d.shuffleRecordsWritten=%d\"," + NL + "                    appName, metrics.jobId, metrics.shuffleRecordsWritten" + NL + "                    ));" + NL + "                log.info(String.format(\"%s.job%d.recordsWritten=%d\"," + NL + "                    appName, metrics.jobId, metrics.recordsWritten" + NL + "                    ));" + NL + "                log.info(String.format(\"%s.job%d.bytesRead=%d\"," + NL + "                    appName, metrics.jobId, metrics.bytesRead" + NL + "                    ));" + NL + "                log.info(String.format(\"%s.job%d.shuffleBytesRead=%d\"," + NL + "                    appName, metrics.jobId, metrics.shuffleBytesRead" + NL + "                    ));" + NL + "                log.info(String.format(\"%s.job%d.shuffleBytesWritten=%d\"," + NL + "                    appName, metrics.jobId, metrics.shuffleBytesWritten" + NL + "                    ));" + NL + "                log.info(String.format(\"%s.job%d.bytesWritten=%d\"," + NL + "                    appName, metrics.jobId, metrics.bytesWritten" + NL + "                    ));" + NL + "                log.info(String.format(\"%s.job%d.diskBytesSpilled=%d\"," + NL + "                    appName, metrics.jobId, metrics.diskBytesSpilled" + NL + "                    ));" + NL + "                log.info(String.format(\"%s.job%d.memoryBytesSpilled=%d\"," + NL + "                    appName, metrics.jobId, metrics.memoryBytesSpilled" + NL + "                    ));" + NL + "                log.info(String.format(\"%s.job%d.shuffleTotalBlocksFetched=%d\"," + NL + "                    appName, metrics.jobId, metrics.shuffleTotalBlocksFetched" + NL + "                    ));" + NL + "                log.info(String.format(\"%s.job%d.jvmGcTime=%s\"," + NL + "                    appName, metrics.jobId, " + NL + "                    org.apache.commons.lang3.time.DurationFormatUtils.formatDurationHMS" + NL + "                        (metrics.jvmGCTime)" + NL + "                    ));" + NL + "                log.info(String.format(\"%s.job%d.pctTimeSpentInGC=%s\"," + NL + "                    appName, metrics.jobId, " + NL + "                    df.format(jobDuration > 0 ? metrics.jvmGCTime / new Double(jobDuration) : 0.)" + NL + "                    ));" + NL + "            }" + NL + "            log.info(\"Total Spark counters :\");" + NL + "            log.info(String.format(" + NL + "                \"%s.total.executors(min/max/avg)=%d/%d/%s\"," + NL + "                appName, minExecutors, maxExecutors, " + NL + "                df.format(countUpdates > 0 ? totalNbExecutors / new Double(countUpdates) : 0.)" + NL + "                ));" + NL + "" + NL + "            EndOfRunMetrics metrics = totalAggregation();" + NL + "            log.info(String.format(\"%s.total.recordsRead=%d\"," + NL + "                appName, metrics.recordsRead" + NL + "                ));" + NL + "            log.info(String.format(\"%s.total.shuffleRecordsRead=%d\"," + NL + "                appName, metrics.shuffleRecordsRead" + NL + "                ));" + NL + "            log.info(String.format(\"%s.total.shuffleRecordsWritten=%d\"," + NL + "                appName, metrics.shuffleRecordsWritten" + NL + "                ));" + NL + "            log.info(String.format(\"%s.total.recordsWritten=%d\"," + NL + "                appName, metrics.recordsWritten" + NL + "                ));" + NL + "            log.info(String.format(\"%s.total.bytesRead=%d\"," + NL + "                appName, metrics.bytesRead" + NL + "                ));" + NL + "            log.info(String.format(\"%s.total.shuffleBytesRead=%d\"," + NL + "                appName, metrics.shuffleBytesRead" + NL + "                ));" + NL + "            log.info(String.format(\"%s.total.shuffleBytesWritten=%d\"," + NL + "                appName, metrics.shuffleBytesWritten" + NL + "                ));" + NL + "            log.info(String.format(\"%s.total.bytesWritten=%d\"," + NL + "                appName, metrics.bytesWritten" + NL + "                ));" + NL + "            log.info(String.format(\"%s.total.diskBytesSpilled=%d\"," + NL + "                appName, metrics.diskBytesSpilled" + NL + "                ));" + NL + "            log.info(String.format(\"%s.total.memoryBytesSpilled=%d\"," + NL + "                appName, metrics.memoryBytesSpilled" + NL + "                ));" + NL + "            log.info(String.format(\"%s.total.shuffleTotalBlocksFetched=%d\"," + NL + "                appName, metrics.shuffleTotalBlocksFetched" + NL + "                ));" + NL + "            log.info(String.format(\"%s.total.jvmGcTime=%s\"," + NL + "                appName," + NL + "                org.apache.commons.lang3.time.DurationFormatUtils.formatDurationHMS" + NL + "                    (metrics.jvmGCTime)" + NL + "                ));" + NL + "            log.info(String.format(\"%s.total.pctTimeSpentInGC=%s\"," + NL + "                appName," + NL + "                df.format(totalJobDuration > 0 ? metrics.jvmGCTime / new Double(totalJobDuration) : 0.)" + NL + "                ));" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public void onJobStart(org.apache.spark.scheduler.SparkListenerJobStart jobStart) {" + NL + "            java.util.List<Object> ids = scala.collection.JavaConversions.asJavaList(jobStart.stageIds());" + NL + "            EndOfRunMetrics newJob = new EndOfRunMetrics(jobStart.jobId(), jobStart.time(), ids);" + NL + "            metricsPerJob.put(newJob.jobId, newJob);" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public void onJobEnd(org.apache.spark.scheduler.SparkListenerJobEnd jobEnd) {" + NL + "            EndOfRunMetrics oldJob = metricsPerJob.get(jobEnd.jobId());" + NL + "            if(oldJob != null) {" + NL + "                oldJob.endTime = jobEnd.time();" + NL + "            }" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public void onTaskEnd(org.apache.spark.scheduler.SparkListenerTaskEnd taskEnd) {" + NL + "            if(taskEnd.taskInfo() == null || !\"SUCCESS\".equals(taskEnd.taskInfo().status()))" + NL + "                return;" + NL + "            countUpdates++;" + NL + "            totalNbExecutors += currentExecutors;" + NL + "            Integer stageId = taskEnd.stageId();" + NL + "            for(EndOfRunMetrics jobMetrics : metricsPerJob.values()) {" + NL + "                if(jobMetrics.endTime != null)" + NL + "                    continue;" + NL + "                for(Object id : jobMetrics.stageIds) {" + NL + "                    if(!id.equals(stageId))" + NL + "                        continue;" + NL + "                    org.apache.spark.executor.TaskMetrics metrics = taskEnd.taskMetrics();" + NL + "" + NL + "                    if(metrics == null) {" + NL + "                        continue;" + NL + "                    }" + NL + "" + NL + "                    jobMetrics.diskBytesSpilled += metrics.diskBytesSpilled();" + NL + "                    jobMetrics.jvmGCTime += metrics.jvmGCTime();" + NL + "                    jobMetrics.memoryBytesSpilled += metrics.memoryBytesSpilled();" + NL + "" + NL + "                    if(metrics.inputMetrics().isDefined()) {" + NL + "                        org.apache.spark.executor.InputMetrics inputMetrics = metrics.inputMetrics().get();" + NL + "                        jobMetrics.bytesRead += inputMetrics.bytesRead();" + NL + "                        jobMetrics.recordsRead += inputMetrics.recordsRead();" + NL + "                    }" + NL + "" + NL + "                    if(metrics.outputMetrics().isDefined()) {" + NL + "                        org.apache.spark.executor.OutputMetrics outputMetrics = metrics.outputMetrics().get();" + NL + "                        jobMetrics.bytesWritten += outputMetrics.bytesWritten();" + NL + "                        jobMetrics.recordsWritten += outputMetrics.recordsWritten();" + NL + "                    }" + NL + "" + NL + "                    if(metrics.shuffleReadMetrics().isDefined()) {" + NL + "                        org.apache.spark.executor.ShuffleReadMetrics srMetrics = metrics.shuffleReadMetrics().get();" + NL + "                        jobMetrics.shuffleRecordsRead += srMetrics.recordsRead();" + NL + "                        jobMetrics.shuffleBytesRead += srMetrics.totalBytesRead();" + NL + "                        jobMetrics.shuffleTotalBlocksFetched += srMetrics.totalBlocksFetched();" + NL + "                    }" + NL + "" + NL + "                    if(metrics.shuffleWriteMetrics().isDefined()) {" + NL + "                        org.apache.spark.executor.ShuffleWriteMetrics swMetrics = metrics.shuffleWriteMetrics().get();" + NL + "                        jobMetrics.shuffleRecordsWritten += swMetrics.shuffleRecordsWritten();" + NL + "                        jobMetrics.shuffleBytesWritten += swMetrics.shuffleBytesWritten();" + NL + "                    }" + NL + "" + NL + "                    return;" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public void onExecutorAdded(org.apache.spark.scheduler.SparkListenerExecutorAdded executorAdded) {" + NL + "            currentExecutors++;" + NL + "            if(currentExecutors > maxExecutors)" + NL + "                maxExecutors = currentExecutors;" + NL + "        }" + NL + "" + NL + "        @Override" + NL + "        public void onExecutorRemoved(org.apache.spark.scheduler.SparkListenerExecutorRemoved executorRemoved) {" + NL + "            currentExecutors--;" + NL + "            if(currentExecutors < minExecutors)" + NL + "                minExecutors = currentExecutors;" + NL + "        }" + NL + "" + NL + "        private EndOfRunMetrics totalAggregation() {" + NL + "            EndOfRunMetrics total = new EndOfRunMetrics(0, 0, null);" + NL + "            for(EndOfRunMetrics jobMetrics : metricsPerJob.values()) {" + NL + "                total.diskBytesSpilled += jobMetrics.diskBytesSpilled;" + NL + "                total.jvmGCTime += jobMetrics.jvmGCTime;" + NL + "                total.memoryBytesSpilled += jobMetrics.memoryBytesSpilled;" + NL + "                total.bytesRead += jobMetrics.bytesRead;" + NL + "                total.recordsRead += jobMetrics.recordsRead;" + NL + "                total.bytesWritten += jobMetrics.bytesWritten;" + NL + "                total.recordsWritten += jobMetrics.recordsWritten;" + NL + "                total.shuffleRecordsRead += jobMetrics.shuffleRecordsRead;" + NL + "                total.shuffleBytesRead += jobMetrics.shuffleBytesRead;" + NL + "                total.shuffleTotalBlocksFetched += jobMetrics.shuffleTotalBlocksFetched;" + NL + "                total.shuffleRecordsWritten += jobMetrics.shuffleRecordsWritten;" + NL + "                total.shuffleBytesWritten += jobMetrics.shuffleBytesWritten;" + NL + "            }" + NL + "            return total;" + NL + "        }" + NL + "" + NL + "        private long appStartTime = 0;" + NL + "        private long minExecutors = 0;" + NL + "        private long maxExecutors = 0;" + NL + "        private long currentExecutors = 0;" + NL + "        private long totalNbExecutors = 0;" + NL + "        private long countUpdates = 0;" + NL + "        private String appName = null;" + NL + "" + NL + "        private java.util.Map<Integer, EndOfRunMetrics> metricsPerJob = new java.util.HashMap<>();" + NL + "" + NL + "    }" + NL + "" + NL + "    public static class EndOfRunMetrics {" + NL + "        public int nbTasks = 0;" + NL + "        public Integer jobId = null;" + NL + "        public java.util.List<Object> stageIds = null;" + NL + "        public Long startTime = null;" + NL + "        public Long endTime = null;" + NL + "        public Long diskBytesSpilled = 0L;" + NL + "        public Long jvmGCTime = 0L;" + NL + "        public Long memoryBytesSpilled = 0L;" + NL + "        public Long bytesRead = 0L;" + NL + "        public Long recordsRead = 0L;" + NL + "        public Long bytesWritten = 0L;" + NL + "        public Long recordsWritten = 0L;" + NL + "        public Long shuffleRecordsRead = 0L;" + NL + "        public Long shuffleBytesRead = 0L;" + NL + "        public Long shuffleTotalBlocksFetched = 0L;" + NL + "        public Long shuffleRecordsWritten = 0L;" + NL + "        public Long shuffleBytesWritten = 0L;" + NL + "" + NL + "        public EndOfRunMetrics(int jobId, long startTime, java.util.List<Object> stageIds) {" + NL + "            this.jobId = jobId;" + NL + "            this.startTime = startTime;" + NL + "            this.stageIds = stageIds;" + NL + "        }" + NL + "" + NL + "        public long duration() {" + NL + "            if(endTime != null && startTime != null)" + NL + "                return endTime - startTime;" + NL + "            return 0;" + NL + "        }" + NL + "" + NL + "    }";
  protected final String TEXT_126 = NL + NL + "    private final static String jobVersion = \"";
  protected final String TEXT_127 = "\";" + NL + "    private final static String jobName = \"";
  protected final String TEXT_128 = "\";" + NL + "    private final static String projectName = \"";
  protected final String TEXT_129 = "\";" + NL + "    public Integer errorCode = null;" + NL + "" + NL + "    private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();" + NL + "    private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(" + NL + "            new java.io.BufferedOutputStream(baos));" + NL + "" + NL + "    private static String currentComponent = \"\";" + NL + "" + NL + "    public String getExceptionStackTrace() {" + NL + "        if (\"failure\".equals(this.getStatus())) {" + NL + "            errorMessagePS.flush();" + NL + "            return baos.toString();" + NL + "        }" + NL + "        return null;" + NL + "    }" + NL + "" + NL + "    //should be remove later" + NL + "    public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {" + NL + "" + NL + "    }" + NL;
  protected final String TEXT_130 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    Vector v = (Vector) codeGenArgument.getArgument();
    IProcess process = (IProcess)v.get(0);
    String version = (String)v.get(1);
    java.util.Map<Integer, String> jobs = (java.util.Map<Integer, String>)v.get(2);
    java.util.List<String> cacheNodes = (java.util.List<String>)v.get(3);
    INode sparkConfig = (INode)v.get(4);
    String sparkMode = ElementParameterParser.getValue(sparkConfig, "__SPARK_MODE__");
    boolean useLocalMode = "LOCAL".equals(sparkMode);

    boolean stats = codeGenArgument.isStatistics();
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));

    List< ? extends INode> processNodes = (List< ? extends INode>)process.getGeneratingNodes();
    List<IContextParameter> params = new ArrayList<IContextParameter>();
    params=process.getContextManager().getDefaultContext().getContextParameterList();

    
//?
IBrandingService service=(IBrandingService)GlobalServiceRegister.getDefault().getService(IBrandingService.class);
if(service instanceof AbstractBrandingService){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(((AbstractBrandingService) service).getJobLicenseHeader(version));
    
}
    String jobFolderName = JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
    String packageName = codeGenArgument.getCurrentProjectName().toLowerCase() + "." + jobFolderName;

    stringBuffer.append(TEXT_2);
    stringBuffer.append( packageName );
    stringBuffer.append(TEXT_3);
    for (String routine : CodeGeneratorRoutine.getRequiredRoutineName(process)) {
    if(!routine.equals(ITalendSynchronizer.TEMPLATE)){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(routine);
    stringBuffer.append(TEXT_5);
      }
}
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getValue(process, "__HEADER_IMPORT__") );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ElementParameterParser.getValue(process, "__FOOTER_IMPORT__") );
    stringBuffer.append(TEXT_9);
    
    List<INode> nodesWithImport = process.getNodesWithImport();
    if(nodesWithImport != null) {
        for(INode node:nodesWithImport){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getValue(node, "__IMPORT__") );
    stringBuffer.append(TEXT_12);
          }
    }

    stringBuffer.append(TEXT_13);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getValue(process, "__PURPOSE__") );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ElementParameterParser.getValue(process, "__DESCRIPTION__") );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ElementParameterParser.getValue(process, "__AUTHOR__") );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(version );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(ElementParameterParser.getValue(process, "__STATUS__") );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(codeGenArgument.getCurrentProjectName().toLowerCase());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(jobFolderName);
    stringBuffer.append(TEXT_25);
    
            for(IContextParameter ctxParam : params){
                String cParaName = ctxParam.getName();
                
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_27);
    if(ctxParam.getType().equals("id_Date")){
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(ctxParam.getValue() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_43);
    }else{
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    
            }
            
    stringBuffer.append(TEXT_48);
    
        for(IContextParameter ctxParam : params){
            if(ctxParam.getType().equals("id_List Of Value") || ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory")){
            
    stringBuffer.append(TEXT_49);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(Character.toUpperCase(ctxParam.getName().charAt(0)) + ctxParam.getName().substring(1));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_52);
    
            }else{
            
    stringBuffer.append(TEXT_53);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(Character.toUpperCase(ctxParam.getName().charAt(0)) + ctxParam.getName().substring(1));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_58);
    
            }
        }
        
    stringBuffer.append(TEXT_59);
    
            for(IContextParameter ctxParam : params){
                if (ctxParam.getType().equals("id_Password")) {
                
    stringBuffer.append(TEXT_60);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_72);
    
                    continue;
                }
                String typeToGenerate ="String";
                if( !(ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory") ||ctxParam.getType().equals("id_List Of Value"))){
                   typeToGenerate=JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true);
                }
                if(typeToGenerate.equals("java.util.Date")){
                
    stringBuffer.append(TEXT_73);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_91);
    
                }else if(typeToGenerate.equals("Object")||typeToGenerate.equals("String")||typeToGenerate.equals("java.lang.String")){
                
    stringBuffer.append(TEXT_92);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_95);
    
                }else if(typeToGenerate.equals("Character")&&ctxParam.getName()!=null){
                 
    stringBuffer.append(TEXT_96);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_98);
    
                }else{
                 
    stringBuffer.append(TEXT_99);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_103);
    
                }
            }
            
    stringBuffer.append(TEXT_104);
    
    if(stats || isLog4jEnabled) {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(TEXT_106);
    
            for(java.util.Map.Entry e : jobs.entrySet()) {

    stringBuffer.append(TEXT_107);
    stringBuffer.append(e.getKey());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(e.getValue());
    stringBuffer.append(TEXT_109);
    
            }

    stringBuffer.append(TEXT_110);
    
            for(String cacheNode : cacheNodes) {

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cacheNode);
    stringBuffer.append(TEXT_112);
    
            }

    stringBuffer.append(TEXT_113);
     if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_114);
     } 
    stringBuffer.append(TEXT_115);
    
            if(stats) {

    stringBuffer.append(TEXT_116);
    
            }

    stringBuffer.append(TEXT_117);
     if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_118);
     } 
    stringBuffer.append(TEXT_119);
    
            if(stats) {

    stringBuffer.append(TEXT_120);
    
            }

    stringBuffer.append(TEXT_121);
     if(isLog4jEnabled) { 
    stringBuffer.append(TEXT_122);
     } 
    stringBuffer.append(TEXT_123);
    
                if(stats) {

    stringBuffer.append(TEXT_124);
    
                }

    stringBuffer.append(TEXT_125);
    
    }

    stringBuffer.append(TEXT_126);
    stringBuffer.append(process.getVersion() );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(TEXT_130);
    return stringBuffer.toString();
  }
}
