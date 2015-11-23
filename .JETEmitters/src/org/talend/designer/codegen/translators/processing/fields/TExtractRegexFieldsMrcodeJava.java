package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.NodeUtil;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TExtractRegexFieldsMrcodeJava
{
  protected static String nl;
  public static synchronized TExtractRegexFieldsMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractRegexFieldsMrcodeJava result = new TExtractRegexFieldsMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\t";
  protected final String TEXT_3 = NL + "\t\t\toutput_";
  protected final String TEXT_4 = ".collect(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ");" + NL + "\t\t";
  protected final String TEXT_7 = NL + "\t\t\tpublic static class ";
  protected final String TEXT_8 = " extends MapReduceBase" + NL + "\t\t\t\timplements Mapper<";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ", ";
  protected final String TEXT_11 = ", ";
  protected final String TEXT_12 = ">{" + NL + "" + NL + "\t\t\t\tContextProperties context;" + NL + "\t\t\t\tGlobalVar globalMap;" + NL + "\t\t\t\t";
  protected final String TEXT_13 = " ";
  protected final String TEXT_14 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t";
  protected final String TEXT_16 = " ";
  protected final String TEXT_17 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t";
  protected final String TEXT_19 = NL + NL + "\t\t\t\tpublic void configure(JobConf job_";
  protected final String TEXT_20 = "){" + NL + "\t\t\t\t\tcontext = new ContextProperties(job_";
  protected final String TEXT_21 = ");" + NL + "\t\t\t\t\tglobalMap = new GlobalVar(job_";
  protected final String TEXT_22 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_24 = " = NullWritable.get();" + NL + "\t\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_26 = " = new ";
  protected final String TEXT_27 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_30 = " = new ";
  protected final String TEXT_31 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t";
  protected final String TEXT_33 = NL + "  \t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic void map(";
  protected final String TEXT_34 = " key_";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = " value_";
  protected final String TEXT_37 = "," + NL + "\t\t\t\t\tOutputCollector<";
  protected final String TEXT_38 = ", ";
  protected final String TEXT_39 = "> output_";
  protected final String TEXT_40 = ", Reporter reporter_";
  protected final String TEXT_41 = ") throws IOException{" + NL + "\t\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic void close() throws IOException{" + NL + "\t\t\t\t\t";
  protected final String TEXT_43 = NL + "  \t\t\t\t}" + NL + "    \t\t}" + NL + "    \t";
  protected final String TEXT_44 = NL + "\t\t\t\tChainReducer.addMapper(job, ";
  protected final String TEXT_45 = ".class, ";
  protected final String TEXT_46 = ".class," + NL + "\t        \t\t";
  protected final String TEXT_47 = ".class, ";
  protected final String TEXT_48 = ".class, ";
  protected final String TEXT_49 = ".class, true, new JobConf(false));" + NL + "\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\tchainMapper.addMapper(job, ";
  protected final String TEXT_51 = ".class, ";
  protected final String TEXT_52 = ".class," + NL + "\t        \t\t";
  protected final String TEXT_53 = ".class, ";
  protected final String TEXT_54 = ".class, ";
  protected final String TEXT_55 = ".class, true, new JobConf(false));" + NL + "\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\tchainMapper.setCid(\"";
  protected final String TEXT_57 = "\");" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\tmos_";
  protected final String TEXT_59 = ".getCollector(\"";
  protected final String TEXT_60 = "\", reporter_";
  protected final String TEXT_61 = ").collect(";
  protected final String TEXT_62 = ", ";
  protected final String TEXT_63 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\tpublic static class ";
  protected final String TEXT_65 = " extends MapReduceBase" + NL + "\t\t\t\timplements Mapper<";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = ", ";
  protected final String TEXT_68 = ", WritableComparable>{" + NL + "\t\t\t\tContextProperties context;" + NL + "\t\t\t\tGlobalVar globalMap;" + NL + "\t\t\t\tpublic MultipleOutputs mos_";
  protected final String TEXT_69 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_70 = " ";
  protected final String TEXT_71 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_73 = " ";
  protected final String TEXT_74 = " = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\t\t";
  protected final String TEXT_76 = NL + NL + "\t\t\t\tpublic void configure(JobConf job_";
  protected final String TEXT_77 = "){" + NL + "\t\t\t\t\tcontext = new ContextProperties(job_";
  protected final String TEXT_78 = ");" + NL + "\t\t\t\t\tglobalMap = new GlobalVar(job_";
  protected final String TEXT_79 = ");" + NL + "\t\t\t\t\tmos_";
  protected final String TEXT_80 = " = new MultipleOutputs(job_";
  protected final String TEXT_81 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_83 = " = NullWritable.get();" + NL + "\t\t\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_85 = " = new ";
  protected final String TEXT_86 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_89 = " = new ";
  protected final String TEXT_90 = "();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\t\t";
  protected final String TEXT_92 = NL + "  \t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic void map(";
  protected final String TEXT_93 = " key_";
  protected final String TEXT_94 = ", ";
  protected final String TEXT_95 = " value_";
  protected final String TEXT_96 = "," + NL + "\t\t\t\t\tOutputCollector<";
  protected final String TEXT_97 = ", WritableComparable> output_";
  protected final String TEXT_98 = ", Reporter reporter_";
  protected final String TEXT_99 = ") throws IOException{" + NL + "\t\t\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tpublic void close() throws IOException{" + NL + "\t\t\t\t\tmos_";
  protected final String TEXT_101 = ".close();" + NL + "\t\t\t\t\t";
  protected final String TEXT_102 = NL + "  \t\t\t\t}" + NL + "    \t\t}" + NL + "    \t";
  protected final String TEXT_103 = NL + "\t\t\t\tChainReducer.addMapper(job, ";
  protected final String TEXT_104 = ".class, ";
  protected final String TEXT_105 = ".class," + NL + "\t        \t\t";
  protected final String TEXT_106 = ".class, ";
  protected final String TEXT_107 = ".class, WritableComparable.class, true, new JobConf(false));" + NL + "\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t\tchainMapper.addMapper(job, ";
  protected final String TEXT_109 = ".class, ";
  protected final String TEXT_110 = ".class," + NL + "\t        \t\t";
  protected final String TEXT_111 = ".class, ";
  protected final String TEXT_112 = ".class, WritableComparable.class, true, new JobConf(false));" + NL + "\t\t\t";
  protected final String TEXT_113 = NL + "        \tMultipleOutputs.setWorkDir(job, genTempFolderForComponent(\"MultipleOutputs_";
  protected final String TEXT_114 = "\"));" + NL + "        \t";
  protected final String TEXT_115 = NL + "\t\t\t\tMultipleOutputs.setKeyValue(job, \"";
  protected final String TEXT_116 = "\", ";
  protected final String TEXT_117 = ".class, ";
  protected final String TEXT_118 = ".class);" + NL + "        \t";
  protected final String TEXT_119 = NL + "            // No mrcode generated for unnecessary ";
  protected final String TEXT_120 = NL + "                ";
  protected final String TEXT_121 = " ";
  protected final String TEXT_122 = " = value_";
  protected final String TEXT_123 = ";";
  protected final String TEXT_124 = NL + "            // No mrconfig generated for unnecessary ";
  protected final String TEXT_125 = NL + "        chainMapper.addMapper(job, ";
  protected final String TEXT_126 = "," + NL + "                NullWritable.class, ";
  protected final String TEXT_127 = "Struct.class," + NL + "                NullWritable.class, ";
  protected final String TEXT_128 = "Struct.class," + NL + "                            true, new JobConf(false));" + NL;
  protected final String TEXT_129 = NL + "            MultipleOutputs.setWorkDir(job," + NL + "                    genTempFolderForComponent(\"";
  protected final String TEXT_130 = "\"));" + NL + "            MultipleOutputs.setKeyValue(job, \"";
  protected final String TEXT_131 = "\"," + NL + "                    NullWritable.class, ";
  protected final String TEXT_132 = "Struct.class);";
  protected final String TEXT_133 = NL + "        /** Declare the input regex and define it after the context initialization */" + NL + "        java.util.regex.Pattern pattern = null;";
  protected final String TEXT_134 = NL + "        if(pattern == null){" + NL + "            pattern = java.util.regex.Pattern.compile(";
  protected final String TEXT_135 = ");" + NL + "        }";
  protected final String TEXT_136 = NL + "        if (";
  protected final String TEXT_137 = " == null)" + NL + "            return";
  protected final String TEXT_138 = ";" + NL + "" + NL + "        java.util.regex.Matcher matcher = pattern.matcher(";
  protected final String TEXT_139 = NL + "                ";
  protected final String TEXT_140 = ");";
  protected final String TEXT_141 = NL + "            // It's an error condition if the input field is non-null but has no match." + NL + "            if (!matcher.find()) {";
  protected final String TEXT_142 = NL + "            }" + NL + "            matcher.reset();";
  protected final String TEXT_143 = NL + NL + "        // Look for every possible match in the row." + NL + "        while (matcher.find()) {" + NL + "            try {" + NL + "                String valueAsString = null;" + NL + "                int groupCount = matcher.groupCount();";
  protected final String TEXT_144 = NL + "                    // Ensure that there is exactly the right number of matches from" + NL + "                    if (groupCount < ";
  protected final String TEXT_145 = ") {" + NL + "                        throw new RuntimeException(\"Column(s) missing\");" + NL + "                    } else if (groupCount > ";
  protected final String TEXT_146 = ") {" + NL + "                        throw new RuntimeException(\"Too many columns\");" + NL + "                    }";
  protected final String TEXT_147 = NL + "                    valueAsString = groupCount <= ";
  protected final String TEXT_148 = "? \"\" : matcher.group(";
  protected final String TEXT_149 = ");";
  protected final String TEXT_150 = NL + "                    ";
  protected final String TEXT_151 = NL + "                    ";
  protected final String TEXT_152 = NL + "                ";
  protected final String TEXT_153 = NL + "            } catch (RuntimeException ex) {";
  protected final String TEXT_154 = NL + "            }" + NL + "        }";
  protected final String TEXT_155 = NL + "            ";
  protected final String TEXT_156 = NL + "            // Die immediately on errors." + NL + "            throw new IOException(";
  protected final String TEXT_157 = ");";
  protected final String TEXT_158 = NL + "                // Ignore errors processing this row and move to the next.";
  protected final String TEXT_159 = NL + "                // Send error rows to the reject output.";
  protected final String TEXT_160 = NL + "                ";
  protected final String TEXT_161 = NL + "                    ";
  protected final String TEXT_162 = NL + "                ";
  protected final String TEXT_163 = NL + "                ";
  protected final String TEXT_164 = NL + "            ";
  protected final String TEXT_165 = NL + "            if (valueAsString.length() > 0) {";
  protected final String TEXT_166 = NL + "                    ";
  protected final String TEXT_167 = NL + "                    ";
  protected final String TEXT_168 = NL + "                    ";
  protected final String TEXT_169 = NL + "            } else {";
  protected final String TEXT_170 = NL + "                    throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_171 = "' in '";
  protected final String TEXT_172 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_173 = NL + "                    ";
  protected final String TEXT_174 = NL + "            }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
	//need to define MapperHelper before MapperGenerator, so use this trick
	class MapperHelperBase{
		public void map(){
		}

		public void prepare(){
		}

		public void configure(){
		}

		public void close(){
		}
	}

	class MapperGenerator{
		MapperHelperBase mapper;

		org.talend.core.model.process.AbstractNode node = null;
		String cid = null;
		String mapperClass = null;

		Object inKey = null;
		Object inKeyClass = null;

		Object inValue = null;
		Object inValueClass = null;

		Object outKey = null;
		Object outKeyClass = null;

		Object outValue = null;
		Object outValueClass = null;

		public MapperGenerator(MapperHelperBase mapper){
			this.mapper = mapper;
		}

		public void init(INode node, String cid, Object inKey, Object inValue, Object outKey, Object outValue){
			this.node = (org.talend.core.model.process.AbstractNode)node;
			this.cid = cid;
			this.inKey = (inKey == null ? "key_"+cid : inKey);
			this.inValue = (inValue == null ? "value_"+cid : inValue);
			this.outKey = (outKey == null ? "outputKey_"+cid : outKey);
			this.outValue = (outValue == null ? "outputValue_"+cid : outValue);
			this.mapperClass = buildClassName(cid, "m");
			this.inKeyClass = buildClassName(inKey, "row");
			this.inValueClass = buildClassName(inValue, "row");
			this.outKeyClass = buildClassName(outKey, "row");
			this.outValueClass = buildClassName(outValue, "row");
		}

		private String buildClassName(String name, String type){
			if(type.equals("m")){
				return name + "Mapper";
			}else if(type.equals("r")){
				return name + "Reducer";
			}else if(type.equals("row")){
				return name + "Struct";
			}else{
				return null;
			}
		}

		private Object buildClassName(Object name, String type){
			if(type.equals("row")){
				if(name instanceof java.util.Map){
					java.util.Map<String, String> classes = new java.util.HashMap<String, String>();
					java.util.Map<String, String> names = (java.util.Map<String, String>)name;
					for(String key : names.keySet()){
						classes.put(key, buildClassName(names.get(key), "row"));
					}
					return classes;
				}else if(name instanceof String){
					return buildClassName(name.toString(), "row");
				}else if(name == null){
					return "NullWritable";
				}
			}
			return null;
		}

		public String getInKeyClass(String name){
			if(inKeyClass instanceof java.util.Map){
				return ((java.util.Map<String, String>)inKeyClass).get(name);
			}
			return getInKeyClass();
		}

		public String getInKeyClass(){
			if(inKeyClass instanceof String){
				return inKeyClass.toString();
			}else{
				System.err.println("not single, wrong call");
				return null;
			}
		}

		public String getInKey(String name){
			if(inKey instanceof java.util.Map){
				return ((java.util.Map<String, String>)inKey).get(name);
			}
			return getInKey();
		}

		public String getInKey(){
			if(inKey instanceof String){
				return inKey.toString();
			}else{
				System.err.println("not single, wrong call");
				return null;
			}
		}

		public String getOutKeyClass(String name){
			if(outKeyClass instanceof java.util.Map){
				return ((java.util.Map<String, String>)outKeyClass).get(name);
			}
			return getOutKeyClass();
		}

		public String getOutKeyClass(){
			if(outKeyClass instanceof String){
				return outKeyClass.toString();
			}else{
				System.err.println("not single, wrong call");
				return null;
			}
		}

		public String getOutKey(String name){
			if(outKey instanceof java.util.Map){
				return ((java.util.Map<String, String>)outKey).get(name);
			}
			return getOutKey();
		}

		public String getOutKey(){
			if(outKey instanceof String){
				return outKey.toString();
			}else{
				System.err.println("not single, wrong call");
				return null;
			}
		}

		public String getInValueClass(String name){
			if(inValueClass instanceof java.util.Map){
				return ((java.util.Map<String, String>)inValueClass).get(name);
			}
			return getInValueClass();
		}

		public String getInValueClass(){
			if(inValueClass instanceof String){
				return inValueClass.toString();
			}else{
				System.err.println("not single, wrong call");
				return null;
			}
		}

		public String getInValue(String name){
			if(inValue instanceof java.util.Map){
				return ((java.util.Map<String, String>)inValue).get(name);
			}
			return getInValue();
		}

		public String getInValue(){
			if(inValue instanceof String){
				return inValue.toString();
			}else{
				System.err.println("not single, wrong call");
				return null;
			}
		}

		public String getOutValueClass(String name){
			if(outValueClass instanceof java.util.Map){
				return ((java.util.Map<String, String>)outValueClass).get(name);
			}
			return getOutValueClass();
		}

		public String getOutValueClass(){
			if(outValueClass instanceof String){
				return outValueClass.toString();
			}else{
				System.err.println("not single, wrong call");
				return null;
			}
		}

		public String getOutValue(String name){
			if(outValue instanceof java.util.Map){
				return ((java.util.Map<String, String>)outValue).get(name);
			}
			return getOutValue();
		}

		public String getOutValue(){
			if(outValue instanceof String){
				return outValue.toString();
			}else{
				System.err.println("not single, wrong call");
				return null;
			}
		}

		public void output(String outKey, String outValue){
			outKey = (outKey == null ? "outputKey_"+cid : outKey);
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(outValue);
    stringBuffer.append(TEXT_6);
    
		}

		public String getCodeEmit(String outKey, String outValue) {
			return "output_" + cid + ".collect("
					+ (outKey == null ? "outputKey_"+cid : outKey) + ","
					+ outValue + ");";
		}

		public void generate(){
		
    stringBuffer.append(TEXT_7);
    stringBuffer.append(mapperClass);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_14);
    if(!outKey.equals(outValue)){//for tFindQuantiles, if outKey same as outValue, assume the write want to reuse same object
    stringBuffer.append(TEXT_15);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(outValue);
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    mapper.prepare();
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    if("NullWritable".equals(outKeyClass)){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_24);
    }else{
    stringBuffer.append(TEXT_25);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    if(!outKey.equals(outValue)){
    stringBuffer.append(TEXT_29);
    stringBuffer.append(outValue);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    mapper.configure();
    stringBuffer.append(TEXT_33);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    mapper.map();
    stringBuffer.append(TEXT_42);
    mapper.close();
    stringBuffer.append(TEXT_43);
    
		}
		public void generateConf(){
			if(node.isMapOnlyAfterReduce()){
			
    stringBuffer.append(TEXT_44);
    stringBuffer.append(mapperClass);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_49);
    
			}else{
			
    stringBuffer.append(TEXT_50);
    stringBuffer.append(mapperClass);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_55);
    
			}
		}

		public void generateConf(org.talend.core.model.process.IConnection inConn){
			String startNodeCid = inConn.getSource().getSubProcessStartNode(false).getUniqueName();
			
    stringBuffer.append(TEXT_56);
    stringBuffer.append(startNodeCid);
    stringBuffer.append(TEXT_57);
    
			generateConf();
		}
	}

	class MOMapperGenerator extends MapperGenerator{

		/** The single connection to pass along the output chain of Mappers
		 *  instead of sending to a dedicated collector via MultipleOutputs. */
		String connectionToChain = null;

		public MOMapperGenerator(MapperHelperBase mapper){
			super(mapper);
		}

		public void sendOutConnectionToChain(String name) {
			connectionToChain = getOutValue(name);
		}

		public void output(String outKey, String outValue){
			outKey = (outKey == null ? "outputKey_"+cid : outKey);
			if (outValue != null && outValue.equals(connectionToChain))
				super.output(outKey, outValue);
			else {
				
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(outValue);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(outValue);
    stringBuffer.append(TEXT_63);
    
			}
		}

		public String getCodeEmit(String outKey, String outValue) {
			if (outValue != null && outValue.equals(connectionToChain))
				return super.getCodeEmit(outKey, outValue);
			else
				return "mos_" + cid + ".getCollector(\"" + outValue
						+ "\", reporter_"+ cid + ")"+ ".collect("
						+ (outKey == null ? "outputKey_"+cid : outKey) + ","
						+ outValue + ");";
		}

		public void generate(){
		
    stringBuffer.append(TEXT_64);
    stringBuffer.append(mapperClass);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_71);
    
				if(outValueClass instanceof java.util.Map){
					for(String key : ((java.util.Map<String, String>)outValueClass).keySet()){
					
    stringBuffer.append(TEXT_72);
    stringBuffer.append(((java.util.Map)outValueClass).get(key));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(((java.util.Map)outValue).get(key));
    stringBuffer.append(TEXT_74);
    
					}
				}
				
    stringBuffer.append(TEXT_75);
    mapper.prepare();
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    if("NullWritable".equals(outKeyClass)){
    stringBuffer.append(TEXT_82);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_83);
    }else{
    stringBuffer.append(TEXT_84);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_86);
    }
    stringBuffer.append(TEXT_87);
    
					if(outValueClass instanceof java.util.Map){
						for(String key : ((java.util.Map<String, String>)outValueClass).keySet()){
						
    stringBuffer.append(TEXT_88);
    stringBuffer.append(((java.util.Map)outValue).get(key));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(((java.util.Map)outValueClass).get(key));
    stringBuffer.append(TEXT_90);
    
						}
					}
					
    stringBuffer.append(TEXT_91);
    mapper.configure();
    stringBuffer.append(TEXT_92);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    mapper.map();
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    mapper.close();
    stringBuffer.append(TEXT_102);
    
		}
		public void generateConf(){
			if(node.isMapOnlyAfterReduce()){
			
    stringBuffer.append(TEXT_103);
    stringBuffer.append(mapperClass);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_107);
    
			}else{
			
    stringBuffer.append(TEXT_108);
    stringBuffer.append(mapperClass);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_112);
    
			}
			
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
        	java.util.Map<String, String> values = (java.util.Map<String, String>)outValue;
        	for(String key : values.keySet()){
        	
    stringBuffer.append(TEXT_115);
    stringBuffer.append(values.get(key));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(getOutValueClass(key));
    stringBuffer.append(TEXT_118);
    
        	}
		}
	}

	final String M_TYPE_BASE = "base";
	final String M_TYPE_MO = "mo";

	class MapperHelper extends MapperHelperBase{

		MapperGenerator mapperGen;

		String cid = null;

		public void setType(String type){
			if(type.equals(M_TYPE_BASE)){
				mapperGen = new MapperGenerator(this);
			}else if(type.equals(M_TYPE_MO)){
				mapperGen = new MOMapperGenerator(this);
			}
		}

		public void init(INode node, String cid, String inKey, String inValue, String outKey, Object outValue){
			if(mapperGen == null){
				mapperGen = new MapperGenerator(this);
			}
			mapperGen.init(node, cid, inKey, inValue, outKey, outValue);
			this.cid = mapperGen.cid;
		}

		public String getInKeyClass(String name){
			return mapperGen.getInKeyClass(name);
		}

		public String getInKeyClass(){
			return mapperGen.getInKeyClass();
		}

		public String getInKey(String name){
			return mapperGen.getInKey(name);
		}

		public String getInKey(){
			return mapperGen.getInKey();
		}

		public String getOutKeyClass(String name){
			return mapperGen.getOutKeyClass(name);
		}

		public String getOutKeyClass(){
			return mapperGen.getOutKeyClass();
		}

		public String getOutKey(String name){
			return mapperGen.getOutKey(name);
		}

		public String getOutKey(){
			return mapperGen.getOutKey();
		}

		public String getInValueClass(String name){
			return mapperGen.getInValueClass(name);
		}

		public String getInValueClass(){
			return mapperGen.getInValueClass();
		}

		public String getInValue(String name){
			return mapperGen.getInValue(name);
		}

		public String getInValue(){
			return mapperGen.getInValue();
		}

		public String getOutValueClass(String name){
			return mapperGen.getOutValueClass(name);
		}

		public String getOutValueClass(){
			return mapperGen.getOutValueClass();
		}

		public String getOutValue(String name){
			return mapperGen.getOutValue(name);
		}

		public String getOutValue(){
			return mapperGen.getOutValue();
		}

		/**
		 * In the case where the underlying implementation supports multiple
		 * outputs, this causes the named output to be passed along the chain
		 * of mapper tasks instead of using the MultipleOutputs object.
		 */
		public void sendOutConnectionToChain(String name) {
			if (mapperGen instanceof MOMapperGenerator)
				((MOMapperGenerator)mapperGen).sendOutConnectionToChain(name);
		}

		public void output(String outKey, String outValue){
			mapperGen.output(outKey, outValue);
		}

		public String getCodeEmit(String outKey, String outValue){
			return mapperGen.getCodeEmit(outKey, outValue);
		}

		public void generate(){
			mapperGen.generate();
		}

		public void generateConf(){
			mapperGen.generateConf();
		}

		public void generateConf(org.talend.core.model.process.IConnection inConn){
			mapperGen.generateConf(inConn);
		}

		public void map(){
		}

		public void prepare(){
		}

		public void configure(){
		}

		public void close(){
		}
	}
	
    

