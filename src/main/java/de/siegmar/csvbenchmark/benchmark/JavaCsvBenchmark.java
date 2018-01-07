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

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.NullWriter;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

@Fork(value = 1, warmups = 1)
@Warmup(iterations = 10)
@BenchmarkMode(Mode.Throughput)
public class JavaCsvBenchmark {

    @State(Scope.Benchmark)
    public static class WriteState {

        CsvWriter csvWriter;

        @Setup
        public void setup() {
            csvWriter = new CsvWriter(new NullWriter(), Constant.SEPARATOR);
        }

        @TearDown
        public void teardown() {
            csvWriter.close();
        }

    }

    @Benchmark
    public void write(final WriteState state) throws IOException {
        state.csvWriter.writeRecord(Constant.row);
    }


    @State(Scope.Benchmark)
    public static class ReadState {

        CsvReader csvReader;

        @Setup
        public void setup() {
            csvReader = new CsvReader(new InfiniteDataReader(Constant.data), Constant.SEPARATOR);
        }

        @TearDown
        public void teardown() {
            csvReader.close();
        }

    }

    @Benchmark
    public void read(final ReadState state) throws IOException {
        state.csvReader.readRecord();
    }

}
