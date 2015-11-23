package org.talend.designer.codegen.translators.databases.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TNeo4jConnectionBeginJava
{
  protected static String nl;
  public static synchronized TNeo4jConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jConnectionBeginJava result = new TNeo4jConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_2 = " = new org.neo4j.rest.graphdb.RestGraphDatabase(";
  protected final String TEXT_3 = ");" + NL + "\t\t";
  protected final String TEXT_4 = NL + "            java.util.Map config = new java.util.HashMap();" + NL + "            config.put( \"read_only\", \"true\" );" + NL + "\t\t\torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_5 = " = new org.neo4j.graphdb.factory.GraphDatabaseFactory()" + NL + "\t\t\t        .newEmbeddedDatabaseBuilder(";
  protected final String TEXT_6 = ")" + NL + "\t\t\t        .setConfig(config).newGraphDatabase();" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_8 = " = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(";
  protected final String TEXT_9 = ");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\tglobalMap.put(\"dbService_";
  protected final String TEXT_11 = "_path\", ";
  protected final String TEXT_12 = ");" + NL + "    globalMap.put(\"dbService_";
  protected final String TEXT_13 = "\", databaseService_";
  protected final String TEXT_14 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dbPath = ElementParameterParser.getValue(node, "__DATABASE_PATH__");

	boolean remoteServer = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REMOTE_SERVER__"));
	boolean readOnlyMode = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__READ_ONLY_MODE__"));
	
	
	if (remoteServer) {
		String serverUrl = ElementParameterParser.getValue(node, "__SERVER_URL__");
		
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(serverUrl);
    stringBuffer.append(TEXT_3);
    
	} else {
		if (readOnlyMode) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dbPath);
    stringBuffer.append(TEXT_6);
    
		} else {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbPath);
    stringBuffer.append(TEXT_9);
    
		}
	}
	
	
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dbPath);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
