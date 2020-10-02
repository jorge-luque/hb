package com.qumpara.analytics;

import com.qumpara.analytics.model.QumparaAnalyticsError;

public interface QumparaAnalyticsResponseListener<T> {
    void onError(QumparaAnalyticsError qumparaAnalyticsError);

    void onResponse(T t);
}
