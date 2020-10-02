package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Libraries.CBUtility;

/* renamed from: com.chartboost.sdk.impl.m0 */
public abstract class C2178m0 extends RelativeLayout {

    /* renamed from: a */
    protected C2158i0 f7349a;

    /* renamed from: b */
    private C2183n0 f7350b;

    /* renamed from: c */
    private int f7351c = 1;

    /* renamed from: com.chartboost.sdk.impl.m0$a */
    class C2179a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f7352a;

        C2179a(boolean z) {
            this.f7352a = z;
        }

        public void run() {
            if (!this.f7352a) {
                C2178m0.this.setVisibility(8);
                C2178m0.this.clearAnimation();
            }
            synchronized (C2178m0.this.f7349a.f7075i) {
                C2178m0.this.f7349a.f7075i.remove(C2178m0.this);
            }
        }
    }

    public C2178m0(Context context, C2158i0 i0Var) {
        super(context);
        this.f7349a = i0Var;
        m8657a(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract View mo9347a();

    /* renamed from: a */
    public void mo9418a(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        this.f7351c = i;
        setClickable(false);
        int b = mo9349b();
        int i2 = this.f7351c;
        if (i2 == 0) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, CBUtility.m8162a(b, getContext()));
            layoutParams2.addRule(10);
            this.f7350b.mo9439a(1);
        } else if (i2 == 1) {
            layoutParams2 = new RelativeLayout.LayoutParams(-1, CBUtility.m8162a(b, getContext()));
            layoutParams2.addRule(12);
            this.f7350b.mo9439a(4);
        } else if (i2 == 2) {
            layoutParams2 = new RelativeLayout.LayoutParams(CBUtility.m8162a(b, getContext()), -1);
            layoutParams2.addRule(9);
            this.f7350b.mo9439a(8);
        } else if (i2 != 3) {
            layoutParams = null;
            setLayoutParams(layoutParams);
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(CBUtility.m8162a(b, getContext()), -1);
            layoutParams2.addRule(11);
            this.f7350b.mo9439a(2);
        }
        layoutParams = layoutParams2;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo9349b();

    /* renamed from: a */
    private void m8657a(Context context) {
        Context context2 = getContext();
        setGravity(17);
        C2183n0 n0Var = new C2183n0(context2);
        this.f7350b = n0Var;
        n0Var.mo9440b(-1);
        this.f7350b.setBackgroundColor(-855638017);
        addView(this.f7350b, new RelativeLayout.LayoutParams(-1, -1));
        addView(mo9347a(), new RelativeLayout.LayoutParams(-1, -1));
    }

    /* renamed from: a */
    public void mo9419a(boolean z) {
        m8658a(z, 500);
    }

    /* renamed from: a */
    private void m8658a(boolean z, long j) {
        this.f7349a.f7265H = z;
        if (z && getVisibility() == 0) {
            return;
        }
        if (z || getVisibility() != 8) {
            C2179a aVar = new C2179a(z);
            if (z) {
                setVisibility(0);
            }
            float a = CBUtility.m8160a((float) mo9349b(), getContext());
            TranslateAnimation translateAnimation = null;
            int i = this.f7351c;
            if (i == 0) {
                translateAnimation = new TranslateAnimation(0.0f, 0.0f, z ? -a : 0.0f, z ? 0.0f : -a);
            } else if (i == 1) {
                float f = z ? a : 0.0f;
                if (z) {
                    a = 0.0f;
                }
                translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, a);
            } else if (i == 2) {
                translateAnimation = new TranslateAnimation(z ? -a : 0.0f, z ? 0.0f : -a, 0.0f, 0.0f);
            } else if (i == 3) {
                float f2 = z ? a : 0.0f;
                if (z) {
                    a = 0.0f;
                }
                translateAnimation = new TranslateAnimation(f2, a, 0.0f, 0.0f);
            }
            translateAnimation.setDuration(j);
            translateAnimation.setFillAfter(!z);
            startAnimation(translateAnimation);
            synchronized (this.f7349a.f7075i) {
                this.f7349a.f7075i.put(this, aVar);
            }
            this.f7349a.f7067a.postDelayed(aVar, j);
        }
    }
}
