package com.iab.omid.library.adcolony.p144b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.adcolony.adsession.C4148a;
import com.iab.omid.library.adcolony.p143a.C4144b;
import com.iab.omid.library.adcolony.p143a.C4145c;
import com.iab.omid.library.adcolony.p143a.C4146d;
import com.iab.omid.library.adcolony.p143a.C4147e;
import com.iab.omid.library.adcolony.p144b.C4151b;
import com.iab.omid.library.adcolony.walking.TreeWalker;

/* renamed from: com.iab.omid.library.adcolony.b.f */
public class C4158f implements C4145c, C4151b.C4152a {

    /* renamed from: f */
    private static C4158f f11186f;

    /* renamed from: a */
    private float f11187a = 0.0f;

    /* renamed from: b */
    private final C4147e f11188b;

    /* renamed from: c */
    private final C4144b f11189c;

    /* renamed from: d */
    private C4146d f11190d;

    /* renamed from: e */
    private C4150a f11191e;

    public C4158f(C4147e eVar, C4144b bVar) {
        this.f11188b = eVar;
        this.f11189c = bVar;
    }

    /* renamed from: a */
    public static C4158f m13949a() {
        if (f11186f == null) {
            f11186f = new C4158f(new C4147e(), new C4144b());
        }
        return f11186f;
    }

    /* renamed from: e */
    private C4150a m13950e() {
        if (this.f11191e == null) {
            this.f11191e = C4150a.m13906a();
        }
        return this.f11191e;
    }

    /* renamed from: a */
    public void mo28431a(float f) {
        this.f11187a = f;
        for (C4148a adSessionStatePublisher : m13950e().mo28507c()) {
            adSessionStatePublisher.getAdSessionStatePublisher().mo28551a(f);
        }
    }

    /* renamed from: a */
    public void mo28540a(Context context) {
        this.f11190d = this.f11188b.mo28435a(new Handler(), context, this.f11189c.mo28430a(), this);
    }

    /* renamed from: a */
    public void mo28515a(boolean z) {
        if (z) {
            TreeWalker.getInstance().mo28576a();
        } else {
            TreeWalker.getInstance().mo28579c();
        }
    }

    /* renamed from: b */
    public void mo28541b() {
        C4151b.m13913a().mo28511a((C4151b.C4152a) this);
        C4151b.m13913a().mo28512b();
        if (C4151b.m13913a().mo28514d()) {
            TreeWalker.getInstance().mo28576a();
        }
        this.f11190d.mo28432a();
    }

    /* renamed from: c */
    public void mo28542c() {
        TreeWalker.getInstance().mo28578b();
        C4151b.m13913a().mo28513c();
        this.f11190d.mo28433b();
    }

    /* renamed from: d */
    public float mo28543d() {
        return this.f11187a;
    }
}
