package org.talend.designer.codegen.translators.databases.hbase;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.common.tmap.TMapAdapter;

public class THBaseLookupInputSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized THBaseLookupInputSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseLookupInputSparkstreamingcodeJava result = new THBaseLookupInputSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "\t\t\t\tbyte[] bytesResult = null;" + NL + "\t\t\t\tString stringResult = null;";
  protected final String TEXT_5 = NL + "\t\t\t\tbytesResult = scannerResult.getValue(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_6 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(\"";
  protected final String TEXT_7 = "\"));" + NL + "\t\t\t\tstringResult = org.apache.hadoop.hbase.util.Bytes.toString(bytesResult);" + NL + "\t\t\t\tif(stringResult != null && stringResult.length() > 0) {";
  protected final String TEXT_8 = NL + "\t\t\t\t\t";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = " = stringResult;";
  protected final String TEXT_11 = " " + NL + "\t\t\t\t\t";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " = java.nio.ByteBuffer.wrap(bytesResult);";
  protected final String TEXT_14 = " " + NL + "\t\t\t\t\t";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = " = BigDataParserUtils.parseTo_Date(stringResult, ";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t\t\t\t\t";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = " = org.apache.hadoop.hbase.util.Bytes.toInt(bytesResult);  ";
  protected final String TEXT_21 = NL + "\t\t\t\t\t";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = " = (char) org.apache.hadoop.hbase.util.Bytes.toInt(bytesResult);  ";
  protected final String TEXT_24 = NL + "\t\t\t\t\t";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = " = org.apache.hadoop.hbase.util.Bytes.to";
  protected final String TEXT_27 = "(bytesResult);  ";
  protected final String TEXT_28 = NL + "\t\t\t\t\t";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = " = BigDataParserUtils.parseTo_";
  protected final String TEXT_31 = "(stringResult);";
  protected final String TEXT_32 = NL + "\t\t\t\t}else{";
  protected final String TEXT_33 = NL + "\t\t\t\t\t";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " = ";
  protected final String TEXT_36 = ";";
  protected final String TEXT_37 = NL + "\t\t\t\t\t";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = " = null;";
  protected final String TEXT_40 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_41 = "' in '";
  protected final String TEXT_42 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t}";
  protected final String TEXT_44 = NL;
  protected final String TEXT_45 = NL + NL + "public static class ";
  protected final String TEXT_46 = "_FlatMapper extends org.talend.bigdata.dataflow.hmap.HMapContextConfigurableBase implements org.talend.bigdata.dataflow.functions.FlatMapper<org.apache.avro.generic.IndexedRecord, ";
  protected final String TEXT_47 = "> {" + NL + "" + NL + "\tprivate transient org.apache.hadoop.conf.Configuration conf;" + NL + "\tprivate transient org.apache.hadoop.hbase.client.HTable table;" + NL + "" + NL + "\tprivate ContextProperties context;" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_48 = "_FlatMapper(JobConf job) {" + NL + "\t\tthis.context = new ContextProperties(job);" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic void prepare() throws Exception {" + NL + "\t\tconf = org.apache.hadoop.hbase.HBaseConfiguration.create();" + NL + "\t\tconf.set(\"hbase.zookeeper.quorum\", ";
  protected final String TEXT_49 = ");" + NL + "\t\tconf.set(\"hbase.zookeeper.property.clientPort\", ";
  protected final String TEXT_50 = ");" + NL + "\t\tconf.set(\"hbase.cluster.distributed\", \"true\");";
  protected final String TEXT_51 = NL + "\t\tconf.set(\"zookeeper.znode.parent\", ";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\t\tconf.set(\"hbase.table.namespace.mappings\", ";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "\t\tconf.set(\"hbase.master.kerberos.principal\", ";
  protected final String TEXT_56 = ");" + NL + "\t\tconf.set(\"hbase.regionserver.kerberos.principal\", ";
  protected final String TEXT_57 = ");" + NL + "\t\tconf.set(\"hbase.security.authorization\", \"true\");" + NL + "\t\tconf.set(\"hbase.security.authentication\", \"kerberos\");";
  protected final String TEXT_58 = NL + "\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_59 = ", ";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\t\tconf.set(";
  protected final String TEXT_62 = ",";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + NL + "\t\ttable = new org.apache.hadoop.hbase.client.HTable(conf, ";
  protected final String TEXT_65 = ");" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic Iterable<";
  protected final String TEXT_66 = "> flatMap(org.apache.avro.generic.IndexedRecord joinKeys) throws Exception {" + NL + "\t\tList<";
  protected final String TEXT_67 = "> result = new ArrayList<>();" + NL + "\t\t";
  protected final String TEXT_68 = " ";
  protected final String TEXT_69 = " = getHMapContext().getInputRecord(\"";
  protected final String TEXT_70 = "\");" + NL + "" + NL + "\t\torg.apache.hadoop.hbase.client.ResultScanner resultScanner = table.getScanner(getScan(";
  protected final String TEXT_71 = "));" + NL + "\t\ttry {" + NL + "\t\t\tfor (org.apache.hadoop.hbase.client.Result scannerResult = resultScanner.next(); scannerResult != null; scannerResult = resultScanner.next()) {" + NL + "        \t\t";
  protected final String TEXT_72 = " ";
  protected final String TEXT_73 = " = new ";
  protected final String TEXT_74 = "();";
  protected final String TEXT_75 = NL + "\t\t\t\tresult.add(";
  protected final String TEXT_76 = ");" + NL + "    \t\t}" + NL + "\t\t} catch (Exception e) {" + NL + "    \t\tthrow new RuntimeException(\"Lookup from table \"+";
  protected final String TEXT_77 = "+\" has failed : \"+e.getMessage(), e);" + NL + "\t\t} finally {" + NL + "\t\t\tif(resultScanner != null) {" + NL + "\t\t\t\tresultScanner.close();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic void cleanup() throws Exception {" + NL + "\t\tif(table != null) {" + NL + "\t\t\ttable.close();" + NL + "\t\t}";
  protected final String TEXT_78 = NL + "        org.apache.hadoop.hbase.client.HConnection hConnection = org.apache.hadoop.hbase.client.HConnectionManager.getConnection(conf);" + NL + "        if ((hConnection != null) && (!hConnection.isClosed())) {" + NL + "            hConnection.close();" + NL + "        }";
  protected final String TEXT_79 = NL + "\t\torg.apache.hadoop.hbase.client.HConnectionManager.deleteConnection(conf, true);";
  protected final String TEXT_80 = NL + "\t}" + NL + "" + NL + "\tprivate org.apache.hadoop.hbase.client.Scan getScan(";
  protected final String TEXT_81 = " ";
  protected final String TEXT_82 = ") {";
  protected final String TEXT_83 = NL + "\t\torg.apache.hadoop.hbase.client.Scan scan =  new org.apache.hadoop.hbase.client.Scan(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_84 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_85 = "));";
  protected final String TEXT_86 = NL + "\t\torg.apache.hadoop.hbase.client.Scan scan = new org.apache.hadoop.hbase.client.Scan();";
  protected final String TEXT_87 = NL + "\t\tscan.addColumn(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_88 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(\"";
  protected final String TEXT_89 = "\"));";
  protected final String TEXT_90 = NL + "\t\tscan.setFilter(getFilterList(scan, ";
  protected final String TEXT_91 = "));";
  protected final String TEXT_92 = NL + "\t\treturn scan;" + NL + "\t}" + NL;
  protected final String TEXT_93 = NL + "\tprivate org.apache.hadoop.hbase.filter.FilterList getFilterList(org.apache.hadoop.hbase.client.Scan scan, ";
  protected final String TEXT_94 = " ";
  protected final String TEXT_95 = ") {" + NL + "\t\torg.apache.hadoop.hbase.filter.FilterList filterList = new org.apache.hadoop.hbase.filter.FilterList(org.apache.hadoop.hbase.filter.FilterList.Operator.";
  protected final String TEXT_96 = ");";
  protected final String TEXT_97 = NL + "\t\tString [] multipleValues = null;" + NL + "\t\tbyte [][] multipleBytesValues = null;";
  protected final String TEXT_98 = NL + "\t\torg.apache.hadoop.hbase.filter.Filter filter\t= null;";
  protected final String TEXT_99 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_100 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_101 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_102 = ", org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_103 = "));";
  protected final String TEXT_104 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_105 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_106 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_107 = ", new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_108 = "));";
  protected final String TEXT_109 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_110 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_111 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_112 = ", new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_113 = "));";
  protected final String TEXT_114 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_115 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_116 = ")));";
  protected final String TEXT_117 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_118 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_119 = "));";
  protected final String TEXT_120 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_121 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_122 = "));";
  protected final String TEXT_123 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_124 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_125 = ")));";
  protected final String TEXT_126 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_127 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_128 = "));";
  protected final String TEXT_129 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_130 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_131 = "));";
  protected final String TEXT_132 = NL + "\t\tscan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_133 = "));";
  protected final String TEXT_134 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.ColumnPrefixFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_135 = "));";
  protected final String TEXT_136 = NL + "\t\tscan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_137 = "));";
  protected final String TEXT_138 = NL + "\t\tif(";
  protected final String TEXT_139 = "!=null && !\"\".equals(";
  protected final String TEXT_140 = ")){" + NL + "\t\t\tmultipleValues = ";
  protected final String TEXT_141 = ".split(\",\");" + NL + "\t\t\tmultipleBytesValues = new byte [multipleValues.length] [];" + NL + "\t\t\tfor(int i=0;i< multipleValues.length;i++){" + NL + "\t\t\t\tmultipleBytesValues[i] = org.apache.hadoop.hbase.util.Bytes.toBytes(multipleValues[i]);" + NL + "\t\t\t}" + NL + "\t\t\tfilter = new org.apache.hadoop.hbase.filter.MultipleColumnPrefixFilter(multipleBytesValues);" + NL + "\t\t}";
  protected final String TEXT_142 = NL + "\t\tscan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_143 = "));";
  protected final String TEXT_144 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.ColumnRangeFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_145 = ".split(\",\")[0]),true,org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_146 = ".split(\",\")[1]),true);";
  protected final String TEXT_147 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_148 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_149 = ")));";
  protected final String TEXT_150 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_151 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_152 = "));";
  protected final String TEXT_153 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_154 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_155 = "));";
  protected final String TEXT_156 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_157 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_158 = ")));";
  protected final String TEXT_159 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_160 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_161 = "));";
  protected final String TEXT_162 = NL + "\t\tfilter = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_163 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_164 = "));";
  protected final String TEXT_165 = NL + "\t\tfilterList.addFilter(filter);";
  protected final String TEXT_166 = NL + "\t\treturn filterList;" + NL + "\t}";
  protected final String TEXT_167 = NL + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
