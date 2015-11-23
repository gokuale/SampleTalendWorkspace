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

public class Storm_footerJava
{
  protected static String nl;
  public static synchronized Storm_footerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Storm_footerJava result = new Storm_footerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "    //private MRRunStat runStat = new MRRunStat();" + NL + "    // portStats is null, it means don't execute the statistics" + NL + "    public Integer portStats = null;" + NL + "    public String clientHost;" + NL + "    public String defaultClientHost = \"localhost\";" + NL + "    private boolean execStat = true;" + NL + "" + NL + "    private String topologyName = ";
  protected final String TEXT_3 = ";" + NL + "" + NL + "    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();" + NL + "" + NL + "    public String status= \"\";" + NL + "" + NL + "    private StormTopologyInitializer topologyInitializer = new StormTopologyInitializer() {" + NL + "        public void initialize(StormTopologyContext ctx) throws IOException {";
  protected final String TEXT_4 = NL + "            ";
  protected final String TEXT_5 = "Topology(ctx);";
  protected final String TEXT_6 = NL + "        }" + NL + "    };" + NL + "" + NL + "    public static void main(String[] args){" + NL + "        System.exit(new ";
  protected final String TEXT_7 = "().runJobInTOS(args));" + NL + "    }" + NL + "" + NL + "    public String[][] runJob(String[] args){" + NL + "        int exitCode = runJobInTOS(args);" + NL + "        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };" + NL + "        return bufferValue;" + NL + "    }" + NL + "" + NL + "    public int runJobInTOS (String[] args) {";
  protected final String TEXT_8 = NL + "            try {" + NL + "" + NL + "                // Configure the Storm topology that should be launched.";
  protected final String TEXT_9 = NL + "                    LocalStormJobRunHelper helper = new LocalStormJobRunHelper();";
  protected final String TEXT_10 = NL + "                    ClusterStormJobRunHelper helper = new ClusterStormJobRunHelper();";
  protected final String TEXT_11 = NL + NL + "                // These members are configured according to the job, but can be" + NL + "                // overridden by command line arguments." + NL + "                helper.setContextName(\"";
  protected final String TEXT_12 = "\");" + NL + "                helper.setTopologyName(";
  protected final String TEXT_13 = ");" + NL + "                helper.setDoKillAlreadyExisting(";
  protected final String TEXT_14 = ");" + NL + "                helper.setDoSubmit(";
  protected final String TEXT_15 = ");" + NL + "                helper.setDoMonitor(";
  protected final String TEXT_16 = ");" + NL + "                helper.setDoKillOnExit(";
  protected final String TEXT_17 = ");" + NL + "                helper.setMonitorTimeout(";
  protected final String TEXT_18 = ");" + NL + "" + NL + "                // Parse all of the command line arguments." + NL + "                helper.evalArguments(args);" + NL + "" + NL + "                // Set up the contexts from the resource files and command line" + NL + "                // arguments." + NL + "                initContext(helper.getContextName(), helper.isDefaultContext(), helper.getOverrideProperties());" + NL + "                copyContextIntoStormConfig(helper.getContextName(), helper.isDefaultContext(), helper.getOverrideProperties()," + NL + "                    helper.getStormConfig());" + NL;
  protected final String TEXT_19 = NL + "                    helper.setNimbusHost(";
  protected final String TEXT_20 = ");" + NL + "                    helper.setNimbusThriftPort(Integer.valueOf(";
  protected final String TEXT_21 = "));" + NL + "                    helper.setDrpcServer(";
  protected final String TEXT_22 = ");" + NL + "                    helper.setDrpcPort(Integer.valueOf(";
  protected final String TEXT_23 = "));" + NL + "                    helper.setJarToSubmit(\"";
  protected final String TEXT_24 = ".jar\");";
  protected final String TEXT_25 = NL + NL + "                helper.setTopologyInitializer(topologyInitializer);" + NL + "                helper.setTopologyMonitor(topologyMonitor);" + NL + "" + NL + "                if (helper.getDoInspect())" + NL + "                    helper.inspect(System.out);" + NL;
  protected final String TEXT_26 = NL + "                        helper.getStormConfig().put(" + NL + "                                String.valueOf(";
  protected final String TEXT_27 = "),";
  protected final String TEXT_28 = NL + "                                ";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + NL + "                return helper.runStorm();" + NL + "            } catch(Exception ex) {" + NL + "                ex.printStackTrace();" + NL + "                return 1;" + NL + "            }";
  protected final String TEXT_31 = NL + "    }" + NL + "" + NL + "    private void initContext(String contextStr, boolean isDefaultContext, java.util.Properties overrideProperties){" + NL + "        // get context" + NL + "        try{" + NL + "            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead." + NL + "            java.io.InputStream inContext = ";
  protected final String TEXT_32 = ".class.getClassLoader().getResourceAsStream(\"";
  protected final String TEXT_33 = "/";
  protected final String TEXT_34 = "/contexts/\"+contextStr+\".properties\");" + NL + "            if(isDefaultContext && inContext == null){" + NL + "" + NL + "            }else{" + NL + "                if (inContext!=null){" + NL + "                    //defaultProps is in order to keep the original context value" + NL + "                    defaultProps.load(inContext);" + NL + "                    inContext.close();" + NL + "                    context = new ContextProperties(defaultProps);" + NL + "                }else{" + NL + "                    //print info and job continue to run, for case: overrideProperties is not empty." + NL + "                    System.err.println(\"Could not find the context \" + contextStr);" + NL + "                }" + NL + "            }" + NL + "" + NL + "            if(!overrideProperties.isEmpty()){" + NL + "                context.putAll(overrideProperties);" + NL + "            }" + NL + "            context.loadValue(overrideProperties, null);" + NL + "            if(parentContextMap != null && !parentContextMap.isEmpty()){";
  protected final String TEXT_35 = NL + "                    if(parentContextMap.containsKey(\"";
  protected final String TEXT_36 = "\")){" + NL + "                        context.";
  protected final String TEXT_37 = " = (";
  protected final String TEXT_38 = ") parentContextMap.get(\"";
  protected final String TEXT_39 = "\");" + NL + "                    }";
  protected final String TEXT_40 = NL + "            }" + NL + "        }catch (java.io.IOException ie){" + NL + "            System.err.println(\"Could not load context \"+contextStr);" + NL + "            ie.printStackTrace();" + NL + "        }" + NL + "    }" + NL + "" + NL + "    private void copyContextIntoStormConfig(String contextStr, boolean isDefaultContext," + NL + "            java.util.Properties overrideProperties, Config conf){" + NL + "        //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead." + NL + "        java.net.URL inContextUrl = ";
  protected final String TEXT_41 = ".class.getClassLoader().getResource(\"";
  protected final String TEXT_42 = "/";
  protected final String TEXT_43 = "/contexts/\"+contextStr+\".properties\");" + NL + "        if (isDefaultContext && inContextUrl == null){" + NL + "" + NL + "        } else {" + NL + "            if (inContextUrl != null){" + NL + "                conf.put(ContextProperties.CONTEXT_FILE_NAME, contextStr + \".properties\");" + NL + "            }" + NL + "        }" + NL + "" + NL + "        if (!overrideProperties.isEmpty()) {" + NL + "            String contextKeys = \"\";" + NL + "            for (Object contextKey : overrideProperties.keySet()) {" + NL + "                conf.put(ContextProperties.CONTEXT_PARAMS_PREFIX + contextKey, context.getProperty(contextKey.toString()));" + NL + "                contextKeys += \" \" + contextKey;" + NL + "            }" + NL + "            conf.put(ContextProperties.CONTEXT_KEYS, contextKeys);" + NL + "        }" + NL + "" + NL + "        if(parentContextMap != null && !parentContextMap.isEmpty()){";
  protected final String TEXT_44 = NL + "                if(parentContextMap.containsKey(\"";
  protected final String TEXT_45 = "\")){" + NL + "                    conf.put(ContextProperties.CONTEXT_PARENT_PARAMS_PREFIX + \"";
  protected final String TEXT_46 = "\", parentContextMap.get(\"";
  protected final String TEXT_47 = "\").toString());" + NL + "                    Object currentKey = conf.get(ContextProperties.CONTEXT_KEYS);" + NL + "                    conf.put(ContextProperties.CONTEXT_PARENT_KEYS," + NL + "                            (currentKey == null ? \"\" : currentKey + \" \")" + NL + "                            + \"";
  protected final String TEXT_48 = "\");" + NL + "                }";
  protected final String TEXT_49 = NL + "        }" + NL + "    }" + NL + "" + NL + "    public Integer getErrorCode() {" + NL + "        return errorCode;" + NL + "    }" + NL + "" + NL + "    public String getStatus() {" + NL + "        return status;" + NL + "    }" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
/*
    This template performs other top-level initialization of the main job
    class, and terminates its scope.

    TODO:
    * Non-infinite while loop.
    * Passing in DRPC ports for different service calls.
    * Statistics, etc.
 */

CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
Vector v = (Vector) codeGenArgument.getArgument();
IProcess process = (IProcess)v.get(0);
List<INode> rootNodes = (List<INode>)v.get(1);
INode stormConfig = (INode)v.get(2);

List<IContextParameter> params = new ArrayList<IContextParameter>();
params = process.getContextManager().getDefaultContext().getContextParameterList();

String jobFolderName = JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
String nimbusHost = ElementParameterParser.getValue(stormConfig, "__NIMBUSHOST__");
String nimbusThriftPort = ElementParameterParser.getValue(stormConfig, "__NIMBUSPORT__");
String drpcServer = ElementParameterParser.getValue(stormConfig, "__DRPCHOST__");
String drpcPort = ElementParameterParser.getValue(stormConfig, "__DRPCPORT__");
Boolean localMode = "true".equals(ElementParameterParser.getValue(stormConfig, "__LOCALMODE__"));
String topologyName = ElementParameterParser.getValue(stormConfig, "__STORM_TOPOLOGY_NAME__");
Boolean killAlreadyExisting = "true".equals(ElementParameterParser.getValue(stormConfig, "__STORM_TOPOLOGY_KILL_EXISTING__"));
Boolean submit = "true".equals(ElementParameterParser.getValue(stormConfig, "__STORM_TOPOLOGY_SUBMIT__"));
Boolean monitor = "true".equals(ElementParameterParser.getValue(stormConfig, "__STORM_TOPOLOGY_MONITOR__"));
Boolean killOnExit = "true".equals(ElementParameterParser.getValue(stormConfig, "__STORM_TOPOLOGY_KILL_ON_EXIT__"));
Integer killMonitorAfterTimeout = Integer.parseInt(ElementParameterParser.getValue(stormConfig, "__STORM_TOPOLOGY_MONITOR_TIMEOUT__"));

String ctxProperties = codeGenArgument.getCurrentProjectName().toLowerCase()
    + "/" + jobFolderName
    + "/contexts/"+ codeGenArgument.getContextName()
    + ".properties"
    ;

List<Map<String, String>> stormAdvancedConfig = (List<Map<String,String>>) ElementParameterParser.getObjectValue(
    stormConfig,"__STORM_ADVANCED_CONFIG__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append( topologyName );
    stringBuffer.append(TEXT_3);
    
        for(INode rootNode : rootNodes) {
        
    stringBuffer.append(TEXT_4);
    stringBuffer.append(rootNode.getUniqueName());
    stringBuffer.append(TEXT_5);
    
        }
        
    stringBuffer.append(TEXT_6);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_7);
    
