package org.talend.designer.codegen.translators.databases.cassandra;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;

public class TCassandraInputBeginJava
{
  protected static String nl;
  public static synchronized TCassandraInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCassandraInputBeginJava result = new TCassandraInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t";
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = NL + "    \t";
  protected final String TEXT_33 = NL + "\t";
  protected final String TEXT_34 = NL + "\t";
  protected final String TEXT_35 = NL + "        com.datastax.driver.core.Cluster cluster_";
  protected final String TEXT_36 = " = (com.datastax.driver.core.Cluster)globalMap.get(\"cluster_";
  protected final String TEXT_37 = "\");" + NL + "    \tcom.datastax.driver.core.Session connection_";
  protected final String TEXT_38 = " = (com.datastax.driver.core.Session)globalMap.get(\"connection_";
  protected final String TEXT_39 = "\");" + NL + "\t";
  protected final String TEXT_40 = NL + "\t\t";
  protected final String TEXT_41 = NL + "\t";
  protected final String TEXT_42 = NL + "    com.datastax.driver.core.Cluster cluster_";
  protected final String TEXT_43 = " = com.datastax.driver.core.Cluster.builder()" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.addContactPoints(";
  protected final String TEXT_44 = ".split(\",\"))" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.withPort(Integer.valueOf(";
  protected final String TEXT_45 = "))" + NL + "                                                            \t";
  protected final String TEXT_46 = NL + "                                                                \t.withCredentials(";
  protected final String TEXT_47 = ", ";
  protected final String TEXT_48 = ")" + NL + "                                                            \t";
  protected final String TEXT_49 = NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.build();" + NL + "\t" + NL + "\tcom.datastax.driver.core.Session connection_";
  protected final String TEXT_50 = " = null;" + NL + "\tconnection_";
  protected final String TEXT_51 = " = cluster_";
  protected final String TEXT_52 = ".connect();" + NL + "\t";
  protected final String TEXT_53 = NL + "\tcom.datastax.driver.core.ResultSet rs_";
  protected final String TEXT_54 = " = connection_";
  protected final String TEXT_55 = ".execute(";
  protected final String TEXT_56 = ");" + NL + "\tint nb_line_";
  protected final String TEXT_57 = " = 0;" + NL + "\tfor(com.datastax.driver.core.Row row_";
  protected final String TEXT_58 = " : rs_";
  protected final String TEXT_59 = "){";
  protected final String TEXT_60 = NL + "    \t\t\t\t";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = " = row_";
  protected final String TEXT_63 = ".getString(\"";
  protected final String TEXT_64 = "\");" + NL + "    \t\t\t";
  protected final String TEXT_65 = NL + "    \t\t\t\t";
  protected final String TEXT_66 = ".";
  protected final String TEXT_67 = " = row_";
  protected final String TEXT_68 = ".getUUID(\"";
  protected final String TEXT_69 = "\").toString();" + NL + "    \t\t\t";
  protected final String TEXT_70 = NL + "    \t\t\t\t";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = " = row_";
  protected final String TEXT_73 = ".getVarint(\"";
  protected final String TEXT_74 = "\");" + NL + "    \t\t\t";
  protected final String TEXT_75 = NL + "    \t\t\t\t";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = " = row_";
  protected final String TEXT_78 = ".getInet(\"";
  protected final String TEXT_79 = "\");" + NL + "    \t\t\t";
  protected final String TEXT_80 = NL + "    \t\t\t\t";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = " = row_";
  protected final String TEXT_83 = ".getMap(\"";
  protected final String TEXT_84 = "\", Object.class, Object.class);" + NL + "    \t\t\t";
  protected final String TEXT_85 = NL + "    \t\t\t\t";
  protected final String TEXT_86 = ".";
  protected final String TEXT_87 = " = row_";
  protected final String TEXT_88 = ".getSet(\"";
  protected final String TEXT_89 = "\", Object.class);" + NL + "    \t\t\t";
  protected final String TEXT_90 = NL + "        \t\t";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " = row_";
  protected final String TEXT_93 = ".getList(\"";
  protected final String TEXT_94 = "\", Object.class);\t" + NL + "        \t";
  protected final String TEXT_95 = NL + "        \t\t";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = " = row_";
  protected final String TEXT_98 = ".getBool(\"";
  protected final String TEXT_99 = "\");\t" + NL + "        \t";
  protected final String TEXT_100 = NL + "        \t\tjava.nio.ByteBuffer bytebuffer_";
  protected final String TEXT_101 = "_";
  protected final String TEXT_102 = " = row_";
  protected final String TEXT_103 = ".getBytes(\"";
  protected final String TEXT_104 = "\");" + NL + "        \t\tbyte[] bytes_";
  protected final String TEXT_105 = "_";
  protected final String TEXT_106 = " = new byte[bytebuffer_";
  protected final String TEXT_107 = "_";
  protected final String TEXT_108 = ".remaining()];" + NL + "        \t\tbytebuffer_";
  protected final String TEXT_109 = "_";
  protected final String TEXT_110 = ".get(bytes_";
  protected final String TEXT_111 = "_";
  protected final String TEXT_112 = ", 0, bytes_";
  protected final String TEXT_113 = "_";
  protected final String TEXT_114 = ".length);" + NL + "        \t\t";
  protected final String TEXT_115 = ".";
  protected final String TEXT_116 = " = bytes_";
  protected final String TEXT_117 = "_";
  protected final String TEXT_118 = ";\t" + NL + "        \t";
  protected final String TEXT_119 = NL + "        \t\t";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = " = row_";
  protected final String TEXT_122 = ".getDate(\"";
  protected final String TEXT_123 = "\");\t" + NL + "        \t";
  protected final String TEXT_124 = " " + NL + "        \t\t";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = " = row_";
  protected final String TEXT_127 = ".getDecimal(\"";
  protected final String TEXT_128 = "\");\t" + NL + "        \t";
  protected final String TEXT_129 = " " + NL + "        \t\t";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = " = row_";
  protected final String TEXT_132 = ".getDouble(\"";
  protected final String TEXT_133 = "\");\t" + NL + "        \t";
  protected final String TEXT_134 = " " + NL + "        \t\t";
  protected final String TEXT_135 = ".";
  protected final String TEXT_136 = " = row_";
  protected final String TEXT_137 = ".getFloat(\"";
  protected final String TEXT_138 = "\");\t" + NL + "        \t";
  protected final String TEXT_139 = " " + NL + "        \t\t";
  protected final String TEXT_140 = ".";
  protected final String TEXT_141 = " = row_";
  protected final String TEXT_142 = ".getInt(\"";
  protected final String TEXT_143 = "\");\t" + NL + "        \t";
  protected final String TEXT_144 = " " + NL + "        \t\t";
  protected final String TEXT_145 = ".";
  protected final String TEXT_146 = " = row_";
  protected final String TEXT_147 = ".getLong(\"";
  protected final String TEXT_148 = "\");\t" + NL + "        \t";
  protected final String TEXT_149 = NL + "        nb_line_";
  protected final String TEXT_150 = "++;";
  protected final String TEXT_151 = "    ";
  protected final String TEXT_152 = NL + "\t";
  protected final String TEXT_153 = NL + "\tint nb_line_";
  protected final String TEXT_154 = " = 0;" + NL + "\t";
  protected final String TEXT_155 = NL + "\t\t\tme.prettyprint.hector.api.Serializer keySerializer_";
  protected final String TEXT_156 = " =me.prettyprint.cassandra.serializers.";
  protected final String TEXT_157 = ".get();" + NL + "\t\t\t";
  protected final String TEXT_158 = NL + "\t\t\t\tme.prettyprint.hector.api.Serializer sNameSerializer_";
  protected final String TEXT_159 = " =me.prettyprint.cassandra.serializers.";
  protected final String TEXT_160 = ".get();" + NL + "\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\tme.prettyprint.hector.api.Cluster cluster_";
  protected final String TEXT_162 = " =null;" + NL + "\t\t\tme.prettyprint.hector.api.Keyspace keyspace_";
  protected final String TEXT_163 = " =null;" + NL + "\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t\tcluster_";
  protected final String TEXT_165 = "=(me.prettyprint.hector.api.Cluster)globalMap.get(\"cluster_";
  protected final String TEXT_166 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_167 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_168 = " - Get an existing cluster instance from \" + \"";
  protected final String TEXT_169 = "\" + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_170 = NL + "\t\t\t\ttry{" + NL + "\t\t\t    \tString hostIps_";
  protected final String TEXT_171 = "=";
  protected final String TEXT_172 = "+\":\"+";
  protected final String TEXT_173 = ";" + NL + "\t\t\t\t    me.prettyprint.cassandra.service.CassandraHostConfigurator hosts_";
  protected final String TEXT_174 = " = new me.prettyprint.cassandra.service.CassandraHostConfigurator(hostIps_";
  protected final String TEXT_175 = ");" + NL + "\t\t\t\t    java.util.Map<String, String> credentials_";
  protected final String TEXT_176 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_177 = NL + "\t\t\t\t\t    credentials_";
  protected final String TEXT_178 = ".put(\"username\",";
  protected final String TEXT_179 = ");" + NL + "\t\t\t\t\t    ";
  protected final String TEXT_180 = NL + "                        ";
  protected final String TEXT_181 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_182 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_183 = ");";
  protected final String TEXT_184 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_185 = " = ";
  protected final String TEXT_186 = "; ";
  protected final String TEXT_187 = NL + "\t\t\t\t\t    " + NL + "\t\t\t\t\t    " + NL + "\t\t\t\t\t    credentials_";
  protected final String TEXT_188 = ".put(\"password\",decryptedPassword_";
  protected final String TEXT_189 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_190 = NL + "\t   \t \t\t\tcluster_";
  protected final String TEXT_191 = " = me.prettyprint.hector.api.factory.HFactory.getOrCreateCluster(\"cluster_";
  protected final String TEXT_192 = "_\"+pid,hosts_";
  protected final String TEXT_193 = ",credentials_";
  protected final String TEXT_194 = ");" + NL + "\t\t\t";
  protected final String TEXT_195 = NL + "\t\t\tme.prettyprint.cassandra.model.ConfigurableConsistencyLevel clpolicy_";
  protected final String TEXT_196 = " = new me.prettyprint.cassandra.model.ConfigurableConsistencyLevel();" + NL + "\t\t\tme.prettyprint.hector.api.HConsistencyLevel consistencyLevel_";
  protected final String TEXT_197 = " = me.prettyprint.hector.api.HConsistencyLevel.ONE;" + NL + "\t\t\tclpolicy_";
  protected final String TEXT_198 = ".setDefaultWriteConsistencyLevel(consistencyLevel_";
  protected final String TEXT_199 = ");" + NL + "\t\t    keyspace_";
  protected final String TEXT_200 = " = me.prettyprint.hector.api.factory.HFactory.createKeyspace(";
  protected final String TEXT_201 = ", cluster_";
  protected final String TEXT_202 = ",clpolicy_";
  protected final String TEXT_203 = ");" + NL + "\t\t    " + NL + "\t\t    me.prettyprint.cassandra.serializers.StringSerializer serializer_";
  protected final String TEXT_204 = " = me.prettyprint.cassandra.serializers.StringSerializer.get();" + NL + "\t\t\t";
  protected final String TEXT_205 = NL + "\t\t\t\t\tme.prettyprint.hector.api.query.MultigetSliceQuery<";
  protected final String TEXT_206 = ", String, String> sliceQuery_";
  protected final String TEXT_207 = " = me.prettyprint.hector.api.factory.HFactory.createMultigetSliceQuery(" + NL + "\t\t\t\t\t\tkeyspace_";
  protected final String TEXT_208 = " , keySerializer_";
  protected final String TEXT_209 = ",serializer_";
  protected final String TEXT_210 = ", serializer_";
  protected final String TEXT_211 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_212 = NL + "\t\t\t\t\tme.prettyprint.hector.api.query.RangeSlicesQuery<";
  protected final String TEXT_213 = ", String, String> sliceQuery_";
  protected final String TEXT_214 = " =" + NL + "\t\t\t\t\t\tme.prettyprint.hector.api.factory.HFactory.createRangeSlicesQuery(keyspace_";
  protected final String TEXT_215 = " , keySerializer_";
  protected final String TEXT_216 = ",serializer_";
  protected final String TEXT_217 = ", serializer_";
  protected final String TEXT_218 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_219 = NL + "\t\t\t\tsliceQuery_";
  protected final String TEXT_220 = ".setColumnNames(";
  protected final String TEXT_221 = ");" + NL + "\t\t\t";
  protected final String TEXT_222 = NL + "\t\t\t\t\tme.prettyprint.hector.api.query.MultigetSuperSliceQuery<";
  protected final String TEXT_223 = ", ";
  protected final String TEXT_224 = ", String, String> sliceQuery_";
  protected final String TEXT_225 = " = me.prettyprint.hector.api.factory.HFactory.createMultigetSuperSliceQuery(" + NL + "\t\t\t\t\t\tkeyspace_";
  protected final String TEXT_226 = " , keySerializer_";
  protected final String TEXT_227 = ",sNameSerializer_";
  protected final String TEXT_228 = ", serializer_";
  protected final String TEXT_229 = ", serializer_";
  protected final String TEXT_230 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_231 = NL + "\t\t\t\t\tme.prettyprint.hector.api.query.RangeSuperSlicesQuery<";
  protected final String TEXT_232 = ", ";
  protected final String TEXT_233 = ", String, String> sliceQuery_";
  protected final String TEXT_234 = " = " + NL + "\t\t\t\t\t\tme.prettyprint.hector.api.factory.HFactory.createRangeSuperSlicesQuery(keyspace_";
  protected final String TEXT_235 = " , keySerializer_";
  protected final String TEXT_236 = ",sNameSerializer_";
  protected final String TEXT_237 = ", serializer_";
  protected final String TEXT_238 = ", serializer_";
  protected final String TEXT_239 = ");\t" + NL + "\t\t\t\t";
  protected final String TEXT_240 = NL + "\t\t\tsliceQuery_";
  protected final String TEXT_241 = ".setColumnFamily(";
  protected final String TEXT_242 = ");" + NL + "\t\t\t";
  protected final String TEXT_243 = NL + "\t\t\t\tsliceQuery_";
  protected final String TEXT_244 = ".setKeys(";
  protected final String TEXT_245 = ");" + NL + "\t\t\t";
  protected final String TEXT_246 = NL + "\t\t\t\tsliceQuery_";
  protected final String TEXT_247 = ".setKeys(";
  protected final String TEXT_248 = ",";
  protected final String TEXT_249 = ");" + NL + "\t\t\t\tsliceQuery_";
  protected final String TEXT_250 = ".setRowCount(";
  protected final String TEXT_251 = ");" + NL + "\t\t\t";
  protected final String TEXT_252 = NL + "\t\t\t\tsliceQuery_";
  protected final String TEXT_253 = ".setColumnNames(";
  protected final String TEXT_254 = ");" + NL + "\t\t\t";
  protected final String TEXT_255 = NL + "\t\t\t\tsliceQuery_";
  protected final String TEXT_256 = ".setRange(";
  protected final String TEXT_257 = ",";
  protected final String TEXT_258 = ", false, ";
  protected final String TEXT_259 = ");" + NL + "\t\t\t";
  protected final String TEXT_260 = NL + "\t\t\t\t\tme.prettyprint.hector.api.query.QueryResult<me.prettyprint.hector.api.beans.Rows<";
  protected final String TEXT_261 = ",String, String>> result_";
  protected final String TEXT_262 = " = sliceQuery_";
  protected final String TEXT_263 = ".execute();" + NL + "\t\t\t\t";
  protected final String TEXT_264 = NL + "\t\t\t\t\tme.prettyprint.hector.api.query.QueryResult<me.prettyprint.hector.api.beans.OrderedRows<";
  protected final String TEXT_265 = ",String, String>> result_";
  protected final String TEXT_266 = " = sliceQuery_";
  protected final String TEXT_267 = ".execute();" + NL + "\t\t\t\t";
  protected final String TEXT_268 = NL + "\t\t\t\tjava.util.Iterator rows_";
  protected final String TEXT_269 = " = result_";
  protected final String TEXT_270 = ".get().iterator();" + NL + "\t\t\t\twhile(rows_";
  protected final String TEXT_271 = ".hasNext()){" + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_272 = "++;" + NL + "\t\t\t\t\tme.prettyprint.hector.api.beans.Row<";
  protected final String TEXT_273 = ",String, String> row_";
  protected final String TEXT_274 = "=(me.prettyprint.hector.api.beans.Row<";
  protected final String TEXT_275 = ",String, String>)rows_";
  protected final String TEXT_276 = ".next();" + NL + "\t\t\t\t\tme.prettyprint.hector.api.beans.ColumnSlice<String, String> slice_";
  protected final String TEXT_277 = "=row_";
  protected final String TEXT_278 = ".getColumnSlice();" + NL + "\t\t\t";
  protected final String TEXT_279 = NL + "\t\t\t\t\tme.prettyprint.hector.api.query.QueryResult<me.prettyprint.hector.api.beans.SuperRows<";
  protected final String TEXT_280 = ",";
  protected final String TEXT_281 = ",String, String>> result_";
  protected final String TEXT_282 = " = sliceQuery_";
  protected final String TEXT_283 = ".execute();" + NL + "\t\t\t\t";
  protected final String TEXT_284 = NL + "\t\t\t\t\tme.prettyprint.hector.api.query.QueryResult<me.prettyprint.hector.api.beans.OrderedSuperRows<";
  protected final String TEXT_285 = ",";
  protected final String TEXT_286 = ",String, String>> result_";
  protected final String TEXT_287 = " = sliceQuery_";
  protected final String TEXT_288 = ".execute();" + NL + "\t\t\t\t";
  protected final String TEXT_289 = NL + "\t\t\t\tjava.util.Iterator superRows_";
  protected final String TEXT_290 = " = result_";
  protected final String TEXT_291 = ".get().iterator();" + NL + "\t\t\t\twhile(superRows_";
  protected final String TEXT_292 = ".hasNext()){" + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_293 = "++;" + NL + "\t\t\t\t\tme.prettyprint.hector.api.beans.SuperRow superRow_";
  protected final String TEXT_294 = "=(me.prettyprint.hector.api.beans.SuperRow)superRows_";
  protected final String TEXT_295 = ".next();" + NL + "\t\t\t\t\tme.prettyprint.hector.api.beans.SuperSlice slice_";
  protected final String TEXT_296 = "=superRow_";
  protected final String TEXT_297 = ".getSuperSlice();" + NL + "\t\t\t\t\tjava.util.List<me.prettyprint.hector.api.beans.HSuperColumn> superColumns_";
  protected final String TEXT_298 = "=slice_";
  protected final String TEXT_299 = ".getSuperColumns();" + NL + "\t\t\t\t\tfor (me.prettyprint.hector.api.beans.HSuperColumn superColumn_";
  protected final String TEXT_300 = " : superColumns_";
  protected final String TEXT_301 = ") {" + NL + "\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_302 = NL + "\t\t\tme.prettyprint.hector.api.beans.HColumn<String,String> column_";
  protected final String TEXT_303 = "=null;" + NL + "" + NL + "\t\t\tjava.nio.ByteBuffer columnValue_";
  protected final String TEXT_304 = "=null;" + NL + "\t\t\tString colName = \"\";" + NL + "\t\t\tbyte[] bTargetColName = null;" + NL + "\t\t\t";
  protected final String TEXT_305 = NL + "\t\t\t\t\t\t\t\tif(row_";
  protected final String TEXT_306 = ".getKey()!=null){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_307 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_308 = ".";
  protected final String TEXT_309 = "=ParserUtils.parseTo_Date((java.util.Date)(row_";
  protected final String TEXT_310 = ".getKey()), ";
  protected final String TEXT_311 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_312 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_313 = ".";
  protected final String TEXT_314 = "=String.valueOf(row_";
  protected final String TEXT_315 = ".getKey()).getBytes(utf8Charset);" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_316 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_317 = ".";
  protected final String TEXT_318 = "=row_";
  protected final String TEXT_319 = ".getKey();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_320 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_321 = ".";
  protected final String TEXT_322 = "=ParserUtils.parseTo_";
  protected final String TEXT_323 = "(String.valueOf(row_";
  protected final String TEXT_324 = ".getKey()));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_325 = NL + "\t\t\t\t\t\t\t\t}\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_326 = NL + "\t\t\t\t\t\t\t\tif(superRow_";
  protected final String TEXT_327 = ".getKey()!=null){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_328 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_329 = ".";
  protected final String TEXT_330 = "=ParserUtils.parseTo_Date((java.util.Date)(superRow_";
  protected final String TEXT_331 = ".getKey()), ";
  protected final String TEXT_332 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_333 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_334 = ".";
  protected final String TEXT_335 = "=String.valueOf(superRow_";
  protected final String TEXT_336 = ".getKey()).getBytes(utf8Charset);" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_337 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_338 = ".";
  protected final String TEXT_339 = "=superRow_";
  protected final String TEXT_340 = ".getKey();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_341 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_342 = ".";
  protected final String TEXT_343 = "=ParserUtils.parseTo_";
  protected final String TEXT_344 = "(String.valueOf(superRow_";
  protected final String TEXT_345 = ".getKey()));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_346 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_347 = NL + "\t\t\t\t\t\t\t\tcolumnValue_";
  protected final String TEXT_348 = "=superColumn_";
  protected final String TEXT_349 = ".getNameByteBuffer();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_350 = NL + "\t\t\t\t\t\t\t\t\tcolName = \"";
  protected final String TEXT_351 = "\";" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_352 = "=slice_";
  protected final String TEXT_353 = ".getColumnByName(colName);" + NL + "" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_354 = NL + "\t\t\t\t\t\t\t\t\tif(column_";
  protected final String TEXT_355 = " == null) {" + NL + "\t\t\t\t\t\t\t\t\t\t// CASSANDRA 2.x changed their column name encoding, leading to wrong getColumnByName behavior" + NL + "\t\t\t\t\t\t\t\t\t\tbyte[] bColName = \"";
  protected final String TEXT_356 = "\".getBytes();" + NL + "\t\t\t\t\t\t\t\t\t\tbTargetColName = new byte[bColName.length + 3];" + NL + "\t\t\t\t\t\t\t\t\t\tbTargetColName[0] = (byte)0;bTargetColName[bTargetColName.length - 1] = (byte)0;" + NL + "\t\t\t\t\t\t\t\t\t\tbTargetColName[1] = (byte)bColName.length;" + NL + "\t\t\t\t\t\t\t\t\t\tSystem.arraycopy(bColName, 0, bTargetColName, 2, bColName.length);\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\tcolName = new String(bTargetColName);" + NL + "\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_357 = "=slice_";
  protected final String TEXT_358 = ".getColumnByName(colName);" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_359 = NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tcolumnValue_";
  protected final String TEXT_360 = "=(column_";
  protected final String TEXT_361 = "==null?null:column_";
  protected final String TEXT_362 = ".getValueBytes());\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_363 = NL + "\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_364 = "=superColumn_";
  protected final String TEXT_365 = ".getSubColumnByName(\"";
  protected final String TEXT_366 = "\");" + NL + "\t\t\t\t\t\t\t\t\tcolumnValue_";
  protected final String TEXT_367 = "=(column_";
  protected final String TEXT_368 = "==null?null:column_";
  protected final String TEXT_369 = ".getValueBytes());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_370 = NL + "\t\t\t\t\t\t\tif(columnValue_";
  protected final String TEXT_371 = "!=null){" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_372 = NL + "\t\t\t\t\t\t\t\t\tLong dateValue_";
  protected final String TEXT_373 = "=columnValue_";
  protected final String TEXT_374 = ".getLong();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_375 = ".";
  protected final String TEXT_376 = " = ParserUtils.parseTo_Date(new java.util.Date(dateValue_";
  protected final String TEXT_377 = "), ";
  protected final String TEXT_378 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_379 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_380 = ".";
  protected final String TEXT_381 = "=columnValue_";
  protected final String TEXT_382 = ".getFloat();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_383 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_384 = ".";
  protected final String TEXT_385 = "=columnValue_";
  protected final String TEXT_386 = ".getChar();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_387 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_388 = ".";
  protected final String TEXT_389 = " = me.prettyprint.cassandra.serializers.BigIntegerSerializer.get().fromByteBuffer(columnValue_";
  protected final String TEXT_390 = ").intValue();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_391 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_392 = ".";
  protected final String TEXT_393 = "=columnValue_";
  protected final String TEXT_394 = ".getShort();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_395 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_396 = ".";
  protected final String TEXT_397 = "=columnValue_";
  protected final String TEXT_398 = ".getLong();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_399 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_400 = ".";
  protected final String TEXT_401 = "=columnValue_";
  protected final String TEXT_402 = ".getDouble();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_403 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_404 = ".";
  protected final String TEXT_405 = " = " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_406 = NL + "\t\t\t\t\t\t\t\t\t\t\t(";
  protected final String TEXT_407 = ")" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_408 = NL + "\t\t\t\t\t\t\t\t\t\tme.prettyprint.cassandra.serializers.";
  protected final String TEXT_409 = ".get().fromByteBuffer(columnValue_";
  protected final String TEXT_410 = ")" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_411 = NL + "\t\t\t\t\t\t\t\t\t\t\t.toString()" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_412 = NL + "\t\t\t\t\t\t\t\t\t\t;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_413 = NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_414 = ".";
  protected final String TEXT_415 = " = ";
  protected final String TEXT_416 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_417 = NL + "    " + NL + "    \t";
  protected final String TEXT_418 = NL + "    ";
  protected final String TEXT_419 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_30);
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    
// Check the presence of a tCassandraConnection
{
    boolean useExistingConnection = ElementParameterParser.getBooleanValue(node,"__USE_EXISTING_CONNECTION__");
    if (useExistingConnection) {
        String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        if (connection.isEmpty()) {
            return "if (true) {throw new IOException(\"You have to selection a connection\");}";
        }
    }
}

    stringBuffer.append(TEXT_31);
    
//TODO: use API_SELECTED instead of this
class API_selector{
	public boolean useDatastax(INode node){
		String dbVersion = ElementParameterParser.getValue(node, "__DB_VERSION__");
        String apiType = ElementParameterParser.getValue(node, "__API_TYPE__");
        return "CASSANDRA_2_0_0".equals(dbVersion) && "DATASTAX".equals(apiType); 
	}
}	

    
	if((new API_selector()).useDatastax(ElementParameterParser.getBooleanValue(node, "__USE_EXISTING_CONNECTION__") ? ElementParameterParser.getLinkedNodeValue(node, "__CONNECTION__") : node)){
	
    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    
	IMetadataTable metadata = null;
	IConnection conn = null;
	List<IMetadataColumn> columns = null;
	List<IMetadataTable> metadatas = node.getMetadataList();	
	if((metadatas != null) && (metadatas.size() > 0)){
    	metadata = metadatas.get(0);
    	if(metadata != null){
    		columns = metadata.getListColumns();		
    	}
    }
    
    List<? extends IConnection> conns = node.getOutgoingSortedConnections();
	if(conns != null && conns.size() > 0 && conns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
		conn = conns.get(0);
    }	
    
    if(columns == null || columns.isEmpty() || conn == null){
    	return "";
    }
	
    stringBuffer.append(TEXT_34);
     
	boolean useExistConn = ElementParameterParser.getBooleanValue(node, "__USE_EXISTING_CONNECTION__");
    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	if(useExistConn){
	
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_39);
    
	}else{	
	
    stringBuffer.append(TEXT_40);
    stringBuffer.append(TEXT_41);
    
    String host = ElementParameterParser.getValue(node,"__HOST__");
    String port = ElementParameterParser.getValue(node,"__PORT__");
    String userName = ElementParameterParser.getValue(node, "__USERNAME__");
    String passWord = ElementParameterParser.getPasswordValue(node, "__PASSWORD__");
	boolean authentication= ElementParameterParser.getBooleanValue(node, "__REQUIRED_AUTHENTICATION__");
    
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_45);
    
                                                            	if(authentication){
                                                            	
    stringBuffer.append(TEXT_46);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(passWord);
    stringBuffer.append(TEXT_48);
    
                                                            	}
                                                            	
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
	}
	String query = ElementParameterParser.getValue(node, "__QUERY__").replaceAll("[\r\n]", " ");	
	
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
        String connName = conn.getName();
    	for(IMetadataColumn column : columns){
    		String dbType = column.getType();
    		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    		String columnName = column.getLabel();	
    		String dbColumnName = column.getOriginalDbColumnName();
			dbColumnName = "\\\"" + dbColumnName + "\\\"";
			
    		if(javaType == JavaTypesManager.STRING){
    			if("ascii".equals(dbType) || "text".equals(dbType) || "varchar".equals(dbType)){
    			
    stringBuffer.append(TEXT_60);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_64);
    
    			}else if("timeuuid".equals(dbType) || "uuid".equals(dbType)){
    			
    stringBuffer.append(TEXT_65);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_69);
    
    			}
        	}else if(javaType == JavaTypesManager.OBJECT){
        		if("varint".equals(dbType)){
    			
    stringBuffer.append(TEXT_70);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_74);
    
    			}else if("inet".equals(dbType)){
    			
    stringBuffer.append(TEXT_75);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_79);
    
    			}else if("map".equals(dbType)){
    			
    stringBuffer.append(TEXT_80);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_84);
    
    			}else if("set".equals(dbType)){
    			
    stringBuffer.append(TEXT_85);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_89);
    
    			}
    		}else if(javaType == JavaTypesManager.LIST){
        	
    stringBuffer.append(TEXT_90);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_94);
    
        	}else if(javaType == JavaTypesManager.BOOLEAN){
        	
    stringBuffer.append(TEXT_95);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_99);
    
    		}else if(javaType == JavaTypesManager.BYTE_ARRAY){
        	
    stringBuffer.append(TEXT_100);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    	
    		}else if(javaType == JavaTypesManager.DATE){
        	
    stringBuffer.append(TEXT_119);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_123);
    
    		}else if(javaType == JavaTypesManager.BIGDECIMAL){
        	
    stringBuffer.append(TEXT_124);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_128);
    
    		}else if(javaType == JavaTypesManager.DOUBLE){
        	
    stringBuffer.append(TEXT_129);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_133);
    
    		}else if(javaType == JavaTypesManager.FLOAT){
        	
    stringBuffer.append(TEXT_134);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_138);
    
    		}else if(javaType == JavaTypesManager.INTEGER){
        	
    stringBuffer.append(TEXT_139);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_143);
    
    		}else if(javaType == JavaTypesManager.LONG){
        	
    stringBuffer.append(TEXT_144);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_148);
    
    		}
    	}
        
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    
    }else{
    
    stringBuffer.append(TEXT_151);
    stringBuffer.append(TEXT_152);
     
	class ColumnComparator implements java.util.Comparator<IMetadataColumn> {

		private Boolean incKey = null;
		private String keyColumn = null;

		public ColumnComparator(Boolean incKey, String keyColumn) {
			this.incKey = incKey;
			this.keyColumn = keyColumn;
		}

		public final int compare(IMetadataColumn a, IMetadataColumn b) {
			if(incKey) {
				if(a.getLabel().equals(keyColumn)) {
					return -1;
				}
				if(b.getLabel().equals(keyColumn)) {
					return 1;
				}
			}// */
			return a.getLabel().toLowerCase().compareTo(b.getLabel().toLowerCase());
		}

	}
	String host = ElementParameterParser.getValue(node,"__HOST__");
    String port = ElementParameterParser.getValue(node,"__PORT__");
    //String cluster= ElementParameterParser.getValue(node, "__CLUSTER__");
    String userName = ElementParameterParser.getValue(node, "__USERNAME__");
    String passWord = ElementParameterParser.getValue(node, "__PASSWORD__");
	String keySpace = ElementParameterParser.getValue(node,"__KEY_SPACE__");
	String dbVersion = ElementParameterParser.getValue(node,"__DB_VERSION__");
	boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    String columnFamily = ElementParameterParser.getValue(node,"__COLUMN_FAMILY__");
    String keyColumn = ElementParameterParser.getValue(node,"__KEY_COLUMN__");
    boolean incKey = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__INC_KEY__"));
    String superKeyColumn = ElementParameterParser.getValue(node,"__SUPER_KEY_COLUMN__");
    boolean incSuperKey = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__INC_SUPER_KEY__"));
    String rowKeys=ElementParameterParser.getValue(node,"__ROW_KEYS__");
    String searchColumns=ElementParameterParser.getValue(node,"__COLUMNS__");
 	String keyStart = ElementParameterParser.getValue(node,"__KEY_START__");
 	String keyEnd = ElementParameterParser.getValue(node,"__KEY_END__");
 	String keyLimit= ElementParameterParser.getValue(node,"__KEY_LIMIT__");
 	String columnStart = ElementParameterParser.getValue(node,"__COLUMN_START__");
 	String columnEnd = ElementParameterParser.getValue(node,"__COLUMN_END__");
 	String columnLimit = ElementParameterParser.getValue(node,"__COLUMN_LIMIT__");
 	
 	boolean isSpecifyKeys = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__SPECIFY_KEYS__"));
 	boolean isSpecifyColumns = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__SPECIFY_COLUMNS__"));
 	
 	String columnFamilyType = ElementParameterParser.getValue(node,"__COLUMN_FAMILY_TYPE__");
 	String rowKeyType = ElementParameterParser.getValue(node,"__ROW_KEY_TYPE__");
 	String sNameType = ElementParameterParser.getValue(node,"__SUPER_COLUMN_TYPE__");
 	String rowKeyCType = ElementParameterParser.getValue(node,"__ROW_KEY_C_TYPE__");
 	String sNameCType = ElementParameterParser.getValue(node,"__SUPER_COLUMN_C_TYPE__");
    
    List<IMetadataTable> metadatas = node.getMetadataList();
  	List<IMetadataColumn> columnList = null;
  	List<? extends IConnection> outputs = node.getOutgoingSortedConnections();
  	String firstConnName = "";
	
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    if (useExistingConnection) {
    	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
        for(INode targetNode : nodes){
            if (targetNode.getUniqueName().equals(connection)) {
                dbVersion = ElementParameterParser.getValue(targetNode, "__DB_VERSION__");
                break;
            }
        }
    }
    
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    
  	if(metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	columnList = metadata.getListColumns();
      	java.util.Collections.sort(columnList, new ColumnComparator (incKey, keyColumn));
		int sizeColumns = columnList.size();
      	if(metadata != null){
      		
      		class TypeMap{
      			Map<String,String> typeMap=new java.util.HashMap<String,String>();
      			
      			public TypeMap(){
					typeMap.put("Boolean","BooleanSerializer");
					typeMap.put("byte[]","BytesArraySerializer");
					typeMap.put("java.util.Date","DateSerializer");
					typeMap.put("Double","DoubleSerializer");
					typeMap.put("Float","FloatSerializer");
					typeMap.put("Integer","IntegerSerializer");
					typeMap.put("Long","LongSerializer");
					typeMap.put("Object","ObjectSerializer");
					typeMap.put("Short","ShortSerializer");
					typeMap.put("String","StringSerializer");
					typeMap.put("Character","CharSerializer");
					typeMap.put("BigDecimal","BigDecimalSerializer");
					typeMap.put("java.util.UUID", "UUIDSerializer");
      			}

      			public String get(String tType, String cType){
      				if("".equals(cType) || "Default".equals(cType)){
      					return typeMap.get(tType);
      				}else if("CounterColumnType".equals(cType)){
      					return "LongSerializer";
      				}else if("IntegerType".equals(cType)){
      					return "BigIntegerSerializer";
      				}else if("AsciiType".equals(cType)){
      					return "AsciiSerializer";
      				}else if("UUIDType".equals(cType)){
      					return "UUIDSerializer";
      				}else if("TimeUUIDType".equals(cType)){
      					return "TimeUUIDSerializer";
      				}else{
      					return typeMap.get(tType) == null ? "ObjectSerializer" : typeMap.get(tType);
      				}
      			}
      		}
     		TypeMap typeMap = new TypeMap();
			
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(typeMap.get(rowKeyType, rowKeyCType));
    stringBuffer.append(TEXT_157);
    
			if("SUPER".equals(columnFamilyType)){
			
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(typeMap.get(sNameType, sNameCType));
    stringBuffer.append(TEXT_160);
    
			}
			
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    
			if(useExistingConnection){
                String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
				
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_166);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_169);
    
				}
			}else{
			
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
					if (authentication){
					
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_179);
    
                        String passwordFieldName = "__PASSWORD__";
                        
    stringBuffer.append(TEXT_180);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_183);
    } else {
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_186);
    }
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    
					}
					
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
			}
			log4jFileUtil.startRetriveDataInfo();
			
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    
			if("STANDARD".equals(columnFamilyType)){
				StringBuilder columns=new StringBuilder();
		        boolean isfirstColumn=true;
				for(int i = 0; i < sizeColumns; i++){
					IMetadataColumn column = columnList.get(i);
		        	if(!isfirstColumn){
		        		columns.append(",");
		        	}else{
		        		isfirstColumn=false;
		        	}
					columns.append("\""+column.getOriginalDbColumnName()+"\"");
	            }
				if(isSpecifyKeys){
				
    stringBuffer.append(TEXT_205);
    stringBuffer.append(rowKeyType);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    
				}else{
				
    stringBuffer.append(TEXT_212);
    stringBuffer.append(rowKeyType);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
				}
				
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(columns.toString());
    stringBuffer.append(TEXT_221);
    
			}else{
				if(isSpecifyKeys){
				
    stringBuffer.append(TEXT_222);
    stringBuffer.append(rowKeyType);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(sNameType);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    
				}else{
				
    stringBuffer.append(TEXT_231);
    stringBuffer.append(rowKeyType);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(sNameType);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    
				}
			}
			
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_242);
    			
			if(isSpecifyKeys){
			
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(rowKeys);
    stringBuffer.append(TEXT_245);
    
			}else{
			
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(("".equals(keyStart) || "\"\"".equals(keyStart)?"null":keyStart));
    stringBuffer.append(TEXT_248);
    stringBuffer.append(("".equals(keyEnd) || "\"\"".equals(keyEnd)?"null":keyEnd));
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(keyLimit);
    stringBuffer.append(TEXT_251);
    
			}
			if(isSpecifyColumns){
			
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(searchColumns);
    stringBuffer.append(TEXT_254);
    
			}else{
			
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(("".equals(columnStart) || "\"\"".equals(columnStart)?"null":columnStart));
    stringBuffer.append(TEXT_257);
    stringBuffer.append(("".equals(columnEnd) || "\"\"".equals(columnEnd)?"null":columnEnd));
    stringBuffer.append(TEXT_258);
    stringBuffer.append(columnLimit);
    stringBuffer.append(TEXT_259);
    
			}
			if("STANDARD".equals(columnFamilyType)){
				if(isSpecifyKeys){
				
    stringBuffer.append(TEXT_260);
    stringBuffer.append(rowKeyType);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    
				}else{
				
    stringBuffer.append(TEXT_264);
    stringBuffer.append(rowKeyType);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    
				}
				
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(rowKeyType);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(rowKeyType);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    
			}else{
				if(isSpecifyKeys){
				
    stringBuffer.append(TEXT_279);
    stringBuffer.append(rowKeyType);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(sNameType);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    
				}else{
				
    stringBuffer.append(TEXT_284);
    stringBuffer.append(rowKeyType);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(sNameType);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    
				}
				
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    
			}
			
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    
			if(outputs!=null && outputs.size() > 0){
		    	IConnection out = outputs.get(0);
      			firstConnName = out.getName();
		  		if(out.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
				
					//java.util.Collections.sort(columnList, new ColumnComparator (incKey, keyColumn));

					for(int i = 0; i < sizeColumns; i++){
						IMetadataColumn column = columnList.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if(incKey && column.getLabel().equals(keyColumn)){
							if("STANDARD".equals(columnFamilyType)){
							
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    
									if(javaType == JavaTypesManager.DATE){
									
    stringBuffer.append(TEXT_307);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_311);
    
									}else if(javaType == JavaTypesManager.BYTE_ARRAY){
									
    stringBuffer.append(TEXT_312);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    
									}else if(javaType == JavaTypesManager.OBJECT){
									
    stringBuffer.append(TEXT_316);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    
									}else{
									
    stringBuffer.append(TEXT_320);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    
									}
									
    stringBuffer.append(TEXT_325);
    
							}else{
							
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    
									if(javaType == JavaTypesManager.DATE){
									
    stringBuffer.append(TEXT_328);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_332);
    
									}else if(javaType == JavaTypesManager.BYTE_ARRAY){
									
    stringBuffer.append(TEXT_333);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    
									}else if(javaType == JavaTypesManager.OBJECT){
									
    stringBuffer.append(TEXT_337);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    
									}else{
									
    stringBuffer.append(TEXT_341);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    	
									}
									
    stringBuffer.append(TEXT_346);
    
							}
						}else{
							if("SUPER".equals(columnFamilyType) && incSuperKey && column.getLabel().equals(superKeyColumn)){
							
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    
							}else{
								if("STANDARD".equals(columnFamilyType)){
								
    stringBuffer.append(TEXT_350);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
     if("CASSANDRA_2_0_0".equals(dbVersion)) { 

										/*
										when hector was used to insert data, getColumnByName() will work as usual
										when datastax driver was used to insert data, column.getName() will return empty for key and will
										return a String different from the column.getOriginalDbColumnName() but only if you look
										at the byte[] level.
										example : column name => age {97,103,101} will become {0,3,97,103,101,0}
										so proposed fix is to reconstruct this second string from the original column name
										{0, <length_of_byte_array_from_original_colname>,<byte array original column name>, 0}
										*/

									
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
     } 
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    
								}else{
								
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    
								}
							}
							
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    
								if(javaType == JavaTypesManager.DATE) {
								
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_378);
    
								}else if(javaType == JavaTypesManager.FLOAT){
								
    stringBuffer.append(TEXT_379);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    
								}else if(javaType == JavaTypesManager.CHARACTER){
								
    stringBuffer.append(TEXT_383);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_384);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    
								}else if(javaType == JavaTypesManager.INTEGER){
								
    stringBuffer.append(TEXT_387);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    
								}else if(javaType == JavaTypesManager.SHORT){
								
    stringBuffer.append(TEXT_391);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    
								}else if(javaType == JavaTypesManager.LONG){
								
    stringBuffer.append(TEXT_395);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    
								}else if(javaType == JavaTypesManager.DOUBLE){
								
    stringBuffer.append(TEXT_399);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    
								}else{
									String columnType=JavaTypesManager.getTypeToGenerate(column.getTalendType(), true);
									String cType = column.getType();
									
    stringBuffer.append(TEXT_403);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_405);
    
										if(typeMap.get(columnType, cType)=="ObjectSerializer"){
										
    stringBuffer.append(TEXT_406);
    stringBuffer.append(columnType);
    stringBuffer.append(TEXT_407);
    
										}
										
    stringBuffer.append(TEXT_408);
    stringBuffer.append(typeMap.get(columnType, cType));
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    
										if(typeMap.get(columnType, cType)=="UUIDSerializer" || typeMap.get(columnType, cType)=="TimeUUIDSerializer"){
										
    stringBuffer.append(TEXT_411);
    
										}
										
    stringBuffer.append(TEXT_412);
    
								}
								
    stringBuffer.append(TEXT_413);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_414);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_415);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_416);
    
						}
			   		}
			   		log4jFileUtil.debugRetriveData(node);
	     		}
			}
      	}
    }
	
    stringBuffer.append(TEXT_417);
    
    }
    
    stringBuffer.append(TEXT_418);
    stringBuffer.append(TEXT_419);
    return stringBuffer.toString();
  }
}
