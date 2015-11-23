package org.talend.designer.codegen.translators.data_quality.standardization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFirstnameMatchBeginJava
{
  protected static String nl;
  public static synchronized TFirstnameMatchBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFirstnameMatchBeginJava result = new TFirstnameMatchBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " " + NL + "" + NL + "  org.apache.lucene.search.IndexSearcher indexSearcher_";
  protected final String TEXT_2 = " = null;" + NL + "  org.apache.lucene.analysis.Analyzer analyzer_";
  protected final String TEXT_3 = " = null;" + NL + "  org.apache.lucene.store.Directory dic_";
  protected final String TEXT_4 = " = null;" + NL + "  org.talend.dataquality.standardization.query.FirstNameStandardize fns_";
  protected final String TEXT_5 = " = null;" + NL + "  org.talend.dataquality.data.index.reader.CopyDataIndexHelper index_";
  protected final String TEXT_6 = "=null;" + NL + "  String indexFolderPath_";
  protected final String TEXT_7 = "=null;" + NL + "  try{" + NL + "      index_";
  protected final String TEXT_8 = "=new org.talend.dataquality.data.index.reader.CopyDataIndexHelper();" + NL + "      indexFolderPath_";
  protected final String TEXT_9 = "=index_";
  protected final String TEXT_10 = ".copyIndexToProject(";
  protected final String TEXT_11 = ");" + NL + "\t  dic_";
  protected final String TEXT_12 = " = org.apache.lucene.store.FSDirectory.open(new java.io.File(indexFolderPath_";
  protected final String TEXT_13 = "));" + NL + "\t  indexSearcher_";
  protected final String TEXT_14 = " = new org.apache.lucene.search.IndexSearcher(dic_";
  protected final String TEXT_15 = ");" + NL + "\t  analyzer_";
  protected final String TEXT_16 = " = new org.apache.lucene.analysis.SimpleAnalyzer();" + NL + "\t  " + NL + "\t  fns_";
  protected final String TEXT_17 = " = " + NL + "\t\t\t   new  org.talend.dataquality.standardization.query.FirstNameStandardize(indexSearcher_";
  protected final String TEXT_18 = ",analyzer_";
  protected final String TEXT_19 = ", 10 ); " + NL + "\t  " + NL + "  }catch(Exception e){" + NL + "   e.printStackTrace();" + NL + "  }" + NL + "" + NL + "  String firstName_";
  protected final String TEXT_20 = " = \"\" ;" + NL + "\t       \t\t\t   " + NL + NL;
  protected final String TEXT_21 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String indexFolder = ElementParameterParser.getValue(node, "__INDEXFILEPATH__");
	

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(indexFolder);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
