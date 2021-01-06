package simpleflatmapper;

import java.io.IOException;
import java.util.Iterator;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

public class SimpleFlatMapperASMBenchmark {

    @State(Scope.Benchmark)
    public static class ReadState {

        Iterator<String[]> csvIterator;

        @Setup
        public void setup() throws IOException {
            csvIterator = Factory.reader(true);
        }

    }

    @Benchmark
    public String[] read(final ReadState state) {
        return state.csvIterator.next();
    }

}
