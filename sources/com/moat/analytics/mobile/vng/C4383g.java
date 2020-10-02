package com.moat.analytics.mobile.vng;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Base64;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.moat.analytics.mobile.vng.C4395j;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.vng.g */
class C4383g {

    /* renamed from: a */
    WebView f11745a;

    /* renamed from: b */
    C4395j f11746b;

    /* renamed from: c */
    final String f11747c = String.format(Locale.ROOT, "_moatTracker%d", new Object[]{Integer.valueOf((int) (Math.random() * 1.0E8d))});

    /* renamed from: d */
    private final C4388a f11748d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f11749e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Handler f11750f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Runnable f11751g;

    /* renamed from: com.moat.analytics.mobile.vng.g$a */
    enum C4388a {
        DISPLAY,
        f11757b
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    C4383g(Context context, C4388a aVar) {
        this.f11748d = aVar;
        WebView webView = new WebView(context);
        this.f11745a = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccess(false);
        settings.setDatabaseEnabled(false);
        settings.setDomStorageEnabled(false);
        settings.setGeolocationEnabled(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setSaveFormData(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(1);
        }
        try {
            this.f11746b = new C4395j(this.f11745a, aVar == C4388a.f11757b ? C4395j.C4399a.NATIVE_VIDEO : C4395j.C4399a.NATIVE_DISPLAY);
        } catch (C4403n e) {
            C4403n.m14758a(e);
        }
    }

    /* renamed from: a */
    private static String m14667a(String str, String str2, Integer num, Integer num2, JSONObject jSONObject, Integer num3) {
        try {
            return Base64.encodeToString(String.format(Locale.ROOT, "<html><head></head><body><div id=\"%s\" style=\"width: %dpx; height: %dpx;\"></div><script>(function initMoatTracking(apiname, pcode, ids, duration) {var events = [];window[pcode + '_moatElToTrack'] = document.getElementById('%s');var moatapi = {'dropTime':%d,'adData': {'ids': ids, 'duration': duration, 'url': 'n/a'},'dispatchEvent': function(ev) {if (this.sendEvent) {if (events) { events.push(ev); ev = events; events = false; }this.sendEvent(ev);} else {events.push(ev);}},'dispatchMany': function(evs){for (var i=0, l=evs.length; i<l; i++) {this.dispatchEvent(evs[i]);}}};Object.defineProperty(window, apiname, {'value': moatapi});var s = document.createElement('script');s.src = 'https://z.moatads.com/' + pcode + '/moatvideo.js?' + apiname + '#' + apiname;document.body.appendChild(s);})('%s', '%s', %s, %s);</script></body></html>", new Object[]{"mianahwvc", num, num2, "mianahwvc", Long.valueOf(System.currentTimeMillis()), str, str2, jSONObject.toString(), num3}).getBytes(), 1);
        } catch (Exception e) {
            C4403n.m14758a(e);
            return "";
        }
    }

    /* renamed from: b */
    private static String m14671b(String str) {
        return "<!DOCTYPE html>\n<html>\n<head lang=\"en\">\n   <meta charset=\"UTF-8\">\n   <title></title>\n</head>\n<body style=\"margin:0;padding:0;\">\n    <script src=\"https://z.moatads.com/" + str + "/moatad.js\" type=\"text/javascript\"></script>\n" + "</body>\n" + "</html>";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29288a() {
        C4409p.m14772a(3, "GlobalWebView", (Object) this, "Cleaning up");
        this.f11746b.mo29316b();
        this.f11746b = null;
        this.f11745a.destroy();
        this.f11745a = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29289a(String str) {
        if (this.f11748d == C4388a.DISPLAY) {
            this.f11745a.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView webView, String str) {
                    if (!C4383g.this.f11749e) {
                        try {
                            boolean unused = C4383g.this.f11749e = true;
                            C4383g.this.f11746b.mo29312a();
                        } catch (Exception e) {
                            C4403n.m14758a(e);
                        }
                    }
                }
            });
            this.f11745a.loadData(m14671b(str), "text/html", "utf-8");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29290a(String str, Map<String, String> map, Integer num, Integer num2, Integer num3) {
        if (this.f11748d == C4388a.f11757b) {
            if (Build.VERSION.SDK_INT >= 19) {
                C4409p.m14772a(3, "GlobalWebView", (Object) this, "Starting off polling interval to check for Video API instance presence");
                this.f11750f = new Handler();
                C43852 r0 = new Runnable() {
                    public void run() {
                        try {
                            if (C4383g.this.f11745a != null && Build.VERSION.SDK_INT >= 19) {
                                WebView webView = C4383g.this.f11745a;
                                webView.evaluateJavascript("typeof " + C4383g.this.f11747c + " !== 'undefined'", new ValueCallback<String>() {
                                    /* renamed from: a */
                                    public void onReceiveValue(String str) {
                                        if ("true".equals(str)) {
                                            C4409p.m14772a(3, "GlobalWebView", (Object) this, String.format("Video API instance %s detected. Flushing event queue", new Object[]{C4383g.this.f11747c}));
                                            try {
                                                boolean unused = C4383g.this.f11749e = true;
                                                C4383g.this.f11746b.mo29312a();
                                                C4383g.this.f11746b.mo29320c(C4383g.this.f11747c);
                                            } catch (Exception e) {
                                                C4403n.m14758a(e);
                                            }
                                        } else {
                                            C4383g.this.f11750f.postDelayed(C4383g.this.f11751g, 200);
                                        }
                                    }
                                });
                            }
                        } catch (Exception e) {
                            C4403n.m14758a(e);
                        }
                    }
                };
                this.f11751g = r0;
                this.f11750f.post(r0);
            } else {
                C4409p.m14772a(3, "GlobalWebView", (Object) this, "Android API version is less than KitKat: " + Build.VERSION.SDK_INT);
                this.f11745a.setWebViewClient(new WebViewClient() {
                    public void onPageFinished(WebView webView, String str) {
                        if (!C4383g.this.f11749e) {
                            C4409p.m14772a(3, "GlobalWebView", (Object) this, "onPageFinished is called for the first time. Flushing event queue");
                            try {
                                boolean unused = C4383g.this.f11749e = true;
                                C4383g.this.f11746b.mo29312a();
                                C4383g.this.f11746b.mo29320c(C4383g.this.f11747c);
                            } catch (Exception e) {
                                C4403n.m14758a(e);
                            }
                        }
                    }
                });
            }
            this.f11745a.loadData(m14667a(this.f11747c, str, num, num2, new JSONObject(map), num3), "text/html", "base64");
        }
    }
}
