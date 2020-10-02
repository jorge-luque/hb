package com.vungle.warren.analytics;

public interface AnalyticsVideoTracker {
    void onProgress(int i);

    void setPlayerVolume(boolean z);

    void start(int i);

    void stop();
}
