package org.talend.designer.codegen.translators.mapreduce.output;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.core.utils.TalendQuoteUtils;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TFileOutputXMLMrcodeJava
{
  protected static String nl;
  public static synchronized TFileOutputXMLMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputXMLMrcodeJava result = new TFileOutputXMLMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + NL + "/** This function needs the following dependecies" + NL + " * \"@{org.talend.designer.components.mrprovider}components/tFileOutputXML/tFileOutputXML_XMLTag.javajet\"%>" + NL + " */" + NL;
  protected final String TEXT_5 = NL + "                FormatterUtils.format_Number(value.";
  protected final String TEXT_6 = " == null ? \"\" : String.valueOf(";
  protected final String TEXT_7 = "), ";
  protected final String TEXT_8 = ", ";
  protected final String TEXT_9 = ")";
  protected final String TEXT_10 = NL + "                FormatterUtils.format_Number(value.";
  protected final String TEXT_11 = " == null ? \"\" : String.valueOf(value.";
  protected final String TEXT_12 = "), ";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = ")";
  protected final String TEXT_15 = NL + "            value.";
  protected final String TEXT_16 = NL + "            ((value.";
  protected final String TEXT_17 = " == null)?\"\":(";
  protected final String TEXT_18 = NL + "                    ";
  protected final String TEXT_19 = "(" + NL + "                            FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_20 = ", ";
  protected final String TEXT_21 = "))";
  protected final String TEXT_22 = NL + "                    FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = ")";
  protected final String TEXT_25 = NL + "                ";
  protected final String TEXT_26 = "(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(value.";
  protected final String TEXT_27 = ")).toString())";
  protected final String TEXT_28 = NL + "                ";
  protected final String TEXT_29 = "(String.valueOf(";
  protected final String TEXT_30 = "))";
  protected final String TEXT_31 = NL + "                    ";
  protected final String TEXT_32 = "(value.";
  protected final String TEXT_33 = ")";
  protected final String TEXT_34 = NL + "                    value.";
  protected final String TEXT_35 = NL + "            ))";
  protected final String TEXT_36 = NL;
  protected final String TEXT_37 = NL + "        List<String> headers_";
  protected final String TEXT_38 = " = new java.util.ArrayList<String>();" + NL + "" + NL + "        headers_";
  protected final String TEXT_39 = ".add(\"<?xml version=\\\"1.0\\\" encoding=\\\"\" + ";
  protected final String TEXT_40 = " + \"\\\"?>\");" + NL;
  protected final String TEXT_41 = NL + "                headers_";
  protected final String TEXT_42 = ".add(\"<\"+";
  protected final String TEXT_43 = "+\">\");";
  protected final String TEXT_44 = NL + "        String tempSt_";
  protected final String TEXT_45 = " = null;" + NL + "" + NL + "        boolean flag_";
  protected final String TEXT_46 = " = true;" + NL + "" + NL + "        String[][] groupby_";
  protected final String TEXT_47 = " = new String[";
  protected final String TEXT_48 = "][2];" + NL + "" + NL + "        int groupby_new_";
  protected final String TEXT_49 = " = 0;" + NL + "" + NL + "        boolean start_";
  protected final String TEXT_50 = " = false;";
  protected final String TEXT_51 = NL + "                groupby_";
  protected final String TEXT_52 = "[";
  protected final String TEXT_53 = "][0] = \"\";" + NL + "             groupby_";
  protected final String TEXT_54 = "[";
  protected final String TEXT_55 = "][1] = \"</\" + ";
  protected final String TEXT_56 = " + \">\";";
  protected final String TEXT_57 = NL + "        flag_";
  protected final String TEXT_58 = " = true;";
  protected final String TEXT_59 = NL + "            tempSt_";
  protected final String TEXT_60 = " = \"<\" + ";
  protected final String TEXT_61 = " + \" \" + ";
  protected final String TEXT_62 = " + \"=\\\"\"" + NL + "                + ";
  protected final String TEXT_63 = NL + "                + \"\\\">\";" + NL + "            if(!groupby_";
  protected final String TEXT_64 = "[";
  protected final String TEXT_65 = "][0].equals(tempSt_";
  protected final String TEXT_66 = ")){" + NL + "                if(flag_";
  protected final String TEXT_67 = "){" + NL + "                    groupby_new_";
  protected final String TEXT_68 = " = ";
  protected final String TEXT_69 = ";" + NL + "                    flag_";
  protected final String TEXT_70 = " = false;" + NL + "                 for(int i_";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = "; i_";
  protected final String TEXT_73 = " >= groupby_new_";
  protected final String TEXT_74 = " && start_";
  protected final String TEXT_75 = "; i_";
  protected final String TEXT_76 = "--){" + NL + "                     sb_";
  protected final String TEXT_77 = ".append(groupby_";
  protected final String TEXT_78 = "[i_";
  protected final String TEXT_79 = "][1]);" + NL + "                     sb_";
  protected final String TEXT_80 = ".append(System.getProperty(\"line.separator\"));" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                groupby_";
  protected final String TEXT_81 = "[";
  protected final String TEXT_82 = "][0] = tempSt_";
  protected final String TEXT_83 = ";" + NL + "                sb_";
  protected final String TEXT_84 = ".append(tempSt_";
  protected final String TEXT_85 = ");" + NL + "                sb_";
  protected final String TEXT_86 = ".append(System.getProperty(\"line.separator\"));" + NL + "                if(!start_";
  protected final String TEXT_87 = "){" + NL + "                    start_";
  protected final String TEXT_88 = " = true;" + NL + "                }" + NL + "            }else if(!flag_";
  protected final String TEXT_89 = "){" + NL + "                sb_";
  protected final String TEXT_90 = ".append(tempSt_";
  protected final String TEXT_91 = ");" + NL + "                sb_";
  protected final String TEXT_92 = ".append(System.getProperty(\"line.separator\"));" + NL + "                if(!start_";
  protected final String TEXT_93 = "){" + NL + "                    start_";
  protected final String TEXT_94 = " = true;" + NL + "                }" + NL + "            }";
  protected final String TEXT_95 = NL + "        sb_";
  protected final String TEXT_96 = ".append(\"<\"+";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "            sb_";
  protected final String TEXT_99 = ".append(\" \" + ";
  protected final String TEXT_100 = " + \"=\\\"\"" + NL + "                                    + ";
  protected final String TEXT_101 = NL + "                                    + \"\\\"\");";
  protected final String TEXT_102 = NL + "            sb_";
  protected final String TEXT_103 = ".append(\">\");";
  protected final String TEXT_104 = NL + "            sb_";
  protected final String TEXT_105 = ".append(\"/>\");";
  protected final String TEXT_106 = NL + "        sb_";
  protected final String TEXT_107 = ".append(System.getProperty(\"line.separator\"));";
  protected final String TEXT_108 = NL + "            sb_";
  protected final String TEXT_109 = ".append(\"<\" + ";
  protected final String TEXT_110 = " + \">\"" + NL + "                                + ";
  protected final String TEXT_111 = NL + "                                + \"</\" + ";
  protected final String TEXT_112 = " + \">\");" + NL + "" + NL + "            sb_";
  protected final String TEXT_113 = ".append(System.getProperty(\"line.separator\"));";
  protected final String TEXT_114 = NL + "\t\t\t    sb_";
  protected final String TEXT_115 = ".append(\"</\"+";
  protected final String TEXT_116 = "+\">\");" + NL + "\t\t\t    ";
  protected final String TEXT_117 = NL;
  protected final String TEXT_118 = NL + NL + "        public static class ";
  protected final String TEXT_119 = "StructOutputFormat extends FileOutputFormat<NullWritable, ";
  protected final String TEXT_120 = "> {" + NL + "" + NL + "            private ContextProperties context;" + NL + "" + NL + "            protected static class HDFSRecordWriter implements RecordWriter<NullWritable, ";
  protected final String TEXT_121 = "> {" + NL + "        \t\tprotected DataOutputStream out;" + NL + "                private ContextProperties context;" + NL + "" + NL + "                private Boolean hasProcessedData = false;" + NL + "" + NL + "        \t\t";
  protected final String TEXT_122 = NL + NL + "        \t\tpublic HDFSRecordWriter(DataOutputStream out, JobConf job) {" + NL + "        \t\t\tthis.out = out;" + NL + "        \t\t\tthis.context = new ContextProperties(job);" + NL + "" + NL + "        \t\t\t";
  protected final String TEXT_123 = NL + "        \t\t}" + NL + "" + NL + "        \t\tprivate void writeObject(";
  protected final String TEXT_124 = " value) throws IOException {" + NL + "        \t\t    hasProcessedData = true;" + NL + "                    StringBuilder sb_";
  protected final String TEXT_125 = " = new StringBuilder();" + NL + "        \t\t\t";
  protected final String TEXT_126 = NL + "        \t\t\tthis.out.write(sb_";
  protected final String TEXT_127 = ".toString().getBytes(";
  protected final String TEXT_128 = "));" + NL + "        \t\t} // writeObject" + NL + "" + NL + "        \t\tpublic synchronized void write(NullWritable key, ";
  protected final String TEXT_129 = " value)" + NL + "        \t\t\t\tthrows IOException {" + NL + "" + NL + "        \t\t\tboolean nullValue = value == null;" + NL + "        \t\t\tif (nullValue) {" + NL + "        \t\t\t\treturn;" + NL + "        \t\t\t} else {" + NL + "        \t\t\t\twriteObject(value);" + NL + "        \t\t\t}" + NL + "        \t\t}" + NL + "" + NL + "        \t\tpublic synchronized void close(Reporter reporter) throws IOException {" + NL + "        \t\t    if (hasProcessedData) {" + NL + "            \t\t    ";
  protected final String TEXT_130 = NL + "            \t\t        out.write((\"</\" + ";
  protected final String TEXT_131 = " + \">\").getBytes(";
  protected final String TEXT_132 = "));" + NL + "                            out.write(System.getProperty(\"line.separator\").getBytes(";
  protected final String TEXT_133 = "));" + NL + "            \t\t        ";
  protected final String TEXT_134 = NL + "        \t\t    }" + NL + "        \t\t    ";
  protected final String TEXT_135 = NL + "        \t\t            out.write((\"</\" + ";
  protected final String TEXT_136 = " + \">\").getBytes(";
  protected final String TEXT_137 = "));" + NL + "        \t\t            out.write(System.getProperty(\"line.separator\").getBytes(";
  protected final String TEXT_138 = "));" + NL + "        \t\t            ";
  protected final String TEXT_139 = NL + "        \t\t\tout.close();" + NL + "        \t\t}" + NL + "        \t} // HDFS RecordReader" + NL + "" + NL + "        \tpublic RecordWriter<NullWritable, ";
  protected final String TEXT_140 = "> getRecordWriter(" + NL + "        \t\t\tFileSystem ignored, JobConf job, String name, Progressable progress) throws IOException{" + NL + "                    this.context = new ContextProperties(job);" + NL + "        \t\t";
  protected final String TEXT_141 = NL + "        \t\t\tPath file = FileOutputFormat.getTaskOutputPath(job, name);" + NL + "        \t\t\tFileSystem fs = file.getFileSystem(job);" + NL + "        \t\t\tDataOutputStream fileOut = fs.create(file, progress);" + NL + "        \t\t\t";
  protected final String TEXT_142 = NL + "        \t\t\t\tCompressionCodec codec = ReflectionUtils.newInstance(org.apache.hadoop.io.compress.GzipCodec.class," + NL + "        \t\t\t\t\t\tjob);" + NL + "        \t\t\t\t";
  protected final String TEXT_143 = NL + "        \t\t\t\tCompressionCodec codec = ReflectionUtils.newInstance(org.apache.hadoop.io.compress.BZip2Codec.class," + NL + "        \t\t\t\t\t\tjob);" + NL + "        \t\t\t\t";
  protected final String TEXT_144 = NL + "        \t\t\t// build the filename including the extension" + NL + "        \t\t\tPath file = FileOutputFormat.getTaskOutputPath(job," + NL + "        \t\t\t\t\tname + codec.getDefaultExtension());" + NL + "        \t\t\tFileSystem fs = file.getFileSystem(job);" + NL + "        \t\t\tDataOutputStream fileOut = new DataOutputStream(" + NL + "        \t\t\t\t\tcodec.createOutputStream(fs.create(file, progress)));" + NL + "        \t\t\t";
  protected final String TEXT_145 = NL + "                     fileOut.write(headers_";
  protected final String TEXT_146 = ".get(";
  protected final String TEXT_147 = ").getBytes(";
  protected final String TEXT_148 = "));" + NL + "                     fileOut.write(System.getProperty(\"line.separator\").getBytes(";
  protected final String TEXT_149 = "));";
  protected final String TEXT_150 = NL + "\t\t\t\treturn new HDFSRecordWriter(fileOut, job);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    
