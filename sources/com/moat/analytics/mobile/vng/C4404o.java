package com.moat.analytics.mobile.vng;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.vng.C4418v;
import com.moat.analytics.mobile.vng.C4434x;
import com.moat.analytics.mobile.vng.p156a.p158b.C4374a;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.vng.o */
class C4404o extends MoatFactory {
    C4404o() {
        if (!m14765a()) {
            C4409p.m14773a("[ERROR] ", 3, "Factory", this, "Failed to initialize MoatFactory" + ", SDK was not started");
            throw new C4403n("Failed to initialize MoatFactory");
        }
    }

    /* renamed from: a */
    private NativeDisplayTracker m14760a(View view, final Map<String, String> map) {
        final WeakReference weakReference = new WeakReference(view);
        return (NativeDisplayTracker) C4434x.m14829a(new C4434x.C4436a<NativeDisplayTracker>() {
            /* renamed from: a */
            public C4374a<NativeDisplayTracker> mo29234a() {
                View view = (View) weakReference.get();
                C4409p.m14773a("[INFO] ", 3, "Factory", this, "Attempting to create NativeDisplayTracker for " + C4409p.m14770a(view));
                return C4374a.m14625a(new C4416t(view, map));
            }
        }, NativeDisplayTracker.class);
    }

    /* renamed from: a */
    private NativeVideoTracker m14761a(final String str) {
        return (NativeVideoTracker) C4434x.m14829a(new C4434x.C4436a<NativeVideoTracker>() {
            /* renamed from: a */
            public C4374a<NativeVideoTracker> mo29234a() {
                C4409p.m14773a("[INFO] ", 3, "Factory", this, "Attempting to create NativeVideoTracker");
                return C4374a.m14625a(new C4417u(str));
            }
        }, NativeVideoTracker.class);
    }

    /* renamed from: a */
    private WebAdTracker m14762a(ViewGroup viewGroup) {
        final WeakReference weakReference = new WeakReference(viewGroup);
        return (WebAdTracker) C4434x.m14829a(new C4434x.C4436a<WebAdTracker>() {
            /* renamed from: a */
            public C4374a<WebAdTracker> mo29234a() {
                ViewGroup viewGroup = (ViewGroup) weakReference.get();
                C4409p.m14773a("[INFO] ", 3, "Factory", this, "Attempting to create WebAdTracker for adContainer " + C4409p.m14770a((View) viewGroup));
                return C4374a.m14625a(new C4375aa(viewGroup));
            }
        }, WebAdTracker.class);
    }

    /* renamed from: a */
    private WebAdTracker m14763a(WebView webView) {
        final WeakReference weakReference = new WeakReference(webView);
        return (WebAdTracker) C4434x.m14829a(new C4434x.C4436a<WebAdTracker>() {
            /* renamed from: a */
            public C4374a<WebAdTracker> mo29234a() {
                WebView webView = (WebView) weakReference.get();
                C4409p.m14773a("[INFO] ", 3, "Factory", this, "Attempting to create WebAdTracker for " + C4409p.m14770a((View) webView));
                return C4374a.m14625a(new C4375aa(webView));
            }
        }, WebAdTracker.class);
    }

    /* renamed from: a */
    private <T> T m14764a(MoatPlugin<T> moatPlugin) {
        return moatPlugin.mo29204a();
    }

    /* renamed from: a */
    private boolean m14765a() {
        return ((C4400k) MoatAnalytics.getInstance()).mo29326a();
    }

    public <T> T createCustomTracker(MoatPlugin<T> moatPlugin) {
        try {
            return m14764a(moatPlugin);
        } catch (Exception e) {
            C4403n.m14758a(e);
            return moatPlugin.mo29205b();
        }
    }

    public NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map) {
        try {
            return m14760a(view, map);
        } catch (Exception e) {
            C4403n.m14758a(e);
            return new C4418v.C4421c();
        }
    }

    public NativeVideoTracker createNativeVideoTracker(String str) {
        try {
            return m14761a(str);
        } catch (Exception e) {
            C4403n.m14758a(e);
            return new C4418v.C4422d();
        }
    }

    public WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
        try {
            return m14762a(viewGroup);
        } catch (Exception e) {
            C4403n.m14758a(e);
            return new C4418v.C4423e();
        }
    }

    public WebAdTracker createWebAdTracker(WebView webView) {
        try {
            return m14763a(webView);
        } catch (Exception e) {
            C4403n.m14758a(e);
            return new C4418v.C4423e();
        }
    }
}
