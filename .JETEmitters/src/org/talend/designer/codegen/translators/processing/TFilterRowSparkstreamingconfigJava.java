package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;
import org.talend.designer.common.tfilterrow.TFilterRowUtil;

public class TFilterRowSparkstreamingconfigJava
{
  protected static String nl;
  public static synchronized TFilterRowSparkstreamingconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFilterRowSparkstreamingconfigJava result = new TFilterRowSparkstreamingconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "   ";
  protected final String TEXT_2 = "<NullWritable, ";
  protected final String TEXT_3 = "> rdd_";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL + "   ";
  protected final String TEXT_6 = "<NullWritable, ";
  protected final String TEXT_7 = "> rdd_";
  protected final String TEXT_8 = ";";
  protected final String TEXT_9 = NL + "\t// Set up a Spark DataFlow with all of the necessary inputs to use this component." + NL + "\t";
  protected final String TEXT_10 = " ";
  protected final String TEXT_11 = " = new ";
  protected final String TEXT_12 = ".Builder()" + NL + "\t            .";
  protected final String TEXT_13 = "(ctx)" + NL + "\t            .build();" + NL + "\t";
  protected final String TEXT_14 = " ";
  protected final String TEXT_15 = " = new ";
  protected final String TEXT_16 = "(";
  protected final String TEXT_17 = ");" + NL + "\t";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = "(\"";
  protected final String TEXT_20 = "\", rdd_";
  protected final String TEXT_21 = ");" + NL + "" + NL + "\tFilter_";
  protected final String TEXT_22 = "_";
  protected final String TEXT_23 = " filter_";
  protected final String TEXT_24 = "_";
  protected final String TEXT_25 = " = new Filter_";
  protected final String TEXT_26 = "_";
  protected final String TEXT_27 = "(job);" + NL + "\torg.talend.bigdata.dataflow.hmap.HMap ";
  protected final String TEXT_28 = " = new org.talend.bigdata.dataflow.hmap.HMap();" + NL + "\torg.talend.bigdata.dataflow.hmap.HMapSpecBuilder ";
  protected final String TEXT_29 = "_hsb = ";
  protected final String TEXT_30 = ".createSpecBuilder();" + NL + "" + NL + "\t";
  protected final String TEXT_31 = "_hsb.declareInput(\"";
  protected final String TEXT_32 = "\", ";
  protected final String TEXT_33 = ".getClassSchema());";
  protected final String TEXT_34 = NL + "\t";
  protected final String TEXT_35 = "_hsb.declareOutput(\"";
  protected final String TEXT_36 = "\", ";
  protected final String TEXT_37 = ".getClassSchema());" + NL + "\t";
  protected final String TEXT_38 = "_hsb.filter(\"";
  protected final String TEXT_39 = "\", filter_";
  protected final String TEXT_40 = "_";
  protected final String TEXT_41 = ");" + NL + "\t";
  protected final String TEXT_42 = "_hsb.mapAll(\"";
  protected final String TEXT_43 = "\", \"";
  protected final String TEXT_44 = "\");";
  protected final String TEXT_45 = NL + "\t";
  protected final String TEXT_46 = "_hsb.declareOutput(\"";
  protected final String TEXT_47 = "_DummyOutput\", ";
  protected final String TEXT_48 = ".getClassSchema());" + NL + "\t";
  protected final String TEXT_49 = "_hsb.filter(\"";
  protected final String TEXT_50 = "_DummyOutput\", filter_";
  protected final String TEXT_51 = "_";
  protected final String TEXT_52 = ");" + NL + "\t";
  protected final String TEXT_53 = "_hsb.mapAll(\"";
  protected final String TEXT_54 = "\", \"";
  protected final String TEXT_55 = "_DummyOutput\");";
  protected final String TEXT_56 = NL + "\t";
  protected final String TEXT_57 = "_hsb.declareOutput(\"";
  protected final String TEXT_58 = "\", ";
  protected final String TEXT_59 = ".getClassSchema(), org.talend.bigdata.dataflow.hmap.HMapSpec.OutputType.REJECT_FILTERS);" + NL + "\t";
  protected final String TEXT_60 = "_hsb.postProcess(\"";
  protected final String TEXT_61 = "\", filter_";
  protected final String TEXT_62 = "_";
  protected final String TEXT_63 = ");" + NL + "\t";
  protected final String TEXT_64 = "_hsb.mapAll(\"";
  protected final String TEXT_65 = "\", \"";
  protected final String TEXT_66 = "\");";
  protected final String TEXT_67 = NL + NL + "\t// Build the tMap spec and use that to build into the dataflow." + NL + "\torg.talend.bigdata.dataflow.hmap.HMapSpec ";
  protected final String TEXT_68 = "_hs = ";
  protected final String TEXT_69 = "_hsb.build();" + NL + "\t";
  protected final String TEXT_70 = "_hmap.createDataFlowBuilder(";
  protected final String TEXT_71 = "_hs).build(";
  protected final String TEXT_72 = "_sdf);" + NL;
  protected final String TEXT_73 = NL + "\trdd_";
  protected final String TEXT_74 = " = ";
  protected final String TEXT_75 = "_sdf.";
  protected final String TEXT_76 = "(\"";
  protected final String TEXT_77 = "\");";
  protected final String TEXT_78 = NL + "\trdd_";
  protected final String TEXT_79 = " = ";
  protected final String TEXT_80 = "_sdf.";
  protected final String TEXT_81 = "(\"";
  protected final String TEXT_82 = "\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String sdfContextName = cid + "_sdfContext";
String sdfName = cid + "_sdf";
String hmapName = cid + "_hmap";
String hsbName = cid + "_hsb";
String hsName = cid + "_hs";

final TFilterRowUtil tFilterRowUtil = new TFilterRowUtil(node);
String sparkDatasetClassName = tFilterRowUtil.getSparkDatasetClassName();
String sparkDataFlowContextName = tFilterRowUtil.getSparkDataFlowContextName();
String sparkWithContextMethodName = tFilterRowUtil.getSparkWithContextMethodName();
String sparkDataFlowName = tFilterRowUtil.getSparkDataFlowName();
String sparkAddDatasetMethodName = tFilterRowUtil.getSparkAddDatasetMethodName();
String sparkGetDatasetMethodName = tFilterRowUtil.getSparkGetDatasetMethodName();

String inStructName = codeGenArgument.getRecordStructName(tFilterRowUtil.getIncomingConnection());
String filterStructName = codeGenArgument.getRecordStructName(tFilterRowUtil.getFilterConnection());
String rejectStructName = codeGenArgument.getRecordStructName(tFilterRowUtil.getRejectConnection());

