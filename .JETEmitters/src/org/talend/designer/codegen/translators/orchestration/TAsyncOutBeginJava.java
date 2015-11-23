package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.process.INode;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TAsyncOutBeginJava
{
  protected static String nl;
  public static synchronized TAsyncOutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAsyncOutBeginJava result = new TAsyncOutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint index_";
  protected final String TEXT_3 = " = 0;" + NL + "\tint threadIdCounter_";
  protected final String TEXT_4 = " = 0;" + NL + "\tjava.util.List<Object[]> buffers_";
  protected final String TEXT_5 = " = new java.util.ArrayList<Object[]>();" + NL + "\tint toto_";
  protected final String TEXT_6 = "=0;" + NL + "\t";
  protected final String TEXT_7 = NL + "\tfinal ParallelThreadPool pool_";
  protected final String TEXT_8 = " = new ParallelThreadPool(";
  protected final String TEXT_9 = ");" + NL + "\tglobalMap.put(\"PARALLEL_FLOW_POOL_";
  protected final String TEXT_10 = "\", pool_";
  protected final String TEXT_11 = ");" + NL + "\tfinal Object[] lockWrite_";
  protected final String TEXT_12 = " = new Object[0];" + NL + "\tglobalMap.put(\"PARALLEL_FLOW_LOCK_";
  protected final String TEXT_13 = "\", lockWrite_";
  protected final String TEXT_14 = ");";

    private static String end_multiThread = "if ( !\"failure\".equals(((java.util.Map)threadLocal.get()).get(\"status\")) ) {\n((java.util.Map) threadLocal.get()).put(\"status\", \"end\");\n}";
    private static String end_singleThread = "if(!\"failure\".equals(status)) { status = \"end\"; }";
    private static String failure_multiThread = "((java.util.Map) threadLocal.get()).put(\"status\", \"failure\");";
    private static String failure_singleThread = "status = \"failure\";";
    private static String errorCode_multiThread = "((java.util.Map) threadLocal.get()).put(\"errorCode\", null);";
    private static String errorCode_singleThread = "errorCode = null;";
    
    // add the list of the connection names to avoid to declare two times the same name.
    public String createCallProcess(INode rootNode, String className, boolean isMultiThread) {
        String toReturn = "";
        toReturn =  "try {\n";
        if(isMultiThread) {
            toReturn +=  errorCode_multiThread;
        }else{
            toReturn +=  errorCode_singleThread;
        }        
        
        toReturn += className + "Class."+ rootNode.getUniqueName() + "Process(globalMap);\n";
        
        if(isMultiThread) {
            toReturn +=  end_multiThread;
        }else{
            toReturn +=  end_singleThread;
        }
        
        toReturn += "\n}catch (TalendException e_" + rootNode.getUniqueName() + ") {\n";
        
//        if(isMultiThread) {
//            toReturn +=  failure_multiThread;
//        }else{
//            toReturn +=  failure_singleThread;
//        }
        
        toReturn += "globalMap.put(\""+rootNode.getUniqueName()+ "_SUBPROCESS_STATE\", -1);\n";
        
        toReturn += "\ne_" + rootNode.getUniqueName() + ".printStackTrace();\n";
        
      
       //List< ? extends IConnection> onSubJobErrorConns = rootNode.getOutgoingConnections(EConnectionType.ON_SUBJOB_ERROR);
       //if(onSubJobErrorConns!=null){
       //    for(IConnection conn : onSubJobErrorConns) {               
       //        toReturn += createCallProcess(conn.getTarget(),  className, isMultiThread);
       //    }
       //}            
       toReturn += "\n}finally {\n}"; 
       return toReturn;
    }

    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean stat = codeGenArgument.isStatistics();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
	String parallelizeNum = ElementParameterParser.getValue(node, "__PARALLELIZE_NUMBER__");;

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(parallelizeNum);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}