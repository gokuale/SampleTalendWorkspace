package org.talend.designer.codegen.translators.data_quality;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TStemBeginJava
{
  protected static String nl;
  public static synchronized TStemBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TStemBeginJava result = new TStemBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    class StemmerHelper{" + NL + "      /** static hashmap of singletons for the stemmer classes [algo -> stemmer]. */" + NL + "      private java.util.Map<String, org.tartarus.snowball.SnowballProgram> algo2stemmer = new java.util.HashMap<String, org.tartarus.snowball.SnowballProgram>();" + NL + "  " + NL + "      private org.tartarus.snowball.SnowballProgram getSnowballProgram(String algorithm) throws ClassNotFoundException, InstantiationException," + NL + "        IllegalAccessException {" + NL + "        org.tartarus.snowball.SnowballProgram snowballProgram = algo2stemmer.get(algorithm);" + NL + "        if (snowballProgram == null) {" + NL + "          Class<?> stemClass = Class.forName(\"org.tartarus.snowball.ext.\" + algorithm + \"Stemmer\");" + NL + "          snowballProgram = (org.tartarus.snowball.SnowballProgram) stemClass.newInstance();" + NL + "          algo2stemmer.put(algorithm, snowballProgram);" + NL + "        }" + NL + "      " + NL + "        if (snowballProgram == null) {" + NL + "          throw new IllegalArgumentException(\"Could not create the stemmer with the given algorithm: \" + algorithm);" + NL + "        }" + NL + "        return snowballProgram;" + NL + "      }" + NL + "    " + NL + "      private String stem(String input, String algorithm) throws ClassNotFoundException, InstantiationException," + NL + "              IllegalAccessException {" + NL + "        org.tartarus.snowball.SnowballProgram stemmer = getSnowballProgram(algorithm);" + NL + "        stemmer.setCurrent(input);" + NL + "        stemmer.stem();" + NL + "        return stemmer.getCurrent();" + NL + "      }" + NL + "" + NL + "      public String stemming(String input, String algorithm){" + NL + "        try {" + NL + "          if (\"\".equals(algorithm)){" + NL + "            return input;" + NL + "          } else{" + NL + "            return this.stem(input, algorithm); //$NON-NLS-1$" + NL + "          }" + NL + "        } catch (ClassNotFoundException e) {" + NL + "          throw new RuntimeException(e);" + NL + "        } catch (InstantiationException e) {" + NL + "          throw new RuntimeException(e);" + NL + "        } catch (IllegalAccessException e) {" + NL + "          throw new RuntimeException(e);" + NL + "        }" + NL + "      }" + NL + "    }" + NL + "    StemmerHelper sh_";
  protected final String TEXT_2 = " = new StemmerHelper(); ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
  List<IMetadataTable> metadatas = node.getMetadataList();

if ((metadatas != null) && (metadatas.size() > 0)) {
  IMetadataTable metadata = metadatas.get(0);
  
  if (metadata != null) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
  }
}

    return stringBuffer.toString();
  }
}
