package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IProcess;
import java.util.List;
import java.util.Map;

public class TPartitionerMainJava
{
  protected static String nl;
  public static synchronized TPartitionerMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPartitionerMainJava result = new TPartitionerMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "    StringBuffer log4jSb_";
  protected final String TEXT_3 = " = new StringBuffer();" + NL + "\t";
  protected final String TEXT_4 = NL + NL + "\t";
  protected final String TEXT_5 = "Struct copy_";
  protected final String TEXT_6 = " = new ";
  protected final String TEXT_7 = "Struct();";
  protected final String TEXT_8 = "\t\t" + NL + "       copy_";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = ";" + NL + "\t\t";
  protected final String TEXT_13 = NL + "\t\tlog4jSb_";
  protected final String TEXT_14 = ".append(copy_";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = ");" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_18 = ".append(\"|\");\t\t\t\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_20 = " - Partition the record : \" + log4jSb_";
  protected final String TEXT_21 = " + \" .\");";
  protected final String TEXT_22 = NL + "    String key_";
  protected final String TEXT_23 = " = \"\" " + NL + "\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t+ ";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = " + \"_\" +String.valueOf(";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = ").length()" + NL + "\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\t\t+ \"_\" " + NL + "\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t;" + NL + "\tjava.util.zip.CRC32 crc32_";
  protected final String TEXT_31 = " = new java.util.zip.CRC32();" + NL + "\tcrc32_";
  protected final String TEXT_32 = ".update(key_";
  protected final String TEXT_33 = ".getBytes());" + NL + "\tLong hash_";
  protected final String TEXT_34 = " = new Long(crc32_";
  protected final String TEXT_35 = ".getValue());\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_36 = NL + "\t  \t\t" + NL + "\t  \t\tString key_";
  protected final String TEXT_37 = " = \"\";" + NL + "\t  \t\t";
  protected final String TEXT_38 = NL + "\t  \t\t\t//";
  protected final String TEXT_39 = NL + "\t  \t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\t\tkey_";
  protected final String TEXT_41 = " = key_";
  protected final String TEXT_42 = " + ";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = " + \"_\" +String.valueOf(";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = ").length()" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\t\t\t+ \"_\" " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\t;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\t\t\t\t\tkey_";
  protected final String TEXT_50 = " = key_";
  protected final String TEXT_51 = "+\"_\";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\t\t\t\tkey_";
  protected final String TEXT_53 = " = key_";
  protected final String TEXT_54 = " + ";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = " + \"_\" + String.valueOf(";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = ").toString().length();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t" + NL + "\t\tjava.util.zip.CRC32 crc32_";
  protected final String TEXT_60 = " = new java.util.zip.CRC32();" + NL + "\t\tcrc32_";
  protected final String TEXT_61 = ".update(key_";
  protected final String TEXT_62 = ".getBytes());" + NL + "\t\tLong hash_";
  protected final String TEXT_63 = " = new Long(crc32_";
  protected final String TEXT_64 = ".getValue());" + NL + "\t\t";
  protected final String TEXT_65 = NL + "\t  \t\tjava.util.zip.CRC32 crc32_";
  protected final String TEXT_66 = " = new java.util.zip.CRC32();" + NL + "\t\t\tcrc32_";
  protected final String TEXT_67 = ".update(";
  protected final String TEXT_68 = ".toString().getBytes());" + NL + "\t\t\tLong hash_";
  protected final String TEXT_69 = " = new Long(crc32_";
  protected final String TEXT_70 = ".getValue());" + NL + "\t  \t\t";
  protected final String TEXT_71 = NL + "\torg.talend.concurrent.LinkedBlockingQueue<";
  protected final String TEXT_72 = "Struct> queue_";
  protected final String TEXT_73 = " = queues_";
  protected final String TEXT_74 = ".poll();" + NL + "\tjava.util.Map<String, Object> map_";
  protected final String TEXT_75 = " = queueMaps_";
  protected final String TEXT_76 = ".poll();" + NL + "\tint offerCounter_";
  protected final String TEXT_77 = " = 0;" + NL + "\twhile (!queue_";
  protected final String TEXT_78 = ".offer(copy_";
  protected final String TEXT_79 = ")) {" + NL + "\t\tofferCounter_";
  protected final String TEXT_80 = "++;" + NL + "\t\tif ((offerCounter_";
  protected final String TEXT_81 = " % 500) == 0) {" + NL + "\t\t\tif (map_";
  protected final String TEXT_82 = ".get(\"HAS_ERROR\") != null) {" + NL + "\t\t\t\tforceStop_";
  protected final String TEXT_83 = " = true;" + NL + "\t\t\t\tthrow new RuntimeException(\"Exception\", (Throwable)map_";
  protected final String TEXT_84 = ".get(\"HAS_ERROR\"));" + NL + "\t\t\t}" + NL + "\t\t\tif (map_";
  protected final String TEXT_85 = ".get(\"THREADS_HAVE_ERROR\") != null) {" + NL + "\t\t\t\tforceStop_";
  protected final String TEXT_86 = " = true;" + NL + "\t\t\t\tthrow new RuntimeException(\"Exception\",(Throwable)map_";
  protected final String TEXT_87 = ".get(\"THREADS_HAVE_ERROR\"));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t} " + NL + "" + NL + "\tqueues_";
  protected final String TEXT_88 = ".add(queue_";
  protected final String TEXT_89 = ");" + NL + "\tqueueMaps_";
  protected final String TEXT_90 = ".add(map_";
  protected final String TEXT_91 = ");" + NL + "\t";
  protected final String TEXT_92 = NL + "\tint offerCounter_";
  protected final String TEXT_93 = " = 0;" + NL + "\tint hashPartition_";
  protected final String TEXT_94 = " = (int)(hash_";
  protected final String TEXT_95 = " % ";
  protected final String TEXT_96 = ");" + NL + "\twhile (!list_";
  protected final String TEXT_97 = ".get(hashPartition_";
  protected final String TEXT_98 = ").offer(copy_";
  protected final String TEXT_99 = ")) {" + NL + "\t\tofferCounter_";
  protected final String TEXT_100 = "++;" + NL + "\t\tif ((offerCounter_";
  protected final String TEXT_101 = " % 500) == 0) {" + NL + "\t\t\tif (listMaps_";
  protected final String TEXT_102 = ".get(hashPartition_";
  protected final String TEXT_103 = ").get(\"HAS_ERROR\") != null) {" + NL + "\t\t\t\tforceStop_";
  protected final String TEXT_104 = " = true;" + NL + "\t\t\t\tthrow new RuntimeException(\"Exception\",(Throwable)listMaps_";
  protected final String TEXT_105 = ".get(hashPartition_";
  protected final String TEXT_106 = ").get(\"HAS_ERROR\"));" + NL + "\t\t\t}" + NL + "\t\t\tif (listMaps_";
  protected final String TEXT_107 = ".get(hashPartition_";
  protected final String TEXT_108 = ").get(\"THREADS_HAVE_ERROR\") != null) {" + NL + "\t\t\t\tforceStop_";
  protected final String TEXT_109 = " = true;" + NL + "\t\t\t\tthrow new RuntimeException(\"Exception\",(Throwable)listMaps_";
  protected final String TEXT_110 = ".get(hashPartition_";
  protected final String TEXT_111 = ").get(\"THREADS_HAVE_ERROR\"));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_112 = NL + "    counter_";
  protected final String TEXT_113 = "++;" + NL + "\t" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    boolean hashPartitioner = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__HASH_PARTITION__"));
	List<Map<String,String>> hashKeys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__HASH_KEYS__");	
    INode src = null;
    IProcess process = node.getProcess();
    boolean found = false;
    String numPartitions = ElementParameterParser.getValue(node,"__NUM_PARTITIONS__");
    
