package com.criteo.publisher;

import com.criteo.publisher.model.AdUnit;
import com.criteo.publisher.model.C2439e;
import com.criteo.publisher.p054a0.C2321a;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.criteo.publisher.n */
public class C2495n {

    /* renamed from: a */
    private final Map<BidToken, C2439e> f7985a = new ConcurrentHashMap();

    /* renamed from: a */
    public BidToken mo10495a(C2439e eVar, AdUnit adUnit) {
        BidToken bidToken = new BidToken(UUID.randomUUID(), adUnit);
        this.f7985a.put(bidToken, eVar);
        return bidToken;
    }

    /* renamed from: a */
    public C2439e mo10496a(BidToken bidToken, C2321a aVar) {
        C2439e remove;
        if (bidToken == null || bidToken.mo10073a().getAdUnitType() != aVar || (remove = this.f7985a.remove(bidToken)) == null || remove.mo10352a()) {
            return null;
        }
        return remove;
    }
}
