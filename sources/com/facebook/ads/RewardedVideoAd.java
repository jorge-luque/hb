package com.facebook.ads;

import android.content.Context;
import androidx.annotation.Keep;
import com.facebook.ads.C2630Ad;
import com.facebook.ads.FullScreenAd;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import com.facebook.ads.internal.bench.Benchmark;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

@Keep
public class RewardedVideoAd implements FullScreenAd {
    public static final int UNSET_VIDEO_DURATION = -1;
    private final RewardedVideoAdApi mRewardedVideoAdApi;

    @Keep
    public interface RewardedVideoAdLoadConfigBuilder extends C2630Ad.LoadConfigBuilder {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoLoadAdConfig build();

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withAdExperience(AdExperienceType adExperienceType);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withAdListener(RewardedVideoAdListener rewardedVideoAdListener);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withBid(String str);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withFailOnCacheFailureEnabled(boolean z);

        @Deprecated
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withRVChainEnabled(boolean z);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withRewardData(RewardData rewardData);
    }

    @Keep
    public interface RewardedVideoAdShowConfigBuilder extends FullScreenAd.ShowConfigBuilder {
        RewardedVideoShowAdConfig build();

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdShowConfigBuilder withAppOrientation(int i);
    }

    @Keep
    public interface RewardedVideoLoadAdConfig extends C2630Ad.LoadAdConfig {
    }

    @Keep
    public interface RewardedVideoShowAdConfig extends FullScreenAd.ShowAdConfig {
    }

    @Benchmark
    public RewardedVideoAd(Context context, String str) {
        this.mRewardedVideoAdApi = DynamicLoaderFactory.makeLoader(context).createRewardedVideoAd(context, str, this);
    }

    public void destroy() {
        this.mRewardedVideoAdApi.destroy();
    }

    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public void enableRVChain(boolean z) {
    }

    public String getPlacementId() {
        return this.mRewardedVideoAdApi.getPlacementId();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public int getVideoDuration() {
        return this.mRewardedVideoAdApi.getVideoDuration();
    }

    public boolean isAdInvalidated() {
        return this.mRewardedVideoAdApi.isAdInvalidated();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public boolean isAdLoaded() {
        return this.mRewardedVideoAdApi.isAdLoaded();
    }

    public void loadAd() {
        this.mRewardedVideoAdApi.loadAd();
    }

    @Deprecated
    public void loadAdFromBid(String str) {
        this.mRewardedVideoAdApi.loadAdFromBid(str);
    }

    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public void setAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.mRewardedVideoAdApi.setAdListener(rewardedVideoAdListener);
    }

    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mRewardedVideoAdApi.setExtraHints(extraHints);
    }

    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public void setRewardData(RewardData rewardData) {
        this.mRewardedVideoAdApi.setRewardData(rewardData);
    }

    public boolean show() {
        return this.mRewardedVideoAdApi.show();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public RewardedVideoAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mRewardedVideoAdApi.buildLoadAdConfig();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public RewardedVideoAdShowConfigBuilder buildShowAdConfig() {
        return this.mRewardedVideoAdApi.buildShowAdConfig();
    }

    @Benchmark
    public void loadAd(RewardedVideoLoadAdConfig rewardedVideoLoadAdConfig) {
        this.mRewardedVideoAdApi.loadAd(rewardedVideoLoadAdConfig);
    }

    @Deprecated
    @Benchmark
    public void loadAdFromBid(String str, boolean z) {
        this.mRewardedVideoAdApi.loadAdFromBid(str, z);
    }

    @Benchmark
    public boolean show(RewardedVideoShowAdConfig rewardedVideoShowAdConfig) {
        return this.mRewardedVideoAdApi.show(rewardedVideoShowAdConfig);
    }

    @Deprecated
    @Benchmark
    public void loadAd(boolean z) {
        this.mRewardedVideoAdApi.loadAd(z);
    }

    @Deprecated
    @Benchmark
    public boolean show(int i) {
        return this.mRewardedVideoAdApi.show(i);
    }
}
