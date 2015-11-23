package org.talend.designer.codegen.translators.processing.fields;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.utils.TalendQuoteUtils;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TWriteXMLFieldsSparkstreamingcodeJava
{
  protected static String nl;
  public static synchronized TWriteXMLFieldsSparkstreamingcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteXMLFieldsSparkstreamingcodeJava result = new TWriteXMLFieldsSparkstreamingcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/** This function needs the following dependecies" + NL + " * \"@{org.talend.designer.components.mrprovider}components/tFileOutputXML/tFileOutputXML_XMLTag.javajet\"%>" + NL + " */" + NL;
  protected final String TEXT_6 = NL + "                FormatterUtils.format_Number(value.";
  protected final String TEXT_7 = " == null ? \"\" : String.valueOf(";
  protected final String TEXT_8 = "), ";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ")";
  protected final String TEXT_11 = NL + "                FormatterUtils.format_Number(value.";
  protected final String TEXT_12 = " == null ? \"\" : String.valueOf(value.";
  protected final String TEXT_13 = "), ";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = ")";
  protected final String TEXT_16 = NL + "            value.";
  protected final String TEXT_17 = NL + "            ((value.";
  protected final String TEXT_18 = " == null)?\"\":(";
  protected final String TEXT_19 = NL + "                    ";
  protected final String TEXT_20 = "(" + NL + "                            FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_21 = ", ";
  protected final String TEXT_22 = "))";
  protected final String TEXT_23 = NL + "                    FormatterUtils.format_DateInUTC(value.";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ")";
  protected final String TEXT_26 = NL + "                ";
  protected final String TEXT_27 = "(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(value.";
  protected final String TEXT_28 = ")).toString())";
  protected final String TEXT_29 = NL + "                ";
  protected final String TEXT_30 = "(String.valueOf(";
  protected final String TEXT_31 = "))";
  protected final String TEXT_32 = NL + "                    ";
  protected final String TEXT_33 = "(value.";
  protected final String TEXT_34 = ")";
  protected final String TEXT_35 = NL + "                    value.";
  protected final String TEXT_36 = NL + "            ))";
  protected final String TEXT_37 = NL;
  protected final String TEXT_38 = NL + "        List<String> headers_";
  protected final String TEXT_39 = " = new java.util.ArrayList<String>();" + NL + "" + NL + "        headers_";
  protected final String TEXT_40 = ".add(\"<?xml version=\\\"1.0\\\" encoding=\\\"\" + ";
  protected final String TEXT_41 = " + \"\\\"?>\");" + NL;
  protected final String TEXT_42 = NL + "                headers_";
  protected final String TEXT_43 = ".add(\"<\"+";
  protected final String TEXT_44 = "+\">\");";
  protected final String TEXT_45 = NL + "        String tempSt_";
  protected final String TEXT_46 = " = null;" + NL + "" + NL + "        boolean flag_";
  protected final String TEXT_47 = " = true;" + NL + "" + NL + "        String[][] groupby_";
  protected final String TEXT_48 = " = new String[";
  protected final String TEXT_49 = "][2];" + NL + "" + NL + "        int groupby_new_";
  protected final String TEXT_50 = " = 0;" + NL + "" + NL + "        boolean start_";
  protected final String TEXT_51 = " = false;";
  protected final String TEXT_52 = NL + "                groupby_";
  protected final String TEXT_53 = "[";
  protected final String TEXT_54 = "][0] = \"\";" + NL + "             groupby_";
  protected final String TEXT_55 = "[";
  protected final String TEXT_56 = "][1] = \"</\" + ";
  protected final String TEXT_57 = " + \">\";";
  protected final String TEXT_58 = NL + "        flag_";
  protected final String TEXT_59 = " = true;";
  protected final String TEXT_60 = NL + "            tempSt_";
  protected final String TEXT_61 = " = \"<\" + ";
  protected final String TEXT_62 = " + \" \" + ";
  protected final String TEXT_63 = " + \"=\\\"\"" + NL + "                + ";
  protected final String TEXT_64 = NL + "                + \"\\\">\";" + NL + "            if(!groupby_";
  protected final String TEXT_65 = "[";
  protected final String TEXT_66 = "][0].equals(tempSt_";
  protected final String TEXT_67 = ")){" + NL + "                if(flag_";
  protected final String TEXT_68 = "){" + NL + "                    groupby_new_";
  protected final String TEXT_69 = " = ";
  protected final String TEXT_70 = ";" + NL + "                    flag_";
  protected final String TEXT_71 = " = false;" + NL + "                 for(int i_";
  protected final String TEXT_72 = " = ";
  protected final String TEXT_73 = "; i_";
  protected final String TEXT_74 = " >= groupby_new_";
  protected final String TEXT_75 = " && start_";
  protected final String TEXT_76 = "; i_";
  protected final String TEXT_77 = "--){" + NL + "                     sb_";
  protected final String TEXT_78 = ".append(groupby_";
  protected final String TEXT_79 = "[i_";
  protected final String TEXT_80 = "][1]);" + NL + "                     sb_";
  protected final String TEXT_81 = ".append(System.getProperty(\"line.separator\"));" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                groupby_";
  protected final String TEXT_82 = "[";
  protected final String TEXT_83 = "][0] = tempSt_";
  protected final String TEXT_84 = ";" + NL + "                sb_";
  protected final String TEXT_85 = ".append(tempSt_";
  protected final String TEXT_86 = ");" + NL + "                sb_";
  protected final String TEXT_87 = ".append(System.getProperty(\"line.separator\"));" + NL + "                if(!start_";
  protected final String TEXT_88 = "){" + NL + "                    start_";
  protected final String TEXT_89 = " = true;" + NL + "                }" + NL + "            }else if(!flag_";
  protected final String TEXT_90 = "){" + NL + "                sb_";
  protected final String TEXT_91 = ".append(tempSt_";
  protected final String TEXT_92 = ");" + NL + "                sb_";
  protected final String TEXT_93 = ".append(System.getProperty(\"line.separator\"));" + NL + "                if(!start_";
  protected final String TEXT_94 = "){" + NL + "                    start_";
  protected final String TEXT_95 = " = true;" + NL + "                }" + NL + "            }";
  protected final String TEXT_96 = NL + "        sb_";
  protected final String TEXT_97 = ".append(\"<\"+";
  protected final String TEXT_98 = ");";
  protected final String TEXT_99 = NL + "            sb_";
  protected final String TEXT_100 = ".append(\" \" + ";
  protected final String TEXT_101 = " + \"=\\\"\"" + NL + "                                    + ";
  protected final String TEXT_102 = NL + "                                    + \"\\\"\");";
  protected final String TEXT_103 = NL + "            sb_";
  protected final String TEXT_104 = ".append(\">\");";
  protected final String TEXT_105 = NL + "            sb_";
  protected final String TEXT_106 = ".append(\"/>\");";
  protected final String TEXT_107 = NL + "        sb_";
  protected final String TEXT_108 = ".append(System.getProperty(\"line.separator\"));";
  protected final String TEXT_109 = NL + "            sb_";
  protected final String TEXT_110 = ".append(\"<\" + ";
  protected final String TEXT_111 = " + \">\"" + NL + "                                + ";
  protected final String TEXT_112 = NL + "                                + \"</\" + ";
  protected final String TEXT_113 = " + \">\");" + NL + "" + NL + "            sb_";
  protected final String TEXT_114 = ".append(System.getProperty(\"line.separator\"));";
  protected final String TEXT_115 = NL + "\t\t\t    sb_";
  protected final String TEXT_116 = ".append(\"</\"+";
  protected final String TEXT_117 = "+\">\");" + NL + "\t\t\t    ";
  protected final String TEXT_118 = NL;
  protected final String TEXT_119 = NL + NL + "public static class ";
  protected final String TEXT_120 = " implements java.io.Serializable {" + NL + "" + NL + "\tprivate ContextProperties context;" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_121 = "(ContextProperties context) {" + NL + "\t\tthis.context = context;" + NL + "\t}" + NL + "\t" + NL + "\tpublic byte[] convert(";
  protected final String TEXT_122 = " value) {" + NL + "\t\tStringBuilder sb_";
  protected final String TEXT_123 = " = new StringBuilder();";
  protected final String TEXT_124 = NL + "     \tsb_";
  protected final String TEXT_125 = ".append(headers_";
  protected final String TEXT_126 = ".get(";
  protected final String TEXT_127 = "));" + NL + "     \tsb_";
  protected final String TEXT_128 = ".append(System.getProperty(\"line.separator\"));";
  protected final String TEXT_129 = NL + "\t\tsb_";
  protected final String TEXT_130 = ".append(\"</\" + ";
  protected final String TEXT_131 = " + \">\");" + NL + "\t\tsb_";
  protected final String TEXT_132 = ".append(System.getProperty(\"line.separator\"));";
  protected final String TEXT_133 = NL + "\t\tsb_";
  protected final String TEXT_134 = ".append(\"</\" + ";
  protected final String TEXT_135 = " + \">\");" + NL + "\t\tsb_";
  protected final String TEXT_136 = ".append(System.getProperty(\"line.separator\"));";
  protected final String TEXT_137 = NL + "\t\ttry {" + NL + "\t\t\treturn sb_";
  protected final String TEXT_138 = ".toString().getBytes(";
  protected final String TEXT_139 = ");" + NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t} // end convert()\t" + NL + "" + NL + "} // end ";
  protected final String TEXT_140 = "_";
  protected final String TEXT_141 = "ToXMLConverter class ";
  protected final String TEXT_142 = NL;
  protected final String TEXT_143 = NL;
  protected final String TEXT_144 = NL + NL + "public static class ";
  protected final String TEXT_145 = "_convertFunction<KEY> implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<KEY, ";
  protected final String TEXT_146 = ">, KEY,";
  protected final String TEXT_147 = "> {" + NL + "\t\t" + NL + "\tprivate ";
  protected final String TEXT_148 = " converter;" + NL + "\t" + NL + "\tpublic ";
  protected final String TEXT_149 = "_convertFunction(JobConf job){" + NL + "\t\tthis.converter = new ";
  protected final String TEXT_150 = "(new ContextProperties(job));" + NL + "\t}" + NL + "\t" + NL + "\tpublic scala.Tuple2<KEY, ";
  protected final String TEXT_151 = "> call(scala.Tuple2<KEY, ";
  protected final String TEXT_152 = "> tuple) {" + NL + "\t\t";
  protected final String TEXT_153 = " record = new ";
  protected final String TEXT_154 = "();";
  protected final String TEXT_155 = NL + "\t\ttry {";
  protected final String TEXT_156 = NL + "\t\t\trecord.";
  protected final String TEXT_157 = " = new String(converter.convert(tuple._2()));";
  protected final String TEXT_158 = NL + "\t\t\trecord.";
  protected final String TEXT_159 = " = new String(converter.convert(tuple._2()), ";
  protected final String TEXT_160 = ");";
  protected final String TEXT_161 = NL + "\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\trecord.";
  protected final String TEXT_162 = " = null;" + NL + "\t\t}";
  protected final String TEXT_163 = NL + "\t\trecord.";
  protected final String TEXT_164 = " = java.nio.ByteBuffer.wrap(converter.convert(tuple._2()));";
  protected final String TEXT_165 = NL + "\t\treturn new scala.Tuple2(tuple._1(), record);" + NL + "\t}" + NL + "}";
  protected final String TEXT_166 = NL + "\torg.apache.spark.streaming.api.java.JavaPairDStream<NullWritable, ";
  protected final String TEXT_167 = "> rdd_";
  protected final String TEXT_168 = " = rdd_";
  protected final String TEXT_169 = ".mapToPair(new ";
  protected final String TEXT_170 = "_convertFunction(job));";
  protected final String TEXT_171 = NL + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
