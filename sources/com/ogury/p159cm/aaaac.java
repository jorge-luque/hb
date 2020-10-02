package com.ogury.p159cm;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.GraphResponse;
import com.ogury.core.OguryError;
import com.ogury.p159cm.ConsentActivity;
import com.ogury.p159cm.abaaa;
import com.ogury.p159cm.abbcb;
import com.ogury.p159cm.accca;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.ogury.cm.aaaac */
public final class aaaac {

    /* renamed from: a */
    public static final aaaac f11933a = new aaaac();

    /* renamed from: b */
    private static aacbc f11934b;

    /* renamed from: c */
    private static aaaaa f11935c;

    /* renamed from: d */
    private static WebView f11936d;

    /* renamed from: e */
    private static final Handler f11937e = new Handler();

    /* renamed from: com.ogury.cm.aaaac$aaaaa */
    public static final class aaaaa implements aacbc {

        /* renamed from: a */
        final /* synthetic */ accca.aaaaa f11938a;

        /* renamed from: b */
        final /* synthetic */ accca.aaaaa f11939b;

        /* renamed from: c */
        final /* synthetic */ Context f11940c;

        aaaaa(accca.aaaaa aaaaa, accca.aaaaa aaaaa2, Context context) {
            this.f11938a = aaaaa;
            this.f11939b = aaaaa2;
            this.f11940c = context;
        }

        /* renamed from: a */
        public final void mo29384a(OguryError oguryError) {
            accbb.m15218b(oguryError, "error");
            aaaac aaaac = aaaac.f11933a;
            aaaac.m14907d().removeCallbacksAndMessages((Object) null);
            aaaac aaaac2 = aaaac.f11933a;
            aacbc a = aaaac.m14895a();
            if (a != null) {
                a.mo29384a(oguryError);
            }
        }

        /* renamed from: a */
        public final void mo29385a(String str) {
            accbb.m15218b(str, "response");
            if (accbb.m15217a((Object) str, (Object) "ready")) {
                this.f11938a.f12147a = true;
                aaaac.m14904a(this.f11939b.f12147a, aaaac.m14895a(), 15000);
            } else if (accbb.m15217a((Object) str, (Object) GraphResponse.SUCCESS_KEY)) {
                this.f11939b.f12147a = true;
                aaaac.m14899a(aaaac.f11933a, this.f11940c);
                aaaac aaaac = aaaac.f11933a;
                aaaac.m14907d().removeCallbacksAndMessages((Object) null);
            } else if (baacc.m15252a(str, "parsedConfig=", false, 2, (Object) null)) {
                aaaac.m14900a(aaaac.f11933a, this.f11940c, str);
            }
        }
    }

    /* renamed from: com.ogury.cm.aaaac$aaaab */
    public static final class aaaab implements aacac {

        /* renamed from: a */
        final /* synthetic */ Context f11941a;

        /* renamed from: b */
        final /* synthetic */ String f11942b;

        /* renamed from: com.ogury.cm.aaaac$aaaab$aaaaa */
        static final class aaaaa implements Runnable {

            /* renamed from: a */
            final /* synthetic */ aaaab f11943a;

            /* renamed from: b */
            final /* synthetic */ String f11944b;

            aaaaa(aaaab aaaab, String str) {
                this.f11943a = aaaab;
                this.f11944b = str;
            }

            public final void run() {
                aacca aacca = aacca.f12035a;
                aacca.m15037c().mo29544b(this.f11944b);
                abaaa.aaaaa aaaaa = abaaa.f12046a;
                abaaa.aaaaa.m15052a().mo29429a(this.f11943a.f11941a);
                abbcb.aaaaa aaaaa2 = abbcb.f12089a;
                abbcb.m15142a(abbcb.aaaaa.m15151a(), this.f11943a.f11941a, (String) null, 2, (Object) null);
                aaaac aaaac = aaaac.f11933a;
                aacbc a = aaaac.m14895a();
                if (a != null) {
                    a.mo29385a(this.f11943a.f11942b);
                }
            }
        }

        aaaab(Context context, String str) {
            this.f11941a = context;
            this.f11942b = str;
        }

        /* renamed from: a */
        public final void mo29386a(String str) {
            accbb.m15218b(str, "aaid");
            new Handler(Looper.getMainLooper()).post(new aaaaa(this, str));
        }
    }

    /* renamed from: com.ogury.cm.aaaac$aaaac  reason: collision with other inner class name */
    static final class C6848aaaac implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f11945a;

