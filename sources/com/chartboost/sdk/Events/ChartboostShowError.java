package com.chartboost.sdk.Events;

public class ChartboostShowError extends C2070b {
    public final int code;
    public boolean shouldRetry;

    public ChartboostShowError(int i, boolean z) {
        super(2);
        this.code = i;
        this.shouldRetry = z;
    }

    public String toString() {
        int i = this.code;
        if (i == 0) {
            return "INTERNAL";
        }
        if (i == 25) {
            return "INTERNET_UNAVAILABLE";
        }
        if (i == 36) {
            return "BANNER_DISABLED";
        }
        if (i == 7) {
            return "SESSION_NOT_STARTED";
        }
        if (i == 8) {
            return "AD_ALREADY_VISIBLE";
        }
        if (i != 33) {
            return i != 34 ? "UNKNOWN" : "NO_CACHED_AD";
        }
        return "PRESENTATION_FAILURE";
    }
}
