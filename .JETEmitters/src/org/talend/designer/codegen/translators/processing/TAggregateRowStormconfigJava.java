package org.talend.designer.codegen.translators.processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

public class TAggregateRowStormconfigJava
{
  protected static String nl;
  public static synchronized TAggregateRowStormconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateRowStormconfigJava result = new TAggregateRowStormconfigJava();
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
  protected final String TEXT_45 = NL;
  protected final String TEXT_46 = NL + "                UtilClass_";
  protected final String TEXT_47 = ".checkedIADD(";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = ", ";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = ", ";
  protected final String TEXT_52 = ", ";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "                ";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = " = ";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = ".add(";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "                ";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = " = (short)(";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = " + ";
  protected final String TEXT_66 = ".";
  protected final String TEXT_67 = ");";
  protected final String TEXT_68 = NL + "                ";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = " = ((byte)(";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = " + ";
  protected final String TEXT_73 = ".";
  protected final String TEXT_74 = "));";
  protected final String TEXT_75 = NL + "                ";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = " += ";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = ";";
  protected final String TEXT_80 = NL + "            if ((";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = " == null)" + NL + "                    || (";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = ".compareTo(";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = ") < 0)) {";
  protected final String TEXT_87 = NL + "                ";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = " = ";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = ";" + NL + "                copyColumns = true;" + NL + "            }";
  protected final String TEXT_92 = NL + "            if (";
  protected final String TEXT_93 = ".";
  protected final String TEXT_94 = " < ";
  protected final String TEXT_95 = ".";
  protected final String TEXT_96 = ") {";
  protected final String TEXT_97 = NL + "                ";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = " = ";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = ";" + NL + "                copyColumns = true;" + NL + "            }";
  protected final String TEXT_102 = NL + "            if ((";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = " == null)" + NL + "                    || (";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = ".compareTo(";
  protected final String TEXT_107 = ".";
  protected final String TEXT_108 = ") > 0)) {";
  protected final String TEXT_109 = NL + "                ";
  protected final String TEXT_110 = ".";
  protected final String TEXT_111 = " = ";
  protected final String TEXT_112 = ".";
  protected final String TEXT_113 = ";" + NL + "                copyColumns = true;" + NL + "            }";
  protected final String TEXT_114 = NL + "            if (";
  protected final String TEXT_115 = ".";
  protected final String TEXT_116 = " > ";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = ") {";
  protected final String TEXT_119 = NL + "                ";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = " = ";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = ";" + NL + "                copyColumns = true;" + NL + "            }";
  protected final String TEXT_124 = NL + "            public final static Fields groupByFields = new Fields(";
  protected final String TEXT_125 = NL + "                ";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = NL + "        public final static Fields fields = new Fields(";
  protected final String TEXT_128 = NL + "            ";
  protected final String TEXT_129 = ");";
  protected final String TEXT_130 = NL + "        ";
  protected final String TEXT_131 = NL + "            ";
  protected final String TEXT_132 = NL + "            /** The empty constructor contains the results of the aggregation before any" + NL + "             *  tuples are processed. */" + NL + "            public ";
  protected final String TEXT_133 = "() {" + NL + "            }" + NL + "" + NL + "            /** The copy constructor contains the results of the aggregation as if the" + NL + "             *  single input value was processed. */" + NL + "            public ";
  protected final String TEXT_134 = "(";
  protected final String TEXT_135 = " in) {" + NL + "                // Initialize calculated fields.";
  protected final String TEXT_136 = NL + "                ";
  protected final String TEXT_137 = NL + NL + "                // Just copy non-calculated fields from the other wrapper.";
  protected final String TEXT_138 = NL + "                    ";
  protected final String TEXT_139 = NL + "            }";
  protected final String TEXT_140 = NL + "        boolean copyColumns = false;";
  protected final String TEXT_141 = NL + NL + "        if (copyColumns) {";
  protected final String TEXT_142 = NL + "                ";
  protected final String TEXT_143 = NL + "        }";
  protected final String TEXT_144 = NL + "{";
  protected final String TEXT_145 = NL + "        ";
  protected final String TEXT_146 = " = ";
  protected final String TEXT_147 = NL + "            .each(new Fields(";
  protected final String TEXT_148 = NL + "                ";
  protected final String TEXT_149 = ")," + NL + "            new storm.trident.operation.builtin.FilterNull());";
  protected final String TEXT_150 = NL + "        storm.trident.fluent.GroupedStream groupBy = ";
  protected final String TEXT_151 = NL + "                .groupBy(";
  protected final String TEXT_152 = ".groupByFields);" + NL + "        TridentState state = groupBy.persistentAggregate(" + NL + "              new MemoryMapState.Factory(),";
  protected final String TEXT_153 = NL + "              ";
  protected final String TEXT_154 = "," + NL + "              new StormAggregator_";
  protected final String TEXT_155 = "(), new Fields(\"aggregateStruct\"));" + NL + "        Stream stream = state.newValuesStream();" + NL + "        stream = stream.each(new Fields(\"aggregateStruct\"), new StormAggregator_";
  protected final String TEXT_156 = "(),";
  protected final String TEXT_157 = NL + "                ";
  protected final String TEXT_158 = ".fields);" + NL + "        stream = stream.project(";
  protected final String TEXT_159 = ");";
  protected final String TEXT_160 = NL + "        TridentState state = ";
  protected final String TEXT_161 = ".persistentAggregate(" + NL + "              new MemoryMapState.Factory(),";
  protected final String TEXT_162 = NL + "              ";
  protected final String TEXT_163 = "," + NL + "              new StormAggregator_";
  protected final String TEXT_164 = "(), new Fields(\"aggregateStruct\"));" + NL + "        Stream stream = state.newValuesStream();" + NL + "        stream = stream.each(new Fields(\"aggregateStruct\"), new StormAggregator_";
  protected final String TEXT_165 = "(),";
  protected final String TEXT_166 = NL + "                ";
  protected final String TEXT_167 = ");" + NL + "        stream = stream.project(";
  protected final String TEXT_168 = ");";
  protected final String TEXT_169 = NL + NL;
  protected final String TEXT_170 = NL + "    ";
  protected final String TEXT_171 = " = stream;" + NL + "}";
  protected final String TEXT_172 = NL;

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

    

/**
 * Contains common processing for tAggregateRow code generation.
 */
class TAggregateRowUtil {