/**
 * The following imports must occur before importing this file:
 * @ include file="@{org.talend.designer.components.mrprovider}/resources/utils/common_codegen_util.javajet"
 */
class MrMapperRowTransformUtil extends org.talend.designer.common.CommonRowTransformUtil {
    /** Must be set to provide a Mapper context to this tool. */
    public MapperHelper helper;

    public String getCodeToGetInField(String columnName) {
        return helper.getInValue() + "." + columnName;
    }
    public String getInValue() {
        return helper.getInValue();
    }
    
    /** Not used in MR, but had to implement it so it returns null*/
    public String getOutValue(){
        return null;
    }

    public String getInValueClass() {
        return helper.getInValueClass();
    }
    
    /** Not used in MR, but had to implement it so it returns null*/
    public String getOutValueClass() {
        return null;
    }

    public String getCodeToGetOutField(boolean isReject, String columnName) {
        return helper.getOutValue(isReject ? "reject" : "main") + "." + columnName;
    }

    public String getCodeToSetOutField(boolean isReject, String columnName, String codeValue) {
        return helper.getOutValue(isReject ? "reject" : "main") + "." + columnName + " = " + codeValue + ";";
    }


    public String getCodeToSetOutField(boolean isReject, String columnName, String codeValue, String operator) {
        return helper.getOutValue(isReject ? "reject" : "main") + "." + columnName + " = " + codeValue + ";";
    }


