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

public class THBaseInputMrcodeJava
{
  protected static String nl;
  public static synchronized THBaseInputMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THBaseInputMrcodeJava result = new THBaseInputMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        org.apache.hadoop.hbase.client.Result result;" + NL + "        while (null != (result = getNextResult())) {" + NL + "            try {" + NL + "                if (validateResult(result, value));" + NL + "                    return true;" + NL + "            } catch (Exception e) {" + NL + "                LOG.error(e);";
  protected final String TEXT_2 = NL + "                    throw new IOException(e.getMessage());";
  protected final String TEXT_3 = NL + "            }" + NL + "        }" + NL + "        return false;";
  protected final String TEXT_4 = NL + "        public boolean validateResult(org.apache.hadoop.hbase.client.Result result,";
  protected final String TEXT_5 = NL + "                ";
  protected final String TEXT_6 = " value) throws IOException {" + NL + "            org.apache.hadoop.hbase.io.ImmutableBytesWritable rowKey = new org.apache.hadoop.hbase.io.ImmutableBytesWritable();" + NL + "            rowKey.set(result.getRow());" + NL + "            lastSuccessfulRow = rowKey.get();" + NL + "" + NL + "            byte[] rowResult = null;" + NL + "            String temp = null;";
  protected final String TEXT_7 = NL + "                rowResult = result.getValue(" + NL + "                        org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_8 = ")," + NL + "                        org.apache.hadoop.hbase.util.Bytes.toBytes(\"";
  protected final String TEXT_9 = "\"));" + NL + "                temp = org.apache.hadoop.hbase.util.Bytes.toString(rowResult);" + NL + "" + NL + "                if (temp != null && temp.length() > 0) {";
  protected final String TEXT_10 = NL + "                        ";
  protected final String TEXT_11 = " = temp.toString();";
  protected final String TEXT_12 = NL + "                        ";
  protected final String TEXT_13 = " = rowResult;";
  protected final String TEXT_14 = NL + "                        ";
  protected final String TEXT_15 = " = BigDataParserUtils.parseTo_Date(temp, ";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "                        ";
  protected final String TEXT_18 = " = org.apache.hadoop.hbase.util.Bytes.toInt(rowResult);";
  protected final String TEXT_19 = NL + "                        ";
  protected final String TEXT_20 = " = (char)org.apache.hadoop.hbase.util.Bytes.toInt(rowResult);";
  protected final String TEXT_21 = NL + "                        ";
  protected final String TEXT_22 = " = org.apache.hadoop.hbase.util.Bytes.to";
  protected final String TEXT_23 = "(rowResult);";
  protected final String TEXT_24 = NL + "                        ";
  protected final String TEXT_25 = " = BigDataParserUtils.parseTo_";
  protected final String TEXT_26 = "(temp);";
  protected final String TEXT_27 = NL + "                } else {";
  protected final String TEXT_28 = NL + "                        ";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = ";";
  protected final String TEXT_31 = NL + "                        ";
  protected final String TEXT_32 = " = null;";
  protected final String TEXT_33 = NL + "                        throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_34 = "' in '";
  protected final String TEXT_35 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_36 = NL + "                }";
  protected final String TEXT_37 = NL + "            return true;" + NL + "        }";
  protected final String TEXT_38 = NL;
  protected final String TEXT_39 = NL + NL + "public static class ";
  protected final String TEXT_40 = "InputFormat implements InputFormat<NullWritable, ";
  protected final String TEXT_41 = ">," + NL + "        JobConfigurable {" + NL + "" + NL + "    ContextProperties context;" + NL + "    private org.apache.hadoop.hbase.client.HTable hTable;" + NL + "    private byte[][] inputColumns;" + NL + "" + NL + "    public void configure(JobConf job) {" + NL + "        context = new ContextProperties(job);" + NL + "        JobConf hbaseJob = new JobConf(job);" + NL + "        hbaseJob.set(\"hbase.zookeeper.quorum\", ";
  protected final String TEXT_42 = ");" + NL + "        hbaseJob.set(\"hbase.zookeeper.property.clientPort\", ";
  protected final String TEXT_43 = ");" + NL;
  protected final String TEXT_44 = NL + "            hbaseJob.set(\"zookeeper.znode.parent\",";
  protected final String TEXT_45 = ");";
  protected final String TEXT_46 = NL + "            hbaseJob.set(\"hbase.table.namespace.mappings\", ";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + "            hbaseJob.set(";
  protected final String TEXT_49 = ", ";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL + NL + "        try {" + NL + "            this.hTable = new org.apache.hadoop.hbase.client.HTable(hbaseJob, ";
  protected final String TEXT_52 = ");" + NL + "        } catch (Exception e) {" + NL + "            throw new RuntimeException(e);" + NL + "        }" + NL;
  protected final String TEXT_53 = NL + "        this.inputColumns = new byte[";
  protected final String TEXT_54 = "][];";
  protected final String TEXT_55 = NL + "            this.inputColumns[";
  protected final String TEXT_56 = "] = org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_57 = NL + "                    ";
  protected final String TEXT_58 = NL + "                    + org.apache.hadoop.hbase.KeyValue.COLUMN_FAMILY_DELIMITER" + NL + "                    + \"";
  protected final String TEXT_59 = "\");";
  protected final String TEXT_60 = NL + "    }" + NL + "" + NL + "    public InputSplit[] getSplits(JobConf job, int numSplits) throws IOException {" + NL + "        if (this.hTable == null) {" + NL + "            throw new IOException(\"No table was provided\");" + NL + "        }" + NL + "        byte[][] startKeys = this.hTable.getStartKeys();" + NL + "        if (startKeys == null || startKeys.length == 0) {" + NL + "            throw new IOException(\"Expecting at least one region\");" + NL + "        }" + NL + "        if (this.inputColumns == null || this.inputColumns.length == 0) {" + NL + "            throw new IOException(\"Expecting at least one column\");" + NL + "        }" + NL + "        int realNumSplits = numSplits > startKeys.length ? startKeys.length : numSplits;" + NL + "        InputSplit[] splits = new InputSplit[realNumSplits];" + NL + "        int middle = startKeys.length / realNumSplits;" + NL + "        int startPos = 0;" + NL + "        for (int i = 0; i < realNumSplits; i++) {" + NL + "            int lastPos = startPos + middle;" + NL + "            lastPos = startKeys.length % realNumSplits > i ? lastPos + 1 : lastPos;" + NL + "            String regionLocation = hTable.getRegionLocation(startKeys[startPos]).getHostname();" + NL + "            splits[i] = new HBaseTableSplit(this.hTable.getTableName(), startKeys[startPos]," + NL + "                    ((i + 1) < realNumSplits) ? startKeys[lastPos] : org.apache.hadoop.hbase.HConstants.EMPTY_START_ROW, regionLocation);" + NL + "            startPos = lastPos;" + NL + "        }" + NL + "        return splits;" + NL + "    }" + NL + "" + NL + "    public RecordReader getRecordReader(InputSplit inputsplit, JobConf job, Reporter reporter) throws IOException {" + NL + "       return new HBaseTableRecordReader((HBaseTableSplit) inputsplit, job, this.hTable, this.inputColumns);" + NL + "    }" + NL + "" + NL + "    protected static class HBaseTableRecordReader implements RecordReader<NullWritable, ";
  protected final String TEXT_61 = "> {" + NL + "" + NL + "        private JobConf job;" + NL + "" + NL + "        private HBaseTableSplit split;" + NL + "" + NL + "        private org.apache.hadoop.hbase.client.ResultScanner scanner;" + NL + "" + NL + "        private byte[] startRow;" + NL + "" + NL + "        private byte[] endRow;" + NL + "" + NL + "        private byte[] lastSuccessfulRow;" + NL + "" + NL + "        private org.apache.hadoop.hbase.client.HTable hTable;" + NL + "" + NL + "        private byte[][] inputColumns;" + NL + "" + NL + "        private org.apache.hadoop.hbase.filter.FilterList filterList;" + NL + "" + NL + "        ContextProperties context;" + NL + "" + NL + "        protected HBaseTableRecordReader(HBaseTableSplit split, JobConf job, org.apache.hadoop.hbase.client.HTable hTable, byte[][] inputColumns) throws IOException {" + NL + "            context = new ContextProperties(job);" + NL + "            this.hTable = hTable;" + NL + "            this.inputColumns = inputColumns;" + NL + "            this.split = split;" + NL + "            this.job = job;" + NL + "            this.startRow = split.getStartRow();" + NL + "            this.endRow = split.getEndRow();" + NL + "            initFilter();" + NL + "            restart(startRow);" + NL + "        }" + NL + "" + NL + "        private void initFilter(){";
  protected final String TEXT_62 = NL + "                    String [] multipleValues = null;" + NL + "                    byte [][] multipleBytesValues = null;";
  protected final String TEXT_63 = NL + "                this.filterList = new org.apache.hadoop.hbase.filter.FilterList(" + NL + "                        org.apache.hadoop.hbase.filter.FilterList.Operator.";
  protected final String TEXT_64 = ");" + NL + "                org.apache.hadoop.hbase.filter.Filter filter = null;";
  protected final String TEXT_65 = NL + "                            filter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(" + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_66 = ")," + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_67 = ")," + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_68 = "," + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_69 = "));";
  protected final String TEXT_70 = NL + "                            filter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(" + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_71 = ")," + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_72 = ")," + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_73 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_74 = "));";
  protected final String TEXT_75 = NL + "                            filter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(" + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_76 = ")," + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_77 = ")," + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_78 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_79 = "));";
  protected final String TEXT_80 = NL + "                            filter = new org.apache.hadoop.hbase.filter.FamilyFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_81 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.BinaryComparator(" + NL + "                                            org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_82 = ")));";
  protected final String TEXT_83 = NL + "                            filter = new org.apache.hadoop.hbase.filter.FamilyFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_84 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_85 = "));";
  protected final String TEXT_86 = NL + "                            filter = new org.apache.hadoop.hbase.filter.FamilyFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_87 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_88 = "));";
  protected final String TEXT_89 = NL + "                            filter = new org.apache.hadoop.hbase.filter.QualifierFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_90 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.BinaryComparator(" + NL + "                                            org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_91 = ")));";
  protected final String TEXT_92 = NL + "                            filter = new org.apache.hadoop.hbase.filter.QualifierFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_93 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_94 = "));";
  protected final String TEXT_95 = NL + "                            filter = new org.apache.hadoop.hbase.filter.QualifierFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_96 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_97 = "));";
  protected final String TEXT_98 = NL + "                            scan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_99 = "));";
  protected final String TEXT_100 = NL + "                        filter = new org.apache.hadoop.hbase.filter.ColumnPrefixFilter(" + NL + "                                org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_101 = "));";
  protected final String TEXT_102 = NL + "                            scan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_103 = "));";
  protected final String TEXT_104 = NL + "                        if (";
  protected final String TEXT_105 = "!=null && !\"\".equals(";
  protected final String TEXT_106 = ")) {" + NL + "                            multipleValues = ";
  protected final String TEXT_107 = ".split(\",\");" + NL + "                            multipleBytesValues = new byte [multipleValues.length] [];" + NL + "                            for (int i = 0; i < multipleValues.length; i++) {" + NL + "                                multipleBytesValues[i] = org.apache.hadoop.hbase.util.Bytes.toBytes(multipleValues[i]);" + NL + "                            }" + NL + "                            filter =  new org.apache.hadoop.hbase.filter.MultipleColumnPrefixFilter(multipleBytesValues);" + NL + "                        }";
  protected final String TEXT_108 = NL + "                            scan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_109 = "));";
  protected final String TEXT_110 = NL + "                        filter = new org.apache.hadoop.hbase.filter.ColumnRangeFilter(" + NL + "                                org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_111 = ".split(\",\")[0])," + NL + "                                true," + NL + "                                org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_112 = ".split(\",\")[1])," + NL + "                                true);";
  protected final String TEXT_113 = NL + "                            filter = new org.apache.hadoop.hbase.filter.RowFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_114 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.BinaryComparator(" + NL + "                                            org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_115 = ")));";
  protected final String TEXT_116 = NL + "                            filter = new org.apache.hadoop.hbase.filter.RowFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_117 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_118 = "));";
  protected final String TEXT_119 = NL + "                            filter = new org.apache.hadoop.hbase.filter.RowFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_120 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_121 = "));";
  protected final String TEXT_122 = NL + "                            filter = new org.apache.hadoop.hbase.filter.ValueFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_123 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.BinaryComparator(" + NL + "                                            org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_124 = ")));";
  protected final String TEXT_125 = NL + "                            filter = new org.apache.hadoop.hbase.filter.ValueFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_126 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_127 = "));";
  protected final String TEXT_128 = NL + "                            filter = new org.apache.hadoop.hbase.filter.ValueFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_129 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_130 = "));";
  protected final String TEXT_131 = NL + "                    this.filterList.addFilter(filter);";
  protected final String TEXT_132 = NL + "        }" + NL + "" + NL + "        private void setFilter(org.apache.hadoop.hbase.client.Scan scan){" + NL + "            if (this.filterList != null) {" + NL + "                scan.setFilter(this.filterList);" + NL + "                scan.setCacheBlocks(false);" + NL + "            }" + NL + "        }" + NL + "" + NL + "        public void restart(byte[] firstRow) throws IOException {" + NL + "            org.apache.hadoop.hbase.client.Scan scan;" + NL + "            if ((endRow != null) && (endRow.length > 0)) {" + NL + "                scan = new org.apache.hadoop.hbase.client.Scan(firstRow, endRow);" + NL + "            } else {" + NL + "                scan = new org.apache.hadoop.hbase.client.Scan(firstRow);" + NL + "            }" + NL + "            for (byte[] column : inputColumns) {" + NL + "                byte[][] fq = org.apache.hadoop.hbase.KeyValue.parseColumn(column);" + NL + "                if (fq.length > 1 && fq[1] != null && fq[1].length > 0) {" + NL + "                    scan.addColumn(fq[0], fq[1]);" + NL + "                } else {" + NL + "                    scan.addFamily(fq[0]);" + NL + "                }" + NL + "            }" + NL + "            setFilter(scan);" + NL + "            this.scanner = hTable.getScanner(scan);" + NL + "        }" + NL + "" + NL + "        public void close() throws IOException {" + NL + "            this.scanner.close();" + NL + "        }" + NL + "" + NL + "        public NullWritable createKey() {" + NL + "            return NullWritable.get();" + NL + "        }" + NL + "" + NL + "        public ";
  protected final String TEXT_133 = " createValue() {" + NL + "            return new ";
  protected final String TEXT_134 = "();" + NL + "        }" + NL + "" + NL + "        public long getPos() throws IOException {" + NL + "            // This should be the ordinal tuple in the range;" + NL + "            // not clear how to calculate..." + NL + "            return 0;" + NL + "        }" + NL + "" + NL + "        public float getProgress() throws IOException {" + NL + "            // Depends on the total number of tuples and getPos" + NL + "            return 0;" + NL + "        }" + NL + "" + NL + "        public boolean next(NullWritable key, ";
  protected final String TEXT_135 = " value) throws IOException {";
  protected final String TEXT_136 = NL + "        }" + NL + "" + NL + "        private org.apache.hadoop.hbase.client.Result getNextResult() throws IOException {";
  protected final String TEXT_137 = NL + "                org.apache.hadoop.hbase.client.Result result = this.scanner.next();";
  protected final String TEXT_138 = NL + "                org.apache.hadoop.hbase.client.Result result;" + NL + "                try {" + NL + "                    result = this.scanner.next();" + NL + "                } catch (IOException e) {" + NL + "                    if (lastSuccessfulRow == null) {" + NL + "                        restart(startRow);" + NL + "                    } else {" + NL + "                        restart(lastSuccessfulRow);" + NL + "                        this.scanner.next();" + NL + "                    }" + NL + "                    result = this.scanner.next();" + NL + "                }";
  protected final String TEXT_139 = NL + "            return (result == null || result.size() == 0) ? null : result;" + NL + "        }" + NL;
  protected final String TEXT_140 = NL + "    }" + NL + "" + NL + "    protected static class HBaseTableSplit implements InputSplit, Comparable<HBaseTableSplit> {" + NL + "" + NL + "        private byte[] m_tableName;" + NL + "" + NL + "        private byte[] m_startRow;" + NL + "" + NL + "        private byte[] m_endRow;" + NL + "" + NL + "        private String m_regionLocation;" + NL + "" + NL + "        public HBaseTableSplit() {" + NL + "            this(org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, \"\");" + NL + "        }" + NL + "" + NL + "        public HBaseTableSplit(byte[] tableName, byte[] startRow, byte[] endRow, final String location) {" + NL + "            this.m_tableName = tableName;" + NL + "            this.m_startRow = startRow;" + NL + "            this.m_endRow = endRow;" + NL + "            this.m_regionLocation = location;" + NL + "        }" + NL + "" + NL + "        public byte[] getTableName() {" + NL + "            return this.m_tableName;" + NL + "        }" + NL + "" + NL + "        public byte[] getStartRow() {" + NL + "            return this.m_startRow;" + NL + "        }" + NL + "" + NL + "        public byte[] getEndRow() {" + NL + "            return this.m_endRow;" + NL + "        }" + NL + "" + NL + "        public String getRegionLocation() {" + NL + "            return this.m_regionLocation;" + NL + "        }" + NL + "" + NL + "        public String[] getLocations() {" + NL + "            return new String[] { this.m_regionLocation };" + NL + "        }" + NL + "" + NL + "        public long getLength() {" + NL + "            // Not clear how to obtain this... seems to be used only for sorting splits" + NL + "            return 0;" + NL + "        }" + NL + "" + NL + "        public void readFields(DataInput in) throws IOException {" + NL + "            this.m_tableName = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "            this.m_startRow = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "            this.m_endRow = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "            this.m_regionLocation = org.apache.hadoop.hbase.util.Bytes.toString(org.apache.hadoop.hbase.util.Bytes.readByteArray(in));" + NL + "        }" + NL + "" + NL + "        public void write(DataOutput out) throws IOException {" + NL + "            org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_tableName);" + NL + "            org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_startRow);" + NL + "            org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_endRow);" + NL + "            org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, org.apache.hadoop.hbase.util.Bytes.toBytes(this.m_regionLocation));" + NL + "        }" + NL + "" + NL + "        public String toString() {" + NL + "            return m_regionLocation + \":\" + org.apache.hadoop.hbase.util.Bytes.toStringBinary(m_startRow) + \",\" + org.apache.hadoop.hbase.util.Bytes.toStringBinary(m_endRow);" + NL + "        }" + NL + "" + NL + "        public int compareTo(HBaseTableSplit o) {" + NL + "            return org.apache.hadoop.hbase.util.Bytes.compareTo(getStartRow(), o.getStartRow());" + NL + "        }" + NL + "    }" + NL + "}";
  protected final String TEXT_141 = NL + "        org.apache.hadoop.hbase.client.Result result;" + NL + "        while (null != (result = getNextResult()) {" + NL + "            try {" + NL + "                if (validateResult(result, value)));" + NL + "                    continue;" + NL + "            } catch (Exception e) {" + NL + "                value.invalidInputLine = record.toString();" + NL + "                value.errorCode = e.toString();" + NL + "                return true;" + NL + "            }" + NL + "        }" + NL + "        return false;";
  protected final String TEXT_142 = NL + "        public boolean validateResult(org.apache.hadoop.hbase.client.Result result,";
  protected final String TEXT_143 = NL + "                ";
  protected final String TEXT_144 = " value) throws IOException {" + NL + "            org.apache.hadoop.hbase.io.ImmutableBytesWritable rowKey = new org.apache.hadoop.hbase.io.ImmutableBytesWritable();" + NL + "            rowKey.set(result.getRow());" + NL + "            lastSuccessfulRow = rowKey.get();" + NL + "" + NL + "            byte[] rowResult = null;" + NL + "            String temp = null;";
  protected final String TEXT_145 = NL + "                rowResult = result.getValue(" + NL + "                        org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_146 = ")," + NL + "                        org.apache.hadoop.hbase.util.Bytes.toBytes(\"";
  protected final String TEXT_147 = "\"));" + NL + "                temp = org.apache.hadoop.hbase.util.Bytes.toString(rowResult);" + NL + "" + NL + "                if (temp != null && temp.length() > 0) {";
  protected final String TEXT_148 = NL + "                        ";
  protected final String TEXT_149 = " = temp.toString();";
  protected final String TEXT_150 = NL + "                        ";
  protected final String TEXT_151 = " = rowResult;";
  protected final String TEXT_152 = NL + "                        ";
  protected final String TEXT_153 = " = BigDataParserUtils.parseTo_Date(temp, ";
  protected final String TEXT_154 = ");";
  protected final String TEXT_155 = NL + "                        ";
  protected final String TEXT_156 = " = org.apache.hadoop.hbase.util.Bytes.toInt(rowResult);";
  protected final String TEXT_157 = NL + "                        ";
  protected final String TEXT_158 = " = (char)org.apache.hadoop.hbase.util.Bytes.toInt(rowResult);";
  protected final String TEXT_159 = NL + "                        ";
  protected final String TEXT_160 = " = org.apache.hadoop.hbase.util.Bytes.to";
  protected final String TEXT_161 = "(rowResult);";
  protected final String TEXT_162 = NL + "                        ";
  protected final String TEXT_163 = " = BigDataParserUtils.parseTo_";
  protected final String TEXT_164 = "(temp);";
  protected final String TEXT_165 = NL + "                } else {";
  protected final String TEXT_166 = NL + "                        ";
  protected final String TEXT_167 = " = ";
  protected final String TEXT_168 = ";";
  protected final String TEXT_169 = NL + "                        ";
  protected final String TEXT_170 = " = null;";
  protected final String TEXT_171 = NL + "                        throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_172 = "' in '";
  protected final String TEXT_173 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_174 = NL + "                }";
  protected final String TEXT_175 = NL + "            return true;" + NL + "        }";
  protected final String TEXT_176 = NL;
  protected final String TEXT_177 = NL + NL + "public static class ";
  protected final String TEXT_178 = "InputFormat implements InputFormat<NullWritable, ";
  protected final String TEXT_179 = ">," + NL + "        JobConfigurable {" + NL + "" + NL + "    ContextProperties context;" + NL + "    private org.apache.hadoop.hbase.client.HTable hTable;" + NL + "    private byte[][] inputColumns;" + NL + "" + NL + "    public void configure(JobConf job) {" + NL + "        context = new ContextProperties(job);" + NL + "        JobConf hbaseJob = new JobConf(job);" + NL + "        hbaseJob.set(\"hbase.zookeeper.quorum\", ";
  protected final String TEXT_180 = ");" + NL + "        hbaseJob.set(\"hbase.zookeeper.property.clientPort\", ";
  protected final String TEXT_181 = ");" + NL;
  protected final String TEXT_182 = NL + "            hbaseJob.set(\"zookeeper.znode.parent\",";
  protected final String TEXT_183 = ");";
  protected final String TEXT_184 = NL + "            hbaseJob.set(\"hbase.table.namespace.mappings\", ";
  protected final String TEXT_185 = ");";
  protected final String TEXT_186 = NL + "            hbaseJob.set(";
  protected final String TEXT_187 = ", ";
  protected final String TEXT_188 = ");";
  protected final String TEXT_189 = NL + NL + "        try {" + NL + "            this.hTable = new org.apache.hadoop.hbase.client.HTable(hbaseJob, ";
  protected final String TEXT_190 = ");" + NL + "        } catch (Exception e) {" + NL + "            throw new RuntimeException(e);" + NL + "        }" + NL;
  protected final String TEXT_191 = NL + "        this.inputColumns = new byte[";
  protected final String TEXT_192 = "][];";
  protected final String TEXT_193 = NL + "            this.inputColumns[";
  protected final String TEXT_194 = "] = org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_195 = NL + "                    ";
  protected final String TEXT_196 = NL + "                    + org.apache.hadoop.hbase.KeyValue.COLUMN_FAMILY_DELIMITER" + NL + "                    + \"";
  protected final String TEXT_197 = "\");";
  protected final String TEXT_198 = NL + "    }" + NL + "" + NL + "    public InputSplit[] getSplits(JobConf job, int numSplits) throws IOException {" + NL + "        if (this.hTable == null) {" + NL + "            throw new IOException(\"No table was provided\");" + NL + "        }" + NL + "        byte[][] startKeys = this.hTable.getStartKeys();" + NL + "        if (startKeys == null || startKeys.length == 0) {" + NL + "            throw new IOException(\"Expecting at least one region\");" + NL + "        }" + NL + "        if (this.inputColumns == null || this.inputColumns.length == 0) {" + NL + "            throw new IOException(\"Expecting at least one column\");" + NL + "        }" + NL + "        int realNumSplits = numSplits > startKeys.length ? startKeys.length : numSplits;" + NL + "        InputSplit[] splits = new InputSplit[realNumSplits];" + NL + "        int middle = startKeys.length / realNumSplits;" + NL + "        int startPos = 0;" + NL + "        for (int i = 0; i < realNumSplits; i++) {" + NL + "            int lastPos = startPos + middle;" + NL + "            lastPos = startKeys.length % realNumSplits > i ? lastPos + 1 : lastPos;" + NL + "            String regionLocation = hTable.getRegionLocation(startKeys[startPos]).getHostname();" + NL + "            splits[i] = new HBaseTableSplit(this.hTable.getTableName(), startKeys[startPos]," + NL + "                    ((i + 1) < realNumSplits) ? startKeys[lastPos] : org.apache.hadoop.hbase.HConstants.EMPTY_START_ROW, regionLocation);" + NL + "            startPos = lastPos;" + NL + "        }" + NL + "        return splits;" + NL + "    }" + NL + "" + NL + "    public RecordReader getRecordReader(InputSplit inputsplit, JobConf job, Reporter reporter) throws IOException {" + NL + "       return new HBaseTableRecordReader((HBaseTableSplit) inputsplit, job, this.hTable, this.inputColumns);" + NL + "    }" + NL + "" + NL + "    protected static class HBaseTableRecordReader implements RecordReader<NullWritable, ";
  protected final String TEXT_199 = "> {" + NL + "" + NL + "        private JobConf job;" + NL + "" + NL + "        private HBaseTableSplit split;" + NL + "" + NL + "        private org.apache.hadoop.hbase.client.ResultScanner scanner;" + NL + "" + NL + "        private byte[] startRow;" + NL + "" + NL + "        private byte[] endRow;" + NL + "" + NL + "        private byte[] lastSuccessfulRow;" + NL + "" + NL + "        private org.apache.hadoop.hbase.client.HTable hTable;" + NL + "" + NL + "        private byte[][] inputColumns;" + NL + "" + NL + "        private org.apache.hadoop.hbase.filter.FilterList filterList;" + NL + "" + NL + "        ContextProperties context;" + NL + "" + NL + "        protected HBaseTableRecordReader(HBaseTableSplit split, JobConf job, org.apache.hadoop.hbase.client.HTable hTable, byte[][] inputColumns) throws IOException {" + NL + "            context = new ContextProperties(job);" + NL + "            this.hTable = hTable;" + NL + "            this.inputColumns = inputColumns;" + NL + "            this.split = split;" + NL + "            this.job = job;" + NL + "            this.startRow = split.getStartRow();" + NL + "            this.endRow = split.getEndRow();" + NL + "            initFilter();" + NL + "            restart(startRow);" + NL + "        }" + NL + "" + NL + "        private void initFilter(){";
  protected final String TEXT_200 = NL + "                    String [] multipleValues = null;" + NL + "                    byte [][] multipleBytesValues = null;";
  protected final String TEXT_201 = NL + "                this.filterList = new org.apache.hadoop.hbase.filter.FilterList(" + NL + "                        org.apache.hadoop.hbase.filter.FilterList.Operator.";
  protected final String TEXT_202 = ");" + NL + "                org.apache.hadoop.hbase.filter.Filter filter = null;";
  protected final String TEXT_203 = NL + "                            filter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(" + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_204 = ")," + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_205 = ")," + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_206 = "," + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_207 = "));";
  protected final String TEXT_208 = NL + "                            filter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(" + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_209 = ")," + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_210 = ")," + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_211 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_212 = "));";
  protected final String TEXT_213 = NL + "                            filter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(" + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_214 = ")," + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_215 = ")," + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_216 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_217 = "));";
  protected final String TEXT_218 = NL + "                            filter = new org.apache.hadoop.hbase.filter.FamilyFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_219 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.BinaryComparator(" + NL + "                                            org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_220 = ")));";
  protected final String TEXT_221 = NL + "                            filter = new org.apache.hadoop.hbase.filter.FamilyFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_222 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_223 = "));";
  protected final String TEXT_224 = NL + "                            filter = new org.apache.hadoop.hbase.filter.FamilyFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_225 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_226 = "));";
  protected final String TEXT_227 = NL + "                            filter = new org.apache.hadoop.hbase.filter.QualifierFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_228 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.BinaryComparator(" + NL + "                                            org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_229 = ")));";
  protected final String TEXT_230 = NL + "                            filter = new org.apache.hadoop.hbase.filter.QualifierFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_231 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_232 = "));";
  protected final String TEXT_233 = NL + "                            filter = new org.apache.hadoop.hbase.filter.QualifierFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_234 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_235 = "));";
  protected final String TEXT_236 = NL + "                            scan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_237 = "));";
  protected final String TEXT_238 = NL + "                        filter = new org.apache.hadoop.hbase.filter.ColumnPrefixFilter(" + NL + "                                org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_239 = "));";
  protected final String TEXT_240 = NL + "                            scan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_241 = "));";
  protected final String TEXT_242 = NL + "                        if (";
  protected final String TEXT_243 = "!=null && !\"\".equals(";
  protected final String TEXT_244 = ")) {" + NL + "                            multipleValues = ";
  protected final String TEXT_245 = ".split(\",\");" + NL + "                            multipleBytesValues = new byte [multipleValues.length] [];" + NL + "                            for (int i = 0; i < multipleValues.length; i++) {" + NL + "                                multipleBytesValues[i] = org.apache.hadoop.hbase.util.Bytes.toBytes(multipleValues[i]);" + NL + "                            }" + NL + "                            filter =  new org.apache.hadoop.hbase.filter.MultipleColumnPrefixFilter(multipleBytesValues);" + NL + "                        }";
  protected final String TEXT_246 = NL + "                            scan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_247 = "));";
  protected final String TEXT_248 = NL + "                        filter = new org.apache.hadoop.hbase.filter.ColumnRangeFilter(" + NL + "                                org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_249 = ".split(\",\")[0])," + NL + "                                true," + NL + "                                org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_250 = ".split(\",\")[1])," + NL + "                                true);";
  protected final String TEXT_251 = NL + "                            filter = new org.apache.hadoop.hbase.filter.RowFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_252 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.BinaryComparator(" + NL + "                                            org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_253 = ")));";
  protected final String TEXT_254 = NL + "                            filter = new org.apache.hadoop.hbase.filter.RowFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_255 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_256 = "));";
  protected final String TEXT_257 = NL + "                            filter = new org.apache.hadoop.hbase.filter.RowFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_258 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_259 = "));";
  protected final String TEXT_260 = NL + "                            filter = new org.apache.hadoop.hbase.filter.ValueFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_261 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.BinaryComparator(" + NL + "                                            org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_262 = ")));";
  protected final String TEXT_263 = NL + "                            filter = new org.apache.hadoop.hbase.filter.ValueFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_264 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_265 = "));";
  protected final String TEXT_266 = NL + "                            filter = new org.apache.hadoop.hbase.filter.ValueFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_267 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_268 = "));";
  protected final String TEXT_269 = NL + "                    this.filterList.addFilter(filter);";
  protected final String TEXT_270 = NL + "        }" + NL + "" + NL + "        private void setFilter(org.apache.hadoop.hbase.client.Scan scan){" + NL + "            if (this.filterList != null) {" + NL + "                scan.setFilter(this.filterList);" + NL + "                scan.setCacheBlocks(false);" + NL + "            }" + NL + "        }" + NL + "" + NL + "        public void restart(byte[] firstRow) throws IOException {" + NL + "            org.apache.hadoop.hbase.client.Scan scan;" + NL + "            if ((endRow != null) && (endRow.length > 0)) {" + NL + "                scan = new org.apache.hadoop.hbase.client.Scan(firstRow, endRow);" + NL + "            } else {" + NL + "                scan = new org.apache.hadoop.hbase.client.Scan(firstRow);" + NL + "            }" + NL + "            for (byte[] column : inputColumns) {" + NL + "                byte[][] fq = org.apache.hadoop.hbase.KeyValue.parseColumn(column);" + NL + "                if (fq.length > 1 && fq[1] != null && fq[1].length > 0) {" + NL + "                    scan.addColumn(fq[0], fq[1]);" + NL + "                } else {" + NL + "                    scan.addFamily(fq[0]);" + NL + "                }" + NL + "            }" + NL + "            setFilter(scan);" + NL + "            this.scanner = hTable.getScanner(scan);" + NL + "        }" + NL + "" + NL + "        public void close() throws IOException {" + NL + "            this.scanner.close();" + NL + "        }" + NL + "" + NL + "        public NullWritable createKey() {" + NL + "            return NullWritable.get();" + NL + "        }" + NL + "" + NL + "        public ";
  protected final String TEXT_271 = " createValue() {" + NL + "            return new ";
  protected final String TEXT_272 = "();" + NL + "        }" + NL + "" + NL + "        public long getPos() throws IOException {" + NL + "            // This should be the ordinal tuple in the range;" + NL + "            // not clear how to calculate..." + NL + "            return 0;" + NL + "        }" + NL + "" + NL + "        public float getProgress() throws IOException {" + NL + "            // Depends on the total number of tuples and getPos" + NL + "            return 0;" + NL + "        }" + NL + "" + NL + "        public boolean next(NullWritable key, ";
  protected final String TEXT_273 = " value) throws IOException {";
  protected final String TEXT_274 = NL + "        }" + NL + "" + NL + "        private org.apache.hadoop.hbase.client.Result getNextResult() throws IOException {";
  protected final String TEXT_275 = NL + "                org.apache.hadoop.hbase.client.Result result = this.scanner.next();";
  protected final String TEXT_276 = NL + "                org.apache.hadoop.hbase.client.Result result;" + NL + "                try {" + NL + "                    result = this.scanner.next();" + NL + "                } catch (IOException e) {" + NL + "                    if (lastSuccessfulRow == null) {" + NL + "                        restart(startRow);" + NL + "                    } else {" + NL + "                        restart(lastSuccessfulRow);" + NL + "                        this.scanner.next();" + NL + "                    }" + NL + "                    result = this.scanner.next();" + NL + "                }";
  protected final String TEXT_277 = NL + "            return (result == null || result.size() == 0) ? null : result;" + NL + "        }" + NL;
  protected final String TEXT_278 = NL + "    }" + NL + "" + NL + "    protected static class HBaseTableSplit implements InputSplit, Comparable<HBaseTableSplit> {" + NL + "" + NL + "        private byte[] m_tableName;" + NL + "" + NL + "        private byte[] m_startRow;" + NL + "" + NL + "        private byte[] m_endRow;" + NL + "" + NL + "        private String m_regionLocation;" + NL + "" + NL + "        public HBaseTableSplit() {" + NL + "            this(org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, \"\");" + NL + "        }" + NL + "" + NL + "        public HBaseTableSplit(byte[] tableName, byte[] startRow, byte[] endRow, final String location) {" + NL + "            this.m_tableName = tableName;" + NL + "            this.m_startRow = startRow;" + NL + "            this.m_endRow = endRow;" + NL + "            this.m_regionLocation = location;" + NL + "        }" + NL + "" + NL + "        public byte[] getTableName() {" + NL + "            return this.m_tableName;" + NL + "        }" + NL + "" + NL + "        public byte[] getStartRow() {" + NL + "            return this.m_startRow;" + NL + "        }" + NL + "" + NL + "        public byte[] getEndRow() {" + NL + "            return this.m_endRow;" + NL + "        }" + NL + "" + NL + "        public String getRegionLocation() {" + NL + "            return this.m_regionLocation;" + NL + "        }" + NL + "" + NL + "        public String[] getLocations() {" + NL + "            return new String[] { this.m_regionLocation };" + NL + "        }" + NL + "" + NL + "        public long getLength() {" + NL + "            // Not clear how to obtain this... seems to be used only for sorting splits" + NL + "            return 0;" + NL + "        }" + NL + "" + NL + "        public void readFields(DataInput in) throws IOException {" + NL + "            this.m_tableName = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "            this.m_startRow = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "            this.m_endRow = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "            this.m_regionLocation = org.apache.hadoop.hbase.util.Bytes.toString(org.apache.hadoop.hbase.util.Bytes.readByteArray(in));" + NL + "        }" + NL + "" + NL + "        public void write(DataOutput out) throws IOException {" + NL + "            org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_tableName);" + NL + "            org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_startRow);" + NL + "            org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_endRow);" + NL + "            org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, org.apache.hadoop.hbase.util.Bytes.toBytes(this.m_regionLocation));" + NL + "        }" + NL + "" + NL + "        public String toString() {" + NL + "            return m_regionLocation + \":\" + org.apache.hadoop.hbase.util.Bytes.toStringBinary(m_startRow) + \",\" + org.apache.hadoop.hbase.util.Bytes.toStringBinary(m_endRow);" + NL + "        }" + NL + "" + NL + "        public int compareTo(HBaseTableSplit o) {" + NL + "            return org.apache.hadoop.hbase.util.Bytes.compareTo(getStartRow(), o.getStartRow());" + NL + "        }" + NL + "    }" + NL + "}";
  protected final String TEXT_279 = NL + "        org.apache.hadoop.hbase.client.Result result;" + NL + "        try {" + NL + "            try {" + NL + "                result = this.scanner.next();" + NL + "            } catch (IOException e) {" + NL + "                if (lastSuccessfulRow == null) {" + NL + "                    restart(startRow);" + NL + "                } else {" + NL + "                    restart(lastSuccessfulRow);" + NL + "                    this.scanner.next();" + NL + "                }" + NL + "                result = this.scanner.next();" + NL + "            }" + NL + "" + NL + "            if (result != null && result.size() > 0) {" + NL + "                value.set(result);" + NL + "                org.apache.hadoop.hbase.io.ImmutableBytesWritable rowKey = new org.apache.hadoop.hbase.io.ImmutableBytesWritable();" + NL + "                rowKey.set(result.getRow());" + NL + "                lastSuccessfulRow = rowKey.get();" + NL + "                return true;" + NL + "            }" + NL + "            return false;" + NL + "        } catch (IOException ioe) {" + NL + "            throw ioe;" + NL + "        }";
  protected final String TEXT_280 = NL + "public static class ";
  protected final String TEXT_281 = " extends org.apache.hadoop.io.ObjectWritable {" + NL + "}" + NL;
  protected final String TEXT_282 = NL + NL + "public static class ";
  protected final String TEXT_283 = "InputFormat implements InputFormat<NullWritable, ";
  protected final String TEXT_284 = ">," + NL + "        JobConfigurable {" + NL + "" + NL + "    ContextProperties context;" + NL + "    private org.apache.hadoop.hbase.client.HTable hTable;" + NL + "    private byte[][] inputColumns;" + NL + "" + NL + "    public void configure(JobConf job) {" + NL + "        context = new ContextProperties(job);" + NL + "        JobConf hbaseJob = new JobConf(job);" + NL + "        hbaseJob.set(\"hbase.zookeeper.quorum\", ";
  protected final String TEXT_285 = ");" + NL + "        hbaseJob.set(\"hbase.zookeeper.property.clientPort\", ";
  protected final String TEXT_286 = ");" + NL;
  protected final String TEXT_287 = NL + "            hbaseJob.set(\"zookeeper.znode.parent\",";
  protected final String TEXT_288 = ");";
  protected final String TEXT_289 = NL + "            hbaseJob.set(\"hbase.table.namespace.mappings\", ";
  protected final String TEXT_290 = ");";
  protected final String TEXT_291 = NL + "            hbaseJob.set(";
  protected final String TEXT_292 = ", ";
  protected final String TEXT_293 = ");";
  protected final String TEXT_294 = NL + NL + "        try {" + NL + "            this.hTable = new org.apache.hadoop.hbase.client.HTable(hbaseJob, ";
  protected final String TEXT_295 = ");" + NL + "        } catch (Exception e) {" + NL + "            throw new RuntimeException(e);" + NL + "        }" + NL;
  protected final String TEXT_296 = NL + "        this.inputColumns = new byte[";
  protected final String TEXT_297 = "][];";
  protected final String TEXT_298 = NL + "            this.inputColumns[";
  protected final String TEXT_299 = "] = org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_300 = NL + "                    ";
  protected final String TEXT_301 = NL + "                    + org.apache.hadoop.hbase.KeyValue.COLUMN_FAMILY_DELIMITER" + NL + "                    + \"";
  protected final String TEXT_302 = "\");";
  protected final String TEXT_303 = NL + "    }" + NL + "" + NL + "    public InputSplit[] getSplits(JobConf job, int numSplits) throws IOException {" + NL + "        if (this.hTable == null) {" + NL + "            throw new IOException(\"No table was provided\");" + NL + "        }" + NL + "        byte[][] startKeys = this.hTable.getStartKeys();" + NL + "        if (startKeys == null || startKeys.length == 0) {" + NL + "            throw new IOException(\"Expecting at least one region\");" + NL + "        }" + NL + "        if (this.inputColumns == null || this.inputColumns.length == 0) {" + NL + "            throw new IOException(\"Expecting at least one column\");" + NL + "        }" + NL + "        int realNumSplits = numSplits > startKeys.length ? startKeys.length : numSplits;" + NL + "        InputSplit[] splits = new InputSplit[realNumSplits];" + NL + "        int middle = startKeys.length / realNumSplits;" + NL + "        int startPos = 0;" + NL + "        for (int i = 0; i < realNumSplits; i++) {" + NL + "            int lastPos = startPos + middle;" + NL + "            lastPos = startKeys.length % realNumSplits > i ? lastPos + 1 : lastPos;" + NL + "            String regionLocation = hTable.getRegionLocation(startKeys[startPos]).getHostname();" + NL + "            splits[i] = new HBaseTableSplit(this.hTable.getTableName(), startKeys[startPos]," + NL + "                    ((i + 1) < realNumSplits) ? startKeys[lastPos] : org.apache.hadoop.hbase.HConstants.EMPTY_START_ROW, regionLocation);" + NL + "            startPos = lastPos;" + NL + "        }" + NL + "        return splits;" + NL + "    }" + NL + "" + NL + "    public RecordReader getRecordReader(InputSplit inputsplit, JobConf job, Reporter reporter) throws IOException {" + NL + "       return new HBaseTableRecordReader((HBaseTableSplit) inputsplit, job, this.hTable, this.inputColumns);" + NL + "    }" + NL + "" + NL + "    protected static class HBaseTableRecordReader implements RecordReader<NullWritable, ";
  protected final String TEXT_304 = "> {" + NL + "" + NL + "        private JobConf job;" + NL + "" + NL + "        private HBaseTableSplit split;" + NL + "" + NL + "        private org.apache.hadoop.hbase.client.ResultScanner scanner;" + NL + "" + NL + "        private byte[] startRow;" + NL + "" + NL + "        private byte[] endRow;" + NL + "" + NL + "        private byte[] lastSuccessfulRow;" + NL + "" + NL + "        private org.apache.hadoop.hbase.client.HTable hTable;" + NL + "" + NL + "        private byte[][] inputColumns;" + NL + "" + NL + "        private org.apache.hadoop.hbase.filter.FilterList filterList;" + NL + "" + NL + "        ContextProperties context;" + NL + "" + NL + "        protected HBaseTableRecordReader(HBaseTableSplit split, JobConf job, org.apache.hadoop.hbase.client.HTable hTable, byte[][] inputColumns) throws IOException {" + NL + "            context = new ContextProperties(job);" + NL + "            this.hTable = hTable;" + NL + "            this.inputColumns = inputColumns;" + NL + "            this.split = split;" + NL + "            this.job = job;" + NL + "            this.startRow = split.getStartRow();" + NL + "            this.endRow = split.getEndRow();" + NL + "            initFilter();" + NL + "            restart(startRow);" + NL + "        }" + NL + "" + NL + "        private void initFilter(){";
  protected final String TEXT_305 = NL + "                    String [] multipleValues = null;" + NL + "                    byte [][] multipleBytesValues = null;";
  protected final String TEXT_306 = NL + "                this.filterList = new org.apache.hadoop.hbase.filter.FilterList(" + NL + "                        org.apache.hadoop.hbase.filter.FilterList.Operator.";
  protected final String TEXT_307 = ");" + NL + "                org.apache.hadoop.hbase.filter.Filter filter = null;";
  protected final String TEXT_308 = NL + "                            filter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(" + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_309 = ")," + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_310 = ")," + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_311 = "," + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_312 = "));";
  protected final String TEXT_313 = NL + "                            filter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(" + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_314 = ")," + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_315 = ")," + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_316 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_317 = "));";
  protected final String TEXT_318 = NL + "                            filter = new org.apache.hadoop.hbase.filter.SingleColumnValueFilter(" + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_319 = ")," + NL + "                                    org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_320 = ")," + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_321 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_322 = "));";
  protected final String TEXT_323 = NL + "                            filter = new org.apache.hadoop.hbase.filter.FamilyFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_324 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.BinaryComparator(" + NL + "                                            org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_325 = ")));";
  protected final String TEXT_326 = NL + "                            filter = new org.apache.hadoop.hbase.filter.FamilyFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_327 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_328 = "));";
  protected final String TEXT_329 = NL + "                            filter = new org.apache.hadoop.hbase.filter.FamilyFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_330 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_331 = "));";
  protected final String TEXT_332 = NL + "                            filter = new org.apache.hadoop.hbase.filter.QualifierFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_333 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.BinaryComparator(" + NL + "                                            org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_334 = ")));";
  protected final String TEXT_335 = NL + "                            filter = new org.apache.hadoop.hbase.filter.QualifierFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_336 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_337 = "));";
  protected final String TEXT_338 = NL + "                            filter = new org.apache.hadoop.hbase.filter.QualifierFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_339 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_340 = "));";
  protected final String TEXT_341 = NL + "                            scan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_342 = "));";
  protected final String TEXT_343 = NL + "                        filter = new org.apache.hadoop.hbase.filter.ColumnPrefixFilter(" + NL + "                                org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_344 = "));";
  protected final String TEXT_345 = NL + "                            scan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_346 = "));";
  protected final String TEXT_347 = NL + "                        if (";
  protected final String TEXT_348 = "!=null && !\"\".equals(";
  protected final String TEXT_349 = ")) {" + NL + "                            multipleValues = ";
  protected final String TEXT_350 = ".split(\",\");" + NL + "                            multipleBytesValues = new byte [multipleValues.length] [];" + NL + "                            for (int i = 0; i < multipleValues.length; i++) {" + NL + "                                multipleBytesValues[i] = org.apache.hadoop.hbase.util.Bytes.toBytes(multipleValues[i]);" + NL + "                            }" + NL + "                            filter =  new org.apache.hadoop.hbase.filter.MultipleColumnPrefixFilter(multipleBytesValues);" + NL + "                        }";
  protected final String TEXT_351 = NL + "                            scan.addFamily(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_352 = "));";
  protected final String TEXT_353 = NL + "                        filter = new org.apache.hadoop.hbase.filter.ColumnRangeFilter(" + NL + "                                org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_354 = ".split(\",\")[0])," + NL + "                                true," + NL + "                                org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_355 = ".split(\",\")[1])," + NL + "                                true);";
  protected final String TEXT_356 = NL + "                            filter = new org.apache.hadoop.hbase.filter.RowFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_357 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.BinaryComparator(" + NL + "                                            org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_358 = ")));";
  protected final String TEXT_359 = NL + "                            filter = new org.apache.hadoop.hbase.filter.RowFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_360 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_361 = "));";
  protected final String TEXT_362 = NL + "                            filter = new org.apache.hadoop.hbase.filter.RowFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_363 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_364 = "));";
  protected final String TEXT_365 = NL + "                            filter = new org.apache.hadoop.hbase.filter.ValueFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_366 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.BinaryComparator(" + NL + "                                            org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_367 = ")));";
  protected final String TEXT_368 = NL + "                            filter = new org.apache.hadoop.hbase.filter.ValueFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_369 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.RegexStringComparator(";
  protected final String TEXT_370 = "));";
  protected final String TEXT_371 = NL + "                            filter = new org.apache.hadoop.hbase.filter.ValueFilter(" + NL + "                                    org.apache.hadoop.hbase.filter.CompareFilter.CompareOp.";
  protected final String TEXT_372 = "," + NL + "                                    new org.apache.hadoop.hbase.filter.SubstringComparator(";
  protected final String TEXT_373 = "));";
  protected final String TEXT_374 = NL + "                    this.filterList.addFilter(filter);";
  protected final String TEXT_375 = NL + "        }" + NL + "" + NL + "        private void setFilter(org.apache.hadoop.hbase.client.Scan scan){" + NL + "            if (this.filterList != null) {" + NL + "                scan.setFilter(this.filterList);" + NL + "                scan.setCacheBlocks(false);" + NL + "            }" + NL + "        }" + NL + "" + NL + "        public void restart(byte[] firstRow) throws IOException {" + NL + "            org.apache.hadoop.hbase.client.Scan scan;" + NL + "            if ((endRow != null) && (endRow.length > 0)) {" + NL + "                scan = new org.apache.hadoop.hbase.client.Scan(firstRow, endRow);" + NL + "            } else {" + NL + "                scan = new org.apache.hadoop.hbase.client.Scan(firstRow);" + NL + "            }" + NL + "            for (byte[] column : inputColumns) {" + NL + "                byte[][] fq = org.apache.hadoop.hbase.KeyValue.parseColumn(column);" + NL + "                if (fq.length > 1 && fq[1] != null && fq[1].length > 0) {" + NL + "                    scan.addColumn(fq[0], fq[1]);" + NL + "                } else {" + NL + "                    scan.addFamily(fq[0]);" + NL + "                }" + NL + "            }" + NL + "            setFilter(scan);" + NL + "            this.scanner = hTable.getScanner(scan);" + NL + "        }" + NL + "" + NL + "        public void close() throws IOException {" + NL + "            this.scanner.close();" + NL + "        }" + NL + "" + NL + "        public NullWritable createKey() {" + NL + "            return NullWritable.get();" + NL + "        }" + NL + "" + NL + "        public ";
  protected final String TEXT_376 = " createValue() {" + NL + "            return new ";
  protected final String TEXT_377 = "();" + NL + "        }" + NL + "" + NL + "        public long getPos() throws IOException {" + NL + "            // This should be the ordinal tuple in the range;" + NL + "            // not clear how to calculate..." + NL + "            return 0;" + NL + "        }" + NL + "" + NL + "        public float getProgress() throws IOException {" + NL + "            // Depends on the total number of tuples and getPos" + NL + "            return 0;" + NL + "        }" + NL + "" + NL + "        public boolean next(NullWritable key, ";
  protected final String TEXT_378 = " value) throws IOException {";
  protected final String TEXT_379 = NL + "        }" + NL + "" + NL + "        private org.apache.hadoop.hbase.client.Result getNextResult() throws IOException {";
  protected final String TEXT_380 = NL + "                org.apache.hadoop.hbase.client.Result result = this.scanner.next();";
  protected final String TEXT_381 = NL + "                org.apache.hadoop.hbase.client.Result result;" + NL + "                try {" + NL + "                    result = this.scanner.next();" + NL + "                } catch (IOException e) {" + NL + "                    if (lastSuccessfulRow == null) {" + NL + "                        restart(startRow);" + NL + "                    } else {" + NL + "                        restart(lastSuccessfulRow);" + NL + "                        this.scanner.next();" + NL + "                    }" + NL + "                    result = this.scanner.next();" + NL + "                }";
  protected final String TEXT_382 = NL + "            return (result == null || result.size() == 0) ? null : result;" + NL + "        }" + NL;
  protected final String TEXT_383 = NL + "    }" + NL + "" + NL + "    protected static class HBaseTableSplit implements InputSplit, Comparable<HBaseTableSplit> {" + NL + "" + NL + "        private byte[] m_tableName;" + NL + "" + NL + "        private byte[] m_startRow;" + NL + "" + NL + "        private byte[] m_endRow;" + NL + "" + NL + "        private String m_regionLocation;" + NL + "" + NL + "        public HBaseTableSplit() {" + NL + "            this(org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, org.apache.hadoop.hbase.HConstants.EMPTY_BYTE_ARRAY, \"\");" + NL + "        }" + NL + "" + NL + "        public HBaseTableSplit(byte[] tableName, byte[] startRow, byte[] endRow, final String location) {" + NL + "            this.m_tableName = tableName;" + NL + "            this.m_startRow = startRow;" + NL + "            this.m_endRow = endRow;" + NL + "            this.m_regionLocation = location;" + NL + "        }" + NL + "" + NL + "        public byte[] getTableName() {" + NL + "            return this.m_tableName;" + NL + "        }" + NL + "" + NL + "        public byte[] getStartRow() {" + NL + "            return this.m_startRow;" + NL + "        }" + NL + "" + NL + "        public byte[] getEndRow() {" + NL + "            return this.m_endRow;" + NL + "        }" + NL + "" + NL + "        public String getRegionLocation() {" + NL + "            return this.m_regionLocation;" + NL + "        }" + NL + "" + NL + "        public String[] getLocations() {" + NL + "            return new String[] { this.m_regionLocation };" + NL + "        }" + NL + "" + NL + "        public long getLength() {" + NL + "            // Not clear how to obtain this... seems to be used only for sorting splits" + NL + "            return 0;" + NL + "        }" + NL + "" + NL + "        public void readFields(DataInput in) throws IOException {" + NL + "            this.m_tableName = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "            this.m_startRow = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "            this.m_endRow = org.apache.hadoop.hbase.util.Bytes.readByteArray(in);" + NL + "            this.m_regionLocation = org.apache.hadoop.hbase.util.Bytes.toString(org.apache.hadoop.hbase.util.Bytes.readByteArray(in));" + NL + "        }" + NL + "" + NL + "        public void write(DataOutput out) throws IOException {" + NL + "            org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_tableName);" + NL + "            org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_startRow);" + NL + "            org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, this.m_endRow);" + NL + "            org.apache.hadoop.hbase.util.Bytes.writeByteArray(out, org.apache.hadoop.hbase.util.Bytes.toBytes(this.m_regionLocation));" + NL + "        }" + NL + "" + NL + "        public String toString() {" + NL + "            return m_regionLocation + \":\" + org.apache.hadoop.hbase.util.Bytes.toStringBinary(m_startRow) + \",\" + org.apache.hadoop.hbase.util.Bytes.toStringBinary(m_endRow);" + NL + "        }" + NL + "" + NL + "        public int compareTo(HBaseTableSplit o) {" + NL + "            return org.apache.hadoop.hbase.util.Bytes.compareTo(getStartRow(), o.getStartRow());" + NL + "        }" + NL + "    }" + NL + "}" + NL + "" + NL + "" + NL + "public static class ";
  protected final String TEXT_384 = "_InputMapper extends MapReduceBase" + NL + "        implements Mapper<NullWritable, ";
  protected final String TEXT_385 = ", NullWritable, WritableComparable>{" + NL + "    private ContextProperties context;" + NL + "    private GlobalVar globalMap;" + NL + "    public MultipleOutputs mos_";
  protected final String TEXT_386 = ";" + NL + "    private ";
  protected final String TEXT_387 = "Struct ";
  protected final String TEXT_388 = " = null;" + NL + "    private ";
  protected final String TEXT_389 = "Struct ";
  protected final String TEXT_390 = " = null;" + NL + "" + NL + "    public void configure(JobConf job_";
  protected final String TEXT_391 = "){" + NL + "        context = new ContextProperties(job_";
  protected final String TEXT_392 = ");" + NL + "        globalMap = new GlobalVar(job_";
  protected final String TEXT_393 = ");" + NL + "        mos_";
  protected final String TEXT_394 = " = new MultipleOutputs(job_";
  protected final String TEXT_395 = ");" + NL;
  protected final String TEXT_396 = NL + "        ";
  protected final String TEXT_397 = " = new ";
  protected final String TEXT_398 = "Struct();";
  protected final String TEXT_399 = NL + "        ";
  protected final String TEXT_400 = " = new ";
  protected final String TEXT_401 = "Struct();" + NL;
  protected final String TEXT_402 = NL + "                try {" + NL + "                    FileSystem fs = FileSystem.get(job_";
  protected final String TEXT_403 = ");" + NL + "                    Path path = new Path(" + NL + "                            \"/tmp/";
  protected final String TEXT_404 = "\"" + NL + "                            + \"/tMROutput_";
  protected final String TEXT_405 = "\"" + NL + "                            + \"/";
  protected final String TEXT_406 = "\");" + NL + "                    fs.mkdirs(path);" + NL + "                } catch (Exception ex_";
  protected final String TEXT_407 = ") {" + NL + "                    throw new RuntimeException(ex_";
  protected final String TEXT_408 = ".getMessage());" + NL + "                }";
  protected final String TEXT_409 = NL + "    }" + NL + "" + NL + "    public void map(NullWritable key_";
  protected final String TEXT_410 = ", ";
  protected final String TEXT_411 = " value_";
  protected final String TEXT_412 = "," + NL + "            OutputCollector<NullWritable, WritableComparable> output_";
  protected final String TEXT_413 = ", Reporter reporter_";
  protected final String TEXT_414 = ") throws IOException{" + NL + "        org.apache.hadoop.hbase.client.Result result = (org.apache.hadoop.hbase.client.Result)value_";
  protected final String TEXT_415 = ".get();" + NL + "        byte[] rowResult = null;" + NL + "        String temp = null;" + NL + "        try {";
  protected final String TEXT_416 = NL + "                rowResult = result.getValue(org.apache.hadoop.hbase.util.Bytes.toBytes(";
  protected final String TEXT_417 = "), org.apache.hadoop.hbase.util.Bytes.toBytes(\"";
  protected final String TEXT_418 = "\"));" + NL + "                temp = org.apache.hadoop.hbase.util.Bytes.toString(rowResult);" + NL + "                if(temp!=null && temp.length() > 0) {";
  protected final String TEXT_419 = NL + "                        ";
  protected final String TEXT_420 = " = temp.toString();";
  protected final String TEXT_421 = NL + "                        ";
  protected final String TEXT_422 = "=rowResult;";
  protected final String TEXT_423 = NL + "                        ";
  protected final String TEXT_424 = "=BigDataParserUtils.parseTo_Date(temp, ";
  protected final String TEXT_425 = ");";
  protected final String TEXT_426 = NL + "                        ";
  protected final String TEXT_427 = "=org.apache.hadoop.hbase.util.Bytes.toInt(rowResult);";
  protected final String TEXT_428 = NL + "                        ";
  protected final String TEXT_429 = "=(char)org.apache.hadoop.hbase.util.Bytes.toInt(rowResult);";
  protected final String TEXT_430 = NL + "                        ";
  protected final String TEXT_431 = "=org.apache.hadoop.hbase.util.Bytes.to";
  protected final String TEXT_432 = "(rowResult);";
  protected final String TEXT_433 = NL + "                        ";
  protected final String TEXT_434 = "=BigDataParserUtils.parseTo_";
  protected final String TEXT_435 = "(temp);";
  protected final String TEXT_436 = NL + "                }else{";
  protected final String TEXT_437 = NL + "                        ";
  protected final String TEXT_438 = " = ";
  protected final String TEXT_439 = ";";
  protected final String TEXT_440 = NL + "                        ";
  protected final String TEXT_441 = " = null;";
  protected final String TEXT_442 = NL + "                        throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_443 = "' in '";
  protected final String TEXT_444 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_445 = NL + "                }";
  protected final String TEXT_446 = NL + "            output_";
  protected final String TEXT_447 = ".collect(NullWritable.get(), ";
  protected final String TEXT_448 = ");" + NL + "        } catch  (Exception e) {";
  protected final String TEXT_449 = NL + "            ";
  protected final String TEXT_450 = ".invalidInputLine = value_";
  protected final String TEXT_451 = ".toString();";
  protected final String TEXT_452 = NL + "            ";
  protected final String TEXT_453 = ".errorCode = e.toString();" + NL + "            mos_";
  protected final String TEXT_454 = ".getCollector(\"";
  protected final String TEXT_455 = "\", reporter_";
  protected final String TEXT_456 = ")" + NL + "                    .collect(NullWritable.get(), ";
  protected final String TEXT_457 = ");" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public void close() throws IOException{" + NL + "        mos_";
  protected final String TEXT_458 = ".close();" + NL + "    }" + NL + "} // end of ";
  protected final String TEXT_459 = "_InputMapper" + NL + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
BigDataCodeGeneratorArgument codeGenArgument = (BigDataCodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

// Fail fast when no output connections exist.
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
if (conns == null || conns.size() == 0)
    return "";

// Parameters

String tableName = ElementParameterParser.getValue(node, "__TABLE__");
boolean isByFilter = ("true").equals(ElementParameterParser.getValue(node, "__IS_BY_FILTER__"));
List<Map<String, String>> filterMapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__FILTER__");
String logical = ElementParameterParser.getValue(node,"__LOGICAL_OP__");
String distribution = ElementParameterParser.getValue(node,"__DISTRIBUTION__");
String version = ElementParameterParser.getValue(node,"__HBASE_VERSION__");
String folder = ElementParameterParser.getValue(node,"__FILENAME__");
final boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
final List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MAPPING__");
List<Map<String, String>> hbaseParameters = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node,"__HBASE_PARAMETERS__");

// Get the output connections.
List< ? extends IConnection> rejConns = node.getOutgoingConnections("REJECT");
List< ? extends IConnection> mainConns = node.getOutgoingConnections("FLOW");
IConnection mainConn = mainConns == null || mainConns.size() == 0
        ? null : mainConns.get(0);
IConnection rejConn = rejConns == null || rejConns.size() == 0
        ? null : rejConns.get(0);

// Fail fast on bad main connection style.
if (mainConn != null && !mainConn.getLineStyle().hasConnectionCategory(
        IConnectionCategory.DATA)) {
    return "";
}

// Fail fast on no connections.
if (mainConn == null && rejConn == null) {
    return "";
}

if (mainConn != null && rejConn == null) {
    
    
// The name of the main row.
final String mainName = mainConn.getName();
final String mainRecord = codeGenArgument.getRecordStructName(mainConn);
final String recordStruct = mainRecord;
final List<IMetadataColumn> mainColumns = mainConn.getMetadataTable().getListColumns();

class NextRecordGenerator {
    /** Generate the implementation for the RecordReader.next() method. */
    public void generate() {
        
    stringBuffer.append(TEXT_1);
    
                if (dieOnError) {
                    
    stringBuffer.append(TEXT_2);
    
                }
                
    stringBuffer.append(TEXT_3);
    
    }
    public void generateHelperMethods() {
        
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_6);
    
            for (int i = 0; i < mapping.size(); i++) {
                Map<String, String> map = mapping.get(i);
                String family_column= map.get("FAMILY_COLUMN");
                IMetadataColumn column = mainColumns.get(i);
                String columnName = column.getLabel();
                String defaultValue = column.getDefault();
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                boolean isPrimitiveType = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
                String toAssign = "value." + columnName;

                
    stringBuffer.append(TEXT_7);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_9);
     if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_11);
     } else if(javaType == JavaTypesManager.BYTE_ARRAY) { 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_13);
     }else if(javaType == JavaTypesManager.DATE) { 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_16);
     }else if(isPrimitiveType && javaType == JavaTypesManager.INTEGER) { 
    stringBuffer.append(TEXT_17);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_18);
     }else if(isPrimitiveType && javaType == JavaTypesManager.CHARACTER) { 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_20);
     } else if(isPrimitiveType && (javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.LONG
                                || javaType == JavaTypesManager.FLOAT || javaType == JavaTypesManager.DOUBLE)) { 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(javaType.getNullableClass().getSimpleName());
    stringBuffer.append(TEXT_23);
     }else {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_26);
     } 
    stringBuffer.append(TEXT_27);
    
                    String default_Value = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, defaultValue);
                    if (default_Value != null && !"null".equals(default_Value)) {
                        
    stringBuffer.append(TEXT_28);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(default_Value);
    stringBuffer.append(TEXT_30);
    
                    } else if (!JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable())) {
                        
    stringBuffer.append(TEXT_31);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_32);
    
                    } else {
                        
    stringBuffer.append(TEXT_33);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(mainName);
    stringBuffer.append(TEXT_35);
    
                    }
                    
    stringBuffer.append(TEXT_36);
    
            }
            
    stringBuffer.append(TEXT_37);
    
    }
}

