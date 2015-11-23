package org.talend.designer.codegen.translators.talendcloud.action;

import java.util.List;
import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TActionOutputBeginJava
{
  protected static String nl;
  public static synchronized TActionOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TActionOutputBeginJava result = new TActionOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " class Util_";
  protected final String TEXT_3 = " {" + NL + "" + NL + "        String[] des_top = { \".\", \".\", \"-\", \"+\" };" + NL + "" + NL + "        String[] des_head = { \"|=\", \"=|\", \"-\", \"+\" };" + NL + "" + NL + "        String[] des_bottom = { \"'\", \"'\", \"-\", \"+\" };" + NL + "" + NL + "        String name=\"\";" + NL + "" + NL + "        java.util.List<String[]> list = new java.util.ArrayList<String[]>();" + NL + "" + NL + "        int[] colLengths = new int[";
  protected final String TEXT_4 = "];" + NL + "" + NL + "        public void addRow(String[] row) {" + NL + "" + NL + "            for (int i = 0; i < ";
  protected final String TEXT_5 = "; i++) {" + NL + "                if (row[i]!=null) {" + NL + "                  colLengths[i] = Math.max(colLengths[i], row[i].length());" + NL + "                }" + NL + "            }" + NL + "            list.add(row);" + NL + "        }" + NL + "" + NL + "        public void setTableName(String name) {" + NL + "" + NL + "            this.name = name;" + NL + "        }" + NL + "" + NL + "            public StringBuilder format() {" + NL + "            " + NL + "                StringBuilder sb = new StringBuilder();" + NL + " ";
  protected final String TEXT_6 = " " + NL + "            " + NL + "                    sb.append(print(des_top));" + NL + "    " + NL + "                    int totals = 0;" + NL + "                    for (int i = 0; i < colLengths.length; i++) {" + NL + "                        totals = totals + colLengths[i];" + NL + "                    }" + NL + "    " + NL + "                    // name" + NL + "                    sb.append(\"|\");" + NL + "                    int k = 0;" + NL + "                    for (k = 0; k < (totals + ";
  protected final String TEXT_7 = " - name.length()) / 2; k++) {" + NL + "                        sb.append(' ');" + NL + "                    }" + NL + "                    sb.append(name);" + NL + "                    for (int i = 0; i < totals + ";
  protected final String TEXT_8 = " - name.length() - k; i++) {" + NL + "                        sb.append(' ');" + NL + "                    }" + NL + "                    sb.append(\"|\\n\");" + NL + "" + NL + "                    // head and rows" + NL + "                    sb.append(print(des_head));" + NL + "                    for (int i = 0; i < list.size(); i++) {" + NL + "    " + NL + "                        String[] row = list.get(i);" + NL + "    " + NL + "                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());" + NL + "                        " + NL + "                        StringBuilder sbformat = new StringBuilder();                                       ";
  protected final String TEXT_9 = "      " + NL + "        \t\t\t        sbformat.append(\"|%";
  protected final String TEXT_10 = "$-\");" + NL + "        \t\t\t        sbformat.append(colLengths[";
  protected final String TEXT_11 = "]);" + NL + "        \t\t\t        sbformat.append(\"s\");" + NL + "        \t\t\t        ";
  protected final String TEXT_12 = "              " + NL + "                        sbformat.append(\"|\\n\");                    " + NL + "       " + NL + "                        formatter.format(sbformat.toString(), (Object[])row);\t" + NL + "                                " + NL + "                        sb.append(formatter.toString());" + NL + "                        if (i == 0)" + NL + "                            sb.append(print(des_head)); // print the head" + NL + "                    }" + NL + "    " + NL + "                    // end" + NL + "                    sb.append(print(des_bottom));" + NL + "                    return sb;" + NL + "                }" + NL + "            " + NL + "" + NL + "            private StringBuilder print(String[] fillChars) {" + NL + "                StringBuilder sb = new StringBuilder();" + NL + "                //first column" + NL + "                sb.append(fillChars[0]);";
  protected final String TEXT_13 = "                " + NL + "                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }" + NL + "                    sb.append(fillChars[3]);";
  protected final String TEXT_14 = "\t                " + NL;
  protected final String TEXT_15 = NL + "                    for (int i = 0; i < colLengths[";
  protected final String TEXT_16 = "] - fillChars[3].length() + 1; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }" + NL + "                    sb.append(fillChars[3]);";
  protected final String TEXT_17 = NL + "                ";
  protected final String TEXT_18 = "  " + NL + "                    //last column" + NL + "                    for (int i = 0; i < colLengths[";
  protected final String TEXT_19 = "] - fillChars[0].length() - fillChars[1].length()+2; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }";
  protected final String TEXT_20 = NL + "                    //last column" + NL + "                    for (int i = 0; i < colLengths[";
  protected final String TEXT_21 = "] - fillChars[1].length() + 1; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }";
  protected final String TEXT_22 = "         " + NL + "                sb.append(fillChars[1]);" + NL + "                sb.append(\"\\n\");";
  protected final String TEXT_23 = "               " + NL + "                return sb;" + NL + "            }" + NL + "            " + NL + "            public boolean isTableEmpty(){" + NL + "            \tif (list.size() > 1)" + NL + "            \t\treturn false;" + NL + "            \treturn true;" + NL + "            }" + NL + "        }" + NL + "        Util_";
  protected final String TEXT_24 = " util_";
  protected final String TEXT_25 = " = new Util_";
  protected final String TEXT_26 = "();" + NL + "        util_";
  protected final String TEXT_27 = ".setTableName(\"";
  protected final String TEXT_28 = "\");" + NL + "        util_";
  protected final String TEXT_29 = ".addRow(new String[]{";
  protected final String TEXT_30 = "\"";
  protected final String TEXT_31 = "\",";
  protected final String TEXT_32 = "});";
  protected final String TEXT_33 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if (null != metadatas && 0 < metadatas.size()) {
	IMetadataTable metadata = metadatas.get(0);
	if (null != metadata) {
		String cid = node.getUniqueName();
		List<IMetadataColumn> columns = metadata.getListColumns();
		int sizeColumns = columns.size();
		String label = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_5);
     
                if (sizeColumns > 0) { //more than one column
                
    stringBuffer.append(TEXT_6);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_8);
    
                        for ( int i = 0; i < sizeColumns; i++) {
                            
    stringBuffer.append(TEXT_9);
    stringBuffer.append(i+1 );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_11);
    
                        }
                        
    stringBuffer.append(TEXT_12);
     
                if (sizeColumns > 1) { 
                    
    stringBuffer.append(TEXT_13);
    
                }
                
    stringBuffer.append(TEXT_14);
    
                for(int i = 0; i< sizeColumns-2;i++) {
                    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(i+1 );
    stringBuffer.append(TEXT_16);
    
                }
                
    stringBuffer.append(TEXT_17);
     
                if (sizeColumns == 1) { 
                    
    stringBuffer.append(TEXT_18);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_19);
     
                } else if (sizeColumns > 1){
                    
    stringBuffer.append(TEXT_20);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_21);
    
                }
                
    stringBuffer.append(TEXT_22);
     
            } 
            
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    for(int i=0;i< columns.size();i++){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(columns.get(i).getLabel() );
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    
	}
}

    stringBuffer.append(TEXT_33);
    return stringBuffer.toString();
  }
}
