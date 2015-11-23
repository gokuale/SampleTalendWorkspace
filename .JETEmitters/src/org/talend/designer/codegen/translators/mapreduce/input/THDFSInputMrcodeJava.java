package org.talend.designer.codegen.translators.mapreduce.input;

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

public class THDFSInputMrcodeJava
{
  protected static String nl;
  public static synchronized THDFSInputMrcodeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSInputMrcodeJava result = new THDFSInputMrcodeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            {" + NL + "                throw new Exception(\"";
  protected final String TEXT_2 = " must contain at least one Main output connection.\");" + NL + "            }";
  protected final String TEXT_3 = NL + NL + "        public static class ";
  protected final String TEXT_4 = "StructInputFormat extends SequenceFileInputFormat<NullWritable, ";
  protected final String TEXT_5 = "Struct> {" + NL + "" + NL + "            private ContextProperties context;" + NL + "" + NL + "            public InputSplit[] getSplits(JobConf job, int numSplits) throws IOException {" + NL + "                context = new ContextProperties(job);" + NL + "                job.set(\"mapred.input.dir\", ";
  protected final String TEXT_6 = ");" + NL + "                return super.getSplits(job, numSplits);" + NL + "            }" + NL + "" + NL + "            public RecordReader<NullWritable, ";
  protected final String TEXT_7 = "Struct> getRecordReader(" + NL + "                    InputSplit split, JobConf job, Reporter reporter)" + NL + "                    throws IOException {" + NL + "                reporter.setStatus(split.toString());" + NL + "                return new HDFSSequenceFileRecordReader(job, (FileSplit) split);" + NL + "            }" + NL + "" + NL + "            protected static class HDFSSequenceFileRecordReader implements" + NL + "                RecordReader<NullWritable, ";
  protected final String TEXT_8 = "Struct> {" + NL + "" + NL + "                 private SequenceFile.Reader in;" + NL + "                 private long start;" + NL + "                 private long end;" + NL + "                 private boolean more = true;" + NL + "                 protected Configuration conf;" + NL + "" + NL + "                 private ContextProperties context;" + NL + "" + NL + "                protected HDFSSequenceFileRecordReader(JobConf conf, FileSplit split)" + NL + "                        throws IOException {" + NL + "" + NL + "                    this.context = new ContextProperties(conf);" + NL + "" + NL + "                    Path path = split.getPath();" + NL + "                    FileSystem fs = path.getFileSystem(conf);" + NL + "                    this.in = new SequenceFile.Reader(fs, path, conf);" + NL + "                    this.end = split.getStart() + split.getLength();" + NL + "                    this.conf = conf;" + NL + "" + NL + "                    if (split.getStart() > in.getPosition())" + NL + "                          in.sync(split.getStart());//sync to start" + NL + "" + NL + "                    this.start = in.getPosition();" + NL + "                    more = start < end;" + NL + "                 }" + NL + "" + NL + "                public synchronized boolean next(NullWritable key, ";
  protected final String TEXT_9 = "Struct value) throws IOException {";
  protected final String TEXT_10 = NL + "                    try {";
  protected final String TEXT_11 = NL + "                        ";
  protected final String TEXT_12 = " seqKey_";
  protected final String TEXT_13 = " = (";
  protected final String TEXT_14 = ")ReflectionUtils.newInstance(in.getKeyClass(), conf);";
  protected final String TEXT_15 = NL + "                        ";
  protected final String TEXT_16 = " seqValue_";
  protected final String TEXT_17 = " = (";
  protected final String TEXT_18 = ")ReflectionUtils.newInstance(in.getValueClass(), conf);" + NL + "" + NL + "                        if (!more) return false;" + NL + "                        long pos = in.getPosition();" + NL + "                        boolean remaining = in.next(seqKey_";
  protected final String TEXT_19 = ");" + NL + "                        if (remaining) {" + NL + "                          in.getCurrentValue(seqValue_";
  protected final String TEXT_20 = ");" + NL + "                        }" + NL + "                        if (pos >= end && in.syncSeen()) {" + NL + "                          more = false;" + NL + "                        } else {" + NL + "                          more = remaining;" + NL + "                        }" + NL + "" + NL + "                        value.";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = "seqKey_";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = ";" + NL + "                        value.";
  protected final String TEXT_25 = " = ";
  protected final String TEXT_26 = "seqValue_";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = ";" + NL + "                    } catch (java.lang.IllegalArgumentException e) {";
  protected final String TEXT_29 = NL + "                            return false;";
  protected final String TEXT_30 = NL + "                            return next(key, value);";
  protected final String TEXT_31 = NL + "                    }" + NL + "                    return more;" + NL + "                }" + NL + "" + NL + "                public NullWritable createKey() {" + NL + "                    return NullWritable.get();" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_32 = "Struct createValue() {" + NL + "                    return new ";
  protected final String TEXT_33 = "Struct();" + NL + "                }" + NL + "" + NL + "                public long getPos() throws IOException {" + NL + "                    if(in != null) {" + NL + "                         return in.getPosition();" + NL + "                     }" + NL + "                     return -1;" + NL + "                }" + NL + "" + NL + "                public void close() throws IOException {" + NL + "                    if (in != null) {" + NL + "                        in.close();" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                public float getProgress() throws IOException {" + NL + "                    if (start == end) {" + NL + "                        return 0.0f;" + NL + "                    } else {" + NL + "                        return Math" + NL + "                                .min(1.0f, (getPos() - start) / (float) (end - start));" + NL + "                    }" + NL + "                }" + NL + "" + NL + "            }" + NL + "" + NL + "        }" + NL;
  protected final String TEXT_34 = NL + "        public static class ";
  protected final String TEXT_35 = "StructInputFormat extends org.talend.hadoop.mapred.lib.file.TDelimitedFileInputFormat<NullWritable, ";
  protected final String TEXT_36 = "Struct> {";
  protected final String TEXT_37 = NL + "        public static class ";
  protected final String TEXT_38 = "StructInputFormat extends org.talend.hadoop.mapred.lib.file.TExtDelimitedFileInputFormat<NullWritable, ";
  protected final String TEXT_39 = "Struct> {";
  protected final String TEXT_40 = NL + "            private ContextProperties context;" + NL + "" + NL + "            //init" + NL + "            public void setConf(Configuration conf){" + NL + "                context = new ContextProperties(conf);" + NL + "                setInputPath(";
  protected final String TEXT_41 = ");" + NL + "                setSkipLines(";
  protected final String TEXT_42 = ");" + NL + "            }" + NL + "" + NL + "            public RecordReader<NullWritable, ";
  protected final String TEXT_43 = "Struct> getRecordReader(" + NL + "                    InputSplit split, JobConf job, Reporter reporter)" + NL + "                    throws IOException {" + NL + "                if (reporter != null) {" + NL + "                    reporter.setStatus(split.toString());" + NL + "                }" + NL + "\t\t\t\t";
  protected final String TEXT_44 = NL + "                return new HDFSRecordReader(job, (FileSplit) split, ";
  protected final String TEXT_45 = ".getBytes(";
  protected final String TEXT_46 = "));";
  protected final String TEXT_47 = NL + "\t\t\t\treturn new HDFSRecordReader(job, (FileSplit) split, ";
  protected final String TEXT_48 = ".getBytes(";
  protected final String TEXT_49 = "));" + NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\treturn new HDFSRecordReader(job, (FileSplit) split, ";
  protected final String TEXT_51 = ".getBytes());" + NL + "\t\t\t\t";
  protected final String TEXT_52 = NL + "            }" + NL + "" + NL + "            protected static class HDFSRecordReader extends";
  protected final String TEXT_53 = NL + "                org.talend.hadoop.mapred.lib.file.TDelimitedFileRecordReader<NullWritable, ";
  protected final String TEXT_54 = "Struct> {";
  protected final String TEXT_55 = NL + "                org.talend.hadoop.mapred.lib.file.TExtDelimitedFileRecordReader<NullWritable, ";
  protected final String TEXT_56 = "Struct> {";
  protected final String TEXT_57 = NL + "                private ContextProperties context;" + NL + "" + NL + "                protected HDFSRecordReader(JobConf job, FileSplit split, byte[] rowSeparator)" + NL + "                        throws IOException {" + NL + "\t\t\t\t\tsuper(job, split, rowSeparator);" + NL + "                    this.context = new ContextProperties(job);" + NL + "                }" + NL;
  protected final String TEXT_58 = NL + "                protected Text dummyValue = new Text();";
  protected final String TEXT_59 = NL + "\t\t\t\tprotected org.talend.hadoop.mapred.lib.file.ExtendedText dummyValue = " + NL + "\t\t\t\t\tnew org.talend.hadoop.mapred.lib.file.ExtendedText(org.talend.hadoop.mapred.lib.file.TExtDelimitedFileLineReader.DEFAULT_BUFFER_SIZE);";
  protected final String TEXT_60 = NL + NL + "                public boolean next(NullWritable key, ";
  protected final String TEXT_61 = "Struct value) throws IOException {" + NL + "                    if (next(dummyValue)) {" + NL;
  protected final String TEXT_62 = NL + "                        String[] columns = routines.system.StringUtils.splitNotRegex(dummyValue.toString(), ";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "                        String[] columns = routines.system.StringUtils.splitNotRegexWithEncoding(dummyValue.buffer(), ";
  protected final String TEXT_65 = ", ";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "                        String columnValue = \"\";";
  protected final String TEXT_68 = NL + "                        try {";
  protected final String TEXT_69 = NL + "                                if(";
  protected final String TEXT_70 = " < columns.length) {" + NL + "                                    columnValue = columns[";
  protected final String TEXT_71 = "]";
  protected final String TEXT_72 = ";" + NL + "\t\t\t\t\t\t\t\tif(columnValue != null && columnValue.length() > 0){";
  protected final String TEXT_73 = NL + "                                            value.";
  protected final String TEXT_74 = " = columnValue;";
  protected final String TEXT_75 = NL + "                                            value.";
  protected final String TEXT_76 = " = columnValue.getBytes(";
  protected final String TEXT_77 = ");";
  protected final String TEXT_78 = NL + "                                            value.";
  protected final String TEXT_79 = " = BigDataParserUtils.parseTo_Date(columnValue, ";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "                                            value.";
  protected final String TEXT_82 = " = BigDataParserUtils.parseTo_";
  protected final String TEXT_83 = "(BigDataParserUtils.parseTo_Number(columnValue, ";
  protected final String TEXT_84 = ", ";
  protected final String TEXT_85 = "));";
  protected final String TEXT_86 = NL + "                                            value.";
  protected final String TEXT_87 = " = BigDataParserUtils.parseTo_";
  protected final String TEXT_88 = "(columnValue);";
  protected final String TEXT_89 = NL + "                                    } else {";
  protected final String TEXT_90 = NL + "                                            value.";
  protected final String TEXT_91 = " = ";
  protected final String TEXT_92 = ";";
  protected final String TEXT_93 = NL + "                                            throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_94 = "' in '";
  protected final String TEXT_95 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_96 = NL + "                                    }" + NL + "                                } else {";
  protected final String TEXT_97 = NL + "                                        value.";
  protected final String TEXT_98 = " = ";
  protected final String TEXT_99 = ";";
  protected final String TEXT_100 = NL + "                                        throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_101 = "' in '";
  protected final String TEXT_102 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_103 = NL + "                                }";
  protected final String TEXT_104 = NL + "                        } catch (java.lang.IllegalArgumentException  ex_";
  protected final String TEXT_105 = ") {" + NL + "                            LOG.error(ex_";
  protected final String TEXT_106 = ".getMessage());";
  protected final String TEXT_107 = NL + "                                throw new IOException(ex_";
  protected final String TEXT_108 = ".getMessage());";
  protected final String TEXT_109 = NL + "                                return next(key, value);";
  protected final String TEXT_110 = NL + "                        }" + NL + "                        return true;" + NL + "                    }" + NL + "                    return false;" + NL + "                }" + NL + "" + NL + "                public NullWritable createKey() {" + NL + "                    return NullWritable.get();" + NL + "                }" + NL + "" + NL + "                public ";
  protected final String TEXT_111 = "Struct createValue() {" + NL + "                    return new ";
  protected final String TEXT_112 = "Struct();" + NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_113 = NL + NL + "              public static class ";
  protected final String TEXT_114 = "StructInputFormat extends" + NL + "                      org.apache.hadoop.mapred.SequenceFileInputFormat<org.apache.hadoop.io.ObjectWritable, org.apache.hadoop.io.ObjectWritable> {" + NL + "                  private ContextProperties context;" + NL + "" + NL + "                  //init" + NL + "                  public InputSplit[] getSplits(JobConf job, int numSplits)" + NL + "                          throws IOException {" + NL + "                      context = new ContextProperties(job);" + NL + "                      job.set(\"mapred.input.dir\", ";
  protected final String TEXT_115 = ");" + NL + "                      return super.getSplits(job, numSplits);" + NL + "                  }" + NL + "              }" + NL + "" + NL + "              // Map the Text to the structure" + NL + "              public static class ";
  protected final String TEXT_116 = "_InputMapper extends MapReduceBase" + NL + "                      implements Mapper<Writable, Writable, NullWritable, WritableComparable>{" + NL + "                  private ContextProperties context;" + NL + "                  private GlobalVar globalMap;" + NL + "                  public MultipleOutputs mos_";
  protected final String TEXT_117 = ";" + NL + "                  private ";
  protected final String TEXT_118 = "Struct ";
  protected final String TEXT_119 = " = null;" + NL + "                  private ";
  protected final String TEXT_120 = "Struct ";
  protected final String TEXT_121 = " = null;" + NL + "" + NL + "                  public void configure(JobConf job_";
  protected final String TEXT_122 = "){" + NL + "                      context = new ContextProperties(job_";
  protected final String TEXT_123 = ");" + NL + "                      globalMap = new GlobalVar(job_";
  protected final String TEXT_124 = ");" + NL + "                      mos_";
  protected final String TEXT_125 = " = new MultipleOutputs(job_";
  protected final String TEXT_126 = ");" + NL;
  protected final String TEXT_127 = NL + "                      ";
  protected final String TEXT_128 = " = new ";
  protected final String TEXT_129 = "Struct();";
  protected final String TEXT_130 = NL + "                      ";
  protected final String TEXT_131 = " = new ";
  protected final String TEXT_132 = "Struct();" + NL;
  protected final String TEXT_133 = NL + "                              try {" + NL + "                                  FileSystem fs = FileSystem.get(job_";
  protected final String TEXT_134 = ");" + NL + "                                  Path path = new Path(" + NL + "                                          \"/tmp/";
  protected final String TEXT_135 = "\"" + NL + "                                          + \"/tMROutput_";
  protected final String TEXT_136 = "\"" + NL + "                                          + \"/";
  protected final String TEXT_137 = "\");" + NL + "                                  fs.mkdirs(path);" + NL + "                              } catch (IOException ex_";
  protected final String TEXT_138 = ") {" + NL + "                                  throw new RuntimeException(ex_";
  protected final String TEXT_139 = ".getMessage());" + NL + "                              }";
  protected final String TEXT_140 = NL + NL + "                }" + NL + "" + NL + "                  public void map(Writable key_";
  protected final String TEXT_141 = ", Writable value_";
  protected final String TEXT_142 = "," + NL + "                          OutputCollector<NullWritable, WritableComparable> output_";
  protected final String TEXT_143 = ", Reporter reporter_";
  protected final String TEXT_144 = ") throws IOException{";
  protected final String TEXT_145 = NL + "                      try {";
  protected final String TEXT_146 = NL + "                          ";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = " = ";
  protected final String TEXT_149 = " ((";
  protected final String TEXT_150 = ") key_";
  protected final String TEXT_151 = ").";
  protected final String TEXT_152 = ";";
  protected final String TEXT_153 = NL + "                          ";
  protected final String TEXT_154 = ".";
  protected final String TEXT_155 = " = ";
  protected final String TEXT_156 = "((";
  protected final String TEXT_157 = ") value_";
  protected final String TEXT_158 = ").";
  protected final String TEXT_159 = ";" + NL + "                          output_";
  protected final String TEXT_160 = ".collect(NullWritable.get(),  ";
  protected final String TEXT_161 = ");" + NL + "                      } catch (java.lang.Exception ex_";
  protected final String TEXT_162 = ") {";
  protected final String TEXT_163 = NL + "                          ";
  protected final String TEXT_164 = ".invalidInputLine = key_";
  protected final String TEXT_165 = ".toString() +\";\"  +value_";
  protected final String TEXT_166 = ".toString();";
  protected final String TEXT_167 = NL + "                          ";
  protected final String TEXT_168 = ".errorCode = ex_";
  protected final String TEXT_169 = ".toString();" + NL + "                          mos_";
  protected final String TEXT_170 = ".getCollector(\"";
  protected final String TEXT_171 = "\", reporter_";
  protected final String TEXT_172 = ")" + NL + "                                  .collect(NullWritable.get(), ";
  protected final String TEXT_173 = ");" + NL + "                      }" + NL + "                  }" + NL + "" + NL + "                  public void close() throws IOException{" + NL + "                      mos_";
  protected final String TEXT_174 = ".close();" + NL + "                  }" + NL + "              } // end of ";
  protected final String TEXT_175 = "_InputMapper";
  protected final String TEXT_176 = NL + "            public static class ";
  protected final String TEXT_177 = "StructInputFormat extends org.talend.hadoop.mapred.lib.file.TDelimitedFileInputFormat<NullWritable, org.apache.hadoop.io.Text> {";
  protected final String TEXT_178 = NL + "            public static class ";
  protected final String TEXT_179 = "StructInputFormat extends org.talend.hadoop.mapred.lib.file.TExtDelimitedFileInputFormat<NullWritable, org.talend.hadoop.mapred.lib.file.ExtendedText> {";
  protected final String TEXT_180 = NL + NL + "            // read the input format line by line" + NL + "" + NL + "                private ContextProperties context;" + NL + "" + NL + "                //init" + NL + "                public void setConf(Configuration conf){" + NL + "                    context = new ContextProperties(conf);" + NL + "                    setInputPath(";
  protected final String TEXT_181 = ");" + NL + "                    setSkipLines(";
  protected final String TEXT_182 = ");" + NL + "                }" + NL;
  protected final String TEXT_183 = NL + "                public RecordReader<NullWritable, org.apache.hadoop.io.Text> getRecordReader(";
  protected final String TEXT_184 = NL + "                public RecordReader<NullWritable, org.talend.hadoop.mapred.lib.file.ExtendedText> getRecordReader(";
  protected final String TEXT_185 = NL + "                        InputSplit split, JobConf job, Reporter reporter)" + NL + "                        throws IOException {" + NL + "                    if (reporter != null) {" + NL + "                        reporter.setStatus(split.toString());" + NL + "                    }";
  protected final String TEXT_186 = NL + "                      return new HDFSRecordReader(job, (FileSplit) split, ";
  protected final String TEXT_187 = ".getBytes(";
  protected final String TEXT_188 = "));";
  protected final String TEXT_189 = NL + "                      return new HDFSRecordReader(job, (FileSplit) split, ";
  protected final String TEXT_190 = ".getBytes());";
  protected final String TEXT_191 = NL + "                }" + NL + "" + NL + "                protected static class HDFSRecordReader extends";
  protected final String TEXT_192 = NL + "                    org.talend.hadoop.mapred.lib.file.TDelimitedFileRecordReader<NullWritable, org.apache.hadoop.io.Text> {";
  protected final String TEXT_193 = NL + "                    org.talend.hadoop.mapred.lib.file.TExtDelimitedFileRecordReader<NullWritable, org.talend.hadoop.mapred.lib.file.ExtendedText> {";
  protected final String TEXT_194 = NL + NL + "                    private ContextProperties context;" + NL + "" + NL + "                    protected HDFSRecordReader(JobConf job, FileSplit split, byte[] rowSeparator)" + NL + "                            throws IOException {" + NL + "                        super(job, split, rowSeparator);" + NL + "                        this.context = new ContextProperties(job);" + NL + "                    }";
  protected final String TEXT_195 = NL + "                    public boolean next(NullWritable key, org.apache.hadoop.io.Text value) throws IOException {";
  protected final String TEXT_196 = NL + "                    public boolean next(NullWritable key, org.talend.hadoop.mapred.lib.file.ExtendedText value) throws IOException {";
  protected final String TEXT_197 = NL + "                        return super.next(value);" + NL + "                    }" + NL + "" + NL + "                    public NullWritable createKey() {" + NL + "                        return NullWritable.get();" + NL + "                    }" + NL;
  protected final String TEXT_198 = NL + "                    public org.apache.hadoop.io.Text createValue() {" + NL + "                        return new org.apache.hadoop.io.Text();" + NL + "                    }";
  protected final String TEXT_199 = NL + "                    public org.talend.hadoop.mapred.lib.file.ExtendedText createValue() {" + NL + "                        return new org.talend.hadoop.mapred.lib.file.ExtendedText(org.talend.hadoop.mapred.lib.file.TExtDelimitedFileLineReader.DEFAULT_BUFFER_SIZE);" + NL + "                    }";
  protected final String TEXT_200 = NL + "                }" + NL + "            }" + NL + "" + NL + "" + NL + "            // Map the Text to the structure" + NL + "            public static class ";
  protected final String TEXT_201 = "_InputMapper extends MapReduceBase";
  protected final String TEXT_202 = NL + "            implements Mapper<NullWritable, org.apache.hadoop.io.Text, NullWritable, WritableComparable>{";
  protected final String TEXT_203 = NL + "            implements Mapper<NullWritable, org.talend.hadoop.mapred.lib.file.ExtendedText, NullWritable, WritableComparable>{";
  protected final String TEXT_204 = NL + "                private ContextProperties context;" + NL + "                private GlobalVar globalMap;" + NL + "                public MultipleOutputs mos_";
  protected final String TEXT_205 = ";" + NL + "                private ";
  protected final String TEXT_206 = "Struct ";
  protected final String TEXT_207 = " = null;" + NL + "                private ";
  protected final String TEXT_208 = "Struct ";
  protected final String TEXT_209 = " = null;" + NL + "" + NL + "" + NL + "                public void configure(JobConf job_";
  protected final String TEXT_210 = "){" + NL + "                    context = new ContextProperties(job_";
  protected final String TEXT_211 = ");" + NL + "                    globalMap = new GlobalVar(job_";
  protected final String TEXT_212 = ");" + NL + "                    mos_";
  protected final String TEXT_213 = " = new MultipleOutputs(job_";
  protected final String TEXT_214 = ");" + NL;
  protected final String TEXT_215 = NL + "                    ";
  protected final String TEXT_216 = " = new ";
  protected final String TEXT_217 = "Struct();";
  protected final String TEXT_218 = NL + "                    ";
  protected final String TEXT_219 = " = new ";
  protected final String TEXT_220 = "Struct();" + NL;
  protected final String TEXT_221 = NL + "                            try {" + NL + "                                FileSystem fs = FileSystem.get(job_";
  protected final String TEXT_222 = ");" + NL + "                                Path path = new Path(" + NL + "                                        \"/tmp/";
  protected final String TEXT_223 = "\"" + NL + "                                        + \"/tMROutput_";
  protected final String TEXT_224 = "\"" + NL + "                                        + \"/";
  protected final String TEXT_225 = "\");" + NL + "                                fs.mkdirs(path);" + NL + "                            } catch (IOException ex_";
  protected final String TEXT_226 = ") {" + NL + "                                throw new RuntimeException(ex_";
  protected final String TEXT_227 = ".getMessage());" + NL + "                            }";
  protected final String TEXT_228 = NL + "                }" + NL;
  protected final String TEXT_229 = NL + "                public void map(NullWritable key_";
  protected final String TEXT_230 = ", org.apache.hadoop.io.Text value_";
  protected final String TEXT_231 = ",";
  protected final String TEXT_232 = NL + "                public void map(NullWritable key_";
  protected final String TEXT_233 = ", org.talend.hadoop.mapred.lib.file.ExtendedText value_";
  protected final String TEXT_234 = ",";
  protected final String TEXT_235 = NL + "                    OutputCollector<NullWritable, WritableComparable> output_";
  protected final String TEXT_236 = ", Reporter reporter_";
  protected final String TEXT_237 = ") throws IOException{";
  protected final String TEXT_238 = NL + "                    String[] columns = routines.system.StringUtils.splitNotRegex(value_";
  protected final String TEXT_239 = ".toString(), ";
  protected final String TEXT_240 = ");";
  protected final String TEXT_241 = NL + "                    String[] columns = routines.system.StringUtils.splitNotRegexWithEncoding(value_";
  protected final String TEXT_242 = ".buffer(), ";
  protected final String TEXT_243 = ", ";
  protected final String TEXT_244 = ");";
  protected final String TEXT_245 = NL + "                    String columnValue = \"\";" + NL + NL;
  protected final String TEXT_246 = NL + "                    try {";
  protected final String TEXT_247 = NL + "                            if(";
  protected final String TEXT_248 = " < columns.length) {" + NL + "                              columnValue = columns[";
  protected final String TEXT_249 = "]";
  protected final String TEXT_250 = ";" + NL + "                              if(columnValue.length() > 0){";
  protected final String TEXT_251 = NL + "                                      ";
  protected final String TEXT_252 = ".";
  protected final String TEXT_253 = " = columnValue;";
  protected final String TEXT_254 = NL + "                                      ";
  protected final String TEXT_255 = ".";
  protected final String TEXT_256 = " = columnValue.getBytes(";
  protected final String TEXT_257 = ");";
  protected final String TEXT_258 = NL + "                                      ";
  protected final String TEXT_259 = ".";
  protected final String TEXT_260 = " = BigDataParserUtils.parseTo_Date(columnValue, ";
  protected final String TEXT_261 = ");";
  protected final String TEXT_262 = NL + "                                      ";
  protected final String TEXT_263 = ".";
  protected final String TEXT_264 = " = BigDataParserUtils.parseTo_";
  protected final String TEXT_265 = "(BigDataParserUtils.parseTo_Number(columnValue, ";
  protected final String TEXT_266 = ", ";
  protected final String TEXT_267 = "));";
  protected final String TEXT_268 = NL + "                                      ";
  protected final String TEXT_269 = ".";
  protected final String TEXT_270 = " = BigDataParserUtils.parseTo_";
  protected final String TEXT_271 = "(columnValue);";
  protected final String TEXT_272 = NL + "                              } else {";
  protected final String TEXT_273 = NL + "                                      ";
  protected final String TEXT_274 = ".";
  protected final String TEXT_275 = " = ";
  protected final String TEXT_276 = ";";
  protected final String TEXT_277 = NL + "                                      throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_278 = "' in '";
  protected final String TEXT_279 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_280 = NL + "                              }" + NL + "                          } else {";
  protected final String TEXT_281 = NL + "                                    ";
  protected final String TEXT_282 = ".";
  protected final String TEXT_283 = " = ";
  protected final String TEXT_284 = ";";
  protected final String TEXT_285 = NL + "                                    throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_286 = "' in '";
  protected final String TEXT_287 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_288 = NL + "                          }";
  protected final String TEXT_289 = NL + "                        output_";
  protected final String TEXT_290 = ".collect(NullWritable.get(),  ";
  protected final String TEXT_291 = ");" + NL + "                    } catch (java.lang.Exception ex_";
  protected final String TEXT_292 = ") {";
  protected final String TEXT_293 = NL + "                        ";
  protected final String TEXT_294 = ".invalidInputLine = value_";
  protected final String TEXT_295 = ".toString();";
  protected final String TEXT_296 = NL + "                        ";
  protected final String TEXT_297 = ".errorCode = ex_";
  protected final String TEXT_298 = ".toString();" + NL + "                        mos_";
  protected final String TEXT_299 = ".getCollector(\"";
  protected final String TEXT_300 = "\", reporter_";
  protected final String TEXT_301 = ")" + NL + "                                .collect(NullWritable.get(), ";
  protected final String TEXT_302 = ");" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                public void close() throws IOException{" + NL + "                    mos_";
  protected final String TEXT_303 = ".close();" + NL + "                }" + NL + "            } // end of ";
  protected final String TEXT_304 = "_InputMapper" + NL;
  protected final String TEXT_305 = NL + NL;

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
        String folder = ElementParameterParser.getValue(node,"__FILENAME__");
        String fieldSeparator = ElementParameterParser.getValue(node,"__FIELDSEPARATOR__");
        String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");
        boolean customEncoding = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM_ENCODING__"));
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
        String skipLines = ElementParameterParser.getValue(node,"__HEADER__");

        String typeFile = ElementParameterParser.getValue(node,"__TYPEFILE__");
        boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

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
        int nbColumns = columns.size();

        if ("SEQUENCE".equals(typeFile)) {
        
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_9);
    
                    String keyColumn = ElementParameterParser.getValue(node,"__KEYCOLUMN__");
                    String valueColumn = ElementParameterParser.getValue(node,"__VALUECOLUMN__");

                    String talendKeyClass = "";
                    String talendValueClass = "";

                    for ( int i = 0; i < nbColumns; i++ ){
                        IMetadataColumn column = columns.get(i);
                        if (column.getLabel().equals(keyColumn)) {
                            talendKeyClass = column.getTalendType();
                        }
                        if (column.getLabel().equals(valueColumn)) {
                            talendValueClass = column.getTalendType();
                        }
                    }

                    String keyClass="org.apache.hadoop.io.Text";
                    if (talendKeyClass.equals("id_Boolean")) keyClass="org.apache.hadoop.io.BooleanWritable";
                    if (talendKeyClass.equals("id_Byte")) keyClass="org.apache.hadoop.io.ByteWritable";
                    if (talendKeyClass.equals("id_byte[]")) keyClass="org.apache.hadoop.io.BytesWritable";
                    if (talendKeyClass.equals("id_Double")) keyClass="org.apache.hadoop.io.DoubleWritable";
                    if (talendKeyClass.equals("id_Float")) keyClass="org.apache.hadoop.io.FloatWritable";
                    if (talendKeyClass.equals("id_Integer")) keyClass="org.apache.hadoop.io.IntWritable";
                    if (talendKeyClass.equals("id_Long")) keyClass="org.apache.hadoop.io.LongWritable";
                    if (talendKeyClass.equals("id_Short")) keyClass="org.apache.hadoop.io.IntWritable";
                    if (talendKeyClass.equals("id_String")) keyClass="org.apache.hadoop.io.Text";

                    String valueClass="org.apache.hadoop.io.Text";
                    if (talendValueClass.equals("id_Boolean")) valueClass="org.apache.hadoop.io.BooleanWritable";
                    if (talendValueClass.equals("id_Byte")) valueClass="org.apache.hadoop.io.ByteWritable";
                    if (talendValueClass.equals("id_byte[]")) valueClass="org.apache.hadoop.io.BytesWritable";
                    if (talendValueClass.equals("id_Double")) valueClass="org.apache.hadoop.io.DoubleWritable";
                    if (talendValueClass.equals("id_Float")) valueClass="org.apache.hadoop.io.FloatWritable";
                    if (talendValueClass.equals("id_Integer")) valueClass="org.apache.hadoop.io.IntWritable";
                    if (talendValueClass.equals("id_Long")) valueClass="org.apache.hadoop.io.LongWritable";
                    if (talendValueClass.equals("id_Short")) valueClass="org.apache.hadoop.io.IntWritable";
                    if (talendValueClass.equals("id_String")) valueClass="org.apache.hadoop.io.Text";
                    
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(keyClass);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(keyClass);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(valueClass);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(valueClass);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(keyColumn );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(talendKeyClass.equals("id_Short")?"(short)":"");
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(((keyClass.equals("org.apache.hadoop.io.Text"))?"toString()":"get()") );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(valueColumn );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(talendValueClass.equals("id_Short")?"(short)":"");
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(((valueClass.equals("org.apache.hadoop.io.Text"))?"toString()":"get()") );
    stringBuffer.append(TEXT_28);
    
                        if (dieOnError) {
                            
    stringBuffer.append(TEXT_29);
    
                        } else {
                            
    stringBuffer.append(TEXT_30);
    
                        }
                        
    stringBuffer.append(TEXT_31);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_33);
    
            // Warning: this return will stop the processing of this javajet.
            return stringBuffer.toString();
        }

