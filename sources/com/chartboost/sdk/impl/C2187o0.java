package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chartboost.sdk.C2116i;
import com.chartboost.sdk.Libraries.C2076e;
import com.chartboost.sdk.Libraries.C2080h;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.impl.C2158i0;
import com.chartboost.sdk.impl.C2184n1;
import java.util.Locale;
import org.json.JSONObject;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.chartboost.sdk.impl.o0 */
public class C2187o0 extends RelativeLayout implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {

    /* renamed from: o */
    private static final CharSequence f7391o = "00:00";

    /* renamed from: a */
    final RelativeLayout f7392a;

    /* renamed from: b */
    final C2183n0 f7393b;

    /* renamed from: c */
    final C2183n0 f7394c;

    /* renamed from: d */
    final C2204r1 f7395d;

    /* renamed from: e */
    final TextView f7396e;

    /* renamed from: f */
    final C2171k0 f7397f;

    /* renamed from: g */
    final C2184n1 f7398g;

    /* renamed from: h */
    final C2158i0 f7399h;

    /* renamed from: i */
    private boolean f7400i = false;

    /* renamed from: j */
    private boolean f7401j = false;

    /* renamed from: k */
    final Handler f7402k;

    /* renamed from: l */
    private final Runnable f7403l = new C2189b();

    /* renamed from: m */
    private final Runnable f7404m = new C2190c();

    /* renamed from: n */
    final Runnable f7405n = new C2191d();

    /* renamed from: com.chartboost.sdk.impl.o0$a */
    class C2188a extends C2204r1 {
        C2188a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo9350a(MotionEvent motionEvent) {
            C2187o0.this.f7399h.mo9240a(C2076e.m8186a(C2076e.m8184a("x", (Object) Float.valueOf(motionEvent.getX())), C2076e.m8184a("y", (Object) Float.valueOf(motionEvent.getY())), C2076e.m8184a("w", (Object) Integer.valueOf(C2187o0.this.f7395d.getWidth())), C2076e.m8184a("h", (Object) Integer.valueOf(C2187o0.this.f7395d.getHeight()))));
        }
    }

    /* renamed from: com.chartboost.sdk.impl.o0$b */
    class C2189b implements Runnable {
        C2189b() {
        }

        public void run() {
            C2187o0.this.mo9456d(false);
        }
    }

    /* renamed from: com.chartboost.sdk.impl.o0$c */
    class C2190c implements Runnable {
        C2190c() {
        }

