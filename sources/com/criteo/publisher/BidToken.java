package com.criteo.publisher;

import com.criteo.publisher.model.AdUnit;
import java.util.UUID;

public final class BidToken {

    /* renamed from: a */
    private final UUID f7627a;

    /* renamed from: b */
    private final AdUnit f7628b;

    BidToken(UUID uuid, AdUnit adUnit) {
        this.f7627a = uuid == null ? UUID.randomUUID() : uuid;
        this.f7628b = adUnit;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AdUnit mo10073a() {
        return this.f7628b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BidToken.class != obj.getClass()) {
            return false;
        }
        BidToken bidToken = (BidToken) obj;
        if (!this.f7627a.equals(bidToken.f7627a)) {
            return false;
        }
        AdUnit adUnit = this.f7628b;
        AdUnit adUnit2 = bidToken.f7628b;
        if (adUnit != null) {
            return adUnit.equals(adUnit2);
        }
        if (adUnit2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f7627a.hashCode() * 31;
        AdUnit adUnit = this.f7628b;
        return hashCode + (adUnit != null ? adUnit.hashCode() : 0);
    }
}
