package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.common.tsqlrow.TSqlRowUtil;

public class TSqlRowSparkconfigJava
{
  protected static String nl;
  public static synchronized TSqlRowSparkconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSqlRowSparkconfigJava result = new TSqlRowSparkconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "org.apache.spark.sql.SQLContext sqlContext_";
  protected final String TEXT_2 = " = new org.apache.spark.sql.SQLContext(ctx);" + NL + "" + NL + "// Create dataframes from incoming schemas and register related tables";
  protected final String TEXT_3 = NL + "\torg.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_4 = "> ";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ".map(new ";
  protected final String TEXT_7 = "_From";
  protected final String TEXT_8 = "To";
  protected final String TEXT_9 = "());";
  protected final String TEXT_10 = "    " + NL + "    org.apache.spark.sql.DataFrame df_";
  protected final String TEXT_11 = "_";
  protected final String TEXT_12 = " = sqlContext_";
  protected final String TEXT_13 = ".createDataFrame(";
  protected final String TEXT_14 = NL + "            ";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ".class);" + NL + "    df_";
  protected final String TEXT_17 = "_";
  protected final String TEXT_18 = ".registerTempTable(\"";
  protected final String TEXT_19 = "\");";
  protected final String TEXT_20 = NL + NL + "// Execute the sql query" + NL + "org.apache.spark.sql.DataFrame df_";
  protected final String TEXT_21 = " = sqlContext_";
  protected final String TEXT_22 = ".sql(";
  protected final String TEXT_23 = ");" + NL + "" + NL + "// Retrieve the associated RDD" + NL + "org.apache.spark.api.java.JavaRDD<";
  protected final String TEXT_24 = "> rdd_";
  protected final String TEXT_25 = " = df_";
  protected final String TEXT_26 = ".toJavaRDD().map(" + NL + "        new ";
  protected final String TEXT_27 = "_FromRowTo";
  protected final String TEXT_28 = "());";
  protected final String TEXT_29 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

TSqlRowUtil tSqlRowUtil = new TSqlRowUtil(node);
String outStructName = codeGenArgument.getRecordStructName(tSqlRowUtil.getOutgoingConnection());


    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
for(IConnection incomingConnection : tSqlRowUtil.getIncomingConnections()) {
    String inStructName = codeGenArgument.getRecordStructName(incomingConnection);
    String inRddName = "rdd_"+incomingConnection.getName();
    
    String rddName, structName;
    
   if(tSqlRowUtil.containsDateFields(incomingConnection)) {
   	// Additional map to convert from java.util.Date to java.sql.Date
    	String newRddName = "tmp_rdd_"+incomingConnection.getName();
    	String newStructName = "DF_"+inStructName+"AvroRecord";

    stringBuffer.append(TEXT_3);
    stringBuffer.append(newStructName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(newRddName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inRddName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(newStructName);
    stringBuffer.append(TEXT_9);
    
		rddName = newRddName;
		structName = newStructName;
	} else {
		// No need for additional map
		rddName = inRddName;
		structName = inStructName;
	}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(incomingConnection.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(rddName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(structName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(incomingConnection.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(tSqlRowUtil.getTableName(incomingConnection));
    stringBuffer.append(TEXT_19);
    
} // end for

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(tSqlRowUtil.getSqlQuery());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(tSqlRowUtil.getOutgoingConnection().getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(outStructName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_29);
    return stringBuffer.toString();
  }
}
