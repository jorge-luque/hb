package com.tapjoy.internal;

import java.util.AbstractQueue;
import java.util.Iterator;

/* renamed from: com.tapjoy.internal.at */
public abstract class C4896at extends AbstractQueue implements C4901ax {
    public Iterator iterator() {
        return new Iterator() {

            /* renamed from: b */
            private int f13365b = 0;

            public final boolean hasNext() {
                return this.f13365b < C4896at.this.size();
            }

            public final Object next() {
                C4896at atVar = C4896at.this;
                int i = this.f13365b;
                this.f13365b = i + 1;
                return atVar.mo30931a(i);
            }

            public final void remove() {
                if (this.f13365b == 1) {
                    C4896at.this.mo30932b(1);
                    this.f13365b = 0;
                    return;
                }
                throw new UnsupportedOperationException("For the first element only");
            }
        };
    }
}
