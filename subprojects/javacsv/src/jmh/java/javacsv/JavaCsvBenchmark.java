package javacsv;

import java.io.IOException;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.infra.Blackhole;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.NullWriter;

public class JavaCsvBenchmark {

    @State(Scope.Benchmark)
    public static class WriteState {

        CsvWriter csvWriter;

        @Setup
        public void setup(final Blackhole bh) {
            this.csvWriter = Factory.writer(new NullWriter(bh));
        }

        @TearDown
        public void teardown() {
            csvWriter.close();
        }

    }

    @Benchmark
    public void write(final WriteState state) throws IOException {
        state.csvWriter.writeRecord(Constant.ROW);
    }

    @State(Scope.Benchmark)
    public static class ReadState {

        CsvReader csvReader;

        @Setup
        public void setup() {
            csvReader = Factory.reader();
        }

        @TearDown
        public void teardown() {
            csvReader.close();
        }

    }

    @Benchmark
    public String[] read(final ReadState state) throws IOException {
        state.csvReader.readRecord();
        return state.csvReader.getValues();
    }

}
