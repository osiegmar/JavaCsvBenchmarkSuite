package de.siegmar.csvbenchmark;

public final class Constant {

    public static final char SEPARATOR = ',';
    public static final char DELIMITER = '"';

    public static final String[] ROW = {
        "Simple field",
        "",
        "Example with separator ,",
        "Example with delimiter \"",
        "Example with\nnewline",
        "Example with , and \" and \nnewline"
    };

    //public static final String DATA = "\"field1\",\"field2\"\n";

    public static final String DATA = "Simple field,"
        + ","
        + "\"Example with separator ,\","
        + "\"Example with delimiter \"\"\","
        + "\"Example with\nnewline\","
        + "\"Example with , and \"\" and \nnewline\""
        + "\n";

}
