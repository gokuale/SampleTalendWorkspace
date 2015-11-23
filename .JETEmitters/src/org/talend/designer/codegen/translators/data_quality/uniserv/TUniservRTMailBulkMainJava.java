package org.talend.designer.codegen.translators.data_quality.uniserv;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class TUniservRTMailBulkMainJava
{
  protected static String nl;
  public static synchronized TUniservRTMailBulkMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniservRTMailBulkMainJava result = new TUniservRTMailBulkMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t\tif(";
  protected final String TEXT_2 = ".";
  protected final String TEXT_3 = "!=null) {" + NL + "\t\t\t\t\t\th_";
  protected final String TEXT_4 = ".put(\"";
  protected final String TEXT_5 = "\", ";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_8 = NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tmailClient_";
  protected final String TEXT_9 = ".setArg(h_";
  protected final String TEXT_10 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t\t\tint returnCode_";
  protected final String TEXT_11 = " = mailClient_";
  protected final String TEXT_12 = ".mailLoadInsert(mailError_";
  protected final String TEXT_13 = ");" + NL + "\t\t\t\t\tif(returnCode_";
  protected final String TEXT_14 = "==0) {" + NL + "\t\t\t\t\t\tmailClient_";
  protected final String TEXT_15 = ".commit();" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tmailClient_";
  protected final String TEXT_16 = ".rollback();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\tmailClient_";
  protected final String TEXT_17 = ".close();" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

    
List<String> UniservBulk=new ArrayList<String>();
UniservBulk.add("IN_NAME");
UniservBulk.add("IN_FIRST_NAME");
UniservBulk.add("IN_NAME_LINE");
UniservBulk.add("IN_COMPANY_NAME");
UniservBulk.add("IN_PERSON");
UniservBulk.add("IN_DEPARTMENT");
UniservBulk.add("IN_WEB_ADDR");
UniservBulk.add("IN_STR");
UniservBulk.add("IN_HNO");
UniservBulk.add("IN_STR_LINE");
UniservBulk.add("IN_ZIP");
UniservBulk.add("IN_CITY");
UniservBulk.add("IN_CITY_LINE");
UniservBulk.add("IN_COUNTRY_CODE");
UniservBulk.add("IN_POBOX");
UniservBulk.add("IN_FREE");
UniservBulk.add("IN_FREE2");
UniservBulk.add("IN_FREE3");
UniservBulk.add("IN_FREE4");
UniservBulk.add("IN_FREE5");
UniservBulk.add("IN_FREE6");
UniservBulk.add("IN_FREE7");
UniservBulk.add("IN_DATE");
UniservBulk.add("IN_PHONE");
UniservBulk.add("IN_GENDER");
UniservBulk.add("IN_ROLE");
UniservBulk.add("IN_EMAIL");
UniservBulk.add("IN_CODEPOOL");
UniservBulk.add("IN_DBREF");
UniservBulk.add("IN_DATA");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		List< ? extends IConnection> conns = node.getIncomingConnections();
		for (IConnection conn : conns) {
			List<IMetadataColumn> columns = metadata.getListColumns();
        		int sizeColumns = columns.size();
			for(int i=0; i<sizeColumns; i++) {
				if(UniservBulk.contains(columns.get(i).getLabel())) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append((columns.get(i).getLabel()).toLowerCase());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_7);
    
				}
			}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
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
    
		}
	}
}

    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}
