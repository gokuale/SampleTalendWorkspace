package org.talend.designer.codegen.translators.data_quality.uniserv;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.EConnectionType;
import java.util.List;
import java.util.Map;

public class TFileInputUniservMainJava
{
  protected static String nl;
  public static synchronized TFileInputUniservMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputUniservMainJava result = new TFileInputUniservMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tif(!headerDone_";
  protected final String TEXT_2 = ") {" + NL + "\t\t\t\t\theaderDone_";
  protected final String TEXT_3 = "=true;";
  protected final String TEXT_4 = NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\twriter_";
  protected final String TEXT_5 = ".write(\"";
  protected final String TEXT_6 = "\");";
  protected final String TEXT_7 = NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\twriter_";
  protected final String TEXT_8 = ".write(";
  protected final String TEXT_9 = "+\"";
  protected final String TEXT_10 = "\");";
  protected final String TEXT_11 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\twriter_";
  protected final String TEXT_12 = ".write(\"\\n\");" + NL + "\t\t\t\t}";
  protected final String TEXT_13 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\twriter_";
  protected final String TEXT_14 = ".write(";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\twriter_";
  protected final String TEXT_18 = ".write(";
  protected final String TEXT_19 = "+";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t\t" + NL + "\t\t\twriter_";
  protected final String TEXT_23 = ".write(\"\\n\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName(); 

String separator = ElementParameterParser.getValue(node, "__OUT_FIELD_SEP__");   
int headerCount = Integer.parseInt(ElementParameterParser.getValue(node, "__OUT_HEADER_COUNT__"));

boolean metricJob = ("true").equals(ElementParameterParser.getValue(node,"__METRIC_JOB__"));

if(!metricJob) {
IMetadataTable inputMetadataTable = null;
java.util.List<IMetadataColumn> columns = null; 

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		List< ? extends IConnection> conns = node.getIncomingConnections();
		for (IConnection conn : conns) {
			inputMetadataTable = conn.getMetadataTable();
			columns = inputMetadataTable.getListColumns();
        	int sizeColumns = columns.size();
			if(headerCount>0) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
					for(int i=0; i<sizeColumns; i++) {
						if(i==0) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_6);
    
						} else {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(columns.get(i).getLabel());
    stringBuffer.append(TEXT_10);
    
						}
					}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
			for(int i=0; i<sizeColumns; i++) {
				if(i==0) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(columns.get(i));
    stringBuffer.append(TEXT_16);
    
				} else {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(columns.get(i));
    stringBuffer.append(TEXT_21);
    
				}
			}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
		}
	}	
}
}

    return stringBuffer.toString();
  }
}
