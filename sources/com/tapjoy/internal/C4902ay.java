package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.tapjoy.internal.ay */
public final class C4902ay extends AbstractSet implements Serializable, Set {

    /* renamed from: a */
    transient WeakHashMap f13372a;

    public C4902ay() {
        this(new WeakHashMap());
    }

    public final boolean add(Object obj) {
        return this.f13372a.put(obj, this) == null;
    }

    public final void clear() {
        this.f13372a.clear();
    }

    public final Object clone() {
        try {
            return (C4902ay) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean contains(Object obj) {
        return this.f13372a.containsKey(obj);
    }

    public final boolean isEmpty() {
        return this.f13372a.isEmpty();
    }

    public final Iterator iterator() {
        return this.f13372a.keySet().iterator();
    }

    public final boolean remove(Object obj) {
        return this.f13372a.remove(obj) != null;
    }

    public final int size() {
        return this.f13372a.size();
    }

    private C4902ay(WeakHashMap weakHashMap) {
        this.f13372a = weakHashMap;
    }
}
