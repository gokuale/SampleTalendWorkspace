package org.talend.designer.codegen.translators.processing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TConvertTypeMrcodeJava
{
  protected static String nl;
  public static synchronized TConvertTypeMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TConvertTypeMrcodeJava result = new TConvertTypeMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
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
  protected final String TEXT_119 = NL + "\t";
  protected final String TEXT_120 = NL + "\t\t\t\t";
  protected final String TEXT_121 = " default_";
  protected final String TEXT_122 = " = new ";
  protected final String TEXT_123 = "();" + NL + "\t\t\t";
  protected final String TEXT_124 = NL + "\t\t\t";
  protected final String TEXT_125 = " ";
  protected final String TEXT_126 = " = value_";
  protected final String TEXT_127 = ";" + NL + "\t\t\t" + NL + "\t\t\tboolean bHasError_";
  protected final String TEXT_128 = " = false;";
  protected final String TEXT_129 = NL + "\t\t\tString errorCode_";
  protected final String TEXT_130 = " = \"\";" + NL + "    \t\tString errorMessage_";
  protected final String TEXT_131 = " = \"\";";
  protected final String TEXT_132 = NL + "\t\t\t\t            try {" + NL + "                        \t\t";
  protected final String TEXT_133 = NL + "                                  if (\"\".equals(";
  protected final String TEXT_134 = ".";
  protected final String TEXT_135 = ")){  ";
  protected final String TEXT_136 = NL + "                                    ";
  protected final String TEXT_137 = ".";
  protected final String TEXT_138 = " = null;" + NL + "                                  }";
  protected final String TEXT_139 = NL + "\t\t\t\t\t\t\t\t  ";
  protected final String TEXT_140 = ".";
  protected final String TEXT_141 = " =";
  protected final String TEXT_142 = NL + "\t\t\t\t\t\t\t\t  ";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = " =";
  protected final String TEXT_145 = NL + "                                  TypeConvert.";
  protected final String TEXT_146 = "2";
  protected final String TEXT_147 = "(";
  protected final String TEXT_148 = ".";
  protected final String TEXT_149 = ", ";
  protected final String TEXT_150 = ");";
  protected final String TEXT_151 = NL + "                                  TypeConvert.";
  protected final String TEXT_152 = "2";
  protected final String TEXT_153 = "(";
  protected final String TEXT_154 = ".";
  protected final String TEXT_155 = ", ";
  protected final String TEXT_156 = ");" + NL + "                            \t";
  protected final String TEXT_157 = NL + "                                  BigDataParserUtils.parseTo_Document(";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = ");";
  protected final String TEXT_160 = NL + "                                  ";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = ".toString();";
  protected final String TEXT_163 = NL + "                                  TypeConvert.";
  protected final String TEXT_164 = "2";
  protected final String TEXT_165 = "(";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = ");";
  protected final String TEXT_168 = "    " + NL + "          \t\t\t\t\t      ";
  protected final String TEXT_169 = ".";
  protected final String TEXT_170 = " = ";
  protected final String TEXT_171 = ".";
  protected final String TEXT_172 = ";";
  protected final String TEXT_173 = "            " + NL + "                              } catch(java.lang.Exception e){" + NL + "                              \tbHasError_";
  protected final String TEXT_174 = " = true;";
  protected final String TEXT_175 = NL + "                                \t";
  protected final String TEXT_176 = ".";
  protected final String TEXT_177 = " = default_";
  protected final String TEXT_178 = ".";
  protected final String TEXT_179 = ";" + NL + "\t\t\t\t\t\t\t\t\tif ((\"\").equals(errorMessage_";
  protected final String TEXT_180 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\terrorMessage_";
  protected final String TEXT_181 = " = \"";
  protected final String TEXT_182 = "\" + \":\" + e.getMessage();" + NL + "\t\t\t\t\t\t\t\t\t} else{" + NL + "\t\t\t\t\t\t\t\t\t\terrorMessage_";
  protected final String TEXT_183 = " = errorMessage_";
  protected final String TEXT_184 = " + \";\" + \"";
  protected final String TEXT_185 = "\" + \":\" + e.getMessage();" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_186 = NL + "                              }";
  protected final String TEXT_187 = "     " + NL + "                  try {";
  protected final String TEXT_188 = NL + "                      if (\"\".equals(";
  protected final String TEXT_189 = ".";
  protected final String TEXT_190 = ")){  ";
  protected final String TEXT_191 = NL + "                        ";
  protected final String TEXT_192 = ".";
  protected final String TEXT_193 = " = null;" + NL + "                      }";
  protected final String TEXT_194 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_195 = ".";
  protected final String TEXT_196 = " =";
  protected final String TEXT_197 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_198 = ".";
  protected final String TEXT_199 = " =";
  protected final String TEXT_200 = NL + "                   \t  TypeConvert.";
  protected final String TEXT_201 = "2";
  protected final String TEXT_202 = "(";
  protected final String TEXT_203 = ".";
  protected final String TEXT_204 = ", ";
  protected final String TEXT_205 = ");";
  protected final String TEXT_206 = NL + "                      TypeConvert.";
  protected final String TEXT_207 = "2";
  protected final String TEXT_208 = "(";
  protected final String TEXT_209 = ".";
  protected final String TEXT_210 = ", ";
  protected final String TEXT_211 = ");";
  protected final String TEXT_212 = NL + "                      BigDataParserUtils.parseTo_Document(";
  protected final String TEXT_213 = ".";
  protected final String TEXT_214 = ");" + NL + "            \t\t";
  protected final String TEXT_215 = NL + "                      ";
  protected final String TEXT_216 = ".";
  protected final String TEXT_217 = ".toString();";
  protected final String TEXT_218 = NL + "                      TypeConvert.";
  protected final String TEXT_219 = "2";
  protected final String TEXT_220 = "(";
  protected final String TEXT_221 = ".";
  protected final String TEXT_222 = ");";
  protected final String TEXT_223 = "    " + NL + "\t\t\t      \t\t";
  protected final String TEXT_224 = ".";
  protected final String TEXT_225 = " = ";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = ";";
  protected final String TEXT_228 = NL + "                  } catch (java.lang.Exception e){" + NL + "                    bHasError_";
  protected final String TEXT_229 = " = true;        ";
  protected final String TEXT_230 = NL + "                    \t";
  protected final String TEXT_231 = ".";
  protected final String TEXT_232 = " = default_";
  protected final String TEXT_233 = ".";
  protected final String TEXT_234 = ";" + NL + "                      if (\"\".equals(errorMessage_";
  protected final String TEXT_235 = ")){" + NL + "                        errorMessage_";
  protected final String TEXT_236 = " = \"";
  protected final String TEXT_237 = "\" + \":\" + e.getMessage();" + NL + "                      } else{" + NL + "                        errorMessage_";
  protected final String TEXT_238 = "=errorMessage_";
  protected final String TEXT_239 = " + \";\" + \"";
  protected final String TEXT_240 = "\" + \":\" + e.getMessage();" + NL + "                      }";
  protected final String TEXT_241 = NL + "                  }";
  protected final String TEXT_242 = NL + "\t\t\tif(!bHasError_";
  protected final String TEXT_243 = ") {";
  protected final String TEXT_244 = NL + "\t\t\t}";
  protected final String TEXT_245 = NL + "\t\t    if (bHasError_";
  protected final String TEXT_246 = "){" + NL + "      \t\t\tif (errorMessage_";
  protected final String TEXT_247 = ".contains(\"Can't support convert\")){" + NL + "        \t\t\terrorCode_";
  protected final String TEXT_248 = " = \"1\"; //ConvertTypeNotSupportException" + NL + "      \t\t\t}else{" + NL + "        \t\t\terrorCode_";
  protected final String TEXT_249 = " = \"2\"; //Other Java exception" + NL + "      \t\t\t}" + NL + "      \t\t\t";
  protected final String TEXT_250 = ".errorCode = errorCode_";
  protected final String TEXT_251 = ";" + NL + "      \t\t\t";
  protected final String TEXT_252 = ".errorMessage = errorMessage_";
  protected final String TEXT_253 = ";";
  protected final String TEXT_254 = NL + "    \t\t}" + NL + "    \t\terrorMessage_";
  protected final String TEXT_255 = " = \"\";";
  protected final String TEXT_256 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
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
	
    stringBuffer.append(TEXT_119);
    
	BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument)argument;
	final INode node = (INode)codeGenArgument.getArgument();
	final String cid = node.getUniqueName();
	
    final boolean autoCast = ("true").equals(ElementParameterParser.getValue(node, "__AUTOCAST__"));
    final List<Map<String, String>> manualtable = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MANUALTABLE__");
    final boolean bEmptyToNull = "true".equals(ElementParameterParser.getValue(node, "__EMPTYTONULL__"));
    
    IConnection inMainCon = null;
    List<? extends IConnection> connsIn = node.getIncomingConnections(EConnectionType.FLOW_MAIN);

    if (connsIn == null || connsIn.size() == 0 ){
    	return "";
  	} else{
		inMainCon = connsIn.get(0);
 	}
 	
    IConnection outConn = null;
    List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
  
    if (outConns == null || outConns.size() == 0 ){
    	return "";
 	} else{
	  	for(int i=0; i<outConns.size(); i++){
	  		IConnection connTemp = outConns.get(i);
		    if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		    	outConn = connTemp;
		    	break;
		    }
	  	}
    }
  
  	final String preconnName = inMainCon.getName(); 
    final String outconnName = outConn.getName();
    String rejectConnNameTmp = null;
     
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
  
    if (rejectConns != null && rejectConns.size() > 0) {
      for (IConnection conn : rejectConns) {
        if (conn.isActivate()){
          rejectConnNameTmp = conn.getName();
        }
      }
    }
    
    final String rejectConnName = rejectConnNameTmp;
    
    final IMetadataTable preMetadata = inMainCon.getMetadataTable(); 
    final List<IMetadataColumn> preColumns = preMetadata.getListColumns();
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    final IMetadataTable metadata = metadatas.get(0);
    final List<IMetadataColumn> columns = metadata.getListColumns();
    
    final boolean hasMain = outconnName!=null && !outconnName.equals(rejectConnName);
    final boolean hasReject = rejectConnName!=null;
    final boolean hasMultipleOutputs = hasReject && hasMain ? true : false;
    
    class Mapper extends MapperHelper{
    
    	public void prepare(){
    		if(hasReject){
			
    stringBuffer.append(TEXT_120);
    stringBuffer.append(getOutValueClass("reject"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(getOutValueClass("reject"));
    stringBuffer.append(TEXT_123);
    
			}    	
    	}
		public void map(){
			
			String outputClassName = getOutValueClass("main");
			String rejectClassName = getOutValueClass("reject");
			
			String outputValueName = getOutValue("main");
			String rejectValueName = getOutValue("reject");
			

    stringBuffer.append(TEXT_124);
    stringBuffer.append(getInValueClass());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
			if(hasReject) {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    
			}
			
			if (autoCast){
				for (IMetadataColumn col : columns){
		      		String outLabel = col.getLabel();
          			String outPattern = col.getPattern();
                  	String outTypeWhole = JavaTypesManager.getTypeToGenerate(col.getTalendType(), col.isNullable());
                  	String outType = outTypeWhole.contains(".") ? outTypeWhole.substring(outTypeWhole.lastIndexOf(".") + 1) : outTypeWhole;
                  	if (("byte[]").equals(outType)){
                    	outType = "byteArray";
              		}
              		
              		for (IMetadataColumn preCol : preColumns){
              			String preLabel = preCol.getLabel();
              			if (preLabel.equals(outLabel)){
              				String inTypeWhole = JavaTypesManager.getTypeToGenerate(preCol.getTalendType(), preCol.isNullable());
              				String inType = inTypeWhole.contains(".") ? inTypeWhole.substring(inTypeWhole.lastIndexOf(".") + 1) : inTypeWhole;
      						String inPattern = preCol.getPattern();
      						
				          	if (("byte[]").equals(inType)){
            					inType = "byteArray";
     					 	}

    stringBuffer.append(TEXT_132);
    
                                if (bEmptyToNull && ("String".equals(inType) || "Object".equals(inType))) {
                                
    stringBuffer.append(TEXT_133);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(preLabel);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_138);
    
                                }
                                
                                if(hasMain) {

    stringBuffer.append(TEXT_139);
    stringBuffer.append(outputValueName );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_141);
    
                                } else if(hasReject) {

    stringBuffer.append(TEXT_142);
    stringBuffer.append(rejectValueName );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_144);
    
                                }
                                
                                if ("Date".equals(outType) && "String".equals(inType)) {
    stringBuffer.append(TEXT_145);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(outPattern );
    stringBuffer.append(TEXT_150);
    } else if ("String".equals(outType) && "Date".equals(inType)) {
    stringBuffer.append(TEXT_151);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_154);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(inPattern );
    stringBuffer.append(TEXT_156);
    } else if (("Document".equals(outType) && "String".equals(inType))){
    stringBuffer.append(TEXT_157);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_159);
    } else if (("String".equals(outType) && "Document".equals(inType))){
    stringBuffer.append(TEXT_160);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_162);
    } else{
    stringBuffer.append(TEXT_163);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_167);
    }
                                
                                if(hasMultipleOutputs) {

    stringBuffer.append(TEXT_168);
    stringBuffer.append(rejectValueName );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(outputValueName );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_172);
    
                                }
                                
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    if (hasReject){
    stringBuffer.append(TEXT_175);
    stringBuffer.append(rejectValueName );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_185);
    }
    stringBuffer.append(TEXT_186);
    
              			}
              		}
				}
			} else {
                for (Map<String, String> manualColumn : manualtable){
                  String input = manualColumn.get("INPUT_COLUMN");
                  String output = manualColumn.get("OUTPUT_COLUMN");
                  IMetadataColumn in = preMetadata.getColumn(input);
                  IMetadataColumn out = metadata.getColumn(output);
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
                  
    stringBuffer.append(TEXT_187);
    
                    if (bEmptyToNull && ("String".equals(inType) || "Object".equals(inType))) {
                    
    stringBuffer.append(TEXT_188);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_189);
    stringBuffer.append(preLabel);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_192);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_193);
    
                    }
                    
                    if(hasMain) {

    stringBuffer.append(TEXT_194);
    stringBuffer.append(outputValueName );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_196);
    
                    } else if(hasReject) {

    stringBuffer.append(TEXT_197);
    stringBuffer.append(rejectValueName );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_199);
    
                    }
                    
                    if ("Date".equals(outType) && "String".equals(inType)) {
    stringBuffer.append(TEXT_200);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_203);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(outPattern );
    stringBuffer.append(TEXT_205);
    } else if ("String".equals(outType) && "Date".equals(inType)) {
    stringBuffer.append(TEXT_206);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_209);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(inPattern );
    stringBuffer.append(TEXT_211);
    } else if (("Document".equals(outType) && "String".equals(inType))){
    stringBuffer.append(TEXT_212);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_213);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_214);
    } else if (("String".equals(outType) && "Document".equals(inType))){
    stringBuffer.append(TEXT_215);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_216);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_217);
    } else {
    stringBuffer.append(TEXT_218);
    stringBuffer.append(inType );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(outType );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_221);
    stringBuffer.append(preLabel );
    stringBuffer.append(TEXT_222);
    }
                    
                    if (hasMultipleOutputs){
                    
    stringBuffer.append(TEXT_223);
    stringBuffer.append(rejectValueName );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(outputValueName );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_227);
    
                    }
                    
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    if (hasReject){
    stringBuffer.append(TEXT_230);
    stringBuffer.append(rejectValueName );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(outLabel );
    stringBuffer.append(TEXT_240);
    }
    stringBuffer.append(TEXT_241);
    
                }
  			}
			
			if(hasMain) {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    
				output(null, getOutValue("main"));

    stringBuffer.append(TEXT_244);
    
			}
			
			if(hasReject) {

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(rejectValueName );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(rejectValueName );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    
		    	output(null, getOutValue("reject"));

    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    
			}
		}
	}
	  
	Mapper mapper = new Mapper();
	if(hasMultipleOutputs){
		mapper.setType(M_TYPE_MO);
		Map<String, String> outConnNames = new HashMap<String, String>();
		outConnNames.put("main", outconnName);
		outConnNames.put("reject", rejectConnName);
		mapper.init(node, cid, null, preconnName, null, outConnNames);
	}else{
		mapper.init(node, cid, null, preconnName, null, outconnName!=null ? outconnName : rejectConnName);
	}
	mapper.generate();
	
    stringBuffer.append(TEXT_256);
    return stringBuffer.toString();
  }
}
