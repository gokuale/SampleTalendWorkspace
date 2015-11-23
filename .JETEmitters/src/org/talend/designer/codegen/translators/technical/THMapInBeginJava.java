package org.talend.designer.codegen.translators.technical;

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

public class THMapInBeginJava
{
  protected static String nl;
  public static synchronized THMapInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THMapInBeginJava result = new THMapInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    ";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + "java.util.List<java.util.Map<String, Object>> list_result_";
  protected final String TEXT_4 = " = (java.util.List<java.util.Map<String, Object>>)globalMap.get(Thread" + NL + "                .currentThread().getId()+\"_list_result_";
  protected final String TEXT_5 = "\");" + NL + "if (list_result_";
  protected final String TEXT_6 = " != null && list_result_";
  protected final String TEXT_7 = ".size() > 0) {";
  protected final String TEXT_8 = NL + "    ";
  protected final String TEXT_9 = " = new ";
  protected final String TEXT_10 = "Struct();";
  protected final String TEXT_11 = NL + "\t";
  protected final String TEXT_12 = NL + "    javax.xml.transform.Result result_";
  protected final String TEXT_13 = " = null; " + NL + "   \torg.talend.transform.runtime.api.RuntimeEngine __tdmRuntime_";
  protected final String TEXT_14 = " = null;" + NL + "   \torg.talend.transform.runtime.api.MapRuntime mapRuntime_";
  protected final String TEXT_15 = " = null;";
  protected final String TEXT_16 = NL + "   \torg.talend.transform.runtime.api.MapPathHelper mapPathHelper_";
  protected final String TEXT_17 = " = new org.talend.transform.runtime.api.MapPathHelper(";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = ", null, ";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\torg.talend.transform.runtime.api.MapPathHelper mapPathHelper_";
  protected final String TEXT_22 = " = new org.talend.transform.runtime.api.MapPathHelper(\"";
  protected final String TEXT_23 = "\", ";
  protected final String TEXT_24 = ", null, ";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\torg.talend.transform.runtime.api.MapPathHelper mapPathHelper_";
  protected final String TEXT_27 = " = new org.talend.transform.runtime.api.MapPathHelper(null, ";
  protected final String TEXT_28 = ", null, ";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + NL + "    synchronized (routines.system.RuntimeMap.getInstance().getRuntimeMap()) {" + NL + "    " + NL + "    \tif (routines.system.RuntimeMap.getInstance().getRuntimeMap().containsKey(\"__tdmRuntime\")) {" + NL + "        \t__tdmRuntime_";
  protected final String TEXT_31 = " = (org.talend.transform.runtime.api.RuntimeEngine) routines.system.RuntimeMap.getInstance().getRuntimeMap().get(\"__tdmRuntime\");" + NL + "    \t} else {";
  protected final String TEXT_32 = NL + "        \t\tSystem.setProperty(org.talend.transform.runtime.api.RuntimeFactory.ODT_DEV_WORKSPACE_VAR, mapPathHelper_";
  protected final String TEXT_33 = ".getWorkspace());" + NL + "        \t\tSystem.setProperty(org.talend.transform.runtime.api.RuntimeFactory.ODT_DEV_INSTALL_VAR, ";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "\t\t\tif (mapPathHelper_";
  protected final String TEXT_36 = ".isValidMapPath()) {" + NL + "\t\t\t\tSystem.setProperty(org.talend.transform.runtime.api.RuntimeFactory.ODT_DEV_WORKSPACE_VAR, mapPathHelper_";
  protected final String TEXT_37 = ".getWorkspace());" + NL + "\t\t\t}";
  protected final String TEXT_38 = NL + "        \t__tdmRuntime_";
  protected final String TEXT_39 = " = org.talend.transform.runtime.api.RuntimeFactory.createRuntime();" + NL + "        \t__tdmRuntime_";
  protected final String TEXT_40 = ".setLogging(\"";
  protected final String TEXT_41 = "\", org.talend.transform.runtime.api.RuntimeEngine.LOG_DEST_CONSOLE);" + NL + "            routines.system.RuntimeMap.getInstance().getRuntimeMap().put(\"__tdmRuntime\",__tdmRuntime_";
  protected final String TEXT_42 = ");" + NL + "\t\t}" + NL + "    " + NL + "    \tif (";
  protected final String TEXT_43 = ".this.globalMap.containsKey(\"mapRuntime_";
  protected final String TEXT_44 = "\")) {" + NL + "        \tmapRuntime_";
  protected final String TEXT_45 = " = (org.talend.transform.runtime.api.MapRuntime) ";
  protected final String TEXT_46 = ".this.globalMap.get(\"mapRuntime_";
  protected final String TEXT_47 = "\");" + NL + "    \t} else {";
  protected final String TEXT_48 = NL + "            \t__tdmRuntime_";
  protected final String TEXT_49 = ".addProjectDevLink(mapPathHelper_";
  protected final String TEXT_50 = ".isValidMapPath() ? mapPathHelper_";
  protected final String TEXT_51 = ".getProjectName() : \"";
  protected final String TEXT_52 = "\");";
  protected final String TEXT_53 = NL + "\t\t\t\tif (mapPathHelper_";
  protected final String TEXT_54 = ".isValidMapPath()) {" + NL + "\t\t\t\t\t__tdmRuntime_";
  protected final String TEXT_55 = ".addProjectDevLink(mapPathHelper_";
  protected final String TEXT_56 = ".getProjectName());" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tjava.io.File userDir = new java.io.File(System.getProperty(\"user.dir\"));" + NL + "\t\t\t\t\tjava.net.URL location = null;" + NL + "\t\t\t\t\tlocation = userDir.toURI().toURL();" + NL + "\t\t\t\t\tString pas = null;" + NL + "\t\t\t\t\tif (isExportedAsOSGI)" + NL + "\t\t\t\t\t\tpas = ";
  protected final String TEXT_57 = ".replace(\"file://\", \"classpath://\").replace(\" \", \"%20\");" + NL + "\t\t\t\t\telse" + NL + "\t\t\t\t\t\tpas = ";
  protected final String TEXT_58 = ".replace(\"file://\", location.toString()).replace(\" \", \"%20\");" + NL + "\t\t\t\t\tString projectArchiveArray[] = pas.split(\",\", 0);" + NL + "" + NL + "\t\t\t\t\tfor (int i = 0; i < projectArchiveArray.length; i++) {" + NL + "\t\t\t\t\t\tif (projectArchiveArray[i].length() == 0)" + NL + "\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\tjava.net.URI uri = null;" + NL + "\t\t\t\t\t\turi = new java.net.URI(projectArchiveArray[i]);" + NL + "\t\t\t\t\t\t__tdmRuntime_";
  protected final String TEXT_59 = ".addProjectUri(uri);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_60 = NL + "\t\tmapRuntime_";
  protected final String TEXT_61 = " = __tdmRuntime_";
  protected final String TEXT_62 = ".getMapRuntime(mapPathHelper_";
  protected final String TEXT_63 = ".getMap());" + NL + "    \t";
  protected final String TEXT_64 = ".this.globalMap.put(\"mapRuntime_";
  protected final String TEXT_65 = "\",mapRuntime_";
  protected final String TEXT_66 = ");" + NL + "\t\t}" + NL + "" + NL + "\t} // Synchronized" + NL + "\t" + NL + "\tjava.util.Map<String, Object> ecProps_";
  protected final String TEXT_67 = " = new java.util.HashMap<String, Object>();";
  protected final String TEXT_68 = " " + NL + "\t";
  protected final String TEXT_69 = ".synchronizeContext();" + NL + "        " + NL + "\tjava.util.Enumeration<?> propertyNames_";
  protected final String TEXT_70 = " = ";
  protected final String TEXT_71 = ".propertyNames();" + NL + "\twhile (propertyNames_";
  protected final String TEXT_72 = ".hasMoreElements()) {" + NL + "\t\tString key_";
  protected final String TEXT_73 = " = (String) propertyNames_";
  protected final String TEXT_74 = ".nextElement();" + NL + "\t\tObject value_";
  protected final String TEXT_75 = " = (Object) ";
  protected final String TEXT_76 = ".get(key_";
  protected final String TEXT_77 = ");       " + NL + "\t\tecProps_";
  protected final String TEXT_78 = ".put(\"context.\"+key_";
  protected final String TEXT_79 = ", value_";
  protected final String TEXT_80 = ");" + NL + "\t}" + NL + "        " + NL + "\torg.talend.transform.runtime.api.MapExecutionContext ec_";
  protected final String TEXT_81 = " = __tdmRuntime_";
  protected final String TEXT_82 = ".getMapExecutionContext();" + NL + "\tec_";
  protected final String TEXT_83 = ".setExecutionProperties(ecProps_";
  protected final String TEXT_84 = ");" + NL + "\t";
  protected final String TEXT_85 = NL + "\t\torg.talend.transform.runtime.api.JavaObjectSource source_";
  protected final String TEXT_86 = ";" + NL + "\t\tsource_";
  protected final String TEXT_87 = " = new org.talend.transform.runtime.api.JavaObjectSource(list_";
  protected final String TEXT_88 = ");" + NL + "\t\tif (false)" + NL + "\t\t\tSystem.out.println(\"Source: \" + ((org.talend.transform.runtime.api.JavaObjectSource)source_";
  protected final String TEXT_89 = ").getObject());" + NL + "\t\tec_";
  protected final String TEXT_90 = ".setSource(source_";
  protected final String TEXT_91 = ");";
  protected final String TEXT_92 = NL + "\t\tjavax.xml.transform.stream.StreamSource ss_";
  protected final String TEXT_93 = " = null;";
  protected final String TEXT_94 = NL + "\t\t\tss_";
  protected final String TEXT_95 = " = new javax.xml.transform.stream.StreamSource();" + NL + "\t\t\tif (";
  protected final String TEXT_96 = "!=null&&";
  protected final String TEXT_97 = ".";
  protected final String TEXT_98 = "!=null) {" + NL + "\t\t\t\tss_";
  protected final String TEXT_99 = ".setReader(new java.io.StringReader(";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = "));" + NL + "\t\t\t} else {" + NL + "\t\t\t\tss_";
  protected final String TEXT_102 = ".setReader(new java.io.StringReader(\"\"));" + NL + "\t\t\t}";
  protected final String TEXT_103 = NL + "\t\t\tif (";
  protected final String TEXT_104 = "!=null&&";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = "!=null){" + NL + "\t\t\t\tec_";
  protected final String TEXT_107 = ".setSource(new org.dom4j.io.DocumentSource(((routines.system.Document)";
  protected final String TEXT_108 = ".";
  protected final String TEXT_109 = ").getDocument()));" + NL + "\t\t\t} else {" + NL + "\t\t\t\tec_";
  protected final String TEXT_110 = ".setSource(new org.dom4j.io.DocumentSource(new routines.system.Document().getDocument()));" + NL + "\t\t\t}";
  protected final String TEXT_111 = NL + "\t\t\tss_";
  protected final String TEXT_112 = " = new javax.xml.transform.stream.StreamSource();" + NL + "\t\t\tss_";
  protected final String TEXT_113 = ".setInputStream(new java.io.ByteArrayInputStream((byte[])";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = "));";
  protected final String TEXT_116 = NL + " \t\t\tif (";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = " instanceof java.io.InputStream) {" + NL + "            \tss_";
  protected final String TEXT_119 = " = new javax.xml.transform.stream.StreamSource();" + NL + "            \tss_";
  protected final String TEXT_120 = ".setInputStream((java.io.InputStream)";
  protected final String TEXT_121 = ".";
  protected final String TEXT_122 = ");" + NL + "        \t} else if (";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = " instanceof String) {" + NL + "            \tss_";
  protected final String TEXT_125 = " = new javax.xml.transform.stream.StreamSource();" + NL + "            \tss_";
  protected final String TEXT_126 = ".setReader(new java.io.StringReader((String)";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = "));" + NL + "        \t} else if (";
  protected final String TEXT_129 = ".";
  protected final String TEXT_130 = " instanceof byte[]) {" + NL + "            \tss_";
  protected final String TEXT_131 = " = new javax.xml.transform.stream.StreamSource();" + NL + "            \tss_";
  protected final String TEXT_132 = ".setInputStream(new java.io.ByteArrayInputStream((byte[])";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = "));" + NL + "        \t} else if (";
  protected final String TEXT_135 = ".";
  protected final String TEXT_136 = " instanceof routines.system.Document) {" + NL + "            \tec_";
  protected final String TEXT_137 = ".setSource(new org.dom4j.io.DocumentSource(((routines.system.Document)";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = ").getDocument()));" + NL + "        \t}";
  protected final String TEXT_140 = NL + "\t\t\tif (ss_";
  protected final String TEXT_141 = " != null)" + NL + "\t\t\t\tec_";
  protected final String TEXT_142 = ".setSource(ss_";
  protected final String TEXT_143 = ");";
  protected final String TEXT_144 = NL + "\t" + NL + "\t";
  protected final String TEXT_145 = "\t\t\t\t\t" + NL + "\t\tresult_";
  protected final String TEXT_146 = " = new org.talend.transform.runtime.api.JavaObjectResult();" + NL + "    \t";
  protected final String TEXT_147 = ".this.globalMap.put(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_148 = "_\"+\"outputResult\", result_";
  protected final String TEXT_149 = ");";
  protected final String TEXT_150 = "\t\t\t\t\t" + NL + "\t\tresult_";
  protected final String TEXT_151 = " = new javax.xml.transform.stream.StreamResult();" + NL + "        java.io.StringWriter sw_";
  protected final String TEXT_152 = " = new java.io.StringWriter();      " + NL + "\t\t((javax.xml.transform.stream.StreamResult)result_";
  protected final String TEXT_153 = ").setWriter(sw_";
  protected final String TEXT_154 = ");" + NL + "    \t";
  protected final String TEXT_155 = ".this.globalMap.put(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_156 = "_\"+\"outputResult\", sw_";
  protected final String TEXT_157 = ");";
  protected final String TEXT_158 = "\t\t\t\t\t" + NL + "\t\tresult_";
  protected final String TEXT_159 = " = new javax.xml.transform.stream.StreamResult();" + NL + "        java.io.ByteArrayOutputStream bas_";
  protected final String TEXT_160 = " = new java.io.ByteArrayOutputStream();       " + NL + "\t\t((javax.xml.transform.stream.StreamResult)result_";
  protected final String TEXT_161 = ").setOutputStream(bas_";
  protected final String TEXT_162 = ");" + NL + "    \t";
  protected final String TEXT_163 = ".this.globalMap.put(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_164 = "_\"+\"outputResult\", bas_";
  protected final String TEXT_165 = ");";
  protected final String TEXT_166 = "\t\t\t\t\t" + NL + "\t\t// Don't store in globalMap - that's done later with the actual InputStream" + NL + "\t\tresult_";
  protected final String TEXT_167 = " = new javax.xml.transform.stream.StreamResult();";
  protected final String TEXT_168 = "\t\t\t\t\t" + NL + "\t\tresult_";
  protected final String TEXT_169 = " = new org.dom4j.io.DocumentResult();" + NL + "    \t";
  protected final String TEXT_170 = ".this.globalMap.put(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_171 = "_\"+\"outputResult\", result_";
  protected final String TEXT_172 = ");";
  protected final String TEXT_173 = NL + "\tec_";
  protected final String TEXT_174 = ".setResult(result_";
  protected final String TEXT_175 = ");" + NL + "\torg.talend.transform.runtime.api.ExecutionStatus results_";
  protected final String TEXT_176 = " = ec_";
  protected final String TEXT_177 = ".getExecutionStatus();" + NL + "\t";
  protected final String TEXT_178 = ".this.globalMap.put(\"";
  protected final String TEXT_179 = "_\"+\"EXECUTION_STATUS\",results_";
  protected final String TEXT_180 = ");\t";
  protected final String TEXT_181 = NL + "\t\t// Runs the map when the InputStream is accessed\t\t\t\t\t" + NL + "    \t";
  protected final String TEXT_182 = ".this.globalMap.put(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_183 = "_\"+\"outputResult\", mapRuntime_";
  protected final String TEXT_184 = ".getResultAsInputStream(ec_";
  protected final String TEXT_185 = "));";
  protected final String TEXT_186 = "\t\t\t\t\t" + NL + "\t\tmapRuntime_";
  protected final String TEXT_187 = ".run(ec_";
  protected final String TEXT_188 = ");" + NL + "    \t";
  protected final String TEXT_189 = ".this.globalMap.put(\"";
  protected final String TEXT_190 = "_\"+\"EXECUTION_SEVERITY\",results_";
  protected final String TEXT_191 = ".getOverallSeverity());" + NL + "    \tif (results_";
  protected final String TEXT_192 = ".getOverallSeverity()>=";
  protected final String TEXT_193 = ") {" + NL + "\t    \tthrow new TalendException(new java.lang.Exception(String.valueOf(results_";
  protected final String TEXT_194 = ")),currentComponent,globalMap);" + NL + "\t\t}";
  protected final String TEXT_195 = NL + NL + "    if (results_";
  protected final String TEXT_196 = ".getOverallSeverity() > org.talend.transform.runtime.api.ExecutionStatus.STATUS_INFO) {" + NL + "        System.err.println(results_";
  protected final String TEXT_197 = ");" + NL + "    }\t\t\t";
  protected final String TEXT_198 = NL;
  protected final String TEXT_199 = "\t\t\t\t\t" + NL + "\torg.talend.transform.runtime.api.JavaObjectResult javaResult_";
  protected final String TEXT_200 = " = (org.talend.transform.runtime.api.JavaObjectResult)";
  protected final String TEXT_201 = ".this.globalMap.get(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_202 = "_\"+\"outputResult\");" + NL + "\tjava.util.List<java.util.Map<String, Object>> outList_";
  protected final String TEXT_203 = ";" + NL + "\tif (javaResult_";
  protected final String TEXT_204 = " != null) {" + NL + "\t    outList_";
  protected final String TEXT_205 = " = (java.util.List)javaResult_";
  protected final String TEXT_206 = ".getObject();" + NL + "\t    if (outList_";
  protected final String TEXT_207 = " != null) {" + NL + "\t    for (java.util.Map<String, Object> outMap : outList_";
  protected final String TEXT_208 = ") {" + NL;
  protected final String TEXT_209 = "\t\t\t\t\t" + NL;
  protected final String TEXT_210 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String this_cid = ElementParameterParser.getValue(node, "__UNIQUE_NAME__");
	String tHMap_id = this_cid.replace("_THMAP_IN", "");
	String cid = tHMap_id;

	// To not conflict with the included asMap in _runmap below
	boolean asMap_ = "true".equals(ElementParameterParser.getValue(node, "__AS_MAP__"));

    
	INode tHMapNode = node;	
	java.util.List<? extends INode> nodes = node.getProcess().getGraphicalNodes();
	for (INode loopNode : nodes) {
		if(loopNode.getUniqueName().equals(tHMap_id)) {
			tHMapNode = loopNode;
			break;
		}
	}

    
    if (tHMapNode != null) {
        java.util.List< ? extends IConnection> outConns = tHMapNode.getOutgoingSortedConnections();
        if (outConns != null & outConns.size() > 0 ) {
            for (IConnection conn:  outConns) {
                if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA) ) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_2);
    
                }
            }
        }
    }

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
    if (tHMapNode != null) {
        java.util.List< ? extends IConnection> outConns = tHMapNode.getOutgoingSortedConnections();
        if (outConns != null & outConns.size() > 0 ) {
            for (IConnection conn:  outConns) {
                if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA) ) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_10);
    
                }
            }
        }
    } // tHMapNode != null

    

	boolean sourceAsMap = "true".equals(ElementParameterParser.getValue(node, "__SOURCE_AS_MAP__"));
	if (sourceAsMap) {

    stringBuffer.append(TEXT_11);
    
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

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    	
	if (mapVarPath != null && !"".equals(mapVarPath.trim())) {
		if (mapVarPath.startsWith("context.")) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(mapVarPath);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(devWorkspace);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(mapPath);
    stringBuffer.append(TEXT_20);
    
    } else {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(mapVarPath);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(devWorkspace);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(mapPath);
    stringBuffer.append(TEXT_25);
    
    }} else {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(devWorkspace);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(mapPath);
    stringBuffer.append(TEXT_29);
    
    }

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
			if (!org.talend.designer.runprocess.ProcessorUtilities.isExportConfig()) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(devInstall);
    stringBuffer.append(TEXT_34);
    
        	} else {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
        	}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(log);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
		if (!org.talend.designer.runprocess.ProcessorUtilities.isExportConfig()) {
			for (String project : projects) {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(project);
    stringBuffer.append(TEXT_52);
    
			} 
		} else {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(projectArchives);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(projectArchives);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
		} // isExportConfig

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
     
    String localContext = "context";

    stringBuffer.append(TEXT_68);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
	if (sourceAsMap) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
	} else {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
		if (tHMapNode.getIncomingConnections()!=null) {
			for (IConnection incomingConn : tHMapNode.getIncomingConnections()) {
			if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {							
					IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
					for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
						if (JavaTypesManager.STRING.getId().equals(inputCol.getTalendType())) {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
						} else if ("id_Document".equals(inputCol.getTalendType())) {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
                        } else if ("id_byte[]".equals(inputCol.getTalendType())) {

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_115);
    
						} else {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(incomingConn.getName() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_139);
    
		              } // if
		       		break;
					} // for

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    
				} // if 
			} // for			

					} // if
	} // if (sourceAsMap)

    stringBuffer.append(TEXT_144);
    
	if(asMap) {

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
	} else if (asString) {

    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
	} else if (asBytearray) {

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
	} else if (asInputstream) {

    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    
	} else if (asDocument) {

    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    
	}

    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    
	if (asInputstream) {

    stringBuffer.append(TEXT_181);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    
	} else {

    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(exceptionLevel);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
	}
		
if(!org.talend.designer.runprocess.ProcessorUtilities.isExportConfig()){

    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
}

    
	}

    stringBuffer.append(TEXT_198);
    
	if (asMap_) {

    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    
	} // if (asMap_)

    stringBuffer.append(TEXT_209);
    stringBuffer.append(TEXT_210);
    return stringBuffer.toString();
  }
}
