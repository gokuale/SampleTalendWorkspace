package org.talend.designer.codegen.translators.databases.hbase;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class THBaseOutputSparkconfigJava
{
  protected static String nl;
  public static synchronized THBaseOutputSparkconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseOutputSparkconfigJava result = new THBaseOutputSparkconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "                    job.set(\"hbase.master.kerberos.principal\",";
  protected final String TEXT_2 = ");" + NL + "                    job.set(\"hbase.regionserver.kerberos.principal\",";
  protected final String TEXT_3 = ");" + NL + "                    job.set(\"hbase.security.authorization\",\"true\");" + NL + "                    job.set(\"hbase.security.authentication\",\"kerberos\");";
  protected final String TEXT_4 = NL + "                        org.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "                    // Get MapReduce job authentication token from Hbase" + NL + "                    org.apache.hadoop.hbase.security.token.TokenUtil.obtainTokenForJob(job, org.apache.hadoop.security.UserGroupInformation.getCurrentUser());";
  protected final String TEXT_8 = NL + "    job.setOutputFormat(";
  protected final String TEXT_9 = "StructOutputFormat.class);" + NL + "    rdd_";
  protected final String TEXT_10 = ".saveAsHadoopDataset(job);";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();
    INode configurationNode = null;
    String configurationNodeName = ElementParameterParser.getValue(node,"__STORAGE_CONFIGURATION__");

    for (INode pNode : node.getProcess().getNodesOfType("tHBaseConfiguration")) {
        if(configurationNodeName!=null && configurationNodeName.equals(pNode.getUniqueName())) {
            configurationNode = pNode;
        }else{
            return "";
        }
    }

// Input Connections
IConnection inMainCon = null;
java.util.List<? extends IConnection> connsIn = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
if (connsIn == null || connsIn.size() == 0 ){
    return "";
} else{
    inMainCon = connsIn.get(0);
}
final String incomingConnectionName = inMainCon.getName();
final String inConnTypeName = codeGenArgument.getRecordStructName(inMainCon);

	boolean useKrb = "true".equals(ElementParameterParser.getValue(configurationNode, "__USE_KRB__"));
    boolean useKeytab = "true".equals(ElementParameterParser.getValue(configurationNode, "__USE_KEYTAB__"));
    String userPrincipal = ElementParameterParser.getValue(configurationNode, "__PRINCIPAL__");
    String keytabPath = ElementParameterParser.getValue(configurationNode, "__KEYTAB_PATH__");
    String hbaseMasterPrincipal = ElementParameterParser.getValue(configurationNode, "__HBASE_MASTER_PRINCIPAL__");
    String hbaseRegionServerPrincipal = ElementParameterParser.getValue(configurationNode, "__HBASE_REGIONSERVER_PRINCIPAL__");
    String version = ElementParameterParser.getValue(configurationNode,"__HBASE_VERSION__");

    java.util.List<String> supportKrbVersionList = java.util.Arrays.<String>asList(
        "Cloudera_CDH4","Cloudera_CDH4_YARN","Cloudera_CDH5","Cloudera_CDH5_1","Cloudera_CDH5_1_MR1",
        "HDP_1_2","HDP_1_3","HDP_2_0","HDP_2_1","HDP_2_2",
        "APACHE_1_0_0","APACHE_1_0_3_EMR",
        "PIVOTAL_HD_2_0");

    
if((version!=null && supportKrbVersionList.contains(version)) && useKrb){
                
    stringBuffer.append(TEXT_1);
    stringBuffer.append(hbaseMasterPrincipal);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(hbaseRegionServerPrincipal);
    stringBuffer.append(TEXT_3);
    
                    if(useKeytab){
                
    stringBuffer.append(TEXT_4);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_6);
    
                    }
                
    stringBuffer.append(TEXT_7);
    
}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(incomingConnectionName);
    stringBuffer.append(TEXT_10);
    

    return stringBuffer.toString();
  }
}
