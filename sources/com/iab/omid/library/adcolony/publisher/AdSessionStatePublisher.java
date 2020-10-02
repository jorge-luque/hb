package com.iab.omid.library.adcolony.publisher;

import android.webkit.WebView;
import com.iab.omid.library.adcolony.adsession.AdEvents;
import com.iab.omid.library.adcolony.adsession.AdSessionConfiguration;
import com.iab.omid.library.adcolony.adsession.AdSessionContext;
import com.iab.omid.library.adcolony.adsession.C4148a;
import com.iab.omid.library.adcolony.adsession.ErrorType;
import com.iab.omid.library.adcolony.adsession.VerificationScriptResource;
import com.iab.omid.library.adcolony.adsession.media.MediaEvents;
import com.iab.omid.library.adcolony.p144b.C4155d;
import com.iab.omid.library.adcolony.p144b.C4156e;
import com.iab.omid.library.adcolony.p146d.C4165a;
import com.iab.omid.library.adcolony.p146d.C4166b;
import com.iab.omid.library.adcolony.p146d.C4169d;
import com.iab.omid.library.adcolony.p147e.C4173b;
import com.tapjoy.TapjoyConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AdSessionStatePublisher {

    /* renamed from: a */
    private C4173b f11208a = new C4173b((WebView) null);

    /* renamed from: b */
    private AdEvents f11209b;

    /* renamed from: c */
    private MediaEvents f11210c;

    /* renamed from: d */
    private C4174a f11211d;

    /* renamed from: e */
    private long f11212e;

    /* renamed from: com.iab.omid.library.adcolony.publisher.AdSessionStatePublisher$a */
    enum C4174a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        mo28573i();
    }

    /* renamed from: a */
    public void mo28550a() {
    }

    /* renamed from: a */
    public void mo28551a(float f) {
        C4156e.m13932a().mo28524a(getWebView(), f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28552a(WebView webView) {
        this.f11208a = new C4173b(webView);
    }

    /* renamed from: a */
    public void mo28553a(AdEvents adEvents) {
        this.f11209b = adEvents;
    }

    /* renamed from: a */
    public void mo28554a(AdSessionConfiguration adSessionConfiguration) {
        C4156e.m13932a().mo28531a(getWebView(), adSessionConfiguration.toJsonObject());
    }

    /* renamed from: a */
    public void mo28555a(ErrorType errorType, String str) {
        C4156e.m13932a().mo28525a(getWebView(), errorType, str);
    }

    /* renamed from: a */
    public void mo28556a(C4148a aVar, AdSessionContext adSessionContext) {
        mo28557a(aVar, adSessionContext, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo28557a(C4148a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String adSessionId = aVar.getAdSessionId();
        JSONObject jSONObject2 = new JSONObject();
        C4166b.m13985a(jSONObject2, "environment", TapjoyConstants.TJC_APP_PLACEMENT);
        C4166b.m13985a(jSONObject2, "adSessionType", adSessionContext.getAdSessionContextType());
        C4166b.m13985a(jSONObject2, "deviceInfo", C4165a.m13978d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        C4166b.m13985a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        C4166b.m13985a(jSONObject3, "partnerName", adSessionContext.getPartner().getName());
        C4166b.m13985a(jSONObject3, "partnerVersion", adSessionContext.getPartner().getVersion());
        C4166b.m13985a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        C4166b.m13985a(jSONObject4, "libraryVersion", "1.3.4-Adcolony");
        C4166b.m13985a(jSONObject4, "appId", C4155d.m13929a().mo28522b().getApplicationContext().getPackageName());
        C4166b.m13985a(jSONObject2, TapjoyConstants.TJC_APP_PLACEMENT, jSONObject4);
        if (adSessionContext.getContentUrl() != null) {
            C4166b.m13985a(jSONObject2, "contentUrl", adSessionContext.getContentUrl());
        }
        if (adSessionContext.getCustomReferenceData() != null) {
            C4166b.m13985a(jSONObject2, "customReferenceData", adSessionContext.getCustomReferenceData());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (VerificationScriptResource next : adSessionContext.getVerificationScriptResources()) {
            C4166b.m13985a(jSONObject5, next.getVendorKey(), next.getVerificationParameters());
        }
        C4156e.m13932a().mo28528a(getWebView(), adSessionId, jSONObject2, jSONObject5, jSONObject);
    }

    /* renamed from: a */
    public void mo28558a(MediaEvents mediaEvents) {
        this.f11210c = mediaEvents;
    }

    /* renamed from: a */
    public void mo28559a(String str) {
        C4156e.m13932a().mo28527a(getWebView(), str, (JSONObject) null);
    }

    /* renamed from: a */
    public void mo28560a(String str, long j) {
        if (j >= this.f11212e) {
            this.f11211d = C4174a.AD_STATE_VISIBLE;
            C4156e.m13932a().mo28535b(getWebView(), str);
        }
    }

    /* renamed from: a */
    public void mo28561a(String str, JSONObject jSONObject) {
        C4156e.m13932a().mo28527a(getWebView(), str, jSONObject);
    }

    /* renamed from: a */
    public void mo28562a(JSONObject jSONObject) {
        C4156e.m13932a().mo28536b(getWebView(), jSONObject);
    }

    /* renamed from: a */
    public void mo28563a(boolean z) {
        if (mo28568e()) {
            C4156e.m13932a().mo28538c(getWebView(), z ? "foregrounded" : "backgrounded");
        }
    }

    /* renamed from: b */
    public void mo28564b() {
        this.f11208a.clear();
    }

    /* renamed from: b */
    public void mo28565b(String str, long j) {
        C4174a aVar;
        if (j >= this.f11212e && this.f11211d != (aVar = C4174a.AD_STATE_NOTVISIBLE)) {
            this.f11211d = aVar;
            C4156e.m13932a().mo28535b(getWebView(), str);
        }
    }

    /* renamed from: c */
    public AdEvents mo28566c() {
        return this.f11209b;
    }

    /* renamed from: d */
    public MediaEvents mo28567d() {
        return this.f11210c;
    }

    /* renamed from: e */
    public boolean mo28568e() {
        return this.f11208a.get() != null;
    }

    /* renamed from: f */
    public void mo28569f() {
        C4156e.m13932a().mo28523a(getWebView());
    }

    /* renamed from: g */
    public void mo28570g() {
        C4156e.m13932a().mo28534b(getWebView());
    }

    public WebView getWebView() {
        return (WebView) this.f11208a.get();
    }

    /* renamed from: h */
    public void mo28572h() {
        C4156e.m13932a().mo28537c(getWebView());
    }

    /* renamed from: i */
    public void mo28573i() {
        this.f11212e = C4169d.m13997a();
        this.f11211d = C4174a.AD_STATE_IDLE;
    }
}
