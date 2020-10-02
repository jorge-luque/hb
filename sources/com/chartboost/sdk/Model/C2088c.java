package com.chartboost.sdk.Model;

import android.content.SharedPreferences;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.chartboost.sdk.C2099a;
import com.chartboost.sdk.C2102d;
import com.chartboost.sdk.C2107e;
import com.chartboost.sdk.C2109f;
import com.chartboost.sdk.C2239j;
import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.Events.C2070b;
import com.chartboost.sdk.Libraries.C2078f;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C2098a;
import com.chartboost.sdk.impl.C2117a;
import com.chartboost.sdk.impl.C2128c1;
import com.chartboost.sdk.impl.C2152h0;
import com.chartboost.sdk.impl.C2158i0;
import com.chartboost.sdk.impl.C2216u1;
import com.chartboost.sdk.impl.C2218v0;
import com.chartboost.sdk.impl.C2224x;
import com.chartboost.sdk.impl.C2225x0;
import com.chartboost.sdk.impl.C2228x1;
import com.chartboost.sdk.impl.C2234y0;
import com.facebook.places.model.PlaceFields;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Model.c */
public class C2088c {

    /* renamed from: A */
    public boolean f6917A = false;

    /* renamed from: B */
    public boolean f6918B;

    /* renamed from: C */
    public boolean f6919C = false;

    /* renamed from: D */
    public boolean f6920D = false;

    /* renamed from: a */
    public int f6921a;

    /* renamed from: b */
    public int f6922b;

    /* renamed from: c */
    public final C2117a f6923c;

    /* renamed from: d */
    public final C2078f f6924d;

    /* renamed from: e */
    public final C2218v0 f6925e;

    /* renamed from: f */
    public final C2092g f6926f;

    /* renamed from: g */
    public final C2098a f6927g;

    /* renamed from: h */
    public final Handler f6928h;

    /* renamed from: i */
    public final C2102d f6929i;

    /* renamed from: j */
    public final C2225x0 f6930j;

    /* renamed from: k */
    public final C2107e f6931k;

    /* renamed from: l */
    public final C2234y0 f6932l;

    /* renamed from: m */
    public final C2089d f6933m;

    /* renamed from: n */
    public final String f6934n;

    /* renamed from: o */
    private boolean f6935o;

    /* renamed from: p */
    private Boolean f6936p = null;

    /* renamed from: q */
    public final String f6937q;

    /* renamed from: r */
    public final C2086a f6938r;

    /* renamed from: s */
    public final SharedPreferences f6939s;

    /* renamed from: t */
    private Runnable f6940t;

    /* renamed from: u */
    private C2109f f6941u;

    /* renamed from: v */
    private final WeakReference<RelativeLayout> f6942v;

    /* renamed from: w */
    private final Boolean f6943w;

    /* renamed from: x */
    public C2128c1 f6944x;

    /* renamed from: y */
    public C2216u1 f6945y;

    /* renamed from: z */
    public boolean f6946z;

    public C2088c(C2086a aVar, C2089d dVar, C2078f fVar, C2218v0 v0Var, C2092g gVar, SharedPreferences sharedPreferences, C2098a aVar2, Handler handler, C2102d dVar2, C2225x0 x0Var, C2107e eVar, C2234y0 y0Var, C2117a aVar3, String str, String str2, RelativeLayout relativeLayout) {
        this.f6938r = aVar;
        this.f6923c = aVar3;
        this.f6924d = fVar;
        this.f6925e = v0Var;
        this.f6926f = gVar;
        this.f6927g = aVar2;
        this.f6928h = handler;
        this.f6929i = dVar2;
        this.f6930j = x0Var;
        this.f6931k = eVar;
        this.f6932l = y0Var;
        this.f6933m = dVar;
        this.f6942v = new WeakReference<>(relativeLayout);
        this.f6943w = Boolean.valueOf(this.f6923c.f7101a == 3);
        this.f6922b = 0;
        this.f6946z = false;
        this.f6918B = false;
        this.f6920D = true;
        this.f6921a = 4;
        this.f6934n = str;
        this.f6937q = str2;
        this.f6935o = true;
        this.f6939s = sharedPreferences;
    }

