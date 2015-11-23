package org.talend.designer.codegen.translators.databases.cassandra;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TCassandraConnectionMainJava
{
  protected static String nl;
  public static synchronized TCassandraConnectionMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCassandraConnectionMainJava result = new TCassandraConnectionMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "    \t";
  protected final String TEXT_4 = NL + "\t";
  protected final String TEXT_5 = NL + "\t";
  protected final String TEXT_6 = NL + "    com.datastax.driver.core.Cluster cluster_";
  protected final String TEXT_7 = " = com.datastax.driver.core.Cluster.builder()" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.addContactPoints(";
  protected final String TEXT_8 = ".split(\",\"))" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.withPort(Integer.valueOf(";
  protected final String TEXT_9 = "))" + NL + "                                                            \t";
  protected final String TEXT_10 = NL + "                                                                \t.withCredentials(";
  protected final String TEXT_11 = ", ";
  protected final String TEXT_12 = ")" + NL + "                                                            \t";
  protected final String TEXT_13 = NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.build();" + NL + "\t" + NL + "\tcom.datastax.driver.core.Session connection_";
  protected final String TEXT_14 = " = null;" + NL + "\tconnection_";
  protected final String TEXT_15 = " = cluster_";
  protected final String TEXT_16 = ".connect();" + NL + "\tglobalMap.put(\"cluster_";
  protected final String TEXT_17 = "\", cluster_";
  protected final String TEXT_18 = ");" + NL + "\tglobalMap.put(\"connection_";
  protected final String TEXT_19 = "\", connection_";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = "    ";
  protected final String TEXT_22 = NL + "\t";
  protected final String TEXT_23 = NL + "    String hostIps_";
  protected final String TEXT_24 = "=";
  protected final String TEXT_25 = "+\":\"+";
  protected final String TEXT_26 = ";" + NL + "    me.prettyprint.cassandra.service.CassandraHostConfigurator hosts_";
  protected final String TEXT_27 = " = new me.prettyprint.cassandra.service.CassandraHostConfigurator(hostIps_";
  protected final String TEXT_28 = ");" + NL + "    hosts_";
  protected final String TEXT_29 = ".setAutoDiscoverHosts(true);" + NL + "    java.util.Map<String, String> credentials_";
  protected final String TEXT_30 = " =new java.util.HashMap<String,String>();" + NL + "\t";
  protected final String TEXT_31 = NL + "    \tcredentials_";
  protected final String TEXT_32 = ".put(\"username\",";
  protected final String TEXT_33 = ");" + NL + "    \t";
  protected final String TEXT_34 = NL + "        ";
  protected final String TEXT_35 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_36 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_39 = " = ";
  protected final String TEXT_40 = "; ";
  protected final String TEXT_41 = NL + "    \t" + NL + "    \t" + NL + "    \tcredentials_";
  protected final String TEXT_42 = ".put(\"password\",decryptedPassword_";
  protected final String TEXT_43 = ");" + NL + "\t";
  protected final String TEXT_44 = NL + "\tme.prettyprint.hector.api.Cluster cluster_";
  protected final String TEXT_45 = " = me.prettyprint.hector.api.factory.HFactory.getOrCreateCluster(\"cluster_";
  protected final String TEXT_46 = "_\"+pid,hosts_";
  protected final String TEXT_47 = ",credentials_";
  protected final String TEXT_48 = ");" + NL + "\tif (cluster_";
  protected final String TEXT_49 = NL + "            .getConnectionManager().getHosts().isEmpty()) {" + NL + "        throw new Exception(\"Cannot connect to the server: \" + hostIps_";
  protected final String TEXT_50 = ");" + NL + "    }" + NL + "" + NL + "\tglobalMap.put(\"cluster_";
  protected final String TEXT_51 = "\", cluster_";
  protected final String TEXT_52 = ");" + NL + "    \t";
  protected final String TEXT_53 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    stringBuffer.append(TEXT_2);
    
//TODO: use API_SELECTED instead of this
class API_selector{
	public boolean useDatastax(INode node){
		String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
        String apiType = ElementParameterParser.getValue(node, "__API_TYPE__");
        return "CASSANDRA_2_0_0".equals(dbVersion) && "DATASTAX".equals(apiType); 
	}
}	

    
    if((new API_selector()).useDatastax(node)){
    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    
    String host = ElementParameterParser.getValue(node,"__HOST__");
    String port = ElementParameterParser.getValue(node,"__PORT__");
    String userName = ElementParameterParser.getValue(node, "__USERNAME__");
    String passWord = ElementParameterParser.getPasswordValue(node, "__PASSWORD__");
	boolean authentication= ElementParameterParser.getBooleanValue(node, "__REQUIRED_AUTHENTICATION__");
    
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_9);
    
                                                            	if(authentication){
                                                            	
    stringBuffer.append(TEXT_10);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(passWord);
    stringBuffer.append(TEXT_12);
    
                                                            	}
                                                            	
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
    }else{
    
    stringBuffer.append(TEXT_21);
    stringBuffer.append(TEXT_22);
    
    String host = ElementParameterParser.getValue(node,"__HOST__");
    String port = ElementParameterParser.getValue(node,"__PORT__");
    //String cluster= ElementParameterParser.getValue(node, "__CLUSTER__");
    String userName = ElementParameterParser.getValue(node, "__USERNAME__");
    String passWord = ElementParameterParser.getValue(node, "__PASSWORD__");
	boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
	
	
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
	if (authentication){
	
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_33);
    
        String passwordFieldName = "__PASSWORD__";
        
    stringBuffer.append(TEXT_34);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_37);
    } else {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
	}
	
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    return stringBuffer.toString();
  }
}
