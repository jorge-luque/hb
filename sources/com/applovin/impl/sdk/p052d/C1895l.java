package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p049ad.C1818b;
import com.applovin.impl.sdk.p049ad.C1821d;
import com.applovin.impl.sdk.utils.C1989e;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.d.l */
public class C1895l extends C1896m {

    /* renamed from: a */
    private final List<String> f6264a;

    public C1895l(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener, C1941j jVar) {
        super(C1821d.m6859a(m7301a(list), jVar), appLovinAdLoadListener, "TaskFetchMultizoneAd", jVar);
        this.f6264a = Collections.unmodifiableList(list);
    }

    /* renamed from: a */
    private static String m7301a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        throw new IllegalArgumentException("No zone identifiers specified");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<String, String> mo8459a() {
        HashMap hashMap = new HashMap(1);
        List<String> list = this.f6264a;
        hashMap.put("zone_ids", C2025o.m7966e(C1989e.m7827a((Collection<String>) list, list.size())));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1818b mo8460b() {
        return C1818b.APPLOVIN_MULTIZONE;
    }
}
