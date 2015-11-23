package org.talend.designer.codegen.translators.processing;

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

public class TTopSparkconfigJava
{
  protected static String nl;
  public static synchronized TTopSparkconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTopSparkconfigJava result = new TTopSparkconfigJava();
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
  protected final String TEXT_29 = NL + "            // No sparkconfig generated for unnecessary ";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL + "        ";
  protected final String TEXT_32 = " rdd_";
  protected final String TEXT_33 = " =" + NL + "            ctx.parallelizePairs(" + NL + "                    rdd_";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = "(";
  protected final String TEXT_36 = "," + NL + "                        new ";
  protected final String TEXT_37 = "(job))," + NL + "                1); // One partition to keep the ordering.";
  protected final String TEXT_38 = NL + "            return -1;";
  protected final String TEXT_39 = NL + "            return 1;";
  protected final String TEXT_40 = NL + "            return 1;";
  protected final String TEXT_41 = NL + "            return -1;";
  protected final String TEXT_42 = NL + "            if(data1.";
  protected final String TEXT_43 = " == null && data2.";
  protected final String TEXT_44 = " != null){";
  protected final String TEXT_45 = NL + "            }else if(data1.";
  protected final String TEXT_46 = " != null && data2.";
  protected final String TEXT_47 = " == null){";
  protected final String TEXT_48 = NL + "            }else if(data1.";
  protected final String TEXT_49 = " == null && data2.";
  protected final String TEXT_50 = " == null){" + NL + "                //ignore" + NL + "            }else{";
  protected final String TEXT_51 = NL + "                if(data1.";
  protected final String TEXT_52 = " != data2.";
  protected final String TEXT_53 = "){" + NL + "                    if(data1.";
  protected final String TEXT_54 = "){";
  protected final String TEXT_55 = NL + "                    }else{";
  protected final String TEXT_56 = NL + "                    }" + NL + "                }";
  protected final String TEXT_57 = NL + "                if(data1.";
  protected final String TEXT_58 = " > data2.";
  protected final String TEXT_59 = "){";
  protected final String TEXT_60 = NL + "                }else if(data1.";
  protected final String TEXT_61 = " < data2.";
  protected final String TEXT_62 = "){";
  protected final String TEXT_63 = NL + "                }";
  protected final String TEXT_64 = NL + "                String s1_";
  protected final String TEXT_65 = " = new String(data1.";
  protected final String TEXT_66 = ");" + NL + "                String s2_";
  protected final String TEXT_67 = " = new String(data2.";
  protected final String TEXT_68 = ");" + NL + "                if(!s1_";
  protected final String TEXT_69 = ".equals(s2_";
  protected final String TEXT_70 = ")){" + NL + "                    if(s1_";
  protected final String TEXT_71 = ".compareTo(s2_";
  protected final String TEXT_72 = ") > 0){";
  protected final String TEXT_73 = NL + "                    }else{";
  protected final String TEXT_74 = NL + "                    }" + NL + "                }";
  protected final String TEXT_75 = NL + "                if(data1.";
  protected final String TEXT_76 = " - data2.";
  protected final String TEXT_77 = " != 0){" + NL + "                    if(data1.";
  protected final String TEXT_78 = " - data2.";
  protected final String TEXT_79 = " > 0){";
  protected final String TEXT_80 = NL + "                    }else{";
  protected final String TEXT_81 = NL + "                    }" + NL + "                }";
  protected final String TEXT_82 = NL + "                    int cmp_";
  protected final String TEXT_83 = " = FormatterUtils.format_DateInUTC(data1.";
  protected final String TEXT_84 = ", ";
  protected final String TEXT_85 = ").compareTo(FormatterUtils.format_DateInUTC(data2.";
  protected final String TEXT_86 = ", ";
  protected final String TEXT_87 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_88 = " > 0){";
  protected final String TEXT_89 = NL + "                    }else if(cmp_";
  protected final String TEXT_90 = " < 0){";
  protected final String TEXT_91 = NL + "                    }";
  protected final String TEXT_92 = NL + "                    if(!data1.";
  protected final String TEXT_93 = ".equals(data2.";
  protected final String TEXT_94 = ")){" + NL + "                        if(data1.";
  protected final String TEXT_95 = ".compareTo(data2.";
  protected final String TEXT_96 = ") > 0){";
  protected final String TEXT_97 = NL + "                        }else{";
  protected final String TEXT_98 = NL + "                        }" + NL + "                    }";
  protected final String TEXT_99 = NL + "                    int cmp_";
  protected final String TEXT_100 = " = String.valueOf(data1.";
  protected final String TEXT_101 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_102 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_103 = " > 0){";
  protected final String TEXT_104 = NL + "                    }else if(cmp_";
  protected final String TEXT_105 = " < 0){";
  protected final String TEXT_106 = NL + "                    }";
  protected final String TEXT_107 = NL + "                    if(data1.";
  protected final String TEXT_108 = " > data2.";
  protected final String TEXT_109 = "){";
  protected final String TEXT_110 = NL + "                    }else if(data1.";
  protected final String TEXT_111 = " < data2.";
  protected final String TEXT_112 = "){";
  protected final String TEXT_113 = NL + "                    }";
  protected final String TEXT_114 = NL + "                    int cmp_";
  protected final String TEXT_115 = " = String.valueOf(data1.";
  protected final String TEXT_116 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_117 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_118 = " > 0){";
  protected final String TEXT_119 = NL + "                    }else if(cmp_";
  protected final String TEXT_120 = " < 0){";
  protected final String TEXT_121 = NL + "                    }";
  protected final String TEXT_122 = NL + "                    if(data1.";
  protected final String TEXT_123 = " > data2.";
  protected final String TEXT_124 = "){";
  protected final String TEXT_125 = NL + "                    }else if(data1.";
  protected final String TEXT_126 = " < data2.";
  protected final String TEXT_127 = "){";
  protected final String TEXT_128 = NL + "                    }";
  protected final String TEXT_129 = NL + "                    int cmp_";
  protected final String TEXT_130 = " = String.valueOf(data1.";
  protected final String TEXT_131 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_132 = "));";
  protected final String TEXT_133 = NL + "                    int cmp_";
  protected final String TEXT_134 = " = data1.";
  protected final String TEXT_135 = ".compareTo(data2.";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL + "                if(cmp_";
  protected final String TEXT_138 = " > 0){";
  protected final String TEXT_139 = NL + "                }else if(cmp_";
  protected final String TEXT_140 = " < 0){";
  protected final String TEXT_141 = NL + "                }";
  protected final String TEXT_142 = NL + "                    int cmp_";
  protected final String TEXT_143 = " = String.valueOf(data1.";
  protected final String TEXT_144 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_145 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_146 = " > 0){";
  protected final String TEXT_147 = NL + "                    }else if(cmp_";
  protected final String TEXT_148 = " < 0){";
  protected final String TEXT_149 = NL + "                    }";
  protected final String TEXT_150 = NL + "                    if(data1.";
  protected final String TEXT_151 = " > data2.";
  protected final String TEXT_152 = "){";
  protected final String TEXT_153 = NL + "                    }else if(data1.";
  protected final String TEXT_154 = " < data2.";
  protected final String TEXT_155 = "){";
  protected final String TEXT_156 = NL + "                    }";
  protected final String TEXT_157 = NL + "                    int cmp_";
  protected final String TEXT_158 = " = String.valueOf(data1.";
  protected final String TEXT_159 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_160 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_161 = " > 0){";
  protected final String TEXT_162 = NL + "                    }else if(cmp_";
  protected final String TEXT_163 = " < 0){";
  protected final String TEXT_164 = NL + "                }";
  protected final String TEXT_165 = NL + "                if(data1.";
  protected final String TEXT_166 = " > data2.";
  protected final String TEXT_167 = "){";
  protected final String TEXT_168 = NL + "                }else if(data1.";
  protected final String TEXT_169 = " < data2.";
  protected final String TEXT_170 = "){";
  protected final String TEXT_171 = NL + "                }";
  protected final String TEXT_172 = NL + "            Don't support Object type: column--";
  protected final String TEXT_173 = NL + "                int cmp_";
  protected final String TEXT_174 = " = String.valueOf(data1.";
  protected final String TEXT_175 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_176 = "));" + NL + "                if(cmp_";
  protected final String TEXT_177 = " > 0){";
  protected final String TEXT_178 = NL + "                }else if(cmp_";
  protected final String TEXT_179 = " < 0){";
  protected final String TEXT_180 = NL + "                }";
  protected final String TEXT_181 = NL + "                if(data1.";
  protected final String TEXT_182 = " > data2.";
  protected final String TEXT_183 = "){";
  protected final String TEXT_184 = NL + "                }else if(data1.";
  protected final String TEXT_185 = " < data2.";
  protected final String TEXT_186 = "){";
  protected final String TEXT_187 = NL + "                }";
  protected final String TEXT_188 = NL + "            int comp_";
  protected final String TEXT_189 = " = data1.";
  protected final String TEXT_190 = ".compareTo(data2.";
  protected final String TEXT_191 = ");" + NL + "            if(comp_";
  protected final String TEXT_192 = " != 0){" + NL + "                if(comp_";
  protected final String TEXT_193 = " > 0){";
  protected final String TEXT_194 = NL + "                }else{";
  protected final String TEXT_195 = NL + "                }" + NL + "" + NL + "            }";
  protected final String TEXT_196 = NL + "            Don't support List type: column--";
  protected final String TEXT_197 = NL + "            Don't support Document type: column--";
  protected final String TEXT_198 = NL + "            Don't support Dynamic type: column--";
  protected final String TEXT_199 = NL + "            }";
  protected final String TEXT_200 = NL;
  protected final String TEXT_201 = NL;

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
                return this.sparkFunction.getCodeToEmit(false, functionGenerator.getOutValue("reject"), functionGenerator.getOutValueClass("reject"));
            } else {
                return this.sparkFunction.getCodeToEmit(true, functionGenerator.getOutValue("main"), functionGenerator.getOutValueClass("main"));
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
            
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
            return;
        }

        // Refactoring FunctionGenerator to java so we have to instaniate a MO or SO here
        functionGenerator = new SOFunctionGenerator(transformer, sparkFunction);

        functionGenerator.init(node, cid, null, transformer.getInConnName(), null, 
                transformer.getOutConnMainName() != null
                    ? transformer.getOutConnMainName()
                            : transformer.getOutConnRejectName());

        functionGenerator.generate();
    }

    public void generateSparkConfig(final org.talend.designer.common.TransformerBase transformer, final org.talend.designer.spark.generator.SparkFunction sparkFunction, String topX) {
        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
            return;
        }

        functionGenerator = new SOFunctionGenerator(transformer, sparkFunction);

        functionGenerator.init(node, cid, null, transformer.getInConnName(), null, 
                transformer.getOutConnMainName() != null
                    ? transformer.getOutConnMainName()
                            : transformer.getOutConnRejectName());
        
    stringBuffer.append(TEXT_31);
    stringBuffer.append(sparkFunction.getConfigReturnedType(functionGenerator.getOutValueClass()));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(transformer.getInConnName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(sparkFunction.getConfigTransformation());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(topX);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_37);
    
    }
}


    

