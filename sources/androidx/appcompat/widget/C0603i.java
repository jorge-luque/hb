package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.p006a.p007a.C0383a;
import androidx.core.widget.C0875e;

/* renamed from: androidx.appcompat.widget.i */
/* compiled from: AppCompatImageHelper */
public class C0603i {

    /* renamed from: a */
    private final ImageView f1468a;

    /* renamed from: b */
    private C0593e0 f1469b;

    /* renamed from: c */
    private C0593e0 f1470c;

    /* renamed from: d */
    private C0593e0 f1471d;

    public C0603i(ImageView imageView) {
        this.f1468a = imageView;
    }

    /* renamed from: e */
    private boolean m1670e() {
        int i = Build.VERSION.SDK_INT;
        if (i <= 21) {
            return i == 21;
        }
        if (this.f1469b != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo3486a(AttributeSet attributeSet, int i) {
        int g;
        C0598g0 a = C0598g0.m1610a(this.f1468a.getContext(), attributeSet, R$styleable.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f1468a.getDrawable();
            if (!(drawable != null || (g = a.mo3446g(R$styleable.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = C0383a.m323c(this.f1468a.getContext(), g)) == null)) {
                this.f1468a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                C0621q.m1808b(drawable);
            }
            if (a.mo3447g(R$styleable.AppCompatImageView_tint)) {
                C0875e.m2925a(this.f1468a, a.mo3432a(R$styleable.AppCompatImageView_tint));
            }
            if (a.mo3447g(R$styleable.AppCompatImageView_tintMode)) {
                C0875e.m2926a(this.f1468a, C0621q.m1806a(a.mo3440d(R$styleable.AppCompatImageView_tintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a.mo3434a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ColorStateList mo3487b() {
        C0593e0 e0Var = this.f1470c;
        if (e0Var != null) {
            return e0Var.f1423a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public PorterDuff.Mode mo3488c() {
        C0593e0 e0Var = this.f1470c;
        if (e0Var != null) {
            return e0Var.f1424b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo3489d() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1468a.getBackground() instanceof RippleDrawable);
    }

    /* renamed from: a */
    public void mo3483a(int i) {
        if (i != 0) {
            Drawable c = C0383a.m323c(this.f1468a.getContext(), i);
            if (c != null) {
                C0621q.m1808b(c);
            }
            this.f1468a.setImageDrawable(c);
        } else {
            this.f1468a.setImageDrawable((Drawable) null);
        }
        mo3482a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3484a(ColorStateList colorStateList) {
        if (this.f1470c == null) {
            this.f1470c = new C0593e0();
        }
        C0593e0 e0Var = this.f1470c;
        e0Var.f1423a = colorStateList;
        e0Var.f1426d = true;
        mo3482a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3485a(PorterDuff.Mode mode) {
        if (this.f1470c == null) {
            this.f1470c = new C0593e0();
        }
        C0593e0 e0Var = this.f1470c;
        e0Var.f1424b = mode;
        e0Var.f1425c = true;
        mo3482a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3482a() {
        Drawable drawable = this.f1468a.getDrawable();
        if (drawable != null) {
            C0621q.m1808b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!m1670e() || !m1669a(drawable)) {
            C0593e0 e0Var = this.f1470c;
            if (e0Var != null) {
                C0596g.m1589a(drawable, e0Var, this.f1468a.getDrawableState());
                return;
            }
            C0593e0 e0Var2 = this.f1469b;
            if (e0Var2 != null) {
                C0596g.m1589a(drawable, e0Var2, this.f1468a.getDrawableState());
            }
        }
    }

    /* renamed from: a */
    private boolean m1669a(Drawable drawable) {
        if (this.f1471d == null) {
            this.f1471d = new C0593e0();
        }
        C0593e0 e0Var = this.f1471d;
        e0Var.mo3413a();
        ColorStateList a = C0875e.m2924a(this.f1468a);
        if (a != null) {
            e0Var.f1426d = true;
            e0Var.f1423a = a;
        }
        PorterDuff.Mode b = C0875e.m2927b(this.f1468a);
        if (b != null) {
            e0Var.f1425c = true;
            e0Var.f1424b = b;
        }
        if (!e0Var.f1426d && !e0Var.f1425c) {
            return false;
        }
        C0596g.m1589a(drawable, e0Var, this.f1468a.getDrawableState());
        return true;
    }
}
