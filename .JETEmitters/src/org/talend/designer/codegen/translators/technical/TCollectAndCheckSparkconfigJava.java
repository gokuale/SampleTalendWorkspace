package org.talend.designer.codegen.translators.technical;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TCollectAndCheckSparkconfigJava
{
  protected static String nl;
  public static synchronized TCollectAndCheckSparkconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCollectAndCheckSparkconfigJava result = new TCollectAndCheckSparkconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "java.util.List<String> reference_";
  protected final String TEXT_2 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_3 = NL + "    reference_";
  protected final String TEXT_4 = ".add(\"";
  protected final String TEXT_5 = "\");";
  protected final String TEXT_6 = NL + NL + "// the globalOutputRDD and reference_tCollectAndCheck_1 will be used to display the diff file if the rdd and the reference differ. " + NL + "StringBuilder globalOutputRDD_";
  protected final String TEXT_7 = " = new StringBuilder();" + NL + "final java.util.List<String> staticReference_";
  protected final String TEXT_8 = " = new java.util.ArrayList<String>(reference_";
  protected final String TEXT_9 = ");" + NL + "" + NL + "// if the output has an element which is not in the reference, it is considered as a new element." + NL + "boolean outputHasNewElement_";
  protected final String TEXT_10 = " = false;" + NL + "" + NL + "// collect the RDD" + NL + "for (";
  protected final String TEXT_11 = " rdd: rdd_";
  protected final String TEXT_12 = ".collect()) {" + NL + "    // dump each line into a string" + NL + "    StringBuilder currentOutputRDD_";
  protected final String TEXT_13 = " = new StringBuilder();";
  protected final String TEXT_14 = NL + "            currentOutputRDD_";
  protected final String TEXT_15 = ".append(BigDataParserUtils.parseTo_String(rdd.";
  protected final String TEXT_16 = ", ";
  protected final String TEXT_17 = ")).append(";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "            currentOutputRDD_";
  protected final String TEXT_20 = ".append(BigDataParserUtils.parseTo_String(rdd.";
  protected final String TEXT_21 = ")).append(";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "    String currentOutputString_";
  protected final String TEXT_24 = " = currentOutputRDD_";
  protected final String TEXT_25 = ".substring(0, currentOutputRDD_";
  protected final String TEXT_26 = ".lastIndexOf(";
  protected final String TEXT_27 = "));" + NL + "    // save the current RDD in the globalOutputRDD" + NL + "    globalOutputRDD_";
  protected final String TEXT_28 = ".append(currentOutputString_";
  protected final String TEXT_29 = ").append(";
  protected final String TEXT_30 = ");" + NL + "" + NL + "    // check this RDD with the ref.";
  protected final String TEXT_31 = NL + "        if ((reference_";
  protected final String TEXT_32 = ".size() > 0) && (reference_";
  protected final String TEXT_33 = ".get(0).equals((currentOutputString_";
  protected final String TEXT_34 = ")))) {" + NL + "            reference_";
  protected final String TEXT_35 = ".remove(currentOutputString_";
  protected final String TEXT_36 = ");" + NL + "        } else {" + NL + "            outputHasNewElement_";
  protected final String TEXT_37 = "= true;" + NL + "        }";
  protected final String TEXT_38 = NL + "        if (reference_";
  protected final String TEXT_39 = ".contains(currentOutputString_";
  protected final String TEXT_40 = ")) {" + NL + "            reference_";
  protected final String TEXT_41 = ".remove(currentOutputString_";
  protected final String TEXT_42 = ");" + NL + "        } else {" + NL + "            outputHasNewElement_";
  protected final String TEXT_43 = " = true;" + NL + "        }";
  protected final String TEXT_44 = NL + "}" + NL + "" + NL + "" + NL + "// display result" + NL + "if (outputHasNewElement_";
  protected final String TEXT_45 = " || reference_";
  protected final String TEXT_46 = ".size() > 0) {" + NL + "    // if the output has new element and if the output does miss at least one element, display the error message";
  protected final String TEXT_47 = NL + "        LOG.error(\"Results: KO\");" + NL + "        LOG.error(\"New elements: \"+ outputHasNewElement_";
  protected final String TEXT_48 = ");" + NL + "        LOG.error(\"Missing: \"+ (reference_";
  protected final String TEXT_49 = ".size() > 0));" + NL + "        LOG.error(\"==================\");" + NL + "        LOG.error(\"=== REFERENCE ====\");" + NL + "        LOG.error(\"==================\");" + NL + "        LOG.error(staticReference_";
  protected final String TEXT_50 = ");" + NL + "        LOG.error(\"==================\");" + NL + "        LOG.error(\"==== RESULTS =====\");" + NL + "        LOG.error(\"==================\");" + NL + "        LOG.error(globalOutputRDD_";
  protected final String TEXT_51 = ");" + NL + "        LOG.error(\"==================\");" + NL + "        LOG.error(\"==== MISSING ====\");" + NL + "        LOG.error(\"==================\");" + NL + "        LOG.error(reference_";
  protected final String TEXT_52 = ");" + NL + "        LOG.error(\"======\");";
  protected final String TEXT_53 = NL + "        System.out.println(\"Results: KO\");" + NL + "        System.out.println(\"New elements: \"+ outputHasNewElement_";
  protected final String TEXT_54 = ");" + NL + "        System.out.println(\"Missing: \"+ (reference_";
  protected final String TEXT_55 = ".size() > 0));" + NL + "        System.out.println(\"==================\");" + NL + "        System.out.println(\"=== REFERENCE ====\");" + NL + "        System.out.println(\"==================\");" + NL + "        System.out.println(staticReference_";
  protected final String TEXT_56 = ");" + NL + "        System.out.println(\"==================\");" + NL + "        System.out.println(\"==== RESULTS =====\");" + NL + "        System.out.println(\"==================\");" + NL + "        System.out.println(globalOutputRDD_";
  protected final String TEXT_57 = ");" + NL + "        System.out.println(\"==================\");" + NL + "        System.out.println(\"==== MISSING ====\");" + NL + "        System.out.println(\"==================\");" + NL + "        System.out.println(reference_";
  protected final String TEXT_58 = ");" + NL + "        System.out.println(\"======\");";
  protected final String TEXT_59 = NL + NL + "    // Then throw an error" + NL + "    throw new RuntimeException(\"Error on component ";
  protected final String TEXT_60 = ".\");" + NL + "} else {";
  protected final String TEXT_61 = NL + "        LOG.debug(\"Results: OK\");";
  protected final String TEXT_62 = NL + "        System.out.println(\"Results: OK\");";
  protected final String TEXT_63 = NL + "}";
  protected final String TEXT_64 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
if(inConns != null && inConns.size() > 0) {
} else {
	return "";
}

IConnection inConn = inConns.get(0);
String inConnName = inConn.getName();
String inConnTypeName = codeGenArgument.getRecordStructName(inConn);
String separator = ElementParameterParser.getValue(node, "__SEPARATOR__");
String lineSeparator = ElementParameterParser.getValue(node, "__LINE_SEPARATOR__");
String reference = ElementParameterParser.getValue(node, "__REFERENCE__");
boolean keepOrdering = ("true").equals(ElementParameterParser.getValue(node, "__ORDERING__"));

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));


