package com.ogury.p159cm;

import com.ogury.core.OguryError;

/* renamed from: com.ogury.cm.abbca */
public final class abbca {

    /* renamed from: a */
    private final boolean f12087a;

    /* renamed from: b */
    private final OguryError f12088b;

    public abbca(boolean z, OguryError oguryError) {
        accbb.m15218b(oguryError, "error");
        this.f12087a = z;
        this.f12088b = oguryError;
    }

    public /* synthetic */ abbca(boolean z, OguryError oguryError, int i, baaca baaca) {
        this(true, new OguryError(0, ""));
    }

    /* renamed from: a */
    public final boolean mo29482a() {
        return this.f12087a;
    }

    /* renamed from: b */
    public final OguryError mo29483b() {
        return this.f12088b;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof abbca) {
                abbca abbca = (abbca) obj;
                if (!(this.f12087a == abbca.f12087a) || !accbb.m15217a((Object) this.f12088b, (Object) abbca.f12088b)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.f12087a;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        OguryError oguryError = this.f12088b;
        return i + (oguryError != null ? oguryError.hashCode() : 0);
    }

    public final String toString() {
        return "ResponseStatus(status=" + this.f12087a + ", error=" + this.f12088b + ")";
    }
}
