package androidx.core.p020f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* renamed from: androidx.core.f.x */
/* compiled from: ViewPropertyAnimatorCompat */
public final class C0851x {

    /* renamed from: a */
    private WeakReference<View> f2065a;

    /* renamed from: b */
    Runnable f2066b = null;

    /* renamed from: c */
    Runnable f2067c = null;

    /* renamed from: d */
    int f2068d = -1;

    /* renamed from: androidx.core.f.x$a */
    /* compiled from: ViewPropertyAnimatorCompat */
    class C0852a extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ C0855y f2069a;

        /* renamed from: b */
        final /* synthetic */ View f2070b;

        C0852a(C0851x xVar, C0855y yVar, View view) {
            this.f2069a = yVar;
            this.f2070b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f2069a.mo3360a(this.f2070b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f2069a.mo2086b(this.f2070b);
        }

        public void onAnimationStart(Animator animator) {
            this.f2069a.mo2087c(this.f2070b);
        }
    }

    /* renamed from: androidx.core.f.x$b */
    /* compiled from: ViewPropertyAnimatorCompat */
    class C0853b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ C0799a0 f2071a;

        /* renamed from: b */
        final /* synthetic */ View f2072b;

        C0853b(C0851x xVar, C0799a0 a0Var, View view) {
            this.f2071a = a0Var;
            this.f2072b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f2071a.mo2149a(this.f2072b);
        }
    }

    /* renamed from: androidx.core.f.x$c */
    /* compiled from: ViewPropertyAnimatorCompat */
    static class C0854c implements C0855y {

        /* renamed from: a */
        C0851x f2073a;

        /* renamed from: b */
        boolean f2074b;

        C0854c(C0851x xVar) {
            this.f2073a = xVar;
        }

        /* renamed from: a */
        public void mo3360a(View view) {
            Object tag = view.getTag(2113929216);
            C0855y yVar = tag instanceof C0855y ? (C0855y) tag : null;
            if (yVar != null) {
                yVar.mo3360a(view);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.core.f.y} */
        /* JADX WARNING: Multi-variable type inference failed */
        @android.annotation.SuppressLint({"WrongConstant"})
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo2086b(android.view.View r4) {
            /*
                r3 = this;
                androidx.core.f.x r0 = r3.f2073a
                int r0 = r0.f2068d
                r1 = -1
                r2 = 0
                if (r0 <= r1) goto L_0x000f
                r4.setLayerType(r0, r2)
                androidx.core.f.x r0 = r3.f2073a
                r0.f2068d = r1
            L_0x000f:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 16
                if (r0 >= r1) goto L_0x0019
                boolean r0 = r3.f2074b
                if (r0 != 0) goto L_0x0039
            L_0x0019:
                androidx.core.f.x r0 = r3.f2073a
                java.lang.Runnable r1 = r0.f2067c
                if (r1 == 0) goto L_0x0024
                r0.f2067c = r2
                r1.run()
            L_0x0024:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r1 = r0 instanceof androidx.core.p020f.C0855y
                if (r1 == 0) goto L_0x0031
                r2 = r0
                androidx.core.f.y r2 = (androidx.core.p020f.C0855y) r2
            L_0x0031:
                if (r2 == 0) goto L_0x0036
                r2.mo2086b(r4)
            L_0x0036:
                r4 = 1
                r3.f2074b = r4
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.p020f.C0851x.C0854c.mo2086b(android.view.View):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.core.f.y} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo2087c(android.view.View r4) {
            /*
                r3 = this;
                r0 = 0
                r3.f2074b = r0
                androidx.core.f.x r0 = r3.f2073a
                int r0 = r0.f2068d
                r1 = 0
                r2 = -1
                if (r0 <= r2) goto L_0x000f
                r0 = 2
                r4.setLayerType(r0, r1)
            L_0x000f:
                androidx.core.f.x r0 = r3.f2073a
                java.lang.Runnable r2 = r0.f2066b
                if (r2 == 0) goto L_0x001a
                r0.f2066b = r1
                r2.run()
            L_0x001a:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r2 = r0 instanceof androidx.core.p020f.C0855y
                if (r2 == 0) goto L_0x0027
                r1 = r0
                androidx.core.f.y r1 = (androidx.core.p020f.C0855y) r1
            L_0x0027:
                if (r1 == 0) goto L_0x002c
                r1.mo2087c(r4)
            L_0x002c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.p020f.C0851x.C0854c.mo2087c(android.view.View):void");
        }
    }

    C0851x(View view) {
        this.f2065a = new WeakReference<>(view);
    }

    /* renamed from: a */
    public C0851x mo4207a(long j) {
        View view = (View) this.f2065a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    /* renamed from: b */
    public C0851x mo4213b(float f) {
        View view = (View) this.f2065a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    /* renamed from: c */
    public void mo4215c() {
        View view = (View) this.f2065a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    /* renamed from: a */
    public C0851x mo4206a(float f) {
        View view = (View) this.f2065a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    /* renamed from: b */
    public long mo4212b() {
        View view = (View) this.f2065a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    /* renamed from: a */
    public C0851x mo4208a(Interpolator interpolator) {
        View view = (View) this.f2065a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    /* renamed from: b */
    public C0851x mo4214b(long j) {
        View view = (View) this.f2065a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    /* renamed from: a */
    public void mo4211a() {
        View view = (View) this.f2065a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    /* renamed from: a */
    public C0851x mo4210a(C0855y yVar) {
        View view = (View) this.f2065a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                m2771a(view, yVar);
            } else {
                view.setTag(2113929216, yVar);
                m2771a(view, new C0854c(this));
            }
        }
        return this;
    }

    /* renamed from: a */
    private void m2771a(View view, C0855y yVar) {
        if (yVar != null) {
            view.animate().setListener(new C0852a(this, yVar, view));
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    /* renamed from: a */
    public C0851x mo4209a(C0799a0 a0Var) {
        View view = (View) this.f2065a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            C0853b bVar = null;
            if (a0Var != null) {
                bVar = new C0853b(this, a0Var, view);
            }
            view.animate().setUpdateListener(bVar);
        }
        return this;
    }
}
