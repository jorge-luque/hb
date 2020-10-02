package com.ogury.p159cm;

import java.io.Serializable;

/* renamed from: com.ogury.cm.acbaa */
public final class acbaa<A, B> implements Serializable {

    /* renamed from: a */
    private final A f12135a;

    /* renamed from: b */
    private final B f12136b;

    public acbaa(A a, B b) {
        this.f12135a = a;
        this.f12136b = b;
    }

    /* renamed from: a */
    public final A mo29524a() {
        return this.f12135a;
    }

    /* renamed from: b */
    public final B mo29525b() {
        return this.f12136b;
    }

    /* renamed from: c */
    public final A mo29526c() {
        return this.f12135a;
    }

    /* renamed from: d */
    public final B mo29527d() {
        return this.f12136b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof acbaa)) {
            return false;
        }
        acbaa acbaa = (acbaa) obj;
        return accbb.m15217a((Object) this.f12135a, (Object) acbaa.f12135a) && accbb.m15217a((Object) this.f12136b, (Object) acbaa.f12136b);
    }

    public final int hashCode() {
        A a = this.f12135a;
        int i = 0;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b = this.f12136b;
        if (b != null) {
            i = b.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        return "(" + this.f12135a + ", " + this.f12136b + ')';
    }
}
