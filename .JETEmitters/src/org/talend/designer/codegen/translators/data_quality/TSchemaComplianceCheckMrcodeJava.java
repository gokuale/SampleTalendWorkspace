package org.talend.designer.codegen.translators.data_quality;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

public class TSchemaComplianceCheckMrcodeJava
{
  protected static String nl;
  public static synchronized TSchemaComplianceCheckMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSchemaComplianceCheckMrcodeJava result = new TSchemaComplianceCheckMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "\t";
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
  protected final String TEXT_120 = NL + "\ttry {" + NL + "\t\tif(";
  protected final String TEXT_121 = NL + "\t\t";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = " != null";
  protected final String TEXT_124 = NL + "\t\t&& (!\"\".equals(";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = "))";
  protected final String TEXT_127 = NL + "\t\t";
  protected final String TEXT_128 = ".";
  protected final String TEXT_129 = " != null";
  protected final String TEXT_130 = NL + "\t\ttrue";
  protected final String TEXT_131 = NL + "\t\t) {";
  protected final String TEXT_132 = NL + "\t\t\tif(!(\"true\".equals(";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = ") || \"false\".equals(";
  protected final String TEXT_135 = ".";
  protected final String TEXT_136 = "))){" + NL + "\t\t\t\tthrow new java.lang.Exception(\"Wrong Boolean type!\");" + NL + "\t\t\t}";
  protected final String TEXT_137 = NL + "\t\t\tif(";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = ".toCharArray().length != 1){" + NL + "\t\t\t\tthrow new java.lang.Exception(\"Wrong Character type!\");" + NL + "\t\t\t}";
  protected final String TEXT_140 = NL + "\t\t\t";
  protected final String TEXT_141 = " tester_";
  protected final String TEXT_142 = " = new ";
  protected final String TEXT_143 = "(";
  protected final String TEXT_144 = ".";
  protected final String TEXT_145 = ");";
  protected final String TEXT_146 = NL + "\t\t\t";
  protected final String TEXT_147 = " tester_";
  protected final String TEXT_148 = " = new ";
  protected final String TEXT_149 = "();";
  protected final String TEXT_150 = NL + "\t\t\t";
  protected final String TEXT_151 = " tester_";
  protected final String TEXT_152 = " = ";
  protected final String TEXT_153 = ".valueOf(";
  protected final String TEXT_154 = ".";
  protected final String TEXT_155 = ");";
  protected final String TEXT_156 = NL + "\t\t}" + NL + "\t} catch(java.lang.Exception e) {" + NL + "\t\tifPassedThrough = false;" + NL + "\t\terrorCodeThrough += 2;" + NL + "\t\terrorMessageThrough += \"|wrong type\";" + NL + "\t}";
  protected final String TEXT_157 = NL + "\tif (";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = " != null){";
  protected final String TEXT_160 = NL + "\t\thandleBigdecimalPrecision((";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = ").toPlainString(), ";
  protected final String TEXT_163 = ", ";
  protected final String TEXT_164 = ");";
  protected final String TEXT_165 = NL + "\t\thandleBigdecimalPrecision(String.valueOf(";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = "), ";
  protected final String TEXT_168 = ", ";
  protected final String TEXT_169 = ");";
  protected final String TEXT_170 = NL + "\t\tifPassedThrough = ifPassedThrough?ifPassed:false;" + NL + "\t\terrorCodeThrough += errorCode;" + NL + "\t\terrorMessageThrough += errorMessage;" + NL + "\t}";
  protected final String TEXT_171 = NL + "\tif (";
  protected final String TEXT_172 = NL + "\t";
  protected final String TEXT_173 = ".";
  protected final String TEXT_174 = " != null ";
  protected final String TEXT_175 = NL + "\t&& (!\"\".equals(";
  protected final String TEXT_176 = ".";
  protected final String TEXT_177 = "))\t\t\t\t\t";
  protected final String TEXT_178 = " " + NL + "\t";
  protected final String TEXT_179 = ".";
  protected final String TEXT_180 = " != null";
  protected final String TEXT_181 = " " + NL + "\ttrue";
  protected final String TEXT_182 = NL + "\t) {";
  protected final String TEXT_183 = NL + "\t\tif( ";
  protected final String TEXT_184 = ".";
  protected final String TEXT_185 = ".length() > ";
  protected final String TEXT_186 = " )" + NL + "\t\t\t";
  protected final String TEXT_187 = ".";
  protected final String TEXT_188 = " = ";
  protected final String TEXT_189 = ".";
  protected final String TEXT_190 = ".substring(0, ";
  protected final String TEXT_191 = ");";
  protected final String TEXT_192 = NL + "\t\ttmpContentThrough = String.valueOf(";
  protected final String TEXT_193 = ".";
  protected final String TEXT_194 = ");";
  protected final String TEXT_195 = NL + "\t\ttmpContentThrough = ";
  protected final String TEXT_196 = ".";
  protected final String TEXT_197 = ".toString();";
  protected final String TEXT_198 = NL + "\t\tif (tmpContentThrough.length() > ";
  protected final String TEXT_199 = ")" + NL + "\t\t\t";
  protected final String TEXT_200 = ".";
  protected final String TEXT_201 = " = ";
  protected final String TEXT_202 = ".";
  protected final String TEXT_203 = ".substring(0, ";
  protected final String TEXT_204 = ");";
  protected final String TEXT_205 = NL + "\t\tif (";
  protected final String TEXT_206 = ".";
  protected final String TEXT_207 = ".length() > ";
  protected final String TEXT_208 = ") {" + NL + "\t\t\tifPassedThrough = false;" + NL + "\t\t\terrorCodeThrough += 8;" + NL + "\t\t\terrorMessageThrough += \"|exceed max length\";" + NL + "\t\t}";
  protected final String TEXT_209 = NL + "\t\ttmpContentThrough = String.valueOf(";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = ");";
  protected final String TEXT_212 = NL + "\t\ttmpContentThrough = ";
  protected final String TEXT_213 = ".";
  protected final String TEXT_214 = ".toString();  ";
  protected final String TEXT_215 = NL + NL + "\t\tif (tmpContentThrough.length() > ";
  protected final String TEXT_216 = ") {" + NL + "\t\t\tifPassedThrough = false;" + NL + "\t\t\terrorCodeThrough += 8;" + NL + "\t\t\terrorMessageThrough += \"|exceed max length\";" + NL + "\t\t}";
  protected final String TEXT_217 = NL + "\t}";
  protected final String TEXT_218 = NL + "\tifPassedThrough = false;" + NL + "\terrorCodeThrough += 2;" + NL + "\terrorMessageThrough += \"|Date format not defined\";";
  protected final String TEXT_219 = NL + "\ttry{" + NL + "\t\tif (";
  protected final String TEXT_220 = NL + "\t\t";
  protected final String TEXT_221 = ".";
  protected final String TEXT_222 = " != null ";
  protected final String TEXT_223 = NL + "\t\t&& (!\"\".equals(";
  protected final String TEXT_224 = ".";
  protected final String TEXT_225 = "))";
  protected final String TEXT_226 = " " + NL + "\t\t";
  protected final String TEXT_227 = ".";
  protected final String TEXT_228 = " != null";
  protected final String TEXT_229 = " " + NL + "\t\ttrue";
  protected final String TEXT_230 = NL + "\t\t){";
  protected final String TEXT_231 = NL + "\t\t\tif (!TalendDate.isDate((";
  protected final String TEXT_232 = ".";
  protected final String TEXT_233 = ").toString(), ";
  protected final String TEXT_234 = ",";
  protected final String TEXT_235 = "true";
  protected final String TEXT_236 = "false";
  protected final String TEXT_237 = "))" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"Data format not matches\");";
  protected final String TEXT_238 = NL + "\t\t\tFastDateParser.getInstance(";
  protected final String TEXT_239 = ", false).parse(";
  protected final String TEXT_240 = ".";
  protected final String TEXT_241 = ");            ";
  protected final String TEXT_242 = NL + "\t\t}" + NL + "\t} catch(java.lang.Exception e){" + NL + "\t\tifPassedThrough = false;" + NL + "\t\terrorCodeThrough += 2;" + NL + "\t\terrorMessageThrough += \"|wrong DATE pattern or wrong DATE data\";" + NL + "\t}";
  protected final String TEXT_243 = NL + "\tifPassedThrough = false;" + NL + "\terrorCodeThrough += 2;" + NL + "\terrorMessageThrough += \"|wrong DATE pattern or wrong DATE data\";";
  protected final String TEXT_244 = NL + "\tifPassedThrough = false;" + NL + "\terrorCodeThrough += 2;" + NL + "\terrorMessageThrough += \"|The TYPE of inputting data is error. (one of OBJECT, STRING, DATE)\";";
  protected final String TEXT_245 = NL + "\t// validate nullable (empty as null)" + NL + "\tif ((";
  protected final String TEXT_246 = ".";
  protected final String TEXT_247 = " == null) || (\"\".equals(";
  protected final String TEXT_248 = ".";
  protected final String TEXT_249 = "))) {";
  protected final String TEXT_250 = NL + "\t// validate nullable" + NL + "\tif (";
  protected final String TEXT_251 = ".";
  protected final String TEXT_252 = " == null) {";
  protected final String TEXT_253 = NL + "\t// validate nullable (empty as null)" + NL + "\tif ((";
  protected final String TEXT_254 = ".";
  protected final String TEXT_255 = " == null) || (\"\".equals(";
  protected final String TEXT_256 = ".";
  protected final String TEXT_257 = "))) {";
  protected final String TEXT_258 = NL + "\t// validate nullable (empty as null)" + NL + "\tif ((";
  protected final String TEXT_259 = ".";
  protected final String TEXT_260 = " == null) || (\"\".equals(";
  protected final String TEXT_261 = ".";
  protected final String TEXT_262 = "))) {";
  protected final String TEXT_263 = NL + "\t// validate nullable" + NL + "\tif (";
  protected final String TEXT_264 = ".";
  protected final String TEXT_265 = " == null) {";
  protected final String TEXT_266 = NL + "\t\tifPassedThrough = false;" + NL + "\t\terrorCodeThrough += 4;" + NL + "\t\terrorMessageThrough += \"|empty or null\";" + NL + "\t}";
  protected final String TEXT_267 = NL + "\t";
  protected final String TEXT_268 = NL + "\t\t\tclass RowSetValueUtil_";
  protected final String TEXT_269 = " {" + NL + "" + NL + "\t\t\t\tboolean ifPassedThrough = true;" + NL + "\t\t\t\tint errorCodeThrough = 0;" + NL + "\t\t\t\tString errorMessageThrough = \"\";" + NL + "\t\t\t\tint resultErrorCodeThrough = 0;" + NL + "\t\t\t\tString resultErrorMessageThrough = \"\";" + NL + "\t\t\t\tString tmpContentThrough = null;" + NL + "\t\t" + NL + "\t\t\t\tboolean ifPassed = true;" + NL + "\t\t\t\tint errorCode = 0;" + NL + "\t\t\t\tString errorMessage = \"\";" + NL + "\t\t" + NL + "\t\t\t\tvoid handleBigdecimalPrecision(String data, int iPrecision, int maxLength){" + NL + "\t\t\t\t\t//number of digits before the decimal point(ignoring frontend zeroes)" + NL + "\t\t\t\t\tint len1 = 0;" + NL + "\t\t\t\t\tint len2 = 0;" + NL + "\t\t\t\t\tifPassed = true;" + NL + "\t\t\t\t\terrorCode = 0;" + NL + "\t\t\t\t\terrorMessage = \"\";" + NL + "\t\t\t\t\tif(data.startsWith(\"-\")){" + NL + "\t\t\t\t\t\tdata = data.substring(1);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tdata = org.apache.commons.lang.StringUtils.stripStart(data, \"0\");" + NL + "\t\t" + NL + "\t\t\t\t\tif(data.indexOf(\".\") >= 0){" + NL + "\t\t\t\t\t\tlen1 = data.indexOf(\".\");" + NL + "\t\t\t\t\t\tdata = org.apache.commons.lang.StringUtils.stripEnd(data, \"0\");" + NL + "\t\t\t\t\t\tlen2 = data.length() - (len1 + 1);" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tlen1 = data.length();" + NL + "\t\t\t\t\t}" + NL + "\t\t" + NL + "\t\t\t\t\tif (iPrecision < len2) {" + NL + "\t\t\t\t\t\tifPassed = false;" + NL + "\t\t\t\t\t\terrorCode += 8;" + NL + "\t\t\t\t\t\terrorMessage += \"|precision Non-matches\";" + NL + "\t\t\t\t\t} else if (maxLength < len1 + iPrecision) {" + NL + "\t\t\t\t\t\tifPassed = false;" + NL + "\t\t\t\t\t\terrorCode += 8;" + NL + "\t\t\t\t\t\terrorMessage += \"|invalid Length setting is unsuitable for Precision\";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t" + NL + "\t\t\t\tint handleErrorCode(int errorCode, int resultErrorCode){" + NL + "\t\t\t\t\tif (errorCode > 0) {" + NL + "\t\t\t\t\t\tif (resultErrorCode > 0) {" + NL + "\t\t\t\t\t\t\tresultErrorCode = 16;" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tresultErrorCode = errorCode;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn resultErrorCode;" + NL + "\t\t\t\t}" + NL + "\t\t" + NL + "\t\t\t\tString handleErrorMessage(String errorMessage, String resultErrorMessage, String columnLabel){" + NL + "\t\t\t\t\tif (errorMessage.length() > 0) {" + NL + "\t\t\t\t\t\tif (resultErrorMessage.length() > 0) {" + NL + "\t\t\t\t\t\t\tresultErrorMessage += \";\"+ errorMessage.replaceFirst(\"\\\\|\", columnLabel);" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tresultErrorMessage = errorMessage.replaceFirst(\"\\\\|\", columnLabel);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn resultErrorMessage;" + NL + "\t\t\t\t}" + NL + "\t\t" + NL + "\t\t\t\tvoid reset(){" + NL + "\t\t\t\t\tifPassedThrough = true;" + NL + "\t\t\t\t\terrorCodeThrough = 0;" + NL + "\t\t\t\t\terrorMessageThrough = \"\";" + NL + "\t\t\t\t\tresultErrorCodeThrough = 0;" + NL + "\t\t\t\t\tresultErrorMessageThrough = \"\";" + NL + "\t\t\t\t\ttmpContentThrough = null;" + NL + "\t\t" + NL + "\t\t\t\t\tifPassed = true;" + NL + "\t\t\t\t\terrorCode = 0;" + NL + "\t\t\t\t\terrorMessage = \"\";" + NL + "\t\t\t\t}" + NL + "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_270 = "\t" + NL + "\t\t\t\t\tvoid setRowValue_";
  protected final String TEXT_271 = "(";
  protected final String TEXT_272 = "Struct ";
  protected final String TEXT_273 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_274 = NL + "\t\t\t\t\t\tresultErrorCodeThrough = handleErrorCode(errorCodeThrough,resultErrorCodeThrough);" + NL + "\t\t\t\t\t\terrorCodeThrough = 0;" + NL + "\t\t\t\t\t\tresultErrorMessageThrough = handleErrorMessage(errorMessageThrough,resultErrorMessageThrough,\"";
  protected final String TEXT_275 = ":\");" + NL + "\t\t\t\t\t\terrorMessageThrough = \"\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_276 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_277 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_278 = NL + "\t\t\t}" + NL + "\t\t\tRowSetValueUtil_";
  protected final String TEXT_279 = " rsvUtil_";
  protected final String TEXT_280 = " = null;" + NL + "\t\t";
  protected final String TEXT_281 = NL + "\t\t\trsvUtil_";
  protected final String TEXT_282 = " = new RowSetValueUtil_";
  protected final String TEXT_283 = "();" + NL + "\t\t";
  protected final String TEXT_284 = NL + "\t\t\t\t\trsvUtil_";
  protected final String TEXT_285 = ".setRowValue_";
  protected final String TEXT_286 = "(value_";
  protected final String TEXT_287 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_288 = NL + "\t\t\t\tif(rsvUtil_";
  protected final String TEXT_289 = ".ifPassedThrough){" + NL + "\t\t\t    \t";
  protected final String TEXT_290 = NL + "\t\t\t    \t\t";
  protected final String TEXT_291 = ".";
  protected final String TEXT_292 = " = value_";
  protected final String TEXT_293 = ".";
  protected final String TEXT_294 = ";" + NL + "\t\t\t    \t";
  protected final String TEXT_295 = NL + "\t\t\t    }" + NL + "\t\t\t";
  protected final String TEXT_296 = NL + "\t\t    \tif(!rsvUtil_";
  protected final String TEXT_297 = ".ifPassedThrough){" + NL + "\t\t\t      \t";
  protected final String TEXT_298 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_299 = ".";
  protected final String TEXT_300 = " = value_";
  protected final String TEXT_301 = ".";
  protected final String TEXT_302 = ";\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_303 = NL + "\t\t\t    \t";
  protected final String TEXT_304 = ".errorCode = String.valueOf(rsvUtil_";
  protected final String TEXT_305 = ".resultErrorCodeThrough);" + NL + "\t\t\t\t\t";
  protected final String TEXT_306 = ".errorMessage = rsvUtil_";
  protected final String TEXT_307 = ".resultErrorMessageThrough;" + NL + "\t\t\t    \t";
  protected final String TEXT_308 = NL + "\t\t    \t}" + NL + "\t\t\t";
  protected final String TEXT_309 = NL + "\t\t\trsvUtil_";
  protected final String TEXT_310 = ".reset();" + NL + "\t\t";
  protected final String TEXT_311 = NL + "\t" + NL + "\t ";
  protected final String TEXT_312 = NL;

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
    
	BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
	final INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	List<IMetadataColumn> listInColumnsTemp = null;
	String inConnNameTemp = null;
	if(node.getIncomingConnections() != null){
		for(IConnection incomingConn : node.getIncomingConnections()){
			if(incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
				inConnNameTemp = incomingConn.getName();
				listInColumnsTemp = incomingConn.getMetadataTable().getListColumns();
			}
		}
	}
	final List<IMetadataColumn> listInColumns = listInColumnsTemp;
	final String inConnName = inConnNameTemp;
	
	String outFilterConnNameTemp = null;
	IMetadataTable outFilterMetadataTableTemp = null;
	String outRejectConnNameTemp = null;
	IMetadataTable outRejectMetadataTableTemp = null;
	List<? extends IConnection> outFilterConns = node.getOutgoingConnections();
    if(outFilterConns != null && outFilterConns.size() > 0){
    	for(IConnection outFilterConn : outFilterConns){
	    	if(outFilterConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA) && !"REJECT".equals(outFilterConn.getConnectorName())){
		    	outFilterConnNameTemp = outFilterConn.getName();
		    	outFilterMetadataTableTemp = outFilterConn.getMetadataTable();
	    	}
    	}
    }
    List<? extends IConnection> outRejectConns = node.getOutgoingConnections("REJECT");
    if(outRejectConns != null && outRejectConns.size() > 0){
    	IConnection outRejectConn = outRejectConns.get(0);
    	outRejectConnNameTemp = outRejectConn.getName();
    	outRejectMetadataTableTemp = outRejectConn.getMetadataTable();
    }
    final IMetadataTable outFilterMetadataTable = outFilterMetadataTableTemp;
    final IMetadataTable outRejectMetadataTable = outRejectMetadataTableTemp;
    final String outFilterConnName = outFilterConnNameTemp;
	final String outRejectConnName = outRejectConnNameTemp;
	final Map<String, String> outConnNames = new HashMap<String, String>();
	if(outFilterConnName!=null)
		outConnNames.put("filter", outFilterConnName);
	if(outRejectConnName!=null)
		outConnNames.put("reject", outRejectConnName);
	boolean hasMultipleOutputs = outConnNames.size() > 1;
	final String outConnName = outFilterConnName != null ? outFilterConnName : outRejectConnName;
	
	if(inConnName == null || listInColumns == null || (outFilterMetadataTable == null && outRejectMetadataTable == null)){
  		return "";
  	}
	
	final boolean anotherChecked = "true".equals(ElementParameterParser.getValue(node, "__CHECK_ANOTHER__"));
	String checkAll = ElementParameterParser.getValue(node, "__CHECK_ALL__");
	final boolean bIsTrim = "true".equals(ElementParameterParser.getValue(node, "__SUB_STRING__"));
	final boolean useFasteDateChecker = "true".equals(ElementParameterParser.getValue(node, "__FAST_DATE_CHECK__"));
	final boolean emptyIsNull = "true".equals(ElementParameterParser.getValue(node, "__EMPTY_IS_NULL__"));
	final boolean allEmptyAreNull = "true".equals(ElementParameterParser.getValue(node, "__ALL_EMPTY_ARE_NULL__"));
	
	List<Map<String, String>> list = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__EMPTY_NULL_TABLE__");
	final List<String> listEmptyAsNull = new ArrayList<String>();
	for(Map<String, String> map : list){
		if("true".equals(map.get("EMPTY_NULL"))){
			listEmptyAsNull.add(map.get("SCHEMA_COLUMN"));
		}
	}

	class SchemaChecker { //CLASS SCHEMACHECKER START
		boolean ignoreTimeZone = "true".equals(ElementParameterParser.getValue(node, "__IGNORE_TIMEZONE__"));

		public void  testDataType(boolean _bNullable, String _sInConnName, IMetadataColumn metadataColumn, String typeSelected, String cid) { //METHOD_TESTDATATYPE START
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
			boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, metadataColumn.isNullable());
			String colName = metadataColumn.getLabel();

			if (javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.STRING) { //CONDITION_00100 START

    stringBuffer.append(TEXT_120);
    
				if (_bNullable){ //CONDITION_00110 START

    stringBuffer.append(TEXT_121);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_123);
    
					if(allEmptyAreNull || listEmptyAsNull.contains(metadataColumn.getLabel())) {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_126);
    
					}
				}else if(!isPrimitive){ //CONDITION_00110 ELSE IF

    stringBuffer.append(TEXT_127);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_129);
    
				}else{ //CONDITION_00110 ELSE

    stringBuffer.append(TEXT_130);
    
				} //CONDITION_00110 STOP

    stringBuffer.append(TEXT_131);
    
				if(typeSelected.equals("Boolean") ) { //CONDITION_00120 START

    stringBuffer.append(TEXT_132);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_136);
    
				} else if(typeSelected.equals("Character")) { //CONDITION_00120 ELSE IF

    stringBuffer.append(TEXT_137);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_139);
    
				} else if(typeSelected.equals("BigDecimal")) { //CONDITION_00120 ELSE IF

    stringBuffer.append(TEXT_140);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_145);
    
				} else if(typeSelected.equals("Object")){ //CONDITION_00120 ELSE IF

    stringBuffer.append(TEXT_146);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_149);
    
				} else { //CONDITION_00120 ELSE

    stringBuffer.append(TEXT_150);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_155);
    
				} //CONDITION_00120 STOP

    stringBuffer.append(TEXT_156);
    
			} //CONDITION_00100 STOP
		} //METHOD_TESTDATATYPE STOP

		public void testPrecision(int _maxLength, int iPrecision, String _sInConnName, IMetadataColumn metadataColumn, String typeSelected, String cid) { //METHOD_TESTPRECISION START
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
			String colName = metadataColumn.getLabel();
			boolean needCheck = false;
			if(anotherChecked) {
				if("BigDecimal".equalsIgnoreCase(typeSelected)) {
					needCheck = true;
				}
			} else if (javaType == JavaTypesManager.BIGDECIMAL) {
				/* NULLable, in case input value is Null, do nothing... 
				Non-NULLable, 
					(1) in case input value is Non-null, go into...; 
					(2) in case input value is Null, do nothing and warning by NULL-CHECKER.
				*/
				/*
					if precision value is not empty or Null, checking "Precision" at first, if passed then checking "Length"
				*/
				needCheck = true;
			}
			if(needCheck) { //CONDITION_00130 START

    stringBuffer.append(TEXT_157);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_159);
    
				if(javaType == JavaTypesManager.BIGDECIMAL) { //CONDITION_00131 START

    stringBuffer.append(TEXT_160);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(iPrecision);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(_maxLength);
    stringBuffer.append(TEXT_164);
    
				} else {  //CONDITION_00131 ELSE

    stringBuffer.append(TEXT_165);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(iPrecision);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(_maxLength);
    stringBuffer.append(TEXT_169);
    
				}  //CONDITION_00131 STOP

    stringBuffer.append(TEXT_170);
    
			} //CONDITION_00130 STOP
		} //METHOD_TESTPRECISION STOP

		public void testDataLength(boolean _bNullable, String _sInConnName,IMetadataColumn inColumn,IMetadataColumn metadataColumn, int maxLength, String cid) { //METHOD_TESTDATALENGTH START
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
			boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, metadataColumn.isNullable());
			boolean bIsStringType = (javaType == JavaTypesManager.STRING), bIsIntegerType = (javaType == JavaTypesManager.INTEGER);
			String colName = inColumn.getLabel();

			if (maxLength > 0 && ( bIsStringType || bIsIntegerType )){ //CONDITION_00140 START

    stringBuffer.append(TEXT_171);
    
				if (_bNullable){ //CONDITION_00141 START

    stringBuffer.append(TEXT_172);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_174);
    
					if(allEmptyAreNull || listEmptyAsNull.contains(metadataColumn.getLabel())) {

    stringBuffer.append(TEXT_175);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_177);
    
					}
				}else if (!isPrimitive){ //CONDITION_00141 ELSE IF

    stringBuffer.append(TEXT_178);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_180);
    
				}else { //CONDITION_00141 ELSE

    stringBuffer.append(TEXT_181);
    
				} //CONDITION_00141 STOP

    stringBuffer.append(TEXT_182);
    
				if ( bIsTrim ){ //CONDITION_00142 START
					if (bIsStringType) { //CONDITION_001421 START

    stringBuffer.append(TEXT_183);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_191);
    
					} else if ( bIsIntegerType ){//CONDITION_001421 ELSE IF
						String generatedType = JavaTypesManager.getTypeToGenerate(metadataColumn.getTalendType(), metadataColumn.isNullable());
						if ("int".equals(generatedType)) { //CONDITION_0014211 START

    stringBuffer.append(TEXT_192);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_194);
    
						} else{ //CONDITION_0014211 ELSE

    stringBuffer.append(TEXT_195);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_197);
    
						} //CONDITION_0014211 STOP

    stringBuffer.append(TEXT_198);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_204);
    
					} //CONDITION_001421 STOP
				} else{ //CONDITION_00142 ELSE
					if (bIsStringType) { //CONDITION_001422 START

    stringBuffer.append(TEXT_205);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_208);
    
					} else if (bIsIntegerType) { //CONDITION_001422 ELSE IF
						String generatedType = JavaTypesManager.getTypeToGenerate(metadataColumn.getTalendType(), metadataColumn.isNullable());
						if ("int".equals(generatedType)) { //CONDITION_0014221 START

    stringBuffer.append(TEXT_209);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_211);
    
						} else { //CONDITION_0014221 ELSE

    stringBuffer.append(TEXT_212);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_214);
    
						} //CONDITION_0014221 STOP

    stringBuffer.append(TEXT_215);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_216);
    
					}//CONDITION_001422 STOP
				} //CONDITION_00142 STOP

    stringBuffer.append(TEXT_217);
     
			} //CONDITION_00140 STOP
		} //METHOD_TESTDATALENGTH STOP

		public void testDate(boolean _bNullable, String _sInConnName, IMetadataColumn metadataColumn, String pattern, String cid) { //METHOD_TESTDATE START
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
			boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, metadataColumn.isNullable());
			String colName = metadataColumn.getLabel();

			if ("".equals(pattern)){ //CONDITION_00150 START

    stringBuffer.append(TEXT_218);
    
			} else { //CONDITION_00150 ELSE
				if (javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.STRING) { //CONDITION_00151 START

    stringBuffer.append(TEXT_219);
    
					if (_bNullable){ //CONDITION_001511 START

    stringBuffer.append(TEXT_220);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_222);
    
						if(allEmptyAreNull || listEmptyAsNull.contains(metadataColumn.getLabel())) {

    stringBuffer.append(TEXT_223);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_225);
    
						}
					}else if (!isPrimitive){ //CONDITION_001511 ELSE IF

    stringBuffer.append(TEXT_226);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_228);
    
					}else { //CONDITION_001511 ELSE

    stringBuffer.append(TEXT_229);
    
					} //CONDITION_001511 STOP

    stringBuffer.append(TEXT_230);
    
					if (!useFasteDateChecker) { //CONDITION_001512 START

    stringBuffer.append(TEXT_231);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_234);
    if(ignoreTimeZone){
    stringBuffer.append(TEXT_235);
    }else{
    stringBuffer.append(TEXT_236);
    }
    stringBuffer.append(TEXT_237);
    
					} else { //CONDITION_001512 ELSE

    stringBuffer.append(TEXT_238);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_241);
    
					} //CONDITION_001512 STOP

    stringBuffer.append(TEXT_242);
    
				// date type need check also (some inputting data not legal, beacause original data is not suite with pattern and has be converted)
				} else if (javaType == JavaTypesManager.DATE){ //CONDITION_00151 ELSE IF
					if (!metadataColumn.getPattern().equals(pattern)){ //CONDITION_001513 START

    stringBuffer.append(TEXT_243);
    
					} //CONDITION_001513 STOP
				} else{ //CONDITION_00151 ELSE

    stringBuffer.append(TEXT_244);
    
				} //CONDITION_00151 STOP
			} //CONDITION_00150 STOP
		} //METHOD_TESTDATE STOP

		public void testNull(String _sInConnName, IMetadataColumn metadataColumn, String cid){ //METHOD_TESTNULL START
			boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(metadataColumn.getTalendType(), metadataColumn.isNullable());
			if (!isPrimitive){ //CONDITION_00160 START
				if(emptyIsNull && !allEmptyAreNull){ //CONDITION_001601 START - for the migration task
					if(listEmptyAsNull.contains(metadataColumn.getLabel())){ //CONDITION_0016011 START

    stringBuffer.append(TEXT_245);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_247);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_249);
    
					}else{ //CONDITION_0016011 ELSE

    stringBuffer.append(TEXT_250);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_252);
    
					} //CONDITION_0016011 STOP
				}else{ //CONDITION_001601 ELSE
					if(allEmptyAreNull){ //CONDITION_0016012 START

    stringBuffer.append(TEXT_253);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_255);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_257);
    
					}else if(listEmptyAsNull.contains(metadataColumn.getLabel())){ //CONDITION_0016012 ELSE IF

    stringBuffer.append(TEXT_258);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_260);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_262);
    
					}else{ //CONDITION_0016012 ELSE

    stringBuffer.append(TEXT_263);
    stringBuffer.append(_sInConnName);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_265);
    
					} //CONDITION_0016012 STOP
				} //CONDITION_001601 STOP

    stringBuffer.append(TEXT_266);
    
			} //CONDITION_00160 STOP
		} //METHOD_TESTNULL STOP
	} //CLASS SCHEMACHECKER STOP

	final List<Map<String, String>> listCheckedColumns = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__CHECKCOLS__");
	boolean bNeedReferSchemaTemp = false;

	/* get the schema of itself (maybe no output flow)*/
	List<IMetadataColumn> listColumsToTestTemp = node.getMetadataList().get(0).getListColumns();
	
	if (anotherChecked){
		if (node.getMetadataFromConnector("OTHER") != null)
			listColumsToTestTemp = node.getMetadataFromConnector("OTHER").getListColumns();
	} else if ("true".equals(checkAll)){
		;
	} else{
		bNeedReferSchemaTemp = true;
	}

	final List<IMetadataColumn> listColumsToTest = listColumsToTestTemp;
	final boolean bNeedReferSchema = bNeedReferSchemaTemp;

    stringBuffer.append(TEXT_267);
    
	class Mapper extends MapperHelper{
		SchemaChecker checker = new SchemaChecker();    
	
		public void prepare(){
		
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    
				for (IMetadataColumn inColumn : listInColumns) { //LOOP_00100 START
					int iInColIndex = listInColumns.indexOf(inColumn);
					if(iInColIndex % 100 == 0){ //CONDITION_00170 START
					
    stringBuffer.append(TEXT_270);
    stringBuffer.append((iInColIndex/100) );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_273);
    
					} //CONDITION_00170 STOP
					// when using another schema, it's size may less than listInColumns
					if (iInColIndex >= listColumsToTest.size()){
						break;
					}
			
					Object pre_iPrecision = null;
					String sInColumnName = inColumn.getLabel(), sTestColName = null, sTestColType = null, sTestColPattern = null;
					boolean bNullable = true, bMaxLenLimited = true;
					/* use setting of tSchemaComplianceCheck schema (it is synchronize with inputting schema, but length value can be different) */
					Object pre_maxLength = listColumsToTest.get(iInColIndex).getLength();
					int maxLength = (pre_maxLength == null) ? 0 : Integer.parseInt(pre_maxLength.toString());
					IMetadataColumn schemaColumn = null;
			
					if (bNeedReferSchema) {
						Map<String, String> checkedColumn = listCheckedColumns.get(iInColIndex);
						sTestColName = checkedColumn.get("SCHEMA_COLUMN");
						sTestColType = checkedColumn.get("SELECTED_TYPE");
						sTestColPattern = checkedColumn.get("DATEPATTERN");
						bNullable = "true".equals(checkedColumn.get("NULLABLE"));
						bMaxLenLimited = "true".equals(checkedColumn.get("MAX_LENGTH"));
					} else{
						schemaColumn = listColumsToTest.get(iInColIndex);
						sTestColName = schemaColumn.getLabel();
						sTestColType = JavaTypesManager.getTypeToGenerate(schemaColumn.getTalendType(), true);
						sTestColPattern = schemaColumn.getPattern();
						bNullable = schemaColumn.isNullable();
						pre_iPrecision = schemaColumn.getPrecision();
					}
			
					// NULL checking
					if (!bNullable){
						checker.testNull(inConnName, inColumn, cid);
					}
			
					// type checking
					if (sTestColType != null){
						if (sTestColType.indexOf("Date") >= 0){
							checker.testDate(bNullable, inConnName, inColumn, sTestColPattern, cid); 
						} else{
							checker.testDataType(bNullable, inConnName, inColumn, sTestColType, cid);
						}
					}
			
					// length checking
					if (bMaxLenLimited){
						checker.testDataLength(bNullable, inConnName,inColumn, anotherChecked?schemaColumn:inColumn, maxLength, cid);
					}
			
					// precision checking
					if (pre_iPrecision != null){
						checker.testPrecision(maxLength, Integer.parseInt(pre_iPrecision.toString()), inConnName, inColumn, sTestColType, cid);
					}
					
    stringBuffer.append(TEXT_274);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_275);
    
					if((iInColIndex + 1) % 100 == 0){ //CONDITION_00171 START
					
    stringBuffer.append(TEXT_276);
    
					} //CONDITION_00171 STOP
				} //LOOP_00100 STOP
				if(listInColumns.size() > 0 && listInColumns.size() % 100 > 0){ //CONDITION_00180 START
				
    stringBuffer.append(TEXT_277);
    
				} //CONDITION_00180 STOP
				
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    
		}//prepare method end
		public void configure(){
		
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    
		}//configure method end
		public void map(){
			int inputColumnSize = listInColumns.size();
			for (int i = 0; i < inputColumnSize; i++ ) { //LOOP_00101 START
				if(i % 100 == 0){ //CONDITION_001002 START
				
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append((i/100));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    
				} //CONDITION_001002 STOP
			} //LOOP_00101 STOP
			
			if(outFilterMetadataTable != null){ //CONDITION_001003 START
			
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    
			    	for(IMetadataColumn inColumn : listInColumns){ //LOOP_001021 START
			    	
    stringBuffer.append(TEXT_290);
    stringBuffer.append(getOutValue("filter"));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_294);
    
			    	}
			    	output(null, getOutValue("filter"));
			    	
    stringBuffer.append(TEXT_295);
    
			} //CONDITION_001003 STOP
			
			if(outRejectMetadataTable != null){ //CONDITION_001004 START
			
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    
			    	for(IMetadataColumn inColumn : listInColumns){ //LOOP_00103 START
		    		
    stringBuffer.append(TEXT_298);
    stringBuffer.append(getOutValue("reject"));
    stringBuffer.append(TEXT_299);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_302);
    
			    	}
			    	
    stringBuffer.append(TEXT_303);
    stringBuffer.append(getOutValue("reject"));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(getOutValue("reject"));
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    
			    	output(null, getOutValue("reject"));
			    	
    stringBuffer.append(TEXT_308);
    
			}//CONDITION_001004 STOP
			
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    
		}//map method end
	}//mapper class end
	
	Mapper mapper = new Mapper();
	if(hasMultipleOutputs){
		mapper.setType(M_TYPE_MO);
		mapper.init(node, cid, null, inConnName, null, outConnNames);
	}else{
		mapper.init(node, cid, null, inConnName, null, outConnName);
	}
	mapper.generate();
	
    stringBuffer.append(TEXT_311);
    stringBuffer.append(TEXT_312);
    return stringBuffer.toString();
  }
}
