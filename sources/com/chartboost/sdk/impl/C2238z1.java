package com.chartboost.sdk.impl;

import android.support.p004v4.media.session.PlaybackStateCompat;
import com.loopj.android.http.C4250c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;

/* renamed from: com.chartboost.sdk.impl.z1 */
public class C2238z1 {

    /* renamed from: a */
    public static final BigInteger f7559a;

    /* renamed from: b */
    public static final BigInteger f7560b;

    /* renamed from: c */
    public static final BigInteger f7561c;

    /* renamed from: d */
    public static final BigInteger f7562d;

    /* renamed from: e */
    public static final BigInteger f7563e;

    /* renamed from: f */
    public static final BigInteger f7564f;

    static {
        BigInteger valueOf = BigInteger.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
        f7559a = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        f7560b = multiply;
        BigInteger multiply2 = f7559a.multiply(multiply);
        f7561c = multiply2;
        BigInteger multiply3 = f7559a.multiply(multiply2);
        f7562d = multiply3;
        BigInteger multiply4 = f7559a.multiply(multiply3);
        f7563e = multiply4;
        f7559a.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).multiply(BigInteger.valueOf(1152921504606846976L));
        f7564f = multiply5;
        f7559a.multiply(multiply5);
        Charset.forName(C4250c.DEFAULT_CHARSET);
    }

    /* renamed from: a */
    public static FileInputStream m8890a(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File '" + file + "' cannot be read");
        }
    }

    /* renamed from: b */
    public static byte[] m8891b(File file) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = m8890a(file);
            try {
                byte[] a = C2121a2.m8440a((InputStream) fileInputStream, file.length());
                C2121a2.m8438a((InputStream) fileInputStream);
                return a;
            } catch (Throwable th) {
                th = th;
                C2121a2.m8438a((InputStream) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            C2121a2.m8438a((InputStream) fileInputStream);
            throw th;
        }
    }
}
