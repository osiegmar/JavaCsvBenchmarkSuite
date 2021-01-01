package de.siegmar.csvbenchmark.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class InfiniteDataReaderTest {

    @Test
    public void test() throws IOException {
        try (BufferedReader r = new BufferedReader(new InfiniteDataReader("a,b,c\n"))) {
            assertEquals("a,b,c", r.readLine());
            assertEquals("a,b,c", r.readLine());
        }
    }

}
