package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import org.talend.core.model.utils.TalendTextUtils;
import java.util.Map;

public class TSAPBapiOutEndJava
{
  protected static String nl;
  public static synchronized TSAPBapiOutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPBapiOutEndJava result = new TSAPBapiOutEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "                if(log.is";
  protected final String TEXT_3 = "Enabled())";
  protected final String TEXT_4 = NL + "            log.";
  protected final String TEXT_5 = "(\"";
  protected final String TEXT_6 = " - \" ";
  protected final String TEXT_7 = " + ";
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "            StringBuilder ";
  protected final String TEXT_11 = " = new StringBuilder();";
  protected final String TEXT_12 = NL + "            ";
  protected final String TEXT_13 = ".append(\"Parameters:\");";
  protected final String TEXT_14 = NL + "                    ";
  protected final String TEXT_15 = ".append(\"";
  protected final String TEXT_16 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_17 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_18 = NL + "                    ";
  protected final String TEXT_19 = ".append(\"";
  protected final String TEXT_20 = "\" + \" = \" + ";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "                ";
  protected final String TEXT_23 = ".append(\" | \");";
  protected final String TEXT_24 = NL + "            StringBuilder ";
  protected final String TEXT_25 = " = new StringBuilder();    ";
  protected final String TEXT_26 = NL + "                    ";
  protected final String TEXT_27 = ".append(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "                    if(";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = " == null){";
  protected final String TEXT_33 = NL + "                        ";
  protected final String TEXT_34 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_35 = NL + "                        ";
  protected final String TEXT_36 = ".append(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = ");" + NL + "                    }   ";
  protected final String TEXT_39 = NL + "                ";
  protected final String TEXT_40 = ".append(\"|\");";
  protected final String TEXT_41 = NL + NL + "\t";
  protected final String TEXT_42 = "\t    " + NL + "\t\torg.talend.sap.ISAPConnection connection_";
  protected final String TEXT_43 = " = (org.talend.sap.ISAPConnection)globalMap.get(\"conn_";
  protected final String TEXT_44 = "\");";
  protected final String TEXT_45 = NL + "\t\t\t\tif(connection_";
  protected final String TEXT_46 = " == null){" + NL + "\t\t\t\t\tconnection_";
  protected final String TEXT_47 = " = ((org.talend.sap.impl.SAPConnectionFactory)(org.talend.sap.impl.SAPConnectionFactory.getInstance())).createConnection(";
  protected final String TEXT_48 = ");" + NL + "\t\t\t\t}";
  protected final String TEXT_49 = NL + "\t";
  protected final String TEXT_50 = NL + "\t\torg.talend.sap.ISAPConnection connection_";
  protected final String TEXT_51 = " = null;";
  protected final String TEXT_52 = NL + "\t\t\t\tconnection_";
  protected final String TEXT_53 = " = ((org.talend.sap.impl.SAPConnectionFactory)(org.talend.sap.impl.SAPConnectionFactory.getInstance())).createConnection(";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "\t\t\tif (connection_";
  protected final String TEXT_56 = " == null) {//}";
  protected final String TEXT_57 = NL + "\t\t";
  protected final String TEXT_58 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_59 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_62 = " = ";
  protected final String TEXT_63 = "; ";
  protected final String TEXT_64 = NL + "    \tjava.util.Properties properties_";
  protected final String TEXT_65 = " = new java.util.Properties();" + NL + "    \tproperties_";
  protected final String TEXT_66 = ".put(org.talend.sap.ISAPConnection.PROP_CLIENT, ";
  protected final String TEXT_67 = ");" + NL + "    \tproperties_";
  protected final String TEXT_68 = ".put(org.talend.sap.ISAPConnection.PROP_USER, ";
  protected final String TEXT_69 = ");" + NL + "    \tproperties_";
  protected final String TEXT_70 = ".put(org.talend.sap.ISAPConnection.PROP_PASSWORD, decryptedPassword_";
  protected final String TEXT_71 = ");" + NL + "    \tproperties_";
  protected final String TEXT_72 = ".put(org.talend.sap.ISAPConnection.PROP_LANGUAGE, ";
  protected final String TEXT_73 = ");" + NL + "    " + NL + "    \t";
  protected final String TEXT_74 = NL + "    \tproperties_";
  protected final String TEXT_75 = ".put(org.talend.sap.ISAPConnection.PROP_APPLICATION_SERVER_HOST, ";
  protected final String TEXT_76 = ");" + NL + "    \tproperties_";
  protected final String TEXT_77 = ".put(org.talend.sap.ISAPConnection.PROP_SYSTEM_NUMBER, ";
  protected final String TEXT_78 = ");" + NL + "    \t";
  protected final String TEXT_79 = NL + "    \tproperties_";
  protected final String TEXT_80 = ".put(\"jco.client.mshost\", ";
  protected final String TEXT_81 = ");" + NL + "    \tproperties_";
  protected final String TEXT_82 = ".put(\"jco.client.r3name\", ";
  protected final String TEXT_83 = ");" + NL + "    \tproperties_";
  protected final String TEXT_84 = ".put(\"jco.client.group\", ";
  protected final String TEXT_85 = ");" + NL + "    \t";
  protected final String TEXT_86 = NL + "    " + NL + "    \t";
  protected final String TEXT_87 = NL + "    \t\tproperties_";
  protected final String TEXT_88 = ".setProperty(\"jco.client.snc_mode\", \"1\");" + NL + "    \t\tproperties_";
  protected final String TEXT_89 = ".setProperty(\"jco.client.snc_partnername\", ";
  protected final String TEXT_90 = ");" + NL + "    \t\tproperties_";
  protected final String TEXT_91 = ".setProperty(\"jco.client.snc_qop\", String.valueOf(";
  protected final String TEXT_92 = "));" + NL + "    \t\t";
  protected final String TEXT_93 = NL + "        \t\tif(";
  protected final String TEXT_94 = " != null){" + NL + "        \t\t\tproperties_";
  protected final String TEXT_95 = ".setProperty(\"jco.client.snc_myname\", ";
  protected final String TEXT_96 = ");" + NL + "        \t\t}" + NL + "    \t\t";
  protected final String TEXT_97 = NL + "    \t\t";
  protected final String TEXT_98 = NL + "        \t\tif(";
  protected final String TEXT_99 = " != null){" + NL + "        \t\t\tproperties_";
  protected final String TEXT_100 = ".setProperty(\"jco.client.snc_lib\", ";
  protected final String TEXT_101 = ");" + NL + "        \t\t}" + NL + "    \t\t";
  protected final String TEXT_102 = NL + "    \t";
  protected final String TEXT_103 = "\t" + NL + "        " + NL + "    \t";
  protected final String TEXT_104 = NL + "    \t\tproperties_";
  protected final String TEXT_105 = ".put(";
  protected final String TEXT_106 = " ,";
  protected final String TEXT_107 = ");" + NL + "    \t\t";
  protected final String TEXT_108 = NL + "        " + NL + "\t\t";
  protected final String TEXT_109 = NL + "    \tconnection_";
  protected final String TEXT_110 = " = org.talend.sap.impl.SAPConnectionFactory.getInstance().createConnection(properties_";
  protected final String TEXT_111 = ");" + NL + "    \t";
  protected final String TEXT_112 = NL + "\t\t\t//{" + NL + "\t\t\t}";
  protected final String TEXT_113 = NL + "\t";
  protected final String TEXT_114 = NL + "\torg.dom4j.Document inputDocument_";
  protected final String TEXT_115 = " = documentHelper_";
  protected final String TEXT_116 = ".getDocument();" + NL + "\t" + NL + "\torg.talend.sap.service.ISAPBapiService service_";
  protected final String TEXT_117 = " = connection_";
  protected final String TEXT_118 = ".getBapiService();" + NL + "\t" + NL + "\t";
  protected final String TEXT_119 = NL + "\torg.talend.sap.model.bapi.ISAPBapiTemplate template_";
  protected final String TEXT_120 = " = service_";
  protected final String TEXT_121 = ".getBapiTemplate(";
  protected final String TEXT_122 = ");" + NL + "\t";
  protected final String TEXT_123 = NL + "\t" + NL + "\ttemplate_";
  protected final String TEXT_124 = ".setXml(inputDocument_";
  protected final String TEXT_125 = ");" + NL + "\torg.dom4j.Document outputDocument_";
  protected final String TEXT_126 = " = template_";
  protected final String TEXT_127 = ".execute();" + NL + "\t";
  protected final String TEXT_128 = NL + "\t" + NL + "\t";
  protected final String TEXT_129 = NL + "\tif(connection_";
  protected final String TEXT_130 = "!=null && connection_";
  protected final String TEXT_131 = ".isAlive()) {" + NL + "\t\t";
  protected final String TEXT_132 = NL + "\t\tconnection_";
  protected final String TEXT_133 = ".close();" + NL + "\t\t";
  protected final String TEXT_134 = NL + "\t}" + NL + "\t";
  protected final String TEXT_135 = NL + "\t" + NL + "\tglobalMap.put(\"outputDocument_";
  protected final String TEXT_136 = "\",outputDocument_";
  protected final String TEXT_137 = ");";
  protected final String TEXT_138 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_3);
    
            }
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_6);
    for(String message : messages){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
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
        
    stringBuffer.append(TEXT_10);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_13);
    
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
                    
    stringBuffer.append(TEXT_14);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_17);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    
    stringBuffer.append(TEXT_18);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_21);
    
                }   
                
    stringBuffer.append(TEXT_22);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_23);
    
            }
        }
        debug(var("log4jParamters"));
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_24);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_25);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_26);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_29);
    
                }else{
                
    stringBuffer.append(TEXT_30);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_38);
    
                }
                
    stringBuffer.append(TEXT_39);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_40);
    
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

    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	log = new LogUtil(node);
	
	String graphicalUniqueName = cid.replace("_TSAPBapi_OUT","");

	String client = ElementParameterParser.getValue(node, "__CLIENT__");
	String userid = ElementParameterParser.getValue(node, "__USERID__");
	String password = ElementParameterParser.getValue(node, "__PASSWORD__");
	String language = ElementParameterParser.getValue(node, "__LANGUAGE__");
	String hostname = ElementParameterParser.getValue(node, "__HOSTNAME__");
	String systemnumber = ElementParameterParser.getValue(node, "__SYSTEMNUMBER__");
	
	String systemId = ElementParameterParser.getValue(node,"__SYSTEMID__");
	String groupName = ElementParameterParser.getValue(node,"__GROUPNAME__");
	
	String serverType = ElementParameterParser.getValue(node,"__SERVERTYPE__");
	
	String sapFunction = ElementParameterParser.getValue(node,"__SAP_FUNCTION__");
	
	List<Map<String, String>> sapProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SAP_PROPERTIES__");
	
	String passwordFieldName = "__PASSWORD__";
	
    boolean activeSNC = ("true").equals(ElementParameterParser.getValue(node,"__SNC_ACTIVE__"));
    String partnerSNCName = ElementParameterParser.getValue(node,"__SNC_PARTNER_NAME__");
    String mySNCName = ElementParameterParser.getValue(node,"__SNC_MY_NAME__");
    String sncLevel = ElementParameterParser.getValue(node,"__SNC_LEVEL__");
    String sncLibPath = ElementParameterParser.getValue(node,"__SNC_LIB_PATH__");
    boolean hasSNCLibPath = sncLibPath != null && !"".equals(sncLibPath);
    boolean hasMySNCName = mySNCName != null && !"".equals(mySNCName);	
    
    boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_41);
    if(useExistingConn){
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_44);
    
		log.info(log.str("Use an existing sap connection with user : '"), userid, log.str("', host : '"), hostname, log.str("'."));
		
		INode connectionNode = null; 
		for (INode processNode : node.getProcess().getGeneratingNodes()) { 
			if(connection.equals(processNode.getUniqueName())) { 
				connectionNode = processNode; 
				break; 
			} 
		} 
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(connectionNode, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){
			String alias = ElementParameterParser.getValue(connectionNode, "__SAP_DATASOURCE_ALIAS__");
			if(null != alias && !("".equals(alias))){

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_48);
    
			}
		}

    stringBuffer.append(TEXT_49);
    }else{
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){
			String alias = ElementParameterParser.getValue(node, "__SAP_DATASOURCE_ALIAS__");
			if(null != alias && !("".equals(alias))){

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_54);
    
			}

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
		}

    stringBuffer.append(TEXT_57);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_60);
    } else {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_73);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(systemnumber);
    stringBuffer.append(TEXT_78);
    }else{
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(systemId);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_85);
    }
    stringBuffer.append(TEXT_86);
    
    	if(activeSNC){
    	
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(partnerSNCName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(sncLevel);
    stringBuffer.append(TEXT_92);
    if(hasMySNCName){
    stringBuffer.append(TEXT_93);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_96);
    }
    stringBuffer.append(TEXT_97);
    if(hasSNCLibPath){
    stringBuffer.append(TEXT_98);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    
    	}
    	
    stringBuffer.append(TEXT_103);
    
    	if(sapProps!=null) {
    		for(Map<String, String> item : sapProps){
    		
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_107);
     
    		}
    	}
    	
    stringBuffer.append(TEXT_108);
    log.info(log.str("Connection attempts to '"), hostname, log.str("' with the user : '"), userid, log.str("'."));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    log.info(log.str("Connection to '"), hostname, log.str("' with the user : '"), userid, log.str("' has succeeded."));
    
		if(specify_alias){

    stringBuffer.append(TEXT_112);
    
		}

    stringBuffer.append(TEXT_113);
    }
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    log.info(log.str("Attempt to get bapi function : '"), sapFunction, log.str("'."));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(sapFunction);
    stringBuffer.append(TEXT_122);
    log.info(log.str("Success to get bapi function : '"), sapFunction, log.str("'."));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    log.info(log.str("Execute the bapi function : '"), sapFunction, log.str("' has finished."));
    stringBuffer.append(TEXT_128);
    if(!useExistingConn) {
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    log.info(log.str("Closing the connection."));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    log.info(log.str("Connection has closed."));
    stringBuffer.append(TEXT_134);
    }
    stringBuffer.append(TEXT_135);
    stringBuffer.append(graphicalUniqueName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(TEXT_138);
    return stringBuffer.toString();
  }
}
