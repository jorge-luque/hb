package com.moat.analytics.mobile.ogury;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.ogury.C4315e;
import com.moat.analytics.mobile.ogury.C4342p;
import com.moat.analytics.mobile.ogury.NoOp;
import com.moat.analytics.mobile.ogury.base.functional.Optional;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.moat.analytics.mobile.ogury.o */
final class C4337o extends MoatFactory {
    C4337o() throws C4332l {
        if (!((C4328i) MoatAnalytics.getInstance()).mo29164()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to initialize MoatFactory");
            sb.append(", SDK was not started");
            String obj = sb.toString();
            C4315e.C43161.m14442(3, "Factory", this, obj);
            C4315e.C43161.m14446("[ERROR] ", obj);
            throw new C4332l("Failed to initialize MoatFactory");
        }
    }

    public final <T> T createCustomTracker(C4336n<T> nVar) {
        try {
            return nVar.create();
        } catch (Exception e) {
            C4332l.m14509(e);
            return nVar.createNoOp();
        }
    }

    public final NativeDisplayTracker createNativeDisplayTracker(View view, final Map<String, String> map) {
        try {
            final WeakReference weakReference = new WeakReference(view);
            return (NativeDisplayTracker) C4342p.m14534(new C4342p.C4344b<NativeDisplayTracker>() {
                /* renamed from: ˏ */
                public final Optional<NativeDisplayTracker> mo29084() {
                    View view = (View) weakReference.get();
                    StringBuilder sb = new StringBuilder("Attempting to create NativeDisplayTracker for ");
                    sb.append(C4315e.C43161.m14444(view));
                    String obj = sb.toString();
                    C4315e.C43161.m14442(3, "Factory", this, obj);
                    C4315e.C43161.m14446("[INFO] ", obj);
                    return Optional.m14414of(new C4360t(view, map));
                }
            }, NativeDisplayTracker.class);
        } catch (Exception e) {
            C4332l.m14509(e);
            return new NoOp.C4304d();
        }
    }

    public final NativeVideoTracker createNativeVideoTracker(final String str) {
        try {
            return (NativeVideoTracker) C4342p.m14534(new C4342p.C4344b<NativeVideoTracker>() {
                /* renamed from: ˏ */
                public final Optional<NativeVideoTracker> mo29084() {
                    C4315e.C43161.m14442(3, "Factory", this, "Attempting to create NativeVideoTracker");
                    C4315e.C43161.m14446("[INFO] ", "Attempting to create NativeVideoTracker");
                    return Optional.m14414of(new C4355r(str));
                }
            }, NativeVideoTracker.class);
        } catch (Exception e) {
            C4332l.m14509(e);
            return new NoOp.C4302a();
        }
    }

    public final WebAdTracker createWebAdTracker(WebView webView) {
        try {
            final WeakReference weakReference = new WeakReference(webView);
            return (WebAdTracker) C4342p.m14534(new C4342p.C4344b<WebAdTracker>() {
                /* renamed from: ˏ */
                public final Optional<WebAdTracker> mo29084() {
                    WebView webView = (WebView) weakReference.get();
                    StringBuilder sb = new StringBuilder("Attempting to create WebAdTracker for ");
                    sb.append(C4315e.C43161.m14444(webView));
                    String obj = sb.toString();
                    C4315e.C43161.m14442(3, "Factory", this, obj);
                    C4315e.C43161.m14446("[INFO] ", obj);
                    return Optional.m14414of(new C4367w(webView));
                }
            }, WebAdTracker.class);
        } catch (Exception e) {
            C4332l.m14509(e);
            return new NoOp.C4303b();
        }
    }

    public final WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
        try {
            final WeakReference weakReference = new WeakReference(viewGroup);
            return (WebAdTracker) C4342p.m14534(new C4342p.C4344b<WebAdTracker>() {
                /* renamed from: ˏ */
                public final Optional<WebAdTracker> mo29084() throws C4332l {
                    ViewGroup viewGroup = (ViewGroup) weakReference.get();
                    StringBuilder sb = new StringBuilder("Attempting to create WebAdTracker for adContainer ");
                    sb.append(C4315e.C43161.m14444(viewGroup));
                    String obj = sb.toString();
                    C4315e.C43161.m14442(3, "Factory", this, obj);
                    C4315e.C43161.m14446("[INFO] ", obj);
                    return Optional.m14414of(new C4367w(viewGroup));
                }
            }, WebAdTracker.class);
        } catch (Exception e) {
            C4332l.m14509(e);
            return new NoOp.C4303b();
        }
    }
}
