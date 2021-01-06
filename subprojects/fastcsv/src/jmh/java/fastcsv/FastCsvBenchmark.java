package fastcsv;

import java.io.IOException;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.infra.Blackhole;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.NullWriter;
import de.siegmar.fastcsv.reader.CloseableIterator;
import de.siegmar.fastcsv.reader.CsvRow;
import de.siegmar.fastcsv.writer.CsvWriter;

public class FastCsvBenchmark {

    @State(Scope.Benchmark)
    public static class WriteState {

        private CsvWriter writer;

        @Setup
        public void setup(final Blackhole bh) {
            this.writer = Factory.writer(new NullWriter(bh));
        }

        @TearDown
        public void teardown() throws IOException {
            writer.close();
        }

    }

    @Benchmark
    public void write(final WriteState state) {
        state.writer.writeRow(Constant.ROW);
    }

    @State(Scope.Benchmark)
    public static class ReadState {

        private CloseableIterator<CsvRow> it;

        @Setup
        public void setup() {
            it = Factory.reader().iterator();
        }

        @TearDown
        public void teardown() throws IOException {
            it.close();
        }

    }

    @Benchmark
    public CsvRow read(final ReadState state) {
        return state.it.next();
    }

}
