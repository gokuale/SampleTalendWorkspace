package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TAsyncOutMainJava
{
  protected static String nl;
  public static synchronized TAsyncOutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAsyncOutMainJava result = new TAsyncOutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "\tObject[] row_";
  protected final String TEXT_4 = "=new Object[]{";
  protected final String TEXT_5 = "\"\",";
  protected final String TEXT_6 = "null,";
  protected final String TEXT_7 = "};\t\t";
  protected final String TEXT_8 = NL + "\trow_";
  protected final String TEXT_9 = "[";
  protected final String TEXT_10 = "] = String.valueOf(";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = "); ";
  protected final String TEXT_13 = NL + "\tif(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = " != null){";
  protected final String TEXT_16 = NL + "\t\trow_";
  protected final String TEXT_17 = "[";
  protected final String TEXT_18 = "] = ";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ";";
  protected final String TEXT_21 = NL + "\t\trow_";
  protected final String TEXT_22 = "[";
  protected final String TEXT_23 = "] = FormatterUtils.format_Date(";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\t\trow_";
  protected final String TEXT_28 = "[";
  protected final String TEXT_29 = "] = String.valueOf(";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "\t\trow_";
  protected final String TEXT_32 = "[";
  protected final String TEXT_33 = "] = java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = ")).toString();";
  protected final String TEXT_36 = NL + "\t\trow_";
  protected final String TEXT_37 = "[";
  protected final String TEXT_38 = "] = ";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = ".clone();";
  protected final String TEXT_41 = NL + "\t\trow_";
  protected final String TEXT_42 = "[";
  protected final String TEXT_43 = "] = String.valueOf(";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = ");";
  protected final String TEXT_46 = "                \t\t\t    " + NL + "\t}";
  protected final String TEXT_47 = NL + "\tif (index_";
  protected final String TEXT_48 = " >= ";
  protected final String TEXT_49 = ") {" + NL + "\t\tglobalMap.put(\"PARALLEL_FLOW_BUFFER_";
  protected final String TEXT_50 = "\", buffers_";
  protected final String TEXT_51 = ");" + NL + "\t\t/*";
  protected final String TEXT_52 = "Process(globalMap);*/" + NL + "\t\t";
  protected final String TEXT_53 = "Process(globalMap);" + NL + "\t\tbuffers_";
  protected final String TEXT_54 = " = new java.util.ArrayList<Object[]>();" + NL + "\t\tindex_";
  protected final String TEXT_55 = " = 0;" + NL + "\t}" + NL + "\tbuffers_";
  protected final String TEXT_56 = ".add(row_";
  protected final String TEXT_57 = ");" + NL + "\tindex_";
  protected final String TEXT_58 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String unitSize = ElementParameterParser.getValue(node,"__UNIT_SIZE__");
	boolean keepEmpty = "true".equals(ElementParameterParser.getValue(node,"__PARALLELIZE_KEEP_EMPTY__"));//bug TDI-21708
	
	List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas != null) && (metadatas.size() > 0)) {//b
        IMetadataTable metadata = metadatas.get(0);
        if (metadata != null) {//a	

    stringBuffer.append(TEXT_2);
    
    String incomingName = "";
  	List<? extends IConnection> inputConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
  	if ((inputConns!=null)&&(inputConns.size()>0)) {
  		IConnection incomingConn = inputConns.get(0); 
  		incomingName = incomingConn.getName();
  	}else{
  		return "";
  	}
	List<IMetadataColumn> columns = metadata.getListColumns();
	int columnSize = columns.size();

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    for(int j=0;j<columnSize;j++){if(keepEmpty){
    stringBuffer.append(TEXT_5);
    }else{
    stringBuffer.append(TEXT_6);
    }}
    stringBuffer.append(TEXT_7);
    
	for (int i = 0; i < columnSize; i++) {
		IMetadataColumn column = columns.get(i);
		String label = column.getLabel();
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
		if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_12);
    
		}else {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_15);
    
			if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){//Bug TDI-30242

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_20);
    
			}else if(javaType == JavaTypesManager.DATE && pattern != null){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_26);
    
			}else if(javaType == JavaTypesManager.BIGDECIMAL){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getPrecision() == null? incomingName + "." + column.getLabel() : incomingName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.CEILING)" );
    stringBuffer.append(TEXT_30);
    
			}else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_35);
    
			}else{
				if("id_Dynamic".equals(column.getTalendType())){

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_40);
    
				}else{

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_45);
    
				}
			}

    stringBuffer.append(TEXT_46);
    
		}
	}
	boolean isParallelize = false;
	String parallelizeNum = "2";
	INode parallelizeNode = null;
	for(INode tmpNode:node.getProcess().getGeneratingNodes()){
		if(tmpNode!=null && tmpNode.isActivate()){
			String parallelize = ElementParameterParser.getValue(tmpNode, "__PARALLELIZE__");
			if(parallelize!=null &&parallelize.equals("true")){
				isParallelize = true;
				parallelizeNode = tmpNode;
			}
		}
	}
	if(isParallelize){

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(unitSize);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(parallelizeNode.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid.replaceAll("tAsyncOut", "tAsyncIn"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
	}
		}//b
	}//a

    return stringBuffer.toString();
  }
}