    String destinationColl = null;
    INode dest = null;
    String connName = null;
    if (node.getIncomingConnections().size() == 1) {    
        IConnection conn = node.getIncomingConnections().get(0);
        connName = conn.getName();
    }
    found = false;
    List<? extends IConnection> startsConns = node.getOutgoingConnections(EConnectionType.STARTS);
    for (int i = 0; i < startsConns.size(); i++) {
    	IConnection conn = startsConns.get(i);
    	INode target = conn.getTarget();
    	if (target.getUniqueName().startsWith("tCollector") && destinationColl == null) {
    		destinationColl = target.getUniqueName();
    		dest = target;
    	} 
    }
	List<IMetadataTable> metadatas = node.getMetadataList();
	IMetadataTable metadata = metadatas.get(0);
	List<IMetadataColumn> columnsout = metadata.getListColumns();
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_1);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    	
	}
	
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_7);
    

   	int curCount = 0;
    for (IMetadataColumn imc : columnsout) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(imc.getLabel());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(imc.getLabel());
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(imc.getLabel());
    stringBuffer.append(TEXT_16);
    if(curCount < columnsout.size()-1){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    }
		}
		curCount++;
		
    }
		if(isLog4jEnabled){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
		}
    if (hashPartitioner) {
      if (hashKeys != null && hashKeys.size() > 0) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
			for (int k = 0; k < hashKeys.size(); k++) {
				Map<String, String> hashKey = hashKeys.get(k);
				String colName = hashKey.get("KEY_COLUMN");
				
    stringBuffer.append(TEXT_24);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_28);
    
				if (k < hashKeys.size() - 1) {
				
    stringBuffer.append(TEXT_29);
    
				}
			}
			
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
    
	  	} else if (hashKeys.size() == 0 && dest != null) {
		  	//know it's a hash partitioner, but what about the keys?  They weren't provided
		  	//but there are some instances where we can derive the keys.  Some of them will use the 
		  	//same hashing method and in some instances we cannot.  For example, with Fuzzy
		  	//matching there is not guarantee with a hash based partition that Bill will
		  	//end up in the same partition as Will even though that may be necessary (see below
		  	//for why I've at least temporarily pulled this back out).
		  	//for this purpose, we also don't care about lookups etc, just what components
		  	//we know about and how to partition for them.  These are tUniqRow, 
		  	//tAggregateRow (sorted, too), tMatchGroup, among others.
		  	
		  		///=========================================================================================
		  		///=========================================================================================
		  		//I've been looking into ways to automate this for some of the fuzzy matching components,
		  		//however that involves a bunch of algorithms that made the parallel version
		  		//slower than the serial version.  This is because these hashing methodologies require 
		  		//calculating several additional computations to deduce an appropriate
		  		//partition and they must be done keywise (for each key).  So that's staying out until 
		  		//something more efficient comes along.  
		  		///=========================================================================================
		  		
		  	//we know that the tCollector is the "start" component, so we can go forward from there.
	  		List<? extends IConnection> colOut = dest.getOutgoingConnections(EConnectionType.FLOW_MAIN);
	  		//we also know it can only have one row output.
	  		IConnection connOut = colOut.get(0);
	  		//This will only work under the circumstance that there's a single flow
	  		//with a single line of logic from start to finish.  If there's not there's 
	  		//a lot of logic that has to go into it.  For instance we can't derive keys
	  		//if they come from something like a lookup.
	  		
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
	  		//agg use GROUPBYS
	  		//UniqRow uses UNIQUE_KEY
	  		INode tmpNode = dest;
	  		boolean done = false;
	  		List<java.util.Map<String,String>> keyMap = null;
	  		String keyColName = "";
	  		boolean extraCheck = false;
	  		while (!done && tmpNode.getOutgoingConnections().size() > 0) {
	  			tmpNode = connOut.getTarget();
	  			
    stringBuffer.append(TEXT_38);
    stringBuffer.append(tmpNode.getComponent().getName());
    stringBuffer.append(TEXT_39);
    
	  			if (tmpNode.getComponent().getName().startsWith("tAggregate") || tmpNode.getComponent().getName().startsWith("tSurviveFields")) {
	  				done = true;
	  				keyMap = (List<java.util.Map<String,String>>) ElementParameterParser.getObjectValue(tmpNode,"__GROUPBYS__");
	  				keyColName = "INPUT_COLUMN";
	  			} else if (tmpNode.getComponent().getName().startsWith("tUniqRow")) {
	  				done = true;
	  				keyMap = (List<java.util.Map<String,String>>) ElementParameterParser.getObjectValue(tmpNode,"__UNIQUE_KEY__");
	  				keyColName = "KEY_ATTRIBUTE";
	  				extraCheck = true;
	  			} else {
	  				List<? extends IConnection> tmpConns = tmpNode.getOutgoingConnections(EConnectionType.FLOW_MAIN);
	  				IConnection tmpOutConn = tmpConns.get(0);
	  				tmpNode = tmpOutConn.getTarget();
	  				connOut = tmpOutConn;
	  			}
	  		}
	  		if (keyMap != null) {
	  			if (!extraCheck) {
					for (int k = 0; k < keyMap.size(); k++) {
						Map<String, String> hashKey = keyMap.get(k);
						String colName = hashKey.get(keyColName);
						
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_46);
    
						if (k < keyMap.size() - 1) {
						
    stringBuffer.append(TEXT_47);
    
						}
						
    stringBuffer.append(TEXT_48);
    
					}
				} if (extraCheck && "KEY_ATTRIBUTE".equals(keyColName)) {
					List<IMetadataTable> md = tmpNode.getMetadataList();
					if (md != null && md.size() > 0) {
						IMetadataTable m = md.get(0);
						if (m != null) {
							List<IMetadataColumn> cols = m.getListColumns();
							int colCounter = 0;
							for (int i = 0; i < cols.size(); i++) {
								IMetadataColumn col = cols.get(i);
								if ("true".equals(keyMap.get(i).get(keyColName))) {
									if (colCounter > 0) {
									
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
									}
								
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_58);
    
									
								}
							}
						}
					}
				}
				
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
	  		}//keyMap != null
	  	} else {//hashKeys size > 0 && dest != null
	  		
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
	  	}
	}
	if (!hashPartitioner) {
	
    stringBuffer.append(TEXT_71);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
	} else {
	
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(numPartitions);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
    
    } 
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    return stringBuffer.toString();
  }
}
