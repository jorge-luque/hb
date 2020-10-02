package com.ogury.p159cm;

import java.util.Iterator;

/* renamed from: com.ogury.cm.baacb */
public final class baacb<T, R> implements baabc<R> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final baabc<T> f12161a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final accac<T, R> f12162b;

    /* renamed from: com.ogury.cm.baacb$aaaaa */
    public static final class aaaaa implements baaaa, Iterator<R> {

        /* renamed from: a */
        final /* synthetic */ baacb f12163a;

        /* renamed from: b */
        private final Iterator<T> f12164b;

        aaaaa(baacb baacb) {
            this.f12163a = baacb;
            this.f12164b = baacb.f12161a.mo29561a();
        }

        public final boolean hasNext() {
            return this.f12164b.hasNext();
        }

        public final R next() {
            return this.f12163a.f12162b.mo29401a(this.f12164b.next());
        }

        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public baacb(baabc<? extends T> baabc, accac<? super T, ? extends R> accac) {
        accbb.m15218b(baabc, "sequence");
        accbb.m15218b(accac, "transformer");
        this.f12161a = baabc;
        this.f12162b = accac;
    }

    /* renamed from: a */
    public final Iterator<R> mo29561a() {
        return new aaaaa(this);
    }
}
