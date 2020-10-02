package com.google.android.exoplayer2.p072ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* renamed from: com.google.android.exoplayer2.ui.AspectRatioFrameLayout */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: a */
    private final C3052c f8460a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C3051b f8461b;

    /* renamed from: c */
    private float f8462c;

    /* renamed from: d */
    private int f8463d;

    /* renamed from: com.google.android.exoplayer2.ui.AspectRatioFrameLayout$b */
    public interface C3051b {
        /* renamed from: a */
        void mo13046a(float f, float f2, boolean z);
    }

    /* renamed from: com.google.android.exoplayer2.ui.AspectRatioFrameLayout$c */
    private final class C3052c implements Runnable {

        /* renamed from: a */
        private float f8464a;

        /* renamed from: b */
        private float f8465b;

        /* renamed from: c */
        private boolean f8466c;

        /* renamed from: d */
        private boolean f8467d;

        private C3052c() {
        }

        /* renamed from: a */
        public void mo13047a(float f, float f2, boolean z) {
            this.f8464a = f;
            this.f8465b = f2;
            this.f8466c = z;
            if (!this.f8467d) {
                this.f8467d = true;
                AspectRatioFrameLayout.this.post(this);
            }
        }

        public void run() {
            this.f8467d = false;
            if (AspectRatioFrameLayout.this.f8461b != null) {
                AspectRatioFrameLayout.this.f8461b.mo13046a(this.f8464a, this.f8465b, this.f8466c);
            }
        }
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        float f;
        float f2;
        super.onMeasure(i, i2);
        if (this.f8462c > 0.0f) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f3 = (float) measuredWidth;
            float f4 = (float) measuredHeight;
            float f5 = f3 / f4;
            float f6 = (this.f8462c / f5) - 1.0f;
            if (Math.abs(f6) <= 0.01f) {
                this.f8460a.mo13047a(this.f8462c, f5, false);
                return;
            }
            int i3 = this.f8463d;
            if (i3 != 0) {
                if (i3 == 1) {
                    f2 = this.f8462c;
                } else if (i3 != 2) {
                    if (i3 == 4) {
                        if (f6 > 0.0f) {
                            f = this.f8462c;
                        } else {
                            f2 = this.f8462c;
                        }
                    }
                    this.f8460a.mo13047a(this.f8462c, f5, true);
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
                } else {
                    f = this.f8462c;
                }
                measuredHeight = (int) (f3 / f2);
                this.f8460a.mo13047a(this.f8462c, f5, true);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            } else if (f6 > 0.0f) {
                f2 = this.f8462c;
                measuredHeight = (int) (f3 / f2);
                this.f8460a.mo13047a(this.f8462c, f5, true);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            } else {
                f = this.f8462c;
            }
            measuredWidth = (int) (f4 * f);
            this.f8460a.mo13047a(this.f8462c, f5, true);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8463d = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.AspectRatioFrameLayout, 0, 0);
            try {
                this.f8463d = obtainStyledAttributes.getInt(R$styleable.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f8460a = new C3052c();
    }

    /* renamed from: a */
    public void mo13044a(int i) {
        if (this.f8463d != i) {
            this.f8463d = i;
            requestLayout();
        }
    }
}
