package org.talend.designer.codegen.translators.databases.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

public class TNeo4jOutputBeginJava
{
  protected static String nl;
  public static synchronized TNeo4jOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jOutputBeginJava result = new TNeo4jOutputBeginJava();
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
  protected final String TEXT_37 = NL + "            org.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_38 = " = (org.neo4j.graphdb.GraphDatabaseService) globalMap.get(\"";
  protected final String TEXT_39 = "\");";
  protected final String TEXT_40 = NL + "                org.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_41 = " = new org.neo4j.rest.graphdb.RestGraphDatabase(";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "                org.neo4j.graphdb.GraphDatabaseService databaseService_";
  protected final String TEXT_44 = " = null;" + NL + "                try{" + NL + "                \t\tdatabaseService_";
  protected final String TEXT_45 = " = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(";
  protected final String TEXT_46 = ");" + NL + "                }catch(java.lang.RuntimeException e){" + NL + "\t\t\t\t\t\t\tthrow new java.lang.RuntimeException(\"There may be inconsistency between the selected database version and the actual database version. Please check.\", e);" + NL + "                }";
  protected final String TEXT_47 = NL + "        if (databaseService_";
  protected final String TEXT_48 = " instanceof org.neo4j.kernel.EmbeddedGraphDatabase) {" + NL + "            org.neo4j.kernel.EmbeddedGraphDatabase db_";
  protected final String TEXT_49 = " = (org.neo4j.kernel.EmbeddedGraphDatabase) databaseService_";
  protected final String TEXT_50 = ";" + NL + "            storeDir_";
  protected final String TEXT_51 = " = db_";
  protected final String TEXT_52 = ".getStoreDir();" + NL + "            db_";
  protected final String TEXT_53 = ".shutdown();" + NL + "            inserter_";
  protected final String TEXT_54 = " = org.neo4j.unsafe.batchinsert.BatchInserters.inserter(db_";
  protected final String TEXT_55 = ".getStoreDir(), importProperties_";
  protected final String TEXT_56 = ");" + NL + "        } else {" + NL + "            throw new UnsupportedOperationException(\"Batch import is not supported with database server edition\");" + NL + "        }" + NL + "        indexProvider_";
  protected final String TEXT_57 = " = new org.neo4j.index.lucene.unsafe.batchinsert.LuceneBatchInserterIndexProvider(inserter_";
  protected final String TEXT_58 = ");" + NL + "        resourceMap.put(\"inserter_";
  protected final String TEXT_59 = "\", inserter_";
  protected final String TEXT_60 = ");" + NL + "        resourceMap.put(\"indexProvider_";
  protected final String TEXT_61 = "\", indexProvider_";
  protected final String TEXT_62 = ");" + NL + "        java.util.Map<String, org.neo4j.unsafe.batchinsert.BatchInserterIndex> indexInserterMap_";
  protected final String TEXT_63 = " = new java.util.HashMap<String, org.neo4j.unsafe.batchinsert.BatchInserterIndex>();";
  protected final String TEXT_64 = NL + "            indexInserterMap_";
  protected final String TEXT_65 = ".put(";
  protected final String TEXT_66 = ", indexProvider_";
  protected final String TEXT_67 = ".nodeIndex(";
  protected final String TEXT_68 = ", org.neo4j.helpers.collection.MapUtil.stringMap(\"type\", \"exact\")));";
  protected final String TEXT_69 = NL + "            org.neo4j.graphdb.index.AutoIndexer<org.neo4j.graphdb.Node> autoIndexer_";
  protected final String TEXT_70 = " = databaseService_";
  protected final String TEXT_71 = ".index().getNodeAutoIndexer();" + NL + "            autoIndexer_";
  protected final String TEXT_72 = ".setEnabled(true);";
  protected final String TEXT_73 = NL + "            autoIndexer_";
  protected final String TEXT_74 = ".startAutoIndexingProperty(\"";
  protected final String TEXT_75 = "\");";
  protected final String TEXT_76 = NL + "        if (databaseService_";
  protected final String TEXT_77 = " instanceof org.neo4j.kernel.EmbeddedGraphDatabase) {" + NL + "            if (!globalMap.containsKey(\"";
  protected final String TEXT_78 = "_inserter\")) {" + NL + "                org.neo4j.kernel.EmbeddedGraphDatabase db_";
  protected final String TEXT_79 = " = (org.neo4j.kernel.EmbeddedGraphDatabase) databaseService_";
  protected final String TEXT_80 = ";" + NL + "                storeDir_";
  protected final String TEXT_81 = " = db_";
  protected final String TEXT_82 = ".getStoreDir();" + NL + "                db_";
  protected final String TEXT_83 = ".shutdown();" + NL + "                inserter_";
  protected final String TEXT_84 = " = org.neo4j.unsafe.batchinsert.BatchInserters.inserter(db_";
  protected final String TEXT_85 = ".getStoreDir(), importProperties_";
  protected final String TEXT_86 = ");" + NL + "                globalMap.put(\"";
  protected final String TEXT_87 = "_inserter\", inserter_";
  protected final String TEXT_88 = ");" + NL + "                globalMap.put(\"";
  protected final String TEXT_89 = "_is_temporary_shutted_down\", true);" + NL + "            } else {" + NL + "               inserter_";
  protected final String TEXT_90 = " = (org.neo4j.unsafe.batchinsert.BatchInserter) globalMap.get(\"";
  protected final String TEXT_91 = "_inserter\");" + NL + "            }" + NL + "        } else {" + NL + "            throw new UnsupportedOperationException(\"Batch import is not supported with database server edition\");" + NL + "        }" + NL + "" + NL + "        if (!globalMap.containsKey(\"";
  protected final String TEXT_92 = "_indexprovider\")) {" + NL + "            indexProvider_";
  protected final String TEXT_93 = " = new org.neo4j.index.lucene.unsafe.batchinsert.LuceneBatchInserterIndexProvider(inserter_";
  protected final String TEXT_94 = ");" + NL + "            globalMap.put(\"";
  protected final String TEXT_95 = "_indexprovider\", indexProvider_";
  protected final String TEXT_96 = ");" + NL + "        } else {" + NL + "            indexProvider_";
  protected final String TEXT_97 = " = (org.neo4j.unsafe.batchinsert.BatchInserterIndexProvider) globalMap.get(\"";
  protected final String TEXT_98 = "_indexprovider\");" + NL + "        }" + NL + "        resourceMap.put(\"inserter_";
  protected final String TEXT_99 = "\", inserter_";
  protected final String TEXT_100 = ");" + NL + "        resourceMap.put(\"indexProvider_";
  protected final String TEXT_101 = "\", indexProvider_";
  protected final String TEXT_102 = ");" + NL + "        java.util.Map<String, org.neo4j.unsafe.batchinsert.BatchInserterIndex> indexInserterMap_";
  protected final String TEXT_103 = " = new java.util.HashMap<String, org.neo4j.unsafe.batchinsert.BatchInserterIndex>();" + NL;
  protected final String TEXT_104 = NL + "            indexInserterMap_";
  protected final String TEXT_105 = ".put(";
  protected final String TEXT_106 = ", indexProvider_";
  protected final String TEXT_107 = ".nodeIndex(";
  protected final String TEXT_108 = ", org.neo4j.helpers.collection.MapUtil.stringMap(\"type\", \"exact\")));";
  protected final String TEXT_109 = NL + "            org.neo4j.unsafe.batchinsert.BatchInserterIndex autoindex_";
  protected final String TEXT_110 = " = indexProvider_";
  protected final String TEXT_111 = ".nodeIndex(\"node_auto_index\", org.neo4j.helpers.collection.MapUtil.stringMap(\"type\", \"exact\"));" + NL + "            long autoindex_id_";
  protected final String TEXT_112 = "  = inserter_";
  protected final String TEXT_113 = ".createNode(null);" + NL + "            java.util.Map<String, Object> autoindex_props_";
  protected final String TEXT_114 = " = new java.util.HashMap<String, Object>();";
  protected final String TEXT_115 = NL + "        java.util.Map<String, String> importProperties_";
  protected final String TEXT_116 = " = new java.util.HashMap<String, String>();" + NL + "        importProperties_";
  protected final String TEXT_117 = ".put(\"neostore.nodestore.db.mapped_memory\", ";
  protected final String TEXT_118 = ");" + NL + "        importProperties_";
  protected final String TEXT_119 = ".put(\"neostore.relationshipstore.db.mapped_memory\", ";
  protected final String TEXT_120 = ");" + NL + "        importProperties_";
  protected final String TEXT_121 = ".put(\"neostore.propertystore.db.mapped_memory\", ";
  protected final String TEXT_122 = ");" + NL + "        importProperties_";
  protected final String TEXT_123 = ".put(\"neostore.propertystore.db.strings.mapped_memory\", ";
  protected final String TEXT_124 = ");" + NL + "        importProperties_";
  protected final String TEXT_125 = ".put(\"neostore.propertystore.db.arrays.mapped_memory\", ";
  protected final String TEXT_126 = ");" + NL + "        String storeDir_";
  protected final String TEXT_127 = " = \"\";" + NL + "        org.neo4j.unsafe.batchinsert.BatchInserter inserter_";
  protected final String TEXT_128 = " = null;" + NL + "        org.neo4j.unsafe.batchinsert.BatchInserterIndexProvider indexProvider_";
  protected final String TEXT_129 = " = null;" + NL;
  protected final String TEXT_130 = NL + "        java.util.Map<String, org.neo4j.graphdb.index.Index<org.neo4j.graphdb.Node>> indexNodeMap_";
  protected final String TEXT_131 = " = new java.util.HashMap<String,org.neo4j.graphdb.index.Index<org.neo4j.graphdb.Node>>();";
  protected final String TEXT_132 = NL + "            indexNodeMap_";
  protected final String TEXT_133 = ".put(";
  protected final String TEXT_134 = ", databaseService_";
  protected final String TEXT_135 = ".index().forNodes(";
  protected final String TEXT_136 = "));";
  protected final String TEXT_137 = NL + "            org.neo4j.graphdb.index.AutoIndexer<org.neo4j.graphdb.Node> autoIndexer_";
  protected final String TEXT_138 = " = databaseService_";
  protected final String TEXT_139 = ".index().getNodeAutoIndexer();" + NL + "            autoIndexer_";
  protected final String TEXT_140 = ".setEnabled(true);";
  protected final String TEXT_141 = NL + "            autoIndexer_";
  protected final String TEXT_142 = ".startAutoIndexingProperty(\"";
  protected final String TEXT_143 = "\");";
  protected final String TEXT_144 = NL + NL;
  protected final String TEXT_145 = NL + "int nb_line_";
  protected final String TEXT_146 = " = 0;" + NL + "long counter_";
  protected final String TEXT_147 = " = 0;";
  protected final String TEXT_148 = NL + "\tresourceMap.put(\"databaseService_";
  protected final String TEXT_149 = "\", databaseService_";
  protected final String TEXT_150 = ");";
  protected final String TEXT_151 = NL;

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

    
class Neo4JOutputUtil {
    private Neo4JTransactionHelper neo4JTransactionHelper;
    private INode node;
    private String cid;
    private boolean batchImport;
    private String dbConnectionName;
    private String dbVersion;
    private boolean useExistingConnection;
    private boolean remoteServer;

    public Neo4JOutputUtil(INode node) {
        this.node = node;
        this.cid = node.getUniqueName();
        this.neo4JTransactionHelper = new Neo4JTransactionHelper(node);

        this.batchImport = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__BATCH_IMPORT__"));
        this.useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));

        if (useExistingConnection) {
            String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
            this.dbConnectionName = "dbService_" + connection; 
            for(INode targetNode : node.getProcess().getNodesOfType("tNeo4jConnection")){
                if (targetNode.getUniqueName().equals(connection)) {
                    this.dbVersion = ElementParameterParser.getValue(targetNode, "__DB_VERSION__");
                    this.remoteServer = "true".equalsIgnoreCase(ElementParameterParser.getValue(targetNode, "__REMOTE_SERVER__"));
                    break;
                }
            }
        } else {
            this.dbConnectionName = "dbService_" + cid;
            this.dbVersion = ElementParameterParser.getValue(node,"__DB_VERSION__");
            this.remoteServer = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REMOTE_SERVER__"));
        }
    }


    public void createDatabaseService() {
        if (this.useExistingConnection) {
            
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_39);
    
        } else {
            if (this.remoteServer) {
                String serverUrl = ElementParameterParser.getValue(node, "__SERVER_URL__");
                
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(serverUrl);
    stringBuffer.append(TEXT_42);
    
            } else {
                String databasePath = ElementParameterParser.getValue(node, "__DATABASE_PATH__");
                
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(databasePath);
    stringBuffer.append(TEXT_46);
    
            }
        }
    }

