package org.talend.designer.codegen.translators.data_quality.address;

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

public class TBatchAddressRowCloudOutMainJava
{
  protected static String nl;
  public static synchronized TBatchAddressRowCloudOutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBatchAddressRowCloudOutMainJava result = new TBatchAddressRowCloudOutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "   ";
  protected final String TEXT_2 = " " + NL + "                  handler_";
  protected final String TEXT_3 = ".addOutputRecord(";
  protected final String TEXT_4 = ");" + NL + "                  org.talend.dataquality.address.api.AddressObject addressObject = new org.talend.dataquality.address.api.AddressObject(\"\");";
  protected final String TEXT_5 = "                   " + NL + "                  addressObject.set";
  protected final String TEXT_6 = "(String.valueOf(";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = "));";
  protected final String TEXT_9 = NL + "                  engine_";
  protected final String TEXT_10 = ".normalizeAddress(addressObject);";
  protected final String TEXT_11 = "   " + NL;
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    List<Map<String, String>> input_address = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__INPUT_ADDRESS__");
    List<Map<String, String>> additional_output_mapping = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__OUTPUT_MAPPING__");

    stringBuffer.append(TEXT_1);
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
       IMetadataTable metadata = metadatas.get(0);
       if (metadata!=null) {
          List< ? extends IConnection> conns = node.getIncomingConnections();
          for (IConnection conn : conns) {
              if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_4);
    
              for (Map<String, String> input : input_address) {
                  String input_address_field = input.get("ADDRESS_FIELD");
                  String input_column = input.get("INPUT_COLUMN");
                  String methodName = input_address_field;

    stringBuffer.append(TEXT_5);
    stringBuffer.append(methodName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( input_column );
    stringBuffer.append(TEXT_8);
    
              }

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
              }
          }
       }
    }

    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
