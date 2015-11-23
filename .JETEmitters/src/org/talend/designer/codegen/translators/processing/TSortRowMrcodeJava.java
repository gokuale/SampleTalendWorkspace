package org.talend.designer.codegen.translators.processing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TSortRowMrcodeJava
{
  protected static String nl;
  public static synchronized TSortRowMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSortRowMrcodeJava result = new TSortRowMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    ";
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
  protected final String TEXT_119 = NL + "    ";
  protected final String TEXT_120 = "\t";
  protected final String TEXT_121 = NL + "\t\t\toutput_";
  protected final String TEXT_122 = ".collect(";
  protected final String TEXT_123 = ", ";
  protected final String TEXT_124 = ");" + NL + "\t\t";
  protected final String TEXT_125 = NL + "\t\t\tpublic static class ";
  protected final String TEXT_126 = " extends MapReduceBase " + NL + "\t\t\t\timplements Reducer<";
  protected final String TEXT_127 = ", ";
  protected final String TEXT_128 = ", ";
  protected final String TEXT_129 = ", ";
  protected final String TEXT_130 = ">{" + NL + "\t\t\t\tContextProperties context;" + NL + "\t\t\t\tGlobalVar globalMap;" + NL + "\t\t\t\t";
  protected final String TEXT_131 = " ";
  protected final String TEXT_132 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_133 = " ";
  protected final String TEXT_134 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\t\t" + NL + "\t\t\t\tpublic void configure(JobConf job_";
  protected final String TEXT_136 = "){" + NL + "\t\t\t\t\tcontext = new ContextProperties(job_";
  protected final String TEXT_137 = ");" + NL + "\t\t\t\t\tglobalMap = new GlobalVar(job_";
  protected final String TEXT_138 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_139 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_140 = " = NullWritable.get();" + NL + "\t\t\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_142 = " = new ";
  protected final String TEXT_143 = "(); " + NL + "\t\t\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\t\t";
  protected final String TEXT_145 = " = new ";
  protected final String TEXT_146 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_147 = NL + "  \t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic void reduce(";
  protected final String TEXT_148 = " key_";
  protected final String TEXT_149 = ", Iterator<";
  protected final String TEXT_150 = "> values_";
  protected final String TEXT_151 = ", " + NL + "\t\t\t\t\tOutputCollector<";
  protected final String TEXT_152 = ", ";
  protected final String TEXT_153 = "> output_";
  protected final String TEXT_154 = ", Reporter reporter_";
  protected final String TEXT_155 = ") throws IOException{" + NL + "\t\t\t\t    final OutputCollector<";
  protected final String TEXT_156 = ", ";
  protected final String TEXT_157 = "> outputCollect_";
  protected final String TEXT_158 = "=output_";
  protected final String TEXT_159 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_160 = NL + "\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\tpublic void close() throws IOException{" + NL + "\t\t\t\t\t";
  protected final String TEXT_161 = NL + "  \t\t\t\t}" + NL + "    \t\t}" + NL + "    \t";
  protected final String TEXT_162 = NL + "\t\t\tChainReducer.setReducer(job, ";
  protected final String TEXT_163 = ".class, ";
  protected final String TEXT_164 = ".class," + NL + "        \t\t";
  protected final String TEXT_165 = ".class, ";
  protected final String TEXT_166 = ".class, ";
  protected final String TEXT_167 = ".class, true, new JobConf(false));" + NL + "\t\t";
  protected final String TEXT_168 = NL + "\t\t\tmos_";
  protected final String TEXT_169 = ".getCollector(\"";
  protected final String TEXT_170 = "\", reporter_";
  protected final String TEXT_171 = ").collect(";
  protected final String TEXT_172 = ", ";
  protected final String TEXT_173 = ");" + NL + "\t\t";
  protected final String TEXT_174 = NL + "\t\t\tpublic static class ";
  protected final String TEXT_175 = " extends MapReduceBase " + NL + "\t\t\t\timplements Reducer<";
  protected final String TEXT_176 = ", ";
  protected final String TEXT_177 = ", ";
  protected final String TEXT_178 = ", WritableComparable>{" + NL + "\t\t\t\tContextProperties context;" + NL + "\t\t\t\tGlobalVar globalMap;" + NL + "\t\t\t\tpublic MultipleOutputs mos_";
  protected final String TEXT_179 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_180 = " ";
  protected final String TEXT_181 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_183 = " ";
  protected final String TEXT_184 = " = null;\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_185 = NL + "\t\t\t\t";
  protected final String TEXT_186 = NL + "\t\t\t\t" + NL + "\t\t\t\tpublic void configure(JobConf job_";
  protected final String TEXT_187 = "){" + NL + "\t\t\t\t\tcontext = new ContextProperties(job_";
  protected final String TEXT_188 = ");" + NL + "\t\t\t\t\tglobalMap = new GlobalVar(job_";
  protected final String TEXT_189 = ");" + NL + "\t\t\t\t\tmos_";
  protected final String TEXT_190 = " = new MultipleOutputs(job_";
  protected final String TEXT_191 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_192 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_193 = " = NullWritable.get();" + NL + "\t\t\t\t\t";
  protected final String TEXT_194 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_195 = " = new ";
  protected final String TEXT_196 = "(); " + NL + "\t\t\t\t\t";
  protected final String TEXT_197 = NL + "\t\t\t\t\t";
  protected final String TEXT_198 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_199 = " = new ";
  protected final String TEXT_200 = "();\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_201 = NL + "\t\t\t\t\t";
  protected final String TEXT_202 = NL + "  \t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic void reduce(";
  protected final String TEXT_203 = " key_";
  protected final String TEXT_204 = ", Iterator<";
  protected final String TEXT_205 = "> values_";
  protected final String TEXT_206 = ", " + NL + "\t\t\t\t\tOutputCollector<";
  protected final String TEXT_207 = ", WritableComparable> output_";
  protected final String TEXT_208 = ", Reporter reporter_";
  protected final String TEXT_209 = ") throws IOException{" + NL + "\t\t\t\t    final Reporter reporterFinal_";
  protected final String TEXT_210 = "= reporter_";
  protected final String TEXT_211 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_212 = NL + "\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\tpublic void close() throws IOException{" + NL + "\t\t\t\t\tmos_";
  protected final String TEXT_213 = ".close();" + NL + "\t\t\t\t\t";
  protected final String TEXT_214 = NL + "  \t\t\t\t}" + NL + "    \t\t}" + NL + "    \t";
  protected final String TEXT_215 = NL + "\t\t\tChainReducer.setReducer(job, ";
  protected final String TEXT_216 = ".class, ";
  protected final String TEXT_217 = ".class," + NL + "        \t\t";
  protected final String TEXT_218 = ".class, ";
  protected final String TEXT_219 = ".class, WritableComparable.class, true, new JobConf(false));" + NL + "        \tMultipleOutputs.setWorkDir(job, genTempFolderForComponent(\"MultipleOutputs_";
  protected final String TEXT_220 = "\"));" + NL + "\t\t\t";
  protected final String TEXT_221 = NL + "\t\t\t\tMultipleOutputs.setKeyValue(job, \"";
  protected final String TEXT_222 = "\", ";
  protected final String TEXT_223 = ".class, ";
  protected final String TEXT_224 = ".class);" + NL + "        \t";
  protected final String TEXT_225 = NL + "\t\t\tjob.setCombinerClass(";
  protected final String TEXT_226 = ".class);" + NL + "\t\t";
  protected final String TEXT_227 = NL + "\t";
  protected final String TEXT_228 = NL + "\t\t\tcompareColumns.put(\"";
  protected final String TEXT_229 = "\", 1);" + NL + "\t\t";
  protected final String TEXT_230 = NL + "\t\t\tcompareColumns.put(\"";
  protected final String TEXT_231 = "\", -1);" + NL + "\t\t";
  protected final String TEXT_232 = NL + "\t\t\t\treturn 1;" + NL + "\t\t\t";
  protected final String TEXT_233 = NL + "\t\t\t\treturn -1;" + NL + "\t\t\t";
  protected final String TEXT_234 = NL + "\t\t\t\treturn -1;" + NL + "\t\t\t";
  protected final String TEXT_235 = NL + "\t\t\t\treturn 1;" + NL + "\t\t\t";
  protected final String TEXT_236 = NL + "\t\t\t\t\tint length1_";
  protected final String TEXT_237 = " = readInt(b1, pos1);" + NL + "\t\t\t\t\tpos1 += 4;" + NL + "\t\t\t\t\tint length2_";
  protected final String TEXT_238 = " = readInt(b2, pos2);" + NL + "\t\t\t\t\tpos2 += 4;" + NL + "\t\t\t\t";
  protected final String TEXT_239 = NL + "\t        \t\tboolean null1_";
  protected final String TEXT_240 = " = b1[pos1] == -1;" + NL + "\t        \t\tpos1 += 1;" + NL + "\t        \t\tboolean null2_";
  protected final String TEXT_241 = " = b2[pos2] == -1;" + NL + "\t        \t\tpos2 += 1;" + NL + "\t        \t";
  protected final String TEXT_242 = NL + "\t\t\t\tif(null1_";
  protected final String TEXT_243 = " && !null2_";
  protected final String TEXT_244 = "){" + NL + "\t\t\t\t}else if(!null1_";
  protected final String TEXT_245 = " && null2_";
  protected final String TEXT_246 = "){" + NL + "\t\t\t\t}else if(null1_";
  protected final String TEXT_247 = " && null2_";
  protected final String TEXT_248 = "){" + NL + "\t\t\t\t}else{\t" + NL + "\t\t\t";
  protected final String TEXT_249 = "\t\t" + NL + "            \t";
  protected final String TEXT_250 = NL + "\t        \t\tpos1 += 1;" + NL + "\t        \t\tpos2 += 1;" + NL + "\t        \t";
  protected final String TEXT_251 = NL + "\t        \t\tpos1 += 1;" + NL + "\t        \t\tpos2 += 1;" + NL + "\t            ";
  protected final String TEXT_252 = NL + "\t            \tpos1 += length1_";
  protected final String TEXT_253 = ";" + NL + "\t            \tpos2 += length2_";
  protected final String TEXT_254 = ";" + NL + "\t            ";
  protected final String TEXT_255 = NL + "\t            \tpos1 += 2;" + NL + "\t            \tpos2 += 2;" + NL + "\t            ";
  protected final String TEXT_256 = NL + "\t                pos1 += 8;" + NL + "\t                pos2 += 8;" + NL + "\t            ";
  protected final String TEXT_257 = NL + "\t                pos1 += 8;" + NL + "\t                pos2 += 8;" + NL + "\t            ";
  protected final String TEXT_258 = NL + "\t                pos1 += 4;" + NL + "\t                pos2 += 4;" + NL + "\t            ";
  protected final String TEXT_259 = NL + "\t                pos1 += (short)((b1[pos1] << 8) | (b1[pos1+1] & 0xff));" + NL + "\t                pos1 += 4; " + NL + "\t                pos2 += (short)((b2[pos2] << 8) | (b2[pos2+1] & 0xff));" + NL + "\t                pos2 += 4; " + NL + "\t            ";
  protected final String TEXT_260 = NL + "\t                pos1 += 4;" + NL + "\t                pos2 += 4;" + NL + "\t            ";
  protected final String TEXT_261 = NL + "\t                pos1 += 8;" + NL + "\t                pos2 += 8;" + NL + "\t            ";
  protected final String TEXT_262 = NL + "\t            \tDon't support Object type: column--";
  protected final String TEXT_263 = NL + "\t            ";
  protected final String TEXT_264 = NL + "\t            \tpos1 += 2;" + NL + "\t            \tpos2 += 2;" + NL + "\t            ";
  protected final String TEXT_265 = NL + "\t            \tpos1 += 4;" + NL + "\t            \tpos1 += readInt(b1, pos1);" + NL + "\t            \tpos2 += 4;" + NL + "\t            \tpos2 += readInt(b2, pos2);" + NL + "\t            ";
  protected final String TEXT_266 = NL + "\t            \tDon't support List type: column--";
  protected final String TEXT_267 = NL + "\t            ";
  protected final String TEXT_268 = NL + "\t            \tDon't support Document type: column--";
  protected final String TEXT_269 = NL + "\t            ";
  protected final String TEXT_270 = NL + "\t            \tDon't support Dynamic type: column--";
  protected final String TEXT_271 = NL + "\t            ";
  protected final String TEXT_272 = NL + "        \t\t}        " + NL + "        \t";
  protected final String TEXT_273 = NL + "\t\t\t\t\tint length1_";
  protected final String TEXT_274 = " = readInt(b1, pos1);" + NL + "\t\t\t\t\tpos1 += 4;" + NL + "\t\t\t\t\tint length2_";
  protected final String TEXT_275 = " = readInt(b2, pos2);" + NL + "\t\t\t\t\tpos2 += 4;" + NL + "\t\t\t\t\tboolean null1_";
  protected final String TEXT_276 = " = length1_";
  protected final String TEXT_277 = " == -1;" + NL + "\t\t\t\t\tboolean null2_";
  protected final String TEXT_278 = " = length2_";
  protected final String TEXT_279 = " == -1;" + NL + "\t\t\t\t";
  protected final String TEXT_280 = NL + "\t        \t\tboolean null1_";
  protected final String TEXT_281 = " = b1[pos1] == -1;" + NL + "\t        \t\tpos1 += 1;" + NL + "\t        \t\tboolean null2_";
  protected final String TEXT_282 = " = b2[pos2] == -1;" + NL + "\t        \t\tpos2 += 1;" + NL + "\t        \t";
  protected final String TEXT_283 = NL + "\t\t\t\tif(null1_";
  protected final String TEXT_284 = " && !null2_";
  protected final String TEXT_285 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_286 = NL + "\t\t\t\t}else if(!null1_";
  protected final String TEXT_287 = " && null2_";
  protected final String TEXT_288 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_289 = NL + "\t\t\t\t}else if(null1_";
  protected final String TEXT_290 = " && null2_";
  protected final String TEXT_291 = "){" + NL + "\t\t\t\t\t//ignore" + NL + "\t\t\t\t}else{\t" + NL + "\t\t\t";
  protected final String TEXT_292 = "\t\t" + NL + "            \t";
  protected final String TEXT_293 = NL + "\t        \t\tif(b1[pos1] > 0 && b2[pos2] ==0){" + NL + "\t        \t\t\t";
  protected final String TEXT_294 = NL + "\t        \t\t}else if(b1[pos1] == 0 && b2[pos2] > 0){" + NL + "\t        \t\t\t";
  protected final String TEXT_295 = NL + "\t        \t\t}" + NL + "\t        \t\tpos1 += 1;" + NL + "\t        \t\tpos2 += 1;" + NL + "\t        \t";
  protected final String TEXT_296 = NL + "\t                if(b1[pos1] > b2[pos2]){" + NL + "\t        \t\t\t";
  protected final String TEXT_297 = NL + "\t        \t\t}else if(b1[pos1] < b2[pos2]){" + NL + "\t        \t\t\t";
  protected final String TEXT_298 = NL + "\t        \t\t}" + NL + "\t        \t\tpos1 += 1;" + NL + "\t        \t\tpos2 += 1;" + NL + "\t            ";
  protected final String TEXT_299 = NL + "\t            \tint n_";
  protected final String TEXT_300 = " = Math.min(length1_";
  protected final String TEXT_301 = ", length2_";
  protected final String TEXT_302 = ");" + NL + "\t            \tfor(int i = 0; i < n_";
  protected final String TEXT_303 = "; i++){" + NL + "\t            \t\tif(b1[pos1+i] > b2[pos2+i]){" + NL + "\t            \t\t\t";
  protected final String TEXT_304 = NL + "\t            \t\t}else if(b1[pos1+i] < b2[pos2+i]){" + NL + "\t            \t\t\t";
  protected final String TEXT_305 = NL + "\t            \t\t}" + NL + "\t            \t}" + NL + "\t            \tpos1 += length1_";
  protected final String TEXT_306 = ";" + NL + "\t            \tpos2 += length2_";
  protected final String TEXT_307 = ";" + NL + "\t            \tif(length1_";
  protected final String TEXT_308 = " > length2_";
  protected final String TEXT_309 = "){" + NL + "\t            \t\t";
  protected final String TEXT_310 = NL + "\t            \t}else if(length1_";
  protected final String TEXT_311 = " < length2_";
  protected final String TEXT_312 = "){" + NL + "\t            \t\t";
  protected final String TEXT_313 = NL + "\t            \t}" + NL + "\t            ";
  protected final String TEXT_314 = NL + "\t            \tif((char)((b1[pos1] << 8) | (b1[pos1+1] & 0xff)) - (char)((b2[pos2] << 8) | (b2[pos2+1] & 0xff)) != 0){" + NL + "\t            \t\tif((char)((b1[pos1] << 8) | (b1[pos1+1] & 0xff)) - (char)((b2[pos2] << 8) | (b2[pos2+1] & 0xff)) > 0){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_315 = "            \t\t\t" + NL + "\t            \t\t}else{" + NL + "\t            \t\t\t";
  protected final String TEXT_316 = NL + "\t            \t\t}" + NL + "\t            \t}" + NL + "\t            \tpos1 += 2;" + NL + "\t            \tpos2 += 2;" + NL + "\t            ";
  protected final String TEXT_317 = NL + "\t            \tlong v1_";
  protected final String TEXT_318 = " = readLong(b1, pos1);" + NL + "\t                pos1 += 8;" + NL + "\t            \tlong v2_";
  protected final String TEXT_319 = " = readLong(b2, pos2);" + NL + "\t                pos2 += 8;" + NL + "\t                ";
  protected final String TEXT_320 = NL + "\t            \t\tint cmp_";
  protected final String TEXT_321 = " = FormatterUtils.format_DateInUTC(new java.util.Date(v1_";
  protected final String TEXT_322 = "), ";
  protected final String TEXT_323 = ").compareTo(FormatterUtils.format_DateInUTC(new java.util.Date(v2_";
  protected final String TEXT_324 = "), ";
  protected final String TEXT_325 = "));" + NL + "\t            \t\tif(cmp_";
  protected final String TEXT_326 = " > 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_327 = NL + "\t            \t\t}else if(cmp_";
  protected final String TEXT_328 = " < 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_329 = NL + "\t            \t\t}" + NL + "\t            \t";
  protected final String TEXT_330 = NL + "\t\t                if(v1_";
  protected final String TEXT_331 = " > v2_";
  protected final String TEXT_332 = "){" + NL + "\t\t                \t";
  protected final String TEXT_333 = NL + "\t\t                }else if(v1_";
  protected final String TEXT_334 = " < v2_";
  protected final String TEXT_335 = "){" + NL + "\t\t                \t";
  protected final String TEXT_336 = NL + "\t\t                }" + NL + "\t            \t";
  protected final String TEXT_337 = NL + "\t                double v1_";
  protected final String TEXT_338 = " = readDouble(b1, pos1);" + NL + "\t                pos1 += 8;" + NL + "\t                double v2_";
  protected final String TEXT_339 = " = readDouble(b2, pos2);" + NL + "\t                pos2 += 8;" + NL + "\t                ";
  protected final String TEXT_340 = NL + "\t            \t\tint cmp_";
  protected final String TEXT_341 = " = String.valueOf(v1_";
  protected final String TEXT_342 = ").compareTo(String.valueOf(v2_";
  protected final String TEXT_343 = "));" + NL + "\t            \t\tif(cmp_";
  protected final String TEXT_344 = " > 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_345 = NL + "\t            \t\t}else if(cmp_";
  protected final String TEXT_346 = " < 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_347 = NL + "\t            \t\t}" + NL + "\t            \t";
  protected final String TEXT_348 = NL + "\t\t                if(v1_";
  protected final String TEXT_349 = " > v2_";
  protected final String TEXT_350 = "){" + NL + "\t\t                \t";
  protected final String TEXT_351 = NL + "\t\t                }else if(v1_";
  protected final String TEXT_352 = " < v2_";
  protected final String TEXT_353 = "){" + NL + "\t\t                \t";
  protected final String TEXT_354 = NL + "\t\t                }" + NL + "\t            \t";
  protected final String TEXT_355 = NL + "\t            \tfloat v1_";
  protected final String TEXT_356 = " = readFloat(b1, pos1);" + NL + "\t                pos1 += 4;" + NL + "\t                float v2_";
  protected final String TEXT_357 = " = readFloat(b2, pos2);" + NL + "\t                pos2 += 4;" + NL + "\t                ";
  protected final String TEXT_358 = NL + "\t            \t\tint cmp_";
  protected final String TEXT_359 = " = String.valueOf(v1_";
  protected final String TEXT_360 = ").compareTo(String.valueOf(v2_";
  protected final String TEXT_361 = "));" + NL + "\t            \t\tif(cmp_";
  protected final String TEXT_362 = " > 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_363 = NL + "\t            \t\t}else if(cmp_";
  protected final String TEXT_364 = " < 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_365 = NL + "\t            \t\t}" + NL + "\t            \t";
  protected final String TEXT_366 = NL + "\t\t                if(v1_";
  protected final String TEXT_367 = " > v2_";
  protected final String TEXT_368 = "){" + NL + "\t\t                \t";
  protected final String TEXT_369 = NL + "\t\t                }else if(v1_";
  protected final String TEXT_370 = " < v2_";
  protected final String TEXT_371 = "){" + NL + "\t\t                \t";
  protected final String TEXT_372 = NL + "\t\t                }" + NL + "\t            \t";
  protected final String TEXT_373 = NL + "\t                byte[] bs1_";
  protected final String TEXT_374 = " = new byte[(short)((b1[pos1] << 8) | (b1[pos1+1] & 0xff))];" + NL + "\t                pos1 += 2; " + NL + "\t                for(int i = 0; i < bs1_";
  protected final String TEXT_375 = ".length; i++){" + NL + "\t                \tbs1_";
  protected final String TEXT_376 = "[i] = b1[pos1+i];" + NL + "\t                }" + NL + "\t                pos1 += bs1_";
  protected final String TEXT_377 = ".length;" + NL + "\t                int scale1_";
  protected final String TEXT_378 = " = (short)((b1[pos1] << 8) | (b1[pos1+1] & 0xff));" + NL + "\t                pos1 += 2;" + NL + "\t                java.math.BigDecimal bd1_";
  protected final String TEXT_379 = " = new java.math.BigDecimal(new java.math.BigInteger(bs1_";
  protected final String TEXT_380 = "), scale1_";
  protected final String TEXT_381 = ");" + NL + "\t                " + NL + "\t                byte[] bs2_";
  protected final String TEXT_382 = " = new byte[(short)((b2[pos2] << 8) | (b2[pos2+1] & 0xff))];" + NL + "\t                pos2 += 2; " + NL + "\t                for(int i = 0; i < bs2_";
  protected final String TEXT_383 = ".length; i++){" + NL + "\t                \tbs2_";
  protected final String TEXT_384 = "[i] = b2[pos2+i];" + NL + "\t                }" + NL + "\t                pos2 += bs2_";
  protected final String TEXT_385 = ".length;" + NL + "\t                int scale2_";
  protected final String TEXT_386 = " = (short)((b2[pos2] << 8) | (b2[pos2+1] & 0xff));" + NL + "\t                pos2 += 2;" + NL + "\t                java.math.BigDecimal bd2_";
  protected final String TEXT_387 = " = new java.math.BigDecimal(new java.math.BigInteger(bs2_";
  protected final String TEXT_388 = "), scale2_";
  protected final String TEXT_389 = ");" + NL + "\t                " + NL + "\t                ";
  protected final String TEXT_390 = NL + "\t            \t\tint cmp_";
  protected final String TEXT_391 = " = String.valueOf(bd1_";
  protected final String TEXT_392 = ").compareTo(String.valueOf(bd2_";
  protected final String TEXT_393 = "));" + NL + "\t            \t";
  protected final String TEXT_394 = NL + "\t\t                int cmp_";
  protected final String TEXT_395 = " = bd1_";
  protected final String TEXT_396 = ".compareTo(bd2_";
  protected final String TEXT_397 = ");" + NL + "\t\t            ";
  protected final String TEXT_398 = NL + "\t        \t\tif(cmp_";
  protected final String TEXT_399 = " > 0){" + NL + "\t        \t\t\t";
  protected final String TEXT_400 = NL + "\t        \t\t}else if(cmp_";
  protected final String TEXT_401 = " < 0){" + NL + "\t        \t\t\t";
  protected final String TEXT_402 = NL + "\t        \t\t}" + NL + "\t            ";
  protected final String TEXT_403 = NL + "\t            \tint v1_";
  protected final String TEXT_404 = " = readInt(b1, pos1);" + NL + "\t                pos1 += 4;" + NL + "\t            \tint v2_";
  protected final String TEXT_405 = " = readInt(b2, pos2);" + NL + "\t                pos2 += 4;" + NL + "\t                ";
  protected final String TEXT_406 = NL + "\t            \t\tint cmp_";
  protected final String TEXT_407 = " = String.valueOf(v1_";
  protected final String TEXT_408 = ").compareTo(String.valueOf(v2_";
  protected final String TEXT_409 = "));" + NL + "\t            \t\tif(cmp_";
  protected final String TEXT_410 = " > 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_411 = NL + "\t            \t\t}else if(cmp_";
  protected final String TEXT_412 = " < 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_413 = NL + "\t            \t\t}" + NL + "\t            \t";
  protected final String TEXT_414 = NL + "\t\t                if(v1_";
  protected final String TEXT_415 = " > v2_";
  protected final String TEXT_416 = "){" + NL + "\t\t                \t";
  protected final String TEXT_417 = NL + "\t\t                }else if(v1_";
  protected final String TEXT_418 = " < v2_";
  protected final String TEXT_419 = "){" + NL + "\t\t                \t";
  protected final String TEXT_420 = NL + "\t\t                }" + NL + "\t            \t";
  protected final String TEXT_421 = NL + "\t           \t\tlong v1_";
  protected final String TEXT_422 = " = readLong(b1, pos1);" + NL + "\t                pos1 += 8;" + NL + "\t            \tlong v2_";
  protected final String TEXT_423 = " = readLong(b2, pos2);" + NL + "\t                pos2 += 8;" + NL + "\t               \t";
  protected final String TEXT_424 = NL + "\t            \t\tint cmp_";
  protected final String TEXT_425 = " = String.valueOf(v1_";
  protected final String TEXT_426 = ").compareTo(String.valueOf(v2_";
  protected final String TEXT_427 = "));" + NL + "\t            \t\tif(cmp_";
  protected final String TEXT_428 = " > 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_429 = NL + "\t            \t\t}else if(cmp_";
  protected final String TEXT_430 = " < 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_431 = NL + "\t            \t\t}" + NL + "\t            \t";
  protected final String TEXT_432 = NL + "\t\t                if(v1_";
  protected final String TEXT_433 = " > v2_";
  protected final String TEXT_434 = "){" + NL + "\t\t                \t";
  protected final String TEXT_435 = NL + "\t\t                }else if(v1_";
  protected final String TEXT_436 = " < v2_";
  protected final String TEXT_437 = "){" + NL + "\t\t                \t";
  protected final String TEXT_438 = NL + "\t\t                }" + NL + "\t            \t";
  protected final String TEXT_439 = NL + "\t            \tDon't support Object type: column--";
  protected final String TEXT_440 = NL + "\t            ";
  protected final String TEXT_441 = NL + "\t            \tshort v1_";
  protected final String TEXT_442 = " = (short)((b1[pos1] << 8) | (b1[pos1+1] & 0xff));" + NL + "\t            \tshort v2_";
  protected final String TEXT_443 = " = (short)((b2[pos2] << 8) | (b2[pos2+1] & 0xff));" + NL + "\t            \tpos1 += 2;" + NL + "\t            \tpos2 += 2;" + NL + "\t            \t";
  protected final String TEXT_444 = NL + "\t            \t\tint cmp_";
  protected final String TEXT_445 = " = String.valueOf(v1_";
  protected final String TEXT_446 = ").compareTo(String.valueOf(v2_";
  protected final String TEXT_447 = "));" + NL + "\t            \t\tif(cmp_";
  protected final String TEXT_448 = " > 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_449 = NL + "\t            \t\t}else if(cmp_";
  protected final String TEXT_450 = " < 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_451 = NL + "\t            \t\t}" + NL + "\t            \t";
  protected final String TEXT_452 = NL + "\t\t            \tif(v1_";
  protected final String TEXT_453 = " > v2_";
  protected final String TEXT_454 = "){" + NL + "\t\t                \t";
  protected final String TEXT_455 = NL + "\t\t                }else if(v1_";
  protected final String TEXT_456 = " < v2_";
  protected final String TEXT_457 = "){" + NL + "\t\t                \t";
  protected final String TEXT_458 = NL + "\t\t                }" + NL + "\t            \t";
  protected final String TEXT_459 = NL + "\t            \tint len1_";
  protected final String TEXT_460 = " = readInt(b1, pos1);" + NL + "\t            \tpos1 += 4;" + NL + "\t            \tbyte[] bs1_";
  protected final String TEXT_461 = " = new byte[len1_";
  protected final String TEXT_462 = "];" + NL + "\t            \tfor(int i = 0; i < bs1_";
  protected final String TEXT_463 = ".length; i++){" + NL + "\t            \t\tbs1_";
  protected final String TEXT_464 = "[i] = b1[pos1 + i];" + NL + "\t            \t}" + NL + "\t            \tpos1 += bs1_";
  protected final String TEXT_465 = ".length;" + NL + "\t            \tString v1_";
  protected final String TEXT_466 = " = new String(bs1_";
  protected final String TEXT_467 = ", \"UTF-8\");" + NL + "\t            \t" + NL + "\t            \tint len2_";
  protected final String TEXT_468 = " = readInt(b2, pos2);" + NL + "\t            \tpos2 += 4;" + NL + "\t            \tbyte[] bs2_";
  protected final String TEXT_469 = " = new byte[len2_";
  protected final String TEXT_470 = "];" + NL + "\t            \tfor(int i = 0; i < bs2_";
  protected final String TEXT_471 = ".length; i++){" + NL + "\t            \t\tbs2_";
  protected final String TEXT_472 = "[i] = b2[pos2 + i];" + NL + "\t            \t}" + NL + "\t            \tpos2 += bs2_";
  protected final String TEXT_473 = ".length;" + NL + "\t            \tString v2_";
  protected final String TEXT_474 = " = new String(bs2_";
  protected final String TEXT_475 = ", \"UTF-8\");" + NL + "\t            \t" + NL + "\t            \tint comp_";
  protected final String TEXT_476 = " = v1_";
  protected final String TEXT_477 = ".compareTo(v2_";
  protected final String TEXT_478 = ");" + NL + "\t            \tif(comp_";
  protected final String TEXT_479 = " != 0){" + NL + "\t            \t\tif(comp_";
  protected final String TEXT_480 = " > 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_481 = NL + "\t            \t\t}else{" + NL + "\t            \t\t\t";
  protected final String TEXT_482 = NL + "\t            \t\t}" + NL + "\t            \t\t" + NL + "\t            \t}" + NL + "\t            ";
  protected final String TEXT_483 = NL + "\t            \tDon't support List type: column--";
  protected final String TEXT_484 = NL + "\t            ";
  protected final String TEXT_485 = NL + "\t            \tDon't support Document type: column--";
  protected final String TEXT_486 = NL + "\t            ";
  protected final String TEXT_487 = NL + "\t            \tDon't support Dynamic type: column--";
  protected final String TEXT_488 = NL + "\t            ";
  protected final String TEXT_489 = NL + "        \t\t}        " + NL + "        \t";
  protected final String TEXT_490 = NL + "\t\t\t\t\tjava.util.Map<String, Integer> compareColumns = new java.util.HashMap<String, Integer>();\t" + NL + "\t\t\t\t";
  protected final String TEXT_491 = NL + "                    \t";
  protected final String TEXT_492 = NL + "                \t";
  protected final String TEXT_493 = NL + "                \t\t";
  protected final String TEXT_494 = NL + "                \t";
  protected final String TEXT_495 = NL + "\t\t\t\t\t\tif(compareColumns.get(\"";
  protected final String TEXT_496 = "\") == null){" + NL + "\t\t\t\t\t\t}else if(compareColumns.get(\"";
  protected final String TEXT_497 = "\") > 0){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_498 = NL + "\t\t\t\t\t\t}else if(compareColumns.get(\"";
  protected final String TEXT_499 = "\") < 0){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_500 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_501 = NL + "\t\t\tpublic static class ";
  protected final String TEXT_502 = " extends WritableComparator{" + NL + "\t\t\t\tint pos1;" + NL + "\t\t\t\tint pos2;" + NL + "\t\t\t\tint comp = 0;" + NL + "\t\t\t\t" + NL + "\t\t\t\tprotected ";
  protected final String TEXT_503 = "(){" + NL + "\t\t\t\t\tsuper(";
  protected final String TEXT_504 = ".class, false);" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic int compare(byte b1[], int s1, int l1, byte b2[], int s2, int l2){" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tpos1 = s1;" + NL + "\t\t\t\t\t\tpos2 = s2;" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_505 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_506 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\treturn comp;" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t}catch(Exception e){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(e);" + NL + "\t\t\t\t\t}\t\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_507 = NL + "\t\t\t\t\tpublic int compare(WritableComparable w1, WritableComparable w2){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_508 = " k1 = (";
  protected final String TEXT_509 = ")w1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_510 = " k2 = (";
  protected final String TEXT_511 = ")w2;" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_512 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\treturn 0;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_513 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_514 = NL + "\t\t\t\tif(k1.";
  protected final String TEXT_515 = " == null && k2.";
  protected final String TEXT_516 = " != null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_517 = NL + "\t\t\t\t}else if(k1.";
  protected final String TEXT_518 = " != null && k2.";
  protected final String TEXT_519 = " == null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_520 = NL + "\t\t\t\t}else if(k1.";
  protected final String TEXT_521 = " == null && k2.";
  protected final String TEXT_522 = " == null){" + NL + "\t\t\t\t\t//ignore" + NL + "\t\t\t\t}else{\t" + NL + "\t\t\t";
  protected final String TEXT_523 = "\t\t" + NL + "            \t";
  protected final String TEXT_524 = NL + "\t        \t\tif(k1.";
  protected final String TEXT_525 = " != k2.";
  protected final String TEXT_526 = "){" + NL + "\t        \t\t\tif(k1.";
  protected final String TEXT_527 = "){" + NL + "\t\t        \t\t\t";
  protected final String TEXT_528 = NL + "\t        \t\t\t}else{" + NL + "\t\t        \t\t\t";
  protected final String TEXT_529 = NL + "\t        \t\t\t}" + NL + "\t        \t\t}" + NL + "\t        \t";
  protected final String TEXT_530 = NL + "\t                if(k1.";
  protected final String TEXT_531 = " > k2.";
  protected final String TEXT_532 = "){" + NL + "\t        \t\t\t";
  protected final String TEXT_533 = NL + "\t        \t\t}else if(k1.";
  protected final String TEXT_534 = " < k2.";
  protected final String TEXT_535 = "){" + NL + "\t        \t\t\t";
  protected final String TEXT_536 = NL + "\t        \t\t}" + NL + "\t            ";
  protected final String TEXT_537 = NL + "\t            \tString s1_";
  protected final String TEXT_538 = " = new String(k1.";
  protected final String TEXT_539 = ");" + NL + "\t            \tString s2_";
  protected final String TEXT_540 = " = new String(k2.";
  protected final String TEXT_541 = ");" + NL + "\t            \tif(!s1_";
  protected final String TEXT_542 = ".equals(s2_";
  protected final String TEXT_543 = ")){" + NL + "\t\t\t\t\t\tif(s1_";
  protected final String TEXT_544 = ".compareTo(s2_";
  protected final String TEXT_545 = ") > 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_546 = NL + "\t\t\t\t\t\t}else{" + NL + "\t            \t\t\t";
  protected final String TEXT_547 = NL + "\t\t\t\t\t\t}" + NL + "\t            \t}" + NL + "\t            ";
  protected final String TEXT_548 = NL + "\t            \tif(k1.";
  protected final String TEXT_549 = " - k2.";
  protected final String TEXT_550 = " != 0){" + NL + "\t            \t\tif(k1.";
  protected final String TEXT_551 = " - k2.";
  protected final String TEXT_552 = " > 0){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_553 = "            \t\t\t" + NL + "\t            \t\t}else{" + NL + "\t            \t\t\t";
  protected final String TEXT_554 = NL + "\t            \t\t}" + NL + "\t            \t}" + NL + "\t            ";
  protected final String TEXT_555 = NL + "\t                ";
  protected final String TEXT_556 = NL + "\t            \t\tint cmp_";
  protected final String TEXT_557 = " = FormatterUtils.format_DateInUTC(k1.";
  protected final String TEXT_558 = ", ";
  protected final String TEXT_559 = ").compareTo(FormatterUtils.format_DateInUTC(k2.";
  protected final String TEXT_560 = ", ";
  protected final String TEXT_561 = "));" + NL + "\t            \t\tif(cmp_";
  protected final String TEXT_562 = " > 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_563 = NL + "\t            \t\t}else if(cmp_";
  protected final String TEXT_564 = " < 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_565 = NL + "\t            \t\t}" + NL + "\t            \t";
  protected final String TEXT_566 = NL + "\t            \t\tif(!k1.";
  protected final String TEXT_567 = ".equals(k2.";
  protected final String TEXT_568 = ")){" + NL + "\t\t\t                if(k1.";
  protected final String TEXT_569 = ".compareTo(k2.";
  protected final String TEXT_570 = ") > 0){" + NL + "\t\t\t                \t";
  protected final String TEXT_571 = NL + "\t\t\t                }else{" + NL + "\t\t\t                \t";
  protected final String TEXT_572 = NL + "\t\t\t                }" + NL + "\t\t                }" + NL + "\t            \t";
  protected final String TEXT_573 = NL + "\t                ";
  protected final String TEXT_574 = NL + "\t            \t\tint cmp_";
  protected final String TEXT_575 = " = String.valueOf(k1.";
  protected final String TEXT_576 = ").compareTo(String.valueOf(k2.";
  protected final String TEXT_577 = "));" + NL + "\t            \t\tif(cmp_";
  protected final String TEXT_578 = " > 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_579 = NL + "\t            \t\t}else if(cmp_";
  protected final String TEXT_580 = " < 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_581 = NL + "\t            \t\t}" + NL + "\t            \t";
  protected final String TEXT_582 = NL + "\t\t                if(k1.";
  protected final String TEXT_583 = " > k2.";
  protected final String TEXT_584 = "){" + NL + "\t\t                \t";
  protected final String TEXT_585 = NL + "\t\t                }else if(k1.";
  protected final String TEXT_586 = " < k2.";
  protected final String TEXT_587 = "){" + NL + "\t\t                \t";
  protected final String TEXT_588 = NL + "\t\t                }" + NL + "\t            \t";
  protected final String TEXT_589 = NL + "\t                ";
  protected final String TEXT_590 = NL + "\t            \t\tint cmp_";
  protected final String TEXT_591 = " = String.valueOf(k1.";
  protected final String TEXT_592 = ").compareTo(String.valueOf(k2.";
  protected final String TEXT_593 = "));" + NL + "\t            \t\tif(cmp_";
  protected final String TEXT_594 = " > 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_595 = NL + "\t            \t\t}else if(cmp_";
  protected final String TEXT_596 = " < 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_597 = NL + "\t            \t\t}" + NL + "\t            \t";
  protected final String TEXT_598 = NL + "\t\t                if(k1.";
  protected final String TEXT_599 = " > k2.";
  protected final String TEXT_600 = "){" + NL + "\t\t                \t";
  protected final String TEXT_601 = NL + "\t\t                }else if(k1.";
  protected final String TEXT_602 = " < k2.";
  protected final String TEXT_603 = "){" + NL + "\t\t                \t";
  protected final String TEXT_604 = NL + "\t\t                }" + NL + "\t            \t";
  protected final String TEXT_605 = NL + "\t                ";
  protected final String TEXT_606 = NL + "\t            \t\tint cmp_";
  protected final String TEXT_607 = " = String.valueOf(k1.";
  protected final String TEXT_608 = ").compareTo(String.valueOf(k2.";
  protected final String TEXT_609 = "));" + NL + "\t            \t";
  protected final String TEXT_610 = NL + "\t\t                int cmp_";
  protected final String TEXT_611 = " = k1.";
  protected final String TEXT_612 = ".compareTo(k2.";
  protected final String TEXT_613 = ");" + NL + "\t\t            ";
  protected final String TEXT_614 = NL + "\t        \t\tif(cmp_";
  protected final String TEXT_615 = " > 0){" + NL + "\t        \t\t\t";
  protected final String TEXT_616 = NL + "\t        \t\t}else if(cmp_";
  protected final String TEXT_617 = " < 0){" + NL + "\t        \t\t\t";
  protected final String TEXT_618 = NL + "\t        \t\t}" + NL + "\t            ";
  protected final String TEXT_619 = NL + "\t                ";
  protected final String TEXT_620 = NL + "\t            \t\tint cmp_";
  protected final String TEXT_621 = " = String.valueOf(k1.";
  protected final String TEXT_622 = ").compareTo(String.valueOf(k2.";
  protected final String TEXT_623 = "));" + NL + "\t            \t\tif(cmp_";
  protected final String TEXT_624 = " > 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_625 = NL + "\t            \t\t}else if(cmp_";
  protected final String TEXT_626 = " < 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_627 = NL + "\t            \t\t}" + NL + "\t            \t";
  protected final String TEXT_628 = NL + "\t\t                if(k1.";
  protected final String TEXT_629 = " > k2.";
  protected final String TEXT_630 = "){" + NL + "\t\t                \t";
  protected final String TEXT_631 = NL + "\t\t                }else if(k1.";
  protected final String TEXT_632 = " < k2.";
  protected final String TEXT_633 = "){" + NL + "\t\t                \t";
  protected final String TEXT_634 = NL + "\t\t                }" + NL + "\t            \t";
  protected final String TEXT_635 = NL + "\t               \t";
  protected final String TEXT_636 = NL + "\t            \t\tint cmp_";
  protected final String TEXT_637 = " = String.valueOf(k1.";
  protected final String TEXT_638 = ").compareTo(String.valueOf(k2.";
  protected final String TEXT_639 = "));" + NL + "\t            \t\tif(cmp_";
  protected final String TEXT_640 = " > 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_641 = NL + "\t            \t\t}else if(cmp_";
  protected final String TEXT_642 = " < 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_643 = NL + "\t            \t\t}" + NL + "\t            \t";
  protected final String TEXT_644 = NL + "\t\t                if(k1.";
  protected final String TEXT_645 = " > k2.";
  protected final String TEXT_646 = "){" + NL + "\t\t                \t";
  protected final String TEXT_647 = NL + "\t\t                }else if(k1.";
  protected final String TEXT_648 = " < k2.";
  protected final String TEXT_649 = "){" + NL + "\t\t                \t";
  protected final String TEXT_650 = NL + "\t\t                }" + NL + "\t            \t";
  protected final String TEXT_651 = NL + "\t            \tDon't support Object type: column--";
  protected final String TEXT_652 = NL + "\t            ";
  protected final String TEXT_653 = NL + "\t            \t";
  protected final String TEXT_654 = NL + "\t            \t\tint cmp_";
  protected final String TEXT_655 = " = String.valueOf(k1.";
  protected final String TEXT_656 = ").compareTo(String.valueOf(k2.";
  protected final String TEXT_657 = "));" + NL + "\t            \t\tif(cmp_";
  protected final String TEXT_658 = " > 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_659 = NL + "\t            \t\t}else if(cmp_";
  protected final String TEXT_660 = " < 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_661 = NL + "\t            \t\t}" + NL + "\t            \t";
  protected final String TEXT_662 = NL + "\t\t            \tif(k1.";
  protected final String TEXT_663 = " > k2.";
  protected final String TEXT_664 = "){" + NL + "\t\t                \t";
  protected final String TEXT_665 = NL + "\t\t                }else if(k1.";
  protected final String TEXT_666 = " < k2.";
  protected final String TEXT_667 = "){" + NL + "\t\t                \t";
  protected final String TEXT_668 = NL + "\t\t                }" + NL + "\t            \t";
  protected final String TEXT_669 = NL + "\t            \tint comp_";
  protected final String TEXT_670 = " = k1.";
  protected final String TEXT_671 = ".compareTo(k2.";
  protected final String TEXT_672 = ");" + NL + "\t            \tif(comp_";
  protected final String TEXT_673 = " != 0){" + NL + "\t            \t\tif(comp_";
  protected final String TEXT_674 = " > 0){" + NL + "\t            \t\t\t";
  protected final String TEXT_675 = NL + "\t            \t\t}else{" + NL + "\t            \t\t\t";
  protected final String TEXT_676 = NL + "\t            \t\t}" + NL + "\t            \t\t" + NL + "\t            \t}" + NL + "\t            ";
  protected final String TEXT_677 = NL + "\t            \tDon't support List type: column--";
  protected final String TEXT_678 = NL + "\t            ";
  protected final String TEXT_679 = NL + "\t            \tDon't support Document type: column--";
  protected final String TEXT_680 = NL + "\t            ";
  protected final String TEXT_681 = NL + "\t            \tDon't support Dynamic type: column--";
  protected final String TEXT_682 = NL + "\t            ";
  protected final String TEXT_683 = NL + "        \t\t}        " + NL + "        \t";
  protected final String TEXT_684 = NL + "                        ";
  protected final String TEXT_685 = ".write";
  protected final String TEXT_686 = "(this.";
  protected final String TEXT_687 = ");";
  protected final String TEXT_688 = NL + "                        if(this.";
  protected final String TEXT_689 = " == null){";
  protected final String TEXT_690 = NL + "                                ";
  protected final String TEXT_691 = ".writeInt(-1);";
  protected final String TEXT_692 = NL + "                                ";
  protected final String TEXT_693 = ".writeByte(-1);";
  protected final String TEXT_694 = NL + "                        }else{";
  protected final String TEXT_695 = NL + "                                ";
  protected final String TEXT_696 = ".writeInt(this.";
  protected final String TEXT_697 = ".length);";
  protected final String TEXT_698 = NL + "                                ";
  protected final String TEXT_699 = ".writeByte(0);";
  protected final String TEXT_700 = NL + "                                ";
  protected final String TEXT_701 = ".writeBoolean(this.";
  protected final String TEXT_702 = ");";
  protected final String TEXT_703 = NL + "                                ";
  protected final String TEXT_704 = ".writeByte(this.";
  protected final String TEXT_705 = ");";
  protected final String TEXT_706 = NL + "                                ";
  protected final String TEXT_707 = ".write(this.";
  protected final String TEXT_708 = ");";
  protected final String TEXT_709 = NL + "                                ";
  protected final String TEXT_710 = ".writeChar(this.";
  protected final String TEXT_711 = ");";
  protected final String TEXT_712 = NL + "                                ";
  protected final String TEXT_713 = ".writeLong(this.";
  protected final String TEXT_714 = ".getTime());";
  protected final String TEXT_715 = NL + "                                ";
  protected final String TEXT_716 = ".writeDouble(this.";
  protected final String TEXT_717 = ");";
  protected final String TEXT_718 = NL + "                                ";
  protected final String TEXT_719 = ".writeFloat(this.";
  protected final String TEXT_720 = ");";
  protected final String TEXT_721 = NL + "                                byte[] bytes_";
  protected final String TEXT_722 = " = this.";
  protected final String TEXT_723 = ".unscaledValue().toByteArray();" + NL + "                                short length_";
  protected final String TEXT_724 = " = (short)bytes_";
  protected final String TEXT_725 = ".length;" + NL + "                                short scale_";
  protected final String TEXT_726 = " = (short)this.";
  protected final String TEXT_727 = ".scale();";
  protected final String TEXT_728 = NL + "                                ";
  protected final String TEXT_729 = ".writeShort(length_";
  protected final String TEXT_730 = ");";
  protected final String TEXT_731 = NL + "                                ";
  protected final String TEXT_732 = ".write(bytes_";
  protected final String TEXT_733 = ");";
  protected final String TEXT_734 = NL + "                                ";
  protected final String TEXT_735 = ".writeShort(scale_";
  protected final String TEXT_736 = ");";
  protected final String TEXT_737 = NL + "                                ";
  protected final String TEXT_738 = ".writeInt(this.";
  protected final String TEXT_739 = ");";
  protected final String TEXT_740 = NL + "                                ";
  protected final String TEXT_741 = ".writeLong(this.";
  protected final String TEXT_742 = ");";
  protected final String TEXT_743 = NL + "                                Don't support Object type: column--";
  protected final String TEXT_744 = NL + "                                ";
  protected final String TEXT_745 = ".writeShort(this.";
  protected final String TEXT_746 = ");";
  protected final String TEXT_747 = NL + "                                byte[] bytes_";
  protected final String TEXT_748 = " = this.";
  protected final String TEXT_749 = ".getBytes(\"UTF-8\");";
  protected final String TEXT_750 = NL + "                                ";
  protected final String TEXT_751 = ".writeInt(bytes_";
  protected final String TEXT_752 = ".length);";
  protected final String TEXT_753 = NL + "                                ";
  protected final String TEXT_754 = ".write(bytes_";
  protected final String TEXT_755 = ");";
  protected final String TEXT_756 = NL + "                                Don't support List type: column--";
  protected final String TEXT_757 = NL + "                                Don't support Document type: column--";
  protected final String TEXT_758 = NL + "                                Don't support Dynamic type: column--";
  protected final String TEXT_759 = NL + "                        }";
  protected final String TEXT_760 = NL + "                        this.";
  protected final String TEXT_761 = " = ";
  protected final String TEXT_762 = ".read";
  protected final String TEXT_763 = "();";
  protected final String TEXT_764 = NL + "                        int length_";
  protected final String TEXT_765 = " = ";
  protected final String TEXT_766 = ".readInt();" + NL + "                        if(length_";
  protected final String TEXT_767 = " == -1){";
  protected final String TEXT_768 = NL + "                        if(";
  protected final String TEXT_769 = ".readByte() == -1){";
  protected final String TEXT_770 = NL + "                            this.";
  protected final String TEXT_771 = " = null;" + NL + "                        }else{";
  protected final String TEXT_772 = NL + "                                this.";
  protected final String TEXT_773 = " = ";
  protected final String TEXT_774 = ".readBoolean();";
  protected final String TEXT_775 = NL + "                                this.";
  protected final String TEXT_776 = " = ";
  protected final String TEXT_777 = ".readByte();";
  protected final String TEXT_778 = NL + "                                this.";
  protected final String TEXT_779 = " = new byte[length_";
  protected final String TEXT_780 = "];";
  protected final String TEXT_781 = NL + "                                ";
  protected final String TEXT_782 = ".readFully(this.";
  protected final String TEXT_783 = ");";
  protected final String TEXT_784 = NL + "                                this.";
  protected final String TEXT_785 = " = ";
  protected final String TEXT_786 = ".readChar();";
  protected final String TEXT_787 = NL + "                                this.";
  protected final String TEXT_788 = " = new java.util.Date(";
  protected final String TEXT_789 = ".readLong());";
  protected final String TEXT_790 = NL + "                                this.";
  protected final String TEXT_791 = " = ";
  protected final String TEXT_792 = ".readDouble();";
  protected final String TEXT_793 = NL + "                                this.";
  protected final String TEXT_794 = " = ";
  protected final String TEXT_795 = ".readFloat();";
  protected final String TEXT_796 = NL + "                                int length_";
  protected final String TEXT_797 = " = ";
  protected final String TEXT_798 = ".readShort();" + NL + "                                byte[] bytes_";
  protected final String TEXT_799 = " = new byte[length_";
  protected final String TEXT_800 = "];";
  protected final String TEXT_801 = NL + "                                ";
  protected final String TEXT_802 = ".readFully(bytes_";
  protected final String TEXT_803 = ");" + NL + "                                int scale_";
  protected final String TEXT_804 = " = ";
  protected final String TEXT_805 = ".readShort();" + NL + "                                this.";
  protected final String TEXT_806 = " = new java.math.BigDecimal(new java.math.BigInteger(bytes_";
  protected final String TEXT_807 = "), scale_";
  protected final String TEXT_808 = ");";
  protected final String TEXT_809 = NL + "                                this.";
  protected final String TEXT_810 = " = ";
  protected final String TEXT_811 = ".readInt();";
  protected final String TEXT_812 = NL + "                                this.";
  protected final String TEXT_813 = " = ";
  protected final String TEXT_814 = ".readLong();";
  protected final String TEXT_815 = NL + "                                Don't support Object type: column--";
  protected final String TEXT_816 = NL + "                                this.";
  protected final String TEXT_817 = " = ";
  protected final String TEXT_818 = ".readShort();";
  protected final String TEXT_819 = NL + "                                int length_";
  protected final String TEXT_820 = " = ";
  protected final String TEXT_821 = ".readInt();" + NL + "                                byte[] bytes_";
  protected final String TEXT_822 = " = new byte[length_";
  protected final String TEXT_823 = "];";
  protected final String TEXT_824 = NL + "                                ";
  protected final String TEXT_825 = ".readFully(bytes_";
  protected final String TEXT_826 = ", 0, length_";
  protected final String TEXT_827 = ");" + NL + "                                this.";
  protected final String TEXT_828 = " = new String(bytes_";
  protected final String TEXT_829 = ", 0, length_";
  protected final String TEXT_830 = ", \"UTF-8\");";
  protected final String TEXT_831 = NL + "                                Don't support List type: column--";
  protected final String TEXT_832 = NL + "                                Don't support Document type: column--";
  protected final String TEXT_833 = NL + "                                Don't support Dynamic type: column--";
  protected final String TEXT_834 = NL + "                        }";
  protected final String TEXT_835 = NL + "            final int prime = 31;" + NL + "            int result = 1;";
  protected final String TEXT_836 = NL + "                            result = prime * result + (this.";
  protected final String TEXT_837 = " ? 1231 : 1237);";
  protected final String TEXT_838 = NL + "                            result = prime * result + (int) this.";
  protected final String TEXT_839 = ";";
  protected final String TEXT_840 = NL + "                        result = prime * result + java.util.Arrays.hashCode(this.";
  protected final String TEXT_841 = ");";
  protected final String TEXT_842 = NL + "                        result = prime * result + ((this.";
  protected final String TEXT_843 = " == null) ? 0 : this.";
  protected final String TEXT_844 = ".hashCode());";
  protected final String TEXT_845 = NL + "            return result;";
  protected final String TEXT_846 = NL + "            if (this == ";
  protected final String TEXT_847 = ") return true;" + NL + "            if (";
  protected final String TEXT_848 = " == null) return false;" + NL + "            if (getClass() != ";
  protected final String TEXT_849 = ".getClass()) return false;" + NL + "            final ";
  protected final String TEXT_850 = " other = (";
  protected final String TEXT_851 = ") ";
  protected final String TEXT_852 = ";";
  protected final String TEXT_853 = NL + "                        if (this.";
  protected final String TEXT_854 = " != other.";
  protected final String TEXT_855 = ")" + NL + "                            return false;";
  protected final String TEXT_856 = NL + "                        if(!java.util.Arrays.equals(this.";
  protected final String TEXT_857 = ", other.";
  protected final String TEXT_858 = ")) {" + NL + "                            return false;" + NL + "                        }";
  protected final String TEXT_859 = NL + "                        if (this.";
  protected final String TEXT_860 = " == null) {" + NL + "                            if (other.";
  protected final String TEXT_861 = " != null)" + NL + "                                return false;" + NL + "                        } else if (!this.";
  protected final String TEXT_862 = ".equals(other.";
  protected final String TEXT_863 = "))" + NL + "                            return false;";
  protected final String TEXT_864 = NL + "            return true;";
  protected final String TEXT_865 = NL + "            int returnValue = -1;";
  protected final String TEXT_866 = NL + "                    returnValue = checkNullsAndCompare(this.";
  protected final String TEXT_867 = ", ";
  protected final String TEXT_868 = ".";
  protected final String TEXT_869 = ");" + NL + "                    if(returnValue != 0) {" + NL + "                        return returnValue;" + NL + "                    }";
  protected final String TEXT_870 = NL + "            return returnValue;";
  protected final String TEXT_871 = NL + "            public static class ";
  protected final String TEXT_872 = " implements ";
  protected final String TEXT_873 = " {" + NL;
  protected final String TEXT_874 = NL + "                    public ";
  protected final String TEXT_875 = " ";
  protected final String TEXT_876 = NL + "                        = ' '";
  protected final String TEXT_877 = ";";
  protected final String TEXT_878 = NL;
  protected final String TEXT_879 = NL + NL + "                public int hashCode() {";
  protected final String TEXT_880 = NL + "                }" + NL + "" + NL + "                public boolean equals(Object obj) {";
  protected final String TEXT_881 = NL + "                }" + NL + "" + NL + "                public String toString() {" + NL + "                    StringBuilder sb = new StringBuilder();" + NL + "                    sb.append(super.toString());" + NL + "                    sb.append(\"[\");";
  protected final String TEXT_882 = NL + "                                sb.append(\"";
  protected final String TEXT_883 = "=\"+";
  protected final String TEXT_884 = ");";
  protected final String TEXT_885 = NL + "                                sb.append(\"";
  protected final String TEXT_886 = "=\"+String.valueOf(";
  protected final String TEXT_887 = "));";
  protected final String TEXT_888 = NL + "                    sb.append(\"]\");" + NL + "" + NL + "                    return sb.toString();" + NL + "                }" + NL + "" + NL + "                public void write(DataOutput out) throws IOException {";
  protected final String TEXT_889 = NL + "                }" + NL + "" + NL + "                public void readFields(DataInput in) throws IOException {";
  protected final String TEXT_890 = NL + "                }" + NL + "" + NL + "                public int compareTo(";
  protected final String TEXT_891 = " other) {";
  protected final String TEXT_892 = NL + "                }" + NL + "" + NL + "                private int checkNullsAndCompare(Object object1, Object object2) {" + NL + "                    int returnValue = 0;" + NL + "                    if (object1 instanceof Comparable && object2 instanceof Comparable) {" + NL + "                        returnValue = ((Comparable) object1).compareTo(object2);" + NL + "                    } else if (object1 != null && object2 != null) {" + NL + "                        returnValue = compareStrings(object1.toString(), object2.toString());" + NL + "                    } else if (object1 == null && object2 != null) {" + NL + "                        returnValue = 1;" + NL + "                    } else if (object1 != null && object2 == null) {" + NL + "                        returnValue = -1;" + NL + "                    } else {" + NL + "                        returnValue = 0;" + NL + "                    }" + NL + "" + NL + "                    return returnValue;" + NL + "                }" + NL + "" + NL + "                private int compareStrings(String string1, String string2) {" + NL + "                    return string1.compareTo(string2);" + NL + "                }" + NL;
  protected final String TEXT_893 = NL + "            }";
  protected final String TEXT_894 = NL + "                static{" + NL + "                    WritableComparator.define(";
  protected final String TEXT_895 = ".class, new ";
  protected final String TEXT_896 = "());" + NL + "                }";
  protected final String TEXT_897 = NL + "            ";
  protected final String TEXT_898 = " ";
  protected final String TEXT_899 = " = value_";
  protected final String TEXT_900 = ";";
  protected final String TEXT_901 = NL + "                    ";
  protected final String TEXT_902 = ".";
  protected final String TEXT_903 = " = ";
  protected final String TEXT_904 = ".";
  protected final String TEXT_905 = ";";
  protected final String TEXT_906 = NL + "                    ";
  protected final String TEXT_907 = ".";
  protected final String TEXT_908 = " = ";
  protected final String TEXT_909 = ".";
  protected final String TEXT_910 = ";";
  protected final String TEXT_911 = NL + "            ";
  protected final String TEXT_912 = " ";
  protected final String TEXT_913 = " = key_";
  protected final String TEXT_914 = ";" + NL + "            while(values_";
  protected final String TEXT_915 = ".hasNext()){";
  protected final String TEXT_916 = NL + "                ";
  protected final String TEXT_917 = " ";
  protected final String TEXT_918 = " = values_";
  protected final String TEXT_919 = ".next();" + NL;
  protected final String TEXT_920 = NL + "                    ";
  protected final String TEXT_921 = ".";
  protected final String TEXT_922 = " = ";
  protected final String TEXT_923 = ".";
  protected final String TEXT_924 = ";";
  protected final String TEXT_925 = NL + "                    ";
  protected final String TEXT_926 = ".";
  protected final String TEXT_927 = " = ";
  protected final String TEXT_928 = ".";
  protected final String TEXT_929 = ";";
  protected final String TEXT_930 = NL + "            }";
  protected final String TEXT_931 = NL;
  protected final String TEXT_932 = NL + "    ";
  protected final String TEXT_933 = "\t";
  protected final String TEXT_934 = "\t" + NL + "\t";
  protected final String TEXT_935 = NL + "    ";
  protected final String TEXT_936 = "\tstatic class NaturalKeyPartitioner_";
  protected final String TEXT_937 = " implements org.apache.hadoop.mapred.Partitioner<";
  protected final String TEXT_938 = ", Writable> {" + NL + "\t\tprivate ContextProperties context;" + NL + "\t\t";
  protected final String TEXT_939 = "[] quantiles_";
  protected final String TEXT_940 = ";" + NL + "\t\tCompositeKeyComparator_";
  protected final String TEXT_941 = " comparator_";
  protected final String TEXT_942 = ";" + NL + "\t\t" + NL + "\t\tpublic int getPartition(";
  protected final String TEXT_943 = " key, Writable value, int splitNum) {" + NL + "\t\t\tint pos = java.util.Arrays.binarySearch(quantiles_";
  protected final String TEXT_944 = ", key, comparator_";
  protected final String TEXT_945 = ") + 1;" + NL + "\t\t\tpos = (pos < 0) ? -pos : pos;" + NL + "\t\t\treturn Math.min(pos, splitNum - 1);" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void configure(JobConf conf_";
  protected final String TEXT_946 = ") {" + NL + "\t\t\tcontext = new ContextProperties(conf_";
  protected final String TEXT_947 = ");" + NL + "\t\t\tJobConf job_";
  protected final String TEXT_948 = " = new JobConf(conf_";
  protected final String TEXT_949 = ");" + NL + "\t\t\tjob_";
  protected final String TEXT_950 = ".setInputFormat(";
  protected final String TEXT_951 = "InputFormat.class);" + NL + "\t\t\t";
  protected final String TEXT_952 = "InputFormat.setInputPaths(job_";
  protected final String TEXT_953 = ", new Path(" + NL + "\t\t\t\t\t";
  protected final String TEXT_954 = "));" + NL + "\t\t\t";
  protected final String TEXT_955 = "InputFormat inputFormat_";
  protected final String TEXT_956 = " = new ";
  protected final String TEXT_957 = "InputFormat();" + NL + "\t\t\t" + NL + "\t\t\ttry {" + NL + "\t\t\t\tInputSplit[] inputSplits_";
  protected final String TEXT_958 = " = inputFormat_";
  protected final String TEXT_959 = ".getSplits(job_";
  protected final String TEXT_960 = ", 0);" + NL + "\t\t\t\tInputSplit inputSplit_";
  protected final String TEXT_961 = " = inputSplits_";
  protected final String TEXT_962 = "[0];" + NL + "\t\t\t\tRecordReader reader_";
  protected final String TEXT_963 = " = inputFormat_";
  protected final String TEXT_964 = ".getRecordReader(inputSplit_";
  protected final String TEXT_965 = "," + NL + "\t\t\t\t\t\tjob_";
  protected final String TEXT_966 = ", null);" + NL + "\t\t\t\t";
  protected final String TEXT_967 = " value_";
  protected final String TEXT_968 = " = (";
  protected final String TEXT_969 = ")reader_";
  protected final String TEXT_970 = ".createValue();" + NL + "" + NL + "\t\t\t\tjava.util.List<WritableComparable> quantilesList_";
  protected final String TEXT_971 = " = new java.util.ArrayList<WritableComparable>();" + NL + "\t\t\t\twhile(reader_";
  protected final String TEXT_972 = ".next(null, value_";
  protected final String TEXT_973 = ")) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_974 = " newkey_";
  protected final String TEXT_975 = " = new ";
  protected final String TEXT_976 = "();" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_977 = NL + "\t\t\t\t\t\t\tnewkey_";
  protected final String TEXT_978 = ".";
  protected final String TEXT_979 = " = value_";
  protected final String TEXT_980 = ".";
  protected final String TEXT_981 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_982 = "\t\t" + NL + "\t\t\t\t\tquantilesList_";
  protected final String TEXT_983 = ".add(newkey_";
  protected final String TEXT_984 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t\tquantiles_";
  protected final String TEXT_985 = " = quantilesList_";
  protected final String TEXT_986 = NL + "\t\t\t\t\t\t.toArray(new ";
  protected final String TEXT_987 = "[0]);" + NL + "\t\t\t} catch (java.io.IOException e) {" + NL + "\t\t\t\t// TODO Auto-generated catch block" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t}" + NL + "\t\t\tcomparator_";
  protected final String TEXT_988 = " = new CompositeKeyComparator_";
  protected final String TEXT_989 = "();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_990 = NL + "        public static class ";
  protected final String TEXT_991 = "InputFormat extends FileInputFormat<NullWritable, ";
  protected final String TEXT_992 = "> {" + NL + "            private ContextProperties context;" + NL + "" + NL + "            public final static String EXT = \".avro\";" + NL;
  protected final String TEXT_993 = NL + "            private boolean ignoreInputPath = false;" + NL + "" + NL + "            protected boolean isIgnoreInputPath() {" + NL + "                return ignoreInputPath;" + NL + "            }" + NL + "" + NL + "            protected void setIgnoreInputPath(boolean ignoreInputPath) {" + NL + "                this.ignoreInputPath = ignoreInputPath;" + NL + "            }" + NL + NL;
  protected final String TEXT_994 = NL + NL + "            protected org.apache.hadoop.fs.FileStatus[] listStatus(JobConf conf) throws IOException {" + NL + "                List<org.apache.hadoop.fs.FileStatus> result = new java.util.ArrayList<org.apache.hadoop.fs.FileStatus>();" + NL + "                for (org.apache.hadoop.fs.FileStatus file : super.listStatus(conf)) {" + NL + "                      if (file.getPath().getName().endsWith(EXT)) {" + NL + "                        result.add(file);" + NL + "                    }" + NL + "                }" + NL + "                return result.toArray(new org.apache.hadoop.fs.FileStatus[0]);" + NL + "              }" + NL + "" + NL + "            public InputSplit[] getSplits(JobConf job, int numSplits)" + NL + "                    throws IOException {";
  protected final String TEXT_995 = NL + "                    if(!isIgnoreInputPath()){" + NL + "                        context = new ContextProperties(job);" + NL + "                        job.set(\"mapred.input.dir\", ";
  protected final String TEXT_996 = ");";
  protected final String TEXT_997 = NL + "                            FileSystem fs = FileSystem.get(job);" + NL + "                            Path inputDir = new Path(";
  protected final String TEXT_998 = ");" + NL + "                            if (!fs.exists(inputDir)) {" + NL + "                                return new InputSplit[0];" + NL + "                            }";
  protected final String TEXT_999 = NL + "                    }";
  protected final String TEXT_1000 = NL + "                return super.getSplits(job, numSplits);" + NL + "            }" + NL + "" + NL + "            public RecordReader<NullWritable, ";
  protected final String TEXT_1001 = "> getRecordReader(" + NL + "                    InputSplit split, JobConf job, Reporter reporter)" + NL + "                    throws IOException {" + NL + "                return new AvroRecordReader(job, (FileSplit) split);" + NL + "            }" + NL + "" + NL + "            protected static class AvroRecordReader implements" + NL + "                RecordReader<NullWritable, ";
  protected final String TEXT_1002 = "> {" + NL + "" + NL + "                private ContextProperties context;" + NL + "" + NL + "                private org.apache.avro.file.FileReader<org.apache.avro.generic.GenericRecord> reader;" + NL + "                  private long start;" + NL + "                  private long end;" + NL + "" + NL + "                  org.apache.avro.generic.GenericRecord record = null;" + NL + "" + NL + "                protected AvroRecordReader(JobConf job, FileSplit split)" + NL + "                        throws IOException {" + NL + "                    this.context = new ContextProperties(job);" + NL + "" + NL + "                    //set schema" + NL + "                    List<org.apache.avro.Schema.Field> fields = new java.util.ArrayList<org.apache.avro.Schema.Field>();" + NL + "                    List<org.apache.avro.Schema> unionSchema = null;";
  protected final String TEXT_1003 = NL + "                            fields.add(new org.apache.avro.Schema.Field(\"";
  protected final String TEXT_1004 = "\",org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_1005 = "),null,null));";
  protected final String TEXT_1006 = NL + "                            unionSchema = new java.util.ArrayList<org.apache.avro.Schema>();" + NL + "                            unionSchema.add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.";
  protected final String TEXT_1007 = "));" + NL + "                            unionSchema.add(org.apache.avro.Schema.create(org.apache.avro.Schema.Type.NULL));" + NL + "                            fields.add(new org.apache.avro.Schema.Field(\"";
  protected final String TEXT_1008 = "\",org.apache.avro.Schema.createUnion(unionSchema),null,null));";
  protected final String TEXT_1009 = NL + "                    org.apache.avro.Schema schema = org.apache.avro.Schema.createRecord(fields);" + NL + "" + NL + "                    //create file reader" + NL + "                    org.apache.avro.io.DatumReader<org.apache.avro.generic.GenericRecord> datumReader = new org.apache.avro.generic.GenericDatumReader<org.apache.avro.generic.GenericRecord>(schema);" + NL + "                    reader = org.apache.avro.file.DataFileReader.openReader(new org.apache.avro.mapred.FsInput(split.getPath(),job),datumReader);" + NL + "" + NL + "                    //sync to start" + NL + "                    reader.sync(split.getStart());" + NL + "                    this.start = reader.tell();" + NL + "                    this.end = split.getStart() + split.getLength();" + NL + "" + NL + "                    record = new org.apache.avro.generic.GenericData.Record(schema);" + NL + "                }" + NL + "" + NL + "                public boolean next(NullWritable key, ";
  protected final String TEXT_1010 = " value) throws IOException {" + NL + "                    if (!reader.hasNext() || reader.pastSync(end)) {" + NL + "                        return false;" + NL + "                    }" + NL + "                    record = reader.next(record);" + NL + "" + NL + "                    Object columnObject = null;" + NL;
  protected final String TEXT_1011 = NL + "                        columnObject = record.get(\"";
  protected final String TEXT_1012 = "\");" + NL + "                        if(columnObject != null) {";
  protected final String TEXT_1013 = NL + "                                value.";
  protected final String TEXT_1014 = " = columnObject.toString();";
  protected final String TEXT_1015 = NL + "                                value.";
  protected final String TEXT_1016 = " = ((Integer)columnObject).byteValue();";
  protected final String TEXT_1017 = NL + "                                value.";
  protected final String TEXT_1018 = " = ((Integer)columnObject).shortValue();";
  protected final String TEXT_1019 = NL + "                                value.";
  protected final String TEXT_1020 = " = (Character)(char)(int)(Integer)columnObject;";
  protected final String TEXT_1021 = NL + "                                    value.";
  protected final String TEXT_1022 = " = ((java.nio.ByteBuffer)columnObject);";
  protected final String TEXT_1023 = NL + "                                    value.";
  protected final String TEXT_1024 = " = ((java.nio.ByteBuffer)columnObject).array();";
  protected final String TEXT_1025 = NL + "                                value.";
  protected final String TEXT_1026 = " = new java.math.BigDecimal(columnObject.toString());";
  protected final String TEXT_1027 = NL + "                                value.";
  protected final String TEXT_1028 = " = new java.util.Date((Long)columnObject);";
  protected final String TEXT_1029 = NL + "                                value.";
  protected final String TEXT_1030 = " = (";
  protected final String TEXT_1031 = ")columnObject;";
  protected final String TEXT_1032 = NL + "                                } else {" + NL + "                                    value.";
  protected final String TEXT_1033 = " = ";
  protected final String TEXT_1034 = ";";
  protected final String TEXT_1035 = NL + "                        }";
  protected final String TEXT_1036 = NL + "                    return true;" + NL + "                  }" + NL + "" + NL + "                public NullWritable createKey(){" + NL + "                    return NullWritable.get();" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_1037 = " createValue(){" + NL + "                    return new ";
  protected final String TEXT_1038 = "();" + NL + "                }" + NL + "" + NL + "                public long getPos() throws IOException{" + NL + "                    return reader.tell();" + NL + "                  }" + NL + "" + NL + "                public void close() throws IOException{" + NL + "                    if(reader != null){" + NL + "                        reader.close();" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                public float getProgress() throws IOException {" + NL + "                    if (start == end) {" + NL + "                        return 0.0f;" + NL + "                    } else {" + NL + "                        return Math.min(1.0f, (getPos() - start) / (float) (end - start));" + NL + "                    }" + NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_1039 = NL;
  protected final String TEXT_1040 = NL;

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
    stringBuffer.append(TEXT_120);
    
	//need to define MapperHelper before MapperGenerator, so use this trick
	class ReducerHelperBase{
		public void reduce(){
		}
		
		public void prepare(){
		}
		
		public void configure(){
		}
		
		public void close(){
		}
	}
	
	class ReducerGenerator{
		ReducerHelperBase reducer;
		
		String cid = null;
		String reducerClass = null;

		Object inKey = null;
		Object inKeyClass = null;

		Object inValue = null;
		Object inValueClass = null;

		Object outKey = null;
		Object outKeyClass = null;

		Object outValue = null;
		Object outValueClass = null;
		
		public ReducerGenerator(ReducerHelperBase reducer){
			this.reducer = reducer; 
		}
		
		public void init(String cid, Object inKey, Object inValue, Object outKey, Object outValue){
			this.cid = cid;
			this.inKey = (inKey == null ? "key_"+cid : inKey);
			this.inValue = (inValue == null ? "values_"+cid : inValue);
			this.outKey = (outKey == null ? "outputKey_"+cid : outKey);
			this.outValue = (outValue == null ? "outputValue_"+cid : outValue);
			this.reducerClass = buildClassName(cid, "r");
			this.inKeyClass = buildClassName(inKey, "row");
			this.inValueClass = buildClassName(inValue, "row");
			this.outKeyClass = buildClassName(outKey, "row");
			this.outValueClass = buildClassName(outValue, "row");
		}
		
		protected String buildClassName(String name, String type){
			if(type.equals("m")){
				return name + "Mapper";
			}else if(type.equals("r")){
				return name + "Reducer";
			}else if(type.equals("c")){
				return name + "Combiner";
			}else if(type.equals("row")){
				return name + "Struct";
			}else{
				return null;
			}
		}
		
		protected Object buildClassName(Object name, String type){
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
			
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(outValue);
    stringBuffer.append(TEXT_124);
    
		}
		public void generate(){
		
    stringBuffer.append(TEXT_125);
    stringBuffer.append(reducerClass);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(outValue);
    stringBuffer.append(TEXT_134);
    reducer.prepare();
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    if("NullWritable".equals(outKeyClass)){
    stringBuffer.append(TEXT_139);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_140);
    }else{
    stringBuffer.append(TEXT_141);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_143);
    }
    stringBuffer.append(TEXT_144);
    stringBuffer.append(outValue);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_146);
    reducer.configure();
    stringBuffer.append(TEXT_147);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    reducer.reduce();
    stringBuffer.append(TEXT_160);
    reducer.close();
    stringBuffer.append(TEXT_161);
    
		}
		public void generateConf(){
		
    stringBuffer.append(TEXT_162);
    stringBuffer.append(reducerClass);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(outValueClass);
    stringBuffer.append(TEXT_167);
    
		}
	} 
	
	class MOReducerGenerator extends ReducerGenerator{
		public MOReducerGenerator(ReducerHelperBase reducer){
			super(reducer); 
		}
		
		public void output(String outKey, String outValue){
			outKey = (outKey == null ? "outputKey_"+cid : outKey);
			
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(outValue);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(outValue);
    stringBuffer.append(TEXT_173);
    
		}
		public void generate(){
		
    stringBuffer.append(TEXT_174);
    stringBuffer.append(reducerClass);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_181);
    
				if(outValueClass instanceof java.util.Map){
					for(String key : ((java.util.Map<String, String>)outValueClass).keySet()){
					
    stringBuffer.append(TEXT_182);
    stringBuffer.append(((java.util.Map)outValueClass).get(key));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(((java.util.Map)outValue).get(key));
    stringBuffer.append(TEXT_184);
    	
					}
				}
				
    stringBuffer.append(TEXT_185);
    reducer.prepare();
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    if("NullWritable".equals(outKeyClass)){
    stringBuffer.append(TEXT_192);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_193);
    }else{
    stringBuffer.append(TEXT_194);
    stringBuffer.append(outKey);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_196);
    }
    stringBuffer.append(TEXT_197);
    
					if(outValueClass instanceof java.util.Map){
						for(String key : ((java.util.Map<String, String>)outValueClass).keySet()){
						
    stringBuffer.append(TEXT_198);
    stringBuffer.append(((java.util.Map)outValue).get(key));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(((java.util.Map)outValueClass).get(key));
    stringBuffer.append(TEXT_200);
    	
						}
					}
					
    stringBuffer.append(TEXT_201);
    reducer.configure();
    stringBuffer.append(TEXT_202);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    reducer.reduce();
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    reducer.close();
    stringBuffer.append(TEXT_214);
    
		}
		public void generateConf(){
		
    stringBuffer.append(TEXT_215);
    stringBuffer.append(reducerClass);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(inKeyClass);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(inValueClass);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    
        	java.util.Map<String, String> values = (java.util.Map<String, String>)outValue;
        	for(String key : values.keySet()){
        	
    stringBuffer.append(TEXT_221);
    stringBuffer.append(values.get(key));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(outKeyClass);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(getOutValueClass(key));
    stringBuffer.append(TEXT_224);
    
        	}
		}
	}
	
	class CombinerGenerator extends ReducerGenerator{
		public CombinerGenerator(ReducerHelperBase reducer){
			super(reducer); 
		}
		public void init(String cid, Object inKey, Object inValue, Object outKey, Object outValue){
			super.init(cid, inKey, inValue, outKey, outValue);
			this.reducerClass = buildClassName(cid, "c");
		}
		public void generateConf(){
		
    stringBuffer.append(TEXT_225);
    stringBuffer.append(reducerClass);
    stringBuffer.append(TEXT_226);
    			
		}
	}
	
	final String R_TYPE_BASE = "base";
	final String R_TYPE_MO = "mo";
	final String R_TYPE_COMBINER = "combiner";
	
	class ReducerHelper extends ReducerHelperBase{
		
		ReducerGenerator reducerGen;
		
		String cid = null;
		
		public void setType(String type){
			if(type.equals(R_TYPE_BASE)){
				reducerGen = new ReducerGenerator(this);
			}else if(type.equals(R_TYPE_MO)){
				reducerGen = new MOReducerGenerator(this);
			}else if(type.equals(R_TYPE_COMBINER)){
				reducerGen = new CombinerGenerator(this);
			}
		}
		
		public void init(String cid, String inKey, String inValue, String outKey, Object outValue){
			if(reducerGen == null){
				reducerGen = new ReducerGenerator(this);
			}
			reducerGen.init(cid, inKey, inValue, outKey, outValue);
			this.cid = reducerGen.cid;
		}
		
		public String getInKeyClass(String name){
			return reducerGen.getInKeyClass(name);
		}
		
		public String getInKeyClass(){
			return reducerGen.getInKeyClass();
		}
		
		public String getInKey(String name){
			return reducerGen.getInKey(name);
		}
		
		public String getInKey(){
			return reducerGen.getInKey();
		}
		
		public String getOutKeyClass(String name){
			return reducerGen.getOutKeyClass(name);
		}
		
		public String getOutKeyClass(){
			return reducerGen.getOutKeyClass();
		}
		
		public String getOutKey(String name){
			return reducerGen.getOutKey(name);
		}
		
		public String getOutKey(){
			return reducerGen.getOutKey();
		}
		
		public String getInValueClass(String name){
			return reducerGen.getInValueClass(name);
		}
		
		public String getInValueClass(){
			return reducerGen.getInValueClass();
		}
		
		public String getInValue(String name){
			return reducerGen.getInValue(name);
		}
		
		public String getInValue(){
			return reducerGen.getInValue();
		}
		
		public String getOutValueClass(String name){
			return reducerGen.getOutValueClass(name);
		}
		
		public String getOutValueClass(){
			return reducerGen.getOutValueClass();
		}
		
		public String getOutValue(String name){
			return reducerGen.getOutValue(name);
		}
		
		public String getOutValue(){
			return reducerGen.getOutValue();
		}
		
		public void output(String outKey, String outValue){
			reducerGen.output(outKey, outValue);
		}
		
		public void generate(){
			reducerGen.generate();
		}
		
		public void generateConf(){
			reducerGen.generateConf();
		}
		
		public void reduce(){
		}
		
		public void prepare(){
		}
		
		public void configure(){
		}
		
		public void close(){
		}
	}
	
    stringBuffer.append(TEXT_227);
    
	class ComparatorHelper{
		String className;
		List<IMetadataColumn> columns;
		String structName;
		Map<String, Boolean> criterias;
		List<String> orders;
		boolean unorder = false;
		Map<String, Boolean> sortTypes; // false means sort by alpha
		boolean genObjectCompare = false;
		
		public void init(String className, List<IMetadataColumn> columns, String structName){
			this.className = className;
			this.columns = columns;
			this.structName = structName;
			orders = new java.util.ArrayList<String>();
			criterias = new java.util.HashMap<String, Boolean>();
			sortTypes = new java.util.HashMap<String, Boolean>();
			for(IMetadataColumn column : columns){
				orders.add(column.getLabel());
				criterias.put(column.getLabel(), true);
				sortTypes.put(column.getLabel(), true);
			}
		}
		public void setGenObjectCompare(Boolean genObjectCompare){
			this.genObjectCompare = genObjectCompare;
		}
		//true is asc
		//false is desc
		public void setCriterias(Map<String,Boolean> criterias){
			this.criterias = criterias;
		}
		
		public void setOrders(List<String> orders){
			this.orders = orders;
			int index = 0;
			for(String order : orders){
				for(int i = 0; i < columns.size(); i++){
					if(order.equals(columns.get(i).getLabel())){
						if(i < index){
							unorder = true;
						}else{
							index = i;
						}
						break;
					}
				}
				if(unorder){
					break;
				}
			}
		}
		
		public void setSortTypes(Map<String, Boolean> sortTypes){
			this.sortTypes = sortTypes;
		}
		
		private void greater(String columnName){
			if(unorder){
				addGreater(columnName);
			}else{
				genGreater(columnName);
			}
		}
		private void lesser(String columnName){
			if(unorder){
				addLesser(columnName);
			}else{
				genLesser(columnName);
			}			
		}
		private void addGreater(String columnName){
		
    stringBuffer.append(TEXT_228);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_229);
    
		}
		private void addLesser(String columnName){
		
    stringBuffer.append(TEXT_230);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_231);
    	
		}
		private void genGreater(String columnName){
			if(criterias.get(columnName)){
			
    stringBuffer.append(TEXT_232);
    	
			}else{
			
    stringBuffer.append(TEXT_233);
    
			}
		}
		private void genLesser(String columnName){
			if(criterias.get(columnName)){
			
    stringBuffer.append(TEXT_234);
    	
			}else{
			
    stringBuffer.append(TEXT_235);
    
			}
		}
		
		private void skipColumn(IMetadataColumn column){
			boolean nullable = !JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			String columnName = column.getLabel();
			if(nullable){
				if(typeToGenerate.equals("byte[]")){
				
    stringBuffer.append(TEXT_236);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_238);
    
				}else{
	       		
    stringBuffer.append(TEXT_239);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_241);
    
	        	}
				
    stringBuffer.append(TEXT_242);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_248);
    }
    stringBuffer.append(TEXT_249);
    
				if(typeToGenerate.equalsIgnoreCase("Boolean")){
	        	
    stringBuffer.append(TEXT_250);
    
	        	}else if(typeToGenerate.equalsIgnoreCase("Byte")){
	            
    stringBuffer.append(TEXT_251);
    
	            }else if(typeToGenerate.equals("byte[]")){
	            
    stringBuffer.append(TEXT_252);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_254);
    
	            }else if(typeToGenerate.equalsIgnoreCase("Char") || typeToGenerate.equalsIgnoreCase("Character")){
	            
    stringBuffer.append(TEXT_255);
    
	            }else if(typeToGenerate.equals("java.util.Date")){
	            
    stringBuffer.append(TEXT_256);
    
	            }else if(typeToGenerate.equalsIgnoreCase("Double")){
	            
    stringBuffer.append(TEXT_257);
    
	            }else if(typeToGenerate.equalsIgnoreCase("Float")){
	            
    stringBuffer.append(TEXT_258);
    
	            }else if(typeToGenerate.equals("BigDecimal")){
	            
    stringBuffer.append(TEXT_259);
    
	            }else if(typeToGenerate.equalsIgnoreCase("Integer") || typeToGenerate.equalsIgnoreCase("int")){
	            
    stringBuffer.append(TEXT_260);
    
	            }else if(typeToGenerate.equalsIgnoreCase("Long")){
	            
    stringBuffer.append(TEXT_261);
    
	            }else if(typeToGenerate.equals("Object")){
	            
    stringBuffer.append(TEXT_262);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_263);
    
	            }else if(typeToGenerate.equalsIgnoreCase("Short")){
	            
    stringBuffer.append(TEXT_264);
    
	            }else if(typeToGenerate.equals("String")){
	            
    stringBuffer.append(TEXT_265);
    
	            }else if(typeToGenerate.equals("List")){
	            
    stringBuffer.append(TEXT_266);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_267);
    
	            }else if(typeToGenerate.equals("Doucument")){
	            
    stringBuffer.append(TEXT_268);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_269);
    
	            }else if(typeToGenerate.equals("Dynamic")){
	            
    stringBuffer.append(TEXT_270);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_271);
    
	            }
				
    if(nullable){
    stringBuffer.append(TEXT_272);
    
        	}
		}
		
		private void compareColumn(IMetadataColumn column){
			boolean nullable = !JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			String columnName = column.getLabel();
			if(nullable){
				if(typeToGenerate.equals("byte[]")){
				
    stringBuffer.append(TEXT_273);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_279);
    
				}else{
	       		
    stringBuffer.append(TEXT_280);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_282);
    
	        	}
				
    stringBuffer.append(TEXT_283);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_285);
    lesser(columnName);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_288);
    greater(columnName);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_291);
    }
    stringBuffer.append(TEXT_292);
    
				if(typeToGenerate.equalsIgnoreCase("Boolean")){
	        	
    stringBuffer.append(TEXT_293);
    greater(columnName);
    stringBuffer.append(TEXT_294);
    lesser(columnName);
    stringBuffer.append(TEXT_295);
    
	        	}else if(typeToGenerate.equalsIgnoreCase("Byte")){
	            
    stringBuffer.append(TEXT_296);
    greater(columnName);
    stringBuffer.append(TEXT_297);
    lesser(columnName);
    stringBuffer.append(TEXT_298);
    
	            }else if(typeToGenerate.equals("byte[]")){
	            
    stringBuffer.append(TEXT_299);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_303);
    greater(columnName);
    stringBuffer.append(TEXT_304);
    lesser(columnName);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_309);
    greater(columnName);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_312);
    lesser(columnName);
    stringBuffer.append(TEXT_313);
    
	            }else if(typeToGenerate.equalsIgnoreCase("Char") || typeToGenerate.equalsIgnoreCase("Character")){
	            
    stringBuffer.append(TEXT_314);
    greater(columnName);
    stringBuffer.append(TEXT_315);
    lesser(columnName);
    stringBuffer.append(TEXT_316);
    
	            }else if(typeToGenerate.equals("java.util.Date")){
	        	
    stringBuffer.append(TEXT_317);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_319);
    
	            	if(!sortTypes.get(columnName)){
	            	
    stringBuffer.append(TEXT_320);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_326);
    greater(columnName);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_328);
    lesser(columnName);
    stringBuffer.append(TEXT_329);
    	
	            	}else{
	            	
    stringBuffer.append(TEXT_330);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_332);
    greater(columnName);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_335);
    lesser(columnName);
    stringBuffer.append(TEXT_336);
    
	            	}
	            }else if(typeToGenerate.equalsIgnoreCase("Double")){
	            
    stringBuffer.append(TEXT_337);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_339);
    
	            	if(!sortTypes.get(columnName)){
	            	
    stringBuffer.append(TEXT_340);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_344);
    greater(columnName);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_346);
    lesser(columnName);
    stringBuffer.append(TEXT_347);
    	
	            	}else{
	            	
    stringBuffer.append(TEXT_348);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_350);
    greater(columnName);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_353);
    lesser(columnName);
    stringBuffer.append(TEXT_354);
    
	            	}
	            }else if(typeToGenerate.equalsIgnoreCase("Float")){
	            
    stringBuffer.append(TEXT_355);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_357);
    
	                if(!sortTypes.get(columnName)){
	            	
    stringBuffer.append(TEXT_358);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_362);
    greater(columnName);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_364);
    lesser(columnName);
    stringBuffer.append(TEXT_365);
    	
	            	}else{
	                
    stringBuffer.append(TEXT_366);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_368);
    greater(columnName);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_371);
    lesser(columnName);
    stringBuffer.append(TEXT_372);
    
	            	}
	            }else if(typeToGenerate.equals("BigDecimal")){
	            
    stringBuffer.append(TEXT_373);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_389);
    
	                if(!sortTypes.get(columnName)){
	            	
    stringBuffer.append(TEXT_390);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_393);
    	
	            	}else{
	                
    stringBuffer.append(TEXT_394);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_397);
    }
    stringBuffer.append(TEXT_398);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_399);
    greater(columnName);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_401);
    lesser(columnName);
    stringBuffer.append(TEXT_402);
    
	            }else if(typeToGenerate.equalsIgnoreCase("Integer") || typeToGenerate.equalsIgnoreCase("int")){
	            
    stringBuffer.append(TEXT_403);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_405);
    
	                if(!sortTypes.get(columnName)){
	            	
    stringBuffer.append(TEXT_406);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_410);
    greater(columnName);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_412);
    lesser(columnName);
    stringBuffer.append(TEXT_413);
    	
	            	}else{
	                
    stringBuffer.append(TEXT_414);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_416);
    greater(columnName);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_419);
    lesser(columnName);
    stringBuffer.append(TEXT_420);
    
	            	}
	            }else if(typeToGenerate.equalsIgnoreCase("Long")){
	            
    stringBuffer.append(TEXT_421);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_423);
    
	                if(!sortTypes.get(columnName)){
	            	
    stringBuffer.append(TEXT_424);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_428);
    greater(columnName);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_430);
    lesser(columnName);
    stringBuffer.append(TEXT_431);
    	
	            	}else{
	                
    stringBuffer.append(TEXT_432);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_434);
    greater(columnName);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_437);
    lesser(columnName);
    stringBuffer.append(TEXT_438);
    
	            	}
	            }else if(typeToGenerate.equals("Object")){
	            
    stringBuffer.append(TEXT_439);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_440);
    
	            }else if(typeToGenerate.equalsIgnoreCase("Short")){
	            
    stringBuffer.append(TEXT_441);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_443);
    
	                if(!sortTypes.get(columnName)){
	            	
    stringBuffer.append(TEXT_444);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_448);
    greater(columnName);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_450);
    lesser(columnName);
    stringBuffer.append(TEXT_451);
    	
	            	}else{
	                
    stringBuffer.append(TEXT_452);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_454);
    greater(columnName);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_457);
    lesser(columnName);
    stringBuffer.append(TEXT_458);
    
	            	}
	            }else if(typeToGenerate.equals("String")){
	            
    stringBuffer.append(TEXT_459);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_480);
    greater(columnName);
    stringBuffer.append(TEXT_481);
    lesser(columnName);
    stringBuffer.append(TEXT_482);
    
	            }else if(typeToGenerate.equals("List")){
	            
    stringBuffer.append(TEXT_483);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_484);
    
	            }else if(typeToGenerate.equals("Doucument")){
	            
    stringBuffer.append(TEXT_485);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_486);
    
	            }else if(typeToGenerate.equals("Dynamic")){
	            
    stringBuffer.append(TEXT_487);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_488);
    
	            }            	
            	
    if(nullable){
    stringBuffer.append(TEXT_489);
    
        	}
		}
		
		public void compareColumns(){
			if(columns != null){
				if(unorder){
				
    stringBuffer.append(TEXT_490);
    
				}
	            for(IMetadataColumn column : columns){
	            	String columnName = column.getLabel();
                	if(orders.contains(columnName)){
                	
    stringBuffer.append(TEXT_491);
    compareColumn(column);
    stringBuffer.append(TEXT_492);
    
                	}else{
                	
    stringBuffer.append(TEXT_493);
    skipColumn(column);
    stringBuffer.append(TEXT_494);
    	
	               	}
				}
				if(unorder){
					for(String columnName : orders){
					
    stringBuffer.append(TEXT_495);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_497);
    genGreater(columnName);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_499);
    genLesser(columnName);
    stringBuffer.append(TEXT_500);
    	
					}
				}
			}
		}
		
		public void compareAfterColumns(){
		}
		
		public void generateCode(){
		
    stringBuffer.append(TEXT_501);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_504);
    compareColumns();
    stringBuffer.append(TEXT_505);
    compareAfterColumns();
    stringBuffer.append(TEXT_506);
    if(genObjectCompare){
    stringBuffer.append(TEXT_507);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_511);
    
						for(IMetadataColumn column : columns){
			            	String columnName = column.getLabel();
		                	compareObjectColumn(column);
						}
						
    stringBuffer.append(TEXT_512);
    }
    stringBuffer.append(TEXT_513);
    
		}
		
		private void compareObjectColumn(IMetadataColumn column){
			boolean nullable = !JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			String columnName = column.getLabel();
			if(nullable){
			
    stringBuffer.append(TEXT_514);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_516);
    lesser(columnName);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_519);
    greater(columnName);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_522);
    }
    stringBuffer.append(TEXT_523);
    
				if(typeToGenerate.equalsIgnoreCase("Boolean")){
	        	
    stringBuffer.append(TEXT_524);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_527);
    greater(columnName);
    stringBuffer.append(TEXT_528);
    lesser(columnName);
    stringBuffer.append(TEXT_529);
    
	        	}else if(typeToGenerate.equalsIgnoreCase("Byte")){
	            
    stringBuffer.append(TEXT_530);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_532);
    greater(columnName);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_535);
    lesser(columnName);
    stringBuffer.append(TEXT_536);
    
	            }else if(typeToGenerate.equals("byte[]")){
	            
    stringBuffer.append(TEXT_537);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_545);
    greater(columnName);
    stringBuffer.append(TEXT_546);
    lesser(columnName);
    stringBuffer.append(TEXT_547);
    
	            }else if(typeToGenerate.equalsIgnoreCase("Char") || typeToGenerate.equalsIgnoreCase("Character")){
	            
    stringBuffer.append(TEXT_548);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_552);
    greater(columnName);
    stringBuffer.append(TEXT_553);
    lesser(columnName);
    stringBuffer.append(TEXT_554);
    
	            }else if(typeToGenerate.equals("java.util.Date")){
	        	
    stringBuffer.append(TEXT_555);
    
	            	if(!sortTypes.get(columnName)){
	            	
    stringBuffer.append(TEXT_556);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_562);
    greater(columnName);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_564);
    lesser(columnName);
    stringBuffer.append(TEXT_565);
    	
	            	}else{
	            	
    stringBuffer.append(TEXT_566);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_570);
    greater(columnName);
    stringBuffer.append(TEXT_571);
    lesser(columnName);
    stringBuffer.append(TEXT_572);
    
	            	}
	            }else if(typeToGenerate.equalsIgnoreCase("Double")){
	            
    stringBuffer.append(TEXT_573);
    
	            	if(!sortTypes.get(columnName)){
	            	
    stringBuffer.append(TEXT_574);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_578);
    greater(columnName);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_580);
    lesser(columnName);
    stringBuffer.append(TEXT_581);
    	
	            	}else{
	            	
    stringBuffer.append(TEXT_582);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_584);
    greater(columnName);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_587);
    lesser(columnName);
    stringBuffer.append(TEXT_588);
    
	            	}
	            }else if(typeToGenerate.equalsIgnoreCase("Float")){
	            
    stringBuffer.append(TEXT_589);
    
	                if(!sortTypes.get(columnName)){
	            	
    stringBuffer.append(TEXT_590);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_594);
    greater(columnName);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_596);
    lesser(columnName);
    stringBuffer.append(TEXT_597);
    	
	            	}else{
	                
    stringBuffer.append(TEXT_598);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_600);
    greater(columnName);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_603);
    lesser(columnName);
    stringBuffer.append(TEXT_604);
    
	            	}
	            }else if(typeToGenerate.equals("BigDecimal")){
	            
    stringBuffer.append(TEXT_605);
    
	                if(!sortTypes.get(columnName)){
	            	
    stringBuffer.append(TEXT_606);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_609);
    	
	            	}else{
	                
    stringBuffer.append(TEXT_610);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_613);
    }
    stringBuffer.append(TEXT_614);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_615);
    greater(columnName);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_617);
    lesser(columnName);
    stringBuffer.append(TEXT_618);
    
	            }else if(typeToGenerate.equalsIgnoreCase("Integer") || typeToGenerate.equalsIgnoreCase("int")){
	            
    stringBuffer.append(TEXT_619);
    
	                if(!sortTypes.get(columnName)){
	            	
    stringBuffer.append(TEXT_620);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_624);
    greater(columnName);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_626);
    lesser(columnName);
    stringBuffer.append(TEXT_627);
    	
	            	}else{
	                
    stringBuffer.append(TEXT_628);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_630);
    greater(columnName);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_633);
    lesser(columnName);
    stringBuffer.append(TEXT_634);
    
	            	}
	            }else if(typeToGenerate.equalsIgnoreCase("Long")){
	            
    stringBuffer.append(TEXT_635);
    
	                if(!sortTypes.get(columnName)){
	            	
    stringBuffer.append(TEXT_636);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_640);
    greater(columnName);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_642);
    lesser(columnName);
    stringBuffer.append(TEXT_643);
    	
	            	}else{
	                
    stringBuffer.append(TEXT_644);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_646);
    greater(columnName);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_649);
    lesser(columnName);
    stringBuffer.append(TEXT_650);
    
	            	}
	            }else if(typeToGenerate.equals("Object")){
	            
    stringBuffer.append(TEXT_651);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_652);
    
	            }else if(typeToGenerate.equalsIgnoreCase("Short")){
	            
    stringBuffer.append(TEXT_653);
    
	                if(!sortTypes.get(columnName)){
	            	
    stringBuffer.append(TEXT_654);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_655);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_658);
    greater(columnName);
    stringBuffer.append(TEXT_659);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_660);
    lesser(columnName);
    stringBuffer.append(TEXT_661);
    	
	            	}else{
	                
    stringBuffer.append(TEXT_662);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_664);
    greater(columnName);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_667);
    lesser(columnName);
    stringBuffer.append(TEXT_668);
    
	            	}
	            }else if(typeToGenerate.equals("String")){
	            
    stringBuffer.append(TEXT_669);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_670);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_671);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_672);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_674);
    greater(columnName);
    stringBuffer.append(TEXT_675);
    lesser(columnName);
    stringBuffer.append(TEXT_676);
    
	            }else if(typeToGenerate.equals("List")){
	            
    stringBuffer.append(TEXT_677);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_678);
    
	            }else if(typeToGenerate.equals("Doucument")){
	            
    stringBuffer.append(TEXT_679);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_680);
    
	            }else if(typeToGenerate.equals("Dynamic")){
	            
    stringBuffer.append(TEXT_681);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_682);
    
	            }            	
            	
    if(nullable){
    stringBuffer.append(TEXT_683);
    
        	}
		}
	}
	
    
    class StructHelper{
        String structName;
        List<IMetadataColumn> columns;
        java.util.Set<IMetadataColumn> columnsNonSerialized;
        String implementsClasses;
        final boolean genComparator;

        /**
         * The comparator should usually only be generated if the structure is
         * being used as an input KEY into a reduce step.
         */
        public StructHelper(String structName, List<IMetadataColumn> columns, boolean genComparator, java.util.Set<IMetadataColumn> columnsNonSerialized) {
            this.structName = structName + "Struct";
            this.columns = columns;
            this.columnsNonSerialized = columnsNonSerialized;
            this.implementsClasses = "WritableComparable<"+this.structName+">";
            this.genComparator = genComparator;
        }

        public StructHelper(String structName, List<IMetadataColumn> columns, boolean genComparator) {
            this.structName = structName + "Struct";
            this.columns = columns;
            this.implementsClasses = "WritableComparable<"+this.structName+">";
            this.genComparator = genComparator;
        }

        public String getStructName(){
            return structName;
        }

        public void appendImplClasses(String className){
            this.implementsClasses += ",";
            this.implementsClasses += className;
        }

        public void overrideWrite(String dataOutput){
            if (columns !=null) {
                for (IMetadataColumn column: columns) {
                    if (columnsNonSerialized != null && columnsNonSerialized.contains(columns))
                        continue;
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

                    if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
                        typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
                        
    stringBuffer.append(TEXT_684);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_687);
    
                    } else{
                        
    stringBuffer.append(TEXT_688);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_689);
    
                            if(typeToGenerate.equals("byte[]")){
                            
    stringBuffer.append(TEXT_690);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_691);
    
                            }else{
                            
    stringBuffer.append(TEXT_692);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_693);
    
                            }
                            
    stringBuffer.append(TEXT_694);
    
                            if(typeToGenerate.equals("byte[]")){
                            
    stringBuffer.append(TEXT_695);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_696);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_697);
    
                            }else{
                            
    stringBuffer.append(TEXT_698);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_699);
    
                            }
                            
    
                            if(typeToGenerate.equals("Boolean")) {
                            
    stringBuffer.append(TEXT_700);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_701);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_702);
    
                            } else if(typeToGenerate.equals("Byte")) {
                            
    stringBuffer.append(TEXT_703);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_705);
    
                            } else if(typeToGenerate.equals("byte[]")) {
                            
    stringBuffer.append(TEXT_706);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_707);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_708);
    
                            } else if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                            
    stringBuffer.append(TEXT_709);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_710);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_711);
    
                            } else if(typeToGenerate.equals("java.util.Date")) {
                            
    stringBuffer.append(TEXT_712);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_713);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_714);
    
                            } else if(typeToGenerate.equals("Double")) {
                            
    stringBuffer.append(TEXT_715);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_717);
    
                            } else if(typeToGenerate.equals("Float")) {
                            
    stringBuffer.append(TEXT_718);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_719);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_720);
    
                            } else if(typeToGenerate.equals("BigDecimal")) {
                            
    stringBuffer.append(TEXT_721);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_722);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_723);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_724);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_725);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_726);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_727);
    stringBuffer.append(TEXT_728);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_729);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_730);
    stringBuffer.append(TEXT_731);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_732);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_733);
    stringBuffer.append(TEXT_734);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_735);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_736);
    
                            } else if(typeToGenerate.equals("Integer")){
                            
    stringBuffer.append(TEXT_737);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_738);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_739);
    
                            } else if(typeToGenerate.equals("Long")) {
                            
    stringBuffer.append(TEXT_740);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_741);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_742);
    
                            } else if(typeToGenerate.equals("Object")) {
                            
    stringBuffer.append(TEXT_743);
    stringBuffer.append(column.getLabel());
    
                            } else if(typeToGenerate.equals("Short")) {
                            
    stringBuffer.append(TEXT_744);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_745);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_746);
    
                            } else if(typeToGenerate.equals("String")) {
                            
    stringBuffer.append(TEXT_747);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_748);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_749);
    stringBuffer.append(TEXT_750);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_751);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_752);
    stringBuffer.append(TEXT_753);
    stringBuffer.append(dataOutput);
    stringBuffer.append(TEXT_754);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_755);
    
                            } else if(typeToGenerate.equals("List")) {
                            
    stringBuffer.append(TEXT_756);
    stringBuffer.append(column.getLabel());
    
                            } else if(typeToGenerate.equals("Document")) {
                            
    stringBuffer.append(TEXT_757);
    stringBuffer.append(column.getLabel());
    
                            } else if(typeToGenerate.equals("Dynamic")) {
                            
    stringBuffer.append(TEXT_758);
    stringBuffer.append(column.getLabel());
    
                            }
                               
    stringBuffer.append(TEXT_759);
    
                    }
                }
            }
        }

        public void overrideReadFields(String dataInput){
            if (columns != null) {
                for (IMetadataColumn column: columns) {
                    if (columnsNonSerialized != null && columnsNonSerialized.contains(columns))
                        continue;
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

                    if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
                        typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
                        
    stringBuffer.append(TEXT_760);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_761);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_762);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_763);
    
                    }else{
                        if(typeToGenerate.equals("byte[]")){
                        
    stringBuffer.append(TEXT_764);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_765);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_766);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_767);
    
                        }else{
                           
    stringBuffer.append(TEXT_768);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_769);
    
                        }
                        
    stringBuffer.append(TEXT_770);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_771);
    
                            if(typeToGenerate.equals("Boolean")){
                            
    stringBuffer.append(TEXT_772);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_773);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_774);
    
                            } else if(typeToGenerate.equals("Byte")){
                            
    stringBuffer.append(TEXT_775);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_776);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_777);
    
                            } else if(typeToGenerate.equals("byte[]")){
                            
    stringBuffer.append(TEXT_778);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_779);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_780);
    stringBuffer.append(TEXT_781);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_782);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_783);
    
                            } else if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")){
                            
    stringBuffer.append(TEXT_784);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_785);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_786);
    
                            } else if(typeToGenerate.equals("java.util.Date")) {
                            
    stringBuffer.append(TEXT_787);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_788);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_789);
    
                            } else if(typeToGenerate.equals("Double")){
                            
    stringBuffer.append(TEXT_790);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_791);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_792);
    
                            } else if(typeToGenerate.equals("Float")){
                            
    stringBuffer.append(TEXT_793);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_794);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_795);
    
                            } else if(typeToGenerate.equals("BigDecimal")){
                            
    stringBuffer.append(TEXT_796);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_797);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_798);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_799);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_800);
    stringBuffer.append(TEXT_801);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_802);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_803);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_804);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_805);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_806);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_807);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_808);
    
                            } else if(typeToGenerate.equals("Integer")){
                            
    stringBuffer.append(TEXT_809);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_810);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_811);
    
                            } else if(typeToGenerate.equals("Long")){
                            
    stringBuffer.append(TEXT_812);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_813);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_814);
    
                            } else if(typeToGenerate.equals("Object")){
                            
    stringBuffer.append(TEXT_815);
    stringBuffer.append(column.getLabel());
    
                            } else if(typeToGenerate.equals("Short")){
                            
    stringBuffer.append(TEXT_816);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_817);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_818);
    
                            } else if(typeToGenerate.equals("String")) {
                            
    stringBuffer.append(TEXT_819);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_820);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_821);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_822);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_823);
    stringBuffer.append(TEXT_824);
    stringBuffer.append(dataInput);
    stringBuffer.append(TEXT_825);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_826);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_827);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_828);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_829);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_830);
    
                            } else if(typeToGenerate.equals("List")) {
                            
    stringBuffer.append(TEXT_831);
    stringBuffer.append(column.getLabel());
    
                            } else if(typeToGenerate.equals("Doucument")) {
                            
    stringBuffer.append(TEXT_832);
    stringBuffer.append(column.getLabel());
    
                            } else if(typeToGenerate.equals("Dynamic")){
                            
    stringBuffer.append(TEXT_833);
    stringBuffer.append(column.getLabel());
    
                            }
                            
    stringBuffer.append(TEXT_834);
    
                    }
                }
            }
        }

        public void overrideHashCode(){
        
    stringBuffer.append(TEXT_835);
    
            if (columns != null) {
                for (IMetadataColumn column: columns) {
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
                         String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                         if(javaType == JavaTypesManager.BOOLEAN) {
                        
    stringBuffer.append(TEXT_836);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_837);
    
                        } else {
                        
    stringBuffer.append(TEXT_838);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_839);
    
                        }
                    } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
                        
    stringBuffer.append(TEXT_840);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_841);
    
                    } else {
                    
    stringBuffer.append(TEXT_842);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_843);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_844);
    
                    }
                }
            }
            
    stringBuffer.append(TEXT_845);
    
        }

        public void overrideEquals(String objName){
        
    stringBuffer.append(TEXT_846);
    stringBuffer.append(objName);
    stringBuffer.append(TEXT_847);
    stringBuffer.append(objName);
    stringBuffer.append(TEXT_848);
    stringBuffer.append(objName);
    stringBuffer.append(TEXT_849);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_850);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_851);
    stringBuffer.append(objName);
    stringBuffer.append(TEXT_852);
    
            if (columns !=null) {
                for (IMetadataColumn column: columns) {
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
                    
    stringBuffer.append(TEXT_853);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_854);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_855);
    
                    } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
                    
    stringBuffer.append(TEXT_856);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_857);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_858);
    
                    } else {
                    
    stringBuffer.append(TEXT_859);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_860);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_861);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_862);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_863);
    
                    }
                }
            }
            
    stringBuffer.append(TEXT_864);
    
        }

        public void overrideCompareTo(String otherName){
            //int returnValue = 0; ?
            
    stringBuffer.append(TEXT_865);
    
            if (columns !=null) {
                for (IMetadataColumn column: columns) {
                
    stringBuffer.append(TEXT_866);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_867);
    stringBuffer.append(otherName);
    stringBuffer.append(TEXT_868);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_869);
    
                }
            }
            
    stringBuffer.append(TEXT_870);
    
        }

        public void addMethods(){
        }

        public void declareVars(){
        }

        public void generateCode(){
        
    stringBuffer.append(TEXT_871);
    stringBuffer.append(structName );
    stringBuffer.append(TEXT_872);
    stringBuffer.append(implementsClasses);
    stringBuffer.append(TEXT_873);
    
                if (columns !=null) {
                for (IMetadataColumn column: columns) {
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    
    stringBuffer.append(TEXT_874);
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()) );
    stringBuffer.append(TEXT_875);
    stringBuffer.append(column.getLabel() );
    
                        if(javaType == JavaTypesManager.CHARACTER && !column.isNullable()) {
                        
    stringBuffer.append(TEXT_876);
    
                        }
                        
    stringBuffer.append(TEXT_877);
    
                    }
                }
                
    stringBuffer.append(TEXT_878);
    declareVars();
    stringBuffer.append(TEXT_879);
    overrideHashCode();
    stringBuffer.append(TEXT_880);
    overrideEquals("obj");
    stringBuffer.append(TEXT_881);
    
                    if (columns !=null) {
                        for(int i=0; i< columns.size(); i++) {
                            IMetadataColumn column = columns.get(i);
                            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                            if(typeToGenerate.equals("String")) {
                            
    stringBuffer.append(TEXT_882);
    stringBuffer.append(i==0?"":"," );
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_883);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_884);
    
                            }else{
                            
    stringBuffer.append(TEXT_885);
    stringBuffer.append(i==0?"":"," );
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_886);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_887);
    
                            }
                        }
                    }
                    
    stringBuffer.append(TEXT_888);
    overrideWrite("out");
    stringBuffer.append(TEXT_889);
    overrideReadFields("in");
    stringBuffer.append(TEXT_890);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_891);
    overrideCompareTo("other");
    stringBuffer.append(TEXT_892);
    addMethods();
    stringBuffer.append(TEXT_893);
    
            if(genComparator){
                ComparatorHelper StructComparator = new ComparatorHelper();
                StructComparator.init(structName + "_Comparator", columns, structName);
                StructComparator.generateCode();

                
    stringBuffer.append(TEXT_894);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_895);
    stringBuffer.append(structName + "_Comparator");
    stringBuffer.append(TEXT_896);
    
            }
        }
    }
    
    
    BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument)argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();

    List<Map<String, String>> criterias = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CRITERIA__");
    List<IMetadataColumn> listCriteriasColsTemp = new ArrayList<IMetadataColumn>();
    List<String> listCriteriasColsName = new ArrayList<String>();
    List<IMetadataColumn> listColsTemp = new ArrayList<IMetadataColumn>();
    List<IMetadataTable> metadatas = node.getMetadataList();
    if((metadatas!=null)&&(metadatas.size()>0)){
        IMetadataTable metadata = metadatas.get(0);
        if(metadata!=null){
            for(int i = 0; i < criterias.size(); i++){
                Map<String, String> line = criterias.get(i);
                String colname = line.get("COLNAME");
                for(IMetadataColumn column : metadata.getListColumns()){
                    if(colname.equals(column.getLabel())){
                        listCriteriasColsTemp.add(column);
                        listCriteriasColsName.add(colname);
                    }
                }
            }
            for(IMetadataColumn column : metadata.getListColumns()){
                if(!listCriteriasColsName.contains(column.getLabel())){
                    listColsTemp.add(column);
                }
            }
        }
    }

    final List<IMetadataColumn> listCriteriasColsPrepa = listCriteriasColsTemp;
    final List<IMetadataColumn> listColsPrepa = listColsTemp;

    String inConnName = null;
    String outConnName = null;
    IMetadataTable outMetadataTableTemp = null;
    final Set<String> inputCols = new HashSet<String>();
    if(node.getIncomingConnections()!=null){
        for(IConnection incomingConn : node.getIncomingConnections()){
            if(incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
                inConnName = incomingConn.getName();
                IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
                for(IMetadataColumn inputCol : inputMetadataTable.getListColumns()){
                    inputCols.add(inputCol.getLabel());
                }
                break;
            }
        }
    }

    for(IConnection conn : node.getOutgoingConnections()){
        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
            outConnName = conn.getName();
            outMetadataTableTemp = conn.getMetadataTable();
            break;
        }
    }

    if(inputCols.isEmpty() || outMetadataTableTemp == null)
        return "";

    final IMetadataTable outMetadataTable = outMetadataTableTemp;

    StructHelper rowStruct = new StructHelper("mOutValue_"+cid, listColsPrepa, false);
    rowStruct.generateCode();

    StructHelper keyStruct = new StructHelper("mOutKey_"+cid, listCriteriasColsPrepa, true);
    keyStruct.generateCode();

    class Mapper extends MapperHelper{

        public void map(){
        
    stringBuffer.append(TEXT_897);
    stringBuffer.append(getInValueClass());
    stringBuffer.append(TEXT_898);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_899);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_900);
    
            for(IMetadataColumn outputCol : listColsPrepa){
                String columnName = outputCol.getLabel();
                if(inputCols.contains(columnName)){
                
    stringBuffer.append(TEXT_901);
    stringBuffer.append(getOutValue());
    stringBuffer.append(TEXT_902);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_903);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_904);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_905);
    
                }
            }
            for(IMetadataColumn outputCol : listCriteriasColsPrepa){
                String columnName = outputCol.getLabel();
                if(inputCols.contains(columnName)){
                
    stringBuffer.append(TEXT_906);
    stringBuffer.append(getOutKey());
    stringBuffer.append(TEXT_907);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_908);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_909);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_910);
    
                }
            }
            this.output(getOutKey(), getOutValue());
        }
    }
    Mapper mapper = new Mapper();
    mapper.init(node, cid, null, inConnName, "mOutKey_"+cid, "mOutValue_"+cid);
    mapper.generate();

    class Reducer extends ReducerHelper{

        public void reduce(){
        
    stringBuffer.append(TEXT_911);
    stringBuffer.append(getInKeyClass());
    stringBuffer.append(TEXT_912);
    stringBuffer.append(getInKey());
    stringBuffer.append(TEXT_913);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_914);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_915);
    stringBuffer.append(TEXT_916);
    stringBuffer.append(getInValueClass());
    stringBuffer.append(TEXT_917);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_918);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_919);
    
                for(IMetadataColumn column : listColsPrepa){
                
    stringBuffer.append(TEXT_920);
    stringBuffer.append(getOutValue());
    stringBuffer.append(TEXT_921);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_922);
    stringBuffer.append(getInValue());
    stringBuffer.append(TEXT_923);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_924);
    
                }
                for(IMetadataColumn column : listCriteriasColsPrepa){
                
    stringBuffer.append(TEXT_925);
    stringBuffer.append(getOutValue());
    stringBuffer.append(TEXT_926);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_927);
    stringBuffer.append(getInKey());
    stringBuffer.append(TEXT_928);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_929);
    
                }
                this.output(null, getOutValue());
                
    stringBuffer.append(TEXT_930);
    
        }
    }
    Reducer reducer = new Reducer();
    reducer.init(cid, "mOutKey_"+cid, "mOutValue_"+cid, null, outConnName);
    reducer.generate();
    
    stringBuffer.append(TEXT_931);
    stringBuffer.append(TEXT_932);
    stringBuffer.append(TEXT_933);
    stringBuffer.append(TEXT_934);
    
	List<String> listCols = new java.util.ArrayList<String>(); 
	Map<String, Boolean> criteriasOrderType = new java.util.HashMap<String, Boolean>(); 
	Map<String, Integer> criteriasSortType = new java.util.HashMap<String, Integer>();
	Map<String, Boolean> sortTypes = new java.util.HashMap<String, Boolean>(); 
	final Integer SORT_NUM = 0;
	final Integer SORT_ALPHA = 1;
	final Integer SORT_DATE = 2;
	for(int i = 0; i < criterias.size(); i++){
		Map<String, String> line = criterias.get(i);
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

	ComparatorHelper compositeKeyComparator = new ComparatorHelper();
	compositeKeyComparator.init("CompositeKeyComparator_"+cid, listCriteriasColsPrepa, mapper.getOutKeyClass());
	compositeKeyComparator.setCriterias(criteriasOrderType);
	compositeKeyComparator.setSortTypes(sortTypes);
	compositeKeyComparator.setGenObjectCompare(true);
	compositeKeyComparator.generateCode();
	
    stringBuffer.append(TEXT_935);
    stringBuffer.append(TEXT_936);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_937);
    stringBuffer.append(mapper.getOutKeyClass());
    stringBuffer.append(TEXT_938);
    stringBuffer.append(mapper.getOutKeyClass());
    stringBuffer.append(TEXT_939);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_940);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_941);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_942);
    stringBuffer.append(mapper.getOutKeyClass());
    stringBuffer.append(TEXT_943);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_944);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_945);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_946);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_947);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_948);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_949);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_950);
    stringBuffer.append(mapper.getOutKeyClass());
    stringBuffer.append(TEXT_951);
    stringBuffer.append(mapper.getOutKeyClass());
    stringBuffer.append(TEXT_952);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_953);
    stringBuffer.append(ElementParameterParser.getObjectValue(node, "__QUANTILES_FILENAME__"));
    stringBuffer.append(TEXT_954);
    stringBuffer.append(mapper.getOutKeyClass());
    stringBuffer.append(TEXT_955);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_956);
    stringBuffer.append(mapper.getOutKeyClass());
    stringBuffer.append(TEXT_957);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_958);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_959);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_960);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_961);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_962);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_963);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_964);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_965);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_966);
    stringBuffer.append(mapper.getOutKeyClass());
    stringBuffer.append(TEXT_967);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_968);
    stringBuffer.append(mapper.getOutKeyClass());
    stringBuffer.append(TEXT_969);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_970);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_971);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_972);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_973);
    stringBuffer.append(mapper.getOutKeyClass());
    stringBuffer.append(TEXT_974);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_975);
    stringBuffer.append(mapper.getOutKeyClass());
    stringBuffer.append(TEXT_976);
    
					if(criterias.size()>0){
						for(Map<String, String> line : criterias){
							String colname = line.get("COLNAME");
							
    stringBuffer.append(TEXT_977);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_978);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_979);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_980);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_981);
    
						}
					}
					
    stringBuffer.append(TEXT_982);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_983);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_984);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_985);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_986);
    stringBuffer.append(mapper.getOutKeyClass());
    stringBuffer.append(TEXT_987);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_988);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_989);
    