    public String getCodeToEmit(boolean isReject) {
        return helper.getCodeEmit(null, helper.getOutValue(isReject ? "reject" : "main"));
    }

    /**
     * Generates a Mapper that is typically correct for the given
     * TransformerBase.  This is a shortcut for many use cases, but not
     * mandatory.
     */
    public void generateMrCode(final org.talend.designer.common.TransformerBase transformer) {

        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    
            return;
        }

        // Use a MapperHelper base that has been tied into the transformer.
        class Mapper extends MapperHelper {

            public void prepare() {
                transformer.generateHelperClasses(false);
                transformer.generateTransformContextDeclaration();
            }

            public void configure() {
                transformer.generateTransformContextInitialization();
            }

            public void map() {
                
    stringBuffer.append(TEXT_120);
    stringBuffer.append(getInValueClass());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
                transformer.generateTransform();
            }
        }

        Mapper mapper = new Mapper();
        this.helper = mapper;

        if (transformer.isMultiOutput()) {
            // The multi-output condition is slightly different, and the
            // MapperHelper is configured with internal names for the
            // connections.
            mapper.setType(M_TYPE_MO);
            java.util.HashMap<String, String> names = new java.util.HashMap<String, String>();
            names.put("main", transformer.getOutConnMainName());
            names.put("reject", transformer.getOutConnRejectName());
            mapper.init(node, cid, null, transformer.getInConnName(), null,
                    names);
            // When there is more than one output, the main output continues
            // along the chain, and the reject output is sent to a secondary
            // file.
            mapper.sendOutConnectionToChain("main");
        } else {
            mapper.init(node, cid, null, transformer.getInConnName(), null,
                    transformer.getOutConnMainName() != null
                            ? transformer.getOutConnMainName()
                            : transformer.getOutConnRejectName());
        }