        if (stormConfig == null) {
            System.err.println("use tStormConfiguration component to configure.");
        } else {
            
    stringBuffer.append(TEXT_8);
     if(localMode) { 
    stringBuffer.append(TEXT_9);
     } else {
    stringBuffer.append(TEXT_10);
     } 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(codeGenArgument.getContextName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(topologyName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(killAlreadyExisting);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(submit);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(monitor);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(killOnExit);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(killMonitorAfterTimeout);
    stringBuffer.append(TEXT_18);
     if (!localMode) { 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(nimbusHost);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(nimbusThriftPort);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(drpcServer);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(drpcPort);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(jobFolderName);
    stringBuffer.append(TEXT_24);
     } 
    stringBuffer.append(TEXT_25);
    
                // Set any advanced config from tStormConfiguration.
                if (stormAdvancedConfig != null && stormAdvancedConfig.size() > 0) {
                    for (int i = 0; i < stormAdvancedConfig.size(); ++i) {
                        Map<String, String> stormAdvancedConfigItem = stormAdvancedConfig.get(i);
                        
    stringBuffer.append(TEXT_26);
    stringBuffer.append(stormAdvancedConfigItem.get("NAME"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(stormAdvancedConfigItem.get("VALUE"));
    stringBuffer.append(TEXT_29);
    
                    }
                }
                
    stringBuffer.append(TEXT_30);
    
        }
        
    stringBuffer.append(TEXT_31);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(codeGenArgument.getCurrentProjectName().toLowerCase());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(jobFolderName);
    stringBuffer.append(TEXT_34);
    
                for(IContextParameter ctxParam :params){
                    String typeToGenerate = "String";
                    if(ctxParam.getType().equals("id_List Of Value") || ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory")){
                        typeToGenerate = "String";
                    }else{
                        typeToGenerate = JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true);
                    }
                    
    stringBuffer.append(TEXT_35);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_39);
    
                }
                
    stringBuffer.append(TEXT_40);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(codeGenArgument.getCurrentProjectName().toLowerCase());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(jobFolderName);
    stringBuffer.append(TEXT_43);
    
            for(IContextParameter ctxParam : params){
            
    stringBuffer.append(TEXT_44);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_48);
    
            }
            
    stringBuffer.append(TEXT_49);
    return stringBuffer.toString();
  }
}