    /** Group by columns: INPUT_COLUMN, OUTPUT_COLUMN */
    final private List<Map<String, String>> groupBy = (List<Map<String,String>>)
            ElementParameterParser.getObjectValue(node, "__GROUPBYS__");

    // TODO: MR and DI option, currently unimplemented
    final private boolean useFinancialPrecision = "true".equals(ElementParameterParser.getValue(node, "__USE_FINANCIAL_PRECISION__"));

    // TODO: MR and DI option, currently unimplemented
    final private String listDelimiter = ElementParameterParser.getValue(node, "__LIST_DELIMITER__");

    /** Incoming connection, or null if none. */
    // TODO: use the IConnection instead of the name.
    final private String inConnName;

    /** The columns in the output schema. */
    final List<IMetadataColumn> inColumns;

    /** The output columns that are being grouped on. */
    final private List<IMetadataColumn> groupByColumns = new java.util.ArrayList<IMetadataColumn>();

    /** List of output columns that are calculated within the aggregate group. */
    final private List<IMetadataColumn> operationInColumns = new java.util.ArrayList<IMetadataColumn>();

    /** List of input columns that are used within the aggregate group. */
    final private List<IMetadataColumn> operationOutColumns = new java.util.ArrayList<IMetadataColumn>();

    /** Output functions to be calculated, mapping from the destination column to the values for
     *  the output column name, the input column name, the function and "true" for IGNORE_NULL */
    final private java.util.Map<IMetadataColumn, String[]> operations = new java.util.HashMap<IMetadataColumn, String[]>();

    /** Outgoing main connection, or null if none. */
    final String outConnName;

    /** The columns in the output schema. */
    final List<IMetadataColumn> outColumns;

    public TAggregateRowUtil(INode node) {
        // Name of the input data connection.
        List<IMetadataColumn> inColumnsTemp = null;
        String inConnNameTemp = null;
        List<? extends IConnection> inConns = node.getIncomingConnections();
        if (inConns != null) {
            for (IConnection inConn : inConns) {
                if (inConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                    inConnNameTemp = inConn.getName();
                    inColumnsTemp = inConn.getMetadataTable().getListColumns();
                    break;
                }
            }
        }
        inConnName = inConnNameTemp;
        inColumns = inColumnsTemp;

        // Characteristics of the main output connection, if any.
        List<? extends IConnection> mainConns = node.getOutgoingConnections("FLOW");
        outConnName = (mainConns != null && mainConns.size() > 0)
                ? mainConns.get(0).getName()
                : null;
        outColumns = null != outConnName
                ? new java.util.ArrayList<IMetadataColumn>(mainConns.get(0).getMetadataTable().getListColumns())
                : new java.util.ArrayList<IMetadataColumn>();

        for (Map<String, String> groupByRow: groupBy) {
            for (IMetadataColumn outColumn: outColumns) {
                if (outColumn.getLabel().equals(groupByRow.get("OUTPUT_COLUMN")))
                    groupByColumns.add(outColumn);
            }
        }
        outColumns.removeAll(groupByColumns);

        // Operations to apply on the groups:  INPUT_COLUMN, FUNCTION (),
        // OUTPUT_COLUMN, IGNORE_NULL */
        List<Map<String, String>> operation = (List<Map<String,String>>)
                ElementParameterParser.getObjectValue(node, "__OPERATIONS__");

        for (Map<String, String> operationRow: operation) {
            for (IMetadataColumn outColumn: outColumns) {
                if (outColumn.getLabel().equals(operationRow.get("OUTPUT_COLUMN"))) {
                    operationOutColumns.add(outColumn);
                    operations.put(outColumn, new String[] {
                            operationRow.get("OUTPUT_COLUMN"),
                            operationRow.get("INPUT_COLUMN"),
                            operationRow.get("FUNCTION"),
                            operationRow.get("IGNORE_NULL")
                        });
                }
            }
            for (IMetadataColumn inColumn: inColumns) {
                // In columns can be deduplicated (unlike out columns
                // which are guaranteed to only be present once).
                if (!operationInColumns.contains(inColumn))
                    if (inColumn.getLabel().equals(operationRow.get("INPUT_COLUMN")))
                        operationInColumns.add(inColumn);
            }
        }

        // Remove the operation columns from the outColumns for a list of non
        // calculated columns.
        outColumns.removeAll(operationOutColumns);
    }

