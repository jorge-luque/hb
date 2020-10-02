package com.tapjoy;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.vungle.warren.AdLoader;

public class TJCloseButton extends ImageButton {

    /* renamed from: a */
    private static final String f12982a = TJCloseButton.class.getSimpleName();

    /* renamed from: b */
    private ClosePosition f12983b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f12984c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f12985d;

    public enum ClosePosition {
        TOP_LEFT(new int[]{10, 9}),
        TOP_CENTER(new int[]{10, 14}),
        TOP_RIGHT(new int[]{10, 11}),
        CENTER(new int[]{13}),
        BOTTOM_LEFT(new int[]{12, 9}),
        BOTTOM_CENTER(new int[]{12, 14}),
        BOTTOM_RIGHT(new int[]{12, 11});
        

        /* renamed from: a */
        final RelativeLayout.LayoutParams f12989a;

        private ClosePosition(int[] iArr) {
            this.f12989a = new RelativeLayout.LayoutParams(-2, -2);
            for (int addRule : iArr) {
                this.f12989a.addRule(addRule);
            }
            int deviceScreenDensityScale = (int) (TapjoyConnectCore.getDeviceScreenDensityScale() * -10.0f);
            this.f12989a.setMargins(0, deviceScreenDensityScale, deviceScreenDensityScale, 0);
        }
    }

    public TJCloseButton(Context context) {
        this(context, ClosePosition.TOP_RIGHT);
    }

    /* access modifiers changed from: protected */
    @TargetApi(11)
    public void onAttachedToWindow() {
        if (Build.VERSION.SDK_INT >= 12) {
            setAlpha(0.0f);
            setVisibility(0);
            this.f12985d = true;
            setClickable(false);
            new Handler().postDelayed(new Runnable() {
                @SuppressLint({"NewApi"})
                public final void run() {
                    TJCloseButton.this.animate().alpha(1.0f).setDuration(500).setListener(new Animator.AnimatorListener() {
                        public final void onAnimationCancel(Animator animator) {
                            TJCloseButton tJCloseButton = TJCloseButton.this;
                            tJCloseButton.setClickable(tJCloseButton.f12984c);
                            boolean unused = TJCloseButton.this.f12985d = false;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            TJCloseButton tJCloseButton = TJCloseButton.this;
                            tJCloseButton.setClickable(tJCloseButton.f12984c);
                            boolean unused = TJCloseButton.this.f12985d = false;
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }

                        public final void onAnimationStart(Animator animator) {
                        }
                    });
                }
            }, AdLoader.RETRY_DELAY);
        }
    }

    /* access modifiers changed from: package-private */
    public void setClickableRequested(boolean z) {
        this.f12984c = z;
        if (!this.f12985d) {
            setClickable(z);
        }
    }

    public TJCloseButton(Context context, ClosePosition closePosition) {
        super(context);
        this.f12984c = true;
        this.f12983b = closePosition;
        Bitmap loadBitmapFromJar = TapjoyUtil.loadBitmapFromJar("tj_close_button.png", context);
        if (loadBitmapFromJar == null) {
            try {
                loadBitmapFromJar = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier("tj_close_button", "drawable", context.getPackageName()));
            } catch (Exception unused) {
                TapjoyLog.m16654w(f12982a, "Could not find close button asset");
            }
        }
        setImageBitmap(loadBitmapFromJar);
        setBackgroundColor(16777215);
        setLayoutParams(this.f12983b.f12989a);
    }
}
