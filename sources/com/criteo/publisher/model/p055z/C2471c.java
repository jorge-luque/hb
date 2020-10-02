package com.criteo.publisher.model.p055z;

import java.net.URL;

/* renamed from: com.criteo.publisher.model.z.c */
abstract class C2471c extends C2490o {

    /* renamed from: a */
    private final URL f7952a;

    C2471c(URL url) {
        if (url != null) {
            this.f7952a = url;
            return;
        }
        throw new NullPointerException("Null url");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public URL mo10448a() {
        return this.f7952a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2490o) {
            return this.f7952a.equals(((C2490o) obj).mo10448a());
        }
        return false;
    }

    public int hashCode() {
        return this.f7952a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "NativeImage{url=" + this.f7952a + "}";
    }
}
