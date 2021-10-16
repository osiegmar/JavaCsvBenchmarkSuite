package de.siegmar.csvbenchmark;

import java.io.Closeable;
import java.util.List;

public interface ICsvWriter extends Closeable {

    void writeRecord(List<String> fields) throws Exception;

}
