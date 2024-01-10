package commonscsv;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import de.siegmar.csvbenchmark.CsvConstants;
import de.siegmar.csvbenchmark.ICsvReader;
import de.siegmar.csvbenchmark.ICsvWriter;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public final class Factory {

    private static final CSVFormat FORMAT = CSVFormat.DEFAULT
        .builder()
        .setRecordSeparator('\n')
        .build();

    private Factory() {
    }

    public static ICsvReader reader() throws IOException {
        return new ICsvReader() {

            private final CSVParser parser = new CSVParser(new InfiniteDataReader(CsvConstants.DATA), FORMAT);
            private final Iterator<CSVRecord> csvIterator = parser.iterator();

            @Override
            public List<String> readRecord() {
                return csvIterator.next().toList();
            }

            @Override
            public void close() throws IOException {
                parser.close();
            }

        };
    }

    public static ICsvWriter writer(final Writer writer) throws IOException {
        return new ICsvWriter() {

            private final CSVPrinter printer = new CSVPrinter(writer, FORMAT);

            @Override
            public void writeRecord(final List<String> fields) throws IOException {
                printer.printRecord(fields);
            }

            @Override
            public void close() throws IOException {
                printer.close();
            }

        };
    }

}
