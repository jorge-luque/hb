package com.applovin.impl.adview;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.C1563h;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1817a;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p051c.C1854d;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.k */
class C1570k extends Dialog implements C1569j {

    /* renamed from: a */
    private final Activity f4927a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1941j f4928b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1977q f4929c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1548c f4930d;

    /* renamed from: e */
    private final C1817a f4931e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public RelativeLayout f4932f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C1563h f4933g;

    C1570k(C1817a aVar, C1548c cVar, Activity activity, C1941j jVar) {
        super(activity, 16973840);
        if (aVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (cVar == null) {
            throw new IllegalArgumentException("No main view specified");
        } else if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity != null) {
            this.f4928b = jVar;
            this.f4929c = jVar.mo8602v();
            this.f4927a = activity;
            this.f4930d = cVar;
            this.f4931e = aVar;
            requestWindowFeature(1);
            setCancelable(false);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }

    /* renamed from: a */
    private int m6035a(int i) {
        return AppLovinSdkUtils.dpToPx(this.f4927a, i);
    }

    /* renamed from: a */
    private void m6037a(C1563h.C1564a aVar) {
        if (this.f4933g != null) {
            this.f4929c.mo8745d("ExpandedAdDialog", "Attempting to create duplicate close button");
            return;
        }
        C1563h a = C1563h.m6016a(aVar, this.f4927a);
        this.f4933g = a;
        a.setVisibility(8);
        this.f4933g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C1570k.this.m6040c();
            }
        });
        this.f4933g.setClickable(false);
        int a2 = m6035a(((Integer) this.f4928b.mo8549a(C1841c.f5944cm)).intValue());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams.addRule(10);
        int i = 9;
        layoutParams.addRule(((Boolean) this.f4928b.mo8549a(C1841c.f5947cp)).booleanValue() ? 9 : 11);
        this.f4933g.mo7436a(a2);
        int a3 = m6035a(((Integer) this.f4928b.mo8549a(C1841c.f5946co)).intValue());
        int a4 = m6035a(((Integer) this.f4928b.mo8549a(C1841c.f5945cn)).intValue());
        layoutParams.setMargins(a4, a3, a4, 0);
        this.f4932f.addView(this.f4933g, layoutParams);
        this.f4933g.bringToFront();
        int a5 = m6035a(((Integer) this.f4928b.mo8549a(C1841c.f5948cq)).intValue());
        View view = new View(this.f4927a);
        view.setBackgroundColor(0);
        int i2 = a2 + a5;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i2);
        layoutParams2.addRule(10);
        if (!((Boolean) this.f4928b.mo8549a(C1841c.f5947cp)).booleanValue()) {
            i = 11;
        }
        layoutParams2.addRule(i);
        layoutParams2.setMargins(a4 - m6035a(5), a3 - m6035a(5), a4 - m6035a(5), 0);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (C1570k.this.f4933g.isClickable()) {
                    C1570k.this.f4933g.performClick();
                }
            }
        });
        this.f4932f.addView(view, layoutParams2);
        view.bringToFront();
    }

    /* renamed from: b */
    private void m6039b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f4930d.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.f4927a);
        this.f4932f = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f4932f.setBackgroundColor(-1157627904);
        this.f4932f.addView(this.f4930d);
        if (!this.f4931e.mo8164l()) {
            m6037a(this.f4931e.mo8165m());
            m6042d();
        }
        setContentView(this.f4932f);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6040c() {
        this.f4930d.mo7373a("javascript:al_onCloseTapped();", (Runnable) new Runnable() {
            public void run() {
                C1570k.this.dismiss();
            }
        });
    }

    /* renamed from: d */
    private void m6042d() {
        this.f4927a.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (C1570k.this.f4933g == null) {
                        C1570k.this.m6040c();
                    }
                    C1570k.this.f4933g.setVisibility(0);
                    C1570k.this.f4933g.bringToFront();
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(((Long) C1570k.this.f4928b.mo8549a(C1841c.f5943cl)).longValue());
                    alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            C1570k.this.f4933g.setClickable(true);
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    C1570k.this.f4933g.startAnimation(alphaAnimation);
                } catch (Throwable th) {
                    C1570k.this.f4929c.mo8743b("ExpandedAdDialog", "Unable to fade in close button", th);
                    C1570k.this.m6040c();
                }
            }
        });
    }

    /* renamed from: a */
    public C1817a mo7449a() {
        return this.f4931e;
    }

    public void dismiss() {
        C1854d statsManagerHelper = this.f4930d.getStatsManagerHelper();
        if (statsManagerHelper != null) {
            statsManagerHelper.mo8367e();
        }
        this.f4927a.runOnUiThread(new Runnable() {
            public void run() {
                C1570k.this.f4932f.removeView(C1570k.this.f4930d);
                C1570k.super.dismiss();
            }
        });
    }

    public void onBackPressed() {
        this.f4930d.mo7373a("javascript:al_onBackPressed();", (Runnable) new Runnable() {
            public void run() {
                C1570k.this.dismiss();
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m6039b();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(this.f4927a.getWindow().getAttributes().flags, this.f4927a.getWindow().getAttributes().flags);
                if (this.f4931e.mo8201A()) {
                    window.addFlags(16777216);
                    return;
                }
                return;
            }
            this.f4929c.mo8746e("ExpandedAdDialog", "Unable to turn on hardware acceleration - window is null");
        } catch (Throwable th) {
            this.f4929c.mo8743b("ExpandedAdDialog", "Setting window flags failed.", th);
        }
    }
}
