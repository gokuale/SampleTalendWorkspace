package org.talend.designer.codegen.translators.processing.fields;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.spark.generator.SparkFunction;

public class TExtractAbstractAvroFieldsSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TExtractAbstractAvroFieldsSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractAbstractAvroFieldsSparkstreamingconfigJava result = new TExtractAbstractAvroFieldsSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        public static class ";
  protected final String TEXT_2 = " implements ";
  protected final String TEXT_3 = " {";
  protected final String TEXT_4 = NL + NL + "            private ContextProperties context = null;" + NL + "" + NL + "            public ";
  protected final String TEXT_5 = "(JobConf job) {" + NL + "                this.context = new ContextProperties(job);" + NL + "            }" + NL + "" + NL + "            public ";
  protected final String TEXT_6 = " ";
  protected final String TEXT_7 = "(";
  protected final String TEXT_8 = ")";
  protected final String TEXT_9 = NL + "                    ";
  protected final String TEXT_10 = " {";
  protected final String TEXT_11 = NL + "                ";
  protected final String TEXT_12 = NL + "                ";
  protected final String TEXT_13 = NL + "                return ";
  protected final String TEXT_14 = ";" + NL + "            }" + NL + "        }";
  protected final String TEXT_15 = NL + "        public static class ";
  protected final String TEXT_16 = " implements ";
  protected final String TEXT_17 = " {";
  protected final String TEXT_18 = NL + NL + "            private ContextProperties context = null;" + NL + "" + NL + "            public ";
  protected final String TEXT_19 = "(JobConf job) {" + NL + "                this.context = new ContextProperties(job);" + NL + "            }" + NL + "" + NL + "            public ";
  protected final String TEXT_20 = " ";
  protected final String TEXT_21 = "(";
  protected final String TEXT_22 = ") ";
  protected final String TEXT_23 = " {";
  protected final String TEXT_24 = NL + "                ";
  protected final String TEXT_25 = NL + "                     return ";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = NL + "            }" + NL + "        }";
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = NL + "            // No sparkcode generated for unnecessary ";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL + "            public static class ";
  protected final String TEXT_32 = "TrueFilter implements org.apache.spark.api.java.function.Function<scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase>, Boolean> {" + NL + "" + NL + "                public Boolean call(scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> arg0)" + NL + "                        throws Exception {" + NL + "                    return arg0._1;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public static class ";
  protected final String TEXT_33 = "FalseFilter implements org.apache.spark.api.java.function.Function<scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase>, Boolean> {" + NL + "" + NL + "                public Boolean call(scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> arg0)" + NL + "                        throws Exception {" + NL + "                    return !arg0._1;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public static class ";
  protected final String TEXT_34 = "ToNullWritableMain implements ";
  protected final String TEXT_35 = " {" + NL + "" + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_36 = "ToNullWritableMain(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_37 = " call(" + NL + "                        scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> data){";
  protected final String TEXT_38 = NL + "                    ";
  protected final String TEXT_39 = " ";
  protected final String TEXT_40 = " = (";
  protected final String TEXT_41 = ")data._2;" + NL + "                    return ";
  protected final String TEXT_42 = ";" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public static class ";
  protected final String TEXT_43 = "ToNullWritableReject implements ";
  protected final String TEXT_44 = " {" + NL + "" + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_45 = "ToNullWritableReject(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_46 = " call(" + NL + "                        scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> data){";
  protected final String TEXT_47 = NL + "                        ";
  protected final String TEXT_48 = " ";
  protected final String TEXT_49 = " = (";
  protected final String TEXT_50 = ")data._2;" + NL + "                    return ";
  protected final String TEXT_51 = ";" + NL + "                }" + NL + "            }";
  protected final String TEXT_52 = NL + "            // No sparkconfig generated for unnecessary ";
  protected final String TEXT_53 = NL;
  protected final String TEXT_54 = NL + "            // Extract data." + NL + "            org.apache.spark.api.java.JavaPairRDD<Boolean, org.apache.avro.specific.SpecificRecordBase> temporary_rdd_";
  protected final String TEXT_55 = " = rdd_";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = "(new ";
  protected final String TEXT_58 = "(job));" + NL + "" + NL + "            // Main flow" + NL;
  protected final String TEXT_59 = NL + "            ";
  protected final String TEXT_60 = " rdd_";
  protected final String TEXT_61 = " = temporary_rdd_";
  protected final String TEXT_62 = NL + "                  .filter(new ";
  protected final String TEXT_63 = "TrueFilter())" + NL + "                    .";
  protected final String TEXT_64 = "(new ";
  protected final String TEXT_65 = "ToNullWritableMain(job));" + NL + "" + NL + "            // Reject flow";
  protected final String TEXT_66 = NL + "            ";
  protected final String TEXT_67 = " rdd_";
  protected final String TEXT_68 = " = temporary_rdd_";
  protected final String TEXT_69 = NL + "                    .filter(new ";
  protected final String TEXT_70 = "FalseFilter())" + NL + "                    .";
  protected final String TEXT_71 = "(new ";
  protected final String TEXT_72 = "ToNullWritableReject(job));";
  protected final String TEXT_73 = NL + "            ";
  protected final String TEXT_74 = " rdd_";
  protected final String TEXT_75 = " = rdd_";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = "(new ";
  protected final String TEXT_78 = "(job));";
  protected final String TEXT_79 = NL + "        org.apache.avro.generic.GenericRecord record = (org.apache.avro.generic.GenericRecord) ";
  protected final String TEXT_80 = ".get();" + NL + "        Object columnObject = null;" + NL + "        try {";
  protected final String TEXT_81 = NL + "                columnObject = record.get(\"";
  protected final String TEXT_82 = "\");" + NL + "                if(columnObject != null) {";
  protected final String TEXT_83 = NL + "                        ";
  protected final String TEXT_84 = NL + "                        ";
  protected final String TEXT_85 = NL + "                        ";
  protected final String TEXT_86 = NL + "                        ";
  protected final String TEXT_87 = NL + "                        ";
  protected final String TEXT_88 = NL + "                        ";
  protected final String TEXT_89 = NL + "                        ";
  protected final String TEXT_90 = NL + "                        ";
  protected final String TEXT_91 = NL + "                }";
  protected final String TEXT_92 = NL + "                    else {";
  protected final String TEXT_93 = NL + "                        ";
  protected final String TEXT_94 = NL + "                    }";
  protected final String TEXT_95 = NL + "                ";
  protected final String TEXT_96 = NL + "        } catch (java.lang.Exception ex) {";
  protected final String TEXT_97 = NL + "        }";
  protected final String TEXT_98 = NL + "        ";
  protected final String TEXT_99 = NL;
  protected final String TEXT_100 = NL + "            ";
  protected final String TEXT_101 = NL + "            // Die immediately on errors." + NL + "            throw new IOException(";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "                // Ignore errors processing this row and move to the next.";
  protected final String TEXT_104 = NL + "                // Send error rows to the reject output.";
  protected final String TEXT_105 = NL + "                ";
  protected final String TEXT_106 = NL + "                    ";
  protected final String TEXT_107 = NL + "                ";
  protected final String TEXT_108 = NL + NL + "    org.apache.spark.streaming.api.java.JavaPairDStream<NullWritable, ";
  protected final String TEXT_109 = "> rdd_";
  protected final String TEXT_110 = ";" + NL + "    // Set up a Spark DataFlow with all of the necessary inputs to use" + NL + "    // this component." + NL + "    org.talend.bigdata.dataflow.spark.streaming.SparkStreamingDataFlowContext ";
  protected final String TEXT_111 = "_sdfContext =" + NL + "            new org.talend.bigdata.dataflow.spark.streaming.SparkStreamingDataFlowContext.Builder().withStreamingContext(ctx).build();" + NL + "    org.talend.bigdata.dataflow.spark.streaming.SparkStreamingDataFlow ";
  protected final String TEXT_112 = "_sdf =" + NL + "            new org.talend.bigdata.dataflow.spark.streaming.SparkStreamingDataFlow(";
  protected final String TEXT_113 = "_sdfContext);" + NL;
  protected final String TEXT_114 = NL + "    ";
  protected final String TEXT_115 = "_sdf.putPairDStream(\"";
  protected final String TEXT_116 = "\", rdd_";
  protected final String TEXT_117 = ".mapToPair(new ExtractGenericRecord_";
  protected final String TEXT_118 = "()));" + NL + "" + NL + "    org.talend.bigdata.dataflow.hmap.HMap ";
  protected final String TEXT_119 = "_hmap = new org.talend.bigdata.dataflow.hmap.HMap();" + NL + "    org.talend.bigdata.dataflow.hmap.HMapSpecBuilder ";
  protected final String TEXT_120 = "_hsb = ";
  protected final String TEXT_121 = "_hmap.createSpecBuilder();" + NL + NL;
  protected final String TEXT_122 = NL + "    ";
  protected final String TEXT_123 = "_hsb.declareInput(\"";
  protected final String TEXT_124 = "\", new org.apache.avro.Schema.Parser().parse(new java.io.File(";
  protected final String TEXT_125 = ")));";
  protected final String TEXT_126 = NL + "    ";
  protected final String TEXT_127 = "_hsb.declareOutput(\"";
  protected final String TEXT_128 = "\", ";
  protected final String TEXT_129 = ".getClassSchema()," + NL + "                            org.talend.bigdata.dataflow.hmap.HMapSpec.OutputType.FLATTEN);" + NL + "" + NL + "    // map each field";
  protected final String TEXT_130 = NL + "        ";
  protected final String TEXT_131 = "_hsb.map(\"";
  protected final String TEXT_132 = "\" + \".\" + ";
  protected final String TEXT_133 = ", \"";
  protected final String TEXT_134 = "\" + \".\" + \"";
  protected final String TEXT_135 = "\");";
  protected final String TEXT_136 = NL + NL + "    // Build the tMap spec and use that to build into the dataflow." + NL + "    org.talend.bigdata.dataflow.hmap.HMapSpec ";
  protected final String TEXT_137 = "_hs = ";
  protected final String TEXT_138 = "_hsb.build();";
  protected final String TEXT_139 = NL + "    ";
  protected final String TEXT_140 = "_hmap.createDataFlowBuilder(";
  protected final String TEXT_141 = "_hs).build(";
  protected final String TEXT_142 = "_sdf);" + NL + "" + NL + "    rdd_";
  protected final String TEXT_143 = " = ";
  protected final String TEXT_144 = "_sdf.getPairDStream(\"";
  protected final String TEXT_145 = "\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final IBigDataNode bigDataNode = (IBigDataNode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    
/**
 * Code generated for component with single output
 */
class SOUserSpecifiedFunctionGenerator extends org.talend.designer.spark.generator.FunctionGenerator{

    SOUserSpecifiedFunctionGenerator(org.talend.designer.common.TransformerBase transformer) {
        super(transformer);
    }

    SOUserSpecifiedFunctionGenerator(org.talend.designer.common.TransformerBase transformer, org.talend.designer.spark.generator.SparkFunction sparkFunction) {
        super(transformer, sparkFunction);
    }

    @Override
    public void generate() {
        
    stringBuffer.append(TEXT_1);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_2);
    stringBuffer.append(this.sparkFunction.getCodeFunctionImplementation(getOutValueClass(),
                codeGenArgument.getRecordStructName(getInValue())));
    stringBuffer.append(TEXT_3);
    
            this.transformer.generateHelperClasses(true);
            this.transformer.generateTransformContextDeclaration();
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturnedType(this.outValueClass.toString()));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(this.sparkFunction.getCodeImplementedMethod());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(this.sparkFunction.getCodeFunctionArgument(codeGenArgument.getRecordStructName(getInValue().toString())));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(this.sparkFunction.getCodeThrowException());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(this.sparkFunction.getMethodHeader(this.outValueClass, this.outValue,
                            codeGenArgument.getRecordStructName(getInValue()), this.inValue));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(this.sparkFunction.getCodeKeyMapping(getInValue()));
    
                this.transformer.generateTransformContextInitialization();
                this.transformer.generateTransform(true);
                
    stringBuffer.append(TEXT_13);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturn(this.getOutValue(), this.getOutValueClass()));
    stringBuffer.append(TEXT_14);
    
    }
}

