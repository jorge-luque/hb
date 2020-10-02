package com.qumpara.offerwall.sdk.listener;

import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;

public interface QumparaResponseListener<T> {
    void onError(QumparaOfferwallModels.QumparaOfferwallError qumparaOfferwallError);

    void onResponse(T t);
}
