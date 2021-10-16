package opencsv;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.ICsvReader;
import de.siegmar.csvbenchmark.ICsvWriter;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public final class Factory {

    private Factory() {
    }

    public static ICsvReader reader() {
        return new ICsvReader() {

            private final CSVReader csvReader = new CSVReader(new InfiniteDataReader(Constant.DATA));

            @Override
            public List<String> readRecord() throws Exception {
                return Arrays.asList(csvReader.readNext());
            }

            @Override
            public void close() throws IOException {
                csvReader.close();
            }

        };
    }

    public static ICsvWriter writer(final Writer writer) {
        return new ICsvWriter() {

            private final CSVWriter csvWriter = new CSVWriter(writer);

            @Override
            public void writeRecord(final List<String> fields) {
                csvWriter.writeNext(fields.toArray(new String[0]), false);
            }

            @Override
            public void close() throws IOException {
                csvWriter.close();
            }

        };
    }

}
