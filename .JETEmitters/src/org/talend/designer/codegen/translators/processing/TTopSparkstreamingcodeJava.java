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
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TTopSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TTopSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTopSparkstreamingcodeJava result = new TTopSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
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
  protected final String TEXT_30 = NL + "            // No sparkconfig generated for unnecessary ";
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = NL + "        ";
  protected final String TEXT_33 = " rdd_";
  protected final String TEXT_34 = " =" + NL + "            ctx.parallelizePairs(" + NL + "                    rdd_";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = "(";
  protected final String TEXT_37 = "," + NL + "                        new ";
  protected final String TEXT_38 = "(job))," + NL + "                1); // One partition to keep the ordering.";
  protected final String TEXT_39 = NL + "            return -1;";
  protected final String TEXT_40 = NL + "            return 1;";
  protected final String TEXT_41 = NL + "            return 1;";
  protected final String TEXT_42 = NL + "            return -1;";
  protected final String TEXT_43 = NL + "            if(data1.";
  protected final String TEXT_44 = " == null && data2.";
  protected final String TEXT_45 = " != null){";
  protected final String TEXT_46 = NL + "            }else if(data1.";
  protected final String TEXT_47 = " != null && data2.";
  protected final String TEXT_48 = " == null){";
  protected final String TEXT_49 = NL + "            }else if(data1.";
  protected final String TEXT_50 = " == null && data2.";
  protected final String TEXT_51 = " == null){" + NL + "                //ignore" + NL + "            }else{";
  protected final String TEXT_52 = NL + "                if(data1.";
  protected final String TEXT_53 = " != data2.";
  protected final String TEXT_54 = "){" + NL + "                    if(data1.";
  protected final String TEXT_55 = "){";
  protected final String TEXT_56 = NL + "                    }else{";
  protected final String TEXT_57 = NL + "                    }" + NL + "                }";
  protected final String TEXT_58 = NL + "                if(data1.";
  protected final String TEXT_59 = " > data2.";
  protected final String TEXT_60 = "){";
  protected final String TEXT_61 = NL + "                }else if(data1.";
  protected final String TEXT_62 = " < data2.";
  protected final String TEXT_63 = "){";
  protected final String TEXT_64 = NL + "                }";
  protected final String TEXT_65 = NL + "                String s1_";
  protected final String TEXT_66 = " = new String(data1.";
  protected final String TEXT_67 = ");" + NL + "                String s2_";
  protected final String TEXT_68 = " = new String(data2.";
  protected final String TEXT_69 = ");" + NL + "                if(!s1_";
  protected final String TEXT_70 = ".equals(s2_";
  protected final String TEXT_71 = ")){" + NL + "                    if(s1_";
  protected final String TEXT_72 = ".compareTo(s2_";
  protected final String TEXT_73 = ") > 0){";
  protected final String TEXT_74 = NL + "                    }else{";
  protected final String TEXT_75 = NL + "                    }" + NL + "                }";
  protected final String TEXT_76 = NL + "                if(data1.";
  protected final String TEXT_77 = " - data2.";
  protected final String TEXT_78 = " != 0){" + NL + "                    if(data1.";
  protected final String TEXT_79 = " - data2.";
  protected final String TEXT_80 = " > 0){";
  protected final String TEXT_81 = NL + "                    }else{";
  protected final String TEXT_82 = NL + "                    }" + NL + "                }";
  protected final String TEXT_83 = NL + "                    int cmp_";
  protected final String TEXT_84 = " = FormatterUtils.format_DateInUTC(data1.";
  protected final String TEXT_85 = ", ";
  protected final String TEXT_86 = ").compareTo(FormatterUtils.format_DateInUTC(data2.";
  protected final String TEXT_87 = ", ";
  protected final String TEXT_88 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_89 = " > 0){";
  protected final String TEXT_90 = NL + "                    }else if(cmp_";
  protected final String TEXT_91 = " < 0){";
  protected final String TEXT_92 = NL + "                    }";
  protected final String TEXT_93 = NL + "                    if(!data1.";
  protected final String TEXT_94 = ".equals(data2.";
  protected final String TEXT_95 = ")){" + NL + "                        if(data1.";
  protected final String TEXT_96 = ".compareTo(data2.";
  protected final String TEXT_97 = ") > 0){";
  protected final String TEXT_98 = NL + "                        }else{";
  protected final String TEXT_99 = NL + "                        }" + NL + "                    }";
  protected final String TEXT_100 = NL + "                    int cmp_";
  protected final String TEXT_101 = " = String.valueOf(data1.";
  protected final String TEXT_102 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_103 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_104 = " > 0){";
  protected final String TEXT_105 = NL + "                    }else if(cmp_";
  protected final String TEXT_106 = " < 0){";
  protected final String TEXT_107 = NL + "                    }";
  protected final String TEXT_108 = NL + "                    if(data1.";
  protected final String TEXT_109 = " > data2.";
  protected final String TEXT_110 = "){";
  protected final String TEXT_111 = NL + "                    }else if(data1.";
  protected final String TEXT_112 = " < data2.";
  protected final String TEXT_113 = "){";
  protected final String TEXT_114 = NL + "                    }";
  protected final String TEXT_115 = NL + "                    int cmp_";
  protected final String TEXT_116 = " = String.valueOf(data1.";
  protected final String TEXT_117 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_118 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_119 = " > 0){";
  protected final String TEXT_120 = NL + "                    }else if(cmp_";
  protected final String TEXT_121 = " < 0){";
  protected final String TEXT_122 = NL + "                    }";
  protected final String TEXT_123 = NL + "                    if(data1.";
  protected final String TEXT_124 = " > data2.";
  protected final String TEXT_125 = "){";
  protected final String TEXT_126 = NL + "                    }else if(data1.";
  protected final String TEXT_127 = " < data2.";
  protected final String TEXT_128 = "){";
  protected final String TEXT_129 = NL + "                    }";
  protected final String TEXT_130 = NL + "                    int cmp_";
  protected final String TEXT_131 = " = String.valueOf(data1.";
  protected final String TEXT_132 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_133 = "));";
  protected final String TEXT_134 = NL + "                    int cmp_";
  protected final String TEXT_135 = " = data1.";
  protected final String TEXT_136 = ".compareTo(data2.";
  protected final String TEXT_137 = ");";
  protected final String TEXT_138 = NL + "                if(cmp_";
  protected final String TEXT_139 = " > 0){";
  protected final String TEXT_140 = NL + "                }else if(cmp_";
  protected final String TEXT_141 = " < 0){";
  protected final String TEXT_142 = NL + "                }";
  protected final String TEXT_143 = NL + "                    int cmp_";
  protected final String TEXT_144 = " = String.valueOf(data1.";
  protected final String TEXT_145 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_146 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_147 = " > 0){";
  protected final String TEXT_148 = NL + "                    }else if(cmp_";
  protected final String TEXT_149 = " < 0){";
  protected final String TEXT_150 = NL + "                    }";
  protected final String TEXT_151 = NL + "                    if(data1.";
  protected final String TEXT_152 = " > data2.";
  protected final String TEXT_153 = "){";
  protected final String TEXT_154 = NL + "                    }else if(data1.";
  protected final String TEXT_155 = " < data2.";
  protected final String TEXT_156 = "){";
  protected final String TEXT_157 = NL + "                    }";
  protected final String TEXT_158 = NL + "                    int cmp_";
  protected final String TEXT_159 = " = String.valueOf(data1.";
  protected final String TEXT_160 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_161 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_162 = " > 0){";
  protected final String TEXT_163 = NL + "                    }else if(cmp_";
  protected final String TEXT_164 = " < 0){";
  protected final String TEXT_165 = NL + "                }";
  protected final String TEXT_166 = NL + "                if(data1.";
  protected final String TEXT_167 = " > data2.";
  protected final String TEXT_168 = "){";
  protected final String TEXT_169 = NL + "                }else if(data1.";
  protected final String TEXT_170 = " < data2.";
  protected final String TEXT_171 = "){";
  protected final String TEXT_172 = NL + "                }";
  protected final String TEXT_173 = NL + "            Don't support Object type: column--";
  protected final String TEXT_174 = NL + "                int cmp_";
  protected final String TEXT_175 = " = String.valueOf(data1.";
  protected final String TEXT_176 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_177 = "));" + NL + "                if(cmp_";
  protected final String TEXT_178 = " > 0){";
  protected final String TEXT_179 = NL + "                }else if(cmp_";
  protected final String TEXT_180 = " < 0){";
  protected final String TEXT_181 = NL + "                }";
  protected final String TEXT_182 = NL + "                if(data1.";
  protected final String TEXT_183 = " > data2.";
  protected final String TEXT_184 = "){";
  protected final String TEXT_185 = NL + "                }else if(data1.";
  protected final String TEXT_186 = " < data2.";
  protected final String TEXT_187 = "){";
  protected final String TEXT_188 = NL + "                }";
  protected final String TEXT_189 = NL + "            int comp_";
  protected final String TEXT_190 = " = data1.";
  protected final String TEXT_191 = ".compareTo(data2.";
  protected final String TEXT_192 = ");" + NL + "            if(comp_";
  protected final String TEXT_193 = " != 0){" + NL + "                if(comp_";
  protected final String TEXT_194 = " > 0){";
  protected final String TEXT_195 = NL + "                }else{";
  protected final String TEXT_196 = NL + "                }" + NL + "" + NL + "            }";
  protected final String TEXT_197 = NL + "            Don't support List type: column--";
  protected final String TEXT_198 = NL + "            Don't support Document type: column--";
  protected final String TEXT_199 = NL + "            Don't support Dynamic type: column--";
  protected final String TEXT_200 = NL + "            }";
  protected final String TEXT_201 = NL + "\t";
  protected final String TEXT_202 = NL + "            public static class ";
  protected final String TEXT_203 = " implements ";
  protected final String TEXT_204 = " {";
  protected final String TEXT_205 = NL + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_206 = "(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "\t            public ";
  protected final String TEXT_207 = " ";
  protected final String TEXT_208 = "(";
  protected final String TEXT_209 = ") ";
  protected final String TEXT_210 = " {" + NL + "\t            \t";
  protected final String TEXT_211 = NL + "\t            \t";
  protected final String TEXT_212 = NL + "\t                ";
  protected final String TEXT_213 = NL + "\t                return ";
  protected final String TEXT_214 = ";" + NL + "\t            }" + NL + "\t        }" + NL + "\t\t";
  protected final String TEXT_215 = NL + "            public static class ";
  protected final String TEXT_216 = " implements ";
  protected final String TEXT_217 = " {";
  protected final String TEXT_218 = NL + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_219 = "(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_220 = " ";
  protected final String TEXT_221 = "(";
  protected final String TEXT_222 = ") ";
  protected final String TEXT_223 = " {" + NL + "                \t";
  protected final String TEXT_224 = NL + "\t                 \treturn ";
  protected final String TEXT_225 = ";";
  protected final String TEXT_226 = NL + "                }" + NL + "            }";
  protected final String TEXT_227 = NL;
  protected final String TEXT_228 = NL + "            // No sparkcode generated for unnecessary ";
  protected final String TEXT_229 = NL + "        public static class StreamingTop_";
  protected final String TEXT_230 = " implements org.apache.spark.api.java.function.Function<";
  protected final String TEXT_231 = ", ";
  protected final String TEXT_232 = "> {" + NL + "            transient private org.apache.spark.api.java.JavaSparkContext ctx = null;" + NL + "            private Integer top = 5;" + NL + "" + NL + "            public StreamingTop_";
  protected final String TEXT_233 = "(Integer top) {" + NL + "                this.top = top;" + NL + "            }" + NL + "" + NL + "            public ";
  protected final String TEXT_234 = " call(";
  protected final String TEXT_235 = " temporaryRdd)" + NL + "                    throws Exception {" + NL + "                if (ctx == null) {" + NL + "                    ctx = new org.apache.spark.api.java.JavaSparkContext(temporaryRdd.context());" + NL + "                }" + NL + "                return ctx.parallelizePairs(" + NL + "                        temporaryRdd.";
  protected final String TEXT_236 = "(top," + NL + "                                new ";
  protected final String TEXT_237 = "(new JobConf())));" + NL + "            }" + NL + "        }";
  protected final String TEXT_238 = NL + "            // No sparkconfig generated for unnecessary ";
  protected final String TEXT_239 = NL + "            ";
  protected final String TEXT_240 = " rdd_";
  protected final String TEXT_241 = " =" + NL + "                    rdd_";
  protected final String TEXT_242 = ".transformToPair(new StreamingTop_";
  protected final String TEXT_243 = "(";
  protected final String TEXT_244 = "));";
  protected final String TEXT_245 = NL + "\t";
  protected final String TEXT_246 = NL + "            return -1;";
  protected final String TEXT_247 = NL + "            return 1;";
  protected final String TEXT_248 = NL + "            return 1;";
  protected final String TEXT_249 = NL + "            return -1;";
  protected final String TEXT_250 = NL + "            if(data1.";
  protected final String TEXT_251 = " == null && data2.";
  protected final String TEXT_252 = " != null){";
  protected final String TEXT_253 = NL + "            }else if(data1.";
  protected final String TEXT_254 = " != null && data2.";
  protected final String TEXT_255 = " == null){";
  protected final String TEXT_256 = NL + "            }else if(data1.";
  protected final String TEXT_257 = " == null && data2.";
  protected final String TEXT_258 = " == null){" + NL + "                //ignore" + NL + "            }else{";
  protected final String TEXT_259 = NL + "                if(data1.";
  protected final String TEXT_260 = " != data2.";
  protected final String TEXT_261 = "){" + NL + "                    if(data1.";
  protected final String TEXT_262 = "){";
  protected final String TEXT_263 = NL + "                    }else{";
  protected final String TEXT_264 = NL + "                    }" + NL + "                }";
  protected final String TEXT_265 = NL + "                if(data1.";
  protected final String TEXT_266 = " > data2.";
  protected final String TEXT_267 = "){";
  protected final String TEXT_268 = NL + "                }else if(data1.";
  protected final String TEXT_269 = " < data2.";
  protected final String TEXT_270 = "){";
  protected final String TEXT_271 = NL + "                }";
  protected final String TEXT_272 = NL + "                String s1_";
  protected final String TEXT_273 = " = new String(data1.";
  protected final String TEXT_274 = ");" + NL + "                String s2_";
  protected final String TEXT_275 = " = new String(data2.";
  protected final String TEXT_276 = ");" + NL + "                if(!s1_";
  protected final String TEXT_277 = ".equals(s2_";
  protected final String TEXT_278 = ")){" + NL + "                    if(s1_";
  protected final String TEXT_279 = ".compareTo(s2_";
  protected final String TEXT_280 = ") > 0){";
  protected final String TEXT_281 = NL + "                    }else{";
  protected final String TEXT_282 = NL + "                    }" + NL + "                }";
  protected final String TEXT_283 = NL + "                if(data1.";
  protected final String TEXT_284 = " - data2.";
  protected final String TEXT_285 = " != 0){" + NL + "                    if(data1.";
  protected final String TEXT_286 = " - data2.";
  protected final String TEXT_287 = " > 0){";
  protected final String TEXT_288 = NL + "                    }else{";
  protected final String TEXT_289 = NL + "                    }" + NL + "                }";
  protected final String TEXT_290 = NL + "                    int cmp_";
  protected final String TEXT_291 = " = FormatterUtils.format_DateInUTC(data1.";
  protected final String TEXT_292 = ", ";
  protected final String TEXT_293 = ").compareTo(FormatterUtils.format_DateInUTC(data2.";
  protected final String TEXT_294 = ", ";
  protected final String TEXT_295 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_296 = " > 0){";
  protected final String TEXT_297 = NL + "                    }else if(cmp_";
  protected final String TEXT_298 = " < 0){";
  protected final String TEXT_299 = NL + "                    }";
  protected final String TEXT_300 = NL + "                    if(!data1.";
  protected final String TEXT_301 = ".equals(data2.";
  protected final String TEXT_302 = ")){" + NL + "                        if(data1.";
  protected final String TEXT_303 = ".compareTo(data2.";
  protected final String TEXT_304 = ") > 0){";
  protected final String TEXT_305 = NL + "                        }else{";
  protected final String TEXT_306 = NL + "                        }" + NL + "                    }";
  protected final String TEXT_307 = NL + "                    int cmp_";
  protected final String TEXT_308 = " = String.valueOf(data1.";
  protected final String TEXT_309 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_310 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_311 = " > 0){";
  protected final String TEXT_312 = NL + "                    }else if(cmp_";
  protected final String TEXT_313 = " < 0){";
  protected final String TEXT_314 = NL + "                    }";
  protected final String TEXT_315 = NL + "                    if(data1.";
  protected final String TEXT_316 = " > data2.";
  protected final String TEXT_317 = "){";
  protected final String TEXT_318 = NL + "                    }else if(data1.";
  protected final String TEXT_319 = " < data2.";
  protected final String TEXT_320 = "){";
  protected final String TEXT_321 = NL + "                    }";
  protected final String TEXT_322 = NL + "                    int cmp_";
  protected final String TEXT_323 = " = String.valueOf(data1.";
  protected final String TEXT_324 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_325 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_326 = " > 0){";
  protected final String TEXT_327 = NL + "                    }else if(cmp_";
  protected final String TEXT_328 = " < 0){";
  protected final String TEXT_329 = NL + "                    }";
  protected final String TEXT_330 = NL + "                    if(data1.";
  protected final String TEXT_331 = " > data2.";
  protected final String TEXT_332 = "){";
  protected final String TEXT_333 = NL + "                    }else if(data1.";
  protected final String TEXT_334 = " < data2.";
  protected final String TEXT_335 = "){";
  protected final String TEXT_336 = NL + "                    }";
  protected final String TEXT_337 = NL + "                    int cmp_";
  protected final String TEXT_338 = " = String.valueOf(data1.";
  protected final String TEXT_339 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_340 = "));";
  protected final String TEXT_341 = NL + "                    int cmp_";
  protected final String TEXT_342 = " = data1.";
  protected final String TEXT_343 = ".compareTo(data2.";
  protected final String TEXT_344 = ");";
  protected final String TEXT_345 = NL + "                if(cmp_";
  protected final String TEXT_346 = " > 0){";
  protected final String TEXT_347 = NL + "                }else if(cmp_";
  protected final String TEXT_348 = " < 0){";
  protected final String TEXT_349 = NL + "                }";
  protected final String TEXT_350 = NL + "                    int cmp_";
  protected final String TEXT_351 = " = String.valueOf(data1.";
  protected final String TEXT_352 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_353 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_354 = " > 0){";
  protected final String TEXT_355 = NL + "                    }else if(cmp_";
  protected final String TEXT_356 = " < 0){";
  protected final String TEXT_357 = NL + "                    }";
  protected final String TEXT_358 = NL + "                    if(data1.";
  protected final String TEXT_359 = " > data2.";
  protected final String TEXT_360 = "){";
  protected final String TEXT_361 = NL + "                    }else if(data1.";
  protected final String TEXT_362 = " < data2.";
  protected final String TEXT_363 = "){";
  protected final String TEXT_364 = NL + "                    }";
  protected final String TEXT_365 = NL + "                    int cmp_";
  protected final String TEXT_366 = " = String.valueOf(data1.";
  protected final String TEXT_367 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_368 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_369 = " > 0){";
  protected final String TEXT_370 = NL + "                    }else if(cmp_";
  protected final String TEXT_371 = " < 0){";
  protected final String TEXT_372 = NL + "                }";
  protected final String TEXT_373 = NL + "                if(data1.";
  protected final String TEXT_374 = " > data2.";
  protected final String TEXT_375 = "){";
  protected final String TEXT_376 = NL + "                }else if(data1.";
  protected final String TEXT_377 = " < data2.";
  protected final String TEXT_378 = "){";
  protected final String TEXT_379 = NL + "                }";
  protected final String TEXT_380 = NL + "            Don't support Object type: column--";
  protected final String TEXT_381 = NL + "                int cmp_";
  protected final String TEXT_382 = " = String.valueOf(data1.";
  protected final String TEXT_383 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_384 = "));" + NL + "                if(cmp_";
  protected final String TEXT_385 = " > 0){";
  protected final String TEXT_386 = NL + "                }else if(cmp_";
  protected final String TEXT_387 = " < 0){";
  protected final String TEXT_388 = NL + "                }";
  protected final String TEXT_389 = NL + "                if(data1.";
  protected final String TEXT_390 = " > data2.";
  protected final String TEXT_391 = "){";
  protected final String TEXT_392 = NL + "                }else if(data1.";
  protected final String TEXT_393 = " < data2.";
  protected final String TEXT_394 = "){";
  protected final String TEXT_395 = NL + "                }";
  protected final String TEXT_396 = NL + "            int comp_";
  protected final String TEXT_397 = " = data1.";
  protected final String TEXT_398 = ".compareTo(data2.";
  protected final String TEXT_399 = ");" + NL + "            if(comp_";
  protected final String TEXT_400 = " != 0){" + NL + "                if(comp_";
  protected final String TEXT_401 = " > 0){";
  protected final String TEXT_402 = NL + "                }else{";
  protected final String TEXT_403 = NL + "                }" + NL + "" + NL + "            }";
  protected final String TEXT_404 = NL + "            Don't support List type: column--";
  protected final String TEXT_405 = NL + "            Don't support Document type: column--";
  protected final String TEXT_406 = NL + "            Don't support Dynamic type: column--";
  protected final String TEXT_407 = NL + "            }";
  protected final String TEXT_408 = NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
