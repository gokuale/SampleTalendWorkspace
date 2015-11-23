package org.talend.designer.codegen.translators.elt.map.hive;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.process.IConnection;
import org.talend.designer.dbmap.external.data.ExternalDbMapData;
import org.talend.designer.dbmap.external.data.ExternalDbMapTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.dbmap.DbMapComponent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class TELTHiveMapMainJava
{
  protected static String nl;
  public static synchronized TELTHiveMapMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TELTHiveMapMainJava result = new TELTHiveMapMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " " + NL + "\t\tSystem.setProperty(\"java.io.tmpdir\", ";
  protected final String TEXT_2 = "); " + NL + "\t";
  protected final String TEXT_3 = NL + "\t\tSystem.setProperty(";
  protected final String TEXT_4 = " ,";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_7 = ");" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"false\");" + NL + "\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"true\");" + NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_11 = ");" + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_12 = ");" + NL + "\t\t\t" + NL + "    \t\t";
  protected final String TEXT_13 = NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_14 = " " + NL + "        \tString decryptedMetastorePassword_";
  protected final String TEXT_15 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_16 = ");" + NL + "   \t\t \t";
  protected final String TEXT_17 = NL + "        \tString decryptedMetastorePassword_";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = "; " + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tSystem.setProperty(\"hive.server2.authentication.kerberos.principal\", ";
  protected final String TEXT_21 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.server2.authentication.kerberos.keytab\", ";
  protected final String TEXT_22 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_23 = NL + NL + "\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", decryptedMetastorePassword_";
  protected final String TEXT_24 = ");" + NL + "\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_25 = ");\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_27 = ", ";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_30 = ", ";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "\t\tSystem.setProperty(\"";
  protected final String TEXT_35 = "\", ";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + NL + "\t\t\tglobalMap.put(" + NL + "\t\t\t\t\"";
  protected final String TEXT_38 = "\"+\"QUERY\" + \"";
  protected final String TEXT_39 = "\"," + NL + "\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t);" + NL + "\t\t\tglobalMap.put(" + NL + "\t\t\t\t\t\"";
  protected final String TEXT_41 = "\"+\"QUERY_COLUMNS_NAME\" + \"";
  protected final String TEXT_42 = "\"," + NL + "\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t);" + NL + "\t\t\t";
  protected final String TEXT_44 = "       " + NL + "                Object ";
  protected final String TEXT_45 = " = new Object();         ";
  protected final String TEXT_46 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    


	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	DbMapComponent node = (DbMapComponent) codeGenArgument.getArgument();

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    org.talend.designer.dbmap.language.hive.HiveGenerationManager gm = new org.talend.designer.dbmap.language.hive.HiveGenerationManager();
    String uniqueNameComponent = null;

    List<IConnection> outputConnections = (List<IConnection>) node.getOutgoingConnections();
    ExternalDbMapData data = (ExternalDbMapData) node.getExternalData();
    uniqueNameComponent = node.getUniqueName();

	boolean isExecutedThroughWebHCat = "MICROSOFT_HD_INSIGHT".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));

	String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
	String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");
	String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
	String fsDefalutName = "fs.default.name";

	boolean setTempPath = "true".equals(ElementParameterParser.getValue(node, "__SET_TEMP_PATH__")); 
	if(setTempPath) { 
		String tempPath = ElementParameterParser.getValue(node, "__TEMP_PATH__"); 
	
    stringBuffer.append(TEXT_1);
    stringBuffer.append(tempPath);
    stringBuffer.append(TEXT_2);
     
	}
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
if(("false").equals(useExistingConn) && !isExecutedThroughWebHCat) {
	boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
	boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
	List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");

	boolean isCustom = "CUSTOM".equals(ElementParameterParser.getValue(node, "__DISTRIBUTION__"));
	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));

	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	boolean cdhCanBeSecured = ("Cloudera_CDH4".equals(hiveVersion) || "Cloudera_CDH4_YARN".equals(hiveVersion) || "Cloudera_CDH5".equals(hiveVersion) || "Cloudera_CDH5_1".equals(hiveVersion) || "Cloudera_CDH5_4".equals(hiveVersion) || "Cloudera_CDH5_1_MR1".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
	boolean pivotalCanBeSecured = ("PIVOTAL_HD_2_0".equals(hiveVersion)) && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer));
	boolean securityIsEnabled = useKrb && (isCustom || ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion) || "HDP_2_0".equals(hiveVersion) || "HDP_2_1".equals(hiveVersion) || "HDP_2_2".equals(hiveVersion) || cdhCanBeSecured || pivotalCanBeSecured));

	boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
	boolean securedEmbeddedHive2 = securedEmbedded && "HIVE2".equalsIgnoreCase(hiveServer);
	String hivePrincipal = ElementParameterParser.getValue(node, "__HIVE_PRINCIPAL__");

	boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);

	if(hadoopProps.size() > 0){
		for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_5);
    
		} 
	}

    // force hive2
    if ((!isCustom)
            && (("Cloudera_CDH5_4".equals(hiveVersion))
                    || ("APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion)) || ("MAPR410".equals(hiveVersion)))) {
        hiveServer = "HIVE2";
    }
	
		if(securedEmbedded) {
			String metastoreUrl = ElementParameterParser.getValue(node, "__METASTORE_JDBC_URL__");
			String driverClass = ElementParameterParser.getValue(node, "__METASTORE_CLASSNAME__");
			String metastoreUsername = ElementParameterParser.getValue(node, "__METASTORE_USERNAME__");
			boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
			String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
			String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_6);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_7);
    if(securedEmbeddedHive2){
				// Disable authorization when using local HiveServer2 in secure mode
				
    stringBuffer.append(TEXT_8);
    
			}else{
				
    stringBuffer.append(TEXT_9);
    
			}
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_12);
    
    		String passwordFieldName = "__METASTORE_PASSWORD__";
    		
    stringBuffer.append(TEXT_13);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_16);
    } else {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_18);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_19);
    }
			
			if(securedEmbeddedHive2){
				
    stringBuffer.append(TEXT_20);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_PRINCIPAL__"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_KEYTAB__"));
    stringBuffer.append(TEXT_22);
    
			}
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(uniqueNameComponent);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_25);
    
			if(useKeytab) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_28);
    
			}
		}

		if(securedStandaloneHive2){
			boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
			String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
			String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

			if(useKeytab) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_31);
    
			}
		}

	if(((isCustom && !useYarn) || (!isCustom && !"PIVOTAL_HD_1_0_1".equals(hiveVersion) && !"PIVOTAL_HD_2_0".equals(hiveVersion) && !"HDP_2_0".equals(hiveVersion) && !"HDP_2_1".equals(hiveVersion) && !"HDP_2_2".equals(hiveVersion) && !"Cloudera_CDH4_YARN".equals(hiveVersion) && !"Cloudera_CDH5".equals(hiveVersion) && !"Cloudera_CDH5_1".equals(hiveVersion) && !"Cloudera_CDH5_4".equals(hiveVersion) && !"MAPR401".equals(hiveVersion) && !"MAPR410".equals(hiveVersion) && !"APACHE_2_4_0_EMR".equals(hiveVersion) && !"APACHE_2_4_0_EMR_0_13_1".equals(hiveVersion) && !"EMR_4_0_0".equals(hiveVersion))) && setMapredJT) {
		String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_32);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_33);
    
	}

	if(setNamenode) {
		String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_34);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_36);
    
	}			
}   			
	
    List<ExternalDbMapTable> outputTables = data.getOutputTables();

    Map<String, IConnection> nameToOutputConnection = new HashMap<String, IConnection>();
    for (IConnection connection : outputConnections) {
        nameToOutputConnection.put(connection.getUniqueName(), connection);
    }

	Set<String> tablesProcessed = new HashSet<String>();
    int lstOutputTablesSize = outputTables.size();
    for (int i = 0; i < lstOutputTablesSize; i++) {
        ExternalDbMapTable outputTable = outputTables.get(i);
        String outputTableName = outputTable.getName();

			IConnection connection = nameToOutputConnection.get(outputTableName);

        if (connection == null) {
        	continue;
        }

        String sqlQuery = gm.buildSqlSelect((DbMapComponent) node, outputTable.getName());
        
	
    stringBuffer.append(TEXT_37);
    stringBuffer.append(uniqueNameComponent );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( connection.getUniqueName() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append( sqlQuery.replaceAll("[\r\n]", " ") );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(uniqueNameComponent );
    stringBuffer.append(TEXT_41);
    stringBuffer.append( connection.getUniqueName() );
    stringBuffer.append(TEXT_42);
    stringBuffer.append( gm.getQueryColumnsName() );
    stringBuffer.append(TEXT_43);
    
            if(!tablesProcessed.contains(outputTable.getTableName())) {          
            
    stringBuffer.append(TEXT_44);
    stringBuffer.append( outputTable.getTableName() );
    stringBuffer.append(TEXT_45);
           
            } 
			tablesProcessed.add(outputTable.getTableName());
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    stringBuffer.append(TEXT_46);
    return stringBuffer.toString();
  }
}
