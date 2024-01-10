package simpleflatmapper;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.simpleflatmapper.lightningcsv.CsvParser;
import org.simpleflatmapper.lightningcsv.CsvWriter;

import de.siegmar.csvbenchmark.CsvConstants;
import de.siegmar.csvbenchmark.ICsvReader;
import de.siegmar.csvbenchmark.ICsvWriter;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public final class Factory {

    private Factory() {
    }

    public static ICsvReader reader(final boolean asm) throws IOException {
        return new ICsvReader() {

            private final Iterator<String[]> csvReader = newReader(asm)
                .reader(new InfiniteDataReader(CsvConstants.DATA)).iterator();

            @Override
            public Collection<String> readRecord() {
                return Arrays.asList(csvReader.next());
            }

            @Override
            public void close() {
            }

        };
    }

    private static CsvParser.DSL newReader(final boolean asm) {
        final CsvParser.DSL dsl = CsvParser.dsl();

        if (asm) {
            return dsl;
        }

        return dsl.disableSpecialisedCharConsumer();
    }

    public static ICsvWriter writer(final Writer writer) {
        return new ICsvWriter() {

            private final CsvWriter csvWriter = CsvWriter.dsl()
                .endOfLine("\n")
                .to(writer);

            @Override
            public void writeRecord(final List<String> fields) throws Exception {
                csvWriter.appendRow(fields);
            }

            @Override
            public void close() throws IOException {
                writer.close();
            }

        };
    }

}
