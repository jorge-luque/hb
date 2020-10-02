package admost.sdk.dfp;

import admost.sdk.listener.AdMostAdListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener;

public class AmrDfpCustomIntEventForwarder implements AdMostAdListener {
    private CustomEventInterstitialListener mInterstitialListener;

    public AmrDfpCustomIntEventForwarder(CustomEventInterstitialListener customEventInterstitialListener) {
        this.mInterstitialListener = customEventInterstitialListener;
    }

    public void onClicked(String str) {
        this.mInterstitialListener.onAdClicked();
    }

    public void onComplete(String str) {
    }

    public void onDismiss(String str) {
        this.mInterstitialListener.onAdClosed();
    }

    public void onFail(int i) {
        this.mInterstitialListener.onAdFailedToLoad(3);
    }

    public void onReady(String str, int i) {
        this.mInterstitialListener.onAdLoaded();
    }

    public void onShown(String str) {
        this.mInterstitialListener.onAdOpened();
    }

    public void onStatusChanged(int i) {
    }
}
