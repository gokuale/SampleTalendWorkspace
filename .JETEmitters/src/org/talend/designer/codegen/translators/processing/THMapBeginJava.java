package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.transform.component.thmap.MapperComponent;

public class THMapBeginJava
{
  protected static String nl;
  public static synchronized THMapBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THMapBeginJava result = new THMapBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + " // Keep tHMap input and output structure names available to the job code" + NL + " globalMap.put(\"";
  protected final String TEXT_2 = "_source_struct_name\", \"";
  protected final String TEXT_3 = "\");" + NL + " globalMap.put(\"";
  protected final String TEXT_4 = "_target_struct_name\", \"";
  protected final String TEXT_5 = "\");" + NL;
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String this_cid = ElementParameterParser.getValue(node, "__UNIQUE_NAME__");
	String tHMap_id = this_cid.replace("_THMAP_OUT", "");
	String cid = tHMap_id;
	String sourceStructName = ((MapperComponent) node).getTDMSourceStructName();
	String targetStructName = ((MapperComponent) node).getTDMTargetStructName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(sourceStructName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(targetStructName );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
