package org.talend.designer.codegen.translators.processing.fields;

import java.util.List;
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

public class TExtractPositionalFieldsSparkcodeJava
{
  protected static String nl;
  public static synchronized TExtractPositionalFieldsSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractPositionalFieldsSparkcodeJava result = new TExtractPositionalFieldsSparkcodeJava();
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
  protected final String TEXT_79 = NL + "        // Input format variables";
  protected final String TEXT_80 = NL + "            private int[] sizes_";
  protected final String TEXT_81 = " = new int[]{";
  protected final String TEXT_82 = NL + "                            ";
  protected final String TEXT_83 = NL + "                            ";
  protected final String TEXT_84 = ",";
  protected final String TEXT_85 = NL + "            };";
  protected final String TEXT_86 = NL + "            String pattern_";
  protected final String TEXT_87 = " = ";
  protected final String TEXT_88 = ";" + NL + "            String[] ptnSplit_";
  protected final String TEXT_89 = " = pattern_";
  protected final String TEXT_90 = ".split(\",\");" + NL + "            private int[] sizes_";
  protected final String TEXT_91 = " = new int[ptnSplit_";
  protected final String TEXT_92 = ".length];";
  protected final String TEXT_93 = NL + "        private int[] indexs_";
  protected final String TEXT_94 = " = new int[sizes_";
  protected final String TEXT_95 = ".length];";
  protected final String TEXT_96 = NL + "        // Input format variables";
  protected final String TEXT_97 = NL + "            for(int i_";
  protected final String TEXT_98 = " = 0; i_";
  protected final String TEXT_99 = "<ptnSplit_";
  protected final String TEXT_100 = ".length; i_";
  protected final String TEXT_101 = "++){" + NL + "                if ((\"*\").equals(ptnSplit_";
  protected final String TEXT_102 = "[i_";
  protected final String TEXT_103 = "])) {" + NL + "                     sizes_";
  protected final String TEXT_104 = "[i_";
  protected final String TEXT_105 = "] = -1;" + NL + "                } else {" + NL + "                     sizes_";
  protected final String TEXT_106 = "[i_";
  protected final String TEXT_107 = "] = Integer.valueOf(ptnSplit_";
  protected final String TEXT_108 = "[i_";
  protected final String TEXT_109 = "]);" + NL + "                }" + NL + "            }";
  protected final String TEXT_110 = NL + "        for(int i_";
  protected final String TEXT_111 = "=0;i_";
  protected final String TEXT_112 = "<indexs_";
  protected final String TEXT_113 = ".length;i_";
  protected final String TEXT_114 = "++){" + NL + "            if(sizes_";
  protected final String TEXT_115 = "[i_";
  protected final String TEXT_116 = "]==-1){" + NL + "                indexs_";
  protected final String TEXT_117 = "[i_";
  protected final String TEXT_118 = "]=-1;" + NL + "            }else{" + NL + "                if(i_";
  protected final String TEXT_119 = "-1>=0){" + NL + "                    indexs_";
  protected final String TEXT_120 = "[i_";
  protected final String TEXT_121 = "]= indexs_";
  protected final String TEXT_122 = "[i_";
  protected final String TEXT_123 = "-1]+sizes_";
  protected final String TEXT_124 = "[i_";
  protected final String TEXT_125 = "];" + NL + "                }else{" + NL + "                    indexs_";
  protected final String TEXT_126 = "[i_";
  protected final String TEXT_127 = "]= sizes_";
  protected final String TEXT_128 = "[i_";
  protected final String TEXT_129 = "];" + NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_130 = NL + "        if (";
  protected final String TEXT_131 = " == null)" + NL + "            return";
  protected final String TEXT_132 = ";" + NL + "        try {" + NL + "" + NL + "            // First map the selected fields to temporary variables" + NL + "            java.util.Map<String,String> newFields_";
  protected final String TEXT_133 = " = new java.util.HashMap<String,String>();" + NL + "" + NL + "            boolean condition = false;" + NL + "            int substringSize = 0;";
  protected final String TEXT_134 = NL + "                        condition = (indexs_";
  protected final String TEXT_135 = "[";
  protected final String TEXT_136 = "] > ";
  protected final String TEXT_137 = ".length()) || (indexs_";
  protected final String TEXT_138 = "[";
  protected final String TEXT_139 = "] < 0);" + NL + "                        substringSize = condition ? ";
  protected final String TEXT_140 = ".length() : indexs_";
  protected final String TEXT_141 = "[";
  protected final String TEXT_142 = "];" + NL + "                        newFields_";
  protected final String TEXT_143 = ".put(\"";
  protected final String TEXT_144 = "\"," + NL + "                                TalendString.talendTrim(";
  protected final String TEXT_145 = NL + "                                        ";
  protected final String TEXT_146 = ".substring(0," + NL + "                                                substringSize)";
  protected final String TEXT_147 = ",";
  protected final String TEXT_148 = NL + "                                        ";
  protected final String TEXT_149 = ",";
  protected final String TEXT_150 = NL + "                                        ";
  protected final String TEXT_151 = "));";
  protected final String TEXT_152 = NL + "                        if(";
  protected final String TEXT_153 = "<indexs_";
  protected final String TEXT_154 = ".length && indexs_";
  protected final String TEXT_155 = "[";
  protected final String TEXT_156 = "]>=0 && indexs_";
  protected final String TEXT_157 = "[";
  protected final String TEXT_158 = "]<= ";
  protected final String TEXT_159 = ".length()){" + NL + "                            condition = (indexs_";
  protected final String TEXT_160 = "[";
  protected final String TEXT_161 = "] > ";
  protected final String TEXT_162 = ".length()) || (indexs_";
  protected final String TEXT_163 = "[";
  protected final String TEXT_164 = "] < 0);" + NL + "                            substringSize = condition ? ";
  protected final String TEXT_165 = ".length() : indexs_";
  protected final String TEXT_166 = "[";
  protected final String TEXT_167 = "];" + NL + "                            newFields_";
  protected final String TEXT_168 = ".put(\"";
  protected final String TEXT_169 = "\"," + NL + "                                    TalendString.talendTrim(";
  protected final String TEXT_170 = NL + "                                            ";
  protected final String TEXT_171 = ".substring(indexs_";
  protected final String TEXT_172 = "[";
  protected final String TEXT_173 = "]," + NL + "                                            substringSize)";
  protected final String TEXT_174 = ",";
  protected final String TEXT_175 = NL + "                                        ";
  protected final String TEXT_176 = ",";
  protected final String TEXT_177 = NL + "                                        ";
  protected final String TEXT_178 = "));" + NL + "                        }";
  protected final String TEXT_179 = NL + "                        condition = (indexs_";
  protected final String TEXT_180 = "[";
  protected final String TEXT_181 = "] > ";
  protected final String TEXT_182 = ".length()) || (indexs_";
  protected final String TEXT_183 = "[";
  protected final String TEXT_184 = "] < 0);" + NL + "                        substringSize = condition ? ";
  protected final String TEXT_185 = ".length() : indexs_";
  protected final String TEXT_186 = "[";
  protected final String TEXT_187 = "];" + NL + "                        newFields_";
  protected final String TEXT_188 = ".put(\"";
  protected final String TEXT_189 = "\",";
  protected final String TEXT_190 = NL + "                                ";
  protected final String TEXT_191 = ".substring(0," + NL + "                                        substringSize)";
  protected final String TEXT_192 = ");";
  protected final String TEXT_193 = NL + "                        if(";
  protected final String TEXT_194 = "<indexs_";
  protected final String TEXT_195 = ".length && indexs_";
  protected final String TEXT_196 = "[";
  protected final String TEXT_197 = "]>=0 && indexs_";
  protected final String TEXT_198 = "[";
  protected final String TEXT_199 = "]<= ";
  protected final String TEXT_200 = ".length()){" + NL + "                            condition = (indexs_";
  protected final String TEXT_201 = "[";
  protected final String TEXT_202 = "] > ";
  protected final String TEXT_203 = ".length()) || (indexs_";
  protected final String TEXT_204 = "[";
  protected final String TEXT_205 = "] < 0);" + NL + "                            substringSize = condition ? ";
  protected final String TEXT_206 = ".length() : indexs_";
  protected final String TEXT_207 = "[";
  protected final String TEXT_208 = "];" + NL + "                            newFields_";
  protected final String TEXT_209 = ".put(\"";
  protected final String TEXT_210 = "\",";
  protected final String TEXT_211 = NL + "                                    ";
  protected final String TEXT_212 = ".substring(indexs_";
  protected final String TEXT_213 = "[";
  protected final String TEXT_214 = "]," + NL + "                                        substringSize)";
  protected final String TEXT_215 = ");" + NL + "                        }";
  protected final String TEXT_216 = NL + NL + "            // Then map the temporary variables to the outputs fields." + NL + "            String temp_";
  protected final String TEXT_217 = " = null;" + NL;
  protected final String TEXT_218 = NL + "                        ";
  protected final String TEXT_219 = NL + "                    temp_";
  protected final String TEXT_220 = " = newFields_";
  protected final String TEXT_221 = ".get(\"";
  protected final String TEXT_222 = "\");" + NL + "" + NL + "                    if(temp_";
  protected final String TEXT_223 = "!=null && temp_";
  protected final String TEXT_224 = ".length() > 0) {";
  protected final String TEXT_225 = NL + "                            ";
  protected final String TEXT_226 = NL + "                            ";
  protected final String TEXT_227 = NL + "                            ";
  protected final String TEXT_228 = NL + "                            ";
  protected final String TEXT_229 = NL + "                            ";
  protected final String TEXT_230 = NL + "                    } else {";
  protected final String TEXT_231 = NL + "                            throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_232 = "' in '";
  protected final String TEXT_233 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_234 = NL + "                            ";
  protected final String TEXT_235 = NL + "                    }";
  protected final String TEXT_236 = NL + "                ";
  protected final String TEXT_237 = NL + "                ";
  protected final String TEXT_238 = NL + "            ";
  protected final String TEXT_239 = NL + "        } catch (RuntimeException ex) {";
  protected final String TEXT_240 = NL + "        }";
  protected final String TEXT_241 = NL + "            // Die immediately on errors." + NL + "            throw new IOException(";
  protected final String TEXT_242 = ");";
  protected final String TEXT_243 = NL + "                ";
  protected final String TEXT_244 = NL + "                // Ignore errors processing this row and move to the next.";
  protected final String TEXT_245 = NL + "                // Send error rows to the reject output.";
  protected final String TEXT_246 = NL + "                ";
  protected final String TEXT_247 = NL + "                    ";
  protected final String TEXT_248 = NL + "                ";
  protected final String TEXT_249 = NL + "                ";

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
        
