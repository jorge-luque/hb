package com.criteo.publisher.p054a0;

import android.util.Log;
import com.criteo.publisher.C2387i;

/* renamed from: com.criteo.publisher.a0.p */
public class C2341p {

    /* renamed from: a */
    private static final String f7707a = "p";

    /* renamed from: a */
    public static void m8996a(Throwable th) {
        Log.w(f7707a, th);
        if (C2387i.m9085U().mo10277j().mo10141n()) {
            throw new RuntimeException(th);
        }
    }

    /* renamed from: a */
    public static boolean m8997a(Object obj) {
        if (obj != null) {
            return true;
        }
        m8996a((Throwable) new NullPointerException("Expected non null value, but null occurs."));
        return false;
    }
}
