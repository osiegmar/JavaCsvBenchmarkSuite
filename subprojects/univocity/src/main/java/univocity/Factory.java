package univocity;

import java.io.Writer;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public class Factory {

    public static CsvParser reader() {
        CsvParserSettings settings = new CsvParserSettings();
        settings.setNullValue("");
        CsvParser parser = new CsvParser(settings);
        parser.beginParsing(new InfiniteDataReader(Constant.DATA));

        return parser;
    }

    public static CsvWriter writer(final Writer writer) {
        final CsvWriterSettings settings = new CsvWriterSettings();
        settings.setQuoteEscapingEnabled(true);
        return new CsvWriter(writer, settings);
    }

}
