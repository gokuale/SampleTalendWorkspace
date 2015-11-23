package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TActionInputLoopEndJava
{
  protected static String nl;
  public static synchronized TActionInputLoopEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TActionInputLoopEndJava result = new TActionInputLoopEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tif (iPaasObject == null){" + NL + "\t\t\trowsCount_";
  protected final String TEXT_3 = "++;" + NL + "\t\t\tif (rowsCount_";
  protected final String TEXT_4 = " < mapList_";
  protected final String TEXT_5 = ".size()){" + NL + "\t\t\t\tmap_";
  protected final String TEXT_6 = " = mapList_";
  protected final String TEXT_7 = ".get(rowsCount_";
  protected final String TEXT_8 = ");" + NL + "\t\t\t}else{" + NL + "\t\t\t\tmap_";
  protected final String TEXT_9 = " = null;" + NL + "\t\t\t}" + NL + "\t\t\tdynamicRowsCount_";
  protected final String TEXT_10 = "++;" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\tif (dynamicRowsCount_";
  protected final String TEXT_12 = " < dynamicMapList_";
  protected final String TEXT_13 = ".size()){" + NL + "\t\t\t\tdynamic_map_";
  protected final String TEXT_14 = " = dynamicMapList_";
  protected final String TEXT_15 = ".get(dynamicRowsCount_";
  protected final String TEXT_16 = ");" + NL + "\t\t\t}else{" + NL + "\t\t\t\tdynamic_map_";
  protected final String TEXT_17 = " = null;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t}else{" + NL + "\t\t\tmap_";
  protected final String TEXT_19 = " = iPaasObject.take();" + NL + "\t\t";
  protected final String TEXT_20 = NL + "\t\t\ttry{" + NL + "\t\t\t\tdynamic_map_";
  protected final String TEXT_21 = " = iPaasObject.takeDynamic();" + NL + "\t\t\t} catch (java.lang.NoSuchMethodError nc_";
  protected final String TEXT_22 = ") {" + NL + "\t\t\t\tthrow new java.lang.Exception(\"Dynamic types don't supported in this version\");" + NL + "\t\t\t}" + NL + "\t    ";
  protected final String TEXT_23 = NL + "\t\t}" + NL + "}";
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	cid = cid.replaceAll("_Loop", "");
	List<IMetadataTable> metadatas = node.getMetadataList();
	IMetadataTable metadata = null;
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);    
	}

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
    if (metadata.isDynamicSchema()) {
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
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    if (metadata.isDynamicSchema()) {
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
	    } 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