    /**
     * @return true if this node doesn't require any code generation (usually
     *     because it is unconnected to other nodes generating data).
     */
    public boolean isUnnecessary() {
        // No code generation if no input, or no significant output.
        return inConnName == null || outConnName == null
                || outColumns == null;
    }

    /**
     * @return the list of output columns that are in the GroupBy box.
     */
    public List<IMetadataColumn> getGroupByColumns() {
        return groupByColumns;
    }

    // TODO: clean this up.
    public String getGroupByInputColumn(IMetadataColumn outColumn) {
        for (java.util.Map<String, String> gbMap : groupBy) {
            if (outColumn.getLabel().equals(gbMap.get("OUTPUT_COLUMN")))
                return gbMap.get("INPUT_COLUMN");
        }
        return null;
    }

    /**
     * @return the list of input columns that are in the Operations box.
     */
    public List<IMetadataColumn> getOperationInColumns() {
        return operationInColumns;
    }

    /**
     * @return the list of output columns that are in the Operations box.
     */
    public List<IMetadataColumn> getOperationOutColumns() {
        return operationOutColumns;
    }

    public String[] getOperationDetails(IMetadataColumn operationOutColumn) {
        return operations.get(operationOutColumn);
    }

    /**
     * @return the list of output columns that are not in the Operations box.
     */
    public List<IMetadataColumn> getOtherOutColumns() {
        return outColumns;
    }

    /**
     * @return the Member type of an input column.
     */
    public String getInputColumnMemberType(String field) {
        for (IMetadataColumn column: inColumns) {
            if (column.getLabel().equals(field)) {
                return JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
            }
        }
        return "";
    }

    /**
     * @return the Member type of an operation output column.
     */
    public String getOperationOutputColumnMemberType(String field) {
        for (IMetadataColumn column: operationOutColumns) {
            if (column.getLabel().equals(field)) {
                return JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
            }
        }
        return "";
    }
}

    stringBuffer.append(TEXT_45);
    

/**
 * Provides a mechanism to extend the tAttregate row to different types of
 * aggregate functions.  Among the responsibilities of an aggregate function
 * are:
 * - Initialize a data member (one per function) to a zero value (it's logical
 *   value if no data has been processed).
 * - Add a single row to the data member from the incoming data.
 * - Combine multiple calculations on two batches of data into one result.
 * - If more than one data member is required, manages the dependent data
 *   members in their own TAggregateFunction classes.
 * - Calculate the final result from the data members.
 *
 * The defaults for this class provide the functionality for the SUM,
 * function, which is useful as a base for constructing other functions.
 *
 * N.B. Currently two strategies can duplicate work (such as needing the sum
 * for both SUM and AVE).  This could be deduplicated based on input column,
 * function AND expected output type.
 */
abstract class TAggregateFunction {
    /** The name of the final column (belonging to the output row) */
    protected final String outColumn;

    /** The name of the source column (belonging to the input row) */
    protected final String inColumn;

    /** The name of the single data member that this strategy manages.  Other
     *  members can be added using dependent TAggregateFunction objects.  This
     *  can be null if no data member should be generated for this function. */
    protected final String memberName;

    /** The type of the single data member that this strategy manages. */
    protected final String memberType;

    /** The type of the input data member that this strategy manages. */
    protected final String inputMemberType;


    final private boolean checkTypeOverflow = "true".equals(ElementParameterParser.getValue(node, "__CHECK_TYPE_OVERFLOW__"));
    final private boolean checkUlp = "true".equals(ElementParameterParser.getValue(node, "__CHECK_ULP__"));

    /** More than one data member can be used in a single function by specifying
     *  A TAggregateFunction that provides the same contract. */
    protected java.util.List<? extends TAggregateFunction> requires = null;

    TAggregateFunction(String outColumn, String inColumn, String memberName, String inputMemberType, String memberType) {
        this.outColumn = outColumn;
        this.inColumn = inColumn;
        this.memberName = memberName;
        // TODO: the member type should be consistent with the destination
        // column.  Double is almost always a reasonable default.
        // TODO rename memberType to outputMemberType
        this.memberType = memberType;
        this.inputMemberType = inputMemberType;
    }
    
