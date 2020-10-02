package com.applovin.adview;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.KeyEvent;
import com.applovin.impl.adview.C1569j;
import com.applovin.impl.adview.C1615o;
import com.applovin.impl.adview.p034a.p036b.C1520a;
import com.applovin.impl.sdk.utils.C1986c;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppLovinFullscreenActivity extends Activity implements C1569j {
    public static C1615o parentInterstitialWrapper;

    /* renamed from: a */
    private C1520a f4572a;

    /* renamed from: b */
    private final AtomicBoolean f4573b = new AtomicBoolean(true);

    /* renamed from: c */
    private int f4574c;

    public void dismiss() {
        this.f4572a.mo7317f();
    }

    public void onBackPressed() {
        this.f4572a.mo7321j();
        if (C1986c.m7820a(getApplicationContext()).mo8771a("applovin.sdk.is_test_environment")) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f4572a.mo7304a(configuration);
    }

    /* JADX WARNING: type inference failed for: r8v18, types: [com.applovin.impl.adview.a.b.a] */
    /* JADX WARNING: type inference failed for: r0v15, types: [com.applovin.impl.adview.a.b.b] */
    /* JADX WARNING: type inference failed for: r0v16, types: [com.applovin.impl.adview.a.b.d] */
    /* JADX WARNING: type inference failed for: r0v17, types: [com.applovin.impl.adview.a.b.c] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r8) {
        /*
            r7 = this;
            super.onCreate(r8)
            int r8 = r7.f4574c
            r0 = 1
            int r8 = r8 + r0
            r7.f4574c = r8
            r7.requestWindowFeature(r0)
            android.view.Window r8 = r7.getWindow()
            r0 = 1024(0x400, float:1.435E-42)
            r8.setFlags(r0, r0)
            android.view.Window r8 = r7.getWindow()
            r0 = 16777216(0x1000000, float:2.3509887E-38)
            r8.addFlags(r0)
            android.view.Window r8 = r7.getWindow()
            r0 = 128(0x80, float:1.794E-43)
            r8.addFlags(r0)
            r8 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r8 = r7.findViewById(r8)
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r8.setBackgroundColor(r0)
            com.applovin.impl.adview.o r8 = parentInterstitialWrapper
            if (r8 != 0) goto L_0x00bf
            android.content.Intent r8 = r7.getIntent()
            java.lang.String r0 = "com.applovin.interstitial.wrapper_id"
            java.lang.String r8 = r8.getStringExtra(r0)
            com.applovin.impl.adview.o r8 = com.applovin.impl.adview.C1615o.m6164a((java.lang.String) r8)
            parentInterstitialWrapper = r8
            if (r8 != 0) goto L_0x00bf
            com.applovin.sdk.AppLovinSdk r8 = com.applovin.sdk.AppLovinSdk.getInstance(r7)
            com.applovin.impl.sdk.j r8 = com.applovin.impl.sdk.utils.C2029r.m7993a((com.applovin.sdk.AppLovinSdk) r8)
            com.applovin.impl.sdk.a r0 = r8.mo8565aa()
            android.app.Activity r0 = r0.mo8070a()
            com.applovin.impl.sdk.c.h r1 = r8.mo8534M()
            com.applovin.impl.sdk.c.g r2 = com.applovin.impl.sdk.p051c.C1859g.f6189d
            r1.mo8390b(r2)
            com.applovin.impl.sdk.c.h r1 = r8.mo8534M()
            com.applovin.impl.sdk.c.g r2 = com.applovin.impl.sdk.p051c.C1859g.f6199n
            r1.mo8390b(r2)
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r1 = com.applovin.impl.sdk.p050b.C1841c.f6064fc
            java.lang.Object r1 = r8.mo8549a(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x007a
            goto L_0x00bf
        L_0x007a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Parent interstitial wrapper is null. Top activity: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " sa: "
            r2.append(r0)
            com.applovin.impl.sdk.c.h r0 = r8.mo8534M()
            com.applovin.impl.sdk.c.g r3 = com.applovin.impl.sdk.p051c.C1859g.f6189d
            long r3 = r0.mo8390b(r3)
            r2.append(r3)
            java.lang.String r0 = " ma: "
            r2.append(r0)
            com.applovin.impl.sdk.c.h r8 = r8.mo8534M()
            com.applovin.impl.sdk.c.g r0 = com.applovin.impl.sdk.p051c.C1859g.f6199n
            long r3 = r8.mo8390b(r0)
            r2.append(r3)
            java.lang.String r8 = " counter: "
            r2.append(r8)
            int r8 = r7.f4574c
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r1.<init>(r8)
            throw r1
        L_0x00bf:
            com.applovin.impl.adview.o r8 = parentInterstitialWrapper
            com.applovin.impl.sdk.ad.g r1 = r8.mo7519b()
            com.applovin.impl.adview.o r8 = parentInterstitialWrapper
            com.applovin.impl.sdk.j r3 = r8.mo7516a()
            com.applovin.impl.adview.o r8 = parentInterstitialWrapper
            com.applovin.sdk.AppLovinAdClickListener r4 = r8.mo7522e()
            com.applovin.impl.adview.o r8 = parentInterstitialWrapper
            com.applovin.sdk.AppLovinAdDisplayListener r5 = r8.mo7521d()
            com.applovin.impl.adview.o r8 = parentInterstitialWrapper
            com.applovin.sdk.AppLovinAdVideoPlaybackListener r6 = r8.mo7520c()
            boolean r8 = r1 instanceof com.applovin.impl.p033a.C1476a
            if (r8 == 0) goto L_0x00eb
            com.applovin.impl.adview.a.b.c r8 = new com.applovin.impl.adview.a.b.c
            r0 = r8
            r2 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
        L_0x00e8:
            r7.f4572a = r8
            goto L_0x0101
        L_0x00eb:
            boolean r8 = r1.hasVideoUrl()
            if (r8 == 0) goto L_0x00f9
            com.applovin.impl.adview.a.b.d r8 = new com.applovin.impl.adview.a.b.d
            r0 = r8
            r2 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L_0x00e8
        L_0x00f9:
            com.applovin.impl.adview.a.b.b r8 = new com.applovin.impl.adview.a.b.b
            r0 = r8
            r2 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L_0x00e8
        L_0x0101:
            com.applovin.impl.adview.a.b.a r8 = r7.f4572a
            r8.mo7313c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.adview.AppLovinFullscreenActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        parentInterstitialWrapper = null;
        this.f4572a.mo7319h();
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        this.f4572a.mo7301a(i, keyEvent);
        return super.onKeyDown(i, keyEvent);
    }

    public void onLowMemory() {
        this.f4572a.mo7320i();
        super.onLowMemory();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f4572a.mo7316e();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.f4573b.get()) {
            this.f4572a.mo7315d();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f4572a.mo7318g();
    }

    public void onWindowFocusChanged(boolean z) {
        if (!this.f4573b.getAndSet(false)) {
            this.f4572a.mo7314c(z);
        }
        if (z) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
        super.onWindowFocusChanged(z);
    }
}
