package org.talend.designer.codegen.translators.data_quality;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.ArrayList;
import org.talend.core.model.utils.NodeUtil;

public class TReservoirSamplingInBeginJava
{
  protected static String nl;
  public static synchronized TReservoirSamplingInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TReservoirSamplingInBeginJava result = new TReservoirSamplingInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "  " + NL + "  " + NL + "    final int sampleSize_";
  protected final String TEXT_3 = " = Integer.valueOf(\"";
  protected final String TEXT_4 = "\");    " + NL + "    ";
  protected final String TEXT_5 = "        " + NL + "        long random_seed_";
  protected final String TEXT_6 = " = Long.valueOf(";
  protected final String TEXT_7 = ");        " + NL + "        org.talend.dataquality.sampling.ReservoirSampler<";
  protected final String TEXT_8 = "Struct> sampler_";
  protected final String TEXT_9 = " " + NL + "            = new org.talend.dataquality.sampling.ReservoirSampler<";
  protected final String TEXT_10 = "Struct>(sampleSize_";
  protected final String TEXT_11 = ", random_seed_";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = "    " + NL + "        org.talend.dataquality.sampling.ReservoirSampler<";
  protected final String TEXT_14 = "Struct> sampler_";
  protected final String TEXT_15 = " " + NL + "            = new org.talend.dataquality.sampling.ReservoirSampler<";
  protected final String TEXT_16 = "Struct>(sampleSize_";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = "        " + NL + "    " + NL + "\tList<";
  protected final String TEXT_19 = "Struct> result_";
  protected final String TEXT_20 = " = null;";
  protected final String TEXT_21 = NL + "        ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    //String cid = node.getUniqueName();
    String cid = ElementParameterParser.getValue(node, "__DESTINATION__");
    String sampleSizeString = ElementParameterParser.getValue(node, "__SAMPLE_SIZE__");
    String randomSeedString = ElementParameterParser.getValue(node, "__RANDOM_SEED__");
    
    String incomingConnName = null;
    List<? extends IConnection> incomingConnections = node.getIncomingConnections();
	if (incomingConnections != null && !incomingConnections.isEmpty()) {
		for (IConnection conn : incomingConnections) {
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				incomingConnName = conn.getName();
				break;
			}
		}
	}

  
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(sampleSizeString);
    stringBuffer.append(TEXT_4);
    
    if(randomSeedString.length() > 0 && !"\"\"".equals(randomSeedString)){
    
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(randomSeedString);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    }else{
    stringBuffer.append(TEXT_13);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
