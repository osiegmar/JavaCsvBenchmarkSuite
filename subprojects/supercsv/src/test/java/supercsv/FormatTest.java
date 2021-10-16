package supercsv;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.StringWriter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.ICsvReader;
import de.siegmar.csvbenchmark.ICsvWriter;

public class FormatTest {

    @Test
    public void reader() throws Exception {
        try (ICsvReader reader = Factory.reader()) {
            for (final List<String> row : Constant.ROWS) {
                assertEquals(row, nullToEmpty(reader.readRecord()));
            }
        }
    }

    private List<String> nullToEmpty(final Collection<String> row) {
        return row.stream()
            .map(s -> (s == null) ? "" : s)
            .collect(Collectors.toList());
    }

    @Test
    public void writer() throws Exception {
        final StringWriter sw = new StringWriter();
        try (ICsvWriter writer = Factory.writer(sw)) {
            for (final List<String> row : Constant.ROWS) {
                writer.writeRecord(row);
            }
        }

        assertEquals(Constant.DATA, sw.toString());
    }

}
