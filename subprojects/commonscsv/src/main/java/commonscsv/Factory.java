package commonscsv;

import java.io.IOException;
import java.io.Writer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public class Factory {

    private static final CSVFormat FORMAT = CSVFormat.DEFAULT
        .withRecordSeparator('\n');

    public static CSVParser reader() throws IOException {
        return new CSVParser(new InfiniteDataReader(Constant.DATA), FORMAT);
    }

    public static CSVPrinter writer(final Writer writer) throws IOException {
        return new CSVPrinter(writer, FORMAT);
    }

}
