package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.webkit.WebView;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.applovin.impl.adview.g */
public class C1562g extends WebView {

    /* renamed from: a */
    private PointF f4909a = new PointF();

    public C1562g(Context context) {
        super(context);
    }

    public PointF getAndClearLastClickLocation() {
        PointF pointF = this.f4909a;
        this.f4909a = new PointF();
        return pointF;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f4909a = new PointF(motionEvent.getRawX(), motionEvent.getRawY());
        return super.onTouchEvent(motionEvent);
    }
}