NextRecordGenerator nextRecordImplementation = new NextRecordGenerator();

    stringBuffer.append(TEXT_38);
    

String zookeeperQuorum = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
String zookeeperClientPort = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");


boolean setTableNsMapping = "true".equals(ElementParameterParser.getValue(node, "__SET_TABLE_NS_MAPPING__"));
String tableNsMapping = ElementParameterParser.getValue(node, "__TABLE_NS_MAPPING__");
boolean useTableNsMapping = setTableNsMapping && ((tableNsMapping != null) && (!tableNsMapping.equals("")));


    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(zookeeperQuorum);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(zookeeperClientPort);
    stringBuffer.append(TEXT_43);
    
        if(setZNodeParent) {
            
    stringBuffer.append(TEXT_44);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_45);
    
        }

        if(useTableNsMapping){
            
    stringBuffer.append(TEXT_46);
    stringBuffer.append(tableNsMapping);
    stringBuffer.append(TEXT_47);
    
        }

        for (Map<String,String> param : hbaseParameters) {
            
    stringBuffer.append(TEXT_48);
    stringBuffer.append(param.get("PROPERTY"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(param.get("VALUE"));
    stringBuffer.append(TEXT_50);
    
        }
        
    stringBuffer.append(TEXT_51);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_52);
    
        
    stringBuffer.append(TEXT_53);
    stringBuffer.append(mapping.size());
    stringBuffer.append(TEXT_54);
    
        for (int i = 0; i < mapping.size(); i++) {
            Map<String, String> map = mapping.get(i);
            IMetadataColumn column = mainColumns.get(i);
            //String schema_column = map.get("SCHEMA_COLUMN");//no use, index is enough
            String family_column= map.get("FAMILY_COLUMN");
            
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_59);
    
        }
        
    stringBuffer.append(TEXT_60);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_61);
    
            if (isByFilter && filterMapping.size() > 0) {
                boolean hasMultipleColumnPrefixFilterType = false;
                for (int i=0; i < filterMapping.size(); i++) {
                    Map<String, String> filterMap = filterMapping.get(i);
                    String filterType = filterMap.get("FILTER_TYPE");
                    if("MultipleColumnPrefixFilter".equals(filterType)){
                        hasMultipleColumnPrefixFilterType = true;
                        break;
                    }
                }
                if (hasMultipleColumnPrefixFilterType) {
                    
    stringBuffer.append(TEXT_62);
    
                }
                
    stringBuffer.append(TEXT_63);
    stringBuffer.append(logical);
    stringBuffer.append(TEXT_64);
    
                for (int j=0; j<filterMapping.size(); j++){
                    Map<String, String> filterMap = filterMapping.get(j);
                    //"SingleColumnValueFilter","FamilyFilter","QualifierFilter",
                    // "ColumnPrefixFilter","MultipleColumnPrefixFilter","MultipleColumnPrefixFilter","RowFilter"
                    String filterType = filterMap.get("FILTER_TYPE");
                    String filterColumn = filterMap.get("FILTER_COLUMN");
                    String filterFamily = filterMap.get("FILTER_FAMILY");
                    //"EQUAL","GREATER","GREATER_OR_EQUAL","LESS","LESS_OR_EQUAL","NO_OP","NOT_EQUAL",
                    String filterOperation = filterMap.get("FILTER_OPERATOR");
                    String filterValue = filterMap.get("FILTER_VALUE");
                    String filterComparatorType = filterMap.get("FILTER_COMPARATOR_TYPE");
                    //"BinaryComparator" ,"RegexStringComparator" ,"SubstringComparator"
                    if("SingleColumnValueFilter".equals(filterType)) {
                        // "filterValue" is column value,like: "1" ,"2" ...
                        // return whole row (all columns) value
                        if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_65);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_69);
    
                        } else if ("RegexStringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_70);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_74);
    
                        } else if("SubstringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_75);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_79);
    
                        }
                    } else if("FamilyFilter".equals(filterType)) {
                        // "Filter Family" is family name ,like: "id_family","name_family"....，
                        // return columns which mapping in "Filter Family",filter other columns
                        if("BinaryComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_80);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_82);
    
                        } else if ("RegexStringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_83);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_85);
    
                        } else if("SubstringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_86);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_88);
    
                        }
                    } else if("QualifierFilter".equals(filterType)) {
                        // "Filter Column" is column name,like:"id" or "name" ....
                        // then you will get meet codition column value ,filter other columns
                        if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_89);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_91);
    
                        }else if ("RegexStringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_92);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_94);
    
                        }else if("SubstringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_95);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_97);
    
                        }
                    } else if("ColumnPrefixFilter".equals(filterType)) {
                        // "Filter Column" value is column name,like:"id" or "name" ....,
                        // return column value,filter other columns
                        if (filterFamily!=null && !"".equals(filterFamily)) {
                            
    stringBuffer.append(TEXT_98);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_99);
    
                        }
                        
    stringBuffer.append(TEXT_100);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_101);
    
                    } else if("MultipleColumnPrefixFilter".equals(filterType)) {
                        // "Filter Column" value is for column name ,like:"id,name" ,"id,name,sex".... ,
                        // return column value,filter other columns
                        if(filterFamily!=null && !"".equals(filterFamily)){
                            
    stringBuffer.append(TEXT_102);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_103);
    
                        }
                        
    stringBuffer.append(TEXT_104);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_107);
    
                    } else if("ColumnRangeFilter".equals(filterType)) {
                        // "Filter Column" value is tow columns name,like: "id,name" ,"id,sex" ....,
                        // return columns value ,filter other columns
                        if (filterFamily!=null && !"".equals(filterFamily)) {
                            
    stringBuffer.append(TEXT_108);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_109);
    
                        }
                        
    stringBuffer.append(TEXT_110);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_112);
    
                    } else if("RowFilter".equals(filterType)) {
                        // "Filter Value" is rowkey value,like "1" ,"car"....,return whole row (all columns)
                        if ("BinaryComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_113);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_115);
    
                        } else if ("RegexStringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_116);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_118);
    
                        } else if("SubstringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_119);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_121);
    
                        }
                    } else if("ValueFilter".equals(filterType)) {
                        // "Filter Value" is any columns value,like "1" ,"car" .... ,
                        // return only the meet codition value,filter other columns
                        if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_122);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_124);
    
                        }else if ("RegexStringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_125);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_127);
    
                        }else if("SubstringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_128);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_130);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_131);
    
                }
            }
            
    stringBuffer.append(TEXT_132);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_135);
    
            // Use a specific callback to generate the appropriate next record.
            nextRecordImplementation.generate();
            
    stringBuffer.append(TEXT_136);
    
            if (dieOnError) {
                
    stringBuffer.append(TEXT_137);
    
            } else {
                
    stringBuffer.append(TEXT_138);
    
            }
            
    stringBuffer.append(TEXT_139);
    
        // Any required helper methods here.
        nextRecordImplementation.generateHelperMethods();
        
    stringBuffer.append(TEXT_140);
    
} else if (rejConn != null && mainConn == null) {
    
    
// The name of the reject row.
final String rejName = rejConn.getName();
final String rejRecord = codeGenArgument.getRecordStructName(rejConn);
final String recordStruct = rejRecord;

// We don't what to get the metadata of the main flow, so we check if the current metadata is not the reject flow
final List<IMetadataColumn> mainColumns;
{
    List<IMetadataColumn> mainColumnsTmp = null;
    for (IMetadataTable md : node.getMetadataList()) {
        if (!"REJECT".equals(md.getTableName())) {
            mainColumnsTmp = md.getListColumns();
            break;
        }
    }
    mainColumns = mainColumnsTmp;
}
if (mainColumns == null)
    return "";

class NextRecordGenerator {
    /** Generate the implementation for the RecordReader.next() method. */
    public void generate() {
        
    stringBuffer.append(TEXT_141);
    
    }
    public void generateHelperMethods() {
        
    stringBuffer.append(TEXT_142);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_144);
    
            for (int i = 0; i < mapping.size(); i++) {
                Map<String, String> map = mapping.get(i);
                String family_column= map.get("FAMILY_COLUMN");
                IMetadataColumn column = mainColumns.get(i);
                String columnName = column.getLabel();
                String defaultValue = column.getDefault();
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                boolean isPrimitiveType = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
                String toAssign = "value." + columnName;

                
    stringBuffer.append(TEXT_145);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_147);
     if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { 
    stringBuffer.append(TEXT_148);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_149);
     } else if(javaType == JavaTypesManager.BYTE_ARRAY) { 
    stringBuffer.append(TEXT_150);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_151);
     }else if(javaType == JavaTypesManager.DATE) { 
    stringBuffer.append(TEXT_152);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_154);
     }else if(isPrimitiveType && javaType == JavaTypesManager.INTEGER) { 
    stringBuffer.append(TEXT_155);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_156);
     }else if(isPrimitiveType && javaType == JavaTypesManager.CHARACTER) { 
    stringBuffer.append(TEXT_157);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_158);
     } else if(isPrimitiveType && (javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.LONG
                                || javaType == JavaTypesManager.FLOAT || javaType == JavaTypesManager.DOUBLE)) { 
    stringBuffer.append(TEXT_159);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(javaType.getNullableClass().getSimpleName());
    stringBuffer.append(TEXT_161);
     }else {
    stringBuffer.append(TEXT_162);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_164);
     } 
    stringBuffer.append(TEXT_165);
    
                    String default_Value = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, defaultValue);
                    if (default_Value != null && !"null".equals(default_Value)) {
                        
    stringBuffer.append(TEXT_166);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(default_Value);
    stringBuffer.append(TEXT_168);
    
                    } else if (!JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable())) {
                        
    stringBuffer.append(TEXT_169);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_170);
    
                    } else {
                        
    stringBuffer.append(TEXT_171);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(rejName);
    stringBuffer.append(TEXT_173);
    
                    }
                    
    stringBuffer.append(TEXT_174);
    
            }
            
    stringBuffer.append(TEXT_175);
    
    }
}

