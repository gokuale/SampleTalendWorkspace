package org.talend.designer.codegen.translators.processing;

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
import org.talend.core.model.utils.NodeUtil;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TConvertTypeSparkconfigJava
{
  protected static String nl;
  public static synchronized TConvertTypeSparkconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TConvertTypeSparkconfigJava result = new TConvertTypeSparkconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            public static class ";
  protected final String TEXT_2 = " implements ";
  protected final String TEXT_3 = " {";
  protected final String TEXT_4 = NL + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_5 = "(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "\t            public ";
  protected final String TEXT_6 = " ";
  protected final String TEXT_7 = "(";
  protected final String TEXT_8 = ") ";
  protected final String TEXT_9 = " {" + NL + "\t            \t";
  protected final String TEXT_10 = NL + "\t            \t";
  protected final String TEXT_11 = NL + "\t                ";
  protected final String TEXT_12 = NL + "\t                return ";
  protected final String TEXT_13 = ";" + NL + "\t            }" + NL + "\t        }" + NL + "\t\t";
  protected final String TEXT_14 = NL + "            public static class ";
  protected final String TEXT_15 = " implements ";
  protected final String TEXT_16 = " {";
  protected final String TEXT_17 = NL + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_18 = "(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_19 = " ";
  protected final String TEXT_20 = "(";
  protected final String TEXT_21 = ") ";
  protected final String TEXT_22 = " {" + NL + "                \t";
  protected final String TEXT_23 = NL + "\t                 \treturn ";
  protected final String TEXT_24 = ";";
  protected final String TEXT_25 = NL + "                }" + NL + "            }";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "            // No sparkcode generated for unnecessary ";
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = NL + "            public static class ";
  protected final String TEXT_30 = "TrueFilter implements org.apache.spark.api.java.function.Function<scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase>, Boolean> {" + NL + "" + NL + "                public Boolean call(scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> arg0)" + NL + "                        throws Exception {" + NL + "                    return arg0._1;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public static class ";
  protected final String TEXT_31 = "FalseFilter implements org.apache.spark.api.java.function.Function<scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase>, Boolean> {" + NL + "" + NL + "                public Boolean call(scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> arg0)" + NL + "                        throws Exception {" + NL + "                    return !arg0._1;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public static class ";
  protected final String TEXT_32 = "ToNullWritableMain implements ";
  protected final String TEXT_33 = " {" + NL + "" + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_34 = "ToNullWritableMain(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_35 = " call(" + NL + "                        scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> data){";
  protected final String TEXT_36 = NL + "                    ";
  protected final String TEXT_37 = " ";
  protected final String TEXT_38 = " = (";
  protected final String TEXT_39 = ")data._2; " + NL + "                    return ";
  protected final String TEXT_40 = ";" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public static class ";
  protected final String TEXT_41 = "ToNullWritableReject implements ";
  protected final String TEXT_42 = " {" + NL + "" + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_43 = "ToNullWritableReject(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_44 = " call(" + NL + "                        scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> data){";
  protected final String TEXT_45 = NL + "                        ";
  protected final String TEXT_46 = " ";
  protected final String TEXT_47 = " = (";
  protected final String TEXT_48 = ")data._2; " + NL + "                    return ";
  protected final String TEXT_49 = ";" + NL + "                }" + NL + "            }";
  protected final String TEXT_50 = NL + "            // No sparkconfig generated for unnecessary ";
  protected final String TEXT_51 = NL;
  protected final String TEXT_52 = NL + "            // Extract data." + NL + "            ";
  protected final String TEXT_53 = NL + "            ";
  protected final String TEXT_54 = "<Boolean, org.apache.avro.specific.SpecificRecordBase> temporary_rdd_";
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
  protected final String TEXT_79 = NL + NL + "        boolean rowHasConversionError = false;" + NL + "        Exception rowException = null;" + NL;
  protected final String TEXT_80 = NL + "                            try{";
  protected final String TEXT_81 = NL + "                                ";
  protected final String TEXT_82 = NL + "                                ";
  protected final String TEXT_83 = NL + "                            }catch(java.lang.Exception e){" + NL + "                                rowHasConversionError = true;" + NL + "                                rowException = e;" + NL + "                            }";
  protected final String TEXT_84 = NL + "                if(rowHasConversionError){";
  protected final String TEXT_85 = NL + "                }else{";
  protected final String TEXT_86 = NL + "                        ";
  protected final String TEXT_87 = NL + "                }";
  protected final String TEXT_88 = NL + "                try{";
  protected final String TEXT_89 = NL + "                    ";
  protected final String TEXT_90 = NL + "                    ";
  protected final String TEXT_91 = NL + "                }catch(java.lang.Exception e){" + NL + "                    rowHasConversionError = true;" + NL + "                    rowException = e;" + NL + "                }";
  protected final String TEXT_92 = NL + "            if(rowHasConversionError){";
  protected final String TEXT_93 = NL + "            }else{";
  protected final String TEXT_94 = NL + "                    ";
  protected final String TEXT_95 = NL + "            }";
  protected final String TEXT_96 = NL + "            // Die immediately on errors." + NL + "            throw new IOException(";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "                // Ignore errors processing this row and move to the next.";
  protected final String TEXT_99 = NL + "                // Send error rows to the reject output.";
  protected final String TEXT_100 = NL + "                ";
  protected final String TEXT_101 = NL + "                    ";
  protected final String TEXT_102 = NL + "                    ";
  protected final String TEXT_103 = NL + "                ";
  protected final String TEXT_104 = NL + "                ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final IBigDataNode bigDataNode = (IBigDataNode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    
	/**
	 * Code generated for component with single output
 	 */
    class SOFunctionGenerator extends org.talend.designer.spark.generator.FunctionGenerator{

    	SOFunctionGenerator(org.talend.designer.common.TransformerBase transformer) {
            super(transformer);
        }

    	SOFunctionGenerator(org.talend.designer.common.TransformerBase transformer, org.talend.designer.spark.generator.SparkFunction sparkFunction) {
    		super(transformer, sparkFunction);
    	}

    	@Override
        public void generate(){
		
    stringBuffer.append(TEXT_1);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_2);
    stringBuffer.append(this.sparkFunction.getCodeFunctionImplementation(getOutValueClass(), getInValueClass()));
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
    stringBuffer.append(this.sparkFunction.getCodeFunctionArgument(getInValueClass()));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(this.sparkFunction.getCodeThrowException());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(this.sparkFunction.getMethodHeader(this.outValueClass, this.outValue, this.inValueClass, this.inValue));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(this.sparkFunction.getCodeKeyMapping(getInValue()));
    stringBuffer.append(TEXT_11);
    
	                this.transformer.generateTransformContextInitialization();
	                this.transformer.generateTransform(true);
	                
    stringBuffer.append(TEXT_12);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturn(this.getOutValue(), this.getOutValueClass()));
    stringBuffer.append(TEXT_13);
    
        }
    }

	/**
	 * Code generated for component with multiple outputs
 	 */
    class MOFunctionGenerator extends org.talend.designer.spark.generator.FunctionGenerator{

        /** The single connection to pass along the output chain of Mappers
         *  instead of sending to a dedicated collector via MultipleOutputs. */
        String connectionToChain = null;
        
        MOFunctionGenerator(org.talend.designer.common.TransformerBase transformer) {
            super(transformer);
            defaultOutKeyClass = "Boolean";
        }

    	MOFunctionGenerator(org.talend.designer.common.TransformerBase transformer, org.talend.designer.spark.generator.SparkFunction sparkFunction) {
    		super(transformer, sparkFunction);
            defaultOutKeyClass = "Boolean";
    	}

    	@Override
        public void generate(){
        
    stringBuffer.append(TEXT_14);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(this.sparkFunction.getCodeFunctionImplementationOutputFixedType(getInValueClass(), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_16);
    
                this.transformer.generateHelperClasses(true);
                this.transformer.generateTransformContextDeclaration();
                
    stringBuffer.append(TEXT_17);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturnedTypeFixedType((String)this.outKeyClass, "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(this.sparkFunction.getCodeImplementedMethod());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(this.sparkFunction.getCodeFunctionArgument(getInValueClass()));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(this.sparkFunction.getCodeThrowException());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(this.sparkFunction.getMethodHeader(this.outValueClass, this.outValue, this.inValueClass, this.inValue));
    
                    this.transformer.generateTransformContextInitialization();
                    this.transformer.generateTransform(true);
	                if(this.sparkFunction.getCodeFunctionReturn()!=null) {
                
    stringBuffer.append(TEXT_23);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturn());
    stringBuffer.append(TEXT_24);
    
	            	}
                
    stringBuffer.append(TEXT_25);
    
        }
    }

    stringBuffer.append(TEXT_26);
    

/**
 * A common, reusable utility that generates code in the context of a spark
 * component, for reading and writing to a spark RDD.
 */
class SparkRowTransformUtil extends org.talend.designer.common.CommonRowTransformUtil {

    private boolean isMultiOutput = false;

    private org.talend.designer.spark.generator.SparkFunction sparkFunction = null;
    

    private org.talend.designer.spark.generator.FunctionGenerator functionGenerator = null;

    public SparkRowTransformUtil() {

    }

    public SparkRowTransformUtil(org.talend.designer.spark.generator.SparkFunction sparkFunction) {
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
        if(!isReject && this.sparkFunction!=null && !isMultiOutput) {
            return this.sparkFunction.getCodeToInitOut(functionGenerator.getOutValue("main"), functionGenerator.getOutValueClass("main"));
        } else {
            return "";
        }
    }

    // Method to avoid using getCodeToInitOut that calls sparkFunction.getCodeToInitOut which creates unnecessary objects
    // Check getCodeToAddToOutput in SparkFunction and its implementation in FlatMapToPairFunction
    public String getCodeToAddToOutput(boolean isReject, Iterable<IMetadataColumn> columns) {
        if(this.sparkFunction!=null && !isMultiOutput) {
            return this.sparkFunction.getCodeToAddToOutput(false, false, functionGenerator.getOutValue(isReject ? "reject" : "main"), functionGenerator.getOutValueClass(isReject ? "reject" : "main"));
        }else if(this.sparkFunction!=null && isMultiOutput){
            if(isReject){
                return this.sparkFunction.getCodeToAddToOutput(true, false, functionGenerator.getOutValue("reject"), functionGenerator.getOutValueClass("reject"));
            }else{
                return this.sparkFunction.getCodeToAddToOutput(true, true, functionGenerator.getOutValue("main"), functionGenerator.getOutValueClass("main"));
            }
        }else {
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
        if (this.sparkFunction != null && isMultiOutput) {
            if (isReject) {
                return this.sparkFunction.getCodeToEmit(false, functionGenerator.getOutValue("reject"), functionGenerator.getOutValueClass("reject"));
            } else {
                return this.sparkFunction.getCodeToEmit(true, functionGenerator.getOutValue("main"), functionGenerator.getOutValueClass("main"));
            }
        } else {
            if (isReject) {
                return this.sparkFunction.getCodeToInitOut(functionGenerator.getOutValue("reject"), functionGenerator.getOutValueClass("reject"));
            } else {
                return "";
            }
        }
    }

    public void generateSparkCode(final org.talend.designer.common.TransformerBase transformer, final org.talend.designer.spark.generator.SparkFunction sparkFunction) {
        if (transformer.isMultiOutput()) {
            setMultiOutput(true);
        }
        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
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
            functionGenerator = new MOFunctionGenerator(transformer, localSparkFunction);
            functionGenerator.init(node, cid, null, transformer.getInConnName(), null, names);

            
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(extractSparkFunction.getCodeFunctionImplementationInputFixedType(transformer.getOutConnMainTypeName(), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturnedType(transformer.getOutConnMainTypeName()));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(transformer.getOutConnMainTypeName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(transformer.getOutConnMainTypeName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturn(transformer.getOutConnMainName(), transformer.getOutConnMainTypeName()));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(extractSparkFunction.getCodeFunctionImplementationInputFixedType(transformer.getOutConnRejectTypeName(), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturnedType(transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(transformer.getOutConnRejectTypeName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(transformer.getOutConnRejectName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(transformer.getOutConnRejectTypeName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturn(transformer.getOutConnRejectName(), transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_49);
    
        } else {
            // Refactoring FunctionGenerator to java so we have to instaniate a MO or SO here
            functionGenerator = new SOFunctionGenerator(transformer, sparkFunction);

            functionGenerator.init(node, cid, null, transformer.getInConnName(), null, 
                    transformer.getOutConnMainName() != null
                        ? transformer.getOutConnMainName()
                                : transformer.getOutConnRejectName());
        }
        functionGenerator.generate();
    }

    public void generateSparkConfig(final org.talend.designer.common.TransformerBase transformer, final org.talend.designer.spark.generator.SparkFunction sparkFunction) {
        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
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
            
    stringBuffer.append(TEXT_52);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(sparkFunction.isStreaming() ?"org.apache.spark.streaming.api.java.JavaPairDStream":"org.apache.spark.api.java.JavaPairRDD");
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
            functionGenerator = new SOFunctionGenerator(transformer, sparkFunction);

            functionGenerator.init(node, cid, null, transformer.getInConnName(), null, 
                    transformer.getOutConnMainName() != null
                        ? transformer.getOutConnMainName()
                                : transformer.getOutConnRejectName());
            
    stringBuffer.append(TEXT_73);
    stringBuffer.append(sparkFunction.getConfigReturnedType(transformer.getOutConnMainName() != null ? transformer.getOutConnMainTypeName() : transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(transformer.getOutConnMainName() != null ? transformer.getOutConnMainName() : transformer.getOutConnRejectName());
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
 * Contains common processing for tConvertTypeUtils code generation. This is
 * used in Spark only for now.
 *
 * The following imports must occur before importing this file:
 * @ include file="@{org.talend.designer.components.mrprovider}/resources/utils/common_codegen_util.javajet"
 */
class TConvertTypeUtil extends org.talend.designer.common.TransformerBase {

        // TODO: what happens when these are input column names?
    final private static String REJECT_MSG = "errorMessage";
    final private static String REJECT_CODE = "errorCode";
    final private static String REJECT_FIELD = "errorField";

    final boolean autoCast = ("true").equals(ElementParameterParser.getValue(node, "__AUTOCAST__"));
    final java.util.List<java.util.Map<String, String>> manualtable = (java.util.List<java.util.Map<String, String>>)ElementParameterParser.getObjectValue(node, "__MANUALTABLE__");
    final boolean bEmptyToNull = "true".equals(ElementParameterParser.getValue(node, "__EMPTYTONULL__"));

    final private boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    /** The outgoing connection contains the column {@link #REJECT_FIELD}.
     *  If we import a job from a DI job, this column will be missing */
    final private Boolean containsRejectField;

    /** Columns in the output schema that do not appear in the input column */
    final private Iterable<IMetadataColumn> newOutColumns;

    /** The list of columns that should be copied directly from the input to
     *  the output schema (where they have the same column names). */
    final private Iterable<IMetadataColumn> copiedInColumns;

    final private boolean validateDatesStrict = false;
    final private boolean validateNumberOfMatchedGroups = false;

    /** TODO: Used in DI, tied to CHECK_NUM */
    private int columnsSize = 0;

    public TConvertTypeUtil(INode node,
            org.talend.designer.common.BigDataCodeGeneratorArgument argument,
            org.talend.designer.common.CommonRowTransformUtil rowTransformUtil) {
        super(node, argument, rowTransformUtil, "FLOW", "REJECT");

        containsRejectField = hasOutputColumn(true, REJECT_FIELD);

        if (null != getInConn() && null != getOutConnMain()) {
            newOutColumns = org.talend.designer.common.TransformerBaseUtil.getColumnsDiff(getOutColumnsMain(), getInColumns());
            columnsSize = getOutConnMain().getMetadataTable().getListColumns().size();
            copiedInColumns = getColumnsUnion(getInColumns(), getOutColumnsMain());
        } else if (null != getInConn() && null != getOutConnReject()) {
            // If only the reject output is used, the new columns are those that
            // are not part of the main schema (ignore the REJECT_XXX columns).
            Iterable<IMetadataColumn> mainCols = org.talend.designer.common.TransformerBaseUtil.getColumnsDiff(
                    getOutColumnsReject(), org.talend.designer.common.TransformerBaseUtil.getColumns(getOutColumnsReject(),
                            REJECT_FIELD, REJECT_CODE, REJECT_MSG));
            newOutColumns = org.talend.designer.common.TransformerBaseUtil.getColumnsDiff(mainCols, getInColumns());
            copiedInColumns = getColumnsUnion(getInColumns(), getOutColumnsReject());
            columnsSize = getOutConnReject().getMetadataTable().getListColumns().size() - 3;
        } else {
            newOutColumns = null;
            copiedInColumns = null;
        }
    }

    public void generateTransformContextDeclaration() {
        // Nothing here
    }

    /**
     * Generates code that performs the tranformation from one input string
     * to many output strings, or to a reject flow.
     */
    public void generateTransform() {
        generateTransform(false);
    }


    /**
     * Generates code that performs the conversion.
     *
     */
    public String generateConversionCode(String preLabel, String outLabel, String inType, String outType, String outPattern, String inPattern){

        String output="";

        if ("Date".equals(outType) && "String".equals(inType)) {
            output = getRowTransform().getCodeToSetOutField(outLabel,"TypeConvert." + inType +"2" + outType + "(" + getRowTransform().getCodeToGetInField(preLabel) +", "+ outPattern +")");
        }else if("String".equals(outType) && "Date".equals(inType)){
            output = getRowTransform().getCodeToSetOutField(outLabel,"TypeConvert." + inType +"2" + outType + "(" + getRowTransform().getCodeToGetInField(preLabel) +", "+ inPattern +")");
        }else if("Document".equals(outType) && "String".equals(inType)){
            output = getRowTransform().getCodeToSetOutField(outLabel,"BigDataParserUtils.parseTo_Document(" + getRowTransform().getCodeToGetInField(preLabel) +")");
        }else if("String".equals(outType) && "Document".equals(inType)){
            output = getRowTransform().getCodeToSetOutField(outLabel, getRowTransform().getCodeToGetInField(preLabel) + ".toString()");
        // Special processing when output type is ByteArray. We wrap the byte array with ByteBuffer for avro compatibilty
        }else if("byteArray".equals(outType)){
            output = getRowTransform().getCodeToSetOutField(outLabel,"java.nio.ByteBuffer.wrap(" + "TypeConvert." + inType +"2" + outType + "(" + getRowTransform().getCodeToGetInField(preLabel) +")" + ")");
        // Special processing when input type is ByteArray. We extract the byte array from ByteBuffer for avro compatibilty
        }else if("byteArray".equals(inType)){
            String iba = "intermediateByteArray_"+preLabel;
            output = getRowTransform().getCodeToGetInField(preLabel)+".clear();\n" + "byte[] " + iba + " =new byte["+getRowTransform().getCodeToGetInField(preLabel)+".capacity()];\n" + getRowTransform().getCodeToGetInField(preLabel) + ".get(" + iba + ", 0," + iba + ".length);\n" + getRowTransform().getCodeToGetOutField(false, outLabel) + " = TypeConvert." + inType + "2" + outType + "(" + iba + ");";
        // No conversion if input type equals output type
        }else if((inType.equals(outType))&&(!("byteArray".equals(outType)))&&(!("byteArray".equals(inType)))){
            output = getRowTransform().getCodeToSetOutField(outLabel,getRowTransform().getCodeToGetInField(preLabel));
        }else{
            output = getRowTransform().getCodeToSetOutField(outLabel, "TypeConvert." + inType +"2" + outType + "(" + getRowTransform().getCodeToGetInField(preLabel) +")");
        }
        return output;
    }

    /**
     * Check for empty values and replace with null if the option is chosen.
     */
    public String generateNullReplacement(boolean emptyToNull, String preLabel, String outLabel, String inType, String outType){

        if (emptyToNull && ("String".equals(inType) || "Object".equals(inType))) {
            return "if (\"\".equals(" + getRowTransform().getCodeToGetInField(preLabel) + ")){\n" + getRowTransform().getCodeToGetInField(preLabel) + "= null;" + "\n}";
        }else{
            return "";
        }
    }

    /**
     * Generates code that performs the tranformation from one input string
     * to many output strings, or to a reject flow. The boolean parameter is
     * used to define whether the transform method return type is void or something
     * else.
     *
     * DI sample output :
     *    MainOutput no exception : col1|col2|col3...
     *    MainOutput with exception : No Output (Error output with Exception msg)
     *    Reject Output : col1|col2...|colx|Empty Col where exception occured|coly...|Error Code|Error msg
     */
    public void generateTransform(boolean hasAReturnedType) {


    stringBuffer.append(TEXT_79);
    
        if (autoCast){
                for (IMetadataColumn col : getOutColumnsMain() != null ? getOutColumnsMain() : getOutColumnsReject()){
                    String outLabel = col.getLabel();
                    String outPattern = col.getPattern();
                    String outTypeWhole = JavaTypesManager.getTypeToGenerate(col.getTalendType(), col.isNullable());
                    String outType = outTypeWhole.contains(".") ? outTypeWhole.substring(outTypeWhole.lastIndexOf(".") + 1) : outTypeWhole;
                    if (("byte[]").equals(outType)){
                        outType = "byteArray";
                    }
                    for (IMetadataColumn preCol : getInColumns()){
                        String preLabel = preCol.getLabel();
                        if (preLabel.equals(outLabel)){
                            String inTypeWhole = JavaTypesManager.getTypeToGenerate(preCol.getTalendType(), preCol.isNullable());
                            String inType = inTypeWhole.contains(".") ? inTypeWhole.substring(inTypeWhole.lastIndexOf(".") + 1) : inTypeWhole;
                            String inPattern = preCol.getPattern();
                            if (("byte[]").equals(inType)){
                                inType = "byteArray";
                            }

    stringBuffer.append(TEXT_80);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(generateNullReplacement(bEmptyToNull, preLabel, outLabel, inType, outType));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(generateConversionCode(preLabel, outLabel, inType, outType, outPattern, inPattern));
    stringBuffer.append(TEXT_83);
    
                        }
                    }
                }

    stringBuffer.append(TEXT_84);
    
                    generateTransformReject(dieOnError, "rowException", null);

    stringBuffer.append(TEXT_85);
                      if(null != getOutConnMain()) {

    stringBuffer.append(TEXT_86);
    stringBuffer.append(getRowTransform().getCodeToAddToOutput(null == getOutConnMain(), newOutColumns));
                      }

    stringBuffer.append(TEXT_87);
    
        }

    
        else {

    
            for (Map<String, String> manualColumn : manualtable){
                String input = manualColumn.get("INPUT_COLUMN");
                String output = manualColumn.get("OUTPUT_COLUMN");
                IMetadataColumn in = org.talend.designer.common.TransformerBaseUtil.getColumn(getInColumns(), input);
                IMetadataColumn out = org.talend.designer.common.TransformerBaseUtil.getColumn(getOutColumnsMain() != null ? getOutColumnsMain() : getOutColumnsReject(), output);
                String inTypeWhole = JavaTypesManager.getTypeToGenerate(in.getTalendType(), in.isNullable());
                String inType = inTypeWhole.contains(".") ? inTypeWhole.substring(inTypeWhole.lastIndexOf(".") + 1) : inTypeWhole;
                String outTypeWhole = JavaTypesManager.getTypeToGenerate(out.getTalendType(), out.isNullable());
                String outType = outTypeWhole.contains(".") ? outTypeWhole.substring(outTypeWhole.lastIndexOf(".") + 1) : outTypeWhole;

                if (("byte[]").equals(outType)){
                    outType = "byteArray";
                }

                if (("byte[]").equals(inType)){
                    inType = "byteArray";
                }

                String outLabel = out.getLabel();
                String outPattern = out.getPattern();
                String preLabel = in.getLabel();
                String inPattern = in.getPattern();

    stringBuffer.append(TEXT_88);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(generateNullReplacement(bEmptyToNull, preLabel, outLabel, inType, outType));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(generateConversionCode(preLabel, outLabel, inType, outType, outPattern, inPattern));
    stringBuffer.append(TEXT_91);
    
            }

    stringBuffer.append(TEXT_92);
    
                generateTransformReject(dieOnError, "rowException", null);

    stringBuffer.append(TEXT_93);
                  if(null != getOutConnMain()) {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(getRowTransform().getCodeToAddToOutput(null == getOutConnMain(), newOutColumns));
                  }

    stringBuffer.append(TEXT_95);
    
        }
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
    private void generateTransformReject(boolean die, String codeException, String codeRejectMsg) {

        if (codeRejectMsg == null) {
            codeRejectMsg = "\"" + cid + " - \" + " + codeException + ".getMessage()";
            // Note: in DI, the error message can have the line number  appended
            // to it: " - Line: " + tos_count_nodeUniqueName()
        }

        if (codeException == null) {
            codeException = codeRejectMsg;
        }

        if (die) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(codeException);
    stringBuffer.append(TEXT_97);
    
        } else {
            // No Reject Output
            if (null == getOutConnReject()) {

    stringBuffer.append(TEXT_98);
    
                generateLogMessage(codeRejectMsg);
            } else {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_MSG, codeRejectMsg) );
    
                if (containsRejectField) {

    stringBuffer.append(TEXT_101);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_FIELD, codeRejectMsg) );
    
                }
                if (null == getOutConnMain()) {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(getRowTransform().getCodeToAddToOutput(true, newOutColumns));
    
                }

    
            }

            // If there are multiple outputs, then copy all of the new columns from
            // the original output to the error output.
            if (isMultiOutput()) {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(getRowTransform().getCodeToCopyOutMainToReject(getOutColumnsMain()));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(getRowTransform().getCodeToAddToOutput(true, newOutColumns));
    
            }
        }
    }


}

    


org.talend.designer.spark.generator.SparkFunction sparkFunction = null;
String requiredInputType = bigDataNode.getRequiredInputType();
String requiredOutputType = bigDataNode.getRequiredOutputType();
String incomingType = bigDataNode.getIncomingType();
String outgoingType = bigDataNode.getOutgoingType();
boolean inputIsPair = requiredInputType != null ? "KEYVALUE".equals(requiredInputType) : "KEYVALUE".equals(incomingType);

String type = requiredOutputType == null ? outgoingType : requiredOutputType;
if("KEYVALUE".equals(type)) {
    sparkFunction = new org.talend.designer.spark.generator.FlatMapToPairFunction(inputIsPair);
} else if("VALUE".equals(type)) {
    sparkFunction = new org.talend.designer.spark.generator.FlatMapFunction(inputIsPair);
}
boolean isNodeInBatchMode = org.talend.designer.common.tmap.LookupUtil.isNodeInBatchMode(node);
if("SPARKSTREAMING".equals(node.getComponent().getType()) && !isNodeInBatchMode) {
    sparkFunction.setStreaming(true);
}

final SparkRowTransformUtil sparkTransformUtil = new SparkRowTransformUtil(sparkFunction);
final TConvertTypeUtil tConvertTypeUtil = new TConvertTypeUtil(node, codeGenArgument, sparkTransformUtil);

sparkTransformUtil.generateSparkConfig(tConvertTypeUtil, sparkFunction);

    return stringBuffer.toString();
  }
}
