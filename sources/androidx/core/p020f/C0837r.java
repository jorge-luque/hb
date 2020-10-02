package androidx.core.p020f;

import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: androidx.core.f.r */
/* compiled from: OneShotPreDrawListener */
public final class C0837r implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    private final View f2043a;

    /* renamed from: b */
    private ViewTreeObserver f2044b;

    /* renamed from: c */
    private final Runnable f2045c;

    private C0837r(View view, Runnable runnable) {
        this.f2043a = view;
        this.f2044b = view.getViewTreeObserver();
        this.f2045c = runnable;
    }

    /* renamed from: a */
    public static C0837r m2676a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        } else if (runnable != null) {
            C0837r rVar = new C0837r(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(rVar);
            view.addOnAttachStateChangeListener(rVar);
            return rVar;
        } else {
            throw new NullPointerException("runnable == null");
        }
    }

    public boolean onPreDraw() {
        mo4193a();
        this.f2045c.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f2044b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        mo4193a();
    }

    /* renamed from: a */
    public void mo4193a() {
        if (this.f2044b.isAlive()) {
            this.f2044b.removeOnPreDrawListener(this);
        } else {
            this.f2043a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f2043a.removeOnAttachStateChangeListener(this);
    }
}