/**
 * Code generated for component with multiple outputs
  */
class MOUserSpecifiedFunctionGenerator extends org.talend.designer.spark.generator.FunctionGenerator{

    /** The single connection to pass along the output chain of Mappers
     *  instead of sending to a dedicated collector via MultipleOutputs. */
    String connectionToChain = null;

    MOUserSpecifiedFunctionGenerator(org.talend.designer.common.TransformerBase transformer) {
        super(transformer);
        defaultOutKeyClass = "Boolean";
    }

    MOUserSpecifiedFunctionGenerator(org.talend.designer.common.TransformerBase transformer, org.talend.designer.spark.generator.SparkFunction sparkFunction) {
        super(transformer, sparkFunction);
        defaultOutKeyClass = "Boolean";
    }

    @Override
    public void generate() {
        
    stringBuffer.append(TEXT_15);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(this.sparkFunction.getCodeFunctionImplementationOutputFixedType(codeGenArgument.getRecordStructName(getInValue().toString()), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_17);
    
            this.transformer.generateHelperClasses(true);
            this.transformer.generateTransformContextDeclaration();
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturnedTypeFixedType((String)this.outKeyClass, "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(this.sparkFunction.getCodeImplementedMethod());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(this.sparkFunction.getCodeFunctionArgument(codeGenArgument.getRecordStructName(getInValue().toString())));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(this.sparkFunction.getCodeThrowException());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(this.sparkFunction.getMethodHeader(this.outValueClass, this.outValue,
                        codeGenArgument.getRecordStructName(getInValue()), this.inValue));
    
                this.transformer.generateTransformContextInitialization();
                this.transformer.generateTransform(true);
                if(this.sparkFunction.getCodeFunctionReturn()!=null) {
                    
    stringBuffer.append(TEXT_25);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturn());
    stringBuffer.append(TEXT_26);
    
                }
                
