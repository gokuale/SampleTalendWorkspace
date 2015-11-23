package org.talend.designer.codegen.translators.processing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TAvroMapSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TAvroMapSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAvroMapSparkstreamingconfigJava result = new TAvroMapSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "                ";
  protected final String TEXT_2 = "<NullWritable, ";
  protected final String TEXT_3 = "> rdd_";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL + "        ";
  protected final String TEXT_6 = " sdfContext =" + NL + "                new ";
  protected final String TEXT_7 = ".Builder()" + NL + "                        .";
  protected final String TEXT_8 = "(ctx)" + NL + "                        .build();";
  protected final String TEXT_9 = NL + "        ";
  protected final String TEXT_10 = " sdf = new ";
  protected final String TEXT_11 = "(sdfContext);";
  protected final String TEXT_12 = NL + "                sdf.put(\"";
  protected final String TEXT_13 = "\", rdd_";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "                    rdd_";
  protected final String TEXT_16 = " = sdf.";
  protected final String TEXT_17 = "(\"";
  protected final String TEXT_18 = "\");";
  protected final String TEXT_19 = NL + "        public static class Filter_";
  protected final String TEXT_20 = "_";
  protected final String TEXT_21 = NL + "                extends org.talend.bigdata.dataflow.hmap.HMapContextConfigurableBase" + NL + "                implements org.talend.bigdata.dataflow.hmap.filter.Condition<";
  protected final String TEXT_22 = "> {" + NL + "" + NL + "            /** Default serial version UID. */" + NL + "            private static final long serialVersionUID = 1L;" + NL + "" + NL + "            /** The context at the time this was created. */" + NL + "            private final ContextProperties context;" + NL + "" + NL + "            Filter_";
  protected final String TEXT_23 = "_";
  protected final String TEXT_24 = "(ContextProperties context) {" + NL + "                this.context = context;" + NL + "            }" + NL + "" + NL + "            public boolean evaluate(";
  protected final String TEXT_25 = " ";
  protected final String TEXT_26 = ") {" + NL + "                return ";
  protected final String TEXT_27 = ";" + NL + "            }" + NL + "        }";
  protected final String TEXT_28 = NL + "        public static class Filter_";
  protected final String TEXT_29 = "_";
  protected final String TEXT_30 = NL + "                extends org.talend.bigdata.dataflow.hmap.HMapContextConfigurableBase" + NL + "                implements org.talend.bigdata.dataflow.hmap.filter.Condition<";
  protected final String TEXT_31 = "> {" + NL + "" + NL + "            /** Default serial version UID. */" + NL + "            private static final long serialVersionUID = 1L;" + NL + "" + NL + "            /** The context at the time this was created. */" + NL + "            private final ContextProperties context;" + NL;
  protected final String TEXT_32 = NL + NL + "            Filter_";
  protected final String TEXT_33 = "_";
  protected final String TEXT_34 = "(ContextProperties context) {" + NL + "                this.context = context;" + NL + "            }" + NL + "" + NL + "            public boolean evaluate(";
  protected final String TEXT_35 = " ";
  protected final String TEXT_36 = ") {";
  protected final String TEXT_37 = NL + "                    ";
  protected final String TEXT_38 = " ";
  protected final String TEXT_39 = " = getInputRecord(\"";
  protected final String TEXT_40 = "\");" + NL + "                    if (null == ";
  protected final String TEXT_41 = ")";
  protected final String TEXT_42 = NL + "                        ";
  protected final String TEXT_43 = " = new ";
  protected final String TEXT_44 = "();";
  protected final String TEXT_45 = NL + NL + "                return ";
  protected final String TEXT_46 = ";" + NL + "            }" + NL + "        }";
  protected final String TEXT_47 = NL + "        public static class PostProcessor_";
  protected final String TEXT_48 = "_";
  protected final String TEXT_49 = NL + "                extends org.talend.bigdata.dataflow.hmap.HMapContextConfigurableBase" + NL + "                implements org.talend.bigdata.dataflow.hmap.PostProcessor<";
  protected final String TEXT_50 = "> {" + NL + "" + NL + "            /** Default serial version UID. */" + NL + "            private static final long serialVersionUID = 1L;" + NL + "" + NL + "            /** The context at the time this was created. */" + NL + "            private final ContextProperties context;" + NL;
  protected final String TEXT_51 = NL + NL + "            PostProcessor_";
  protected final String TEXT_52 = "_";
  protected final String TEXT_53 = "(ContextProperties context) {" + NL + "                this.context = context;" + NL + "            }" + NL + "" + NL + "            public void postProcess(";
  protected final String TEXT_54 = " ";
  protected final String TEXT_55 = ") {";
  protected final String TEXT_56 = NL + "                    ";
  protected final String TEXT_57 = " ";
  protected final String TEXT_58 = " = getInputRecord(\"";
  protected final String TEXT_59 = "\");" + NL + "                    if (null == ";
  protected final String TEXT_60 = ")";
  protected final String TEXT_61 = NL + "                        ";
  protected final String TEXT_62 = " = new ";
  protected final String TEXT_63 = "();";
  protected final String TEXT_64 = NL + "                ";
  protected final String TEXT_65 = NL + "            }" + NL + "        }";
  protected final String TEXT_66 = NL + "        public static class JoinKeyProcessor_";
  protected final String TEXT_67 = "_";
  protected final String TEXT_68 = NL + "                extends org.talend.bigdata.dataflow.hmap.HMapContextConfigurableBase" + NL + "                implements org.talend.bigdata.dataflow.hmap.PostProcessor<org.apache.avro.generic.IndexedRecord> {" + NL + "" + NL + "            /** Default serial version UID. */" + NL + "            private static final long serialVersionUID = 1L;" + NL + "" + NL + "            /** The context at the time this was created. */" + NL + "            private final ContextProperties context;" + NL + "" + NL + "            JoinKeyProcessor_";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = "(ContextProperties context) {" + NL + "                this.context = context;" + NL + "            }" + NL + "" + NL + "            public void postProcess(org.apache.avro.generic.IndexedRecord joinKey) {";
  protected final String TEXT_71 = NL + "                ";
  protected final String TEXT_72 = " ";
  protected final String TEXT_73 = " = getInputRecord(\"";
  protected final String TEXT_74 = "\");";
  protected final String TEXT_75 = NL + "                    joinKey.put(";
  protected final String TEXT_76 = ", ";
  protected final String TEXT_77 = ");";
  protected final String TEXT_78 = NL + "            }" + NL + "        }";
  protected final String TEXT_79 = NL + "        static class ";
  protected final String TEXT_80 = " implements java.io.Serializable {" + NL + "            private static final long serialVersionUID = 1L;";
  protected final String TEXT_81 = NL + "                ";
  protected final String TEXT_82 = " ";
  protected final String TEXT_83 = ";";
  protected final String TEXT_84 = NL + "        }";
  protected final String TEXT_85 = NL + "        ";
  protected final String TEXT_86 = " ";
  protected final String TEXT_87 = " = new ";
  protected final String TEXT_88 = "();";
  protected final String TEXT_89 = NL + "            ";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = " = ";
  protected final String TEXT_92 = ";";
  protected final String TEXT_93 = NL + "{" + NL + "    // Set up a Spark DataFlow with all of the input datasets necessary to use this component.";
  protected final String TEXT_94 = NL;
  protected final String TEXT_95 = NL + "    ";
  protected final String TEXT_96 = NL;
  protected final String TEXT_97 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    
