package de.siegmar.csvbenchmark.benchmark;

import java.io.IOException;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;
import de.siegmar.csvbenchmark.util.NullWriter;
import de.siegmar.fastcsv.reader.CsvParser;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.writer.CsvAppender;
import de.siegmar.fastcsv.writer.CsvWriter;

@Fork(value = 1, warmups = 1)
@Warmup(iterations = 10)
@BenchmarkMode(Mode.Throughput)
public class FastCsvBenchmark {

    @State(Scope.Benchmark)
    public static class WriteState {

        CsvAppender append;

        @Setup
        public void setup() {
            final CsvWriter csvWriter = new CsvWriter();
            csvWriter.setFieldSeparator(Constant.SEPARATOR);
            csvWriter.setLineDelimiter(Constant.LINE_DELIMITER);
            csvWriter.setTextDelimiter(Constant.DELIMITER);

            append = csvWriter.append(new NullWriter());
        }

        @TearDown
        public void teardown() throws IOException {
            append.close();
        }

    }

    @Benchmark
    public void write(final WriteState state) throws IOException {
        state.append.appendLine(Constant.row);
    }

    @State(Scope.Benchmark)
    public static class ReadState {

        CsvParser csvParser;

        @Setup
        public void setup() throws IOException {
            final CsvReader csvReader = new CsvReader();
            csvReader.setFieldSeparator(Constant.SEPARATOR);
            csvReader.setTextDelimiter(Constant.DELIMITER);

            csvParser = csvReader.parse(new InfiniteDataReader(Constant.data));
        }

        @TearDown
        public void teardown() throws IOException {
            csvParser.close();
        }

    }

    @Benchmark
    public void read(final ReadState state) throws IOException {
        state.csvParser.nextRow();
    }

}
