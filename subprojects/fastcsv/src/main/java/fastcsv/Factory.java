package fastcsv;

import java.io.Writer;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.writer.CsvWriter;
import de.siegmar.fastcsv.writer.LineDelimiter;

public class Factory {

    public static CsvReader reader() {
        return CsvReader.builder()
            .fieldSeparator(Constant.SEPARATOR)
            .quoteCharacter(Constant.DELIMITER)
            .skipEmptyRows(false)
            .build(new InfiniteDataReader(Constant.DATA));
    }

    public static CsvWriter writer(final Writer writer) {
        return CsvWriter.builder()
            .fieldSeparator(Constant.SEPARATOR)
            .lineDelimiter(LineDelimiter.LF)
            .quoteCharacter(Constant.DELIMITER)
            .build(writer);
    }

}
