package org.talend.designer.codegen.translators.databases.cassandra;

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

public class TCassandraLookupInputSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TCassandraLookupInputSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCassandraLookupInputSparkstreamingcodeJava result = new TCassandraLookupInputSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    \t\t\t\t";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = " = row.getString(\"";
  protected final String TEXT_5 = "\");";
  protected final String TEXT_6 = NL + "    \t\t\t\t";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " = row.getUUID(\"";
  protected final String TEXT_9 = "\").toString();";
  protected final String TEXT_10 = NL + "    \t\t\t\t";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = " = row.getVarint(\"";
  protected final String TEXT_13 = "\");";
  protected final String TEXT_14 = NL + "    \t\t\t\t";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = " = row.getInet(\"";
  protected final String TEXT_17 = "\");";
  protected final String TEXT_18 = NL + "    \t\t\t\t";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = " = row.getMap(\"";
  protected final String TEXT_21 = "\", Object.class, Object.class);";
  protected final String TEXT_22 = NL + "    \t\t\t\t";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = " = row.getSet(\"";
  protected final String TEXT_25 = "\", Object.class);";
  protected final String TEXT_26 = NL + "        \t\t";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = " = row.getList(\"";
  protected final String TEXT_29 = "\", Object.class);";
  protected final String TEXT_30 = NL + "        \t\t";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = " = row.getBool(\"";
  protected final String TEXT_33 = "\");";
  protected final String TEXT_34 = NL + "        \t\t";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = " = row.getBytes(\"";
  protected final String TEXT_37 = "\");";
  protected final String TEXT_38 = NL + "        \t\t";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " = row.getDate(\"";
  protected final String TEXT_41 = "\");";
  protected final String TEXT_42 = NL + "        \t\t";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = " = row.getDecimal(\"";
  protected final String TEXT_45 = "\");";
  protected final String TEXT_46 = NL + "        \t\t";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = " = row.getDouble(\"";
  protected final String TEXT_49 = "\");";
  protected final String TEXT_50 = NL + "        \t\t";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = " = row.getFloat(\"";
  protected final String TEXT_53 = "\");";
  protected final String TEXT_54 = NL + "        \t\t";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = " = row.getInt(\"";
  protected final String TEXT_57 = "\");";
  protected final String TEXT_58 = NL + "        \t\t";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = " = row.getLong(\"";
  protected final String TEXT_61 = "\");";
  protected final String TEXT_62 = NL + "\t\t\t\t   ";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = " = null;";
  protected final String TEXT_65 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column ";
  protected final String TEXT_66 = "\");";
  protected final String TEXT_67 = NL;
  protected final String TEXT_68 = NL + NL + "public static class ";
  protected final String TEXT_69 = "_FlatMapper extends org.talend.bigdata.dataflow.hmap.HMapContextConfigurableBase implements org.talend.bigdata.dataflow.functions.FlatMapper<org.apache.avro.generic.IndexedRecord, ";
  protected final String TEXT_70 = "> {" + NL + "" + NL + "\tprivate transient com.datastax.driver.core.Cluster cluster;" + NL + "\tprivate transient com.datastax.driver.core.Session session;" + NL + "\tprivate ContextProperties context;" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_71 = "_FlatMapper(JobConf job) {" + NL + "\t\tthis.context = new ContextProperties(job);" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic void prepare() throws Exception {";
  protected final String TEXT_72 = NL + "\t\tString password = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "\t\tString password = ";
  protected final String TEXT_75 = ";";
  protected final String TEXT_76 = NL + "   \tcluster = com.datastax.driver.core.Cluster.builder() //" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.addContactPoints(";
  protected final String TEXT_77 = ".split(\",\")) //" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.withPort(Integer.valueOf(";
  protected final String TEXT_78 = ")) //";
  protected final String TEXT_79 = NL + "                                                .withCredentials(";
  protected final String TEXT_80 = ", password) //";
  protected final String TEXT_81 = NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.build();" + NL;
  protected final String TEXT_82 = NL + "\t\t\tsession = cluster.connect(StringHandling.DQUOTE(";
  protected final String TEXT_83 = "));";
  protected final String TEXT_84 = NL + "\t\t\tsession = cluster.connect();";
  protected final String TEXT_85 = NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic Iterable<";
  protected final String TEXT_86 = "> flatMap(org.apache.avro.generic.IndexedRecord joinKeys) throws Exception {" + NL + "\t\tList<";
  protected final String TEXT_87 = "> result = new ArrayList<>();" + NL + "\t\t";
  protected final String TEXT_88 = " ";
  protected final String TEXT_89 = " = getHMapContext().getInputRecord(\"";
  protected final String TEXT_90 = "\");" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\tcom.datastax.driver.core.ResultSet resultSet = session.execute(";
  protected final String TEXT_91 = ");" + NL + "\t\t\tfor(com.datastax.driver.core.Row row : resultSet) {" + NL + "        \t\t";
  protected final String TEXT_92 = " ";
  protected final String TEXT_93 = " = new ";
  protected final String TEXT_94 = "();";
  protected final String TEXT_95 = NL + "\t\t\t\tresult.add(";
  protected final String TEXT_96 = ");" + NL + "    \t\t}" + NL + "\t\t} catch (Exception e) {" + NL + "    \t\tthrow new RuntimeException(\"Lookup from query \"+";
  protected final String TEXT_97 = "+\" has failed : \"+e.getMessage(), e);" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic void cleanup() throws Exception {" + NL + "\t\tif (session != null) {" + NL + "    \t\tsession.close();" + NL + "\t\t}" + NL + "\t\tif (cluster != null) {" + NL + "    \t\tcluster.close();" + NL + "\t\t}" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
final class TCassandraLookupInputUtil {

	protected INode node;

	protected IConnection outgoingConnection;

	public TCassandraLookupInputUtil(INode node) {
		this.node = node;
		this.outgoingConnection = findOutgoingConnection();
	}

	public IConnection getOutgoingConnection() {
		return outgoingConnection;
	}

	public String getPort() {
		return ElementParameterParser.getValue(node, "__PORT__");
	}

	public String getHost() {
		return ElementParameterParser.getValue(node, "__HOST__");
	}

	public String getKeySpace() {
	   return ElementParameterParser.getValue(node, "__KEY_SPACE__");
	}

	public boolean isAuthenticationRequired() {
		return "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
	}

	public String getUsername() {
		return ElementParameterParser.getValue(node, "__USERNAME__");
	}

	public String getPassword() {
		return canEncryptPassword() ? ElementParameterParser.getEncryptedValue(node, "__PASSWORD__") : ElementParameterParser.getValue(node, "__PASSWORD__");
	}

	public boolean canEncryptPassword() {
		return isAuthenticationRequired() && ElementParameterParser.canEncrypt(node, "__PASSWORD__");
	}

	public String getQuery() {
		return ElementParameterParser.getValue(node, "__QUERY__").replaceAll("[\r\n]", " ");
	}

	public List<IMetadataColumn> getColumns() {
		return node.getMetadataList().get(0).getListColumns();
	}

	public void generateRowStructCode(String outputName){
		for(IMetadataColumn column : getColumns()) {
			String dbType = column.getType();
    		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    		String columnName = column.getLabel();
    		String dbColumnName = column.getOriginalDbColumnName();
			dbColumnName = "\\\"" + dbColumnName + "\\\"";

    		if(javaType == JavaTypesManager.STRING){
    			if("ascii".equals(dbType) || "text".equals(dbType) || "varchar".equals(dbType)){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_5);
    
    			}else if("timeuuid".equals(dbType) || "uuid".equals(dbType)){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_9);
    
    			}
        	}else if(javaType == JavaTypesManager.OBJECT){
        		if("varint".equals(dbType)){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_13);
    
    			}else if("inet".equals(dbType)){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_17);
    
    			}else if("map".equals(dbType)){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_21);
    
    			}else if("set".equals(dbType)){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_25);
    
    			}
    		}else if(javaType == JavaTypesManager.LIST){

    stringBuffer.append(TEXT_26);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_29);
    
        	}else if(javaType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_30);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_33);
    
    		}else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_37);
    
    		}else if(javaType == JavaTypesManager.DATE){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_41);
    
    		}else if(javaType == JavaTypesManager.BIGDECIMAL){

    stringBuffer.append(TEXT_42);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_45);
    
    		}else if(javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_49);
    
    		}else if(javaType == JavaTypesManager.FLOAT){

    stringBuffer.append(TEXT_50);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_53);
    
    		}else if(javaType == JavaTypesManager.INTEGER){

    stringBuffer.append(TEXT_54);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_57);
    
    		}else if(javaType == JavaTypesManager.LONG){

    stringBuffer.append(TEXT_58);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(dbColumnName);
    stringBuffer.append(TEXT_61);
    
    		}
    	} // end for
	}

	protected void generateIsNullableCode(String outputName, IMetadataColumn column) {
		if(column.isNullable()) {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_64);
    
		} else {

    stringBuffer.append(TEXT_65);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_66);
    
		}
	}

	private IConnection findOutgoingConnection() {
		IConnection result = null;
		List<? extends IConnection> outgoingConnections = node.getOutgoingConnections();
		if (outgoingConnections.size() > 0) {
		    result = outgoingConnections.get(0);
		}
		return result;
	}

} // end class TCassandraLookupInputUtil

    stringBuffer.append(TEXT_67);
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument)argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

