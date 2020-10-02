package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.tapjoy.internal.en */
final class C5025en extends AbstractList implements Serializable, RandomAccess {

    /* renamed from: a */
    private final ArrayList f13612a;

    C5025en(List list) {
        this.f13612a = new ArrayList(list);
    }

    public final Object get(int i) {
        return this.f13612a.get(i);
    }

    public final int size() {
        return this.f13612a.size();
    }

    public final Object[] toArray() {
        return this.f13612a.toArray();
    }
}
