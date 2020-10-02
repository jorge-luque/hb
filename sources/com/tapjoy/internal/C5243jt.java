package com.tapjoy.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.tapjoy.internal.jt */
public final class C5243jt {

    /* renamed from: a */
    static final C5248jw f14427a = new C5248jw() {
        public final boolean hasNext() {
            return false;
        }

        public final Object next() {
            throw new NoSuchElementException();
        }
    };

    /* renamed from: b */
    private static final Iterator f14428b = new Iterator() {
        public final boolean hasNext() {
            return false;
        }

        public final Object next() {
            throw new NoSuchElementException();
        }

        public final void remove() {
            throw new IllegalStateException();
        }
    };

    /* renamed from: a */
    public static Object m17609a(Iterator it) {
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }
}
