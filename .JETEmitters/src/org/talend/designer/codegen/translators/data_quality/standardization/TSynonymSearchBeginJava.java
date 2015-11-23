package org.talend.designer.codegen.translators.data_quality.standardization;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSynonymSearchBeginJava
{
  protected static String nl;
  public static synchronized TSynonymSearchBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSynonymSearchBeginJava result = new TSynonymSearchBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "org.talend.dataquality.standardization.record.SynonymRecordSearcher " + NL + "\trecSearch_";
  protected final String TEXT_2 = " = new org.talend.dataquality.standardization.record.SynonymRecordSearcher(";
  protected final String TEXT_3 = ");";
  protected final String TEXT_4 = NL + "\t\torg.talend.dataquality.standardization.index.SynonymIndexSearcher searcher";
  protected final String TEXT_5 = "_";
  protected final String TEXT_6 = " = new org.talend.dataquality.standardization.index.SynonymIndexSearcher(";
  protected final String TEXT_7 = ");" + NL + "\t\tsearcher";
  protected final String TEXT_8 = "_";
  protected final String TEXT_9 = ".setSearchMode(org.talend.dataquality.standardization.index.SynonymIndexSearcher.SynonymSearchMode.";
  protected final String TEXT_10 = ");" + NL + "\t\tsearcher";
  protected final String TEXT_11 = "_";
  protected final String TEXT_12 = ".setMinimumSimilarity(";
  protected final String TEXT_13 = ");" + NL + "\t\tsearcher";
  protected final String TEXT_14 = "_";
  protected final String TEXT_15 = ".setSlop(";
  protected final String TEXT_16 = ");" + NL + "\t\tsearcher";
  protected final String TEXT_17 = "_";
  protected final String TEXT_18 = ".setTopDocLimit(";
  protected final String TEXT_19 = ");\t" + NL + "\t\tsearcher";
  protected final String TEXT_20 = "_";
  protected final String TEXT_21 = ".setMatchingThreshold(";
  protected final String TEXT_22 = ");\t" + NL + "\t\trecSearch_";
  protected final String TEXT_23 = ".addSearcher(searcher";
  protected final String TEXT_24 = "_";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ");" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_27 = NL + "int uniqueIndexNum_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = ";" + NL + "int gid_";
  protected final String TEXT_30 = " = 0;" + NL + "String[] inputs_";
  protected final String TEXT_31 = " = null;" + NL + "org.talend.dataquality.standardization.index.Error error_";
  protected final String TEXT_32 = " = new org.talend.dataquality.standardization.index.Error();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();	
// String path = ElementParameterParser.getValue(node, "__FILE_PATH__"); 
// String separator = ElementParameterParser.getValue(node, "__SEPARATOR__");
List<Map<String, String>> listToSearch = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SEARCH_INDEXS__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(listToSearch.size());
    stringBuffer.append(TEXT_3);
     
List<String> uniqueInputName = new java.util.ArrayList<String>();
int i = 0;

for (Map<String, String> toSearch : listToSearch) {
	String inputName = toSearch.get("PRE_COLUMN");
	String indexPath = toSearch.get("INDEX_PATH");
	String searchMode = toSearch.get("SEARCH_MODE");
	String matchingThreshold = toSearch.get("SCORE_THRESHOLD");
	String minimumSimilarity = toSearch.get("MINIMUM_SIMILARITY");
	String slop = toSearch.get("SLOP_FOR_PARTIAL_MATCH");
	int limit = Integer.parseInt(toSearch.get("NUM_TOPS"));
	
	// only use the previous index if duplicate
	if (!uniqueInputName.contains(inputName)) {
		uniqueInputName.add(inputName);
		
    stringBuffer.append(TEXT_4);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(indexPath);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(searchMode);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(minimumSimilarity);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(slop);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(matchingThreshold);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_26);
    
		i++;
	}
}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    return stringBuffer.toString();
  }
}
