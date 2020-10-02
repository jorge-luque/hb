package com.iab.omid.library.oguryco.adsession;

import android.webkit.WebView;
import com.iab.omid.library.oguryco.p152d.C4221e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class AdSessionContext {
    private final AdSessionContextType adSessionContextType;
    private final String contentUrl;
    private final String customReferenceData;
    private final Map<String, VerificationScriptResource> injectedResourcesMap = new HashMap();
    private final String omidJsScriptContent;
    private final Partner partner;
    private final List<VerificationScriptResource> verificationScriptResources = new ArrayList();
    private final WebView webView;

    private AdSessionContext(Partner partner2, WebView webView2, String str, List<VerificationScriptResource> list, String str2, String str3, AdSessionContextType adSessionContextType2) {
        this.partner = partner2;
        this.webView = webView2;
        this.omidJsScriptContent = str;
        this.adSessionContextType = adSessionContextType2;
        if (list != null) {
            this.verificationScriptResources.addAll(list);
            for (VerificationScriptResource put : list) {
                String uuid = UUID.randomUUID().toString();
                this.injectedResourcesMap.put(uuid, put);
            }
        }
        this.contentUrl = str2;
        this.customReferenceData = str3;
    }

    public static AdSessionContext createHtmlAdSessionContext(Partner partner2, WebView webView2, String str) {
        C4221e.m14230a((Object) partner2, "Partner is null");
        C4221e.m14230a((Object) webView2, "WebView is null");
        if (str != null) {
            C4221e.m14231a(str, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner2, webView2, (String) null, (List<VerificationScriptResource>) null, (String) null, str, AdSessionContextType.HTML);
    }

    public static AdSessionContext createHtmlAdSessionContext(Partner partner2, WebView webView2, String str, String str2) {
        C4221e.m14230a((Object) partner2, "Partner is null");
        C4221e.m14230a((Object) webView2, "WebView is null");
        if (str2 != null) {
            C4221e.m14231a(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner2, webView2, (String) null, (List<VerificationScriptResource>) null, str, str2, AdSessionContextType.HTML);
    }

    public static AdSessionContext createJavascriptAdSessionContext(Partner partner2, WebView webView2, String str, String str2) {
        C4221e.m14230a((Object) partner2, "Partner is null");
        C4221e.m14230a((Object) webView2, "WebView is null");
        if (str2 != null) {
            C4221e.m14231a(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner2, webView2, (String) null, (List<VerificationScriptResource>) null, str, str2, AdSessionContextType.JAVASCRIPT);
    }

    public static AdSessionContext createNativeAdSessionContext(Partner partner2, String str, List<VerificationScriptResource> list, String str2) {
        C4221e.m14230a((Object) partner2, "Partner is null");
        C4221e.m14230a((Object) str, "OM SDK JS script content is null");
        C4221e.m14230a((Object) list, "VerificationScriptResources is null");
        if (str2 != null) {
            C4221e.m14231a(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner2, (WebView) null, str, list, (String) null, str2, AdSessionContextType.NATIVE);
    }

    public static AdSessionContext createNativeAdSessionContext(Partner partner2, String str, List<VerificationScriptResource> list, String str2, String str3) {
        C4221e.m14230a((Object) partner2, "Partner is null");
        C4221e.m14230a((Object) str, "OM SDK JS script content is null");
        C4221e.m14230a((Object) list, "VerificationScriptResources is null");
        if (str3 != null) {
            C4221e.m14231a(str3, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new AdSessionContext(partner2, (WebView) null, str, list, str2, str3, AdSessionContextType.NATIVE);
    }

    public final AdSessionContextType getAdSessionContextType() {
        return this.adSessionContextType;
    }

    public final String getContentUrl() {
        return this.contentUrl;
    }

    public final String getCustomReferenceData() {
        return this.customReferenceData;
    }

    public final Map<String, VerificationScriptResource> getInjectedResourcesMap() {
        return Collections.unmodifiableMap(this.injectedResourcesMap);
    }

    public final String getOmidJsScriptContent() {
        return this.omidJsScriptContent;
    }

    public final Partner getPartner() {
        return this.partner;
    }

    public final List<VerificationScriptResource> getVerificationScriptResources() {
        return Collections.unmodifiableList(this.verificationScriptResources);
    }

    public final WebView getWebView() {
        return this.webView;
    }
}
