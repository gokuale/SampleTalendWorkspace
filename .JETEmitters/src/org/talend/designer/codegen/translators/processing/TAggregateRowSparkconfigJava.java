package org.talend.designer.codegen.translators.processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IBigDataNode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.spark.aggregate.AggregateFunctionFactory;
import org.talend.designer.spark.aggregate.IAggregateFunction;
import org.talend.designer.spark.generator.utils.SparkFunctionUtil;

public class TAggregateRowSparkconfigJava
{
  protected static String nl;
  public static synchronized TAggregateRowSparkconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateRowSparkconfigJava result = new TAggregateRowSparkconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t            org.apache.spark.api.java.JavaPairRDD<";
  protected final String TEXT_2 = ", ";
  protected final String TEXT_3 = "> rdd_";
  protected final String TEXT_4 = " = rdd_";
  protected final String TEXT_5 = NL + "\t                .mapToPair(new PreMap";
  protected final String TEXT_6 = "())" + NL + "\t                .reduceByKey(new Comb";
  protected final String TEXT_7 = "())" + NL + "\t                .mapToPair(new Map";
  protected final String TEXT_8 = "());";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final IBigDataNode bigDataNode = (IBigDataNode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();

if (metadatas != null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    if(metadata != null) {
        List< ? extends IConnection> connections = node.getOutgoingConnections();
        List< ? extends IConnection> inConnections = node.getIncomingConnections();
        if ((connections != null) && (connections.size() > 0)
                && (inConnections != null) && (inConnections.size() > 0)) {
            IConnection connection = connections.get(0);
            IConnection inConnection = inConnections.get(0);
            String connName = connection.getName();
            String connectionTypeName = codeGenArgument.getRecordStructName(connection);
            String inConnName = inConnection.getName();
            String inConnectionTypeName = codeGenArgument.getRecordStructName(inConnection);

            List<Map<String, String>> groupBy = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
            List<String> groupByInput = new ArrayList<String>();
            for (Map<String, String> element: groupBy) {
                groupByInput.add(element.get("INPUT_COLUMN"));
            }

            String computationType = connectionTypeName;

            List<Map<String, String>> operationTemp = (List<Map<String,String>>)
            ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
            Boolean useFinancialPrecision = "true".equals(ElementParameterParser.getValue(node, "__USE_FINANCIAL_PRECISION__"));
            boolean checkTypeOverflow = "true".equals(ElementParameterParser.getValue(node, "__CHECK_TYPE_OVERFLOW__"));
            boolean checkUlp = "true".equals(ElementParameterParser.getValue(node, "__CHECK_ULP__"));

            List<IAggregateFunction> aggregateFunctions = new ArrayList<IAggregateFunction>();
            Boolean needToExtendOutputType = useFinancialPrecision;
            for (Map<String, String> operationRow: operationTemp) {
                if (operationRow.get("FUNCTION").equals("std_dev") || operationRow.get("FUNCTION").equals("avg")) {
                    needToExtendOutputType = true;
                }
                aggregateFunctions.add(AggregateFunctionFactory.getFunction(cid, operationRow, inConnection.getMetadataTable().getListColumns(), connection.getMetadataTable().getListColumns(),
                        useFinancialPrecision, checkTypeOverflow, checkUlp));
            }

            if (needToExtendOutputType) {
                computationType = "Extended" + cid + "_" + computationType;
            }

            String keyType = SparkFunctionUtil.getKeyType(bigDataNode.getKeyList(), "BOTH");

            
    stringBuffer.append(TEXT_1);
    stringBuffer.append(keyType);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
        }
    }
}

    return stringBuffer.toString();
  }
}
