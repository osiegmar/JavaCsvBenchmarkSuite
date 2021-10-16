package de.siegmar.csvbenchmark;

import java.io.Closeable;
import java.util.Collection;

public interface ICsvReader extends Closeable {

    Collection<String> readRecord() throws Exception;

}
