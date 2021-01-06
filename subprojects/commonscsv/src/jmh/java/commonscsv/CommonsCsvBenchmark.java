package commonscsv;

import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.infra.Blackhole;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.NullWriter;

public class CommonsCsvBenchmark {

    @State(Scope.Benchmark)
    public static class WriteState {

        private CSVPrinter csvPrinter;

        @Setup
        public void setup(final Blackhole bh) throws IOException {
            this.csvPrinter = Factory.writer(new NullWriter(bh));
        }

        @TearDown
        public void teardown() throws IOException {
            csvPrinter.close();
        }

    }

    @Benchmark
    public void write(final WriteState state) throws IOException {
        state.csvPrinter.printRecord((Object[]) Constant.ROW);
    }

    @State(Scope.Benchmark)
    public static class ReadState {

        private Iterator<CSVRecord> csvIterator;
        private CSVParser csvParser;

        @Setup
        public void setup() throws IOException {
            csvParser = Factory.reader();
            csvIterator = csvParser.iterator();
        }

        @TearDown
        public void teardown() throws IOException {
            csvParser.close();
        }

    }

    @Benchmark
    public CSVRecord read(final ReadState state) {
        return state.csvIterator.next();
    }

}
