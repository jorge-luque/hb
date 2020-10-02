package com.criteo.publisher.model;

import com.criteo.publisher.p054a0.C2321a;
import com.criteo.publisher.p054a0.C2340o;

public final class NativeAdUnit extends AdUnit {

    /* renamed from: c */
    private final AdSize f7851c = new AdSize(2, 2);

    public NativeAdUnit(String str) {
        super(str, C2321a.CRITEO_CUSTOM_NATIVE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NativeAdUnit.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        return C2340o.m8994a(this.f7851c, ((NativeAdUnit) obj).f7851c);
    }

    public AdSize getAdSize() {
        return this.f7851c;
    }

    public int hashCode() {
        return C2340o.m8993a(Integer.valueOf(super.hashCode()), this.f7851c);
    }
}
