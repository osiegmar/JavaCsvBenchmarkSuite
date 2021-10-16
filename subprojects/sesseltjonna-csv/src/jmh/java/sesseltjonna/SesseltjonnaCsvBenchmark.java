package sesseltjonna;

import java.io.IOException;
import java.util.Collection;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

import de.siegmar.csvbenchmark.ICsvReader;

public class SesseltjonnaCsvBenchmark {

    @State(Scope.Benchmark)
    public static class ReadState {

        private ICsvReader reader;

        @Setup
        public void setup() throws Exception {
            reader = Factory.reader();
        }

        @TearDown
        public void teardown() throws IOException {
            reader.close();
        }

    }

    @Benchmark
    public Collection<String> read(final ReadState state) throws Exception {
        return state.reader.readRecord();
    }

}
