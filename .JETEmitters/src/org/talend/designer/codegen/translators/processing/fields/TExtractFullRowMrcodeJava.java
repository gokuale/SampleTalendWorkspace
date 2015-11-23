package org.talend.designer.codegen.translators.processing.fields;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TExtractFullRowMrcodeJava
{
  protected static String nl;
  public static synchronized TExtractFullRowMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractFullRowMrcodeJava result = new TExtractFullRowMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            for(int i_";
  protected final String TEXT_2 = " = 0; i_";
  protected final String TEXT_3 = "<ptnSplit_";
  protected final String TEXT_4 = ".length; i_";
  protected final String TEXT_5 = "++){" + NL + "                if ((\"*\").equals(ptnSplit_";
  protected final String TEXT_6 = "[i_";
  protected final String TEXT_7 = "])) {" + NL + "                     sizes_";
  protected final String TEXT_8 = "[i_";
  protected final String TEXT_9 = "] = -1;" + NL + "                } else {" + NL + "                     sizes_";
  protected final String TEXT_10 = "[i_";
  protected final String TEXT_11 = "] = Integer.valueOf(ptnSplit_";
  protected final String TEXT_12 = "[i_";
  protected final String TEXT_13 = "]);" + NL + "                }" + NL + "            }";
  protected final String TEXT_14 = NL + "        for(int i_";
  protected final String TEXT_15 = "=0;i_";
  protected final String TEXT_16 = "<indexs_";
  protected final String TEXT_17 = ".length;i_";
  protected final String TEXT_18 = "++){" + NL + "            if(sizes_";
  protected final String TEXT_19 = "[i_";
  protected final String TEXT_20 = "]==-1){" + NL + "                indexs_";
  protected final String TEXT_21 = "[i_";
  protected final String TEXT_22 = "]=-1;" + NL + "            }else{" + NL + "                if(i_";
  protected final String TEXT_23 = "-1>=0){" + NL + "                    indexs_";
  protected final String TEXT_24 = "[i_";
  protected final String TEXT_25 = "]= indexs_";
  protected final String TEXT_26 = "[i_";
  protected final String TEXT_27 = "-1]+sizes_";
  protected final String TEXT_28 = "[i_";
  protected final String TEXT_29 = "];" + NL + "                }else{" + NL + "                    indexs_";
  protected final String TEXT_30 = "[i_";
  protected final String TEXT_31 = "]= sizes_";
  protected final String TEXT_32 = "[i_";
  protected final String TEXT_33 = "];" + NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_34 = NL + "        public void configure(JobConf job_";
  protected final String TEXT_35 = "){" + NL + "            context = new ContextProperties(job_";
  protected final String TEXT_36 = ");" + NL + "            globalMap = new GlobalVar(job_";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "            ";
  protected final String TEXT_39 = " = new ";
  protected final String TEXT_40 = "Struct();";
  protected final String TEXT_41 = NL + "        }";
  protected final String TEXT_42 = NL + "            mos_";
  protected final String TEXT_43 = " = new MultipleOutputs(job_";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL + "            ";
  protected final String TEXT_46 = " = new ";
  protected final String TEXT_47 = "Struct();";
  protected final String TEXT_48 = NL + "                    try {" + NL + "                        FileSystem fs = FileSystem.get(job_";
  protected final String TEXT_49 = ");" + NL + "                        Path path = new Path(" + NL + "                                \"/tmp/";
  protected final String TEXT_50 = "\"" + NL + "                                + \"/tMROutput_";
  protected final String TEXT_51 = "\"" + NL + "                                + \"/";
  protected final String TEXT_52 = "\");" + NL + "                        fs.mkdirs(path);" + NL + "                    } catch (IOException ex_";
  protected final String TEXT_53 = ") {" + NL + "                        throw new RuntimeException(ex_";
  protected final String TEXT_54 = ".getMessage());" + NL + "                    }";
  protected final String TEXT_55 = NL + NL + "            public static class ";
  protected final String TEXT_56 = "_InputMapper extends MapReduceBase " + NL + "                implements Mapper<NullWritable, ";
  protected final String TEXT_57 = "Struct, NullWritable, WritableComparable>{" + NL + "" + NL + "                private ContextProperties context;" + NL + "                private GlobalVar globalMap;" + NL + "                private ";
  protected final String TEXT_58 = "Struct ";
  protected final String TEXT_59 = " = null;";
  protected final String TEXT_60 = NL + "                    public MultipleOutputs mos_";
  protected final String TEXT_61 = ";" + NL + "                    private ";
  protected final String TEXT_62 = "Struct ";
  protected final String TEXT_63 = " = null;";
  protected final String TEXT_64 = NL + NL + NL + "                public void map(NullWritable key_";
  protected final String TEXT_65 = ", ";
  protected final String TEXT_66 = "Struct value_";
  protected final String TEXT_67 = ", " + NL + "                    OutputCollector<NullWritable, WritableComparable> output_";
  protected final String TEXT_68 = ", Reporter reporter_";
  protected final String TEXT_69 = ") throws IOException{" + NL + "                    try {";
  protected final String TEXT_70 = NL + "                            if(value_";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = ".length() > 0){";
  protected final String TEXT_73 = NL + "                                ";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = " = value_";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = ".toString();" + NL + "                            } else {";
  protected final String TEXT_78 = NL + "                                    ";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = " = ";
  protected final String TEXT_81 = ";";
  protected final String TEXT_82 = NL + "                                    throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_83 = "' in '";
  protected final String TEXT_84 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_85 = NL + "                            }";
  protected final String TEXT_86 = NL + "                        output_";
  protected final String TEXT_87 = ".collect(NullWritable.get(),  ";
  protected final String TEXT_88 = ");" + NL + "                    } catch (Exception ex_";
  protected final String TEXT_89 = ") {";
  protected final String TEXT_90 = NL + "                                ";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " = ";
  protected final String TEXT_93 = ".";
  protected final String TEXT_94 = ";";
  protected final String TEXT_95 = NL + "                                    ";
  protected final String TEXT_96 = ".inputLine = value_";
  protected final String TEXT_97 = ".";
  protected final String TEXT_98 = ".toString();";
  protected final String TEXT_99 = NL + "                            ";
  protected final String TEXT_100 = ".errorMessage = ex_";
  protected final String TEXT_101 = ".toString();" + NL + "                            mos_";
  protected final String TEXT_102 = ".getCollector(\"";
  protected final String TEXT_103 = "\", reporter_";
  protected final String TEXT_104 = ")" + NL + "                                .collect(NullWritable.get(), ";
  protected final String TEXT_105 = ");";
  protected final String TEXT_106 = NL + "                                throw new  java.io.IOException(ex_";
  protected final String TEXT_107 = ".getMessage());";
  protected final String TEXT_108 = NL + "                                System.out.println(ex_";
  protected final String TEXT_109 = ".toString());";
  protected final String TEXT_110 = NL + "                    }" + NL + "                }" + NL;
  protected final String TEXT_111 = NL + "                    public void close() throws IOException{" + NL + "                        mos_";
  protected final String TEXT_112 = ".close();" + NL + "                    }";
  protected final String TEXT_113 = NL + "            } // end of ";
  protected final String TEXT_114 = "_InputMapper" + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
class MultiouputMrCodeUtils{

    private INode node;
    private String cid;
    private String mainConnectionName;
    private boolean hasRejectedConnection;
    private String rejectedConnectionName;

    public MultiouputMrCodeUtils(INode node) {
        this.node = node;
        this.cid = node.getUniqueName();

        List< ? extends IConnection> mainConnections = node.getOutgoingConnections("FLOW");
        if ((mainConnections.size() > 0)  && (mainConnections.get(0) != null)) {
            this.mainConnectionName = mainConnections.get(0).getName();
        }

        List<? extends IConnection> rejectedConnections = node.getOutgoingConnections("REJECT");
        if ((rejectedConnections != null)  && (rejectedConnections.size() == 1)){
            this.hasRejectedConnection = true;
            this.rejectedConnectionName = rejectedConnections.get(0).getName();
        } else {
            this.hasRejectedConnection = false;
            this.rejectedConnectionName = "";
        }
    }

    /**
     * Write down a generic configure function for MapReduce Job.
     * 
     */
    public void writeConfigure(String shortCid) {
        writeHeader();
        writeReject(shortCid);
        writeFooter();
    }
    /**
     * Write down a configure function for tExtractFosutionFields.
     * 
     */
    public void writePositionnalConfigure(String shortCid, boolean advancedInputFormat) {
        writeHeader();
        writeReject(shortCid);

        if (!advancedInputFormat) {
            
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
        }
        
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
    
        writeFooter();
    }

    private void writeHeader() {
        
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_40);
    
    }

    private void writeFooter() {
            
    stringBuffer.append(TEXT_41);
    
    }

    private void writeReject(String shortCid) {
        if (hasRejectedConnection){
            
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_47);
    
            // Force the creation of the output directory
            for (INode virtualNode : node.getProcess().getGraphicalNodes()) {
                if (virtualNode.getUniqueName().equals(shortCid)) {
                    
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(node.getProcess().getName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(virtualNode.getUniqueName());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(virtualNode.getOutgoingConnections("REJECT").get(0).getName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
                    break;
                }
            }
        }
    }
}

    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;

INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

MultiouputMrCodeUtils multiOutputMrCodeUtils = new MultiouputMrCodeUtils(node);

List< ? extends IConnection> inConnections = node.getIncomingConnections();
List< ? extends IConnection> mainConnections = node.getOutgoingConnections("FLOW");
if ((inConnections.size() > 0) && (inConnections.get(0) != null)
        && (mainConnections.size() > 0)  && (mainConnections.get(0) != null)) {

    IConnection incomingConnection = inConnections.get(0);
    String incomingConnectionName = incomingConnection.getName();
    IMetadataTable inputMetadataTable = incomingConnection.getMetadataTable();

    IConnection mainConnection = mainConnections.get(0);
    String mainConnectionName = mainConnection.getName();
    IMetadataTable mainMetadata = mainConnection.getMetadataTable();


    if ((mainMetadata != null) && (mainMetadata.getListColumns() != null) && (mainMetadata.getListColumns().size() > 0)
           && (inputMetadataTable != null) && (inputMetadataTable.getListColumns() != null) && (inputMetadataTable.getListColumns().size() > 0)) {
        boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

        List<? extends IConnection> rejectedConnections = node.getOutgoingConnections("REJECT");
        String rejectedConnectionName = "";
        if ((rejectedConnections != null)  && (rejectedConnections.size() == 1)){
            IConnection rejectedConnection = rejectedConnections.get(0);
            rejectedConnectionName =  rejectedConnection.getName();
        }


        if (mainConnection.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            List<IMetadataColumn> columns = mainMetadata.getListColumns();
            int nbColumns = columns.size();
            
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(incomingConnectionName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_59);
    
                if ((rejectedConnections != null)  && (rejectedConnections.size() == 1)){
                    
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_63);
    
                }

                String shortCid = cid.replaceAll("_ExtractFullRow", "");
                multiOutputMrCodeUtils.writeConfigure(shortCid);
                
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(incomingConnectionName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
                        for ( int i = 0; i < nbColumns; i++ ){
                            IMetadataColumn column = columns.get(i);
                            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                            String columnName = column.getLabel();
                            String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
                            
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(inputMetadataTable.getListColumns().get(0));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(inputMetadataTable.getListColumns().get(0));
    stringBuffer.append(TEXT_77);
    
                                if(defaultValue != null && defaultValue.length() > 0) {
                                    
    stringBuffer.append(TEXT_78);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_81);
    
                                } else {
                                    
    stringBuffer.append(TEXT_82);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_84);
    
                                }
                                
    stringBuffer.append(TEXT_85);
    
                        }
                        
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
                        if ((rejectedConnections != null)  && (rejectedConnections.size() == 1)){
                            // set the parsed column
                            for ( int i = 0; i < nbColumns; i++ ){
                                String columnName = columns.get(i).getLabel();
                                
    stringBuffer.append(TEXT_90);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_94);
    
                            }

                            // set the rejected input line
                            // This field does not exist if the job is imported by DI job
                            IMetadataTable rejectedMedata = rejectedConnections.get(0).getMetadataTable();
                            List<IMetadataColumn> rejectedColumns = rejectedMedata.getListColumns();
                            for (IMetadataColumn rejectedColumn: rejectedColumns) {
                                if (rejectedColumn.getLabel().equals("inputLine")) {
                                    
    stringBuffer.append(TEXT_95);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(inputMetadataTable.getListColumns().get(0));
    stringBuffer.append(TEXT_98);
    
                                }
                            }
                            
    stringBuffer.append(TEXT_99);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_105);
    
                        } else {
                            if (dieOnError) {
                                
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
                            } else {
                                
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
                            }
                        }
                        
    stringBuffer.append(TEXT_110);
    
                if ((rejectedConnections != null)  && (rejectedConnections.size() == 1)){
                    
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
                }
                
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
        }
    }
}

    return stringBuffer.toString();
  }
}
