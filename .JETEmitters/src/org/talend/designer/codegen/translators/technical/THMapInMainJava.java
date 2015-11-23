package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class THMapInMainJava
{
  protected static String nl;
  public static synchronized THMapInMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THMapInMainJava result = new THMapInMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "    if(outMap.get(\"";
  protected final String TEXT_5 = "\")==null){";
  protected final String TEXT_6 = NL + "        ";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " = null;" + NL + " \t}else if (outMap.get(\"";
  protected final String TEXT_9 = "\") instanceof String) { " + NL + " \t\t";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = " = (String)outMap.get(\"";
  protected final String TEXT_12 = "\");" + NL + " \t}";
  protected final String TEXT_13 = NL + "\t if(outMap.get(\"";
  protected final String TEXT_14 = "\")==null){";
  protected final String TEXT_15 = NL + "        ";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = " = false;" + NL + "     }else if (outMap.get(\"";
  protected final String TEXT_18 = "\") instanceof Boolean) { " + NL + "\t \t";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = " = ((Boolean)outMap.get(\"";
  protected final String TEXT_21 = "\")).booleanValue();" + NL + "\t }";
  protected final String TEXT_22 = NL + " \t if(outMap.get(\"";
  protected final String TEXT_23 = "\")==null){";
  protected final String TEXT_24 = NL + "        ";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = " = 0;" + NL + "     }else if (outMap.get(\"";
  protected final String TEXT_27 = "\") instanceof Byte) { " + NL + "\t \t";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = " = ((Byte)outMap.get(\"";
  protected final String TEXT_30 = "\")).byteValue();" + NL + "\t }";
  protected final String TEXT_31 = NL + " \t if(outMap.get(\"";
  protected final String TEXT_32 = "\")==null){";
  protected final String TEXT_33 = NL + "        ";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " = 0;" + NL + "     }else if (outMap.get(\"";
  protected final String TEXT_36 = "\") instanceof Character) { " + NL + " \t\t";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = " = ((Character)outMap.get(\"";
  protected final String TEXT_39 = "\")).charValue();" + NL + "\t} else if (outMap.get(\"";
  protected final String TEXT_40 = "\") instanceof Short) { " + NL + " \t\t";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = " = (char)((Short)outMap.get(\"";
  protected final String TEXT_43 = "\")).shortValue();" + NL + " \t}";
  protected final String TEXT_44 = NL + "   if(outMap.get(\"";
  protected final String TEXT_45 = "\")==null){";
  protected final String TEXT_46 = NL + "        ";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = " = 0;" + NL + "     }else if (outMap.get(\"";
  protected final String TEXT_49 = "\") instanceof Short) { " + NL + " \t\t";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = " = ((Short)outMap.get(\"";
  protected final String TEXT_52 = "\")).shortValue();" + NL + " \t}";
  protected final String TEXT_53 = NL + " \tif(outMap.get(\"";
  protected final String TEXT_54 = "\")==null){";
  protected final String TEXT_55 = NL + "        ";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = " = 0;" + NL + "    }else if (outMap.get(\"";
  protected final String TEXT_58 = "\") instanceof Integer) { " + NL + " \t\t";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = " = ((Integer)outMap.get(\"";
  protected final String TEXT_61 = "\")).intValue();" + NL + " \t}";
  protected final String TEXT_62 = NL + " \tif(outMap.get(\"";
  protected final String TEXT_63 = "\")==null){";
  protected final String TEXT_64 = NL + "        ";
  protected final String TEXT_65 = ".";
  protected final String TEXT_66 = " = (long)0;" + NL + "    }else if (outMap.get(\"";
  protected final String TEXT_67 = "\") instanceof Long) { " + NL + " \t\t";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = " = ((Long)outMap.get(\"";
  protected final String TEXT_70 = "\")).longValue();" + NL + " \t}";
  protected final String TEXT_71 = NL + " \tif(outMap.get(\"";
  protected final String TEXT_72 = "\")==null){";
  protected final String TEXT_73 = NL + "        ";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = " = 0.0f;" + NL + "    }else if (outMap.get(\"";
  protected final String TEXT_76 = "\") instanceof Float) { " + NL + " \t\t";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = " = ((Float)outMap.get(\"";
  protected final String TEXT_79 = "\")).floatValue();" + NL + " \t}";
  protected final String TEXT_80 = NL + " \tif(outMap.get(\"";
  protected final String TEXT_81 = "\")==null){";
  protected final String TEXT_82 = NL + "        ";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = " = 0.0;" + NL + "    }else if (outMap.get(\"";
  protected final String TEXT_85 = "\") instanceof Double) { " + NL + " \t\t";
  protected final String TEXT_86 = ".";
  protected final String TEXT_87 = " = ((Double)outMap.get(\"";
  protected final String TEXT_88 = "\")).doubleValue();" + NL + " \t}";
  protected final String TEXT_89 = NL + " \tif(outMap.get(\"";
  protected final String TEXT_90 = "\")==null){";
  protected final String TEXT_91 = NL + "        ";
  protected final String TEXT_92 = ".";
  protected final String TEXT_93 = " = null;" + NL + "    }else if (outMap.get(\"";
  protected final String TEXT_94 = "\") instanceof java.math.BigDecimal) { " + NL + " \t\t";
  protected final String TEXT_95 = ".";
  protected final String TEXT_96 = " = (java.math.BigDecimal)outMap.get(\"";
  protected final String TEXT_97 = "\");" + NL + " \t}";
  protected final String TEXT_98 = NL + " \tif(outMap.get(\"";
  protected final String TEXT_99 = "\")==null){";
  protected final String TEXT_100 = NL + "        ";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = " = null;" + NL + "    }else if (outMap.get(\"";
  protected final String TEXT_103 = "\") instanceof java.util.Date) { " + NL + " \t\t";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = " = (java.util.Date)outMap.get(\"";
  protected final String TEXT_106 = "\");" + NL + "\t}";
  protected final String TEXT_107 = NL + "    java.io.StringWriter swOut_";
  protected final String TEXT_108 = " = (java.io.StringWriter)";
  protected final String TEXT_109 = ".this.globalMap.get(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_110 = "_\"+\"outputResult\");" + NL + "    if (swOut_";
  protected final String TEXT_111 = " != null)" + NL + " \t    ";
  protected final String TEXT_112 = ".";
  protected final String TEXT_113 = " = swOut_";
  protected final String TEXT_114 = ".toString();";
  protected final String TEXT_115 = NL + "\tjava.io.ByteArrayOutputStream basOut_";
  protected final String TEXT_116 = " = (java.io.ByteArrayOutputStream)";
  protected final String TEXT_117 = ".this.globalMap.get(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_118 = "_\"+\"outputResult\");" + NL + "    if (basOut_";
  protected final String TEXT_119 = " != null)" + NL + " \t    ";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = " = (byte[])basOut_";
  protected final String TEXT_122 = ".toByteArray();";
  protected final String TEXT_123 = NL + "\t";
  protected final String TEXT_124 = ".";
  protected final String TEXT_125 = " = (java.io.InputStream)";
  protected final String TEXT_126 = ".this.globalMap.get(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_127 = "_\"+\"outputResult\");";
  protected final String TEXT_128 = NL + "  \t";
  protected final String TEXT_129 = ".";
  protected final String TEXT_130 = " = new routines.system.Document();" + NL + "\torg.dom4j.io.DocumentResult drOut_";
  protected final String TEXT_131 = " = (org.dom4j.io.DocumentResult)";
  protected final String TEXT_132 = ".this.globalMap.get(Thread" + NL + "                .currentThread().getId()+\"_";
  protected final String TEXT_133 = "_\"+\"outputResult\");" + NL + "    if (drOut_";
  protected final String TEXT_134 = " != null)" + NL + " \t    ((routines.system.Document)";
  protected final String TEXT_135 = ".";
  protected final String TEXT_136 = ").setDocument(drOut_";
  protected final String TEXT_137 = ".getDocument()); \t";
  protected final String TEXT_138 = "\t" + NL + NL;
  protected final String TEXT_139 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String this_cid = ElementParameterParser.getValue(node, "__UNIQUE_NAME__");
	String tHMap_id = this_cid.replace("_THMAP_IN", "");
	String cid = tHMap_id;

	boolean asMap = "true".equals(ElementParameterParser.getValue(node, "__AS_MAP__"));
	boolean asString = "true".equals(ElementParameterParser.getValue(node, "__AS_STRING__"));
	boolean asBytearray = "true".equals(ElementParameterParser.getValue(node, "__AS_BYTEARRAY__"));
	boolean asInputstream = "true".equals(ElementParameterParser.getValue(node, "__AS_INPUTSTREAM__"));
	boolean asDocument = "true".equals(ElementParameterParser.getValue(node, "__AS_DOCUMENT__"));

    stringBuffer.append(TEXT_2);
    
	if (node.getOutgoingConnections()!=null) {			
for (IConnection outgoingConn : node.getOutgoingConnections()) {
		if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {						

    stringBuffer.append(TEXT_3);
    
				String outputConnName = outgoingConn.getName();
				IMetadataTable outputMetadataTable = outgoingConn.getMetadataTable();
				for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
					if (asMap) {
						if (JavaTypesManager.STRING.getId().equals(outputCol.getTalendType())) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_12);
    
						} else if (JavaTypesManager.BOOLEAN.getId().equals(outputCol.getTalendType())) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_21);
    
						} else if (JavaTypesManager.BYTE.getId().equals(outputCol.getTalendType())) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_30);
    
						} else if (JavaTypesManager.CHARACTER.getId().equals(outputCol.getTalendType())) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_43);
    
						} else if (JavaTypesManager.SHORT.getId().equals(outputCol.getTalendType())) {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_52);
    
						} else if (JavaTypesManager.INTEGER.getId().equals(outputCol.getTalendType())) {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_61);
    
						} else if (JavaTypesManager.LONG.getId().equals(outputCol.getTalendType())) {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_70);
    
						} else if (JavaTypesManager.FLOAT.getId().equals(outputCol.getTalendType())) {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_79);
    
						} else if (JavaTypesManager.DOUBLE.getId().equals(outputCol.getTalendType())) {

    stringBuffer.append(TEXT_80);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_88);
    
						} else if (JavaTypesManager.BIGDECIMAL.getId().equals(outputCol.getTalendType())) {

    stringBuffer.append(TEXT_89);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_97);
    
						} else if (JavaTypesManager.DATE.getId().equals(outputCol.getTalendType())) {

    stringBuffer.append(TEXT_98);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_106);
    
						}
					} else if (asString) {

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
						break;
					} else if (asBytearray) {

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
						break;
					} else if (asInputstream) {

    stringBuffer.append(TEXT_123);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_125);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
						break;
					} else if (asDocument) {

    stringBuffer.append(TEXT_128);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append( node.getProcess().getName() );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
						break;
					}
				}
				break;
			}
		}		

	}

    stringBuffer.append(TEXT_138);
    stringBuffer.append(TEXT_139);
    return stringBuffer.toString();
  }
}
