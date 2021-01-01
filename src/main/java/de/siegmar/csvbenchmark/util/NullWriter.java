package de.siegmar.csvbenchmark.util;

import java.io.Writer;
import java.util.Arrays;

import org.openjdk.jmh.infra.Blackhole;

// Do some semi-realistic work
public class NullWriter extends Writer {

    private static final int BUFFER_SIZE = 8192;

    private final Blackhole bh;
    private final char[] buf = new char[BUFFER_SIZE];
    private int pos;

    public NullWriter(final Blackhole bh) {
        this.bh = bh;
    }

    @Override
    public void write(final char[] cbuf, final int off, final int len) {
        if (len + pos > buf.length) {
            flush();
        }
        System.arraycopy(cbuf, off, buf, pos, len);
        pos += len;
    }

    @Override
    public void flush() {
        bh.consume(Arrays.copyOf(buf, pos));
        pos = 0;
    }

    @Override
    public void close() {
        flush();
    }

}
