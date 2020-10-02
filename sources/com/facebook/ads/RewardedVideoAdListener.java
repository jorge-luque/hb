package com.facebook.ads;

import androidx.annotation.Keep;

@Keep
public interface RewardedVideoAdListener extends AdListener {
    void onLoggingImpression(C2630Ad ad);

    void onRewardedVideoClosed();

    void onRewardedVideoCompleted();
}
