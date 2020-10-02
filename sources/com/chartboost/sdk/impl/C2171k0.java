package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* renamed from: com.chartboost.sdk.impl.k0 */
public class C2171k0 extends C2213t1 {

    /* renamed from: c */
    private Paint f7308c;

    /* renamed from: d */
    private Paint f7309d;

    /* renamed from: e */
    private Path f7310e;

    /* renamed from: f */
    private RectF f7311f;

    /* renamed from: g */
    private RectF f7312g;

    /* renamed from: h */
    private int f7313h = 0;

    /* renamed from: i */
    private float f7314i;

    /* renamed from: j */
    private float f7315j;

    public C2171k0(Context context) {
        super(context);
        m8623a(context);
    }

    /* renamed from: a */
    private void m8623a(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        this.f7314i = 4.5f * f;
        Paint paint = new Paint();
        this.f7308c = paint;
        paint.setColor(-1);
        this.f7308c.setStyle(Paint.Style.STROKE);
        this.f7308c.setStrokeWidth(f * 1.0f);
        this.f7308c.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f7309d = paint2;
        paint2.setColor(-855638017);
        this.f7309d.setStyle(Paint.Style.FILL);
        this.f7309d.setAntiAlias(true);
        this.f7310e = new Path();
        this.f7312g = new RectF();
        this.f7311f = new RectF();
    }

    /* renamed from: b */
    public void mo9388b(int i) {
        this.f7308c.setColor(i);
        invalidate();
    }

    /* renamed from: c */
    public void mo9389c(int i) {
        this.f7309d.setColor(i);
        invalidate();
    }

    /* renamed from: b */
    public void mo9387b(float f) {
        this.f7314i = f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9386a(Canvas canvas) {
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f7311f.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        float min = (float) Math.min(1, Math.round(f * 0.5f));
        this.f7311f.inset(min, min);
        this.f7310e.reset();
        Path path = this.f7310e;
        RectF rectF = this.f7311f;
        float f2 = this.f7314i;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        canvas.save();
        canvas.clipPath(this.f7310e);
        canvas.drawColor(this.f7313h);
        this.f7312g.set(this.f7311f);
        RectF rectF2 = this.f7312g;
        float f3 = rectF2.right;
        float f4 = rectF2.left;
        rectF2.right = ((f3 - f4) * this.f7315j) + f4;
        canvas.drawRect(rectF2, this.f7309d);
        canvas.restore();
        RectF rectF3 = this.f7311f;
        float f5 = this.f7314i;
        canvas.drawRoundRect(rectF3, f5, f5, this.f7308c);
    }

    /* renamed from: a */
    public void mo9385a(int i) {
        this.f7313h = i;
        invalidate();
    }

    /* renamed from: a */
    public void mo9384a(float f) {
        this.f7315j = f;
        if (getVisibility() != 8) {
            invalidate();
        }
    }
}
