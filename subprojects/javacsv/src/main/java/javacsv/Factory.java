package javacsv;

import java.io.Writer;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public class Factory {

    public static CsvReader reader() {
        return new CsvReader(new InfiniteDataReader(Constant.DATA), Constant.SEPARATOR);
    }

    public static CsvWriter writer(final Writer writer) {
        return new CsvWriter(writer, Constant.SEPARATOR);
    }

}
