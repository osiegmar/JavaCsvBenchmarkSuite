package commonscsv;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import de.siegmar.csvbenchmark.Constant;

public class FormatTest {

    @Test
    public void reader() throws IOException {
        final CSVRecord record = Factory.reader().iterator().next();
        final List<String> items = new ArrayList<>();
        for (final String s : record) {
            items.add(s);
        }

        assertArrayEquals(Constant.ROW, items.toArray());
    }

    @Test
    public void writer() throws IOException {
        final StringWriter sw = new StringWriter();
        try (CSVPrinter csvPrinter = Factory.writer(sw)) {
            csvPrinter.printRecord((Object[]) Constant.ROW);
        }

        assertEquals(Constant.DATA, sw.toString());
    }

}
