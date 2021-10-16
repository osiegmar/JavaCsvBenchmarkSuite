package de.siegmar.csvbenchmark;

import java.util.List;

public final class Constant {

    public static final char SEPARATOR = ',';
    public static final char DELIMITER = '"';

    public static final List<String> ROW1 = List.of(
        "Simple field",
        "",
        "Example with separator ,",
        "Example with delimiter \"",
        "Example with\nnewline",
        "Example with , and \" and \nnewline"
    );

    public static final List<String> ROW2 = List.of(
        "Example row with only",
        "two columns"
    );

    public static final List<List<String>> ROWS = List.of(ROW1, ROW2);

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

    private Constant() {
    }

}