    stringBuffer.append(TEXT_79);
    
        if (advancedInputFormat) {
            
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
                    for(int i=0; i < formats.size();i++){
                        java.util.Map<String,String> tmp = formats.get(i);
                        if(("*").equals(tmp.get("SIZE"))){
                            
    stringBuffer.append(TEXT_82);
    stringBuffer.append(-1);
    
                        }else{
                            
    stringBuffer.append(TEXT_83);
    stringBuffer.append(Integer.valueOf(tmp.get("SIZE")));
    stringBuffer.append(TEXT_84);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_85);
    
        } else {
            
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
        }
        
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
    }


    public void generateTransformContextInitialization() {
        
    stringBuffer.append(TEXT_96);
    
        if (!advancedInputFormat) {
            
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
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
    
        }
        
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
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
    
    }
    public void generateTransform() {
        generateTransform(false);
    }

    /**
     * Generates code that performs the tranformation from one input string
     * to many output strings, or to a reject flow.
     */
    public void generateTransform(boolean hasAReturnedType) {
        
    stringBuffer.append(TEXT_130);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(hasAReturnedType?" null":"");
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
            if (advanced) {
                for (int i = 0; i < formats.size(); i++) {
                    java.util.Map<String,String> tmp = formats.get(i);
                    if (i == 0) {
                        
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(tmp.get("COLUMN"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_147);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(tmp.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(tmp.get("ALIGN"));
    stringBuffer.append(TEXT_151);
    
                    } else {
                        
    stringBuffer.append(TEXT_152);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(tmp.get("COLUMN"));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_174);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(tmp.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(tmp.get("ALIGN"));
    stringBuffer.append(TEXT_178);
    
                    }
                }
            } else {
                for(int i = 0; i < newOutColumns.size(); i++){
                    IMetadataColumn temporaryMetadata = newOutColumns.get(i);
                    if(i==0){
                        
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(temporaryMetadata.getLabel());
    stringBuffer.append(TEXT_189);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_192);
    
                    }else{
                        
    stringBuffer.append(TEXT_193);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(temporaryMetadata.getLabel());
    stringBuffer.append(TEXT_210);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_215);
    
                    }
                }
            }
            
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    
            for(IMetadataColumn column : newOutColumns){
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                String columnName = column.getLabel();
                if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
                    
    stringBuffer.append(TEXT_218);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "newFields_" + cid +".get(\"" + columnName + "\")") );
    
                } else {
                    
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    
                        if(javaType == JavaTypesManager.BYTE_ARRAY){
                            
    stringBuffer.append(TEXT_225);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "temp_" + cid +".getBytes()") );
    
                        }else if(javaType == JavaTypesManager.DATE) {
                            if(checkNum){
                            
    stringBuffer.append(TEXT_226);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(temp_" + cid +", " + patternValue + ", false)") );
    
                            }else{
                            
    stringBuffer.append(TEXT_227);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(temp_" + cid +", " + patternValue + ")") );
    
                            }
                        }else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) {
                            
    stringBuffer.append(TEXT_228);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, " BigDataParserUtils.parseTo_" + typeToGenerate
                                    + "(BigDataParserUtils.parseTo_Number(temp_" + cid +", " + thousandsSeparator + ", " + decimalSeparator + "))") );
    
                        } else {
                            
    stringBuffer.append(TEXT_229);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_" + typeToGenerate + "(temp_" + cid + ")") );
    
                        }
                    
    stringBuffer.append(TEXT_230);
    
                        String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
                        if(defaultValue == null) {
                            
    stringBuffer.append(TEXT_231);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(getOutConnMainName());
    stringBuffer.append(TEXT_233);
    
                        } else {
                            
    stringBuffer.append(TEXT_234);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, defaultValue) );
    
                        }
                    
    stringBuffer.append(TEXT_235);
    
                }
            }

            if (null != getOutConnMain()) {
                
    stringBuffer.append(TEXT_236);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(false, copiedInColumns));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(getRowTransform().getCodeToEmit(false));
    
            }
            
    stringBuffer.append(TEXT_238);
    stringBuffer.append(getRowTransform().getCodeToInitOut(null == getOutConnMain(), newOutColumns));
    stringBuffer.append(TEXT_239);
    
            generateTransformReject(dieOnError, "ex", null);
            
    stringBuffer.append(TEXT_240);
    
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
            
    stringBuffer.append(TEXT_241);
    stringBuffer.append(codeException);
    stringBuffer.append(TEXT_242);
    
        } else {
            // If there are multiple outputs, then copy all of the new columns from
            // the original output to the error output.
            if (isMultiOutput()) {
                
    stringBuffer.append(TEXT_243);
    stringBuffer.append(getRowTransform().getCodeToCopyOutMainToReject(newOutColumns));
    
            }

            if (null == getOutConnReject()) {
                
    stringBuffer.append(TEXT_244);
    
                generateLogMessage(codeRejectMsg);
            } else {
                
    stringBuffer.append(TEXT_245);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_MSG,
                        codeRejectMsg) );
    
                if (containsRejectField) {
                    
    stringBuffer.append(TEXT_247);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_FIELD,
                        getRowTransform().getCodeToGetInField(field)) );
    
                }
                
    stringBuffer.append(TEXT_248);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(true, copiedInColumns));
    stringBuffer.append(TEXT_249);
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
