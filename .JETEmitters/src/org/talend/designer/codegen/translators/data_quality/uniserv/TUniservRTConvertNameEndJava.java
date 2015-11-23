package org.talend.designer.codegen.translators.data_quality.uniserv;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;

public class TUniservRTConvertNameEndJava
{
  protected static String nl;
  public static synchronized TUniservRTConvertNameEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniservRTConvertNameEndJava result = new TUniservRTConvertNameEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "try {" + NL + "\tcnameClient_";
  protected final String TEXT_2 = ".close();" + NL + "} catch (Exception ex) {" + NL + "\tglobalMap.put(\"WS_ERROR_CODE\", new Integer(-1));" + NL + "\tglobalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_3 = "\");" + NL + "\t" + NL + "\tString msg = ex.getMessage();" + NL + "\tif(msg == null) {" + NL + "\t\tmsg = ex.toString();" + NL + "\t}" + NL + "\tglobalMap.put(\"WS_ERROR_MESSAGE\", msg);" + NL + "" + NL + "\tthrow new RuntimeException(msg);" + NL + "}";

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
    return stringBuffer.toString();
  }
}
