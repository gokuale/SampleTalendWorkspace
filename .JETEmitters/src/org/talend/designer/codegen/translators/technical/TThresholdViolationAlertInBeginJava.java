package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TThresholdViolationAlertInBeginJava
{
  protected static String nl;
  public static synchronized TThresholdViolationAlertInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TThresholdViolationAlertInBeginJava result = new TThresholdViolationAlertInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = " = (String)globalMap.get(\"mailField\");\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid_original = ElementParameterParser.getValue(node, "__ORIGIN__");
String cid = cid_original.replace("tThresholdViolationAlert","tThresholdVA");

String outputField = ElementParameterParser.getValue(node, "__OUTFIELD__");

List< ? extends IConnection> outputConns = node.getOutgoingSortedConnections();

if (outputConns!=null) {
	if (outputConns.size()>0) {
		IConnection connTemp = outputConns.get(0);
		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			for(IMetadataColumn column: connTemp.getMetadataTable().getListColumns()){
				if(outputField.equals(column.getLabel())){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(outputField );
    stringBuffer.append(TEXT_4);
    
					break;
				}
			}
		}
	}
}


    return stringBuffer.toString();
  }
}
