package com.chartboost.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C2088c;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C2098a;

@SuppressLint({"Registered"})
public class CBImpressionActivity extends Activity {

    /* renamed from: a */
    final C2098a f6827a;

    /* renamed from: b */
    final Handler f6828b;

    /* renamed from: c */
    final C2102d f6829c;

    public CBImpressionActivity() {
        C2102d dVar = null;
        this.f6827a = C2239j.m8897n() != null ? C2239j.m8897n().f7590x : null;
        this.f6828b = C2239j.m8897n() != null ? C2239j.m8897n().f7591y : null;
        this.f6829c = C2239j.m8897n() != null ? C2239j.m8897n().f7592z : dVar;
    }

    public void onAttachedToWindow() {
        View decorView;
        try {
            super.onAttachedToWindow();
            Window window = getWindow();
            if (window != null && (decorView = window.getDecorView()) != null && !decorView.isHardwareAccelerated() && this.f6829c != null) {
                CBLogging.m8154b("CBImpressionActivity", "The activity passed down is not hardware accelerated, so Chartboost cannot show ads");
                C2088c e = this.f6829c.mo9200e();
                if (e != null) {
                    e.mo9120a(CBError.CBImpressionError.HARDWARE_ACCELERATION_DISABLED);
                }
                finish();
            }
        } catch (Exception e2) {
            C2098a.m8288a(CBImpressionActivity.class, "onAttachedToWindow", e2);
        }
    }

    public void onBackPressed() {
        try {
            if (this.f6829c == null || !this.f6829c.mo9207h()) {
                super.onBackPressed();
            }
        } catch (Exception e) {
            C2098a.m8288a(CBImpressionActivity.class, "onBackPressed", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if ((getIntent() != null && !getIntent().getBooleanExtra("isChartboost", false)) || this.f6827a == null || this.f6828b == null || this.f6829c == null) {
            CBLogging.m8154b("CBImpressionActivity", "This activity cannot be called from outside chartboost SDK");
            finish();
            return;
        }
        requestWindowFeature(1);
        getWindow().setWindowAnimations(0);
        this.f6829c.mo9189a(this);
        setContentView(new RelativeLayout(this));
        CBLogging.m8152a("CBImpressionActivity", "Impression Activity onCreate() called");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.f6829c != null && !C2242k.f7617q) {
                this.f6829c.mo9199d((Activity) this);
            }
            super.onDestroy();
        } catch (Exception e) {
            C2098a.m8288a(CBImpressionActivity.class, "onDestroy", e);
        } catch (Throwable th) {
            super.onDestroy();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            super.onPause();
            if (this.f6829c != null && !C2242k.f7617q) {
                this.f6829c.mo9187a((Activity) this);
                this.f6829c.mo9210j();
            }
        } catch (Exception e) {
            C2098a.m8288a(CBImpressionActivity.class, "onPause", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        try {
            super.onResume();
            if (this.f6829c != null && !C2242k.f7617q) {
                this.f6829c.mo9187a((Activity) this);
                this.f6829c.mo9212k();
            }
        } catch (Exception e) {
            C2098a.m8288a(CBImpressionActivity.class, "onResume", e);
        }
        Chartboost.setActivityAttrs(this);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        try {
            super.onStart();
            if (this.f6829c != null && !C2242k.f7617q) {
                this.f6829c.mo9206h(this);
            }
        } catch (Exception e) {
            C2098a.m8288a(CBImpressionActivity.class, "onStart", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            super.onStop();
            if (this.f6829c != null && !C2242k.f7617q) {
                this.f6829c.mo9211j(this);
            }
        } catch (Exception e) {
            C2098a.m8288a(CBImpressionActivity.class, "onStop", e);
        }
    }
}
