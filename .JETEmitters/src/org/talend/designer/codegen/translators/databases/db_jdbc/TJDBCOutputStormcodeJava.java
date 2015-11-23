package org.talend.designer.codegen.translators.databases.db_jdbc;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TJDBCOutputStormcodeJava
{
  protected static String nl;
  public static synchronized TJDBCOutputStormcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCOutputStormcodeJava result = new TJDBCOutputStormcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            ";
  protected final String TEXT_2 = " stream_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL + "        public static class ";
  protected final String TEXT_6 = " implements Serializable {";
  protected final String TEXT_7 = NL + "        }";
  protected final String TEXT_8 = NL + "        public final static Fields fields = new Fields(";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "            public static final int tupleIndex";
  protected final String TEXT_11 = "_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ";";
  protected final String TEXT_14 = NL + "        /** Default serial version UID. */" + NL + "        private static final long serialVersionUID = 1L;";
  protected final String TEXT_15 = NL + "           private TridentTuple tuple;";
  protected final String TEXT_16 = NL + "            ";
  protected final String TEXT_17 = "(TridentTuple tuple) {";
  protected final String TEXT_18 = NL + "            }";
  protected final String TEXT_19 = NL + "            this.tuple = tuple;";
  protected final String TEXT_20 = NL + "            public TridentTuple getTuple() {" + NL + "                return tuple;" + NL + "            }" + NL + "" + NL + "            public void setTuple(TridentTuple tuple) {" + NL + "                this.tuple = tuple;" + NL + "            }";
  protected final String TEXT_21 = NL + "            public final static String getField";
  protected final String TEXT_22 = "_";
  protected final String TEXT_23 = "() {";
  protected final String TEXT_24 = NL + "                    return \"";
  protected final String TEXT_25 = "__";
  protected final String TEXT_26 = "\";";
  protected final String TEXT_27 = NL + "                    return ";
  protected final String TEXT_28 = ";";
  protected final String TEXT_29 = NL + "            }";
  protected final String TEXT_30 = NL + "            public final ";
  protected final String TEXT_31 = " get";
  protected final String TEXT_32 = "_";
  protected final String TEXT_33 = "() {" + NL + "                return ";
  protected final String TEXT_34 = "(tupleIndex";
  protected final String TEXT_35 = "_";
  protected final String TEXT_36 = ");" + NL + "            }";
  protected final String TEXT_37 = NL + "        public final static Values createValues(";
  protected final String TEXT_38 = " ";
  protected final String TEXT_39 = ") {" + NL + "            return new Values(";
  protected final String TEXT_40 = NL + "            );" + NL + "        }";
  protected final String TEXT_41 = NL + "        public static class ";
  protected final String TEXT_42 = " extends ";
  protected final String TEXT_43 = " {" + NL + "            /** Default serial version UID. */" + NL + "            private static final long serialVersionUID = 1L;" + NL + "            public ";
  protected final String TEXT_44 = "(TridentTuple tuple) {" + NL + "                super(tuple);" + NL + "            }" + NL + "        }";
  protected final String TEXT_45 = NL + NL + "public static class StormFunction_";
  protected final String TEXT_46 = " extends storm.trident.operation.BaseFunction {" + NL + "" + NL + "    private ContextProperties context;" + NL + "" + NL + "    private final ";
  protected final String TEXT_47 = " input" + NL + "            = new ";
  protected final String TEXT_48 = "(null);" + NL + "" + NL + "    private java.sql.Connection connection;" + NL + "    private java.sql.PreparedStatement statement;" + NL + "    private int batchSize = ";
  protected final String TEXT_49 = ";" + NL + "    private int batchSizeCounter = 0;" + NL + NL;
  protected final String TEXT_50 = NL + NL + "    @Override" + NL + "    public void prepare(Map conf, TridentOperationContext tContext) {" + NL + "        context = new ContextProperties(conf);" + NL + "" + NL + "        try {" + NL + "            Class.forName(";
  protected final String TEXT_51 = ");" + NL;
  protected final String TEXT_52 = NL;
  protected final String TEXT_53 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_54 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = "; ";
  protected final String TEXT_59 = NL + NL + "            this.connection = java.sql.DriverManager.getConnection(";
  protected final String TEXT_60 = ", ";
  protected final String TEXT_61 = ", decryptedPassword_";
  protected final String TEXT_62 = ");" + NL + "            String dbName = connection.getMetaData().getDatabaseProductName().toUpperCase();" + NL + "            this.connection.setAutoCommit(false);" + NL;
  protected final String TEXT_63 = NL + "            String[] fieldNames = {";
  protected final String TEXT_64 = "};" + NL + "" + NL + "            statement = connection.prepareStatement((new org.talend.hadoop.mapred.lib.db.JDBCHelper(connection)).constructQuery(";
  protected final String TEXT_65 = ", fieldNames));" + NL + "        } catch (Exception ex) {" + NL + "            // Something has gone wrong in setting up the query, which is a" + NL + "            // job configuration problem (not a JDBC connection problem)." + NL + "            // There's little hope of proceeding at this stage." + NL + "            ex.printStackTrace();" + NL + "            throw new backtype.storm.topology.FailedException(ex.getMessage());" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public void execute(TridentTuple tuple, TridentCollector collector) {" + NL + "        input.setTuple(tuple);" + NL + "        try {";
  protected final String TEXT_66 = NL + "                        if(String.valueOf(";
  protected final String TEXT_67 = ").toLowerCase().equals(\"null\")) {" + NL + "                            statement.setNull(";
  protected final String TEXT_68 = ", java.sql.Types.CHAR);" + NL + "                        }else if(";
  protected final String TEXT_69 = " == '\\0'){" + NL + "                            statement.setString(";
  protected final String TEXT_70 = ", \"\");" + NL + "                        }else{" + NL + "                            statement.setString(";
  protected final String TEXT_71 = ", String.valueOf(";
  protected final String TEXT_72 = "));" + NL + "                        }";
  protected final String TEXT_73 = NL + "                        statement.set";
  protected final String TEXT_74 = "(";
  protected final String TEXT_75 = ", ";
  protected final String TEXT_76 = ");";
  protected final String TEXT_77 = NL + "                    if(";
  protected final String TEXT_78 = " != null){" + NL + "                        statement.setBoolean(";
  protected final String TEXT_79 = ", ";
  protected final String TEXT_80 = ");" + NL + "                    }else{" + NL + "                        statement.setNull(";
  protected final String TEXT_81 = ", java.sql.Types.BOOLEAN);" + NL + "                    }";
  protected final String TEXT_82 = NL + "                    if(";
  protected final String TEXT_83 = " != null){" + NL + "                        statement.setByte(";
  protected final String TEXT_84 = ", ";
  protected final String TEXT_85 = ");" + NL + "                    }else{" + NL + "                        statement.setNull(";
  protected final String TEXT_86 = ", java.sql.Types.INTEGER);" + NL + "                    }";
  protected final String TEXT_87 = NL + "                    if(";
  protected final String TEXT_88 = " != null){" + NL + "                        statement.setBytes(";
  protected final String TEXT_89 = ", ";
  protected final String TEXT_90 = ");" + NL + "                    }else{" + NL + "                        statement.setNull(";
  protected final String TEXT_91 = ", java.sql.Types.ARRAY);" + NL + "                    }";
  protected final String TEXT_92 = NL + "                    if(";
  protected final String TEXT_93 = " != null){" + NL + "                        statement.setString(";
  protected final String TEXT_94 = ", String.valueOf(";
  protected final String TEXT_95 = "));" + NL + "                    }else{" + NL + "                        statement.setNull(";
  protected final String TEXT_96 = ", java.sql.Types.CHAR);" + NL + "                    }";
  protected final String TEXT_97 = NL + "                    if(";
  protected final String TEXT_98 = " != null){" + NL + "                        statement.setTimestamp(";
  protected final String TEXT_99 = ", new java.sql.Timestamp(";
  protected final String TEXT_100 = ".getTime()));" + NL + "                    }else{" + NL + "                        statement.setNull(";
  protected final String TEXT_101 = ", java.sql.Types.DATE);" + NL + "                    }";
  protected final String TEXT_102 = NL + "                    if(";
  protected final String TEXT_103 = " != null){" + NL + "                        statement.setDouble(";
  protected final String TEXT_104 = ", ";
  protected final String TEXT_105 = ");" + NL + "                    }else{" + NL + "                        statement.setNull(";
  protected final String TEXT_106 = ", java.sql.Types.DOUBLE);" + NL + "                    }";
  protected final String TEXT_107 = NL + "                    if(";
  protected final String TEXT_108 = " != null){" + NL + "                        statement.setFloat(";
  protected final String TEXT_109 = ", ";
  protected final String TEXT_110 = ");" + NL + "                    }else{" + NL + "                        statement.setNull(";
  protected final String TEXT_111 = ", java.sql.Types.FLOAT);" + NL + "                    }";
  protected final String TEXT_112 = NL + "                    statement.setBigDecimal(";
  protected final String TEXT_113 = ", ";
  protected final String TEXT_114 = ");";
  protected final String TEXT_115 = NL + "                    if(";
  protected final String TEXT_116 = " != null){" + NL + "                        statement.setInt(";
  protected final String TEXT_117 = ", ";
  protected final String TEXT_118 = ");" + NL + "                    }else{" + NL + "                        statement.setNull(";
  protected final String TEXT_119 = ", java.sql.Types.INTEGER);" + NL + "                    }";
  protected final String TEXT_120 = NL + "                    if(";
  protected final String TEXT_121 = " != null){" + NL + "                        statement.setLong(";
  protected final String TEXT_122 = ", ";
  protected final String TEXT_123 = ");" + NL + "                    }else{" + NL + "                        statement.setNull(";
  protected final String TEXT_124 = ", java.sql.Types.INTEGER);" + NL + "                    }";
  protected final String TEXT_125 = NL + "                    if(";
  protected final String TEXT_126 = " != null){" + NL + "                        statement.setObject(";
  protected final String TEXT_127 = ", ";
  protected final String TEXT_128 = ");" + NL + "                    }else{" + NL + "                        statement.setNull(";
  protected final String TEXT_129 = ", java.sql.Types.OTHER);" + NL + "                    }";
  protected final String TEXT_130 = NL + "                    if(";
  protected final String TEXT_131 = " != null){" + NL + "                        statement.setShort(";
  protected final String TEXT_132 = ", ";
  protected final String TEXT_133 = ");" + NL + "                    }else{" + NL + "                        statement.setNull(";
  protected final String TEXT_134 = ", java.sql.Types.INTEGER);" + NL + "                    }";
  protected final String TEXT_135 = NL + "                    if(";
  protected final String TEXT_136 = " != null){" + NL + "                        statement.setString(";
  protected final String TEXT_137 = ", ";
  protected final String TEXT_138 = ");" + NL + "                    }else{" + NL + "                        statement.setNull(";
  protected final String TEXT_139 = ", java.sql.Types.VARCHAR);" + NL + "                    }";
  protected final String TEXT_140 = NL + "                    statement.setObject(";
  protected final String TEXT_141 = ", ";
  protected final String TEXT_142 = ");";
  protected final String TEXT_143 = NL + "                statement.addBatch();";
  protected final String TEXT_144 = NL + "                    batchSizeCounter++;" + NL + "                    if (batchSizeCounter >= batchSize ) {" + NL + "                        batchSizeCounter=0;" + NL + "                        statement.executeBatch();" + NL + "                        statement.clearBatch();" + NL + "                        if (connection!=null && !connection.isClosed()) {" + NL + "                            connection.commit();" + NL + "                        }" + NL + "                    }";
  protected final String TEXT_145 = NL + "                statement.executeUpdate();" + NL + "                if (connection!=null && !connection.isClosed()) {" + NL + "                    connection.commit();" + NL + "                }";
  protected final String TEXT_146 = NL + "        } catch (java.sql.SQLException e) {" + NL + "            try {" + NL + "                e.printStackTrace();" + NL + "                rollbackDb();" + NL + "                throw new backtype.storm.topology.FailedException(e.getMessage());" + NL + "            } finally {" + NL + "                closeDb();" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public void cleanup() {" + NL + "        try {";
  protected final String TEXT_147 = NL + "                if(batchSize>0 && statement!=null && batchSizeCounter>0){" + NL + "                    statement.executeBatch();" + NL + "                    statement.clearBatch();" + NL + "                }";
  protected final String TEXT_148 = NL + "            if (connection!=null && !connection.isClosed()) {" + NL + "                connection.commit();" + NL + "            }" + NL + "        } catch (java.sql.SQLException e) {" + NL + "            rollbackDb();" + NL + "            throw new backtype.storm.topology.FailedException(e.getMessage());" + NL + "        } finally {" + NL + "            closeDb();" + NL + "        }" + NL + "    }" + NL + "" + NL + "    private void rollbackDb() throws backtype.storm.topology.FailedException {" + NL + "        try {" + NL + "            if (connection != null && !connection.isClosed()) {" + NL + "                connection.rollback();" + NL + "            }" + NL + "        } catch (java.sql.SQLException e) {" + NL + "            throw new backtype.storm.topology.FailedException(e.getMessage());" + NL + "        }" + NL + "    }" + NL + "" + NL + "    private void closeDb() throws backtype.storm.topology.FailedException {" + NL + "        try {" + NL + "            if (statement!=null) {" + NL + "                statement.close();" + NL + "                statement = null;" + NL + "            }" + NL + "        } catch (java.sql.SQLException ex) {" + NL + "            throw new backtype.storm.topology.FailedException(ex.getMessage());" + NL + "        } finally {" + NL + "            try {" + NL + "                if (connection != null && !connection.isClosed()) {" + NL + "                    connection.close();" + NL + "                }" + NL + "            } catch (java.sql.SQLException ex) {" + NL + "                throw new backtype.storm.topology.FailedException(ex.getMessage());" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    

/**
 * This utility class is responsible for some common Storm and Trident code
 * generation, including:
 *
 * - analyzing the input and function fields for BaseFunctions
 */
class StormStreamUtil {

    private final INode node;
    private IConnection inConn;
    private IMetadataTable inMetadata;
    private java.util.List<IMetadataColumn> inColumns;
    private IConnection outConn;
    private IMetadataTable outMetadata;
    private java.util.List<IMetadataColumn> outColumns;

    public StormStreamUtil(INode node) {
        this.node = node;
    }

    /**
     * @return the input connection or null if none was set.
     */
    public IConnection getInConnection() {
        return inConn;
    }

    /**
     * @return the input metadata table or null if none was set.
     */
    public IMetadataTable getInMetadata() {
        return inMetadata;
    }

    /**
     * @return the input schema columns or null if none was set.
     */
    public java.util.List<IMetadataColumn> getInColumns() {
        return inColumns;
    }

    /**
     * @return the input schema columns or null if none was set.
     */
    public boolean getInColumnsContains(String label) {
        for (IMetadataColumn column : inColumns)
            if (column.getLabel().equals(label))
                return true;
        return false;
    }

    /**
     * Sets and configures this utility to consider the given input connection
     * as the input to the Storm stream.
     */
    public void setInConnection(IConnection inConn) {
        this.inConn = inConn;
        this.inMetadata = inConn == null ? null : inConn.getMetadataTable();
        this.inColumns = inMetadata == null ? null : inMetadata.getListColumns();
    }

    /**
     * @return the output connection or null if none was set.
     */
    public IConnection getOutConnection() {
        return outConn;
    }

    /**
     * @return the output metadata table or null if none was set.
     */
    public IMetadataTable getOutMetadata() {
        return outMetadata;
    }

    /**
     * @return the output schema columns or null if none was set.
     */
    public java.util.List<IMetadataColumn> getOutColumns() {
        return outColumns;
    }

    /**
     * Sets and configures this utility to consider the given output connection
     * as the output to the Storm stream.
     */
    public void setOutConnection(IConnection outConn) {
        this.outConn = outConn;
        this.outMetadata = outConn == null ? null : outConn.getMetadataTable();
        this.outColumns = outMetadata == null ? null : outMetadata.getListColumns();
    }

    /**
     * @return the first data connection coming into this node.
     */
    public IConnection getFirstDataInConnection() {
        // Use the first incoming DATA connection
        if (node.getIncomingConnections() != null) {
            for (IConnection inConn : node.getIncomingConnections()) {
                if (inConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                    return inConn;
                }
            }
        }
        return null;
    }

    /**
     * @return the first main connection coming into this node.
     */
    public IConnection getFirstMainInConnection() {
        java.util.List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
        return inConns == null || inConns.size() == 0 ? null : inConns.get(0);
    }

    /**
     * @return the first connection with the given name coming out of this node.
     */
    public IConnection getFirstOutConnection() {
        // Use the first outgoing connection of any type
        if (node.getOutgoingConnections() != null
                && node.getOutgoingConnections().size() > 0) {
            return node.getOutgoingConnections().get(0);
        }
        return null;
    }

    /**
     * @return the first connection with the given name coming out of this node.
     */
    public IConnection getFirstNamedOutConnection(String connectorName) {
        // Use the first incoming DATA connection
        if (node.getOutgoingConnections() != null) {
            for (IConnection outConn : node.getOutgoingConnections()) {
                if (outConn.getConnectorName().equals(connectorName)) {
                    return outConn;
                }
            }
        }
        return null;
    }

    /**
     * @return the number of fields in the output columns, or 0 if there is no
     *    output connection.
     */
    public int getOutFieldsSize() {
        return outColumns == null ? 0 : outColumns.size();
    }

    public void generateAllOutStreamsDeclarations() {
        generateSetAllOutStreams(true, null);
    }

    /**
     * For every output stream from this node (not just the specific
     * getOutputConnection()), generate a line of code that declares and/or sets
     * the corresponding trident <code>stream_</code> variable.
     *
     * @param declare whether the type declaration should be included.
     * @param the value to set the output streams (must be a
     *      <code>storm.trident.Stream</code>).
     */
    public void generateSetAllOutStreams(boolean declare, String codeValue) {
        for (IConnection conn : node.getOutgoingConnections()) { 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(declare ? "Stream" : "" );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( conn.getName() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(codeValue);
    stringBuffer.append(TEXT_4);
     }
    }

    public String getCodeInStreamVariable() {
        return "stream_" + inConn.getName();
    }

    public String getCodeOutStreamVariable() {
        return "stream_" + outConn.getName();
    }
}

    
/**
 * Helper tool to generate wrappers for Tuples, including specifications about
 * which fields are found in the tuple, and a simple, reusable wrapper for
 * getting column values from a tuple.
 *
 * TODO(rskraba): check whether a Values-based getter/setter methods are
 *    useful for tFilterRow and tJavaStorm.
 */
class TupleWrapperHelper {

    /** The full class name for the wrapper. */
    private final String className;

    /** A unique field prefix for generating field names.  If based on a
     *  connection, the connection name can be freely used. */
    protected final String fieldPrefix;

    /** List of columns that have values belonging to tuples of this type. */
    private final java.util.LinkedHashMap<String, IMetadataColumn> columnInfo
            = new java.util.LinkedHashMap<String, IMetadataColumn>();

    /** A column prefix to use to prevent collisions between
     *  intermediate/generated columns and columns coming from actual row
     *  schemas. */
    private final java.util.HashMap<String, String> codeGenPrefix
            = new java.util.HashMap<String, String>();

    /** A list of tuple field names that should not be generated automatically,
     *  but overridden to use a specific code value (usually a reference to a
     *  field name from another wrapper). */
    private final java.util.HashMap<String, String> overrideCodeFieldName
            = new java.util.HashMap<String, String>();

    /** True if generate should add a method for getting the field names per
     *  column. */
    protected boolean needsFieldNameAccessors = true;

    /** True if generate should create the methods for wrapping a TridentTuple. */
    protected boolean needsTupleMethods = true;

    /** True if generate should add a method for outputting a Values. */
    protected boolean needsValuesMethods = true;

    // TODO -- delete when static methods can be used within code generators.
    TupleWrapperHelper() {
        className = null;
        fieldPrefix = null;
    }

    TupleWrapperHelper(IConnection conn) {
        this(new TupleWrapperHelper().getClassName(conn), conn.getName(),
                conn.getMetadataTable().getListColumns());
    }

    TupleWrapperHelper(String className, IConnection conn) {
        this(className, conn.getName(),
                conn.getMetadataTable().getListColumns());
    }

    TupleWrapperHelper(String className, IConnection conn,
            Iterable<IMetadataColumn> columns) {
        this(className, conn.getName(), columns);
    }

    TupleWrapperHelper(String className, String fieldPrefix,
            Iterable<IMetadataColumn> columns) {
        this.className = className;
        this.fieldPrefix = fieldPrefix;
        for (IMetadataColumn column : columns)
            columnInfo.put(column.getLabel(), column);
    }

    TupleWrapperHelper(TupleWrapperHelper parent, IConnection conn) {
        this(conn);
        // override all of the field values to refer to the parent.
        for (IMetadataColumn column : columnInfo.values()) {
            setCodeFieldName(column,
                    parent.getCodeFieldsAccessors(parent.className + ".",
                            java.util.Arrays.asList(column)));
        }
    }

    /** The number of fields that this class manages. */
    public int getSize() {
        return columnInfo.size();
    }


    /**
     * @return the class name that contains field information for the given
     *   connection, if a TupleWrapper was generated for that connection.
     */
    // TODO(rskraba): static
    public String getClassName(IConnection conn) {
        if(conn != null)
            return "TupleWrapper_" + conn.getName();
        else 
            return "TupleWrapper_null";
    }

    /**
     * @return the fields that are used for the given connection, if a
     *   TupleWrapper was generated for that connection.
     */
    // TODO(rskraba): static
    public String getFields(IConnection conn) {
        return getClassName(conn) + ".fields";
    }

    /**
     * @return the default TupleWrapper getField for a field of a specify connection
     */
    // TODO(rskraba): static
    public String getField(IConnection conn, String field) {
        return getClassName(conn) + ".getField_" + field + "()";
    }

    /**
     * Specifies that a field name for the given column should be initialized
     * to the given code value (usually a quoted string constant or a static
     * reference to another class).
     */
    public void setCodeFieldName(IMetadataColumn column, String codeOther) {
        overrideCodeFieldName.put(column.getLabel(), codeOther);
    }

    /**
     * Used to add a prefix to a column for generated code referring to that
     * column.  As long as the prefix doesn't start with _, it is guaranteed
     * not to cause a collision with existing row schema columns.
     *
     * This should be used for intermediary columns that don't specifically
     * belong to row schemas.
     */
    public void setPrefix(IMetadataColumn column, String prefix) {
        codeGenPrefix.put(column.getLabel(), prefix);
    }

    /**
     * Adds all of the given columns to this class, ignoring any that have the
     * same label as existing columns.
     */
    public void union(Iterable<IMetadataColumn> columns) {
        for (IMetadataColumn toAdd : columns)
            if (!columnInfo.containsKey(toAdd.getLabel()))
                columnInfo.put(toAdd.getLabel(), toAdd);
    }

    /**
     * Adds the given column as an internal, intermediary column, which is used
     * during processing but doesn't belong to any specific row schema.
     */
    public void addInternalColumn(String label, String prefix,
            org.talend.core.model.metadata.types.JavaType jt) {
        IMetadataColumn internal
                = new org.talend.core.model.metadata.MetadataColumn();
        internal.setLabel(label);
        internal.setType(jt.getId());
        internal.setTalendType(jt.getId());
        columnInfo.put(label, internal);
        setCodeFieldName(internal, '"' + label + '"');
        setPrefix(internal, prefix);
    }

    // TODO(rskraba): static
    public String getCodeJavaType(IMetadataColumn column) {
        org.talend.core.model.metadata.types.JavaType jt
                = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
        return org.talend.core.model.metadata.types.JavaTypesManager.getTypeToGenerate(jt, column.isNullable());
    }

    // TODO(rskraba): static
    public String getCodeJavaMember(String codeModifiers, IMetadataColumn column,
            String codeVarName, String codeVarValue) {
        StringBuilder member = new StringBuilder();
        if (codeModifiers != null)
            member.append(codeModifiers).append(' ');
        member.append(getCodeJavaType(column)).append(' ').append(codeVarName);
        if (codeVarValue != null)
            member.append('=').append(codeVarValue);
        member.append(';');
        return member.toString();
    }

        // TODO(rskraba): static
    public String getCodeJavaMemberInit(IMetadataColumn column, String codeVarName,
            String codeVarValue) {
        StringBuilder member = new StringBuilder();
        member.append(codeVarName);
        if (codeVarValue != null)
            member.append('=').append(codeVarValue);
        member.append(';');
        return member.toString();
    }

    // TODO(rskraba): static
    public String getCodeJavaDefault(IMetadataColumn column) {
        return org.talend.core.model.metadata.types.JavaTypesManager.getDefaultValueFromJavaIdType(
                column.getTalendType(), column.isNullable());
    }

    /**
     * Creates a code snippet that can be used to access a value from a
     * TridentTuple instance.  This is in the format like: <code>codeTuple.getString</code>
     * or <code>(Date) codeTuple.getObject</code>.
     *
     * Note the open parenthesis isn't added, and that the snippet should return
     * a value compatible with {@link getCodeJavaType}.
     */
    // TODO(rskraba): static
    public String getCodeTupleAccessorForType(String codeTuple, IMetadataColumn column) {
        org.talend.core.model.metadata.types.JavaType jt
                = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
        if (jt.isPrimitive() && (jt != org.talend.core.model.metadata.types.JavaTypesManager.CHARACTER)) {
            // getByte, getShort, getLong, etc...
            // But character type is not a default type of storm, so we need to cast it.
            return codeTuple + ".get" + jt.getNullableClass().getSimpleName();
        } else if (jt == org.talend.core.model.metadata.types.JavaTypesManager.STRING) {
            return codeTuple + ".getString";
        } else if (jt == org.talend.core.model.metadata.types.JavaTypesManager.BYTE_ARRAY) {
            return codeTuple + ".getBytes";
        }
        return "(" + getCodeJavaType(column) + ") " + codeTuple + ".getValue";
    }

    /** Generates standard TupleWrappers for all of the outgoing connections
     *  of the given node. */
    // TODO(rskraba): static
    public void generateAllOutgoing(INode node) {
        for (IConnection conn : node.getOutgoingConnections())
            new TupleWrapperHelper(conn).generate();
    }

    /** Generates the entire class. */
    public void generate() {
        
    stringBuffer.append(TEXT_5);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_6);
    
            generateFieldsConstants();
            generateMembers();
            generateConstructors();
            if (needsFieldNameAccessors)
                generateFieldNameAccessors();
            generateMethods();
            if (needsTupleMethods)
                generateWrappedTupleAccessors();
            if (needsValuesMethods)
                generateValuesCreate();
            
    stringBuffer.append(TEXT_7);
    
    }

    /**
     * Generates a class member containing all of the expected field names that
     * are expected to be emitted along the stream that this struct represents.
     *
     * <code>
     * public final static Fields fields = new Fields(getField_store(),
     *     getField_sales(), getField_avePrice(), getField_maxPrice(),
     *     getField_date(), getField_unknown());
     * public static final int tupleIndex_store = 0;
     * public static final int tupleIndex_sales = 1;
     * public static final int tupleIndex_avePrice = 2;
     * public static final int tupleIndex_maxPrice = 3;
     * public static final int tupleIndex_date = 4;
     * public static final int tupleIndex_unknown = 5;
     * </code>
     */
    protected void generateFieldsConstants() {
        
    stringBuffer.append(TEXT_8);
    stringBuffer.append(getCodeFieldsAccessors(null, columnInfo.values()));
    stringBuffer.append(TEXT_9);
    
        int i = 0;
        for (IMetadataColumn column : columnInfo.values()) {
            String prefix = codeGenPrefix.get(column.getLabel());
            if (prefix == null)
                prefix = "";
            
    stringBuffer.append(TEXT_10);
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(i++);
    stringBuffer.append(TEXT_13);
    
        }
    }

    /**
     * Any class members that need to be created for this struct.
     *
     * By default, just the underlying private tuple that any instances of this
     * struct can wrap.
     */
    protected void generateMembers() {
        
    stringBuffer.append(TEXT_14);
     if (needsTupleMethods) { 
    stringBuffer.append(TEXT_15);
     }
    }

    /**
     * Constructors that need to be created for this struct.
     *
     * By default, the constructor that wraps an underlying tuple.
     */
    protected void generateConstructors() {
        if (needsTupleMethods) {
            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_17);
     generateInitializeMembers(); 
    stringBuffer.append(TEXT_18);
    
        }
    }

    /**
     * Class or instance that need to be initialized in the constructor.
     *
     * By default, the constructor that wraps an underlying tuple.
     */
    protected void generateInitializeMembers() {
        if (needsTupleMethods) {
            
    stringBuffer.append(TEXT_19);
    
        }
    }

    /**
     * Any methods that need to be created for this struct.
     *
     * By default, just accessors for the underlying private tuple that any
     * instances of this struct can wrap.
     */
    protected void generateMethods() {
        if (needsTupleMethods) {
            
    stringBuffer.append(TEXT_20);
    
        }
    }

    /**
     * Generates static class methods used access the field names for given
     * columns.
     *
     * <code>
     * // for each column
     * public static String getField_store() {
     *     return "row3__store";
     * }
     *
     * // or:
     * public static String getField_store() {
     *     return row2Struct.getField_store();
     * }
     * </code>
     */
    protected void generateFieldNameAccessors() {
        for (IMetadataColumn column : columnInfo.values()) {
            String prefix = codeGenPrefix.get(column.getLabel());
            if (prefix == null)
                prefix = "";
            
    stringBuffer.append(TEXT_21);
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_23);
    
                String codeOverride = overrideCodeFieldName.get(column.getLabel());
                if (codeOverride == null) {
                    
    stringBuffer.append(TEXT_24);
    stringBuffer.append(fieldPrefix);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_26);
    
                } else {
                    
    stringBuffer.append(TEXT_27);
    stringBuffer.append(codeOverride);
    stringBuffer.append(TEXT_28);
    
                }
                
    stringBuffer.append(TEXT_29);
    
        }
    }

    /**
     * Generates accessors to get column values of the correct type given the
     * column name.
     *
     * <code>
     * public String get_store() {
     *   return tuple.getString(tupleIndex_store);
     * }
     *
     * public double get_sales() {
     *  return tuple.getDouble(tupleIndex_sales);
     * }
     * </code>
     */
    protected void generateWrappedTupleAccessors() {
        for (IMetadataColumn column : columnInfo.values()) {
            String prefix = codeGenPrefix.get(column.getLabel());
            if (prefix == null)
                prefix = "";
            
    stringBuffer.append(TEXT_30);
    stringBuffer.append(getCodeJavaType(column));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(getCodeTupleAccessorForType("tuple", column));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_36);
    
        }
    }

    /**
     * Generates a static helper method to create a Trident Values object in the
     * expected format and order for emission.
     *
     * <code>
     * public static Values createValues(String store, double sales,
     *         double avePrice, double maxPrice, long date, String unknown) {
     *      return new Values(store, sales, avePrice, maxPrice, date, unknown);
     * }
     * </code>
     */
    protected void generateValuesCreate() {
        
    stringBuffer.append(TEXT_37);
    
            boolean first = true;
            // Construct the method signature
            for (IMetadataColumn column : columnInfo.values()) {
                
    stringBuffer.append( first ? "" : ", " );
    stringBuffer.append(getCodeJavaType(column));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(column.getLabel());
    
                first = false;
            }
            // Close the signature and start the body.
            
    stringBuffer.append(TEXT_39);
    
                first = true;
                for (IMetadataColumn column : columnInfo.values()) {
                    
    stringBuffer.append( first ? "" : ", " );
    stringBuffer.append(column.getLabel());
    
                    first = false;
                }
                
    stringBuffer.append(TEXT_40);
    
        // Close the body.
    }

    /**
     * A very simple helper that creates a subclass that adds nothing to the
     * parent subclass generated by a previous TupleWrapper.  This is useful
     * for extending the static namespace from the previous class.
     */
    // TODO(rskraba): static
    public void generateExtends(String className, String parentClassName) {
        // This currently doesn't support extra constructors, and may eventually
        //  be better off as a subclass strateggy of TupleWrapperHelper.
        // For the moment, it's only used by tReplicate.
        
    stringBuffer.append(TEXT_41);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(parentClassName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_44);
    
    }

    /**
     * @return the actual name of this class.
     */
    public String toString() {
        return className;
    }

    /**
     * @return a comma-separated list of getField_COLUMN_LABEL() accessors
     */
    public String getCodeFieldsAccessors(String tupleWrapperRedirect,
            Iterable<IMetadataColumn> columns) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (IMetadataColumn column : columns) {
            String prefix = codeGenPrefix.get(column.getLabel());
            if (prefix == null)
                prefix = "";
            sb.append(first ? "" : ",");
            if (tupleWrapperRedirect != null)
                sb.append(tupleWrapperRedirect);
            sb.append("getField").append(prefix).append("_").append(
                    column.getLabel()).append("()");
            first = false;
        }
        return sb.toString();
    }
}

    
StormStreamUtil streamUtil = new StormStreamUtil(node);
streamUtil.setInConnection(streamUtil.getFirstDataInConnection());
streamUtil.setOutConnection(streamUtil.getFirstOutConnection());

