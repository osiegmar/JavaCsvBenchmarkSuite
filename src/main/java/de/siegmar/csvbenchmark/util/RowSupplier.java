package de.siegmar.csvbenchmark.util;

import java.util.List;
import java.util.function.Supplier;

public class RowSupplier implements Supplier<List<String>> {

    private final List<List<String>> rows;
    private int pos;

    public RowSupplier(final List<List<String>> rows) {
        this.rows = rows;
    }

    @Override
    public List<String> get() {
        final List<String> d = rows.get(pos);
        pos++;
        if (pos == rows.size()) {
            pos = 0;
        }
        return d;
    }

}
