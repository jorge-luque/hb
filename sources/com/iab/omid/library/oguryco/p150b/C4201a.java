package com.iab.omid.library.oguryco.p150b;

import com.iab.omid.library.oguryco.adsession.C4199a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.iab.omid.library.oguryco.b.a */
public class C4201a {

    /* renamed from: a */
    private static C4201a f11287a = new C4201a();

    /* renamed from: b */
    private final ArrayList<C4199a> f11288b = new ArrayList<>();

    /* renamed from: c */
    private final ArrayList<C4199a> f11289c = new ArrayList<>();

    private C4201a() {
    }

    /* renamed from: a */
    public static C4201a m14135a() {
        return f11287a;
    }

    /* renamed from: a */
    public void mo28718a(C4199a aVar) {
        this.f11288b.add(aVar);
    }

    /* renamed from: b */
    public Collection<C4199a> mo28719b() {
        return Collections.unmodifiableCollection(this.f11288b);
    }

    /* renamed from: b */
    public void mo28720b(C4199a aVar) {
        boolean d = mo28723d();
        this.f11289c.add(aVar);
        if (!d) {
            C4209f.m14178a().mo28755b();
        }
    }

    /* renamed from: c */
    public Collection<C4199a> mo28721c() {
        return Collections.unmodifiableCollection(this.f11289c);
    }

    /* renamed from: c */
    public void mo28722c(C4199a aVar) {
        boolean d = mo28723d();
        this.f11288b.remove(aVar);
        this.f11289c.remove(aVar);
        if (d && !mo28723d()) {
            C4209f.m14178a().mo28756c();
        }
    }

    /* renamed from: d */
    public boolean mo28723d() {
        return this.f11289c.size() > 0;
    }
}
