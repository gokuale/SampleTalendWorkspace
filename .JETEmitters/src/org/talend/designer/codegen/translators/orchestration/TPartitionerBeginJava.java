package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TPartitionerBeginJava
{
  protected static String nl;
  public static synchronized TPartitionerBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPartitionerBeginJava result = new TPartitionerBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "   ";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "    \tlog.info(\"";
  protected final String TEXT_4 = " - Use ";
  protected final String TEXT_5 = " to collect its data.\");";
  protected final String TEXT_6 = NL + "    \tlog.info(\"";
  protected final String TEXT_7 = " - Has ";
  protected final String TEXT_8 = " recollectors to start.\");";
  protected final String TEXT_9 = NL + "\t\tlog.info(\"";
  protected final String TEXT_10 = " - Use columns:\"" + NL + "\t\t";
  protected final String TEXT_11 = " + \"'";
  protected final String TEXT_12 = "'\"" + NL + "\t\t\t";
  protected final String TEXT_13 = " + \",'";
  protected final String TEXT_14 = "'\"" + NL + "\t\t\t";
  protected final String TEXT_15 = " + \" to partition data to ";
  protected final String TEXT_16 = " queues with each ";
  protected final String TEXT_17 = " capacity.\");" + NL + "\t";
  protected final String TEXT_18 = NL + "\t\tlog.info(\"";
  protected final String TEXT_19 = " - Partition data randomly to ";
  protected final String TEXT_20 = " queues with each ";
  protected final String TEXT_21 = " capacity.\");" + NL + "\t";
  protected final String TEXT_22 = NL + "globalMap.put(\"MULTI_THREADED_JOB_";
  protected final String TEXT_23 = "_\"+jobName, Boolean.TRUE);" + NL + "class TargetTask_";
  protected final String TEXT_24 = " extends org.talend.concurrent.ParallelTask {" + NL + "    public TargetTask_";
  protected final String TEXT_25 = "(java.util.Map<String, Object> m, org.talend.concurrent.LinkedBlockingQueue<? extends Object> q, int i) {" + NL + "    \tsuper(m,i, \"";
  protected final String TEXT_26 = "\",q);" + NL + "       /*mapInstance.put(\"";
  protected final String TEXT_27 = "_THREAD_ID\",i);" + NL + "       if (q != null) {" + NL + "       mapInstance.put(\"QUEUE_";
  protected final String TEXT_28 = "\",q);" + NL + "       }" + NL + "       mapInstance.put(\"FINISHED_";
  protected final String TEXT_29 = "\",Boolean.FALSE);" + NL + "    }" + NL + "    public void makeFinished() {" + NL + "       finished=true;" + NL + "       mapInstance.put(\"FINISHED_";
  protected final String TEXT_30 = "\",Boolean.TRUE);*/" + NL + "    }" + NL + "    " + NL + "    public void doWork() throws Exception {" + NL + "    \t";
  protected final String TEXT_31 = NL + "        ";
  protected final String TEXT_32 = "Process(mapInstance);" + NL + "    }" + NL + "}" + NL + "java.util.List<org.talend.concurrent.ParallelTask> tasks_";
  protected final String TEXT_33 = " = new java.util.ArrayList<org.talend.concurrent.ParallelTask>();" + NL + "" + NL + "" + NL + "String colStr_";
  protected final String TEXT_34 = " = System.getProperty(\"org.talend.parallel.collector\");" + NL + "boolean isCol_";
  protected final String TEXT_35 = " = colStr_";
  protected final String TEXT_36 = " != null && \"true\".equals(colStr_";
  protected final String TEXT_37 = ");" + NL + "" + NL + "if (isCol_";
  protected final String TEXT_38 = ") {" + NL + "\treturn;" + NL + "}\t" + NL + "" + NL + "if (";
  protected final String TEXT_39 = " >= Runtime.getRuntime().availableProcessors()) {" + NL + "\t";
  protected final String TEXT_40 = NL + "\t\tlog.error(\"";
  protected final String TEXT_41 = " - Using \"+ ";
  protected final String TEXT_42 = " + \" threads is greater than the available processors: \"+Runtime.getRuntime().availableProcessors()+\" and may adversely affect performance.\");" + NL + "\t";
  protected final String TEXT_43 = NL + "\tSystem.err.println(\"WARNING: Using \"+ ";
  protected final String TEXT_44 = " + \" threads is greater than the available processors: \"+Runtime.getRuntime().availableProcessors()+\" and may adversely affect performance.\");" + NL + "}" + NL;
  protected final String TEXT_45 = NL + "\torg.talend.concurrent.LinkedBlockingQueue<org.talend.concurrent.LinkedBlockingQueue<";
  protected final String TEXT_46 = "Struct>> queues_";
  protected final String TEXT_47 = " = new org.talend.concurrent.LinkedBlockingQueue<org.talend.concurrent.LinkedBlockingQueue<";
  protected final String TEXT_48 = "Struct>>(";
  protected final String TEXT_49 = ");" + NL + "\torg.talend.concurrent.LinkedBlockingQueue<java.util.Map<String,Object>> queueMaps_";
  protected final String TEXT_50 = " = new org.talend.concurrent.LinkedBlockingQueue<java.util.Map<String,Object>>(";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "    java.util.List<org.talend.concurrent.LinkedBlockingQueue<";
  protected final String TEXT_53 = "Struct>> list_";
  protected final String TEXT_54 = " = new java.util.ArrayList<org.talend.concurrent.LinkedBlockingQueue<";
  protected final String TEXT_55 = "Struct>> (";
  protected final String TEXT_56 = ");" + NL + "    java.util.List<java.util.Map<String,Object>> listMaps_";
  protected final String TEXT_57 = " = new java.util.ArrayList<java.util.Map<String,Object>>(";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + NL + NL + "\tjava.util.concurrent.ExecutorService rootEs_";
  protected final String TEXT_60 = " = java.util.concurrent.Executors.newFixedThreadPool(";
  protected final String TEXT_61 = "+";
  protected final String TEXT_62 = ");" + NL + "    org.talend.concurrent.TalendExecutorCompletionService<Object> es_";
  protected final String TEXT_63 = " = new org.talend.concurrent.TalendExecutorCompletionService<Object>(rootEs_";
  protected final String TEXT_64 = ");" + NL + "    java.util.List<java.util.concurrent.Future<Object>> futures_";
  protected final String TEXT_65 = " = new java.util.ArrayList<java.util.concurrent.Future<Object>>(";
  protected final String TEXT_66 = "+";
  protected final String TEXT_67 = ");" + NL + "    ";
  protected final String TEXT_68 = NL + "\tglobalMap.put(\"EXECUTOR_SERVICE_";
  protected final String TEXT_69 = "\",rootEs_";
  protected final String TEXT_70 = ");" + NL + "\tglobalMap.put(\"EXECUTOR_COMPLETION_SERVICE_";
  protected final String TEXT_71 = "\",es_";
  protected final String TEXT_72 = ");" + NL + "\tglobalMap.put(\"FUTURES_LIST_";
  protected final String TEXT_73 = "\",futures_";
  protected final String TEXT_74 = ");" + NL + "\tglobalMap.put(\"TASKS_";
  protected final String TEXT_75 = "\",tasks_";
  protected final String TEXT_76 = ");";
  protected final String TEXT_77 = NL + NL + "//put the maps into a list so that lookups can self-auto-propagate the data around to one another." + NL + "java.util.List<java.util.Map<String, Object>> mapsList_";
  protected final String TEXT_78 = "= new java.util.ArrayList<java.util.Map<String, Object>>(";
  protected final String TEXT_79 = ");" + NL + "globalMap.put(\"THREAD_MAPS_";
  protected final String TEXT_80 = "_\"+jobName,mapsList_";
  protected final String TEXT_81 = ");" + NL + "globalMap.put(\"TASKS_";
  protected final String TEXT_82 = "\",tasks_";
  protected final String TEXT_83 = ");\t" + NL + "for (int i = 0; i < ";
  protected final String TEXT_84 = "; i++) {" + NL + "    org.talend.concurrent.LinkedBlockingQueue<";
  protected final String TEXT_85 = "Struct> tmp_";
  protected final String TEXT_86 = " = new org.talend.concurrent.LinkedBlockingQueue<";
  protected final String TEXT_87 = "Struct>(";
  protected final String TEXT_88 = ");" + NL + "    ";
  protected final String TEXT_89 = NL + "    ";
  protected final String TEXT_90 = "_";
  protected final String TEXT_91 = ".add(tmp_";
  protected final String TEXT_92 = ");" + NL + "\t" + NL + "\tjava.util.Map<String, Object> map_";
  protected final String TEXT_93 = "= java.util.Collections.synchronizedMap(new java.util.HashMap<String, Object>(" + NL + "\t\t\t\t\t\t\tglobalMap));" + NL + "\t//since lookups are going to try to be executed to overwrite what's already been" + NL + "\t//written we're going to add a copy of globalMap to it so that we can replace them" + NL + "\t//with the original value(s)" + NL + "\tmap_";
  protected final String TEXT_94 = ".put(\"BACKUP_GLOBAL_MAP_";
  protected final String TEXT_95 = "\",java.util.Collections.synchronizedMap(new java.util.HashMap<String, Object>(" + NL + "\t\t\t\t\t\t\tglobalMap)));" + NL + "\t" + NL + "\tmapsList_";
  protected final String TEXT_96 = ".add(map_";
  protected final String TEXT_97 = ");" + NL + "\t";
  protected final String TEXT_98 = "Maps_";
  protected final String TEXT_99 = ".add(map_";
  protected final String TEXT_100 = ");" + NL + "\tTargetTask_";
  protected final String TEXT_101 = " task_";
  protected final String TEXT_102 = " = new TargetTask_";
  protected final String TEXT_103 = "(map_";
  protected final String TEXT_104 = ", tmp_";
  protected final String TEXT_105 = ", i);" + NL + "\ttasks_";
  protected final String TEXT_106 = ".add(task_";
  protected final String TEXT_107 = ");" + NL + "}" + NL + "" + NL + "for (int i = 0; i < ";
  protected final String TEXT_108 = "; i++) {" + NL + "\torg.talend.concurrent.ParallelTask task_";
  protected final String TEXT_109 = " = tasks_";
  protected final String TEXT_110 = ".get(i);" + NL + "\tfutures_";
  protected final String TEXT_111 = ".add(es_";
  protected final String TEXT_112 = ".submit(task_";
  protected final String TEXT_113 = "));" + NL + "}" + NL + "" + NL + "" + NL + "boolean forceStop_";
  protected final String TEXT_114 = " = false;" + NL + "" + NL + "resourceMap.put(\"tasks_";
  protected final String TEXT_115 = "\", tasks_";
  protected final String TEXT_116 = ");" + NL + "resourceMap.put(\"futures_";
  protected final String TEXT_117 = "\", futures_";
  protected final String TEXT_118 = ");" + NL + "resourceMap.put(\"rootEs_";
  protected final String TEXT_119 = "\", rootEs_";
  protected final String TEXT_120 = ");" + NL + "resourceMap.put(\"es_";
  protected final String TEXT_121 = "\", es_";
  protected final String TEXT_122 = ");" + NL + "" + NL + "int counter_";
  protected final String TEXT_123 = " = 0;";
  protected final String TEXT_124 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    boolean hashPartitioner = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__HASH_PARTITION__"));
    String queueSize = ElementParameterParser.getValue(node,"__QUEUE_SIZE__");
    String destStartComp = null;
    
    String numPartitions = ElementParameterParser.getValue(node, "__NUM_PARTITIONS__");
    
    boolean startRecollector = false;
    boolean warnRecoll = false;
    List<String> recs = new ArrayList<String>();
    List<? extends IConnection> startsConns = node.getOutgoingConnections(EConnectionType.STARTS);
    for (int i = 0; i < startsConns.size(); i++) {
    	IConnection conn = startsConns.get(i);
    	INode target = conn.getTarget();
    	if (target.getUniqueName().startsWith("tCollector") && destStartComp == null) {
    		destStartComp = target.getUniqueName();
    	} else if (target.getUniqueName().startsWith("tRecollector")) {
    		startRecollector = true;
    		recs.add(target.getUniqueName());
    	}
    }
    
    String connName = null;
    if (node.getIncomingConnections().size() == 1) {    
        IConnection conn = node.getIncomingConnections().get(0);
        connName = conn.getName();
    }
/*
    int recollTaskCount = 0;
    List<? extends INode> listRecoll= node.getProcess().getNodesOfType("tRecollector");
	if (listRecoll!=null && listRecoll.size() > 0 ) {
		recollTaskCount = listRecoll.size();
	}

	boolean hasMultiPartitioner = false;
	List<? extends INode> listPartitioner= node.getProcess().getNodesOfType("tPartitioner");
	if (listPartitioner != null && listPartitioner.size() > 1 ) {
		hasMultiPartitioner = true; // has multiple tPartitioner components in the same process
	}
*/
	List<String> recollectors = new ArrayList<String>();
	NodeUtil.getRecollectorsFromPartitioner(node,recollectors);
	int recollTaskCount = recollectors.size();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    
   //a slight change to what the value of destStartComp is and this particular chunk of code
   //can be used to start any subjob, kind of the way Parallelize links do. 

    stringBuffer.append(TEXT_1);
    
if(isLog4jEnabled){

    stringBuffer.append(TEXT_2);
    
	if (destStartComp !=null) {
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(destStartComp );
    stringBuffer.append(TEXT_5);
    
    }
    if (recollectors.size() > 0){
    
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(recollTaskCount);
    stringBuffer.append(TEXT_8);
    
    }
    if (hashPartitioner) { // use hash partitioner
    	List<Map<String,String>> hashKeys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__HASH_KEYS__");
		
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
    	for (int i = 0; i < hashKeys.size(); i++) {
    		if (i == 0) {
			
    stringBuffer.append(TEXT_11);
    stringBuffer.append(hashKeys.get(i).get("KEY_COLUMN") );
    stringBuffer.append(TEXT_12);
    
			} else {
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(hashKeys.get(i).get("KEY_COLUMN") );
    stringBuffer.append(TEXT_14);
    
			}
    	}
		
    stringBuffer.append(TEXT_15);
    stringBuffer.append(numPartitions );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(queueSize);
    stringBuffer.append(TEXT_17);
    
    } else {
	
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(numPartitions );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(queueSize);
    stringBuffer.append(TEXT_21);
    
    }
}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(destStartComp);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(destStartComp);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(destStartComp);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(destStartComp);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(destStartComp);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(destStartComp);
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
    stringBuffer.append(numPartitions);
    stringBuffer.append(TEXT_39);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(numPartitions);
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(numPartitions);
    stringBuffer.append(TEXT_44);
    
if (!hashPartitioner) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(numPartitions);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(numPartitions);
    stringBuffer.append(TEXT_51);
     
} else { 

    stringBuffer.append(TEXT_52);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(numPartitions);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(numPartitions);
    stringBuffer.append(TEXT_58);
     
}

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(numPartitions);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(recollTaskCount);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(numPartitions);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(recollTaskCount);
    stringBuffer.append(TEXT_67);
    
//have to propagate ES and futures for departitioner to grab
if (recollTaskCount > 0) {

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
}

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(numPartitions);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(numPartitions);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(queueSize);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(hashPartitioner ? "list" : "queues");
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(hashPartitioner ? "list" : "queue");
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
    stringBuffer.append(numPartitions);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
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
    stringBuffer.append(TEXT_124);
    return stringBuffer.toString();
  }
}
