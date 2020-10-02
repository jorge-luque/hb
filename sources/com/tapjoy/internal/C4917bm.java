package com.tapjoy.internal;

import java.io.Writer;

/* renamed from: com.tapjoy.internal.bm */
public final class C4917bm implements C4916bl {

    /* renamed from: a */
    public final String f13380a;

    public C4917bm(String str) {
        this.f13380a = str;
    }

    /* renamed from: a */
    public final void mo30993a(Writer writer) {
        writer.write(this.f13380a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C4917bm) {
            return this.f13380a.equals(((C4917bm) obj).f13380a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f13380a.hashCode();
    }

    public final String toString() {
        return this.f13380a;
    }
}
