package p118io.presage.interstitial.optinvideo;

import p118io.presage.common.network.models.RewardItem;
import p118io.presage.interstitial.PresageInterstitialCallback;

/* renamed from: io.presage.interstitial.optinvideo.PresageOptinVideoCallback */
public interface PresageOptinVideoCallback extends PresageInterstitialCallback {
    void onAdRewarded(RewardItem rewardItem);
}
