package javacsv;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.StringWriter;
import java.util.List;

import org.junit.jupiter.api.Test;

import de.siegmar.csvbenchmark.CsvConstants;
import de.siegmar.csvbenchmark.ICsvReader;
import de.siegmar.csvbenchmark.ICsvWriter;

public class FormatTest {

    @Test
    public void reader() throws Exception {
        try (ICsvReader reader = Factory.reader()) {
            for (final List<String> row : CsvConstants.RECORDS) {
                assertEquals(row, reader.readRecord());
            }
        }
    }

    @Test
    public void writer() throws Exception {
        final StringWriter sw = new StringWriter();
        try (ICsvWriter writer = Factory.writer(sw)) {
            for (final List<String> row : CsvConstants.RECORDS) {
                writer.writeRecord(row);
            }
        }

        assertEquals(CsvConstants.DATA, sw.toString());
    }

}
