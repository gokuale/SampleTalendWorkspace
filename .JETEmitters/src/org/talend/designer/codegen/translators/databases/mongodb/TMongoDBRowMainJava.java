package org.talend.designer.codegen.translators.databases.mongodb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TMongoDBRowMainJava
{
  protected static String nl;
  public static synchronized TMongoDBRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBRowMainJava result = new TMongoDBRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_2 = " = new StringBuffer();" + NL + "\t";
  protected final String TEXT_3 = NL + "\ttry{" + NL + "\t\t";
  protected final String TEXT_4 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Execute command: \\\"\" + ";
  protected final String TEXT_6 = " + \"\\\" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\tresult_";
  protected final String TEXT_8 = "=db_";
  protected final String TEXT_9 = ".command(";
  protected final String TEXT_10 = ");" + NL + "\t\t";
  protected final String TEXT_11 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_12 = " - Execute script function: \" + ";
  protected final String TEXT_13 = " + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\t\tlog4jSb_";
  protected final String TEXT_15 = ".append(";
  protected final String TEXT_16 = ");" + NL + "\t\t\t\t\tlog4jSb_";
  protected final String TEXT_17 = ".append(\"|\");\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_19 = " - Arguments : \" + log4jSb_";
  protected final String TEXT_20 = "+\".\");" + NL + "\t\t\t\tlog4jSb_";
  protected final String TEXT_21 = ".delete(0,log4jSb_";
  protected final String TEXT_22 = ".length());\t" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\tresult_";
  protected final String TEXT_24 = "=db_";
  protected final String TEXT_25 = ".doEval(";
  protected final String TEXT_26 = ",";
  protected final String TEXT_27 = ");" + NL + "\t\t";
  protected final String TEXT_28 = NL + "\t\tif(result_";
  protected final String TEXT_29 = ".ok()){" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_31 = " - Return the result is : \"+result_";
  protected final String TEXT_32 = ");" + NL + "\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t    System.out.println(result_";
  protected final String TEXT_34 = ");" + NL + "\t\t    ";
  protected final String TEXT_35 = NL + "\t\t}else{" + NL + "\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_37 = " - Error result: \" + result_";
  protected final String TEXT_38 = ");" + NL + "\t\t\t";
  protected final String TEXT_39 = NL + "                System.out.println(result_";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\t            throw new Exception(\"Error result: \" + result_";
  protected final String TEXT_42 = ");" + NL + "\t        ";
  protected final String TEXT_43 = NL + "\t\t}" + NL + "\t} catch(Exception e_";
  protected final String TEXT_44 = ") {" + NL + "\t\t";
  protected final String TEXT_45 = NL + "\t\t\te_";
  protected final String TEXT_46 = ".printStackTrace();" + NL + "\t\t\tthrow e_";
  protected final String TEXT_47 = ";" + NL + "\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_49 = " - \" + e_";
  protected final String TEXT_50 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t    System.err.println(e_";
  protected final String TEXT_52 = ".getMessage());" + NL + "\t\t\t    ";
  protected final String TEXT_53 = NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
  	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
  	INode node = (INode)codeGenArgument.getArgument();
  	String cid = node.getUniqueName();

    boolean isExecuteCommand = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__EXECUTE_COMMAND__"));
    String function = ElementParameterParser.getValue(node,"__FUNCTION__");
    function = function.replaceAll("\n"," ");
    function = function.replaceAll("\r"," ");
  	String command = ElementParameterParser.getValue(node,"__COMMAND__");
  	List<Map<String, String>> parameters = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FUNCTION_PARAMETERS__");
  	boolean dieOnError = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
  	
  	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
  	if (isLog4jEnabled) {
	
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
	}
	
    stringBuffer.append(TEXT_3);
    
		if(isExecuteCommand){
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(command);
    stringBuffer.append(TEXT_6);
    
			}
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(command);
    stringBuffer.append(TEXT_10);
    
		}else{
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(function);
    stringBuffer.append(TEXT_13);
    
				for(Map<String, String> parameter:parameters){
				
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(parameter.get("PARAMETER"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
				}
				
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
			}
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(function);
    for(Map<String, String> parameter:parameters){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(parameter.get("PARAMETER"));
    }
    stringBuffer.append(TEXT_27);
    
		}
		
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
			} else {
			
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
			}
			
    stringBuffer.append(TEXT_35);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
			} else {
            
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
            }
	        if (dieOnError) {
	        
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
	        }
	        
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
		if (dieOnError) {
		
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
		} else {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
			} else {
			    
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
			}
		}
		
    stringBuffer.append(TEXT_53);
    return stringBuffer.toString();
  }
}
