package org.talend.designer.codegen.translators.databases.mysql;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.common.tmap.TMapAdapter;
import org.talend.designer.spark.generator.storage.ISparkStorage;
import org.talend.designer.spark.generator.storage.MysqlSparkStorage;

public class TMysqlLookupInputSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TMysqlLookupInputSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlLookupInputSparkstreamingcodeJava result = new TMysqlLookupInputSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "\t\t\t\tif(resultSet.getObject(";
  protected final String TEXT_5 = ") != null) {" + NL + "\t\t\t\t\tString value = resultSet.getString(";
  protected final String TEXT_6 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " = value";
  protected final String TEXT_9 = ";" + NL + "\t\t\t\t} else {";
  protected final String TEXT_10 = NL + "\t\t\t\t}" + NL;
  protected final String TEXT_11 = NL + "\t\t\t\tif(resultSet.getObject(";
  protected final String TEXT_12 = ") != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = " = resultSet.get";
  protected final String TEXT_15 = "(";
  protected final String TEXT_16 = ");" + NL + "\t\t\t\t} else {";
  protected final String TEXT_17 = NL + "\t\t\t\t}" + NL;
  protected final String TEXT_18 = NL + "\t\t\t\tif(resultSet.getObject(";
  protected final String TEXT_19 = ") != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = " =  new java.util.Date(resultSet.getTimestamp(";
  protected final String TEXT_22 = ").getTime());" + NL + "\t\t\t\t} else {";
  protected final String TEXT_23 = NL + "\t\t\t\t}" + NL;
  protected final String TEXT_24 = NL + "\t\t\t\tif(resultSet.getObject(";
  protected final String TEXT_25 = ") != null) {" + NL + "\t\t\t\t\tString value = resultSet.getString(";
  protected final String TEXT_26 = ")";
  protected final String TEXT_27 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = " = value.charAt(0);" + NL + "\t\t\t\t} else {";
  protected final String TEXT_30 = NL + "\t\t\t\t}" + NL;
  protected final String TEXT_31 = NL + "\t\t\t\tif(resultSet.getObject(";
  protected final String TEXT_32 = ") != null) {" + NL + "\t\t\t\t\tbyte[] value = resultSet.getBytes(";
  protected final String TEXT_33 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " = java.nio.ByteBuffer.wrap(value);" + NL + "\t\t\t\t} else {";
  protected final String TEXT_36 = NL + "\t\t\t\t}" + NL;
  protected final String TEXT_37 = NL + "\t\t\t\tif(resultSet.getObject(";
  protected final String TEXT_38 = ") != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " = (java.util.List) resultSet.getObject(";
  protected final String TEXT_41 = ");" + NL + "\t\t\t\t} else {";
  protected final String TEXT_42 = NL + "\t\t\t\t}" + NL;
  protected final String TEXT_43 = NL + "\t\t\t\t   ";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = " = null;";
  protected final String TEXT_46 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column ";
  protected final String TEXT_47 = "\");";
  protected final String TEXT_48 = NL;
  protected final String TEXT_49 = NL + NL + "public static class ";
  protected final String TEXT_50 = "_FlatMapper extends org.talend.bigdata.dataflow.hmap.HMapContextConfigurableBase implements org.talend.bigdata.dataflow.functions.FlatMapper<org.apache.avro.generic.IndexedRecord, ";
  protected final String TEXT_51 = "> {" + NL + "" + NL + "\tprivate transient java.sql.Connection connection;" + NL + "" + NL + "\tprivate ContextProperties context;" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_52 = "_FlatMapper(JobConf job) {" + NL + "\t\tthis.context = new ContextProperties(job);" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic void prepare() throws Exception {" + NL + "\t\tjava.lang.Class.forName(";
  protected final String TEXT_53 = ");" + NL + "   \tconnection = java.sql.DriverManager.getConnection(";
  protected final String TEXT_54 = ");" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic Iterable<";
  protected final String TEXT_55 = "> flatMap(org.apache.avro.generic.IndexedRecord joinKeys) throws Exception {" + NL + "\t\tList<";
  protected final String TEXT_56 = "> result = new ArrayList<>();" + NL + "\t\t";
  protected final String TEXT_57 = " ";
  protected final String TEXT_58 = " = getHMapContext().getInputRecord(\"";
  protected final String TEXT_59 = "\");" + NL + "" + NL + "\t\tjava.sql.Statement statement = connection.createStatement();" + NL + "\t\tString query = ";
  protected final String TEXT_60 = ";" + NL + "\t\ttry {" + NL + "    \t\tjava.sql.ResultSet resultSet = statement.executeQuery(query);" + NL + "    \t\twhile (resultSet.next()) {" + NL + "        \t\t";
  protected final String TEXT_61 = " ";
  protected final String TEXT_62 = " = new ";
  protected final String TEXT_63 = "();" + NL;
  protected final String TEXT_64 = NL + "\t\t\t\tresult.add(";
  protected final String TEXT_65 = ");" + NL + "    \t\t}" + NL + "\t\t} catch (Exception e) {" + NL + "    \t\tthrow new RuntimeException(\"Lookup from table \"+";
  protected final String TEXT_66 = "+\" has failed : \"+e.getMessage(), e);" + NL + "\t\t} finally {" + NL + "    \t\tstatement.close();" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic void cleanup() throws Exception {" + NL + "\t\tif (connection != null && !connection.isClosed()) {" + NL + "    \t\tconnection.close();" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_67 = NL;
  protected final String TEXT_68 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    
abstract class AbstractJDBCLookupInputUtil {

	protected INode node;

	protected IConnection outgoingConnection;

	public AbstractJDBCLookupInputUtil(INode node) {
		this.node = node;
		this.outgoingConnection = findOutgoingConnection();
	}

	public IConnection getOutgoingConnection() {
		return outgoingConnection;
	}

	public String getTable() {
		return ElementParameterParser.getValue(node,  "__TABLE__");
	}

	public String getDbQuery() {
		String result = ElementParameterParser.getValue(node, "__QUERY__");
		result = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(result);
		return result;
	}

	public List<IMetadataColumn> getColumns() {
		return node.getMetadataList().get(0).getListColumns();
	}

	public String getTypeToGenerate(IMetadataColumn column) {
		return mappingType(JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()));
	}

	public void generateRowStructCode(String outputName){
		int currentColumnIndex = 1;
		for(IMetadataColumn column : getColumns()) {
			String typeToGenerate = getTypeToGenerate(column);
			if(("String").equals(typeToGenerate)) {
				generateStringResultSetCode(outputName, column, currentColumnIndex, getTrimMethod(column));
			} else if(("Char").equals(typeToGenerate) || ("Character").equals(typeToGenerate)) {
				generateStringCharAndCharacterResultSet(outputName, column, currentColumnIndex, getTrimMethod(column), typeToGenerate);
			} else if(("Timestamp").equals(typeToGenerate)) {
				generateTimestampResultSet(outputName, column, currentColumnIndex);
			} else if(("Bytes").equals(typeToGenerate)) {
				generateBytesResultSet(outputName, column, currentColumnIndex);
			} else if (("List").equals(typeToGenerate)) {
				generateListResultSet(outputName, column, currentColumnIndex);
			} else {
				generateOtherResultSetCode(outputName, column, currentColumnIndex, typeToGenerate);
			}
			currentColumnIndex++;
		}
	}

	public void generateStringResultSetCode(String outputName, IMetadataColumn column, int currentColumnIndex, String trimMethod) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(currentColumnIndex);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(currentColumnIndex);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_9);
    
		generateIsNullableCode(outputName, column);

    stringBuffer.append(TEXT_10);
    
	}

	public void generateOtherResultSetCode(String outputName, IMetadataColumn column, int currentColumnIndex, String typeToGenerate) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(currentColumnIndex);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(currentColumnIndex);
    stringBuffer.append(TEXT_16);
    
		generateIsNullableCode(outputName, column);

    stringBuffer.append(TEXT_17);
    
	}

	public void generateTimestampResultSet(String outputName, IMetadataColumn column, int currentColumnIndex) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(currentColumnIndex);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(currentColumnIndex);
    stringBuffer.append(TEXT_22);
    
		generateIsNullableCode(outputName, column);

    stringBuffer.append(TEXT_23);
    
	}

	public void generateStringCharAndCharacterResultSet(String outputName, IMetadataColumn column, int currentColumnIndex, String trimMethod, String typeToGenerate) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(currentColumnIndex);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(currentColumnIndex);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_29);
    
		generateIsNullableCode(outputName, column);

    stringBuffer.append(TEXT_30);
    
	}

	public void generateBytesResultSet(String outputName, IMetadataColumn column, int currentColumnIndex) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(currentColumnIndex);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(currentColumnIndex);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_35);
    
		generateIsNullableCode(outputName, column);

    stringBuffer.append(TEXT_36);
    
	}

	public void generateListResultSet(String outputName, IMetadataColumn column, int currentColumnIndex) {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(currentColumnIndex);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(currentColumnIndex);
    stringBuffer.append(TEXT_41);
    
		generateIsNullableCode(outputName, column);

    stringBuffer.append(TEXT_42);
    
	}

	protected void generateIsNullableCode(String outputName, IMetadataColumn column) {
		if(column.isNullable()) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_45);
    
		} else {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_47);
    
		}
	}

	private String getTrimMethod(IMetadataColumn column) {
		return hasColumnToBeTrimmed(column) ? ".trim()" : "";
	}

	private boolean haveAllColumnsToBeTrimmed(){
	   return ("true").equals(ElementParameterParser.getValue(node, "__TRIM_ALL_COLUMN__"));
   }

   private boolean hasColumnToBeTrimmed(IMetadataColumn column) {
		boolean result = haveAllColumnsToBeTrimmed();
		if(!result) {
			List<Map<String, String>> trimColumnList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIM_COLUMN__");
			if((trimColumnList != null && trimColumnList.size() > 0)) {
				for(Map<String, String> trimColumn : trimColumnList) {
				    if(column.getLabel().equals(trimColumn.get("SCHEMA_COLUMN"))) {
				        if(("true").equals(trimColumn.get("TRIM"))) {
				            result = true;
				            break;
				        }
				    }
				}
			}
		}
		return result;
	}

	private String mappingType(String typeToGenerate) {
		String result = null;
		if(("byte[]").equals(typeToGenerate)) {
		   result = "Bytes";
		} else if(("java.util.Date").equals(typeToGenerate)) {
		   result = "Timestamp";
		} else if(("Integer").equals(typeToGenerate)) {
		   result = "Int";
		} else {
		   result = typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
		}
		return result;
	}

	private IConnection findOutgoingConnection() {
		IConnection result = null;
		List<? extends IConnection> outgoingConnections = node.getOutgoingConnections();
		if (outgoingConnections.size() > 0) {
		    result = outgoingConnections.get(0);
		}
		return result;
	}

} // end class AbstractJDBCLookupInputUtil

    stringBuffer.append(TEXT_48);
    