	// For every output connection, an output RDD needs to be created in this context.
	if(tFilterRowUtil.getFilterConnection() != null) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(sparkDatasetClassName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(filterStructName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(tFilterRowUtil.getFilterConnection().getName());
    stringBuffer.append(TEXT_4);
    
	} // end if
	if(tFilterRowUtil.getRejectConnection() != null) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(sparkDatasetClassName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(rejectStructName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(tFilterRowUtil.getRejectConnection().getName());
    stringBuffer.append(TEXT_8);
    
	} // end if

    stringBuffer.append(TEXT_9);
    stringBuffer.append(sparkDataFlowContextName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(sdfContextName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(sparkDataFlowContextName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(sparkWithContextMethodName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(sparkDataFlowName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(sdfName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(sparkDataFlowName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(sdfContextName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(sdfName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(sparkAddDatasetMethodName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(tFilterRowUtil.getIncomingConnection().getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(tFilterRowUtil.getIncomingConnection().getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(tFilterRowUtil.getIncomingConnection().getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(tFilterRowUtil.getIncomingConnection().getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(tFilterRowUtil.getIncomingConnection().getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(hmapName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(hmapName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(tFilterRowUtil.getIncomingConnection().getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_33);
    
    if (tFilterRowUtil.getFilterConnection() != null) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(tFilterRowUtil.getFilterConnection().getName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(filterStructName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(tFilterRowUtil.getFilterConnection().getName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(tFilterRowUtil.getIncomingConnection().getName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(tFilterRowUtil.getIncomingConnection().getName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(tFilterRowUtil.getFilterConnection().getName());
    stringBuffer.append(TEXT_44);
    
	} else {
	// We must declare an output to be compliant with talend-dataflow-spark

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(inStructName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(tFilterRowUtil.getIncomingConnection().getName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(tFilterRowUtil.getIncomingConnection().getName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
	} // end else

   if (tFilterRowUtil.getRejectConnection() != null) {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(tFilterRowUtil.getRejectConnection().getName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(rejectStructName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(tFilterRowUtil.getRejectConnection().getName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(tFilterRowUtil.getIncomingConnection().getName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(tFilterRowUtil.getIncomingConnection().getName());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(tFilterRowUtil.getRejectConnection().getName());
    stringBuffer.append(TEXT_66);
    
 	 } // end if

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
    
	// For every output connection, initialize the output RDD.
	if(tFilterRowUtil.getFilterConnection() != null) {

    stringBuffer.append(TEXT_73);
    stringBuffer.append(tFilterRowUtil.getFilterConnection().getName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(sparkGetDatasetMethodName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(tFilterRowUtil.getFilterConnection().getName());
    stringBuffer.append(TEXT_77);
    
	} // end if
	if(tFilterRowUtil.getRejectConnection() != null) {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(tFilterRowUtil.getRejectConnection().getName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(sparkGetDatasetMethodName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(tFilterRowUtil.getRejectConnection().getName());
    stringBuffer.append(TEXT_82);
    
	} // end if

    return stringBuffer.toString();
  }
}
