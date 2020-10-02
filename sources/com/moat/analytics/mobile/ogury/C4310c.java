package com.moat.analytics.mobile.ogury;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.facebook.internal.AnalyticsEvents;
import com.moat.analytics.mobile.ogury.C4315e;
import com.moat.analytics.mobile.ogury.C4317f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.moat.analytics.mobile.ogury.c */
abstract class C4310c {

    /* renamed from: ʻ */
    private final C4362v f11492;

    /* renamed from: ʼ */
    private boolean f11493;

    /* renamed from: ʽ */
    private WeakReference<View> f11494;

    /* renamed from: ˊ */
    WeakReference<WebView> f11495;

    /* renamed from: ˋ */
    C4317f f11496;

    /* renamed from: ˋॱ */
    private boolean f11497;

    /* renamed from: ˎ */
    C4332l f11498 = null;

    /* renamed from: ˏ */
    TrackerListener f11499;

    /* renamed from: ॱ */
    final String f11500;

    /* renamed from: ॱॱ */
    private final boolean f11501;

    /* renamed from: ᐝ */
    final boolean f11502;

    C4310c(View view, boolean z, boolean z2) {
        String str;
        C4315e.C43161.m14442(3, "BaseTracker", this, "Initializing.");
        if (z) {
            StringBuilder sb = new StringBuilder("m");
            sb.append(hashCode());
            str = sb.toString();
        } else {
            str = "";
        }
        this.f11500 = str;
        this.f11494 = new WeakReference<>(view);
        this.f11501 = z;
        this.f11502 = z2;
        this.f11493 = false;
        this.f11497 = false;
        this.f11492 = new C4362v();
    }

    public void changeTargetView(View view) {
        StringBuilder sb = new StringBuilder("changing view to ");
        sb.append(C4315e.C43161.m14444(view));
        C4315e.C43161.m14442(3, "BaseTracker", this, sb.toString());
        this.f11494 = new WeakReference<>(view);
    }

    public void removeListener() {
        this.f11499 = null;
    }

    @Deprecated
    public void setActivity(Activity activity) {
    }

    public void setListener(TrackerListener trackerListener) {
        this.f11499 = trackerListener;
    }

    public void startTracking() {
        try {
            C4315e.C43161.m14442(3, "BaseTracker", this, "In startTracking method.");
            mo29115();
            if (this.f11499 != null) {
                TrackerListener trackerListener = this.f11499;
                StringBuilder sb = new StringBuilder("Tracking started on ");
                sb.append(C4315e.C43161.m14444(this.f11494.get()));
                trackerListener.onTrackingStarted(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder("startTracking succeeded for ");
            sb2.append(C4315e.C43161.m14444(this.f11494.get()));
            String obj = sb2.toString();
            C4315e.C43161.m14442(3, "BaseTracker", this, obj);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(mo29116());
            sb3.append(" ");
            sb3.append(obj);
            C4315e.C43161.m14446("[SUCCESS] ", sb3.toString());
        } catch (Exception e) {
            mo29114("startTracking", e);
        }
    }

    public void stopTracking() {
        boolean z = false;
        try {
            C4315e.C43161.m14442(3, "BaseTracker", this, "In stopTracking method.");
            this.f11497 = true;
            if (this.f11496 != null) {
                this.f11496.mo29144(this);
                z = true;
            }
        } catch (Exception e) {
            C4332l.m14509(e);
        }
        StringBuilder sb = new StringBuilder("Attempt to stop tracking ad impression was ");
        sb.append(z ? "" : "un");
        sb.append("successful.");
        C4315e.C43161.m14442(3, "BaseTracker", this, sb.toString());
        String str = z ? "[SUCCESS] " : "[ERROR] ";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(mo29116());
        sb2.append(" stopTracking ");
        sb2.append(z ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
        sb2.append(" for ");
        sb2.append(C4315e.C43161.m14444(this.f11494.get()));
        C4315e.C43161.m14446(str, sb2.toString());
        TrackerListener trackerListener = this.f11499;
        if (trackerListener != null) {
            trackerListener.onTrackingStopped("");
            this.f11499 = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʻ */
    public final String mo29108() {
        return C4315e.C43161.m14444(this.f11494.get());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʽ */
    public final String mo29109() {
        this.f11492.mo29192(this.f11500, this.f11494.get());
        return this.f11492.f11686;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ */
    public final boolean mo29111() {
        return this.f11493 && !this.f11497;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ */
    public final void mo29113(WebView webView) throws C4332l {
        if (webView != null) {
            this.f11495 = new WeakReference<>(webView);
            if (this.f11496 == null) {
                if (!(this.f11501 || this.f11502)) {
                    C4315e.C43161.m14442(3, "BaseTracker", this, "Attempting bridge installation.");
                    if (this.f11495.get() != null) {
                        this.f11496 = new C4317f(this.f11495.get(), C4317f.C4321a.f11550);
                        C4315e.C43161.m14442(3, "BaseTracker", this, "Bridge installed.");
                    } else {
                        this.f11496 = null;
                        C4315e.C43161.m14442(3, "BaseTracker", this, "Bridge not installed, WebView is null.");
                    }
                }
            }
            C4317f fVar = this.f11496;
            if (fVar != null) {
                fVar.mo29143(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ */
    public void mo29115() throws C4332l {
        C4315e.C43161.m14442(3, "BaseTracker", this, "Attempting to start impression.");
        mo29117();
        if (this.f11493) {
            throw new C4332l("Tracker already started");
        } else if (!this.f11497) {
            mo29110(new ArrayList());
            C4317f fVar = this.f11496;
            if (fVar != null) {
                fVar.mo29141(this);
                this.f11493 = true;
                C4315e.C43161.m14442(3, "BaseTracker", this, "Impression started.");
                return;
            }
            C4315e.C43161.m14442(3, "BaseTracker", this, "Bridge is null, won't start tracking");
            throw new C4332l("Bridge is null");
        } else {
            throw new C4332l("Tracker already stopped");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ */
    public abstract String mo29116();

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ */
    public final void mo29117() throws C4332l {
        if (this.f11498 != null) {
            StringBuilder sb = new StringBuilder("Tracker initialization failed: ");
            sb.append(this.f11498.getMessage());
            throw new C4332l(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱॱ */
    public final View mo29118() {
        return this.f11494.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ */
    public void mo29110(List<String> list) throws C4332l {
        if (this.f11494.get() == null && !this.f11502) {
            list.add("Tracker's target view is null");
        }
        if (!list.isEmpty()) {
            throw new C4332l(TextUtils.join(" and ", list));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ */
    public final void mo29114(String str, Exception exc) {
        try {
            C4332l.m14509(exc);
            String r3 = C4332l.m14507(str, exc);
            if (this.f11499 != null) {
                this.f11499.onTrackingFailedToStart(r3);
            }
            C4315e.C43161.m14442(3, "BaseTracker", this, r3);
            StringBuilder sb = new StringBuilder();
            sb.append(mo29116());
            sb.append(" ");
            sb.append(r3);
            C4315e.C43161.m14446("[ERROR] ", sb.toString());
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ */
    public final void mo29112() throws C4332l {
        if (this.f11493) {
            throw new C4332l("Tracker already started");
        } else if (this.f11497) {
            throw new C4332l("Tracker already stopped");
        }
    }
}
