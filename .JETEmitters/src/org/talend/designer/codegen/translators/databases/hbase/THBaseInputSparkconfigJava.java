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

public class THBaseInputSparkconfigJava
{
  protected static String nl;
  public static synchronized THBaseInputSparkconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseInputSparkconfigJava result = new THBaseInputSparkconfigJava();
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
  protected final String TEXT_8 = NL + "            org.apache.spark.api.java.JavaPairRDD<NullWritable, ";
  protected final String TEXT_9 = "> rdd_";
  protected final String TEXT_10 = " = ctx.hadoopRDD(job, ";
  protected final String TEXT_11 = "InputFormat_";
  protected final String TEXT_12 = ".class, NullWritable.class, ";
  protected final String TEXT_13 = ".class);" + NL + "            org.apache.spark.api.java.JavaPairRDD<NullWritable, ";
  protected final String TEXT_14 = "> rdd_";
  protected final String TEXT_15 = " = rdd_";
  protected final String TEXT_16 = ".mapToPair(new IdentityMap_";
  protected final String TEXT_17 = "(job));";
  protected final String TEXT_18 = NL + "            // extract raw HBase cells" + NL + "            org.apache.spark.api.java.JavaPairRDD<NullWritable, ";
  protected final String TEXT_19 = "TemporaryStruct> rawRdd_";
  protected final String TEXT_20 = " = ctx.hadoopRDD(job, ";
  protected final String TEXT_21 = "StructInputFormat.class, NullWritable.class, ";
  protected final String TEXT_22 = "TemporaryStruct.class);" + NL + "" + NL + "            // extract rejected records" + NL + "            org.apache.spark.api.java.JavaPairRDD<NullWritable, ";
  protected final String TEXT_23 = "> rdd_";
  protected final String TEXT_24 = " = rawRdd_";
  protected final String TEXT_25 = ".flatMapToPair(new RejectMap_";
  protected final String TEXT_26 = "(job));";
  protected final String TEXT_27 = NL + "                    // extract raw HBase cells" + NL + "                    org.apache.spark.api.java.JavaPairRDD<NullWritable, ";
  protected final String TEXT_28 = "TemporaryStruct> rawRdd_";
  protected final String TEXT_29 = " = ctx.hadoopRDD(job, ";
  protected final String TEXT_30 = "StructInputFormat.class, NullWritable.class, ";
  protected final String TEXT_31 = "TemporaryStruct.class);" + NL + "" + NL + "                    // cast to avro structs" + NL + "                    org.apache.spark.api.java.JavaPairRDD<Boolean, org.apache.avro.specific.SpecificRecordBase> castedRdd_";
  protected final String TEXT_32 = " = rawRdd_";
  protected final String TEXT_33 = ".mapToPair(new CastMap_";
  protected final String TEXT_34 = "(job));" + NL + "" + NL + "                    // Main flow" + NL + "                    org.apache.spark.api.java.JavaPairRDD<NullWritable, ";
  protected final String TEXT_35 = "> rdd_";
  protected final String TEXT_36 = " = castedRdd_";
  protected final String TEXT_37 = ".filter(new ";
  protected final String TEXT_38 = "TrueFilter()).mapToPair(new ";
  protected final String TEXT_39 = "ToNullWritableMain(job));" + NL + "" + NL + "                    // Reject flow" + NL + "                    org.apache.spark.api.java.JavaPairRDD<NullWritable, ";
  protected final String TEXT_40 = "> rdd_";
  protected final String TEXT_41 = " = castedRdd_";
  protected final String TEXT_42 = ".filter(new ";
  protected final String TEXT_43 = "FalseFilter()).mapToPair(new ";
  protected final String TEXT_44 = "ToNullWritableReject(job));";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
INode configurationNode = null;
String configurationNodeName = ElementParameterParser.getValue(node,"__STORAGE_CONFIGURATION__");

for (INode pNode : node.getProcess().getNodesOfType("tHBaseConfiguration")) {
    if(configurationNodeName!=null && configurationNodeName.equals(pNode.getUniqueName())) {
        configurationNode = pNode;
    }else{
        return "";
    }
}

if(metadatas!=null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    if(metadata != null){
        String zookeeperUrl = ElementParameterParser.getValue(configurationNode,"__ZOOKEEPER_QUORUM__");
        String zookeeperPort = ElementParameterParser.getValue(configurationNode,"__ZOOKEEPER_CLIENT_PORT__");
        String table_name = ElementParameterParser.getValue(node, "__TABLE__");
        List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
        List< ? extends IConnection> mainConnections = node.getOutgoingConnections("FLOW");
        List< ? extends IConnection> rejectedConnections = node.getOutgoingConnections("REJECT");

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

        // Fail fast when no output connections exist.
        if (conns == null || conns.size() == 0)
            return "";

        // Only main flow
       if ((mainConnections.size() == 1) && (rejectedConnections.size() == 0)) {
            IConnection mainConnection = mainConnections.get(0);
            String connName = mainConnection.getName();
            String outStruct = codeGenArgument.getRecordStructName(mainConnection);
            //Note: Because Hadoop's RecordReader class re-uses the same Writable object for each record, directly caching the returned RDD or directly passing it to an aggregation or shuffle operation will create many references to the same object. If you plan to directly cache, sort, or aggregate Hadoop writable objects, you should first copy them using a map function.
            
    stringBuffer.append(TEXT_8);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
        }
        // Only reject flow
        else if((mainConnections.size() == 0) && (rejectedConnections.size() == 1)){
            IConnection rejectedConnection = rejectedConnections.get(0);
            String rejectConnName = rejectedConnection.getName();
            String rejectOutStruct = codeGenArgument.getRecordStructName(rejectedConnection);
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
        }
        else {
            // Main and reject flows
            if ((mainConnections != null) && (mainConnections.size() == 1)
                    && (rejectedConnections != null) && (rejectedConnections.size() == 1)) {
                IConnection mainConnection = mainConnections.get(0);
                String mainConnName = mainConnection.getName();
                String mainOutStruct = codeGenArgument.getRecordStructName(mainConnection);
                IConnection rejectedConnection = rejectedConnections.get(0);
                String rejectConnName = rejectedConnection.getName();
                String rejectOutStruct = codeGenArgument.getRecordStructName(rejectedConnection);

    stringBuffer.append(TEXT_27);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(mainConnName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
            }
        }
    }
}

    return stringBuffer.toString();
  }
}
