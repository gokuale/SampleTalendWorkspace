package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.EConnectionType;
import java.util.List;
import java.util.Map;

public class TRecordMatchingOutBeginJava
{
  protected static String nl;
  public static synchronized TRecordMatchingOutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRecordMatchingOutBeginJava result = new TRecordMatchingOutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  " + NL + "  class SortableRow_";
  protected final String TEXT_2 = " implements Comparable<SortableRow_";
  protected final String TEXT_3 = ">, routines.system.IPersistableRow<SortableRow_";
  protected final String TEXT_4 = "> {";
  protected final String TEXT_5 = NL + "        ";
  protected final String TEXT_6 = " exprKey_";
  protected final String TEXT_7 = "__";
  protected final String TEXT_8 = ";";
  protected final String TEXT_9 = NL + "      ";
  protected final String TEXT_10 = " ";
  protected final String TEXT_11 = "__";
  protected final String TEXT_12 = ";";
  protected final String TEXT_13 = "    " + NL + "    " + NL + "    public void fillFrom(";
  protected final String TEXT_14 = "Struct ";
  protected final String TEXT_15 = NL + "        ";
  protected final String TEXT_16 = NL + "    ){        ";
  protected final String TEXT_17 = NL + "        this.";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ";";
  protected final String TEXT_21 = NL + "        this.";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ";";
  protected final String TEXT_24 = NL + "        " + NL + "    }" + NL + "    " + NL + "    public void copyDataTo(";
  protected final String TEXT_25 = "Struct ";
  protected final String TEXT_26 = "){";
  protected final String TEXT_27 = NL + "        ";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = " = this.";
  protected final String TEXT_30 = ";";
  protected final String TEXT_31 = NL + "    }" + NL + "    " + NL + "    public String toString(){" + NL + "      StringBuilder sb = new StringBuilder();" + NL + "      sb.append(super.toString());" + NL + "      sb.append(\"[\");";
  protected final String TEXT_32 = NL + "        sb.append(";
  protected final String TEXT_33 = ");" + NL + "        sb.append(\"=\");" + NL + "        sb.append(String.valueOf(this.";
  protected final String TEXT_34 = "));";
  protected final String TEXT_35 = NL + "      sb.append(\"]\");" + NL + "      return sb.toString();      " + NL + "    }" + NL + "" + NL + "    public int compareTo(SortableRow_";
  protected final String TEXT_36 = " other){" + NL + "      int returnValue = 0;";
  protected final String TEXT_37 = NL + "        returnValue = checkNullsAndCompare(this.";
  protected final String TEXT_38 = ",  other.";
  protected final String TEXT_39 = ");" + NL + "        " + NL + "        if (returnValue != 0) {" + NL + "          return returnValue;" + NL + "        }                      ";
  protected final String TEXT_40 = NL + "      return returnValue;" + NL + "    }   " + NL + "" + NL + "    private int checkNullsAndCompare(Object object1, Object object2) {" + NL + "      int returnValue = 0;" + NL + "      if (object1 instanceof Comparable && object2 instanceof Comparable) {" + NL + "        returnValue = ((Comparable) object1).compareTo(object2);" + NL + "      } else if (object1 != null && object2 != null) {" + NL + "        returnValue = compareStrings(object1.toString(), object2.toString());" + NL + "      } else if (object1 == null && object2 != null) {" + NL + "        returnValue = 1;" + NL + "      } else if (object1 != null && object2 == null) {" + NL + "        returnValue = -1;" + NL + "      } else {" + NL + "        returnValue = 0;" + NL + "      }" + NL + "      return returnValue;" + NL + "    }" + NL + "" + NL + "    private int compareStrings(String string1, String string2) {" + NL + "      return string1.compareTo(string2);" + NL + "    }" + NL + "        " + NL + "    public void readData(ObjectInputStream dis) {" + NL + "      synchronized(";
  protected final String TEXT_41 = "Struct.commonByteArrayLock_";
  protected final String TEXT_42 = "_";
  protected final String TEXT_43 = ") {" + NL + "        try {" + NL + "          int length = 0;";
  protected final String TEXT_44 = NL + "              this.";
  protected final String TEXT_45 = "__";
  protected final String TEXT_46 = " = dis.read";
  protected final String TEXT_47 = "();";
  protected final String TEXT_48 = NL + "              length = dis.readInt();" + NL + "              " + NL + "              if (length == -1) {" + NL + "                this.";
  protected final String TEXT_49 = "__";
  protected final String TEXT_50 = " = null;" + NL + "              } else {" + NL + "                if(length > ";
  protected final String TEXT_51 = "Struct.commonByteArray_";
  protected final String TEXT_52 = "_";
  protected final String TEXT_53 = ".length) {" + NL + "                  if(length < 1024 && ";
  protected final String TEXT_54 = "Struct.commonByteArray_";
  protected final String TEXT_55 = "_";
  protected final String TEXT_56 = ".length == 0) {";
  protected final String TEXT_57 = NL + "                    ";
  protected final String TEXT_58 = "Struct.commonByteArray_";
  protected final String TEXT_59 = "_";
  protected final String TEXT_60 = " = new byte[1024];" + NL + "                  } else {";
  protected final String TEXT_61 = NL + "                    ";
  protected final String TEXT_62 = "Struct.commonByteArray_";
  protected final String TEXT_63 = "_";
  protected final String TEXT_64 = " = new byte[2 * length];" + NL + "                  }" + NL + "                }" + NL + "                dis.readFully(";
  protected final String TEXT_65 = "Struct.commonByteArray_";
  protected final String TEXT_66 = "_";
  protected final String TEXT_67 = ", 0, length);" + NL + "                this.";
  protected final String TEXT_68 = "__";
  protected final String TEXT_69 = " = new String(";
  protected final String TEXT_70 = "Struct.commonByteArray_";
  protected final String TEXT_71 = "_";
  protected final String TEXT_72 = ", 0, length);" + NL + "              }";
  protected final String TEXT_73 = NL + "              length = dis.readByte();" + NL + "              if (length == -1) {" + NL + "                this.";
  protected final String TEXT_74 = "__";
  protected final String TEXT_75 = " = null;" + NL + "              } else {" + NL + "                this.";
  protected final String TEXT_76 = "__";
  protected final String TEXT_77 = " = new Date(dis.readLong());" + NL + "              }";
  protected final String TEXT_78 = NL + "              length = dis.readInt();" + NL + "              if (length == -1) {" + NL + "                this.";
  protected final String TEXT_79 = "__";
  protected final String TEXT_80 = " = null;" + NL + "              } else {" + NL + "                byte[] byteArray = new byte[length];" + NL + "                dis.readFully(byteArray);" + NL + "                this.";
  protected final String TEXT_81 = "__";
  protected final String TEXT_82 = " = byteArray;" + NL + "              }";
  protected final String TEXT_83 = NL + "              this.";
  protected final String TEXT_84 = "__";
  protected final String TEXT_85 = " = (";
  protected final String TEXT_86 = ") dis.readObject();" + NL + "        ";
  protected final String TEXT_87 = NL + "              length = dis.readByte();" + NL + "              " + NL + "              if (length == -1) {" + NL + "                this.";
  protected final String TEXT_88 = "__";
  protected final String TEXT_89 = " = null;" + NL + "              } else {" + NL + "                this.";
  protected final String TEXT_90 = "__";
  protected final String TEXT_91 = " = dis.read";
  protected final String TEXT_92 = "();" + NL + "              }";
  protected final String TEXT_93 = NL + "              this.";
  protected final String TEXT_94 = " = dis.read";
  protected final String TEXT_95 = "();";
  protected final String TEXT_96 = NL + "              length = dis.readInt();" + NL + "              if (length == -1) {" + NL + "                this.";
  protected final String TEXT_97 = " = null;" + NL + "              } else {" + NL + "                if (length > ";
  protected final String TEXT_98 = "Struct.commonByteArray_";
  protected final String TEXT_99 = "_";
  protected final String TEXT_100 = ".length) {" + NL + "                  if(length < 1024 && ";
  protected final String TEXT_101 = "Struct.commonByteArray_";
  protected final String TEXT_102 = "_";
  protected final String TEXT_103 = ".length == 0) {";
  protected final String TEXT_104 = NL + "                    ";
  protected final String TEXT_105 = "Struct.commonByteArray_";
  protected final String TEXT_106 = "_";
  protected final String TEXT_107 = " = new byte[1024];" + NL + "                  } else {";
  protected final String TEXT_108 = NL + "                    ";
  protected final String TEXT_109 = "Struct.commonByteArray_";
  protected final String TEXT_110 = "_";
  protected final String TEXT_111 = " = new byte[2 * length];" + NL + "                  }" + NL + "                }" + NL + "                dis.readFully(";
  protected final String TEXT_112 = "Struct.commonByteArray_";
  protected final String TEXT_113 = "_";
  protected final String TEXT_114 = ", 0, length);" + NL + "                this.";
  protected final String TEXT_115 = " = new String(";
  protected final String TEXT_116 = "Struct.commonByteArray_";
  protected final String TEXT_117 = "_";
  protected final String TEXT_118 = ", 0, length);" + NL + "              }";
  protected final String TEXT_119 = NL + "              length = dis.readByte();" + NL + "              if (length == -1) {" + NL + "                this.";
  protected final String TEXT_120 = " = null;" + NL + "              } else {" + NL + "                this.";
  protected final String TEXT_121 = " = new Date(dis.readLong());" + NL + "              }";
  protected final String TEXT_122 = NL + "              length = dis.readInt();" + NL + "              if (length == -1) {" + NL + "                this.";
  protected final String TEXT_123 = " = null;" + NL + "              } else {" + NL + "                byte[] byteArray = new byte[length];" + NL + "                dis.readFully(byteArray);" + NL + "                this.";
  protected final String TEXT_124 = " = byteArray;" + NL + "              }";
  protected final String TEXT_125 = NL + "              this.";
  protected final String TEXT_126 = " = (";
  protected final String TEXT_127 = ") dis.readObject();" + NL + "          ";
  protected final String TEXT_128 = NL + "              length = dis.readByte();" + NL + "              if (length == -1) {" + NL + "                this.";
  protected final String TEXT_129 = " = null;" + NL + "              } else {" + NL + "                this.";
  protected final String TEXT_130 = " = dis.read";
  protected final String TEXT_131 = "();" + NL + "              }";
  protected final String TEXT_132 = NL + "            } catch (IOException e) {" + NL + "              throw new RuntimeException(e);";
  protected final String TEXT_133 = NL + "            } catch(ClassNotFoundException eCNFE) {" + NL + "              throw new RuntimeException(eCNFE);";
  protected final String TEXT_134 = NL + "        }" + NL + "      }" + NL + "    }" + NL + "              " + NL + "    public void writeData(ObjectOutputStream dos) {" + NL + "      try {";
  protected final String TEXT_135 = NL + "            dos.write";
  protected final String TEXT_136 = "(this.";
  protected final String TEXT_137 = "__";
  protected final String TEXT_138 = ");";
  protected final String TEXT_139 = NL + "            if(this.";
  protected final String TEXT_140 = "__";
  protected final String TEXT_141 = " == null) {" + NL + "              dos.writeInt(-1);" + NL + "            } else {" + NL + "              byte[] byteArray = this.";
  protected final String TEXT_142 = "__";
  protected final String TEXT_143 = ".getBytes();" + NL + "              dos.writeInt(byteArray.length);" + NL + "              dos.write(byteArray);" + NL + "            }";
  protected final String TEXT_144 = NL + "            if(this.";
  protected final String TEXT_145 = "__";
  protected final String TEXT_146 = " == null) {" + NL + "              dos.writeByte(-1);" + NL + "            } else {" + NL + "              dos.writeByte(0);" + NL + "              dos.writeLong(this.";
  protected final String TEXT_147 = "__";
  protected final String TEXT_148 = ".getTime());" + NL + "            }";
  protected final String TEXT_149 = NL + "            if(this.";
  protected final String TEXT_150 = "__";
  protected final String TEXT_151 = " == null) {" + NL + "              dos.writeInt(-1);" + NL + "            } else {" + NL + "              dos.writeInt(this.";
  protected final String TEXT_152 = "__";
  protected final String TEXT_153 = ".length);" + NL + "              dos.write(this.";
  protected final String TEXT_154 = "__";
  protected final String TEXT_155 = ");" + NL + "            }";
  protected final String TEXT_156 = NL + "            dos.writeObject(this.";
  protected final String TEXT_157 = "__";
  protected final String TEXT_158 = ");" + NL + "          ";
  protected final String TEXT_159 = NL + "            if(this.";
  protected final String TEXT_160 = "__";
  protected final String TEXT_161 = " == null) {" + NL + "              dos.writeByte(-1);" + NL + "            } else {" + NL + "              dos.writeByte(0);" + NL + "              dos.write";
  protected final String TEXT_162 = "(this.";
  protected final String TEXT_163 = "__";
  protected final String TEXT_164 = ");" + NL + "            }";
  protected final String TEXT_165 = NL + "        // == key == //";
  protected final String TEXT_166 = NL + "            dos.write";
  protected final String TEXT_167 = "(this.";
  protected final String TEXT_168 = ");";
  protected final String TEXT_169 = NL + "            if(this.";
  protected final String TEXT_170 = " == null) {" + NL + "              dos.writeInt(-1);" + NL + "            } else {" + NL + "              byte[] byteArray = this.";
  protected final String TEXT_171 = ".getBytes();" + NL + "              dos.writeInt(byteArray.length);" + NL + "              dos.write(byteArray);" + NL + "            }";
  protected final String TEXT_172 = NL + "            if(this.";
  protected final String TEXT_173 = " == null) {" + NL + "              dos.writeByte(-1);" + NL + "            } else {" + NL + "              dos.writeByte(0);" + NL + "              dos.writeLong(this.";
  protected final String TEXT_174 = ".getTime());" + NL + "            }";
  protected final String TEXT_175 = NL + "            if(this.";
  protected final String TEXT_176 = " == null) {" + NL + "              dos.writeInt(-1);" + NL + "            } else {" + NL + "              dos.writeInt(this.";
  protected final String TEXT_177 = ".length);" + NL + "              dos.write(this.";
  protected final String TEXT_178 = ");" + NL + "            }";
  protected final String TEXT_179 = NL + "            dos.writeObject(this.";
  protected final String TEXT_180 = ");" + NL + "          ";
  protected final String TEXT_181 = NL + "            if(this.";
  protected final String TEXT_182 = " == null) {" + NL + "              dos.writeByte(-1);" + NL + "            } else {" + NL + "              dos.writeByte(0);" + NL + "              dos.write";
  protected final String TEXT_183 = "(this.";
  protected final String TEXT_184 = ");" + NL + "            }";
  protected final String TEXT_185 = NL + "          } catch (IOException e) {" + NL + "            throw new RuntimeException(e);";
  protected final String TEXT_186 = NL + "          } catch (Exception e) {" + NL + "            throw new RuntimeException(e);";
  protected final String TEXT_187 = "  " + NL + "      }" + NL + "    }" + NL + "  }" + NL + "  " + NL + "  org.talend.designer.components.lookup.persistent.PersistentRowSorterIterator<SortableRow_";
  protected final String TEXT_188 = "> fsi_";
  protected final String TEXT_189 = " = " + NL + "    new org.talend.designer.components.lookup.persistent.PersistentRowSorterIterator<SortableRow_";
  protected final String TEXT_190 = ">(";
  protected final String TEXT_191 = NL + "      ";
  protected final String TEXT_192 = " + \"/\"+ jobName +\"_tMapData_\" + pid +\"_";
  protected final String TEXT_193 = "\", ";
  protected final String TEXT_194 = ") {" + NL + "      public SortableRow_";
  protected final String TEXT_195 = " createRowInstance() {" + NL + "        return new SortableRow_";
  protected final String TEXT_196 = "();" + NL + "      }" + NL + "  };" + NL + "  fsi_";
  protected final String TEXT_197 = ".initPut();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
cid = cid.replace("_RecordMatchingOut", "");
List<? extends IConnection> inConns = node.getIncomingConnections();
IConnection inMainCon = null, inLookupCon = null;
String connNameMain = null, connNameLookUp = null;

for (IConnection connIn : inConns){  
  if (connIn.getLineStyle().equals(EConnectionType.FLOW_REF)){
    inLookupCon = connIn;
    connNameLookUp = connIn.getName();
  } else if (connIn.getLineStyle().equals(EConnectionType.FLOW_MAIN)){ 
    inMainCon = connIn;  
    connNameMain = connIn.getName();
  } 
}
  
if (connNameLookUp == null || connNameMain == null){
  return "";
}
List<IMetadataTable> metadatas = node.getMetadataList();
 
if ((metadatas != null)&&(metadatas.size() > 0)) {
  IMetadataTable metadata = metadatas.get(0);
  List<Map<String, String>> listMapJoinCols = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__JOIN_KEY__");
  
  if (listMapJoinCols == null || listMapJoinCols.size() == 0){
    return "";
  }
  String sTmpDir = ElementParameterParser.getValue(node, "__TMP_DIRECTORY__"); 
  String sBufferSize = ElementParameterParser.getValue(node, "__ROWS_BUFFER_SIZE__"); 
  List<Map<String, String>> listBlocking = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BLOCKING_DEFINITION__");
  List<String> listBlockingColsName = new java.util.ArrayList();
  
  for (Map<String, String> mapBlocking : listBlocking){
    listBlockingColsName.add(mapBlocking.get("LOOKUP_COLUMN"));
  }
  
    stringBuffer.append(TEXT_1);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_4);
    
