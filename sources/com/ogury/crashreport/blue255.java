package com.ogury.crashreport;

/* compiled from: Crash.kt */
public final class blue255 extends ansi {

    /* renamed from: a */
    private final String f12191a;

    /* renamed from: b */
    private final String f12192b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public blue255(String str, String str2) {
        super((byte) 0);
        tx7920.m15333b(str, "crash");
        tx7920.m15333b(str2, "packageName");
        this.f12191a = str;
        this.f12192b = str2;
    }

    /* renamed from: a */
    public final String mo29582a() {
        return this.f12191a;
    }

    /* renamed from: b */
    public final String mo29583b() {
        return this.f12192b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof blue255)) {
            return false;
        }
        blue255 blue255 = (blue255) obj;
        return tx7920.m15332a((Object) this.f12191a, (Object) blue255.f12191a) && tx7920.m15332a((Object) this.f12192b, (Object) blue255.f12192b);
    }

    public final int hashCode() {
        String str = this.f12191a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f12192b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        return "PresageCrash(crash=" + this.f12191a + ", packageName=" + this.f12192b + ")";
    }
}
