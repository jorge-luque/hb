package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.ogury.p159cm.OguryChoiceManager;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.dg */
public final class C4964dg {

    /* renamed from: a */
    private static C4964dg f13495a = new C4964dg();

    private C4964dg() {
    }

    /* renamed from: a */
    public static C4964dg m16825a() {
        return f13495a;
    }

    /* renamed from: a */
    private static void m16826a(StringBuilder sb, Object[] objArr) {
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
    public static boolean m16827a(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        webView.loadUrl("javascript: " + str);
        return true;
    }

    /* renamed from: a */
    public final void mo31061a(WebView webView, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            mo31062a(webView, "publishVideoEvent", str, jSONObject);
            return;
        }
        mo31062a(webView, "publishVideoEvent", str);
    }

    /* renamed from: a */
    public final void mo31062a(final WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            m16826a(sb, objArr);
            sb.append(")}");
            final String sb2 = sb.toString();
            Handler handler = webView.getHandler();
            if (handler == null || Looper.myLooper() == handler.getLooper()) {
                webView.loadUrl(sb2);
            } else {
                handler.post(new Runnable() {
                    public final void run() {
                        webView.loadUrl(sb2);
                    }
                });
            }
        }
    }

    /* renamed from: b */
    public final void mo31063b(WebView webView, String str) {
        mo31062a(webView, "setNativeViewHierarchy", str);
    }
}
