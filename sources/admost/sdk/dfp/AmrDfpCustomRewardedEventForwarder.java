package admost.sdk.dfp;

import admost.sdk.listener.AdMostAdListener;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;

public class AmrDfpCustomRewardedEventForwarder implements AdMostAdListener {
    private MediationRewardedAdCallback mCallback;
    private MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mInterstitialListener;
    private AmrDfpCustomEventRewarded mRewarded;

    public AmrDfpCustomRewardedEventForwarder(MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback, AmrDfpCustomEventRewarded amrDfpCustomEventRewarded) {
        this.mInterstitialListener = mediationAdLoadCallback;
        this.mRewarded = amrDfpCustomEventRewarded;
    }

    public void onClicked(String str) {
    }

    public void onComplete(String str) {
        try {
            this.mCallback.onVideoComplete();
            this.mCallback.onUserEarnedReward(new RewardItem() {
                public int getAmount() {
                    return 1;
                }

                public String getType() {
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDismiss(String str) {
        try {
            this.mCallback.onAdClosed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onFail(int i) {
        if (i == 9991000) {
            try {
                this.mCallback.onAdFailedToShow("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.mInterstitialListener.onFailure("No fill.");
        }
    }

    public void onReady(String str, int i) {
        this.mCallback = this.mInterstitialListener.onSuccess(this.mRewarded);
    }

    public void onShown(String str) {
        try {
            this.mCallback.onAdOpened();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onStatusChanged(int i) {
    }
}
