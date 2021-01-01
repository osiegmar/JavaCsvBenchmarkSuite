package opencsv;

import java.io.IOException;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.infra.Blackhole;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.NullWriter;

public class OpenCsvBenchmark {

    @State(Scope.Benchmark)
    public static class WriteState {

        CSVWriter csvWriter;

        @Setup
        public void setup(final Blackhole bh) {
            csvWriter = Factory.writer(new NullWriter(bh));
        }

        @TearDown
        public void teardown() throws IOException {
            csvWriter.close();
        }

    }

    @Benchmark
    public void write(final WriteState state) {
        state.csvWriter.writeNext(Constant.ROW, false);
    }

    @State(Scope.Benchmark)
    public static class ReadState {

        CSVReader csvReader;

        @Setup
        public void setup() {
            csvReader = Factory.reader();
        }

        @TearDown
        public void teardown() throws IOException {
            csvReader.close();
        }

    }

    @Benchmark
    public String[] read(final ReadState state) throws IOException, CsvValidationException {
        return state.csvReader.readNext();
    }

}
