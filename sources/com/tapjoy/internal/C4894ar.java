package com.tapjoy.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* renamed from: com.tapjoy.internal.ar */
public final class C4894ar extends C3122aq {

    /* renamed from: a */
    private final LinkedHashMap f13362a = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: b */
    private int f13363b = 10;

    /* renamed from: a */
    private void m16679a() {
        int size = this.f13362a.size() - this.f13363b;
        if (size > 0) {
            Iterator it = this.f13362a.entrySet().iterator();
            while (size > 0 && it.hasNext()) {
                size--;
                it.next();
                it.remove();
            }
        }
    }

    /* renamed from: a */
    public final void mo18473a(Object obj, Object obj2) {
        super.mo18473a(obj, obj2);
        m16679a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C4891ao mo18474a(Object obj, boolean z) {
        C4890am amVar = (C4890am) this.f13362a.get(obj);
        if (amVar != null || !z) {
            return amVar;
        }
        C4890am amVar2 = new C4890am(obj);
        this.f13362a.put(obj, amVar2);
        m16679a();
        return amVar2;
    }
}
