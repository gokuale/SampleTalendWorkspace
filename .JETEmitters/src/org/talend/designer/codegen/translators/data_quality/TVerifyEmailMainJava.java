package org.talend.designer.codegen.translators.data_quality;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TVerifyEmailMainJava
{
  protected static String nl;
  public static synchronized TVerifyEmailMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TVerifyEmailMainJava result = new TVerifyEmailMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " " + NL + "        String email_";
  protected final String TEXT_3 = "  = ";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = "           " + NL + "         String firstName__";
  protected final String TEXT_7 = "  = ";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = ";" + NL + "         String lastName__";
  protected final String TEXT_10 = "  = ";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = ";";
  protected final String TEXT_13 = NL + "         ";
  protected final String TEXT_14 = " = new ";
  protected final String TEXT_15 = "Struct();" + NL + "         String[] result =  emailVerify_";
  protected final String TEXT_16 = ".getVerifyResult(email_";
  protected final String TEXT_17 = ",firstName__";
  protected final String TEXT_18 = ",lastName__";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "         ";
  protected final String TEXT_21 = ".VerificationLevel = result[0];";
  protected final String TEXT_22 = NL + "         ";
  protected final String TEXT_23 = ".SuggestedEmail = result[1];";
  protected final String TEXT_24 = "              ";
  protected final String TEXT_25 = NL + "        ";
  protected final String TEXT_26 = " = new ";
  protected final String TEXT_27 = "Struct();";
  protected final String TEXT_28 = NL + "        ";
  protected final String TEXT_29 = ".VerificationLevel = emailVerify_";
  protected final String TEXT_30 = ".getVerifyResult(email_";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "           ";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = ";";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String inConnName = null;
boolean isLocalPartUseColumn = ("true").equals(ElementParameterParser.getValue(node, "__USE_COLUMN__"));


List<? extends IConnection> inConns = node.getIncomingConnections();
List<? extends IConnection> outConns = node.getOutgoingConnections();
IConnection inConn = null;
if(inConns != null && inConns.size() > 0) {
    for (IConnection conn: inConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            inConn = conn;
            inConnName = inConn.getName();
            break;
        }
    }
}
if(inConn!=null){
    List<IMetadataColumn> columnList = inConn.getMetadataTable().getListColumns();
    if(inConnName != null && columnList != null && (columnList.size() > 0) ) {
        String ColumnSource = ElementParameterParser.getValue(node, "__EMAIL_COLUMN__");
        String ColumnFirstName = ElementParameterParser.getValue(node, "__COLUMN_FIRSTNAME__");
        String ColumnLastName = ElementParameterParser.getValue(node, "__COLUMN_LASTNAME__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ColumnSource );
    stringBuffer.append(TEXT_5);
     
        String outConnName=null;
        if (outConns == null || outConns.isEmpty() || !outConns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            return "";
        } else {
            outConnName = outConns.get(0).getName();
        }
        
        if(isLocalPartUseColumn){ //use column content (first and last name)

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ColumnFirstName );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ColumnLastName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_23);
            }else{        

    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
          }
        for (IMetadataColumn inColumn : columnList) {
            String label = inColumn.getLabel();

    stringBuffer.append(TEXT_32);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_36);
    
        }
    }
}

    return stringBuffer.toString();
  }
}
