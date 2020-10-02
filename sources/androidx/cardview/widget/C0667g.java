package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R$color;
import androidx.cardview.R$dimen;

/* renamed from: androidx.cardview.widget.g */
/* compiled from: RoundRectDrawableWithShadow */
class C0667g extends Drawable {

    /* renamed from: q */
    private static final double f1659q = Math.cos(Math.toRadians(45.0d));

    /* renamed from: r */
    static C0668a f1660r;

    /* renamed from: a */
    private final int f1661a;

    /* renamed from: b */
    private Paint f1662b;

    /* renamed from: c */
    private Paint f1663c;

    /* renamed from: d */
    private Paint f1664d;

    /* renamed from: e */
    private final RectF f1665e;

    /* renamed from: f */
    private float f1666f;

    /* renamed from: g */
    private Path f1667g;

    /* renamed from: h */
    private float f1668h;

    /* renamed from: i */
    private float f1669i;

    /* renamed from: j */
    private float f1670j;

    /* renamed from: k */
    private ColorStateList f1671k;

    /* renamed from: l */
    private boolean f1672l = true;

    /* renamed from: m */
    private final int f1673m;

    /* renamed from: n */
    private final int f1674n;

    /* renamed from: o */
    private boolean f1675o = true;

    /* renamed from: p */
    private boolean f1676p = false;

    /* renamed from: androidx.cardview.widget.g$a */
    /* compiled from: RoundRectDrawableWithShadow */
    interface C0668a {
        /* renamed from: a */
        void mo3683a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    C0667g(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.f1673m = resources.getColor(R$color.cardview_shadow_start_color);
        this.f1674n = resources.getColor(R$color.cardview_shadow_end_color);
        this.f1661a = resources.getDimensionPixelSize(R$dimen.cardview_compat_inset_shadow);
        this.f1662b = new Paint(5);
        m1979a(colorStateList);
        Paint paint = new Paint(5);
        this.f1663c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f1666f = (float) ((int) (f + 0.5f));
        this.f1665e = new RectF();
        Paint paint2 = new Paint(this.f1663c);
        this.f1664d = paint2;
        paint2.setAntiAlias(false);
        m1978a(f2, f3);
    }

    /* renamed from: a */
    private void m1979a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1671k = colorStateList;
        this.f1662b.setColor(colorStateList.getColorForState(getState(), this.f1671k.getDefaultColor()));
    }

    /* renamed from: b */
    static float m1981b(float f, float f2, boolean z) {
        if (!z) {
            return f * 1.5f;
        }
        double d = (double) (f * 1.5f);
        double d2 = (double) f2;
        Double.isNaN(d2);
        Double.isNaN(d);
        return (float) (d + ((1.0d - f1659q) * d2));
    }

