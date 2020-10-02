package com.chartboost.sdk;

import com.chartboost.sdk.Banner.C2061a;
import com.chartboost.sdk.Banner.C2062b;
import com.chartboost.sdk.Banner.C2066e;
import com.chartboost.sdk.Model.C2093h;
import java.util.HashMap;

/* renamed from: com.chartboost.sdk.b */
public class C2100b implements C2066e {

    /* renamed from: a */
    private HashMap<String, C2061a> f7041a = new HashMap<>();

    /* renamed from: a */
    public void mo9180a(String str, C2061a aVar) {
        this.f7041a.put(str, aVar);
    }

    /* renamed from: b */
    public boolean mo9183b(String str) {
        C2062b bVar = this.f7041a.get(str);
        if (bVar != null) {
            return bVar.mo8999a();
        }
        return false;
    }

    /* renamed from: c */
    public void mo9184c(String str) {
        C2062b bVar = this.f7041a.get(str);
        if (bVar != null) {
            bVar.mo9001c();
        }
    }

    /* renamed from: d */
    public void mo9185d(String str) {
        C2062b bVar = this.f7041a.get(str);
        if (bVar != null) {
            bVar.mo9000b();
        }
    }

    /* renamed from: e */
    public void mo9186e(String str) {
        C2062b bVar = this.f7041a.get(str);
        if (bVar != null) {
            bVar.mo9002d();
        }
    }

    /* renamed from: a */
    public C2061a mo9179a(String str) {
        return this.f7041a.get(str);
    }

    /* renamed from: b */
    private C2093h.C2094a m8314b() {
        C2239j n = C2239j.m8897n();
        if (n != null) {
            return n.mo9605c();
        }
        return null;
    }

    /* renamed from: a */
    public void mo9181a(String str, String str2) {
        C2062b bVar = this.f7041a.get(str);
        if (bVar != null) {
            bVar.mo8998a(str2);
        }
    }

    /* renamed from: a */
    public boolean mo9182a() {
        C2093h.C2094a b = m8314b();
        if (b != null) {
            return b.mo9155c();
        }
        return true;
    }
}
