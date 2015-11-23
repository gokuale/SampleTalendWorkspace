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

public class TUniservRTPostEndJava
{
  protected static String nl;
  public static synchronized TUniservRTPostEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniservRTPostEndJava result = new TUniservRTPostEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + NL + "\ttry {" + NL + "\t\tif(postClient_";
  protected final String TEXT_2 = " != null){" + NL + "\t\t\tpostClient_";
  protected final String TEXT_3 = ".close();" + NL + "\t\t}" + NL + "\t} catch (Exception ex) {" + NL + "\t\tglobalMap.put(\"WS_ERROR_CODE\", new Integer(-1));" + NL + "\t\tglobalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_4 = "\");" + NL + "\t\t" + NL + "\t\tString msg = ex.getMessage();" + NL + "\t\tif(msg == null) {" + NL + "\t\t\tmsg = ex.toString();" + NL + "\t\t}" + NL + "\t\tglobalMap.put(\"WS_ERROR_MESSAGE\", msg);" + NL + "\t" + NL + "\t\tthrow new RuntimeException(msg);" + NL + "\t}" + NL + NL + NL;
  protected final String TEXT_5 = NL + "    printWriter_";
  protected final String TEXT_6 = ".close();";

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
    
if(ElementParameterParser.getValue(node, "__USE_FILE_AMBIGUOUS__").equals("true"))
{

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    }
    return stringBuffer.toString();
  }
}
