package org.talend.designer.codegen.translators.logs_errors;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TLogRowStormmonitorJava
{
  protected static String nl;
  public static synchronized TLogRowStormmonitorJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLogRowStormmonitorJava result = new TLogRowStormmonitorJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "System.out.println(drpc.execute(topologyName + \"";
  protected final String TEXT_3 = "\" + \"__log\"," + NL + "        topologyName + \"";
  protected final String TEXT_4 = "\" + \"__log\"));";
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    
// TODO: Format the output tuple.
// String label = ElementParameterParser.getValue(node, "__LABEL__");
// if(("__UNIQUE_NAME__").equals(label)) {
//     label=cid;
// }
// String printHeader = ElementParameterParser.getValue(node,"__PRINT_HEADER__");
// boolean vertical = ("true").equals(ElementParameterParser.getValue(node,"__VERTICAL__"));
// boolean uniquePrint = ("true").equals(ElementParameterParser.getValue(node,"__PRINT_UNIQUE__"));
// boolean titlePrint = ("true").equals(ElementParameterParser.getValue(node,"__PRINT_LABEL__"));
// boolean uniqueTitlePrint = ("true").equals(ElementParameterParser.getValue(node,"__PRINT_UNIQUE_LABEL__"));
// boolean basic = !(vertical);
// String printUniqueName = ElementParameterParser.getValue(node,"__PRINT_UNIQUE_NAME__");
// String printColumnNames = ElementParameterParser.getValue(node,"__PRINT_COLNAMES__");
// String useFixedLength = ElementParameterParser.getValue(node,"__USE_FIXED_LENGTH__");
// List<Map<String, String>> lengths = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__LENGTHS__");
// List<IMetadataColumn> columns = streamUtil.getInColumns();

    stringBuffer.append(TEXT_2);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
