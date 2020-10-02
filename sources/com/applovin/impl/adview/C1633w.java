package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.impl.adview.C1563h;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.applovin.impl.adview.w */
public final class C1633w extends C1563h {

    /* renamed from: c */
    private static final Paint f5081c = new Paint(1);

    /* renamed from: d */
    private static final Paint f5082d = new Paint(1);

    /* renamed from: e */
    private static final Paint f5083e = new Paint(1);

    public C1633w(Context context) {
        super(context);
        f5081c.setColor(-1);
        f5082d.setColor(-16777216);
        f5083e.setColor(-1);
        f5083e.setStyle(Paint.Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public float getCenter() {
        return getSize() / 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getCrossOffset() {
        return this.f4910a * 10.0f;
    }

    /* access modifiers changed from: protected */
    public float getInnerCircleOffset() {
        return this.f4910a * 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getInnerCircleRadius() {
        return getCenter() - getInnerCircleOffset();
    }

    /* access modifiers changed from: protected */
    public float getStrokeWidth() {
        return this.f4910a * 3.0f;
    }

    public C1563h.C1564a getStyle() {
        return C1563h.C1564a.WHITE_ON_BLACK;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f5081c);
        canvas.drawCircle(center, center, getInnerCircleRadius(), f5082d);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        f5083e.setStrokeWidth(getStrokeWidth());
        Canvas canvas2 = canvas;
        float f = crossOffset;
        float f2 = size;
        canvas2.drawLine(f, crossOffset, f2, size, f5083e);
        canvas2.drawLine(f, size, f2, crossOffset, f5083e);
    }
}
