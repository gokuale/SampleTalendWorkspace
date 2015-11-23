package org.talend.designer.codegen.translators.bigdata.googlebigquery;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TBigQueryOutputBulkMainJava
{
  protected static String nl;
  public static synchronized TBigQueryOutputBulkMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBigQueryOutputBulkMainJava result = new TBigQueryOutputBulkMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  \t" + NL + "                    \tString[] row_";
  protected final String TEXT_2 = "=new String[]{";
  protected final String TEXT_3 = "\"\\\\N\",";
  protected final String TEXT_4 = "};\t\t//empty value must be NULL('\\N' in bulk file)" + NL + "                    \t";
  protected final String TEXT_5 = NL + "                \t\t\t\t\trow_";
  protected final String TEXT_6 = "[";
  protected final String TEXT_7 = "] = String.valueOf(" + NL + "                \t\t\t\t\t\t\ttrue == ";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = " ?\"1\":\"0\"" + NL + "                \t\t\t\t\t\t\t);" + NL + "                \t\t\t\t";
  protected final String TEXT_10 = NL + "                \t\t\t    \trow_";
  protected final String TEXT_11 = "[";
  protected final String TEXT_12 = "] = String.valueOf(";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = ");" + NL + "                \t\t\t    ";
  protected final String TEXT_15 = NL + "                \t\t\t    if(";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = " != null){" + NL + "                \t\t\t        ";
  protected final String TEXT_18 = NL + "                \t\t\t            row_";
  protected final String TEXT_19 = "[";
  protected final String TEXT_20 = "] = ";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = ";" + NL + "                \t\t\t            ";
  protected final String TEXT_23 = NL + "                \t\t\t            row_";
  protected final String TEXT_24 = "[";
  protected final String TEXT_25 = "] = FormatterUtils.format_Date(";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = ", \"yyyy-MM-dd HH:mm:ss\");" + NL + "                \t\t\t            ";
  protected final String TEXT_28 = NL + "                \t\t\t            row_";
  protected final String TEXT_29 = "[";
  protected final String TEXT_30 = "] = java.nio.charset.Charset.forName(";
  protected final String TEXT_31 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ")).toString();" + NL + "                \t\t\t            ";
  protected final String TEXT_34 = NL + "                \t\t\t\t\t\trow_";
  protected final String TEXT_35 = "[";
  protected final String TEXT_36 = "] = String.valueOf(" + NL + "                \t\t\t\t\t\t\ttrue == ";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = " ?\"1\":\"0\"" + NL + "                \t\t\t\t\t\t\t);" + NL + "                \t\t\t\t\t";
  protected final String TEXT_39 = NL + "                \t\t\t            row_";
  protected final String TEXT_40 = "[";
  protected final String TEXT_41 = "] = String.valueOf(";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = ");" + NL + "                \t\t\t            ";
  protected final String TEXT_44 = "                \t\t\t    " + NL + "                \t\t\t    }" + NL + "                \t\t \t";
  protected final String TEXT_45 = NL + "\t            \t\t\tdiskSpace_";
  protected final String TEXT_46 = " = file_";
  protected final String TEXT_47 = ".getFreeSpace();" + NL + "\t            \t\t\tif(diskSpace_";
  protected final String TEXT_48 = " <= 0){" + NL + "\t\t\t\t\t\t\t\tthrow new java.io.IOException(\"The disk space is not enough,please check it!\");" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_49 = NL + "                        csvWriter_";
  protected final String TEXT_50 = ".writeNext(row_";
  protected final String TEXT_51 = ");    ";
  protected final String TEXT_52 = NL + "                            csvWriter_";
  protected final String TEXT_53 = ".flush();";
  protected final String TEXT_54 = NL + "                            if(nb_line_";
  protected final String TEXT_55 = "%";
  protected final String TEXT_56 = " == 0) {                            " + NL + "                                csvWriter_";
  protected final String TEXT_57 = ".flush();" + NL + "                            }     ";
  protected final String TEXT_58 = NL + "                        nb_line_";
  protected final String TEXT_59 = "++;";
  protected final String TEXT_60 = NL + "                            log.debug(\"";
  protected final String TEXT_61 = " - Writing the record \" + nb_line_";
  protected final String TEXT_62 = " + \".\");" + NL + "                \t\t";
  protected final String TEXT_63 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
        
            boolean checkDiskSpace = ("true").equals(ElementParameterParser.getValue(node,"__CHECK_DISK_SPACE__"));
            boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
            String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");
            
            String encoding = ElementParameterParser.getValue(node,"__ENCODING__");        
            
            List< ? extends IConnection> conns = node.getIncomingConnections();
        	        	if(conns!=null){
        		if (conns.size()>0){
        		    IConnection conn =conns.get(0);
            		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            			List<IMetadataColumn> columns = metadata.getListColumns();
                		int sizeColumns = columns.size();
            			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    for(int j=0;j<sizeColumns;j++){
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    
            			for (int i = 0; i < sizeColumns; i++) {
                			IMetadataColumn column = columns.get(i);
                			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                			if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){
                			
                				if(javaType == JavaTypesManager.BOOLEAN ){
                				
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_9);
    
                				} else {
                			    
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_14);
    
                			    }
                			}else {
                			    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_17);
    					
                			        if(javaType == JavaTypesManager.STRING ){
                			            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_22);
    
                			        }else if(javaType == JavaTypesManager.DATE && pattern != null){
                			            
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_27);
    
                			        }else if(javaType == JavaTypesManager.BYTE_ARRAY){
                			            
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_33);
    
                			        }else if(javaType == JavaTypesManager.BOOLEAN ){
                					
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_38);
    
                					}	             			        
                			        else{
                			            
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_43);
    
                			        }
                			        
    stringBuffer.append(TEXT_44);
     
                			}
            			} 
                        if(checkDiskSpace){
                        
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
                        }
                        
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
                        if(checkDiskSpace){
                        
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
                        }
                        
    
                        if(flushOnRow) {
                        
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
                        }
                        
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    
                        if(isLog4jEnabled){
                        
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
                		}
            		}
        		
        		}
        	}
        }
    }
    
    stringBuffer.append(TEXT_63);
    return stringBuffer.toString();
  }
}
