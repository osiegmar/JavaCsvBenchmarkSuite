package simpleflatmapper;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import org.simpleflatmapper.lightningcsv.CsvParser;
import org.simpleflatmapper.lightningcsv.CsvWriter;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public final class Factory {

    private Factory() {
    }

    public static Iterator<String[]> reader(final boolean asm) throws IOException {
        CsvParser.DSL dsl = CsvParser.dsl();

        if (!asm) {
            dsl = dsl.disableSpecialisedCharConsumer();
        }

        return dsl.iterator(new InfiniteDataReader(Constant.DATA));
    }

    public static CsvWriter writer(final Writer writer) {
        return CsvWriter.dsl()
            .endOfLine("\n")
            .to(writer);
    }

}
