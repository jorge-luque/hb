package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p049ad.C1818b;
import com.applovin.impl.sdk.p049ad.C1821d;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.t */
public class C1913t extends C1864a implements AppLovinAdLoadListener {

    /* renamed from: a */
    private final JSONObject f6334a;

    /* renamed from: c */
    private final C1821d f6335c;

    /* renamed from: d */
    private final C1818b f6336d;

    /* renamed from: e */
    private final AppLovinAdLoadListener f6337e;

    public C1913t(JSONObject jSONObject, C1821d dVar, C1818b bVar, AppLovinAdLoadListener appLovinAdLoadListener, C1941j jVar) {
        super("TaskProcessAdResponse", jVar);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (dVar != null) {
            this.f6334a = jSONObject;
            this.f6335c = dVar;
            this.f6336d = bVar;
            this.f6337e = appLovinAdLoadListener;
        } else {
            throw new IllegalArgumentException("No zone specified");
        }
    }

    /* renamed from: a */
    private void m7367a(int i) {
        C2029r.m8008a(this.f6337e, this.f6335c, i, this.f6217b);
    }

    /* renamed from: a */
    private void m7368a(JSONObject jSONObject) {
        String b = C1993i.m7896b(jSONObject, "type", "undefined", this.f6217b);
        if ("applovin".equalsIgnoreCase(b)) {
            mo8405a("Starting task for AppLovin ad...");
            this.f6217b.mo8533L().mo8474a((C1864a) new C1918v(jSONObject, this.f6334a, this.f6336d, this, this.f6217b));
        } else if ("vast".equalsIgnoreCase(b)) {
            mo8405a("Starting task for VAST ad...");
            this.f6217b.mo8533L().mo8474a((C1864a) C1914u.m7370a(jSONObject, this.f6334a, this.f6336d, this, this.f6217b));
        } else {
            mo8408c("Unable to process ad of unknown type: " + b);
            failedToReceiveAd(AppLovinErrorCodes.INVALID_RESPONSE);
        }
    }

    public void adReceived(AppLovinAd appLovinAd) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f6337e;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(appLovinAd);
        }
    }

    public void failedToReceiveAd(int i) {
        m7367a(i);
    }

    public void run() {
        JSONArray b = C1993i.m7900b(this.f6334a, "ads", new JSONArray(), this.f6217b);
        if (b.length() > 0) {
            mo8405a("Processing ad...");
            m7368a(C1993i.m7883a(b, 0, new JSONObject(), this.f6217b));
            return;
        }
        mo8408c("No ads were returned from the server");
        C2029r.m8010a(this.f6335c.mo8174a(), this.f6335c.mo8175b(), this.f6334a, this.f6217b);
        m7367a(204);
    }
}
