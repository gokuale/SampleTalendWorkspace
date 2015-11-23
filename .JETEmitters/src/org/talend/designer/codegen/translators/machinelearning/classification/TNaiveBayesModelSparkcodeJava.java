package org.talend.designer.codegen.translators.machinelearning.classification;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IBigDataNode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TNaiveBayesModelSparkcodeJava
{
  protected static String nl;
  public static synchronized TNaiveBayesModelSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNaiveBayesModelSparkcodeJava result = new TNaiveBayesModelSparkcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    return stringBuffer.toString();
  }
}
