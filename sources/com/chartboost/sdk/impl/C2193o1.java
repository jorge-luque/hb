package com.chartboost.sdk.impl;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.chartboost.sdk.C2107e;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C2086a;
import com.chartboost.sdk.Model.C2088c;

/* renamed from: com.chartboost.sdk.impl.o1 */
public class C2193o1 {

    /* renamed from: a */
    private final Handler f7412a;

    /* renamed from: com.chartboost.sdk.impl.o1$a */
    class C2194a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        final /* synthetic */ View f7413a;

        /* renamed from: b */
        final /* synthetic */ int f7414b;

        /* renamed from: c */
        final /* synthetic */ C2088c f7415c;

        /* renamed from: d */
        final /* synthetic */ Runnable f7416d;

        /* renamed from: e */
        final /* synthetic */ boolean f7417e;

        C2194a(View view, int i, C2088c cVar, Runnable runnable, boolean z) {
            this.f7413a = view;
            this.f7414b = i;
            this.f7415c = cVar;
            this.f7416d = runnable;
            this.f7417e = z;
        }

        public void onGlobalLayout() {
            this.f7413a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            C2193o1.this.mo9473a(this.f7414b, this.f7415c, this.f7416d, this.f7417e);
        }
    }

    public C2193o1(Handler handler) {
        this.f7412a = handler;
    }

    /* renamed from: a */
    public static Integer m8724a(int i) {
        if (i < 1 || i > 9) {
            return null;
        }
        return Integer.valueOf(i);
    }

    /* renamed from: a */
    public void mo9472a(int i, C2088c cVar, Runnable runnable, C2107e eVar) {
        m8725a(i, cVar, runnable, true, eVar);
    }

    /* renamed from: a */
    public void mo9471a(int i, C2088c cVar, Runnable runnable) {
        mo9473a(i, cVar, runnable, false);
    }

    /* renamed from: a */
    private void m8725a(int i, C2088c cVar, Runnable runnable, boolean z, C2107e eVar) {
        C2216u1 u1Var;
        if (i == 7) {
            if (runnable != null) {
                runnable.run();
            }
        } else if (cVar == null || (u1Var = cVar.f6945y) == null) {
            CBLogging.m8152a("AnimationManager", "Transition of impression canceled due to lack of container");
        } else {
            View c = u1Var.mo9518c();
            if (c == null) {
                eVar.mo9229d(cVar);
                CBLogging.m8152a("AnimationManager", "Transition of impression canceled due to lack of view");
                return;
            }
            ViewTreeObserver viewTreeObserver = c.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new C2194a(c, i, cVar, runnable, z));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9473a(int i, C2088c cVar, Runnable runnable, boolean z) {
        C2216u1 u1Var;
        C2210s1 s1Var;
        ScaleAnimation scaleAnimation;
        TranslateAnimation translateAnimation;
        C2210s1 s1Var2;
        ScaleAnimation scaleAnimation2;
        TranslateAnimation translateAnimation2;
        AlphaAnimation alphaAnimation;
        int i2 = i;
        C2088c cVar2 = cVar;
        Runnable runnable2 = runnable;
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 1.0f));
        if (cVar2 == null || (u1Var = cVar2.f6945y) == null) {
            CBLogging.m8152a("AnimationManager", "Transition of impression canceled due to lack of container");
            if (runnable2 != null) {
                runnable.run();
                return;
            }
            return;
        }
        View c = u1Var.mo9518c();
        if (c == null) {
            if (runnable2 != null) {
                runnable.run();
            }
            CBLogging.m8152a("AnimationManager", "Transition of impression canceled due to lack of view");
            return;
        }
        int i3 = cVar2.f6921a;
        if (i3 == 2 || i3 == 1) {
            c = cVar2.f6945y;
        }
        float width = (float) c.getWidth();
        float height = (float) c.getHeight();
        int i4 = cVar2.f6938r.f6896b;
        switch (i2) {
            case 1:
                if (z) {
                    s1Var = new C2210s1(-60.0f, 0.0f, width / 2.0f, height / 2.0f, true);
                } else {
                    s1Var = new C2210s1(0.0f, 60.0f, width / 2.0f, height / 2.0f, true);
                }
                s1Var.setDuration(500);
                s1Var.setFillAfter(true);
                animationSet.addAnimation(s1Var);
                if (z) {
                    scaleAnimation = new ScaleAnimation(0.4f, 1.0f, 0.4f, 1.0f);
                } else {
                    scaleAnimation = new ScaleAnimation(1.0f, 0.4f, 1.0f, 0.4f);
                }
                scaleAnimation.setDuration(500);
                scaleAnimation.setFillAfter(true);
                animationSet.addAnimation(scaleAnimation);
                if (z) {
                    translateAnimation = new TranslateAnimation((-width) * 0.4f, 0.0f, height * 0.3f, 0.0f);
                } else {
                    translateAnimation = new TranslateAnimation(0.0f, width, 0.0f, height * 0.3f);
                }
                translateAnimation.setDuration(500);
                translateAnimation.setFillAfter(true);
                animationSet.addAnimation(translateAnimation);
                break;
            case 2:
                if (!z) {
                    ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation3.setDuration(500);
                    scaleAnimation3.setStartOffset(0);
                    scaleAnimation3.setFillAfter(true);
                    animationSet.addAnimation(scaleAnimation3);
                    break;
                } else {
                    ScaleAnimation scaleAnimation4 = new ScaleAnimation(0.6f, 1.1f, 0.6f, 1.1f, 1, 0.5f, 1, 0.5f);
                    float f = (float) 500;
                    float f2 = 0.6f * f;
                    scaleAnimation4.setDuration((long) Math.round(f2));
                    scaleAnimation4.setStartOffset(0);
                    scaleAnimation4.setFillAfter(true);
                    animationSet.addAnimation(scaleAnimation4);
                    ScaleAnimation scaleAnimation5 = new ScaleAnimation(1.0f, 0.81818175f, 1.0f, 0.81818175f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation5.setDuration((long) Math.round(0.19999999f * f));
                    scaleAnimation5.setStartOffset((long) Math.round(f2));
                    scaleAnimation5.setFillAfter(true);
                    animationSet.addAnimation(scaleAnimation5);
                    ScaleAnimation scaleAnimation6 = new ScaleAnimation(1.0f, 1.1111112f, 1.0f, 1.1111112f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation6.setDuration((long) Math.round(0.099999964f * f));
                    scaleAnimation6.setStartOffset((long) Math.round(f * 0.8f));
                    scaleAnimation6.setFillAfter(true);
                    animationSet.addAnimation(scaleAnimation6);
                    break;
                }
            case 3:
                if (z) {
                    s1Var2 = new C2210s1(-60.0f, 0.0f, width / 2.0f, height / 2.0f, false);
                } else {
                    s1Var2 = new C2210s1(0.0f, 60.0f, width / 2.0f, height / 2.0f, false);
                }
                C2210s1 s1Var3 = s1Var2;
                s1Var3.setDuration(500);
                s1Var3.setFillAfter(true);
                animationSet.addAnimation(s1Var3);
                if (z) {
                    scaleAnimation2 = new ScaleAnimation(0.4f, 1.0f, 0.4f, 1.0f);
                } else {
                    scaleAnimation2 = new ScaleAnimation(1.0f, 0.4f, 1.0f, 0.4f);
                }
                scaleAnimation2.setDuration(500);
                scaleAnimation2.setFillAfter(true);
                animationSet.addAnimation(scaleAnimation2);
                if (z) {
                    translateAnimation2 = new TranslateAnimation(width * 0.3f, 0.0f, (-height) * 0.4f, 0.0f);
                } else {
                    translateAnimation2 = new TranslateAnimation(0.0f, width * 0.3f, 0.0f, height);
                }
                translateAnimation2.setDuration(500);
                translateAnimation2.setFillAfter(true);
                animationSet.addAnimation(translateAnimation2);
                break;
            case 4:
                TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, z ? -height : 0.0f, z ? 0.0f : -height);
                translateAnimation3.setDuration(500);
                translateAnimation3.setFillAfter(true);
                animationSet.addAnimation(translateAnimation3);
                break;
            case 5:
                float f3 = z ? height : 0.0f;
                if (z) {
                    height = 0.0f;
                }
                TranslateAnimation translateAnimation4 = new TranslateAnimation(0.0f, 0.0f, f3, height);
                translateAnimation4.setDuration(500);
                translateAnimation4.setFillAfter(true);
                animationSet.addAnimation(translateAnimation4);
                break;
            case 6:
                if (z) {
                    alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                }
                alphaAnimation.setDuration(500);
                alphaAnimation.setFillAfter(true);
                animationSet = new AnimationSet(true);
                animationSet.addAnimation(alphaAnimation);
                break;
            case 8:
                float f4 = z ? width : 0.0f;
                if (z) {
                    width = 0.0f;
                }
                TranslateAnimation translateAnimation5 = new TranslateAnimation(f4, width, 0.0f, 0.0f);
                translateAnimation5.setDuration(500);
                translateAnimation5.setFillAfter(true);
                animationSet.addAnimation(translateAnimation5);
                break;
            case 9:
                TranslateAnimation translateAnimation6 = new TranslateAnimation(z ? -width : 0.0f, z ? 0.0f : -width, 0.0f, 0.0f);
                translateAnimation6.setDuration(500);
                translateAnimation6.setFillAfter(true);
                animationSet.addAnimation(translateAnimation6);
                break;
        }
        if (i2 == 7) {
            if (runnable2 != null) {
                runnable.run();
            }
            return;
        }
        if (runnable2 != null) {
            this.f7412a.postDelayed(runnable2, 500);
        }
        c.startAnimation(animationSet);
    }

    /* renamed from: a */
    public void mo9475a(boolean z, View view, C2086a aVar) {
        int i = aVar.f6896b;
        mo9474a(z, view, 500);
    }

    /* renamed from: a */
    public void mo9474a(boolean z, View view, long j) {
        view.clearAnimation();
        if (z) {
            view.setVisibility(0);
        }
        float f = 0.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (z) {
            f = 1.0f;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setFillBefore(true);
        view.startAnimation(alphaAnimation);
    }
}
