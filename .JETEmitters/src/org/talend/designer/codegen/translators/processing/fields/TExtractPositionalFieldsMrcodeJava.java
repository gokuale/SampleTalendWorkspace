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

public class TExtractPositionalFieldsMrcodeJava
{
  protected static String nl;
  public static synchronized TExtractPositionalFieldsMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractPositionalFieldsMrcodeJava result = new TExtractPositionalFieldsMrcodeJava();
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
  protected final String TEXT_133 = NL + "        // Input format variables";
  protected final String TEXT_134 = NL + "            private int[] sizes_";
  protected final String TEXT_135 = " = new int[]{";
  protected final String TEXT_136 = NL + "                            ";
  protected final String TEXT_137 = NL + "                            ";
  protected final String TEXT_138 = ",";
  protected final String TEXT_139 = NL + "            };";
  protected final String TEXT_140 = NL + "            String pattern_";
  protected final String TEXT_141 = " = ";
  protected final String TEXT_142 = ";" + NL + "            String[] ptnSplit_";
  protected final String TEXT_143 = " = pattern_";
  protected final String TEXT_144 = ".split(\",\");" + NL + "            private int[] sizes_";
  protected final String TEXT_145 = " = new int[ptnSplit_";
  protected final String TEXT_146 = ".length];";
  protected final String TEXT_147 = NL + "        private int[] indexs_";
  protected final String TEXT_148 = " = new int[sizes_";
  protected final String TEXT_149 = ".length];";
  protected final String TEXT_150 = NL + "        // Input format variables";
  protected final String TEXT_151 = NL + "            for(int i_";
  protected final String TEXT_152 = " = 0; i_";
  protected final String TEXT_153 = "<ptnSplit_";
  protected final String TEXT_154 = ".length; i_";
  protected final String TEXT_155 = "++){" + NL + "                if ((\"*\").equals(ptnSplit_";
  protected final String TEXT_156 = "[i_";
  protected final String TEXT_157 = "])) {" + NL + "                     sizes_";
  protected final String TEXT_158 = "[i_";
  protected final String TEXT_159 = "] = -1;" + NL + "                } else {" + NL + "                     sizes_";
  protected final String TEXT_160 = "[i_";
  protected final String TEXT_161 = "] = Integer.valueOf(ptnSplit_";
  protected final String TEXT_162 = "[i_";
  protected final String TEXT_163 = "]);" + NL + "                }" + NL + "            }";
  protected final String TEXT_164 = NL + "        for(int i_";
  protected final String TEXT_165 = "=0;i_";
  protected final String TEXT_166 = "<indexs_";
  protected final String TEXT_167 = ".length;i_";
  protected final String TEXT_168 = "++){" + NL + "            if(sizes_";
  protected final String TEXT_169 = "[i_";
  protected final String TEXT_170 = "]==-1){" + NL + "                indexs_";
  protected final String TEXT_171 = "[i_";
  protected final String TEXT_172 = "]=-1;" + NL + "            }else{" + NL + "                if(i_";
  protected final String TEXT_173 = "-1>=0){" + NL + "                    indexs_";
  protected final String TEXT_174 = "[i_";
  protected final String TEXT_175 = "]= indexs_";
  protected final String TEXT_176 = "[i_";
  protected final String TEXT_177 = "-1]+sizes_";
  protected final String TEXT_178 = "[i_";
  protected final String TEXT_179 = "];" + NL + "                }else{" + NL + "                    indexs_";
  protected final String TEXT_180 = "[i_";
  protected final String TEXT_181 = "]= sizes_";
  protected final String TEXT_182 = "[i_";
  protected final String TEXT_183 = "];" + NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_184 = NL + "        if (";
  protected final String TEXT_185 = " == null)" + NL + "            return";
  protected final String TEXT_186 = ";" + NL + "        try {" + NL + "" + NL + "            // First map the selected fields to temporary variables" + NL + "            java.util.Map<String,String> newFields_";
  protected final String TEXT_187 = " = new java.util.HashMap<String,String>();" + NL + "" + NL + "            boolean condition = false;" + NL + "            int substringSize = 0;";
  protected final String TEXT_188 = NL + "                        condition = (indexs_";
  protected final String TEXT_189 = "[";
  protected final String TEXT_190 = "] > ";
  protected final String TEXT_191 = ".length()) || (indexs_";
  protected final String TEXT_192 = "[";
  protected final String TEXT_193 = "] < 0);" + NL + "                        substringSize = condition ? ";
  protected final String TEXT_194 = ".length() : indexs_";
  protected final String TEXT_195 = "[";
  protected final String TEXT_196 = "];" + NL + "                        newFields_";
  protected final String TEXT_197 = ".put(\"";
  protected final String TEXT_198 = "\"," + NL + "                                TalendString.talendTrim(";
  protected final String TEXT_199 = NL + "                                        ";
  protected final String TEXT_200 = ".substring(0," + NL + "                                                substringSize)";
  protected final String TEXT_201 = ",";
  protected final String TEXT_202 = NL + "                                        ";
  protected final String TEXT_203 = ",";
  protected final String TEXT_204 = NL + "                                        ";
  protected final String TEXT_205 = "));";
  protected final String TEXT_206 = NL + "                        if(";
  protected final String TEXT_207 = "<indexs_";
  protected final String TEXT_208 = ".length && indexs_";
  protected final String TEXT_209 = "[";
  protected final String TEXT_210 = "]>=0 && indexs_";
  protected final String TEXT_211 = "[";
  protected final String TEXT_212 = "]<= ";
  protected final String TEXT_213 = ".length()){" + NL + "                            condition = (indexs_";
  protected final String TEXT_214 = "[";
  protected final String TEXT_215 = "] > ";
  protected final String TEXT_216 = ".length()) || (indexs_";
  protected final String TEXT_217 = "[";
  protected final String TEXT_218 = "] < 0);" + NL + "                            substringSize = condition ? ";
  protected final String TEXT_219 = ".length() : indexs_";
  protected final String TEXT_220 = "[";
  protected final String TEXT_221 = "];" + NL + "                            newFields_";
  protected final String TEXT_222 = ".put(\"";
  protected final String TEXT_223 = "\"," + NL + "                                    TalendString.talendTrim(";
  protected final String TEXT_224 = NL + "                                            ";
  protected final String TEXT_225 = ".substring(indexs_";
  protected final String TEXT_226 = "[";
  protected final String TEXT_227 = "]," + NL + "                                            substringSize)";
  protected final String TEXT_228 = ",";
  protected final String TEXT_229 = NL + "                                        ";
  protected final String TEXT_230 = ",";
  protected final String TEXT_231 = NL + "                                        ";
  protected final String TEXT_232 = "));" + NL + "                        }";
  protected final String TEXT_233 = NL + "                        condition = (indexs_";
  protected final String TEXT_234 = "[";
  protected final String TEXT_235 = "] > ";
  protected final String TEXT_236 = ".length()) || (indexs_";
  protected final String TEXT_237 = "[";
  protected final String TEXT_238 = "] < 0);" + NL + "                        substringSize = condition ? ";
  protected final String TEXT_239 = ".length() : indexs_";
  protected final String TEXT_240 = "[";
  protected final String TEXT_241 = "];" + NL + "                        newFields_";
  protected final String TEXT_242 = ".put(\"";
  protected final String TEXT_243 = "\",";
  protected final String TEXT_244 = NL + "                                ";
  protected final String TEXT_245 = ".substring(0," + NL + "                                        substringSize)";
  protected final String TEXT_246 = ");";
  protected final String TEXT_247 = NL + "                        if(";
  protected final String TEXT_248 = "<indexs_";
  protected final String TEXT_249 = ".length && indexs_";
  protected final String TEXT_250 = "[";
  protected final String TEXT_251 = "]>=0 && indexs_";
  protected final String TEXT_252 = "[";
  protected final String TEXT_253 = "]<= ";
  protected final String TEXT_254 = ".length()){" + NL + "                            condition = (indexs_";
  protected final String TEXT_255 = "[";
  protected final String TEXT_256 = "] > ";
  protected final String TEXT_257 = ".length()) || (indexs_";
  protected final String TEXT_258 = "[";
  protected final String TEXT_259 = "] < 0);" + NL + "                            substringSize = condition ? ";
  protected final String TEXT_260 = ".length() : indexs_";
  protected final String TEXT_261 = "[";
  protected final String TEXT_262 = "];" + NL + "                            newFields_";
  protected final String TEXT_263 = ".put(\"";
  protected final String TEXT_264 = "\",";
  protected final String TEXT_265 = NL + "                                    ";
  protected final String TEXT_266 = ".substring(indexs_";
  protected final String TEXT_267 = "[";
  protected final String TEXT_268 = "]," + NL + "                                        substringSize)";
  protected final String TEXT_269 = ");" + NL + "                        }";
  protected final String TEXT_270 = NL + NL + "            // Then map the temporary variables to the outputs fields." + NL + "            String temp_";
  protected final String TEXT_271 = " = null;" + NL;
  protected final String TEXT_272 = NL + "                        ";
  protected final String TEXT_273 = NL + "                    temp_";
  protected final String TEXT_274 = " = newFields_";
  protected final String TEXT_275 = ".get(\"";
  protected final String TEXT_276 = "\");" + NL + "" + NL + "                    if(temp_";
  protected final String TEXT_277 = "!=null && temp_";
  protected final String TEXT_278 = ".length() > 0) {";
  protected final String TEXT_279 = NL + "                            ";
  protected final String TEXT_280 = NL + "                            ";
  protected final String TEXT_281 = NL + "                            ";
  protected final String TEXT_282 = NL + "                            ";
  protected final String TEXT_283 = NL + "                            ";
  protected final String TEXT_284 = NL + "                    } else {";
  protected final String TEXT_285 = NL + "                            throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_286 = "' in '";
  protected final String TEXT_287 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_288 = NL + "                            ";
  protected final String TEXT_289 = NL + "                    }";
  protected final String TEXT_290 = NL + "                ";
  protected final String TEXT_291 = NL + "                ";
  protected final String TEXT_292 = NL + "            ";
  protected final String TEXT_293 = NL + "        } catch (RuntimeException ex) {";
  protected final String TEXT_294 = NL + "        }";
  protected final String TEXT_295 = NL + "            // Die immediately on errors." + NL + "            throw new IOException(";
  protected final String TEXT_296 = ");";
  protected final String TEXT_297 = NL + "                ";
  protected final String TEXT_298 = NL + "                // Ignore errors processing this row and move to the next.";
  protected final String TEXT_299 = NL + "                // Send error rows to the reject output.";
  protected final String TEXT_300 = NL + "                ";
  protected final String TEXT_301 = NL + "                    ";
  protected final String TEXT_302 = NL + "                ";
  protected final String TEXT_303 = NL + "                ";

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
        
