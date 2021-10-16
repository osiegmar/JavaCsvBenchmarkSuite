package jackson;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.ICsvReader;
import de.siegmar.csvbenchmark.ICsvWriter;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public final class Factory {

    private Factory() {
    }

    public static ICsvReader reader() throws IOException {
        return new ICsvReader() {

            private final MappingIterator<List<String>> iterator = new CsvMapper()
                .enable(CsvParser.Feature.WRAP_AS_ARRAY)
                .readerFor(List.class)
                .readValues(new InfiniteDataReader(Constant.DATA));

            @Override
            public List<String> readRecord() throws Exception {
                return iterator.nextValue();
            }

            @Override
            public void close() throws IOException {
                iterator.close();
            }

        };
    }

    public static ICsvWriter writer(final Writer writer) throws IOException {
        return new ICsvWriter() {

            private final SequenceWriter csvWriter = new CsvMapper()
                .enable(CsvGenerator.Feature.STRICT_CHECK_FOR_QUOTING)
                .writer()
                .writeValues(writer);

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
