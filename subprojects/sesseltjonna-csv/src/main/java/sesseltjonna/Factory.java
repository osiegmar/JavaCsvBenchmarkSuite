package sesseltjonna;

import java.util.Arrays;
import java.util.List;

import com.github.skjolber.stcsv.CsvReader;
import com.github.skjolber.stcsv.sa.StringArrayCsvReader;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.ICsvReader;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public final class Factory {

    private Factory() {
    }

    public static ICsvReader reader() throws Exception {
        final CsvReader<String[]> csvReader = StringArrayCsvReader.builder()
            .build(new InfiniteDataReader(Constant.DATA));

        return new ICsvReader() {

            @Override
            public List<String> readRecord() throws Exception {
                return Arrays.asList(csvReader.next());
            }

            @Override
            public void close() {
            }

        };
    }

}
