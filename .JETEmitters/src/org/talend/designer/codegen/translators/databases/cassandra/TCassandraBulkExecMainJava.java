package org.talend.designer.codegen.translators.databases.cassandra;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TCassandraBulkExecMainJava
{
  protected static String nl;
  public static synchronized TCassandraBulkExecMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCassandraBulkExecMainJava result = new TCassandraBulkExecMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " \t" + NL + "java.io.File file_";
  protected final String TEXT_2 = " = new java.io.File(";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = "+\"/\"+";
  protected final String TEXT_5 = ");" + NL + "" + NL + "java.util.List<String> args_";
  protected final String TEXT_6 = " = new java.util.ArrayList<String>();" + NL + "args_";
  protected final String TEXT_7 = ".add(\"-d\"+";
  protected final String TEXT_8 = ");" + NL + "args_";
  protected final String TEXT_9 = ".add(\"-p\"+";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = "; ";
  protected final String TEXT_19 = NL + NL + "args_";
  protected final String TEXT_20 = ".add(\"-u\"+";
  protected final String TEXT_21 = ");" + NL + "" + NL + "args_";
  protected final String TEXT_22 = ".add(\"-pw\");" + NL + "args_";
  protected final String TEXT_23 = ".add(decryptedPassword_";
  protected final String TEXT_24 = ");" + NL;
  protected final String TEXT_25 = NL + "args_";
  protected final String TEXT_26 = ".add(file_";
  protected final String TEXT_27 = ".getAbsolutePath());";
  protected final String TEXT_28 = NL + "\tlog.info(\"";
  protected final String TEXT_29 = " - Loading the data from SSTable \"+file_";
  protected final String TEXT_30 = ".getAbsolutePath()+\"to the server.\");";
  protected final String TEXT_31 = NL + "org.apache.cassandra.tools.BulkLoader.main(args_";
  protected final String TEXT_32 = ".toArray(new String[args_";
  protected final String TEXT_33 = ".size()]));";
  protected final String TEXT_34 = NL + "\tlog.info(\"";
  protected final String TEXT_35 = " - Loaded the data to the server successfully.\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String sstablePath = ElementParameterParser.getValue(node,"__SSTABLE_STORE_PATH__");
String keySpace = ElementParameterParser.getValue(node,"__KEY_SPACE__");
String columnFamily = ElementParameterParser.getValue(node,"__COLUMN_FAMILY__");
String host = ElementParameterParser.getValue(node,"__HOST__");
String port = ElementParameterParser.getValue(node,"__PORT__");
String version = ElementParameterParser.getValue(node,"__DB_VERSION__");
boolean requireAuth = "true".equals(ElementParameterParser.getValue(node,"__REQUIRED_AUTHENTICATION__"));
boolean needAuth = !"CASSANDRA_1_1_2".equals(version) && requireAuth;
String username = ElementParameterParser.getValue(node,"__USERNAME__");
String password = ElementParameterParser.getValue(node,"__PASSWORD__"); 
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(sstablePath);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(keySpace);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(columnFamily);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_10);
    if(needAuth){
    stringBuffer.append(TEXT_11);
    
String passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_12);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    } else {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
if (isLog4jEnabled) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
}

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
if (isLog4jEnabled) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
}

    return stringBuffer.toString();
  }
}
