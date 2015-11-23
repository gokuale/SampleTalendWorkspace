package org.talend.designer.codegen.translators.data_quality.matching.patternmatching;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TPatternExtractMainJava
{
  protected static String nl;
  public static synchronized TPatternExtractMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPatternExtractMainJava result = new TPatternExtractMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "                    ";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + NL + "                    try {" + NL + "                        java.util.regex.Matcher matcher_";
  protected final String TEXT_4 = " = pattern_";
  protected final String TEXT_5 = ".matcher(";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ");" + NL + "                        result_";
  protected final String TEXT_8 = " = matcher_";
  protected final String TEXT_9 = ".find();" + NL + "                        match_";
  protected final String TEXT_10 = " = matcher_";
  protected final String TEXT_11 = ".group();" + NL + "                    } catch (NullPointerException ne) {" + NL + "                        result_";
  protected final String TEXT_12 = "=false;" + NL + "                    } catch (java.lang.IllegalStateException ISE) {" + NL + "                        result_";
  protected final String TEXT_13 = "=false;" + NL + "                    }" + NL + "" + NL + "                    if (!result_";
  protected final String TEXT_14 = ") {" + NL;
  protected final String TEXT_15 = NL + "                                        if (";
  protected final String TEXT_16 = " == null) { ";
  protected final String TEXT_17 = NL + "                                            ";
  protected final String TEXT_18 = " = new ";
  protected final String TEXT_19 = "Struct();" + NL + "                                        }";
  protected final String TEXT_20 = NL + "                                        ";
  protected final String TEXT_21 = ".MATCH = \"No Pattern Found\";" + NL;
  protected final String TEXT_22 = NL + "                                            ";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = NL + "                                        //";
  protected final String TEXT_28 = ".MATCH = \"No Pattern Found\";";
  protected final String TEXT_29 = NL + "                        nb_line_reject_";
  protected final String TEXT_30 = "++;" + NL + "                    }  else {";
  protected final String TEXT_31 = NL + "                                        if(";
  protected final String TEXT_32 = " == null){ ";
  protected final String TEXT_33 = NL + "                                            ";
  protected final String TEXT_34 = " = new ";
  protected final String TEXT_35 = "Struct();" + NL + "                                        }";
  protected final String TEXT_36 = NL + "                                        ";
  protected final String TEXT_37 = ".MATCH =match_";
  protected final String TEXT_38 = ";" + NL;
  protected final String TEXT_39 = NL + "                                            ";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = ";";
  protected final String TEXT_44 = NL + "                                        //";
  protected final String TEXT_45 = ".MATCH =match_";
  protected final String TEXT_46 = ";";
  protected final String TEXT_47 = NL + "                        nb_line_ok_";
  protected final String TEXT_48 = "++;" + NL + "                    }" + NL + "                    nb_line_";
  protected final String TEXT_49 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String ColumnToCheck = ElementParameterParser.getValue(node, "__COLUMN2CHECK__");

// Input link definition
String connName = null;

if (node.getIncomingConnections().size() == 1) {
    IConnection conn = node.getIncomingConnections().get(0);
    connName = conn.getName();
}
List<IMetadataTable> metadatas = node.getMetadataList();

if ((metadatas != null) && (metadatas.size() > 0)) {
    IMetadataTable metadata = metadatas.get(0);
    List<IMetadataColumn> columnsout = metadata.getListColumns();

    if (metadata != null && connName != null) {
        List<? extends IConnection> conns = node.getOutgoingSortedConnections();
        List<? extends IConnection> connPatternOk = node.getOutgoingConnections("ROW_PATTERN_OK");
        List<? extends IConnection> connPatternNOk = node.getOutgoingConnections("ROW_PATTERN_NOK");

        if (conns != null) {

            for (IConnection conn : conns) {

                if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_2);
    
				}
			}

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ColumnToCheck );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
                        if (connPatternNOk != null) {

                            if (connPatternNOk.size() > 0) {

                                for (int j = 0; j < connPatternNOk.size(); j++) {
                                    IConnection connKO = connPatternNOk.get(j);

                                    if (connKO.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                                    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(connKO.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(connKO.getName() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(connKO.getName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(connKO.getName() );
    stringBuffer.append(TEXT_21);
    
                                        for (int m = 0; m < columnsout.size() - 1; m++) {
                                            IMetadataColumn column = columnsout.get(m);
                                            // for (IMetadataColumn column: metadata.getListColumns()) {
                                             
    stringBuffer.append(TEXT_22);
    stringBuffer.append(connKO.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_26);
     }
    stringBuffer.append(TEXT_27);
    stringBuffer.append(connKO.getName() );
    stringBuffer.append(TEXT_28);
    
                                    } 
                                }
                            }
                        }
                        
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
                        if (connPatternOk != null) {

                            if (connPatternOk.size() > 0) {

                                for (int k = 0; k < connPatternOk.size(); k++) {
                                    IConnection connOK = connPatternOk.get(k);

                                    if (connOK.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                                    
    stringBuffer.append(TEXT_31);
    stringBuffer.append(connOK.getName() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(connOK.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(connOK.getName() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(connOK.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
                                        for (int n = 0; n < columnsout.size() - 1; n++) {
                                            IMetadataColumn column = columnsout.get(n);
                                            // for (IMetadataColumn column: metadata.getListColumns()) {
                                            
    stringBuffer.append(TEXT_39);
    stringBuffer.append(connOK.getName() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(connOK.getName() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
                                    }
                                }
                            }
                        }
                        
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
        }
    }
}
    return stringBuffer.toString();
  }
}
