package com.moat.analytics.mobile.ogury;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.moat.analytics.mobile.ogury.C4315e;
import com.moat.analytics.mobile.ogury.C4317f;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.ogury.d */
final class C4311d implements ValueCallback<String>, Runnable {

    /* renamed from: ʼ */
    private Handler f11503;

    /* renamed from: ʽ */
    private Runnable f11504;
    /* access modifiers changed from: private */

    /* renamed from: ˊ */
    public boolean f11505 = false;

    /* renamed from: ˋ */
    C4317f f11506;

    /* renamed from: ˎ */
    WebView f11507;

    /* renamed from: ˏ */
    private final int f11508;

    /* renamed from: ॱ */
    final String f11509 = String.format(Locale.ROOT, "_moatTracker%d", new Object[]{Integer.valueOf((int) (Math.random() * 1.0E8d))});

    /* renamed from: com.moat.analytics.mobile.ogury.d$b */
    enum C4314b {
        ;
        

        /* renamed from: ˏ */
        public static final int f11513 = 1;

        /* renamed from: ॱ */
        public static final int f11514 = 2;

        static {
            f11512 = new int[]{1, 2};
        }

        public static int[] values$5b4351f2() {
            return (int[]) f11512.clone();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    C4311d(Context context, int i) {
        this.f11508 = i;
        WebView webView = new WebView(context);
        this.f11507 = webView;
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
            this.f11506 = new C4317f(this.f11507, i == C4314b.f11514 ? C4317f.C4321a.f11551 : C4317f.C4321a.f11552);
        } catch (C4332l e) {
            C4332l.m14509(e);
        }
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if ("true".equals((String) obj)) {
            C4315e.C43161.m14442(3, "GlobalWebView", this, String.format("Video API instance %s detected. Flushing event queue", new Object[]{this.f11509}));
            try {
                this.f11505 = true;
                this.f11506.mo29138();
                this.f11506.mo29139(this.f11509);
            } catch (Exception e) {
                C4332l.m14509(e);
            }
        } else {
            this.f11503.postDelayed(this.f11504, 200);
        }
    }

    public final void run() {
        try {
            if (this.f11507 != null && Build.VERSION.SDK_INT >= 19) {
                WebView webView = this.f11507;
                StringBuilder sb = new StringBuilder("typeof ");
                sb.append(this.f11509);
                sb.append(" !== 'undefined'");
                webView.evaluateJavascript(sb.toString(), this);
            }
        } catch (Exception e) {
            C4332l.m14509(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ */
    public final void mo29121(String str) {
        if (this.f11508 == C4314b.f11513) {
            this.f11507.setWebViewClient(new WebViewClient() {
                public final void onPageFinished(WebView webView, String str) {
                    if (!C4311d.this.f11505) {
                        try {
                            boolean unused = C4311d.this.f11505 = true;
                            C4311d.this.f11506.mo29138();
                        } catch (Exception e) {
                            C4332l.m14509(e);
                        }
                    }
                }
            });
            WebView webView = this.f11507;
            StringBuilder sb = new StringBuilder("<!DOCTYPE html>\n<html>\n<head lang=\"en\">\n   <meta charset=\"UTF-8\">\n   <title></title>\n</head>\n<body style=\"margin:0;padding:0;\">\n    <script src=\"https://z.moatads.com/");
            sb.append(str);
            sb.append("/moatad.js\" type=\"text/javascript\"></script>\n</body>\n</html>");
            webView.loadData(sb.toString(), "text/html", "utf-8");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ */
    public final void mo29122(String str, Map<String, String> map, Integer num, Integer num2, Integer num3) {
        if (this.f11508 == C4314b.f11514) {
            if (Build.VERSION.SDK_INT >= 19) {
                C4315e.C43161.m14442(3, "GlobalWebView", this, "Starting off polling interval to check for Video API instance presence");
                Handler handler = new Handler();
                this.f11503 = handler;
                this.f11504 = this;
                handler.post(this);
            } else {
                StringBuilder sb = new StringBuilder("Android API version is less than KitKat: ");
                sb.append(Build.VERSION.SDK_INT);
                C4315e.C43161.m14442(3, "GlobalWebView", this, sb.toString());
                this.f11507.setWebViewClient(new WebViewClient() {
                    public final void onPageFinished(WebView webView, String str) {
                        if (!C4311d.this.f11505) {
                            C4315e.C43161.m14442(3, "GlobalWebView", this, "onPageFinished is called for the first time. Flushing event queue");
                            try {
                                boolean unused = C4311d.this.f11505 = true;
                                C4311d.this.f11506.mo29138();
                                C4311d.this.f11506.mo29139(C4311d.this.f11509);
                            } catch (Exception e) {
                                C4332l.m14509(e);
                            }
                        }
                    }
                });
            }
            JSONObject jSONObject = new JSONObject(map);
            WebView webView = this.f11507;
            String str2 = this.f11509;
            webView.loadData(String.format(Locale.ROOT, "<html><head></head><body><div id=\"%s\" style=\"width: %dpx; height: %dpx;\"></div><script>(function initMoatTracking(apiname, pcode, ids, duration) {var events = [];window[pcode + '_moatElToTrack'] = document.getElementById('%s');var moatapi = {'dropTime':%d,'adData': {'ids': ids, 'duration': duration, 'url': 'n/a'},'dispatchEvent': function(ev) {if (this.sendEvent) {if (events) { events.push(ev); ev = events; events = false; }this.sendEvent(ev);} else {events.push(ev);}},'dispatchMany': function(evs){for (var i=0, l=evs.length; i<l; i++) {this.dispatchEvent(evs[i]);}}};Object.defineProperty(window, apiname, {'value': moatapi});var s = document.createElement('script');s.src = 'https://z.moatads.com/' + pcode + '/moatvideo.js?' + apiname + '#' + apiname;document.body.appendChild(s);})('%s', '%s', %s, %s);</script></body></html>", new Object[]{"mianahwvc", num, num2, "mianahwvc", Long.valueOf(System.currentTimeMillis()), str2, str, jSONObject.toString(), num3}), "text/html", (String) null);
        }
    }
}
