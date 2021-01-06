package sesseltjonna;

import java.io.Reader;

import com.github.skjolber.stcsv.CsvReader;
import com.github.skjolber.stcsv.sa.StringArrayCsvReader;

public final class Factory {

    private Factory() {
    }

    public static CsvReader<String[]> reader(final Reader input) throws Exception {
        return StringArrayCsvReader.builder().build(input);
    }

}
