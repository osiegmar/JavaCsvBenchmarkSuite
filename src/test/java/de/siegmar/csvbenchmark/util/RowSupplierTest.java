package de.siegmar.csvbenchmark.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class RowSupplierTest {

    @Test
    public void supply() {
        final RowSupplier s = new RowSupplier(List.of(List.of("a"), List.of("b", "c")));
        assertEquals(List.of("b", "c"), s.get());
        assertEquals(List.of("a"), s.get());
        assertEquals(List.of("b", "c"), s.get());
    }

}
