package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;

public class TActionInputInMainJava
{
  protected static String nl;
  public static synchronized TActionInputInMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TActionInputInMainJava result = new TActionInputInMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t\tObject ";
  protected final String TEXT_2 = " = map_";
  protected final String TEXT_3 = ".get(\"";
  protected final String TEXT_4 = "\");" + NL + "\t\t\t\t\tif (null != ";
  protected final String TEXT_5 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = " = (";
  protected final String TEXT_8 = ") ";
  protected final String TEXT_9 = ";" + NL + "\t\t\t\t\t}";
  protected final String TEXT_10 = NL + "\t\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_11 = " = new routines.system.Dynamic();" + NL + "\t\t\t\t\tdynamic_";
  protected final String TEXT_12 = ".clearColumnValues();" + NL + "\t\t\t\t\tif (dynamic_map_";
  protected final String TEXT_13 = " != null) {" + NL + "\t\t\t\t\t\tjava.util.Iterator<java.util.Map.Entry<IPaasField, Object>> dynamicIterator_";
  protected final String TEXT_14 = " = dynamic_map_";
  protected final String TEXT_15 = ".entrySet().iterator();" + NL + "\t\t\t\t\t\tint ind_";
  protected final String TEXT_16 = " = 0;" + NL + "\t\t\t\t\t\twhile (dynamicIterator_";
  protected final String TEXT_17 = ".hasNext()) {" + NL + "\t\t\t\t\t\t\tjava.util.Map.Entry<IPaasField, Object> entry_";
  protected final String TEXT_18 = " = dynamicIterator_";
  protected final String TEXT_19 = ".next();" + NL + "\t\t\t\t\t\t\tIPaasField ipaasField_";
  protected final String TEXT_20 = " = entry_";
  protected final String TEXT_21 = ".getKey();" + NL + "\t\t\t\t\t\t\troutines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_22 = " = new routines.system.DynamicMetadata();" + NL + "\t\t\t\t    \t\tdynamicMetadata_";
  protected final String TEXT_23 = ".setName(ipaasField_";
  protected final String TEXT_24 = ".getName().replaceAll(\"[ .-]+\", \"_\"));" + NL + "\t\t\t\t    \t\tdynamicMetadata_";
  protected final String TEXT_25 = ".setDbName(dynamicMetadata_";
  protected final String TEXT_26 = ".getName());" + NL + "\t\t\t\t    \t\tdynamicMetadata_";
  protected final String TEXT_27 = ".setType(ipaasField_";
  protected final String TEXT_28 = ".getType() == null ? \"id_String\" : ipaasField_";
  protected final String TEXT_29 = ".getType());" + NL + "\t\t\t\t    \t\tdynamicMetadata_";
  protected final String TEXT_30 = ".setDbType(\"VARCHAR\");" + NL + "\t\t\t\t    \t\tdynamicMetadata_";
  protected final String TEXT_31 = ".setLength(ipaasField_";
  protected final String TEXT_32 = ".getLength() > 0 ? ipaasField_";
  protected final String TEXT_33 = ".getLength() : 100);" + NL + "\t\t\t\t    \t\tdynamicMetadata_";
  protected final String TEXT_34 = ".setPrecision(0);" + NL + "\t\t\t\t    \t\tdynamicMetadata_";
  protected final String TEXT_35 = ".setNullable(true);" + NL + "\t\t\t\t    \t\tdynamicMetadata_";
  protected final String TEXT_36 = ".setKey(false);" + NL + "\t\t\t\t    \t\t//TODO Handle source type" + NL + "\t\t\t\t    \t\t//dynamicMetadata_";
  protected final String TEXT_37 = ".setSourceType(routines.system.DynamicMetadata.sourceTypes.demilitedFile);" + NL + "\t\t\t\t    \t\tdynamic_";
  protected final String TEXT_38 = ".metadatas.add(dynamicMetadata_";
  protected final String TEXT_39 = ");" + NL + "\t\t\t\t    \t\tdynamicMetadata_";
  protected final String TEXT_40 = ".setColumnPosition(ind_";
  protected final String TEXT_41 = ");" + NL + "\t\t\t\t    \t\tdynamic_";
  protected final String TEXT_42 = ".addColumnValue(entry_";
  protected final String TEXT_43 = ".getValue());" + NL + "\t\t\t\t    \t\tind_";
  protected final String TEXT_44 = "++;" + NL + "\t\t\t\t    \t}" + NL + "\t\t\t\t    }" + NL + "\t\t\t    \t";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = " = dynamic_";
  protected final String TEXT_47 = ";";
  protected final String TEXT_48 = NL + "\t\t\t\t\tif (map_";
  protected final String TEXT_49 = ".get(\"";
  protected final String TEXT_50 = "\") instanceof org.dom4j.Document) {" + NL + "\t\t\t\t\t\troutines.system.Document doc_";
  protected final String TEXT_51 = " = new routines.system.Document();" + NL + "\t\t\t\t\t\tdoc_";
  protected final String TEXT_52 = ".setDocument((org.dom4j.Document) map_";
  protected final String TEXT_53 = ".get(\"";
  protected final String TEXT_54 = "\"));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = " = doc_";
  protected final String TEXT_57 = ";" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = " = (";
  protected final String TEXT_60 = ") map_";
  protected final String TEXT_61 = ".get(\"";
  protected final String TEXT_62 = "\");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_63 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = " = (";
  protected final String TEXT_66 = ") map_";
  protected final String TEXT_67 = ".get(\"";
  protected final String TEXT_68 = "\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();
		cid = cid.replaceAll("_In", "");

		List< ? extends IConnection> outputConnections = node.getOutgoingSortedConnections();
		String dataOutputConnection = null;
		for(IConnection conn : outputConnections) {
			if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				dataOutputConnection = conn.getName();
				break;
			} // if(conn) end
		} // for(conns) end

		List<IMetadataTable> metadatas = node.getMetadataList();
		IMetadataTable metadata = null;
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			metadata = metadatas.get(0);
		}
	
		if(dataOutputConnection != null && metadata != null){
			List<IMetadataColumn> columns = metadata.getListColumns();
			for(IMetadataColumn c: columns){
				String label = c.getLabel();
				String type = c.getComment();
				if (type == null || type.trim().equals("")) {
					type = JavaTypesManager.getTypeToGenerate(c.getTalendType(), c.isNullable());
				}
				if (JavaTypesManager.isJavaPrimitiveType(type)) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(c.getTalendType(), true));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_9);
    
				} else if (type.equals("Dynamic")) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    				} else if (type.equals("Document")) {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_62);
    				} else {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_68);
    				}
			}
		}

    return stringBuffer.toString();
  }
}
