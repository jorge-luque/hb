package com.iab.omid.library.adcolony.p144b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.adcolony.adsession.ErrorType;
import com.iab.omid.library.adcolony.p146d.C4168c;
import com.ogury.p159cm.OguryChoiceManager;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.b.e */
public class C4156e {

    /* renamed from: a */
    private static C4156e f11182a = new C4156e();

    /* renamed from: com.iab.omid.library.adcolony.b.e$a */
    class C4157a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ WebView f11183a;

        /* renamed from: b */
        final /* synthetic */ String f11184b;

        C4157a(WebView webView, String str) {
            this.f11183a = webView;
            this.f11184b = str;
        }

        public void run() {
            this.f11183a.loadUrl(this.f11184b);
        }
    }

    private C4156e() {
    }

    /* renamed from: a */
    public static C4156e m13932a() {
        return f11182a;
    }

    /* renamed from: a */
    public void mo28523a(WebView webView) {
        mo28529a(webView, "finishSession", new Object[0]);
    }

    /* renamed from: a */
    public void mo28524a(WebView webView, float f) {
        mo28529a(webView, "setDeviceVolume", Float.valueOf(f));
    }

    /* renamed from: a */
    public void mo28525a(WebView webView, ErrorType errorType, String str) {
        mo28529a(webView, "error", errorType.toString(), str);
    }

    /* renamed from: a */
    public void mo28526a(WebView webView, String str, String str2) {
        if (str != null && !TextUtils.isEmpty(str2)) {
            mo28533a(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};this.omidVerificationProperties.injectionId = '%INJECTION_ID%';var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
        }
    }

    /* renamed from: a */
    public void mo28527a(WebView webView, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            mo28529a(webView, "publishMediaEvent", str, jSONObject);
            return;
        }
        mo28529a(webView, "publishMediaEvent", str);
    }

    /* renamed from: a */
    public void mo28528a(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        mo28529a(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28529a(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            mo28532a(sb, objArr);
            sb.append(")}");
            mo28530a(webView, sb);
            return;
        }
        C4168c.m13995a("The WebView is null for " + str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28530a(WebView webView, StringBuilder sb) {
        String sb2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            webView.loadUrl(sb2);
        } else {
            handler.post(new C4157a(webView, sb2));
        }
    }

    /* renamed from: a */
    public void mo28531a(WebView webView, JSONObject jSONObject) {
        mo28529a(webView, "init", jSONObject);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28532a(StringBuilder sb, Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                if (obj == null) {
                    sb.append('\"');
                } else {
                    if (obj instanceof String) {
                        String obj2 = obj.toString();
                        if (obj2.startsWith("{")) {
                            sb.append(obj2);
                        } else {
                            sb.append('\"');
                            sb.append(obj2);
                        }
                    } else {
                        sb.append(obj);
                    }
                    sb.append(",");
                }
                sb.append('\"');
                sb.append(",");
            }
            sb.setLength(sb.length() - 1);
        }
    }

    /* renamed from: a */
    public boolean mo28533a(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        webView.loadUrl("javascript: " + str);
        return true;
    }

    /* renamed from: b */
    public void mo28534b(WebView webView) {
        mo28529a(webView, "publishImpressionEvent", new Object[0]);
    }

    /* renamed from: b */
    public void mo28535b(WebView webView, String str) {
        mo28529a(webView, "setNativeViewHierarchy", str);
    }

    /* renamed from: b */
    public void mo28536b(WebView webView, JSONObject jSONObject) {
        mo28529a(webView, "publishLoadedEvent", jSONObject);
    }

    /* renamed from: c */
    public void mo28537c(WebView webView) {
        mo28529a(webView, "publishLoadedEvent", new Object[0]);
    }

    /* renamed from: c */
    public void mo28538c(WebView webView, String str) {
        mo28529a(webView, "setState", str);
    }
}
