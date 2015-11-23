package org.talend.designer.codegen.translators.processing.fields;

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

public class TExtractPositionalFieldsSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TExtractPositionalFieldsSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractPositionalFieldsSparkstreamingcodeJava result = new TExtractPositionalFieldsSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "            public static class ";
  protected final String TEXT_3 = " implements ";
  protected final String TEXT_4 = " {";
  protected final String TEXT_5 = NL + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_6 = "(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "\t            public ";
  protected final String TEXT_7 = " ";
  protected final String TEXT_8 = "(";
  protected final String TEXT_9 = ") ";
  protected final String TEXT_10 = " {" + NL + "\t            \t";
  protected final String TEXT_11 = NL + "\t            \t";
  protected final String TEXT_12 = NL + "\t                ";
  protected final String TEXT_13 = NL + "\t                return ";
  protected final String TEXT_14 = ";" + NL + "\t            }" + NL + "\t        }" + NL + "\t\t";
  protected final String TEXT_15 = NL + "            public static class ";
  protected final String TEXT_16 = " implements ";
  protected final String TEXT_17 = " {";
  protected final String TEXT_18 = NL + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_19 = "(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_20 = " ";
  protected final String TEXT_21 = "(";
  protected final String TEXT_22 = ") ";
  protected final String TEXT_23 = " {" + NL + "                \t";
  protected final String TEXT_24 = NL + "\t                 \treturn ";
  protected final String TEXT_25 = ";";
  protected final String TEXT_26 = NL + "                }" + NL + "            }";
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL + "            // No sparkcode generated for unnecessary ";
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL + "            public static class ";
  protected final String TEXT_31 = "TrueFilter implements org.apache.spark.api.java.function.Function<scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase>, Boolean> {" + NL + "" + NL + "                public Boolean call(scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> arg0)" + NL + "                        throws Exception {" + NL + "                    return arg0._1;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public static class ";
  protected final String TEXT_32 = "FalseFilter implements org.apache.spark.api.java.function.Function<scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase>, Boolean> {" + NL + "" + NL + "                public Boolean call(scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> arg0)" + NL + "                        throws Exception {" + NL + "                    return !arg0._1;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public static class ";
  protected final String TEXT_33 = "ToNullWritableMain implements ";
  protected final String TEXT_34 = " {" + NL + "" + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_35 = "ToNullWritableMain(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_36 = " call(" + NL + "                        scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> data){";
  protected final String TEXT_37 = NL + "                    ";
  protected final String TEXT_38 = " ";
  protected final String TEXT_39 = " = (";
  protected final String TEXT_40 = ")data._2; " + NL + "                    return ";
  protected final String TEXT_41 = ";" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public static class ";
  protected final String TEXT_42 = "ToNullWritableReject implements ";
  protected final String TEXT_43 = " {" + NL + "" + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_44 = "ToNullWritableReject(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_45 = " call(" + NL + "                        scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> data){";
  protected final String TEXT_46 = NL + "                        ";
  protected final String TEXT_47 = " ";
  protected final String TEXT_48 = " = (";
  protected final String TEXT_49 = ")data._2; " + NL + "                    return ";
  protected final String TEXT_50 = ";" + NL + "                }" + NL + "            }";
  protected final String TEXT_51 = NL + "            // No sparkconfig generated for unnecessary ";
  protected final String TEXT_52 = NL;
  protected final String TEXT_53 = NL + "            // Extract data." + NL + "            ";
  protected final String TEXT_54 = NL + "            ";
  protected final String TEXT_55 = "<Boolean, org.apache.avro.specific.SpecificRecordBase> temporary_rdd_";
  protected final String TEXT_56 = " = rdd_";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = "(new ";
  protected final String TEXT_59 = "(job));" + NL + "" + NL + "            // Main flow" + NL;
  protected final String TEXT_60 = NL + "            ";
  protected final String TEXT_61 = " rdd_";
  protected final String TEXT_62 = " = temporary_rdd_";
  protected final String TEXT_63 = NL + "                  .filter(new ";
  protected final String TEXT_64 = "TrueFilter())" + NL + "                    .";
  protected final String TEXT_65 = "(new ";
  protected final String TEXT_66 = "ToNullWritableMain(job));" + NL + "" + NL + "            // Reject flow";
  protected final String TEXT_67 = NL + "            ";
  protected final String TEXT_68 = " rdd_";
  protected final String TEXT_69 = " = temporary_rdd_";
  protected final String TEXT_70 = NL + "                    .filter(new ";
  protected final String TEXT_71 = "FalseFilter())" + NL + "                    .";
  protected final String TEXT_72 = "(new ";
  protected final String TEXT_73 = "ToNullWritableReject(job));";
  protected final String TEXT_74 = NL + "            ";
  protected final String TEXT_75 = " rdd_";
  protected final String TEXT_76 = " = rdd_";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = "(new ";
  protected final String TEXT_79 = "(job));";
  protected final String TEXT_80 = NL + "        // Input format variables";
  protected final String TEXT_81 = NL + "            private int[] sizes_";
  protected final String TEXT_82 = " = new int[]{";
  protected final String TEXT_83 = NL + "                            ";
  protected final String TEXT_84 = NL + "                            ";
  protected final String TEXT_85 = ",";
  protected final String TEXT_86 = NL + "            };";
  protected final String TEXT_87 = NL + "            String pattern_";
  protected final String TEXT_88 = " = ";
  protected final String TEXT_89 = ";" + NL + "            String[] ptnSplit_";
  protected final String TEXT_90 = " = pattern_";
  protected final String TEXT_91 = ".split(\",\");" + NL + "            private int[] sizes_";
  protected final String TEXT_92 = " = new int[ptnSplit_";
  protected final String TEXT_93 = ".length];";
  protected final String TEXT_94 = NL + "        private int[] indexs_";
  protected final String TEXT_95 = " = new int[sizes_";
  protected final String TEXT_96 = ".length];";
  protected final String TEXT_97 = NL + "        // Input format variables";
  protected final String TEXT_98 = NL + "            for(int i_";
  protected final String TEXT_99 = " = 0; i_";
  protected final String TEXT_100 = "<ptnSplit_";
  protected final String TEXT_101 = ".length; i_";
  protected final String TEXT_102 = "++){" + NL + "                if ((\"*\").equals(ptnSplit_";
  protected final String TEXT_103 = "[i_";
  protected final String TEXT_104 = "])) {" + NL + "                     sizes_";
  protected final String TEXT_105 = "[i_";
  protected final String TEXT_106 = "] = -1;" + NL + "                } else {" + NL + "                     sizes_";
  protected final String TEXT_107 = "[i_";
  protected final String TEXT_108 = "] = Integer.valueOf(ptnSplit_";
  protected final String TEXT_109 = "[i_";
  protected final String TEXT_110 = "]);" + NL + "                }" + NL + "            }";
  protected final String TEXT_111 = NL + "        for(int i_";
  protected final String TEXT_112 = "=0;i_";
  protected final String TEXT_113 = "<indexs_";
  protected final String TEXT_114 = ".length;i_";
  protected final String TEXT_115 = "++){" + NL + "            if(sizes_";
  protected final String TEXT_116 = "[i_";
  protected final String TEXT_117 = "]==-1){" + NL + "                indexs_";
  protected final String TEXT_118 = "[i_";
  protected final String TEXT_119 = "]=-1;" + NL + "            }else{" + NL + "                if(i_";
  protected final String TEXT_120 = "-1>=0){" + NL + "                    indexs_";
  protected final String TEXT_121 = "[i_";
  protected final String TEXT_122 = "]= indexs_";
  protected final String TEXT_123 = "[i_";
  protected final String TEXT_124 = "-1]+sizes_";
  protected final String TEXT_125 = "[i_";
  protected final String TEXT_126 = "];" + NL + "                }else{" + NL + "                    indexs_";
  protected final String TEXT_127 = "[i_";
  protected final String TEXT_128 = "]= sizes_";
  protected final String TEXT_129 = "[i_";
  protected final String TEXT_130 = "];" + NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_131 = NL + "        if (";
  protected final String TEXT_132 = " == null)" + NL + "            return";
  protected final String TEXT_133 = ";" + NL + "        try {" + NL + "" + NL + "            // First map the selected fields to temporary variables" + NL + "            java.util.Map<String,String> newFields_";
  protected final String TEXT_134 = " = new java.util.HashMap<String,String>();" + NL + "" + NL + "            boolean condition = false;" + NL + "            int substringSize = 0;";
  protected final String TEXT_135 = NL + "                        condition = (indexs_";
  protected final String TEXT_136 = "[";
  protected final String TEXT_137 = "] > ";
  protected final String TEXT_138 = ".length()) || (indexs_";
  protected final String TEXT_139 = "[";
  protected final String TEXT_140 = "] < 0);" + NL + "                        substringSize = condition ? ";
  protected final String TEXT_141 = ".length() : indexs_";
  protected final String TEXT_142 = "[";
  protected final String TEXT_143 = "];" + NL + "                        newFields_";
  protected final String TEXT_144 = ".put(\"";
  protected final String TEXT_145 = "\"," + NL + "                                TalendString.talendTrim(";
  protected final String TEXT_146 = NL + "                                        ";
  protected final String TEXT_147 = ".substring(0," + NL + "                                                substringSize)";
  protected final String TEXT_148 = ",";
  protected final String TEXT_149 = NL + "                                        ";
  protected final String TEXT_150 = ",";
  protected final String TEXT_151 = NL + "                                        ";
  protected final String TEXT_152 = "));";
  protected final String TEXT_153 = NL + "                        if(";
  protected final String TEXT_154 = "<indexs_";
  protected final String TEXT_155 = ".length && indexs_";
  protected final String TEXT_156 = "[";
  protected final String TEXT_157 = "]>=0 && indexs_";
  protected final String TEXT_158 = "[";
  protected final String TEXT_159 = "]<= ";
  protected final String TEXT_160 = ".length()){" + NL + "                            condition = (indexs_";
  protected final String TEXT_161 = "[";
  protected final String TEXT_162 = "] > ";
  protected final String TEXT_163 = ".length()) || (indexs_";
  protected final String TEXT_164 = "[";
  protected final String TEXT_165 = "] < 0);" + NL + "                            substringSize = condition ? ";
  protected final String TEXT_166 = ".length() : indexs_";
  protected final String TEXT_167 = "[";
  protected final String TEXT_168 = "];" + NL + "                            newFields_";
  protected final String TEXT_169 = ".put(\"";
  protected final String TEXT_170 = "\"," + NL + "                                    TalendString.talendTrim(";
  protected final String TEXT_171 = NL + "                                            ";
  protected final String TEXT_172 = ".substring(indexs_";
  protected final String TEXT_173 = "[";
  protected final String TEXT_174 = "]," + NL + "                                            substringSize)";
  protected final String TEXT_175 = ",";
  protected final String TEXT_176 = NL + "                                        ";
  protected final String TEXT_177 = ",";
  protected final String TEXT_178 = NL + "                                        ";
  protected final String TEXT_179 = "));" + NL + "                        }";
  protected final String TEXT_180 = NL + "                        condition = (indexs_";
  protected final String TEXT_181 = "[";
  protected final String TEXT_182 = "] > ";
  protected final String TEXT_183 = ".length()) || (indexs_";
  protected final String TEXT_184 = "[";
  protected final String TEXT_185 = "] < 0);" + NL + "                        substringSize = condition ? ";
  protected final String TEXT_186 = ".length() : indexs_";
  protected final String TEXT_187 = "[";
  protected final String TEXT_188 = "];" + NL + "                        newFields_";
  protected final String TEXT_189 = ".put(\"";
  protected final String TEXT_190 = "\",";
  protected final String TEXT_191 = NL + "                                ";
  protected final String TEXT_192 = ".substring(0," + NL + "                                        substringSize)";
  protected final String TEXT_193 = ");";
  protected final String TEXT_194 = NL + "                        if(";
  protected final String TEXT_195 = "<indexs_";
  protected final String TEXT_196 = ".length && indexs_";
  protected final String TEXT_197 = "[";
  protected final String TEXT_198 = "]>=0 && indexs_";
  protected final String TEXT_199 = "[";
  protected final String TEXT_200 = "]<= ";
  protected final String TEXT_201 = ".length()){" + NL + "                            condition = (indexs_";
  protected final String TEXT_202 = "[";
  protected final String TEXT_203 = "] > ";
  protected final String TEXT_204 = ".length()) || (indexs_";
  protected final String TEXT_205 = "[";
  protected final String TEXT_206 = "] < 0);" + NL + "                            substringSize = condition ? ";
  protected final String TEXT_207 = ".length() : indexs_";
  protected final String TEXT_208 = "[";
  protected final String TEXT_209 = "];" + NL + "                            newFields_";
  protected final String TEXT_210 = ".put(\"";
  protected final String TEXT_211 = "\",";
  protected final String TEXT_212 = NL + "                                    ";
  protected final String TEXT_213 = ".substring(indexs_";
  protected final String TEXT_214 = "[";
  protected final String TEXT_215 = "]," + NL + "                                        substringSize)";
  protected final String TEXT_216 = ");" + NL + "                        }";
  protected final String TEXT_217 = NL + NL + "            // Then map the temporary variables to the outputs fields." + NL + "            String temp_";
  protected final String TEXT_218 = " = null;" + NL;
  protected final String TEXT_219 = NL + "                        ";
  protected final String TEXT_220 = NL + "                    temp_";
  protected final String TEXT_221 = " = newFields_";
  protected final String TEXT_222 = ".get(\"";
  protected final String TEXT_223 = "\");" + NL + "" + NL + "                    if(temp_";
  protected final String TEXT_224 = "!=null && temp_";
  protected final String TEXT_225 = ".length() > 0) {";
  protected final String TEXT_226 = NL + "                            ";
  protected final String TEXT_227 = NL + "                            ";
  protected final String TEXT_228 = NL + "                            ";
  protected final String TEXT_229 = NL + "                            ";
  protected final String TEXT_230 = NL + "                            ";
  protected final String TEXT_231 = NL + "                    } else {";
  protected final String TEXT_232 = NL + "                            throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_233 = "' in '";
  protected final String TEXT_234 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_235 = NL + "                            ";
  protected final String TEXT_236 = NL + "                    }";
  protected final String TEXT_237 = NL + "                ";
  protected final String TEXT_238 = NL + "                ";
  protected final String TEXT_239 = NL + "            ";
  protected final String TEXT_240 = NL + "        } catch (RuntimeException ex) {";
  protected final String TEXT_241 = NL + "        }";
  protected final String TEXT_242 = NL + "            // Die immediately on errors." + NL + "            throw new IOException(";
  protected final String TEXT_243 = ");";
  protected final String TEXT_244 = NL + "                ";
  protected final String TEXT_245 = NL + "                // Ignore errors processing this row and move to the next.";
  protected final String TEXT_246 = NL + "                // Send error rows to the reject output.";
  protected final String TEXT_247 = NL + "                ";
  protected final String TEXT_248 = NL + "                    ";
  protected final String TEXT_249 = NL + "                ";
  protected final String TEXT_250 = NL + "                ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(this.sparkFunction.getCodeFunctionImplementation(getOutValueClass(), getInValueClass()));
    stringBuffer.append(TEXT_4);
    
                this.transformer.generateHelperClasses(true);
                this.transformer.generateTransformContextDeclaration();
                
    stringBuffer.append(TEXT_5);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturnedType(this.outValueClass.toString()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(this.sparkFunction.getCodeImplementedMethod());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(this.sparkFunction.getCodeFunctionArgument(getInValueClass()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(this.sparkFunction.getCodeThrowException());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(this.sparkFunction.getMethodHeader(this.outValueClass, this.outValue, this.inValueClass, this.inValue));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(this.sparkFunction.getCodeKeyMapping(getInValue()));
    stringBuffer.append(TEXT_12);
    
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
        
    stringBuffer.append(TEXT_15);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(this.sparkFunction.getCodeFunctionImplementationOutputFixedType(getInValueClass(), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
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
    stringBuffer.append(this.sparkFunction.getCodeFunctionArgument(getInValueClass()));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(this.sparkFunction.getCodeThrowException());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(this.sparkFunction.getMethodHeader(this.outValueClass, this.outValue, this.inValueClass, this.inValue));
    
                    this.transformer.generateTransformContextInitialization();
                    this.transformer.generateTransform(true);
	                if(this.sparkFunction.getCodeFunctionReturn()!=null) {
                
    stringBuffer.append(TEXT_24);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturn());
    stringBuffer.append(TEXT_25);
    
	            	}
                
    stringBuffer.append(TEXT_26);
    
        }
    }

    stringBuffer.append(TEXT_27);
    

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
            
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
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

            
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(extractSparkFunction.getCodeFunctionImplementationInputFixedType(transformer.getOutConnMainTypeName(), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturnedType(transformer.getOutConnMainTypeName()));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(transformer.getOutConnMainTypeName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(transformer.getOutConnMainTypeName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturn(transformer.getOutConnMainName(), transformer.getOutConnMainTypeName()));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(extractSparkFunction.getCodeFunctionImplementationInputFixedType(transformer.getOutConnRejectTypeName(), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturnedType(transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(transformer.getOutConnRejectTypeName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(transformer.getOutConnRejectName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(transformer.getOutConnRejectTypeName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(extractSparkFunction.getCodeFunctionReturn(transformer.getOutConnRejectName(), transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_50);
    
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
            
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
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
            
    stringBuffer.append(TEXT_53);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(sparkFunction.isStreaming() ?"org.apache.spark.streaming.api.java.JavaPairDStream":"org.apache.spark.api.java.JavaPairRDD");
    stringBuffer.append(TEXT_55);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(transformer.getInConnName());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(localFunctionType);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(sparkFunction.getConfigReturnedType(transformer.getOutConnMainTypeName()));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(extractFunctionType);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(sparkFunction.getConfigReturnedType(transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(transformer.getOutConnRejectName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(extractFunctionType);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
        } else {
            functionGenerator = new SOFunctionGenerator(transformer, sparkFunction);

            functionGenerator.init(node, cid, null, transformer.getInConnName(), null, 
                    transformer.getOutConnMainName() != null
                        ? transformer.getOutConnMainName()
                                : transformer.getOutConnRejectName());
            
    stringBuffer.append(TEXT_74);
    stringBuffer.append(sparkFunction.getConfigReturnedType(transformer.getOutConnMainName() != null ? transformer.getOutConnMainTypeName() : transformer.getOutConnRejectTypeName()));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(transformer.getOutConnMainName() != null ? transformer.getOutConnMainName() : transformer.getOutConnRejectName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(transformer.getInConnName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(sparkFunction.getConfigTransformation());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_79);
    
        }
    }
}


    

/**
 * Contains common processing for tExtractPositionalFields code generation.  This is
 * used in MapReduce and Storm components.
 *
 * The following imports must occur before importing this file:
 * @ include file="@{org.talend.designer.components.mrprovider}/resources/utils/common_codegen_util.javajet"
 */
class TExtractPositionalFieldsUtil extends org.talend.designer.common.TransformerBase {

    // TODO: what happens when these are input column names?
    final private static String REJECT_MSG = "errorMessage";
    final private static String REJECT_CODE = "errorCode";
    final private static String REJECT_FIELD = "inputLine";

    final private String field = ElementParameterParser.getValue(node, "__FIELD__");

    final private boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    final private boolean advanced = ("true").equals(ElementParameterParser.getValue(node, "__ADVANCED_OPTION__"));
    final private boolean trim = ("true").equals(ElementParameterParser.getValue(node, "__TRIM__"));
    final private boolean checkNum = ("true").equals(ElementParameterParser.getValue(node, "__CHECK_FIELDS_NUM__"));
    final private boolean advancedSeparator = ("true").equals(ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__"));
    final private String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    final private String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

    final private String pattern = ElementParameterParser.getValue(node, "__PATTERN__");
    final private boolean advancedInputFormat = ("true").equals(ElementParameterParser.getValue(node, "__ADVANCED_OPTION__"));
    final private java.util.List<java.util.Map<String, String>> formats =
        (java.util.List<java.util.Map<String,String>>)ElementParameterParser.getObjectValue( node, "__FORMATS__");

    /** The outgoing connection contains the column {@link #REJECT_FIELD}.
     *  If we import a job from a DI job, this column will be missing */
    final private Boolean containsRejectField;

    /** The list of columns that should be copied directly from the input to
     *  the output schema (where they have the same column names). */
    final private Iterable<IMetadataColumn> copiedInColumns;

    /** Columns in the output schema that do not appear in the input column (and are not . */
    final private java.util.List<IMetadataColumn> newOutColumns;

    /** TODO: Used in DI, tied to CHECK_NUM */
    final private boolean validateDatesStrict = false;
    final private boolean validateNumberOfMatchedGroups = false;

    public TExtractPositionalFieldsUtil(INode node,
            org.talend.designer.common.BigDataCodeGeneratorArgument argument,
            org.talend.designer.common.CommonRowTransformUtil rowTransformUtil) {
        super(node, argument, rowTransformUtil, "FLOW", "REJECT");

        containsRejectField = hasOutputColumn(true, REJECT_FIELD);

        if (null != getInConn() && null != getOutConnMain()) {
            copiedInColumns = getColumnsUnion(getInColumns(), getOutColumnsMain());
            newOutColumns = getColumnsDiff(getOutColumnsMain(), getInColumns());
        } else if (null != getInConn() && null != getOutConnReject()) {
            copiedInColumns = getColumnsUnion(getInColumns(), getOutColumnsReject());
            // If only the reject output is used, the new columns are those that
            // are not part of the main schema (ignore the REJECT_XXX columns).
            Iterable<IMetadataColumn> mainCols = getColumnsDiff(
                    getOutColumnsReject(), getColumns(getOutColumnsReject(),
                            REJECT_FIELD, REJECT_CODE, REJECT_MSG));
            newOutColumns = getColumnsDiff(mainCols, getInColumns());
        } else {
            copiedInColumns = null;
            newOutColumns = null;
        }
    }

    public void generateTransformContextDeclaration() {
        
    stringBuffer.append(TEXT_80);
    
        if (advancedInputFormat) {
            
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
                    for(int i=0; i < formats.size();i++){
                        java.util.Map<String,String> tmp = formats.get(i);
                        if(("*").equals(tmp.get("SIZE"))){
                            
    stringBuffer.append(TEXT_83);
    stringBuffer.append(-1);
    
                        }else{
                            
    stringBuffer.append(TEXT_84);
    stringBuffer.append(Integer.valueOf(tmp.get("SIZE")));
    stringBuffer.append(TEXT_85);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_86);
    
        } else {
            
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
        }
        
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
    }


    public void generateTransformContextInitialization() {
        
    stringBuffer.append(TEXT_97);
    
        if (!advancedInputFormat) {
            
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
        }
        
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
    }
    public void generateTransform() {
        generateTransform(false);
    }

    /**
     * Generates code that performs the tranformation from one input string
     * to many output strings, or to a reject flow.
     */
    public void generateTransform(boolean hasAReturnedType) {
        
    stringBuffer.append(TEXT_131);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(hasAReturnedType?" null":"");
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
            if (advanced) {
                for (int i = 0; i < formats.size(); i++) {
                    java.util.Map<String,String> tmp = formats.get(i);
                    if (i == 0) {
                        
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(tmp.get("COLUMN"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_148);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(tmp.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(tmp.get("ALIGN"));
    stringBuffer.append(TEXT_152);
    
                    } else {
                        
    stringBuffer.append(TEXT_153);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(tmp.get("COLUMN"));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_175);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(tmp.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(tmp.get("ALIGN"));
    stringBuffer.append(TEXT_179);
    
                    }
                }
            } else {
                for(int i = 0; i < newOutColumns.size(); i++){
                    IMetadataColumn temporaryMetadata = newOutColumns.get(i);
                    if(i==0){
                        
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(temporaryMetadata.getLabel());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_193);
    
                    }else{
                        
    stringBuffer.append(TEXT_194);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(temporaryMetadata.getLabel());
    stringBuffer.append(TEXT_211);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_216);
    
                    }
                }
            }
            
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
            for(IMetadataColumn column : newOutColumns){
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                String columnName = column.getLabel();
                if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
                    
    stringBuffer.append(TEXT_219);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "newFields_" + cid +".get(\"" + columnName + "\")") );
    
                } else {
                    
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    
                        if(javaType == JavaTypesManager.BYTE_ARRAY){
                            
    stringBuffer.append(TEXT_226);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "temp_" + cid +".getBytes()") );
    
                        }else if(javaType == JavaTypesManager.DATE) {
                            if(checkNum){
                            
    stringBuffer.append(TEXT_227);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(temp_" + cid +", " + patternValue + ", false)") );
    
                            }else{
                            
    stringBuffer.append(TEXT_228);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(temp_" + cid +", " + patternValue + ")") );
    
                            }
                        }else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) {
                            
    stringBuffer.append(TEXT_229);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, " BigDataParserUtils.parseTo_" + typeToGenerate
                                    + "(BigDataParserUtils.parseTo_Number(temp_" + cid +", " + thousandsSeparator + ", " + decimalSeparator + "))") );
    
                        } else {
                            
    stringBuffer.append(TEXT_230);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_" + typeToGenerate + "(temp_" + cid + ")") );
    
                        }
                    
    stringBuffer.append(TEXT_231);
    
                        String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
                        if(defaultValue == null) {
                            
    stringBuffer.append(TEXT_232);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(getOutConnMainName());
    stringBuffer.append(TEXT_234);
    
                        } else {
                            
    stringBuffer.append(TEXT_235);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, defaultValue) );
    
                        }
                    
    stringBuffer.append(TEXT_236);
    
                }
            }

            if (null != getOutConnMain()) {
                
    stringBuffer.append(TEXT_237);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(false, copiedInColumns));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(getRowTransform().getCodeToEmit(false));
    
            }
            
    stringBuffer.append(TEXT_239);
    stringBuffer.append(getRowTransform().getCodeToInitOut(null == getOutConnMain(), newOutColumns));
    stringBuffer.append(TEXT_240);
    
            generateTransformReject(dieOnError, "ex", null);
            
    stringBuffer.append(TEXT_241);
    
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
            codeRejectMsg = "\"" + cid + " - \" + " + codeException
                    + ".getMessage()";
            // Note: in DI, the error message can have the line number  appended
            // to it: " - Line: " + tos_count_nodeUniqueName()
        }

        if (codeException == null) {
            codeException = codeRejectMsg;
        }

        if (die) {
            
    stringBuffer.append(TEXT_242);
    stringBuffer.append(codeException);
    stringBuffer.append(TEXT_243);
    
        } else {
            // If there are multiple outputs, then copy all of the new columns from
            // the original output to the error output.
            if (isMultiOutput()) {
                
    stringBuffer.append(TEXT_244);
    stringBuffer.append(getRowTransform().getCodeToCopyOutMainToReject(newOutColumns));
    
            }

            if (null == getOutConnReject()) {
                
    stringBuffer.append(TEXT_245);
    
                generateLogMessage(codeRejectMsg);
            } else {
                
    stringBuffer.append(TEXT_246);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_MSG,
                        codeRejectMsg) );
    
                if (containsRejectField) {
                    
    stringBuffer.append(TEXT_248);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_FIELD,
                        getRowTransform().getCodeToGetInField(field)) );
    
                }
                
    stringBuffer.append(TEXT_249);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(true, copiedInColumns));
    stringBuffer.append(TEXT_250);
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
boolean inputIsPair = requiredInputType != null ? "KEYVALUE".equals(requiredInputType) : "KEYVALUE".equals(incomingType);

String type = requiredOutputType == null ? outgoingType : requiredOutputType;
if("KEYVALUE".equals(type)) {
    sparkFunction = new org.talend.designer.spark.generator.FlatMapToPairFunction(inputIsPair);
} else if("VALUE".equals(type)) {
    sparkFunction = new org.talend.designer.spark.generator.FlatMapFunction(inputIsPair);
}

final SparkRowTransformUtil sparkTransformUtil = new SparkRowTransformUtil(sparkFunction);
final TExtractPositionalFieldsUtil tExtractPositionalFieldsUtil = new TExtractPositionalFieldsUtil(
        node, codeGenArgument, sparkTransformUtil);

sparkTransformUtil.generateSparkCode(tExtractPositionalFieldsUtil, sparkFunction);

    return stringBuffer.toString();
  }
}
