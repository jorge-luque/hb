package com.chartboost.sdk.Events;

public class ChartboostCacheError extends C2070b {
    public final int code;

    public ChartboostCacheError(int i) {
        super(1);
        this.code = i;
    }

    public String toString() {
        int i = this.code;
        if (i == 0) {
            return "INTERNAL";
        }
        if (i == 1) {
            return "INTERNET_UNAVAILABLE";
        }
        if (i == 16) {
            return "ASSET_DOWNLOAD_FAILURE";
        }
        if (i == 36) {
            return "BANNER_DISABLED";
        }
        if (i == 5) {
            return "NETWORK_FAILURE";
        }
        if (i != 6) {
            return i != 7 ? "UNKNOWN" : "SESSION_NOT_STARTED";
        }
        return "NO_AD_FOUND";
    }
}
