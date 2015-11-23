package org.talend.designer.codegen.translators.common;

import java.util.List;
import java.util.Vector;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.temp.ECodePart;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class Storm_monitor_headerJava
{
  protected static String nl;
  public static synchronized Storm_monitor_headerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Storm_monitor_headerJava result = new Storm_monitor_headerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "private StormTopologyMonitor topologyMonitor = new StormTopologyMonitor() {" + NL + "  public void run(backtype.storm.generated.DistributedRPC.Iface drpc, String topologyName) throws org.apache.thrift7.TException, backtype.storm.generated.DRPCExecutionException {";
  protected final String TEXT_2 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

/*
    This template creates the runMonitor method, which is used in a job
    running in Talend studio to monitor an ongoing Storm job via DRPC.

    This method is available at the top-level of the main job class.

    This method opens a scope for components STORMMONITOR code parts to permit
    them to specify how they should be monitored.  This occurs within an
    infinite while loop.

    TODO:
    * All flags to configure whether this method is run or not.
    * Non-infinite while loop.
    * Option to kill storm topology on shutdown.
    * Passing in DRPC ports for different service calls.
    * Statistics, etc.

 */

CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
Vector v = (Vector) codeGenArgument.getArgument();
IProcess process = (IProcess)v.get(0);
List<INode> rootNodes = (List<INode>)v.get(1);
INode stormConfig = (INode)v.get(2);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
