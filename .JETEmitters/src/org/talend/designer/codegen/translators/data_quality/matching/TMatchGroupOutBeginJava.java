package org.talend.designer.codegen.translators.data_quality.matching;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;
import java.util.Map;

public class TMatchGroupOutBeginJava
{
  protected static String nl;
  public static synchronized TMatchGroupOutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMatchGroupOutBeginJava result = new TMatchGroupOutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "class ";
  protected final String TEXT_2 = "Struct implements routines.system.";
  protected final String TEXT_3 = " {" + NL + "  final byte[] commonByteArrayLock_";
  protected final String TEXT_4 = "_";
  protected final String TEXT_5 = " = new byte[0];" + NL + "  byte[] commonByteArray_";
  protected final String TEXT_6 = "_";
  protected final String TEXT_7 = " = new byte[0];";
  protected final String TEXT_8 = NL + "    private  final int DEFAULT_HASHCODE = 1;" + NL + "    private  final int PRIME = 31;" + NL + "    private int hashCode = DEFAULT_HASHCODE;" + NL + "    public boolean hashCodeDirty = true;";
  protected final String TEXT_9 = NL + "    public ";
  protected final String TEXT_10 = " ";
  protected final String TEXT_11 = " = ' '";
  protected final String TEXT_12 = ";" + NL + "" + NL + "    public ";
  protected final String TEXT_13 = " get";
  protected final String TEXT_14 = " () {" + NL + "      return this.";
  protected final String TEXT_15 = ";" + NL + "    }";
  protected final String TEXT_16 = NL + "  public void copyDateToOut(";
  protected final String TEXT_17 = "Struct other){";
  protected final String TEXT_18 = NL + "      other.";
  protected final String TEXT_19 = " = this.";
  protected final String TEXT_20 = ";";
  protected final String TEXT_21 = NL + "  }" + NL + "    ";
  protected final String TEXT_22 = NL + "    @Override" + NL + "    public int hashCode() {" + NL + "      if (this.hashCodeDirty) {" + NL + "        final int prime = PRIME;" + NL + "        int result = DEFAULT_HASHCODE;" + NL + "        ";
  protected final String TEXT_23 = NL + "              result = prime * result + (this.";
  protected final String TEXT_24 = " ? 1231 : 1237);";
  protected final String TEXT_25 = NL + "              result = prime * result + (int) this.";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = NL + "            result = prime * result + java.util.Arrays.hashCode(this.";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "            result = prime * result + ((this.";
  protected final String TEXT_30 = " == null) ? 0 : this.";
  protected final String TEXT_31 = ".hashCode());";
  protected final String TEXT_32 = NL + "        this.hashCode = result;" + NL + "        this.hashCodeDirty = false;" + NL + "      }" + NL + "      return this.hashCode;" + NL + "    }" + NL + "    " + NL + "    @Override" + NL + "    public boolean equals(Object obj) {" + NL + "      if (this == obj)" + NL + "        return true;" + NL + "      if (obj == null)" + NL + "        return false;" + NL + "      if (getClass() != obj.getClass())" + NL + "        return false;" + NL + "      final ";
  protected final String TEXT_33 = "Struct other = (";
  protected final String TEXT_34 = "Struct) obj;" + NL + "      ";
  protected final String TEXT_35 = NL + "          if (this.";
  protected final String TEXT_36 = " != other.";
  protected final String TEXT_37 = ") {" + NL + "            return false;" + NL + "          }";
  protected final String TEXT_38 = "   " + NL + "          if(!java.util.Arrays.equals(this.";
  protected final String TEXT_39 = ", other.";
  protected final String TEXT_40 = ")) {" + NL + "            return false;" + NL + "          }";
  protected final String TEXT_41 = NL + "          if (this.";
  protected final String TEXT_42 = " == null) {" + NL + "            if (other.";
  protected final String TEXT_43 = " != null) " + NL + "              return false;" + NL + "          } else if (!this.";
  protected final String TEXT_44 = ".equals(other.";
  protected final String TEXT_45 = ")) " + NL + "            return false;";
  protected final String TEXT_46 = NL + "      return true;" + NL + "    }" + NL + "" + NL + "    public void copyDataTo(";
  protected final String TEXT_47 = "Struct other) {";
  protected final String TEXT_48 = NL + "        other.";
  protected final String TEXT_49 = " = this.";
  protected final String TEXT_50 = ";";
  protected final String TEXT_51 = NL + "    }" + NL + "    " + NL + "    public void copyKeysDataTo(";
  protected final String TEXT_52 = "Struct other) {";
  protected final String TEXT_53 = NL + "        other.";
  protected final String TEXT_54 = " = this.";
  protected final String TEXT_55 = ";";
  protected final String TEXT_56 = NL + "    }";
  protected final String TEXT_57 = NL + "        private String readString(ObjectInputStream dis) throws IOException{" + NL + "          String strReturn = null;" + NL + "          int length = 0;" + NL + "          length = dis.readInt();" + NL + "          " + NL + "          if (length == -1) {" + NL + "            strReturn = null;" + NL + "          } else {" + NL + "            if (length > commonByteArray_";
  protected final String TEXT_58 = "_";
  protected final String TEXT_59 = ".length) {" + NL + "              if (length < 1024 && commonByteArray_";
  protected final String TEXT_60 = "_";
  protected final String TEXT_61 = ".length == 0) {" + NL + "                commonByteArray_";
  protected final String TEXT_62 = "_";
  protected final String TEXT_63 = " = new byte[1024];" + NL + "              } else {" + NL + "                commonByteArray_";
  protected final String TEXT_64 = "_";
  protected final String TEXT_65 = " = new byte[2 * length];" + NL + "              }" + NL + "            }" + NL + "            dis.readFully(commonByteArray_";
  protected final String TEXT_66 = "_";
  protected final String TEXT_67 = ", 0, length);" + NL + "            strReturn = new String(commonByteArray_";
  protected final String TEXT_68 = "_";
  protected final String TEXT_69 = ", 0, length, utf8Charset);" + NL + "          }" + NL + "          return strReturn;" + NL + "        }" + NL + "  " + NL + "        private void writeString(String str, ObjectOutputStream dos) throws IOException{" + NL + "          if (str == null) {" + NL + "            dos.writeInt(-1);" + NL + "          } else {" + NL + "            byte[] byteArray = str.getBytes(utf8Charset);" + NL + "            dos.writeInt(byteArray.length);" + NL + "            dos.write(byteArray);" + NL + "          }" + NL + "        }" + NL + "        ";
  protected final String TEXT_70 = NL + NL + "        private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{" + NL + "          String strReturn = null;" + NL + "          int length = 0;" + NL + "          length = dis.readInt();" + NL + "          " + NL + "          if (length == -1) {" + NL + "            strReturn = null;" + NL + "          } else {" + NL + "            byte[] byteArray = new byte[length];" + NL + "            dis.read(byteArray);" + NL + "            strReturn = new String(byteArray, utf8Charset);" + NL + "          }" + NL + "          return strReturn;" + NL + "        }" + NL + "            " + NL + "        private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{" + NL + "          if (str == null) {" + NL + "            dos.writeInt(-1);" + NL + "          } else {" + NL + "            byte[] byteArray = str.getBytes(utf8Charset);" + NL + "            dos.writeInt(byteArray.length);" + NL + "            dos.write(byteArray);" + NL + "          }" + NL + "        }";
  protected final String TEXT_71 = NL + "        private java.util.Date readDate(ObjectInputStream dis) throws IOException{" + NL + "          java.util.Date dateReturn = null;" + NL + "          int length = 0;" + NL + "          length = dis.readByte();" + NL + "          " + NL + "          if (length == -1) {" + NL + "            dateReturn = null;" + NL + "          } else {" + NL + "            dateReturn = new Date(dis.readLong());" + NL + "          }" + NL + "          return dateReturn;" + NL + "        }" + NL + "              " + NL + "        private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{" + NL + "          if (date1 == null) {" + NL + "            dos.writeByte(-1);" + NL + "          } else {" + NL + "            dos.writeByte(0);" + NL + "            dos.writeLong(date1.getTime());" + NL + "          }" + NL + "        }";
  protected final String TEXT_72 = NL + "        private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{" + NL + "          java.util.Date dateReturn = null;" + NL + "          int length = 0;" + NL + "          length = dis.readByte();" + NL + "          " + NL + "          if (length == -1) {" + NL + "            dateReturn = null;" + NL + "          } else {" + NL + "            dateReturn = new Date(dis.readLong());" + NL + "          }" + NL + "          return dateReturn;" + NL + "        }" + NL + "        " + NL + "        private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{" + NL + "          if (date1 == null) {" + NL + "            dos.writeByte(-1);" + NL + "          } else {" + NL + "            dos.writeByte(0);" + NL + "            dos.writeLong(date1.getTime());" + NL + "          }" + NL + "        }";
  protected final String TEXT_73 = NL + "        private byte[] readByteArray(ObjectInputStream dis) throws IOException{" + NL + "          byte[] byteArrayReturn;" + NL + "          int length = 0;" + NL + "          length = dis.readInt();" + NL + "          " + NL + "          if (length == -1) {" + NL + "            byteArrayReturn = null;" + NL + "          } else {" + NL + "            byte[] byteArray = new byte[length];" + NL + "            dis.readFully(byteArray);" + NL + "            byteArrayReturn = byteArray;" + NL + "          }" + NL + "          return byteArrayReturn;" + NL + "        }" + NL + "              " + NL + "        private void writeByteArray(byte[] byteArray, ObjectOutputStream dos) throws IOException{" + NL + "          if (byteArray == null) {" + NL + "            dos.writeInt(-1);" + NL + "          } else {" + NL + "            dos.writeInt(byteArray.length);" + NL + "            dos.write(byteArray);" + NL + "          }" + NL + "        }";
  protected final String TEXT_74 = NL + "        private byte[] readByteArray(DataInputStream dis, ObjectInputStream ois) throws IOException{" + NL + "          byte[] byteArrayReturn;" + NL + "          int length = 0;" + NL + "          length = dis.readInt();" + NL + "          " + NL + "          if (length == -1) {" + NL + "            byteArrayReturn = null;" + NL + "          } else {" + NL + "            byte[] byteArray = new byte[length];" + NL + "            dis.read(byteArray);" + NL + "            byteArrayReturn = byteArray;" + NL + "          }" + NL + "          return byteArrayReturn;" + NL + "        }" + NL + "            " + NL + "        private void writeByteArray(byte[] byteArray, DataOutputStream dos, ObjectOutputStream oos) throws IOException{  " + NL + "          if (byteArray == null) {" + NL + "            dos.writeInt(-1);" + NL + "          } else {" + NL + "            dos.writeInt(byteArray.length);" + NL + "            dos.write(byteArray);" + NL + "          }" + NL + "        }";
  protected final String TEXT_75 = NL + "          private Integer readInteger(ObjectInputStream dis) throws IOException{" + NL + "            Integer intReturn;" + NL + "            int length = 0;" + NL + "            length = dis.readByte();" + NL + "            if (length == -1) {" + NL + "              intReturn = null;" + NL + "            } else {" + NL + "              intReturn = dis.read";
  protected final String TEXT_76 = "();" + NL + "            }" + NL + "            return intReturn;" + NL + "          }" + NL + "              " + NL + "          private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{" + NL + "            if (intNum == null) {" + NL + "              dos.writeByte(-1);" + NL + "            } else {" + NL + "              dos.writeByte(0);" + NL + "              dos.write";
  protected final String TEXT_77 = "(intNum);" + NL + "            }" + NL + "          }" + NL + "          ";
  protected final String TEXT_78 = NL + "          private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{" + NL + "            Integer intReturn;" + NL + "            int length = 0;" + NL + "            length = dis.readByte();" + NL + "             " + NL + "            if (length == -1) {" + NL + "              intReturn = null;" + NL + "            } else {" + NL + "              intReturn = dis.read";
  protected final String TEXT_79 = "();" + NL + "            }" + NL + "            return intReturn;" + NL + "          }" + NL + "              " + NL + "          private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{  " + NL + "            if (intNum == null) {" + NL + "              dos.writeByte(-1);" + NL + "            } else {" + NL + "              dos.writeByte(0);" + NL + "              dos.write";
  protected final String TEXT_80 = "(intNum);" + NL + "            }" + NL + "          }";
  protected final String TEXT_81 = "  " + NL + "     " + NL + "  public void ";
  protected final String TEXT_82 = "Data(ObjectInputStream dis) {" + NL + "    synchronized(commonByteArrayLock_";
  protected final String TEXT_83 = "_";
  protected final String TEXT_84 = ") {" + NL + "      try {" + NL + "        int length = 0;";
  protected final String TEXT_85 = NL + "              this.";
  protected final String TEXT_86 = " = dis.read";
  protected final String TEXT_87 = "();";
  protected final String TEXT_88 = NL + "              this.";
  protected final String TEXT_89 = " = readString(dis);";
  protected final String TEXT_90 = NL + "              this.";
  protected final String TEXT_91 = " = readDate(dis);";
  protected final String TEXT_92 = NL + "              this.";
  protected final String TEXT_93 = " = readByteArray(dis);";
  protected final String TEXT_94 = NL + "              this.";
  protected final String TEXT_95 = " = (";
  protected final String TEXT_96 = ") dis.readObject();";
  protected final String TEXT_97 = NL + "                this.";
  protected final String TEXT_98 = " = readInteger(dis);";
  protected final String TEXT_99 = NL + "                length = dis.readByte();" + NL + "                if (length == -1) {" + NL + "                  this.";
  protected final String TEXT_100 = " = null;" + NL + "                } else {" + NL + "                  this.";
  protected final String TEXT_101 = " = dis.read";
  protected final String TEXT_102 = "();" + NL + "                }";
  protected final String TEXT_103 = NL + "          } catch (IOException e) {" + NL + "            throw new RuntimeException(e);";
  protected final String TEXT_104 = NL + "          } catch(ClassNotFoundException eCNFE) {" + NL + "            throw new RuntimeException(eCNFE);";
  protected final String TEXT_105 = NL + "      }";
  protected final String TEXT_106 = NL + "        finally {}";
  protected final String TEXT_107 = NL + "    }" + NL + "  }" + NL + "" + NL + "  public void ";
  protected final String TEXT_108 = "Data(ObjectOutputStream dos) {" + NL + "    try {";
  protected final String TEXT_109 = NL + "           // ";
  protected final String TEXT_110 = NL + "            dos.write";
  protected final String TEXT_111 = "(this.";
  protected final String TEXT_112 = ");";
  protected final String TEXT_113 = NL + "            writeString(this.";
  protected final String TEXT_114 = ",dos);";
  protected final String TEXT_115 = NL + "            writeDate(this.";
  protected final String TEXT_116 = ",dos);";
  protected final String TEXT_117 = NL + "            writeByteArray(this.";
  protected final String TEXT_118 = ",dos);";
  protected final String TEXT_119 = NL + "                   dos.writeObject(this.";
  protected final String TEXT_120 = ");";
  protected final String TEXT_121 = NL + "              writeInteger(this.";
  protected final String TEXT_122 = ",dos);";
  protected final String TEXT_123 = NL + "              if (this.";
  protected final String TEXT_124 = " == null) {" + NL + "                dos.writeByte(-1);" + NL + "              } else {" + NL + "                dos.writeByte(0);" + NL + "                dos.write";
  protected final String TEXT_125 = "(this.";
  protected final String TEXT_126 = ");" + NL + "              }";
  protected final String TEXT_127 = NL + "        } catch (IOException e) {" + NL + "          throw new RuntimeException(e);";
  protected final String TEXT_128 = NL + "    }";
  protected final String TEXT_129 = NL + "      finally {}";
  protected final String TEXT_130 = NL + "  }" + NL;
  protected final String TEXT_131 = NL + NL + "    /** " + NL + "     * Fill Values data by reading ObjectInputStream." + NL + "     */" + NL + "    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {" + NL + "    " + NL + "      try {" + NL + "      int length = 0;";
  protected final String TEXT_132 = NL + "              this.";
  protected final String TEXT_133 = " = dis.read";
  protected final String TEXT_134 = "();";
  protected final String TEXT_135 = NL + "              this.";
  protected final String TEXT_136 = " = readString(dis,ois);";
  protected final String TEXT_137 = NL + "              this.";
  protected final String TEXT_138 = " = readByteArray(dis,ois);";
  protected final String TEXT_139 = NL + "              this.";
  protected final String TEXT_140 = " = readDate(dis,ois);";
  protected final String TEXT_141 = NL + "              this.";
  protected final String TEXT_142 = " = (";
  protected final String TEXT_143 = ") ois.readObject();";
  protected final String TEXT_144 = NL + "                this.";
  protected final String TEXT_145 = " = readInteger(dis,ois);";
  protected final String TEXT_146 = NL + "                length = dis.readByte();" + NL + "                " + NL + "                if (length == -1) {" + NL + "                  this.";
  protected final String TEXT_147 = " = null;" + NL + "                } else {" + NL + "                  this.";
  protected final String TEXT_148 = " = dis.read";
  protected final String TEXT_149 = "();" + NL + "                }";
  protected final String TEXT_150 = NL + "          } catch (IOException e) {" + NL + "            throw new RuntimeException(e);";
  protected final String TEXT_151 = NL + "          } catch(ClassNotFoundException eCNFE) {" + NL + "            throw new RuntimeException(eCNFE);";
  protected final String TEXT_152 = NL + "      }";
  protected final String TEXT_153 = NL + "        finally {}";
  protected final String TEXT_154 = NL + "    }" + NL + "" + NL + "    /** " + NL + "     * Return a byte array which represents Values data." + NL + "     */" + NL + "    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {" + NL + "      try {";
  protected final String TEXT_155 = NL + "            dos.write";
  protected final String TEXT_156 = "(this.";
  protected final String TEXT_157 = ");";
  protected final String TEXT_158 = NL + "            writeString(this.";
  protected final String TEXT_159 = ", dos, oos);";
  protected final String TEXT_160 = NL + "            writeByteArray(this.";
  protected final String TEXT_161 = ", dos, oos);";
  protected final String TEXT_162 = NL + "            writeDate(this.";
  protected final String TEXT_163 = ", dos, oos);";
  protected final String TEXT_164 = NL + "                   oos.writeObject(this.";
  protected final String TEXT_165 = ");";
  protected final String TEXT_166 = NL + "              writeInteger(this.";
  protected final String TEXT_167 = ", dos, oos);";
  protected final String TEXT_168 = NL + "              if(this.";
  protected final String TEXT_169 = " == null) {" + NL + "                dos.writeByte(-1);" + NL + "              } else {" + NL + "                dos.writeByte(0);" + NL + "                dos.write";
  protected final String TEXT_170 = "(this.";
  protected final String TEXT_171 = ");" + NL + "              }";
  protected final String TEXT_172 = NL + "        } catch (IOException e) {" + NL + "          throw new RuntimeException(e);";
  protected final String TEXT_173 = NL + "      }";
  protected final String TEXT_174 = NL + "        finally {}";
  protected final String TEXT_175 = NL + "    }" + NL;
  protected final String TEXT_176 = NL + NL + "  public String toString() {" + NL + "    " + NL + "    StringBuilder sb = new StringBuilder();" + NL + "    sb.append(super.toString());" + NL + "    sb.append(\"[\");";
  protected final String TEXT_177 = NL + "        sb.append(\",\"+ \"";
  protected final String TEXT_178 = "=\"+";
  protected final String TEXT_179 = ");";
  protected final String TEXT_180 = NL + "        sb.append(\",\"+ \"";
  protected final String TEXT_181 = "=\"+String.valueOf(";
  protected final String TEXT_182 = "));";
  protected final String TEXT_183 = NL + "    sb.append(\"]\");" + NL + "    return sb.toString();" + NL + "  }" + NL + "    " + NL + "  /** " + NL + "   * Compare keys" + NL + "   */" + NL + "  public int compareTo(";
  protected final String TEXT_184 = "Struct other) {" + NL + "    int returnValue = -1;";
  protected final String TEXT_185 = NL + "        returnValue = checkNullsAndCompare(this.";
  protected final String TEXT_186 = ", other.";
  protected final String TEXT_187 = ");" + NL + "      " + NL + "        if (returnValue != 0) {" + NL + "          return returnValue;" + NL + "        }" + NL;
  protected final String TEXT_188 = NL + "  return returnValue;" + NL + "  }" + NL + "    " + NL + "  private int checkNullsAndCompare(Object object1, Object object2) {" + NL + "    int returnValue = 0;" + NL + "    if (object1 instanceof Comparable && object2 instanceof Comparable) {" + NL + "      returnValue = ((Comparable) object1).compareTo(object2);" + NL + "    } else if (object1 != null && object2 != null) {" + NL + "      returnValue = compareStrings(object1.toString(), object2.toString());" + NL + "    } else if (object1 == null && object2 != null) {" + NL + "      returnValue = 1;" + NL + "    } else if (object1 != null && object2 == null) {" + NL + "      returnValue = -1;" + NL + "    } else {" + NL + "      returnValue = 0;" + NL + "    }" + NL + "    return returnValue;" + NL + "  }" + NL + "" + NL + "  private int compareStrings(String string1, String string2) {" + NL + "    return string1.compareTo(string2);" + NL + "  }" + NL + "}" + NL + " " + NL + "" + NL + "class ";
  protected final String TEXT_189 = "_2Struct implements routines.system.IPersistableComparableLookupRow";
  protected final String TEXT_190 = ",org.talend.dataquality.indicators.mapdb.helper.IObjectConvertArray {" + NL + "  final byte[] commonByteArrayLock_";
  protected final String TEXT_191 = "_";
  protected final String TEXT_192 = " = new byte[0];" + NL + "  byte[] commonByteArray_";
  protected final String TEXT_193 = "_";
  protected final String TEXT_194 = " = new byte[0];" + NL + "    private  final int DEFAULT_HASHCODE = 1;" + NL + "    private  final int PRIME = 31;" + NL + "    private int hashCode = DEFAULT_HASHCODE;" + NL + "    public boolean hashCodeDirty = true;";
  protected final String TEXT_195 = NL + "        public ";
  protected final String TEXT_196 = " ";
  protected final String TEXT_197 = " = ' '";
  protected final String TEXT_198 = ";" + NL + "" + NL + "        public ";
  protected final String TEXT_199 = " get";
  protected final String TEXT_200 = " () {" + NL + "            return this.";
  protected final String TEXT_201 = ";" + NL + "        }";
  protected final String TEXT_202 = NL + "  public void copyDateToOut(";
  protected final String TEXT_203 = "_2Struct other){";
  protected final String TEXT_204 = NL + "      other.";
  protected final String TEXT_205 = " = this.";
  protected final String TEXT_206 = ";";
  protected final String TEXT_207 = NL + "  }" + NL + "    " + NL + "    @Override" + NL + "    public int hashCode() {" + NL + "      if (this.hashCodeDirty) {" + NL + "        final int prime = PRIME;" + NL + "        int result = DEFAULT_HASHCODE;" + NL + "        ";
  protected final String TEXT_208 = NL + "              result = prime * result + (this.";
  protected final String TEXT_209 = " ? 1231 : 1237);";
  protected final String TEXT_210 = NL + "              result = prime * result + (int) this.";
  protected final String TEXT_211 = ";";
  protected final String TEXT_212 = NL + "            result = prime * result + java.util.Arrays.hashCode(this.";
  protected final String TEXT_213 = ");";
  protected final String TEXT_214 = NL + "            result = prime * result + ((this.";
  protected final String TEXT_215 = " == null) ? 0 : this.";
  protected final String TEXT_216 = ".hashCode());";
  protected final String TEXT_217 = NL + "        this.hashCode = result;" + NL + "        this.hashCodeDirty = false;" + NL + "      }" + NL + "      return this.hashCode;" + NL + "    }" + NL + "    " + NL + "    @Override" + NL + "    public boolean equals(Object obj) {" + NL + "      if (this == obj)" + NL + "        return true;" + NL + "      if (obj == null)" + NL + "        return false;" + NL + "      if (getClass() != obj.getClass())" + NL + "        return false;" + NL + "      final ";
  protected final String TEXT_218 = "_2Struct other = (";
  protected final String TEXT_219 = "_2Struct) obj;" + NL + "      ";
  protected final String TEXT_220 = NL + "          if (this.";
  protected final String TEXT_221 = " != other.";
  protected final String TEXT_222 = ") {" + NL + "            return false;" + NL + "          }";
  protected final String TEXT_223 = "   " + NL + "          if(!java.util.Arrays.equals(this.";
  protected final String TEXT_224 = ", other.";
  protected final String TEXT_225 = ")) {" + NL + "            return false;" + NL + "          }";
  protected final String TEXT_226 = NL + "          if (this.";
  protected final String TEXT_227 = " == null) {" + NL + "            if (other.";
  protected final String TEXT_228 = " != null) " + NL + "              return false;" + NL + "          } else if (!this.";
  protected final String TEXT_229 = ".equals(other.";
  protected final String TEXT_230 = ")) " + NL + "            return false;";
  protected final String TEXT_231 = NL + "      return true;" + NL + "    }" + NL + "    public void copyDataTo(";
  protected final String TEXT_232 = "_2Struct other) {";
  protected final String TEXT_233 = NL + "          other.";
  protected final String TEXT_234 = " = this.";
  protected final String TEXT_235 = ";";
  protected final String TEXT_236 = NL + "      }" + NL + "      " + NL + "      public void copyKeysDataTo(";
  protected final String TEXT_237 = "_2Struct other) {";
  protected final String TEXT_238 = NL + "          other.";
  protected final String TEXT_239 = " = this.";
  protected final String TEXT_240 = ";";
  protected final String TEXT_241 = NL + "      }" + NL;
  protected final String TEXT_242 = NL + "        private String readString(ObjectInputStream dis) throws IOException{" + NL + "              String strReturn = null;" + NL + "              int length = 0;" + NL + "              length = dis.readInt();" + NL + "              " + NL + "              if (length == -1) {" + NL + "                strReturn = null;" + NL + "              } else {" + NL + "                if (length > commonByteArray_";
  protected final String TEXT_243 = "_";
  protected final String TEXT_244 = ".length) {" + NL + "                  if (length < 1024 && commonByteArray_";
  protected final String TEXT_245 = "_";
  protected final String TEXT_246 = ".length == 0) {" + NL + "                    commonByteArray_";
  protected final String TEXT_247 = "_";
  protected final String TEXT_248 = " = new byte[1024];" + NL + "                  } else {" + NL + "                    commonByteArray_";
  protected final String TEXT_249 = "_";
  protected final String TEXT_250 = " = new byte[2 * length];" + NL + "                  }" + NL + "                }" + NL + "                dis.readFully(commonByteArray_";
  protected final String TEXT_251 = "_";
  protected final String TEXT_252 = ", 0, length);" + NL + "                strReturn = new String(commonByteArray_";
  protected final String TEXT_253 = "_";
  protected final String TEXT_254 = ", 0, length, utf8Charset);" + NL + "              }" + NL + "              return strReturn;" + NL + "            }" + NL + "      " + NL + "            private void writeString(String str, ObjectOutputStream dos) throws IOException{" + NL + "              if (str == null) {" + NL + "                dos.writeInt(-1);" + NL + "              } else {" + NL + "                byte[] byteArray = str.getBytes(utf8Charset);" + NL + "                dos.writeInt(byteArray.length);" + NL + "                dos.write(byteArray);" + NL + "              }" + NL + "            }" + NL + "            ";
  protected final String TEXT_255 = NL + "                private java.util.Date readDate(ObjectInputStream dis) throws IOException{" + NL + "                  java.util.Date dateReturn = null;" + NL + "                  int length = 0;" + NL + "                  length = dis.readByte();" + NL + "                  " + NL + "                  if (length == -1) {" + NL + "                    dateReturn = null;" + NL + "                  } else {" + NL + "                    dateReturn = new Date(dis.readLong());" + NL + "                  }" + NL + "                  return dateReturn;" + NL + "                }" + NL + "                      " + NL + "                private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{" + NL + "                  if (date1 == null) {" + NL + "                    dos.writeByte(-1);" + NL + "                  } else {" + NL + "                    dos.writeByte(0);" + NL + "                    dos.writeLong(date1.getTime());" + NL + "                  }" + NL + "                }";
  protected final String TEXT_256 = NL + "                    private byte[] readByteArray(ObjectInputStream dis) throws IOException{" + NL + "                      byte[] byteArrayReturn;" + NL + "                      int length = 0;" + NL + "                      length = dis.readInt();" + NL + "                      " + NL + "                      if (length == -1) {" + NL + "                        byteArrayReturn = null;" + NL + "                      } else {" + NL + "                        byte[] byteArray = new byte[length];" + NL + "                        dis.readFully(byteArray);" + NL + "                        byteArrayReturn = byteArray;" + NL + "                      }" + NL + "                      return byteArrayReturn;" + NL + "                    }" + NL + "                          " + NL + "                    private void writeByteArray(byte[] byteArray, ObjectOutputStream dos) throws IOException{" + NL + "                      if (byteArray == null) {" + NL + "                        dos.writeInt(-1);" + NL + "                      } else {" + NL + "                        dos.writeInt(byteArray.length);" + NL + "                        dos.write(byteArray);" + NL + "                      }" + NL + "                    }";
  protected final String TEXT_257 = NL + "                          private Integer readInteger(ObjectInputStream dis) throws IOException{" + NL + "                            Integer intReturn;" + NL + "                            int length = 0;" + NL + "                            length = dis.readByte();" + NL + "                            if (length == -1) {" + NL + "                              intReturn = null;" + NL + "                            } else {" + NL + "                              intReturn = dis.read";
  protected final String TEXT_258 = "();" + NL + "                            }" + NL + "                            return intReturn;" + NL + "                          }" + NL + "                              " + NL + "                          private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{" + NL + "                            if (intNum == null) {" + NL + "                              dos.writeByte(-1);" + NL + "                            } else {" + NL + "                              dos.writeByte(0);" + NL + "                              dos.write";
  protected final String TEXT_259 = "(intNum);" + NL + "                            }" + NL + "                          }";
  protected final String TEXT_260 = "    " + NL + "      public void readKeysData(ObjectInputStream dis) {" + NL + "          synchronized(commonByteArrayLock_";
  protected final String TEXT_261 = "_";
  protected final String TEXT_262 = ") {" + NL + "            try {" + NL + "              int length = 0;";
  protected final String TEXT_263 = NL + "                    this.";
  protected final String TEXT_264 = " = dis.read";
  protected final String TEXT_265 = "();";
  protected final String TEXT_266 = NL + "                    this.";
  protected final String TEXT_267 = " = readString(dis);";
  protected final String TEXT_268 = NL + "                    this.";
  protected final String TEXT_269 = " = readDate(dis);";
  protected final String TEXT_270 = NL + "                    this.";
  protected final String TEXT_271 = " = readByteArray(dis);";
  protected final String TEXT_272 = NL + "                    this.";
  protected final String TEXT_273 = " = (";
  protected final String TEXT_274 = ") dis.readObject();";
  protected final String TEXT_275 = NL + "                      this.";
  protected final String TEXT_276 = " = readInteger(dis);";
  protected final String TEXT_277 = NL + "                      length = dis.readByte();" + NL + "                      if (length == -1) {" + NL + "                        this.";
  protected final String TEXT_278 = " = null;" + NL + "                      } else {" + NL + "                        this.";
  protected final String TEXT_279 = " = dis.read";
  protected final String TEXT_280 = "();" + NL + "                      }";
  protected final String TEXT_281 = NL + "                    } catch (IOException e) {" + NL + "                      throw new RuntimeException(e);";
  protected final String TEXT_282 = NL + "                    } catch(ClassNotFoundException eCNFE) {" + NL + "                      throw new RuntimeException(eCNFE);";
  protected final String TEXT_283 = NL + "                }";
  protected final String TEXT_284 = NL + "              finally {}";
  protected final String TEXT_285 = NL + "          }" + NL + "        }" + NL + "      public void writeKeysData(ObjectOutputStream dos) {" + NL + "          try {";
  protected final String TEXT_286 = NL + "                 // ";
  protected final String TEXT_287 = NL + "                  dos.write";
  protected final String TEXT_288 = "(this.";
  protected final String TEXT_289 = ");";
  protected final String TEXT_290 = NL + "                  writeString(this.";
  protected final String TEXT_291 = ",dos);";
  protected final String TEXT_292 = NL + "                  writeDate(this.";
  protected final String TEXT_293 = ",dos);";
  protected final String TEXT_294 = NL + "                  writeByteArray(this.";
  protected final String TEXT_295 = ",dos);";
  protected final String TEXT_296 = NL + "                         dos.writeObject(this.";
  protected final String TEXT_297 = ");";
  protected final String TEXT_298 = NL + "                    writeInteger(this.";
  protected final String TEXT_299 = ",dos);";
  protected final String TEXT_300 = NL + "                    if (this.";
  protected final String TEXT_301 = " == null) {" + NL + "                      dos.writeByte(-1);" + NL + "                    } else {" + NL + "                      dos.writeByte(0);" + NL + "                      dos.write";
  protected final String TEXT_302 = "(this.";
  protected final String TEXT_303 = ");" + NL + "                    }";
  protected final String TEXT_304 = NL + "              } catch (IOException e) {" + NL + "                throw new RuntimeException(e);";
  protected final String TEXT_305 = NL + "          }";
  protected final String TEXT_306 = NL + "            finally {}";
  protected final String TEXT_307 = NL + "        }" + NL + "      /** " + NL + "       * Fill Values data by reading ObjectInputStream." + NL + "       */" + NL + "      public void readValuesData(DataInputStream dis, ObjectInputStream ois) {" + NL + "   " + NL + "      }" + NL + "" + NL + "      /** " + NL + "       * Return a byte array which represents Values data." + NL + "       */" + NL + "      public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {" + NL + "" + NL + "      }" + NL + "" + NL + "    public String toString() {" + NL + "      " + NL + "      StringBuilder sb = new StringBuilder();" + NL + "      sb.append(super.toString());" + NL + "      sb.append(\"[\");";
  protected final String TEXT_308 = NL + "          sb.append(\",\"+ \"";
  protected final String TEXT_309 = "=\"+";
  protected final String TEXT_310 = ");";
  protected final String TEXT_311 = NL + "          sb.append(\",\"+ \"";
  protected final String TEXT_312 = "=\"+String.valueOf(";
  protected final String TEXT_313 = "));";
  protected final String TEXT_314 = NL + "      sb.append(\"]\");" + NL + "      return sb.toString();" + NL + "    }" + NL + "      " + NL + "    /** " + NL + "     * Compare keys" + NL + "     */" + NL + "    public int compareTo(";
  protected final String TEXT_315 = "_2Struct other) {" + NL + "      int returnValue = -1;";
  protected final String TEXT_316 = NL + "          returnValue = checkNullsAndCompare(this.";
  protected final String TEXT_317 = ", other.";
  protected final String TEXT_318 = ");" + NL + "        " + NL + "          if (returnValue != 0) {" + NL + "            return returnValue;" + NL + "          }" + NL;
  protected final String TEXT_319 = NL + "    return returnValue;" + NL + "    }" + NL + "      " + NL + "    private int checkNullsAndCompare(Object object1, Object object2) {" + NL + "      int returnValue = 0;" + NL + "      if (object1 instanceof Comparable && object2 instanceof Comparable) {" + NL + "        returnValue = ((Comparable) object1).compareTo(object2);" + NL + "      } else if (object1 != null && object2 != null) {" + NL + "        returnValue = compareStrings(object1.toString(), object2.toString());" + NL + "      } else if (object1 == null && object2 != null) {" + NL + "        returnValue = 1;" + NL + "      } else if (object1 != null && object2 == null) {" + NL + "        returnValue = -1;" + NL + "      } else {" + NL + "        returnValue = 0;" + NL + "      }" + NL + "      return returnValue;" + NL + "    }" + NL + "" + NL + "    private int compareStrings(String string1, String string2) {" + NL + "      return string1.compareTo(string2);" + NL + "    }" + NL + "    " + NL + "    @Override" + NL + "    public Object[] getArrays() {" + NL + "        Object[] array=new Object[";
  protected final String TEXT_320 = "];";
  protected final String TEXT_321 = NL + "           " + NL + "            array[";
  protected final String TEXT_322 = "]=this.";
  protected final String TEXT_323 = ";";
  protected final String TEXT_324 = NL + "        return array;" + NL + "    }" + NL + "    @Override" + NL + "    public void restoreObjectByArrays(Object[] elements) {";
  protected final String TEXT_325 = NL + "            this.";
  protected final String TEXT_326 = "=(";
  protected final String TEXT_327 = ")elements[";
  protected final String TEXT_328 = "];";
  protected final String TEXT_329 = NL + "    }" + NL + "}//end of _2struct" + NL + "" + NL + "" + NL + "" + NL + "org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE " + NL + "  matchingModeEnum_";
  protected final String TEXT_330 = " = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.";
  protected final String TEXT_331 = ";";
  protected final String TEXT_332 = NL + "  org.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_333 = "LookupManager<";
  protected final String TEXT_334 = "Struct> " + NL + "    tHash_Lookup_";
  protected final String TEXT_335 = " = new org.talend.designer.components.lookup.persistent.Persistent";
  protected final String TEXT_336 = "LookupManager<";
  protected final String TEXT_337 = "Struct>(" + NL + "        matchingModeEnum_";
  protected final String TEXT_338 = ", ";
  protected final String TEXT_339 = NL + "        ";
  protected final String TEXT_340 = " + \"/\"+ jobName +\"_tMapData_\" + pid +\"_Lookup_";
  protected final String TEXT_341 = "_\", " + NL + "        new org.talend.designer.components.persistent.IRowCreator() {" + NL + "          public ";
  protected final String TEXT_342 = "Struct createRowInstance() {" + NL + "            return new ";
  protected final String TEXT_343 = "Struct();" + NL + "          }" + NL + "        }";
  protected final String TEXT_344 = NL + "          , ";
  protected final String TEXT_345 = NL + "    ); " + NL + "" + NL + "  tHash_Lookup_";
  protected final String TEXT_346 = ".initPut();";
  protected final String TEXT_347 = NL + "  org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<";
  protected final String TEXT_348 = "Struct> " + NL + "    tHash_Lookup_";
  protected final String TEXT_349 = " = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.<";
  protected final String TEXT_350 = "Struct>getLookup(matchingModeEnum_";
  protected final String TEXT_351 = ");";
  protected final String TEXT_352 = NL + "globalMap.put(\"tHash_Lookup_";
  protected final String TEXT_353 = "\", tHash_Lookup_";
  protected final String TEXT_354 = ");" + NL + "" + NL + "/*store all block rows*/ ";
  protected final String TEXT_355 = NL + "    java.util.Set<Object[]> blockRows_";
  protected final String TEXT_356 = " =new org.talend.dataquality.indicators.mapdb.DBSet<Object[]>();";
  protected final String TEXT_357 = " " + NL + "  java.util.Map<";
  protected final String TEXT_358 = "_2Struct, String> blockRows_";
  protected final String TEXT_359 = " = new java.util.HashMap<";
  protected final String TEXT_360 = "_2Struct, String>();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();  
cid = cid.replace("_GroupOut", "");

// incoming connection
List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
IConnection inConn = null;
String connNameMain = null;
if (inConns == null || inConns.size() == 0){
  return "";
} else{
  inConn = inConns.get(0);
  connNameMain = inConn.getName();
}

// input schema
IMetadataTable table = inConn.getMetadataTable();
List<IMetadataColumn> columns = table.getListColumns();

// outing connection
String connNameOut = null;
List<? extends IConnection> outConns = node.getOutgoingSortedConnections().get(0).getTarget().getOutgoingSortedConnections();

if (outConns == null || outConns.size() == 0){
  return "";
} else {
  connNameOut = outConns.get(0).getName();
}
boolean hasAtLeastOneBlock = false;
List<String> blockColumns = new java.util.ArrayList<String>(); // to store unduplicated blocking columns
List<Map<String, String>> listBlocking = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BLOCKING_DEFINITION__");

for (Map<String, String> blocking : listBlocking){
  String sColumnName = blocking.get("INPUT_COLUMN");
  
  if (!hasAtLeastOneBlock){
    hasAtLeastOneBlock = true;
  }
  
  if (!blockColumns.contains(sColumnName)){
    blockColumns.add(sColumnName);
  }
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append( hasAtLeastOneBlock ? "IPersistableComparableLookupRow<"+cid+"Struct>" : "IPersistableRow<"+cid+"Struct>" );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_7);
    
