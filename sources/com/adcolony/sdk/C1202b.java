package com.adcolony.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.b */
class C1202b extends Activity {

    /* renamed from: k */
    static final int f3341k = 0;

    /* renamed from: l */
    static final int f3342l = 1;

    /* renamed from: a */
    C1205c f3343a;

    /* renamed from: b */
    String f3344b;

    /* renamed from: c */
    int f3345c = -1;

    /* renamed from: d */
    int f3346d;

    /* renamed from: e */
    boolean f3347e;

    /* renamed from: f */
    boolean f3348f;

    /* renamed from: g */
    boolean f3349g;

    /* renamed from: h */
    boolean f3350h;

    /* renamed from: i */
    boolean f3351i;

    /* renamed from: j */
    boolean f3352j;

    /* renamed from: com.adcolony.sdk.b$a */
    class C1203a implements C1458z {
        C1203a() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1202b.this.mo6341a(xVar);
        }
    }

    C1202b() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6393a(boolean z) {
        Iterator<Map.Entry<Integer, C1364l0>> it = this.f3343a.mo6430m().entrySet().iterator();
        while (it.hasNext() && !isFinishing()) {
            C1364l0 l0Var = (C1364l0) it.next().getValue();
            if (!l0Var.mo6684f() && l0Var.mo6680b().isPlaying()) {
                l0Var.mo6685h();
            }
        }
        AdColonyInterstitial d = C1199a.m4880c().mo6536d();
        if (d != null && d.mo6333g() && d.mo6331e().mo6448c() != null && z && this.f3351i) {
            d.mo6331e().mo6445a("pause");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6394b(boolean z) {
        for (Map.Entry<Integer, C1364l0> value : this.f3343a.mo6430m().entrySet()) {
            C1364l0 l0Var = (C1364l0) value.getValue();
            if (!l0Var.mo6684f() && !l0Var.mo6680b().isPlaying() && !C1199a.m4880c().mo6543i().mo6665b()) {
                l0Var.mo6686i();
            }
        }
        AdColonyInterstitial d = C1199a.m4880c().mo6536d();
        if (d != null && d.mo6333g() && d.mo6331e().mo6448c() != null) {
            if ((!z || !this.f3351i) && this.f3352j) {
                d.mo6331e().mo6445a("resume");
            }
        }
    }

    public void onBackPressed() {
        JSONObject b = C1437s.m5599b();
        C1437s.m5592a(b, "id", this.f3343a.mo6400a());
        new C1454x("AdSession.on_back_button", this.f3343a.mo6428k(), b).mo6834d();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this instanceof AdColonyInterstitialActivity) {
            mo6391a();
        } else {
            ((AdColonyAdViewActivity) this).mo6252c();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C1199a.m4882e() || C1199a.m4880c().mo6540f() == null) {
            finish();
            return;
        }
        C1290h c = C1199a.m4880c();
        this.f3349g = false;
        C1205c f = c.mo6540f();
        this.f3343a = f;
        f.mo6412c(false);
        if (C1359k0.m5335h()) {
            this.f3343a.mo6412c(true);
        }
        this.f3344b = this.f3343a.mo6400a();
        this.f3346d = this.f3343a.mo6428k();
        boolean multiWindowEnabled = c.mo6552r().getMultiWindowEnabled();
        this.f3350h = multiWindowEnabled;
        if (multiWindowEnabled) {
            getWindow().addFlags(2048);
            getWindow().clearFlags(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
        } else {
            getWindow().addFlags(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
            getWindow().clearFlags(2048);
        }
        requestWindowFeature(1);
        getWindow().getDecorView().setBackgroundColor(-16777216);
        if (c.mo6552r().getKeepScreenOn()) {
            getWindow().addFlags(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
        }
        ViewParent parent = this.f3343a.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f3343a);
        }
        setContentView(this.f3343a);
        this.f3343a.mo6424i().add(C1199a.m4873a("AdSession.finish_fullscreen_ad", (C1458z) new C1203a(), true));
        this.f3343a.mo6426j().add("AdSession.finish_fullscreen_ad");
        mo6392a(this.f3345c);
        if (!this.f3343a.mo6432o()) {
            JSONObject b = C1437s.m5599b();
            C1437s.m5592a(b, "id", this.f3343a.mo6400a());
            C1437s.m5602b(b, "screen_width", this.f3343a.mo6413d());
            C1437s.m5602b(b, "screen_height", this.f3343a.mo6406b());
            new C1454x("AdSession.on_fullscreen_ad_started", this.f3343a.mo6428k(), b).mo6834d();
            this.f3343a.mo6415d(true);
            return;
        }
        mo6391a();
    }

    public void onDestroy() {
        super.onDestroy();
        if (C1199a.m4882e() && this.f3343a != null && !this.f3347e) {
            if ((Build.VERSION.SDK_INT < 24 || !C1359k0.m5335h()) && !this.f3343a.mo6436q()) {
                JSONObject b = C1437s.m5599b();
                C1437s.m5592a(b, "id", this.f3343a.mo6400a());
                new C1454x("AdSession.on_error", this.f3343a.mo6428k(), b).mo6834d();
                this.f3349g = true;
            }
        }
    }

    public void onPause() {
        super.onPause();
        mo6393a(this.f3348f);
        this.f3348f = false;
    }

    public void onResume() {
        super.onResume();
        mo6391a();
        mo6394b(this.f3348f);
        this.f3348f = true;
        this.f3352j = true;
    }

    public void onWindowFocusChanged(boolean z) {
        if (z && this.f3348f) {
            C1199a.m4880c().mo6554u().mo6495b(true);
            mo6394b(this.f3348f);
            this.f3351i = true;
        } else if (!z && this.f3348f) {
            C1199a.m4880c().mo6554u().mo6493a(true);
            mo6393a(this.f3348f);
            this.f3351i = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6391a() {
        C1290h c = C1199a.m4880c();
        if (this.f3343a == null) {
            this.f3343a = c.mo6540f();
        }
        C1205c cVar = this.f3343a;
        if (cVar != null) {
            cVar.mo6412c(false);
            if (C1359k0.m5335h()) {
                this.f3343a.mo6412c(true);
            }
            int r = c.mo6542h().mo6634r();
            int q = this.f3350h ? c.mo6542h().mo6633q() - C1359k0.m5327e(C1199a.m4878b()) : c.mo6542h().mo6633q();
            if (r > 0 && q > 0) {
                JSONObject b = C1437s.m5599b();
                JSONObject b2 = C1437s.m5599b();
                float n = c.mo6542h().mo6630n();
                C1437s.m5602b(b2, "width", (int) (((float) r) / n));
                C1437s.m5602b(b2, "height", (int) (((float) q) / n));
                C1437s.m5602b(b2, "app_orientation", C1359k0.m5331f(C1359k0.m5332g()));
                C1437s.m5602b(b2, "x", 0);
                C1437s.m5602b(b2, "y", 0);
                C1437s.m5592a(b2, "ad_session_id", this.f3343a.mo6400a());
                C1437s.m5602b(b, "screen_width", r);
                C1437s.m5602b(b, "screen_height", q);
                C1437s.m5592a(b, "ad_session_id", this.f3343a.mo6400a());
                C1437s.m5602b(b, "id", this.f3343a.mo6410c());
                this.f3343a.setLayoutParams(new FrameLayout.LayoutParams(r, q));
                this.f3343a.mo6408b(r);
                this.f3343a.mo6401a(q);
                new C1454x("MRAID.on_size_change", this.f3343a.mo6428k(), b2).mo6834d();
                new C1454x("AdContainer.on_orientation_change", this.f3343a.mo6428k(), b).mo6834d();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6341a(C1454x xVar) {
        int f = C1437s.m5611f(xVar.mo6830b(), "status");
        if ((f == 5 || f == 0 || f == 6 || f == 1) && !this.f3347e) {
            C1290h c = C1199a.m4880c();
            C1353k i = c.mo6543i();
            c.mo6537d(xVar);
            if (i.mo6663a() != null) {
                i.mo6663a().dismiss();
                i.mo6664a((AlertDialog) null);
            }
            if (!this.f3349g) {
                finish();
            }
            this.f3347e = true;
            ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            c.mo6538d(false);
            JSONObject b = C1437s.m5599b();
            C1437s.m5592a(b, "id", this.f3343a.mo6400a());
            new C1454x("AdSession.on_close", this.f3343a.mo6428k(), b).mo6834d();
            c.mo6526a((C1205c) null);
            c.mo6524a((AdColonyInterstitial) null);
            c.mo6521a((AdColonyAdView) null);
            C1199a.m4880c().mo6530b().mo6453a().remove(this.f3343a.mo6400a());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6392a(int i) {
        if (i == 0) {
            setRequestedOrientation(7);
        } else if (i != 1) {
            setRequestedOrientation(4);
        } else {
            setRequestedOrientation(6);
        }
        this.f3345c = i;
    }
}