final class HBaseConfigurationUtil {

	protected INode configurationNode;
	
	public HBaseConfigurationUtil(INode configurationNode) {
		this.configurationNode = configurationNode;
	}
	
	public String getZookeeperUrl() {
		return ElementParameterParser.getValue(configurationNode, "__ZOOKEEPER_QUORUM__");
	}
	
	public String getZookeeperPort() {
		return ElementParameterParser.getValue(configurationNode, "__ZOOKEEPER_CLIENT_PORT__");
	}
	
	public boolean isUsingKerberos() {
		return "true".equals(ElementParameterParser.getValue(configurationNode, "__USE_KRB__"));
	}
	
	public boolean isUsingKeytab() {
		return "true".equals(ElementParameterParser.getValue(configurationNode, "__USE_KEYTAB__"));
	}
	
	public String getUserPrincipal() {
		return ElementParameterParser.getValue(configurationNode, "__PRINCIPAL__");
	}
	
	public String getKeytabPath() {
		return ElementParameterParser.getValue(configurationNode, "__KEYTAB_PATH__");
	}
	
	public String getHBaseMasterPrincipal() {
		return ElementParameterParser.getValue(configurationNode, "__HBASE_MASTER_PRINCIPAL__");
	}
	
	public String getHBaseRegionServerPrincipal() {
		return ElementParameterParser.getValue(configurationNode, "__HBASE_REGIONSERVER_PRINCIPAL__");
	}
	
