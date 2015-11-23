package org.talend.designer.codegen.translators.data_quality.uniserv;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;

public class TUniservRTMailSearchEndJava
{
  protected static String nl;
  public static synchronized TUniservRTMailSearchEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniservRTMailSearchEndJava result = new TUniservRTMailSearchEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + NL + "\ttry {" + NL + "\t\tif(mailClient_";
  protected final String TEXT_2 = " != null){" + NL + "\t\t\tmailClient_";
  protected final String TEXT_3 = ".close();" + NL + "\t\t}" + NL + "\t} catch (Exception ex) {" + NL + "\t\tglobalMap.put(\"WS_ERROR_CODE\", new Integer(-1));" + NL + "\t\tglobalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_4 = "\");" + NL + "\t\t" + NL + "\t\tString msg = ex.getMessage();" + NL + "\t\tif(msg == null) {" + NL + "\t\t\tmsg = ex.toString();" + NL + "\t\t}" + NL + "\t\tglobalMap.put(\"WS_ERROR_MESSAGE\", msg);" + NL + "\t" + NL + "\t\tthrow new RuntimeException(msg);" + NL + "\t}";
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
