package org.talend.designer.codegen.translators.system;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.BlockCode;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;

public class TRunJobMrconfigJava
{
  protected static String nl;
  public static synchronized TRunJobMrconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRunJobMrconfigJava result = new TRunJobMrconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "        //For different jobs, job name must be different, but classpath and JVM arguments are possbilely different" + NL + "        java.util.Map<String,List<String>> childJob_commandLine_Mapper_";
  protected final String TEXT_2 = " = new java.util.HashMap<String,List<String>>();" + NL + "        java.util.List<String> childJob_commandLine_";
  protected final String TEXT_3 = " = null;" + NL + "        String classpathSeparator_";
  protected final String TEXT_4 = " = System.getProperty(\"path.separator\");";
  protected final String TEXT_5 = NL + "                childJob_commandLine_";
  protected final String TEXT_6 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_7 = NL + "                    childJob_commandLine_";
  protected final String TEXT_8 = ".add(\"";
  protected final String TEXT_9 = "\");";
  protected final String TEXT_10 = NL + "                            childJob_commandLine_";
  protected final String TEXT_11 = ".add(DealChildJobLibrary.replaceJarPathsFromCrcMap(";
  protected final String TEXT_12 = ").replaceAll(\";\",classpathSeparator_";
  protected final String TEXT_13 = "));";
  protected final String TEXT_14 = NL + "                            childJob_commandLine_";
  protected final String TEXT_15 = ".add(";
  protected final String TEXT_16 = ".replaceAll(\";\",classpathSeparator_";
  protected final String TEXT_17 = "));";
  protected final String TEXT_18 = NL + "                            childJob_commandLine_";
  protected final String TEXT_19 = ".add(DealChildJobLibrary.replaceJarPathsFromCrcMap(\"";
  protected final String TEXT_20 = "\").replaceAll(\";\",classpathSeparator_";
  protected final String TEXT_21 = "));";
  protected final String TEXT_22 = NL + "                            childJob_commandLine_";
  protected final String TEXT_23 = ".add(\"";
  protected final String TEXT_24 = "\".replaceAll(\";\",classpathSeparator_";
  protected final String TEXT_25 = "));";
  protected final String TEXT_26 = NL + "                childJob_commandLine_Mapper_";
  protected final String TEXT_27 = ".put(\"";
  protected final String TEXT_28 = "\",childJob_commandLine_";
  protected final String TEXT_29 = ");    ";
  protected final String TEXT_30 = NL + NL + "\tjava.util.List<String> paraList_";
  protected final String TEXT_31 = " = new java.util.ArrayList<String>();" + NL + "\t";
  protected final String TEXT_32 = NL + "\t\tif (childJob_commandLine_Mapper_";
  protected final String TEXT_33 = ".get(";
  protected final String TEXT_34 = ")==null) {" + NL + "\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t" + NL + "\t\t\t\tLOG.fatal(\"";
  protected final String TEXT_36 = " - The child job named \" + ";
  protected final String TEXT_37 = " + \" is not in the job list.\");" + NL + "\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\tthrow new RuntimeException(\"The child job named \"+";
  protected final String TEXT_39 = "+\" is not in the job list.\");" + NL + "\t\t}" + NL + "\t\tparaList_";
  protected final String TEXT_40 = ".addAll(childJob_commandLine_Mapper_";
  protected final String TEXT_41 = ".get(";
  protected final String TEXT_42 = "));" + NL + "\t";
  protected final String TEXT_43 = NL + "\t\tString osName_";
  protected final String TEXT_44 = " = System.getProperty(\"os.name\");" + NL + "\t\tif (osName_";
  protected final String TEXT_45 = " != null && osName_";
  protected final String TEXT_46 = ".toLowerCase().startsWith(\"win\")) {" + NL + "      \t\t";
  protected final String TEXT_47 = NL + "\t      \t\t\tparaList_";
  protected final String TEXT_48 = ".add(\"";
  protected final String TEXT_49 = "\");" + NL + "\t      \t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\t\tparaList_";
  protected final String TEXT_51 = ".add(DealChildJobLibrary.replaceJarPathsFromCrcMap(";
  protected final String TEXT_52 = "));" + NL + "\t      \t\t\t\t";
  protected final String TEXT_53 = NL + "\t      \t\t\t\t\tparaList_";
  protected final String TEXT_54 = ".add(";
  protected final String TEXT_55 = ");" + NL + "\t      \t\t\t\t";
  protected final String TEXT_56 = NL + "\t        \t\t\t\tparaList_";
  protected final String TEXT_57 = ".add(DealChildJobLibrary.replaceJarPathsFromCrcMap(\"";
  protected final String TEXT_58 = "\"));" + NL + "\t      \t\t\t\t";
  protected final String TEXT_59 = NL + "\t      \t\t\t\t\tparaList_";
  protected final String TEXT_60 = ".add(\"";
  protected final String TEXT_61 = "\");" + NL + "\t      \t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t} else {" + NL + "      \t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t\tparaList_";
  protected final String TEXT_64 = ".add(\"";
  protected final String TEXT_65 = "\");" + NL + "\t      \t\t";
  protected final String TEXT_66 = NL + "\t\t\t\t\t\t\tparaList_";
  protected final String TEXT_67 = ".add(DealChildJobLibrary.replaceJarPathsFromCrcMap(";
  protected final String TEXT_68 = ").replace(\"$ROOT_PATH\",System.getProperty(\"user.dir\")));" + NL + "\t      \t\t\t\t";
  protected final String TEXT_69 = NL + "\t        \t\t\t\tparaList_";
  protected final String TEXT_70 = ".add(";
  protected final String TEXT_71 = ".replace(\"$ROOT_PATH\",System.getProperty(\"user.dir\")));" + NL + "\t     \t \t\t\t";
  protected final String TEXT_72 = NL + "      \t\t\t\t\tparaList_";
  protected final String TEXT_73 = ".add(DealChildJobLibrary.replaceJarPathsFromCrcMap(";
  protected final String TEXT_74 = ").replace(\"$ROOT_PATH\",System.getProperty(\"user.dir\")));" + NL + "\t      \t\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\t\t\t\tparaList_";
  protected final String TEXT_76 = ".add(";
  protected final String TEXT_77 = ");" + NL + "\t      \t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t}" + NL + "\t  \t";
  protected final String TEXT_79 = NL + NL + "\tparaList_";
  protected final String TEXT_80 = ".add(\"--stat_port=\" + null);" + NL + "" + NL + "\tparaList_";
  protected final String TEXT_81 = ".add(\"--parent_part_launcher=JOB:\" + jobName + \"/NODE:";
  protected final String TEXT_82 = "\");" + NL + "\t" + NL + "\tjava.util.Map<String, Object> parentContextMap_";
  protected final String TEXT_83 = " = new java.util.HashMap<String, Object>();" + NL + "" + NL + "\t";
  protected final String TEXT_84 = " " + NL + "\t\t";
  protected final String TEXT_85 = ".synchronizeContext();" + NL + "\t\tjava.util.Enumeration<?> propertyNames_";
  protected final String TEXT_86 = " = ";
  protected final String TEXT_87 = ".propertyNames();" + NL + "\t\twhile (propertyNames_";
  protected final String TEXT_88 = ".hasMoreElements()) {" + NL + "\t\t\tString key_";
  protected final String TEXT_89 = " = (String) propertyNames_";
  protected final String TEXT_90 = ".nextElement();" + NL + "\t\t\tObject value_";
  protected final String TEXT_91 = " = (Object) ";
  protected final String TEXT_92 = ".get(key_";
  protected final String TEXT_93 = ");       " + NL + "\t\t\tparaList_";
  protected final String TEXT_94 = ".add(\"--context_param \" + key_";
  protected final String TEXT_95 = " + \"=\" + value_";
  protected final String TEXT_96 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_97 = "  " + NL + "\t\t\tparentContextMap_";
  protected final String TEXT_98 = ".put(\"";
  protected final String TEXT_99 = "\", ";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = ");" + NL + "\t\t\t";
  protected final String TEXT_102 = NL + NL + "\tObject obj_";
  protected final String TEXT_103 = " = null;" + NL + "" + NL + "\t";
  protected final String TEXT_104 = NL + "\t\tobj_";
  protected final String TEXT_105 = " = ";
  protected final String TEXT_106 = ";" + NL + "\t\tparaList_";
  protected final String TEXT_107 = ".add(\"--context_param ";
  protected final String TEXT_108 = "=\" + RuntimeUtils.tRunJobConvertContext(obj_";
  protected final String TEXT_109 = "));" + NL + "\t\tparentContextMap_";
  protected final String TEXT_110 = ".put(\"";
  protected final String TEXT_111 = "\", obj_";
  protected final String TEXT_112 = ");" + NL + "\t";
  protected final String TEXT_113 = NL + "\t";
  protected final String TEXT_114 = NL + "\t\tSystem.out.println(\"";
  protected final String TEXT_115 = " in ";
  protected final String TEXT_116 = " call ";
  protected final String TEXT_117 = "\"+";
  protected final String TEXT_118 = "+\"";
  protected final String TEXT_119 = " with:\\n\\n\" + paraList_";
  protected final String TEXT_120 = " + \"\\n\");" + NL + "\t";
  protected final String TEXT_121 = NL + "\tRuntime runtime_";
  protected final String TEXT_122 = " = Runtime.getRuntime();" + NL + "\tfinal Process ps_";
  protected final String TEXT_123 = ";" + NL + "\tps_";
  protected final String TEXT_124 = " = runtime_";
  protected final String TEXT_125 = ".exec((String[])paraList_";
  protected final String TEXT_126 = ".toArray(new String[paraList_";
  protected final String TEXT_127 = ".size()]));" + NL + "" + NL + "\tThread normal_";
  protected final String TEXT_128 = " = new Thread() {" + NL + "\t\tpublic void run() {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps_";
  protected final String TEXT_129 = ".getInputStream()));" + NL + "\t\t\t\tString line = \"\";" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\twhile((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\tSystem.out.println(line);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} finally {" + NL + "\t\t\t\treader.close();" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\t\t";
  protected final String TEXT_130 = NL + "\t\t\t\t\tLOG.error(\"";
  protected final String TEXT_131 = " - \" + ioe.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_132 = NL + "\t\t\t\tioe.printStackTrace();" + NL + "\t\t\t}" + NL + "    \t}" + NL + "\t};" + NL + "\t";
  protected final String TEXT_133 = NL + "\t\tLOG.info(\"";
  protected final String TEXT_134 = " - The child job '";
  protected final String TEXT_135 = "\"+";
  protected final String TEXT_136 = "+\"";
  protected final String TEXT_137 = "' starts on the version '";
  protected final String TEXT_138 = "' with the context '";
  protected final String TEXT_139 = "'.\");" + NL + "\t";
  protected final String TEXT_140 = NL + "\tnormal_";
  protected final String TEXT_141 = ".start();" + NL + "\t";
  protected final String TEXT_142 = NL + "\t\tLOG.info(\"";
  protected final String TEXT_143 = " - The child job '";
  protected final String TEXT_144 = "\"+";
  protected final String TEXT_145 = "+\"";
  protected final String TEXT_146 = "' is done.\");" + NL + "\t";
  protected final String TEXT_147 = NL + NL + "\tfinal StringBuffer errorMsg_";
  protected final String TEXT_148 = " = new StringBuffer();" + NL + "\tThread error_";
  protected final String TEXT_149 = " = new Thread() {" + NL + "\t\tpublic void run() {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps_";
  protected final String TEXT_150 = ".getErrorStream()));" + NL + "\t\t\t\tString line = \"\";" + NL + "    \t\t\ttry {" + NL + "      \t\t\t\twhile((line = reader.readLine()) != null) {" + NL + "        \t\t\t\terrorMsg_";
  protected final String TEXT_151 = ".append(line).append(\"\\n\");" + NL + "      \t\t\t\t}" + NL + "    \t\t\t} finally {" + NL + "      \t\t\t\treader.close();" + NL + "    \t\t\t}" + NL + "  \t\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t\t\tLOG.error(\"";
  protected final String TEXT_153 = " - \" + ioe.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_154 = NL + "\t\t        ioe.printStackTrace();" + NL + "  \t\t\t}" + NL + "\t\t}" + NL + "\t};" + NL + "\terror_";
  protected final String TEXT_155 = ".start();" + NL + "" + NL + "\t//0 indicates normal termination\t" + NL + "\tint result_";
  protected final String TEXT_156 = " = ps_";
  protected final String TEXT_157 = ".waitFor();" + NL + "\tnormal_";
  protected final String TEXT_158 = ".join(10000);" + NL + "\terror_";
  protected final String TEXT_159 = ".join(10000);" + NL + "" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_160 = "_CHILD_RETURN_CODE\",result_";
  protected final String TEXT_161 = ");" + NL + "\tif (result_";
  protected final String TEXT_162 = " != 0) {" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_163 = "_CHILD_EXCEPTION_STACKTRACE\",errorMsg_";
  protected final String TEXT_164 = ".toString());" + NL + "\t\t";
  protected final String TEXT_165 = "  " + NL + "\t\t\t";
  protected final String TEXT_166 = NL + "\t\t\t\tLOG.fatal(\"";
  protected final String TEXT_167 = " - Child job returns \" + result_";
  protected final String TEXT_168 = " + \". It doesn't terminate normally.\\n\" + errorMsg_";
  protected final String TEXT_169 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_170 = NL + "    \t\tthrow new RuntimeException(\"Child job returns \" + result_";
  protected final String TEXT_171 = " + \". It doesn't terminate normally.\\n\" + errorMsg_";
  protected final String TEXT_172 = ".toString());" + NL + "\t\t";
  protected final String TEXT_173 = NL + "\t\t\t";
  protected final String TEXT_174 = NL + "\t\t\t\tLOG.error(\"";
  protected final String TEXT_175 = " - Child job returns \" + result_";
  protected final String TEXT_176 = " + \". It doesn't terminate normally.\\n\" + errorMsg_";
  protected final String TEXT_177 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_178 = NL + "\t\t\tSystem.err.println(\"Child job returns \" + result_";
  protected final String TEXT_179 = " + \". It doesn't terminate normally.\\n\" + errorMsg_";
  protected final String TEXT_180 = ".toString());" + NL + "\t\t";
  protected final String TEXT_181 = NL + "\t}" + NL + "" + NL + "\t";
  protected final String TEXT_182 = NL + "\t\tLOG.info(\"";
  protected final String TEXT_183 = " - Done.\");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_CHILD_ERROR__"));  
boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();  
boolean transmitWholeContext = ("true").equals(ElementParameterParser.getValue(node, "__TRANSMIT_WHOLE_CONTEXT__"));  
boolean printParameter = ("true").equals(ElementParameterParser.getValue(node, "__PRINT_PARAMETER__")); 

boolean originalContext = ("true").equals(ElementParameterParser.getValue(node, "__TRANSMIT_ORIGINAL_CONTEXT__")); 

IProcess currentProcess = node.getProcess();
List<Map<String, String>> contextParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONTEXTPARAMS__");
String process = ElementParameterParser.getValue(node,"__PROCESS_TYPE_PROCESS__");
String context = ElementParameterParser.getValue(node,"__PROCESS_TYPE_CONTEXT__");
String version = ElementParameterParser.getValue(node,"__PROCESS_TYPE_VERSION__");
// "\"--father_pid=\"+pid", "\"--root_pid=\"+rootPid", 
String[] codeOptions = new String[] {"\"--father_node="+ cid + "\""};
String[] commandLineWindows = new String[] {"<command>"};
String[] commandLineUnix = new String[] {"<command>"};
String[] commandLine = new String[] {"<command>"};
String childJob = ElementParameterParser.getValue(node,"__PROCESS__");


boolean useDynamicJob = ("true").equals(ElementParameterParser.getValue(node, "__USE_DYNAMIC_JOB__"));
String dynamicJobName = ElementParameterParser.getValue(node,"__CONTEXT_JOB__");
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
boolean propagateData = false;