NextRecordGenerator nextRecordImplementation = new NextRecordGenerator();

    stringBuffer.append(TEXT_176);
    

String zookeeperQuorum = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
String zookeeperClientPort = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");


boolean setTableNsMapping = "true".equals(ElementParameterParser.getValue(node, "__SET_TABLE_NS_MAPPING__"));
String tableNsMapping = ElementParameterParser.getValue(node, "__TABLE_NS_MAPPING__");
boolean useTableNsMapping = setTableNsMapping && ((tableNsMapping != null) && (!tableNsMapping.equals("")));


    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(zookeeperQuorum);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(zookeeperClientPort);
    stringBuffer.append(TEXT_181);
    
        if(setZNodeParent) {
            
    stringBuffer.append(TEXT_182);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_183);
    
        }

        if(useTableNsMapping){
            
    stringBuffer.append(TEXT_184);
    stringBuffer.append(tableNsMapping);
    stringBuffer.append(TEXT_185);
    
        }

        for (Map<String,String> param : hbaseParameters) {
            
    stringBuffer.append(TEXT_186);
    stringBuffer.append(param.get("PROPERTY"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(param.get("VALUE"));
    stringBuffer.append(TEXT_188);
    
        }
        
    stringBuffer.append(TEXT_189);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_190);
    
        
    stringBuffer.append(TEXT_191);
    stringBuffer.append(mapping.size());
    stringBuffer.append(TEXT_192);
    
        for (int i = 0; i < mapping.size(); i++) {
            Map<String, String> map = mapping.get(i);
            IMetadataColumn column = mainColumns.get(i);
            //String schema_column = map.get("SCHEMA_COLUMN");//no use, index is enough
            String family_column= map.get("FAMILY_COLUMN");
            
    stringBuffer.append(TEXT_193);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_197);
    
        }
        
    stringBuffer.append(TEXT_198);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_199);
    
            if (isByFilter && filterMapping.size() > 0) {
                boolean hasMultipleColumnPrefixFilterType = false;
                for (int i=0; i < filterMapping.size(); i++) {
                    Map<String, String> filterMap = filterMapping.get(i);
                    String filterType = filterMap.get("FILTER_TYPE");
                    if("MultipleColumnPrefixFilter".equals(filterType)){
                        hasMultipleColumnPrefixFilterType = true;
                        break;
                    }
                }
                if (hasMultipleColumnPrefixFilterType) {
                    
    stringBuffer.append(TEXT_200);
    
                }
                
    stringBuffer.append(TEXT_201);
    stringBuffer.append(logical);
    stringBuffer.append(TEXT_202);
    
                for (int j=0; j<filterMapping.size(); j++){
                    Map<String, String> filterMap = filterMapping.get(j);
                    //"SingleColumnValueFilter","FamilyFilter","QualifierFilter",
                    // "ColumnPrefixFilter","MultipleColumnPrefixFilter","MultipleColumnPrefixFilter","RowFilter"
                    String filterType = filterMap.get("FILTER_TYPE");
                    String filterColumn = filterMap.get("FILTER_COLUMN");
                    String filterFamily = filterMap.get("FILTER_FAMILY");
                    //"EQUAL","GREATER","GREATER_OR_EQUAL","LESS","LESS_OR_EQUAL","NO_OP","NOT_EQUAL",
                    String filterOperation = filterMap.get("FILTER_OPERATOR");
                    String filterValue = filterMap.get("FILTER_VALUE");
                    String filterComparatorType = filterMap.get("FILTER_COMPARATOR_TYPE");
                    //"BinaryComparator" ,"RegexStringComparator" ,"SubstringComparator"
                    if("SingleColumnValueFilter".equals(filterType)) {
                        // "filterValue" is column value,like: "1" ,"2" ...
                        // return whole row (all columns) value
                        if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_203);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_207);
    
                        } else if ("RegexStringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_208);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_212);
    
                        } else if("SubstringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_213);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_217);
    
                        }
                    } else if("FamilyFilter".equals(filterType)) {
                        // "Filter Family" is family name ,like: "id_family","name_family"....，
                        // return columns which mapping in "Filter Family",filter other columns
                        if("BinaryComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_218);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_220);
    
                        } else if ("RegexStringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_221);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_223);
    
                        } else if("SubstringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_224);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_226);
    
                        }
                    } else if("QualifierFilter".equals(filterType)) {
                        // "Filter Column" is column name,like:"id" or "name" ....
                        // then you will get meet codition column value ,filter other columns
                        if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_227);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_229);
    
                        }else if ("RegexStringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_230);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_232);
    
                        }else if("SubstringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_233);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_235);
    
                        }
                    } else if("ColumnPrefixFilter".equals(filterType)) {
                        // "Filter Column" value is column name,like:"id" or "name" ....,
                        // return column value,filter other columns
                        if (filterFamily!=null && !"".equals(filterFamily)) {
                            
    stringBuffer.append(TEXT_236);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_237);
    
                        }
                        
    stringBuffer.append(TEXT_238);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_239);
    
                    } else if("MultipleColumnPrefixFilter".equals(filterType)) {
                        // "Filter Column" value is for column name ,like:"id,name" ,"id,name,sex".... ,
                        // return column value,filter other columns
                        if(filterFamily!=null && !"".equals(filterFamily)){
                            
    stringBuffer.append(TEXT_240);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_241);
    
                        }
                        
    stringBuffer.append(TEXT_242);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_245);
    
                    } else if("ColumnRangeFilter".equals(filterType)) {
                        // "Filter Column" value is tow columns name,like: "id,name" ,"id,sex" ....,
                        // return columns value ,filter other columns
                        if (filterFamily!=null && !"".equals(filterFamily)) {
                            
    stringBuffer.append(TEXT_246);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_247);
    
                        }
                        
    stringBuffer.append(TEXT_248);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_250);
    
                    } else if("RowFilter".equals(filterType)) {
                        // "Filter Value" is rowkey value,like "1" ,"car"....,return whole row (all columns)
                        if ("BinaryComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_251);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_253);
    
                        } else if ("RegexStringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_254);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_256);
    
                        } else if("SubstringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_257);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_259);
    
                        }
                    } else if("ValueFilter".equals(filterType)) {
                        // "Filter Value" is any columns value,like "1" ,"car" .... ,
                        // return only the meet codition value,filter other columns
                        if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_260);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_262);
    
                        }else if ("RegexStringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_263);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_265);
    
                        }else if("SubstringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_266);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_268);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_269);
    
                }
            }
            
    stringBuffer.append(TEXT_270);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_273);
    
            // Use a specific callback to generate the appropriate next record.
            nextRecordImplementation.generate();
            
    stringBuffer.append(TEXT_274);
    
            if (dieOnError) {
                
    stringBuffer.append(TEXT_275);
    
            } else {
                
    stringBuffer.append(TEXT_276);
    
            }
            
    stringBuffer.append(TEXT_277);
    
        // Any required helper methods here.
        nextRecordImplementation.generateHelperMethods();
        
    stringBuffer.append(TEXT_278);
    
} else {
    
    
// The name of the main row.
final String mainName = mainConn.getName();
final String rejName = rejConn.getName();
final String mainRecord = codeGenArgument.getRecordStructName(mainConn);
final String recordStruct = mainName + "TemporaryStruct";
final List<IMetadataColumn> mainColumns = mainConn.getMetadataTable().getListColumns();

class NextRecordGenerator {
    /** Generate the implementation for the RecordReader.next() method. */
    public void generate() {
        
    stringBuffer.append(TEXT_279);
    
    }
    public void generateHelperMethods() {
    }
}
NextRecordGenerator nextRecordImplementation = new NextRecordGenerator();

// With both main and reject flows, the object passed to the mapper is not a
// parsed structure, but a Result.  The mapper is responsible for sorting the
// result output into the main or reject flow.


    stringBuffer.append(TEXT_280);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_281);
    

