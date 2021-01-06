package univocity;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.StringWriter;

import org.junit.jupiter.api.Test;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvWriter;

import de.siegmar.csvbenchmark.Constant;

public class FormatTest {

    @Test
    public void reader() {
        final CsvParser reader = Factory.reader();

        assertArrayEquals(Constant.ROW, reader.parseNext());
    }

    @Test
    public void writer() {
        final StringWriter sw = new StringWriter();
        final CsvWriter csvWriter = Factory.writer(sw);
        csvWriter.writeRow(Constant.ROW);
        csvWriter.close();

        assertEquals(Constant.DATA, sw.toString());
    }

}
