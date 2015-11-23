package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TRulesEndJava
{
  protected static String nl;
  public static synchronized TRulesEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRulesEndJava result = new TRulesEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "//\ti_";
  protected final String TEXT_3 = " ++ ;" + NL + "//ksession_";
  protected final String TEXT_4 = ".dispose();" + NL + "//}";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

if(conns!=null && conns.size() > 0 ){
	for(IConnection conn: conns){
		if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
			break;
		}
	}
}

    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
