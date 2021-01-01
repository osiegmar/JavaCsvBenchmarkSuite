package fastcsv;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.fastcsv.reader.CsvReader;

public class FormatTest {

    @Test
    public void reader() throws IOException {
        try (CsvReader reader = Factory.reader()) {
            assertArrayEquals(Constant.ROW, reader.iterator().next().getFields().toArray());
        }
    }

    @Test
    public void writer() {
        final StringWriter sw = new StringWriter();
        Factory.writer(sw).writeRow(Constant.ROW);
        assertEquals(Constant.DATA, sw.toString());
    }

}
