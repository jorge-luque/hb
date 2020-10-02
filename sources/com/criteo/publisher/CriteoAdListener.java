package com.criteo.publisher;

public interface CriteoAdListener {
    void onAdClicked();

    void onAdClosed();

    void onAdFailedToReceive(CriteoErrorCode criteoErrorCode);

    void onAdLeftApplication();

    void onAdOpened();
}
