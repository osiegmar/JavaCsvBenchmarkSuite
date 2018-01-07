package de.siegmar.csvbenchmark.util;

import java.io.Writer;

// Do some semi-realistic work
public class NullWriter extends Writer {

    private char[] buf = new char[10 * 1024 * 1024];
    private int pos = 0;

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
        pos = 0;
    }

    @Override
    public void close() {
        flush();
        buf = null;
    }

}
