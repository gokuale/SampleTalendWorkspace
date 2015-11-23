package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TThresholdViolationAlertOutMainJava
{
  protected static String nl;
  public static synchronized TThresholdViolationAlertOutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TThresholdViolationAlertOutMainJava result = new TThresholdViolationAlertOutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t(";
  protected final String TEXT_3 = NL + "\t\t";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = " != null?";
  protected final String TEXT_6 = NL + "    \t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_7 = "), ";
  protected final String TEXT_8 = ",";
  protected final String TEXT_9 = ")\t\t\t\t\t";
  protected final String TEXT_10 = NL + "    \t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = "), ";
  protected final String TEXT_13 = ",";
  protected final String TEXT_14 = ")\t\t\t\t\t\t";
  protected final String TEXT_15 = NL + "            String.valueOf(";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = ")";
  protected final String TEXT_18 = NL + "            FormatterUtils.format_Date(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ",";
  protected final String TEXT_21 = ")";
  protected final String TEXT_22 = NL + "\t\t\t";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = NL + "\t\t\tString.valueOf(";
  protected final String TEXT_25 = ")";
  protected final String TEXT_26 = NL + "            ";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = ".toString()";
  protected final String TEXT_29 = ":";
  protected final String TEXT_30 = "null";
  protected final String TEXT_31 = NL + "\t\t)";
  protected final String TEXT_32 = NL + "bd_";
  protected final String TEXT_33 = ".append(";
  protected final String TEXT_34 = ")";
  protected final String TEXT_35 = ".append(\"";
  protected final String TEXT_36 = "\" + ";
  protected final String TEXT_37 = " + ";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "bdExtra_";
  protected final String TEXT_40 = ".append(\"\\n\"+";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "bd_";
  protected final String TEXT_43 = ".append(";
  protected final String TEXT_44 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid_original = ElementParameterParser.getValue(node, "__DESTINATION__");
String cid = cid_original.replace("tThresholdViolationAlert","tThresholdVA");

String suffixSeparator = ElementParameterParser.getValue(node, "__SUFFIXSEPARATOR__");
String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
String additionInfo = ElementParameterParser.getValue(node, "__ADDITIONINFO__");

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

//XMLTool
class XMLTool{
	public boolean advancedSeparator = false;
	public String thousandsSeparator = null;
 	public String decimalSeparator =null;
	public String connName = null;
	public String cid = null;
	
	public void getValue(IMetadataColumn column){
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		String defaultValue=column.getDefault();
		boolean isNotSetDefault = false;
		if(defaultValue!=null){
			isNotSetDefault = defaultValue.length()==0;
		}else{
			isNotSetDefault=true;
		}

    stringBuffer.append(TEXT_2);
    
		if(column.isNullable()){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_5);
    
		}
		
        if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        	if(javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( thousandsSeparator);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_9);
    
    		} else {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_12);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_14);
    
	   		}
        } else if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_17);
    
        }else if(javaType == JavaTypesManager.DATE){
            if( column.getPattern() != null && column.getPattern().trim().length() != 0 ){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_21);
    
            }else{

    stringBuffer.append(TEXT_22);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel());
    
           }
        }else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getPrecision() == null? connName + "." + column.getLabel() : connName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_25);
    
        }else{

    stringBuffer.append(TEXT_26);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_28);
    
		}
		if(column.isNullable()){
			
    stringBuffer.append(TEXT_29);
     
			if(isNotSetDefault == false){
				
    stringBuffer.append(column.getDefault());
    
			}else{
				
    stringBuffer.append(TEXT_30);
    
			}
		}

    stringBuffer.append(TEXT_31);
    
	}
}

if (node.getIncomingConnections()!=null) {
	for (IConnection incomingConn : node.getIncomingConnections()) {
		if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
			List<IMetadataColumn> inputCols = inputMetadataTable.getListColumns();

		    // init tool
            XMLTool tool = new XMLTool();
            tool.connName = incomingConn.getName();
            tool.advancedSeparator=advancedSeparator;
            tool.thousandsSeparator=thousandsSeparator;
            tool.decimalSeparator=decimalSeparator;
            tool.cid=cid;

			for (int i=0; i<inputCols.size();i++) {
				IMetadataColumn inputCol = inputCols.get(i);

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    if(i!=0){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(inputCol.getLabel() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(suffixSeparator );
    stringBuffer.append(TEXT_37);
     tool.getValue(inputCol); 
    stringBuffer.append(TEXT_38);
    
			}
			if(!"".equals(additionInfo)){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(additionInfo );
    stringBuffer.append(TEXT_41);
    
			}

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_44);
    
		}
	}
}

    return stringBuffer.toString();
  }
}