        /* renamed from: b */
        final /* synthetic */ aacbc f11946b;

        C6848aaaac(boolean z, aacbc aacbc) {
            this.f11945a = z;
            this.f11946b = aacbc;
        }

        public final void run() {
            if (!this.f11945a) {
                aaaac.m14903a(this.f11946b, new OguryError(1002, "Timeout error"));
            }
        }
    }

    private aaaac() {
    }

    /* renamed from: a */
    public static aacbc m14895a() {
        return f11934b;
    }

    /* renamed from: a */
    public static void m14896a(Context context, aacbc aacbc) {
        accbb.m15218b(context, "context");
        accbb.m15218b(aacbc, "callback");
        abcbc.f12099a.queryProductDetails();
        f11934b = aacbc;
        accca.aaaaa aaaaa2 = new accca.aaaaa();
        aaaaa2.f12147a = false;
        accca.aaaaa aaaaa3 = new accca.aaaaa();
        aaaaa3.f12147a = false;
        try {
            WebView webView = new WebView(context.getApplicationContext(), (AttributeSet) null);
            f11936d = webView;
            WebSettings settings = webView.getSettings();
            if (settings != null) {
                settings.setJavaScriptEnabled(true);
            }
            WebView webView2 = f11936d;
            if (webView2 != null) {
                webView2.setBackgroundColor(0);
            }
            WebView webView3 = f11936d;
            if (webView3 != null) {
                webView3.setLayerType(1, (Paint) null);
            }
            aaaaa aaaaa4 = new aaaaa(context, new aaaaa(aaaaa2, aaaaa3, context));
            f11935c = aaaaa4;
            WebView webView4 = f11936d;
            if (webView4 != null) {
                webView4.setWebViewClient(aaaaa4);
            }
            m14904a(aaaaa2.f12147a, aacbc, 20000);
            WebView webView5 = f11936d;
            if (webView5 != null) {
                StringBuilder sb = new StringBuilder("https://consent-form.ogury.co");
                aacca aacca = aacca.f12035a;
                sb.append(aacca.m15037c().mo29549e());
                sb.append("?assetType=android");
                webView5.loadUrl(sb.toString());
            }
        } catch (Exception unused) {
            aaccc aaccc = aaccc.f12045a;
            aaccc.m15050b("Cannot create WebView");
            m14903a(f11934b, new OguryError(4, "Cannot create WebView"));
        }
    }

    /* renamed from: a */
    public static void m14897a(WebView webView) {
        f11936d = null;
    }

    /* renamed from: a */
    public static void m14898a(aaaaa aaaaa2) {
        f11935c = null;
    }

    /* renamed from: a */
    public static final /* synthetic */ void m14899a(aaaac aaaac, Context context) {
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            boolean z = false;
            if (runningAppProcesses != null) {
                String packageName = context.getPackageName();
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.importance == 100 && accbb.m15217a((Object) next.processName, (Object) packageName)) {
                        break;
                    }
                }
            }
            if (!z) {
                ConsentActivity.aaaaa aaaaa2 = ConsentActivity.f11912a;
                accbb.m15218b(context, "context");
                context.startActivity(new Intent(context, ConsentActivity.class));
                return;
            }
            m14903a(f11934b, new OguryError(4, "App in background"));
            return;
        }
        throw new acbab("null cannot be cast to non-null type android.app.ActivityManager");
    }

    /* renamed from: a */
    public static final /* synthetic */ void m14900a(aaaac aaaac, Context context, String str) {
        if (str != null) {
            String substring = str.substring(13);
            accbb.m15215a((Object) substring, "(this as java.lang.String).substring(startIndex)");
            aacba aacba = aacba.f12030a;
            aacba.m15022a(context, (aacac) new aaaab(context, substring));
            return;
        }
        throw new acbab("null cannot be cast to non-null type java.lang.String");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m14903a(aacbc aacbc, OguryError oguryError) {
        f11936d = null;
        f11935c = null;
        if (aacbc != null) {
            aacbc.mo29384a(oguryError);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m14904a(boolean z, aacbc aacbc, long j) {
        f11937e.postDelayed(new C6848aaaac(z, aacbc), j);
    }

    /* renamed from: b */
    public static aaaaa m14905b() {
        return f11935c;
    }

    /* renamed from: c */
    public static WebView m14906c() {
        return f11936d;
    }

    /* renamed from: d */
    public static Handler m14907d() {
        return f11937e;
    }
}