    stringBuffer.append(TEXT_27);
    
    }
}

    stringBuffer.append(TEXT_28);
    

/**
 * A common, reusable utility that generates code in the context of a spark
 * component, for reading and writing to a spark RDD.
 * This implementation do not use the avro schema, and will use '"InConnName" + Struct' as a structure
 */
class SparkUserSpecifiedRowTransformUtil extends org.talend.designer.common.CommonRowTransformUtil {

    private boolean isMultiOutput = false;

    private org.talend.designer.spark.generator.SparkFunction sparkFunction = null;


    private org.talend.designer.spark.generator.FunctionGenerator functionGenerator = null;

    public SparkUserSpecifiedRowTransformUtil() {

    }

    public SparkUserSpecifiedRowTransformUtil(org.talend.designer.spark.generator.SparkFunction sparkFunction) {
        this.sparkFunction = sparkFunction;
    }

    public void setMultiOutput(boolean multiOutput) {
        isMultiOutput = multiOutput;
    }

    public String getCodeToGetInField(String columnName) {
        return functionGenerator.getInValue() + "." + columnName;
    }

    public String getInValue() {
        return functionGenerator.getInValue();
    }

    public String getOutValue() {
        return functionGenerator.getOutValue();
    }

    public String getInValueClass() {
        return functionGenerator.getInValueClass();
    }