        // Use the configured mapper helper to create the Mapper MR_CODE
        mapper.generate();
    }


    public void generateMrConfig(final org.talend.designer.common.TransformerBase transformer,
            String inputMapperClass) {

        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    
            return;
        }

        // The connection that contains rows to be passed along the chain.  At
        // least one of these is guaranteed to be present.
        IConnection chained = transformer.getOutConnMain() != null
                ? transformer.getOutConnMain() : transformer.getOutConnReject();

        
    stringBuffer.append(TEXT_125);
    stringBuffer.append(inputMapperClass);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(transformer.getInConnName());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(chained.getName());
    stringBuffer.append(TEXT_128);
    
        // If multiple outputs, the rejected output is guaranteed to be on a
        // multiple outputs.
        if (transformer.isMultiOutput()) {
            String shortCid = cid.replaceAll("_Out", "").replaceAll("_In", "");
            
    stringBuffer.append(TEXT_129);
    stringBuffer.append(shortCid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(transformer.getOutConnRejectName());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(transformer.getOutConnRejectName());
    stringBuffer.append(TEXT_132);
    
        }
    }
}

    

/**
 * Contains common processing for tExtractRegexFields code generation.  This is
 * used in MapReduce and Storm components.
 *
 * The following imports must occur before importing this file:
 * @ include file="@{org.talend.designer.components.mrprovider}/resources/utils/common_codegen_util.javajet"
 */
