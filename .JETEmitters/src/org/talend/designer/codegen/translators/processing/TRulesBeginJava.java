package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TRulesBeginJava
{
  protected static String nl;
  public static synchronized TRulesBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRulesBeginJava result = new TRulesBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "class KnowledgeBase_";
  protected final String TEXT_3 = "{" + NL + "\t" + NL + "\tpublic final int BASE_DRL=0;" + NL + "\t" + NL + "\tpublic final int BASE_XLS=1;" + NL + "\t" + NL + "\tString fileName = null;" + NL + "\tint style = 0;" + NL + "" + NL + "\t" + NL + "\tKnowledgeBase_";
  protected final String TEXT_4 = "(String filename){" + NL + "\t\tthis.fileName = filename;" + NL + "\t\t" + NL + "\t\tif(this.fileName!=null){" + NL + "\t\t\tif(fileName.endsWith(\".drl\")){" + NL + "\t\t\t\tthis.style = BASE_DRL;" + NL + "\t\t\t}else if(fileName.endsWith(\".xls\")){" + NL + "\t\t\t\tthis.style = BASE_XLS;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tpublic org.kie.internal.KnowledgeBase readKnowledgeBase(){" + NL + "\t\tswitch(style){" + NL + "\t\t\tcase BASE_DRL:" + NL + "\t\t\t\treturn readKnowledgeBaseDRL();" + NL + "\t\t\tcase BASE_XLS:" + NL + "\t\t\t\treturn readKnowledgeBaseXLS();" + NL + "\t\t\tdefault:" + NL + "\t\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tpublic org.kie.internal.KnowledgeBase readKnowledgeBaseDRL(){" + NL + "        org.kie.internal.builder.KnowledgeBuilder kbuilder = org.kie.internal.builder.KnowledgeBuilderFactory.newKnowledgeBuilder();";
  protected final String TEXT_5 = NL + "          if (this.fileName.startsWith(\"file://\")||this.fileName.startsWith(\"http://\")){" + NL + "            kbuilder.add(org.kie.internal.io.ResourceFactory.newUrlResource(this.fileName), org.kie.api.io.ResourceType.DRL);" + NL + "          }" + NL + "          else" + NL + "          {" + NL + "            kbuilder.add(org.kie.internal.io.ResourceFactory.newFileResource(this.fileName), org.kie.api.io.ResourceType.DRL);" + NL + "          }";
  protected final String TEXT_6 = NL + "          kbuilder.add(org.kie.internal.io.ResourceFactory.newClassPathResource(this.fileName), org.kie.api.io.ResourceType.DRL);";
  protected final String TEXT_7 = " " + NL + "        org.kie.internal.builder.KnowledgeBuilderErrors errors = kbuilder.getErrors();" + NL + "        if (errors.size() > 0) {" + NL + "            for (org.kie.internal.builder.KnowledgeBuilderError error : errors) {" + NL + "                System.err.println(error);" + NL + "            }" + NL + "            throw new IllegalArgumentException(\"Could not parse knowledge.\");" + NL + "        }" + NL + "        org.kie.internal.KnowledgeBase kbase = org.kie.internal.KnowledgeBaseFactory.newKnowledgeBase();" + NL + "        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());" + NL + "        return kbase;" + NL + "        " + NL + "\t}" + NL + "\t" + NL + "\tpublic org.kie.internal.KnowledgeBase readKnowledgeBaseXLS(){" + NL + "\t" + NL + "        org.kie.internal.builder.KnowledgeBuilder kbuilder = org.kie.internal.builder.KnowledgeBuilderFactory.newKnowledgeBuilder();" + NL + "\t\t    org.kie.internal.builder.DecisionTableConfiguration config = org.kie.internal.builder.KnowledgeBuilderFactory.newDecisionTableConfiguration();" + NL + "\t\t    config.setInputType(org.kie.internal.builder.DecisionTableInputType.XLS);";
  protected final String TEXT_8 = NL + "          if (this.fileName.startsWith(\"file://\")||this.fileName.startsWith(\"http://\")){" + NL + "            kbuilder.add(org.kie.internal.io.ResourceFactory.newUrlResource(this.fileName), org.kie.api.io.ResourceType.DTABLE, config);            " + NL + "          }" + NL + "          else" + NL + "          {" + NL + "            kbuilder.add(org.kie.internal.io.ResourceFactory.newFileResource(this.fileName), org.kie.api.io.ResourceType.DTABLE, config);            " + NL + "          }";
  protected final String TEXT_9 = NL + "        \tkbuilder.add(org.kie.internal.io.ResourceFactory.newClassPathResource(this.fileName), org.kie.api.io.ResourceType.DTABLE, config);";
  protected final String TEXT_10 = NL + "        org.kie.internal.builder.KnowledgeBuilderErrors errors = kbuilder.getErrors();" + NL + "        if (errors.size() > 0) {" + NL + "            for (org.kie.internal.builder.KnowledgeBuilderError error : errors) {" + NL + "                System.err.println(error);" + NL + "            }" + NL + "            throw new IllegalArgumentException(\"Could not parse knowledge.\");" + NL + "        }" + NL + "        org.kie.internal.KnowledgeBase  kbase = org.kie.internal.KnowledgeBaseFactory.newKnowledgeBase();" + NL + "        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());" + NL + "        return kbase;" + NL + "        " + NL + "\t}" + NL + "\t" + NL + "}" + NL + "" + NL + "int nb_line_";
  protected final String TEXT_11 = " = 0;" + NL + "" + NL + "// MOD 2012-11-06 to fix TDQ-4649 " + NL + "org.kie.internal.KnowledgeBase kbase_";
  protected final String TEXT_12 = " = new KnowledgeBase_";
  protected final String TEXT_13 = "(";
  protected final String TEXT_14 = ").readKnowledgeBase();" + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();

List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

String propertyType = ElementParameterParser.getValue(node, "__PROPERTY_TYPE__");

String fileName = ElementParameterParser.getValue(node, "__SELECTED_FILE__");

List<Map<String, String>> schemas = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SCHEMAS__");

if(conns!=null && conns.size()>0){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
        if ("BUILT_IN".equals(propertyType)){ 

    stringBuffer.append(TEXT_5);
    
        }
        else
        {

    stringBuffer.append(TEXT_6);
    
        }

    stringBuffer.append(TEXT_7);
    
        if (("BUILT_IN").equals(propertyType)){ 

    stringBuffer.append(TEXT_8);
    
        }
        else
        {

    stringBuffer.append(TEXT_9);
    
        }

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(fileName );
    stringBuffer.append(TEXT_14);
    
}

    return stringBuffer.toString();
  }
}