    public String getOutValueClass() {
        return functionGenerator.getOutValueClass();
    }

    public String getCodeToGetOutField(boolean isReject, String columnName) {
        return functionGenerator.getOutValue(isReject ? "reject" : "main") + "." + columnName;
    }

    public String getCodeToInitOut(boolean isReject, Iterable<IMetadataColumn> columns) {
        if(this.sparkFunction!=null && !isMultiOutput) {
            return this.sparkFunction.getCodeToInitOut(functionGenerator.getOutValue(isReject ? "reject" : "main"), functionGenerator.getOutValueClass(isReject ? "reject" : "main"));
        } else {
            return "";
        }
    }

    public String getCodeToSetOutField(boolean isReject, String columnName, String codeValue) {
        return functionGenerator.getOutValue(isReject ? "reject" : "main") + "." + columnName + " = " + codeValue + ";";
    }

    public String getCodeToSetOutField(boolean isReject, String columnName, String codeValue, String operator) {
        return functionGenerator.getOutValue(isReject ? "reject" : "main") + "." + columnName + " " + operator + " " + codeValue + ";";
    }

    public String getCodeToEmit(boolean isReject) {
        if (this.sparkFunction!=null && isMultiOutput) {
            if (isReject) {
                return this.sparkFunction.getCodeToEmit(false, functionGenerator.getOutValue("reject"),
                        codeGenArgument.getRecordStructName(functionGenerator.getOutValue("reject")));
            } else {
                return this.sparkFunction.getCodeToEmit(true, functionGenerator.getOutValue("main"),
                        codeGenArgument.getRecordStructName(functionGenerator.getOutValue("main")));
            }
        } else {
            return "";
        }
    }

