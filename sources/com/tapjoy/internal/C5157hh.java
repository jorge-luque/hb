package com.tapjoy.internal;

import com.tapjoy.internal.C5196ij;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tapjoy.internal.hh */
public final class C5157hh implements C4935cf {

    /* renamed from: a */
    public final C3145gz f14102a;

    /* renamed from: b */
    Set f14103b = null;

    /* renamed from: c */
    private final Map f14104c = Collections.synchronizedMap(new HashMap());

    /* renamed from: d */
    private final Map f14105d = C5246ju.m17610a();

    public C5157hh(C3145gz gzVar) {
        this.f14102a = gzVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void mo18560a(C3131ca caVar, C5196ij.C5197a aVar) {
        if (caVar instanceof C5196ij) {
            List list = aVar.f14265b;
            if (list != null) {
                synchronized (this) {
                    this.f14103b = list instanceof Collection ? new HashSet(C5242js.m17608a(list)) : C5247jv.m17612a(list.iterator());
                }
            }
            C5196ij ijVar = (C5196ij) caVar;
            String str = ijVar.f14257c;
            boolean z = ijVar.f14258d;
            this.f14105d.remove(str);
            if (!z) {
                this.f14104c.put(str, aVar.f14264a);
            }
            C3151hg hgVar = aVar.f14264a;
            C5143ha haVar = this.f14102a.f8772p;
            if (hgVar instanceof C5156hf) {
                C5139gw.m17325a("No content for \"{}\"", str);
                haVar.mo30543a(str);
                return;
            }
            C5139gw.m17325a("New content for \"{}\" is ready", str);
            if (z) {
                hgVar.mo18598a(haVar, new C5100fw());
            } else {
                haVar.mo30546b(str);
            }
        } else {
            throw new IllegalStateException(caVar.getClass().getName());
        }
    }

    /* renamed from: a */
    public final void mo18559a(C3131ca caVar) {
        mo18560a(caVar, new C5196ij.C5197a(new C5156hf(), (List) null));
    }
}
