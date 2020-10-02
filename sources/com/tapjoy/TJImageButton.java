package com.tapjoy;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class TJImageButton extends ImageButton {

    /* renamed from: a */
    private Bitmap f13055a;

    /* renamed from: b */
    private Bitmap f13056b;

    public TJImageButton(Context context) {
        super(context);
    }

    public void setDisableImageBitmap(Bitmap bitmap) {
        this.f13056b = bitmap;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setImageBitmap(z ? this.f13055a : this.f13056b);
    }

    public void setEnabledImageBitmap(Bitmap bitmap) {
        this.f13055a = bitmap;
    }

    public TJImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TJImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public TJImageButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