    public void generateSparkCode(final org.talend.designer.common.TransformerBase transformer, final org.talend.designer.spark.generator.SparkFunction sparkFunction) {
        if (transformer.isMultiOutput()) {
            setMultiOutput(true);
        }
        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
            return;
        }

        if (transformer.isMultiOutput()) {
            org.talend.designer.spark.generator.SparkFunction localSparkFunction = null;
            if ((sparkFunction instanceof org.talend.designer.spark.generator.FlatMapFunction)
                    || (sparkFunction instanceof org.talend.designer.spark.generator.FlatMapToPairFunction)) {
                localSparkFunction = new org.talend.designer.spark.generator.FlatMapToPairFunction(sparkFunction.isInputPair(), sparkFunction.getKeyList());
            } else {
                localSparkFunction = new org.talend.designer.spark.generator.MapToPairFunction(sparkFunction.isInputPair(), sparkFunction.getKeyList());
            }

            org.talend.designer.spark.generator.SparkFunction extractSparkFunction = null;
            if ((sparkFunction instanceof org.talend.designer.spark.generator.FlatMapFunction)
                    || (sparkFunction instanceof org.talend.designer.spark.generator.MapFunction)) {
                extractSparkFunction = new org.talend.designer.spark.generator.MapFunction(sparkFunction.isInputPair(), sparkFunction.getKeyList());
            } else {
                extractSparkFunction = new org.talend.designer.spark.generator.MapToPairFunction(sparkFunction.isInputPair(), sparkFunction.getKeyList());
            }
            this.sparkFunction = localSparkFunction;

            // The multi-output condition is slightly different, and the
            // MapperHelper is configured with internal names for the
            // connections.
            java.util.HashMap<String, String> names = new java.util.HashMap<String, String>();
            names.put("main", transformer.getOutConnMainName());
            names.put("reject", transformer.getOutConnRejectName());

            // Refactoring FunctionGenerator to java so we have to instaniate a MO or SO here
            functionGenerator = new MOUserSpecifiedFunctionGenerator(transformer, localSparkFunction);
            functionGenerator.init(node, cid, null, transformer.getInConnName(), null, names);

            
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(extractSparkFunction.getCodeFunctionImplementationInputFixedType(transformer.getOutConnMainTypeName(), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturnedType(transformer.getOutConnMainTypeName()));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(transformer.getOutConnMainTypeName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(transformer.getOutConnMainTypeName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturn(transformer.getOutConnMainName(), transformer.getOutConnMainTypeName()));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(extractSparkFunction.getCodeFunctionImplementationInputFixedType(transformer.getOutConnRejectTypeName(), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturnedType(transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(transformer.getOutConnRejectTypeName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(transformer.getOutConnRejectName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(transformer.getOutConnRejectTypeName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturn(transformer.getOutConnRejectName(), transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_51);
    
        } else {
            // Refactoring FunctionGenerator to java so we have to instaniate a MO or SO here
            functionGenerator = new SOUserSpecifiedFunctionGenerator(transformer, sparkFunction);

            functionGenerator.init(node, cid, null, transformer.getInConnName(), null,
                    transformer.getOutConnMainName() != null
                        ? transformer.getOutConnMainName()
                                : transformer.getOutConnRejectName());
        }
        functionGenerator.generate();
    }

    public void generateSparkConfig(final org.talend.designer.common.TransformerBase transformer, final org.talend.designer.spark.generator.SparkFunction sparkFunction) {
        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
            return;
        }

        if (transformer.isMultiOutput()) {
            String localFunctionType = "mapToPair";
            if ((sparkFunction instanceof org.talend.designer.spark.generator.FlatMapFunction)
                    || (sparkFunction instanceof org.talend.designer.spark.generator.FlatMapToPairFunction)) {
                localFunctionType = "flatMapToPair";
            }

            String extractFunctionType = "mapToPair";
            if ((sparkFunction instanceof org.talend.designer.spark.generator.FlatMapFunction)
                    || (sparkFunction instanceof org.talend.designer.spark.generator.MapFunction)) {
                extractFunctionType = "map";
            }
												
    stringBuffer.append(TEXT_54);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(transformer.getInConnName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(localFunctionType);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(sparkFunction.getConfigReturnedType(transformer.getOutConnMainTypeName()));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(extractFunctionType);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(sparkFunction.getConfigReturnedType(transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(transformer.getOutConnRejectName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(extractFunctionType);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
        } else {
            functionGenerator = new SOUserSpecifiedFunctionGenerator(transformer, sparkFunction);

            functionGenerator.init(node, cid, null, transformer.getInConnName(), null,
                    transformer.getOutConnMainName() != null
                        ? transformer.getOutConnMainName()
                                : transformer.getOutConnRejectName());
            
    stringBuffer.append(TEXT_73);
    stringBuffer.append(sparkFunction.getConfigReturnedType(transformer.getOutConnMainTypeName()));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(transformer.getInConnName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(sparkFunction.getConfigTransformation());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_78);
    
        }
    }
}


    

/**
 * Contains common processing for tExtractAvroFields code generation.  This is
 * used in MapReduce and Storm components.
 *
 * The following imports must occur before importing this file:
 * @ include file="@{org.talend.designer.components.mrprovider}/resources/utils/common_codegen_util.javajet"
 */
class TExtractAvroFieldsUtil extends org.talend.designer.common.TransformerBase {

    // TODO: what happens when these are input column names?
    final private static String REJECT_MSG = "errorMessage";
    final private static String REJECT_CODE = "errorCode";
    final private static String REJECT_FIELD = "inputLine";

    final private String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    final private boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    /** The outgoing connection contains the column {@link #REJECT_FIELD}.
     *  If we import a job from a DI job, this column will be missing */
    final private Boolean containsRejectField;

    /** The list of columns that should be copied directly from the input to
     *  the output schema (where they have the same column names). */
    final private java.util.List<IMetadataColumn> copiedInColumns;

    /** Columns in the output schema that are not copied directly from the
     *  input schema (excluding reject fields). */
    final private java.util.List<IMetadataColumn> newOutColumns;


    public TExtractAvroFieldsUtil(INode node,
            org.talend.designer.common.BigDataCodeGeneratorArgument argument,
            org.talend.designer.common.CommonRowTransformUtil rowTransformUtil) {
        super(node, argument, rowTransformUtil, "FLOW", "REJECT");

        containsRejectField = hasOutputColumn(true, REJECT_FIELD);

        if (null != getInConn() && null != getOutConnMain()) {
            copiedInColumns = org.talend.designer.common.TransformerBaseUtil.getColumnsUnion(getInColumns(), getOutColumnsMain());
            newOutColumns = org.talend.designer.common.TransformerBaseUtil.getColumnsDiff(getOutColumnsMain(), getInColumns());
        } else if (null != getInConn() && null != getOutConnReject()) {
            copiedInColumns = org.talend.designer.common.TransformerBaseUtil.getColumnsUnion(getInColumns(), getOutColumnsReject());
            // If only the reject output is used, the new columns are those that
            // are not part of the main schema (ignore the REJECT_XXX columns).
            java.util.List<IMetadataColumn> mainCols = org.talend.designer.common.TransformerBaseUtil.getColumnsDiff(
                    getOutColumnsReject(), org.talend.designer.common.TransformerBaseUtil.getColumns(getOutColumnsReject(),
                            REJECT_FIELD, REJECT_CODE, REJECT_MSG));
            newOutColumns = org.talend.designer.common.TransformerBaseUtil.getColumnsDiff(mainCols, getInColumns());
        } else {
            copiedInColumns = null;
            newOutColumns = null;
        }

    }

    public void generateTransformContextDeclaration() {
    }

    public void generateTransformContextInitialization() {
    }


    public void generateTransform() {
        generateTransform(false);
    }

    /**
     * Generates code that performs the tranformation from one JSON input string
     * to many output strings, or to a reject flow.
     */
    public void generateTransform(boolean hasAReturnedType) {
        
    stringBuffer.append(TEXT_79);
    stringBuffer.append(getInConn().getName());
    stringBuffer.append(TEXT_80);
    
            Iterable<IMetadataColumn> outColumns = getOutColumnsMain();
            if (outColumns == null)
                outColumns = getOutColumnsReject();
            for (IMetadataColumn column : outColumns) {
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                String objectTypeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), true);
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
                
    stringBuffer.append(TEXT_81);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_82);
    if(javaType == JavaTypesManager.STRING) {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "columnObject.toString()"));
    } else if(javaType == JavaTypesManager.BYTE) {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "((Integer)columnObject).byteValue()"));
    } else if(javaType == JavaTypesManager.SHORT) {
    stringBuffer.append(TEXT_85);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "((Integer)columnObject).shortValue()"));
    } else if(javaType == JavaTypesManager.CHARACTER) {
    stringBuffer.append(TEXT_86);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "(Character)(char)(int)(Integer)columnObject"));
    } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
    stringBuffer.append(TEXT_87);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "((java.nio.ByteBuffer)columnObject).array()"));
    } else if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_88);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "new java.math.BigDecimal(columnObject.toString())"));
    } else if(javaType == JavaTypesManager.DATE) {
    stringBuffer.append(TEXT_89);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "new java.util.Date((Long)columnObject)"));
    } else {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "(" + objectTypeToGenerate + ")columnObject"));
    }
    stringBuffer.append(TEXT_91);
    if(defaultValue!=null && defaultValue.length()>0){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, defaultValue));
    stringBuffer.append(TEXT_94);
    }
    
            }

            if (null != getOutConnMain()) {
                
    stringBuffer.append(TEXT_95);
    stringBuffer.append(getRowTransform().getCodeToEmit(false));
    
            }
            
    stringBuffer.append(TEXT_96);
    
            generateTransformReject(dieOnError, "ex", null, "originalJsonStr_"+cid);
            
    stringBuffer.append(TEXT_97);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(getRowTransform().getCodeToInitOut(null == getOutConnMain(), newOutColumns));
    stringBuffer.append(TEXT_99);
    
    }

    /**
     * Generates code in the transform context to create reject output.
     *
     * @param die if this reject output should kill the job.  Normally, this is
     *    tied to a dieOnError parameter for the component, but can be
     *    explicitly set to false for non-fatal reject output.
     * @param codeException a variable in the transform scope that contains the
     *    variable with an exception.  If null, this will be constructed from
     *    the codeRejectMsg.
     * @param codeRejectMsg the error message to output with the reject output.
     */
    private void generateTransformReject(boolean die, String codeException, String codeRejectMsg, String codeRejectField) {
        if (codeRejectMsg == null) {
            codeRejectMsg = "\"" + cid + " - \" + " + codeException
                    + ".getMessage()";
            // Note: in DI, the error message can have the line number  appended
            // to it: " - Line: " + tos_count_nodeUniqueName()
        }

        if (codeException == null) {
            codeException = codeRejectMsg;
        }

        // If there are multiple outputs, then copy all of the new columns from
        // the original output to the error output.
        if (isMultiOutput()) {
            
    stringBuffer.append(TEXT_100);
    stringBuffer.append(getRowTransform().getCodeToCopyOutMainToReject(newOutColumns));
    
        }

        if (die) {
            
    stringBuffer.append(TEXT_101);
    stringBuffer.append(codeException);
    stringBuffer.append(TEXT_102);
    
        } else {
            if (null == getOutConnReject()) {
                
    stringBuffer.append(TEXT_103);
    
                generateLogMessage(codeRejectMsg);
            } else {
                
    stringBuffer.append(TEXT_104);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_MSG,
                        codeRejectMsg) );
    
                if (containsRejectField) {
                    
    stringBuffer.append(TEXT_106);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_FIELD,
                            getInConnName() + ".get().toString()") );
    
                }
                
    stringBuffer.append(TEXT_107);
    stringBuffer.append(getRowTransform().getCodeToEmit(true));
    
            }
        }
    }
}

    

