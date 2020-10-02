package com.applovin.impl.mediation.ads;

import com.applovin.impl.mediation.C1733f;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.mediation.ads.a */
public abstract class C1694a {

    /* renamed from: a */
    private static C1941j f5291a;
    protected final MaxAdFormat adFormat;
    protected MaxAdListener adListener = null;
    protected final String adUnitId;
    protected final C1733f.C1735a loadRequestBuilder;
    protected final C1977q logger;
    protected final C1941j sdk;
    protected final String tag;

    protected C1694a(String str, MaxAdFormat maxAdFormat, String str2, C1941j jVar) {
        this.adUnitId = str;
        this.adFormat = maxAdFormat;
        this.sdk = jVar;
        this.tag = str2;
        this.logger = jVar.mo8602v();
        this.loadRequestBuilder = new C1733f.C1735a();
    }

    public static void logApiCall(String str, String str2) {
        C1941j jVar = f5291a;
        if (jVar != null) {
            jVar.mo8602v().mo8742b(str, str2);
            return;
        }
        for (AppLovinSdk a : AppLovinSdk.m8096a()) {
            C1941j a2 = C2029r.m7993a(a);
            if (a2 != null && !a2.mo8584e()) {
                f5291a = a2;
                a2.mo8602v().mo8742b(str, str2);
            }
        }
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public void logApiCall(String str) {
        this.logger.mo8742b(this.tag, str);
    }

    public void setExtraParameter(String str, String str2) {
        if (str != null) {
            this.loadRequestBuilder.mo7882a(str, str2);
            return;
        }
        throw new IllegalArgumentException("No key specified");
    }

    public void setListener(MaxAdListener maxAdListener) {
        C1977q qVar = this.logger;
        String str = this.tag;
        qVar.mo8742b(str, "Setting listener: " + maxAdListener);
        this.adListener = maxAdListener;
    }
}
