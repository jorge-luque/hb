package com.chartboost.sdk.impl;

import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.C2128c1;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.i */
public class C2157i implements C2128c1.C2129a {

    /* renamed from: a */
    private final C2143g f7256a;

    /* renamed from: b */
    private final String f7257b;

    public C2157i(C2143g gVar, String str) {
        this.f7256a = gVar;
        this.f7257b = str;
    }

    /* renamed from: a */
    public void mo9300a(C2128c1 c1Var, JSONObject jSONObject) {
        if (this.f7256a.f7183p.f7108h || C2242k.f7618r) {
            synchronized (this.f7256a) {
                this.f7256a.mo9340b(this.f7257b);
            }
        }
    }

    /* renamed from: a */
    public void mo9299a(C2128c1 c1Var, CBError cBError) {
        C2143g gVar = this.f7256a;
        if (gVar.f7183p.f7108h) {
            synchronized (gVar) {
                this.f7256a.mo9340b(this.f7257b);
            }
        }
    }
}
