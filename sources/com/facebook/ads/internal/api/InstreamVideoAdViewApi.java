package com.facebook.ads.internal.api;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.facebook.ads.C2630Ad;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.InstreamVideoAdListener;
import com.facebook.ads.InstreamVideoAdView;

@Keep
public interface InstreamVideoAdViewApi extends C2630Ad {
    InstreamVideoAdView.InstreamVideoLoadConfigBuilder buildLoadAdConfig();

    void destroy();

    String getPlacementId();

    Bundle getSaveInstanceState();

    boolean isAdLoaded();

    void loadAd();

    void loadAd(InstreamVideoAdView.InstreamVideoLoadAdConfig instreamVideoLoadAdConfig);

    @Deprecated
    void loadAdFromBid(String str);

    void setAdListener(InstreamVideoAdListener instreamVideoAdListener);

    @Deprecated
    void setExtraHints(ExtraHints extraHints);

    void setIsAdLoaded(boolean z);

    boolean show();
}
