package org.talend.designer.codegen.translators.business.sap;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSAPIDocInputBeginJava
{
  protected static String nl;
  public static synchronized TSAPIDocInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPIDocInputBeginJava result = new TSAPIDocInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t" + NL;
  protected final String TEXT_3 = NL + NL + NL + NL + "class SapListener extends com.sap.mw.jco.JCO.Server {";
  protected final String TEXT_4 = NL + "    private String logFile = ";
  protected final String TEXT_5 = ";" + NL + "    private java.io.PrintWriter out     = null;" + NL;
  protected final String TEXT_6 = NL + "    public SapListener( String sapGwHost, String sapGwService, String progId, com.sap.mw.jco.IRepository repository ) {" + NL + "        super( sapGwHost, sapGwService, progId, repository );";
  protected final String TEXT_7 = NL + "\t\t\t\tthis.setProperty(";
  protected final String TEXT_8 = " ,";
  protected final String TEXT_9 = ");" + NL + "\t\t\t";
  protected final String TEXT_10 = "\t\t" + NL + "        try {" + NL + "            out = new java.io.PrintWriter( new java.io.FileWriter( logFile ), true );" + NL + "        } catch( Exception ex ) {" + NL + "            out = null;" + NL + "            ex.printStackTrace();" + NL + "        }" + NL + "" + NL + "        this.writeLogMessage( \"SAP Listener Started\" );";
  protected final String TEXT_11 = NL + "        System.out.println(\"SAP Listener Started\");" + NL + "    }" + NL;
  protected final String TEXT_12 = NL + "    private void writeLogMessage( String msg ) {" + NL + "        try {" + NL + "            out.println( msg );" + NL + "            out.flush();" + NL + "        } catch( Exception ex ) {" + NL + "            ex.printStackTrace();" + NL + "        }" + NL + "    }";
  protected final String TEXT_13 = NL + NL + "    protected void handleRequest( com.sap.mw.jco.JCO.Function function ) {" + NL + "        String functionName = \"IDOC_INBOUND_ASYNCHRONOUS\";" + NL;
  protected final String TEXT_14 = NL + "        String      idocDataFile = null;" + NL + "        java.io.PrintWriter dataOut      = null;";
  protected final String TEXT_15 = NL + "        com.sap.mw.jco.JCO.Table controlRecord = null;" + NL + "        com.sap.mw.jco.JCO.Table dataRecord    = null;" + NL + "\t\t" + NL + "        if( function.getName().equalsIgnoreCase( functionName ) ) {" + NL + "\t\t" + NL + "\t\t    controlRecord = function.getTableParameterList().getTable( 0 );" + NL + "            dataRecord    = function.getTableParameterList().getTable( 1 );" + NL;
  protected final String TEXT_16 = NL + "        \tfunction.writeXML(";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "        \tfunction.writeHTML(";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "            if( controlRecord.getNumRows() >= 1 ) {" + NL + "" + NL + "                this.writeLogMessage( \"TABNAM  - \" + controlRecord.getString( 0  ) );" + NL + "                this.writeLogMessage( \"IDOCTYP - \" + controlRecord.getString( 9  ) );" + NL + "                this.writeLogMessage( \"MESTYP  - \" + controlRecord.getString( 11 ) );" + NL + "" + NL + "                while( controlRecord.nextRow() ) {" + NL + "                    this.writeLogMessage( \"TABNAM  - \" + controlRecord.getString( 0  ) );" + NL + "                    this.writeLogMessage( \"IDOCTYP - \" + controlRecord.getString( 9  ) );" + NL + "                    this.writeLogMessage( \"MESTYP  - \" + controlRecord.getString( 11 ) );" + NL + "                }" + NL + "            }" + NL + "            if( dataRecord.getNumRows() >= 1 ) {" + NL + "" + NL + "                this.writeLogMessage( \"SEGNAM  - \" + dataRecord.getString( 0  ) );" + NL + "                while( dataRecord.nextRow() ) {" + NL + "                    this.writeLogMessage( \"SEGNAM - \" + dataRecord.getString( 0  ) );" + NL + "                }" + NL + "            }";
  protected final String TEXT_21 = NL + "        }" + NL + "    }" + NL + "}" + NL;
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_24 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = "; ";
  protected final String TEXT_29 = NL + "  " + NL + "" + NL + "com.sap.mw.jco.JCO.addClientPool( \"POOL\", 3, ";
  protected final String TEXT_30 = ", ";
  protected final String TEXT_31 = ", decryptedPassword_";
  protected final String TEXT_32 = ", ";
  protected final String TEXT_33 = ", ";
  protected final String TEXT_34 = ", ";
  protected final String TEXT_35 = " );" + NL + "com.sap.mw.jco.IRepository rep_";
  protected final String TEXT_36 = " = com.sap.mw.jco.JCO.createRepository( \"REP\", \"POOL\" );" + NL + "SapListener listener_";
  protected final String TEXT_37 = " = new SapListener( ";
  protected final String TEXT_38 = ", ";
  protected final String TEXT_39 = ", ";
  protected final String TEXT_40 = ", rep_";
  protected final String TEXT_41 = " );" + NL + "listener_";
  protected final String TEXT_42 = ".setTrace(true);" + NL + "listener_";
  protected final String TEXT_43 = ".start();" + NL + "synchronized(listener_";
  protected final String TEXT_44 = ") {" + NL + "\tlistener_";
  protected final String TEXT_45 = ".wait();" + NL + "}";
  protected final String TEXT_46 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    
boolean startIterate = false;

String client = ElementParameterParser.getValue(node, "__CLIENT__");
String userid = ElementParameterParser.getValue(node, "__USERID__");
String language = ElementParameterParser.getValue(node, "__LANGUAGE__");
String hostname = ElementParameterParser.getValue(node, "__HOSTNAME__");
String systemnumber = ElementParameterParser.getValue(node, "__SYSTEMNUMBER__");

String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
String activateLog = ElementParameterParser.getValue(node, "__ACTIVATE_LOGFILE__");
String logFile = ElementParameterParser.getValue(node, "__LOGFILE__");

String outFileXML = ElementParameterParser.getValue(node, "__FILE_IDOC_XML__");
String outFileHTML = ElementParameterParser.getValue(node, "__FILE_IDOC_HTML__");

String isXML = ElementParameterParser.getValue(node, "__FORMAT_XML__");
String isHTML = ElementParameterParser.getValue(node, "__FORMAT_HTML__");

String gwservice = ElementParameterParser.getValue(node, "__GATEWAYSERVICE__");
String programid = ElementParameterParser.getValue(node, "__PROGRAMID__");

List<Map<String, String>> sapProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SAP_PROPERTIES__");


    stringBuffer.append(TEXT_3);
    
	if(activateLog.equals("true")) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(logFile);
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    
	if(sapProps != null) {
		if(sapProps.size() > 0){
			for(Map<String, String> item : sapProps){
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_9);
     
			} 
		}
	}

	if(activateLog.equals("true")) {

    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    
	if(activateLog.equals("true")) {

    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    
	if(activateLog.equals("true")) {

    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    
			if("true".equals(isXML)) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(outFileXML);
    stringBuffer.append(TEXT_17);
    }
			if("true".equals(isHTML)) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(outFileHTML);
    stringBuffer.append(TEXT_19);
    }
		if(activateLog.equals("true")) {

    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    
String passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_22);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_25);
    } else {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(systemnumber);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(gwservice);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(programid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    return stringBuffer.toString();
  }
}
