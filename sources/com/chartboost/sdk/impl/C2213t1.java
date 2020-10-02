package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* renamed from: com.chartboost.sdk.impl.t1 */
public abstract class C2213t1 extends View {

    /* renamed from: a */
    private Bitmap f7461a = null;

    /* renamed from: b */
    private Canvas f7462b = null;

    public C2213t1(Context context) {
        super(context);
        m8775a(context);
    }

    /* renamed from: a */
    private void m8775a(Context context) {
        try {
            Class<?> cls = getClass();
            cls.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{1, null});
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    private boolean m8776b(Canvas canvas) {
        try {
            return ((Boolean) Canvas.class.getMethod("isHardwareAccelerated", new Class[0]).invoke(canvas, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo9386a(Canvas canvas);

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.f7461a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f7461a.recycle();
        }
        this.f7461a = null;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        Canvas canvas2;
        boolean b = m8776b(canvas);
        if (b) {
            Bitmap bitmap = this.f7461a;
            if (!(bitmap != null && bitmap.getWidth() == canvas.getWidth() && this.f7461a.getHeight() == canvas.getHeight())) {
                Bitmap bitmap2 = this.f7461a;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    this.f7461a.recycle();
                }
                try {
                    this.f7461a = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
                    this.f7462b = new Canvas(this.f7461a);
                } catch (Throwable unused) {
                    return;
                }
            }
            this.f7461a.eraseColor(0);
            canvas2 = canvas;
            canvas = this.f7462b;
        } else {
            canvas2 = null;
        }
        mo9386a(canvas);
        if (b) {
            canvas2.drawBitmap(this.f7461a, 0.0f, 0.0f, (Paint) null);
        }
    }
}