class AvroInput{
    private String inputFormatName;
    private String rowStructName;
    private List<IMetadataColumn> columns;
    private String folder;
    private boolean isSpark = false;

    /** Forces the creation of the input dir if it doesn't exist. */
    private boolean createInputDirIfNotExists = false;
    public AvroInput(String rowStructName, List<IMetadataColumn> columns, String folder){
        this.rowStructName = rowStructName;
        this.inputFormatName = rowStructName;
        this.columns = columns;
        this.folder = folder;
    }

    public AvroInput(String inputFormatName, String rowStructName, List<IMetadataColumn> columns, String folder){
        this.rowStructName = rowStructName;
        this.inputFormatName = inputFormatName;
        this.columns = columns;
        this.folder = folder;
    }


    public AvroInput(String inputFormatName, String rowStructName, List<IMetadataColumn> columns, String folder, boolean isSpark){
        this.rowStructName = rowStructName;
        this.inputFormatName = inputFormatName;
        this.columns = columns;
        this.folder = folder;
        this.isSpark = isSpark;
    }

    
    /**
     * In some cases, we do not want to fail the job if the input directory does
     * not exist, but to treat it as a valid (but empty) input.
     */
    public void setCreateInputDirIfNotExists(boolean createInputDirIfNotExists) {
        this.createInputDirIfNotExists = createInputDirIfNotExists;
    }

