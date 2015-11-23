package org.talend.designer.codegen.translators.misc;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TRowGeneratorStormcodeJava
{
  protected static String nl;
  public static synchronized TRowGeneratorStormcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRowGeneratorStormcodeJava result = new TRowGeneratorStormcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        public static class ";
  protected final String TEXT_2 = " implements Serializable {";
  protected final String TEXT_3 = NL + "        }";
  protected final String TEXT_4 = NL + "        public final static Fields fields = new Fields(";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "            public static final int tupleIndex";
  protected final String TEXT_7 = "_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = NL + "        /** Default serial version UID. */" + NL + "        private static final long serialVersionUID = 1L;";
  protected final String TEXT_11 = NL + "           private TridentTuple tuple;";
  protected final String TEXT_12 = NL + "            ";
  protected final String TEXT_13 = "(TridentTuple tuple) {";
  protected final String TEXT_14 = NL + "            }";
  protected final String TEXT_15 = NL + "            this.tuple = tuple;";
  protected final String TEXT_16 = NL + "            public TridentTuple getTuple() {" + NL + "                return tuple;" + NL + "            }" + NL + "" + NL + "            public void setTuple(TridentTuple tuple) {" + NL + "                this.tuple = tuple;" + NL + "            }";
  protected final String TEXT_17 = NL + "            public final static String getField";
  protected final String TEXT_18 = "_";
  protected final String TEXT_19 = "() {";
  protected final String TEXT_20 = NL + "                    return \"";
  protected final String TEXT_21 = "__";
  protected final String TEXT_22 = "\";";
  protected final String TEXT_23 = NL + "                    return ";
  protected final String TEXT_24 = ";";
  protected final String TEXT_25 = NL + "            }";
  protected final String TEXT_26 = NL + "            public final ";
  protected final String TEXT_27 = " get";
  protected final String TEXT_28 = "_";
  protected final String TEXT_29 = "() {" + NL + "                return ";
  protected final String TEXT_30 = "(tupleIndex";
  protected final String TEXT_31 = "_";
  protected final String TEXT_32 = ");" + NL + "            }";
  protected final String TEXT_33 = NL + "        public final static Values createValues(";
  protected final String TEXT_34 = " ";
  protected final String TEXT_35 = ") {" + NL + "            return new Values(";
  protected final String TEXT_36 = NL + "            );" + NL + "        }";
  protected final String TEXT_37 = NL + "        public static class ";
  protected final String TEXT_38 = " extends ";
  protected final String TEXT_39 = " {" + NL + "            /** Default serial version UID. */" + NL + "            private static final long serialVersionUID = 1L;" + NL + "            public ";
  protected final String TEXT_40 = "(TridentTuple tuple) {" + NL + "                super(tuple);" + NL + "            }" + NL + "        }";
  protected final String TEXT_41 = NL + "    static class FieldGenerator_";
  protected final String TEXT_42 = " extends org.talend.libs.tbd.ee.libstorm.AbstractFieldGenerator{";
  protected final String TEXT_43 = NL + "        public Object getNext() {";
  protected final String TEXT_44 = NL + "                return ";
  protected final String TEXT_45 = " ";
  protected final String TEXT_46 = " ";
  protected final String TEXT_47 = ";";
  protected final String TEXT_48 = NL + "                ";
  protected final String TEXT_49 = "[] ";
  protected final String TEXT_50 = "Table" + NL + "                    = new ";
  protected final String TEXT_51 = "[] { ";
  protected final String TEXT_52 = " };" + NL + "                java.util.Random random";
  protected final String TEXT_53 = " = new java.util.Random();" + NL + "                return ";
  protected final String TEXT_54 = "Table[random";
  protected final String TEXT_55 = ".nextInt(";
  protected final String TEXT_56 = "Table.length)];";
  protected final String TEXT_57 = NL + "                return ";
  protected final String TEXT_58 = " ";
  protected final String TEXT_59 = " ";
  protected final String TEXT_60 = ";";
  protected final String TEXT_61 = NL + "        }" + NL + "    }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    
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
        
    stringBuffer.append(TEXT_1);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_2);
    
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
            
    stringBuffer.append(TEXT_3);
    
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
        
    stringBuffer.append(TEXT_4);
    stringBuffer.append(getCodeFieldsAccessors(null, columnInfo.values()));
    stringBuffer.append(TEXT_5);
    
        int i = 0;
        for (IMetadataColumn column : columnInfo.values()) {
            String prefix = codeGenPrefix.get(column.getLabel());
            if (prefix == null)
                prefix = "";
            
    stringBuffer.append(TEXT_6);
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(i++);
    stringBuffer.append(TEXT_9);
    
        }
    }

    /**
     * Any class members that need to be created for this struct.
     *
     * By default, just the underlying private tuple that any instances of this
     * struct can wrap.
     */
    protected void generateMembers() {
        
    stringBuffer.append(TEXT_10);
     if (needsTupleMethods) { 
    stringBuffer.append(TEXT_11);
     }
    }

    /**
     * Constructors that need to be created for this struct.
     *
     * By default, the constructor that wraps an underlying tuple.
     */
    protected void generateConstructors() {
        if (needsTupleMethods) {
            
    stringBuffer.append(TEXT_12);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_13);
     generateInitializeMembers(); 
    stringBuffer.append(TEXT_14);
    
        }
    }

    /**
     * Class or instance that need to be initialized in the constructor.
     *
     * By default, the constructor that wraps an underlying tuple.
     */
    protected void generateInitializeMembers() {
        if (needsTupleMethods) {
            
    stringBuffer.append(TEXT_15);
    
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
            
    stringBuffer.append(TEXT_16);
    
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
            
    stringBuffer.append(TEXT_17);
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_19);
    
                String codeOverride = overrideCodeFieldName.get(column.getLabel());
                if (codeOverride == null) {
                    
    stringBuffer.append(TEXT_20);
    stringBuffer.append(fieldPrefix);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_22);
    
                } else {
                    
    stringBuffer.append(TEXT_23);
    stringBuffer.append(codeOverride);
    stringBuffer.append(TEXT_24);
    
                }
                
    stringBuffer.append(TEXT_25);
    
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
            
    stringBuffer.append(TEXT_26);
    stringBuffer.append(getCodeJavaType(column));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(getCodeTupleAccessorForType("tuple", column));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(prefix);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_32);
    
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
        
    stringBuffer.append(TEXT_33);
    
            boolean first = true;
            // Construct the method signature
            for (IMetadataColumn column : columnInfo.values()) {
                
    stringBuffer.append( first ? "" : ", " );
    stringBuffer.append(getCodeJavaType(column));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    
                first = false;
            }
            // Close the signature and start the body.
            
    stringBuffer.append(TEXT_35);
    
                first = true;
                for (IMetadataColumn column : columnInfo.values()) {
                    
    stringBuffer.append( first ? "" : ", " );
    stringBuffer.append(column.getLabel());
    
                    first = false;
                }
                
    stringBuffer.append(TEXT_36);
    
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
        
    stringBuffer.append(TEXT_37);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(parentClassName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_40);
    
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

    
List<IMetadataTable> metadatas = node.getMetadataList();

