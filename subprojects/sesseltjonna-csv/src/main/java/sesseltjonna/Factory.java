package sesseltjonna;

import com.github.skjolber.stcsv.CsvReader;
import com.github.skjolber.stcsv.sa.StringArrayCsvReader;

import java.io.Reader;

public class Factory {

    public static CsvReader<String[]> reader(Reader input) throws Exception {
        return StringArrayCsvReader.builder().build(input);
    }

}
