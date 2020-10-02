package com.ogury.p159cm;

import java.util.Iterator;

/* renamed from: com.ogury.cm.acbbc */
public abstract class acbbc implements baaaa, Iterator<Integer> {
    /* renamed from: a */
    public abstract int mo29532a();

    public /* synthetic */ Object next() {
        return Integer.valueOf(mo29532a());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
