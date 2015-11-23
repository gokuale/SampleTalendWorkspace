package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;

public class TFireRulesVirtualBeginJava
{
  protected static String nl;
  public static synchronized TFireRulesVirtualBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFireRulesVirtualBeginJava result = new TFireRulesVirtualBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/**" + NL + " * " + NL + "// MOD 2012-11-06 to fix TDQ-4649" + NL + "org.drools.KnowledgeBase kbase_";
  protected final String TEXT_3 = " = null;" + NL + "try{" + NL + "    kbase_";
  protected final String TEXT_4 = " = new KnowledgeBase_";
  protected final String TEXT_5 = "(";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ".replace(\"/packages/\",\"/package/\")).readKnowledgeBase();" + NL + "}catch (Exception e){" + NL + "    System.err.println(e.getMessage());" + NL + "    return;" + NL + "}" + NL + "" + NL + "*/" + NL + "" + NL + "int nb_line_";
  protected final String TEXT_8 = " = 0;" + NL + "" + NL + "org.kie.api.KieServices ks_";
  protected final String TEXT_9 = " = org.kie.api.KieServices.Factory.get();" + NL;
  protected final String TEXT_10 = NL + "    org.kie.api.runtime.KieContainer kContainer_";
  protected final String TEXT_11 = " = ks_";
  protected final String TEXT_12 = ".getKieClasspathContainer();";
  protected final String TEXT_13 = NL + NL + "    String modulePath = ";
  protected final String TEXT_14 = ";" + NL + "    String url = ";
  protected final String TEXT_15 = " + \"/maven2/\" + modulePath;" + NL + "    System.out.println(\"URL: \" + url);" + NL + "    " + NL + "    // Create URLConnection with basic authorization";
  protected final String TEXT_16 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = "; ";
  protected final String TEXT_22 = NL + "          " + NL + "    java.net.URLConnection connection = new java.net.URL(url).openConnection();" + NL + "" + NL + "    //if the TAC url is empty,using official drools authentication" + NL + "    String basicAuth = \"Basic \" + javax.xml.bind.DatatypeConverter" + NL + "            .printBase64Binary((";
  protected final String TEXT_23 = " + ':' + decryptedPassword_";
  protected final String TEXT_24 = ").getBytes());" + NL + "    //if the TAC url is not empty,using TAC embeded drools authentication" + NL + "    if(!\"\".equals(";
  protected final String TEXT_25 = ")) { " + NL + "        byte[] responseBody = null;" + NL + "        int statusCode = 0;" + NL + "        org.apache.commons.httpclient.methods.GetMethod method = null;" + NL + "        org.apache.commons.httpclient.HttpClient client = new org.apache.commons.httpclient.HttpClient();" + NL + "        // Create and encrypt json object in following format: {\"actionName\":\"getDroolsKey\",\"authPass\":\"admin\",\"authUser\":\"admin@company.com\"}" + NL + "        StringBuilder jsonStrBuilder = new StringBuilder(\"{\\\"actionName\\\":\\\"getDroolsKey\\\",\\\"authPass\\\":\\\"\");" + NL + "        jsonStrBuilder.append(decryptedPassword_";
  protected final String TEXT_26 = ");" + NL + "        jsonStrBuilder.append(\"\\\",\\\"authUser\\\":\\\"\");" + NL + "        jsonStrBuilder.append(";
  protected final String TEXT_27 = ");" + NL + "        jsonStrBuilder.append(\"\\\"}\");               " + NL + "        String encrypt = new String(org.apache.commons.codec.binary.Base64.encodeBase64(jsonStrBuilder.toString().getBytes()), \"UTF8\");" + NL + "    " + NL + "        // Retrieve session key from metaServelet of TAC using encrypted json string" + NL + "        String split[] = url.split(\"/\");" + NL + "        String metaServletURL = \"\";" + NL + "        if(";
  protected final String TEXT_28 = ".startsWith(\"http\")){" + NL + "            metaServletURL = ";
  protected final String TEXT_29 = " + (";
  protected final String TEXT_30 = ".endsWith(\"/\")?\"\":\"/\") + \"metaServlet?\"+ encrypt;" + NL + "        }else{" + NL + "            String tacPath = \"/\".equals(";
  protected final String TEXT_31 = ".charAt(0))?";
  protected final String TEXT_32 = ":\"/\"+";
  protected final String TEXT_33 = ";" + NL + "            metaServletURL = split[0] + \"//\" + split[2] + tacPath + \"/metaServlet?\"+ encrypt;" + NL + "        }" + NL + "        method = new  org.apache.commons.httpclient.methods.GetMethod(metaServletURL);" + NL + "        statusCode = client.executeMethod(method);      " + NL + "        if (statusCode != org.apache.commons.httpclient.HttpStatus.SC_OK) {" + NL + "            throw new Exception(\"Failed to retrieve the session key. Please make sure the URL of TAC webapp is correctly specified.\"" + NL + "                    + method.getStatusLine());" + NL + "        }       " + NL + "        responseBody = method.getResponseBody();    " + NL + "" + NL + "        String response = new String(method.getResponseBody());" + NL + "        " + NL + "        // Use the session key to login" + NL + "        routines.system.JSONObject json = new routines.system.JSONObject(response);" + NL + "        String token = null;" + NL + "        try{" + NL + "            token = (String) json.get(\"key\");" + NL + "        } catch (Exception e) {" + NL + "            String error = (String) json.get(\"error\");" + NL + "            throw new Exception(\"Guvnor authentication failed: \" + error);" + NL + "        } finally {" + NL + "            // Release the connection." + NL + "            if (method != null) {" + NL + "                method.releaseConnection();" + NL + "            }" + NL + "        }" + NL + "        " + NL + "        if(token!=null){" + NL + "            token = java.net.URLDecoder.decode(token, \"UTF-8\");" + NL + "            basicAuth = \"Basic \" + javax.xml.bind.DatatypeConverter" + NL + "                    .printBase64Binary((token + ':' + decryptedPassword_";
  protected final String TEXT_34 = ").getBytes());" + NL + "        }" + NL + "    } " + NL + "" + NL + "    connection.setRequestProperty(\"Authorization\", basicAuth);" + NL + "    // Read KIE module from the connection" + NL + "    org.kie.api.builder.KieRepository kr = ks_";
  protected final String TEXT_35 = ".getRepository();" + NL + "    org.kie.api.io.Resource kResource = ks_";
  protected final String TEXT_36 = ".getResources().newInputStreamResource(" + NL + "            connection.getInputStream());" + NL + "    org.kie.api.builder.KieModule kModule = kr.addKieModule(kResource);" + NL + "    System.out.println(\"GroupId: \" + kModule.getReleaseId().getGroupId());" + NL + "    System.out.println(\"ArtifactId: \"" + NL + "            + kModule.getReleaseId().getArtifactId());" + NL + "    System.out.println(\"Version: \" + kModule.getReleaseId().getVersion());" + NL + "    " + NL + "    // Create a new KIE session and start a console logger for it" + NL + "    org.kie.api.runtime.KieContainer kContainer_";
  protected final String TEXT_37 = " = ks_";
  protected final String TEXT_38 = ".newKieContainer(kModule.getReleaseId());";
  protected final String TEXT_39 = NL + NL + "org.kie.api.runtime.KieSession ksession_";
  protected final String TEXT_40 = " = kContainer_";
  protected final String TEXT_41 = ".newKieSession(\"defaultKieSession\");" + NL + "" + NL + "//Generate XSD and binding.xml files" + NL + "//String[] mainArgsBindGen_";
  protected final String TEXT_42 = " = {\"-t\",";
  protected final String TEXT_43 = ",";
  protected final String TEXT_44 = "};" + NL + "//org.jibx.binding.generator.BindGen.main(mainArgsBindGen_";
  protected final String TEXT_45 = ");" + NL + "" + NL + "//Compile the binding" + NL + "//String[] argsCompile_";
  protected final String TEXT_46 = " = {\"-v\",";
  protected final String TEXT_47 = " + \"/\" + ";
  protected final String TEXT_48 = "};" + NL + "//org.jibx.binding.Compile.main(argsCompile_";
  protected final String TEXT_49 = ");" + NL + "" + NL + "org.jibx.runtime.IBindingFactory bfact_";
  protected final String TEXT_50 = " = org.jibx.runtime.BindingDirectory.getFactory(";
  protected final String TEXT_51 = ".class);" + NL + "org.jibx.runtime.IUnmarshallingContext uctx_";
  protected final String TEXT_52 = " = bfact_";
  protected final String TEXT_53 = ".createUnmarshallingContext();" + NL + "org.jibx.runtime.IMarshallingContext mctx_";
  protected final String TEXT_54 = " = bfact_";
  protected final String TEXT_55 = ".createMarshallingContext();" + NL + "mctx_";
  protected final String TEXT_56 = ".setIndent(1);";
  protected final String TEXT_57 = NL + NL + "String input_";
  protected final String TEXT_58 = ";";
  protected final String TEXT_59 = NL + "\tjava.util.Queue<String> queue_";
  protected final String TEXT_60 = " = new java.util.concurrent.ConcurrentLinkedQueue<String>();" + NL + "\t\t\t\t\t" + NL + "\tclass ThreadXMLField_";
  protected final String TEXT_61 = " extends Thread {" + NL + "\t\tjava.util.Queue<String> queue;" + NL + "\t\tjava.util.List<java.util.Map<String,String>> flows;" + NL + "\t\tjava.lang.Exception lastException;" + NL + "\t\tString currentComponent;" + NL + "\t\t" + NL + "\t\tThreadXMLField_";
  protected final String TEXT_62 = "(java.util.Queue q) {" + NL + "\t\t\tthis.queue = q;" + NL + "\t\t\tglobalMap.put(\"queue_";
  protected final String TEXT_63 = "\", queue);" + NL + "\t\t\tlastException = null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tThreadXMLField_";
  protected final String TEXT_64 = "(java.util.Queue q, java.util.List<java.util.Map<String,String>> l) {" + NL + "\t\t\tthis.queue = q;" + NL + "\t\t\tthis.flows = l;" + NL + "\t\t\tlastException = null;" + NL + "\t\t\tglobalMap.put(\"queue_";
  protected final String TEXT_65 = "\", queue);" + NL + "\t\t\tglobalMap.put(\"flows_";
  protected final String TEXT_66 = "\", flows);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic java.lang.Exception getLastException() {" + NL + "\t\t\treturn this.lastException;" + NL + "\t\t}" + NL + "\t\tpublic String getCurrentComponent() {" + NL + "\t\t\treturn this.currentComponent;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t@Override" + NL + "\t\tpublic void run() {" + NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_67 = "Process(globalMap);" + NL + "\t\t\t} catch (TalendException te) {" + NL + "\t\t\t\tthis.lastException = te.getException();" + NL + "\t\t\t\tthis.currentComponent = te.getCurrentComponent();" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_68 = "_FINISH\" + (this.queue==null?\"\":this.queue.hashCode()), \"true\");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tThreadXMLField_";
  protected final String TEXT_69 = " txf_";
  protected final String TEXT_70 = " = new ThreadXMLField_";
  protected final String TEXT_71 = "(queue_";
  protected final String TEXT_72 = ");" + NL + "\ttxf_";
  protected final String TEXT_73 = ".start();";
  protected final String TEXT_74 = NL + "\tjava.util.Queue<String> queue_";
  protected final String TEXT_75 = " = (java.util.Queue<String>) globalMap.get(\"queue_";
  protected final String TEXT_76 = "\");";
  protected final String TEXT_77 = " " + NL + "String readFinishMarkWithPipeId_";
  protected final String TEXT_78 = " = \"";
  protected final String TEXT_79 = "_FINISH\"+(queue_";
  protected final String TEXT_80 = "==null?\"\":queue_";
  protected final String TEXT_81 = ".hashCode());" + NL + "while(!globalMap.containsKey(readFinishMarkWithPipeId_";
  protected final String TEXT_82 = ") || !queue_";
  protected final String TEXT_83 = ".isEmpty()) { " + NL + "\tif (!queue_";
  protected final String TEXT_84 = ".isEmpty()) { ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();

List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

String chooseRulePackage = ElementParameterParser.getValue(node, "__CHOOSE_RULE_MODULE__");
String bindingDirectory = ElementParameterParser.getValue(node, "__BINDING_DIRECTORY__");
String className = ElementParameterParser.getValue(node, "__CLASS_NAME__");
String guvnorURL = ElementParameterParser.getValue(node, "__GUVNOR_URL__");
String tacWebApp = ElementParameterParser.getValue(node, "__TAC_WEBAPP__");
String guvnorPackage = ElementParameterParser.getValue(node, "__GUVNOR_PACKAGE__");
String guvnorUsername = ElementParameterParser.getValue(node, "__USERNAME__");
//Default binding file is binding.xml
String bindingFile = "\"binding.xml\"";

if(className.startsWith("\"") && className.endsWith("\"")){
    className = className.substring(1,className.length()-1);
}

List<Map<String, String>> schemas = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SCHEMAS__");

if(conns!=null && conns.size()>0){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(guvnorURL);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(guvnorPackage);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
if(chooseRulePackage.equals("LAST_IMPORTED_MODULE")){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
}else if(chooseRulePackage.equals("LATEST_DEPLOYMENT_FROM_WORKBENCH")){

    stringBuffer.append(TEXT_13);
    stringBuffer.append(guvnorPackage);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(guvnorURL);
    stringBuffer.append(TEXT_15);
     String passwordFieldName = "__PASSWORD__"; 
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    } else {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(guvnorUsername);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(tacWebApp);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(guvnorUsername);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(tacWebApp);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(tacWebApp);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(tacWebApp);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(tacWebApp);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(tacWebApp);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(tacWebApp);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
}

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(bindingDirectory);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(bindingDirectory);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(bindingFile);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
}

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
INode sourceNode = node.getIncomingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getSource();
String virtualSourceCid = sourceNode.getUniqueName();
INode startNode = NodeUtil.getSpecificStartNode(sourceNode);
String startNodeCid = null; 
if(startNode != null){
	startNodeCid = startNode.getUniqueName();
} 
IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
if(nextMergeConn != null && nextMergeConn.getInputId()>1 && startNodeCid != null){

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(startNodeCid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
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
    
}else{	

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
}

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    return stringBuffer.toString();
  }
}
