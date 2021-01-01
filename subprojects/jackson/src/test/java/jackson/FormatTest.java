package jackson;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.MappingIterator;

import de.siegmar.csvbenchmark.Constant;

public class FormatTest {

    @Test
    public void reader() throws IOException {
        try (MappingIterator<String[]> reader = Factory.reader()) {
            assertArrayEquals(Constant.ROW, reader.nextValue());
        }
    }

    @Test
    public void writer() throws IOException {
        final StringWriter sw = new StringWriter();
        Factory.writer(sw).write(Constant.ROW);

        assertEquals(Constant.DATA, sw.toString());
    }

}
