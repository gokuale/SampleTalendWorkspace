package org.talend.designer.codegen.translators.data_quality.address.loqate;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnectionCategory;

public class TLoqateAddressRowMainJava
{
  protected static String nl;
  public static synchronized TLoqateAddressRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLoqateAddressRowMainJava result = new TLoqateAddressRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "                                  ";
  protected final String TEXT_2 = ".";
  protected final String TEXT_3 = "=";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = "                " + NL + "                                  if (";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " != null) {" + NL + "                                      lqtInputRecord_";
  protected final String TEXT_9 = ".set(\"";
  protected final String TEXT_10 = "\", ";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = ");                                       " + NL + "                                  }";
  protected final String TEXT_13 = NL + "                             // Process the record" + NL + "                             lqtServer_";
  protected final String TEXT_14 = ".process(lqtInputRecord_";
  protected final String TEXT_15 = ", lqtProcessList_";
  protected final String TEXT_16 = ", lqtProcessResult_";
  protected final String TEXT_17 = ");" + NL + "                             lqtInputRecord_";
  protected final String TEXT_18 = ".clear();" + NL + "" + NL + "                             // set the output result";
  protected final String TEXT_19 = "                                    ";
  protected final String TEXT_20 = NL + "                                 ";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = " = lqtProcessResult_";
  protected final String TEXT_23 = ".getField(0, \"";
  protected final String TEXT_24 = "\");";
  protected final String TEXT_25 = "                             ";
  protected final String TEXT_26 = NL + "                             ";
  protected final String TEXT_27 = ".STATUS = lqtProcessResult_";
  protected final String TEXT_28 = ".getStatus().toString();";
  protected final String TEXT_29 = NL + "                             ";
  protected final String TEXT_30 = ".ACCURACYCODE = lqtProcessResult_";
  protected final String TEXT_31 = ".getAccuracyCode();";
  protected final String TEXT_32 = "              ";
  protected final String TEXT_33 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    List<Map<String, String>> input_address = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__INPUT_ADDRESS__");
    List<Map<String, String>> output_address = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__OUTPUT_ADDRESS__");

      
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
       IMetadataTable metadata = metadatas.get(0);
       if (metadata!=null) {
          List< ? extends IConnection> conns = node.getIncomingConnections();
          for (IConnection conn : conns) {
              if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
                  IMetadataTable metadata_input = conn.getMetadataTable();
                  List<IMetadataColumn> columnsInput = metadata_input.getListColumns();

                  List< ? extends IConnection> connsout = node.getOutgoingConnections();
                  if (connsout!=null) {
                      List<IMetadataColumn> columnsout = metadata.getListColumns();
                     
                      for (IConnection connout : connsout) {
                          if(connout!=null && connout.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                              // set right column values from the left column which name is the same
                              List exist = new ArrayList();
                              for (int j = 0; j < columnsout.size(); j++) {
                                  IMetadataColumn columnOutput=columnsout.get(j);
                                  for (int h = 0; h < columnsInput.size(); h++) {
                                      IMetadataColumn columnInput=columnsInput.get(h);
                                      if (columnOutput.getLabel().equals(columnInput.getLabel())) {
                                          exist.add(columnOutput.getLabel());
                                          break;
                                      }
                                  }
                              }
                              for (int k = 0; k < exist.size(); k++) {
                                  String label=(String)exist.get(k);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    
                              }
                              // ###### PROCESS DATA ######
                              // Set the relevant Loqate values
                              for (Map<String, String> input : input_address) {
                                  String input_address_field = input.get("ADDRESS_FIELD");
                                  String input_column = input.get("INPUT_COLUMN");

    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( input_column );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append( input_address_field );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( input_column );
    stringBuffer.append(TEXT_12);
                    
                              }

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
                             for (Map<String, String> output : output_address) {
                                 String output_address_field = output.get("ADDRESS_FIELD");
                                 String output_column = output.get("OUTPUT_COLUMN");

    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( output_column );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append( output_address_field );
    stringBuffer.append(TEXT_24);
    
                             }

    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
           
                          }
                      }
                  }
              }
          }
       }
    }

    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    return stringBuffer.toString();
  }
}
