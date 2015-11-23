package org.talend.designer.codegen.translators.custom_code;

import java.util.List;
import java.util.Map;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSetDynamicSchemaMainJava
{
  protected static String nl;
  public static synchronized TSetDynamicSchemaMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSetDynamicSchemaMainJava result = new TSetDynamicSchemaMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\troutines.system.DynamicMetadata dynamicMetadataColumn_";
  protected final String TEXT_2 = " = new routines.system.DynamicMetadata();";
  protected final String TEXT_3 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = "==null||\"\".equals(";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ")){" + NL + "\t\t\t\t\t\t\tdynamicMetadataColumn_";
  protected final String TEXT_8 = ".setType(\"id_String\");" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tdynamicMetadataColumn_";
  protected final String TEXT_9 = ".setType(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = ");" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_12 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = "==null||\"\".equals(";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = ")){" + NL + "\t\t\t\t\t\t\tdynamicMetadataColumn_";
  protected final String TEXT_17 = ".setDbType(\"VARCHAR\");" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tdynamicMetadataColumn_";
  protected final String TEXT_18 = ".setDbType(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ");" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_21 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = "==null){" + NL + "\t\t\t\t\t\t\tdynamicMetadataColumn_";
  protected final String TEXT_24 = ".setPrecision(0);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tdynamicMetadataColumn_";
  protected final String TEXT_25 = ".setPrecision(";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = ");" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\tdynamicMetadataColumn_";
  protected final String TEXT_29 = ".set";
  protected final String TEXT_30 = "(";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "\t\t\t\tdynamic_";
  protected final String TEXT_34 = ".metadatas.add(dynamicMetadataColumn_";
  protected final String TEXT_35 = "); ";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\t\t\t\t\t\t" + NL + "" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    List<Map<String,String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING__");
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		List< ? extends IConnection> conns = node.getIncomingConnections();
		if((conns!=null)&&(conns.size()>0)) {
			IConnection conn = conns.get(0);
			String conn_name = conn.getName();
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
				for(Map<String,String> map:mapping) {
					if("Type".equals(map.get("PROPERTY"))){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn_name);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(map.get("VALUE"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(conn_name);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(map.get("VALUE"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn_name);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(map.get("VALUE"));
    stringBuffer.append(TEXT_11);
    
					}else if("DbType".equals(map.get("PROPERTY"))){

    stringBuffer.append(TEXT_12);
    stringBuffer.append(conn_name);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(map.get("VALUE"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(conn_name);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(map.get("VALUE"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(conn_name);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(map.get("VALUE"));
    stringBuffer.append(TEXT_20);
    
					}else if("Precision".equals(map.get("PROPERTY"))){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(conn_name);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(map.get("VALUE"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(conn_name);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(map.get("VALUE"));
    stringBuffer.append(TEXT_27);
    
					}else{

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(map.get("PROPERTY"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(conn_name);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(map.get("VALUE"));
    stringBuffer.append(TEXT_32);
    
					}
				}

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
			}
		}
	}

    stringBuffer.append(TEXT_36);
    return stringBuffer.toString();
  }
}
