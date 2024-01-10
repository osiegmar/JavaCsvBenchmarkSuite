package de.siegmar.csvbenchmark;

import java.util.List;

public final class CsvConstants {

    public static final char SEPARATOR = ',';
    public static final char DELIMITER = '"';

    public static final List<String> RECORD_1 = List.of(
        "Simple field",
        "",
        "Example with separator ,",
        "Example with delimiter \"",
        "Example with\nnewline",
        "Example with , and \" and \nnewline"
    );

    public static final List<String> RECORD_2 = List.of(
        "Example row with only",
        "two columns"
    );

    public static final List<List<String>> RECORDS = List.of(RECORD_1, RECORD_2);

    public static final String DATA = "Simple field,"
        + ","
        + "\"Example with separator ,\","
        + "\"Example with delimiter \"\"\","
        + "\"Example with\nnewline\","
        + "\"Example with , and \"\" and \nnewline\""
        + "\n"
        + "Example row with only,"
        + "two columns"
        + "\n";

    private CsvConstants() {
    }

}