    /* renamed from: A */
    private boolean m8223A() {
        return this.f6936p != null;
    }

    /* renamed from: B */
    private void m8224B() {
        C2239j n = C2239j.m8897n();
        if (n != null) {
            n.f7574h.mo9185d(this.f6923c.f7102b);
        }
    }

    /* renamed from: C */
    private void m8225C() {
        int i = this.f6923c.f7101a;
        if (i == 0) {
            m8226D();
        } else if (i == 1) {
            m8227E();
        } else if (i == 3) {
            this.f6921a = 3;
        }
    }

    /* renamed from: D */
    private void m8226D() {
        if (this.f6938r.f6910p.equals("video")) {
            this.f6921a = 1;
            this.f6935o = false;
            return;
        }
        this.f6921a = 0;
    }

    /* renamed from: E */
    private void m8227E() {
        this.f6921a = 2;
        this.f6935o = false;
        if (m8235z()) {
            this.f6941u = new C2158i0(this, this.f6924d, this.f6928h, this.f6929i);
        }
    }

    /* renamed from: F */
    private void m8228F() {
        if (m8235z()) {
            int i = this.f6923c.f7101a;
            if (i == 0) {
                if (this.f6938r.f6910p.equals("video")) {
                    this.f6941u = new C2158i0(this, this.f6924d, this.f6928h, this.f6929i);
                } else {
                    this.f6941u = new C2152h0(this, this.f6928h, this.f6929i);
                }
            } else if (i == 1) {
                this.f6941u = new C2158i0(this, this.f6924d, this.f6928h, this.f6929i);
            }
        } else {
            this.f6941u = new C2228x1(this, this.f6924d, this.f6925e, this.f6939s, this.f6927g, this.f6928h, this.f6929i, this.f6931k);
        }
    }

    /* renamed from: G */
    private void m8229G() {
        C2128c1 c1Var = new C2128c1("https://live.chartboost.com", "/api/video-complete", this.f6926f, this.f6927g, 2, (C2128c1.C2129a) null);
        c1Var.mo9294a(PlaceFields.LOCATION, (Object) this.f6934n);
        c1Var.mo9294a("reward", (Object) Integer.valueOf(this.f6938r.f6905k));
        c1Var.mo9294a("currency-name", (Object) this.f6938r.f6906l);
        c1Var.mo9294a("ad_id", (Object) mo9126c());
        c1Var.mo9294a("force_close", (Object) false);
        if (!this.f6938r.f6901g.isEmpty()) {
            c1Var.mo9294a("cgn", (Object) this.f6938r.f6901g);
        }
        C2109f g = mo9129f() != null ? mo9130g() : null;
        if (g != null) {
            float h = g.mo9248h();
            float g2 = g.mo9247g();
            CBLogging.m8152a(C2088c.class.getSimpleName(), String.format(Locale.US, "TotalDuration: %f PlaybackTime: %f", new Object[]{Float.valueOf(g2), Float.valueOf(h)}));
            float f = g2 / 1000.0f;
            c1Var.mo9294a("total_time", (Object) Float.valueOf(f));
            if (h <= 0.0f) {
                c1Var.mo9294a("playback_time", (Object) Float.valueOf(f));
            } else {
                c1Var.mo9294a("playback_time", (Object) Float.valueOf(h / 1000.0f));
            }
        }
        this.f6925e.mo9524a(c1Var);
        this.f6927g.mo9170b(this.f6923c.mo9267a(this.f6938r.f6896b), mo9126c());
    }

