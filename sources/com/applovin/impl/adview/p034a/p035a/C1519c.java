package com.applovin.impl.adview.p034a.p035a;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.AppLovinVideoViewV2;
import com.applovin.impl.adview.C1515a;
import com.applovin.impl.adview.C1578l;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C1985b;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.a.a.c */
public class C1519c extends C1517a {
    public C1519c(C1827g gVar, AppLovinFullscreenActivity appLovinFullscreenActivity, C1941j jVar) {
        super(gVar, appLovinFullscreenActivity, jVar);
    }

    /* renamed from: a */
    public void mo7299a(ImageView imageView, C1578l lVar, C1515a aVar, ProgressBar progressBar, AppLovinVideoViewV2 appLovinVideoViewV2, AppLovinAdView appLovinAdView) {
        appLovinVideoViewV2.setLayoutParams(this.f4781e);
        this.f4780d.addView(appLovinVideoViewV2);
        appLovinAdView.setLayoutParams(this.f4781e);
        this.f4780d.addView(appLovinAdView);
        appLovinAdView.setVisibility(4);
        if (lVar != null) {
            mo7297a(this.f4779c.mo8252af(), (this.f4779c.mo8257ak() ? 3 : 5) | 48, lVar);
        }
        if (imageView != null) {
            int dpToPx = AppLovinSdkUtils.dpToPx(this.f4778b, ((Integer) this.f4777a.mo8549a(C1841c.f5931cZ)).intValue());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, dpToPx, ((Integer) this.f4777a.mo8549a(C1841c.f5985db)).intValue());
            int dpToPx2 = AppLovinSdkUtils.dpToPx(this.f4778b, ((Integer) this.f4777a.mo8549a(C1841c.f5984da)).intValue());
            layoutParams.setMargins(dpToPx2, dpToPx2, dpToPx2, dpToPx2);
            this.f4780d.addView(imageView, layoutParams);
        }
        if (aVar != null) {
            this.f4780d.addView(aVar, this.f4781e);
        }
        if (progressBar != null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, 20, 80);
            layoutParams2.setMargins(0, 0, 0, ((Integer) this.f4777a.mo8549a(C1841c.f5989df)).intValue());
            this.f4780d.addView(progressBar, layoutParams2);
        }
        this.f4778b.setContentView(this.f4780d);
    }

    /* renamed from: a */
    public void mo7300a(C1578l lVar, View view) {
        view.setVisibility(0);
        C1985b.m7817a(this.f4780d, view);
        if (lVar != null) {
            mo7297a(this.f4779c.mo8252af(), (this.f4779c.mo8256aj() ? 3 : 5) | 48, lVar);
        }
    }
}
