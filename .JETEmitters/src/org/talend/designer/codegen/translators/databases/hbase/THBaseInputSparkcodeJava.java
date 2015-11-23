package org.talend.designer.codegen.translators.databases.hbase;

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

public class THBaseInputSparkcodeJava
{
  protected static String nl;
  public static synchronized THBaseInputSparkcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseInputSparkcodeJava result = new THBaseInputSparkcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    " + NL + "    public static class ";
  protected final String TEXT_2 = "TemporaryStruct extends org.apache.hadoop.io.ObjectWritable {" + NL + "    }" + NL + "    " + NL + "    public static class ";
  protected final String TEXT_3 = "StructInputFormat implements InputFormat<NullWritable, ";
  protected final String TEXT_4 = "TemporaryStruct>, JobConfigurable {" + NL + "        private org.apache.hadoop.hbase.client.HTable hTable;" + NL + "" + NL + "        private byte[][] inputColumns;" + NL + "        " + NL + "        ContextProperties context;" + NL + "        " + NL + "        public void configure(JobConf job_";
  protected final String TEXT_5 = ") {" + NL + "            context = new ContextProperties(job_";
  protected final String TEXT_6 = ");" + NL + "            JobConf hbaseJob = new JobConf(job_";
  protected final String TEXT_7 = ");" + NL + "            hbaseJob.set(\"hbase.zookeeper.quorum\", ";
  protected final String TEXT_8 = ");" + NL + "            hbaseJob.set(\"hbase.zookeeper.property.clientPort\", ";
  protected final String TEXT_9 = ");" + NL + "            ";
  protected final String TEXT_10 = NL + "            hbaseJob.set(\"zookeeper.znode.parent\",";
  protected final String TEXT_11 = "); ";
  protected final String TEXT_12 = NL + "            hbaseJob.set(\"hbase.table.namespace.mappings\", ";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "                hbaseJob.set(";
  protected final String TEXT_15 = ",";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "            try {" + NL + "                this.hTable = new org.apache.hadoop.hbase.client.HTable(hbaseJob, ";
  protected final String TEXT_18 = ");" + NL + "            } catch (Exception ex) {" + NL + "                throw new RuntimeException(ex);" + NL + "            }";
  protected final String TEXT_19 = NL + "            this.inputColumns = new byte[";
  protected final String TEXT_20 = "][];";
  protected final String TEXT_21 = NL + "                this.inputColumns[";
  protected final String TEXT_22 = "] = org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_23 = "+org.apache.hadoop.hbase.KeyValue.COLUMN_FAMILY_DELIMITER+\"";
  protected final String TEXT_24 = "\");";
  protected final String TEXT_25 = NL + "                    try {" + NL + "                        FileSystem fs = FileSystem.get(job_";
  protected final String TEXT_26 = ");" + NL + "                        Path path = new Path(" + NL + "                                \"/tmp/";
  protected final String TEXT_27 = "\"" + NL + "                                + \"/tMROutput_";
  protected final String TEXT_28 = "\"" + NL + "                                + \"/";
  protected final String TEXT_29 = "\");" + NL + "                        fs.mkdirs(path);" + NL + "                    } catch (IOException ex_";
  protected final String TEXT_30 = ") {" + NL + "                        throw new RuntimeException(ex_";
  protected final String TEXT_31 = ".getMessage());" + NL + "                    }";
  protected final String TEXT_32 = NL + "        }" + NL + "        " + NL + "        public RecordReader getRecordReader(InputSplit inputsplit, JobConf job, Reporter reporter) throws IOException {" + NL + "           return new HBaseTableRecordReader((HBaseTableSplit) inputsplit, job, this.hTable, this.inputColumns);" + NL + "        }" + NL + "        " + NL + "        protected static class HBaseTableRecordReader implements RecordReader<NullWritable, ";
  protected final String TEXT_33 = "TemporaryStruct> {" + NL + "" + NL + "            private JobConf job;" + NL + "" + NL + "            private HBaseTableSplit split;" + NL + "" + NL + "            private org.apache.hadoop.hbase.client.ResultScanner scanner;" + NL + "" + NL + "            private byte[] startRow;" + NL + "" + NL + "            private byte[] endRow;" + NL + "" + NL + "            private byte[] lastSuccessfulRow;" + NL + "            " + NL + "            private org.apache.hadoop.hbase.client.HTable hTable;" + NL + "" + NL + "            private byte[][] inputColumns;" + NL + "            " + NL + "            private org.apache.hadoop.hbase.filter.FilterList filterList;" + NL + "            " + NL + "            ContextProperties context;" + NL + "" + NL + "            protected HBaseTableRecordReader(HBaseTableSplit split, JobConf job, org.apache.hadoop.hbase.client.HTable hTable, byte[][] inputColumns) throws IOException {" + NL + "                context = new ContextProperties(job);" + NL + "                this.hTable = hTable;" + NL + "                this.inputColumns = inputColumns;" + NL + "                this.split = split;" + NL + "                this.job = job;" + NL + "                this.startRow = split.getStartRow();" + NL + "                this.endRow = split.getEndRow();" + NL + "                initFilter();" + NL + "                restart(startRow);" + NL + "            }" + NL + "            " + NL + "            private void initFilter(){";
  protected final String TEXT_34 = NL + "                        String [] multipleValues = null;" + NL + "                        byte [][] multipleBytesValues = null;";
  protected final String TEXT_35 = "  " + NL + "                    this.filterList = new org.apache.hadoop.hbase.filter.FilterList(org.apache.hadoop.hbase.filter.FilterList.Operator.";
  protected final String TEXT_36 = ");" + NL + "                    org.apache.hadoop.hbase.filter.Filter filter = null;";
  protected final String TEXT_37 = NL + "                                filter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_38 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_39 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_40 = ", org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_41 = "));";
  protected final String TEXT_42 = NL + "                                filter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_43 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_44 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_45 = ", new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_46 = "));";
  protected final String TEXT_47 = NL + "                                filter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_48 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_49 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_50 = ", new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_51 = "));";
  protected final String TEXT_52 = NL + "                                filter = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_53 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_54 = ")));";
  protected final String TEXT_55 = NL + "                                filter = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_56 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_57 = "));";
  protected final String TEXT_58 = NL + "                                filter = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_59 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_60 = "));";
  protected final String TEXT_61 = NL + "                                filter = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_62 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_63 = ")));";
  protected final String TEXT_64 = NL + "                                filter = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_65 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_66 = "));";
  protected final String TEXT_67 = NL + "                                filter = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_68 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_69 = "));";
  protected final String TEXT_70 = NL + "                                scan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_71 = "));";
  protected final String TEXT_72 = NL + "                            filter = new org.apache.hadoop.hbase.filter.ColumnPrefixFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_73 = "));";
  protected final String TEXT_74 = NL + "                                scan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_75 = "));";
  protected final String TEXT_76 = NL + "                            if(";
  protected final String TEXT_77 = "!=null && !\"\".equals(";
  protected final String TEXT_78 = ")){" + NL + "                                multipleValues = ";
  protected final String TEXT_79 = ".split(\",\");" + NL + "                                multipleBytesValues = new byte [multipleValues.length] [];" + NL + "                                for(int i=0;i< multipleValues.length;i++){" + NL + "                                    multipleBytesValues[i] = org.apache.hadoop.hbase.util.Bytes.toBytes(multipleValues[i]);" + NL + "                                }" + NL + "                                filter =  new org.apache.hadoop.hbase.filter.MultipleColumnPrefixFilter(multipleBytesValues);" + NL + "                            }";
  protected final String TEXT_80 = NL + "                                scan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_81 = "));";
  protected final String TEXT_82 = NL + "                            filter = new org.apache.hadoop.hbase.filter.ColumnRangeFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_83 = ".split(\",\")[0]),true,org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_84 = ".split(\",\")[1]),true);";
  protected final String TEXT_85 = NL + "                                filter = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_86 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_87 = ")));";
  protected final String TEXT_88 = NL + "                                filter = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_89 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_90 = "));";
  protected final String TEXT_91 = NL + "                                filter = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_92 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_93 = "));";
  protected final String TEXT_94 = NL + "                                filter = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_95 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_96 = ")));";
  protected final String TEXT_97 = NL + "                                filter = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_98 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_99 = "));";
  protected final String TEXT_100 = NL + "                                filter = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_101 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_102 = "));";
  protected final String TEXT_103 = NL + "                        this.filterList.addFilter(filter);";
  protected final String TEXT_104 = "                  " + NL + "            }" + NL + "            " + NL + "            private void setFilter(org.apache.hadoop.hbase.client.Scan scan){" + NL + "                if(this.filterList != null){" + NL + "                    scan.setFilter(this.filterList);" + NL + "                    scan.setCacheBlocks(false);" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public void restart(byte[] firstRow) throws IOException {" + NL + "                org.apache.hadoop.hbase.client.Scan scan;" + NL + "                if ((endRow != null) && (endRow.length > 0)) {" + NL + "                    scan = new org.apache.hadoop.hbase.client.Scan(firstRow, endRow);" + NL + "                } else {" + NL + "                    scan = new org.apache.hadoop.hbase.client.Scan(firstRow);" + NL + "                }" + NL + "                for (byte[] column : inputColumns) {" + NL + "                    byte[][] fq = org.apache.hadoop.hbase.KeyValue.parseColumn(column);" + NL + "                    if (fq.length > 1 && fq[1] != null && fq[1].length > 0) {" + NL + "                        scan.addColumn(fq[0], fq[1]);" + NL + "                    } else {" + NL + "                        scan.addFamily(fq[0]);" + NL + "                    }" + NL + "                }" + NL + "                setFilter(scan);                                    " + NL + "                this.scanner = hTable.getScanner(scan);" + NL + "            }" + NL + "" + NL + "            public void close() throws IOException {" + NL + "                this.scanner.close();" + NL + "            }" + NL + "" + NL + "            public NullWritable createKey() {" + NL + "                return NullWritable.get();" + NL + "            }" + NL + "" + NL + "            public ";
  protected final String TEXT_105 = "TemporaryStruct createValue() {" + NL + "                return new ";
  protected final String TEXT_106 = "TemporaryStruct();" + NL + "            }" + NL + "" + NL + "            public long getPos() throws IOException {" + NL + "                // This should be the ordinal tuple in the range;" + NL + "                // not clear how to calculate..." + NL + "                return 0;" + NL + "            }" + NL + "" + NL + "            public float getProgress() throws IOException {" + NL + "                // Depends on the total number of tuples and getPos" + NL + "                return 0;" + NL + "            }" + NL + "" + NL + "            public boolean next(NullWritable key, ";
  protected final String TEXT_107 = "TemporaryStruct value) throws IOException {" + NL + "                org.apache.hadoop.hbase.client.Result result;" + NL + "                try {" + NL + "                    try {" + NL + "                        result = this.scanner.next();" + NL + "                    } catch (IOException e) {" + NL + "                        if (lastSuccessfulRow == null) {" + NL + "                            restart(startRow);" + NL + "                        } else {" + NL + "                            restart(lastSuccessfulRow);" + NL + "                            this.scanner.next();" + NL + "                        }" + NL + "                        result = this.scanner.next();" + NL + "                    }" + NL + "" + NL + "                    if (result != null && result.size() > 0) {" + NL + "                        value.set(result);" + NL + "                        org.apache.hadoop.hbase.io.ImmutableBytesWritable rowKey = new org.apache.hadoop.hbase.io.ImmutableBytesWritable();" + NL + "                        rowKey.set(result.getRow());" + NL + "                        lastSuccessfulRow = rowKey.get();" + NL + "                        return true;" + NL + "                    }" + NL + "                    return false;" + NL + "                } catch (IOException ioe) {" + NL + "                    throw ioe;" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "        " + NL + "        public InputSplit[] getSplits(JobConf job, int numSplits) throws IOException {" + NL + "            if (this.hTable == null) {" + NL + "                throw new IOException(\"No table was provided\");" + NL + "            }" + NL + "            byte[][] startKeys = this.hTable.getStartKeys();" + NL + "            if (startKeys == null || startKeys.length == 0) {" + NL + "                throw new IOException(\"Expecting at least one region\");" + NL + "            }" + NL + "            if (this.inputColumns == null || this.inputColumns.length == 0) {" + NL + "                throw new IOException(\"Expecting at least one column\");" + NL + "            }" + NL + "            int realNumSplits = numSplits > startKeys.length ? startKeys.length : numSplits;" + NL + "            InputSplit[] splits = new InputSplit[realNumSplits];" + NL + "            int middle = startKeys.length / realNumSplits;" + NL + "            int startPos = 0;" + NL + "            for (int i = 0; i < realNumSplits; i++) {" + NL + "                int lastPos = startPos + middle;" + NL + "                lastPos = startKeys.length % realNumSplits > i ? lastPos + 1 : lastPos;" + NL + "                String regionLocation = hTable.getRegionLocation(startKeys[startPos]).getHostname();" + NL + "                splits[i] = new HBaseTableSplit(this.hTable.getTableName(), startKeys[startPos]," + NL + "                        ((i + 1) < realNumSplits) ? startKeys[lastPos] : org.apache.hadoop.hbase.HConstants.EMPTY_START_ROW, regionLocation);" + NL + "                startPos = lastPos;" + NL + "            }" + NL + "            return splits;" + NL + "        }" + NL + "        " + NL + "        protected static class HBaseTableSplit implements InputSplit, Comparable<HBaseTableSplit> {" + NL + "" + NL + "            private byte[] m_tableName;" + NL + "" + NL + "            private byte[] m_startRow;" + NL + "" + NL + "            private byte[] m_endRow;" + NL + "" + NL + "            private String m_regionLocation;" + NL + "" + NL + "            public HBaseTableSplit() {" + NL + "                this(org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, \"\");" + NL + "            }" + NL + "" + NL + "            public HBaseTableSplit(byte[] tableName, byte[] startRow, byte[] endRow, final String location) {" + NL + "                this.m_tableName = tableName;" + NL + "                this.m_startRow = startRow;" + NL + "                this.m_endRow = endRow;" + NL + "                this.m_regionLocation = location;" + NL + "            }" + NL + "" + NL + "            public byte[] getTableName() {" + NL + "                return this.m_tableName;" + NL + "            }" + NL + "" + NL + "            public byte[] getStartRow() {" + NL + "                return this.m_startRow;" + NL + "            }" + NL + "" + NL + "            public byte[] getEndRow() {" + NL + "                return this.m_endRow;" + NL + "            }" + NL + "" + NL + "            public String getRegionLocation() {" + NL + "                return this.m_regionLocation;" + NL + "            }" + NL + "" + NL + "            public String[] getLocations() {" + NL + "                return new String[] { this.m_regionLocation };" + NL + "            }" + NL + "" + NL + "            public long getLength() {" + NL + "                // Not clear how to obtain this... seems to be used only for sorting splits" + NL + "                return 0;" + NL + "            }" + NL + "" + NL + "            public void readFields(DataInput in) throws IOException {" + NL + "                this.m_tableName = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "                this.m_startRow = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "                this.m_endRow = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "                this.m_regionLocation = org.apache.hadoop.hbase.util.Bytes.toString(org.apache.hadoop.hbase.util.Bytes.readByteArray(in));" + NL + "            }" + NL + "" + NL + "            public void write(DataOutput out) throws IOException {" + NL + "                org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_tableName);" + NL + "                org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_startRow);" + NL + "                org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_endRow);" + NL + "                org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, org.apache.hadoop.hbase.util.Bytes.toBytes(this.m_regionLocation));" + NL + "            }" + NL + "" + NL + "            public String toString() {" + NL + "                return m_regionLocation + \":\" + org.apache.hadoop.hbase.util.Bytes.toStringBinary(m_startRow) + \",\" + org.apache.hadoop.hbase.util.Bytes.toStringBinary(m_endRow);" + NL + "            }" + NL + "" + NL + "            public int compareTo(HBaseTableSplit o) {" + NL + "                return org.apache.hadoop.hbase.util.Bytes.compareTo(getStartRow(), o.getStartRow());" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "    ";
  protected final String TEXT_108 = NL + NL + "public static class RejectMap_";
  protected final String TEXT_109 = " implements org.apache.spark.api.java.function.PairFlatMapFunction<scala.Tuple2<NullWritable, ";
  protected final String TEXT_110 = "TemporaryStruct>, NullWritable, ";
  protected final String TEXT_111 = "> {" + NL + "" + NL + "        private ContextProperties context = null;" + NL + "" + NL + "        public RejectMap_";
  protected final String TEXT_112 = "(JobConf job) {" + NL + "            this.context = new ContextProperties(job);" + NL + "        }" + NL + "" + NL + "        public java.lang.Iterable<scala.Tuple2<NullWritable, ";
  protected final String TEXT_113 = ">> call(scala.Tuple2<NullWritable, ";
  protected final String TEXT_114 = "TemporaryStruct> data) throws java.lang.Exception {" + NL + "" + NL + "            java.util.List<scala.Tuple2<NullWritable, ";
  protected final String TEXT_115 = ">> outputs = new java.util.ArrayList<scala.Tuple2<NullWritable, ";
  protected final String TEXT_116 = ">>();";
  protected final String TEXT_117 = NL + "            ";
  protected final String TEXT_118 = "TemporaryStruct value = data._2();" + NL + "            org.apache.hadoop.hbase.client.Result result = (org.apache.hadoop.hbase.client.Result) value.get();" + NL + "            byte[] rowResult = null;" + NL + "            String temp = null;";
  protected final String TEXT_119 = NL + "            ";
  protected final String TEXT_120 = " rejectRow = new ";
  protected final String TEXT_121 = "();" + NL + "" + NL + "            try {";
  protected final String TEXT_122 = NL + "                    rowResult = result.getValue(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_123 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(\"";
  protected final String TEXT_124 = "\"));" + NL + "                    temp = org.apache.hadoop.hbase.util.Bytes.toString(rowResult);" + NL + "                    if(temp!=null && temp.length() > 0) {";
  protected final String TEXT_125 = NL + "                            rejectRow.";
  protected final String TEXT_126 = " = temp.toString();";
  protected final String TEXT_127 = " " + NL + "                            rejectRow.";
  protected final String TEXT_128 = "=rowResult;";
  protected final String TEXT_129 = " " + NL + "                            rejectRow.";
  protected final String TEXT_130 = "=BigDataParserUtils.parseTo_Date(temp, ";
  protected final String TEXT_131 = ");";
  protected final String TEXT_132 = " " + NL + "                            rejectRow.";
  protected final String TEXT_133 = "=org.apache.hadoop.hbase.util.Bytes.toInt(rowResult);";
  protected final String TEXT_134 = " " + NL + "                            rejectRow.";
  protected final String TEXT_135 = "=(char)org.apache.hadoop.hbase.util.Bytes.toInt(rowResult);";
  protected final String TEXT_136 = NL + "                            rejectRow.";
  protected final String TEXT_137 = "=org.apache.hadoop.hbase.util.Bytes.to";
  protected final String TEXT_138 = "(rowResult);";
  protected final String TEXT_139 = NL + "                            rejectRow.";
  protected final String TEXT_140 = "=BigDataParserUtils.parseTo_";
  protected final String TEXT_141 = "(temp);";
  protected final String TEXT_142 = NL + "                    }else{";
  protected final String TEXT_143 = NL + "                            rejectRow.";
  protected final String TEXT_144 = " = ";
  protected final String TEXT_145 = ";";
  protected final String TEXT_146 = NL + "                            rejectRow.";
  protected final String TEXT_147 = " = null;";
  protected final String TEXT_148 = NL + "                            throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_149 = "' in '";
  protected final String TEXT_150 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_151 = NL + "                    }";
  protected final String TEXT_152 = NL + "                    return outputs;" + NL + "            } catch  (Exception ex_";
  protected final String TEXT_153 = ") {" + NL + "                rejectRow.invalidInputLine = value.toString();" + NL + "                rejectRow.errorCode = ex_";
  protected final String TEXT_154 = ".toString();" + NL + "                outputs.add(new scala.Tuple2<NullWritable, ";
  protected final String TEXT_155 = ">(NullWritable.get(), rejectRow));" + NL + "                return outputs;" + NL + "            }" + NL + "        }" + NL + "}";
  protected final String TEXT_156 = NL + "\t\tpublic static class ";
  protected final String TEXT_157 = "InputFormat_";
  protected final String TEXT_158 = " implements InputFormat<NullWritable, ";
  protected final String TEXT_159 = ">, JobConfigurable {" + NL + "\t\t\tprivate org.apache.hadoop.hbase.client.HTable hTable;" + NL + "" + NL + "\t\t\tprivate byte[][] inputColumns;" + NL + "\t\t\t" + NL + "\t\t\tContextProperties context;" + NL + "\t\t\t" + NL + "\t\t\tpublic void configure(JobConf job) {" + NL + "\t\t\t\tcontext = new ContextProperties(job);" + NL + "\t\t\t\tJobConf hbaseJob = new JobConf(job);" + NL + "\t\t\t\thbaseJob.set(\"hbase.zookeeper.quorum\", ";
  protected final String TEXT_160 = ");" + NL + "\t\t\t\thbaseJob.set(\"hbase.zookeeper.property.clientPort\", ";
  protected final String TEXT_161 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_162 = NL + "\t\t\t\thbaseJob.set(\"zookeeper.znode.parent\",";
  protected final String TEXT_163 = "); " + NL + "\t\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t\thbaseJob.set(\"hbase.table.namespace.mappings\", ";
  protected final String TEXT_165 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_166 = NL + "\t\t\t\t\thbaseJob.set(";
  protected final String TEXT_167 = ",";
  protected final String TEXT_168 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t        try {" + NL + "\t\t            this.hTable = new org.apache.hadoop.hbase.client.HTable(hbaseJob, ";
  protected final String TEXT_170 = ");" + NL + "\t\t        } catch (Exception ex) {" + NL + "\t\t            throw new RuntimeException(ex);" + NL + "\t\t        }" + NL + "\t\t        ";
  protected final String TEXT_171 = NL + "\t\t        this.inputColumns = new byte[";
  protected final String TEXT_172 = "][];" + NL + "\t\t        ";
  protected final String TEXT_173 = NL + "\t\t\t\t\tthis.inputColumns[";
  protected final String TEXT_174 = "] = org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_175 = "+org.apache.hadoop.hbase.KeyValue.COLUMN_FAMILY_DELIMITER+\"";
  protected final String TEXT_176 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_177 = NL + "\t\t    }" + NL + "\t\t    " + NL + "\t\t\tpublic RecordReader getRecordReader(InputSplit inputsplit, JobConf job, Reporter reporter) throws IOException {" + NL + "\t\t\t   return new HBaseTableRecordReader((HBaseTableSplit) inputsplit, job, this.hTable, this.inputColumns);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tprotected static class HBaseTableRecordReader implements RecordReader<NullWritable, ";
  protected final String TEXT_178 = "> {" + NL + "" + NL + "\t            private JobConf job;" + NL + "\t" + NL + "\t            private HBaseTableSplit split;" + NL + "\t" + NL + "\t            private org.apache.hadoop.hbase.client.ResultScanner scanner;" + NL + "\t" + NL + "\t            private byte[] startRow;" + NL + "\t" + NL + "\t            private byte[] endRow;" + NL + "\t" + NL + "\t            private byte[] lastSuccessfulRow;" + NL + "\t            " + NL + "\t            private org.apache.hadoop.hbase.client.HTable hTable;" + NL + "" + NL + "\t\t\t\tprivate byte[][] inputColumns;" + NL + "\t\t\t\t" + NL + "\t\t\t\tprivate org.apache.hadoop.hbase.filter.FilterList filterList;" + NL + "\t\t\t\t" + NL + "\t\t\t\tContextProperties context;" + NL + "\t" + NL + "\t            protected HBaseTableRecordReader(HBaseTableSplit split, JobConf job, org.apache.hadoop.hbase.client.HTable hTable, byte[][] inputColumns) throws IOException {" + NL + "\t            \tcontext = new ContextProperties(job);" + NL + "\t\t\t\t\tthis.hTable = hTable;" + NL + "\t\t\t\t\tthis.inputColumns = inputColumns;" + NL + "\t                this.split = split;" + NL + "\t                this.job = job;" + NL + "\t                this.startRow = split.getStartRow();" + NL + "\t                this.endRow = split.getEndRow();" + NL + "\t                initFilter();" + NL + "\t                restart(startRow);" + NL + "\t            }" + NL + "\t            " + NL + "\t            private void initFilter(){" + NL + "\t            \t";
  protected final String TEXT_179 = NL + "\t\t\t\t\t\t\tString [] multipleValues = null;" + NL + "\t\t\t\t\t\t\tbyte [][] multipleBytesValues = null;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_180 = "\t" + NL + "\t\t\t\t\t\tthis.filterList = new org.apache.hadoop.hbase.filter.FilterList(org.apache.hadoop.hbase.filter.FilterList.Operator.";
  protected final String TEXT_181 = ");" + NL + "\t\t\t\t\t\torg.apache.hadoop.hbase.filter.Filter filter = null;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_183 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_184 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_185 = ", org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_186 = "));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_187 = NL + "\t\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_188 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_189 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_190 = ", new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_191 = "));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_192 = NL + "\t\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_193 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_194 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_195 = ", new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_196 = "));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_197 = NL + "\t\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_198 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_199 = ")));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_200 = NL + "\t\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_201 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_202 = "));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_203 = NL + "\t\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_204 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_205 = "));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_206 = NL + "\t\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_207 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_208 = ")));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_209 = NL + "\t\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_210 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_211 = "));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_212 = NL + "\t\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_213 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_214 = "));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_215 = NL + "\t\t\t\t\t\t\t\t\tscan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_216 = "));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_217 = NL + "\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.ColumnPrefixFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_218 = "));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_219 = NL + "\t\t\t\t\t\t\t\t\tscan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_220 = "));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_221 = NL + "\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_222 = "!=null && !\"\".equals(";
  protected final String TEXT_223 = ")){" + NL + "\t\t\t\t\t\t\t\t\tmultipleValues = ";
  protected final String TEXT_224 = ".split(\",\");" + NL + "\t\t\t\t\t\t\t\t\tmultipleBytesValues = new byte [multipleValues.length] [];" + NL + "\t\t\t\t\t\t\t\t\tfor(int i=0;i< multipleValues.length;i++){" + NL + "\t\t\t\t\t\t\t\t\t\tmultipleBytesValues[i] = org.apache.hadoop.hbase.util.Bytes.toBytes(multipleValues[i]);" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\tfilter =  new org.apache.hadoop.hbase.filter.MultipleColumnPrefixFilter(multipleBytesValues);" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_225 = NL + "\t\t\t\t\t\t\t\t\tscan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_226 = "));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_227 = NL + "\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.ColumnRangeFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_228 = ".split(\",\")[0]),true,org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_229 = ".split(\",\")[1]),true);" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_230 = NL + "\t\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_231 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_232 = ")));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_233 = NL + "\t\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_234 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_235 = "));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_236 = NL + "\t\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_237 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_238 = "));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_239 = NL + "\t\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_240 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_241 = ")));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_242 = NL + "\t\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_243 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_244 = "));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_245 = NL + "\t\t\t\t\t\t\t\t\tfilter = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_246 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_247 = "));" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_248 = NL + "\t\t\t\t\t\t\tthis.filterList.addFilter(filter);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_249 = "\t\t\t\t\t" + NL + "\t            }" + NL + "\t            " + NL + "\t            private void setFilter(org.apache.hadoop.hbase.client.Scan scan){" + NL + "\t            \tif(this.filterList != null){" + NL + "\t            \t\tscan.setFilter(this.filterList);" + NL + "\t\t\t\t\t\tscan.setCacheBlocks(false);" + NL + "\t            \t}" + NL + "\t            }" + NL + "\t" + NL + "\t            public void restart(byte[] firstRow) throws IOException {" + NL + "\t                org.apache.hadoop.hbase.client.Scan scan;" + NL + "\t                if ((endRow != null) && (endRow.length > 0)) {" + NL + "\t                    scan = new org.apache.hadoop.hbase.client.Scan(firstRow, endRow);" + NL + "\t                } else {" + NL + "\t                    scan = new org.apache.hadoop.hbase.client.Scan(firstRow);" + NL + "\t                }" + NL + "\t                for (byte[] column : inputColumns) {" + NL + "\t                    byte[][] fq = org.apache.hadoop.hbase.KeyValue.parseColumn(column);" + NL + "\t                    if (fq.length > 1 && fq[1] != null && fq[1].length > 0) {" + NL + "\t                        scan.addColumn(fq[0], fq[1]);" + NL + "\t                    } else {" + NL + "\t                        scan.addFamily(fq[0]);" + NL + "\t                    }" + NL + "\t                }" + NL + "\t\t\t\t\tsetFilter(scan);\t\t\t\t\t                " + NL + "\t                this.scanner = hTable.getScanner(scan);" + NL + "\t            }" + NL + "\t" + NL + "\t            public void close() throws IOException {" + NL + "\t                this.scanner.close();" + NL + "\t            }" + NL + "\t" + NL + "\t            public NullWritable createKey() {" + NL + "\t                return NullWritable.get();" + NL + "\t            }" + NL + "\t" + NL + "\t            public ";
  protected final String TEXT_250 = " createValue() {" + NL + "\t                return new ";
  protected final String TEXT_251 = "();" + NL + "\t            }" + NL + "\t" + NL + "\t            public long getPos() throws IOException {" + NL + "\t                // This should be the ordinal tuple in the range;" + NL + "\t                // not clear how to calculate..." + NL + "\t                return 0;" + NL + "\t            }" + NL + "\t" + NL + "\t            public float getProgress() throws IOException {" + NL + "\t                // Depends on the total number of tuples and getPos" + NL + "\t                return 0;" + NL + "\t            }" + NL + "\t" + NL + "\t            public boolean next(NullWritable key, ";
  protected final String TEXT_252 = " value) throws IOException {" + NL + "\t                org.apache.hadoop.hbase.client.Result result;" + NL + "\t                try {" + NL + "\t                    try {" + NL + "\t                        result = this.scanner.next();" + NL + "\t                    } catch (IOException e) {" + NL + "\t                        ";
  protected final String TEXT_253 = NL + "\t                            throw new IOException(e.getMessage());" + NL + "\t                            ";
  protected final String TEXT_254 = NL + "\t                            if (lastSuccessfulRow == null) {" + NL + "\t                                restart(startRow);" + NL + "\t                            } else {" + NL + "\t                                restart(lastSuccessfulRow);" + NL + "\t                                this.scanner.next();" + NL + "\t                            }" + NL + "\t                            result = this.scanner.next();" + NL + "\t                            ";
  protected final String TEXT_255 = NL + "\t                    }" + NL + "\t" + NL + "\t                    if (result != null && result.size() > 0) {" + NL + "\t                        org.apache.hadoop.hbase.io.ImmutableBytesWritable rowKey = new org.apache.hadoop.hbase.io.ImmutableBytesWritable();" + NL + "\t                        rowKey.set(result.getRow());" + NL + "\t                        lastSuccessfulRow = rowKey.get();" + NL + "\t" + NL + "\t\t\t\t\t\t\tbyte[] rowResult = null;" + NL + "\t\t\t\t\t\t\tString temp = null;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_256 = NL + "\t\t\t\t\t\t\t\trowResult = result.getValue(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_257 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(\"";
  protected final String TEXT_258 = "\"));" + NL + "\t\t\t\t\t\t\t\ttemp = org.apache.hadoop.hbase.util.Bytes.toString(rowResult);" + NL + "\t\t\t\t\t\t\t\tif(temp!=null && temp.length() > 0) {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_259 = NL + "\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_260 = " = temp.toString();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_261 = " " + NL + "\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_262 = "=rowResult;" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_263 = " " + NL + "\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_264 = "=BigDataParserUtils.parseTo_Date(temp, ";
  protected final String TEXT_265 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_266 = " " + NL + "\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_267 = "=org.apache.hadoop.hbase.util.Bytes.toInt(rowResult);" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_268 = " " + NL + "\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_269 = "=(char)org.apache.hadoop.hbase.util.Bytes.toInt(rowResult);  " + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_270 = NL + "\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_271 = "=org.apache.hadoop.hbase.util.Bytes.to";
  protected final String TEXT_272 = "(rowResult);  " + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_273 = NL + "\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_274 = "=BigDataParserUtils.parseTo_";
  protected final String TEXT_275 = "(temp);" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_276 = NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_277 = NL + "\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_278 = " = ";
  protected final String TEXT_279 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_280 = NL + "\t\t\t\t\t\t\t\t\t\tvalue.";
  protected final String TEXT_281 = " = null;" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_282 = NL + "\t\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_283 = "' in '";
  protected final String TEXT_284 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_285 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_286 = NL + "\t                        return true;" + NL + "\t                    }" + NL + "\t                    return false;" + NL + "\t                } catch (IOException ioe) {" + NL + "\t                    ";
  protected final String TEXT_287 = NL + "                            throw ioe;";
  protected final String TEXT_288 = NL + "                            System.err.println(ioe.getMessage());" + NL + "                            return next(key, value);";
  protected final String TEXT_289 = NL + "\t                }" + NL + "\t            }" + NL + "\t        }" + NL + "\t        " + NL + "\t        public InputSplit[] getSplits(JobConf job, int numSplits) throws IOException {" + NL + "\t            if (this.hTable == null) {" + NL + "\t                throw new IOException(\"No table was provided\");" + NL + "\t            }" + NL + "\t            byte[][] startKeys = this.hTable.getStartKeys();" + NL + "\t            if (startKeys == null || startKeys.length == 0) {" + NL + "\t                throw new IOException(\"Expecting at least one region\");" + NL + "\t            }" + NL + "\t            if (this.inputColumns == null || this.inputColumns.length == 0) {" + NL + "\t                throw new IOException(\"Expecting at least one column\");" + NL + "\t            }" + NL + "\t            int realNumSplits = numSplits > startKeys.length ? startKeys.length : numSplits;" + NL + "\t            InputSplit[] splits = new InputSplit[realNumSplits];" + NL + "\t            int middle = startKeys.length / realNumSplits;" + NL + "\t            int startPos = 0;" + NL + "\t            for (int i = 0; i < realNumSplits; i++) {" + NL + "\t                int lastPos = startPos + middle;" + NL + "\t                lastPos = startKeys.length % realNumSplits > i ? lastPos + 1 : lastPos;" + NL + "\t                String regionLocation = hTable.getRegionLocation(startKeys[startPos]).getHostname();" + NL + "\t                splits[i] = new HBaseTableSplit(this.hTable.getTableName(), startKeys[startPos]," + NL + "\t                        ((i + 1) < realNumSplits) ? startKeys[lastPos] : org.apache.hadoop.hbase.HConstants.EMPTY_START_ROW, regionLocation);" + NL + "\t                startPos = lastPos;" + NL + "\t            }" + NL + "\t            return splits;" + NL + "\t        }" + NL + "" + NL + "\t        protected static class HBaseTableSplit implements InputSplit, Comparable<HBaseTableSplit> {" + NL + "" + NL + "\t            private byte[] m_tableName;" + NL + "" + NL + "\t            private byte[] m_startRow;" + NL + "" + NL + "\t            private byte[] m_endRow;" + NL + "" + NL + "\t            private String m_regionLocation;" + NL + "" + NL + "\t            public HBaseTableSplit() {" + NL + "\t                this(org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, \"\");" + NL + "\t            }" + NL + "\t" + NL + "\t            public HBaseTableSplit(byte[] tableName, byte[] startRow, byte[] endRow, final String location) {" + NL + "\t                this.m_tableName = tableName;" + NL + "\t                this.m_startRow = startRow;" + NL + "\t                this.m_endRow = endRow;" + NL + "\t                this.m_regionLocation = location;" + NL + "\t            }" + NL + "\t" + NL + "\t            public byte[] getTableName() {" + NL + "\t                return this.m_tableName;" + NL + "\t            }" + NL + "\t" + NL + "\t            public byte[] getStartRow() {" + NL + "\t                return this.m_startRow;" + NL + "\t            }" + NL + "\t" + NL + "\t            public byte[] getEndRow() {" + NL + "\t                return this.m_endRow;" + NL + "\t            }" + NL + "\t" + NL + "\t            public String getRegionLocation() {" + NL + "\t                return this.m_regionLocation;" + NL + "\t            }" + NL + "\t" + NL + "\t            public String[] getLocations() {" + NL + "\t                return new String[] { this.m_regionLocation };" + NL + "\t            }" + NL + "\t" + NL + "\t            public long getLength() {" + NL + "\t                // Not clear how to obtain this... seems to be used only for sorting splits" + NL + "\t                return 0;" + NL + "\t            }" + NL + "\t" + NL + "\t            public void readFields(DataInput in) throws IOException {" + NL + "\t                this.m_tableName = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "\t                this.m_startRow = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "\t                this.m_endRow = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "\t                this.m_regionLocation = org.apache.hadoop.hbase.util.Bytes.toString(org.apache.hadoop.hbase.util.Bytes.readByteArray(in));" + NL + "\t            }" + NL + "\t" + NL + "\t            public void write(DataOutput out) throws IOException {" + NL + "\t                org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_tableName);" + NL + "\t                org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_startRow);" + NL + "\t                org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_endRow);" + NL + "\t                org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, org.apache.hadoop.hbase.util.Bytes.toBytes(this.m_regionLocation));" + NL + "\t            }" + NL + "\t" + NL + "\t            public String toString() {" + NL + "\t                return m_regionLocation + \":\" + org.apache.hadoop.hbase.util.Bytes.toStringBinary(m_startRow) + \",\" + org.apache.hadoop.hbase.util.Bytes.toStringBinary(m_endRow);" + NL + "\t            }" + NL + "\t" + NL + "\t            public int compareTo(HBaseTableSplit o) {" + NL + "\t                return org.apache.hadoop.hbase.util.Bytes.compareTo(getStartRow(), o.getStartRow());" + NL + "\t            }" + NL + "\t        }" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_290 = NL + NL + "public static class IdentityMap_";
  protected final String TEXT_291 = " implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<NullWritable, ";
  protected final String TEXT_292 = ">, NullWritable, ";
  protected final String TEXT_293 = "> {" + NL + "" + NL + "        private ContextProperties context = null;" + NL + "        private java.util.List<org.apache.avro.Schema.Field> fieldsList;" + NL + "" + NL + "        public IdentityMap_";
  protected final String TEXT_294 = "(JobConf job) {" + NL + "            this.context = new ContextProperties(job);" + NL + "        }" + NL + "" + NL + "        public scala.Tuple2<NullWritable, ";
  protected final String TEXT_295 = "> call(scala.Tuple2<NullWritable, ";
  protected final String TEXT_296 = "> data) throws java.lang.Exception {" + NL + "" + NL + "            if(fieldsList == null){" + NL + "                this.fieldsList = (new ";
  protected final String TEXT_297 = "()).getSchema().getFields();" + NL + "            }" + NL;
  protected final String TEXT_298 = NL + "            ";
  protected final String TEXT_299 = " value = new ";
  protected final String TEXT_300 = "();" + NL + "" + NL + "            for(org.apache.avro.Schema.Field field : fieldsList){" + NL + "                value.put(field.pos(), data._2().get(field.pos()));" + NL + "            }" + NL + "" + NL + "\t\t\treturn new scala.Tuple2<NullWritable, ";
  protected final String TEXT_301 = ">(NullWritable.get(), value);" + NL + "        }" + NL + "" + NL + "}";
  protected final String TEXT_302 = NL + "    " + NL + "    public static class ";
  protected final String TEXT_303 = "TemporaryStruct extends org.apache.hadoop.io.ObjectWritable {" + NL + "    }" + NL + "    " + NL + "    public static class ";
  protected final String TEXT_304 = "StructInputFormat implements InputFormat<NullWritable, ";
  protected final String TEXT_305 = "TemporaryStruct>, JobConfigurable {" + NL + "        private org.apache.hadoop.hbase.client.HTable hTable;" + NL + "" + NL + "        private byte[][] inputColumns;" + NL + "        " + NL + "        ContextProperties context;" + NL + "        " + NL + "        public void configure(JobConf job_";
  protected final String TEXT_306 = ") {" + NL + "            context = new ContextProperties(job_";
  protected final String TEXT_307 = ");" + NL + "            JobConf hbaseJob = new JobConf(job_";
  protected final String TEXT_308 = ");" + NL + "            hbaseJob.set(\"hbase.zookeeper.quorum\", ";
  protected final String TEXT_309 = ");" + NL + "            hbaseJob.set(\"hbase.zookeeper.property.clientPort\", ";
  protected final String TEXT_310 = ");" + NL + "            ";
  protected final String TEXT_311 = NL + "            hbaseJob.set(\"zookeeper.znode.parent\",";
  protected final String TEXT_312 = "); ";
  protected final String TEXT_313 = NL + "            hbaseJob.set(\"hbase.table.namespace.mappings\", ";
  protected final String TEXT_314 = ");";
  protected final String TEXT_315 = NL + "                hbaseJob.set(";
  protected final String TEXT_316 = ",";
  protected final String TEXT_317 = ");";
  protected final String TEXT_318 = NL + "            try {" + NL + "                this.hTable = new org.apache.hadoop.hbase.client.HTable(hbaseJob, ";
  protected final String TEXT_319 = ");" + NL + "            } catch (Exception ex) {" + NL + "                throw new RuntimeException(ex);" + NL + "            }";
  protected final String TEXT_320 = NL + "            this.inputColumns = new byte[";
  protected final String TEXT_321 = "][];";
  protected final String TEXT_322 = NL + "                this.inputColumns[";
  protected final String TEXT_323 = "] = org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_324 = "+org.apache.hadoop.hbase.KeyValue.COLUMN_FAMILY_DELIMITER+\"";
  protected final String TEXT_325 = "\");";
  protected final String TEXT_326 = NL + "                    try {" + NL + "                        FileSystem fs = FileSystem.get(job_";
  protected final String TEXT_327 = ");" + NL + "                        Path path = new Path(" + NL + "                                \"/tmp/";
  protected final String TEXT_328 = "\"" + NL + "                                + \"/tMROutput_";
  protected final String TEXT_329 = "\"" + NL + "                                + \"/";
  protected final String TEXT_330 = "\");" + NL + "                        fs.mkdirs(path);" + NL + "                    } catch (IOException ex_";
  protected final String TEXT_331 = ") {" + NL + "                        throw new RuntimeException(ex_";
  protected final String TEXT_332 = ".getMessage());" + NL + "                    }";
  protected final String TEXT_333 = NL + "        }" + NL + "        " + NL + "        public RecordReader getRecordReader(InputSplit inputsplit, JobConf job, Reporter reporter) throws IOException {" + NL + "           return new HBaseTableRecordReader((HBaseTableSplit) inputsplit, job, this.hTable, this.inputColumns);" + NL + "        }" + NL + "        " + NL + "        protected static class HBaseTableRecordReader implements RecordReader<NullWritable, ";
  protected final String TEXT_334 = "TemporaryStruct> {" + NL + "" + NL + "            private JobConf job;" + NL + "" + NL + "            private HBaseTableSplit split;" + NL + "" + NL + "            private org.apache.hadoop.hbase.client.ResultScanner scanner;" + NL + "" + NL + "            private byte[] startRow;" + NL + "" + NL + "            private byte[] endRow;" + NL + "" + NL + "            private byte[] lastSuccessfulRow;" + NL + "            " + NL + "            private org.apache.hadoop.hbase.client.HTable hTable;" + NL + "" + NL + "            private byte[][] inputColumns;" + NL + "            " + NL + "            private org.apache.hadoop.hbase.filter.FilterList filterList;" + NL + "            " + NL + "            ContextProperties context;" + NL + "" + NL + "            protected HBaseTableRecordReader(HBaseTableSplit split, JobConf job, org.apache.hadoop.hbase.client.HTable hTable, byte[][] inputColumns) throws IOException {" + NL + "                context = new ContextProperties(job);" + NL + "                this.hTable = hTable;" + NL + "                this.inputColumns = inputColumns;" + NL + "                this.split = split;" + NL + "                this.job = job;" + NL + "                this.startRow = split.getStartRow();" + NL + "                this.endRow = split.getEndRow();" + NL + "                initFilter();" + NL + "                restart(startRow);" + NL + "            }" + NL + "            " + NL + "            private void initFilter(){";
  protected final String TEXT_335 = NL + "                        String [] multipleValues = null;" + NL + "                        byte [][] multipleBytesValues = null;";
  protected final String TEXT_336 = "  " + NL + "                    this.filterList = new org.apache.hadoop.hbase.filter.FilterList(org.apache.hadoop.hbase.filter.FilterList.Operator.";
  protected final String TEXT_337 = ");" + NL + "                    org.apache.hadoop.hbase.filter.Filter filter = null;";
  protected final String TEXT_338 = NL + "                                filter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_339 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_340 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_341 = ", org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_342 = "));";
  protected final String TEXT_343 = NL + "                                filter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_344 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_345 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_346 = ", new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_347 = "));";
  protected final String TEXT_348 = NL + "                                filter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_349 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_350 = "), org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_351 = ", new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_352 = "));";
  protected final String TEXT_353 = NL + "                                filter = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_354 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_355 = ")));";
  protected final String TEXT_356 = NL + "                                filter = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_357 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_358 = "));";
  protected final String TEXT_359 = NL + "                                filter = new org.apache.hadoop.hbase.filter.FamilyFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_360 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_361 = "));";
  protected final String TEXT_362 = NL + "                                filter = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_363 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_364 = ")));";
  protected final String TEXT_365 = NL + "                                filter = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_366 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_367 = "));";
  protected final String TEXT_368 = NL + "                                filter = new org.apache.hadoop.hbase.filter.QualifierFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_369 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_370 = "));";
  protected final String TEXT_371 = NL + "                                scan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_372 = "));";
  protected final String TEXT_373 = NL + "                            filter = new org.apache.hadoop.hbase.filter.ColumnPrefixFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_374 = "));";
  protected final String TEXT_375 = NL + "                                scan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_376 = "));";
  protected final String TEXT_377 = NL + "                            if(";
  protected final String TEXT_378 = "!=null && !\"\".equals(";
  protected final String TEXT_379 = ")){" + NL + "                                multipleValues = ";
  protected final String TEXT_380 = ".split(\",\");" + NL + "                                multipleBytesValues = new byte [multipleValues.length] [];" + NL + "                                for(int i=0;i< multipleValues.length;i++){" + NL + "                                    multipleBytesValues[i] = org.apache.hadoop.hbase.util.Bytes.toBytes(multipleValues[i]);" + NL + "                                }" + NL + "                                filter =  new org.apache.hadoop.hbase.filter.MultipleColumnPrefixFilter(multipleBytesValues);" + NL + "                            }";
  protected final String TEXT_381 = NL + "                                scan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_382 = "));";
  protected final String TEXT_383 = NL + "                            filter = new org.apache.hadoop.hbase.filter.ColumnRangeFilter(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_384 = ".split(\",\")[0]),true,org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_385 = ".split(\",\")[1]),true);";
  protected final String TEXT_386 = NL + "                                filter = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_387 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_388 = ")));";
  protected final String TEXT_389 = NL + "                                filter = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_390 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_391 = "));";
  protected final String TEXT_392 = NL + "                                filter = new org.apache.hadoop.hbase.filter.RowFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_393 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_394 = "));";
  protected final String TEXT_395 = NL + "                                filter = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_396 = ",new org.apache.hadoop.hbase.filter.BinaryComparator(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_397 = ")));";
  protected final String TEXT_398 = NL + "                                filter = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_399 = ",new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_400 = "));";
  protected final String TEXT_401 = NL + "                                filter = new org.apache.hadoop.hbase.filter.ValueFilter(org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_402 = ",new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_403 = "));";
  protected final String TEXT_404 = NL + "                        this.filterList.addFilter(filter);";
  protected final String TEXT_405 = "                  " + NL + "            }" + NL + "            " + NL + "            private void setFilter(org.apache.hadoop.hbase.client.Scan scan){" + NL + "                if(this.filterList != null){" + NL + "                    scan.setFilter(this.filterList);" + NL + "                    scan.setCacheBlocks(false);" + NL + "                }" + NL + "            }" + NL + "" + NL + "            public void restart(byte[] firstRow) throws IOException {" + NL + "                org.apache.hadoop.hbase.client.Scan scan;" + NL + "                if ((endRow != null) && (endRow.length > 0)) {" + NL + "                    scan = new org.apache.hadoop.hbase.client.Scan(firstRow, endRow);" + NL + "                } else {" + NL + "                    scan = new org.apache.hadoop.hbase.client.Scan(firstRow);" + NL + "                }" + NL + "                for (byte[] column : inputColumns) {" + NL + "                    byte[][] fq = org.apache.hadoop.hbase.KeyValue.parseColumn(column);" + NL + "                    if (fq.length > 1 && fq[1] != null && fq[1].length > 0) {" + NL + "                        scan.addColumn(fq[0], fq[1]);" + NL + "                    } else {" + NL + "                        scan.addFamily(fq[0]);" + NL + "                    }" + NL + "                }" + NL + "                setFilter(scan);                                    " + NL + "                this.scanner = hTable.getScanner(scan);" + NL + "            }" + NL + "" + NL + "            public void close() throws IOException {" + NL + "                this.scanner.close();" + NL + "            }" + NL + "" + NL + "            public NullWritable createKey() {" + NL + "                return NullWritable.get();" + NL + "            }" + NL + "" + NL + "            public ";
  protected final String TEXT_406 = "TemporaryStruct createValue() {" + NL + "                return new ";
  protected final String TEXT_407 = "TemporaryStruct();" + NL + "            }" + NL + "" + NL + "            public long getPos() throws IOException {" + NL + "                // This should be the ordinal tuple in the range;" + NL + "                // not clear how to calculate..." + NL + "                return 0;" + NL + "            }" + NL + "" + NL + "            public float getProgress() throws IOException {" + NL + "                // Depends on the total number of tuples and getPos" + NL + "                return 0;" + NL + "            }" + NL + "" + NL + "            public boolean next(NullWritable key, ";
  protected final String TEXT_408 = "TemporaryStruct value) throws IOException {" + NL + "                org.apache.hadoop.hbase.client.Result result;" + NL + "                try {" + NL + "                    try {" + NL + "                        result = this.scanner.next();" + NL + "                    } catch (IOException e) {" + NL + "                        if (lastSuccessfulRow == null) {" + NL + "                            restart(startRow);" + NL + "                        } else {" + NL + "                            restart(lastSuccessfulRow);" + NL + "                            this.scanner.next();" + NL + "                        }" + NL + "                        result = this.scanner.next();" + NL + "                    }" + NL + "" + NL + "                    if (result != null && result.size() > 0) {" + NL + "                        value.set(result);" + NL + "                        org.apache.hadoop.hbase.io.ImmutableBytesWritable rowKey = new org.apache.hadoop.hbase.io.ImmutableBytesWritable();" + NL + "                        rowKey.set(result.getRow());" + NL + "                        lastSuccessfulRow = rowKey.get();" + NL + "                        return true;" + NL + "                    }" + NL + "                    return false;" + NL + "                } catch (IOException ioe) {" + NL + "                    throw ioe;" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "        " + NL + "        public InputSplit[] getSplits(JobConf job, int numSplits) throws IOException {" + NL + "            if (this.hTable == null) {" + NL + "                throw new IOException(\"No table was provided\");" + NL + "            }" + NL + "            byte[][] startKeys = this.hTable.getStartKeys();" + NL + "            if (startKeys == null || startKeys.length == 0) {" + NL + "                throw new IOException(\"Expecting at least one region\");" + NL + "            }" + NL + "            if (this.inputColumns == null || this.inputColumns.length == 0) {" + NL + "                throw new IOException(\"Expecting at least one column\");" + NL + "            }" + NL + "            int realNumSplits = numSplits > startKeys.length ? startKeys.length : numSplits;" + NL + "            InputSplit[] splits = new InputSplit[realNumSplits];" + NL + "            int middle = startKeys.length / realNumSplits;" + NL + "            int startPos = 0;" + NL + "            for (int i = 0; i < realNumSplits; i++) {" + NL + "                int lastPos = startPos + middle;" + NL + "                lastPos = startKeys.length % realNumSplits > i ? lastPos + 1 : lastPos;" + NL + "                String regionLocation = hTable.getRegionLocation(startKeys[startPos]).getHostname();" + NL + "                splits[i] = new HBaseTableSplit(this.hTable.getTableName(), startKeys[startPos]," + NL + "                        ((i + 1) < realNumSplits) ? startKeys[lastPos] : org.apache.hadoop.hbase.HConstants.EMPTY_START_ROW, regionLocation);" + NL + "                startPos = lastPos;" + NL + "            }" + NL + "            return splits;" + NL + "        }" + NL + "        " + NL + "        protected static class HBaseTableSplit implements InputSplit, Comparable<HBaseTableSplit> {" + NL + "" + NL + "            private byte[] m_tableName;" + NL + "" + NL + "            private byte[] m_startRow;" + NL + "" + NL + "            private byte[] m_endRow;" + NL + "" + NL + "            private String m_regionLocation;" + NL + "" + NL + "            public HBaseTableSplit() {" + NL + "                this(org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, \"\");" + NL + "            }" + NL + "" + NL + "            public HBaseTableSplit(byte[] tableName, byte[] startRow, byte[] endRow, final String location) {" + NL + "                this.m_tableName = tableName;" + NL + "                this.m_startRow = startRow;" + NL + "                this.m_endRow = endRow;" + NL + "                this.m_regionLocation = location;" + NL + "            }" + NL + "" + NL + "            public byte[] getTableName() {" + NL + "                return this.m_tableName;" + NL + "            }" + NL + "" + NL + "            public byte[] getStartRow() {" + NL + "                return this.m_startRow;" + NL + "            }" + NL + "" + NL + "            public byte[] getEndRow() {" + NL + "                return this.m_endRow;" + NL + "            }" + NL + "" + NL + "            public String getRegionLocation() {" + NL + "                return this.m_regionLocation;" + NL + "            }" + NL + "" + NL + "            public String[] getLocations() {" + NL + "                return new String[] { this.m_regionLocation };" + NL + "            }" + NL + "" + NL + "            public long getLength() {" + NL + "                // Not clear how to obtain this... seems to be used only for sorting splits" + NL + "                return 0;" + NL + "            }" + NL + "" + NL + "            public void readFields(DataInput in) throws IOException {" + NL + "                this.m_tableName = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "                this.m_startRow = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "                this.m_endRow = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "                this.m_regionLocation = org.apache.hadoop.hbase.util.Bytes.toString(org.apache.hadoop.hbase.util.Bytes.readByteArray(in));" + NL + "            }" + NL + "" + NL + "            public void write(DataOutput out) throws IOException {" + NL + "                org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_tableName);" + NL + "                org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_startRow);" + NL + "                org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_endRow);" + NL + "                org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, org.apache.hadoop.hbase.util.Bytes.toBytes(this.m_regionLocation));" + NL + "            }" + NL + "" + NL + "            public String toString() {" + NL + "                return m_regionLocation + \":\" + org.apache.hadoop.hbase.util.Bytes.toStringBinary(m_startRow) + \",\" + org.apache.hadoop.hbase.util.Bytes.toStringBinary(m_endRow);" + NL + "            }" + NL + "" + NL + "            public int compareTo(HBaseTableSplit o) {" + NL + "                return org.apache.hadoop.hbase.util.Bytes.compareTo(getStartRow(), o.getStartRow());" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "    ";
  protected final String TEXT_409 = NL + NL + "public static class CastMap_";
  protected final String TEXT_410 = " implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<NullWritable, ";
  protected final String TEXT_411 = "TemporaryStruct>, Boolean, org.apache.avro.specific.SpecificRecordBase> {" + NL + "" + NL + "        private ContextProperties context = null;" + NL + "" + NL + "        public CastMap_";
  protected final String TEXT_412 = "(JobConf job) {" + NL + "            this.context = new ContextProperties(job);" + NL + "        }" + NL + "" + NL + "        public scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> call(scala.Tuple2<NullWritable, ";
  protected final String TEXT_413 = "TemporaryStruct> data) throws java.lang.Exception {" + NL;
  protected final String TEXT_414 = NL + "            ";
  protected final String TEXT_415 = "TemporaryStruct value = data._2();" + NL + "            org.apache.hadoop.hbase.client.Result result = (org.apache.hadoop.hbase.client.Result) value.get();" + NL + "            byte[] rowResult = null;" + NL + "            String temp = null;";
  protected final String TEXT_416 = NL + "            ";
  protected final String TEXT_417 = " mainRow = new ";
  protected final String TEXT_418 = "();";
  protected final String TEXT_419 = NL + "            ";
  protected final String TEXT_420 = " rejectRow = new ";
  protected final String TEXT_421 = "();" + NL + "" + NL + "            try {";
  protected final String TEXT_422 = NL + "                    rowResult = result.getValue(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_423 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(\"";
  protected final String TEXT_424 = "\"));" + NL + "                    temp = org.apache.hadoop.hbase.util.Bytes.toString(rowResult);" + NL + "                    if(temp!=null && temp.length() > 0) {";
  protected final String TEXT_425 = NL + "                            mainRow.";
  protected final String TEXT_426 = " = temp.toString();" + NL + "                            rejectRow.";
  protected final String TEXT_427 = " = temp.toString();";
  protected final String TEXT_428 = " " + NL + "                            mainRow.";
  protected final String TEXT_429 = "=rowResult;" + NL + "                            rejectRow.";
  protected final String TEXT_430 = "=rowResult;";
  protected final String TEXT_431 = " " + NL + "                            mainRow.";
  protected final String TEXT_432 = "=BigDataParserUtils.parseTo_Date(temp, ";
  protected final String TEXT_433 = ");" + NL + "                            rejectRow.";
  protected final String TEXT_434 = "=BigDataParserUtils.parseTo_Date(temp, ";
  protected final String TEXT_435 = ");";
  protected final String TEXT_436 = " " + NL + "                            mainRow.";
  protected final String TEXT_437 = "=org.apache.hadoop.hbase.util.Bytes.toInt(rowResult);" + NL + "                            rejectRow.";
  protected final String TEXT_438 = "=org.apache.hadoop.hbase.util.Bytes.toInt(rowResult);";
  protected final String TEXT_439 = " " + NL + "                            mainRow.";
  protected final String TEXT_440 = "=(char)org.apache.hadoop.hbase.util.Bytes.toInt(rowResult);" + NL + "                            rejectRow.";
  protected final String TEXT_441 = "=(char)org.apache.hadoop.hbase.util.Bytes.toInt(rowResult);";
  protected final String TEXT_442 = NL + "                            mainRow.";
  protected final String TEXT_443 = "=org.apache.hadoop.hbase.util.Bytes.to";
  protected final String TEXT_444 = "(rowResult);" + NL + "                            rejectRow.";
  protected final String TEXT_445 = "=org.apache.hadoop.hbase.util.Bytes.to";
  protected final String TEXT_446 = "(rowResult);";
  protected final String TEXT_447 = NL + "                            mainRow.";
  protected final String TEXT_448 = "=BigDataParserUtils.parseTo_";
  protected final String TEXT_449 = "(temp);" + NL + "                            rejectRow.";
  protected final String TEXT_450 = "=BigDataParserUtils.parseTo_";
  protected final String TEXT_451 = "(temp);";
  protected final String TEXT_452 = NL + "                    }else{";
  protected final String TEXT_453 = NL + "                            mainRow.";
  protected final String TEXT_454 = " = ";
  protected final String TEXT_455 = ";" + NL + "                            rejectRow.";
  protected final String TEXT_456 = " = ";
  protected final String TEXT_457 = ";";
  protected final String TEXT_458 = NL + "                            mainRow.";
  protected final String TEXT_459 = " = null;" + NL + "                            rejectRow.";
  protected final String TEXT_460 = " = null;";
  protected final String TEXT_461 = NL + "                            throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_462 = "' in '";
  protected final String TEXT_463 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_464 = NL + "                    }";
  protected final String TEXT_465 = NL + "                    return new scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase>(true, mainRow);" + NL + "            } catch  (Exception ex_";
  protected final String TEXT_466 = ") {" + NL + "                rejectRow.invalidInputLine = value.toString();" + NL + "                rejectRow.errorCode = ex_";
  protected final String TEXT_467 = ".toString();" + NL + "                return new scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase>(false, rejectRow);" + NL + "            }" + NL + "        }" + NL + "}";
  protected final String TEXT_468 = NL + "public static class ";
  protected final String TEXT_469 = "FalseFilter implements org.apache.spark.api.java.function.Function<scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase>, Boolean> {" + NL + "" + NL + "        public Boolean call(scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> arg0)" + NL + "                throws Exception {" + NL + "            return !arg0._1;" + NL + "        }" + NL + "    }" + NL + "" + NL + "public static class ";
  protected final String TEXT_470 = "TrueFilter implements org.apache.spark.api.java.function.Function<scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase>, Boolean> {" + NL + "" + NL + "        public Boolean call(scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> arg0)" + NL + "                throws Exception {" + NL + "            return arg0._1;" + NL + "        }" + NL + "    }";
  protected final String TEXT_471 = NL + "public static class ";
  protected final String TEXT_472 = "ToNullWritableMain implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase>, NullWritable, ";
  protected final String TEXT_473 = "> {" + NL + "" + NL + "    private ContextProperties context = null;" + NL + "" + NL + "    public ";
  protected final String TEXT_474 = "ToNullWritableMain(JobConf job) {" + NL + "        this.context = new ContextProperties(job);" + NL + "    }" + NL + "" + NL + "    public scala.Tuple2<NullWritable, ";
  protected final String TEXT_475 = "> call(scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> data) {";
  protected final String TEXT_476 = NL + "        ";
  protected final String TEXT_477 = " mainRow = (";
  protected final String TEXT_478 = ") data._2;" + NL + "        return new scala.Tuple2<NullWritable, ";
  protected final String TEXT_479 = ">(NullWritable.get(), mainRow);" + NL + "    }" + NL + "}" + NL + "" + NL + "public static class ";
  protected final String TEXT_480 = "ToNullWritableReject implements org.apache.spark.api.java.function.PairFunction<scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase>, NullWritable, ";
  protected final String TEXT_481 = "> {" + NL + "" + NL + "    private ContextProperties context = null;" + NL + "" + NL + "    public ";
  protected final String TEXT_482 = "ToNullWritableReject(JobConf job) {" + NL + "        this.context = new ContextProperties(job);" + NL + "    }" + NL + "" + NL + "    public scala.Tuple2<NullWritable, ";
  protected final String TEXT_483 = "> call(scala.Tuple2<Boolean, org.apache.avro.specific.SpecificRecordBase> data) {";
  protected final String TEXT_484 = NL + "        ";
  protected final String TEXT_485 = " rejectRow = (";
  protected final String TEXT_486 = ") data._2;" + NL + "        return new scala.Tuple2<NullWritable, ";
  protected final String TEXT_487 = ">(NullWritable.get(), rejectRow);" + NL + "    }" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
INode configurationNode = null;
String configurationNodeName = ElementParameterParser.getValue(node,"__STORAGE_CONFIGURATION__");

for (INode pNode : node.getProcess().getNodesOfType("tHBaseConfiguration")) {
    if(configurationNodeName!=null && configurationNodeName.equals(pNode.getUniqueName())) {
        configurationNode = pNode;
    }else{
        return "";
    }
}

if ((metadatas!=null) && (metadatas.size() > 0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata != null) {

        String zookeeper_quorum = ElementParameterParser.getValue(configurationNode, "__ZOOKEEPER_QUORUM__");
        String zookeeper_client_port = ElementParameterParser.getValue(configurationNode, "__ZOOKEEPER_CLIENT_PORT__");

        boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(configurationNode, "__SET_ZNODE_PARENT__"));
        String zNodeParent = ElementParameterParser.getValue(configurationNode, "__ZNODE_PARENT__");

        String table_name = ElementParameterParser.getValue(node, "__TABLE__");
        boolean isByFilter = ("true").equals(ElementParameterParser.getValue(node, "__IS_BY_FILTER__"));
        List<Map<String, String>> filterMapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__FILTER__");
        String logical = ElementParameterParser.getValue(node,"__LOGICAL_OP__");
        String distribution = ElementParameterParser.getValue(configurationNode,"__DISTRIBUTION__");
        String version = ElementParameterParser.getValue(configurationNode,"__HBASE_VERSION__");
        boolean before90 = false; // unused
        String folder = ElementParameterParser.getValue(node,"__FILENAME__");
        boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

        List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
        List< ? extends IConnection> rejectedConnections = node.getOutgoingConnections("REJECT");
        List< ? extends IConnection> mainConnections = node.getOutgoingConnections("FLOW");

        // Only reject flow
        if ((mainConnections.size() == 0) && (rejectedConnections.size() == 1)) {
            IConnection rejectedConnection = rejectedConnections.get(0);
            String rejectConnName = rejectedConnection.getName();
            String rejectOutStruct = codeGenArgument.getRecordStructName(rejectedConnection);
            
    
    boolean setTableNsMapping = "true".equals(ElementParameterParser.getValue(node, "__SET_TABLE_NS_MAPPING__"));
    String tableNsMapping = ElementParameterParser.getValue(node, "__TABLE_NS_MAPPING__");
    boolean useTableNsMapping = setTableNsMapping && ((tableNsMapping != null)&&(!tableNsMapping.equals("")));

      
List<IMetadataColumn> columns = metadata.getListColumns();
int nbColumns = columns.size();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(zookeeper_quorum);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(zookeeper_client_port);
    stringBuffer.append(TEXT_9);
    
            if(setZNodeParent) {
            
    stringBuffer.append(TEXT_10);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_11);
    
            }

            if(useTableNsMapping){
            
    stringBuffer.append(TEXT_12);
    stringBuffer.append(tableNsMapping);
    stringBuffer.append(TEXT_13);
    
            }
            
            List<Map<String, String>> properties =
                (List<Map<String,String>>)ElementParameterParser.getObjectValue(configurationNode,"__HBASE_PARAMETERS__");
            for(int i=0;i<properties.size();i++){
                Map<String, String> map = properties.get(i);
                String property = map.get("PROPERTY");
                String value= map.get("VALUE");
                
    stringBuffer.append(TEXT_14);
    stringBuffer.append(property);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_16);
    
            }
            
    stringBuffer.append(TEXT_17);
    stringBuffer.append(table_name);
    stringBuffer.append(TEXT_18);
    
            List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MAPPING__");
            
    stringBuffer.append(TEXT_19);
    stringBuffer.append(mapping.size());
    stringBuffer.append(TEXT_20);
    
            for(int i = 0; i < mapping.size(); i++){
                Map<String, String> map = mapping.get(i);
                IMetadataColumn column = columns.get(i);
                //String schema_column = map.get("SCHEMA_COLUMN");//no use, index is enough
                String family_column= map.get("FAMILY_COLUMN");
                
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_24);
    
            }
            // Force the creation of the output directory
            for (INode virtualNode : node.getProcess().getGraphicalNodes()) {
                if (virtualNode.getUniqueName().equals(cid)) {
                    
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(node.getProcess().getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(virtualNode.getUniqueName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(virtualNode.getOutgoingConnections("REJECT").get(0).getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
                    break;
                }
            }
            
    stringBuffer.append(TEXT_32);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_33);
    
                if(isByFilter && filterMapping.size() > 0){
                    boolean hasMultipleColumnPrefixFilterType = false;
                    for(int i=0;i<filterMapping.size();i++){
                        Map<String, String> filterMap = filterMapping.get(i);
                        String filterType = filterMap.get("FILTER_TYPE");
                        if("MultipleColumnPrefixFilter".equals(filterType)){
                            hasMultipleColumnPrefixFilterType = true;
                            break;
                        } 
                    }
                    if(hasMultipleColumnPrefixFilterType){
                    
    stringBuffer.append(TEXT_34);
    
                    }
                    
    stringBuffer.append(TEXT_35);
    stringBuffer.append(logical);
    stringBuffer.append(TEXT_36);
    
                    for(int j=0;j<filterMapping.size();j++){
                        Map<String, String> filterMap = filterMapping.get(j);
                        String filterType = filterMap.get("FILTER_TYPE");//"SingleColumnValueFilter","FamilyFilter","QualifierFilter","ColumnPrefixFilter","MultipleColumnPrefixFilter","MultipleColumnPrefixFilter","RowFilter"
                        String filterColumn = filterMap.get("FILTER_COLUMN");
                        String filterFamily = filterMap.get("FILTER_FAMILY");
                        String filterOperation = filterMap.get("FILTER_OPERATOR");//"EQUAL","GREATER","GREATER_OR_EQUAL","LESS","LESS_OR_EQUAL","NO_OP","NOT_EQUAL",
                        String filterValue = filterMap.get("FILTER_VALUE");
                        String filterComparatorType = filterMap.get("FILTER_COMPARATOR_TYPE");//"BinaryComparator" ,"RegexStringComparator" ,"SubstringComparator"
                        if("SingleColumnValueFilter".equals(filterType)){//"filterValue" is column value,like: "1" ,"2" ... ，return whole row (all columns) value 
                            if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_37);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_41);
    
                            }else if ("RegexStringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_42);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_46);
    
                            }else if("SubstringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_47);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_51);
    
                            }
                        }else if("FamilyFilter".equals(filterType)){//"Filter Family" is family name ,like: "id_family","name_family"....， return columns which mapping in "Filter Family",filter other columns
                            if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_52);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_54);
    
                            }else if ("RegexStringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_55);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_57);
    
                            }else if("SubstringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_58);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_60);
    
                            }
                        }else if("QualifierFilter".equals(filterType)){ //"Filter Column" is column name,like:"id" or "name" .... then you will get meet codition column value ,filter other columns
                            if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_61);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_63);
    
                            }else if ("RegexStringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_64);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_66);
    
                            }else if("SubstringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_67);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_69);
    
                            }
                        }else if("ColumnPrefixFilter".equals(filterType)){//"Filter Column" value is column name,like:"id" or "name" ....,return column value,filter other columns
                            if(filterFamily!=null && !"".equals(filterFamily)){ 
                            
    stringBuffer.append(TEXT_70);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_71);
    
                            }
                            
    stringBuffer.append(TEXT_72);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_73);
    
                        }else if("MultipleColumnPrefixFilter".equals(filterType)){ //"Filter Column" value is for column name ,like:"id,name" ,"id,name,sex".... , return column value,filter other columns
                            if(filterFamily!=null && !"".equals(filterFamily)){ 
                            
    stringBuffer.append(TEXT_74);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_75);
    
                            }
                            
    stringBuffer.append(TEXT_76);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_79);
    
                        }else if("ColumnRangeFilter".equals(filterType)){//"Filter Column" value is tow columns name,like: "id,name" ,"id,sex" ....,return columns value ,filter other columns
                            if(filterFamily!=null && !"".equals(filterFamily)){ 
                            
    stringBuffer.append(TEXT_80);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_81);
    
                            }
                            
    stringBuffer.append(TEXT_82);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_84);
    
                        }else if("RowFilter".equals(filterType)){//"Filter Value" is rowkey value,like "1" ,"car"....,return whole row (all columns)
                            if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_85);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_87);
    
                            }else if ("RegexStringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_88);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_90);
    
                            }else if("SubstringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_91);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_93);
    
                            }
                        }else if("ValueFilter".equals(filterType)){//"Filter Value" is any columns value,like "1" ,"car" .... ,return only the meet codition value,filter other columns
                            if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_94);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_96);
    
                            }else if ("RegexStringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_97);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_99);
    
                            }else if("SubstringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_100);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_102);
    
                            }
                        }
                        
    stringBuffer.append(TEXT_103);
    
                    }
                }
                
    stringBuffer.append(TEXT_104);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_107);
    

    
    // Map to try to cast Hbase results and return only the rejected ones

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_121);
    
                for(int i = 0; i < mapping.size(); i++){
                    Map<String, String> map = mapping.get(i);
                    String family_column= map.get("FAMILY_COLUMN");
                    IMetadataColumn column = columns.get(i);
                    String columnName = column.getLabel();
                    String defaultValue = column.getDefault();
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                    boolean isPrimitiveType = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
                    
    stringBuffer.append(TEXT_122);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_124);
    
                        if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
                        
    stringBuffer.append(TEXT_125);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_126);
    
                        }else if(javaType == JavaTypesManager.BYTE_ARRAY){
                        
    stringBuffer.append(TEXT_127);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_128);
    
                        }else if(javaType == JavaTypesManager.DATE){
                        
    stringBuffer.append(TEXT_129);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_131);
    
                        }else if(isPrimitiveType && javaType == JavaTypesManager.INTEGER){
                        
    stringBuffer.append(TEXT_132);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_133);
    
                        }else if(isPrimitiveType && javaType == JavaTypesManager.CHARACTER){
                        
    stringBuffer.append(TEXT_134);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_135);
    
                        }else if(isPrimitiveType && (javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT || javaType == JavaTypesManager.DOUBLE)) {  
                        
    stringBuffer.append(TEXT_136);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(javaType.getNullableClass().getSimpleName());
    stringBuffer.append(TEXT_138);
    
                        }else{
                        
    stringBuffer.append(TEXT_139);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_141);
    
                        }
                        
    stringBuffer.append(TEXT_142);
    
                        String default_Value = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, defaultValue);
                        if (column.isNullable() && default_Value != null && !"null".equals(default_Value)) {
                        
    stringBuffer.append(TEXT_143);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(default_Value);
    stringBuffer.append(TEXT_145);
    
                        } else if (column.isNullable() && !JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable())) {
                        
    stringBuffer.append(TEXT_146);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_147);
    
                        } else {
                        
    stringBuffer.append(TEXT_148);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_150);
    
                        }
                        
    stringBuffer.append(TEXT_151);
    
                }
                
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_155);
    
        // Only main flow
        } else if ((mainConnections.size() == 1) && (rejectedConnections.size() == 0)) {
            IConnection mainConnection = mainConnections.get(0);
            String connName = mainConnection.getName();
            String outStruct = codeGenArgument.getRecordStructName(mainConnection);
            
    
	boolean setTableNsMapping = "true".equals(ElementParameterParser.getValue(node, "__SET_TABLE_NS_MAPPING__"));
	String tableNsMapping = ElementParameterParser.getValue(node, "__TABLE_NS_MAPPING__");
	boolean useTableNsMapping = setTableNsMapping && ((tableNsMapping != null)&&(!tableNsMapping.equals("")));

    			
		List<IMetadataColumn> columns = metadata.getListColumns();
		int nbColumns = columns.size();
		
    stringBuffer.append(TEXT_156);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(zookeeper_quorum);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(zookeeper_client_port);
    stringBuffer.append(TEXT_161);
    
				if(setZNodeParent) {
				
    stringBuffer.append(TEXT_162);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_163);
    
				}

				if(useTableNsMapping){
				
    stringBuffer.append(TEXT_164);
    stringBuffer.append(tableNsMapping);
    stringBuffer.append(TEXT_165);
    
				}
				
				List<Map<String, String>> properties =
			        (List<Map<String,String>>)ElementParameterParser.getObjectValue(configurationNode,"__HBASE_PARAMETERS__");
			   	for(int i=0;i<properties.size();i++){
			   		Map<String, String> map = properties.get(i);
			   		String property = map.get("PROPERTY");
			   		String value= map.get("VALUE");
					
    stringBuffer.append(TEXT_166);
    stringBuffer.append(property);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_168);
    
			   	}
				
    stringBuffer.append(TEXT_169);
    stringBuffer.append(table_name);
    stringBuffer.append(TEXT_170);
    
		        List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MAPPING__");
		        
    stringBuffer.append(TEXT_171);
    stringBuffer.append(mapping.size());
    stringBuffer.append(TEXT_172);
    
				for(int i = 0; i < mapping.size(); i++){
					Map<String, String> map = mapping.get(i);
					IMetadataColumn column = columns.get(i);
					//String schema_column = map.get("SCHEMA_COLUMN");//no use, index is enough
					String family_column= map.get("FAMILY_COLUMN");
					
    stringBuffer.append(TEXT_173);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_176);
    
				}
				
    stringBuffer.append(TEXT_177);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_178);
    
	            	if(isByFilter && filterMapping.size() > 0){
	            		boolean hasMultipleColumnPrefixFilterType = false;
						for(int i=0;i<filterMapping.size();i++){
							Map<String, String> filterMap = filterMapping.get(i);
							String filterType = filterMap.get("FILTER_TYPE");
							if("MultipleColumnPrefixFilter".equals(filterType)){
								hasMultipleColumnPrefixFilterType = true;
								break;
							} 
						}
						if(hasMultipleColumnPrefixFilterType){
						
    stringBuffer.append(TEXT_179);
    
						}
						
    stringBuffer.append(TEXT_180);
    stringBuffer.append(logical);
    stringBuffer.append(TEXT_181);
    
						for(int j=0;j<filterMapping.size();j++){
							Map<String, String> filterMap = filterMapping.get(j);
							String filterType = filterMap.get("FILTER_TYPE");//"SingleColumnValueFilter","FamilyFilter","QualifierFilter","ColumnPrefixFilter","MultipleColumnPrefixFilter","MultipleColumnPrefixFilter","RowFilter"
							String filterColumn = filterMap.get("FILTER_COLUMN");
							String filterFamily = filterMap.get("FILTER_FAMILY");
							String filterOperation = filterMap.get("FILTER_OPERATOR");//"EQUAL","GREATER","GREATER_OR_EQUAL","LESS","LESS_OR_EQUAL","NO_OP","NOT_EQUAL",
							String filterValue = filterMap.get("FILTER_VALUE");
							String filterComparatorType = filterMap.get("FILTER_COMPARATOR_TYPE");//"BinaryComparator" ,"RegexStringComparator" ,"SubstringComparator"
							if("SingleColumnValueFilter".equals(filterType)){//"filterValue" is column value,like: "1" ,"2" ... ，return whole row (all columns) value 
							    if("BinaryComparator".equals(filterComparatorType)){
								
    stringBuffer.append(TEXT_182);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_186);
    
								}else if ("RegexStringComparator".equals(filterComparatorType)){
								
    stringBuffer.append(TEXT_187);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_191);
    
								}else if("SubstringComparator".equals(filterComparatorType)){
								
    stringBuffer.append(TEXT_192);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_196);
    
								}
							}else if("FamilyFilter".equals(filterType)){//"Filter Family" is family name ,like: "id_family","name_family"....， return columns which mapping in "Filter Family",filter other columns
								if("BinaryComparator".equals(filterComparatorType)){
								
    stringBuffer.append(TEXT_197);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_199);
    
								}else if ("RegexStringComparator".equals(filterComparatorType)){
								
    stringBuffer.append(TEXT_200);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_202);
    
								}else if("SubstringComparator".equals(filterComparatorType)){
								
    stringBuffer.append(TEXT_203);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_205);
    
								}
							}else if("QualifierFilter".equals(filterType)){ //"Filter Column" is column name,like:"id" or "name" .... then you will get meet codition column value ,filter other columns
								if("BinaryComparator".equals(filterComparatorType)){
								
    stringBuffer.append(TEXT_206);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_208);
    
								}else if ("RegexStringComparator".equals(filterComparatorType)){
								
    stringBuffer.append(TEXT_209);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_211);
    
								}else if("SubstringComparator".equals(filterComparatorType)){
								
    stringBuffer.append(TEXT_212);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_214);
    
								}
							}else if("ColumnPrefixFilter".equals(filterType)){//"Filter Column" value is column name,like:"id" or "name" ....,return column value,filter other columns
								if(filterFamily!=null && !"".equals(filterFamily)){ 
								
    stringBuffer.append(TEXT_215);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_216);
    
								}
								
    stringBuffer.append(TEXT_217);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_218);
    
							}else if("MultipleColumnPrefixFilter".equals(filterType)){ //"Filter Column" value is for column name ,like:"id,name" ,"id,name,sex".... , return column value,filter other columns
								if(filterFamily!=null && !"".equals(filterFamily)){ 
								
    stringBuffer.append(TEXT_219);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_220);
    
								}
								
    stringBuffer.append(TEXT_221);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_224);
    
							}else if("ColumnRangeFilter".equals(filterType)){//"Filter Column" value is tow columns name,like: "id,name" ,"id,sex" ....,return columns value ,filter other columns
								if(filterFamily!=null && !"".equals(filterFamily)){ 
								
    stringBuffer.append(TEXT_225);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_226);
    
								}
								
    stringBuffer.append(TEXT_227);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_229);
    
							}else if("RowFilter".equals(filterType)){//"Filter Value" is rowkey value,like "1" ,"car"....,return whole row (all columns)
								if("BinaryComparator".equals(filterComparatorType)){
								
    stringBuffer.append(TEXT_230);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_232);
    
								}else if ("RegexStringComparator".equals(filterComparatorType)){
								
    stringBuffer.append(TEXT_233);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_235);
    
								}else if("SubstringComparator".equals(filterComparatorType)){
								
    stringBuffer.append(TEXT_236);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_238);
    
								}
							}else if("ValueFilter".equals(filterType)){//"Filter Value" is any columns value,like "1" ,"car" .... ,return only the meet codition value,filter other columns
								if("BinaryComparator".equals(filterComparatorType)){
								
    stringBuffer.append(TEXT_239);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_241);
    
								}else if ("RegexStringComparator".equals(filterComparatorType)){
								
    stringBuffer.append(TEXT_242);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_244);
    
								}else if("SubstringComparator".equals(filterComparatorType)){
								
    stringBuffer.append(TEXT_245);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_247);
    
								}
							}
							
    stringBuffer.append(TEXT_248);
    
						}
					}
					
    stringBuffer.append(TEXT_249);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_252);
    
	                        if (dieOnError) {
	                            
    stringBuffer.append(TEXT_253);
    
	                        } else {
	                            
    stringBuffer.append(TEXT_254);
    
	                        }
	                        
    stringBuffer.append(TEXT_255);
    
							for(int i = 0; i < mapping.size(); i++){
								Map<String, String> map = mapping.get(i);
								String family_column= map.get("FAMILY_COLUMN");
								IMetadataColumn column = columns.get(i);
								String columnName = column.getLabel();
								String defaultValue = column.getDefault();
								String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
								String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
								boolean isPrimitiveType = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
								
    stringBuffer.append(TEXT_256);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_258);
    
									if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
									
    stringBuffer.append(TEXT_259);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_260);
    
									}else if(javaType == JavaTypesManager.BYTE_ARRAY){
									
    stringBuffer.append(TEXT_261);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_262);
    
									}else if(javaType == JavaTypesManager.DATE){
									
    stringBuffer.append(TEXT_263);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_265);
    
									}else if(isPrimitiveType && javaType == JavaTypesManager.INTEGER){
									
    stringBuffer.append(TEXT_266);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_267);
    
									}else if(isPrimitiveType && javaType == JavaTypesManager.CHARACTER){
									
    stringBuffer.append(TEXT_268);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_269);
    
									}else if(isPrimitiveType && (javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT || javaType == JavaTypesManager.DOUBLE)) {  
									
    stringBuffer.append(TEXT_270);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(javaType.getNullableClass().getSimpleName());
    stringBuffer.append(TEXT_272);
    
									}else{
									
    stringBuffer.append(TEXT_273);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_275);
    
									}
									
    stringBuffer.append(TEXT_276);
    
									String default_Value = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, defaultValue);
									if(default_Value != null && !"null".equals(default_Value)) {
									
    stringBuffer.append(TEXT_277);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(default_Value);
    stringBuffer.append(TEXT_279);
    
									} else if(!JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable())) {
									
    stringBuffer.append(TEXT_280);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_281);
    
									} else {
									
    stringBuffer.append(TEXT_282);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_284);
    
									}
									
    stringBuffer.append(TEXT_285);
    
							}
							
    stringBuffer.append(TEXT_286);
    
                        if (dieOnError) {
                            
    stringBuffer.append(TEXT_287);
    
                        } else {
                            
    stringBuffer.append(TEXT_288);
    
                        }
                        
    stringBuffer.append(TEXT_289);
    

    
    //Note: Because Hadoop's RecordReader class re-uses the same Writable object for each record, directly caching the returned RDD or directly passing it to an aggregation or shuffle operation will create many references to the same object. If you plan to directly cache, sort, or aggregate Hadoop writable objects, you should first copy them using a map function.

	// Uses Avro builder to copy the incoming record into a new record.
    // TODO: a Better way to copy the records. Ditch Avro builder.

    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(outStruct);
    stringBuffer.append(TEXT_301);
    
        // Reject and Main flow
        } else if((mainConnections.size() == 1) && (rejectedConnections.size() == 1)){
            IConnection mainConnection = mainConnections.get(0);
            String mainConnName = mainConnection.getName();
            String mainOutStruct = codeGenArgument.getRecordStructName(mainConnection);
            IConnection rejectedConnection = rejectedConnections.get(0);
            String rejectConnName = rejectedConnection.getName();
            String rejectOutStruct = codeGenArgument.getRecordStructName(rejectedConnection);
            
    
    boolean setTableNsMapping = "true".equals(ElementParameterParser.getValue(node, "__SET_TABLE_NS_MAPPING__"));
    String tableNsMapping = ElementParameterParser.getValue(node, "__TABLE_NS_MAPPING__");
    boolean useTableNsMapping = setTableNsMapping && ((tableNsMapping != null)&&(!tableNsMapping.equals("")));

     
if (mainConnection.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    List<IMetadataColumn> columns = metadata.getListColumns();
    int nbColumns = columns.size();
    
    stringBuffer.append(TEXT_302);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(zookeeper_quorum);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(zookeeper_client_port);
    stringBuffer.append(TEXT_310);
    
            if(setZNodeParent) {
            
    stringBuffer.append(TEXT_311);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_312);
    
            }

            if(useTableNsMapping){
            
    stringBuffer.append(TEXT_313);
    stringBuffer.append(tableNsMapping);
    stringBuffer.append(TEXT_314);
    
            }

            List<Map<String, String>> properties =
                (List<Map<String,String>>)ElementParameterParser.getObjectValue(configurationNode,"__HBASE_PARAMETERS__");
            for(int i=0;i<properties.size();i++){
                Map<String, String> map = properties.get(i);
                String property = map.get("PROPERTY");
                String value= map.get("VALUE");
                
    stringBuffer.append(TEXT_315);
    stringBuffer.append(property);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_317);
    
            }
            
    stringBuffer.append(TEXT_318);
    stringBuffer.append(table_name);
    stringBuffer.append(TEXT_319);
    
            List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MAPPING__");
            
    stringBuffer.append(TEXT_320);
    stringBuffer.append(mapping.size());
    stringBuffer.append(TEXT_321);
    
            for(int i = 0; i < mapping.size(); i++){
                Map<String, String> map = mapping.get(i);
                IMetadataColumn column = columns.get(i);
                //String schema_column = map.get("SCHEMA_COLUMN");//no use, index is enough
                String family_column= map.get("FAMILY_COLUMN");
                
    stringBuffer.append(TEXT_322);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_325);
    
            }
            // Force the creation of the output directory
            for (INode virtualNode : node.getProcess().getGraphicalNodes()) {
                if (virtualNode.getUniqueName().equals(cid)) {
                    
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(node.getProcess().getName());
    stringBuffer.append(TEXT_328);
    stringBuffer.append(virtualNode.getUniqueName());
    stringBuffer.append(TEXT_329);
    stringBuffer.append(virtualNode.getOutgoingConnections("REJECT").get(0).getName());
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    
                    break;
                }
            }
            
    stringBuffer.append(TEXT_333);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_334);
    
                if(isByFilter && filterMapping.size() > 0){
                    boolean hasMultipleColumnPrefixFilterType = false;
                    for(int i=0;i<filterMapping.size();i++){
                        Map<String, String> filterMap = filterMapping.get(i);
                        String filterType = filterMap.get("FILTER_TYPE");
                        if("MultipleColumnPrefixFilter".equals(filterType)){
                            hasMultipleColumnPrefixFilterType = true;
                            break;
                        } 
                    }
                    if(hasMultipleColumnPrefixFilterType){
                    
    stringBuffer.append(TEXT_335);
    
                    }
                    
    stringBuffer.append(TEXT_336);
    stringBuffer.append(logical);
    stringBuffer.append(TEXT_337);
    
                    for(int j=0;j<filterMapping.size();j++){
                        Map<String, String> filterMap = filterMapping.get(j);
                        String filterType = filterMap.get("FILTER_TYPE");//"SingleColumnValueFilter","FamilyFilter","QualifierFilter","ColumnPrefixFilter","MultipleColumnPrefixFilter","MultipleColumnPrefixFilter","RowFilter"
                        String filterColumn = filterMap.get("FILTER_COLUMN");
                        String filterFamily = filterMap.get("FILTER_FAMILY");
                        String filterOperation = filterMap.get("FILTER_OPERATOR");//"EQUAL","GREATER","GREATER_OR_EQUAL","LESS","LESS_OR_EQUAL","NO_OP","NOT_EQUAL",
                        String filterValue = filterMap.get("FILTER_VALUE");
                        String filterComparatorType = filterMap.get("FILTER_COMPARATOR_TYPE");//"BinaryComparator" ,"RegexStringComparator" ,"SubstringComparator"
                        if("SingleColumnValueFilter".equals(filterType)){//"filterValue" is column value,like: "1" ,"2" ... ，return whole row (all columns) value 
                            if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_338);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_342);
    
                            }else if ("RegexStringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_343);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_347);
    
                            }else if("SubstringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_348);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_352);
    
                            }
                        }else if("FamilyFilter".equals(filterType)){//"Filter Family" is family name ,like: "id_family","name_family"....， return columns which mapping in "Filter Family",filter other columns
                            if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_353);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_355);
    
                            }else if ("RegexStringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_356);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_358);
    
                            }else if("SubstringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_359);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_361);
    
                            }
                        }else if("QualifierFilter".equals(filterType)){ //"Filter Column" is column name,like:"id" or "name" .... then you will get meet codition column value ,filter other columns
                            if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_362);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_364);
    
                            }else if ("RegexStringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_365);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_367);
    
                            }else if("SubstringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_368);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_370);
    
                            }
                        }else if("ColumnPrefixFilter".equals(filterType)){//"Filter Column" value is column name,like:"id" or "name" ....,return column value,filter other columns
                            if(filterFamily!=null && !"".equals(filterFamily)){ 
                            
    stringBuffer.append(TEXT_371);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_372);
    
                            }
                            
    stringBuffer.append(TEXT_373);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_374);
    
                        }else if("MultipleColumnPrefixFilter".equals(filterType)){ //"Filter Column" value is for column name ,like:"id,name" ,"id,name,sex".... , return column value,filter other columns
                            if(filterFamily!=null && !"".equals(filterFamily)){ 
                            
    stringBuffer.append(TEXT_375);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_376);
    
                            }
                            
    stringBuffer.append(TEXT_377);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_380);
    
                        }else if("ColumnRangeFilter".equals(filterType)){//"Filter Column" value is tow columns name,like: "id,name" ,"id,sex" ....,return columns value ,filter other columns
                            if(filterFamily!=null && !"".equals(filterFamily)){ 
                            
    stringBuffer.append(TEXT_381);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_382);
    
                            }
                            
    stringBuffer.append(TEXT_383);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_385);
    
                        }else if("RowFilter".equals(filterType)){//"Filter Value" is rowkey value,like "1" ,"car"....,return whole row (all columns)
                            if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_386);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_388);
    
                            }else if ("RegexStringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_389);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_391);
    
                            }else if("SubstringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_392);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_394);
    
                            }
                        }else if("ValueFilter".equals(filterType)){//"Filter Value" is any columns value,like "1" ,"car" .... ,return only the meet codition value,filter other columns
                            if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_395);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_397);
    
                            }else if ("RegexStringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_398);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_400);
    
                            }else if("SubstringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_401);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_403);
    
                            }
                        }
                        
    stringBuffer.append(TEXT_404);
    
                    }
                }
                
    stringBuffer.append(TEXT_405);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_408);
    
}

    
List<IMetadataColumn> columns = metadata.getListColumns();
int nbColumns = columns.size();
List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MAPPING__");

    
    // First map to try to cast Hbase results into main struct objects

    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_421);
    
                for(int i = 0; i < mapping.size(); i++){
                    Map<String, String> map = mapping.get(i);
                    String family_column= map.get("FAMILY_COLUMN");
                    IMetadataColumn column = columns.get(i);
                    String columnName = column.getLabel();
                    String defaultValue = column.getDefault();
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                    boolean isPrimitiveType = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
                    
    stringBuffer.append(TEXT_422);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_424);
    
                        if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
                        
    stringBuffer.append(TEXT_425);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_427);
    
                        }else if(javaType == JavaTypesManager.BYTE_ARRAY){
                        
    stringBuffer.append(TEXT_428);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_430);
    
                        }else if(javaType == JavaTypesManager.DATE){
                        
    stringBuffer.append(TEXT_431);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_435);
    
                        }else if(isPrimitiveType && javaType == JavaTypesManager.INTEGER){
                        
    stringBuffer.append(TEXT_436);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_438);
    
                        }else if(isPrimitiveType && javaType == JavaTypesManager.CHARACTER){
                        
    stringBuffer.append(TEXT_439);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_441);
    
                        }else if(isPrimitiveType && (javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT || javaType == JavaTypesManager.DOUBLE)) {  
                        
    stringBuffer.append(TEXT_442);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(javaType.getNullableClass().getSimpleName());
    stringBuffer.append(TEXT_444);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(javaType.getNullableClass().getSimpleName());
    stringBuffer.append(TEXT_446);
    
                        }else{
                        
    stringBuffer.append(TEXT_447);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_451);
    
                        }
                        
    stringBuffer.append(TEXT_452);
    
                        String default_Value = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, defaultValue);
                        if (column.isNullable() && default_Value != null && !"null".equals(default_Value)) {
                        
    stringBuffer.append(TEXT_453);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(default_Value);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(default_Value);
    stringBuffer.append(TEXT_457);
    
                        } else if (column.isNullable() && !JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable())) {
                        
    stringBuffer.append(TEXT_458);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_460);
    
                        } else {
                        
    stringBuffer.append(TEXT_461);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_462);
    stringBuffer.append(mainConnName);
    stringBuffer.append(TEXT_463);
    
                        }
                        
    stringBuffer.append(TEXT_464);
    
                }
                
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    
    // Map to filter the casted records, true records go to main flow and false go to reject flow

    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    
    // Map to convert the record's key from Boolean to NullWritable

    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(mainOutStruct);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(rejectOutStruct);
    stringBuffer.append(TEXT_487);
    
        }
    }
}

    return stringBuffer.toString();
  }
}
