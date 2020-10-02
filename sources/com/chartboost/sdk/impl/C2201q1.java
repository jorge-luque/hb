package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.C2080h;

/* renamed from: com.chartboost.sdk.impl.q1 */
public class C2201q1 extends ImageView {

    /* renamed from: a */
    private C2080h f7430a = null;

    /* renamed from: b */
    protected TextView f7431b = null;

    public C2201q1(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void mo9496a(C2080h hVar) {
        if (hVar != null && hVar.mo9104e() && this.f7430a != hVar) {
            this.f7430a = hVar;
            setImageDrawable(new BitmapDrawable(hVar.mo9101b()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mo9495a(canvas);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f7430a = null;
        setImageDrawable(new BitmapDrawable(bitmap));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9495a(Canvas canvas) {
        TextView textView = this.f7431b;
        if (textView != null) {
            textView.layout(0, 0, canvas.getWidth(), canvas.getHeight());
            this.f7431b.setEnabled(isEnabled());
            this.f7431b.setSelected(isSelected());
            if (isFocused()) {
                this.f7431b.requestFocus();
            } else {
                this.f7431b.clearFocus();
            }
            this.f7431b.setPressed(isPressed());
            this.f7431b.draw(canvas);
        }
    }
}
