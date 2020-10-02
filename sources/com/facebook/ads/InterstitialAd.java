package com.facebook.ads;

import android.content.Context;
import androidx.annotation.Keep;
import com.facebook.ads.C2630Ad;
import com.facebook.ads.FullScreenAd;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.bench.Benchmark;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import java.util.EnumSet;

@Keep
public class InterstitialAd implements FullScreenAd {
    private final InterstitialAdApi mInterstitialAdApi;

    @Keep
    public interface InterstitialAdLoadConfigBuilder extends C2630Ad.LoadConfigBuilder {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialLoadAdConfig build();

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialAdLoadConfigBuilder withAdListener(InterstitialAdListener interstitialAdListener);

        InterstitialAdLoadConfigBuilder withBid(String str);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialAdLoadConfigBuilder withCacheFlags(EnumSet<CacheFlag> enumSet);

        InterstitialAdLoadConfigBuilder withRewardData(RewardData rewardData);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialAdLoadConfigBuilder withRewardedAdListener(RewardedAdListener rewardedAdListener);
    }

    @Keep
    public interface InterstitialAdShowConfigBuilder extends FullScreenAd.ShowConfigBuilder {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialShowAdConfig build();
    }

    @Keep
    public interface InterstitialLoadAdConfig extends C2630Ad.LoadAdConfig {
    }

    @Keep
    public interface InterstitialShowAdConfig extends FullScreenAd.ShowAdConfig {
    }

    @Benchmark
    public InterstitialAd(Context context, String str) {
        this.mInterstitialAdApi = DynamicLoaderFactory.makeLoader(context).createInterstitialAd(context, str, this);
    }

    public void destroy() {
        this.mInterstitialAdApi.destroy();
    }

    public String getPlacementId() {
        return this.mInterstitialAdApi.getPlacementId();
    }

    public boolean isAdInvalidated() {
        return this.mInterstitialAdApi.isAdInvalidated();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public boolean isAdLoaded() {
        return this.mInterstitialAdApi.isAdLoaded();
    }

    public void loadAd() {
        this.mInterstitialAdApi.loadAd();
    }

    @Deprecated
    public void loadAdFromBid(String str) {
        this.mInterstitialAdApi.loadAdFromBid(str);
    }

    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public void setAdListener(InterstitialAdListener interstitialAdListener) {
        this.mInterstitialAdApi.setAdListener(interstitialAdListener);
    }

    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mInterstitialAdApi.setExtraHints(extraHints);
    }

    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public void setRewardedAdListener(RewardedAdListener rewardedAdListener) {
        this.mInterstitialAdApi.setRewardedAdListener(rewardedAdListener);
    }

    @Benchmark
    public boolean show() {
        return this.mInterstitialAdApi.show();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public InterstitialAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mInterstitialAdApi.buildLoadAdConfig();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public InterstitialAdShowConfigBuilder buildShowAdConfig() {
        return this.mInterstitialAdApi.buildShowAdConfig();
    }

    public void loadAd(InterstitialLoadAdConfig interstitialLoadAdConfig) {
        this.mInterstitialAdApi.loadAd(interstitialLoadAdConfig);
    }

    @Deprecated
    @Benchmark
    public void loadAdFromBid(EnumSet<CacheFlag> enumSet, String str) {
        this.mInterstitialAdApi.loadAdFromBid(enumSet, str);
    }

    @Benchmark
    public boolean show(InterstitialShowAdConfig interstitialShowAdConfig) {
        return this.mInterstitialAdApi.show(interstitialShowAdConfig);
    }

    @Deprecated
    @Benchmark
    public void loadAd(EnumSet<CacheFlag> enumSet) {
        this.mInterstitialAdApi.loadAd(enumSet);
    }
}
