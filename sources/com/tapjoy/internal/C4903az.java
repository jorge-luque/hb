package com.tapjoy.internal;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/* renamed from: com.tapjoy.internal.az */
public final class C4903az extends AbstractMap {

    /* renamed from: a */
    private final HashMap f13373a = new HashMap();

    /* renamed from: b */
    private final C4929bx f13374b = new C4929bx();

    /* renamed from: a */
    private static Object m16691a(C4928bw bwVar) {
        if (bwVar != null) {
            return bwVar.get();
        }
        return null;
    }

    /* renamed from: b */
    private void m16692b() {
        while (true) {
            C4928bw a = this.f13374b.mo31016a();
            if (a != null) {
                this.f13373a.remove(a.f13424a);
            } else {
                return;
            }
        }
    }

    public final void clear() {
        this.f13373a.clear();
        do {
        } while (this.f13374b.mo31016a() != null);
    }

    public final boolean containsKey(Object obj) {
        m16692b();
        return this.f13373a.containsKey(obj);
    }

    public final boolean containsValue(Object obj) {
        m16692b();
        for (C4928bw bwVar : this.f13373a.values()) {
            if (obj.equals(bwVar.get())) {
                return true;
            }
        }
        return false;
    }

    public final Set entrySet() {
        m16692b();
        throw new UnsupportedOperationException();
    }

    public final boolean equals(Object obj) {
        m16692b();
        throw new UnsupportedOperationException();
    }

    public final Object get(Object obj) {
        m16692b();
        return m16691a((C4928bw) this.f13373a.get(obj));
    }

    public final int hashCode() {
        m16692b();
        throw new UnsupportedOperationException();
    }

    public final Set keySet() {
        m16692b();
        return this.f13373a.keySet();
    }

    public final Object put(Object obj, Object obj2) {
        m16692b();
        return m16691a((C4928bw) this.f13373a.put(obj, new C4928bw(obj, obj2, this.f13374b)));
    }

    public final Object remove(Object obj) {
        m16692b();
        return m16691a((C4928bw) this.f13373a.remove(obj));
    }

    public final int size() {
        m16692b();
        return this.f13373a.size();
    }

    public final String toString() {
        m16692b();
        throw new UnsupportedOperationException();
    }

    public final Collection values() {
        m16692b();
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public static C4903az m16690a() {
        return new C4903az();
    }
}
