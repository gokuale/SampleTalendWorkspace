package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class THMapEndJava
{
  protected static String nl;
  public static synchronized THMapEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THMapEndJava result = new THMapEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL;
  protected final String TEXT_3 = NL + "\tjava.io.InputStream is = (java.io.InputStream)";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = ";" + NL + "\tis.close();" + NL + "\t" + NL + "\torg.talend.transform.runtime.api.ExecutionStatus results = " + NL + "\t   (org.talend.transform.runtime.api.ExecutionStatus)";
  protected final String TEXT_6 = ".this.globalMap.get(\"";
  protected final String TEXT_7 = "_\"+\"EXECUTION_STATUS\");\t" + NL + "   \t";
  protected final String TEXT_8 = ".this.globalMap.put(\"";
  protected final String TEXT_9 = "_\"+\"EXECUTION_SEVERITY\",results.getOverallSeverity());" + NL + "   \tif (results.getOverallSeverity()>=";
  protected final String TEXT_10 = ") {" + NL + "    \tthrow new TalendException(new java.lang.Exception(String.valueOf(results)),currentComponent,globalMap);" + NL + "\t}" + NL + "\t";
  protected final String TEXT_11 = "\t" + NL + NL;
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String this_cid = ElementParameterParser.getValue(node, "__UNIQUE_NAME__");
	String tHMap_id = this_cid.replace("_THMAP_IN", "");
	String cid = tHMap_id;

    Integer exceptionLevel = Integer.parseInt(ElementParameterParser.getValue(node, "__EXCEPTION__")); 
	boolean asInputstream = "true".equals(ElementParameterParser.getValue(node, "__AS_INPUTSTREAM__"));

    stringBuffer.append(TEXT_2);
    
	if (node.getOutgoingConnections()!=null) {
		java.util.Set<IConnection> dataConns = new java.util.HashSet<IConnection>();	
		for (IConnection outgoingConn : node.getOutgoingConnections()) {
		if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		dataConns.add(outgoingConn);	
		}
		}
		for (IConnection outgoingConn : node.getOutgoingConnections()) {
			if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				String outputConnName = outgoingConn.getName();
				IMetadataTable outputMetadataTable = outgoingConn.getMetadataTable();
				for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
					if (asInputstream) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(exceptionLevel);
    stringBuffer.append(TEXT_10);
    
						break;
					}
				}
				break;
			}
		}		
	}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
