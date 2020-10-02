package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.core.content.C0768a;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import p075d.p080b.C3191a;

/* renamed from: com.google.firebase.iid.b0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final class C3694b0 {

    /* renamed from: a */
    private final SharedPreferences f10287a;

    /* renamed from: b */
    private final Context f10288b;

    /* renamed from: c */
    private final Map<String, Long> f10289c = new C3191a();

    public C3694b0(Context context) {
        this.f10288b = context;
        this.f10287a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        File file = new File(C0768a.m2412c(this.f10288b), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !m12565b()) {
                    mo27313a();
                    FirebaseInstanceId.m12531k().mo27301f();
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e.getMessage());
                    if (valueOf.length() != 0) {
                        "Error creating file in no backup dir: ".concat(valueOf);
                    } else {
                        new String("Error creating file in no backup dir: ");
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static String m12563a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: b */
    private final synchronized boolean m12565b() {
        return this.f10287a.getAll().isEmpty();
    }

    /* renamed from: c */
    private final long m12566c(String str) {
        String string = this.f10287a.getString(m12563a(str, "cre"), (String) null);
        if (string == null) {
            return 0;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* renamed from: b */
    private static String m12564b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    /* renamed from: a */
    public final synchronized void mo27313a() {
        this.f10289c.clear();
        this.f10287a.edit().clear().commit();
    }

    /* renamed from: b */
    public final synchronized void mo27315b(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.f10287a.edit();
        for (String next : this.f10287a.getAll().keySet()) {
            if (next.startsWith(concat)) {
                edit.remove(next);
            }
        }
        edit.commit();
    }

    /* renamed from: a */
    public final synchronized C3691a0 mo27312a(String str, String str2, String str3) {
        return C3691a0.m12560b(this.f10287a.getString(m12564b(str, str2, str3), (String) null));
    }

    /* renamed from: a */
    public final synchronized void mo27314a(String str, String str2, String str3, String str4, String str5) {
        String a = C3691a0.m12559a(str4, str5, System.currentTimeMillis());
        if (a != null) {
            SharedPreferences.Editor edit = this.f10287a.edit();
            edit.putString(m12564b(str, str2, str3), a);
            edit.commit();
        }
    }

    /* renamed from: a */
    public final synchronized long mo27311a(String str) {
        long currentTimeMillis;
        currentTimeMillis = System.currentTimeMillis();
        if (!this.f10287a.contains(m12563a(str, "cre"))) {
            SharedPreferences.Editor edit = this.f10287a.edit();
            edit.putString(m12563a(str, "cre"), String.valueOf(currentTimeMillis));
            edit.commit();
        } else {
            currentTimeMillis = m12566c(str);
        }
        this.f10289c.put(str, Long.valueOf(currentTimeMillis));
        return currentTimeMillis;
    }
}