class TExtractRegexFieldsUtil extends org.talend.designer.common.TransformerBase {

    // TODO: what happens when these are input column names?
    final private static String REJECT_MSG = "errorMessage";
    final private static String REJECT_CODE = "errorCode";
    final private static String REJECT_FIELD = "inputLine";

    final private String regex = ElementParameterParser.getValue(node, "__REGEX__");

    final private boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    final private String field = ElementParameterParser.getValue(node, "__FIELD__");

    final private String encoding = ElementParameterParser.getValue(node,"__ENCODING__");

    /** The outgoing connection contains the column {@link #REJECT_FIELD}.
     *  If we import a job from a DI job, this column will be missing */
    final private Boolean containsRejectField;

    /** The list of columns that should be copied directly from the input to
     *  the output schema (where they have the same column names). */
    final private Iterable<IMetadataColumn> copiedInColumns;

    /** Columns in the output schema that are not copied directly from the
     *  input schema (excluding reject fields). */
    final private java.util.List<IMetadataColumn> newOutColumns;

    /** TODO: Used in DI, tied to CHECK_NUM */
    final private boolean validateDatesStrict = false;
    final private boolean validateNumberOfMatchedGroups = false;

    public TExtractRegexFieldsUtil(INode node,
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
        
    stringBuffer.append(TEXT_133);
    
    }

