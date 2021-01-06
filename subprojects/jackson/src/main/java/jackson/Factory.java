package jackson;

import java.io.IOException;
import java.io.Writer;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public final class Factory {

    private Factory() {
    }

    public static MappingIterator<String[]> reader() throws IOException {
        final CsvMapper mapper = new CsvMapper();
        mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
        return mapper.readerFor(String[].class).readValues(new InfiniteDataReader(Constant.DATA));
    }

    public static SequenceWriter writer(final Writer writer) throws IOException {
        final CsvMapper mapper = new CsvMapper();
        mapper.enable(CsvGenerator.Feature.STRICT_CHECK_FOR_QUOTING);
        return mapper.writer().writeValues(writer);
    }

}
