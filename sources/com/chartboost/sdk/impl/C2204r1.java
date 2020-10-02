package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.C2080h;

/* renamed from: com.chartboost.sdk.impl.r1 */
public abstract class C2204r1 extends RelativeLayout {

    /* renamed from: a */
    final C2207c f7441a;

    /* renamed from: b */
    private final Rect f7442b;

    /* renamed from: c */
    protected Button f7443c;

    /* renamed from: d */
    boolean f7444d;

    /* renamed from: com.chartboost.sdk.impl.r1$a */
    class C2205a implements View.OnTouchListener {
        C2205a() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean a = C2204r1.this.mo9505a(view, motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    if (C2204r1.this.getVisibility() == 0 && C2204r1.this.isEnabled() && a) {
                        C2204r1.this.mo9350a(motionEvent);
                    }
                    C2204r1.this.f7441a.mo9508a(false);
                } else if (actionMasked == 2) {
                    C2204r1.this.f7441a.mo9508a(a);
                } else if (actionMasked == 3 || actionMasked == 4) {
                    C2204r1.this.f7441a.mo9508a(false);
                }
                return true;
            }
            C2204r1.this.f7441a.mo9508a(a);
            return a;
        }
    }

    /* renamed from: com.chartboost.sdk.impl.r1$b */
    class C2206b implements View.OnClickListener {
        C2206b() {
        }

        public void onClick(View view) {
            C2204r1.this.mo9350a((MotionEvent) null);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.r1$c */
    private class C2207c extends C2201q1 {

        /* renamed from: c */
        private boolean f7447c;

        public C2207c(Context context) {
            super(context);
            this.f7447c = false;
            this.f7447c = false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo9508a(boolean z) {
            if (!C2204r1.this.f7444d || !z) {
                if (this.f7447c) {
                    if (getDrawable() != null) {
                        getDrawable().clearColorFilter();
                    } else if (getBackground() != null) {
                        getBackground().clearColorFilter();
                    }
                    invalidate();
                    this.f7447c = false;
                }
            } else if (!this.f7447c) {
                if (getDrawable() != null) {
                    getDrawable().setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
                } else if (getBackground() != null) {
                    getBackground().setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
                }
                invalidate();
                this.f7447c = true;
            }
        }

        public boolean performClick() {
            super.performClick();
            return true;
        }
    }

    public C2204r1(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo9350a(MotionEvent motionEvent);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo9505a(View view, MotionEvent motionEvent) {
        view.getLocalVisibleRect(this.f7442b);
        this.f7442b.left += view.getPaddingLeft();
        this.f7442b.top += view.getPaddingTop();
        this.f7442b.right -= view.getPaddingRight();
        this.f7442b.bottom -= view.getPaddingBottom();
        return this.f7442b.contains(Math.round(motionEvent.getX()), Math.round(motionEvent.getY()));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public C2204r1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7442b = new Rect();
        this.f7443c = null;
        this.f7444d = true;
        C2207c cVar = new C2207c(getContext());
        this.f7441a = cVar;
        cVar.setOnTouchListener(new C2205a());
        addView(this.f7441a, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* renamed from: a */
    public void mo9503a(String str) {
        if (str != null) {
            mo9500a().setText(str);
            addView(mo9500a(), new RelativeLayout.LayoutParams(-1, -1));
            this.f7441a.setVisibility(8);
            mo9504a(false);
            this.f7443c.setOnClickListener(new C2206b());
        } else if (this.f7443c != null) {
            removeView(mo9500a());
            this.f7443c = null;
            this.f7441a.setVisibility(0);
            mo9504a(true);
        }
    }

    /* renamed from: a */
    public TextView mo9500a() {
        if (this.f7443c == null) {
            Button button = new Button(getContext());
            this.f7443c = button;
            button.setGravity(17);
        }
        this.f7443c.postInvalidate();
        return this.f7443c;
    }

    /* renamed from: a */
    public void mo9502a(C2080h hVar) {
        if (hVar != null && hVar.mo9104e()) {
            this.f7441a.mo9496a(hVar);
            mo9503a((String) null);
        }
    }

    /* renamed from: a */
    public void mo9501a(ImageView.ScaleType scaleType) {
        this.f7441a.setScaleType(scaleType);
    }

    /* renamed from: a */
    public void mo9504a(boolean z) {
        this.f7444d = z;
    }
}
