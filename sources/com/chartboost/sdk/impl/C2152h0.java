package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.chartboost.sdk.C2102d;
import com.chartboost.sdk.C2109f;
import com.chartboost.sdk.C2116i;
import com.chartboost.sdk.Libraries.C2076e;
import com.chartboost.sdk.Libraries.C2080h;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C2088c;
import com.chartboost.sdk.Model.CBError;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.h0 */
public class C2152h0 extends C2109f {

    /* renamed from: l */
    C2080h f7239l = new C2080h(this);

    /* renamed from: m */
    C2080h f7240m = new C2080h(this);

    /* renamed from: n */
    C2080h f7241n = new C2080h(this);

    /* renamed from: o */
    C2080h f7242o = new C2080h(this);

    /* renamed from: p */
    C2080h f7243p = new C2080h(this);

    /* renamed from: q */
    C2080h f7244q = new C2080h(this);

    /* renamed from: r */
    protected float f7245r = 1.0f;

    public C2152h0(C2088c cVar, Handler handler, C2102d dVar) {
        super(cVar, handler, dVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C2109f.C2111b mo9233a(Context context) {
        return new C2153a(context);
    }

    /* renamed from: b */
    public boolean mo9242b(JSONObject jSONObject) {
        if (!super.mo9242b(jSONObject)) {
            return false;
        }
        if (this.f7071e.isNull("frame-portrait") || this.f7071e.isNull("close-portrait")) {
            this.f7076j = false;
        }
        if (this.f7071e.isNull("frame-landscape") || this.f7071e.isNull("close-landscape")) {
            this.f7077k = false;
        }
        if (this.f7071e.isNull("ad-portrait")) {
            this.f7076j = false;
        }
        if (this.f7071e.isNull("ad-landscape")) {
            this.f7077k = false;
        }
        if (this.f7240m.mo9099a("frame-landscape") && this.f7239l.mo9099a("frame-portrait") && this.f7242o.mo9099a("close-landscape") && this.f7241n.mo9099a("close-portrait") && this.f7244q.mo9099a("ad-landscape") && this.f7243p.mo9099a("ad-portrait")) {
            return true;
        }
        CBLogging.m8154b("ImageViewProtocol", "Error while downloading the assets");
        mo9236a(CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE);
        return false;
    }

    /* renamed from: a */
    public void mo9356a(ViewGroup.LayoutParams layoutParams, C2080h hVar, float f) {
        if (hVar != null && hVar.mo9104e()) {
            layoutParams.width = (int) ((((float) hVar.mo9103d()) / hVar.mo9098a()) * f);
            layoutParams.height = (int) ((((float) hVar.mo9102c()) / hVar.mo9098a()) * f);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.h0$a */
    public class C2153a extends C2109f.C2111b {

        /* renamed from: h */
        protected C2201q1 f7246h;

        /* renamed from: i */
        protected C2204r1 f7247i;

        /* renamed from: j */
        private boolean f7248j = false;

        /* renamed from: k */
        protected C2204r1 f7249k;

        /* renamed from: l */
        protected ImageView f7250l;

        /* renamed from: com.chartboost.sdk.impl.h0$a$a */
        class C2154a extends C2204r1 {
            C2154a(Context context, C2152h0 h0Var) {
                super(context);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo9350a(MotionEvent motionEvent) {
                C2153a.this.mo9358a(motionEvent.getX(), motionEvent.getY(), (float) C2153a.this.f7249k.getWidth(), (float) C2153a.this.f7249k.getHeight());
            }
        }

        /* renamed from: com.chartboost.sdk.impl.h0$a$b */
        class C2155b extends C2204r1 {
            C2155b(Context context) {
                super(context);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo9350a(MotionEvent motionEvent) {
                C2153a.this.mo9359c();
            }
        }

        protected C2153a(Context context) {
            super(context);
            setBackgroundColor(0);
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            C2116i a = C2116i.m8407a();
            C2201q1 q1Var = (C2201q1) a.mo9266a(new C2201q1(context));
            this.f7246h = q1Var;
            addView(q1Var, new RelativeLayout.LayoutParams(-1, -1));
            C2204r1 r1Var = (C2204r1) a.mo9266a(new C2154a(context, C2152h0.this));
            this.f7249k = r1Var;
            mo9258a((View) r1Var);
            this.f7249k.setContentDescription("CBAd");
            ImageView imageView = (ImageView) a.mo9266a(new ImageView(context));
            this.f7250l = imageView;
            imageView.setBackgroundColor(-16777216);
            addView(this.f7250l);
            addView(this.f7249k);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo9358a(float f, float f2, float f3, float f4) {
            C2152h0.this.mo9240a(C2076e.m8186a(C2076e.m8184a("x", (Object) Float.valueOf(f)), C2076e.m8184a("y", (Object) Float.valueOf(f2)), C2076e.m8184a("w", (Object) Float.valueOf(f3)), C2076e.m8184a("h", (Object) Float.valueOf(f4))));
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo9359c() {
            C2152h0.this.mo9234a();
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo9360d() {
            C2155b bVar = new C2155b(getContext());
            this.f7247i = bVar;
            bVar.setContentDescription("CBClose");
            addView(this.f7247i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo9257a(int i, int i2) {
            int i3;
            int i4;
            if (!this.f7248j) {
                mo9360d();
                this.f7248j = true;
            }
            boolean b = CBUtility.m8171b(C2152h0.this.mo9246f());
            C2080h hVar = b ? C2152h0.this.f7239l : C2152h0.this.f7240m;
            C2080h hVar2 = b ? C2152h0.this.f7241n : C2152h0.this.f7242o;
            if (!hVar.mo9104e()) {
                C2152h0 h0Var = C2152h0.this;
                C2080h hVar3 = h0Var.f7239l;
                hVar = hVar == hVar3 ? h0Var.f7240m : hVar3;
            }
            if (!hVar2.mo9104e()) {
                C2152h0 h0Var2 = C2152h0.this;
                C2080h hVar4 = h0Var2.f7241n;
                hVar2 = hVar2 == hVar4 ? h0Var2.f7242o : hVar4;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            C2152h0.this.mo9356a(layoutParams, hVar, 1.0f);
            C2152h0.this.f7245r = Math.min(Math.min(((float) i) / ((float) layoutParams.width), ((float) i2) / ((float) layoutParams.height)), 1.0f);
            C2152h0 h0Var3 = C2152h0.this;
            float f = h0Var3.f7245r;
            layoutParams.width = (int) (((float) layoutParams.width) * f);
            layoutParams.height = (int) (((float) layoutParams.height) * f);
            Point b2 = h0Var3.mo9357b(b ? "frame-portrait" : "frame-landscape");
            layoutParams.leftMargin = Math.round((((float) (i - layoutParams.width)) / 2.0f) + ((((float) b2.x) / hVar.mo9098a()) * C2152h0.this.f7245r));
            layoutParams.topMargin = Math.round((((float) (i2 - layoutParams.height)) / 2.0f) + ((((float) b2.y) / hVar.mo9098a()) * C2152h0.this.f7245r));
            C2152h0.this.mo9356a(layoutParams2, hVar2, 1.0f);
            Point b3 = C2152h0.this.mo9357b(b ? "close-portrait" : "close-landscape");
            if (b3.x == 0 && b3.y == 0) {
                i4 = layoutParams.leftMargin + layoutParams.width + Math.round(((float) (-layoutParams2.width)) / 2.0f);
                i3 = layoutParams.topMargin + Math.round(((float) (-layoutParams2.height)) / 2.0f);
            } else {
                int round = Math.round(((((float) layoutParams.leftMargin) + (((float) layoutParams.width) / 2.0f)) + ((float) b3.x)) - (((float) layoutParams2.width) / 2.0f));
                i3 = Math.round(((((float) layoutParams.topMargin) + (((float) layoutParams.height) / 2.0f)) + ((float) b3.y)) - (((float) layoutParams2.height) / 2.0f));
                i4 = round;
            }
            layoutParams2.leftMargin = Math.min(Math.max(0, i4), i - layoutParams2.width);
            layoutParams2.topMargin = Math.min(Math.max(0, i3), i2 - layoutParams2.height);
            this.f7246h.setLayoutParams(layoutParams);
            this.f7247i.setLayoutParams(layoutParams2);
            this.f7246h.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f7246h.mo9496a(hVar);
            this.f7247i.mo9502a(hVar2);
            C2080h hVar5 = b ? C2152h0.this.f7243p : C2152h0.this.f7244q;
            if (!hVar5.mo9104e()) {
                C2152h0 h0Var4 = C2152h0.this;
                C2080h hVar6 = h0Var4.f7243p;
                hVar5 = hVar5 == hVar6 ? h0Var4.f7244q : hVar6;
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            C2152h0 h0Var5 = C2152h0.this;
            h0Var5.mo9356a(layoutParams3, hVar5, h0Var5.f7245r);
            Point b4 = C2152h0.this.mo9357b(b ? "ad-portrait" : "ad-landscape");
            layoutParams3.leftMargin = Math.round((((float) (i - layoutParams3.width)) / 2.0f) + ((((float) b4.x) / hVar5.mo9098a()) * C2152h0.this.f7245r));
            layoutParams3.topMargin = Math.round((((float) (i2 - layoutParams3.height)) / 2.0f) + ((((float) b4.y) / hVar5.mo9098a()) * C2152h0.this.f7245r));
            this.f7250l.setLayoutParams(layoutParams3);
            this.f7249k.setLayoutParams(layoutParams3);
            this.f7249k.mo9501a(ImageView.ScaleType.FIT_CENTER);
            this.f7249k.mo9502a(hVar5);
        }

        /* renamed from: a */
        public void mo9256a() {
            super.mo9256a();
            this.f7246h = null;
            this.f7247i = null;
            this.f7249k = null;
            this.f7250l = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Point mo9357b(String str) {
        JSONObject a = C2076e.m8185a(this.f7071e, str, "offset");
        if (a != null) {
            return new Point(a.optInt("x"), a.optInt("y"));
        }
        return new Point(0, 0);
    }

    /* renamed from: b */
    public void mo9241b() {
        super.mo9241b();
        this.f7240m = null;
        this.f7239l = null;
        this.f7242o = null;
        this.f7241n = null;
        this.f7244q = null;
        this.f7243p = null;
    }
}
