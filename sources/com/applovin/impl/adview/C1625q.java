package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.impl.adview.C1563h;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.applovin.impl.adview.q */
public final class C1625q extends C1563h {

    /* renamed from: c */
    private static final Paint f5062c = new Paint(1);

    /* renamed from: d */
    private static final Paint f5063d = new Paint(1);

    public C1625q(Context context) {
        super(context);
        f5062c.setARGB(80, 0, 0, 0);
        f5063d.setColor(-1);
        f5063d.setStyle(Paint.Style.STROKE);
    }

    /* renamed from: a */
    public void mo7436a(int i) {
        setViewScale(((float) i) / 30.0f);
    }

    /* access modifiers changed from: protected */
    public float getCenter() {
        return getSize() / 2.0f;
    }

    /* access modifiers changed from: protected */
    public float getCrossOffset() {
        return this.f4910a * 8.0f;
    }

    /* access modifiers changed from: protected */
    public float getStrokeWidth() {
        return this.f4910a * 2.0f;
    }

    public C1563h.C1564a getStyle() {
        return C1563h.C1564a.WHITE_ON_TRANSPARENT;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f5062c);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        f5063d.setStrokeWidth(getStrokeWidth());
        Canvas canvas2 = canvas;
        float f = crossOffset;
        float f2 = size;
        canvas2.drawLine(f, crossOffset, f2, size, f5063d);
        canvas2.drawLine(f, size, f2, crossOffset, f5063d);
    }
}
