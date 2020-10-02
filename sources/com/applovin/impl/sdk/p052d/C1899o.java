package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p049ad.C1818b;
import com.applovin.impl.sdk.p049ad.C1819c;
import com.applovin.impl.sdk.p049ad.C1821d;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.d.o */
public class C1899o extends C1896m {

    /* renamed from: a */
    private final C1819c f6270a;

    public C1899o(C1819c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1941j jVar) {
        super(C1821d.m6859a("adtoken_zone", jVar), appLovinAdLoadListener, "TaskFetchTokenAd", jVar);
        this.f6270a = cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<String, String> mo8459a() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("adtoken", this.f6270a.mo8166a());
        hashMap.put("adtoken_prefix", this.f6270a.mo8168c());
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1818b mo8460b() {
        return C1818b.REGULAR_AD_TOKEN;
    }
}
