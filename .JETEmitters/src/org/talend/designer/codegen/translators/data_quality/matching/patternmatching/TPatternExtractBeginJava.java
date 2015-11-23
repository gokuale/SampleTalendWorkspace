package org.talend.designer.codegen.translators.data_quality.matching.patternmatching;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;

public class TPatternExtractBeginJava
{
  protected static String nl;
  public static synchronized TPatternExtractBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPatternExtractBeginJava result = new TPatternExtractBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    String stringpattern_";
  protected final String TEXT_3 = "=";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL + "    String stringpattern_";
  protected final String TEXT_6 = "=";
  protected final String TEXT_7 = ";";
  protected final String TEXT_8 = NL + NL + "\tboolean result_";
  protected final String TEXT_9 = "=false;" + NL + "\tString match_";
  protected final String TEXT_10 = "=\"\";\t" + NL + "\tint nb_line_";
  protected final String TEXT_11 = " = 0;" + NL + "\tint nb_line_ok_";
  protected final String TEXT_12 = " = 0;" + NL + "\tint nb_line_reject_";
  protected final String TEXT_13 = " = 0;";
  protected final String TEXT_14 = NL + "\tjava.util.regex.Pattern pattern_";
  protected final String TEXT_15 = " = null;" + NL + "\ttry {" + NL + "    \tpattern_";
  protected final String TEXT_16 = " = java.util.regex.Pattern.compile(stringpattern_";
  protected final String TEXT_17 = ");" + NL + "    } catch (java.util.regex.PatternSyntaxException pe_";
  protected final String TEXT_18 = ") {" + NL + "    \tSystem.err.println(\"Error in component tPatternCheck: the pattern defined contains errors\");" + NL + "    \tthrow pe_";
  protected final String TEXT_19 = ";" + NL + "   \t}";
  protected final String TEXT_20 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
String CustomPattern = ElementParameterParser.getValue(node, "__PATTERN__");
boolean bUseCustom = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_PATTERN__"));
//may be dq pattern
String PatternList = ElementParameterParser.getValue(node, "__PATTERN_LIST__");

if (bUseCustom) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(CustomPattern.replace("\\", "\\\\"));
    stringBuffer.append(TEXT_4);
     } else {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(PatternList.replace("\\\\", "\\").replace("\\", "\\\\"));
    stringBuffer.append(TEXT_7);
     
} 

if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List<? extends IConnection> conns = node.getOutgoingSortedConnections();

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
		if (conns != null) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
		}
    }
}

    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
