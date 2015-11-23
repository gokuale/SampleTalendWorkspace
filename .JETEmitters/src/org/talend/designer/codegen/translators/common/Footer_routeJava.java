package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.INode;

import org.talend.core.model.process.IProcess;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.JavaResourcesHelper;
import java.util.Map;
import org.talend.core.model.process.ElementParameterParser;

public class Footer_routeJava
{
  protected static String nl;
  public static synchronized Footer_routeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Footer_routeJava result = new Footer_routeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "protected void postProcessCamelContext(CamelContext camelContext) throws Exception {" + NL + "\t\tsuper.postProcessCamelContext(camelContext);" + NL + "\t\t// add notifier" + NL + "\t\tjava.util.Set<JmxNotificationEventNotifier> jmxEventNotifiers = camelContext" + NL + "\t\t\t\t.getRegistry().findByType(" + NL + "\t\t\t\t\t\tJmxNotificationEventNotifier.class);" + NL + "\t\tif (jmxEventNotifiers != null && !jmxEventNotifiers.isEmpty()) {" + NL + "\t\t\tcamelContext.getManagementStrategy().addEventNotifier(" + NL + "\t\t\t\t\tjmxEventNotifiers.iterator().next());" + NL + "\t\t}" + NL;
  protected final String TEXT_2 = NL + "\t\t// add external libraries" + NL + "\t\tjava.net.URLClassLoader sysloader = (java.net.URLClassLoader) ClassLoader.getSystemClassLoader();" + NL + "\t\tjava.lang.reflect.Method method = java.net.URLClassLoader.class.getDeclaredMethod(\"addURL\", new Class[] { java.net.URL.class });" + NL + "\t\tmethod.setAccessible(true);" + NL + "\t\tString[] libPaths = new String[] {";
  protected final String TEXT_3 = "};" + NL + "\t\tfor (String lib : libPaths) {" + NL + "\t\t\tString separator = System.getProperty(\"path.separator\");" + NL + "\t\t\tString[] jarFiles = lib.split(separator);" + NL + "\t\t\tfor (String jarFile : jarFiles) {" + NL + "\t\t\t\tmethod.invoke(sysloader, new Object[] { new java.io.File(jarFile).toURL() });" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_4 = NL + NL + "\t\t// add statistics which shows on the connection" + NL + "\t\tfinal routines.system.CamelStat runStat = new routines.system.CamelStat(camelContext);" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\trunStat.addConnectionMapping(\"";
  protected final String TEXT_6 = "\", \"";
  protected final String TEXT_7 = "\");";
  protected final String TEXT_8 = NL + NL + "\t\trunStat.initStatisticsInterceptor();" + NL + "" + NL + "\t\trunStat.openSocket(true);" + NL + "\t\trunStat.setAllPID(pid, pid, pid, jobName);" + NL + "\t\trunStat.startThreadStat(clientHost, portStats);" + NL + "\t\trunStat.updateStatOnJob(routines.system.RunStat.JOBSTART, \"\");" + NL + "" + NL + "\t\tnew Thread(new MyStatThread(runStat)).start();";
  protected final String TEXT_9 = NL + NL + "\t}" + NL;
  protected final String TEXT_10 = NL + NL + "\tclass MyStatThread implements Runnable {" + NL + "" + NL + "\t\troutines.system.CamelStat stats;" + NL + "" + NL + "\t\tpublic MyStatThread(routines.system.CamelStat stats) {" + NL + "\t\t\tthis.stats = stats;" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void run() {" + NL + "\t\t\twhile (true) {" + NL + "\t\t\t\ttry {";
  protected final String TEXT_11 = NL + "\t\t\t\t\tstats.updateStatOnConnection(\"";
  protected final String TEXT_12 = "\", 1, \"";
  protected final String TEXT_13 = "\");";
  protected final String TEXT_14 = NL + "\t\t\t\t\tThread.sleep(1000);" + NL + "\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_15 = NL + NL + "};" + NL + "    // init uriMap first" + NL + "    initUriMap();" + NL + "" + NL + "    //add route" + NL + "    main.addRouteBuilder(this);" + NL + "" + NL + "\tmain.run();" + NL + "}" + NL + "" + NL + "\tpublic void stop() throws java.lang.Exception {" + NL + "\t\tif(main != null) {" + NL + "\t\t\tmain.stop();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\tpublic void shutdown() throws java.lang.Exception {" + NL + "\t\tif(main != null) {" + NL + "\t\t\tmain.shutdown();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\tpublic static class ContextProperties extends Properties {" + NL + "" + NL + "\t\tpublic void synchronizeContext() {" + NL + "\t\t";
  protected final String TEXT_16 = NL + "\t\t\tif(";
  protected final String TEXT_17 = " != null){" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tString pattern_";
  protected final String TEXT_19 = " = \"yyyy-MM-dd HH:mm:ss\";" + NL + "\t\t\t\tString value_";
  protected final String TEXT_20 = " = \"";
  protected final String TEXT_21 = "\";" + NL + "\t\t\t\tString[] parts_";
  protected final String TEXT_22 = " = value_";
  protected final String TEXT_23 = ".split(\";\");" + NL + "\t\t\t\tif (parts_";
  protected final String TEXT_24 = ".length > 1) {" + NL + "\t\t\t\t\tpattern_";
  protected final String TEXT_25 = " = parts_";
  protected final String TEXT_26 = "[0];" + NL + "\t\t\t\t\tthis.setProperty(\"";
  protected final String TEXT_27 = "\", pattern_";
  protected final String TEXT_28 = " + \";\" + FormatterUtils.format_Date(";
  protected final String TEXT_29 = ", pattern_";
  protected final String TEXT_30 = "));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tthis.setProperty(\"";
  protected final String TEXT_31 = "\", FormatterUtils.format_Date(";
  protected final String TEXT_32 = ", pattern_";
  protected final String TEXT_33 = "));" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\tthis.setProperty(\"";
  protected final String TEXT_35 = "\", ";
  protected final String TEXT_36 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_38 = NL + "\t\t}" + NL;
  protected final String TEXT_39 = NL + "\t\tpublic String ";
  protected final String TEXT_40 = ";" + NL + "\t\tpublic String get";
  protected final String TEXT_41 = "() {" + NL + "\t\t\treturn this.";
  protected final String TEXT_42 = ";" + NL + "\t\t}";
  protected final String TEXT_43 = NL + "\t\tpublic ";
  protected final String TEXT_44 = " ";
  protected final String TEXT_45 = ";" + NL + "\t\tpublic ";
  protected final String TEXT_46 = " get";
  protected final String TEXT_47 = "() {" + NL + "\t\t\treturn this.";
  protected final String TEXT_48 = ";" + NL + "\t\t}";
  protected final String TEXT_49 = NL + "\t}" + NL + "" + NL + "\tprivate final ContextProperties context = new ContextProperties();" + NL + "\t" + NL + "\t//private final String jobVersion = \"";
  protected final String TEXT_50 = "\";" + NL + "\tprivate final String jobName = \"";
  protected final String TEXT_51 = "\";" + NL + "\t//private final String projectName = \"";
  protected final String TEXT_52 = "\";" + NL + "\t" + NL + "\tpublic Integer errorCode = null;" + NL + "\t" + NL + "\tpublic boolean watch = false;" + NL + "\t//portStats is null, it means don't execute the statistics" + NL + "\tpublic Integer portStats = null;" + NL + "\tpublic int portTraces = 4334;" + NL + "\tpublic String clientHost;" + NL + "\tpublic String defaultClientHost = \"localhost\";" + NL + "\tpublic String contextStr = \"Default\";" + NL + "\tpublic String pid = \"0\";" + NL + "\tpublic long startTime = 0;" + NL + "\t" + NL + "\tprivate Properties context_param = new Properties();" + NL + "    public Map<String, Object> parentContextMap = new HashMap<String, Object>();" + NL + "    " + NL + "    public static void main(String[] args){" + NL + "    \tfinal ";
  protected final String TEXT_53 = " ";
  protected final String TEXT_54 = "Class = new ";
  protected final String TEXT_55 = "();" + NL + "    " + NL + "        int exitCode = ";
  protected final String TEXT_56 = "Class.runJobInTOS(args);" + NL + "         " + NL + "         if(exitCode==1)" + NL + "       System.exit(exitCode);" + NL + "    }    " + NL + "   " + NL + " " + NL + "    public String[][] runJob(String[] args) {  " + NL + "    " + NL + "\t\tint exitCode = runJobInTOS(args);" + NL + "\t\tString[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };" + NL + "\t\treturn bufferValue;" + NL + "    }" + NL + "    " + NL + "    public int runJobInTOS(String[] args) {\t" + NL + "\t" + NL + "\t\tString lastStr = \"\";" + NL + "        for (String arg : args) {" + NL + "        \tif (arg.equalsIgnoreCase(\"--context_param\")) {" + NL + "                lastStr = arg;" + NL + "            } else if (lastStr.equals(\"\")) {" + NL + "                evalParam(arg);" + NL + "            } else {" + NL + "                evalParam(lastStr + \" \" + arg);" + NL + "                lastStr = \"\";" + NL + "            }" + NL + "        }" + NL + "\t\t" + NL + "\t\tif(clientHost == null) {" + NL + "    \t\tclientHost = defaultClientHost;" + NL + "    \t}" + NL + "    \t" + NL + "    \tif(pid == null || \"0\".equals(pid)) {" + NL + "\t    \tpid = TalendString.getAsciiRandomString(6);" + NL + "\t    }" + NL + "" + NL + "\t\t//read context values" + NL + "\t\treadContextValues(contextStr);" + NL + "\t\t" + NL + "\t\ttry {" + NL + "\t\t\trun();" + NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t\treturn 1;" + NL + "\t\t}" + NL + "\t\treturn 0;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t* read context values from specified context" + NL + "\t* @parameter contextName : the name of context while will be used" + NL + "\t*/" + NL + "\tpublic void readContextValues(String contextName){" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.InputStream inContext = ";
  protected final String TEXT_57 = ".class.getClassLoader().getResourceAsStream(\"";
  protected final String TEXT_58 = "/";
  protected final String TEXT_59 = "/contexts/\"+contextName+\".properties\");" + NL + "" + NL + "\t\t\tif (inContext!=null) {" + NL + "\t    \t\tcontext.load(inContext);" + NL + "    \t\t\tinContext.close();" + NL + "\t    \t}else{" + NL + "\t    \t\t//print info and job continue to run, for case: context_param is not empty." + NL + "\t    \t\tSystem.err.println(\"Could not find the context \" + contextName);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tif(!context_param.isEmpty()) {" + NL + "\t\t\t    context.putAll(context_param);" + NL + "\t\t\t}";
  protected final String TEXT_60 = NL + "            \t\tString pwd_";
  protected final String TEXT_61 = "_value = context.getProperty(\"";
  protected final String TEXT_62 = "\");" + NL + "            \t\tcontext.";
  protected final String TEXT_63 = " = null;" + NL + "            \t\tif(pwd_";
  protected final String TEXT_64 = "_value!=null) {" + NL + "            \t\t\tif(context_param.containsKey(\"";
  protected final String TEXT_65 = "\")) {//no need to decrypt if it come from program argument or parent job runtime" + NL + "            \t\t\t\tcontext.";
  protected final String TEXT_66 = " = pwd_";
  protected final String TEXT_67 = "_value;" + NL + "            \t\t\t} else if (!pwd_";
  protected final String TEXT_68 = "_value.isEmpty()) {" + NL + "            \t\t\t\ttry {" + NL + "            \t\t\t\t\tcontext.";
  protected final String TEXT_69 = " = routines.system.PasswordEncryptUtil.decryptPassword(pwd_";
  protected final String TEXT_70 = "_value);" + NL + "            \t\t\t\t\tcontext.put(\"";
  protected final String TEXT_71 = "\",context.";
  protected final String TEXT_72 = ");" + NL + "            \t\t\t\t} catch (java.lang.RuntimeException e) {" + NL + "            \t\t\t\t\t//do nothing" + NL + "            \t\t\t\t}" + NL + "            \t\t\t}" + NL + "            \t\t}";
  protected final String TEXT_73 = NL + "\t\t\ttry{" + NL + "\t\t\t\tString context_";
  protected final String TEXT_74 = "_value = context.getProperty(\"";
  protected final String TEXT_75 = "\");" + NL + "\t\t\t\tif (context_";
  protected final String TEXT_76 = "_value == null){" + NL + "\t\t\t\t\tcontext_";
  protected final String TEXT_77 = "_value = \"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t\tint context_";
  protected final String TEXT_78 = "_pos = context_";
  protected final String TEXT_79 = "_value.indexOf(\";\");" + NL + "\t\t\t\tString context_";
  protected final String TEXT_80 = "_pattern =  \"yyyy-MM-dd HH:mm:ss\";" + NL + "\t\t\t\tif(context_";
  protected final String TEXT_81 = "_pos > -1){" + NL + "\t\t\t\t\tcontext_";
  protected final String TEXT_82 = "_pattern = context_";
  protected final String TEXT_83 = "_value.substring(0, context_";
  protected final String TEXT_84 = "_pos);" + NL + "\t\t\t\t\tcontext_";
  protected final String TEXT_85 = "_value = context_";
  protected final String TEXT_86 = "_value.substring(context_";
  protected final String TEXT_87 = "_pos + 1);" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t    context.";
  protected final String TEXT_88 = "=(java.util.Date)(new java.text.SimpleDateFormat(context_";
  protected final String TEXT_89 = "_pattern).parse(context_";
  protected final String TEXT_90 = "_value));" + NL + "\t\t\t   " + NL + "\t\t\t}catch(ParseException e)" + NL + "\t\t\t{" + NL + "\t\t\t    context.";
  protected final String TEXT_91 = "=null;" + NL + "\t\t\t}";
  protected final String TEXT_92 = NL + "\t\t\t    \tcontext.";
  protected final String TEXT_93 = "=(";
  protected final String TEXT_94 = ") context.getProperty(\"";
  protected final String TEXT_95 = "\");";
  protected final String TEXT_96 = NL + "\t\t\t \tcontext.";
  protected final String TEXT_97 = "= new java.text.StringCharacterIterator(context.getProperty(\"";
  protected final String TEXT_98 = "\")).first();\t\t\t ";
  protected final String TEXT_99 = " " + NL + "\t\t\t \t\ttry{" + NL + "\t\t\t     \t\tcontext.";
  protected final String TEXT_100 = "=routines.system.ParserUtils.parseTo_";
  protected final String TEXT_101 = " (context.getProperty(\"";
  protected final String TEXT_102 = "\"));" + NL + "\t\t\t \t\t}catch(NumberFormatException e){" + NL + "\t\t\t     \t\tcontext.";
  protected final String TEXT_103 = "=null;" + NL + "\t\t\t \t\t}";
  protected final String TEXT_104 = NL + "    \t} catch (java.io.IOException ie) {" + NL + "    \t\tSystem.err.println(\"Could not load context \"+contextName);" + NL + "    \t\tie.printStackTrace();" + NL + "    \t}" + NL + "    \t" + NL + "    \t" + NL + "\t\t// get context value from parent directly" + NL + "\t\tif (parentContextMap != null && !parentContextMap.isEmpty()) {";
  protected final String TEXT_105 = "\t\t\t\tif (parentContextMap.containsKey(\"";
  protected final String TEXT_106 = "\")) {" + NL + "\t\t\t\tcontext.";
  protected final String TEXT_107 = " = (";
  protected final String TEXT_108 = ") parentContextMap.get(\"";
  protected final String TEXT_109 = "\");" + NL + "\t\t\t}";
  protected final String TEXT_110 = NL + "\t\t}    " + NL + "\t}" + NL + "" + NL + "\tprivate void evalParam(String arg) {" + NL + "\tif (arg.startsWith(\"--watch\")) {" + NL + "    \t\twatch = true;" + NL + "    \t} else if (arg.startsWith(\"--stat_port=\")) {" + NL + "\t\t\tString portStatsStr = arg.substring(12);" + NL + "\t\t\tif (portStatsStr != null && !portStatsStr.equals(\"null\")) {" + NL + "\t\t\t\tportStats = Integer.parseInt(portStatsStr);" + NL + "\t\t\t}    \t\t" + NL + "    \t} else if (arg.startsWith(\"--trace_port=\")) {" + NL + "    \t\tportTraces = Integer.parseInt(arg.substring(13));" + NL + "    \t} else if (arg.startsWith(\"--client_host=\")) {" + NL + "    \t\tclientHost = arg.substring(14);" + NL + "    \t} else if (arg.startsWith(\"--context=\")) {" + NL + "    \t\tcontextStr = arg.substring(10);" + NL + "    \t}if (arg.startsWith(\"--pid=\")) {" + NL + "    \t\tpid = arg.substring(6);" + NL + "    \t} else if (arg.startsWith(\"--context_param\")) {   \t\t " + NL + "            String keyValue = arg.substring(16);           " + NL + "            int index = -1;" + NL + "            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {" + NL + "                context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));" + NL + "            }" + NL + "    \t}\t" + NL + "\t}" + NL + "}";
  protected final String TEXT_111 = NL;

    private static String end_multiThread = "if ( !\"failure\".equals(((java.util.Map)threadLocal.get()).get(\"status\")) ) {\n((java.util.Map) threadLocal.get()).put(\"status\", \"end\");\n}";
    private static String end_singleThread = "if(!\"failure\".equals(status)) { status = \"end\"; }";
    private static String failure_multiThread = "((java.util.Map) threadLocal.get()).put(\"status\", \"failure\");";
    private static String failure_singleThread = "status = \"failure\";";
    private static String errorCode_multiThread = "((java.util.Map) threadLocal.get()).put(\"errorCode\", null);";
    private static String errorCode_singleThread = "errorCode = null;";
    
    // add the list of the connection names to avoid to declare two times the same name.
    public String createCallProcess(INode rootNode, String className, boolean isMultiThread) {
        String toReturn = "";
        toReturn =  "try {\n";
        if(isMultiThread) {
            toReturn +=  errorCode_multiThread;
        }else{
            toReturn +=  errorCode_singleThread;
        }        
        
        toReturn += rootNode.getUniqueName() + "Process(globalMap);\n";
        
        if(isMultiThread) {
            toReturn +=  end_multiThread;
        }else{
            toReturn +=  end_singleThread;
        }
        
        toReturn += "\n}catch (TalendException e_" + rootNode.getUniqueName() + ") {\n";
        
//        if(isMultiThread) {
//            toReturn +=  failure_multiThread;
//        }else{
//            toReturn +=  failure_singleThread;
//        }
        
        toReturn += "globalMap.put(\""+rootNode.getUniqueName()+ "_SUBPROCESS_STATE\", -1);\n";
        
        toReturn += "\ne_" + rootNode.getUniqueName() + ".printStackTrace();\n";
        
      
       //List< ? extends IConnection> onSubJobErrorConns = rootNode.getOutgoingConnections(EConnectionType.ON_SUBJOB_ERROR);
       //if(onSubJobErrorConns!=null){
       //    for(IConnection conn : onSubJobErrorConns) {               
       //        toReturn += createCallProcess(conn.getTarget(),  className, isMultiThread);
       //    }
       //}            
        if(isMultiThread){
            toReturn += "\n}catch (Error e_" + rootNode.getUniqueName() + ") {\n";
            toReturn += "globalMap.put(\""+rootNode.getUniqueName()+ "_SUBPROCESS_STATE\", -1);\n";
            toReturn += "\ne_" + rootNode.getUniqueName() + ".printStackTrace();\n";
        }
       toReturn += "\n}"; 
       return toReturn;
    }
		 
    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    Vector v = (Vector) codeGenArgument.getArgument();
    IProcess process = (IProcess)v.get(0);

	List<? extends INode> processNodes = (List<? extends INode>) process.getGeneratingNodes();
	List<IContextParameter> params = new ArrayList<IContextParameter>();
    params=process.getContextManager().getDefaultContext().getContextParameterList();
    String jobFolderName = JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
	
	boolean stats = codeGenArgument.isStatistics();
	

    stringBuffer.append(TEXT_1);
    
StringBuilder librariesSb = new StringBuilder();
for (INode node : processNodes) {
	if (node.isActivate()) {
		if (node.getComponent().getName().equals("cMessagingEndpoint")) {
			List<Map<String, String>> dependencies = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__HOTLIBS__");
			for(Map<String, String> dependencie : dependencies){
				String librarieJar = dependencie.get("LIBPATH");
				librariesSb.append("\"");
				librariesSb.append(librarieJar);
				librariesSb.append("\",");
			}
		}
	}
}
if(librariesSb.length()>0){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(librariesSb.toString());
    stringBuffer.append(TEXT_3);
    
}
	if(stats) { 
    stringBuffer.append(TEXT_4);
    
		for (INode node : processNodes) {
			if (node.isActivate()) {
				for(int i=0; i<node.getIncomingConnections().size(); i++) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(node.getIncomingConnections().get(i).getUniqueName());
    stringBuffer.append(TEXT_7);
    
				}
			}
		}

    stringBuffer.append(TEXT_8);
     } //if stats 
    stringBuffer.append(TEXT_9);
     if(stats) { 
    stringBuffer.append(TEXT_10);
    
		for (INode node : processNodes) {
			if (node.isActivate()) {
				for(int i=0; i<node.getIncomingConnections().size(); i++) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(node.getIncomingConnections().get(i).getUniqueName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_13);
    
				}
			}
		}

    stringBuffer.append(TEXT_14);
     } //if stats 
    stringBuffer.append(TEXT_15);
     for (IContextParameter ctxParam : params){
			String cParaName = ctxParam.getName(); 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_17);
     if(ctxParam.getType().equals("id_Date")){ 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(ctxParam.getValue() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_33);
     } else { 
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_36);
     } 
    stringBuffer.append(TEXT_37);
     } 
    stringBuffer.append(TEXT_38);
    
for (IContextParameter ctxParam : params) {
	if(ctxParam.getType().equals("id_List Of Value") || ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory")) { 
    stringBuffer.append(TEXT_39);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(Character.toUpperCase(ctxParam.getName().charAt(0)) + ctxParam.getName().substring(1));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_42);
    	} else { 
    stringBuffer.append(TEXT_43);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(Character.toUpperCase(ctxParam.getName().charAt(0)) + ctxParam.getName().substring(1));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_48);
    	}
}

    stringBuffer.append(TEXT_49);
    stringBuffer.append(process.getVersion() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(codeGenArgument.getCurrentProjectName().toLowerCase() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(jobFolderName );
    stringBuffer.append(TEXT_59);
     
			//for bug TDI-22398
			for (IContextParameter ctxParam :params){ //start for

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
			    if( !(ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory") ||ctxParam.getType().equals("id_List Of Value")))
			    {
			       typeToGenerate=JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true);
			    }
			    if(typeToGenerate.equals("java.util.Date")){ // start if
			        

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
    
		    	}else if(typeToGenerate.equals("Object")||typeToGenerate.equals("String")||typeToGenerate.equals("java.lang.String") ){

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
    
			    } //end if
			} //end for

    stringBuffer.append(TEXT_104);
     
			for (IContextParameter ctxParam :params){
				//about the type, they are same as header.javajet
				String typeToGenerate = "String";
				if(ctxParam.getType().equals("id_List Of Value") || ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory")){
					typeToGenerate = "String";
				}else{			 
					typeToGenerate = JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true);
				}

    stringBuffer.append(TEXT_105);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_109);
    
		}

    stringBuffer.append(TEXT_110);
    stringBuffer.append(TEXT_111);
    return stringBuffer.toString();
  }
}