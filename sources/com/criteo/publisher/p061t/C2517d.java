package com.criteo.publisher.p061t;

import com.criteo.publisher.p061t.C2551t;

/* renamed from: com.criteo.publisher.t.d */
abstract class C2517d extends C2551t.C2553b {

    /* renamed from: a */
    private final String f8028a;

    /* renamed from: b */
    private final boolean f8029b;

    C2517d(String str, boolean z) {
        this.f8028a = str;
        this.f8029b = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10559a() {
        return this.f8029b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo10560b() {
        return this.f8028a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2551t.C2553b)) {
            return false;
        }
        C2551t.C2553b bVar = (C2551t.C2553b) obj;
        String str = this.f8028a;
        if (str != null ? str.equals(bVar.mo10560b()) : bVar.mo10560b() == null) {
            if (this.f8029b == bVar.mo10559a()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f8028a;
        return (((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ (this.f8029b ? 1231 : 1237);
    }

    public String toString() {
        return "MetricRequestSlot{impressionId=" + this.f8028a + ", cachedBidUsed=" + this.f8029b + "}";
    }
}
