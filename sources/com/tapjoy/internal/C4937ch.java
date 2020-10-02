package com.tapjoy.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.tapjoy.internal.ch */
public final class C4937ch {
    /* renamed from: a */
    public static byte[] m16776a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
