package org.talend.designer.codegen.translators.processing.fields;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TWriteXMLFieldsSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TWriteXMLFieldsSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteXMLFieldsSparkstreamingconfigJava result = new TWriteXMLFieldsSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "public static class ";
  protected final String TEXT_4 = "_convertFunction<KEY> implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<KEY, ";
  protected final String TEXT_5 = ">, KEY,";
  protected final String TEXT_6 = "> {" + NL + "\t\t" + NL + "\tprivate ";
  protected final String TEXT_7 = " converter;" + NL + "\t" + NL + "\tpublic ";
  protected final String TEXT_8 = "_convertFunction(JobConf job){" + NL + "\t\tthis.converter = new ";
  protected final String TEXT_9 = "(new ContextProperties(job));" + NL + "\t}" + NL + "\t" + NL + "\tpublic scala.Tuple2<KEY, ";
  protected final String TEXT_10 = "> call(scala.Tuple2<KEY, ";
  protected final String TEXT_11 = "> tuple) {" + NL + "\t\t";
  protected final String TEXT_12 = " record = new ";
  protected final String TEXT_13 = "();";
  protected final String TEXT_14 = NL + "\t\ttry {";
  protected final String TEXT_15 = NL + "\t\t\trecord.";
  protected final String TEXT_16 = " = new String(converter.convert(tuple._2()));";
  protected final String TEXT_17 = NL + "\t\t\trecord.";
  protected final String TEXT_18 = " = new String(converter.convert(tuple._2()), ";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\trecord.";
  protected final String TEXT_21 = " = null;" + NL + "\t\t}";
  protected final String TEXT_22 = NL + "\t\trecord.";
  protected final String TEXT_23 = " = java.nio.ByteBuffer.wrap(converter.convert(tuple._2()));";
  protected final String TEXT_24 = NL + "\t\treturn new scala.Tuple2(tuple._1(), record);" + NL + "\t}" + NL + "}";
  protected final String TEXT_25 = NL + "\torg.apache.spark.streaming.api.java.JavaPairDStream<NullWritable, ";
  protected final String TEXT_26 = "> rdd_";
  protected final String TEXT_27 = " = rdd_";
  protected final String TEXT_28 = ".mapToPair(new ";
  protected final String TEXT_29 = "_convertFunction(job));";
  protected final String TEXT_30 = NL + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();


    stringBuffer.append(TEXT_2);
    
/**
* This is a Javajet helper class meant to generate all Spark functions responsible for serializing rowXStruct objects into byte arrays
* within a Spark Streaming job.
*
* tWriteXXX Spark functions rely on converters to serialize rowStruct into byte arrays accepted by messaging output components.
* These converters are framework undependant : they can be reused with any framework which needs to send messages as byte arrays.
* The type name of the converter to use must be provided via the generateCode() method.
*  
* WARNING : this does not generate the converter code but only the Spark functions one actually. These functions are common between 
* all tWriteXXX components and converters code have to be generated elsewhere beforehand.
*/

class TWriteXXXHelper {

	private INode node;
	
	private IConnection incomingConnection;
	
	private IConnection outgoingConnection;

	public TWriteXXXHelper(INode node) {
		this.node = node;
		this.incomingConnection = findIncomingConnection();
		this.outgoingConnection = findOutgoingConnection();
	}
	
	public void generateCode(String converterTypeName) {
		String cid = node.getUniqueName();

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(getIncomingConnectionTypeName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(converterTypeName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(converterTypeName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(getIncomingConnectionTypeName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_13);
    
		if("STRING".equals(getOutputType())) {

    stringBuffer.append(TEXT_14);
    			
			if(getEncoding() == null || getEncoding().equals("")) {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_16);
    
			} else {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(getEncoding());
    stringBuffer.append(TEXT_19);
    
			}

    stringBuffer.append(TEXT_20);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_21);
    
		} else {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_23);
    
		}

    stringBuffer.append(TEXT_24);
    
	} // end generateCode()
	
	public void generateConfig() {
		String cid = node.getUniqueName();

    stringBuffer.append(TEXT_25);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(outgoingConnection.getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(incomingConnection.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    	
	} // end generateConfig()
	
	private IConnection findIncomingConnection() {
		IConnection result = null;
		if (node.getIncomingConnections() != null) {
		    for (IConnection in : node.getIncomingConnections()) {
		        if (in.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		            result = in;
		            break;
		        }
		    }
		}
		return result;
	}

   private IConnection findOutgoingConnection() {
		IConnection result = null;
		if (node.getOutgoingConnections() != null) {
		    for (IConnection in : node.getOutgoingConnections()) {
		        if (in.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		            result = in;
		            break;
		        }
		    }
		}
		return result;
	}
    
   private String getIncomingConnectionTypeName() {
		return codeGenArgument.getRecordStructName(this.incomingConnection);
   }
   
   private String getOutgoingConnectionTypeName() {
		return codeGenArgument.getRecordStructName(this.outgoingConnection);
   }
   
   private String getOutgoingColumnName() {
      return this.outgoingConnection.getMetadataTable().getListColumns().get(0).getLabel();
   }
   
   private String getOutputType() {
   	return ElementParameterParser.getValue(node, "__OUTPUT_TYPE__");
   }
   
   private String getEncoding() {
   	return ElementParameterParser.getValue(node, "__ENCODING__");
   }
    
} // end TWriteXXXHelper class

    stringBuffer.append(TEXT_30);
    
TWriteXXXHelper tWriteXXXHelper = new TWriteXXXHelper(node);
tWriteXXXHelper.generateConfig();

    return stringBuffer.toString();
  }
}
