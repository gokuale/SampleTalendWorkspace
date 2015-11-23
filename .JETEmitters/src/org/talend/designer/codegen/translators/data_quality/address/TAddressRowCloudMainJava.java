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

public class TAddressRowCloudMainJava
{
  protected static String nl;
  public static synchronized TAddressRowCloudMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAddressRowCloudMainJava result = new TAddressRowCloudMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "                                  ";
  protected final String TEXT_2 = ".";
  protected final String TEXT_3 = "=";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL + "                              org.talend.dataquality.address.api.AddressObject addressObj = new org.talend.dataquality.address.api.AddressObject(\"\");";
  protected final String TEXT_7 = "                " + NL + "                                  if (";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = " != null && !\"\".equals(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = ".trim())) {" + NL + "                                      addressObj.set";
  protected final String TEXT_12 = "(";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = ".trim());" + NL + "                                  }";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = NL + "                                  // for google and qas provider,we set address as format \"Address, Locality, Administrative, PostalCode, Country\"" + NL + "                                  java.util.ArrayList<String> addressList = new java.util.ArrayList<String>();" + NL + "                                  addressList.add(addressObj.getOriginalAddress());" + NL + "                                  addressList.add(addressObj.getOriginalLocality());" + NL + "                                  addressList.add(addressObj.getOriginalAdminiArea());" + NL + "                                  addressList.add(addressObj.getOriginalPostalCode());" + NL + "                                  addressList.add(addressObj.getOriginalCountry());" + NL + "                                  java.util.Collection<String> nullCon = new java.util.Vector<String>();" + NL + "                                  nullCon.add(null);" + NL + "                                  addressList.removeAll(nullCon);" + NL + "                                  addressObj.setOriginalAddress(org.apache.commons.lang.StringUtils.join(addressList, \", \"));";
  protected final String TEXT_17 = "                            " + NL + "                              org.talend.dataquality.address.api.AddressObject result_";
  protected final String TEXT_18 = ";" + NL + "                              try {" + NL + "                                  // normalize Address" + NL + "                                  engine_";
  protected final String TEXT_19 = ".normalizeAddress(addressObj);" + NL + "                             " + NL + "                                  // get result" + NL + "                                  result_";
  protected final String TEXT_20 = " = engine_";
  protected final String TEXT_21 = ".getHeadAddressObject();" + NL + "                              } catch (org.talend.dataquality.address.api.AddressApiException e) {" + NL + "                                  System.err.println(e.getMessage());" + NL + "                                  e.printStackTrace();" + NL + "                                  return;" + NL + "                              }" + NL + "" + NL + "                              // set the output result";
  protected final String TEXT_22 = NL + "                              ";
  protected final String TEXT_23 = ".Status = result_";
  protected final String TEXT_24 = ".getStatus();";
  protected final String TEXT_25 = NL + "                              ";
  protected final String TEXT_26 = ".AddressVerificationCode = result_";
  protected final String TEXT_27 = ".getAddressVerificationCode();";
  protected final String TEXT_28 = NL + "                              ";
  protected final String TEXT_29 = ".VerificationLevel = result_";
  protected final String TEXT_30 = ".getVerificationLevel();";
  protected final String TEXT_31 = NL + "                              ";
  protected final String TEXT_32 = ".FormattedAddress = result_";
  protected final String TEXT_33 = ".getFormattedAddress();";
  protected final String TEXT_34 = NL + "                              ";
  protected final String TEXT_35 = ".StreetNumber = result_";
  protected final String TEXT_36 = ".getStreetNumber();";
  protected final String TEXT_37 = NL + "                              ";
  protected final String TEXT_38 = ".Route = result_";
  protected final String TEXT_39 = ".getRoute();";
  protected final String TEXT_40 = NL + "                              ";
  protected final String TEXT_41 = ".Locality = result_";
  protected final String TEXT_42 = ".getLocality();";
  protected final String TEXT_43 = NL + "                              ";
  protected final String TEXT_44 = ".AdministrationAreaLevel1 = result_";
  protected final String TEXT_45 = ".getAdministrationAreaLevel1();";
  protected final String TEXT_46 = NL + "                              ";
  protected final String TEXT_47 = ".AdministrationAreaLevel2 = result_";
  protected final String TEXT_48 = ".getAdministrationAreaLevel2();";
  protected final String TEXT_49 = NL + "                              ";
  protected final String TEXT_50 = ".Country = result_";
  protected final String TEXT_51 = ".getCountry();";
  protected final String TEXT_52 = NL + "                              ";
  protected final String TEXT_53 = ".PostalCodeLong = result_";
  protected final String TEXT_54 = ".getPostalCodeLong();";
  protected final String TEXT_55 = NL + "                              ";
  protected final String TEXT_56 = ".PostalCodeShort = result_";
  protected final String TEXT_57 = ".getPostalCodeShort();";
  protected final String TEXT_58 = NL + "                              ";
  protected final String TEXT_59 = ".Longitude = result_";
  protected final String TEXT_60 = ".getLongitude();";
  protected final String TEXT_61 = NL + "                              ";
  protected final String TEXT_62 = ".Latitude = result_";
  protected final String TEXT_63 = ".getLatitude();" + NL + "                              ";
  protected final String TEXT_64 = NL + "                                  ";
  protected final String TEXT_65 = ".";
  protected final String TEXT_66 = " = result_";
  protected final String TEXT_67 = ".getResultColumn(\"";
  protected final String TEXT_68 = "\");";
  protected final String TEXT_69 = "              ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String api_type = ElementParameterParser.getValue(node, "__API_TYPE__");
    List<Map<String, String>> input_address = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__INPUT_ADDRESS__");
    List<Map<String, String>> additional_output_mapping = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__OUTPUT_MAPPING__");

      
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

    stringBuffer.append(TEXT_6);
                                  
                              for (Map<String, String> input : input_address) {
                                  String input_address_field = input.get("ADDRESS_FIELD");
                                  String input_column = input.get("INPUT_COLUMN");
                                  String methodName = input_address_field.substring(0,1).toUpperCase()+input_address_field.substring(1);

    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( input_column );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( input_column );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(methodName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( input_column );
    stringBuffer.append(TEXT_14);
                    
                              }

    stringBuffer.append(TEXT_15);
    
                              if ("GOOGLE".equals(api_type) || "QAS".equals(api_type)) {

    stringBuffer.append(TEXT_16);
    
                              }
                              
                              

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
                              for (Map<String, String> output : additional_output_mapping) {
                                  String output_address_field = output.get("ADDRESS_FIELD");
                                  String output_column = output.get("OUTPUT_COLUMN");
                              
    stringBuffer.append(TEXT_64);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( output_column );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append( output_address_field );
    stringBuffer.append(TEXT_68);
    
                              }
                          }
                      }
                  }
              }
          }
       }
    }

    stringBuffer.append(TEXT_69);
    return stringBuffer.toString();
  }
}
