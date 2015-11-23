package org.talend.designer.codegen.translators.bigdata.hcatalog;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;
import java.util.List;

public class THCatalogInputBeginJava
{
  protected static String nl;
  public static synchronized THCatalogInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THCatalogInputBeginJava result = new THCatalogInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t\tclass KerberosPolicyConfig_";
  protected final String TEXT_31 = " extends javax.security.auth.login.Configuration {" + NL + "\t\t\tprivate java.util.Map<String, String> properties;" + NL + "" + NL + "\t\t\tpublic KerberosPolicyConfig_";
  protected final String TEXT_32 = "() {" + NL + "\t\t\t\tproperties = java.util.Collections" + NL + "\t\t\t\t\t\t.<String, String> emptyMap();" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic KerberosPolicyConfig_";
  protected final String TEXT_33 = "(" + NL + "\t\t\t\t\tjava.util.Map<String, String> properties) {" + NL + "\t\t\t\tthis.properties = properties;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic javax.security.auth.login.AppConfigurationEntry[] getAppConfigurationEntry(" + NL + "\t\t\t\t\tString name) {" + NL + "\t\t\t\treturn new javax.security.auth.login.AppConfigurationEntry[] { new javax.security.auth.login.AppConfigurationEntry(" + NL + "\t\t\t\t\t\tcom.sun.security.auth.module.Krb5LoginModule.class" + NL + "\t\t\t\t\t\t\t\t.getName()," + NL + "\t\t\t\t\t\tjavax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag.REQUIRED," + NL + "\t\t\t\t\t\tproperties) };" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\torg.apache.cxf.jaxrs.security.KerberosAuthOutInterceptor kbInterceptor_";
  protected final String TEXT_34 = " = new org.apache.cxf.jaxrs.security.KerberosAuthOutInterceptor();" + NL + "" + NL + "\t\torg.apache.cxf.configuration.security.AuthorizationPolicy policy_";
  protected final String TEXT_35 = " = new org.apache.cxf.configuration.security.AuthorizationPolicy();" + NL + "\t\tpolicy_";
  protected final String TEXT_36 = ".setAuthorizationType(org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_NEGOTIATE);" + NL + "" + NL + "\t\tkbInterceptor_";
  protected final String TEXT_37 = ".setPolicy(policy_";
  protected final String TEXT_38 = ");" + NL + "\t\tjava.util.Map<String, String> properties_";
  protected final String TEXT_39 = " = new java.util.HashMap<String, String>();" + NL + "\t\tkbInterceptor_";
  protected final String TEXT_40 = ".setServicePrincipalName(";
  protected final String TEXT_41 = ");" + NL + "\t\tkbInterceptor_";
  protected final String TEXT_42 = ".setRealm(";
  protected final String TEXT_43 = ");" + NL + "\t\tproperties_";
  protected final String TEXT_44 = ".put(\"useTicketCache\", \"true\");" + NL + "\t\tproperties_";
  protected final String TEXT_45 = ".put(\"refreshKrb5Config\", \"true\");" + NL + "\t\tproperties_";
  protected final String TEXT_46 = ".put(\"renewTGT\", \"true\");";
  protected final String TEXT_47 = NL + "\t\t\t\tproperties_";
  protected final String TEXT_48 = ".put(\"useKeyTab\", \"true\");" + NL + "\t\t\t\tproperties_";
  protected final String TEXT_49 = ".put(\"keyTab\", ";
  protected final String TEXT_50 = ");" + NL + "\t\t\t\tproperties_";
  protected final String TEXT_51 = ".put(\"principal\", ";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\t\tkbInterceptor_";
  protected final String TEXT_54 = ".setLoginConfig(new KerberosPolicyConfig_";
  protected final String TEXT_55 = "(properties_";
  protected final String TEXT_56 = "));";
  protected final String TEXT_57 = NL + "\tString credentials_";
  protected final String TEXT_58 = " = \"?user.name=\" + ";
  protected final String TEXT_59 = " + \"&format=extended\";" + NL + "\torg.apache.cxf.jaxrs.client.WebClient client_";
  protected final String TEXT_60 = " = org.apache.cxf.jaxrs.client.WebClient.create(\"http://\" + ";
  protected final String TEXT_61 = " + \":\" + ";
  protected final String TEXT_62 = " + credentials_";
  protected final String TEXT_63 = ");" + NL;
  protected final String TEXT_64 = NL + "\t\torg.apache.cxf.jaxrs.client.WebClient.getConfig(client_";
  protected final String TEXT_65 = ").getOutInterceptors().add(kbInterceptor_";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "\tString pathEndpoint_";
  protected final String TEXT_68 = " = \"/templeton/v1/ddl/database/\" + ";
  protected final String TEXT_69 = " + \"/table/\" + ";
  protected final String TEXT_70 = ";" + NL + "\tif(!\"\".equals(";
  protected final String TEXT_71 = ")) {" + NL + "\t\tpathEndpoint_";
  protected final String TEXT_72 = " += \"/partition/\" + ";
  protected final String TEXT_73 = ";" + NL + "\t}" + NL + "\t" + NL + "\tString location_";
  protected final String TEXT_74 = " = \"\";" + NL + "\t";
  protected final String TEXT_75 = NL + "\t\t\tString err_";
  protected final String TEXT_76 = " = \"\";" + NL + "\t\t\torg.json.simple.JSONObject jsonRow_";
  protected final String TEXT_77 = " = new org.json.simple.JSONObject();" + NL + "\t\t\tjava.io.InputStream is_";
  protected final String TEXT_78 = ";" + NL + "\t\t\tObject obj_";
  protected final String TEXT_79 = ";" + NL + "\t\t\torg.json.simple.JSONObject object_";
  protected final String TEXT_80 = ";" + NL + "\t\t\tObject error_";
  protected final String TEXT_81 = ";";
  protected final String TEXT_82 = NL + "\t\t\tis_";
  protected final String TEXT_83 = " = (java.io.InputStream) response_";
  protected final String TEXT_84 = ".getEntity();" + NL + "\t\t\tString result_";
  protected final String TEXT_85 = " = org.apache.cxf.helpers.IOUtils.toString(is_";
  protected final String TEXT_86 = ");" + NL + "\t\t\tobj_";
  protected final String TEXT_87 = "=org.json.simple.JSONValue.parse(result_";
  protected final String TEXT_88 = ");" + NL + "\t\t\tobject_";
  protected final String TEXT_89 = "=(org.json.simple.JSONObject)obj_";
  protected final String TEXT_90 = ";";
  protected final String TEXT_91 = NL + "\t\t\terror_";
  protected final String TEXT_92 = " = object_";
  protected final String TEXT_93 = ".get(\"error\");" + NL + "\t\t\tif(error_";
  protected final String TEXT_94 = "!=null) {" + NL + "\t\t\t\terr_";
  protected final String TEXT_95 = " = error_";
  protected final String TEXT_96 = ".toString();" + NL + "\t\t\t}";
  protected final String TEXT_97 = NL + "\t\t\t\tif(((org.json.simple.JSONObject)object_";
  protected final String TEXT_98 = ".get(\"exec\"))!=null) {" + NL + "\t\t\t\t\tString time_";
  protected final String TEXT_99 = " = TalendDate.formatDate(\"yyyyMMddHHmmss\", TalendDate.getCurrentDate());" + NL + "\t\t\t\t\tObject stdout_";
  protected final String TEXT_100 = " = ((org.json.simple.JSONObject)object_";
  protected final String TEXT_101 = ".get(\"exec\")).get(\"stdout\");" + NL + "\t\t\t\t\tObject stderr_";
  protected final String TEXT_102 = " = ((org.json.simple.JSONObject)object_";
  protected final String TEXT_103 = ".get(\"exec\")).get(\"stderr\");" + NL + "\t\t\t\t\tString stdout_filename_";
  protected final String TEXT_104 = " = \"/\" + projectName + \"_\" + jobName + \"_\" + jobVersion + \"_\" + time_";
  protected final String TEXT_105 = " + \"_\" + \"";
  protected final String TEXT_106 = "\" + \"_stdout.log\";" + NL + "\t\t\t\t\tString stderr_filename_";
  protected final String TEXT_107 = " = \"/\" + projectName + \"_\" + jobName + \"_\" + jobVersion + \"_\" + time_";
  protected final String TEXT_108 = " + \"_\" + \"";
  protected final String TEXT_109 = "\" + \"_stderr.log\";" + NL + "\t\t\t\t\tjava.io.FileWriter fw_out_";
  protected final String TEXT_110 = " = new java.io.FileWriter(new java.io.File(";
  protected final String TEXT_111 = "+stdout_filename_";
  protected final String TEXT_112 = "));" + NL + "\t\t\t\t\tjava.io.FileWriter fw_err_";
  protected final String TEXT_113 = " = new java.io.FileWriter(new java.io.File(";
  protected final String TEXT_114 = "+stderr_filename_";
  protected final String TEXT_115 = "));" + NL + "\t\t\t\t\tfw_out_";
  protected final String TEXT_116 = ".write(stdout_";
  protected final String TEXT_117 = "!=null?stdout_";
  protected final String TEXT_118 = ".toString():\"\");" + NL + "\t\t\t\t\tfw_err_";
  protected final String TEXT_119 = ".write(stderr_";
  protected final String TEXT_120 = "!=null?stderr_";
  protected final String TEXT_121 = ".toString():\"\");" + NL + "\t\t\t\t\tfw_out_";
  protected final String TEXT_122 = ".close();" + NL + "\t\t\t\t\tfw_err_";
  protected final String TEXT_123 = ".close();" + NL + "\t\t\t\t}";
  protected final String TEXT_124 = NL + "\t\t\tif(response_";
  protected final String TEXT_125 = ".getStatus()!=200) {" + NL + "\t\t\t\tif(response_";
  protected final String TEXT_126 = ".getStatus()==400) {" + NL + "\t\t\t\t\tthrow new Exception(\"Error 400 (Bad request): The request was invalid.\\n--->\" + err_";
  protected final String TEXT_127 = ");" + NL + "\t\t\t\t} else if(response_";
  protected final String TEXT_128 = ".getStatus()==401) {" + NL + "\t\t\t\t\tthrow new Exception(\"Error 401 (Unauthorized): Credentials were missing or incorrect.\\n--->\" + err_";
  protected final String TEXT_129 = ");" + NL + "\t\t\t\t} else if(response_";
  protected final String TEXT_130 = ".getStatus()==404) {" + NL + "\t\t\t\t\tthrow new Exception(\"Error 404 (Not found): The URI requested is invalid or the resource requested does not exist.\\n--->\" + err_";
  protected final String TEXT_131 = ");" + NL + "\t\t\t\t} else if(response_";
  protected final String TEXT_132 = ".getStatus()==500) {" + NL + "\t\t\t\t\tthrow new Exception(\"Error 500 (Internal Server Error): We received an unexpected result.\\n--->\" + err_";
  protected final String TEXT_133 = ");" + NL + "\t\t\t\t} else if(response_";
  protected final String TEXT_134 = ".getStatus()==503) {" + NL + "\t\t\t\t\tthrow new Exception(\"Error 503 (Busy, please retry): The server is busy.\\n--->\" + err_";
  protected final String TEXT_135 = ");" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tthrow new Exception(object_";
  protected final String TEXT_136 = ".get(\"errorCode\") + \":\" + object_";
  protected final String TEXT_137 = ".get(\"error\") + object_";
  protected final String TEXT_138 = ".get(\"errorDetail\"));" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_139 = NL + "\ttry {" + NL + "\t\tclient_";
  protected final String TEXT_140 = ".path(pathEndpoint_";
  protected final String TEXT_141 = ");" + NL + "\t\tclient_";
  protected final String TEXT_142 = ".accept(\"application/json\");" + NL + "\t\t" + NL + "\t\tjavax.ws.rs.core.Response response_";
  protected final String TEXT_143 = " = client_";
  protected final String TEXT_144 = ".get();" + NL;
  protected final String TEXT_145 = "\t\t" + NL + "\t\tObject loc_";
  protected final String TEXT_146 = " = object_";
  protected final String TEXT_147 = ".get(\"location\");" + NL + "\t\tif(loc_";
  protected final String TEXT_148 = "!=null) {" + NL + "\t\t\tlocation_";
  protected final String TEXT_149 = " = loc_";
  protected final String TEXT_150 = ".toString();" + NL + "\t\t}" + NL + "\t} catch (Exception e_";
  protected final String TEXT_151 = ") {";
  protected final String TEXT_152 = NL + "\t\t\tthrow e_";
  protected final String TEXT_153 = ";";
  protected final String TEXT_154 = NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_155 = ".getMessage());";
  protected final String TEXT_156 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_157 = " - \" + e_";
  protected final String TEXT_158 = ".getMessage());";
  protected final String TEXT_159 = NL + "\t}" + NL + "\t" + NL + "\tif(location_";
  protected final String TEXT_160 = " == null || \"\".equals(location_";
  protected final String TEXT_161 = ") || location_";
  protected final String TEXT_162 = ".length() <= 0) {";
  protected final String TEXT_163 = NL + "\t\t\tthrow new Exception(\"Error during the response parsing. The Templeton server has returned a bad value or the location isn't available\");";
  protected final String TEXT_164 = NL + "\t\t\tSystem.err.println(\"Error during the response parsing. The Templeton server has returned a bad value or the location isn't available\");";
  protected final String TEXT_165 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_166 = " - Error during the response parsing. The Templeton server has returned a bad value or the location isn't available\");";
  protected final String TEXT_167 = NL + "\t}" + NL + "\t\t" + NL + "\tString pathHDFS_";
  protected final String TEXT_168 = " = \"\";" + NL + "\tString namenode_";
  protected final String TEXT_169 = " = \"\";" + NL + "\t" + NL + "\tif(location_";
  protected final String TEXT_170 = ".contains(\":\")) {";
  protected final String TEXT_171 = NL + "\t\tpathHDFS_";
  protected final String TEXT_172 = " = location_";
  protected final String TEXT_173 = ";" + NL + "\t\tnamenode_";
  protected final String TEXT_174 = " = \"maprfs:///\";";
  protected final String TEXT_175 = NL + "\t\tjava.net.URI uri_location_";
  protected final String TEXT_176 = " = java.net.URI.create(location_";
  protected final String TEXT_177 = ");" + NL + "\t\tpathHDFS_";
  protected final String TEXT_178 = " = uri_location_";
  protected final String TEXT_179 = ".getPath();" + NL + "\t\tnamenode_";
  protected final String TEXT_180 = " = uri_location_";
  protected final String TEXT_181 = ".getScheme() + \"://\" + uri_location_";
  protected final String TEXT_182 = ".getAuthority();";
  protected final String TEXT_183 = NL + "\t}";
  protected final String TEXT_184 = NL + "\t\tString username_";
  protected final String TEXT_185 = " = \"\";" + NL + "\t\torg.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_186 = " = null;";
  protected final String TEXT_187 = NL + "\t\torg.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_188 = " = new org.apache.hadoop.conf.Configuration();" + NL + "\t\tconf_";
  protected final String TEXT_189 = ".set(\"fs.default.name\", namenode_";
  protected final String TEXT_190 = ");";
  protected final String TEXT_191 = NL + "\t\t\tconf_";
  protected final String TEXT_192 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_193 = ");";
  protected final String TEXT_194 = NL + "\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_195 = ", ";
  protected final String TEXT_196 = ");";
  protected final String TEXT_197 = NL + "\t\t\tusername_";
  protected final String TEXT_198 = " = ";
  protected final String TEXT_199 = ";";
  protected final String TEXT_200 = NL + "\t\t\t\tconf_";
  protected final String TEXT_201 = ".set(";
  protected final String TEXT_202 = " ,";
  protected final String TEXT_203 = ");";
  protected final String TEXT_204 = NL + "\t\tif(username_";
  protected final String TEXT_205 = " == null || \"\".equals(username_";
  protected final String TEXT_206 = ")){" + NL + "\t\t\tfs_";
  protected final String TEXT_207 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_208 = ");" + NL + "\t\t}else{" + NL + "\t\t\tfs_";
  protected final String TEXT_209 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_210 = ".get(\"fs.default.name\")),conf_";
  protected final String TEXT_211 = ",username_";
  protected final String TEXT_212 = ");" + NL + "\t\t}\t" + NL + "" + NL + "\t\torg.apache.hadoop.fs.FileStatus [] fileStatus_";
  protected final String TEXT_213 = "= fs_";
  protected final String TEXT_214 = ".listStatus(new org.apache.hadoop.fs.Path(pathHDFS_";
  protected final String TEXT_215 = "));";
  protected final String TEXT_216 = NL + "\t\tfor(int i_";
  protected final String TEXT_217 = "=0; i_";
  protected final String TEXT_218 = "<fileStatus_";
  protected final String TEXT_219 = ".length; i_";
  protected final String TEXT_220 = "++) {" + NL + "\t\t\tif(fileStatus_";
  protected final String TEXT_221 = "[i_";
  protected final String TEXT_222 = "].isDir()) {" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\torg.apache.hadoop.fs.Path path_";
  protected final String TEXT_223 = " = fileStatus_";
  protected final String TEXT_224 = "[i_";
  protected final String TEXT_225 = "].getPath();" + NL + "\t\t\torg.apache.hadoop.fs.FSDataInputStream fsDataInputStream_";
  protected final String TEXT_226 = " = fs_";
  protected final String TEXT_227 = ".open(path_";
  protected final String TEXT_228 = ");" + NL + "\t\t\torg.talend.fileprocess.FileInputDelimited fid_";
  protected final String TEXT_229 = " = new org.talend.fileprocess.FileInputDelimited(fsDataInputStream_";
  protected final String TEXT_230 = ", ";
  protected final String TEXT_231 = ",";
  protected final String TEXT_232 = ",";
  protected final String TEXT_233 = ",false,0,0,-1,-1, false);" + NL + "\t\t\twhile (fid_";
  protected final String TEXT_234 = ".nextRecord()) {";
  protected final String TEXT_235 = NL + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	log4jFileUtil.componentStartInfo(node);
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
	String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
	boolean customEncoding="true".equals( ElementParameterParser.getValue(node,"__CUSTOM_ENCODING__"));
	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	
	String templetonHost = ElementParameterParser.getValue(node, "__TEMPLETON_HOST__");
	String templetonPort = ElementParameterParser.getValue(node, "__TEMPLETON_PORT__");
	String database = ElementParameterParser.getValue(node, "__DATABASE_NAME__");
	String table = ElementParameterParser.getValue(node, "__TABLE_NAME__");
	String partition = ElementParameterParser.getValue(node, "__PARTITION_NAME__");
	String user = ElementParameterParser.getValue(node, "__USERNAME__");
	
	String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
	List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
		
	String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
	
	boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	boolean activateLog = "true".equals(ElementParameterParser.getValue(node, "__ACTIVATE_LOG__"));
	
	String stdout = ElementParameterParser.getValue(node, "__STDOUT__");
	String stderr = ElementParameterParser.getValue(node, "__STDERR__");
	
	IConnection outConn = null;
	IMetadataTable metadata = null;
	
	boolean useKerberos = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	String krb_realm = ElementParameterParser.getValue(node, "__KRB_REALM__");
	String krb_princ = ElementParameterParser.getValue(node, "__KRB_PRINC__");
	String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
	boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
	String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
	String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
	
	if(useKerberos) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(krb_princ);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(krb_realm);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
			if(useKeytab) {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_52);
    
			}

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
	}	

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(templetonHost);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(templetonPort);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
	if(useKerberos) {

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
	}

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(database);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(partition);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(partition);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
	class ParseRestResult {
	
		protected String cid;
		protected boolean activateLog;
		protected String stdout;
		protected String stderr;
	
	
		public void declareVariable(INode node) {
			this.cid = node.getUniqueName();

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
		}
	
		public void getJSONObject(INode node, String context) {
			this.cid = node.getUniqueName();

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
		}
		
		public void manageError(INode node, boolean activateLog) {
			this.cid = node.getUniqueName();
			this.activateLog = activateLog;

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
			if(this.activateLog) {
				this.stdout = ElementParameterParser.getValue(node, "__STDOUT__");
				this.stderr = ElementParameterParser.getValue(node, "__STDERR__");

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(this.stdout);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(this.stderr);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
			}
		}
		
		public void manageResponseStatus(INode node, String context) {
			this.cid = node.getUniqueName();

    stringBuffer.append(TEXT_124);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(context==null?"":context+"_");
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
		}
	}

    
		ParseRestResult parserResult = new ParseRestResult();
		parserResult.declareVariable(node);

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
			parserResult.getJSONObject(node, null);
			parserResult.manageError(node, activateLog);
			parserResult.manageResponseStatus(node, null);

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    
		if(dieOnError) {

    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
		} else {

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
			}
		}

    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    
		if(dieOnError) {

    stringBuffer.append(TEXT_163);
    
		} else {

    stringBuffer.append(TEXT_164);
    
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
			}
		}

    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    
        boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
        String hcatVersion = ElementParameterParser.getValue(node, "__HCAT_VERSION__");
        if(!isCustom && hcatVersion!=null && hcatVersion.contains("MAPR")) {

    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
		} else {

    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
		}

    stringBuffer.append(TEXT_183);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);
		if (metadata!=null) { 

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
       
		String hadoopVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");

    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    
		if(useKerberos) {

    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_193);
    
			if(useKeytab) {

    stringBuffer.append(TEXT_194);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_196);
    
			}
		} else {

    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_199);
    
		}
		if(hadoopProps.size() > 0){
			for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_203);
     
			} 
		}

    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    
		log4jFileUtil.startRetriveDataInfo();

    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append((customEncoding?encoding:null) );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    
		}
	}

    stringBuffer.append(TEXT_235);
    return stringBuffer.toString();
  }
}
