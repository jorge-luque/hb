package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/* renamed from: com.tapjoy.internal.in */
public final class C5201in extends View {

    /* renamed from: a */
    public boolean f14273a = false;

    /* renamed from: b */
    private Bitmap f14274b = null;

    /* renamed from: c */
    private Rect f14275c = null;

    /* renamed from: d */
    private Rect f14276d = null;

    /* renamed from: e */
    private Rect f14277e = null;

    /* renamed from: f */
    private Rect f14278f = new Rect();

    public C5201in(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo31375a() {
        if (this.f14273a) {
            this.f14277e = this.f14275c;
        } else {
            this.f14277e = this.f14276d;
        }
    }

    public final void onDraw(Canvas canvas) {
        if (this.f14277e != null && this.f14274b != null) {
            getDrawingRect(this.f14278f);
            canvas.drawBitmap(this.f14274b, this.f14277e, this.f14278f, (Paint) null);
        }
    }

    public final void setImageBitmap(Bitmap bitmap) {
        this.f14274b = bitmap;
        int width = bitmap.getWidth();
        int height = this.f14274b.getHeight();
        int i = width / 2;
        this.f14276d = new Rect(0, 0, i, height);
        this.f14275c = new Rect(i, 0, width, height);
        mo31375a();
    }
}
