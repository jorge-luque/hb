package com.chartboost.sdk.Events;

public class ChartboostClickError extends C2070b {
    public final int code;

    public ChartboostClickError(int i) {
        super(0);
        this.code = i;
    }

    public String toString() {
        int i = this.code;
        if (i == 0) {
            return "URI_INVALID";
        }
        if (i != 1) {
            return i != 3 ? "UNKNOWN" : "INTERNAL";
        }
        return "URI_UNRECOGNIZED";
    }
}
