package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.TalendTextUtils;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TSAPBapiInEndJava
{
  protected static String nl;
  public static synchronized TSAPBapiInEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPBapiInEndJava result = new TSAPBapiInEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String graphicalUniqueName = cid.replace("_TSAPBapi_IN","");
	
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	List<IConnection> connections = new java.util.ArrayList<IConnection>();
	
	if(conns!=null){
		for(int i=0;i<conns.size();i++){
			IConnection conn = conns.get(i);
		    if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		   		connections.add(conn);
		    }
		}
	}
	
	if(connections.isEmpty()) {
		return "";
	}

    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
