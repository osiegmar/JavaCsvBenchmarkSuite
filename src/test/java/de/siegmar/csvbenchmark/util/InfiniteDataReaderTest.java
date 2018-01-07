package de.siegmar.csvbenchmark.util;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Test;

public class InfiniteDataReaderTest {

    @Test
    public void test() throws IOException {
        final BufferedReader r = new BufferedReader(new InfiniteDataReader("a,b,c\n"));
        assertEquals("a,b,c", r.readLine());
        assertEquals("a,b,c", r.readLine());
    }

}
