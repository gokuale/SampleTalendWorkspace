package org.talend.designer.codegen.translators.machinelearning;

import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TMahoutClusteringMrconfigJava
{
  protected static String nl;
  public static synchronized TMahoutClusteringMrconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMahoutClusteringMrconfigJava result = new TMahoutClusteringMrconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + NL + NL + "\t";
  protected final String TEXT_2 = "//end a" + NL + "\t" + NL + "\t//tmp_output_path : the path of a temp file(for resaving the res of tMahoutClustering) which create in mrconfig, then will be read in mrcode and delete in mrjobfooter." + NL + "\tfinal String ";
  protected final String TEXT_3 = "_tmp_output_path = \"";
  protected final String TEXT_4 = "_tmp_out.clusters\";" + NL + "\t" + NL + "\tclass MahoutClusteringThread implements Runnable {" + NL + "" + NL + "\t\tpublic void run() {" + NL + "" + NL + "\t\t\t// get the -libjars of talend MR job" + NL + "\t\t\tStringBuilder sb_old_libJars = new StringBuilder();" + NL + "\t\t\ttry {" + NL + "\t\t\t\tjava.net.URL[] oldLibJars = org.apache.hadoop.util.GenericOptionsParser.getLibJars(getConf());" + NL + "\t\t\t\tfor (int i = 0; i < oldLibJars.length; i++) {" + NL + "\t\t\t\t\tsb_old_libJars.append(\",\");" + NL + "\t\t\t\t\tsb_old_libJars.append(oldLibJars[i].getPath().toString());" + NL + "\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t} catch (IOException e1) {" + NL + "\t\t\t\te1.printStackTrace();" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t//send .jars (jars for MahoutClustering MR job + jars for talend MR job)" + NL + "\t\t\tString libJars = \"-libjars=\"" + NL + "\t\t\t\t    + org.talend.dataquality.hadoop.JarUtils.getJarPath(org.apache.mahout.math.Vector.class)" + NL + "\t\t\t\t    + \",\"" + NL + "\t\t\t\t    + org.talend.dataquality.hadoop.JarUtils.getJarPath(org.apache.mahout.math.VectorWritable.class)" + NL + "\t\t\t\t    + \",\"" + NL + "\t\t\t\t    + org.talend.dataquality.hadoop.JarUtils.getJarPath(org.uncommons.maths.random.RandomDotOrgSeedGenerator.class)" + NL + "\t\t\t\t    + \",\"" + NL + "\t\t\t\t    + org.talend.dataquality.hadoop.JarUtils" + NL + "\t\t\t\t\t    .getJarPath(org.apache.mahout.clustering.classify.ClusterClassifierSpe.class) " + NL + "\t\t\t\t    + sb_old_libJars.toString();" + NL + "" + NL + "" + NL + "\t\t\tString[] commonOpts = { libJars," + NL + "\t\t\t\t\t\t\"--input\", ";
  protected final String TEXT_5 = "," + NL + "\t\t\t\t\t\t\"--output\", ";
  protected final String TEXT_6 = "_tmp_output_path," + NL + "\t\t\t\t\t\t\"--clustersDir\", \"";
  protected final String TEXT_7 = "_tmp_\" + System.currentTimeMillis()," + NL + "\t\t\t\t\t\t\"--colsFormat\", \"";
  protected final String TEXT_8 = "\"," + NL + "\t\t\t\t\t\t\"--colsSeparator\", ";
  protected final String TEXT_9 = "," + NL + "\t\t\t\t\t\t\"--distanceMeasure\", \"";
  protected final String TEXT_10 = "\"" + NL + "\t\t\t};" + NL + "" + NL + "\t\t\t// Select Clustering options" + NL + "\t\t\torg.talend.datascience.mahout.clustering.TalendJob jobMahout;" + NL + "\t\t\tString[] clOpts;" + NL + "" + NL + "\t\t" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\tString[] tmpOpts = {" + NL + "\t\t\t\t\t\"--t1\", \"";
  protected final String TEXT_12 = "\"," + NL + "\t\t\t\t\t\"--t2\", \"";
  protected final String TEXT_13 = "\"" + NL + "\t\t\t\t};" + NL + "\t\t\t\tclOpts = tmpOpts;" + NL + "\t\t\t\tjobMahout = new org.talend.datascience.mahout.clustering.TalendCanopyJob(); " + NL + "\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\tString[] tmpOpts = {" + NL + "\t\t\t\t\t\"--numClusters\", \"";
  protected final String TEXT_15 = "\"," + NL + "\t\t\t\t\t\"--maxIter\", \"";
  protected final String TEXT_16 = "\"," + NL + "\t\t\t\t\t\"--convergenceDelta\", \"";
  protected final String TEXT_17 = "\"" + NL + "\t\t\t\t};" + NL + "\t\t\t\tclOpts = tmpOpts;" + NL + "\t\t\t\tjobMahout = new org.talend.datascience.mahout.clustering.TalendKMeansJob();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tString[] tmpOpts = {" + NL + "\t\t\t\t\t\"--numClusters\", \"";
  protected final String TEXT_19 = "\"," + NL + "\t\t\t\t\t\"--maxIter\", \"";
  protected final String TEXT_20 = "\"," + NL + "\t\t\t\t\t\"--convergenceDelta\", \"";
  protected final String TEXT_21 = "\"," + NL + "\t\t\t\t\t\"-m\", \"";
  protected final String TEXT_22 = "\"" + NL + "\t\t\t\t};" + NL + "\t\t\t\tclOpts = tmpOpts;" + NL + "\t\t\t\tjobMahout = new org.talend.datascience.mahout.clustering.TalendFuzzyKMeansJob();" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tString[] tmpOpts = {" + NL + "\t\t\t\t\t\"--numClusters\", \"";
  protected final String TEXT_24 = "\"," + NL + "\t\t\t\t\t\"--maxIter\", \"";
  protected final String TEXT_25 = "\"," + NL + "\t\t\t\t\t\"--alpha\", \"";
  protected final String TEXT_26 = "\"" + NL + "\t\t\t\t};" + NL + "\t\t\t\tclOpts = tmpOpts;" + NL + "\t\t\t\tjobMahout = new org.talend.datascience.mahout.clustering.TalendDirichletJob();" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + NL + "\t\t\tString[] opts = new String[commonOpts.length + clOpts.length];" + NL + "\t\t\tSystem.arraycopy(commonOpts, 0, opts, 0, commonOpts.length);" + NL + "\t\t\tSystem.arraycopy(clOpts, 0, opts, commonOpts.length, clOpts.length);" + NL + "\t" + NL + "\t\t\t// set path separator (should be \":\" because namenodes are linux" + NL + "\t\t\t// machines)" + NL + "\t\t\tString oldPathSepProp_tMahoutClustering_1 = System.getProperty(\"path.separator\");" + NL + "\t\t\tSystem.setProperty(\"path.separator\", \":\");" + NL + "" + NL + "\t\t\t//get config hadoop" + NL + "\t\t\torg.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_28 = " = getConf();" + NL + "\t\t\t" + NL + "\t\t\ttry {" + NL + "\t\t\t\torg.apache.hadoop.util.ToolRunner.run(conf_";
  protected final String TEXT_29 = ", jobMahout, opts);" + NL + "\t\t\t} catch (Exception e) {" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tSystem.setProperty(\"path.separator\", oldPathSepProp_tMahoutClustering_1);" + NL + "" + NL + "\t\t}//end public void run()" + NL + "\t}//end class mahoutClusteringThread implements Runnable" + NL + "" + NL + "\t" + NL + "\tMahoutClusteringThread threadMahout = new MahoutClusteringThread();" + NL + "\tthreadMahout.run();" + NL + "\t" + NL + "" + NL + "\t";
  protected final String TEXT_30 = NL + "\t\t\tMultipleInputs.addInputPath(job, ";
  protected final String TEXT_31 = "StructInputFormat.class, ChainMapper.class, \"";
  protected final String TEXT_32 = "\");" + NL + "\t\t\tchainMapper.setCid(\"";
  protected final String TEXT_33 = "\");" + NL + "\t\t\t";
  protected final String TEXT_34 = "//end b" + NL + "" + NL + "" + NL + "\t";
  protected final String TEXT_35 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    //a
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();

		String inputPath = (String)ElementParameterParser.getObjectValue(node,"__INPUT_HDFS_FILENAME__");
		String colsSeparator = (String)ElementParameterParser.getObjectValue(node,"__FIELDSEPARATOR__");

		String colsFormat = "";
		List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			IMetadataTable metadata = metadatas.get(0);
			if (metadata!=null) {
				List<Map<String, String>> clusterCols = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CLUSTER_COLUMNS__");
				for (IMetadataColumn col : metadata.getListColumns()) {
		
					if(!col.getLabel().equals("clusterID")){// input without the last column : clusterID

						String usage = "N";
						for (Map<String, String> clCol : clusterCols) {
							if (col.getLabel().equals(clCol.get("INPUT_COLUMN")) ) {
								usage = "U";
								break;
							}
						}

						colsFormat += usage;
					}
			
				} // for columns
			}
		}
		String clusterType = ElementParameterParser.getValue(node, "__CLUSTERING_TYPE__");
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(inputPath);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(colsFormat);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(colsSeparator);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DISTANCE_MEASURE__"));
    stringBuffer.append(TEXT_10);
     if (clusterType.equals("CANOPY")) { 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CANOPY_T1__"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CANOPY_T2__"));
    stringBuffer.append(TEXT_13);
     } else if (clusterType.equals("KMEANS")) { 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getValue(node, "__NUM_CLUSTERS__"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MAX_ITERATIONS__"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CONVERGENCE_DELTA__"));
    stringBuffer.append(TEXT_17);
     } else if (clusterType.equals("FUZZYKMEANS")) { 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(ElementParameterParser.getValue(node, "__NUM_CLUSTERS__"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MAX_ITERATIONS__"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CONVERGENCE_DELTA__"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FUZZINESS__"));
    stringBuffer.append(TEXT_22);
     } else if (clusterType.equals("DIRICHLET")) { 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(ElementParameterParser.getValue(node, "__NUM_CLUSTERS__"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MAX_ITERATIONS__"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ALPHA0__"));
    stringBuffer.append(TEXT_26);
     } 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    //b


	//define the "outConns": Outgoing Connections
	List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();

	//begin of Outgoing Connections
	if(outConns != null && outConns.size() > 0){
	
		IConnection conn =outConns.get(0);
		String outConnName = conn.getName();
		if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){

			
    stringBuffer.append(TEXT_30);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
		}

	}else{//Outgoing Connections null
		System.out.println("outConns == null or outConns.size() <= 0");
	}
	//end of Outgoing Connections
	
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}
