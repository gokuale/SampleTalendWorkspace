package org.talend.designer.codegen.translators.data_quality.address;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.IConnection;

public class TBatchAddressRowCloudOutEndJava
{
  protected static String nl;
  public static synchronized TBatchAddressRowCloudOutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBatchAddressRowCloudOutEndJava result = new TBatchAddressRowCloudOutEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "engine_";
  protected final String TEXT_2 = ".finalizeBatchInput();" + NL + "engine_";
  protected final String TEXT_3 = ".shutdown();" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_4 = "_NB_LINE\",nb_line_";
  protected final String TEXT_5 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_6 = "_FINISH\" + (listGroupby_";
  protected final String TEXT_7 = "==null?\"\":listGroupby_";
  protected final String TEXT_8 = ".hashCode()), \"true\");";
  protected final String TEXT_9 = NL + "        tbo_";
  protected final String TEXT_10 = ".join();" + NL + "        if(tbo_";
  protected final String TEXT_11 = ".getLastException()!=null) {" + NL + "            currentComponent = tbo_";
  protected final String TEXT_12 = ".getCurrentComponent();" + NL + "            throw tbo_";
  protected final String TEXT_13 = ".getLastException();" + NL + "        }";
  protected final String TEXT_14 = NL + NL + "resourceMap.put(\"finish_";
  protected final String TEXT_15 = "\", true);";
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    String virtualTargetCid = node.getOutgoingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getTarget().getUniqueName();

    List<IMetadataTable> metadatas = node.getMetadataList();

    if ((metadatas!=null)&&(metadatas.size()>0)) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(virtualTargetCid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
    IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
    if(nextMergeConn == null || nextMergeConn.getInputId()==1){
    
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

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