    private void writeBatchModeVersion1_9(Set<String> indexNames, List<String> autoIndexedColumns) {
        
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
        for (String indexName : indexNames) {
            
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(indexName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(indexName);
    stringBuffer.append(TEXT_68);
    
        }

        // Auto index configuration
        if (autoIndexedColumns.size() > 0) {
            
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
        }
        for (String autoIndexedColumn : autoIndexedColumns) {
            
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(autoIndexedColumn);
    stringBuffer.append(TEXT_75);
    
        }
        neo4JTransactionHelper.startTransaction();
    }

    private void writeBatchModeVersion2_1(Set<String> indexNames, List<String> autoIndexedColumns) {
        
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(dbConnectionName);
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
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(dbConnectionName);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(dbConnectionName);
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
    
        for (String indexName : indexNames) {
            
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(indexName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(indexName);
    stringBuffer.append(TEXT_108);
    
        }

        // There is no autoindex in batch mode, so we did it by hand.
        if (autoIndexedColumns.size() > 0) {
            
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
    
        }
    }

    private void writeBatchMode(Set<String> indexNames, List<String> autoIndexedColumns) {
        String nodeMappedMemory = ElementParameterParser.getValue(node, "__NODE_MAPPED_MEMORY__");
        String relationshipMappedMemory = ElementParameterParser.getValue(node, "__RELATIONSHIP_MAPPED_MEMORY__");
        String propertyMappedMemory = ElementParameterParser.getValue(node, "__PROPERTY_MAPPED_MEMORY__");
        String stringsMappedMemory = ElementParameterParser.getValue(node, "__STRINGS_MAPPED_MEMORY__");
        String arraysMappedMemory = ElementParameterParser.getValue(node, "__ARRAYS_MAPPED_MEMORY__");
        
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(nodeMappedMemory);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(relationshipMappedMemory);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(propertyMappedMemory);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(stringsMappedMemory);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(arraysMappedMemory);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
        if ("NEO4J_1_X_X".equals(dbVersion)) {
            writeBatchModeVersion1_9(indexNames, autoIndexedColumns);
        } else { // NEO4J_2_1_X
            writeBatchModeVersion2_1(indexNames, autoIndexedColumns);
        }
    }

    private void writeNormalMode(Set<String> indexNames, List<String> autoIndexedColumns) {
        
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    
        neo4JTransactionHelper.startEmbeddedTransaction();

        for (String indexName : indexNames) {
            
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(indexName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(indexName);
    stringBuffer.append(TEXT_136);
    
        }

        neo4JTransactionHelper.closeEmbeddedTransaction();

        // Auto index configuration
        if (autoIndexedColumns.size() > 0) {
            
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
        }
        for (String autoIndexedColumn : autoIndexedColumns) {
            
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(autoIndexedColumn);
    stringBuffer.append(TEXT_143);
    
        }
        neo4JTransactionHelper.startTransaction();
    }
}

    stringBuffer.append(TEXT_144);
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    boolean batchImport = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__BATCH_IMPORT__"));
    boolean shutdownDb = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SHUTDOWN_DB__"));
    List<Map<String, String>> values = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__VALUES__");

    List<String> autoIndexedColumns = new ArrayList<String>();
    Set<String> indexNames = new HashSet();
    for (Map<String, String> value : values) {
    	boolean autoIndexed = Boolean.valueOf(value.get("AUTO_INDEXED"));
   		if (autoIndexed) {
   			autoIndexedColumns.add(value.get("SCHEMA_COLUMN"));
   		}

   		String strIndexNames = value.get("INDEX_NAMES");
   		if (strIndexNames != null && !strIndexNames.isEmpty()) {
   			indexNames.addAll(Arrays.asList(strIndexNames.split(",")));
   		}
    }

    // Add update/delete index
    String action = (String) ElementParameterParser.getObjectValue(node, "__DATA_ACTION__");
    if (!action.equals("INSERT")) {
    	indexNames.add((String) ElementParameterParser.getObjectValue(node, "__INDEX_NAME__"));
    }

    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));

    Neo4JOutputUtil neo4JOutputUtil = new Neo4JOutputUtil(node);

    neo4JOutputUtil.createDatabaseService();

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    
	if (!batchImport && (!useExistingConnection||(useExistingConnection && shutdownDb))) {

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    
	}
    // Index configuration
    if (batchImport) {
        neo4JOutputUtil.writeBatchMode(indexNames, autoIndexedColumns);
    } else {
        neo4JOutputUtil.writeNormalMode(indexNames, autoIndexedColumns);
    }

    stringBuffer.append(TEXT_151);
    return stringBuffer.toString();
  }
}