if(org.talend.designer.common.tmap.LookupUtil.isNodeInBatchMode((INode) ((BigDataCodeGeneratorArgument) argument).getArgument())) {

    stringBuffer.append(TEXT_1);
    

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
            
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
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
            
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
            return;
        }

        functionGenerator = new SOFunctionGenerator(transformer, sparkFunction);

        functionGenerator.init(node, cid, null, transformer.getInConnName(), null, 
                transformer.getOutConnMainName() != null
                    ? transformer.getOutConnMainName()
                            : transformer.getOutConnRejectName());
        
    stringBuffer.append(TEXT_32);
    stringBuffer.append(sparkFunction.getConfigReturnedType(functionGenerator.getOutValueClass()));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(transformer.getInConnName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(sparkFunction.getConfigTransformation());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(topX);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_38);
    
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
        
    stringBuffer.append(TEXT_39);
    
        }else{
        
    stringBuffer.append(TEXT_40);
    
        }
    }
    private void genLesser(String columnName){
        if(criteriasOrderType.get(columnName)){
        
    stringBuffer.append(TEXT_41);
    
        }else{
        
    stringBuffer.append(TEXT_42);
    
        }
    }

    private void compareObjectColumn(IMetadataColumn column, int columnIterator){
        String columnNameToGenerate = "_1()._" + columnIterator + "()";
        boolean nullable = !JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
        String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
        String columnName = column.getLabel();
        if(nullable){
        
    stringBuffer.append(TEXT_43);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_45);
    lesser(columnName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_48);
    greater(columnName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_51);
    }
    
            if(typeToGenerate.equalsIgnoreCase("Boolean")){
            
    stringBuffer.append(TEXT_52);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_55);
    greater(columnName);
    stringBuffer.append(TEXT_56);
    lesser(columnName);
    stringBuffer.append(TEXT_57);
    
            }else if(typeToGenerate.equalsIgnoreCase("Byte")){
            
    stringBuffer.append(TEXT_58);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_60);
    greater(columnName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_63);
    lesser(columnName);
    stringBuffer.append(TEXT_64);
    
            }else if(typeToGenerate.equals("byte[]")){
            
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
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_73);
    greater(columnName);
    stringBuffer.append(TEXT_74);
    lesser(columnName);
    stringBuffer.append(TEXT_75);
    
            }else if(typeToGenerate.equalsIgnoreCase("Char") || typeToGenerate.equalsIgnoreCase("Character")){
            
    stringBuffer.append(TEXT_76);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_80);
    greater(columnName);
    stringBuffer.append(TEXT_81);
    lesser(columnName);
    stringBuffer.append(TEXT_82);
    
            }else if(typeToGenerate.equals("java.util.Date")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_83);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_89);
    greater(columnName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_91);
    lesser(columnName);
    stringBuffer.append(TEXT_92);
    
                }else{
                
    stringBuffer.append(TEXT_93);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_97);
    greater(columnName);
    stringBuffer.append(TEXT_98);
    lesser(columnName);
    stringBuffer.append(TEXT_99);
    
                }
            }else if(typeToGenerate.equalsIgnoreCase("Double")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_100);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_104);
    greater(columnName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_106);
    lesser(columnName);
    stringBuffer.append(TEXT_107);
    
                }else{
                
    stringBuffer.append(TEXT_108);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_110);
    greater(columnName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_113);
    lesser(columnName);
    stringBuffer.append(TEXT_114);
    
                }
            }else if(typeToGenerate.equalsIgnoreCase("Float")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_115);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_119);
    greater(columnName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_121);
    lesser(columnName);
    stringBuffer.append(TEXT_122);
    
                }else{
                
    stringBuffer.append(TEXT_123);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_125);
    greater(columnName);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_128);
    lesser(columnName);
    stringBuffer.append(TEXT_129);
    
                }
            }else if(typeToGenerate.equals("BigDecimal")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_130);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_133);
    
                }else{
                
    stringBuffer.append(TEXT_134);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_137);
    }
    stringBuffer.append(TEXT_138);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_139);
    greater(columnName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_141);
    lesser(columnName);
    stringBuffer.append(TEXT_142);
    
            }else if(typeToGenerate.equalsIgnoreCase("Integer") || typeToGenerate.equalsIgnoreCase("int")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_143);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_147);
    greater(columnName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_149);
    lesser(columnName);
    stringBuffer.append(TEXT_150);
    
                }else{
                
    stringBuffer.append(TEXT_151);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_153);
    greater(columnName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_156);
    lesser(columnName);
    stringBuffer.append(TEXT_157);
    
                }
            }else if(typeToGenerate.equalsIgnoreCase("Long")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_158);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_162);
    greater(columnName);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_164);
    lesser(columnName);
    stringBuffer.append(TEXT_165);
    
            }else{
            
    stringBuffer.append(TEXT_166);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_168);
    greater(columnName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_171);
    lesser(columnName);
    stringBuffer.append(TEXT_172);
    
            }
        }else if(typeToGenerate.equals("Object")){
        
    stringBuffer.append(TEXT_173);
    stringBuffer.append(columnNameToGenerate);
    
        }else if(typeToGenerate.equalsIgnoreCase("Short")){
        
    
            if(!sortTypes.get(columnName)){
            
    stringBuffer.append(TEXT_174);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_178);
    greater(columnName);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_180);
    lesser(columnName);
    stringBuffer.append(TEXT_181);
    
            }else{
            
    stringBuffer.append(TEXT_182);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_184);
    greater(columnName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_187);
    lesser(columnName);
    stringBuffer.append(TEXT_188);
    
            }
        }else if(typeToGenerate.equals("String")){
        
    stringBuffer.append(TEXT_189);
    stringBuffer.append(columnIterator);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(columnIterator);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(columnIterator);
    stringBuffer.append(TEXT_194);
    greater(columnName);
    stringBuffer.append(TEXT_195);
    lesser(columnName);
    stringBuffer.append(TEXT_196);
    
        }else if(typeToGenerate.equals("List")){
        
    stringBuffer.append(TEXT_197);
    stringBuffer.append(columnNameToGenerate);
    
        }else if(typeToGenerate.equals("Doucument")){
        
    stringBuffer.append(TEXT_198);
    stringBuffer.append(columnNameToGenerate);
    
        }else if(typeToGenerate.equals("Dynamic")){
        
    stringBuffer.append(TEXT_199);
    stringBuffer.append(columnNameToGenerate);
    
        }
        
    if(nullable){
    stringBuffer.append(TEXT_200);
    
        }
    }


}

    
final SparkRowTransformUtil sparkTransformUtil = new SparkRowTransformUtil();
final TTopUtil tTopUtil = new TTopUtil(node, codeGenArgument, sparkTransformUtil);