    public void extendMethods(){
    }

    public void gen(){
    
    stringBuffer.append(TEXT_990);
    stringBuffer.append(inputFormatName);
    stringBuffer.append(TEXT_991);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_992);
    
            // If a specific folder has been specified, it should normally be
            // set as the only input dir for this input format during
            // getSplits().  The setOverrideInputDir() can be used in a
            // generated job to change this behaviour (such as when the inputs
            // have been copied to the DistributedCache).
            
    stringBuffer.append(TEXT_993);
    extendMethods();
    stringBuffer.append(TEXT_994);
     if (folder != null) { 
    stringBuffer.append(TEXT_995);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_996);
     if (createInputDirIfNotExists) { 
    stringBuffer.append(TEXT_997);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_998);
     } 
    stringBuffer.append(TEXT_999);
     } 
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_1002);
    
                    java.util.Map<JavaType,String> talendTypeToAvroType = new java.util.HashMap<JavaType,String>();
                    talendTypeToAvroType.put(JavaTypesManager.STRING,"STRING");
                    talendTypeToAvroType.put(JavaTypesManager.CHARACTER,"INT");
                    talendTypeToAvroType.put(JavaTypesManager.BYTE_ARRAY,"BYTES");
                    talendTypeToAvroType.put(JavaTypesManager.INTEGER,"INT");
                    talendTypeToAvroType.put(JavaTypesManager.BYTE,"INT");
                    talendTypeToAvroType.put(JavaTypesManager.SHORT,"INT");
                    talendTypeToAvroType.put(JavaTypesManager.LONG,"LONG");
                    talendTypeToAvroType.put(JavaTypesManager.FLOAT,"FLOAT");
                    talendTypeToAvroType.put(JavaTypesManager.DOUBLE,"DOUBLE");
                    talendTypeToAvroType.put(JavaTypesManager.BOOLEAN,"BOOLEAN");
                    talendTypeToAvroType.put(JavaTypesManager.BIGDECIMAL,"STRING");
                    talendTypeToAvroType.put(JavaTypesManager.DATE,"LONG");

                    for(IMetadataColumn column : columns){
                        JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                        String columnName = column.getLabel();
                        boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());

                        if(isPrimitive) {
                        
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(talendTypeToAvroType.get(javaType));
    stringBuffer.append(TEXT_1005);
    
                        } else {
                        
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(talendTypeToAvroType.get(javaType));
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_1008);
    
                            }
                    }
                    
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_1010);
    
                    for(IMetadataColumn column : columns){
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                        String objectTypeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), true);
                        JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                        String columnName = column.getLabel();
                        String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
                        
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_1012);
    if(javaType == JavaTypesManager.STRING) {
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_1014);
    } else if(javaType == JavaTypesManager.BYTE) {
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_1016);
    } else if(javaType == JavaTypesManager.SHORT) {
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_1018);
    } else if(javaType == JavaTypesManager.CHARACTER) {
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_1020);
    } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
    if (isSpark) {
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_1022);
    } else {
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_1024);
    }
    } else if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_1026);
    } else if(javaType == JavaTypesManager.DATE) {
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_1028);
    } else {
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(objectTypeToGenerate);
    stringBuffer.append(TEXT_1031);
    }
    if(defaultValue!=null && defaultValue.length()>0){
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_1034);
    }
    stringBuffer.append(TEXT_1035);
    
                    }
                    
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(rowStructName);
    stringBuffer.append(TEXT_1038);
    
    }
}

    
AvroInput avroInput = new AvroInput(mapper.getOutKeyClass(), listCriteriasColsPrepa, null);
avroInput.gen();

    stringBuffer.append(TEXT_1039);
    stringBuffer.append(TEXT_1040);
    return stringBuffer.toString();
  }
}
