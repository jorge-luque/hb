package com.moat.analytics.mobile.vng;

import android.view.ViewGroup;
import android.webkit.WebView;

/* renamed from: com.moat.analytics.mobile.vng.aa */
class C4375aa extends C4377b implements WebAdTracker {
    C4375aa(ViewGroup viewGroup) {
        this(C4376ab.m14631a(viewGroup, false).mo29252c(null));
        if (viewGroup == null) {
            C4409p.m14773a("[ERROR] ", 3, "WebAdTracker", this, "WebAdTracker initialization not successful, " + "Target ViewGroup is null");
            this.f11720a = new C4403n("Target ViewGroup is null");
        }
        if (this.f11721b == null) {
            C4409p.m14773a("[ERROR] ", 3, "WebAdTracker", this, "WebAdTracker initialization not successful, " + "No WebView to track inside of ad container");
            this.f11720a = new C4403n("No WebView to track inside of ad container");
        }
    }

    C4375aa(WebView webView) {
        super(webView, false, false);
        C4409p.m14772a(3, "WebAdTracker", (Object) this, "Initializing.");
        if (webView == null) {
            C4409p.m14773a("[ERROR] ", 3, "WebAdTracker", this, "WebAdTracker initialization not successful, " + "WebView is null");
            this.f11720a = new C4403n("WebView is null");
            return;
        }
        try {
            super.mo29258a(webView);
            C4409p.m14775a("[SUCCESS] ", mo29257a() + " created for " + mo29268g());
        } catch (C4403n e) {
            this.f11720a = e;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo29257a() {
        return "WebAdTracker";
    }
}
