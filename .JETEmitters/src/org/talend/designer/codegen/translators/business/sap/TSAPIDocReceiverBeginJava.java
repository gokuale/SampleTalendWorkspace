package org.talend.designer.codegen.translators.business.sap;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class TSAPIDocReceiverBeginJava
{
  protected static String nl;
  public static synchronized TSAPIDocReceiverBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPIDocReceiverBeginJava result = new TSAPIDocReceiverBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjavax.jms.Connection connection_";
  protected final String TEXT_3 = " = null;" + NL + "\ttry {" + NL + "\t//}" + NL + "\t";
  protected final String TEXT_4 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_5 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = "; ";
  protected final String TEXT_10 = NL + "\t" + NL + "\tString url_";
  protected final String TEXT_11 = " =\"\";" + NL + "\t";
  protected final String TEXT_12 = NL + "\t\turl_";
  protected final String TEXT_13 = " = \"failover:(\";" + NL + "\t\t";
  protected final String TEXT_14 = NL + "\t\t\turl_";
  protected final String TEXT_15 = " = url_";
  protected final String TEXT_16 = " +\",\";" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\turl_";
  protected final String TEXT_18 = " = url_";
  protected final String TEXT_19 = " +\"";
  protected final String TEXT_20 = "://\";" + NL + "\t\t\turl_";
  protected final String TEXT_21 = " = url_";
  protected final String TEXT_22 = " +";
  protected final String TEXT_23 = ";" + NL + "\t\t\turl_";
  protected final String TEXT_24 = " = url_";
  protected final String TEXT_25 = " +\":\";" + NL + "\t\t\turl_";
  protected final String TEXT_26 = " = url_";
  protected final String TEXT_27 = " +";
  protected final String TEXT_28 = ";" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\turl_";
  protected final String TEXT_30 = " = url_";
  protected final String TEXT_31 = " +\")?randomize=false\";" + NL + "\t\t";
  protected final String TEXT_32 = NL + "\t\t\turl_";
  protected final String TEXT_33 = " = url_";
  protected final String TEXT_34 = " +\"&\"+";
  protected final String TEXT_35 = "+\"=\"+";
  protected final String TEXT_36 = ";" + NL + "\t\t";
  protected final String TEXT_37 = NL + "\t\turl_";
  protected final String TEXT_38 = " = \"";
  protected final String TEXT_39 = "://\"+";
  protected final String TEXT_40 = "+\":\"+";
  protected final String TEXT_41 = ";" + NL + "\t";
  protected final String TEXT_42 = NL + "\t" + NL + "\torg.apache.activemq.ActiveMQConnectionFactory factory_";
  protected final String TEXT_43 = " = new org.apache.activemq.ActiveMQConnectionFactory(url_";
  protected final String TEXT_44 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_45 = NL + "\t\tconnection_";
  protected final String TEXT_46 = " = factory_";
  protected final String TEXT_47 = ".createConnection();" + NL + "\t";
  protected final String TEXT_48 = NL + "\t\tconnection_";
  protected final String TEXT_49 = " = factory_";
  protected final String TEXT_50 = ".createConnection(";
  protected final String TEXT_51 = ",decryptedPassword_";
  protected final String TEXT_52 = ");" + NL + "\t";
  protected final String TEXT_53 = NL + "\t" + NL + "\tconnection_";
  protected final String TEXT_54 = ".start();" + NL + "\t" + NL + "\tjavax.jms.Session session_";
  protected final String TEXT_55 = " = connection_";
  protected final String TEXT_56 = ".createSession(";
  protected final String TEXT_57 = ", javax.jms.Session.";
  protected final String TEXT_58 = ");" + NL + "\t" + NL + "\tjavax.jms.Destination des_";
  protected final String TEXT_59 = " = null;" + NL + "\t" + NL + "\t";
  protected final String TEXT_60 = NL + "\tdes_";
  protected final String TEXT_61 = " = session_";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = "createTopic";
  protected final String TEXT_64 = "createQueue";
  protected final String TEXT_65 = "(\"";
  protected final String TEXT_66 = "\" + " + NL + "\t\t";
  protected final String TEXT_67 = NL + "\t\tglobalMap.get(\"";
  protected final String TEXT_68 = "_source_struct_name\")" + NL + "\t\t";
  protected final String TEXT_69 = NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\t";
  protected final String TEXT_71 = NL + "\t);" + NL + "\t\t" + NL + "\tjavax.jms.MessageProducer replyProducer_";
  protected final String TEXT_72 = " = session_";
  protected final String TEXT_73 = ".createProducer(null);" + NL + "\treplyProducer_";
  protected final String TEXT_74 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);" + NL + "\t\t\t" + NL + "\tjavax.jms.MessageConsumer consumer_";
  protected final String TEXT_75 = " = session_";
  protected final String TEXT_76 = ".createConsumer(des_";
  protected final String TEXT_77 = ");" + NL + "\t" + NL + "\tjavax.jms.Message message_";
  protected final String TEXT_78 = ";" + NL + "\t" + NL + "\t";
  protected final String TEXT_79 = NL + "\tint count_";
  protected final String TEXT_80 = " = 0;" + NL + "\tint max_count_";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = ";" + NL + "\t";
  protected final String TEXT_83 = NL + "\t" + NL + "\t";
  protected final String TEXT_84 = NL + "\tlong max_interval_";
  protected final String TEXT_85 = " = ";
  protected final String TEXT_86 = "*1000;" + NL + "\tlong start_point_";
  protected final String TEXT_87 = " = java.lang.System.currentTimeMillis();" + NL + "\t";
  protected final String TEXT_88 = NL + "\t" + NL + "\twhile (true) {" + NL + "\t\t";
  protected final String TEXT_89 = NL + "\t\tif(count_";
  protected final String TEXT_90 = " == max_count_";
  protected final String TEXT_91 = ") {" + NL + "\t\t\tbreak;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_92 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_93 = NL + "\t\tif((java.lang.System.currentTimeMillis() - start_point_";
  protected final String TEXT_94 = ") > max_interval_";
  protected final String TEXT_95 = ") {" + NL + "\t\t\tbreak;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_96 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_97 = " " + NL + "\t\ttry {" + NL + "\t\t//}" + NL + "\t\t";
  protected final String TEXT_98 = NL + "\t\t" + NL + "\t\t\tmessage_";
  protected final String TEXT_99 = " = consumer_";
  protected final String TEXT_100 = ".receive(" + NL + "\t\t\t\t";
  protected final String TEXT_101 = " ";
  protected final String TEXT_102 = "*1000 ";
  protected final String TEXT_103 = NL + "\t\t\t\t";
  protected final String TEXT_104 = " max_interval_";
  protected final String TEXT_105 = " ";
  protected final String TEXT_106 = NL + "\t\t\t);" + NL + "\t\t\t" + NL + "\t\t\tif(message_";
  protected final String TEXT_107 = " == null) {" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_108 = NL + "\t\t\tcount_";
  protected final String TEXT_109 = "++;" + NL + "\t\t";
  protected final String TEXT_110 = NL + "\t\t\t";
  protected final String TEXT_111 = ".message = ((javax.jms.TextMessage) message_";
  protected final String TEXT_112 = ").getText();" + NL + "    //}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	List<? extends IConnection> outputConnections = node.getOutgoingConnections(EConnectionType.FLOW_MAIN);
	
	if(outputConnections==null || outputConnections.isEmpty()){
		return "";
	}
	
	IConnection outputConnection = outputConnections.get(0);
	
	boolean linktHMap =  "true".equals(ElementParameterParser.getValue(node, "__LINK_THMAP__"));
	String hid = ElementParameterParser.getValue(node, "__MAPPING__");
	if(linktHMap && (hid == null || "".equals(hid))) {
		return "";
	}
	
	String idocType = ElementParameterParser.getValue(node, "__IDOC_TYPE__");
	
	//begin to get mode parameters
	String mode = ElementParameterParser.getValue(node, "__MODE__");
	boolean realTimeMode = "REAL_TIME".equals(mode);
	boolean batchMode = "BATCH".equals(mode);
	
	boolean listenInterval = "true".equals(ElementParameterParser.getValue(node, "__LISTEN_INTERVAL__"));
	boolean listenCount = "true".equals(ElementParameterParser.getValue(node, "__LISTEN_COUNT__"));
	
	String interval = ElementParameterParser.getValue(node, "__INTERVAL__");
	String count = ElementParameterParser.getValue(node, "__COUNT__");
	
	String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");
	//end to get mode parameters
	
	//begin to get connection parameters
	boolean failover =  "true".equals(ElementParameterParser.getValue(node, "__FAILOVER__"));
	List<Map<String,String>> servers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SERVERS__");
	List<Map<String,String>> additionalOpts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADDITIONAL_OPTIONS__");
	
	String host = ElementParameterParser.getValue(node, "__SERVERADDRESS__");
	String port = ElementParameterParser.getValue(node, "__SERVERPORT__");
	String dbuser = ElementParameterParser.getValue(node, "__USER__");
	
	boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
	String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
	
	boolean isUseSSL = ("true").equals(ElementParameterParser.getValue(node, "__USE_SSL__"));
	String transProtocol="tcp";
	if(isUseSSL){
		transProtocol = "ssl";
	}
	//end to get connection parameters
	
	String passwordFieldName = "__PASS__";

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_6);
    } else {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    if(failover){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
		int i=0;
		for(Map<String, String> serversMap : servers) {
			String strHost = serversMap.get("SERVERS_HOST");
			String strPort = serversMap.get("SERVERS_PORT");

			if(i>0) {
			
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(transProtocol);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(strHost);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(strPort);
    stringBuffer.append(TEXT_28);
    
			i++;
		}
		
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
		for(Map<String, String> optrion : additionalOpts) {
		
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(optrion.get("OPTION_NAME"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(optrion.get("OPTION_VALUE"));
    stringBuffer.append(TEXT_36);
    
		}
	}else{
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(transProtocol);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    
	if(dbuser == null || ("\"\"").equals(dbuser) || ("").equals(dbuser)) {
	
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    
	} else {
	
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
	}
	
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(transacted);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(acknowledgmentMode);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    
	String keyPrefix = ElementParameterParser.getValue(node, "__KEY_PREFIX__");
	
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    if(realTimeMode) {
    stringBuffer.append(TEXT_63);
    } else {
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    stringBuffer.append(keyPrefix);
    stringBuffer.append(TEXT_66);
    if(linktHMap) {
    stringBuffer.append(TEXT_67);
    stringBuffer.append(hid );
    stringBuffer.append(TEXT_68);
    } else {
    stringBuffer.append(TEXT_69);
    stringBuffer.append(idocType);
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    if(realTimeMode && listenCount) {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    if(realTimeMode && listenInterval) {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    if(realTimeMode && listenCount) {
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    if(realTimeMode && listenInterval) {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    }
    stringBuffer.append(TEXT_96);
    if(transacted) {
    stringBuffer.append(TEXT_97);
    }
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    if(batchMode) {
    stringBuffer.append(TEXT_101);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    if(realTimeMode && listenInterval) {
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    }
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    if(realTimeMode && listenCount) {
		
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    stringBuffer.append(outputConnection.getName());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    return stringBuffer.toString();
  }
}