java.util.Map<String, java.util.List<org.talend.core.model.metadata.IMetadataColumn>> keyList = bigDataNode.getKeyList();
org.talend.designer.spark.generator.SparkFunction sparkFunction = new org.talend.designer.spark.generator.TopFunction(false, keyList);

sparkTransformUtil.generateSparkCode(tTopUtil, sparkFunction);

    
} else {
	final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
	final INode node = (INode) codeGenArgument.getArgument();
	final IBigDataNode bigDataNode = (IBigDataNode) codeGenArgument.getArgument();
	final String cid = node.getUniqueName();
	
    stringBuffer.append(TEXT_201);
    
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
		
    stringBuffer.append(TEXT_202);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(this.sparkFunction.getCodeFunctionImplementation(getOutValueClass(), getInValueClass()));
    stringBuffer.append(TEXT_204);
    
                this.transformer.generateHelperClasses(true);
                this.transformer.generateTransformContextDeclaration();
                
    stringBuffer.append(TEXT_205);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturnedType(this.outValueClass.toString()));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(this.sparkFunction.getCodeImplementedMethod());
    stringBuffer.append(TEXT_208);
    stringBuffer.append(this.sparkFunction.getCodeFunctionArgument(getInValueClass()));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(this.sparkFunction.getCodeThrowException());
    stringBuffer.append(TEXT_210);
    stringBuffer.append(this.sparkFunction.getMethodHeader(this.outValueClass, this.outValue, this.inValueClass, this.inValue));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(this.sparkFunction.getCodeKeyMapping(getInValue()));
    stringBuffer.append(TEXT_212);
    
	                this.transformer.generateTransformContextInitialization();
	                this.transformer.generateTransform(true);
	                
    stringBuffer.append(TEXT_213);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturn(this.getOutValue(), this.getOutValueClass()));
    stringBuffer.append(TEXT_214);
    
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
        
    stringBuffer.append(TEXT_215);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(this.sparkFunction.getCodeFunctionImplementationOutputFixedType(getInValueClass(), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_217);
    
                this.transformer.generateHelperClasses(true);
                this.transformer.generateTransformContextDeclaration();
                
    stringBuffer.append(TEXT_218);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturnedTypeFixedType((String)this.outKeyClass, "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(this.sparkFunction.getCodeImplementedMethod());
    stringBuffer.append(TEXT_221);
    stringBuffer.append(this.sparkFunction.getCodeFunctionArgument(getInValueClass()));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(this.sparkFunction.getCodeThrowException());
    stringBuffer.append(TEXT_223);
    stringBuffer.append(this.sparkFunction.getMethodHeader(this.outValueClass, this.outValue, this.inValueClass, this.inValue));
    
                    this.transformer.generateTransformContextInitialization();
                    this.transformer.generateTransform(true);
	                if(this.sparkFunction.getCodeFunctionReturn()!=null) {
                
    stringBuffer.append(TEXT_224);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturn());
    stringBuffer.append(TEXT_225);
    
	            	}
                
    stringBuffer.append(TEXT_226);
    
        }
    }

    stringBuffer.append(TEXT_227);
    

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
            
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    
            return;
        }


        // Refactoring FunctionGenerator to java so we have to instaniate a MO or SO here
        functionGenerator = new SOFunctionGenerator(transformer, sparkFunction);

        functionGenerator.init(node, cid, null, transformer.getInConnName(), null, 
                transformer.getOutConnMainName() != null
                    ? transformer.getOutConnMainName()
                            : transformer.getOutConnRejectName());

        functionGenerator.generate();


        String internalType = ((org.talend.designer.spark.streaming.generator.TopStreamingFunction)sparkFunction).getConfigInternalType(functionGenerator.getOutValueClass());
        
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(internalType);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(internalType);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(internalType);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(internalType);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(sparkFunction.getConfigTransformation());
    stringBuffer.append(TEXT_236);
    stringBuffer.append(sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_237);
    
    }

    public void generateSparkConfig(final org.talend.designer.common.TransformerBase transformer, final org.talend.designer.spark.generator.SparkFunction sparkFunction, String topX) {
        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    
            return;
        }

        functionGenerator = new SOFunctionGenerator(transformer, sparkFunction);

        functionGenerator.init(node, cid, null, transformer.getInConnName(), null, 
                transformer.getOutConnMainName() != null
                    ? transformer.getOutConnMainName()
                            : transformer.getOutConnRejectName());
            String returnedType = sparkFunction.getConfigReturnedType(functionGenerator.getOutValueClass());
            
    stringBuffer.append(TEXT_239);
    stringBuffer.append(returnedType);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_241);
    stringBuffer.append(transformer.getInConnName());
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(topX);
    stringBuffer.append(TEXT_244);
    
    }
}


    stringBuffer.append(TEXT_245);
    

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
        
    stringBuffer.append(TEXT_246);
    
        }else{
        
    stringBuffer.append(TEXT_247);
    
        }
    }
    private void genLesser(String columnName){
        if(criteriasOrderType.get(columnName)){
        
    stringBuffer.append(TEXT_248);
    
        }else{
        
    stringBuffer.append(TEXT_249);
    
        }
    }

    private void compareObjectColumn(IMetadataColumn column, int columnIterator){
        String columnNameToGenerate = "_1()._" + columnIterator + "()";
        boolean nullable = !JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
        String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
        String columnName = column.getLabel();
        if(nullable){
        
    stringBuffer.append(TEXT_250);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_252);
    lesser(columnName);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_255);
    greater(columnName);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_258);
    }
    
            if(typeToGenerate.equalsIgnoreCase("Boolean")){
            
    stringBuffer.append(TEXT_259);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_262);
    greater(columnName);
    stringBuffer.append(TEXT_263);
    lesser(columnName);
    stringBuffer.append(TEXT_264);
    
            }else if(typeToGenerate.equalsIgnoreCase("Byte")){
            
    stringBuffer.append(TEXT_265);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_267);
    greater(columnName);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_270);
    lesser(columnName);
    stringBuffer.append(TEXT_271);
    
            }else if(typeToGenerate.equals("byte[]")){
            
    stringBuffer.append(TEXT_272);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_280);
    greater(columnName);
    stringBuffer.append(TEXT_281);
    lesser(columnName);
    stringBuffer.append(TEXT_282);
    
            }else if(typeToGenerate.equalsIgnoreCase("Char") || typeToGenerate.equalsIgnoreCase("Character")){
            
    stringBuffer.append(TEXT_283);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_287);
    greater(columnName);
    stringBuffer.append(TEXT_288);
    lesser(columnName);
    stringBuffer.append(TEXT_289);
    
            }else if(typeToGenerate.equals("java.util.Date")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_290);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_296);
    greater(columnName);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_298);
    lesser(columnName);
    stringBuffer.append(TEXT_299);
    
                }else{
                
    stringBuffer.append(TEXT_300);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_304);
    greater(columnName);
    stringBuffer.append(TEXT_305);
    lesser(columnName);
    stringBuffer.append(TEXT_306);
    
                }
            }else if(typeToGenerate.equalsIgnoreCase("Double")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_307);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_311);
    greater(columnName);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_313);
    lesser(columnName);
    stringBuffer.append(TEXT_314);
    
                }else{
                
    stringBuffer.append(TEXT_315);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_317);
    greater(columnName);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_320);
    lesser(columnName);
    stringBuffer.append(TEXT_321);
    
                }
            }else if(typeToGenerate.equalsIgnoreCase("Float")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_322);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_326);
    greater(columnName);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_328);
    lesser(columnName);
    stringBuffer.append(TEXT_329);
    
                }else{
                
    stringBuffer.append(TEXT_330);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_332);
    greater(columnName);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_335);
    lesser(columnName);
    stringBuffer.append(TEXT_336);
    
                }
            }else if(typeToGenerate.equals("BigDecimal")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_337);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_340);
    
                }else{
                
    stringBuffer.append(TEXT_341);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_344);
    }
    stringBuffer.append(TEXT_345);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_346);
    greater(columnName);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_348);
    lesser(columnName);
    stringBuffer.append(TEXT_349);
    
            }else if(typeToGenerate.equalsIgnoreCase("Integer") || typeToGenerate.equalsIgnoreCase("int")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_350);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_354);
    greater(columnName);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_356);
    lesser(columnName);
    stringBuffer.append(TEXT_357);
    
                }else{
                
    stringBuffer.append(TEXT_358);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_360);
    greater(columnName);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_363);
    lesser(columnName);
    stringBuffer.append(TEXT_364);
    
                }
            }else if(typeToGenerate.equalsIgnoreCase("Long")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_365);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_369);
    greater(columnName);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_371);
    lesser(columnName);
    stringBuffer.append(TEXT_372);
    
            }else{
            
    stringBuffer.append(TEXT_373);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_375);
    greater(columnName);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_378);
    lesser(columnName);
    stringBuffer.append(TEXT_379);
    
            }
        }else if(typeToGenerate.equals("Object")){
        
    stringBuffer.append(TEXT_380);
    stringBuffer.append(columnNameToGenerate);
    
        }else if(typeToGenerate.equalsIgnoreCase("Short")){
        
    
            if(!sortTypes.get(columnName)){
            
    stringBuffer.append(TEXT_381);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_385);
    greater(columnName);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_387);
    lesser(columnName);
    stringBuffer.append(TEXT_388);
    
            }else{
            
    stringBuffer.append(TEXT_389);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_391);
    greater(columnName);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_394);
    lesser(columnName);
    stringBuffer.append(TEXT_395);
    
            }
        }else if(typeToGenerate.equals("String")){
        
    stringBuffer.append(TEXT_396);
    stringBuffer.append(columnIterator);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(columnIterator);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(columnIterator);
    stringBuffer.append(TEXT_401);
    greater(columnName);
    stringBuffer.append(TEXT_402);
    lesser(columnName);
    stringBuffer.append(TEXT_403);
    
        }else if(typeToGenerate.equals("List")){
        
    stringBuffer.append(TEXT_404);
    stringBuffer.append(columnNameToGenerate);
    
        }else if(typeToGenerate.equals("Doucument")){
        
    stringBuffer.append(TEXT_405);
    stringBuffer.append(columnNameToGenerate);
    
        }else if(typeToGenerate.equals("Dynamic")){
        
    stringBuffer.append(TEXT_406);
    stringBuffer.append(columnNameToGenerate);
    
        }
        
    if(nullable){
    stringBuffer.append(TEXT_407);
    
        }
    }


}

    stringBuffer.append(TEXT_408);
    
	final SparkRowTransformUtil sparkTransformUtil = new SparkRowTransformUtil();
	final TTopUtil tTopUtil = new TTopUtil(node, codeGenArgument, sparkTransformUtil);
	
	java.util.Map<String, java.util.List<org.talend.core.model.metadata.IMetadataColumn>> keyList = bigDataNode.getKeyList();
	org.talend.designer.spark.streaming.generator.TopStreamingFunction sparkFunction = new org.talend.designer.spark.streaming.generator.TopStreamingFunction(false, keyList);
	
	sparkTransformUtil.generateSparkCode(tTopUtil, sparkFunction);
}

    return stringBuffer.toString();
  }
}