    TAggregateFunction(String outColumn, String inColumn, String memberName) {
        this(outColumn, inColumn, memberName, "double", "double");
        // TODO: the member type should be consistent with the destination
        // column.  Double is almost always a reasonable default.
    }

    public void getCodeMembers(StringBuilder out) {
        if (memberName != null)
            out.append(memberType).append(' ').append(memberName).append(" = ")
                    .append(getZero()).append(";\n");
        if (requires != null)
            for (TAggregateFunction subOp : requires)
                subOp.getCodeMembers(out);
    }

    public void getCodeMembersInit(StringBuilder out, String codeIn) {
        if (memberName != null)
            out.append(memberName).append(" = ").append(getCodeFromIn(codeIn))
                    .append(";\n");
        if (requires != null)
            for (TAggregateFunction subOp : requires)
                subOp.getCodeMembersInit(out, codeIn);
    }

    protected String getCodeFromIn(String codeIn) {
        if (memberType.equals("BigDecimal")) {
            if (inputMemberType.equalsIgnoreCase("short")) {
                return "new BigDecimal(" + codeIn + ".get_" + inColumn + "().longValue())";
            } else if (inputMemberType.equals("BigDecimal")) {
                    return  codeIn + ".get_" + inColumn + "()";
            } else {
                return "new BigDecimal(" + codeIn + ".get_" + inColumn + "())";
            }
        } else if (memberType.equalsIgnoreCase("integer")) {
            return  codeIn + ".get_" + inColumn + "().intValue()";
        } else {
            return  codeIn + ".get_" + inColumn + "()." + memberType.toLowerCase() + "Value()";
        }
    }

    protected void generateCombine(String codeVal1, String codeVal2) {
        if (memberName != null) {
            if(checkTypeOverflow || checkUlp) {
                
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(codeVal2);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(checkTypeOverflow);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(checkUlp);
    stringBuffer.append(TEXT_53);
    
            }

            if (memberType.equals("BigDecimal")) {
                
    stringBuffer.append(TEXT_54);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(codeVal2);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_60);
    
            } else if (memberType.equals("Short")) {
                
    stringBuffer.append(TEXT_61);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(codeVal2);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_67);
    
            } else if (memberType.equals("Byte")) {
                
    stringBuffer.append(TEXT_68);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(codeVal2);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_74);
    
            } else {
                
    stringBuffer.append(TEXT_75);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(codeVal2);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_79);
    
            }
        }
        if (requires != null)
            for (TAggregateFunction subOp : requires)
                subOp.generateCombine(codeVal1, codeVal2);
    }

    protected String getZero() {
        if (memberType.equals("BigDecimal")) {
            return "new BigDecimal(0)";
        } else if (memberType.equals("Double")) {
            return "0d";
        } else if (memberType.equals("Float")) {
            return "0f";
        } else if (memberType.equals("Long")) {
            return "0l";
        } else {
            return "0";
        }
    }

    public String getCodeToEmit(String codeOut) {
        return memberName == null ? "" : codeOut + "." + memberName;
    }
}

/**
 * A count adds 1 for each valid row encountered.
 */
class TAggregateCount extends TAggregateFunction {
    TAggregateCount(String outColumn, String inColumn) {
        super(outColumn, inColumn, outColumn + "_count");
    }

    TAggregateCount(String outColumn, String inColumn, String inputMemberType, String outputMemberType) {
        super(outColumn, inColumn, outColumn + "_count", inputMemberType, outputMemberType);
    }

    protected String getCodeFromIn(String codeIn) {
        if (memberType.equals("BigDecimal")) {
            return "new BigDecimal(1)";
        } else if (memberType.equals("Double")) {
            return "1d";
        } else if (memberType.equals("Float")) {
            return "1f";
        } else if (memberType.equals("Long")) {
            return "1l";
        } else {
            return "1";
        }
    }
 }

/** A sum totals the incoming values for each valid row. */
class TAggregateSum extends TAggregateFunction {
    TAggregateSum(String outColumn, String inColumn) {
        super(outColumn, inColumn, outColumn + "_sum");
    }

    TAggregateSum(String outColumn, String inColumn, String inputMemberType, String outputMemberType) {
        super(outColumn, inColumn, outColumn + "_sum", inputMemberType, outputMemberType);
    }
}

/** Finds the smallest value for each valid row. */
class TAggregateMin extends TAggregateFunction {
    TAggregateMin(String outColumn, String inColumn) {
        super(outColumn, inColumn, outColumn + "_min");
    }

    TAggregateMin(String outColumn, String inColumn, String inputMemberType, String outputMemberType) {
        super(outColumn, inColumn, outColumn + "_min", inputMemberType, outputMemberType);
    }

    protected String getZero() {
        if (memberType.equals("BigDecimal")) {
            // BigDecimal does not know handle infinite
            return "null";
        } else if (memberType.equals("Double")) {
            return "Double.POSITIVE_INFINITY";
        } else if (memberType.equals("Float")) {
            return "Float.POSITIVE_INFINITY";
        } else {
            return memberType + ".MAX_VALUE";
        }
    }