    /* renamed from: x */
    private void m8233x() {
        C2107e c;
        if (this.f6922b == 2 && (c = this.f6929i.mo9195c()) != null) {
            c.mo9224a(this);
        }
    }

    /* renamed from: y */
    private boolean m8234y() {
        return this.f6936p.booleanValue();
    }

    /* renamed from: z */
    private boolean m8235z() {
        return this.f6938r.f6896b == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003c  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo9123a(org.json.JSONObject r7) {
        /*
            r6 = this;
            int r0 = r6.f6922b
            r1 = 0
            r2 = 2
            if (r0 != r2) goto L_0x0045
            boolean r0 = r6.f6917A
            if (r0 == 0) goto L_0x000b
            goto L_0x0045
        L_0x000b:
            com.chartboost.sdk.Model.a r0 = r6.f6938r
            java.lang.String r2 = r0.f6904j
            java.lang.String r0 = r0.f6903i
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x0037
            com.chartboost.sdk.impl.x0 r3 = r6.f6930j     // Catch:{ Exception -> 0x002b }
            boolean r3 = r3.mo9555a(r0)     // Catch:{ Exception -> 0x002b }
            if (r3 == 0) goto L_0x0026
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0024 }
            r6.f6936p = r2     // Catch:{ Exception -> 0x0024 }
            goto L_0x0036
        L_0x0024:
            r2 = move-exception
            goto L_0x002f
        L_0x0026:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x002b }
            r6.f6936p = r0     // Catch:{ Exception -> 0x002b }
            goto L_0x0037
        L_0x002b:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
        L_0x002f:
            java.lang.Class<com.chartboost.sdk.Model.c> r3 = com.chartboost.sdk.Model.C2088c.class
            java.lang.String r4 = "onClick"
            com.chartboost.sdk.Tracking.C2098a.m8288a((java.lang.Class) r3, (java.lang.String) r4, (java.lang.Exception) r2)
        L_0x0036:
            r2 = r0
        L_0x0037:
            boolean r0 = r6.f6918B
            if (r0 == 0) goto L_0x003c
            return r1
        L_0x003c:
            r0 = 1
            r6.f6918B = r0
            r6.f6920D = r1
            r6.mo9122a((java.lang.String) r2, (org.json.JSONObject) r7)
            return r0
        L_0x0045:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.Model.C2088c.mo9123a(org.json.JSONObject):boolean");
    }

    /* renamed from: b */
    public boolean mo9125b(String str, JSONObject jSONObject) {
        if (this.f6923c.f7101a != 3) {
            return false;
        }
        m8224B();
        mo9122a(str, jSONObject);
        return true;
    }

    /* renamed from: c */
    public String mo9126c() {
        return this.f6938r.f6900f;
    }

    /* renamed from: d */
    public RelativeLayout mo9127d() {
        return (RelativeLayout) this.f6942v.get();
    }

    /* renamed from: e */
    public Boolean mo9128e() {
        return this.f6943w;
    }

    /* renamed from: f */
    public C2109f.C2111b mo9129f() {
        C2109f fVar = this.f6941u;
        if (fVar != null) {
            return fVar.mo9249i();
        }
        return null;
    }

    /* renamed from: g */
    public C2109f mo9130g() {
        return this.f6941u;
    }

    /* renamed from: h */
    public void mo9131h() {
        this.f6917A = true;
    }

    /* renamed from: i */
    public void mo9132i() {
        Runnable runnable = this.f6940t;
        if (runnable != null) {
            runnable.run();
            this.f6940t = null;
        }
        this.f6917A = false;
    }

    /* renamed from: j */
    public boolean mo9133j() {
        C2109f fVar = this.f6941u;
        if (fVar != null) {
            return fVar.mo9250j();
        }
        return false;
    }

    /* renamed from: k */
    public void mo9134k() {
        this.f6920D = true;
        this.f6929i.mo9190a(this);
        this.f6933m.mo9147a(this);
    }

    /* renamed from: l */
    public void mo9135l() {
        this.f6933m.mo9149b(this);
    }

    /* renamed from: m */
    public void mo9136m() {
        C2109f fVar = this.f6941u;
        if (fVar != null && fVar.mo9249i() != null) {
            this.f6941u.mo9249i().setVisibility(8);
        }
    }

    /* renamed from: n */
    public void mo9137n() {
        C2109f fVar = this.f6941u;
        if (fVar != null && !this.f6919C) {
            this.f6919C = true;
            fVar.mo9251k();
        }
    }

    /* renamed from: o */
    public void mo9138o() {
        C2099a aVar;
        C2099a aVar2;
        this.f6935o = true;
        if (this.f6923c.f7101a == 1 && (aVar2 = C2242k.f7604d) != null) {
            aVar2.didCompleteRewardedVideo(this.f6934n, this.f6938r.f6905k);
        } else if (this.f6923c.f7101a == 0 && (aVar = C2242k.f7604d) != null) {
            aVar.didCompleteInterstitial(this.f6934n);
        }
        m8229G();
    }

    /* renamed from: p */
    public void mo9139p() {
    }

    /* renamed from: q */
    public void mo9140q() {
        this.f6918B = false;
        C2109f fVar = this.f6941u;
        if (fVar != null && this.f6919C) {
            this.f6919C = false;
            fVar.mo9252l();
        }
    }

    /* renamed from: r */
    public void mo9141r() {
        this.f6918B = false;
    }

    /* renamed from: s */
    public boolean mo9142s() {
        this.f6922b = 0;
        m8225C();
        m8228F();
        return this.f6941u.mo9242b(this.f6938r.f6895a);
    }

    /* renamed from: t */
    public boolean mo9143t() {
        C2109f fVar = this.f6941u;
        if (fVar != null) {
            fVar.mo9253m();
            if (this.f6941u.mo9249i() != null) {
                return true;
            }
        } else {
            CBLogging.m8154b("CBImpression", "reinitializing -- no view protocol exists!!");
        }
        CBLogging.m8156c("CBImpression", "reinitializing -- view not yet created");
        return false;
    }

    /* renamed from: u */
    public boolean mo9144u() {
        return this.f6935o;
    }

    /* renamed from: v */
    public void mo9145v() {
        this.f6933m.mo9150c(this);
    }

    /* renamed from: w */
    public boolean mo9146w() {
        return this.f6920D;
    }

    /* renamed from: b */
    public void mo9124b() {
        mo9119a();
        if (this.f6946z) {
            C2109f fVar = this.f6941u;
            if (fVar != null) {
                fVar.mo9241b();
            }
            this.f6941u = null;
            CBLogging.m8156c("CBImpression", "Destroying the view and view data");
        }
    }

    /* renamed from: b */
    private C2128c1 m8232b(JSONObject jSONObject) {
        return m8230a(new C2128c1("https://live.chartboost.com", "/api/click", this.f6926f, this.f6927g, 2, (C2128c1.C2129a) null), jSONObject);
    }

    /* renamed from: a */
    public void mo9120a(CBError.CBImpressionError cBImpressionError) {
        this.f6933m.mo9148a(this, cBImpressionError);
    }

    /* renamed from: a */
    public void mo9119a() {
        C2216u1 u1Var = this.f6945y;
        if (u1Var != null) {
            u1Var.mo9516a();
            try {
                if (!(this.f6941u == null || this.f6941u.mo9249i() == null || this.f6941u.mo9249i().getParent() == null)) {
                    this.f6945y.removeView(this.f6941u.mo9249i());
                }
            } catch (Exception e) {
                CBLogging.m8153a("CBImpression", "Exception raised while cleaning up views", e);
                C2098a.m8288a(C2088c.class, "cleanUpViews", e);
            }
            this.f6945y = null;
        }
        C2109f fVar = this.f6941u;
        if (fVar != null) {
            fVar.mo9243c();
        }
        CBLogging.m8156c("CBImpression", "Destroying the view");
    }

    /* renamed from: a */
    public CBError.CBImpressionError mo9118a(RelativeLayout relativeLayout) {
        try {
            if (this.f6941u != null) {
                if (mo9128e().booleanValue()) {
                    return this.f6941u.mo9232a(relativeLayout);
                }
                return this.f6941u.mo9254n();
            }
        } catch (Exception e) {
            C2098a.m8288a(C2088c.class, "tryCreatingView", e);
        }
        return CBError.CBImpressionError.ERROR_CREATING_VIEW;
    }

    /* renamed from: a */
    public void mo9121a(Runnable runnable) {
        this.f6940t = runnable;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9122a(String str, JSONObject jSONObject) {
        Handler handler = this.f6928h;
        C2117a aVar = this.f6923c;
        aVar.getClass();
        handler.post(new C2117a.C2118a(1, this.f6934n, (CBError.CBImpressionError) null, (C2070b) null));
        if (mo9144u()) {
            m8233x();
        }
        if (m8231a(str)) {
            this.f6944x = m8232b(jSONObject);
            this.f6930j.mo9553a(this, str, (C2128c1) null);
        } else {
            this.f6930j.mo9554a(this, false, str, CBError.CBClickError.URI_INVALID, (C2128c1) null);
        }
        this.f6927g.mo9162a(this.f6923c.mo9267a(this.f6938r.f6896b), this.f6934n, mo9126c());
    }

    /* renamed from: a */
    private boolean m8231a(String str) {
        return !C2224x.m8805e().mo9549a((CharSequence) str);
    }

    /* renamed from: a */
    private C2128c1 m8230a(C2128c1 c1Var, JSONObject jSONObject) {
        if (!this.f6938r.f6900f.isEmpty()) {
            c1Var.mo9294a("ad_id", (Object) this.f6938r.f6900f);
        }
        if (!this.f6938r.f6907m.isEmpty()) {
            c1Var.mo9294a("to", (Object) this.f6938r.f6907m);
        }
        if (!this.f6938r.f6901g.isEmpty()) {
            c1Var.mo9294a("cgn", (Object) this.f6938r.f6901g);
        }
        if (!this.f6938r.f6902h.isEmpty()) {
            c1Var.mo9294a(VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE, (Object) this.f6938r.f6902h);
        }
        int i = this.f6921a;
        if (i == 1 || i == 2) {
            C2109f fVar = null;
            if (this.f6938r.f6896b == 0 && mo9129f() != null) {
                fVar = mo9130g();
            } else if (this.f6938r.f6896b == 1 && mo9129f() != null) {
                fVar = mo9130g();
            }
            if (fVar != null) {
                float h = fVar.mo9248h();
                float g = fVar.mo9247g();
                CBLogging.m8152a(C2088c.class.getSimpleName(), String.format(Locale.US, "TotalDuration: %f PlaybackTime: %f", new Object[]{Float.valueOf(g), Float.valueOf(h)}));
                float f = g / 1000.0f;
                c1Var.mo9294a("total_time", (Object) Float.valueOf(f));
                if (h <= 0.0f) {
                    c1Var.mo9294a("playback_time", (Object) Float.valueOf(f));
                } else {
                    c1Var.mo9294a("playback_time", (Object) Float.valueOf(h / 1000.0f));
                }
            }
        } else if (i == 3) {
            c1Var.mo9294a(VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE, (Object) "");
        }
        if (jSONObject != null) {
            c1Var.mo9294a("click_coordinates", (Object) jSONObject);
        }
        c1Var.mo9294a(PlaceFields.LOCATION, (Object) this.f6934n);
        if (m8223A()) {
            c1Var.mo9294a("retarget_reinstall", (Object) Boolean.valueOf(m8234y()));
        }
        return c1Var;
    }
}
