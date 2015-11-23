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

public class TBatchAddressRowCloudInMainJava
{
  protected static String nl;
  public static synchronized TBatchAddressRowCloudInMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBatchAddressRowCloudInMainJava result = new TBatchAddressRowCloudInMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "          " + NL;
  protected final String TEXT_3 = NL + "                    ";
  protected final String TEXT_4 = " = queue_";
  protected final String TEXT_5 = ".poll();       " + NL + "                           ";
  protected final String TEXT_6 = "       " + NL;
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    List<Map<String, String>> additional_output_mapping = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__OUTPUT_MAPPING__");

    stringBuffer.append(TEXT_1);
     
    List< ? extends IConnection> connsout = node.getOutgoingConnections();
    if (connsout!=null) {
           for (IConnection connout : connsout) {
                if(connout!=null && connout.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connout.getName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
                }
           }
    }

    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
