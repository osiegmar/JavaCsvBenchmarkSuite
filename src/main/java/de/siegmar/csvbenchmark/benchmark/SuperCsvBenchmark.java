package de.siegmar.csvbenchmark.benchmark;

import java.io.IOException;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;
import org.supercsv.io.CsvListReader;
import org.supercsv.io.CsvListWriter;
import org.supercsv.prefs.CsvPreference;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;
import de.siegmar.csvbenchmark.util.NullWriter;

@Fork(value = 1, warmups = 1)
@Warmup(iterations = 10)
@BenchmarkMode(Mode.Throughput)
public class SuperCsvBenchmark {

    @State(Scope.Benchmark)
    public static class WriteState {

        CsvListWriter csvWriter;

        @Setup
        public void setup() {
            csvWriter = new CsvListWriter(new NullWriter(),
                CsvPreference.STANDARD_PREFERENCE);
        }

        @TearDown
        public void teardown() throws IOException {
            csvWriter.close();
        }

    }

    @Benchmark
    public void write(final WriteState state) throws IOException {
        state.csvWriter.write(Constant.row);
    }


    @State(Scope.Benchmark)
    public static class ReadState {

        CsvListReader csvReader;

        @Setup
        public void setup() {
            csvReader = new CsvListReader(new InfiniteDataReader(Constant.data),
                CsvPreference.STANDARD_PREFERENCE);
        }

        @TearDown
        public void teardown() throws IOException {
            csvReader.close();
        }

    }

    @Benchmark
    public void read(final ReadState state) throws IOException {
        state.csvReader.read();
    }

}
