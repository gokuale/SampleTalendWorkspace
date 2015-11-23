package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TActionInputLoopBeginJava
{
  protected static String nl;
  public static synchronized TActionInputLoopBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TActionInputLoopBeginJava result = new TActionInputLoopBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t" + NL + "\t// TODO: (iPaasObject == null) ? < %=JavaTypesManager.getDefaultValueFromJavaType(type, c.getDefault())% >" + NL + "\tjava.util.Map<String, Object> map_";
  protected final String TEXT_3 = ";" + NL + "\tint rowsCount_";
  protected final String TEXT_4 = " = 0;" + NL + "\tjava.util.List<java.util.Map<String, Object>> mapList_";
  protected final String TEXT_5 = " = new java.util.ArrayList<java.util.Map<String, Object>>();" + NL + "\tint dynamicRowsCount_";
  protected final String TEXT_6 = " = 0;" + NL + "\t";
  protected final String TEXT_7 = NL + "\tjava.util.Map<IPaasField, Object> dynamic_map_";
  protected final String TEXT_8 = " = null;" + NL + "\tjava.util.List<java.util.Map<IPaasField, Object>> dynamicMapList_";
  protected final String TEXT_9 = " = new java.util.ArrayList<java.util.Map<IPaasField, Object>>();" + NL + "\t";
  protected final String TEXT_10 = NL + "\tif (iPaasObject != null){" + NL + "\t\tmap_";
  protected final String TEXT_11 = " = iPaasObject.take();" + NL + "\t\t";
  protected final String TEXT_12 = NL + "\t\ttry {" + NL + "\t\t\tdynamic_map_";
  protected final String TEXT_13 = " = iPaasObject.takeDynamic();" + NL + "\t\t} catch (java.lang.NoSuchMethodError nc_";
  protected final String TEXT_14 = ") {" + NL + "\t\t\tthrow new java.lang.Exception(\"Dynamic types don't supported in this version\");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_15 = NL + "\t}else {" + NL + "\t";
  protected final String TEXT_16 = NL + "\t\tdynamic_map_";
  protected final String TEXT_17 = " = new java.util.LinkedHashMap<IPaasField, Object>();" + NL + "\t";
  protected final String TEXT_18 = NL + "\t \tmap_";
  protected final String TEXT_19 = " = new java.util.HashMap<String,Object>();" + NL + "\t";
  protected final String TEXT_20 = NL + "\t\t\t\tIPaasFieldImpl ipaasField_";
  protected final String TEXT_21 = " = new IPaasFieldImpl(";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\t\t\t\tipaasField_";
  protected final String TEXT_24 = ".setLength(";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\t\t\t\tipaasField_";
  protected final String TEXT_27 = ".setLength(100);";
  protected final String TEXT_28 = NL + "\t\t\t\tipaasField_";
  protected final String TEXT_29 = ".setLength(";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "\t\t\t\tipaasField_";
  protected final String TEXT_32 = ".setType(\"";
  protected final String TEXT_33 = "\");" + NL + "\t\t\t\tdynamic_map_";
  protected final String TEXT_34 = ".put(ipaasField_";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "\t\t\tdynamicMapList_";
  protected final String TEXT_38 = ".add(dynamic_map_";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = "        \t  " + NL + "\t\t\t\tmap_";
  protected final String TEXT_41 = ".put(\"";
  protected final String TEXT_42 = "\",";
  protected final String TEXT_43 = ");        \t            \t";
  protected final String TEXT_44 = "        \t            \t" + NL + "\t\t\t\tmap_";
  protected final String TEXT_45 = ".put(\"";
  protected final String TEXT_46 = "\", ";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + " \t  \t\t\tmapList_";
  protected final String TEXT_49 = ".add(map_";
  protected final String TEXT_50 = ");" + NL + " \t  \t\t\tmap_";
  protected final String TEXT_51 = " = new java.util.HashMap<String,Object>();";
  protected final String TEXT_52 = NL + "\t\t\tif (mapList_";
  protected final String TEXT_53 = ".size() > 0){" + NL + "\t\t\t\tmap_";
  protected final String TEXT_54 = " = mapList_";
  protected final String TEXT_55 = ".get(rowsCount_";
  protected final String TEXT_56 = ");" + NL + "\t\t\t}else{" + NL + "\t\t\t\tmap_";
  protected final String TEXT_57 = " = null;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\tif(dynamicMapList_";
  protected final String TEXT_59 = ".size() > 0) {" + NL + "\t\t\t\tdynamic_map_";
  protected final String TEXT_60 = " = dynamicMapList_";
  protected final String TEXT_61 = ".get(dynamicRowsCount_";
  protected final String TEXT_62 = ");" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdynamic_map_";
  protected final String TEXT_63 = " = null;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t}" + NL + "" + NL + "\twhile(null != map_";
  protected final String TEXT_65 = NL + "\t ";
  protected final String TEXT_66 = NL + "\t || null != dynamic_map_";
  protected final String TEXT_67 = NL + "\t  ";
  protected final String TEXT_68 = NL + "\t  ) {" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();
		cid = cid.replaceAll("_Loop", "");
		
		List<Map<String,String>> tableValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(
	        node, "__DYNAMIC_VALUES__");
		
		List<IMetadataTable> metadatas = node.getMetadataList();
		IMetadataTable metadata = null;
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			metadata = metadatas.get(0);    
    	}
		
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    if (metadata.isDynamicSchema()) { 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    if (metadata.isDynamicSchema()) { 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    if (metadata.isDynamicSchema()) { 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
		String nbRows = ElementParameterParser.getValue(node, "__NB_ROWS__");

		List<Map<String, String>> inTableValues =
    		(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TESTDATA__");
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		String firstConnName = "";	
            for(IConnection conn : conns) {
                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
             		firstConnName = conn.getName();
             		break;
                }
     }
     
     if (metadata.isDynamicSchema()) {
		    int counter = 0;
			for(Map<String, String> tableValue : tableValues) {
	            String name = tableValue.get("DYNAMIC_NAME");
    	        String value = tableValue.get("DYNAMIC_VALUE");
    	        String dynamicType = tableValue.get("DYNAMIC_TYPE");
    	        String length = tableValue.get("DYNAMIC_LENGTH");
    	        counter++;

    stringBuffer.append(TEXT_20);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_22);
     if (length != null && !length.isEmpty()) { 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(length);
    stringBuffer.append(TEXT_25);
     } else if (tableValue.get("VALUE") == null) { 
    stringBuffer.append(TEXT_26);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_27);
     } else {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(tableValue.get("VALUE"));
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(dynamicType);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(value );
    stringBuffer.append(TEXT_36);
                  
            }

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
    }
	for(Map<String, String> tableValue : inTableValues) {
   	for(IMetadataColumn column3: metadata.getListColumns()){
     	String label3 = column3.getLabel();
	   	String value3 = tableValue.get(label3);
	      if(value3 == null || value3.length() == 0){ //use the default value
	         String typeToGenerate = JavaTypesManager.getTypeToGenerate(column3.getTalendType(), column3.isNullable());
	  	      String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column3.getDefault());

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(label3 );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_43);
    
      	}else{

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(label3 );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(value3 );
    stringBuffer.append(TEXT_47);
    
   	   }
 	  	}

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
 	 }

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    if (metadata.isDynamicSchema()) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    if (metadata.isDynamicSchema()) {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    return stringBuffer.toString();
  }
}