// parse the reference line by line.

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
String javajetLineSeparator = (String) java.security.AccessController.doPrivileged(
        new sun.security.action.GetPropertyAction("line.separator"));

String referenceEnCodeStr = "";
try {
    referenceEnCodeStr = (new sun.misc.BASE64Encoder()).encode(reference.getBytes("UTF-8"));
} catch (java.io.UnsupportedEncodingException e) {
    e.printStackTrace();
}

StringBuilder codeValuesBase64 = new StringBuilder();
for(String item : reference.split(javajetLineSeparator)) {
    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(item);
    stringBuffer.append(TEXT_5);
    
}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inConnTypeName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
    for(IMetadataColumn column: inConn.getMetadataTable().getListColumns()) {
        if (JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.DATE) {
            
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_18);
    
        } else {
            
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_22);
    
        }
    }
    
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(lineSeparator);
    stringBuffer.append(TEXT_30);
    
    if (keepOrdering) {
        
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
    } else {
        
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
    
    }
    
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
    if (isLog4jEnabled) {
        
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
    
    } else {
        
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
    }
    
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
    if (isLog4jEnabled) {
        
    stringBuffer.append(TEXT_61);
    
    } else {
        
    stringBuffer.append(TEXT_62);
    
    }
    
    stringBuffer.append(TEXT_63);
    stringBuffer.append(TEXT_64);
    return stringBuffer.toString();
  }
}
