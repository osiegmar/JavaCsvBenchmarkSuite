package univocity;

import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;

import de.siegmar.csvbenchmark.CsvConstants;
import de.siegmar.csvbenchmark.ICsvReader;
import de.siegmar.csvbenchmark.ICsvWriter;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public final class Factory {

    private Factory() {
    }

    public static ICsvReader reader() {
        final CsvParserSettings settings = new CsvParserSettings();
        settings.setNullValue("");
        final CsvParser parser = new CsvParser(settings);
        parser.beginParsing(new InfiniteDataReader(CsvConstants.DATA));

        return new ICsvReader() {

            @Override
            public Collection<String> readRecord() {
                return Arrays.asList(parser.parseNext());
            }

            @Override
            public void close() {
                parser.stopParsing();
            }

        };
    }

    public static ICsvWriter writer(final Writer writer) {
        final CsvWriterSettings settings = new CsvWriterSettings();
        settings.setQuoteEscapingEnabled(true);

        return new ICsvWriter() {

            private final CsvWriter csvWriter = new CsvWriter(writer, settings);

            @Override
            public void writeRecord(final List<String> fields) {
                csvWriter.writeRow(fields);
            }

            @Override
            public void close() {
                csvWriter.close();
            }

        };
    }

}
