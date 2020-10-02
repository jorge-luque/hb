package com.ogury.crashreport;

/* compiled from: Ranges.kt */
public final class cf0 extends partightenfactor0 {

    /* compiled from: Ranges.kt */
    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(byte b) {
            this();
        }
    }

    static {
        new rtf1((byte) 0);
        new cf0(1, 0);
    }

    public cf0(int i, int i2) {
        super(i, i2, 1);
    }

    /* renamed from: d */
    public final boolean mo29587d() {
        return mo29605a() > mo29606b();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof cf0)) {
            return false;
        }
        if (mo29587d() && ((cf0) obj).mo29587d()) {
            return true;
        }
        cf0 cf0 = (cf0) obj;
        return mo29605a() == cf0.mo29605a() && mo29606b() == cf0.mo29606b();
    }

    public final int hashCode() {
        if (mo29587d()) {
            return -1;
        }
        return (mo29605a() * 31) + mo29606b();
    }

    public final String toString() {
        return mo29605a() + ".." + mo29606b();
    }
}
