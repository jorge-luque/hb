package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: androidx.cardview.widget.f */
/* compiled from: RoundRectDrawable */
class C0666f extends Drawable {

    /* renamed from: a */
    private float f1648a;

    /* renamed from: b */
    private final Paint f1649b;

    /* renamed from: c */
    private final RectF f1650c;

    /* renamed from: d */
    private final Rect f1651d;

    /* renamed from: e */
    private float f1652e;

    /* renamed from: f */
    private boolean f1653f = false;

    /* renamed from: g */
    private boolean f1654g = true;

    /* renamed from: h */
    private ColorStateList f1655h;

    /* renamed from: i */
    private PorterDuffColorFilter f1656i;

    /* renamed from: j */
    private ColorStateList f1657j;

    /* renamed from: k */
    private PorterDuff.Mode f1658k = PorterDuff.Mode.SRC_IN;

    C0666f(ColorStateList colorStateList, float f) {
        this.f1648a = f;
        this.f1649b = new Paint(5);
        m1971a(colorStateList);
        this.f1650c = new RectF();
        this.f1651d = new Rect();
    }

    /* renamed from: a */
    private void m1971a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1655h = colorStateList;
        this.f1649b.setColor(colorStateList.getColorForState(getState(), this.f1655h.getDefaultColor()));
    }

    /* renamed from: b */
    public float mo3698b() {
        return this.f1648a;
    }

    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f1649b;
        if (this.f1656i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f1656i);
            z = true;
        }
        RectF rectF = this.f1650c;
        float f = this.f1648a;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z) {
            paint.setColorFilter((ColorFilter) null);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1651d, this.f1648a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f1655h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.f1657j
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001a
        L_0x000a:
            android.content.res.ColorStateList r0 = r1.f1655h
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001a
        L_0x0014:
            boolean r0 = super.isStateful()
            if (r0 == 0) goto L_0x001c
        L_0x001a:
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.cardview.widget.C0666f.isStateful():boolean");
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m1972a(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1655h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f1649b.getColor();
        if (z) {
            this.f1649b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1657j;
        if (colorStateList2 == null || (mode = this.f1658k) == null) {
            return z;
        }
        this.f1656i = m1970a(colorStateList2, mode);
        return true;
    }

    public void setAlpha(int i) {
        this.f1649b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1649b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1657j = colorStateList;
        this.f1656i = m1970a(colorStateList, this.f1658k);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f1658k = mode;
        this.f1656i = m1970a(this.f1657j, mode);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3697a(float f, boolean z, boolean z2) {
        if (f != this.f1652e || this.f1653f != z || this.f1654g != z2) {
            this.f1652e = f;
            this.f1653f = z;
            this.f1654g = z2;
            m1972a((Rect) null);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo3695a() {
        return this.f1652e;
    }

    /* renamed from: a */
    private void m1972a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1650c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f1651d.set(rect);
        if (this.f1653f) {
            float b = C0667g.m1981b(this.f1652e, this.f1648a, this.f1654g);
            this.f1651d.inset((int) Math.ceil((double) C0667g.m1977a(this.f1652e, this.f1648a, this.f1654g)), (int) Math.ceil((double) b));
            this.f1650c.set(this.f1651d);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3696a(float f) {
        if (f != this.f1648a) {
            this.f1648a = f;
            m1972a((Rect) null);
            invalidateSelf();
        }
    }

    /* renamed from: a */
    private PorterDuffColorFilter m1970a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