	public String getVersion() {
		return ElementParameterParser.getValue(configurationNode, "__HBASE_VERSION__");
	}
	
	public boolean isZNodeParentSet() {
		return "true".equals(ElementParameterParser.getValue(configurationNode, "__SET_ZNODE_PARENT__"));
	}
	
	public String getZNodeParent() {
		return ElementParameterParser.getValue(configurationNode, "__ZNODE_PARENT__");
	}
	
	public List<Map<String, String>> getHBaseParameters() {
		return (List<Map<String,String>>) ElementParameterParser.getObjectValue(configurationNode, "__HBASE_PARAMETERS__");
   }
   
   public boolean isCustomDistribution() {
   	return "CUSTOM".equals(ElementParameterParser.getValue(configurationNode, "__DISTRIBUTION__"));
   }
   
   public boolean supportNewHBaseApi() {
   	return java.util.Arrays.asList("HDP_2_0","HDP_2_1","HDP_2_2","PIVOTAL_HD_2_0","Cloudera_CDH5","Cloudera_CDH5_1","Cloudera_CDH5_4","Cloudera_CDH5_1_MR1").contains(getVersion());
   }

} // end class HBaseConfigurationUtil

    stringBuffer.append(TEXT_3);
    
final class THBaseLookupInputUtil {
	
