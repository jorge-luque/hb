package com.tapjoy.internal;

import android.view.ViewGroup;
import java.util.Iterator;

/* renamed from: com.tapjoy.internal.ac */
public final class C4876ac {

    /* renamed from: com.tapjoy.internal.ac$a */
    static class C4878a implements Iterator {

        /* renamed from: a */
        private final ViewGroup f13314a;

        /* renamed from: b */
        private int f13315b;

        /* renamed from: c */
        private int f13316c = 0;

        public C4878a(ViewGroup viewGroup) {
            this.f13314a = viewGroup;
            this.f13315b = viewGroup.getChildCount();
        }

        public final boolean hasNext() {
            return this.f13316c < this.f13315b;
        }

        public final /* synthetic */ Object next() {
            ViewGroup viewGroup = this.f13314a;
            int i = this.f13316c;
            this.f13316c = i + 1;
            return viewGroup.getChildAt(i);
        }

        public final void remove() {
            this.f13314a.removeViewAt(this.f13316c - 1);
        }
    }

    /* renamed from: a */
    public static Iterable m16662a(ViewGroup viewGroup) {
        final C4878a aVar = new C4878a(viewGroup);
        return new Iterable() {
            public final Iterator iterator() {
                return aVar;
            }
        };
    }
}