String zookeeperQuorum = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
String zookeeperClientPort = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");


boolean setTableNsMapping = "true".equals(ElementParameterParser.getValue(node, "__SET_TABLE_NS_MAPPING__"));
String tableNsMapping = ElementParameterParser.getValue(node, "__TABLE_NS_MAPPING__");
boolean useTableNsMapping = setTableNsMapping && ((tableNsMapping != null) && (!tableNsMapping.equals("")));


    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(zookeeperQuorum);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(zookeeperClientPort);
    stringBuffer.append(TEXT_286);
    
        if(setZNodeParent) {
            
    stringBuffer.append(TEXT_287);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_288);
    
        }

        if(useTableNsMapping){
            
    stringBuffer.append(TEXT_289);
    stringBuffer.append(tableNsMapping);
    stringBuffer.append(TEXT_290);
    
        }

        for (Map<String,String> param : hbaseParameters) {
            
    stringBuffer.append(TEXT_291);
    stringBuffer.append(param.get("PROPERTY"));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(param.get("VALUE"));
    stringBuffer.append(TEXT_293);
    
        }
        
    stringBuffer.append(TEXT_294);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_295);
    
        
    stringBuffer.append(TEXT_296);
    stringBuffer.append(mapping.size());
    stringBuffer.append(TEXT_297);
    
        for (int i = 0; i < mapping.size(); i++) {
            Map<String, String> map = mapping.get(i);
            IMetadataColumn column = mainColumns.get(i);
            //String schema_column = map.get("SCHEMA_COLUMN");//no use, index is enough
            String family_column= map.get("FAMILY_COLUMN");
            
    stringBuffer.append(TEXT_298);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_302);
    
        }
        
    stringBuffer.append(TEXT_303);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_304);
    
            if (isByFilter && filterMapping.size() > 0) {
                boolean hasMultipleColumnPrefixFilterType = false;
                for (int i=0; i < filterMapping.size(); i++) {
                    Map<String, String> filterMap = filterMapping.get(i);
                    String filterType = filterMap.get("FILTER_TYPE");
                    if("MultipleColumnPrefixFilter".equals(filterType)){
                        hasMultipleColumnPrefixFilterType = true;
                        break;
                    }
                }
                if (hasMultipleColumnPrefixFilterType) {
                    
    stringBuffer.append(TEXT_305);
    
                }
                
    stringBuffer.append(TEXT_306);
    stringBuffer.append(logical);
    stringBuffer.append(TEXT_307);
    
                for (int j=0; j<filterMapping.size(); j++){
                    Map<String, String> filterMap = filterMapping.get(j);
                    //"SingleColumnValueFilter","FamilyFilter","QualifierFilter",
                    // "ColumnPrefixFilter","MultipleColumnPrefixFilter","MultipleColumnPrefixFilter","RowFilter"
                    String filterType = filterMap.get("FILTER_TYPE");
                    String filterColumn = filterMap.get("FILTER_COLUMN");
                    String filterFamily = filterMap.get("FILTER_FAMILY");
                    //"EQUAL","GREATER","GREATER_OR_EQUAL","LESS","LESS_OR_EQUAL","NO_OP","NOT_EQUAL",
                    String filterOperation = filterMap.get("FILTER_OPERATOR");
                    String filterValue = filterMap.get("FILTER_VALUE");
                    String filterComparatorType = filterMap.get("FILTER_COMPARATOR_TYPE");
                    //"BinaryComparator" ,"RegexStringComparator" ,"SubstringComparator"
                    if("SingleColumnValueFilter".equals(filterType)) {
                        // "filterValue" is column value,like: "1" ,"2" ...
                        // return whole row (all columns) value
                        if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_308);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_312);
    
                        } else if ("RegexStringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_313);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_317);
    
                        } else if("SubstringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_318);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_322);
    
                        }
                    } else if("FamilyFilter".equals(filterType)) {
                        // "Filter Family" is family name ,like: "id_family","name_family"....，
                        // return columns which mapping in "Filter Family",filter other columns
                        if("BinaryComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_323);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_325);
    
                        } else if ("RegexStringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_326);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_328);
    
                        } else if("SubstringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_329);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_331);
    
                        }
                    } else if("QualifierFilter".equals(filterType)) {
                        // "Filter Column" is column name,like:"id" or "name" ....
                        // then you will get meet codition column value ,filter other columns
                        if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_332);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_334);
    
                        }else if ("RegexStringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_335);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_337);
    
                        }else if("SubstringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_338);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_340);
    
                        }
                    } else if("ColumnPrefixFilter".equals(filterType)) {
                        // "Filter Column" value is column name,like:"id" or "name" ....,
                        // return column value,filter other columns
                        if (filterFamily!=null && !"".equals(filterFamily)) {
                            
    stringBuffer.append(TEXT_341);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_342);
    
                        }
                        
    stringBuffer.append(TEXT_343);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_344);
    
                    } else if("MultipleColumnPrefixFilter".equals(filterType)) {
                        // "Filter Column" value is for column name ,like:"id,name" ,"id,name,sex".... ,
                        // return column value,filter other columns
                        if(filterFamily!=null && !"".equals(filterFamily)){
                            
    stringBuffer.append(TEXT_345);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_346);
    
                        }
                        
    stringBuffer.append(TEXT_347);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_350);
    
                    } else if("ColumnRangeFilter".equals(filterType)) {
                        // "Filter Column" value is tow columns name,like: "id,name" ,"id,sex" ....,
                        // return columns value ,filter other columns
                        if (filterFamily!=null && !"".equals(filterFamily)) {
                            
    stringBuffer.append(TEXT_351);
    stringBuffer.append(filterFamily);
    stringBuffer.append(TEXT_352);
    
                        }
                        
    stringBuffer.append(TEXT_353);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(filterColumn);
    stringBuffer.append(TEXT_355);
    
                    } else if("RowFilter".equals(filterType)) {
                        // "Filter Value" is rowkey value,like "1" ,"car"....,return whole row (all columns)
                        if ("BinaryComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_356);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_358);
    
                        } else if ("RegexStringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_359);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_361);
    
                        } else if("SubstringComparator".equals(filterComparatorType)) {
                            
    stringBuffer.append(TEXT_362);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_364);
    
                        }
                    } else if("ValueFilter".equals(filterType)) {
                        // "Filter Value" is any columns value,like "1" ,"car" .... ,
                        // return only the meet codition value,filter other columns
                        if("BinaryComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_365);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_367);
    
                        }else if ("RegexStringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_368);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_370);
    
                        }else if("SubstringComparator".equals(filterComparatorType)){
                            
    stringBuffer.append(TEXT_371);
    stringBuffer.append(filterOperation);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(filterValue);
    stringBuffer.append(TEXT_373);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_374);
    
                }
            }
            
    stringBuffer.append(TEXT_375);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_378);
    
            // Use a specific callback to generate the appropriate next record.
            nextRecordImplementation.generate();
            
    stringBuffer.append(TEXT_379);
    
            if (dieOnError) {
                
    stringBuffer.append(TEXT_380);
    
            } else {
                
    stringBuffer.append(TEXT_381);
    
            }
            
    stringBuffer.append(TEXT_382);
    
        // Any required helper methods here.
        nextRecordImplementation.generateHelperMethods();
        
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(mainName);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(mainName);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(rejName);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(rejName);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(mainName);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(mainName);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(rejName);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(rejName);
    stringBuffer.append(TEXT_401);
    
        // Force the creation of the output directory
        for (INode virtualNode : node.getProcess().getGraphicalNodes()) {
            if (virtualNode.getUniqueName().equals(cid)) {
                
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(node.getProcess().getName());
    stringBuffer.append(TEXT_404);
    stringBuffer.append(virtualNode.getUniqueName());
    stringBuffer.append(TEXT_405);
    stringBuffer.append(virtualNode.getOutgoingConnections("REJECT").get(0).getName());
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    
                break;
            }
        }
        
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(recordStruct);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    
            for(int i = 0; i < mapping.size(); i++){
                Map<String, String> map = mapping.get(i);
                String family_column= map.get("FAMILY_COLUMN");
                IMetadataColumn column = mainColumns.get(i);
                String columnName = column.getLabel();
                String defaultValue = column.getDefault();
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                boolean isPrimitiveType = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
                String toAssign = mainName + "." + columnName;
                
    stringBuffer.append(TEXT_416);
    stringBuffer.append(family_column);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_418);
    
                    if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
                    
    stringBuffer.append(TEXT_419);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_420);
    
                    }else if(javaType == JavaTypesManager.BYTE_ARRAY){
                    
    stringBuffer.append(TEXT_421);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_422);
    
                    }else if(javaType == JavaTypesManager.DATE){
                    
    stringBuffer.append(TEXT_423);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_425);
    
                    }else if(isPrimitiveType && javaType == JavaTypesManager.INTEGER){
                    
    stringBuffer.append(TEXT_426);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_427);
    
                    }else if(isPrimitiveType && javaType == JavaTypesManager.CHARACTER){
                    
    stringBuffer.append(TEXT_428);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_429);
    
                    }else if(isPrimitiveType && (javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT || javaType == JavaTypesManager.DOUBLE)) {
                    
    stringBuffer.append(TEXT_430);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(javaType.getNullableClass().getSimpleName());
    stringBuffer.append(TEXT_432);
    
                    }else{
                    
    stringBuffer.append(TEXT_433);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_435);
    
                    }
                    
    stringBuffer.append(TEXT_436);
    
                    String default_Value = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, defaultValue);
                    if (column.isNullable() && default_Value != null && !"null".equals(default_Value)) {
                    
    stringBuffer.append(TEXT_437);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(default_Value);
    stringBuffer.append(TEXT_439);
    
                    } else if (column.isNullable() && !JavaTypesManager.isJavaPrimitiveType(javaType,column.isNullable())) {
                    
    stringBuffer.append(TEXT_440);
    stringBuffer.append(toAssign);
    stringBuffer.append(TEXT_441);
    
                    } else {
                    
    stringBuffer.append(TEXT_442);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(mainName);
    stringBuffer.append(TEXT_444);
    
                    }
                    
    stringBuffer.append(TEXT_445);
    
            }
            
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(mainName);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(rejName);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(rejName);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(rejName);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(rejName);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    
}

    return stringBuffer.toString();
  }
}
