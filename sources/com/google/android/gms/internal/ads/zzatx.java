package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzatx extends zzatq {
    private final RewardedAdLoadCallback zzdrl;

    public zzatx(RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzdrl = rewardedAdLoadCallback;
    }

    public final void onRewardedAdFailedToLoad(int i) {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zzdrl;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdFailedToLoad(i);
        }
    }

    public final void onRewardedAdLoaded() {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zzdrl;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdLoaded();
        }
    }
}
