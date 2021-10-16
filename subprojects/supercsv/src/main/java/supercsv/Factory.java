package supercsv;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.List;

import org.supercsv.io.CsvListReader;
import org.supercsv.io.CsvListWriter;
import org.supercsv.prefs.CsvPreference;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.ICsvReader;
import de.siegmar.csvbenchmark.ICsvWriter;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public final class Factory {

    private Factory() {
    }

    public static ICsvReader reader() {
        return new ICsvReader() {

            private final CsvListReader csvReader = new CsvListReader(new InfiniteDataReader(Constant.DATA),
                CsvPreference.STANDARD_PREFERENCE);

            @Override
            public Collection<String> readRecord() throws Exception {
                return csvReader.read();
            }

            @Override
            public void close() throws IOException {
                csvReader.close();
            }

        };
    }

    public static ICsvWriter writer(final Writer writer) {
        return new ICsvWriter() {

            private final CsvListWriter csvWriter = new CsvListWriter(writer, CsvPreference.EXCEL_PREFERENCE);

            @Override
            public void writeRecord(final List<String> fields) throws Exception {
                csvWriter.write(fields);
            }

            @Override
            public void close() throws IOException {
                csvWriter.close();
            }

        };
    }

}
