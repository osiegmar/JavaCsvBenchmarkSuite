package opencsv;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import de.siegmar.csvbenchmark.Constant;

public class FormatTest {

    @Test
    public void reader() throws IOException, CsvValidationException {
        try (CSVReader reader = Factory.reader()) {
            assertArrayEquals(Constant.ROW, reader.readNext());
        }
    }

    @Test
    public void writer() throws IOException {
        final StringWriter sw = new StringWriter();
        try (CSVWriter csvWriter = Factory.writer(sw)) {
            csvWriter.writeNext(Constant.ROW, false);
        }

        assertEquals(Constant.DATA, sw.toString());
    }

}