    protected void generateCombine(String codeVal1, String codeVal2) {
        if (memberType.equals("BigDecimal")) {
            
    stringBuffer.append(TEXT_80);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(codeVal2);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(codeVal2);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_91);
    
        } else {
            
    stringBuffer.append(TEXT_92);
    stringBuffer.append(codeVal2);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(codeVal2);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_101);
    
        }
     }
}

class TAggregateMax extends TAggregateFunction {
    TAggregateMax(String outColumn, String inColumn) {
        super(outColumn, inColumn, outColumn + "_max");
    }

    TAggregateMax(String outColumn, String inColumn, String inputMemberType, String outputMemberType) {
        super(outColumn, inColumn, outColumn + "_max", inputMemberType, outputMemberType);
    }

    protected String getZero() {
        if (memberType.equals("BigDecimal")) {
            // BigDecimal does not know handle infinite
            return "null";
        } else if (memberType.equals("Double")) {
            return "Double.NEGATIVE_INFINITY";
        } else if (memberType.equals("Float")) {
            return "Float.NEGATIVE_INFINITY";
        } else {
            return memberType + ".MIN_VALUE";
        }
    }

    protected void generateCombine(String codeVal1, String codeVal2) {
        if (memberType.equals("BigDecimal")) {
            
    stringBuffer.append(TEXT_102);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(codeVal2);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(codeVal2);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_113);
    
        } else {
            
    stringBuffer.append(TEXT_114);
    stringBuffer.append(codeVal2);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(codeVal1);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(codeVal2);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(memberName);
    stringBuffer.append(TEXT_123);
    
        }
     }
}

class TAggregateAve extends TAggregateFunction {
    TAggregateAve(String outColumn, String inColumn) {
        this(outColumn, inColumn, "double", "double");
    }

    TAggregateAve(String outColumn, String inColumn, String inputMemberType, String outputMemberType) {
        super(outColumn, inColumn, null, inputMemberType, outputMemberType);
        requires = java.util.Arrays.asList(new TAggregateSum(outColumn, inColumn, inputMemberType, outputMemberType),
                new TAggregateCount(outColumn, inColumn));
    }

    public String getCodeToEmit(String codeOut) {
        if (memberType.equals("BigDecimal")) {
            return requires.get(0).getCodeToEmit(codeOut) +".divide(new BigDecimal("
                    + requires.get(1).getCodeToEmit(codeOut) + "))";
        } else if (memberType.equals("Integer")) {
            return requires.get(0).getCodeToEmit(codeOut) + " / " 
                    + "((Double)" + requires.get(1).getCodeToEmit(codeOut) + ")."
                    + "intValue()";
        } else {
            return requires.get(0).getCodeToEmit(codeOut) + " / " 
                    + "((Double)" + requires.get(1).getCodeToEmit(codeOut) + ")."
                    + memberType.toLowerCase() + "Value()";
        }
    }
}

/**
 * TODO: see  http://math.stackexchange.com/questions/102978/incremental-computation-of-standard-deviation
 * http://stats.stackexchange.com/questions/25848/how-to-sum-a-standard-deviation
 * http://stackoverflow.com/questions/7753002/adding-combining-standard-deviations
 * http://alias-i.com/lingpipe/src/com/aliasi/stats/OnlineNormalEstimator.java
 */
class TAggregateStdDev extends TAggregateFunction {
    TAggregateStdDev(String outColumn, String inColumn) {
        this(outColumn, inColumn, "double", "double");
    }

    TAggregateStdDev(String outColumn, String inColumn, String inputMemberType, String outputMemberType) {
        super(outColumn, inColumn, outColumn + "_sumsquare", inputMemberType, outputMemberType);
        requires = java.util.Arrays.asList(new TAggregateAve(outColumn, inColumn, inputMemberType, outputMemberType));
    }

    protected String getCodeFromIn(String codeIn) {
        if (memberType.equals("BigDecimal")) {
            return super.getCodeFromIn(codeIn) +".pow(2)";
        }  else if (memberType.equals("Short")) {
            return "(short)(" + super.getCodeFromIn(codeIn) + " * " + super.getCodeFromIn(codeIn) + ")";
        } else {
            return super.getCodeFromIn(codeIn) + " * " + super.getCodeFromIn(codeIn);
        }
    }