    /* renamed from: c */
    private int m1983c(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    public void draw(Canvas canvas) {
        if (this.f1672l) {
            m1982b(getBounds());
            this.f1672l = false;
        }
        canvas.translate(0.0f, this.f1670j / 2.0f);
        m1980a(canvas);
        canvas.translate(0.0f, (-this.f1670j) / 2.0f);
        f1660r.mo3683a(canvas, this.f1665e, this.f1666f, this.f1662b);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m1981b(this.f1668h, this.f1666f, this.f1675o));
        int ceil2 = (int) Math.ceil((double) m1977a(this.f1668h, this.f1666f, this.f1675o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f1671k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1672l = true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f1671k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1662b.getColor() == colorForState) {
            return false;
        }
        this.f1662b.setColor(colorForState);
        this.f1672l = true;
        invalidateSelf();
        return true;
    }

    public void setAlpha(int i) {
        this.f1662b.setAlpha(i);
        this.f1663c.setAlpha(i);
        this.f1664d.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1662b.setColorFilter(colorFilter);
    }

    /* renamed from: b */
    private void m1982b(Rect rect) {
        float f = this.f1668h;
        float f2 = 1.5f * f;
        this.f1665e.set(((float) rect.left) + f, ((float) rect.top) + f2, ((float) rect.right) - f, ((float) rect.bottom) - f2);
        m1984c();
    }

    /* renamed from: c */
    private void m1984c() {
        float f = this.f1666f;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.f1669i;
        rectF2.inset(-f2, -f2);
        Path path = this.f1667g;
        if (path == null) {
            this.f1667g = new Path();
        } else {
            path.reset();
        }
        this.f1667g.setFillType(Path.FillType.EVEN_ODD);
        this.f1667g.moveTo(-this.f1666f, 0.0f);
        this.f1667g.rLineTo(-this.f1669i, 0.0f);
        this.f1667g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1667g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1667g.close();
        float f3 = this.f1666f;
        float f4 = f3 / (this.f1669i + f3);
        Paint paint = this.f1663c;
        float f5 = this.f1666f + this.f1669i;
        int i = this.f1673m;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f5, new int[]{i, i, this.f1674n}, new float[]{0.0f, f4, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f1664d;
        float f6 = this.f1666f;
        float f7 = this.f1669i;
        int i2 = this.f1673m;
        paint2.setShader(new LinearGradient(0.0f, (-f6) + f7, 0.0f, (-f6) - f7, new int[]{i2, i2, this.f1674n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f1664d.setAntiAlias(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3712a(boolean z) {
        this.f1675o = z;
        invalidateSelf();
    }

    /* renamed from: a */
    private void m1978a(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 >= 0.0f) {
            float c = (float) m1983c(f);
            float c2 = (float) m1983c(f2);
            if (c > c2) {
                if (!this.f1676p) {
                    this.f1676p = true;
                }
                c = c2;
            }
            if (this.f1670j != c || this.f1668h != c2) {
                this.f1670j = c;
                this.f1668h = c2;
                this.f1669i = (float) ((int) ((c * 1.5f) + ((float) this.f1661a) + 0.5f));
                this.f1672l = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3714b(float f) {
        m1978a(f, this.f1668h);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float mo3713b() {
        float f = this.f1668h;
        return (Math.max(f, this.f1666f + ((float) this.f1661a) + (f / 2.0f)) * 2.0f) + ((this.f1668h + ((float) this.f1661a)) * 2.0f);
    }

    /* renamed from: a */
    static float m1977a(float f, float f2, boolean z) {
        if (!z) {
            return f;
        }
        double d = (double) f;
        double d2 = (double) f2;
        Double.isNaN(d2);
        Double.isNaN(d);
        return (float) (d + ((1.0d - f1659q) * d2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3710a(float f) {
        if (f >= 0.0f) {
            float f2 = (float) ((int) (f + 0.5f));
            if (this.f1666f != f2) {
                this.f1666f = f2;
                this.f1672l = true;
                invalidateSelf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
    }

    /* renamed from: a */
    private void m1980a(Canvas canvas) {
        float f = this.f1666f;
        float f2 = (-f) - this.f1669i;
        float f3 = f + ((float) this.f1661a) + (this.f1670j / 2.0f);
        float f4 = f3 * 2.0f;
        boolean z = this.f1665e.width() - f4 > 0.0f;
        boolean z2 = this.f1665e.height() - f4 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.f1665e;
        canvas.translate(rectF.left + f3, rectF.top + f3);
        canvas.drawPath(this.f1667g, this.f1663c);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f1665e.width() - f4, -this.f1666f, this.f1664d);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.f1665e;
        canvas.translate(rectF2.right - f3, rectF2.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1667g, this.f1663c);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f1665e.width() - f4, (-this.f1666f) + this.f1669i, this.f1664d);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.f1665e;
        canvas.translate(rectF3.left + f3, rectF3.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1667g, this.f1663c);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f1665e.height() - f4, -this.f1666f, this.f1664d);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.f1665e;
        canvas.translate(rectF4.right - f3, rectF4.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1667g, this.f1663c);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f1665e.height() - f4, -this.f1666f, this.f1664d);
        }
        canvas.restoreToCount(save4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3711a(Rect rect) {
        getPadding(rect);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo3709a() {
        float f = this.f1668h;
        return (Math.max(f, this.f1666f + ((float) this.f1661a) + ((f * 1.5f) / 2.0f)) * 2.0f) + (((this.f1668h * 1.5f) + ((float) this.f1661a)) * 2.0f);
    }
}
