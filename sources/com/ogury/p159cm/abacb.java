package com.ogury.p159cm;

import com.loopj.android.http.C4250c;
import com.ogury.p159cm.ConsentActivity;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.ogury.cm.abacb */
public final class abacb {

    /* renamed from: a */
    public static final abacb f12067a = new abacb();

    private abacb() {
    }

    /* renamed from: a */
    public static String m15103a(byte[] bArr) throws Exception {
        accbb.m15218b(bArr, "str");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(bArr)), C4250c.DEFAULT_CHARSET));
        try {
            return ConsentActivity.aaaaa.m14880a((Reader) bufferedReader);
        } finally {
            ConsentActivity.aaaaa.m14883a((Closeable) bufferedReader);
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public static byte[] m15104a(String str) throws Exception {
        accbb.m15218b(str, "str");
        if (str.length() == 0) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            Charset forName = Charset.forName(C4250c.DEFAULT_CHARSET);
            accbb.m15215a((Object) forName, "Charset.forName(charsetName)");
            byte[] bytes = str.getBytes(forName);
            accbb.m15215a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            gZIPOutputStream.write(bytes);
            ConsentActivity.aaaaa.m14883a((Closeable) gZIPOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            accbb.m15215a((Object) byteArray, "obj.toByteArray()");
            return byteArray;
        } catch (Throwable th) {
            ConsentActivity.aaaaa.m14883a((Closeable) gZIPOutputStream);
            throw th;
        }
    }
}
