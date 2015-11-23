package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Map;

public class TFileArchiveMainJava
{
  protected static String nl;
  public static synchronized TFileArchiveMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileArchiveMainJava result = new TFileArchiveMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t";
  protected final String TEXT_31 = NL + NL + NL + "    String sourceDir_";
  protected final String TEXT_32 = " = ";
  protected final String TEXT_33 = ";      " + NL + "    String zipFile_";
  protected final String TEXT_34 = " = ";
  protected final String TEXT_35 = ";" + NL + "    " + NL + "    com.talend.compress.zip.Zip zip_";
  protected final String TEXT_36 = " = new com.talend.compress.zip.Zip(sourceDir_";
  protected final String TEXT_37 = ", zipFile_";
  protected final String TEXT_38 = ");" + NL + "    zip_";
  protected final String TEXT_39 = ".setOverwriteExistTargetZip(";
  protected final String TEXT_40 = ");" + NL + "\tzip_";
  protected final String TEXT_41 = ".setMakeTargetDir(";
  protected final String TEXT_42 = ");" + NL + "\tint level_";
  protected final String TEXT_43 = " = ";
  protected final String TEXT_44 = ";" + NL + "\tzip_";
  protected final String TEXT_45 = ".setCompressLevel(level_";
  protected final String TEXT_46 = ");" + NL + "\tzip_";
  protected final String TEXT_47 = ".setAllFiles(";
  protected final String TEXT_48 = ");" + NL + "    zip_";
  protected final String TEXT_49 = ".setContainSubDir(";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = "  " + NL + "    \t//build filename pattern filter" + NL + "\t    String[] patterns_";
  protected final String TEXT_52 = " = new String[";
  protected final String TEXT_53 = "];" + NL + "    \t";
  protected final String TEXT_54 = NL + "\t        patterns_";
  protected final String TEXT_55 = "[";
  protected final String TEXT_56 = "] = ";
  protected final String TEXT_57 = ";";
  protected final String TEXT_58 = NL + "  \t\tStringBuilder sbf_";
  protected final String TEXT_59 = " = new StringBuilder(); " + NL + "        sbf_";
  protected final String TEXT_60 = ".append(\"(\");" + NL + "        for (int i_";
  protected final String TEXT_61 = " = 0 ; i_";
  protected final String TEXT_62 = " < patterns_";
  protected final String TEXT_63 = ".length ; i_";
  protected final String TEXT_64 = "++) {" + NL + "            sbf_";
  protected final String TEXT_65 = ".append(patterns_";
  protected final String TEXT_66 = "[i_";
  protected final String TEXT_67 = "].replaceAll(\"\\\\.\", \"\\\\\\\\.\").replaceAll(\"\\\\*\", \".*\"));" + NL + "            if(i_";
  protected final String TEXT_68 = " != patterns_";
  protected final String TEXT_69 = ".length-1) sbf_";
  protected final String TEXT_70 = ".append(\"|\");" + NL + "        }        " + NL + "        sbf_";
  protected final String TEXT_71 = ".append(\")\");" + NL + "        final String maskStr_";
  protected final String TEXT_72 = " = new String(sbf_";
  protected final String TEXT_73 = ".toString());" + NL + "        " + NL + "        //apply the filter" + NL + "       \tzip_";
  protected final String TEXT_74 = ".setNamePatternFilter(maskStr_";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = "     " + NL + "   \t" + NL + "   zip_";
  protected final String TEXT_77 = ".setEncoding(";
  protected final String TEXT_78 = ");" + NL + "   zip_";
  protected final String TEXT_79 = ".setZip64Mode(\"";
  protected final String TEXT_80 = "\");" + NL + "   zip_";
  protected final String TEXT_81 = ".setEncrypted(";
  protected final String TEXT_82 = ");" + NL + "\t        ";
  protected final String TEXT_83 = NL + "    ";
  protected final String TEXT_84 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_85 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_88 = " = ";
  protected final String TEXT_89 = "; ";
  protected final String TEXT_90 = NL + "    " + NL + "   zip_";
  protected final String TEXT_91 = ".setPassword(decryptedPassword_";
  protected final String TEXT_92 = ");" + NL + "   zip_";
  protected final String TEXT_93 = ".setUseAesEncryption(";
  protected final String TEXT_94 = ");" + NL + "  " + NL + "   zip_";
  protected final String TEXT_95 = ".doZip();" + NL + "   \t  " + NL + "   globalMap.put(\"";
  protected final String TEXT_96 = "_ARCHIVE_FILEPATH\",zipFile_";
  protected final String TEXT_97 = ");" + NL + "   globalMap.put(\"";
  protected final String TEXT_98 = "_ARCHIVE_FILENAME\",(";
  protected final String TEXT_99 = ").contains(\"\\\\\")?" + NL + "    (";
  protected final String TEXT_100 = ").substring(((";
  protected final String TEXT_101 = ").lastIndexOf(\"\\\\\")+2)): (";
  protected final String TEXT_102 = ").substring(((";
  protected final String TEXT_103 = ").lastIndexOf(\"/\"))+1));" + NL;
  protected final String TEXT_104 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_30);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();	

	String directory = ElementParameterParser.getValue(node, "__SOURCE__");
	String zipFile = ElementParameterParser.getValue(node, "__TARGET__");
	String level = ElementParameterParser.getValue(node, "__LEVEL__");
	boolean mkDir = ("true").equals(ElementParameterParser.getValue(node, "__MKDIR__"));
	boolean isAllFile = ("true").equals(ElementParameterParser.getValue(node, "__ALL_FILES__"));
	boolean subDir = ("true").equals(ElementParameterParser.getValue(node, "__SUB_DIRECTROY__"));
	boolean overwrite = ("true").equals(ElementParameterParser.getValue(node, "__OVERWRITE__"));
	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	boolean isEncrypted = ("true").equals(ElementParameterParser.getValue(node, "__ENCRYPT_FILES__"));
	
	List<Map<String, String>> masks = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MASK__");	
	
	String zip64Mode = ElementParameterParser.getValue(node, "__ZIP64_MODE__");
	String encryptMethod = ElementParameterParser.getValue(node, "__ENCRYPT_METHOD__");

	log4jFileUtil.componentStartInfo(node);
	
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(directory );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(zipFile );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(overwrite);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(mkDir);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(level );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(isAllFile);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(subDir);
    stringBuffer.append(TEXT_50);
     
	if (!isAllFile) {
    
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(masks.size());
    stringBuffer.append(TEXT_53);
    
	    for(int i=0 ; i < masks.size() ; i++) {
	        Map<String, String> line = masks.get(i);
        
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(line.get("FILEMASK"));
    stringBuffer.append(TEXT_57);
    
	    }
	    
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
     
   }
   
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(zip64Mode);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(isEncrypted);
    stringBuffer.append(TEXT_82);
    
   String passwordFieldName = "__PASSWORD__";
   
    stringBuffer.append(TEXT_83);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_86);
    } else {
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append("AES256".equals(encryptMethod));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(zipFile );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(zipFile );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(zipFile );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(zipFile );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(zipFile );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(TEXT_104);
    return stringBuffer.toString();
  }
}
