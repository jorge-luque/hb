package com.applovin.impl.mediation.p037a.p038a;

import android.content.Context;
import com.applovin.impl.sdk.utils.C1991g;

/* renamed from: com.applovin.impl.mediation.a.a.f */
public class C1654f {

    /* renamed from: a */
    private final String f5183a;

    /* renamed from: b */
    private final String f5184b;

    /* renamed from: c */
    private final boolean f5185c;

    C1654f(String str, String str2, Context context) {
        this.f5183a = str.replace("android.permission.", "");
        this.f5184b = str2;
        this.f5185c = C1991g.m7838a(str, context);
    }

    /* renamed from: a */
    public String mo7671a() {
        return this.f5183a;
    }

    /* renamed from: b */
    public String mo7672b() {
        return this.f5184b;
    }

    /* renamed from: c */
    public boolean mo7673c() {
        return this.f5185c;
    }
}
