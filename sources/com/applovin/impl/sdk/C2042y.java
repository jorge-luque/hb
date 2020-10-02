package com.applovin.impl.sdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.applovin.impl.mediation.p045b.C1698b;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.sdk.y */
public class C2042y {

    /* renamed from: a */
    private final C1941j f6768a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1977q f6769b;

    /* renamed from: c */
    private final Object f6770c = new Object();

    /* renamed from: d */
    private final Rect f6771d = new Rect();

    /* renamed from: e */
    private final Handler f6772e;

    /* renamed from: f */
    private final Runnable f6773f;

    /* renamed from: g */
    private final ViewTreeObserver.OnPreDrawListener f6774g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final WeakReference<MaxAdView> f6775h;

    /* renamed from: i */
    private WeakReference<ViewTreeObserver> f6776i = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */

    /* renamed from: j */
    public WeakReference<View> f6777j = new WeakReference<>((Object) null);

    /* renamed from: k */
    private int f6778k;

    /* renamed from: l */
    private long f6779l;

    /* renamed from: m */
    private long f6780m = Long.MIN_VALUE;

    /* renamed from: com.applovin.impl.sdk.y$a */
    public interface C2045a {
        void onLogVisibilityImpression();
    }

    public C2042y(MaxAdView maxAdView, C1941j jVar, C2045a aVar) {
        this.f6768a = jVar;
        this.f6769b = jVar.mo8602v();
        this.f6772e = new Handler(Looper.getMainLooper());
        this.f6775h = new WeakReference<>(maxAdView);
        final WeakReference weakReference = new WeakReference(aVar);
        this.f6773f = new Runnable() {
            public void run() {
                MaxAdView maxAdView = (MaxAdView) C2042y.this.f6775h.get();
                View view = (View) C2042y.this.f6777j.get();
                if (maxAdView != null && view != null) {
                    if (C2042y.this.m8082b(maxAdView, view)) {
                        C2042y.this.f6769b.mo8742b("VisibilityTracker", "View met visibility requirements. Logging visibility impression..");
                        C2042y.this.mo8854a();
                        C2045a aVar = (C2045a) weakReference.get();
                        if (aVar != null) {
                            aVar.onLogVisibilityImpression();
                            return;
                        }
                        return;
                    }
                    C2042y.this.m8081b();
                }
            }
        };
        this.f6774g = new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                C2042y.this.f6769b.mo8742b("VisibilityTracker", "View is being drawn, checking visibility...");
                C2042y.this.m8081b();
                C2042y.this.m8084c();
                return true;
            }
        };
    }

    /* renamed from: a */
    private void m8077a(View view) {
        View a = C2029r.m7991a((View) this.f6775h.get());
        if (a == null) {
            a = C2029r.m7991a(view);
        }
        if (a == null) {
            this.f6769b.mo8742b("VisibilityTracker", "Unable to set view tree observer due to no root view.");
            return;
        }
        ViewTreeObserver viewTreeObserver = a.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            this.f6769b.mo8745d("VisibilityTracker", "Unable to set view tree observer since the view tree observer is not alive.");
            return;
        }
        this.f6776i = new WeakReference<>(viewTreeObserver);
        viewTreeObserver.addOnPreDrawListener(this.f6774g);
    }

    /* renamed from: a */
    private boolean m8078a(View view, View view2) {
        return view2 != null && view2.getVisibility() == 0 && view.getParent() != null && view2.getWidth() > 0 && view2.getHeight() > 0 && view2.getGlobalVisibleRect(this.f6771d) && ((long) (AppLovinSdkUtils.pxToDp(view2.getContext(), this.f6771d.width()) * AppLovinSdkUtils.pxToDp(view2.getContext(), this.f6771d.height()))) >= ((long) this.f6778k);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8081b() {
        this.f6772e.postDelayed(this.f6773f, ((Long) this.f6768a.mo8549a(C1841c.f5939ch)).longValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m8082b(View view, View view2) {
        if (!m8078a(view, view2)) {
            return false;
        }
        if (this.f6780m == Long.MIN_VALUE) {
            this.f6780m = SystemClock.uptimeMillis();
        }
        return SystemClock.uptimeMillis() - this.f6780m >= this.f6779l;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m8084c() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f6776i.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f6774g);
        }
        this.f6776i.clear();
    }

    /* renamed from: a */
    public void mo8854a() {
        synchronized (this.f6770c) {
            this.f6772e.removeMessages(0);
            m8084c();
            this.f6780m = Long.MIN_VALUE;
            this.f6777j.clear();
        }
    }

    /* renamed from: a */
    public void mo8855a(C1698b bVar) {
        synchronized (this.f6770c) {
            this.f6769b.mo8742b("VisibilityTracker", "Tracking Visibility...");
            mo8854a();
            this.f6777j = new WeakReference<>(bVar.mo7782n());
            this.f6778k = bVar.mo7787s();
            this.f6779l = bVar.mo7789u();
            m8077a((View) this.f6777j.get());
        }
    }
}
