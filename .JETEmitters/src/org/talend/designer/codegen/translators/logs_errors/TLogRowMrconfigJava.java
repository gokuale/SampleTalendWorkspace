package org.talend.designer.codegen.translators.logs_errors;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TLogRowMrconfigJava
{
  protected static String nl;
  public static synchronized TLogRowMrconfigJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLogRowMrconfigJava result = new TLogRowMrconfigJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t";
  protected final String TEXT_3 = NL + "\t\t\tString outputPath_";
  protected final String TEXT_4 = " = genTempFolderForComponent(\"";
  protected final String TEXT_5 = "\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\t\tMultipleOutputs.setOutputFormat(job, \"";
  protected final String TEXT_7 = "\", ";
  protected final String TEXT_8 = "StructOutputFormat.class, outputPath_";
  protected final String TEXT_9 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\tjob.setOutputFormat(";
  protected final String TEXT_11 = "StructOutputFormat.class);" + NL + "\t\t\t\t\t";
  protected final String TEXT_12 = "StructOutputFormat" + NL + "\t\t\t\t\t\t\t.setOutputPath(" + NL + "\t\t\t\t\t\t\t\t\tjob," + NL + "\t\t\t\t\t\t\t\t\tnew Path(" + NL + "\t\t\t\t\t\t\t\t\t\t\toutputPath_";
  protected final String TEXT_13 = "));" + NL + "\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\tfs.delete(new Path(outputPath_";
  protected final String TEXT_15 = "),true);" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
/**
 * This helper class provides utilities for generating code when there are multiple outgoing connections, specifically
 * those that provide a main connection and a reject connection. When both are present, this class helps determine where
 * to send or retrieve the data for a given connection.
 *
 * Normally, for efficiency reasons, the main output continues along a chain of Mapper/Reducer classes and the reject
 * output is sent to a MultipleOutputs to start a new chain.
 *
 * TODO: the file mr_multioutput_utils.javajet and MultipleOutputsComponentUtils.java need to be kept synchronized.
 */
class MultiOutputUtils {

    private static final String MAIN_FLOW_NAME = "FLOW"; //$NON-NLS-1$
    private static final String REJECT_FLOW_NAME = "REJECT"; //$NON-NLS-1$

    private static final String TAVROINPUT_COMPONENT_NAME = "tAvroInput"; //$NON-NLS-1$
    private static final String TEXTRACTDELIMITEDFIELDS_COMPONENT_NAME = "tExtractDelimitedFields"; //$NON-NLS-1$
    private static final String TEXTRACTFULLROW_COMPONENT_NAME = "tExtractFullRow"; //$NON-NLS-1$
    private static final String TEXTRACTJSONFIELDS_COMPONENT_NAME = "tExtractJSONFields"; //$NON-NLS-1$
    private static final String TEXTRACTABSTRACTJSONFIELDS_COMPONENT_NAME = "tExtractAbstractJSONFields"; //$NON-NLS-1$
    private static final String TEXTRACTPOSITIONALFIELDS_COMPONENT_NAME = "tExtractPositionalFields"; //$NON-NLS-1$
    private static final String TEXTRACTREGEXFIELDS_COMPONENT_NAME = "tExtractRegexFields"; //$NON-NLS-1$
    private static final String TEXTRACTXMLFIELD_COMPONENT_NAME = "tExtractXMLField"; //$NON-NLS-1$
    private static final String TFILEINPUTDELIMITED_COMPONENT_NAME = "tFileInputDelimited"; //$NON-NLS-1$
    private static final String TFILEINPUTFULLROW_COMPONENT_NAME = "tFileInputFullRow"; //$NON-NLS-1$
    private static final String TFILEINPUTJSON_COMPONENT_NAME = "tFileInputJSON"; //$NON-NLS-1$
    private static final String TFILEINPUTPOSITIONAL_COMPONENT_NAME = "tFileInputPositional"; //$NON-NLS-1$
    private static final String TFILEINPUTREGEX_COMPONENT_NAME = "tFileInputRegex"; //$NON-NLS-1$
    private static final String TFILEINPUTXML_COMPONENT_NAME = "tFileInputXML"; //$NON-NLS-1$
    private static final String THBASEINPUT_COMPONENT_NAME = "tHBaseInput"; //$NON-NLS-1$
    private static final String THDFSINPUT_COMPONENT_NAME = "tHDFSInput"; //$NON-NLS-1$
    private static final String TJDBCINPUT_COMPONENT_NAME = "tJDBCInput"; //$NON-NLS-1$

    private static final String TVIRTUALINPUTCOMPONENT_NAME = "tMRInput"; //$NON-NLS-1$

    /**
     * Check if the source of a connection may be a multipleOutput.
     *
     * @param connection current connection
     * @return true is the component may have a reject flow.
     */
    public boolean canBeAMultipleOutput(IConnection connection) {
        if ((connection == null) || (connection.getSource() == null) || (connection.getSource().getComponent() == null)) {
            return false;
        } else {
            return canBeAMultipleOutput(connection.getSource().getComponent().getName());
        }
    }

    /**
     * Check if a the name of a component is in the list of the multipleoutputs component.
     *
     * These component may have a reject flow for processing error. But we need to handle them just like they don't have
     * one.
     *
     * @param name of the comonent
     * @return true is the component may have a reject flow.
     */
    public boolean canBeAMultipleOutput(String name) {
        return name.equals(THDFSINPUT_COMPONENT_NAME) || name.equals(TJDBCINPUT_COMPONENT_NAME)
                || name.equals(TAVROINPUT_COMPONENT_NAME) || name.equals(THBASEINPUT_COMPONENT_NAME)
                || name.equals(TFILEINPUTJSON_COMPONENT_NAME) || name.equals(TEXTRACTJSONFIELDS_COMPONENT_NAME)
                || name.equals(TEXTRACTABSTRACTJSONFIELDS_COMPONENT_NAME)
                || name.equals(TFILEINPUTFULLROW_COMPONENT_NAME) || name.equals(TEXTRACTFULLROW_COMPONENT_NAME)
                || name.equals(TFILEINPUTDELIMITED_COMPONENT_NAME) || name.equals(TEXTRACTDELIMITEDFIELDS_COMPONENT_NAME)
                || name.equals(TEXTRACTREGEXFIELDS_COMPONENT_NAME) || name.equals(TFILEINPUTREGEX_COMPONENT_NAME)
                || name.equals(TFILEINPUTPOSITIONAL_COMPONENT_NAME) || name.equals(TEXTRACTPOSITIONALFIELDS_COMPONENT_NAME)
                || name.equals(TFILEINPUTXML_COMPONENT_NAME) || name.equals(TEXTRACTXMLFIELD_COMPONENT_NAME)
                || (name.startsWith(TVIRTUALINPUTCOMPONENT_NAME));
    }

    /**
     * Check if the current connection is a reject flow of a multiple output component.
     *
     * @param connection the current connection
     * @return true id the current connection is a reject flow
     */
    public boolean isRejectFlowOnMultipleOutput(IConnection connection) {
        if ((connection == null) || (connection.getSource() == null) || (connection.getSource().getComponent() == null)) {
            return false;
        } else {
            return isRejectFlowOnMultipleOutput(connection.getSource().getComponent().getName(), connection.getConnectorName());
        }
    }

    /**
     * Check if the current connection is a reject flow of a multiple output component.
     *
     * @param name of the component
     * @param connectorName name of the link
     * @return true id the current connection is a reject flow
     */
    public boolean isRejectFlowOnMultipleOutput(String name, String connectorName) {
        return canBeAMultipleOutput(name) && connectorName.equals(REJECT_FLOW_NAME);
    }

    /**
     * Check if the current connection is a reject flow of a multiple output component.
     *
     * @param connection the current connection
     * @return true id the current connection is a reject flow
     */
    public boolean isMainFlowOnMultipleOutput(IConnection connection) {
        if ((connection == null) || (connection.getSource() == null) || (connection.getSource().getComponent() == null)) {
            return false;
        } else {
            return isMainFlowOnMultipleOutput(connection.getSource().getComponent().getName(), connection.getConnectorName());
        }
    }

    /**
     * Check if the current connection is a main flow of a multiple output component.
     *
     * @param name of the component
     * @param connectorName bale fir the link
     * @return true id the current connection is a reject flow
     */
    public boolean isMainFlowOnMultipleOutput(String name, String connectorName) {
        return canBeAMultipleOutput(name) && connectorName.equals(MAIN_FLOW_NAME);
    }


}

    stringBuffer.append(TEXT_2);
    
	MultiOutputUtils mo = new MultiOutputUtils();
    BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();  
    String cid = node.getUniqueName();
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if((metadatas != null) && (metadatas.size() > 0)){
        IMetadataTable metadata = metadatas.get(0);
        if(metadata != null){
        
		    List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
		    if(inConns != null && inConns.size() > 0){

		    }else{
		        return "";
		    }
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			IConnection inConn = inConns.get(0);
			String connName = inConn.getName();
			List<? extends IConnection> sourceNodeOutConns = inConn.getSource().getOutgoingConnections(EConnectionType.FLOW_MAIN);
            if (sourceNodeOutConns != null && sourceNodeOutConns.size() > 0) {
            	boolean hasMultipleOutputs = sourceNodeOutConns.size() > 1;

            	// Check if it is a true multipleoutput
            	if (hasMultipleOutputs) {
            	    hasMultipleOutputs = !mo.isMainFlowOnMultipleOutput(inConn);
            	}
				if(hasMultipleOutputs){
				
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
				}else{
				
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
				}
			}
			
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
    	}
	}
	
    return stringBuffer.toString();
  }
}
