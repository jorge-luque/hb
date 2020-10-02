package com.ogury.p159cm;

import com.ogury.p159cm.ConsentActivity;
import java.util.Iterator;

/* renamed from: com.ogury.cm.baaac */
public class baaac implements baaaa, Iterable<Integer> {

    /* renamed from: a */
    public static final aaaaa f12151a = new aaaaa((baaca) null);

    /* renamed from: b */
    private final int f12152b;

    /* renamed from: c */
    private final int f12153c;

    /* renamed from: d */
    private final int f12154d = 1;

    /* renamed from: com.ogury.cm.baaac$aaaaa */
    public static final class aaaaa {
        private aaaaa() {
        }

        public /* synthetic */ aaaaa(baaca baaca) {
            this();
        }
    }

    public baaac(int i, int i2, int i3) {
        this.f12152b = i;
        this.f12153c = ConsentActivity.aaaaa.m14875a(i, i2, 1);
    }

    /* renamed from: a */
    public final int mo29552a() {
        return this.f12152b;
    }

    /* renamed from: b */
    public final int mo29553b() {
        return this.f12153c;
    }

    /* renamed from: c */
    public final int mo29554c() {
        return this.f12154d;
    }

    /* renamed from: d */
    public boolean mo29555d() {
        return this.f12154d > 0 ? this.f12152b > this.f12153c : this.f12152b < this.f12153c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof baaac)) {
            return false;
        }
        if (mo29555d() && ((baaac) obj).mo29555d()) {
            return true;
        }
        baaac baaac = (baaac) obj;
        return this.f12152b == baaac.f12152b && this.f12153c == baaac.f12153c && this.f12154d == baaac.f12154d;
    }

    public int hashCode() {
        if (mo29555d()) {
            return -1;
        }
        return (((this.f12152b * 31) + this.f12153c) * 31) + this.f12154d;
    }

    public /* synthetic */ Iterator iterator() {
        return new baaba(this.f12152b, this.f12153c, this.f12154d);
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f12154d > 0) {
            sb = new StringBuilder();
            sb.append(this.f12152b);
            sb.append("..");
            sb.append(this.f12153c);
            sb.append(" step ");
            i = this.f12154d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f12152b);
            sb.append(" downTo ");
            sb.append(this.f12153c);
            sb.append(" step ");
            i = -this.f12154d;
        }
        sb.append(i);
        return sb.toString();
    }
}
