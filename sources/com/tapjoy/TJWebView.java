package com.tapjoy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.webkit.WebView;

public class TJWebView extends WebView {

    /* renamed from: com.tapjoy.TJWebView$a */
    class C4863a extends GestureDetector.SimpleOnGestureListener {
        C4863a() {
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return true;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public TJWebView(Context context) {
        super(context);
        setScrollContainer(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        new GestureDetector(new C4863a());
        if (getSettings() != null) {
            getSettings().setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 17) {
                getSettings().setMediaPlaybackRequiresUserGesture(false);
            }
        }
        setBackgroundColor(0);
    }

    public TJWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