org.talend.designer.spark.generator.SparkFunction sparkFunction = null;
String requiredInputType = bigDataNode.getRequiredInputType();
String requiredOutputType = bigDataNode.getRequiredOutputType();
String incomingType = bigDataNode.getIncomingType();
String outgoingType = bigDataNode.getOutgoingType();
String incomingName = bigDataNode.getIncomingConnections().get(0).getName();
String outgoingName = bigDataNode.getOutgoingConnections().get(0).getName();
String outgoingConnectionTypeName = codeGenArgument.getRecordStructName(bigDataNode.getOutgoingConnections().get(0));
boolean inputIsPair = requiredInputType != null ? "KEYVALUE".equals(requiredInputType) : "KEYVALUE".equals(incomingType);

String type = requiredOutputType == null ? outgoingType : requiredOutputType;
if("KEYVALUE".equals(type)) {
    sparkFunction = new org.talend.designer.spark.generator.MapToPairFunction(inputIsPair);
} else if("VALUE".equals(type)) {
    sparkFunction = new org.talend.designer.spark.generator.MapFunction(inputIsPair);
}

boolean isNodeInBatchMode = org.talend.designer.common.tmap.LookupUtil.isNodeInBatchMode(node);
if("SPARKSTREAMING".equals(node.getComponent().getType()) && !isNodeInBatchMode) {
    sparkFunction.setStreaming(true);
}

