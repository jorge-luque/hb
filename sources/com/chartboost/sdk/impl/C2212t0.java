package com.chartboost.sdk.impl;

import com.chartboost.sdk.Model.CBError;

/* renamed from: com.chartboost.sdk.impl.t0 */
public class C2212t0<T> {

    /* renamed from: a */
    public final T f7459a;

    /* renamed from: b */
    public final CBError f7460b;

    private C2212t0(T t, CBError cBError) {
        this.f7459a = t;
        this.f7460b = cBError;
    }

    /* renamed from: a */
    public static <T> C2212t0<T> m8774a(T t) {
        return new C2212t0<>(t, (CBError) null);
    }

    /* renamed from: a */
    public static <T> C2212t0<T> m8773a(CBError cBError) {
        return new C2212t0<>((Object) null, cBError);
    }
}
