package com.chartboost.sdk.impl;

import admost.sdk.base.AdMostZoneType;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.chartboost.sdk.C2102d;
import com.chartboost.sdk.C2109f;
import com.chartboost.sdk.C2116i;
import com.chartboost.sdk.Libraries.C2076e;
import com.chartboost.sdk.Libraries.C2078f;
import com.chartboost.sdk.Libraries.C2080h;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C2088c;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C2098a;
import com.chartboost.sdk.impl.C2152h0;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tapjoy.TJAdUnitConstants;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.i0 */
public class C2158i0 extends C2152h0 {

    /* renamed from: A */
    private boolean f7258A = false;

    /* renamed from: B */
    private boolean f7259B = false;

    /* renamed from: C */
    JSONObject f7260C;

    /* renamed from: D */
    protected boolean f7261D;

    /* renamed from: E */
    protected boolean f7262E;

    /* renamed from: F */
    protected boolean f7263F;

    /* renamed from: G */
    protected boolean f7264G;

    /* renamed from: H */
    protected boolean f7265H = false;

    /* renamed from: I */
    protected int f7266I;

    /* renamed from: J */
    protected C2080h f7267J;

    /* renamed from: K */
    protected C2080h f7268K;

    /* renamed from: L */
    protected C2080h f7269L;

    /* renamed from: M */
    protected C2080h f7270M;

    /* renamed from: N */
    protected C2080h f7271N;

    /* renamed from: O */
    protected C2080h f7272O;

    /* renamed from: P */
    protected C2080h f7273P;

    /* renamed from: Q */
    protected C2080h f7274Q;

    /* renamed from: R */
    protected boolean f7275R = false;

    /* renamed from: S */
    protected boolean f7276S = false;

    /* renamed from: T */
    protected boolean f7277T = false;

    /* renamed from: s */
    final C2078f f7278s;

    /* renamed from: t */
    protected int f7279t = 0;

    /* renamed from: u */
    protected int f7280u;

    /* renamed from: v */
    protected String f7281v;

    /* renamed from: w */
    protected String f7282w;

    /* renamed from: x */
    private boolean f7283x = false;

    /* renamed from: y */
    protected int f7284y = 0;

    /* renamed from: z */
    protected int f7285z = 0;

    /* renamed from: com.chartboost.sdk.impl.i0$b */
    public class C2160b extends C2152h0.C2153a {

        /* renamed from: n */
        private final C2204r1 f7286n;

        /* renamed from: o */
        final C2187o0 f7287o;

        /* renamed from: p */
        C2174l0 f7288p;

        /* renamed from: q */
        private View f7289q;

        /* renamed from: r */
        final C2147g0 f7290r;

        /* renamed from: s */
        final C2168j0 f7291s;

        /* renamed from: t */
        private final C2204r1 f7292t;

        /* renamed from: com.chartboost.sdk.impl.i0$b$a */
        class C2161a extends C2204r1 {
            C2161a(Context context, C2158i0 i0Var) {
                super(context);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo9350a(MotionEvent motionEvent) {
                C2160b bVar = C2160b.this;
                if (C2158i0.this.f7073g.f6921a == 2) {
                    bVar.f7291s.mo9419a(false);
                }
                C2160b bVar2 = C2160b.this;
                if (C2158i0.this.f7279t == 1) {
                    bVar2.mo9374d(false);
                }
                C2160b.this.mo9373c(true);
            }
        }

        /* renamed from: com.chartboost.sdk.impl.i0$b$b */
        class C2162b extends C2204r1 {
            C2162b(Context context, C2158i0 i0Var) {
                super(context);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo9350a(MotionEvent motionEvent) {
                C2160b.this.mo9359c();
            }
        }

        /* renamed from: com.chartboost.sdk.impl.i0$b$c */
        class C2163c implements Runnable {
            C2163c() {
            }

            public void run() {
                Object[] objArr = new Object[1];
                objArr[0] = C2158i0.this.f7261D ? "hidden" : "shown";
                CBLogging.m8158d("InterstitialVideoViewProtocol", String.format("controls %s automatically from timer", objArr));
                C2160b bVar = C2160b.this;
                bVar.f7287o.mo9450a(!C2158i0.this.f7261D, true);
                synchronized (C2158i0.this.f7075i) {
                    C2158i0.this.f7075i.remove(C2160b.this.f7287o);
                }
            }
        }

