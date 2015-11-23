package org.talend.designer.codegen.translators.processing;

import java.util.Set;
import org.talend.transform.component.thmap.MapperComponent;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class THMapMainJava
{
  protected static String nl;
  public static synchronized THMapMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THMapMainJava result = new THMapMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "    javax.xml.transform.Result result_";
  protected final String TEXT_4 = " = null; " + NL + "   \torg.talend.transform.runtime.api.RuntimeEngine __tdmRuntime_";
  protected final String TEXT_5 = " = null;" + NL + "   \torg.talend.transform.runtime.api.MapRuntime mapRuntime_";
  protected final String TEXT_6 = " = null;";
  protected final String TEXT_7 = NL + "   \torg.talend.transform.runtime.api.MapPathHelper mapPathHelper_";
  protected final String TEXT_8 = " = new org.talend.transform.runtime.api.MapPathHelper(";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ", null, ";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\torg.talend.transform.runtime.api.MapPathHelper mapPathHelper_";
  protected final String TEXT_13 = " = new org.talend.transform.runtime.api.MapPathHelper(\"";
  protected final String TEXT_14 = "\", ";
  protected final String TEXT_15 = ", null, ";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\torg.talend.transform.runtime.api.MapPathHelper mapPathHelper_";
  protected final String TEXT_18 = " = new org.talend.transform.runtime.api.MapPathHelper(null, ";
  protected final String TEXT_19 = ", null, ";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + NL + "    synchronized (routines.system.RuntimeMap.getInstance().getRuntimeMap()) {" + NL + "    " + NL + "    \tif (routines.system.RuntimeMap.getInstance().getRuntimeMap().containsKey(\"__tdmRuntime\")) {" + NL + "        \t__tdmRuntime_";
  protected final String TEXT_22 = " = (org.talend.transform.runtime.api.RuntimeEngine) routines.system.RuntimeMap.getInstance().getRuntimeMap().get(\"__tdmRuntime\");" + NL + "    \t} else {";
  protected final String TEXT_23 = NL + "        \t\tSystem.setProperty(org.talend.transform.runtime.api.RuntimeFactory.ODT_DEV_WORKSPACE_VAR, mapPathHelper_";
  protected final String TEXT_24 = ".getWorkspace());" + NL + "        \t\tSystem.setProperty(org.talend.transform.runtime.api.RuntimeFactory.ODT_DEV_INSTALL_VAR, ";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\t\t\tif (mapPathHelper_";
  protected final String TEXT_27 = ".isValidMapPath()) {" + NL + "\t\t\t\tSystem.setProperty(org.talend.transform.runtime.api.RuntimeFactory.ODT_DEV_WORKSPACE_VAR, mapPathHelper_";
  protected final String TEXT_28 = ".getWorkspace());" + NL + "\t\t\t}";
  protected final String TEXT_29 = NL + "        \t__tdmRuntime_";
  protected final String TEXT_30 = " = org.talend.transform.runtime.api.RuntimeFactory.createRuntime();" + NL + "        \t__tdmRuntime_";
  protected final String TEXT_31 = ".setLogging(\"";
  protected final String TEXT_32 = "\", org.talend.transform.runtime.api.RuntimeEngine.LOG_DEST_CONSOLE);" + NL + "            routines.system.RuntimeMap.getInstance().getRuntimeMap().put(\"__tdmRuntime\",__tdmRuntime_";
  protected final String TEXT_33 = ");" + NL + "\t\t}" + NL + "    " + NL + "    \tif (";
  protected final String TEXT_34 = ".this.globalMap.containsKey(\"mapRuntime_";
  protected final String TEXT_35 = "\")) {" + NL + "        \tmapRuntime_";
  protected final String TEXT_36 = " = (org.talend.transform.runtime.api.MapRuntime) ";
  protected final String TEXT_37 = ".this.globalMap.get(\"mapRuntime_";
  protected final String TEXT_38 = "\");" + NL + "    \t} else {";
  protected final String TEXT_39 = NL + "            \t__tdmRuntime_";
  protected final String TEXT_40 = ".addProjectDevLink(mapPathHelper_";
  protected final String TEXT_41 = ".isValidMapPath() ? mapPathHelper_";
  protected final String TEXT_42 = ".getProjectName() : \"";
  protected final String TEXT_43 = "\");";
  protected final String TEXT_44 = NL + "\t\t\t\tif (mapPathHelper_";
  protected final String TEXT_45 = ".isValidMapPath()) {" + NL + "\t\t\t\t\t__tdmRuntime_";
  protected final String TEXT_46 = ".addProjectDevLink(mapPathHelper_";
  protected final String TEXT_47 = ".getProjectName());" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tjava.io.File userDir = new java.io.File(System.getProperty(\"user.dir\"));" + NL + "\t\t\t\t\tjava.net.URL location = null;" + NL + "\t\t\t\t\tlocation = userDir.toURI().toURL();" + NL + "\t\t\t\t\tString pas = null;" + NL + "\t\t\t\t\tif (isExportedAsOSGI)" + NL + "\t\t\t\t\t\tpas = ";
  protected final String TEXT_48 = ".replace(\"file://\", \"classpath://\").replace(\" \", \"%20\");" + NL + "\t\t\t\t\telse" + NL + "\t\t\t\t\t\tpas = ";
  protected final String TEXT_49 = ".replace(\"file://\", location.toString()).replace(\" \", \"%20\");" + NL + "\t\t\t\t\tString projectArchiveArray[] = pas.split(\",\", 0);" + NL + "" + NL + "\t\t\t\t\tfor (int i = 0; i < projectArchiveArray.length; i++) {" + NL + "\t\t\t\t\t\tif (projectArchiveArray[i].length() == 0)" + NL + "\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\tjava.net.URI uri = null;" + NL + "\t\t\t\t\t\turi = new java.net.URI(projectArchiveArray[i]);" + NL + "\t\t\t\t\t\t__tdmRuntime_";
  protected final String TEXT_50 = ".addProjectUri(uri);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_51 = NL + "\t\tmapRuntime_";
  protected final String TEXT_52 = " = __tdmRuntime_";
  protected final String TEXT_53 = ".getMapRuntime(mapPathHelper_";
  protected final String TEXT_54 = ".getMap());" + NL + "    \t";
  protected final String TEXT_55 = ".this.globalMap.put(\"mapRuntime_";
  protected final String TEXT_56 = "\",mapRuntime_";
  protected final String TEXT_57 = ");" + NL + "\t\t}" + NL + "" + NL + "\t} // Synchronized" + NL + "\t" + NL + "\tjava.util.Map<String, Object> ecProps_";
  protected final String TEXT_58 = " = new java.util.HashMap<String, Object>();";
  protected final String TEXT_59 = " " + NL + "\t";
  protected final String TEXT_60 = ".synchronizeContext();" + NL + "        " + NL + "\tjava.util.Enumeration<?> propertyNames_";
  protected final String TEXT_61 = " = ";
  protected final String TEXT_62 = ".propertyNames();" + NL + "\twhile (propertyNames_";
  protected final String TEXT_63 = ".hasMoreElements()) {" + NL + "\t\tString key_";
  protected final String TEXT_64 = " = (String) propertyNames_";
  protected final String TEXT_65 = ".nextElement();" + NL + "\t\tObject value_";
  protected final String TEXT_66 = " = (Object) ";
  protected final String TEXT_67 = ".get(key_";
  protected final String TEXT_68 = ");       " + NL + "\t\tecProps_";
  protected final String TEXT_69 = ".put(\"context.\"+key_";
  protected final String TEXT_70 = ", value_";
  protected final String TEXT_71 = ");" + NL + "\t}" + NL + "        " + NL + "\torg.talend.transform.runtime.api.MapExecutionContext ec_";
  protected final String TEXT_72 = " = __tdmRuntime_";
  protected final String TEXT_73 = ".getMapExecutionContext();" + NL + "\tec_";
  protected final String TEXT_74 = ".setExecutionProperties(ecProps_";
  protected final String TEXT_75 = ");" + NL + "\t";
  protected final String TEXT_76 = NL + "\t\torg.talend.transform.runtime.api.JavaObjectSource source_";
  protected final String TEXT_77 = ";" + NL + "\t\tsource_";
  protected final String TEXT_78 = " = new org.talend.transform.runtime.api.JavaObjectSource(list_";
  protected final String TEXT_79 = ");" + NL + "\t\tif (false)" + NL + "\t\t\tSystem.out.println(\"Source: \" + ((org.talend.transform.runtime.api.JavaObjectSource)source_";
  protected final String TEXT_80 = ").getObject());" + NL + "\t\tec_";
  protected final String TEXT_81 = ".setSource(source_";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL + "\t\tjavax.xml.transform.stream.StreamSource ss_";
  protected final String TEXT_84 = " = null;";
  protected final String TEXT_85 = NL + "\t\t\tss_";
  protected final String TEXT_86 = " = new javax.xml.transform.stream.StreamSource();" + NL + "\t\t\tif (";
  protected final String TEXT_87 = "!=null&&";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = "!=null) {" + NL + "\t\t\t\tss_";
  protected final String TEXT_90 = ".setReader(new java.io.StringReader(";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = "));" + NL + "\t\t\t} else {" + NL + "\t\t\t\tss_";
  protected final String TEXT_93 = ".setReader(new java.io.StringReader(\"\"));" + NL + "\t\t\t}";
  protected final String TEXT_94 = NL + "\t\t\tif (";
  protected final String TEXT_95 = "!=null&&";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = "!=null){" + NL + "\t\t\t\tec_";
  protected final String TEXT_98 = ".setSource(new org.dom4j.io.DocumentSource(((routines.system.Document)";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = ").getDocument()));" + NL + "\t\t\t} else {" + NL + "\t\t\t\tec_";
  protected final String TEXT_101 = ".setSource(new org.dom4j.io.DocumentSource(new routines.system.Document().getDocument()));" + NL + "\t\t\t}";
  protected final String TEXT_102 = NL + "\t\t\tss_";
  protected final String TEXT_103 = " = new javax.xml.transform.stream.StreamSource();" + NL + "\t\t\tss_";
  protected final String TEXT_104 = ".setInputStream(new java.io.ByteArrayInputStream((byte[])";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = "));";
  protected final String TEXT_107 = NL + " \t\t\tif (";
  protected final String TEXT_108 = ".";
  protected final String TEXT_109 = " instanceof java.io.InputStream) {" + NL + "            \tss_";
  protected final String TEXT_110 = " = new javax.xml.transform.stream.StreamSource();" + NL + "            \tss_";
  protected final String TEXT_111 = ".setInputStream((java.io.InputStream)";
  protected final String TEXT_112 = ".";
  protected final String TEXT_113 = ");" + NL + "        \t} else if (";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = " instanceof String) {" + NL + "            \tss_";
  protected final String TEXT_116 = " = new javax.xml.transform.stream.StreamSource();" + NL + "            \tss_";
  protected final String TEXT_117 = ".setReader(new java.io.StringReader((String)";
  protected final String TEXT_118 = ".";
  protected final String TEXT_119 = "));" + NL + "        \t} else if (";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = " instanceof byte[]) {" + NL + "            \tss_";
  protected final String TEXT_122 = " = new javax.xml.transform.stream.StreamSource();" + NL + "            \tss_";
  protected final String TEXT_123 = ".setInputStream(new java.io.ByteArrayInputStream((byte[])";
  protected final String TEXT_124 = ".";
  protected final String TEXT_125 = "));" + NL + "        \t} else if (";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = " instanceof routines.system.Document) {" + NL + "            \tec_";
  protected final String TEXT_128 = ".setSource(new org.dom4j.io.DocumentSource(((routines.system.Document)";
  protected final String TEXT_129 = ".";
  protected final String TEXT_130 = ").getDocument()));" + NL + "        \t}";
  protected final String TEXT_131 = NL + "\t\t\tif (ss_";
  protected final String TEXT_132 = " != null)" + NL + "\t\t\t\tec_";
  protected final String TEXT_133 = ".setSource(ss_";
  protected final String TEXT_134 = ");";
  protected final String TEXT_135 = NL + "\t" + NL + "\t";
  protected final String TEXT_136 = "\t\t\t\t\t" + NL + "\t\tresult_";
  protected final String TEXT_137 = " = new org.talend.transform.runtime.api.JavaObjectResult();" + NL + "    \t";
  protected final String TEXT_138 = ".this.globalMap.put(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_139 = "_\"+\"outputResult\", result_";
  protected final String TEXT_140 = ");";
  protected final String TEXT_141 = "\t\t\t\t\t" + NL + "\t\tresult_";
  protected final String TEXT_142 = " = new javax.xml.transform.stream.StreamResult();" + NL + "        java.io.StringWriter sw_";
  protected final String TEXT_143 = " = new java.io.StringWriter();      " + NL + "\t\t((javax.xml.transform.stream.StreamResult)result_";
  protected final String TEXT_144 = ").setWriter(sw_";
  protected final String TEXT_145 = ");" + NL + "    \t";
  protected final String TEXT_146 = ".this.globalMap.put(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_147 = "_\"+\"outputResult\", sw_";
  protected final String TEXT_148 = ");";
  protected final String TEXT_149 = "\t\t\t\t\t" + NL + "\t\tresult_";
  protected final String TEXT_150 = " = new javax.xml.transform.stream.StreamResult();" + NL + "        java.io.ByteArrayOutputStream bas_";
  protected final String TEXT_151 = " = new java.io.ByteArrayOutputStream();       " + NL + "\t\t((javax.xml.transform.stream.StreamResult)result_";
  protected final String TEXT_152 = ").setOutputStream(bas_";
  protected final String TEXT_153 = ");" + NL + "    \t";
  protected final String TEXT_154 = ".this.globalMap.put(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_155 = "_\"+\"outputResult\", bas_";
  protected final String TEXT_156 = ");";
  protected final String TEXT_157 = "\t\t\t\t\t" + NL + "\t\t// Don't store in globalMap - that's done later with the actual InputStream" + NL + "\t\tresult_";
  protected final String TEXT_158 = " = new javax.xml.transform.stream.StreamResult();";
  protected final String TEXT_159 = "\t\t\t\t\t" + NL + "\t\tresult_";
  protected final String TEXT_160 = " = new org.dom4j.io.DocumentResult();" + NL + "    \t";
  protected final String TEXT_161 = ".this.globalMap.put(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_162 = "_\"+\"outputResult\", result_";
  protected final String TEXT_163 = ");";
  protected final String TEXT_164 = NL + "\tec_";
  protected final String TEXT_165 = ".setResult(result_";
  protected final String TEXT_166 = ");" + NL + "\torg.talend.transform.runtime.api.ExecutionStatus results_";
  protected final String TEXT_167 = " = ec_";
  protected final String TEXT_168 = ".getExecutionStatus();" + NL + "\t";
  protected final String TEXT_169 = ".this.globalMap.put(\"";
  protected final String TEXT_170 = "_\"+\"EXECUTION_STATUS\",results_";
  protected final String TEXT_171 = ");\t";
  protected final String TEXT_172 = NL + "\t\t// Runs the map when the InputStream is accessed\t\t\t\t\t" + NL + "    \t";
  protected final String TEXT_173 = ".this.globalMap.put(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_174 = "_\"+\"outputResult\", mapRuntime_";
  protected final String TEXT_175 = ".getResultAsInputStream(ec_";
  protected final String TEXT_176 = "));";
  protected final String TEXT_177 = "\t\t\t\t\t" + NL + "\t\tmapRuntime_";
  protected final String TEXT_178 = ".run(ec_";
  protected final String TEXT_179 = ");" + NL + "    \t";
  protected final String TEXT_180 = ".this.globalMap.put(\"";
  protected final String TEXT_181 = "_\"+\"EXECUTION_SEVERITY\",results_";
  protected final String TEXT_182 = ".getOverallSeverity());" + NL + "    \tif (results_";
  protected final String TEXT_183 = ".getOverallSeverity()>=";
  protected final String TEXT_184 = ") {" + NL + "\t    \tthrow new TalendException(new java.lang.Exception(String.valueOf(results_";
  protected final String TEXT_185 = ")),currentComponent,globalMap);" + NL + "\t\t}";
  protected final String TEXT_186 = NL + NL + "    if (results_";
  protected final String TEXT_187 = ".getOverallSeverity() > org.talend.transform.runtime.api.ExecutionStatus.STATUS_INFO) {" + NL + "        System.err.println(results_";
  protected final String TEXT_188 = ");" + NL + "    }\t\t\t";
  protected final String TEXT_189 = NL;
  protected final String TEXT_190 = NL + "    java.io.StringWriter swOut_";
  protected final String TEXT_191 = " = (java.io.StringWriter)";
  protected final String TEXT_192 = ".this.globalMap.get(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_193 = "_\"+\"outputResult\");" + NL + "    if (swOut_";
  protected final String TEXT_194 = " != null)" + NL + " \t\t";
  protected final String TEXT_195 = ".";
  protected final String TEXT_196 = " = swOut_";
  protected final String TEXT_197 = ".toString();";
  protected final String TEXT_198 = NL + "\tjava.io.ByteArrayOutputStream basOut_";
  protected final String TEXT_199 = " = (java.io.ByteArrayOutputStream)";
  protected final String TEXT_200 = ".this.globalMap.get(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_201 = "_\"+\"outputResult\");" + NL + "    if (basOut_";
  protected final String TEXT_202 = " != null)" + NL + " \t    ";
  protected final String TEXT_203 = ".";
  protected final String TEXT_204 = " = (byte[])basOut_";
  protected final String TEXT_205 = ".toByteArray();";
  protected final String TEXT_206 = NL + "\t";
  protected final String TEXT_207 = ".";
  protected final String TEXT_208 = " = (java.io.InputStream)";
  protected final String TEXT_209 = ".this.globalMap.get(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_210 = "_\"+\"outputResult\");";
  protected final String TEXT_211 = NL + "  \t";
  protected final String TEXT_212 = ".";
  protected final String TEXT_213 = " = new routines.system.Document();" + NL + "\torg.dom4j.io.DocumentResult drOut_";
  protected final String TEXT_214 = " = (org.dom4j.io.DocumentResult)";
  protected final String TEXT_215 = ".this.globalMap.get(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_216 = "_\"+\"outputResult\");" + NL + "    if (drOut_";
  protected final String TEXT_217 = " != null)" + NL + " \t    ((routines.system.Document)";
  protected final String TEXT_218 = ".";
  protected final String TEXT_219 = ").setDocument(drOut_";
  protected final String TEXT_220 = ".getDocument()); \t";
  protected final String TEXT_221 = "\t" + NL;
  protected final String TEXT_222 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String this_cid = ElementParameterParser.getValue(node, "__UNIQUE_NAME__");
	String tHMap_id = this_cid;
	String cid = tHMap_id;
	INode tHMapNode = node;	

	boolean sourceAsMap = "true".equals(ElementParameterParser.getValue(node, "__SOURCE_AS_MAP__"));

    stringBuffer.append(TEXT_2);
    
	// Fills the dependency property of the component
	Set<String> projects = ((MapperComponent)tHMapNode.getExternalNode()).populateDependencies(0);
	Set<String> projectArchiveSet = ((MapperComponent)tHMapNode.getExternalNode()).populateDependencies(MapperComponent.DEP_FOR_PROJECT_ARCHIVE);

    String mapPath = ElementParameterParser.getValue(node, "__HMAP_PATH__");
	mapPath = ((MapperComponent)tHMapNode.getExternalNode()).makeAbsoluteMapPath(mapPath);
	mapPath = MapperComponent.fixMapPath(mapPath);
	
	String mapVarPath = ElementParameterParser.getValue(node, "__HMAP_VAR_PATH__");
	mapVarPath = TalendTextUtils.removeQuotes(mapVarPath);
	mapVarPath = ((MapperComponent)tHMapNode.getExternalNode()).toPortableString(mapVarPath);
	
	String log = ElementParameterParser.getValue(node, "__LOG__");

	StringBuffer pa = new StringBuffer();
	for (String project : projectArchiveSet) {
	    if (pa.toString().length() > 0) {
	       pa.append(",");
	    }
		pa.append("file://__tdm/" + project.replace(" ", "%20") + ".zip");
	}
	String projectArchives = pa.toString();
	projectArchives = TalendTextUtils.addQuotes(projectArchives);    

	boolean asMap = "true".equals(ElementParameterParser.getValue(node, "__AS_MAP__"));
	boolean asString = "true".equals(ElementParameterParser.getValue(node, "__AS_STRING__"));
	boolean asBytearray = "true".equals(ElementParameterParser.getValue(node, "__AS_BYTEARRAY__"));
	boolean asInputstream = "true".equals(ElementParameterParser.getValue(node, "__AS_INPUTSTREAM__"));
	boolean asDocument = "true".equals(ElementParameterParser.getValue(node, "__AS_DOCUMENT__"));
	
    String devWorkspace = ElementParameterParser.getValue(node.getProcess(), "__COMP_DEFAULT_FILE_DIR__");
	devWorkspace = TalendTextUtils.addQuotes(devWorkspace);    
    String devInstall = ElementParameterParser.getValue(node.getProcess(), "__PRODUCT_ROOT_DIR__");
	devInstall = TalendTextUtils.addQuotes(devInstall);    
    
    Integer exceptionLevel = Integer.parseInt(ElementParameterParser.getValue(node, "__EXCEPTION__")); 

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    	
	if (mapVarPath != null && !"".equals(mapVarPath.trim())) {
		if (mapVarPath.startsWith("context.")) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(mapVarPath);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(devWorkspace);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(mapPath);
    stringBuffer.append(TEXT_11);
    
    } else {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(mapVarPath);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(devWorkspace);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(mapPath);
    stringBuffer.append(TEXT_16);
    
    }} else {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(devWorkspace);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(mapPath);
    stringBuffer.append(TEXT_20);
    
    }

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
			if (!org.talend.designer.runprocess.ProcessorUtilities.isExportConfig()) {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(devInstall);
    stringBuffer.append(TEXT_25);
    
        	} else {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
        	}

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(log);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
		if (!org.talend.designer.runprocess.ProcessorUtilities.isExportConfig()) {
			for (String project : projects) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(project);
    stringBuffer.append(TEXT_43);
    
			} 
		} else {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(projectArchives);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(projectArchives);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
		} // isExportConfig

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
     
    String localContext = "context";

    stringBuffer.append(TEXT_59);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
	if (sourceAsMap) {

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
	} else {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
		if (tHMapNode.getIncomingConnections()!=null) {
			for (IConnection incomingConn : tHMapNode.getIncomingConnections()) {
			if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {							
					IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
					for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
						if (JavaTypesManager.STRING.getId().equals(inputCol.getTalendType())) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
						} else if ("id_Document".equals(inputCol.getTalendType())) {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
                        } else if ("id_byte[]".equals(inputCol.getTalendType())) {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_106);
    
						} else {

    stringBuffer.append(TEXT_107);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_130);
    
		              } // if
		       		break;
					} // for

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
				} // if 
			} // for			

					} // if
	} // if (sourceAsMap)

    stringBuffer.append(TEXT_135);
    
	if(asMap) {

    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
	} else if (asString) {

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
	} else if (asBytearray) {

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    
	} else if (asInputstream) {

    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
	} else if (asDocument) {

    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append( node.getProcess().getName() );
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
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    
	if (asInputstream) {

    stringBuffer.append(TEXT_172);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
	} else {

    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(exceptionLevel);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    
	}
		
if(!org.talend.designer.runprocess.ProcessorUtilities.isExportConfig()){

    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    
}

    stringBuffer.append(TEXT_189);
    
	if (node.getOutgoingConnections()!=null) {
		java.util.Set<IConnection> dataConns = new java.util.HashSet<IConnection>();	
		for (IConnection outgoingConn : node.getOutgoingConnections()) {
		if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		dataConns.add(outgoingConn);	
		}
		}
		for (IConnection outgoingConn : node.getOutgoingConnections()) {
			if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				String outputConnName = outgoingConn.getName();
				IMetadataTable outputMetadataTable = outgoingConn.getMetadataTable();
				for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
					if (asString) {

    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
						break;
					} else if (asBytearray) {

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    
						break;
					} else if (asInputstream) {

    stringBuffer.append(TEXT_206);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_208);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    
						break;
					} else if (asDocument) {

    stringBuffer.append(TEXT_211);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    
						break;
					}
				}
				break;
			}
		}		
	}

    stringBuffer.append(TEXT_221);
    stringBuffer.append(TEXT_222);
    return stringBuffer.toString();
  }
}