class TMapJDBCFlatMapperUtil {

	private AbstractJDBCLookupInputUtil jdbcLookupInputUtil;
	private ISparkStorage storage;
	private final org.talend.designer.common.tmap.TMapAdapter tMapAdapter;

	public TMapJDBCFlatMapperUtil(AbstractJDBCLookupInputUtil jdbcLookupInputUtil, ISparkStorage storage){
		this.jdbcLookupInputUtil = jdbcLookupInputUtil;
		this.storage = storage;

        INode nextNode = jdbcLookupInputUtil.getOutgoingConnection().getTarget();
        tMapAdapter = org.talend.designer.common.tmap.AbstractTMapAdapter.createForTMap(nextNode);
	}

	public void generateFlatMapperCode(BigDataCodeGeneratorArgument codeGenArgument, String driverClass) {
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();

		String outputName = jdbcLookupInputUtil.getOutgoingConnection().getName();
		String structName = codeGenArgument.getRecordStructName(jdbcLookupInputUtil.getOutgoingConnection());

		if(structName == null){
			return;
		}

		String inputMainName = tMapAdapter.getInputMainName();
		String structMainName = codeGenArgument.getRecordStructName(inputMainName);

		if(structMainName == null){
			return;
		}

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(storage.getURI());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(structMainName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(inputMainName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(inputMainName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(jdbcLookupInputUtil.getDbQuery());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_63);
    
				jdbcLookupInputUtil.generateRowStructCode(outputName);

    stringBuffer.append(TEXT_64);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(jdbcLookupInputUtil.getTable());
    stringBuffer.append(TEXT_66);
    
	} // end generateFlatMapperCode()
} // end TMapJDBCFlatMapperUtil class

    stringBuffer.append(TEXT_67);
    
final class TMysqlLookupInputUtil extends AbstractJDBCLookupInputUtil {

	public TMysqlLookupInputUtil(INode node) {
		super(node);
	}

} // end class TMysqlLookupInputUtil

    stringBuffer.append(TEXT_68);
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument)argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

TMysqlLookupInputUtil tMysqlLookupInputUtil = new TMysqlLookupInputUtil(node);
MysqlSparkStorage storage = new MysqlSparkStorage(node);
TMapJDBCFlatMapperUtil tMapFlatMapperUtil = new TMapJDBCFlatMapperUtil(tMysqlLookupInputUtil, storage);

String validateError = org.talend.designer.common.tmap.AbstractTMapAdapter.validatePullLookupConfig(node);
if (validateError != null) {
    // Cause the job compilation to explicitly fail if there is a problem.
    return "{throw new JobConfigurationError(\"" + validateError +"\");}";
}

tMapFlatMapperUtil.generateFlatMapperCode(codeGenArgument, "\"org.gjt.mm.mysql.Driver\"");

    return stringBuffer.toString();
  }
}
