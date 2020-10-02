package com.facebook.ads.internal.api;

import android.content.res.Configuration;
import androidx.annotation.Keep;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdView;
import com.facebook.ads.C2630Ad;
import com.facebook.ads.ExtraHints;

@Keep
public interface AdViewApi extends AdViewParentApi, C2630Ad {
    AdView.AdViewLoadConfigBuilder buildLoadAdConfig();

    void loadAd(AdView.AdViewLoadConfig adViewLoadConfig);

    void onConfigurationChanged(Configuration configuration);

    void setAdListener(AdListener adListener);

    @Deprecated
    void setExtraHints(ExtraHints extraHints);
}