    /*annouce variables*/
    List<String[]> listExprKeys = new java.util.ArrayList<String[]>();
    IMetadataTable lookupMetadata = inLookupCon.getMetadataTable();   
    List<IMetadataColumn> lookupColumns = lookupMetadata.getListColumns();
  
    for (IMetadataColumn lookupColumn : lookupColumns){
      String sLookupColumnName = lookupColumn.getLabel();
      String sLookupColumnType = JavaTypesManager.getTypeToGenerate(lookupColumn.getTalendType(), lookupColumn.isNullable());
      if (listBlockingColsName.contains(sLookupColumnName)){
      
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sLookupColumnType);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(sLookupColumnName);
    stringBuffer.append(TEXT_8);
    
        listExprKeys.add(new String[]{sLookupColumnType, " exprKey_" + connNameLookUp + "__" + sLookupColumnName});
      }
    }
    List<String[]> listPreColumns = new java.util.ArrayList<String[]>();
    IMetadataTable preMetadata = inMainCon.getMetadataTable();   
    List<IMetadataColumn> preColumns = preMetadata.getListColumns();
  
    for (IMetadataColumn preColumn : preColumns){
      String sPreColumnName = preColumn.getLabel();
      String sPreColumnType = JavaTypesManager.getTypeToGenerate(preColumn.getTalendType(), preColumn.isNullable());
      
    stringBuffer.append(TEXT_9);
    stringBuffer.append(sPreColumnType);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(sPreColumnName);
    stringBuffer.append(TEXT_12);
    
      listPreColumns.add(new String[]{sPreColumnType, connNameMain + "__" + sPreColumnName});
    }
    
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connNameMain);
    
      StringBuffer sb = new StringBuffer();
      
      for (Object entry : listExprKeys){
        sb.append(",").append(((String[])entry)[0]).append(" ").append(((String[])entry)[1]);
      }
      
    stringBuffer.append(TEXT_15);
    stringBuffer.append(sb.toString());
    stringBuffer.append(TEXT_16);
    
      for (Object entry : listPreColumns){
      
    stringBuffer.append(TEXT_17);
    stringBuffer.append(((String[])entry)[1]);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(preColumns.get(listPreColumns.indexOf(entry)).getLabel());
    stringBuffer.append(TEXT_20);
    
      }
      
      for (Object entry : listExprKeys){
      
    stringBuffer.append(TEXT_21);
    stringBuffer.append(((String[])entry)[1]);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(((String[])entry)[1]);
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_26);
    
      for (Object entry : listPreColumns){
      
    stringBuffer.append(TEXT_27);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(preColumns.get(listPreColumns.indexOf(entry)).getLabel());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(((String[])entry)[1]);
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    
      for (Object entry : listPreColumns){
      
    stringBuffer.append(TEXT_32);
    stringBuffer.append(((String[])entry)[1]);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(((String[])entry)[1]);
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_36);
    
      for (Object entry : listExprKeys){
      
    stringBuffer.append(TEXT_37);
    stringBuffer.append(((String[])entry)[1]);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(((String[])entry)[1]);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_43);
    
          boolean hasAtLeastOneRead = false, hasAtLeastOneObjectType = false;
          
          for (IMetadataColumn mainColumn : preColumns){
            hasAtLeastOneRead = true;
            JavaType javaType = JavaTypesManager.getJavaTypeFromId(mainColumn.getTalendType());
            String typeToGenerate = JavaTypesManager.getTypeToGenerate(mainColumn.getTalendType(), mainColumn.isNullable());
               
            if (JavaTypesManager.isJavaPrimitiveType(mainColumn.getTalendType(), mainColumn.isNullable())){
              typeToGenerate = typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
              
    stringBuffer.append(TEXT_44);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_47);
    
            } else if ("String".equals(typeToGenerate)){
            
    stringBuffer.append(TEXT_48);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_72);
    
            } else if ("java.util.Date".equals(typeToGenerate)){
            
    stringBuffer.append(TEXT_73);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_77);
    
            } else if ("byte[]".equals(typeToGenerate)){
            
    stringBuffer.append(TEXT_78);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_82);
    
            } else if("Object".equals(typeToGenerate) || "BigDecimal".equals(typeToGenerate) || "List".equals(typeToGenerate)) {
              hasAtLeastOneObjectType = true;
              
    stringBuffer.append(TEXT_83);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_86);
    
            } else {
              typeToGenerate = JavaTypesManager.getTypeToGenerate(mainColumn.getTalendType(), false);
              typeToGenerate = typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
              
    stringBuffer.append(TEXT_87);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_92);
    
            }
          }
           
          for (IMetadataColumn column : lookupColumns){
            String sColumnName = column.getLabel(); 
            String sType = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
          
            if (!listBlockingColsName.contains(sColumnName)){
              continue;
            }
            hasAtLeastOneRead = true;
            sColumnName = "exprKey_" + connNameLookUp + "__" + sColumnName;
          
            if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
              sType = sType.substring(0,1).toUpperCase() + sType.substring(1);
              
    stringBuffer.append(TEXT_93);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(sType);
    stringBuffer.append(TEXT_95);
    
            } else if ("String".equals(sType)){
            
    stringBuffer.append(TEXT_96);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(connNameLookUp);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_118);
    
            } else if ("java.util.Date".equals(sType)){
            
    stringBuffer.append(TEXT_119);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_121);
    
            } else if ("byte[]".equals(sType)){
            
    stringBuffer.append(TEXT_122);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_124);
    
            } else if("Object".equals(sType) || "BigDecimal".equals(sType) || "List".equals(sType)) {
              hasAtLeastOneObjectType = true;
              
    stringBuffer.append(TEXT_125);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(sType);
    stringBuffer.append(TEXT_127);
    
            } else {
              sType = JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
              sType = sType.substring(0,1).toUpperCase() + sType.substring(1);
              
    stringBuffer.append(TEXT_128);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(sType);
    stringBuffer.append(TEXT_131);
    
            }
          }
             
          if(hasAtLeastOneRead) {
          
    stringBuffer.append(TEXT_132);
    
          }
          if(hasAtLeastOneObjectType) {
          
    stringBuffer.append(TEXT_133);
    
          }
          
    stringBuffer.append(TEXT_134);
    
        boolean hasAtLeastOneWrite = false;
        
        for (IMetadataColumn mainColumn : preColumns){
          hasAtLeastOneWrite = true;
          JavaType javaType = JavaTypesManager.getJavaTypeFromId(mainColumn.getTalendType());
          String typeToGenerate = JavaTypesManager.getTypeToGenerate(mainColumn.getTalendType(), mainColumn.isNullable());
          
          if (JavaTypesManager.isJavaPrimitiveType(mainColumn.getTalendType(), mainColumn.isNullable())){
            typeToGenerate = typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
          
    stringBuffer.append(TEXT_135);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_138);
    
          } else if ("String".equals(typeToGenerate)){
          
    stringBuffer.append(TEXT_139);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_141);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_143);
    
          } else if ("java.util.Date".equals(typeToGenerate)){
          
    stringBuffer.append(TEXT_144);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_148);
    
          } else if ("byte[]".equals(typeToGenerate)){
          
    stringBuffer.append(TEXT_149);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_155);
    
          } else if("Object".equals(typeToGenerate) || "BigDecimal".equals(typeToGenerate) || "List".equals(typeToGenerate)) {
          
    stringBuffer.append(TEXT_156);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_158);
    
          } else {
            typeToGenerate=JavaTypesManager.getTypeToGenerate(mainColumn.getTalendType(), false);
            typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            
    stringBuffer.append(TEXT_159);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_161);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(mainColumn.getLabel());
    stringBuffer.append(TEXT_164);
    
          }
        }
        
    stringBuffer.append(TEXT_165);
    
        for (IMetadataColumn column : lookupColumns){
          String sColumnName = column.getLabel(); 
          String sType = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
          
          if (!listBlockingColsName.contains(sColumnName)){
            continue;
          }
          hasAtLeastOneWrite = true;
          sColumnName = "exprKey_" + connNameLookUp + "__" + sColumnName;
          
          if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
            sType = sType.substring(0,1).toUpperCase() + sType.substring(1);
            
    stringBuffer.append(TEXT_166);
    stringBuffer.append(sType);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_168);
    
          } else if ("String".equals(sType)){
          
    stringBuffer.append(TEXT_169);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_171);
    
          } else if ("java.util.Date".equals(sType)){
          
    stringBuffer.append(TEXT_172);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_174);
    
          } else if ("byte[]".equals(sType)) {
          
    stringBuffer.append(TEXT_175);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_178);
    
          } else if ("Object".equals(sType) || "BigDecimal".equals(sType) || "List".equals(sType)) {
          
    stringBuffer.append(TEXT_179);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_180);
    
          } else {
            sType = JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
            sType = sType.substring(0,1).toUpperCase() + sType.substring(1);
            
    stringBuffer.append(TEXT_181);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(sType);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_184);
    
          }
        }
        
        if(hasAtLeastOneWrite) {
        
    stringBuffer.append(TEXT_185);
    } else {
    stringBuffer.append(TEXT_186);
    }
    stringBuffer.append(TEXT_187);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(sTmpDir);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(sBufferSize);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_197);
    
}

    return stringBuffer.toString();
  }
}
