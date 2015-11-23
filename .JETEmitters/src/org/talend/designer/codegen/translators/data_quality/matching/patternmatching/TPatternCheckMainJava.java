package org.talend.designer.codegen.translators.data_quality.matching.patternmatching;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TPatternCheckMainJava
{
  protected static String nl;
  public static synchronized TPatternCheckMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPatternCheckMainJava result = new TPatternCheckMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "          ";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + "          " + NL + "      try {" + NL + "        java.util.regex.Matcher matcher_";
  protected final String TEXT_4 = " = pattern_";
  protected final String TEXT_5 = ".matcher(";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ");" + NL + "        result_";
  protected final String TEXT_8 = " = matcher_";
  protected final String TEXT_9 = ".find();" + NL + "      } catch(NullPointerException ne) {" + NL + "        result_";
  protected final String TEXT_10 = " = false;   " + NL + "      }" + NL + "          " + NL + "      if (!result_";
  protected final String TEXT_11 = ") { ";
  protected final String TEXT_12 = " " + NL + "              if(";
  protected final String TEXT_13 = " == null){  ";
  protected final String TEXT_14 = NL + "                ";
  protected final String TEXT_15 = " = new ";
  protected final String TEXT_16 = "Struct(); " + NL + "              }      ";
  protected final String TEXT_17 = NL + "                ";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = ";      ";
  protected final String TEXT_22 = "            " + NL + "        nb_line_reject_";
  protected final String TEXT_23 = "++; " + NL + "        " + NL + "      } else { ";
  protected final String TEXT_24 = " " + NL + "              if (";
  protected final String TEXT_25 = " == null) { ";
  protected final String TEXT_26 = NL + "                ";
  protected final String TEXT_27 = " = new ";
  protected final String TEXT_28 = "Struct(); " + NL + "              }        ";
  protected final String TEXT_29 = " ";
  protected final String TEXT_30 = NL + "                ";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = " = ";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = ";      ";
  protected final String TEXT_35 = "            " + NL + "        nb_line_ok_";
  protected final String TEXT_36 = "++; " + NL + "      }" + NL + "      nb_line_";
  protected final String TEXT_37 = "++; ";
  protected final String TEXT_38 = NL + "            " + NL + "            " + NL + "            " + NL + "            " + NL + "            " + NL + "            " + NL + "            " + NL + "            " + NL + "            " + NL + "            " + NL + "            " + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "            " + NL + "            " + NL + NL + NL;
  protected final String TEXT_39 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();

if ((metadatas != null) && (metadatas.size() > 0)) {
  String ColumnToCheck=ElementParameterParser.getValue(node, "__COLUMN2CHECK__");  
  String connInName = null;

  if (node.getIncomingConnections().size() == 1) {
    connInName = node.getIncomingConnections().get(0).getName();
  }
  IMetadataTable metadata = metadatas.get(0);
  
  if (metadata != null && connInName != null) {
    List<? extends IConnection> connsOut = node.getOutgoingSortedConnections();
    List<? extends IConnection> connPatternOk = node.getOutgoingConnections("ROW_PATTERN_OK");
    List<? extends IConnection> connPatternNOk = node.getOutgoingConnections("ROW_PATTERN_NOK");
     
    if (connsOut != null && connsOut.size() > 0) {
    
      for (IConnection connOut : connsOut) {        
        if (connOut.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        
    stringBuffer.append(TEXT_1);
    stringBuffer.append(connOut.getName() );
    stringBuffer.append(TEXT_2);
    
        }
      }
      
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connInName );
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
    
        if (connPatternNOk != null && connPatternNOk.size() > 0) { 
          for (int j = 0; j < connPatternNOk.size(); j++) { 
            IConnection connKO = connPatternNOk.get(j); 
            if (connKO.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
            
    stringBuffer.append(TEXT_12);
    stringBuffer.append(connKO.getName() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connKO.getName() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(connKO.getName() );
    stringBuffer.append(TEXT_16);
    
              for (IMetadataColumn column : metadata.getListColumns()) {
              
    stringBuffer.append(TEXT_17);
    stringBuffer.append(connKO.getName() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(connInName );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_21);
    
              } 
            } 
          } 
        }
        
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
        if (connPatternOk != null && connPatternOk.size() > 0) {
          for (int k = 0; k < connPatternOk.size(); k++) { 
            IConnection connOK = connPatternOk.get(k);
            if (connOK.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            
    stringBuffer.append(TEXT_24);
    stringBuffer.append(connOK.getName() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(connOK.getName() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(connOK.getName() );
    stringBuffer.append(TEXT_28);
    
              for (IMetadataColumn column : metadata.getListColumns()) {
              
    stringBuffer.append(TEXT_29);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(connOK.getName() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(connInName );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_34);
                     
              }
            } 
          } 
        } 
        
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
     
    }
  } 
}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_39);
    return stringBuffer.toString();
  }
}
