package com.iab.omid.library.oguryco.publisher;

import android.webkit.WebView;
import com.iab.omid.library.oguryco.adsession.AdEvents;
import com.iab.omid.library.oguryco.adsession.AdSessionConfiguration;
import com.iab.omid.library.oguryco.adsession.AdSessionContext;
import com.iab.omid.library.oguryco.adsession.C4199a;
import com.iab.omid.library.oguryco.adsession.ErrorType;
import com.iab.omid.library.oguryco.adsession.VerificationScriptResource;
import com.iab.omid.library.oguryco.adsession.media.MediaEvents;
import com.iab.omid.library.oguryco.p150b.C4206d;
import com.iab.omid.library.oguryco.p150b.C4207e;
import com.iab.omid.library.oguryco.p152d.C4216a;
import com.iab.omid.library.oguryco.p152d.C4217b;
import com.iab.omid.library.oguryco.p152d.C4220d;
import com.iab.omid.library.oguryco.p153e.C4224b;
import com.tapjoy.TapjoyConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AdSessionStatePublisher {

    /* renamed from: a */
    private C4224b f11329a = new C4224b((WebView) null);

    /* renamed from: b */
    private AdEvents f11330b;

    /* renamed from: c */
    private MediaEvents f11331c;

    /* renamed from: d */
    private C4225a f11332d;

    /* renamed from: e */
    private long f11333e;

    /* renamed from: com.iab.omid.library.oguryco.publisher.AdSessionStatePublisher$a */
    enum C4225a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        mo28787i();
    }

    /* renamed from: a */
    public void mo28764a() {
    }

    /* renamed from: a */
    public void mo28765a(float f) {
        C4207e.m14161a().mo28738a(getWebView(), f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28766a(WebView webView) {
        this.f11329a = new C4224b(webView);
    }

    /* renamed from: a */
    public void mo28767a(AdEvents adEvents) {
        this.f11330b = adEvents;
    }

    /* renamed from: a */
    public void mo28768a(AdSessionConfiguration adSessionConfiguration) {
        C4207e.m14161a().mo28745a(getWebView(), adSessionConfiguration.toJsonObject());
    }

    /* renamed from: a */
    public void mo28769a(ErrorType errorType, String str) {
        C4207e.m14161a().mo28739a(getWebView(), errorType, str);
    }

    /* renamed from: a */
    public void mo28770a(C4199a aVar, AdSessionContext adSessionContext) {
        mo28771a(aVar, adSessionContext, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo28771a(C4199a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String adSessionId = aVar.getAdSessionId();
        JSONObject jSONObject2 = new JSONObject();
        C4217b.m14214a(jSONObject2, "environment", TapjoyConstants.TJC_APP_PLACEMENT);
        C4217b.m14214a(jSONObject2, "adSessionType", adSessionContext.getAdSessionContextType());
        C4217b.m14214a(jSONObject2, "deviceInfo", C4216a.m14207d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        C4217b.m14214a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        C4217b.m14214a(jSONObject3, "partnerName", adSessionContext.getPartner().getName());
        C4217b.m14214a(jSONObject3, "partnerVersion", adSessionContext.getPartner().getVersion());
        C4217b.m14214a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        C4217b.m14214a(jSONObject4, "libraryVersion", "1.3.1-Oguryco");
        C4217b.m14214a(jSONObject4, "appId", C4206d.m14158a().mo28736b().getApplicationContext().getPackageName());
        C4217b.m14214a(jSONObject2, TapjoyConstants.TJC_APP_PLACEMENT, jSONObject4);
        if (adSessionContext.getContentUrl() != null) {
            C4217b.m14214a(jSONObject2, "contentUrl", adSessionContext.getContentUrl());
        }
        if (adSessionContext.getCustomReferenceData() != null) {
            C4217b.m14214a(jSONObject2, "customReferenceData", adSessionContext.getCustomReferenceData());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (VerificationScriptResource next : adSessionContext.getVerificationScriptResources()) {
            C4217b.m14214a(jSONObject5, next.getVendorKey(), next.getVerificationParameters());
        }
        C4207e.m14161a().mo28742a(getWebView(), adSessionId, jSONObject2, jSONObject5, jSONObject);
    }

    /* renamed from: a */
    public void mo28772a(MediaEvents mediaEvents) {
        this.f11331c = mediaEvents;
    }

    /* renamed from: a */
    public void mo28773a(String str) {
        C4207e.m14161a().mo28741a(getWebView(), str, (JSONObject) null);
    }

    /* renamed from: a */
    public void mo28774a(String str, long j) {
        if (j >= this.f11333e) {
            this.f11332d = C4225a.AD_STATE_VISIBLE;
            C4207e.m14161a().mo28749b(getWebView(), str);
        }
    }

    /* renamed from: a */
    public void mo28775a(String str, JSONObject jSONObject) {
        C4207e.m14161a().mo28741a(getWebView(), str, jSONObject);
    }

    /* renamed from: a */
    public void mo28776a(JSONObject jSONObject) {
        C4207e.m14161a().mo28750b(getWebView(), jSONObject);
    }

    /* renamed from: a */
    public void mo28777a(boolean z) {
        if (mo28782e()) {
            C4207e.m14161a().mo28752c(getWebView(), z ? "foregrounded" : "backgrounded");
        }
    }

    /* renamed from: b */
    public void mo28778b() {
        this.f11329a.clear();
    }

    /* renamed from: b */
    public void mo28779b(String str, long j) {
        C4225a aVar;
        if (j >= this.f11333e && this.f11332d != (aVar = C4225a.AD_STATE_NOTVISIBLE)) {
            this.f11332d = aVar;
            C4207e.m14161a().mo28749b(getWebView(), str);
        }
    }

    /* renamed from: c */
    public AdEvents mo28780c() {
        return this.f11330b;
    }

    /* renamed from: d */
    public MediaEvents mo28781d() {
        return this.f11331c;
    }

    /* renamed from: e */
    public boolean mo28782e() {
        return this.f11329a.get() != null;
    }

    /* renamed from: f */
    public void mo28783f() {
        C4207e.m14161a().mo28737a(getWebView());
    }

    /* renamed from: g */
    public void mo28784g() {
        C4207e.m14161a().mo28748b(getWebView());
    }

    public WebView getWebView() {
        return (WebView) this.f11329a.get();
    }

    /* renamed from: h */
    public void mo28786h() {
        C4207e.m14161a().mo28751c(getWebView());
    }

    /* renamed from: i */
    public void mo28787i() {
        this.f11333e = C4220d.m14226a();
        this.f11332d = C4225a.AD_STATE_IDLE;
    }
}