        /* renamed from: com.chartboost.sdk.impl.i0$b$d */
        class C2164d implements Runnable {
            C2164d() {
            }

            public void run() {
                C2160b.this.f7291s.mo9419a(false);
            }
        }

        /* renamed from: com.chartboost.sdk.impl.i0$b$e */
        class C2165e implements Runnable {
            C2165e() {
            }

            public void run() {
                try {
                    C2158i0.this.mo9234a();
                } catch (Exception e) {
                    C2098a.m8288a(C2160b.class, "onCloseButton Runnable.run", e);
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo9257a(int i, int i2) {
            super.mo9257a(i, i2);
            m8593a(C2158i0.this.f7279t, false);
            boolean b = CBUtility.m8171b(C2158i0.this.mo9246f());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f7246h.getLayoutParams();
            C2158i0 i0Var = C2158i0.this;
            i0Var.mo9356a(layoutParams2, b ? i0Var.f7268K : i0Var.f7267J, 1.0f);
            Point b2 = C2158i0.this.mo9357b(b ? "replay-portrait" : "replay-landscape");
            int round = Math.round(((((float) layoutParams6.leftMargin) + (((float) layoutParams6.width) / 2.0f)) + ((float) b2.x)) - (((float) layoutParams2.width) / 2.0f));
            int round2 = Math.round(((((float) layoutParams6.topMargin) + (((float) layoutParams6.height) / 2.0f)) + ((float) b2.y)) - (((float) layoutParams2.height) / 2.0f));
            layoutParams2.leftMargin = Math.min(Math.max(0, round), i - layoutParams2.width);
            layoutParams2.topMargin = Math.min(Math.max(0, round2), i2 - layoutParams2.height);
            this.f7286n.bringToFront();
            if (b) {
                this.f7286n.mo9502a(C2158i0.this.f7268K);
            } else {
                this.f7286n.mo9502a(C2158i0.this.f7267J);
            }
            RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f7249k.getLayoutParams();
            if (!C2158i0.this.mo9368s()) {
                layoutParams3.width = layoutParams7.width;
                layoutParams3.height = layoutParams7.height;
                layoutParams3.leftMargin = layoutParams7.leftMargin;
                layoutParams3.topMargin = layoutParams7.topMargin;
                layoutParams4.width = layoutParams7.width;
                layoutParams4.height = layoutParams7.height;
                layoutParams4.leftMargin = layoutParams7.leftMargin;
                layoutParams4.topMargin = layoutParams7.topMargin;
            } else {
                RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
                C2080h hVar = b ? C2158i0.this.f7241n : C2158i0.this.f7242o;
                C2158i0.this.mo9356a(layoutParams8, hVar, 1.0f);
                layoutParams8.leftMargin = 0;
                layoutParams8.topMargin = 0;
                layoutParams8.addRule(11);
                this.f7292t.setLayoutParams(layoutParams8);
                this.f7292t.mo9502a(hVar);
            }
            layoutParams5.width = layoutParams7.width;
            layoutParams5.height = 72;
            layoutParams5.leftMargin = layoutParams7.leftMargin;
            layoutParams5.topMargin = (layoutParams7.topMargin + layoutParams7.height) - 72;
            if (C2158i0.this.f7276S) {
                this.f7289q.setLayoutParams(layoutParams);
            }
            if (C2158i0.this.f7073g.f6921a == 2) {
                this.f7288p.setLayoutParams(layoutParams3);
            }
            this.f7287o.setLayoutParams(layoutParams4);
            this.f7290r.setLayoutParams(layoutParams5);
            this.f7286n.setLayoutParams(layoutParams2);
            if (C2158i0.this.f7073g.f6921a == 2) {
                this.f7288p.mo9393a();
            }
            this.f7287o.mo9460h();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo9372b(float f, float f2, float f3, float f4) {
            if (C2158i0.this.f7279t == 1) {
                mo9374d(false);
            }
            C2158i0.this.mo9240a(C2076e.m8186a(C2076e.m8184a("x", (Object) Float.valueOf(f)), C2076e.m8184a("y", (Object) Float.valueOf(f2)), C2076e.m8184a("w", (Object) Float.valueOf(f3)), C2076e.m8184a("h", (Object) Float.valueOf(f4))));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo9373c(boolean z) {
            C2158i0 i0Var = C2158i0.this;
            if (i0Var.f7279t != 1) {
                if (i0Var.f7262E) {
                    m8593a(0, z);
                    return;
                }
                m8593a(1, z);
                JSONObject a = C2076e.m8185a(C2158i0.this.f7260C, "timer");
                if (C2158i0.this.f7280u >= 1 || a == null || a.isNull(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_DELAY)) {
                    this.f7287o.mo9449a(!C2158i0.this.f7261D);
                } else {
                    Object[] objArr = new Object[1];
                    objArr[0] = C2158i0.this.f7261D ? TJAdUnitConstants.String.VISIBLE : "hidden";
                    CBLogging.m8158d("InterstitialVideoViewProtocol", String.format("controls starting %s, setting timer", objArr));
                    this.f7287o.mo9449a(C2158i0.this.f7261D);
                    C2158i0.this.mo9235a((View) this.f7287o, (Runnable) new C2163c(), Math.round(a.optDouble(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_DELAY, 0.0d) * 1000.0d));
                }
                this.f7287o.mo9458f();
                C2158i0 i0Var2 = C2158i0.this;
                if (i0Var2.f7280u <= 1) {
                    i0Var2.f7073g.mo9139p();
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo9360d() {
            super.mo9360d();
            C2158i0 i0Var = C2158i0.this;
            if (i0Var.f7279t != 0 || (i0Var.f7262E && !i0Var.mo9364o())) {
                m8593a(C2158i0.this.f7279t, false);
            } else {
                mo9373c(false);
            }
        }

        /* renamed from: e */
        public void mo9375e() {
            mo9374d(true);
            this.f7287o.mo9453c();
            C2158i0 i0Var = C2158i0.this;
            int i = i0Var.f7280u + 1;
            i0Var.f7280u = i;
            if (i <= 1 && !i0Var.mo9365p()) {
                C2158i0 i0Var2 = C2158i0.this;
                if (i0Var2.f7284y >= 1) {
                    i0Var2.f7073g.mo9138o();
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: f */
        public boolean mo9376f() {
            C2158i0 i0Var = C2158i0.this;
            if (i0Var.f7279t == 1 && i0Var.f7280u < 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("close-");
                sb.append(CBUtility.m8171b(C2158i0.this.mo9246f()) ? TJAdUnitConstants.String.PORTRAIT : TJAdUnitConstants.String.LANDSCAPE);
                JSONObject a = C2076e.m8185a(C2158i0.this.mo9245e(), sb.toString());
                float optDouble = a != null ? (float) a.optDouble(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_DELAY, -1.0d) : -1.0f;
                int round = optDouble >= 0.0f ? Math.round(optDouble * 1000.0f) : -1;
                C2158i0.this.f7266I = round;
                if (round < 0 || round > this.f7287o.mo9446a().mo9406d()) {
                    return false;
                }
            }
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: g */
        public void mo9377g() {
            C2158i0.this.f7262E = false;
            mo9373c(true);
        }

        private C2160b(Context context) {
            super(context);
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            C2116i a = C2116i.m8407a();
            if (C2158i0.this.f7276S) {
                View view = new View(context);
                this.f7289q = view;
                view.setBackgroundColor(-16777216);
                this.f7289q.setVisibility(8);
                addView(this.f7289q);
            }
            if (C2158i0.this.f7073g.f6921a == 2) {
                C2174l0 l0Var = (C2174l0) a.mo9266a(new C2174l0(context, C2158i0.this));
                this.f7288p = l0Var;
                l0Var.setVisibility(8);
                addView(this.f7288p);
            }
            C2187o0 o0Var = (C2187o0) a.mo9266a(new C2187o0(context, C2158i0.this));
            this.f7287o = o0Var;
            mo9258a((View) o0Var.f7398g);
            this.f7287o.setVisibility(8);
            addView(this.f7287o);
            C2147g0 g0Var = (C2147g0) a.mo9266a(new C2147g0(context, C2158i0.this));
            this.f7290r = g0Var;
            g0Var.setVisibility(8);
            addView(this.f7290r);
            if (C2158i0.this.f7073g.f6921a == 2) {
                C2168j0 j0Var = (C2168j0) a.mo9266a(new C2168j0(context, C2158i0.this));
                this.f7291s = j0Var;
                j0Var.setVisibility(8);
                addView(this.f7291s);
            } else {
                this.f7291s = null;
            }
            C2161a aVar = new C2161a(getContext(), C2158i0.this);
            this.f7286n = aVar;
            aVar.setVisibility(8);
            addView(this.f7286n);
            C2162b bVar = new C2162b(getContext(), C2158i0.this);
            this.f7292t = bVar;
            bVar.setVisibility(8);
            this.f7292t.setContentDescription("CBClose");
            addView(this.f7292t);
            JSONObject optJSONObject3 = C2158i0.this.f7260C.optJSONObject("progress");
            JSONObject optJSONObject4 = C2158i0.this.f7260C.optJSONObject("video-controls-background");
            if (optJSONObject3 != null && !optJSONObject3.isNull("background-color") && !optJSONObject3.isNull("border-color") && !optJSONObject3.isNull("progress-color") && !optJSONObject3.isNull("radius")) {
                C2158i0.this.f7275R = true;
                C2171k0 b = this.f7287o.mo9451b();
                b.mo9385a(C2109f.m8375a(optJSONObject3.optString("background-color")));
                b.mo9388b(C2109f.m8375a(optJSONObject3.optString("border-color")));
                b.mo9389c(C2109f.m8375a(optJSONObject3.optString("progress-color")));
                b.mo9387b((float) optJSONObject3.optDouble("radius", 0.0d));
            }
            if (optJSONObject4 != null && !optJSONObject4.isNull("color")) {
                this.f7287o.mo9447a(C2109f.m8375a(optJSONObject4.optString("color")));
            }
            if (C2158i0.this.f7073g.f6921a == 2 && C2158i0.this.f7263F && (optJSONObject2 = C2158i0.this.f7260C.optJSONObject("post-video-toaster")) != null) {
                this.f7290r.mo9348a(optJSONObject2.optString("title"), optJSONObject2.optString("tagline"));
            }
            if (C2158i0.this.f7073g.f6921a == 2 && C2158i0.this.f7262E && (optJSONObject = C2158i0.this.f7260C.optJSONObject("confirmation")) != null) {
                this.f7288p.mo9394a(optJSONObject.optString(ViewHierarchyConstants.TEXT_KEY), C2109f.m8375a(optJSONObject.optString("color")));
            }
            String str = "";
            if (C2158i0.this.f7073g.f6921a == 2 && C2158i0.this.f7264G) {
                JSONObject a2 = C2076e.m8185a(C2158i0.this.f7260C, "post-video-reward-toaster");
                this.f7291s.mo9418a((a2 == null || !a2.optString("position").equals("inside-top")) ? 1 : 0);
                this.f7291s.mo9382a(a2 != null ? a2.optString(ViewHierarchyConstants.TEXT_KEY) : str);
                if (C2158i0.this.f7272O.mo9104e()) {
                    this.f7291s.mo9381a(C2158i0.this.f7274Q);
                }
            }
            JSONObject e = C2158i0.this.mo9245e();
            if (e == null || e.isNull("video-click-button")) {
                this.f7287o.mo9455d();
            }
            this.f7287o.mo9454c(C2158i0.this.f7260C.optBoolean("video-progress-timer-enabled"));
            if (C2158i0.this.f7277T || C2158i0.this.f7276S) {
                this.f7250l.setVisibility(4);
            }
            String[] strArr = new String[1];
            strArr[0] = CBUtility.m8171b(C2158i0.this.mo9246f()) ? "video-portrait" : "video-landscape";
            JSONObject a3 = C2076e.m8185a(e, strArr);
            str = a3 != null ? a3.optString("id") : str;
            C2158i0.this.f7282w = str;
            if (str.isEmpty()) {
                C2158i0.this.mo9236a(CBError.CBImpressionError.VIDEO_ID_MISSING);
                return;
            }
            if (C2158i0.this.f7281v == null) {
                C2158i0.this.f7281v = C2158i0.this.f7278s.mo9090a(C2158i0.this.f7282w);
            }
            String str2 = C2158i0.this.f7281v;
            if (str2 == null) {
                C2158i0.this.mo9236a(CBError.CBImpressionError.VIDEO_UNAVAILABLE);
            } else {
                this.f7287o.mo9448a(str2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo9374d(boolean z) {
            JSONObject jSONObject;
            this.f7287o.mo9459g();
            C2158i0 i0Var = C2158i0.this;
            if (i0Var.f7279t == 1 && z) {
                if (i0Var.f7280u < 1 && (jSONObject = i0Var.f7260C) != null && !jSONObject.isNull("post-video-reward-toaster")) {
                    C2158i0 i0Var2 = C2158i0.this;
                    if (i0Var2.f7264G && i0Var2.f7272O.mo9104e() && C2158i0.this.f7273P.mo9104e()) {
                        m8594e(true);
                    }
                }
                m8593a(2, true);
                if (CBUtility.m8171b(CBUtility.m8174e())) {
                    requestLayout();
                }
            }
        }

        /* renamed from: e */
        private void m8594e(boolean z) {
            if (z) {
                this.f7291s.mo9419a(true);
            } else {
                this.f7291s.setVisibility(0);
            }
            C2158i0.this.f7067a.postDelayed(new C2164d(), 2500);
        }

        /* renamed from: b */
        public C2204r1 mo9371b(boolean z) {
            return ((!C2158i0.this.mo9368s() || !z) && (C2158i0.this.mo9368s() || z)) ? this.f7247i : this.f7292t;
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo9359c() {
            C2158i0 i0Var = C2158i0.this;
            if (i0Var.f7279t != 1 || i0Var.f7073g.f6923c.f7101a != 1) {
                if (C2158i0.this.f7279t == 1) {
                    mo9374d(false);
                    this.f7287o.mo9453c();
                    C2158i0 i0Var2 = C2158i0.this;
                    int i = i0Var2.f7280u;
                    if (i < 1) {
                        i0Var2.f7280u = i + 1;
                        i0Var2.f7073g.mo9138o();
                    }
                }
                C2158i0.this.f7067a.post(new C2165e());
            }
        }

        /* renamed from: a */
        private void m8593a(int i, boolean z) {
            C2158i0 i0Var = C2158i0.this;
            i0Var.f7279t = i;
            boolean z2 = true;
            if (i == 0) {
                i0Var.mo9238a(!i0Var.mo9368s(), (View) this.f7249k, z);
                C2158i0 i0Var2 = C2158i0.this;
                if (i0Var2.f7073g.f6921a == 2) {
                    i0Var2.mo9238a(true, (View) this.f7288p, z);
                }
                C2158i0 i0Var3 = C2158i0.this;
                if (i0Var3.f7276S) {
                    i0Var3.mo9238a(false, this.f7289q, z);
                }
                C2158i0.this.mo9238a(false, (View) this.f7287o, z);
                C2158i0.this.mo9238a(false, (View) this.f7286n, z);
                C2158i0.this.mo9238a(false, (View) this.f7290r, z);
                this.f7249k.setEnabled(false);
                this.f7286n.setEnabled(false);
                this.f7287o.setEnabled(false);
            } else if (i == 1) {
                i0Var.mo9238a(false, (View) this.f7249k, z);
                C2158i0 i0Var4 = C2158i0.this;
                if (i0Var4.f7073g.f6921a == 2) {
                    i0Var4.mo9238a(false, (View) this.f7288p, z);
                }
                C2158i0 i0Var5 = C2158i0.this;
                if (i0Var5.f7276S) {
                    i0Var5.mo9238a(true, this.f7289q, z);
                }
                C2158i0.this.mo9238a(true, (View) this.f7287o, z);
                C2158i0.this.mo9238a(false, (View) this.f7286n, z);
                C2158i0.this.mo9238a(false, (View) this.f7290r, z);
                this.f7249k.setEnabled(true);
                this.f7286n.setEnabled(false);
                this.f7287o.setEnabled(true);
            } else if (i == 2) {
                i0Var.mo9238a(true, (View) this.f7249k, z);
                C2158i0 i0Var6 = C2158i0.this;
                if (i0Var6.f7073g.f6921a == 2) {
                    i0Var6.mo9238a(false, (View) this.f7288p, z);
                }
                C2158i0 i0Var7 = C2158i0.this;
                if (i0Var7.f7276S) {
                    i0Var7.mo9238a(false, this.f7289q, z);
                }
                C2158i0.this.mo9238a(false, (View) this.f7287o, z);
                C2158i0.this.mo9238a(true, (View) this.f7286n, z);
                C2158i0.this.mo9238a(C2158i0.this.f7273P.mo9104e() && C2158i0.this.f7272O.mo9104e() && C2158i0.this.f7263F, (View) this.f7290r, z);
                this.f7286n.setEnabled(true);
                this.f7249k.setEnabled(true);
                this.f7287o.setEnabled(false);
                if (C2158i0.this.f7265H) {
                    m8594e(false);
                }
            }
            boolean f = mo9376f();
            C2204r1 b = mo9371b(true);
            b.setEnabled(f);
            C2158i0.this.mo9238a(f, (View) b, z);
            C2204r1 b2 = mo9371b(false);
            b2.setEnabled(false);
            C2158i0.this.mo9238a(false, (View) b2, z);
            C2158i0 i0Var8 = C2158i0.this;
            if (i0Var8.f7277T || i0Var8.f7276S) {
                C2158i0 i0Var9 = C2158i0.this;
                i0Var9.mo9238a(!i0Var9.mo9368s(), (View) this.f7250l, z);
            }
            C2158i0 i0Var10 = C2158i0.this;
            i0Var10.mo9238a(!i0Var10.mo9368s(), (View) this.f7246h, z);
            if (i == 0) {
                z2 = false;
            }
            mo9259a(z2);
        }

        /* renamed from: a */
        public void mo9256a() {
            C2158i0.this.mo9251k();
            super.mo9256a();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo9358a(float f, float f2, float f3, float f4) {
            C2158i0 i0Var = C2158i0.this;
            if ((!i0Var.f7261D || i0Var.f7279t != 1) && C2158i0.this.f7279t != 0) {
                mo9372b(f, f2, f3, f4);
            }
        }
    }

    public C2158i0(C2088c cVar, C2078f fVar, Handler handler, C2102d dVar) {
        super(cVar, handler, dVar);
        this.f7278s = fVar;
        this.f7279t = 0;
        this.f7267J = new C2080h(this);
        this.f7268K = new C2080h(this);
        this.f7269L = new C2080h(this);
        this.f7270M = new C2080h(this);
        this.f7271N = new C2080h(this);
        this.f7272O = new C2080h(this);
        this.f7273P = new C2080h(this);
        this.f7274Q = new C2080h(this);
        this.f7280u = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C2109f.C2111b mo9233a(Context context) {
        return new C2160b(context);
    }

    /* renamed from: b */
    public boolean mo9242b(JSONObject jSONObject) {
        if (!super.mo9242b(jSONObject)) {
            return false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("ux");
        this.f7260C = optJSONObject;
        if (optJSONObject == null) {
            this.f7260C = C2076e.m8186a(new C2076e.C2077a[0]);
        }
        if (this.f7071e.isNull("video-landscape") || this.f7071e.isNull("replay-landscape")) {
            this.f7077k = false;
        }
        if (!this.f7267J.mo9099a("replay-landscape") || !this.f7268K.mo9099a("replay-portrait") || !this.f7271N.mo9099a("video-click-button") || !this.f7272O.mo9099a("post-video-reward-icon") || !this.f7273P.mo9099a("post-video-button") || !this.f7269L.mo9099a("video-confirmation-button") || !this.f7270M.mo9099a("video-confirmation-icon") || !this.f7274Q.mo9099a("post-video-reward-icon")) {
            CBLogging.m8154b("InterstitialVideoViewProtocol", "Error while downloading the assets");
            mo9236a(CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE);
            return false;
        }
        this.f7261D = this.f7260C.optBoolean("video-controls-togglable");
        this.f7276S = jSONObject.optBoolean(AdMostZoneType.FULLSCREEN);
        this.f7277T = jSONObject.optBoolean("preroll_popup_fullscreen");
        if (this.f7073g.f6921a == 2) {
            JSONObject optJSONObject2 = this.f7260C.optJSONObject("confirmation");
            JSONObject optJSONObject3 = this.f7260C.optJSONObject("post-video-toaster");
            if (optJSONObject3 != null && !optJSONObject3.isNull("title") && !optJSONObject3.isNull("tagline")) {
                this.f7263F = true;
            }
            if (optJSONObject2 != null && !optJSONObject2.isNull(ViewHierarchyConstants.TEXT_KEY) && !optJSONObject2.isNull("color")) {
                this.f7262E = true;
            }
            if (!this.f7260C.isNull("post-video-reward-toaster")) {
                this.f7264G = true;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9244d() {
        if (this.f7262E && (!this.f7269L.mo9104e() || !this.f7270M.mo9104e())) {
            this.f7262E = false;
        }
        super.mo9244d();
    }

    /* renamed from: g */
    public float mo9247g() {
        return (float) this.f7285z;
    }

    /* renamed from: h */
    public float mo9248h() {
        return (float) this.f7284y;
    }

    /* renamed from: j */
    public boolean mo9250j() {
        mo9249i().mo9359c();
        return true;
    }

    /* renamed from: k */
    public void mo9251k() {
        super.mo9251k();
        if (this.f7279t == 1 && !this.f7283x) {
            this.f7283x = true;
            mo9249i().f7287o.mo9457e();
        }
    }

    /* renamed from: l */
    public void mo9252l() {
        super.mo9252l();
        if (this.f7279t == 1 && this.f7283x) {
            mo9249i().f7287o.mo9446a().mo9397a(this.f7284y);
            mo9249i().f7287o.mo9458f();
        }
        this.f7283x = false;
    }

    /* renamed from: o */
    public boolean mo9364o() {
        return this.f7073g.f6921a == 1;
    }

    /* renamed from: p */
    public boolean mo9365p() {
        return this.f7259B;
    }

    /* renamed from: q */
    public boolean mo9366q() {
        return this.f7279t == 1;
    }

    /* renamed from: r */
    public boolean mo9367r() {
        return this.f7258A;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0029 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo9368s() {
        /*
            r4 = this;
            int r0 = r4.f7279t
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001b
            if (r0 == r2) goto L_0x000c
            r3 = 2
            if (r0 == r3) goto L_0x002a
            goto L_0x0029
        L_0x000c:
            boolean r0 = r4.f7276S
            if (r0 != 0) goto L_0x0029
            int r0 = com.chartboost.sdk.Libraries.CBUtility.m8174e()
            boolean r0 = com.chartboost.sdk.Libraries.CBUtility.m8171b(r0)
            if (r0 == 0) goto L_0x002a
            goto L_0x0029
        L_0x001b:
            boolean r0 = r4.f7277T
            if (r0 != 0) goto L_0x0029
            int r0 = com.chartboost.sdk.Libraries.CBUtility.m8174e()
            boolean r0 = com.chartboost.sdk.Libraries.CBUtility.m8171b(r0)
            if (r0 == 0) goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C2158i0.mo9368s():boolean");
    }

    /* renamed from: t */
    public void mo9369t() {
        String str = this.f7281v;
        if (str != null) {
            new File(str).delete();
        }
        this.f7259B = true;
        mo9236a(CBError.CBImpressionError.ERROR_PLAYING_VIDEO);
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public void mo9370u() {
        this.f7073g.mo9145v();
    }

    /* renamed from: a */
    public void mo9363a(boolean z) {
        this.f7258A = z;
    }

    /* renamed from: i */
    public C2160b m8582i() {
        return (C2160b) super.mo9249i();
    }

    /* renamed from: b */
    public void mo9241b() {
        super.mo9241b();
        this.f7267J = null;
        this.f7268K = null;
        this.f7271N = null;
        this.f7272O = null;
        this.f7273P = null;
        this.f7269L = null;
        this.f7270M = null;
        this.f7274Q = null;
    }
}