/**
 * XML is an utilitary fonction used by TFileOuputXMLUtil, which allow to save datas of a XML tag
 */
class XMLTag {
    /** 
     * The raw name of the column. This will be used to link the data of the XML to the input of the user
     */
    private String columnName;

    /** 
     * The label displayed in the generated java code.
     * 
     * Display Example:
     * <labe>"value"</label>
     */
    private String label;

    /** 
     * If the XMLTag is a "GroupBy" field, the tag need to carry a Label Name.
     * 
     * Display Example:
     * <labelName label="value">
     * </labelName>
     */
    private String labelName;

    public XMLTag(String columnName, String label) {
        this.columnName = columnName;
        this.label = label;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
    public String getColumnName() {
        return this.columnName;
    }

    public String getLabel() {
        return this.label;
    }
    public String getLabelName() {
        return this.labelName;
    }
}

    stringBuffer.append(TEXT_4);
    
/**
 * This utilitary class generate the code to process a field of the input data. It will hide the complexity of handeling the type of the data
 */
class TypeExtractor {
    private String thousandsSeparator;

    private String decimalSeparator;

    private boolean needReplace = false;

    private boolean isDate = false;

    private boolean isByteArray = false;

    private String pattern = null;

    private boolean isPrimitive = false;

    private boolean isBigDecimal = false;

