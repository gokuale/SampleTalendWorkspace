package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TAsyncInBeginJava
{
  protected static String nl;
  public static synchronized TAsyncInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAsyncInBeginJava result = new TAsyncInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\twhile (!this.isFinish()) {" + NL + "\t\tjava.util.List<Object[]> buffers_";
  protected final String TEXT_3 = "= (java.util.List<Object[]>) this.pollBuffer();// wait" + NL + "\t\tint buffersSize_";
  protected final String TEXT_4 = " = buffers_";
  protected final String TEXT_5 = ".size();// bug0014422" + NL + "\t\tthis.setFree(false);" + NL + "\t\tif (buffers_";
  protected final String TEXT_6 = " != null && buffers_";
  protected final String TEXT_7 = ".size() > 0) {" + NL + "\t\t\tfor (Object[] row_";
  protected final String TEXT_8 = " : buffers_";
  protected final String TEXT_9 = ") {";
  protected final String TEXT_10 = NL + "    \t\t";
  protected final String TEXT_11 = " = null;\t\t\t";
  protected final String TEXT_12 = "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_13 = " = new ";
  protected final String TEXT_14 = "Struct();";
  protected final String TEXT_15 = NL + "\t\t";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = " = (Dynamic)row_";
  protected final String TEXT_18 = "[";
  protected final String TEXT_19 = "];";
  protected final String TEXT_20 = NL + "\t\t";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = " = row_";
  protected final String TEXT_23 = "[";
  protected final String TEXT_24 = "]==null?null:String.valueOf(row_";
  protected final String TEXT_25 = "[";
  protected final String TEXT_26 = "]);";
  protected final String TEXT_27 = NL + "\t\t\t\t  ";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = " = row_";
  protected final String TEXT_30 = "[";
  protected final String TEXT_31 = "];" + NL + "\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_33 = NL + "\t\t\tString temp_";
  protected final String TEXT_34 = "_";
  protected final String TEXT_35 = " = String.valueOf(row_";
  protected final String TEXT_36 = "[";
  protected final String TEXT_37 = "]);" + NL + "\t\t\tif(temp_";
  protected final String TEXT_38 = "_";
  protected final String TEXT_39 = ".length() > 0) {" + NL + "\t\t";
  protected final String TEXT_40 = NL + "\t\t\tString temp_";
  protected final String TEXT_41 = "_";
  protected final String TEXT_42 = " = row_";
  protected final String TEXT_43 = "[";
  protected final String TEXT_44 = "]==null?null:String.valueOf(row_";
  protected final String TEXT_45 = "[";
  protected final String TEXT_46 = "]);" + NL + "\t\t\tif(temp_";
  protected final String TEXT_47 = "_";
  protected final String TEXT_48 = " != null) {" + NL + "\t\t";
  protected final String TEXT_49 = NL + "\t\t\t";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = " = temp_";
  protected final String TEXT_52 = "_";
  protected final String TEXT_53 = ".getBytes(";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "\t\t\t";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_58 = "_";
  protected final String TEXT_59 = ", ";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\t\t\t";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = " = ParserUtils.parseTo_";
  protected final String TEXT_64 = "(ParserUtils.parseTo_Number(temp_";
  protected final String TEXT_65 = "_";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = ", ";
  protected final String TEXT_68 = "));";
  protected final String TEXT_69 = NL + "\t\t\t";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = " = ParserUtils.parseTo_";
  protected final String TEXT_72 = "(temp_";
  protected final String TEXT_73 = "_";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "\t\t} else {\t\t\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_77 = "' in '";
  protected final String TEXT_78 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_79 = NL + "\t\t\t";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = ";";
  protected final String TEXT_83 = NL + "\t\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
	boolean advancedSeparator = (advancedSeparatorStr!=null&&!advancedSeparatorStr.equals(""))?advancedSeparatorStr.equals("true"):false;
	String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
	String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
	boolean keepEmpty = "true".equals(ElementParameterParser.getValue(node,"__PARALLELIZE_KEEP_EMPTY__"));//bug TDI-21708
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	IMetadataTable metadata=null;
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
    

 	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

	if (conns!=null && conns.size()>0) {
		for (int i=0;i<conns.size();i++) {
			IConnection connTemp = conns.get(i);
			if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_11);
    
			}
		}
	}
	
	String firstConnName = "";
	if (conns!=null && conns.size()>0) {//1
		IConnection conn = conns.get(0);
		firstConnName = conn.getName();			
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//2

    stringBuffer.append(TEXT_12);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_14);
    
			List<IMetadataColumn> listColumns = metadata.getListColumns();
			int sizeListColumns = listColumns.size();
			for (int valueN=0; valueN<sizeListColumns; valueN++) {//3
				IMetadataColumn column = listColumns.get(valueN);
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    
				if("id_Dynamic".equals(column.getTalendType())){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_19);
    
				}else if(javaType == JavaTypesManager.STRING){//4

    stringBuffer.append(TEXT_20);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_26);
    
				}else if(javaType == JavaTypesManager.OBJECT){//Bug TDI-30242
				
    stringBuffer.append(TEXT_27);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_31);
    
				}else{//4

    stringBuffer.append(TEXT_32);
    if(keepEmpty){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_39);
    }else{
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_48);
    }
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_49);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_54);
    
					}else if(javaType == JavaTypesManager.DATE) { 

    stringBuffer.append(TEXT_55);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_59);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_60);
    
					}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_61);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_66);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_67);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_68);
    
					} else { 

    stringBuffer.append(TEXT_69);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_74);
    
					}

    stringBuffer.append(TEXT_75);
    
					String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
					if(defaultValue == null) {

    stringBuffer.append(TEXT_76);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_78);
    
					} else {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_82);
    
					}

    stringBuffer.append(TEXT_83);
    
				}//4
			}//3
		}//2
	}//1

    return stringBuffer.toString();
  }
}
