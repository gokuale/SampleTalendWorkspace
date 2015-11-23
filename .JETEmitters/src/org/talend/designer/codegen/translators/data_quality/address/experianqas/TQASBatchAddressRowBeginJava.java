package org.talend.designer.codegen.translators.data_quality.address.experianqas;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TQASBatchAddressRowBeginJava
{
  protected static String nl;
  public static synchronized TQASBatchAddressRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TQASBatchAddressRowBeginJava result = new TQASBatchAddressRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "      org.talend.qasbatch.QASSearch qasSearch_";
  protected final String TEXT_2 = " = new org.talend.qasbatch.QASSearch();" + NL + "      qasSearch_";
  protected final String TEXT_3 = ".setLayout(\"";
  protected final String TEXT_4 = "\");" + NL + "      boolean bStarted_";
  protected final String TEXT_5 = " = qasSearch_";
  protected final String TEXT_6 = ".batchStart(";
  protected final String TEXT_7 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
  CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
  INode node = (INode)codeGenArgument.getArgument();
  String cid = node.getUniqueName();
  List<IMetadataTable> metadatas = node.getMetadataList();
  
  if ((metadatas != null) && (metadatas.size() > 0)) {
    IMetadataTable metadata = metadatas.get(0);
    
    if (metadata != null) {
      String sIniFilePath = ElementParameterParser.getValue(node, "__PATH__");
      String sCountry = ElementParameterParser.getValue(node, "__COUNTRY__");
      
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(sCountry);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(sIniFilePath);
    stringBuffer.append(TEXT_7);
    
    }
  }

    return stringBuffer.toString();
  }
}
