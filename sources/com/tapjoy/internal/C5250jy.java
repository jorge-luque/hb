package com.tapjoy.internal;

import java.nio.CharBuffer;

/* renamed from: com.tapjoy.internal.jy */
public final class C5250jy {
    /* renamed from: a */
    private static long m17614a(Readable readable, Appendable appendable) {
        CharBuffer allocate = CharBuffer.allocate(2048);
        long j = 0;
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return j;
            }
            allocate.flip();
            appendable.append(allocate, 0, read);
            j += (long) read;
        }
    }

    /* renamed from: a */
    public static String m17615a(Readable readable) {
        StringBuilder sb = new StringBuilder();
        m17614a(readable, sb);
        return sb.toString();
    }
}
