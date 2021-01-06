package sesseltjonna;

import com.github.skjolber.stcsv.CsvReader;
import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.io.Reader;

public class SesseltjonnaCsvBenchmark {

    @State(Scope.Benchmark)
    public static class ReadState {

        CsvReader<String[]> csvReader;
        Reader input = new InfiniteDataReader(Constant.DATA);
    
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