    public void generateTransformContextInitialization(){
        
    stringBuffer.append(TEXT_134);
    stringBuffer.append(regex);
    stringBuffer.append(TEXT_135);
    
    }

    public void generateTransform() {
        generateTransform(false);
    }

    /**
     * Generates code that performs the tranformation from one input string
     * to many output strings, or to a reject flow.
     */
    public void generateTransform(boolean hasAReturnedType) {
        
    stringBuffer.append(TEXT_136);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(hasAReturnedType?" null":"");
    stringBuffer.append(TEXT_138);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_140);
    
        // If there is a reject connection, add isNotMatch to the context.
        if (null != getOutConnReject()) {
            
    stringBuffer.append(TEXT_141);
    
                generateTransformReject(dieOnError, null,
                        getRowTransform().getCodeToGetInField(field) +
                                "+ \" doesn't match regex:\" + " + regex);
                
    stringBuffer.append(TEXT_142);
    
        }
        
    stringBuffer.append(TEXT_143);
    
                if(validateNumberOfMatchedGroups) {
                    // groupCount is recalculated for every matcher.find() operation.
                    
    stringBuffer.append(TEXT_144);
    stringBuffer.append(newOutColumns.size() );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(newOutColumns.size() );
    stringBuffer.append(TEXT_146);
    
                }

