package com.moat.analytics.mobile.vng;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.facebook.internal.AnalyticsEvents;
import com.moat.analytics.mobile.vng.C4395j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.moat.analytics.mobile.vng.b */
abstract class C4377b {

    /* renamed from: a */
    C4403n f11720a = null;

    /* renamed from: b */
    WeakReference<WebView> f11721b;

    /* renamed from: c */
    C4395j f11722c;

    /* renamed from: d */
    TrackerListener f11723d;

    /* renamed from: e */
    final String f11724e;

    /* renamed from: f */
    final boolean f11725f;

    /* renamed from: g */
    private WeakReference<View> f11726g;

    /* renamed from: h */
    private final C4439z f11727h;

    /* renamed from: i */
    private final boolean f11728i;

    /* renamed from: j */
    private boolean f11729j;

    /* renamed from: k */
    private boolean f11730k;

    C4377b(View view, boolean z, boolean z2) {
        String str;
        C4409p.m14772a(3, "BaseTracker", (Object) this, "Initializing.");
        if (z) {
            str = "m" + hashCode();
        } else {
            str = "";
        }
        this.f11724e = str;
        this.f11726g = new WeakReference<>(view);
        this.f11728i = z;
        this.f11725f = z2;
        this.f11729j = false;
        this.f11730k = false;
        this.f11727h = new C4439z();
    }

    /* renamed from: i */
    private void mo29279i() {
        String str;
        C4409p.m14772a(3, "BaseTracker", (Object) this, "Attempting bridge installation.");
        if (this.f11721b.get() != null) {
            this.f11722c = new C4395j((WebView) this.f11721b.get(), C4395j.C4399a.WEBVIEW);
            str = "Bridge installed.";
        } else {
            this.f11722c = null;
            str = "Bridge not installed, WebView is null.";
        }
        C4409p.m14772a(3, "BaseTracker", (Object) this, str);
    }

    /* renamed from: j */
    private void mo29280j() {
        if (this.f11729j) {
            throw new C4403n("Tracker already started");
        }
    }

    /* renamed from: k */
    private void mo29281k() {
        if (this.f11730k) {
            throw new C4403n("Tracker already stopped");
        }
    }

    /* renamed from: l */
    private boolean mo29282l() {
        return this.f11728i || this.f11725f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract String mo29257a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29258a(WebView webView) {
        if (webView != null) {
            this.f11721b = new WeakReference<>(webView);
            if (this.f11722c == null && !mo29282l()) {
                mo29279i();
            }
            C4395j jVar = this.f11722c;
            if (jVar != null) {
                jVar.mo29313a(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29259a(C4395j jVar) {
        this.f11722c = jVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29260a(String str, Exception exc) {
        try {
            C4403n.m14758a(exc);
            String a = C4403n.m14756a(str, exc);
            if (this.f11723d != null) {
                this.f11723d.onTrackingFailedToStart(a);
            }
            C4409p.m14772a(3, "BaseTracker", (Object) this, a);
            C4409p.m14775a("[ERROR] ", mo29257a() + " " + a);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29261a(List<String> list) {
        if (mo29267f() == null && !this.f11725f) {
            list.add("Tracker's target view is null");
        }
        if (!list.isEmpty()) {
            throw new C4403n(TextUtils.join(" and ", list));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29262b() {
        C4409p.m14772a(3, "BaseTracker", (Object) this, "Attempting to start impression.");
        mo29263c();
        mo29265d();
        mo29261a((List<String>) new ArrayList());
        C4395j jVar = this.f11722c;
        if (jVar != null) {
            jVar.mo29317b(this);
            this.f11729j = true;
            C4409p.m14772a(3, "BaseTracker", (Object) this, "Impression started.");
            return;
        }
        C4409p.m14772a(3, "BaseTracker", (Object) this, "Bridge is null, won't start tracking");
        throw new C4403n("Bridge is null");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo29263c() {
        if (this.f11720a != null) {
            throw new C4403n("Tracker initialization failed: " + this.f11720a.getMessage());
        }
    }

    public void changeTargetView(View view) {
        C4409p.m14772a(3, "BaseTracker", (Object) this, "changing view to " + C4409p.m14770a(view));
        this.f11726g = new WeakReference<>(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo29265d() {
        mo29280j();
        mo29281k();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo29266e() {
        return this.f11729j && !this.f11730k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public View mo29267f() {
        return (View) this.f11726g.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public String mo29268g() {
        return C4409p.m14770a(mo29267f());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public String mo29269h() {
        this.f11727h.mo29348a(this.f11724e, mo29267f());
        return this.f11727h.f11896a;
    }

    public void removeListener() {
        this.f11723d = null;
    }

    @Deprecated
    public void setActivity(Activity activity) {
    }

    public void setListener(TrackerListener trackerListener) {
        this.f11723d = trackerListener;
    }

    public void startTracking() {
        try {
            C4409p.m14772a(3, "BaseTracker", (Object) this, "In startTracking method.");
            mo29262b();
            if (this.f11723d != null) {
                this.f11723d.onTrackingStarted("Tracking started on " + mo29268g());
            }
            String str = "startTracking succeeded for " + mo29268g();
            C4409p.m14772a(3, "BaseTracker", (Object) this, str);
            C4409p.m14775a("[SUCCESS] ", mo29257a() + " " + str);
        } catch (Exception e) {
            mo29260a("startTracking", e);
        }
    }

    public void stopTracking() {
        boolean z = false;
        try {
            C4409p.m14772a(3, "BaseTracker", (Object) this, "In stopTracking method.");
            this.f11730k = true;
            if (this.f11722c != null) {
                this.f11722c.mo29319c(this);
                z = true;
            }
        } catch (Exception e) {
            C4403n.m14758a(e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Attempt to stop tracking ad impression was ");
        sb.append(z ? "" : "un");
        sb.append("successful.");
        C4409p.m14772a(3, "BaseTracker", (Object) this, sb.toString());
        String str = z ? "[SUCCESS] " : "[ERROR] ";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo29257a());
        sb2.append(" stopTracking ");
        sb2.append(z ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
        sb2.append(" for ");
        sb2.append(mo29268g());
        C4409p.m14775a(str, sb2.toString());
        TrackerListener trackerListener = this.f11723d;
        if (trackerListener != null) {
            trackerListener.onTrackingStopped("");
            this.f11723d = null;
        }
    }
}
