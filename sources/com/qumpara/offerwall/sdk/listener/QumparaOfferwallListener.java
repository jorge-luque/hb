package com.qumpara.offerwall.sdk.listener;

public interface QumparaOfferwallListener {
    void onClicked();

    void onDismiss();

    void onEngageClicked(String str);

    void onEngageFail(String str, int i, String str2);

    void onEngageSuccess(String str, String str2);

    void onFail(int i, String str);

    void onReady();

    void onRedeemClicked(String str);

    void onRedeemFail(String str, int i, String str2);

    void onRedeemSuccess(String str);

    void onShown();
}
