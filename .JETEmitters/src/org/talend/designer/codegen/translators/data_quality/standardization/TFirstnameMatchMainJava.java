package org.talend.designer.codegen.translators.data_quality.standardization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFirstnameMatchMainJava
{
  protected static String nl;
  public static synchronized TFirstnameMatchMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFirstnameMatchMainJava result = new TFirstnameMatchMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\t \tif(true){" + NL + "\t\t\t\t\t \t\tthrow new RuntimeException (\"Schema type \" + \"";
  protected final String TEXT_3 = "\" + \" is not supported, existing...\" );" + NL + "\t\t\t\t\t \t}\t\t\t\t      " + NL + "\t\t\t\t\t ";
  protected final String TEXT_4 = NL + "\t\t\t\t      ";
  protected final String TEXT_5 = NL + "\t\t\t       \t  \t\tif(!(\"\").equals(";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ") && (";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = " != null))" + NL + "\t\t\t       \t  \t\t\tfirstName_";
  protected final String TEXT_10 = " = fns_";
  protected final String TEXT_11 = ".replaceNameWithGenderInfo(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ".trim(), ";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = "); " + NL + "\t\t\t\t\t  ";
  protected final String TEXT_17 = NL + "\t\t\t\t      \t\tif(!(\"\").equals(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ")  && ";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = " != null)" + NL + "\t\t\t\t      \t\t\tfirstName_";
  protected final String TEXT_22 = " =\tfns_";
  protected final String TEXT_23 = ".replaceNameWithCountryInfo(";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = ", ";
  protected final String TEXT_28 = ");" + NL + "\t\t\t\t      ";
  protected final String TEXT_29 = NL + "\t\t\t\t       \t \tif(!(\"\").equals(";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = ") && ";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = " != null)" + NL + "\t\t\t\t       \t \t\tfirstName_";
  protected final String TEXT_34 = " = fns_";
  protected final String TEXT_35 = ".replaceNameWithCountryGenderInfo(";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = ", ";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = ", ";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ");\t\t\t\t       \t\t\t\t" + NL + "\t\t\t\t      ";
  protected final String TEXT_43 = NL + "\t\t\t\t      \t\t\tfirstName_";
  protected final String TEXT_44 = " = fns_";
  protected final String TEXT_45 = ".replaceName(";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = ",";
  protected final String TEXT_48 = ");" + NL + "\t\t\t\t      ";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t  ";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_51 = "=null;" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_52 = "=new ";
  protected final String TEXT_53 = "Struct();" + NL + "\t\t\t\t\t  ";
  protected final String TEXT_54 = NL + "\t\t\t\t\t  ";
  protected final String TEXT_55 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = ";" + NL + "\t\t\t\t\t  ";
  protected final String TEXT_60 = NL + "\t\t\t\t\t\t\t\t\t \t";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = " =firstName_";
  protected final String TEXT_63 = ";\t" + NL + "\t\t\t\t\t  ";
  protected final String TEXT_64 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_65 = NL + NL + NL + NL + "\t\t      ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String nameColumn = ElementParameterParser.getValue(node,"__COLUMNNAMES__");
	String genderColumn = ElementParameterParser.getValue(node, "__GENDER__");
	String countryColumn = ElementParameterParser.getValue(node, "__COUNTRY__");
	
	boolean useGender = ("true").equals(ElementParameterParser.getValue(node, "__CHECKGENDER__"));
	boolean useCountry = ("true").equals(ElementParameterParser.getValue(node, "__CHECKCOUNTRY__"));
	boolean isFuzzy = ("true").equals(ElementParameterParser.getValue(node, "__CHECKFUZZY__"));
	
	String inputColumn = ElementParameterParser.getValue(node,"__COLUMNS__");
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	
	if ((metadatas!=null)&&(metadatas.size()>0)) {
	    IMetadataTable metadata = metadatas.get(0);
	    if(metadata != null) {
	       List<IMetadataColumn> columns = metadata.getListColumns();
    	   int sizeColumns = columns.size();
	       List<? extends IConnection> conns = node.getIncomingConnections();
	       List<? extends IConnection> conns_out = node.getOutgoingConnections();
		   List<? extends IConnection> connsOut = node.getOutgoingConnections("OUTPUT");
		   JavaType javaType = null;
           String connName = "";
           Boolean isRightType = false;

    
        for (IConnection conn : conns) {
           	 IConnection con = conns.get(0);
           	 connName = con.getName();
    		 if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	    		 for(int column=0; column<sizeColumns; column++){
	    			
	    		    javaType = JavaTypesManager.getJavaTypeFromId(columns.get(column).getTalendType());
	    		    boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, columns.get(column).isNullable());
	    		    String columnLabel = columns.get(column).toString();
	    		    boolean currentColumnIsGender = useGender && columnLabel.equals(genderColumn);
	    		    boolean currentColumnIsCountry = useCountry && columnLabel.equals(countryColumn);
	    		    boolean currentColumnIsFirstName = columnLabel.equals(nameColumn);
	    		 	if((currentColumnIsFirstName || currentColumnIsGender || currentColumnIsCountry) && javaType != JavaTypesManager.STRING){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(javaType.getLabel());
    stringBuffer.append(TEXT_3);
                       
                      	break;
				     }
				     else {
				      
    stringBuffer.append(TEXT_4);
    
			       		 if( useGender &&!useCountry &&columns.get(column).toString().equals(nameColumn)) {
			       	  
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(nameColumn);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(nameColumn);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(nameColumn);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genderColumn);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(isFuzzy);
    stringBuffer.append(TEXT_16);
    }
			       		 else if(!useGender && useCountry && columns.get(column).toString().equals(genderColumn)) {
				      
    stringBuffer.append(TEXT_17);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(nameColumn);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(nameColumn);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(nameColumn);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(countryColumn);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(isFuzzy);
    stringBuffer.append(TEXT_28);
    
				       	 }
			       		 else if(useCountry && useGender &&  columns.get(column).toString().equals(countryColumn)) {
				       
    stringBuffer.append(TEXT_29);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(nameColumn);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(nameColumn);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(nameColumn);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(countryColumn);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genderColumn);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(isFuzzy);
    stringBuffer.append(TEXT_42);
     }
			       		else if(!useCountry && !useGender &&  columns.get(column).toString().equals(countryColumn)) {
				      
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(nameColumn);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(isFuzzy);
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    
						}
			 	 }
							if(conns_out != null && connsOut!=null && conns_out.size()>0 ) {
								for(IConnection conn_o:connsOut) {
					  
    stringBuffer.append(TEXT_50);
    stringBuffer.append(conn_o.getName());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(conn_o.getName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(conn_o.getName());
    stringBuffer.append(TEXT_53);
    
								}
					  
    stringBuffer.append(TEXT_54);
    
								for (int j = 0; j < sizeColumns; j++) {
									if(!columns.get(j).getLabel().equals("FIRSTNAMEMATCH")){
					  
    stringBuffer.append(TEXT_55);
    stringBuffer.append(conns_out.get(0).getName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(columns.get(j).getLabel());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(columns.get(j).getLabel());
    stringBuffer.append(TEXT_59);
    				
									 }
									 else {
					  
    stringBuffer.append(TEXT_60);
    stringBuffer.append(conns_out.get(0).getName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(columns.get(j).getLabel());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
								    }
					  
    stringBuffer.append(TEXT_64);
      	
								}
						
    
				             }
				  }
             }

        }
    }

    stringBuffer.append(TEXT_65);
    return stringBuffer.toString();
  }
}
