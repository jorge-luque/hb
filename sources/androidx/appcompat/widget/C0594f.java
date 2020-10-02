package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.core.graphics.drawable.C0857a;
import androidx.core.widget.C0873c;

/* renamed from: androidx.appcompat.widget.f */
/* compiled from: AppCompatCompoundButtonHelper */
class C0594f {

    /* renamed from: a */
    private final CompoundButton f1427a;

    /* renamed from: b */
    private ColorStateList f1428b = null;

    /* renamed from: c */
    private PorterDuff.Mode f1429c = null;

    /* renamed from: d */
    private boolean f1430d = false;

    /* renamed from: e */
    private boolean f1431e = false;

    /* renamed from: f */
    private boolean f1432f;

    C0594f(CompoundButton compoundButton) {
        this.f1427a = compoundButton;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031 A[SYNTHETIC, Splitter:B:12:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b A[Catch:{ all -> 0x0080 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3418a(android.util.AttributeSet r4, int r5) {
        /*
            r3 = this;
            android.widget.CompoundButton r0 = r3.f1427a
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.R$styleable.CompoundButton
            r2 = 0
            android.content.res.TypedArray r4 = r0.obtainStyledAttributes(r4, r1, r5, r2)
            int r5 = androidx.appcompat.R$styleable.CompoundButton_buttonCompat     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.hasValue(r5)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x002e
            int r5 = androidx.appcompat.R$styleable.CompoundButton_buttonCompat     // Catch:{ all -> 0x0080 }
            int r5 = r4.getResourceId(r5, r2)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x002e
            android.widget.CompoundButton r0 = r3.f1427a     // Catch:{ NotFoundException -> 0x002e }
            android.widget.CompoundButton r1 = r3.f1427a     // Catch:{ NotFoundException -> 0x002e }
            android.content.Context r1 = r1.getContext()     // Catch:{ NotFoundException -> 0x002e }
            android.graphics.drawable.Drawable r5 = androidx.appcompat.p006a.p007a.C0383a.m323c(r1, r5)     // Catch:{ NotFoundException -> 0x002e }
            r0.setButtonDrawable(r5)     // Catch:{ NotFoundException -> 0x002e }
            r5 = 1
            goto L_0x002f
        L_0x002e:
            r5 = 0
        L_0x002f:
            if (r5 != 0) goto L_0x0050
            int r5 = androidx.appcompat.R$styleable.CompoundButton_android_button     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.hasValue(r5)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x0050
            int r5 = androidx.appcompat.R$styleable.CompoundButton_android_button     // Catch:{ all -> 0x0080 }
            int r5 = r4.getResourceId(r5, r2)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x0050
            android.widget.CompoundButton r0 = r3.f1427a     // Catch:{ all -> 0x0080 }
            android.widget.CompoundButton r1 = r3.f1427a     // Catch:{ all -> 0x0080 }
            android.content.Context r1 = r1.getContext()     // Catch:{ all -> 0x0080 }
            android.graphics.drawable.Drawable r5 = androidx.appcompat.p006a.p007a.C0383a.m323c(r1, r5)     // Catch:{ all -> 0x0080 }
            r0.setButtonDrawable(r5)     // Catch:{ all -> 0x0080 }
        L_0x0050:
            int r5 = androidx.appcompat.R$styleable.CompoundButton_buttonTint     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.hasValue(r5)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x0063
            android.widget.CompoundButton r5 = r3.f1427a     // Catch:{ all -> 0x0080 }
            int r0 = androidx.appcompat.R$styleable.CompoundButton_buttonTint     // Catch:{ all -> 0x0080 }
            android.content.res.ColorStateList r0 = r4.getColorStateList(r0)     // Catch:{ all -> 0x0080 }
            androidx.core.widget.C0873c.m2921a((android.widget.CompoundButton) r5, (android.content.res.ColorStateList) r0)     // Catch:{ all -> 0x0080 }
        L_0x0063:
            int r5 = androidx.appcompat.R$styleable.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.hasValue(r5)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x007c
            android.widget.CompoundButton r5 = r3.f1427a     // Catch:{ all -> 0x0080 }
            int r0 = androidx.appcompat.R$styleable.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0080 }
            r1 = -1
            int r0 = r4.getInt(r0, r1)     // Catch:{ all -> 0x0080 }
            r1 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.C0621q.m1806a(r0, r1)     // Catch:{ all -> 0x0080 }
            androidx.core.widget.C0873c.m2922a((android.widget.CompoundButton) r5, (android.graphics.PorterDuff.Mode) r0)     // Catch:{ all -> 0x0080 }
        L_0x007c:
            r4.recycle()
            return
        L_0x0080:
            r5 = move-exception
            r4.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0594f.mo3418a(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3419b() {
        if (this.f1432f) {
            this.f1432f = false;
            return;
        }
        this.f1432f = true;
        mo3415a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3416a(ColorStateList colorStateList) {
        this.f1428b = colorStateList;
        this.f1430d = true;
        mo3415a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3417a(PorterDuff.Mode mode) {
        this.f1429c = mode;
        this.f1431e = true;
        mo3415a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3415a() {
        Drawable a = C0873c.m2920a(this.f1427a);
        if (a == null) {
            return;
        }
        if (this.f1430d || this.f1431e) {
            Drawable mutate = C0857a.m2818h(a).mutate();
            if (this.f1430d) {
                C0857a.m2804a(mutate, this.f1428b);
            }
            if (this.f1431e) {
                C0857a.m2807a(mutate, this.f1429c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f1427a.getDrawableState());
            }
            this.f1427a.setButtonDrawable(mutate);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = androidx.core.widget.C0873c.m2920a(r2.f1427a);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo3414a(int r3) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 17
            if (r0 >= r1) goto L_0x0013
            android.widget.CompoundButton r0 = r2.f1427a
            android.graphics.drawable.Drawable r0 = androidx.core.widget.C0873c.m2920a(r0)
            if (r0 == 0) goto L_0x0013
            int r0 = r0.getIntrinsicWidth()
            int r3 = r3 + r0
        L_0x0013:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0594f.mo3414a(int):int");
    }
}
