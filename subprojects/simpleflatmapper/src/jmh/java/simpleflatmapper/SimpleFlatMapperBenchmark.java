package simpleflatmapper;

import java.io.IOException;
import java.util.Iterator;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.simpleflatmapper.lightningcsv.CsvWriter;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.NullWriter;

public class SimpleFlatMapperBenchmark {

    @State(Scope.Benchmark)
    public static class WriteState {

        CsvWriter csvWriter;

        @Setup
        public void setup(final Blackhole bh) {
            csvWriter = Factory.writer(new NullWriter(bh));
        }

    }

    @Benchmark
    public void write(final WriteState state) throws IOException {
        state.csvWriter.appendRow(Constant.ROW);
    }

    @State(Scope.Benchmark)
    public static class ReadState {

        Iterator<String[]> csvIterator;

        @Setup
        public void setup() throws IOException {
            csvIterator = Factory.reader(false);
        }

    }

    @Benchmark
    public String[] read(final ReadState state) {
        return state.csvIterator.next();
    }

}