TCassandraLookupInputUtil tCassandraLookupInputUtil = new TCassandraLookupInputUtil(node);

String validateError = org.talend.designer.common.tmap.AbstractTMapAdapter.validatePullLookupConfig(node);
if (validateError != null) {
    // Cause the job compilation to explicitly fail if there is a problem.
    return "{throw new JobConfigurationError(\"" + validateError +"\");}";
}

String outputName = tCassandraLookupInputUtil.getOutgoingConnection().getName();
String structName = codeGenArgument.getRecordStructName(tCassandraLookupInputUtil.getOutgoingConnection());

TMapAdapter tMapAdapter = org.talend.designer.common.tmap.AbstractTMapAdapter.createForTMap(
        tCassandraLookupInputUtil.getOutgoingConnection().getTarget());
String inputMainName = tMapAdapter.getInputMainName();
String structMainName = codeGenArgument.getRecordStructName(inputMainName);


    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
	if(tCassandraLookupInputUtil.canEncryptPassword()) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(tCassandraLookupInputUtil.getPassword());
    stringBuffer.append(TEXT_73);
    
	} else {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(tCassandraLookupInputUtil.getPassword());
    stringBuffer.append(TEXT_75);
    
	}

    stringBuffer.append(TEXT_76);
    stringBuffer.append(tCassandraLookupInputUtil.getHost());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(tCassandraLookupInputUtil.getPort());
    stringBuffer.append(TEXT_78);
    
	if(tCassandraLookupInputUtil.isAuthenticationRequired()) {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(tCassandraLookupInputUtil.getUsername());
    stringBuffer.append(TEXT_80);
    
	}

    stringBuffer.append(TEXT_81);
    
	if(tCassandraLookupInputUtil.getKeySpace() != null && !"".equals(tCassandraLookupInputUtil.getKeySpace())) {

    stringBuffer.append(TEXT_82);
    stringBuffer.append(tCassandraLookupInputUtil.getKeySpace());
    stringBuffer.append(TEXT_83);
    
	} else {

    stringBuffer.append(TEXT_84);
    
	}

    stringBuffer.append(TEXT_85);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(structMainName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(inputMainName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(inputMainName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(tCassandraLookupInputUtil.getQuery());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_94);
    
				tCassandraLookupInputUtil.generateRowStructCode(outputName);

    stringBuffer.append(TEXT_95);
    stringBuffer.append(outputName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(tCassandraLookupInputUtil.getQuery());
    stringBuffer.append(TEXT_97);
    return stringBuffer.toString();
  }
}
