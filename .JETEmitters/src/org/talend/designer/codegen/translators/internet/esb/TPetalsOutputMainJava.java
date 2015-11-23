package org.talend.designer.codegen.translators.internet.esb;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TPetalsOutputMainJava
{
  protected static String nl;
  public static synchronized TPetalsOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPetalsOutputMainJava result = new TPetalsOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tnb_line_";
  protected final String TEXT_2 = " ++;" + NL + "        \trowElt_";
  protected final String TEXT_3 = " = petalsOutMessage.createElementNS( petalsNs, \"tns:outDataBean\" );" + NL + "        \trootElt_";
  protected final String TEXT_4 = ".appendChild( rowElt_";
  protected final String TEXT_5 = " );";
  protected final String TEXT_6 = " " + NL + "\t\t\t\tif( ";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " != ";
  protected final String TEXT_9 = " ) {" + NL + "\t\t\t\t\tString ";
  protected final String TEXT_10 = "Value_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = "\t   \t\t\t\t\t\t" + NL + "\t\t\t\t\tString.valueOf( ";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = ".getTime());";
  protected final String TEXT_15 = NL + "\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(" + NL + "\t\t\t\t\t\tjava.nio.ByteBuffer.wrap( ";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = " )).toString();";
  protected final String TEXT_18 = NL + "\t\t\t\t\tString.valueOf( ";
  protected final String TEXT_19 = " );";
  protected final String TEXT_20 = "    " + NL + "\t\t\t   \tString.valueOf( ";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = " );\t\t\t";
  protected final String TEXT_23 = "\t\t\t\t\t" + NL + "\t\t\t\t\telement_";
  protected final String TEXT_24 = " = petalsOutMessage.createElementNS( petalsNs, \"tns:";
  protected final String TEXT_25 = "\" );" + NL + "\t\t\t\t\telement_";
  protected final String TEXT_26 = ".setTextContent( ";
  protected final String TEXT_27 = "Value_";
  protected final String TEXT_28 = " );" + NL + "\t\t\t\t\trowElt_";
  protected final String TEXT_29 = ".appendChild( element_";
  protected final String TEXT_30 = " );" + NL + "\t\t\t\t}";
  protected final String TEXT_31 = NL + "\t\t\t\telse {" + NL + "\t\t\t\t\telement_";
  protected final String TEXT_32 = " = petalsOutMessage.createElementNS( petalsNs, \"tns:";
  protected final String TEXT_33 = "\" );" + NL + "\t\t\t\t\telement_";
  protected final String TEXT_34 = ".setTextContent( String.valueOf( ";
  protected final String TEXT_35 = " ));" + NL + "\t\t\t\t\trowElt_";
  protected final String TEXT_36 = ".appendChild( element_";
  protected final String TEXT_37 = " );" + NL + "\t\t\t\t}";
  protected final String TEXT_38 = NL + "\t\t\t\telse {" + NL + "\t\t\t\t\telement_";
  protected final String TEXT_39 = " = petalsOutMessage.createElementNS( petalsNs, \"tns:";
  protected final String TEXT_40 = "\" );" + NL + "\t\t\t\t\telement_";
  protected final String TEXT_41 = ".setAttribute( \"xsi:nil\", \"true\" );" + NL + "\t\t\t\t\trowElt_";
  protected final String TEXT_42 = ".appendChild( element_";
  protected final String TEXT_43 = " );" + NL + "\t\t\t\t}";
  protected final String TEXT_44 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    // Strategy: if the value is not the default value for the column type, then write it.
    // If it is the default value and this value is not null, then write it.
    // Otherwise, if the column is nillable, set it to null.
    // Primitive types are handled in the first two cases. Others are all processed too. 
    
    // Get the schema
    List<IMetadataTable> metadatas = node.getMetadataList();
	if( metadatas != null 
			&& metadatas.size() > 0
			&& metadatas.get( 0 ) != null ) {
			
    	IMetadataTable metadata = metadatas.get( 0 );
        
        // Get the row
        for( IConnection conn : node.getIncomingConnections()) {
        	if( ! conn.getLineStyle().hasConnectionCategory( IConnectionCategory.DATA ))
        		continue;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_5);
    
        	List<IMetadataColumn> columns = metadata.getListColumns();
        	for( int i=0; i<columns.size(); i++ ) {
        		IMetadataColumn column = columns.get( i );
        		JavaType javaType = JavaTypesManager.getJavaTypeFromId( column.getTalendType());
        		
        		String defaultValue = JavaTypesManager.getDefaultValueFromJavaIdType( column.getTalendType(), column.isNullable());
        		boolean primitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());

    stringBuffer.append(TEXT_6);
    stringBuffer.append( conn.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( defaultValue );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_11);
    
					
				// Date are passed as a timestamp
	    		if( javaType == JavaTypesManager.DATE ) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append( conn.getName() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_14);
    	
	    		}
	    
	    		// Byte[]
	    		else if( javaType == JavaTypesManager.BYTE_ARRAY ) {

    stringBuffer.append(TEXT_15);
    stringBuffer.append( conn.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_17);
    		
				}
			
				// Big decimals
				else if( javaType == JavaTypesManager.BIGDECIMAL ) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append( column.getPrecision() == null? conn.getName() + "." 
							+ column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" 
							+ column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_19);
    
				}
			
				// Others
				else {

    stringBuffer.append(TEXT_20);
    stringBuffer.append( conn.getName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_22);
    			
				}

    stringBuffer.append(TEXT_23);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_30);
    				
				
				// Handle nillable elements
				if( defaultValue != null ) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append( defaultValue );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_37);
    					
				}
				else if( column.isNullable()) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_43);
    
				}
      	}	// end of second "for" loop
    	}	// end of first "for" loop
  	}

    stringBuffer.append(TEXT_44);
    return stringBuffer.toString();
  }
}
