package org.talend.designer.codegen.translators.databases.db_jdbc;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.common.BigDataCodeGeneratorArgument;

public class TJDBCInputMrcodeJava
{
  protected static String nl;
  public static synchronized TJDBCInputMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCInputMrcodeJava result = new TJDBCInputMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            {" + NL + "                throw new Exception(\"";
  protected final String TEXT_2 = " must contain at least one Main output connection.\");" + NL + "            }";
  protected final String TEXT_3 = NL + NL + "\tpublic static class ";
  protected final String TEXT_4 = "StructInputFormat implements InputFormat<NullWritable, ";
  protected final String TEXT_5 = "Struct>, JobConfigurable {" + NL + "" + NL + "\t    private java.sql.Connection connection;" + NL + "\t\tContextProperties context;" + NL + "" + NL + "\t\tpublic void configure(JobConf job) {" + NL + "\t\t\tcontext = new ContextProperties(job);" + NL + "" + NL + "\t\t\ttry {" + NL + "\t\t\t\tClass.forName(";
  protected final String TEXT_6 = ");" + NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = "; ";
  protected final String TEXT_14 = NL + NL + "\t\t        this.connection = java.sql.DriverManager.getConnection(";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ", decryptedPassword_";
  protected final String TEXT_17 = ");" + NL + "\t\t        this.connection.setAutoCommit(false);" + NL + "\t\t\t\tthis.connection.setTransactionIsolation(java.sql.Connection.TRANSACTION_SERIALIZABLE);" + NL + "\t\t    } catch (Exception ex) {" + NL + "\t\t        throw new RuntimeException(ex);" + NL + "\t\t    }" + NL + "\t    }" + NL + "" + NL + "\t\tpublic RecordReader getRecordReader(InputSplit split, JobConf job, Reporter reporter) throws IOException {" + NL + "\t\t\ttry {" + NL + "\t\t  \t\treturn new DBRecordReader(connection, (new org.talend.hadoop.mapred.lib.db.JDBCHelper(connection)).getDBSql(split,";
  protected final String TEXT_18 = ",\"";
  protected final String TEXT_19 = "\"), split.getLength());" + NL + "\t\t  \t} catch (SQLException ex) {" + NL + "\t            throw new IOException(ex.getMessage());" + NL + "\t        }" + NL + "\t\t}" + NL + "\t\tpublic InputSplit[] getSplits(JobConf job, int numSplits) throws IOException {" + NL + "            try {" + NL + "\t            java.sql.Statement statement = connection.createStatement();" + NL + "\t" + NL + "\t            java.sql.ResultSet results = statement.executeQuery(";
  protected final String TEXT_20 = ");" + NL + "\t            results.next();" + NL + "\t" + NL + "\t            long count = results.getLong(1);" + NL + "\t            long chunkSize = (count / numSplits);" + NL + "\t" + NL + "\t            results.close();" + NL + "\t            statement.close();" + NL + "\t" + NL + "\t            InputSplit[] splits = new InputSplit[numSplits];" + NL + "\t" + NL + "\t            // Split the rows into n-number of numSplits and adjust the last chunk" + NL + "\t            // accordingly" + NL + "\t            for (int i = 0; i < numSplits; i++) {" + NL + "\t                org.talend.hadoop.mapred.lib.db.DBTableSplit split;" + NL + "\t" + NL + "\t                if ((i + 1) == numSplits)" + NL + "\t                    split = new org.talend.hadoop.mapred.lib.db.DBTableSplit(i * chunkSize, count);" + NL + "\t                else" + NL + "\t                    split = new org.talend.hadoop.mapred.lib.db.DBTableSplit(i * chunkSize, (i * chunkSize) + chunkSize);" + NL + "\t" + NL + "\t                splits[i] = split;" + NL + "\t            }" + NL + "\t" + NL + "\t            return splits;" + NL + "\t        } catch (java.sql.SQLException e) {" + NL + "\t            throw new IOException(e.getMessage());" + NL + "\t        }" + NL + "        }" + NL + "" + NL + "\t\tprotected static class DBRecordReader implements RecordReader<NullWritable, ";
  protected final String TEXT_21 = "Struct> {" + NL + "\t        private java.sql.ResultSet results;" + NL + "" + NL + "\t        private java.sql.Statement statement;" + NL + "" + NL + "\t        private long pos = 0;" + NL + "" + NL + "\t        private long splitLength = 0;" + NL + "\t        /**" + NL + "\t         * @param split The InputSplit to read data for" + NL + "\t         * @throws SQLException" + NL + "\t         */" + NL + "\t        protected DBRecordReader(java.sql.Connection connection, String query, long splitLength) throws SQLException {" + NL + "\t            statement = connection.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY, java.sql.ResultSet.CONCUR_READ_ONLY);" + NL + "\t            results = statement.executeQuery(query);" + NL + "\t            this.splitLength = splitLength; " + NL + "\t        }" + NL + "\t" + NL + "\t        /** {@inheritDoc} */" + NL + "\t        public void close() throws IOException {" + NL + "\t            try {" + NL + "\t                results.close();" + NL + "\t                statement.close();" + NL + "\t            } catch (SQLException e) {" + NL + "\t                throw new IOException(e.getMessage());" + NL + "\t            }" + NL + "\t        }" + NL + "\t" + NL + "\t        /** {@inheritDoc} */" + NL + "\t        public NullWritable createKey() {" + NL + "\t            return NullWritable.get();" + NL + "\t        }" + NL + "\t" + NL + "\t        /** {@inheritDoc} */" + NL + "\t        public ";
  protected final String TEXT_22 = "Struct createValue() {" + NL + "\t            return new ";
  protected final String TEXT_23 = "Struct();" + NL + "\t        }" + NL + "\t" + NL + "\t        /** {@inheritDoc} */" + NL + "\t        public long getPos() throws IOException {" + NL + "\t            return pos;" + NL + "\t        }" + NL + "\t" + NL + "\t        /** {@inheritDoc} */" + NL + "\t        public float getProgress() throws IOException {" + NL + "\t            return pos / (float)splitLength;" + NL + "\t        }" + NL + "\t" + NL + "\t        /** {@inheritDoc} */" + NL + "\t        public boolean next(NullWritable key, ";
  protected final String TEXT_24 = "Struct value) throws IOException{" + NL + "\t            try{" + NL + "\t                if(!results.next())" + NL + "\t                    return false;" + NL + "\t" + NL + "\t                ";
  protected final String TEXT_25 = NL + "\t\t                \tif(results.getObject(";
  protected final String TEXT_26 = ") != null){" + NL + "\t\t                    \tvalue.";
  protected final String TEXT_27 = " = results.getBoolean(";
  protected final String TEXT_28 = ");" + NL + "\t\t                    }else{" + NL + "\t\t                    \t";
  protected final String TEXT_29 = NL + "\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_30 = " = null;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t                    }" + NL + "\t\t                ";
  protected final String TEXT_33 = NL + "\t\t                \tif(results.getObject(";
  protected final String TEXT_34 = ") != null){" + NL + "\t\t                    \tvalue.";
  protected final String TEXT_35 = " = results.getByte(";
  protected final String TEXT_36 = ");" + NL + "\t\t                    }else{" + NL + "\t\t                    \t";
  protected final String TEXT_37 = NL + "\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_38 = " = null;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t                    }" + NL + "\t\t                ";
  protected final String TEXT_41 = NL + "\t\t                \tif(results.getObject(";
  protected final String TEXT_42 = ") != null){" + NL + "\t\t                    \tvalue.";
  protected final String TEXT_43 = " = results.getBytes(";
  protected final String TEXT_44 = ");" + NL + "\t\t                    }else{" + NL + "\t\t                    \t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_46 = " = null;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t                    }" + NL + "\t\t                ";
  protected final String TEXT_49 = NL + "\t\t                \tif(results.getString(";
  protected final String TEXT_50 = ") != null && results.getString(";
  protected final String TEXT_51 = ").length() > 0){" + NL + "\t\t                    \tvalue.";
  protected final String TEXT_52 = " = results.getString(";
  protected final String TEXT_53 = ").charAt(0);" + NL + "\t\t                    }else{" + NL + "\t\t                    \tif(results.getString(";
  protected final String TEXT_54 = ") == null){" + NL + "\t\t                    \t\t";
  protected final String TEXT_55 = NL + "\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_56 = " = null;" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_58 = NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tvalue.";
  protected final String TEXT_59 = " = '\\0';" + NL + "\t\t                    \t}" + NL + "\t\t                    }" + NL + "\t\t                ";
  protected final String TEXT_60 = NL + "\t\t                \ttry{" + NL + "\t\t                    \tvalue.";
  protected final String TEXT_61 = " = results.getTimestamp(";
  protected final String TEXT_62 = ");" + NL + "\t\t                    }catch(java.lang.Exception e){" + NL + "\t\t                    \tvalue.";
  protected final String TEXT_63 = " = results.getDate(";
  protected final String TEXT_64 = ");" + NL + "\t\t                    }" + NL + "\t\t                    " + NL + "\t\t                ";
  protected final String TEXT_65 = NL + "\t\t                \tif(results.getObject(";
  protected final String TEXT_66 = ") != null){" + NL + "\t\t                    \tvalue.";
  protected final String TEXT_67 = " = results.getDouble(";
  protected final String TEXT_68 = ");" + NL + "\t\t                    }else{" + NL + "\t\t                    \t";
  protected final String TEXT_69 = NL + "\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_70 = " = null;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_71 = NL + "\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t                    }" + NL + "\t\t                ";
  protected final String TEXT_73 = NL + "\t\t                \tif(results.getObject(";
  protected final String TEXT_74 = ") != null){" + NL + "\t\t                    \tvalue.";
  protected final String TEXT_75 = " = results.getFloat(";
  protected final String TEXT_76 = ");" + NL + "\t\t                    }else{" + NL + "\t\t                    \t";
  protected final String TEXT_77 = NL + "\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_78 = " = null;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_80 = NL + "\t\t                    }" + NL + "\t\t                ";
  protected final String TEXT_81 = NL + "\t\t                \tif(results.getObject(";
  protected final String TEXT_82 = ") != null){" + NL + "\t\t                    \tvalue.";
  protected final String TEXT_83 = " = results.getBigDecimal(";
  protected final String TEXT_84 = ");" + NL + "\t\t                    }else{" + NL + "\t\t                    \t";
  protected final String TEXT_85 = NL + "\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_86 = " = null;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t                    }" + NL + "\t\t                ";
  protected final String TEXT_89 = NL + "\t\t                \tif(results.getObject(";
  protected final String TEXT_90 = ") != null){" + NL + "\t\t                    \tvalue.";
  protected final String TEXT_91 = " = results.getInt(";
  protected final String TEXT_92 = ");" + NL + "\t\t                    }else{" + NL + "\t\t                    \t";
  protected final String TEXT_93 = NL + "\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_94 = " = null;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t                    }" + NL + "\t\t                ";
  protected final String TEXT_97 = NL + "\t\t                \tif(results.getObject(";
  protected final String TEXT_98 = ") != null){" + NL + "\t\t                    \tvalue.";
  protected final String TEXT_99 = " = results.getLong(";
  protected final String TEXT_100 = ");" + NL + "\t\t                    }else{" + NL + "\t\t                    \t";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_102 = " = null;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_104 = NL + "\t\t                    }" + NL + "\t\t                ";
  protected final String TEXT_105 = NL + "\t\t                \tif(results.getObject(";
  protected final String TEXT_106 = ") != null){" + NL + "\t\t                    \tvalue.";
  protected final String TEXT_107 = " = results.getObject(";
  protected final String TEXT_108 = ");" + NL + "\t\t                    }else{" + NL + "\t\t                    \t";
  protected final String TEXT_109 = NL + "\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_110 = " = null;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_112 = NL + "\t\t                    }" + NL + "\t\t                ";
  protected final String TEXT_113 = NL + "\t\t                \tif(results.getObject(";
  protected final String TEXT_114 = ") != null){" + NL + "\t\t                    \tvalue.";
  protected final String TEXT_115 = " = results.getShort(";
  protected final String TEXT_116 = ");" + NL + "\t\t                    }else{" + NL + "\t\t                    \t";
  protected final String TEXT_117 = NL + "\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_118 = " = null;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_119 = NL + "\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Null value in non-Nullable column\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t                    }" + NL + "\t\t                ";
  protected final String TEXT_121 = NL + "\t\t                \tif(results.getString(";
  protected final String TEXT_122 = ") != null){" + NL + "\t\t                    \tvalue.";
  protected final String TEXT_123 = " = results.getString(";
  protected final String TEXT_124 = ");" + NL + "\t\t                    }else{" + NL + "\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_125 = " = null;" + NL + "\t\t                    }" + NL + "\t\t                ";
  protected final String TEXT_126 = NL + "\t                    \tvalue.";
  protected final String TEXT_127 = " = (java.util.List)results.getObject(";
  protected final String TEXT_128 = ");" + NL + "\t\t                ";
  protected final String TEXT_129 = NL + "\t                pos++;" + NL + "\t            } catch (SQLException e) {" + NL + "\t                ";
  protected final String TEXT_130 = NL + "                        throw new IOException(e.getMessage());";
  protected final String TEXT_131 = NL + "\t                    System.err.println(e.getMessage());" + NL + "\t                    return next(key, value);" + NL + "\t                    ";
  protected final String TEXT_132 = NL + "\t            }" + NL + "\t            return true;" + NL + "\t        }" + NL + "\t    }" + NL + "\t}";
  protected final String TEXT_133 = NL + NL + "\tpublic static class ";
  protected final String TEXT_134 = "TemporaryStruct extends org.apache.hadoop.io.ObjectWritable {" + NL + "\t}" + NL + "" + NL + "\tpublic static class ";
  protected final String TEXT_135 = "StructInputFormat implements InputFormat<NullWritable, ";
  protected final String TEXT_136 = "TemporaryStruct>, JobConfigurable {" + NL + "" + NL + "\t\tprivate java.sql.Connection connection;" + NL + "" + NL + "\t\tContextProperties context;" + NL + "" + NL + "\t\tpublic void configure(JobConf job) {" + NL + "\t\t\tcontext = new ContextProperties(job);" + NL + "\t\t\ttry {" + NL + "\t\t\t\tClass.forName(";
  protected final String TEXT_137 = ");" + NL;
  protected final String TEXT_138 = NL;
  protected final String TEXT_139 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_140 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_141 = ");";
  protected final String TEXT_142 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_143 = " = ";
  protected final String TEXT_144 = "; ";
  protected final String TEXT_145 = NL + NL + "\t\t        this.connection = java.sql.DriverManager.getConnection(";
  protected final String TEXT_146 = ", ";
  protected final String TEXT_147 = ", decryptedPassword_";
  protected final String TEXT_148 = ");" + NL + "\t\t        this.connection.setAutoCommit(false);" + NL + "\t\t\t\tthis.connection.setTransactionIsolation(java.sql.Connection.TRANSACTION_SERIALIZABLE);" + NL + "\t\t    } catch (Exception ex) {" + NL + "\t\t        throw new RuntimeException(ex);" + NL + "\t\t    }" + NL + "\t    }" + NL + "" + NL + "\t\tpublic RecordReader getRecordReader(InputSplit split, JobConf job, Reporter reporter) throws IOException {" + NL + "\t\t\ttry {" + NL + "\t\t  \t\treturn new DBRecordReader(connection, (new org.talend.hadoop.mapred.lib.db.JDBCHelper(connection)).getDBSql(split,";
  protected final String TEXT_149 = ",\"";
  protected final String TEXT_150 = "\"), split.getLength());" + NL + "\t\t  \t} catch (SQLException ex) {" + NL + "\t            throw new IOException(ex.getMessage());" + NL + "\t        }" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic InputSplit[] getSplits(JobConf job, int numSplits) throws IOException {" + NL + "            try {" + NL + "\t            java.sql.Statement statement = connection.createStatement();" + NL + "" + NL + "\t            java.sql.ResultSet results = statement.executeQuery(";
  protected final String TEXT_151 = ");" + NL + "\t            results.next();" + NL + "" + NL + "\t            long count = results.getLong(1);" + NL + "\t            long chunkSize = (count / numSplits);" + NL + "" + NL + "\t            results.close();" + NL + "\t            statement.close();" + NL + "" + NL + "\t            InputSplit[] splits = new InputSplit[numSplits];" + NL + "" + NL + "\t            // Split the rows into n-number of numSplits and adjust the last chunk" + NL + "\t            // accordingly" + NL + "\t            for (int iterator = 0; iterator < numSplits; iterator++) {" + NL + "\t                org.talend.hadoop.mapred.lib.db.DBTableSplit split;" + NL + "" + NL + "\t                if ((iterator + 1) == numSplits) {" + NL + "\t                    split = new org.talend.hadoop.mapred.lib.db.DBTableSplit(iterator * chunkSize, count);" + NL + "\t                } else {" + NL + "\t                    split = new org.talend.hadoop.mapred.lib.db.DBTableSplit(iterator * chunkSize, (iterator * chunkSize) + chunkSize);" + NL + "\t                }" + NL + "\t                splits[iterator] = split;" + NL + "\t            }" + NL + "" + NL + "\t            return splits;" + NL + "\t        } catch (java.sql.SQLException e) {" + NL + "\t            throw new IOException(e.getMessage());" + NL + "\t        }" + NL + "        }" + NL + "" + NL + "        protected static class DBRecordReader implements RecordReader<NullWritable, ";
  protected final String TEXT_152 = "TemporaryStruct> {" + NL + "" + NL + "\t        private java.sql.ResultSet results;" + NL + "" + NL + "\t        private java.sql.Statement statement;" + NL + "" + NL + "\t        private long pos = 0;" + NL + "" + NL + "\t        private long splitLength = 0;" + NL + "" + NL + "\t        /**" + NL + "\t         * @param split The InputSplit to read data for" + NL + "\t         * @throws SQLException" + NL + "\t         */" + NL + "\t        protected DBRecordReader(java.sql.Connection connection, String query, long splitLength) throws SQLException {" + NL + "\t            statement = connection.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY, java.sql.ResultSet.CONCUR_READ_ONLY);" + NL + "\t            results = statement.executeQuery(query);" + NL + "\t            this.splitLength = splitLength; " + NL + "\t        }" + NL + "" + NL + "\t        /** {@inheritDoc} */" + NL + "\t        public void close() throws IOException {" + NL + "\t            try {" + NL + "\t                results.close();" + NL + "\t                statement.close();" + NL + "\t            } catch (SQLException e) {" + NL + "\t                throw new IOException(e.getMessage());" + NL + "\t            }" + NL + "\t        }" + NL + "" + NL + "\t        /** {@inheritDoc} */" + NL + "\t        public NullWritable createKey() {" + NL + "\t            return NullWritable.get();" + NL + "\t        }" + NL + "" + NL + "\t        /** {@inheritDoc} */" + NL + "\t        public ";
  protected final String TEXT_153 = "TemporaryStruct createValue() {" + NL + "\t            return new ";
  protected final String TEXT_154 = "TemporaryStruct();" + NL + "\t        }" + NL + "" + NL + "\t        /** {@inheritDoc} */" + NL + "\t        public long getPos() throws IOException {" + NL + "\t            return pos;" + NL + "\t        }" + NL + "" + NL + "\t        /** {@inheritDoc} */" + NL + "\t        public float getProgress() throws IOException {" + NL + "\t            return pos / (float)splitLength;" + NL + "\t        }" + NL + "" + NL + "\t        /** {@inheritDoc} */" + NL + "\t        public boolean next(NullWritable key, ";
  protected final String TEXT_155 = "TemporaryStruct value) throws IOException{" + NL + "                value.set(results);" + NL + "                try {" + NL + "                    return !results.isAfterLast();" + NL + "                } catch (SQLException sqlEx_";
  protected final String TEXT_156 = ") {" + NL + "                    return false;" + NL + "                }" + NL + "\t        }" + NL + "\t    }" + NL + "\t} // end of ";
  protected final String TEXT_157 = "StructInputFormat" + NL + "" + NL + "\tpublic static class ";
  protected final String TEXT_158 = "_InputMapper extends MapReduceBase " + NL + "    implements Mapper<NullWritable, ";
  protected final String TEXT_159 = "TemporaryStruct, NullWritable, WritableComparable>{" + NL + "        private ContextProperties context;" + NL + "        private GlobalVar globalMap;" + NL + "        public MultipleOutputs mos_";
  protected final String TEXT_160 = ";" + NL + "        private ";
  protected final String TEXT_161 = "Struct ";
  protected final String TEXT_162 = " = null;" + NL + "        private ";
  protected final String TEXT_163 = "Struct ";
  protected final String TEXT_164 = " = null;" + NL + "" + NL + "        public void configure(JobConf job_";
  protected final String TEXT_165 = "){" + NL + "            context = new ContextProperties(job_";
  protected final String TEXT_166 = ");" + NL + "            globalMap = new GlobalVar(job_";
  protected final String TEXT_167 = ");" + NL + "            mos_";
  protected final String TEXT_168 = " = new MultipleOutputs(job_";
  protected final String TEXT_169 = ");" + NL;
  protected final String TEXT_170 = NL + "            ";
  protected final String TEXT_171 = " = new ";
  protected final String TEXT_172 = "Struct();";
  protected final String TEXT_173 = NL + "            ";
  protected final String TEXT_174 = " = new ";
  protected final String TEXT_175 = "Struct();" + NL;
  protected final String TEXT_176 = NL + "                    try {" + NL + "                        FileSystem fs = FileSystem.get(job_";
  protected final String TEXT_177 = ");" + NL + "                        Path path = new Path(" + NL + "                                \"/tmp/";
  protected final String TEXT_178 = "\"" + NL + "                                + \"/tMROutput_";
  protected final String TEXT_179 = "\"" + NL + "                                + \"/";
  protected final String TEXT_180 = "\");" + NL + "                        fs.mkdirs(path);" + NL + "                    } catch (IOException ex_";
  protected final String TEXT_181 = ") {" + NL + "                        throw new RuntimeException(ex_";
  protected final String TEXT_182 = ".getMessage());" + NL + "                    }";
  protected final String TEXT_183 = NL + "        }" + NL + "" + NL + "        public void map(NullWritable key_";
  protected final String TEXT_184 = ", ";
  protected final String TEXT_185 = "TemporaryStruct value_";
  protected final String TEXT_186 = ", " + NL + "                OutputCollector<NullWritable, WritableComparable> output_";
  protected final String TEXT_187 = ", Reporter reporter_";
  protected final String TEXT_188 = ") throws IOException{" + NL + "                try {" + NL + "                ResultSet resultSet = (ResultSet)value_";
  protected final String TEXT_189 = ".get();" + NL + "                while (resultSet.next()) {" + NL + "                    try {";
  protected final String TEXT_190 = NL + "                                if(resultSet.getObject(";
  protected final String TEXT_191 = ") != null){";
  protected final String TEXT_192 = NL + "                                    ";
  protected final String TEXT_193 = ".";
  protected final String TEXT_194 = " = resultSet.getBoolean(";
  protected final String TEXT_195 = ");" + NL + "                                }else{";
  protected final String TEXT_196 = NL + "                                        ";
  protected final String TEXT_197 = ".";
  protected final String TEXT_198 = " = null;";
  protected final String TEXT_199 = NL + "                                        throw new RuntimeException(\"Null ";
  protected final String TEXT_200 = " in non-Nullable column\");";
  protected final String TEXT_201 = NL + "                                }";
  protected final String TEXT_202 = NL + "                                if(resultSet.getObject(";
  protected final String TEXT_203 = ") != null){";
  protected final String TEXT_204 = NL + "                                    ";
  protected final String TEXT_205 = ".";
  protected final String TEXT_206 = " = resultSet.getByte(";
  protected final String TEXT_207 = ");" + NL + "                                }else{";
  protected final String TEXT_208 = NL + "                                        ";
  protected final String TEXT_209 = ".";
  protected final String TEXT_210 = " = null;";
  protected final String TEXT_211 = NL + "                                        throw new RuntimeException(\"Null ";
  protected final String TEXT_212 = " in non-Nullable column\");";
  protected final String TEXT_213 = NL + "                                }";
  protected final String TEXT_214 = NL + "                                if(resultSet.getObject(";
  protected final String TEXT_215 = ") != null){";
  protected final String TEXT_216 = NL + "                                    ";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = " = resultSet.getBytes(";
  protected final String TEXT_219 = ");" + NL + "                                }else{";
  protected final String TEXT_220 = NL + "                                        ";
  protected final String TEXT_221 = ".";
  protected final String TEXT_222 = " = null;";
  protected final String TEXT_223 = NL + "                                        throw new RuntimeException(\"Null ";
  protected final String TEXT_224 = " in non-Nullable column\");";
  protected final String TEXT_225 = NL + "                                }";
  protected final String TEXT_226 = NL + "                                if(resultSet.getString(";
  protected final String TEXT_227 = ") != null && resultSet.getString(";
  protected final String TEXT_228 = ").length() > 0){";
  protected final String TEXT_229 = NL + "                                    ";
  protected final String TEXT_230 = ".";
  protected final String TEXT_231 = " = resultSet.getString(";
  protected final String TEXT_232 = ").charAt(0);" + NL + "                                }else{" + NL + "                                    if(resultSet.getString(";
  protected final String TEXT_233 = ") == null){";
  protected final String TEXT_234 = NL + "                                            ";
  protected final String TEXT_235 = ".";
  protected final String TEXT_236 = " = null;";
  protected final String TEXT_237 = NL + "                                            throw new RuntimeException(\"Null ";
  protected final String TEXT_238 = " in non-Nullable column\");";
  protected final String TEXT_239 = NL + "                                    }else{";
  protected final String TEXT_240 = NL + "                                        ";
  protected final String TEXT_241 = ".";
  protected final String TEXT_242 = " = '\\0';" + NL + "                                    }" + NL + "                                }";
  protected final String TEXT_243 = NL + "                                try{";
  protected final String TEXT_244 = NL + "                                    ";
  protected final String TEXT_245 = ".";
  protected final String TEXT_246 = " = resultSet.getTimestamp(";
  protected final String TEXT_247 = ");" + NL + "                                }catch(java.lang.Exception e){";
  protected final String TEXT_248 = NL + "                                    ";
  protected final String TEXT_249 = ".";
  protected final String TEXT_250 = " = resultSet.getDate(";
  protected final String TEXT_251 = ");" + NL + "                                }";
  protected final String TEXT_252 = NL + "                                if(resultSet.getObject(";
  protected final String TEXT_253 = ") != null){";
  protected final String TEXT_254 = NL + "                                    ";
  protected final String TEXT_255 = ".";
  protected final String TEXT_256 = " = resultSet.getDouble(";
  protected final String TEXT_257 = ");" + NL + "                                }else{";
  protected final String TEXT_258 = NL + "                                        ";
  protected final String TEXT_259 = ".";
  protected final String TEXT_260 = " = null;";
  protected final String TEXT_261 = NL + "                                        throw new RuntimeException(\"Null ";
  protected final String TEXT_262 = " in non-Nullable column\");";
  protected final String TEXT_263 = NL + "                                }";
  protected final String TEXT_264 = NL + "                                if(resultSet.getObject(";
  protected final String TEXT_265 = ") != null){";
  protected final String TEXT_266 = NL + "                                    ";
  protected final String TEXT_267 = ".";
  protected final String TEXT_268 = " = resultSet.getFloat(";
  protected final String TEXT_269 = ");" + NL + "                                }else{";
  protected final String TEXT_270 = NL + "                                        ";
  protected final String TEXT_271 = ".";
  protected final String TEXT_272 = " = null;";
  protected final String TEXT_273 = NL + "                                        throw new RuntimeException(\"Null ";
  protected final String TEXT_274 = " in non-Nullable column\");";
  protected final String TEXT_275 = NL + "                                }";
  protected final String TEXT_276 = NL + "                                if(resultSet.getObject(";
  protected final String TEXT_277 = ") != null){";
  protected final String TEXT_278 = NL + "                                    ";
  protected final String TEXT_279 = ".";
  protected final String TEXT_280 = " = resultSet.getBigDecimal(";
  protected final String TEXT_281 = ");" + NL + "                                }else{";
  protected final String TEXT_282 = NL + "                                        ";
  protected final String TEXT_283 = ".";
  protected final String TEXT_284 = " = null;";
  protected final String TEXT_285 = NL + "                                        throw new RuntimeException(\"Null ";
  protected final String TEXT_286 = " in non-Nullable column\");";
  protected final String TEXT_287 = NL + "                                }";
  protected final String TEXT_288 = NL + "                                if(resultSet.getObject(";
  protected final String TEXT_289 = ") != null){";
  protected final String TEXT_290 = NL + "                                    ";
  protected final String TEXT_291 = ".";
  protected final String TEXT_292 = " = resultSet.getInt(";
  protected final String TEXT_293 = ");" + NL + "                                }else{";
  protected final String TEXT_294 = NL + "                                        ";
  protected final String TEXT_295 = ".";
  protected final String TEXT_296 = " = null;";
  protected final String TEXT_297 = NL + "                                        throw new RuntimeException(\"Null ";
  protected final String TEXT_298 = " in non-Nullable column\");";
  protected final String TEXT_299 = NL + "                                }";
  protected final String TEXT_300 = NL + "                                if(resultSet.getObject(";
  protected final String TEXT_301 = ") != null){";
  protected final String TEXT_302 = NL + "                                    ";
  protected final String TEXT_303 = ".";
  protected final String TEXT_304 = " = resultSet.getLong(";
  protected final String TEXT_305 = ");" + NL + "                                }else{";
  protected final String TEXT_306 = NL + "                                        ";
  protected final String TEXT_307 = ".";
  protected final String TEXT_308 = " = null;";
  protected final String TEXT_309 = NL + "                                        throw new RuntimeException(\"Null ";
  protected final String TEXT_310 = " in non-Nullable column\");";
  protected final String TEXT_311 = NL + "                                }";
  protected final String TEXT_312 = NL + "                                if(resultSet.getObject(";
  protected final String TEXT_313 = ") != null){";
  protected final String TEXT_314 = NL + "                                    ";
  protected final String TEXT_315 = ".";
  protected final String TEXT_316 = " = resultSet.getObject(";
  protected final String TEXT_317 = ");" + NL + "                                }else{";
  protected final String TEXT_318 = NL + "                                        ";
  protected final String TEXT_319 = ".";
  protected final String TEXT_320 = " = null;";
  protected final String TEXT_321 = NL + "                                        throw new RuntimeException(\"Null ";
  protected final String TEXT_322 = " in non-Nullable column\");";
  protected final String TEXT_323 = NL + "                                }";
  protected final String TEXT_324 = NL + "                                if(resultSet.getObject(";
  protected final String TEXT_325 = ") != null){";
  protected final String TEXT_326 = NL + "                                    ";
  protected final String TEXT_327 = ".";
  protected final String TEXT_328 = " = resultSet.getShort(";
  protected final String TEXT_329 = ");" + NL + "                                }else{";
  protected final String TEXT_330 = NL + "                                        ";
  protected final String TEXT_331 = ".";
  protected final String TEXT_332 = " = null;";
  protected final String TEXT_333 = NL + "                                        throw new RuntimeException(\"Null ";
  protected final String TEXT_334 = " in non-Nullable column\");";
  protected final String TEXT_335 = NL + "                                }";
  protected final String TEXT_336 = NL + "                                if(resultSet.getString(";
  protected final String TEXT_337 = ") != null){";
  protected final String TEXT_338 = NL + "                                    ";
  protected final String TEXT_339 = ".";
  protected final String TEXT_340 = " = resultSet.getString(";
  protected final String TEXT_341 = ");" + NL + "                                }else{";
  protected final String TEXT_342 = NL + "                                    ";
  protected final String TEXT_343 = ".";
  protected final String TEXT_344 = " = null;" + NL + "                                }";
  protected final String TEXT_345 = NL + "                                ";
  protected final String TEXT_346 = ".";
  protected final String TEXT_347 = " = (java.util.List)resultSet.getObject(";
  protected final String TEXT_348 = ");";
  protected final String TEXT_349 = NL + "                        output_";
  protected final String TEXT_350 = ".collect(NullWritable.get(), ";
  protected final String TEXT_351 = ");" + NL + "                    } catch (Exception ex_";
  protected final String TEXT_352 = ") {";
  protected final String TEXT_353 = NL + "                        ";
  protected final String TEXT_354 = ".invalidInputLine = value_";
  protected final String TEXT_355 = ".toString();";
  protected final String TEXT_356 = NL + "                        ";
  protected final String TEXT_357 = ".errorCode = ex_";
  protected final String TEXT_358 = ".toString();" + NL + "                        mos_";
  protected final String TEXT_359 = ".getCollector(\"";
  protected final String TEXT_360 = "\", reporter_";
  protected final String TEXT_361 = ")" + NL + "                                .collect(NullWritable.get(), ";
  protected final String TEXT_362 = ");" + NL + "                    }" + NL + "                }" + NL + "            } catch (SQLException sqlEx_";
  protected final String TEXT_363 = ") {";
  protected final String TEXT_364 = NL + "                ";
  protected final String TEXT_365 = ".invalidInputLine = value_";
  protected final String TEXT_366 = ".toString();";
  protected final String TEXT_367 = NL + "                ";
  protected final String TEXT_368 = ".errorCode = sqlEx_";
  protected final String TEXT_369 = ".toString();" + NL + "                mos_";
  protected final String TEXT_370 = ".getCollector(\"";
  protected final String TEXT_371 = "\", reporter_";
  protected final String TEXT_372 = ")" + NL + "                        .collect(NullWritable.get(), ";
  protected final String TEXT_373 = ");" + NL + "            }" + NL + "        }" + NL + "" + NL + "        public void close() throws IOException{" + NL + "            mos_";
  protected final String TEXT_374 = ".close();" + NL + "        }" + NL + "    } // end of ";
  protected final String TEXT_375 = "_InputMapper" + NL + "" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null) && (metadatas.size() > 0)) {
    // We don't what to get the metadata of the main flow, so we check if the current metadata is not the reject flow
    int flowMetadataPosition = 0;
    while ((flowMetadataPosition < metadatas.size()) && ("REJECT".equals(metadatas.get(flowMetadataPosition).getTableName()))) {
        flowMetadataPosition++;
    }
    IMetadataTable metadata = metadatas.get(flowMetadataPosition);

    if (metadata != null) {

        String url = ElementParameterParser.getValue(node, "__URL__");
        String driverClass = ElementParameterParser.getValue(node, "__DRIVER_CLASS__");
        String dbuser = ElementParameterParser.getValue(node, "__USER__");
         String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
        boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
        dbquery = dbquery.replaceAll("\n"," ");
        dbquery = dbquery.replaceAll("\r"," ");
        String dbCountQuery = "\"select count(*) from (\"+" + dbquery + "+\") talendTable\"";

        List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
        List< ? extends IConnection> rejectedConnections = node.getOutgoingConnections("REJECT");

        // Fail fast when no output connections exist.
        if (conns == null || conns.size() == 0)
            return "";

        // Fail fast when only reject connections exist (there must be at least
        // one main connection for this component.)
        if (rejectedConnections != null && rejectedConnections.size() == conns.size()) {
            
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
        } else if ((rejectedConnections == null) || (rejectedConnections.size() == 0)) {
            
    
IConnection conn = conns.get(0);
String connName = conn.getName();

if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

	List<IMetadataColumn> columns = metadata.getListColumns();
	String columnStr="";
	String firstColumn="";
	for(IMetadataColumn column:columns){
		if(columnStr!=""){
			columnStr +=",";
		}else{
			firstColumn = column.getOriginalDbColumnName();
		}
		columnStr +=column.getOriginalDbColumnName();
	}
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_6);
    
                String passwordFieldName = "__PASS__";
                
    stringBuffer.append(TEXT_7);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_10);
    } else {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(columnStr);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(dbCountQuery);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_24);
    
	                int i = 1;
		            for(IMetadataColumn column: columns){
		                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate);
		                if("Boolean".equals(typeToGenerate) || "boolean".equals(typeToGenerate)){
		                
    stringBuffer.append(TEXT_25);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_28);
    
		                    	if(column.isNullable()){
								
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_30);
    
								}else{
								
    stringBuffer.append(TEXT_31);
    
								}
								
    stringBuffer.append(TEXT_32);
    
		                }else if("Byte".equals(typeToGenerate) || "byte".equals(typeToGenerate)){
		                
    stringBuffer.append(TEXT_33);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_36);
    
		                    	if(column.isNullable()){
								
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_38);
    
								}else{
								
    stringBuffer.append(TEXT_39);
    
								}
								
    stringBuffer.append(TEXT_40);
    
		                }else if("byte[]".equals(typeToGenerate)){
		                
    stringBuffer.append(TEXT_41);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_44);
    
		                    	if(column.isNullable()){
								
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_46);
    
								}else{
								
    stringBuffer.append(TEXT_47);
    
								}
								
    stringBuffer.append(TEXT_48);
    
		                }else if("char".equals(typeToGenerate) || "Character".equals(typeToGenerate)){
		                
    stringBuffer.append(TEXT_49);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_54);
    
			                    	if(column.isNullable()){
									
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_56);
    
									}else{
									
    stringBuffer.append(TEXT_57);
    
									}
									
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_59);
    
		                }else if("java.util.Date".equals(typeToGenerate)){
		                
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_64);
    
		                }else if("Double".equals(typeToGenerate) || "double".equals(typeToGenerate)){
		                
    stringBuffer.append(TEXT_65);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_68);
    
		                    	if(column.isNullable()){
								
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_70);
    
								}else{
								
    stringBuffer.append(TEXT_71);
    
								}
								
    stringBuffer.append(TEXT_72);
    
		                }else if("Float".equals(typeToGenerate) || "float".equals(typeToGenerate)){
		                
    stringBuffer.append(TEXT_73);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_76);
    
		                    	if(column.isNullable()){
								
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_78);
    
								}else{
								
    stringBuffer.append(TEXT_79);
    
								}
								
    stringBuffer.append(TEXT_80);
    
		                }else if("BigDecimal".equals(typeToGenerate)){
		                
    stringBuffer.append(TEXT_81);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_84);
    
		                    	if(column.isNullable()){
								
    stringBuffer.append(TEXT_85);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_86);
    
								}else{
								
    stringBuffer.append(TEXT_87);
    
								}
								
    stringBuffer.append(TEXT_88);
    
		                }else if("Integer".equals(typeToGenerate) || "int".equals(typeToGenerate)){
		                
    stringBuffer.append(TEXT_89);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_92);
    
		                    	if(column.isNullable()){
								
    stringBuffer.append(TEXT_93);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_94);
    
								}else{
								
    stringBuffer.append(TEXT_95);
    
								}
								
    stringBuffer.append(TEXT_96);
    
		                }else if("Long".equals(typeToGenerate) || "long".equals(typeToGenerate)){
		                
    stringBuffer.append(TEXT_97);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_100);
    
		                    	if(column.isNullable()){
								
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_102);
    
								}else{
								
    stringBuffer.append(TEXT_103);
    
								}
								
    stringBuffer.append(TEXT_104);
    
		                }else if("Object".equals(typeToGenerate)){
		                
    stringBuffer.append(TEXT_105);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_108);
    
		                    	if(column.isNullable()){
								
    stringBuffer.append(TEXT_109);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_110);
    
								}else{
								
    stringBuffer.append(TEXT_111);
    
								}
								
    stringBuffer.append(TEXT_112);
    
		                }else if("Short".equals(typeToGenerate) || "short".equals(typeToGenerate)){
		                
    stringBuffer.append(TEXT_113);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_116);
    
		                    	if(column.isNullable()){
								
    stringBuffer.append(TEXT_117);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_118);
    
								}else{
								
    stringBuffer.append(TEXT_119);
    
								}
								
    stringBuffer.append(TEXT_120);
    
		                }else if("String".equals(typeToGenerate)){
		                
    stringBuffer.append(TEXT_121);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_125);
    
		                }else if("List".equals(typeToGenerate)){
		                
    stringBuffer.append(TEXT_126);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_128);
    
		                }
		        		i++;
		            }
	                
    stringBuffer.append(TEXT_129);
    
	                if (dieOnError) {
	                    
    stringBuffer.append(TEXT_130);
    
	                } else {
	                    
    stringBuffer.append(TEXT_131);
    
	                }
	                
    stringBuffer.append(TEXT_132);
    
}

    
        } else if ((rejectedConnections != null)  && (rejectedConnections.size() == 1)){
            
    
List< ? extends IConnection> mainConnections = node.getOutgoingConnections("FLOW");
IConnection mainConnection = mainConnections.get(0);
String mainConnectionName = mainConnection.getName();
IConnection rejectedConnection = rejectedConnections.get(0);
String rejectedConnectionName = rejectedConnection.getName();

if (mainConnection.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

	List<IMetadataColumn> columns = metadata.getListColumns();
	String columnStr="";
	String firstColumn="";
	for(IMetadataColumn column:columns){
		if(columnStr!=""){
			columnStr +=",";
		}else{
			firstColumn = column.getOriginalDbColumnName();
		}
		columnStr +=column.getOriginalDbColumnName();
	}
	
    stringBuffer.append(TEXT_133);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_137);
    
                String passwordFieldName = "__PASS__";
                
    stringBuffer.append(TEXT_138);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_141);
    } else {
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_144);
    }
    stringBuffer.append(TEXT_145);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(columnStr);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(dbCountQuery);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_175);
    
            // Force the creation of the output directory
            for (INode virtualNode : node.getProcess().getGraphicalNodes()) {
                if (virtualNode.getUniqueName().equals(cid)) {
                    
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(node.getProcess().getName());
    stringBuffer.append(TEXT_178);
    stringBuffer.append(virtualNode.getUniqueName());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(virtualNode.getOutgoingConnections("REJECT").get(0).getName());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
                    break;
                }
            }
            
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    
                        int i = 1;
                        for(IMetadataColumn column: columns){
                            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                            String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate);
                            if("Boolean".equals(typeToGenerate) || "boolean".equals(typeToGenerate)){
                            
    stringBuffer.append(TEXT_190);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_194);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_195);
    
                                    if(column.isNullable()){
                                    
    stringBuffer.append(TEXT_196);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_198);
    
                                    }else{
                                    
    stringBuffer.append(TEXT_199);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_200);
    
                                    }
                                    
    stringBuffer.append(TEXT_201);
    
                            }else if("Byte".equals(typeToGenerate) || "byte".equals(typeToGenerate)){
                            
    stringBuffer.append(TEXT_202);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_206);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_207);
    
                                    if(column.isNullable()){
                                    
    stringBuffer.append(TEXT_208);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_210);
    
                                    }else{
                                    
    stringBuffer.append(TEXT_211);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_212);
    
                                    }
                                    
    stringBuffer.append(TEXT_213);
    
                            }else if("byte[]".equals(typeToGenerate)){
                            
    stringBuffer.append(TEXT_214);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_218);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_219);
    
                                    if(column.isNullable()){
                                    
    stringBuffer.append(TEXT_220);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_222);
    
                                    }else{
                                    
    stringBuffer.append(TEXT_223);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_224);
    
                                    }
                                    
    stringBuffer.append(TEXT_225);
    
                            }else if("char".equals(typeToGenerate) || "Character".equals(typeToGenerate)){
                            
    stringBuffer.append(TEXT_226);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_231);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_233);
    
                                        if(column.isNullable()){
                                        
    stringBuffer.append(TEXT_234);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_236);
    
                                        }else{
                                        
    stringBuffer.append(TEXT_237);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_238);
    
                                        }
                                        
    stringBuffer.append(TEXT_239);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_242);
    
                            }else if("java.util.Date".equals(typeToGenerate)){
                            
    stringBuffer.append(TEXT_243);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_246);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_250);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_251);
    
                            }else if("Double".equals(typeToGenerate) || "double".equals(typeToGenerate)){
                            
    stringBuffer.append(TEXT_252);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_256);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_257);
    
                                    if(column.isNullable()){
                                    
    stringBuffer.append(TEXT_258);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_260);
    
                                    }else{
                                    
    stringBuffer.append(TEXT_261);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_262);
    
                                    }
                                    
    stringBuffer.append(TEXT_263);
    
                            }else if("Float".equals(typeToGenerate) || "float".equals(typeToGenerate)){
                            
    stringBuffer.append(TEXT_264);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_268);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_269);
    
                                    if(column.isNullable()){
                                    
    stringBuffer.append(TEXT_270);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_272);
    
                                    }else{
                                    
    stringBuffer.append(TEXT_273);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_274);
    
                                    }
                                    
    stringBuffer.append(TEXT_275);
    
                            }else if("BigDecimal".equals(typeToGenerate)){
                            
    stringBuffer.append(TEXT_276);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_280);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_281);
    
                                    if(column.isNullable()){
                                    
    stringBuffer.append(TEXT_282);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_284);
    
                                    }else{
                                    
    stringBuffer.append(TEXT_285);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_286);
    
                                    }
                                    
    stringBuffer.append(TEXT_287);
    
                            }else if("Integer".equals(typeToGenerate) || "int".equals(typeToGenerate)){
                            
    stringBuffer.append(TEXT_288);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_292);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_293);
    
                                    if(column.isNullable()){
                                    
    stringBuffer.append(TEXT_294);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_296);
    
                                    }else{
                                    
    stringBuffer.append(TEXT_297);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_298);
    
                                    }
                                    
    stringBuffer.append(TEXT_299);
    
                            }else if("Long".equals(typeToGenerate) || "long".equals(typeToGenerate)){
                            
    stringBuffer.append(TEXT_300);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_304);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_305);
    
                                    if(column.isNullable()){
                                    
    stringBuffer.append(TEXT_306);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_308);
    
                                    }else{
                                    
    stringBuffer.append(TEXT_309);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_310);
    
                                    }
                                    
    stringBuffer.append(TEXT_311);
    
                            }else if("Object".equals(typeToGenerate)){
                            
    stringBuffer.append(TEXT_312);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_316);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_317);
    
                                    if(column.isNullable()){
                                    
    stringBuffer.append(TEXT_318);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_320);
    
                                    }else{
                                    
    stringBuffer.append(TEXT_321);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_322);
    
                                    }
                                    
    stringBuffer.append(TEXT_323);
    
                            }else if("Short".equals(typeToGenerate) || "short".equals(typeToGenerate)){
                            
    stringBuffer.append(TEXT_324);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_328);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_329);
    
                                    if(column.isNullable()){
                                    
    stringBuffer.append(TEXT_330);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_332);
    
                                    }else{
                                    
    stringBuffer.append(TEXT_333);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_334);
    
                                    }
                                    
    stringBuffer.append(TEXT_335);
    
                            }else if("String".equals(typeToGenerate)){
                            
    stringBuffer.append(TEXT_336);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_340);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_344);
    
                            }else if("List".equals(typeToGenerate)){
                            
    stringBuffer.append(TEXT_345);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_347);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_348);
    
                            }
                            i++;
                        }
                        
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    
}

    
        }
    }
}

    return stringBuffer.toString();
  }
}
