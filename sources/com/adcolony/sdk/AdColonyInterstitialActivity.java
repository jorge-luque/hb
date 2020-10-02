package com.adcolony.sdk;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdColonyInterstitialActivity extends C1202b {

    /* renamed from: m */
    AdColonyInterstitial f3311m;

    /* renamed from: n */
    private C1288g f3312n;

    public AdColonyInterstitialActivity() {
        AdColonyInterstitial adColonyInterstitial;
        if (!C1199a.m4882e()) {
            adColonyInterstitial = null;
        } else {
            adColonyInterstitial = C1199a.m4880c().mo6536d();
        }
        this.f3311m = adColonyInterstitial;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6341a(C1454x xVar) {
        AdColonyInterstitial adColonyInterstitial;
        super.mo6341a(xVar);
        C1222d b = C1199a.m4880c().mo6530b();
        JSONObject g = C1437s.m5612g(xVar.mo6830b(), "v4iap");
        JSONArray c = C1437s.m5604c(g, "product_ids");
        if (!(g == null || (adColonyInterstitial = this.f3311m) == null || adColonyInterstitial.getListener() == null || c.length() <= 0)) {
            this.f3311m.getListener().onIAPEvent(this.f3311m, C1437s.m5607d(c, 0), C1437s.m5611f(g, "engagement_type"));
        }
        b.mo6454a(this.f3343a);
        if (this.f3311m != null) {
            b.mo6453a().remove(this.f3311m.mo6324b());
        }
        AdColonyInterstitial adColonyInterstitial2 = this.f3311m;
        if (!(adColonyInterstitial2 == null || adColonyInterstitial2.getListener() == null)) {
            this.f3311m.getListener().onClosed(this.f3311m);
            this.f3311m.mo6319a((C1205c) null);
            this.f3311m.setListener((AdColonyInterstitialListener) null);
            this.f3311m = null;
        }
        C1288g gVar = this.f3312n;
        if (gVar != null) {
            gVar.mo6505a();
            this.f3312n = null;
        }
    }

    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        AdColonyInterstitial adColonyInterstitial;
        AdColonyInterstitial adColonyInterstitial2 = this.f3311m;
        this.f3345c = adColonyInterstitial2 == null ? -1 : adColonyInterstitial2.mo6332f();
        super.onCreate(bundle);
        if (C1199a.m4882e() && (adColonyInterstitial = this.f3311m) != null) {
            C1218c0 e = adColonyInterstitial.mo6331e();
            if (e != null) {
                e.mo6444a(this.f3343a);
            }
            this.f3312n = new C1288g(new Handler(Looper.getMainLooper()), this.f3311m);
            if (this.f3311m.getListener() != null) {
                this.f3311m.getListener().onOpened(this.f3311m);
            }
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
