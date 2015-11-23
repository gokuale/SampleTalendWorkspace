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

public class TAggregateRowSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TAggregateRowSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateRowSparkstreamingcodeJava result = new TAggregateRowSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = " ";
  protected final String TEXT_3 = NL + "                public static class Extended";
  protected final String TEXT_4 = "_";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = " {";
  protected final String TEXT_7 = NL + "                        ";
  protected final String TEXT_8 = NL + "                }";
  protected final String TEXT_9 = NL + NL + NL + "\t            // Map to the computation type and instantiate value." + NL + "\t            public static class PreMap";
  protected final String TEXT_10 = NL + "\t            implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<";
  protected final String TEXT_11 = ", ";
  protected final String TEXT_12 = ">, ";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = "> {" + NL + "\t                public scala.Tuple2<";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = "> call(scala.Tuple2<";
  protected final String TEXT_17 = ", ";
  protected final String TEXT_18 = "> data) throws Exception {" + NL + "\t                    ";
  protected final String TEXT_19 = " key = data._1;" + NL + "\t                    ";
  protected final String TEXT_20 = " input = data._2;" + NL + "\t                    ";
  protected final String TEXT_21 = " output = new ";
  protected final String TEXT_22 = "();";
  protected final String TEXT_23 = NL + "\t                        ";
  protected final String TEXT_24 = NL + "\t                    return new scala.Tuple2<";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ">(key, output);" + NL + "                }" + NL + "" + NL + "            }" + NL + "" + NL + "            // Combiner function" + NL + "            public static class Comb";
  protected final String TEXT_27 = " implements org.apache.spark.api.java.function.Function2<";
  protected final String TEXT_28 = ", ";
  protected final String TEXT_29 = ", ";
  protected final String TEXT_30 = "> {//$NON-NLS-1$" + NL + "                public ";
  protected final String TEXT_31 = "  call(";
  protected final String TEXT_32 = " output, ";
  protected final String TEXT_33 = " input) throws Exception {";
  protected final String TEXT_34 = NL + "                        ";
  protected final String TEXT_35 = NL + "                    return output;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            // Final mapping to the output value" + NL + "" + NL + "            public static class Map";
  protected final String TEXT_36 = " implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<";
  protected final String TEXT_37 = ", ";
  protected final String TEXT_38 = ">, ";
  protected final String TEXT_39 = ", ";
  protected final String TEXT_40 = "> {" + NL + "                public scala.Tuple2<";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = "> call(scala.Tuple2<";
  protected final String TEXT_43 = ", ";
  protected final String TEXT_44 = "> data) throws Exception {";
  protected final String TEXT_45 = NL + "                    ";
  protected final String TEXT_46 = " key = data._1;";
  protected final String TEXT_47 = NL + "                    ";
  protected final String TEXT_48 = " input = data._2;";
  protected final String TEXT_49 = NL + "                        ";
  protected final String TEXT_50 = " output = new ";
  protected final String TEXT_51 = "();";
  protected final String TEXT_52 = NL + "                        ";
  protected final String TEXT_53 = " output = input;";
  protected final String TEXT_54 = NL + "                        ";
  protected final String TEXT_55 = NL + "                            output.";
  protected final String TEXT_56 = " = BigDataParserUtils.parseTo_Date(key._";
  protected final String TEXT_57 = "(), ";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "                            output.";
  protected final String TEXT_60 = " = java.nio.ByteBuffer.wrap(BigDataParserUtils.parseTo_String(key._";
  protected final String TEXT_61 = "()).getBytes());";
  protected final String TEXT_62 = NL + "                            output.";
  protected final String TEXT_63 = " = BigDataParserUtils.parseTo_";
  protected final String TEXT_64 = "(key._";
  protected final String TEXT_65 = "());";
  protected final String TEXT_66 = NL + "                    return new scala.Tuple2<";
  protected final String TEXT_67 = ", ";
  protected final String TEXT_68 = ">(key, output);" + NL + "                 };" + NL + "             }" + NL;
  protected final String TEXT_69 = NL + "                static class UtilClass_";
  protected final String TEXT_70 = " {" + NL + "" + NL + "                    public static void checkedIADD(byte a, byte b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "                        byte r = (byte) (a + b);" + NL + "                        if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {" + NL + "                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'short/Short'\", \"'byte/Byte'\"));" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                    public static void checkedIADD(short a, short b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "                        short r = (short)(a + b);" + NL + "                        if (checkTypeOverFlow && (short)((a ^ r) & (b ^ r)) < (short)0) {" + NL + "                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'int/Integer'\", \"'short/Short'\"));" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                    public static void checkedIADD(int a, int b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "                        int r = a + b;" + NL + "                        if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {" + NL + "                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'long/Long'\", \"'int/Integer'\"));" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                    public static void checkedIADD(long a, long b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "                        long r = a + b;" + NL + "                        if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {" + NL + "                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'BigDecimal'\", \"'long/Long'\"));" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                    public static void checkedIADD(float a, float b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "                        if(checkUlp) {" + NL + "                            float minAddedValue = Math.ulp(a);" + NL + "                            if (minAddedValue > Math.abs(b)) {" + NL + "                                throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(b), \"'double' or 'BigDecimal'\", \"'float/Float'\"));" + NL + "                            }" + NL + "                        }" + NL + "" + NL + "                        if (checkTypeOverFlow && ((double) a + (double) b > (double) Float.MAX_VALUE) || ((double) a + (double) b < (double) -Float.MAX_VALUE)) {" + NL + "                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'double' or 'BigDecimal'\", \"'float/Float'\"));" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                    public static void checkedIADD(double a, double b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "                        if(checkUlp) {" + NL + "                            double minAddedValue = Math.ulp(a);" + NL + "                            if (minAddedValue > Math.abs(b)) {" + NL + "                                throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(a), \"'BigDecimal'\", \"'double/Double'\"));" + NL + "                            }" + NL + "                        }" + NL + "" + NL + "                        if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {" + NL + "                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'BigDecimal'\", \"'double/Double'\"));" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                    public static void checkedIADD(BigDecimal a, BigDecimal b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "                        // Nothing, BigDecimal is infinite" + NL + "                    }" + NL + "" + NL + "                    private static String buildOverflowMessage(String a, String b, String advicedTypes, String originalType) {" + NL + "                        return \"Type overflow when adding \" + b + \" to \" + a" + NL + "                        + \", to resolve this problem, increase the precision by using \" + advicedTypes + \" type in place of \" + originalType + \".\";" + NL + "                    }" + NL + "" + NL + "                    private static String buildPrecisionMessage(String a, String b, String advicedTypes, String originalType) {" + NL + "                        return \"The double precision is unsufficient to add the value \" + b + \" to \" + a" + NL + "                        + \", to resolve this problem, increase the precision by using \" + advicedTypes + \" type in place of \" + originalType + \".\";" + NL + "                    }" + NL + "                }" + NL;
  protected final String TEXT_71 = NL + "\t                public static class Extended";
  protected final String TEXT_72 = "_";
  protected final String TEXT_73 = " extends ";
  protected final String TEXT_74 = " {" + NL + "\t                    ";
  protected final String TEXT_75 = NL + "\t                        ";
  protected final String TEXT_76 = NL + "\t                        ";
  protected final String TEXT_77 = NL + "\t                }" + NL + "\t                ";
  protected final String TEXT_78 = NL + "\t" + NL + "\t" + NL + "\t            // Map to the computation type and instantiate value." + NL + "\t            public static class PreMap";
  protected final String TEXT_79 = NL + "\t            implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<";
  protected final String TEXT_80 = ", ";
  protected final String TEXT_81 = ">, ";
  protected final String TEXT_82 = ", ";
  protected final String TEXT_83 = "> {" + NL + "\t                public scala.Tuple2<";
  protected final String TEXT_84 = ", ";
  protected final String TEXT_85 = "> call(scala.Tuple2<";
  protected final String TEXT_86 = ", ";
  protected final String TEXT_87 = "> data) throws Exception {" + NL + "\t                    ";
  protected final String TEXT_88 = " key = data._1;" + NL + "\t                    ";
  protected final String TEXT_89 = " input = data._2;" + NL + "\t                    ";
  protected final String TEXT_90 = " output = new ";
  protected final String TEXT_91 = "();" + NL + "\t                    ";
  protected final String TEXT_92 = NL + "\t                        ";
  protected final String TEXT_93 = NL + "\t                        ";
  protected final String TEXT_94 = NL + "\t                    return new scala.Tuple2<";
  protected final String TEXT_95 = ", ";
  protected final String TEXT_96 = ">(key, output);" + NL + "\t                }" + NL + "\t            }" + NL + "\t" + NL + "\t            // Combiner function" + NL + "\t            public static class Comb";
  protected final String TEXT_97 = " implements org.apache.spark.api.java.function.Function2<";
  protected final String TEXT_98 = ", ";
  protected final String TEXT_99 = ", ";
  protected final String TEXT_100 = "> {//$NON-NLS-1$" + NL + "\t                public ";
  protected final String TEXT_101 = "  call(";
  protected final String TEXT_102 = " output, ";
  protected final String TEXT_103 = " input) throws Exception {" + NL + "\t                    ";
  protected final String TEXT_104 = NL + "\t                        ";
  protected final String TEXT_105 = NL + "\t                        ";
  protected final String TEXT_106 = NL + "\t                    return output;" + NL + "\t                }" + NL + "\t            }" + NL + "\t" + NL + "\t            // Final mapping to the output value" + NL + "\t" + NL + "\t            public static class Map";
  protected final String TEXT_107 = " implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<";
  protected final String TEXT_108 = ", ";
  protected final String TEXT_109 = ">, ";
  protected final String TEXT_110 = ", ";
  protected final String TEXT_111 = "> {" + NL + "\t                public scala.Tuple2<";
  protected final String TEXT_112 = ", ";
  protected final String TEXT_113 = "> call(scala.Tuple2<";
  protected final String TEXT_114 = ", ";
  protected final String TEXT_115 = "> data) throws Exception {" + NL + "\t                    ";
  protected final String TEXT_116 = " key = data._1;" + NL + "\t                    ";
  protected final String TEXT_117 = " input = data._2;" + NL + "\t                    ";
  protected final String TEXT_118 = NL + "\t                        ";
  protected final String TEXT_119 = " output = new ";
  protected final String TEXT_120 = "();" + NL + "\t                        ";
  protected final String TEXT_121 = NL + "\t                        ";
  protected final String TEXT_122 = " output = input;" + NL + "\t                        ";
  protected final String TEXT_123 = NL + "\t                        ";
  protected final String TEXT_124 = NL + "\t                        ";
  protected final String TEXT_125 = NL + "\t                            output.";
  protected final String TEXT_126 = " = BigDataParserUtils.parseTo_Date(key._";
  protected final String TEXT_127 = "(), ";
  protected final String TEXT_128 = ");" + NL + "\t                            ";
  protected final String TEXT_129 = NL + "\t                            output.";
  protected final String TEXT_130 = " = java.nio.ByteBuffer.wrap(BigDataParserUtils.parseTo_String(key._";
  protected final String TEXT_131 = "()).getBytes());" + NL + "\t                            ";
  protected final String TEXT_132 = NL + "\t                        output.";
  protected final String TEXT_133 = " = BigDataParserUtils.parseTo_";
  protected final String TEXT_134 = "(key._";
  protected final String TEXT_135 = "());" + NL + "\t                        ";
  protected final String TEXT_136 = NL + "\t                    return new scala.Tuple2<";
  protected final String TEXT_137 = ", ";
  protected final String TEXT_138 = ">(key, output);" + NL + "\t                 };" + NL + "\t             }" + NL + "\t" + NL + "\t            ";
  protected final String TEXT_139 = NL + "\t                static class UtilClass_";
  protected final String TEXT_140 = " {" + NL + "\t" + NL + "\t                    public static void checkedIADD(byte a, byte b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "\t                        byte r = (byte) (a + b);" + NL + "\t                        if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {" + NL + "\t                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'short/Short'\", \"'byte/Byte'\"));" + NL + "\t                        }" + NL + "\t                    }" + NL + "\t" + NL + "\t                    public static void checkedIADD(short a, short b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "\t                        short r = (short)(a + b);" + NL + "\t                        if (checkTypeOverFlow && (short)((a ^ r) & (b ^ r)) < (short)0) {" + NL + "\t                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'int/Integer'\", \"'short/Short'\"));" + NL + "\t                        }" + NL + "\t                    }" + NL + "\t" + NL + "\t                    public static void checkedIADD(int a, int b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "\t                        int r = a + b;" + NL + "\t                        if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {" + NL + "\t                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'long/Long'\", \"'int/Integer'\"));" + NL + "\t                        }" + NL + "\t                    }" + NL + "\t" + NL + "\t                    public static void checkedIADD(long a, long b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "\t                        long r = a + b;" + NL + "\t                        if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {" + NL + "\t                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'BigDecimal'\", \"'long/Long'\"));" + NL + "\t                        }" + NL + "\t                    }" + NL + "\t" + NL + "\t                    public static void checkedIADD(float a, float b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "\t                        if(checkUlp) {" + NL + "\t                            float minAddedValue = Math.ulp(a);" + NL + "\t                            if (minAddedValue > Math.abs(b)) {" + NL + "\t                                throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(b), \"'double' or 'BigDecimal'\", \"'float/Float'\"));" + NL + "\t                            }" + NL + "\t                        }" + NL + "\t" + NL + "\t                        if (checkTypeOverFlow && ((double) a + (double) b > (double) Float.MAX_VALUE) || ((double) a + (double) b < (double) -Float.MAX_VALUE)) {" + NL + "\t                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'double' or 'BigDecimal'\", \"'float/Float'\"));" + NL + "\t                        }" + NL + "\t                    }" + NL + "\t" + NL + "\t                    public static void checkedIADD(double a, double b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "\t                        if(checkUlp) {" + NL + "\t                            double minAddedValue = Math.ulp(a);" + NL + "\t                            if (minAddedValue > Math.abs(b)) {" + NL + "\t                                throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(a), \"'BigDecimal'\", \"'double/Double'\"));" + NL + "\t                            }" + NL + "\t                        }" + NL + "\t" + NL + "\t                        if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {" + NL + "\t                            throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), \"'BigDecimal'\", \"'double/Double'\"));" + NL + "\t                        }" + NL + "\t                    }" + NL + "\t" + NL + "\t                    public static void checkedIADD(BigDecimal a, BigDecimal b, boolean checkTypeOverFlow, boolean checkUlp) {" + NL + "\t                        // Nothing, BigDecimal is infinite" + NL + "\t                    }" + NL + "\t" + NL + "\t                    private static String buildOverflowMessage(String a, String b, String advicedTypes, String originalType) {" + NL + "\t                        return \"Type overflow when adding \" + b + \" to \" + a" + NL + "\t                        + \", to resolve this problem, increase the precision by using \" + advicedTypes + \" type in place of \" + originalType + \".\";" + NL + "\t                    }" + NL + "\t" + NL + "\t                    private static String buildPrecisionMessage(String a, String b, String advicedTypes, String originalType) {" + NL + "\t                        return \"The double precision is unsufficient to add the value \" + b + \" to \" + a" + NL + "\t                        + \", to resolve this problem, increase the precision by using \" + advicedTypes + \" type in place of \" + originalType + \".\";" + NL + "\t                    }" + NL + "\t                }" + NL + "\t" + NL + "\t                ";
  protected final String TEXT_141 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    


if(org.talend.designer.common.tmap.LookupUtil.isNodeInBatchMode((INode) ((BigDataCodeGeneratorArgument) argument).getArgument())) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
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
                
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_6);
    
                    for (IAggregateFunction aggregateFunction: aggregateFunctions) {
                        
    stringBuffer.append(TEXT_7);
    stringBuffer.append(aggregateFunction.getExtendedType());
    
                    }
                    
    stringBuffer.append(TEXT_8);
    
                computationType = "Extended" + cid + "_" + computationType;
            }

	            String keyType = SparkFunctionUtil.getKeyType(bigDataNode.getKeyList(), "BOTH");
            
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(inConnectionTypeName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(inConnectionTypeName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(inConnectionTypeName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_22);
    
                    for (IAggregateFunction aggregateFunction: aggregateFunctions) {
                        
    stringBuffer.append(TEXT_23);
    stringBuffer.append(aggregateFunction.getPreMapping());
    
                    }
                    
    stringBuffer.append(TEXT_24);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
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
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_33);
    
                    for (IAggregateFunction aggregateFunction: aggregateFunctions) {
                        
    stringBuffer.append(TEXT_34);
    stringBuffer.append(aggregateFunction.getCombFunction());
    
                    }
                    
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_48);
    
                    if (needToExtendOutputType) {
                        
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_51);
    
                    } else {
                        
    stringBuffer.append(TEXT_52);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_53);
    
                    }

                    for (IAggregateFunction aggregateFunction: aggregateFunctions) {
                        
    stringBuffer.append(TEXT_54);
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
                            
    stringBuffer.append(TEXT_55);
    stringBuffer.append(outputKey);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(keyCount);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(datePattern);
    stringBuffer.append(TEXT_58);
    
                        } else if (outputType.equals("byte[]")) {
                            
    stringBuffer.append(TEXT_59);
    stringBuffer.append(outputKey);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(keyCount);
    stringBuffer.append(TEXT_61);
    
                        } else {
                            
    stringBuffer.append(TEXT_62);
    stringBuffer.append(outputKey);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(outputType);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(keyCount);
    stringBuffer.append(TEXT_65);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_66);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_68);
    
            if (checkTypeOverflow || checkUlp) {
            
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    
            } //checkTypeOverflow || checkUlp
        }
    }
}

    
} else {
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
	                
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_74);
    
	                    for (IAggregateFunction aggregateFunction: aggregateFunctions) {
	                        
    stringBuffer.append(TEXT_75);
    stringBuffer.append(aggregateFunction.getExtendedType());
    stringBuffer.append(TEXT_76);
    
	                    }
	                    
    stringBuffer.append(TEXT_77);
    
	                computationType = "Extended" + cid + "_" + computationType;
	            }
	
	            String keyType = SparkFunctionUtil.getKeyType(bigDataNode.getKeyList(), "BOTH");
	            
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(inConnectionTypeName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(inConnectionTypeName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(inConnectionTypeName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_91);
    
	                    for (IAggregateFunction aggregateFunction: aggregateFunctions) {
	                        
    stringBuffer.append(TEXT_92);
    stringBuffer.append(aggregateFunction.getPreMapping());
    stringBuffer.append(TEXT_93);
    
	                    }
	                    
    stringBuffer.append(TEXT_94);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_103);
    
	                    for (IAggregateFunction aggregateFunction: aggregateFunctions) {
	                        
    stringBuffer.append(TEXT_104);
    stringBuffer.append(aggregateFunction.getCombFunction());
    stringBuffer.append(TEXT_105);
    
	                    }
	                    
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(computationType);
    stringBuffer.append(TEXT_117);
    
	                    if (needToExtendOutputType) {
	                        
    stringBuffer.append(TEXT_118);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_120);
    
	                    } else {
	                        
    stringBuffer.append(TEXT_121);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_122);
    
	                    }
	
	                    for (IAggregateFunction aggregateFunction: aggregateFunctions) {
	                        
    stringBuffer.append(TEXT_123);
    stringBuffer.append(aggregateFunction.getFinalMapping(needToExtendOutputType));
    stringBuffer.append(TEXT_124);
    
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
	                            
    stringBuffer.append(TEXT_125);
    stringBuffer.append(outputKey);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(keyCount);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(datePattern);
    stringBuffer.append(TEXT_128);
    
	                        } else if (outputType.equals("byte[]")) {
	                            
    stringBuffer.append(TEXT_129);
    stringBuffer.append(outputKey);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(keyCount);
    stringBuffer.append(TEXT_131);
    
	                        } else {
	                        
    stringBuffer.append(TEXT_132);
    stringBuffer.append(outputKey);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(outputType);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(keyCount);
    stringBuffer.append(TEXT_135);
    
	                        }
	                    }
	                    
    stringBuffer.append(TEXT_136);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_138);
    
	            if (checkTypeOverflow || checkUlp) {
	            
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    
	            } //checkTypeOverflow || checkUlp
	        }
	    }
	}
}

    stringBuffer.append(TEXT_141);
    return stringBuffer.toString();
  }
}
