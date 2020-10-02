package com.iab.omid.library.oguryco.p150b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.oguryco.adsession.ErrorType;
import com.iab.omid.library.oguryco.p152d.C4219c;
import com.ogury.p159cm.OguryChoiceManager;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.oguryco.b.e */
public class C4207e {

    /* renamed from: a */
    private static C4207e f11303a = new C4207e();

    private C4207e() {
    }

    /* renamed from: a */
    public static C4207e m14161a() {
        return f11303a;
    }

    /* renamed from: a */
    public void mo28737a(WebView webView) {
        mo28743a(webView, "finishSession", new Object[0]);
    }

    /* renamed from: a */
    public void mo28738a(WebView webView, float f) {
        mo28743a(webView, "setDeviceVolume", Float.valueOf(f));
    }

    /* renamed from: a */
    public void mo28739a(WebView webView, ErrorType errorType, String str) {
        mo28743a(webView, "error", errorType.toString(), str);
    }

    /* renamed from: a */
    public void mo28740a(WebView webView, String str, String str2) {
        if (str != null && !TextUtils.isEmpty(str2)) {
            mo28747a(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};this.omidVerificationProperties.injectionId = '%INJECTION_ID%';var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
        }
    }

    /* renamed from: a */
    public void mo28741a(WebView webView, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            mo28743a(webView, "publishMediaEvent", str, jSONObject);
            return;
        }
        mo28743a(webView, "publishMediaEvent", str);
    }

    /* renamed from: a */
    public void mo28742a(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        mo28743a(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28743a(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            mo28746a(sb, objArr);
            sb.append(")}");
            mo28744a(webView, sb);
            return;
        }
        C4219c.m14224a("The WebView is null for ".concat(String.valueOf(str)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28744a(final WebView webView, StringBuilder sb) {
        final String sb2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            webView.loadUrl(sb2);
        } else {
            handler.post(new Runnable() {
                public void run() {
                    webView.loadUrl(sb2);
                }
            });
        }
    }

    /* renamed from: a */
    public void mo28745a(WebView webView, JSONObject jSONObject) {
        mo28743a(webView, "init", jSONObject);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28746a(StringBuilder sb, Object[] objArr) {
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
    public boolean mo28747a(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        webView.loadUrl("javascript: ".concat(String.valueOf(str)));
        return true;
    }

    /* renamed from: b */
    public void mo28748b(WebView webView) {
        mo28743a(webView, "publishImpressionEvent", new Object[0]);
    }

    /* renamed from: b */
    public void mo28749b(WebView webView, String str) {
        mo28743a(webView, "setNativeViewHierarchy", str);
    }

    /* renamed from: b */
    public void mo28750b(WebView webView, JSONObject jSONObject) {
        mo28743a(webView, "publishLoadedEvent", jSONObject);
    }

    /* renamed from: c */
    public void mo28751c(WebView webView) {
        mo28743a(webView, "publishLoadedEvent", new Object[0]);
    }

    /* renamed from: c */
    public void mo28752c(WebView webView, String str) {
        mo28743a(webView, "setState", str);
    }
}
