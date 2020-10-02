package p163cz.msebera.android.httpclient.conn.p174r;

import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.conn.r.a */
/* compiled from: BasicRouteDirector */
public class C5644a implements C5646c {
    /* renamed from: a */
    public int mo33051a(C5648e eVar, C5648e eVar2) {
        C5886a.m18894a(eVar, "Planned route");
        if (eVar2 == null || eVar2.mo33055a() < 1) {
            return mo33050a(eVar);
        }
        if (eVar.mo33055a() > 1) {
            return mo33053c(eVar, eVar2);
        }
        return mo33052b(eVar, eVar2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo33052b(C5648e eVar, C5648e eVar2) {
        if (eVar2.mo33055a() > 1 || !eVar.mo33061e().equals(eVar2.mo33061e()) || eVar.mo33054B() != eVar2.mo33054B()) {
            return -1;
        }
        if (eVar.mo33060d() == null || eVar.mo33060d().equals(eVar2.mo33060d())) {
            return 0;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo33053c(C5648e eVar, C5648e eVar2) {
        int a;
        int a2;
        if (eVar2.mo33055a() <= 1 || !eVar.mo33061e().equals(eVar2.mo33061e()) || (a = eVar.mo33055a()) < (a2 = eVar2.mo33055a())) {
            return -1;
        }
        for (int i = 0; i < a2 - 1; i++) {
            if (!eVar.mo33056a(i).equals(eVar2.mo33056a(i))) {
                return -1;
            }
        }
        if (a > a2) {
            return 4;
        }
        if ((eVar2.mo33057b() && !eVar.mo33057b()) || (eVar2.mo33063f() && !eVar.mo33063f())) {
            return -1;
        }
        if (eVar.mo33057b() && !eVar2.mo33057b()) {
            return 3;
        }
        if (eVar.mo33063f() && !eVar2.mo33063f()) {
            return 5;
        }
        if (eVar.mo33054B() != eVar2.mo33054B()) {
            return -1;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo33050a(C5648e eVar) {
        return eVar.mo33055a() > 1 ? 2 : 1;
    }
}
