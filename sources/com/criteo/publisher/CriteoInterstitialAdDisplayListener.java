package com.criteo.publisher;

public interface CriteoInterstitialAdDisplayListener {
    void onAdFailedToDisplay(CriteoErrorCode criteoErrorCode);

    void onAdReadyToDisplay();
}
