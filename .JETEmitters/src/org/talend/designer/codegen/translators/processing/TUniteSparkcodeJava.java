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
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TUniteSparkcodeJava
{
  protected static String nl;
  public static synchronized TUniteSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniteSparkcodeJava result = new TUniteSparkcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final IBigDataNode node = (IBigDataNode) codeGenArgument.getArgument();
final String cid = node.getUniqueName();

// nothing for now...

    return stringBuffer.toString();
  }
}
