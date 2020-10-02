package com.criteo.publisher.model;

import com.criteo.publisher.p054a0.C2321a;
import com.criteo.publisher.p054a0.C2340o;

public final class BannerAdUnit extends AdUnit {

    /* renamed from: c */
    private final AdSize f7850c;

    public BannerAdUnit(String str, AdSize adSize) {
        super(str, C2321a.CRITEO_BANNER);
        this.f7850c = adSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BannerAdUnit.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        return C2340o.m8994a(this.f7850c, ((BannerAdUnit) obj).f7850c);
    }

    public AdSize getSize() {
        return this.f7850c;
    }

    public int hashCode() {
        return C2340o.m8993a(Integer.valueOf(super.hashCode()), this.f7850c);
    }
}