    public String getCodeToEmit(String codeOut) {
        // sqrt(t0*t2 - t1 ^ 2)/t0 where t0 = count, t1 = sum, t2 = sumsquare
        // Population, for sample stddev, use (_count - 1)
        if (memberType.equals("BigDecimal")) {
            return "((" + codeOut + "." + outColumn + "_count == 0)"
                    + "|| (" + codeOut + "." + outColumn + "_count * "
                    + codeOut + "." + outColumn + "_sumsquare.doubleValue() < "
                    + codeOut + "." + outColumn + "_sum.pow(2).doubleValue()))"
                    + " ? new BigDecimal(0)"
                    + ": new BigDecimal(Math.sqrt(" + codeOut + "." + outColumn + "_count * "
                    + codeOut + "." + outColumn + "_sumsquare.doubleValue() - "
                    + codeOut + "." + outColumn + "_sum.pow(2).doubleValue())/"
                    + codeOut + "." + outColumn + "_count)";
        } else if (memberType.equals("Double")) {
            return "((" + codeOut + "." + outColumn + "_count == 0)"
                    + "|| (" + codeOut + "." + outColumn + "_count * "
                    + codeOut + "." + outColumn + "_sumsquare < "
                    + codeOut + "." + outColumn + "_sum" + "*"
                    + codeOut + "." + outColumn + "_sum))"
                    + " ? 0d"
                    + ": Math.sqrt(" + codeOut + "." + outColumn + "_count * "
                    + codeOut + "." + outColumn + "_sumsquare - "
                    + codeOut + "." + outColumn + "_sum" + "*"
                    + codeOut + "." + outColumn + "_sum" + ")/"
                    + codeOut + "." + outColumn + "_count";
        } else if (memberType.equals("Float")) {
            return "((" + codeOut + "." + outColumn + "_count == 0)"
                    + "|| (" + codeOut + "." + outColumn + "_count * "
                    + codeOut + "." + outColumn + "_sumsquare < "
                    + codeOut + "." + outColumn + "_sum" + "*"
                    + codeOut + "." + outColumn + "_sum))"
                    + " ? 0f"
                    + ": ((Double) (Math.sqrt(" + codeOut + "." + outColumn + "_count * "
                    + codeOut + "." + outColumn + "_sumsquare - "
                    + codeOut + "." + outColumn + "_sum" + "*"
                    + codeOut + "." + outColumn + "_sum" + ")/"
                    + codeOut + "." + outColumn + "_count)).floatValue()";
        } else if (memberType.equals("Long")) {
            return "((" + codeOut + "." + outColumn + "_count == 0)"
                    + "|| (" + codeOut + "." + outColumn + "_count * "
                    + codeOut + "." + outColumn + "_sumsquare < "
                    + codeOut + "." + outColumn + "_sum" + "*"
                    + codeOut + "." + outColumn + "_sum))"
                    + " ? 0l"
                    + ": ((Double) (Math.sqrt(" + codeOut + "." + outColumn + "_count * "
                    + codeOut + "." + outColumn + "_sumsquare - "
                    + codeOut + "." + outColumn + "_sum" + "*"
                    + codeOut + "." + outColumn + "_sum" + ")/"
                    + codeOut + "." + outColumn + "_count)).longValue()";
        } else if (memberType.equals("Short")) {
            return "((" + codeOut + "." + outColumn + "_count == 0)"
                    + "|| (" + codeOut + "." + outColumn + "_count * "
                    + codeOut + "." + outColumn + "_sumsquare < "
                    + codeOut + "." + outColumn + "_sum" + "*"
                    + codeOut + "." + outColumn + "_sum))"
                    + " ? (short)0"
                    + ": ((Double) (Math.sqrt(" + codeOut + "." + outColumn + "_count * "
                    + codeOut + "." + outColumn + "_sumsquare - "
                    + codeOut + "." + outColumn + "_sum" + "*"
                    + codeOut + "." + outColumn + "_sum" + ")/"
                    + codeOut + "." + outColumn + "_count)).shortValue()";
        } else {
            return "((" + codeOut + "." + outColumn + "_count == 0)"
                    + "|| (" + codeOut + "." + outColumn + "_count * "
                    + codeOut + "." + outColumn + "_sumsquare < "
                    + codeOut + "." + outColumn + "_sum" + "*"
                    + codeOut + "." + outColumn + "_sum))"
                    + " ? 0"
                    + ": ((Double) (Math.sqrt(" + codeOut + "." + outColumn + "_count * "
                    + codeOut + "." + outColumn + "_sumsquare - "
                    + codeOut + "." + outColumn + "_sum" + "*"
                    + codeOut + "." + outColumn + "_sum" + ")/"
                    + codeOut + "." + outColumn + "_count)).intValue()";
        }

    }
}

/**
 * Helper for managing collections of aggregation functions.
 *
 * This generates a serializable structure containing the intermediate data
 * necessary to calculate the aggregate functions, and the glue code for the
 * Storm function and combiner to use it.
 */
class TAggregateRowStruct extends TupleWrapperHelper {

    // TODO(rskraba): factor into the TAggregateFunction classes.  Make a factory!
    /** Possible values for the operations table FUNCTION column. */
    final public static String SUM = "sum";
    final public static String COUNT = "count";
    final public static String MAX = "max";
    final public static String MIN = "min";
    //final public static String FIRST = "first";
    //final public static String LAST = "last";
    final public static String AVG = "avg";
    //final public static String COUNT_DISTINCT = "distinct";
    //final public static String UNION = "union";
    //final public static String LIST = "list";
    //final public static String LIST_OBJECT = "list_object";
    final public static String STD_DEV = "std_dev";

