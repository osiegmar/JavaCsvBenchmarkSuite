package jackson;

import java.io.IOException;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.infra.Blackhole;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.SequenceWriter;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.NullWriter;

public class JacksonBenchmark {

    @State(Scope.Benchmark)
    public static class WriteState {

        SequenceWriter writer;

        @Setup
        public void setup(final Blackhole bh) throws IOException {
            this.writer = Factory.writer(new NullWriter(bh));
        }

        @TearDown
        public void teardown() throws IOException {
            writer.close();
        }

    }

    @Benchmark
    public void write(final WriteState state) throws IOException {
        state.writer.write(Constant.ROW);
    }

    @State(Scope.Benchmark)
    public static class ReadState {

        MappingIterator<String[]> it;

        @Setup
        public void setup() throws IOException {
            it = Factory.reader();
        }

    }

    @Benchmark
    public String[] read(final ReadState state) {
        return state.it.next();
    }

}
