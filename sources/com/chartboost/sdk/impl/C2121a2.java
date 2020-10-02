package com.chartboost.sdk.impl;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/* renamed from: com.chartboost.sdk.impl.a2 */
public class C2121a2 {
    static {
        char c = File.separatorChar;
        C2130c2 c2Var = new C2130c2(4);
        PrintWriter printWriter = new PrintWriter(c2Var);
        printWriter.println();
        c2Var.toString();
        printWriter.close();
    }

    /* renamed from: a */
    public static void m8438a(InputStream inputStream) {
        m8437a((Closeable) inputStream);
    }

    /* renamed from: b */
    public static byte[] m8442b(InputStream inputStream) throws IOException {
        C2125b2 b2Var = new C2125b2();
        m8435a(inputStream, (OutputStream) b2Var);
        return b2Var.mo9280a();
    }

    /* renamed from: a */
    public static void m8437a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public static byte[] m8440a(InputStream inputStream, long j) throws IOException {
        if (j <= 2147483647L) {
            return m8439a(inputStream, (int) j);
        }
        throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + j);
    }

    /* renamed from: b */
    public static long m8441b(InputStream inputStream, OutputStream outputStream) throws IOException {
        return m8436a(inputStream, outputStream, new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE]);
    }

    /* renamed from: a */
    public static byte[] m8439a(InputStream inputStream, int i) throws IOException {
        if (i >= 0) {
            int i2 = 0;
            if (i == 0) {
                return new byte[0];
            }
            byte[] bArr = new byte[i];
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == i) {
                return bArr;
            }
            throw new IOException("Unexpected readed size. current: " + i2 + ", excepted: " + i);
        }
        throw new IllegalArgumentException("Size must be equal or greater than zero: " + i);
    }

    /* renamed from: a */
    public static int m8435a(InputStream inputStream, OutputStream outputStream) throws IOException {
        long b = m8441b(inputStream, outputStream);
        if (b > 2147483647L) {
            return -1;
        }
        return (int) b;
    }

    /* renamed from: a */
    public static long m8436a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }
}
