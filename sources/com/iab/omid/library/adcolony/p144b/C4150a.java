package com.iab.omid.library.adcolony.p144b;

import com.iab.omid.library.adcolony.adsession.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.iab.omid.library.adcolony.b.a */
public class C4150a {

    /* renamed from: c */
    private static C4150a f11166c = new C4150a();

    /* renamed from: a */
    private final ArrayList<C4148a> f11167a = new ArrayList<>();

    /* renamed from: b */
    private final ArrayList<C4148a> f11168b = new ArrayList<>();

    private C4150a() {
    }

    /* renamed from: a */
    public static C4150a m13906a() {
        return f11166c;
    }

    /* renamed from: a */
    public void mo28504a(C4148a aVar) {
        this.f11167a.add(aVar);
    }

    /* renamed from: b */
    public Collection<C4148a> mo28505b() {
        return Collections.unmodifiableCollection(this.f11167a);
    }

    /* renamed from: b */
    public void mo28506b(C4148a aVar) {
        boolean d = mo28509d();
        this.f11168b.add(aVar);
        if (!d) {
            C4158f.m13949a().mo28541b();
        }
    }

    /* renamed from: c */
    public Collection<C4148a> mo28507c() {
        return Collections.unmodifiableCollection(this.f11168b);
    }

    /* renamed from: c */
    public void mo28508c(C4148a aVar) {
        boolean d = mo28509d();
        this.f11167a.remove(aVar);
        this.f11168b.remove(aVar);
        if (d && !mo28509d()) {
            C4158f.m13949a().mo28542c();
        }
    }

    /* renamed from: d */
    public boolean mo28509d() {
        return this.f11168b.size() > 0;
    }
}
