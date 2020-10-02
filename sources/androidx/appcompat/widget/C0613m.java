package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.content.p017c.C0780f;
import androidx.core.widget.C0872b;
import androidx.core.widget.C0879i;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* renamed from: androidx.appcompat.widget.m */
/* compiled from: AppCompatTextHelper */
class C0613m {

    /* renamed from: a */
    private final TextView f1505a;

    /* renamed from: b */
    private C0593e0 f1506b;

    /* renamed from: c */
    private C0593e0 f1507c;

    /* renamed from: d */
    private C0593e0 f1508d;

    /* renamed from: e */
    private C0593e0 f1509e;

    /* renamed from: f */
    private C0593e0 f1510f;

    /* renamed from: g */
    private C0593e0 f1511g;

    /* renamed from: h */
    private C0593e0 f1512h;

    /* renamed from: i */
    private final C0617n f1513i;

    /* renamed from: j */
    private int f1514j = 0;

    /* renamed from: k */
    private int f1515k = -1;

    /* renamed from: l */
    private Typeface f1516l;

    /* renamed from: m */
    private boolean f1517m;

    /* renamed from: androidx.appcompat.widget.m$a */
    /* compiled from: AppCompatTextHelper */
    private static class C0614a extends C0780f.C0781a {

        /* renamed from: a */
        private final WeakReference<C0613m> f1518a;

        /* renamed from: b */
        private final int f1519b;

        /* renamed from: c */
        private final int f1520c;

        /* renamed from: androidx.appcompat.widget.m$a$a */
        /* compiled from: AppCompatTextHelper */
        private class C0615a implements Runnable {

            /* renamed from: a */
            private final WeakReference<C0613m> f1521a;

            /* renamed from: b */
            private final Typeface f1522b;

            C0615a(C0614a aVar, WeakReference<C0613m> weakReference, Typeface typeface) {
                this.f1521a = weakReference;
                this.f1522b = typeface;
            }

            public void run() {
                C0613m mVar = (C0613m) this.f1521a.get();
                if (mVar != null) {
                    mVar.mo3518a(this.f1522b);
                }
            }
        }

        C0614a(C0613m mVar, int i, int i2) {
            this.f1518a = new WeakReference<>(mVar);
            this.f1519b = i;
            this.f1520c = i2;
        }

        /* renamed from: a */
        public void mo3532a(int i) {
        }

        /* renamed from: a */
        public void mo3533a(Typeface typeface) {
            int i;
            C0613m mVar = (C0613m) this.f1518a.get();
            if (mVar != null) {
                if (Build.VERSION.SDK_INT >= 28 && (i = this.f1519b) != -1) {
                    typeface = Typeface.create(typeface, i, (this.f1520c & 2) != 0);
                }
                mVar.mo3520a((Runnable) new C0615a(this, this.f1518a, typeface));
            }
        }
    }

    C0613m(TextView textView) {
        this.f1505a = textView;
        this.f1513i = new C0617n(this.f1505a);
    }

