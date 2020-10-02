package com.google.ads.mediation;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* renamed from: com.google.ads.mediation.b */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class C2938b implements RewardedVideoAdListener {

    /* renamed from: a */
    private final /* synthetic */ AbstractAdViewAdapter f8206a;

    C2938b(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.f8206a = abstractAdViewAdapter;
    }

    public final void onRewarded(RewardItem rewardItem) {
        this.f8206a.zzmb.onRewarded(this.f8206a, rewardItem);
    }

    public final void onRewardedVideoAdClosed() {
        this.f8206a.zzmb.onAdClosed(this.f8206a);
        InterstitialAd unused = this.f8206a.zzma = null;
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        this.f8206a.zzmb.onAdFailedToLoad(this.f8206a, i);
    }

    public final void onRewardedVideoAdLeftApplication() {
        this.f8206a.zzmb.onAdLeftApplication(this.f8206a);
    }

    public final void onRewardedVideoAdLoaded() {
        this.f8206a.zzmb.onAdLoaded(this.f8206a);
    }

    public final void onRewardedVideoAdOpened() {
        this.f8206a.zzmb.onAdOpened(this.f8206a);
    }

    public final void onRewardedVideoCompleted() {
        this.f8206a.zzmb.onVideoCompleted(this.f8206a);
    }

    public final void onRewardedVideoStarted() {
        this.f8206a.zzmb.onVideoStarted(this.f8206a);
    }
}
