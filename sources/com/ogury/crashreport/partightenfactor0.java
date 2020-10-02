package com.ogury.crashreport;

import com.ogury.crashreport.rtf1;
import java.util.Iterator;

/* compiled from: Progressions.kt */
public class partightenfactor0 implements Iterable<Integer> {

    /* renamed from: a */
    public static final rtf1 f12219a = new rtf1((byte) 0);

    /* renamed from: b */
    private final int f12220b;

    /* renamed from: c */
    private final int f12221c;

    /* renamed from: d */
    private final int f12222d;

    /* compiled from: Progressions.kt */
    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(byte b) {
            this();
        }
    }

    public partightenfactor0(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i3 != Integer.MIN_VALUE) {
            this.f12220b = i;
            this.f12221c = rtf1.C6851rtf1.m15315a(i, i2, i3);
            this.f12222d = i3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    /* renamed from: a */
    public final int mo29605a() {
        return this.f12220b;
    }

    /* renamed from: b */
    public final int mo29606b() {
        return this.f12221c;
    }

    /* renamed from: c */
    public final int mo29607c() {
        return this.f12222d;
    }

    /* renamed from: d */
    public boolean mo29587d() {
        return this.f12222d > 0 ? this.f12220b > this.f12221c : this.f12220b < this.f12221c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof partightenfactor0)) {
            return false;
        }
        if (mo29587d() && ((partightenfactor0) obj).mo29587d()) {
            return true;
        }
        partightenfactor0 partightenfactor0 = (partightenfactor0) obj;
        return this.f12220b == partightenfactor0.f12220b && this.f12221c == partightenfactor0.f12221c && this.f12222d == partightenfactor0.f12222d;
    }

    public int hashCode() {
        if (mo29587d()) {
            return -1;
        }
        return (((this.f12220b * 31) + this.f12221c) * 31) + this.f12222d;
    }

    public /* synthetic */ Iterator iterator() {
        return new fs24(this.f12220b, this.f12221c, this.f12222d);
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f12222d > 0) {
            sb = new StringBuilder();
            sb.append(this.f12220b);
            sb.append("..");
            sb.append(this.f12221c);
            sb.append(" step ");
            i = this.f12222d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f12220b);
            sb.append(" downTo ");
            sb.append(this.f12221c);
            sb.append(" step ");
            i = -this.f12222d;
        }
        sb.append(i);
        return sb.toString();
    }
}
