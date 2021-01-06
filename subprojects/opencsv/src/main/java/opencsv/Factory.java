package opencsv;

import java.io.Writer;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public final class Factory {

    private Factory() {
    }

    public static CSVReader reader() {
        return new CSVReader(new InfiniteDataReader(Constant.DATA));
    }

    public static CSVWriter writer(final Writer writer) {
        return new CSVWriter(writer);
    }

}