    stringBuffer.append(TEXT_133);
    
        if (advancedInputFormat) {
            
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
                    for(int i=0; i < formats.size();i++){
                        java.util.Map<String,String> tmp = formats.get(i);
                        if(("*").equals(tmp.get("SIZE"))){
                            
    stringBuffer.append(TEXT_136);
    stringBuffer.append(-1);
    
                        }else{
                            
    stringBuffer.append(TEXT_137);
    stringBuffer.append(Integer.valueOf(tmp.get("SIZE")));
    stringBuffer.append(TEXT_138);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_139);
    
        } else {
            
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
        }
        
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
    }


    public void generateTransformContextInitialization() {
        
    stringBuffer.append(TEXT_150);
    
        if (!advancedInputFormat) {
            
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    
        }
        
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    
    }
    public void generateTransform() {
        generateTransform(false);
    }

    /**
     * Generates code that performs the tranformation from one input string
     * to many output strings, or to a reject flow.
     */
    public void generateTransform(boolean hasAReturnedType) {
        
    stringBuffer.append(TEXT_184);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(hasAReturnedType?" null":"");
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    
            if (advanced) {
                for (int i = 0; i < formats.size(); i++) {
                    java.util.Map<String,String> tmp = formats.get(i);
                    if (i == 0) {
                        
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(tmp.get("COLUMN"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_201);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(tmp.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(tmp.get("ALIGN"));
    stringBuffer.append(TEXT_205);
    
                    } else {
                        
    stringBuffer.append(TEXT_206);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(tmp.get("COLUMN"));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_228);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(tmp.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_230);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(tmp.get("ALIGN"));
    stringBuffer.append(TEXT_232);
    
                    }
                }
            } else {
                for(int i = 0; i < newOutColumns.size(); i++){
                    IMetadataColumn temporaryMetadata = newOutColumns.get(i);
                    if(i==0){
                        
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(temporaryMetadata.getLabel());
    stringBuffer.append(TEXT_243);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_246);
    
                    }else{
                        
    stringBuffer.append(TEXT_247);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(temporaryMetadata.getLabel());
    stringBuffer.append(TEXT_264);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(getRowTransform().getCodeToGetInField(field));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_269);
    
                    }
                }
            }
            
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    
            for(IMetadataColumn column : newOutColumns){
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                String columnName = column.getLabel();
                if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
                    
    stringBuffer.append(TEXT_272);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "newFields_" + cid +".get(\"" + columnName + "\")") );
    
                } else {
                    
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    
                        if(javaType == JavaTypesManager.BYTE_ARRAY){
                            
    stringBuffer.append(TEXT_279);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "temp_" + cid +".getBytes()") );
    
                        }else if(javaType == JavaTypesManager.DATE) {
                            if(checkNum){
                            
    stringBuffer.append(TEXT_280);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(temp_" + cid +", " + patternValue + ", false)") );
    
                            }else{
                            
    stringBuffer.append(TEXT_281);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_Date(temp_" + cid +", " + patternValue + ")") );
    
                            }
                        }else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) {
                            
    stringBuffer.append(TEXT_282);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, " BigDataParserUtils.parseTo_" + typeToGenerate
                                    + "(BigDataParserUtils.parseTo_Number(temp_" + cid +", " + thousandsSeparator + ", " + decimalSeparator + "))") );
    
                        } else {
                            
    stringBuffer.append(TEXT_283);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, "BigDataParserUtils.parseTo_" + typeToGenerate + "(temp_" + cid + ")") );
    
                        }
                    
    stringBuffer.append(TEXT_284);
    
                        String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
                        if(defaultValue == null) {
                            
    stringBuffer.append(TEXT_285);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(getOutConnMainName());
    stringBuffer.append(TEXT_287);
    
                        } else {
                            
    stringBuffer.append(TEXT_288);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(columnName, defaultValue) );
    
                        }
                    
    stringBuffer.append(TEXT_289);
    
                }
            }

            if (null != getOutConnMain()) {
                
    stringBuffer.append(TEXT_290);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(false, copiedInColumns));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(getRowTransform().getCodeToEmit(false));
    
            }
            
    stringBuffer.append(TEXT_292);
    stringBuffer.append(getRowTransform().getCodeToInitOut(null == getOutConnMain(), newOutColumns));
    stringBuffer.append(TEXT_293);
    
            generateTransformReject(dieOnError, "ex", null);
            
    stringBuffer.append(TEXT_294);
    
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
            
    stringBuffer.append(TEXT_295);
    stringBuffer.append(codeException);
    stringBuffer.append(TEXT_296);
    
        } else {
            // If there are multiple outputs, then copy all of the new columns from
            // the original output to the error output.
            if (isMultiOutput()) {
                
    stringBuffer.append(TEXT_297);
    stringBuffer.append(getRowTransform().getCodeToCopyOutMainToReject(newOutColumns));
    
            }

            if (null == getOutConnReject()) {
                
    stringBuffer.append(TEXT_298);
    
                generateLogMessage(codeRejectMsg);
            } else {
                
    stringBuffer.append(TEXT_299);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_MSG,
                        codeRejectMsg) );
    
                if (containsRejectField) {
                    
    stringBuffer.append(TEXT_301);
    stringBuffer.append(getRowTransform().getCodeToSetOutField(true, REJECT_FIELD,
                        getRowTransform().getCodeToGetInField(field)) );
    
                }
                
    stringBuffer.append(TEXT_302);
    stringBuffer.append(getRowTransform().getCodeToCopyFields(true, copiedInColumns));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(getRowTransform().getCodeToEmit(true));
    
            }
        }
    }


}

    
final MrMapperRowTransformUtil mrTransformUtil = new MrMapperRowTransformUtil();
final TExtractPositionalFieldsUtil tExtractPositionalFieldsUtil = new TExtractPositionalFieldsUtil(
        node, codeGenArgument, mrTransformUtil);
mrTransformUtil.generateMrCode(tExtractPositionalFieldsUtil);

    return stringBuffer.toString();
  }
}
