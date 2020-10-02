package com.chartboost.sdk.Banner;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;

/* renamed from: com.chartboost.sdk.Banner.d */
class C2065d {
    C2065d() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9027a(C2067f fVar, BannerSize bannerSize) {
        m8146a(fVar, BannerSize.getWidth(bannerSize), BannerSize.getHeight(bannerSize));
    }

    /* renamed from: a */
    private void m8146a(C2067f fVar, int i, int i2) {
        DisplayMetrics displayMetrics = fVar.getDisplayMetrics();
        ViewGroup.LayoutParams viewLayoutParams = fVar.getViewLayoutParams();
        viewLayoutParams.width = (int) m8145a(i, displayMetrics);
        viewLayoutParams.height = (int) m8145a(i2, displayMetrics);
        fVar.setViewLayoutParams(viewLayoutParams);
    }

    /* renamed from: a */
    private float m8145a(int i, DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, (float) i, displayMetrics);
    }
}
