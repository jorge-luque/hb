package com.loopj.android.http;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

/* renamed from: com.loopj.android.http.g */
/* compiled from: LogHandler */
public class C4255g implements C4256h {

    /* renamed from: a */
    boolean f11405a = true;

    /* renamed from: b */
    int f11406b = 2;

    @TargetApi(8)
    /* renamed from: c */
    private void m14365c(String str, String str2, Throwable th) {
        Log.wtf(str, str2, th);
    }

    /* renamed from: a */
    public boolean mo28905a() {
        return this.f11405a;
    }

    /* renamed from: b */
    public void mo28907b(String str, String str2) {
        mo28901a(6, str, str2);
    }

    /* renamed from: d */
    public void mo28910d(String str, String str2) {
        mo28901a(2, str, str2);
    }

    /* renamed from: a */
    public boolean mo28906a(int i) {
        return i >= this.f11406b;
    }

    /* renamed from: b */
    public void mo28908b(String str, String str2, Throwable th) {
        mo28902a(6, str, str2, th);
    }

    /* renamed from: c */
    public void mo28909c(String str, String str2) {
        mo28901a(2, str, str2);
    }

    /* renamed from: a */
    public void mo28901a(int i, String str, String str2) {
        mo28902a(i, str, str2, (Throwable) null);
    }

    /* renamed from: a */
    public void mo28902a(int i, String str, String str2, Throwable th) {
        if (mo28905a() && mo28906a(i)) {
            if (i == 5) {
                Log.w(str, str2, th);
            } else if (i == 6) {
                Log.e(str, str2, th);
            } else if (i == 8) {
                if (Integer.valueOf(Build.VERSION.SDK).intValue() > 8) {
                    m14365c(str, str2, th);
                } else {
                    Log.e(str, str2, th);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo28903a(String str, String str2) {
        mo28901a(5, str, str2);
    }

    /* renamed from: a */
    public void mo28904a(String str, String str2, Throwable th) {
        mo28902a(5, str, str2, th);
    }
}