	protected INode node;
	
	protected IConnection outgoingConnection;

	public THBaseLookupInputUtil(INode node) {
		this.node = node;
		this.outgoingConnection = findOutgoingConnection();
	}
	
	public INode getConfigurationNode() {
		INode configurationNode = null;
		String configurationNodeName = ElementParameterParser.getValue(node,"__STORAGE_CONFIGURATION__");
		for (INode pNode : node.getProcess().getNodesOfType("tHBaseConfiguration")) {
		    if(configurationNodeName!=null && configurationNodeName.equals(pNode.getUniqueName())) {
		        configurationNode = pNode;
		    }
		}
		return configurationNode;
	}
	
	public IConnection getOutgoingConnection() {
		return outgoingConnection;
	}
	
	public List<IMetadataColumn> getColumns() {
		return node.getMetadataList().get(0).getListColumns();
	}
	
	public String getTableName() {
		return ElementParameterParser.getValue(node, "__TABLE__");
	}
	
	public boolean isByFilter() {
		return "true".equals(ElementParameterParser.getValue(node, "__IS_BY_FILTER__"));
	}
	
	public boolean isRowSelectionDefined() {
		return "true".equals(ElementParameterParser.getValue(node, "__DEFINE_ROW_SELECTION__"));
	}
	
	public String getStartRow() {
		return ElementParameterParser.getValue(node, "__START_ROW__");
	}
	
	public String getEndRow() {
		return ElementParameterParser.getValue(node, "__END_ROW__");
	}
	
	public List<Map<String, String>> getMapping() {
		return (List<Map<String,String>>) ElementParameterParser.getObjectValue(node,"__MAPPING__");
	}
	
	public List<Map<String, String>> getFilterMapping() {
		return (List<Map<String,String>>) ElementParameterParser.getObjectValue(node,"__FILTER__");
	}
	
	public String getLogicalOperator() {
		return ElementParameterParser.getValue(node,"__LOGICAL_OP__");
	}
	
	public void generateRowStructCode(String outputName){

    stringBuffer.append(TEXT_4);
    
		for(int i=0; i < getMapping().size(); i++){
			Map<String, String> map = getMapping().get(i);
			String schemaColumn = map.get("SCHEMA_COLUMN");
			String familyColumn= map.get("FAMILY_COLUMN");
			IMetadataColumn column = getColumns().get(i);
			String columnName = column.getLabel();
			String defaultValue = column.getDefault();
			if(columnName.equals(schemaColumn)) {//
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				boolean isPrimitiveType = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());

    stringBuffer.append(TEXT_5);
    stringBuffer.append(familyColumn);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_7);
    									
				if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_10);
    									
				}else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_13);
    									
				}else if(javaType == JavaTypesManager.DATE){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_17);
    									
				}else if(isPrimitiveType && javaType == JavaTypesManager.INTEGER){  

    stringBuffer.append(TEXT_18);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_20);
    									
				}else if(isPrimitiveType && javaType == JavaTypesManager.CHARACTER){  

    stringBuffer.append(TEXT_21);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_23);
    									
				}else if(isPrimitiveType && (javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT || javaType == JavaTypesManager.DOUBLE)) {  

    stringBuffer.append(TEXT_24);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(javaType.getNullableClass().getSimpleName());
    stringBuffer.append(TEXT_27);
    									
				}else{

    stringBuffer.append(TEXT_28);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_31);
    								
				}

    stringBuffer.append(TEXT_32);
    
				String default_Value = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, defaultValue);
				if(default_Value != null && !"null".equals(default_Value)) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(outputName );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(default_Value);
    stringBuffer.append(TEXT_36);
    
				} else if(!JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable())) {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(outputName );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_39);
    
				} else {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_42);
    
				}

    stringBuffer.append(TEXT_43);
    
			} //if(columnName.equals(schema_column))
		} //for(int i=0;i<mapping.size();i++)	
	}
	
	private IConnection findOutgoingConnection() {
		IConnection result = null;
		List<? extends IConnection> outgoingConnections = node.getOutgoingConnections();
		if (outgoingConnections.size() > 0) {
		    result = outgoingConnections.get(0);
		}
		return result;
	}
	
} // end class THBaseLookupInputUtil

    stringBuffer.append(TEXT_44);
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument)argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean setTableNsMapping = "true".equals(ElementParameterParser.getValue(node, "__SET_TABLE_NS_MAPPING__"));
String tableNsMapping = ElementParameterParser.getValue(node, "__TABLE_NS_MAPPING__");
boolean useTableNsMapping = setTableNsMapping && ((tableNsMapping != null)&&(!tableNsMapping.equals("")));

