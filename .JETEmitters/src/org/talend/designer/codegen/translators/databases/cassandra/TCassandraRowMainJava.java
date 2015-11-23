package org.talend.designer.codegen.translators.databases.cassandra;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;

public class TCassandraRowMainJava
{
  protected static String nl;
  public static synchronized TCassandraRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCassandraRowMainJava result = new TCassandraRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    \t";
  protected final String TEXT_3 = NL + "        com.datastax.driver.core.Cluster cluster_";
  protected final String TEXT_4 = " = (com.datastax.driver.core.Cluster)globalMap.get(\"cluster_";
  protected final String TEXT_5 = "\");" + NL + "        com.datastax.driver.core.Session connection_";
  protected final String TEXT_6 = " = (com.datastax.driver.core.Session)globalMap.get(\"connection_";
  protected final String TEXT_7 = "\");";
  protected final String TEXT_8 = NL + "\t";
  protected final String TEXT_9 = NL + "    com.datastax.driver.core.Cluster cluster_";
  protected final String TEXT_10 = " = com.datastax.driver.core.Cluster.builder()" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.addContactPoints(";
  protected final String TEXT_11 = ".split(\",\"))" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.withPort(Integer.valueOf(";
  protected final String TEXT_12 = "))" + NL + "                                                            \t";
  protected final String TEXT_13 = NL + "                                                                \t.withCredentials(";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = ")" + NL + "                                                            \t";
  protected final String TEXT_16 = NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.build();" + NL + "\t" + NL + "\tcom.datastax.driver.core.Session connection_";
  protected final String TEXT_17 = " = null;" + NL + "\tconnection_";
  protected final String TEXT_18 = " = cluster_";
  protected final String TEXT_19 = ".connect();" + NL + "        resourceMap.put(\"cluster_";
  protected final String TEXT_20 = "\", cluster_";
  protected final String TEXT_21 = ");" + NL + "        resourceMap.put(\"connection_";
  protected final String TEXT_22 = "\", connection_";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "    try{" + NL + "    \tconnection_";
  protected final String TEXT_25 = ".execute(";
  protected final String TEXT_26 = ");" + NL + "    }catch(java.lang.Exception e){" + NL + "    \t";
  protected final String TEXT_27 = NL + "    \t\tthrow(e);" + NL + "    \t";
  protected final String TEXT_28 = NL + "    \t\tSystem.err.println(e.getMessage());" + NL + "    \t";
  protected final String TEXT_29 = NL + "    }";
  protected final String TEXT_30 = NL + "        connection_";
  protected final String TEXT_31 = ".close();" + NL + "        cluster_";
  protected final String TEXT_32 = ".close();";
  protected final String TEXT_33 = "    ";
  protected final String TEXT_34 = NL + "\t\tme.prettyprint.hector.api.Cluster cluster_";
  protected final String TEXT_35 = " =null;" + NL + "\t\tme.prettyprint.hector.api.Keyspace keyspace_";
  protected final String TEXT_36 = " =null;" + NL + "\t\ttry{";
  protected final String TEXT_37 = NL + "\t\tcluster_";
  protected final String TEXT_38 = "=(me.prettyprint.hector.api.Cluster)globalMap.get(\"cluster_";
  protected final String TEXT_39 = "\");";
  protected final String TEXT_40 = NL + "\t\t\tString hostIps_";
  protected final String TEXT_41 = "=";
  protected final String TEXT_42 = "+\":\"+";
  protected final String TEXT_43 = ";" + NL + "\t\t\tme.prettyprint.cassandra.service.CassandraHostConfigurator hosts_";
  protected final String TEXT_44 = " = new me.prettyprint.cassandra.service.CassandraHostConfigurator(hostIps_";
  protected final String TEXT_45 = ");" + NL + "\t\t\tjava.util.Map<String, String> credentials_";
  protected final String TEXT_46 = " = new java.util.HashMap<String, String>();";
  protected final String TEXT_47 = NL + "\t\t\tcredentials_";
  protected final String TEXT_48 = ".put(\"username\",";
  protected final String TEXT_49 = ");" + NL + "\t\t\t";
  protected final String TEXT_50 = NL + "            ";
  protected final String TEXT_51 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_52 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_55 = " = ";
  protected final String TEXT_56 = "; ";
  protected final String TEXT_57 = NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\tcredentials_";
  protected final String TEXT_58 = ".put(\"password\",decryptedPassword_";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL + "\t\t\tcluster_";
  protected final String TEXT_61 = " = me.prettyprint.hector.api.factory.HFactory.getOrCreateCluster(\"cluster_";
  protected final String TEXT_62 = "_\"+pid,hosts_";
  protected final String TEXT_63 = ",credentials_";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\t\t\tme.prettyprint.cassandra.model.ConfigurableConsistencyLevel clpolicy_";
  protected final String TEXT_66 = " = new me.prettyprint.cassandra.model.ConfigurableConsistencyLevel();" + NL + "\t\t\tme.prettyprint.hector.api.HConsistencyLevel consistencyLevel_";
  protected final String TEXT_67 = " = me.prettyprint.hector.api.HConsistencyLevel.ONE;" + NL + "\t\t\tclpolicy_";
  protected final String TEXT_68 = ".setDefaultWriteConsistencyLevel(consistencyLevel_";
  protected final String TEXT_69 = ");" + NL + "\t\t\tkeyspace_";
  protected final String TEXT_70 = " = me.prettyprint.hector.api.factory.HFactory.createKeyspace(";
  protected final String TEXT_71 = ", cluster_";
  protected final String TEXT_72 = ",clpolicy_";
  protected final String TEXT_73 = ");" + NL + "\t\t\tme.prettyprint.cassandra.model.CqlQuery cql_";
  protected final String TEXT_74 = "=new me.prettyprint.cassandra.model.CqlQuery(keyspace_";
  protected final String TEXT_75 = ",me.prettyprint.cassandra.serializers.StringSerializer.get()," + NL + "\t\t\t\tme.prettyprint.cassandra.serializers.StringSerializer.get(),me.prettyprint.cassandra.serializers.StringSerializer.get());" + NL + "\t\t\tcql_";
  protected final String TEXT_76 = ".setQuery(";
  protected final String TEXT_77 = ");" + NL + "\t\t\tcql_";
  protected final String TEXT_78 = ".execute();" + NL + "\t\t}catch(Exception e_";
  protected final String TEXT_79 = "){";
  protected final String TEXT_80 = NL + "\t\t\tthrow(e_";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_83 = ".getMessage());";
  protected final String TEXT_84 = NL + "\t\t}finally{" + NL + "\t\t\tif(cluster_";
  protected final String TEXT_85 = "!=null){" + NL + "\t\t\t\tcluster_";
  protected final String TEXT_86 = ".getConnectionManager().shutdown();" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_87 = NL + "\t\t}";
  protected final String TEXT_88 = NL + "    \t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    
// Check the presence of a tCassandraConnection
{
    boolean useExistingConnection = ElementParameterParser.getBooleanValue(node,"__USE_EXISTING_CONNECTION__");
    if (useExistingConnection) {
        String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        if (connection.isEmpty()) {
            return "if (true) {throw new IOException(\"You have to selection a connection\");}";
        }
    }
}

    stringBuffer.append(TEXT_1);
    
//TODO: use API_SELECTED instead of this
class API_selector{
	public boolean useDatastax(INode node){
		String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
        String apiType = ElementParameterParser.getValue(node, "__API_TYPE__");
        return "CASSANDRA_2_0_0".equals(dbVersion) && "DATASTAX".equals(apiType); 
	}
}	

    
	if((new API_selector()).useDatastax(ElementParameterParser.getBooleanValue(node, "__USE_EXISTING_CONNECTION__") ? ElementParameterParser.getLinkedNodeValue(node, "__CONNECTION__") : node)){
	
    stringBuffer.append(TEXT_2);
     
    boolean useExistConn = ElementParameterParser.getBooleanValue(node, "__USE_EXISTING_CONNECTION__");
    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
    if(useExistConn){
    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_7);
    
    }else{  
    
    stringBuffer.append(TEXT_8);
    
    String host = ElementParameterParser.getValue(node,"__HOST__");
    String port = ElementParameterParser.getValue(node,"__PORT__");
    String userName = ElementParameterParser.getValue(node, "__USERNAME__");
    String passWord = ElementParameterParser.getPasswordValue(node, "__PASSWORD__");
	boolean authentication= ElementParameterParser.getBooleanValue(node, "__REQUIRED_AUTHENTICATION__");
    
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_12);
    
                                                            	if(authentication){
                                                            	
    stringBuffer.append(TEXT_13);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(passWord);
    stringBuffer.append(TEXT_15);
    
                                                            	}
                                                            	
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
    }
    Boolean dieOnError = ElementParameterParser.getBooleanValue(node, "__DIE_ON_ERROR__");
    String query = ElementParameterParser.getValue(node, "__QUERY__").replaceAll("[\r\n]", " ");
    
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_26);
    
    	if(dieOnError){
    	
    stringBuffer.append(TEXT_27);
    
    	}else{
    	
    stringBuffer.append(TEXT_28);
    
    	}
    	
    stringBuffer.append(TEXT_29);
     
    if(!useExistConn){
    
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
    }
    
    
    }else{
    
    stringBuffer.append(TEXT_33);
    
	String host = ElementParameterParser.getValue(node,"__HOST__");
    String port = ElementParameterParser.getValue(node,"__PORT__");
    //String cluster= ElementParameterParser.getValue(node, "__CLUSTER__");
    String userName = ElementParameterParser.getValue(node, "__USERNAME__");
    String passWord = ElementParameterParser.getValue(node, "__PASSWORD__");
	String keySpace = ElementParameterParser.getValue(node,"__KEY_SPACE__");
	boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    String columnFamily = ElementParameterParser.getValue(node,"__COLUMN_FAMILY__");
    String query = ElementParameterParser.getValue(node,"__QUERY__");
    query = query.replaceAll("\n"," ");
    query = query.replaceAll("\r"," ");
    boolean dieOnError = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
	if (useExistingConnection){
		String connection = ElementParameterParser.getValue(node, "__CONNECTION__");

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_39);
    
	}else{

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
		if (authentication){

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_49);
    
            String passwordFieldName = "__PASSWORD__";
            
    stringBuffer.append(TEXT_50);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_53);
    } else {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
		}

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
	}

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
	if(dieOnError){

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
	}else{

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
	}
	if (!useExistingConnection){

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
	}else{

    stringBuffer.append(TEXT_87);
    
	}

    stringBuffer.append(TEXT_88);
    
    }
    
    return stringBuffer.toString();
  }
}