/**
 * Helper class for adapting information from TMapAdapter to spark code and config
 * structures.  This provides code generation utility methods that are
 * completely spark-specific.
 */
class TMapSparkUtil extends org.talend.designer.common.tmap.TMapUtil {

    TMapSparkUtil(BigDataCodeGeneratorArgument argument, String componentType) {
        super(argument, componentType);
    }

    protected TMapSparkUtil(BigDataCodeGeneratorArgument argument, String componentType,
            org.talend.designer.common.tmap.TMapAdapter adapter) {
        super(argument, componentType, adapter);
    }

    protected TMapSparkUtil create(BigDataCodeGeneratorArgument argument, String componentType,
            org.talend.designer.common.tmap.TMapAdapter adapter) {
        return new TMapSparkUtil(argument, componentType, adapter);
    }

    public void generateConfigOutputVariablesDeclaration() {
        for (String name : tMapAdapter.getOutputNames()) {
            if (tMapAdapter.isOutputConnected(name) && !tMapAdapter.isOutputLinkedSource(name)) {
                
    stringBuffer.append(TEXT_1);
    stringBuffer.append(sparkVars.getSparkDatasetClassName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(codeGenArgument.getRecordStructName(name));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_4);
    
            }
        }
    }

    public void generateConfigInitDataflow() {
        
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sparkVars.getSparkDataFlowContextName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(sparkVars.getSparkDataFlowContextName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(sparkVars.getSparkWithContextMethodName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(sparkVars.getSparkDataFlowName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(sparkVars.getSparkDataFlowName());
    stringBuffer.append(TEXT_11);
    
        // Only non-pull input sources are going to be in the context before
        // this component is initialized.
        String mainName = tMapAdapter.getInputMainName();
        for (String name : tMapAdapter.getInputNames()) {
            String inputMode = tMapAdapter.getInputMode(name);
            if (mainName.equals(name) || org.talend.designer.common.tmap.TMapAdapter.INPUT_MODE_NORMAL.equals(inputMode)) {
                
    stringBuffer.append(TEXT_12);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_14);
    
            }
        }
    }

    public void generateConfigOutputVariablesInitialization() {
        for (String name : tMapAdapter.getOutputNames()) {
            if (tMapAdapter.isOutputConnected(name) && !tMapAdapter.isOutputLinkedSource(name)) {
                
    stringBuffer.append(TEXT_15);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(sparkVars.getSparkGetDatasetMethodName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_18);
    
            }
        }
    }

    protected void generateCodeInputFilterCondition(String name, String expr) {
        // Ignore this method call when there isn't any filter condition.
        if (expr == null)
            return;

        String inRecordStruct = argument.getRecordStructName(name);
        
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(inRecordStruct);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(inRecordStruct);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(expr);
    stringBuffer.append(TEXT_27);
    
    }

    protected void generateCodeOutputFilterCondition(String name, String expr) {
        // Ignore this method call when there isn't any filter condition.
        if (expr == null)
            return;

        String outRecordStruct = getOutputRecordStruct(name);
        
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(outRecordStruct);
    stringBuffer.append(TEXT_31);
    
            for (String varName : tMapAdapter.getVarNames()) {
                generateCodeVarsTableDeclaration(varName);
            }
            
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(outRecordStruct);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_36);
    
                for (String inputName : tMapAdapter.getInputNames()) {
                    
    stringBuffer.append(TEXT_37);
    stringBuffer.append(argument.getRecordStructName(inputName));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(inputName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(inputName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(inputName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(inputName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(argument.getRecordStructName(inputName));
    stringBuffer.append(TEXT_44);
    
                }
                for (String varName : tMapAdapter.getVarNames()) {
                    generateCodeVarsTableInitialization(varName);
                }
                
    stringBuffer.append(TEXT_45);
    stringBuffer.append(expr);
    stringBuffer.append(TEXT_46);
    
    }

    protected void generateCodeOutputPostProcessor(String name) {
        // Ignore this method call when there isn't any postprocess expression.
        if (postProcessExpressions.length() == 0)
            return;

        String outRecordStruct = getOutputRecordStruct(name);

        
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(outRecordStruct);
    stringBuffer.append(TEXT_50);
    
            for (String varName : tMapAdapter.getVarNames()) {
                generateCodeVarsTableDeclaration(varName);
            }
            
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(outRecordStruct);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_55);
    
                for (String inputName : tMapAdapter.getInputNames()) {
                    
    stringBuffer.append(TEXT_56);
    stringBuffer.append(argument.getRecordStructName(inputName));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(inputName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(inputName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(inputName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(inputName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(argument.getRecordStructName(inputName));
    stringBuffer.append(TEXT_63);
    
                }
                for (String varName : tMapAdapter.getVarNames()) {
                    generateCodeVarsTableInitialization(varName);
                }
                
    stringBuffer.append(TEXT_64);
    stringBuffer.append(postProcessExpressions);
    stringBuffer.append(TEXT_65);
    
        // Reset any existing expressions.
        postProcessExpressions.setLength(0);
    }

    protected void generateCodeOutputJoinKeyProcessor(String name) {
        String recordStruct = argument.getRecordStructName(name);

        
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_74);
    
                String[] joinKeyExpressions = tMapAdapter.getJoinExpressions(name);
                for (int i = 0; i < joinKeyExpressions.length; i++) {
                    
    stringBuffer.append(TEXT_75);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(joinKeyExpressions[i]);
    stringBuffer.append(TEXT_77);
    
                }
                
    stringBuffer.append(TEXT_78);
    
    }

    protected void generateCodeVarsStruct(String name) {
        String[][] contents = tMapAdapter.getTableContents(name);
        if (contents == null || contents.length == 0) {
            return;
        }
        String instanceVarName = name + "__" + cid;
        String className = instanceVarName + "__Struct";
        
    stringBuffer.append(TEXT_79);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_80);
    
            for (int i = 0; i < contents.length; i++) {
                String javaType = tMapAdapter.getVarJavaType(contents[i]);
                boolean isNullable = tMapAdapter.isVarNullable(contents[i]);
                
    stringBuffer.append(TEXT_81);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(javaType, isNullable));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(contents[i][0]);
    stringBuffer.append(TEXT_83);
    
            }
            
    stringBuffer.append(TEXT_84);
    
    }

    protected void generateCodeVarsTableDeclaration(String name) {
        String[][] contents = tMapAdapter.getTableContents(name);
        if (contents == null || contents.length == 0) {
            return;
        }
        String instanceVarName = name + "__" + cid;
        String className = instanceVarName + "__Struct";
        
    stringBuffer.append(TEXT_85);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_88);
    
    }

    protected void generateCodeVarsTableInitialization(String name) {
        String[][] contents = tMapAdapter.getTableContents(name);
        if (contents == null || contents.length == 0) {
            return;
        }
        String instanceVarName = name + "__" + cid;
        String className = instanceVarName + "__Struct";
        for (int i = 0; i < contents.length; i++) {
            String varExpression = contents[i][1];
            if (varExpression == null) {
                varExpression = JavaTypesManager.getDefaultValueFromJavaIdType(
                        tMapAdapter.getVarJavaType(contents[i]),
                        tMapAdapter.isVarNullable(contents[i]));
            }
            
    stringBuffer.append(TEXT_89);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(contents[i][0]);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(varExpression);
    stringBuffer.append(TEXT_92);
    
        }
    }
}

    
org.talend.designer.common.tmap.TMapUtil tMapUtil =
        new TMapSparkUtil(codeGenArgument, node.getComponent().getType());

String validateError = tMapUtil.validateTMapConfig();
if (validateError != null) {
    // Cause the job compilation to explicitly fail if there is a problem.
    return "throw new JobConfigurationError(\"" + validateError +"\");";
}

// Give the tMap component the opportunity to create all of the helper classes
// that it needs to function.
tMapUtil.generateAuxiliaryRecordStructs();

// In the config context, declare the output data variables that the next component
// expects.
tMapUtil.generateConfigOutputVariablesDeclaration();

// Open a new context for the component so no local variables leak into others.

    stringBuffer.append(TEXT_93);
     tMapUtil.generateConfigInitDataflow(); 
    stringBuffer.append(TEXT_94);
    stringBuffer.append(TEXT_95);
    stringBuffer.append( tMapUtil.getConfigBuildComponent() );
    stringBuffer.append(TEXT_96);
    
    // Initialize the output variables for the next component.
    tMapUtil.generateConfigOutputVariablesInitialization();
    
    stringBuffer.append(TEXT_97);
    return stringBuffer.toString();
  }
}
