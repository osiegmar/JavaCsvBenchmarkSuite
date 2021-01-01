package simpleflatmapper;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import de.siegmar.csvbenchmark.Constant;

public class FormatTest {

    @Test
    public void reader() throws IOException {
        final Iterator<String[]> reader = Factory.reader(false);

        assertArrayEquals(Constant.ROW, reader.next());
    }

    @Test
    public void writer() throws IOException {
        final StringWriter sw = new StringWriter();
        Factory.writer(sw).appendRow(Constant.ROW);

        assertEquals(Constant.DATA, sw.toString());
    }

}
