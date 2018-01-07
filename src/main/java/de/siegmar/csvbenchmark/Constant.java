package de.siegmar.csvbenchmark;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UncheckedIOException;

import de.siegmar.fastcsv.writer.CsvAppender;
import de.siegmar.fastcsv.writer.CsvWriter;

public final class Constant {

    public static final char SEPARATOR = ',';
    public static final char DELIMITER = '"';
    public static final char[] LINE_DELIMITER = { '\n' };

    public static final String[] row = {
        "Simple field",
        "Example with separator " + SEPARATOR,
        "Example with delimiter " + DELIMITER,
        "Example with\nnewline",
        "Example with " + SEPARATOR + " and " + DELIMITER + " and \nnewline"
    };

    public static final String data;

    static {
        final CsvWriter writer = new CsvWriter();
        writer.setFieldSeparator(SEPARATOR);
        writer.setLineDelimiter(LINE_DELIMITER);
        writer.setTextDelimiter(DELIMITER);

        final StringWriter line = new StringWriter();
        try (CsvAppender appender = writer.append(line)) {
            appender.appendLine(row);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        data = line.toString();
    }

}
