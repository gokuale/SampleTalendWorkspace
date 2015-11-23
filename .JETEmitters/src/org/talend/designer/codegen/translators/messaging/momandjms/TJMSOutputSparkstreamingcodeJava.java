package org.talend.designer.codegen.translators.messaging.momandjms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
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

public class TJMSOutputSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TJMSOutputSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJMSOutputSparkstreamingcodeJava result = new TJMSOutputSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "public static class ";
  protected final String TEXT_2 = "_OutputFunction" + NL + "    implements org.apache.spark.api.java.function.VoidFunction<java.util.Iterator<";
  protected final String TEXT_3 = ">>{" + NL + "    " + NL + "    private ContextProperties context = null;" + NL + "    " + NL + "    public ";
  protected final String TEXT_4 = "_OutputFunction(JobConf job){" + NL + "    \tthis.context = new ContextProperties(job);" + NL + "    }" + NL + "" + NL + "    public void call(java.util.Iterator<";
  protected final String TEXT_5 = "> dataIterator) throws java.lang.Exception{" + NL + "    \t";
  protected final String TEXT_6 = NL + "        ";
  protected final String TEXT_7 = NL + "    \t\tSystem.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_8 = ");" + NL + "    \t\ttry{" + NL + "\t    \t\tnew java.io.FileInputStream(new java.io.File(System.getProperty(\"javax.net.ssl.trustStore\")));" + NL + "\t        }catch(Exception e){" + NL + "\t       \t\te.printStackTrace();" + NL + "\t        }" + NL + "    \t\tSystem.setProperty(\"javax.net.ssl.trustStoreType\", ";
  protected final String TEXT_9 = ");" + NL + "\t\t    System.setProperty(\"javax.net.ssl.trustStorePassword\", ";
  protected final String TEXT_10 = ");" + NL + "\t\t    ";
  protected final String TEXT_11 = NL + "\t\t\t    System.setProperty(\"javax.net.ssl.keyStore\", ";
  protected final String TEXT_12 = ");" + NL + "\t\t\t    try{" + NL + "\t\t    \t\tnew java.io.FileInputStream(new java.io.File(System.getProperty(\"javax.net.ssl.keyStore\")));" + NL + "\t\t        }catch(Exception e){" + NL + "\t\t       \t\te.printStackTrace();" + NL + "\t\t        }" + NL + "\t    \t\tSystem.setProperty(\"javax.net.ssl.keyStoreType\", ";
  protected final String TEXT_13 = ");" + NL + "\t    \t\tSystem.setProperty(\"javax.net.ssl.keyStorePassword\", ";
  protected final String TEXT_14 = ");" + NL + "\t    \t";
  protected final String TEXT_15 = NL + "\t        ";
  protected final String TEXT_16 = NL + "\t\t\t    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(" + NL + "\t\t\t    \tnew javax.net.ssl.HostnameVerifier(){" + NL + "\t\t\t      \t\tpublic boolean verify(String hostName,javax.net.ssl.SSLSession session)" + NL + "\t\t\t       \t\t\t{" + NL + "\t\t\t       \t\t\t\treturn true;" + NL + "\t\t\t       \t\t\t}" + NL + "\t\t\t     \t}" + NL + "\t\t\t    );" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "    \t";
  protected final String TEXT_18 = NL + "        " + NL + "        java.util.Hashtable props_";
  protected final String TEXT_19 = " = new java.util.Hashtable();" + NL + "    \tprops_";
  protected final String TEXT_20 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, ";
  protected final String TEXT_21 = ");" + NL + "    \tprops_";
  protected final String TEXT_22 = ".put(javax.naming.Context.PROVIDER_URL, ";
  protected final String TEXT_23 = ");" + NL + "    \t";
  protected final String TEXT_24 = " " + NL + "    \t\t\tprops_";
  protected final String TEXT_25 = ".put(";
  protected final String TEXT_26 = ", ";
  protected final String TEXT_27 = "); " + NL + "\t\t\t";
  protected final String TEXT_28 = NL + "    \t" + NL + "    \tjavax.naming.Context context_";
  protected final String TEXT_29 = " = new javax.naming.InitialContext(props_";
  protected final String TEXT_30 = ");" + NL + "    \tjavax.jms.ConnectionFactory factory_";
  protected final String TEXT_31 = " = (javax.jms.ConnectionFactory) context_";
  protected final String TEXT_32 = ".lookup(";
  protected final String TEXT_33 = ");" + NL + "    \t" + NL + "    \tjavax.jms.Connection connection_";
  protected final String TEXT_34 = " = factory_";
  protected final String TEXT_35 = ".createConnection(";
  protected final String TEXT_36 = ");" + NL + "    \tconnection_";
  protected final String TEXT_37 = ".start();" + NL + "    " + NL + "    \tjavax.jms.Session session_";
  protected final String TEXT_38 = " = connection_";
  protected final String TEXT_39 = ".createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);" + NL + "    \tjavax.jms.Destination dest_";
  protected final String TEXT_40 = " = session_";
  protected final String TEXT_41 = ".create";
  protected final String TEXT_42 = "(";
  protected final String TEXT_43 = ");" + NL + "    " + NL + "    \tjavax.jms.MessageProducer producer_";
  protected final String TEXT_44 = " = session_";
  protected final String TEXT_45 = ".createProducer(dest_";
  protected final String TEXT_46 = ");" + NL + "    " + NL + "    \tproducer_";
  protected final String TEXT_47 = ".setDeliveryMode(javax.jms.DeliveryMode.";
  protected final String TEXT_48 = ");" + NL + "        " + NL + "\t\twhile(dataIterator.hasNext()){";
  protected final String TEXT_49 = NL + "            ";
  protected final String TEXT_50 = " ";
  protected final String TEXT_51 = " = dataIterator.next();";
  protected final String TEXT_52 = NL + "                producer_";
  protected final String TEXT_53 = ".send((javax.jms.Message)";
  protected final String TEXT_54 = ".message);";
  protected final String TEXT_55 = NL + "                    javax.jms.ObjectMessage message_";
  protected final String TEXT_56 = " = session_";
  protected final String TEXT_57 = ".createObjectMessage();" + NL + "                    message_";
  protected final String TEXT_58 = ".setObject(";
  protected final String TEXT_59 = ".messageContent);" + NL + "            \t";
  protected final String TEXT_60 = NL + "                    javax.jms.TextMessage message_";
  protected final String TEXT_61 = " = session_";
  protected final String TEXT_62 = ".createTextMessage();" + NL + "                    message_";
  protected final String TEXT_63 = ".setText(";
  protected final String TEXT_64 = ".messageContent);" + NL + "            \t";
  protected final String TEXT_65 = NL + "            \tproducer_";
  protected final String TEXT_66 = ".send(message_";
  protected final String TEXT_67 = ");";
  protected final String TEXT_68 = NL + "    \t}" + NL + "    \tproducer_";
  protected final String TEXT_69 = ".close();" + NL + "        session_";
  protected final String TEXT_70 = ".close();" + NL + "        connection_";
  protected final String TEXT_71 = ".close();" + NL + "    }" + NL + "" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    
IMetadataTable metadata = null;
IConnection conn = null;
List<IMetadataColumn> columns = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if((metadatas!=null) && (metadatas.size() > 0)){
    metadata = metadatas.get(0);
    if(metadata != null){
		columns = metadata.getListColumns();		
	}
}
List<? extends IConnection> conns = node.getIncomingConnections();
if(conns != null && conns.size() > 0 && conns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
    conn = conns.get(0);
}

if(columns == null || columns.isEmpty() || conn == null){
	return "";
}

String inRowStruct = codeGenArgument.getRecordStructName(conn);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_5);
    
        String contextProvider=ElementParameterParser.getValue(node, "__CONTEXT_PROVIDER__");
        String connFacName=ElementParameterParser.getValue(node, "__CONN_FACTORY_NAME__");
        String url=ElementParameterParser.getValue(node, "__SERVER_URL__");
        boolean userIdentity=ElementParameterParser.getBooleanValue(node, "__USER_IDENTITY__");
        String user=ElementParameterParser.getValue(node, "__USER__");
        
        String to=ElementParameterParser.getValue(node, "__TO__");
        String deliverMode = ElementParameterParser.getValue(node, "__DELIVERY_MODE__");
        String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
        
        List<Map<String, String>> advProps = ElementParameterParser.getTableValue(node, "__ADVANCED_PROPERTIES__"); 	
        String processingMode = ElementParameterParser.getValue(node, "__PROCESSING_MODE__");
        
    stringBuffer.append(TEXT_6);
    
		TSetKeystoreUtil tSetKeystoreUtil = new TSetKeystoreUtil(node);
		if(tSetKeystoreUtil.useHTTPS()){
		
    stringBuffer.append(TEXT_7);
    stringBuffer.append(tSetKeystoreUtil.getTrustStorePath());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(tSetKeystoreUtil.getTrustStoreType());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(tSetKeystoreUtil.getTrustStorePassword());
    stringBuffer.append(TEXT_10);
    if(tSetKeystoreUtil.needClientAuth()){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(tSetKeystoreUtil.getKeyStorePath());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(tSetKeystoreUtil.getKeyStoreType());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(tSetKeystoreUtil.getKeyStorePassword());
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    if(!tSetKeystoreUtil.needVerifyName()){
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    
    	}
    	
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(contextProvider);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_23);
     
    	if(advProps.size() > 0){ 
    		for(Map<String, String> item : advProps){ 
    		
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_27);
      
    		}  
    	}	 
    	
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(connFacName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(userIdentity ? user + "," + ElementParameterParser.getPasswordValue(node, "__PASS__") : "" );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
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
    stringBuffer.append(to);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(deliverMode);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(inRowStruct);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_51);
    
            if("RAW".equals(processingMode)){
            
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_54);
    
			}else{
				if("id_Document".equals(metadata.getColumn("messageContent").getTalendType())){
            	
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_59);
    
            	}else{
            	
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_64);
    
            	}
            	
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
			}	
            
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    return stringBuffer.toString();
  }
}
