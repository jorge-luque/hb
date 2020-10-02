package com.adcolony.sdk;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;

public class AdColonyAdViewActivity extends C1202b {

    /* renamed from: m */
    AdColonyAdView f3285m;

    public AdColonyAdViewActivity() {
        AdColonyAdView adColonyAdView;
        if (!C1199a.m4882e()) {
            adColonyAdView = null;
        } else {
            adColonyAdView = C1199a.m4880c().mo6539e();
        }
        this.f3285m = adColonyAdView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6251b() {
        ViewParent parent = this.f3343a.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f3343a);
        }
        this.f3285m.mo6227a();
        C1199a.m4880c().mo6521a((AdColonyAdView) null);
        finish();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6252c() {
        this.f3285m.mo6228b();
    }

    public void onBackPressed() {
        mo6251b();
    }

    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        AdColonyAdView adColonyAdView;
        if (!C1199a.m4882e() || (adColonyAdView = this.f3285m) == null) {
            C1199a.m4880c().mo6521a((AdColonyAdView) null);
            finish();
            return;
        }
        this.f3345c = adColonyAdView.getOrientation();
        super.onCreate(bundle);
        this.f3285m.mo6228b();
        AdColonyAdViewListener listener = this.f3285m.getListener();
        if (listener != null) {
            listener.onOpened(this.f3285m);
        }
    }

    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    public /* bridge */ /* synthetic */ void onPause() {
        super.onPause();
    }

    public /* bridge */ /* synthetic */ void onResume() {
        super.onResume();
    }

    public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