                for (int i = 0; i < newOutColumns.size(); i++) {
                    
    stringBuffer.append(TEXT_147);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(i+1);
    stringBuffer.append(TEXT_149);
    
                    generateTransformExtractGroupFromMatcher(newOutColumns.get(i), i);
                }

                // Emit the parsed structure on the main output.
                if (null != getOutConnMain()) {
                    
    stringBuffer.append(TEXT_150);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(false, copiedInColumns));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(getRowTransform().getCodeToEmit(false));
    
                }
                
    stringBuffer.append(TEXT_152);
    stringBuffer.append(getRowTransform().getCodeToInitOut(null == getOutConnMain(), newOutColumns));
    stringBuffer.append(TEXT_153);
    
                generateTransformReject(dieOnError, "ex", null);
                
    stringBuffer.append(TEXT_154);
    
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

        // If there are multiple outputs, then copy all of the new columns from
        // the original output to the error output.
        if (isMultiOutput()) {
            
    stringBuffer.append(TEXT_155);
    stringBuffer.append(getRowTransform().getCodeToCopyOutMainToReject(newOutColumns));
    
        }

        if (die) {
            
    stringBuffer.append(TEXT_156);
    stringBuffer.append(codeException);
    stringBuffer.append(TEXT_157);
    
        } else {
            if (null == getOutConnReject()) {
                
    stringBuffer.append(TEXT_158);
    
                generateLogMessage(codeRejectMsg);
            } else {
                
    stringBuffer.append(TEXT_159);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_MSG,
                        codeRejectMsg) );
    
                if (containsRejectField) {
                    
    stringBuffer.append(TEXT_161);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_FIELD,
                        getRowTransform().getCodeToGetInField(field)) );
    
                }
                
    stringBuffer.append(TEXT_162);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(true, copiedInColumns));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(getRowTransform().getCodeToEmit(true));
    
            }
        }
        return;
    }

    /**
     * Generates code that writes one match group to a specific output column.
     * In the context, the variable "valueAsString" contains the output value
     * as a string (or "" if unknown or empty).
     */
    private void generateTransformExtractGroupFromMatcher(
            IMetadataColumn column, int i) {

        String typeToGenerate = JavaTypesManager.getTypeToGenerate(
                column.getTalendType(), column.isNullable());
        String primitiveTypeToGenerate = JavaTypesManager.getTypeToGenerate(
                column.getTalendType(), false);
        JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

        String colName = column.getLabel();
        if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
            
    stringBuffer.append(TEXT_164);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(colName, "valueAsString") );
    
        } else {
            
    stringBuffer.append(TEXT_165);
    
                if (javaType == JavaTypesManager.BYTE_ARRAY) {
                    
    stringBuffer.append(TEXT_166);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(colName,
                            "valueAsString.getBytes(" + encoding + ")") );
    
                } else if(javaType == JavaTypesManager.DATE) {
                    String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0
                            ? null : column.getPattern();
                    
    stringBuffer.append(TEXT_167);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(colName,
                            "BigDataParserUtils.parseTo_Date(valueAsString, " + patternValue + ", " + !validateDatesStrict+ ")") );
    
                } else {
                    
    stringBuffer.append(TEXT_168);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(colName,
                            "BigDataParserUtils.parseTo_" + typeToGenerate + "(valueAsString)") );
    
                }
                
    stringBuffer.append(TEXT_169);
    
                String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
                if(defaultValue == null) {
                    // TODO: fix this.
                    
    stringBuffer.append(TEXT_170);
    stringBuffer.append( colName );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(getOutConnMainName());
    stringBuffer.append(TEXT_172);
    
                } else {
                    
    stringBuffer.append(TEXT_173);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(colName, defaultValue) );
    
                }
                
    stringBuffer.append(TEXT_174);
    
        }
    }

}

    
final MrMapperRowTransformUtil mrTransformUtil = new MrMapperRowTransformUtil();
final TExtractRegexFieldsUtil tExtractRegexFieldsUtil = new TExtractRegexFieldsUtil(
        node, codeGenArgument, mrTransformUtil);
mrTransformUtil.generateMrCode(tExtractRegexFieldsUtil);

    return stringBuffer.toString();
  }
}
