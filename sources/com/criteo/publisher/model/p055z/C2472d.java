package com.criteo.publisher.model.p055z;

import java.net.URL;

/* renamed from: com.criteo.publisher.model.z.d */
abstract class C2472d extends C2491p {

    /* renamed from: a */
    private final URL f7953a;

    C2472d(URL url) {
        if (url != null) {
            this.f7953a = url;
            return;
        }
        throw new NullPointerException("Null url");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public URL mo10452a() {
        return this.f7953a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2491p) {
            return this.f7953a.equals(((C2491p) obj).mo10452a());
        }
        return false;
    }

    public int hashCode() {
        return this.f7953a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "NativeImpressionPixel{url=" + this.f7953a + "}";
    }
}
