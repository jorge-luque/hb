package com.iab.omid.library.adcolony.adsession;

import android.webkit.WebView;
import com.iab.omid.library.adcolony.p146d.C4170e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class AdSessionContext {

    /* renamed from: a */
    private final Partner f11119a;

    /* renamed from: b */
    private final WebView f11120b;

    /* renamed from: c */
    private final List<VerificationScriptResource> f11121c = new ArrayList();

    /* renamed from: d */
    private final Map<String, VerificationScriptResource> f11122d = new HashMap();

    /* renamed from: e */
    private final String f11123e;

    /* renamed from: f */
    private final String f11124f;

    /* renamed from: g */
    private final String f11125g;

    /* renamed from: h */
    private final AdSessionContextType f11126h;

    private AdSessionContext(Partner partner, WebView webView, String str, List<VerificationScriptResource> list, String str2, String str3, AdSessionContextType adSessionContextType) {
        this.f11119a = partner;
        this.f11120b = webView;
        this.f11123e = str;
        this.f11126h = adSessionContextType;
        if (list != null) {
            this.f11121c.addAll(list);
            for (VerificationScriptResource put : list) {
                String uuid = UUID.randomUUID().toString();
                this.f11122d.put(uuid, put);
            }
        }
        this.f11125g = str2;
        this.f11124f = str3;
    }

    public static AdSessionContext createHtmlAdSessionContext(Partner partner, WebView webView, String str, String str2) {
        C4170e.m14001a((Object) partner, "Partner is null");
        C4170e.m14001a((Object) webView, "WebView is null");
        if (str2 != null) {
            C4170e.m14002a(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner, webView, (String) null, (List<VerificationScriptResource>) null, str, str2, AdSessionContextType.HTML);
    }

    public static AdSessionContext createJavascriptAdSessionContext(Partner partner, WebView webView, String str, String str2) {
        C4170e.m14001a((Object) partner, "Partner is null");
        C4170e.m14001a((Object) webView, "WebView is null");
        if (str2 != null) {
            C4170e.m14002a(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner, webView, (String) null, (List<VerificationScriptResource>) null, str, str2, AdSessionContextType.JAVASCRIPT);
    }

    public static AdSessionContext createNativeAdSessionContext(Partner partner, String str, List<VerificationScriptResource> list, String str2, String str3) {
        C4170e.m14001a((Object) partner, "Partner is null");
        C4170e.m14001a((Object) str, "OM SDK JS script content is null");
        C4170e.m14001a((Object) list, "VerificationScriptResources is null");
        if (str3 != null) {
            C4170e.m14002a(str3, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner, (WebView) null, str, list, str2, str3, AdSessionContextType.NATIVE);
    }

    public AdSessionContextType getAdSessionContextType() {
        return this.f11126h;
    }

    public String getContentUrl() {
        return this.f11125g;
    }

    public String getCustomReferenceData() {
        return this.f11124f;
    }

    public Map<String, VerificationScriptResource> getInjectedResourcesMap() {
        return Collections.unmodifiableMap(this.f11122d);
    }

    public String getOmidJsScriptContent() {
        return this.f11123e;
    }

    public Partner getPartner() {
        return this.f11119a;
    }

    public List<VerificationScriptResource> getVerificationScriptResources() {
        return Collections.unmodifiableList(this.f11121c);
    }

    public WebView getWebView() {
        return this.f11120b;
    }
}
