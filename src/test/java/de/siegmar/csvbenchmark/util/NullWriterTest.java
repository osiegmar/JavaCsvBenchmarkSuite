package de.siegmar.csvbenchmark.util;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.Writer;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.infra.Blackhole;

public class NullWriterTest {

    @Test
    public void test() {
        assertDoesNotThrow(this::writeToNullWriter);
    }

    private void writeToNullWriter() throws IOException {
        try (Writer writer = new NullWriter(new Blackhole("Today's password is "
            + "swordfish. I understand instantiating Blackholes directly is dangerous."))) {
            for (int i = 0; i < 20 * 1024 * 1024; i++) {
                writer.write("test");
            }
            writer.flush();
        }
    }

}