    private final String twhInput;
    private final String twhOutput;
    private final TAggregateRowUtil tAggregateRowUtil;
    private final StormStreamUtil streamUtil;
    private final List<TAggregateFunction> operations = new java.util.ArrayList<TAggregateFunction>();

    TAggregateRowStruct(TAggregateRowUtil tAggregateRowUtil, StormStreamUtil streamUtil) {
        super("AggregateStruct_" + streamUtil.getOutConnection().getName(), streamUtil.getOutConnection());
        this.twhInput = getClassName(streamUtil.getInConnection());
        this.twhOutput = getClassName(streamUtil.getOutConnection());
        this.tAggregateRowUtil = tAggregateRowUtil;
        this.streamUtil = streamUtil;

        // Turn off some unnecessary code generation for this intermediate struct.
        needsTupleMethods = false;
        needsValuesMethods = false;
        needsFieldNameAccessors = false;

        // Get the list of calculations that need to occur.
        for (IMetadataColumn operationOut : tAggregateRowUtil.getOperationOutColumns()) {
            String[] details = tAggregateRowUtil.getOperationDetails(operationOut);
            if (SUM.equals(details[2]))
                operations.add(new TAggregateSum(details[0], details[1], tAggregateRowUtil.getInputColumnMemberType(details[1]), tAggregateRowUtil.getOperationOutputColumnMemberType(details[0])));
            else if (COUNT.equals(details[2]))
                operations.add(new TAggregateCount(details[0], details[1], tAggregateRowUtil.getInputColumnMemberType(details[1]), tAggregateRowUtil.getOperationOutputColumnMemberType(details[0])));
            else if (MIN.equals(details[2]))
                operations.add(new TAggregateMin(details[0], details[1], tAggregateRowUtil.getInputColumnMemberType(details[1]), tAggregateRowUtil.getOperationOutputColumnMemberType(details[0])));
            else if (MAX.equals(details[2]))
                operations.add(new TAggregateMax(details[0], details[1], tAggregateRowUtil.getInputColumnMemberType(details[1]), tAggregateRowUtil.getOperationOutputColumnMemberType(details[0])));
            else if (AVG.equals(details[2]))
                operations.add(new TAggregateAve(details[0], details[1], tAggregateRowUtil.getInputColumnMemberType(details[1]), tAggregateRowUtil.getOperationOutputColumnMemberType(details[0])));
            else if (STD_DEV.equals(details[2]))
                operations.add(new TAggregateStdDev(details[0], details[1], tAggregateRowUtil.getInputColumnMemberType(details[1]), tAggregateRowUtil.getOperationOutputColumnMemberType(details[0])));
            // all other values should never occur.
        }
    }

    public void generateFieldsConstants() {
        // This needs to be in the same order as getCodeEmitValues(), but
        // not necessarily in the same order as the output schema (the final
        // project will reorder correctly).
        List<IMetadataColumn> emitColumns = new java.util.ArrayList<IMetadataColumn>();
        emitColumns.addAll(tAggregateRowUtil.getOperationOutColumns());
        emitColumns.addAll(tAggregateRowUtil.getOtherOutColumns());
        if (tAggregateRowUtil.getGroupByColumns().size() != 0) {
            
    stringBuffer.append(TEXT_124);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(getCodeFieldsAccessors(twhOutput + ".",
                        tAggregateRowUtil.getGroupByColumns()));
    stringBuffer.append(TEXT_126);
    
        }
        
    stringBuffer.append(TEXT_127);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(getCodeFieldsAccessors(twhOutput + ".", emitColumns));
    stringBuffer.append(TEXT_129);
    
    }

    /** Adds the necessary members for storing incremental data. */
    public void generateMembers() {
        super.generateMembers();
        StringBuilder sb = new StringBuilder();
        for (TAggregateFunction op : operations)
            op.getCodeMembers(sb);
        
    stringBuffer.append(TEXT_130);
    stringBuffer.append(sb);
    
        for (IMetadataColumn other : tAggregateRowUtil.getOtherOutColumns()) {
            
    stringBuffer.append(TEXT_131);
    stringBuffer.append( getCodeJavaMember(null, other, other.getLabel(), getCodeJavaDefault(other)) );
    
        }
    }

    /** Overrides the default behaviour to create an empty and a copy constructor. */
    protected void generateConstructors() {
        
    stringBuffer.append(TEXT_132);
    stringBuffer.append(toString());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(toString());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(twhInput);
    stringBuffer.append(TEXT_135);
    
                StringBuilder sb = new StringBuilder();
                for (TAggregateFunction op : operations) {
                    op.getCodeMembersInit(sb, "in");
                }
                
    stringBuffer.append(TEXT_136);
    stringBuffer.append(sb);
    stringBuffer.append(TEXT_137);
    
                for (IMetadataColumn other : tAggregateRowUtil.getOtherOutColumns()) {
                    
    stringBuffer.append(TEXT_138);
    stringBuffer.append( getCodeJavaMemberInit(other, other.getLabel(),
                            streamUtil.getInColumnsContains(other.getLabel())
                                    ? "in.get_" + other.getLabel() + "()"
                                    : getCodeJavaDefault(other)) );
    
                }
                
    stringBuffer.append(TEXT_139);
    
    }

