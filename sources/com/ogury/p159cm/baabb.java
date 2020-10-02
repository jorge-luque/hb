package com.ogury.p159cm;

/* renamed from: com.ogury.cm.baabb */
public final class baabb extends baaac {

    /* renamed from: b */
    public static final aaaaa f12159b = new aaaaa((baaca) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final baabb f12160c = new baabb(1, 0);

    /* renamed from: com.ogury.cm.baabb$aaaaa */
    public static final class aaaaa {
        private aaaaa() {
        }

        public /* synthetic */ aaaaa(baaca baaca) {
            this();
        }
    }

    public baabb(int i, int i2) {
        super(i, i2, 1);
    }

    /* renamed from: d */
    public final boolean mo29555d() {
        return mo29552a() > mo29553b();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof baabb)) {
            return false;
        }
        if (mo29555d() && ((baabb) obj).mo29555d()) {
            return true;
        }
        baabb baabb = (baabb) obj;
        return mo29552a() == baabb.mo29552a() && mo29553b() == baabb.mo29553b();
    }

    public final int hashCode() {
        if (mo29555d()) {
            return -1;
        }
        return (mo29552a() * 31) + mo29553b();
    }

    public final String toString() {
        return mo29552a() + ".." + mo29553b();
    }
}
