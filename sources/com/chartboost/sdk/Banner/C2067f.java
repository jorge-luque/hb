package com.chartboost.sdk.Banner;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.chartboost.sdk.C2239j;

/* renamed from: com.chartboost.sdk.Banner.f */
public interface C2067f {
    C2239j.C2241b attachBannerToSDKCommand(C2239j.C2241b bVar);

    DisplayMetrics getDisplayMetrics();

    C2239j.C2241b getSdkCommand();

    ViewGroup.LayoutParams getViewLayoutParams();

    boolean isBelowLollipop();

    void setViewLayoutParams(ViewGroup.LayoutParams layoutParams);
}