    public void generateCombine(String codeVal1, String codeVal2) {
        
    stringBuffer.append(TEXT_140);
    
        StringBuilder sb = new StringBuilder();
        for (TAggregateFunction op : operations)
            op.generateCombine(codeVal1, codeVal2);
        
    stringBuffer.append(TEXT_141);
    
            for (IMetadataColumn other : tAggregateRowUtil.getOtherOutColumns()) {
                if (!streamUtil.getInColumnsContains(other.getLabel()))
                    continue;
                
    stringBuffer.append(TEXT_142);
    stringBuffer.append( getCodeJavaMemberInit(other, codeVal1 + "." + other.getLabel(),
                        codeVal2 + "." + other.getLabel()) );
    
            }
            
    stringBuffer.append(TEXT_143);
    
    }

    public String getCodeEmitValues(String codeIn) {
        StringBuilder sb = new StringBuilder();
        sb.append("new Values(");
        boolean first = true;
        for (TAggregateFunction op : operations) {
            sb.append(first ? "" : ",");
            first = false;
            sb.append(op.getCodeToEmit(codeIn));
        }

        for (IMetadataColumn other : tAggregateRowUtil.getOtherOutColumns()) {
            sb.append(first ? "" : ",");
            first = false;
            sb.append(codeIn).append('.').append(other.getLabel());
        }

        return sb.append(')').toString();
    }
}


    
StormStreamUtil streamUtil = new StormStreamUtil(node);
TAggregateRowUtil tAggregateRowUtil = new TAggregateRowUtil(node);

streamUtil.setInConnection(streamUtil.getFirstDataInConnection());
streamUtil.setOutConnection(streamUtil.getFirstOutConnection());

// Quit fast if this node is unnecessary.
if (tAggregateRowUtil.isUnnecessary())
    return "";

String outConnName = streamUtil.getOutConnection().getName();

String inConnectionName = streamUtil.getInConnection().getName();

streamUtil.generateAllOutStreamsDeclarations();

    stringBuffer.append(TEXT_144);
    
    // Look into fields of "operation" table and extract the one where the option "ignore null is check".
    // If there is at least one field checked, create a storm filter to remove it (with a basic FilterNull).
    final List<Map<String, String>> operations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
    java.util.Set<String> ignoredFields = new java.util.HashSet<String>();
    for (Map<String, String> line: operations) {
        Boolean ignoreNull = "true".equals(line.get("IGNORE_NULL"));
        if (ignoreNull) {
            ignoredFields.add(new TupleWrapperHelper().getField(streamUtil.getInConnection(), line.get("INPUT_COLUMN")));
        }
    }
    if (ignoredFields.size() > 0) {
        
    stringBuffer.append(TEXT_145);
    stringBuffer.append(streamUtil.getCodeInStreamVariable());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(streamUtil.getCodeInStreamVariable());
    stringBuffer.append(TEXT_147);
    
            boolean first = true;
            for (String ignoredField: ignoredFields) {
                
    stringBuffer.append(TEXT_148);
    stringBuffer.append(first ? "" : ",");
    stringBuffer.append(ignoredField);
    
                first = false;
            }
            
    stringBuffer.append(TEXT_149);
    
    }

    // The aggregate is simplified if there are no groupBy columns (i.e., the
    // aggregate operation doesn't repartition the tuple flow).
    if (tAggregateRowUtil.getGroupByColumns().size() != 0) {
        String aggregateStruct = new TAggregateRowStruct(tAggregateRowUtil, streamUtil).toString();
        
    stringBuffer.append(TEXT_150);
    stringBuffer.append(streamUtil.getCodeInStreamVariable());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(aggregateStruct);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(new TupleWrapperHelper().getFields(streamUtil.getInConnection()));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(aggregateStruct);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(new TupleWrapperHelper().getFields(streamUtil.getOutConnection()));
    stringBuffer.append(TEXT_159);
     } else { 
    stringBuffer.append(TEXT_160);
    stringBuffer.append(streamUtil.getCodeInStreamVariable());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(new TupleWrapperHelper().getFields(streamUtil.getInConnection()));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(new TupleWrapperHelper().getFields(streamUtil.getOutConnection()));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(new TupleWrapperHelper().getFields(streamUtil.getOutConnection()));
    stringBuffer.append(TEXT_168);
     } 
    stringBuffer.append(TEXT_169);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(streamUtil.getCodeOutStreamVariable());
    stringBuffer.append(TEXT_171);
    stringBuffer.append(TEXT_172);
    return stringBuffer.toString();
  }
}
