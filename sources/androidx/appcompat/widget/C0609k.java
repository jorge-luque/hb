package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.drawable.C0857a;
import androidx.core.p020f.C0839t;

/* renamed from: androidx.appcompat.widget.k */
/* compiled from: AppCompatSeekBarHelper */
class C0609k extends C0605j {

    /* renamed from: d */
    private final SeekBar f1488d;

    /* renamed from: e */
    private Drawable f1489e;

    /* renamed from: f */
    private ColorStateList f1490f = null;

    /* renamed from: g */
    private PorterDuff.Mode f1491g = null;

    /* renamed from: h */
    private boolean f1492h = false;

    /* renamed from: i */
    private boolean f1493i = false;

    C0609k(SeekBar seekBar) {
        super(seekBar);
        this.f1488d = seekBar;
    }

    /* renamed from: d */
    private void m1693d() {
        if (this.f1489e == null) {
            return;
        }
        if (this.f1492h || this.f1493i) {
            Drawable h = C0857a.m2818h(this.f1489e.mutate());
            this.f1489e = h;
            if (this.f1492h) {
                C0857a.m2804a(h, this.f1490f);
            }
            if (this.f1493i) {
                C0857a.m2807a(this.f1489e, this.f1491g);
            }
            if (this.f1489e.isStateful()) {
                this.f1489e.setState(this.f1488d.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3491a(AttributeSet attributeSet, int i) {
        super.mo3491a(attributeSet, i);
        C0598g0 a = C0598g0.m1610a(this.f1488d.getContext(), attributeSet, R$styleable.AppCompatSeekBar, i, 0);
        Drawable c = a.mo3439c(R$styleable.AppCompatSeekBar_android_thumb);
        if (c != null) {
            this.f1488d.setThumb(c);
        }
        mo3501a(a.mo3437b(R$styleable.AppCompatSeekBar_tickMark));
        if (a.mo3447g(R$styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.f1491g = C0621q.m1806a(a.mo3440d(R$styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f1491g);
            this.f1493i = true;
        }
        if (a.mo3447g(R$styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f1490f = a.mo3432a(R$styleable.AppCompatSeekBar_tickMarkTint);
            this.f1492h = true;
        }
        a.mo3434a();
        m1693d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3502b() {
        Drawable drawable = this.f1489e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1488d.getDrawableState())) {
            this.f1488d.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo3503c() {
        Drawable drawable = this.f1489e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3501a(Drawable drawable) {
        Drawable drawable2 = this.f1489e;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1489e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1488d);
            C0857a.m2810a(drawable, C0839t.m2725n(this.f1488d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1488d.getDrawableState());
            }
            m1693d();
        }
        this.f1488d.invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3500a(Canvas canvas) {
        if (this.f1489e != null) {
            int max = this.f1488d.getMax();
            int i = 1;
            if (max > 1) {
                int intrinsicWidth = this.f1489e.getIntrinsicWidth();
                int intrinsicHeight = this.f1489e.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.f1489e.setBounds(-i2, -i, i2, i);
                float width = ((float) ((this.f1488d.getWidth() - this.f1488d.getPaddingLeft()) - this.f1488d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f1488d.getPaddingLeft(), (float) (this.f1488d.getHeight() / 2));
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f1489e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