    /* renamed from: j */
    private void m1714j() {
        C0593e0 e0Var = this.f1512h;
        this.f1506b = e0Var;
        this.f1507c = e0Var;
        this.f1508d = e0Var;
        this.f1509e = e0Var;
        this.f1510f = e0Var;
        this.f1511g = e0Var;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo3519a(AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        boolean z;
        boolean z2;
        ColorStateList colorStateList2;
        String str;
        ColorStateList colorStateList3;
        String str2;
        C0596g gVar;
        int i2;
        AttributeSet attributeSet2 = attributeSet;
        int i3 = i;
        Context context = this.f1505a.getContext();
        C0596g b = C0596g.m1590b();
        C0598g0 a = C0598g0.m1610a(context, attributeSet2, R$styleable.AppCompatTextHelper, i3, 0);
        int g = a.mo3446g(R$styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (a.mo3447g(R$styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.f1506b = m1709a(context, b, a.mo3446g(R$styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a.mo3447g(R$styleable.AppCompatTextHelper_android_drawableTop)) {
            this.f1507c = m1709a(context, b, a.mo3446g(R$styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a.mo3447g(R$styleable.AppCompatTextHelper_android_drawableRight)) {
            this.f1508d = m1709a(context, b, a.mo3446g(R$styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a.mo3447g(R$styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.f1509e = m1709a(context, b, a.mo3446g(R$styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (a.mo3447g(R$styleable.AppCompatTextHelper_android_drawableStart)) {
                this.f1510f = m1709a(context, b, a.mo3446g(R$styleable.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (a.mo3447g(R$styleable.AppCompatTextHelper_android_drawableEnd)) {
                this.f1511g = m1709a(context, b, a.mo3446g(R$styleable.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        a.mo3434a();
        boolean z3 = this.f1505a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (g != -1) {
            C0598g0 a2 = C0598g0.m1608a(context, g, R$styleable.TextAppearance);
            if (z3 || !a2.mo3447g(R$styleable.TextAppearance_textAllCaps)) {
                z2 = false;
                z = false;
            } else {
                z2 = a2.mo3435a(R$styleable.TextAppearance_textAllCaps, false);
                z = true;
            }
            m1710a(context, a2);
            if (Build.VERSION.SDK_INT < 23) {
                colorStateList = a2.mo3447g(R$styleable.TextAppearance_android_textColor) ? a2.mo3432a(R$styleable.TextAppearance_android_textColor) : null;
                colorStateList3 = a2.mo3447g(R$styleable.TextAppearance_android_textColorHint) ? a2.mo3432a(R$styleable.TextAppearance_android_textColorHint) : null;
                colorStateList2 = a2.mo3447g(R$styleable.TextAppearance_android_textColorLink) ? a2.mo3432a(R$styleable.TextAppearance_android_textColorLink) : null;
            } else {
                colorStateList3 = null;
                colorStateList2 = null;
                colorStateList = null;
            }
            str2 = a2.mo3447g(R$styleable.TextAppearance_textLocale) ? a2.mo3441d(R$styleable.TextAppearance_textLocale) : null;
            str = (Build.VERSION.SDK_INT < 26 || !a2.mo3447g(R$styleable.TextAppearance_fontVariationSettings)) ? null : a2.mo3441d(R$styleable.TextAppearance_fontVariationSettings);
            a2.mo3434a();
        } else {
            str2 = null;
            colorStateList3 = null;
            str = null;
            colorStateList2 = null;
            z2 = false;
            z = false;
            colorStateList = null;
        }
        C0598g0 a3 = C0598g0.m1610a(context, attributeSet2, R$styleable.TextAppearance, i3, 0);
        if (!z3 && a3.mo3447g(R$styleable.TextAppearance_textAllCaps)) {
            z2 = a3.mo3435a(R$styleable.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (a3.mo3447g(R$styleable.TextAppearance_android_textColor)) {
                colorStateList = a3.mo3432a(R$styleable.TextAppearance_android_textColor);
            }
            if (a3.mo3447g(R$styleable.TextAppearance_android_textColorHint)) {
                colorStateList3 = a3.mo3432a(R$styleable.TextAppearance_android_textColorHint);
            }
            if (a3.mo3447g(R$styleable.TextAppearance_android_textColorLink)) {
                colorStateList2 = a3.mo3432a(R$styleable.TextAppearance_android_textColorLink);
            }
        }
        if (a3.mo3447g(R$styleable.TextAppearance_textLocale)) {
            str2 = a3.mo3441d(R$styleable.TextAppearance_textLocale);
        }
        if (Build.VERSION.SDK_INT >= 26 && a3.mo3447g(R$styleable.TextAppearance_fontVariationSettings)) {
            str = a3.mo3441d(R$styleable.TextAppearance_fontVariationSettings);
        }
        if (Build.VERSION.SDK_INT < 28 || !a3.mo3447g(R$styleable.TextAppearance_android_textSize) || a3.mo3438c(R$styleable.TextAppearance_android_textSize, -1) != 0) {
            gVar = b;
        } else {
            gVar = b;
            this.f1505a.setTextSize(0, 0.0f);
        }
        m1710a(context, a3);
        a3.mo3434a();
        if (colorStateList != null) {
            this.f1505a.setTextColor(colorStateList);
        }
        if (colorStateList3 != null) {
            this.f1505a.setHintTextColor(colorStateList3);
        }
        if (colorStateList2 != null) {
            this.f1505a.setLinkTextColor(colorStateList2);
        }
        if (!z3 && z) {
            mo3521a(z2);
        }
        Typeface typeface = this.f1516l;
        if (typeface != null) {
            if (this.f1515k == -1) {
                this.f1505a.setTypeface(typeface, this.f1514j);
            } else {
                this.f1505a.setTypeface(typeface);
            }
        }
        if (str != null) {
            this.f1505a.setFontVariationSettings(str);
        }
        if (str2 != null) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 24) {
                this.f1505a.setTextLocales(LocaleList.forLanguageTags(str2));
            } else if (i4 >= 21) {
                this.f1505a.setTextLocale(Locale.forLanguageTag(str2.substring(0, str2.indexOf(44))));
            }
        }
        this.f1513i.mo3540a(attributeSet2, i3);
        if (C0872b.f2160T && this.f1513i.mo3547f() != 0) {
            int[] e = this.f1513i.mo3546e();
            if (e.length > 0) {
                if (((float) this.f1505a.getAutoSizeStepGranularity()) != -1.0f) {
                    this.f1505a.setAutoSizeTextTypeUniformWithConfiguration(this.f1513i.mo3544c(), this.f1513i.mo3542b(), this.f1513i.mo3545d(), 0);
                } else {
                    this.f1505a.setAutoSizeTextTypeUniformWithPresetSizes(e, 0);
                }
            }
        }
        C0598g0 a4 = C0598g0.m1609a(context, attributeSet2, R$styleable.AppCompatTextView);
        int g2 = a4.mo3446g(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
        C0596g gVar2 = gVar;
        Drawable a5 = g2 != -1 ? gVar2.mo3421a(context, g2) : null;
        int g3 = a4.mo3446g(R$styleable.AppCompatTextView_drawableTopCompat, -1);
        Drawable a6 = g3 != -1 ? gVar2.mo3421a(context, g3) : null;
        int g4 = a4.mo3446g(R$styleable.AppCompatTextView_drawableRightCompat, -1);
        Drawable a7 = g4 != -1 ? gVar2.mo3421a(context, g4) : null;
        int g5 = a4.mo3446g(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
        Drawable a8 = g5 != -1 ? gVar2.mo3421a(context, g5) : null;
        int g6 = a4.mo3446g(R$styleable.AppCompatTextView_drawableStartCompat, -1);
        Drawable a9 = g6 != -1 ? gVar2.mo3421a(context, g6) : null;
        int g7 = a4.mo3446g(R$styleable.AppCompatTextView_drawableEndCompat, -1);
        m1711a(a5, a6, a7, a8, a9, g7 != -1 ? gVar2.mo3421a(context, g7) : null);
        if (a4.mo3447g(R$styleable.AppCompatTextView_drawableTint)) {
            C0879i.m2938a(this.f1505a, a4.mo3432a(R$styleable.AppCompatTextView_drawableTint));
        }
        if (a4.mo3447g(R$styleable.AppCompatTextView_drawableTintMode)) {
            i2 = -1;
            C0879i.m2939a(this.f1505a, C0621q.m1806a(a4.mo3440d(R$styleable.AppCompatTextView_drawableTintMode, -1), (PorterDuff.Mode) null));
        } else {
            i2 = -1;
        }
        int c = a4.mo3438c(R$styleable.AppCompatTextView_firstBaselineToTopHeight, i2);
        int c2 = a4.mo3438c(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, i2);
        int c3 = a4.mo3438c(R$styleable.AppCompatTextView_lineHeight, i2);
        a4.mo3434a();
        if (c != i2) {
            C0879i.m2937a(this.f1505a, c);
        }
        if (c2 != i2) {
            C0879i.m2942b(this.f1505a, c2);
        }
        if (c3 != i2) {
            C0879i.m2944c(this.f1505a, c3);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3524b() {
        this.f1513i.mo3536a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo3525c() {
        return this.f1513i.mo3542b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo3526d() {
        return this.f1513i.mo3544c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo3527e() {
        return this.f1513i.mo3545d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int[] mo3528f() {
        return this.f1513i.mo3546e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public int mo3529g() {
        return this.f1513i.mo3547f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo3530h() {
        return this.f1513i.mo3548g();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo3531i() {
        mo3511a();
    }

    /* renamed from: b */
    private void m1713b(int i, float f) {
        this.f1513i.mo3538a(i, f);
    }

    /* renamed from: a */
    public void mo3518a(Typeface typeface) {
        if (this.f1517m) {
            this.f1505a.setTypeface(typeface);
            this.f1516l = typeface;
        }
    }

    /* renamed from: a */
    public void mo3520a(Runnable runnable) {
        this.f1505a.post(runnable);
    }

    /* renamed from: a */
    private void m1710a(Context context, C0598g0 g0Var) {
        String d;
        this.f1514j = g0Var.mo3440d(R$styleable.TextAppearance_android_textStyle, this.f1514j);
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 28) {
            int d2 = g0Var.mo3440d(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.f1515k = d2;
            if (d2 != -1) {
                this.f1514j = (this.f1514j & 2) | 0;
            }
        }
        if (g0Var.mo3447g(R$styleable.TextAppearance_android_fontFamily) || g0Var.mo3447g(R$styleable.TextAppearance_fontFamily)) {
            this.f1516l = null;
            int i = g0Var.mo3447g(R$styleable.TextAppearance_fontFamily) ? R$styleable.TextAppearance_fontFamily : R$styleable.TextAppearance_android_fontFamily;
            int i2 = this.f1515k;
            int i3 = this.f1514j;
            if (!context.isRestricted()) {
                try {
                    Typeface a = g0Var.mo3433a(i, this.f1514j, (C0780f.C0781a) new C0614a(this, i2, i3));
                    if (a != null) {
                        if (Build.VERSION.SDK_INT < 28 || this.f1515k == -1) {
                            this.f1516l = a;
                        } else {
                            this.f1516l = Typeface.create(Typeface.create(a, 0), this.f1515k, (this.f1514j & 2) != 0);
                        }
                    }
                    this.f1517m = this.f1516l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f1516l == null && (d = g0Var.mo3441d(i)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.f1515k == -1) {
                    this.f1516l = Typeface.create(d, this.f1514j);
                    return;
                }
                Typeface create = Typeface.create(d, 0);
                int i4 = this.f1515k;
                if ((this.f1514j & 2) != 0) {
                    z = true;
                }
                this.f1516l = Typeface.create(create, i4, z);
            }
        } else if (g0Var.mo3447g(R$styleable.TextAppearance_android_typeface)) {
            this.f1517m = false;
            int d3 = g0Var.mo3440d(R$styleable.TextAppearance_android_typeface, 1);
            if (d3 == 1) {
                this.f1516l = Typeface.SANS_SERIF;
            } else if (d3 == 2) {
                this.f1516l = Typeface.SERIF;
            } else if (d3 == 3) {
                this.f1516l = Typeface.MONOSPACE;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3515a(Context context, int i) {
        String d;
        ColorStateList a;
        C0598g0 a2 = C0598g0.m1608a(context, i, R$styleable.TextAppearance);
        if (a2.mo3447g(R$styleable.TextAppearance_textAllCaps)) {
            mo3521a(a2.mo3435a(R$styleable.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a2.mo3447g(R$styleable.TextAppearance_android_textColor) && (a = a2.mo3432a(R$styleable.TextAppearance_android_textColor)) != null) {
            this.f1505a.setTextColor(a);
        }
        if (a2.mo3447g(R$styleable.TextAppearance_android_textSize) && a2.mo3438c(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f1505a.setTextSize(0, 0.0f);
        }
        m1710a(context, a2);
        if (Build.VERSION.SDK_INT >= 26 && a2.mo3447g(R$styleable.TextAppearance_fontVariationSettings) && (d = a2.mo3441d(R$styleable.TextAppearance_fontVariationSettings)) != null) {
            this.f1505a.setFontVariationSettings(d);
        }
        a2.mo3434a();
        Typeface typeface = this.f1516l;
        if (typeface != null) {
            this.f1505a.setTypeface(typeface, this.f1514j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3521a(boolean z) {
        this.f1505a.setAllCaps(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3511a() {
        if (!(this.f1506b == null && this.f1507c == null && this.f1508d == null && this.f1509e == null)) {
            Drawable[] compoundDrawables = this.f1505a.getCompoundDrawables();
            m1712a(compoundDrawables[0], this.f1506b);
            m1712a(compoundDrawables[1], this.f1507c);
            m1712a(compoundDrawables[2], this.f1508d);
            m1712a(compoundDrawables[3], this.f1509e);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return;
        }
        if (this.f1510f != null || this.f1511g != null) {
            Drawable[] compoundDrawablesRelative = this.f1505a.getCompoundDrawablesRelative();
            m1712a(compoundDrawablesRelative[0], this.f1510f);
            m1712a(compoundDrawablesRelative[2], this.f1511g);
        }
    }

    /* renamed from: a */
    private void m1712a(Drawable drawable, C0593e0 e0Var) {
        if (drawable != null && e0Var != null) {
            C0596g.m1589a(drawable, e0Var, this.f1505a.getDrawableState());
        }
    }

    /* renamed from: a */
    private static C0593e0 m1709a(Context context, C0596g gVar, int i) {
        ColorStateList b = gVar.mo3424b(context, i);
        if (b == null) {
            return null;
        }
        C0593e0 e0Var = new C0593e0();
        e0Var.f1426d = true;
        e0Var.f1423a = b;
        return e0Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3522a(boolean z, int i, int i2, int i3, int i4) {
        if (!C0872b.f2160T) {
            mo3524b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3513a(int i, float f) {
        if (!C0872b.f2160T && !mo3530h()) {
            m1713b(i, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3512a(int i) {
        this.f1513i.mo3543b(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3514a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        this.f1513i.mo3539a(i, i2, i3, i4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3523a(int[] iArr, int i) throws IllegalArgumentException {
        this.f1513i.mo3541a(iArr, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3516a(ColorStateList colorStateList) {
        if (this.f1512h == null) {
            this.f1512h = new C0593e0();
        }
        C0593e0 e0Var = this.f1512h;
        e0Var.f1423a = colorStateList;
        e0Var.f1426d = colorStateList != null;
        m1714j();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3517a(PorterDuff.Mode mode) {
        if (this.f1512h == null) {
            this.f1512h = new C0593e0();
        }
        C0593e0 e0Var = this.f1512h;
        e0Var.f1424b = mode;
        e0Var.f1425c = mode != null;
        m1714j();
    }

    /* renamed from: a */
    private void m1711a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f1505a.getCompoundDrawablesRelative();
            TextView textView = this.f1505a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                Drawable[] compoundDrawablesRelative2 = this.f1505a.getCompoundDrawablesRelative();
                if (!(compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null)) {
                    TextView textView2 = this.f1505a;
                    Drawable drawable7 = compoundDrawablesRelative2[0];
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative2[1];
                    }
                    Drawable drawable8 = compoundDrawablesRelative2[2];
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative2[3];
                    }
                    textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                    return;
                }
            }
            Drawable[] compoundDrawables = this.f1505a.getCompoundDrawables();
            TextView textView3 = this.f1505a;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }
}
