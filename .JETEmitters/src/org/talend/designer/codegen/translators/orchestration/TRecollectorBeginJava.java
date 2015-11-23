package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class TRecollectorBeginJava
{
  protected static String nl;
  public static synchronized TRecollectorBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRecollectorBeginJava result = new TRecollectorBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    //hey, listen: ";
  protected final String TEXT_2 = NL + "    ";
  protected final String TEXT_3 = NL + "    ";
  protected final String TEXT_4 = NL + "    \tlog.info(\"";
  protected final String TEXT_5 = " - Satrt to wrok.\");" + NL + "\t    StringBuffer log4jSb_";
  protected final String TEXT_6 = " = new StringBuffer();";
  protected final String TEXT_7 = NL + NL + "if (globalMap.get(\"RUN_ONCE_";
  protected final String TEXT_8 = "\") == null) {//determine whether we should run." + NL + "" + NL + "globalMap.put(\"RUN_ONCE_";
  protected final String TEXT_9 = "\",Boolean.TRUE);" + NL + "" + NL + "    java.util.List<org.talend.concurrent.MapAndQueue<";
  protected final String TEXT_10 = "Struct>/*_";
  protected final String TEXT_11 = "*/> queues_";
  protected final String TEXT_12 = " = " + NL + "          new java.util.ArrayList<org.talend.concurrent.MapAndQueue<";
  protected final String TEXT_13 = "Struct>/*_";
  protected final String TEXT_14 = "*/>(";
  protected final String TEXT_15 = ");" + NL + "try {          " + NL + "    for (int i_";
  protected final String TEXT_16 = " = 0; i_";
  protected final String TEXT_17 = " < ";
  protected final String TEXT_18 = "; i_";
  protected final String TEXT_19 = "++) { " + NL + "    //preinit queues to prevent IndexOutOfBoundsException if they don't come online in order." + NL + "\tqueues_";
  protected final String TEXT_20 = ".add(i_";
  protected final String TEXT_21 = ",new org.talend.concurrent.MapAndQueue<";
  protected final String TEXT_22 = "Struct>(\"";
  protected final String TEXT_23 = "\", \"";
  protected final String TEXT_24 = "\"));" + NL + "    }" + NL + "    java.util.List<org.talend.concurrent.ParallelTask> tasks_";
  protected final String TEXT_25 = " = (java.util.List<org.talend.concurrent.ParallelTask>)globalMap.get(\"TASKS_";
  protected final String TEXT_26 = "\");" + NL + "    for (int i_";
  protected final String TEXT_27 = " = 0; i_";
  protected final String TEXT_28 = " < ";
  protected final String TEXT_29 = "; i_";
  protected final String TEXT_30 = "++) {" + NL + "    org.talend.concurrent.ParallelTask task_";
  protected final String TEXT_31 = " = tasks_";
  protected final String TEXT_32 = ".get(i_";
  protected final String TEXT_33 = ");" + NL + "    " + NL + "" + NL + " \tqueues_";
  protected final String TEXT_34 = ".get(i_";
  protected final String TEXT_35 = ").setMap(task_";
  protected final String TEXT_36 = ".getMap());" + NL + " \t}" + NL + " \t//wait for queues to come online and start to get populated." + NL + "    boolean[] added_";
  protected final String TEXT_37 = " = new boolean[";
  protected final String TEXT_38 = "];" + NL + "    int populatedQueues_";
  protected final String TEXT_39 = " = 0;" + NL + "    while (populatedQueues_";
  protected final String TEXT_40 = " < ";
  protected final String TEXT_41 = ") { \t//initialize maps/queues.\t" + NL + "    for (int i_";
  protected final String TEXT_42 = " = 0; i_";
  protected final String TEXT_43 = " < ";
  protected final String TEXT_44 = "; i_";
  protected final String TEXT_45 = "++) {" + NL + "        if (!added_";
  protected final String TEXT_46 = "[i_";
  protected final String TEXT_47 = "]) {" + NL + " \t    \tjava.util.concurrent.BlockingQueue<java.util.concurrent.BlockingQueue<";
  protected final String TEXT_48 = "Struct>> tmp_";
  protected final String TEXT_49 = " = " + NL + " \t    \t\t(java.util.concurrent.BlockingQueue<java.util.concurrent.BlockingQueue<";
  protected final String TEXT_50 = "Struct>>)queues_";
  protected final String TEXT_51 = ".get(i_";
  protected final String TEXT_52 = ").getMap().get(\"OUTQUEUE_";
  protected final String TEXT_53 = "\");" + NL + " \t    \t";
  protected final String TEXT_54 = "\t" + NL + " \t\t\tif (tmp_";
  protected final String TEXT_55 = " != null) {" + NL + " \t\t\t\tqueues_";
  protected final String TEXT_56 = ".get(i_";
  protected final String TEXT_57 = ").setQueues(tmp_";
  protected final String TEXT_58 = ");" + NL + " \t\t    \tadded_";
  protected final String TEXT_59 = "[i_";
  protected final String TEXT_60 = "] = true; \t\t " + NL + " \t\t    \tpopulatedQueues_";
  protected final String TEXT_61 = "++;   \t" + NL + " \t\t\t}" + NL + " \t\t\t";
  protected final String TEXT_62 = NL + " \t\t\tadded_";
  protected final String TEXT_63 = "[i_";
  protected final String TEXT_64 = "] = true;" + NL + " \t\t\tpopulatedQueues_";
  protected final String TEXT_65 = "++;" + NL + " \t\t\t";
  protected final String TEXT_66 = NL + " \t\t}" + NL + "       }//end for" + NL + "       }//end while";
  protected final String TEXT_67 = NL + "if(true){" + NL + "\tthrow new Exception(\"Bad sort criteria: couldn't sort column \\\"";
  protected final String TEXT_68 = "\\\" as num.\");" + NL + "}";
  protected final String TEXT_69 = NL + "if(true){" + NL + "\tthrow new Exception(\"Bad sort criteria: couldn't sort column \\\"";
  protected final String TEXT_70 = "\\\" as date.\");" + NL + "}";
  protected final String TEXT_71 = "  " + NL + "class Comparable";
  protected final String TEXT_72 = "Struct extends ";
  protected final String TEXT_73 = "Struct implements Comparator<";
  protected final String TEXT_74 = "Struct> {" + NL + "\tpublic int compare(";
  protected final String TEXT_75 = "Struct o1, ";
  protected final String TEXT_76 = "Struct o2) {" + NL + "\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\tif (o1 == null && o2 != null ){" + NL + "\t\t";
  protected final String TEXT_78 = NL + "\t\t\treturn -1;" + NL + "\t\t";
  protected final String TEXT_79 = NL + "\t\t\treturn 1;" + NL + "\t\t";
  protected final String TEXT_80 = NL + "\t\t}" + NL + "\t\tif (o1 != null && o2 == null) {" + NL + "\t\t";
  protected final String TEXT_81 = NL + "\t\t\treturn 1;" + NL + "\t\t";
  protected final String TEXT_82 = NL + "\t\t\treturn -1;" + NL + "\t\t";
  protected final String TEXT_83 = NL + "\t\t}" + NL + "\t\tif (o1 == null && o2 == null) {" + NL + "\t\t\treturn 0;" + NL + "\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_84 = NL + "\t\tif(o1.";
  protected final String TEXT_85 = " == null && o2.";
  protected final String TEXT_86 = " != null){";
  protected final String TEXT_87 = NL + "\t\t\treturn -1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\treturn 1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_89 = NL + "\t\t}else if(o1.";
  protected final String TEXT_90 = " != null && o2.";
  protected final String TEXT_91 = " == null){";
  protected final String TEXT_92 = NL + "\t\t\treturn 1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\treturn -1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t}else if(o1.";
  protected final String TEXT_95 = " != null && o2.";
  protected final String TEXT_96 = " != null){" + NL + "\t\t\tif(!o1.";
  protected final String TEXT_97 = ".equals(o2.";
  protected final String TEXT_98 = ")){";
  protected final String TEXT_99 = NL + "\t\t\t\treturn o1.";
  protected final String TEXT_100 = ".compareTo(o2.";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "\t\t\t\treturn o2.";
  protected final String TEXT_103 = ".compareTo(o1.";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_106 = NL + "\t\tif(o1.";
  protected final String TEXT_107 = " != o2.";
  protected final String TEXT_108 = "){";
  protected final String TEXT_109 = NL + "\t\t\t\treturn o1.";
  protected final String TEXT_110 = " ? 1 : -1;";
  protected final String TEXT_111 = NL + "\t\t\t\treturn o1.";
  protected final String TEXT_112 = " ? -1 : 1;";
  protected final String TEXT_113 = NL + "\t\t}";
  protected final String TEXT_114 = NL + "\t\tif(o1.";
  protected final String TEXT_115 = " != o2.";
  protected final String TEXT_116 = "){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\treturn o1.";
  protected final String TEXT_118 = " > o2.";
  protected final String TEXT_119 = " ? 1 : -1;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\treturn o2.";
  protected final String TEXT_121 = " > o1.";
  protected final String TEXT_122 = " ? 1 : -1;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_123 = NL + "\t\t}";
  protected final String TEXT_124 = NL + "\t\tString o1S";
  protected final String TEXT_125 = " = o1.";
  protected final String TEXT_126 = " == null ? \"null\" : new String(o1.";
  protected final String TEXT_127 = ");" + NL + "\t\tString o2S";
  protected final String TEXT_128 = " = o2.";
  protected final String TEXT_129 = " == null ? \"null\" : new String(o2.";
  protected final String TEXT_130 = ");" + NL + "\t\tif(!o1S";
  protected final String TEXT_131 = ".equals(o2S";
  protected final String TEXT_132 = ")){";
  protected final String TEXT_133 = NL + "\t\t\treturn o1S";
  protected final String TEXT_134 = ".compareTo(o2S";
  protected final String TEXT_135 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_136 = NL + "\t\t\treturn o2S";
  protected final String TEXT_137 = ".compareTo(o1S";
  protected final String TEXT_138 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_139 = NL + "\t\t}";
  protected final String TEXT_140 = NL + "\t\t\tString o1S";
  protected final String TEXT_141 = " = o1.";
  protected final String TEXT_142 = " == null ? \"null\" : FormatterUtils.format_Date(o1.";
  protected final String TEXT_143 = ", ";
  protected final String TEXT_144 = ");" + NL + "\t\t\tString o2S";
  protected final String TEXT_145 = " = o2.";
  protected final String TEXT_146 = " == null ? \"null\" : FormatterUtils.format_Date(o2.";
  protected final String TEXT_147 = ", ";
  protected final String TEXT_148 = ");" + NL + "\t\t\tif(!o1S";
  protected final String TEXT_149 = ".equals(o2S";
  protected final String TEXT_150 = ")){";
  protected final String TEXT_151 = NL + "\t\t\t\treturn o1S";
  protected final String TEXT_152 = ".compareTo(o2S";
  protected final String TEXT_153 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_154 = NL + "\t\t\t\treturn o2S";
  protected final String TEXT_155 = ".compareTo(o1S";
  protected final String TEXT_156 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_157 = NL + "\t\t\t}";
  protected final String TEXT_158 = NL + "\t\tif(o1.";
  protected final String TEXT_159 = " == null && o2.";
  protected final String TEXT_160 = " != null){";
  protected final String TEXT_161 = NL + "\t\t\treturn -1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_162 = NL + "\t\t\treturn 1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_163 = NL + "\t\t}else if(o1.";
  protected final String TEXT_164 = " != null && o2.";
  protected final String TEXT_165 = " == null){";
  protected final String TEXT_166 = NL + "\t\t\treturn 1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_167 = NL + "\t\t\treturn -1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_168 = NL + "\t\t}else if(o1.";
  protected final String TEXT_169 = " != null && o2.";
  protected final String TEXT_170 = " != null){" + NL + "\t\t\tif(!o1.";
  protected final String TEXT_171 = ".equals(o2.";
  protected final String TEXT_172 = ")){";
  protected final String TEXT_173 = NL + "\t\t\t\treturn o1.";
  protected final String TEXT_174 = ".compareTo(o2.";
  protected final String TEXT_175 = ");";
  protected final String TEXT_176 = NL + "\t\t\t\treturn o2.";
  protected final String TEXT_177 = ".compareTo(o1.";
  protected final String TEXT_178 = ");";
  protected final String TEXT_179 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_180 = NL + "\t\tString o1S";
  protected final String TEXT_181 = " = o1.";
  protected final String TEXT_182 = " == null ? \"null\" : String.valueOf(o1.";
  protected final String TEXT_183 = ");" + NL + "\t\tString o2S";
  protected final String TEXT_184 = " = o2.";
  protected final String TEXT_185 = " == null ? \"null\" : String.valueOf(o2.";
  protected final String TEXT_186 = ");" + NL + "\t\tif(!o1S";
  protected final String TEXT_187 = ".equals(o2S";
  protected final String TEXT_188 = ")){";
  protected final String TEXT_189 = NL + "\t\t\treturn o1S";
  protected final String TEXT_190 = ".compareTo(o2S";
  protected final String TEXT_191 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_192 = NL + "\t\t\treturn o2S";
  protected final String TEXT_193 = ".compareTo(o1S";
  protected final String TEXT_194 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_195 = NL + "\t\t}";
  protected final String TEXT_196 = NL + "\t\tString o1S";
  protected final String TEXT_197 = " = String.valueOf(o1.";
  protected final String TEXT_198 = ");" + NL + "\t\tString o2S";
  protected final String TEXT_199 = " = String.valueOf(o2.";
  protected final String TEXT_200 = ");" + NL + "\t\tif(!o1S";
  protected final String TEXT_201 = ".equals(o2S";
  protected final String TEXT_202 = ")){";
  protected final String TEXT_203 = NL + "\t\t\treturn o1S";
  protected final String TEXT_204 = ".compareTo(o2S";
  protected final String TEXT_205 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_206 = NL + "\t\t\treturn o2S";
  protected final String TEXT_207 = ".compareTo(o1S";
  protected final String TEXT_208 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_209 = NL + "\t\t}";
  protected final String TEXT_210 = NL + "\t\tif(o1.";
  protected final String TEXT_211 = " == null && o2.";
  protected final String TEXT_212 = " != null){";
  protected final String TEXT_213 = NL + "\t\t\treturn -1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_214 = NL + "\t\t\treturn 1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_215 = NL + "\t\t}else if(o1.";
  protected final String TEXT_216 = " != null && o2.";
  protected final String TEXT_217 = " == null){";
  protected final String TEXT_218 = NL + "\t\t\treturn 1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_219 = NL + "\t\t\treturn -1;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_220 = NL + "\t\t}else if(o1.";
  protected final String TEXT_221 = " != null && o2.";
  protected final String TEXT_222 = " != null){" + NL + "\t\t\tif(!o1.";
  protected final String TEXT_223 = ".equals(o2.";
  protected final String TEXT_224 = ")){";
  protected final String TEXT_225 = NL + "\t\t\t\treturn o1.";
  protected final String TEXT_226 = ".compareTo(o2.";
  protected final String TEXT_227 = ");";
  protected final String TEXT_228 = NL + "\t\t\t\treturn o2.";
  protected final String TEXT_229 = ".compareTo(o1.";
  protected final String TEXT_230 = ");";
  protected final String TEXT_231 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_232 = NL + "\t\treturn 0;" + NL + "\t}" + NL + "}";
  protected final String TEXT_233 = NL + "all the columns in the \"schema column\" of the table:\"Criteria\" in ";
  protected final String TEXT_234 = " should be included in the schema of ";
  protected final String TEXT_235 = ";";
  protected final String TEXT_236 = NL + "    " + NL + "    //java.util.List<Comparable";
  protected final String TEXT_237 = "Struct> srtList_";
  protected final String TEXT_238 = " = new java.util.ArrayList<Comparable";
  protected final String TEXT_239 = "Struct>();" + NL + "    " + NL + "    //Comparable";
  protected final String TEXT_240 = "Struct tmpOut_";
  protected final String TEXT_241 = " = null;" + NL + "    org.talend.concurrent.sorts.TournamentTree<";
  protected final String TEXT_242 = "Struct," + NL + "    \tComparable";
  protected final String TEXT_243 = "Struct> tTree_";
  protected final String TEXT_244 = " = " + NL + "    \tnew org.talend.concurrent.sorts.TournamentTree<";
  protected final String TEXT_245 = "Struct," + NL + "    \tComparable";
  protected final String TEXT_246 = "Struct>(new Comparable";
  protected final String TEXT_247 = "Struct());" + NL + "    \t";
  protected final String TEXT_248 = NL + "    ";
  protected final String TEXT_249 = "Struct tmpIn_";
  protected final String TEXT_250 = " = null;";
  protected final String TEXT_251 = NL + "    int nextIndex_";
  protected final String TEXT_252 = " = -1;" + NL + "    //need to wait for the queues to come on line." + NL + " \tfor (int i_";
  protected final String TEXT_253 = " = 0; i_";
  protected final String TEXT_254 = " < ";
  protected final String TEXT_255 = "; i_";
  protected final String TEXT_256 = "++) {" + NL + " \t\ttTree_";
  protected final String TEXT_257 = ".addSource(queues_";
  protected final String TEXT_258 = ".get(i_";
  protected final String TEXT_259 = ")); \t\t" + NL + " \t}\t" + NL + " \t";
  protected final String TEXT_260 = NL + " //let's sleep for 1 second to see if that decreases the poll overhead" + NL + " " + NL + " " + NL + "boolean finished_";
  protected final String TEXT_261 = " = false;" + NL + "int counter_";
  protected final String TEXT_262 = " = 0;" + NL + "" + NL + "" + NL + "while (!finished_";
  protected final String TEXT_263 = ") {//main loop" + NL;
  protected final String TEXT_264 = "    " + NL + " \tif (!tTree_";
  protected final String TEXT_265 = ".isDone()) {" + NL + "    //";
  protected final String TEXT_266 = "Struct tmp_";
  protected final String TEXT_267 = " = bms_";
  protected final String TEXT_268 = ".pop();" + NL + "    //if (!bms_";
  protected final String TEXT_269 = ".isDone()) {" + NL + "    \t";
  protected final String TEXT_270 = "Struct tmp_";
  protected final String TEXT_271 = " = tTree_";
  protected final String TEXT_272 = ".pop();" + NL + "    \t" + NL + "    \t";
  protected final String TEXT_273 = " = tmp_";
  protected final String TEXT_274 = " == null ? null : new ";
  protected final String TEXT_275 = "Struct();" + NL + "    \tif (tmp_";
  protected final String TEXT_276 = " != null) {" + NL + "    \t";
  protected final String TEXT_277 = NL + "\t\t\t";
  protected final String TEXT_278 = ".";
  protected final String TEXT_279 = " = tmp_";
  protected final String TEXT_280 = ".";
  protected final String TEXT_281 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_282 = NL + "\t\t                log4jSb_";
  protected final String TEXT_283 = ".append(";
  protected final String TEXT_284 = ".";
  protected final String TEXT_285 = ");" + NL + "\t\t                ";
  protected final String TEXT_286 = NL + "\t\t                \tlog4jSb_";
  protected final String TEXT_287 = ".append(\"|\");" + NL + "\t\t                ";
  protected final String TEXT_288 = "\t" + NL + "\t\t    \t";
  protected final String TEXT_289 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_290 = " - Recollect the record : \" + log4jSb_";
  protected final String TEXT_291 = ");" + NL + "\t\t\t\t\tlog4jSb_";
  protected final String TEXT_292 = ".delete(0,log4jSb_";
  protected final String TEXT_293 = ".length());" + NL + "\t\t\t\t";
  protected final String TEXT_294 = NL + "    \t}" + NL + "    \tcounter_";
  protected final String TEXT_295 = "++;";
  protected final String TEXT_296 = NL + "\t";
  protected final String TEXT_297 = " = null;" + NL + "\tif (queues_";
  protected final String TEXT_298 = ".size() > 0) {" + NL + "\t    int curIndex_";
  protected final String TEXT_299 = " = counter_";
  protected final String TEXT_300 = " % ";
  protected final String TEXT_301 = ";" + NL + "\t\tif (curIndex_";
  protected final String TEXT_302 = " >= queues_";
  protected final String TEXT_303 = ".size()) {" + NL + "\t\t\tcurIndex_";
  protected final String TEXT_304 = " = queues_";
  protected final String TEXT_305 = ".size() - 1;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t//added to get around skewed queue sizes (i.e. when hash partition is used and" + NL + "\t\t//1 partition may not get any hashes" + NL + "\t\tif (curIndex_";
  protected final String TEXT_306 = " == 0 && queues_";
  protected final String TEXT_307 = ".get(curIndex_";
  protected final String TEXT_308 = ").size() == 0) {" + NL + "\t\t\tcurIndex_";
  protected final String TEXT_309 = " = queues_";
  protected final String TEXT_310 = ".size() - 1;" + NL + "\t\t}" + NL + "\t\twhile (queues_";
  protected final String TEXT_311 = ".get(curIndex_";
  protected final String TEXT_312 = ").size() == 0 && curIndex_";
  protected final String TEXT_313 = " > 0) {" + NL + "\t\t    curIndex_";
  protected final String TEXT_314 = "--;" + NL + "\t\t}" + NL + "\t\tObject tmp_";
  protected final String TEXT_315 = " = queues_";
  protected final String TEXT_316 = ".get(curIndex_";
  protected final String TEXT_317 = ").poll();" + NL + "\t\tif (tmp_";
  protected final String TEXT_318 = " != null) {" + NL + "\t\t\ttmpIn_";
  protected final String TEXT_319 = " = (";
  protected final String TEXT_320 = "Struct)tmp_";
  protected final String TEXT_321 = ";" + NL + "\t\t\t";
  protected final String TEXT_322 = " = new ";
  protected final String TEXT_323 = "Struct();" + NL + "\t\t\t";
  protected final String TEXT_324 = NL + "\t\t\t";
  protected final String TEXT_325 = ".";
  protected final String TEXT_326 = " = tmpIn_";
  protected final String TEXT_327 = ".";
  protected final String TEXT_328 = ";" + NL + "\t\t\t";
  protected final String TEXT_329 = NL + "\t\t                log4jSb_";
  protected final String TEXT_330 = ".append(";
  protected final String TEXT_331 = ".";
  protected final String TEXT_332 = ");" + NL + "\t\t                ";
  protected final String TEXT_333 = NL + "\t\t                \tlog4jSb_";
  protected final String TEXT_334 = ".append(\"|\");" + NL + "\t\t                ";
  protected final String TEXT_335 = NL + "\t\t    \t";
  protected final String TEXT_336 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_337 = " - Recollect the record : \" + log4jSb_";
  protected final String TEXT_338 = ");" + NL + "\t\t\t\t\tlog4jSb_";
  protected final String TEXT_339 = ".delete(0,log4jSb_";
  protected final String TEXT_340 = ".length());" + NL + "\t\t\t\t";
  protected final String TEXT_341 = NL + "\t\t\tcounter_";
  protected final String TEXT_342 = "++;" + NL + "\t\t} else {" + NL + "\t\t\tif (globalMap.get(\"FINISHED_";
  protected final String TEXT_343 = "\") != null && queues_";
  protected final String TEXT_344 = ".get(curIndex_";
  protected final String TEXT_345 = ").size() == 0) {" + NL + "\t\t\t\tqueues_";
  protected final String TEXT_346 = ".remove(curIndex_";
  protected final String TEXT_347 = ");" + NL + "\t\t    }\t\t" + NL + "\t\t \tcontinue;\t" + NL + "\t\t}" + NL + "\t   ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    INode srcNode = null;
    INode departitionNode = null;
    String cid = node.getUniqueName();	
    String srcCompo =null;// ElementParameterParser.getValue(node,"__SRC_COMPONENT__");
    String depComp = ElementParameterParser.getValue(node,"__DEPART_COMPONENT__");
    IProcess process = node.getProcess();
    List<IMetadataTable> metadatas = node.getMetadataList();
	IMetadataTable metadata = metadatas.get(0);
	List<IMetadataColumn> columnsout = metadata.getListColumns();
    List<? extends IConnection> connsout = node.getOutgoingConnections();
    boolean isSorting = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__IS_SORTING__"));
    List<? extends IConnection> startsConns = node.getIncomingConnections(EConnectionType.STARTS);
    for (int i = 0; i < startsConns.size(); i++) {
    	IConnection conn = startsConns.get(i);
    	INode source = conn.getSource();
    	if (source.getUniqueName().startsWith("tDepartitioner") && srcNode == null) {
    		INode start = org.talend.core.model.utils.NodeUtil.getSubProcessStartNode(source);
    		
    		List<? extends IConnection> stStart = start.getIncomingConnections(EConnectionType.STARTS);
    		if (stStart == null || stStart.size() == 0) {
    			return "tCollector is missing!";
    		}
    		IConnection c = stStart.get(0);
    		if (c != null) {
    			start = c.getSource();//the partitioner to our collector.
    		}
    		srcCompo = start.getUniqueName();
    		srcNode = start;    		  		
    	}
    }
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(srcCompo);
    
    String outName = null;
    if (connsout != null) {
       	for (int i = 0; i < connsout.size(); i++) {
           	IConnection connout = connsout.get(i);
           	if (connout.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
           		outName = connout.getName();
           	}
        }
    }
           
    
    
    boolean found = false;
    
    
    stringBuffer.append(TEXT_2);
    
    List<? extends INode> departitionNodes = process.getNodesOfType("tDepartitioner");
    for (int i = 0; i < departitionNodes.size() && !found; i++) {
    	INode tmpNode = departitionNodes.get(i);
    	if (tmpNode.getUniqueName().equals(depComp)) {
    		found = true;
    		departitionNode = tmpNode;    		  		
    	}
    }
    
    INode startNode = org.talend.core.model.utils.NodeUtil.getSubProcessStartNode(departitionNode);
    
    String startCid = startNode.getUniqueName();
    String dConnName = null;
    if (departitionNode.getIncomingConnections().size() == 1) {
        IConnection conn = departitionNode.getIncomingConnections().get(0);
        dConnName = conn.getName();
    }
    String numQueues = ElementParameterParser.getValue(srcNode,"__NUM_PARTITIONS__");
    
    stringBuffer.append(TEXT_3);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dConnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dConnName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(numQueues);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(numQueues);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(dConnName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(startCid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(depComp);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(srcCompo);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(numQueues);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(numQueues);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(numQueues);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(numQueues);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(dConnName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(dConnName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(depComp);
    stringBuffer.append(TEXT_53);
     if (isSorting) { 
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
     } else { 
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    }
    stringBuffer.append(TEXT_66);
    
    //still with me?  I've stolen the PORTS parameter from the tPartition so that I can grab the object input streams.:D
    //now it's time to steal the schema of the tSortRow... long story, but it involves that whole Comparable thing... 
    //we have the tDepartitioner of relevance due to the parameter and so forth.  Now we have to reverse traverse that subjob
    //to get to the tSortRow's incoming connection... o.O
    List<? extends IConnection> dpInConns = departitionNode.getIncomingConnections(EConnectionType.FLOW_MAIN);
    
    //can be only 1!
    IConnection dpInConn = dpInConns.get(0);
    String dpInConnName = dpInConn.getName();
    INode dpInConnSrc = dpInConn.getSource();
    INode tmpNode = dpInConnSrc;
    String nm = dpInConnSrc.getComponent().getName();
    if (isSorting) {
	    while (!nm.equals("tSortOut") && tmpNode!=null && tmpNode.getIncomingConnections().size() > 0) {
	       List<? extends IConnection> tmpConns = tmpNode.getIncomingConnections();
	       tmpNode = null;
	       for(IConnection tmpInConn : tmpConns) {
	       		if(tmpInConn.getLineStyle() != EConnectionType.FLOW_REF) {
	            	tmpNode = tmpInConn.getSource();
	            	nm = tmpNode.getComponent().getName();
	            	break;
	            }
	       }
	    }
    }
    List<Map<String,String>> criterias = (List<Map<String,String>>)ElementParameterParser.getObjectValue(tmpNode,"__CRITERIA__");
    
    if (criterias != null) {
    final Integer SORT_NUM = 0;
	final Integer SORT_ALPHA = 1;
	final Integer SORT_DATE = 2;
	final Integer SORT_ASC = Integer.MAX_VALUE;
	final Integer SORT_DESC = Integer.MIN_VALUE;
	List<String> listCols = new ArrayList<String>();
	List<Integer> listCriterias = new ArrayList<Integer>();
	List<Integer> listCriteriaTypes = new ArrayList<Integer>();
	List<Boolean> listNullables = new ArrayList<Boolean>();
	List<String> listPatterns = new ArrayList<String>();
	List<JavaType> listColumnTypes = new ArrayList<JavaType>();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		if (metadata!=null) {
        	for (int i = 0 ; i < criterias.size() ; i++) {
        		Map<String, String> line = criterias.get(i);
        		String colname = line.get("COLNAME");
        		if(listCols.contains(colname)){
        			continue;//skip dipulicate
        		}
        		listCols.add(colname);
        		if(("asc").equals(line.get("ORDER"))){
        			listCriterias.add(SORT_ASC);
        		}else{
        			listCriterias.add(SORT_DESC);
        		}
        		if(("num").equals(line.get("SORT"))){
        			listCriteriaTypes.add(SORT_NUM);
        		}else if(("alpha").equals(line.get("SORT"))){
        			listCriteriaTypes.add(SORT_ALPHA);
        		}else{
        			listCriteriaTypes.add(SORT_DATE);
        		}
    
        		for (IMetadataColumn column : metadata.getListColumns()) {
        			if (column.getLabel().compareTo(colname)==0) {
        				listColumnTypes.add(JavaTypesManager.getJavaTypeFromId(column.getTalendType()));
        				if(JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), false)){
	        				listNullables.add(column.isNullable());
        				}else{
	        				listNullables.add(true);
    	    			}
        				listPatterns.add(column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern());
        			
        			}
        		}
    		}
    		
    	if (listCols.size() == listColumnTypes.size()) { 
    	// the column names in the table:"Criteria" of tSortRow are included in the schema of tRecollector When "Merge sort partitions" is ticked
    		for (int i = 0 ; i < listCols.size() ; i++) {
    			Integer criteriaType = listCriteriaTypes.get(i);
    			JavaType columnType = listColumnTypes.get(i);
    			if(criteriaType == SORT_NUM){
    				if(!columnType.isPrimitive()){
    					if("id_Dynamic".equals(columnType.getId()) || columnType == JavaTypesManager.LIST 
    						|| columnType == JavaTypesManager.BYTE_ARRAY || columnType == JavaTypesManager.OBJECT 
    						|| columnType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_67);
    stringBuffer.append(listCols.get(i) );
    stringBuffer.append(TEXT_68);
    
						}
					}
				}else if(criteriaType == SORT_DATE){
					if(columnType != JavaTypesManager.DATE){

    stringBuffer.append(TEXT_69);
    stringBuffer.append(listCols.get(i) );
    stringBuffer.append(TEXT_70);
    
					}
				}
			}	
    
    stringBuffer.append(TEXT_71);
    stringBuffer.append(dConnName );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(dConnName );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(dConnName );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(dConnName );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(dConnName);
    stringBuffer.append(TEXT_76);
    
			for (int i = 0 ; i < listCols.size() ; i++) {
				String colname = listCols.get(i);	
				JavaType columnType = listColumnTypes.get(i);
				Integer criteriaType = listCriteriaTypes.get(i);
				Integer criteria = listCriterias.get(i);
				if (i == 0) {
				
    stringBuffer.append(TEXT_77);
    
			if (criteria == SORT_ASC) {
		
    stringBuffer.append(TEXT_78);
    
			} else {
		
    stringBuffer.append(TEXT_79);
    
			}
		
    stringBuffer.append(TEXT_80);
    
			if (criteria == SORT_ASC) {
		
    stringBuffer.append(TEXT_81);
    
			} else {
		
    stringBuffer.append(TEXT_82);
    
			}
		
    stringBuffer.append(TEXT_83);
    
				}
				if(criteriaType == SORT_NUM){
					if("id_Dynamic".equals(columnType.getId())){
					} else if(listNullables.get(i)){//

    stringBuffer.append(TEXT_84);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_86);
    
						if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_87);
    
						}else{
						
    stringBuffer.append(TEXT_88);
    
						}

    stringBuffer.append(TEXT_89);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_91);
    
						if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_92);
    
						}else{
						
    stringBuffer.append(TEXT_93);
    
						}

    stringBuffer.append(TEXT_94);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_98);
    
						if(criteria == SORT_ASC){

    stringBuffer.append(TEXT_99);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_101);
    
						}else{

    stringBuffer.append(TEXT_102);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_104);
    
						}

    stringBuffer.append(TEXT_105);
    
					}else{//end tag for if(listNullables.get(i))
						if(columnType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_106);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_108);
    
							if(criteria == SORT_ASC){

    stringBuffer.append(TEXT_109);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_110);
    
							}else{

    stringBuffer.append(TEXT_111);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_112);
    
							}

    stringBuffer.append(TEXT_113);
    
						}else {

    stringBuffer.append(TEXT_114);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_116);
    
							if(criteria == SORT_ASC){
							
    stringBuffer.append(TEXT_117);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_119);
    
							}else{
							
    stringBuffer.append(TEXT_120);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_122);
    
							}
						
    stringBuffer.append(TEXT_123);
    
						}
					}//end of if(listNullables.get(i))
				}else if(criteriaType == SORT_ALPHA){//end tag for if(criteriaType == SORT_NUM)
					if(columnType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_124);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_132);
    
							if(criteria == SORT_ASC){
							
    stringBuffer.append(TEXT_133);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_135);
    
							}else{
							
    stringBuffer.append(TEXT_136);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_138);
    
							}

    stringBuffer.append(TEXT_139);
    
					}else if(columnType == JavaTypesManager.DATE){

    stringBuffer.append(TEXT_140);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(listPatterns.get(i) );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(listPatterns.get(i) );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_150);
    
							if(criteria == SORT_ASC){
							
    stringBuffer.append(TEXT_151);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_153);
    
							}else{
							
    stringBuffer.append(TEXT_154);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_156);
    
							}

    stringBuffer.append(TEXT_157);
    
					}else if(columnType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_158);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_160);
    
							if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_161);
    
							}else{
						
    stringBuffer.append(TEXT_162);
    
							}

    stringBuffer.append(TEXT_163);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_165);
    
							if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_166);
    
							}else{
						
    stringBuffer.append(TEXT_167);
    
							}

    stringBuffer.append(TEXT_168);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_172);
    
							if(criteria == SORT_ASC){

    stringBuffer.append(TEXT_173);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_175);
    
							}else{

    stringBuffer.append(TEXT_176);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_178);
    
							}

    stringBuffer.append(TEXT_179);
    
					}else{
						if(listNullables.get(i)){

    stringBuffer.append(TEXT_180);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_188);
    
							if(criteria == SORT_ASC){
							
    stringBuffer.append(TEXT_189);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_191);
    
							}else{
							
    stringBuffer.append(TEXT_192);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_194);
    
							}

    stringBuffer.append(TEXT_195);
    
						}else{

    stringBuffer.append(TEXT_196);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_202);
    
							if(criteria == SORT_ASC){
							
    stringBuffer.append(TEXT_203);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_205);
    
							}else{
							
    stringBuffer.append(TEXT_206);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_208);
    
							}

    stringBuffer.append(TEXT_209);
    
						}
					}
				}else if(!"id_Dynamic".equals(columnType.getId())){//end tag for if(criteriaType == SORT_ALPHA) for SORT_DATE

    stringBuffer.append(TEXT_210);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_212);
    
							if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_213);
    
							}else{
						
    stringBuffer.append(TEXT_214);
    
							}

    stringBuffer.append(TEXT_215);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_217);
    
							if(criteria == SORT_ASC){
						
    stringBuffer.append(TEXT_218);
    
							}else{
						
    stringBuffer.append(TEXT_219);
    
							}

    stringBuffer.append(TEXT_220);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_224);
    
							if(criteria == SORT_ASC){

    stringBuffer.append(TEXT_225);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_227);
    
							}else{

    stringBuffer.append(TEXT_228);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_230);
    
							}

    stringBuffer.append(TEXT_231);
    
				}//end of if(criteriaType == SORT_NUM)
			}

    stringBuffer.append(TEXT_232);
    
			} else { // if (listCols.size() == listColumnTypes.size()) end

    stringBuffer.append(TEXT_233);
    stringBuffer.append(tmpNode.getUniqueName().replace("_SortOut",""));
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    
			}
		}
	}

    stringBuffer.append(TEXT_236);
    stringBuffer.append(outName);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(outName);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(outName);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(dConnName);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(dConnName);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(dConnName);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(dConnName);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(dConnName);
    stringBuffer.append(TEXT_247);
    
 }
 
    stringBuffer.append(TEXT_248);
    stringBuffer.append(dpInConnName);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
     if (criterias != null) { 
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(numQueues);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    
 	
 	}
 	
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    
if (criterias != null) {

    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(dConnName);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(dConnName);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(outName);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(outName);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    
   			int curCount = 0;
			for (int i = 0 ; i < columnsout.size() ; i++) {
				String colname = columnsout.get(i).getLabel();
				
    stringBuffer.append(TEXT_277);
    stringBuffer.append(outName);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_281);
    
    				if(isLog4jEnabled){
						curCount++;
					
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(outName);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_285);
    if(curCount < columnsout.size()){
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    }
					}
			}
			
    stringBuffer.append(TEXT_288);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    }
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
     } else { 
    stringBuffer.append(TEXT_296);
    stringBuffer.append(outName);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(numQueues);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(dpInConnName);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(outName);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(outName);
    stringBuffer.append(TEXT_323);
    
   			int count = 0;
			for (IMetadataColumn column : columnsout) {
			
    stringBuffer.append(TEXT_324);
    stringBuffer.append(outName);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_328);
    
    				if(isLog4jEnabled){
						count++;
					
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(outName);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_332);
    if(count < columnsout.size()){
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    }
					}
			}
			
    stringBuffer.append(TEXT_335);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    }
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
     } 
    return stringBuffer.toString();
  }
}
