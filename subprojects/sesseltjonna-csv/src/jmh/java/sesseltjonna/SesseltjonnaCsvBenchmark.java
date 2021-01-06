package sesseltjonna;

import java.io.IOException;
import java.io.Reader;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

import com.github.skjolber.stcsv.CsvReader;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public class SesseltjonnaCsvBenchmark {

    @State(Scope.Benchmark)
    public static class ReadState {

        private CsvReader<String[]> csvReader;
        private final Reader input = new InfiniteDataReader(Constant.DATA);

        @Setup
        public void setup() throws Exception {
            csvReader = Factory.reader(input);
        }

        @TearDown
        public void teardown() throws IOException {
            input.close();
        }

    }

    @Benchmark
    public String[] read(final ReadState state) throws Exception {
        return state.csvReader.next();
    }

}
