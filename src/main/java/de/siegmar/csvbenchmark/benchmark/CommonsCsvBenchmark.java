package de.siegmar.csvbenchmark.benchmark;

import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
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

@Fork(value = 1, warmups = 1)
@Warmup(iterations = 10)
@BenchmarkMode(Mode.Throughput)
public class CommonsCsvBenchmark {

    @State(Scope.Benchmark)
    public static class WriteState {

        CSVPrinter csvPrinter;

        @Setup
        public void setup() throws IOException {
            final CSVFormat format = CSVFormat.DEFAULT
                .withRecordSeparator('\n');

            csvPrinter = new CSVPrinter(new NullWriter(), format);
        }

        @TearDown
        public void teardown() throws IOException {
            csvPrinter.close();
        }

    }

    @Benchmark
    public void write(final WriteState state) throws IOException {
        state.csvPrinter.printRecord((Object[]) Constant.row);
    }

    @State(Scope.Benchmark)
    public static class ReadState {

        private CSVParser csvParser;
        Iterator<CSVRecord> csvIterator;

        @Setup
        public void setup() throws IOException {
            final CSVFormat format = CSVFormat.DEFAULT
                .withRecordSeparator('\n');

            csvParser = new CSVParser(new InfiniteDataReader(Constant.data), format);
            csvIterator = csvParser.iterator();
        }

        @TearDown
        public void teardown() throws IOException {
            csvParser.close();
        }

    }

    @Benchmark
    public void read(final ReadState state) {
        state.csvIterator.next();
    }

}
