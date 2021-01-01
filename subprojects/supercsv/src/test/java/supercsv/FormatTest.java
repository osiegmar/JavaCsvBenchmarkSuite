package supercsv;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;
import org.supercsv.io.CsvListWriter;

import de.siegmar.csvbenchmark.Constant;

public class FormatTest {

    @Test
    public void reader() throws IOException {
        final String[] sa = Factory.reader().read().stream()
            .map(s -> (s == null) ? "" : s)
            .toArray(String[]::new);

        assertArrayEquals(Constant.ROW, sa);
    }

    @Test
    public void writer() throws IOException {
        final StringWriter sw = new StringWriter();
        try (CsvListWriter csvListWriter = Factory.writer(sw)) {
            csvListWriter.write(Constant.ROW);
        }

        assertEquals(Constant.DATA, sw.toString());
    }

}
