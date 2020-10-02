package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.core.p020f.C0839t;

/* renamed from: androidx.appcompat.widget.e */
/* compiled from: AppCompatBackgroundHelper */
class C0592e {

    /* renamed from: a */
    private final View f1417a;

    /* renamed from: b */
    private final C0596g f1418b;

    /* renamed from: c */
    private int f1419c = -1;

    /* renamed from: d */
    private C0593e0 f1420d;

    /* renamed from: e */
    private C0593e0 f1421e;

    /* renamed from: f */
    private C0593e0 f1422f;

    C0592e(View view) {
        this.f1417a = view;
        this.f1418b = C0596g.m1590b();
    }

    /* renamed from: d */
    private boolean m1570d() {
        int i = Build.VERSION.SDK_INT;
        if (i <= 21) {
            return i == 21;
        }
        if (this.f1420d != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3409a(AttributeSet attributeSet, int i) {
        C0598g0 a = C0598g0.m1610a(this.f1417a.getContext(), attributeSet, R$styleable.ViewBackgroundHelper, i, 0);
        try {
            if (a.mo3447g(R$styleable.ViewBackgroundHelper_android_background)) {
                this.f1419c = a.mo3446g(R$styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList b = this.f1418b.mo3424b(this.f1417a.getContext(), this.f1419c);
                if (b != null) {
                    mo3406a(b);
                }
            }
            if (a.mo3447g(R$styleable.ViewBackgroundHelper_backgroundTint)) {
                C0839t.m2693a(this.f1417a, a.mo3432a(R$styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (a.mo3447g(R$styleable.ViewBackgroundHelper_backgroundTintMode)) {
                C0839t.m2695a(this.f1417a, C0621q.m1806a(a.mo3440d(R$styleable.ViewBackgroundHelper_backgroundTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a.mo3434a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3411b(ColorStateList colorStateList) {
        if (this.f1421e == null) {
            this.f1421e = new C0593e0();
        }
        C0593e0 e0Var = this.f1421e;
        e0Var.f1423a = colorStateList;
        e0Var.f1426d = true;
        mo3404a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public PorterDuff.Mode mo3412c() {
        C0593e0 e0Var = this.f1421e;
        if (e0Var != null) {
            return e0Var.f1424b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ColorStateList mo3410b() {
        C0593e0 e0Var = this.f1421e;
        if (e0Var != null) {
            return e0Var.f1423a;
        }
        return null;
    }

    /* renamed from: b */
    private boolean m1569b(Drawable drawable) {
        if (this.f1422f == null) {
            this.f1422f = new C0593e0();
        }
        C0593e0 e0Var = this.f1422f;
        e0Var.mo3413a();
        ColorStateList g = C0839t.m2717g(this.f1417a);
        if (g != null) {
            e0Var.f1426d = true;
            e0Var.f1423a = g;
        }
        PorterDuff.Mode h = C0839t.m2719h(this.f1417a);
        if (h != null) {
            e0Var.f1425c = true;
            e0Var.f1424b = h;
        }
        if (!e0Var.f1426d && !e0Var.f1425c) {
            return false;
        }
        C0596g.m1589a(drawable, e0Var, this.f1417a.getDrawableState());
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3405a(int i) {
        this.f1419c = i;
        C0596g gVar = this.f1418b;
        mo3406a(gVar != null ? gVar.mo3424b(this.f1417a.getContext(), i) : null);
        mo3404a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3408a(Drawable drawable) {
        this.f1419c = -1;
        mo3406a((ColorStateList) null);
        mo3404a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3407a(PorterDuff.Mode mode) {
        if (this.f1421e == null) {
            this.f1421e = new C0593e0();
        }
        C0593e0 e0Var = this.f1421e;
        e0Var.f1424b = mode;
        e0Var.f1425c = true;
        mo3404a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3404a() {
        Drawable background = this.f1417a.getBackground();
        if (background == null) {
            return;
        }
        if (!m1570d() || !m1569b(background)) {
            C0593e0 e0Var = this.f1421e;
            if (e0Var != null) {
                C0596g.m1589a(background, e0Var, this.f1417a.getDrawableState());
                return;
            }
            C0593e0 e0Var2 = this.f1420d;
            if (e0Var2 != null) {
                C0596g.m1589a(background, e0Var2, this.f1417a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3406a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1420d == null) {
                this.f1420d = new C0593e0();
            }
            C0593e0 e0Var = this.f1420d;
            e0Var.f1423a = colorStateList;
            e0Var.f1426d = true;
        } else {
            this.f1420d = null;
        }
        mo3404a();
    }
}