        boolean useDefaultDecoder = ElementParameterParser.getValue(node, "__FALLBACK_RECORD_READER__").equals("false");

        if(useDefaultDecoder) {
        
    stringBuffer.append(TEXT_34);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_36);
     } else { 
    stringBuffer.append(TEXT_37);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_39);
     } 
    stringBuffer.append(TEXT_40);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(skipLines);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_43);
     if(useDefaultDecoder) { 
    stringBuffer.append(TEXT_44);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_46);
     } else if(customEncoding) { 
    stringBuffer.append(TEXT_47);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_49);
     } else { 
    stringBuffer.append(TEXT_50);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_51);
     } 
    stringBuffer.append(TEXT_52);
     if(useDefaultDecoder) { 
    stringBuffer.append(TEXT_53);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_54);
     } else { 
    stringBuffer.append(TEXT_55);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_56);
     } 
    stringBuffer.append(TEXT_57);
     if(useDefaultDecoder) { 
    stringBuffer.append(TEXT_58);
     } else { 
    stringBuffer.append(TEXT_59);
     } 
    stringBuffer.append(TEXT_60);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_61);
     if(useDefaultDecoder) { 
    stringBuffer.append(TEXT_62);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_63);
     } else { 
    stringBuffer.append(TEXT_64);
    stringBuffer.append( customEncoding? encoding : null);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_66);
     } 
    stringBuffer.append(TEXT_67);
    
                        List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
                        String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
                        boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;

                        String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
                        boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
                        String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
                        String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

                        
    stringBuffer.append(TEXT_68);
    
                            for ( int i = 0; i < nbColumns; i++ ){
                                IMetadataColumn column = columns.get(i);
                                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                                String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                                String columnName = column.getLabel();
                                String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
                                
    stringBuffer.append(TEXT_69);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_71);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_72);
    
                                        if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
                                            
    stringBuffer.append(TEXT_73);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_74);
    
                                        } else if(javaType == JavaTypesManager.BYTE_ARRAY){
                                            
    stringBuffer.append(TEXT_75);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_77);
    
                                        } else if (javaType == JavaTypesManager.DATE) {
                                            
    stringBuffer.append(TEXT_78);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_80);
    
                                        } else if (advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) {
                                            
    stringBuffer.append(TEXT_81);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_83);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_84);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_85);
    
                                        } else {
                                            
    stringBuffer.append(TEXT_86);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_88);
    
                                        }
                                        
    stringBuffer.append(TEXT_89);
    
                                        if(defaultValue != null && defaultValue.length() > 0) {
                                            
    stringBuffer.append(TEXT_90);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_92);
    
                                        } else {
                                            
    stringBuffer.append(TEXT_93);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_95);
    
                                        }
                                        
    stringBuffer.append(TEXT_96);
    
                                    if(defaultValue != null && defaultValue.length() > 0) {
                                        
    stringBuffer.append(TEXT_97);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_99);
    
                                    } else {
                                        
    stringBuffer.append(TEXT_100);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_102);
    
                                    }
                                    
    stringBuffer.append(TEXT_103);
    
                            }
                            
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
                            if (dieOnError) {
                                
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
                            } else {
                                
    stringBuffer.append(TEXT_109);
    
                            }
                            
    stringBuffer.append(TEXT_110);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_112);
    
    }

    
        } else if ((rejectedConnections != null)  && (rejectedConnections.size() == 1)){
            
    
    List< ? extends IConnection> mainConnections = node.getOutgoingConnections("FLOW");
    IConnection mainConnection = mainConnections.get(0);
    String mainConnectionName = mainConnection.getName();
    IConnection rejectedConnection = rejectedConnections.get(0);
    String rejectedConnectionName = rejectedConnection.getName();

    if (mainConnection.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        List<IMetadataColumn> columns = metadata.getListColumns();
        int nbColumns = columns.size();


          if ("SEQUENCE".equals(typeFile)) {
              
    stringBuffer.append(TEXT_113);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_132);
    
                      // Force the creation of the output directory
                      for (INode virtualNode : node.getProcess().getGraphicalNodes()) {
                          if (virtualNode.getUniqueName().equals(cid)) {
                              
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(node.getProcess().getName());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(virtualNode.getUniqueName());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(virtualNode.getOutgoingConnections("REJECT").get(0).getName());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    
                              break;
                          }
                      }
                      
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
                      String keyColumn = ElementParameterParser.getValue(node,"__KEYCOLUMN__");
                      String valueColumn = ElementParameterParser.getValue(node,"__VALUECOLUMN__");

                      String talendKeyClass = "";
                      String talendValueClass = "";

                      for ( int i = 0; i < nbColumns; i++ ){
                          IMetadataColumn column = columns.get(i);
                          if (column.getLabel().equals(keyColumn)) {
                              talendKeyClass = column.getTalendType();
                          }
                          if (column.getLabel().equals(valueColumn)) {
                              talendValueClass = column.getTalendType();
                          }
                      }
                      String keyClass="org.apache.hadoop.io.Text";
                      if (talendKeyClass.equals("id_Boolean")) keyClass="org.apache.hadoop.io.BooleanWritable";
                      if (talendKeyClass.equals("id_Byte")) keyClass="org.apache.hadoop.io.ByteWritable";
                      if (talendKeyClass.equals("id_byte[]")) keyClass="org.apache.hadoop.io.BytesWritable";
                      if (talendKeyClass.equals("id_Double")) keyClass="org.apache.hadoop.io.DoubleWritable";
                      if (talendKeyClass.equals("id_Float")) keyClass="org.apache.hadoop.io.FloatWritable";
                      if (talendKeyClass.equals("id_Integer")) keyClass="org.apache.hadoop.io.IntWritable";
                      if (talendKeyClass.equals("id_Long")) keyClass="org.apache.hadoop.io.LongWritable";
                      if (talendKeyClass.equals("id_Short")) keyClass="org.apache.hadoop.io.IntWritable";
                      if (talendKeyClass.equals("id_String")) keyClass="org.apache.hadoop.io.Text";

                      String valueClass="org.apache.hadoop.io.Text";
                      if (talendValueClass.equals("id_Boolean")) valueClass="org.apache.hadoop.io.BooleanWritable";
                      if (talendValueClass.equals("id_Byte")) valueClass="org.apache.hadoop.io.ByteWritable";
                      if (talendValueClass.equals("id_byte[]")) valueClass="org.apache.hadoop.io.BytesWritable";
                      if (talendValueClass.equals("id_Double")) valueClass="org.apache.hadoop.io.DoubleWritable";
                      if (talendValueClass.equals("id_Float")) valueClass="org.apache.hadoop.io.FloatWritable";
                      if (talendValueClass.equals("id_Integer")) valueClass="org.apache.hadoop.io.IntWritable";
                      if (talendValueClass.equals("id_Long")) valueClass="org.apache.hadoop.io.LongWritable";
                      if (talendValueClass.equals("id_Short")) valueClass="org.apache.hadoop.io.IntWritable";
                      if (talendValueClass.equals("id_String")) valueClass="org.apache.hadoop.io.Text";
                      
    stringBuffer.append(TEXT_145);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(keyColumn );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(talendKeyClass.equals("id_Short")?"(short)":"");
    stringBuffer.append(TEXT_149);
    stringBuffer.append(keyClass);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(((keyClass.equals("org.apache.hadoop.io.Text"))?"toString()":"get()") );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(valueColumn );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(talendValueClass.equals("id_Short")?"(short)":"");
    stringBuffer.append(TEXT_156);
    stringBuffer.append(valueClass);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(((valueClass.equals("org.apache.hadoop.io.Text"))?"toString()":"get()") );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    
              // END OF SEQUENCE FILE PART
          } else {
              // TEXT FILE PART

            boolean useDefaultDecoder = ElementParameterParser.getValue(node, "__FALLBACK_RECORD_READER__").equals("false");


            if(useDefaultDecoder) { 
    stringBuffer.append(TEXT_176);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_177);
     } else { 
    stringBuffer.append(TEXT_178);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_179);
     } 
    stringBuffer.append(TEXT_180);
    stringBuffer.append(folder);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(skipLines);
    stringBuffer.append(TEXT_182);
     if(useDefaultDecoder) { 
    stringBuffer.append(TEXT_183);
     } else { 
    stringBuffer.append(TEXT_184);
     } 
    stringBuffer.append(TEXT_185);
     if(customEncoding) { 
    stringBuffer.append(TEXT_186);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_188);
     } else { 
    stringBuffer.append(TEXT_189);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_190);
     } 
    stringBuffer.append(TEXT_191);
     if(useDefaultDecoder) { 
    stringBuffer.append(TEXT_192);
     } else { 
    stringBuffer.append(TEXT_193);
     } 
    stringBuffer.append(TEXT_194);
     if(useDefaultDecoder) { 
    stringBuffer.append(TEXT_195);
     } else { 
    stringBuffer.append(TEXT_196);
     } 
    stringBuffer.append(TEXT_197);
     if(useDefaultDecoder) { 
    stringBuffer.append(TEXT_198);
     } else { 
    stringBuffer.append(TEXT_199);
     } 
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
     if(useDefaultDecoder) { 
    stringBuffer.append(TEXT_202);
     } else { 
    stringBuffer.append(TEXT_203);
     } 
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_220);
    
                    // Force the creation of the output directory
                    for (INode virtualNode : node.getProcess().getGraphicalNodes()) {
                        if (virtualNode.getUniqueName().equals(cid)) {
                            
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(node.getProcess().getName());
    stringBuffer.append(TEXT_223);
    stringBuffer.append(virtualNode.getUniqueName());
    stringBuffer.append(TEXT_224);
    stringBuffer.append(virtualNode.getOutgoingConnections("REJECT").get(0).getName());
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    
                            break;
                        }
                    }
                    
    stringBuffer.append(TEXT_228);
     if(useDefaultDecoder) { 
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
     } else { 
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
     } 
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
     if(useDefaultDecoder) { 
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_240);
     } else { 
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append( customEncoding? encoding : null);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_244);
     } 
    stringBuffer.append(TEXT_245);
    
                    List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
                    String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
                    boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;

                    String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
                    boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
                    String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
                    String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

                    
    stringBuffer.append(TEXT_246);
    
                        for ( int i = 0; i < nbColumns; i++ ){
                            IMetadataColumn column = columns.get(i);
                            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                            String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                            String columnName = column.getLabel();
                            String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
                            
    stringBuffer.append(TEXT_247);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_249);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_250);
    
                                  if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
                                      
    stringBuffer.append(TEXT_251);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_253);
    
                                  } else if(javaType == JavaTypesManager.BYTE_ARRAY){
                                      
    stringBuffer.append(TEXT_254);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(customEncoding?encoding:"" );
    stringBuffer.append(TEXT_257);
    
                                  } else if (javaType == JavaTypesManager.DATE) {
                                      
    stringBuffer.append(TEXT_258);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_261);
    
                                  } else if (advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) {
                                      
    stringBuffer.append(TEXT_262);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_265);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_266);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_267);
    
                                  } else {
                                      
    stringBuffer.append(TEXT_268);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_270);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_271);
    
                                  }
                                  
    stringBuffer.append(TEXT_272);
    
                                  if(defaultValue != null && defaultValue.length() > 0) {
                                      
    stringBuffer.append(TEXT_273);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_276);
    
                                  } else {
                                      
    stringBuffer.append(TEXT_277);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_279);
    
                                  }
                                  
    stringBuffer.append(TEXT_280);
    
                                if(defaultValue != null && defaultValue.length() > 0) {
                                    
    stringBuffer.append(TEXT_281);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_284);
    
                                } else {
                                    
    stringBuffer.append(TEXT_285);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_287);
    
                                }
                                
    stringBuffer.append(TEXT_288);
    
                        }
                        
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(mainConnectionName);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(rejectedConnectionName);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    
          } // END OF TEXT FILE PART
    }

    stringBuffer.append(TEXT_305);
    
        }
    }
}

    return stringBuffer.toString();
  }
}
