package com.chartboost.sdk.Libraries;

import com.chartboost.sdk.Tracking.C2098a;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* renamed from: com.chartboost.sdk.Libraries.c */
public final class C2073c {
    private C2073c() {
    }

    /* renamed from: a */
    public static String m8177a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        Locale locale = Locale.US;
        return String.format(locale, "%0" + (bArr.length << 1) + "x", new Object[]{bigInteger});
    }

    /* renamed from: b */
    public static synchronized byte[] m8178b(byte[] bArr) {
        Class<C2073c> cls = C2073c.class;
        synchronized (cls) {
            if (bArr == null) {
                return null;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(bArr);
                byte[] digest = instance.digest();
                return digest;
            } catch (NoSuchAlgorithmException e) {
                C2098a.m8288a((Class) cls, "sha1", (Exception) e);
                return null;
            } catch (Exception e2) {
                C2098a.m8288a((Class) cls, "sha1", e2);
                return null;
            }
        }
    }
}