/**
 * Contains common processing for tExtractDelimitedFields code generation.  This is
 * used in MapReduce and Storm components.
 *
 * The following imports must occur before importing this file:
 * @ include file="@{org.talend.designer.components.mrprovider}/resources/utils/common_codegen_util.javajet"
 */
class TTopUtil extends org.talend.designer.common.TransformerBase {

    /** The list of columns that should be copied directly from the input to
     *  the output schema (where they have the same column names). */
    final private Iterable<IMetadataColumn> copiedInColumns;

    /** TODO: Used in DI, tied to CHECK_NUM */
    private int columnsSize = 0;

    java.util.List<java.util.Map<String, String>> criterias = (java.util.List<java.util.Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CRITERIA__");
    java.util.List<String> listCols = new java.util.ArrayList<String>();
    java.util.Map<String, Boolean> criteriasOrderType = new java.util.HashMap<String, Boolean>();
    java.util.Map<String, Integer> criteriasSortType = new java.util.HashMap<String, Integer>();
    java.util.Map<String, Boolean> sortTypes = new java.util.HashMap<String, Boolean>();
    final Integer SORT_NUM = 0;
    final Integer SORT_ALPHA = 1;
    final Integer SORT_DATE = 2;

    public TTopUtil(INode node,
            org.talend.designer.common.BigDataCodeGeneratorArgument argument,
            org.talend.designer.common.CommonRowTransformUtil rowTransformUtil) {
        super(node, argument, rowTransformUtil, "FLOW", "REJECT");

        if (null != getInConn() && null != getOutConnMain()) {
            copiedInColumns = org.talend.designer.common.TransformerBaseUtil.getColumnsUnion(getInColumns(), getOutColumnsMain());
            columnsSize = getOutConnMain().getMetadataTable().getListColumns().size();
        } else {
            copiedInColumns = null;
        }

        for(int i = 0; i < criterias.size(); i++){
            java.util.Map<String, String> line = criterias.get(i);
            String colname = line.get("COLNAME");
            if(listCols.contains(colname)){
                continue;//skip dipulicate
            }
            listCols.add(colname);

            if(("asc").equals(line.get("ORDER"))){
                criteriasOrderType.put(colname, true);
            }else{
                criteriasOrderType.put(colname, false);
            }
            if(("num").equals(line.get("SORT"))){
                criteriasSortType.put(colname, SORT_NUM);
                sortTypes.put(colname, true);
            }else if(("alpha").equals(line.get("SORT"))){
                sortTypes.put(colname, false);
            }else{
                criteriasSortType.put(colname, SORT_DATE);
                sortTypes.put(colname, true);
            }
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
        generateTransform(true);
    }

    /**
     * Generates code that performs the tranformation from one input string
     * to many output strings, or to a reject flow. The boolean parameter is
     * used to define whether the transform method return type is void or something
     * else.
     */
    public void generateTransform(boolean hasAReturnedType) {
        int index = 0;
        for(String col:listCols) {
            for(IMetadataColumn column : copiedInColumns){
                if(col.equals(column.getLabel())) {
                    compareObjectColumn(column, ++index);
                    break;
                }
            }
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

    }

    private void greater(String columnName){
            genGreater(columnName);
    }
    private void lesser(String columnName){
            genLesser(columnName);
    }
    private void genGreater(String columnName){
        if(criteriasOrderType.get(columnName)){
        
    stringBuffer.append(TEXT_38);
    
        }else{
        
    stringBuffer.append(TEXT_39);
    
        }
    }
    private void genLesser(String columnName){
        if(criteriasOrderType.get(columnName)){
        
    stringBuffer.append(TEXT_40);
    
        }else{
        
    stringBuffer.append(TEXT_41);
    
        }
    }

    private void compareObjectColumn(IMetadataColumn column, int columnIterator){
        String columnNameToGenerate = "_1()._" + columnIterator + "()";
        boolean nullable = !JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
        String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
        String columnName = column.getLabel();
        if(nullable){
        
    stringBuffer.append(TEXT_42);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_44);
    lesser(columnName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_47);
    greater(columnName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_50);
    }
    
            if(typeToGenerate.equalsIgnoreCase("Boolean")){
            
    stringBuffer.append(TEXT_51);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_54);
    greater(columnName);
    stringBuffer.append(TEXT_55);
    lesser(columnName);
    stringBuffer.append(TEXT_56);
    
            }else if(typeToGenerate.equalsIgnoreCase("Byte")){
            
    stringBuffer.append(TEXT_57);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_59);
    greater(columnName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_62);
    lesser(columnName);
    stringBuffer.append(TEXT_63);
    
            }else if(typeToGenerate.equals("byte[]")){
            
    stringBuffer.append(TEXT_64);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_72);
    greater(columnName);
    stringBuffer.append(TEXT_73);
    lesser(columnName);
    stringBuffer.append(TEXT_74);
    
            }else if(typeToGenerate.equalsIgnoreCase("Char") || typeToGenerate.equalsIgnoreCase("Character")){
            
    stringBuffer.append(TEXT_75);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_79);
    greater(columnName);
    stringBuffer.append(TEXT_80);
    lesser(columnName);
    stringBuffer.append(TEXT_81);
    
            }else if(typeToGenerate.equals("java.util.Date")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_82);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_88);
    greater(columnName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_90);
    lesser(columnName);
    stringBuffer.append(TEXT_91);
    
                }else{
                
    stringBuffer.append(TEXT_92);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_96);
    greater(columnName);
    stringBuffer.append(TEXT_97);
    lesser(columnName);
    stringBuffer.append(TEXT_98);
    
                }
            }else if(typeToGenerate.equalsIgnoreCase("Double")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_99);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_103);
    greater(columnName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_105);
    lesser(columnName);
    stringBuffer.append(TEXT_106);
    
                }else{
                
    stringBuffer.append(TEXT_107);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_109);
    greater(columnName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_112);
    lesser(columnName);
    stringBuffer.append(TEXT_113);
    
                }
            }else if(typeToGenerate.equalsIgnoreCase("Float")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_114);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_118);
    greater(columnName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_120);
    lesser(columnName);
    stringBuffer.append(TEXT_121);
    
                }else{
                
    stringBuffer.append(TEXT_122);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_124);
    greater(columnName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_127);
    lesser(columnName);
    stringBuffer.append(TEXT_128);
    
                }
            }else if(typeToGenerate.equals("BigDecimal")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_129);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_132);
    
                }else{
                
    stringBuffer.append(TEXT_133);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_136);
    }
    stringBuffer.append(TEXT_137);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_138);
    greater(columnName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_140);
    lesser(columnName);
    stringBuffer.append(TEXT_141);
    
            }else if(typeToGenerate.equalsIgnoreCase("Integer") || typeToGenerate.equalsIgnoreCase("int")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_142);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_146);
    greater(columnName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_148);
    lesser(columnName);
    stringBuffer.append(TEXT_149);
    
                }else{
                
    stringBuffer.append(TEXT_150);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_152);
    greater(columnName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_155);
    lesser(columnName);
    stringBuffer.append(TEXT_156);
    
                }
            }else if(typeToGenerate.equalsIgnoreCase("Long")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_157);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_161);
    greater(columnName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_163);
    lesser(columnName);
    stringBuffer.append(TEXT_164);
    
            }else{
            
    stringBuffer.append(TEXT_165);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_167);
    greater(columnName);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_170);
    lesser(columnName);
    stringBuffer.append(TEXT_171);
    
            }
        }else if(typeToGenerate.equals("Object")){
        
    stringBuffer.append(TEXT_172);
    stringBuffer.append(columnNameToGenerate);
    
        }else if(typeToGenerate.equalsIgnoreCase("Short")){
        
    
            if(!sortTypes.get(columnName)){
            
    stringBuffer.append(TEXT_173);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_177);
    greater(columnName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_179);
    lesser(columnName);
    stringBuffer.append(TEXT_180);
    
            }else{
            
    stringBuffer.append(TEXT_181);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_183);
    greater(columnName);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_186);
    lesser(columnName);
    stringBuffer.append(TEXT_187);
    
            }
        }else if(typeToGenerate.equals("String")){
        
    stringBuffer.append(TEXT_188);
    stringBuffer.append(columnIterator);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(columnIterator);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(columnIterator);
    stringBuffer.append(TEXT_193);
    greater(columnName);
    stringBuffer.append(TEXT_194);
    lesser(columnName);
    stringBuffer.append(TEXT_195);
    
        }else if(typeToGenerate.equals("List")){
        
    stringBuffer.append(TEXT_196);
    stringBuffer.append(columnNameToGenerate);
    
        }else if(typeToGenerate.equals("Doucument")){
        
    stringBuffer.append(TEXT_197);
    stringBuffer.append(columnNameToGenerate);
    
        }else if(typeToGenerate.equals("Dynamic")){
        
    stringBuffer.append(TEXT_198);
    stringBuffer.append(columnNameToGenerate);
    
        }
        
    if(nullable){
    stringBuffer.append(TEXT_199);
    
        }
    }


}

    
final SparkRowTransformUtil sparkTransformUtil = new SparkRowTransformUtil();
final TTopUtil tTopUtil = new TTopUtil(node, codeGenArgument, sparkTransformUtil);

java.util.Map<String, java.util.List<org.talend.core.model.metadata.IMetadataColumn>> keyList = bigDataNode.getKeyList();
org.talend.designer.spark.generator.SparkFunction sparkFunction = new org.talend.designer.spark.generator.TopFunction(false, keyList);

String topX = ElementParameterParser.getValue(node, "__TOP__");

sparkTransformUtil.generateSparkConfig(tTopUtil, sparkFunction, topX);

    stringBuffer.append(TEXT_200);
    stringBuffer.append(TEXT_201);
    return stringBuffer.toString();
  }
}
