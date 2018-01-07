package de.siegmar.csvbenchmark.util;

import java.io.IOException;
import java.io.Writer;

import org.junit.Test;

public class NullWriterTest {

    @Test
    public void test() throws IOException {
        final Writer writer = new NullWriter();
        for (int i = 0; i < 20 * 1024 * 1024; i++) {
            writer.write("test");
        }
    }

}
