package com.facebook.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import com.facebook.ads.C2630Ad;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.bench.Benchmark;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

@Keep
public class AdView extends RelativeLayout implements C2630Ad {
    private final AdViewApi mAdViewApi;
    private final AdViewParentApi mAdViewParentApi = new AdViewParentApi() {
        @Benchmark
        public void onConfigurationChanged(Configuration configuration) {
            AdView.super.onConfigurationChanged(configuration);
        }
    };

    @Keep
    public interface AdViewLoadConfig extends C2630Ad.LoadAdConfig {
    }

    @Keep
    public interface AdViewLoadConfigBuilder extends C2630Ad.LoadConfigBuilder {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        AdViewLoadConfig build();

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        AdViewLoadConfigBuilder withAdListener(AdListener adListener);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        AdViewLoadConfigBuilder withBid(String str);
    }

    @Benchmark
    public AdView(Context context, String str, AdSize adSize) {
        super(context);
        this.mAdViewApi = DynamicLoaderFactory.makeLoader(context).createAdViewApi(context, str, adSize, this.mAdViewParentApi, this);
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public AdViewLoadConfigBuilder buildLoadAdConfig() {
        return this.mAdViewApi.buildLoadAdConfig();
    }

    public void destroy() {
        this.mAdViewApi.destroy();
    }

    @Deprecated
    public void disableAutoRefresh() {
    }

    public String getPlacementId() {
        return this.mAdViewApi.getPlacementId();
    }

    public boolean isAdInvalidated() {
        return this.mAdViewApi.isAdInvalidated();
    }

    @Benchmark
    public void loadAd() {
        this.mAdViewApi.loadAd();
    }

    @Deprecated
    public void loadAdFromBid(String str) {
        this.mAdViewApi.loadAdFromBid(str);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        this.mAdViewApi.onConfigurationChanged(configuration);
    }

    @Deprecated
    @Benchmark
    public void setAdListener(AdListener adListener) {
        this.mAdViewApi.setAdListener(adListener);
    }

    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mAdViewApi.setExtraHints(extraHints);
    }

    @Benchmark
    public void loadAd(AdViewLoadConfig adViewLoadConfig) {
        this.mAdViewApi.loadAd(adViewLoadConfig);
    }

    @Benchmark
    public AdView(Context context, String str, String str2) throws Exception {
        super(context);
        this.mAdViewApi = DynamicLoaderFactory.makeLoader(context).createAdViewApi(context, str, str2, this.mAdViewParentApi, this);
    }
}
