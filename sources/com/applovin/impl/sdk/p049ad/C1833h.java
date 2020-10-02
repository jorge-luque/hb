package com.applovin.impl.sdk.p049ad;

import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1941j;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.h */
public final class C1833h extends AppLovinAdBase {

    /* renamed from: a */
    private AppLovinAd f5735a;

    /* renamed from: b */
    private final C1821d f5736b;

    public C1833h(C1821d dVar, C1941j jVar) {
        super(new JSONObject(), new JSONObject(), C1818b.UNKNOWN, jVar);
        this.f5736b = dVar;
    }

    /* renamed from: c */
    private AppLovinAd m7021c() {
        return (AppLovinAd) this.sdk.mo8541T().mo8333c(this.f5736b);
    }

    /* renamed from: d */
    private String m7022d() {
        C1821d adZone = getAdZone();
        if (adZone == null || adZone.mo8185j()) {
            return null;
        }
        return adZone.mo8174a();
    }

    /* renamed from: a */
    public AppLovinAd mo8289a() {
        return this.f5735a;
    }

    /* renamed from: a */
    public void mo8290a(AppLovinAd appLovinAd) {
        this.f5735a = appLovinAd;
    }

    /* renamed from: b */
    public AppLovinAd mo8291b() {
        AppLovinAd appLovinAd = this.f5735a;
        return appLovinAd != null ? appLovinAd : m7021c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1833h.class != obj.getClass()) {
            return false;
        }
        AppLovinAd b = mo8291b();
        return b != null ? b.equals(obj) : super.equals(obj);
    }

    public long getAdIdNumber() {
        AppLovinAd b = mo8291b();
        if (b != null) {
            return b.getAdIdNumber();
        }
        return 0;
    }

    public C1821d getAdZone() {
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) mo8291b();
        return appLovinAdBase != null ? appLovinAdBase.getAdZone() : this.f5736b;
    }

    public long getCreatedAtMillis() {
        AppLovinAd b = mo8291b();
        if (b instanceof AppLovinAdBase) {
            return ((AppLovinAdBase) b).getCreatedAtMillis();
        }
        return 0;
    }

    public AppLovinAdSize getSize() {
        return getAdZone().mo8176c();
    }

    public C1818b getSource() {
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) mo8291b();
        return appLovinAdBase != null ? appLovinAdBase.getSource() : C1818b.UNKNOWN;
    }

    public AppLovinAdType getType() {
        return getAdZone().mo8177d();
    }

    public String getZoneId() {
        if (this.f5736b.mo8185j()) {
            return null;
        }
        return this.f5736b.mo8174a();
    }

    public int hashCode() {
        AppLovinAd b = mo8291b();
        return b != null ? b.hashCode() : super.hashCode();
    }

    public boolean isVideoAd() {
        AppLovinAd b = mo8291b();
        return b != null && b.isVideoAd();
    }

    public String toString() {
        return "AppLovinAd{ #" + getAdIdNumber() + ", adType=" + getType() + ", adSize=" + getSize() + ", zoneId='" + m7022d() + '\'' + '}';
    }
}
