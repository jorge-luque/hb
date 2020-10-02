package com.chartboost.sdk.impl;

import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.CBError;
import java.io.File;
import java.util.HashMap;

/* renamed from: com.chartboost.sdk.impl.m */
class C2177m extends C2203r0<Void> {

    /* renamed from: j */
    private final C2181n f7346j;

    /* renamed from: k */
    private final C2222w0 f7347k;

    /* renamed from: l */
    final C2173l f7348l;

    C2177m(C2181n nVar, C2222w0 w0Var, C2173l lVar, File file) {
        super("GET", lVar.f7319d, 2, file);
        this.f7440i = 1;
        this.f7346j = nVar;
        this.f7347k = w0Var;
        this.f7348l = lVar;
    }

    /* renamed from: a */
    public C2209s0 mo9289a() {
        HashMap hashMap = new HashMap();
        hashMap.put("X-Chartboost-App", C2242k.f7610j);
        hashMap.put("X-Chartboost-Client", CBUtility.m8175f());
        hashMap.put("X-Chartboost-Reachability", Integer.toString(this.f7347k.mo9537a()));
        return new C2209s0(hashMap, (byte[]) null, (String) null);
    }

    /* renamed from: a */
    public void mo9292a(Void voidR, C2215u0 u0Var) {
        this.f7346j.mo9433a(this, (CBError) null, (C2215u0) null);
    }

    /* renamed from: a */
    public void mo9291a(CBError cBError, C2215u0 u0Var) {
        this.f7346j.mo9433a(this, cBError, u0Var);
    }
}
