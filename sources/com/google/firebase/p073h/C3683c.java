package com.google.firebase.p073h;

import com.google.firebase.components.C3634d;
import com.google.firebase.components.C3637e;
import com.google.firebase.components.C3642g;
import com.google.firebase.components.C3652n;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.google.firebase.h.c */
/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public class C3683c implements C3687h {

    /* renamed from: a */
    private final String f10259a;

    /* renamed from: b */
    private final C3684d f10260b;

    C3683c(Set<C3099f> set, C3684d dVar) {
        this.f10259a = m12514a(set);
        this.f10260b = dVar;
    }

    /* renamed from: b */
    public static C3634d<C3687h> m12515b() {
        C3634d.C3636b<C3687h> a = C3634d.m12372a(C3687h.class);
        a.mo27232a(C3652n.m12431c(C3099f.class));
        a.mo27231a((C3642g<C3687h>) C3682b.m12511a());
        return a.mo27233b();
    }

    /* renamed from: a */
    public String mo27287a() {
        if (this.f10260b.mo27288a().isEmpty()) {
            return this.f10259a;
        }
        return this.f10259a + ' ' + m12514a(this.f10260b.mo27288a());
    }

    /* renamed from: a */
    private static String m12514a(Set<C3099f> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<C3099f> it = set.iterator();
        while (it.hasNext()) {
            C3099f next = it.next();
            sb.append(next.mo18328a());
            sb.append('/');
            sb.append(next.mo18329b());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    static /* synthetic */ C3687h m12513a(C3637e eVar) {
        return new C3683c(eVar.mo27221d(C3099f.class), C3684d.m12517b());
    }
}
