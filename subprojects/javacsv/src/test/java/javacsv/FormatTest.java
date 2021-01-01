package javacsv;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import de.siegmar.csvbenchmark.Constant;

public class FormatTest {

    @Test
    public void reader() throws IOException {
        final CsvReader reader = Factory.reader();
        reader.readRecord();

        assertArrayEquals(Constant.ROW, reader.getValues());
    }

    @Test
    public void writer() throws IOException {
        final StringWriter sw = new StringWriter();
        final CsvWriter csvWriter = Factory.writer(sw);
        csvWriter.writeRecord(Constant.ROW);
        csvWriter.close();

        assertEquals(Constant.DATA, sw.toString());
    }

}
