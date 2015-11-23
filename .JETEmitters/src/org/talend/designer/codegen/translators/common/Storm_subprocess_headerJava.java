package org.talend.designer.codegen.translators.common;

import org.talend.designer.codegen.config.NodesSubTree;
import org.talend.core.model.process.INode;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.Vector;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IHashableInputConnections;
import org.talend.core.model.process.IHashConfiguration;
import org.talend.core.model.process.IHashableColumn;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.utils.TalendQuoteUtils;

public class Storm_subprocess_headerJava
{
  protected static String nl;
  public static synchronized Storm_subprocess_headerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Storm_subprocess_headerJava result = new Storm_subprocess_headerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "private void ";
  protected final String TEXT_2 = "Topology(StormTopologyContext ctx) throws IOException {";
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

/*
    This template creates UIDTopology methods, which are used to configure a
    Trident topology for submission.

    This method is available at the top-level of the main job class.

    This method opens a scope for components STORMCONFIG code parts to permit
    them to specify their connections.

    After this method, the scope is inside the method, with the following
    variables available:
    * TridentTopology topology
    * LocalDRPC drpc

 */

CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
Vector v = (Vector) codeGenArgument.getArgument();
NodesSubTree subTree = (NodesSubTree)v.get(1);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(subTree.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
