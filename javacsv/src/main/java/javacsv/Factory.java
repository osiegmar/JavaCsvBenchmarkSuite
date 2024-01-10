package javacsv;

import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import de.siegmar.csvbenchmark.CsvConstants;
import de.siegmar.csvbenchmark.ICsvReader;
import de.siegmar.csvbenchmark.ICsvWriter;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public final class Factory {

    private Factory() {
    }

    public static ICsvReader reader() {
        return new ICsvReader() {

            private final CsvReader csvReader = new CsvReader(new InfiniteDataReader(CsvConstants.DATA),
                CsvConstants.SEPARATOR);

            @Override
            public List<String> readRecord() throws Exception {
                csvReader.readRecord();
                return Arrays.asList(csvReader.getValues());
            }

            @Override
            public void close() {
                csvReader.close();
            }

        };
    }

    public static ICsvWriter writer(final Writer writer) {
        return new ICsvWriter() {

            private final CsvWriter csvWriter = new CsvWriter(writer, CsvConstants.SEPARATOR);

            @Override
            public void writeRecord(final List<String> fields) throws Exception {
                csvWriter.writeRecord(fields.toArray(new String[0]));
            }

            @Override
            public void close() {
                csvWriter.close();
            }

        };
    }

}
