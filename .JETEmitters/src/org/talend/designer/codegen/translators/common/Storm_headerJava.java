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

public class Storm_headerJava
{
  protected static String nl;
  public static synchronized Storm_headerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Storm_headerJava result = new Storm_headerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "package ";
  protected final String TEXT_3 = ";" + NL + "" + NL + "import routines.system.*;" + NL + "import routines.system.api.*;";
  protected final String TEXT_4 = NL + "import routines.";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL + NL + NL + "import java.io.IOException;" + NL + "import java.io.Serializable;" + NL + "import java.util.ArrayList;" + NL + "import java.util.List;" + NL + "import java.util.Map;" + NL + "import java.math.BigDecimal;" + NL + "" + NL + "import org.apache.commons.lang.SerializationUtils;" + NL + "import org.apache.commons.codec.binary.Base64;" + NL + "import org.apache.commons.codec.binary.StringUtils;" + NL + "import org.json.simple.JSONValue;" + NL + "" + NL + "import storm.trident.Stream;" + NL + "import storm.trident.TridentState;" + NL + "import storm.trident.TridentTopology;" + NL + "import storm.trident.operation.BaseFunction;" + NL + "import storm.trident.operation.TridentCollector;" + NL + "import storm.trident.operation.TridentOperationContext;" + NL + "import storm.trident.testing.MemoryMapState;" + NL + "import storm.trident.tuple.TridentTuple;" + NL + "import backtype.storm.Config;" + NL + "import backtype.storm.ILocalDRPC;" + NL + "import backtype.storm.StormSubmitter;" + NL + "import backtype.storm.generated.AlreadyAliveException;" + NL + "import backtype.storm.generated.KillOptions;" + NL + "import backtype.storm.generated.NotAliveException;" + NL + "import backtype.storm.tuple.Fields;" + NL + "import backtype.storm.tuple.Values;" + NL + "import backtype.storm.utils.DRPCClient;" + NL + "import backtype.storm.utils.NimbusClient;" + NL + "import backtype.storm.utils.Utils;" + NL + "import org.apache.thrift7.TException;" + NL + "import org.talend.libs.tbd.ee.libstorm.LocalStormJobRunHelper;" + NL + "import org.talend.libs.tbd.ee.libstorm.ClusterStormJobRunHelper;" + NL + "import org.talend.libs.tbd.ee.libstorm.StormTopologyInitializer;" + NL + "import org.talend.libs.tbd.ee.libstorm.StormTopologyMonitor;" + NL + "import org.talend.libs.tbd.ee.libstorm.StormTopologyContext;" + NL;
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
  protected final String TEXT_20 = " implements TalendJob {" + NL + "" + NL + "    private final static String utf8Charset = \"UTF-8\";" + NL + "    private GlobalVar globalMap = null;" + NL;
  protected final String TEXT_21 = NL + "    private static class GlobalVar{" + NL + "        public static final String GLOBALVAR_PARAMS_PREFIX = \"talend.globalvar.params.\";" + NL + "        private Config job;" + NL + "        private java.util.Map<String, Object> map;" + NL + "" + NL + "        public GlobalVar(Config job){" + NL + "            this.job = job;" + NL + "            this.map = new java.util.HashMap<String, Object>();" + NL + "        }" + NL + "" + NL + "        public Object get(String key){" + NL + "            String tempValue = (String) job.get(GLOBALVAR_PARAMS_PREFIX + key);" + NL + "            if(tempValue != null){" + NL + "                return SerializationUtils.deserialize(Base64.decodeBase64(StringUtils.getBytesUtf8(tempValue)));" + NL + "            }else{" + NL + "                return null;" + NL + "            }" + NL + "        }" + NL + "" + NL + "        public void put(String key, Object value){" + NL + "            if(value == null)" + NL + "                return;" + NL + "            job.put(GLOBALVAR_PARAMS_PREFIX + key, StringUtils.newStringUtf8(Base64.encodeBase64(SerializationUtils.serialize((Serializable)value))));" + NL + "        }" + NL + "" + NL + "        public void putLocal(String key, Object value){" + NL + "            map.put(key, value);" + NL + "        }" + NL + "" + NL + "        public Object getLocal(String key){" + NL + "            return map.get(key);" + NL + "        }" + NL + "    }" + NL + "" + NL + "    // create and load default properties" + NL + "    private java.util.Properties defaultProps = new java.util.Properties();" + NL + "    // create application properties with default" + NL + "    public static class ContextProperties extends java.util.Properties {" + NL + "" + NL + "        private static final long serialVersionUID = 1L;" + NL + "" + NL + "        public static final String CONTEXT_FILE_NAME = \"talend.context.fileName\";" + NL + "        public static final String CONTEXT_KEYS = \"talend.context.keys\";" + NL + "        public static final String CONTEXT_PARAMS_PREFIX = \"talend.context.params.\";" + NL + "        public static final String CONTEXT_PARENT_KEYS = \"talend.context.parent.keys\";" + NL + "        public static final String CONTEXT_PARENT_PARAMS_PREFIX = \"talend.context.parent.params.\";" + NL + "" + NL + "        public ContextProperties(java.util.Properties properties){" + NL + "            super(properties);" + NL + "        }" + NL + "        public ContextProperties(){" + NL + "            super();" + NL + "        }" + NL + "        public ContextProperties(Map job){" + NL + "            super();" + NL + "            String contextFileName = (String) job.get(CONTEXT_FILE_NAME);" + NL + "            try {" + NL + "                if(contextFileName != null && !\"\".equals(contextFileName)){" + NL + "                    java.io.File contextFile = new java.io.File(contextFileName);" + NL + "                    if (contextFile.exists()) {" + NL + "                        java.io.InputStream contextIn = contextFile.toURI().toURL().openStream();" + NL + "                        this.load(contextIn);" + NL + "                        contextIn.close();" + NL + "                    } else {" + NL + "                        java.io.InputStream contextIn = ";
  protected final String TEXT_22 = ".class.getClassLoader().getResourceAsStream(\"";
  protected final String TEXT_23 = "/";
  protected final String TEXT_24 = "/contexts/\"+contextFileName);" + NL + "                        if(contextIn != null){" + NL + "                            this.load(contextIn);" + NL + "                            contextIn.close();" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "                Object contextKeys = job.get(CONTEXT_KEYS);" + NL + "                if (contextKeys != null) {" + NL + "                    java.util.StringTokenizer st = new java.util.StringTokenizer(contextKeys.toString(), \" \");" + NL + "                    while (st.hasMoreTokens()) {" + NL + "                        String contextKey = st.nextToken();" + NL + "                        if((String) job.get(CONTEXT_PARAMS_PREFIX + contextKey) != null){" + NL + "                            this.put(contextKey, job.get(CONTEXT_PARAMS_PREFIX + contextKey));" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "                Object contextParentKeys = job.get(CONTEXT_PARENT_KEYS);" + NL + "                if (contextParentKeys != null) {" + NL + "                    java.util.StringTokenizer st = new java.util.StringTokenizer(contextParentKeys.toString(), \" \");" + NL + "                    while (st.hasMoreTokens()) {" + NL + "                        String contextKey = st.nextToken();" + NL + "                        if((String)job.get(CONTEXT_PARENT_PARAMS_PREFIX + contextKey) != null){" + NL + "                            this.put(contextKey, job.get(CONTEXT_PARENT_PARAMS_PREFIX + contextKey));" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                this.loadValue(null,job);" + NL + "            } catch (java.io.IOException ie) {" + NL + "                System.err.println(\"Could not load context \" + contextFileName);" + NL + "                ie.printStackTrace();" + NL + "            }" + NL + "        }" + NL + "" + NL + "        public void synchronizeContext(){";
  protected final String TEXT_25 = NL + "                if(";
  protected final String TEXT_26 = " != null){";
  protected final String TEXT_27 = NL + "                        String pattern_";
  protected final String TEXT_28 = " = \"yyyy-MM-dd HH:mm:ss\";" + NL + "                        String value_";
  protected final String TEXT_29 = " = \"";
  protected final String TEXT_30 = "\";" + NL + "                        String[] parts_";
  protected final String TEXT_31 = " = value_";
  protected final String TEXT_32 = ".split(\";\");" + NL + "                        if(parts_";
  protected final String TEXT_33 = ".length > 1){" + NL + "                            pattern_";
  protected final String TEXT_34 = " = parts_";
  protected final String TEXT_35 = "[0];" + NL + "                            this.setProperty(\"";
  protected final String TEXT_36 = "\", pattern_";
  protected final String TEXT_37 = " + \";\" + FormatterUtils.format_DateInUTC(";
  protected final String TEXT_38 = ", pattern_";
  protected final String TEXT_39 = "));" + NL + "                        }else{" + NL + "                            this.setProperty(\"";
  protected final String TEXT_40 = "\", FormatterUtils.format_DateInUTC(";
  protected final String TEXT_41 = ", pattern_";
  protected final String TEXT_42 = "));" + NL + "                        }";
  protected final String TEXT_43 = NL + "                        this.setProperty(\"";
  protected final String TEXT_44 = "\", ";
  protected final String TEXT_45 = ".toString());";
  protected final String TEXT_46 = NL + "                }";
  protected final String TEXT_47 = NL + "        }" + NL;
  protected final String TEXT_48 = NL + "                public String ";
  protected final String TEXT_49 = ";" + NL + "                public String get";
  protected final String TEXT_50 = "(){" + NL + "                    return this.";
  protected final String TEXT_51 = ";" + NL + "                }";
  protected final String TEXT_52 = NL + "                public ";
  protected final String TEXT_53 = " ";
  protected final String TEXT_54 = ";" + NL + "                public ";
  protected final String TEXT_55 = " get";
  protected final String TEXT_56 = "(){" + NL + "                    return this.";
  protected final String TEXT_57 = ";" + NL + "                }";
  protected final String TEXT_58 = NL + "        public void loadValue(java.util.Properties context_param, Map job){";
  protected final String TEXT_59 = NL + "                    String pwd_";
  protected final String TEXT_60 = "_value = this.getProperty(\"";
  protected final String TEXT_61 = "\");" + NL + "                    this.";
  protected final String TEXT_62 = " = null;" + NL + "                    if(pwd_";
  protected final String TEXT_63 = "_value!=null) {" + NL + "                        //no need to decrypt if it come from program argument or parent job runtime" + NL + "                        if((context_param!=null && context_param.containsKey(\"";
  protected final String TEXT_64 = "\"))" + NL + "                         || (job!=null && job.get(CONTEXT_PARAMS_PREFIX + \"";
  protected final String TEXT_65 = "\") != null)" + NL + "                         || (job!=null && job.get(CONTEXT_PARENT_PARAMS_PREFIX + \"";
  protected final String TEXT_66 = "\") != null)){" + NL + "                            this.";
  protected final String TEXT_67 = " = pwd_";
  protected final String TEXT_68 = "_value;" + NL + "                        } else if (!pwd_";
  protected final String TEXT_69 = "_value.isEmpty()) {" + NL + "                            try {" + NL + "                                this.";
  protected final String TEXT_70 = " = routines.system.PasswordEncryptUtil.decryptPassword(pwd_";
  protected final String TEXT_71 = "_value);" + NL + "                            } catch (java.lang.RuntimeException e) {" + NL + "                                //do nothing" + NL + "                            }" + NL + "                        }" + NL + "                    }";
  protected final String TEXT_72 = NL + "                    try{" + NL + "                        String context_";
  protected final String TEXT_73 = "_value = this.getProperty(\"";
  protected final String TEXT_74 = "\");" + NL + "                        if (context_";
  protected final String TEXT_75 = "_value == null){" + NL + "                            context_";
  protected final String TEXT_76 = "_value = \"\";" + NL + "                        }" + NL + "                        int context_";
  protected final String TEXT_77 = "_pos = context_";
  protected final String TEXT_78 = "_value.indexOf(\";\");" + NL + "                        String context_";
  protected final String TEXT_79 = "_pattern =  \"yyyy-MM-dd HH:mm:ss\";" + NL + "                        if(context_";
  protected final String TEXT_80 = "_pos > -1){" + NL + "                            context_";
  protected final String TEXT_81 = "_pattern = context_";
  protected final String TEXT_82 = "_value.substring(0, context_";
  protected final String TEXT_83 = "_pos);" + NL + "                            context_";
  protected final String TEXT_84 = "_value = context_";
  protected final String TEXT_85 = "_value.substring(context_";
  protected final String TEXT_86 = "_pos + 1);" + NL + "                        }" + NL + "" + NL + "                        this.";
  protected final String TEXT_87 = "=(java.util.Date)(new java.text.SimpleDateFormat(context_";
  protected final String TEXT_88 = "_pattern).parse(context_";
  protected final String TEXT_89 = "_value));" + NL + "" + NL + "                    }catch(ParseException e){" + NL + "                        this.";
  protected final String TEXT_90 = "=null;" + NL + "                    }";
  protected final String TEXT_91 = NL + "                    this.";
  protected final String TEXT_92 = "=(";
  protected final String TEXT_93 = ") this.getProperty(\"";
  protected final String TEXT_94 = "\");";
  protected final String TEXT_95 = NL + "                     this.";
  protected final String TEXT_96 = "= new java.text.StringCharacterIterator(this.getProperty(\"";
  protected final String TEXT_97 = "\")).first();";
  protected final String TEXT_98 = NL + "                     try{" + NL + "                         this.";
  protected final String TEXT_99 = "=routines.system.ParserUtils.parseTo_";
  protected final String TEXT_100 = "(this.getProperty(\"";
  protected final String TEXT_101 = "\"));" + NL + "                     }catch(NumberFormatException e){" + NL + "                         this.";
  protected final String TEXT_102 = "=null;" + NL + "                      }";
  protected final String TEXT_103 = NL + "        }" + NL + "    }" + NL + "    private ContextProperties context = new ContextProperties();" + NL + "    public ContextProperties getContext() {" + NL + "        return this.context;" + NL + "    }" + NL + "" + NL + "    private final static String jobVersion = \"";
  protected final String TEXT_104 = "\";" + NL + "    private final static String jobName = \"";
  protected final String TEXT_105 = "\";" + NL + "    private final static String projectName = \"";
  protected final String TEXT_106 = "\";" + NL + "    public Integer errorCode = null;" + NL + "" + NL + "    private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();" + NL + "    private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(" + NL + "            new java.io.BufferedOutputStream(baos));" + NL + "" + NL + "    public String getExceptionStackTrace() {" + NL + "        if (\"failure\".equals(this.getStatus())) {" + NL + "            errorMessagePS.flush();" + NL + "            return baos.toString();" + NL + "        }" + NL + "        return null;" + NL + "    }" + NL + "" + NL + "    //should be remove later" + NL + "    public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {" + NL + "" + NL + "    }" + NL;
  protected final String TEXT_107 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    Vector v = (Vector) codeGenArgument.getArgument();
    IProcess process = (IProcess)v.get(0);
    String version = (String)v.get(1);

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
     // TODO: Storm uses Kyro configuration for its config, so String
    // encoding is unnecessary (but then Java or custom serializers
    // need to be implemented.)
    
    stringBuffer.append(TEXT_21);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(codeGenArgument.getCurrentProjectName().toLowerCase());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(jobFolderName);
    stringBuffer.append(TEXT_24);
    
            for(IContextParameter ctxParam : params){
                String cParaName = ctxParam.getName();
                
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_26);
    if(ctxParam.getType().equals("id_Date")){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(ctxParam.getValue() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cParaName );
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
    }else{
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    
            }
            
    stringBuffer.append(TEXT_47);
    
        for(IContextParameter ctxParam : params){
            if(ctxParam.getType().equals("id_List Of Value") || ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory")){
            
    stringBuffer.append(TEXT_48);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(Character.toUpperCase(ctxParam.getName().charAt(0)) + ctxParam.getName().substring(1));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_51);
    
            }else{
            
    stringBuffer.append(TEXT_52);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(Character.toUpperCase(ctxParam.getName().charAt(0)) + ctxParam.getName().substring(1));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_57);
    
            }
        }
        
    stringBuffer.append(TEXT_58);
    
            for(IContextParameter ctxParam : params){
                if (ctxParam.getType().equals("id_Password")) {
                
    stringBuffer.append(TEXT_59);
    stringBuffer.append(ctxParam.getName());
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
    
                    continue;
                }
                String typeToGenerate ="String";
                if( !(ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory") ||ctxParam.getType().equals("id_List Of Value"))){
                   typeToGenerate=JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true);
                }
                if(typeToGenerate.equals("java.util.Date")){
                
    stringBuffer.append(TEXT_72);
    stringBuffer.append(ctxParam.getName());
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
    
                }else if(typeToGenerate.equals("Object")||typeToGenerate.equals("String")||typeToGenerate.equals("java.lang.String")){
                
    stringBuffer.append(TEXT_91);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_94);
    
                }else if(typeToGenerate.equals("Character")&&ctxParam.getName()!=null){
                 
    stringBuffer.append(TEXT_95);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_97);
    
                }else{
                 
    stringBuffer.append(TEXT_98);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_102);
    
                }
            }
            
    stringBuffer.append(TEXT_103);
    stringBuffer.append(process.getVersion() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(TEXT_107);
    return stringBuffer.toString();
  }
}
