package org.talend.designer.codegen.translators.misc;

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

public class TFixedFlowInputSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TFixedFlowInputSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFixedFlowInputSparkstreamingconfigJava result = new TFixedFlowInputSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            ";
  protected final String TEXT_2 = " = init(new Object[][] { new Object[] {";
  protected final String TEXT_3 = "}});";
  protected final String TEXT_4 = NL + "            ";
  protected final String TEXT_5 = " = init(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "            private java.util.List<java.util.List<Object>> init(Object[][] fixedValuesAsArray) {" + NL + "                List<List<Object>> fixedValues = new java.util.ArrayList<java.util.List<Object>>();" + NL + "                for (Object[] tuple : fixedValuesAsArray)" + NL + "                    fixedValues.add(java.util.Arrays.asList(tuple));" + NL + "                return fixedValues;" + NL + "            }";
  protected final String TEXT_8 = NL + "            private java.util.List<java.util.List<Object>> init(String... base64Rows) {" + NL + "                java.util.List<java.util.List<Object>> fixedValues = new java.util.ArrayList<java.util.List<Object>>();" + NL + "" + NL + "                StringBuilder base64 = new StringBuilder();" + NL + "                for (String row : base64Rows)" + NL + "                    base64.append(row);" + NL + "" + NL + "                String originalFileContent = \"\";" + NL + "                try {" + NL + "                    originalFileContent = new String((new sun.misc.BASE64Decoder()).decodeBuffer(base64.toString()), utf8Charset);" + NL + "" + NL + "                    org.talend.fileprocess.FileInputDelimited fid = new org.talend.fileprocess.FileInputDelimited(" + NL + "                            new java.io.ByteArrayInputStream(originalFileContent.getBytes(utf8Charset))," + NL + "                            utf8Charset,";
  protected final String TEXT_9 = NL + "                            ";
  protected final String TEXT_10 = ",";
  protected final String TEXT_11 = NL + "                            ";
  protected final String TEXT_12 = "," + NL + "                            true, 0, 0, -1, -1, false);" + NL + "" + NL + "                    while (fid.nextRecord()) {" + NL + "                        java.util.List<Object> tuple = new java.util.ArrayList<Object>();" + NL;
  protected final String TEXT_13 = NL + NL + "                            if (";
  protected final String TEXT_14 = " < fid.getColumnsCountOfCurrentRow()) {" + NL + "                                String colContent = fid.get(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "                                    tuple.add(colContent == null || colContent.length() == 0" + NL + "                                            ? ";
  protected final String TEXT_17 = ": colContent);";
  protected final String TEXT_18 = NL + "                                    if ( colContent == null || colContent.length() == 0) {" + NL + "                                        tuple.add(BigDataParserUtils.parseTo_Date(";
  protected final String TEXT_19 = NL + "                                                (String)";
  protected final String TEXT_20 = " ";
  protected final String TEXT_21 = ",";
  protected final String TEXT_22 = NL + "                                            ";
  protected final String TEXT_23 = "));" + NL + "                                    } else {" + NL + "                                        tuple.add(BigDataParserUtils.parseTo_Date(colContent, ";
  protected final String TEXT_24 = "));" + NL + "                                    }";
  protected final String TEXT_25 = NL + "                                    tuple.add(colContent == null || colContent.length() == 0" + NL + "                                             ? ";
  protected final String TEXT_26 = " : colContent.getBytes());";
  protected final String TEXT_27 = NL + "                                    tuple.add(colContent == null || colContent.trim().length() == 0" + NL + "                                            ? ";
  protected final String TEXT_28 = " : BigDataParserUtils.parseTo_";
  protected final String TEXT_29 = "(colContent));";
  protected final String TEXT_30 = NL + "                            } else {";
  protected final String TEXT_31 = NL + "                                    tuple.add(";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "                                    tuple.add(BigDataParserUtils.parseTo_Date((String)";
  protected final String TEXT_34 = ", ";
  protected final String TEXT_35 = "));";
  protected final String TEXT_36 = NL + "                                    tuple.add(BigDataParserUtils.parseTo_Date(";
  protected final String TEXT_37 = ", ";
  protected final String TEXT_38 = "));";
  protected final String TEXT_39 = NL + "                            }";
  protected final String TEXT_40 = NL + NL + "                        fixedValues.add(tuple);" + NL + "                    }" + NL + "" + NL + "                } catch (java.lang.Exception e) {" + NL + "                    e.printStackTrace();" + NL + "                }" + NL + "" + NL + "                return fixedValues;" + NL + "            }";
  protected final String TEXT_41 = NL + "                Object o_";
  protected final String TEXT_42 = " = ";
  protected final String TEXT_43 = ".get(";
  protected final String TEXT_44 = ").get(";
  protected final String TEXT_45 = ");" + NL + "                if(o_";
  protected final String TEXT_46 = " != null) {";
  protected final String TEXT_47 = NL + "                    ";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = " = java.nio.ByteBuffer.wrap((";
  protected final String TEXT_50 = ") o_";
  protected final String TEXT_51 = ");" + NL + "                }";
  protected final String TEXT_52 = NL + "                ";
  protected final String TEXT_53 = ".";
  protected final String TEXT_54 = " =" + NL + "                        (";
  protected final String TEXT_55 = ") ";
  protected final String TEXT_56 = ".get(";
  protected final String TEXT_57 = ").get(";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL;
  protected final String TEXT_60 = NL + "org.apache.spark.streaming.api.java.JavaDStream<";
  protected final String TEXT_61 = "> ";
  protected final String TEXT_62 = "_sourceDStream = ctx.receiverStream(new CustomReceiver_";
  protected final String TEXT_63 = "(new Data_";
  protected final String TEXT_64 = "().getList(),Long.valueOf(";
  protected final String TEXT_65 = ").longValue()));" + NL + "" + NL + "org.apache.spark.streaming.api.java.JavaPairDStream<NullWritable, ";
  protected final String TEXT_66 = "> rdd_";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = "_sourceDStream.mapToPair(new ";
  protected final String TEXT_69 = "_mapToPair(job));";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

final String repetitionInterval = ElementParameterParser.getValue(node, "__INPUT_REPETITION__");


    

/**
 * Contains common processing for tFixedFlowInput code generation.  This is
 * used in MapReduce.
 *
 * The following imports must occur before importing this file:
 * @ include file="@{org.talend.designer.components.mrprovider}/resources/utils/common_codegen_util.javajet"
 */
class TFixedFlowInputUtil extends org.talend.designer.common.TransformerBase {

    /** If initialized, contains code that can be assigned to a list of lists.
     *  Exactly one of codeValues or codeValuesBase64 will be non-null. */
    private StringBuilder codeValues = null;

    /** If initialized, contains code that can be assigned to a list of lists.
     *  Exactly one of codeValues or codeValuesBase64 will be non-null. */
    private StringBuilder codeValuesBase64 = null;

    /** The number of times the specified values should be repeated. */
    public final String nbRows;

    public TFixedFlowInputUtil(INode node,
            org.talend.designer.common.BigDataCodeGeneratorArgument argument,
            org.talend.designer.common.CommonRowTransformUtil rowTransformUtil) {
        super(node, argument, rowTransformUtil, "FLOW", "REJECT");

        nbRows = ElementParameterParser.getValue(node, "__NB_ROWS__");

        // Exactly one of these will be true.
        if ("true".equals(ElementParameterParser.getValue(node, "__USE_SINGLEMODE__")))
            initCodeValuesSingleMode((List<Map<String,String>>)
                    ElementParameterParser.getObjectValue(node, "__VALUES__"));
        else if ("true".equals(ElementParameterParser.getValue(node, "__USE_INTABLE__")))
            initCodeValuesInTable((List<Map<String,String>>)
                    ElementParameterParser.getObjectValue(node, "__INTABLE__"));
        else if ("true".equals(ElementParameterParser.getValue(node, "__USE_INLINECONTENT__")))
            initCodeValuesInlineContent(ElementParameterParser.getValue(node,"__INLINECONTENT__"));
    }

    /**
     * Used from the constructor to initialize the fixed values when only a
     * single value is specified.
     */
    private void initCodeValuesSingleMode(List<Map<String,String>> tableValues) {
        codeValues = new StringBuilder();
        if (tableValues == null || tableValues.size() == 0)
            return;

        for(Map<String, String> tableValue : tableValues) {
            String label = tableValue.get("SCHEMA_COLUMN");
            String value = tableValue.get("VALUE");
            if (value == null || value.length() == 0) { //use the default value
                IMetadataColumn column = getOutConnMain().getMetadataTable().getColumn(label);
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                String defaultValue = "null";
                if (column.getDefault() != null && column.getDefault().length() > 0) {
                    defaultValue = column.getDefault();
                } else {
                    if (typeToGenerate == null) {
                        throw new IllegalArgumentException();
                    }
                    if (JavaTypesManager.isJavaPrimitiveType(typeToGenerate)) {
                        if ("char".equals(typeToGenerate)) {
                            defaultValue = "' '";
                        } else if ("boolean".equals(typeToGenerate)) {
                            defaultValue = "false";
                        } else if ("byte".equals(typeToGenerate)) {
                            defaultValue = "(byte)0";
                        } else if ("double".equals(typeToGenerate)) {
                            defaultValue = "0.0d";
                        } else if ("float".equals(typeToGenerate)) {
                            defaultValue = "0.0f";
                        } else if ("long".equals(typeToGenerate)) {
                            defaultValue = "0l";
                        } else if ("short".equals(typeToGenerate)) {
                            defaultValue = "(short) 0";
                        } else {
                            defaultValue = "0";
                        }
                    }
                }
                codeValues.append(defaultValue).append(',');
            } else {
                codeValues.append(value).append(',');
            }
        }
        // Remove trailing commas.
        if (codeValues.length() > 0)
            codeValues.setLength(codeValues.length() - 1);
    }

    /**
     * Used from the constructor to initialize the fixed values when the list of
     * values is specified in the parameter table.
     */
    private void initCodeValuesInTable(List<Map<String,String>> tableValues) {
        codeValues = new StringBuilder();
        if (tableValues == null || tableValues.size() == 0)
            return;

        for (Map<String, String> tableValue : tableValues) {
            if (0 != codeValues.length())
                codeValues.append("}, new Object[] {");
            for (IMetadataColumn column: getOutColumnsMain()) {
                String label = column.getLabel();
                String value = tableValue.get(label);
                if (value == null || value.length() == 0) { //use the default value
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                    if (column.getDefault() != null && column.getDefault().length() > 0) {
                        codeValues.append(column.getDefault()).append(',');
                    } else {
                        if (typeToGenerate == null) {
                            throw new IllegalArgumentException();
                        }
                        if (JavaTypesManager.isJavaPrimitiveType(typeToGenerate)) {
                            if ("char".equals(typeToGenerate)) {
                                codeValues.append("' '").append(',');
                            } else if ("boolean".equals(typeToGenerate)) {
                                codeValues.append("false").append(',');
                            } else if ("byte".equals(typeToGenerate)) {
                                codeValues.append("(byte)0").append(',');
                            } else if ("double".equals(typeToGenerate)) {
                                codeValues.append("0.0d").append(',');
                            } else if ("float".equals(typeToGenerate)) {
                                codeValues.append("0.0f").append(',');
                            } else if ("long".equals(typeToGenerate)) {
                                codeValues.append("0l").append(',');
                            } else if ("short".equals(typeToGenerate)) {
                                codeValues.append("(short) 0").append(',');
                            } else {
                                codeValues.append("0").append(',');
                            }
                        } else {
                            codeValues.append("null").append(',');
                        }
                    }
                } else {
                    codeValues.append(value).append(',');
                }
            }
            // Remove trailing commas.
            if (codeValues.length() > 0)
                codeValues.setLength(codeValues.length() - 1);
        }
    }

    /**
     * Used from the constructor to initialize the fixed values when the list of
     * values is specified inline.
     */
    private void initCodeValuesInlineContent(String fileContent) {
        String lineSeparator = (String) java.security.AccessController.doPrivileged(
                new sun.security.action.GetPropertyAction("line.separator"));

        String fileContentEnCodeStr = "";
        try {
            fileContentEnCodeStr = (new sun.misc.BASE64Encoder()).encode(fileContent.getBytes("UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        codeValuesBase64 = new StringBuilder();
        for(String item : fileContentEnCodeStr.split(lineSeparator))
            codeValuesBase64.append('"').append(item).append("\",");
        // Remove trailing commas.
        if (codeValuesBase64.length() > 0)
            codeValuesBase64.setLength(codeValuesBase64.length() - 1);
    }

    /**
     * Generates the initialized class member that will contain the fixed data.
     */
    public void generateFixedDataMember(String codeFixedVar) {
        // The fixed data member is composed of a simple declaration, but also
        // a method to parse the data passed in.
        if (codeValues != null) {
            
    stringBuffer.append(TEXT_1);
    stringBuffer.append(codeFixedVar);
    stringBuffer.append(TEXT_2);
    stringBuffer.append( codeValues );
    stringBuffer.append(TEXT_3);
    
        } else {
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(codeFixedVar);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( codeValuesBase64 );
    stringBuffer.append(TEXT_6);
    
        }
    }

    /**
     * Generates a private static init method that can be used to initialize a
     * static List of List of objects from the values specified by the user.
     */
    public void generateFixedDataInit() {
        if (codeValues != null) {
            
    stringBuffer.append(TEXT_7);
    
        } else {
            
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append( ElementParameterParser.getValue(node, "__FIELDSEPARATOR__") );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append( ElementParameterParser.getValue(node, "__ROWSEPARATOR__") );
    stringBuffer.append(TEXT_12);
    
                        int i = -1;
                        for (IMetadataColumn column : getOutColumnsMain()) {
                            i++;
                            String label = column.getLabel();
                            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                            String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

                            String defaultValue = "null";
                            if (column.getDefault() != null && column.getDefault().length() > 0) {
                                defaultValue = column.getDefault();
                            } else {
                                if (typeToGenerate == null) {
                                    throw new IllegalArgumentException();
                                }
                                if (JavaTypesManager.isJavaPrimitiveType(typeToGenerate)) {
                                    if ("char".equals(typeToGenerate)) {
                                        defaultValue = "' '";
                                    } else if ("boolean".equals(typeToGenerate)) {
                                        defaultValue = "false";
                                    } else if ("byte".equals(typeToGenerate)) {
                                        defaultValue = "(byte)0";
                                    } else if ("double".equals(typeToGenerate)) {
                                        defaultValue = "0.0d";
                                    } else if ("float".equals(typeToGenerate)) {
                                        defaultValue = "0.0f";
                                    } else if ("long".equals(typeToGenerate)) {
                                        defaultValue = "0l";
                                    } else if ("short".equals(typeToGenerate)) {
                                        defaultValue = "(short) 0";
                                    } else {
                                        defaultValue = "0";
                                    }
                                }
                            }
                            
    stringBuffer.append(TEXT_13);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_15);
    
                                if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
                                    
    stringBuffer.append(TEXT_16);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_17);
    
                                } else if (javaType == JavaTypesManager.DATE) {
                                    
    stringBuffer.append(TEXT_18);
     if ((defaultValue==null) || "".equals(defaultValue) || "null".equals(defaultValue)){ 
    stringBuffer.append(TEXT_19);
     } 
    stringBuffer.append(TEXT_20);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(TEXT_22);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_24);
    
                                } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
                                    
    stringBuffer.append(TEXT_25);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_26);
    
                                } else {
                                    
    stringBuffer.append(TEXT_27);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_29);
    
                                }
                                
    stringBuffer.append(TEXT_30);
    
                                if (javaType != JavaTypesManager.DATE) {
                                    
    stringBuffer.append(TEXT_31);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_32);
    
                                } else if (defaultValue == null || "".equals(defaultValue) || "null".equals(defaultValue)) {
                                    
    stringBuffer.append(TEXT_33);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_34);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_35);
    
                                } else {
                                    
    stringBuffer.append(TEXT_36);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_37);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_38);
    
                                }
                                
    stringBuffer.append(TEXT_39);
    
                        }
                        
    stringBuffer.append(TEXT_40);
    
        }
    }

    /**
     * Generates code to copy from the fixed buffer to the named output struct.
     */
    public void generateCopyFromFixedToOut(String codeFixedVar, String codeOutStruct, String codeRowCount) {
        int i = 0;
        for (IMetadataColumn column : getOutColumnsMain()) {
            // TODO: this assignment should be handled by a new RowTransformUtil
            // that doesn't rely on an underlying Mapper.
            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

            // Avro metadata table compatibility
            if (codeGenArgument.getRecordStructGenerator().isByteArrayWrappedInBuffer()&& (javaType == JavaTypesManager.BYTE_ARRAY)) {
                
    stringBuffer.append(TEXT_41);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(codeFixedVar);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(codeRowCount);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(codeOutStruct);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_49);
    stringBuffer.append( javaType.getNullableClass().getSimpleName() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_51);
    
                i++;
            } else {
                
    stringBuffer.append(TEXT_52);
    stringBuffer.append(codeOutStruct);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_54);
    stringBuffer.append( javaType.getNullableClass().getSimpleName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(codeFixedVar);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(codeRowCount);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(i++);
    stringBuffer.append(TEXT_58);
    
            }
        }
    }
}

    stringBuffer.append(TEXT_59);
    
final TFixedFlowInputUtil tFixedFlowInputUtil = new TFixedFlowInputUtil(node, codeGenArgument, null);

List< ? extends IConnection> connections = node.getOutgoingConnections();
if (connections == null || connections.size() == 0)
    return "";

IConnection connection = connections.get(0);
String connName = connection.getName();
String outStruct = codeGenArgument.getRecordStructName(connection);

    stringBuffer.append(TEXT_60);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(repetitionInterval);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    return stringBuffer.toString();
  }
}
