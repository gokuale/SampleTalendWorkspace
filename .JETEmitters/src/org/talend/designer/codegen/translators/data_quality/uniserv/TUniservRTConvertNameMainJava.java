package org.talend.designer.codegen.translators.data_quality.uniserv;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class TUniservRTConvertNameMainJava
{
  protected static String nl;
  public static synchronized TUniservRTConvertNameMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniservRTConvertNameMainJava result = new TUniservRTConvertNameMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t\t";
  protected final String TEXT_2 = " = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_3 = " = new ";
  protected final String TEXT_4 = "Struct();";
  protected final String TEXT_5 = NL + "\t\t\t\t\t";
  protected final String TEXT_6 = " = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_7 = " = new ";
  protected final String TEXT_8 = "Struct();";
  protected final String TEXT_9 = NL + "\t\t\t\t\tif (";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = " != null) {" + NL + "\t\t\t\t\t\tcnameClient_";
  protected final String TEXT_12 = ".setArg(uniserv.cliserv.Name.";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_16 = NL + "\t\t\tunires_";
  protected final String TEXT_17 = " = cnameClient_";
  protected final String TEXT_18 = ".execRequest(uniserv.cliserv.Name.ANALYSE_NAME);" + NL + "\t\t\tint retType_";
  protected final String TEXT_19 = " = unires_";
  protected final String TEXT_20 = ".getRetType();" + NL + "\t\t\tif (retType_";
  protected final String TEXT_21 = " == uniserv.cliserv.GenClient.UNI_ERR) {" + NL + "\t\t\t\tcnameClient_";
  protected final String TEXT_22 = ".getErrorMsg(retType_";
  protected final String TEXT_23 = ", unires_";
  protected final String TEXT_24 = ".getRetInfo(), " + NL + "\t\t\t\t\t\t\tlangCode_";
  protected final String TEXT_25 = ", errmsg_";
  protected final String TEXT_26 = ");" + NL + "" + NL + "\t\t\t\tcnameClient_";
  protected final String TEXT_27 = ".close();" + NL + "\t\t\t\tglobalMap.put(\"WS_ERROR_CODE\", unires_";
  protected final String TEXT_28 = ".getRetInfo());" + NL + "                globalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_29 = "\");" + NL + "                globalMap.put(\"WS_ERROR_MESSAGE\", errmsg_";
  protected final String TEXT_30 = ".toString());" + NL + "\t\t\t\tthrow new RuntimeException(\"Error code \" + unires_";
  protected final String TEXT_31 = ".getRetInfo() + \": \" + errmsg_";
  protected final String TEXT_32 = ".toString());" + NL + "\t\t\t} else if (retType_";
  protected final String TEXT_33 = " == uniserv.cliserv.GenClient.UNI_WARN) {" + NL + "\t\t\t\tcnameClient_";
  protected final String TEXT_34 = ".getErrorMsg(retType_";
  protected final String TEXT_35 = ", unires_";
  protected final String TEXT_36 = ".getRetInfo(), " + NL + "\t\t\t\t\t\t\tlangCode_";
  protected final String TEXT_37 = ", errmsg_";
  protected final String TEXT_38 = ");" + NL + "" + NL + "\t\t\t\tSystem.err.println(\"Warning \" + unires_";
  protected final String TEXT_39 = ".getRetInfo() + \": \" + errmsg_";
  protected final String TEXT_40 = ".toString());" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tv_";
  protected final String TEXT_41 = ".removeAllElements();";
  protected final String TEXT_42 = NL + "\t\t\t\t\t\tv_";
  protected final String TEXT_43 = ".addElement(resClassArg_";
  protected final String TEXT_44 = ");\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\tv_";
  protected final String TEXT_46 = ".addElement(uniserv.cliserv.Name.";
  protected final String TEXT_47 = ");\t\t";
  protected final String TEXT_48 = NL + NL + "\t\t\tunires_";
  protected final String TEXT_49 = " = cnameClient_";
  protected final String TEXT_50 = ".getArg(v_";
  protected final String TEXT_51 = ", h_";
  protected final String TEXT_52 = ");" + NL + "\t\t\tif (unires_";
  protected final String TEXT_53 = ".getRetType() == uniserv.cliserv.GenClient.UNI_ERR) {" + NL + "\t\t\t\tcnameClient_";
  protected final String TEXT_54 = ".getErrorMsg(unires_";
  protected final String TEXT_55 = ".getRetType(), unires_";
  protected final String TEXT_56 = ".getRetInfo(), " + NL + "\t\t\t\t\t\t\tlangCode_";
  protected final String TEXT_57 = ", errmsg_";
  protected final String TEXT_58 = ");" + NL + "" + NL + "\t\t\t\tcnameClient_";
  protected final String TEXT_59 = ".close();" + NL + "\t\t\t\tglobalMap.put(\"WS_ERROR_CODE\", unires_";
  protected final String TEXT_60 = ".getRetInfo());" + NL + "                globalMap.put(\"WS_ERROR_COMPONENT_NAME\", \"";
  protected final String TEXT_61 = "\");" + NL + "                globalMap.put(\"WS_ERROR_MESSAGE\", errmsg_";
  protected final String TEXT_62 = ".toString());" + NL + "\t\t\t\tthrow new RuntimeException(\"Error code \" + unires_";
  protected final String TEXT_63 = ".getRetInfo() + \": \" + errmsg_";
  protected final String TEXT_64 = ".toString());" + NL + "\t\t\t} else if (unires_";
  protected final String TEXT_65 = ".getRetType() == uniserv.cliserv.GenClient.UNI_WARN) {" + NL + "\t\t\t\tcnameClient_";
  protected final String TEXT_66 = ".getErrorMsg(unires_";
  protected final String TEXT_67 = ".getRetType(), unires_";
  protected final String TEXT_68 = ".getRetInfo(), " + NL + "\t\t\t\t\t\t\tlangCode_";
  protected final String TEXT_69 = ", errmsg_";
  protected final String TEXT_70 = ");" + NL + "" + NL + "\t\t\t\tSystem.err.println(\"Warning \" + unires_";
  protected final String TEXT_71 = ".getRetInfo() + \": \" + errmsg_";
  protected final String TEXT_72 = ".toString());" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tString resClassArgVal_";
  protected final String TEXT_73 = " = (String) h_";
  protected final String TEXT_74 = ".get(resClassArg_";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = NL + "\t\t\t\tint outResClass_";
  protected final String TEXT_77 = " = 0;" + NL + "\t\t\t\tif (resClassArgVal_";
  protected final String TEXT_78 = " != null) {" + NL + "\t\t\t\t\toutResClass_";
  protected final String TEXT_79 = " = Integer.parseInt(resClassArgVal_";
  protected final String TEXT_80 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (outResClass_";
  protected final String TEXT_81 = " >= rejectClass_";
  protected final String TEXT_82 = ") {";
  protected final String TEXT_83 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = " = ";
  protected final String TEXT_86 = ".";
  protected final String TEXT_87 = ";";
  protected final String TEXT_88 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_89 = " = null;";
  protected final String TEXT_90 = NL + "\t\t\t\t} else {";
  protected final String TEXT_91 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_92 = ".";
  protected final String TEXT_93 = " = resClassArgVal_";
  protected final String TEXT_94 = ";";
  protected final String TEXT_95 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = " = (String)h_";
  protected final String TEXT_98 = ".get(uniserv.cliserv.Name.";
  protected final String TEXT_99 = ");";
  protected final String TEXT_100 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = " = ";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = ";";
  protected final String TEXT_105 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_106 = " = null;";
  protected final String TEXT_107 = NL + "\t\t\t\t}";
  protected final String TEXT_108 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = " = resClassArgVal_";
  protected final String TEXT_111 = ";";
  protected final String TEXT_112 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_113 = ".";
  protected final String TEXT_114 = " = (String)h_";
  protected final String TEXT_115 = ".get(uniserv.cliserv.Name.";
  protected final String TEXT_116 = ");";
  protected final String TEXT_117 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_118 = ".";
  protected final String TEXT_119 = " = ";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = ";";
  protected final String TEXT_122 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean useRejects = "true".equals(ElementParameterParser.getValue(node, "__USE_REJECTS__"));


List<String> cnameInputArgs = new ArrayList<String>();
cnameInputArgs.add("IN_LINE_1");
cnameInputArgs.add("IN_LINE_2");
cnameInputArgs.add("IN_LINE_3");
cnameInputArgs.add("IN_LINE_4");
cnameInputArgs.add("IN_LINE_5");
cnameInputArgs.add("IN_LINE_6");

List<String> cnameOutputArgs = new ArrayList<String>();
cnameOutputArgs.add("OUT_RES_RATE");
cnameOutputArgs.add("OUT_COMPANY");
cnameOutputArgs.add("OUT_COMP_FORM");
cnameOutputArgs.add("OUT_RES_COMP_REF");
cnameOutputArgs.add("OUT_COMP_REF");
cnameOutputArgs.add("OUT_COMP_REF_WORD");
cnameOutputArgs.add("OUT_PERS1");
cnameOutputArgs.add("OUT_RES_PERS1_REF");
cnameOutputArgs.add("OUT_PERS1_REF");
cnameOutputArgs.add("OUT_PERS1_REF_WORD");
cnameOutputArgs.add("OUT_RES_PERS1_SEX");
cnameOutputArgs.add("OUT_PERS1_SALUTATION");
cnameOutputArgs.add("OUT_PERS1_LETTER");
cnameOutputArgs.add("OUT_PERS1_ENVELOPE");
cnameOutputArgs.add("OUT_PERS1_TITLE_ACA");
cnameOutputArgs.add("OUT_PERS1_TITLE_NOB");
cnameOutputArgs.add("OUT_PERS1_TITLE_OTH");
cnameOutputArgs.add("OUT_PERS1_PROF");
cnameOutputArgs.add("OUT_PERS1_FIRST");
cnameOutputArgs.add("OUT_RES_PERS1_FIRST");
cnameOutputArgs.add("OUT_PERS1_LAST");
cnameOutputArgs.add("OUT_PERS1_LAST_PREF");
cnameOutputArgs.add("OUT_PERS1_LAST_MAIN");
cnameOutputArgs.add("OUT_PERS1_LAST_SUFF");
cnameOutputArgs.add("OUT_RES_PERS1_LAST");
cnameOutputArgs.add("OUT_PERS2");
cnameOutputArgs.add("OUT_RES_PERS2_REF");
cnameOutputArgs.add("OUT_PERS2_REF");
cnameOutputArgs.add("OUT_PERS2_REF_WORD");
cnameOutputArgs.add("OUT_RES_PERS2_SEX");
cnameOutputArgs.add("OUT_PERS2_SALUTATION");
cnameOutputArgs.add("OUT_PERS2_LETTER");
cnameOutputArgs.add("OUT_PERS2_ENVELOPE");
cnameOutputArgs.add("OUT_PERS2_TITLE_ACA");
cnameOutputArgs.add("OUT_PERS2_TITLE_NOB");
cnameOutputArgs.add("OUT_PERS2_TITLE_OTH");
cnameOutputArgs.add("OUT_PERS2_PROF");
cnameOutputArgs.add("OUT_PERS2_FIRST");
cnameOutputArgs.add("OUT_RES_PERS2_FIRST");
cnameOutputArgs.add("OUT_PERS2_LAST");
cnameOutputArgs.add("OUT_PERS2_LAST_PREF");
cnameOutputArgs.add("OUT_PERS2_LAST_MAIN");
cnameOutputArgs.add("OUT_PERS2_LAST_SUFF");
cnameOutputArgs.add("OUT_RES_PERS2_LAST");
cnameOutputArgs.add("OUT_PERS3");
cnameOutputArgs.add("OUT_RES_PERS3_REF");
cnameOutputArgs.add("OUT_PERS3_REF");
cnameOutputArgs.add("OUT_PERS3_REF_WORD");
cnameOutputArgs.add("OUT_RES_PERS3_SEX");
cnameOutputArgs.add("OUT_PERS3_SALUTATION");
cnameOutputArgs.add("OUT_PERS3_LETTER");
cnameOutputArgs.add("OUT_PERS3_ENVELOPE");
cnameOutputArgs.add("OUT_PERS3_TITLE_ACA");
cnameOutputArgs.add("OUT_PERS3_TITLE_NOB");
cnameOutputArgs.add("OUT_PERS3_TITLE_OTH");
cnameOutputArgs.add("OUT_PERS3_PROF");
cnameOutputArgs.add("OUT_PERS3_FIRST");
cnameOutputArgs.add("OUT_RES_PERS3_FIRST");
cnameOutputArgs.add("OUT_PERS3_LAST");
cnameOutputArgs.add("OUT_PERS3_LAST_PREF");
cnameOutputArgs.add("OUT_PERS3_LAST_MAIN");
cnameOutputArgs.add("OUT_PERS3_LAST_SUFF");
cnameOutputArgs.add("OUT_RES_PERS3_LAST");
cnameOutputArgs.add("OUT_LOCATION_ADD");
cnameOutputArgs.add("OUT_STR_HNO");
cnameOutputArgs.add("OUT_ZIP");
cnameOutputArgs.add("OUT_CITY");
cnameOutputArgs.add("OUT_NOT_RECOGNIZED");
cnameOutputArgs.add("OUT_RES_INFO");
cnameOutputArgs.add("OUT_RES_SEX");
cnameOutputArgs.add("OUT_SALUTATION");
cnameOutputArgs.add("OUT_LETTER");
cnameOutputArgs.add("OUT_ENVELOPE");
cnameOutputArgs.add("OUT_FREE_FIELD_01");
cnameOutputArgs.add("OUT_FREE_FIELD_02");
cnameOutputArgs.add("OUT_FREE_FIELD_03");
cnameOutputArgs.add("OUT_FREE_FIELD_04");
cnameOutputArgs.add("OUT_FREE_FIELD_05");
cnameOutputArgs.add("OUT_FREE_FIELD_06");
cnameOutputArgs.add("OUT_FREE_FIELD_07");
cnameOutputArgs.add("OUT_FREE_FIELD_08");
cnameOutputArgs.add("OUT_FREE_FIELD_09");
cnameOutputArgs.add("OUT_FREE_FIELD_10");
cnameOutputArgs.add("OUT_RES_CNAME_CL");


String incomingConn = "";
List<IMetadataTable> metadataList = node.getMetadataList();
if (metadataList != null && metadataList.size() > 0) { // 1
	IMetadataTable inMetadata = metadataList.get(0);
	IMetadataTable outMetadata = metadataList.get(1);
	IMetadataTable rejMetadata = metadataList.get(2);
	if (outMetadata != null) { // 2
		List<? extends IConnection> inConns = node.getIncomingConnections();
		List<? extends IConnection> outConns = node.getOutgoingConnections("OUTPUT");
		List<? extends IConnection> rejConns = node.getOutgoingConnections("REJECT");

		for (IConnection inConn : inConns) { // 3
			incomingConn = inConn.getName();
			if (outConns != null) { // 4
				for (IConnection outConn : outConns) { // 5

    stringBuffer.append(TEXT_1);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_4);
    
				} // end 5
			} // end 4
			
			if (rejConns != null) { // 7
				for (IConnection rejConn : rejConns) { // 8

    stringBuffer.append(TEXT_5);
    stringBuffer.append(rejConn.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(rejConn.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(rejConn.getName());
    stringBuffer.append(TEXT_8);
    
				} // end 8
			} // end 7

			List<IMetadataColumn> inColumns = inMetadata.getListColumns();
			for (IMetadataColumn inColumn : inColumns) { // 9
				if (cnameInputArgs.contains(inColumn.getLabel())) { // 10

    stringBuffer.append(TEXT_9);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_15);
    
				} // end 10
			} // end 9

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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
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
    
			List<IMetadataColumn> outColumns = outMetadata.getListColumns();
			for (IMetadataColumn outColumn : outColumns) { // 11
				if (cnameOutputArgs.contains(outColumn.getLabel())) { // 12
					if (outColumn.getLabel().equals("OUT_RES_CNAME_CL")) { // 13

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
					} else {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(outColumn.getLabel());
    stringBuffer.append(TEXT_47);
    
					} // end 13
				} // end 12
			} // end 11

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
 			// Use reject connection if specified
			if (useRejects) { // 14

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
				List<IMetadataColumn> rejColumns = rejMetadata.getListColumns();
				if (rejConns != null) { // 15
					for (IConnection rejConn : rejConns) { // 16
						for (IMetadataColumn rejColumn : rejColumns) { // 17

    stringBuffer.append(TEXT_83);
    stringBuffer.append(rejConn.getName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(rejColumn.getLabel());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(incomingConn);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(rejColumn.getLabel());
    stringBuffer.append(TEXT_87);
    
						} // end 17
					} // end 16
				} // end 15
	
				if (outConns != null) { // 18
					for (IConnection outConn : outConns) { // 19

    stringBuffer.append(TEXT_88);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_89);
    
					} // end 19
				} // end 18

    stringBuffer.append(TEXT_90);
    
				outColumns = outMetadata.getListColumns();
				for (IConnection outConn : outConns) { // 20
					for (IMetadataColumn outColumn : outColumns) { // 21
						if (cnameOutputArgs.contains(outColumn.getLabel())) { // 22
							if (outColumn.getLabel().equals("OUT_RES_CNAME_CL")) { // 23

    stringBuffer.append(TEXT_91);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(outColumn.getLabel());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
							} else { // no out_res_cname_x_cl argument

    stringBuffer.append(TEXT_95);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(outColumn.getLabel());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(outColumn.getLabel());
    stringBuffer.append(TEXT_99);
    
							} // end 23
						} else { // no Convert-Name-specific column

    stringBuffer.append(TEXT_100);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(outColumn.getLabel());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(incomingConn);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(outColumn.getLabel());
    stringBuffer.append(TEXT_104);
    
						} // end 22
					} // end 21
				} // end 20

				if (rejConns != null) { // 24
					for (IConnection rejConn : rejConns) { // 25

    stringBuffer.append(TEXT_105);
    stringBuffer.append(rejConn.getName());
    stringBuffer.append(TEXT_106);
    
					} // end 25
				} // end 24

    stringBuffer.append(TEXT_107);
    
			} else { // only use output connection
				if (outConns != null) { // 26
					outColumns = outMetadata.getListColumns();
					for (IConnection outConn : outConns) { // 27
						for (IMetadataColumn outColumn : outColumns) { // 28
							if (cnameOutputArgs.contains(outColumn.getLabel())) { // 29
								if (outColumn.getLabel().equals("OUT_RES_CNAME_CL")) { // 30

    stringBuffer.append(TEXT_108);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(outColumn.getLabel());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
								} else {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(outColumn.getLabel());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(outColumn.getLabel());
    stringBuffer.append(TEXT_116);
    
								} // end 30
							} else { // no Convert-Name-specific column

    stringBuffer.append(TEXT_117);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(outColumn.getLabel());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(incomingConn);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(outColumn.getLabel());
    stringBuffer.append(TEXT_121);
    
							} // end 29
						} // end 28
					} // end 27
				} // end 26
			} // end 14
		} // end 3
	} // end 2
} // end 1

    stringBuffer.append(TEXT_122);
    return stringBuffer.toString();
  }
}