  if (hasAtLeastOneBlock) {
  
    stringBuffer.append(TEXT_8);
    
  }
  
  for (IMetadataColumn column : columns){
    String sColumnName = column.getLabel();
    String sType= JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
    
    stringBuffer.append(TEXT_9);
    stringBuffer.append(sType);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(sColumnName);
                
      if ("Character".equals(sType) && !column.isNullable()) {
        
    stringBuffer.append(TEXT_11);
    
      }
      
    stringBuffer.append(TEXT_12);
    stringBuffer.append(sType);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(sColumnName.substring(0, 1).toUpperCase());
    stringBuffer.append(sColumnName.substring(1));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_15);
    
  }
  
    stringBuffer.append(TEXT_16);
    stringBuffer.append(connNameOut);
    stringBuffer.append(TEXT_17);
    
    for (IMetadataColumn column : columns){
      String sColumnName = column.getLabel();
      
    stringBuffer.append(TEXT_18);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    
  if (hasAtLeastOneBlock) { // T_SH_001
  
    stringBuffer.append(TEXT_22);
    
        for (Map<String, String> blocking : listBlocking){
          String sColumnName = blocking.get("INPUT_COLUMN");
          String sType = JavaTypesManager.getTypeToGenerate(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable());
          
          if (JavaTypesManager.isJavaPrimitiveType(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable())) {
            if ("Boolean".equals(sType)){
            
    stringBuffer.append(TEXT_23);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_24);
    
            } else {
            
    stringBuffer.append(TEXT_25);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_26);
    
            }
          } else if ("byte[]".equals(sType)){
          
    stringBuffer.append(TEXT_27);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_28);
    
          } else{
          
    stringBuffer.append(TEXT_29);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_31);
    
          }
        }
        
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
      for (Map<String, String> blocking : listBlocking){
        String sColumnName = blocking.get("INPUT_COLUMN");
        String sType = JavaTypesManager.getTypeToGenerate(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable());
          
        if (JavaTypesManager.isJavaPrimitiveType(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable())) {
        
    stringBuffer.append(TEXT_35);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_37);
     
        } else if ("byte[]".equals(sType)) {
        
    stringBuffer.append(TEXT_38);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_40);
    
        } else {
        
    stringBuffer.append(TEXT_41);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_45);
    
        }
      }
      
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
      for (IMetadataColumn column : columns){
        String sColumnName = column.getLabel();
        
    stringBuffer.append(TEXT_48);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
      for (Map<String, String> blocking : listBlocking) {
        String sColumnName = blocking.get("INPUT_COLUMN");
        
    stringBuffer.append(TEXT_53);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    
  } // T_SH_001
 
  boolean hasString1 = false;
  boolean hasString2 = false;
  boolean hasDate1 = false;
  boolean hasDate2 = false;
  boolean hasByteArray1 = false;
  boolean hasByteArray2 = false;
  boolean hasInteger1 = false;
  boolean hasInteger2 = false;
     
  for (IMetadataColumn column : columns){
    String sColumnName = column.getLabel();
    String sType= JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
    
    if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) continue;
    
    if (sType.equals("String")) {
      if (!hasString1 && (!hasAtLeastOneBlock || blockColumns.contains(sColumnName))) {
        hasString1 =true;
        
    stringBuffer.append(TEXT_57);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_69);
    
      } else if (!hasString2 && (hasAtLeastOneBlock && !blockColumns.contains(sColumnName))){
        hasString2 = true;
        
    stringBuffer.append(TEXT_70);
    
      }
    } else if(sType.equals("java.util.Date")) {
      if(!hasDate1 && (!hasAtLeastOneBlock || blockColumns.contains(sColumnName))) {
        hasDate1 = true;
        
    stringBuffer.append(TEXT_71);
    
      }else if (!hasDate2 && (hasAtLeastOneBlock && !blockColumns.contains(column.getLabel()))) {
        hasDate2 = true;
        
    stringBuffer.append(TEXT_72);
    
      }
    } else if(sType.equals("byte[]")) {
      if (!hasByteArray1 && (!hasAtLeastOneBlock || blockColumns.contains(sColumnName))) {
        hasByteArray1 = true;
        
    stringBuffer.append(TEXT_73);
    
      } else if (!hasByteArray2 && (hasAtLeastOneBlock && !blockColumns.contains(sColumnName))) {
        hasByteArray2 = true;
        
    stringBuffer.append(TEXT_74);
    
      }
    } else {
      sType =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
      sType = sType.substring(0,1).toUpperCase() + sType.substring(1);
      
      if(sType.equals("Int")){
        
        if(!hasInteger1 && (!hasAtLeastOneBlock || blockColumns.contains(sColumnName))) {
          hasInteger1 = true;
          
    stringBuffer.append(TEXT_75);
    stringBuffer.append( sType );
    stringBuffer.append(TEXT_76);
    stringBuffer.append( sType );
    stringBuffer.append(TEXT_77);
    
        } else if(!hasInteger2 && (hasAtLeastOneBlock && !blockColumns.contains(sColumnName))){
          hasInteger2 = true;
          
    stringBuffer.append(TEXT_78);
    stringBuffer.append( sType );
    stringBuffer.append(TEXT_79);
    stringBuffer.append( sType );
    stringBuffer.append(TEXT_80);
    
        }
      }
    }
  }
  
    stringBuffer.append(TEXT_81);
    stringBuffer.append( hasAtLeastOneBlock ? "readKeys" : "read" );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_84);
      
        boolean hasAtLeastOneRead = false;
        boolean hasAtLeastOneObjectType = false;
   
        for (IMetadataColumn column : columns){
          String sColumnName = column.getLabel();
          
          if (!hasAtLeastOneBlock || blockColumns.contains(sColumnName)) {
            hasAtLeastOneRead = true;
            String sType= JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

            if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
              sType=sType.substring(0,1).toUpperCase() + sType.substring(1);
              
    stringBuffer.append(TEXT_85);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(sType);
    stringBuffer.append(TEXT_87);
    
            } else if(sType.equals("String")) {
            
    stringBuffer.append(TEXT_88);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_89);
    
            } else if(sType.equals("java.util.Date")) {
            
    stringBuffer.append(TEXT_90);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_91);
    
            } else if(sType.equals("byte[]")) {
            
    stringBuffer.append(TEXT_92);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_93);
    
            } else if(sType.equals("Object") || sType.equals("BigDecimal") || sType.equals("List")) {
              hasAtLeastOneObjectType = true;
              
    stringBuffer.append(TEXT_94);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_95);
    stringBuffer.append( sType );
    stringBuffer.append(TEXT_96);
    
            } else {
              sType =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
              sType=sType.substring(0,1).toUpperCase()+sType.substring(1);
              
              if (sType.equals("Int")){
              
    stringBuffer.append(TEXT_97);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_98);
    
              } else {
              
    stringBuffer.append(TEXT_99);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append( sType );
    stringBuffer.append(TEXT_102);
    
              }
            }
          }
        }
      
        if (hasAtLeastOneRead) {
        
    stringBuffer.append(TEXT_103);
    
        }
        if(hasAtLeastOneObjectType) {
        
    stringBuffer.append(TEXT_104);
    
        }
        
    stringBuffer.append(TEXT_105);
    
      if (!hasAtLeastOneRead) {
      
    stringBuffer.append(TEXT_106);
    
      }
      
    stringBuffer.append(TEXT_107);
    stringBuffer.append( hasAtLeastOneBlock ? "writeKeys" : "write" );
    stringBuffer.append(TEXT_108);
      
      boolean hasAtLeastOneWrite = false;
      hasAtLeastOneObjectType = false;
      
      for (IMetadataColumn column : columns){
        String sColumnName = column.getLabel();
        
        if (!hasAtLeastOneBlock || blockColumns.contains(sColumnName)) {
          hasAtLeastOneWrite = true;
          String sType= JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
          
    stringBuffer.append(TEXT_109);
    stringBuffer.append(sType );
    
          if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
            sType = sType.substring(0,1).toUpperCase()+sType.substring(1);
          
    stringBuffer.append(TEXT_110);
    stringBuffer.append(sType);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_112);
    
          } else if(sType.equals("String")) {
          
    stringBuffer.append(TEXT_113);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_114);
    
          } else if(sType.equals("java.util.Date")) {
          
    stringBuffer.append(TEXT_115);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_116);
    
          } else if(sType.equals("byte[]")) {
          
    stringBuffer.append(TEXT_117);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_118);
    
          } else if(sType.equals("Object") || sType.equals("BigDecimal") || sType.equals("List")) {
          
    stringBuffer.append(TEXT_119);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_120);
    
          } else {
            sType =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
            sType = sType.substring(0,1).toUpperCase()+sType.substring(1);
          
            if (sType.equals("Int")){
            
    stringBuffer.append(TEXT_121);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_122);
    
            } else {
            
    stringBuffer.append(TEXT_123);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(sType);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_126);
    
            }
          }
        }
      }
      if(hasAtLeastOneWrite) {
      
    stringBuffer.append(TEXT_127);
    
      }
      
    stringBuffer.append(TEXT_128);
    
    if(!hasAtLeastOneWrite) {
    
    stringBuffer.append(TEXT_129);
    
    }
    
    stringBuffer.append(TEXT_130);
    
  if (hasAtLeastOneBlock) { // T SH 002
  
    stringBuffer.append(TEXT_131);
     
      hasAtLeastOneRead = false;
      hasAtLeastOneObjectType = false;
      
        for (IMetadataColumn column : columns){
          String sColumnName = column.getLabel();
         
          if (!blockColumns.contains(sColumnName)) {
            hasAtLeastOneRead = true;
            String sType = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

            if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
              sType=sType.substring(0,1).toUpperCase()+sType.substring(1);
              
    stringBuffer.append(TEXT_132);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append( sType );
    stringBuffer.append(TEXT_134);
    
            } else if(sType.equals("String")) {
            
    stringBuffer.append(TEXT_135);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_136);
    
            } else if(sType.equals("byte[]")) {
            
    stringBuffer.append(TEXT_137);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_138);
    
            } else if(sType.equals("java.util.Date")) {
            
    stringBuffer.append(TEXT_139);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_140);
    
            } else if(sType.equals("Object") || sType.equals("BigDecimal") || sType.equals("List")) {
              hasAtLeastOneObjectType = true;
              
    stringBuffer.append(TEXT_141);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append( sType );
    stringBuffer.append(TEXT_143);
    
            } else {
              sType =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
              sType=sType.substring(0,1).toUpperCase()+sType.substring(1);
              if(sType.equals("Int")){
              
    stringBuffer.append(TEXT_144);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_145);
    
              } else {
              
    stringBuffer.append(TEXT_146);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append( sType );
    stringBuffer.append(TEXT_149);
    
              }
            }
          }
        }
        if (hasAtLeastOneRead) {
        
    stringBuffer.append(TEXT_150);
    
        }
         
        if (hasAtLeastOneObjectType) {
        
    stringBuffer.append(TEXT_151);
    
        }
        
    stringBuffer.append(TEXT_152);
    
      if (!hasAtLeastOneRead) {
      
    stringBuffer.append(TEXT_153);
    
      }
      
    stringBuffer.append(TEXT_154);
      
      hasAtLeastOneWrite = false;
      
      for (IMetadataColumn column : columns){
        String sColumnName = column.getLabel();
        
        if (!blockColumns.contains(sColumnName)) {
          String sType= JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
          hasAtLeastOneWrite = true;
        
          if (JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable())) {
            sType=sType.substring(0,1).toUpperCase()+sType.substring(1);
            
    stringBuffer.append(TEXT_155);
    stringBuffer.append( sType );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_157);
    
          } else if(sType.equals("String")) {
          
    stringBuffer.append(TEXT_158);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_159);
    
          } else if(sType.equals("byte[]")) {
          
    stringBuffer.append(TEXT_160);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_161);
    
          } else if(sType.equals("java.util.Date")) {
          
    stringBuffer.append(TEXT_162);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_163);
    
          } else if(sType.equals("Object") || sType.equals("BigDecimal") || sType.equals("List")) {
          
    stringBuffer.append(TEXT_164);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_165);
    
          } else {
            sType =JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
            sType = sType.substring(0,1).toUpperCase()+sType.substring(1);
            
            if (sType.equals("Int")){
            
    stringBuffer.append(TEXT_166);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_167);
    
            } else {
            
    stringBuffer.append(TEXT_168);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append( sType );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_171);
    
            }
          }
        }
      }

      if (hasAtLeastOneRead) {
      
    stringBuffer.append(TEXT_172);
    
      }
      
    stringBuffer.append(TEXT_173);
    
      if (!hasAtLeastOneRead) {
      
    stringBuffer.append(TEXT_174);
    
      }
      
    stringBuffer.append(TEXT_175);
    
  } // T SH 002
  
    stringBuffer.append(TEXT_176);
      
    int i = 0;
    for (IMetadataColumn column : columns){
      i++;
      String sColumnName = column.getLabel();
      String sType = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
            
      if (sType.equals("String")) {
      
    stringBuffer.append(TEXT_177);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_179);
    
      }else{
      
    stringBuffer.append(TEXT_180);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_182);
    
      }
    }
    
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
      
    for (IMetadataColumn column : columns){
      String sColumnName = column.getLabel();
    
      if (blockColumns.contains(sColumnName)) {
      
    stringBuffer.append(TEXT_185);
    stringBuffer.append(sColumnName );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(sColumnName );
    stringBuffer.append(TEXT_187);
    
      }
    }
  
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append("<"+cid+"_2Struct>" );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_194);
    
  for (Map<String, String> blocking : listBlocking){
      String sColumnName = blocking.get("INPUT_COLUMN");
      String sType = JavaTypesManager.getTypeToGenerate(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable());
    
    stringBuffer.append(TEXT_195);
    stringBuffer.append(sType);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(sColumnName);
                
        if ("Character".equals(sType) && !table.getColumn(sColumnName).isNullable()) {
        
    stringBuffer.append(TEXT_197);
    
        }
        
    stringBuffer.append(TEXT_198);
    stringBuffer.append(sType);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(sColumnName.substring(0, 1).toUpperCase());
    stringBuffer.append(sColumnName.substring(1));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_201);
    
  }
  
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    
        for (Map<String, String> blocking : listBlocking){
          String sColumnName = blocking.get("INPUT_COLUMN");
      
    stringBuffer.append(TEXT_204);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_206);
    }
    stringBuffer.append(TEXT_207);
    
        for (Map<String, String> blocking : listBlocking){
          String sColumnName = blocking.get("INPUT_COLUMN");
          String sType = JavaTypesManager.getTypeToGenerate(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable());
          
          if (JavaTypesManager.isJavaPrimitiveType(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable())) {
            if ("Boolean".equals(sType)){
            
    stringBuffer.append(TEXT_208);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_209);
    
            } else {
            
    stringBuffer.append(TEXT_210);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_211);
    
            }
          } else if ("byte[]".equals(sType)){
          
    stringBuffer.append(TEXT_212);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_213);
    
          } else{
          
    stringBuffer.append(TEXT_214);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_216);
    
          }
        }
        
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
      for (Map<String, String> blocking : listBlocking){
        String sColumnName = blocking.get("INPUT_COLUMN");
        String sType = JavaTypesManager.getTypeToGenerate(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable());
          
        if (JavaTypesManager.isJavaPrimitiveType(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable())) {
        
    stringBuffer.append(TEXT_220);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_222);
     
        } else if ("byte[]".equals(sType)) {
        
    stringBuffer.append(TEXT_223);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_225);
    
        } else {
        
    stringBuffer.append(TEXT_226);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_230);
    
        }
      }
      
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    
        for (Map<String, String> blocking : listBlocking) {
          String sColumnName = blocking.get("INPUT_COLUMN");
          
    stringBuffer.append(TEXT_233);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_235);
    }
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    
        for (Map<String, String> blocking : listBlocking) {
          String sColumnName = blocking.get("INPUT_COLUMN");
          
    stringBuffer.append(TEXT_238);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_240);
    }
    stringBuffer.append(TEXT_241);
    
      boolean hasString_1 = false;
      boolean hasDate_1 = false;
      boolean hasByteArray_1 = false;
      boolean hasInteger_1 = false;
         
      for (Map<String, String> blocking : listBlocking){
          String sColumnName = blocking.get("INPUT_COLUMN");
          String sType = JavaTypesManager.getTypeToGenerate(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable());
          if (JavaTypesManager.isJavaPrimitiveType(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable())) continue;
        
          if (sType.equals("String")) {
          if (!hasString_1 && (!hasAtLeastOneBlock || blockColumns.contains(sColumnName))) {
            hasString_1 =true;
        
    stringBuffer.append(TEXT_242);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_254);
    
          }
        }else if(sType.equals("java.util.Date")) {
            if(!hasDate_1 && (!hasAtLeastOneBlock || blockColumns.contains(sColumnName))) {
                hasDate_1 = true;
                
    stringBuffer.append(TEXT_255);
    
              }
            } else if(sType.equals("byte[]")) {
                if (!hasByteArray_1 && (!hasAtLeastOneBlock || blockColumns.contains(sColumnName))) {
                    hasByteArray_1 = true;
                    
    stringBuffer.append(TEXT_256);
    
                  }
                } else {
                    sType =JavaTypesManager.getTypeToGenerate(table.getColumn(sColumnName).getTalendType(), false);
                    sType = sType.substring(0,1).toUpperCase() + sType.substring(1);
                    if(sType.equals("Int")){
                        
                        if(!hasInteger_1 && (!hasAtLeastOneBlock || blockColumns.contains(sColumnName))) {
                          hasInteger_1 = true;
                          
    stringBuffer.append(TEXT_257);
    stringBuffer.append( sType );
    stringBuffer.append(TEXT_258);
    stringBuffer.append( sType );
    stringBuffer.append(TEXT_259);
    
                        }
                      }
                    
                }
      }
    stringBuffer.append(TEXT_260);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_262);
      
              boolean hasAtLeast_OneRead = false;
              boolean hasAtLeast_OneObjectType = false;
         
              for (Map<String, String> blocking : listBlocking){
                String sColumnName = blocking.get("INPUT_COLUMN");
                
                if (!hasAtLeastOneBlock || blockColumns.contains(sColumnName)) {
                  hasAtLeast_OneRead = true;
                 String sType = JavaTypesManager.getTypeToGenerate(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable());

                  if (JavaTypesManager.isJavaPrimitiveType(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable())) {
                    sType=sType.substring(0,1).toUpperCase() + sType.substring(1);
                    
    stringBuffer.append(TEXT_263);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(sType);
    stringBuffer.append(TEXT_265);
    
                  } else if(sType.equals("String")) {
                  
    stringBuffer.append(TEXT_266);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_267);
    
                  } else if(sType.equals("java.util.Date")) {
                  
    stringBuffer.append(TEXT_268);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_269);
    
                  } else if(sType.equals("byte[]")) {
                  
    stringBuffer.append(TEXT_270);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_271);
    
                  } else if(sType.equals("Object") || sType.equals("BigDecimal") || sType.equals("List")) {
                    hasAtLeast_OneObjectType = true;
                    
    stringBuffer.append(TEXT_272);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_273);
    stringBuffer.append( sType );
    stringBuffer.append(TEXT_274);
    
                  } else {
                    sType =JavaTypesManager.getTypeToGenerate(table.getColumn(sColumnName).getTalendType(), false);
                    sType=sType.substring(0,1).toUpperCase()+sType.substring(1);
                    
                    if (sType.equals("Int")){
                    
    stringBuffer.append(TEXT_275);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_276);
    
                    } else {
                    
    stringBuffer.append(TEXT_277);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_279);
    stringBuffer.append( sType );
    stringBuffer.append(TEXT_280);
    
                    }
                  }
                }
              }
            
              if (hasAtLeast_OneRead) {
                  
    stringBuffer.append(TEXT_281);
    
                  }
                  if(hasAtLeast_OneObjectType) {
                  
    stringBuffer.append(TEXT_282);
    
                  }
                  
    stringBuffer.append(TEXT_283);
    
                if (!hasAtLeast_OneRead) {
                
    stringBuffer.append(TEXT_284);
    
            }
            
    stringBuffer.append(TEXT_285);
      
            boolean hasAtLeast_OneWrite = false;
            hasAtLeast_OneObjectType = false;
            
            for (Map<String, String> blocking : listBlocking){
                String sColumnName = blocking.get("INPUT_COLUMN");
              
              if (!hasAtLeastOneBlock || blockColumns.contains(sColumnName)) {
                hasAtLeast_OneWrite = true;
                String sType= JavaTypesManager.getTypeToGenerate(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable());
                
    stringBuffer.append(TEXT_286);
    stringBuffer.append(sType );
    
                if (JavaTypesManager.isJavaPrimitiveType(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable())) {
                  sType = sType.substring(0,1).toUpperCase()+sType.substring(1);
                
    stringBuffer.append(TEXT_287);
    stringBuffer.append(sType);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_289);
    
                } else if(sType.equals("String")) {
                
    stringBuffer.append(TEXT_290);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_291);
    
                } else if(sType.equals("java.util.Date")) {
                
    stringBuffer.append(TEXT_292);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_293);
    
                } else if(sType.equals("byte[]")) {
                
    stringBuffer.append(TEXT_294);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_295);
    
                } else if(sType.equals("Object") || sType.equals("BigDecimal") || sType.equals("List")) {
                
    stringBuffer.append(TEXT_296);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_297);
    
                } else {
                  sType =JavaTypesManager.getTypeToGenerate(table.getColumn(sColumnName).getTalendType(), false);
                  sType = sType.substring(0,1).toUpperCase()+sType.substring(1);
                
                  if (sType.equals("Int")){
                  
    stringBuffer.append(TEXT_298);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_299);
    
                  } else {
                  
    stringBuffer.append(TEXT_300);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(sType);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_303);
    
                  }
                }
              }
            }
            if(hasAtLeast_OneWrite) {
            
    stringBuffer.append(TEXT_304);
    
            }
            
    stringBuffer.append(TEXT_305);
    
          if(!hasAtLeast_OneWrite) {
          
    stringBuffer.append(TEXT_306);
    
          }
          
    stringBuffer.append(TEXT_307);
      
          for (Map<String, String> blocking : listBlocking){
            String sColumnName = blocking.get("INPUT_COLUMN");
            String sType = JavaTypesManager.getTypeToGenerate(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable());
              
        if (sType.equals("String")) {
        
    stringBuffer.append(TEXT_308);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_310);
    
        }else{
        
    stringBuffer.append(TEXT_311);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_313);
    
        }
      }
      
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
      
          for (Map<String, String> blocking : listBlocking){
            String sColumnName = blocking.get("INPUT_COLUMN");
         
    stringBuffer.append(TEXT_316);
    stringBuffer.append(sColumnName );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(sColumnName );
    stringBuffer.append(TEXT_318);
    
      }
    
    stringBuffer.append(TEXT_319);
    stringBuffer.append(listBlocking.size());
    stringBuffer.append(TEXT_320);
      
        for (int index=0;index<listBlocking.size();index++){
            Map<String, String> blocking=listBlocking.get(index);
            String sColumnName = blocking.get("INPUT_COLUMN");
        
    stringBuffer.append(TEXT_321);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_323);
    
        }
        
    stringBuffer.append(TEXT_324);
      
        for (int index=0;index<listBlocking.size();index++){
            Map<String, String> blocking=listBlocking.get(index);
            String sColumnName = blocking.get("INPUT_COLUMN");
            String sType = JavaTypesManager.getTypeToGenerate(table.getColumn(sColumnName).getTalendType(), table.getColumn(sColumnName).isNullable());
        
    stringBuffer.append(TEXT_325);
    stringBuffer.append(sColumnName);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(sType);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_328);
    
        }
        
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(hasAtLeastOneBlock ? "ALL_MATCHES" : "ALL_ROWS");
    stringBuffer.append(TEXT_331);
    
boolean bSortOnDisk = "true".equals(ElementParameterParser.getValue(node, "__STORE_ON_DISK__")); 
String rowsBufferSize = ElementParameterParser.getValue(node, "__ROWS_BUFFER_SIZE__");
String tempFolder = ElementParameterParser.getValue(node, "__TMP_DIRECTORY__");

if (bSortOnDisk){

    stringBuffer.append(TEXT_332);
    stringBuffer.append(hasAtLeastOneBlock ? "Sorted" : "" );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(hasAtLeastOneBlock ? "Sorted" : "" );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(TEXT_339);
    stringBuffer.append( tempFolder );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
     if (hasAtLeastOneBlock){
    stringBuffer.append(TEXT_344);
    stringBuffer.append(rowsBufferSize);
    }
    stringBuffer.append(TEXT_345);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_346);
    
} else {

    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    
}

    stringBuffer.append(TEXT_352);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_354);
    if (bSortOnDisk && hasAtLeastOneBlock){ // sorted by key
    stringBuffer.append(TEXT_355);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_356);
    }else {
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(connNameMain);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    }
    return stringBuffer.toString();
  }
}
