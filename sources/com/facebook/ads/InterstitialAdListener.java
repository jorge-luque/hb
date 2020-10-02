package com.facebook.ads;

import androidx.annotation.Keep;

@Keep
public interface InterstitialAdListener extends AdListener {
    void onInterstitialDismissed(C2630Ad ad);

    void onInterstitialDisplayed(C2630Ad ad);
}
