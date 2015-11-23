package org.talend.designer.codegen.translators.databases.teradata;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.common.tmap.TMapAdapter;
import org.talend.designer.common.tmap.TMapMapperComponentAdapter;
import org.talend.designer.mapper.MapperComponent;
import org.talend.designer.spark.generator.storage.ISparkStorage;
import org.talend.designer.spark.generator.storage.TeradataSparkStorage;

public class TTeradataLookupInputSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TTeradataLookupInputSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataLookupInputSparkstreamingconfigJava result = new TTeradataLookupInputSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument)argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

    return stringBuffer.toString();
  }
}
