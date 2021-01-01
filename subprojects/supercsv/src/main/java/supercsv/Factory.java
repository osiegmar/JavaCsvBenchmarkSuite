package supercsv;

import java.io.Writer;

import org.supercsv.io.CsvListReader;
import org.supercsv.io.CsvListWriter;
import org.supercsv.prefs.CsvPreference;

import de.siegmar.csvbenchmark.Constant;
import de.siegmar.csvbenchmark.util.InfiniteDataReader;

public class Factory {

    public static CsvListReader reader() {
        return new CsvListReader(new InfiniteDataReader(Constant.DATA),
            CsvPreference.STANDARD_PREFERENCE);
    }

    public static CsvListWriter writer(final Writer writer) {
        return new CsvListWriter(writer, CsvPreference.EXCEL_PREFERENCE);
    }

}
