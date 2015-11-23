package org.talend.designer.codegen.translators.databases.hbase;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class THBaseInputMrconfigJava
{
  protected static String nl;
  public static synchronized THBaseInputMrconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseInputMrconfigJava result = new THBaseInputMrconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    job.set(\"hbase.master.kerberos.principal\", ";
  protected final String TEXT_2 = ");" + NL + "    job.set(\"hbase.regionserver.kerberos.principal\", ";
  protected final String TEXT_3 = ");" + NL + "    job.set(\"hbase.security.authorization\", \"true\");" + NL + "    job.set(\"hbase.security.authentication\", \"kerberos\");" + NL + "    job.set(\"hbase.zookeeper.quorum\", ";
  protected final String TEXT_4 = ");" + NL + "    job.set(\"hbase.zookeeper.property.clientPort\", ";
  protected final String TEXT_5 = ");" + NL;
  protected final String TEXT_6 = NL + "        org.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_7 = NL + "                ";
  protected final String TEXT_8 = ", ";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "    // Get MapReduce job authentication token from HBase" + NL + "    org.apache.hadoop.hbase.security.token.TokenUtil.obtainTokenForJob(job," + NL + "            org.apache.hadoop.security.UserGroupInformation.getCurrentUser());";
  protected final String TEXT_11 = NL + "MultipleInputs.addInputPath(job, ";
  protected final String TEXT_12 = "InputFormat.class," + NL + "        ChainMapper.class," + NL + "        \"";
  protected final String TEXT_13 = "\");" + NL + "chainMapper.setCid(\"";
  protected final String TEXT_14 = "\");";
  protected final String TEXT_15 = NL + "    chainMapper.addMapper(job, ";
  protected final String TEXT_16 = "_InputMapper.class," + NL + "        NullWritable.class, ";
  protected final String TEXT_17 = "TemporaryStruct.class," + NL + "        NullWritable.class, ";
  protected final String TEXT_18 = "Struct.class," + NL + "        true, new JobConf(false));" + NL + "" + NL + "    MultipleOutputs.setWorkDir(job," + NL + "            genTempFolderForComponent(\"";
  protected final String TEXT_19 = "\"));" + NL + "    MultipleOutputs.setKeyValue(job, \"";
  protected final String TEXT_20 = "\"," + NL + "            NullWritable.class, ";
  protected final String TEXT_21 = "Struct.class);" + NL;
  protected final String TEXT_22 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

// Fail fast when no output connections exist.
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
if (conns == null || conns.size() == 0)
    return "";

// Parameters
boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
String hbaseMasterPrincipal = ElementParameterParser.getValue(node, "__HBASE_MASTER_PRINCIPAL__");
String hbaseRegionServerPrincipal = ElementParameterParser.getValue(node, "__HBASE_REGIONSERVER_PRINCIPAL__");
String version = ElementParameterParser.getValue(node,"__HBASE_VERSION__");
String zookeeperQuorum = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
String zookeeperClientPort = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");

java.util.List<String> supportKrbVersionList = java.util.Arrays.<String>asList(
        "Cloudera_CDH4","Cloudera_CDH4_YARN","Cloudera_CDH5","Cloudera_CDH5_1","Cloudera_CDH5_4","Cloudera_CDH5_1_MR1",
        "HDP_1_2","HDP_1_3","HDP_2_0","HDP_2_1","HDP_2_2",
        "APACHE_1_0_0","APACHE_1_0_3_EMR",
        "PIVOTAL_HD_2_0");

// Get the output connections.
List< ? extends IConnection> rejConns = node.getOutgoingConnections("REJECT");
List< ? extends IConnection> mainConns = node.getOutgoingConnections("FLOW");
IConnection mainConn = mainConns == null || mainConns.size() == 0
        ? null : mainConns.get(0);
IConnection rejConn = rejConns == null || rejConns.size() == 0
        ? null : rejConns.get(0);

// Fail fast on bad main connection style.
if (mainConn != null && !mainConn.getLineStyle().hasConnectionCategory(
        IConnectionCategory.DATA)) {
    return "";
}

// Fail fast on no connections.
if (mainConn == null && rejConn == null) {
    return "";
}

// Add kerberos configuration for HBase if necessary.
if((version!=null && supportKrbVersionList.contains(version)) && useKrb){
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(hbaseMasterPrincipal);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(hbaseRegionServerPrincipal);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(zookeeperQuorum);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(zookeeperClientPort);
    stringBuffer.append(TEXT_5);
    
    if(useKeytab){
        
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_9);
    
    }
    
    stringBuffer.append(TEXT_10);
    
}


    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    

// If there is a main and a reject connection, the input format will wrap the
// rows into a generic object, and the mapper will separate them into multiple
// outputs.
if (mainConn != null && rejConn != null) {
    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(mainConn.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(mainConn.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(rejConn.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(rejConn.getName());
    stringBuffer.append(TEXT_21);
    
}

    stringBuffer.append(TEXT_22);
    return stringBuffer.toString();
  }
}