        public void run() {
            C2183n0 n0Var = C2187o0.this.f7393b;
            if (n0Var != null) {
                n0Var.setVisibility(8);
            }
            C2187o0 o0Var = C2187o0.this;
            if (o0Var.f7399h.f7275R) {
                o0Var.f7397f.setVisibility(8);
            }
            C2187o0.this.f7394c.setVisibility(8);
            C2204r1 r1Var = C2187o0.this.f7395d;
            if (r1Var != null) {
                r1Var.setEnabled(false);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.o0$d */
    class C2191d implements Runnable {

        /* renamed from: a */
        private int f7409a = 0;

        C2191d() {
        }

        public void run() {
            C2158i0.C2160b i = C2187o0.this.f7399h.mo9249i();
            if (i != null) {
                if (C2187o0.this.f7398g.mo9442a().mo9405c()) {
                    int d = C2187o0.this.f7398g.mo9442a().mo9406d();
                    if (d > 0) {
                        C2158i0 i0Var = C2187o0.this.f7399h;
                        i0Var.f7284y = d;
                        if (((float) d) / 1000.0f > 0.0f && !i0Var.mo9367r()) {
                            C2187o0.this.f7399h.mo9370u();
                            C2187o0.this.f7399h.mo9363a(true);
                        }
                    }
                    float b = ((float) d) / ((float) C2187o0.this.f7398g.mo9442a().mo9404b());
                    C2187o0 o0Var = C2187o0.this;
                    if (o0Var.f7399h.f7275R) {
                        o0Var.f7397f.mo9384a(b);
                    }
                    int i2 = d / 1000;
                    if (this.f7409a != i2) {
                        this.f7409a = i2;
                        C2187o0.this.f7396e.setText(String.format(Locale.US, "%02d:%02d", new Object[]{Integer.valueOf(i2 / 60), Integer.valueOf(i2 % 60)}));
                    }
                }
                if (i.mo9376f()) {
                    C2204r1 b2 = i.mo9371b(true);
                    if (b2.getVisibility() == 8) {
                        C2187o0.this.f7399h.mo9237a(true, (View) b2);
                        b2.setEnabled(true);
                    }
                }
                C2187o0 o0Var2 = C2187o0.this;
                o0Var2.f7402k.removeCallbacks(o0Var2.f7405n);
                C2187o0 o0Var3 = C2187o0.this;
                o0Var3.f7402k.postDelayed(o0Var3.f7405n, 16);
            }
        }
    }

    /* renamed from: com.chartboost.sdk.impl.o0$e */
    class C2192e implements Runnable {
        C2192e() {
        }

        public void run() {
            C2187o0.this.f7398g.setVisibility(0);
        }
    }

    public C2187o0(Context context, C2158i0 i0Var) {
        super(context);
        this.f7399h = i0Var;
        this.f7402k = i0Var.f7067a;
        JSONObject e = i0Var.mo9245e();
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = 10.0f * f;
        int round = Math.round(f2);
        C2116i a = C2116i.m8407a();
        this.f7398g = (C2184n1) a.mo9266a(new C2184n1(context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        addView(this.f7398g, layoutParams);
        this.f7392a = (RelativeLayout) a.mo9266a(new RelativeLayout(context));
        if (e == null || e.isNull("video-click-button")) {
            this.f7393b = null;
            this.f7395d = null;
        } else {
            C2183n0 n0Var = (C2183n0) a.mo9266a(new C2183n0(context));
            this.f7393b = n0Var;
            n0Var.setVisibility(8);
            C2188a aVar = new C2188a(context);
            this.f7395d = aVar;
            aVar.mo9501a(ImageView.ScaleType.FIT_CENTER);
            C2080h hVar = i0Var.f7271N;
            Point b = i0Var.mo9357b("video-click-button");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = Math.round(((float) b.x) / hVar.mo9098a());
            layoutParams2.topMargin = Math.round(((float) b.y) / hVar.mo9098a());
            i0Var.mo9356a(layoutParams2, hVar, 1.0f);
            this.f7395d.mo9502a(hVar);
            this.f7393b.addView(this.f7395d, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, Math.round(((float) layoutParams2.height) + f2));
            layoutParams3.addRule(10);
            this.f7392a.addView(this.f7393b, layoutParams3);
        }
        C2183n0 n0Var2 = (C2183n0) a.mo9266a(new C2183n0(context));
        this.f7394c = n0Var2;
        n0Var2.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, Math.round(f * 32.5f));
        layoutParams4.addRule(12);
        this.f7392a.addView(this.f7394c, layoutParams4);
        this.f7394c.setGravity(16);
        this.f7394c.setPadding(round, round, round, round);
        TextView textView = (TextView) a.mo9266a(new TextView(context));
        this.f7396e = textView;
        textView.setTextColor(-1);
        this.f7396e.setTextSize(2, 11.0f);
        this.f7396e.setText(f7391o);
        this.f7396e.setPadding(0, 0, round, 0);
        this.f7396e.setSingleLine();
        this.f7396e.measure(0, 0);
        int measuredWidth = this.f7396e.getMeasuredWidth();
        this.f7396e.setGravity(17);
        this.f7394c.addView(this.f7396e, new LinearLayout.LayoutParams(measuredWidth, -1));
        C2171k0 k0Var = (C2171k0) a.mo9266a(new C2171k0(context));
        this.f7397f = k0Var;
        k0Var.setVisibility(8);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, Math.round(f2));
        layoutParams5.setMargins(0, CBUtility.m8162a(1, context), 0, 0);
        this.f7394c.addView(this.f7397f, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams6.addRule(6, this.f7398g.getId());
        layoutParams6.addRule(8, this.f7398g.getId());
        layoutParams6.addRule(5, this.f7398g.getId());
        layoutParams6.addRule(7, this.f7398g.getId());
        addView(this.f7392a, layoutParams6);
        mo9460h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9450a(boolean z, boolean z2) {
        C2183n0 n0Var;
        this.f7402k.removeCallbacks(this.f7403l);
        this.f7402k.removeCallbacks(this.f7404m);
        C2158i0 i0Var = this.f7399h;
        if (i0Var.f7261D && i0Var.mo9366q() && z != this.f7400i) {
            this.f7400i = z;
            AlphaAnimation alphaAnimation = z ? new AlphaAnimation(0.0f, 1.0f) : new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(z2 ? 100 : 200);
            alphaAnimation.setFillAfter(true);
            if (!this.f7401j && (n0Var = this.f7393b) != null) {
                n0Var.setVisibility(0);
                this.f7393b.startAnimation(alphaAnimation);
                C2204r1 r1Var = this.f7395d;
                if (r1Var != null) {
                    r1Var.setEnabled(true);
                }
            }
            if (this.f7399h.f7275R) {
                this.f7397f.setVisibility(0);
            }
            this.f7394c.setVisibility(0);
            this.f7394c.startAnimation(alphaAnimation);
            if (this.f7400i) {
                this.f7402k.postDelayed(this.f7403l, 3000);
            } else {
                this.f7402k.postDelayed(this.f7404m, alphaAnimation.getDuration());
            }
        }
    }

    /* renamed from: b */
    public void mo9452b(boolean z) {
        setBackgroundColor(z ? -16777216 : 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (!z) {
            layoutParams.addRule(6, this.f7398g.getId());
            layoutParams.addRule(8, this.f7398g.getId());
            layoutParams.addRule(5, this.f7398g.getId());
            layoutParams.addRule(7, this.f7398g.getId());
        }
        this.f7392a.setLayoutParams(layoutParams);
        C2183n0 n0Var = this.f7393b;
        if (n0Var != null) {
            n0Var.setGravity(8388627);
            this.f7393b.requestLayout();
        }
    }

    /* renamed from: c */
    public void mo9454c(boolean z) {
        this.f7396e.setVisibility(z ? 0 : 8);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo9456d(boolean z) {
        mo9450a(!this.f7400i, z);
    }

    /* renamed from: e */
    public void mo9457e() {
        if (this.f7398g.mo9442a().mo9405c()) {
            this.f7399h.f7284y = this.f7398g.mo9442a().mo9406d();
        }
        this.f7398g.mo9442a().mo9407e();
        this.f7402k.removeCallbacks(this.f7405n);
    }

    /* renamed from: f */
    public void mo9458f() {
        this.f7402k.postDelayed(new C2192e(), 500);
        this.f7398g.mo9442a().mo9396a();
        this.f7402k.removeCallbacks(this.f7405n);
        this.f7402k.postDelayed(this.f7405n, 16);
    }

    /* renamed from: g */
    public void mo9459g() {
        if (this.f7398g.mo9442a().mo9405c()) {
            this.f7399h.f7284y = this.f7398g.mo9442a().mo9406d();
            this.f7398g.mo9442a().mo9407e();
        }
        if (this.f7399h.mo9249i().f7249k.getVisibility() == 0) {
            this.f7399h.mo9249i().f7249k.postInvalidate();
        }
        this.f7402k.removeCallbacks(this.f7405n);
    }

    /* renamed from: h */
    public void mo9460h() {
        mo9452b(CBUtility.m8171b(CBUtility.m8174e()));
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f7399h.f7284y = this.f7398g.mo9442a().mo9404b();
        if (this.f7399h.mo9249i() != null) {
            this.f7399h.mo9249i().mo9375e();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7402k.removeCallbacks(this.f7405n);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f7399h.mo9369t();
        return false;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f7399h.f7285z = this.f7398g.mo9442a().mo9404b();
        this.f7399h.mo9249i().mo9259a(true);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f7398g.mo9442a().mo9405c() || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (this.f7399h != null) {
            mo9456d(true);
        }
        return true;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        C2204r1 r1Var = this.f7395d;
        if (r1Var != null) {
            r1Var.setEnabled(z);
        }
        if (z) {
            mo9449a(false);
        }
    }

    /* renamed from: c */
    public void mo9453c() {
        this.f7398g.setVisibility(8);
        invalidate();
    }

    /* renamed from: d */
    public void mo9455d() {
        C2183n0 n0Var = this.f7393b;
        if (n0Var != null) {
            n0Var.setVisibility(8);
        }
        this.f7401j = true;
        C2204r1 r1Var = this.f7395d;
        if (r1Var != null) {
            r1Var.setEnabled(false);
        }
    }

    /* renamed from: b */
    public C2171k0 mo9451b() {
        return this.f7397f;
    }

    /* renamed from: a */
    public void mo9449a(boolean z) {
        C2183n0 n0Var;
        this.f7402k.removeCallbacks(this.f7403l);
        this.f7402k.removeCallbacks(this.f7404m);
        if (z) {
            if (!this.f7401j && (n0Var = this.f7393b) != null) {
                n0Var.setVisibility(0);
            }
            if (this.f7399h.f7275R) {
                this.f7397f.setVisibility(0);
            }
            this.f7394c.setVisibility(0);
            C2204r1 r1Var = this.f7395d;
            if (r1Var != null) {
                r1Var.setEnabled(true);
            }
        } else {
            C2183n0 n0Var2 = this.f7393b;
            if (n0Var2 != null) {
                n0Var2.clearAnimation();
                this.f7393b.setVisibility(8);
            }
            this.f7394c.clearAnimation();
            if (this.f7399h.f7275R) {
                this.f7397f.setVisibility(8);
            }
            this.f7394c.setVisibility(8);
            C2204r1 r1Var2 = this.f7395d;
            if (r1Var2 != null) {
                r1Var2.setEnabled(false);
            }
        }
        this.f7400i = z;
    }

    /* renamed from: a */
    public C2184n1.C2185a mo9446a() {
        return this.f7398g.mo9442a();
    }

    /* renamed from: a */
    public void mo9447a(int i) {
        C2183n0 n0Var = this.f7393b;
        if (n0Var != null) {
            n0Var.setBackgroundColor(i);
        }
        this.f7394c.setBackgroundColor(i);
    }

    /* renamed from: a */
    public void mo9448a(String str) {
        this.f7398g.mo9442a().mo9399a((MediaPlayer.OnCompletionListener) this);
        this.f7398g.mo9442a().mo9400a((MediaPlayer.OnErrorListener) this);
        this.f7398g.mo9442a().mo9401a((MediaPlayer.OnPreparedListener) this);
        this.f7398g.mo9442a().mo9402a(Uri.parse(str));
    }
}
