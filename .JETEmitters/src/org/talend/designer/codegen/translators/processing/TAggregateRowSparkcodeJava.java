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
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.spark.aggregate.AggregateFunctionFactory;
import org.talend.designer.spark.aggregate.IAggregateFunction;
import org.talend.designer.spark.generator.utils.SparkFunctionUtil;

public class TAggregateRowSparkcodeJava
{
  protected static String nl;
  public static synchronized TAggregateRowSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateRowSparkcodeJava result = new TAggregateRowSparkcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " ";
  protected final String TEXT_2 = NL + "                public static class Extended";
  protected final String TEXT_3 = "_";
  protected final String TEXT_4 = " extends ";
  protected final String TEXT_5 = " {";
  protected final String TEXT_6 = NL + "                        ";
  protected final String TEXT_7 = NL + "                }";
  protected final String TEXT_8 = NL + NL + NL + "\t            // Map to the computation type and instantiate value." + NL + "\t            public static class PreMap";
  protected final String TEXT_9 = NL + "\t            implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<";
  protected final String TEXT_10 = ", ";
  protected final String TEXT_11 = ">, ";
  protected final String TEXT_12 = ", ";
  protected final String TEXT_13 = "> {" + NL + "\t                public scala.Tuple2<";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = "> call(scala.Tuple2<";
  protected final String TEXT_16 = ", ";
  protected final String TEXT_17 = "> data) throws Exception {" + NL + "\t                    ";
  protected final String TEXT_18 = " key = data._1;" + NL + "\t                    ";
  protected final String TEXT_19 = " input = data._2;" + NL + "\t                    ";
  protected final String TEXT_20 = " output = new ";
  protected final String TEXT_21 = "();";
  protected final String TEXT_22 = NL + "\t                        ";
  protected final String TEXT_23 = NL + "\t                    return new scala.Tuple2<";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ">(key, output);" + NL + "                }" + NL + "" + NL + "            }" + NL + "" + NL + "            // Combiner function" + NL + "            public static class Comb";
  protected final String TEXT_26 = " implements org.apache.spark.api.java.function.Function2<";
  protected final String TEXT_27 = ", ";
  protected final String TEXT_28 = ", ";
  protected final String TEXT_29 = "> {//$NON-NLS-1$" + NL + "                public ";
  protected final String TEXT_30 = "  call(";
  protected final String TEXT_31 = " output, ";
  protected final String TEXT_32 = " input) throws Exception {";
  protected final String TEXT_33 = NL + "                        ";
  protected final String TEXT_34 = NL + "                    return output;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            // Final mapping to the output value" + NL + "" + NL + "            public static class Map";
  protected final String TEXT_35 = " implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = ">, ";
  protected final String TEXT_38 = ", ";
  protected final String TEXT_39 = "> {" + NL + "                public scala.Tuple2<";
  protected final String TEXT_40 = ", ";
  protected final String TEXT_41 = "> call(scala.Tuple2<";
  protected final String TEXT_42 = ", ";
  protected final String TEXT_43 = "> data) throws Exception {";
  protected final String TEXT_44 = NL + "                    ";
  protected final String TEXT_45 = " key = data._1;";
  protected final String TEXT_46 = NL + "                    ";
  protected final String TEXT_47 = " input = data._2;";
  protected final String TEXT_48 = NL + "                        ";
  protected final String TEXT_49 = " output = new ";
  protected final String TEXT_50 = "();";
  protected final String TEXT_51 = NL + "                        ";
  protected final String TEXT_52 = " output = input;";
  protected final String TEXT_53 = NL + "                        ";
  protected final String TEXT_54 = NL + "                            output.";
  protected final String TEXT_55 = " = BigDataParserUtils.parseTo_Date(key._";
  protected final String TEXT_56 = "(), ";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "                            output.";
  protected final String TEXT_59 = " = java.nio.ByteBuffer.wrap(BigDataParserUtils.parseTo_String(key._";
  protected final String TEXT_60 = "()).getBytes());";
  protected final String TEXT_61 = NL + "                            output.";
  protected final String TEXT_62 = " = BigDataParserUtils.parseTo_";
  protected final String TEXT_63 = "(key._";
  protected final String TEXT_64 = "());";
  protected final String TEXT_65 = NL + "                    return new scala.Tuple2<";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = ">(key, output);" + NL + "                 };" + NL + "             }" + NL;
  protected final String TEXT_68 = NL + "                static class UtilClass_";
  protected final String TEXT_69 = " {" + NL + "" + NL + "                    public static void checkedIADD(byte a, byte b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "                        byte r = (byte) (a + b);" + NL + "                        if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {" + NL + "                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'short/Short'\", \"'byte/Byte'\"));" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                    public static void checkedIADD(short a, short b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "                        short r = (short)(a + b);" + NL + "                        if (checkTypeOverFlow && (short)((a ^ r) & (b ^ r)) < (short)0) {" + NL + "                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'int/Integer'\", \"'short/Short'\"));" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                    public static void checkedIADD(int a, int b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "                        int r = a + b;" + NL + "                        if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {" + NL + "                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'long/Long'\", \"'int/Integer'\"));" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                    public static void checkedIADD(long a, long b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "                        long r = a + b;" + NL + "                        if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {" + NL + "                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'BigDecimal'\", \"'long/Long'\"));" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                    public static void checkedIADD(float a, float b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "                        if(checkUlp) {" + NL + "                            float minAddedValue = Math.ulp(a);" + NL + "                            if (minAddedValue > Math.abs(b)) {" + NL + "                                throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(b), \"'double' or 'BigDecimal'\", \"'float/Float'\"));" + NL + "                            }" + NL + "                        }" + NL + "" + NL + "                        if (checkTypeOverFlow && ((double) a + (double) b > (double) Float.MAX_VALUE) || ((double) a + (double) b < (double) -Float.MAX_VALUE)) {" + NL + "                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'double' or 'BigDecimal'\", \"'float/Float'\"));" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                    public static void checkedIADD(double a, double b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "                        if(checkUlp) {" + NL + "                            double minAddedValue = Math.ulp(a);" + NL + "                            if (minAddedValue > Math.abs(b)) {" + NL + "                                throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(a), \"'BigDecimal'\", \"'double/Double'\"));" + NL + "                            }" + NL + "                        }" + NL + "" + NL + "                        if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {" + NL + "                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'BigDecimal'\", \"'double/Double'\"));" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                    public static void checkedIADD(BigDecimal a, BigDecimal b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "                        // Nothing, BigDecimal is infinite" + NL + "                    }" + NL + "" + NL + "                    private static String buildOverflowMessage(String a, String b, String advicedTypes, String originalType) {" + NL + "                        return \"Type overflow when adding \" + b + \" to \" + a" + NL + "                        + \", to resolve this problem, increase the precision by using \" + advicedTypes + \" type in place of \" + originalType + \".\";" + NL + "                    }" + NL + "" + NL + "                    private static String buildPrecisionMessage(String a, String b, String advicedTypes, String originalType) {" + NL + "                        return \"The double precision is unsufficient to add the value \" + b + \" to \" + a" + NL + "                        + \", to resolve this problem, increase the precision by using \" + advicedTypes + \" type in place of \" + originalType + \".\";" + NL + "                    }" + NL + "                }" + NL;
  protected final String TEXT_70 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
//Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final IBigDataNode bigDataNode = (IBigDataNode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();

if (metadatas != null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    if(metadata != null){
        List< ? extends IConnection> connections = node.getOutgoingConnections();
        List< ? extends IConnection> inConnections = node.getIncomingConnections();
        if ((connections != null) && (connections.size() > 0)
                && (inConnections != null) && (inConnections.size() > 0)) {
            IConnection connection = connections.get(0);
            IConnection inConnection = inConnections.get(0);
            String connName = connection.getName();
            String connectionTypeName = codeGenArgument.getRecordStructName(connection);
            String inConnectionTypeName = codeGenArgument.getRecordStructName(inConnection);


            List<Map<String, String>> groupBy = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
            List<String> groupByInput = new ArrayList<String>();
            List<String> groupByOutput = new ArrayList<String>();
            for (Map<String, String> element: groupBy) {
                groupByInput.add(element.get("INPUT_COLUMN"));
                groupByOutput.add(element.get("OUTPUT_COLUMN"));
            }

            Boolean useFinancialPrecision = "true".equals(ElementParameterParser.getValue(node, "__USE_FINANCIAL_PRECISION__"));
            boolean checkTypeOverflow = "true".equals(ElementParameterParser.getValue(node, "__CHECK_TYPE_OVERFLOW__"));
            boolean checkUlp = "true".equals(ElementParameterParser.getValue(node, "__CHECK_ULP__"));

            String computationType = connectionTypeName;
            Boolean needToExtendOutputType = useFinancialPrecision;
            List<Map<String, String>> operationTemp = (List<Map<String,String>>)
                    ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
            List<IAggregateFunction> aggregateFunctions = new ArrayList<IAggregateFunction>();
            for (Map<String, String> operationRow: operationTemp) {
                if (operationRow.get("FUNCTION").equals("std_dev") || operationRow.get("FUNCTION").equals("avg")) {
                    needToExtendOutputType = true;
                }
                aggregateFunctions.add(AggregateFunctionFactory.getFunction(cid, operationRow,
                        inConnection.getMetadataTable().getListColumns(), connection.getMetadataTable().getListColumns(),
                        useFinancialPrecision, checkTypeOverflow, checkUlp));
            }

            if (needToExtendOutputType) {
                
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_5);
    
                    for (IAggregateFunction aggregateFunction: aggregateFunctions) {
                        
    stringBuffer.append(TEXT_6);
    stringBuffer.append(aggregateFunction.getExtendedType());
    
                    }
                    
    stringBuffer.append(TEXT_7);
    
                computationType = "Extended" + cid + "_" + computationType;
            }

	            String keyType = SparkFunctionUtil.getKeyType(bigDataNode.getKeyList(), "BOTH");
            
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inConnectionTypeName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(inConnectionTypeName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(inConnectionTypeName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_21);
    
                    for (IAggregateFunction aggregateFunction: aggregateFunctions) {
                        
    stringBuffer.append(TEXT_22);
    stringBuffer.append(aggregateFunction.getPreMapping());
    
                    }
                    
    stringBuffer.append(TEXT_23);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_32);
    
                    for (IAggregateFunction aggregateFunction: aggregateFunctions) {
                        
    stringBuffer.append(TEXT_33);
    stringBuffer.append(aggregateFunction.getCombFunction());
    
                    }
                    
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_47);
    
                    if (needToExtendOutputType) {
                        
    stringBuffer.append(TEXT_48);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_50);
    
                    } else {
                        
    stringBuffer.append(TEXT_51);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_52);
    
                    }

                    for (IAggregateFunction aggregateFunction: aggregateFunctions) {
                        
    stringBuffer.append(TEXT_53);
    stringBuffer.append(aggregateFunction.getFinalMapping(needToExtendOutputType));
    
                    }

                    int keyCount = 0;
                    for (String outputKey: groupByOutput) {
                        // get the type of each groupBy element
                        String outputType = "";
                        String datePattern = "";
                        for (IMetadataColumn column : connection.getMetadataTable().getListColumns()) {
                            if (outputKey.equals(column.getLabel())) {
                                outputType = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                                if (outputType.equals("java.util.Date")) {
                                    datePattern = column.getPattern();
                                }
                                break;
                            }
                        }

                        keyCount++;
                        if (outputType.equals("java.util.Date")) {
                            
    stringBuffer.append(TEXT_54);
    stringBuffer.append(outputKey);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(keyCount);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(datePattern);
    stringBuffer.append(TEXT_57);
    
                        } else if (outputType.equals("byte[]")) {
                            
    stringBuffer.append(TEXT_58);
    stringBuffer.append(outputKey);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(keyCount);
    stringBuffer.append(TEXT_60);
    
                        } else {
                            
    stringBuffer.append(TEXT_61);
    stringBuffer.append(outputKey);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(outputType);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(keyCount);
    stringBuffer.append(TEXT_64);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_65);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_67);
    
            if (checkTypeOverflow || checkUlp) {
            
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    
            } //checkTypeOverflow || checkUlp
        }
    }
}

    stringBuffer.append(TEXT_70);
    return stringBuffer.toString();
  }
}
