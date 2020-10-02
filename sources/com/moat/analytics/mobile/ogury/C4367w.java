package com.moat.analytics.mobile.ogury;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.ogury.C4315e;

/* renamed from: com.moat.analytics.mobile.ogury.w */
final class C4367w extends C4310c implements WebAdTracker {
    C4367w(ViewGroup viewGroup) {
        this(C4361u.m14587(viewGroup, false).orElse(null));
        if (viewGroup == null) {
            String concat = "WebAdTracker initialization not successful, ".concat("Target ViewGroup is null");
            C4315e.C43161.m14442(3, "WebAdTracker", this, concat);
            C4315e.C43161.m14446("[ERROR] ", concat);
            this.f11498 = new C4332l("Target ViewGroup is null");
        }
        if (this.f11495 == null) {
            String concat2 = "WebAdTracker initialization not successful, ".concat("No WebView to track inside of ad container");
            C4315e.C43161.m14442(3, "WebAdTracker", this, concat2);
            C4315e.C43161.m14446("[ERROR] ", concat2);
            this.f11498 = new C4332l("No WebView to track inside of ad container");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ */
    public final String mo29116() {
        return "WebAdTracker";
    }

    C4367w(WebView webView) {
        super(webView, false, false);
        C4315e.C43161.m14442(3, "WebAdTracker", this, "Initializing.");
        if (webView == null) {
            String concat = "WebAdTracker initialization not successful, ".concat("WebView is null");
            C4315e.C43161.m14442(3, "WebAdTracker", this, concat);
            C4315e.C43161.m14446("[ERROR] ", concat);
            this.f11498 = new C4332l("WebView is null");
            return;
        }
        try {
            super.mo29113(webView);
            StringBuilder sb = new StringBuilder("WebAdTracker created for ");
            sb.append(mo29108());
            C4315e.C43161.m14446("[SUCCESS] ", sb.toString());
        } catch (C4332l e) {
            this.f11498 = e;
        }
    }
}
