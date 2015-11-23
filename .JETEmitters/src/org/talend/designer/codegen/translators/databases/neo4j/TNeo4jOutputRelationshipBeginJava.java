package org.talend.designer.codegen.translators.databases.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TNeo4jOutputRelationshipBeginJava
{
  protected static String nl;
  public static synchronized TNeo4jOutputRelationshipBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jOutputRelationshipBeginJava result = new TNeo4jOutputRelationshipBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            org.neo4j.graphdb.Transaction tx_";
  protected final String TEXT_2 = " = databaseService_";
  protected final String TEXT_3 = ".beginTx();";
  protected final String TEXT_4 = NL + "                org.neo4j.graphdb.Transaction tx_";
  protected final String TEXT_5 = " = databaseService_";
  protected final String TEXT_6 = ".beginTx();";
  protected final String TEXT_7 = NL + "            if (counter_";
  protected final String TEXT_8 = " % Long.parseLong(";
  protected final String TEXT_9 = ") == 0) {" + NL + "                tx_";
  protected final String TEXT_10 = ".success();" + NL + "                tx_";
  protected final String TEXT_11 = ".finish();" + NL + "                tx_";
  protected final String TEXT_12 = " = databaseService_";
  protected final String TEXT_13 = ".beginTx();" + NL + "            }";
  protected final String TEXT_14 = NL + "                if (counter_";
  protected final String TEXT_15 = " % Long.parseLong(";
  protected final String TEXT_16 = ") == 0) {" + NL + "                    tx_";
  protected final String TEXT_17 = ".success();" + NL + "                    tx_";
  protected final String TEXT_18 = ".finish();" + NL + "                    tx_";
  protected final String TEXT_19 = " = databaseService_";
  protected final String TEXT_20 = ".beginTx();" + NL + "                }";
  protected final String TEXT_21 = NL + "            if (counter_";
  protected final String TEXT_22 = " % Long.parseLong(";
  protected final String TEXT_23 = ") > 0) {" + NL + "                tx_";
  protected final String TEXT_24 = ".success();" + NL + "                tx_";
  protected final String TEXT_25 = ".finish();" + NL + "            }";
  protected final String TEXT_26 = NL + "                if (counter_";
  protected final String TEXT_27 = " % Long.parseLong(";
  protected final String TEXT_28 = ") > 0) {" + NL + "                    tx_";
  protected final String TEXT_29 = ".success();" + NL + "                    tx_";
  protected final String TEXT_30 = ".finish();" + NL + "                }";
  protected final String TEXT_31 = NL + "                org.neo4j.graphdb.Transaction tx_begin_";
  protected final String TEXT_32 = " = databaseService_";
  protected final String TEXT_33 = ".beginTx();" + NL + "                try" + NL + "                {";
  protected final String TEXT_34 = NL + "                tx_begin_";
  protected final String TEXT_35 = ".success();" + NL + "                } // enf of Try" + NL + "                finally" + NL + "                {" + NL + "                    tx_begin_";
  protected final String TEXT_36 = ".close();" + NL + "                }";
  protected final String TEXT_37 = NL + "        org.neo4j.unsafe.batchinsert.BatchInserterIndexProvider indexProvider_";
  protected final String TEXT_38 = " = null;";
  protected final String TEXT_39 = NL + "            indexProvider_";
  protected final String TEXT_40 = " = new org.neo4j.index.lucene.unsafe.batchinsert.LuceneBatchInserterIndexProvider(inserter_";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "           if (!globalMap.containsKey(\"";
  protected final String TEXT_43 = "_indexprovider\")) {" + NL + "               indexProvider_";
  protected final String TEXT_44 = " = new org.neo4j.index.lucene.unsafe.batchinsert.LuceneBatchInserterIndexProvider(inserter_";
  protected final String TEXT_45 = ");" + NL + "               globalMap.put(\"";
  protected final String TEXT_46 = "_indexprovider\", indexProvider_";
  protected final String TEXT_47 = ");" + NL + "           } else {" + NL + "               indexProvider_";
  protected final String TEXT_48 = " = (org.neo4j.unsafe.batchinsert.BatchInserterIndexProvider) globalMap.get(\"";
  protected final String TEXT_49 = "_indexprovider\");" + NL + "           }";
  protected final String TEXT_50 = NL + "        resourceMap.put(\"indexProvider_";
  protected final String TEXT_51 = "\", indexProvider_";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "            if(indexProvider_";
  protected final String TEXT_54 = "!=null){" + NL + "                indexProvider_";
  protected final String TEXT_55 = ".shutdown();" + NL + "            }";
  protected final String TEXT_56 = NL + "           if ((indexProvider_";
  protected final String TEXT_57 = "!=null) && (globalMap.containsKey(\"";
  protected final String TEXT_58 = "_indexprovider\"))) {" + NL + "               indexProvider_";
  protected final String TEXT_59 = ".shutdown();" + NL + "               globalMap.remove(\"";
  protected final String TEXT_60 = "_indexprovider\");" + NL + "           }";
  protected final String TEXT_61 = NL + "        org.neo4j.unsafe.batchinsert.BatchInserter inserter_";
  protected final String TEXT_62 = " = null;" + NL + "        if (databaseService_";
  protected final String TEXT_63 = " instanceof org.neo4j.kernel.EmbeddedGraphDatabase) {";
  protected final String TEXT_64 = NL + "                org.neo4j.kernel.EmbeddedGraphDatabase db_";
  protected final String TEXT_65 = " = (org.neo4j.kernel.EmbeddedGraphDatabase) databaseService_";
  protected final String TEXT_66 = ";" + NL + "                storeDir_";
  protected final String TEXT_67 = " = db_";
  protected final String TEXT_68 = ".getStoreDir();" + NL + "                db_";
  protected final String TEXT_69 = ".shutdown();" + NL + "                inserter_";
  protected final String TEXT_70 = " = org.neo4j.unsafe.batchinsert.BatchInserters.inserter(db_";
  protected final String TEXT_71 = ".getStoreDir(), importProperties_";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = NL + "               if (!globalMap.containsKey(\"";
  protected final String TEXT_74 = "_inserter\")) {" + NL + "                   org.neo4j.kernel.EmbeddedGraphDatabase db_";
  protected final String TEXT_75 = " = (org.neo4j.kernel.EmbeddedGraphDatabase) databaseService_";
  protected final String TEXT_76 = ";" + NL + "                   storeDir_";
  protected final String TEXT_77 = " = db_";
  protected final String TEXT_78 = ".getStoreDir();" + NL + "                   db_";
  protected final String TEXT_79 = ".shutdown();" + NL + "                   inserter_";
  protected final String TEXT_80 = " = org.neo4j.unsafe.batchinsert.BatchInserters.inserter(db_";
  protected final String TEXT_81 = ".getStoreDir(), importProperties_";
  protected final String TEXT_82 = ");" + NL + "                   globalMap.put(\"";
  protected final String TEXT_83 = "_inserter\", inserter_";
  protected final String TEXT_84 = ");" + NL + "                   globalMap.put(\"";
  protected final String TEXT_85 = "_is_temporary_shutted_down\", true);" + NL + "               } else {" + NL + "                   inserter_";
  protected final String TEXT_86 = " = (org.neo4j.unsafe.batchinsert.BatchInserter) globalMap.get(\"";
  protected final String TEXT_87 = "_inserter\");" + NL + "               }";
  protected final String TEXT_88 = NL + "        } else {" + NL + "            throw new UnsupportedOperationException(\"Not supported yet\");" + NL + "        }" + NL + "        resourceMap.put(\"inserter_";
  protected final String TEXT_89 = "\", inserter_";
  protected final String TEXT_90 = ");";
  protected final String TEXT_91 = NL + "            if(inserter_";
  protected final String TEXT_92 = "!=null){" + NL + "                inserter_";
  protected final String TEXT_93 = ".shutdown();" + NL + "            }";
  protected final String TEXT_94 = NL + "           if ((inserter_";
  protected final String TEXT_95 = "!=null) && (globalMap.containsKey(\"";
  protected final String TEXT_96 = "_inserter\"))) {" + NL + "               try {" + NL + "                   inserter_";
  protected final String TEXT_97 = ".shutdown();" + NL + "                   globalMap.remove(\"";
  protected final String TEXT_98 = "_inserter\");" + NL + "               } catch (IllegalStateException e_";
  protected final String TEXT_99 = ") {" + NL + "                   // Nothing, the shutdown must be called two times due to multiples components" + NL + "               }" + NL + "           }";
  protected final String TEXT_100 = NL + "            databaseService_";
  protected final String TEXT_101 = " = new org.neo4j.kernel.EmbeddedGraphDatabase(storeDir_";
  protected final String TEXT_102 = ");" + NL + "            globalMap.put(\"";
  protected final String TEXT_103 = "\", databaseService_";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = NL + "           // if the db connection is still shutted down, reopen it for further components." + NL + "           // Otherwise, that mean that another component with the embedded connection has done it previously" + NL + "           if (((Boolean) globalMap.get(\"";
  protected final String TEXT_106 = "_is_temporary_shutted_down\"))) {" + NL + "               databaseService_";
  protected final String TEXT_107 = " = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase((String)globalMap.get(\"";
  protected final String TEXT_108 = "_path\"));" + NL + "               globalMap.put(\"";
  protected final String TEXT_109 = "\", databaseService_";
  protected final String TEXT_110 = ");" + NL + "               globalMap.put(\"";
  protected final String TEXT_111 = "_is_temporary_shutted_down\", false);" + NL + "           }";
  protected final String TEXT_112 = NL + "    \torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_113 = " = (org.neo4j.graphdb.GraphDatabaseService) globalMap.get(\"";
  protected final String TEXT_114 = "\");" + NL + "    \t";
  protected final String TEXT_115 = NL + "    \t\torg.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_116 = " = new org.neo4j.rest.graphdb.RestGraphDatabase(";
  protected final String TEXT_117 = ");" + NL + "    \t\t";
  protected final String TEXT_118 = NL + "            org.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_119 = " = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(";
  protected final String TEXT_120 = ");" + NL + "\t    \t";
  protected final String TEXT_121 = NL + "\tint nb_line_";
  protected final String TEXT_122 = " = 0;" + NL + "\tlong counter_";
  protected final String TEXT_123 = " = 0;";
  protected final String TEXT_124 = NL + "\tresourceMap.put(\"databaseService_";
  protected final String TEXT_125 = "\", databaseService_";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = NL + "    \tjava.util.Map<String, String> importProperties_";
  protected final String TEXT_128 = " = new java.util.HashMap<String, String>();" + NL + "\t\timportProperties_";
  protected final String TEXT_129 = ".put(\"neostore.nodestore.db.mapped_memory\", \"0M\");" + NL + "\t\timportProperties_";
  protected final String TEXT_130 = ".put(\"neostore.relationshipstore.db.mapped_memory\", ";
  protected final String TEXT_131 = ");" + NL + "\t\timportProperties_";
  protected final String TEXT_132 = ".put(\"neostore.propertystore.db.mapped_memory\", ";
  protected final String TEXT_133 = ");" + NL + "\t\timportProperties_";
  protected final String TEXT_134 = ".put(\"neostore.propertystore.db.strings.mapped_memory\", ";
  protected final String TEXT_135 = ");" + NL + "\t\timportProperties_";
  protected final String TEXT_136 = ".put(\"neostore.propertystore.db.arrays.mapped_memory\", ";
  protected final String TEXT_137 = ");" + NL + "\t\tString storeDir_";
  protected final String TEXT_138 = " = \"\";" + NL + "\t    ";
  protected final String TEXT_139 = NL + NL + "    \torg.neo4j.unsafe.batchinsert.BatchInserterIndex startIndexInserter_";
  protected final String TEXT_140 = " = indexProvider_";
  protected final String TEXT_141 = ".nodeIndex(";
  protected final String TEXT_142 = ", org.neo4j.helpers.collection.MapUtil.stringMap(\"type\", \"exact\"));" + NL + "    \torg.neo4j.unsafe.batchinsert.BatchInserterIndex endIndexInserter_";
  protected final String TEXT_143 = " = indexProvider_";
  protected final String TEXT_144 = ".nodeIndex(";
  protected final String TEXT_145 = ", org.neo4j.helpers.collection.MapUtil.stringMap(\"type\", \"exact\"));" + NL + "    \t";
  protected final String TEXT_146 = NL + "        org.neo4j.graphdb.index.Index<org.neo4j.graphdb.Node> startIndexNode_";
  protected final String TEXT_147 = " = null;" + NL + "        org.neo4j.graphdb.index.Index<org.neo4j.graphdb.Node> endIndexNode_";
  protected final String TEXT_148 = " = null;";
  protected final String TEXT_149 = NL + "    \tstartIndexNode_";
  protected final String TEXT_150 = " = databaseService_";
  protected final String TEXT_151 = ".index().forNodes(";
  protected final String TEXT_152 = ");" + NL + "    \tendIndexNode_";
  protected final String TEXT_153 = " = databaseService_";
  protected final String TEXT_154 = ".index().forNodes(";
  protected final String TEXT_155 = ");" + NL + "    \t";
  protected final String TEXT_156 = NL + NL + "\torg.neo4j.graphdb.RelationshipType relationshipType_";
  protected final String TEXT_157 = " = org.neo4j.graphdb.DynamicRelationshipType.withName(";
  protected final String TEXT_158 = ");" + NL;
  protected final String TEXT_159 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
class Neo4JTransactionHelper {
    private INode node;
    private String cid;
    private String dbVersion;
    private boolean batchImport;
    private boolean remoteServer;
    private String commitEvery;

    public Neo4JTransactionHelper(INode node) {
        this.node = node;
        this.cid = node.getUniqueName();

        this.batchImport = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__BATCH_IMPORT__"));
        this.commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
        boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));

        if (useExistingConnection) {
            String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
            for(INode targetNode : node.getProcess().getNodesOfType("tNeo4jConnection")){
                if (targetNode.getUniqueName().equals(connection)) {
                    this.dbVersion = ElementParameterParser.getValue(targetNode, "__DB_VERSION__");
                    this.remoteServer = "true".equalsIgnoreCase(ElementParameterParser.getValue(targetNode, "__REMOTE_SERVER__"));
                    break;
                }
            }
        } else {
            this.dbVersion = ElementParameterParser.getValue(node,"__DB_VERSION__");
            this.remoteServer = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REMOTE_SERVER__"));
        }

    }

    public String getDbVersion() {
        return this.dbVersion;
    }

    public void startTransaction() {
        if ("NEO4J_1_X_X".equals(this.dbVersion)) {
            
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
        } else { // NEO4J_2_1_X
            if (!this.batchImport) {
                
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
            }
        }
    }

    public void restartTransaction() {
        if ("NEO4J_1_X_X".equals(this.dbVersion)) {
            
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(this.cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(this.cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(this.cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(this.cid);
    stringBuffer.append(TEXT_13);
    
        } else { // NEO4J_2_1_X
            if (!this.batchImport) {
                
    stringBuffer.append(TEXT_14);
    stringBuffer.append(this.cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(this.cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(this.cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(this.cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(this.cid);
    stringBuffer.append(TEXT_20);
    
            }
        }
    }

    public void closeTransaction() {
        if ("NEO4J_1_X_X".equals(this.dbVersion)) {
            
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
        } else { // NEO4J_2_1_X
            if (!this.batchImport) {
                
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
            }
        }
    }

    public void startEmbeddedTransaction() {
        if ("NEO4J_1_X_X".equals(this.dbVersion)) {
            // Nothing for neo4j 1.X.X
        } else { // NEO4J_2_1_X
            if (!remoteServer) {
                
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
            }
        }
    }

    public void closeEmbeddedTransaction() {
        if ("NEO4J_1_X_X".equals(this.dbVersion)) {
            // Nothing for neo4j 1.X.X
        } else { // NEO4J_2_1_X
            if (!remoteServer) {
                
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
            }
        }
    }
}

     
class Neo4JOutputRelationshipUtil {
    private INode node;
    private String cid;
    private String dbVersion;
    private String dbConnectionName;
    private boolean batchImport;
    private String commitEvery;

    public Neo4JOutputRelationshipUtil(INode node) {
        this.node = node;
        this.cid = node.getUniqueName();

        this.batchImport = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__BATCH_IMPORT__"));
        this.commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
        boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));

        if (useExistingConnection) {
            String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
            this.dbConnectionName = "dbService_" + connection; 
            for(INode targetNode : node.getProcess().getNodesOfType("tNeo4jConnection")){
                if (targetNode.getUniqueName().equals(connection)) {
                    this.dbVersion = ElementParameterParser.getValue(targetNode, "__DB_VERSION__");
                    break;
                }
            }
        } else {
            this.dbConnectionName = "dbService_" + cid;
            this.dbVersion = ElementParameterParser.getValue(node,"__DB_VERSION__");
        }

    }

    /**
     * Write down the following java code : Get the current Neo4j index provider. If it does not exist, create one.
     */
    public void getIndexProvider() {
        
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
        if ("NEO4J_1_X_X".equals(this.dbVersion)) {
            
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
        } else { // NEO4J_2_1_X
           
    stringBuffer.append(TEXT_42);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_49);
    
        }
        
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
    }
    /**
     * Shut down the index provider. On Neo4J 2.1.X, we cannot shut it down multiples times,
     * so we need to be sure that two components will not kill it twice,
     * so we need to add some protections.
     */
    public void shutdownIndexProvider() {
        if ("NEO4J_1_X_X".equals(this.dbVersion)) {
            
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
        } else { // NEO4J_2_1_X
           
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_60);
    
        }
    }

    /**
     * Write down the following java code : Get the current Neo4j inserter. If it does not exist, shut down the database and create one.
     */
    public void getInserter() {
        
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
            if ("NEO4J_1_X_X".equals(this.dbVersion)) {
                
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
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
    
            } else { // NEO4J_2_1_X
               
    stringBuffer.append(TEXT_73);
    stringBuffer.append(dbConnectionName);
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
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_87);
    
            }
            
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
    }

    /**
     * Shutdown the inserter. On neo4J 2.1.x, we cannot shut down the database multiple times, so we need to add some protections.
     */
    public void shutdownInserter() {
        if ("NEO4J_1_X_X".equals(this.dbVersion)) {
            
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
        } else { // NEO4J_2_1_X
           
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
        }
    }

    /**
     * Restart an embedded database for computation of the futurs components.
     */
    public void restartEmbeddedDatabase() {
        if ("NEO4J_1_X_X".equals(this.dbVersion)) {
            
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
        } else { // NEO4J_2_1_X
           
    stringBuffer.append(TEXT_105);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_111);
    
        }
    }
}

    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
    boolean batchImport = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__BATCH_IMPORT__"));
    boolean shutdownDb = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SHUTDOWN_DB__"));
    boolean remoteServer = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REMOTE_SERVER__"));

    Neo4JTransactionHelper neo4JTransactionHelper = new Neo4JTransactionHelper(node);
    Neo4JOutputRelationshipUtil neo4JOutputRelationshipUtil = new Neo4JOutputRelationshipUtil(node);

    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
    String dbconn = "dbService_" + connection;

    if (useExistingConnection) {
    	
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(dbconn);
    stringBuffer.append(TEXT_114);
    
    } else {
    	if (remoteServer) {
    		String serverUrl = ElementParameterParser.getValue(node, "__SERVER_URL__");
    		
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(serverUrl);
    stringBuffer.append(TEXT_117);
    
    	} else {
	    	String databasePath = ElementParameterParser.getValue(node, "__DATABASE_PATH__");
	    	
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(databasePath);
    stringBuffer.append(TEXT_120);
    
    	}
    }
    String startIndexName = ElementParameterParser.getValue(node, "__START_INDEX_NAME__");
    String endIndexName = ElementParameterParser.getValue(node, "__END_INDEX_NAME__");

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
	if (!batchImport && (!useExistingConnection||(useExistingConnection && shutdownDb))) {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
	}
    String relationshipType = ElementParameterParser.getValue(node, "__RELATIONSHIP_TYPE__");
    if (batchImport) {
    	String relationshipMappedMemory = ElementParameterParser.getValue(node, "__RELATIONSHIP_MAPPED_MEMORY__");
		String propertyMappedMemory = ElementParameterParser.getValue(node, "__PROPERTY_MAPPED_MEMORY__");
		String stringsMappedMemory = ElementParameterParser.getValue(node, "__STRINGS_MAPPED_MEMORY__");
		String arraysMappedMemory = ElementParameterParser.getValue(node, "__ARRAYS_MAPPED_MEMORY__");
    	
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(relationshipMappedMemory);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(propertyMappedMemory);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(stringsMappedMemory);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(arraysMappedMemory);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
        neo4JOutputRelationshipUtil.getInserter();
        neo4JOutputRelationshipUtil.getIndexProvider();
	    
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(startIndexName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(endIndexName);
    stringBuffer.append(TEXT_145);
    
    } else {
        
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
        neo4JTransactionHelper.startEmbeddedTransaction();
        
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(startIndexName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(endIndexName);
    stringBuffer.append(TEXT_155);
    
        neo4JTransactionHelper.closeEmbeddedTransaction();
    }
    
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(relationshipType);
    stringBuffer.append(TEXT_158);
    
neo4JTransactionHelper.startTransaction();

    stringBuffer.append(TEXT_159);
    return stringBuffer.toString();
  }
}
