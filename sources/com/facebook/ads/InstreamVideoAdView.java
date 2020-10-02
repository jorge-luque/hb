package com.facebook.ads;

import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import com.facebook.ads.C2630Ad;
import com.facebook.ads.internal.api.InstreamVideoAdViewApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

@Deprecated
@Keep
public class InstreamVideoAdView extends RelativeLayout implements C2630Ad {
    private final InstreamVideoAdViewApi mInstreamVideoAdViewApi;

    @Keep
    @Deprecated
    public interface InstreamVideoLoadAdConfig extends C2630Ad.LoadAdConfig {
    }

    @Keep
    @Deprecated
    public interface InstreamVideoLoadConfigBuilder extends C2630Ad.LoadConfigBuilder {
        @Deprecated
        InstreamVideoLoadAdConfig build();

        @Deprecated
        InstreamVideoLoadConfigBuilder withAdListener(InstreamVideoAdListener instreamVideoAdListener);

        @Deprecated
        InstreamVideoLoadConfigBuilder withBid(String str);
    }

    @Deprecated
    public InstreamVideoAdView(Context context, Bundle bundle) {
        super(context);
        this.mInstreamVideoAdViewApi = DynamicLoaderFactory.makeLoader(context).createInstreamVideoAdViewApi(this, context, bundle);
    }

    @Deprecated
    public InstreamVideoLoadConfigBuilder buildLoadAdConfig() {
        return this.mInstreamVideoAdViewApi.buildLoadAdConfig();
    }

    @Deprecated
    public void destroy() {
        this.mInstreamVideoAdViewApi.destroy();
    }

    @Deprecated
    public String getPlacementId() {
        return this.mInstreamVideoAdViewApi.getPlacementId();
    }

    @Deprecated
    public Bundle getSaveInstanceState() {
        return this.mInstreamVideoAdViewApi.getSaveInstanceState();
    }

    @Deprecated
    public boolean isAdInvalidated() {
        return this.mInstreamVideoAdViewApi.isAdInvalidated();
    }

    @Deprecated
    public boolean isAdLoaded() {
        return this.mInstreamVideoAdViewApi.isAdLoaded();
    }

    @Deprecated
    public void loadAd() {
        this.mInstreamVideoAdViewApi.loadAd();
    }

    @Deprecated
    public void loadAdFromBid(String str) {
        this.mInstreamVideoAdViewApi.loadAdFromBid(str);
    }

    @Deprecated
    public void setAdListener(InstreamVideoAdListener instreamVideoAdListener) {
        this.mInstreamVideoAdViewApi.setAdListener(instreamVideoAdListener);
    }

    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mInstreamVideoAdViewApi.setExtraHints(extraHints);
    }

    @Deprecated
    public boolean show() {
        return this.mInstreamVideoAdViewApi.show();
    }

    @Deprecated
    public void loadAd(InstreamVideoLoadAdConfig instreamVideoLoadAdConfig) {
        this.mInstreamVideoAdViewApi.loadAd(instreamVideoLoadAdConfig);
    }

    @Deprecated
    public InstreamVideoAdView(Context context, String str, AdSize adSize) {
        super(context);
        this.mInstreamVideoAdViewApi = DynamicLoaderFactory.makeLoader(context).createInstreamVideoAdViewApi(this, context, str, adSize);
    }
}
