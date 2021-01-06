package univocity;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.infra.Blackhole;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvWriter;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.NullWriter;

public class UnivocityBenchmark {

    @State(Scope.Benchmark)
    public static class WriteState {

        private CsvWriter writer;

        @Setup
        public void setup(final Blackhole bh) {
            writer = Factory.writer(new NullWriter(bh));
        }

        @TearDown
        public void teardown() {
            writer.close();
        }

    }

    @Benchmark
    public void write(final WriteState state) {
        state.writer.writeRow(Constant.ROW);
    }

    @State(Scope.Benchmark)
    public static class ReadState {

        private CsvParser parser;

        @Setup
        public void setup() {
            parser = Factory.reader();
        }

    }

    @Benchmark
    public String[] read(final ReadState state) {
        return state.parser.parseNext();
    }

}
