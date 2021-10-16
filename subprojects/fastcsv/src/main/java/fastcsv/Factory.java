package fastcsv;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.ICsvReader;
import de.siegmar.csvbenchmark.ICsvWriter;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;
import de.siegmar.fastcsv.reader.CloseableIterator;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import de.siegmar.fastcsv.writer.CsvWriter;
import de.siegmar.fastcsv.writer.LineDelimiter;

public final class Factory {

    private Factory() {
    }

    public static ICsvReader reader() {
        return new ICsvReader() {

            private final CloseableIterator<CsvRow> iterator = CsvReader.builder()
                .fieldSeparator(Constant.SEPARATOR)
                .quoteCharacter(Constant.DELIMITER)
                .skipEmptyRows(false)
                .build(new InfiniteDataReader(Constant.DATA))
                .iterator();

            @Override
            public List<String> readRecord() {
                return iterator.next().getFields();
            }

            @Override
            public void close() throws IOException {
                iterator.close();
            }

        };
    }

    public static ICsvWriter writer(final Writer writer) {
        return new ICsvWriter() {

            private final CsvWriter csvWriter = CsvWriter.builder()
                .fieldSeparator(Constant.SEPARATOR)
                .lineDelimiter(LineDelimiter.LF)
                .quoteCharacter(Constant.DELIMITER)
                .build(writer);

            @Override
            public void writeRecord(final List<String> fields) {
                csvWriter.writeRow(fields);
            }

            @Override
            public void close() throws IOException {
                csvWriter.close();
            }

        };
    }

}
