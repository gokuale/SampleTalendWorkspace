package org.talend.designer.codegen.translators.messaging.momandjms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.NodeUtil;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.common.tsetkeystore.TSetKeystoreUtil;

public class TJMSInputSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TJMSInputSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJMSInputSparkstreamingcodeJava result = new TJMSInputSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "public static class JMSReceiver_";
  protected final String TEXT_2 = " extends org.apache.spark.streaming.receiver.Receiver<";
  protected final String TEXT_3 = ">{" + NL + "\tprivate ContextProperties context = null;" + NL + "    //private GlobalVar globalMap = null;" + NL + "\t" + NL + "\tpublic JMSReceiver_";
  protected final String TEXT_4 = "(JobConf job, org.apache.spark.storage.StorageLevel storageLevel) {" + NL + "        super(storageLevel);" + NL + " \t\tthis.context = new ContextProperties(job);" + NL + " \t\t//this.globalMap = new GlobalVar(job);" + NL + "    }" + NL + "    " + NL + "    public void onStart() {" + NL + "        new Thread() {" + NL + "            public void run() {" + NL + "                receive();" + NL + "            }" + NL + "        }.start();" + NL + "    }" + NL + "    public void onStop() {" + NL + "" + NL + "    }" + NL + "    private void receive(){";
  protected final String TEXT_5 = NL + "    \t\tSystem.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_6 = ");" + NL + "    \t\ttry{" + NL + "\t    \t\tnew java.io.FileInputStream(new java.io.File(System.getProperty(\"javax.net.ssl.trustStore\")));" + NL + "\t        }catch(Exception e){" + NL + "\t       \t\treportError(e.getMessage(), e);" + NL + "\t        }" + NL + "    \t\tSystem.setProperty(\"javax.net.ssl.trustStoreType\", ";
  protected final String TEXT_7 = ");" + NL + "\t\t    System.setProperty(\"javax.net.ssl.trustStorePassword\", ";
  protected final String TEXT_8 = ");" + NL + "\t\t    ";
  protected final String TEXT_9 = NL + "\t\t\t    System.setProperty(\"javax.net.ssl.keyStore\", ";
  protected final String TEXT_10 = ");" + NL + "\t\t\t    try{" + NL + "\t\t    \t\tnew java.io.FileInputStream(new java.io.File(System.getProperty(\"javax.net.ssl.keyStore\")));" + NL + "\t\t        }catch(Exception e){" + NL + "\t\t       \t\treportError(e.getMessage(), e);" + NL + "\t\t        }" + NL + "\t    \t\tSystem.setProperty(\"javax.net.ssl.keyStoreType\", ";
  protected final String TEXT_11 = ");" + NL + "\t    \t\tSystem.setProperty(\"javax.net.ssl.keyStorePassword\", ";
  protected final String TEXT_12 = ");" + NL + "\t    \t";
  protected final String TEXT_13 = NL + "\t        ";
  protected final String TEXT_14 = NL + "\t\t\t    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(" + NL + "\t\t\t    \tnew javax.net.ssl.HostnameVerifier(){" + NL + "\t\t\t      \t\tpublic boolean verify(String hostName,javax.net.ssl.SSLSession session)" + NL + "\t\t\t       \t\t\t{" + NL + "\t\t\t       \t\t\t\treturn true;" + NL + "\t\t\t       \t\t\t}" + NL + "\t\t\t     \t}" + NL + "\t\t\t    );" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "    \t";
  protected final String TEXT_16 = NL + "        java.util.Hashtable props_";
  protected final String TEXT_17 = " = new java.util.Hashtable();" + NL + "    \tprops_";
  protected final String TEXT_18 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, ";
  protected final String TEXT_19 = ");" + NL + "    \tprops_";
  protected final String TEXT_20 = ".put(javax.naming.Context.PROVIDER_URL, ";
  protected final String TEXT_21 = ");" + NL + "    \t";
  protected final String TEXT_22 = NL + "        \t\tprops_";
  protected final String TEXT_23 = ".put(";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ");" + NL + "        \t";
  protected final String TEXT_26 = NL + "    \tjavax.jms.Connection connection_";
  protected final String TEXT_27 = " = null;" + NL + "    \tjavax.jms.Session session_";
  protected final String TEXT_28 = " = null;" + NL + "    \tjavax.jms.MessageConsumer consumer_";
  protected final String TEXT_29 = " = null;" + NL + "    \ttry{" + NL + "        \tjavax.naming.Context context_";
  protected final String TEXT_30 = " = new javax.naming.InitialContext(props_";
  protected final String TEXT_31 = ");" + NL + "        \tjavax.jms.ConnectionFactory factory_";
  protected final String TEXT_32 = " = (javax.jms.ConnectionFactory) context_";
  protected final String TEXT_33 = ".lookup(";
  protected final String TEXT_34 = ");" + NL + "        \t" + NL + "        \tconnection_";
  protected final String TEXT_35 = " = factory_";
  protected final String TEXT_36 = ".createConnection(";
  protected final String TEXT_37 = ");" + NL + "        \tsession_";
  protected final String TEXT_38 = " = connection_";
  protected final String TEXT_39 = ".createSession(false, javax.jms.Session.CLIENT_ACKNOWLEDGE);" + NL + "        \tjavax.jms.Destination dest_";
  protected final String TEXT_40 = " = session_";
  protected final String TEXT_41 = ".create";
  protected final String TEXT_42 = "(";
  protected final String TEXT_43 = ");" + NL + "        \tconsumer_";
  protected final String TEXT_44 = "\t= session_";
  protected final String TEXT_45 = ".createConsumer(dest_";
  protected final String TEXT_46 = ", ";
  protected final String TEXT_47 = ");" + NL + "        " + NL + "        \tconnection_";
  protected final String TEXT_48 = ".start();" + NL + "        " + NL + "        \tSystem.out.println(\"Ready to receive message\");" + NL + "        \tSystem.out.println(\"Waiting...\");" + NL + "        " + NL + "        \tjavax.jms.Message message_";
  protected final String TEXT_49 = ";" + NL + "        " + NL + "        \tint nbline_";
  protected final String TEXT_50 = " = 0;" + NL + "        " + NL + "        \twhile(!isStopped() && (message_";
  protected final String TEXT_51 = " = consumer_";
  protected final String TEXT_52 = ".receive(";
  protected final String TEXT_53 = "*1000)) != null){" + NL + "        \t\t";
  protected final String TEXT_54 = " row = new ";
  protected final String TEXT_55 = "();" + NL + "         \t\t";
  protected final String TEXT_56 = NL + "        \t\t\trow.message=message_";
  protected final String TEXT_57 = ";\t" + NL + "    \t\t\t";
  protected final String TEXT_58 = NL + "        \t\t\t\trow.messageContent=BigDataParserUtils.parseTo_Document(((javax.jms.ObjectMessage) message_";
  protected final String TEXT_59 = ").getObject().toString());" + NL + "        \t\t\t";
  protected final String TEXT_60 = NL + "        \t\t\t\trow.messageContent=((javax.jms.TextMessage) message_";
  protected final String TEXT_61 = ").getText();" + NL + "        \t\t\t";
  protected final String TEXT_62 = NL + "    \t\t    store(row);" + NL + "        \t\tmessage_";
  protected final String TEXT_63 = ".acknowledge();" + NL + "            \tif(";
  protected final String TEXT_64 = " > 0 && nbline_";
  protected final String TEXT_65 = " >= ";
  protected final String TEXT_66 = "){" + NL + "            \t\tbreak;" + NL + "            \t}" + NL + "    \t\t}" + NL + "    \t}catch(Throwable ex){" + NL + "    \t\trestart(ex.getMessage(), ex);" + NL + "    \t}finally{" + NL + "    \t\ttry{" + NL + "        \t\tif(consumer_";
  protected final String TEXT_67 = " != null){" + NL + "                \tconsumer_";
  protected final String TEXT_68 = ".close();" + NL + "                }" + NL + "                if(session_";
  protected final String TEXT_69 = " != null){" + NL + "                \tsession_";
  protected final String TEXT_70 = ".close();" + NL + "                }" + NL + "                if(connection_";
  protected final String TEXT_71 = " != null){" + NL + "                \tconnection_";
  protected final String TEXT_72 = ".close();" + NL + "                }" + NL + "            }catch(Exception ex){" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    
IMetadataTable metadata = null;
IConnection conn = null;
List<IMetadataColumn> columns = null;
List<IMetadataTable> metadatas = node.getMetadataList();    
if((metadatas != null) && (metadatas.size() > 0)){
    metadata = metadatas.get(0);
    if(metadata != null){
        columns = metadata.getListColumns();        
    }
}

List<? extends IConnection> conns = node.getOutgoingSortedConnections();
if(conns != null && conns.size() > 0 && conns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
    conn = conns.get(0);
}   

if(columns == null || columns.isEmpty() || conn == null){
	return "";
}
String outRowStruct = codeGenArgument.getRecordStructName(conn);
String connName = conn.getName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(outRowStruct);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
        String contextProvider = ElementParameterParser.getValue(node, "__CONTEXT_PROVIDER__");
        String connFacName = ElementParameterParser.getValue(node, "__CONN_FACTORY_NAME__");
        String url = ElementParameterParser.getValue(node, "__SERVER_URL__");
        boolean userIdentity = ElementParameterParser.getBooleanValue(node, "__USER_IDENTITY__");
        String user = ElementParameterParser.getValue(node, "__USER__");
        
        String from = ElementParameterParser.getValue(node, "__FROM__");
        String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");
        String messageSelector = ElementParameterParser.getValue(node, "__MSG_SELECTOR__");
        String processingMode  =  ElementParameterParser.getValue(node, "__PROCESSING_MODE__");
        String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");	
        List<Map<String, String>> advProps = ElementParameterParser.getTableValue(node, "__ADVANCED_PROPERTIES__");
        String maxMsg=ElementParameterParser.getValue(node, "__MAX_MSG__");
        
    
		TSetKeystoreUtil tSetKeystoreUtil = new TSetKeystoreUtil(node);
		if(tSetKeystoreUtil.useHTTPS()){
		
    stringBuffer.append(TEXT_5);
    stringBuffer.append(tSetKeystoreUtil.getTrustStorePath());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(tSetKeystoreUtil.getTrustStoreType());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(tSetKeystoreUtil.getTrustStorePassword());
    stringBuffer.append(TEXT_8);
    if(tSetKeystoreUtil.needClientAuth()){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(tSetKeystoreUtil.getKeyStorePath());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(tSetKeystoreUtil.getKeyStoreType());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(tSetKeystoreUtil.getKeyStorePassword());
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    if(!tSetKeystoreUtil.needVerifyName()){
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    
    	}
    	
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(contextProvider);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_21);
    
        if(advProps.size() > 0){
        	for(Map<String, String> item : advProps){
        	
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_25);
     
        	} 
        }
        
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(connFacName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(userIdentity ? user + "," + ElementParameterParser.getPasswordValue(node, "__PASS__") : "" );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(msgType);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(messageSelector);
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
    stringBuffer.append("-1".equals(timeout)?0:timeout);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(outRowStruct);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(outRowStruct);
    stringBuffer.append(TEXT_55);
    
    			if("RAW".equals(processingMode)){
        		
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
    			}else{
    				if("id_Document".equals(metadata.getColumn("messageContent").getTalendType())){
        			
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
    				}else{
        			
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
    				}
    			}
    		    
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(maxMsg);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(maxMsg);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    return stringBuffer.toString();
  }
}
