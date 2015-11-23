package org.talend.designer.codegen.translators.data_quality;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class TDqReportRunBeginJava
{
  protected static String nl;
  public static synchronized TDqReportRunBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDqReportRunBeginJava result = new TDqReportRunBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "  " + NL + "     // prepare connection contexts" + NL + "    org.talend.core.runtime.CoreRuntimePlugin plugin_";
  protected final String TEXT_3 = " = org.talend.core.runtime.CoreRuntimePlugin.getInstance();" + NL + "    if (plugin_";
  protected final String TEXT_4 = " != null) {" + NL + "        org.talend.core.repository.services.StandaloneRepositoryContextService repositoryContextService" + NL + "            = (org.talend.core.repository.services.StandaloneRepositoryContextService)plugin_";
  protected final String TEXT_5 = ".getRepositoryContextService();" + NL + "        repositoryContextService.setContextProperties(context);" + NL + "    }" + NL + "    // prepare report contexts" + NL + "    org.talend.dataprofiler.core.tdq.DQReportContextHandler reportCtxHandler_";
  protected final String TEXT_6 = " = org.talend.dataprofiler.core.tdq.DQReportContextHandler.getInstance();" + NL + "    if (reportCtxHandler_";
  protected final String TEXT_7 = " != null) {" + NL + "        reportCtxHandler_";
  protected final String TEXT_8 = ".setContextProperties(context);" + NL + "    }" + NL + "  " + NL + "    String reportSubFolder_";
  protected final String TEXT_9 = " = \"/TDQ_Data Profiling/Reports/\";" + NL + "  " + NL + "    String projectDir_";
  protected final String TEXT_10 = " = \"";
  protected final String TEXT_11 = "\";" + NL + "    System.setProperty(\"talend.project.path\", projectDir_";
  protected final String TEXT_12 = ");" + NL + "    if(jobName!=null){" + NL + "        System.setProperty(\"talend.jobName\", jobName);" + NL + "    }" + NL + "    if(contextStr!=null){" + NL + "        System.setProperty(\"talend.jobContextName\", contextStr);" + NL + "    }" + NL + "    " + NL + "    int pos_";
  protected final String TEXT_13 = " = projectDir_";
  protected final String TEXT_14 = ".lastIndexOf('/');" + NL + "    String projectName_";
  protected final String TEXT_15 = " = null;" + NL + "    if (pos_";
  protected final String TEXT_16 = " > 0 && pos_";
  protected final String TEXT_17 = " < projectDir_";
  protected final String TEXT_18 = ".length() + 1) {" + NL + "        projectName_";
  protected final String TEXT_19 = " = projectDir_";
  protected final String TEXT_20 = ".substring(pos_";
  protected final String TEXT_21 = " + 1);" + NL + "    }" + NL + "    if (projectName_";
  protected final String TEXT_22 = " != null) {" + NL + "        java.io.File f = new java.io.File(\"items\");" + NL + "        if (f.exists()) { // running exported job, the project name is lowercased for exported items" + NL + "            String path = \"items/\" + projectName_";
  protected final String TEXT_23 = ".toLowerCase() + reportSubFolder_";
  protected final String TEXT_24 = ";" + NL + "            if (new java.io.File(path).exists()) {" + NL + "                System.setProperty(\"talend.dq.reporting.bundlepath\", \"items\");" + NL + "\t\t\t\tSystem.setProperty(\"talend.project.path\", \"items/\" + projectName_";
  protected final String TEXT_25 = ".toLowerCase());" + NL + "                projectDir_";
  protected final String TEXT_26 = " = path;" + NL + "            } else {" + NL + "                System.err.println(\"[INFO] This error may appear if the reports are not exported with the job.\");" + NL + "            }" + NL + "        } else { // running job in studio, use uppercased technical name." + NL + "            System.setProperty(\"talend.dq.reporting.bundlepath\", \"";
  protected final String TEXT_27 = "\");" + NL + "            projectDir_";
  protected final String TEXT_28 = " = projectDir_";
  protected final String TEXT_29 = ".substring(0, pos_";
  protected final String TEXT_30 = " + 1) + projectName_";
  protected final String TEXT_31 = " " + NL + "                + reportSubFolder_";
  protected final String TEXT_32 = ";" + NL + "        }" + NL + "    }" + NL + "    " + NL + "    //List<String> reportPaths_";
  protected final String TEXT_33 = " = new java.util.ArrayList<String>();" + NL + "    java.util.StringTokenizer t_";
  protected final String TEXT_34 = " = new java.util.StringTokenizer(";
  protected final String TEXT_35 = ", \",\");" + NL + "    while(t_";
  protected final String TEXT_36 = ".hasMoreTokens()){" + NL + "        //reportPaths_";
  protected final String TEXT_37 = ".clear();" + NL + "        String token = t_";
  protected final String TEXT_38 = ".nextToken();" + NL + "        int idx = token.indexOf(reportSubFolder_";
  protected final String TEXT_39 = ");" + NL + "        if(idx > 0){" + NL + "            token = token.substring(idx + reportSubFolder_";
  protected final String TEXT_40 = ".length());" + NL + "        }" + NL + "        // reportPaths_";
  protected final String TEXT_41 = ".add(token);" + NL + "                " + NL + "        org.talend.dataquality.reporting.engine.StandaloneReportDocGenerator generator_";
  protected final String TEXT_42 = " =" + NL + "                new org.talend.dataquality.reporting.engine.StandaloneReportDocGenerator(projectDir_";
  protected final String TEXT_43 = " + token);" + NL + "        java.util.Date timestamp = new java.util.Date();" + NL + "        double startTime = System.currentTimeMillis();" + NL + "        try{" + NL + "            generator_";
  protected final String TEXT_44 = ".initReportFile();" + NL + "            generator_";
  protected final String TEXT_45 = ".setOutputFolderPath(";
  protected final String TEXT_46 = ");" + NL + "            org.talend.utils.sugars.ReturnCode returnCode=generator_";
  protected final String TEXT_47 = ".generate();" + NL + "            if(!returnCode.isOk()){" + NL + "                generator_";
  protected final String TEXT_48 = ".setSucceeded(false);" + NL + "                if(returnCode.getMessage()!=null){" + NL + "                    generator_";
  protected final String TEXT_49 = ".setErrorMessage(returnCode.getMessage());" + NL + "                }" + NL + "            }" + NL + "        }catch(Exception e){" + NL + "            generator_";
  protected final String TEXT_50 = ".setSucceeded(false);" + NL + "            StringBuffer buf = new StringBuffer(\"Stack trace:\\n\");" + NL + "            for (StackTraceElement s : e.getStackTrace()) {" + NL + "                buf.append(s).append(\"\\n\");" + NL + "            }" + NL + "            if(e.getMessage() != null && !\"null\".equals(e.getMessage())){            " + NL + "            \tgenerator_";
  protected final String TEXT_51 = ".setErrorMessage(e.getMessage() +\"\\n\"+ buf.toString());" + NL + "            }else{" + NL + "            \tgenerator_";
  protected final String TEXT_52 = ".setErrorMessage(buf.toString());" + NL + "            }" + NL + "        }" + NL + "        double endTime = System.currentTimeMillis();" + NL + "        double duration = (endTime - startTime)/1000;" + NL + "      ";
  protected final String TEXT_53 = NL + "            ";
  protected final String TEXT_54 = ".REPORT_UUID = generator_";
  protected final String TEXT_55 = ".getReportUUID();";
  protected final String TEXT_56 = NL + "            ";
  protected final String TEXT_57 = ".REPORT_NAME = token;";
  protected final String TEXT_58 = NL + "            ";
  protected final String TEXT_59 = ".EXE_TIMESTAMP = timestamp;";
  protected final String TEXT_60 = NL + "            ";
  protected final String TEXT_61 = ".EXE_DURATION = duration;";
  protected final String TEXT_62 = NL + "            ";
  protected final String TEXT_63 = ".EXE_STATUS = generator_";
  protected final String TEXT_64 = ".isSucceeded();        ";
  protected final String TEXT_65 = NL + "            ";
  protected final String TEXT_66 = ".INFO_FAILURE = generator_";
  protected final String TEXT_67 = ".getErrorMessage();";
  protected final String TEXT_68 = NL + "        }";
  protected final String TEXT_69 = NL + "        }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String reportFiles  = ElementParameterParser.getValue(node, "__REPORT_FILE__");
    String outputFolder  = ElementParameterParser.getValue(node, "__OUTPUT_FOLDER__");
  
    String compDefaultProjectDir = ElementParameterParser.getValue(node.getProcess(), "__COMP_DEFAULT_PROJECT_DIR__");
    String dqReportingBundleDir = ElementParameterParser.getValue(node.getProcess(), "__DQ_REPORTING_BUNDLE_DIR__");

  
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
    stringBuffer.append(compDefaultProjectDir);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(dqReportingBundleDir);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(reportFiles);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
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
    stringBuffer.append(outputFolder);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
        for (IConnection conn : node.getOutgoingConnections()) {
            if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    
    stringBuffer.append(TEXT_53);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
            }
        }

    /* to adapt IS_MULTIPLYING_OUTPUTS option */
    if (node.getOutgoingConnections() == null || node.getOutgoingConnections().size() == 0){
    
    stringBuffer.append(TEXT_68);
    /* to adapt has onsubjob connection, but no main connection */
    }else{
       boolean hasMain =false;
       for (IConnection conn : node.getOutgoingConnections()) {
            if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
                 hasMain = true;
                 break;
            }
       }
       if( hasMain ==false ){
      
    stringBuffer.append(TEXT_69);
     
       }
    }
    
    return stringBuffer.toString();
  }
}
