package org.talend.designer.codegen.translators.databases.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TNeo4jRowBeginJava
{
  protected static String nl;
  public static synchronized TNeo4jRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jRowBeginJava result = new TNeo4jRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_2 = " = (org.neo4j.graphdb.GraphDatabaseService) globalMap.get(\"";
  protected final String TEXT_3 = "\");" + NL + "\t";
  protected final String TEXT_4 = NL + "    \t\torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_5 = " = new org.neo4j.rest.graphdb.RestGraphDatabase(";
  protected final String TEXT_6 = ");" + NL + "    \t\t";
  protected final String TEXT_7 = NL + "                org.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_8 = " = new org.neo4j.kernel.EmbeddedGraphDatabase(";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "                org.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_11 = " = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = "   " + NL + "org.neo4j.rest.graphdb.query.QueryEngine<java.util.Map<String, Object>> queryEngine_";
  protected final String TEXT_14 = " = null;" + NL + "org.neo4j.cypher.ExecutionEngine engine_";
  protected final String TEXT_15 = " = null;" + NL + "if (databaseService_";
  protected final String TEXT_16 = " instanceof org.neo4j.rest.graphdb.RestGraphDatabase) {" + NL + "\torg.neo4j.rest.graphdb.RestGraphDatabase restDatabase_";
  protected final String TEXT_17 = " = (org.neo4j.rest.graphdb.RestGraphDatabase) databaseService_";
  protected final String TEXT_18 = "; " + NL + "\tqueryEngine_";
  protected final String TEXT_19 = " = new org.neo4j.rest.graphdb.query.RestCypherQueryEngine(restDatabase_";
  protected final String TEXT_20 = ".getRestAPI());" + NL + "} else {";
  protected final String TEXT_21 = NL + "        engine_";
  protected final String TEXT_22 = " = new org.neo4j.cypher.ExecutionEngine(databaseService_";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "        engine_";
  protected final String TEXT_25 = " = new org.neo4j.cypher.ExecutionEngine(databaseService_";
  protected final String TEXT_26 = ", org.neo4j.kernel.impl.util.StringLogger.SYSTEM);";
  protected final String TEXT_27 = NL + "}" + NL + "" + NL + "" + NL + "if (databaseService_";
  protected final String TEXT_28 = ".getClass().equals(org.neo4j.kernel.EmbeddedGraphDatabase.class)) {" + NL + "    while (((org.neo4j.kernel.EmbeddedGraphDatabase)databaseService_";
  protected final String TEXT_29 = ").transactionRunning()){" + NL + "        // wait the end of the previous transaction" + NL + "    }" + NL + "}" + NL + "org.neo4j.graphdb.Transaction tx_";
  protected final String TEXT_30 = " = databaseService_";
  protected final String TEXT_31 = ".beginTx();" + NL + "" + NL + "long counter_";
  protected final String TEXT_32 = " = 0;" + NL + "long nbNodeInserted_";
  protected final String TEXT_33 = " = 0;" + NL + "long nbRelationshipInserted_";
  protected final String TEXT_34 = " = 0;" + NL + "long nbPropertiesUpdated_";
  protected final String TEXT_35 = " = 0;" + NL + "long nbNodeDeleted_";
  protected final String TEXT_36 = " = 0;" + NL + "long nbRelationshipDeleted_";
  protected final String TEXT_37 = " = 0;";
  protected final String TEXT_38 = NL + "resourceMap.put(\"databaseService_";
  protected final String TEXT_39 = "\", databaseService_";
  protected final String TEXT_40 = "); ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	

    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
    boolean shutdownDb = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SHUTDOWN_DB__"));
    String dbVersion = ElementParameterParser.getValue(node,"__DB_VERSION__");

    if (useExistingConnection) {
    	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
        for(INode targetNode : nodes){
            if (targetNode.getUniqueName().equals(connection)) {
                dbVersion = ElementParameterParser.getValue(targetNode, "__DB_VERSION__");
                break;
            }
        }
    	String dbconn = "dbService_" + connection;
		
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(dbconn);
    stringBuffer.append(TEXT_3);
    
    } else {
    	boolean remoteServer = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REMOTE_SERVER__"));
    	if (remoteServer) {
    		String serverUrl = ElementParameterParser.getValue(node, "__SERVER_URL__");
    		
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(serverUrl);
    stringBuffer.append(TEXT_6);
    
    	} else {
	    	String databasePath = ElementParameterParser.getValue(node, "__DATABASE_PATH__");
	    	if ("NEO4J_1_X_X".equals(dbVersion)) {
                
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(databasePath);
    stringBuffer.append(TEXT_9);
    
            } else { // NEO4J_2_1_X
                
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(databasePath);
    stringBuffer.append(TEXT_12);
    
            }
		}
    }

    String userNbLine = ElementParameterParser.getValue(node, "__USE_NB_LINE__");

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
    
    if ("NEO4J_1_X_X".equals(dbVersion)) {
        
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
    } else { // NEO4J_2_1_X
        
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
    }
    
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
	if (!useExistingConnection||(useExistingConnection && shutdownDb)) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
	}

    return stringBuffer.toString();
  }
}
