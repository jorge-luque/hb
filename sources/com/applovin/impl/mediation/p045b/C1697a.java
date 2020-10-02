package com.applovin.impl.mediation.p045b;

import android.os.SystemClock;
import com.applovin.impl.mediation.C1743j;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.a */
public abstract class C1697a extends C1701e implements MaxAd {

    /* renamed from: a */
    protected C1743j f5297a;

    /* renamed from: c */
    private final AtomicBoolean f5298c = new AtomicBoolean();

    protected C1697a(JSONObject jSONObject, JSONObject jSONObject2, C1743j jVar, C1941j jVar2) {
        super(jSONObject, jSONObject2, jVar2);
        this.f5297a = jVar;
    }

    /* renamed from: l */
    private long mo7780l() {
        return mo7831b("load_started_time_ms", 0);
    }

    /* renamed from: a */
    public abstract C1697a mo7764a(C1743j jVar);

    /* renamed from: a */
    public boolean mo7765a() {
        C1743j jVar = this.f5297a;
        return jVar != null && jVar.mo7904d() && this.f5297a.mo7905e();
    }

    /* renamed from: b */
    public String mo7766b() {
        return mo7824a("event_id", "");
    }

    /* renamed from: c */
    public C1743j mo7767c() {
        return this.f5297a;
    }

    /* renamed from: d */
    public String mo7768d() {
        return mo7833b("bid_response", (String) null);
    }

    /* renamed from: e */
    public String mo7769e() {
        return mo7833b("third_party_ad_placement_id", (String) null);
    }

    /* renamed from: f */
    public long mo7770f() {
        if (mo7780l() > 0) {
            return mo7775h() - mo7780l();
        }
        return -1;
    }

    /* renamed from: g */
    public void mo7771g() {
        mo7838c("load_started_time_ms", SystemClock.elapsedRealtime());
    }

    public String getAdUnitId() {
        return mo7824a("ad_unit_id", "");
    }

    public MaxAdFormat getFormat() {
        return C2029r.m8031c(mo7824a("ad_format", (String) null));
    }

    public String getNetworkName() {
        return mo7833b("network_name", "");
    }

    /* renamed from: h */
    public long mo7775h() {
        return mo7831b("load_completed_time_ms", 0);
    }

    /* renamed from: i */
    public void mo7776i() {
        mo7838c("load_completed_time_ms", SystemClock.elapsedRealtime());
    }

    /* renamed from: j */
    public AtomicBoolean mo7777j() {
        return this.f5298c;
    }

    /* renamed from: k */
    public void mo7778k() {
        this.f5297a = null;
    }

    public String toString() {
        return getClass().getSimpleName() + "{thirdPartyAdPlacementId=" + mo7769e() + ", adUnitId=" + getAdUnitId() + ", format=" + getFormat().getLabel() + ", networkName='" + getNetworkName() + "'}";
    }
}