// Parse the inputs to this javajet generator.
final BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
final INode node = (INode)codeGenArgument.getArgument();


    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    
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

    stringBuffer.append(TEXT_5);
    
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
                
    stringBuffer.append(TEXT_6);
    stringBuffer.append(xmlTag.getColumnName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(precision == null ? "value." + xmlTag.getColumnName() : "value." + xmlTag.getColumnName() + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_10);
    
            } else {
                
    stringBuffer.append(TEXT_11);
    stringBuffer.append(xmlTag.getColumnName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(xmlTag.getColumnName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(thousandsSeparator);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(decimalSeparator);
    stringBuffer.append(TEXT_15);
    
            }
        } else if(isPrimitive) {
            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(xmlTag.getColumnName());
    
        } else {
            
    stringBuffer.append(TEXT_17);
    stringBuffer.append(xmlTag.getColumnName());
    stringBuffer.append(TEXT_18);
    
            if (isDate && pattern != null){
                if (needReplace) { 
                    
    stringBuffer.append(TEXT_19);
    stringBuffer.append(xmlCheckingFonction);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(xmlTag.getColumnName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_22);
    
                } else {
                    
    stringBuffer.append(TEXT_23);
    stringBuffer.append(xmlTag.getColumnName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_25);
    
                }
            } else if(isByteArray){
                
    stringBuffer.append(TEXT_26);
    stringBuffer.append(xmlCheckingFonction);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(xmlTag.getColumnName());
    stringBuffer.append(TEXT_28);
    
            } else if(isBigDecimal){
                
    stringBuffer.append(TEXT_29);
    stringBuffer.append(xmlCheckingFonction);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(precision == null? "value." + xmlTag.getColumnName() : "value." + xmlTag.getColumnName() + ".setScale(" + precision + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_31);
    
            } else{
                if (needReplace) {
                    
    stringBuffer.append(TEXT_32);
    stringBuffer.append(xmlCheckingFonction);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(xmlTag.getColumnName());
    stringBuffer.append(TEXT_34);
    
                } else {
                    
    stringBuffer.append(TEXT_35);
    stringBuffer.append(xmlTag.getColumnName());
    
                }
            }
            
    stringBuffer.append(TEXT_36);
    
        }
    }

}


    stringBuffer.append(TEXT_37);
    

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
        
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_41);
    
        if(rootTags.size() > 0){
            for (int i = 0; i < rootTags.size(); i++){
                Map<String, String> rootTag = rootTags.get(i);
                
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(rootTag.get("TAG"));
    stringBuffer.append(TEXT_44);
    
            }
        }
    }

    /**
     * Write down on the generated code the context variables used for the processing of the groupBy tags.
     */
    private void writeGroupByContextVariable(String cid, int groupBySize) {
        
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(groupBySize);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    
     }

    /**
     * Write down on the generated code the final closing of the groupBy tags.
     */
    private void writeGroupByEndTag(String cid, List<XMLTag> groupByElements) {
        if (groupByElements.size() > 0) {
            for (int i = 0; i < groupByElements.size(); i++) {
                
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(groupByElements.get(i).getLabelName());
    stringBuffer.append(TEXT_57);
    
            }
        }
    }

    /**
     * Write down on the generated code the XMl tag of the "GroupBy" elements.
     */
    private void writeGroupByTags(String cid, List<XMLTag> groupByElements, IMetadataTable metadata) {
        // the flag allow use to know if we are on the first groupByElements
        
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
        for (int i = 0; i < groupByElements.size(); i++) {
         TypeExtractor typeExtractor = new TypeExtractor(metadata, groupByElements.get(i), advancedSeparator, thousandsSeparator, decimalSeparator);
            
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(groupByElements.get(i).getLabelName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(groupByElements.get(i).getLabel());
    stringBuffer.append(TEXT_63);
    typeExtractor.writeField(true);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(groupByElements.size() - 1);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(i);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
        }
        
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROW_TAG__"));
    stringBuffer.append(TEXT_98);
    
    }


    /**
     * Write down on the generated code the XMl tag of the "Attributes" elements.
     */
    private void writeAttributesTags(String cid, List<XMLTag> attributes, IMetadataTable metadata, boolean hasTags) {
        for(int i = 0; i < attributes.size(); i++){
            TypeExtractor typeExtractor = new TypeExtractor(metadata, attributes.get(i), advancedSeparator, thousandsSeparator, decimalSeparator);
            
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(attributes.get(i).getLabel());
    stringBuffer.append(TEXT_101);
    typeExtractor.writeField(false);
    stringBuffer.append(TEXT_102);
    
        }

        if(hasTags){
            
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
        } else {
            
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
        }
        
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
    }


    /**
     * Write down on the generated code the XMl tag of the "Tags" elements.
     */
    private void writeTagsTags(String cid, List<XMLTag> tags, IMetadataTable metadata) {
        for(int i = 0; i < tags.size(); i++){
            TypeExtractor typeExtractor = new TypeExtractor(metadata, tags.get(i), advancedSeparator, thousandsSeparator, decimalSeparator);
            
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(tags.get(i).getLabel());
    stringBuffer.append(TEXT_111);
    typeExtractor.writeField(false);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(tags.get(i).getLabel());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
			if (i == (tags.size() - 1)){
			    
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROW_TAG__"));
    stringBuffer.append(TEXT_117);
    
			}
        }
    }
}


    stringBuffer.append(TEXT_118);
    
