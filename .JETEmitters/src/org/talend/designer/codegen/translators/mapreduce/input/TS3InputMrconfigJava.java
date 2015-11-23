package org.talend.designer.codegen.translators.mapreduce.input;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TS3InputMrconfigJava
{
  protected static String nl;
  public static synchronized TS3InputMrconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TS3InputMrconfigJava result = new TS3InputMrconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t\tMultipleInputs.addInputPath(job, ";
  protected final String TEXT_2 = "StructInputFormat.class, ChainMapper.class, \"";
  protected final String TEXT_3 = "\");" + NL + "\t\t\t\t\tchainMapper.setCid(\"";
  protected final String TEXT_4 = "\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_5 = NL + "                    // Get the password under the variable decryptedPassword";
  protected final String TEXT_6 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_7 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = "; ";
  protected final String TEXT_12 = NL + NL + "                    job.set(\"mapreduce.input.fileinputformat.inputdir\", \"s3n://\" + ";
  protected final String TEXT_13 = " +\":\" + decryptedPassword_";
  protected final String TEXT_14 = " + \"@\" + ";
  protected final String TEXT_15 = ");" + NL + "                    job.set(\"mapred.input.dir\", \"s3n://\" + ";
  protected final String TEXT_16 = " +\":\" + decryptedPassword_";
  protected final String TEXT_17 = " + \"@\" + ";
  protected final String TEXT_18 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;

INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();

if(metadatas!=null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    if(metadata != null){

        String folder = ElementParameterParser.getValue(node,"__FILENAME__");
        String s3username = ElementParameterParser.getValue(node, "__S3_USERNAME__");
        String s3bucket = ElementParameterParser.getValue(node,"__S3_BUCKET__");
        String passwordFieldName = "__S3_PASSWORD__";

		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		if(conns != null){
			if(conns.size()>0){

			    IConnection conn =conns.get(0);
				String connName = conn.getName();

				if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
				    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
                    //Cloudera Navigator parameters
                    
    stringBuffer.append(TEXT_5);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_8);
    } else {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(s3username);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(s3bucket);
    stringBuffer.append(TEXT_18);
    
				}
			}
		}
	}
}

    return stringBuffer.toString();
  }
}