IMetadataTable metadata = null;
if((metadatas!=null) && (metadatas.size() > 0)){
    metadata = metadatas.get(0);
}
IConnection outConn = null;
String connName = null;
List<IMetadataColumn> columns = null;
if(metadata != null){
	List<? extends IConnection> conns = node.getOutgoingSortedConnections();
	if(conns != null){
		if(conns.size()>0){
			outConn = conns.get(0);
			connName = outConn.getName();
			if(outConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
				columns = metadata.getListColumns();
			}
		}
	}
}
if(metadata == null || connName == null || columns == null){
	return "";
}

List<Map<String, String>> tableValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__VALUES__");

new TupleWrapperHelper().generateAllOutgoing(node);

for(int i = 0; i < tableValues.size(); i++){
    Map<String, String> lineValue = tableValues.get(i);
    
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_42);
    
        String columnType = JavaTypesManager.getTypeToGenerate(columns.get(i).getTalendType(), columns.get(i).isNullable());

        String castedTypeBegin = "";
        String castedTypeEnd = "";
        if (columnType.equalsIgnoreCase("short")){
            castedTypeBegin = "(short) (";
            castedTypeEnd = ")";
        } else         if (columnType.equalsIgnoreCase("byte")){
            castedTypeBegin = "(byte) (";
            castedTypeEnd = ")";
        }
        
    stringBuffer.append(TEXT_43);
    
            /* TODO we need atomic integer in order to create true ID */
            /* if column parameter looks like abcd(efgh,...) )  */
            if(lineValue.get("ARRAY").indexOf("(") > 0){
            
    stringBuffer.append(TEXT_44);
    stringBuffer.append(castedTypeBegin);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(lineValue.get("ARRAY"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(castedTypeEnd);
    stringBuffer.append(TEXT_47);
    
            /* else if parameter is  separated by , */
            } else if (lineValue.get("ARRAY").indexOf(",") > 0){
            
    stringBuffer.append(TEXT_48);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(lineValue.get("ARRAY"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_56);
    
            }else{
            
    stringBuffer.append(TEXT_57);
    stringBuffer.append(castedTypeBegin);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(lineValue.get("ARRAY"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(castedTypeEnd);
    stringBuffer.append(TEXT_60);
    
            }
            
    stringBuffer.append(TEXT_61);
    
}

    return stringBuffer.toString();
  }
}
