package org.talend.designer.codegen.translators.data_quality.address;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;

public class TBatchAddressRowCloudInBeginJava
{
  protected static String nl;
  public static synchronized TBatchAddressRowCloudInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBatchAddressRowCloudInBeginJava result = new TBatchAddressRowCloudInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "                        " + NL + "                    java.util.Queue<";
  protected final String TEXT_2 = "Struct> queue_";
  protected final String TEXT_3 = " = (java.util.Queue<";
  protected final String TEXT_4 = "Struct>) globalMap.get(\"queue_";
  protected final String TEXT_5 = "\");" + NL + "" + NL + "                    String readFinishMarkWithPipeId_";
  protected final String TEXT_6 = " = \"";
  protected final String TEXT_7 = "_FINISH\"+(queue_";
  protected final String TEXT_8 = "==null?\"\":queue_";
  protected final String TEXT_9 = ".hashCode());" + NL + "                    int nb_line_";
  protected final String TEXT_10 = " = 0;" + NL + "                    while(!globalMap.containsKey(readFinishMarkWithPipeId_";
  protected final String TEXT_11 = ") || !queue_";
  protected final String TEXT_12 = ".isEmpty()) {" + NL + "                        if (queue_";
  protected final String TEXT_13 = ".isEmpty()){" + NL + "                            Thread.sleep(1000);  " + NL + "                        } else {";
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String api_type = ElementParameterParser.getValue(node, "__API_TYPE__"); 
    String licenseKey = ElementParameterParser.getValue(node, "__LICENSE_KEY__"); 
    boolean isSecuredMode = ("true").equals(ElementParameterParser.getValue(node, "__SECURE_MODE__")); 
    
    String address_line_separator = ElementParameterParser.getValue(node,"__ADDRESS_LINE_SEPARATOR__");
    String default_country = ElementParameterParser.getValue(node, "__DEFAULT_COUNTRY__"); 
    String forced_country = ElementParameterParser.getValue(node, "__FORCED_COUNTRY__"); 
    String output_script = ElementParameterParser.getValue(node, "__OUTPUT_SCRIPT__"); 
    String minimum_match_score = ElementParameterParser.getValue(node, "__MINIMUM_MATCH_SCORE__"); 
    
    String query_interval = ElementParameterParser.getValue(node, "__QUERY_INTERVAL__"); 
    String trial_limit = ElementParameterParser.getValue(node, "__TRIAL_LIMIT__"); 
    String trial_interval = ElementParameterParser.getValue(node, "__TRIAL_INTERVAL__"); 
    String termination_waiting_seconds = ElementParameterParser.getValue(node, "__TERMINATION_WAITING_SECONDS__"); 
    String output_handler_termination_delay = ElementParameterParser.getValue(node, "__OUTPUT_HANDLER_TERMINATION_DELAY__");
    String processing_mode = ElementParameterParser.getValue(node, "__PROCESSING_MODE__");
    
    boolean useAdditionalOutput = ("true").equals(ElementParameterParser.getValue(node, "__USE_ADDITIONAL_OUTPUT__")); 
    List<Map<String, String>> additional_output_mapping = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__OUTPUT_MAPPING__");


    String xmlField = ElementParameterParser.getValue(node, "__XMLFIELD__");

    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
            List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
            if(conns!=null && conns.size()>0){
                IConnection conn = conns.get(0);
                if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                
                    INode sourceNode = node.getIncomingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getSource();
                    String virtualSourceCid = sourceNode.getUniqueName();
                    INode startNode = NodeUtil.getSpecificStartNode(sourceNode);
                    String startNodeCid = null; 
                    if(startNode != null){
                        startNodeCid = startNode.getUniqueName();
                    } 
                    IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
                    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
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
    
                }
            }
        }
    }
    
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
