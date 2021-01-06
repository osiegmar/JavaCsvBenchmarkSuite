package supercsv;

import java.io.IOException;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.infra.Blackhole;
import org.supercsv.io.CsvListReader;
import org.supercsv.io.CsvListWriter;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.NullWriter;

public class SuperCsvBenchmark {

    @State(Scope.Benchmark)
    public static class WriteState {

        private CsvListWriter csvWriter;

        @Setup
        public void setup(final Blackhole bh) {
            csvWriter = Factory.writer(new NullWriter(bh));
        }

        @TearDown
        public void teardown() throws IOException {
            csvWriter.close();
        }

    }

    @Benchmark
    public void write(final WriteState state) throws IOException {
        state.csvWriter.write(Constant.ROW);
    }

    @State(Scope.Benchmark)
    public static class ReadState {

        private CsvListReader csvReader;

        @Setup
        public void setup() {
            csvReader = Factory.reader();
        }

        @TearDown
        public void teardown() throws IOException {
            csvReader.close();
        }

    }

    @Benchmark
    public List<String> read(final ReadState state) throws IOException {
        return state.csvReader.read();
    }

}
