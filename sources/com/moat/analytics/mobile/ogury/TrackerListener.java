package com.moat.analytics.mobile.ogury;

public interface TrackerListener {
    void onTrackingFailedToStart(String str);

    void onTrackingStarted(String str);

    void onTrackingStopped(String str);
}