boolean useHierarchical = "true".equals(ElementParameterParser.getValue(node, "__USE_HIERARCHICAL__"));
String schemaFileName = ElementParameterParser.getValue(node, "__SCHEMA_FILENAME__");

if (!useHierarchical) {
    final SparkUserSpecifiedRowTransformUtil sparkTransformUtil = new SparkUserSpecifiedRowTransformUtil(sparkFunction);
    final TExtractAvroFieldsUtil tExtractAvroFieldsUtil = new TExtractAvroFieldsUtil(node, codeGenArgument, sparkTransformUtil);
    sparkTransformUtil.generateSparkConfig(tExtractAvroFieldsUtil, sparkFunction);
} else {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(outgoingConnectionTypeName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(outgoingName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(incomingName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(incomingName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(incomingName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(schemaFileName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(outgoingName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(outgoingConnectionTypeName);
    stringBuffer.append(TEXT_129);
    
    List<Map<String, String>> mappings = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
    for (Map<String, String> mapping: mappings) {

        String outputColumnName = mapping.get("SCHEMA_COLUMN");
        String nodePath = mapping.get("NODE_PATH");

        if ((nodePath == null) || ("".equals(nodePath)) || ("\"\"".equals(nodePath))) {
            nodePath = "\"" + outputColumnName + "\"";
        }
        
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(incomingName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(nodePath);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(outgoingName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(outputColumnName);
    stringBuffer.append(TEXT_135);
    
    }
    
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(outgoingName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(outgoingName);
    stringBuffer.append(TEXT_145);
    
}

    return stringBuffer.toString();
  }
}
