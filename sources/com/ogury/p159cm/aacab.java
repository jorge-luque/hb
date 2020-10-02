package com.ogury.p159cm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.facebook.GraphResponse;
import com.ogury.core.OguryError;
import com.ogury.p159cm.aabba;
import com.ogury.p159cm.abbba;
import com.ogury.p159cm.accca;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.ogury.cm.aacab */
public final class aacab {

    /* renamed from: a */
    public static final aaaaa f12018a = new aaaaa((baaca) null);

    /* renamed from: com.ogury.cm.aacab$aaaaa */
    public static final class aaaaa {
        private aaaaa() {
        }

        public /* synthetic */ aaaaa(baaca baaca) {
            this();
        }
    }

    /* renamed from: com.ogury.cm.aacab$aaaab */
    static final class aaaab extends accbc implements accab<acbba> {

        /* renamed from: a */
        final /* synthetic */ aacab f12019a;

        /* renamed from: b */
        final /* synthetic */ WebView f12020b;

        /* renamed from: c */
        final /* synthetic */ aacbc f12021c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aaaab(aacab aacab, WebView webView, aacbc aacbc) {
            super(0);
            this.f12019a = aacab;
            this.f12020b = webView;
            this.f12021c = aacbc;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo29404a() {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final accca.aaaab aaaab = new accca.aaaab();
            aaaab.f12148a = "";
            final accca.aaaab aaaab2 = new accca.aaaab();
            aaaab2.f12148a = "";
            abcbc.f12099a.setQueryProductDetailsListener(new acaab() {
                /* renamed from: a */
                public final void mo29424a(String str, String str2) {
                    accbb.m15218b(str, "status");
                    accbb.m15218b(str2, "skuDetailsJson");
                    aaaab.f12148a = str;
                    aaaab2.f12148a = str2;
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            abcbc.f12099a.setQueryProductDetailsListener((acaab) null);
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {

                /* renamed from: a */
                final /* synthetic */ aaaab f12025a;

                {
                    this.f12025a = r1;
                }

                public final void run() {
                    if (accbb.m15217a((Object) (String) aaaab.f12148a, (Object) "ok")) {
                        aaaab aaaab = this.f12025a;
                        aacab.m15012a(aaaab.f12020b, (String) aaaab2.f12148a);
                        this.f12025a.f12021c.mo29385a("ready");
                        return;
                    }
                    this.f12025a.f12021c.mo29384a(new OguryError(1005, aabba.aaaaa.m14999b((String) aaaab.f12148a)));
                }
            });
            if (!accbb.m15217a((Object) (String) aaaab.f12148a, (Object) "ok")) {
                new abaca();
                abaca.m15099a((String) aaaab.f12148a, this.f12021c);
            }
            return acbba.f12137a;
        }
    }

    /* renamed from: com.ogury.cm.aacab$aaaac */
    public static final class aaaac implements abcac {

        /* renamed from: a */
        final /* synthetic */ aacab f12028a;

        /* renamed from: b */
        final /* synthetic */ WebView f12029b;

        aaaac(aacab aacab, WebView webView) {
            this.f12028a = aacab;
            this.f12029b = webView;
        }

        /* renamed from: a */
        public final void mo29426a(String str) {
            accbb.m15218b(str, "jsonResult");
            aacab.m15014a(str, this.f12029b);
            abcbc.f12099a.setBillingFinishedListener((abcac) null);
        }
    }

    /* renamed from: a */
    private static String m15010a(String str) {
        String str2;
        if (str != null) {
            str2 = ", \"" + aabba.aaaaa.m14997a(str) + '\"';
        } else {
            str2 = "";
        }
        StringBuilder sb = new StringBuilder("javascript:(function(){ogFormBridge.init(\"");
        aacca aacca = aacca.f12035a;
        sb.append(aabba.aaaaa.m14997a(aacca.m15041f()));
        sb.append('\"');
        sb.append(str2);
        sb.append(")})()");
        return sb.toString();
    }

    /* renamed from: a */
    private static void m15011a(Context context) {
        if (context instanceof ConsentActivity) {
            ((ConsentActivity) context).finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m15012a(WebView webView, String str) {
        webView.setVisibility(0);
        webView.loadUrl(m15010a(str));
    }

    /* renamed from: a */
    public static void m15014a(String str, WebView webView) {
        accbb.m15218b(str, "jsonResult");
        accbb.m15218b(webView, "webView");
        webView.loadUrl("javascript:(function(){ogFormBridge.purchase(\"" + aabba.aaaaa.m14997a(str) + "\")})()");
    }

    /* renamed from: a */
    public final void mo29423a(String str, Context context, aacbc aacbc, WebView webView) {
        String str2 = str;
        Context context2 = context;
        aacbc aacbc2 = aacbc;
        WebView webView2 = webView;
        accbb.m15218b(str2, "url");
        accbb.m15218b(context2, "context");
        accbb.m15218b(aacbc2, "callback");
        accbb.m15218b(webView2, "webView");
        Locale locale = Locale.US;
        accbb.m15215a((Object) locale, "Locale.US");
        String lowerCase = str2.toLowerCase(locale);
        accbb.m15215a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        boolean z = false;
        if (baacc.m15252a(lowerCase, "https://ogyconsent", false, 2, (Object) null)) {
            String substring = str2.substring(20);
            accbb.m15215a((Object) substring, "(this as java.lang.String).substring(startIndex)");
            if (baacc.m15252a(substring, "consent=", false, 2, (Object) null)) {
                abbba.aaaaa aaaaa2 = abbba.f12082a;
                abbba.aaaaa.m15133a().mo29480a(substring, false);
                aacca aacca = aacca.f12035a;
                if (aacca.m15045j()) {
                    StringBuilder sb = new StringBuilder("parsedConfig=");
                    aacca aacca2 = aacca.f12035a;
                    sb.append(aacca.m15040e());
                    aacbc2.mo29385a(sb.toString());
                } else {
                    aacca aacca3 = aacca.f12035a;
                    aacbc2.mo29384a(aacca.m15040e().mo29483b());
                }
                m15011a(context);
                abcbc.f12099a.endDataSourceConnections();
            } else if (baacc.m15252a(substring, "ogyRedirect=", false, 2, (Object) null)) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(babac.m15263a(substring, "ogyRedirect=", (String) null, 2, (Object) null)));
                    if (context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0) {
                        z = true;
                    }
                    if (z) {
                        context2.startActivity(intent);
                    }
                } catch (Exception e) {
                    aaccc aaccc = aaccc.f12045a;
                    aaccc.m15049a((Throwable) e);
                }
            } else if (!baacc.m15252a(substring, "error=", false, 2, (Object) null)) {
            } else {
                if (substring != null) {
                    String substring2 = substring.substring(6);
                    accbb.m15215a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
                    aacbc2.mo29384a(new OguryError(1003, baacc.m15246a(baacc.m15246a(substring2, "%20", " ", false, 4, (Object) null), "%22", "\"", false, 4, (Object) null)));
                    m15011a(context);
                    return;
                }
                throw new acbab("null cannot be cast to non-null type java.lang.String");
            }
        } else if (babac.m15265a((CharSequence) str2, (CharSequence) "?ready", false, 2, (Object) null)) {
            if (abcbc.f12099a.isProductActivated()) {
                acbca.m15204a(false, false, (ClassLoader) null, (String) null, 0, new aaaab(this, webView2, aacbc2), 31, (Object) null);
                return;
            }
            m15012a(webView2, (String) null);
            aacbc2.mo29385a("ready");
        } else if (babac.m15265a((CharSequence) str2, (CharSequence) "?success", false, 2, (Object) null)) {
            aacbc2.mo29385a(GraphResponse.SUCCESS_KEY);
        } else if (babac.m15265a((CharSequence) str2, (CharSequence) "?purchase", false, 2, (Object) null)) {
            abcbc.f12099a.setBillingFinishedListener(new aaaac(this, webView2));
            abcbc abcbc = abcbc.f12099a;
            if (context2 != null) {
                abcbc.launchBillingFlow((Activity) context2);
                return;
            }
            throw new acbab("null cannot be cast to non-null type android.app.Activity");
        }
    }
}
