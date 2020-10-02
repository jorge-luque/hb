package com.criteo.publisher.advancednative;

import androidx.annotation.Keep;
import com.criteo.publisher.CriteoErrorCode;

@Keep
public abstract class CriteoNativeAdListener {
    public void onAdClicked() {
    }

    public void onAdClosed() {
    }

    public void onAdFailedToReceive(CriteoErrorCode criteoErrorCode) {
    }

    public void onAdImpression() {
    }

    public void onAdLeftApplication() {
    }

    public abstract void onAdReceived(CriteoNativeAd criteoNativeAd);
}
