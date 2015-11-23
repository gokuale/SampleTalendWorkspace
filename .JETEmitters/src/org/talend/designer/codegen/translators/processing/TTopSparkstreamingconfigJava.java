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

public class TTopSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TTopSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTopSparkstreamingconfigJava result = new TTopSparkstreamingconfigJava();
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
  protected final String TEXT_34 = " =" + NL + "            ctx.sparkContext().parallelizePairs(" + NL + "                    rdd_";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = "(";
  protected final String TEXT_37 = "," + NL + "                        new ";
  protected final String TEXT_38 = "(job))," + NL + "                1); // One partition to keep the ordering.";
  protected final String TEXT_39 = NL + "\t";
  protected final String TEXT_40 = NL + "            return -1;";
  protected final String TEXT_41 = NL + "            return 1;";
  protected final String TEXT_42 = NL + "            return 1;";
  protected final String TEXT_43 = NL + "            return -1;";
  protected final String TEXT_44 = NL + "            if(data1.";
  protected final String TEXT_45 = " == null && data2.";
  protected final String TEXT_46 = " != null){";
  protected final String TEXT_47 = NL + "            }else if(data1.";
  protected final String TEXT_48 = " != null && data2.";
  protected final String TEXT_49 = " == null){";
  protected final String TEXT_50 = NL + "            }else if(data1.";
  protected final String TEXT_51 = " == null && data2.";
  protected final String TEXT_52 = " == null){" + NL + "                //ignore" + NL + "            }else{";
  protected final String TEXT_53 = NL + "                if(data1.";
  protected final String TEXT_54 = " != data2.";
  protected final String TEXT_55 = "){" + NL + "                    if(data1.";
  protected final String TEXT_56 = "){";
  protected final String TEXT_57 = NL + "                    }else{";
  protected final String TEXT_58 = NL + "                    }" + NL + "                }";
  protected final String TEXT_59 = NL + "                if(data1.";
  protected final String TEXT_60 = " > data2.";
  protected final String TEXT_61 = "){";
  protected final String TEXT_62 = NL + "                }else if(data1.";
  protected final String TEXT_63 = " < data2.";
  protected final String TEXT_64 = "){";
  protected final String TEXT_65 = NL + "                }";
  protected final String TEXT_66 = NL + "                String s1_";
  protected final String TEXT_67 = " = new String(data1.";
  protected final String TEXT_68 = ");" + NL + "                String s2_";
  protected final String TEXT_69 = " = new String(data2.";
  protected final String TEXT_70 = ");" + NL + "                if(!s1_";
  protected final String TEXT_71 = ".equals(s2_";
  protected final String TEXT_72 = ")){" + NL + "                    if(s1_";
  protected final String TEXT_73 = ".compareTo(s2_";
  protected final String TEXT_74 = ") > 0){";
  protected final String TEXT_75 = NL + "                    }else{";
  protected final String TEXT_76 = NL + "                    }" + NL + "                }";
  protected final String TEXT_77 = NL + "                if(data1.";
  protected final String TEXT_78 = " - data2.";
  protected final String TEXT_79 = " != 0){" + NL + "                    if(data1.";
  protected final String TEXT_80 = " - data2.";
  protected final String TEXT_81 = " > 0){";
  protected final String TEXT_82 = NL + "                    }else{";
  protected final String TEXT_83 = NL + "                    }" + NL + "                }";
  protected final String TEXT_84 = NL + "                    int cmp_";
  protected final String TEXT_85 = " = FormatterUtils.format_DateInUTC(data1.";
  protected final String TEXT_86 = ", ";
  protected final String TEXT_87 = ").compareTo(FormatterUtils.format_DateInUTC(data2.";
  protected final String TEXT_88 = ", ";
  protected final String TEXT_89 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_90 = " > 0){";
  protected final String TEXT_91 = NL + "                    }else if(cmp_";
  protected final String TEXT_92 = " < 0){";
  protected final String TEXT_93 = NL + "                    }";
  protected final String TEXT_94 = NL + "                    if(!data1.";
  protected final String TEXT_95 = ".equals(data2.";
  protected final String TEXT_96 = ")){" + NL + "                        if(data1.";
  protected final String TEXT_97 = ".compareTo(data2.";
  protected final String TEXT_98 = ") > 0){";
  protected final String TEXT_99 = NL + "                        }else{";
  protected final String TEXT_100 = NL + "                        }" + NL + "                    }";
  protected final String TEXT_101 = NL + "                    int cmp_";
  protected final String TEXT_102 = " = String.valueOf(data1.";
  protected final String TEXT_103 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_104 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_105 = " > 0){";
  protected final String TEXT_106 = NL + "                    }else if(cmp_";
  protected final String TEXT_107 = " < 0){";
  protected final String TEXT_108 = NL + "                    }";
  protected final String TEXT_109 = NL + "                    if(data1.";
  protected final String TEXT_110 = " > data2.";
  protected final String TEXT_111 = "){";
  protected final String TEXT_112 = NL + "                    }else if(data1.";
  protected final String TEXT_113 = " < data2.";
  protected final String TEXT_114 = "){";
  protected final String TEXT_115 = NL + "                    }";
  protected final String TEXT_116 = NL + "                    int cmp_";
  protected final String TEXT_117 = " = String.valueOf(data1.";
  protected final String TEXT_118 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_119 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_120 = " > 0){";
  protected final String TEXT_121 = NL + "                    }else if(cmp_";
  protected final String TEXT_122 = " < 0){";
  protected final String TEXT_123 = NL + "                    }";
  protected final String TEXT_124 = NL + "                    if(data1.";
  protected final String TEXT_125 = " > data2.";
  protected final String TEXT_126 = "){";
  protected final String TEXT_127 = NL + "                    }else if(data1.";
  protected final String TEXT_128 = " < data2.";
  protected final String TEXT_129 = "){";
  protected final String TEXT_130 = NL + "                    }";
  protected final String TEXT_131 = NL + "                    int cmp_";
  protected final String TEXT_132 = " = String.valueOf(data1.";
  protected final String TEXT_133 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_134 = "));";
  protected final String TEXT_135 = NL + "                    int cmp_";
  protected final String TEXT_136 = " = data1.";
  protected final String TEXT_137 = ".compareTo(data2.";
  protected final String TEXT_138 = ");";
  protected final String TEXT_139 = NL + "                if(cmp_";
  protected final String TEXT_140 = " > 0){";
  protected final String TEXT_141 = NL + "                }else if(cmp_";
  protected final String TEXT_142 = " < 0){";
  protected final String TEXT_143 = NL + "                }";
  protected final String TEXT_144 = NL + "                    int cmp_";
  protected final String TEXT_145 = " = String.valueOf(data1.";
  protected final String TEXT_146 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_147 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_148 = " > 0){";
  protected final String TEXT_149 = NL + "                    }else if(cmp_";
  protected final String TEXT_150 = " < 0){";
  protected final String TEXT_151 = NL + "                    }";
  protected final String TEXT_152 = NL + "                    if(data1.";
  protected final String TEXT_153 = " > data2.";
  protected final String TEXT_154 = "){";
  protected final String TEXT_155 = NL + "                    }else if(data1.";
  protected final String TEXT_156 = " < data2.";
  protected final String TEXT_157 = "){";
  protected final String TEXT_158 = NL + "                    }";
  protected final String TEXT_159 = NL + "                    int cmp_";
  protected final String TEXT_160 = " = String.valueOf(data1.";
  protected final String TEXT_161 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_162 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_163 = " > 0){";
  protected final String TEXT_164 = NL + "                    }else if(cmp_";
  protected final String TEXT_165 = " < 0){";
  protected final String TEXT_166 = NL + "                }";
  protected final String TEXT_167 = NL + "                if(data1.";
  protected final String TEXT_168 = " > data2.";
  protected final String TEXT_169 = "){";
  protected final String TEXT_170 = NL + "                }else if(data1.";
  protected final String TEXT_171 = " < data2.";
  protected final String TEXT_172 = "){";
  protected final String TEXT_173 = NL + "                }";
  protected final String TEXT_174 = NL + "            Don't support Object type: column--";
  protected final String TEXT_175 = NL + "                int cmp_";
  protected final String TEXT_176 = " = String.valueOf(data1.";
  protected final String TEXT_177 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_178 = "));" + NL + "                if(cmp_";
  protected final String TEXT_179 = " > 0){";
  protected final String TEXT_180 = NL + "                }else if(cmp_";
  protected final String TEXT_181 = " < 0){";
  protected final String TEXT_182 = NL + "                }";
  protected final String TEXT_183 = NL + "                if(data1.";
  protected final String TEXT_184 = " > data2.";
  protected final String TEXT_185 = "){";
  protected final String TEXT_186 = NL + "                }else if(data1.";
  protected final String TEXT_187 = " < data2.";
  protected final String TEXT_188 = "){";
  protected final String TEXT_189 = NL + "                }";
  protected final String TEXT_190 = NL + "            int comp_";
  protected final String TEXT_191 = " = data1.";
  protected final String TEXT_192 = ".compareTo(data2.";
  protected final String TEXT_193 = ");" + NL + "            if(comp_";
  protected final String TEXT_194 = " != 0){" + NL + "                if(comp_";
  protected final String TEXT_195 = " > 0){";
  protected final String TEXT_196 = NL + "                }else{";
  protected final String TEXT_197 = NL + "                }" + NL + "" + NL + "            }";
  protected final String TEXT_198 = NL + "            Don't support List type: column--";
  protected final String TEXT_199 = NL + "            Don't support Document type: column--";
  protected final String TEXT_200 = NL + "            Don't support Dynamic type: column--";
  protected final String TEXT_201 = NL + "            }";
  protected final String TEXT_202 = NL + "\t";
  protected final String TEXT_203 = NL + "            public static class ";
  protected final String TEXT_204 = " implements ";
  protected final String TEXT_205 = " {";
  protected final String TEXT_206 = NL + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_207 = "(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "\t            public ";
  protected final String TEXT_208 = " ";
  protected final String TEXT_209 = "(";
  protected final String TEXT_210 = ") ";
  protected final String TEXT_211 = " {" + NL + "\t            \t";
  protected final String TEXT_212 = NL + "\t            \t";
  protected final String TEXT_213 = NL + "\t                ";
  protected final String TEXT_214 = NL + "\t                return ";
  protected final String TEXT_215 = ";" + NL + "\t            }" + NL + "\t        }" + NL + "\t\t";
  protected final String TEXT_216 = NL + "            public static class ";
  protected final String TEXT_217 = " implements ";
  protected final String TEXT_218 = " {";
  protected final String TEXT_219 = NL + NL + "                private ContextProperties context = null;" + NL + "" + NL + "                public ";
  protected final String TEXT_220 = "(JobConf job) {" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_221 = " ";
  protected final String TEXT_222 = "(";
  protected final String TEXT_223 = ") ";
  protected final String TEXT_224 = " {" + NL + "                \t";
  protected final String TEXT_225 = NL + "\t                 \treturn ";
  protected final String TEXT_226 = ";";
  protected final String TEXT_227 = NL + "                }" + NL + "            }";
  protected final String TEXT_228 = NL;
  protected final String TEXT_229 = NL + "            // No sparkcode generated for unnecessary ";
  protected final String TEXT_230 = NL + "        public static class StreamingTop_";
  protected final String TEXT_231 = " implements org.apache.spark.api.java.function.Function<";
  protected final String TEXT_232 = ", ";
  protected final String TEXT_233 = "> {" + NL + "            transient private org.apache.spark.api.java.JavaSparkContext ctx = null;" + NL + "            private Integer top = 5;" + NL + "" + NL + "            public StreamingTop_";
  protected final String TEXT_234 = "(Integer top) {" + NL + "                this.top = top;" + NL + "            }" + NL + "" + NL + "            public ";
  protected final String TEXT_235 = " call(";
  protected final String TEXT_236 = " temporaryRdd)" + NL + "                    throws Exception {" + NL + "                if (ctx == null) {" + NL + "                    ctx = new org.apache.spark.api.java.JavaSparkContext(temporaryRdd.context());" + NL + "                }" + NL + "                return ctx.parallelizePairs(" + NL + "                        temporaryRdd.";
  protected final String TEXT_237 = "(top," + NL + "                                new ";
  protected final String TEXT_238 = "(new JobConf())));" + NL + "            }" + NL + "        }";
  protected final String TEXT_239 = NL + "            // No sparkconfig generated for unnecessary ";
  protected final String TEXT_240 = NL + "            ";
  protected final String TEXT_241 = " rdd_";
  protected final String TEXT_242 = " =" + NL + "                    rdd_";
  protected final String TEXT_243 = ".transformToPair(new StreamingTop_";
  protected final String TEXT_244 = "(";
  protected final String TEXT_245 = "));";
  protected final String TEXT_246 = NL + "\t";
  protected final String TEXT_247 = NL + "            return -1;";
  protected final String TEXT_248 = NL + "            return 1;";
  protected final String TEXT_249 = NL + "            return 1;";
  protected final String TEXT_250 = NL + "            return -1;";
  protected final String TEXT_251 = NL + "            if(data1.";
  protected final String TEXT_252 = " == null && data2.";
  protected final String TEXT_253 = " != null){";
  protected final String TEXT_254 = NL + "            }else if(data1.";
  protected final String TEXT_255 = " != null && data2.";
  protected final String TEXT_256 = " == null){";
  protected final String TEXT_257 = NL + "            }else if(data1.";
  protected final String TEXT_258 = " == null && data2.";
  protected final String TEXT_259 = " == null){" + NL + "                //ignore" + NL + "            }else{";
  protected final String TEXT_260 = NL + "                if(data1.";
  protected final String TEXT_261 = " != data2.";
  protected final String TEXT_262 = "){" + NL + "                    if(data1.";
  protected final String TEXT_263 = "){";
  protected final String TEXT_264 = NL + "                    }else{";
  protected final String TEXT_265 = NL + "                    }" + NL + "                }";
  protected final String TEXT_266 = NL + "                if(data1.";
  protected final String TEXT_267 = " > data2.";
  protected final String TEXT_268 = "){";
  protected final String TEXT_269 = NL + "                }else if(data1.";
  protected final String TEXT_270 = " < data2.";
  protected final String TEXT_271 = "){";
  protected final String TEXT_272 = NL + "                }";
  protected final String TEXT_273 = NL + "                String s1_";
  protected final String TEXT_274 = " = new String(data1.";
  protected final String TEXT_275 = ");" + NL + "                String s2_";
  protected final String TEXT_276 = " = new String(data2.";
  protected final String TEXT_277 = ");" + NL + "                if(!s1_";
  protected final String TEXT_278 = ".equals(s2_";
  protected final String TEXT_279 = ")){" + NL + "                    if(s1_";
  protected final String TEXT_280 = ".compareTo(s2_";
  protected final String TEXT_281 = ") > 0){";
  protected final String TEXT_282 = NL + "                    }else{";
  protected final String TEXT_283 = NL + "                    }" + NL + "                }";
  protected final String TEXT_284 = NL + "                if(data1.";
  protected final String TEXT_285 = " - data2.";
  protected final String TEXT_286 = " != 0){" + NL + "                    if(data1.";
  protected final String TEXT_287 = " - data2.";
  protected final String TEXT_288 = " > 0){";
  protected final String TEXT_289 = NL + "                    }else{";
  protected final String TEXT_290 = NL + "                    }" + NL + "                }";
  protected final String TEXT_291 = NL + "                    int cmp_";
  protected final String TEXT_292 = " = FormatterUtils.format_DateInUTC(data1.";
  protected final String TEXT_293 = ", ";
  protected final String TEXT_294 = ").compareTo(FormatterUtils.format_DateInUTC(data2.";
  protected final String TEXT_295 = ", ";
  protected final String TEXT_296 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_297 = " > 0){";
  protected final String TEXT_298 = NL + "                    }else if(cmp_";
  protected final String TEXT_299 = " < 0){";
  protected final String TEXT_300 = NL + "                    }";
  protected final String TEXT_301 = NL + "                    if(!data1.";
  protected final String TEXT_302 = ".equals(data2.";
  protected final String TEXT_303 = ")){" + NL + "                        if(data1.";
  protected final String TEXT_304 = ".compareTo(data2.";
  protected final String TEXT_305 = ") > 0){";
  protected final String TEXT_306 = NL + "                        }else{";
  protected final String TEXT_307 = NL + "                        }" + NL + "                    }";
  protected final String TEXT_308 = NL + "                    int cmp_";
  protected final String TEXT_309 = " = String.valueOf(data1.";
  protected final String TEXT_310 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_311 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_312 = " > 0){";
  protected final String TEXT_313 = NL + "                    }else if(cmp_";
  protected final String TEXT_314 = " < 0){";
  protected final String TEXT_315 = NL + "                    }";
  protected final String TEXT_316 = NL + "                    if(data1.";
  protected final String TEXT_317 = " > data2.";
  protected final String TEXT_318 = "){";
  protected final String TEXT_319 = NL + "                    }else if(data1.";
  protected final String TEXT_320 = " < data2.";
  protected final String TEXT_321 = "){";
  protected final String TEXT_322 = NL + "                    }";
  protected final String TEXT_323 = NL + "                    int cmp_";
  protected final String TEXT_324 = " = String.valueOf(data1.";
  protected final String TEXT_325 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_326 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_327 = " > 0){";
  protected final String TEXT_328 = NL + "                    }else if(cmp_";
  protected final String TEXT_329 = " < 0){";
  protected final String TEXT_330 = NL + "                    }";
  protected final String TEXT_331 = NL + "                    if(data1.";
  protected final String TEXT_332 = " > data2.";
  protected final String TEXT_333 = "){";
  protected final String TEXT_334 = NL + "                    }else if(data1.";
  protected final String TEXT_335 = " < data2.";
  protected final String TEXT_336 = "){";
  protected final String TEXT_337 = NL + "                    }";
  protected final String TEXT_338 = NL + "                    int cmp_";
  protected final String TEXT_339 = " = String.valueOf(data1.";
  protected final String TEXT_340 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_341 = "));";
  protected final String TEXT_342 = NL + "                    int cmp_";
  protected final String TEXT_343 = " = data1.";
  protected final String TEXT_344 = ".compareTo(data2.";
  protected final String TEXT_345 = ");";
  protected final String TEXT_346 = NL + "                if(cmp_";
  protected final String TEXT_347 = " > 0){";
  protected final String TEXT_348 = NL + "                }else if(cmp_";
  protected final String TEXT_349 = " < 0){";
  protected final String TEXT_350 = NL + "                }";
  protected final String TEXT_351 = NL + "                    int cmp_";
  protected final String TEXT_352 = " = String.valueOf(data1.";
  protected final String TEXT_353 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_354 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_355 = " > 0){";
  protected final String TEXT_356 = NL + "                    }else if(cmp_";
  protected final String TEXT_357 = " < 0){";
  protected final String TEXT_358 = NL + "                    }";
  protected final String TEXT_359 = NL + "                    if(data1.";
  protected final String TEXT_360 = " > data2.";
  protected final String TEXT_361 = "){";
  protected final String TEXT_362 = NL + "                    }else if(data1.";
  protected final String TEXT_363 = " < data2.";
  protected final String TEXT_364 = "){";
  protected final String TEXT_365 = NL + "                    }";
  protected final String TEXT_366 = NL + "                    int cmp_";
  protected final String TEXT_367 = " = String.valueOf(data1.";
  protected final String TEXT_368 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_369 = "));" + NL + "                    if(cmp_";
  protected final String TEXT_370 = " > 0){";
  protected final String TEXT_371 = NL + "                    }else if(cmp_";
  protected final String TEXT_372 = " < 0){";
  protected final String TEXT_373 = NL + "                }";
  protected final String TEXT_374 = NL + "                if(data1.";
  protected final String TEXT_375 = " > data2.";
  protected final String TEXT_376 = "){";
  protected final String TEXT_377 = NL + "                }else if(data1.";
  protected final String TEXT_378 = " < data2.";
  protected final String TEXT_379 = "){";
  protected final String TEXT_380 = NL + "                }";
  protected final String TEXT_381 = NL + "            Don't support Object type: column--";
  protected final String TEXT_382 = NL + "                int cmp_";
  protected final String TEXT_383 = " = String.valueOf(data1.";
  protected final String TEXT_384 = ").compareTo(String.valueOf(data2.";
  protected final String TEXT_385 = "));" + NL + "                if(cmp_";
  protected final String TEXT_386 = " > 0){";
  protected final String TEXT_387 = NL + "                }else if(cmp_";
  protected final String TEXT_388 = " < 0){";
  protected final String TEXT_389 = NL + "                }";
  protected final String TEXT_390 = NL + "                if(data1.";
  protected final String TEXT_391 = " > data2.";
  protected final String TEXT_392 = "){";
  protected final String TEXT_393 = NL + "                }else if(data1.";
  protected final String TEXT_394 = " < data2.";
  protected final String TEXT_395 = "){";
  protected final String TEXT_396 = NL + "                }";
  protected final String TEXT_397 = NL + "            int comp_";
  protected final String TEXT_398 = " = data1.";
  protected final String TEXT_399 = ".compareTo(data2.";
  protected final String TEXT_400 = ");" + NL + "            if(comp_";
  protected final String TEXT_401 = " != 0){" + NL + "                if(comp_";
  protected final String TEXT_402 = " > 0){";
  protected final String TEXT_403 = NL + "                }else{";
  protected final String TEXT_404 = NL + "                }" + NL + "" + NL + "            }";
  protected final String TEXT_405 = NL + "            Don't support List type: column--";
  protected final String TEXT_406 = NL + "            Don't support Document type: column--";
  protected final String TEXT_407 = NL + "            Don't support Dynamic type: column--";
  protected final String TEXT_408 = NL + "            }";
  protected final String TEXT_409 = NL;
  protected final String TEXT_410 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final IBigDataNode bigDataNode = (IBigDataNode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();
	
if(org.talend.designer.common.tmap.LookupUtil.isNodeInBatchMode((INode) ((BigDataCodeGeneratorArgument) argument).getArgument())) {

    stringBuffer.append(TEXT_1);
    
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


    stringBuffer.append(TEXT_39);
    

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
        
    stringBuffer.append(TEXT_40);
    
        }else{
        
    stringBuffer.append(TEXT_41);
    
        }
    }
    private void genLesser(String columnName){
        if(criteriasOrderType.get(columnName)){
        
    stringBuffer.append(TEXT_42);
    
        }else{
        
    stringBuffer.append(TEXT_43);
    
        }
    }

    private void compareObjectColumn(IMetadataColumn column, int columnIterator){
        String columnNameToGenerate = "_1()._" + columnIterator + "()";
        boolean nullable = !JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
        String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
        String columnName = column.getLabel();
        if(nullable){
        
    stringBuffer.append(TEXT_44);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_46);
    lesser(columnName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_49);
    greater(columnName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_52);
    }
    
            if(typeToGenerate.equalsIgnoreCase("Boolean")){
            
    stringBuffer.append(TEXT_53);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_56);
    greater(columnName);
    stringBuffer.append(TEXT_57);
    lesser(columnName);
    stringBuffer.append(TEXT_58);
    
            }else if(typeToGenerate.equalsIgnoreCase("Byte")){
            
    stringBuffer.append(TEXT_59);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_61);
    greater(columnName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_64);
    lesser(columnName);
    stringBuffer.append(TEXT_65);
    
            }else if(typeToGenerate.equals("byte[]")){
            
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
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_74);
    greater(columnName);
    stringBuffer.append(TEXT_75);
    lesser(columnName);
    stringBuffer.append(TEXT_76);
    
            }else if(typeToGenerate.equalsIgnoreCase("Char") || typeToGenerate.equalsIgnoreCase("Character")){
            
    stringBuffer.append(TEXT_77);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_81);
    greater(columnName);
    stringBuffer.append(TEXT_82);
    lesser(columnName);
    stringBuffer.append(TEXT_83);
    
            }else if(typeToGenerate.equals("java.util.Date")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_84);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_90);
    greater(columnName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_92);
    lesser(columnName);
    stringBuffer.append(TEXT_93);
    
                }else{
                
    stringBuffer.append(TEXT_94);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_98);
    greater(columnName);
    stringBuffer.append(TEXT_99);
    lesser(columnName);
    stringBuffer.append(TEXT_100);
    
                }
            }else if(typeToGenerate.equalsIgnoreCase("Double")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_101);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_105);
    greater(columnName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_107);
    lesser(columnName);
    stringBuffer.append(TEXT_108);
    
                }else{
                
    stringBuffer.append(TEXT_109);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_111);
    greater(columnName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_114);
    lesser(columnName);
    stringBuffer.append(TEXT_115);
    
                }
            }else if(typeToGenerate.equalsIgnoreCase("Float")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_116);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_120);
    greater(columnName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_122);
    lesser(columnName);
    stringBuffer.append(TEXT_123);
    
                }else{
                
    stringBuffer.append(TEXT_124);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_126);
    greater(columnName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_129);
    lesser(columnName);
    stringBuffer.append(TEXT_130);
    
                }
            }else if(typeToGenerate.equals("BigDecimal")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_131);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_134);
    
                }else{
                
    stringBuffer.append(TEXT_135);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_138);
    }
    stringBuffer.append(TEXT_139);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_140);
    greater(columnName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_142);
    lesser(columnName);
    stringBuffer.append(TEXT_143);
    
            }else if(typeToGenerate.equalsIgnoreCase("Integer") || typeToGenerate.equalsIgnoreCase("int")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_144);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_148);
    greater(columnName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_150);
    lesser(columnName);
    stringBuffer.append(TEXT_151);
    
                }else{
                
    stringBuffer.append(TEXT_152);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_154);
    greater(columnName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_157);
    lesser(columnName);
    stringBuffer.append(TEXT_158);
    
                }
            }else if(typeToGenerate.equalsIgnoreCase("Long")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_159);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_163);
    greater(columnName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_165);
    lesser(columnName);
    stringBuffer.append(TEXT_166);
    
            }else{
            
    stringBuffer.append(TEXT_167);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_169);
    greater(columnName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_172);
    lesser(columnName);
    stringBuffer.append(TEXT_173);
    
            }
        }else if(typeToGenerate.equals("Object")){
        
    stringBuffer.append(TEXT_174);
    stringBuffer.append(columnNameToGenerate);
    
        }else if(typeToGenerate.equalsIgnoreCase("Short")){
        
    
            if(!sortTypes.get(columnName)){
            
    stringBuffer.append(TEXT_175);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_179);
    greater(columnName);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_181);
    lesser(columnName);
    stringBuffer.append(TEXT_182);
    
            }else{
            
    stringBuffer.append(TEXT_183);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_185);
    greater(columnName);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_188);
    lesser(columnName);
    stringBuffer.append(TEXT_189);
    
            }
        }else if(typeToGenerate.equals("String")){
        
    stringBuffer.append(TEXT_190);
    stringBuffer.append(columnIterator);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(columnIterator);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(columnIterator);
    stringBuffer.append(TEXT_195);
    greater(columnName);
    stringBuffer.append(TEXT_196);
    lesser(columnName);
    stringBuffer.append(TEXT_197);
    
        }else if(typeToGenerate.equals("List")){
        
    stringBuffer.append(TEXT_198);
    stringBuffer.append(columnNameToGenerate);
    
        }else if(typeToGenerate.equals("Doucument")){
        
    stringBuffer.append(TEXT_199);
    stringBuffer.append(columnNameToGenerate);
    
        }else if(typeToGenerate.equals("Dynamic")){
        
    stringBuffer.append(TEXT_200);
    stringBuffer.append(columnNameToGenerate);
    
        }
        
    if(nullable){
    stringBuffer.append(TEXT_201);
    
        }
    }


}

    
	final SparkRowTransformUtil sparkTransformUtil = new SparkRowTransformUtil();
	final TTopUtil tTopUtil = new TTopUtil(node, codeGenArgument, sparkTransformUtil);
	
	java.util.Map<String, java.util.List<org.talend.core.model.metadata.IMetadataColumn>> keyList = bigDataNode.getKeyList();
	org.talend.designer.spark.generator.SparkFunction sparkFunction = new org.talend.designer.spark.generator.TopFunction(false, keyList);
	
	String topX = ElementParameterParser.getValue(node, "__TOP__");
	
	sparkTransformUtil.generateSparkConfig(tTopUtil, sparkFunction, topX);
} else {

    stringBuffer.append(TEXT_202);
    
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
		
    stringBuffer.append(TEXT_203);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(this.sparkFunction.getCodeFunctionImplementation(getOutValueClass(), getInValueClass()));
    stringBuffer.append(TEXT_205);
    
                this.transformer.generateHelperClasses(true);
                this.transformer.generateTransformContextDeclaration();
                
    stringBuffer.append(TEXT_206);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturnedType(this.outValueClass.toString()));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(this.sparkFunction.getCodeImplementedMethod());
    stringBuffer.append(TEXT_209);
    stringBuffer.append(this.sparkFunction.getCodeFunctionArgument(getInValueClass()));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(this.sparkFunction.getCodeThrowException());
    stringBuffer.append(TEXT_211);
    stringBuffer.append(this.sparkFunction.getMethodHeader(this.outValueClass, this.outValue, this.inValueClass, this.inValue));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(this.sparkFunction.getCodeKeyMapping(getInValue()));
    stringBuffer.append(TEXT_213);
    
	                this.transformer.generateTransformContextInitialization();
	                this.transformer.generateTransform(true);
	                
    stringBuffer.append(TEXT_214);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturn(this.getOutValue(), this.getOutValueClass()));
    stringBuffer.append(TEXT_215);
    
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
        
    stringBuffer.append(TEXT_216);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(this.sparkFunction.getCodeFunctionImplementationOutputFixedType(getInValueClass(), "Boolean", "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_218);
    
                this.transformer.generateHelperClasses(true);
                this.transformer.generateTransformContextDeclaration();
                
    stringBuffer.append(TEXT_219);
    stringBuffer.append(this.sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturnedTypeFixedType((String)this.outKeyClass, "org.apache.avro.specific.SpecificRecordBase"));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(this.sparkFunction.getCodeImplementedMethod());
    stringBuffer.append(TEXT_222);
    stringBuffer.append(this.sparkFunction.getCodeFunctionArgument(getInValueClass()));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(this.sparkFunction.getCodeThrowException());
    stringBuffer.append(TEXT_224);
    stringBuffer.append(this.sparkFunction.getMethodHeader(this.outValueClass, this.outValue, this.inValueClass, this.inValue));
    
                    this.transformer.generateTransformContextInitialization();
                    this.transformer.generateTransform(true);
	                if(this.sparkFunction.getCodeFunctionReturn()!=null) {
                
    stringBuffer.append(TEXT_225);
    stringBuffer.append(this.sparkFunction.getCodeFunctionReturn());
    stringBuffer.append(TEXT_226);
    
	            	}
                
    stringBuffer.append(TEXT_227);
    
        }
    }

    stringBuffer.append(TEXT_228);
    

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
            
    stringBuffer.append(TEXT_229);
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
        
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(internalType);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(internalType);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(internalType);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(internalType);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(sparkFunction.getConfigTransformation());
    stringBuffer.append(TEXT_237);
    stringBuffer.append(sparkFunction.getClassName(cid));
    stringBuffer.append(TEXT_238);
    
    }

    public void generateSparkConfig(final org.talend.designer.common.TransformerBase transformer, final org.talend.designer.spark.generator.SparkFunction sparkFunction, String topX) {
        if (transformer.isUnnecessary()) {
            
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    
            return;
        }

        functionGenerator = new SOFunctionGenerator(transformer, sparkFunction);

        functionGenerator.init(node, cid, null, transformer.getInConnName(), null, 
                transformer.getOutConnMainName() != null
                    ? transformer.getOutConnMainName()
                            : transformer.getOutConnRejectName());
            String returnedType = sparkFunction.getConfigReturnedType(functionGenerator.getOutValueClass());
            
    stringBuffer.append(TEXT_240);
    stringBuffer.append(returnedType);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(transformer.getOutConnMainName());
    stringBuffer.append(TEXT_242);
    stringBuffer.append(transformer.getInConnName());
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(topX);
    stringBuffer.append(TEXT_245);
    
    }
}


    stringBuffer.append(TEXT_246);
    

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
        
    stringBuffer.append(TEXT_247);
    
        }else{
        
    stringBuffer.append(TEXT_248);
    
        }
    }
    private void genLesser(String columnName){
        if(criteriasOrderType.get(columnName)){
        
    stringBuffer.append(TEXT_249);
    
        }else{
        
    stringBuffer.append(TEXT_250);
    
        }
    }

    private void compareObjectColumn(IMetadataColumn column, int columnIterator){
        String columnNameToGenerate = "_1()._" + columnIterator + "()";
        boolean nullable = !JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
        String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
        String columnName = column.getLabel();
        if(nullable){
        
    stringBuffer.append(TEXT_251);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_253);
    lesser(columnName);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_256);
    greater(columnName);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_259);
    }
    
            if(typeToGenerate.equalsIgnoreCase("Boolean")){
            
    stringBuffer.append(TEXT_260);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_263);
    greater(columnName);
    stringBuffer.append(TEXT_264);
    lesser(columnName);
    stringBuffer.append(TEXT_265);
    
            }else if(typeToGenerate.equalsIgnoreCase("Byte")){
            
    stringBuffer.append(TEXT_266);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_268);
    greater(columnName);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_271);
    lesser(columnName);
    stringBuffer.append(TEXT_272);
    
            }else if(typeToGenerate.equals("byte[]")){
            
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
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_281);
    greater(columnName);
    stringBuffer.append(TEXT_282);
    lesser(columnName);
    stringBuffer.append(TEXT_283);
    
            }else if(typeToGenerate.equalsIgnoreCase("Char") || typeToGenerate.equalsIgnoreCase("Character")){
            
    stringBuffer.append(TEXT_284);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_288);
    greater(columnName);
    stringBuffer.append(TEXT_289);
    lesser(columnName);
    stringBuffer.append(TEXT_290);
    
            }else if(typeToGenerate.equals("java.util.Date")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_291);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_297);
    greater(columnName);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_299);
    lesser(columnName);
    stringBuffer.append(TEXT_300);
    
                }else{
                
    stringBuffer.append(TEXT_301);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_305);
    greater(columnName);
    stringBuffer.append(TEXT_306);
    lesser(columnName);
    stringBuffer.append(TEXT_307);
    
                }
            }else if(typeToGenerate.equalsIgnoreCase("Double")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_308);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_312);
    greater(columnName);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_314);
    lesser(columnName);
    stringBuffer.append(TEXT_315);
    
                }else{
                
    stringBuffer.append(TEXT_316);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_318);
    greater(columnName);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_321);
    lesser(columnName);
    stringBuffer.append(TEXT_322);
    
                }
            }else if(typeToGenerate.equalsIgnoreCase("Float")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_323);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_327);
    greater(columnName);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_329);
    lesser(columnName);
    stringBuffer.append(TEXT_330);
    
                }else{
                
    stringBuffer.append(TEXT_331);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_333);
    greater(columnName);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_336);
    lesser(columnName);
    stringBuffer.append(TEXT_337);
    
                }
            }else if(typeToGenerate.equals("BigDecimal")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_338);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_341);
    
                }else{
                
    stringBuffer.append(TEXT_342);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_345);
    }
    stringBuffer.append(TEXT_346);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_347);
    greater(columnName);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_349);
    lesser(columnName);
    stringBuffer.append(TEXT_350);
    
            }else if(typeToGenerate.equalsIgnoreCase("Integer") || typeToGenerate.equalsIgnoreCase("int")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_351);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_355);
    greater(columnName);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_357);
    lesser(columnName);
    stringBuffer.append(TEXT_358);
    
                }else{
                
    stringBuffer.append(TEXT_359);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_361);
    greater(columnName);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_364);
    lesser(columnName);
    stringBuffer.append(TEXT_365);
    
                }
            }else if(typeToGenerate.equalsIgnoreCase("Long")){
            
    
                if(!sortTypes.get(columnName)){
                
    stringBuffer.append(TEXT_366);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_370);
    greater(columnName);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_372);
    lesser(columnName);
    stringBuffer.append(TEXT_373);
    
            }else{
            
    stringBuffer.append(TEXT_374);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_376);
    greater(columnName);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_379);
    lesser(columnName);
    stringBuffer.append(TEXT_380);
    
            }
        }else if(typeToGenerate.equals("Object")){
        
    stringBuffer.append(TEXT_381);
    stringBuffer.append(columnNameToGenerate);
    
        }else if(typeToGenerate.equalsIgnoreCase("Short")){
        
    
            if(!sortTypes.get(columnName)){
            
    stringBuffer.append(TEXT_382);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_386);
    greater(columnName);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_388);
    lesser(columnName);
    stringBuffer.append(TEXT_389);
    
            }else{
            
    stringBuffer.append(TEXT_390);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_392);
    greater(columnName);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_395);
    lesser(columnName);
    stringBuffer.append(TEXT_396);
    
            }
        }else if(typeToGenerate.equals("String")){
        
    stringBuffer.append(TEXT_397);
    stringBuffer.append(columnIterator);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(columnNameToGenerate);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(columnIterator);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(columnIterator);
    stringBuffer.append(TEXT_402);
    greater(columnName);
    stringBuffer.append(TEXT_403);
    lesser(columnName);
    stringBuffer.append(TEXT_404);
    
        }else if(typeToGenerate.equals("List")){
        
    stringBuffer.append(TEXT_405);
    stringBuffer.append(columnNameToGenerate);
    
        }else if(typeToGenerate.equals("Doucument")){
        
    stringBuffer.append(TEXT_406);
    stringBuffer.append(columnNameToGenerate);
    
        }else if(typeToGenerate.equals("Dynamic")){
        
    stringBuffer.append(TEXT_407);
    stringBuffer.append(columnNameToGenerate);
    
        }
        
    if(nullable){
    stringBuffer.append(TEXT_408);
    
        }
    }


}

    
	final SparkRowTransformUtil sparkTransformUtil = new SparkRowTransformUtil();
	final TTopUtil tTopUtil = new TTopUtil(node, codeGenArgument, sparkTransformUtil);
	
	java.util.Map<String, java.util.List<org.talend.core.model.metadata.IMetadataColumn>> keyList = bigDataNode.getKeyList();
	org.talend.designer.spark.generator.SparkFunction sparkFunction = new org.talend.designer.spark.streaming.generator.TopStreamingFunction(false, keyList);
	
	String topX = ElementParameterParser.getValue(node, "__TOP__");
	
	sparkTransformUtil.generateSparkConfig(tTopUtil, sparkFunction, topX);
}

    stringBuffer.append(TEXT_409);
    stringBuffer.append(TEXT_410);
    return stringBuffer.toString();
  }
}
