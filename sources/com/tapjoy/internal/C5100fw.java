package com.tapjoy.internal;

import com.tapjoy.internal.C3137gf;

/* renamed from: com.tapjoy.internal.fw */
public final class C5100fw {

    /* renamed from: a */
    public C5093fq f13955a;

    /* renamed from: b */
    public volatile C3137gf.C3139a f13956b;

    /* renamed from: c */
    public int f13957c;

    /* renamed from: d */
    public volatile C3137gf.C3139a f13958d;

    /* renamed from: e */
    public volatile C3137gf.C3139a f13959e;

    /* renamed from: a */
    public final void mo31263a() {
        mo31264a(16);
        C3137gf.C3139a aVar = this.f13958d;
        if (aVar != null) {
            this.f13958d = null;
            aVar.mo18526b().mo18529c();
        }
    }

    /* renamed from: a */
    public final synchronized void mo31264a(int i) {
        C3137gf.C3139a aVar = this.f13956b;
        if (aVar != null && this.f13957c < i) {
            int i2 = i | this.f13957c;
            this.f13957c = i2;
            aVar.mo18524a("state", (Object) Integer.valueOf(i2)).mo18526b().mo18529c();
        }
    }
}
