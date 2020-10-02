package com.facebook.ads;

import androidx.annotation.Keep;

@Keep
public abstract class AbstractAdListener implements AdListener, InterstitialAdListener {
    public void onAdClicked(C2630Ad ad) {
    }

    public void onAdLoaded(C2630Ad ad) {
    }

    public void onError(C2630Ad ad, AdError adError) {
    }

    public void onInterstitialDismissed(C2630Ad ad) {
    }

    public void onInterstitialDisplayed(C2630Ad ad) {
    }

    public void onLoggingImpression(C2630Ad ad) {
    }
}
