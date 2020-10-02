package com.iab.omid.library.oguryco.p150b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.oguryco.adsession.C4199a;
import com.iab.omid.library.oguryco.p149a.C4195b;
import com.iab.omid.library.oguryco.p149a.C4196c;
import com.iab.omid.library.oguryco.p149a.C4197d;
import com.iab.omid.library.oguryco.p149a.C4198e;
import com.iab.omid.library.oguryco.p150b.C4202b;
import com.iab.omid.library.oguryco.walking.TreeWalker;

/* renamed from: com.iab.omid.library.oguryco.b.f */
public class C4209f implements C4196c, C4202b.C4204a {

    /* renamed from: a */
    private static C4209f f11307a;

    /* renamed from: b */
    private float f11308b = 0.0f;

    /* renamed from: c */
    private final C4198e f11309c;

    /* renamed from: d */
    private final C4195b f11310d;

    /* renamed from: e */
    private C4197d f11311e;

    /* renamed from: f */
    private C4201a f11312f;

    public C4209f(C4198e eVar, C4195b bVar) {
        this.f11309c = eVar;
        this.f11310d = bVar;
    }

    /* renamed from: a */
    public static C4209f m14178a() {
        if (f11307a == null) {
            f11307a = new C4209f(new C4198e(), new C4195b());
        }
        return f11307a;
    }

    /* renamed from: e */
    private C4201a m14179e() {
        if (this.f11312f == null) {
            this.f11312f = C4201a.m14135a();
        }
        return this.f11312f;
    }

    /* renamed from: a */
    public void mo28619a(float f) {
        this.f11308b = f;
        for (C4199a adSessionStatePublisher : m14179e().mo28721c()) {
            adSessionStatePublisher.getAdSessionStatePublisher().mo28765a(f);
        }
    }

    /* renamed from: a */
    public void mo28754a(Context context) {
        this.f11311e = this.f11309c.mo28623a(new Handler(), context, this.f11310d.mo28618a(), this);
    }

    /* renamed from: a */
    public void mo28730a(boolean z) {
        if (z) {
            TreeWalker.getInstance().mo28790a();
        } else {
            TreeWalker.getInstance().mo28793c();
        }
    }

    /* renamed from: b */
    public void mo28755b() {
        C4202b.m14142a().mo28725a((C4202b.C4204a) this);
        C4202b.m14142a().mo28726b();
        if (C4202b.m14142a().mo28728d()) {
            TreeWalker.getInstance().mo28790a();
        }
        this.f11311e.mo28620a();
    }

    /* renamed from: c */
    public void mo28756c() {
        TreeWalker.getInstance().mo28792b();
        C4202b.m14142a().mo28727c();
        this.f11311e.mo28621b();
    }

    /* renamed from: d */
    public float mo28757d() {
        return this.f11308b;
    }
}