    private boolean isAdvancedSeparator = false;

    private Integer precision = null;

    private XMLTag xmlTag;

    /**
     * For a given xmlTag, we are going to extract a columnName from metadata and preprocess all the information about it.
     */
    public TypeExtractor(IMetadataTable metadata, XMLTag xmlTag, boolean advancedSeparator, String thousandsSeparator, String decimalSeparator) {
        this.xmlTag = xmlTag;
        this.decimalSeparator = decimalSeparator;
        this.thousandsSeparator = thousandsSeparator;
        for(IMetadataColumn column: metadata.getListColumns()) {
            if(column.getLabel().equals(xmlTag.getColumnName())){
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.STRING){
                    needReplace = true;
                }
                if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.DATE){
                    pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                    if(pattern != null && (pattern.contains("&") || pattern.contains("<") || pattern.contains(">") || pattern.contains("'") || pattern.contains("\""))){
                        needReplace = true;
                    }
                    isDate = true;
                }
                if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BYTE_ARRAY){
                    isByteArray = true;
                }else if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BIGDECIMAL){
                    isBigDecimal = true;
                }
                isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
                isAdvancedSeparator = advancedSeparator && JavaTypesManager.isNumberType(javaType);
                precision = column.getPrecision();
                break;
            }
        }
    }

    /**
     * Write down the generated code of the data processed in the constructor. 
     * 
     * @param CheckCData generate code with the fonction "TalendString.checkCDATAForXML".
     */
    public void writeField(boolean checkCData)
    {
        String xmlCheckingFonction = "TalendString.replaceSpecialCharForXML";
        if (checkCData) {
            xmlCheckingFonction = "TalendString.checkCDATAForXML";
        }

        if (isAdvancedSeparator){
            if(isBigDecimal){
                
    stringBuffer.append(TEXT_5);
    stringBuffer.append(xmlTag.getColumnName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(precision == null ? "value." + xmlTag.getColumnName() : "value." + xmlTag.getColumnName() + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_9);
    
            } else {
                
    stringBuffer.append(TEXT_10);
    stringBuffer.append(xmlTag.getColumnName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(xmlTag.getColumnName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_14);
    
            }
        } else if(isPrimitive) {
            
    stringBuffer.append(TEXT_15);
    stringBuffer.append(xmlTag.getColumnName());
    
        } else {
            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(xmlTag.getColumnName());
    stringBuffer.append(TEXT_17);
    
            if (isDate && pattern != null){
                if (needReplace) { 
                    
    stringBuffer.append(TEXT_18);
    stringBuffer.append(xmlCheckingFonction);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(xmlTag.getColumnName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_21);
    
                } else {
                    
    stringBuffer.append(TEXT_22);
    stringBuffer.append(xmlTag.getColumnName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_24);
    
                }
            } else if(isByteArray){
                
    stringBuffer.append(TEXT_25);
    stringBuffer.append(xmlCheckingFonction);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(xmlTag.getColumnName());
    stringBuffer.append(TEXT_27);
    
            } else if(isBigDecimal){
                
    stringBuffer.append(TEXT_28);
    stringBuffer.append(xmlCheckingFonction);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(precision == null? "value." + xmlTag.getColumnName() : "value." + xmlTag.getColumnName() + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_30);
    
            } else{
                if (needReplace) {
                    
    stringBuffer.append(TEXT_31);
    stringBuffer.append(xmlCheckingFonction);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(xmlTag.getColumnName());
    stringBuffer.append(TEXT_33);
    
                } else {
                    
    stringBuffer.append(TEXT_34);
    stringBuffer.append(xmlTag.getColumnName());
    
                }
            }
            
    stringBuffer.append(TEXT_35);
    
        }
    }

}


    stringBuffer.append(TEXT_36);
    

/**
 * Contains common processing for tFileOutputXML code generation. This is used in MapReduce components.
 */
class TFileOuputXMLUtil {

    private INode node;

    private boolean advancedSeparator;

    private String thousandsSeparator;

    private String decimalSeparator;

    public TFileOuputXMLUtil (INode node) {
        this.node = node;
        String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
        this.advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
        this.thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
        this.decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
    }

    /**
     * Extract the rootTags data from the node and formate them. 
     */
    public List<Map<String, String>> getRootTag() {
        List<Map<String, String>> rootTags = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT_TAGS__");
        if (rootTags == null) {
            Map<String, String> defaultRootNode = new java.util.HashMap<String, String>();
            defaultRootNode.put("TAG","\"root\"");
            rootTags.add(defaultRootNode);
        }
        return rootTags;
    }

    /**
     * Extract the GroupBy data from the node and formate them as XMLTag
     */
    public List<XMLTag> getGroupByFields(IMetadataTable metadata) {
        String useDynamicGrouping = ElementParameterParser.getValue(node, "__USE_DYNAMIC_GROUPING__");
        if (("false").equals(useDynamicGrouping)) {
         return new java.util.ArrayList<XMLTag>();
        }

        List<Map<String, String>> columnMapping = 
                (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING__");

        // get the groupBy fields
        List<Map<String, String>> groupByTable =
                (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP_BY__");

        List<XMLTag>  groupByElements = new java.util.ArrayList<XMLTag>();
        for(int i = 0; i < groupByTable.size(); i++){
            XMLTag xmlTag = new XMLTag(groupByTable.get(i).get("COLUMN"), groupByTable.get(i).get("LABEL"));
         			groupByElements.add(xmlTag);
        }

        // Parse the columnMapping to get the label of the field.
        for (int i = 0; i < columnMapping.size(); i++) {
            Map<String, String> map = columnMapping.get(i);
            String col = metadata.getListColumns().get(i).getLabel();
            for (XMLTag xmlTag: groupByElements) {
                if (xmlTag.getColumnName().equals(col)) {
                    if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
                        xmlTag.setLabelName(TalendQuoteUtils.addQuotes(col));
                    }else{
                        xmlTag.setLabelName(map.get("LABEL"));
                    }
                    break;
                }
            }
        }

        return groupByElements;
    }


    /**
     * Extract the Attributes and Tags datas from the node and formate them as XMLTag
     *
     * @param attributes An empty but declared List of XMLTag, which we are going to fill with the attributes
     *
     * @param tags An empty but declared List of XMLTag, which we are going to fill with the tags
     *
     * @param groupByElements The list of GroupBy elements
     *
     * @param metadata General metadata of the component
     *
     * @return void the data are put on the input variables tags and attributes
     */
    public void getAttributeAndTags(List<XMLTag> attributes, List<XMLTag> tags, List<XMLTag> groupByElements,
             IMetadataTable metadata) {
        if (attributes == null || tags == null) {
            return;
        }
        List<Map<String, String>> columnMapping = 
             (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING__");
        outter2:
            for(int i = 0; i < columnMapping.size(); i++){
                Map<String, String> map = columnMapping.get(i);
                String col = metadata.getListColumns().get(i).getLabel();
                // the column is groupBy must not be processed.
                for(int j = 0; j < groupByElements.size(); j++){
                    if(groupByElements.get(j).getColumnName().equals(col)){
                        continue outter2;
                    }
                }

                if (("true").equals(map.get("AS_ATTRIBUTE"))) {
                    if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
                        XMLTag attribute = new XMLTag(col, TalendQuoteUtils.addQuotes(col));
                        attributes.add(attribute);
                    }else{
                        XMLTag attribute = new XMLTag(col, map.get("LABEL"));
                        attributes.add(attribute);
                    }
                } else {
                    if(("true").equals(map.get("SCHEMA_COLUMN_NAME"))){
                        XMLTag attribute = new XMLTag(col, TalendQuoteUtils.addQuotes(col));
                        tags.add(attribute);
                    }else{
                        XMLTag attribute = new XMLTag(col, map.get("LABEL"));
                        tags.add(attribute);
                    }
                }
            }
    }

    /**
     * Write down on the generated code the XML headers and the root tags.
     */
    private void writeHeader(String cid, List<Map<String, String>> rootTags, String encoding) {
        
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_40);
    
        if(rootTags.size() > 0){
            for (int i = 0; i < rootTags.size(); i++){
                Map<String, String> rootTag = rootTags.get(i);
                
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(rootTag.get("TAG"));
    stringBuffer.append(TEXT_43);
    
            }
        }
    }

    /**
     * Write down on the generated code the context variables used for the processing of the groupBy tags.
     */
    private void writeGroupByContextVariable(String cid, int groupBySize) {
        
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(groupBySize);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    
     }

    /**
     * Write down on the generated code the final closing of the groupBy tags.
     */
    private void writeGroupByEndTag(String cid, List<XMLTag> groupByElements) {
        if (groupByElements.size() > 0) {
            for (int i = 0; i < groupByElements.size(); i++) {
                
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(groupByElements.get(i).getLabelName());
    stringBuffer.append(TEXT_56);
    
            }
        }
    }

    /**
     * Write down on the generated code the XMl tag of the "GroupBy" elements.
     */
    private void writeGroupByTags(String cid, List<XMLTag> groupByElements, IMetadataTable metadata) {
        // the flag allow use to know if we are on the first groupByElements
        
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
        for (int i = 0; i < groupByElements.size(); i++) {
         TypeExtractor typeExtractor = new TypeExtractor(metadata, groupByElements.get(i), advancedSeparator, thousandsSeparator, decimalSeparator);
            
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(groupByElements.get(i).getLabelName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(groupByElements.get(i).getLabel());
    stringBuffer.append(TEXT_62);
    typeExtractor.writeField(true);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(groupByElements.size() - 1);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
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
    stringBuffer.append(i);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
        }
        
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROW_TAG__"));
    stringBuffer.append(TEXT_97);
    
    }


    /**
     * Write down on the generated code the XMl tag of the "Attributes" elements.
     */
    private void writeAttributesTags(String cid, List<XMLTag> attributes, IMetadataTable metadata, boolean hasTags) {
        for(int i = 0; i < attributes.size(); i++){
            TypeExtractor typeExtractor = new TypeExtractor(metadata, attributes.get(i), advancedSeparator, thousandsSeparator, decimalSeparator);
            
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(attributes.get(i).getLabel());
    stringBuffer.append(TEXT_100);
    typeExtractor.writeField(false);
    stringBuffer.append(TEXT_101);
    
        }

        if(hasTags){
            
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
        } else {
            
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
        }
        
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
    }


    /**
     * Write down on the generated code the XMl tag of the "Tags" elements.
     */
    private void writeTagsTags(String cid, List<XMLTag> tags, IMetadataTable metadata) {
        for(int i = 0; i < tags.size(); i++){
            TypeExtractor typeExtractor = new TypeExtractor(metadata, tags.get(i), advancedSeparator, thousandsSeparator, decimalSeparator);
            
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(tags.get(i).getLabel());
    stringBuffer.append(TEXT_110);
    typeExtractor.writeField(false);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(tags.get(i).getLabel());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
			if (i == (tags.size() - 1)){
			    
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROW_TAG__"));
    stringBuffer.append(TEXT_116);
    
			}
        }
    }
}


    stringBuffer.append(TEXT_117);
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();  
String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
if(metadatas != null && metadatas.size() > 0) {
    IMetadataTable metadata = metadatas.get(0);
    if(metadata != null){
        boolean customEncoding = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_ENCODING__"));
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");


        boolean compress = "true".equals(ElementParameterParser.getValue(node, "__COMPRESS__"));
        String compression = ElementParameterParser.getValue(node, "__COMPRESSION__");

        TFileOuputXMLUtil tFileOuputXMLUtil = new TFileOuputXMLUtil(node);
        List<Map<String, String>> rootTags = tFileOuputXMLUtil.getRootTag();

        List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
        if(inConns == null || inConns.size() == 0) {
            return "";
        }
        IConnection inConn = inConns.get(0); 
        String connName = inConn.getName();
        String connTypeName = codeGenArgument.getRecordStructName(inConn);

        List<IMetadataColumn> columns = metadata.getListColumns();
        int columnSize = columns.size();

        List<XMLTag> groupByElements = tFileOuputXMLUtil.getGroupByFields(metadata);
        List<XMLTag> attributes = new java.util.ArrayList<XMLTag>();
        List<XMLTag> tags = new java.util.ArrayList<XMLTag>();

        tFileOuputXMLUtil.getAttributeAndTags(attributes, tags, groupByElements, metadata);
        
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_121);
    
        		tFileOuputXMLUtil.writeGroupByContextVariable(cid, groupByElements.size());
        		
    stringBuffer.append(TEXT_122);
    
                    if (groupByElements.size() > 0) {
                        List<XMLTag> groupby = tFileOuputXMLUtil.getGroupByFields(metadata);
                        tFileOuputXMLUtil.writeGroupByEndTag(cid, groupby);
                    }
        			
    stringBuffer.append(TEXT_123);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    
		            // display groupBy tag
    		        tFileOuputXMLUtil.writeGroupByTags(cid, groupByElements, metadata);

		            // display attributes tag
    		        tFileOuputXMLUtil.writeAttributesTags(cid, attributes, metadata, (tags.size() > 0));

		            // display "tag" tag
    		        tFileOuputXMLUtil.writeTagsTags(cid, tags, metadata);
        			
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_129);
    
            		    for(int i = groupByElements.size() - 1; i >= 0; i--){
            		        
    stringBuffer.append(TEXT_130);
    stringBuffer.append(groupByElements.get(i).getLabelName());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_133);
    
            		    }
            		    
    stringBuffer.append(TEXT_134);
    
        		    if(rootTags.size() > 0){
        		        for (int i = rootTags.size() - 1; i >= 0; i--){
        		            
    stringBuffer.append(TEXT_135);
    stringBuffer.append(rootTags.get(i).get("TAG"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_138);
    
        		        }
        		    }
        		    
    stringBuffer.append(TEXT_139);
    stringBuffer.append(connTypeName);
    stringBuffer.append(TEXT_140);
    
        		if (!compress) {
        		    
    stringBuffer.append(TEXT_141);
    
        		} else {

        			if("GZIP".equals(compression)){
        				
    stringBuffer.append(TEXT_142);
    
        			}else if("BZIP2".equals(compression)){
        				
    stringBuffer.append(TEXT_143);
    
        			}
        			
    stringBuffer.append(TEXT_144);
    
        		}


                 tFileOuputXMLUtil.writeHeader(cid, rootTags, encoding);

                 // We need to add the xml "version header"
                 for(int i = 0; i < rootTags.size() + 1;i++){
                     
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_149);
    
                 }
			    
    stringBuffer.append(TEXT_150);
    
	}
}

    return stringBuffer.toString();
  }
}
