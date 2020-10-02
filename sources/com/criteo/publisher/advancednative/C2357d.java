package com.criteo.publisher.advancednative;

import java.net.URL;

/* renamed from: com.criteo.publisher.advancednative.d */
final class C2357d extends CriteoMedia {

    /* renamed from: a */
    private final URL f7734a;

    C2357d(URL url) {
        if (url != null) {
            this.f7734a = url;
            return;
        }
        throw new NullPointerException("Null imageUrl");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CriteoMedia) {
            return this.f7734a.equals(((CriteoMedia) obj).getImageUrl());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public URL getImageUrl() {
        return this.f7734a;
    }

    public int hashCode() {
        return this.f7734a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "CriteoMedia{imageUrl=" + this.f7734a + "}";
    }
}