class RowStructToXMLConverterHelper {

	private INode node;
	
	private String cid;
	
	private String incomingConnectionTypeName;
	
	private IConnection incomingConnection;
	
	private IMetadataTable metadata;
	
	public RowStructToXMLConverterHelper(INode node) {
		this.node = node;
		this.cid = node.getUniqueName();
		
		List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
		if(inConns == null || inConns.size() == 0) {
		    return;
		}
		this.incomingConnection = inConns.get(0);
		this.incomingConnectionTypeName  = codeGenArgument.getRecordStructName(incomingConnection);
		
		this.metadata = node.getMetadataList().get(0);
		//this.metadata = incomingConnection.getMetadataTable();
	}
	
	public String getConverterTypeName() {
		return cid+"_"+incomingConnectionTypeName+"ToXMLConverter";
	}
	
	public void generateConverterCode() {
		boolean customEncoding = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_ENCODING__"));
      String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
      
      TFileOuputXMLUtil tFileOuputXMLUtil = new TFileOuputXMLUtil(node);
		List<Map<String, String>> rootTags = tFileOuputXMLUtil.getRootTag();
		
		List<XMLTag> groupByElements = tFileOuputXMLUtil.getGroupByFields(metadata);
      List<XMLTag> attributes = new java.util.ArrayList<XMLTag>();
      List<XMLTag> tags = new java.util.ArrayList<XMLTag>();

      tFileOuputXMLUtil.getAttributeAndTags(attributes, tags, groupByElements, metadata);

    stringBuffer.append(TEXT_119);
    stringBuffer.append(getConverterTypeName());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(getConverterTypeName());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    
		tFileOuputXMLUtil.writeGroupByContextVariable(cid, groupByElements.size());
		
		tFileOuputXMLUtil.writeHeader(cid, rootTags, encoding);

     	// We need to add the xml "version header"
     	for(int i = 0; i < rootTags.size() + 1;i++){
 
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    
     	} // end for
     	
		if (groupByElements.size() > 0) {
    		List<XMLTag> groupby = tFileOuputXMLUtil.getGroupByFields(metadata);
    		tFileOuputXMLUtil.writeGroupByEndTag(cid, groupby);
      }

		// display groupBy tag
		tFileOuputXMLUtil.writeGroupByTags(cid, groupByElements, metadata);

		// display attributes tag
		tFileOuputXMLUtil.writeAttributesTags(cid, attributes, metadata, (tags.size() > 0));

		// display "tag" tag
		tFileOuputXMLUtil.writeTagsTags(cid, tags, metadata);
		

		for(int i = groupByElements.size() - 1; i >= 0; i--){

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(groupByElements.get(i).getLabelName());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    
		} // end for

		if(rootTags.size() > 0){
			for (int i = rootTags.size() - 1; i >= 0; i--){

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(rootTags.get(i).get("TAG"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    
    		} // end for
		} // end if

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(incomingConnectionTypeName);
    stringBuffer.append(TEXT_141);
    
	} // end generateConverterCode()
} // end class

    stringBuffer.append(TEXT_142);
    stringBuffer.append(TEXT_143);
    
/**
* This is a Javajet helper class meant to generate all Spark functions responsible for serializing rowXStruct objects into byte arrays
* within a Spark Streaming job.
*
* tWriteXXX Spark functions rely on converters to serialize rowStruct into byte arrays accepted by messaging output components.
* These converters are framework undependant : they can be reused with any framework which needs to send messages as byte arrays.
* The type name of the converter to use must be provided via the generateCode() method.
*  
* WARNING : this does not generate the converter code but only the Spark functions one actually. These functions are common between 
* all tWriteXXX components and converters code have to be generated elsewhere beforehand.
*/

class TWriteXXXHelper {

	private INode node;
	
	private IConnection incomingConnection;
	
	private IConnection outgoingConnection;

	public TWriteXXXHelper(INode node) {
		this.node = node;
		this.incomingConnection = findIncomingConnection();
		this.outgoingConnection = findOutgoingConnection();
	}
	
	public void generateCode(String converterTypeName) {
		String cid = node.getUniqueName();

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(getIncomingConnectionTypeName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(converterTypeName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(converterTypeName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(getIncomingConnectionTypeName());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_154);
    
		if("STRING".equals(getOutputType())) {

    stringBuffer.append(TEXT_155);
    			
			if(getEncoding() == null || getEncoding().equals("")) {

    stringBuffer.append(TEXT_156);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_157);
    
			} else {

    stringBuffer.append(TEXT_158);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_159);
    stringBuffer.append(getEncoding());
    stringBuffer.append(TEXT_160);
    
			}

    stringBuffer.append(TEXT_161);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_162);
    
		} else {

    stringBuffer.append(TEXT_163);
    stringBuffer.append(getOutgoingColumnName());
    stringBuffer.append(TEXT_164);
    
		}

    stringBuffer.append(TEXT_165);
    
	} // end generateCode()
	
	public void generateConfig() {
		String cid = node.getUniqueName();

    stringBuffer.append(TEXT_166);
    stringBuffer.append(getOutgoingConnectionTypeName());
    stringBuffer.append(TEXT_167);
    stringBuffer.append(outgoingConnection.getName());
    stringBuffer.append(TEXT_168);
    stringBuffer.append(incomingConnection.getName());
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    	
	} // end generateConfig()
	
	private IConnection findIncomingConnection() {
		IConnection result = null;
		if (node.getIncomingConnections() != null) {
		    for (IConnection in : node.getIncomingConnections()) {
		        if (in.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		            result = in;
		            break;
		        }
		    }
		}
		return result;
	}

   private IConnection findOutgoingConnection() {
		IConnection result = null;
		if (node.getOutgoingConnections() != null) {
		    for (IConnection in : node.getOutgoingConnections()) {
		        if (in.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		            result = in;
		            break;
		        }
		    }
		}
		return result;
	}
    
   private String getIncomingConnectionTypeName() {
		return codeGenArgument.getRecordStructName(this.incomingConnection);
   }
   
   private String getOutgoingConnectionTypeName() {
		return codeGenArgument.getRecordStructName(this.outgoingConnection);
   }
   
   private String getOutgoingColumnName() {
      return this.outgoingConnection.getMetadataTable().getListColumns().get(0).getLabel();
   }
   
   private String getOutputType() {
   	return ElementParameterParser.getValue(node, "__OUTPUT_TYPE__");
   }
   
   private String getEncoding() {
   	return ElementParameterParser.getValue(node, "__ENCODING__");
   }
    
} // end TWriteXXXHelper class

    stringBuffer.append(TEXT_171);
    
RowStructToXMLConverterHelper converterHelper = new RowStructToXMLConverterHelper(node);
converterHelper.generateConverterCode();

TWriteXXXHelper tWriteXXXHelper = new TWriteXXXHelper(node);
tWriteXXXHelper.generateCode(converterHelper.getConverterTypeName());

    return stringBuffer.toString();
  }
}
