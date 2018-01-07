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

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.NullWriter;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

@Fork(value = 1, warmups = 1)
@Warmup(iterations = 10)
@BenchmarkMode(Mode.Throughput)
public class OpenCsvBenchmark {

    @State(Scope.Benchmark)
    public static class WriteState {

        CSVWriter csvWriter;

        @Setup
        public void setup() {
            csvWriter = new CSVWriter(new NullWriter());
        }

        @TearDown
        public void teardown() throws IOException {
            csvWriter.close();
        }

    }

    @Benchmark
    public void write(final WriteState state) {
        state.csvWriter.writeNext(Constant.row);
    }


    @State(Scope.Benchmark)
    public static class ReadState {

        CSVReader csvReader;

        @Setup
        public void setup() {
            csvReader = new CSVReader(new InfiniteDataReader(Constant.data));
        }

        @TearDown
        public void teardown() throws IOException {
            csvReader.close();
        }

    }

    @Benchmark
    public void read(final ReadState state) throws IOException {
        state.csvReader.readNext();
    }

}
