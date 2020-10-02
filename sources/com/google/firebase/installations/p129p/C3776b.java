package com.google.firebase.installations.p129p;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.stats.CodePackage;
import com.google.firebase.FirebaseApp;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.firebase.installations.p.b */
/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
public class C3776b {

    /* renamed from: c */
    private static final String[] f10458c = {"*", "FCM", CodePackage.GCM, ""};

    /* renamed from: a */
    private final SharedPreferences f10459a;

    /* renamed from: b */
    private final String f10460b;

    public C3776b(FirebaseApp firebaseApp) {
        this.f10459a = firebaseApp.mo27170a().getSharedPreferences("com.google.android.gms.appid", 0);
        this.f10460b = m12729a(firebaseApp);
    }

    /* renamed from: a */
    private static String m12729a(FirebaseApp firebaseApp) {
        String c = firebaseApp.mo27173c().mo27209c();
        if (c != null) {
            return c;
        }
        String b = firebaseApp.mo27173c().mo27208b();
        if (!b.startsWith("1:") && !b.startsWith("2:")) {
            return b;
        }
        String[] split = b.split(":");
        if (split.length != 4) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    /* renamed from: c */
    private String m12734c() {
        String string;
        synchronized (this.f10459a) {
            string = this.f10459a.getString("|S|id", (String) null);
        }
        return string;
    }

    /* renamed from: d */
    private String m12735d() {
        synchronized (this.f10459a) {
            String string = this.f10459a.getString("|S||P|", (String) null);
            if (string == null) {
                return null;
            }
            PublicKey b = m12733b(string);
            if (b == null) {
                return null;
            }
            String a = m12732a(b);
            return a;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        return r4;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo27433b() {
        /*
            r7 = this;
            android.content.SharedPreferences r0 = r7.f10459a
            monitor-enter(r0)
            java.lang.String[] r1 = f10458c     // Catch:{ all -> 0x0033 }
            int r2 = r1.length     // Catch:{ all -> 0x0033 }
            r3 = 0
        L_0x0007:
            r4 = 0
            if (r3 >= r2) goto L_0x0031
            r5 = r1[r3]     // Catch:{ all -> 0x0033 }
            java.lang.String r6 = r7.f10460b     // Catch:{ all -> 0x0033 }
            java.lang.String r5 = r7.m12731a(r6, r5)     // Catch:{ all -> 0x0033 }
            android.content.SharedPreferences r6 = r7.f10459a     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = r6.getString(r5, r4)     // Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x002e
            boolean r5 = r4.isEmpty()     // Catch:{ all -> 0x0033 }
            if (r5 != 0) goto L_0x002e
            java.lang.String r1 = "{"
            boolean r1 = r4.startsWith(r1)     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x002c
            java.lang.String r4 = r7.m12730a((java.lang.String) r4)     // Catch:{ all -> 0x0033 }
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return r4
        L_0x002e:
            int r3 = r3 + 1
            goto L_0x0007
        L_0x0031:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return r4
        L_0x0033:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            goto L_0x0037
        L_0x0036:
            throw r1
        L_0x0037:
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.p129p.C3776b.mo27433b():java.lang.String");
    }

    /* renamed from: a */
    private String m12731a(String str, String str2) {
        return "|T|" + str + "|" + str2;
    }

    /* renamed from: a */
    private String m12730a(String str) {
        try {
            return new JSONObject(str).getString("token");
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: b */
    private PublicKey m12733b(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            Log.w("ContentValues", "Invalid key stored " + e);
            return null;
        }
    }

    /* renamed from: a */
    public String mo27432a() {
        synchronized (this.f10459a) {
            String c = m12734c();
            if (c != null) {
                return c;
            }
            String d = m12735d();
            return d;
        }
    }

    /* renamed from: a */
    private static String m12732a(PublicKey publicKey) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            return null;
        }
    }
}
