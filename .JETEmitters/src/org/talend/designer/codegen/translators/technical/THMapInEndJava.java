package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class THMapInEndJava
{
  protected static String nl;
  public static synchronized THMapInEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THMapInEndJava result = new THMapInEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = "\t\t\t\t\t" + NL + "    } // Close the loop (if)" + NL + "    } // Close the loop (if)" + NL + "} // Close the loop (for)";
  protected final String TEXT_4 = NL + "\tjava.io.InputStream is_";
  protected final String TEXT_5 = " = (java.io.InputStream)";
  protected final String TEXT_6 = ".this.globalMap.get(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_7 = "_\"+\"outputResult\");" + NL + "\tif (is_";
  protected final String TEXT_8 = " != null)" + NL + "\t\tis_";
  protected final String TEXT_9 = ".close();";
  protected final String TEXT_10 = NL + "} // if (listResult..." + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_11 = "_NB_LINE\",nb_line_";
  protected final String TEXT_12 = ");" + NL;
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String this_cid = ElementParameterParser.getValue(node, "__UNIQUE_NAME__");
	String tHMap_id = this_cid.replace("_THMAP_IN", "");
	String cid = tHMap_id;

	boolean asMap = "true".equals(ElementParameterParser.getValue(node, "__AS_MAP__"));
	boolean asInputstream = "true".equals(ElementParameterParser.getValue(node, "__AS_INPUTSTREAM__"));


    stringBuffer.append(TEXT_2);
    
	if(asMap) {

    stringBuffer.append(TEXT_3);
    
	} else if (asInputstream) { 

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
	} 

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