try {
    if (useDynamicJob) {
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
    
        //issue 19108: The context text field waits for a context name without quotes. The component removes the first quote and the last quote if they exist.
        if (context.startsWith("\"")) {
            context=context.substring(1, context.length());
        }
        if (context.endsWith("\"")) {
            context=context.substring(0, context.length()-1);
        }

        if (process!=null && !process.equals("")) {
            String[] childJobIds = process.split(";");
            for (int i=0;i<childJobIds.length;i++) {
                
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
                commandLine = ProcessorUtilities.getCommandLine("win32",true, childJobIds[i], context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, codeOptions);

                // remove the frontal 2 lines
                if (commandLine.length > 0 && ProcessorUtilities.isExportConfig()) {
                    int tmpSize = commandLine.length - 2;
                    String[] tmp = new String[tmpSize];
                    System.arraycopy(commandLine, 2, tmp, 0, tmpSize);
                    commandLine = tmp;
                }
                for (int j = 0; j < commandLine.length; j++) {
                  // commandLine[j] = commandLine[j].replace("\n", "");
                  if (j == 0) {
                    
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(commandLine[j]);
    stringBuffer.append(TEXT_9);
    
                  } else if (j > 0) {
                    if (commandLine[j].indexOf("\"") >= 0) {
                        if (commandLine[j].indexOf(".jar")>=0) {
                            
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(commandLine[j] );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
                        } else {
                            
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(commandLine[j] );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
                        }
                    } else {
                        if (commandLine[j].indexOf(".jar")>=0) {
                            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(commandLine[j] );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
                        } else {
                            
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(commandLine[j] );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
                        }
                    }
                  }
                }

                //find the job name and classpath, the job name in front of codeOptions
                int position = 0;
                for(String tempCommandLine : commandLine) {
                    if (codeOptions[0].equals(tempCommandLine)) {
                        break;
                    }
                    position++;
                }

                int jobNamePosition = position-1;

                String childJobName = commandLine[jobNamePosition];
                childJobName = childJobName.substring(childJobName.lastIndexOf(".")+1);
                
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(childJobName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
            }
        }
    }
} catch (ProcessorException e) {
}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    

	if (useDynamicJob) {
		
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_34);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_42);
    
	} else {
		try {
	    	commandLineWindows = ProcessorUtilities.getCommandLine("win32",true, process, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, codeOptions);
	    	// remove the 2 fist lines
	    	if (commandLineWindows.length > 0 && ProcessorUtilities.isExportConfig()) {
	    		int tmpSize = commandLineWindows.length - 2;
	    		String[] tmp = new String[tmpSize];
	    		System.arraycopy(commandLineWindows, 2, tmp, 0, tmpSize);
	    		commandLineWindows = tmp;
    		}
	    	commandLineUnix = ProcessorUtilities.getCommandLine("linux",true, process, context,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, codeOptions);
    		// remove the 2 first lines
			if (commandLineUnix.length > 0 && ProcessorUtilities.isExportConfig()) {
				int tmpSize = commandLineUnix.length - 2;
				String[] tmp = new String[tmpSize];
				System.arraycopy(commandLineUnix, 2, tmp, 0, tmpSize);
				commandLineUnix = tmp;
			}
		} catch (ProcessorException e) {
		}

	  	
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    
			for (int i = 0; i < commandLineWindows.length; i++) {
				if (i == 0) {
	     	 	
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(commandLineWindows[i]);
    stringBuffer.append(TEXT_49);
    
				} else if (i > 0) {
	      			if (commandLineWindows[i].indexOf("\"") >= 0) {
						if (commandLineWindows[i].indexOf(".jar")>=0) {
	      				
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_52);
    
						} else {
	      				
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_55);
    
	          			}
	      			} else {
	          			if (commandLineWindows[i].indexOf(".jar")>=0) {
          				
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_58);
    
	          			} else {
          				
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(commandLineWindows[i] );
    stringBuffer.append(TEXT_61);
    
	          			}
	      			}	
	    		}
	  		}
	  		
    stringBuffer.append(TEXT_62);
    
			for (int i = 0; i < commandLineUnix.length; i++) {
				if (i == 0) {
	      		
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(commandLineUnix[i]);
    stringBuffer.append(TEXT_65);
    
	    		} else if (i > 0) {
	      			String param;
					if (commandLineUnix[i].indexOf("\"") >= 0) {
						param = commandLineUnix[i];
					} else {
						param = "\""+commandLineUnix[i]+"\"";
					}
					if (param.contains("$ROOT_PATH")) {
						if (param.indexOf(".jar") >= 0) {
	      				
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_68);
    
	      				} else {
	      				
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_71);
    
	      				}
	      			}else if (param.indexOf(".jar") >= 0) {
	      				
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_74);
    
	      			} else {
      				    
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(param );
    stringBuffer.append(TEXT_77);
    
	      			}
    			}
	  		}
	  		
    stringBuffer.append(TEXT_78);
    
	}
	
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    
	Set<IConnection> iterateConnSet =  new HashSet<IConnection>();
	List<? extends IConnection> iterateConns = node.getIncomingConnections(EConnectionType.ITERATE);
	if (iterateConns != null)  { 
		iterateConnSet.addAll(iterateConns);
	}
	boolean parallelIterate = false;
	for (IConnection iterateConn : iterateConnSet) {
		parallelIterate = "true".equals(ElementParameterParser.getValue(iterateConn, "__ENABLE_PARALLEL__"));
	}
	if (transmitWholeContext) { 
		String localContext = "context";
		if (parallelIterate) {
			localContext = "localContext";
		}
		
    stringBuffer.append(TEXT_84);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    
		List<IContextParameter> params = currentProcess.getContextManager().getDefaultContext().getContextParameterList();
		for (IContextParameter ctxParam :params) {
			String ctxParamName = ctxParam.getName();
 			
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(ctxParamName );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(localContext);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(ctxParamName );
    stringBuffer.append(TEXT_101);
    
		}
	} // transmitWholeContext
	
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
	for (int i=0; i<contextParams.size(); i++) {
		Map<String, String> contextParam = contextParams.get(i);
		String name = contextParam.get("PARAM_NAME_COLUMN");
		String value = contextParam.get("PARAM_VALUE_COLUMN");
		//bug22181
		if (parallelIterate && value!=null && value.contains("context.")) {
			value = value.replace("context.","localContext.");
		}
		
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(value );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
	}
	
    stringBuffer.append(TEXT_113);
    if (printParameter) {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(currentProcess.getName() );
    stringBuffer.append(TEXT_116);
    if (!useDynamicJob) {
    stringBuffer.append(childJob );
    } else {
    stringBuffer.append(TEXT_117);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    
	}

	
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    if (!useDynamicJob) {
    stringBuffer.append(childJob );
    } else {
    stringBuffer.append(TEXT_135);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_136);
    }
    stringBuffer.append(TEXT_137);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    if (!useDynamicJob) {
    stringBuffer.append(childJob );
    } else {
    stringBuffer.append(TEXT_144);
    stringBuffer.append(dynamicJobName);
    stringBuffer.append(TEXT_145);
    }
    stringBuffer.append(TEXT_146);
    }
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    }
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    if (dieOnError) { 
    stringBuffer.append(TEXT_165);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    }
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    } else {
    stringBuffer.append(TEXT_173);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    }
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    }
    stringBuffer.append(TEXT_181);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    }
    return stringBuffer.toString();
  }
}
