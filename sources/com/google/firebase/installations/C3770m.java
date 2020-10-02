package com.google.firebase.installations;

import android.util.Base64;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

/* renamed from: com.google.firebase.installations.m */
/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
public class C3770m {

    /* renamed from: a */
    private static final byte f10441a = Byte.parseByte("01110000", 2);

    /* renamed from: b */
    private static final byte f10442b = Byte.parseByte("00001111", 2);

    /* renamed from: a */
    public String mo27410a() {
        byte[] a = m12707a(UUID.randomUUID(), new byte[17]);
        a[16] = a[0];
        a[0] = (byte) ((f10442b & a[0]) | f10441a);
        return m12706a(a);
    }

    /* renamed from: a */
    private static String m12706a(byte[] bArr) {
        return new String(Base64.encode(bArr, 11), Charset.defaultCharset()).substring(0, 22);
    }

    /* renamed from: a */
    private static byte[] m12707a(UUID uuid, byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.putLong(uuid.getMostSignificantBits());
        wrap.putLong(uuid.getLeastSignificantBits());
        return wrap.array();
    }
}
