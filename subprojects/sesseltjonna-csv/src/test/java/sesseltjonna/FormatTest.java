package sesseltjonna;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.Reader;

import org.junit.jupiter.api.Test;

import com.github.skjolber.stcsv.CsvReader;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public class FormatTest {

    @Test
    public void reader() throws Exception {
        try (Reader input = new InfiniteDataReader(Constant.DATA)) {
            final CsvReader<String[]> reader = Factory.reader(input);
            final String[] next = reader.next();

            // empty columns are returned as null (not empty strings)
            for (int i = 0; i < Constant.ROW.length; i++) {
                if (Constant.ROW[i].isEmpty()) {
                    assertNull(next[i]);
                } else {
                    assertEquals(Constant.ROW[i], next[i]);
                }
            }
        }
    }

}
