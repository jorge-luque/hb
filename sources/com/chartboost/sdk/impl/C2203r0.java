package com.chartboost.sdk.impl;

import com.chartboost.sdk.Model.CBError;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.chartboost.sdk.impl.r0 */
public class C2203r0<T> {

    /* renamed from: a */
    public final String f7432a;

    /* renamed from: b */
    public final String f7433b;

    /* renamed from: c */
    public final int f7434c;

    /* renamed from: d */
    public final AtomicInteger f7435d = new AtomicInteger();

    /* renamed from: e */
    public final File f7436e;

    /* renamed from: f */
    public long f7437f;

    /* renamed from: g */
    public long f7438g;

    /* renamed from: h */
    public long f7439h;

    /* renamed from: i */
    public int f7440i;

    public C2203r0(String str, String str2, int i, File file) {
        this.f7432a = str;
        this.f7433b = str2;
        this.f7434c = i;
        this.f7436e = file;
        this.f7437f = 0;
        this.f7438g = 0;
        this.f7439h = 0;
        this.f7440i = 0;
    }

    /* renamed from: a */
    public C2209s0 mo9289a() {
        return new C2209s0((Map<String, String>) null, (byte[]) null, (String) null);
    }

    /* renamed from: a */
    public void mo9291a(CBError cBError, C2215u0 u0Var) {
    }

    /* renamed from: a */
    public void mo9292a(T t, C2215u0 u0Var) {
    }

    /* renamed from: b */
    public boolean mo9499b() {
        return this.f7435d.compareAndSet(0, -1);
    }

    /* renamed from: a */
    public C2212t0<T> mo9290a(C2215u0 u0Var) {
        return C2212t0.m8774a(null);
    }
}
