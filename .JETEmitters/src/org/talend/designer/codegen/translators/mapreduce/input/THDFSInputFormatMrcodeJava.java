package org.talend.designer.codegen.translators.mapreduce.input;

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

public class THDFSInputFormatMrcodeJava
{
  protected static String nl;
  public static synchronized THDFSInputFormatMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSInputFormatMrcodeJava result = new THDFSInputFormatMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "        // read the input format line by line" + NL + "        public static class ";
  protected final String TEXT_2 = "StructInputFormat extends org.talend.hadoop.mapred.lib.file.TDelimitedFileInputFormat<NullWritable, ";
  protected final String TEXT_3 = "> {" + NL + "            private ContextProperties context;" + NL + "" + NL + "            //init" + NL + "            public void setConf(Configuration conf){" + NL + "                context = new ContextProperties(conf);" + NL + "                setInputPath(";
  protected final String TEXT_4 = ");";
  protected final String TEXT_5 = NL + "                    setSkipLines(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "            }" + NL + "" + NL + "            public RecordReader<NullWritable, ";
  protected final String TEXT_8 = "> getRecordReader(" + NL + "                    InputSplit split, JobConf job, Reporter reporter)" + NL + "                    throws IOException {" + NL + "                if (reporter != null) {" + NL + "                    reporter.setStatus(split.toString());" + NL + "                }" + NL + "                return new HDFSRecordReader(job, (FileSplit) split, ";
  protected final String TEXT_9 = ".getBytes(";
  protected final String TEXT_10 = "));" + NL + "            }" + NL + "" + NL + "            protected static class HDFSRecordReader extends" + NL + "                org.talend.hadoop.mapred.lib.file.TDelimitedFileRecordReader<NullWritable, ";
  protected final String TEXT_11 = "> {" + NL + "" + NL + "                private ContextProperties context;" + NL + "" + NL + "                protected HDFSRecordReader(JobConf job, FileSplit split, byte[] rowSeparator)" + NL + "                        throws IOException {" + NL + "                    super(job, split, rowSeparator);" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL;
  protected final String TEXT_12 = NL + "                    public boolean nextCSV(NullWritable key, ";
  protected final String TEXT_13 = " value) throws IOException {";
  protected final String TEXT_14 = NL + "                        // CSV mode => it is human readable => we can make a toString()" + NL + "                        String currentLine = null;" + NL + "                        int numberOfTextEnclosureChar = 0;" + NL + "    " + NL + "                        // We are looping on the input until we find a pair number of text enclosure character." + NL + "                        // It allow the handle schema like \" 'abc\\ndef' \" (with \"'\" as text enclosure character)" + NL + "" + NL + "                        boolean hasNext = true;" + NL;
  protected final String TEXT_15 = NL + "                            boolean previousCharIsEscape = true;";
  protected final String TEXT_16 = NL + NL + "                        do {" + NL + "                            Text textValue = new Text();" + NL + "                            hasNext = next(textValue);" + NL + "                            if (hasNext) {" + NL + "                                // There is still data to process" + NL + "                                String currentSubline = ";
  protected final String TEXT_17 = ";" + NL + "" + NL + "                                // Get the number of escape character on the current substring," + NL + "                                // in order to check if we have or not a complete column" + NL + "                                for (int index = currentSubline.indexOf('";
  protected final String TEXT_18 = "');" + NL + "                                        index >= 0;" + NL + "                                        index = currentSubline.indexOf('";
  protected final String TEXT_19 = "', index + 1)) {";
  protected final String TEXT_20 = NL + "                                        if (index == 0) {" + NL + "                                            // First character is an escape character, count it before any processing" + NL + "                                            numberOfTextEnclosureChar++;" + NL + "                                            previousCharIsEscape = false;" + NL + "                                        } else if (index == currentSubline.length() - 1) {" + NL + "                                            // last character, check if he is escaped or not" + NL + "                                            if (!previousCharIsEscape) {" + NL + "                                                numberOfTextEnclosureChar++;" + NL + "                                            } else {" + NL + "                                                previousCharIsEscape = false;" + NL + "                                                break;" + NL + "                                            }" + NL + "                                        } else if (previousCharIsEscape) {" + NL + "                                            // if the previous character is defined as the escape one, don't do anything" + NL + "                                            previousCharIsEscape = false;" + NL + "                                        } else if (currentSubline.charAt(index + 1) == '";
  protected final String TEXT_21 = "') {" + NL + "                                            // if the current character and the next character are defined as the text enclosure," + NL + "                                            // we are on a escape character" + NL + "                                            previousCharIsEscape = true;" + NL + "                                        } else {" + NL + "                                            // No particular case, we are on a true enclosure character" + NL + "                                            numberOfTextEnclosureChar++;" + NL + "                                        }";
  protected final String TEXT_22 = NL + "                                        if ((index == 0) || (currentSubline.charAt(index - 1) != '";
  protected final String TEXT_23 = "')) {" + NL + "                                            numberOfTextEnclosureChar++;" + NL + "                                        }";
  protected final String TEXT_24 = NL + NL + "                                }" + NL + "                                if (currentLine == null) {" + NL + "                                    currentLine = currentSubline;" + NL + "                                } else {" + NL + "                                    currentLine += ";
  protected final String TEXT_25 = " + currentSubline;" + NL + "                                }" + NL + "                            }" + NL + "                        } while ((hasNext) && (numberOfTextEnclosureChar % 2 != 0));" + NL + "" + NL + "                        value.";
  protected final String TEXT_26 = " = currentLine;" + NL + "" + NL + "                        if (numberOfTextEnclosureChar % 2 != 0) {" + NL + "                            // the loop exited because there is no more data, but we still need to send the current one" + NL + "                            return true;" + NL + "                        } else {" + NL + "                            return hasNext;" + NL + "                        }" + NL + "                    }";
  protected final String TEXT_27 = NL + NL + "                public boolean next(NullWritable key, ";
  protected final String TEXT_28 = " value) throws IOException {";
  protected final String TEXT_29 = NL + "                            boolean hasNext = nextCSV(key, value);" + NL + "                            while (hasNext && value.";
  protected final String TEXT_30 = ".length() == 0) {" + NL + "                                hasNext = nextCSV(key, value);" + NL + "                            }" + NL + "                            return hasNext;";
  protected final String TEXT_31 = NL + "                            return nextCSV(key, value);";
  protected final String TEXT_32 = NL + "                            Text textValue = new Text();" + NL + "                            boolean hasNext = next(textValue);" + NL + "                            while (hasNext && textValue.getLength() == 0) {" + NL + "                                hasNext =  next(textValue);" + NL + "                            }" + NL + "                            value.";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = ";" + NL + "                            return hasNext;";
  protected final String TEXT_35 = NL + "                            Text textValue = new Text();" + NL + "                            boolean hasNext = next(textValue);" + NL + "                            value.";
  protected final String TEXT_36 = " = ";
  protected final String TEXT_37 = ";" + NL + "" + NL + "                            return hasNext;";
  protected final String TEXT_38 = NL + "                }" + NL + "" + NL + "                public NullWritable createKey() {" + NL + "                    return NullWritable.get();" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_39 = " createValue() {" + NL + "                    return new ";
  protected final String TEXT_40 = "();" + NL + "                }" + NL + "            }" + NL;
  protected final String TEXT_41 = NL + "                @Override" + NL + "                protected boolean isSplitable(FileSystem fs, Path filename) {" + NL + "                    return false;" + NL + "                }";
  protected final String TEXT_42 = NL + "        }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String folder = ElementParameterParser.getValue(node,"__FILENAME__");