String validateError = org.talend.designer.common.tmap.AbstractTMapAdapter.validatePullLookupConfig(node);
if (validateError != null) {
    // Cause the job compilation to explicitly fail if there is a problem.
    return "{throw new JobConfigurationError(\"" + validateError +"\");}";
}

THBaseLookupInputUtil tHBaseLookupInputUtil = new THBaseLookupInputUtil(node);
HBaseConfigurationUtil hBaseConfigurationUtil = new HBaseConfigurationUtil(tHBaseLookupInputUtil.getConfigurationNode());

String outputName = tHBaseLookupInputUtil.getOutgoingConnection().getName();
String structName = codeGenArgument.getRecordStructName(tHBaseLookupInputUtil.getOutgoingConnection());

TMapAdapter tMapAdapter = org.talend.designer.common.tmap.AbstractTMapAdapter.createForTMap(
        tHBaseLookupInputUtil.getOutgoingConnection().getTarget());
String inputMainName = tMapAdapter.getInputMainName();
String structMainName = codeGenArgument.getRecordStructName(inputMainName);


    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(hBaseConfigurationUtil.getZookeeperUrl());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(hBaseConfigurationUtil.getZookeeperPort());
    stringBuffer.append(TEXT_50);
    
	if(hBaseConfigurationUtil.isZNodeParentSet()) {

    stringBuffer.append(TEXT_51);
    stringBuffer.append(hBaseConfigurationUtil.getZNodeParent());
    stringBuffer.append(TEXT_52);
    
	}

	if(useTableNsMapping){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(tableNsMapping);
    stringBuffer.append(TEXT_54);
    
	}

	if(hBaseConfigurationUtil.isUsingKerberos()) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(hBaseConfigurationUtil.getHBaseMasterPrincipal());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(hBaseConfigurationUtil.getHBaseRegionServerPrincipal());
    stringBuffer.append(TEXT_57);
    
		if(hBaseConfigurationUtil.isUsingKeytab()) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(hBaseConfigurationUtil.getUserPrincipal());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(hBaseConfigurationUtil.getKeytabPath());
    stringBuffer.append(TEXT_60);
    
		}
	}
	for(int i=0; i < hBaseConfigurationUtil.getHBaseParameters().size(); i++){
		Map<String, String> map = hBaseConfigurationUtil.getHBaseParameters().get(i);
		String property = map.get("PROPERTY");
		String value= map.get("VALUE");

    stringBuffer.append(TEXT_61);
    stringBuffer.append(property);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_63);
    
	}

    stringBuffer.append(TEXT_64);
    stringBuffer.append(tHBaseLookupInputUtil.getTableName());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(structMainName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(inputMainName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(inputMainName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(inputMainName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_74);
    
				tHBaseLookupInputUtil.generateRowStructCode(outputName);

    stringBuffer.append(TEXT_75);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(tHBaseLookupInputUtil.getTableName());
    stringBuffer.append(TEXT_77);
    
	if((hBaseConfigurationUtil.isCustomDistribution()) || (!hBaseConfigurationUtil.isCustomDistribution() && hBaseConfigurationUtil.getVersion() !=null && hBaseConfigurationUtil.supportNewHBaseApi())) {

    stringBuffer.append(TEXT_78);
    
	} else {

    stringBuffer.append(TEXT_79);
    
	}

    stringBuffer.append(TEXT_80);
    stringBuffer.append(structMainName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(inputMainName);
    stringBuffer.append(TEXT_82);
    
	if(tHBaseLookupInputUtil.isRowSelectionDefined()) {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(tHBaseLookupInputUtil.getStartRow());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(tHBaseLookupInputUtil.getEndRow());
    stringBuffer.append(TEXT_85);
    
	} else {

    stringBuffer.append(TEXT_86);
    
	}

	List<IMetadataColumn> columns = tHBaseLookupInputUtil.getColumns();
	List<Map<String, String>> mapping = tHBaseLookupInputUtil.getMapping();
	for(int i=0; i < mapping.size(); i++){
		Map<String, String> map = mapping.get(i);
		IMetadataColumn column = columns.get(i);
		String familyColumn = map.get("FAMILY_COLUMN");

    stringBuffer.append(TEXT_87);
    stringBuffer.append(familyColumn);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_89);
    
	}

	if(tHBaseLookupInputUtil.isByFilter()) {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(inputMainName);
    stringBuffer.append(TEXT_91);
    
	}

    stringBuffer.append(TEXT_92);
    
	if(tHBaseLookupInputUtil.isByFilter()) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(structMainName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(inputMainName);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(tHBaseLookupInputUtil.getLogicalOperator());
    stringBuffer.append(TEXT_96);
    
		List<Map<String, String>> filterMapping = tHBaseLookupInputUtil.getFilterMapping();
		boolean hasMultipleColumnPrefixFilterType = false;
		for(int i=0; i < filterMapping.size() ;i++){
			Map<String, String> filterMap = filterMapping.get(i);
			String filterType = filterMap.get("FILTER_TYPE");
			if("MultipleColumnPrefixFilter".equals(filterType)){
				hasMultipleColumnPrefixFilterType = true;
				break;
			}
		}

		if(hasMultipleColumnPrefixFilterType){

    stringBuffer.append(TEXT_97);
    
		}

    stringBuffer.append(TEXT_98);
    
		for(int j=0; j < filterMapping.size(); j++) {
			Map<String, String> filterMap = filterMapping.get(j);
			String filterType = filterMap.get("FILTER_TYPE");
			String filterColumn = filterMap.get("FILTER_COLUMN");
			String filterFamily = filterMap.get("FILTER_FAMILY");
			String filterOperation = filterMap.get("FILTER_OPERATOR");
			String filterValue = filterMap.get("FILTER_VALUE");
			String filterComparatorType = filterMap.get("FILTER_COMPARATOR_TYPE");
			if("SingleColumnValueFilter".equals(filterType)){
				if("BinaryComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_99);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_103);
    
				}else if ("RegexStringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_104);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_108);
    
				}else if("SubstringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_109);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_113);
    
				}
			}else if("FamilyFilter".equals(filterType)){
				if("BinaryComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_114);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_116);
    
				}else if ("RegexStringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_117);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_119);
    
				}else if("SubstringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_120);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_122);
    
				}
			}else if("QualifierFilter".equals(filterType)){
				if("BinaryComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_123);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_125);
    
				}else if ("RegexStringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_126);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_128);
    
				}else if("SubstringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_129);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_131);
    
				}
			}else if("ColumnPrefixFilter".equals(filterType)){
				if(filterFamily!=null && !"".equals(filterFamily)){

    stringBuffer.append(TEXT_132);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_133);
    
				}

    stringBuffer.append(TEXT_134);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_135);
    
			}else if("MultipleColumnPrefixFilter".equals(filterType)){
				if(filterFamily!=null && !"".equals(filterFamily)){

    stringBuffer.append(TEXT_136);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_137);
    
				}

    stringBuffer.append(TEXT_138);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_141);
    
			}else if("ColumnRangeFilter".equals(filterType)){
				if(filterFamily!=null && !"".equals(filterFamily)){

    stringBuffer.append(TEXT_142);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_143);
    
				}

    stringBuffer.append(TEXT_144);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_146);
    
			}else if("RowFilter".equals(filterType)){
				if("BinaryComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_147);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_149);
    
				}else if ("RegexStringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_150);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_152);
    
				}else if("SubstringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_153);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_155);
    
				}
			}else if("ValueFilter".equals(filterType)){
				if("BinaryComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_156);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_158);
    
				}else if ("RegexStringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_159);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_161);
    
				}else if("SubstringComparator".equals(filterComparatorType)){

    stringBuffer.append(TEXT_162);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_164);
    
				}
			}

    stringBuffer.append(TEXT_165);
    
		} // end for(int j=0; j < filterMapping.size(); j++)

    stringBuffer.append(TEXT_166);
    
	} // end if(tHBaseLookupInputUtil.isByFilter())

    stringBuffer.append(TEXT_167);
    return stringBuffer.toString();
  }
}
