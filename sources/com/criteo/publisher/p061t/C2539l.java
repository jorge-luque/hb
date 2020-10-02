package com.criteo.publisher.p061t;

import com.criteo.publisher.p061t.C2548r;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.criteo.publisher.t.l */
class C2539l extends C2548r {

    /* renamed from: c */
    private static final String f8076c = "l";

    /* renamed from: a */
    private final C2542n f8077a;

    /* renamed from: b */
    private final ConcurrentMap<File, C2561y> f8078b = new ConcurrentHashMap();

    C2539l(C2542n nVar) {
        this.f8077a = nVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10574a(String str, C2548r.C2549a aVar) {
        try {
            m9530a(this.f8077a.mo10583a(str)).mo10600a(aVar);
        } catch (IOException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo10576b() {
        int i = 0;
        for (File length : this.f8077a.mo10584b()) {
            i = (int) (((long) i) + length.length());
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10573a(String str, C2544o oVar) {
        try {
            m9530a(this.f8077a.mo10583a(str)).mo10599a(oVar);
        } catch (IOException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Collection<C2540m> mo10572a() {
        Collection<File> b = this.f8077a.mo10584b();
        ArrayList arrayList = new ArrayList(b.size());
        for (File a : b) {
            try {
                arrayList.add(m9530a(a).mo10601b());
            } catch (IOException unused) {
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10575a(String str) {
        return this.f8077a.mo10584b().contains(this.f8077a.mo10583a(str));
    }

    /* renamed from: a */
    private C2561y m9530a(File file) {
        C2561y yVar = (C2561y) this.f8078b.get(file);
        if (yVar != null) {
            return yVar;
        }
        C2561y a = this.f8077a.mo10581a(file);
        C2561y putIfAbsent = this.f8078b.putIfAbsent(file, a);
        return putIfAbsent == null ? a : putIfAbsent;
    }
}
