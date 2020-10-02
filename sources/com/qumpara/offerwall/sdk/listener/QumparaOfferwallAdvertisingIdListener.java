package com.qumpara.offerwall.sdk.listener;

public interface QumparaOfferwallAdvertisingIdListener {
    void fail(Exception exc, String str);

    void success(String str);
}