java.util.List<IMetadataTable> metadatas = node.getMetadataList();
if (metadatas == null || metadatas.size() == 0 || metadatas.get(0) == null)
    return "";

IMetadataTable metadata = metadatas.get(0);

String url = ElementParameterParser.getValue(node, "__URL__");
String driverClass = ElementParameterParser.getValue(node, "__DRIVER_CLASS__");
String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser = ElementParameterParser.getValue(node, "__USER__");
String dbtable = ElementParameterParser.getValue(node, "__TABLE__");

java.util.List<IMetadataColumn> columns = metadata.getListColumns();
boolean useBatchSize = "true".equals(ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__"));
String batchSize = ElementParameterParser.getValue(node, "__BATCH_SIZE__");

for (IConnection conn : node.getOutgoingConnections()) {
    new TupleWrapperHelper().generateExtends(new TupleWrapperHelper().getClassName(conn),
            new TupleWrapperHelper().getClassName(streamUtil.getInConnection()));
}

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(new TupleWrapperHelper().getClassName(streamUtil.getInConnection()));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(new TupleWrapperHelper().getClassName(streamUtil.getInConnection()));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(batchSize==null || "".equals(batchSize) ? 10000 : batchSize);
    stringBuffer.append(TEXT_49);
     //tExtractJSONFieldsUtil.generateHelperClassesInstanceDeclaration(); 
    stringBuffer.append(TEXT_50);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_51);
    
            String passwordFieldName = "__PASS__";
            
    stringBuffer.append(TEXT_52);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_55);
    } else {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
            StringBuilder dbColumnsName = new StringBuilder();
            for(IMetadataColumn column : columns){
                dbColumnsName.append("\"").append(column.getOriginalDbColumnName()).append("\"").append(",");
            }
            
    stringBuffer.append(TEXT_63);
    stringBuffer.append(dbColumnsName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_65);
    
            int i = 1;
            for (IMetadataColumn column: columns) {
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                String codeFieldAccessor = "input.get_" + column.getLabel() + "()";

                if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
                    typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
                    if (typeToGenerate.equals("Char")) {
                        
    stringBuffer.append(TEXT_66);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_72);
    
                    } else {
                        
    stringBuffer.append(TEXT_73);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_76);
    
                    }
                } else if (typeToGenerate.equals("Boolean")) {
                    
    stringBuffer.append(TEXT_77);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_81);
    
                } else if (typeToGenerate.equals("Byte")) {
                    
    stringBuffer.append(TEXT_82);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_86);
    
                } else if (typeToGenerate.equals("byte[]")) {
                    
    stringBuffer.append(TEXT_87);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_91);
    
                } else if (typeToGenerate.equals("Character")) {
                    
    stringBuffer.append(TEXT_92);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_96);
    
                } else if (typeToGenerate.equals("java.util.Date")) {
                    
    stringBuffer.append(TEXT_97);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_101);
    
                } else if (typeToGenerate.equals("Double")) {
                    
    stringBuffer.append(TEXT_102);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_106);
    
                } else if (typeToGenerate.equals("Float")) {
                    
    stringBuffer.append(TEXT_107);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    
                } else if(typeToGenerate.equals("BigDecimal")) {
                    
    stringBuffer.append(TEXT_112);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_114);
    
                } else if (typeToGenerate.equals("Integer")) {
                    
    stringBuffer.append(TEXT_115);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_119);
    
                } else if (typeToGenerate.equals("Long")) {
                    
    stringBuffer.append(TEXT_120);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_124);
    
                } else if (typeToGenerate.equals("Object")) {
                    
    stringBuffer.append(TEXT_125);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_129);
    
                } else if (typeToGenerate.equals("Short")) {
                    
    stringBuffer.append(TEXT_130);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_134);
    
                } else if (typeToGenerate.equals("String")) {
                    
    stringBuffer.append(TEXT_135);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_139);
    
                } else if (typeToGenerate.equals("List")) {
                    
    stringBuffer.append(TEXT_140);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(codeFieldAccessor);
    stringBuffer.append(TEXT_142);
    
                }
                i++;
            }

            if (useBatchSize) { 
    stringBuffer.append(TEXT_143);
     if(!("").equals(batchSize) && !("0").equals(batchSize)) { 
    stringBuffer.append(TEXT_144);
     } 
     }else{ 
    stringBuffer.append(TEXT_145);
     } 
    stringBuffer.append(TEXT_146);
     if (useBatchSize) { 
    stringBuffer.append(TEXT_147);
     } 
    stringBuffer.append(TEXT_148);
    return stringBuffer.toString();
  }
}