String uriPrefix = "";
// Used for Spark only for now.
boolean useConfigurationComponent = "true".equals(ElementParameterParser.getValue(node, "__DEFINE_STORAGE_CONFIGURATION__"));
if(useConfigurationComponent) {
    uriPrefix = org.talend.designer.spark.generator.storage.SparkStorageUtils.getURIPrefix(node);
    folder = uriPrefix + " + " + folder;
}

String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");
boolean customEncoding = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_ENCODING__"));
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
String skipLines = ElementParameterParser.getValue(node,"__HEADER__");
boolean skipEmptyLines = "true".equals(ElementParameterParser.getValue(node,"__REMOVE_EMPTY_ROW__"));
boolean csvMode = "true".equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"));
if (csvMode) {
    rowSeparator = ElementParameterParser.getValue(node, "__CSVROWSEPARATOR__");
}

List<IMetadataTable> metadatas = node.getMetadataList();
List< ? extends IConnection> connections = node.getOutgoingConnections();
if ((connections != null) && (connections.size() > 0) && (metadatas!=null) && (metadatas.size() > 0)){
    IConnection connection = connections.get(0);
    String connectionName = connection.getName();
    String connectionTypeName = codeGenArgument.getRecordStructName(connection);

    List<IMetadataColumn> columns = metadatas.get(0).getListColumns();
    if ((connection.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) && (columns != null) && (columns.size() > 0)) {
        IMetadataColumn column = columns.get(0);
        String columnName = column.getLabel();
        
    stringBuffer.append(TEXT_1);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_4);
    
                if (skipLines != null && !skipLines.isEmpty()) {
                    
    stringBuffer.append(TEXT_5);
    stringBuffer.append(skipLines);
    stringBuffer.append(TEXT_6);
    
                }
                
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_11);
    
                if (csvMode) {
                    
    stringBuffer.append(TEXT_12);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_13);
    
                        String escapeChar = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
                        if(("").equals(escapeChar)){
                            escapeChar = "\"\"";
                        }
                        escapeChar = escapeChar.substring(1, escapeChar.length() - 1);
                        if(("'").equals(escapeChar)){
                            escapeChar = "\\'";
                        }
    
                        String textEnclosure = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
                        if(("").equals(textEnclosure)){
                            textEnclosure = "\"\"";
                        }
                        textEnclosure = textEnclosure.substring(1, textEnclosure.length() - 1);
                        if ("".equals(textEnclosure)) {
                            textEnclosure = "\0";
                        } else if (("'").equals(textEnclosure)) {
                            textEnclosure = "\\'";
                        }
    
                        
    stringBuffer.append(TEXT_14);
     if (escapeChar.equals(textEnclosure)) {
    stringBuffer.append(TEXT_15);
     } 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(customEncoding?"new String(textValue.getBytes(), " + encoding + ");"
                                        :"textValue.toString()" );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(textEnclosure);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(textEnclosure);
    stringBuffer.append(TEXT_19);
     if (escapeChar.equals(textEnclosure)) {
    stringBuffer.append(TEXT_20);
    stringBuffer.append(textEnclosure);
    stringBuffer.append(TEXT_21);
     } else { 
    stringBuffer.append(TEXT_22);
    stringBuffer.append(escapeChar);
    stringBuffer.append(TEXT_23);
     } 
    stringBuffer.append(TEXT_24);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_26);
    
                }
                
    stringBuffer.append(TEXT_27);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_28);
    
                    if (csvMode) {
                        if (skipEmptyLines) {
                            
    stringBuffer.append(TEXT_29);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_30);
    
                        } else {
                            
    stringBuffer.append(TEXT_31);
    
                        }
                    } else { // normal mode
                        if (skipEmptyLines) {
                            
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(customEncoding?"new String(textValue.getBytes(), " + encoding + ");"
                                    :"textValue.toString()" );
    stringBuffer.append(TEXT_34);
    
                        } else {
                            
    stringBuffer.append(TEXT_35);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(customEncoding?"new String(textValue.getBytes(), " + encoding + ");"
                                    :"textValue.toString()" );
    stringBuffer.append(TEXT_37);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_38);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(connectionTypeName);
    stringBuffer.append(TEXT_40);
    
            if (csvMode) {
                
    stringBuffer.append(TEXT_41);
    
            }
            
    stringBuffer.append(TEXT_42);
    
    }
}


    return stringBuffer.toString();
  }
}
